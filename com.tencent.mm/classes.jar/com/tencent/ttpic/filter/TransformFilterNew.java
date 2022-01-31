package com.tencent.ttpic.filter;

import android.graphics.PointF;
import android.text.TextUtils;
import com.tencent.filter.m.a;
import com.tencent.filter.m.f;
import com.tencent.ttpic.face.FaceRangeStatus;
import com.tencent.ttpic.model.DistortionItem;
import com.tencent.ttpic.model.FaceActionCounter;
import com.tencent.ttpic.model.FaceMeshItem;
import com.tencent.ttpic.model.HandActionCounter;
import com.tencent.ttpic.model.MeshDistortionType;
import com.tencent.ttpic.model.StickerItem.FeatureStatValueRange;
import com.tencent.ttpic.util.TransformUtil;
import com.tencent.ttpic.util.VideoFileUtil;
import com.tencent.ttpic.util.VideoFilterUtil;
import com.tencent.ttpic.util.VideoFilterUtil.DRAW_MODE;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.ttpic.util.VideoMaterialUtil.DISTORTION_ITEM_FILED;
import com.tencent.ttpic.util.VideoMaterialUtil.FIELD;
import com.tencent.ttpic.util.VideoMaterialUtil.TRIGGER_TYPE;
import com.tencent.ttpic.util.VideoUtil;
import com.tencent.ttpic.util.youtu.VideoPreviewFaceOutlineDetector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TransformFilterNew
  extends VideoFilterBase
{
  public static final String FRAGMENT_SHADER = VideoFileUtil.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/TransformFragmentShader.dat").replace("\\s+", " ");
  private static final int MESH_DISTORTION_TYPE_COUNT = 30;
  private static final String VERTEX_SHADER = VideoFileUtil.loadAssetsString(VideoGlobalContext.getContext(), "camera/camera_video/shader/TransformVertexShader.dat").replace("\\s+", " ");
  private static final int XCOORD_NUM = 50;
  private static final int YCOORD_NUM = 66;
  private String dataPath;
  private float[] flatMesh = new float['ð'];
  private List<DistortionItem> mCurDistortionItemList;
  private FaceMeshItem mFaceMeshItem;
  private long mFrameStartTime;
  private List<PointF> mFullscreenVertices;
  private List<PointF> mInitTextureCoordinates;
  private int mLastMeshIndex = -1;
  private Map<String, List<DistortionItem>> mMeshCache = new HashMap();
  private boolean mMeshCleared = false;
  private boolean mTriggered = false;
  private MeshDistortionType[] meshs = new MeshDistortionType[30];
  
  public TransformFilterNew(FaceMeshItem paramFaceMeshItem, String paramString)
  {
    super(VERTEX_SHADER, FRAGMENT_SHADER);
    this.mFaceMeshItem = paramFaceMeshItem;
    this.dataPath = paramString;
    initCoordinates();
    initParams();
  }
  
  private void clearMesh()
  {
    Arrays.fill(this.flatMesh, 0.0F);
    addParam(new m.a("item", this.flatMesh));
    this.mLastMeshIndex = -1;
    this.mCurDistortionItemList = null;
  }
  
  private List<DistortionItem> getNextFrame(int paramInt)
  {
    String str = this.mFaceMeshItem.id + "_" + paramInt;
    ArrayList localArrayList;
    if (!this.mMeshCache.containsKey(str))
    {
      localArrayList = new ArrayList();
      Object localObject = VideoFileUtil.load(this.dataPath + "/" + this.mFaceMeshItem.id, str + ".json");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        try
        {
          localObject = new JSONObject((String)localObject).optJSONArray(VideoMaterialUtil.FIELD.DISTORTION_LIST.value);
          if (localObject != null)
          {
            paramInt = 0;
            while (paramInt < ((JSONArray)localObject).length())
            {
              DistortionItem localDistortionItem = new DistortionItem();
              JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(paramInt);
              localDistortionItem.position = localJSONObject.optInt(VideoMaterialUtil.DISTORTION_ITEM_FILED.POSITION.value);
              localDistortionItem.distortion = localJSONObject.optInt(VideoMaterialUtil.DISTORTION_ITEM_FILED.DISTORTION.value);
              localDistortionItem.direction = localJSONObject.optInt(VideoMaterialUtil.DISTORTION_ITEM_FILED.DIRECTION.value);
              localDistortionItem.radius = ((float)localJSONObject.optDouble(VideoMaterialUtil.DISTORTION_ITEM_FILED.RADIUS.value));
              localDistortionItem.strength = ((float)localJSONObject.optDouble(VideoMaterialUtil.DISTORTION_ITEM_FILED.STRENGH.value));
              localDistortionItem.x = localJSONObject.optInt(VideoMaterialUtil.DISTORTION_ITEM_FILED.X.value);
              localDistortionItem.y = localJSONObject.optInt(VideoMaterialUtil.DISTORTION_ITEM_FILED.Y.value);
              localArrayList.add(localDistortionItem);
              paramInt += 1;
            }
          }
          this.mMeshCache.put(str, localArrayList);
        }
        catch (JSONException localJSONException) {}
      }
    }
    return (List)this.mMeshCache.get(str);
  }
  
  private void initCoordinates()
  {
    this.mFullscreenVertices = VideoMaterialUtil.genFullScreenVertices(50, 66, -1.0F, 1.0F, -1.0F, 1.0F);
    this.mInitTextureCoordinates = VideoMaterialUtil.genFullScreenVertices(50, 66, 0.0F, 1.0F, 0.0F, 1.0F);
  }
  
  private boolean needClearMaterial()
  {
    return (this.mFaceMeshItem.triggerType != VideoMaterialUtil.TRIGGER_TYPE.ALWAYS.value) && (!this.mTriggered);
  }
  
  private void updateMeshParam(List<PointF> paramList, FaceRangeStatus paramFaceRangeStatus, long paramLong)
  {
    long l = this.mFrameStartTime;
    if (this.mFaceMeshItem.frameType == 0)
    {
      int j = (int)((paramLong - l) / Math.max(this.mFaceMeshItem.frameDuration, 1.0D)) % Math.max(this.mFaceMeshItem.frames, 1);
      i = j;
      if (!this.mMeshCleared)
      {
        i = j;
        if (j == this.mLastMeshIndex) {
          updateMeshParam(this.mCurDistortionItemList, paramList);
        }
      }
    }
    else
    {
      if (this.mFaceMeshItem.frameType != 1) {
        break label212;
      }
    }
    label212:
    for (int i = (int)((VideoFilterUtil.getFaceStatus(paramFaceRangeStatus, this.mFaceMeshItem.featureStatType, this.mFaceMeshItem.featureStatValueRange) - this.mFaceMeshItem.featureStatValueRange.min) / ((this.mFaceMeshItem.featureStatValueRange.max - this.mFaceMeshItem.featureStatValueRange.min) / this.mFaceMeshItem.frames));; i = 0)
    {
      paramFaceRangeStatus = getNextFrame(i);
      if ((paramFaceRangeStatus == null) || (paramFaceRangeStatus.isEmpty()) || (needClearMaterial()))
      {
        clearMesh();
        return;
      }
      updateMeshParam(paramFaceRangeStatus, paramList);
      this.mCurDistortionItemList = paramFaceRangeStatus;
      this.mMeshCleared = false;
      this.mLastMeshIndex = i;
      return;
    }
  }
  
  private void updateMeshParam(List<DistortionItem> paramList, List<PointF> paramList1)
  {
    if ((VideoUtil.isEmpty(paramList)) || (VideoUtil.isEmpty(paramList1))) {
      return;
    }
    paramList1 = TransformUtil.getFullPoints(paramList1);
    float f1 = ((PointF)paramList1.get(18)).x - ((PointF)paramList1.get(0)).x;
    float f4 = ((PointF)paramList1.get(18)).y - ((PointF)paramList1.get(0)).y;
    float f2 = ((PointF)paramList1.get(9)).x - ((PointF)paramList1.get(89)).x;
    float f3 = ((PointF)paramList1.get(9)).y - ((PointF)paramList1.get(89)).y;
    f1 = (float)Math.sqrt(f1 * f1 + f4 * f4);
    f2 = (float)Math.sqrt(f3 * f3 + f2 * f2) / f1;
    f3 = ((PointF)paramList1.get(9)).x;
    f4 = ((PointF)paramList1.get(84)).x;
    float f5 = -((PointF)paramList1.get(9)).y;
    float f6 = ((PointF)paramList1.get(84)).y;
    f3 = (float)(Math.atan2(f3 - f4, f6 + f5) + 3.141592653589793D);
    int j = paramList1.size();
    int i = 0;
    while (i < paramList.size())
    {
      DistortionItem localDistortionItem = (DistortionItem)paramList.get(i);
      this.meshs[i].type = localDistortionItem.distortion;
      this.meshs[i].strength = localDistortionItem.strength;
      if (localDistortionItem.position < j) {
        this.meshs[i].point = ((PointF)paramList1.get(localDistortionItem.position));
      }
      this.meshs[i].radius = ((float)(localDistortionItem.radius * f1 / this.mFaceDetScale / Math.min(this.width, this.height) / 375.0D));
      this.meshs[i].direction = localDistortionItem.direction;
      this.meshs[i].faceDegree = f3;
      this.meshs[i].faceRatio = f2;
      i += 1;
    }
    i = paramList.size();
    while (i < 30)
    {
      this.meshs[i].type = -1;
      i += 1;
    }
    j = 0;
    i = 0;
    while (i < paramList.size())
    {
      paramList1 = this.flatMesh;
      int k = j + 1;
      paramList1[j] = this.meshs[i].type;
      paramList1 = this.flatMesh;
      j = k + 1;
      paramList1[k] = this.meshs[i].strength;
      paramList1 = this.flatMesh;
      k = j + 1;
      paramList1[j] = ((float)(2.0F * this.meshs[i].point.x / this.mFaceDetScale / this.width - 1.0D));
      paramList1 = this.flatMesh;
      j = k + 1;
      paramList1[k] = ((float)(2.0F * this.meshs[i].point.y / this.mFaceDetScale / this.height - 1.0D));
      paramList1 = this.flatMesh;
      k = j + 1;
      paramList1[j] = this.meshs[i].radius;
      paramList1 = this.flatMesh;
      j = k + 1;
      paramList1[k] = this.meshs[i].direction;
      paramList1 = this.flatMesh;
      k = j + 1;
      paramList1[j] = this.meshs[i].faceDegree;
      paramList1 = this.flatMesh;
      j = k + 1;
      paramList1[k] = this.meshs[i].faceRatio;
      i += 1;
    }
    addParam(new m.a("item", this.flatMesh));
  }
  
  public void ApplyGLSLFilter()
  {
    super.ApplyGLSLFilter();
    setPositions(VideoMaterialUtil.toFlatArray((PointF[])this.mFullscreenVertices.toArray(new PointF[0])));
    setTexCords(VideoMaterialUtil.toFlatArray((PointF[])this.mInitTextureCoordinates.toArray(new PointF[0])));
    setDrawMode(VideoFilterUtil.DRAW_MODE.TRIANGLE_STRIP);
    setCoordNum(6651);
  }
  
  public FaceMeshItem getFaceMeshItem()
  {
    return this.mFaceMeshItem;
  }
  
  public void initParams()
  {
    addParam(new m.f("screenRatio", 0.0F));
    addParam(new m.a("item", this.flatMesh));
    int i = 0;
    while (i < 30)
    {
      this.meshs[i] = new MeshDistortionType();
      i += 1;
    }
  }
  
  protected void updateActionTriggered(Set<Integer> paramSet, FaceRangeStatus paramFaceRangeStatus, long paramLong)
  {
    if ((this.mFaceMeshItem != null) && (paramSet.contains(Integer.valueOf(this.mFaceMeshItem.triggerType))) && (VideoFilterUtil.isStatusTriggered(paramFaceRangeStatus, this.mFaceMeshItem.featureStatType, this.mFaceMeshItem.featureStatValueRange)))
    {
      if (!this.mTriggered) {
        this.mFrameStartTime = paramLong;
      }
      this.mTriggered = true;
    }
    while ((this.mFaceMeshItem == null) || (!this.mFaceMeshItem.alwaysTriggered)) {
      return;
    }
    this.mTriggered = false;
  }
  
  public void updatePreview(List<PointF> paramList1, float[] paramArrayOfFloat, Map<Integer, FaceActionCounter> paramMap, List<PointF> paramList2, Map<Integer, HandActionCounter> paramMap1, Set<Integer> paramSet, float paramFloat, long paramLong)
  {
    paramList1 = VideoMaterialUtil.copyList(paramList1);
    paramArrayOfFloat = VideoPreviewFaceOutlineDetector.getInstance().detectFaceRangeStatus(paramList1);
    updateActionTriggered(paramSet, paramArrayOfFloat, paramLong);
    if ((paramList1 == null) || (paramList1.size() < 90) || (needClearMaterial()))
    {
      clearMesh();
      this.mTriggered = false;
      this.mMeshCleared = true;
      return;
    }
    updateMeshParam(paramList1, paramArrayOfFloat, paramLong);
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
    addParam(new m.f("screenRatio", this.height / this.width));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.ttpic.filter.TransformFilterNew
 * JD-Core Version:    0.7.0.1
 */
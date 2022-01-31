package com.tencent.ttpic.filter;

import android.graphics.PointF;
import android.text.TextUtils;
import com.tencent.filter.m.a;
import com.tencent.filter.m.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.PTDetectInfo;
import com.tencent.ttpic.PTDetectInfo.Builder;
import com.tencent.ttpic.baseutils.BaseUtils;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.device.DeviceInstance;
import com.tencent.ttpic.gles.GlUtil.DRAW_MODE;
import com.tencent.ttpic.model.DistortionItem;
import com.tencent.ttpic.model.FaceMeshItem;
import com.tencent.ttpic.model.MeshDistortionType;
import com.tencent.ttpic.model.StickerItem;
import com.tencent.ttpic.model.TRIGGERED_STATUS;
import com.tencent.ttpic.model.TriggerCtrlItem;
import com.tencent.ttpic.shader.ShaderCreateFactory.PROGRAM_TYPE;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.TransformUtil;
import com.tencent.ttpic.util.VideoFilterUtil;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.ttpic.util.VideoMaterialUtil.DISTORTION_ITEM_FILED;
import com.tencent.ttpic.util.VideoMaterialUtil.FIELD;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TransformFilter
  extends VideoFilterBase
{
  private static final List<DistortionItem> EMPTY;
  private static final int MESH_DISTORTION_TYPE_COUNT = 30;
  private static final int XCOORD_NUM = 50;
  private static final int YCOORD_NUM = 66;
  private static List<PointF> mFullscreenVerticesPortrait;
  private static List<PointF> mInitTextureCoordinatesPortrait;
  float anotherStrength;
  private String dataPath;
  private float faceHeight;
  private float faceWidth;
  private float[] flatMesh;
  private List<DistortionItem> items;
  private FaceMeshItem mFaceMeshItem;
  private int mLastMeshIndex;
  private Map<String, List<DistortionItem>> mMeshCache;
  private MeshDistortionType[] meshs;
  private boolean optimizeBoundary;
  private float optimizeBoundaryStrength;
  private float screenRatioX;
  private float screenRatioY;
  private List<StickerItem> stickerItems;
  private TriggerCtrlItem triggerCtrlItem;
  
  static
  {
    AppMethodBeat.i(83037);
    EMPTY = new ArrayList();
    mFullscreenVerticesPortrait = VideoMaterialUtil.genFullScreenVertices(50, 66, -1.0F, 1.0F, -1.0F, 1.0F);
    mInitTextureCoordinatesPortrait = VideoMaterialUtil.genFullScreenVertices(50, 66, 0.0F, 1.0F, 0.0F, 1.0F);
    AppMethodBeat.o(83037);
  }
  
  public TransformFilter(FaceMeshItem paramFaceMeshItem, String paramString)
  {
    super(ShaderCreateFactory.PROGRAM_TYPE.TRANSFORM);
    AppMethodBeat.i(83022);
    this.meshs = new MeshDistortionType[30];
    this.flatMesh = new float['Ò'];
    this.mLastMeshIndex = -1;
    this.mMeshCache = new HashMap();
    this.optimizeBoundary = true;
    this.optimizeBoundaryStrength = 0.25F;
    this.screenRatioX = 1.0F;
    this.screenRatioY = 1.0F;
    this.anotherStrength = 1.0F;
    this.mFaceMeshItem = paramFaceMeshItem;
    this.dataPath = paramString;
    this.items = EMPTY;
    this.triggerCtrlItem = new TriggerCtrlItem(this.mFaceMeshItem);
    initParams();
    AppMethodBeat.o(83022);
  }
  
  public TransformFilter(List<DistortionItem> paramList, List<StickerItem> paramList1)
  {
    super(ShaderCreateFactory.PROGRAM_TYPE.TRANSFORM);
    AppMethodBeat.i(83021);
    this.meshs = new MeshDistortionType[30];
    this.flatMesh = new float['Ò'];
    this.mLastMeshIndex = -1;
    this.mMeshCache = new HashMap();
    this.optimizeBoundary = true;
    this.optimizeBoundaryStrength = 0.25F;
    this.screenRatioX = 1.0F;
    this.screenRatioY = 1.0F;
    this.anotherStrength = 1.0F;
    this.items = paramList;
    this.stickerItems = paramList1;
    this.triggerCtrlItem = new TriggerCtrlItem();
    initParams();
    AppMethodBeat.o(83021);
  }
  
  private List<DistortionItem> getNextFrame(int paramInt)
  {
    AppMethodBeat.i(83028);
    Object localObject1 = this.mFaceMeshItem.id + "_" + paramInt;
    ArrayList localArrayList;
    if (!this.mMeshCache.containsKey(localObject1))
    {
      localArrayList = new ArrayList();
      Object localObject2 = FileUtils.load(VideoGlobalContext.getContext(), this.dataPath + "/" + this.mFaceMeshItem.id, (String)localObject1 + ".json");
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        try
        {
          localObject2 = new JSONObject((String)localObject2).optJSONArray(VideoMaterialUtil.FIELD.DISTORTION_LIST.value);
          if (localObject2 != null)
          {
            paramInt = 0;
            while (paramInt < ((JSONArray)localObject2).length())
            {
              DistortionItem localDistortionItem = new DistortionItem();
              JSONObject localJSONObject = ((JSONArray)localObject2).getJSONObject(paramInt);
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
          this.mMeshCache.put(localObject1, localArrayList);
        }
        catch (JSONException localJSONException) {}
      }
    }
    localObject1 = (List)this.mMeshCache.get(localObject1);
    AppMethodBeat.o(83028);
    return localObject1;
  }
  
  private float getStrengthAdjust(int paramInt)
  {
    AppMethodBeat.i(83031);
    if ("OPPO_X909".equals(DeviceInstance.getInstance().getDeviceName())) {}
    for (float f1 = 0.2F;; f1 = 1.0F)
    {
      float f2 = f1;
      if (this.optimizeBoundary)
      {
        f2 = f1;
        if (this.faceWidth > 0.0F)
        {
          f2 = f1;
          if (this.width > 0)
          {
            f2 = f1;
            if (this.mFaceDetScale > 0.0D)
            {
              float f4 = this.faceWidth;
              float f5 = this.optimizeBoundaryStrength;
              f2 = this.width * (float)this.mFaceDetScale;
              float f3 = this.height * (float)this.mFaceDetScale;
              float f6 = Math.min(f2, f3);
              f4 = Math.min(0.15F * f6, Math.min(f4 * f5, f6 * this.meshs[paramInt].radius));
              f2 = f1 * (Math.min(Math.min(Math.min(1.0F, Math.max(0.0F, (this.meshs[paramInt].point.x + this.meshs[paramInt].offsetX) / f4)), Math.min(1.0F, Math.max(0.0F, (f2 - this.meshs[paramInt].point.x - this.meshs[paramInt].offsetX) / f4))), Math.min(Math.min(1.0F, Math.max(0.0F, (this.meshs[paramInt].point.y + this.meshs[paramInt].offsetY) / f4)), Math.min(1.0F, Math.max(0.0F, (f3 - this.meshs[paramInt].point.y - this.meshs[paramInt].offsetY) / f4)))) * 0.9F + 0.1F);
            }
          }
        }
      }
      AppMethodBeat.o(83031);
      return f2;
    }
  }
  
  private TRIGGERED_STATUS updateActionTriggered(Set<Integer> paramSet, long paramLong)
  {
    AppMethodBeat.i(83026);
    paramSet = new PTDetectInfo.Builder().triggeredExpression(paramSet).timestamp(paramLong).build();
    paramSet = this.triggerCtrlItem.getTriggeredStatus(paramSet);
    AppMethodBeat.o(83026);
    return paramSet;
  }
  
  private void updateMeshParam()
  {
    AppMethodBeat.i(83027);
    int i = this.triggerCtrlItem.getFrameIndex();
    if (i == this.mLastMeshIndex)
    {
      AppMethodBeat.o(83027);
      return;
    }
    this.items = getNextFrame(i);
    this.mLastMeshIndex = i;
    AppMethodBeat.o(83027);
  }
  
  public void ApplyGLSLFilter()
  {
    AppMethodBeat.i(83033);
    super.ApplyGLSLFilter();
    setDrawMode(GlUtil.DRAW_MODE.TRIANGLE_STRIP);
    AppMethodBeat.o(83033);
  }
  
  public FaceMeshItem getFaceMeshItem()
  {
    return this.mFaceMeshItem;
  }
  
  public void initAttribParams()
  {
    AppMethodBeat.i(83023);
    setPositions(VideoMaterialUtil.toFlatArray((PointF[])mFullscreenVerticesPortrait.toArray(new PointF[0])), false);
    setTexCords(VideoMaterialUtil.toFlatArray((PointF[])mInitTextureCoordinatesPortrait.toArray(new PointF[0])), false);
    setCoordNum(6651);
    AppMethodBeat.o(83023);
  }
  
  public void initParams()
  {
    AppMethodBeat.i(83024);
    addParam(new m.f("screenRatioX", 0.0F));
    addParam(new m.f("screenRatioY", 0.0F));
    addParam(new m.a("item", this.flatMesh));
    addParam(new m.f("faceRatio", 1.0F));
    addParam(new m.f("sin_roll", 0.0F));
    addParam(new m.f("cos_roll", 0.0F));
    addParam(new m.f("tan_yaw", 0.0F));
    addParam(new m.f("cos_yaw", 0.0F));
    addParam(new m.f("tan_pitch", 0.0F));
    addParam(new m.f("cos_pitch", 0.0F));
    int i = 0;
    while (i < 30)
    {
      this.meshs[i] = new MeshDistortionType();
      i += 1;
    }
    AppMethodBeat.o(83024);
  }
  
  public void reset()
  {
    AppMethodBeat.i(83034);
    this.triggerCtrlItem.reset();
    AppMethodBeat.o(83034);
  }
  
  public void setDistortionItems(List<DistortionItem> paramList)
  {
    this.items = paramList;
  }
  
  public void setOptimizeBoundary(boolean paramBoolean)
  {
    this.optimizeBoundary = paramBoolean;
  }
  
  public void setRenderForBitmap(boolean paramBoolean)
  {
    AppMethodBeat.i(83035);
    this.triggerCtrlItem.setRenderForBitmap(paramBoolean);
    AppMethodBeat.o(83035);
  }
  
  public void setTriggerWords(String paramString)
  {
    AppMethodBeat.i(83036);
    this.triggerCtrlItem.setTriggerWords(paramString);
    AppMethodBeat.o(83036);
  }
  
  public void updateFaceFeatures(List<PointF> paramList)
  {
    AppMethodBeat.i(83030);
    if ((paramList == null) || (paramList.size() < 131))
    {
      AppMethodBeat.o(83030);
      return;
    }
    float f1 = ((PointF)paramList.get(18)).x - ((PointF)paramList.get(0)).x;
    float f2 = ((PointF)paramList.get(18)).y - ((PointF)paramList.get(0)).y;
    float f3 = ((PointF)paramList.get(9)).x - ((PointF)paramList.get(89)).x;
    float f4 = ((PointF)paramList.get(9)).y - ((PointF)paramList.get(89)).y;
    this.faceWidth = ((float)Math.sqrt(f1 * f1 + f2 * f2));
    this.faceHeight = ((float)Math.sqrt(f4 * f4 + f3 * f3));
    f1 = this.faceHeight / this.faceWidth;
    f2 = ((PointF)paramList.get(9)).x;
    f3 = ((PointF)paramList.get(84)).x;
    f4 = -((PointF)paramList.get(9)).y;
    float f5 = ((PointF)paramList.get(84)).y;
    f2 = (float)(Math.atan2(f2 - f3, f5 + f4) + 3.141592653589793D);
    f3 = this.height / this.width;
    f4 = (float)(2.0D / (this.width * this.mFaceDetScale));
    f5 = (float)(2.0D / (this.height * this.mFaceDetScale));
    PointF localPointF1 = new PointF();
    PointF localPointF2 = new PointF();
    PointF localPointF3 = new PointF();
    int i = 0;
    while (i < 131)
    {
      if ((i < 99) || (i > 106))
      {
        localPointF1.x = (((PointF)paramList.get(i)).x * f4 - 1.0F);
        localPointF1.y = (((PointF)paramList.get(i)).y * f5 - 1.0F);
        int j = 0;
        if (j < this.meshs.length)
        {
          float f8;
          float f7;
          if (this.meshs[j].type > 0)
          {
            localPointF2.x = ((this.meshs[j].point.x + this.meshs[j].offsetX) * f4 - 1.0F);
            localPointF2.y = (((this.meshs[j].point.y + this.meshs[j].offsetY) * f5 - 1.0F) * f3);
            localPointF3.x = localPointF1.x;
            localPointF1.y *= f3;
            f6 = AlgoUtils.getDistance(localPointF2, localPointF3);
            if (f6 < this.meshs[j].radius)
            {
              f8 = f6 / this.meshs[j].radius;
              f6 = localPointF2.x - localPointF3.x;
              f7 = (localPointF2.y - localPointF3.y) / f3;
              if (this.meshs[j].type != 1) {
                break label715;
              }
              f8 = (float)(1.5D * (1.0D - Math.sin(f8 * 3.1415D * 0.5D)) * this.meshs[j].strength);
              localPointF1.x -= f6 * f8;
              localPointF1.y -= f8 * f7;
            }
          }
          label715:
          do
          {
            for (;;)
            {
              j += 1;
              break;
              if (this.meshs[j].type != 2) {
                break label789;
              }
              f8 = (float)(Math.cos(1.57075D * f8) * this.meshs[j].strength);
              localPointF1.x = (f6 * f8 + localPointF1.x);
              localPointF1.y = (f8 * f7 + localPointF1.y);
            }
          } while (this.meshs[j].type != 3);
          label789:
          float f6 = (float)(Math.cos(f8 * 1.57075D) * this.meshs[j].radius * 0.5D / f1 * this.meshs[j].strength);
          PointF localPointF4 = new PointF(f1, f1 / f3);
          if (this.meshs[j].direction == 1.0F)
          {
            f7 = localPointF4.x;
            localPointF4.x = (-f6 * f7);
            localPointF4.y = 0.0F;
          }
          for (;;)
          {
            localPointF1.x = ((float)(localPointF1.x + (localPointF4.x * Math.cos(f2) - localPointF4.y * Math.sin(f2))));
            double d1 = localPointF1.y;
            double d2 = localPointF4.y;
            double d3 = Math.cos(f2);
            localPointF1.y = ((float)((localPointF4.x * Math.sin(f2) + d2 * d3) / f3 + d1));
            break;
            if (this.meshs[j].direction == 2.0F)
            {
              localPointF4.x = 0.0F;
              f7 = localPointF4.y;
              localPointF4.y = (-f6 * f7);
            }
            else if (this.meshs[j].direction == 3.0F)
            {
              localPointF4.x = (f6 * localPointF4.x);
              localPointF4.y = 0.0F;
            }
            else if (this.meshs[j].direction == 4.0F)
            {
              localPointF4.x = 0.0F;
              localPointF4.y = (f6 * localPointF4.y);
            }
            else if (this.meshs[j].direction == 5.0F)
            {
              localPointF4.x *= -f6;
              f7 = localPointF4.y;
              localPointF4.y = (-f6 * f7);
            }
            else if (this.meshs[j].direction == 6.0F)
            {
              localPointF4.x *= f6;
              f7 = localPointF4.y;
              localPointF4.y = (-f6 * f7);
            }
            else if (this.meshs[j].direction == 7.0F)
            {
              localPointF4.x *= -f6;
              localPointF4.y = (f6 * localPointF4.y);
            }
            else if (this.meshs[j].direction == 8.0F)
            {
              localPointF4.x *= f6;
              localPointF4.y = (f6 * localPointF4.y);
            }
            else
            {
              localPointF4.x = 0.0F;
              localPointF4.y = 0.0F;
            }
          }
        }
        ((PointF)paramList.get(i)).x = ((localPointF1.x + 1.0F) / f4);
        ((PointF)paramList.get(i)).y = ((localPointF1.y + 1.0F) / f5);
      }
      i += 1;
    }
    AppMethodBeat.o(83030);
  }
  
  public void updateParams(List<PointF> paramList, Set<Integer> paramSet, double paramDouble, float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(83029);
    Object localObject = VideoMaterialUtil.copyList(paramList);
    Arrays.fill(this.flatMesh, -1.0F);
    if ((localObject == null) || (((List)localObject).size() < 90) || (BaseUtils.isEmpty(this.items)) || (!VideoFilterUtil.actionTriggered(paramList, this.stickerItems, paramSet))) {
      addParam(new m.f("faceRatio", 1.0F));
    }
    for (;;)
    {
      addParam(new m.a("item", this.flatMesh));
      AppMethodBeat.o(83029);
      return;
      List localList = TransformUtil.getFullPoints((List)localObject);
      float f1 = ((PointF)localList.get(18)).x - ((PointF)localList.get(0)).x;
      float f2 = ((PointF)localList.get(18)).y - ((PointF)localList.get(0)).y;
      float f3 = ((PointF)localList.get(9)).x - ((PointF)localList.get(89)).x;
      float f4 = ((PointF)localList.get(9)).y - ((PointF)localList.get(89)).y;
      this.faceWidth = ((float)Math.sqrt(f1 * f1 + f2 * f2));
      this.faceHeight = ((float)Math.sqrt(f4 * f4 + f3 * f3));
      f3 = this.faceHeight / this.faceWidth;
      f1 = ((PointF)localList.get(9)).x;
      f2 = ((PointF)localList.get(84)).x;
      f4 = -((PointF)localList.get(9)).y;
      float f5 = ((PointF)localList.get(84)).y;
      f4 = (float)(Math.atan2(f1 - f2, f5 + f4) + 3.141592653589793D);
      paramList = new PointF((float)(((PointF)localList.get(9)).x * 2.0F / paramDouble / this.width - 1.0D), (float)(((PointF)localList.get(9)).y * 2.0F / paramDouble / this.height - 1.0D) * this.height / this.width);
      paramSet = new PointF((float)(((PointF)localList.get(89)).x * 2.0F / paramDouble / this.width - 1.0D), (float)(((PointF)localList.get(89)).y * 2.0F / paramDouble / this.height - 1.0D) * this.height / this.width);
      f5 = AlgoUtils.getDistance(paramList, paramSet);
      float f6 = (float)Math.min(0.8353981633974483D, Math.max(-0.8353981633974483D, paramArrayOfFloat[1] * 1.5D));
      float f7 = (float)Math.tan(f6);
      f1 = (float)Math.cos(f6);
      f2 = ((PointF)localList.get(43)).x;
      float f8 = (((PointF)localList.get(9)).x - ((PointF)localList.get(43)).x) / 3.0F;
      float f9 = ((PointF)localList.get(43)).y;
      localObject = new PointF(f2 + f8, (((PointF)localList.get(9)).y - ((PointF)localList.get(43)).y) / 3.0F + f9);
      ((PointF)localObject).x = ((float)(2.0F * ((PointF)localObject).x / paramDouble / this.width - 1.0D));
      ((PointF)localObject).y = ((float)(2.0F * ((PointF)localObject).y / paramDouble / this.height - 1.0D) * this.height / this.width);
      f2 = ((PointF)localList.get(53)).x;
      f8 = (((PointF)localList.get(9)).x - ((PointF)localList.get(53)).x) / 3.0F;
      f9 = ((PointF)localList.get(53)).y;
      PointF localPointF1 = new PointF(f2 + f8, (((PointF)localList.get(9)).y - ((PointF)localList.get(53)).y) / 3.0F + f9);
      localPointF1.x = ((float)(2.0F * localPointF1.x / paramDouble / this.width - 1.0D));
      localPointF1.y = ((float)(2.0F * localPointF1.y / paramDouble / this.height - 1.0D) * this.height / this.width);
      f8 = AlgoUtils.getDistance((PointF)localObject, localPointF1);
      f9 = (float)Math.min(0.8353981633974483D, Math.max(-0.8353981633974483D, paramArrayOfFloat[0] * 1.4D));
      Math.tan(f9);
      f2 = (float)Math.cos(f9);
      float f10 = (float)Math.cos(f4);
      float f11 = (float)Math.sin(f4);
      int j = localList.size();
      int i = 0;
      while (i < this.items.size())
      {
        paramArrayOfFloat = (DistortionItem)this.items.get(i);
        this.meshs[i].type = paramArrayOfFloat.distortion;
        if (paramArrayOfFloat.position < j) {
          this.meshs[i].point = ((PointF)localList.get(paramArrayOfFloat.position));
        }
        float f12 = getStrengthAdjust(i);
        this.meshs[i].strength = (f12 * paramArrayOfFloat.strength);
        this.meshs[i].radius = ((float)(paramArrayOfFloat.radius * this.faceWidth / paramDouble / Math.min(this.width, this.height) / 375.0D));
        f12 = paramArrayOfFloat.x * f1;
        float f13 = paramArrayOfFloat.y * f2;
        this.meshs[i].offsetX = ((f12 * f10 + f13 * f11) * this.faceWidth / 375.0F);
        this.meshs[i].offsetY = ((f12 * f11 - f13 * f10) * this.faceWidth / 375.0F);
        this.meshs[i].direction = paramArrayOfFloat.direction;
        if ((paramArrayOfFloat.distortion == 4) || (paramArrayOfFloat.distortion == 5))
        {
          PointF localPointF2 = (PointF)localList.get(paramArrayOfFloat.direction);
          f12 = (paramArrayOfFloat.targetDx * f10 * f1 + paramArrayOfFloat.targetDy * f11 * f2) * this.faceWidth / 375.0F;
          f13 = (paramArrayOfFloat.targetDx * f11 * f1 - paramArrayOfFloat.targetDy * f10 * f2) * this.faceWidth / 375.0F;
          this.meshs[i].direction = ((float)Math.atan2(f13 + localPointF2.y - this.meshs[i].point.y - this.meshs[i].offsetY, localPointF2.x + f12 - this.meshs[i].point.x - this.meshs[i].offsetX));
          if (paramArrayOfFloat.distortion == 5) {
            this.meshs[i].direction = (3.141593F + this.meshs[i].direction);
          }
        }
        this.meshs[i].faceDegree = f4;
        this.meshs[i].faceRatio = f3;
        i += 1;
      }
      i = this.items.size();
      while (i < 30)
      {
        this.meshs[i].type = -1;
        i += 1;
      }
      j = 0;
      i = 0;
      while (i < this.items.size())
      {
        paramArrayOfFloat = this.flatMesh;
        int k = j + 1;
        paramArrayOfFloat[j] = this.meshs[i].type;
        paramArrayOfFloat = this.flatMesh;
        j = k + 1;
        paramArrayOfFloat[k] = this.meshs[i].strength;
        f10 = (float)(2.0F * (this.meshs[i].point.x + this.meshs[i].offsetX) / paramDouble / this.width - 1.0D);
        f11 = (float)(2.0F * (this.meshs[i].point.y + this.meshs[i].offsetY) / paramDouble / this.height - 1.0D);
        paramArrayOfFloat = this.flatMesh;
        k = j + 1;
        paramArrayOfFloat[j] = (this.screenRatioX * f10);
        paramArrayOfFloat = this.flatMesh;
        j = k + 1;
        paramArrayOfFloat[k] = (this.screenRatioY * f11);
        f2 = AlgoUtils.distanceOfPoint2Line(paramList, paramSet, f5, new PointF(f10, this.height * f11 / this.width)) * f7;
        f1 = f2;
        if ((paramList.x - paramSet.x) * (f11 - paramSet.y) - (paramList.y - paramSet.y) * (f10 - paramSet.x) > 0.0F) {
          f1 = -f2;
        }
        AlgoUtils.distanceOfPoint2Line((PointF)localObject, localPointF1, f8, new PointF(f10, f11 * this.height / this.width));
        f2 = ((PointF)localObject).x;
        f2 = localPointF1.x;
        f2 = localPointF1.y;
        f2 = ((PointF)localObject).y;
        f2 = localPointF1.y;
        f2 = localPointF1.x;
        f1 = 2.5F + f1;
        this.meshs[i].radius = (this.meshs[i].radius * 2.5F / f1);
        paramArrayOfFloat = this.flatMesh;
        k = j + 1;
        paramArrayOfFloat[j] = this.meshs[i].radius;
        paramArrayOfFloat = this.flatMesh;
        int m = k + 1;
        paramArrayOfFloat[k] = this.meshs[i].direction;
        paramArrayOfFloat = this.flatMesh;
        j = m + 1;
        paramArrayOfFloat[m] = f1;
        i += 1;
      }
      addParam(new m.f("faceRatio", f3));
      addParam(new m.f("sin_roll", (float)Math.sin(f4)));
      addParam(new m.f("cos_roll", (float)Math.cos(f4)));
      addParam(new m.f("tan_yaw", (float)Math.tan(f6)));
      addParam(new m.f("cos_yaw", (float)Math.cos(f6)));
      addParam(new m.f("tan_pitch", (float)Math.tan(f9)));
      addParam(new m.f("cos_pitch", (float)Math.cos(f9)));
    }
  }
  
  public void updatePreview(PTDetectInfo paramPTDetectInfo)
  {
    AppMethodBeat.i(83025);
    float[] arrayOfFloat = paramPTDetectInfo.faceAngles;
    if ((paramPTDetectInfo.phoneAngle == 90.0F) || (paramPTDetectInfo.phoneAngle == 270.0F))
    {
      arrayOfFloat = new float[3];
      arrayOfFloat[0] = (-paramPTDetectInfo.faceAngles[1]);
      arrayOfFloat[1] = (-paramPTDetectInfo.faceAngles[0]);
      arrayOfFloat[2] = paramPTDetectInfo.faceAngles[2];
    }
    if (this.dataPath != null)
    {
      updateActionTriggered(paramPTDetectInfo.triggeredExpression, paramPTDetectInfo.timestamp);
      if (this.triggerCtrlItem.isTriggered()) {
        break label132;
      }
      this.items = EMPTY;
      this.mLastMeshIndex = -1;
    }
    for (;;)
    {
      updateParams(paramPTDetectInfo.facePoints, paramPTDetectInfo.triggeredExpression, this.mFaceDetScale, arrayOfFloat);
      AppMethodBeat.o(83025);
      return;
      label132:
      updateMeshParam();
    }
  }
  
  public void updateStrength(float paramFloat)
  {
    this.anotherStrength = paramFloat;
  }
  
  public void updateVideoSize(int paramInt1, int paramInt2, double paramDouble)
  {
    float f3 = 1.0F;
    AppMethodBeat.i(83032);
    super.updateVideoSize(paramInt1, paramInt2, paramDouble);
    float f2 = this.height / this.width;
    if (f2 > 1.0F) {}
    for (float f1 = 1.0F;; f1 = 1.0F / f2)
    {
      this.screenRatioX = f1;
      f1 = f3;
      if (f2 > 1.0F) {
        f1 = f2;
      }
      this.screenRatioY = f1;
      addParam(new m.f("screenRatioX", this.screenRatioX));
      addParam(new m.f("screenRatioY", this.screenRatioY));
      AppMethodBeat.o(83032);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.ttpic.filter.TransformFilter
 * JD-Core Version:    0.7.0.1
 */
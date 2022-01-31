package com.tencent.ttpic.util;

import android.graphics.Color;
import android.graphics.PointF;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.PTFaceAttr.PTExpression;
import com.tencent.ttpic.baseutils.LogUtils;
import com.tencent.ttpic.filter.FabbyMvPart;
import com.tencent.ttpic.filter.FabbyParts;
import com.tencent.ttpic.gameplaysdk.model.GameParams;
import com.tencent.ttpic.gameplaysdk.model.NodeParameter;
import com.tencent.ttpic.gameplaysdk.model.StickerItem3D;
import com.tencent.ttpic.json.XML;
import com.tencent.ttpic.logic.watermark.LogicDataManager;
import com.tencent.ttpic.model.AgeRange;
import com.tencent.ttpic.model.Audio2Text;
import com.tencent.ttpic.model.CanvasItem;
import com.tencent.ttpic.model.CharmRange;
import com.tencent.ttpic.model.CpRange;
import com.tencent.ttpic.model.DistortionItem;
import com.tencent.ttpic.model.ExpressionItem;
import com.tencent.ttpic.model.FaceCropItem;
import com.tencent.ttpic.model.FaceCropItem.CropFrame;
import com.tencent.ttpic.model.FaceExpression;
import com.tencent.ttpic.model.FaceFeatureItem;
import com.tencent.ttpic.model.FaceImageLayer;
import com.tencent.ttpic.model.FaceItem;
import com.tencent.ttpic.model.FaceMeshItem;
import com.tencent.ttpic.model.FaceMoveItem;
import com.tencent.ttpic.model.GenderRange;
import com.tencent.ttpic.model.GridModel;
import com.tencent.ttpic.model.GridSettingModel;
import com.tencent.ttpic.model.ImageWMElement;
import com.tencent.ttpic.model.MultiViewerItem;
import com.tencent.ttpic.model.PhantomItem;
import com.tencent.ttpic.model.PopularRange;
import com.tencent.ttpic.model.Rect;
import com.tencent.ttpic.model.ShakaEffectItem;
import com.tencent.ttpic.model.SizeI;
import com.tencent.ttpic.model.StickerItem;
import com.tencent.ttpic.model.StickerItem.ValueRange;
import com.tencent.ttpic.model.TextWMElement;
import com.tencent.ttpic.model.Transition;
import com.tencent.ttpic.model.VideoFilterEffect;
import com.tencent.ttpic.model.VideoMaterial;
import com.tencent.ttpic.model.WMElement;
import com.tencent.ttpic.model.WMElement.WMType;
import com.tencent.ttpic.model.WMGroup;
import com.tencent.ttpic.model.WMLogic;
import com.tencent.ttpic.model.WMLogicPair;
import com.tencent.ttpic.particle.ParticleConfig;
import com.tencent.util.g;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONTokener;

public class VideoTemplateParser
{
  public static final String POSTFIX_DAT = "dat";
  private static final String POSTFIX_JSON = "json";
  private static final String TAG;
  private static final DecryptListener decryptListener;
  private static Comparator<Pair<Float, Integer>> mDivideValueComp;
  private static Comparator<Pair<Float, ? extends Object>> mDivideValueCompForObject;
  private static Comparator<GridModel> mGridModelComparator;
  private static Comparator<Pair<Float, Double>> mRangeValueComp;
  
  static
  {
    AppMethodBeat.i(84278);
    TAG = VideoTemplateParser.class.getSimpleName();
    decryptListener = new VideoTemplateParser.1();
    mDivideValueComp = new VideoTemplateParser.3();
    mDivideValueCompForObject = new VideoTemplateParser.4();
    mRangeValueComp = new VideoTemplateParser.5();
    mGridModelComparator = new VideoTemplateParser.6();
    AppMethodBeat.o(84278);
  }
  
  private static void checkValid(VideoMaterial paramVideoMaterial)
  {
    AppMethodBeat.i(84277);
    if (paramVideoMaterial == null)
    {
      AppMethodBeat.o(84277);
      return;
    }
    paramVideoMaterial = paramVideoMaterial.getItemList();
    if (paramVideoMaterial == null)
    {
      AppMethodBeat.o(84277);
      return;
    }
    paramVideoMaterial = paramVideoMaterial.iterator();
    while (paramVideoMaterial.hasNext())
    {
      StickerItem localStickerItem = (StickerItem)paramVideoMaterial.next();
      if (localStickerItem.type == VideoFilterFactory.POSITION_TYPE.STATIC.type)
      {
        if ((localStickerItem.position == null) || (localStickerItem.position.length < 2))
        {
          paramVideoMaterial = new IllegalArgumentException("No \"position\" field in static sticker");
          AppMethodBeat.o(84277);
          throw paramVideoMaterial;
        }
      }
      else if (localStickerItem.type == VideoFilterFactory.POSITION_TYPE.DYNAMIC.type)
      {
        if ((localStickerItem.scalePivots == null) || (localStickerItem.scalePivots.length < 2))
        {
          paramVideoMaterial = new IllegalArgumentException("No \"scalePivot\" field in dynamic sticker");
          AppMethodBeat.o(84277);
          throw paramVideoMaterial;
        }
        if ((localStickerItem.alignFacePoints == null) || (localStickerItem.alignFacePoints.length == 0))
        {
          paramVideoMaterial = new IllegalArgumentException("No \"alignFacePoints\" field in dynamic sticker");
          AppMethodBeat.o(84277);
          throw paramVideoMaterial;
        }
        if ((localStickerItem.anchorPoint == null) || (localStickerItem.anchorPoint.length < 2))
        {
          paramVideoMaterial = new IllegalArgumentException("No \"anchorPoint\" field in dynamic sticker");
          AppMethodBeat.o(84277);
          throw paramVideoMaterial;
        }
      }
    }
    AppMethodBeat.o(84277);
  }
  
  private static InputStream drinkACupOfCoffee(InputStream paramInputStream, DecryptListener paramDecryptListener)
  {
    AppMethodBeat.i(84276);
    byte[] arrayOfByte = g.toByteArray(paramInputStream);
    paramInputStream = arrayOfByte;
    if (paramDecryptListener != null) {
      paramInputStream = paramDecryptListener.decrypt(arrayOfByte);
    }
    paramInputStream = new ByteArrayInputStream(paramInputStream);
    AppMethodBeat.o(84276);
    return paramInputStream;
  }
  
  public static Object getVideoMaterialField(String paramString, VideoMaterialUtil.FIELD paramFIELD)
  {
    Object localObject = null;
    AppMethodBeat.i(84242);
    paramString = parseVideoMaterialFileAsJSONObject(paramString, "params", true, decryptListener);
    if (paramString == null)
    {
      AppMethodBeat.o(84242);
      return null;
    }
    try
    {
      paramString = paramString.get(paramFIELD.value);
      AppMethodBeat.o(84242);
      return paramString;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString = localObject;
      }
    }
  }
  
  private static void parse3DItemListParams(String paramString, org.json.JSONObject paramJSONObject, VideoMaterial paramVideoMaterial, boolean[] paramArrayOfBoolean)
  {
    AppMethodBeat.i(84263);
    ArrayList localArrayList;
    Object localObject1;
    int j;
    int i;
    boolean bool;
    label819:
    label826:
    label842:
    label1399:
    int k;
    for (;;)
    {
      StickerItem3D localStickerItem3D;
      try
      {
        localArrayList = new ArrayList();
        localObject1 = paramJSONObject.optJSONArray("itemList3D");
        if (localObject1 == null) {
          break label3101;
        }
        j = 0;
        i = 0;
        if (i >= ((JSONArray)localObject1).length()) {
          break;
        }
        localObject2 = ((JSONArray)localObject1).getJSONObject(i);
        localStickerItem3D = new StickerItem3D();
        paramJSONObject = ((org.json.JSONObject)localObject2).optJSONArray("scale");
        if (paramJSONObject != null)
        {
          localStickerItem3D.nodeScale = new float[paramJSONObject.length()];
          j = 0;
          if (j < paramJSONObject.length())
          {
            localStickerItem3D.nodeScale[j] = ((float)paramJSONObject.getDouble(j));
            j += 1;
            continue;
          }
        }
        paramJSONObject = ((org.json.JSONObject)localObject2).optJSONArray("position");
        if (paramJSONObject != null)
        {
          localStickerItem3D.nodePosition = new float[paramJSONObject.length()];
          j = 0;
          if (j < paramJSONObject.length())
          {
            localStickerItem3D.nodePosition[j] = ((float)paramJSONObject.getDouble(j));
            j += 1;
            continue;
          }
        }
        paramJSONObject = ((org.json.JSONObject)localObject2).optJSONArray("eulerAngles");
        if (paramJSONObject != null)
        {
          localStickerItem3D.nodeEulerAngles = new float[paramJSONObject.length()];
          j = 0;
          if (j < paramJSONObject.length())
          {
            localStickerItem3D.nodeEulerAngles[j] = ((float)paramJSONObject.getDouble(j));
            j += 1;
            continue;
          }
        }
        localStickerItem3D.id = ((org.json.JSONObject)localObject2).optString("id");
        localStickerItem3D.frames = ((org.json.JSONObject)localObject2).optInt("frames");
        localStickerItem3D.frameDuration = ((org.json.JSONObject)localObject2).optDouble("frameDuration");
        if (localStickerItem3D.frames > 0)
        {
          paramJSONObject = new NodeParameter();
          paramJSONObject.nodeId = localStickerItem3D.id;
          paramJSONObject.frames = localStickerItem3D.frames;
          paramJSONObject.frameDuration = ((int)localStickerItem3D.frameDuration);
          localStickerItem3D.nodeParameter = paramJSONObject;
        }
        if (localStickerItem3D.id.contains(":"))
        {
          paramJSONObject = localStickerItem3D.id.split(":");
          if (paramJSONObject.length == 2) {
            localStickerItem3D.subFolder = paramJSONObject[1];
          }
          localStickerItem3D.name = ((org.json.JSONObject)localObject2).optString("name");
          localStickerItem3D.type = ((org.json.JSONObject)localObject2).optInt("type");
          localStickerItem3D.personID = ((org.json.JSONObject)localObject2).optInt("personID", -1);
          localStickerItem3D.featureStatType = ((org.json.JSONObject)localObject2).optInt("featureStatType");
          localStickerItem3D.frameType = ((org.json.JSONObject)localObject2).optInt("frameType");
          localStickerItem3D.blendMode = ((org.json.JSONObject)localObject2).optInt("blendMode", -1);
          localStickerItem3D.zIndex = ((org.json.JSONObject)localObject2).optInt("zIndex", 0);
          localStickerItem3D.audioLoopCount = ((org.json.JSONObject)localObject2).optInt("audioLoopCount", -1);
          paramJSONObject = ((org.json.JSONObject)localObject2).optJSONObject(VideoMaterialUtil.FIELD.CHARM_RANGE.value);
          if (paramJSONObject != null)
          {
            localStickerItem3D.charmRange = new CharmRange();
            localStickerItem3D.charmRange.min = paramJSONObject.optDouble(VideoMaterialUtil.CHARM_RANGE_FIELD.MIN.value);
            localStickerItem3D.charmRange.max = paramJSONObject.optDouble(VideoMaterialUtil.CHARM_RANGE_FIELD.MAX.value);
          }
          if (localStickerItem3D.blendMode == -1) {
            localStickerItem3D.blendMode = paramVideoMaterial.getBlendMode();
          }
          localStickerItem3D.triggerType = ((org.json.JSONObject)localObject2).optInt("triggerType");
          if (VideoMaterialUtil.isActionTriggerType(localStickerItem3D.triggerType)) {
            paramVideoMaterial.setTriggerType(localStickerItem3D.triggerType);
          }
          if (((org.json.JSONObject)localObject2).optInt("alwaysTriggered") == 1)
          {
            bool = true;
            localStickerItem3D.alwaysTriggered = bool;
            localStickerItem3D.playCount = ((org.json.JSONObject)localObject2).optInt("playCount");
            localStickerItem3D.stickerType = ((org.json.JSONObject)localObject2).optInt("stickerType", 0);
            if ((localStickerItem3D.stickerType == VideoFilterFactory.STICKER_TYPE.VIDEO_UP_DOWN.type) || (localStickerItem3D.stickerType == VideoFilterFactory.STICKER_TYPE.VIDEO_LEFT_RIGHT.type))
            {
              if (localStickerItem3D.stickerType != VideoFilterFactory.STICKER_TYPE.VIDEO_UP_DOWN.type) {
                break label819;
              }
              paramJSONObject = VideoMaterialUtil.ITEM_SOURCE_TYPE.VIDEO_UP_DOWN;
              localStickerItem3D.sourceType = paramJSONObject;
            }
            localStickerItem3D.width = ((org.json.JSONObject)localObject2).optInt("width");
            localStickerItem3D.height = ((org.json.JSONObject)localObject2).optInt("height");
            localStickerItem3D.support3D = ((org.json.JSONObject)localObject2).optInt("enable3D", 1);
            paramJSONObject = ((org.json.JSONObject)localObject2).optJSONArray("position");
            if (paramJSONObject == null) {
              break label826;
            }
            localStickerItem3D.position = new double[paramJSONObject.length()];
            j = 0;
            if (j >= paramJSONObject.length()) {
              break label842;
            }
            localStickerItem3D.position[j] = paramJSONObject.getDouble(j);
            j += 1;
            continue;
          }
        }
        else
        {
          localStickerItem3D.subFolder = localStickerItem3D.id;
          continue;
        }
        bool = false;
      }
      catch (JSONException paramString)
      {
        LogUtils.e(TAG, paramString);
        AppMethodBeat.o(84263);
        return;
      }
      continue;
      paramJSONObject = VideoMaterialUtil.ITEM_SOURCE_TYPE.VIDEO_LEFT_RIGHT;
      continue;
      localStickerItem3D.position = new double[] { 0.0D, 0.0D };
      localStickerItem3D.audio = ((org.json.JSONObject)localObject2).optString("audio");
      if ((!TextUtils.isEmpty(localStickerItem3D.audio)) && (!TextUtils.isEmpty(paramString)) && ((paramString.startsWith("assets://camera/camera_video/video_")) || (paramString.contains("/files/olm/camera/video_")))) {
        break label3107;
      }
      paramJSONObject = ((org.json.JSONObject)localObject2).optJSONArray("anchorPoint");
      if (paramJSONObject != null)
      {
        localStickerItem3D.anchorPoint = new int[paramJSONObject.length()];
        j = 0;
        while (j < paramJSONObject.length())
        {
          localStickerItem3D.anchorPoint[j] = paramJSONObject.getInt(j);
          j += 1;
        }
      }
      paramJSONObject = ((org.json.JSONObject)localObject2).optJSONArray("alignFacePoints");
      if (paramJSONObject != null)
      {
        localStickerItem3D.alignFacePoints = new int[paramJSONObject.length()];
        j = 0;
        while (j < paramJSONObject.length())
        {
          localStickerItem3D.alignFacePoints[j] = paramJSONObject.getInt(j);
          j += 1;
        }
      }
      paramJSONObject = ((org.json.JSONObject)localObject2).optJSONArray("scalePivots");
      if (paramJSONObject != null)
      {
        localStickerItem3D.scalePivots = new int[paramJSONObject.length()];
        j = 0;
        while (j < paramJSONObject.length())
        {
          localStickerItem3D.scalePivots[j] = paramJSONObject.getInt(j);
          j += 1;
        }
      }
      localStickerItem3D.scaleFactor = ((org.json.JSONObject)localObject2).optInt("scaleFactor");
      localStickerItem3D.markMode = ((org.json.JSONObject)localObject2).optInt("markMode");
      localStickerItem3D.activateTriggerType = ((org.json.JSONObject)localObject2).optInt("activateTriggerType", 0);
      localStickerItem3D.activateTriggerCount = ((org.json.JSONObject)localObject2).optInt("activateTriggerCount", 0);
      localStickerItem3D.activateTriggerTotalCount = ((org.json.JSONObject)localObject2).optInt("activateTriggerTotalCount", 0);
      paramJSONObject = ((org.json.JSONObject)localObject2).optJSONObject("ageRange");
      if (paramJSONObject != null)
      {
        localStickerItem3D.ageRange = new AgeRange();
        localStickerItem3D.ageRange.min = ((float)paramJSONObject.optDouble("min"));
        localStickerItem3D.ageRange.max = ((float)paramJSONObject.optDouble("max"));
      }
      paramJSONObject = ((org.json.JSONObject)localObject2).optJSONObject("genderRange");
      if (paramJSONObject != null)
      {
        localStickerItem3D.genderRange = new GenderRange();
        localStickerItem3D.genderRange.min = ((float)paramJSONObject.optDouble("min"));
        localStickerItem3D.genderRange.max = ((float)paramJSONObject.optDouble("max"));
      }
      paramJSONObject = ((org.json.JSONObject)localObject2).optJSONObject("popularRange");
      if (paramJSONObject != null)
      {
        localStickerItem3D.popularRange = new PopularRange();
        localStickerItem3D.popularRange.min = ((float)paramJSONObject.optDouble("min"));
        localStickerItem3D.popularRange.max = ((float)paramJSONObject.optDouble("max"));
      }
      paramJSONObject = ((org.json.JSONObject)localObject2).optJSONObject("cpRange");
      if (paramJSONObject != null)
      {
        localStickerItem3D.cpRange = new CpRange();
        localStickerItem3D.cpRange.min = ((float)paramJSONObject.optDouble("min"));
        localStickerItem3D.cpRange.max = ((float)paramJSONObject.optDouble("max"));
      }
      Object localObject2 = ((org.json.JSONObject)localObject2).optJSONArray(VideoMaterialUtil.FIELD.WATERMARK_GROUP.value);
      if (localObject2 != null)
      {
        WMGroup localWMGroup = new WMGroup();
        j = 0;
        if (j < ((JSONArray)localObject2).length())
        {
          Object localObject3 = ((JSONArray)localObject2).optJSONObject(j);
          if (localObject3 == null) {
            break label3138;
          }
          k = ((org.json.JSONObject)localObject3).optInt(VideoMaterialUtil.WATERMARK_ELEMENT.WMTYPE.value);
          if (k == WMElement.WMType.TEXT.value)
          {
            paramJSONObject = new TextWMElement();
            paramJSONObject.dataPath = paramVideoMaterial.getDataPath();
            paramJSONObject.sid = paramVideoMaterial.getId();
            paramJSONObject.id = ((org.json.JSONObject)localObject3).optString(VideoMaterialUtil.WATERMARK_ELEMENT.ID.value);
            paramJSONObject.relativeID = ((org.json.JSONObject)localObject3).optString(VideoMaterialUtil.WATERMARK_ELEMENT.RELATIVE_ID.value);
            localObject4 = ((org.json.JSONObject)localObject3).optJSONArray(VideoMaterialUtil.WATERMARK_ELEMENT.RELATIVE_ANCHOR.value);
            if ((localObject4 == null) || (((JSONArray)localObject4).length() != 2)) {
              break label2334;
            }
            paramJSONObject.relativeAnchor = new PointF((float)((JSONArray)localObject4).getDouble(0), (float)((JSONArray)localObject4).getDouble(1));
            label1553:
            localObject4 = ((org.json.JSONObject)localObject3).optJSONArray(VideoMaterialUtil.WATERMARK_ELEMENT.ANCHOR.value);
            if ((localObject4 == null) || (((JSONArray)localObject4).length() != 2)) {
              break label2350;
            }
          }
          label1734:
          label1758:
          Object localObject5;
          label2105:
          label2130:
          Object localObject6;
          String str1;
          label2334:
          label2350:
          for (paramJSONObject.anchor = new PointF((float)((JSONArray)localObject4).getDouble(0), (float)((JSONArray)localObject4).getDouble(1));; paramJSONObject.anchor = new PointF(0.0F, 0.0F))
          {
            paramJSONObject.offsetX = ((org.json.JSONObject)localObject3).optInt(VideoMaterialUtil.WATERMARK_ELEMENT.OFFSETX.value);
            paramJSONObject.offsetY = ((org.json.JSONObject)localObject3).optInt(VideoMaterialUtil.WATERMARK_ELEMENT.OFFSETY.value);
            paramJSONObject.width = ((org.json.JSONObject)localObject3).optInt(VideoMaterialUtil.WATERMARK_ELEMENT.WIDTH.value);
            paramJSONObject.height = ((org.json.JSONObject)localObject3).optInt(VideoMaterialUtil.WATERMARK_ELEMENT.HEIGHT.value);
            paramJSONObject.wmtype = k;
            paramJSONObject.edittype = ((org.json.JSONObject)localObject3).optInt(VideoMaterialUtil.WATERMARK_ELEMENT.EDITTYPE.value);
            paramJSONObject.fmtstr = ((org.json.JSONObject)localObject3).optString(VideoMaterialUtil.WATERMARK_ELEMENT.FMTSTR.value);
            paramJSONObject.fontName = ((org.json.JSONObject)localObject3).optString(VideoMaterialUtil.WATERMARK_ELEMENT.FONT_NAME.value);
            if (((org.json.JSONObject)localObject3).optInt(VideoMaterialUtil.WATERMARK_ELEMENT.FONT_BOLD.value) != 1) {
              break label3114;
            }
            bool = true;
            paramJSONObject.fontBold = bool;
            if (((org.json.JSONObject)localObject3).optInt(VideoMaterialUtil.WATERMARK_ELEMENT.FONT_ITALICS.value) != 1) {
              break label3120;
            }
            bool = true;
            paramJSONObject.fontItalics = bool;
            paramJSONObject.fontTexture = ((org.json.JSONObject)localObject3).optString(VideoMaterialUtil.WATERMARK_ELEMENT.FONT_TEXTURE.value);
            paramJSONObject.fontSize = ((float)((org.json.JSONObject)localObject3).optDouble(VideoMaterialUtil.WATERMARK_ELEMENT.FONT_SIZE.value, 60.0D));
            paramJSONObject.fontFit = ((org.json.JSONObject)localObject3).optInt(VideoMaterialUtil.WATERMARK_ELEMENT.FONT_FIT.value);
            paramJSONObject.kern = ((org.json.JSONObject)localObject3).optInt(VideoMaterialUtil.WATERMARK_ELEMENT.KERN.value);
            paramJSONObject.imgPath = ((org.json.JSONObject)localObject3).optString(VideoMaterialUtil.WATERMARK_ELEMENT.IMG_PATH.value);
            paramJSONObject.frameDuration = ((org.json.JSONObject)localObject3).optInt(VideoMaterialUtil.WATERMARK_ELEMENT.FRAME_DURATION.value);
            paramJSONObject.frames = ((org.json.JSONObject)localObject3).optInt(VideoMaterialUtil.WATERMARK_ELEMENT.FRAMES.value);
            paramJSONObject.color = ((org.json.JSONObject)localObject3).optString(VideoMaterialUtil.WATERMARK_ELEMENT.COLOR.value, "#FFFFFFFF");
            paramJSONObject.strokeColor = ((org.json.JSONObject)localObject3).optString(VideoMaterialUtil.WATERMARK_ELEMENT.STROKE_COLOR.value, "#FFFFFFFF");
            paramJSONObject.strokeSize = ((float)((org.json.JSONObject)localObject3).optDouble(VideoMaterialUtil.WATERMARK_ELEMENT.STROKE_SIZE.value, -1.0D));
            paramJSONObject.shadowColor = ((org.json.JSONObject)localObject3).optString(VideoMaterialUtil.WATERMARK_ELEMENT.SHADOW_COLOR.value, "#FFFFFFFF");
            paramJSONObject.shadowSize = ((float)((org.json.JSONObject)localObject3).optDouble(VideoMaterialUtil.WATERMARK_ELEMENT.SHADOW_SIZE.value, -1.0D));
            paramJSONObject.shadowDx = ((float)((org.json.JSONObject)localObject3).optDouble(VideoMaterialUtil.WATERMARK_ELEMENT.SHADOW_DX.value, -1.0D));
            paramJSONObject.shadowDy = ((float)((org.json.JSONObject)localObject3).optDouble(VideoMaterialUtil.WATERMARK_ELEMENT.SHADOW_DY.value, -1.0D));
            paramJSONObject.alignment = ((org.json.JSONObject)localObject3).optString(VideoMaterialUtil.WATERMARK_ELEMENT.ALIGNMENT.value);
            paramJSONObject.vertical = ((org.json.JSONObject)localObject3).optInt(VideoMaterialUtil.WATERMARK_ELEMENT.VERTICAL.value);
            paramJSONObject.outerStrokeColor = ((org.json.JSONObject)localObject3).optString(VideoMaterialUtil.WATERMARK_ELEMENT.OUTER_STROKE_COLOR.value, "#FFFFFFFF");
            paramJSONObject.outerStrokeSize = ((float)((org.json.JSONObject)localObject3).optDouble(VideoMaterialUtil.WATERMARK_ELEMENT.OUTER_STROKE_SIZE.value, -1.0D));
            paramJSONObject.shaderBmp = ((org.json.JSONObject)localObject3).optString(VideoMaterialUtil.WATERMARK_ELEMENT.SHADER_BMP.value, null);
            if (((org.json.JSONObject)localObject3).optInt(VideoMaterialUtil.WATERMARK_ELEMENT.EMBOSS.value, 0) != 1) {
              break label3126;
            }
            bool = true;
            paramJSONObject.emboss = bool;
            if (((org.json.JSONObject)localObject3).optInt(VideoMaterialUtil.WATERMARK_ELEMENT.MULTI_ROW.value, 0) != 1) {
              break label3132;
            }
            bool = true;
            paramJSONObject.multiRow = bool;
            paramJSONObject.animateType = ((org.json.JSONObject)localObject3).optString(VideoMaterialUtil.WATERMARK_ELEMENT.ANIMATE_TYPE.value);
            localObject4 = ((org.json.JSONObject)localObject3).optJSONObject(VideoMaterialUtil.WATERMARK_ELEMENT.LOGIC.value);
            if (localObject4 == null) {
              break label2473;
            }
            localObject3 = new WMLogic();
            ((WMLogic)localObject3).type = ((org.json.JSONObject)localObject4).optString(VideoMaterialUtil.WATERMARK_LOGIC.TYPE.value);
            ((WMLogic)localObject3).setCompare(((org.json.JSONObject)localObject4).optString(VideoMaterialUtil.WATERMARK_LOGIC.COMPARE.value), paramJSONObject.sid);
            ((WMLogic)localObject3).data = ((org.json.JSONObject)localObject4).optString(VideoMaterialUtil.WATERMARK_LOGIC.DATA.value);
            localObject5 = ((org.json.JSONObject)localObject4).optJSONObject(VideoMaterialUtil.WATERMARK_LOGIC.RANGE.value);
            if (localObject5 == null) {
              break label2374;
            }
            ((WMLogic)localObject3).range = new ArrayList();
            localObject6 = ((org.json.JSONObject)localObject5).keys();
            while (((Iterator)localObject6).hasNext())
            {
              str1 = (String)((Iterator)localObject6).next();
              String str2 = ((org.json.JSONObject)localObject5).optString(str1);
              ((WMLogic)localObject3).range.add(new WMLogicPair(str1, str2));
            }
            paramJSONObject = new ImageWMElement();
            break;
            paramJSONObject.relativeAnchor = new PointF(0.0F, 0.0F);
            break label1553;
          }
          Collections.sort(((WMLogic)localObject3).range);
          label2374:
          Object localObject4 = ((org.json.JSONObject)localObject4).optJSONObject(VideoMaterialUtil.WATERMARK_LOGIC.CASE.value);
          if (localObject4 != null)
          {
            ((WMLogic)localObject3).wmcase = new ArrayList();
            localObject5 = ((org.json.JSONObject)localObject4).keys();
            while (((Iterator)localObject5).hasNext())
            {
              localObject6 = (String)((Iterator)localObject5).next();
              str1 = ((org.json.JSONObject)localObject4).optString((String)localObject6);
              ((WMLogic)localObject3).wmcase.add(new WMLogicPair((String)localObject6, str1));
            }
          }
          paramJSONObject.logic = ((WMLogic)localObject3);
          label2473:
          localWMGroup.wmElements.add(paramJSONObject);
          break label3138;
        }
        localStickerItem3D.wmGroup = localWMGroup;
      }
      localStickerItem3D.preTriggerType = localStickerItem3D.triggerType;
      localArrayList.add(localStickerItem3D);
      j = localStickerItem3D.triggerType;
      i += 1;
    }
    paramString = localArrayList.iterator();
    while (paramString.hasNext())
    {
      paramJSONObject = (StickerItem3D)paramString.next();
      if (paramJSONObject.activateTriggerType == 0)
      {
        paramJSONObject.countTriggerType = j;
      }
      else
      {
        paramJSONObject.playCount = 0;
        paramJSONObject.countTriggerType = PTFaceAttr.PTExpression.MV_PART_INDEX.value;
      }
    }
    paramVideoMaterial.setItemList3D(localArrayList);
    paramVideoMaterial = paramVideoMaterial.getGameParams();
    if (paramVideoMaterial != null) {
      j = 0;
    }
    for (;;)
    {
      if (j < localArrayList.size())
      {
        paramArrayOfBoolean = (StickerItem3D)localArrayList.get(j);
        i = 0;
        paramJSONObject = "";
        int m;
        int n;
        float f;
        if ((paramArrayOfBoolean.nodePosition != null) && (paramArrayOfBoolean.nodePosition.length == 3))
        {
          m = 1;
          localObject1 = paramArrayOfBoolean.nodePosition;
          n = localObject1.length;
          k = 0;
          for (;;)
          {
            paramString = paramJSONObject;
            i = m;
            if (k >= n) {
              break;
            }
            f = localObject1[k];
            paramJSONObject = paramJSONObject + f + "/";
            k += 1;
          }
        }
        paramString = "" + "0/0/0/";
        if (paramArrayOfBoolean.id.equals("head")) {
          paramString = paramString + "180/0/0/";
        }
        while ((paramArrayOfBoolean.nodeScale != null) && (paramArrayOfBoolean.nodeScale.length == 3))
        {
          m = 1;
          localObject1 = paramArrayOfBoolean.nodeScale;
          n = localObject1.length;
          i = 0;
          for (;;)
          {
            paramJSONObject = paramString;
            k = m;
            if (i >= n) {
              break;
            }
            f = localObject1[i];
            paramString = paramString + f + "/";
            i += 1;
          }
          if ((paramArrayOfBoolean.nodeEulerAngles != null) && (paramArrayOfBoolean.nodeEulerAngles.length == 3))
          {
            m = 1;
            localObject1 = paramArrayOfBoolean.nodeEulerAngles;
            n = localObject1.length;
            k = 0;
            paramJSONObject = paramString;
            for (;;)
            {
              paramString = paramJSONObject;
              i = m;
              if (k >= n) {
                break;
              }
              f = localObject1[k];
              paramJSONObject = paramJSONObject + f + "/";
              k += 1;
            }
          }
          paramString = paramString + "0/0/0/";
        }
        paramJSONObject = paramString + "1/1/1/";
        k = i;
        if (k != 0)
        {
          paramString = paramArrayOfBoolean.id.split(":");
          paramVideoMaterial.nodeInitialTransform = (paramVideoMaterial.nodeInitialTransform + paramString[0] + "/" + paramJSONObject);
        }
      }
      else
      {
        if (!TextUtils.isEmpty(paramVideoMaterial.nodeInitialTransform)) {
          paramVideoMaterial.nodeInitialTransform = paramVideoMaterial.nodeInitialTransform.substring(0, paramVideoMaterial.nodeInitialTransform.length() - 1);
        }
        label3101:
        AppMethodBeat.o(84263);
        return;
        label3107:
        paramArrayOfBoolean[0] = true;
        break;
        label3114:
        bool = false;
        break label1734;
        label3120:
        bool = false;
        break label1758;
        label3126:
        bool = false;
        break label2105;
        label3132:
        bool = false;
        break label2130;
        label3138:
        j += 1;
        break label1399;
      }
      j += 1;
    }
  }
  
  private static void parseArParticleListParams(org.json.JSONObject paramJSONObject, VideoMaterial paramVideoMaterial)
  {
    AppMethodBeat.i(84253);
    paramJSONObject = paramJSONObject.optJSONArray(VideoMaterialUtil.FIELD.AR_PARTICLE_LIST.value);
    if (paramJSONObject != null)
    {
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i < paramJSONObject.length())
      {
        String str = paramJSONObject.optString(i);
        if (str != null) {
          localArrayList.add(str);
        }
        i += 1;
      }
      paramVideoMaterial.setArParticleList(localArrayList);
    }
    AppMethodBeat.o(84253);
  }
  
  public static void parseAudio2TextParams(org.json.JSONObject paramJSONObject, VideoMaterial paramVideoMaterial)
  {
    AppMethodBeat.i(84269);
    paramJSONObject = paramJSONObject.optJSONObject("audio2text");
    if (paramJSONObject != null)
    {
      Audio2Text localAudio2Text = new Audio2Text();
      localAudio2Text.sentenceCount = paramJSONObject.optInt("sentenceCount", 0);
      localAudio2Text.sentenceMode = paramJSONObject.optInt("sentenceMode", 0);
      localAudio2Text.silenceTime = paramJSONObject.optDouble("silenceTime", 0.0D);
      localAudio2Text.segmentCount = paramJSONObject.optInt("segmentCount", 0);
      localAudio2Text.segmentTime = paramJSONObject.optDouble("segmentTime", 0.0D);
      localAudio2Text.triggerWords = paramJSONObject.optString("triggerWords", null);
      paramVideoMaterial.setAudio2Text(localAudio2Text);
    }
    AppMethodBeat.o(84269);
  }
  
  private static void parseAudio3DParams(org.json.JSONObject paramJSONObject, VideoMaterial paramVideoMaterial)
  {
    boolean bool2 = true;
    AppMethodBeat.i(84267);
    GameParams localGameParams = new GameParams();
    localGameParams.mGameName = paramJSONObject.optString(VideoMaterialUtil.GAME_FIELD.GAME_NAME.value);
    localGameParams.mAnimNames = paramJSONObject.optString(VideoMaterialUtil.GAME_FIELD.ANIM_NAMES.value);
    localGameParams.mAnimDefaultRotate = paramJSONObject.optString(VideoMaterialUtil.GAME_FIELD.ANIM_DEFAULT_ROTATE.value);
    localGameParams.mAnimNodeNames = paramJSONObject.optString(VideoMaterialUtil.GAME_FIELD.ANIM_NODE_NAMES.value);
    localGameParams.mRunningAnimName = paramJSONObject.optString(VideoMaterialUtil.GAME_FIELD.RUNNING_ANIM_NAME.value);
    localGameParams.mRunningAnimDefaultRotate = paramJSONObject.optString(VideoMaterialUtil.GAME_FIELD.RUNNING_ANIM_DEFAULT_ROTATE.value);
    JSONArray localJSONArray = paramJSONObject.optJSONArray(VideoMaterialUtil.GAME_FIELD.TEXTURE_IMAGES.value);
    if ((localJSONArray != null) && (localJSONArray.length() > 0))
    {
      localGameParams.textureImages = new String[localJSONArray.length()];
      int i = 0;
      while (i < localJSONArray.length())
      {
        localGameParams.textureImages[i] = localJSONArray.optString(i);
        i += 1;
      }
      localGameParams.usePreload = true;
    }
    localGameParams.fov = ((float)paramJSONObject.optDouble(VideoMaterialUtil.GAME_FIELD.FOV.value, 60.0D));
    if (paramJSONObject.optInt(VideoMaterialUtil.GAME_FIELD.NOT_FLATTEN_EAR.value, 0) == 0)
    {
      bool1 = true;
      localGameParams.flattenEar = bool1;
      if (paramJSONObject.optInt(VideoMaterialUtil.GAME_FIELD.NOT_FLATTEN_NOSE.value, 0) != 0) {
        break label265;
      }
    }
    label265:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localGameParams.flattenNose = bool1;
      paramVideoMaterial.setAudio3DParams(localGameParams);
      AppMethodBeat.o(84267);
      return;
      bool1 = false;
      break;
    }
  }
  
  private static void parseBasicParams(String paramString, org.json.JSONObject paramJSONObject, VideoMaterial paramVideoMaterial)
  {
    boolean bool2 = true;
    AppMethodBeat.i(84249);
    paramVideoMaterial.setId(VideoMaterialUtil.getMaterialId(paramString));
    paramVideoMaterial.setMinAppVersion(paramJSONObject.optInt(VideoMaterialUtil.FIELD.MIN_APP_VERSION.value));
    paramVideoMaterial.setCategoryFlag(paramJSONObject.optInt(VideoMaterialUtil.FIELD.CATEGORY_FLAG.value, 0));
    paramVideoMaterial.setShaderType(paramJSONObject.optInt(VideoMaterialUtil.FIELD.SHADER_TYPE.value));
    paramVideoMaterial.setFaceoffType(paramJSONObject.optInt(VideoMaterialUtil.FIELD.FACE_OFF_TYPE.value));
    paramVideoMaterial.setFaceSwapType(paramJSONObject.optInt(VideoMaterialUtil.FIELD.FACE_SWAP_TYPE.value));
    paramVideoMaterial.setMaxFaceCount(paramJSONObject.optInt(VideoMaterialUtil.FIELD.MAX_FACE_COUNT.value));
    if (paramJSONObject.optInt(VideoMaterialUtil.FIELD.RESET_WHEN_START_RECORD.value, 0) == 1)
    {
      bool1 = true;
      paramVideoMaterial.setResetWhenStartRecord(bool1);
      if (paramJSONObject.optInt(VideoMaterialUtil.FIELD.SUPPORT_PAUSE.value, 0) != 1) {
        break label569;
      }
      bool1 = true;
      label141:
      paramVideoMaterial.setSupportPause(bool1);
      paramVideoMaterial.setVoicekind(paramJSONObject.optInt(VideoMaterialUtil.FIELD.VOICE_KIND.value, -999999));
      paramVideoMaterial.setEnvironment(paramJSONObject.optInt(VideoMaterialUtil.FIELD.ENVIRONMENT.value, -999999));
      paramVideoMaterial.setFaceExchangeImage(paramJSONObject.optString(VideoMaterialUtil.FIELD.FACE_EXCHANGE_IMAGE.value));
      paramVideoMaterial.setImageFacePointsFileName(paramJSONObject.optString(VideoMaterialUtil.FIELD.IMAGE_FACE_POINTS_FILE_NAME.value));
      paramVideoMaterial.setBlendAlpha(paramJSONObject.optDouble(VideoMaterialUtil.FIELD.BLEND_ALPHA.value));
      paramVideoMaterial.setGrayScale(paramJSONObject.optInt(VideoMaterialUtil.FIELD.GRAY_SCALE.value));
      paramVideoMaterial.setOrderMode(paramJSONObject.optInt(VideoMaterialUtil.FIELD.ORDER_MODE.value));
      paramVideoMaterial.setBlendMode(paramJSONObject.optInt(VideoMaterialUtil.FIELD.BLEND_MODE.value));
      paramVideoMaterial.setFeatureType(paramJSONObject.optInt(VideoMaterialUtil.FIELD.FEATURE_TYPE.value));
      paramVideoMaterial.setFilterId(paramJSONObject.optString(VideoMaterialUtil.FIELD.FILTER_ID.value));
      paramVideoMaterial.setFilterBlurStrength(paramJSONObject.optDouble(VideoMaterialUtil.FIELD.FILTER_BLUR_STRENGTH.value, 0.0D));
      paramVideoMaterial.setArParticleType(paramJSONObject.optInt(VideoMaterialUtil.FIELD.AR_PARTICLE_TYPE.value));
      if (paramJSONObject.optInt(VideoMaterialUtil.FIELD.SUPPORT_LANDSCAPE.value, 1) != 1) {
        break label574;
      }
      bool1 = true;
      label338:
      paramVideoMaterial.setSupportLandscape(bool1);
      paramVideoMaterial.setRandomGroupCount(paramJSONObject.optInt(VideoMaterialUtil.FIELD.RANDOM_GROUP_COUNT.value));
      paramVideoMaterial.setTipsText(paramJSONObject.optString(VideoMaterialUtil.FIELD.TIPS_TEXT.value));
      paramVideoMaterial.setTipsIcon(paramJSONObject.optString(VideoMaterialUtil.FIELD.TIPS_ICON.value));
      paramVideoMaterial.setHandBoostEnable(paramJSONObject.optInt(VideoMaterialUtil.FIELD.HAND_BOOST_ENABLE.value));
      if (paramJSONObject.optInt(VideoMaterialUtil.FIELD.USE_MESH.value, 0) == 0) {
        break label579;
      }
    }
    label569:
    label574:
    label579:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramVideoMaterial.setUseMesh(bool1);
      if (!TextUtils.isEmpty(paramJSONObject.optString(VideoMaterialUtil.FIELD.AD_ICON.value))) {
        paramVideoMaterial.setAdIcon(paramString + File.separator + paramJSONObject.optString(VideoMaterialUtil.FIELD.AD_ICON.value));
      }
      paramVideoMaterial.setAdLink(paramJSONObject.optString(VideoMaterialUtil.FIELD.AD_LINK.value));
      paramVideoMaterial.setAdAppLink(paramJSONObject.optString(VideoMaterialUtil.FIELD.AD_APP_LINK.value));
      paramVideoMaterial.setWeiboTag(paramJSONObject.optString("weiboTag"));
      paramVideoMaterial.setDetectorFlag(paramJSONObject.optInt(VideoMaterialUtil.FIELD.DETECTOR_FLAG.value));
      paramVideoMaterial.setLipsLutPath(paramJSONObject.optString(VideoMaterialUtil.FIELD.LIPS_LUT.value));
      paramVideoMaterial.setSplitScreen((float)paramJSONObject.optDouble(VideoMaterialUtil.FIELD.SPLIT_SCREEN.value, 0.0D));
      AppMethodBeat.o(84249);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label141;
      bool1 = false;
      break label338;
    }
  }
  
  private static List<DistortionItem> parseDistortionItemListParams(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(84261);
    if (paramJSONArray != null) {
      try
      {
        ArrayList localArrayList = new ArrayList();
        int i = 0;
        while (i < paramJSONArray.length())
        {
          DistortionItem localDistortionItem = new DistortionItem();
          org.json.JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
          localDistortionItem.position = localJSONObject.optInt(VideoMaterialUtil.DISTORTION_ITEM_FILED.POSITION.value);
          localDistortionItem.distortion = localJSONObject.optInt(VideoMaterialUtil.DISTORTION_ITEM_FILED.DISTORTION.value);
          localDistortionItem.direction = localJSONObject.optInt(VideoMaterialUtil.DISTORTION_ITEM_FILED.DIRECTION.value);
          localDistortionItem.radius = ((float)localJSONObject.optDouble(VideoMaterialUtil.DISTORTION_ITEM_FILED.RADIUS.value));
          localDistortionItem.strength = ((float)localJSONObject.optDouble(VideoMaterialUtil.DISTORTION_ITEM_FILED.STRENGH.value));
          localDistortionItem.x = localJSONObject.optInt(VideoMaterialUtil.DISTORTION_ITEM_FILED.X.value);
          localDistortionItem.y = localJSONObject.optInt(VideoMaterialUtil.DISTORTION_ITEM_FILED.Y.value);
          localArrayList.add(localDistortionItem);
          i += 1;
        }
        AppMethodBeat.o(84261);
        return localArrayList;
      }
      catch (JSONException paramJSONArray)
      {
        LogUtils.e(TAG, paramJSONArray);
      }
    }
    AppMethodBeat.o(84261);
    return null;
  }
  
  private static void parseFabbyMvItems(String paramString, org.json.JSONObject paramJSONObject, VideoMaterial paramVideoMaterial, DecryptListener paramDecryptListener)
  {
    AppMethodBeat.i(84268);
    Object localObject2 = paramJSONObject.optString("mvTemplateFile");
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      AppMethodBeat.o(84268);
      return;
    }
    int i = ((String)localObject2).lastIndexOf(".");
    Object localObject1 = localObject2;
    if (i >= 0) {
      localObject1 = ((String)localObject2).substring(0, i);
    }
    Object localObject4 = parseVideoMaterialFileAsJSONObject(paramString, (String)localObject1, true, paramDecryptListener);
    if (localObject4 == null)
    {
      AppMethodBeat.o(84268);
      return;
    }
    JSONArray localJSONArray = ((org.json.JSONObject)localObject4).optJSONArray("parts");
    if (localJSONArray == null)
    {
      AppMethodBeat.o(84268);
      return;
    }
    if (localJSONArray.length() <= 0)
    {
      AppMethodBeat.o(84268);
      return;
    }
    localJSONArray.length();
    Object localObject3 = new ArrayList();
    i = 0;
    int j;
    while (i < localJSONArray.length())
    {
      FabbyMvPart localFabbyMvPart = new FabbyMvPart();
      Object localObject5 = localJSONArray.optJSONObject(i);
      if (localObject5 != null)
      {
        double d = ((org.json.JSONObject)localObject5).optDouble("duration");
        Object localObject6 = ((org.json.JSONObject)localObject5).optJSONObject("background");
        Object localObject7;
        if (localObject6 != null)
        {
          localObject7 = new StickerItem();
          localObject1 = ((org.json.JSONObject)localObject6).optString("videoFile");
          localObject2 = ((org.json.JSONObject)localObject6).optString("imageName");
          if ((!TextUtils.isEmpty((CharSequence)localObject1)) || (!TextUtils.isEmpty((CharSequence)localObject2)))
          {
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              break label1244;
            }
            j = ((String)localObject1).lastIndexOf("/");
            ((StickerItem)localObject7).id = ((String)localObject1).substring(j + 1, ((String)localObject1).length());
            ((StickerItem)localObject7).subFolder = ((String)localObject1).substring(0, j);
            j = 1;
            ((StickerItem)localObject7).type = 1;
            ((StickerItem)localObject7).alwaysTriggered = true;
            ((StickerItem)localObject7).frames = ((org.json.JSONObject)localObject6).optInt("imageCount", 1);
            ((StickerItem)localObject7).frameDuration = (((org.json.JSONObject)localObject6).optDouble("imageDuration", d) / ((StickerItem)localObject7).frames * 1000.0D);
            ((StickerItem)localObject7).aspectMode = ((org.json.JSONObject)localObject6).optInt("aspectMode", 0);
            ((StickerItem)localObject7).blendMode = ((org.json.JSONObject)localObject6).optInt("blendMode", 0);
            ((StickerItem)localObject7).width = ((org.json.JSONObject)localObject6).optInt("width", 720);
            ((StickerItem)localObject7).height = ((org.json.JSONObject)localObject6).optInt("height", 960);
            ((StickerItem)localObject7).position = new double[] { 0.0D, 0.0D };
            ((StickerItem)localObject7).isFabbyMvItem = true;
            ((StickerItem)localObject7).fabbyTotalParts = localJSONArray.length();
            ((StickerItem)localObject7).fabbyPart = i;
            if (j == 0) {
              break label1322;
            }
            ((StickerItem)localObject7).sourceType = VideoMaterialUtil.getItemSourceType(((org.json.JSONObject)localObject6).optInt(VideoMaterialUtil.FIELD.VIDEO_ALPHA_TYPE.value));
            label467:
            localFabbyMvPart.bgItem = ((StickerItem)localObject7);
          }
        }
        localObject6 = ((org.json.JSONObject)localObject5).optJSONObject("foreground");
        if (localObject6 != null)
        {
          localObject7 = new StickerItem();
          localObject1 = ((org.json.JSONObject)localObject6).optString("videoFile");
          localObject2 = ((org.json.JSONObject)localObject6).optString("imageName");
          if ((!TextUtils.isEmpty((CharSequence)localObject1)) || (!TextUtils.isEmpty((CharSequence)localObject2)))
          {
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              break label1333;
            }
            j = ((String)localObject1).lastIndexOf("/");
            ((StickerItem)localObject7).id = ((String)localObject1).substring(j + 1, ((String)localObject1).length());
            ((StickerItem)localObject7).subFolder = ((String)localObject1).substring(0, j);
            j = 1;
            label587:
            ((StickerItem)localObject7).type = 1;
            ((StickerItem)localObject7).alwaysTriggered = true;
            ((StickerItem)localObject7).frames = ((org.json.JSONObject)localObject6).optInt("imageCount", 1);
            ((StickerItem)localObject7).frameDuration = (((org.json.JSONObject)localObject6).optDouble("imageDuration", d) / ((StickerItem)localObject7).frames * 1000.0D);
            ((StickerItem)localObject7).aspectMode = ((org.json.JSONObject)localObject6).optInt("aspectMode", 0);
            ((StickerItem)localObject7).blendMode = ((org.json.JSONObject)localObject6).optInt("blendMode", 0);
            ((StickerItem)localObject7).width = ((org.json.JSONObject)localObject6).optInt("width", 720);
            ((StickerItem)localObject7).height = ((org.json.JSONObject)localObject6).optInt("height", 1280);
            ((StickerItem)localObject7).position = new double[] { 0.0D, 0.0D };
            ((StickerItem)localObject7).isFabbyMvItem = true;
            ((StickerItem)localObject7).fabbyTotalParts = localJSONArray.length();
            ((StickerItem)localObject7).fabbyPart = i;
            if (j == 0) {
              break label1411;
            }
            ((StickerItem)localObject7).sourceType = VideoMaterialUtil.getItemSourceType(((org.json.JSONObject)localObject6).optInt(VideoMaterialUtil.FIELD.VIDEO_ALPHA_TYPE.value));
            label762:
            localFabbyMvPart.fgItem = ((StickerItem)localObject7);
          }
        }
        localObject6 = ((org.json.JSONObject)localObject5).optJSONObject("cover");
        if (localObject6 != null)
        {
          localObject7 = new StickerItem();
          localObject2 = ((org.json.JSONObject)localObject6).optString("imageFile");
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject1 = localObject2;
            if (((String)localObject2).endsWith("_")) {
              localObject1 = ((String)localObject2).substring(0, ((String)localObject2).length() - 1);
            }
            j = ((String)localObject1).lastIndexOf("/");
            ((StickerItem)localObject7).id = ((String)localObject1).substring(j + 1, ((String)localObject1).lastIndexOf("_"));
            ((StickerItem)localObject7).subFolder = ((String)localObject1).substring(0, j);
            ((StickerItem)localObject7).type = 1;
            ((StickerItem)localObject7).alwaysTriggered = true;
            ((StickerItem)localObject7).frames = 1;
            ((StickerItem)localObject7).frameDuration = (1000.0D * d);
            ((StickerItem)localObject7).aspectMode = ((org.json.JSONObject)localObject6).optInt("aspectMode", 0);
            ((StickerItem)localObject7).blendMode = ((org.json.JSONObject)localObject6).optInt("blendMode", 0);
            ((StickerItem)localObject7).width = ((org.json.JSONObject)localObject6).optInt("width", 720);
            ((StickerItem)localObject7).height = ((org.json.JSONObject)localObject6).optInt("height", 1280);
            ((StickerItem)localObject7).position = new double[] { 0.0D, 0.0D };
            ((StickerItem)localObject7).isFabbyMvItem = true;
            ((StickerItem)localObject7).fabbyTotalParts = localJSONArray.length();
            ((StickerItem)localObject7).fabbyPart = i;
            localFabbyMvPart.coverItem = ((StickerItem)localObject7);
          }
        }
        localObject1 = ((org.json.JSONObject)localObject5).optJSONObject("cameraFrame");
        if (localObject1 != null)
        {
          localFabbyMvPart.easeCurve = ((org.json.JSONObject)localObject1).optInt("easeCurve", 0);
          localFabbyMvPart.scaleMap.clear();
          localObject2 = ((org.json.JSONObject)localObject1).optJSONObject("shakaEffect");
          Object localObject8;
          Object localObject9;
          Object localObject10;
          Object localObject11;
          Object localObject12;
          Object localObject13;
          if (localObject2 != null)
          {
            localObject6 = new ShakaEffectItem();
            ((ShakaEffectItem)localObject6).setFilterType(((org.json.JSONObject)localObject2).optInt("filterType"));
            localObject7 = new HashMap();
            localObject8 = ((org.json.JSONObject)localObject2).keys();
            for (;;)
            {
              if (!((Iterator)localObject8).hasNext()) {
                break label1445;
              }
              localObject9 = (String)((Iterator)localObject8).next();
              localObject10 = ((org.json.JSONObject)localObject2).optJSONObject((String)localObject9);
              new StringBuilder("key = ").append((String)localObject9).append(", valueJson = ").append(localObject10);
              if (localObject10 != null)
              {
                localObject11 = new ArrayList();
                localObject12 = ((org.json.JSONObject)localObject10).keys();
                for (;;)
                {
                  if (((Iterator)localObject12).hasNext())
                  {
                    localObject13 = (String)((Iterator)localObject12).next();
                    ((List)localObject11).add(Pair.create(Float.valueOf((String)localObject13), Double.valueOf(((org.json.JSONObject)localObject10).optDouble((String)localObject13, 0.0D))));
                    continue;
                    label1244:
                    localObject1 = localObject2;
                    if (((String)localObject2).endsWith("_")) {
                      localObject1 = ((String)localObject2).substring(0, ((String)localObject2).length() - 1);
                    }
                    j = ((String)localObject1).lastIndexOf("/");
                    ((StickerItem)localObject7).id = ((String)localObject1).substring(j + 1, ((String)localObject1).length());
                    ((StickerItem)localObject7).subFolder = ((String)localObject1).substring(0, j);
                    j = 0;
                    break;
                    label1322:
                    ((StickerItem)localObject7).sourceType = VideoMaterialUtil.ITEM_SOURCE_TYPE.IMAGE;
                    break label467;
                    label1333:
                    localObject1 = localObject2;
                    if (((String)localObject2).endsWith("_")) {
                      localObject1 = ((String)localObject2).substring(0, ((String)localObject2).length() - 1);
                    }
                    j = ((String)localObject1).lastIndexOf("/");
                    ((StickerItem)localObject7).id = ((String)localObject1).substring(j + 1, ((String)localObject1).length());
                    ((StickerItem)localObject7).subFolder = ((String)localObject1).substring(0, j);
                    j = 0;
                    break label587;
                    label1411:
                    ((StickerItem)localObject7).sourceType = VideoMaterialUtil.ITEM_SOURCE_TYPE.IMAGE;
                    break label762;
                  }
                }
                Collections.sort((List)localObject11, mRangeValueComp);
                ((Map)localObject7).put(localObject9, localObject11);
              }
            }
            label1445:
            ((ShakaEffectItem)localObject6).setValueMap((Map)localObject7);
            localFabbyMvPart.setShakaEffectItem((ShakaEffectItem)localObject6);
          }
          localObject2 = ((org.json.JSONObject)localObject1).optJSONObject("scale");
          if (localObject2 != null)
          {
            localObject6 = ((org.json.JSONObject)localObject2).keys();
            while (((Iterator)localObject6).hasNext())
            {
              localObject7 = (String)((Iterator)localObject6).next();
              localFabbyMvPart.scaleMap.add(Pair.create(Float.valueOf((String)localObject7), Double.valueOf(((org.json.JSONObject)localObject2).optDouble((String)localObject7, 1.0D))));
            }
          }
          Collections.sort(localFabbyMvPart.scaleMap, mRangeValueComp);
          localFabbyMvPart.degreeMap.clear();
          localObject2 = ((org.json.JSONObject)localObject1).optJSONObject("rotate");
          if (localObject2 != null)
          {
            localObject6 = ((org.json.JSONObject)localObject2).keys();
            while (((Iterator)localObject6).hasNext())
            {
              localObject7 = (String)((Iterator)localObject6).next();
              localFabbyMvPart.degreeMap.add(Pair.create(Float.valueOf((String)localObject7), Double.valueOf(((org.json.JSONObject)localObject2).optDouble((String)localObject7, 0.0D))));
            }
          }
          Collections.sort(localFabbyMvPart.degreeMap, mRangeValueComp);
          localFabbyMvPart.translateXMap.clear();
          localObject2 = ((org.json.JSONObject)localObject1).optJSONObject("translateX");
          if (localObject2 != null)
          {
            localObject6 = ((org.json.JSONObject)localObject2).keys();
            while (((Iterator)localObject6).hasNext())
            {
              localObject7 = (String)((Iterator)localObject6).next();
              localFabbyMvPart.translateXMap.add(Pair.create(Float.valueOf((String)localObject7), Double.valueOf(((org.json.JSONObject)localObject2).optDouble((String)localObject7, 0.0D))));
            }
          }
          Collections.sort(localFabbyMvPart.translateXMap, mRangeValueComp);
          localFabbyMvPart.translateYMap.clear();
          localObject2 = ((org.json.JSONObject)localObject1).optJSONObject("translateY");
          if (localObject2 != null)
          {
            localObject6 = ((org.json.JSONObject)localObject2).keys();
            while (((Iterator)localObject6).hasNext())
            {
              localObject7 = (String)((Iterator)localObject6).next();
              localFabbyMvPart.translateYMap.add(Pair.create(Float.valueOf((String)localObject7), Double.valueOf(((org.json.JSONObject)localObject2).optDouble((String)localObject7, 0.0D))));
            }
          }
          Collections.sort(localFabbyMvPart.translateYMap, mRangeValueComp);
          localFabbyMvPart.anchorXMap.clear();
          localObject2 = ((org.json.JSONObject)localObject1).optJSONObject("anchorX");
          if (localObject2 != null)
          {
            localObject6 = ((org.json.JSONObject)localObject2).keys();
            while (((Iterator)localObject6).hasNext())
            {
              localObject7 = (String)((Iterator)localObject6).next();
              localFabbyMvPart.anchorXMap.add(Pair.create(Float.valueOf((String)localObject7), Double.valueOf(((org.json.JSONObject)localObject2).optDouble((String)localObject7, 0.0D))));
            }
          }
          Collections.sort(localFabbyMvPart.anchorXMap, mRangeValueComp);
          localFabbyMvPart.anchorYMap.clear();
          localObject2 = ((org.json.JSONObject)localObject1).optJSONObject("anchorY");
          if (localObject2 != null)
          {
            localObject6 = ((org.json.JSONObject)localObject2).keys();
            while (((Iterator)localObject6).hasNext())
            {
              localObject7 = (String)((Iterator)localObject6).next();
              localFabbyMvPart.anchorYMap.add(Pair.create(Float.valueOf((String)localObject7), Double.valueOf(((org.json.JSONObject)localObject2).optDouble((String)localObject7, 0.0D))));
            }
          }
          Collections.sort(localFabbyMvPart.anchorYMap, mRangeValueComp);
          localFabbyMvPart.alphaMap.clear();
          localObject2 = ((org.json.JSONObject)localObject1).optJSONObject("alpha");
          if (localObject2 != null)
          {
            localObject6 = ((org.json.JSONObject)localObject2).keys();
            while (((Iterator)localObject6).hasNext())
            {
              localObject7 = (String)((Iterator)localObject6).next();
              localFabbyMvPart.alphaMap.add(Pair.create(Float.valueOf((String)localObject7), Double.valueOf(((org.json.JSONObject)localObject2).optDouble((String)localObject7, 1.0D))));
            }
          }
          Collections.sort(localFabbyMvPart.alphaMap, mRangeValueComp);
          localFabbyMvPart.blurRadiusMap.clear();
          localObject2 = ((org.json.JSONObject)localObject1).optJSONObject("blurRadius");
          if (localObject2 != null)
          {
            localObject6 = ((org.json.JSONObject)localObject2).keys();
            while (((Iterator)localObject6).hasNext())
            {
              localObject7 = (String)((Iterator)localObject6).next();
              localFabbyMvPart.blurRadiusMap.add(Pair.create(Float.valueOf((String)localObject7), Double.valueOf(((org.json.JSONObject)localObject2).optDouble((String)localObject7, 0.0D))));
            }
          }
          Collections.sort(localFabbyMvPart.blurRadiusMap, mRangeValueComp);
          localFabbyMvPart.blurDirectionMap.clear();
          localObject2 = ((org.json.JSONObject)localObject1).optJSONObject("blurDirection");
          if (localObject2 != null)
          {
            localObject6 = ((org.json.JSONObject)localObject2).keys();
            while (((Iterator)localObject6).hasNext())
            {
              localObject7 = (String)((Iterator)localObject6).next();
              localFabbyMvPart.blurDirectionMap.add(Pair.create(Float.valueOf((String)localObject7), Double.valueOf(((org.json.JSONObject)localObject2).optDouble((String)localObject7, 0.0D))));
            }
          }
          Collections.sort(localFabbyMvPart.blurDirectionMap, mRangeValueComp);
          localFabbyMvPart.gridTypeMap.clear();
          localObject2 = ((org.json.JSONObject)localObject1).optJSONObject("gridType");
          if (localObject2 != null)
          {
            localObject6 = ((org.json.JSONObject)localObject2).keys();
            while (((Iterator)localObject6).hasNext())
            {
              localObject7 = (String)((Iterator)localObject6).next();
              localFabbyMvPart.gridTypeMap.add(Pair.create(Float.valueOf((String)localObject7), Integer.valueOf(((org.json.JSONObject)localObject2).optInt((String)localObject7, 0))));
            }
          }
          Collections.sort(localFabbyMvPart.gridTypeMap, mDivideValueComp);
          localFabbyMvPart.gridSettingMap.clear();
          localObject2 = ((org.json.JSONObject)localObject1).optJSONObject("gridSettingFile");
          if (localObject2 != null)
          {
            localObject6 = ((org.json.JSONObject)localObject2).keys();
            while (((Iterator)localObject6).hasNext())
            {
              localObject7 = (String)((Iterator)localObject6).next();
              localObject8 = ((org.json.JSONObject)localObject2).optString((String)localObject7);
              if (!TextUtils.isEmpty((CharSequence)localObject8))
              {
                localObject10 = parseVideoMaterialFileAsJSONObject(paramString, (String)localObject8, true, paramDecryptListener);
                if (localObject10 != null)
                {
                  localObject8 = new GridSettingModel();
                  localObject9 = new Rect(0, 0, 720, 1280);
                  localObject11 = ((org.json.JSONObject)localObject10).optJSONObject("canvasSize");
                  if (localObject11 != null)
                  {
                    ((Rect)localObject9).width = ((int)((org.json.JSONObject)localObject11).optDouble("width", 720.0D));
                    ((Rect)localObject9).height = ((int)((org.json.JSONObject)localObject11).optDouble("height", 1280.0D));
                  }
                  localObject10 = ((org.json.JSONObject)localObject10).optJSONArray("canvasRectList");
                  if ((localObject10 != null) && (((JSONArray)localObject10).length() > 0))
                  {
                    j = 0;
                    while (j < ((JSONArray)localObject10).length())
                    {
                      localObject11 = new GridModel();
                      localObject12 = new Rect(0, 0, 720, 1280);
                      localObject13 = ((JSONArray)localObject10).optJSONObject(j);
                      if (localObject13 != null)
                      {
                        ((Rect)localObject12).x = ((int)((org.json.JSONObject)localObject13).optDouble("left", 0.0D));
                        ((Rect)localObject12).y = ((int)((org.json.JSONObject)localObject13).optDouble("top", 0.0D));
                        ((Rect)localObject12).width = ((int)((org.json.JSONObject)localObject13).optDouble("width", 720.0D));
                        ((Rect)localObject12).height = ((int)((org.json.JSONObject)localObject13).optDouble("height", 1280.0D));
                        ((GridModel)localObject11).renderId = ((org.json.JSONObject)localObject13).optInt("renderId", 0);
                        ((GridModel)localObject11).zIndex = ((org.json.JSONObject)localObject13).optInt("zIndex", 0);
                        ((GridModel)localObject11).aspectMode = ((org.json.JSONObject)localObject13).optInt("aspectMode", 0);
                        ((GridModel)localObject11).positionMode = ((org.json.JSONObject)localObject13).optInt("positionMode", 0);
                        ((GridModel)localObject11).transformType = ((org.json.JSONObject)localObject13).optInt("transformType", 0);
                      }
                      ((GridModel)localObject11).canvasRect = ((Rect)localObject12);
                      ((GridSettingModel)localObject8).canvasRectList.add(localObject11);
                      j += 1;
                    }
                    Collections.sort(((GridSettingModel)localObject8).canvasRectList, mGridModelComparator);
                  }
                  ((GridSettingModel)localObject8).canvasRect = ((Rect)localObject9);
                  localFabbyMvPart.gridSettingMap.add(Pair.create(Float.valueOf((String)localObject7), localObject8));
                }
              }
            }
          }
          Collections.sort(localFabbyMvPart.gridSettingMap, mDivideValueCompForObject);
          localFabbyMvPart.gridModeMap.clear();
          localObject2 = ((org.json.JSONObject)localObject1).optJSONObject("gridMode");
          if (localObject2 != null)
          {
            localObject6 = ((org.json.JSONObject)localObject2).keys();
            while (((Iterator)localObject6).hasNext())
            {
              localObject7 = (String)((Iterator)localObject6).next();
              localFabbyMvPart.gridModeMap.add(Pair.create(Float.valueOf((String)localObject7), Integer.valueOf(((org.json.JSONObject)localObject2).optInt((String)localObject7, 0))));
            }
          }
          Collections.sort(localFabbyMvPart.gridModeMap, mDivideValueComp);
          localFabbyMvPart.gridOrderMap.clear();
          localObject1 = ((org.json.JSONObject)localObject1).optJSONObject("gridOrder");
          if (localObject1 != null)
          {
            localObject2 = ((org.json.JSONObject)localObject1).keys();
            while (((Iterator)localObject2).hasNext())
            {
              localObject6 = (String)((Iterator)localObject2).next();
              localFabbyMvPart.gridOrderMap.add(Pair.create(Float.valueOf((String)localObject6), Integer.valueOf(((org.json.JSONObject)localObject1).optInt((String)localObject6, 0))));
            }
          }
          Collections.sort(localFabbyMvPart.gridOrderMap, mDivideValueComp);
        }
        localObject6 = ((org.json.JSONObject)localObject5).optJSONObject("finishTransition");
        int k;
        if (localObject6 != null)
        {
          localObject7 = new StickerItem();
          localObject1 = ((org.json.JSONObject)localObject6).optString("maskVideoFile");
          localObject2 = ((org.json.JSONObject)localObject6).optString("maskImageName");
          j = ((org.json.JSONObject)localObject6).optInt("transitionFunction", 0);
          if ((TextUtils.isEmpty((CharSequence)localObject1)) && (TextUtils.isEmpty((CharSequence)localObject2))) {
            break label3588;
          }
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            break label3513;
          }
          k = ((String)localObject1).lastIndexOf("/");
          ((StickerItem)localObject7).id = ((String)localObject1).substring(k + 1, ((String)localObject1).length());
          ((StickerItem)localObject7).subFolder = ((String)localObject1).substring(0, k);
        }
        for (;;)
        {
          ((StickerItem)localObject7).frames = ((org.json.JSONObject)localObject6).optInt("maskImageCount", 1);
          ((StickerItem)localObject7).frameDuration = (((org.json.JSONObject)localObject6).optDouble("maskImageDuration", 0.0D) / ((StickerItem)localObject7).frames * 1000.0D);
          ((StickerItem)localObject7).triggerType = ((org.json.JSONObject)localObject6).optInt("triggerType", 0);
          if ((((StickerItem)localObject7).triggerType == 1) && (paramVideoMaterial.getItemList() != null) && (paramVideoMaterial.getItemList().size() != 0)) {
            ((StickerItem)localObject7).triggerType = ((StickerItem)paramVideoMaterial.getItemList().get(paramVideoMaterial.getItemList().size() - 1)).triggerType;
          }
          localFabbyMvPart.transitionItem = ((StickerItem)localObject7);
          localFabbyMvPart.transitionDuration = ((((org.json.JSONObject)localObject6).optDouble("duration", 0.0D) * 1000.0D));
          localFabbyMvPart.transitionEase = ((org.json.JSONObject)localObject6).optInt("easeCurve", 0);
          localFabbyMvPart.transitionMaskType = ((org.json.JSONObject)localObject6).optInt("maskType", 1);
          localFabbyMvPart.transitionFunction = j;
          localObject1 = ((org.json.JSONObject)localObject5).optJSONObject("filterEffect");
          if (localObject1 == null) {
            break label3618;
          }
          localFabbyMvPart.filterType = ((org.json.JSONObject)localObject1).optInt("type", 0);
          localFabbyMvPart.filterId = ((org.json.JSONObject)localObject1).optString("filter");
          localFabbyMvPart.lutFile = ((org.json.JSONObject)localObject1).optString("lutFile");
          localFabbyMvPart.filterParamMap.clear();
          localObject1 = ((org.json.JSONObject)localObject1).optJSONObject("param");
          if (localObject1 == null) {
            break label3618;
          }
          localObject2 = ((org.json.JSONObject)localObject1).keys();
          while (((Iterator)localObject2).hasNext())
          {
            localObject5 = (String)((Iterator)localObject2).next();
            localFabbyMvPart.filterParamMap.add(Pair.create(Float.valueOf((String)localObject5), Integer.valueOf(((org.json.JSONObject)localObject1).optInt((String)localObject5, 0))));
          }
          label3513:
          localObject1 = localObject2;
          if (((String)localObject2).endsWith("_")) {
            localObject1 = ((String)localObject2).substring(0, ((String)localObject2).length() - 1);
          }
          k = ((String)localObject1).lastIndexOf("/");
          ((StickerItem)localObject7).id = ((String)localObject1).substring(k + 1, ((String)localObject1).length());
          ((StickerItem)localObject7).subFolder = ((String)localObject1).substring(0, k);
          continue;
          label3588:
          ((StickerItem)localObject7).id = "";
          ((StickerItem)localObject7).subFolder = "";
        }
        Collections.sort(localFabbyMvPart.filterParamMap, mDivideValueComp);
        label3618:
        localFabbyMvPart.duration = ((1000.0D * d));
        localFabbyMvPart.partIndex = i;
        ((List)localObject3).add(localFabbyMvPart);
      }
      i += 1;
    }
    localObject1 = ((org.json.JSONObject)localObject4).optString("bgmAudio", "");
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      paramVideoMaterial.setHasAudio(true);
    }
    paramVideoMaterial.setFabbyParts(new FabbyParts((List)localObject3, (String)localObject1));
    paramJSONObject = paramJSONObject.optJSONArray(VideoMaterialUtil.FIELD.MULTI_VIEWER.value);
    localObject1 = new ArrayList();
    if (paramJSONObject != null)
    {
      i = 0;
      if (i < paramJSONObject.length())
      {
        localObject2 = new MultiViewerItem();
        localObject3 = paramJSONObject.optJSONObject(i);
        if (localObject3 != null)
        {
          ((MultiViewerItem)localObject2).videoMaterial = parseVideoMaterial(paramString, ((org.json.JSONObject)localObject3).optString("importMaterial"), true, paramDecryptListener);
          if (VideoMaterialUtil.isWatermarkMaterial(((MultiViewerItem)localObject2).videoMaterial)) {
            LogicDataManager.getInstance().init(((MultiViewerItem)localObject2).videoMaterial);
          }
          ((MultiViewerItem)localObject2).renderId = ((org.json.JSONObject)localObject3).optInt("renderId");
          localObject4 = ((org.json.JSONObject)localObject3).optJSONArray("activeParts");
          if (localObject4 != null)
          {
            j = 0;
            while (j < ((JSONArray)localObject4).length())
            {
              ((MultiViewerItem)localObject2).activeParts.add(Integer.valueOf(((JSONArray)localObject4).optInt(j)));
              j += 1;
            }
          }
          if (((org.json.JSONObject)localObject3).optInt("needOriginFrame", 1) != 1) {
            break label3909;
          }
        }
        label3909:
        for (boolean bool = true;; bool = false)
        {
          ((MultiViewerItem)localObject2).needOriginFrame = bool;
          ((List)localObject1).add(localObject2);
          i += 1;
          break;
        }
      }
    }
    paramVideoMaterial.setMultiViewerItemList((List)localObject1);
    AppMethodBeat.o(84268);
  }
  
  private static void parseFaceCropParams(org.json.JSONObject paramJSONObject, VideoMaterial paramVideoMaterial)
  {
    int i = 0;
    AppMethodBeat.i(84251);
    try
    {
      Object localObject1 = paramJSONObject.optJSONObject(VideoMaterialUtil.FIELD.FACE_CROP.value);
      if (localObject1 != null)
      {
        paramJSONObject = new FaceCropItem();
        paramJSONObject.frameDuration = ((org.json.JSONObject)localObject1).optInt(VideoMaterialUtil.FACE_CROP_ITEM.FRAME_DURATION.value);
        paramJSONObject.frames = ((org.json.JSONObject)localObject1).optInt(VideoMaterialUtil.FACE_CROP_ITEM.FRAMES.value);
        paramJSONObject.frameList = new ArrayList();
        localObject1 = ((org.json.JSONObject)localObject1).optJSONArray(VideoMaterialUtil.FACE_CROP_ITEM.FRAME_LIST.value);
        if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0)) {
          while (i < ((JSONArray)localObject1).length())
          {
            Object localObject2 = ((JSONArray)localObject1).getJSONObject(i);
            FaceCropItem.CropFrame localCropFrame = new FaceCropItem.CropFrame();
            localCropFrame.faceAngle = ((org.json.JSONObject)localObject2).optDouble(VideoMaterialUtil.FACE_CROP_ITEM_FRAME.FACE_ANGLE.value);
            localCropFrame.faceWidth = ((org.json.JSONObject)localObject2).optDouble(VideoMaterialUtil.FACE_CROP_ITEM_FRAME.FACE_WIDTH.value);
            localCropFrame.index = ((org.json.JSONObject)localObject2).optInt(VideoMaterialUtil.FACE_CROP_ITEM_FRAME.INDEX.value);
            JSONArray localJSONArray = ((org.json.JSONObject)localObject2).optJSONArray(VideoMaterialUtil.FACE_CROP_ITEM_FRAME.NOSE_POINT.value);
            if ((localJSONArray != null) && (localJSONArray.length() > 0))
            {
              localCropFrame.noseX = localJSONArray.getDouble(0);
              localCropFrame.noseY = localJSONArray.getDouble(1);
            }
            localObject2 = ((org.json.JSONObject)localObject2).optJSONArray(VideoMaterialUtil.FACE_CROP_ITEM_FRAME.SIZE.value);
            if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0))
            {
              localCropFrame.width = ((JSONArray)localObject2).getDouble(0);
              localCropFrame.height = ((JSONArray)localObject2).getDouble(1);
            }
            paramJSONObject.frameList.add(localCropFrame);
            i += 1;
          }
        }
        paramVideoMaterial.setFaceCropItem(paramJSONObject);
      }
      AppMethodBeat.o(84251);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      LogUtils.e(TAG, paramJSONObject);
      AppMethodBeat.o(84251);
    }
  }
  
  private static void parseFaceExpressionParams(org.json.JSONObject paramJSONObject, VideoMaterial paramVideoMaterial, boolean[] paramArrayOfBoolean)
  {
    AppMethodBeat.i(84252);
    org.json.JSONObject localJSONObject = paramJSONObject.optJSONObject(VideoMaterialUtil.FIELD.FACE_EXPRESSION.value);
    if (localJSONObject != null)
    {
      paramJSONObject = new FaceExpression();
      paramJSONObject.id = localJSONObject.optString(VideoMaterialUtil.FACE_EXPRESSION_ITEM_FILED.ID.value);
      paramJSONObject.videoID = localJSONObject.optString(VideoMaterialUtil.FACE_EXPRESSION_ITEM_FILED.VIDEO_ID.value);
      paramJSONObject.frameDuration = localJSONObject.optDouble(VideoMaterialUtil.FACE_EXPRESSION_ITEM_FILED.FRAME_DURATION.value);
      paramJSONObject.frames = localJSONObject.optInt(VideoMaterialUtil.FACE_EXPRESSION_ITEM_FILED.FRAMES.value);
      paramJSONObject.audioID = localJSONObject.optString(VideoMaterialUtil.FACE_EXPRESSION_ITEM_FILED.AUDIO_ID.value);
      int k;
      int i;
      Object localObject1;
      Object localObject2;
      if (!TextUtils.isEmpty(paramJSONObject.audioID))
      {
        k = 1;
        paramArrayOfBoolean[0] = k;
        paramArrayOfBoolean = localJSONObject.optJSONArray(VideoMaterialUtil.FACE_EXPRESSION_ITEM_FILED.CANVAS_SIZE.value);
        if ((paramArrayOfBoolean != null) && (paramArrayOfBoolean.length() == 2))
        {
          paramJSONObject.canvasSize = new SizeI();
          paramJSONObject.canvasSize.width = paramArrayOfBoolean.optInt(0);
          paramJSONObject.canvasSize.height = paramArrayOfBoolean.optInt(1);
        }
        paramJSONObject.canvasResizeMode = localJSONObject.optInt(VideoMaterialUtil.FACE_EXPRESSION_ITEM_FILED.CANVAS_RESIZE_MODE.value);
        paramJSONObject.scoreImageID = localJSONObject.optString(VideoMaterialUtil.FACE_EXPRESSION_ITEM_FILED.SCORE_IMAGE_ID.value);
        paramJSONObject.expressionNumber = localJSONObject.optInt(VideoMaterialUtil.FACE_EXPRESSION_ITEM_FILED.EXPRESSION_NUMBER.value);
        paramArrayOfBoolean = localJSONObject.optJSONArray(VideoMaterialUtil.FACE_EXPRESSION_ITEM_FILED.EXPRESSION_LIST.value);
        if (paramArrayOfBoolean != null)
        {
          paramJSONObject.expressionList = new ArrayList();
          i = 0;
        }
      }
      else
      {
        for (;;)
        {
          if (i >= paramArrayOfBoolean.length()) {
            break label676;
          }
          localObject1 = new ExpressionItem();
          localObject2 = paramArrayOfBoolean.optJSONObject(i);
          if (localObject2 != null)
          {
            ((ExpressionItem)localObject1).expressionTime = ((org.json.JSONObject)localObject2).optInt(VideoMaterialUtil.EXPRESSION_ITEM_FILED.EXPRESSION_TIME.value);
            ((ExpressionItem)localObject1).expressionID = ((org.json.JSONObject)localObject2).optString(VideoMaterialUtil.EXPRESSION_ITEM_FILED.EXPRESSION_ID.value);
            JSONArray localJSONArray = ((org.json.JSONObject)localObject2).optJSONArray(VideoMaterialUtil.EXPRESSION_ITEM_FILED.EXPRESSION_FEAT_SIZE.value);
            if ((localJSONArray != null) && (localJSONArray.length() == 2))
            {
              ((ExpressionItem)localObject1).expressionFeatSize = new SizeI();
              ((ExpressionItem)localObject1).expressionFeatSize.width = localJSONArray.optInt(0);
              ((ExpressionItem)localObject1).expressionFeatSize.height = localJSONArray.optInt(1);
            }
            localJSONArray = ((org.json.JSONObject)localObject2).optJSONArray(VideoMaterialUtil.EXPRESSION_ITEM_FILED.EXPRESSION_FEAT.value);
            int j;
            if (localJSONArray != null)
            {
              ((ExpressionItem)localObject1).expressionFeat = new ArrayList();
              j = 0;
              for (;;)
              {
                if (j < localJSONArray.length() / 2)
                {
                  ((ExpressionItem)localObject1).expressionFeat.add(new PointF(localJSONArray.optInt(j * 2), localJSONArray.optInt(j * 2 + 1)));
                  j += 1;
                  continue;
                  k = 0;
                  break;
                }
              }
            }
            localJSONArray = ((org.json.JSONObject)localObject2).optJSONArray(VideoMaterialUtil.EXPRESSION_ITEM_FILED.EXPRESSION_ANGLE.value);
            if ((localJSONArray != null) && (localJSONArray.length() == 3))
            {
              ((ExpressionItem)localObject1).expressionAngle = new float[3];
              ((ExpressionItem)localObject1).expressionAngle[0] = ((float)localJSONArray.optDouble(0));
              ((ExpressionItem)localObject1).expressionAngle[1] = ((float)localJSONArray.optDouble(1));
              ((ExpressionItem)localObject1).expressionAngle[2] = ((float)localJSONArray.optDouble(2));
            }
            ((ExpressionItem)localObject1).scoreImageID = ((org.json.JSONObject)localObject2).optString(VideoMaterialUtil.EXPRESSION_ITEM_FILED.SCORE_IMAGE_ID.value);
            localObject2 = ((org.json.JSONObject)localObject2).optJSONArray(VideoMaterialUtil.EXPRESSION_ITEM_FILED.EXPRESSION_WEIGHT.value);
            if ((localObject2 != null) && (((JSONArray)localObject2).length() == 7))
            {
              ((ExpressionItem)localObject1).expressionWeight = new double[7];
              j = 0;
            }
            while (j < 7)
            {
              ((ExpressionItem)localObject1).expressionWeight[j] = ((JSONArray)localObject2).optDouble(j);
              j += 1;
              continue;
              ((ExpressionItem)localObject1).expressionWeight = ActUtil.WEIGHT;
            }
            paramJSONObject.expressionList.add(localObject1);
          }
          i += 1;
        }
      }
      label676:
      paramArrayOfBoolean = localJSONObject.optJSONArray(VideoMaterialUtil.FACE_EXPRESSION_ITEM_FILED.CANVAS_ITEM_LIST.value);
      if (paramArrayOfBoolean != null)
      {
        paramJSONObject.canvasItemList = new ArrayList();
        i = 0;
        while (i < paramArrayOfBoolean.length())
        {
          localJSONObject = paramArrayOfBoolean.optJSONObject(i);
          if (localJSONObject != null)
          {
            localObject1 = new CanvasItem();
            ((CanvasItem)localObject1).type = localJSONObject.optInt(VideoMaterialUtil.CANVAS_ITEM_FILED.TYPE.value);
            ((CanvasItem)localObject1).index = localJSONObject.optInt(VideoMaterialUtil.CANVAS_ITEM_FILED.INDEX.value);
            ((CanvasItem)localObject1).startTime = localJSONObject.optInt(VideoMaterialUtil.CANVAS_ITEM_FILED.START_TIME.value);
            ((CanvasItem)localObject1).endTime = localJSONObject.optInt(VideoMaterialUtil.CANVAS_ITEM_FILED.END_TIME.value);
            ((CanvasItem)localObject1).zIndex = localJSONObject.optInt(VideoMaterialUtil.CANVAS_ITEM_FILED.Z_INDEX.value);
            localObject2 = localJSONObject.optJSONArray(VideoMaterialUtil.CANVAS_ITEM_FILED.ITEM_RECT.value);
            if ((localObject2 != null) && (((JSONArray)localObject2).length() == 4))
            {
              ((CanvasItem)localObject1).itemRect = new Rect();
              ((CanvasItem)localObject1).itemRect.x = ((JSONArray)localObject2).optInt(0);
              ((CanvasItem)localObject1).itemRect.y = ((JSONArray)localObject2).optInt(1);
              ((CanvasItem)localObject1).itemRect.width = ((JSONArray)localObject2).optInt(2);
              ((CanvasItem)localObject1).itemRect.height = ((JSONArray)localObject2).optInt(3);
            }
            ((CanvasItem)localObject1).itemResizeMode = localJSONObject.optInt(VideoMaterialUtil.CANVAS_ITEM_FILED.ITEM_RESIZE_MODE.value);
            paramJSONObject.canvasItemList.add(localObject1);
          }
          i += 1;
        }
      }
      paramVideoMaterial.setFaceExpression(paramJSONObject);
    }
    AppMethodBeat.o(84252);
  }
  
  private static FaceFeatureItem parseFaceFeatureItem(String paramString, org.json.JSONObject paramJSONObject, VideoMaterial paramVideoMaterial, DecryptListener paramDecryptListener)
  {
    AppMethodBeat.i(84247);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(84247);
      return null;
    }
    FaceFeatureItem localFaceFeatureItem = new FaceFeatureItem();
    localFaceFeatureItem.setId(paramJSONObject.optString("id"));
    localFaceFeatureItem.setMaskAnchorPoint(paramJSONObject.optInt("maskAnchorPoint", -1));
    if (paramString.endsWith("/")) {}
    for (;;)
    {
      localFaceFeatureItem.setDataPath(paramString);
      Object localObject2 = paramJSONObject.optString("distortionFile");
      int i;
      Object localObject1;
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        i = ((String)localObject2).lastIndexOf(".");
        localObject1 = localObject2;
        if (i >= 0) {
          localObject1 = ((String)localObject2).substring(0, i);
        }
        localObject1 = parseVideoMaterialFileAsJSONObject(paramString, (String)localObject1, true, paramDecryptListener);
        if (localObject1 != null)
        {
          localObject1 = ((org.json.JSONObject)localObject1).optJSONArray("distortionList");
          if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
          {
            localObject1 = parseDistortionItemListParams((JSONArray)localObject1);
            if (localObject1 != null) {
              localFaceFeatureItem.setDistortionItemList((List)localObject1);
            }
          }
        }
      }
      localObject2 = paramJSONObject.optString("faceOffFile");
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        i = ((String)localObject2).lastIndexOf(".");
        localObject1 = localObject2;
        if (i >= 0) {
          localObject1 = ((String)localObject2).substring(0, i);
        }
        localObject1 = parseVideoMaterialFileAsJSONObject(paramString, (String)localObject1, true, paramDecryptListener);
        if (localObject1 != null)
        {
          localObject2 = new JSONArray();
          ((JSONArray)localObject2).put(localObject1);
          localObject1 = parseFaceOffItemListParams((JSONArray)localObject2);
          if (localObject1 != null) {
            localFaceFeatureItem.setFaceOffItemList((List)localObject1);
          }
        }
      }
      paramJSONObject = paramJSONObject.optJSONArray("itemList");
      if (paramJSONObject != null)
      {
        paramString = parseItemListParams(paramString, paramJSONObject, VideoFilterFactory.STICKER_TYPE.FACE_FEATURE.type, paramVideoMaterial, paramVideoMaterial.getBlendMode(), null, null, paramDecryptListener);
        if (paramString != null)
        {
          Collections.sort(paramString, new VideoTemplateParser.2());
          localFaceFeatureItem.setStickerItems(paramString);
        }
      }
      AppMethodBeat.o(84247);
      return localFaceFeatureItem;
      paramString = paramString + "/" + localFaceFeatureItem.getId();
    }
  }
  
  private static void parseFaceFeatureItemListParams(String paramString, org.json.JSONObject paramJSONObject, VideoMaterial paramVideoMaterial, DecryptListener paramDecryptListener)
  {
    AppMethodBeat.i(84246);
    paramJSONObject = paramJSONObject.optJSONArray("faceFeatureItemList");
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(84246);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramJSONObject.length())
    {
      Object localObject = paramJSONObject.optJSONObject(i);
      if (localObject != null)
      {
        localObject = parseFaceFeatureItem(paramString, (org.json.JSONObject)localObject, paramVideoMaterial, paramDecryptListener);
        if (localObject != null) {
          localArrayList.add(localObject);
        }
      }
      i += 1;
    }
    paramVideoMaterial.setFaceFeatureItemList(localArrayList);
    AppMethodBeat.o(84246);
  }
  
  private static void parseFaceImageLayerParams(org.json.JSONObject paramJSONObject, VideoMaterial paramVideoMaterial)
  {
    int j = 0;
    AppMethodBeat.i(84254);
    paramJSONObject = paramJSONObject.optJSONObject("faceAverage");
    if (paramJSONObject != null)
    {
      FaceImageLayer localFaceImageLayer = new FaceImageLayer();
      localFaceImageLayer.width = paramJSONObject.optDouble("width");
      localFaceImageLayer.height = paramJSONObject.optDouble("height");
      localFaceImageLayer.x = paramJSONObject.optDouble("x");
      localFaceImageLayer.y = paramJSONObject.optDouble("y");
      localFaceImageLayer.type = paramJSONObject.optInt("type");
      localFaceImageLayer.imagePath = paramJSONObject.optString("image");
      JSONArray localJSONArray = paramJSONObject.optJSONArray("imageFacePoint");
      ArrayList localArrayList;
      int i;
      if (localJSONArray != null)
      {
        localArrayList = new ArrayList();
        i = 0;
        while (i < localJSONArray.length())
        {
          localArrayList.add(Double.valueOf(localJSONArray.optDouble(i)));
          i += 1;
        }
        localFaceImageLayer.imageFacePoint = localArrayList;
      }
      localJSONArray = paramJSONObject.optJSONArray("imageFaceColor");
      if (localJSONArray != null)
      {
        localArrayList = new ArrayList();
        i = 0;
        while (i < localJSONArray.length())
        {
          localArrayList.add(Double.valueOf(localJSONArray.optDouble(i)));
          i += 1;
        }
        localFaceImageLayer.imageFaceColor = localArrayList;
      }
      localJSONArray = paramJSONObject.optJSONArray("imageFaceColor2");
      if (localJSONArray != null)
      {
        localArrayList = new ArrayList();
        i = 0;
        while (i < localJSONArray.length())
        {
          localArrayList.add(Double.valueOf(localJSONArray.optDouble(i)));
          i += 1;
        }
        localFaceImageLayer.imageFaceColor2 = localArrayList;
      }
      localJSONArray = paramJSONObject.optJSONArray("faceColorRange");
      if (localJSONArray != null)
      {
        localArrayList = new ArrayList();
        i = 0;
        while (i < localJSONArray.length())
        {
          localArrayList.add(Double.valueOf(localJSONArray.optDouble(i)));
          i += 1;
        }
        localFaceImageLayer.faceColorRange = localArrayList;
      }
      localFaceImageLayer.blendAlpha = paramJSONObject.optDouble("blendAlpha", 0.5D);
      localFaceImageLayer.distortionAlpha = paramJSONObject.optDouble("distortionAlpha", 0.5D);
      localJSONArray = paramJSONObject.optJSONArray("distortionList");
      if (localJSONArray != null)
      {
        localArrayList = new ArrayList();
        i = 0;
        while (i < localJSONArray.length())
        {
          Object localObject = localJSONArray.opt(i);
          if ((localObject instanceof org.json.JSONObject))
          {
            localObject = (org.json.JSONObject)localObject;
            DistortionItem localDistortionItem = new DistortionItem();
            localDistortionItem.position = ((org.json.JSONObject)localObject).optInt(VideoMaterialUtil.DISTORTION_ITEM_FILED.POSITION.value);
            localDistortionItem.distortion = ((org.json.JSONObject)localObject).optInt(VideoMaterialUtil.DISTORTION_ITEM_FILED.DISTORTION.value);
            localDistortionItem.direction = ((org.json.JSONObject)localObject).optInt(VideoMaterialUtil.DISTORTION_ITEM_FILED.DIRECTION.value);
            localDistortionItem.radius = ((float)((org.json.JSONObject)localObject).optDouble(VideoMaterialUtil.DISTORTION_ITEM_FILED.RADIUS.value));
            localDistortionItem.strength = ((float)((org.json.JSONObject)localObject).optDouble(VideoMaterialUtil.DISTORTION_ITEM_FILED.STRENGH.value));
            localDistortionItem.x = ((org.json.JSONObject)localObject).optInt(VideoMaterialUtil.DISTORTION_ITEM_FILED.X.value, 0);
            localDistortionItem.y = ((org.json.JSONObject)localObject).optInt(VideoMaterialUtil.DISTORTION_ITEM_FILED.Y.value, 0);
            localArrayList.add(localDistortionItem);
          }
          i += 1;
        }
        localFaceImageLayer.distortionList = localArrayList;
      }
      localFaceImageLayer.faceMaskImagePath = paramJSONObject.optString("faceMaskImage", null);
      localJSONArray = paramJSONObject.optJSONArray("faceMaskFacePoint");
      if (localJSONArray != null)
      {
        localArrayList = new ArrayList();
        i = 0;
        while (i < localJSONArray.length())
        {
          localArrayList.add(Double.valueOf(localJSONArray.optDouble(i)));
          i += 1;
        }
        localFaceImageLayer.faceMaskFacePoint = localArrayList;
      }
      localJSONArray = paramJSONObject.optJSONArray("faceTriangle");
      if (localJSONArray != null)
      {
        localArrayList = new ArrayList();
        i = j;
        while (i < localJSONArray.length())
        {
          localArrayList.add(Integer.valueOf(localJSONArray.optInt(i)));
          i += 1;
        }
        localFaceImageLayer.faceTriangle = localArrayList;
      }
      localFaceImageLayer.antiWrinkle = paramJSONObject.optDouble("antiWrinkle");
      paramVideoMaterial.setFaceImageLayer(localFaceImageLayer);
    }
    AppMethodBeat.o(84254);
  }
  
  private static void parseFaceMeshItemListParams(org.json.JSONObject paramJSONObject, VideoMaterial paramVideoMaterial)
  {
    AppMethodBeat.i(84255);
    paramJSONObject = paramJSONObject.optJSONArray(VideoMaterialUtil.FIELD.FACE_MESH_ITEM_LIST.value);
    if (paramJSONObject != null)
    {
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      if (i < paramJSONObject.length())
      {
        org.json.JSONObject localJSONObject1 = paramJSONObject.optJSONObject(i);
        FaceMeshItem localFaceMeshItem;
        if (localJSONObject1 != null)
        {
          localFaceMeshItem = new FaceMeshItem();
          localFaceMeshItem.id = localJSONObject1.optString(VideoMaterialUtil.FACE_MESH_ITEM_LIST.ID.value);
          localFaceMeshItem.personID = localJSONObject1.optInt(VideoMaterialUtil.FACE_MESH_ITEM_LIST.PERSON_ID.value, -1);
          localFaceMeshItem.frames = localJSONObject1.optInt(VideoMaterialUtil.FACE_MESH_ITEM_LIST.FRAMES.value);
          org.json.JSONObject localJSONObject2 = localJSONObject1.optJSONObject(VideoMaterialUtil.FIELD.CHARM_RANGE.value);
          if (localJSONObject2 != null)
          {
            localFaceMeshItem.charmRange = new CharmRange();
            localFaceMeshItem.charmRange.min = localJSONObject2.optDouble(VideoMaterialUtil.CHARM_RANGE_FIELD.MIN.value);
            localFaceMeshItem.charmRange.max = localJSONObject2.optDouble(VideoMaterialUtil.CHARM_RANGE_FIELD.MAX.value);
          }
          localFaceMeshItem.frameType = localJSONObject1.optInt("frameType");
          localFaceMeshItem.frameDuration = localJSONObject1.optDouble("frameDuration");
          localFaceMeshItem.triggerType = Math.max(localJSONObject1.optInt("triggerType"), 2);
          if (VideoMaterialUtil.isActionTriggerType(localFaceMeshItem.triggerType)) {
            paramVideoMaterial.setTriggerType(localFaceMeshItem.triggerType);
          }
          if (localJSONObject1.optInt("alwaysTriggered") != 1) {
            break label349;
          }
        }
        label349:
        for (boolean bool = true;; bool = false)
        {
          localFaceMeshItem.alwaysTriggered = bool;
          localFaceMeshItem.featureStatType = localJSONObject1.optInt("featureStatType");
          localJSONObject1 = localJSONObject1.optJSONObject("featureStatValueRange");
          if (localJSONObject1 != null)
          {
            localFaceMeshItem.featureStatValueRange = new StickerItem.ValueRange();
            localFaceMeshItem.featureStatValueRange.min = localJSONObject1.optDouble("min");
            localFaceMeshItem.featureStatValueRange.max = localJSONObject1.optDouble("max");
          }
          localArrayList.add(localFaceMeshItem);
          i += 1;
          break;
        }
      }
      paramVideoMaterial.setFaceMeshItemList(localArrayList);
    }
    AppMethodBeat.o(84255);
  }
  
  private static void parseFaceMoveItemListParams(org.json.JSONObject paramJSONObject, VideoMaterial paramVideoMaterial)
  {
    AppMethodBeat.i(84260);
    try
    {
      ArrayList localArrayList = new ArrayList();
      paramJSONObject = paramJSONObject.optJSONArray(VideoMaterialUtil.FIELD.FACE_MOVE_LIST.value);
      if (paramJSONObject != null)
      {
        int i = 0;
        while (i < paramJSONObject.length())
        {
          FaceMoveItem localFaceMoveItem = new FaceMoveItem();
          org.json.JSONObject localJSONObject = paramJSONObject.getJSONObject(i);
          localFaceMoveItem.position = localJSONObject.optInt(VideoMaterialUtil.FACE_MOVE_ITEM_FILED.POSITION.value);
          localFaceMoveItem.pos1 = localJSONObject.optInt(VideoMaterialUtil.FACE_MOVE_ITEM_FILED.POS1.value);
          localFaceMoveItem.pos2 = localJSONObject.optInt(VideoMaterialUtil.FACE_MOVE_ITEM_FILED.POS2.value);
          localFaceMoveItem.ratio1 = ((float)localJSONObject.optDouble(VideoMaterialUtil.FACE_MOVE_ITEM_FILED.RATIO1.value));
          localFaceMoveItem.ratio2 = ((float)localJSONObject.optDouble(VideoMaterialUtil.FACE_MOVE_ITEM_FILED.RATIO2.value));
          localFaceMoveItem.dx = localJSONObject.optInt(VideoMaterialUtil.FACE_MOVE_ITEM_FILED.X.value);
          localFaceMoveItem.dy = localJSONObject.optInt(VideoMaterialUtil.FACE_MOVE_ITEM_FILED.Y.value);
          localArrayList.add(localFaceMoveItem);
          i += 1;
        }
        paramVideoMaterial.setFaceMoveItemList(localArrayList);
      }
      AppMethodBeat.o(84260);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      LogUtils.e(TAG, paramJSONObject);
      AppMethodBeat.o(84260);
    }
  }
  
  private static void parseFaceMoveTrianglesParams(org.json.JSONObject paramJSONObject, VideoMaterial paramVideoMaterial)
  {
    AppMethodBeat.i(84259);
    try
    {
      paramJSONObject = paramJSONObject.optJSONArray(VideoMaterialUtil.FIELD.FACE_MOVE_TRIANGLE.value);
      if (paramJSONObject != null)
      {
        int[] arrayOfInt = new int[paramJSONObject.length()];
        int i = 0;
        while (i < paramJSONObject.length())
        {
          arrayOfInt[i] = paramJSONObject.getInt(i);
          i += 1;
        }
        paramVideoMaterial.setFaceMoveTriangles(arrayOfInt);
      }
      AppMethodBeat.o(84259);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      LogUtils.e(TAG, paramJSONObject);
      AppMethodBeat.o(84259);
    }
  }
  
  private static List<FaceItem> parseFaceOffItemListParams(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(84256);
    ArrayList localArrayList1 = new ArrayList();
    if (paramJSONArray != null)
    {
      int k = 0;
      int j = 0;
      int i = -1;
      Object localObject1;
      if (k < paramJSONArray.length())
      {
        localObject1 = paramJSONArray.optJSONObject(k);
        int n = j;
        int m = i;
        FaceItem localFaceItem;
        boolean bool;
        if (localObject1 != null)
        {
          localFaceItem = new FaceItem();
          localFaceItem.id = ((org.json.JSONObject)localObject1).optString(VideoMaterialUtil.FACE_OFF_ITEM_FIELD.ID.value);
          localFaceItem.faceExchangeImage = ((org.json.JSONObject)localObject1).optString(VideoMaterialUtil.FACE_OFF_ITEM_FIELD.FACE_EXCHANGE_IMAGE.value);
          localFaceItem.irisImage = ((org.json.JSONObject)localObject1).optString(VideoMaterialUtil.FACE_OFF_ITEM_FIELD.IRIS_IMAGE.value);
          localFaceItem.blendAlpha = ((float)((org.json.JSONObject)localObject1).optDouble(VideoMaterialUtil.FACE_OFF_ITEM_FIELD.BLEND_ALPHA.value));
          localFaceItem.featureType = FaceOffUtil.getFeatureType(((org.json.JSONObject)localObject1).optInt(VideoMaterialUtil.FACE_OFF_ITEM_FIELD.FEATURE_TYPE.value));
          localFaceItem.grayScale = ((org.json.JSONObject)localObject1).optInt(VideoMaterialUtil.FACE_OFF_ITEM_FIELD.GRAY_SCALE.value);
          localFaceItem.blendMode = ((org.json.JSONObject)localObject1).optInt(VideoMaterialUtil.FACE_OFF_ITEM_FIELD.BLEND_MODE.value);
          localFaceItem.personID = ((org.json.JSONObject)localObject1).optInt(VideoMaterialUtil.FACE_OFF_ITEM_FIELD.PERSON_ID.value, -1);
          localFaceItem.randomGroupNum = ((org.json.JSONObject)localObject1).optInt(VideoMaterialUtil.FACE_OFF_ITEM_FIELD.RANDOM_GROUP_NUM.value);
          Object localObject2 = ((org.json.JSONObject)localObject1).optJSONArray(VideoMaterialUtil.FACE_OFF_ITEM_FIELD.FACE_POINTS.value);
          if (localObject2 != null)
          {
            ArrayList localArrayList2 = new ArrayList();
            m = 0;
            while (m < ((JSONArray)localObject2).length())
            {
              localArrayList2.add(Float.valueOf((float)((JSONArray)localObject2).optDouble(m)));
              m += 1;
            }
            localFaceItem.facePoints = localArrayList2;
          }
          localObject2 = ((org.json.JSONObject)localObject1).optJSONObject(VideoMaterialUtil.FIELD.CHARM_RANGE.value);
          if (localObject2 != null)
          {
            localFaceItem.charmRange = new CharmRange();
            localFaceItem.charmRange.min = ((org.json.JSONObject)localObject2).optDouble(VideoMaterialUtil.CHARM_RANGE_FIELD.MIN.value);
            localFaceItem.charmRange.max = ((org.json.JSONObject)localObject2).optDouble(VideoMaterialUtil.CHARM_RANGE_FIELD.MAX.value);
          }
          localFaceItem.frameType = ((org.json.JSONObject)localObject1).optInt(VideoMaterialUtil.FACE_OFF_ITEM_FIELD.FRAME_TYPE.value);
          localFaceItem.frames = ((org.json.JSONObject)localObject1).optInt(VideoMaterialUtil.FACE_OFF_ITEM_FIELD.FRAMES.value);
          localFaceItem.frameDuration = ((org.json.JSONObject)localObject1).optInt(VideoMaterialUtil.FACE_OFF_ITEM_FIELD.FRAME_DURATION.value);
          localFaceItem.width = ((org.json.JSONObject)localObject1).optInt("width");
          localFaceItem.height = ((org.json.JSONObject)localObject1).optInt("height");
          localFaceItem.triggerType = ((org.json.JSONObject)localObject1).optInt(VideoMaterialUtil.FACE_OFF_ITEM_FIELD.TRIGGER_TYPE.value, PTFaceAttr.PTExpression.FACE_DETECT.value);
          if (((org.json.JSONObject)localObject1).optInt("alwaysTriggered", 1) != 1) {
            break label658;
          }
          bool = true;
          label464:
          localFaceItem.alwaysTriggered = bool;
          localFaceItem.featureStatType = ((org.json.JSONObject)localObject1).optInt("featureStatType");
          localObject2 = ((org.json.JSONObject)localObject1).optJSONObject("featureStatValueRange");
          if (localObject2 != null)
          {
            localFaceItem.featureStatValueRange = new StickerItem.ValueRange();
            localFaceItem.featureStatValueRange.min = ((org.json.JSONObject)localObject2).optDouble("min");
            localFaceItem.featureStatValueRange.max = ((org.json.JSONObject)localObject2).optDouble("max");
          }
          localFaceItem.activateTriggerType = ((org.json.JSONObject)localObject1).optInt("activateTriggerType", 0);
          localFaceItem.activateTriggerCount = ((org.json.JSONObject)localObject1).optInt("activateTriggerCount", 0);
          localFaceItem.activateTriggerTotalCount = ((org.json.JSONObject)localObject1).optInt("activateTriggerTotalCount", 0);
          localFaceItem.playCount = ((org.json.JSONObject)localObject1).optInt("playCount");
          localFaceItem.preTriggerType = localFaceItem.triggerType;
          localFaceItem.countTriggerType = localFaceItem.triggerType;
          if (i != -1) {
            break label664;
          }
          i = localFaceItem.triggerType;
        }
        for (;;)
        {
          localArrayList1.add(localFaceItem);
          m = i;
          n = j;
          k += 1;
          j = n;
          i = m;
          break;
          label658:
          bool = false;
          break label464;
          label664:
          j = Math.max(j, localFaceItem.triggerType);
        }
      }
      paramJSONArray = localArrayList1.iterator();
      while (paramJSONArray.hasNext())
      {
        localObject1 = (FaceItem)paramJSONArray.next();
        ((FaceItem)localObject1).preTriggerType = i;
        ((FaceItem)localObject1).countTriggerType = j;
      }
    }
    AppMethodBeat.o(84256);
    return localArrayList1;
  }
  
  private static void parseFacePointsListParams(org.json.JSONObject paramJSONObject, VideoMaterial paramVideoMaterial)
  {
    AppMethodBeat.i(84258);
    paramJSONObject = paramJSONObject.optJSONArray(VideoMaterialUtil.FIELD.FACE_POINTS_LIST.value);
    ArrayList localArrayList = new ArrayList();
    if (paramJSONObject != null)
    {
      int i = 0;
      while (i < paramJSONObject.length())
      {
        localArrayList.add(Float.valueOf((float)paramJSONObject.optDouble(i)));
        i += 1;
      }
      paramVideoMaterial.setFacePoints(localArrayList);
    }
    AppMethodBeat.o(84258);
  }
  
  private static void parseFilterEffectParams(org.json.JSONObject paramJSONObject, VideoMaterial paramVideoMaterial)
  {
    AppMethodBeat.i(84257);
    paramJSONObject = paramJSONObject.optJSONObject(VideoMaterialUtil.FIELD.FILTER_EFFECT.value);
    if (paramJSONObject != null)
    {
      VideoFilterEffect localVideoFilterEffect = new VideoFilterEffect();
      localVideoFilterEffect.type = paramJSONObject.optInt(VideoMaterialUtil.FILTER_EFFECT_FIELD.TYPE.value);
      localVideoFilterEffect.order = paramJSONObject.optInt(VideoMaterialUtil.FILTER_EFFECT_FIELD.ORDER.value);
      paramVideoMaterial.setVideoFilterEffect(localVideoFilterEffect);
    }
    AppMethodBeat.o(84257);
  }
  
  private static void parseGameParams(org.json.JSONObject paramJSONObject, VideoMaterial paramVideoMaterial)
  {
    boolean bool2 = true;
    AppMethodBeat.i(84266);
    GameParams localGameParams = new GameParams();
    localGameParams.mGameName = paramJSONObject.optString(VideoMaterialUtil.GAME_FIELD.GAME_NAME.value);
    localGameParams.mAnimNames = paramJSONObject.optString(VideoMaterialUtil.GAME_FIELD.ANIM_NAMES.value);
    localGameParams.mAnimDefaultRotate = paramJSONObject.optString(VideoMaterialUtil.GAME_FIELD.ANIM_DEFAULT_ROTATE.value);
    localGameParams.mAnimNodeNames = paramJSONObject.optString(VideoMaterialUtil.GAME_FIELD.ANIM_NODE_NAMES.value);
    localGameParams.mRunningAnimName = paramJSONObject.optString(VideoMaterialUtil.GAME_FIELD.RUNNING_ANIM_NAME.value);
    localGameParams.mRunningAnimDefaultRotate = paramJSONObject.optString(VideoMaterialUtil.GAME_FIELD.RUNNING_ANIM_DEFAULT_ROTATE.value);
    JSONArray localJSONArray = paramJSONObject.optJSONArray(VideoMaterialUtil.GAME_FIELD.TEXTURE_IMAGES.value);
    if ((localJSONArray != null) && (localJSONArray.length() > 0))
    {
      localGameParams.textureImages = new String[localJSONArray.length()];
      int i = 0;
      while (i < localJSONArray.length())
      {
        localGameParams.textureImages[i] = localJSONArray.optString(i);
        i += 1;
      }
      localGameParams.usePreload = true;
    }
    localGameParams.fov = ((float)paramJSONObject.optDouble(VideoMaterialUtil.GAME_FIELD.FOV.value, 60.0D));
    if (paramJSONObject.optInt(VideoMaterialUtil.GAME_FIELD.NOT_FLATTEN_EAR.value, 0) == 0)
    {
      bool1 = true;
      localGameParams.flattenEar = bool1;
      if (paramJSONObject.optInt(VideoMaterialUtil.GAME_FIELD.NOT_FLATTEN_NOSE.value, 0) != 0) {
        break label265;
      }
    }
    label265:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localGameParams.flattenNose = bool1;
      paramVideoMaterial.setGameParams(localGameParams);
      AppMethodBeat.o(84266);
      return;
      bool1 = false;
      break;
    }
  }
  
  private static void parseHeadCropItemListParams(org.json.JSONObject paramJSONObject, VideoMaterial paramVideoMaterial)
  {
    AppMethodBeat.i(84262);
    for (;;)
    {
      int j;
      try
      {
        ArrayList localArrayList = new ArrayList();
        paramJSONObject = paramJSONObject.optJSONArray(VideoMaterialUtil.FIELD.FACE_HEAD_CROP_ITEM_LIST.value);
        if (paramJSONObject != null)
        {
          int k = -1;
          int i = 0;
          j = 0;
          Object localObject;
          if (j < paramJSONObject.length())
          {
            localObject = paramJSONObject.getJSONObject(j);
            StickerItem localStickerItem = new StickerItem();
            localStickerItem.id = ((org.json.JSONObject)localObject).optString("id");
            localStickerItem.subFolder = localStickerItem.id;
            localStickerItem.type = ((org.json.JSONObject)localObject).optInt("type");
            localStickerItem.triggerType = ((org.json.JSONObject)localObject).optInt("triggerType");
            if (((org.json.JSONObject)localObject).optInt("alwaysTriggered") != 1) {
              break label595;
            }
            bool = true;
            localStickerItem.alwaysTriggered = bool;
            localStickerItem.featureStatType = ((org.json.JSONObject)localObject).optInt("featureStatType");
            localStickerItem.playCount = ((org.json.JSONObject)localObject).optInt("playCount");
            if (VideoMaterialUtil.isActionTriggerType(localStickerItem.triggerType)) {
              paramVideoMaterial.setTriggerType(localStickerItem.triggerType);
            }
            localStickerItem.frameType = ((org.json.JSONObject)localObject).optInt("frameType");
            localStickerItem.frameDuration = ((org.json.JSONObject)localObject).optDouble("frameDuration");
            localStickerItem.frames = ((org.json.JSONObject)localObject).optInt("frames");
            localStickerItem.width = ((org.json.JSONObject)localObject).optInt("width");
            localStickerItem.height = ((org.json.JSONObject)localObject).optInt("height");
            JSONArray localJSONArray = ((org.json.JSONObject)localObject).optJSONArray("position");
            int m;
            if (localJSONArray != null)
            {
              localStickerItem.position = new double[localJSONArray.length()];
              m = 0;
              if (m < localJSONArray.length())
              {
                localStickerItem.position[m] = localJSONArray.getDouble(m);
                m += 1;
                continue;
              }
            }
            else
            {
              localStickerItem.position = new double[] { 0.0D, 0.0D };
            }
            localJSONArray = ((org.json.JSONObject)localObject).optJSONArray("scalePivots");
            if (localJSONArray != null)
            {
              localStickerItem.scalePivots = new int[localJSONArray.length()];
              m = 0;
              if (m < localJSONArray.length())
              {
                localStickerItem.scalePivots[m] = localJSONArray.getInt(m);
                m += 1;
                continue;
              }
            }
            localStickerItem.scaleFactor = ((org.json.JSONObject)localObject).optInt("scaleFactor");
            localStickerItem.blendMode = ((org.json.JSONObject)localObject).optInt("blendMode", -1);
            if (localStickerItem.blendMode == -1) {
              localStickerItem.blendMode = paramVideoMaterial.getBlendMode();
            }
            localStickerItem.support3D = ((org.json.JSONObject)localObject).optInt("enable3D", 1);
            localStickerItem.personID = ((org.json.JSONObject)localObject).optInt("personID", -1);
            localStickerItem.activateTriggerCount = ((org.json.JSONObject)localObject).optInt("activateTriggerCount", 0);
            localStickerItem.activateTriggerTotalCount = ((org.json.JSONObject)localObject).optInt("activateTriggerTotalCount", 0);
            localArrayList.add(localStickerItem);
            if (k == -1)
            {
              k = localStickerItem.triggerType;
              break label601;
            }
            i = Math.max(i, localStickerItem.triggerType);
            break label601;
          }
          paramJSONObject = localArrayList.iterator();
          if (paramJSONObject.hasNext())
          {
            localObject = (StickerItem)paramJSONObject.next();
            ((StickerItem)localObject).preTriggerType = k;
            ((StickerItem)localObject).countTriggerType = i;
            continue;
          }
          paramVideoMaterial.setHeadCropItemList(localArrayList);
        }
      }
      catch (JSONException paramJSONObject)
      {
        LogUtils.e(TAG, paramJSONObject);
        AppMethodBeat.o(84262);
        return;
      }
      AppMethodBeat.o(84262);
      return;
      label595:
      boolean bool = false;
      continue;
      label601:
      j += 1;
    }
  }
  
  private static List<StickerItem> parseItemListParams(String paramString, JSONArray paramJSONArray, int paramInt1, VideoMaterial paramVideoMaterial, int paramInt2, boolean[] paramArrayOfBoolean, int[] paramArrayOfInt, DecryptListener paramDecryptListener)
  {
    AppMethodBeat.i(84264);
    ArrayList localArrayList;
    int j;
    int i;
    org.json.JSONObject localJSONObject;
    StickerItem localStickerItem;
    boolean bool;
    label435:
    Object localObject2;
    try
    {
      localArrayList = new ArrayList();
      if (paramJSONArray != null)
      {
        j = 0;
        i = 0;
        if (i >= paramJSONArray.length()) {
          break label2157;
        }
        localJSONObject = paramJSONArray.getJSONObject(i);
        localStickerItem = new StickerItem();
        localStickerItem.id = localJSONObject.optString("id");
        localStickerItem.subFolder = localStickerItem.id;
        localStickerItem.name = localJSONObject.optString("name");
        localStickerItem.type = localJSONObject.optInt("type");
        localStickerItem.scale = ((float)localJSONObject.optDouble("scale", 1.0D));
        localStickerItem.angle = ((float)localJSONObject.optDouble("angle", 0.0D));
        localStickerItem.dx = localJSONObject.optInt("dx", 0);
        localStickerItem.dy = localJSONObject.optInt("dy", 0);
        localStickerItem.personID = localJSONObject.optInt("personID", -1);
        localStickerItem.featureStatType = localJSONObject.optInt("featureStatType");
        localStickerItem.frameType = localJSONObject.optInt("frameType");
        localStickerItem.blendMode = localJSONObject.optInt("blendMode", -1);
        localStickerItem.zIndex = localJSONObject.optInt("zIndex");
        localStickerItem.audioLoopCount = localJSONObject.optInt("audioLoopCount", -1);
        localStickerItem.randomGroupNum = localJSONObject.optInt("randomGroupNum");
        localObject1 = localJSONObject.optJSONObject("featureStatValueRange");
        if (localObject1 != null)
        {
          localStickerItem.featureStatValueRange = new StickerItem.ValueRange();
          localStickerItem.featureStatValueRange.min = ((org.json.JSONObject)localObject1).optDouble("min");
          localStickerItem.featureStatValueRange.max = ((org.json.JSONObject)localObject1).optDouble("max");
        }
        localObject1 = localJSONObject.optJSONObject(VideoMaterialUtil.FIELD.CHARM_RANGE.value);
        if (localObject1 != null)
        {
          localStickerItem.charmRange = new CharmRange();
          localStickerItem.charmRange.min = ((org.json.JSONObject)localObject1).optDouble(VideoMaterialUtil.CHARM_RANGE_FIELD.MIN.value);
          localStickerItem.charmRange.max = ((org.json.JSONObject)localObject1).optDouble(VideoMaterialUtil.CHARM_RANGE_FIELD.MAX.value);
        }
        if (localStickerItem.blendMode == -1) {
          localStickerItem.blendMode = paramInt2;
        }
        localStickerItem.triggerType = localJSONObject.optInt("triggerType");
        localStickerItem.audioTriggerType = localJSONObject.optInt("audioTriggerType");
        if (localJSONObject.optInt("audioNeedAdjust", 1) != 1) {
          break label2227;
        }
        bool = true;
        localStickerItem.audioNeedAdjust = bool;
        localObject1 = localJSONObject.optJSONObject("audioValueRange");
        if (localObject1 != null)
        {
          localStickerItem.audioValueRange = new StickerItem.ValueRange();
          localStickerItem.audioValueRange.min = ((org.json.JSONObject)localObject1).optDouble("min");
          localStickerItem.audioValueRange.max = ((org.json.JSONObject)localObject1).optDouble("max");
        }
        if ((VideoMaterialUtil.isActionTriggerType(localStickerItem.triggerType)) && (paramArrayOfInt != null)) {
          paramArrayOfInt[0] = localStickerItem.triggerType;
        }
        if (localJSONObject.optInt("alwaysTriggered") != 1) {
          break label2233;
        }
        bool = true;
        label541:
        localStickerItem.alwaysTriggered = bool;
        localStickerItem.playCount = localJSONObject.optInt("playCount");
        localStickerItem.frameDuration = localJSONObject.optDouble("frameDuration");
        localStickerItem.stickerType = localJSONObject.optInt("stickerType", paramInt1);
        if ((localStickerItem.stickerType == VideoFilterFactory.STICKER_TYPE.VIDEO_UP_DOWN.type) || (localStickerItem.stickerType == VideoFilterFactory.STICKER_TYPE.VIDEO_LEFT_RIGHT.type)) {
          if (localStickerItem.stickerType != VideoFilterFactory.STICKER_TYPE.VIDEO_UP_DOWN.type) {
            break label769;
          }
        }
        label769:
        for (localObject1 = VideoMaterialUtil.ITEM_SOURCE_TYPE.VIDEO_UP_DOWN;; localObject1 = VideoMaterialUtil.ITEM_SOURCE_TYPE.VIDEO_LEFT_RIGHT)
        {
          localStickerItem.sourceType = ((VideoMaterialUtil.ITEM_SOURCE_TYPE)localObject1);
          localStickerItem.frames = localJSONObject.optInt("frames");
          localStickerItem.width = localJSONObject.optInt("width");
          localStickerItem.height = localJSONObject.optInt("height");
          localStickerItem.support3D = localJSONObject.optInt("enable3D", 1);
          localStickerItem.scaleDirection = localJSONObject.optInt("scaleDirection");
          localObject1 = localJSONObject.optJSONArray("position");
          if (localObject1 == null) {
            break;
          }
          localStickerItem.position = new double[((JSONArray)localObject1).length()];
          j = 0;
          while (j < ((JSONArray)localObject1).length())
          {
            localStickerItem.position[j] = ((JSONArray)localObject1).getDouble(j);
            j += 1;
          }
        }
        localStickerItem.position = new double[] { 0.0D, 0.0D };
        localStickerItem.audio = localJSONObject.optString("audio");
        if ((!TextUtils.isEmpty(localStickerItem.audio)) && (paramArrayOfBoolean != null)) {
          paramArrayOfBoolean[0] = true;
        }
        localObject1 = localJSONObject.optJSONArray("anchorPoint");
        if (localObject1 != null)
        {
          localStickerItem.anchorPoint = new int[((JSONArray)localObject1).length()];
          j = 0;
          while (j < ((JSONArray)localObject1).length())
          {
            localStickerItem.anchorPoint[j] = ((JSONArray)localObject1).getInt(j);
            j += 1;
          }
        }
        localObject1 = localJSONObject.optJSONArray("anchorPointAudio");
        if (localObject1 != null)
        {
          localStickerItem.anchorPointAudio = new double[((JSONArray)localObject1).length()];
          j = 0;
          while (j < ((JSONArray)localObject1).length())
          {
            localStickerItem.anchorPointAudio[j] = ((JSONArray)localObject1).getDouble(j);
            j += 1;
          }
        }
        localStickerItem.anchorPointAudio = new double[] { 0.5D, 0.5D };
        localObject1 = localJSONObject.optJSONArray("alignFacePoints");
        if (localObject1 != null)
        {
          localStickerItem.alignFacePoints = new int[((JSONArray)localObject1).length()];
          j = 0;
          while (j < ((JSONArray)localObject1).length())
          {
            localStickerItem.alignFacePoints[j] = ((JSONArray)localObject1).getInt(j);
            j += 1;
          }
        }
        localObject1 = localJSONObject.optJSONArray("scalePivots");
        if (localObject1 != null)
        {
          localStickerItem.scalePivots = new int[((JSONArray)localObject1).length()];
          j = 0;
          while (j < ((JSONArray)localObject1).length())
          {
            localStickerItem.scalePivots[j] = ((JSONArray)localObject1).getInt(j);
            j += 1;
          }
        }
        localStickerItem.scaleFactor = localJSONObject.optInt("scaleFactor");
        localStickerItem.originalScaleFactor = localStickerItem.scaleFactor;
        localStickerItem.markMode = localJSONObject.optInt("markMode");
        localStickerItem.activateTriggerType = localJSONObject.optInt("activateTriggerType", 0);
        localStickerItem.activateTriggerCount = localJSONObject.optInt("activateTriggerCount", 0);
        localStickerItem.activateTriggerTotalCount = localJSONObject.optInt("activateTriggerTotalCount", 0);
        localStickerItem.bodyTriggerPoint = localJSONObject.optInt("bodyTriggerPoint", 0);
        localStickerItem.bodyTriggerDirection = localJSONObject.optInt("bodyTriggerDirection", 0);
        localStickerItem.bodyTriggerDistance = localJSONObject.optInt("bodyTriggerDistance", 0);
        localStickerItem.bodyTriggerTimeGap = localJSONObject.optDouble("bodyTriggerTimeGap", 0.0D);
        localObject1 = localJSONObject.optJSONObject("ageRange");
        if (localObject1 != null)
        {
          localStickerItem.ageRange = new AgeRange();
          localStickerItem.ageRange.min = ((float)((org.json.JSONObject)localObject1).optDouble("min"));
          localStickerItem.ageRange.max = ((float)((org.json.JSONObject)localObject1).optDouble("max"));
        }
        localObject1 = localJSONObject.optJSONObject("genderRange");
        if (localObject1 != null)
        {
          localStickerItem.genderRange = new GenderRange();
          localStickerItem.genderRange.min = ((float)((org.json.JSONObject)localObject1).optDouble("min"));
          localStickerItem.genderRange.max = ((float)((org.json.JSONObject)localObject1).optDouble("max"));
        }
        localObject1 = localJSONObject.optJSONObject("popularRange");
        if (localObject1 != null)
        {
          localStickerItem.popularRange = new PopularRange();
          localStickerItem.popularRange.min = ((float)((org.json.JSONObject)localObject1).optDouble("min"));
          localStickerItem.popularRange.max = ((float)((org.json.JSONObject)localObject1).optDouble("max"));
        }
        localObject1 = localJSONObject.optJSONObject("cpRange");
        if (localObject1 != null)
        {
          localStickerItem.cpRange = new CpRange();
          localStickerItem.cpRange.min = ((float)((org.json.JSONObject)localObject1).optDouble("min"));
          localStickerItem.cpRange.max = ((float)((org.json.JSONObject)localObject1).optDouble("max"));
        }
        localObject1 = localJSONObject.optJSONObject("audioScaleFactor");
        if (localObject1 == null) {
          break label1574;
        }
        localObject2 = ((org.json.JSONObject)localObject1).keys();
        while (((Iterator)localObject2).hasNext())
        {
          String str = (String)((Iterator)localObject2).next();
          localStickerItem.audioScaleFactorMap.add(Pair.create(Float.valueOf(str), Double.valueOf(((org.json.JSONObject)localObject1).optDouble(str, 0.0D))));
        }
      }
      Collections.sort(localStickerItem.audioScaleFactorMap, mRangeValueComp);
    }
    catch (JSONException paramString)
    {
      LogUtils.e(TAG, paramString);
      AppMethodBeat.o(84264);
      return null;
    }
    label1574:
    Object localObject1 = localJSONObject.optJSONObject("transition");
    label1694:
    int m;
    if (localObject1 != null)
    {
      localStickerItem.transition = new Transition();
      localStickerItem.transition.particleCountMax = ((org.json.JSONObject)localObject1).optInt(VideoMaterialUtil.TRANSITION.PARTICLE_COUNT_MAX.value);
      localStickerItem.transition.life = ((org.json.JSONObject)localObject1).optString(VideoMaterialUtil.TRANSITION.LIFE.value);
      localStickerItem.transition.emissionMode = ((org.json.JSONObject)localObject1).optInt(VideoMaterialUtil.TRANSITION.EMISSION_MODE.value);
      localObject2 = localStickerItem.transition;
      if (((org.json.JSONObject)localObject1).optInt(VideoMaterialUtil.TRANSITION.PARTICLE_ALWAYS_UPDATE.value) != 1) {
        break label2239;
      }
      bool = true;
      ((Transition)localObject2).particleAlwaysUpdate = bool;
      localStickerItem.transition.emissionRate = ((org.json.JSONObject)localObject1).optInt(VideoMaterialUtil.TRANSITION.EMISSION_RATE.value);
      localStickerItem.transition.scale = ((org.json.JSONObject)localObject1).optString(VideoMaterialUtil.TRANSITION.SCALE.value);
      localStickerItem.transition.rotate = ((org.json.JSONObject)localObject1).optString(VideoMaterialUtil.TRANSITION.ROTATE.value);
      localStickerItem.transition.positionX = ((org.json.JSONObject)localObject1).optString(VideoMaterialUtil.TRANSITION.POSITION_X.value);
      localStickerItem.transition.positionY = ((org.json.JSONObject)localObject1).optString(VideoMaterialUtil.TRANSITION.POSITION_Y.value);
      localStickerItem.transition.p0 = ((org.json.JSONObject)localObject1).optString(VideoMaterialUtil.TRANSITION.P0.value);
      localStickerItem.transition.p1 = ((org.json.JSONObject)localObject1).optString(VideoMaterialUtil.TRANSITION.P1.value);
      localStickerItem.transition.p2 = ((org.json.JSONObject)localObject1).optString(VideoMaterialUtil.TRANSITION.P2.value);
      localStickerItem.transition.repeatCount = ((org.json.JSONObject)localObject1).optInt(VideoMaterialUtil.TRANSITION.REPEAT_COUNT.value, 1);
      localStickerItem.transition.minUpdateInterval = ((org.json.JSONObject)localObject1).optInt(VideoMaterialUtil.TRANSITION.MIN_UPDATE_INTERVAL.value, 1);
      localStickerItem.transition.clearMode = ((org.json.JSONObject)localObject1).optInt(VideoMaterialUtil.TRANSITION.CLEAR_MODE.value, 0);
      localObject1 = localJSONObject.optJSONArray(VideoMaterialUtil.FIELD.WATERMARK_GROUP.value);
      if (localObject1 == null) {
        break label2062;
      }
      localStickerItem.wmGroupCopies = new ArrayList();
      j = 0;
      label1947:
      m = localStickerItem.transition.particleCountMax / localStickerItem.transition.repeatCount;
      if (localStickerItem.transition.clearMode != VideoMaterialUtil.PARTICLE_CLEAR_MODE.CLEAR_ALL.value) {
        break label2245;
      }
    }
    label2062:
    label2227:
    label2233:
    label2239:
    label2245:
    for (int k = 1;; k = 0)
    {
      if (j < k + m)
      {
        localObject2 = parseWMGroup((JSONArray)localObject1, paramVideoMaterial);
        ((WMGroup)localObject2).id = j;
        localStickerItem.wmGroupCopies.add(localObject2);
        j += 1;
        break label1947;
        localObject1 = localJSONObject.optJSONArray(VideoMaterialUtil.FIELD.WATERMARK_GROUP.value);
        if (localObject1 != null) {
          localStickerItem.wmGroup = parseWMGroup((JSONArray)localObject1, paramVideoMaterial);
        }
      }
      localStickerItem.triggerWords = localJSONObject.optString("triggerWords");
      localStickerItem.preTriggerType = localStickerItem.triggerType;
      localArrayList.add(localStickerItem);
      j = localStickerItem.triggerType;
      localStickerItem.particleConfig = parseParticleConfig(paramString + File.separator + localStickerItem.id, localJSONObject.optString("dexName"), paramDecryptListener);
      i += 1;
      break;
      label2157:
      paramString = localArrayList.iterator();
      while (paramString.hasNext())
      {
        paramJSONArray = (StickerItem)paramString.next();
        if (paramJSONArray.activateTriggerType == 0)
        {
          paramJSONArray.countTriggerType = j;
        }
        else
        {
          paramJSONArray.playCount = 0;
          paramJSONArray.countTriggerType = PTFaceAttr.PTExpression.MV_PART_INDEX.value;
        }
      }
      AppMethodBeat.o(84264);
      return localArrayList;
      bool = false;
      break label435;
      bool = false;
      break label541;
      bool = false;
      break label1694;
    }
  }
  
  public static ParticleConfig parseParticleConfig(String paramString1, String paramString2, DecryptListener paramDecryptListener)
  {
    AppMethodBeat.i(84273);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      AppMethodBeat.o(84273);
      return null;
    }
    paramString1 = readPexFile(paramString1, paramString2, paramDecryptListener);
    try
    {
      new JSONTokener(XML.toJSONObject(paramString1).toString()).nextValue();
      AppMethodBeat.o(84273);
      return null;
    }
    catch (Exception paramString1)
    {
      AppMethodBeat.o(84273);
      return null;
    }
    catch (JSONException paramString1)
    {
      label62:
      break label62;
    }
  }
  
  private static PhantomItem parsePhantomItem(org.json.JSONObject paramJSONObject, VideoMaterial paramVideoMaterial)
  {
    AppMethodBeat.i(84245);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(84245);
      return null;
    }
    PhantomItem localPhantomItem = new PhantomItem();
    localPhantomItem.setDataPath(paramVideoMaterial.getDataPath());
    localPhantomItem.setId(paramJSONObject.optString(VideoMaterialUtil.PHANTOM_ITEM_FIELD.ID.value));
    localPhantomItem.setMaskImage(paramJSONObject.optString(VideoMaterialUtil.PHANTOM_ITEM_FIELD.MASK_IMAGE.value));
    localPhantomItem.setBlendMode(paramJSONObject.optInt(VideoMaterialUtil.PHANTOM_ITEM_FIELD.BLEND_MODE.value));
    localPhantomItem.setScale(paramJSONObject.optDouble(VideoMaterialUtil.PHANTOM_ITEM_FIELD.SCALE.value));
    localPhantomItem.setOpacity(paramJSONObject.optDouble(VideoMaterialUtil.PHANTOM_ITEM_FIELD.OPACITY.value));
    localPhantomItem.setxK(paramJSONObject.optDouble(VideoMaterialUtil.PHANTOM_ITEM_FIELD.X_K.value));
    localPhantomItem.setxAsin(paramJSONObject.optDouble(VideoMaterialUtil.PHANTOM_ITEM_FIELD.X_A_SIN.value));
    localPhantomItem.setxBcos(paramJSONObject.optDouble(VideoMaterialUtil.PHANTOM_ITEM_FIELD.X_B_COS.value));
    localPhantomItem.setxPhase(paramJSONObject.optDouble(VideoMaterialUtil.PHANTOM_ITEM_FIELD.X_PHASE.value));
    localPhantomItem.setxOffset(paramJSONObject.optDouble(VideoMaterialUtil.PHANTOM_ITEM_FIELD.X_OFFSET.value));
    localPhantomItem.setxStep(paramJSONObject.optDouble(VideoMaterialUtil.PHANTOM_ITEM_FIELD.X_STEP.value));
    paramVideoMaterial = new double[2];
    VideoMaterial tmp193_192 = paramVideoMaterial;
    tmp193_192[0] = 0.0D;
    VideoMaterial tmp197_193 = tmp193_192;
    tmp197_193[1] = 360.0D;
    tmp197_193;
    JSONArray localJSONArray = paramJSONObject.optJSONArray(VideoMaterialUtil.PHANTOM_ITEM_FIELD.X_RANGE.value);
    if (localJSONArray != null)
    {
      paramVideoMaterial[0] = localJSONArray.optDouble(0);
      paramVideoMaterial[1] = localJSONArray.optDouble(1);
    }
    localPhantomItem.setxRange(paramVideoMaterial);
    localPhantomItem.setyK(paramJSONObject.optDouble(VideoMaterialUtil.PHANTOM_ITEM_FIELD.Y_K.value));
    localPhantomItem.setyAsin(paramJSONObject.optDouble(VideoMaterialUtil.PHANTOM_ITEM_FIELD.Y_A_SIN.value));
    localPhantomItem.setyBcos(paramJSONObject.optDouble(VideoMaterialUtil.PHANTOM_ITEM_FIELD.Y_B_COS.value));
    localPhantomItem.setyPhase(paramJSONObject.optDouble(VideoMaterialUtil.PHANTOM_ITEM_FIELD.Y_PHASE.value));
    localPhantomItem.setyOffset(paramJSONObject.optDouble(VideoMaterialUtil.PHANTOM_ITEM_FIELD.Y_OFFSET.value));
    localPhantomItem.setyStep(paramJSONObject.optDouble(VideoMaterialUtil.PHANTOM_ITEM_FIELD.Y_STEP.value));
    paramJSONObject = paramJSONObject.optJSONArray(VideoMaterialUtil.PHANTOM_ITEM_FIELD.Y_RANGE.value);
    paramVideoMaterial = new double[2];
    VideoMaterial tmp340_339 = paramVideoMaterial;
    tmp340_339[0] = 0.0D;
    VideoMaterial tmp344_340 = tmp340_339;
    tmp344_340[1] = 360.0D;
    tmp344_340;
    if (paramJSONObject != null)
    {
      paramVideoMaterial[0] = paramJSONObject.optDouble(0);
      paramVideoMaterial[1] = paramJSONObject.optDouble(1);
    }
    localPhantomItem.setyRange(paramVideoMaterial);
    AppMethodBeat.o(84245);
    return localPhantomItem;
  }
  
  private static void parsePhantomItemListParams(org.json.JSONObject paramJSONObject, VideoMaterial paramVideoMaterial)
  {
    AppMethodBeat.i(84244);
    paramJSONObject = paramJSONObject.optJSONArray("phantomItemList");
    if (paramJSONObject == null)
    {
      paramVideoMaterial.setPhantomItemList(new ArrayList());
      AppMethodBeat.o(84244);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramJSONObject.length())
    {
      Object localObject = paramJSONObject.optJSONObject(i);
      if (localObject != null)
      {
        localObject = parsePhantomItem((org.json.JSONObject)localObject, paramVideoMaterial);
        if (localObject != null) {
          localArrayList.add(localObject);
        }
      }
      i += 1;
    }
    paramVideoMaterial.setPhantomItemList(localArrayList);
    AppMethodBeat.o(84244);
  }
  
  private static void parseResourceListParams(org.json.JSONObject paramJSONObject, VideoMaterial paramVideoMaterial)
  {
    AppMethodBeat.i(84250);
    ArrayList localArrayList = new ArrayList();
    paramJSONObject = paramJSONObject.optJSONArray(VideoMaterialUtil.FIELD.RESOURCE_LIST.value);
    if (paramJSONObject != null)
    {
      int i = 0;
      while (i < paramJSONObject.length())
      {
        localArrayList.add(paramJSONObject.optString(i));
        i += 1;
      }
      paramVideoMaterial.setResourceList(localArrayList);
    }
    AppMethodBeat.o(84250);
  }
  
  private static void parseSegmentParams(org.json.JSONObject paramJSONObject, VideoMaterial paramVideoMaterial)
  {
    AppMethodBeat.i(84248);
    paramVideoMaterial.setSegmentFeather(paramJSONObject.optInt("SegmentFeathering", 0));
    boolean bool;
    if (paramJSONObject.optInt("SegmentRequired", 0) == 1) {
      bool = true;
    }
    for (;;)
    {
      paramVideoMaterial.setSegmentRequired(bool);
      paramVideoMaterial.setSegmentStrokeWidth(paramJSONObject.optDouble("SegmentStrokeWidth", 0.0D));
      paramVideoMaterial.setSegmentStrokeGap(paramJSONObject.optDouble("SegmentStrokeGap", 0.0D));
      paramJSONObject = paramJSONObject.optString("SegmentStrokeColor", "");
      if (!TextUtils.isEmpty(paramJSONObject)) {}
      try
      {
        i = Color.parseColor(paramJSONObject);
        paramVideoMaterial.setSegmentStrokeColor(new float[] { Color.red(i) / 255.0F, Color.green(i) / 255.0F, Color.blue(i) / 255.0F, Color.alpha(i) / 255.0F });
        AppMethodBeat.o(84248);
        return;
        bool = false;
      }
      catch (Exception paramJSONObject)
      {
        for (;;)
        {
          int i = 0;
        }
      }
    }
  }
  
  public static VideoMaterial parseVideoMaterial(String paramString)
  {
    AppMethodBeat.i(84238);
    paramString = parseVideoMaterial(paramString, "params", true, decryptListener);
    AppMethodBeat.o(84238);
    return paramString;
  }
  
  public static VideoMaterial parseVideoMaterial(String paramString, DecryptListener paramDecryptListener)
  {
    AppMethodBeat.i(84240);
    paramString = parseVideoMaterial(null, parseVideoMaterialString(paramString, paramDecryptListener), paramDecryptListener);
    AppMethodBeat.o(84240);
    return paramString;
  }
  
  public static VideoMaterial parseVideoMaterial(String paramString1, String paramString2, DecryptListener paramDecryptListener)
  {
    AppMethodBeat.i(84241);
    paramString1 = parseVideoMaterial(paramString1, parseVideoMaterialString(paramString2, paramDecryptListener), paramDecryptListener);
    AppMethodBeat.o(84241);
    return paramString1;
  }
  
  public static VideoMaterial parseVideoMaterial(String paramString1, String paramString2, boolean paramBoolean, DecryptListener paramDecryptListener)
  {
    AppMethodBeat.i(84239);
    paramString1 = parseVideoMaterial(paramString1, parseVideoMaterialFileAsJSONObject(paramString1, paramString2, paramBoolean, paramDecryptListener), paramDecryptListener);
    AppMethodBeat.o(84239);
    return paramString1;
  }
  
  private static VideoMaterial parseVideoMaterial(String paramString, org.json.JSONObject paramJSONObject, DecryptListener paramDecryptListener)
  {
    boolean bool = false;
    AppMethodBeat.i(84243);
    VideoMaterial localVideoMaterial = new VideoMaterial();
    localVideoMaterial.setDataPath(paramString);
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(84243);
      return localVideoMaterial;
    }
    parseBasicParams(paramString, paramJSONObject, localVideoMaterial);
    if (!TextUtils.isEmpty(paramJSONObject.optString(VideoMaterialUtil.GAME_FIELD.GAME_NAME.value))) {
      parseGameParams(paramJSONObject, localVideoMaterial);
    }
    if (!TextUtils.isEmpty(paramJSONObject.optString(VideoMaterialUtil.GAME_FIELD.GAME_NAME.value))) {
      parseAudio3DParams(paramJSONObject, localVideoMaterial);
    }
    parseResourceListParams(paramJSONObject, localVideoMaterial);
    Object localObject = new int[1];
    localObject[0] = 0;
    boolean[] arrayOfBoolean = new boolean[1];
    arrayOfBoolean[0] = false;
    List localList = parseItemListParams(paramString, paramJSONObject.optJSONArray(VideoMaterialUtil.FIELD.ITEM_LIST.value), VideoFilterFactory.STICKER_TYPE.NORMAL.type, localVideoMaterial, localVideoMaterial.getBlendMode(), arrayOfBoolean, (int[])localObject, paramDecryptListener);
    localVideoMaterial.setTriggerType(localObject[0]);
    localVideoMaterial.setItemList(localList);
    int i;
    if (arrayOfBoolean[0] != 0) {
      i = 1;
    }
    for (;;)
    {
      localObject = new boolean[1];
      localObject[0] = 0;
      parse3DItemListParams(paramString, paramJSONObject, localVideoMaterial, (boolean[])localObject);
      if ((i != 0) || (localObject[0] != 0))
      {
        i = 1;
        parseHeadCropItemListParams(paramJSONObject, localVideoMaterial);
        localVideoMaterial.setDistortionItemList(parseDistortionItemListParams(paramJSONObject.optJSONArray(VideoMaterialUtil.FIELD.DISTORTION_LIST.value)));
        parseFaceMoveItemListParams(paramJSONObject, localVideoMaterial);
        parseFaceMoveTrianglesParams(paramJSONObject, localVideoMaterial);
        parseFacePointsListParams(paramJSONObject, localVideoMaterial);
        parseFilterEffectParams(paramJSONObject, localVideoMaterial);
        localObject = parseFaceOffItemListParams(paramJSONObject.optJSONArray(VideoMaterialUtil.FIELD.FACE_OFF_ITEM_LIST.value));
        if (!TextUtils.isEmpty(localVideoMaterial.getFaceExchangeImage())) {
          ((List)localObject).add(new FaceItem(localVideoMaterial.getFaceExchangeImage(), (float)localVideoMaterial.getBlendAlpha(), localVideoMaterial.getGrayScale(), localVideoMaterial.getFeatureType(), localVideoMaterial.getFacePoints()));
        }
        localVideoMaterial.setFaceOffItemList((List)localObject);
        parseFaceMeshItemListParams(paramJSONObject, localVideoMaterial);
        parseFaceMeshItemListParams(paramJSONObject, localVideoMaterial);
        parseFaceImageLayerParams(paramJSONObject, localVideoMaterial);
        parseArParticleListParams(paramJSONObject, localVideoMaterial);
        localObject = new boolean[1];
        localObject[0] = 0;
        parseFaceExpressionParams(paramJSONObject, localVideoMaterial, (boolean[])localObject);
        if ((i != 0) || (localObject[0] != 0)) {
          bool = true;
        }
        parseFaceCropParams(paramJSONObject, localVideoMaterial);
        localVideoMaterial.setHasAudio(bool);
        parseFabbyMvItems(paramString, paramJSONObject, localVideoMaterial, paramDecryptListener);
        parseSegmentParams(paramJSONObject, localVideoMaterial);
        parseFaceFeatureItemListParams(paramString, paramJSONObject, localVideoMaterial, paramDecryptListener);
        parsePhantomItemListParams(paramJSONObject, localVideoMaterial);
        parseAudio2TextParams(paramJSONObject, localVideoMaterial);
        VideoMaterialUtil.updateSupportLandscape(localVideoMaterial);
        VideoMaterialUtil.updateMaxFaceCount(localVideoMaterial);
        VideoMaterialUtil.updateFaceValueDetectType(localVideoMaterial);
        VideoMaterialUtil.updateItemImageType(localVideoMaterial);
        VideoMaterialUtil.updateWatermarkInfo(localVideoMaterial);
        VideoMaterialUtil.updateNeedFaceInfo(localVideoMaterial);
        VideoMaterialUtil.updateNeedBodyInfo(localVideoMaterial);
      }
      try
      {
        checkValid(localVideoMaterial);
        label470:
        AppMethodBeat.o(84243);
        return localVideoMaterial;
        i = 0;
        continue;
        i = 0;
      }
      catch (IllegalArgumentException paramString)
      {
        break label470;
      }
    }
  }
  
  public static JSONArray parseVideoMaterialFileAsJSONArray(String paramString1, String paramString2, boolean paramBoolean, DecryptListener paramDecryptListener)
  {
    AppMethodBeat.i(84272);
    paramString1 = readMaterialFile(paramString1, paramString2, paramBoolean, paramDecryptListener);
    if ((paramString1 != null) && (!TextUtils.isEmpty(paramString1))) {
      try
      {
        paramString1 = (JSONArray)new JSONTokener(paramString1).nextValue();
        AppMethodBeat.o(84272);
        return paramString1;
      }
      catch (JSONException paramString1) {}
    }
    AppMethodBeat.o(84272);
    return null;
  }
  
  public static org.json.JSONObject parseVideoMaterialFileAsJSONObject(String paramString1, String paramString2, boolean paramBoolean, DecryptListener paramDecryptListener)
  {
    AppMethodBeat.i(84271);
    paramString1 = readMaterialFile(paramString1, paramString2, paramBoolean, paramDecryptListener);
    LogUtils.d(TAG, "[material str]".concat(String.valueOf(paramString1)));
    if ((paramString1 != null) && (!TextUtils.isEmpty(paramString1))) {
      try
      {
        paramString1 = (org.json.JSONObject)new JSONTokener(paramString1).nextValue();
        AppMethodBeat.o(84271);
        return paramString1;
      }
      catch (JSONException paramString1) {}
    }
    AppMethodBeat.o(84271);
    return null;
  }
  
  public static org.json.JSONObject parseVideoMaterialString(String paramString, DecryptListener paramDecryptListener)
  {
    AppMethodBeat.i(84270);
    Object localObject = null;
    String str = paramString.trim();
    paramString = str;
    if (str != null)
    {
      paramString = str;
      try
      {
        if (str.charAt(0) == '{') {
          break label112;
        }
        paramString = new BufferedReader(new InputStreamReader(drinkACupOfCoffee(new ByteArrayInputStream(str.getBytes(Charset.forName("UTF-8"))), paramDecryptListener)), 1024);
        paramDecryptListener = new StringBuffer();
        for (;;)
        {
          str = paramString.readLine();
          if (str == null) {
            break;
          }
          paramDecryptListener.append(str);
        }
        AppMethodBeat.o(84270);
      }
      catch (Exception paramString)
      {
        paramString = localObject;
      }
      return paramString;
      paramString = paramDecryptListener.toString();
    }
    label112:
    if (!TextUtils.isEmpty(paramString)) {}
    for (paramString = (org.json.JSONObject)new JSONTokener(paramString).nextValue();; paramString = null) {
      break;
    }
  }
  
  private static WMGroup parseWMGroup(JSONArray paramJSONArray, VideoMaterial paramVideoMaterial)
  {
    AppMethodBeat.i(84265);
    WMGroup localWMGroup = new WMGroup();
    int i = 0;
    for (;;)
    {
      Object localObject2;
      Object localObject1;
      Object localObject4;
      Object localObject5;
      String str1;
      try
      {
        if (i < paramJSONArray.length())
        {
          localObject2 = paramJSONArray.optJSONObject(i);
          if (localObject2 == null) {
            break label1155;
          }
          int j = ((org.json.JSONObject)localObject2).optInt(VideoMaterialUtil.WATERMARK_ELEMENT.WMTYPE.value);
          if (j != WMElement.WMType.TEXT.value) {
            break label988;
          }
          localObject1 = new TextWMElement();
          ((WMElement)localObject1).dataPath = paramVideoMaterial.getDataPath();
          ((WMElement)localObject1).sid = paramVideoMaterial.getId();
          ((WMElement)localObject1).id = ((org.json.JSONObject)localObject2).optString(VideoMaterialUtil.WATERMARK_ELEMENT.ID.value);
          ((WMElement)localObject1).relativeID = ((org.json.JSONObject)localObject2).optString(VideoMaterialUtil.WATERMARK_ELEMENT.RELATIVE_ID.value);
          localObject3 = ((org.json.JSONObject)localObject2).optJSONArray(VideoMaterialUtil.WATERMARK_ELEMENT.RELATIVE_ANCHOR.value);
          if ((localObject3 == null) || (((JSONArray)localObject3).length() != 2)) {
            break label1000;
          }
          ((WMElement)localObject1).relativeAnchor = new PointF((float)((JSONArray)localObject3).getDouble(0), (float)((JSONArray)localObject3).getDouble(1));
          localObject3 = ((org.json.JSONObject)localObject2).optJSONArray(VideoMaterialUtil.WATERMARK_ELEMENT.ANCHOR.value);
          if ((localObject3 == null) || (((JSONArray)localObject3).length() != 2)) {
            break label1017;
          }
          ((WMElement)localObject1).anchor = new PointF((float)((JSONArray)localObject3).getDouble(0), (float)((JSONArray)localObject3).getDouble(1));
          ((WMElement)localObject1).offsetX = ((org.json.JSONObject)localObject2).optInt(VideoMaterialUtil.WATERMARK_ELEMENT.OFFSETX.value);
          ((WMElement)localObject1).offsetY = ((org.json.JSONObject)localObject2).optInt(VideoMaterialUtil.WATERMARK_ELEMENT.OFFSETY.value);
          ((WMElement)localObject1).width = ((org.json.JSONObject)localObject2).optInt(VideoMaterialUtil.WATERMARK_ELEMENT.WIDTH.value);
          ((WMElement)localObject1).height = ((org.json.JSONObject)localObject2).optInt(VideoMaterialUtil.WATERMARK_ELEMENT.HEIGHT.value);
          ((WMElement)localObject1).wmtype = j;
          ((WMElement)localObject1).edittype = ((org.json.JSONObject)localObject2).optInt(VideoMaterialUtil.WATERMARK_ELEMENT.EDITTYPE.value);
          ((WMElement)localObject1).fmtstr = ((org.json.JSONObject)localObject2).optString(VideoMaterialUtil.WATERMARK_ELEMENT.FMTSTR.value);
          ((WMElement)localObject1).fontName = ((org.json.JSONObject)localObject2).optString(VideoMaterialUtil.WATERMARK_ELEMENT.FONT_NAME.value);
          if (((org.json.JSONObject)localObject2).optInt(VideoMaterialUtil.WATERMARK_ELEMENT.FONT_BOLD.value) != 1) {
            break label1162;
          }
          bool = true;
          ((WMElement)localObject1).fontBold = bool;
          if (((org.json.JSONObject)localObject2).optInt(VideoMaterialUtil.WATERMARK_ELEMENT.FONT_ITALICS.value) != 1) {
            break label1168;
          }
          bool = true;
          ((WMElement)localObject1).fontItalics = bool;
          ((WMElement)localObject1).fontTexture = ((org.json.JSONObject)localObject2).optString(VideoMaterialUtil.WATERMARK_ELEMENT.FONT_TEXTURE.value);
          ((WMElement)localObject1).fontSize = ((float)((org.json.JSONObject)localObject2).optDouble(VideoMaterialUtil.WATERMARK_ELEMENT.FONT_SIZE.value, 40.0D));
          ((WMElement)localObject1).fontFit = ((org.json.JSONObject)localObject2).optInt(VideoMaterialUtil.WATERMARK_ELEMENT.FONT_FIT.value);
          ((WMElement)localObject1).kern = ((org.json.JSONObject)localObject2).optInt(VideoMaterialUtil.WATERMARK_ELEMENT.KERN.value);
          ((WMElement)localObject1).imgPath = ((org.json.JSONObject)localObject2).optString(VideoMaterialUtil.WATERMARK_ELEMENT.IMG_PATH.value);
          ((WMElement)localObject1).frameDuration = ((org.json.JSONObject)localObject2).optInt(VideoMaterialUtil.WATERMARK_ELEMENT.FRAME_DURATION.value);
          ((WMElement)localObject1).frames = ((org.json.JSONObject)localObject2).optInt(VideoMaterialUtil.WATERMARK_ELEMENT.FRAMES.value);
          ((WMElement)localObject1).color = ((org.json.JSONObject)localObject2).optString(VideoMaterialUtil.WATERMARK_ELEMENT.COLOR.value, "#FFFFFFFF");
          ((WMElement)localObject1).strokeColor = ((org.json.JSONObject)localObject2).optString(VideoMaterialUtil.WATERMARK_ELEMENT.STROKE_COLOR.value, "#FFFFFFFF");
          ((WMElement)localObject1).strokeSize = ((float)((org.json.JSONObject)localObject2).optDouble(VideoMaterialUtil.WATERMARK_ELEMENT.STROKE_SIZE.value, -1.0D));
          ((WMElement)localObject1).shadowColor = ((org.json.JSONObject)localObject2).optString(VideoMaterialUtil.WATERMARK_ELEMENT.SHADOW_COLOR.value, "#FFFFFFFF");
          ((WMElement)localObject1).shadowSize = ((float)((org.json.JSONObject)localObject2).optDouble(VideoMaterialUtil.WATERMARK_ELEMENT.SHADOW_SIZE.value, -1.0D));
          ((WMElement)localObject1).shadowDx = ((float)((org.json.JSONObject)localObject2).optDouble(VideoMaterialUtil.WATERMARK_ELEMENT.SHADOW_DX.value, -1.0D));
          ((WMElement)localObject1).shadowDy = ((float)((org.json.JSONObject)localObject2).optDouble(VideoMaterialUtil.WATERMARK_ELEMENT.SHADOW_DY.value, -1.0D));
          ((WMElement)localObject1).alignment = ((org.json.JSONObject)localObject2).optString(VideoMaterialUtil.WATERMARK_ELEMENT.ALIGNMENT.value);
          ((WMElement)localObject1).vertical = ((org.json.JSONObject)localObject2).optInt(VideoMaterialUtil.WATERMARK_ELEMENT.VERTICAL.value);
          ((WMElement)localObject1).outerStrokeColor = ((org.json.JSONObject)localObject2).optString(VideoMaterialUtil.WATERMARK_ELEMENT.OUTER_STROKE_COLOR.value, "#FFFFFFFF");
          ((WMElement)localObject1).outerStrokeSize = ((float)((org.json.JSONObject)localObject2).optDouble(VideoMaterialUtil.WATERMARK_ELEMENT.OUTER_STROKE_SIZE.value, -1.0D));
          ((WMElement)localObject1).shaderBmp = ((org.json.JSONObject)localObject2).optString(VideoMaterialUtil.WATERMARK_ELEMENT.SHADER_BMP.value, null);
          if (((org.json.JSONObject)localObject2).optInt(VideoMaterialUtil.WATERMARK_ELEMENT.EMBOSS.value, 0) != 1) {
            break label1174;
          }
          bool = true;
          ((WMElement)localObject1).emboss = bool;
          if (((org.json.JSONObject)localObject2).optInt(VideoMaterialUtil.WATERMARK_ELEMENT.MULTI_ROW.value, 0) != 1) {
            break label1180;
          }
          bool = true;
          ((WMElement)localObject1).multiRow = bool;
          ((WMElement)localObject1).animateType = ((org.json.JSONObject)localObject2).optString(VideoMaterialUtil.WATERMARK_ELEMENT.ANIMATE_TYPE.value);
          localObject3 = ((org.json.JSONObject)localObject2).optJSONObject(VideoMaterialUtil.WATERMARK_ELEMENT.LOGIC.value);
          if (localObject3 == null) {
            break label1142;
          }
          localObject2 = new WMLogic();
          ((WMLogic)localObject2).type = ((org.json.JSONObject)localObject3).optString(VideoMaterialUtil.WATERMARK_LOGIC.TYPE.value);
          ((WMLogic)localObject2).setCompare(((org.json.JSONObject)localObject3).optString(VideoMaterialUtil.WATERMARK_LOGIC.COMPARE.value), ((WMElement)localObject1).sid);
          ((WMLogic)localObject2).data = ((org.json.JSONObject)localObject3).optString(VideoMaterialUtil.WATERMARK_LOGIC.DATA.value);
          localObject4 = ((org.json.JSONObject)localObject3).optJSONObject(VideoMaterialUtil.WATERMARK_LOGIC.RANGE.value);
          if (localObject4 == null) {
            break label1042;
          }
          ((WMLogic)localObject2).range = new ArrayList();
          localObject5 = ((org.json.JSONObject)localObject4).keys();
          if (!((Iterator)localObject5).hasNext()) {
            break label1034;
          }
          str1 = (String)((Iterator)localObject5).next();
          String str2 = ((org.json.JSONObject)localObject4).optString(str1);
          ((WMLogic)localObject2).range.add(new WMLogicPair(str1, str2));
          continue;
        }
        localObject1 = new ImageWMElement();
      }
      catch (Exception paramJSONArray)
      {
        LogUtils.e(paramJSONArray);
        AppMethodBeat.o(84265);
        return localWMGroup;
      }
      label988:
      continue;
      label1000:
      ((WMElement)localObject1).relativeAnchor = new PointF(0.0F, 0.0F);
      continue;
      label1017:
      ((WMElement)localObject1).anchor = new PointF(0.0F, 0.0F);
      continue;
      label1034:
      Collections.sort(((WMLogic)localObject2).range);
      label1042:
      Object localObject3 = ((org.json.JSONObject)localObject3).optJSONObject(VideoMaterialUtil.WATERMARK_LOGIC.CASE.value);
      if (localObject3 != null)
      {
        ((WMLogic)localObject2).wmcase = new ArrayList();
        localObject4 = ((org.json.JSONObject)localObject3).keys();
        while (((Iterator)localObject4).hasNext())
        {
          localObject5 = (String)((Iterator)localObject4).next();
          str1 = ((org.json.JSONObject)localObject3).optString((String)localObject5);
          ((WMLogic)localObject2).wmcase.add(new WMLogicPair((String)localObject5, str1));
        }
      }
      ((WMElement)localObject1).logic = ((WMLogic)localObject2);
      label1142:
      localWMGroup.wmElements.add(localObject1);
      label1155:
      i += 1;
      continue;
      label1162:
      boolean bool = false;
      continue;
      label1168:
      bool = false;
      continue;
      label1174:
      bool = false;
      continue;
      label1180:
      bool = false;
    }
  }
  
  /* Error */
  private static String readMaterialFile(String paramString1, String paramString2, boolean paramBoolean, DecryptListener paramDecryptListener)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: ldc_w 2891
    //   6: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: invokestatic 2896	com/tencent/ttpic/baseutils/FileUtils:getRealPath	(Ljava/lang/String;)Ljava/lang/String;
    //   13: astore 6
    //   15: new 867	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 868	java/lang/StringBuilder:<init>	()V
    //   22: aload 6
    //   24: invokevirtual 872	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: ldc_w 877
    //   30: invokevirtual 872	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: aload_1
    //   34: invokevirtual 872	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: ldc_w 1298
    //   40: invokevirtual 872	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: astore 5
    //   45: iload_2
    //   46: ifeq +263 -> 309
    //   49: ldc 11
    //   51: astore_0
    //   52: aload 5
    //   54: aload_0
    //   55: invokevirtual 872	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: invokevirtual 880	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: astore 5
    //   63: new 867	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 868	java/lang/StringBuilder:<init>	()V
    //   70: aload 6
    //   72: invokevirtual 872	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: ldc_w 877
    //   78: invokevirtual 872	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: aload_1
    //   82: invokevirtual 872	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: ldc_w 1298
    //   88: invokevirtual 872	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: astore_1
    //   92: iload_2
    //   93: ifne +222 -> 315
    //   96: ldc 11
    //   98: astore_0
    //   99: aload_1
    //   100: aload_0
    //   101: invokevirtual 872	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: invokevirtual 880	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: astore 7
    //   109: new 1196	java/io/File
    //   112: dup
    //   113: aload 5
    //   115: invokespecial 2897	java/io/File:<init>	(Ljava/lang/String;)V
    //   118: astore_0
    //   119: new 1196	java/io/File
    //   122: dup
    //   123: aload 7
    //   125: invokespecial 2897	java/io/File:<init>	(Ljava/lang/String;)V
    //   128: astore_1
    //   129: aload_0
    //   130: invokevirtual 2900	java/io/File:exists	()Z
    //   133: ifeq +10 -> 143
    //   136: aload_0
    //   137: invokevirtual 2903	java/io/File:isFile	()Z
    //   140: ifne +17 -> 157
    //   143: aload_1
    //   144: invokevirtual 2900	java/io/File:exists	()Z
    //   147: ifeq +222 -> 369
    //   150: aload_1
    //   151: invokevirtual 2903	java/io/File:isFile	()Z
    //   154: ifeq +215 -> 369
    //   157: aload_0
    //   158: invokevirtual 2900	java/io/File:exists	()Z
    //   161: ifeq +160 -> 321
    //   164: aload_0
    //   165: invokevirtual 2903	java/io/File:isFile	()Z
    //   168: ifeq +153 -> 321
    //   171: new 2905	java/io/FileInputStream
    //   174: dup
    //   175: aload_0
    //   176: invokespecial 2908	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   179: astore_0
    //   180: iload_2
    //   181: ifne +177 -> 358
    //   184: aload_0
    //   185: aload_3
    //   186: invokestatic 2866	com/tencent/ttpic/util/VideoTemplateParser:drinkACupOfCoffee	(Ljava/io/InputStream;Lcom/tencent/ttpic/util/DecryptListener;)Ljava/io/InputStream;
    //   189: astore_1
    //   190: aload_0
    //   191: invokestatic 2911	com/tencent/util/g:closeQuietly	(Ljava/io/InputStream;)V
    //   194: aload_1
    //   195: ifnull +359 -> 554
    //   198: new 2852	java/io/InputStreamReader
    //   201: dup
    //   202: aload_1
    //   203: invokespecial 2869	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   206: astore_3
    //   207: new 2850	java/io/BufferedReader
    //   210: dup
    //   211: aload_3
    //   212: sipush 1024
    //   215: invokespecial 2872	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   218: astore 6
    //   220: new 867	java/lang/StringBuilder
    //   223: dup
    //   224: invokespecial 868	java/lang/StringBuilder:<init>	()V
    //   227: astore 5
    //   229: aload 6
    //   231: invokevirtual 2878	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   234: astore 7
    //   236: aload 7
    //   238: ifnull +275 -> 513
    //   241: aload 5
    //   243: aload 7
    //   245: invokevirtual 872	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: pop
    //   249: goto -20 -> 229
    //   252: astore 7
    //   254: aload_3
    //   255: astore 5
    //   257: aload 7
    //   259: astore_3
    //   260: aload_3
    //   261: invokevirtual 2914	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   264: pop
    //   265: aload 6
    //   267: ifnull +8 -> 275
    //   270: aload 6
    //   272: invokevirtual 2917	java/io/BufferedReader:close	()V
    //   275: aload 5
    //   277: ifnull +8 -> 285
    //   280: aload 5
    //   282: invokevirtual 2918	java/io/InputStreamReader:close	()V
    //   285: aload_1
    //   286: ifnull +7 -> 293
    //   289: aload_1
    //   290: invokevirtual 2921	java/io/InputStream:close	()V
    //   293: aload_0
    //   294: ifnull +7 -> 301
    //   297: aload_0
    //   298: invokevirtual 2922	java/io/FileInputStream:close	()V
    //   301: ldc_w 2891
    //   304: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   307: aconst_null
    //   308: areturn
    //   309: ldc 8
    //   311: astore_0
    //   312: goto -260 -> 52
    //   315: ldc 8
    //   317: astore_0
    //   318: goto -219 -> 99
    //   321: aload_1
    //   322: invokevirtual 2900	java/io/File:exists	()Z
    //   325: ifeq +483 -> 808
    //   328: aload_1
    //   329: invokevirtual 2903	java/io/File:isFile	()Z
    //   332: ifeq +476 -> 808
    //   335: new 2905	java/io/FileInputStream
    //   338: dup
    //   339: aload_1
    //   340: invokespecial 2908	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   343: astore_0
    //   344: iload_2
    //   345: ifne +8 -> 353
    //   348: iconst_1
    //   349: istore_2
    //   350: goto -170 -> 180
    //   353: iconst_0
    //   354: istore_2
    //   355: goto -5 -> 350
    //   358: aload_0
    //   359: astore_1
    //   360: aload_0
    //   361: astore_3
    //   362: aload_1
    //   363: astore_0
    //   364: aload_3
    //   365: astore_1
    //   366: goto -172 -> 194
    //   369: invokestatic 2928	com/tencent/ttpic/util/VideoGlobalContext:getContext	()Landroid/content/Context;
    //   372: invokevirtual 2934	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   375: aload 5
    //   377: invokevirtual 2940	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   380: astore 6
    //   382: iload_2
    //   383: ifne +29 -> 412
    //   386: aload 6
    //   388: aload_3
    //   389: invokestatic 2866	com/tencent/ttpic/util/VideoTemplateParser:drinkACupOfCoffee	(Ljava/io/InputStream;Lcom/tencent/ttpic/util/DecryptListener;)Ljava/io/InputStream;
    //   392: astore_0
    //   393: aload_0
    //   394: astore_1
    //   395: aload_0
    //   396: astore 5
    //   398: aload 6
    //   400: invokestatic 2911	com/tencent/util/g:closeQuietly	(Ljava/io/InputStream;)V
    //   403: aconst_null
    //   404: astore_3
    //   405: aload_0
    //   406: astore_1
    //   407: aload_3
    //   408: astore_0
    //   409: goto -215 -> 194
    //   412: aconst_null
    //   413: astore_0
    //   414: aload 6
    //   416: astore_1
    //   417: goto -223 -> 194
    //   420: astore_0
    //   421: aconst_null
    //   422: astore_0
    //   423: aload_0
    //   424: astore 6
    //   426: aload_0
    //   427: astore_1
    //   428: aload_0
    //   429: astore 5
    //   431: invokestatic 2928	com/tencent/ttpic/util/VideoGlobalContext:getContext	()Landroid/content/Context;
    //   434: invokevirtual 2934	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   437: aload 7
    //   439: invokevirtual 2940	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   442: astore 7
    //   444: iload_2
    //   445: ifne +45 -> 490
    //   448: iload 4
    //   450: ifne +46 -> 496
    //   453: aload_0
    //   454: astore 6
    //   456: aload_0
    //   457: astore_1
    //   458: aload_0
    //   459: astore 5
    //   461: aload 7
    //   463: aload_3
    //   464: invokestatic 2866	com/tencent/ttpic/util/VideoTemplateParser:drinkACupOfCoffee	(Ljava/io/InputStream;Lcom/tencent/ttpic/util/DecryptListener;)Ljava/io/InputStream;
    //   467: astore_0
    //   468: aload_0
    //   469: astore 6
    //   471: aload_0
    //   472: astore_1
    //   473: aload_0
    //   474: astore 5
    //   476: aload 7
    //   478: invokestatic 2911	com/tencent/util/g:closeQuietly	(Ljava/io/InputStream;)V
    //   481: aconst_null
    //   482: astore_3
    //   483: aload_0
    //   484: astore_1
    //   485: aload_3
    //   486: astore_0
    //   487: goto -293 -> 194
    //   490: iconst_0
    //   491: istore 4
    //   493: goto -45 -> 448
    //   496: aconst_null
    //   497: astore_0
    //   498: aload 7
    //   500: astore_1
    //   501: goto -307 -> 194
    //   504: astore_0
    //   505: aconst_null
    //   506: astore_0
    //   507: aload 6
    //   509: astore_1
    //   510: goto -316 -> 194
    //   513: aload 5
    //   515: invokevirtual 880	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   518: astore 5
    //   520: aload 6
    //   522: invokevirtual 2917	java/io/BufferedReader:close	()V
    //   525: aload_3
    //   526: invokevirtual 2918	java/io/InputStreamReader:close	()V
    //   529: aload_1
    //   530: ifnull +7 -> 537
    //   533: aload_1
    //   534: invokevirtual 2921	java/io/InputStream:close	()V
    //   537: aload_0
    //   538: ifnull +7 -> 545
    //   541: aload_0
    //   542: invokevirtual 2922	java/io/FileInputStream:close	()V
    //   545: ldc_w 2891
    //   548: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   551: aload 5
    //   553: areturn
    //   554: aload_1
    //   555: ifnull +7 -> 562
    //   558: aload_1
    //   559: invokevirtual 2921	java/io/InputStream:close	()V
    //   562: aload_0
    //   563: ifnull -262 -> 301
    //   566: aload_0
    //   567: invokevirtual 2922	java/io/FileInputStream:close	()V
    //   570: goto -269 -> 301
    //   573: astore_0
    //   574: goto -273 -> 301
    //   577: astore_3
    //   578: aconst_null
    //   579: astore_0
    //   580: aconst_null
    //   581: astore 5
    //   583: aconst_null
    //   584: astore 6
    //   586: aconst_null
    //   587: astore_1
    //   588: aload 6
    //   590: ifnull +8 -> 598
    //   593: aload 6
    //   595: invokevirtual 2917	java/io/BufferedReader:close	()V
    //   598: aload 5
    //   600: ifnull +8 -> 608
    //   603: aload 5
    //   605: invokevirtual 2918	java/io/InputStreamReader:close	()V
    //   608: aload_1
    //   609: ifnull +7 -> 616
    //   612: aload_1
    //   613: invokevirtual 2921	java/io/InputStream:close	()V
    //   616: aload_0
    //   617: ifnull +7 -> 624
    //   620: aload_0
    //   621: invokevirtual 2922	java/io/FileInputStream:close	()V
    //   624: ldc_w 2891
    //   627: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   630: aload_3
    //   631: athrow
    //   632: astore_0
    //   633: goto -9 -> 624
    //   636: astore_3
    //   637: aconst_null
    //   638: astore 5
    //   640: aconst_null
    //   641: astore 6
    //   643: aconst_null
    //   644: astore_1
    //   645: goto -57 -> 588
    //   648: astore_3
    //   649: aconst_null
    //   650: astore 5
    //   652: aconst_null
    //   653: astore 6
    //   655: goto -67 -> 588
    //   658: astore_3
    //   659: aconst_null
    //   660: astore_0
    //   661: aconst_null
    //   662: astore 5
    //   664: aconst_null
    //   665: astore 6
    //   667: goto -79 -> 588
    //   670: astore_3
    //   671: aconst_null
    //   672: astore 5
    //   674: aconst_null
    //   675: astore 6
    //   677: goto -89 -> 588
    //   680: astore 6
    //   682: aload_3
    //   683: astore 5
    //   685: aconst_null
    //   686: astore 7
    //   688: aload 6
    //   690: astore_3
    //   691: aload 7
    //   693: astore 6
    //   695: goto -107 -> 588
    //   698: astore 7
    //   700: aload_3
    //   701: astore 5
    //   703: aload 7
    //   705: astore_3
    //   706: goto -118 -> 588
    //   709: astore_3
    //   710: goto -122 -> 588
    //   713: astore_0
    //   714: goto -413 -> 301
    //   717: astore_3
    //   718: aconst_null
    //   719: astore_0
    //   720: aconst_null
    //   721: astore 5
    //   723: aconst_null
    //   724: astore 6
    //   726: aconst_null
    //   727: astore_1
    //   728: goto -468 -> 260
    //   731: astore_3
    //   732: aconst_null
    //   733: astore 5
    //   735: aconst_null
    //   736: astore 6
    //   738: aconst_null
    //   739: astore_1
    //   740: goto -480 -> 260
    //   743: astore_3
    //   744: aconst_null
    //   745: astore 5
    //   747: aconst_null
    //   748: astore 6
    //   750: goto -490 -> 260
    //   753: astore_3
    //   754: aconst_null
    //   755: astore_0
    //   756: aconst_null
    //   757: astore 7
    //   759: aconst_null
    //   760: astore 6
    //   762: aload 5
    //   764: astore_1
    //   765: aload 7
    //   767: astore 5
    //   769: goto -509 -> 260
    //   772: astore_3
    //   773: aconst_null
    //   774: astore 5
    //   776: aconst_null
    //   777: astore 6
    //   779: goto -519 -> 260
    //   782: astore 6
    //   784: aload_3
    //   785: astore 5
    //   787: aconst_null
    //   788: astore 7
    //   790: aload 6
    //   792: astore_3
    //   793: aload 7
    //   795: astore 6
    //   797: goto -537 -> 260
    //   800: astore_0
    //   801: goto -256 -> 545
    //   804: astore_1
    //   805: goto -382 -> 423
    //   808: aconst_null
    //   809: astore_0
    //   810: goto -630 -> 180
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	813	0	paramString1	String
    //   0	813	1	paramString2	String
    //   0	813	2	paramBoolean	boolean
    //   0	813	3	paramDecryptListener	DecryptListener
    //   1	491	4	i	int
    //   43	743	5	localObject1	Object
    //   13	663	6	localObject2	Object
    //   680	9	6	localObject3	Object
    //   693	85	6	localObject4	Object
    //   782	9	6	localException1	Exception
    //   795	1	6	localObject5	Object
    //   107	137	7	str	String
    //   252	186	7	localException2	Exception
    //   442	250	7	localInputStream	InputStream
    //   698	6	7	localObject6	Object
    //   757	37	7	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   220	229	252	java/lang/Exception
    //   229	236	252	java/lang/Exception
    //   241	249	252	java/lang/Exception
    //   513	520	252	java/lang/Exception
    //   369	382	420	java/io/IOException
    //   386	393	420	java/io/IOException
    //   431	444	504	java/io/IOException
    //   461	468	504	java/io/IOException
    //   476	481	504	java/io/IOException
    //   558	562	573	java/io/IOException
    //   566	570	573	java/io/IOException
    //   109	143	577	finally
    //   143	157	577	finally
    //   157	180	577	finally
    //   321	344	577	finally
    //   369	382	577	finally
    //   386	393	577	finally
    //   593	598	632	java/io/IOException
    //   603	608	632	java/io/IOException
    //   612	616	632	java/io/IOException
    //   620	624	632	java/io/IOException
    //   184	190	636	finally
    //   190	194	648	finally
    //   398	403	658	finally
    //   431	444	658	finally
    //   461	468	658	finally
    //   476	481	658	finally
    //   198	207	670	finally
    //   207	220	680	finally
    //   220	229	698	finally
    //   229	236	698	finally
    //   241	249	698	finally
    //   513	520	698	finally
    //   260	265	709	finally
    //   270	275	713	java/io/IOException
    //   280	285	713	java/io/IOException
    //   289	293	713	java/io/IOException
    //   297	301	713	java/io/IOException
    //   109	143	717	java/lang/Exception
    //   143	157	717	java/lang/Exception
    //   157	180	717	java/lang/Exception
    //   321	344	717	java/lang/Exception
    //   369	382	717	java/lang/Exception
    //   386	393	717	java/lang/Exception
    //   184	190	731	java/lang/Exception
    //   190	194	743	java/lang/Exception
    //   398	403	753	java/lang/Exception
    //   431	444	753	java/lang/Exception
    //   461	468	753	java/lang/Exception
    //   476	481	753	java/lang/Exception
    //   198	207	772	java/lang/Exception
    //   207	220	782	java/lang/Exception
    //   520	529	800	java/io/IOException
    //   533	537	800	java/io/IOException
    //   541	545	800	java/io/IOException
    //   398	403	804	java/io/IOException
  }
  
  /* Error */
  private static String readPexFile(String paramString1, String paramString2, DecryptListener paramDecryptListener)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 5
    //   3: iconst_1
    //   4: istore 4
    //   6: ldc_w 2941
    //   9: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   12: aload_1
    //   13: ldc 8
    //   15: invokevirtual 1368	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   18: ifne +276 -> 294
    //   21: iconst_1
    //   22: istore_3
    //   23: aload_0
    //   24: invokestatic 2896	com/tencent/ttpic/baseutils/FileUtils:getRealPath	(Ljava/lang/String;)Ljava/lang/String;
    //   27: astore 6
    //   29: new 867	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 868	java/lang/StringBuilder:<init>	()V
    //   36: aload 6
    //   38: invokevirtual 872	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: ldc_w 877
    //   44: invokevirtual 872	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: aload_1
    //   48: invokevirtual 872	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: invokevirtual 880	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: astore_0
    //   55: new 867	java/lang/StringBuilder
    //   58: dup
    //   59: invokespecial 868	java/lang/StringBuilder:<init>	()V
    //   62: aload 6
    //   64: invokevirtual 872	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: ldc_w 877
    //   70: invokevirtual 872	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: aload_1
    //   74: invokevirtual 872	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: invokevirtual 880	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: astore 8
    //   82: new 1196	java/io/File
    //   85: dup
    //   86: aload_0
    //   87: invokespecial 2897	java/io/File:<init>	(Ljava/lang/String;)V
    //   90: astore_1
    //   91: new 1196	java/io/File
    //   94: dup
    //   95: aload 8
    //   97: invokespecial 2897	java/io/File:<init>	(Ljava/lang/String;)V
    //   100: astore 6
    //   102: aload_1
    //   103: invokevirtual 2900	java/io/File:exists	()Z
    //   106: ifeq +10 -> 116
    //   109: aload_1
    //   110: invokevirtual 2903	java/io/File:isFile	()Z
    //   113: ifne +19 -> 132
    //   116: aload 6
    //   118: invokevirtual 2900	java/io/File:exists	()Z
    //   121: ifeq +230 -> 351
    //   124: aload 6
    //   126: invokevirtual 2903	java/io/File:isFile	()Z
    //   129: ifeq +222 -> 351
    //   132: aload_1
    //   133: invokevirtual 2900	java/io/File:exists	()Z
    //   136: ifeq +163 -> 299
    //   139: aload_1
    //   140: invokevirtual 2903	java/io/File:isFile	()Z
    //   143: ifeq +156 -> 299
    //   146: new 2905	java/io/FileInputStream
    //   149: dup
    //   150: aload_1
    //   151: invokespecial 2908	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   154: astore_0
    //   155: iload_3
    //   156: ifne +184 -> 340
    //   159: aload_0
    //   160: aload_2
    //   161: invokestatic 2866	com/tencent/ttpic/util/VideoTemplateParser:drinkACupOfCoffee	(Ljava/io/InputStream;Lcom/tencent/ttpic/util/DecryptListener;)Ljava/io/InputStream;
    //   164: astore_1
    //   165: aload_0
    //   166: invokestatic 2911	com/tencent/util/g:closeQuietly	(Ljava/io/InputStream;)V
    //   169: aload_1
    //   170: ifnull +385 -> 555
    //   173: new 2852	java/io/InputStreamReader
    //   176: dup
    //   177: aload_1
    //   178: invokespecial 2869	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   181: astore_2
    //   182: new 2850	java/io/BufferedReader
    //   185: dup
    //   186: aload_2
    //   187: sipush 1024
    //   190: invokespecial 2872	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   193: astore 7
    //   195: new 867	java/lang/StringBuilder
    //   198: dup
    //   199: invokespecial 868	java/lang/StringBuilder:<init>	()V
    //   202: astore 6
    //   204: aload 7
    //   206: invokevirtual 2878	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   209: astore 8
    //   211: aload 8
    //   213: ifnull +282 -> 495
    //   216: aload 6
    //   218: aload 8
    //   220: invokevirtual 872	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: pop
    //   224: goto -20 -> 204
    //   227: astore 8
    //   229: aload_2
    //   230: astore 6
    //   232: aload 8
    //   234: astore_2
    //   235: getstatic 40	com/tencent/ttpic/util/VideoTemplateParser:TAG	Ljava/lang/String;
    //   238: aload_2
    //   239: invokevirtual 2914	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   242: aload_2
    //   243: iconst_0
    //   244: anewarray 4	java/lang/Object
    //   247: invokestatic 2944	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
    //   250: aload 7
    //   252: ifnull +8 -> 260
    //   255: aload 7
    //   257: invokevirtual 2917	java/io/BufferedReader:close	()V
    //   260: aload 6
    //   262: ifnull +8 -> 270
    //   265: aload 6
    //   267: invokevirtual 2918	java/io/InputStreamReader:close	()V
    //   270: aload_1
    //   271: ifnull +7 -> 278
    //   274: aload_1
    //   275: invokevirtual 2921	java/io/InputStream:close	()V
    //   278: aload_0
    //   279: ifnull +7 -> 286
    //   282: aload_0
    //   283: invokevirtual 2922	java/io/FileInputStream:close	()V
    //   286: ldc_w 2941
    //   289: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   292: aconst_null
    //   293: areturn
    //   294: iconst_0
    //   295: istore_3
    //   296: goto -273 -> 23
    //   299: aload 6
    //   301: invokevirtual 2900	java/io/File:exists	()Z
    //   304: ifeq +538 -> 842
    //   307: aload 6
    //   309: invokevirtual 2903	java/io/File:isFile	()Z
    //   312: ifeq +530 -> 842
    //   315: new 2905	java/io/FileInputStream
    //   318: dup
    //   319: aload 6
    //   321: invokespecial 2908	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   324: astore_0
    //   325: iload_3
    //   326: ifne +9 -> 335
    //   329: iload 4
    //   331: istore_3
    //   332: goto -177 -> 155
    //   335: iconst_0
    //   336: istore_3
    //   337: goto -5 -> 332
    //   340: aload_0
    //   341: astore_1
    //   342: aload_0
    //   343: astore_2
    //   344: aload_1
    //   345: astore_0
    //   346: aload_2
    //   347: astore_1
    //   348: goto -179 -> 169
    //   351: invokestatic 2928	com/tencent/ttpic/util/VideoGlobalContext:getContext	()Landroid/content/Context;
    //   354: invokevirtual 2934	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   357: aload_0
    //   358: invokevirtual 2940	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   361: astore 7
    //   363: iload_3
    //   364: ifne +29 -> 393
    //   367: aload 7
    //   369: aload_2
    //   370: invokestatic 2866	com/tencent/ttpic/util/VideoTemplateParser:drinkACupOfCoffee	(Ljava/io/InputStream;Lcom/tencent/ttpic/util/DecryptListener;)Ljava/io/InputStream;
    //   373: astore_0
    //   374: aload_0
    //   375: astore_1
    //   376: aload_0
    //   377: astore 6
    //   379: aload 7
    //   381: invokestatic 2911	com/tencent/util/g:closeQuietly	(Ljava/io/InputStream;)V
    //   384: aconst_null
    //   385: astore_2
    //   386: aload_0
    //   387: astore_1
    //   388: aload_2
    //   389: astore_0
    //   390: goto -221 -> 169
    //   393: aconst_null
    //   394: astore_0
    //   395: aload 7
    //   397: astore_1
    //   398: goto -229 -> 169
    //   401: astore_0
    //   402: aconst_null
    //   403: astore_0
    //   404: aload_0
    //   405: astore 7
    //   407: aload_0
    //   408: astore_1
    //   409: aload_0
    //   410: astore 6
    //   412: invokestatic 2928	com/tencent/ttpic/util/VideoGlobalContext:getContext	()Landroid/content/Context;
    //   415: invokevirtual 2934	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   418: aload 8
    //   420: invokevirtual 2940	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   423: astore 8
    //   425: iload_3
    //   426: ifne +47 -> 473
    //   429: iload 5
    //   431: istore_3
    //   432: iload_3
    //   433: ifne +45 -> 478
    //   436: aload_0
    //   437: astore 7
    //   439: aload_0
    //   440: astore_1
    //   441: aload_0
    //   442: astore 6
    //   444: aload 8
    //   446: aload_2
    //   447: invokestatic 2866	com/tencent/ttpic/util/VideoTemplateParser:drinkACupOfCoffee	(Ljava/io/InputStream;Lcom/tencent/ttpic/util/DecryptListener;)Ljava/io/InputStream;
    //   450: astore_0
    //   451: aload_0
    //   452: astore 7
    //   454: aload_0
    //   455: astore_1
    //   456: aload_0
    //   457: astore 6
    //   459: aload 8
    //   461: invokestatic 2911	com/tencent/util/g:closeQuietly	(Ljava/io/InputStream;)V
    //   464: aconst_null
    //   465: astore_2
    //   466: aload_0
    //   467: astore_1
    //   468: aload_2
    //   469: astore_0
    //   470: goto -301 -> 169
    //   473: iconst_0
    //   474: istore_3
    //   475: goto -43 -> 432
    //   478: aconst_null
    //   479: astore_0
    //   480: aload 8
    //   482: astore_1
    //   483: goto -314 -> 169
    //   486: astore_0
    //   487: aconst_null
    //   488: astore_0
    //   489: aload 7
    //   491: astore_1
    //   492: goto -323 -> 169
    //   495: aload 6
    //   497: invokevirtual 880	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   500: astore 6
    //   502: aload 7
    //   504: invokevirtual 2917	java/io/BufferedReader:close	()V
    //   507: aload_2
    //   508: invokevirtual 2918	java/io/InputStreamReader:close	()V
    //   511: aload_1
    //   512: ifnull +7 -> 519
    //   515: aload_1
    //   516: invokevirtual 2921	java/io/InputStream:close	()V
    //   519: aload_0
    //   520: ifnull +7 -> 527
    //   523: aload_0
    //   524: invokevirtual 2922	java/io/FileInputStream:close	()V
    //   527: ldc_w 2941
    //   530: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   533: aload 6
    //   535: areturn
    //   536: astore_0
    //   537: getstatic 40	com/tencent/ttpic/util/VideoTemplateParser:TAG	Ljava/lang/String;
    //   540: aload_0
    //   541: invokevirtual 2945	java/io/IOException:getMessage	()Ljava/lang/String;
    //   544: aload_0
    //   545: iconst_0
    //   546: anewarray 4	java/lang/Object
    //   549: invokestatic 2944	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
    //   552: goto -25 -> 527
    //   555: aload_1
    //   556: ifnull +7 -> 563
    //   559: aload_1
    //   560: invokevirtual 2921	java/io/InputStream:close	()V
    //   563: aload_0
    //   564: ifnull -278 -> 286
    //   567: aload_0
    //   568: invokevirtual 2922	java/io/FileInputStream:close	()V
    //   571: goto -285 -> 286
    //   574: astore_0
    //   575: getstatic 40	com/tencent/ttpic/util/VideoTemplateParser:TAG	Ljava/lang/String;
    //   578: aload_0
    //   579: invokevirtual 2945	java/io/IOException:getMessage	()Ljava/lang/String;
    //   582: aload_0
    //   583: iconst_0
    //   584: anewarray 4	java/lang/Object
    //   587: invokestatic 2944	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
    //   590: goto -304 -> 286
    //   593: astore_0
    //   594: getstatic 40	com/tencent/ttpic/util/VideoTemplateParser:TAG	Ljava/lang/String;
    //   597: aload_0
    //   598: invokevirtual 2945	java/io/IOException:getMessage	()Ljava/lang/String;
    //   601: aload_0
    //   602: iconst_0
    //   603: anewarray 4	java/lang/Object
    //   606: invokestatic 2944	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
    //   609: goto -323 -> 286
    //   612: astore_2
    //   613: aconst_null
    //   614: astore_0
    //   615: aconst_null
    //   616: astore 6
    //   618: aconst_null
    //   619: astore 7
    //   621: aconst_null
    //   622: astore_1
    //   623: aload 7
    //   625: ifnull +8 -> 633
    //   628: aload 7
    //   630: invokevirtual 2917	java/io/BufferedReader:close	()V
    //   633: aload 6
    //   635: ifnull +8 -> 643
    //   638: aload 6
    //   640: invokevirtual 2918	java/io/InputStreamReader:close	()V
    //   643: aload_1
    //   644: ifnull +7 -> 651
    //   647: aload_1
    //   648: invokevirtual 2921	java/io/InputStream:close	()V
    //   651: aload_0
    //   652: ifnull +7 -> 659
    //   655: aload_0
    //   656: invokevirtual 2922	java/io/FileInputStream:close	()V
    //   659: ldc_w 2941
    //   662: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   665: aload_2
    //   666: athrow
    //   667: astore_0
    //   668: getstatic 40	com/tencent/ttpic/util/VideoTemplateParser:TAG	Ljava/lang/String;
    //   671: aload_0
    //   672: invokevirtual 2945	java/io/IOException:getMessage	()Ljava/lang/String;
    //   675: aload_0
    //   676: iconst_0
    //   677: anewarray 4	java/lang/Object
    //   680: invokestatic 2944	com/tencent/ttpic/baseutils/LogUtils:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;[Ljava/lang/Object;)V
    //   683: goto -24 -> 659
    //   686: astore_2
    //   687: aconst_null
    //   688: astore 6
    //   690: aconst_null
    //   691: astore 7
    //   693: aconst_null
    //   694: astore_1
    //   695: goto -72 -> 623
    //   698: astore_2
    //   699: aconst_null
    //   700: astore 6
    //   702: aconst_null
    //   703: astore 7
    //   705: goto -82 -> 623
    //   708: astore_2
    //   709: aconst_null
    //   710: astore_0
    //   711: aconst_null
    //   712: astore 6
    //   714: aconst_null
    //   715: astore 7
    //   717: goto -94 -> 623
    //   720: astore_2
    //   721: aconst_null
    //   722: astore 6
    //   724: aconst_null
    //   725: astore 7
    //   727: goto -104 -> 623
    //   730: astore 8
    //   732: aload_2
    //   733: astore 6
    //   735: aconst_null
    //   736: astore 7
    //   738: aload 8
    //   740: astore_2
    //   741: goto -118 -> 623
    //   744: astore 8
    //   746: aload_2
    //   747: astore 6
    //   749: aload 8
    //   751: astore_2
    //   752: goto -129 -> 623
    //   755: astore_2
    //   756: goto -133 -> 623
    //   759: astore_2
    //   760: aconst_null
    //   761: astore_0
    //   762: aconst_null
    //   763: astore 6
    //   765: aconst_null
    //   766: astore 7
    //   768: aconst_null
    //   769: astore_1
    //   770: goto -535 -> 235
    //   773: astore_2
    //   774: aconst_null
    //   775: astore 6
    //   777: aconst_null
    //   778: astore 7
    //   780: aconst_null
    //   781: astore_1
    //   782: goto -547 -> 235
    //   785: astore_2
    //   786: aconst_null
    //   787: astore 6
    //   789: aconst_null
    //   790: astore 7
    //   792: goto -557 -> 235
    //   795: astore_2
    //   796: aconst_null
    //   797: astore_0
    //   798: aconst_null
    //   799: astore 8
    //   801: aconst_null
    //   802: astore 7
    //   804: aload 6
    //   806: astore_1
    //   807: aload 8
    //   809: astore 6
    //   811: goto -576 -> 235
    //   814: astore_2
    //   815: aconst_null
    //   816: astore 6
    //   818: aconst_null
    //   819: astore 7
    //   821: goto -586 -> 235
    //   824: astore 8
    //   826: aload_2
    //   827: astore 6
    //   829: aconst_null
    //   830: astore 7
    //   832: aload 8
    //   834: astore_2
    //   835: goto -600 -> 235
    //   838: astore_1
    //   839: goto -435 -> 404
    //   842: aconst_null
    //   843: astore_0
    //   844: goto -689 -> 155
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	847	0	paramString1	String
    //   0	847	1	paramString2	String
    //   0	847	2	paramDecryptListener	DecryptListener
    //   22	453	3	i	int
    //   4	326	4	j	int
    //   1	429	5	k	int
    //   27	801	6	localObject1	Object
    //   193	638	7	localObject2	Object
    //   80	139	8	str	String
    //   227	192	8	localException1	Exception
    //   423	58	8	localInputStream	InputStream
    //   730	9	8	localObject3	Object
    //   744	6	8	localObject4	Object
    //   799	9	8	localObject5	Object
    //   824	9	8	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   195	204	227	java/lang/Exception
    //   204	211	227	java/lang/Exception
    //   216	224	227	java/lang/Exception
    //   495	502	227	java/lang/Exception
    //   351	363	401	java/io/IOException
    //   367	374	401	java/io/IOException
    //   412	425	486	java/io/IOException
    //   444	451	486	java/io/IOException
    //   459	464	486	java/io/IOException
    //   502	511	536	java/io/IOException
    //   515	519	536	java/io/IOException
    //   523	527	536	java/io/IOException
    //   559	563	574	java/io/IOException
    //   567	571	574	java/io/IOException
    //   255	260	593	java/io/IOException
    //   265	270	593	java/io/IOException
    //   274	278	593	java/io/IOException
    //   282	286	593	java/io/IOException
    //   82	116	612	finally
    //   116	132	612	finally
    //   132	155	612	finally
    //   299	325	612	finally
    //   351	363	612	finally
    //   367	374	612	finally
    //   628	633	667	java/io/IOException
    //   638	643	667	java/io/IOException
    //   647	651	667	java/io/IOException
    //   655	659	667	java/io/IOException
    //   159	165	686	finally
    //   165	169	698	finally
    //   379	384	708	finally
    //   412	425	708	finally
    //   444	451	708	finally
    //   459	464	708	finally
    //   173	182	720	finally
    //   182	195	730	finally
    //   195	204	744	finally
    //   204	211	744	finally
    //   216	224	744	finally
    //   495	502	744	finally
    //   235	250	755	finally
    //   82	116	759	java/lang/Exception
    //   116	132	759	java/lang/Exception
    //   132	155	759	java/lang/Exception
    //   299	325	759	java/lang/Exception
    //   351	363	759	java/lang/Exception
    //   367	374	759	java/lang/Exception
    //   159	165	773	java/lang/Exception
    //   165	169	785	java/lang/Exception
    //   379	384	795	java/lang/Exception
    //   412	425	795	java/lang/Exception
    //   444	451	795	java/lang/Exception
    //   459	464	795	java/lang/Exception
    //   173	182	814	java/lang/Exception
    //   182	195	824	java/lang/Exception
    //   379	384	838	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.ttpic.util.VideoTemplateParser
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.ttpic.util;

import android.graphics.Color;
import android.graphics.PointF;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.ttpic.filter.FabbyMvPart;
import com.tencent.ttpic.filter.FabbyParts;
import com.tencent.ttpic.gameplaysdk.model.GameParams;
import com.tencent.ttpic.gameplaysdk.model.NodeParameter;
import com.tencent.ttpic.gameplaysdk.model.StickerItem3D;
import com.tencent.ttpic.model.AgeRange;
import com.tencent.ttpic.model.CanvasItem;
import com.tencent.ttpic.model.CharmRange;
import com.tencent.ttpic.model.CpRange;
import com.tencent.ttpic.model.DistortionItem;
import com.tencent.ttpic.model.ExpressionItem;
import com.tencent.ttpic.model.FaceCropItem;
import com.tencent.ttpic.model.FaceCropItem.CropFrame;
import com.tencent.ttpic.model.FaceExpression;
import com.tencent.ttpic.model.FaceItem;
import com.tencent.ttpic.model.FaceMeshItem;
import com.tencent.ttpic.model.FaceMoveItem;
import com.tencent.ttpic.model.GenderRange;
import com.tencent.ttpic.model.GridModel;
import com.tencent.ttpic.model.GridSettingModel;
import com.tencent.ttpic.model.ImageWMElement;
import com.tencent.ttpic.model.MultiViewerItem;
import com.tencent.ttpic.model.PopularRange;
import com.tencent.ttpic.model.Rect;
import com.tencent.ttpic.model.ShakaEffectItem;
import com.tencent.ttpic.model.SizeI;
import com.tencent.ttpic.model.StickerItem;
import com.tencent.ttpic.model.StickerItem.FeatureStatValueRange;
import com.tencent.ttpic.model.TextWMElement;
import com.tencent.ttpic.model.VideoFilterEffect;
import com.tencent.ttpic.model.VideoMaterial;
import com.tencent.ttpic.model.VideoMaterial.FaceImageLayer;
import com.tencent.ttpic.model.WMElement;
import com.tencent.ttpic.model.WMElement.WMType;
import com.tencent.ttpic.model.WMGroup;
import com.tencent.ttpic.model.WMLogic;
import com.tencent.ttpic.model.WMLogicPair;
import com.tencent.util.e;
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
import org.json.JSONObject;
import org.json.JSONTokener;

public class VideoTemplateParser
{
  public static final String POSTFIX_DAT = "dat";
  private static final String POSTFIX_JSON = "json";
  private static final DecryptListener decryptListener = new DecryptListener()
  {
    public final byte[] decrypt(byte[] paramAnonymousArrayOfByte)
    {
      return Coffee.drink(paramAnonymousArrayOfByte);
    }
  };
  private static Comparator<Pair<Float, Integer>> mDivideValueComp = new VideoTemplateParser.2();
  private static Comparator<Pair<Float, ? extends Object>> mDivideValueCompForObject = new VideoTemplateParser.3();
  private static Comparator<GridModel> mGridModelComparator = new VideoTemplateParser.5();
  private static Comparator<Pair<Float, Double>> mRangeValueComp = new VideoTemplateParser.4();
  
  private static void checkValid(VideoMaterial paramVideoMaterial)
  {
    if (paramVideoMaterial == null) {}
    StickerItem localStickerItem;
    do
    {
      do
      {
        do
        {
          return;
          while (!paramVideoMaterial.hasNext())
          {
            do
            {
              paramVideoMaterial = paramVideoMaterial.getItemList();
            } while (paramVideoMaterial == null);
            paramVideoMaterial = paramVideoMaterial.iterator();
          }
          localStickerItem = (StickerItem)paramVideoMaterial.next();
          if (localStickerItem.type != VideoFilterFactory.POSITION_TYPE.STATIC.type) {
            break;
          }
        } while ((localStickerItem.position != null) && (localStickerItem.position.length >= 2));
        throw new IllegalArgumentException("No \"position\" field in static sticker");
      } while (localStickerItem.type != VideoFilterFactory.POSITION_TYPE.DYNAMIC.type);
      if ((localStickerItem.scalePivots == null) || (localStickerItem.scalePivots.length < 2)) {
        throw new IllegalArgumentException("No \"scalePivot\" field in dynamic sticker");
      }
      if ((localStickerItem.alignFacePoints == null) || (localStickerItem.alignFacePoints.length == 0)) {
        throw new IllegalArgumentException("No \"alignFacePoints\" field in dynamic sticker");
      }
    } while ((localStickerItem.anchorPoint != null) && (localStickerItem.anchorPoint.length >= 2));
    throw new IllegalArgumentException("No \"anchorPoint\" field in dynamic sticker");
  }
  
  private static InputStream drinkACupOfCoffee(InputStream paramInputStream, DecryptListener paramDecryptListener)
  {
    byte[] arrayOfByte = e.toByteArray(paramInputStream);
    paramInputStream = arrayOfByte;
    if (paramDecryptListener != null) {
      paramInputStream = paramDecryptListener.decrypt(arrayOfByte);
    }
    return new ByteArrayInputStream(paramInputStream);
  }
  
  private static void parseFabbyMvItems(String paramString, JSONObject paramJSONObject, VideoMaterial paramVideoMaterial, DecryptListener paramDecryptListener)
  {
    Object localObject2 = paramJSONObject.optString("mvTemplateFile");
    if (TextUtils.isEmpty((CharSequence)localObject2)) {}
    Object localObject3;
    int j;
    label421:
    label708:
    label1263:
    label1274:
    do
    {
      JSONObject localJSONObject;
      JSONArray localJSONArray;
      do
      {
        do
        {
          return;
          i = ((String)localObject2).lastIndexOf(".");
          localObject1 = localObject2;
          if (i >= 0) {
            localObject1 = ((String)localObject2).substring(0, i);
          }
          localJSONObject = parseVideoMaterialFile(paramString, (String)localObject1, true, paramDecryptListener);
        } while (localJSONObject == null);
        localJSONArray = localJSONObject.optJSONArray("parts");
      } while ((localJSONArray == null) || (localJSONArray.length() <= 0));
      localJSONArray.length();
      localObject3 = new ArrayList();
      i = 0;
      while (i < localJSONArray.length())
      {
        FabbyMvPart localFabbyMvPart = new FabbyMvPart();
        Object localObject4 = localJSONArray.optJSONObject(i);
        if (localObject4 != null)
        {
          double d = ((JSONObject)localObject4).optDouble("duration");
          Object localObject5 = ((JSONObject)localObject4).optJSONObject("background");
          Object localObject6;
          if (localObject5 != null)
          {
            localObject6 = new StickerItem();
            localObject1 = ((JSONObject)localObject5).optString("videoFile");
            localObject2 = ((JSONObject)localObject5).optString("imageName");
            if ((!TextUtils.isEmpty((CharSequence)localObject1)) || (!TextUtils.isEmpty((CharSequence)localObject2)))
            {
              if (TextUtils.isEmpty((CharSequence)localObject1)) {
                break label1186;
              }
              j = ((String)localObject1).lastIndexOf("/");
              ((StickerItem)localObject6).id = ((String)localObject1).substring(j + 1, ((String)localObject1).length());
              ((StickerItem)localObject6).subFolder = ((String)localObject1).substring(0, j);
              j = 1;
              ((StickerItem)localObject6).type = 1;
              ((StickerItem)localObject6).alwaysTriggered = true;
              ((StickerItem)localObject6).frames = ((JSONObject)localObject5).optInt("imageCount", 1);
              ((StickerItem)localObject6).frameDuration = (((JSONObject)localObject5).optDouble("imageDuration", d) / ((StickerItem)localObject6).frames * 1000.0D);
              ((StickerItem)localObject6).aspectMode = ((JSONObject)localObject5).optInt("aspectMode", 0);
              ((StickerItem)localObject6).blendMode = ((JSONObject)localObject5).optInt("blendMode", 0);
              ((StickerItem)localObject6).width = ((JSONObject)localObject5).optInt("width", 720);
              ((StickerItem)localObject6).height = ((JSONObject)localObject5).optInt("height", 960);
              ((StickerItem)localObject6).position = new double[] { 0.0D, 0.0D };
              ((StickerItem)localObject6).isFabbyMvItem = true;
              ((StickerItem)localObject6).fabbyTotalParts = localJSONArray.length();
              ((StickerItem)localObject6).fabbyPart = i;
              if (j == 0) {
                break label1263;
              }
              ((StickerItem)localObject6).sourceType = VideoMaterialUtil.getItemSourceType(((JSONObject)localObject5).optInt(VideoMaterialUtil.FIELD.VIDEO_ALPHA_TYPE.value));
              localFabbyMvPart.bgItem = ((StickerItem)localObject6);
            }
          }
          localObject5 = ((JSONObject)localObject4).optJSONObject("foreground");
          if (localObject5 != null)
          {
            localObject6 = new StickerItem();
            localObject1 = ((JSONObject)localObject5).optString("videoFile");
            localObject2 = ((JSONObject)localObject5).optString("imageName");
            if ((!TextUtils.isEmpty((CharSequence)localObject1)) || (!TextUtils.isEmpty((CharSequence)localObject2)))
            {
              if (TextUtils.isEmpty((CharSequence)localObject1)) {
                break label1274;
              }
              j = ((String)localObject1).lastIndexOf("/");
              ((StickerItem)localObject6).id = ((String)localObject1).substring(j + 1, ((String)localObject1).length());
              ((StickerItem)localObject6).subFolder = ((String)localObject1).substring(0, j);
              j = 1;
              ((StickerItem)localObject6).type = 1;
              ((StickerItem)localObject6).alwaysTriggered = true;
              ((StickerItem)localObject6).frames = ((JSONObject)localObject5).optInt("imageCount", 1);
              ((StickerItem)localObject6).frameDuration = (((JSONObject)localObject5).optDouble("imageDuration", d) / ((StickerItem)localObject6).frames * 1000.0D);
              ((StickerItem)localObject6).aspectMode = ((JSONObject)localObject5).optInt("aspectMode", 0);
              ((StickerItem)localObject6).blendMode = ((JSONObject)localObject5).optInt("blendMode", 0);
              ((StickerItem)localObject6).width = ((JSONObject)localObject5).optInt("width", 720);
              ((StickerItem)localObject6).height = ((JSONObject)localObject5).optInt("height", 1280);
              ((StickerItem)localObject6).position = new double[] { 0.0D, 0.0D };
              ((StickerItem)localObject6).isFabbyMvItem = true;
              ((StickerItem)localObject6).fabbyTotalParts = localJSONArray.length();
              ((StickerItem)localObject6).fabbyPart = i;
              if (j == 0) {
                break label1351;
              }
              ((StickerItem)localObject6).sourceType = VideoMaterialUtil.getItemSourceType(((JSONObject)localObject5).optInt(VideoMaterialUtil.FIELD.VIDEO_ALPHA_TYPE.value));
              localFabbyMvPart.fgItem = ((StickerItem)localObject6);
            }
          }
          localObject5 = ((JSONObject)localObject4).optJSONObject("cover");
          if (localObject5 != null)
          {
            localObject6 = new StickerItem();
            localObject2 = ((JSONObject)localObject5).optString("imageFile");
            if (!TextUtils.isEmpty((CharSequence)localObject2))
            {
              localObject1 = localObject2;
              if (((String)localObject2).endsWith("_")) {
                localObject1 = ((String)localObject2).substring(0, ((String)localObject2).length() - 1);
              }
              j = ((String)localObject1).lastIndexOf("/");
              ((StickerItem)localObject6).id = ((String)localObject1).substring(j + 1, ((String)localObject1).lastIndexOf("_"));
              ((StickerItem)localObject6).subFolder = ((String)localObject1).substring(0, j);
              ((StickerItem)localObject6).type = 1;
              ((StickerItem)localObject6).alwaysTriggered = true;
              ((StickerItem)localObject6).frames = 1;
              ((StickerItem)localObject6).frameDuration = (1000.0D * d);
              ((StickerItem)localObject6).aspectMode = ((JSONObject)localObject5).optInt("aspectMode", 0);
              ((StickerItem)localObject6).blendMode = ((JSONObject)localObject5).optInt("blendMode", 0);
              ((StickerItem)localObject6).width = ((JSONObject)localObject5).optInt("width", 720);
              ((StickerItem)localObject6).height = ((JSONObject)localObject5).optInt("height", 1280);
              ((StickerItem)localObject6).position = new double[] { 0.0D, 0.0D };
              ((StickerItem)localObject6).isFabbyMvItem = true;
              ((StickerItem)localObject6).fabbyTotalParts = localJSONArray.length();
              ((StickerItem)localObject6).fabbyPart = i;
              localFabbyMvPart.coverItem = ((StickerItem)localObject6);
            }
          }
          localObject1 = ((JSONObject)localObject4).optJSONObject("cameraFrame");
          if (localObject1 != null)
          {
            localFabbyMvPart.easeCurve = ((JSONObject)localObject1).optInt("easeCurve", 0);
            localFabbyMvPart.scaleMap.clear();
            localObject2 = ((JSONObject)localObject1).optJSONObject("shakaEffect");
            Object localObject7;
            Object localObject8;
            Object localObject9;
            Object localObject10;
            Object localObject11;
            Object localObject12;
            if (localObject2 != null)
            {
              localObject5 = new ShakaEffectItem();
              ((ShakaEffectItem)localObject5).setFilterType(((JSONObject)localObject2).optInt("filterType"));
              localObject6 = new HashMap();
              localObject7 = ((JSONObject)localObject2).keys();
              for (;;)
              {
                if (!((Iterator)localObject7).hasNext()) {
                  break label1385;
                }
                localObject8 = (String)((Iterator)localObject7).next();
                localObject9 = ((JSONObject)localObject2).optJSONObject((String)localObject8);
                new StringBuilder("key = ").append((String)localObject8).append(", valueJson = ").append(localObject9);
                if (localObject9 != null)
                {
                  localObject10 = new ArrayList();
                  localObject11 = ((JSONObject)localObject9).keys();
                  for (;;)
                  {
                    if (((Iterator)localObject11).hasNext())
                    {
                      localObject12 = (String)((Iterator)localObject11).next();
                      ((List)localObject10).add(Pair.create(Float.valueOf((String)localObject12), Double.valueOf(((JSONObject)localObject9).optDouble((String)localObject12, 0.0D))));
                      continue;
                      localObject1 = localObject2;
                      if (((String)localObject2).endsWith("_")) {
                        localObject1 = ((String)localObject2).substring(0, ((String)localObject2).length() - 1);
                      }
                      j = ((String)localObject1).lastIndexOf("/");
                      ((StickerItem)localObject6).id = ((String)localObject1).substring(j + 1, ((String)localObject1).length());
                      ((StickerItem)localObject6).subFolder = ((String)localObject1).substring(0, j);
                      j = 0;
                      break;
                      ((StickerItem)localObject6).sourceType = VideoMaterialUtil.ITEM_SOURCE_TYPE.IMAGE;
                      break label421;
                      localObject1 = localObject2;
                      if (((String)localObject2).endsWith("_")) {
                        localObject1 = ((String)localObject2).substring(0, ((String)localObject2).length() - 1);
                      }
                      j = ((String)localObject1).lastIndexOf("/");
                      ((StickerItem)localObject6).id = ((String)localObject1).substring(j + 1, ((String)localObject1).length());
                      ((StickerItem)localObject6).subFolder = ((String)localObject1).substring(0, j);
                      j = 0;
                      break label538;
                      ((StickerItem)localObject6).sourceType = VideoMaterialUtil.ITEM_SOURCE_TYPE.IMAGE;
                      break label708;
                    }
                  }
                  Collections.sort((List)localObject10, mRangeValueComp);
                  ((Map)localObject6).put(localObject8, localObject10);
                }
              }
              ((ShakaEffectItem)localObject5).setValueMap((Map)localObject6);
              localFabbyMvPart.setShakaEffectItem((ShakaEffectItem)localObject5);
            }
            localObject2 = ((JSONObject)localObject1).optJSONObject("scale");
            if (localObject2 != null)
            {
              localObject5 = ((JSONObject)localObject2).keys();
              while (((Iterator)localObject5).hasNext())
              {
                localObject6 = (String)((Iterator)localObject5).next();
                localFabbyMvPart.scaleMap.add(Pair.create(Float.valueOf((String)localObject6), Double.valueOf(((JSONObject)localObject2).optDouble((String)localObject6, 1.0D))));
              }
            }
            Collections.sort(localFabbyMvPart.scaleMap, mRangeValueComp);
            localFabbyMvPart.degreeMap.clear();
            localObject2 = ((JSONObject)localObject1).optJSONObject("rotate");
            if (localObject2 != null)
            {
              localObject5 = ((JSONObject)localObject2).keys();
              while (((Iterator)localObject5).hasNext())
              {
                localObject6 = (String)((Iterator)localObject5).next();
                localFabbyMvPart.degreeMap.add(Pair.create(Float.valueOf((String)localObject6), Double.valueOf(((JSONObject)localObject2).optDouble((String)localObject6, 0.0D))));
              }
            }
            Collections.sort(localFabbyMvPart.degreeMap, mRangeValueComp);
            localFabbyMvPart.translateXMap.clear();
            localObject2 = ((JSONObject)localObject1).optJSONObject("translateX");
            if (localObject2 != null)
            {
              localObject5 = ((JSONObject)localObject2).keys();
              while (((Iterator)localObject5).hasNext())
              {
                localObject6 = (String)((Iterator)localObject5).next();
                localFabbyMvPart.translateXMap.add(Pair.create(Float.valueOf((String)localObject6), Double.valueOf(((JSONObject)localObject2).optDouble((String)localObject6, 0.0D))));
              }
            }
            Collections.sort(localFabbyMvPart.translateXMap, mRangeValueComp);
            localFabbyMvPart.translateYMap.clear();
            localObject2 = ((JSONObject)localObject1).optJSONObject("translateY");
            if (localObject2 != null)
            {
              localObject5 = ((JSONObject)localObject2).keys();
              while (((Iterator)localObject5).hasNext())
              {
                localObject6 = (String)((Iterator)localObject5).next();
                localFabbyMvPart.translateYMap.add(Pair.create(Float.valueOf((String)localObject6), Double.valueOf(((JSONObject)localObject2).optDouble((String)localObject6, 0.0D))));
              }
            }
            Collections.sort(localFabbyMvPart.translateYMap, mRangeValueComp);
            localFabbyMvPart.anchorXMap.clear();
            localObject2 = ((JSONObject)localObject1).optJSONObject("anchorX");
            if (localObject2 != null)
            {
              localObject5 = ((JSONObject)localObject2).keys();
              while (((Iterator)localObject5).hasNext())
              {
                localObject6 = (String)((Iterator)localObject5).next();
                localFabbyMvPart.anchorXMap.add(Pair.create(Float.valueOf((String)localObject6), Double.valueOf(((JSONObject)localObject2).optDouble((String)localObject6, 0.0D))));
              }
            }
            Collections.sort(localFabbyMvPart.anchorXMap, mRangeValueComp);
            localFabbyMvPart.anchorYMap.clear();
            localObject2 = ((JSONObject)localObject1).optJSONObject("anchorY");
            if (localObject2 != null)
            {
              localObject5 = ((JSONObject)localObject2).keys();
              while (((Iterator)localObject5).hasNext())
              {
                localObject6 = (String)((Iterator)localObject5).next();
                localFabbyMvPart.anchorYMap.add(Pair.create(Float.valueOf((String)localObject6), Double.valueOf(((JSONObject)localObject2).optDouble((String)localObject6, 0.0D))));
              }
            }
            Collections.sort(localFabbyMvPart.anchorYMap, mRangeValueComp);
            localFabbyMvPart.alphaMap.clear();
            localObject2 = ((JSONObject)localObject1).optJSONObject("alpha");
            if (localObject2 != null)
            {
              localObject5 = ((JSONObject)localObject2).keys();
              while (((Iterator)localObject5).hasNext())
              {
                localObject6 = (String)((Iterator)localObject5).next();
                localFabbyMvPart.alphaMap.add(Pair.create(Float.valueOf((String)localObject6), Double.valueOf(((JSONObject)localObject2).optDouble((String)localObject6, 1.0D))));
              }
            }
            Collections.sort(localFabbyMvPart.alphaMap, mRangeValueComp);
            localFabbyMvPart.blurRadiusMap.clear();
            localObject2 = ((JSONObject)localObject1).optJSONObject("blurRadius");
            if (localObject2 != null)
            {
              localObject5 = ((JSONObject)localObject2).keys();
              while (((Iterator)localObject5).hasNext())
              {
                localObject6 = (String)((Iterator)localObject5).next();
                localFabbyMvPart.blurRadiusMap.add(Pair.create(Float.valueOf((String)localObject6), Double.valueOf(((JSONObject)localObject2).optDouble((String)localObject6, 0.0D))));
              }
            }
            Collections.sort(localFabbyMvPart.blurRadiusMap, mRangeValueComp);
            localFabbyMvPart.blurDirectionMap.clear();
            localObject2 = ((JSONObject)localObject1).optJSONObject("blurDirection");
            if (localObject2 != null)
            {
              localObject5 = ((JSONObject)localObject2).keys();
              while (((Iterator)localObject5).hasNext())
              {
                localObject6 = (String)((Iterator)localObject5).next();
                localFabbyMvPart.blurDirectionMap.add(Pair.create(Float.valueOf((String)localObject6), Double.valueOf(((JSONObject)localObject2).optDouble((String)localObject6, 0.0D))));
              }
            }
            Collections.sort(localFabbyMvPart.blurDirectionMap, mRangeValueComp);
            localFabbyMvPart.gridTypeMap.clear();
            localObject2 = ((JSONObject)localObject1).optJSONObject("gridType");
            if (localObject2 != null)
            {
              localObject5 = ((JSONObject)localObject2).keys();
              while (((Iterator)localObject5).hasNext())
              {
                localObject6 = (String)((Iterator)localObject5).next();
                localFabbyMvPart.gridTypeMap.add(Pair.create(Float.valueOf((String)localObject6), Integer.valueOf(((JSONObject)localObject2).optInt((String)localObject6, 0))));
              }
            }
            Collections.sort(localFabbyMvPart.gridTypeMap, mDivideValueComp);
            localFabbyMvPart.gridSettingMap.clear();
            localObject2 = ((JSONObject)localObject1).optJSONObject("gridSettingFile");
            if (localObject2 != null)
            {
              localObject5 = ((JSONObject)localObject2).keys();
              while (((Iterator)localObject5).hasNext())
              {
                localObject6 = (String)((Iterator)localObject5).next();
                localObject7 = ((JSONObject)localObject2).optString((String)localObject6);
                if (!TextUtils.isEmpty((CharSequence)localObject7))
                {
                  localObject9 = parseVideoMaterialFile(paramString, (String)localObject7, true, paramDecryptListener);
                  if (localObject9 != null)
                  {
                    localObject7 = new GridSettingModel();
                    localObject8 = new Rect(0, 0, 720, 1280);
                    localObject10 = ((JSONObject)localObject9).optJSONObject("canvasSize");
                    if (localObject10 != null)
                    {
                      ((Rect)localObject8).width = ((int)((JSONObject)localObject10).optDouble("width", 720.0D));
                      ((Rect)localObject8).height = ((int)((JSONObject)localObject10).optDouble("height", 1280.0D));
                    }
                    localObject9 = ((JSONObject)localObject9).optJSONArray("canvasRectList");
                    if ((localObject9 != null) && (((JSONArray)localObject9).length() > 0))
                    {
                      j = 0;
                      while (j < ((JSONArray)localObject9).length())
                      {
                        localObject10 = new GridModel();
                        localObject11 = new Rect(0, 0, 720, 1280);
                        localObject12 = ((JSONArray)localObject9).optJSONObject(j);
                        if (localObject12 != null)
                        {
                          ((Rect)localObject11).x = ((int)((JSONObject)localObject12).optDouble("left", 0.0D));
                          ((Rect)localObject11).y = ((int)((JSONObject)localObject12).optDouble("top", 0.0D));
                          ((Rect)localObject11).width = ((int)((JSONObject)localObject12).optDouble("width", 720.0D));
                          ((Rect)localObject11).height = ((int)((JSONObject)localObject12).optDouble("height", 1280.0D));
                          ((GridModel)localObject10).renderId = ((JSONObject)localObject12).optInt("renderId", 0);
                          ((GridModel)localObject10).zIndex = ((JSONObject)localObject12).optInt("zIndex", 0);
                          ((GridModel)localObject10).aspectMode = ((JSONObject)localObject12).optInt("aspectMode", 0);
                          ((GridModel)localObject10).positionMode = ((JSONObject)localObject12).optInt("positionMode", 0);
                          ((GridModel)localObject10).transformType = ((JSONObject)localObject12).optInt("transformType", 0);
                        }
                        ((GridModel)localObject10).canvasRect = ((Rect)localObject11);
                        ((GridSettingModel)localObject7).canvasRectList.add(localObject10);
                        j += 1;
                      }
                      Collections.sort(((GridSettingModel)localObject7).canvasRectList, mGridModelComparator);
                    }
                    ((GridSettingModel)localObject7).canvasRect = ((Rect)localObject8);
                    localFabbyMvPart.gridSettingMap.add(Pair.create(Float.valueOf((String)localObject6), localObject7));
                  }
                }
              }
            }
            Collections.sort(localFabbyMvPart.gridSettingMap, mDivideValueCompForObject);
            localFabbyMvPart.gridModeMap.clear();
            localObject2 = ((JSONObject)localObject1).optJSONObject("gridMode");
            if (localObject2 != null)
            {
              localObject5 = ((JSONObject)localObject2).keys();
              while (((Iterator)localObject5).hasNext())
              {
                localObject6 = (String)((Iterator)localObject5).next();
                localFabbyMvPart.gridModeMap.add(Pair.create(Float.valueOf((String)localObject6), Integer.valueOf(((JSONObject)localObject2).optInt((String)localObject6, 0))));
              }
            }
            Collections.sort(localFabbyMvPart.gridModeMap, mDivideValueComp);
            localFabbyMvPart.gridOrderMap.clear();
            localObject1 = ((JSONObject)localObject1).optJSONObject("gridOrder");
            if (localObject1 != null)
            {
              localObject2 = ((JSONObject)localObject1).keys();
              while (((Iterator)localObject2).hasNext())
              {
                localObject5 = (String)((Iterator)localObject2).next();
                localFabbyMvPart.gridOrderMap.add(Pair.create(Float.valueOf((String)localObject5), Integer.valueOf(((JSONObject)localObject1).optInt((String)localObject5, 0))));
              }
            }
            Collections.sort(localFabbyMvPart.gridOrderMap, mDivideValueComp);
          }
          localObject5 = ((JSONObject)localObject4).optJSONObject("finishTransition");
          int k;
          if (localObject5 != null)
          {
            localObject6 = new StickerItem();
            localObject1 = ((JSONObject)localObject5).optString("maskVideoFile");
            localObject2 = ((JSONObject)localObject5).optString("maskImageName");
            j = ((JSONObject)localObject5).optInt("transitionFunction", 0);
            if ((TextUtils.isEmpty((CharSequence)localObject1)) && (TextUtils.isEmpty((CharSequence)localObject2))) {
              break label3523;
            }
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              break label3449;
            }
            k = ((String)localObject1).lastIndexOf("/");
            ((StickerItem)localObject6).id = ((String)localObject1).substring(k + 1, ((String)localObject1).length());
            ((StickerItem)localObject6).subFolder = ((String)localObject1).substring(0, k);
          }
          for (;;)
          {
            ((StickerItem)localObject6).frames = ((JSONObject)localObject5).optInt("maskImageCount", 1);
            ((StickerItem)localObject6).frameDuration = (((JSONObject)localObject5).optDouble("maskImageDuration", 0.0D) / ((StickerItem)localObject6).frames * 1000.0D);
            ((StickerItem)localObject6).triggerType = ((JSONObject)localObject5).optInt("triggerType", 0);
            if ((((StickerItem)localObject6).triggerType == 1) && (paramVideoMaterial.getItemList() != null) && (paramVideoMaterial.getItemList().size() != 0)) {
              ((StickerItem)localObject6).triggerType = ((StickerItem)paramVideoMaterial.getItemList().get(paramVideoMaterial.getItemList().size() - 1)).triggerType;
            }
            localFabbyMvPart.transitionItem = ((StickerItem)localObject6);
            localFabbyMvPart.transitionDuration = ((((JSONObject)localObject5).optDouble("duration", 0.0D) * 1000.0D));
            localFabbyMvPart.transitionEase = ((JSONObject)localObject5).optInt("easeCurve", 0);
            localFabbyMvPart.transitionMaskType = ((JSONObject)localObject5).optInt("maskType", 1);
            localFabbyMvPart.transitionFunction = j;
            localObject1 = ((JSONObject)localObject4).optJSONObject("filterEffect");
            if (localObject1 == null) {
              break label3553;
            }
            localFabbyMvPart.filterType = ((JSONObject)localObject1).optInt("type", 0);
            localFabbyMvPart.filterId = ((JSONObject)localObject1).optString("filter");
            localFabbyMvPart.lutFile = ((JSONObject)localObject1).optString("lutFile");
            localFabbyMvPart.filterParamMap.clear();
            localObject1 = ((JSONObject)localObject1).optJSONObject("param");
            if (localObject1 == null) {
              break label3553;
            }
            localObject2 = ((JSONObject)localObject1).keys();
            while (((Iterator)localObject2).hasNext())
            {
              localObject4 = (String)((Iterator)localObject2).next();
              localFabbyMvPart.filterParamMap.add(Pair.create(Float.valueOf((String)localObject4), Integer.valueOf(((JSONObject)localObject1).optInt((String)localObject4, 0))));
            }
            localObject1 = localObject2;
            if (((String)localObject2).endsWith("_")) {
              localObject1 = ((String)localObject2).substring(0, ((String)localObject2).length() - 1);
            }
            k = ((String)localObject1).lastIndexOf("/");
            ((StickerItem)localObject6).id = ((String)localObject1).substring(k + 1, ((String)localObject1).length());
            ((StickerItem)localObject6).subFolder = ((String)localObject1).substring(0, k);
            continue;
            ((StickerItem)localObject6).id = "";
            ((StickerItem)localObject6).subFolder = "";
          }
          Collections.sort(localFabbyMvPart.filterParamMap, mDivideValueComp);
          localFabbyMvPart.duration = ((1000.0D * d));
          localFabbyMvPart.partIndex = i;
          ((List)localObject3).add(localFabbyMvPart);
        }
        i += 1;
      }
      localObject1 = localJSONObject.optString("bgmAudio", "");
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        paramVideoMaterial.setHasAudio(true);
      }
      paramVideoMaterial.setFabbyParts(new FabbyParts((List)localObject3, (String)localObject1));
      paramJSONObject = paramJSONObject.optJSONArray(VideoMaterialUtil.FIELD.MULTI_VIEWER.value);
    } while (paramJSONObject == null);
    label538:
    label1186:
    label1351:
    label1385:
    label3449:
    Object localObject1 = new ArrayList();
    label3523:
    label3553:
    int i = 0;
    while (i < paramJSONObject.length())
    {
      localObject2 = new MultiViewerItem();
      localObject3 = paramJSONObject.optJSONObject(i);
      if (localObject3 != null)
      {
        ((MultiViewerItem)localObject2).videoMaterial = parseVideoMaterial(paramString, ((JSONObject)localObject3).optString("importMaterial"), true, paramDecryptListener);
        ((MultiViewerItem)localObject2).renderId = ((JSONObject)localObject3).optInt("renderId");
        localObject3 = ((JSONObject)localObject3).optJSONArray("activeParts");
        if (localObject3 != null)
        {
          j = 0;
          while (j < ((JSONArray)localObject3).length())
          {
            ((MultiViewerItem)localObject2).activeParts.add(Integer.valueOf(((JSONArray)localObject3).optInt(j)));
            j += 1;
          }
        }
      }
      ((List)localObject1).add(localObject2);
      i += 1;
    }
    paramVideoMaterial.setMultiViewerItemList((List)localObject1);
  }
  
  public static VideoMaterial parseVideoMaterial(String paramString)
  {
    return parseVideoMaterial(paramString, "params", true, decryptListener);
  }
  
  public static VideoMaterial parseVideoMaterial(String paramString, DecryptListener paramDecryptListener)
  {
    return parseVideoMaterial(null, parseVideoMaterialString(paramString, paramDecryptListener), paramDecryptListener);
  }
  
  public static VideoMaterial parseVideoMaterial(String paramString1, String paramString2, boolean paramBoolean, DecryptListener paramDecryptListener)
  {
    return parseVideoMaterial(paramString1, parseVideoMaterialFile(paramString1, paramString2, paramBoolean, paramDecryptListener), paramDecryptListener);
  }
  
  private static VideoMaterial parseVideoMaterial(String paramString, JSONObject paramJSONObject, DecryptListener paramDecryptListener)
  {
    VideoMaterial localVideoMaterial = new VideoMaterial();
    localVideoMaterial.setDataPath(paramString);
    if (paramJSONObject == null) {
      return localVideoMaterial;
    }
    boolean bool1;
    label344:
    Object localObject1;
    label635:
    Object localObject2;
    label659:
    int i;
    boolean bool2;
    Object localObject3;
    int j;
    label778:
    Object localObject5;
    Object localObject4;
    label1143:
    Object localObject6;
    label1360:
    Object localObject7;
    label1450:
    label1984:
    int k;
    label2041:
    Object localObject8;
    label2136:
    Object localObject9;
    label2189:
    label2326:
    label2351:
    Object localObject10;
    String str1;
    String str2;
    try
    {
      localVideoMaterial.setId(VideoMaterialUtil.getMaterialId(paramString));
      localVideoMaterial.setMinAppVersion(paramJSONObject.optInt(VideoMaterialUtil.FIELD.MIN_APP_VERSION.value));
      localVideoMaterial.setCategoryFlag(paramJSONObject.optInt(VideoMaterialUtil.FIELD.CATEGORY_FLAG.value, 0));
      localVideoMaterial.setShaderType(paramJSONObject.optInt(VideoMaterialUtil.FIELD.SHADER_TYPE.value));
      localVideoMaterial.setFaceoffType(paramJSONObject.optInt(VideoMaterialUtil.FIELD.FACE_OFF_TYPE.value));
      localVideoMaterial.setFaceSwapType(paramJSONObject.optInt(VideoMaterialUtil.FIELD.FACE_SWAP_TYPE.value));
      localVideoMaterial.setMaxFaceCount(paramJSONObject.optInt(VideoMaterialUtil.FIELD.MAX_FACE_COUNT.value));
      localVideoMaterial.setFaceExchangeImage(paramJSONObject.optString(VideoMaterialUtil.FIELD.FACE_EXCHANGE_IMAGE.value));
      localVideoMaterial.setImageFacePointsFileName(paramJSONObject.optString(VideoMaterialUtil.FIELD.IMAGE_FACE_POINTS_FILE_NAME.value));
      localVideoMaterial.setBlendAlpha(paramJSONObject.optDouble(VideoMaterialUtil.FIELD.BLEND_ALPHA.value));
      localVideoMaterial.setGrayScale(paramJSONObject.optInt(VideoMaterialUtil.FIELD.GRAY_SCALE.value));
      localVideoMaterial.setOrderMode(paramJSONObject.optInt(VideoMaterialUtil.FIELD.ORDER_MODE.value));
      localVideoMaterial.setBlendMode(paramJSONObject.optInt(VideoMaterialUtil.FIELD.BLEND_MODE.value));
      localVideoMaterial.setFeatureType(paramJSONObject.optInt(VideoMaterialUtil.FIELD.FEATURE_TYPE.value));
      localVideoMaterial.setFilterId(paramJSONObject.optString(VideoMaterialUtil.FIELD.FILTER_ID.value));
      localVideoMaterial.setArParticleType(paramJSONObject.optInt(VideoMaterialUtil.FIELD.AR_PARTICLE_TYPE.value));
      if (paramJSONObject.optInt(VideoMaterialUtil.FIELD.SUPPORT_LANDSCAPE.value, 1) != 1) {
        break label10774;
      }
      bool1 = true;
      localVideoMaterial.setSupportLandscape(bool1);
      localVideoMaterial.setRandomGroupCount(paramJSONObject.optInt(VideoMaterialUtil.FIELD.RANDOM_GROUP_COUNT.value));
      localVideoMaterial.setTipsText(paramJSONObject.optString(VideoMaterialUtil.FIELD.TIPS_TEXT.value));
      localVideoMaterial.setTipsIcon(paramJSONObject.optString(VideoMaterialUtil.FIELD.TIPS_ICON.value));
      if (paramJSONObject.optInt(VideoMaterialUtil.FIELD.USE_MESH.value, 0) == 0) {
        break label10780;
      }
      bool1 = true;
      localVideoMaterial.setUseMesh(bool1);
      if (!TextUtils.isEmpty(paramJSONObject.optString(VideoMaterialUtil.FIELD.AD_ICON.value))) {
        localVideoMaterial.setAdIcon(paramString + File.separator + paramJSONObject.optString(VideoMaterialUtil.FIELD.AD_ICON.value));
      }
      localVideoMaterial.setAdLink(paramJSONObject.optString(VideoMaterialUtil.FIELD.AD_LINK.value));
      localVideoMaterial.setAdAppLink(paramJSONObject.optString(VideoMaterialUtil.FIELD.AD_APP_LINK.value));
      localVideoMaterial.setWeiboTag(paramJSONObject.optString("weiboTag"));
      localVideoMaterial.setDetectorFlag(paramJSONObject.optInt(VideoMaterialUtil.FIELD.DETECTOR_FLAG.value));
      localVideoMaterial.setLipsLutPath(paramJSONObject.optString(VideoMaterialUtil.FIELD.LIPS_LUT.value));
      if (!TextUtils.isEmpty(paramJSONObject.optString(VideoMaterialUtil.GAME_FIELD.GAME_NAME.value)))
      {
        localObject1 = new GameParams();
        ((GameParams)localObject1).mGameName = paramJSONObject.optString(VideoMaterialUtil.GAME_FIELD.GAME_NAME.value);
        ((GameParams)localObject1).mAnimNames = paramJSONObject.optString(VideoMaterialUtil.GAME_FIELD.ANIM_NAMES.value);
        ((GameParams)localObject1).mAnimDefaultRotate = paramJSONObject.optString(VideoMaterialUtil.GAME_FIELD.ANIM_DEFAULT_ROTATE.value);
        ((GameParams)localObject1).mAnimNodeNames = paramJSONObject.optString(VideoMaterialUtil.GAME_FIELD.ANIM_NODE_NAMES.value);
        ((GameParams)localObject1).mRunningAnimName = paramJSONObject.optString(VideoMaterialUtil.GAME_FIELD.RUNNING_ANIM_NAME.value);
        ((GameParams)localObject1).mRunningAnimDefaultRotate = paramJSONObject.optString(VideoMaterialUtil.GAME_FIELD.RUNNING_ANIM_DEFAULT_ROTATE.value);
        localVideoMaterial.setGameParams((GameParams)localObject1);
        localVideoMaterial.setFov((float)paramJSONObject.optDouble(VideoMaterialUtil.GAME_FIELD.FOV.value, 60.0D));
        if (paramJSONObject.optInt(VideoMaterialUtil.GAME_FIELD.NOT_FLATTEN_EAR.value, 0) != 0) {
          break label10786;
        }
        bool1 = true;
        localVideoMaterial.setFlattenEar(bool1);
        if (paramJSONObject.optInt(VideoMaterialUtil.GAME_FIELD.NOT_FLATTEN_NOSE.value, 0) != 0) {
          break label10792;
        }
        bool1 = true;
        localVideoMaterial.setFlattenNose(bool1);
      }
      localObject1 = new ArrayList();
      localObject2 = paramJSONObject.optJSONArray(VideoMaterialUtil.FIELD.RESOURCE_LIST.value);
      if (localObject2 != null)
      {
        i = 0;
        while (i < ((JSONArray)localObject2).length())
        {
          ((List)localObject1).add(((JSONArray)localObject2).optString(i));
          i += 1;
        }
        localVideoMaterial.setResourceList((List)localObject1);
      }
      bool1 = false;
      bool2 = false;
      localObject2 = new ArrayList();
      localObject3 = paramJSONObject.optJSONArray(VideoMaterialUtil.FIELD.ITEM_LIST.value);
      if (localObject3 == null) {
        break label3164;
      }
      j = 0;
      i = 0;
      bool1 = bool2;
      if (i >= ((JSONArray)localObject3).length()) {
        break label3088;
      }
      localObject5 = ((JSONArray)localObject3).getJSONObject(i);
      localObject4 = new StickerItem();
      ((StickerItem)localObject4).id = ((JSONObject)localObject5).optString("id");
      ((StickerItem)localObject4).subFolder = ((StickerItem)localObject4).id;
      ((StickerItem)localObject4).name = ((JSONObject)localObject5).optString("name");
      ((StickerItem)localObject4).type = ((JSONObject)localObject5).optInt("type");
      ((StickerItem)localObject4).personID = ((JSONObject)localObject5).optInt("personID", -1);
      ((StickerItem)localObject4).featureStatType = ((JSONObject)localObject5).optInt("featureStatType");
      ((StickerItem)localObject4).frameType = ((JSONObject)localObject5).optInt("frameType");
      ((StickerItem)localObject4).blendMode = ((JSONObject)localObject5).optInt("blendMode", -1);
      ((StickerItem)localObject4).zIndex = ((JSONObject)localObject5).optInt("zIndex");
      ((StickerItem)localObject4).audioLoopCount = ((JSONObject)localObject5).optInt("audioLoopCount", -1);
      ((StickerItem)localObject4).randomGroupNum = ((JSONObject)localObject5).optInt("randomGroupNum");
      localObject1 = ((JSONObject)localObject5).optJSONObject("featureStatValueRange");
      if (localObject1 != null)
      {
        ((StickerItem)localObject4).featureStatValueRange = new StickerItem.FeatureStatValueRange();
        ((StickerItem)localObject4).featureStatValueRange.min = ((JSONObject)localObject1).optDouble("min");
        ((StickerItem)localObject4).featureStatValueRange.max = ((JSONObject)localObject1).optDouble("max");
      }
      localObject1 = ((JSONObject)localObject5).optJSONObject(VideoMaterialUtil.FIELD.CHARM_RANGE.value);
      if (localObject1 != null)
      {
        ((StickerItem)localObject4).charmRange = new CharmRange();
        ((StickerItem)localObject4).charmRange.min = ((JSONObject)localObject1).optDouble(VideoMaterialUtil.CHARM_RANGE_FIELD.MIN.value);
        ((StickerItem)localObject4).charmRange.max = ((JSONObject)localObject1).optDouble(VideoMaterialUtil.CHARM_RANGE_FIELD.MAX.value);
      }
      if (((StickerItem)localObject4).blendMode == -1) {
        ((StickerItem)localObject4).blendMode = localVideoMaterial.getBlendMode();
      }
      ((StickerItem)localObject4).triggerType = ((JSONObject)localObject5).optInt("triggerType");
      if (VideoMaterialUtil.isActionTriggerType(((StickerItem)localObject4).triggerType)) {
        localVideoMaterial.setTriggerType(((StickerItem)localObject4).triggerType);
      }
      if (((JSONObject)localObject5).optInt("alwaysTriggered") != 1) {
        break label10798;
      }
      bool2 = true;
      ((StickerItem)localObject4).alwaysTriggered = bool2;
      ((StickerItem)localObject4).playCount = ((JSONObject)localObject5).optInt("playCount");
      ((StickerItem)localObject4).frameDuration = ((JSONObject)localObject5).optDouble("frameDuration");
      ((StickerItem)localObject4).stickerType = ((JSONObject)localObject5).optInt("stickerType", 0);
      if ((((StickerItem)localObject4).stickerType == VideoFilterFactory.STICKER_TYPE.VIDEO_UP_DOWN.type) || (((StickerItem)localObject4).stickerType == VideoFilterFactory.STICKER_TYPE.VIDEO_LEFT_RIGHT.type)) {
        if (((StickerItem)localObject4).stickerType != VideoFilterFactory.STICKER_TYPE.VIDEO_UP_DOWN.type) {
          break label1360;
        }
      }
      for (localObject1 = VideoMaterialUtil.ITEM_SOURCE_TYPE.VIDEO_UP_DOWN;; localObject1 = VideoMaterialUtil.ITEM_SOURCE_TYPE.VIDEO_LEFT_RIGHT)
      {
        ((StickerItem)localObject4).sourceType = ((VideoMaterialUtil.ITEM_SOURCE_TYPE)localObject1);
        ((StickerItem)localObject4).frames = ((JSONObject)localObject5).optInt("frames");
        ((StickerItem)localObject4).width = ((JSONObject)localObject5).optInt("width");
        ((StickerItem)localObject4).height = ((JSONObject)localObject5).optInt("height");
        ((StickerItem)localObject4).support3D = ((JSONObject)localObject5).optInt("enable3D", 1);
        localObject1 = ((JSONObject)localObject5).optJSONArray("position");
        if (localObject1 == null) {
          break;
        }
        ((StickerItem)localObject4).position = new double[((JSONArray)localObject1).length()];
        j = 0;
        while (j < ((JSONArray)localObject1).length())
        {
          ((StickerItem)localObject4).position[j] = ((JSONArray)localObject1).getDouble(j);
          j += 1;
        }
      }
      ((StickerItem)localObject4).position = new double[] { 0.0D, 0.0D };
      ((StickerItem)localObject4).audio = ((JSONObject)localObject5).optString("audio");
      bool2 = bool1;
      if (!TextUtils.isEmpty(((StickerItem)localObject4).audio))
      {
        bool2 = bool1;
        if (!TextUtils.isEmpty(paramString))
        {
          if (paramString.startsWith("assets://camera/camera_video/video_")) {
            break label10804;
          }
          bool2 = bool1;
          if (paramString.contains("/files/olm/camera/video_")) {
            break label10804;
          }
        }
      }
      localObject1 = ((JSONObject)localObject5).optJSONArray("anchorPoint");
      if (localObject1 != null)
      {
        ((StickerItem)localObject4).anchorPoint = new int[((JSONArray)localObject1).length()];
        j = 0;
        while (j < ((JSONArray)localObject1).length())
        {
          ((StickerItem)localObject4).anchorPoint[j] = ((JSONArray)localObject1).getInt(j);
          j += 1;
        }
      }
      localObject1 = ((JSONObject)localObject5).optJSONArray("alignFacePoints");
      if (localObject1 != null)
      {
        ((StickerItem)localObject4).alignFacePoints = new int[((JSONArray)localObject1).length()];
        j = 0;
        while (j < ((JSONArray)localObject1).length())
        {
          ((StickerItem)localObject4).alignFacePoints[j] = ((JSONArray)localObject1).getInt(j);
          j += 1;
        }
      }
      localObject1 = ((JSONObject)localObject5).optJSONArray("scalePivots");
      if (localObject1 != null)
      {
        ((StickerItem)localObject4).scalePivots = new int[((JSONArray)localObject1).length()];
        j = 0;
        while (j < ((JSONArray)localObject1).length())
        {
          ((StickerItem)localObject4).scalePivots[j] = ((JSONArray)localObject1).getInt(j);
          j += 1;
        }
      }
      ((StickerItem)localObject4).scaleFactor = ((JSONObject)localObject5).optInt("scaleFactor");
      ((StickerItem)localObject4).markMode = ((JSONObject)localObject5).optInt("markMode");
      ((StickerItem)localObject4).activateTriggerType = ((JSONObject)localObject5).optInt("activateTriggerType", 0);
      ((StickerItem)localObject4).activateTriggerCount = ((JSONObject)localObject5).optInt("activateTriggerCount", 0);
      ((StickerItem)localObject4).activateTriggerTotalCount = ((JSONObject)localObject5).optInt("activateTriggerTotalCount", 0);
      localObject1 = ((JSONObject)localObject5).optJSONObject("ageRange");
      if (localObject1 != null)
      {
        ((StickerItem)localObject4).ageRange = new AgeRange();
        ((StickerItem)localObject4).ageRange.min = ((float)((JSONObject)localObject1).optDouble("min"));
        ((StickerItem)localObject4).ageRange.max = ((float)((JSONObject)localObject1).optDouble("max"));
      }
      localObject1 = ((JSONObject)localObject5).optJSONObject("genderRange");
      if (localObject1 != null)
      {
        ((StickerItem)localObject4).genderRange = new GenderRange();
        ((StickerItem)localObject4).genderRange.min = ((float)((JSONObject)localObject1).optDouble("min"));
        ((StickerItem)localObject4).genderRange.max = ((float)((JSONObject)localObject1).optDouble("max"));
      }
      localObject1 = ((JSONObject)localObject5).optJSONObject("popularRange");
      if (localObject1 != null)
      {
        ((StickerItem)localObject4).popularRange = new PopularRange();
        ((StickerItem)localObject4).popularRange.min = ((float)((JSONObject)localObject1).optDouble("min"));
        ((StickerItem)localObject4).popularRange.max = ((float)((JSONObject)localObject1).optDouble("max"));
      }
      localObject1 = ((JSONObject)localObject5).optJSONObject("cpRange");
      if (localObject1 != null)
      {
        ((StickerItem)localObject4).cpRange = new CpRange();
        ((StickerItem)localObject4).cpRange.min = ((float)((JSONObject)localObject1).optDouble("min"));
        ((StickerItem)localObject4).cpRange.max = ((float)((JSONObject)localObject1).optDouble("max"));
      }
      localObject5 = ((JSONObject)localObject5).optJSONArray(VideoMaterialUtil.FIELD.WATERMARK_GROUP.value);
      if (localObject5 == null) {
        break label3048;
      }
      localObject6 = new WMGroup();
      j = 0;
      if (j >= ((JSONArray)localObject5).length()) {
        break label3041;
      }
      localObject7 = ((JSONArray)localObject5).optJSONObject(j);
      if (localObject7 == null) {
        break label10822;
      }
      k = ((JSONObject)localObject7).optInt(VideoMaterialUtil.WATERMARK_ELEMENT.WMTYPE.value);
      if (k != WMElement.WMType.TEXT.value) {
        break label2871;
      }
      localObject1 = new TextWMElement();
      ((WMElement)localObject1).sid = localVideoMaterial.getId();
      ((WMElement)localObject1).id = ((JSONObject)localObject7).optString(VideoMaterialUtil.WATERMARK_ELEMENT.ID.value);
      ((WMElement)localObject1).relativeID = ((JSONObject)localObject7).optString(VideoMaterialUtil.WATERMARK_ELEMENT.RELATIVE_ID.value);
      localObject8 = ((JSONObject)localObject7).optJSONArray(VideoMaterialUtil.WATERMARK_ELEMENT.RELATIVE_ANCHOR.value);
      if ((localObject8 == null) || (((JSONArray)localObject8).length() != 2)) {
        break label2883;
      }
      ((WMElement)localObject1).relativeAnchor = new PointF((float)((JSONArray)localObject8).getDouble(0), (float)((JSONArray)localObject8).getDouble(1));
      localObject8 = ((JSONObject)localObject7).optJSONArray(VideoMaterialUtil.WATERMARK_ELEMENT.ANCHOR.value);
      if ((localObject8 == null) || (((JSONArray)localObject8).length() != 2)) {
        break label2900;
      }
      ((WMElement)localObject1).anchor = new PointF((float)((JSONArray)localObject8).getDouble(0), (float)((JSONArray)localObject8).getDouble(1));
      ((WMElement)localObject1).offsetX = ((JSONObject)localObject7).optInt(VideoMaterialUtil.WATERMARK_ELEMENT.OFFSETX.value);
      ((WMElement)localObject1).offsetY = ((JSONObject)localObject7).optInt(VideoMaterialUtil.WATERMARK_ELEMENT.OFFSETY.value);
      ((WMElement)localObject1).width = ((JSONObject)localObject7).optInt(VideoMaterialUtil.WATERMARK_ELEMENT.WIDTH.value);
      ((WMElement)localObject1).height = ((JSONObject)localObject7).optInt(VideoMaterialUtil.WATERMARK_ELEMENT.HEIGHT.value);
      ((WMElement)localObject1).wmtype = k;
      ((WMElement)localObject1).edittype = ((JSONObject)localObject7).optInt(VideoMaterialUtil.WATERMARK_ELEMENT.EDITTYPE.value);
      ((WMElement)localObject1).fmtstr = ((JSONObject)localObject7).optString(VideoMaterialUtil.WATERMARK_ELEMENT.FMTSTR.value);
      ((WMElement)localObject1).fontName = ((JSONObject)localObject7).optString(VideoMaterialUtil.WATERMARK_ELEMENT.FONT_NAME.value);
      if (((JSONObject)localObject7).optInt(VideoMaterialUtil.WATERMARK_ELEMENT.FONT_BOLD.value) != 1) {
        break label10810;
      }
      bool1 = true;
      ((WMElement)localObject1).fontBold = bool1;
      if (((JSONObject)localObject7).optInt(VideoMaterialUtil.WATERMARK_ELEMENT.FONT_ITALICS.value) != 1) {
        break label10816;
      }
      bool1 = true;
      ((WMElement)localObject1).fontItalics = bool1;
      ((WMElement)localObject1).fontTexture = ((JSONObject)localObject7).optString(VideoMaterialUtil.WATERMARK_ELEMENT.FONT_TEXTURE.value);
      ((WMElement)localObject1).fontSize = ((float)((JSONObject)localObject7).optDouble(VideoMaterialUtil.WATERMARK_ELEMENT.FONT_SIZE.value, 20.0D));
      ((WMElement)localObject1).fontFit = ((JSONObject)localObject7).optInt(VideoMaterialUtil.WATERMARK_ELEMENT.FONT_FIT.value);
      ((WMElement)localObject1).kern = ((JSONObject)localObject7).optInt(VideoMaterialUtil.WATERMARK_ELEMENT.KERN.value);
      ((WMElement)localObject1).imgPath = ((JSONObject)localObject7).optString(VideoMaterialUtil.WATERMARK_ELEMENT.IMG_PATH.value);
      ((WMElement)localObject1).frameDuration = ((JSONObject)localObject7).optInt(VideoMaterialUtil.WATERMARK_ELEMENT.FRAME_DURATION.value);
      ((WMElement)localObject1).frames = ((JSONObject)localObject7).optInt(VideoMaterialUtil.WATERMARK_ELEMENT.FRAMES.value);
      ((WMElement)localObject1).color = ((JSONObject)localObject7).optString(VideoMaterialUtil.WATERMARK_ELEMENT.COLOR.value, "#FFFFFFFF");
      ((WMElement)localObject1).strokeColor = ((JSONObject)localObject7).optString(VideoMaterialUtil.WATERMARK_ELEMENT.STROKE_COLOR.value, "#FFFFFFFF");
      ((WMElement)localObject1).strokeSize = ((float)((JSONObject)localObject7).optDouble(VideoMaterialUtil.WATERMARK_ELEMENT.STROKE_SIZE.value, -1.0D));
      ((WMElement)localObject1).shadowColor = ((JSONObject)localObject7).optString(VideoMaterialUtil.WATERMARK_ELEMENT.SHADOW_COLOR.value, "#FFFFFFFF");
      ((WMElement)localObject1).shadowSize = ((float)((JSONObject)localObject7).optDouble(VideoMaterialUtil.WATERMARK_ELEMENT.SHADOW_SIZE.value, -1.0D));
      ((WMElement)localObject1).shadowDx = ((float)((JSONObject)localObject7).optDouble(VideoMaterialUtil.WATERMARK_ELEMENT.SHADOW_DX.value, -1.0D));
      ((WMElement)localObject1).shadowDy = ((float)((JSONObject)localObject7).optDouble(VideoMaterialUtil.WATERMARK_ELEMENT.SHADOW_DY.value, -1.0D));
      ((WMElement)localObject1).alignment = ((JSONObject)localObject7).optString(VideoMaterialUtil.WATERMARK_ELEMENT.ALIGNMENT.value);
      ((WMElement)localObject1).vertical = ((JSONObject)localObject7).optInt(VideoMaterialUtil.WATERMARK_ELEMENT.VERTICAL.value);
      ((WMElement)localObject1).animateType = ((JSONObject)localObject7).optString(VideoMaterialUtil.WATERMARK_ELEMENT.ANIMATE_TYPE.value);
      localObject8 = ((JSONObject)localObject7).optJSONObject(VideoMaterialUtil.WATERMARK_ELEMENT.LOGIC.value);
      if (localObject8 == null) {
        break label3025;
      }
      localObject7 = new WMLogic();
      ((WMLogic)localObject7).type = ((JSONObject)localObject8).optString(VideoMaterialUtil.WATERMARK_LOGIC.TYPE.value);
      ((WMLogic)localObject7).setCompare(((JSONObject)localObject8).optString(VideoMaterialUtil.WATERMARK_LOGIC.COMPARE.value), ((WMElement)localObject1).sid);
      ((WMLogic)localObject7).data = ((JSONObject)localObject8).optString(VideoMaterialUtil.WATERMARK_LOGIC.DATA.value);
      localObject9 = ((JSONObject)localObject8).optJSONObject(VideoMaterialUtil.WATERMARK_LOGIC.RANGE.value);
      if (localObject9 == null) {
        break label2925;
      }
      ((WMLogic)localObject7).range = new ArrayList();
      localObject10 = ((JSONObject)localObject9).keys();
      while (((Iterator)localObject10).hasNext())
      {
        str1 = (String)((Iterator)localObject10).next();
        str2 = ((JSONObject)localObject9).optString(str1);
        ((WMLogic)localObject7).range.add(new WMLogicPair(str1, str2));
      }
      VideoMaterialUtil.updateSupportLandscape(localVideoMaterial);
    }
    catch (JSONException paramString) {}
    label2833:
    VideoMaterialUtil.updateMaxFaceCount(localVideoMaterial);
    VideoMaterialUtil.updateFaceValueDetectType(localVideoMaterial);
    VideoMaterialUtil.updateItemImageType(localVideoMaterial);
    VideoMaterialUtil.updateWatermarkInfo(localVideoMaterial);
    VideoMaterialUtil.updateNeedFaceInfo(localVideoMaterial);
    for (;;)
    {
      try
      {
        checkValid(localVideoMaterial);
        return localVideoMaterial;
        label2871:
        localObject1 = new ImageWMElement();
        break label2041;
        label2883:
        ((WMElement)localObject1).relativeAnchor = new PointF(0.0F, 0.0F);
        break label2136;
        label2900:
        ((WMElement)localObject1).anchor = new PointF(0.0F, 0.0F);
        break label2189;
        Collections.sort(((WMLogic)localObject7).range);
        label2925:
        localObject8 = ((JSONObject)localObject8).optJSONObject(VideoMaterialUtil.WATERMARK_LOGIC.CASE.value);
        if (localObject8 != null)
        {
          ((WMLogic)localObject7).wmcase = new ArrayList();
          localObject9 = ((JSONObject)localObject8).keys();
          if (((Iterator)localObject9).hasNext())
          {
            localObject10 = (String)((Iterator)localObject9).next();
            str1 = ((JSONObject)localObject8).optString((String)localObject10);
            ((WMLogic)localObject7).wmcase.add(new WMLogicPair((String)localObject10, str1));
            continue;
          }
        }
        ((WMElement)localObject1).logic = ((WMLogic)localObject7);
        label3025:
        ((WMGroup)localObject6).wmElements.add(localObject1);
        break label10822;
        label3041:
        ((StickerItem)localObject4).wmGroup = ((WMGroup)localObject6);
        label3048:
        ((StickerItem)localObject4).preTriggerType = ((StickerItem)localObject4).triggerType;
        ((List)localObject2).add(localObject4);
        j = ((StickerItem)localObject4).triggerType;
        i += 1;
        bool1 = bool2;
        break label778;
        label3088:
        localObject1 = ((List)localObject2).iterator();
        if (((Iterator)localObject1).hasNext())
        {
          localObject3 = (StickerItem)((Iterator)localObject1).next();
          if (((StickerItem)localObject3).activateTriggerType == 0)
          {
            ((StickerItem)localObject3).countTriggerType = j;
            continue;
          }
          ((StickerItem)localObject3).playCount = 0;
          ((StickerItem)localObject3).countTriggerType = VideoMaterialUtil.TRIGGER_TYPE.MV_PART_INDEX.value;
          continue;
        }
        localVideoMaterial.setItemList((List)localObject2);
        label3164:
        localObject3 = new ArrayList();
        localObject2 = paramJSONObject.optJSONArray("itemList3D");
        bool2 = bool1;
        int m;
        if (localObject2 != null)
        {
          j = 0;
          i = 0;
          if (i < ((JSONArray)localObject2).length())
          {
            localObject5 = ((JSONArray)localObject2).getJSONObject(i);
            localObject4 = new StickerItem3D();
            localObject1 = ((JSONObject)localObject5).optJSONArray("scale");
            if (localObject1 != null)
            {
              ((StickerItem3D)localObject4).nodeScale = new float[((JSONArray)localObject1).length()];
              j = 0;
              if (j < ((JSONArray)localObject1).length())
              {
                ((StickerItem3D)localObject4).nodeScale[j] = ((float)((JSONArray)localObject1).getDouble(j));
                j += 1;
                continue;
              }
            }
            localObject1 = ((JSONObject)localObject5).optJSONArray("position");
            if (localObject1 != null)
            {
              ((StickerItem3D)localObject4).nodePosition = new float[((JSONArray)localObject1).length()];
              j = 0;
              if (j < ((JSONArray)localObject1).length())
              {
                ((StickerItem3D)localObject4).nodePosition[j] = ((float)((JSONArray)localObject1).getDouble(j));
                j += 1;
                continue;
              }
            }
            localObject1 = ((JSONObject)localObject5).optJSONArray("eulerAngles");
            if (localObject1 != null)
            {
              ((StickerItem3D)localObject4).nodeEulerAngles = new float[((JSONArray)localObject1).length()];
              j = 0;
              if (j < ((JSONArray)localObject1).length())
              {
                ((StickerItem3D)localObject4).nodeEulerAngles[j] = ((float)((JSONArray)localObject1).getDouble(j));
                j += 1;
                continue;
              }
            }
            ((StickerItem3D)localObject4).id = ((JSONObject)localObject5).optString("id");
            ((StickerItem3D)localObject4).frames = ((JSONObject)localObject5).optInt("frames");
            ((StickerItem3D)localObject4).frameDuration = ((JSONObject)localObject5).optDouble("frameDuration");
            if (((StickerItem3D)localObject4).frames > 0)
            {
              localObject1 = new NodeParameter();
              ((NodeParameter)localObject1).nodeId = ((StickerItem3D)localObject4).id;
              ((NodeParameter)localObject1).frames = ((StickerItem3D)localObject4).frames;
              ((NodeParameter)localObject1).frameDuration = ((int)((StickerItem3D)localObject4).frameDuration);
              ((StickerItem3D)localObject4).nodeParameter = ((NodeParameter)localObject1);
            }
            if (((StickerItem3D)localObject4).id.contains(":"))
            {
              localObject1 = ((StickerItem3D)localObject4).id.split(":");
              if (localObject1.length == 2) {
                ((StickerItem3D)localObject4).subFolder = localObject1[1];
              }
              ((StickerItem3D)localObject4).name = ((JSONObject)localObject5).optString("name");
              ((StickerItem3D)localObject4).type = ((JSONObject)localObject5).optInt("type");
              ((StickerItem3D)localObject4).personID = ((JSONObject)localObject5).optInt("personID", -1);
              ((StickerItem3D)localObject4).featureStatType = ((JSONObject)localObject5).optInt("featureStatType");
              ((StickerItem3D)localObject4).frameType = ((JSONObject)localObject5).optInt("frameType");
              ((StickerItem3D)localObject4).blendMode = ((JSONObject)localObject5).optInt("blendMode", -1);
              ((StickerItem3D)localObject4).zIndex = ((JSONObject)localObject5).optInt("zIndex", 0);
              ((StickerItem3D)localObject4).audioLoopCount = ((JSONObject)localObject5).optInt("audioLoopCount", -1);
              localObject1 = ((JSONObject)localObject5).optJSONObject(VideoMaterialUtil.FIELD.CHARM_RANGE.value);
              if (localObject1 != null)
              {
                ((StickerItem3D)localObject4).charmRange = new CharmRange();
                ((StickerItem3D)localObject4).charmRange.min = ((JSONObject)localObject1).optDouble(VideoMaterialUtil.CHARM_RANGE_FIELD.MIN.value);
                ((StickerItem3D)localObject4).charmRange.max = ((JSONObject)localObject1).optDouble(VideoMaterialUtil.CHARM_RANGE_FIELD.MAX.value);
              }
              if (((StickerItem3D)localObject4).blendMode == -1) {
                ((StickerItem3D)localObject4).blendMode = localVideoMaterial.getBlendMode();
              }
              ((StickerItem3D)localObject4).triggerType = ((JSONObject)localObject5).optInt("triggerType");
              if (VideoMaterialUtil.isActionTriggerType(((StickerItem3D)localObject4).triggerType)) {
                localVideoMaterial.setTriggerType(((StickerItem3D)localObject4).triggerType);
              }
              if (((JSONObject)localObject5).optInt("alwaysTriggered") != 1) {
                break label10831;
              }
              bool2 = true;
              ((StickerItem3D)localObject4).alwaysTriggered = bool2;
              ((StickerItem3D)localObject4).playCount = ((JSONObject)localObject5).optInt("playCount");
              ((StickerItem3D)localObject4).stickerType = ((JSONObject)localObject5).optInt("stickerType", 0);
              if ((((StickerItem3D)localObject4).stickerType == VideoFilterFactory.STICKER_TYPE.VIDEO_UP_DOWN.type) || (((StickerItem3D)localObject4).stickerType == VideoFilterFactory.STICKER_TYPE.VIDEO_LEFT_RIGHT.type))
              {
                if (((StickerItem3D)localObject4).stickerType == VideoFilterFactory.STICKER_TYPE.VIDEO_UP_DOWN.type)
                {
                  localObject1 = VideoMaterialUtil.ITEM_SOURCE_TYPE.VIDEO_UP_DOWN;
                  ((StickerItem3D)localObject4).sourceType = ((VideoMaterialUtil.ITEM_SOURCE_TYPE)localObject1);
                }
              }
              else
              {
                ((StickerItem3D)localObject4).width = ((JSONObject)localObject5).optInt("width");
                ((StickerItem3D)localObject4).height = ((JSONObject)localObject5).optInt("height");
                ((StickerItem3D)localObject4).support3D = ((JSONObject)localObject5).optInt("enable3D", 1);
                localObject1 = ((JSONObject)localObject5).optJSONArray("position");
                if (localObject1 == null) {
                  continue;
                }
                ((StickerItem3D)localObject4).position = new double[((JSONArray)localObject1).length()];
                j = 0;
                if (j >= ((JSONArray)localObject1).length()) {
                  continue;
                }
                ((StickerItem3D)localObject4).position[j] = ((JSONArray)localObject1).getDouble(j);
                j += 1;
                continue;
              }
            }
            else
            {
              ((StickerItem3D)localObject4).subFolder = ((StickerItem3D)localObject4).id;
              continue;
            }
            localObject1 = VideoMaterialUtil.ITEM_SOURCE_TYPE.VIDEO_LEFT_RIGHT;
            continue;
            ((StickerItem3D)localObject4).position = new double[] { 0.0D, 0.0D };
            ((StickerItem3D)localObject4).audio = ((JSONObject)localObject5).optString("audio");
            bool2 = bool1;
            if (!TextUtils.isEmpty(((StickerItem3D)localObject4).audio))
            {
              bool2 = bool1;
              if (!TextUtils.isEmpty(paramString))
              {
                if (paramString.startsWith("assets://camera/camera_video/video_")) {
                  break label10837;
                }
                bool2 = bool1;
                if (paramString.contains("/files/olm/camera/video_")) {
                  break label10837;
                }
              }
            }
            localObject1 = ((JSONObject)localObject5).optJSONArray("anchorPoint");
            if (localObject1 != null)
            {
              ((StickerItem3D)localObject4).anchorPoint = new int[((JSONArray)localObject1).length()];
              j = 0;
              if (j < ((JSONArray)localObject1).length())
              {
                ((StickerItem3D)localObject4).anchorPoint[j] = ((JSONArray)localObject1).getInt(j);
                j += 1;
                continue;
              }
            }
            localObject1 = ((JSONObject)localObject5).optJSONArray("alignFacePoints");
            if (localObject1 != null)
            {
              ((StickerItem3D)localObject4).alignFacePoints = new int[((JSONArray)localObject1).length()];
              j = 0;
              if (j < ((JSONArray)localObject1).length())
              {
                ((StickerItem3D)localObject4).alignFacePoints[j] = ((JSONArray)localObject1).getInt(j);
                j += 1;
                continue;
              }
            }
            localObject1 = ((JSONObject)localObject5).optJSONArray("scalePivots");
            if (localObject1 != null)
            {
              ((StickerItem3D)localObject4).scalePivots = new int[((JSONArray)localObject1).length()];
              j = 0;
              if (j < ((JSONArray)localObject1).length())
              {
                ((StickerItem3D)localObject4).scalePivots[j] = ((JSONArray)localObject1).getInt(j);
                j += 1;
                continue;
              }
            }
            ((StickerItem3D)localObject4).scaleFactor = ((JSONObject)localObject5).optInt("scaleFactor");
            ((StickerItem3D)localObject4).markMode = ((JSONObject)localObject5).optInt("markMode");
            ((StickerItem3D)localObject4).activateTriggerType = ((JSONObject)localObject5).optInt("activateTriggerType", 0);
            ((StickerItem3D)localObject4).activateTriggerCount = ((JSONObject)localObject5).optInt("activateTriggerCount", 0);
            ((StickerItem3D)localObject4).activateTriggerTotalCount = ((JSONObject)localObject5).optInt("activateTriggerTotalCount", 0);
            localObject1 = ((JSONObject)localObject5).optJSONObject("ageRange");
            if (localObject1 != null)
            {
              ((StickerItem3D)localObject4).ageRange = new AgeRange();
              ((StickerItem3D)localObject4).ageRange.min = ((float)((JSONObject)localObject1).optDouble("min"));
              ((StickerItem3D)localObject4).ageRange.max = ((float)((JSONObject)localObject1).optDouble("max"));
            }
            localObject1 = ((JSONObject)localObject5).optJSONObject("genderRange");
            if (localObject1 != null)
            {
              ((StickerItem3D)localObject4).genderRange = new GenderRange();
              ((StickerItem3D)localObject4).genderRange.min = ((float)((JSONObject)localObject1).optDouble("min"));
              ((StickerItem3D)localObject4).genderRange.max = ((float)((JSONObject)localObject1).optDouble("max"));
            }
            localObject1 = ((JSONObject)localObject5).optJSONObject("popularRange");
            if (localObject1 != null)
            {
              ((StickerItem3D)localObject4).popularRange = new PopularRange();
              ((StickerItem3D)localObject4).popularRange.min = ((float)((JSONObject)localObject1).optDouble("min"));
              ((StickerItem3D)localObject4).popularRange.max = ((float)((JSONObject)localObject1).optDouble("max"));
            }
            localObject1 = ((JSONObject)localObject5).optJSONObject("cpRange");
            if (localObject1 != null)
            {
              ((StickerItem3D)localObject4).cpRange = new CpRange();
              ((StickerItem3D)localObject4).cpRange.min = ((float)((JSONObject)localObject1).optDouble("min"));
              ((StickerItem3D)localObject4).cpRange.max = ((float)((JSONObject)localObject1).optDouble("max"));
            }
            localObject5 = ((JSONObject)localObject5).optJSONArray(VideoMaterialUtil.FIELD.WATERMARK_GROUP.value);
            if (localObject5 != null)
            {
              localObject6 = new WMGroup();
              j = 0;
              if (j < ((JSONArray)localObject5).length())
              {
                localObject7 = ((JSONArray)localObject5).optJSONObject(j);
                if (localObject7 == null) {
                  break label10855;
                }
                k = ((JSONObject)localObject7).optInt(VideoMaterialUtil.WATERMARK_ELEMENT.WMTYPE.value);
                if (k == WMElement.WMType.TEXT.value)
                {
                  localObject1 = new TextWMElement();
                  ((WMElement)localObject1).sid = localVideoMaterial.getId();
                  ((WMElement)localObject1).id = ((JSONObject)localObject7).optString(VideoMaterialUtil.WATERMARK_ELEMENT.ID.value);
                  ((WMElement)localObject1).relativeID = ((JSONObject)localObject7).optString(VideoMaterialUtil.WATERMARK_ELEMENT.RELATIVE_ID.value);
                  localObject8 = ((JSONObject)localObject7).optJSONArray(VideoMaterialUtil.WATERMARK_ELEMENT.RELATIVE_ANCHOR.value);
                  if ((localObject8 != null) && (((JSONArray)localObject8).length() == 2))
                  {
                    ((WMElement)localObject1).relativeAnchor = new PointF((float)((JSONArray)localObject8).getDouble(0), (float)((JSONArray)localObject8).getDouble(1));
                    localObject8 = ((JSONObject)localObject7).optJSONArray(VideoMaterialUtil.WATERMARK_ELEMENT.ANCHOR.value);
                    if ((localObject8 == null) || (((JSONArray)localObject8).length() != 2)) {
                      continue;
                    }
                    ((WMElement)localObject1).anchor = new PointF((float)((JSONArray)localObject8).getDouble(0), (float)((JSONArray)localObject8).getDouble(1));
                    ((WMElement)localObject1).offsetX = ((JSONObject)localObject7).optInt(VideoMaterialUtil.WATERMARK_ELEMENT.OFFSETX.value);
                    ((WMElement)localObject1).offsetY = ((JSONObject)localObject7).optInt(VideoMaterialUtil.WATERMARK_ELEMENT.OFFSETY.value);
                    ((WMElement)localObject1).width = ((JSONObject)localObject7).optInt(VideoMaterialUtil.WATERMARK_ELEMENT.WIDTH.value);
                    ((WMElement)localObject1).height = ((JSONObject)localObject7).optInt(VideoMaterialUtil.WATERMARK_ELEMENT.HEIGHT.value);
                    ((WMElement)localObject1).wmtype = k;
                    ((WMElement)localObject1).edittype = ((JSONObject)localObject7).optInt(VideoMaterialUtil.WATERMARK_ELEMENT.EDITTYPE.value);
                    ((WMElement)localObject1).fmtstr = ((JSONObject)localObject7).optString(VideoMaterialUtil.WATERMARK_ELEMENT.FMTSTR.value);
                    ((WMElement)localObject1).fontName = ((JSONObject)localObject7).optString(VideoMaterialUtil.WATERMARK_ELEMENT.FONT_NAME.value);
                    if (((JSONObject)localObject7).optInt(VideoMaterialUtil.WATERMARK_ELEMENT.FONT_BOLD.value) != 1) {
                      break label10843;
                    }
                    bool1 = true;
                    ((WMElement)localObject1).fontBold = bool1;
                    if (((JSONObject)localObject7).optInt(VideoMaterialUtil.WATERMARK_ELEMENT.FONT_ITALICS.value) != 1) {
                      break label10849;
                    }
                    bool1 = true;
                    ((WMElement)localObject1).fontItalics = bool1;
                    ((WMElement)localObject1).fontTexture = ((JSONObject)localObject7).optString(VideoMaterialUtil.WATERMARK_ELEMENT.FONT_TEXTURE.value);
                    ((WMElement)localObject1).fontSize = ((float)((JSONObject)localObject7).optDouble(VideoMaterialUtil.WATERMARK_ELEMENT.FONT_SIZE.value, 20.0D));
                    ((WMElement)localObject1).fontFit = ((JSONObject)localObject7).optInt(VideoMaterialUtil.WATERMARK_ELEMENT.FONT_FIT.value);
                    ((WMElement)localObject1).kern = ((JSONObject)localObject7).optInt(VideoMaterialUtil.WATERMARK_ELEMENT.KERN.value);
                    ((WMElement)localObject1).imgPath = ((JSONObject)localObject7).optString(VideoMaterialUtil.WATERMARK_ELEMENT.IMG_PATH.value);
                    ((WMElement)localObject1).frameDuration = ((JSONObject)localObject7).optInt(VideoMaterialUtil.WATERMARK_ELEMENT.FRAME_DURATION.value);
                    ((WMElement)localObject1).frames = ((JSONObject)localObject7).optInt(VideoMaterialUtil.WATERMARK_ELEMENT.FRAMES.value);
                    ((WMElement)localObject1).color = ((JSONObject)localObject7).optString(VideoMaterialUtil.WATERMARK_ELEMENT.COLOR.value, "#FFFFFFFF");
                    ((WMElement)localObject1).strokeColor = ((JSONObject)localObject7).optString(VideoMaterialUtil.WATERMARK_ELEMENT.STROKE_COLOR.value, "#FFFFFFFF");
                    ((WMElement)localObject1).strokeSize = ((float)((JSONObject)localObject7).optDouble(VideoMaterialUtil.WATERMARK_ELEMENT.STROKE_SIZE.value, -1.0D));
                    ((WMElement)localObject1).shadowColor = ((JSONObject)localObject7).optString(VideoMaterialUtil.WATERMARK_ELEMENT.SHADOW_COLOR.value, "#FFFFFFFF");
                    ((WMElement)localObject1).shadowSize = ((float)((JSONObject)localObject7).optDouble(VideoMaterialUtil.WATERMARK_ELEMENT.SHADOW_SIZE.value, -1.0D));
                    ((WMElement)localObject1).shadowDx = ((float)((JSONObject)localObject7).optDouble(VideoMaterialUtil.WATERMARK_ELEMENT.SHADOW_DX.value, -1.0D));
                    ((WMElement)localObject1).shadowDy = ((float)((JSONObject)localObject7).optDouble(VideoMaterialUtil.WATERMARK_ELEMENT.SHADOW_DY.value, -1.0D));
                    ((WMElement)localObject1).alignment = ((JSONObject)localObject7).optString(VideoMaterialUtil.WATERMARK_ELEMENT.ALIGNMENT.value);
                    ((WMElement)localObject1).vertical = ((JSONObject)localObject7).optInt(VideoMaterialUtil.WATERMARK_ELEMENT.VERTICAL.value);
                    ((WMElement)localObject1).animateType = ((JSONObject)localObject7).optString(VideoMaterialUtil.WATERMARK_ELEMENT.ANIMATE_TYPE.value);
                    localObject8 = ((JSONObject)localObject7).optJSONObject(VideoMaterialUtil.WATERMARK_ELEMENT.LOGIC.value);
                    if (localObject8 == null) {
                      continue;
                    }
                    localObject7 = new WMLogic();
                    ((WMLogic)localObject7).type = ((JSONObject)localObject8).optString(VideoMaterialUtil.WATERMARK_LOGIC.TYPE.value);
                    ((WMLogic)localObject7).setCompare(((JSONObject)localObject8).optString(VideoMaterialUtil.WATERMARK_LOGIC.COMPARE.value), ((WMElement)localObject1).sid);
                    ((WMLogic)localObject7).data = ((JSONObject)localObject8).optString(VideoMaterialUtil.WATERMARK_LOGIC.DATA.value);
                    localObject9 = ((JSONObject)localObject8).optJSONObject(VideoMaterialUtil.WATERMARK_LOGIC.RANGE.value);
                    if (localObject9 == null) {
                      continue;
                    }
                    ((WMLogic)localObject7).range = new ArrayList();
                    localObject10 = ((JSONObject)localObject9).keys();
                    if (!((Iterator)localObject10).hasNext()) {
                      continue;
                    }
                    str1 = (String)((Iterator)localObject10).next();
                    str2 = ((JSONObject)localObject9).optString(str1);
                    ((WMLogic)localObject7).range.add(new WMLogicPair(str1, str2));
                    continue;
                  }
                }
                else
                {
                  localObject1 = new ImageWMElement();
                  continue;
                }
                ((WMElement)localObject1).relativeAnchor = new PointF(0.0F, 0.0F);
                continue;
                ((WMElement)localObject1).anchor = new PointF(0.0F, 0.0F);
                continue;
                Collections.sort(((WMLogic)localObject7).range);
                localObject8 = ((JSONObject)localObject8).optJSONObject(VideoMaterialUtil.WATERMARK_LOGIC.CASE.value);
                if (localObject8 != null)
                {
                  ((WMLogic)localObject7).wmcase = new ArrayList();
                  localObject9 = ((JSONObject)localObject8).keys();
                  if (((Iterator)localObject9).hasNext())
                  {
                    localObject10 = (String)((Iterator)localObject9).next();
                    str1 = ((JSONObject)localObject8).optString((String)localObject10);
                    ((WMLogic)localObject7).wmcase.add(new WMLogicPair((String)localObject10, str1));
                    continue;
                  }
                }
                ((WMElement)localObject1).logic = ((WMLogic)localObject7);
                ((WMGroup)localObject6).wmElements.add(localObject1);
                break label10855;
              }
              ((StickerItem3D)localObject4).wmGroup = ((WMGroup)localObject6);
            }
            ((StickerItem3D)localObject4).preTriggerType = ((StickerItem3D)localObject4).triggerType;
            ((List)localObject3).add(localObject4);
            j = ((StickerItem3D)localObject4).triggerType;
            i += 1;
            bool1 = bool2;
            continue;
          }
          localObject1 = ((List)localObject3).iterator();
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (StickerItem3D)((Iterator)localObject1).next();
            if (((StickerItem3D)localObject2).activateTriggerType == 0)
            {
              ((StickerItem3D)localObject2).countTriggerType = j;
              continue;
            }
            ((StickerItem3D)localObject2).playCount = 0;
            ((StickerItem3D)localObject2).countTriggerType = VideoMaterialUtil.TRIGGER_TYPE.MV_PART_INDEX.value;
            continue;
          }
          localVideoMaterial.setItemList3D((List)localObject3);
          localObject4 = localVideoMaterial.getGameParams();
          bool2 = bool1;
          if (localObject4 != null)
          {
            j = 0;
            if (j < ((List)localObject3).size())
            {
              localObject5 = (StickerItem3D)((List)localObject3).get(j);
              i = 0;
              localObject2 = "";
              int n;
              float f;
              if ((((StickerItem3D)localObject5).nodePosition != null) && (((StickerItem3D)localObject5).nodePosition.length == 3))
              {
                m = 1;
                localObject6 = ((StickerItem3D)localObject5).nodePosition;
                n = localObject6.length;
                k = 0;
                localObject1 = localObject2;
                i = m;
                if (k < n)
                {
                  f = localObject6[k];
                  localObject2 = (String)localObject2 + f + "-";
                  k += 1;
                  continue;
                }
              }
              else
              {
                localObject1 = "" + "0-0-0-";
              }
              if ((((StickerItem3D)localObject5).nodeEulerAngles != null) && (((StickerItem3D)localObject5).nodeEulerAngles.length == 3))
              {
                m = 1;
                localObject6 = ((StickerItem3D)localObject5).nodeEulerAngles;
                n = localObject6.length;
                k = 0;
                localObject2 = localObject1;
                localObject1 = localObject2;
                i = m;
                if (k < n)
                {
                  f = localObject6[k];
                  localObject2 = (String)localObject2 + f + "-";
                  k += 1;
                  continue;
                }
              }
              else
              {
                localObject1 = (String)localObject1 + "0-0-0-";
              }
              if ((((StickerItem3D)localObject5).nodeScale != null) && (((StickerItem3D)localObject5).nodeScale.length == 3))
              {
                m = 1;
                localObject6 = ((StickerItem3D)localObject5).nodeScale;
                n = localObject6.length;
                i = 0;
                localObject2 = localObject1;
                k = m;
                if (i < n)
                {
                  f = localObject6[i];
                  localObject1 = (String)localObject1 + f + "-";
                  i += 1;
                  continue;
                }
              }
              else
              {
                localObject2 = (String)localObject1 + "1-1-1-";
                k = i;
              }
              if (k == 0) {
                break label10864;
              }
              ((GameParams)localObject4).nodeInitialTransform = (((GameParams)localObject4).nodeInitialTransform + ((StickerItem3D)localObject5).id + "-" + (String)localObject2);
              break label10864;
            }
            if (!TextUtils.isEmpty(((GameParams)localObject4).nodeInitialTransform)) {
              ((GameParams)localObject4).nodeInitialTransform = ((GameParams)localObject4).nodeInitialTransform.substring(0, ((GameParams)localObject4).nodeInitialTransform.length() - 1);
            }
            ((GameParams)localObject4).fov = localVideoMaterial.getFov();
            ((GameParams)localObject4).flattenEar = localVideoMaterial.isFlattenEar();
            ((GameParams)localObject4).flattenNose = localVideoMaterial.isFlattenNose();
            bool2 = bool1;
          }
        }
        localObject1 = new ArrayList();
        localObject2 = paramJSONObject.optJSONArray(VideoMaterialUtil.FIELD.FACE_HEAD_CROP_ITEM_LIST.value);
        if (localObject2 != null)
        {
          k = -1;
          i = 0;
          j = 0;
          if (j < ((JSONArray)localObject2).length())
          {
            localObject3 = ((JSONArray)localObject2).getJSONObject(j);
            localObject4 = new StickerItem();
            ((StickerItem)localObject4).id = ((JSONObject)localObject3).optString("id");
            ((StickerItem)localObject4).subFolder = ((StickerItem)localObject4).id;
            ((StickerItem)localObject4).type = ((JSONObject)localObject3).optInt("type");
            ((StickerItem)localObject4).triggerType = ((JSONObject)localObject3).optInt("triggerType");
            if (((JSONObject)localObject3).optInt("alwaysTriggered") != 1) {
              break label10873;
            }
            bool1 = true;
            ((StickerItem)localObject4).alwaysTriggered = bool1;
            ((StickerItem)localObject4).featureStatType = ((JSONObject)localObject3).optInt("featureStatType");
            ((StickerItem)localObject4).playCount = ((JSONObject)localObject3).optInt("playCount");
            if (VideoMaterialUtil.isActionTriggerType(((StickerItem)localObject4).triggerType)) {
              localVideoMaterial.setTriggerType(((StickerItem)localObject4).triggerType);
            }
            ((StickerItem)localObject4).frameType = ((JSONObject)localObject3).optInt("frameType");
            ((StickerItem)localObject4).frameDuration = ((JSONObject)localObject3).optDouble("frameDuration");
            ((StickerItem)localObject4).frames = ((JSONObject)localObject3).optInt("frames");
            ((StickerItem)localObject4).width = ((JSONObject)localObject3).optInt("width");
            ((StickerItem)localObject4).height = ((JSONObject)localObject3).optInt("height");
            localObject5 = ((JSONObject)localObject3).optJSONArray("position");
            if (localObject5 != null)
            {
              ((StickerItem)localObject4).position = new double[((JSONArray)localObject5).length()];
              m = 0;
              if (m < ((JSONArray)localObject5).length())
              {
                ((StickerItem)localObject4).position[m] = ((JSONArray)localObject5).getDouble(m);
                m += 1;
                continue;
              }
            }
            else
            {
              ((StickerItem)localObject4).position = new double[] { 0.0D, 0.0D };
            }
            localObject5 = ((JSONObject)localObject3).optJSONArray("scalePivots");
            if (localObject5 != null)
            {
              ((StickerItem)localObject4).scalePivots = new int[((JSONArray)localObject5).length()];
              m = 0;
              if (m < ((JSONArray)localObject5).length())
              {
                ((StickerItem)localObject4).scalePivots[m] = ((JSONArray)localObject5).getInt(m);
                m += 1;
                continue;
              }
            }
            ((StickerItem)localObject4).scaleFactor = ((JSONObject)localObject3).optInt("scaleFactor");
            ((StickerItem)localObject4).blendMode = ((JSONObject)localObject3).optInt("blendMode", -1);
            if (((StickerItem)localObject4).blendMode == -1) {
              ((StickerItem)localObject4).blendMode = localVideoMaterial.getBlendMode();
            }
            ((StickerItem)localObject4).support3D = ((JSONObject)localObject3).optInt("enable3D", 1);
            ((StickerItem)localObject4).personID = ((JSONObject)localObject3).optInt("personID", -1);
            ((StickerItem)localObject4).activateTriggerCount = ((JSONObject)localObject3).optInt("activateTriggerCount", 0);
            ((StickerItem)localObject4).activateTriggerTotalCount = ((JSONObject)localObject3).optInt("activateTriggerTotalCount", 0);
            ((List)localObject1).add(localObject4);
            if (k == -1)
            {
              k = ((StickerItem)localObject4).triggerType;
              break label10879;
            }
            i = Math.max(i, ((StickerItem)localObject4).triggerType);
            break label10879;
          }
          localObject2 = ((List)localObject1).iterator();
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = (StickerItem)((Iterator)localObject2).next();
            ((StickerItem)localObject3).preTriggerType = k;
            ((StickerItem)localObject3).countTriggerType = i;
            continue;
          }
          localVideoMaterial.setHeadCropItemList((List)localObject1);
        }
        localObject1 = new ArrayList();
        localObject2 = paramJSONObject.optJSONArray(VideoMaterialUtil.FIELD.DISTORTION_LIST.value);
        if (localObject2 != null)
        {
          i = 0;
          if (i < ((JSONArray)localObject2).length())
          {
            localObject3 = new DistortionItem();
            localObject4 = ((JSONArray)localObject2).getJSONObject(i);
            ((DistortionItem)localObject3).position = ((JSONObject)localObject4).optInt(VideoMaterialUtil.DISTORTION_ITEM_FILED.POSITION.value);
            ((DistortionItem)localObject3).distortion = ((JSONObject)localObject4).optInt(VideoMaterialUtil.DISTORTION_ITEM_FILED.DISTORTION.value);
            ((DistortionItem)localObject3).direction = ((JSONObject)localObject4).optInt(VideoMaterialUtil.DISTORTION_ITEM_FILED.DIRECTION.value);
            ((DistortionItem)localObject3).radius = ((float)((JSONObject)localObject4).optDouble(VideoMaterialUtil.DISTORTION_ITEM_FILED.RADIUS.value));
            ((DistortionItem)localObject3).strength = ((float)((JSONObject)localObject4).optDouble(VideoMaterialUtil.DISTORTION_ITEM_FILED.STRENGH.value));
            ((DistortionItem)localObject3).x = ((JSONObject)localObject4).optInt(VideoMaterialUtil.DISTORTION_ITEM_FILED.X.value);
            ((DistortionItem)localObject3).y = ((JSONObject)localObject4).optInt(VideoMaterialUtil.DISTORTION_ITEM_FILED.Y.value);
            ((List)localObject1).add(localObject3);
            i += 1;
            continue;
          }
          localVideoMaterial.setDistortionItemList((List)localObject1);
        }
        localObject1 = new ArrayList();
        localObject2 = paramJSONObject.optJSONArray(VideoMaterialUtil.FIELD.FACE_MOVE_LIST.value);
        if (localObject2 != null)
        {
          i = 0;
          if (i < ((JSONArray)localObject2).length())
          {
            localObject3 = new FaceMoveItem();
            localObject4 = ((JSONArray)localObject2).getJSONObject(i);
            ((FaceMoveItem)localObject3).position = ((JSONObject)localObject4).optInt(VideoMaterialUtil.FACE_MOVE_ITEM_FILED.POSITION.value);
            ((FaceMoveItem)localObject3).pos1 = ((JSONObject)localObject4).optInt(VideoMaterialUtil.FACE_MOVE_ITEM_FILED.POS1.value);
            ((FaceMoveItem)localObject3).pos2 = ((JSONObject)localObject4).optInt(VideoMaterialUtil.FACE_MOVE_ITEM_FILED.POS2.value);
            ((FaceMoveItem)localObject3).ratio1 = ((float)((JSONObject)localObject4).optDouble(VideoMaterialUtil.FACE_MOVE_ITEM_FILED.RATIO1.value));
            ((FaceMoveItem)localObject3).ratio2 = ((float)((JSONObject)localObject4).optDouble(VideoMaterialUtil.FACE_MOVE_ITEM_FILED.RATIO2.value));
            ((FaceMoveItem)localObject3).dx = ((JSONObject)localObject4).optInt(VideoMaterialUtil.FACE_MOVE_ITEM_FILED.X.value);
            ((FaceMoveItem)localObject3).dy = ((JSONObject)localObject4).optInt(VideoMaterialUtil.FACE_MOVE_ITEM_FILED.Y.value);
            ((List)localObject1).add(localObject3);
            i += 1;
            continue;
          }
          localVideoMaterial.setFaceMoveItemList((List)localObject1);
        }
        localObject1 = paramJSONObject.optJSONArray(VideoMaterialUtil.FIELD.FACE_MOVE_TRIANGLE.value);
        if (localObject1 != null)
        {
          localObject2 = new int[((JSONArray)localObject1).length()];
          i = 0;
          if (i < ((JSONArray)localObject1).length())
          {
            localObject2[i] = ((JSONArray)localObject1).getInt(i);
            i += 1;
            continue;
          }
          localVideoMaterial.setFaceMoveTriangles((int[])localObject2);
        }
        localObject1 = paramJSONObject.optJSONArray(VideoMaterialUtil.FIELD.FACE_POINTS_LIST.value);
        localObject2 = new ArrayList();
        if (localObject1 != null)
        {
          i = 0;
          if (i < ((JSONArray)localObject1).length())
          {
            ((List)localObject2).add(Float.valueOf((float)((JSONArray)localObject1).optDouble(i)));
            i += 1;
            continue;
          }
          localVideoMaterial.setFacePoints((List)localObject2);
        }
        localObject1 = paramJSONObject.optJSONObject(VideoMaterialUtil.FIELD.FILTER_EFFECT.value);
        if (localObject1 != null)
        {
          localObject2 = new VideoFilterEffect();
          ((VideoFilterEffect)localObject2).type = ((JSONObject)localObject1).optInt(VideoMaterialUtil.FILTER_EFFECT_FIELD.TYPE.value);
          ((VideoFilterEffect)localObject2).order = ((JSONObject)localObject1).optInt(VideoMaterialUtil.FILTER_EFFECT_FIELD.ORDER.value);
          localVideoMaterial.setVideoFilterEffect((VideoFilterEffect)localObject2);
        }
        localObject2 = paramJSONObject.optJSONArray(VideoMaterialUtil.FIELD.FACE_OFF_ITEM_LIST.value);
        localObject1 = new ArrayList();
        if (localObject2 != null)
        {
          j = -1;
          k = 0;
          i = 0;
          if (i < ((JSONArray)localObject2).length())
          {
            localObject3 = ((JSONArray)localObject2).getJSONObject(i);
            localObject4 = new FaceItem();
            ((FaceItem)localObject4).id = ((JSONObject)localObject3).optString(VideoMaterialUtil.FACE_OFF_ITEM_FIELD.ID.value);
            ((FaceItem)localObject4).faceExchangeImage = ((JSONObject)localObject3).optString(VideoMaterialUtil.FACE_OFF_ITEM_FIELD.FACE_EXCHANGE_IMAGE.value);
            ((FaceItem)localObject4).irisImage = ((JSONObject)localObject3).optString(VideoMaterialUtil.FACE_OFF_ITEM_FIELD.IRIS_IMAGE.value);
            ((FaceItem)localObject4).blendAlpha = ((float)((JSONObject)localObject3).optDouble(VideoMaterialUtil.FACE_OFF_ITEM_FIELD.BLEND_ALPHA.value));
            ((FaceItem)localObject4).featureType = FaceOffUtil.getFeatureType(((JSONObject)localObject3).optInt(VideoMaterialUtil.FACE_OFF_ITEM_FIELD.FEATURE_TYPE.value));
            ((FaceItem)localObject4).grayScale = ((JSONObject)localObject3).optInt(VideoMaterialUtil.FACE_OFF_ITEM_FIELD.GRAY_SCALE.value);
            ((FaceItem)localObject4).blendMode = ((JSONObject)localObject3).optInt(VideoMaterialUtil.FACE_OFF_ITEM_FIELD.BLEND_MODE.value);
            ((FaceItem)localObject4).personID = ((JSONObject)localObject3).optInt(VideoMaterialUtil.FACE_OFF_ITEM_FIELD.PERSON_ID.value, -1);
            ((FaceItem)localObject4).randomGroupNum = ((JSONObject)localObject3).optInt(VideoMaterialUtil.FACE_OFF_ITEM_FIELD.RANDOM_GROUP_NUM.value);
            localObject5 = ((JSONObject)localObject3).optJSONArray(VideoMaterialUtil.FACE_OFF_ITEM_FIELD.FACE_POINTS.value);
            if (localObject5 != null)
            {
              localObject6 = new ArrayList();
              m = 0;
              if (m < ((JSONArray)localObject5).length())
              {
                ((List)localObject6).add(Float.valueOf((float)((JSONArray)localObject5).optDouble(m)));
                m += 1;
                continue;
              }
              ((FaceItem)localObject4).facePoints = ((List)localObject6);
            }
            localObject5 = ((JSONObject)localObject3).optJSONObject(VideoMaterialUtil.FIELD.CHARM_RANGE.value);
            if (localObject5 != null)
            {
              ((FaceItem)localObject4).charmRange = new CharmRange();
              ((FaceItem)localObject4).charmRange.min = ((JSONObject)localObject5).optDouble(VideoMaterialUtil.CHARM_RANGE_FIELD.MIN.value);
              ((FaceItem)localObject4).charmRange.max = ((JSONObject)localObject5).optDouble(VideoMaterialUtil.CHARM_RANGE_FIELD.MAX.value);
            }
            ((FaceItem)localObject4).frameType = ((JSONObject)localObject3).optInt(VideoMaterialUtil.FACE_OFF_ITEM_FIELD.FRAME_TYPE.value);
            ((FaceItem)localObject4).frames = ((JSONObject)localObject3).optInt(VideoMaterialUtil.FACE_OFF_ITEM_FIELD.FRAMES.value);
            ((FaceItem)localObject4).frameDuration = ((JSONObject)localObject3).optInt(VideoMaterialUtil.FACE_OFF_ITEM_FIELD.FRAME_DURATION.value);
            ((FaceItem)localObject4).width = ((JSONObject)localObject3).optInt("width");
            ((FaceItem)localObject4).height = ((JSONObject)localObject3).optInt("height");
            ((FaceItem)localObject4).triggerType = ((JSONObject)localObject3).optInt(VideoMaterialUtil.FACE_OFF_ITEM_FIELD.TRIGGER_TYPE.value, VideoMaterialUtil.TRIGGER_TYPE.FACE_DETECT.value);
            if (((JSONObject)localObject3).optInt("alwaysTriggered", 1) != 1) {
              break label10888;
            }
            bool1 = true;
            ((FaceItem)localObject4).alwaysTriggered = bool1;
            ((FaceItem)localObject4).featureStatType = ((JSONObject)localObject3).optInt("featureStatType");
            localObject5 = ((JSONObject)localObject3).optJSONObject("featureStatValueRange");
            if (localObject5 != null)
            {
              ((FaceItem)localObject4).featureStatValueRange = new StickerItem.FeatureStatValueRange();
              ((FaceItem)localObject4).featureStatValueRange.min = ((JSONObject)localObject5).optDouble("min");
              ((FaceItem)localObject4).featureStatValueRange.max = ((JSONObject)localObject5).optDouble("max");
            }
            ((FaceItem)localObject4).activateTriggerType = ((JSONObject)localObject3).optInt("activateTriggerType", 0);
            ((FaceItem)localObject4).activateTriggerCount = ((JSONObject)localObject3).optInt("activateTriggerCount", 0);
            ((FaceItem)localObject4).activateTriggerTotalCount = ((JSONObject)localObject3).optInt("activateTriggerTotalCount", 0);
            ((FaceItem)localObject4).playCount = ((JSONObject)localObject3).optInt("playCount");
            ((FaceItem)localObject4).preTriggerType = ((FaceItem)localObject4).triggerType;
            ((FaceItem)localObject4).countTriggerType = ((FaceItem)localObject4).triggerType;
            if (j == -1)
            {
              j = ((FaceItem)localObject4).triggerType;
              ((List)localObject1).add(localObject4);
              i += 1;
              continue;
            }
            k = Math.max(k, ((FaceItem)localObject4).triggerType);
            continue;
          }
          localObject2 = ((List)localObject1).iterator();
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = (FaceItem)((Iterator)localObject2).next();
            ((FaceItem)localObject3).preTriggerType = j;
            ((FaceItem)localObject3).countTriggerType = k;
            continue;
          }
        }
        if (!TextUtils.isEmpty(localVideoMaterial.getFaceExchangeImage())) {
          ((List)localObject1).add(new FaceItem(localVideoMaterial.getFaceExchangeImage(), (float)localVideoMaterial.getBlendAlpha(), localVideoMaterial.getGrayScale(), localVideoMaterial.getFeatureType(), localVideoMaterial.getFacePoints()));
        }
        localVideoMaterial.setFaceOffItemList((List)localObject1);
        localObject1 = paramJSONObject.optJSONArray(VideoMaterialUtil.FIELD.FACE_MESH_ITEM_LIST.value);
        if (localObject1 != null)
        {
          localObject2 = new ArrayList();
          i = 0;
          if (i < ((JSONArray)localObject1).length())
          {
            localObject4 = ((JSONArray)localObject1).getJSONObject(i);
            localObject3 = new FaceMeshItem();
            ((FaceMeshItem)localObject3).id = ((JSONObject)localObject4).optString(VideoMaterialUtil.FACE_MESH_ITEM_LIST.ID.value);
            ((FaceMeshItem)localObject3).personID = ((JSONObject)localObject4).optInt(VideoMaterialUtil.FACE_MESH_ITEM_LIST.PERSON_ID.value, -1);
            ((FaceMeshItem)localObject3).frames = ((JSONObject)localObject4).optInt(VideoMaterialUtil.FACE_MESH_ITEM_LIST.FRAMES.value);
            localObject5 = ((JSONObject)localObject4).optJSONObject(VideoMaterialUtil.FIELD.CHARM_RANGE.value);
            if (localObject5 != null)
            {
              ((FaceMeshItem)localObject3).charmRange = new CharmRange();
              ((FaceMeshItem)localObject3).charmRange.min = ((JSONObject)localObject5).optDouble(VideoMaterialUtil.CHARM_RANGE_FIELD.MIN.value);
              ((FaceMeshItem)localObject3).charmRange.max = ((JSONObject)localObject5).optDouble(VideoMaterialUtil.CHARM_RANGE_FIELD.MAX.value);
            }
            ((FaceMeshItem)localObject3).frameType = ((JSONObject)localObject4).optInt("frameType");
            ((FaceMeshItem)localObject3).frameDuration = ((JSONObject)localObject4).optDouble("frameDuration");
            ((FaceMeshItem)localObject3).triggerType = ((JSONObject)localObject4).optInt("triggerType");
            if (VideoMaterialUtil.isActionTriggerType(((FaceMeshItem)localObject3).triggerType)) {
              localVideoMaterial.setTriggerType(((FaceMeshItem)localObject3).triggerType);
            }
            if (((JSONObject)localObject4).optInt("alwaysTriggered") != 1) {
              break label10894;
            }
            bool1 = true;
            ((FaceMeshItem)localObject3).alwaysTriggered = bool1;
            ((FaceMeshItem)localObject3).featureStatType = ((JSONObject)localObject4).optInt("featureStatType");
            localObject4 = ((JSONObject)localObject4).optJSONObject("featureStatValueRange");
            if (localObject4 != null)
            {
              ((FaceMeshItem)localObject3).featureStatValueRange = new StickerItem.FeatureStatValueRange();
              ((FaceMeshItem)localObject3).featureStatValueRange.min = ((JSONObject)localObject4).optDouble("min");
              ((FaceMeshItem)localObject3).featureStatValueRange.max = ((JSONObject)localObject4).optDouble("max");
            }
            ((List)localObject2).add(localObject3);
            i += 1;
            continue;
          }
          localVideoMaterial.setFaceMeshItemList((List)localObject2);
        }
        localObject2 = paramJSONObject.optJSONObject("faceAverage");
        if (localObject2 != null)
        {
          localObject1 = new VideoMaterial.FaceImageLayer();
          ((VideoMaterial.FaceImageLayer)localObject1).width = ((JSONObject)localObject2).optDouble("width");
          ((VideoMaterial.FaceImageLayer)localObject1).height = ((JSONObject)localObject2).optDouble("height");
          ((VideoMaterial.FaceImageLayer)localObject1).x = ((JSONObject)localObject2).optDouble("x");
          ((VideoMaterial.FaceImageLayer)localObject1).y = ((JSONObject)localObject2).optDouble("y");
          ((VideoMaterial.FaceImageLayer)localObject1).type = ((JSONObject)localObject2).optInt("type");
          ((VideoMaterial.FaceImageLayer)localObject1).imagePath = ((JSONObject)localObject2).optString("image");
          localObject3 = ((JSONObject)localObject2).optJSONArray("imageFacePoint");
          if (localObject3 != null)
          {
            localObject4 = new ArrayList();
            i = 0;
            if (i < ((JSONArray)localObject3).length())
            {
              ((List)localObject4).add(Double.valueOf(((JSONArray)localObject3).optDouble(i)));
              i += 1;
              continue;
            }
            ((VideoMaterial.FaceImageLayer)localObject1).imageFacePoint = ((List)localObject4);
          }
          localObject3 = ((JSONObject)localObject2).optJSONArray("imageFaceColor");
          if (localObject3 != null)
          {
            localObject4 = new ArrayList();
            i = 0;
            if (i < ((JSONArray)localObject3).length())
            {
              ((List)localObject4).add(Double.valueOf(((JSONArray)localObject3).optDouble(i)));
              i += 1;
              continue;
            }
            ((VideoMaterial.FaceImageLayer)localObject1).imageFaceColor = ((List)localObject4);
          }
          ((VideoMaterial.FaceImageLayer)localObject1).blendAlpha = ((JSONObject)localObject2).optDouble("blendAlpha", 0.5D);
          ((VideoMaterial.FaceImageLayer)localObject1).distortionAlpha = ((JSONObject)localObject2).optDouble("distortionAlpha", 0.5D);
          localObject3 = ((JSONObject)localObject2).optJSONArray("distortionList");
          if (localObject3 != null)
          {
            localObject4 = new ArrayList();
            i = 0;
            if (i < ((JSONArray)localObject3).length())
            {
              localObject5 = ((JSONArray)localObject3).opt(i);
              if (!(localObject5 instanceof JSONObject)) {
                break label10900;
              }
              localObject5 = (JSONObject)localObject5;
              localObject6 = new DistortionItem();
              ((DistortionItem)localObject6).position = ((JSONObject)localObject5).optInt(VideoMaterialUtil.DISTORTION_ITEM_FILED.POSITION.value);
              ((DistortionItem)localObject6).distortion = ((JSONObject)localObject5).optInt(VideoMaterialUtil.DISTORTION_ITEM_FILED.DISTORTION.value);
              ((DistortionItem)localObject6).direction = ((JSONObject)localObject5).optInt(VideoMaterialUtil.DISTORTION_ITEM_FILED.DIRECTION.value);
              ((DistortionItem)localObject6).radius = ((float)((JSONObject)localObject5).optDouble(VideoMaterialUtil.DISTORTION_ITEM_FILED.RADIUS.value));
              ((DistortionItem)localObject6).strength = ((float)((JSONObject)localObject5).optDouble(VideoMaterialUtil.DISTORTION_ITEM_FILED.STRENGH.value));
              ((DistortionItem)localObject6).x = ((JSONObject)localObject5).optInt(VideoMaterialUtil.DISTORTION_ITEM_FILED.X.value, 0);
              ((DistortionItem)localObject6).y = ((JSONObject)localObject5).optInt(VideoMaterialUtil.DISTORTION_ITEM_FILED.Y.value, 0);
              ((List)localObject4).add(localObject6);
              break label10900;
            }
            ((VideoMaterial.FaceImageLayer)localObject1).distortionList = ((List)localObject4);
          }
          ((VideoMaterial.FaceImageLayer)localObject1).faceMaskImagePath = ((JSONObject)localObject2).optString("faceMaskImage", null);
          localObject3 = ((JSONObject)localObject2).optJSONArray("faceMaskFacePoint");
          if (localObject3 != null)
          {
            localObject4 = new ArrayList();
            i = 0;
            if (i < ((JSONArray)localObject3).length())
            {
              ((List)localObject4).add(Double.valueOf(((JSONArray)localObject3).optDouble(i)));
              i += 1;
              continue;
            }
            ((VideoMaterial.FaceImageLayer)localObject1).faceMaskFacePoint = ((List)localObject4);
          }
          localObject2 = ((JSONObject)localObject2).optJSONArray("faceTriangle");
          if (localObject2 != null)
          {
            localObject3 = new ArrayList();
            i = 0;
            if (i < ((JSONArray)localObject2).length())
            {
              ((List)localObject3).add(Integer.valueOf(((JSONArray)localObject2).optInt(i)));
              i += 1;
              continue;
            }
            ((VideoMaterial.FaceImageLayer)localObject1).faceTriangle = ((List)localObject3);
          }
          localVideoMaterial.setFaceImageLayer((VideoMaterial.FaceImageLayer)localObject1);
        }
        localObject1 = paramJSONObject.optJSONArray(VideoMaterialUtil.FIELD.AR_PARTICLE_LIST.value);
        if (localObject1 != null)
        {
          localObject2 = new ArrayList();
          i = 0;
          if (i < ((JSONArray)localObject1).length())
          {
            ((List)localObject2).add(((JSONArray)localObject1).getString(i));
            i += 1;
            continue;
          }
          localVideoMaterial.setArParticleList((List)localObject2);
        }
        localObject2 = paramJSONObject.optJSONObject(VideoMaterialUtil.FIELD.FACE_EXPRESSION.value);
        if (localObject2 != null)
        {
          localObject1 = new FaceExpression();
          ((FaceExpression)localObject1).id = ((JSONObject)localObject2).optString(VideoMaterialUtil.FACE_EXPRESSION_ITEM_FILED.ID.value);
          ((FaceExpression)localObject1).videoID = ((JSONObject)localObject2).optString(VideoMaterialUtil.FACE_EXPRESSION_ITEM_FILED.VIDEO_ID.value);
          ((FaceExpression)localObject1).frameDuration = ((JSONObject)localObject2).optDouble(VideoMaterialUtil.FACE_EXPRESSION_ITEM_FILED.FRAME_DURATION.value);
          ((FaceExpression)localObject1).frames = ((JSONObject)localObject2).optInt(VideoMaterialUtil.FACE_EXPRESSION_ITEM_FILED.FRAMES.value);
          ((FaceExpression)localObject1).audioID = ((JSONObject)localObject2).optString(VideoMaterialUtil.FACE_EXPRESSION_ITEM_FILED.AUDIO_ID.value);
          if (bool2) {
            break label10909;
          }
          if (TextUtils.isEmpty(((FaceExpression)localObject1).audioID)) {
            break label10915;
          }
          break label10909;
          localObject3 = ((JSONObject)localObject2).optJSONArray(VideoMaterialUtil.FACE_EXPRESSION_ITEM_FILED.CANVAS_SIZE.value);
          if ((localObject3 != null) && (((JSONArray)localObject3).length() == 2))
          {
            ((FaceExpression)localObject1).canvasSize = new SizeI();
            ((FaceExpression)localObject1).canvasSize.width = ((JSONArray)localObject3).optInt(0);
            ((FaceExpression)localObject1).canvasSize.height = ((JSONArray)localObject3).optInt(1);
          }
          ((FaceExpression)localObject1).canvasResizeMode = ((JSONObject)localObject2).optInt(VideoMaterialUtil.FACE_EXPRESSION_ITEM_FILED.CANVAS_RESIZE_MODE.value);
          ((FaceExpression)localObject1).scoreImageID = ((JSONObject)localObject2).optString(VideoMaterialUtil.FACE_EXPRESSION_ITEM_FILED.SCORE_IMAGE_ID.value);
          ((FaceExpression)localObject1).expressionNumber = ((JSONObject)localObject2).optInt(VideoMaterialUtil.FACE_EXPRESSION_ITEM_FILED.EXPRESSION_NUMBER.value);
          localObject3 = ((JSONObject)localObject2).optJSONArray(VideoMaterialUtil.FACE_EXPRESSION_ITEM_FILED.EXPRESSION_LIST.value);
          if (localObject3 != null)
          {
            ((FaceExpression)localObject1).expressionList = new ArrayList();
            i = 0;
            if (i < ((JSONArray)localObject3).length())
            {
              localObject4 = new ExpressionItem();
              localObject5 = ((JSONArray)localObject3).getJSONObject(i);
              ((ExpressionItem)localObject4).expressionTime = ((JSONObject)localObject5).optInt(VideoMaterialUtil.EXPRESSION_ITEM_FILED.EXPRESSION_TIME.value);
              ((ExpressionItem)localObject4).expressionID = ((JSONObject)localObject5).optString(VideoMaterialUtil.EXPRESSION_ITEM_FILED.EXPRESSION_ID.value);
              localObject6 = ((JSONObject)localObject5).optJSONArray(VideoMaterialUtil.EXPRESSION_ITEM_FILED.EXPRESSION_FEAT_SIZE.value);
              if ((localObject6 != null) && (((JSONArray)localObject6).length() == 2))
              {
                ((ExpressionItem)localObject4).expressionFeatSize = new SizeI();
                ((ExpressionItem)localObject4).expressionFeatSize.width = ((JSONArray)localObject6).optInt(0);
                ((ExpressionItem)localObject4).expressionFeatSize.height = ((JSONArray)localObject6).optInt(1);
              }
              localObject6 = ((JSONObject)localObject5).optJSONArray(VideoMaterialUtil.EXPRESSION_ITEM_FILED.EXPRESSION_FEAT.value);
              if (localObject6 != null)
              {
                ((ExpressionItem)localObject4).expressionFeat = new ArrayList();
                j = 0;
                if (j < ((JSONArray)localObject6).length() / 2)
                {
                  ((ExpressionItem)localObject4).expressionFeat.add(new PointF(((JSONArray)localObject6).optInt(j * 2), ((JSONArray)localObject6).optInt(j * 2 + 1)));
                  j += 1;
                  continue;
                }
              }
              localObject6 = ((JSONObject)localObject5).optJSONArray(VideoMaterialUtil.EXPRESSION_ITEM_FILED.EXPRESSION_ANGLE.value);
              if ((localObject6 != null) && (((JSONArray)localObject6).length() == 3))
              {
                ((ExpressionItem)localObject4).expressionAngle = new float[3];
                ((ExpressionItem)localObject4).expressionAngle[0] = ((float)((JSONArray)localObject6).optDouble(0));
                ((ExpressionItem)localObject4).expressionAngle[1] = ((float)((JSONArray)localObject6).optDouble(1));
                ((ExpressionItem)localObject4).expressionAngle[2] = ((float)((JSONArray)localObject6).optDouble(2));
              }
              ((ExpressionItem)localObject4).scoreImageID = ((JSONObject)localObject5).optString(VideoMaterialUtil.EXPRESSION_ITEM_FILED.SCORE_IMAGE_ID.value);
              localObject5 = ((JSONObject)localObject5).optJSONArray(VideoMaterialUtil.EXPRESSION_ITEM_FILED.EXPRESSION_WEIGHT.value);
              if ((localObject5 != null) && (((JSONArray)localObject5).length() == 7))
              {
                ((ExpressionItem)localObject4).expressionWeight = new double[7];
                j = 0;
                if (j < 7)
                {
                  ((ExpressionItem)localObject4).expressionWeight[j] = ((JSONArray)localObject5).optDouble(j);
                  j += 1;
                  continue;
                }
              }
              else
              {
                ((ExpressionItem)localObject4).expressionWeight = ActUtil.WEIGHT;
              }
              ((FaceExpression)localObject1).expressionList.add(localObject4);
              i += 1;
              continue;
            }
          }
          localObject2 = ((JSONObject)localObject2).optJSONArray(VideoMaterialUtil.FACE_EXPRESSION_ITEM_FILED.CANVAS_ITEM_LIST.value);
          if (localObject2 != null)
          {
            ((FaceExpression)localObject1).canvasItemList = new ArrayList();
            i = 0;
            if (i < ((JSONArray)localObject2).length())
            {
              localObject3 = ((JSONArray)localObject2).getJSONObject(i);
              localObject4 = new CanvasItem();
              ((CanvasItem)localObject4).type = ((JSONObject)localObject3).optInt(VideoMaterialUtil.CANVAS_ITEM_FILED.TYPE.value);
              ((CanvasItem)localObject4).index = ((JSONObject)localObject3).optInt(VideoMaterialUtil.CANVAS_ITEM_FILED.INDEX.value);
              ((CanvasItem)localObject4).startTime = ((JSONObject)localObject3).optInt(VideoMaterialUtil.CANVAS_ITEM_FILED.START_TIME.value);
              ((CanvasItem)localObject4).endTime = ((JSONObject)localObject3).optInt(VideoMaterialUtil.CANVAS_ITEM_FILED.END_TIME.value);
              ((CanvasItem)localObject4).zIndex = ((JSONObject)localObject3).optInt(VideoMaterialUtil.CANVAS_ITEM_FILED.Z_INDEX.value);
              localObject5 = ((JSONObject)localObject3).optJSONArray(VideoMaterialUtil.CANVAS_ITEM_FILED.ITEM_RECT.value);
              if ((localObject5 != null) && (((JSONArray)localObject5).length() == 4))
              {
                ((CanvasItem)localObject4).itemRect = new Rect();
                ((CanvasItem)localObject4).itemRect.x = ((JSONArray)localObject5).optInt(0);
                ((CanvasItem)localObject4).itemRect.y = ((JSONArray)localObject5).optInt(1);
                ((CanvasItem)localObject4).itemRect.width = ((JSONArray)localObject5).optInt(2);
                ((CanvasItem)localObject4).itemRect.height = ((JSONArray)localObject5).optInt(3);
              }
              ((CanvasItem)localObject4).itemResizeMode = ((JSONObject)localObject3).optInt(VideoMaterialUtil.CANVAS_ITEM_FILED.ITEM_RESIZE_MODE.value);
              ((FaceExpression)localObject1).canvasItemList.add(localObject4);
              i += 1;
              continue;
            }
          }
          localVideoMaterial.setFaceExpression((FaceExpression)localObject1);
          localObject2 = paramJSONObject.optJSONObject(VideoMaterialUtil.FIELD.FACE_CROP.value);
          if (localObject2 != null)
          {
            localObject1 = new FaceCropItem();
            ((FaceCropItem)localObject1).frameDuration = ((JSONObject)localObject2).optInt(VideoMaterialUtil.FACE_CROP_ITEM.FRAME_DURATION.value);
            ((FaceCropItem)localObject1).frames = ((JSONObject)localObject2).optInt(VideoMaterialUtil.FACE_CROP_ITEM.FRAMES.value);
            ((FaceCropItem)localObject1).frameList = new ArrayList();
            localObject2 = ((JSONObject)localObject2).optJSONArray(VideoMaterialUtil.FACE_CROP_ITEM.FRAME_LIST.value);
            if ((localObject2 != null) && (((JSONArray)localObject2).length() > 0))
            {
              i = 0;
              if (i < ((JSONArray)localObject2).length())
              {
                localObject4 = ((JSONArray)localObject2).getJSONObject(i);
                localObject3 = new FaceCropItem.CropFrame();
                ((FaceCropItem.CropFrame)localObject3).faceAngle = ((JSONObject)localObject4).optDouble(VideoMaterialUtil.FACE_CROP_ITEM_FRAME.FACE_ANGLE.value);
                ((FaceCropItem.CropFrame)localObject3).faceWidth = ((JSONObject)localObject4).optDouble(VideoMaterialUtil.FACE_CROP_ITEM_FRAME.FACE_WIDTH.value);
                ((FaceCropItem.CropFrame)localObject3).index = ((JSONObject)localObject4).optInt(VideoMaterialUtil.FACE_CROP_ITEM_FRAME.INDEX.value);
                localObject5 = ((JSONObject)localObject4).optJSONArray(VideoMaterialUtil.FACE_CROP_ITEM_FRAME.NOSE_POINT.value);
                if ((localObject5 != null) && (((JSONArray)localObject5).length() > 0))
                {
                  ((FaceCropItem.CropFrame)localObject3).noseX = ((JSONArray)localObject5).getDouble(0);
                  ((FaceCropItem.CropFrame)localObject3).noseY = ((JSONArray)localObject5).getDouble(1);
                }
                localObject4 = ((JSONObject)localObject4).optJSONArray(VideoMaterialUtil.FACE_CROP_ITEM_FRAME.SIZE.value);
                if ((localObject4 != null) && (((JSONArray)localObject4).length() > 0))
                {
                  ((FaceCropItem.CropFrame)localObject3).width = ((JSONArray)localObject4).getDouble(0);
                  ((FaceCropItem.CropFrame)localObject3).height = ((JSONArray)localObject4).getDouble(1);
                }
                ((FaceCropItem)localObject1).frameList.add(localObject3);
                i += 1;
                continue;
              }
            }
            localVideoMaterial.setFaceCropItem((FaceCropItem)localObject1);
          }
          localVideoMaterial.setHasAudio(bool1);
          parseFabbyMvItems(paramString, paramJSONObject, localVideoMaterial, paramDecryptListener);
          localVideoMaterial.setSegmentFeather(paramJSONObject.optInt("SegmentFeathering", 0));
          if (paramJSONObject.optInt("SegmentRequired", 0) == 1)
          {
            bool1 = true;
            localVideoMaterial.setSegmentRequired(bool1);
            localVideoMaterial.setSegmentStrokeWidth(paramJSONObject.optDouble("SegmentStrokeWidth", 0.0D));
            localVideoMaterial.setSegmentStrokeGap(paramJSONObject.optDouble("SegmentStrokeGap", 0.0D));
            paramString = paramJSONObject.optString("SegmentStrokeColor", "");
            if (TextUtils.isEmpty(paramString)) {
              break label2833;
            }
            i = Color.parseColor(paramString);
            localVideoMaterial.setSegmentStrokeColor(new float[] { Color.red(i) / 255.0F, Color.green(i) / 255.0F, Color.blue(i) / 255.0F, Color.alpha(i) / 255.0F });
            break label2833;
          }
          bool1 = false;
          continue;
        }
      }
      catch (IllegalArgumentException paramString)
      {
        continue;
        bool1 = bool2;
        continue;
      }
      label10774:
      bool1 = false;
      break;
      label10780:
      bool1 = false;
      break label344;
      label10786:
      bool1 = false;
      break label635;
      label10792:
      bool1 = false;
      break label659;
      label10798:
      bool2 = false;
      break label1143;
      label10804:
      bool2 = true;
      break label1450;
      label10810:
      bool1 = false;
      break label2326;
      label10816:
      bool1 = false;
      break label2351;
      label10822:
      j += 1;
      break label1984;
      label10831:
      bool2 = false;
      continue;
      label10837:
      bool2 = true;
      continue;
      label10843:
      bool1 = false;
      continue;
      label10849:
      bool1 = false;
      continue;
      label10855:
      j += 1;
      continue;
      label10864:
      j += 1;
      continue;
      label10873:
      bool1 = false;
      continue;
      label10879:
      j += 1;
      continue;
      label10888:
      bool1 = false;
      continue;
      label10894:
      bool1 = false;
      continue;
      label10900:
      i += 1;
      continue;
      label10909:
      bool1 = true;
      continue;
      label10915:
      bool1 = false;
    }
  }
  
  /* Error */
  public static JSONObject parseVideoMaterialFile(String paramString1, String paramString2, boolean paramBoolean, DecryptListener paramDecryptListener)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 4
    //   3: aload_0
    //   4: invokestatic 2180	com/tencent/ttpic/util/VideoUtil:getRealPath	(Ljava/lang/String;)Ljava/lang/String;
    //   7: astore 6
    //   9: new 342	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 786	java/lang/StringBuilder:<init>	()V
    //   16: aload 6
    //   18: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: ldc 211
    //   23: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: aload_1
    //   27: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: ldc 157
    //   32: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: astore 5
    //   37: iload_2
    //   38: ifeq +257 -> 295
    //   41: ldc 13
    //   43: astore_0
    //   44: aload 5
    //   46: aload_0
    //   47: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: invokevirtual 795	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: astore 5
    //   55: new 342	java/lang/StringBuilder
    //   58: dup
    //   59: invokespecial 786	java/lang/StringBuilder:<init>	()V
    //   62: aload 6
    //   64: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: ldc 211
    //   69: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: aload_1
    //   73: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: ldc 157
    //   78: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: astore_1
    //   82: iload_2
    //   83: ifne +218 -> 301
    //   86: ldc 13
    //   88: astore_0
    //   89: aload_1
    //   90: aload_0
    //   91: invokevirtual 349	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: invokevirtual 795	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: astore 7
    //   99: new 788	java/io/File
    //   102: dup
    //   103: aload 5
    //   105: invokespecial 2181	java/io/File:<init>	(Ljava/lang/String;)V
    //   108: astore_0
    //   109: new 788	java/io/File
    //   112: dup
    //   113: aload 7
    //   115: invokespecial 2181	java/io/File:<init>	(Ljava/lang/String;)V
    //   118: astore_1
    //   119: aload_0
    //   120: invokevirtual 2184	java/io/File:exists	()Z
    //   123: ifeq +10 -> 133
    //   126: aload_0
    //   127: invokevirtual 2187	java/io/File:isFile	()Z
    //   130: ifne +17 -> 147
    //   133: aload_1
    //   134: invokevirtual 2184	java/io/File:exists	()Z
    //   137: ifeq +218 -> 355
    //   140: aload_1
    //   141: invokevirtual 2187	java/io/File:isFile	()Z
    //   144: ifeq +211 -> 355
    //   147: aload_0
    //   148: invokevirtual 2184	java/io/File:exists	()Z
    //   151: ifeq +156 -> 307
    //   154: aload_0
    //   155: invokevirtual 2187	java/io/File:isFile	()Z
    //   158: ifeq +149 -> 307
    //   161: new 2189	java/io/FileInputStream
    //   164: dup
    //   165: aload_0
    //   166: invokespecial 2192	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   169: astore_0
    //   170: iload_2
    //   171: ifne +173 -> 344
    //   174: aload_0
    //   175: aload_3
    //   176: invokestatic 2194	com/tencent/ttpic/util/VideoTemplateParser:drinkACupOfCoffee	(Ljava/io/InputStream;Lcom/tencent/ttpic/util/DecryptListener;)Ljava/io/InputStream;
    //   179: astore_1
    //   180: aload_0
    //   181: invokestatic 2198	com/tencent/util/e:closeQuietly	(Ljava/io/InputStream;)V
    //   184: aload_1
    //   185: ifnull +616 -> 801
    //   188: new 2200	java/io/InputStreamReader
    //   191: dup
    //   192: aload_1
    //   193: invokespecial 2202	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   196: astore_3
    //   197: new 2204	java/io/BufferedReader
    //   200: dup
    //   201: aload_3
    //   202: sipush 1024
    //   205: invokespecial 2207	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   208: astore 6
    //   210: new 2209	java/lang/StringBuffer
    //   213: dup
    //   214: invokespecial 2210	java/lang/StringBuffer:<init>	()V
    //   217: astore 5
    //   219: aload 6
    //   221: invokevirtual 2213	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   224: astore 7
    //   226: aload 7
    //   228: ifnull +271 -> 499
    //   231: aload 5
    //   233: aload 7
    //   235: invokevirtual 2216	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   238: pop
    //   239: goto -20 -> 219
    //   242: astore 7
    //   244: aload_3
    //   245: astore 5
    //   247: aload 7
    //   249: astore_3
    //   250: aload_3
    //   251: invokevirtual 2219	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   254: pop
    //   255: aload 6
    //   257: ifnull +8 -> 265
    //   260: aload 6
    //   262: invokevirtual 2222	java/io/BufferedReader:close	()V
    //   265: aload 5
    //   267: ifnull +8 -> 275
    //   270: aload 5
    //   272: invokevirtual 2223	java/io/InputStreamReader:close	()V
    //   275: aload_1
    //   276: ifnull +7 -> 283
    //   279: aload_1
    //   280: invokevirtual 2226	java/io/InputStream:close	()V
    //   283: aload_0
    //   284: ifnull +7 -> 291
    //   287: aload_0
    //   288: invokevirtual 2227	java/io/FileInputStream:close	()V
    //   291: aconst_null
    //   292: astore_1
    //   293: aload_1
    //   294: areturn
    //   295: ldc 10
    //   297: astore_0
    //   298: goto -254 -> 44
    //   301: ldc 10
    //   303: astore_0
    //   304: goto -215 -> 89
    //   307: aload_1
    //   308: invokevirtual 2184	java/io/File:exists	()Z
    //   311: ifeq +501 -> 812
    //   314: aload_1
    //   315: invokevirtual 2187	java/io/File:isFile	()Z
    //   318: ifeq +494 -> 812
    //   321: new 2189	java/io/FileInputStream
    //   324: dup
    //   325: aload_1
    //   326: invokespecial 2192	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   329: astore_0
    //   330: iload_2
    //   331: ifne +8 -> 339
    //   334: iconst_1
    //   335: istore_2
    //   336: goto -166 -> 170
    //   339: iconst_0
    //   340: istore_2
    //   341: goto -5 -> 336
    //   344: aload_0
    //   345: astore_1
    //   346: aload_0
    //   347: astore_3
    //   348: aload_1
    //   349: astore_0
    //   350: aload_3
    //   351: astore_1
    //   352: goto -168 -> 184
    //   355: invokestatic 2233	com/tencent/ttpic/util/VideoGlobalContext:getContext	()Landroid/content/Context;
    //   358: invokevirtual 2239	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   361: aload 5
    //   363: invokevirtual 2245	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   366: astore 6
    //   368: iload_2
    //   369: ifne +29 -> 398
    //   372: aload 6
    //   374: aload_3
    //   375: invokestatic 2194	com/tencent/ttpic/util/VideoTemplateParser:drinkACupOfCoffee	(Ljava/io/InputStream;Lcom/tencent/ttpic/util/DecryptListener;)Ljava/io/InputStream;
    //   378: astore_0
    //   379: aload_0
    //   380: astore_1
    //   381: aload_0
    //   382: astore 5
    //   384: aload 6
    //   386: invokestatic 2198	com/tencent/util/e:closeQuietly	(Ljava/io/InputStream;)V
    //   389: aconst_null
    //   390: astore_3
    //   391: aload_0
    //   392: astore_1
    //   393: aload_3
    //   394: astore_0
    //   395: goto -211 -> 184
    //   398: aconst_null
    //   399: astore_0
    //   400: aload 6
    //   402: astore_1
    //   403: goto -219 -> 184
    //   406: astore_0
    //   407: aconst_null
    //   408: astore_0
    //   409: aload_0
    //   410: astore 6
    //   412: aload_0
    //   413: astore_1
    //   414: aload_0
    //   415: astore 5
    //   417: invokestatic 2233	com/tencent/ttpic/util/VideoGlobalContext:getContext	()Landroid/content/Context;
    //   420: invokevirtual 2239	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   423: aload 7
    //   425: invokevirtual 2245	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   428: astore 7
    //   430: iload_2
    //   431: ifne +45 -> 476
    //   434: iload 4
    //   436: ifne +46 -> 482
    //   439: aload_0
    //   440: astore 6
    //   442: aload_0
    //   443: astore_1
    //   444: aload_0
    //   445: astore 5
    //   447: aload 7
    //   449: aload_3
    //   450: invokestatic 2194	com/tencent/ttpic/util/VideoTemplateParser:drinkACupOfCoffee	(Ljava/io/InputStream;Lcom/tencent/ttpic/util/DecryptListener;)Ljava/io/InputStream;
    //   453: astore_0
    //   454: aload_0
    //   455: astore 6
    //   457: aload_0
    //   458: astore_1
    //   459: aload_0
    //   460: astore 5
    //   462: aload 7
    //   464: invokestatic 2198	com/tencent/util/e:closeQuietly	(Ljava/io/InputStream;)V
    //   467: aconst_null
    //   468: astore_3
    //   469: aload_0
    //   470: astore_1
    //   471: aload_3
    //   472: astore_0
    //   473: goto -289 -> 184
    //   476: iconst_0
    //   477: istore 4
    //   479: goto -45 -> 434
    //   482: aconst_null
    //   483: astore_0
    //   484: aload 7
    //   486: astore_1
    //   487: goto -303 -> 184
    //   490: astore_0
    //   491: aconst_null
    //   492: astore_0
    //   493: aload 6
    //   495: astore_1
    //   496: goto -312 -> 184
    //   499: aload 5
    //   501: invokevirtual 2246	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   504: astore 5
    //   506: aload 5
    //   508: invokestatic 155	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   511: ifne +284 -> 795
    //   514: new 2248	org/json/JSONTokener
    //   517: dup
    //   518: aload 5
    //   520: invokespecial 2249	org/json/JSONTokener:<init>	(Ljava/lang/String;)V
    //   523: invokevirtual 2252	org/json/JSONTokener:nextValue	()Ljava/lang/Object;
    //   526: checkcast 145	org/json/JSONObject
    //   529: astore 5
    //   531: aload 6
    //   533: ifnull +8 -> 541
    //   536: aload 6
    //   538: invokevirtual 2222	java/io/BufferedReader:close	()V
    //   541: aload_3
    //   542: ifnull +7 -> 549
    //   545: aload_3
    //   546: invokevirtual 2223	java/io/InputStreamReader:close	()V
    //   549: aload_1
    //   550: ifnull +7 -> 557
    //   553: aload_1
    //   554: invokevirtual 2226	java/io/InputStream:close	()V
    //   557: aload 5
    //   559: astore_1
    //   560: aload_0
    //   561: ifnull -268 -> 293
    //   564: aload_0
    //   565: invokevirtual 2227	java/io/FileInputStream:close	()V
    //   568: aload 5
    //   570: areturn
    //   571: astore_0
    //   572: aload 5
    //   574: areturn
    //   575: astore_0
    //   576: aconst_null
    //   577: areturn
    //   578: astore_3
    //   579: aconst_null
    //   580: astore_0
    //   581: aconst_null
    //   582: astore 5
    //   584: aconst_null
    //   585: astore 6
    //   587: aconst_null
    //   588: astore_1
    //   589: aload 6
    //   591: ifnull +8 -> 599
    //   594: aload 6
    //   596: invokevirtual 2222	java/io/BufferedReader:close	()V
    //   599: aload 5
    //   601: ifnull +8 -> 609
    //   604: aload 5
    //   606: invokevirtual 2223	java/io/InputStreamReader:close	()V
    //   609: aload_1
    //   610: ifnull +7 -> 617
    //   613: aload_1
    //   614: invokevirtual 2226	java/io/InputStream:close	()V
    //   617: aload_0
    //   618: ifnull +7 -> 625
    //   621: aload_0
    //   622: invokevirtual 2227	java/io/FileInputStream:close	()V
    //   625: aload_3
    //   626: athrow
    //   627: astore_0
    //   628: goto -3 -> 625
    //   631: astore_3
    //   632: aconst_null
    //   633: astore 5
    //   635: aconst_null
    //   636: astore 6
    //   638: aconst_null
    //   639: astore_1
    //   640: goto -51 -> 589
    //   643: astore_3
    //   644: aconst_null
    //   645: astore 5
    //   647: aconst_null
    //   648: astore 6
    //   650: goto -61 -> 589
    //   653: astore_3
    //   654: aconst_null
    //   655: astore_0
    //   656: aconst_null
    //   657: astore 5
    //   659: aconst_null
    //   660: astore 6
    //   662: goto -73 -> 589
    //   665: astore_3
    //   666: aconst_null
    //   667: astore 5
    //   669: aconst_null
    //   670: astore 6
    //   672: goto -83 -> 589
    //   675: astore 6
    //   677: aload_3
    //   678: astore 5
    //   680: aconst_null
    //   681: astore 7
    //   683: aload 6
    //   685: astore_3
    //   686: aload 7
    //   688: astore 6
    //   690: goto -101 -> 589
    //   693: astore 7
    //   695: aload_3
    //   696: astore 5
    //   698: aload 7
    //   700: astore_3
    //   701: goto -112 -> 589
    //   704: astore_3
    //   705: goto -116 -> 589
    //   708: astore_3
    //   709: aconst_null
    //   710: astore_0
    //   711: aconst_null
    //   712: astore 5
    //   714: aconst_null
    //   715: astore 6
    //   717: aconst_null
    //   718: astore_1
    //   719: goto -469 -> 250
    //   722: astore_3
    //   723: aconst_null
    //   724: astore 5
    //   726: aconst_null
    //   727: astore 6
    //   729: aconst_null
    //   730: astore_1
    //   731: goto -481 -> 250
    //   734: astore_3
    //   735: aconst_null
    //   736: astore 5
    //   738: aconst_null
    //   739: astore 6
    //   741: goto -491 -> 250
    //   744: astore_3
    //   745: aconst_null
    //   746: astore_0
    //   747: aconst_null
    //   748: astore 7
    //   750: aconst_null
    //   751: astore 6
    //   753: aload 5
    //   755: astore_1
    //   756: aload 7
    //   758: astore 5
    //   760: goto -510 -> 250
    //   763: astore_3
    //   764: aconst_null
    //   765: astore 5
    //   767: aconst_null
    //   768: astore 6
    //   770: goto -520 -> 250
    //   773: astore 6
    //   775: aload_3
    //   776: astore 5
    //   778: aconst_null
    //   779: astore 7
    //   781: aload 6
    //   783: astore_3
    //   784: aload 7
    //   786: astore 6
    //   788: goto -538 -> 250
    //   791: astore_1
    //   792: goto -383 -> 409
    //   795: aconst_null
    //   796: astore 5
    //   798: goto -267 -> 531
    //   801: aconst_null
    //   802: astore_3
    //   803: aconst_null
    //   804: astore 6
    //   806: aconst_null
    //   807: astore 5
    //   809: goto -278 -> 531
    //   812: aconst_null
    //   813: astore_0
    //   814: goto -644 -> 170
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	817	0	paramString1	String
    //   0	817	1	paramString2	String
    //   0	817	2	paramBoolean	boolean
    //   0	817	3	paramDecryptListener	DecryptListener
    //   1	477	4	i	int
    //   35	773	5	localObject1	Object
    //   7	664	6	localObject2	Object
    //   675	9	6	localObject3	Object
    //   688	81	6	localObject4	Object
    //   773	9	6	localException1	Exception
    //   786	19	6	localObject5	Object
    //   97	137	7	str	String
    //   242	182	7	localException2	Exception
    //   428	259	7	localInputStream	InputStream
    //   693	6	7	localObject6	Object
    //   748	37	7	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   210	219	242	java/lang/Exception
    //   219	226	242	java/lang/Exception
    //   231	239	242	java/lang/Exception
    //   499	531	242	java/lang/Exception
    //   355	368	406	java/io/IOException
    //   372	379	406	java/io/IOException
    //   417	430	490	java/io/IOException
    //   447	454	490	java/io/IOException
    //   462	467	490	java/io/IOException
    //   536	541	571	java/io/IOException
    //   545	549	571	java/io/IOException
    //   553	557	571	java/io/IOException
    //   564	568	571	java/io/IOException
    //   260	265	575	java/io/IOException
    //   270	275	575	java/io/IOException
    //   279	283	575	java/io/IOException
    //   287	291	575	java/io/IOException
    //   99	133	578	finally
    //   133	147	578	finally
    //   147	170	578	finally
    //   307	330	578	finally
    //   355	368	578	finally
    //   372	379	578	finally
    //   594	599	627	java/io/IOException
    //   604	609	627	java/io/IOException
    //   613	617	627	java/io/IOException
    //   621	625	627	java/io/IOException
    //   174	180	631	finally
    //   180	184	643	finally
    //   384	389	653	finally
    //   417	430	653	finally
    //   447	454	653	finally
    //   462	467	653	finally
    //   188	197	665	finally
    //   197	210	675	finally
    //   210	219	693	finally
    //   219	226	693	finally
    //   231	239	693	finally
    //   499	531	693	finally
    //   250	255	704	finally
    //   99	133	708	java/lang/Exception
    //   133	147	708	java/lang/Exception
    //   147	170	708	java/lang/Exception
    //   307	330	708	java/lang/Exception
    //   355	368	708	java/lang/Exception
    //   372	379	708	java/lang/Exception
    //   174	180	722	java/lang/Exception
    //   180	184	734	java/lang/Exception
    //   384	389	744	java/lang/Exception
    //   417	430	744	java/lang/Exception
    //   447	454	744	java/lang/Exception
    //   462	467	744	java/lang/Exception
    //   188	197	763	java/lang/Exception
    //   197	210	773	java/lang/Exception
    //   384	389	791	java/io/IOException
  }
  
  public static JSONObject parseVideoMaterialString(String paramString, DecryptListener paramDecryptListener)
  {
    String str = paramString.trim();
    paramString = str;
    if (str != null) {
      paramString = str;
    }
    try
    {
      if (str.charAt(0) != '{')
      {
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
        paramString = paramDecryptListener.toString();
      }
      if (!TextUtils.isEmpty(paramString)) {}
      for (paramString = (JSONObject)new JSONTokener(paramString).nextValue();; paramString = null) {
        return paramString;
      }
      return null;
    }
    catch (Exception paramString) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.ttpic.util.VideoTemplateParser
 * JD-Core Version:    0.7.0.1
 */
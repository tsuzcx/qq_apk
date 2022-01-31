package com.tencent.ttpic.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.graphics.Point;
import android.graphics.PointF;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.PTFaceAttr.PTExpression;
import com.tencent.ttpic.VideoModule;
import com.tencent.ttpic.VideoModule.DeviceType;
import com.tencent.ttpic.baseutils.BaseUtils;
import com.tencent.ttpic.baseutils.BitmapUtils;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.config.MediaConfig.ENCODE_SIZE;
import com.tencent.ttpic.constant.CATEGORY_TYPE;
import com.tencent.ttpic.device.DeviceInstance;
import com.tencent.ttpic.facedetect.FaceDetector.DETECT_TYPE;
import com.tencent.ttpic.filter.FabbyMvPart;
import com.tencent.ttpic.filter.FabbyParts;
import com.tencent.ttpic.gameplaysdk.model.StickerItem3D;
import com.tencent.ttpic.model.Audio2Text;
import com.tencent.ttpic.model.FaceFeatureItem;
import com.tencent.ttpic.model.FaceItem;
import com.tencent.ttpic.model.Point3D;
import com.tencent.ttpic.model.StickerItem;
import com.tencent.ttpic.model.VideoMaterial;
import com.tencent.ttpic.model.VideoMaterialMetaData;
import com.tencent.ttpic.model.WMElement;
import com.tencent.ttpic.model.WMGroup;
import com.tencent.util.i;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class VideoMaterialUtil
{
  public static final String CRAZYFACE_ANTI_WRINKLE = "antiWrinkle";
  public static final String CRAZYFACE_BLEND_ALPHA = "blendAlpha";
  public static final String CRAZYFACE_CANVAS = "canvas";
  public static final String CRAZYFACE_DISTORTION_ALPHA = "distortionAlpha";
  public static final String CRAZYFACE_DISTORTION_LIST = "distortionList";
  public static final String CRAZYFACE_FACE_COLOR = "imageFaceColor";
  public static final String CRAZYFACE_FACE_COLOR2 = "imageFaceColor2";
  public static final String CRAZYFACE_FACE_COLOR_RANGE = "faceColorRange";
  public static final String CRAZYFACE_FACE_LAYER = "faceImageLayer";
  public static final String CRAZYFACE_FACE_MASK = "faceMaskImage";
  public static final String CRAZYFACE_FACE_MASK_POINTS = "faceMaskFacePoint";
  public static final String CRAZYFACE_FACE_POINTS = "imageFacePoint";
  public static final String CRAZYFACE_FACE_RIANGLE = "faceTriangle";
  public static final String CRAZYFACE_HEIGHT = "height";
  public static final String CRAZYFACE_IMAGE_LAYER = "imageLayer";
  public static final String CRAZYFACE_IMAGE_PATH = "image";
  public static final String CRAZYFACE_LAYER_TYPE = "type";
  public static final String CRAZYFACE_STK_TYPE = "stkType";
  public static final String CRAZYFACE_WIDTH = "width";
  public static final String CRAZYFACE_X = "x";
  public static final String CRAZYFACE_Y = "y";
  public static final String[] DEVICE_NEED_COPY_TRANSFORM;
  public static final String[] DEVICE_NEED_SMALL_SIZE;
  public static final List<Integer> EMPTY_ANGLES_LIST;
  public static final List<PointF> EMPTY_POINTS_LIST;
  public static boolean ENABLE_FAST_RENDER = false;
  public static final String FILE_NAME_CUSTOM_FILTER_FRAGMENT_SHADER_ANDROID = "filterFragment_android.glsl";
  public static final String FILE_NAME_CUSTOM_FILTER_FRAGMENT_SHADER_COMMON = "filterFragment.glsl";
  public static final String FILE_NAME_CUSTOM_FILTER_VERTEX_SHADER_ANDROID = "filterVertex_android.glsl";
  public static final String FILE_NAME_CUSTOM_FILTER_VERTEX_SHADER_COMMON = "filterVertex.glsl";
  public static final String FILE_NAME_FRAGMENT_SHADER_ANDROID = "fragment_android.glsl";
  public static final String FILE_NAME_FRAGMENT_SHADER_COMMON = "fragment.glsl";
  public static final String FILE_NAME_VERTEX_SHADER_ANDROID = "vertex_android.glsl";
  public static final String FILE_NAME_VERTEX_SHADER_COMMON = "vertex.glsl";
  public static final String FRAMES_ID_SEPARATOR_3D = ":";
  public static final int INVALID_INT_FIELD_VALUE = -999999;
  public static final String ITEM_ID_CUSTOM = "nothing";
  public static final String MATERIAL_PREFIX = "video_";
  public static final String MP4_SUFFIX = ".mp4";
  public static final String PARAMS_FILE_NAME = "params";
  public static final String PNG_SUFFIX = ".png";
  public static final double RATIO_CANVAS = 0.75D;
  public static final double SCALE_DIFF = 100.0D;
  public static double SCALE_FACE_DETECT = 0.0D;
  public static final double SCALE_Y = 0.25D;
  public static final int SIZE_FACE_ANGLE = 3;
  public static final int SIZE_FACE_POINT = 90;
  private static final String TAG;
  public static FilenameFilter mMp4Filter;
  public static FilenameFilter mPngFilter;
  
  static
  {
    AppMethodBeat.i(84211);
    TAG = VideoMaterialUtil.class.getSimpleName();
    SCALE_FACE_DETECT = 0.16666667163372D;
    ENABLE_FAST_RENDER = true;
    EMPTY_POINTS_LIST = new ArrayList();
    EMPTY_ANGLES_LIST = new ArrayList();
    mPngFilter = new VideoMaterialUtil.3();
    mMp4Filter = new VideoMaterialUtil.4();
    DEVICE_NEED_SMALL_SIZE = new String[] { "A1001" };
    DEVICE_NEED_COPY_TRANSFORM = new String[] { "A1001", "SM-N9006", "vivo_X5Max_L", "vivo_X5Max_L", "vivo_X5V", "vivo_Y23L" };
    AppMethodBeat.o(84211);
  }
  
  public static float angleToRadian(float paramFloat)
  {
    return (float)(paramFloat * 3.141592653589793D / 180.0D);
  }
  
  public static List<Point3D> arrayTo3DPointList(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(84152);
    ArrayList localArrayList = new ArrayList();
    if (paramArrayOfFloat == null)
    {
      AppMethodBeat.o(84152);
      return localArrayList;
    }
    int i = 0;
    while (i < paramArrayOfFloat.length / 3)
    {
      localArrayList.add(new Point3D(paramArrayOfFloat[(i * 3)], paramArrayOfFloat[(i * 3 + 1)], paramArrayOfFloat[(i * 3 + 2)]));
      i += 1;
    }
    AppMethodBeat.o(84152);
    return localArrayList;
  }
  
  public static List<Float> arrayToList(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(84150);
    ArrayList localArrayList = new ArrayList();
    if (paramArrayOfFloat == null)
    {
      AppMethodBeat.o(84150);
      return localArrayList;
    }
    int j = paramArrayOfFloat.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(Float.valueOf(paramArrayOfFloat[i]));
      i += 1;
    }
    AppMethodBeat.o(84150);
    return localArrayList;
  }
  
  public static List<PointF> arrayToPointList(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(84151);
    ArrayList localArrayList = new ArrayList();
    if (paramArrayOfFloat == null)
    {
      AppMethodBeat.o(84151);
      return localArrayList;
    }
    int i = 0;
    while (i < paramArrayOfFloat.length / 2)
    {
      localArrayList.add(new PointF(paramArrayOfFloat[(i * 2)], paramArrayOfFloat[(i * 2 + 1)]));
      i += 1;
    }
    AppMethodBeat.o(84151);
    return localArrayList;
  }
  
  public static List<PointF> arrayToPointList(int[][] paramArrayOfInt)
  {
    AppMethodBeat.i(84153);
    ArrayList localArrayList = new ArrayList();
    if (paramArrayOfInt == null)
    {
      AppMethodBeat.o(84153);
      return localArrayList;
    }
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      localArrayList.add(new PointF(paramArrayOfInt[i][0], paramArrayOfInt[i][1]));
      i += 1;
    }
    AppMethodBeat.o(84153);
    return localArrayList;
  }
  
  public static int calSampleSize(long paramLong1, long paramLong2, int paramInt)
  {
    int i;
    if (paramLong1 <= 0L)
    {
      i = 128;
      return i;
    }
    for (;;)
    {
      i = paramInt;
      if (paramLong2 <= paramLong1) {
        break;
      }
      paramInt <<= 1;
      paramLong2 >>= 2;
    }
  }
  
  public static boolean canMaterialUseFastRender(VideoMaterial paramVideoMaterial)
  {
    AppMethodBeat.i(84201);
    paramVideoMaterial = paramVideoMaterial.getItemList().iterator();
    int i = 0;
    if (paramVideoMaterial.hasNext())
    {
      if (!canStickerItemUseFastRender((StickerItem)paramVideoMaterial.next())) {
        break label71;
      }
      i += 1;
    }
    label71:
    for (;;)
    {
      break;
      if (i <= 7)
      {
        AppMethodBeat.o(84201);
        return true;
      }
      AppMethodBeat.o(84201);
      return false;
    }
  }
  
  public static boolean canStickerItemUseFastBodyRender(StickerItem paramStickerItem)
  {
    AppMethodBeat.i(84200);
    if ((canStickerItemUseFastRender(paramStickerItem)) && (paramStickerItem.type == VideoFilterFactory.POSITION_TYPE.BODY.type))
    {
      AppMethodBeat.o(84200);
      return true;
    }
    AppMethodBeat.o(84200);
    return false;
  }
  
  public static boolean canStickerItemUseFastFaceRender(StickerItem paramStickerItem)
  {
    AppMethodBeat.i(84199);
    if ((canStickerItemUseFastRender(paramStickerItem)) && (paramStickerItem.type == VideoFilterFactory.POSITION_TYPE.DYNAMIC.type))
    {
      AppMethodBeat.o(84199);
      return true;
    }
    AppMethodBeat.o(84199);
    return false;
  }
  
  public static boolean canStickerItemUseFastRender(StickerItem paramStickerItem)
  {
    return (ENABLE_FAST_RENDER) && (paramStickerItem != null) && (paramStickerItem.markMode == 0) && (paramStickerItem.personID < 0) && (paramStickerItem.stickerType == 0) && ((paramStickerItem.type == VideoFilterFactory.POSITION_TYPE.DYNAMIC.type) || (paramStickerItem.type == VideoFilterFactory.POSITION_TYPE.BODY.type)) && ((paramStickerItem.blendMode < 2) || (paramStickerItem.blendMode > 12)) && (paramStickerItem.zIndex == 0) && (paramStickerItem.charmRange == null) && (paramStickerItem.ageRange == null) && (paramStickerItem.popularRange == null) && (paramStickerItem.genderRange == null) && (paramStickerItem.cpRange == null) && (paramStickerItem.randomGroupNum == 0) && (paramStickerItem.audioTriggerType == 0) && (paramStickerItem.particleConfig == null);
  }
  
  public static void copyArrayToArray(PointF[] paramArrayOfPointF1, PointF[] paramArrayOfPointF2)
  {
    AppMethodBeat.i(84165);
    if ((paramArrayOfPointF1 == null) || (paramArrayOfPointF2 == null))
    {
      AppMethodBeat.o(84165);
      return;
    }
    int i = 0;
    while (i < Math.min(paramArrayOfPointF1.length, paramArrayOfPointF2.length))
    {
      paramArrayOfPointF2[i].x = paramArrayOfPointF1[i].x;
      paramArrayOfPointF2[i].y = paramArrayOfPointF1[i].y;
      i += 1;
    }
    AppMethodBeat.o(84165);
  }
  
  public static int copyList(List<PointF> paramList1, List<PointF> paramList2)
  {
    AppMethodBeat.i(84158);
    if ((paramList2 == null) || (paramList1 == null))
    {
      AppMethodBeat.o(84158);
      return -1;
    }
    int k = paramList2.size();
    int i = 0;
    int j;
    for (;;)
    {
      j = i;
      if (i >= paramList1.size()) {
        break;
      }
      ((PointF)paramList1.get(i)).x = ((PointF)paramList2.get(i)).x;
      ((PointF)paramList1.get(i)).y = ((PointF)paramList2.get(i)).y;
      i += 1;
    }
    while (j < k)
    {
      paramList1.add(new PointF(((PointF)paramList2.get(j)).x, ((PointF)paramList2.get(j)).y));
      j += 1;
    }
    AppMethodBeat.o(84158);
    return 0;
  }
  
  public static List<PointF> copyList(List<PointF> paramList)
  {
    AppMethodBeat.i(84157);
    if (paramList == null)
    {
      AppMethodBeat.o(84157);
      return null;
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      PointF localPointF = (PointF)paramList.next();
      localArrayList.add(new PointF(localPointF.x, localPointF.y));
    }
    AppMethodBeat.o(84157);
    return localArrayList;
  }
  
  public static void copyListToArray(List<PointF> paramList, PointF[] paramArrayOfPointF)
  {
    AppMethodBeat.i(84164);
    if ((BaseUtils.isEmpty(paramList)) || (paramArrayOfPointF == null))
    {
      AppMethodBeat.o(84164);
      return;
    }
    int i = 0;
    while (i < Math.min(paramList.size(), paramArrayOfPointF.length))
    {
      paramArrayOfPointF[i].x = ((PointF)paramList.get(i)).x;
      paramArrayOfPointF[i].y = ((PointF)paramList.get(i)).y;
      i += 1;
    }
    AppMethodBeat.o(84164);
  }
  
  public static void flipYPoints(List<PointF> paramList, int paramInt) {}
  
  public static float[] flipYPoints(float[] paramArrayOfFloat, int paramInt)
  {
    return paramArrayOfFloat;
  }
  
  public static int genFullScreenVertices(float[] paramArrayOfFloat, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    int i = 1;
    AppMethodBeat.i(84149);
    if ((paramInt1 <= 0) || (paramInt2 <= 0))
    {
      AppMethodBeat.o(84149);
      return -1;
    }
    paramFloat2 = (paramFloat2 - paramFloat1) / paramInt1;
    paramFloat4 = (paramFloat4 - paramFloat3) / paramInt2;
    paramArrayOfFloat[0] = getCoordinate(paramFloat1, paramFloat2, 0);
    paramArrayOfFloat[1] = getCoordinate(paramFloat3, paramFloat4, 0);
    int j = 0;
    if (j < paramInt1)
    {
      int m;
      int k;
      if (j % 2 == 0)
      {
        m = 0;
        k = i;
        i = m;
        while (i < paramInt2)
        {
          paramArrayOfFloat[(k * 2)] = getCoordinate(paramFloat1, paramFloat2, j + 1);
          paramArrayOfFloat[(k * 2 + 1)] = getCoordinate(paramFloat3, paramFloat4, i);
          k += 1;
          paramArrayOfFloat[(k * 2)] = getCoordinate(paramFloat1, paramFloat2, j);
          paramArrayOfFloat[(k * 2 + 1)] = getCoordinate(paramFloat3, paramFloat4, i + 1);
          k += 1;
          i += 1;
        }
        paramArrayOfFloat[(k * 2)] = getCoordinate(paramFloat1, paramFloat2, j + 1);
        paramArrayOfFloat[(k * 2 + 1)] = getCoordinate(paramFloat3, paramFloat4, paramInt2);
      }
      for (i = k + 1;; i = m + 1)
      {
        j += 1;
        break;
        k = paramInt2;
        m = i;
        i = k;
        while (i > 0)
        {
          paramArrayOfFloat[(m * 2)] = getCoordinate(paramFloat1, paramFloat2, j + 1);
          paramArrayOfFloat[(m * 2 + 1)] = getCoordinate(paramFloat3, paramFloat4, i);
          k = m + 1;
          paramArrayOfFloat[(k * 2)] = getCoordinate(paramFloat1, paramFloat2, j);
          paramArrayOfFloat[(k * 2 + 1)] = getCoordinate(paramFloat3, paramFloat4, i - 1);
          m = k + 1;
          i -= 1;
        }
        paramArrayOfFloat[(m * 2)] = getCoordinate(paramFloat1, paramFloat2, j + 1);
        paramArrayOfFloat[(m * 2 + 1)] = getCoordinate(paramFloat3, paramFloat4, 0);
      }
    }
    AppMethodBeat.o(84149);
    return 0;
  }
  
  public static List<PointF> genFullScreenVertices(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AppMethodBeat.i(84148);
    ArrayList localArrayList = new ArrayList();
    if ((paramInt1 <= 0) || (paramInt2 <= 0))
    {
      AppMethodBeat.o(84148);
      return localArrayList;
    }
    paramFloat2 = (paramFloat2 - paramFloat1) / paramInt1;
    paramFloat4 = (paramFloat4 - paramFloat3) / paramInt2;
    localArrayList.add(new PointF(getCoordinate(paramFloat1, paramFloat2, 0), getCoordinate(paramFloat3, paramFloat4, 0)));
    int i = 0;
    if (i < paramInt1)
    {
      int j;
      if (i % 2 == 0)
      {
        j = 0;
        while (j < paramInt2)
        {
          localArrayList.add(new PointF(getCoordinate(paramFloat1, paramFloat2, i + 1), getCoordinate(paramFloat3, paramFloat4, j)));
          localArrayList.add(new PointF(getCoordinate(paramFloat1, paramFloat2, i), getCoordinate(paramFloat3, paramFloat4, j + 1)));
          j += 1;
        }
        localArrayList.add(new PointF(getCoordinate(paramFloat1, paramFloat2, i + 1), getCoordinate(paramFloat3, paramFloat4, paramInt2)));
      }
      for (;;)
      {
        i += 1;
        break;
        j = paramInt2;
        while (j > 0)
        {
          localArrayList.add(new PointF(getCoordinate(paramFloat1, paramFloat2, i + 1), getCoordinate(paramFloat3, paramFloat4, j)));
          localArrayList.add(new PointF(getCoordinate(paramFloat1, paramFloat2, i), getCoordinate(paramFloat3, paramFloat4, j - 1)));
          j -= 1;
        }
        localArrayList.add(new PointF(getCoordinate(paramFloat1, paramFloat2, i + 1), getCoordinate(paramFloat3, paramFloat4, 0)));
      }
    }
    AppMethodBeat.o(84148);
    return localArrayList;
  }
  
  public static String getActionTipString(int paramInt)
  {
    AppMethodBeat.i(84144);
    String str;
    if (paramInt == PTFaceAttr.PTExpression.MOUTH_OPEN.value)
    {
      str = VideoGlobalContext.getContext().getString(2131306097);
      AppMethodBeat.o(84144);
      return str;
    }
    if (paramInt == PTFaceAttr.PTExpression.EYEBROWS_RAISE.value)
    {
      str = VideoGlobalContext.getContext().getString(2131306098);
      AppMethodBeat.o(84144);
      return str;
    }
    if (paramInt == PTFaceAttr.PTExpression.BLINK.value)
    {
      str = VideoGlobalContext.getContext().getString(2131306092);
      AppMethodBeat.o(84144);
      return str;
    }
    if (paramInt == PTFaceAttr.PTExpression.HEAD_SHAKE.value)
    {
      str = VideoGlobalContext.getContext().getString(2131306099);
      AppMethodBeat.o(84144);
      return str;
    }
    if (paramInt == PTFaceAttr.PTExpression.KISS.value)
    {
      str = VideoGlobalContext.getContext().getString(2131306095);
      AppMethodBeat.o(84144);
      return str;
    }
    if (paramInt == PTFaceAttr.PTExpression.BLINK_LEFT_EYE.value)
    {
      str = VideoGlobalContext.getContext().getString(2131306093);
      AppMethodBeat.o(84144);
      return str;
    }
    if (paramInt == PTFaceAttr.PTExpression.BLINK_RIGHT_EYE.value)
    {
      str = VideoGlobalContext.getContext().getString(2131306094);
      AppMethodBeat.o(84144);
      return str;
    }
    if (paramInt == PTFaceAttr.PTExpression.HEAD_NOD.value)
    {
      str = VideoGlobalContext.getContext().getString(2131306096);
      AppMethodBeat.o(84144);
      return str;
    }
    if (paramInt == PTFaceAttr.PTExpression.HEAD_SHAKE_NEW.value)
    {
      str = VideoGlobalContext.getContext().getString(2131306099);
      AppMethodBeat.o(84144);
      return str;
    }
    if (paramInt == PTFaceAttr.PTExpression.TRY_CLICK_SCREEN.value)
    {
      str = VideoGlobalContext.getContext().getString(2131306100);
      AppMethodBeat.o(84144);
      return str;
    }
    AppMethodBeat.o(84144);
    return "";
  }
  
  public static int getAllImageSize(VideoMaterial paramVideoMaterial)
  {
    AppMethodBeat.i(84172);
    if ((paramVideoMaterial == null) || (paramVideoMaterial.getDataPath() == null))
    {
      AppMethodBeat.o(84172);
      return 0;
    }
    Object localObject = new ArrayList();
    if (paramVideoMaterial.getItemList() != null) {
      ((List)localObject).addAll(paramVideoMaterial.getItemList());
    }
    if (paramVideoMaterial.getHeadCropItemList() != null) {
      ((List)localObject).addAll(paramVideoMaterial.getHeadCropItemList());
    }
    localObject = ((List)localObject).iterator();
    StickerItem localStickerItem;
    for (int i = 0; ((Iterator)localObject).hasNext(); i = getAllImageSize(paramVideoMaterial.getDataPath() + File.separator + localStickerItem.subFolder) + i) {
      localStickerItem = (StickerItem)((Iterator)localObject).next();
    }
    AppMethodBeat.o(84172);
    return i;
  }
  
  public static int getAllImageSize(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(84171);
    if (paramString.startsWith("assets://")) {}
    for (;;)
    {
      try
      {
        arrayOfString = VideoGlobalContext.getContext().getAssets().list(FileUtils.getRealPath(paramString));
        if (arrayOfString != null)
        {
          j = arrayOfString.length;
          if (j != 0) {}
        }
        else
        {
          AppMethodBeat.o(84171);
          return 0;
        }
        paramString = BitmapUtils.getBitmapSize(VideoGlobalContext.getContext(), paramString + File.separator + arrayOfString[0]);
        if (paramString == null)
        {
          AppMethodBeat.o(84171);
          return 0;
        }
        int j = paramString.x;
        int k = paramString.y;
        int m = arrayOfString.length;
        i = m * (k * j * 4) + 0;
      }
      catch (IOException paramString)
      {
        String[] arrayOfString;
        continue;
      }
      AppMethodBeat.o(84171);
      return i;
      arrayOfString = new File(paramString).list(mPngFilter);
      if ((arrayOfString == null) || (arrayOfString.length == 0))
      {
        AppMethodBeat.o(84171);
        return 0;
      }
      paramString = BitmapUtils.getBitmapSize(VideoGlobalContext.getContext(), paramString + File.separator + arrayOfString[0]);
      if (paramString == null)
      {
        AppMethodBeat.o(84171);
        return 0;
      }
      i = paramString.x * paramString.y * 4 * arrayOfString.length + 0;
    }
  }
  
  public static List<Integer> getAllIndex(PointWithIndex[][] paramArrayOfPointWithIndex, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(84147);
    if ((paramInt1 <= 0) || (paramInt2 <= 0))
    {
      AppMethodBeat.o(84147);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(paramArrayOfPointWithIndex[0][0].index));
    int i = 0;
    if (i < paramInt1)
    {
      int j;
      if (i % 2 == 0)
      {
        j = 0;
        while (j < paramInt2)
        {
          localArrayList.add(Integer.valueOf(paramArrayOfPointWithIndex[j][(i + 1)].index));
          localArrayList.add(Integer.valueOf(paramArrayOfPointWithIndex[(j + 1)][i].index));
          j += 1;
        }
        localArrayList.add(Integer.valueOf(paramArrayOfPointWithIndex[paramInt2][(i + 1)].index));
      }
      for (;;)
      {
        i += 1;
        break;
        j = paramInt2;
        while (j > 0)
        {
          localArrayList.add(Integer.valueOf(paramArrayOfPointWithIndex[j][(i + 1)].index));
          localArrayList.add(Integer.valueOf(paramArrayOfPointWithIndex[(j - 1)][i].index));
          j -= 1;
        }
        localArrayList.add(Integer.valueOf(paramArrayOfPointWithIndex[0][(i + 1)].index));
      }
    }
    AppMethodBeat.o(84147);
    return localArrayList;
  }
  
  public static PointWithIndex[][] getAllPoints(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AppMethodBeat.i(84146);
    if ((paramInt1 <= 0) || (paramInt2 <= 0))
    {
      AppMethodBeat.o(84146);
      return null;
    }
    paramFloat2 = (paramFloat2 - paramFloat1) / paramInt1;
    paramFloat4 = (paramFloat4 - paramFloat3) / paramInt2;
    PointWithIndex[][] arrayOfPointWithIndex = (PointWithIndex[][])Array.newInstance(PointWithIndex.class, new int[] { paramInt2 + 1, paramInt1 + 1 });
    int j = 0;
    int i = 0;
    while (i <= paramInt2)
    {
      int k = 0;
      while (k <= paramInt1)
      {
        arrayOfPointWithIndex[i][k] = new PointWithIndex(getCoordinate(paramFloat1, paramFloat2, k), getCoordinate(paramFloat3, paramFloat4, i), j);
        k += 1;
        j += 1;
      }
      i += 1;
    }
    AppMethodBeat.o(84146);
    return arrayOfPointWithIndex;
  }
  
  private static float getCoordinate(float paramFloat1, float paramFloat2, int paramInt)
  {
    return paramInt * paramFloat2 + paramFloat1;
  }
  
  public static VideoMaterialUtil.ITEM_SOURCE_TYPE getItemSourceType(int paramInt)
  {
    if (paramInt == 1) {
      return VideoMaterialUtil.ITEM_SOURCE_TYPE.VIDEO_LEFT_RIGHT;
    }
    if (paramInt == 2) {
      return VideoMaterialUtil.ITEM_SOURCE_TYPE.VIDEO_UP_DOWN;
    }
    return VideoMaterialUtil.ITEM_SOURCE_TYPE.VIDEO_NORMAL;
  }
  
  public static String getMaterialId(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(84168);
    if (paramString == null)
    {
      AppMethodBeat.o(84168);
      return null;
    }
    String[] arrayOfString = paramString.split(File.separator);
    int i = arrayOfString.length - 1;
    for (;;)
    {
      paramString = localObject;
      if (i >= 0)
      {
        if (!TextUtils.isEmpty(arrayOfString[i])) {
          paramString = arrayOfString[i];
        }
      }
      else
      {
        AppMethodBeat.o(84168);
        return paramString;
      }
      i -= 1;
    }
  }
  
  public static String getMusicMaterialM4aPath(String paramString)
  {
    AppMethodBeat.i(84169);
    if (paramString == null)
    {
      AppMethodBeat.o(84169);
      return null;
    }
    paramString = paramString + File.separator + getMaterialId(paramString) + ".m4a";
    AppMethodBeat.o(84169);
    return paramString;
  }
  
  public static int getNormalEncodeWidth()
  {
    AppMethodBeat.i(84186);
    if (needSmallSize())
    {
      i = MediaConfig.ENCODE_SIZE.MEDIUM.width;
      AppMethodBeat.o(84186);
      return i;
    }
    int i = VideoPrefsUtil.getNormalEncodeWidth();
    AppMethodBeat.o(84186);
    return i;
  }
  
  public static PTFaceAttr.PTExpression getOppositeTriggerType(int paramInt)
  {
    AppMethodBeat.i(84138);
    PTFaceAttr.PTExpression localPTExpression = getTriggerType(paramInt).opposite;
    AppMethodBeat.o(84138);
    return localPTExpression;
  }
  
  public static PTFaceAttr.PTExpression getTriggerType(int paramInt)
  {
    AppMethodBeat.i(84139);
    Object localObject = PTFaceAttr.PTExpression.values();
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      PTFaceAttr.PTExpression localPTExpression = localObject[i];
      if (localPTExpression.value == paramInt)
      {
        AppMethodBeat.o(84139);
        return localPTExpression;
      }
      i += 1;
    }
    localObject = PTFaceAttr.PTExpression.UNKNOW;
    AppMethodBeat.o(84139);
    return localObject;
  }
  
  /* Error */
  public static int[] getVideoIndexMap(String paramString)
  {
    // Byte code:
    //   0: ldc_w 690
    //   3: invokestatic 215	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: iconst_0
    //   7: newarray int
    //   9: astore 7
    //   11: new 692	java/io/RandomAccessFile
    //   14: dup
    //   15: aload_0
    //   16: ldc_w 694
    //   19: invokespecial 697	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: astore 8
    //   24: aload 7
    //   26: astore_0
    //   27: aload 8
    //   29: invokevirtual 701	java/io/RandomAccessFile:length	()J
    //   32: lstore_3
    //   33: aload 7
    //   35: astore_0
    //   36: aload 8
    //   38: lload_3
    //   39: ldc2_w 702
    //   42: lsub
    //   43: invokevirtual 707	java/io/RandomAccessFile:seek	(J)V
    //   46: aload 7
    //   48: astore_0
    //   49: iconst_4
    //   50: newarray byte
    //   52: astore 9
    //   54: aload 7
    //   56: astore_0
    //   57: aload 8
    //   59: aload 9
    //   61: invokevirtual 711	java/io/RandomAccessFile:read	([B)I
    //   64: pop
    //   65: aload 7
    //   67: astore_0
    //   68: aload 9
    //   70: invokestatic 716	com/tencent/ttpic/util/ByteUtil:readInt	([B)I
    //   73: istore_1
    //   74: iload_1
    //   75: bipush 12
    //   77: if_icmple +10 -> 87
    //   80: iload_1
    //   81: sipush 400
    //   84: if_icmplt +25 -> 109
    //   87: aload 7
    //   89: astore_0
    //   90: aload 8
    //   92: invokevirtual 719	java/io/RandomAccessFile:close	()V
    //   95: aload 8
    //   97: invokevirtual 719	java/io/RandomAccessFile:close	()V
    //   100: ldc_w 690
    //   103: invokestatic 267	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   106: aload 7
    //   108: areturn
    //   109: iload_1
    //   110: i2l
    //   111: lstore 5
    //   113: aload 7
    //   115: astore_0
    //   116: aload 8
    //   118: lload_3
    //   119: lload 5
    //   121: lsub
    //   122: ldc2_w 720
    //   125: ladd
    //   126: invokevirtual 707	java/io/RandomAccessFile:seek	(J)V
    //   129: aload 7
    //   131: astore_0
    //   132: iload_1
    //   133: bipush 12
    //   135: isub
    //   136: iconst_4
    //   137: idiv
    //   138: istore_2
    //   139: aload 7
    //   141: astore_0
    //   142: iload_2
    //   143: newarray int
    //   145: astore 7
    //   147: iconst_0
    //   148: istore_1
    //   149: iload_1
    //   150: iload_2
    //   151: if_icmpge +33 -> 184
    //   154: aload 7
    //   156: astore_0
    //   157: aload 8
    //   159: aload 9
    //   161: invokevirtual 711	java/io/RandomAccessFile:read	([B)I
    //   164: pop
    //   165: aload 7
    //   167: astore_0
    //   168: aload 7
    //   170: iload_1
    //   171: aload 9
    //   173: invokestatic 716	com/tencent/ttpic/util/ByteUtil:readInt	([B)I
    //   176: iastore
    //   177: iload_1
    //   178: iconst_1
    //   179: iadd
    //   180: istore_1
    //   181: goto -32 -> 149
    //   184: aload 8
    //   186: invokevirtual 719	java/io/RandomAccessFile:close	()V
    //   189: ldc_w 690
    //   192: invokestatic 267	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   195: aload 7
    //   197: areturn
    //   198: astore_0
    //   199: aconst_null
    //   200: astore 8
    //   202: aload 7
    //   204: astore_0
    //   205: aload_0
    //   206: astore 7
    //   208: aload 8
    //   210: ifnull -21 -> 189
    //   213: aload 8
    //   215: invokevirtual 719	java/io/RandomAccessFile:close	()V
    //   218: aload_0
    //   219: astore 7
    //   221: goto -32 -> 189
    //   224: astore 7
    //   226: aload_0
    //   227: astore 7
    //   229: goto -40 -> 189
    //   232: astore_0
    //   233: aconst_null
    //   234: astore 8
    //   236: aload 8
    //   238: ifnull +8 -> 246
    //   241: aload 8
    //   243: invokevirtual 719	java/io/RandomAccessFile:close	()V
    //   246: ldc_w 690
    //   249: invokestatic 267	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   252: aload_0
    //   253: athrow
    //   254: astore_0
    //   255: goto -155 -> 100
    //   258: astore_0
    //   259: goto -70 -> 189
    //   262: astore 7
    //   264: goto -18 -> 246
    //   267: astore_0
    //   268: goto -32 -> 236
    //   271: astore 7
    //   273: goto -68 -> 205
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	276	0	paramString	String
    //   73	108	1	i	int
    //   138	14	2	j	int
    //   32	87	3	l1	long
    //   111	9	5	l2	long
    //   9	211	7	localObject	Object
    //   224	1	7	localIOException1	IOException
    //   227	1	7	str	String
    //   262	1	7	localIOException2	IOException
    //   271	1	7	localException	Exception
    //   22	220	8	localRandomAccessFile	java.io.RandomAccessFile
    //   52	120	9	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   11	24	198	java/lang/Exception
    //   213	218	224	java/io/IOException
    //   11	24	232	finally
    //   95	100	254	java/io/IOException
    //   184	189	258	java/io/IOException
    //   241	246	262	java/io/IOException
    //   27	33	267	finally
    //   36	46	267	finally
    //   49	54	267	finally
    //   57	65	267	finally
    //   68	74	267	finally
    //   90	95	267	finally
    //   116	129	267	finally
    //   132	139	267	finally
    //   142	147	267	finally
    //   157	165	267	finally
    //   168	177	267	finally
    //   27	33	271	java/lang/Exception
    //   36	46	271	java/lang/Exception
    //   49	54	271	java/lang/Exception
    //   57	65	271	java/lang/Exception
    //   68	74	271	java/lang/Exception
    //   90	95	271	java/lang/Exception
    //   116	129	271	java/lang/Exception
    //   132	139	271	java/lang/Exception
    //   142	147	271	java/lang/Exception
    //   157	165	271	java/lang/Exception
    //   168	177	271	java/lang/Exception
  }
  
  public static boolean hasValidFaceOffItem(VideoMaterial paramVideoMaterial)
  {
    AppMethodBeat.i(84206);
    if ((paramVideoMaterial != null) && (paramVideoMaterial.getFaceOffItemList() != null))
    {
      paramVideoMaterial = paramVideoMaterial.getFaceOffItemList().iterator();
      while (paramVideoMaterial.hasNext()) {
        if (!isEmptyItem((FaceItem)paramVideoMaterial.next()))
        {
          AppMethodBeat.o(84206);
          return true;
        }
      }
    }
    AppMethodBeat.o(84206);
    return false;
  }
  
  public static boolean is3DMaterial(VideoMaterial paramVideoMaterial)
  {
    AppMethodBeat.i(84202);
    if (paramVideoMaterial == null)
    {
      AppMethodBeat.o(84202);
      return false;
    }
    if (paramVideoMaterial.getGameParams() != null)
    {
      AppMethodBeat.o(84202);
      return true;
    }
    AppMethodBeat.o(84202);
    return false;
  }
  
  public static boolean isARMaterial(VideoMaterial paramVideoMaterial)
  {
    AppMethodBeat.i(84181);
    if ((paramVideoMaterial != null) && (paramVideoMaterial.getArParticleList() != null) && (!paramVideoMaterial.getArParticleList().isEmpty()))
    {
      AppMethodBeat.o(84181);
      return true;
    }
    AppMethodBeat.o(84181);
    return false;
  }
  
  public static boolean isActionTriggerType(int paramInt)
  {
    boolean bool2 = false;
    PTFaceAttr.PTExpression[] arrayOfPTExpression = PTFaceAttr.PTExpression.ACTION_TRIGGER_TYPE;
    int j = arrayOfPTExpression.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (paramInt == arrayOfPTExpression[i].value) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static boolean isAudio2textMaterial(VideoMaterial paramVideoMaterial)
  {
    AppMethodBeat.i(84185);
    if ((paramVideoMaterial != null) && (paramVideoMaterial.getAudio2Text() != null) && (paramVideoMaterial.getAudio2Text().sentenceCount > 0))
    {
      AppMethodBeat.o(84185);
      return true;
    }
    AppMethodBeat.o(84185);
    return false;
  }
  
  public static boolean isAudioTextTriggerType(int paramInt)
  {
    return (300 <= paramInt) && (paramInt <= 311);
  }
  
  public static boolean isBodyDetectItem(StickerItem paramStickerItem)
  {
    return (paramStickerItem != null) && (paramStickerItem.type == VideoFilterFactory.POSITION_TYPE.BODY.type);
  }
  
  public static boolean isBodyDetectMaterial(VideoMaterial paramVideoMaterial)
  {
    AppMethodBeat.i(84208);
    if (paramVideoMaterial != null)
    {
      Object localObject2 = paramVideoMaterial.getItemList();
      Object localObject1 = paramVideoMaterial.getItemList3D();
      Object localObject3 = paramVideoMaterial.getHeadCropItemList();
      paramVideoMaterial = paramVideoMaterial.getFaceOffItemList();
      ArrayList localArrayList = new ArrayList();
      if (localObject2 != null) {
        localArrayList.addAll((Collection)localObject2);
      }
      if (localObject3 != null) {
        localArrayList.addAll((Collection)localObject3);
      }
      localObject2 = localArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (StickerItem)((Iterator)localObject2).next();
        if (((StickerItem)localObject3).type == VideoFilterFactory.POSITION_TYPE.BODY.type)
        {
          AppMethodBeat.o(84208);
          return true;
        }
        if (isBodyTriggerType(((StickerItem)localObject3).triggerType))
        {
          AppMethodBeat.o(84208);
          return true;
        }
      }
      if (paramVideoMaterial != null)
      {
        paramVideoMaterial = paramVideoMaterial.iterator();
        while (paramVideoMaterial.hasNext()) {
          if (isBodyTriggerType(((FaceItem)paramVideoMaterial.next()).triggerType))
          {
            AppMethodBeat.o(84208);
            return true;
          }
        }
      }
      if (localObject1 != null)
      {
        paramVideoMaterial = ((List)localObject1).iterator();
        while (paramVideoMaterial.hasNext())
        {
          localObject1 = (StickerItem3D)paramVideoMaterial.next();
          if (((StickerItem3D)localObject1).type == VideoFilterFactory.POSITION_TYPE.BODY.type)
          {
            AppMethodBeat.o(84208);
            return true;
          }
          if (isBodyTriggerType(((StickerItem3D)localObject1).triggerType))
          {
            AppMethodBeat.o(84208);
            return true;
          }
        }
      }
    }
    AppMethodBeat.o(84208);
    return false;
  }
  
  public static boolean isBodyDetectType(int paramInt)
  {
    return paramInt == 400;
  }
  
  public static boolean isBodyTriggerType(int paramInt)
  {
    return paramInt == 401;
  }
  
  public static boolean isChangeFaceMaterial(VideoMaterial paramVideoMaterial)
  {
    AppMethodBeat.i(84177);
    if (paramVideoMaterial != null)
    {
      if ((paramVideoMaterial.getShaderType() == 5) && (paramVideoMaterial.getFaceoffType() == 1))
      {
        AppMethodBeat.o(84177);
        return true;
      }
      AppMethodBeat.o(84177);
      return false;
    }
    AppMethodBeat.o(84177);
    return false;
  }
  
  public static boolean isCosMaterial(VideoMaterial paramVideoMaterial)
  {
    AppMethodBeat.i(84182);
    if ((paramVideoMaterial != null) && ((paramVideoMaterial.getDetectorFlag() == 1) || (paramVideoMaterial.getDetectorFlag() == 2)))
    {
      AppMethodBeat.o(84182);
      return true;
    }
    AppMethodBeat.o(84182);
    return false;
  }
  
  public static boolean isCpValueMaterial(VideoMaterial paramVideoMaterial)
  {
    AppMethodBeat.i(84173);
    if (paramVideoMaterial != null)
    {
      paramVideoMaterial = paramVideoMaterial.getItemList();
      if (paramVideoMaterial != null)
      {
        paramVideoMaterial = paramVideoMaterial.iterator();
        while (paramVideoMaterial.hasNext())
        {
          StickerItem localStickerItem = (StickerItem)paramVideoMaterial.next();
          if ((localStickerItem.markMode == FaceDetector.DETECT_TYPE.DETECT_TYPE_CP.value) || (localStickerItem.cpRange != null))
          {
            AppMethodBeat.o(84173);
            return true;
          }
        }
      }
    }
    AppMethodBeat.o(84173);
    return false;
  }
  
  public static boolean isDistortionFilter(VideoMaterial paramVideoMaterial)
  {
    AppMethodBeat.i(84166);
    if (paramVideoMaterial == null)
    {
      AppMethodBeat.o(84166);
      return false;
    }
    if (paramVideoMaterial.getShaderType() != VideoMaterialUtil.SHADER_TYPE.NORMAL.value)
    {
      AppMethodBeat.o(84166);
      return true;
    }
    AppMethodBeat.o(84166);
    return false;
  }
  
  public static boolean isDownloaded(VideoMaterial paramVideoMaterial)
  {
    AppMethodBeat.i(84189);
    if (paramVideoMaterial == null)
    {
      AppMethodBeat.o(84189);
      return false;
    }
    boolean bool = paramVideoMaterial.getDataPath().startsWith("/");
    AppMethodBeat.o(84189);
    return bool;
  }
  
  public static boolean isEmojiMaterial(VideoMaterial paramVideoMaterial)
  {
    AppMethodBeat.i(84176);
    if (paramVideoMaterial == null)
    {
      AppMethodBeat.o(84176);
      return false;
    }
    if (paramVideoMaterial.getCategoryFlag() == CATEGORY_TYPE.EMOJI.value)
    {
      AppMethodBeat.o(84176);
      return true;
    }
    AppMethodBeat.o(84176);
    return false;
  }
  
  public static boolean isEmptyItem(FaceItem paramFaceItem)
  {
    AppMethodBeat.i(84205);
    if ((paramFaceItem == null) || ((TextUtils.isEmpty(paramFaceItem.id)) && (TextUtils.isEmpty(paramFaceItem.faceExchangeImage))) || ((!TextUtils.isEmpty(paramFaceItem.id)) && (paramFaceItem.id.equals("action"))) || ((!TextUtils.isEmpty(paramFaceItem.id)) && (paramFaceItem.id.equals("audio"))))
    {
      AppMethodBeat.o(84205);
      return true;
    }
    AppMethodBeat.o(84205);
    return false;
  }
  
  public static boolean isEmptyItem(StickerItem paramStickerItem)
  {
    AppMethodBeat.i(84204);
    if ((paramStickerItem == null) || (TextUtils.isEmpty(paramStickerItem.id)) || (paramStickerItem.id.equals("action")) || (paramStickerItem.id.equals("audio")))
    {
      AppMethodBeat.o(84204);
      return true;
    }
    AppMethodBeat.o(84204);
    return false;
  }
  
  public static boolean isFaceCopyMaterial(VideoMaterial paramVideoMaterial)
  {
    AppMethodBeat.i(84179);
    if (paramVideoMaterial == null)
    {
      AppMethodBeat.o(84179);
      return false;
    }
    if ((paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.FACE_COPY.value) || ((paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.FACE_SWITCH.value) && (paramVideoMaterial.getFaceSwapType() == VideoMaterialUtil.FACE_SWAP_TYPE.FACE_COPY.value)))
    {
      AppMethodBeat.o(84179);
      return true;
    }
    AppMethodBeat.o(84179);
    return false;
  }
  
  public static boolean isFaceCountTriggerItem(StickerItem paramStickerItem)
  {
    return (paramStickerItem != null) && (2 <= paramStickerItem.countTriggerType) && (paramStickerItem.countTriggerType <= 107);
  }
  
  public static boolean isFaceItem(StickerItem paramStickerItem)
  {
    return (paramStickerItem != null) && ((paramStickerItem.type == VideoFilterFactory.POSITION_TYPE.STATIC.type) || (paramStickerItem.type == VideoFilterFactory.POSITION_TYPE.DYNAMIC.type) || (paramStickerItem.type == VideoFilterFactory.POSITION_TYPE.RELATIVE.type));
  }
  
  public static boolean isFaceMorphingMaterial(VideoMaterial paramVideoMaterial)
  {
    AppMethodBeat.i(84180);
    if (paramVideoMaterial == null)
    {
      AppMethodBeat.o(84180);
      return false;
    }
    if (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.FACE_MORPHING.value)
    {
      AppMethodBeat.o(84180);
      return true;
    }
    AppMethodBeat.o(84180);
    return false;
  }
  
  public static boolean isFaceSwitchMaterial(VideoMaterial paramVideoMaterial)
  {
    AppMethodBeat.i(84178);
    if (paramVideoMaterial == null)
    {
      AppMethodBeat.o(84178);
      return false;
    }
    if (((paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.FACE_SWITCH.value) || (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.FACE_SWITCH_DUP.value)) && (paramVideoMaterial.getFaceSwapType() == VideoMaterialUtil.FACE_SWAP_TYPE.FACE_SWITCH.value))
    {
      AppMethodBeat.o(84178);
      return true;
    }
    AppMethodBeat.o(84178);
    return false;
  }
  
  public static boolean isFaceTriggerType(int paramInt)
  {
    return paramInt < 200;
  }
  
  public static boolean isGestureCountTriggerItem(StickerItem paramStickerItem)
  {
    return (paramStickerItem != null) && (200 <= paramStickerItem.countTriggerType) && (paramStickerItem.countTriggerType <= 211);
  }
  
  public static boolean isGestureDetectMaterial(VideoMaterial paramVideoMaterial)
  {
    AppMethodBeat.i(84210);
    if (paramVideoMaterial != null)
    {
      Object localObject2 = paramVideoMaterial.getItemList();
      Object localObject1 = paramVideoMaterial.getItemList3D();
      Object localObject3 = paramVideoMaterial.getHeadCropItemList();
      paramVideoMaterial = paramVideoMaterial.getFaceOffItemList();
      ArrayList localArrayList = new ArrayList();
      if (localObject2 != null) {
        localArrayList.addAll((Collection)localObject2);
      }
      if (localObject3 != null) {
        localArrayList.addAll((Collection)localObject3);
      }
      localObject2 = localArrayList.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (StickerItem)((Iterator)localObject2).next();
        if (((StickerItem)localObject3).type == VideoFilterFactory.POSITION_TYPE.GESTURE.type)
        {
          AppMethodBeat.o(84210);
          return true;
        }
        if (isGestureTriggerType(((StickerItem)localObject3).triggerType))
        {
          AppMethodBeat.o(84210);
          return true;
        }
      }
      if (paramVideoMaterial != null)
      {
        paramVideoMaterial = paramVideoMaterial.iterator();
        while (paramVideoMaterial.hasNext()) {
          if (isGestureTriggerType(((FaceItem)paramVideoMaterial.next()).triggerType))
          {
            AppMethodBeat.o(84210);
            return true;
          }
        }
      }
      if (localObject1 != null)
      {
        paramVideoMaterial = ((List)localObject1).iterator();
        while (paramVideoMaterial.hasNext())
        {
          localObject1 = (StickerItem3D)paramVideoMaterial.next();
          if (((StickerItem3D)localObject1).type == VideoFilterFactory.POSITION_TYPE.GESTURE.type)
          {
            AppMethodBeat.o(84210);
            return true;
          }
          if (isGestureTriggerType(((StickerItem3D)localObject1).triggerType))
          {
            AppMethodBeat.o(84210);
            return true;
          }
        }
      }
    }
    AppMethodBeat.o(84210);
    return false;
  }
  
  public static boolean isGestureItem(StickerItem paramStickerItem)
  {
    return (paramStickerItem != null) && (paramStickerItem.type == VideoFilterFactory.POSITION_TYPE.GESTURE.type);
  }
  
  public static boolean isGestureTriggerType(int paramInt)
  {
    return (200 <= paramInt) && (paramInt <= 213);
  }
  
  public static boolean isHeadCropMaterial(VideoMaterial paramVideoMaterial)
  {
    AppMethodBeat.i(84198);
    if (paramVideoMaterial == null)
    {
      AppMethodBeat.o(84198);
      return false;
    }
    if (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.FACE_HEAD_CROP.value)
    {
      AppMethodBeat.o(84198);
      return true;
    }
    AppMethodBeat.o(84198);
    return false;
  }
  
  public static boolean isSegmentMaterial(VideoMaterial paramVideoMaterial)
  {
    AppMethodBeat.i(84209);
    if ((paramVideoMaterial != null) && (paramVideoMaterial.isSegmentRequired()))
    {
      AppMethodBeat.o(84209);
      return true;
    }
    AppMethodBeat.o(84209);
    return false;
  }
  
  public static boolean isValidOutputFile(String paramString)
  {
    AppMethodBeat.i(84156);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(84156);
      return false;
    }
    boolean bool = new File(paramString).exists();
    AppMethodBeat.o(84156);
    return bool;
  }
  
  public static boolean isWatermarkEditable(VideoMaterial paramVideoMaterial)
  {
    AppMethodBeat.i(84175);
    if (paramVideoMaterial != null)
    {
      paramVideoMaterial = paramVideoMaterial.getItemList();
      if (paramVideoMaterial != null)
      {
        Object localObject;
        do
        {
          paramVideoMaterial = paramVideoMaterial.iterator();
          while (!((Iterator)localObject).hasNext())
          {
            do
            {
              if (!paramVideoMaterial.hasNext()) {
                break;
              }
              localObject = (StickerItem)paramVideoMaterial.next();
            } while (((StickerItem)localObject).wmGroup == null);
            localObject = ((StickerItem)localObject).wmGroup.wmElements.iterator();
          }
        } while (((WMElement)((Iterator)localObject).next()).edittype != 1);
        AppMethodBeat.o(84175);
        return true;
      }
    }
    AppMethodBeat.o(84175);
    return false;
  }
  
  public static boolean isWatermarkMaterial(VideoMaterial paramVideoMaterial)
  {
    AppMethodBeat.i(84174);
    if (paramVideoMaterial != null)
    {
      paramVideoMaterial = paramVideoMaterial.getItemList();
      if (paramVideoMaterial != null)
      {
        paramVideoMaterial = paramVideoMaterial.iterator();
        while (paramVideoMaterial.hasNext()) {
          if (((StickerItem)paramVideoMaterial.next()).stickerType == VideoFilterFactory.STICKER_TYPE.WATERMARK.type)
          {
            AppMethodBeat.o(84174);
            return true;
          }
        }
      }
    }
    AppMethodBeat.o(84174);
    return false;
  }
  
  public static float[] listToArray(List<Float> paramList)
  {
    AppMethodBeat.i(84154);
    if (paramList == null)
    {
      AppMethodBeat.o(84154);
      return new float[0];
    }
    float[] arrayOfFloat = new float[paramList.size()];
    int i = 0;
    while (i < paramList.size())
    {
      arrayOfFloat[i] = ((Float)paramList.get(i)).floatValue();
      i += 1;
    }
    AppMethodBeat.o(84154);
    return arrayOfFloat;
  }
  
  public static int[][] listToIntArray(List<PointF> paramList)
  {
    AppMethodBeat.i(84207);
    if (paramList == null)
    {
      AppMethodBeat.o(84207);
      return new int[0][];
    }
    int i = paramList.size();
    int[][] arrayOfInt = (int[][])Array.newInstance(Integer.TYPE, new int[] { i, 2 });
    i = 0;
    while (i < paramList.size())
    {
      arrayOfInt[i][0] = ((int)((PointF)paramList.get(i)).x);
      arrayOfInt[i][1] = ((int)((PointF)paramList.get(i)).y);
      i += 1;
    }
    AppMethodBeat.o(84207);
    return arrayOfInt;
  }
  
  public static String loadFragmentShader(String paramString)
  {
    AppMethodBeat.i(84141);
    String str2 = FileUtils.load(VideoGlobalContext.getContext(), paramString, "fragment_android.glsl");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = FileUtils.load(VideoGlobalContext.getContext(), paramString, "fragment.glsl");
    }
    AppMethodBeat.o(84141);
    return str1;
  }
  
  public static List<VideoMaterialMetaData> loadLocalMaterials()
  {
    AppMethodBeat.i(84167);
    Object localObject = VideoLocalDataInitializer.buildVideoMaterials();
    if (localObject == null)
    {
      localObject = new ArrayList();
      AppMethodBeat.o(84167);
      return localObject;
    }
    Iterator localIterator = ((List)localObject).iterator();
    while (localIterator.hasNext())
    {
      VideoMaterialMetaData localVideoMaterialMetaData = (VideoMaterialMetaData)localIterator.next();
      if (TextUtils.isEmpty(localVideoMaterialMetaData.path)) {
        localVideoMaterialMetaData.path = VideoPrefsUtil.getDefaultPrefs().getString(localVideoMaterialMetaData.id, "");
      }
    }
    AppMethodBeat.o(84167);
    return localObject;
  }
  
  public static String loadVertexShader(String paramString)
  {
    AppMethodBeat.i(84140);
    String str2 = FileUtils.load(VideoGlobalContext.getContext(), paramString, "vertex_android.glsl");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = FileUtils.load(VideoGlobalContext.getContext(), paramString, "vertex.glsl");
    }
    AppMethodBeat.o(84140);
    return str1;
  }
  
  public static String loadVideoCustomEffectFilterFragmentShader(String paramString)
  {
    AppMethodBeat.i(84143);
    String str2 = FileUtils.load(VideoGlobalContext.getContext(), paramString, "filterFragment_android.glsl");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = FileUtils.load(VideoGlobalContext.getContext(), paramString, "filterFragment.glsl");
    }
    AppMethodBeat.o(84143);
    return str1;
  }
  
  public static String loadVideoCustomEffectFilterVertexShader(String paramString)
  {
    AppMethodBeat.i(84142);
    String str2 = FileUtils.load(VideoGlobalContext.getContext(), paramString, "filterVertex_android.glsl");
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = FileUtils.load(VideoGlobalContext.getContext(), paramString, "filterVertex.glsl");
    }
    AppMethodBeat.o(84142);
    return str1;
  }
  
  public static List<PointF> makeFacePoints(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(84145);
    ArrayList localArrayList = new ArrayList(90);
    int j = Math.min(paramArrayOfFloat.length / 2, 90);
    int i = 0;
    while (i < j)
    {
      localArrayList.add(new PointF(paramArrayOfFloat[(i * 2)], paramArrayOfFloat[(i * 2 + 1)]));
      i += 1;
    }
    AppMethodBeat.o(84145);
    return localArrayList;
  }
  
  public static boolean needCopyTransform()
  {
    AppMethodBeat.i(84161);
    String str1 = DeviceInstance.getInstance().getDeviceName().trim();
    if (!TextUtils.isEmpty(str1))
    {
      String[] arrayOfString = DEVICE_NEED_COPY_TRANSFORM;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str2 = arrayOfString[i];
        if (str1.toLowerCase().endsWith(str2.toLowerCase()))
        {
          AppMethodBeat.o(84161);
          return true;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(84161);
    return false;
  }
  
  public static boolean needDetectFace(VideoMaterial paramVideoMaterial)
  {
    AppMethodBeat.i(84187);
    if ((paramVideoMaterial != null) && (paramVideoMaterial.getTriggerType() != 0) && (paramVideoMaterial.getTriggerType() != 1))
    {
      AppMethodBeat.o(84187);
      return true;
    }
    AppMethodBeat.o(84187);
    return false;
  }
  
  public static boolean needFaceTips(VideoMaterial paramVideoMaterial)
  {
    AppMethodBeat.i(84203);
    if (paramVideoMaterial == null)
    {
      AppMethodBeat.o(84203);
      return false;
    }
    paramVideoMaterial = paramVideoMaterial.getItemList();
    if (paramVideoMaterial == null)
    {
      AppMethodBeat.o(84203);
      return false;
    }
    paramVideoMaterial = paramVideoMaterial.iterator();
    while (paramVideoMaterial.hasNext()) {
      if (((StickerItem)paramVideoMaterial.next()).triggerType >= 2)
      {
        AppMethodBeat.o(84203);
        return true;
      }
    }
    AppMethodBeat.o(84203);
    return false;
  }
  
  public static boolean needOpenRefine(VideoMaterial paramVideoMaterial)
  {
    AppMethodBeat.i(84183);
    if ((paramVideoMaterial != null) && ((paramVideoMaterial.getDetectorFlag() == 1) || ((paramVideoMaterial.getDetectorFlag() == 2) && (VideoModule.getDeviceType() == VideoModule.DeviceType.HIGH))))
    {
      AppMethodBeat.o(84183);
      return true;
    }
    AppMethodBeat.o(84183);
    return false;
  }
  
  public static boolean needSmallSize()
  {
    AppMethodBeat.i(84162);
    String str1 = DeviceInstance.getInstance().getDeviceName().trim();
    if (!TextUtils.isEmpty(str1))
    {
      String[] arrayOfString = DEVICE_NEED_SMALL_SIZE;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str2 = arrayOfString[i];
        if (str1.toLowerCase().endsWith(str2.toLowerCase()))
        {
          AppMethodBeat.o(84162);
          return true;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(84162);
    return false;
  }
  
  public static boolean needVoiceChange(VideoMaterial paramVideoMaterial)
  {
    AppMethodBeat.i(84184);
    if ((paramVideoMaterial != null) && (paramVideoMaterial.getVoicekind() != -999999) && (paramVideoMaterial.getEnvironment() != -999999))
    {
      AppMethodBeat.o(84184);
      return true;
    }
    AppMethodBeat.o(84184);
    return false;
  }
  
  public static void saveVideoMaterialToImages(String paramString)
  {
    AppMethodBeat.i(84170);
    String str = getMaterialId(paramString);
    if ((str == null) || (!str.startsWith("video_")))
    {
      AppMethodBeat.o(84170);
      return;
    }
    paramString = new File(paramString).listFiles();
    if (paramString == null)
    {
      AppMethodBeat.o(84170);
      return;
    }
    int n = paramString.length;
    int i = 0;
    while (i < n)
    {
      str = paramString[i];
      if (str.isDirectory())
      {
        File[] arrayOfFile = str.listFiles(new VideoMaterialUtil.2());
        if (arrayOfFile != null)
        {
          int i1 = arrayOfFile.length;
          int j = 0;
          for (;;)
          {
            if (j < i1)
            {
              Object localObject = arrayOfFile[j];
              try
              {
                FileUtils.deleteFiles(str.getAbsolutePath(), ".png");
                localObject = getVideoIndexMap(((File)localObject).getAbsolutePath());
                ArrayList localArrayList = new ArrayList();
                int k = 0;
                for (;;)
                {
                  localArrayList.clear();
                  int m = 0;
                  while (m < localObject.length)
                  {
                    if (localObject[m] == k) {
                      localArrayList.add(str.getAbsolutePath() + File.separator + getMaterialId(str.getAbsolutePath()) + "_" + m + ".png");
                    }
                    m += 1;
                  }
                  k += 1;
                }
              }
              catch (Exception localException)
              {
                i.n(TAG, localException.toString());
                j += 1;
              }
            }
          }
        }
      }
      i += 1;
    }
    AppMethodBeat.o(84170);
  }
  
  public static void sort(List<StickerItem> paramList)
  {
    AppMethodBeat.i(84163);
    if (BaseUtils.isEmpty(paramList))
    {
      AppMethodBeat.o(84163);
      return;
    }
    Collections.sort(paramList, new VideoMaterialUtil.1());
    AppMethodBeat.o(84163);
  }
  
  public static boolean supportLandscape(VideoMaterial paramVideoMaterial)
  {
    AppMethodBeat.i(84188);
    if ((paramVideoMaterial != null) && (paramVideoMaterial.isSupportLandscape()))
    {
      AppMethodBeat.o(84188);
      return true;
    }
    AppMethodBeat.o(84188);
    return false;
  }
  
  public static float[] toFlatArray(List<PointF> paramList)
  {
    AppMethodBeat.i(84155);
    if (paramList == null)
    {
      AppMethodBeat.o(84155);
      return new float[0];
    }
    float[] arrayOfFloat = new float[paramList.size() * 2];
    int i = 0;
    while (i < paramList.size())
    {
      PointF localPointF = (PointF)paramList.get(i);
      if (localPointF != null)
      {
        arrayOfFloat[(i * 2)] = localPointF.x;
        arrayOfFloat[(i * 2 + 1)] = localPointF.y;
      }
      i += 1;
    }
    AppMethodBeat.o(84155);
    return arrayOfFloat;
  }
  
  public static float[] toFlatArray(PointF[] paramArrayOfPointF)
  {
    Object localObject;
    if (paramArrayOfPointF == null) {
      localObject = new float[0];
    }
    for (;;)
    {
      return localObject;
      try
      {
        float[] arrayOfFloat = new float[paramArrayOfPointF.length * 2];
        int i = 0;
        for (;;)
        {
          localObject = arrayOfFloat;
          if (i >= paramArrayOfPointF.length) {
            break;
          }
          if (paramArrayOfPointF[i] != null)
          {
            arrayOfFloat[(i * 2)] = paramArrayOfPointF[i].x;
            arrayOfFloat[(i * 2 + 1)] = paramArrayOfPointF[i].y;
          }
          i += 1;
        }
        return new float[0];
      }
      catch (OutOfMemoryError paramArrayOfPointF) {}
    }
  }
  
  public static void updateFaceValueDetectType(VideoMaterial paramVideoMaterial)
  {
    AppMethodBeat.i(84192);
    if ((paramVideoMaterial == null) || (paramVideoMaterial.getItemList() == null))
    {
      AppMethodBeat.o(84192);
      return;
    }
    Iterator localIterator = paramVideoMaterial.getItemList().iterator();
    StickerItem localStickerItem;
    for (int j = 0; localIterator.hasNext(); j = localStickerItem.markMode | j)
    {
      localStickerItem = (StickerItem)localIterator.next();
      int i = j;
      if (localStickerItem.ageRange != null) {
        i = j | 0x1;
      }
      j = i;
      if (localStickerItem.genderRange != null) {
        j = i | 0x2;
      }
      i = j;
      if (localStickerItem.popularRange != null) {
        i = j | 0x4;
      }
      j = i;
      if (localStickerItem.cpRange != null) {
        j = i | 0x8;
      }
    }
    paramVideoMaterial.setFaceValueDetectType(j);
    AppMethodBeat.o(84192);
  }
  
  public static void updateItemImageType(VideoMaterial paramVideoMaterial)
  {
    AppMethodBeat.i(84193);
    if (paramVideoMaterial == null)
    {
      AppMethodBeat.o(84193);
      return;
    }
    Object localObject1 = new ArrayList();
    if (paramVideoMaterial.getItemList() != null) {
      ((List)localObject1).addAll(paramVideoMaterial.getItemList());
    }
    Object localObject2;
    Object localObject3;
    if (paramVideoMaterial.getFaceFeatureItemList() != null)
    {
      localObject2 = paramVideoMaterial.getFaceFeatureItemList().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (FaceFeatureItem)((Iterator)localObject2).next();
        if ((localObject3 != null) && (((FaceFeatureItem)localObject3).getFaceOffItemList() != null)) {
          ((List)localObject1).addAll(((FaceFeatureItem)localObject3).getStickerItems());
        }
      }
    }
    if (paramVideoMaterial.getHeadCropItemList() != null) {
      ((List)localObject1).addAll(paramVideoMaterial.getHeadCropItemList());
    }
    if (paramVideoMaterial.getFabbyParts() != null)
    {
      localObject2 = paramVideoMaterial.getFabbyParts().getParts().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (FabbyMvPart)((Iterator)localObject2).next();
        if (((FabbyMvPart)localObject3).bgItem != null) {
          ((List)localObject1).add(((FabbyMvPart)localObject3).bgItem);
        }
        if (((FabbyMvPart)localObject3).fgItem != null) {
          ((List)localObject1).add(((FabbyMvPart)localObject3).fgItem);
        }
        if (((FabbyMvPart)localObject3).coverItem != null) {
          ((List)localObject1).add(((FabbyMvPart)localObject3).coverItem);
        }
        if (((FabbyMvPart)localObject3).transitionItem != null) {
          ((List)localObject1).add(((FabbyMvPart)localObject3).transitionItem);
        }
      }
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (StickerItem)((Iterator)localObject1).next();
      if (((StickerItem)localObject2).sourceType == null) {
        ((StickerItem)localObject2).sourceType = VideoMaterialUtil.ITEM_SOURCE_TYPE.IMAGE;
      }
    }
    paramVideoMaterial = paramVideoMaterial.getItemList3D();
    if (paramVideoMaterial != null)
    {
      paramVideoMaterial = paramVideoMaterial.iterator();
      while (paramVideoMaterial.hasNext())
      {
        localObject1 = (StickerItem)paramVideoMaterial.next();
        if (((StickerItem)localObject1).sourceType == null) {
          ((StickerItem)localObject1).sourceType = VideoMaterialUtil.ITEM_SOURCE_TYPE.IMAGE;
        }
      }
    }
    AppMethodBeat.o(84193);
  }
  
  public static void updateMaxFaceCount(VideoMaterial paramVideoMaterial)
  {
    AppMethodBeat.i(84191);
    if (paramVideoMaterial == null)
    {
      AppMethodBeat.o(84191);
      return;
    }
    if (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.FACE_CROP.value) {
      paramVideoMaterial.setMaxFaceCount(1);
    }
    AppMethodBeat.o(84191);
  }
  
  public static void updateNeedBodyInfo(VideoMaterial paramVideoMaterial)
  {
    AppMethodBeat.i(84196);
    if (paramVideoMaterial == null)
    {
      AppMethodBeat.o(84196);
      return;
    }
    if (paramVideoMaterial.getItemList() != null)
    {
      Iterator localIterator = paramVideoMaterial.getItemList().iterator();
      while (localIterator.hasNext())
      {
        StickerItem localStickerItem = (StickerItem)localIterator.next();
        if (localStickerItem.type == VideoFilterFactory.POSITION_TYPE.BODY.type)
        {
          paramVideoMaterial.setNeedBodyInfo(true);
          AppMethodBeat.o(84196);
          return;
        }
        if (isBodyTriggerType(localStickerItem.triggerType))
        {
          paramVideoMaterial.setNeedBodyInfo(true);
          AppMethodBeat.o(84196);
          return;
        }
      }
    }
    paramVideoMaterial.setNeedBodyInfo(false);
    AppMethodBeat.o(84196);
  }
  
  public static void updateNeedFaceInfo(VideoMaterial paramVideoMaterial)
  {
    AppMethodBeat.i(84195);
    if (paramVideoMaterial == null)
    {
      AppMethodBeat.o(84195);
      return;
    }
    if ((paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.CUSTOM_BEFORE_COMMON.value) || (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.SNAKE_FACE_BEFORE_COMMON.value) || (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.FACE_OFF.value) || (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.TRANSFORM.value) || (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.FACE_SWITCH.value) || (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.FACE_OFF_TRANSFORM.value) || (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.THREE_DIM.value) || (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.FACE_SWITCH_DUP.value) || (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.FACE_COPY.value) || (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.FACE_MORPHING.value) || (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.FACE_HEAD_CROP.value) || (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.FACE_CROP.value) || (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.MAI_MENG.value) || (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.GAMEPLAY_3D.value))
    {
      paramVideoMaterial.setNeedFaceInfo(true);
      AppMethodBeat.o(84195);
      return;
    }
    if (paramVideoMaterial.getItemList() != null)
    {
      Iterator localIterator = paramVideoMaterial.getItemList().iterator();
      while (localIterator.hasNext())
      {
        StickerItem localStickerItem = (StickerItem)localIterator.next();
        if ((localStickerItem.type == VideoFilterFactory.POSITION_TYPE.STATIC.type) || (localStickerItem.type == VideoFilterFactory.POSITION_TYPE.DYNAMIC.type))
        {
          paramVideoMaterial.setNeedFaceInfo(true);
          AppMethodBeat.o(84195);
          return;
        }
        if (isFaceTriggerType(localStickerItem.triggerType))
        {
          paramVideoMaterial.setNeedFaceInfo(true);
          AppMethodBeat.o(84195);
          return;
        }
      }
    }
    paramVideoMaterial.setNeedFaceInfo(false);
    AppMethodBeat.o(84195);
  }
  
  public static void updatePointList(List<PointF> paramList1, List<PointF> paramList2)
  {
    AppMethodBeat.i(84159);
    if (paramList2 == null)
    {
      AppMethodBeat.o(84159);
      return;
    }
    Object localObject = paramList1;
    if (paramList1 == null) {
      localObject = new ArrayList();
    }
    int j = paramList2.size();
    while (((List)localObject).size() > j) {
      ((List)localObject).remove(((List)localObject).size() - 1);
    }
    while (((List)localObject).size() < j) {
      ((List)localObject).add(new PointF());
    }
    int i = 0;
    while (i < j)
    {
      ((PointF)((List)localObject).get(i)).x = ((PointF)paramList2.get(i)).x;
      ((PointF)((List)localObject).get(i)).y = ((PointF)paramList2.get(i)).y;
      i += 1;
    }
    AppMethodBeat.o(84159);
  }
  
  public static void updatePointListOfList(List<List<PointF>> paramList1, List<List<PointF>> paramList2)
  {
    AppMethodBeat.i(84160);
    if (paramList2 == null)
    {
      AppMethodBeat.o(84160);
      return;
    }
    Object localObject = paramList1;
    if (paramList1 == null) {
      localObject = new ArrayList();
    }
    int j = paramList2.size();
    while (((List)localObject).size() > j) {
      ((List)localObject).remove(((List)localObject).size() - 1);
    }
    while (((List)localObject).size() < j) {
      ((List)localObject).add(new ArrayList());
    }
    int i = 0;
    while (i < j)
    {
      updatePointList((List)((List)localObject).get(i), (List)paramList2.get(i));
      i += 1;
    }
    AppMethodBeat.o(84160);
  }
  
  public static void updateSupportLandscape(VideoMaterial paramVideoMaterial)
  {
    AppMethodBeat.i(84190);
    if (paramVideoMaterial == null)
    {
      AppMethodBeat.o(84190);
      return;
    }
    if ((paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.MAI_MENG.value) || (paramVideoMaterial.getShaderType() == VideoMaterialUtil.SHADER_TYPE.FACE_CROP.value) || (isFaceMorphingMaterial(paramVideoMaterial))) {
      paramVideoMaterial.setSupportLandscape(false);
    }
    AppMethodBeat.o(84190);
  }
  
  public static void updateWatermarkInfo(VideoMaterial paramVideoMaterial)
  {
    AppMethodBeat.i(84194);
    if ((paramVideoMaterial == null) || (paramVideoMaterial.getItemList() == null))
    {
      AppMethodBeat.o(84194);
      return;
    }
    paramVideoMaterial = paramVideoMaterial.getItemList().iterator();
    while (paramVideoMaterial.hasNext())
    {
      StickerItem localStickerItem = (StickerItem)paramVideoMaterial.next();
      if (localStickerItem.wmGroup != null)
      {
        localStickerItem.wmGroup.setItemId(localStickerItem.id);
        localStickerItem.wmGroup.setSize(localStickerItem.width, localStickerItem.height);
      }
      if (localStickerItem.wmGroupCopies != null)
      {
        Iterator localIterator = localStickerItem.wmGroupCopies.iterator();
        while (localIterator.hasNext())
        {
          WMGroup localWMGroup = (WMGroup)localIterator.next();
          localWMGroup.setItemId(localStickerItem.id);
          localWMGroup.setSize(localStickerItem.width, localStickerItem.height);
        }
      }
    }
    AppMethodBeat.o(84194);
  }
  
  public static enum AR_MATERIAL_TYPE
  {
    public int value;
    
    static
    {
      AppMethodBeat.i(84056);
      NORMAL = new AR_MATERIAL_TYPE("NORMAL", 0, 1);
      CLICKABLE = new AR_MATERIAL_TYPE("CLICKABLE", 1, 2);
      $VALUES = new AR_MATERIAL_TYPE[] { NORMAL, CLICKABLE };
      AppMethodBeat.o(84056);
    }
    
    private AR_MATERIAL_TYPE(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  public static enum EXPRESSION_TYPE
  {
    public final int value;
    
    static
    {
      AppMethodBeat.i(84077);
      JUMP_EYE_BROW = new EXPRESSION_TYPE("JUMP_EYE_BROW", 0, 4);
      WINK = new EXPRESSION_TYPE("WINK", 1, 5);
      SHOOK_HEAD = new EXPRESSION_TYPE("SHOOK_HEAD", 2, 6);
      RIGHT_EYE_WINK = new EXPRESSION_TYPE("RIGHT_EYE_WINK", 3, 8);
      LEFT_EYE_WINK = new EXPRESSION_TYPE("LEFT_EYE_WINK", 4, 9);
      NOD = new EXPRESSION_TYPE("NOD", 5, 10);
      SHAKE_HEAD = new EXPRESSION_TYPE("SHAKE_HEAD", 6, 11);
      $VALUES = new EXPRESSION_TYPE[] { JUMP_EYE_BROW, WINK, SHOOK_HEAD, RIGHT_EYE_WINK, LEFT_EYE_WINK, NOD, SHAKE_HEAD };
      AppMethodBeat.o(84077);
    }
    
    private EXPRESSION_TYPE(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  public static enum FIELD
  {
    public final String value;
    
    static
    {
      AppMethodBeat.i(84104);
      MIN_APP_VERSION = new FIELD("MIN_APP_VERSION", 0, "minAppVersion");
      CATEGORY_FLAG = new FIELD("CATEGORY_FLAG", 1, "categoryFlag");
      SHADER_TYPE = new FIELD("SHADER_TYPE", 2, "shaderType");
      FACE_OFF_TYPE = new FIELD("FACE_OFF_TYPE", 3, "faceOffType");
      RESET_WHEN_START_RECORD = new FIELD("RESET_WHEN_START_RECORD", 4, "resetWhenStartRecord");
      SUPPORT_PAUSE = new FIELD("SUPPORT_PAUSE", 5, "supportPause");
      MAX_FACE_COUNT = new FIELD("MAX_FACE_COUNT", 6, "maxFaceCount");
      VOICE_KIND = new FIELD("VOICE_KIND", 7, "voicekind");
      ENVIRONMENT = new FIELD("ENVIRONMENT", 8, "environment");
      RESOURCE_LIST = new FIELD("RESOURCE_LIST", 9, "resourceList");
      ITEM_LIST = new FIELD("ITEM_LIST", 10, "itemList");
      FACE_EXCHANGE_IMAGE = new FIELD("FACE_EXCHANGE_IMAGE", 11, "faceExchangeImage");
      IMAGE_FACE_POINTS_FILE_NAME = new FIELD("IMAGE_FACE_POINTS_FILE_NAME", 12, "imageFacePointsFileName");
      BLEND_ALPHA = new FIELD("BLEND_ALPHA", 13, "blendAlpha");
      DISTORTION_LIST = new FIELD("DISTORTION_LIST", 14, "distortionList");
      FACE_POINTS_LIST = new FIELD("FACE_POINTS_LIST", 15, "facePoints");
      GRAY_SCALE = new FIELD("GRAY_SCALE", 16, "grayScale");
      FEATURE_TYPE = new FIELD("FEATURE_TYPE", 17, "featureType");
      FACE_MOVE_LIST = new FIELD("FACE_MOVE_LIST", 18, "faceMoveList");
      FACE_MOVE_TRIANGLE = new FIELD("FACE_MOVE_TRIANGLE", 19, "faceMoveTriangle");
      BLEND_MODE = new FIELD("BLEND_MODE", 20, "blendMode");
      ORDER_MODE = new FIELD("ORDER_MODE", 21, "orderMode");
      FACE_SWAP_TYPE = new FIELD("FACE_SWAP_TYPE", 22, "faceSwapType");
      FILTER_ID = new FIELD("FILTER_ID", 23, "filterId");
      FILTER_BLUR_STRENGTH = new FIELD("FILTER_BLUR_STRENGTH", 24, "filterBlurStrength");
      FILTER_EFFECT = new FIELD("FILTER_EFFECT", 25, "filterEffect");
      CHARM_RANGE = new FIELD("CHARM_RANGE", 26, "charmRange");
      FACE_MESH_ITEM_LIST = new FIELD("FACE_MESH_ITEM_LIST", 27, "faceMeshItemList");
      FACE_OFF_ITEM_LIST = new FIELD("FACE_OFF_ITEM_LIST", 28, "faceOffItemList");
      AR_PARTICLE_TYPE = new FIELD("AR_PARTICLE_TYPE", 29, "arParticleType");
      AR_PARTICLE_LIST = new FIELD("AR_PARTICLE_LIST", 30, "arParticleList");
      SUPPORT_LANDSCAPE = new FIELD("SUPPORT_LANDSCAPE", 31, "supportLandscape");
      RANDOM_GROUP_COUNT = new FIELD("RANDOM_GROUP_COUNT", 32, "randomGroupCount");
      FACE_EXPRESSION = new FIELD("FACE_EXPRESSION", 33, "faceExpression");
      TIPS_TEXT = new FIELD("TIPS_TEXT", 34, "tipsText");
      TIPS_ICON = new FIELD("TIPS_ICON", 35, "tipsIcon");
      FACE_CROP = new FIELD("FACE_CROP", 36, "videoFaceCrop");
      USE_MESH = new FIELD("USE_MESH", 37, "useMesh");
      FACE_HEAD_CROP_ITEM_LIST = new FIELD("FACE_HEAD_CROP_ITEM_LIST", 38, "headCropItemList");
      WATERMARK_GROUP = new FIELD("WATERMARK_GROUP", 39, "watermarkGroup");
      AD_ICON = new FIELD("AD_ICON", 40, "adIcon");
      AD_LINK = new FIELD("AD_LINK", 41, "adH5Link");
      AD_APP_LINK = new FIELD("AD_APP_LINK", 42, "adAppLink");
      DETECTOR_FLAG = new FIELD("DETECTOR_FLAG", 43, "detectorFlag");
      VIDEO_ALPHA_TYPE = new FIELD("VIDEO_ALPHA_TYPE", 44, "videoAlphaType");
      LIPS_LUT = new FIELD("LIPS_LUT", 45, "lipsLut");
      SPLIT_SCREEN = new FIELD("SPLIT_SCREEN", 46, "splitScreen");
      MULTI_VIEWER = new FIELD("MULTI_VIEWER", 47, "multiViewer");
      HAND_BOOST_ENABLE = new FIELD("HAND_BOOST_ENABLE", 48, "handBoostEnable");
      $VALUES = new FIELD[] { MIN_APP_VERSION, CATEGORY_FLAG, SHADER_TYPE, FACE_OFF_TYPE, RESET_WHEN_START_RECORD, SUPPORT_PAUSE, MAX_FACE_COUNT, VOICE_KIND, ENVIRONMENT, RESOURCE_LIST, ITEM_LIST, FACE_EXCHANGE_IMAGE, IMAGE_FACE_POINTS_FILE_NAME, BLEND_ALPHA, DISTORTION_LIST, FACE_POINTS_LIST, GRAY_SCALE, FEATURE_TYPE, FACE_MOVE_LIST, FACE_MOVE_TRIANGLE, BLEND_MODE, ORDER_MODE, FACE_SWAP_TYPE, FILTER_ID, FILTER_BLUR_STRENGTH, FILTER_EFFECT, CHARM_RANGE, FACE_MESH_ITEM_LIST, FACE_OFF_ITEM_LIST, AR_PARTICLE_TYPE, AR_PARTICLE_LIST, SUPPORT_LANDSCAPE, RANDOM_GROUP_COUNT, FACE_EXPRESSION, TIPS_TEXT, TIPS_ICON, FACE_CROP, USE_MESH, FACE_HEAD_CROP_ITEM_LIST, WATERMARK_GROUP, AD_ICON, AD_LINK, AD_APP_LINK, DETECTOR_FLAG, VIDEO_ALPHA_TYPE, LIPS_LUT, SPLIT_SCREEN, MULTI_VIEWER, HAND_BOOST_ENABLE };
      AppMethodBeat.o(84104);
    }
    
    private FIELD(String paramString)
    {
      this.value = paramString;
    }
  }
  
  public static enum VOICEKIND
  {
    public final int value;
    
    static
    {
      AppMethodBeat.i(84131);
      BYPASS = new VOICEKIND("BYPASS", 0, -1);
      CAT = new VOICEKIND("CAT", 1, 1);
      MAN = new VOICEKIND("MAN", 2, 2);
      GIRL = new VOICEKIND("GIRL", 3, 4);
      UNCLE = new VOICEKIND("UNCLE", 4, 5);
      BOY = new VOICEKIND("BOY", 5, 6);
      FAST = new VOICEKIND("FAST", 6, 7);
      SLOWLY = new VOICEKIND("SLOWLY", 7, 8);
      WOMAN = new VOICEKIND("WOMAN", 8, 9);
      ELECTRONIC = new VOICEKIND("ELECTRONIC", 9, 10);
      ELEVEN = new VOICEKIND("ELEVEN", 10, 11);
      TWELVE = new VOICEKIND("TWELVE", 11, 12);
      THIRTEEN = new VOICEKIND("THIRTEEN", 12, 13);
      BIG = new VOICEKIND("BIG", 13, 536936433);
      $VALUES = new VOICEKIND[] { BYPASS, CAT, MAN, GIRL, UNCLE, BOY, FAST, SLOWLY, WOMAN, ELECTRONIC, ELEVEN, TWELVE, THIRTEEN, BIG };
      AppMethodBeat.o(84131);
    }
    
    private VOICEKIND(int paramInt)
    {
      this.value = paramInt;
    }
  }
  
  public static enum WATERMARK_ELEMENT
  {
    public String value;
    
    static
    {
      AppMethodBeat.i(84134);
      ID = new WATERMARK_ELEMENT("ID", 0, "id");
      RELATIVE_ID = new WATERMARK_ELEMENT("RELATIVE_ID", 1, "relativeID");
      RELATIVE_ANCHOR = new WATERMARK_ELEMENT("RELATIVE_ANCHOR", 2, "relativeAnchor");
      ANCHOR = new WATERMARK_ELEMENT("ANCHOR", 3, "anchor");
      OFFSETX = new WATERMARK_ELEMENT("OFFSETX", 4, "offsetX");
      OFFSETY = new WATERMARK_ELEMENT("OFFSETY", 5, "offsetY");
      WIDTH = new WATERMARK_ELEMENT("WIDTH", 6, "width");
      HEIGHT = new WATERMARK_ELEMENT("HEIGHT", 7, "height");
      WMTYPE = new WATERMARK_ELEMENT("WMTYPE", 8, "wmtype");
      EDITTYPE = new WATERMARK_ELEMENT("EDITTYPE", 9, "editType");
      FMTSTR = new WATERMARK_ELEMENT("FMTSTR", 10, "fmtstr");
      FONT_NAME = new WATERMARK_ELEMENT("FONT_NAME", 11, "fontName");
      FONT_BOLD = new WATERMARK_ELEMENT("FONT_BOLD", 12, "fontBold");
      FONT_ITALICS = new WATERMARK_ELEMENT("FONT_ITALICS", 13, "fontItalics");
      FONT_TEXTURE = new WATERMARK_ELEMENT("FONT_TEXTURE", 14, "fontTexture");
      FONT_SIZE = new WATERMARK_ELEMENT("FONT_SIZE", 15, "fontSize");
      FONT_FIT = new WATERMARK_ELEMENT("FONT_FIT", 16, "fontFit");
      KERN = new WATERMARK_ELEMENT("KERN", 17, "kern");
      IMG_PATH = new WATERMARK_ELEMENT("IMG_PATH", 18, "imgPath");
      FRAME_DURATION = new WATERMARK_ELEMENT("FRAME_DURATION", 19, "frameDuration");
      FRAMES = new WATERMARK_ELEMENT("FRAMES", 20, "frames");
      COLOR = new WATERMARK_ELEMENT("COLOR", 21, "color");
      STROKE_COLOR = new WATERMARK_ELEMENT("STROKE_COLOR", 22, "strokeColor");
      STROKE_SIZE = new WATERMARK_ELEMENT("STROKE_SIZE", 23, "strokeSize");
      SHADOW_COLOR = new WATERMARK_ELEMENT("SHADOW_COLOR", 24, "shadowColor");
      SHADOW_SIZE = new WATERMARK_ELEMENT("SHADOW_SIZE", 25, "shadowSize");
      SHADOW_DX = new WATERMARK_ELEMENT("SHADOW_DX", 26, "shadowDx");
      SHADOW_DY = new WATERMARK_ELEMENT("SHADOW_DY", 27, "shadowDy");
      ALIGNMENT = new WATERMARK_ELEMENT("ALIGNMENT", 28, "alignment");
      VERTICAL = new WATERMARK_ELEMENT("VERTICAL", 29, "vertical");
      OUTER_STROKE_COLOR = new WATERMARK_ELEMENT("OUTER_STROKE_COLOR", 30, "outerStrokeColor");
      OUTER_STROKE_SIZE = new WATERMARK_ELEMENT("OUTER_STROKE_SIZE", 31, "outerStrokeSize");
      SHADER_BMP = new WATERMARK_ELEMENT("SHADER_BMP", 32, "shaderBmp");
      EMBOSS = new WATERMARK_ELEMENT("EMBOSS", 33, "emboss");
      MULTI_ROW = new WATERMARK_ELEMENT("MULTI_ROW", 34, "multiRow");
      ROTATE = new WATERMARK_ELEMENT("ROTATE", 35, "rotate");
      ANIMATE_TYPE = new WATERMARK_ELEMENT("ANIMATE_TYPE", 36, "animateType");
      LOGIC = new WATERMARK_ELEMENT("LOGIC", 37, "logic");
      $VALUES = new WATERMARK_ELEMENT[] { ID, RELATIVE_ID, RELATIVE_ANCHOR, ANCHOR, OFFSETX, OFFSETY, WIDTH, HEIGHT, WMTYPE, EDITTYPE, FMTSTR, FONT_NAME, FONT_BOLD, FONT_ITALICS, FONT_TEXTURE, FONT_SIZE, FONT_FIT, KERN, IMG_PATH, FRAME_DURATION, FRAMES, COLOR, STROKE_COLOR, STROKE_SIZE, SHADOW_COLOR, SHADOW_SIZE, SHADOW_DX, SHADOW_DY, ALIGNMENT, VERTICAL, OUTER_STROKE_COLOR, OUTER_STROKE_SIZE, SHADER_BMP, EMBOSS, MULTI_ROW, ROTATE, ANIMATE_TYPE, LOGIC };
      AppMethodBeat.o(84134);
    }
    
    private WATERMARK_ELEMENT(String paramString)
    {
      this.value = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.ttpic.util.VideoMaterialUtil
 * JD-Core Version:    0.7.0.1
 */
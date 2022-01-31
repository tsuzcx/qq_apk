package com.tencent.ttpic.manager;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.LogUtils;
import com.tencent.ttpic.fabby.FabbyManager;
import com.tencent.ttpic.util.ResourcePathMapper;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.ttpic.util.youtu.GestureDetector;
import java.io.FileInputStream;
import java.io.InputStream;

public class FeatureManager
{
  public static final int INIT_FAIL = -1;
  public static final int INIT_NOFILE = -2;
  public static final int INIT_SUCC = 1;
  private static final String TAG;
  private static final String[] bodyDetectionResNms;
  private static final String[] filterResNms;
  private static final String[] gameplayResNms;
  private static final String[] gestureDetectionResNms;
  private static boolean isBodyDetectionReady;
  private static boolean isFilterReady;
  private static boolean isGameplayReady;
  private static boolean isGestureDetectionReady;
  private static boolean isLipsLutReady;
  private static boolean isSegmentationReady;
  private static final String[] lipslutResNms;
  private static final String[] segmentationResNms;
  
  static
  {
    AppMethodBeat.i(83432);
    TAG = FeatureManager.class.getSimpleName();
    isSegmentationReady = false;
    isGestureDetectionReady = false;
    isGameplayReady = false;
    isBodyDetectionReady = false;
    isLipsLutReady = false;
    isFilterReady = false;
    segmentationResNms = new String[] { "model5", "so3", "so4" };
    gestureDetectionResNms = new String[] { "model1", "so1", "so2" };
    gameplayResNms = new String[] { "so5" };
    bodyDetectionResNms = new String[] { "model6", "so6", "so7" };
    lipslutResNms = new String[] { "so8" };
    filterResNms = new String[] { "so9" };
    checkFeaturesReady();
    AppMethodBeat.o(83432);
  }
  
  public static void checkFeaturesReady()
  {
    AppMethodBeat.i(83425);
    String[] arrayOfString = segmentationResNms;
    int j = arrayOfString.length;
    int i = 0;
    String str;
    if (i < j)
    {
      str = ResourcePathMapper.getResPath(arrayOfString[i]);
      if ((str == null) || (str.equals(""))) {
        setIsSegmentationReady(false);
      }
    }
    else
    {
      arrayOfString = gestureDetectionResNms;
      j = arrayOfString.length;
      i = 0;
      label52:
      if (i < j)
      {
        str = ResourcePathMapper.getResPath(arrayOfString[i]);
        if ((str != null) && (!str.equals(""))) {
          break label250;
        }
        setIsGestureDetectionReady(false);
      }
      arrayOfString = gameplayResNms;
      j = arrayOfString.length;
      i = 0;
      label90:
      if (i < j)
      {
        str = ResourcePathMapper.getResPath(arrayOfString[i]);
        if ((str != null) && (!str.equals(""))) {
          break label261;
        }
        setIsGameplayReady(false);
      }
      arrayOfString = bodyDetectionResNms;
      j = arrayOfString.length;
      i = 0;
      label128:
      if (i < j)
      {
        str = ResourcePathMapper.getResPath(arrayOfString[i]);
        if ((str != null) && (!str.equals(""))) {
          break label272;
        }
        setIsBodyDetectionReady(false);
      }
      arrayOfString = lipslutResNms;
      j = arrayOfString.length;
      i = 0;
      label166:
      if (i < j)
      {
        str = ResourcePathMapper.getResPath(arrayOfString[i]);
        if ((str != null) && (!str.equals(""))) {
          break label283;
        }
        setisLutLipsReady(false);
      }
      arrayOfString = filterResNms;
      j = arrayOfString.length;
      i = 0;
    }
    for (;;)
    {
      if (i >= j) {
        break label305;
      }
      str = ResourcePathMapper.getResPath(arrayOfString[i]);
      if ((str == null) || (str.equals("")))
      {
        setisFilterReady(false);
        AppMethodBeat.o(83425);
        return;
        setIsSegmentationReady(true);
        i += 1;
        break;
        label250:
        setIsGestureDetectionReady(true);
        i += 1;
        break label52;
        label261:
        setIsGameplayReady(true);
        i += 1;
        break label90;
        label272:
        setIsBodyDetectionReady(true);
        i += 1;
        break label128;
        label283:
        setisLutLipsReady(true);
        i += 1;
        break label166;
      }
      setisFilterReady(true);
      i += 1;
    }
    label305:
    AppMethodBeat.o(83425);
  }
  
  public static InputStream getModelStream(String paramString)
  {
    AppMethodBeat.i(83431);
    String str = ResourcePathMapper.getModelResPath(paramString);
    if (str != null) {}
    try
    {
      if (!str.equals(""))
      {
        if (str.startsWith("assets://"))
        {
          paramString = VideoGlobalContext.getContext().getAssets().open(str.substring(9) + paramString);
          AppMethodBeat.o(83431);
          return paramString;
        }
        paramString = new FileInputStream(str + paramString);
        AppMethodBeat.o(83431);
        return paramString;
      }
      AppMethodBeat.o(83431);
      return null;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(83431);
    }
    return null;
  }
  
  public static int init3DGameplay()
  {
    AppMethodBeat.i(83428);
    try
    {
      loadLibrary("gameplay");
      setIsGameplayReady(true);
      AppMethodBeat.o(83428);
      return 1;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      AppMethodBeat.o(83428);
      return -1;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(83428);
    }
    return -1;
  }
  
  public static int initBodyDetection()
  {
    AppMethodBeat.i(83429);
    try
    {
      new StringBuilder("android.os.Build.VERSION.SDK_INT = ").append(Build.VERSION.SDK_INT);
      if (Build.VERSION.SDK_INT <= 17) {
        System.load("/data/data/com.tencent.xnet/lib/libxnet.so");
      }
      for (;;)
      {
        loadLibrary("bodydetector");
        setIsBodyDetectionReady(true);
        AppMethodBeat.o(83429);
        return 1;
        loadLibrary("xnet");
      }
      return -1;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      AppMethodBeat.o(83429);
      return -1;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(83429);
    }
  }
  
  public static int initGestureDetection()
  {
    AppMethodBeat.i(83426);
    int i = 0;
    String str1 = ResourcePathMapper.getModelResPath("libXGestureSDK.so");
    String str2 = ResourcePathMapper.getModelResPath("libpt_handdetector.so");
    if ((str1 != null) && (!str1.equals("")) && (str2 != null) && (!str2.equals(""))) {}
    try
    {
      loadLibrary("XGestureSDK");
      loadLibrary("pt_handdetector");
      i = 1;
    }
    catch (Exception localException)
    {
      break label57;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      label57:
      break label57;
    }
    if (i == 0)
    {
      AppMethodBeat.o(83426);
      return -1;
      AppMethodBeat.o(83426);
      return -2;
    }
    GestureDetector.getInstance();
    setIsGestureDetectionReady(true);
    AppMethodBeat.o(83426);
    return 1;
  }
  
  public static int initSegmentation()
  {
    AppMethodBeat.i(83427);
    try
    {
      System.loadLibrary("YTCommon");
      System.loadLibrary("nnpack");
      loadLibrary("segmentern");
      i = 1;
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        localException1 = localException1;
        LogUtils.e(localException1);
        try
        {
          loadLibrary("segmentern");
          i = 1;
        }
        catch (Exception localException2)
        {
          i = 0;
        }
      }
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        int i;
        localUnsatisfiedLinkError = localUnsatisfiedLinkError;
        LogUtils.e(localUnsatisfiedLinkError);
        try
        {
          loadLibrary("segmentern");
          i = 1;
        }
        catch (Exception localException3)
        {
          i = 0;
        }
      }
    }
    finally {}
    if (i == 0)
    {
      AppMethodBeat.o(83427);
      return -1;
    }
    try
    {
      loadLibrary("segmentern");
      label81:
      AppMethodBeat.o(83427);
      throw localObject;
      FabbyManager.init();
      setIsSegmentationReady(true);
      AppMethodBeat.o(83427);
      return 1;
    }
    catch (Exception localException4)
    {
      break label81;
    }
  }
  
  public static boolean isBodyDetectionReady()
  {
    return isBodyDetectionReady;
  }
  
  public static boolean isFilterReady()
  {
    return isFilterReady;
  }
  
  public static boolean isGameplayReady()
  {
    return isGameplayReady;
  }
  
  public static boolean isGestureDetectionReady()
  {
    return isGestureDetectionReady;
  }
  
  public static boolean isLutLipsReady()
  {
    return isLipsLutReady;
  }
  
  public static boolean isSegmentationReady()
  {
    return isSegmentationReady;
  }
  
  public static void loadLibrary(String paramString)
  {
    AppMethodBeat.i(83430);
    String str1 = "lib" + paramString + ".so";
    String str2 = ResourcePathMapper.getModelResPath(str1);
    if ((str2 != null) && (!str2.equals("")))
    {
      if (str2.startsWith("assets://"))
      {
        System.loadLibrary(paramString);
        AppMethodBeat.o(83430);
        return;
      }
      System.load(str2 + str1);
      AppMethodBeat.o(83430);
      return;
    }
    paramString = new Exception("Load Library " + str1 + "failed.");
    AppMethodBeat.o(83430);
    throw paramString;
  }
  
  private static void setIsBodyDetectionReady(boolean paramBoolean)
  {
    isBodyDetectionReady = paramBoolean;
  }
  
  private static void setIsGameplayReady(boolean paramBoolean)
  {
    isGameplayReady = paramBoolean;
  }
  
  private static void setIsGestureDetectionReady(boolean paramBoolean)
  {
    isGestureDetectionReady = paramBoolean;
  }
  
  private static void setIsSegmentationReady(boolean paramBoolean)
  {
    isSegmentationReady = paramBoolean;
  }
  
  private static void setisFilterReady(boolean paramBoolean)
  {
    isFilterReady = paramBoolean;
  }
  
  private static void setisLutLipsReady(boolean paramBoolean)
  {
    isLipsLutReady = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.ttpic.manager.FeatureManager
 * JD-Core Version:    0.7.0.1
 */
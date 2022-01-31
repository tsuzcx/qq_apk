package com.tencent.ttpic.util.youtu;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.baseutils.LogUtils;
import com.tencent.ttpic.device.DeviceUtils;
import com.tencent.ttpic.util.ResourcePathMapper;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.util.i;
import java.io.File;

public enum YTFaceDetectorBase
{
  private static final String TAG;
  public static String YT_MODEL_DIR;
  public static String YT_MODEL_DIR_BACKUP;
  private volatile boolean faceTrackInited;
  private volatile boolean picFaceDetectInited;
  
  static
  {
    AppMethodBeat.i(84406);
    INSTANCE = new YTFaceDetectorBase("INSTANCE", 0);
    $VALUES = new YTFaceDetectorBase[] { INSTANCE };
    TAG = YTFaceDetectorBase.class.getSimpleName();
    YT_MODEL_DIR = null;
    YT_MODEL_DIR_BACKUP = null;
    AppMethodBeat.o(84406);
  }
  
  private YTFaceDetectorBase() {}
  
  public static YTFaceDetectorBase getInstance()
  {
    return INSTANCE;
  }
  
  private int initFaceTrackModel(String paramString)
  {
    AppMethodBeat.i(84403);
    int i = nativeInitFaceTrack(paramString);
    AppMethodBeat.o(84403);
    return i;
  }
  
  private int initModel(String paramString)
  {
    AppMethodBeat.i(84402);
    int i = nativeInit(paramString);
    AppMethodBeat.o(84402);
    return i;
  }
  
  private int initPicFaceDetectModel(String paramString)
  {
    AppMethodBeat.i(84404);
    int i = nativeInitPicFaceDetect(paramString);
    AppMethodBeat.o(84404);
    return i;
  }
  
  private native void nativeDestructor();
  
  public final void destroy()
  {
    AppMethodBeat.i(84405);
    nativeDestructor();
    this.faceTrackInited = false;
    this.picFaceDetectInited = false;
    AppMethodBeat.o(84405);
  }
  
  public final int initFaceTrack()
  {
    AppMethodBeat.i(84400);
    if (this.faceTrackInited)
    {
      AppMethodBeat.o(84400);
      return 0;
    }
    String str2 = YT_MODEL_DIR;
    String str1 = str2;
    if (!DeviceUtils.canWriteFile(str2)) {
      str1 = YT_MODEL_DIR_BACKUP;
    }
    DeviceUtils.canWriteFile(str1);
    int j = 0;
    int i = 1;
    while (j < 6)
    {
      str2 = new String[] { "net_1_bin.rpnproto", "net_1.rpnmodel", "net_2_bin.rpnproto", "net_2.rpnmodel", "net_3_bin.rpnproto", "net_3.rpnmodel" }[j];
      if (!FileUtils.copyAssets(VideoGlobalContext.getContext(), "detector/".concat(String.valueOf(str2)), str1 + File.separator + str2)) {
        i = 0;
      }
      j += 1;
    }
    j = 0;
    while (j < 11)
    {
      str2 = new String[] { "align.stb", "align583.rpdm", "align583_bin.rpdc", "eye.rpdm", "eye_bin.rpdc", "eyebrow.rpdm", "eyebrow_bin.rpdc", "mouth.rpdm", "mouth_bin.rpdc", "refine1.rmd", "refine2.rmd" }[j];
      if (!FileUtils.copyAssets(VideoGlobalContext.getContext(), "align/".concat(String.valueOf(str2)), str1 + File.separator + str2)) {
        i = 0;
      }
      j += 1;
    }
    j = 0;
    while (j < 2)
    {
      str2 = new String[] { "meshBasis.bin", "rotBasis.bin" }[j];
      if (!FileUtils.copyAssets(VideoGlobalContext.getContext(), "poseest/".concat(String.valueOf(str2)), str1 + File.separator + str2)) {
        i = 0;
      }
      j += 1;
    }
    if (i == 0)
    {
      AppMethodBeat.o(84400);
      return -1000;
    }
    if (initFaceTrackModel(str1 + File.separator) != 0)
    {
      i.n(TAG, "nativeInit failed");
      AppMethodBeat.o(84400);
      return -1002;
    }
    nativeSetRefine(false);
    this.faceTrackInited = true;
    AppMethodBeat.o(84400);
    return 0;
  }
  
  public final int initPicFaceDetect()
  {
    AppMethodBeat.i(84401);
    if (this.picFaceDetectInited)
    {
      AppMethodBeat.o(84401);
      return 0;
    }
    String str2 = YT_MODEL_DIR;
    String str1 = str2;
    if (!DeviceUtils.canWriteFile(str2)) {
      str1 = YT_MODEL_DIR_BACKUP;
    }
    int j = 0;
    int i = 1;
    if (j < 13)
    {
      str2 = new String[] { "pictrack_align521_16.rpdm", "pictrack_align521_bin.rpdc", "pictrack_contour_16.rpdm", "pictrack_contour_bin.rpdc", "pictrack_eye_16.rpdm", "pictrack_eye_bin.rpdc", "pictrack_eyebrow_16.rpdm", "pictrack_eyebrow_bin.rpdc", "pictrack_FacePicAlignRunner_bin.md5", "pictrack_mouth_16.rpdm", "pictrack_mouth_bin.rpdc", "pictrack_nose_16.rpdm", "pictrack_nose_bin.rpdc" }[j];
      String str3 = ResourcePathMapper.getModelResPath(str2);
      LogUtils.e(TAG, "resPath = ".concat(String.valueOf(str3)));
      if ((str3 != null) && (!str3.startsWith("assets://"))) {
        if (!FileUtils.copyFile(str3 + str2, str1 + File.separator + str2))
        {
          LogUtils.e(TAG, "copyFile failed");
          i = 0;
        }
      }
      for (;;)
      {
        j += 1;
        break;
        if (!FileUtils.copyAssets(VideoGlobalContext.getContext(), "ufa/".concat(String.valueOf(str2)), str1 + File.separator + str2))
        {
          LogUtils.e(TAG, "copyAssets failed");
          i = 0;
        }
      }
    }
    if (i == 0) {
      LogUtils.e(TAG, "copy pic face align model failed!");
    }
    if (initPicFaceDetectModel(str1 + File.separator) != 0)
    {
      i.n(TAG, "nativeInit failed");
      AppMethodBeat.o(84401);
      return -1002;
    }
    nativeSetRefine(false);
    this.picFaceDetectInited = true;
    AppMethodBeat.o(84401);
    return 0;
  }
  
  public final native int nativeInit(String paramString);
  
  public final native int nativeInitFaceTrack(String paramString);
  
  public final native int nativeInitPicFaceDetect(String paramString);
  
  public final native void nativeSetRefine(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.ttpic.util.youtu.YTFaceDetectorBase
 * JD-Core Version:    0.7.0.1
 */
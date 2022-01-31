package com.tencent.ttpic;

import android.content.Context;
import android.opengl.GLES20;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.GpuInfoUtil;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.ttpic.util.VideoPrefsUtil;
import java.util.HashSet;
import java.util.Set;

public class VideoModule
{
  public static final String[] GPU_GL_ONE_THREAD;
  public static String PTU_VERSION;
  public static final int RENDER_MODE = 1;
  public static final int RENDER_MODE_GLFINISH = 0;
  public static final int RENDER_MODE_GLFLUSH = 1;
  public static String SDK_VERSION;
  public static Set<String> blackList;
  private static VideoModule.DeviceType deviceType;
  private static boolean enableEXTShaderFramebufferFetch;
  public static boolean es_GL_EXT_shader_framebuffer_fetch;
  
  static
  {
    AppMethodBeat.i(81647);
    PTU_VERSION = "5.5";
    SDK_VERSION = "1.8";
    blackList = new HashSet();
    GPU_GL_ONE_THREAD = new String[] { "PowerVR SGX 544MP", "Adreno (TM) 306" };
    AppMethodBeat.o(81647);
  }
  
  public static VideoModule.DeviceType getDeviceType()
  {
    return deviceType;
  }
  
  public static int getVersionCode()
  {
    return 480;
  }
  
  public static void init(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(81642);
    VideoGlobalContext.setContext(paramContext);
    VideoPrefsUtil.init(paramContext);
    com.tencent.ttpic.factory.TTPicFilterFactoryLocal.LUT_DIR_ROOT = paramString1;
    com.tencent.ttpic.util.youtu.YTFaceDetectorBase.YT_MODEL_DIR = paramString2;
    com.tencent.ttpic.util.youtu.YTFaceDetectorBase.YT_MODEL_DIR_BACKUP = paramString3;
    AppMethodBeat.o(81642);
  }
  
  private static void initBlackList()
  {
    AppMethodBeat.i(81643);
    blackList.add("OPPO_OPPO_R11_Plus");
    blackList.add("VIVO_vivo_X6S_A");
    blackList.add("SAMSUNG_SM-G9500");
    blackList.add("VIVO_vivo_X20A");
    AppMethodBeat.o(81643);
  }
  
  public static void initExtensionValues()
  {
    boolean bool = true;
    AppMethodBeat.i(81645);
    String[] arrayOfString = GLES20.glGetString(7939).split("\\s");
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfString[i].equals("GL_EXT_shader_framebuffer_fetch")) {
        es_GL_EXT_shader_framebuffer_fetch = true;
      }
      i += 1;
    }
    if ((es_GL_EXT_shader_framebuffer_fetch) && (enableEXTShaderFramebufferFetch)) {}
    for (;;)
    {
      es_GL_EXT_shader_framebuffer_fetch = bool;
      AppMethodBeat.o(81645);
      return;
      bool = false;
    }
  }
  
  public static boolean isEnableEXTShaderFramebufferFetch()
  {
    return enableEXTShaderFramebufferFetch;
  }
  
  private static boolean isInBlackList(String paramString)
  {
    AppMethodBeat.i(81644);
    boolean bool = blackList.contains(paramString);
    AppMethodBeat.o(81644);
    return bool;
  }
  
  public static boolean isInOneGLThreadBlackList()
  {
    AppMethodBeat.i(81646);
    Object localObject = GpuInfoUtil.getGPUInfo().split(";");
    if ((localObject.length > 0) && (!TextUtils.isEmpty(localObject[0])))
    {
      localObject = localObject[0].trim().toLowerCase();
      String[] arrayOfString = GPU_GL_ONE_THREAD;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        if (((String)localObject).equals(arrayOfString[i].toLowerCase()))
        {
          AppMethodBeat.o(81646);
          return true;
        }
        i += 1;
      }
    }
    AppMethodBeat.o(81646);
    return false;
  }
  
  public static void setDeviceType(VideoModule.DeviceType paramDeviceType)
  {
    deviceType = paramDeviceType;
  }
  
  public static void setEnableEXTShaderFramebufferFetch(boolean paramBoolean)
  {
    enableEXTShaderFramebufferFetch = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.ttpic.VideoModule
 * JD-Core Version:    0.7.0.1
 */
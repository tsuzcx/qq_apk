package com.tencent.ttpic;

import android.content.Context;
import android.opengl.GLES20;
import com.tencent.ttpic.util.VideoGlobalContext;
import com.tencent.ttpic.util.VideoPrefsUtil;

public class VideoModule
{
  public static String PTU_VERSION = "5.3";
  public static final int RENDER_MODE = 1;
  public static String SDK_VERSION = "1.7";
  public static boolean es_GL_EXT_shader_framebuffer_fetch;
  
  public static String getSDKVersion()
  {
    return SDK_VERSION;
  }
  
  public static int getVersionCode()
  {
    return 498;
  }
  
  public static void init(Context paramContext)
  {
    VideoGlobalContext.setContext(paramContext);
    VideoPrefsUtil.init(paramContext);
    com.tencent.view.b.xdf = true;
  }
  
  public static void initExtensionValues()
  {
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.ttpic.VideoModule
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.view;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.QImage;
import com.tencent.util.d;
import com.tencent.util.g;
import com.tencent.util.h;
import java.util.Map;

public final class f
{
  private static final float[] xdk = { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
  private static final float[] xdl = { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
  private static boolean xdm = true;
  
  public static void Ku(int paramInt)
  {
    GLES20.glDeleteTextures(1, new int[] { paramInt }, 0);
    checkGlError("glDeleteTextures");
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, Bitmap paramBitmap)
  {
    int i = b.xde;
    if (i < 0)
    {
      if (h.cRm().xcS)
      {
        GLES20.glActiveTexture(33984);
        checkGlError("glActiveTexture");
        GLES20.glBindTexture(3553, paramInt1);
        checkGlError("glBindTexture");
        GLES20.glTexImage2D(3553, 0, 6408, paramInt2, paramInt3, 0, 6408, 5121, null);
        checkGlError("glTexImage2D");
      }
      int[] arrayOfInt = new int[1];
      GLES20.glGenFramebuffers(1, arrayOfInt, 0);
      GLES20.glBindFramebuffer(36160, arrayOfInt[0]);
      checkGlError("glBindFramebuffer");
      GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramInt1, 0);
      checkGlError("glFramebufferTexture2D");
      checkGlError("glReadPixels");
      GLSLRender.nativeCopyPixelToBitmap(paramBitmap);
      GLES20.glBindFramebuffer(36160, 0);
      GLES20.glDeleteFramebuffers(1, arrayOfInt, 0);
      checkGlError("glBindFramebuffer");
      return;
    }
    GLSLRender.nativeCopyPixelToBitmapWithShare(paramBitmap, paramInt1, i);
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte, int paramInt4)
  {
    if (b.xde < 0)
    {
      GLES20.glBindFramebuffer(36160, paramInt4);
      checkGlError("glBindFramebuffer");
      GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramInt1, 0);
      checkGlError("glFramebufferTexture2D");
      GLSLRender.nativeToRGBData(paramArrayOfByte, paramInt2, paramInt3);
      GLES20.glBindFramebuffer(36160, 0);
      checkGlError("glBindFramebuffer");
      return;
    }
    GLSLRender.nativePushDataFromTexture(paramArrayOfByte, paramInt2, paramInt3, b.xde);
  }
  
  public static int ac(Bitmap paramBitmap)
  {
    int i = cRo();
    GLES20.glBindTexture(3553, i);
    GLUtils.texImage2D(3553, 0, paramBitmap, 0);
    GLES20.glTexParameteri(3553, 10240, 9729);
    GLES20.glTexParameteri(3553, 10241, 9729);
    GLES20.glTexParameteri(3553, 10242, 33071);
    GLES20.glTexParameteri(3553, 10243, 33071);
    checkGlError("texImage2D");
    return i;
  }
  
  public static Bitmap ax(int paramInt1, int paramInt2, int paramInt3)
  {
    Bitmap localBitmap = Bitmap.createBitmap(paramInt2, paramInt3, Bitmap.Config.ARGB_8888);
    if (localBitmap != null) {
      a(paramInt1, paramInt2, paramInt3, localBitmap);
    }
    return localBitmap;
  }
  
  public static QImage ay(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = b.xde;
    if (i < 0)
    {
      if (h.cRm().xcS)
      {
        GLES20.glActiveTexture(33984);
        checkGlError("glActiveTexture");
        GLES20.glBindTexture(3553, paramInt1);
        checkGlError("glBindTexture");
        GLES20.glTexImage2D(3553, 0, 6408, paramInt2, paramInt3, 0, 6408, 5121, null);
        checkGlError("glTexImage2D");
      }
      int[] arrayOfInt = new int[1];
      GLES20.glGenFramebuffers(1, arrayOfInt, 0);
      GLES20.glBindFramebuffer(36160, arrayOfInt[0]);
      checkGlError("glBindFramebuffer");
      GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramInt1, 0);
      checkGlError("glFramebufferTexture2D");
      checkGlError("glReadPixels");
      QImage localQImage = GLSLRender.nativeCopyTexture(paramInt2, paramInt3);
      GLES20.glBindFramebuffer(36160, 0);
      GLES20.glDeleteFramebuffers(1, arrayOfInt, 0);
      checkGlError("glBindFramebuffer");
      return localQImage;
    }
    return GLSLRender.nativeCopyTextureWithShare(paramInt2, paramInt3, paramInt1, i);
  }
  
  public static int cRo()
  {
    int[] arrayOfInt = new int[1];
    d.cRj().c(arrayOfInt, true);
    checkGlError("glGenTextures");
    return arrayOfInt[0];
  }
  
  public static void checkGlError(String paramString)
  {
    int i = GLES20.glGetError();
    if ((i != 0) && (xdm))
    {
      g.i("RendererUtils", paramString + ": glError " + i);
      paramString = (StackTraceElement[])Thread.getAllStackTraces().get(Thread.currentThread());
      int j = paramString.length;
      i = 0;
      while (i < j)
      {
        g.i("SS     ", paramString[i].toString());
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.view.f
 * JD-Core Version:    0.7.0.1
 */
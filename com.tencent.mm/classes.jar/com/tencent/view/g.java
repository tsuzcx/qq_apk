package com.tencent.view;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.QImage;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.util.f;
import com.tencent.util.i;
import com.tencent.util.j;
import java.util.Map;

public final class g
{
  private static final float[] BzS = { 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F };
  private static final float[] BzT = { -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F };
  private static boolean BzU = true;
  
  public static void Tn(int paramInt)
  {
    AppMethodBeat.i(86645);
    GLES20.glDeleteTextures(1, new int[] { paramInt }, 0);
    checkGlError("glDeleteTextures");
    AppMethodBeat.o(86645);
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, Bitmap paramBitmap)
  {
    AppMethodBeat.i(86642);
    int i = b.BzL;
    if (i < 0)
    {
      if (j.dXc().BzA)
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
      AppMethodBeat.o(86642);
      return;
    }
    GLSLRender.nativeCopyPixelToBitmapWithShare(paramBitmap, paramInt1, i);
    AppMethodBeat.o(86642);
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte, int paramInt4)
  {
    AppMethodBeat.i(86641);
    if (b.BzL < 0)
    {
      GLES20.glBindFramebuffer(36160, paramInt4);
      checkGlError("glBindFramebuffer");
      GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramInt1, 0);
      checkGlError("glFramebufferTexture2D");
      GLSLRender.nativeToRGBData(paramArrayOfByte, paramInt2, paramInt3);
      GLES20.glBindFramebuffer(36160, 0);
      checkGlError("glBindFramebuffer");
      AppMethodBeat.o(86641);
      return;
    }
    GLSLRender.nativePushDataFromTexture(paramArrayOfByte, paramInt2, paramInt3, b.BzL);
    AppMethodBeat.o(86641);
  }
  
  public static Bitmap aJ(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(86643);
    Bitmap localBitmap = Bitmap.createBitmap(paramInt2, paramInt3, Bitmap.Config.ARGB_8888);
    if (localBitmap != null) {
      a(paramInt1, paramInt2, paramInt3, localBitmap);
    }
    AppMethodBeat.o(86643);
    return localBitmap;
  }
  
  public static QImage aK(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(86644);
    int i = b.BzL;
    if (i < 0)
    {
      if (j.dXc().BzA)
      {
        GLES20.glActiveTexture(33984);
        checkGlError("glActiveTexture");
        GLES20.glBindTexture(3553, paramInt1);
        checkGlError("glBindTexture");
        GLES20.glTexImage2D(3553, 0, 6408, paramInt2, paramInt3, 0, 6408, 5121, null);
        checkGlError("glTexImage2D");
      }
      localObject = new int[1];
      GLES20.glGenFramebuffers(1, (int[])localObject, 0);
      GLES20.glBindFramebuffer(36160, localObject[0]);
      checkGlError("glBindFramebuffer");
      GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramInt1, 0);
      checkGlError("glFramebufferTexture2D");
      checkGlError("glReadPixels");
      QImage localQImage = GLSLRender.nativeCopyTexture(paramInt2, paramInt3);
      GLES20.glBindFramebuffer(36160, 0);
      GLES20.glDeleteFramebuffers(1, (int[])localObject, 0);
      checkGlError("glBindFramebuffer");
      AppMethodBeat.o(86644);
      return localQImage;
    }
    Object localObject = GLSLRender.nativeCopyTextureWithShare(paramInt2, paramInt3, paramInt1, i);
    AppMethodBeat.o(86644);
    return localObject;
  }
  
  public static int at(Bitmap paramBitmap)
  {
    AppMethodBeat.i(86640);
    int i = dXe();
    GLES20.glBindTexture(3553, i);
    GLUtils.texImage2D(3553, 0, paramBitmap, 0);
    GLES20.glTexParameteri(3553, 10240, 9729);
    GLES20.glTexParameteri(3553, 10241, 9729);
    GLES20.glTexParameteri(3553, 10242, 33071);
    GLES20.glTexParameteri(3553, 10243, 33071);
    checkGlError("texImage2D");
    AppMethodBeat.o(86640);
    return i;
  }
  
  public static void checkGlError(String paramString)
  {
    AppMethodBeat.i(86646);
    int i = GLES20.glGetError();
    if ((i != 0) && (BzU))
    {
      i.n("RendererUtils", paramString + ": glError " + i);
      paramString = (StackTraceElement[])Thread.getAllStackTraces().get(Thread.currentThread());
      int j = paramString.length;
      i = 0;
      while (i < j)
      {
        i.n("SS     ", paramString[i].toString());
        i += 1;
      }
    }
    AppMethodBeat.o(86646);
  }
  
  public static int dXe()
  {
    AppMethodBeat.i(86639);
    int[] arrayOfInt = new int[1];
    f.dWZ().c(arrayOfInt, true);
    checkGlError("glGenTextures");
    int i = arrayOfInt[0];
    AppMethodBeat.o(86639);
    return i;
  }
  
  public static boolean isEnableLog()
  {
    return BzU;
  }
  
  public static void sa(boolean paramBoolean)
  {
    BzU = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.view.g
 * JD-Core Version:    0.7.0.1
 */
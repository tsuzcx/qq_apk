package com.tencent.ttpic.util;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.opengl.GLES20;
import com.tencent.filter.GLSLRender;
import java.nio.ByteBuffer;

public class TextureUtil
{
  public static Bitmap rgbaBytesToBitmap(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
    localBitmap.copyPixelsFromBuffer(ByteBuffer.wrap(paramArrayOfByte));
    return localBitmap;
  }
  
  public static void rgbaBytesToBitmap(Bitmap paramBitmap, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramBitmap.copyPixelsFromBuffer(ByteBuffer.wrap(paramArrayOfByte));
  }
  
  public static void textureToRgba(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    int[] arrayOfInt = new int[1];
    GLES20.glGenFramebuffers(1, arrayOfInt, 0);
    GLES20.glBindFramebuffer(36160, arrayOfInt[0]);
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramInt1, 0);
    GLSLRender.nativeToRGBData(paramArrayOfByte, paramInt2, paramInt3);
    GLES20.glBindFramebuffer(36160, 0);
    GLES20.glDeleteFramebuffers(1, arrayOfInt, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.ttpic.util.TextureUtil
 * JD-Core Version:    0.7.0.1
 */
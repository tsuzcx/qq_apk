package com.tencent.tavkit.ciimage;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.opengl.GLES20;
import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.RenderContext;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class TAVGLUtils
{
  private static final String TAG = "TAVGLUtils";
  private static final String TAV_DEBUG_IMAGE_DIR;
  
  static
  {
    AppMethodBeat.i(197335);
    TAV_DEBUG_IMAGE_DIR = Environment.getExternalStorageDirectory().getPath() + "/TAV调试图片";
    AppMethodBeat.o(197335);
  }
  
  private static TextureInfo checkTextureInfo(TextureInfo paramTextureInfo)
  {
    AppMethodBeat.i(197329);
    if (paramTextureInfo.textureType == 3553)
    {
      AppMethodBeat.o(197329);
      return paramTextureInfo;
    }
    TextureInfo localTextureInfo = new TextureInfo(RenderContext.createTexture(3553), 3553, paramTextureInfo.width, paramTextureInfo.height, null, 0);
    TextureFilter localTextureFilter = new TextureFilter();
    localTextureFilter.setOutputTextureInfo(localTextureInfo);
    localTextureFilter.applyFilter(paramTextureInfo, null, paramTextureInfo.getTextureMatrix(), 1.0F, null);
    AppMethodBeat.o(197329);
    return localTextureInfo;
  }
  
  public static File newDebugImageFile(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(197331);
    Object localObject = Long.toHexString(System.currentTimeMillis()) + "_id=" + paramInt1 + "_" + paramInt2 + "_" + paramInt3 + ".png";
    File localFile = new File(TAV_DEBUG_IMAGE_DIR);
    if ((!localFile.exists()) && (!localFile.mkdir()))
    {
      localObject = new RuntimeException("mkdir return false, path = " + localFile.getAbsolutePath());
      AppMethodBeat.o(197331);
      throw ((Throwable)localObject);
    }
    localObject = new File(TAV_DEBUG_IMAGE_DIR, (String)localObject);
    AppMethodBeat.o(197331);
    return localObject;
  }
  
  public static Bitmap saveBitmap(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(197325);
    Bitmap localBitmap = saveBitmap(paramInt1, 3553, paramInt2, paramInt3);
    AppMethodBeat.o(197325);
    return localBitmap;
  }
  
  public static Bitmap saveBitmap(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(197326);
    Bitmap localBitmap = saveBitmap(new TextureInfo(paramInt1, paramInt2, paramInt3, paramInt4, 0));
    AppMethodBeat.o(197326);
    return localBitmap;
  }
  
  public static Bitmap saveBitmap(TextureInfo paramTextureInfo)
  {
    AppMethodBeat.i(197328);
    Object localObject = checkTextureInfo(paramTextureInfo);
    paramTextureInfo = new int[1];
    GLES20.glGenFramebuffers(1, paramTextureInfo, 0);
    GLES20.glBindFramebuffer(36160, paramTextureInfo[0]);
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, ((TextureInfo)localObject).textureID, 0);
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(((TextureInfo)localObject).width * ((TextureInfo)localObject).height * 4);
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    localByteBuffer.rewind();
    GLES20.glReadPixels(0, 0, ((TextureInfo)localObject).width, ((TextureInfo)localObject).height, 6408, 5121, localByteBuffer);
    localObject = Bitmap.createBitmap(((TextureInfo)localObject).width, ((TextureInfo)localObject).height, Bitmap.Config.ARGB_4444);
    localByteBuffer.rewind();
    ((Bitmap)localObject).copyPixelsFromBuffer(localByteBuffer);
    GLES20.glBindFramebuffer(36160, 0);
    GLES20.glDeleteFramebuffers(1, paramTextureInfo, 0);
    AppMethodBeat.o(197328);
    return localObject;
  }
  
  public static Bitmap saveBitmap(CIImage paramCIImage)
  {
    AppMethodBeat.i(197327);
    TextureInfo localTextureInfo = CIContext.newTextureInfo(paramCIImage.getSize().width, paramCIImage.getSize().height);
    CIImageFilter localCIImageFilter = new CIImageFilter();
    localCIImageFilter.setOutputTextureInfo(localTextureInfo);
    paramCIImage.draw(localCIImageFilter);
    paramCIImage = saveBitmap(localTextureInfo);
    AppMethodBeat.o(197327);
    return paramCIImage;
  }
  
  public static void saveBitmapToFile(Bitmap paramBitmap)
  {
    AppMethodBeat.i(197333);
    saveBitmapToFile(paramBitmap, newDebugImageFile(0, paramBitmap.getWidth(), paramBitmap.getHeight()));
    AppMethodBeat.o(197333);
  }
  
  public static void saveBitmapToFile(Bitmap paramBitmap, File paramFile)
  {
    AppMethodBeat.i(197334);
    if (!paramFile.createNewFile())
    {
      paramBitmap = new RuntimeException("createNewFile return false, path = " + paramFile.getAbsolutePath());
      AppMethodBeat.o(197334);
      throw paramBitmap;
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.PNG, 0, localByteArrayOutputStream);
    paramBitmap = localByteArrayOutputStream.toByteArray();
    paramFile = new FileOutputStream(paramFile);
    paramFile.write(paramBitmap);
    paramFile.flush();
    paramFile.close();
    AppMethodBeat.o(197334);
  }
  
  public static void saveBitmapToFile(TextureInfo paramTextureInfo)
  {
    AppMethodBeat.i(197330);
    saveBitmapToFile(paramTextureInfo, newDebugImageFile(paramTextureInfo.textureID, paramTextureInfo.width, paramTextureInfo.height));
    AppMethodBeat.o(197330);
  }
  
  public static void saveBitmapToFile(TextureInfo paramTextureInfo, File paramFile)
  {
    AppMethodBeat.i(197332);
    saveBitmapToFile(saveBitmap(paramTextureInfo), paramFile);
    AppMethodBeat.o(197332);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tavkit.ciimage.TAVGLUtils
 * JD-Core Version:    0.7.0.1
 */
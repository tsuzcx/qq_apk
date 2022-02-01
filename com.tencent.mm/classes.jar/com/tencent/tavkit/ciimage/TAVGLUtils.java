package com.tencent.tavkit.ciimage;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.os.Environment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tav.decoder.RenderContext;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Scanner;

public class TAVGLUtils
{
  private static final String TAG = "TAVGLUtils";
  private static final String TAV_DEBUG_IMAGE_DIR;
  
  static
  {
    AppMethodBeat.i(191842);
    TAV_DEBUG_IMAGE_DIR = Environment.getExternalStorageDirectory().getPath() + "/TAV调试图片";
    AppMethodBeat.o(191842);
  }
  
  public static void checkEglError(String paramString)
  {
    AppMethodBeat.i(191831);
    int i = 0;
    String str = "";
    for (;;)
    {
      int j = EGL14.eglGetError();
      if (j == 12288) {
        break;
      }
      new StringBuilder().append(paramString).append(": EGL error: 0x").append(Integer.toHexString(j));
      str = str + paramString + ": EGL error: 0x" + Integer.toHexString(j);
      i = 1;
    }
    if (i != 0) {
      new RuntimeException("EGL error encountered (see log): ".concat(String.valueOf(str)));
    }
    AppMethodBeat.o(191831);
  }
  
  private static TextureInfo checkTextureInfo(TextureInfo paramTextureInfo)
  {
    AppMethodBeat.i(191836);
    if (paramTextureInfo.textureType == 3553)
    {
      AppMethodBeat.o(191836);
      return paramTextureInfo;
    }
    TextureInfo localTextureInfo = new TextureInfo(RenderContext.createTexture(3553), 3553, paramTextureInfo.width, paramTextureInfo.height, null, 0);
    TextureFilter localTextureFilter = new TextureFilter();
    localTextureFilter.setOutputTextureInfo(localTextureInfo);
    localTextureFilter.applyFilter(paramTextureInfo, null, paramTextureInfo.getTextureMatrix(), 1.0F, null);
    AppMethodBeat.o(191836);
    return localTextureInfo;
  }
  
  public static String convertStreamToString(InputStream paramInputStream)
  {
    AppMethodBeat.i(191833);
    paramInputStream = new Scanner(paramInputStream).useDelimiter("\\A");
    if (paramInputStream.hasNext())
    {
      paramInputStream = paramInputStream.next();
      AppMethodBeat.o(191833);
      return paramInputStream;
    }
    AppMethodBeat.o(191833);
    return "";
  }
  
  public static float lerp(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return (1.0F - paramFloat3) * paramFloat1 + paramFloat2 * paramFloat3;
  }
  
  /* Error */
  public static String loadShaderCode(android.content.Context paramContext, String paramString)
  {
    // Byte code:
    //   0: ldc 155
    //   2: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aconst_null
    //   6: astore_2
    //   7: aload_0
    //   8: invokevirtual 161	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   11: aload_1
    //   12: invokevirtual 167	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   15: astore_0
    //   16: aload_0
    //   17: invokestatic 169	com/tencent/tavkit/ciimage/TAVGLUtils:convertStreamToString	(Ljava/io/InputStream;)Ljava/lang/String;
    //   20: astore_1
    //   21: aload_0
    //   22: ifnull +7 -> 29
    //   25: aload_0
    //   26: invokevirtual 174	java/io/InputStream:close	()V
    //   29: ldc 155
    //   31: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   34: aload_1
    //   35: areturn
    //   36: astore_0
    //   37: aload_2
    //   38: astore_0
    //   39: aload_0
    //   40: ifnull +7 -> 47
    //   43: aload_0
    //   44: invokevirtual 174	java/io/InputStream:close	()V
    //   47: ldc 155
    //   49: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   52: ldc 56
    //   54: areturn
    //   55: astore_0
    //   56: aconst_null
    //   57: astore_1
    //   58: aload_1
    //   59: ifnull +7 -> 66
    //   62: aload_1
    //   63: invokevirtual 174	java/io/InputStream:close	()V
    //   66: ldc 155
    //   68: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   71: aload_0
    //   72: athrow
    //   73: astore_0
    //   74: goto -45 -> 29
    //   77: astore_0
    //   78: goto -31 -> 47
    //   81: astore_1
    //   82: goto -16 -> 66
    //   85: astore_1
    //   86: aload_0
    //   87: astore_2
    //   88: aload_1
    //   89: astore_0
    //   90: aload_2
    //   91: astore_1
    //   92: goto -34 -> 58
    //   95: astore_1
    //   96: goto -57 -> 39
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	99	0	paramContext	android.content.Context
    //   0	99	1	paramString	String
    //   6	85	2	localContext	android.content.Context
    // Exception table:
    //   from	to	target	type
    //   7	16	36	java/lang/Exception
    //   7	16	55	finally
    //   25	29	73	java/io/IOException
    //   43	47	77	java/io/IOException
    //   62	66	81	java/io/IOException
    //   16	21	85	finally
    //   16	21	95	java/lang/Exception
  }
  
  public static File newDebugImageFile(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(191838);
    Object localObject = Long.toHexString(System.currentTimeMillis()) + "_id=" + paramInt1 + "_" + paramInt2 + "_" + paramInt3 + ".png";
    File localFile = new File(TAV_DEBUG_IMAGE_DIR);
    if ((!localFile.exists()) && (!localFile.mkdir()))
    {
      localObject = new RuntimeException("mkdir return false, path = " + localFile.getAbsolutePath());
      AppMethodBeat.o(191838);
      throw ((Throwable)localObject);
    }
    localObject = new File(TAV_DEBUG_IMAGE_DIR, (String)localObject);
    AppMethodBeat.o(191838);
    return localObject;
  }
  
  public static Bitmap saveBitmap(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(191834);
    int[] arrayOfInt = new int[1];
    GLES20.glBindTexture(3553, paramInt1);
    GLES20.glGenFramebuffers(1, arrayOfInt, 0);
    GLES20.glBindFramebuffer(36160, arrayOfInt[0]);
    GLES20.glFramebufferTexture2D(36160, 36064, 3553, paramInt1, 0);
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(paramInt2 * paramInt3 * 4);
    localByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    localByteBuffer.rewind();
    GLES20.glReadPixels(0, 0, paramInt2, paramInt3, 6408, 5121, localByteBuffer);
    Bitmap localBitmap = Bitmap.createBitmap(paramInt2, paramInt3, Bitmap.Config.ARGB_4444);
    localByteBuffer.rewind();
    localBitmap.copyPixelsFromBuffer(localByteBuffer);
    GLES20.glBindFramebuffer(36160, 0);
    GLES20.glDeleteFramebuffers(1, arrayOfInt, 0);
    GLES20.glBindTexture(3553, 0);
    AppMethodBeat.o(191834);
    return localBitmap;
  }
  
  public static Bitmap saveBitmap(TextureInfo paramTextureInfo)
  {
    AppMethodBeat.i(191835);
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
    AppMethodBeat.o(191835);
    return localObject;
  }
  
  public static void saveBitmapToFile(Bitmap paramBitmap)
  {
    AppMethodBeat.i(191840);
    saveBitmapToFile(paramBitmap, newDebugImageFile(0, paramBitmap.getWidth(), paramBitmap.getHeight()));
    AppMethodBeat.o(191840);
  }
  
  public static void saveBitmapToFile(Bitmap paramBitmap, File paramFile)
  {
    AppMethodBeat.i(191841);
    if (!paramFile.createNewFile())
    {
      paramBitmap = new RuntimeException("createNewFile return false, path = " + paramFile.getAbsolutePath());
      AppMethodBeat.o(191841);
      throw paramBitmap;
    }
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    paramBitmap.compress(Bitmap.CompressFormat.PNG, 0, localByteArrayOutputStream);
    paramBitmap = localByteArrayOutputStream.toByteArray();
    paramFile = new FileOutputStream(paramFile);
    paramFile.write(paramBitmap);
    paramFile.flush();
    paramFile.close();
    AppMethodBeat.o(191841);
  }
  
  public static void saveBitmapToFile(TextureInfo paramTextureInfo)
  {
    AppMethodBeat.i(191837);
    saveBitmapToFile(paramTextureInfo, newDebugImageFile(paramTextureInfo.textureID, paramTextureInfo.width, paramTextureInfo.height));
    AppMethodBeat.o(191837);
  }
  
  public static void saveBitmapToFile(TextureInfo paramTextureInfo, File paramFile)
  {
    AppMethodBeat.i(191839);
    saveBitmapToFile(saveBitmap(paramTextureInfo), paramFile);
    AppMethodBeat.o(191839);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tavkit.ciimage.TAVGLUtils
 * JD-Core Version:    0.7.0.1
 */
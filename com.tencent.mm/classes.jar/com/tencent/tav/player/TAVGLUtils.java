package com.tencent.tav.player;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Scanner;

public class TAVGLUtils
{
  private static final String TAG = "TAVGLUtils";
  
  public static String convertStreamToString(InputStream paramInputStream)
  {
    AppMethodBeat.i(215973);
    paramInputStream = new Scanner(paramInputStream, "UTF-8").useDelimiter("\\A");
    if (paramInputStream.hasNext())
    {
      paramInputStream = paramInputStream.next();
      AppMethodBeat.o(215973);
      return paramInputStream;
    }
    AppMethodBeat.o(215973);
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
    //   0: ldc 57
    //   2: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aconst_null
    //   6: astore_3
    //   7: aconst_null
    //   8: astore_2
    //   9: aload_0
    //   10: invokevirtual 63	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   13: aload_1
    //   14: invokevirtual 69	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   17: astore_0
    //   18: aload_0
    //   19: astore_2
    //   20: aload_0
    //   21: astore_3
    //   22: aload_0
    //   23: invokestatic 71	com/tencent/tav/player/TAVGLUtils:convertStreamToString	(Ljava/io/InputStream;)Ljava/lang/String;
    //   26: astore_1
    //   27: aload_0
    //   28: ifnull +7 -> 35
    //   31: aload_0
    //   32: invokevirtual 76	java/io/InputStream:close	()V
    //   35: ldc 57
    //   37: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   40: aload_1
    //   41: areturn
    //   42: astore_0
    //   43: aload_2
    //   44: astore_3
    //   45: ldc 8
    //   47: ldc 77
    //   49: aload_0
    //   50: invokestatic 83	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   53: aload_2
    //   54: ifnull +7 -> 61
    //   57: aload_2
    //   58: invokevirtual 76	java/io/InputStream:close	()V
    //   61: ldc 57
    //   63: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   66: ldc 48
    //   68: areturn
    //   69: astore_0
    //   70: aload_3
    //   71: ifnull +7 -> 78
    //   74: aload_3
    //   75: invokevirtual 76	java/io/InputStream:close	()V
    //   78: ldc 57
    //   80: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   83: aload_0
    //   84: athrow
    //   85: astore_0
    //   86: goto -51 -> 35
    //   89: astore_0
    //   90: goto -29 -> 61
    //   93: astore_1
    //   94: goto -16 -> 78
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	97	0	paramContext	android.content.Context
    //   0	97	1	paramString	String
    //   8	50	2	localContext	android.content.Context
    //   6	69	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   9	18	42	java/lang/Exception
    //   22	27	42	java/lang/Exception
    //   9	18	69	finally
    //   22	27	69	finally
    //   45	53	69	finally
    //   31	35	85	java/io/IOException
    //   57	61	89	java/io/IOException
    //   74	78	93	java/io/IOException
  }
  
  public static Bitmap saveBitmap(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(215986);
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
    AppMethodBeat.o(215986);
    return localBitmap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tav.player.TAVGLUtils
 * JD-Core Version:    0.7.0.1
 */
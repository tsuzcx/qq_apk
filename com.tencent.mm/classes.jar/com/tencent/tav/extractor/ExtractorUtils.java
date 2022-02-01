package com.tencent.tav.extractor;

import android.graphics.Matrix;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.decoder.DecoderAssetTrack;
import java.nio.ByteBuffer;

public class ExtractorUtils
{
  public static final String MIME_AUDIO = "audio/";
  public static final String MIME_VIDEO = "video/";
  public static final int TIMEOUT_US = 1000;
  
  public static void applyMirror(Matrix paramMatrix, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(198116);
    if (paramMatrix == null)
    {
      AppMethodBeat.o(198116);
      return;
    }
    Matrix localMatrix = new Matrix();
    switch (paramInt1)
    {
    }
    for (;;)
    {
      paramMatrix.postConcat(localMatrix);
      AppMethodBeat.o(198116);
      return;
      localMatrix.postScale(-1.0F, 1.0F);
      localMatrix.postTranslate(paramInt2, 0.0F);
      continue;
      localMatrix.postScale(1.0F, -1.0F);
      localMatrix.postTranslate(0.0F, paramInt3);
      continue;
      localMatrix.postScale(-1.0F, -1.0F);
      localMatrix.postTranslate(paramInt2, paramInt3);
    }
  }
  
  public static long getAudioDuration(long paramLong, int paramInt1, int paramInt2)
  {
    return 1000000L * paramLong / (paramInt1 * 2 * paramInt2);
  }
  
  /* Error */
  public static long getAudioDuration(AssetExtractor paramAssetExtractor)
  {
    // Byte code:
    //   0: ldc 56
    //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokevirtual 62	com/tencent/tav/extractor/AssetExtractor:getTrackCount	()I
    //   9: istore_2
    //   10: iconst_0
    //   11: istore_1
    //   12: iload_1
    //   13: iload_2
    //   14: if_icmpge +58 -> 72
    //   17: aload_0
    //   18: iload_1
    //   19: invokevirtual 66	com/tencent/tav/extractor/AssetExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   22: astore 5
    //   24: aload 5
    //   26: ldc 68
    //   28: invokevirtual 74	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   31: ldc 8
    //   33: invokevirtual 80	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   36: ifeq +28 -> 64
    //   39: aload 5
    //   41: ldc 82
    //   43: invokevirtual 85	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   46: ifeq +18 -> 64
    //   49: aload 5
    //   51: ldc 82
    //   53: invokevirtual 89	android/media/MediaFormat:getLong	(Ljava/lang/String;)J
    //   56: lstore_3
    //   57: ldc 56
    //   59: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   62: lload_3
    //   63: lreturn
    //   64: iload_1
    //   65: iconst_1
    //   66: iadd
    //   67: istore_1
    //   68: goto -56 -> 12
    //   71: astore_0
    //   72: ldc 56
    //   74: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   77: lconst_0
    //   78: lreturn
    //   79: astore_0
    //   80: goto -8 -> 72
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	83	0	paramAssetExtractor	AssetExtractor
    //   11	57	1	i	int
    //   9	6	2	j	int
    //   56	7	3	l	long
    //   22	28	5	localMediaFormat	MediaFormat
    // Exception table:
    //   from	to	target	type
    //   5	10	71	java/lang/Exception
    //   17	57	71	java/lang/Exception
    //   5	10	79	java/lang/Error
    //   17	57	79	java/lang/Error
  }
  
  public static long getDuration(AssetExtractor paramAssetExtractor)
  {
    AppMethodBeat.i(198109);
    try
    {
      j = paramAssetExtractor.getTrackCount();
      i = 0;
      l2 = 0L;
      l1 = 0L;
    }
    catch (Exception paramAssetExtractor)
    {
      int j;
      MediaFormat localMediaFormat;
      String str;
      AppMethodBeat.o(198109);
      return 0L;
    }
    catch (Error paramAssetExtractor)
    {
      for (;;)
      {
        int i;
        long l3;
        long l4;
        continue;
        i += 1;
        long l2 = l3;
        long l1 = l4;
      }
    }
    if (i < j)
    {
      localMediaFormat = paramAssetExtractor.getTrackFormat(i);
      str = localMediaFormat.getString("mime");
      if (str.startsWith("video/"))
      {
        l3 = l2;
        l4 = l1;
        if (localMediaFormat.containsKey("durationUs"))
        {
          l4 = localMediaFormat.getLong("durationUs");
          l3 = l2;
        }
      }
      else
      {
        l3 = l2;
        l4 = l1;
        if (str.startsWith("audio/"))
        {
          l3 = l2;
          l4 = l1;
          if (localMediaFormat.containsKey("durationUs"))
          {
            l3 = localMediaFormat.getLong("durationUs");
            l4 = l1;
          }
        }
      }
    }
    else
    {
      if (l1 > 0L)
      {
        AppMethodBeat.o(198109);
        return l1;
      }
      AppMethodBeat.o(198109);
      return l2;
    }
  }
  
  /* Error */
  public static long getDuration(String paramString)
  {
    // Byte code:
    //   0: ldc 92
    //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 58	com/tencent/tav/extractor/AssetExtractor
    //   8: dup
    //   9: invokespecial 93	com/tencent/tav/extractor/AssetExtractor:<init>	()V
    //   12: astore_3
    //   13: aload_3
    //   14: aload_0
    //   15: invokevirtual 97	com/tencent/tav/extractor/AssetExtractor:setDataSource	(Ljava/lang/String;)V
    //   18: aload_3
    //   19: invokestatic 99	com/tencent/tav/extractor/ExtractorUtils:getDuration	(Lcom/tencent/tav/extractor/AssetExtractor;)J
    //   22: lstore_1
    //   23: aload_3
    //   24: invokevirtual 102	com/tencent/tav/extractor/AssetExtractor:release	()V
    //   27: ldc 92
    //   29: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   32: lload_1
    //   33: lreturn
    //   34: astore_0
    //   35: ldc 92
    //   37: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   40: lconst_0
    //   41: lreturn
    //   42: astore_0
    //   43: goto -16 -> 27
    //   46: astore_0
    //   47: goto -20 -> 27
    //   50: astore_0
    //   51: goto -16 -> 35
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	paramString	String
    //   22	11	1	l	long
    //   12	12	3	localAssetExtractor	AssetExtractor
    // Exception table:
    //   from	to	target	type
    //   5	23	34	java/lang/Exception
    //   23	27	42	java/lang/Exception
    //   23	27	46	java/lang/Error
    //   5	23	50	java/lang/Error
  }
  
  /* Error */
  public static MediaFormat getFirstFormat(AssetExtractor paramAssetExtractor, String paramString)
  {
    // Byte code:
    //   0: ldc 105
    //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokevirtual 62	com/tencent/tav/extractor/AssetExtractor:getTrackCount	()I
    //   9: istore_3
    //   10: iconst_0
    //   11: istore_2
    //   12: iload_2
    //   13: iload_3
    //   14: if_icmpge +44 -> 58
    //   17: aload_0
    //   18: iload_2
    //   19: invokevirtual 66	com/tencent/tav/extractor/AssetExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   22: astore 5
    //   24: aload 5
    //   26: ldc 68
    //   28: invokevirtual 74	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   31: aload_1
    //   32: invokevirtual 80	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   35: istore 4
    //   37: iload 4
    //   39: ifeq +11 -> 50
    //   42: ldc 105
    //   44: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   47: aload 5
    //   49: areturn
    //   50: iload_2
    //   51: iconst_1
    //   52: iadd
    //   53: istore_2
    //   54: goto -42 -> 12
    //   57: astore_0
    //   58: ldc 105
    //   60: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   63: aconst_null
    //   64: areturn
    //   65: astore_0
    //   66: goto -8 -> 58
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	69	0	paramAssetExtractor	AssetExtractor
    //   0	69	1	paramString	String
    //   11	43	2	i	int
    //   9	6	3	j	int
    //   35	3	4	bool	boolean
    //   22	26	5	localMediaFormat	MediaFormat
    // Exception table:
    //   from	to	target	type
    //   5	10	57	java/lang/Exception
    //   17	37	57	java/lang/Exception
    //   5	10	65	java/lang/Error
    //   17	37	65	java/lang/Error
  }
  
  /* Error */
  public static int getFirstTrackIndex(AssetExtractor paramAssetExtractor, String paramString)
  {
    // Byte code:
    //   0: ldc 108
    //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokevirtual 62	com/tencent/tav/extractor/AssetExtractor:getTrackCount	()I
    //   9: istore_3
    //   10: iconst_0
    //   11: istore_2
    //   12: iload_2
    //   13: iload_3
    //   14: if_icmpge +39 -> 53
    //   17: aload_0
    //   18: iload_2
    //   19: invokevirtual 66	com/tencent/tav/extractor/AssetExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   22: ldc 68
    //   24: invokevirtual 74	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   27: aload_1
    //   28: invokevirtual 80	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   31: istore 4
    //   33: iload 4
    //   35: ifeq +10 -> 45
    //   38: ldc 108
    //   40: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   43: iload_2
    //   44: ireturn
    //   45: iload_2
    //   46: iconst_1
    //   47: iadd
    //   48: istore_2
    //   49: goto -37 -> 12
    //   52: astore_0
    //   53: ldc 108
    //   55: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   58: iconst_m1
    //   59: ireturn
    //   60: astore_0
    //   61: goto -8 -> 53
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	64	0	paramAssetExtractor	AssetExtractor
    //   0	64	1	paramString	String
    //   11	38	2	i	int
    //   9	6	3	j	int
    //   31	3	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   5	10	52	java/lang/Exception
    //   17	33	52	java/lang/Exception
    //   5	10	60	java/lang/Error
    //   17	33	60	java/lang/Error
  }
  
  public static int getFrameRate(MediaFormat paramMediaFormat)
  {
    AppMethodBeat.i(198120);
    if (paramMediaFormat != null) {}
    try
    {
      if (paramMediaFormat.containsKey("frame-rate"))
      {
        int i = paramMediaFormat.getInteger("frame-rate");
        AppMethodBeat.o(198120);
        return i;
      }
    }
    catch (Exception paramMediaFormat)
    {
      AppMethodBeat.o(198120);
      return 0;
    }
    catch (Error paramMediaFormat)
    {
      label33:
      break label33;
    }
  }
  
  public static ByteBuffer getInputBuffer(MediaCodec paramMediaCodec, int paramInt)
  {
    AppMethodBeat.i(198119);
    if (Build.VERSION.SDK_INT < 21)
    {
      paramMediaCodec = paramMediaCodec.getInputBuffers()[paramInt];
      AppMethodBeat.o(198119);
      return paramMediaCodec;
    }
    paramMediaCodec = paramMediaCodec.getInputBuffer(paramInt);
    AppMethodBeat.o(198119);
    return paramMediaCodec;
  }
  
  public static ByteBuffer getOutputBuffer(MediaCodec paramMediaCodec, int paramInt)
  {
    AppMethodBeat.i(198118);
    if (Build.VERSION.SDK_INT < 21)
    {
      paramMediaCodec = paramMediaCodec.getOutputBuffers()[paramInt];
      AppMethodBeat.o(198118);
      return paramMediaCodec;
    }
    paramMediaCodec = paramMediaCodec.getOutputBuffer(paramInt);
    AppMethodBeat.o(198118);
    return paramMediaCodec;
  }
  
  public static int getPreferRotation(AssetExtractor paramAssetExtractor)
  {
    AppMethodBeat.i(198113);
    try
    {
      paramAssetExtractor = getFirstFormat(paramAssetExtractor, "video/");
      if ((paramAssetExtractor != null) && (paramAssetExtractor.containsKey("rotation-degrees")))
      {
        int i = paramAssetExtractor.getInteger("rotation-degrees") / 90;
        AppMethodBeat.o(198113);
        return i;
      }
    }
    catch (Exception paramAssetExtractor)
    {
      AppMethodBeat.o(198113);
      return 0;
    }
    catch (Error paramAssetExtractor)
    {
      label43:
      break label43;
    }
  }
  
  public static void getRotationMatrix(Matrix paramMatrix, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(198114);
    int i = paramInt1 % 4;
    paramInt1 = i;
    if (i < 0) {
      paramInt1 = i + 4;
    }
    float f1;
    float f2;
    float f3;
    float f4;
    float f5;
    float f6;
    switch (paramInt1)
    {
    default: 
      f1 = 0.0F;
      f2 = 0.0F;
      f3 = 1.0F;
      f4 = 0.0F;
      f5 = 0.0F;
      f6 = 1.0F;
    }
    for (;;)
    {
      paramMatrix.setValues(new float[] { f6, f4, f2, f5, f3, f1, 0.0F, 0.0F, 1.0F });
      AppMethodBeat.o(198114);
      return;
      f2 = paramInt3;
      f1 = 0.0F;
      f3 = 0.0F;
      f4 = -1.0F;
      f5 = 1.0F;
      f6 = 0.0F;
      continue;
      f2 = paramInt2;
      f1 = paramInt3;
      f3 = -1.0F;
      f4 = 0.0F;
      f5 = 0.0F;
      f6 = -1.0F;
      continue;
      f1 = paramInt2;
      f2 = 0.0F;
      f3 = 0.0F;
      f4 = 1.0F;
      f5 = -1.0F;
      f6 = 0.0F;
    }
  }
  
  public static CGSize getTransformedSize(CGSize paramCGSize, int paramInt, float paramFloat)
  {
    AppMethodBeat.i(198115);
    paramCGSize = paramCGSize.clone();
    if (Math.abs(paramInt) % 2 == 1)
    {
      float f = paramCGSize.width;
      paramCGSize.width = paramCGSize.height;
      paramCGSize.height = f;
    }
    if (paramFloat > 0.0F)
    {
      if (paramCGSize.width * 1.0F / paramCGSize.height <= paramFloat) {
        break label83;
      }
      paramCGSize.width = ((int)Math.ceil(paramCGSize.height * paramFloat));
    }
    for (;;)
    {
      AppMethodBeat.o(198115);
      return paramCGSize;
      label83:
      paramCGSize.height = ((int)Math.ceil(paramCGSize.width * 1.0F / paramFloat));
    }
  }
  
  public static CGSize getVideoSize(AssetExtractor paramAssetExtractor)
  {
    AppMethodBeat.i(198112);
    for (;;)
    {
      try
      {
        paramAssetExtractor = getFirstFormat(paramAssetExtractor, "video/");
        localCGSize = new CGSize();
        if (paramAssetExtractor != null)
        {
          if (!paramAssetExtractor.containsKey("display-width")) {
            continue;
          }
          localCGSize.width = paramAssetExtractor.getInteger("display-width");
          if (!paramAssetExtractor.containsKey("display-height")) {
            continue;
          }
          localCGSize.height = paramAssetExtractor.getInteger("display-height");
        }
      }
      catch (Exception paramAssetExtractor)
      {
        CGSize localCGSize;
        paramAssetExtractor = new CGSize();
        AppMethodBeat.o(198112);
        return paramAssetExtractor;
        localCGSize.height = paramAssetExtractor.getInteger("height");
        continue;
      }
      catch (Error paramAssetExtractor)
      {
        continue;
      }
      AppMethodBeat.o(198112);
      return localCGSize;
      localCGSize.width = paramAssetExtractor.getInteger("width");
    }
  }
  
  public static boolean isSameExtractor(DecoderAssetTrack paramDecoderAssetTrack1, DecoderAssetTrack paramDecoderAssetTrack2)
  {
    AppMethodBeat.i(198121);
    if ((paramDecoderAssetTrack1 != null) && (paramDecoderAssetTrack2 != null)) {}
    for (int i = 1; (i != 0) && (paramDecoderAssetTrack1.assetPath != null) && (paramDecoderAssetTrack1.assetPath.equals(paramDecoderAssetTrack2.assetPath)); i = 0)
    {
      AppMethodBeat.o(198121);
      return true;
    }
    AppMethodBeat.o(198121);
    return false;
  }
  
  private static void swap(float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    float f = paramArrayOfFloat[paramInt1];
    paramArrayOfFloat[paramInt1] = paramArrayOfFloat[paramInt2];
    paramArrayOfFloat[paramInt2] = f;
  }
  
  public static float[] toOpenGL2DMatrix(Matrix paramMatrix)
  {
    AppMethodBeat.i(198117);
    float[] arrayOfFloat = new float[9];
    if (paramMatrix == null)
    {
      int i = 0;
      if (i < 9)
      {
        if (i % 4 == 0) {}
        for (float f = 1.0F;; f = 0.0F)
        {
          arrayOfFloat[i] = f;
          i += 1;
          break;
        }
      }
    }
    else
    {
      paramMatrix.getValues(arrayOfFloat);
      swap(arrayOfFloat, 1, 3);
      swap(arrayOfFloat, 2, 6);
      swap(arrayOfFloat, 5, 7);
    }
    AppMethodBeat.o(198117);
    return arrayOfFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tav.extractor.ExtractorUtils
 * JD-Core Version:    0.7.0.1
 */
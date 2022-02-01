package com.tencent.tav.decoder;

import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.RectF;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.extractor.AssetExtractor;
import java.nio.ByteBuffer;

public class DecoderUtils
{
  public static final String MIME_AUDIO = "audio/";
  public static final String MIME_VIDEO = "video/";
  public static final int TIMEOUT_US = 1000;
  
  public static long getAudioDuration(long paramLong, int paramInt1, int paramInt2)
  {
    return 1000000L * paramLong / (paramInt1 * 2 * paramInt2);
  }
  
  /* Error */
  public static long getAudioDuration(AssetExtractor paramAssetExtractor)
  {
    // Byte code:
    //   0: ldc 29
    //   2: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokevirtual 41	com/tencent/tav/extractor/AssetExtractor:getTrackCount	()I
    //   9: istore_2
    //   10: iconst_0
    //   11: istore_1
    //   12: iload_1
    //   13: iload_2
    //   14: if_icmpge +58 -> 72
    //   17: aload_0
    //   18: iload_1
    //   19: invokevirtual 45	com/tencent/tav/extractor/AssetExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   22: astore 5
    //   24: aload 5
    //   26: ldc 47
    //   28: invokevirtual 53	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   31: ldc 8
    //   33: invokevirtual 59	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   36: ifeq +28 -> 64
    //   39: aload 5
    //   41: ldc 61
    //   43: invokevirtual 64	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   46: ifeq +18 -> 64
    //   49: aload 5
    //   51: ldc 61
    //   53: invokevirtual 68	android/media/MediaFormat:getLong	(Ljava/lang/String;)J
    //   56: lstore_3
    //   57: ldc 29
    //   59: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   62: lload_3
    //   63: lreturn
    //   64: iload_1
    //   65: iconst_1
    //   66: iadd
    //   67: istore_1
    //   68: goto -56 -> 12
    //   71: astore_0
    //   72: ldc 29
    //   74: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    AppMethodBeat.i(218179);
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
      AppMethodBeat.o(218179);
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
        AppMethodBeat.o(218179);
        return l1;
      }
      AppMethodBeat.o(218179);
      return l2;
    }
  }
  
  /* Error */
  public static long getDuration(String paramString)
  {
    // Byte code:
    //   0: ldc 74
    //   2: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 37	com/tencent/tav/extractor/AssetExtractor
    //   8: dup
    //   9: invokespecial 75	com/tencent/tav/extractor/AssetExtractor:<init>	()V
    //   12: astore_3
    //   13: aload_3
    //   14: aload_0
    //   15: invokevirtual 79	com/tencent/tav/extractor/AssetExtractor:setDataSource	(Ljava/lang/String;)V
    //   18: aload_3
    //   19: invokestatic 81	com/tencent/tav/decoder/DecoderUtils:getDuration	(Lcom/tencent/tav/extractor/AssetExtractor;)J
    //   22: lstore_1
    //   23: aload_3
    //   24: invokevirtual 84	com/tencent/tav/extractor/AssetExtractor:release	()V
    //   27: ldc 74
    //   29: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   32: lload_1
    //   33: lreturn
    //   34: astore_0
    //   35: ldc 74
    //   37: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   0: ldc 87
    //   2: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokevirtual 41	com/tencent/tav/extractor/AssetExtractor:getTrackCount	()I
    //   9: istore_3
    //   10: iconst_0
    //   11: istore_2
    //   12: iload_2
    //   13: iload_3
    //   14: if_icmpge +44 -> 58
    //   17: aload_0
    //   18: iload_2
    //   19: invokevirtual 45	com/tencent/tav/extractor/AssetExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   22: astore 5
    //   24: aload 5
    //   26: ldc 47
    //   28: invokevirtual 53	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   31: aload_1
    //   32: invokevirtual 59	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   35: istore 4
    //   37: iload 4
    //   39: ifeq +11 -> 50
    //   42: ldc 87
    //   44: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   47: aload 5
    //   49: areturn
    //   50: iload_2
    //   51: iconst_1
    //   52: iadd
    //   53: istore_2
    //   54: goto -42 -> 12
    //   57: astore_0
    //   58: ldc 87
    //   60: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   0: ldc 90
    //   2: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokevirtual 41	com/tencent/tav/extractor/AssetExtractor:getTrackCount	()I
    //   9: istore_3
    //   10: iconst_0
    //   11: istore_2
    //   12: iload_2
    //   13: iload_3
    //   14: if_icmpge +39 -> 53
    //   17: aload_0
    //   18: iload_2
    //   19: invokevirtual 45	com/tencent/tav/extractor/AssetExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   22: ldc 47
    //   24: invokevirtual 53	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   27: aload_1
    //   28: invokevirtual 59	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   31: istore 4
    //   33: iload 4
    //   35: ifeq +10 -> 45
    //   38: ldc 90
    //   40: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   43: iload_2
    //   44: ireturn
    //   45: iload_2
    //   46: iconst_1
    //   47: iadd
    //   48: istore_2
    //   49: goto -37 -> 12
    //   52: astore_0
    //   53: ldc 90
    //   55: invokestatic 71	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public static ByteBuffer getInputBuffer(MediaCodec paramMediaCodec, int paramInt)
  {
    AppMethodBeat.i(218187);
    if (Build.VERSION.SDK_INT < 21)
    {
      paramMediaCodec = paramMediaCodec.getInputBuffers()[paramInt];
      AppMethodBeat.o(218187);
      return paramMediaCodec;
    }
    paramMediaCodec = paramMediaCodec.getInputBuffer(paramInt);
    AppMethodBeat.o(218187);
    return paramMediaCodec;
  }
  
  public static Rectangle getMatrixAndCropRect(CGSize paramCGSize, int paramInt, float paramFloat1, float paramFloat2, Point paramPoint, Matrix paramMatrix)
  {
    AppMethodBeat.i(218182);
    while (paramInt < 0) {
      paramInt += 4;
    }
    paramInt %= 4;
    getRotationMatrix(paramMatrix, paramInt, paramCGSize.width, paramCGSize.height);
    Object localObject = getTransformedSize(paramCGSize, paramInt, paramFloat2);
    CGSize localCGSize;
    float f2;
    float f1;
    if ((paramFloat2 > 0.0F) || (paramFloat1 > 1.0F))
    {
      localCGSize = new CGSize();
      if (paramInt % 2 == 1)
      {
        localCGSize.width = paramCGSize.height;
        localCGSize.height = paramCGSize.width;
        f2 = 0.0F;
        paramFloat2 = 0.0F;
        if (((CGSize)localObject).width == localCGSize.width) {
          break label511;
        }
        f1 = (localCGSize.width - ((CGSize)localObject).width) * 0.5F;
        label123:
        Matrix localMatrix = new Matrix();
        localMatrix.setTranslate(-f1, -paramFloat2);
        f2 = ((CGSize)localObject).width;
        float f3 = ((CGSize)localObject).height;
        f2 /= paramFloat1;
        f3 /= paramFloat1;
        float f5 = (paramFloat1 - 1.0F) / paramFloat1;
        float f4 = -((CGSize)localObject).width * 0.5F * f5 - paramPoint.x;
        f5 = -((CGSize)localObject).height * 0.5F * f5 - paramPoint.y;
        paramPoint = new Matrix();
        paramPoint.setTranslate(f4, f5);
        f1 -= f4;
        paramFloat2 -= f5;
        localMatrix.postConcat(paramPoint);
        localMatrix.postScale(paramFloat1, paramFloat1);
        paramPoint = new Matrix();
        paramMatrix.invert(paramPoint);
        localObject = new RectF(f1, paramFloat2, f2 + f1, f3 + paramFloat2);
        paramPoint.mapRect((RectF)localObject);
        paramPoint = new Rectangle(((RectF)localObject).left, ((RectF)localObject).top, ((RectF)localObject).width(), ((RectF)localObject).height());
        if (paramPoint.x < 0.0F)
        {
          paramPoint.width += paramPoint.x;
          paramPoint.x = 0.0F;
        }
        if (paramPoint.y < 0.0F)
        {
          paramPoint.height += paramPoint.y;
          paramPoint.y = 0.0F;
        }
        if (paramPoint.x + paramPoint.width > paramCGSize.width) {
          paramPoint.width = (localCGSize.width - paramPoint.x);
        }
        if (paramPoint.y + paramPoint.height > paramCGSize.height) {
          paramPoint.height = (localCGSize.height - paramPoint.y);
        }
        paramMatrix.postConcat(localMatrix);
      }
    }
    for (paramCGSize = paramPoint;; paramCGSize = null)
    {
      AppMethodBeat.o(218182);
      return paramCGSize;
      localCGSize.width = paramCGSize.width;
      localCGSize.height = paramCGSize.height;
      break;
      label511:
      f1 = f2;
      if (((CGSize)localObject).height == localCGSize.height) {
        break label123;
      }
      paramFloat2 = (localCGSize.height - ((CGSize)localObject).height) * 0.5F;
      f1 = f2;
      break label123;
    }
  }
  
  public static ByteBuffer getOutputBuffer(MediaCodec paramMediaCodec, int paramInt)
  {
    AppMethodBeat.i(218186);
    if (Build.VERSION.SDK_INT < 21)
    {
      paramMediaCodec = paramMediaCodec.getOutputBuffers()[paramInt];
      AppMethodBeat.o(218186);
      return paramMediaCodec;
    }
    paramMediaCodec = paramMediaCodec.getOutputBuffer(paramInt);
    AppMethodBeat.o(218186);
    return paramMediaCodec;
  }
  
  public static Matrix getPreferMatrix(CGSize paramCGSize1, CGSize paramCGSize2, int paramInt)
  {
    AppMethodBeat.i(218188);
    Matrix localMatrix1 = new Matrix();
    getMatrixAndCropRect(paramCGSize2, paramInt, 1.0F, 0.0F, new Point(0, 0), localMatrix1);
    Matrix localMatrix2 = new Matrix();
    paramCGSize2 = getTransformedSize(paramCGSize2, paramInt, 0.0F);
    float f1;
    float f2;
    if (paramCGSize2.width * 1.0F / paramCGSize1.width > 1.0F * paramCGSize2.height / paramCGSize1.height)
    {
      f1 = paramCGSize1.width / paramCGSize2.width;
      localMatrix2.setScale(f1, f1);
      f2 = paramCGSize2.height;
      localMatrix2.postTranslate(0.0F, Math.round((paramCGSize1.height - f2 * f1) * 0.5F));
    }
    for (;;)
    {
      localMatrix1.postConcat(localMatrix2);
      AppMethodBeat.o(218188);
      return localMatrix1;
      f1 = paramCGSize1.height / paramCGSize2.height;
      localMatrix2.setScale(f1, f1);
      f2 = paramCGSize2.width;
      localMatrix2.postTranslate(Math.round((paramCGSize1.width - f2 * f1) * 0.5F), 0.0F);
    }
  }
  
  public static void getRotationMatrix(Matrix paramMatrix, int paramInt, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(218184);
    int i = paramInt % 4;
    paramInt = i;
    if (i < 0) {
      paramInt = i + 4;
    }
    float f1;
    float f2;
    float f3;
    float f4;
    switch (paramInt)
    {
    default: 
      paramFloat1 = 0.0F;
      paramFloat2 = 0.0F;
      f1 = 1.0F;
      f2 = 0.0F;
      f3 = 0.0F;
      f4 = 1.0F;
    }
    for (;;)
    {
      paramMatrix.setValues(new float[] { f4, f2, paramFloat2, f3, f1, paramFloat1, 0.0F, 0.0F, 1.0F });
      AppMethodBeat.o(218184);
      return;
      paramFloat1 = 0.0F;
      f1 = 0.0F;
      f2 = -1.0F;
      f3 = 1.0F;
      f4 = 0.0F;
      continue;
      f1 = paramFloat1;
      float f5 = -1.0F;
      f2 = 0.0F;
      f3 = 0.0F;
      f4 = -1.0F;
      paramFloat1 = paramFloat2;
      paramFloat2 = f1;
      f1 = f5;
      continue;
      paramFloat2 = 0.0F;
      f1 = 0.0F;
      f2 = 1.0F;
      f3 = -1.0F;
      f4 = 0.0F;
    }
  }
  
  public static CGSize getTransformedSize(CGSize paramCGSize, int paramInt, float paramFloat)
  {
    AppMethodBeat.i(218183);
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
      AppMethodBeat.o(218183);
      return paramCGSize;
      label83:
      paramCGSize.height = ((int)Math.ceil(paramCGSize.width * 1.0F / paramFloat));
    }
  }
  
  private static void swap(float[] paramArrayOfFloat, int paramInt1, int paramInt2)
  {
    float f = paramArrayOfFloat[paramInt1];
    paramArrayOfFloat[paramInt1] = paramArrayOfFloat[paramInt2];
    paramArrayOfFloat[paramInt2] = f;
  }
  
  public static float[] toOpenGL2DMatrix(Matrix paramMatrix)
  {
    AppMethodBeat.i(218185);
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
    AppMethodBeat.o(218185);
    return arrayOfFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.tav.decoder.DecoderUtils
 * JD-Core Version:    0.7.0.1
 */
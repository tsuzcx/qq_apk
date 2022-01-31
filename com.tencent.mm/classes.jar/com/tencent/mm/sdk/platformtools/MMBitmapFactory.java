package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.AssetManager.AssetInputStream;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.os.Process;
import com.tencent.mm.compatible.e.n;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.vfs.b;
import com.tencent.mm.vfs.e;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;

public class MMBitmapFactory
{
  public static final int DECODER_ID_MMJPEG_DECODER = 2;
  public static final int DECODER_ID_MMPNG_DECODER = 0;
  public static final int DECODER_ID_MMVCODEC_DECODER = 1;
  private static final Bitmap.Config DEFAULT_BITMAP_CONFIG = Bitmap.Config.ARGB_8888;
  private static final int DEFAULT_CHECK_STORAGE_SIZE = 8192;
  private static final int DEFAULT_DECODE_MARK_SIZE = 8388608;
  private static final int DEFAULT_DECODE_STORAGE_SIZE = 8192;
  public static final int DEFAULT_DECODE_STRATEGY = 1;
  public static final int ERROR_ALLOCATE_STRUCT_FAILED = 1001;
  public static final int ERROR_BEGIN_SAMPLE_FAILED = 1004;
  public static final int ERROR_GET_PIXEL_FORMAT_FAILED = 1003;
  public static final int ERROR_ILLEGAL_IDATA_CHUNK = 2003;
  public static final int ERROR_ILLEGAL_IMAGE_SIZE = 1008;
  public static final int ERROR_ILLEGAL_NPTC_CHUNK = 2002;
  public static final int ERROR_IMAGE_SIZE_IS_TOO_LARGE = 1007;
  public static final int ERROR_IMG_BUG_DETECTED_BEGIN = 2000;
  public static final int ERROR_IO_FAILED = 1005;
  public static final int ERROR_LOCK_BITMAP_FAILED = 1002;
  public static final int ERROR_PNG_BUG_DETECTED_BEGIN = 2001;
  public static final int ERROR_SUCCESS = 0;
  public static final int ERROR_UNSUPPORT_IMAGE_FORMAT = 1006;
  private static final int ERROR_USER_DEFINED_BEGIN = 3000;
  public static final int STRATEGY_AUTO_DETECT = 0;
  public static final int STRATEGY_FORCE_SYSTEM_DECODER = 1;
  private static final String TAG = "MicroMsg.MMBitmapFactory";
  private static boolean mIsInit = false;
  static Method mMthGetDefaultDensity = null;
  
  private static boolean checkIfHaveToUseMMDecoder(BitmapFactory.Options paramOptions)
  {
    if (paramOptions != null) {}
    for (String str = paramOptions.outMimeType;; str = "")
    {
      y.d("MicroMsg.MMBitmapFactory", "mimetype: %s", new Object[] { str });
      if ((paramOptions == null) || (paramOptions.outMimeType == null) || ((!paramOptions.outMimeType.toLowerCase().endsWith("png")) && (!paramOptions.outMimeType.toLowerCase().endsWith("vcodec")))) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public static boolean checkIsImageLegal(InputStream paramInputStream)
  {
    return checkIsImageLegal(paramInputStream, null);
  }
  
  public static boolean checkIsImageLegal(InputStream paramInputStream, DecodeResultLogger paramDecodeResultLogger)
  {
    return checkIsImageLegalInternal(paramInputStream, paramDecodeResultLogger);
  }
  
  public static boolean checkIsImageLegal(String paramString)
  {
    return checkIsImageLegal(paramString, null);
  }
  
  /* Error */
  public static boolean checkIsImageLegal(String paramString, DecodeResultLogger paramDecodeResultLogger)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +24 -> 25
    //   4: ldc 64
    //   6: ldc 131
    //   8: invokestatic 135	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   11: aload_1
    //   12: ifnull +11 -> 23
    //   15: aload_1
    //   16: sipush 1005
    //   19: invokestatic 139	com/tencent/mm/sdk/platformtools/MMBitmapFactory$DecodeResultLogger:access$002	(Lcom/tencent/mm/sdk/platformtools/MMBitmapFactory$DecodeResultLogger;I)I
    //   22: pop
    //   23: iconst_0
    //   24: ireturn
    //   25: new 141	java/io/BufferedInputStream
    //   28: dup
    //   29: new 143	com/tencent/mm/vfs/d
    //   32: dup
    //   33: aload_0
    //   34: invokespecial 146	com/tencent/mm/vfs/d:<init>	(Ljava/lang/String;)V
    //   37: invokespecial 149	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   40: astore 6
    //   42: aload 6
    //   44: astore 5
    //   46: invokestatic 155	java/lang/System:currentTimeMillis	()J
    //   49: lstore_2
    //   50: aload 6
    //   52: astore 5
    //   54: aload 6
    //   56: aload_1
    //   57: invokestatic 124	com/tencent/mm/sdk/platformtools/MMBitmapFactory:checkIsImageLegalInternal	(Ljava/io/InputStream;Lcom/tencent/mm/sdk/platformtools/MMBitmapFactory$DecodeResultLogger;)Z
    //   60: istore 4
    //   62: aload 6
    //   64: astore 5
    //   66: ldc 64
    //   68: ldc 157
    //   70: iconst_3
    //   71: anewarray 4	java/lang/Object
    //   74: dup
    //   75: iconst_0
    //   76: aload_0
    //   77: aastore
    //   78: dup
    //   79: iconst_1
    //   80: iload 4
    //   82: invokestatic 163	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   85: aastore
    //   86: dup
    //   87: iconst_2
    //   88: invokestatic 155	java/lang/System:currentTimeMillis	()J
    //   91: lload_2
    //   92: lsub
    //   93: invokestatic 168	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   96: aastore
    //   97: invokestatic 100	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   100: aload 6
    //   102: invokestatic 174	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   105: iload 4
    //   107: ireturn
    //   108: astore 7
    //   110: aconst_null
    //   111: astore_0
    //   112: aload_0
    //   113: astore 5
    //   115: ldc 64
    //   117: aload 7
    //   119: ldc 176
    //   121: iconst_0
    //   122: anewarray 4	java/lang/Object
    //   125: invokestatic 180	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   128: aload_1
    //   129: ifnull +14 -> 143
    //   132: aload_0
    //   133: astore 5
    //   135: aload_1
    //   136: sipush 1005
    //   139: invokestatic 139	com/tencent/mm/sdk/platformtools/MMBitmapFactory$DecodeResultLogger:access$002	(Lcom/tencent/mm/sdk/platformtools/MMBitmapFactory$DecodeResultLogger;I)I
    //   142: pop
    //   143: aload_0
    //   144: invokestatic 174	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   147: iconst_0
    //   148: ireturn
    //   149: astore_0
    //   150: aconst_null
    //   151: astore 5
    //   153: aload 5
    //   155: invokestatic 174	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   158: aload_0
    //   159: athrow
    //   160: astore_0
    //   161: goto -8 -> 153
    //   164: astore 7
    //   166: aload 6
    //   168: astore_0
    //   169: goto -57 -> 112
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	172	0	paramString	String
    //   0	172	1	paramDecodeResultLogger	DecodeResultLogger
    //   49	43	2	l	long
    //   60	46	4	bool	boolean
    //   44	110	5	localObject	Object
    //   40	127	6	localBufferedInputStream	BufferedInputStream
    //   108	10	7	localFileNotFoundException1	java.io.FileNotFoundException
    //   164	1	7	localFileNotFoundException2	java.io.FileNotFoundException
    // Exception table:
    //   from	to	target	type
    //   25	42	108	java/io/FileNotFoundException
    //   25	42	149	finally
    //   46	50	160	finally
    //   54	62	160	finally
    //   66	100	160	finally
    //   115	128	160	finally
    //   135	143	160	finally
    //   46	50	164	java/io/FileNotFoundException
    //   54	62	164	java/io/FileNotFoundException
    //   66	100	164	java/io/FileNotFoundException
  }
  
  public static boolean checkIsImageLegal(byte[] paramArrayOfByte)
  {
    return checkIsImageLegal(paramArrayOfByte, null);
  }
  
  public static boolean checkIsImageLegal(byte[] paramArrayOfByte, DecodeResultLogger paramDecodeResultLogger)
  {
    if (paramArrayOfByte == null)
    {
      y.e("MicroMsg.MMBitmapFactory", "buf is null.");
      if (paramDecodeResultLogger != null) {
        DecodeResultLogger.access$002(paramDecodeResultLogger, 1005);
      }
      return false;
    }
    return checkIsImageLegalInternal(new ByteArrayInputStream(paramArrayOfByte), paramDecodeResultLogger);
  }
  
  private static boolean checkIsImageLegalInternal(InputStream paramInputStream, DecodeResultLogger paramDecodeResultLogger)
  {
    if (paramInputStream == null)
    {
      y.e("MicroMsg.MMBitmapFactory", "InputStream is null.");
      if (paramDecodeResultLogger != null) {
        DecodeResultLogger.access$002(paramDecodeResultLogger, 1005);
      }
    }
    int i;
    do
    {
      return false;
      if (!DynamicConfigStorage.getValue(DynamicConfigStorage.PREF_KEY_IS_ENABLE_MM_BITMAP_FACTORY, false)) {
        return true;
      }
      i = nativeCheckIsImageLegal(paramInputStream, new byte[8192], paramDecodeResultLogger);
    } while ((i != 0) && (i != 1006));
    return true;
  }
  
  private static void checkIsInit()
  {
    if (!mIsInit) {
      y.w("MicroMsg.MMBitmapFactory", "MMBitmapFactory is not initialized.");
    }
  }
  
  public static Bitmap decodeByteArray(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return decodeByteArray(paramArrayOfByte, paramInt1, paramInt2, null, null, 1, new int[0]);
  }
  
  public static Bitmap decodeByteArray(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    return decodeByteArray(paramArrayOfByte, paramInt1, paramInt2, null, null, paramInt3, new int[0]);
  }
  
  public static Bitmap decodeByteArray(byte[] paramArrayOfByte, int paramInt1, int paramInt2, BitmapFactory.Options paramOptions)
  {
    return decodeByteArray(paramArrayOfByte, paramInt1, paramInt2, paramOptions, null, 1, new int[0]);
  }
  
  public static Bitmap decodeByteArray(byte[] paramArrayOfByte, int paramInt1, int paramInt2, BitmapFactory.Options paramOptions, int paramInt3)
  {
    return decodeByteArray(paramArrayOfByte, paramInt1, paramInt2, paramOptions, null, paramInt3, new int[0]);
  }
  
  public static Bitmap decodeByteArray(byte[] paramArrayOfByte, int paramInt1, int paramInt2, BitmapFactory.Options paramOptions, DecodeResultLogger paramDecodeResultLogger)
  {
    return decodeByteArray(paramArrayOfByte, paramInt1, paramInt2, paramOptions, paramDecodeResultLogger, 1, new int[0]);
  }
  
  public static Bitmap decodeByteArray(byte[] paramArrayOfByte, int paramInt1, int paramInt2, BitmapFactory.Options paramOptions, DecodeResultLogger paramDecodeResultLogger, int paramInt3, int... paramVarArgs)
  {
    boolean bool = WXHardCoderJNI.hcDecodePicEnable;
    int j = WXHardCoderJNI.hcDecodePicDelay;
    int k = WXHardCoderJNI.hcDecodePicCPU;
    int m = WXHardCoderJNI.hcDecodePicIO;
    if (WXHardCoderJNI.hcDecodePicThr) {}
    for (int i = Process.myTid();; i = 0)
    {
      i = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcDecodePicTimeout, 601, WXHardCoderJNI.hcDecodePicAction, "MicroMsg.MMBitmapFactory");
      long l = System.currentTimeMillis();
      paramArrayOfByte = decodeByteArrayInternal(paramArrayOfByte, paramInt1, paramInt2, paramOptions, paramDecodeResultLogger, paramInt3, paramVarArgs);
      y.i("MicroMsg.MMBitmapFactory", "decode done, size:%d, cost:%d ms", new Object[] { Integer.valueOf(paramInt2), Long.valueOf(System.currentTimeMillis() - l) });
      WXHardCoderJNI.stopPerformace(WXHardCoderJNI.hcDecodePicEnable, i);
      return paramArrayOfByte;
    }
  }
  
  public static Bitmap decodeByteArray(byte[] paramArrayOfByte, int paramInt1, int paramInt2, DecodeResultLogger paramDecodeResultLogger)
  {
    return decodeByteArray(paramArrayOfByte, paramInt1, paramInt2, null, paramDecodeResultLogger, 1, new int[0]);
  }
  
  public static Bitmap decodeByteArray(byte[] paramArrayOfByte, int paramInt1, int paramInt2, DecodeResultLogger paramDecodeResultLogger, int paramInt3, int... paramVarArgs)
  {
    return decodeByteArray(paramArrayOfByte, paramInt1, paramInt2, null, paramDecodeResultLogger, paramInt3, paramVarArgs);
  }
  
  private static Bitmap decodeByteArrayInternal(byte[] paramArrayOfByte, int paramInt1, int paramInt2, BitmapFactory.Options paramOptions, DecodeResultLogger paramDecodeResultLogger, int paramInt3, int... paramVarArgs)
  {
    checkIsInit();
    boolean bool = DynamicConfigStorage.getValue(DynamicConfigStorage.PREF_KEY_IS_ENABLE_MM_BITMAP_FACTORY, false);
    if (bool)
    {
      switch (paramInt3)
      {
      default: 
        y.i("MicroMsg.MMBitmapFactory", "Decoded by system BitmapFactory directly, isEnabled:%b", new Object[] { Boolean.valueOf(bool) });
        return decodeByteArrayWithSystemDecoder(paramArrayOfByte, paramInt1, paramInt2, paramOptions, paramDecodeResultLogger);
      }
      return decodeByteArrayWithMMDecoderIfPossible(paramArrayOfByte, paramInt1, paramInt2, paramOptions, paramDecodeResultLogger, paramVarArgs);
    }
    y.i("MicroMsg.MMBitmapFactory", "Decoded by system BitmapFactory directly since strategy, isEnabled:%b", new Object[] { Boolean.valueOf(bool) });
    return decodeByteArrayWithSystemDecoder(paramArrayOfByte, paramInt1, paramInt2, paramOptions, paramDecodeResultLogger);
  }
  
  private static Bitmap decodeByteArrayWithMMDecoderIfPossible(byte[] paramArrayOfByte, int paramInt1, int paramInt2, BitmapFactory.Options paramOptions, DecodeResultLogger paramDecodeResultLogger, int... paramVarArgs)
  {
    if (paramDecodeResultLogger == null) {
      for (;;)
      {
        try
        {
          localObject = new DecodeResultLogger();
          paramDecodeResultLogger = (DecodeResultLogger)localObject;
        }
        catch (Exception paramArrayOfByte)
        {
          Object localObject;
          label166:
          paramVarArgs = null;
          continue;
        }
        try
        {
          localObject = nativeDecodeByteArray(paramArrayOfByte, paramInt1, paramInt2, paramOptions, paramDecodeResultLogger, paramVarArgs);
          paramVarArgs = (int[])localObject;
          try
          {
            if (paramDecodeResultLogger.mDecodeResultCode == 0) {
              continue;
            }
            paramVarArgs = (int[])localObject;
            if (paramDecodeResultLogger.mDecodeResultCode >= 2000) {
              continue;
            }
            paramVarArgs = (int[])localObject;
            y.i("MicroMsg.MMBitmapFactory", "mmimgdec decoder decodes failed, try system BitmapFactory.");
            paramVarArgs = (int[])localObject;
            DecodeResultLogger.access$102(paramDecodeResultLogger, false);
            paramVarArgs = (int[])localObject;
            localObject = BitmapFactory.decodeByteArray(paramArrayOfByte, paramInt1, paramInt2, paramOptions);
            if (localObject == null)
            {
              if (paramOptions != null)
              {
                paramVarArgs = (int[])localObject;
                if (paramOptions.inJustDecodeBounds)
                {
                  paramVarArgs = (int[])localObject;
                  if (paramOptions.outWidth >= 0)
                  {
                    paramVarArgs = (int[])localObject;
                    if (paramOptions.outHeight < 0) {}
                  }
                }
              }
            }
            else
            {
              paramVarArgs = (int[])localObject;
              y.i("MicroMsg.MMBitmapFactory", "System decoder decodes success.");
              paramVarArgs = (int[])localObject;
              DecodeResultLogger.access$002(paramDecodeResultLogger, 0);
              paramArrayOfByte = paramDecodeResultLogger;
              paramVarArgs = (int[])localObject;
              y.i("MicroMsg.MMBitmapFactory", paramArrayOfByte.toLogString());
              return paramVarArgs;
            }
            paramVarArgs = (int[])localObject;
            y.w("MicroMsg.MMBitmapFactory", "System decoder decodes failed.");
            paramVarArgs = (int[])localObject;
            DecodeResultLogger.access$002(paramDecodeResultLogger, 1006);
            paramVarArgs = (int[])localObject;
            paramArrayOfByte = paramDecodeResultLogger;
            continue;
            y.printErrStackTrace("MicroMsg.MMBitmapFactory", paramArrayOfByte, "An exception was thrown when decode image.", new Object[0]);
          }
          catch (Exception paramArrayOfByte) {}
        }
        catch (Exception paramArrayOfByte)
        {
          paramVarArgs = null;
          continue;
        }
        DecodeResultLogger.access$002(paramDecodeResultLogger, 1005);
        paramArrayOfByte = paramDecodeResultLogger;
        continue;
        paramVarArgs = (int[])localObject;
        y.i("MicroMsg.MMBitmapFactory", "decoder [%s] decodes done, ret:%d.", new Object[] { paramDecodeResultLogger.mDecoderTag, Integer.valueOf(paramDecodeResultLogger.mDecodeResultCode) });
        paramVarArgs = (int[])localObject;
        paramArrayOfByte = paramDecodeResultLogger;
        if (localObject != null)
        {
          paramArrayOfByte = (byte[])localObject;
          if (paramOptions != null)
          {
            paramVarArgs = (int[])localObject;
            paramArrayOfByte = (byte[])localObject;
            if (paramOptions.inScaled)
            {
              paramVarArgs = (int[])localObject;
              paramArrayOfByte = (byte[])localObject;
              if (!paramOptions.inJustDecodeBounds)
              {
                paramVarArgs = (int[])localObject;
                paramArrayOfByte = getScaledBitmap((Bitmap)localObject, paramOptions);
                if (paramArrayOfByte == localObject) {
                  break label387;
                }
                paramVarArgs = (int[])localObject;
                ((Bitmap)localObject).recycle();
                break label387;
              }
            }
          }
        }
      }
    }
    label387:
    for (;;)
    {
      paramVarArgs = paramArrayOfByte;
      setDensityFromOptions(paramArrayOfByte, paramOptions);
      paramVarArgs = paramArrayOfByte;
      paramArrayOfByte = paramDecodeResultLogger;
      break label166;
      break;
    }
  }
  
  private static Bitmap decodeByteArrayWithSystemDecoder(byte[] paramArrayOfByte, int paramInt1, int paramInt2, BitmapFactory.Options paramOptions, DecodeResultLogger paramDecodeResultLogger)
  {
    paramOptions = BitmapFactory.decodeByteArray(paramArrayOfByte, paramInt1, paramInt2, paramOptions);
    if (paramDecodeResultLogger != null)
    {
      paramDecodeResultLogger.clear();
      if (paramOptions != null)
      {
        paramInt1 = 0;
        DecodeResultLogger.access$002(paramDecodeResultLogger, paramInt1);
        DecodeResultLogger.access$102(paramDecodeResultLogger, false);
      }
    }
    else
    {
      if (paramOptions == null) {
        break label72;
      }
    }
    label72:
    for (paramArrayOfByte = paramOptions.toString();; paramArrayOfByte = "null")
    {
      y.i("MicroMsg.MMBitmapFactory", "decode bytearray by system decoder done, res: %s", new Object[] { paramArrayOfByte });
      return paramOptions;
      paramInt1 = 1006;
      break;
    }
  }
  
  public static Bitmap decodeFile(String paramString)
  {
    return decodeFile(paramString, null, null, 1, new int[0]);
  }
  
  public static Bitmap decodeFile(String paramString, int paramInt)
  {
    return decodeFile(paramString, null, null, paramInt, new int[0]);
  }
  
  public static Bitmap decodeFile(String paramString, BitmapFactory.Options paramOptions)
  {
    return decodeFile(paramString, paramOptions, null, 1, new int[0]);
  }
  
  public static Bitmap decodeFile(String paramString, BitmapFactory.Options paramOptions, int paramInt)
  {
    return decodeFile(paramString, paramOptions, null, paramInt, new int[0]);
  }
  
  /* Error */
  public static Bitmap decodeFile(String paramString, BitmapFactory.Options paramOptions, DecodeResultLogger paramDecodeResultLogger, int paramInt, int... paramVarArgs)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_0
    //   4: invokestatic 371	com/tencent/mm/vfs/e:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   7: astore_0
    //   8: aload_0
    //   9: aconst_null
    //   10: aload_1
    //   11: aload_2
    //   12: iload_3
    //   13: aload 4
    //   15: invokestatic 375	com/tencent/mm/sdk/platformtools/MMBitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;Lcom/tencent/mm/sdk/platformtools/MMBitmapFactory$DecodeResultLogger;I[I)Landroid/graphics/Bitmap;
    //   18: astore_1
    //   19: aload_0
    //   20: invokestatic 174	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   23: aload_1
    //   24: areturn
    //   25: astore_0
    //   26: aconst_null
    //   27: astore_0
    //   28: aload_0
    //   29: invokestatic 174	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   32: aconst_null
    //   33: areturn
    //   34: astore_0
    //   35: aload 5
    //   37: astore_1
    //   38: aload_1
    //   39: invokestatic 174	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   42: aload_0
    //   43: athrow
    //   44: astore_2
    //   45: aload_0
    //   46: astore_1
    //   47: aload_2
    //   48: astore_0
    //   49: goto -11 -> 38
    //   52: astore_1
    //   53: goto -25 -> 28
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	paramString	String
    //   0	56	1	paramOptions	BitmapFactory.Options
    //   0	56	2	paramDecodeResultLogger	DecodeResultLogger
    //   0	56	3	paramInt	int
    //   0	56	4	paramVarArgs	int[]
    //   1	35	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	8	25	java/io/FileNotFoundException
    //   3	8	34	finally
    //   8	19	44	finally
    //   8	19	52	java/io/FileNotFoundException
  }
  
  public static Bitmap decodeFile(String paramString, DecodeResultLogger paramDecodeResultLogger)
  {
    return decodeFile(paramString, null, paramDecodeResultLogger, 1, new int[0]);
  }
  
  public static Bitmap decodeFile(String paramString, DecodeResultLogger paramDecodeResultLogger, int paramInt)
  {
    return decodeFile(paramString, null, paramDecodeResultLogger, paramInt, new int[0]);
  }
  
  public static Bitmap decodeFileDescriptor(FileDescriptor paramFileDescriptor, BitmapFactory.Options paramOptions, DecodeResultLogger paramDecodeResultLogger)
  {
    Object localObject2 = null;
    if (!checkIfHaveToUseMMDecoder(paramOptions)) {}
    for (;;)
    {
      try
      {
        Bitmap localBitmap = BitmapFactory.decodeFileDescriptor(paramFileDescriptor, null, paramOptions);
        if (localBitmap == null) {
          break;
        }
        if (paramDecodeResultLogger != null)
        {
          paramDecodeResultLogger.clear();
          DecodeResultLogger.access$002(paramDecodeResultLogger, 0);
          DecodeResultLogger.access$102(paramDecodeResultLogger, false);
        }
        return localBitmap;
      }
      catch (Exception localException)
      {
        y.printErrStackTrace("MicroMsg.MMBitmapFactory", localException, "", new Object[0]);
      }
      Object localObject1 = null;
    }
    y.d("MicroMsg.MMBitmapFactory", "decodeFileDescriptor, fallback");
    try
    {
      paramFileDescriptor = new FileInputStream(paramFileDescriptor);
      bk.b(paramOptions);
    }
    finally
    {
      try
      {
        paramOptions = decodeStream(paramFileDescriptor, null, paramOptions, paramDecodeResultLogger, 0, new int[0]);
        bk.b(paramFileDescriptor);
        return paramOptions;
      }
      finally
      {
        paramOptions = paramFileDescriptor;
        paramFileDescriptor = paramDecodeResultLogger;
      }
      paramFileDescriptor = finally;
      paramOptions = localObject2;
    }
    throw paramFileDescriptor;
  }
  
  /* Error */
  public static Bitmap decodeRegion(FileDescriptor paramFileDescriptor, Rect paramRect, BitmapFactory.Options paramOptions, DecodeResultLogger paramDecodeResultLogger)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aload_2
    //   4: invokestatic 381	com/tencent/mm/sdk/platformtools/MMBitmapFactory:checkIfHaveToUseMMDecoder	(Landroid/graphics/BitmapFactory$Options;)Z
    //   7: ifne +181 -> 188
    //   10: aload_0
    //   11: iconst_1
    //   12: invokestatic 401	android/graphics/BitmapRegionDecoder:newInstance	(Ljava/io/FileDescriptor;Z)Landroid/graphics/BitmapRegionDecoder;
    //   15: astore 4
    //   17: aload 4
    //   19: astore 5
    //   21: aload 4
    //   23: aload_1
    //   24: aload_2
    //   25: invokevirtual 404	android/graphics/BitmapRegionDecoder:decodeRegion	(Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   28: astore 6
    //   30: aload 6
    //   32: astore 5
    //   34: aload 4
    //   36: ifnull +12 -> 48
    //   39: aload 4
    //   41: invokevirtual 405	android/graphics/BitmapRegionDecoder:recycle	()V
    //   44: aload 6
    //   46: astore 5
    //   48: aload 5
    //   50: ifnull +80 -> 130
    //   53: aload_3
    //   54: ifnull +19 -> 73
    //   57: aload_3
    //   58: invokevirtual 350	com/tencent/mm/sdk/platformtools/MMBitmapFactory$DecodeResultLogger:clear	()V
    //   61: aload_3
    //   62: iconst_0
    //   63: invokestatic 139	com/tencent/mm/sdk/platformtools/MMBitmapFactory$DecodeResultLogger:access$002	(Lcom/tencent/mm/sdk/platformtools/MMBitmapFactory$DecodeResultLogger;I)I
    //   66: pop
    //   67: aload_3
    //   68: iconst_0
    //   69: invokestatic 303	com/tencent/mm/sdk/platformtools/MMBitmapFactory$DecodeResultLogger:access$102	(Lcom/tencent/mm/sdk/platformtools/MMBitmapFactory$DecodeResultLogger;Z)Z
    //   72: pop
    //   73: aload 5
    //   75: areturn
    //   76: astore 6
    //   78: aconst_null
    //   79: astore 4
    //   81: aload 4
    //   83: astore 5
    //   85: ldc 64
    //   87: aload 6
    //   89: ldc 116
    //   91: iconst_0
    //   92: anewarray 4	java/lang/Object
    //   95: invokestatic 180	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   98: aload 4
    //   100: ifnull +88 -> 188
    //   103: aload 4
    //   105: invokevirtual 405	android/graphics/BitmapRegionDecoder:recycle	()V
    //   108: aconst_null
    //   109: astore 5
    //   111: goto -63 -> 48
    //   114: astore_0
    //   115: aconst_null
    //   116: astore 5
    //   118: aload 5
    //   120: ifnull +8 -> 128
    //   123: aload 5
    //   125: invokevirtual 405	android/graphics/BitmapRegionDecoder:recycle	()V
    //   128: aload_0
    //   129: athrow
    //   130: ldc 64
    //   132: ldc_w 407
    //   135: invokestatic 388	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   138: new 390	java/io/FileInputStream
    //   141: dup
    //   142: aload_0
    //   143: invokespecial 393	java/io/FileInputStream:<init>	(Ljava/io/FileDescriptor;)V
    //   146: astore_0
    //   147: aload_0
    //   148: aload_1
    //   149: aload_2
    //   150: aload_3
    //   151: invokestatic 411	com/tencent/mm/sdk/platformtools/MMBitmapFactory:decodeRegionFallback	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;Lcom/tencent/mm/sdk/platformtools/MMBitmapFactory$DecodeResultLogger;)Landroid/graphics/Bitmap;
    //   154: astore_1
    //   155: aload_0
    //   156: invokestatic 174	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   159: aload_1
    //   160: areturn
    //   161: astore_0
    //   162: aload 7
    //   164: astore_1
    //   165: aload_1
    //   166: invokestatic 174	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   169: aload_0
    //   170: athrow
    //   171: astore_2
    //   172: aload_0
    //   173: astore_1
    //   174: aload_2
    //   175: astore_0
    //   176: goto -11 -> 165
    //   179: astore_0
    //   180: goto -62 -> 118
    //   183: astore 6
    //   185: goto -104 -> 81
    //   188: aconst_null
    //   189: astore 5
    //   191: goto -143 -> 48
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	194	0	paramFileDescriptor	FileDescriptor
    //   0	194	1	paramRect	Rect
    //   0	194	2	paramOptions	BitmapFactory.Options
    //   0	194	3	paramDecodeResultLogger	DecodeResultLogger
    //   15	89	4	localBitmapRegionDecoder	android.graphics.BitmapRegionDecoder
    //   19	171	5	localObject1	Object
    //   28	17	6	localBitmap	Bitmap
    //   76	12	6	localException1	Exception
    //   183	1	6	localException2	Exception
    //   1	162	7	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   10	17	76	java/lang/Exception
    //   10	17	114	finally
    //   138	147	161	finally
    //   147	155	171	finally
    //   21	30	179	finally
    //   85	98	179	finally
    //   21	30	183	java/lang/Exception
  }
  
  /* Error */
  public static Bitmap decodeRegion(InputStream paramInputStream, Rect paramRect, BitmapFactory.Options paramOptions, DecodeResultLogger paramDecodeResultLogger)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokestatic 381	com/tencent/mm/sdk/platformtools/MMBitmapFactory:checkIfHaveToUseMMDecoder	(Landroid/graphics/BitmapFactory$Options;)Z
    //   4: ifne +144 -> 148
    //   7: aload_0
    //   8: iconst_1
    //   9: invokestatic 414	android/graphics/BitmapRegionDecoder:newInstance	(Ljava/io/InputStream;Z)Landroid/graphics/BitmapRegionDecoder;
    //   12: astore 5
    //   14: aload 5
    //   16: astore 4
    //   18: aload 5
    //   20: aload_1
    //   21: aload_2
    //   22: invokevirtual 404	android/graphics/BitmapRegionDecoder:decodeRegion	(Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   25: astore 6
    //   27: aload 5
    //   29: ifnull +125 -> 154
    //   32: aload 5
    //   34: invokevirtual 405	android/graphics/BitmapRegionDecoder:recycle	()V
    //   37: aload 6
    //   39: astore 4
    //   41: aload 4
    //   43: ifnull +80 -> 123
    //   46: aload_3
    //   47: ifnull +19 -> 66
    //   50: aload_3
    //   51: invokevirtual 350	com/tencent/mm/sdk/platformtools/MMBitmapFactory$DecodeResultLogger:clear	()V
    //   54: aload_3
    //   55: iconst_0
    //   56: invokestatic 139	com/tencent/mm/sdk/platformtools/MMBitmapFactory$DecodeResultLogger:access$002	(Lcom/tencent/mm/sdk/platformtools/MMBitmapFactory$DecodeResultLogger;I)I
    //   59: pop
    //   60: aload_3
    //   61: iconst_0
    //   62: invokestatic 303	com/tencent/mm/sdk/platformtools/MMBitmapFactory$DecodeResultLogger:access$102	(Lcom/tencent/mm/sdk/platformtools/MMBitmapFactory$DecodeResultLogger;Z)Z
    //   65: pop
    //   66: aload 4
    //   68: areturn
    //   69: astore 6
    //   71: aconst_null
    //   72: astore 5
    //   74: aload 5
    //   76: astore 4
    //   78: ldc 64
    //   80: aload 6
    //   82: ldc 116
    //   84: iconst_0
    //   85: anewarray 4	java/lang/Object
    //   88: invokestatic 180	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   91: aload 5
    //   93: ifnull +55 -> 148
    //   96: aload 5
    //   98: invokevirtual 405	android/graphics/BitmapRegionDecoder:recycle	()V
    //   101: aconst_null
    //   102: astore 4
    //   104: goto -63 -> 41
    //   107: astore_0
    //   108: aconst_null
    //   109: astore 4
    //   111: aload 4
    //   113: ifnull +8 -> 121
    //   116: aload 4
    //   118: invokevirtual 405	android/graphics/BitmapRegionDecoder:recycle	()V
    //   121: aload_0
    //   122: athrow
    //   123: ldc 64
    //   125: ldc_w 416
    //   128: invokestatic 388	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   131: aload_0
    //   132: aload_1
    //   133: aload_2
    //   134: aload_3
    //   135: invokestatic 411	com/tencent/mm/sdk/platformtools/MMBitmapFactory:decodeRegionFallback	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;Lcom/tencent/mm/sdk/platformtools/MMBitmapFactory$DecodeResultLogger;)Landroid/graphics/Bitmap;
    //   138: areturn
    //   139: astore_0
    //   140: goto -29 -> 111
    //   143: astore 6
    //   145: goto -71 -> 74
    //   148: aconst_null
    //   149: astore 4
    //   151: goto -110 -> 41
    //   154: aload 6
    //   156: astore 4
    //   158: goto -117 -> 41
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	161	0	paramInputStream	InputStream
    //   0	161	1	paramRect	Rect
    //   0	161	2	paramOptions	BitmapFactory.Options
    //   0	161	3	paramDecodeResultLogger	DecodeResultLogger
    //   16	141	4	localObject	Object
    //   12	85	5	localBitmapRegionDecoder	android.graphics.BitmapRegionDecoder
    //   25	13	6	localBitmap	Bitmap
    //   69	12	6	localException1	Exception
    //   143	12	6	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   7	14	69	java/lang/Exception
    //   7	14	107	finally
    //   18	27	139	finally
    //   78	91	139	finally
    //   18	27	143	java/lang/Exception
  }
  
  /* Error */
  public static Bitmap decodeRegion(byte[] paramArrayOfByte, int paramInt1, int paramInt2, Rect paramRect, BitmapFactory.Options paramOptions, DecodeResultLogger paramDecodeResultLogger)
  {
    // Byte code:
    //   0: aload 4
    //   2: invokestatic 381	com/tencent/mm/sdk/platformtools/MMBitmapFactory:checkIfHaveToUseMMDecoder	(Landroid/graphics/BitmapFactory$Options;)Z
    //   5: ifne +155 -> 160
    //   8: aload_0
    //   9: iload_1
    //   10: iload_2
    //   11: iconst_1
    //   12: invokestatic 420	android/graphics/BitmapRegionDecoder:newInstance	([BIIZ)Landroid/graphics/BitmapRegionDecoder;
    //   15: astore 7
    //   17: aload 7
    //   19: astore 6
    //   21: aload 7
    //   23: aload_3
    //   24: aload 4
    //   26: invokevirtual 404	android/graphics/BitmapRegionDecoder:decodeRegion	(Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   29: astore 8
    //   31: aload 7
    //   33: ifnull +133 -> 166
    //   36: aload 7
    //   38: invokevirtual 405	android/graphics/BitmapRegionDecoder:recycle	()V
    //   41: aload 8
    //   43: astore 6
    //   45: aload 6
    //   47: ifnull +84 -> 131
    //   50: aload 5
    //   52: ifnull +22 -> 74
    //   55: aload 5
    //   57: invokevirtual 350	com/tencent/mm/sdk/platformtools/MMBitmapFactory$DecodeResultLogger:clear	()V
    //   60: aload 5
    //   62: iconst_0
    //   63: invokestatic 139	com/tencent/mm/sdk/platformtools/MMBitmapFactory$DecodeResultLogger:access$002	(Lcom/tencent/mm/sdk/platformtools/MMBitmapFactory$DecodeResultLogger;I)I
    //   66: pop
    //   67: aload 5
    //   69: iconst_0
    //   70: invokestatic 303	com/tencent/mm/sdk/platformtools/MMBitmapFactory$DecodeResultLogger:access$102	(Lcom/tencent/mm/sdk/platformtools/MMBitmapFactory$DecodeResultLogger;Z)Z
    //   73: pop
    //   74: aload 6
    //   76: areturn
    //   77: astore 8
    //   79: aconst_null
    //   80: astore 7
    //   82: aload 7
    //   84: astore 6
    //   86: ldc 64
    //   88: aload 8
    //   90: ldc 116
    //   92: iconst_0
    //   93: anewarray 4	java/lang/Object
    //   96: invokestatic 180	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   99: aload 7
    //   101: ifnull +59 -> 160
    //   104: aload 7
    //   106: invokevirtual 405	android/graphics/BitmapRegionDecoder:recycle	()V
    //   109: aconst_null
    //   110: astore 6
    //   112: goto -67 -> 45
    //   115: astore_0
    //   116: aconst_null
    //   117: astore 6
    //   119: aload 6
    //   121: ifnull +8 -> 129
    //   124: aload 6
    //   126: invokevirtual 405	android/graphics/BitmapRegionDecoder:recycle	()V
    //   129: aload_0
    //   130: athrow
    //   131: ldc 64
    //   133: ldc_w 422
    //   136: invokestatic 388	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   139: aload_0
    //   140: iload_1
    //   141: iload_2
    //   142: aload_3
    //   143: aload 4
    //   145: aload 5
    //   147: invokestatic 424	com/tencent/mm/sdk/platformtools/MMBitmapFactory:decodeRegionFallback	([BIILandroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;Lcom/tencent/mm/sdk/platformtools/MMBitmapFactory$DecodeResultLogger;)Landroid/graphics/Bitmap;
    //   150: areturn
    //   151: astore_0
    //   152: goto -33 -> 119
    //   155: astore 8
    //   157: goto -75 -> 82
    //   160: aconst_null
    //   161: astore 6
    //   163: goto -118 -> 45
    //   166: aload 8
    //   168: astore 6
    //   170: goto -125 -> 45
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	173	0	paramArrayOfByte	byte[]
    //   0	173	1	paramInt1	int
    //   0	173	2	paramInt2	int
    //   0	173	3	paramRect	Rect
    //   0	173	4	paramOptions	BitmapFactory.Options
    //   0	173	5	paramDecodeResultLogger	DecodeResultLogger
    //   19	150	6	localObject	Object
    //   15	90	7	localBitmapRegionDecoder	android.graphics.BitmapRegionDecoder
    //   29	13	8	localBitmap	Bitmap
    //   77	12	8	localException1	Exception
    //   155	12	8	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   8	17	77	java/lang/Exception
    //   8	17	115	finally
    //   21	31	151	finally
    //   86	99	151	finally
    //   21	31	155	java/lang/Exception
  }
  
  private static Bitmap decodeRegionFallback(InputStream paramInputStream, Rect paramRect, BitmapFactory.Options paramOptions, DecodeResultLogger paramDecodeResultLogger)
  {
    Object localObject = null;
    paramOptions = decodeStream(paramInputStream, null, paramOptions, paramDecodeResultLogger, 0, new int[0]);
    paramInputStream = localObject;
    if (paramOptions != null)
    {
      paramRect = Bitmap.createBitmap(paramOptions, paramRect.left, paramRect.top, paramRect.right - paramRect.left, paramRect.bottom - paramRect.top);
      paramInputStream = paramRect;
      if (paramRect != paramOptions)
      {
        paramOptions.recycle();
        paramInputStream = paramRect;
      }
    }
    return paramInputStream;
  }
  
  private static Bitmap decodeRegionFallback(byte[] paramArrayOfByte, int paramInt1, int paramInt2, Rect paramRect, BitmapFactory.Options paramOptions, DecodeResultLogger paramDecodeResultLogger)
  {
    paramArrayOfByte = decodeByteArray(paramArrayOfByte, paramInt1, paramInt2, paramOptions, paramDecodeResultLogger, 0, new int[0]);
    if (paramArrayOfByte != null)
    {
      paramRect = Bitmap.createBitmap(paramArrayOfByte, paramRect.left, paramRect.top, paramRect.right - paramRect.left, paramRect.bottom - paramRect.top);
      if (paramRect != paramArrayOfByte) {
        paramArrayOfByte.recycle();
      }
      return paramRect;
    }
    return null;
  }
  
  public static Bitmap decodeStream(InputStream paramInputStream)
  {
    return decodeStream(paramInputStream, null, null, null, 1, new int[0]);
  }
  
  public static Bitmap decodeStream(InputStream paramInputStream, int paramInt)
  {
    return decodeStream(paramInputStream, null, null, null, paramInt, new int[0]);
  }
  
  public static Bitmap decodeStream(InputStream paramInputStream, Rect paramRect, BitmapFactory.Options paramOptions)
  {
    return decodeStream(paramInputStream, paramRect, paramOptions, null, 1, new int[0]);
  }
  
  public static Bitmap decodeStream(InputStream paramInputStream, Rect paramRect, BitmapFactory.Options paramOptions, int paramInt)
  {
    return decodeStream(paramInputStream, paramRect, paramOptions, null, paramInt, new int[0]);
  }
  
  public static Bitmap decodeStream(InputStream paramInputStream, Rect paramRect, BitmapFactory.Options paramOptions, DecodeResultLogger paramDecodeResultLogger, int paramInt, int... paramVarArgs)
  {
    boolean bool = WXHardCoderJNI.hcDecodePicEnable;
    int j = WXHardCoderJNI.hcDecodePicDelay;
    int k = WXHardCoderJNI.hcDecodePicCPU;
    int m = WXHardCoderJNI.hcDecodePicIO;
    if (WXHardCoderJNI.hcDecodePicThr) {}
    for (int i = Process.myTid();; i = 0)
    {
      i = WXHardCoderJNI.startPerformance(bool, j, k, m, i, WXHardCoderJNI.hcDecodePicTimeout, 601, WXHardCoderJNI.hcDecodePicAction, "MicroMsg.MMBitmapFactory");
      long l2 = System.currentTimeMillis();
      try
      {
        j = paramInputStream.available();
        l1 = j;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          long l1 = -1L;
          continue;
          paramInputStream = paramRect.toString();
        }
      }
      paramRect = decodeStreamInternal(paramInputStream, paramRect, paramOptions, paramDecodeResultLogger, paramInt, paramVarArgs);
      if (paramRect != null) {
        break;
      }
      paramInputStream = "null";
      y.i("MicroMsg.MMBitmapFactory", "[%s]decode done, size:%d, cost:%d ms", new Object[] { paramInputStream, Long.valueOf(l1), Long.valueOf(System.currentTimeMillis() - l2) });
      WXHardCoderJNI.stopPerformace(WXHardCoderJNI.hcDecodePicEnable, i);
      return paramRect;
    }
  }
  
  public static Bitmap decodeStream(InputStream paramInputStream, DecodeResultLogger paramDecodeResultLogger)
  {
    return decodeStream(paramInputStream, null, null, paramDecodeResultLogger, 1, new int[0]);
  }
  
  public static Bitmap decodeStream(InputStream paramInputStream, DecodeResultLogger paramDecodeResultLogger, int paramInt, int... paramVarArgs)
  {
    return decodeStream(paramInputStream, null, null, paramDecodeResultLogger, paramInt, paramVarArgs);
  }
  
  private static Bitmap decodeStreamInternal(InputStream paramInputStream, Rect paramRect, BitmapFactory.Options paramOptions, DecodeResultLogger paramDecodeResultLogger, int paramInt, int... paramVarArgs)
  {
    checkIsInit();
    boolean bool = DynamicConfigStorage.getValue(DynamicConfigStorage.PREF_KEY_IS_ENABLE_MM_BITMAP_FACTORY, false);
    if ((bool) && (!(paramInputStream instanceof AssetManager.AssetInputStream))) {
      switch (paramInt)
      {
      default: 
        y.i("MicroMsg.MMBitmapFactory", "Decoded by system BitmapFactory directly, isEnabled:%b", new Object[] { Boolean.valueOf(bool) });
        paramInputStream = decodeStreamWithSystemDecoder(paramInputStream, paramRect, paramOptions, paramDecodeResultLogger);
      }
    }
    for (;;)
    {
      paramRect = an.ufL;
      an.crm();
      return paramInputStream;
      paramInputStream = decodeStreamWithMMDecoderIfPossible(paramInputStream, paramRect, paramOptions, paramDecodeResultLogger, paramVarArgs);
      continue;
      y.i("MicroMsg.MMBitmapFactory", "Decoded by system BitmapFactory directly, isEnabled:%b", new Object[] { Boolean.valueOf(bool) });
      paramInputStream = decodeStreamWithSystemDecoder(paramInputStream, paramRect, paramOptions, paramDecodeResultLogger);
    }
  }
  
  private static Bitmap decodeStreamWithMMDecoderIfPossible(InputStream paramInputStream, Rect paramRect, BitmapFactory.Options paramOptions, DecodeResultLogger paramDecodeResultLogger, int... paramVarArgs)
  {
    Object localObject1;
    if (paramOptions != null)
    {
      localObject1 = paramOptions.inTempStorage;
      Object localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = new byte[8192];
      }
      if (!paramInputStream.markSupported())
      {
        if ((paramInputStream instanceof FileInputStream)) {
          localObject1 = new i((FileInputStream)paramInputStream);
        }
        for (;;)
        {
          try
          {
            label53:
            ((InputStream)localObject1).mark(8388608);
            if (paramDecodeResultLogger != null) {
              continue;
            }
            paramInputStream = new DecodeResultLogger();
            paramDecodeResultLogger = paramInputStream;
          }
          catch (IOException paramRect)
          {
            label215:
            paramInputStream = null;
            y.printErrStackTrace("MicroMsg.MMBitmapFactory", paramRect, "An exception was thrown when decode image.", new Object[0]);
            DecodeResultLogger.access$002(paramDecodeResultLogger, 1005);
            continue;
            continue;
          }
          try
          {
            paramVarArgs = nativeDecodeStream((InputStream)localObject1, (byte[])localObject2, paramRect, paramOptions, paramDecodeResultLogger, paramVarArgs);
            paramInputStream = paramVarArgs;
          }
          catch (IOException paramRect)
          {
            paramInputStream = null;
            continue;
          }
          try
          {
            if (paramDecodeResultLogger.mDecodeResultCode != 0)
            {
              paramInputStream = paramVarArgs;
              if (paramDecodeResultLogger.mDecodeResultCode < 2000)
              {
                paramInputStream = paramVarArgs;
                y.i("MicroMsg.MMBitmapFactory", "mmimgdec decoder decodes failed, try system BitmapFactory.");
                paramInputStream = paramVarArgs;
                DecodeResultLogger.access$102(paramDecodeResultLogger, false);
                paramInputStream = paramVarArgs;
                ((InputStream)localObject1).reset();
                paramInputStream = paramVarArgs;
                ((InputStream)localObject1).mark(8388608);
                paramInputStream = paramVarArgs;
                paramRect = BitmapFactory.decodeStream((InputStream)localObject1, paramRect, paramOptions);
                if (paramRect == null)
                {
                  if (paramOptions != null)
                  {
                    paramInputStream = paramRect;
                    if (paramOptions.inJustDecodeBounds)
                    {
                      paramInputStream = paramRect;
                      if (paramOptions.outWidth >= 0)
                      {
                        paramInputStream = paramRect;
                        if (paramOptions.outHeight < 0) {}
                      }
                    }
                  }
                }
                else
                {
                  paramInputStream = paramRect;
                  y.i("MicroMsg.MMBitmapFactory", "System decoder decodes success.");
                  paramInputStream = paramRect;
                  DecodeResultLogger.access$002(paramDecodeResultLogger, 0);
                  paramInputStream = paramRect;
                }
              }
            }
          }
          catch (IOException paramRect)
          {
            continue;
          }
          try
          {
            ((InputStream)localObject1).reset();
            ((InputStream)localObject1).mark(8388608);
            y.i("MicroMsg.MMBitmapFactory", paramDecodeResultLogger.toLogString());
            return paramInputStream;
          }
          catch (IOException paramRect)
          {
            continue;
          }
          localObject1 = new BufferedInputStream(paramInputStream);
          continue;
          paramInputStream = paramRect;
          y.w("MicroMsg.MMBitmapFactory", "System decoder decodes failed.");
          paramInputStream = paramRect;
          DecodeResultLogger.access$002(paramDecodeResultLogger, 1006);
          paramInputStream = paramRect;
          continue;
          paramInputStream = paramVarArgs;
          y.i("MicroMsg.MMBitmapFactory", "decoder [%s] decodes done, ret:%d.", new Object[] { paramDecodeResultLogger.mDecoderTag, Integer.valueOf(paramDecodeResultLogger.mDecodeResultCode) });
          paramRect = paramVarArgs;
          if (paramVarArgs != null)
          {
            paramRect = paramVarArgs;
            if (paramOptions != null)
            {
              paramRect = paramVarArgs;
              paramInputStream = paramVarArgs;
              if (paramOptions.inScaled)
              {
                paramRect = paramVarArgs;
                paramInputStream = paramVarArgs;
                if (!paramOptions.inJustDecodeBounds)
                {
                  paramInputStream = paramVarArgs;
                  paramRect = getScaledBitmap(paramVarArgs, paramOptions);
                  if (paramRect == paramVarArgs) {
                    break label444;
                  }
                  paramInputStream = paramVarArgs;
                  paramVarArgs.recycle();
                  break label444;
                }
              }
            }
          }
        }
      }
    }
    label444:
    for (;;)
    {
      paramInputStream = paramRect;
      setDensityFromOptions(paramRect, paramOptions);
      paramInputStream = paramRect;
      break label215;
      localObject1 = paramInputStream;
      break label53;
      localObject1 = null;
      break;
    }
  }
  
  private static Bitmap decodeStreamWithSystemDecoder(InputStream paramInputStream, Rect paramRect, BitmapFactory.Options paramOptions, DecodeResultLogger paramDecodeResultLogger)
  {
    int i = 1006;
    paramRect = BitmapFactory.decodeStream(paramInputStream, paramRect, paramOptions);
    if (paramDecodeResultLogger != null)
    {
      paramDecodeResultLogger.clear();
      if ((paramOptions == null) || (!paramOptions.inJustDecodeBounds))
      {
        if (paramRect != null) {
          i = 0;
        }
        DecodeResultLogger.access$002(paramDecodeResultLogger, i);
        DecodeResultLogger.access$102(paramDecodeResultLogger, false);
      }
    }
    else
    {
      if (paramRect == null) {
        break label113;
      }
    }
    label113:
    for (paramInputStream = paramRect.toString();; paramInputStream = "null")
    {
      y.i("MicroMsg.MMBitmapFactory", "decode stream by system decoder done, res: %s", new Object[] { paramInputStream });
      return paramRect;
      int j = i;
      if (paramOptions.outWidth >= 0)
      {
        j = i;
        if (paramOptions.outHeight >= 0) {
          j = 0;
        }
      }
      DecodeResultLogger.access$002(paramDecodeResultLogger, j);
      break;
    }
  }
  
  private static Bitmap getScaledBitmap(Bitmap paramBitmap, BitmapFactory.Options paramOptions)
  {
    int i = paramOptions.inDensity;
    int j = paramOptions.inTargetDensity;
    int k = paramOptions.inScreenDensity;
    if ((i != 0) && (j != 0) && (i != k)) {}
    for (float f = j / i;; f = 1.0F)
    {
      if (f != 1.0F) {}
      for (i = 1;; i = 0)
      {
        paramOptions = paramBitmap;
        if (i != 0) {
          paramOptions = Bitmap.createScaledBitmap(paramBitmap, (int)(paramBitmap.getWidth() * f + 0.5F), (int)(f * paramBitmap.getHeight() + 0.5F), true);
        }
        return paramOptions;
      }
    }
  }
  
  public static boolean init()
  {
    if (n.yY()) {
      com.tencent.mm.compatible.loader.d.v(ae.getContext(), "libvoipCodec_v7a.so");
    }
    try
    {
      mIsInit = nativeInit(new String[] { new File(ae.getContext().getDir("lib", 0), "libvoipCodec_v7a.so").getAbsolutePath() });
      if (!mIsInit)
      {
        DynamicConfigStorage.setValue(DynamicConfigStorage.PREF_KEY_IS_ENABLE_MM_BITMAP_FACTORY, false);
        y.w("MicroMsg.MMBitmapFactory", "MMBitmapFactory initialize failed, force use system BitmapFactory instead.");
      }
      return mIsInit;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.MMBitmapFactory", localThrowable, "", new Object[0]);
        if (!com.tencent.mm.compatible.util.d.gG(20)) {
          break;
        }
        mIsInit = nativeInit(new String[] { new File(ae.getContext().getDir("lib", 0), "libvoipCodec_v7a.so").getAbsolutePath() });
      }
      throw localThrowable;
    }
  }
  
  private static native int nativeCheckIsImageLegal(InputStream paramInputStream, byte[] paramArrayOfByte, DecodeResultLogger paramDecodeResultLogger);
  
  private static native Bitmap nativeDecodeByteArray(byte[] paramArrayOfByte, int paramInt1, int paramInt2, BitmapFactory.Options paramOptions, DecodeResultLogger paramDecodeResultLogger, int... paramVarArgs);
  
  private static native Bitmap nativeDecodeStream(InputStream paramInputStream, byte[] paramArrayOfByte, Rect paramRect, BitmapFactory.Options paramOptions, DecodeResultLogger paramDecodeResultLogger, int... paramVarArgs);
  
  private static native boolean nativeInit(String... paramVarArgs);
  
  private static native int nativePinBitmap(Bitmap paramBitmap);
  
  private static native boolean nativeSwitchDecoder(int paramInt, boolean paramBoolean);
  
  private static native int nativeUnPinBitmap(Bitmap paramBitmap);
  
  public static Bitmap pinBitmap(Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()) && (nativePinBitmap(paramBitmap) < 0)) {
      y.e("MicroMsg.MMBitmapFactory", "pinBitmap failed");
    }
    return paramBitmap;
  }
  
  private static void setDensityFromOptions(Bitmap paramBitmap, BitmapFactory.Options paramOptions)
  {
    int i = 1;
    if ((paramBitmap == null) || (paramOptions == null)) {}
    do
    {
      for (;;)
      {
        return;
        int k = paramOptions.inDensity;
        if (k == 0) {
          break;
        }
        paramBitmap.setDensity(k);
        int j = paramOptions.inTargetDensity;
        if ((j != 0) && (k != j) && (k != paramOptions.inScreenDensity))
        {
          byte[] arrayOfByte = paramBitmap.getNinePatchChunk();
          if ((arrayOfByte != null) && (NinePatch.isNinePatchChunk(arrayOfByte))) {}
          while ((paramOptions.inScaled) || (i != 0))
          {
            paramBitmap.setDensity(j);
            return;
            i = 0;
          }
        }
      }
    } while (paramOptions.inBitmap == null);
    try
    {
      if (mMthGetDefaultDensity == null)
      {
        paramOptions = Bitmap.class.getDeclaredMethod("getDefaultDensity", null);
        mMthGetDefaultDensity = paramOptions;
        paramOptions.setAccessible(true);
      }
      paramBitmap.setDensity(((Integer)mMthGetDefaultDensity.invoke(null, new Object[0])).intValue());
      return;
    }
    catch (Exception paramOptions)
    {
      paramBitmap.setDensity(160);
    }
  }
  
  public static void setUseMMBitmapFactory(boolean paramBoolean)
  {
    if (mIsInit)
    {
      DynamicConfigStorage.setValue(DynamicConfigStorage.PREF_KEY_IS_ENABLE_MM_BITMAP_FACTORY, paramBoolean);
      if (!paramBoolean) {
        y.i("MicroMsg.MMBitmapFactory", "MMBitmapFactory is switched off, use system BitmapFactory directly.");
      }
    }
  }
  
  public static boolean switchDecoder(int paramInt, boolean paramBoolean)
  {
    return nativeSwitchDecoder(paramInt, paramBoolean);
  }
  
  public static Bitmap unPinBitmap(Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()) && (nativeUnPinBitmap(paramBitmap) < 0)) {
      y.e("MicroMsg.MMBitmapFactory", "unpinBitmap failed");
    }
    return paramBitmap;
  }
  
  public static class DecodeResultLogger
  {
    private int mDecodeResultCode;
    private String mDecoderTag = null;
    private boolean mIsDecodeByMMDecoder;
    
    public DecodeResultLogger()
    {
      clear();
    }
    
    private void fillerForNative(int paramInt, boolean paramBoolean, String paramString)
    {
      this.mDecodeResultCode = paramInt;
      this.mIsDecodeByMMDecoder = paramBoolean;
      String str;
      if (paramString != null)
      {
        str = paramString;
        if (paramString.length() != 0) {}
      }
      else
      {
        str = "System";
      }
      this.mDecoderTag = str;
    }
    
    public void clear()
    {
      this.mDecodeResultCode = 0;
      this.mIsDecodeByMMDecoder = false;
      this.mDecoderTag = "System";
    }
    
    public int getDecodeResult()
    {
      return this.mDecodeResultCode;
    }
    
    public String getDecoderTag()
    {
      return this.mDecoderTag;
    }
    
    public boolean isDecodeByMMDecoder()
    {
      return this.mIsDecodeByMMDecoder;
    }
    
    public void setDecodeResult(int paramInt)
    {
      this.mDecodeResultCode = paramInt;
    }
    
    public String toLogString()
    {
      return this.mDecodeResultCode + "," + this.mIsDecodeByMMDecoder + "," + this.mDecoderTag + "," + "-";
    }
    
    public String toString()
    {
      return "{" + this.mDecodeResultCode + "," + this.mIsDecodeByMMDecoder + "," + this.mDecoderTag + "}";
    }
  }
  
  private static class DynamicConfigStorage
  {
    public static String PREF_KEY_IS_ENABLE_MM_BITMAP_FACTORY = "pref_key_is_enable_MMBitmapFactory";
    private static final String PREF_NAME = "pref_MMBitmapFactory_dyncfg";
    private static SharedPreferences mPref = ap.l(ae.getContext(), "pref_MMBitmapFactory_dyncfg", 4);
    
    public static boolean getValue(String paramString, boolean paramBoolean)
    {
      
      if (mPref == null)
      {
        y.w("MicroMsg.MMBitmapFactory", "SharedPreferences in DynamicConfigStorage initialize failed.");
        return paramBoolean;
      }
      paramBoolean = mPref.getBoolean(paramString, paramBoolean);
      y.d("MicroMsg.MMBitmapFactory", "DynamicConfigStorage, getValue:%b", new Object[] { Boolean.valueOf(paramBoolean) });
      return paramBoolean;
    }
    
    private static void reload()
    {
      mPref = ap.l(ae.getContext(), "pref_MMBitmapFactory_dyncfg", 4);
    }
    
    public static void setValue(String paramString, boolean paramBoolean)
    {
      if (mPref == null)
      {
        y.w("MicroMsg.MMBitmapFactory", "SharedPreferences in DynamicConfigStorage initialize failed.");
        return;
      }
      SharedPreferences.Editor localEditor = mPref.edit();
      localEditor.putBoolean(paramString, paramBoolean);
      localEditor.commit();
    }
  }
  
  public static class HEVCKVStatHelper
  {
    private static final String KVSTAT_STRING_SEPERATOR = ",";
    public static final int SCENE_SNS = 0;
    private static final long STAT_INTERVAL = 60000L;
    private static long mLastStatTick = 0L;
    
    public static String getKVStatString(Object paramObject, int paramInt, long paramLong, BitmapFactory.Options paramOptions, MMBitmapFactory.DecodeResultLogger paramDecodeResultLogger)
    {
      StringBuilder localStringBuilder = new StringBuilder(128);
      long l2 = -1L;
      long l1;
      if ((paramObject instanceof File))
      {
        paramObject = (File)paramObject;
        l1 = l2;
        if (paramObject.exists())
        {
          l1 = l2;
          if (paramObject.isFile()) {
            l1 = paramObject.length();
          }
        }
      }
      for (;;)
      {
        localStringBuilder.append(paramInt).append(",").append(paramDecodeResultLogger.mDecodeResultCode).append(",").append(l1).append(",").append(paramLong).append(",").append(bk.pm(paramOptions.outMimeType));
        return localStringBuilder.toString();
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          l1 = l2;
          if (paramObject.exists())
          {
            l1 = l2;
            if (paramObject.isFile()) {
              l1 = paramObject.length();
            }
          }
        }
        else if ((paramObject instanceof String))
        {
          paramObject = (String)paramObject;
          l1 = l2;
          if (e.bK(paramObject)) {
            l1 = e.aeQ(paramObject);
          }
        }
        else
        {
          l1 = l2;
          if ((paramObject instanceof byte[])) {
            l1 = ((byte[])paramObject).length;
          }
        }
      }
    }
    
    public static boolean isTimeToStat()
    {
      long l = bk.UZ();
      if (l - mLastStatTick > 60000L)
      {
        mLastStatTick = l;
        return true;
      }
      return false;
    }
  }
  
  public static class KVStatHelper
  {
    private static final String KVSTAT_STRING_SEPERATOR = ",";
    public static final int MMBMPFACTORY_SCENE_ADDTOFAV = 5;
    public static final int MMBMPFACTORY_SCENE_APPMSG_DECODE = 9;
    public static final int MMBMPFACTORY_SCENE_APPMSG_TRANS = 6;
    public static final int MMBMPFACTORY_SCENE_GALLERY_BROWSE = 1;
    public static final int MMBMPFACTORY_SCENE_GET_MSGIMG = 2;
    public static final int MMBMPFACTORY_SCENE_IMGMSG_TRANS = 7;
    public static final int MMBMPFACTORY_SCENE_NONE = 0;
    public static final int MMBMPFACTORY_SCENE_OTHERS = 8;
    public static final int MMBMPFACTORY_SCENE_SHAREIMG = 3;
    public static final int MMBMPFACTORY_SCENE_SHARE_TO_TIMELINE = 4;
    public static final int MMBMPFACTORY_SCENE_SNS_IMGRECV = 10;
    
    /* Error */
    public static String getKVStatString(Object paramObject, int paramInt, MMBitmapFactory.DecodeResultLogger paramDecodeResultLogger)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore 11
      //   3: aconst_null
      //   4: astore 10
      //   6: new 47	java/lang/StringBuilder
      //   9: dup
      //   10: sipush 128
      //   13: invokespecial 50	java/lang/StringBuilder:<init>	(I)V
      //   16: astore 12
      //   18: ldc 52
      //   20: astore 8
      //   22: ldc2_w 53
      //   25: lstore 5
      //   27: aload_0
      //   28: instanceof 56
      //   31: ifeq +80 -> 111
      //   34: aload_0
      //   35: checkcast 56	java/io/File
      //   38: astore_0
      //   39: aload_0
      //   40: invokevirtual 60	java/io/File:exists	()Z
      //   43: ifeq +452 -> 495
      //   46: aload_0
      //   47: invokevirtual 63	java/io/File:isFile	()Z
      //   50: ifeq +445 -> 495
      //   53: aload_0
      //   54: invokestatic 69	com/tencent/mm/a/g:m	(Ljava/io/File;)Ljava/lang/String;
      //   57: invokestatic 75	com/tencent/mm/sdk/platformtools/bk:pm	(Ljava/lang/String;)Ljava/lang/String;
      //   60: astore 7
      //   62: aload_0
      //   63: invokevirtual 79	java/io/File:length	()J
      //   66: lstore_3
      //   67: aload 12
      //   69: iload_1
      //   70: invokevirtual 83	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   73: ldc 11
      //   75: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   78: aload_2
      //   79: invokestatic 92	com/tencent/mm/sdk/platformtools/MMBitmapFactory$DecodeResultLogger:access$000	(Lcom/tencent/mm/sdk/platformtools/MMBitmapFactory$DecodeResultLogger;)I
      //   82: invokevirtual 83	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   85: ldc 11
      //   87: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   90: lload_3
      //   91: invokevirtual 95	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   94: ldc 11
      //   96: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   99: aload 7
      //   101: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   104: pop
      //   105: aload 12
      //   107: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   110: areturn
      //   111: aload_0
      //   112: instanceof 101
      //   115: ifeq +147 -> 262
      //   118: aload_0
      //   119: checkcast 101	com/tencent/mm/vfs/b
      //   122: astore 10
      //   124: lload 5
      //   126: lstore_3
      //   127: aload 8
      //   129: astore 7
      //   131: aload 10
      //   133: invokevirtual 102	com/tencent/mm/vfs/b:exists	()Z
      //   136: ifeq -69 -> 67
      //   139: aload 10
      //   141: getfield 106	com/tencent/mm/vfs/b:mUri	Landroid/net/Uri;
      //   144: aconst_null
      //   145: invokestatic 112	com/tencent/mm/vfs/e:b	(Landroid/net/Uri;Lcom/tencent/mm/vfs/FileSystemManager$d;)Ljava/io/InputStream;
      //   148: astore_0
      //   149: aload_0
      //   150: sipush 4096
      //   153: invokestatic 115	com/tencent/mm/a/g:b	(Ljava/io/InputStream;I)Ljava/lang/String;
      //   156: invokestatic 75	com/tencent/mm/sdk/platformtools/bk:pm	(Ljava/lang/String;)Ljava/lang/String;
      //   159: astore 9
      //   161: aload 9
      //   163: astore 8
      //   165: aload 10
      //   167: invokevirtual 116	com/tencent/mm/vfs/b:length	()J
      //   170: lstore_3
      //   171: lload_3
      //   172: lstore 5
      //   174: lload 5
      //   176: lstore_3
      //   177: aload 9
      //   179: astore 7
      //   181: aload_0
      //   182: ifnull -115 -> 67
      //   185: aload_0
      //   186: invokevirtual 121	java/io/InputStream:close	()V
      //   189: lload 5
      //   191: lstore_3
      //   192: aload 9
      //   194: astore 7
      //   196: goto -129 -> 67
      //   199: astore_0
      //   200: lload 5
      //   202: lstore_3
      //   203: aload 9
      //   205: astore 7
      //   207: goto -140 -> 67
      //   210: astore_0
      //   211: aconst_null
      //   212: astore_0
      //   213: lload 5
      //   215: lstore_3
      //   216: aload 8
      //   218: astore 7
      //   220: aload_0
      //   221: ifnull -154 -> 67
      //   224: aload_0
      //   225: invokevirtual 121	java/io/InputStream:close	()V
      //   228: lload 5
      //   230: lstore_3
      //   231: aload 8
      //   233: astore 7
      //   235: goto -168 -> 67
      //   238: astore_0
      //   239: lload 5
      //   241: lstore_3
      //   242: aload 8
      //   244: astore 7
      //   246: goto -179 -> 67
      //   249: astore_0
      //   250: aconst_null
      //   251: astore_2
      //   252: aload_2
      //   253: ifnull +7 -> 260
      //   256: aload_2
      //   257: invokevirtual 121	java/io/InputStream:close	()V
      //   260: aload_0
      //   261: athrow
      //   262: aload_0
      //   263: instanceof 123
      //   266: ifeq +169 -> 435
      //   269: aload_0
      //   270: checkcast 123	java/lang/String
      //   273: astore 13
      //   275: lload 5
      //   277: lstore_3
      //   278: aload 8
      //   280: astore 7
      //   282: aload 13
      //   284: invokestatic 127	com/tencent/mm/vfs/e:bK	(Ljava/lang/String;)Z
      //   287: ifeq -220 -> 67
      //   290: aload 8
      //   292: astore 9
      //   294: aload 11
      //   296: astore 7
      //   298: aload_0
      //   299: checkcast 123	java/lang/String
      //   302: invokestatic 131	com/tencent/mm/vfs/e:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
      //   305: astore_0
      //   306: aload_0
      //   307: astore 10
      //   309: aload 8
      //   311: astore 9
      //   313: aload_0
      //   314: astore 7
      //   316: aload_0
      //   317: sipush 4096
      //   320: invokestatic 115	com/tencent/mm/a/g:b	(Ljava/io/InputStream;I)Ljava/lang/String;
      //   323: invokestatic 75	com/tencent/mm/sdk/platformtools/bk:pm	(Ljava/lang/String;)Ljava/lang/String;
      //   326: astore 8
      //   328: aload_0
      //   329: astore 10
      //   331: aload 8
      //   333: astore 9
      //   335: aload_0
      //   336: astore 7
      //   338: aload 13
      //   340: invokestatic 135	com/tencent/mm/vfs/e:aeQ	(Ljava/lang/String;)J
      //   343: lstore_3
      //   344: lload_3
      //   345: lstore 5
      //   347: lload 5
      //   349: lstore_3
      //   350: aload 8
      //   352: astore 7
      //   354: aload_0
      //   355: ifnull -288 -> 67
      //   358: aload_0
      //   359: invokevirtual 121	java/io/InputStream:close	()V
      //   362: lload 5
      //   364: lstore_3
      //   365: aload 8
      //   367: astore 7
      //   369: goto -302 -> 67
      //   372: astore_0
      //   373: lload 5
      //   375: lstore_3
      //   376: aload 8
      //   378: astore 7
      //   380: goto -313 -> 67
      //   383: astore_0
      //   384: lload 5
      //   386: lstore_3
      //   387: aload 9
      //   389: astore 7
      //   391: aload 10
      //   393: ifnull -326 -> 67
      //   396: aload 10
      //   398: invokevirtual 121	java/io/InputStream:close	()V
      //   401: lload 5
      //   403: lstore_3
      //   404: aload 9
      //   406: astore 7
      //   408: goto -341 -> 67
      //   411: astore_0
      //   412: lload 5
      //   414: lstore_3
      //   415: aload 9
      //   417: astore 7
      //   419: goto -352 -> 67
      //   422: astore_0
      //   423: aload 7
      //   425: ifnull +8 -> 433
      //   428: aload 7
      //   430: invokevirtual 121	java/io/InputStream:close	()V
      //   433: aload_0
      //   434: athrow
      //   435: lload 5
      //   437: lstore_3
      //   438: aload 8
      //   440: astore 7
      //   442: aload_0
      //   443: instanceof 137
      //   446: ifeq -379 -> 67
      //   449: aload_0
      //   450: checkcast 137	[B
      //   453: checkcast 137	[B
      //   456: astore_0
      //   457: aload_0
      //   458: invokestatic 141	com/tencent/mm/a/g:o	([B)Ljava/lang/String;
      //   461: astore 7
      //   463: aload_0
      //   464: arraylength
      //   465: i2l
      //   466: lstore_3
      //   467: goto -400 -> 67
      //   470: astore_2
      //   471: goto -211 -> 260
      //   474: astore_2
      //   475: goto -42 -> 433
      //   478: astore_2
      //   479: aload_0
      //   480: astore 7
      //   482: aload_2
      //   483: astore_0
      //   484: aload 7
      //   486: astore_2
      //   487: goto -235 -> 252
      //   490: astore 7
      //   492: goto -279 -> 213
      //   495: ldc2_w 53
      //   498: lstore_3
      //   499: aload 8
      //   501: astore 7
      //   503: goto -436 -> 67
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	506	0	paramObject	Object
      //   0	506	1	paramInt	int
      //   0	506	2	paramDecodeResultLogger	MMBitmapFactory.DecodeResultLogger
      //   66	433	3	l1	long
      //   25	411	5	l2	long
      //   60	425	7	localObject1	Object
      //   490	1	7	localFileNotFoundException	java.io.FileNotFoundException
      //   501	1	7	localObject2	Object
      //   20	480	8	localObject3	Object
      //   159	257	9	localObject4	Object
      //   4	393	10	localObject5	Object
      //   1	294	11	localObject6	Object
      //   16	90	12	localStringBuilder	StringBuilder
      //   273	66	13	str	String
      // Exception table:
      //   from	to	target	type
      //   185	189	199	java/lang/Exception
      //   139	149	210	java/io/FileNotFoundException
      //   224	228	238	java/lang/Exception
      //   139	149	249	finally
      //   358	362	372	java/lang/Exception
      //   298	306	383	java/io/FileNotFoundException
      //   316	328	383	java/io/FileNotFoundException
      //   338	344	383	java/io/FileNotFoundException
      //   396	401	411	java/lang/Exception
      //   298	306	422	finally
      //   316	328	422	finally
      //   338	344	422	finally
      //   256	260	470	java/lang/Exception
      //   428	433	474	java/lang/Exception
      //   149	161	478	finally
      //   165	171	478	finally
      //   149	161	490	java/io/FileNotFoundException
      //   165	171	490	java/io/FileNotFoundException
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.MMBitmapFactory
 * JD-Core Version:    0.7.0.1
 */
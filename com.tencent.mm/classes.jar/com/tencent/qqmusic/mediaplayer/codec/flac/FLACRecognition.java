package com.tencent.qqmusic.mediaplayer.codec.flac;

import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.AudioInformation;
import com.tencent.qqmusic.mediaplayer.codec.IAudioRecognition;
import com.tencent.qqmusic.mediaplayer.codec.NativeDecoder;
import com.tencent.qqmusic.mediaplayer.util.Logger;

public class FLACRecognition
  implements IAudioRecognition
{
  public static final String TAG = "FLACRecognition";
  
  private boolean checkFormatBySoftDecoder(String paramString)
  {
    boolean bool2 = false;
    localNativeDecoder = new NativeDecoder();
    try
    {
      if (localNativeDecoder.init(paramString, false) == 0)
      {
        paramString = localNativeDecoder.getAudioInformation();
        boolean bool1 = bool2;
        if (paramString != null)
        {
          paramString = paramString.getAudioType();
          AudioFormat.AudioType localAudioType = AudioFormat.AudioType.FLAC;
          bool1 = bool2;
          if (paramString == localAudioType) {
            bool1 = true;
          }
        }
        try
        {
          localNativeDecoder.release();
          return bool1;
        }
        catch (Throwable paramString)
        {
          Logger.e("FLACRecognition", paramString);
          return bool1;
        }
      }
      try
      {
        localNativeDecoder.release();
        return false;
      }
      catch (Throwable paramString)
      {
        Logger.e("FLACRecognition", paramString);
        return false;
      }
      try
      {
        localNativeDecoder.release();
        throw paramString;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          Logger.e("FLACRecognition", localThrowable);
        }
      }
    }
    catch (Throwable paramString)
    {
      paramString = paramString;
      Logger.e("FLACRecognition", paramString);
      try
      {
        localNativeDecoder.release();
        return false;
      }
      catch (Throwable paramString)
      {
        Logger.e("FLACRecognition", paramString);
        return false;
      }
    }
    finally {}
  }
  
  public AudioFormat.AudioType getAudioType(String paramString, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0) && (new String(paramArrayOfByte).startsWith("flaC"))) {
      return AudioFormat.AudioType.FLAC;
    }
    if (checkFormatBySoftDecoder(paramString)) {
      return AudioFormat.AudioType.FLAC;
    }
    return AudioFormat.AudioType.UNSUPPORT;
  }
  
  /* Error */
  public AudioFormat.AudioType guessAudioType(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 78	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifne +91 -> 95
    //   7: aload_1
    //   8: invokevirtual 82	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   11: ldc 84
    //   13: invokevirtual 87	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   16: ifeq +7 -> 23
    //   19: getstatic 42	com/tencent/qqmusic/mediaplayer/AudioFormat$AudioType:FLAC	Lcom/tencent/qqmusic/mediaplayer/AudioFormat$AudioType;
    //   22: areturn
    //   23: new 89	java/io/FileInputStream
    //   26: dup
    //   27: aload_1
    //   28: invokespecial 92	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   31: astore_3
    //   32: aload_3
    //   33: astore_2
    //   34: bipush 64
    //   36: newarray byte
    //   38: astore 4
    //   40: aload_3
    //   41: astore_2
    //   42: aload_3
    //   43: aload 4
    //   45: invokevirtual 98	java/io/InputStream:read	([B)I
    //   48: pop
    //   49: aload_3
    //   50: astore_2
    //   51: aload_0
    //   52: aload_1
    //   53: aload 4
    //   55: invokevirtual 100	com/tencent/qqmusic/mediaplayer/codec/flac/FLACRecognition:getAudioType	(Ljava/lang/String;[B)Lcom/tencent/qqmusic/mediaplayer/AudioFormat$AudioType;
    //   58: astore_1
    //   59: aload_3
    //   60: invokevirtual 103	java/io/InputStream:close	()V
    //   63: aload_1
    //   64: areturn
    //   65: astore_2
    //   66: ldc 10
    //   68: aload_2
    //   69: invokestatic 52	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   72: aload_1
    //   73: areturn
    //   74: astore 4
    //   76: aconst_null
    //   77: astore_1
    //   78: aload_1
    //   79: astore_2
    //   80: ldc 10
    //   82: aload 4
    //   84: invokestatic 52	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   87: aload_1
    //   88: ifnull +7 -> 95
    //   91: aload_1
    //   92: invokevirtual 103	java/io/InputStream:close	()V
    //   95: getstatic 68	com/tencent/qqmusic/mediaplayer/AudioFormat$AudioType:UNSUPPORT	Lcom/tencent/qqmusic/mediaplayer/AudioFormat$AudioType;
    //   98: areturn
    //   99: astore_1
    //   100: ldc 10
    //   102: aload_1
    //   103: invokestatic 52	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   106: goto -11 -> 95
    //   109: astore_1
    //   110: aconst_null
    //   111: astore_2
    //   112: aload_2
    //   113: ifnull +7 -> 120
    //   116: aload_2
    //   117: invokevirtual 103	java/io/InputStream:close	()V
    //   120: aload_1
    //   121: athrow
    //   122: astore_2
    //   123: ldc 10
    //   125: aload_2
    //   126: invokestatic 52	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   129: goto -9 -> 120
    //   132: astore_1
    //   133: goto -21 -> 112
    //   136: astore 4
    //   138: aload_3
    //   139: astore_1
    //   140: goto -62 -> 78
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	143	0	this	FLACRecognition
    //   0	143	1	paramString	String
    //   33	18	2	localFileInputStream1	java.io.FileInputStream
    //   65	4	2	localException1	java.lang.Exception
    //   79	38	2	str	String
    //   122	4	2	localException2	java.lang.Exception
    //   31	108	3	localFileInputStream2	java.io.FileInputStream
    //   38	16	4	arrayOfByte	byte[]
    //   74	9	4	localException3	java.lang.Exception
    //   136	1	4	localException4	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   59	63	65	java/lang/Exception
    //   23	32	74	java/lang/Exception
    //   91	95	99	java/lang/Exception
    //   23	32	109	finally
    //   116	120	122	java/lang/Exception
    //   34	40	132	finally
    //   42	49	132	finally
    //   51	59	132	finally
    //   80	87	132	finally
    //   34	40	136	java/lang/Exception
    //   42	49	136	java/lang/Exception
    //   51	59	136	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.codec.flac.FLACRecognition
 * JD-Core Version:    0.7.0.1
 */
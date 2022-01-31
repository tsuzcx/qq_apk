package com.tencent.qqmusic.mediaplayer.codec.flac;

import com.tencent.matrix.trace.core.AppMethodBeat;
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
    AppMethodBeat.i(128582);
    NativeDecoder localNativeDecoder = new NativeDecoder();
    for (;;)
    {
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
            AppMethodBeat.o(128582);
            return bool1;
          }
          catch (Throwable paramString)
          {
            Logger.e("FLACRecognition", paramString);
            continue;
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
        }
        catch (Throwable paramString)
        {
          Logger.e("FLACRecognition", paramString);
        }
        continue;
      }
      finally {}
      try
      {
        localNativeDecoder.release();
        AppMethodBeat.o(128582);
        return false;
      }
      catch (Throwable paramString)
      {
        Logger.e("FLACRecognition", paramString);
      }
    }
    try
    {
      localNativeDecoder.release();
      AppMethodBeat.o(128582);
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
  
  public AudioFormat.AudioType getAudioType(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(128581);
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0) && (new String(paramArrayOfByte).startsWith("flaC")))
    {
      paramString = AudioFormat.AudioType.FLAC;
      AppMethodBeat.o(128581);
      return paramString;
    }
    if (checkFormatBySoftDecoder(paramString))
    {
      paramString = AudioFormat.AudioType.FLAC;
      AppMethodBeat.o(128581);
      return paramString;
    }
    paramString = AudioFormat.AudioType.UNSUPPORT;
    AppMethodBeat.o(128581);
    return paramString;
  }
  
  /* Error */
  public AudioFormat.AudioType guessAudioType(String paramString)
  {
    // Byte code:
    //   0: ldc 84
    //   2: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: invokestatic 90	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   9: ifne +104 -> 113
    //   12: aload_1
    //   13: invokevirtual 94	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   16: ldc 96
    //   18: invokevirtual 99	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   21: ifeq +14 -> 35
    //   24: getstatic 49	com/tencent/qqmusic/mediaplayer/AudioFormat$AudioType:FLAC	Lcom/tencent/qqmusic/mediaplayer/AudioFormat$AudioType;
    //   27: astore_1
    //   28: ldc 84
    //   30: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   33: aload_1
    //   34: areturn
    //   35: new 101	java/io/FileInputStream
    //   38: dup
    //   39: aload_1
    //   40: invokespecial 104	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   43: astore_3
    //   44: aload_3
    //   45: astore_2
    //   46: bipush 64
    //   48: newarray byte
    //   50: astore 4
    //   52: aload_3
    //   53: astore_2
    //   54: aload_3
    //   55: aload 4
    //   57: invokevirtual 110	java/io/InputStream:read	([B)I
    //   60: pop
    //   61: aload_3
    //   62: astore_2
    //   63: aload_0
    //   64: aload_1
    //   65: aload 4
    //   67: invokevirtual 112	com/tencent/qqmusic/mediaplayer/codec/flac/FLACRecognition:getAudioType	(Ljava/lang/String;[B)Lcom/tencent/qqmusic/mediaplayer/AudioFormat$AudioType;
    //   70: astore_1
    //   71: aload_3
    //   72: invokevirtual 115	java/io/InputStream:close	()V
    //   75: ldc 84
    //   77: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   80: aload_1
    //   81: areturn
    //   82: astore_2
    //   83: ldc 10
    //   85: aload_2
    //   86: invokestatic 62	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   89: goto -14 -> 75
    //   92: astore 4
    //   94: aconst_null
    //   95: astore_1
    //   96: aload_1
    //   97: astore_2
    //   98: ldc 10
    //   100: aload 4
    //   102: invokestatic 62	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   105: aload_1
    //   106: ifnull +7 -> 113
    //   109: aload_1
    //   110: invokevirtual 115	java/io/InputStream:close	()V
    //   113: getstatic 79	com/tencent/qqmusic/mediaplayer/AudioFormat$AudioType:UNSUPPORT	Lcom/tencent/qqmusic/mediaplayer/AudioFormat$AudioType;
    //   116: astore_1
    //   117: ldc 84
    //   119: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   122: aload_1
    //   123: areturn
    //   124: astore_1
    //   125: ldc 10
    //   127: aload_1
    //   128: invokestatic 62	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   131: goto -18 -> 113
    //   134: astore_1
    //   135: aconst_null
    //   136: astore_2
    //   137: aload_2
    //   138: ifnull +7 -> 145
    //   141: aload_2
    //   142: invokevirtual 115	java/io/InputStream:close	()V
    //   145: ldc 84
    //   147: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   150: aload_1
    //   151: athrow
    //   152: astore_2
    //   153: ldc 10
    //   155: aload_2
    //   156: invokestatic 62	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   159: goto -14 -> 145
    //   162: astore_1
    //   163: goto -26 -> 137
    //   166: astore 4
    //   168: aload_3
    //   169: astore_1
    //   170: goto -74 -> 96
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	173	0	this	FLACRecognition
    //   0	173	1	paramString	String
    //   45	18	2	localFileInputStream1	java.io.FileInputStream
    //   82	4	2	localException1	java.lang.Exception
    //   97	45	2	str	String
    //   152	4	2	localException2	java.lang.Exception
    //   43	126	3	localFileInputStream2	java.io.FileInputStream
    //   50	16	4	arrayOfByte	byte[]
    //   92	9	4	localException3	java.lang.Exception
    //   166	1	4	localException4	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   71	75	82	java/lang/Exception
    //   35	44	92	java/lang/Exception
    //   109	113	124	java/lang/Exception
    //   35	44	134	finally
    //   141	145	152	java/lang/Exception
    //   46	52	162	finally
    //   54	61	162	finally
    //   63	71	162	finally
    //   98	105	162	finally
    //   46	52	166	java/lang/Exception
    //   54	61	166	java/lang/Exception
    //   63	71	166	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.codec.flac.FLACRecognition
 * JD-Core Version:    0.7.0.1
 */
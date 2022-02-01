package com.tencent.qqmusic.mediaplayer.codec.ffmpeg;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.codec.IAudioRecognition;
import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;
import java.io.IOException;

public class FfmpegRecognition
  implements IAudioRecognition
{
  private static final String SO_AUDIO_COMMON = "audio_common";
  private static final String SO_BASE_NAME = "FFmpeg";
  private static final String SO_NAME = "ffmpeg_decoder";
  private static final String SO_NEON_BASE_NAME = "FFmpeg_v7a";
  private static final String SO_NEON_NAME = "ffmpeg_decoder_v7a";
  private static final String TAG = "FfmpegRecognition";
  
  public static boolean isM4a(IDataSource paramIDataSource)
  {
    AppMethodBeat.i(114355);
    byte[] arrayOfByte = new byte[4];
    try
    {
      paramIDataSource.readAt(4L, arrayOfByte, 0, 4);
      label22:
      if ((arrayOfByte[0] == 102) && (arrayOfByte[1] == 116) && (arrayOfByte[2] == 121) && (arrayOfByte[3] == 112))
      {
        AppMethodBeat.o(114355);
        return true;
      }
      AppMethodBeat.o(114355);
      return false;
    }
    catch (IOException paramIDataSource)
    {
      break label22;
    }
  }
  
  /* Error */
  public AudioFormat.AudioType getAudioType(String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: ldc 57
    //   5: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_2
    //   9: ifnull +8 -> 17
    //   12: aload_2
    //   13: arraylength
    //   14: ifne +157 -> 171
    //   17: new 59	java/io/FileInputStream
    //   20: dup
    //   21: aload_1
    //   22: invokespecial 62	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   25: astore_3
    //   26: aload_3
    //   27: astore_1
    //   28: bipush 64
    //   30: newarray byte
    //   32: astore 4
    //   34: aload_3
    //   35: astore_1
    //   36: aload_3
    //   37: aload 4
    //   39: invokevirtual 68	java/io/InputStream:read	([B)I
    //   42: pop
    //   43: aload_3
    //   44: astore_1
    //   45: new 70	java/lang/String
    //   48: dup
    //   49: aload 4
    //   51: invokespecial 73	java/lang/String:<init>	([B)V
    //   54: astore 4
    //   56: aload_3
    //   57: invokevirtual 76	java/io/InputStream:close	()V
    //   60: aload 4
    //   62: astore_1
    //   63: aload_1
    //   64: ifnull +119 -> 183
    //   67: aload_1
    //   68: ldc 78
    //   70: invokevirtual 82	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   73: ifeq +110 -> 183
    //   76: getstatic 88	com/tencent/qqmusic/mediaplayer/AudioFormat$AudioType:M4A	Lcom/tencent/qqmusic/mediaplayer/AudioFormat$AudioType;
    //   79: astore_1
    //   80: ldc 57
    //   82: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   85: aload_1
    //   86: areturn
    //   87: astore_1
    //   88: ldc 25
    //   90: aload_1
    //   91: invokestatic 94	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   94: aload 4
    //   96: astore_1
    //   97: goto -34 -> 63
    //   100: astore 4
    //   102: aconst_null
    //   103: astore_3
    //   104: aload_3
    //   105: astore_1
    //   106: ldc 25
    //   108: aload 4
    //   110: invokestatic 94	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   113: aload 5
    //   115: astore_1
    //   116: aload_3
    //   117: ifnull -54 -> 63
    //   120: aload_3
    //   121: invokevirtual 76	java/io/InputStream:close	()V
    //   124: aload 5
    //   126: astore_1
    //   127: goto -64 -> 63
    //   130: astore_1
    //   131: ldc 25
    //   133: aload_1
    //   134: invokestatic 94	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   137: aload 5
    //   139: astore_1
    //   140: goto -77 -> 63
    //   143: astore_2
    //   144: aconst_null
    //   145: astore_1
    //   146: aload_1
    //   147: ifnull +7 -> 154
    //   150: aload_1
    //   151: invokevirtual 76	java/io/InputStream:close	()V
    //   154: ldc 57
    //   156: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   159: aload_2
    //   160: athrow
    //   161: astore_1
    //   162: ldc 25
    //   164: aload_1
    //   165: invokestatic 94	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   168: goto -14 -> 154
    //   171: new 70	java/lang/String
    //   174: dup
    //   175: aload_2
    //   176: invokespecial 73	java/lang/String:<init>	([B)V
    //   179: astore_1
    //   180: goto -117 -> 63
    //   183: aload_2
    //   184: ifnull +52 -> 236
    //   187: aload_2
    //   188: arraylength
    //   189: iconst_2
    //   190: if_icmple +46 -> 236
    //   193: aload_2
    //   194: iconst_0
    //   195: baload
    //   196: iconst_m1
    //   197: if_icmpne +39 -> 236
    //   200: aload_2
    //   201: iconst_1
    //   202: baload
    //   203: sipush 240
    //   206: iand
    //   207: sipush 240
    //   210: if_icmpne +26 -> 236
    //   213: aload_2
    //   214: iconst_1
    //   215: baload
    //   216: bipush 15
    //   218: iand
    //   219: bipush 6
    //   221: iand
    //   222: ifne +14 -> 236
    //   225: getstatic 88	com/tencent/qqmusic/mediaplayer/AudioFormat$AudioType:M4A	Lcom/tencent/qqmusic/mediaplayer/AudioFormat$AudioType;
    //   228: astore_1
    //   229: ldc 57
    //   231: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   234: aload_1
    //   235: areturn
    //   236: getstatic 97	com/tencent/qqmusic/mediaplayer/AudioFormat$AudioType:UNSUPPORT	Lcom/tencent/qqmusic/mediaplayer/AudioFormat$AudioType;
    //   239: astore_1
    //   240: ldc 57
    //   242: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   245: aload_1
    //   246: areturn
    //   247: astore_2
    //   248: goto -102 -> 146
    //   251: astore 4
    //   253: goto -149 -> 104
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	256	0	this	FfmpegRecognition
    //   0	256	1	paramString	String
    //   0	256	2	paramArrayOfByte	byte[]
    //   25	96	3	localFileInputStream	java.io.FileInputStream
    //   32	63	4	localObject1	Object
    //   100	9	4	localException1	java.lang.Exception
    //   251	1	4	localException2	java.lang.Exception
    //   1	137	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   56	60	87	java/lang/Exception
    //   17	26	100	java/lang/Exception
    //   120	124	130	java/lang/Exception
    //   17	26	143	finally
    //   150	154	161	java/lang/Exception
    //   28	34	247	finally
    //   36	43	247	finally
    //   45	56	247	finally
    //   106	113	247	finally
    //   28	34	251	java/lang/Exception
    //   36	43	251	java/lang/Exception
    //   45	56	251	java/lang/Exception
  }
  
  public AudioFormat.AudioType guessAudioType(String paramString)
  {
    AppMethodBeat.i(114354);
    paramString = getAudioType(paramString, null);
    AppMethodBeat.o(114354);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.codec.ffmpeg.FfmpegRecognition
 * JD-Core Version:    0.7.0.1
 */
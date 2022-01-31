package com.tencent.qqmusic.mediaplayer.codec.ffmpeg;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.codec.IAudioRecognition;

public class FfmpegRecognition
  implements IAudioRecognition
{
  private static final String SO_AUDIO_COMMON = "audio_common";
  private static final String SO_BASE_NAME = "FFmpeg";
  private static final String SO_NAME = "ffmpeg_decoder";
  private static final String SO_NEON_BASE_NAME = "FFmpeg_v7a";
  private static final String SO_NEON_NAME = "ffmpeg_decoder_v7a";
  private static final String TAG = "FfmpegRecognition";
  
  /* Error */
  public AudioFormat.AudioType getAudioType(String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: ldc 35
    //   5: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_2
    //   9: ifnull +8 -> 17
    //   12: aload_2
    //   13: arraylength
    //   14: ifne +149 -> 163
    //   17: new 43	java/io/FileInputStream
    //   20: dup
    //   21: aload_1
    //   22: invokespecial 46	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   25: astore_2
    //   26: aload_2
    //   27: astore_1
    //   28: bipush 64
    //   30: newarray byte
    //   32: astore_3
    //   33: aload_2
    //   34: astore_1
    //   35: aload_2
    //   36: aload_3
    //   37: invokevirtual 52	java/io/InputStream:read	([B)I
    //   40: pop
    //   41: aload_2
    //   42: astore_1
    //   43: new 54	java/lang/String
    //   46: dup
    //   47: aload_3
    //   48: invokespecial 57	java/lang/String:<init>	([B)V
    //   51: astore_3
    //   52: aload_2
    //   53: invokevirtual 60	java/io/InputStream:close	()V
    //   56: aload_3
    //   57: astore_1
    //   58: aload_1
    //   59: ifnull +116 -> 175
    //   62: aload_1
    //   63: ldc 62
    //   65: invokevirtual 66	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   68: ifeq +107 -> 175
    //   71: getstatic 72	com/tencent/qqmusic/mediaplayer/AudioFormat$AudioType:M4A	Lcom/tencent/qqmusic/mediaplayer/AudioFormat$AudioType;
    //   74: astore_1
    //   75: ldc 35
    //   77: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   80: aload_1
    //   81: areturn
    //   82: astore_1
    //   83: ldc 25
    //   85: aload_1
    //   86: invokestatic 81	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   89: aload_3
    //   90: astore_1
    //   91: goto -33 -> 58
    //   94: astore_3
    //   95: aconst_null
    //   96: astore_2
    //   97: aload_2
    //   98: astore_1
    //   99: ldc 25
    //   101: aload_3
    //   102: invokestatic 81	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   105: aload 4
    //   107: astore_1
    //   108: aload_2
    //   109: ifnull -51 -> 58
    //   112: aload_2
    //   113: invokevirtual 60	java/io/InputStream:close	()V
    //   116: aload 4
    //   118: astore_1
    //   119: goto -61 -> 58
    //   122: astore_1
    //   123: ldc 25
    //   125: aload_1
    //   126: invokestatic 81	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   129: aload 4
    //   131: astore_1
    //   132: goto -74 -> 58
    //   135: astore_2
    //   136: aconst_null
    //   137: astore_1
    //   138: aload_1
    //   139: ifnull +7 -> 146
    //   142: aload_1
    //   143: invokevirtual 60	java/io/InputStream:close	()V
    //   146: ldc 35
    //   148: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   151: aload_2
    //   152: athrow
    //   153: astore_1
    //   154: ldc 25
    //   156: aload_1
    //   157: invokestatic 81	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   160: goto -14 -> 146
    //   163: new 54	java/lang/String
    //   166: dup
    //   167: aload_2
    //   168: invokespecial 57	java/lang/String:<init>	([B)V
    //   171: astore_1
    //   172: goto -114 -> 58
    //   175: getstatic 84	com/tencent/qqmusic/mediaplayer/AudioFormat$AudioType:UNSUPPORT	Lcom/tencent/qqmusic/mediaplayer/AudioFormat$AudioType;
    //   178: astore_1
    //   179: ldc 35
    //   181: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   184: aload_1
    //   185: areturn
    //   186: astore_2
    //   187: goto -49 -> 138
    //   190: astore_3
    //   191: goto -94 -> 97
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	194	0	this	FfmpegRecognition
    //   0	194	1	paramString	String
    //   0	194	2	paramArrayOfByte	byte[]
    //   32	58	3	localObject1	Object
    //   94	8	3	localException1	java.lang.Exception
    //   190	1	3	localException2	java.lang.Exception
    //   1	129	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   52	56	82	java/lang/Exception
    //   17	26	94	java/lang/Exception
    //   112	116	122	java/lang/Exception
    //   17	26	135	finally
    //   142	146	153	java/lang/Exception
    //   28	33	186	finally
    //   35	41	186	finally
    //   43	52	186	finally
    //   99	105	186	finally
    //   28	33	190	java/lang/Exception
    //   35	41	190	java/lang/Exception
    //   43	52	190	java/lang/Exception
  }
  
  public AudioFormat.AudioType guessAudioType(String paramString)
  {
    AppMethodBeat.i(128580);
    paramString = getAudioType(paramString, null);
    AppMethodBeat.o(128580);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.codec.ffmpeg.FfmpegRecognition
 * JD-Core Version:    0.7.0.1
 */
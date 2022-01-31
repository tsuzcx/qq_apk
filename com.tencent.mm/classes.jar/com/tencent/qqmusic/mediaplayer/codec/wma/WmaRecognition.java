package com.tencent.qqmusic.mediaplayer.codec.wma;

import android.text.TextUtils;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.codec.IAudioRecognition;

public class WmaRecognition
  implements IAudioRecognition
{
  public static String TAG = "WmaRecognition";
  private final int HEARER_LENGTH = 16;
  private final byte[] WMA_HEADER = { 48, 38, -78, 117, -114, 102, -49, 17, -90, -39, 0, -86, 0, 98, -50, 108 };
  
  /* Error */
  public AudioFormat.AudioType getAudioType(String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +48 -> 49
    //   4: aload_2
    //   5: arraylength
    //   6: bipush 16
    //   8: if_icmplt +41 -> 49
    //   11: aload_2
    //   12: ifnull +170 -> 182
    //   15: aload_2
    //   16: arraylength
    //   17: bipush 16
    //   19: if_icmplt +163 -> 182
    //   22: iconst_0
    //   23: istore_3
    //   24: iload_3
    //   25: bipush 16
    //   27: if_icmpge +145 -> 172
    //   30: aload_2
    //   31: iload_3
    //   32: baload
    //   33: aload_0
    //   34: getfield 41	com/tencent/qqmusic/mediaplayer/codec/wma/WmaRecognition:WMA_HEADER	[B
    //   37: iload_3
    //   38: baload
    //   39: if_icmpne +133 -> 172
    //   42: iload_3
    //   43: iconst_1
    //   44: iadd
    //   45: istore_3
    //   46: goto -22 -> 24
    //   49: new 47	java/io/FileInputStream
    //   52: dup
    //   53: aload_1
    //   54: invokespecial 50	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   57: astore 5
    //   59: aload 5
    //   61: astore_2
    //   62: bipush 16
    //   64: newarray byte
    //   66: astore_1
    //   67: aload 5
    //   69: astore_2
    //   70: aload 5
    //   72: aload_1
    //   73: invokevirtual 56	java/io/InputStream:read	([B)I
    //   76: pop
    //   77: aload 5
    //   79: invokevirtual 59	java/io/InputStream:close	()V
    //   82: aload_1
    //   83: astore_2
    //   84: goto -73 -> 11
    //   87: astore_2
    //   88: getstatic 18	com/tencent/qqmusic/mediaplayer/codec/wma/WmaRecognition:TAG	Ljava/lang/String;
    //   91: aload_2
    //   92: invokestatic 65	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   95: aload_1
    //   96: astore_2
    //   97: goto -86 -> 11
    //   100: astore 4
    //   102: aconst_null
    //   103: astore_1
    //   104: aconst_null
    //   105: astore 5
    //   107: aload 5
    //   109: astore_2
    //   110: getstatic 18	com/tencent/qqmusic/mediaplayer/codec/wma/WmaRecognition:TAG	Ljava/lang/String;
    //   113: aload 4
    //   115: invokestatic 65	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   118: aload_1
    //   119: astore_2
    //   120: aload 5
    //   122: ifnull -111 -> 11
    //   125: aload 5
    //   127: invokevirtual 59	java/io/InputStream:close	()V
    //   130: aload_1
    //   131: astore_2
    //   132: goto -121 -> 11
    //   135: astore_2
    //   136: getstatic 18	com/tencent/qqmusic/mediaplayer/codec/wma/WmaRecognition:TAG	Ljava/lang/String;
    //   139: aload_2
    //   140: invokestatic 65	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   143: aload_1
    //   144: astore_2
    //   145: goto -134 -> 11
    //   148: astore_1
    //   149: aconst_null
    //   150: astore_2
    //   151: aload_2
    //   152: ifnull +7 -> 159
    //   155: aload_2
    //   156: invokevirtual 59	java/io/InputStream:close	()V
    //   159: aload_1
    //   160: athrow
    //   161: astore_2
    //   162: getstatic 18	com/tencent/qqmusic/mediaplayer/codec/wma/WmaRecognition:TAG	Ljava/lang/String;
    //   165: aload_2
    //   166: invokestatic 65	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   169: goto -10 -> 159
    //   172: iload_3
    //   173: bipush 16
    //   175: if_icmpne +7 -> 182
    //   178: getstatic 71	com/tencent/qqmusic/mediaplayer/AudioFormat$AudioType:WMA	Lcom/tencent/qqmusic/mediaplayer/AudioFormat$AudioType;
    //   181: areturn
    //   182: getstatic 74	com/tencent/qqmusic/mediaplayer/AudioFormat$AudioType:UNSUPPORT	Lcom/tencent/qqmusic/mediaplayer/AudioFormat$AudioType;
    //   185: areturn
    //   186: astore_1
    //   187: goto -36 -> 151
    //   190: astore 4
    //   192: aconst_null
    //   193: astore_1
    //   194: goto -87 -> 107
    //   197: astore 4
    //   199: goto -92 -> 107
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	202	0	this	WmaRecognition
    //   0	202	1	paramString	String
    //   0	202	2	paramArrayOfByte	byte[]
    //   23	153	3	i	int
    //   100	14	4	localIOException1	java.io.IOException
    //   190	1	4	localIOException2	java.io.IOException
    //   197	1	4	localIOException3	java.io.IOException
    //   57	69	5	localFileInputStream	java.io.FileInputStream
    // Exception table:
    //   from	to	target	type
    //   77	82	87	java/io/IOException
    //   49	59	100	java/io/IOException
    //   125	130	135	java/io/IOException
    //   49	59	148	finally
    //   155	159	161	java/io/IOException
    //   62	67	186	finally
    //   70	77	186	finally
    //   110	118	186	finally
    //   62	67	190	java/io/IOException
    //   70	77	197	java/io/IOException
  }
  
  public AudioFormat.AudioType guessAudioType(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.toLowerCase().contains(".wma"))) {
      return AudioFormat.AudioType.WMA;
    }
    return AudioFormat.AudioType.UNSUPPORT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.codec.wma.WmaRecognition
 * JD-Core Version:    0.7.0.1
 */
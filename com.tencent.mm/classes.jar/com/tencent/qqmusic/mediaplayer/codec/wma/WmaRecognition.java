package com.tencent.qqmusic.mediaplayer.codec.wma;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.AudioFormat.AudioType;
import com.tencent.qqmusic.mediaplayer.codec.IAudioRecognition;

public class WmaRecognition
  implements IAudioRecognition
{
  public static String TAG = "WmaRecognition";
  private final int HEARER_LENGTH;
  private final byte[] WMA_HEADER;
  
  public WmaRecognition()
  {
    AppMethodBeat.i(128584);
    this.HEARER_LENGTH = 16;
    this.WMA_HEADER = new byte[] { 48, 38, -78, 117, -114, 102, -49, 17, -90, -39, 0, -86, 0, 98, -50, 108 };
    AppMethodBeat.o(128584);
  }
  
  /* Error */
  public AudioFormat.AudioType getAudioType(String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: ldc 56
    //   2: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_2
    //   6: ifnull +48 -> 54
    //   9: aload_2
    //   10: arraylength
    //   11: bipush 16
    //   13: if_icmplt +41 -> 54
    //   16: aload_2
    //   17: ifnull +182 -> 199
    //   20: aload_2
    //   21: arraylength
    //   22: bipush 16
    //   24: if_icmplt +175 -> 199
    //   27: iconst_0
    //   28: istore_3
    //   29: iload_3
    //   30: bipush 16
    //   32: if_icmpge +150 -> 182
    //   35: aload_2
    //   36: iload_3
    //   37: baload
    //   38: aload_0
    //   39: getfield 48	com/tencent/qqmusic/mediaplayer/codec/wma/WmaRecognition:WMA_HEADER	[B
    //   42: iload_3
    //   43: baload
    //   44: if_icmpne +138 -> 182
    //   47: iload_3
    //   48: iconst_1
    //   49: iadd
    //   50: istore_3
    //   51: goto -22 -> 29
    //   54: new 58	java/io/FileInputStream
    //   57: dup
    //   58: aload_1
    //   59: invokespecial 61	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   62: astore 5
    //   64: aload 5
    //   66: astore_2
    //   67: bipush 16
    //   69: newarray byte
    //   71: astore_1
    //   72: aload 5
    //   74: astore_2
    //   75: aload 5
    //   77: aload_1
    //   78: invokevirtual 67	java/io/InputStream:read	([B)I
    //   81: pop
    //   82: aload 5
    //   84: invokevirtual 70	java/io/InputStream:close	()V
    //   87: aload_1
    //   88: astore_2
    //   89: goto -73 -> 16
    //   92: astore_2
    //   93: getstatic 18	com/tencent/qqmusic/mediaplayer/codec/wma/WmaRecognition:TAG	Ljava/lang/String;
    //   96: aload_2
    //   97: invokestatic 76	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   100: aload_1
    //   101: astore_2
    //   102: goto -86 -> 16
    //   105: astore 4
    //   107: aconst_null
    //   108: astore_1
    //   109: aconst_null
    //   110: astore 5
    //   112: aload 5
    //   114: astore_2
    //   115: getstatic 18	com/tencent/qqmusic/mediaplayer/codec/wma/WmaRecognition:TAG	Ljava/lang/String;
    //   118: aload 4
    //   120: invokestatic 76	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   123: aload_1
    //   124: astore_2
    //   125: aload 5
    //   127: ifnull -111 -> 16
    //   130: aload 5
    //   132: invokevirtual 70	java/io/InputStream:close	()V
    //   135: aload_1
    //   136: astore_2
    //   137: goto -121 -> 16
    //   140: astore_2
    //   141: getstatic 18	com/tencent/qqmusic/mediaplayer/codec/wma/WmaRecognition:TAG	Ljava/lang/String;
    //   144: aload_2
    //   145: invokestatic 76	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   148: aload_1
    //   149: astore_2
    //   150: goto -134 -> 16
    //   153: astore_1
    //   154: aconst_null
    //   155: astore_2
    //   156: aload_2
    //   157: ifnull +7 -> 164
    //   160: aload_2
    //   161: invokevirtual 70	java/io/InputStream:close	()V
    //   164: ldc 56
    //   166: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   169: aload_1
    //   170: athrow
    //   171: astore_2
    //   172: getstatic 18	com/tencent/qqmusic/mediaplayer/codec/wma/WmaRecognition:TAG	Ljava/lang/String;
    //   175: aload_2
    //   176: invokestatic 76	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   179: goto -15 -> 164
    //   182: iload_3
    //   183: bipush 16
    //   185: if_icmpne +14 -> 199
    //   188: getstatic 82	com/tencent/qqmusic/mediaplayer/AudioFormat$AudioType:WMA	Lcom/tencent/qqmusic/mediaplayer/AudioFormat$AudioType;
    //   191: astore_1
    //   192: ldc 56
    //   194: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   197: aload_1
    //   198: areturn
    //   199: getstatic 85	com/tencent/qqmusic/mediaplayer/AudioFormat$AudioType:UNSUPPORT	Lcom/tencent/qqmusic/mediaplayer/AudioFormat$AudioType;
    //   202: astore_1
    //   203: ldc 56
    //   205: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   208: aload_1
    //   209: areturn
    //   210: astore_1
    //   211: goto -55 -> 156
    //   214: astore 4
    //   216: aconst_null
    //   217: astore_1
    //   218: goto -106 -> 112
    //   221: astore 4
    //   223: goto -111 -> 112
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	226	0	this	WmaRecognition
    //   0	226	1	paramString	String
    //   0	226	2	paramArrayOfByte	byte[]
    //   28	158	3	i	int
    //   105	14	4	localIOException1	java.io.IOException
    //   214	1	4	localIOException2	java.io.IOException
    //   221	1	4	localIOException3	java.io.IOException
    //   62	69	5	localFileInputStream	java.io.FileInputStream
    // Exception table:
    //   from	to	target	type
    //   82	87	92	java/io/IOException
    //   54	64	105	java/io/IOException
    //   130	135	140	java/io/IOException
    //   54	64	153	finally
    //   160	164	171	java/io/IOException
    //   67	72	210	finally
    //   75	82	210	finally
    //   115	123	210	finally
    //   67	72	214	java/io/IOException
    //   75	82	221	java/io/IOException
  }
  
  public AudioFormat.AudioType guessAudioType(String paramString)
  {
    AppMethodBeat.i(128586);
    if ((!TextUtils.isEmpty(paramString)) && (paramString.toLowerCase().contains(".wma")))
    {
      paramString = AudioFormat.AudioType.WMA;
      AppMethodBeat.o(128586);
      return paramString;
    }
    paramString = AudioFormat.AudioType.UNSUPPORT;
    AppMethodBeat.o(128586);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.codec.wma.WmaRecognition
 * JD-Core Version:    0.7.0.1
 */
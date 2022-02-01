package com.tencent.qqmusic.mediaplayer.audioplaylist.itemparser;

import com.tencent.qqmusic.mediaplayer.audioplaylist.TrackInfo;
import com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetDetector;
import java.util.Iterator;

public abstract class AudioPlayListItemParser
{
  public static final String TAG = "AudioListItemParser";
  protected CharsetDetector charsetDetector = new CharsetDetector();
  protected String mUri;
  
  protected static String delSeprator(String paramString)
  {
    return paramString.substring(paramString.indexOf("\"") + 1, paramString.lastIndexOf("\""));
  }
  
  /* Error */
  protected String guessCharsetEncoding(java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: ldc 44
    //   2: astore_3
    //   3: new 46	java/io/BufferedInputStream
    //   6: dup
    //   7: aload_1
    //   8: invokespecial 49	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   11: astore 5
    //   13: aload 5
    //   15: astore_1
    //   16: aload_3
    //   17: astore 4
    //   19: aload_0
    //   20: getfield 20	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/AudioPlayListItemParser:charsetDetector	Lcom/tencent/qqmusic/mediaplayer/audioplaylist/charsetdetector/CharsetDetector;
    //   23: aload 5
    //   25: invokevirtual 53	com/tencent/qqmusic/mediaplayer/audioplaylist/charsetdetector/CharsetDetector:setText	(Ljava/io/InputStream;)Lcom/tencent/qqmusic/mediaplayer/audioplaylist/charsetdetector/CharsetDetector;
    //   28: pop
    //   29: aload 5
    //   31: astore_1
    //   32: aload_3
    //   33: astore 4
    //   35: aload_0
    //   36: getfield 20	com/tencent/qqmusic/mediaplayer/audioplaylist/itemparser/AudioPlayListItemParser:charsetDetector	Lcom/tencent/qqmusic/mediaplayer/audioplaylist/charsetdetector/CharsetDetector;
    //   39: invokevirtual 57	com/tencent/qqmusic/mediaplayer/audioplaylist/charsetdetector/CharsetDetector:detect	()Lcom/tencent/qqmusic/mediaplayer/audioplaylist/charsetdetector/CharsetMatch;
    //   42: astore 6
    //   44: aload_3
    //   45: astore_1
    //   46: aload 6
    //   48: ifnull +65 -> 113
    //   51: aload 5
    //   53: astore_1
    //   54: aload_3
    //   55: astore 4
    //   57: aload 6
    //   59: invokevirtual 63	com/tencent/qqmusic/mediaplayer/audioplaylist/charsetdetector/CharsetMatch:getConfidence	()I
    //   62: istore_2
    //   63: aload 5
    //   65: astore_1
    //   66: aload_3
    //   67: astore 4
    //   69: aload 6
    //   71: invokevirtual 67	com/tencent/qqmusic/mediaplayer/audioplaylist/charsetdetector/CharsetMatch:getName	()Ljava/lang/String;
    //   74: astore_3
    //   75: aload 5
    //   77: astore_1
    //   78: aload_3
    //   79: astore 4
    //   81: ldc 8
    //   83: new 69	java/lang/StringBuilder
    //   86: dup
    //   87: ldc 71
    //   89: invokespecial 74	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   92: aload_3
    //   93: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: ldc 80
    //   98: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: iload_2
    //   102: invokevirtual 83	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   105: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   108: invokestatic 92	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   111: aload_3
    //   112: astore_1
    //   113: aload 5
    //   115: invokevirtual 95	java/io/BufferedInputStream:close	()V
    //   118: aload_1
    //   119: areturn
    //   120: astore_3
    //   121: ldc 8
    //   123: ldc 97
    //   125: aload_3
    //   126: invokestatic 101	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   129: aload_1
    //   130: areturn
    //   131: astore 6
    //   133: aconst_null
    //   134: astore 4
    //   136: aload 4
    //   138: astore_1
    //   139: ldc 8
    //   141: ldc 103
    //   143: aload 6
    //   145: invokestatic 101	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   148: aload_3
    //   149: astore_1
    //   150: aload 4
    //   152: ifnull -34 -> 118
    //   155: aload 4
    //   157: invokevirtual 95	java/io/BufferedInputStream:close	()V
    //   160: aload_3
    //   161: areturn
    //   162: astore_1
    //   163: ldc 8
    //   165: ldc 97
    //   167: aload_1
    //   168: invokestatic 101	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   171: aload_3
    //   172: areturn
    //   173: astore_3
    //   174: aconst_null
    //   175: astore_1
    //   176: aload_1
    //   177: ifnull +7 -> 184
    //   180: aload_1
    //   181: invokevirtual 95	java/io/BufferedInputStream:close	()V
    //   184: aload_3
    //   185: athrow
    //   186: astore_1
    //   187: ldc 8
    //   189: ldc 97
    //   191: aload_1
    //   192: invokestatic 101	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   195: goto -11 -> 184
    //   198: astore_3
    //   199: goto -23 -> 176
    //   202: astore 6
    //   204: aload 4
    //   206: astore_3
    //   207: aload 5
    //   209: astore 4
    //   211: goto -75 -> 136
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	214	0	this	AudioPlayListItemParser
    //   0	214	1	paramInputStream	java.io.InputStream
    //   62	40	2	i	int
    //   2	110	3	str	String
    //   120	52	3	localIOException1	java.io.IOException
    //   173	12	3	localObject1	Object
    //   198	1	3	localObject2	Object
    //   206	1	3	localObject3	Object
    //   17	193	4	localObject4	Object
    //   11	197	5	localBufferedInputStream	java.io.BufferedInputStream
    //   42	28	6	localCharsetMatch	com.tencent.qqmusic.mediaplayer.audioplaylist.charsetdetector.CharsetMatch
    //   131	13	6	localIOException2	java.io.IOException
    //   202	1	6	localIOException3	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   113	118	120	java/io/IOException
    //   3	13	131	java/io/IOException
    //   155	160	162	java/io/IOException
    //   3	13	173	finally
    //   180	184	186	java/io/IOException
    //   19	29	198	finally
    //   35	44	198	finally
    //   57	63	198	finally
    //   69	75	198	finally
    //   81	111	198	finally
    //   139	148	198	finally
    //   19	29	202	java/io/IOException
    //   35	44	202	java/io/IOException
    //   57	63	202	java/io/IOException
    //   69	75	202	java/io/IOException
    //   81	111	202	java/io/IOException
  }
  
  public abstract boolean isParseSuccess();
  
  public abstract Iterator<TrackInfo> iterator();
  
  public abstract void parse();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.audioplaylist.itemparser.AudioPlayListItemParser
 * JD-Core Version:    0.7.0.1
 */
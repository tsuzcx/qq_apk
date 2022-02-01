package com.tencent.qqmusic.mediaplayer;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.codec.IAudioRecognition;
import com.tencent.qqmusic.mediaplayer.codec.NativeDecoder;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class AudioRecognition
{
  private static final int READ_FILE_HEADER_SIZE = 64;
  private static String TAG;
  private static HashMap<String, AudioFormat.AudioType> mGuessFormatResultCache;
  private static HashMap<String, AudioFormat.AudioType> mRecognitionResultCache;
  
  static
  {
    AppMethodBeat.i(114289);
    TAG = "AudioRecognition";
    mRecognitionResultCache = new HashMap();
    mGuessFormatResultCache = new HashMap();
    AppMethodBeat.o(114289);
  }
  
  public static int calcBitDept(long paramLong1, long paramLong2, int paramInt, long paramLong3)
  {
    AppMethodBeat.i(114287);
    if ((0L == paramLong2) || (paramInt == 0))
    {
      AppMethodBeat.o(114287);
      return 0;
    }
    double d = 1000.0F * (float)paramLong1 / (float)(paramInt * paramLong2 * paramLong3);
    int i = (int)Math.round(d);
    Logger.i(TAG, "byteNumbers = " + paramLong1 + ",time = " + paramLong2 + ",channels = " + paramInt + ",sampleRate = " + paramLong3 + ",bitDept = " + d);
    AppMethodBeat.o(114287);
    return i;
  }
  
  /* Error */
  public static int getAudioBitDept(com.tencent.qqmusic.mediaplayer.codec.BaseDecoder paramBaseDecoder, AudioInformation paramAudioInformation)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: ldc 90
    //   5: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_1
    //   9: invokevirtual 96	com/tencent/qqmusic/mediaplayer/AudioInformation:getAudioType	()Lcom/tencent/qqmusic/mediaplayer/AudioFormat$AudioType;
    //   12: getstatic 102	com/tencent/qqmusic/mediaplayer/AudioFormat$AudioType:FLAC	Lcom/tencent/qqmusic/mediaplayer/AudioFormat$AudioType;
    //   15: if_acmpne +105 -> 120
    //   18: iconst_1
    //   19: istore_3
    //   20: iload 4
    //   22: istore_2
    //   23: iload_3
    //   24: ifeq +13 -> 37
    //   27: aload_0
    //   28: invokevirtual 108	com/tencent/qqmusic/mediaplayer/codec/BaseDecoder:getMinBufferSize	()J
    //   31: lstore 5
    //   33: lload 5
    //   35: l2i
    //   36: istore_2
    //   37: aload_1
    //   38: invokevirtual 111	com/tencent/qqmusic/mediaplayer/AudioInformation:getSampleRate	()J
    //   41: l2i
    //   42: aload_1
    //   43: invokevirtual 115	com/tencent/qqmusic/mediaplayer/AudioInformation:getChannels	()I
    //   46: iconst_2
    //   47: invokestatic 120	android/media/AudioTrack:getMinBufferSize	(III)I
    //   50: istore 4
    //   52: iload_3
    //   53: ifne +99 -> 152
    //   56: iload 4
    //   58: sipush 2048
    //   61: irem
    //   62: ifeq +84 -> 146
    //   65: iload 4
    //   67: sipush 2048
    //   70: idiv
    //   71: iconst_1
    //   72: iadd
    //   73: sipush 2048
    //   76: imul
    //   77: istore_2
    //   78: aload_0
    //   79: iload_2
    //   80: iload_2
    //   81: newarray byte
    //   83: invokevirtual 124	com/tencent/qqmusic/mediaplayer/codec/BaseDecoder:decodeData	(I[B)I
    //   86: istore_3
    //   87: iload_3
    //   88: ifgt +53 -> 141
    //   91: iload_2
    //   92: iconst_2
    //   93: imul
    //   94: istore_2
    //   95: iload_2
    //   96: i2l
    //   97: aload_0
    //   98: invokevirtual 127	com/tencent/qqmusic/mediaplayer/codec/BaseDecoder:getCurrentTime	()J
    //   101: aload_1
    //   102: invokevirtual 115	com/tencent/qqmusic/mediaplayer/AudioInformation:getChannels	()I
    //   105: aload_1
    //   106: invokevirtual 111	com/tencent/qqmusic/mediaplayer/AudioInformation:getSampleRate	()J
    //   109: invokestatic 129	com/tencent/qqmusic/mediaplayer/AudioRecognition:calcBitDept	(JJIJ)I
    //   112: istore_2
    //   113: ldc 90
    //   115: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   118: iload_2
    //   119: ireturn
    //   120: iconst_0
    //   121: istore_3
    //   122: goto -102 -> 20
    //   125: astore 7
    //   127: getstatic 26	com/tencent/qqmusic/mediaplayer/AudioRecognition:TAG	Ljava/lang/String;
    //   130: aload 7
    //   132: invokestatic 133	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   135: iload 4
    //   137: istore_2
    //   138: goto -101 -> 37
    //   141: iload_3
    //   142: istore_2
    //   143: goto -48 -> 95
    //   146: iload 4
    //   148: istore_2
    //   149: goto -71 -> 78
    //   152: goto -74 -> 78
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	155	0	paramBaseDecoder	com.tencent.qqmusic.mediaplayer.codec.BaseDecoder
    //   0	155	1	paramAudioInformation	AudioInformation
    //   22	127	2	i	int
    //   19	123	3	j	int
    //   1	146	4	k	int
    //   31	3	5	l	long
    //   125	6	7	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   27	33	125	finally
  }
  
  public static NativeDecoder getDecoderFormFile(String paramString)
  {
    AppMethodBeat.i(114285);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(114285);
      return null;
    }
    NativeDecoder localNativeDecoder = new NativeDecoder();
    if (localNativeDecoder.init(paramString, false) == 0)
    {
      AppMethodBeat.o(114285);
      return localNativeDecoder;
    }
    AppMethodBeat.o(114285);
    return null;
  }
  
  public static AudioFormat.AudioType guessFormat(String paramString)
  {
    AppMethodBeat.i(114284);
    if ((mGuessFormatResultCache != null) && (mGuessFormatResultCache.containsKey(paramString)))
    {
      paramString = (AudioFormat.AudioType)mGuessFormatResultCache.get(paramString);
      AppMethodBeat.o(114284);
      return paramString;
    }
    Iterator localIterator = MediaCodecFactory.getSupportAudioType().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = MediaCodecFactory.createDecoderByType((AudioFormat.AudioType)localIterator.next());
      if (localObject != null)
      {
        localObject = ((IAudioRecognition)localObject).guessAudioType(paramString);
        if (AudioFormat.isAudioType((AudioFormat.AudioType)localObject))
        {
          mGuessFormatResultCache.put(paramString, localObject);
          AppMethodBeat.o(114284);
          return localObject;
        }
      }
    }
    paramString = AudioFormat.AudioType.UNSUPPORT;
    AppMethodBeat.o(114284);
    return paramString;
  }
  
  public static AudioFormat.AudioType recognitionAudioFormatByExtensions(String paramString)
  {
    AppMethodBeat.i(114283);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(114283);
      return null;
    }
    if (mRecognitionResultCache.containsKey(paramString))
    {
      localObject1 = (AudioFormat.AudioType)mRecognitionResultCache.get(paramString);
      Logger.w(TAG, "Get from cache " + localObject1 + ",filepath = " + paramString + ",retType = " + localObject1);
      AppMethodBeat.o(114283);
      return localObject1;
    }
    AudioFormat.AudioType localAudioType = guessFormat(paramString);
    Object localObject1 = localAudioType;
    if (!AudioFormat.isAudioType(localAudioType)) {
      Logger.i(TAG, "recognitionAudioFormatByExtensions guessAudioType = null,so recognitionAudioFormatExactly filepath = ".concat(String.valueOf(paramString)));
    }
    try
    {
      localObject1 = recognitionAudioFormatExactly(paramString);
      Logger.i(TAG, "recognitionAudioFormatByExtensions filepath = " + paramString + ",guessAudioType = " + localObject1);
      AppMethodBeat.o(114283);
      return localObject1;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Logger.e(TAG, localIOException);
        Object localObject2 = localAudioType;
      }
    }
  }
  
  /* Error */
  public static AudioFormat.AudioType recognitionAudioFormatExactly(String paramString)
  {
    // Byte code:
    //   0: ldc 246
    //   2: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ifnonnull +10 -> 16
    //   9: ldc 246
    //   11: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   14: aconst_null
    //   15: areturn
    //   16: getstatic 35	com/tencent/qqmusic/mediaplayer/AudioRecognition:mGuessFormatResultCache	Ljava/util/HashMap;
    //   19: aload_0
    //   20: invokevirtual 249	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   23: pop
    //   24: getstatic 26	com/tencent/qqmusic/mediaplayer/AudioRecognition:TAG	Ljava/lang/String;
    //   27: ldc 251
    //   29: aload_0
    //   30: invokestatic 230	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   33: invokevirtual 234	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   36: invokestatic 87	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   39: new 253	java/io/File
    //   42: dup
    //   43: aload_0
    //   44: invokespecial 254	java/io/File:<init>	(Ljava/lang/String;)V
    //   47: astore 4
    //   49: aload 4
    //   51: invokevirtual 257	java/io/File:exists	()Z
    //   54: ifne +28 -> 82
    //   57: new 259	java/io/FileNotFoundException
    //   60: dup
    //   61: ldc_w 261
    //   64: aload_0
    //   65: invokestatic 230	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   68: invokevirtual 234	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   71: invokespecial 262	java/io/FileNotFoundException:<init>	(Ljava/lang/String;)V
    //   74: astore_0
    //   75: ldc 246
    //   77: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   80: aload_0
    //   81: athrow
    //   82: aload 4
    //   84: invokevirtual 265	java/io/File:canRead	()Z
    //   87: ifne +28 -> 115
    //   90: new 207	java/io/IOException
    //   93: dup
    //   94: ldc_w 267
    //   97: aload_0
    //   98: invokestatic 230	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   101: invokevirtual 234	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   104: invokespecial 268	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   107: astore_0
    //   108: ldc 246
    //   110: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   113: aload_0
    //   114: athrow
    //   115: getstatic 26	com/tencent/qqmusic/mediaplayer/AudioRecognition:TAG	Ljava/lang/String;
    //   118: new 52	java/lang/StringBuilder
    //   121: dup
    //   122: ldc_w 270
    //   125: invokespecial 57	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   128: aload 4
    //   130: invokevirtual 273	java/io/File:length	()J
    //   133: invokevirtual 61	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   136: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   139: invokestatic 87	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   142: invokestatic 278	java/lang/System:currentTimeMillis	()J
    //   145: lstore_2
    //   146: aload_0
    //   147: invokestatic 222	com/tencent/qqmusic/mediaplayer/AudioRecognition:guessFormat	(Ljava/lang/String;)Lcom/tencent/qqmusic/mediaplayer/AudioFormat$AudioType;
    //   150: astore 9
    //   152: invokestatic 166	com/tencent/qqmusic/mediaplayer/MediaCodecFactory:getSupportAudioType	()Ljava/util/ArrayList;
    //   155: astore 10
    //   157: aload 9
    //   159: ifnull +58 -> 217
    //   162: aload 10
    //   164: aload 9
    //   166: invokevirtual 281	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   169: ifeq +48 -> 217
    //   172: aload 10
    //   174: aload 9
    //   176: invokevirtual 283	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   179: pop
    //   180: aload 10
    //   182: iconst_0
    //   183: aload 9
    //   185: invokevirtual 287	java/util/ArrayList:add	(ILjava/lang/Object;)V
    //   188: getstatic 290	com/tencent/qqmusic/mediaplayer/AudioFormat$AudioType:MP3	Lcom/tencent/qqmusic/mediaplayer/AudioFormat$AudioType;
    //   191: aload 9
    //   193: invokevirtual 293	com/tencent/qqmusic/mediaplayer/AudioFormat$AudioType:equals	(Ljava/lang/Object;)Z
    //   196: ifeq +21 -> 217
    //   199: aload 10
    //   201: getstatic 102	com/tencent/qqmusic/mediaplayer/AudioFormat$AudioType:FLAC	Lcom/tencent/qqmusic/mediaplayer/AudioFormat$AudioType;
    //   204: invokevirtual 283	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   207: pop
    //   208: aload 10
    //   210: iconst_0
    //   211: getstatic 102	com/tencent/qqmusic/mediaplayer/AudioFormat$AudioType:FLAC	Lcom/tencent/qqmusic/mediaplayer/AudioFormat$AudioType;
    //   214: invokevirtual 287	java/util/ArrayList:add	(ILjava/lang/Object;)V
    //   217: aload_0
    //   218: invokestatic 297	com/tencent/qqmusic/mediaplayer/codec/MediaCodecDecoder:getAudioType	(Ljava/lang/String;)Lcom/tencent/qqmusic/mediaplayer/AudioFormat$AudioType;
    //   221: astore 8
    //   223: aload 8
    //   225: invokestatic 197	com/tencent/qqmusic/mediaplayer/AudioFormat:isAudioType	(Lcom/tencent/qqmusic/mediaplayer/AudioFormat$AudioType;)Z
    //   228: ifne +501 -> 729
    //   231: new 299	java/io/FileInputStream
    //   234: dup
    //   235: aload_0
    //   236: invokespecial 300	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   239: astore 7
    //   241: aload 7
    //   243: astore 5
    //   245: sipush 1024
    //   248: newarray byte
    //   250: astore 11
    //   252: aload 7
    //   254: astore 5
    //   256: aload 7
    //   258: aload 11
    //   260: invokevirtual 306	java/io/InputStream:read	([B)I
    //   263: istore_1
    //   264: iload_1
    //   265: bipush 64
    //   267: if_icmplt +472 -> 739
    //   270: aload 7
    //   272: astore 5
    //   274: bipush 64
    //   276: newarray byte
    //   278: astore 4
    //   280: aload 7
    //   282: astore 5
    //   284: aload 4
    //   286: astore 6
    //   288: aload 11
    //   290: iconst_0
    //   291: aload 4
    //   293: iconst_0
    //   294: bipush 64
    //   296: invokestatic 310	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   299: aload 7
    //   301: astore 5
    //   303: aload 4
    //   305: astore 6
    //   307: getstatic 26	com/tencent/qqmusic/mediaplayer/AudioRecognition:TAG	Ljava/lang/String;
    //   310: new 52	java/lang/StringBuilder
    //   313: dup
    //   314: ldc_w 312
    //   317: invokespecial 57	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   320: new 226	java/lang/String
    //   323: dup
    //   324: aload 11
    //   326: iconst_0
    //   327: iload_1
    //   328: invokespecial 315	java/lang/String:<init>	([BII)V
    //   331: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   334: ldc_w 317
    //   337: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: aload_0
    //   341: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   347: invokestatic 87	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   350: aload 7
    //   352: invokevirtual 320	java/io/InputStream:close	()V
    //   355: aload 10
    //   357: invokevirtual 172	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   360: astore 6
    //   362: aload 6
    //   364: invokeinterface 178 1 0
    //   369: ifeq +360 -> 729
    //   372: aload 6
    //   374: invokeinterface 182 1 0
    //   379: checkcast 98	com/tencent/qqmusic/mediaplayer/AudioFormat$AudioType
    //   382: invokestatic 186	com/tencent/qqmusic/mediaplayer/MediaCodecFactory:createDecoderByType	(Lcom/tencent/qqmusic/mediaplayer/AudioFormat$AudioType;)Lcom/tencent/qqmusic/mediaplayer/codec/IAudioRecognition;
    //   385: astore 5
    //   387: aload 5
    //   389: ifnull -27 -> 362
    //   392: aload 5
    //   394: aload_0
    //   395: aload 4
    //   397: invokeinterface 323 3 0
    //   402: astore 5
    //   404: aload 5
    //   406: invokestatic 197	com/tencent/qqmusic/mediaplayer/AudioFormat:isAudioType	(Lcom/tencent/qqmusic/mediaplayer/AudioFormat$AudioType;)Z
    //   409: ifeq -47 -> 362
    //   412: getstatic 26	com/tencent/qqmusic/mediaplayer/AudioRecognition:TAG	Ljava/lang/String;
    //   415: new 52	java/lang/StringBuilder
    //   418: dup
    //   419: ldc_w 325
    //   422: invokespecial 57	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   425: aload 5
    //   427: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   430: ldc_w 327
    //   433: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: aload_0
    //   437: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   440: ldc_w 329
    //   443: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   446: invokestatic 278	java/lang/System:currentTimeMillis	()J
    //   449: lload_2
    //   450: lsub
    //   451: invokevirtual 61	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   454: ldc_w 331
    //   457: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   460: aload 5
    //   462: aload 9
    //   464: invokevirtual 293	com/tencent/qqmusic/mediaplayer/AudioFormat$AudioType:equals	(Ljava/lang/Object;)Z
    //   467: invokevirtual 334	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   470: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   473: invokestatic 220	com/tencent/qqmusic/mediaplayer/util/Logger:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   476: aload 5
    //   478: ifnonnull +163 -> 641
    //   481: getstatic 204	com/tencent/qqmusic/mediaplayer/AudioFormat$AudioType:UNSUPPORT	Lcom/tencent/qqmusic/mediaplayer/AudioFormat$AudioType;
    //   484: astore 5
    //   486: getstatic 26	com/tencent/qqmusic/mediaplayer/AudioRecognition:TAG	Ljava/lang/String;
    //   489: new 52	java/lang/StringBuilder
    //   492: dup
    //   493: ldc_w 336
    //   496: invokespecial 57	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   499: aload_0
    //   500: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   503: ldc 217
    //   505: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: aload 5
    //   510: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   513: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   516: invokestatic 87	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   519: ldc 246
    //   521: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   524: aload 5
    //   526: areturn
    //   527: astore 5
    //   529: getstatic 26	com/tencent/qqmusic/mediaplayer/AudioRecognition:TAG	Ljava/lang/String;
    //   532: aload 5
    //   534: invokestatic 133	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   537: goto -182 -> 355
    //   540: astore 6
    //   542: aconst_null
    //   543: astore 4
    //   545: aconst_null
    //   546: astore 7
    //   548: aload 7
    //   550: astore 5
    //   552: getstatic 26	com/tencent/qqmusic/mediaplayer/AudioRecognition:TAG	Ljava/lang/String;
    //   555: aload 6
    //   557: invokestatic 133	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   560: aload 7
    //   562: ifnull +174 -> 736
    //   565: aload 7
    //   567: invokevirtual 320	java/io/InputStream:close	()V
    //   570: goto -215 -> 355
    //   573: astore 5
    //   575: getstatic 26	com/tencent/qqmusic/mediaplayer/AudioRecognition:TAG	Ljava/lang/String;
    //   578: aload 5
    //   580: invokestatic 133	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   583: goto -228 -> 355
    //   586: astore_0
    //   587: aconst_null
    //   588: astore 5
    //   590: aload 5
    //   592: ifnull +8 -> 600
    //   595: aload 5
    //   597: invokevirtual 320	java/io/InputStream:close	()V
    //   600: ldc 246
    //   602: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   605: aload_0
    //   606: athrow
    //   607: astore 4
    //   609: getstatic 26	com/tencent/qqmusic/mediaplayer/AudioRecognition:TAG	Ljava/lang/String;
    //   612: aload 4
    //   614: invokestatic 133	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   617: goto -17 -> 600
    //   620: astore 5
    //   622: getstatic 26	com/tencent/qqmusic/mediaplayer/AudioRecognition:TAG	Ljava/lang/String;
    //   625: ldc_w 338
    //   628: aload 5
    //   630: invokestatic 341	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   633: getstatic 204	com/tencent/qqmusic/mediaplayer/AudioFormat$AudioType:UNSUPPORT	Lcom/tencent/qqmusic/mediaplayer/AudioFormat$AudioType;
    //   636: astore 5
    //   638: goto -234 -> 404
    //   641: getstatic 26	com/tencent/qqmusic/mediaplayer/AudioRecognition:TAG	Ljava/lang/String;
    //   644: new 52	java/lang/StringBuilder
    //   647: dup
    //   648: ldc_w 343
    //   651: invokespecial 57	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   654: aload_0
    //   655: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   658: ldc_w 345
    //   661: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   664: aload 5
    //   666: invokevirtual 213	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   669: ldc_w 347
    //   672: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   675: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   678: invokestatic 87	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   681: getstatic 33	com/tencent/qqmusic/mediaplayer/AudioRecognition:mRecognitionResultCache	Ljava/util/HashMap;
    //   684: aload_0
    //   685: aload 5
    //   687: invokevirtual 201	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   690: pop
    //   691: getstatic 35	com/tencent/qqmusic/mediaplayer/AudioRecognition:mGuessFormatResultCache	Ljava/util/HashMap;
    //   694: aload_0
    //   695: aload 5
    //   697: invokevirtual 201	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   700: pop
    //   701: goto -215 -> 486
    //   704: astore_0
    //   705: goto -115 -> 590
    //   708: astore 6
    //   710: aconst_null
    //   711: astore 4
    //   713: goto -165 -> 548
    //   716: astore 5
    //   718: aload 6
    //   720: astore 4
    //   722: aload 5
    //   724: astore 6
    //   726: goto -178 -> 548
    //   729: aload 8
    //   731: astore 5
    //   733: goto -257 -> 476
    //   736: goto -381 -> 355
    //   739: aconst_null
    //   740: astore 4
    //   742: goto -443 -> 299
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	745	0	paramString	String
    //   263	65	1	i	int
    //   145	305	2	l	long
    //   47	497	4	localObject1	Object
    //   607	6	4	localException1	java.lang.Exception
    //   711	30	4	localObject2	Object
    //   243	282	5	localObject3	Object
    //   527	6	5	localException2	java.lang.Exception
    //   550	1	5	localFileInputStream1	java.io.FileInputStream
    //   573	6	5	localException3	java.lang.Exception
    //   588	8	5	localObject4	Object
    //   620	9	5	localSoNotFindException	SoNotFindException
    //   636	60	5	localAudioType1	AudioFormat.AudioType
    //   716	7	5	localException4	java.lang.Exception
    //   731	1	5	localAudioType2	AudioFormat.AudioType
    //   286	87	6	localObject5	Object
    //   540	16	6	localException5	java.lang.Exception
    //   708	11	6	localException6	java.lang.Exception
    //   724	1	6	localException7	java.lang.Exception
    //   239	327	7	localFileInputStream2	java.io.FileInputStream
    //   221	509	8	localAudioType3	AudioFormat.AudioType
    //   150	313	9	localAudioType4	AudioFormat.AudioType
    //   155	201	10	localArrayList	ArrayList
    //   250	75	11	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   350	355	527	java/lang/Exception
    //   231	241	540	java/lang/Exception
    //   565	570	573	java/lang/Exception
    //   231	241	586	finally
    //   595	600	607	java/lang/Exception
    //   392	404	620	com/tencent/qqmusic/mediaplayer/SoNotFindException
    //   245	252	704	finally
    //   256	264	704	finally
    //   274	280	704	finally
    //   288	299	704	finally
    //   307	350	704	finally
    //   552	560	704	finally
    //   245	252	708	java/lang/Exception
    //   256	264	708	java/lang/Exception
    //   274	280	708	java/lang/Exception
    //   288	299	716	java/lang/Exception
    //   307	350	716	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.AudioRecognition
 * JD-Core Version:    0.7.0.1
 */
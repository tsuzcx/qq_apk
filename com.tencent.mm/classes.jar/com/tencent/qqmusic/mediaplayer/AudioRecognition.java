package com.tencent.qqmusic.mediaplayer;

import android.media.AudioTrack;
import android.text.TextUtils;
import com.tencent.qqmusic.mediaplayer.codec.BaseDecoder;
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
  private static String TAG = "AudioRecognition";
  private static HashMap<String, AudioFormat.AudioType> mGuessFormatResultCache = new HashMap();
  private static HashMap<String, AudioFormat.AudioType> mRecognitionResultCache = new HashMap();
  
  public static int calcBitDept(long paramLong1, long paramLong2, int paramInt, long paramLong3)
  {
    if ((0L == paramLong2) || (paramInt == 0)) {
      return 0;
    }
    double d = 1000.0F * (float)paramLong1 / (float)(paramInt * paramLong2 * paramLong3);
    int i = (int)Math.round(d);
    Logger.i(TAG, "byteNumbers = " + paramLong1 + ",time = " + paramLong2 + ",channels = " + paramInt + ",sampleRate = " + paramLong3 + ",bitDept = " + d);
    return i;
  }
  
  public static int getAudioBitDept(BaseDecoder paramBaseDecoder, AudioInformation paramAudioInformation)
  {
    k = 0;
    if (paramAudioInformation.getAudioType() == AudioFormat.AudioType.FLAC) {}
    for (j = 1;; j = 0)
    {
      i = k;
      if (j != 0) {}
      try
      {
        long l = paramBaseDecoder.getMinBufferSize();
        i = (int)l;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          Logger.e(TAG, localThrowable);
          i = k;
          continue;
          i = j;
          continue;
          i = k;
        }
      }
      k = AudioTrack.getMinBufferSize((int)paramAudioInformation.getSampleRate(), paramAudioInformation.getChannels(), 2);
      if (j != 0) {
        break label140;
      }
      if (k % 2048 == 0) {
        break label134;
      }
      i = (k / 2048 + 1) * 2048;
      j = paramBaseDecoder.decodeData(i, new byte[i]);
      if (j > 0) {
        break;
      }
      i *= 2;
      return calcBitDept(i, paramBaseDecoder.getCurrentTime(), paramAudioInformation.getChannels(), paramAudioInformation.getSampleRate());
    }
  }
  
  public static NativeDecoder getDecoderFormFile(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    NativeDecoder localNativeDecoder = new NativeDecoder();
    localNativeDecoder.init(paramString, false);
    return localNativeDecoder;
  }
  
  public static AudioFormat.AudioType guessFormat(String paramString)
  {
    if ((mGuessFormatResultCache != null) && (mGuessFormatResultCache.containsKey(paramString))) {
      return (AudioFormat.AudioType)mGuessFormatResultCache.get(paramString);
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
          return localObject;
        }
      }
    }
    return AudioFormat.AudioType.UNSUPPORT;
  }
  
  public static AudioFormat.AudioType recognitionAudioFormatByExtensions(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    if (mRecognitionResultCache.containsKey(paramString))
    {
      localObject1 = (AudioFormat.AudioType)mRecognitionResultCache.get(paramString);
      Logger.w(TAG, "Get from cache " + localObject1 + ",filepath = " + paramString + ",retType = " + localObject1);
      return localObject1;
    }
    AudioFormat.AudioType localAudioType = guessFormat(paramString);
    Object localObject1 = localAudioType;
    if (!AudioFormat.isAudioType(localAudioType)) {
      Logger.i(TAG, "recognitionAudioFormatByExtensions guessAudioType = null,so recognitionAudioFormatExactly filepath = " + paramString);
    }
    try
    {
      localObject1 = recognitionAudioFormatExactly(paramString);
      Logger.i(TAG, "recognitionAudioFormatByExtensions filepath = " + paramString + ",guessAudioType = " + localObject1);
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
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: getstatic 28	com/tencent/qqmusic/mediaplayer/AudioRecognition:mGuessFormatResultCache	Ljava/util/HashMap;
    //   9: aload_0
    //   10: invokevirtual 226	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   13: pop
    //   14: getstatic 19	com/tencent/qqmusic/mediaplayer/AudioRecognition:TAG	Ljava/lang/String;
    //   17: new 41	java/lang/StringBuilder
    //   20: dup
    //   21: ldc 228
    //   23: invokespecial 46	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   26: aload_0
    //   27: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: invokestatic 77	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   36: new 230	java/io/File
    //   39: dup
    //   40: aload_0
    //   41: invokespecial 231	java/io/File:<init>	(Ljava/lang/String;)V
    //   44: astore 4
    //   46: aload 4
    //   48: invokevirtual 234	java/io/File:exists	()Z
    //   51: ifne +27 -> 78
    //   54: new 236	java/io/FileNotFoundException
    //   57: dup
    //   58: new 41	java/lang/StringBuilder
    //   61: dup
    //   62: ldc 238
    //   64: invokespecial 46	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   67: aload_0
    //   68: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: invokespecial 239	java/io/FileNotFoundException:<init>	(Ljava/lang/String;)V
    //   77: athrow
    //   78: aload 4
    //   80: invokevirtual 242	java/io/File:canRead	()Z
    //   83: ifne +27 -> 110
    //   86: new 196	java/io/IOException
    //   89: dup
    //   90: new 41	java/lang/StringBuilder
    //   93: dup
    //   94: ldc 244
    //   96: invokespecial 46	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   99: aload_0
    //   100: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   106: invokespecial 245	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   109: athrow
    //   110: getstatic 19	com/tencent/qqmusic/mediaplayer/AudioRecognition:TAG	Ljava/lang/String;
    //   113: new 41	java/lang/StringBuilder
    //   116: dup
    //   117: ldc 247
    //   119: invokespecial 46	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   122: aload 4
    //   124: invokevirtual 250	java/io/File:length	()J
    //   127: invokevirtual 50	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   130: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: invokestatic 77	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   136: invokestatic 255	java/lang/System:currentTimeMillis	()J
    //   139: lstore_2
    //   140: aload_0
    //   141: invokestatic 210	com/tencent/qqmusic/mediaplayer/AudioRecognition:guessFormat	(Ljava/lang/String;)Lcom/tencent/qqmusic/mediaplayer/AudioFormat$AudioType;
    //   144: astore 8
    //   146: invokestatic 155	com/tencent/qqmusic/mediaplayer/MediaCodecFactory:getSupportAudioType	()Ljava/util/ArrayList;
    //   149: astore 9
    //   151: aload 8
    //   153: ifnull +58 -> 211
    //   156: aload 9
    //   158: aload 8
    //   160: invokevirtual 258	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   163: ifeq +48 -> 211
    //   166: aload 9
    //   168: aload 8
    //   170: invokevirtual 260	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   173: pop
    //   174: aload 9
    //   176: iconst_0
    //   177: aload 8
    //   179: invokevirtual 264	java/util/ArrayList:add	(ILjava/lang/Object;)V
    //   182: getstatic 267	com/tencent/qqmusic/mediaplayer/AudioFormat$AudioType:MP3	Lcom/tencent/qqmusic/mediaplayer/AudioFormat$AudioType;
    //   185: aload 8
    //   187: invokevirtual 270	com/tencent/qqmusic/mediaplayer/AudioFormat$AudioType:equals	(Ljava/lang/Object;)Z
    //   190: ifeq +21 -> 211
    //   193: aload 9
    //   195: getstatic 93	com/tencent/qqmusic/mediaplayer/AudioFormat$AudioType:FLAC	Lcom/tencent/qqmusic/mediaplayer/AudioFormat$AudioType;
    //   198: invokevirtual 260	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   201: pop
    //   202: aload 9
    //   204: iconst_0
    //   205: getstatic 93	com/tencent/qqmusic/mediaplayer/AudioFormat$AudioType:FLAC	Lcom/tencent/qqmusic/mediaplayer/AudioFormat$AudioType;
    //   208: invokevirtual 264	java/util/ArrayList:add	(ILjava/lang/Object;)V
    //   211: new 272	java/io/FileInputStream
    //   214: dup
    //   215: aload_0
    //   216: invokespecial 273	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   219: astore 7
    //   221: aload 7
    //   223: astore 5
    //   225: sipush 1024
    //   228: invokestatic 279	com/tencent/qqmusic/mediaplayer/CacheBytesManager:getStatic	(I)[B
    //   231: astore 10
    //   233: aload 7
    //   235: astore 5
    //   237: aload 7
    //   239: aload 10
    //   241: invokevirtual 285	java/io/InputStream:read	([B)I
    //   244: istore_1
    //   245: iload_1
    //   246: bipush 64
    //   248: if_icmplt +475 -> 723
    //   251: aload 7
    //   253: astore 5
    //   255: bipush 64
    //   257: newarray byte
    //   259: astore 4
    //   261: aload 7
    //   263: astore 5
    //   265: aload 4
    //   267: astore 6
    //   269: aload 10
    //   271: iconst_0
    //   272: aload 4
    //   274: iconst_0
    //   275: bipush 64
    //   277: invokestatic 289	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   280: aload 7
    //   282: astore 5
    //   284: aload 4
    //   286: astore 6
    //   288: aload 10
    //   290: invokestatic 293	com/tencent/qqmusic/mediaplayer/CacheBytesManager:recycle	([B)[B
    //   293: pop
    //   294: aload 7
    //   296: astore 5
    //   298: aload 4
    //   300: astore 6
    //   302: getstatic 19	com/tencent/qqmusic/mediaplayer/AudioRecognition:TAG	Ljava/lang/String;
    //   305: new 41	java/lang/StringBuilder
    //   308: dup
    //   309: ldc_w 295
    //   312: invokespecial 46	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   315: new 297	java/lang/String
    //   318: dup
    //   319: aload 10
    //   321: iconst_0
    //   322: iload_1
    //   323: invokespecial 300	java/lang/String:<init>	([BII)V
    //   326: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: ldc_w 302
    //   332: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: aload_0
    //   336: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   342: invokestatic 77	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   345: aload 7
    //   347: invokevirtual 305	java/io/InputStream:close	()V
    //   350: aload 9
    //   352: invokevirtual 161	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   355: astore 6
    //   357: aload 6
    //   359: invokeinterface 167 1 0
    //   364: ifeq +350 -> 714
    //   367: aload 6
    //   369: invokeinterface 171 1 0
    //   374: checkcast 89	com/tencent/qqmusic/mediaplayer/AudioFormat$AudioType
    //   377: invokestatic 175	com/tencent/qqmusic/mediaplayer/MediaCodecFactory:createDecoderByType	(Lcom/tencent/qqmusic/mediaplayer/AudioFormat$AudioType;)Lcom/tencent/qqmusic/mediaplayer/codec/IAudioRecognition;
    //   380: astore 5
    //   382: aload 5
    //   384: ifnull -27 -> 357
    //   387: aload 5
    //   389: aload_0
    //   390: aload 4
    //   392: invokeinterface 308 3 0
    //   397: astore 5
    //   399: aload 5
    //   401: invokestatic 186	com/tencent/qqmusic/mediaplayer/AudioFormat:isAudioType	(Lcom/tencent/qqmusic/mediaplayer/AudioFormat$AudioType;)Z
    //   404: ifeq -47 -> 357
    //   407: getstatic 19	com/tencent/qqmusic/mediaplayer/AudioRecognition:TAG	Ljava/lang/String;
    //   410: new 41	java/lang/StringBuilder
    //   413: dup
    //   414: ldc_w 310
    //   417: invokespecial 46	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   420: aload 5
    //   422: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   425: ldc_w 312
    //   428: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: aload_0
    //   432: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: ldc_w 314
    //   438: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   441: invokestatic 255	java/lang/System:currentTimeMillis	()J
    //   444: lload_2
    //   445: lsub
    //   446: invokevirtual 50	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   449: ldc_w 316
    //   452: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   455: aload 5
    //   457: aload 8
    //   459: invokevirtual 270	com/tencent/qqmusic/mediaplayer/AudioFormat$AudioType:equals	(Ljava/lang/Object;)Z
    //   462: invokevirtual 319	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   465: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   468: invokestatic 208	com/tencent/qqmusic/mediaplayer/util/Logger:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   471: aload 5
    //   473: ifnonnull +153 -> 626
    //   476: getstatic 193	com/tencent/qqmusic/mediaplayer/AudioFormat$AudioType:UNSUPPORT	Lcom/tencent/qqmusic/mediaplayer/AudioFormat$AudioType;
    //   479: astore 5
    //   481: getstatic 19	com/tencent/qqmusic/mediaplayer/AudioRecognition:TAG	Ljava/lang/String;
    //   484: new 41	java/lang/StringBuilder
    //   487: dup
    //   488: ldc_w 321
    //   491: invokespecial 46	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   494: aload_0
    //   495: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   498: ldc 205
    //   500: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   503: aload 5
    //   505: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   508: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   511: invokestatic 77	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   514: aload 5
    //   516: areturn
    //   517: astore 5
    //   519: getstatic 19	com/tencent/qqmusic/mediaplayer/AudioRecognition:TAG	Ljava/lang/String;
    //   522: aload 5
    //   524: invokestatic 124	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   527: goto -177 -> 350
    //   530: astore 6
    //   532: aconst_null
    //   533: astore 4
    //   535: aconst_null
    //   536: astore 7
    //   538: aload 7
    //   540: astore 5
    //   542: getstatic 19	com/tencent/qqmusic/mediaplayer/AudioRecognition:TAG	Ljava/lang/String;
    //   545: aload 6
    //   547: invokestatic 124	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   550: aload 7
    //   552: ifnull +168 -> 720
    //   555: aload 7
    //   557: invokevirtual 305	java/io/InputStream:close	()V
    //   560: goto -210 -> 350
    //   563: astore 5
    //   565: getstatic 19	com/tencent/qqmusic/mediaplayer/AudioRecognition:TAG	Ljava/lang/String;
    //   568: aload 5
    //   570: invokestatic 124	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   573: goto -223 -> 350
    //   576: astore_0
    //   577: aconst_null
    //   578: astore 5
    //   580: aload 5
    //   582: ifnull +8 -> 590
    //   585: aload 5
    //   587: invokevirtual 305	java/io/InputStream:close	()V
    //   590: aload_0
    //   591: athrow
    //   592: astore 4
    //   594: getstatic 19	com/tencent/qqmusic/mediaplayer/AudioRecognition:TAG	Ljava/lang/String;
    //   597: aload 4
    //   599: invokestatic 124	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   602: goto -12 -> 590
    //   605: astore 5
    //   607: getstatic 19	com/tencent/qqmusic/mediaplayer/AudioRecognition:TAG	Ljava/lang/String;
    //   610: ldc_w 323
    //   613: aload 5
    //   615: invokestatic 326	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   618: getstatic 193	com/tencent/qqmusic/mediaplayer/AudioFormat$AudioType:UNSUPPORT	Lcom/tencent/qqmusic/mediaplayer/AudioFormat$AudioType;
    //   621: astore 5
    //   623: goto -224 -> 399
    //   626: getstatic 19	com/tencent/qqmusic/mediaplayer/AudioRecognition:TAG	Ljava/lang/String;
    //   629: new 41	java/lang/StringBuilder
    //   632: dup
    //   633: ldc_w 328
    //   636: invokespecial 46	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   639: aload_0
    //   640: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   643: ldc_w 330
    //   646: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   649: aload 5
    //   651: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   654: ldc_w 332
    //   657: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   660: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   663: invokestatic 77	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   666: getstatic 26	com/tencent/qqmusic/mediaplayer/AudioRecognition:mRecognitionResultCache	Ljava/util/HashMap;
    //   669: aload_0
    //   670: aload 5
    //   672: invokevirtual 190	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   675: pop
    //   676: getstatic 28	com/tencent/qqmusic/mediaplayer/AudioRecognition:mGuessFormatResultCache	Ljava/util/HashMap;
    //   679: aload_0
    //   680: aload 5
    //   682: invokevirtual 190	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   685: pop
    //   686: goto -205 -> 481
    //   689: astore_0
    //   690: goto -110 -> 580
    //   693: astore 6
    //   695: aconst_null
    //   696: astore 4
    //   698: goto -160 -> 538
    //   701: astore 5
    //   703: aload 6
    //   705: astore 4
    //   707: aload 5
    //   709: astore 6
    //   711: goto -173 -> 538
    //   714: aconst_null
    //   715: astore 5
    //   717: goto -246 -> 471
    //   720: goto -370 -> 350
    //   723: aconst_null
    //   724: astore 4
    //   726: goto -446 -> 280
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	729	0	paramString	String
    //   244	79	1	i	int
    //   139	306	2	l	long
    //   44	490	4	localObject1	Object
    //   592	6	4	localException1	java.lang.Exception
    //   696	29	4	localObject2	Object
    //   223	292	5	localObject3	Object
    //   517	6	5	localException2	java.lang.Exception
    //   540	1	5	localFileInputStream1	java.io.FileInputStream
    //   563	6	5	localException3	java.lang.Exception
    //   578	8	5	localObject4	Object
    //   605	9	5	localSoNotFindException	SoNotFindException
    //   621	60	5	localAudioType1	AudioFormat.AudioType
    //   701	7	5	localException4	java.lang.Exception
    //   715	1	5	localObject5	Object
    //   267	101	6	localObject6	Object
    //   530	16	6	localException5	java.lang.Exception
    //   693	11	6	localException6	java.lang.Exception
    //   709	1	6	localException7	java.lang.Exception
    //   219	337	7	localFileInputStream2	java.io.FileInputStream
    //   144	314	8	localAudioType2	AudioFormat.AudioType
    //   149	202	9	localArrayList	ArrayList
    //   231	89	10	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   345	350	517	java/lang/Exception
    //   211	221	530	java/lang/Exception
    //   555	560	563	java/lang/Exception
    //   211	221	576	finally
    //   585	590	592	java/lang/Exception
    //   387	399	605	com/tencent/qqmusic/mediaplayer/SoNotFindException
    //   225	233	689	finally
    //   237	245	689	finally
    //   255	261	689	finally
    //   269	280	689	finally
    //   288	294	689	finally
    //   302	345	689	finally
    //   542	550	689	finally
    //   225	233	693	java/lang/Exception
    //   237	245	693	java/lang/Exception
    //   255	261	693	java/lang/Exception
    //   269	280	701	java/lang/Exception
    //   288	294	701	java/lang/Exception
    //   302	345	701	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.AudioRecognition
 * JD-Core Version:    0.7.0.1
 */
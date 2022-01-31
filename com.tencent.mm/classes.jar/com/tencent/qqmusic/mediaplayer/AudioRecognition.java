package com.tencent.qqmusic.mediaplayer;

import android.media.AudioTrack;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
  private static String TAG;
  private static HashMap<String, AudioFormat.AudioType> mGuessFormatResultCache;
  private static HashMap<String, AudioFormat.AudioType> mRecognitionResultCache;
  
  static
  {
    AppMethodBeat.i(128376);
    TAG = "AudioRecognition";
    mRecognitionResultCache = new HashMap();
    mGuessFormatResultCache = new HashMap();
    AppMethodBeat.o(128376);
  }
  
  public static int calcBitDept(long paramLong1, long paramLong2, int paramInt, long paramLong3)
  {
    AppMethodBeat.i(128374);
    if ((0L == paramLong2) || (paramInt == 0))
    {
      AppMethodBeat.o(128374);
      return 0;
    }
    double d = 1000.0F * (float)paramLong1 / (float)(paramInt * paramLong2 * paramLong3);
    int i = (int)Math.round(d);
    Logger.i(TAG, "byteNumbers = " + paramLong1 + ",time = " + paramLong2 + ",channels = " + paramInt + ",sampleRate = " + paramLong3 + ",bitDept = " + d);
    AppMethodBeat.o(128374);
    return i;
  }
  
  public static int getAudioBitDept(BaseDecoder paramBaseDecoder, AudioInformation paramAudioInformation)
  {
    k = 0;
    AppMethodBeat.i(128373);
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
        break label152;
      }
      if (k % 2048 == 0) {
        break label146;
      }
      i = (k / 2048 + 1) * 2048;
      j = paramBaseDecoder.decodeData(i, new byte[i]);
      if (j > 0) {
        break;
      }
      i *= 2;
      i = calcBitDept(i, paramBaseDecoder.getCurrentTime(), paramAudioInformation.getChannels(), paramAudioInformation.getSampleRate());
      AppMethodBeat.o(128373);
      return i;
    }
  }
  
  public static NativeDecoder getDecoderFormFile(String paramString)
  {
    AppMethodBeat.i(128372);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(128372);
      return null;
    }
    NativeDecoder localNativeDecoder = new NativeDecoder();
    localNativeDecoder.init(paramString, false);
    AppMethodBeat.o(128372);
    return localNativeDecoder;
  }
  
  public static AudioFormat.AudioType guessFormat(String paramString)
  {
    AppMethodBeat.i(128371);
    if ((mGuessFormatResultCache != null) && (mGuessFormatResultCache.containsKey(paramString)))
    {
      paramString = (AudioFormat.AudioType)mGuessFormatResultCache.get(paramString);
      AppMethodBeat.o(128371);
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
          AppMethodBeat.o(128371);
          return localObject;
        }
      }
    }
    paramString = AudioFormat.AudioType.UNSUPPORT;
    AppMethodBeat.o(128371);
    return paramString;
  }
  
  public static AudioFormat.AudioType recognitionAudioFormatByExtensions(String paramString)
  {
    AppMethodBeat.i(128370);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(128370);
      return null;
    }
    if (mRecognitionResultCache.containsKey(paramString))
    {
      localObject1 = (AudioFormat.AudioType)mRecognitionResultCache.get(paramString);
      Logger.w(TAG, "Get from cache " + localObject1 + ",filepath = " + paramString + ",retType = " + localObject1);
      AppMethodBeat.o(128370);
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
      AppMethodBeat.o(128370);
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
    //   0: ldc 248
    //   2: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ifnonnull +10 -> 16
    //   9: ldc 248
    //   11: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   14: aconst_null
    //   15: areturn
    //   16: getstatic 35	com/tencent/qqmusic/mediaplayer/AudioRecognition:mGuessFormatResultCache	Ljava/util/HashMap;
    //   19: aload_0
    //   20: invokevirtual 251	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   23: pop
    //   24: getstatic 26	com/tencent/qqmusic/mediaplayer/AudioRecognition:TAG	Ljava/lang/String;
    //   27: ldc 253
    //   29: aload_0
    //   30: invokestatic 232	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   33: invokevirtual 236	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   36: invokestatic 87	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   39: new 255	java/io/File
    //   42: dup
    //   43: aload_0
    //   44: invokespecial 256	java/io/File:<init>	(Ljava/lang/String;)V
    //   47: astore 4
    //   49: aload 4
    //   51: invokevirtual 259	java/io/File:exists	()Z
    //   54: ifne +28 -> 82
    //   57: new 261	java/io/FileNotFoundException
    //   60: dup
    //   61: ldc_w 263
    //   64: aload_0
    //   65: invokestatic 232	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   68: invokevirtual 236	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   71: invokespecial 264	java/io/FileNotFoundException:<init>	(Ljava/lang/String;)V
    //   74: astore_0
    //   75: ldc 248
    //   77: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   80: aload_0
    //   81: athrow
    //   82: aload 4
    //   84: invokevirtual 267	java/io/File:canRead	()Z
    //   87: ifne +28 -> 115
    //   90: new 209	java/io/IOException
    //   93: dup
    //   94: ldc_w 269
    //   97: aload_0
    //   98: invokestatic 232	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   101: invokevirtual 236	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   104: invokespecial 270	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   107: astore_0
    //   108: ldc 248
    //   110: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   113: aload_0
    //   114: athrow
    //   115: getstatic 26	com/tencent/qqmusic/mediaplayer/AudioRecognition:TAG	Ljava/lang/String;
    //   118: new 52	java/lang/StringBuilder
    //   121: dup
    //   122: ldc_w 272
    //   125: invokespecial 57	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   128: aload 4
    //   130: invokevirtual 275	java/io/File:length	()J
    //   133: invokevirtual 61	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   136: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   139: invokestatic 87	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   142: invokestatic 280	java/lang/System:currentTimeMillis	()J
    //   145: lstore_2
    //   146: aload_0
    //   147: invokestatic 224	com/tencent/qqmusic/mediaplayer/AudioRecognition:guessFormat	(Ljava/lang/String;)Lcom/tencent/qqmusic/mediaplayer/AudioFormat$AudioType;
    //   150: astore 8
    //   152: invokestatic 168	com/tencent/qqmusic/mediaplayer/MediaCodecFactory:getSupportAudioType	()Ljava/util/ArrayList;
    //   155: astore 9
    //   157: aload 8
    //   159: ifnull +58 -> 217
    //   162: aload 9
    //   164: aload 8
    //   166: invokevirtual 283	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   169: ifeq +48 -> 217
    //   172: aload 9
    //   174: aload 8
    //   176: invokevirtual 285	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   179: pop
    //   180: aload 9
    //   182: iconst_0
    //   183: aload 8
    //   185: invokevirtual 289	java/util/ArrayList:add	(ILjava/lang/Object;)V
    //   188: getstatic 292	com/tencent/qqmusic/mediaplayer/AudioFormat$AudioType:MP3	Lcom/tencent/qqmusic/mediaplayer/AudioFormat$AudioType;
    //   191: aload 8
    //   193: invokevirtual 295	com/tencent/qqmusic/mediaplayer/AudioFormat$AudioType:equals	(Ljava/lang/Object;)Z
    //   196: ifeq +21 -> 217
    //   199: aload 9
    //   201: getstatic 104	com/tencent/qqmusic/mediaplayer/AudioFormat$AudioType:FLAC	Lcom/tencent/qqmusic/mediaplayer/AudioFormat$AudioType;
    //   204: invokevirtual 285	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   207: pop
    //   208: aload 9
    //   210: iconst_0
    //   211: getstatic 104	com/tencent/qqmusic/mediaplayer/AudioFormat$AudioType:FLAC	Lcom/tencent/qqmusic/mediaplayer/AudioFormat$AudioType;
    //   214: invokevirtual 289	java/util/ArrayList:add	(ILjava/lang/Object;)V
    //   217: new 297	java/io/FileInputStream
    //   220: dup
    //   221: aload_0
    //   222: invokespecial 298	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   225: astore 7
    //   227: aload 7
    //   229: astore 5
    //   231: sipush 1024
    //   234: invokestatic 304	com/tencent/qqmusic/mediaplayer/CacheBytesManager:getStatic	(I)[B
    //   237: astore 10
    //   239: aload 7
    //   241: astore 5
    //   243: aload 7
    //   245: aload 10
    //   247: invokevirtual 310	java/io/InputStream:read	([B)I
    //   250: istore_1
    //   251: iload_1
    //   252: bipush 64
    //   254: if_icmplt +485 -> 739
    //   257: aload 7
    //   259: astore 5
    //   261: bipush 64
    //   263: newarray byte
    //   265: astore 4
    //   267: aload 7
    //   269: astore 5
    //   271: aload 4
    //   273: astore 6
    //   275: aload 10
    //   277: iconst_0
    //   278: aload 4
    //   280: iconst_0
    //   281: bipush 64
    //   283: invokestatic 314	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   286: aload 7
    //   288: astore 5
    //   290: aload 4
    //   292: astore 6
    //   294: aload 10
    //   296: invokestatic 318	com/tencent/qqmusic/mediaplayer/CacheBytesManager:recycle	([B)[B
    //   299: pop
    //   300: aload 7
    //   302: astore 5
    //   304: aload 4
    //   306: astore 6
    //   308: getstatic 26	com/tencent/qqmusic/mediaplayer/AudioRecognition:TAG	Ljava/lang/String;
    //   311: new 52	java/lang/StringBuilder
    //   314: dup
    //   315: ldc_w 320
    //   318: invokespecial 57	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   321: new 228	java/lang/String
    //   324: dup
    //   325: aload 10
    //   327: iconst_0
    //   328: iload_1
    //   329: invokespecial 323	java/lang/String:<init>	([BII)V
    //   332: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: ldc_w 325
    //   338: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: aload_0
    //   342: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   348: invokestatic 87	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   351: aload 7
    //   353: invokevirtual 328	java/io/InputStream:close	()V
    //   356: aload 9
    //   358: invokevirtual 174	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   361: astore 6
    //   363: aload 6
    //   365: invokeinterface 180 1 0
    //   370: ifeq +360 -> 730
    //   373: aload 6
    //   375: invokeinterface 184 1 0
    //   380: checkcast 100	com/tencent/qqmusic/mediaplayer/AudioFormat$AudioType
    //   383: invokestatic 188	com/tencent/qqmusic/mediaplayer/MediaCodecFactory:createDecoderByType	(Lcom/tencent/qqmusic/mediaplayer/AudioFormat$AudioType;)Lcom/tencent/qqmusic/mediaplayer/codec/IAudioRecognition;
    //   386: astore 5
    //   388: aload 5
    //   390: ifnull -27 -> 363
    //   393: aload 5
    //   395: aload_0
    //   396: aload 4
    //   398: invokeinterface 331 3 0
    //   403: astore 5
    //   405: aload 5
    //   407: invokestatic 199	com/tencent/qqmusic/mediaplayer/AudioFormat:isAudioType	(Lcom/tencent/qqmusic/mediaplayer/AudioFormat$AudioType;)Z
    //   410: ifeq -47 -> 363
    //   413: getstatic 26	com/tencent/qqmusic/mediaplayer/AudioRecognition:TAG	Ljava/lang/String;
    //   416: new 52	java/lang/StringBuilder
    //   419: dup
    //   420: ldc_w 333
    //   423: invokespecial 57	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   426: aload 5
    //   428: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   431: ldc_w 335
    //   434: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   437: aload_0
    //   438: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   441: ldc_w 337
    //   444: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   447: invokestatic 280	java/lang/System:currentTimeMillis	()J
    //   450: lload_2
    //   451: lsub
    //   452: invokevirtual 61	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   455: ldc_w 339
    //   458: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   461: aload 5
    //   463: aload 8
    //   465: invokevirtual 295	com/tencent/qqmusic/mediaplayer/AudioFormat$AudioType:equals	(Ljava/lang/Object;)Z
    //   468: invokevirtual 342	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   471: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   474: invokestatic 222	com/tencent/qqmusic/mediaplayer/util/Logger:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   477: aload 5
    //   479: ifnonnull +163 -> 642
    //   482: getstatic 206	com/tencent/qqmusic/mediaplayer/AudioFormat$AudioType:UNSUPPORT	Lcom/tencent/qqmusic/mediaplayer/AudioFormat$AudioType;
    //   485: astore 5
    //   487: getstatic 26	com/tencent/qqmusic/mediaplayer/AudioRecognition:TAG	Ljava/lang/String;
    //   490: new 52	java/lang/StringBuilder
    //   493: dup
    //   494: ldc_w 344
    //   497: invokespecial 57	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   500: aload_0
    //   501: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   504: ldc 219
    //   506: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   509: aload 5
    //   511: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   514: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   517: invokestatic 87	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   520: ldc 248
    //   522: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   525: aload 5
    //   527: areturn
    //   528: astore 5
    //   530: getstatic 26	com/tencent/qqmusic/mediaplayer/AudioRecognition:TAG	Ljava/lang/String;
    //   533: aload 5
    //   535: invokestatic 135	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   538: goto -182 -> 356
    //   541: astore 6
    //   543: aconst_null
    //   544: astore 4
    //   546: aconst_null
    //   547: astore 7
    //   549: aload 7
    //   551: astore 5
    //   553: getstatic 26	com/tencent/qqmusic/mediaplayer/AudioRecognition:TAG	Ljava/lang/String;
    //   556: aload 6
    //   558: invokestatic 135	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   561: aload 7
    //   563: ifnull +173 -> 736
    //   566: aload 7
    //   568: invokevirtual 328	java/io/InputStream:close	()V
    //   571: goto -215 -> 356
    //   574: astore 5
    //   576: getstatic 26	com/tencent/qqmusic/mediaplayer/AudioRecognition:TAG	Ljava/lang/String;
    //   579: aload 5
    //   581: invokestatic 135	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   584: goto -228 -> 356
    //   587: astore_0
    //   588: aconst_null
    //   589: astore 5
    //   591: aload 5
    //   593: ifnull +8 -> 601
    //   596: aload 5
    //   598: invokevirtual 328	java/io/InputStream:close	()V
    //   601: ldc 248
    //   603: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   606: aload_0
    //   607: athrow
    //   608: astore 4
    //   610: getstatic 26	com/tencent/qqmusic/mediaplayer/AudioRecognition:TAG	Ljava/lang/String;
    //   613: aload 4
    //   615: invokestatic 135	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   618: goto -17 -> 601
    //   621: astore 5
    //   623: getstatic 26	com/tencent/qqmusic/mediaplayer/AudioRecognition:TAG	Ljava/lang/String;
    //   626: ldc_w 346
    //   629: aload 5
    //   631: invokestatic 349	com/tencent/qqmusic/mediaplayer/util/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   634: getstatic 206	com/tencent/qqmusic/mediaplayer/AudioFormat$AudioType:UNSUPPORT	Lcom/tencent/qqmusic/mediaplayer/AudioFormat$AudioType;
    //   637: astore 5
    //   639: goto -234 -> 405
    //   642: getstatic 26	com/tencent/qqmusic/mediaplayer/AudioRecognition:TAG	Ljava/lang/String;
    //   645: new 52	java/lang/StringBuilder
    //   648: dup
    //   649: ldc_w 351
    //   652: invokespecial 57	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   655: aload_0
    //   656: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   659: ldc_w 353
    //   662: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   665: aload 5
    //   667: invokevirtual 215	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   670: ldc_w 355
    //   673: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   676: invokevirtual 82	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   679: invokestatic 87	com/tencent/qqmusic/mediaplayer/util/Logger:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   682: getstatic 33	com/tencent/qqmusic/mediaplayer/AudioRecognition:mRecognitionResultCache	Ljava/util/HashMap;
    //   685: aload_0
    //   686: aload 5
    //   688: invokevirtual 203	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   691: pop
    //   692: getstatic 35	com/tencent/qqmusic/mediaplayer/AudioRecognition:mGuessFormatResultCache	Ljava/util/HashMap;
    //   695: aload_0
    //   696: aload 5
    //   698: invokevirtual 203	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   701: pop
    //   702: goto -215 -> 487
    //   705: astore_0
    //   706: goto -115 -> 591
    //   709: astore 6
    //   711: aconst_null
    //   712: astore 4
    //   714: goto -165 -> 549
    //   717: astore 5
    //   719: aload 6
    //   721: astore 4
    //   723: aload 5
    //   725: astore 6
    //   727: goto -178 -> 549
    //   730: aconst_null
    //   731: astore 5
    //   733: goto -256 -> 477
    //   736: goto -380 -> 356
    //   739: aconst_null
    //   740: astore 4
    //   742: goto -456 -> 286
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	745	0	paramString	String
    //   250	79	1	i	int
    //   145	306	2	l	long
    //   47	498	4	localObject1	Object
    //   608	6	4	localException1	java.lang.Exception
    //   712	29	4	localObject2	Object
    //   229	297	5	localObject3	Object
    //   528	6	5	localException2	java.lang.Exception
    //   551	1	5	localFileInputStream1	java.io.FileInputStream
    //   574	6	5	localException3	java.lang.Exception
    //   589	8	5	localObject4	Object
    //   621	9	5	localSoNotFindException	SoNotFindException
    //   637	60	5	localAudioType1	AudioFormat.AudioType
    //   717	7	5	localException4	java.lang.Exception
    //   731	1	5	localObject5	Object
    //   273	101	6	localObject6	Object
    //   541	16	6	localException5	java.lang.Exception
    //   709	11	6	localException6	java.lang.Exception
    //   725	1	6	localException7	java.lang.Exception
    //   225	342	7	localFileInputStream2	java.io.FileInputStream
    //   150	314	8	localAudioType2	AudioFormat.AudioType
    //   155	202	9	localArrayList	ArrayList
    //   237	89	10	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   351	356	528	java/lang/Exception
    //   217	227	541	java/lang/Exception
    //   566	571	574	java/lang/Exception
    //   217	227	587	finally
    //   596	601	608	java/lang/Exception
    //   393	405	621	com/tencent/qqmusic/mediaplayer/SoNotFindException
    //   231	239	705	finally
    //   243	251	705	finally
    //   261	267	705	finally
    //   275	286	705	finally
    //   294	300	705	finally
    //   308	351	705	finally
    //   553	561	705	finally
    //   231	239	709	java/lang/Exception
    //   243	251	709	java/lang/Exception
    //   261	267	709	java/lang/Exception
    //   275	286	717	java/lang/Exception
    //   294	300	717	java/lang/Exception
    //   308	351	717	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.AudioRecognition
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.tav.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.coremedia.CMSampleBuffer;
import com.tencent.tav.decoder.AudioInfo;
import com.tencent.tav.decoder.AudioMixer;
import com.tencent.tav.decoder.factory.AVResampleFactory;
import com.tencent.tav.decoder.logger.Logger;
import java.nio.ByteBuffer;
import java.nio.ShortBuffer;

public class AudioCompositor
{
  private final String TAG;
  private AudioMixer audioMixer;
  private final AudioResample audioResample;
  private ShortBuffer currentSamples;
  private ShortBuffer lastSamples;
  
  public AudioCompositor(AudioInfo paramAudioInfo)
  {
    AppMethodBeat.i(189043);
    this.TAG = ("AudioCompositor@" + Integer.toHexString(hashCode()));
    this.audioMixer = new AudioMixer(paramAudioInfo.sampleRate, paramAudioInfo.channelCount);
    this.audioResample = new AudioResample();
    AppMethodBeat.o(189043);
  }
  
  private AudioInfo resample(CMSampleBuffer paramCMSampleBuffer, AudioInfo paramAudioInfo)
  {
    AppMethodBeat.i(189048);
    ByteBuffer localByteBuffer2 = paramCMSampleBuffer.getSampleByteBuffer();
    if ((localByteBuffer2 == null) || (localByteBuffer2.limit() <= 0))
    {
      Logger.d(this.audioResample.TAG, "resample: 不进行重采样 byteBuffer = ".concat(String.valueOf(localByteBuffer2)));
      AppMethodBeat.o(189048);
      return paramAudioInfo;
    }
    ByteBuffer localByteBuffer1;
    if (AVResampleFactory.getInstance().isResampleEnable())
    {
      localByteBuffer1 = this.audioResample.resample(localByteBuffer2, paramAudioInfo);
      if (localByteBuffer1 != null) {
        paramAudioInfo = this.audioResample.getDestAudioInfo();
      }
    }
    for (;;)
    {
      paramCMSampleBuffer.setSampleByteBuffer(localByteBuffer1);
      AppMethodBeat.o(189048);
      return paramAudioInfo;
      localByteBuffer1 = localByteBuffer2;
    }
  }
  
  public void clear()
  {
    try
    {
      this.currentSamples = null;
      this.lastSamples = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public ByteBuffer processFrame(ByteBuffer paramByteBuffer, float paramFloat1, float paramFloat2, AudioInfo paramAudioInfo)
  {
    AppMethodBeat.i(189047);
    this.audioMixer.setAudioInfo(paramAudioInfo.sampleRate, paramAudioInfo.channelCount, paramAudioInfo.pcmEncoding);
    paramByteBuffer = this.audioMixer.processBytes(paramByteBuffer, paramFloat2, paramFloat1, 1.0F);
    AppMethodBeat.o(189047);
    return paramByteBuffer;
  }
  
  /* Error */
  public CMSampleBuffer readMergeSample(com.tencent.tav.decoder.AudioDecoderTrack paramAudioDecoderTrack, AudioMixInputParameters paramAudioMixInputParameters, CMSampleBuffer paramCMSampleBuffer)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: aload_0
    //   4: monitorenter
    //   5: ldc 155
    //   7: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: aload_3
    //   11: ifnull +14 -> 25
    //   14: aload_3
    //   15: invokevirtual 86	com/tencent/tav/coremedia/CMSampleBuffer:getSampleByteBuffer	()Ljava/nio/ByteBuffer;
    //   18: ifnull +7 -> 25
    //   21: aload_1
    //   22: ifnonnull +22 -> 44
    //   25: aload_0
    //   26: aconst_null
    //   27: putfield 134	com/tencent/tav/core/AudioCompositor:currentSamples	Ljava/nio/ShortBuffer;
    //   30: aload_0
    //   31: aconst_null
    //   32: putfield 136	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   35: ldc 155
    //   37: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   40: aload_0
    //   41: monitorexit
    //   42: aload_3
    //   43: areturn
    //   44: aload_3
    //   45: invokevirtual 86	com/tencent/tav/coremedia/CMSampleBuffer:getSampleByteBuffer	()Ljava/nio/ByteBuffer;
    //   48: invokevirtual 159	java/nio/ByteBuffer:asShortBuffer	()Ljava/nio/ShortBuffer;
    //   51: invokevirtual 162	java/nio/ShortBuffer:limit	()I
    //   54: istore 8
    //   56: aload_0
    //   57: getfield 134	com/tencent/tav/core/AudioCompositor:currentSamples	Ljava/nio/ShortBuffer;
    //   60: ifnull +15 -> 75
    //   63: aload_0
    //   64: getfield 134	com/tencent/tav/core/AudioCompositor:currentSamples	Ljava/nio/ShortBuffer;
    //   67: invokevirtual 165	java/nio/ShortBuffer:capacity	()I
    //   70: iload 8
    //   72: if_icmpge +235 -> 307
    //   75: iload 8
    //   77: iconst_2
    //   78: imul
    //   79: invokestatic 169	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   82: astore 12
    //   84: aload 12
    //   86: aload_3
    //   87: invokevirtual 86	com/tencent/tav/coremedia/CMSampleBuffer:getSampleByteBuffer	()Ljava/nio/ByteBuffer;
    //   90: invokevirtual 173	java/nio/ByteBuffer:order	()Ljava/nio/ByteOrder;
    //   93: invokevirtual 176	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   96: pop
    //   97: aload_0
    //   98: aload 12
    //   100: invokevirtual 159	java/nio/ByteBuffer:asShortBuffer	()Ljava/nio/ShortBuffer;
    //   103: putfield 134	com/tencent/tav/core/AudioCompositor:currentSamples	Ljava/nio/ShortBuffer;
    //   106: aload_0
    //   107: getfield 136	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   110: ifnull +91 -> 201
    //   113: aload_0
    //   114: getfield 136	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   117: invokevirtual 179	java/nio/ShortBuffer:remaining	()I
    //   120: ifle +81 -> 201
    //   123: iload 8
    //   125: aload_0
    //   126: getfield 136	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   129: invokevirtual 179	java/nio/ShortBuffer:remaining	()I
    //   132: if_icmpge +186 -> 318
    //   135: aload_0
    //   136: getfield 136	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   139: invokevirtual 182	java/nio/ShortBuffer:position	()I
    //   142: istore 6
    //   144: aload_0
    //   145: getfield 136	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   148: invokevirtual 162	java/nio/ShortBuffer:limit	()I
    //   151: istore 7
    //   153: aload_0
    //   154: getfield 136	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   157: iload 6
    //   159: iload 8
    //   161: iadd
    //   162: invokevirtual 185	java/nio/ShortBuffer:limit	(I)Ljava/nio/Buffer;
    //   165: pop
    //   166: aload_0
    //   167: getfield 134	com/tencent/tav/core/AudioCompositor:currentSamples	Ljava/nio/ShortBuffer;
    //   170: aload_0
    //   171: getfield 136	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   174: invokevirtual 189	java/nio/ShortBuffer:put	(Ljava/nio/ShortBuffer;)Ljava/nio/ShortBuffer;
    //   177: pop
    //   178: aload_0
    //   179: getfield 136	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   182: iload 7
    //   184: invokevirtual 185	java/nio/ShortBuffer:limit	(I)Ljava/nio/Buffer;
    //   187: pop
    //   188: aload_0
    //   189: getfield 136	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   192: iload 6
    //   194: iload 8
    //   196: iadd
    //   197: invokevirtual 191	java/nio/ShortBuffer:position	(I)Ljava/nio/Buffer;
    //   200: pop
    //   201: aload_0
    //   202: getfield 134	com/tencent/tav/core/AudioCompositor:currentSamples	Ljava/nio/ShortBuffer;
    //   205: invokevirtual 182	java/nio/ShortBuffer:position	()I
    //   208: istore 6
    //   210: iload 6
    //   212: iload 8
    //   214: if_icmpge +396 -> 610
    //   217: aload_1
    //   218: aload_3
    //   219: invokevirtual 195	com/tencent/tav/coremedia/CMSampleBuffer:getTime	()Lcom/tencent/tav/coremedia/CMTime;
    //   222: invokevirtual 201	com/tencent/tav/decoder/AudioDecoderTrack:readSample	(Lcom/tencent/tav/coremedia/CMTime;)Lcom/tencent/tav/coremedia/CMSampleBuffer;
    //   225: astore 14
    //   227: aload_0
    //   228: getfield 52	com/tencent/tav/core/AudioCompositor:TAG	Ljava/lang/String;
    //   231: astore 12
    //   233: new 27	java/lang/StringBuilder
    //   236: dup
    //   237: ldc 203
    //   239: invokespecial 32	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   242: astore 13
    //   244: iload 5
    //   246: iconst_1
    //   247: iadd
    //   248: istore 7
    //   250: aload 12
    //   252: aload 13
    //   254: iload 5
    //   256: invokevirtual 206	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   259: ldc 208
    //   261: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: aload 14
    //   266: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   269: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   272: invokestatic 214	com/tencent/tav/decoder/logger/Logger:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   275: aload 14
    //   277: invokevirtual 218	com/tencent/tav/coremedia/CMSampleBuffer:getState	()Lcom/tencent/tav/coremedia/CMSampleState;
    //   280: invokevirtual 224	com/tencent/tav/coremedia/CMSampleState:getStateCode	()J
    //   283: lstore 10
    //   285: lload 10
    //   287: ldc2_w 225
    //   290: lcmp
    //   291: ifgt +57 -> 348
    //   294: ldc 155
    //   296: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   299: goto -259 -> 40
    //   302: astore_1
    //   303: aload_0
    //   304: monitorexit
    //   305: aload_1
    //   306: athrow
    //   307: aload_0
    //   308: getfield 134	com/tencent/tav/core/AudioCompositor:currentSamples	Ljava/nio/ShortBuffer;
    //   311: invokevirtual 229	java/nio/ShortBuffer:clear	()Ljava/nio/Buffer;
    //   314: pop
    //   315: goto -209 -> 106
    //   318: aload_0
    //   319: getfield 134	com/tencent/tav/core/AudioCompositor:currentSamples	Ljava/nio/ShortBuffer;
    //   322: aload_0
    //   323: getfield 136	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   326: invokevirtual 189	java/nio/ShortBuffer:put	(Ljava/nio/ShortBuffer;)Ljava/nio/ShortBuffer;
    //   329: pop
    //   330: aload_0
    //   331: getfield 136	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   334: aload_0
    //   335: getfield 136	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   338: invokevirtual 162	java/nio/ShortBuffer:limit	()I
    //   341: invokevirtual 191	java/nio/ShortBuffer:position	(I)Ljava/nio/Buffer;
    //   344: pop
    //   345: goto -144 -> 201
    //   348: aload_1
    //   349: aload 14
    //   351: invokevirtual 195	com/tencent/tav/coremedia/CMSampleBuffer:getTime	()Lcom/tencent/tav/coremedia/CMTime;
    //   354: invokevirtual 233	com/tencent/tav/decoder/AudioDecoderTrack:asyncReadNextSample	(Lcom/tencent/tav/coremedia/CMTime;)V
    //   357: aload_2
    //   358: ifnull +300 -> 658
    //   361: aload_2
    //   362: aload 14
    //   364: invokevirtual 195	com/tencent/tav/coremedia/CMSampleBuffer:getTime	()Lcom/tencent/tav/coremedia/CMTime;
    //   367: invokevirtual 239	com/tencent/tav/core/AudioMixInputParameters:getVolumeAtTime	(Lcom/tencent/tav/coremedia/CMTime;)F
    //   370: fstore 4
    //   372: aload 14
    //   374: invokevirtual 86	com/tencent/tav/coremedia/CMSampleBuffer:getSampleByteBuffer	()Ljava/nio/ByteBuffer;
    //   377: ifnull +367 -> 744
    //   380: aload 14
    //   382: invokevirtual 86	com/tencent/tav/coremedia/CMSampleBuffer:getSampleByteBuffer	()Ljava/nio/ByteBuffer;
    //   385: invokevirtual 91	java/nio/ByteBuffer:limit	()I
    //   388: ifle +356 -> 744
    //   391: aload_0
    //   392: aload 14
    //   394: aload_1
    //   395: invokevirtual 242	com/tencent/tav/decoder/AudioDecoderTrack:getAudioInfo	()Lcom/tencent/tav/decoder/AudioInfo;
    //   398: invokespecial 244	com/tencent/tav/core/AudioCompositor:resample	(Lcom/tencent/tav/coremedia/CMSampleBuffer;Lcom/tencent/tav/decoder/AudioInfo;)Lcom/tencent/tav/decoder/AudioInfo;
    //   401: astore 13
    //   403: aload 13
    //   405: astore 12
    //   407: aload_2
    //   408: ifnull +53 -> 461
    //   411: aload 13
    //   413: astore 12
    //   415: aload_2
    //   416: invokevirtual 248	com/tencent/tav/core/AudioMixInputParameters:getAudioTapProcessor	()Lcom/tencent/tav/core/AudioTapProcessor;
    //   419: ifnull +42 -> 461
    //   422: aload_2
    //   423: invokevirtual 248	com/tencent/tav/core/AudioMixInputParameters:getAudioTapProcessor	()Lcom/tencent/tav/core/AudioTapProcessor;
    //   426: astore 12
    //   428: aload 14
    //   430: aload 12
    //   432: aload 14
    //   434: invokevirtual 195	com/tencent/tav/coremedia/CMSampleBuffer:getTime	()Lcom/tencent/tav/coremedia/CMTime;
    //   437: aload 14
    //   439: invokevirtual 86	com/tencent/tav/coremedia/CMSampleBuffer:getSampleByteBuffer	()Ljava/nio/ByteBuffer;
    //   442: aload 13
    //   444: invokeinterface 254 4 0
    //   449: invokevirtual 131	com/tencent/tav/coremedia/CMSampleBuffer:setSampleByteBuffer	(Ljava/nio/ByteBuffer;)V
    //   452: aload 12
    //   454: invokeinterface 255 1 0
    //   459: astore 12
    //   461: aload_0
    //   462: aload 14
    //   464: invokevirtual 86	com/tencent/tav/coremedia/CMSampleBuffer:getSampleByteBuffer	()Ljava/nio/ByteBuffer;
    //   467: fload 4
    //   469: fconst_1
    //   470: aload 12
    //   472: invokevirtual 257	com/tencent/tav/core/AudioCompositor:processFrame	(Ljava/nio/ByteBuffer;FFLcom/tencent/tav/decoder/AudioInfo;)Ljava/nio/ByteBuffer;
    //   475: invokevirtual 159	java/nio/ByteBuffer:asShortBuffer	()Ljava/nio/ShortBuffer;
    //   478: astore 12
    //   480: aload 12
    //   482: invokevirtual 162	java/nio/ShortBuffer:limit	()I
    //   485: iload 8
    //   487: iload 6
    //   489: isub
    //   490: if_icmple +223 -> 713
    //   493: aload 12
    //   495: invokevirtual 162	java/nio/ShortBuffer:limit	()I
    //   498: iload 8
    //   500: iload 6
    //   502: isub
    //   503: isub
    //   504: istore 5
    //   506: aload_0
    //   507: getfield 136	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   510: ifnull +15 -> 525
    //   513: aload_0
    //   514: getfield 136	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   517: invokevirtual 165	java/nio/ShortBuffer:capacity	()I
    //   520: iload 5
    //   522: if_icmpge +142 -> 664
    //   525: iload 5
    //   527: iconst_2
    //   528: imul
    //   529: invokestatic 169	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   532: astore_1
    //   533: aload_1
    //   534: aload_3
    //   535: invokevirtual 86	com/tencent/tav/coremedia/CMSampleBuffer:getSampleByteBuffer	()Ljava/nio/ByteBuffer;
    //   538: invokevirtual 173	java/nio/ByteBuffer:order	()Ljava/nio/ByteOrder;
    //   541: invokevirtual 176	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   544: pop
    //   545: aload_0
    //   546: aload_1
    //   547: invokevirtual 159	java/nio/ByteBuffer:asShortBuffer	()Ljava/nio/ShortBuffer;
    //   550: putfield 136	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   553: aload 12
    //   555: iload 8
    //   557: iload 6
    //   559: isub
    //   560: invokevirtual 191	java/nio/ShortBuffer:position	(I)Ljava/nio/Buffer;
    //   563: pop
    //   564: aload_0
    //   565: getfield 136	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   568: aload 12
    //   570: invokevirtual 189	java/nio/ShortBuffer:put	(Ljava/nio/ShortBuffer;)Ljava/nio/ShortBuffer;
    //   573: pop
    //   574: aload_0
    //   575: getfield 136	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   578: invokevirtual 260	java/nio/ShortBuffer:flip	()Ljava/nio/Buffer;
    //   581: pop
    //   582: aload 12
    //   584: iconst_0
    //   585: invokevirtual 191	java/nio/ShortBuffer:position	(I)Ljava/nio/Buffer;
    //   588: pop
    //   589: aload 12
    //   591: iload 8
    //   593: iload 6
    //   595: isub
    //   596: invokevirtual 185	java/nio/ShortBuffer:limit	(I)Ljava/nio/Buffer;
    //   599: pop
    //   600: aload_0
    //   601: getfield 134	com/tencent/tav/core/AudioCompositor:currentSamples	Ljava/nio/ShortBuffer;
    //   604: aload 12
    //   606: invokevirtual 189	java/nio/ShortBuffer:put	(Ljava/nio/ShortBuffer;)Ljava/nio/ShortBuffer;
    //   609: pop
    //   610: aload_0
    //   611: getfield 134	com/tencent/tav/core/AudioCompositor:currentSamples	Ljava/nio/ShortBuffer;
    //   614: invokevirtual 260	java/nio/ShortBuffer:flip	()Ljava/nio/Buffer;
    //   617: pop
    //   618: aload_0
    //   619: getfield 68	com/tencent/tav/core/AudioCompositor:audioMixer	Lcom/tencent/tav/decoder/AudioMixer;
    //   622: aload_3
    //   623: invokevirtual 86	com/tencent/tav/coremedia/CMSampleBuffer:getSampleByteBuffer	()Ljava/nio/ByteBuffer;
    //   626: invokevirtual 159	java/nio/ByteBuffer:asShortBuffer	()Ljava/nio/ShortBuffer;
    //   629: aload_0
    //   630: getfield 134	com/tencent/tav/core/AudioCompositor:currentSamples	Ljava/nio/ShortBuffer;
    //   633: invokevirtual 264	com/tencent/tav/decoder/AudioMixer:mergeSamples	(Ljava/nio/ShortBuffer;Ljava/nio/ShortBuffer;)Ljava/nio/ByteBuffer;
    //   636: astore_1
    //   637: new 82	com/tencent/tav/coremedia/CMSampleBuffer
    //   640: dup
    //   641: aload_3
    //   642: invokevirtual 195	com/tencent/tav/coremedia/CMSampleBuffer:getTime	()Lcom/tencent/tav/coremedia/CMTime;
    //   645: aload_1
    //   646: invokespecial 267	com/tencent/tav/coremedia/CMSampleBuffer:<init>	(Lcom/tencent/tav/coremedia/CMTime;Ljava/nio/ByteBuffer;)V
    //   649: astore_3
    //   650: ldc 155
    //   652: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   655: goto -615 -> 40
    //   658: fconst_1
    //   659: fstore 4
    //   661: goto -289 -> 372
    //   664: aload_0
    //   665: getfield 136	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   668: invokevirtual 229	java/nio/ShortBuffer:clear	()Ljava/nio/Buffer;
    //   671: pop
    //   672: goto -119 -> 553
    //   675: astore_1
    //   676: aload_0
    //   677: getfield 52	com/tencent/tav/core/AudioCompositor:TAG	Ljava/lang/String;
    //   680: ldc_w 269
    //   683: aload_1
    //   684: invokestatic 273	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   687: new 82	com/tencent/tav/coremedia/CMSampleBuffer
    //   690: dup
    //   691: ldc2_w 225
    //   694: ldc_w 275
    //   697: aload_1
    //   698: invokestatic 279	com/tencent/tav/coremedia/CMSampleState:fromError	(JLjava/lang/String;Ljava/lang/Throwable;)Lcom/tencent/tav/coremedia/CMSampleState;
    //   701: invokespecial 282	com/tencent/tav/coremedia/CMSampleBuffer:<init>	(Lcom/tencent/tav/coremedia/CMSampleState;)V
    //   704: astore_3
    //   705: ldc 155
    //   707: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   710: goto -670 -> 40
    //   713: aload_0
    //   714: getfield 134	com/tencent/tav/core/AudioCompositor:currentSamples	Ljava/nio/ShortBuffer;
    //   717: aload 12
    //   719: invokevirtual 189	java/nio/ShortBuffer:put	(Ljava/nio/ShortBuffer;)Ljava/nio/ShortBuffer;
    //   722: pop
    //   723: aload 12
    //   725: invokevirtual 162	java/nio/ShortBuffer:limit	()I
    //   728: istore 9
    //   730: iload 7
    //   732: istore 5
    //   734: iload 6
    //   736: iload 9
    //   738: iadd
    //   739: istore 6
    //   741: goto -531 -> 210
    //   744: iload 7
    //   746: istore 5
    //   748: goto -538 -> 210
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	751	0	this	AudioCompositor
    //   0	751	1	paramAudioDecoderTrack	com.tencent.tav.decoder.AudioDecoderTrack
    //   0	751	2	paramAudioMixInputParameters	AudioMixInputParameters
    //   0	751	3	paramCMSampleBuffer	CMSampleBuffer
    //   370	290	4	f	float
    //   1	746	5	i	int
    //   142	598	6	j	int
    //   151	594	7	k	int
    //   54	542	8	m	int
    //   728	11	9	n	int
    //   283	3	10	l	long
    //   82	642	12	localObject1	Object
    //   242	201	13	localObject2	Object
    //   225	238	14	localCMSampleBuffer	CMSampleBuffer
    // Exception table:
    //   from	to	target	type
    //   5	10	302	finally
    //   14	21	302	finally
    //   25	40	302	finally
    //   44	75	302	finally
    //   75	106	302	finally
    //   106	201	302	finally
    //   201	210	302	finally
    //   217	244	302	finally
    //   250	285	302	finally
    //   294	299	302	finally
    //   307	315	302	finally
    //   318	345	302	finally
    //   348	357	302	finally
    //   361	372	302	finally
    //   372	403	302	finally
    //   415	461	302	finally
    //   461	525	302	finally
    //   525	553	302	finally
    //   553	610	302	finally
    //   610	650	302	finally
    //   650	655	302	finally
    //   664	672	302	finally
    //   676	710	302	finally
    //   713	730	302	finally
    //   217	244	675	java/lang/Throwable
    //   250	285	675	java/lang/Throwable
    //   348	357	675	java/lang/Throwable
    //   361	372	675	java/lang/Throwable
    //   372	403	675	java/lang/Throwable
    //   415	461	675	java/lang/Throwable
    //   461	525	675	java/lang/Throwable
    //   525	553	675	java/lang/Throwable
    //   553	610	675	java/lang/Throwable
    //   610	650	675	java/lang/Throwable
    //   664	672	675	java/lang/Throwable
    //   713	730	675	java/lang/Throwable
  }
  
  public void setAudioInfo(AudioInfo paramAudioInfo)
  {
    AppMethodBeat.i(189044);
    this.audioMixer = new AudioMixer(paramAudioInfo.sampleRate, paramAudioInfo.channelCount);
    AppMethodBeat.o(189044);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.core.AudioCompositor
 * JD-Core Version:    0.7.0.1
 */
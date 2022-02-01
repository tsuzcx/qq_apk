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
    AppMethodBeat.i(215381);
    this.TAG = ("AudioCompositor@" + Integer.toHexString(hashCode()));
    this.audioMixer = new AudioMixer(paramAudioInfo.sampleRate, paramAudioInfo.channelCount);
    this.audioResample = new AudioResample();
    AppMethodBeat.o(215381);
  }
  
  private AudioInfo resample(CMSampleBuffer paramCMSampleBuffer, AudioInfo paramAudioInfo)
  {
    AppMethodBeat.i(215395);
    ByteBuffer localByteBuffer2 = paramCMSampleBuffer.getSampleByteBuffer();
    if ((localByteBuffer2 == null) || (localByteBuffer2.limit() <= 0))
    {
      Logger.d(this.audioResample.TAG, "resample: 不进行重采样 byteBuffer = ".concat(String.valueOf(localByteBuffer2)));
      AppMethodBeat.o(215395);
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
      AppMethodBeat.o(215395);
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
    AppMethodBeat.i(215437);
    this.audioMixer.setAudioInfo(paramAudioInfo.sampleRate, paramAudioInfo.channelCount, paramAudioInfo.pcmEncoding);
    paramByteBuffer = this.audioMixer.processBytes(paramByteBuffer, paramFloat2, paramFloat1, 1.0F);
    AppMethodBeat.o(215437);
    return paramByteBuffer;
  }
  
  /* Error */
  public CMSampleBuffer readMergeSample(com.tencent.tav.decoder.AudioDecoderTrack paramAudioDecoderTrack, AudioMixInputParameters paramAudioMixInputParameters, CMSampleBuffer paramCMSampleBuffer)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 153
    //   4: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_3
    //   8: ifnull +14 -> 22
    //   11: aload_3
    //   12: invokevirtual 86	com/tencent/tav/coremedia/CMSampleBuffer:getSampleByteBuffer	()Ljava/nio/ByteBuffer;
    //   15: ifnull +7 -> 22
    //   18: aload_1
    //   19: ifnonnull +22 -> 41
    //   22: aload_0
    //   23: aconst_null
    //   24: putfield 134	com/tencent/tav/core/AudioCompositor:currentSamples	Ljava/nio/ShortBuffer;
    //   27: aload_0
    //   28: aconst_null
    //   29: putfield 136	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   32: ldc 153
    //   34: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_3
    //   40: areturn
    //   41: aload_3
    //   42: invokevirtual 86	com/tencent/tav/coremedia/CMSampleBuffer:getSampleByteBuffer	()Ljava/nio/ByteBuffer;
    //   45: invokevirtual 157	java/nio/ByteBuffer:asShortBuffer	()Ljava/nio/ShortBuffer;
    //   48: invokevirtual 160	java/nio/ShortBuffer:limit	()I
    //   51: istore 8
    //   53: aload_0
    //   54: getfield 134	com/tencent/tav/core/AudioCompositor:currentSamples	Ljava/nio/ShortBuffer;
    //   57: ifnull +15 -> 72
    //   60: aload_0
    //   61: getfield 134	com/tencent/tav/core/AudioCompositor:currentSamples	Ljava/nio/ShortBuffer;
    //   64: invokevirtual 163	java/nio/ShortBuffer:capacity	()I
    //   67: iload 8
    //   69: if_icmpge +235 -> 304
    //   72: iload 8
    //   74: iconst_2
    //   75: imul
    //   76: invokestatic 167	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   79: astore 12
    //   81: aload 12
    //   83: aload_3
    //   84: invokevirtual 86	com/tencent/tav/coremedia/CMSampleBuffer:getSampleByteBuffer	()Ljava/nio/ByteBuffer;
    //   87: invokevirtual 171	java/nio/ByteBuffer:order	()Ljava/nio/ByteOrder;
    //   90: invokevirtual 174	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   93: pop
    //   94: aload_0
    //   95: aload 12
    //   97: invokevirtual 157	java/nio/ByteBuffer:asShortBuffer	()Ljava/nio/ShortBuffer;
    //   100: putfield 134	com/tencent/tav/core/AudioCompositor:currentSamples	Ljava/nio/ShortBuffer;
    //   103: aload_0
    //   104: getfield 136	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   107: ifnull +91 -> 198
    //   110: aload_0
    //   111: getfield 136	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   114: invokevirtual 177	java/nio/ShortBuffer:remaining	()I
    //   117: ifle +81 -> 198
    //   120: iload 8
    //   122: aload_0
    //   123: getfield 136	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   126: invokevirtual 177	java/nio/ShortBuffer:remaining	()I
    //   129: if_icmpge +191 -> 320
    //   132: aload_0
    //   133: getfield 136	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   136: invokevirtual 180	java/nio/ShortBuffer:position	()I
    //   139: istore 5
    //   141: aload_0
    //   142: getfield 136	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   145: invokevirtual 160	java/nio/ShortBuffer:limit	()I
    //   148: istore 6
    //   150: aload_0
    //   151: getfield 136	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   154: iload 5
    //   156: iload 8
    //   158: iadd
    //   159: invokevirtual 183	java/nio/ShortBuffer:limit	(I)Ljava/nio/Buffer;
    //   162: pop
    //   163: aload_0
    //   164: getfield 134	com/tencent/tav/core/AudioCompositor:currentSamples	Ljava/nio/ShortBuffer;
    //   167: aload_0
    //   168: getfield 136	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   171: invokevirtual 187	java/nio/ShortBuffer:put	(Ljava/nio/ShortBuffer;)Ljava/nio/ShortBuffer;
    //   174: pop
    //   175: aload_0
    //   176: getfield 136	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   179: iload 6
    //   181: invokevirtual 183	java/nio/ShortBuffer:limit	(I)Ljava/nio/Buffer;
    //   184: pop
    //   185: aload_0
    //   186: getfield 136	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   189: iload 5
    //   191: iload 8
    //   193: iadd
    //   194: invokevirtual 189	java/nio/ShortBuffer:position	(I)Ljava/nio/Buffer;
    //   197: pop
    //   198: aload_0
    //   199: getfield 134	com/tencent/tav/core/AudioCompositor:currentSamples	Ljava/nio/ShortBuffer;
    //   202: invokevirtual 180	java/nio/ShortBuffer:position	()I
    //   205: istore 6
    //   207: iconst_0
    //   208: istore 5
    //   210: iload 6
    //   212: iload 8
    //   214: if_icmpge +425 -> 639
    //   217: aload_1
    //   218: aload_3
    //   219: invokevirtual 193	com/tencent/tav/coremedia/CMSampleBuffer:getTime	()Lcom/tencent/tav/coremedia/CMTime;
    //   222: invokevirtual 199	com/tencent/tav/decoder/AudioDecoderTrack:readSample	(Lcom/tencent/tav/coremedia/CMTime;)Lcom/tencent/tav/coremedia/CMSampleBuffer;
    //   225: astore 13
    //   227: aload_0
    //   228: getfield 52	com/tencent/tav/core/AudioCompositor:TAG	Ljava/lang/String;
    //   231: astore 12
    //   233: new 27	java/lang/StringBuilder
    //   236: dup
    //   237: ldc 201
    //   239: invokespecial 32	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   242: astore 14
    //   244: iload 5
    //   246: iconst_1
    //   247: iadd
    //   248: istore 7
    //   250: aload 12
    //   252: aload 14
    //   254: iload 5
    //   256: invokevirtual 204	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   259: ldc 206
    //   261: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: aload 13
    //   266: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   269: invokevirtual 50	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   272: invokestatic 212	com/tencent/tav/decoder/logger/Logger:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   275: aload 13
    //   277: invokevirtual 216	com/tencent/tav/coremedia/CMSampleBuffer:getState	()Lcom/tencent/tav/coremedia/CMSampleState;
    //   280: invokevirtual 221	com/tencent/tav/coremedia/CMSampleState:getExportCode	()I
    //   283: istore 5
    //   285: iload 5
    //   287: sipush -202
    //   290: if_icmpne +60 -> 350
    //   293: ldc 153
    //   295: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   298: aload 13
    //   300: astore_3
    //   301: goto -264 -> 37
    //   304: aload_0
    //   305: getfield 134	com/tencent/tav/core/AudioCompositor:currentSamples	Ljava/nio/ShortBuffer;
    //   308: invokevirtual 224	java/nio/ShortBuffer:clear	()Ljava/nio/Buffer;
    //   311: pop
    //   312: goto -209 -> 103
    //   315: astore_1
    //   316: aload_0
    //   317: monitorexit
    //   318: aload_1
    //   319: athrow
    //   320: aload_0
    //   321: getfield 134	com/tencent/tav/core/AudioCompositor:currentSamples	Ljava/nio/ShortBuffer;
    //   324: aload_0
    //   325: getfield 136	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   328: invokevirtual 187	java/nio/ShortBuffer:put	(Ljava/nio/ShortBuffer;)Ljava/nio/ShortBuffer;
    //   331: pop
    //   332: aload_0
    //   333: getfield 136	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   336: aload_0
    //   337: getfield 136	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   340: invokevirtual 160	java/nio/ShortBuffer:limit	()I
    //   343: invokevirtual 189	java/nio/ShortBuffer:position	(I)Ljava/nio/Buffer;
    //   346: pop
    //   347: goto -149 -> 198
    //   350: aload 13
    //   352: invokevirtual 216	com/tencent/tav/coremedia/CMSampleBuffer:getState	()Lcom/tencent/tav/coremedia/CMSampleState;
    //   355: invokevirtual 228	com/tencent/tav/coremedia/CMSampleState:getStateCode	()J
    //   358: lstore 10
    //   360: lload 10
    //   362: ldc2_w 229
    //   365: lcmp
    //   366: ifgt +11 -> 377
    //   369: ldc 153
    //   371: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   374: goto -337 -> 37
    //   377: aload_1
    //   378: aload 13
    //   380: invokevirtual 193	com/tencent/tav/coremedia/CMSampleBuffer:getTime	()Lcom/tencent/tav/coremedia/CMTime;
    //   383: invokevirtual 234	com/tencent/tav/decoder/AudioDecoderTrack:asyncReadNextSample	(Lcom/tencent/tav/coremedia/CMTime;)V
    //   386: aload_2
    //   387: ifnull +300 -> 687
    //   390: aload_2
    //   391: aload 13
    //   393: invokevirtual 193	com/tencent/tav/coremedia/CMSampleBuffer:getTime	()Lcom/tencent/tav/coremedia/CMTime;
    //   396: invokevirtual 240	com/tencent/tav/core/AudioMixInputParameters:getVolumeAtTime	(Lcom/tencent/tav/coremedia/CMTime;)F
    //   399: fstore 4
    //   401: aload 13
    //   403: invokevirtual 86	com/tencent/tav/coremedia/CMSampleBuffer:getSampleByteBuffer	()Ljava/nio/ByteBuffer;
    //   406: ifnull +367 -> 773
    //   409: aload 13
    //   411: invokevirtual 86	com/tencent/tav/coremedia/CMSampleBuffer:getSampleByteBuffer	()Ljava/nio/ByteBuffer;
    //   414: invokevirtual 91	java/nio/ByteBuffer:limit	()I
    //   417: ifle +356 -> 773
    //   420: aload_0
    //   421: aload 13
    //   423: aload_1
    //   424: invokevirtual 243	com/tencent/tav/decoder/AudioDecoderTrack:getAudioInfo	()Lcom/tencent/tav/decoder/AudioInfo;
    //   427: invokespecial 245	com/tencent/tav/core/AudioCompositor:resample	(Lcom/tencent/tav/coremedia/CMSampleBuffer;Lcom/tencent/tav/decoder/AudioInfo;)Lcom/tencent/tav/decoder/AudioInfo;
    //   430: astore 14
    //   432: aload 14
    //   434: astore 12
    //   436: aload_2
    //   437: ifnull +53 -> 490
    //   440: aload 14
    //   442: astore 12
    //   444: aload_2
    //   445: invokevirtual 249	com/tencent/tav/core/AudioMixInputParameters:getAudioTapProcessor	()Lcom/tencent/tav/core/AudioTapProcessor;
    //   448: ifnull +42 -> 490
    //   451: aload_2
    //   452: invokevirtual 249	com/tencent/tav/core/AudioMixInputParameters:getAudioTapProcessor	()Lcom/tencent/tav/core/AudioTapProcessor;
    //   455: astore 12
    //   457: aload 13
    //   459: aload 12
    //   461: aload 13
    //   463: invokevirtual 193	com/tencent/tav/coremedia/CMSampleBuffer:getTime	()Lcom/tencent/tav/coremedia/CMTime;
    //   466: aload 13
    //   468: invokevirtual 86	com/tencent/tav/coremedia/CMSampleBuffer:getSampleByteBuffer	()Ljava/nio/ByteBuffer;
    //   471: aload 14
    //   473: invokeinterface 255 4 0
    //   478: invokevirtual 131	com/tencent/tav/coremedia/CMSampleBuffer:setSampleByteBuffer	(Ljava/nio/ByteBuffer;)V
    //   481: aload 12
    //   483: invokeinterface 256 1 0
    //   488: astore 12
    //   490: aload_0
    //   491: aload 13
    //   493: invokevirtual 86	com/tencent/tav/coremedia/CMSampleBuffer:getSampleByteBuffer	()Ljava/nio/ByteBuffer;
    //   496: fload 4
    //   498: fconst_1
    //   499: aload 12
    //   501: invokevirtual 258	com/tencent/tav/core/AudioCompositor:processFrame	(Ljava/nio/ByteBuffer;FFLcom/tencent/tav/decoder/AudioInfo;)Ljava/nio/ByteBuffer;
    //   504: invokevirtual 157	java/nio/ByteBuffer:asShortBuffer	()Ljava/nio/ShortBuffer;
    //   507: astore 12
    //   509: aload 12
    //   511: invokevirtual 160	java/nio/ShortBuffer:limit	()I
    //   514: iload 8
    //   516: iload 6
    //   518: isub
    //   519: if_icmple +223 -> 742
    //   522: aload 12
    //   524: invokevirtual 160	java/nio/ShortBuffer:limit	()I
    //   527: iload 8
    //   529: iload 6
    //   531: isub
    //   532: isub
    //   533: istore 5
    //   535: aload_0
    //   536: getfield 136	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   539: ifnull +15 -> 554
    //   542: aload_0
    //   543: getfield 136	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   546: invokevirtual 163	java/nio/ShortBuffer:capacity	()I
    //   549: iload 5
    //   551: if_icmpge +142 -> 693
    //   554: iload 5
    //   556: iconst_2
    //   557: imul
    //   558: invokestatic 167	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   561: astore_1
    //   562: aload_1
    //   563: aload_3
    //   564: invokevirtual 86	com/tencent/tav/coremedia/CMSampleBuffer:getSampleByteBuffer	()Ljava/nio/ByteBuffer;
    //   567: invokevirtual 171	java/nio/ByteBuffer:order	()Ljava/nio/ByteOrder;
    //   570: invokevirtual 174	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   573: pop
    //   574: aload_0
    //   575: aload_1
    //   576: invokevirtual 157	java/nio/ByteBuffer:asShortBuffer	()Ljava/nio/ShortBuffer;
    //   579: putfield 136	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   582: aload 12
    //   584: iload 8
    //   586: iload 6
    //   588: isub
    //   589: invokevirtual 189	java/nio/ShortBuffer:position	(I)Ljava/nio/Buffer;
    //   592: pop
    //   593: aload_0
    //   594: getfield 136	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   597: aload 12
    //   599: invokevirtual 187	java/nio/ShortBuffer:put	(Ljava/nio/ShortBuffer;)Ljava/nio/ShortBuffer;
    //   602: pop
    //   603: aload_0
    //   604: getfield 136	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   607: invokevirtual 261	java/nio/ShortBuffer:flip	()Ljava/nio/Buffer;
    //   610: pop
    //   611: aload 12
    //   613: iconst_0
    //   614: invokevirtual 189	java/nio/ShortBuffer:position	(I)Ljava/nio/Buffer;
    //   617: pop
    //   618: aload 12
    //   620: iload 8
    //   622: iload 6
    //   624: isub
    //   625: invokevirtual 183	java/nio/ShortBuffer:limit	(I)Ljava/nio/Buffer;
    //   628: pop
    //   629: aload_0
    //   630: getfield 134	com/tencent/tav/core/AudioCompositor:currentSamples	Ljava/nio/ShortBuffer;
    //   633: aload 12
    //   635: invokevirtual 187	java/nio/ShortBuffer:put	(Ljava/nio/ShortBuffer;)Ljava/nio/ShortBuffer;
    //   638: pop
    //   639: aload_0
    //   640: getfield 134	com/tencent/tav/core/AudioCompositor:currentSamples	Ljava/nio/ShortBuffer;
    //   643: invokevirtual 261	java/nio/ShortBuffer:flip	()Ljava/nio/Buffer;
    //   646: pop
    //   647: aload_0
    //   648: getfield 68	com/tencent/tav/core/AudioCompositor:audioMixer	Lcom/tencent/tav/decoder/AudioMixer;
    //   651: aload_3
    //   652: invokevirtual 86	com/tencent/tav/coremedia/CMSampleBuffer:getSampleByteBuffer	()Ljava/nio/ByteBuffer;
    //   655: invokevirtual 157	java/nio/ByteBuffer:asShortBuffer	()Ljava/nio/ShortBuffer;
    //   658: aload_0
    //   659: getfield 134	com/tencent/tav/core/AudioCompositor:currentSamples	Ljava/nio/ShortBuffer;
    //   662: invokevirtual 265	com/tencent/tav/decoder/AudioMixer:mergeSamples	(Ljava/nio/ShortBuffer;Ljava/nio/ShortBuffer;)Ljava/nio/ByteBuffer;
    //   665: astore_1
    //   666: new 82	com/tencent/tav/coremedia/CMSampleBuffer
    //   669: dup
    //   670: aload_3
    //   671: invokevirtual 193	com/tencent/tav/coremedia/CMSampleBuffer:getTime	()Lcom/tencent/tav/coremedia/CMTime;
    //   674: aload_1
    //   675: invokespecial 268	com/tencent/tav/coremedia/CMSampleBuffer:<init>	(Lcom/tencent/tav/coremedia/CMTime;Ljava/nio/ByteBuffer;)V
    //   678: astore_3
    //   679: ldc 153
    //   681: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   684: goto -647 -> 37
    //   687: fconst_1
    //   688: fstore 4
    //   690: goto -289 -> 401
    //   693: aload_0
    //   694: getfield 136	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   697: invokevirtual 224	java/nio/ShortBuffer:clear	()Ljava/nio/Buffer;
    //   700: pop
    //   701: goto -119 -> 582
    //   704: astore_1
    //   705: aload_0
    //   706: getfield 52	com/tencent/tav/core/AudioCompositor:TAG	Ljava/lang/String;
    //   709: ldc_w 270
    //   712: aload_1
    //   713: invokestatic 274	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   716: new 82	com/tencent/tav/coremedia/CMSampleBuffer
    //   719: dup
    //   720: ldc2_w 229
    //   723: ldc_w 276
    //   726: aload_1
    //   727: invokestatic 280	com/tencent/tav/coremedia/CMSampleState:fromError	(JLjava/lang/String;Ljava/lang/Throwable;)Lcom/tencent/tav/coremedia/CMSampleState;
    //   730: invokespecial 283	com/tencent/tav/coremedia/CMSampleBuffer:<init>	(Lcom/tencent/tav/coremedia/CMSampleState;)V
    //   733: astore_3
    //   734: ldc 153
    //   736: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   739: goto -702 -> 37
    //   742: aload_0
    //   743: getfield 134	com/tencent/tav/core/AudioCompositor:currentSamples	Ljava/nio/ShortBuffer;
    //   746: aload 12
    //   748: invokevirtual 187	java/nio/ShortBuffer:put	(Ljava/nio/ShortBuffer;)Ljava/nio/ShortBuffer;
    //   751: pop
    //   752: aload 12
    //   754: invokevirtual 160	java/nio/ShortBuffer:limit	()I
    //   757: istore 9
    //   759: iload 7
    //   761: istore 5
    //   763: iload 9
    //   765: iload 6
    //   767: iadd
    //   768: istore 6
    //   770: goto -560 -> 210
    //   773: iload 7
    //   775: istore 5
    //   777: goto -567 -> 210
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	780	0	this	AudioCompositor
    //   0	780	1	paramAudioDecoderTrack	com.tencent.tav.decoder.AudioDecoderTrack
    //   0	780	2	paramAudioMixInputParameters	AudioMixInputParameters
    //   0	780	3	paramCMSampleBuffer	CMSampleBuffer
    //   399	290	4	f	float
    //   139	637	5	i	int
    //   148	621	6	j	int
    //   248	526	7	k	int
    //   51	574	8	m	int
    //   757	11	9	n	int
    //   358	3	10	l	long
    //   79	674	12	localObject1	Object
    //   225	267	13	localCMSampleBuffer	CMSampleBuffer
    //   242	230	14	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	315	finally
    //   11	18	315	finally
    //   22	37	315	finally
    //   41	72	315	finally
    //   72	103	315	finally
    //   103	198	315	finally
    //   198	207	315	finally
    //   293	298	315	finally
    //   304	312	315	finally
    //   320	347	315	finally
    //   369	374	315	finally
    //   679	684	315	finally
    //   705	739	315	finally
    //   217	244	704	finally
    //   250	285	704	finally
    //   350	360	704	finally
    //   377	386	704	finally
    //   390	401	704	finally
    //   401	432	704	finally
    //   444	490	704	finally
    //   490	554	704	finally
    //   554	582	704	finally
    //   582	639	704	finally
    //   639	679	704	finally
    //   693	701	704	finally
    //   742	759	704	finally
  }
  
  public void setAudioInfo(AudioInfo paramAudioInfo)
  {
    AppMethodBeat.i(215403);
    this.audioMixer = new AudioMixer(paramAudioInfo.sampleRate, paramAudioInfo.channelCount);
    AppMethodBeat.o(215403);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.core.AudioCompositor
 * JD-Core Version:    0.7.0.1
 */
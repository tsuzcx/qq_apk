package com.tencent.tav.core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.decoder.AudioInfo;
import com.tencent.tav.decoder.AudioMixer;
import java.nio.ByteBuffer;
import java.nio.ShortBuffer;

public class AudioCompositor
{
  public static boolean LOG_VERBOSE = false;
  private final String TAG;
  private AudioMixer audioMixer;
  private ShortBuffer currentSamples;
  private ShortBuffer lastSamples;
  
  public AudioCompositor(AudioInfo paramAudioInfo)
  {
    AppMethodBeat.i(197594);
    this.TAG = ("AudioCompositor@" + Integer.toHexString(hashCode()));
    this.audioMixer = new AudioMixer(paramAudioInfo.sampleRate, paramAudioInfo.channelCount);
    AppMethodBeat.o(197594);
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
    AppMethodBeat.i(197597);
    this.audioMixer.setAudioInfo(paramAudioInfo.sampleRate, paramAudioInfo.channelCount, paramAudioInfo.pcmEncoding);
    paramByteBuffer = this.audioMixer.processBytes(paramByteBuffer, paramFloat2, paramFloat1, 1.0F);
    AppMethodBeat.o(197597);
    return paramByteBuffer;
  }
  
  /* Error */
  public com.tencent.tav.coremedia.CMSampleBuffer readMergeSample(com.tencent.tav.decoder.AudioDecoderTrack paramAudioDecoderTrack, AudioMixInputParameters paramAudioMixInputParameters, com.tencent.tav.coremedia.CMSampleBuffer paramCMSampleBuffer)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 7
    //   3: aload_0
    //   4: monitorenter
    //   5: ldc 99
    //   7: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   10: aload_3
    //   11: ifnull +14 -> 25
    //   14: aload_3
    //   15: invokevirtual 105	com/tencent/tav/coremedia/CMSampleBuffer:getSampleByteBuffer	()Ljava/nio/ByteBuffer;
    //   18: ifnull +7 -> 25
    //   21: aload_1
    //   22: ifnonnull +22 -> 44
    //   25: aload_0
    //   26: aconst_null
    //   27: putfield 78	com/tencent/tav/core/AudioCompositor:currentSamples	Ljava/nio/ShortBuffer;
    //   30: aload_0
    //   31: aconst_null
    //   32: putfield 80	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   35: ldc 99
    //   37: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   40: aload_0
    //   41: monitorexit
    //   42: aload_3
    //   43: areturn
    //   44: aload_3
    //   45: invokevirtual 105	com/tencent/tav/coremedia/CMSampleBuffer:getSampleByteBuffer	()Ljava/nio/ByteBuffer;
    //   48: invokevirtual 111	java/nio/ByteBuffer:asShortBuffer	()Ljava/nio/ShortBuffer;
    //   51: invokevirtual 116	java/nio/ShortBuffer:limit	()I
    //   54: istore 8
    //   56: aload_0
    //   57: getfield 78	com/tencent/tav/core/AudioCompositor:currentSamples	Ljava/nio/ShortBuffer;
    //   60: ifnull +15 -> 75
    //   63: aload_0
    //   64: getfield 78	com/tencent/tav/core/AudioCompositor:currentSamples	Ljava/nio/ShortBuffer;
    //   67: invokevirtual 119	java/nio/ShortBuffer:capacity	()I
    //   70: iload 8
    //   72: if_icmpge +236 -> 308
    //   75: iload 8
    //   77: iconst_2
    //   78: imul
    //   79: invokestatic 123	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   82: astore 10
    //   84: aload 10
    //   86: aload_3
    //   87: invokevirtual 105	com/tencent/tav/coremedia/CMSampleBuffer:getSampleByteBuffer	()Ljava/nio/ByteBuffer;
    //   90: invokevirtual 127	java/nio/ByteBuffer:order	()Ljava/nio/ByteOrder;
    //   93: invokevirtual 130	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   96: pop
    //   97: aload_0
    //   98: aload 10
    //   100: invokevirtual 111	java/nio/ByteBuffer:asShortBuffer	()Ljava/nio/ShortBuffer;
    //   103: putfield 78	com/tencent/tav/core/AudioCompositor:currentSamples	Ljava/nio/ShortBuffer;
    //   106: aload_0
    //   107: getfield 80	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   110: ifnull +91 -> 201
    //   113: aload_0
    //   114: getfield 80	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   117: invokevirtual 133	java/nio/ShortBuffer:remaining	()I
    //   120: ifle +81 -> 201
    //   123: iload 8
    //   125: aload_0
    //   126: getfield 80	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   129: invokevirtual 133	java/nio/ShortBuffer:remaining	()I
    //   132: if_icmpge +187 -> 319
    //   135: aload_0
    //   136: getfield 80	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   139: invokevirtual 136	java/nio/ShortBuffer:position	()I
    //   142: istore 5
    //   144: aload_0
    //   145: getfield 80	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   148: invokevirtual 116	java/nio/ShortBuffer:limit	()I
    //   151: istore 6
    //   153: aload_0
    //   154: getfield 80	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   157: iload 5
    //   159: iload 8
    //   161: iadd
    //   162: invokevirtual 139	java/nio/ShortBuffer:limit	(I)Ljava/nio/Buffer;
    //   165: pop
    //   166: aload_0
    //   167: getfield 78	com/tencent/tav/core/AudioCompositor:currentSamples	Ljava/nio/ShortBuffer;
    //   170: aload_0
    //   171: getfield 80	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   174: invokevirtual 143	java/nio/ShortBuffer:put	(Ljava/nio/ShortBuffer;)Ljava/nio/ShortBuffer;
    //   177: pop
    //   178: aload_0
    //   179: getfield 80	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   182: iload 6
    //   184: invokevirtual 139	java/nio/ShortBuffer:limit	(I)Ljava/nio/Buffer;
    //   187: pop
    //   188: aload_0
    //   189: getfield 80	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   192: iload 5
    //   194: iload 8
    //   196: iadd
    //   197: invokevirtual 145	java/nio/ShortBuffer:position	(I)Ljava/nio/Buffer;
    //   200: pop
    //   201: aload_0
    //   202: getfield 78	com/tencent/tav/core/AudioCompositor:currentSamples	Ljava/nio/ShortBuffer;
    //   205: invokevirtual 136	java/nio/ShortBuffer:position	()I
    //   208: istore 5
    //   210: iload 5
    //   212: iload 8
    //   214: if_icmpge +361 -> 575
    //   217: aload_1
    //   218: aload_3
    //   219: invokevirtual 149	com/tencent/tav/coremedia/CMSampleBuffer:getTime	()Lcom/tencent/tav/coremedia/CMTime;
    //   222: invokevirtual 155	com/tencent/tav/decoder/AudioDecoderTrack:readSample	(Lcom/tencent/tav/coremedia/CMTime;)Lcom/tencent/tav/coremedia/CMSampleBuffer;
    //   225: astore 10
    //   227: iload 7
    //   229: istore 6
    //   231: getstatic 17	com/tencent/tav/core/AudioCompositor:LOG_VERBOSE	Z
    //   234: ifeq +43 -> 277
    //   237: aload_0
    //   238: getfield 56	com/tencent/tav/core/AudioCompositor:TAG	Ljava/lang/String;
    //   241: new 31	java/lang/StringBuilder
    //   244: dup
    //   245: ldc 157
    //   247: invokespecial 36	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   250: iload 7
    //   252: invokevirtual 160	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   255: ldc 162
    //   257: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: aload 10
    //   262: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   265: invokevirtual 54	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   268: invokestatic 171	com/tencent/tav/decoder/logger/Logger:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   271: iload 7
    //   273: iconst_1
    //   274: iadd
    //   275: istore 6
    //   277: aload 10
    //   279: invokevirtual 149	com/tencent/tav/coremedia/CMSampleBuffer:getTime	()Lcom/tencent/tav/coremedia/CMTime;
    //   282: getstatic 177	com/tencent/tav/decoder/IDecoder:SAMPLE_TIME_FINISH	Lcom/tencent/tav/coremedia/CMTime;
    //   285: invokevirtual 183	com/tencent/tav/coremedia/CMTime:bigThan	(Lcom/tencent/tav/coremedia/CMTime;)Z
    //   288: istore 9
    //   290: iload 9
    //   292: ifne +57 -> 349
    //   295: ldc 99
    //   297: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   300: goto -260 -> 40
    //   303: astore_1
    //   304: aload_0
    //   305: monitorexit
    //   306: aload_1
    //   307: athrow
    //   308: aload_0
    //   309: getfield 78	com/tencent/tav/core/AudioCompositor:currentSamples	Ljava/nio/ShortBuffer;
    //   312: invokevirtual 186	java/nio/ShortBuffer:clear	()Ljava/nio/Buffer;
    //   315: pop
    //   316: goto -210 -> 106
    //   319: aload_0
    //   320: getfield 78	com/tencent/tav/core/AudioCompositor:currentSamples	Ljava/nio/ShortBuffer;
    //   323: aload_0
    //   324: getfield 80	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   327: invokevirtual 143	java/nio/ShortBuffer:put	(Ljava/nio/ShortBuffer;)Ljava/nio/ShortBuffer;
    //   330: pop
    //   331: aload_0
    //   332: getfield 80	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   335: aload_0
    //   336: getfield 80	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   339: invokevirtual 116	java/nio/ShortBuffer:limit	()I
    //   342: invokevirtual 145	java/nio/ShortBuffer:position	(I)Ljava/nio/Buffer;
    //   345: pop
    //   346: goto -145 -> 201
    //   349: aload_1
    //   350: aload 10
    //   352: invokevirtual 149	com/tencent/tav/coremedia/CMSampleBuffer:getTime	()Lcom/tencent/tav/coremedia/CMTime;
    //   355: invokevirtual 190	com/tencent/tav/decoder/AudioDecoderTrack:asyncReadNextSample	(Lcom/tencent/tav/coremedia/CMTime;)V
    //   358: aload_2
    //   359: ifnull +264 -> 623
    //   362: aload_2
    //   363: aload 10
    //   365: invokevirtual 149	com/tencent/tav/coremedia/CMSampleBuffer:getTime	()Lcom/tencent/tav/coremedia/CMTime;
    //   368: invokevirtual 196	com/tencent/tav/core/AudioMixInputParameters:getVolumeAtTime	(Lcom/tencent/tav/coremedia/CMTime;)F
    //   371: fstore 4
    //   373: iload 6
    //   375: istore 7
    //   377: aload 10
    //   379: invokevirtual 105	com/tencent/tav/coremedia/CMSampleBuffer:getSampleByteBuffer	()Ljava/nio/ByteBuffer;
    //   382: ifnull -172 -> 210
    //   385: aload_2
    //   386: ifnull +38 -> 424
    //   389: aload_2
    //   390: invokevirtual 200	com/tencent/tav/core/AudioMixInputParameters:getAudioTapProcessor	()Lcom/tencent/tav/core/AudioTapProcessor;
    //   393: ifnull +31 -> 424
    //   396: aload 10
    //   398: aload_2
    //   399: invokevirtual 200	com/tencent/tav/core/AudioMixInputParameters:getAudioTapProcessor	()Lcom/tencent/tav/core/AudioTapProcessor;
    //   402: aload 10
    //   404: invokevirtual 149	com/tencent/tav/coremedia/CMSampleBuffer:getTime	()Lcom/tencent/tav/coremedia/CMTime;
    //   407: aload 10
    //   409: invokevirtual 105	com/tencent/tav/coremedia/CMSampleBuffer:getSampleByteBuffer	()Ljava/nio/ByteBuffer;
    //   412: aload_1
    //   413: invokevirtual 204	com/tencent/tav/decoder/AudioDecoderTrack:getAudioInfo	()Lcom/tencent/tav/decoder/AudioInfo;
    //   416: invokeinterface 210 4 0
    //   421: invokevirtual 214	com/tencent/tav/coremedia/CMSampleBuffer:setSampleByteBuffer	(Ljava/nio/ByteBuffer;)V
    //   424: aload_0
    //   425: aload 10
    //   427: invokevirtual 105	com/tencent/tav/coremedia/CMSampleBuffer:getSampleByteBuffer	()Ljava/nio/ByteBuffer;
    //   430: fload 4
    //   432: fconst_1
    //   433: aload_1
    //   434: invokevirtual 204	com/tencent/tav/decoder/AudioDecoderTrack:getAudioInfo	()Lcom/tencent/tav/decoder/AudioInfo;
    //   437: invokevirtual 216	com/tencent/tav/core/AudioCompositor:processFrame	(Ljava/nio/ByteBuffer;FFLcom/tencent/tav/decoder/AudioInfo;)Ljava/nio/ByteBuffer;
    //   440: invokevirtual 111	java/nio/ByteBuffer:asShortBuffer	()Ljava/nio/ShortBuffer;
    //   443: astore 10
    //   445: aload 10
    //   447: invokevirtual 116	java/nio/ShortBuffer:limit	()I
    //   450: iload 8
    //   452: iload 5
    //   454: isub
    //   455: if_icmple +214 -> 669
    //   458: aload 10
    //   460: invokevirtual 116	java/nio/ShortBuffer:limit	()I
    //   463: iload 8
    //   465: iload 5
    //   467: isub
    //   468: isub
    //   469: istore 6
    //   471: aload_0
    //   472: getfield 80	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   475: ifnull +15 -> 490
    //   478: aload_0
    //   479: getfield 80	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   482: invokevirtual 119	java/nio/ShortBuffer:capacity	()I
    //   485: iload 6
    //   487: if_icmpge +142 -> 629
    //   490: iload 6
    //   492: iconst_2
    //   493: imul
    //   494: invokestatic 123	java/nio/ByteBuffer:allocateDirect	(I)Ljava/nio/ByteBuffer;
    //   497: astore_1
    //   498: aload_1
    //   499: aload_3
    //   500: invokevirtual 105	com/tencent/tav/coremedia/CMSampleBuffer:getSampleByteBuffer	()Ljava/nio/ByteBuffer;
    //   503: invokevirtual 127	java/nio/ByteBuffer:order	()Ljava/nio/ByteOrder;
    //   506: invokevirtual 130	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   509: pop
    //   510: aload_0
    //   511: aload_1
    //   512: invokevirtual 111	java/nio/ByteBuffer:asShortBuffer	()Ljava/nio/ShortBuffer;
    //   515: putfield 80	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   518: aload 10
    //   520: iload 8
    //   522: iload 5
    //   524: isub
    //   525: invokevirtual 145	java/nio/ShortBuffer:position	(I)Ljava/nio/Buffer;
    //   528: pop
    //   529: aload_0
    //   530: getfield 80	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   533: aload 10
    //   535: invokevirtual 143	java/nio/ShortBuffer:put	(Ljava/nio/ShortBuffer;)Ljava/nio/ShortBuffer;
    //   538: pop
    //   539: aload_0
    //   540: getfield 80	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   543: invokevirtual 219	java/nio/ShortBuffer:flip	()Ljava/nio/Buffer;
    //   546: pop
    //   547: aload 10
    //   549: iconst_0
    //   550: invokevirtual 145	java/nio/ShortBuffer:position	(I)Ljava/nio/Buffer;
    //   553: pop
    //   554: aload 10
    //   556: iload 8
    //   558: iload 5
    //   560: isub
    //   561: invokevirtual 139	java/nio/ShortBuffer:limit	(I)Ljava/nio/Buffer;
    //   564: pop
    //   565: aload_0
    //   566: getfield 78	com/tencent/tav/core/AudioCompositor:currentSamples	Ljava/nio/ShortBuffer;
    //   569: aload 10
    //   571: invokevirtual 143	java/nio/ShortBuffer:put	(Ljava/nio/ShortBuffer;)Ljava/nio/ShortBuffer;
    //   574: pop
    //   575: aload_0
    //   576: getfield 78	com/tencent/tav/core/AudioCompositor:currentSamples	Ljava/nio/ShortBuffer;
    //   579: invokevirtual 219	java/nio/ShortBuffer:flip	()Ljava/nio/Buffer;
    //   582: pop
    //   583: aload_0
    //   584: getfield 72	com/tencent/tav/core/AudioCompositor:audioMixer	Lcom/tencent/tav/decoder/AudioMixer;
    //   587: aload_3
    //   588: invokevirtual 105	com/tencent/tav/coremedia/CMSampleBuffer:getSampleByteBuffer	()Ljava/nio/ByteBuffer;
    //   591: invokevirtual 111	java/nio/ByteBuffer:asShortBuffer	()Ljava/nio/ShortBuffer;
    //   594: aload_0
    //   595: getfield 78	com/tencent/tav/core/AudioCompositor:currentSamples	Ljava/nio/ShortBuffer;
    //   598: invokevirtual 223	com/tencent/tav/decoder/AudioMixer:mergeSamples	(Ljava/nio/ShortBuffer;Ljava/nio/ShortBuffer;)Ljava/nio/ByteBuffer;
    //   601: astore_1
    //   602: new 101	com/tencent/tav/coremedia/CMSampleBuffer
    //   605: dup
    //   606: aload_3
    //   607: invokevirtual 149	com/tencent/tav/coremedia/CMSampleBuffer:getTime	()Lcom/tencent/tav/coremedia/CMTime;
    //   610: aload_1
    //   611: invokespecial 226	com/tencent/tav/coremedia/CMSampleBuffer:<init>	(Lcom/tencent/tav/coremedia/CMTime;Ljava/nio/ByteBuffer;)V
    //   614: astore_3
    //   615: ldc 99
    //   617: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   620: goto -580 -> 40
    //   623: fconst_1
    //   624: fstore 4
    //   626: goto -253 -> 373
    //   629: aload_0
    //   630: getfield 80	com/tencent/tav/core/AudioCompositor:lastSamples	Ljava/nio/ShortBuffer;
    //   633: invokevirtual 186	java/nio/ShortBuffer:clear	()Ljava/nio/Buffer;
    //   636: pop
    //   637: goto -119 -> 518
    //   640: astore_1
    //   641: aload_0
    //   642: getfield 56	com/tencent/tav/core/AudioCompositor:TAG	Ljava/lang/String;
    //   645: aload_1
    //   646: invokestatic 230	com/tencent/tav/decoder/logger/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   649: new 101	com/tencent/tav/coremedia/CMSampleBuffer
    //   652: dup
    //   653: getstatic 177	com/tencent/tav/decoder/IDecoder:SAMPLE_TIME_FINISH	Lcom/tencent/tav/coremedia/CMTime;
    //   656: aconst_null
    //   657: invokespecial 226	com/tencent/tav/coremedia/CMSampleBuffer:<init>	(Lcom/tencent/tav/coremedia/CMTime;Ljava/nio/ByteBuffer;)V
    //   660: astore_3
    //   661: ldc 99
    //   663: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   666: goto -626 -> 40
    //   669: aload_0
    //   670: getfield 78	com/tencent/tav/core/AudioCompositor:currentSamples	Ljava/nio/ShortBuffer;
    //   673: aload 10
    //   675: invokevirtual 143	java/nio/ShortBuffer:put	(Ljava/nio/ShortBuffer;)Ljava/nio/ShortBuffer;
    //   678: pop
    //   679: aload 10
    //   681: invokevirtual 116	java/nio/ShortBuffer:limit	()I
    //   684: istore 7
    //   686: iload 7
    //   688: iload 5
    //   690: iadd
    //   691: istore 5
    //   693: iload 6
    //   695: istore 7
    //   697: goto -487 -> 210
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	700	0	this	AudioCompositor
    //   0	700	1	paramAudioDecoderTrack	com.tencent.tav.decoder.AudioDecoderTrack
    //   0	700	2	paramAudioMixInputParameters	AudioMixInputParameters
    //   0	700	3	paramCMSampleBuffer	com.tencent.tav.coremedia.CMSampleBuffer
    //   371	254	4	f	float
    //   142	550	5	i	int
    //   151	543	6	j	int
    //   1	695	7	k	int
    //   54	507	8	m	int
    //   288	3	9	bool	boolean
    //   82	598	10	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   5	10	303	finally
    //   14	21	303	finally
    //   25	40	303	finally
    //   44	75	303	finally
    //   75	106	303	finally
    //   106	201	303	finally
    //   201	210	303	finally
    //   217	227	303	finally
    //   231	271	303	finally
    //   277	290	303	finally
    //   295	300	303	finally
    //   308	316	303	finally
    //   319	346	303	finally
    //   349	358	303	finally
    //   362	373	303	finally
    //   377	385	303	finally
    //   389	424	303	finally
    //   424	490	303	finally
    //   490	518	303	finally
    //   518	575	303	finally
    //   575	615	303	finally
    //   615	620	303	finally
    //   629	637	303	finally
    //   641	666	303	finally
    //   669	686	303	finally
    //   217	227	640	java/lang/Throwable
    //   231	271	640	java/lang/Throwable
    //   277	290	640	java/lang/Throwable
    //   349	358	640	java/lang/Throwable
    //   362	373	640	java/lang/Throwable
    //   377	385	640	java/lang/Throwable
    //   389	424	640	java/lang/Throwable
    //   424	490	640	java/lang/Throwable
    //   490	518	640	java/lang/Throwable
    //   518	575	640	java/lang/Throwable
    //   575	615	640	java/lang/Throwable
    //   629	637	640	java/lang/Throwable
    //   669	686	640	java/lang/Throwable
  }
  
  public void setAudioInfo(AudioInfo paramAudioInfo)
  {
    AppMethodBeat.i(197595);
    this.audioMixer = new AudioMixer(paramAudioInfo.sampleRate, paramAudioInfo.channelCount);
    AppMethodBeat.o(197595);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.tav.core.AudioCompositor
 * JD-Core Version:    0.7.0.1
 */
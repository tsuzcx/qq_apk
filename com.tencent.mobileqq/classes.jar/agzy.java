import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import com.tencent.mobileqq.richmedia.mediacodec.AudioDecoder;
import com.tencent.mobileqq.richmedia.mediacodec.AudioDecoder.AudioDecodeConfig;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

public class agzy
  implements Runnable
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private volatile boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int;
  private int d;
  
  public agzy(AudioDecoder paramAudioDecoder, float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_Float = paramFloat1;
    this.jdField_b_of_type_Float = paramFloat2;
  }
  
  /* Error */
  private void a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: iconst_3
    //   1: istore_3
    //   2: iconst_4
    //   3: istore_2
    //   4: ldc 37
    //   6: iconst_4
    //   7: ldc 39
    //   9: invokestatic 44	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   12: aconst_null
    //   13: astore 9
    //   15: aload_0
    //   16: getfield 20	agzy:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder	Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   19: invokestatic 49	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	(Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;)Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig;
    //   22: getfield 54	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig:jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData;
    //   25: getfield 59	com/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData:e	I
    //   28: iconst_1
    //   29: if_icmpne +509 -> 538
    //   32: aload_0
    //   33: getfield 20	agzy:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder	Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   36: invokestatic 49	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	(Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;)Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig;
    //   39: getfield 54	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig:jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData;
    //   42: getfield 61	com/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData:jdField_b_of_type_Int	I
    //   45: bipush 16
    //   47: if_icmpne +5 -> 52
    //   50: iconst_2
    //   51: istore_3
    //   52: aload_0
    //   53: getfield 20	agzy:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder	Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   56: invokestatic 49	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	(Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;)Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig;
    //   59: getfield 54	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig:jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData;
    //   62: getfield 63	com/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData:d	I
    //   65: iload_2
    //   66: iload_3
    //   67: invokestatic 69	android/media/AudioTrack:getMinBufferSize	(III)I
    //   70: istore 5
    //   72: iload 5
    //   74: iconst_2
    //   75: imul
    //   76: newarray byte
    //   78: astore 10
    //   80: new 65	android/media/AudioTrack
    //   83: dup
    //   84: iconst_3
    //   85: aload_0
    //   86: getfield 20	agzy:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder	Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   89: invokestatic 49	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	(Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;)Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig;
    //   92: getfield 54	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig:jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData;
    //   95: getfield 63	com/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData:d	I
    //   98: iload_2
    //   99: iload_3
    //   100: iload 5
    //   102: iconst_1
    //   103: invokespecial 72	android/media/AudioTrack:<init>	(IIIIII)V
    //   106: astore 8
    //   108: aload 8
    //   110: invokevirtual 75	android/media/AudioTrack:play	()V
    //   113: iconst_0
    //   114: istore_3
    //   115: aload_0
    //   116: getfield 77	agzy:jdField_a_of_type_Int	I
    //   119: aload_1
    //   120: arraylength
    //   121: if_icmpge +328 -> 449
    //   124: invokestatic 83	java/lang/Thread:interrupted	()Z
    //   127: ifne +322 -> 449
    //   130: iload_3
    //   131: ifne +318 -> 449
    //   134: aload_0
    //   135: getfield 85	agzy:jdField_c_of_type_Float	F
    //   138: fconst_0
    //   139: fcmpl
    //   140: ifeq +87 -> 227
    //   143: aload_0
    //   144: getfield 85	agzy:jdField_c_of_type_Float	F
    //   147: aload_0
    //   148: getfield 86	agzy:d	I
    //   151: i2f
    //   152: fmul
    //   153: aload_0
    //   154: getfield 29	agzy:jdField_b_of_type_Float	F
    //   157: fdiv
    //   158: f2i
    //   159: istore 4
    //   161: iload 4
    //   163: aload_0
    //   164: getfield 20	agzy:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder	Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   167: invokestatic 49	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	(Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;)Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig;
    //   170: getfield 54	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig:jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData;
    //   173: getfield 61	com/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData:jdField_b_of_type_Int	I
    //   176: irem
    //   177: istore 6
    //   179: iload 4
    //   181: istore_2
    //   182: iload 6
    //   184: ifeq +23 -> 207
    //   187: iload 4
    //   189: aload_0
    //   190: getfield 20	agzy:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder	Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   193: invokestatic 49	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	(Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;)Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig;
    //   196: getfield 54	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig:jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData;
    //   199: getfield 61	com/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData:jdField_b_of_type_Int	I
    //   202: iload 6
    //   204: isub
    //   205: iadd
    //   206: istore_2
    //   207: aload_0
    //   208: iload_2
    //   209: aload_0
    //   210: getfield 87	agzy:jdField_b_of_type_Int	I
    //   213: isub
    //   214: putfield 77	agzy:jdField_a_of_type_Int	I
    //   217: aload 8
    //   219: invokevirtual 90	android/media/AudioTrack:flush	()V
    //   222: aload_0
    //   223: fconst_0
    //   224: putfield 85	agzy:jdField_c_of_type_Float	F
    //   227: aload_0
    //   228: getfield 20	agzy:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder	Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   231: invokestatic 49	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	(Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;)Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig;
    //   234: getfield 91	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig:jdField_a_of_type_Int	I
    //   237: tableswitch	default:+298 -> 535, 1:+158->395, 2:+176->413, 3:+194->431
    //   265: aload_0
    //   266: getfield 77	agzy:jdField_a_of_type_Int	I
    //   269: aload 10
    //   271: iload 5
    //   273: iconst_2
    //   274: imul
    //   275: invokestatic 96	com/tencent/mobileqq/richmedia/mediacodec/utils/AudioDataUtil:a	([BI[BI)I
    //   278: istore_2
    //   279: aload_0
    //   280: getfield 20	agzy:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder	Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   283: invokestatic 49	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	(Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;)Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig;
    //   286: getfield 98	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig:b	Z
    //   289: ifne +16 -> 305
    //   292: aload 8
    //   294: aload 10
    //   296: iconst_0
    //   297: iload 5
    //   299: iconst_2
    //   300: imul
    //   301: invokevirtual 102	android/media/AudioTrack:write	([BII)I
    //   304: pop
    //   305: aload_0
    //   306: iload_2
    //   307: aload_0
    //   308: getfield 77	agzy:jdField_a_of_type_Int	I
    //   311: iadd
    //   312: putfield 77	agzy:jdField_a_of_type_Int	I
    //   315: aload_0
    //   316: getfield 77	agzy:jdField_a_of_type_Int	I
    //   319: aload_1
    //   320: arraylength
    //   321: if_icmplt +21 -> 342
    //   324: aload_0
    //   325: getfield 20	agzy:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder	Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   328: invokestatic 49	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	(Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;)Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig;
    //   331: getfield 104	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig:jdField_a_of_type_Boolean	Z
    //   334: ifeq +8 -> 342
    //   337: aload_0
    //   338: iconst_0
    //   339: putfield 77	agzy:jdField_a_of_type_Int	I
    //   342: aload_0
    //   343: getfield 105	agzy:jdField_a_of_type_Boolean	Z
    //   346: istore 7
    //   348: iload 7
    //   350: ifeq -235 -> 115
    //   353: aload_0
    //   354: getfield 25	agzy:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   357: astore 9
    //   359: aload 9
    //   361: monitorenter
    //   362: aload_0
    //   363: getfield 25	agzy:jdField_a_of_type_JavaLangObject	Ljava/lang/Object;
    //   366: invokevirtual 108	java/lang/Object:wait	()V
    //   369: aload 9
    //   371: monitorexit
    //   372: goto -257 -> 115
    //   375: astore 11
    //   377: aload 9
    //   379: monitorexit
    //   380: aload 11
    //   382: athrow
    //   383: astore 9
    //   385: aload 9
    //   387: invokevirtual 111	java/lang/InterruptedException:printStackTrace	()V
    //   390: iconst_1
    //   391: istore_3
    //   392: goto -277 -> 115
    //   395: aload_1
    //   396: aload_0
    //   397: getfield 77	agzy:jdField_a_of_type_Int	I
    //   400: aload 10
    //   402: iload 5
    //   404: iconst_2
    //   405: imul
    //   406: invokestatic 113	com/tencent/mobileqq/richmedia/mediacodec/utils/AudioDataUtil:b	([BI[BI)I
    //   409: istore_2
    //   410: goto -131 -> 279
    //   413: aload_1
    //   414: aload_0
    //   415: getfield 77	agzy:jdField_a_of_type_Int	I
    //   418: aload 10
    //   420: iload 5
    //   422: iconst_2
    //   423: imul
    //   424: invokestatic 115	com/tencent/mobileqq/richmedia/mediacodec/utils/AudioDataUtil:c	([BI[BI)I
    //   427: istore_2
    //   428: goto -149 -> 279
    //   431: aload_1
    //   432: aload_0
    //   433: getfield 77	agzy:jdField_a_of_type_Int	I
    //   436: aload 10
    //   438: iload 5
    //   440: iconst_2
    //   441: imul
    //   442: invokestatic 117	com/tencent/mobileqq/richmedia/mediacodec/utils/AudioDataUtil:d	([BI[BI)I
    //   445: istore_2
    //   446: goto -167 -> 279
    //   449: aload 8
    //   451: invokevirtual 120	android/media/AudioTrack:stop	()V
    //   454: aload 8
    //   456: ifnull +8 -> 464
    //   459: aload 8
    //   461: invokevirtual 123	android/media/AudioTrack:release	()V
    //   464: return
    //   465: astore 8
    //   467: aconst_null
    //   468: astore_1
    //   469: ldc 37
    //   471: iconst_4
    //   472: ldc 125
    //   474: invokestatic 127	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   477: aload 8
    //   479: invokevirtual 128	java/lang/Throwable:printStackTrace	()V
    //   482: aload_1
    //   483: ifnull -19 -> 464
    //   486: aload_1
    //   487: invokevirtual 123	android/media/AudioTrack:release	()V
    //   490: return
    //   491: astore_1
    //   492: aload 9
    //   494: astore 8
    //   496: aload 8
    //   498: ifnull +8 -> 506
    //   501: aload 8
    //   503: invokevirtual 123	android/media/AudioTrack:release	()V
    //   506: aload_1
    //   507: athrow
    //   508: astore_1
    //   509: goto -13 -> 496
    //   512: astore 9
    //   514: aload_1
    //   515: astore 8
    //   517: aload 9
    //   519: astore_1
    //   520: goto -24 -> 496
    //   523: astore 9
    //   525: aload 8
    //   527: astore_1
    //   528: aload 9
    //   530: astore 8
    //   532: goto -63 -> 469
    //   535: goto -271 -> 264
    //   538: bipush 12
    //   540: istore_2
    //   541: goto -509 -> 32
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	544	0	this	agzy
    //   0	544	1	paramArrayOfByte	byte[]
    //   3	538	2	i	int
    //   1	391	3	j	int
    //   159	47	4	k	int
    //   70	372	5	m	int
    //   177	28	6	n	int
    //   346	3	7	bool	boolean
    //   106	354	8	localAudioTrack	android.media.AudioTrack
    //   465	13	8	localThrowable1	Throwable
    //   494	37	8	localObject1	Object
    //   13	365	9	localObject2	Object
    //   383	110	9	localInterruptedException	java.lang.InterruptedException
    //   512	6	9	localObject3	Object
    //   523	6	9	localThrowable2	Throwable
    //   78	359	10	arrayOfByte	byte[]
    //   375	6	11	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   362	372	375	finally
    //   377	380	375	finally
    //   353	362	383	java/lang/InterruptedException
    //   380	383	383	java/lang/InterruptedException
    //   15	32	465	java/lang/Throwable
    //   32	50	465	java/lang/Throwable
    //   52	108	465	java/lang/Throwable
    //   15	32	491	finally
    //   32	50	491	finally
    //   52	108	491	finally
    //   108	113	508	finally
    //   115	130	508	finally
    //   134	179	508	finally
    //   187	207	508	finally
    //   207	227	508	finally
    //   227	264	508	finally
    //   264	279	508	finally
    //   279	305	508	finally
    //   305	342	508	finally
    //   342	348	508	finally
    //   353	362	508	finally
    //   380	383	508	finally
    //   385	390	508	finally
    //   395	410	508	finally
    //   413	428	508	finally
    //   431	446	508	finally
    //   449	454	508	finally
    //   469	482	512	finally
    //   108	113	523	java/lang/Throwable
    //   115	130	523	java/lang/Throwable
    //   134	179	523	java/lang/Throwable
    //   187	207	523	java/lang/Throwable
    //   207	227	523	java/lang/Throwable
    //   227	264	523	java/lang/Throwable
    //   264	279	523	java/lang/Throwable
    //   279	305	523	java/lang/Throwable
    //   305	342	523	java/lang/Throwable
    //   342	348	523	java/lang/Throwable
    //   353	362	523	java/lang/Throwable
    //   380	383	523	java/lang/Throwable
    //   385	390	523	java/lang/Throwable
    //   395	410	523	java/lang/Throwable
    //   413	428	523	java/lang/Throwable
    //   431	446	523	java/lang/Throwable
    //   449	454	523	java/lang/Throwable
  }
  
  /* Error */
  private byte[] a()
  {
    // Byte code:
    //   0: invokestatic 137	java/lang/System:currentTimeMillis	()J
    //   3: lstore_3
    //   4: new 139	java/io/File
    //   7: dup
    //   8: aload_0
    //   9: getfield 20	agzy:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder	Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   12: invokestatic 49	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	(Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;)Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig;
    //   15: getfield 142	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   18: invokespecial 145	java/io/File:<init>	(Ljava/lang/String;)V
    //   21: astore 5
    //   23: aload_0
    //   24: aload 5
    //   26: invokevirtual 148	java/io/File:length	()J
    //   29: l2i
    //   30: putfield 86	agzy:d	I
    //   33: aload_0
    //   34: aload_0
    //   35: getfield 86	agzy:d	I
    //   38: i2f
    //   39: aload_0
    //   40: getfield 27	agzy:jdField_a_of_type_Float	F
    //   43: fmul
    //   44: f2i
    //   45: putfield 87	agzy:jdField_b_of_type_Int	I
    //   48: aload_0
    //   49: getfield 87	agzy:jdField_b_of_type_Int	I
    //   52: aload_0
    //   53: getfield 20	agzy:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder	Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   56: invokestatic 49	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	(Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;)Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig;
    //   59: getfield 54	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig:jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData;
    //   62: getfield 61	com/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData:jdField_b_of_type_Int	I
    //   65: irem
    //   66: istore_1
    //   67: iload_1
    //   68: ifeq +29 -> 97
    //   71: aload_0
    //   72: getfield 87	agzy:jdField_b_of_type_Int	I
    //   75: istore_2
    //   76: aload_0
    //   77: aload_0
    //   78: getfield 20	agzy:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder	Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   81: invokestatic 49	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	(Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;)Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig;
    //   84: getfield 54	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig:jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData;
    //   87: getfield 61	com/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData:jdField_b_of_type_Int	I
    //   90: iload_1
    //   91: isub
    //   92: iload_2
    //   93: iadd
    //   94: putfield 87	agzy:jdField_b_of_type_Int	I
    //   97: aload_0
    //   98: getfield 29	agzy:jdField_b_of_type_Float	F
    //   101: fconst_0
    //   102: fcmpl
    //   103: ifne +160 -> 263
    //   106: aload_0
    //   107: aload_0
    //   108: getfield 86	agzy:d	I
    //   111: putfield 150	agzy:jdField_c_of_type_Int	I
    //   114: ldc 37
    //   116: iconst_4
    //   117: new 152	java/lang/StringBuilder
    //   120: dup
    //   121: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   124: ldc 155
    //   126: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: aload_0
    //   130: getfield 87	agzy:jdField_b_of_type_Int	I
    //   133: invokevirtual 162	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   136: ldc 164
    //   138: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: aload_0
    //   142: getfield 150	agzy:jdField_c_of_type_Int	I
    //   145: invokevirtual 162	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   148: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: invokestatic 44	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   154: aload_0
    //   155: getfield 150	agzy:jdField_c_of_type_Int	I
    //   158: aload_0
    //   159: getfield 87	agzy:jdField_b_of_type_Int	I
    //   162: isub
    //   163: newarray byte
    //   165: astore 7
    //   167: new 170	java/io/FileInputStream
    //   170: dup
    //   171: aload 5
    //   173: invokespecial 173	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   176: astore 6
    //   178: aload 6
    //   180: ifnull +41 -> 221
    //   183: aload 6
    //   185: astore 5
    //   187: aload_0
    //   188: getfield 87	agzy:jdField_b_of_type_Int	I
    //   191: ifeq +18 -> 209
    //   194: aload 6
    //   196: astore 5
    //   198: aload 6
    //   200: aload_0
    //   201: getfield 87	agzy:jdField_b_of_type_Int	I
    //   204: i2l
    //   205: invokevirtual 177	java/io/FileInputStream:skip	(J)J
    //   208: pop2
    //   209: aload 6
    //   211: astore 5
    //   213: aload 6
    //   215: aload 7
    //   217: invokevirtual 181	java/io/FileInputStream:read	([B)I
    //   220: pop
    //   221: aload 6
    //   223: ifnull +8 -> 231
    //   226: aload 6
    //   228: invokevirtual 184	java/io/FileInputStream:close	()V
    //   231: ldc 37
    //   233: iconst_4
    //   234: new 152	java/lang/StringBuilder
    //   237: dup
    //   238: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   241: ldc 186
    //   243: invokevirtual 159	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: invokestatic 137	java/lang/System:currentTimeMillis	()J
    //   249: lload_3
    //   250: lsub
    //   251: invokevirtual 189	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   254: invokevirtual 168	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   257: invokestatic 44	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   260: aload 7
    //   262: areturn
    //   263: aload_0
    //   264: aload_0
    //   265: getfield 86	agzy:d	I
    //   268: i2f
    //   269: aload_0
    //   270: getfield 29	agzy:jdField_b_of_type_Float	F
    //   273: fmul
    //   274: f2i
    //   275: putfield 150	agzy:jdField_c_of_type_Int	I
    //   278: aload_0
    //   279: getfield 150	agzy:jdField_c_of_type_Int	I
    //   282: aload_0
    //   283: getfield 20	agzy:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder	Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   286: invokestatic 49	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	(Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;)Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig;
    //   289: getfield 54	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig:jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData;
    //   292: getfield 61	com/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData:jdField_b_of_type_Int	I
    //   295: irem
    //   296: istore_1
    //   297: iload_1
    //   298: ifeq -184 -> 114
    //   301: aload_0
    //   302: getfield 150	agzy:jdField_c_of_type_Int	I
    //   305: istore_2
    //   306: aload_0
    //   307: aload_0
    //   308: getfield 20	agzy:jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder	Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;
    //   311: invokestatic 49	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder:a	(Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder;)Lcom/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig;
    //   314: getfield 54	com/tencent/mobileqq/richmedia/mediacodec/AudioDecoder$AudioDecodeConfig:jdField_a_of_type_ComTencentMobileqqShortvideoUtilAudioEncoder$AudioData	Lcom/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData;
    //   317: getfield 61	com/tencent/mobileqq/shortvideo/util/AudioEncoder$AudioData:jdField_b_of_type_Int	I
    //   320: iload_1
    //   321: isub
    //   322: iload_2
    //   323: iadd
    //   324: putfield 150	agzy:jdField_c_of_type_Int	I
    //   327: goto -213 -> 114
    //   330: astore 5
    //   332: aload 5
    //   334: invokevirtual 190	java/io/IOException:printStackTrace	()V
    //   337: goto -106 -> 231
    //   340: astore 7
    //   342: aconst_null
    //   343: astore 6
    //   345: aload 6
    //   347: astore 5
    //   349: ldc 37
    //   351: iconst_4
    //   352: ldc 125
    //   354: invokestatic 127	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   357: aload 6
    //   359: astore 5
    //   361: aload 7
    //   363: invokevirtual 128	java/lang/Throwable:printStackTrace	()V
    //   366: aload 6
    //   368: ifnull +8 -> 376
    //   371: aload 6
    //   373: invokevirtual 184	java/io/FileInputStream:close	()V
    //   376: aconst_null
    //   377: areturn
    //   378: astore 5
    //   380: aload 5
    //   382: invokevirtual 190	java/io/IOException:printStackTrace	()V
    //   385: goto -9 -> 376
    //   388: astore 6
    //   390: aconst_null
    //   391: astore 5
    //   393: aload 5
    //   395: ifnull +8 -> 403
    //   398: aload 5
    //   400: invokevirtual 184	java/io/FileInputStream:close	()V
    //   403: aload 6
    //   405: athrow
    //   406: astore 5
    //   408: aload 5
    //   410: invokevirtual 190	java/io/IOException:printStackTrace	()V
    //   413: goto -10 -> 403
    //   416: astore 6
    //   418: goto -25 -> 393
    //   421: astore 7
    //   423: goto -78 -> 345
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	426	0	this	agzy
    //   66	256	1	i	int
    //   75	249	2	j	int
    //   3	247	3	l	long
    //   21	191	5	localObject1	Object
    //   330	3	5	localIOException1	IOException
    //   347	13	5	localObject2	Object
    //   378	3	5	localIOException2	IOException
    //   391	8	5	localObject3	Object
    //   406	3	5	localIOException3	IOException
    //   176	196	6	localFileInputStream	java.io.FileInputStream
    //   388	16	6	localObject4	Object
    //   416	1	6	localObject5	Object
    //   165	96	7	arrayOfByte	byte[]
    //   340	22	7	localThrowable1	Throwable
    //   421	1	7	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   226	231	330	java/io/IOException
    //   167	178	340	java/lang/Throwable
    //   371	376	378	java/io/IOException
    //   167	178	388	finally
    //   398	403	406	java/io/IOException
    //   187	194	416	finally
    //   198	209	416	finally
    //   213	221	416	finally
    //   349	357	416	finally
    //   361	366	416	finally
    //   187	194	421	java/lang/Throwable
    //   198	209	421	java/lang/Throwable
    //   213	221	421	java/lang/Throwable
  }
  
  private byte[] a(String paramString)
  {
    QLog.d("AudioDecoder", 4, "getAudioDataFromMp4 begin");
    long l3 = System.currentTimeMillis();
    MediaCodec localMediaCodec = null;
    MediaExtractor localMediaExtractor = new MediaExtractor();
    for (;;)
    {
      ByteArrayOutputStream localByteArrayOutputStream;
      long l1;
      int i;
      Object localObject1;
      Object localObject2;
      long l2;
      try
      {
        localMediaExtractor.setDataSource(paramString);
        localByteArrayOutputStream = new ByteArrayOutputStream();
        ByteBuffer.allocate(512);
        l1 = 0L;
        i = 0;
        if (i >= localMediaExtractor.getTrackCount()) {
          break label720;
        }
        localObject1 = localMediaExtractor.getTrackFormat(i);
        localObject2 = ((MediaFormat)localObject1).getString("mime");
        this.jdField_a_of_type_Long = ((MediaFormat)localObject1).getLong("durationUs");
        long l4 = (this.jdField_a_of_type_Float * (float)this.jdField_a_of_type_Long);
        l2 = (this.jdField_b_of_type_Float * (float)this.jdField_a_of_type_Long);
        l1 = l2;
        if (l2 == 0L) {
          l1 = this.jdField_a_of_type_Long;
        }
        if (!((String)localObject2).startsWith("audio/")) {
          break label222;
        }
        localMediaExtractor.selectTrack(i);
        if (l4 > 0L) {
          localMediaExtractor.seekTo(l4, 0);
        }
        paramString = localMediaCodec;
      }
      catch (IOException paramString)
      {
        paramString.printStackTrace();
        return null;
      }
      String str;
      try
      {
        localMediaCodec = MediaCodec.createDecoderByType((String)localObject2);
        paramString = localMediaCodec;
        localMediaCodec.configure((MediaFormat)localObject1, null, null, 0);
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        str = paramString;
        continue;
      }
      if (localMediaCodec == null)
      {
        QLog.e("AudioDecoder", 2, "Can't find video info!");
        return null;
        label222:
        i += 1;
      }
      else
      {
        label587:
        label717:
        for (;;)
        {
          int k;
          int m;
          try
          {
            str.start();
            localObject1 = str.getInputBuffers();
            paramString = str.getOutputBuffers();
            localObject2 = new MediaCodec.BufferInfo();
            i = 0;
            int j = 0;
            if (j != 0) {
              break label503;
            }
            k = str.dequeueInputBuffer(10000L);
            if (k < 0) {
              break label503;
            }
            m = localMediaExtractor.readSampleData(localObject1[k], 0);
            l2 = localMediaExtractor.getSampleTime();
            if ((m < 0) || ((l1 > 0L) && (l2 >= l1)))
            {
              str.queueInputBuffer(k, 0, 0, 0L, 4);
              j = 1;
              if (i != 0) {
                break label717;
              }
              k = str.dequeueOutputBuffer((MediaCodec.BufferInfo)localObject2, 10000L);
              switch (k)
              {
              default: 
                if ((((MediaCodec.BufferInfo)localObject2).flags & 0x4) == 0) {
                  break label587;
                }
                if (QLog.isColorLevel()) {
                  QLog.d("AudioDecoder", 2, "output EOS");
                }
                i = 1;
                str.releaseOutputBuffer(k, false);
                if (i == 0) {
                  break label714;
                }
                str.stop();
                str.release();
                localMediaExtractor.release();
                QLog.d("AudioDecoder", 1, "getAudioDataFromMp4 time cost=" + (System.currentTimeMillis() - l3));
                return localByteArrayOutputStream.toByteArray();
              }
            }
          }
          catch (Throwable paramString)
          {
            paramString.printStackTrace();
            QLog.e("AudioDecoder", 2, "decode start error", paramString);
            return null;
          }
          str.queueInputBuffer(k, 0, m, l2, 0);
          localMediaExtractor.advance();
          label503:
          continue;
          if (QLog.isColorLevel()) {
            QLog.d("AudioDecoder", 2, "INFO_OUTPUT_BUFFERS_CHANGED");
          }
          paramString = str.getOutputBuffers();
          continue;
          if (QLog.isColorLevel())
          {
            QLog.d("AudioDecoder", 2, "New format " + str.getOutputFormat());
            continue;
            if (QLog.isColorLevel())
            {
              QLog.d("AudioDecoder", 2, "dequeueOutputBuffer timed out!");
              continue;
              Object localObject3 = paramString[k];
              if (localObject3 == null) {}
              try
              {
                QLog.e("AudioDecoder", 1, "find no data");
                return null;
              }
              catch (Exception paramString)
              {
                byte[] arrayOfByte;
                QLog.e("AudioDecoder", 1, "" + paramString.toString());
                return null;
              }
              if (((MediaCodec.BufferInfo)localObject2).size != 0)
              {
                localObject3.position(((MediaCodec.BufferInfo)localObject2).offset);
                localObject3.limit(((MediaCodec.BufferInfo)localObject2).offset + ((MediaCodec.BufferInfo)localObject2).size);
              }
              m = localObject3.remaining();
              arrayOfByte = new byte[m];
              localObject3.get(arrayOfByte, 0, m);
              localByteArrayOutputStream.write(arrayOfByte, 0, m);
              continue;
            }
          }
        }
        label714:
        label720:
        str = null;
      }
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = 0;
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    float f = (float)paramLong1 / (float)paramLong2;
    if ((f >= this.jdField_a_of_type_Float) && (f <= this.jdField_b_of_type_Float))
    {
      this.jdField_c_of_type_Float = f;
      return;
    }
    QLog.w("AudioDecoder", 1, "seek error, timePercent=" + f);
  }
  
  public void b()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void c()
  {
    this.jdField_a_of_type_Boolean = false;
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaLangObject.notifyAll();
      return;
    }
  }
  
  public void run()
  {
    if (AudioDecoder.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder).jdField_a_of_type_JavaLangString.endsWith(".mp4")) {}
    for (byte[] arrayOfByte = a(AudioDecoder.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaMediacodecAudioDecoder).jdField_a_of_type_JavaLangString); arrayOfByte == null; arrayOfByte = a()) {
      return;
    }
    a(arrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     agzy
 * JD-Core Version:    0.7.0.1
 */
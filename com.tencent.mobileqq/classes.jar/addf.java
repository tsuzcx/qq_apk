import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import msg.aio_doodle.DoodleMsgProto.DoodleData;
import msg.aio_doodle.DoodleMsgProto.DoodleHeader;
import msg.aio_doodle.DoodleMsgProto.LineData;

public class addf
{
  public static float a(Context paramContext, float paramFloat)
  {
    return paramFloat / paramContext.getResources().getDisplayMetrics().density;
  }
  
  private static int a(DoodleMsgProto.DoodleData paramDoodleData)
  {
    if (paramDoodleData == null) {}
    while (!paramDoodleData.uint_line_id.has()) {
      return -1;
    }
    return paramDoodleData.uint_line_id.get();
  }
  
  public static int a(byte[] paramArrayOfByte, int paramInt)
  {
    return paramArrayOfByte[(paramInt + 3)] & 0xFF | paramArrayOfByte[(paramInt + 2)] << 8 & 0xFF00 | paramArrayOfByte[(paramInt + 1)] << 16 & 0xFF0000 | paramArrayOfByte[paramInt] << 24 & 0xFF000000;
  }
  
  public static long a(byte[] paramArrayOfByte, int paramInt)
  {
    long l = 0L;
    int i = 0;
    while (i < 8)
    {
      l = l << 8 | paramArrayOfByte[(i + paramInt)] & 0xFF;
      i += 1;
    }
    return l;
  }
  
  /* Error */
  public static adcz a(java.lang.String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 60	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +9 -> 13
    //   7: aconst_null
    //   8: astore 6
    //   10: aload 6
    //   12: areturn
    //   13: new 62	java/io/File
    //   16: dup
    //   17: aload_0
    //   18: invokespecial 66	java/io/File:<init>	(Ljava/lang/String;)V
    //   21: astore 6
    //   23: aload 6
    //   25: invokevirtual 69	java/io/File:exists	()Z
    //   28: ifne +36 -> 64
    //   31: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   34: ifeq +28 -> 62
    //   37: ldc 76
    //   39: iconst_2
    //   40: new 78	java/lang/StringBuilder
    //   43: dup
    //   44: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   47: ldc 83
    //   49: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: aload_0
    //   53: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: invokestatic 95	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   62: aconst_null
    //   63: areturn
    //   64: new 97	java/io/BufferedInputStream
    //   67: dup
    //   68: new 99	java/io/FileInputStream
    //   71: dup
    //   72: aload 6
    //   74: invokespecial 102	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   77: invokespecial 105	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   80: astore 7
    //   82: aload 7
    //   84: astore 6
    //   86: iconst_4
    //   87: newarray byte
    //   89: astore 9
    //   91: aload 7
    //   93: astore 6
    //   95: aload 7
    //   97: aload 9
    //   99: invokevirtual 111	java/io/InputStream:read	([B)I
    //   102: istore_3
    //   103: iload_3
    //   104: iconst_4
    //   105: if_icmpge +103 -> 208
    //   108: aload 7
    //   110: astore 6
    //   112: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   115: ifeq +32 -> 147
    //   118: aload 7
    //   120: astore 6
    //   122: ldc 76
    //   124: iconst_2
    //   125: new 78	java/lang/StringBuilder
    //   128: dup
    //   129: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   132: ldc 113
    //   134: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: iload_3
    //   138: invokevirtual 116	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   141: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   144: invokestatic 95	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   147: aconst_null
    //   148: astore_0
    //   149: aload_0
    //   150: astore 6
    //   152: aload 7
    //   154: ifnull -144 -> 10
    //   157: aload 7
    //   159: invokevirtual 119	java/io/InputStream:close	()V
    //   162: aconst_null
    //   163: areturn
    //   164: astore 7
    //   166: aload 7
    //   168: invokevirtual 122	java/lang/Exception:printStackTrace	()V
    //   171: aload_0
    //   172: astore 6
    //   174: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   177: ifeq -167 -> 10
    //   180: ldc 76
    //   182: iconst_2
    //   183: new 78	java/lang/StringBuilder
    //   186: dup
    //   187: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   190: ldc 124
    //   192: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: aload 7
    //   197: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   200: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   203: invokestatic 95	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   206: aconst_null
    //   207: areturn
    //   208: aload 7
    //   210: astore 6
    //   212: aload 9
    //   214: iconst_0
    //   215: invokestatic 129	addf:a	([BI)I
    //   218: istore_3
    //   219: iload_3
    //   220: ifle +10 -> 230
    //   223: iload_3
    //   224: sipush 20000
    //   227: if_icmplt +93 -> 320
    //   230: aload 7
    //   232: astore 6
    //   234: ldc 76
    //   236: iconst_2
    //   237: new 78	java/lang/StringBuilder
    //   240: dup
    //   241: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   244: ldc 131
    //   246: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: iload_3
    //   250: invokevirtual 116	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   253: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   256: invokestatic 95	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   259: aconst_null
    //   260: astore_0
    //   261: aload_0
    //   262: astore 6
    //   264: aload 7
    //   266: ifnull -256 -> 10
    //   269: aload 7
    //   271: invokevirtual 119	java/io/InputStream:close	()V
    //   274: aconst_null
    //   275: areturn
    //   276: astore 7
    //   278: aload 7
    //   280: invokevirtual 122	java/lang/Exception:printStackTrace	()V
    //   283: aload_0
    //   284: astore 6
    //   286: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   289: ifeq -279 -> 10
    //   292: ldc 76
    //   294: iconst_2
    //   295: new 78	java/lang/StringBuilder
    //   298: dup
    //   299: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   302: ldc 124
    //   304: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: aload 7
    //   309: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   312: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   315: invokestatic 95	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   318: aconst_null
    //   319: areturn
    //   320: aload 7
    //   322: astore 6
    //   324: iload_3
    //   325: newarray byte
    //   327: astore_0
    //   328: aload 7
    //   330: astore 6
    //   332: aload 7
    //   334: aload_0
    //   335: iconst_0
    //   336: iload_3
    //   337: invokevirtual 134	java/io/InputStream:read	([BII)I
    //   340: istore 4
    //   342: iload 4
    //   344: iload_3
    //   345: if_icmpge +113 -> 458
    //   348: aload 7
    //   350: astore 6
    //   352: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   355: ifeq +42 -> 397
    //   358: aload 7
    //   360: astore 6
    //   362: ldc 76
    //   364: iconst_2
    //   365: new 78	java/lang/StringBuilder
    //   368: dup
    //   369: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   372: ldc 136
    //   374: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   377: iload 4
    //   379: invokevirtual 116	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   382: ldc 138
    //   384: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: iload_3
    //   388: invokevirtual 116	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   391: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   394: invokestatic 95	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   397: aconst_null
    //   398: astore_0
    //   399: aload_0
    //   400: astore 6
    //   402: aload 7
    //   404: ifnull -394 -> 10
    //   407: aload 7
    //   409: invokevirtual 119	java/io/InputStream:close	()V
    //   412: aconst_null
    //   413: areturn
    //   414: astore 7
    //   416: aload 7
    //   418: invokevirtual 122	java/lang/Exception:printStackTrace	()V
    //   421: aload_0
    //   422: astore 6
    //   424: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   427: ifeq -417 -> 10
    //   430: ldc 76
    //   432: iconst_2
    //   433: new 78	java/lang/StringBuilder
    //   436: dup
    //   437: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   440: ldc 124
    //   442: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: aload 7
    //   447: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   450: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   453: invokestatic 95	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   456: aconst_null
    //   457: areturn
    //   458: aload 7
    //   460: astore 6
    //   462: new 140	msg/aio_doodle/DoodleMsgProto$DoodleHeader
    //   465: dup
    //   466: invokespecial 141	msg/aio_doodle/DoodleMsgProto$DoodleHeader:<init>	()V
    //   469: astore 8
    //   471: aload 7
    //   473: astore 6
    //   475: aload 8
    //   477: aload_0
    //   478: checkcast 143	[B
    //   481: invokevirtual 147	msg/aio_doodle/DoodleMsgProto$DoodleHeader:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   484: pop
    //   485: aload 8
    //   487: ifnonnull +64 -> 551
    //   490: aconst_null
    //   491: astore_0
    //   492: aload_0
    //   493: astore 6
    //   495: aload 7
    //   497: ifnull -487 -> 10
    //   500: aload 7
    //   502: invokevirtual 119	java/io/InputStream:close	()V
    //   505: aconst_null
    //   506: areturn
    //   507: astore 7
    //   509: aload 7
    //   511: invokevirtual 122	java/lang/Exception:printStackTrace	()V
    //   514: aload_0
    //   515: astore 6
    //   517: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   520: ifeq -510 -> 10
    //   523: ldc 76
    //   525: iconst_2
    //   526: new 78	java/lang/StringBuilder
    //   529: dup
    //   530: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   533: ldc 124
    //   535: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   538: aload 7
    //   540: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   543: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   546: invokestatic 95	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   549: aconst_null
    //   550: areturn
    //   551: aload 7
    //   553: astore 6
    //   555: new 149	adcz
    //   558: dup
    //   559: invokespecial 150	adcz:<init>	()V
    //   562: astore_0
    //   563: aload 7
    //   565: astore 6
    //   567: aload_0
    //   568: aload 8
    //   570: invokestatic 153	addf:a	(Ladcz;Lmsg/aio_doodle/DoodleMsgProto$DoodleHeader;)V
    //   573: aconst_null
    //   574: astore 8
    //   576: iconst_m1
    //   577: istore_3
    //   578: aload 7
    //   580: astore 6
    //   582: aload 7
    //   584: aload 9
    //   586: invokevirtual 111	java/io/InputStream:read	([B)I
    //   589: iconst_4
    //   590: if_icmpne +68 -> 658
    //   593: aload 7
    //   595: astore 6
    //   597: aload 9
    //   599: iconst_0
    //   600: invokestatic 129	addf:a	([BI)I
    //   603: istore 4
    //   605: iload 4
    //   607: ifle +11 -> 618
    //   610: iload 4
    //   612: sipush 20000
    //   615: if_icmplt +145 -> 760
    //   618: aload 7
    //   620: astore 6
    //   622: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   625: ifeq +33 -> 658
    //   628: aload 7
    //   630: astore 6
    //   632: ldc 76
    //   634: iconst_2
    //   635: new 78	java/lang/StringBuilder
    //   638: dup
    //   639: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   642: ldc 155
    //   644: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   647: iload 4
    //   649: invokevirtual 116	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   652: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   655: invokestatic 95	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   658: aload 8
    //   660: ifnull +15 -> 675
    //   663: aload 7
    //   665: astore 6
    //   667: aload_0
    //   668: aload 8
    //   670: iconst_1
    //   671: iconst_0
    //   672: invokevirtual 158	adcz:a	(Ladej;ZZ)V
    //   675: aload 7
    //   677: astore 6
    //   679: aload 7
    //   681: invokevirtual 119	java/io/InputStream:close	()V
    //   684: aload 7
    //   686: astore 6
    //   688: ldc 76
    //   690: iconst_2
    //   691: ldc 160
    //   693: invokestatic 95	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   696: aload_0
    //   697: astore 6
    //   699: aload 7
    //   701: ifnull +749 -> 1450
    //   704: aload 7
    //   706: invokevirtual 119	java/io/InputStream:close	()V
    //   709: aload_0
    //   710: astore 6
    //   712: aload_0
    //   713: ifnull -703 -> 10
    //   716: aload_0
    //   717: invokevirtual 163	adcz:a	()Ladds;
    //   720: invokevirtual 168	adds:d	()F
    //   723: fstore_1
    //   724: aload_0
    //   725: invokevirtual 163	adcz:a	()Ladds;
    //   728: invokevirtual 171	adds:c	()F
    //   731: fstore_2
    //   732: fload_1
    //   733: fload_2
    //   734: fcmpl
    //   735: ifle +19 -> 754
    //   738: aload_0
    //   739: invokevirtual 163	adcz:a	()Ladds;
    //   742: fload_1
    //   743: invokevirtual 174	adds:c	(F)V
    //   746: aload_0
    //   747: invokevirtual 163	adcz:a	()Ladds;
    //   750: fload_2
    //   751: invokevirtual 176	adds:d	(F)V
    //   754: aload_0
    //   755: invokestatic 179	addf:a	(Ladcz;)V
    //   758: aload_0
    //   759: areturn
    //   760: aload 7
    //   762: astore 6
    //   764: iload 4
    //   766: newarray byte
    //   768: astore 11
    //   770: aload 7
    //   772: astore 6
    //   774: aload 7
    //   776: aload 11
    //   778: iconst_0
    //   779: iload 4
    //   781: invokevirtual 134	java/io/InputStream:read	([BII)I
    //   784: iload 4
    //   786: if_icmpeq +107 -> 893
    //   789: aload 7
    //   791: astore 6
    //   793: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   796: ifeq -138 -> 658
    //   799: aload 7
    //   801: astore 6
    //   803: ldc 76
    //   805: iconst_2
    //   806: new 78	java/lang/StringBuilder
    //   809: dup
    //   810: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   813: ldc 181
    //   815: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   818: iload 4
    //   820: invokevirtual 116	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   823: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   826: invokestatic 95	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   829: goto -171 -> 658
    //   832: astore 8
    //   834: aload 7
    //   836: astore 6
    //   838: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   841: ifeq +36 -> 877
    //   844: aload 7
    //   846: astore 6
    //   848: ldc 76
    //   850: iconst_2
    //   851: new 78	java/lang/StringBuilder
    //   854: dup
    //   855: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   858: ldc 183
    //   860: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   863: aload 8
    //   865: invokevirtual 184	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   868: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   871: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   874: invokestatic 95	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   877: aload_0
    //   878: astore 6
    //   880: aload 7
    //   882: ifnull +568 -> 1450
    //   885: aload 7
    //   887: invokevirtual 119	java/io/InputStream:close	()V
    //   890: goto -181 -> 709
    //   893: aload 7
    //   895: astore 6
    //   897: new 28	msg/aio_doodle/DoodleMsgProto$DoodleData
    //   900: dup
    //   901: invokespecial 185	msg/aio_doodle/DoodleMsgProto$DoodleData:<init>	()V
    //   904: astore 10
    //   906: aload 7
    //   908: astore 6
    //   910: aload 10
    //   912: aload 11
    //   914: checkcast 143	[B
    //   917: invokevirtual 186	msg/aio_doodle/DoodleMsgProto$DoodleData:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   920: pop
    //   921: aload 10
    //   923: ifnonnull +64 -> 987
    //   926: aconst_null
    //   927: astore_0
    //   928: aload_0
    //   929: astore 6
    //   931: aload 7
    //   933: ifnull -923 -> 10
    //   936: aload 7
    //   938: invokevirtual 119	java/io/InputStream:close	()V
    //   941: aconst_null
    //   942: areturn
    //   943: astore 7
    //   945: aload 7
    //   947: invokevirtual 122	java/lang/Exception:printStackTrace	()V
    //   950: aload_0
    //   951: astore 6
    //   953: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   956: ifeq -946 -> 10
    //   959: ldc 76
    //   961: iconst_2
    //   962: new 78	java/lang/StringBuilder
    //   965: dup
    //   966: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   969: ldc 124
    //   971: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   974: aload 7
    //   976: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   979: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   982: invokestatic 95	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   985: aconst_null
    //   986: areturn
    //   987: aload 7
    //   989: astore 6
    //   991: aload 10
    //   993: invokestatic 188	addf:a	(Lmsg/aio_doodle/DoodleMsgProto$DoodleData;)I
    //   996: istore 4
    //   998: aload 7
    //   1000: astore 6
    //   1002: ldc 76
    //   1004: iconst_2
    //   1005: new 78	java/lang/StringBuilder
    //   1008: dup
    //   1009: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   1012: ldc 190
    //   1014: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1017: iload 4
    //   1019: invokevirtual 116	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1022: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1025: invokestatic 95	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1028: iload 4
    //   1030: iconst_m1
    //   1031: if_icmpne +113 -> 1144
    //   1034: aload 7
    //   1036: astore 6
    //   1038: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1041: ifeq -383 -> 658
    //   1044: aload 7
    //   1046: astore 6
    //   1048: ldc 76
    //   1050: iconst_2
    //   1051: new 78	java/lang/StringBuilder
    //   1054: dup
    //   1055: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   1058: ldc 192
    //   1060: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1063: iload 4
    //   1065: invokevirtual 116	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1068: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1071: invokestatic 95	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1074: goto -416 -> 658
    //   1077: astore 8
    //   1079: aload 7
    //   1081: astore 6
    //   1083: aload 8
    //   1085: invokevirtual 122	java/lang/Exception:printStackTrace	()V
    //   1088: aload 7
    //   1090: astore 6
    //   1092: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1095: ifeq +33 -> 1128
    //   1098: aload 7
    //   1100: astore 6
    //   1102: ldc 76
    //   1104: iconst_2
    //   1105: new 78	java/lang/StringBuilder
    //   1108: dup
    //   1109: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   1112: ldc 194
    //   1114: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1117: aload 8
    //   1119: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1122: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1125: invokestatic 95	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1128: aload_0
    //   1129: astore 6
    //   1131: aload 7
    //   1133: ifnull +317 -> 1450
    //   1136: aload 7
    //   1138: invokevirtual 119	java/io/InputStream:close	()V
    //   1141: goto -432 -> 709
    //   1144: iload 4
    //   1146: iload_3
    //   1147: if_icmpne +22 -> 1169
    //   1150: iconst_0
    //   1151: istore 5
    //   1153: aload 7
    //   1155: astore 6
    //   1157: aload 8
    //   1159: aload 10
    //   1161: iload 5
    //   1163: invokestatic 197	addf:a	(Ladej;Lmsg/aio_doodle/DoodleMsgProto$DoodleData;Z)V
    //   1166: goto -588 -> 578
    //   1169: aload 8
    //   1171: ifnull +15 -> 1186
    //   1174: aload 7
    //   1176: astore 6
    //   1178: aload_0
    //   1179: aload 8
    //   1181: iconst_1
    //   1182: iconst_0
    //   1183: invokevirtual 158	adcz:a	(Ladej;ZZ)V
    //   1186: aload 7
    //   1188: astore 6
    //   1190: new 199	adej
    //   1193: dup
    //   1194: invokespecial 200	adej:<init>	()V
    //   1197: astore 8
    //   1199: aload 7
    //   1201: astore 6
    //   1203: aload 8
    //   1205: iload 4
    //   1207: putfield 203	adej:a	I
    //   1210: iconst_1
    //   1211: istore 5
    //   1213: iload 4
    //   1215: istore_3
    //   1216: goto -63 -> 1153
    //   1219: astore 6
    //   1221: aload 6
    //   1223: invokevirtual 122	java/lang/Exception:printStackTrace	()V
    //   1226: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1229: ifeq +29 -> 1258
    //   1232: ldc 76
    //   1234: iconst_2
    //   1235: new 78	java/lang/StringBuilder
    //   1238: dup
    //   1239: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   1242: ldc 124
    //   1244: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1247: aload 6
    //   1249: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1252: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1255: invokestatic 95	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1258: goto -549 -> 709
    //   1261: astore 6
    //   1263: aload 6
    //   1265: invokevirtual 122	java/lang/Exception:printStackTrace	()V
    //   1268: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1271: ifeq +29 -> 1300
    //   1274: ldc 76
    //   1276: iconst_2
    //   1277: new 78	java/lang/StringBuilder
    //   1280: dup
    //   1281: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   1284: ldc 124
    //   1286: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1289: aload 6
    //   1291: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1294: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1297: invokestatic 95	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1300: goto -591 -> 709
    //   1303: astore 6
    //   1305: aload 6
    //   1307: invokevirtual 122	java/lang/Exception:printStackTrace	()V
    //   1310: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1313: ifeq +29 -> 1342
    //   1316: ldc 76
    //   1318: iconst_2
    //   1319: new 78	java/lang/StringBuilder
    //   1322: dup
    //   1323: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   1326: ldc 124
    //   1328: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1331: aload 6
    //   1333: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1336: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1339: invokestatic 95	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1342: goto -633 -> 709
    //   1345: astore_0
    //   1346: aconst_null
    //   1347: astore 6
    //   1349: aload 6
    //   1351: ifnull +8 -> 1359
    //   1354: aload 6
    //   1356: invokevirtual 119	java/io/InputStream:close	()V
    //   1359: aload_0
    //   1360: athrow
    //   1361: astore 6
    //   1363: aload 6
    //   1365: invokevirtual 122	java/lang/Exception:printStackTrace	()V
    //   1368: invokestatic 74	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1371: ifeq -12 -> 1359
    //   1374: ldc 76
    //   1376: iconst_2
    //   1377: new 78	java/lang/StringBuilder
    //   1380: dup
    //   1381: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   1384: ldc 124
    //   1386: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1389: aload 6
    //   1391: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1394: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1397: invokestatic 95	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1400: goto -41 -> 1359
    //   1403: astore_0
    //   1404: goto -55 -> 1349
    //   1407: astore 8
    //   1409: aconst_null
    //   1410: astore 7
    //   1412: aconst_null
    //   1413: astore_0
    //   1414: goto -335 -> 1079
    //   1417: astore 8
    //   1419: aconst_null
    //   1420: astore_0
    //   1421: goto -342 -> 1079
    //   1424: astore 8
    //   1426: aconst_null
    //   1427: astore 7
    //   1429: aconst_null
    //   1430: astore_0
    //   1431: goto -597 -> 834
    //   1434: astore 8
    //   1436: aconst_null
    //   1437: astore_0
    //   1438: goto -604 -> 834
    //   1441: astore 6
    //   1443: goto -522 -> 921
    //   1446: astore_0
    //   1447: goto -962 -> 485
    //   1450: aload 6
    //   1452: astore_0
    //   1453: goto -744 -> 709
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1456	0	paramString	java.lang.String
    //   723	20	1	f1	float
    //   731	20	2	f2	float
    //   102	1114	3	i	int
    //   340	874	4	j	int
    //   1151	61	5	bool	boolean
    //   8	1194	6	localObject1	Object
    //   1219	29	6	localException1	Exception
    //   1261	29	6	localException2	Exception
    //   1303	29	6	localException3	Exception
    //   1347	8	6	localObject2	Object
    //   1361	29	6	localException4	Exception
    //   1441	10	6	localInvalidProtocolBufferMicroException	com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException
    //   80	78	7	localBufferedInputStream	java.io.BufferedInputStream
    //   164	106	7	localException5	Exception
    //   276	132	7	localException6	Exception
    //   414	87	7	localException7	Exception
    //   507	430	7	localException8	Exception
    //   943	257	7	localException9	Exception
    //   1410	18	7	localObject3	Object
    //   469	200	8	localDoodleHeader	DoodleMsgProto.DoodleHeader
    //   832	32	8	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   1077	103	8	localException10	Exception
    //   1197	7	8	localadej	adej
    //   1407	1	8	localException11	Exception
    //   1417	1	8	localException12	Exception
    //   1424	1	8	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   1434	1	8	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   89	509	9	arrayOfByte1	byte[]
    //   904	256	10	localDoodleData	DoodleMsgProto.DoodleData
    //   768	145	11	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   157	162	164	java/lang/Exception
    //   269	274	276	java/lang/Exception
    //   407	412	414	java/lang/Exception
    //   500	505	507	java/lang/Exception
    //   567	573	832	java/lang/OutOfMemoryError
    //   582	593	832	java/lang/OutOfMemoryError
    //   597	605	832	java/lang/OutOfMemoryError
    //   622	628	832	java/lang/OutOfMemoryError
    //   632	658	832	java/lang/OutOfMemoryError
    //   667	675	832	java/lang/OutOfMemoryError
    //   679	684	832	java/lang/OutOfMemoryError
    //   688	696	832	java/lang/OutOfMemoryError
    //   764	770	832	java/lang/OutOfMemoryError
    //   774	789	832	java/lang/OutOfMemoryError
    //   793	799	832	java/lang/OutOfMemoryError
    //   803	829	832	java/lang/OutOfMemoryError
    //   897	906	832	java/lang/OutOfMemoryError
    //   910	921	832	java/lang/OutOfMemoryError
    //   991	998	832	java/lang/OutOfMemoryError
    //   1002	1028	832	java/lang/OutOfMemoryError
    //   1038	1044	832	java/lang/OutOfMemoryError
    //   1048	1074	832	java/lang/OutOfMemoryError
    //   1157	1166	832	java/lang/OutOfMemoryError
    //   1178	1186	832	java/lang/OutOfMemoryError
    //   1190	1199	832	java/lang/OutOfMemoryError
    //   1203	1210	832	java/lang/OutOfMemoryError
    //   936	941	943	java/lang/Exception
    //   567	573	1077	java/lang/Exception
    //   582	593	1077	java/lang/Exception
    //   597	605	1077	java/lang/Exception
    //   622	628	1077	java/lang/Exception
    //   632	658	1077	java/lang/Exception
    //   667	675	1077	java/lang/Exception
    //   679	684	1077	java/lang/Exception
    //   688	696	1077	java/lang/Exception
    //   764	770	1077	java/lang/Exception
    //   774	789	1077	java/lang/Exception
    //   793	799	1077	java/lang/Exception
    //   803	829	1077	java/lang/Exception
    //   897	906	1077	java/lang/Exception
    //   910	921	1077	java/lang/Exception
    //   991	998	1077	java/lang/Exception
    //   1002	1028	1077	java/lang/Exception
    //   1038	1044	1077	java/lang/Exception
    //   1048	1074	1077	java/lang/Exception
    //   1157	1166	1077	java/lang/Exception
    //   1178	1186	1077	java/lang/Exception
    //   1190	1199	1077	java/lang/Exception
    //   1203	1210	1077	java/lang/Exception
    //   704	709	1219	java/lang/Exception
    //   885	890	1261	java/lang/Exception
    //   1136	1141	1303	java/lang/Exception
    //   64	82	1345	finally
    //   1354	1359	1361	java/lang/Exception
    //   86	91	1403	finally
    //   95	103	1403	finally
    //   112	118	1403	finally
    //   122	147	1403	finally
    //   212	219	1403	finally
    //   234	259	1403	finally
    //   324	328	1403	finally
    //   332	342	1403	finally
    //   352	358	1403	finally
    //   362	397	1403	finally
    //   462	471	1403	finally
    //   475	485	1403	finally
    //   555	563	1403	finally
    //   567	573	1403	finally
    //   582	593	1403	finally
    //   597	605	1403	finally
    //   622	628	1403	finally
    //   632	658	1403	finally
    //   667	675	1403	finally
    //   679	684	1403	finally
    //   688	696	1403	finally
    //   764	770	1403	finally
    //   774	789	1403	finally
    //   793	799	1403	finally
    //   803	829	1403	finally
    //   838	844	1403	finally
    //   848	877	1403	finally
    //   897	906	1403	finally
    //   910	921	1403	finally
    //   991	998	1403	finally
    //   1002	1028	1403	finally
    //   1038	1044	1403	finally
    //   1048	1074	1403	finally
    //   1083	1088	1403	finally
    //   1092	1098	1403	finally
    //   1102	1128	1403	finally
    //   1157	1166	1403	finally
    //   1178	1186	1403	finally
    //   1190	1199	1403	finally
    //   1203	1210	1403	finally
    //   64	82	1407	java/lang/Exception
    //   86	91	1417	java/lang/Exception
    //   95	103	1417	java/lang/Exception
    //   112	118	1417	java/lang/Exception
    //   122	147	1417	java/lang/Exception
    //   212	219	1417	java/lang/Exception
    //   234	259	1417	java/lang/Exception
    //   324	328	1417	java/lang/Exception
    //   332	342	1417	java/lang/Exception
    //   352	358	1417	java/lang/Exception
    //   362	397	1417	java/lang/Exception
    //   462	471	1417	java/lang/Exception
    //   475	485	1417	java/lang/Exception
    //   555	563	1417	java/lang/Exception
    //   64	82	1424	java/lang/OutOfMemoryError
    //   86	91	1434	java/lang/OutOfMemoryError
    //   95	103	1434	java/lang/OutOfMemoryError
    //   112	118	1434	java/lang/OutOfMemoryError
    //   122	147	1434	java/lang/OutOfMemoryError
    //   212	219	1434	java/lang/OutOfMemoryError
    //   234	259	1434	java/lang/OutOfMemoryError
    //   324	328	1434	java/lang/OutOfMemoryError
    //   332	342	1434	java/lang/OutOfMemoryError
    //   352	358	1434	java/lang/OutOfMemoryError
    //   362	397	1434	java/lang/OutOfMemoryError
    //   462	471	1434	java/lang/OutOfMemoryError
    //   475	485	1434	java/lang/OutOfMemoryError
    //   555	563	1434	java/lang/OutOfMemoryError
    //   910	921	1441	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   475	485	1446	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  private static DoodleMsgProto.DoodleData a(int paramInt, adej paramadej)
  {
    QLog.d("DoodleMsgTranslator", 2, "formatHeader line header begin :" + paramInt);
    if (paramadej == null) {
      return null;
    }
    ArrayList localArrayList = paramadej.a();
    DoodleMsgProto.DoodleData localDoodleData = new DoodleMsgProto.DoodleData();
    localDoodleData.uint_line_id.set(paramInt);
    localDoodleData.uint_line_id.setHasFlag(true);
    localDoodleData.uint32_rgba.set(paramadej.b());
    localDoodleData.uint32_rgba.setHasFlag(true);
    PBUInt32Field localPBUInt32Field = localDoodleData.uint32template_id;
    if (paramadej.a() < 0) {}
    for (paramInt = 0;; paramInt = paramadej.a())
    {
      localPBUInt32Field.set(paramInt);
      localDoodleData.uint32template_id.setHasFlag(true);
      long l = 0L;
      if (localArrayList.size() > 0) {
        l = ((adek)localArrayList.get(localArrayList.size() - 1)).a();
      }
      localDoodleData.uint32_time.set((int)l);
      localDoodleData.uint32_time.setHasFlag(true);
      return localDoodleData;
    }
  }
  
  private static void a(adcz paramadcz)
  {
    if (paramadcz == null) {}
    Iterator localIterator2;
    adek localadek;
    for (;;)
    {
      return;
      Iterator localIterator1 = paramadcz.a().iterator();
      while (localIterator1.hasNext())
      {
        adej localadej = (adej)localIterator1.next();
        if (localadej.c() >= 500)
        {
          if (QLog.isColorLevel()) {
            QLog.d("DoodleMsgTranslator", 2, "reduce point before:" + localadej.c());
          }
          paramadcz = null;
          localIterator2 = localadej.a().iterator();
          if (localIterator2.hasNext())
          {
            localadek = (adek)localIterator2.next();
            if (localIterator2.hasNext()) {
              break label157;
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("DoodleMsgTranslator", 2, "reduce point end:" + localadej.c());
          }
        }
      }
    }
    label157:
    if (paramadcz == null) {
      paramadcz = localadek;
    }
    for (;;)
    {
      break;
      if ((Math.abs(localadek.a() - paramadcz.a()) < 10.0F) && (Math.abs(localadek.b() - paramadcz.b()) < 10.0F)) {
        localIterator2.remove();
      }
    }
  }
  
  private static void a(adcz paramadcz, DoodleMsgProto.DoodleHeader paramDoodleHeader)
  {
    if ((paramadcz == null) || (paramDoodleHeader == null)) {}
    do
    {
      return;
      BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
      if ((paramDoodleHeader.float_draw_area_width.has()) && (paramDoodleHeader.float_draw_area_height.has())) {
        paramadcz.a().a((int)muc.a(localBaseApplication, paramDoodleHeader.float_draw_area_width.get()), (int)muc.a(localBaseApplication, paramDoodleHeader.float_draw_area_height.get()));
      }
      if (paramDoodleHeader.float_line_width_max.has()) {
        paramadcz.a().a(muc.a(localBaseApplication, paramDoodleHeader.float_line_width_max.get()));
      }
      if (paramDoodleHeader.float_line_width_min.has()) {
        paramadcz.a().b(muc.a(localBaseApplication, paramDoodleHeader.float_line_width_min.get()));
      }
      if (paramDoodleHeader.float_comp_factor_max.has()) {
        paramadcz.a().c(paramDoodleHeader.float_comp_factor_max.get());
      }
      if (paramDoodleHeader.float_comp_factor_min.has()) {
        paramadcz.a().d(paramDoodleHeader.float_comp_factor_min.get());
      }
    } while (!paramDoodleHeader.uint32_time.has());
    paramadcz.a(paramDoodleHeader.uint32_time.get());
  }
  
  private static void a(adej paramadej, DoodleMsgProto.DoodleData paramDoodleData, boolean paramBoolean)
  {
    if ((paramadej == null) || (paramDoodleData == null)) {}
    for (;;)
    {
      return;
      if (paramBoolean)
      {
        if (paramDoodleData.uint32_rgba.has()) {
          paramadej.b(paramDoodleData.uint32_rgba.get());
        }
        if (paramDoodleData.uint32template_id.has())
        {
          paramadej.a(paramDoodleData.uint32template_id.get());
          if (paramadej.a() > 0) {
            paramadej.b(-1);
          }
        }
      }
      BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
      if (paramDoodleData.rpt_line_Data.has())
      {
        paramDoodleData = paramDoodleData.rpt_line_Data.get();
        if (paramDoodleData != null)
        {
          paramDoodleData = paramDoodleData.iterator();
          while (paramDoodleData.hasNext())
          {
            DoodleMsgProto.LineData localLineData = (DoodleMsgProto.LineData)paramDoodleData.next();
            if ((localLineData.float_X.has()) && (localLineData.float_Y.has()) && (localLineData.uint64_tickcount.has())) {
              paramadej.a(muc.a(localBaseApplication, localLineData.float_X.get()), muc.a(localBaseApplication, localLineData.float_Y.get()), -1.0F, localLineData.uint64_tickcount.get());
            }
          }
        }
      }
    }
  }
  
  private static boolean a(int paramInt, adej paramadej, addg paramaddg)
  {
    QLog.d("DoodleMsgTranslator", 2, "formatHeader line begin :" + paramInt);
    boolean bool;
    if ((paramaddg == null) || (paramadej == null))
    {
      bool = false;
      return bool;
    }
    ArrayList localArrayList = paramadej.a();
    if (localArrayList != null) {}
    for (int i = localArrayList.size();; i = 0)
    {
      BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
      bool = true;
      int j = 0;
      DoodleMsgProto.DoodleData localDoodleData = a(paramInt, paramadej);
      if (localDoodleData == null)
      {
        if (paramaddg == null) {
          break;
        }
        return paramaddg.a(null);
      }
      int k = 0;
      while ((k + j < i) && (k < 1000))
      {
        DoodleMsgProto.LineData localLineData = new DoodleMsgProto.LineData();
        adek localadek = (adek)localArrayList.get(j + k);
        localLineData.float_X.set(a(localBaseApplication, localadek.a()));
        localLineData.float_X.setHasFlag(true);
        localLineData.float_Y.set(a(localBaseApplication, localadek.b()));
        localLineData.float_Y.setHasFlag(true);
        localLineData.uint64_tickcount.set(localadek.a());
        localLineData.uint64_tickcount.setHasFlag(true);
        localDoodleData.rpt_line_Data.add(localLineData);
        k += 1;
      }
      j += k;
      QLog.d("DoodleMsgTranslator", 2, "format line pos before:" + j + ". count:" + k);
      if (paramaddg != null) {
        if ((paramaddg.a(localDoodleData)) && (bool)) {
          bool = true;
        }
      }
      for (;;)
      {
        if (j >= i)
        {
          return bool;
          bool = false;
        }
        else
        {
          break;
        }
      }
    }
  }
  
  public static boolean a(adcz paramadcz, addg paramaddg)
  {
    if ((paramadcz == null) || (paramaddg == null)) {}
    do
    {
      do
      {
        return false;
      } while (paramadcz.a() == null);
      try
      {
        boolean bool1 = b(paramadcz, paramaddg);
        paramadcz = paramadcz.a().iterator();
        int i = 0;
        if (paramadcz.hasNext())
        {
          boolean bool2 = a(i, (adej)paramadcz.next(), paramaddg);
          if ((bool2) && (bool1)) {}
          for (bool1 = true;; bool1 = false)
          {
            i += 1;
            break;
          }
        }
        return bool1;
      }
      catch (Exception paramadcz)
      {
        paramadcz.printStackTrace();
      }
    } while (!QLog.isColorLevel());
    QLog.e("DoodleMsgTranslator", 2, "translate data exception:" + paramadcz);
    return false;
  }
  
  public static byte[] a(int paramInt)
  {
    return new byte[] { (byte)((0xFF000000 & paramInt) >> 24), (byte)((0xFF0000 & paramInt) >> 16), (byte)((0xFF00 & paramInt) >> 8), (byte)(paramInt & 0xFF) };
  }
  
  public static byte[] a(long paramLong)
  {
    byte[] arrayOfByte = new byte[8];
    int i = 0;
    while (i < 8)
    {
      arrayOfByte[i] = ((byte)(int)(paramLong >> 64 - (i + 1) * 8 & 0xFF));
      i += 1;
    }
    return arrayOfByte;
  }
  
  public static boolean b(adcz paramadcz, addg paramaddg)
  {
    boolean bool = false;
    if (paramadcz == null)
    {
      if (paramaddg != null) {
        bool = paramaddg.a(null);
      }
      return bool;
    }
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    DoodleMsgProto.DoodleHeader localDoodleHeader = new DoodleMsgProto.DoodleHeader();
    localDoodleHeader.uint32_Version.set(1);
    localDoodleHeader.uint32_Version.setHasFlag(true);
    localDoodleHeader.uint32_time.set((int)paramadcz.a());
    localDoodleHeader.uint32_time.setHasFlag(true);
    ArrayList localArrayList = paramadcz.a();
    if (localArrayList != null) {}
    for (int i = localArrayList.size();; i = 0)
    {
      paramadcz = paramadcz.a();
      localDoodleHeader.uint32_line_count.set(i);
      localDoodleHeader.uint32_line_count.setHasFlag(true);
      localDoodleHeader.float_line_width_max.set(a(localBaseApplication, paramadcz.a()));
      localDoodleHeader.float_line_width_max.setHasFlag(true);
      localDoodleHeader.float_line_width_min.set(a(localBaseApplication, paramadcz.b()));
      localDoodleHeader.float_line_width_min.setHasFlag(true);
      localDoodleHeader.float_comp_factor_max.set(paramadcz.c());
      localDoodleHeader.float_comp_factor_max.setHasFlag(true);
      localDoodleHeader.float_comp_factor_min.set(paramadcz.d());
      localDoodleHeader.float_comp_factor_min.setHasFlag(true);
      localDoodleHeader.float_draw_area_width.set(a(localBaseApplication, paramadcz.a().width()));
      localDoodleHeader.float_draw_area_width.setHasFlag(true);
      localDoodleHeader.float_draw_area_height.set(a(localBaseApplication, paramadcz.a().height()));
      localDoodleHeader.float_draw_area_height.setHasFlag(true);
      if (paramaddg == null) {
        break;
      }
      return paramaddg.a(localDoodleHeader);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     addf
 * JD-Core Version:    0.7.0.1
 */
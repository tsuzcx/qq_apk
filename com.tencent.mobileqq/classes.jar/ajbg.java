import android.content.Context;
import android.os.AsyncTask;
import com.tencent.mobileqq.activity.bless.BlessSelectMemberActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Properties;

public class ajbg
  extends AsyncTask<Void, Void, Integer>
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long = 0L;
  String jdField_a_of_type_JavaLangString;
  WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference;
  ArrayList<String> jdField_a_of_type_JavaUtilArrayList;
  long jdField_b_of_type_Long = 0L;
  WeakReference<QQAppInterface> jdField_b_of_type_JavaLangRefWeakReference;
  
  public ajbg(QQAppInterface paramQQAppInterface, Context paramContext, ArrayList<String> paramArrayList, int paramInt)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramContext);
    this.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(paramQQAppInterface);
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  /* Error */
  protected Integer a(Void... paramVarArgs)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +11 -> 16
    //   8: ldc 53
    //   10: iconst_2
    //   11: ldc 55
    //   13: invokestatic 59	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   16: invokestatic 64	com/tencent/mobileqq/activity/bless/BlessSelectMemberActivity:b	()Ljava/util/concurrent/atomic/AtomicBoolean;
    //   19: astore 5
    //   21: aload 5
    //   23: monitorenter
    //   24: invokestatic 64	com/tencent/mobileqq/activity/bless/BlessSelectMemberActivity:b	()Ljava/util/concurrent/atomic/AtomicBoolean;
    //   27: invokevirtual 69	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   30: ifne +69 -> 99
    //   33: invokestatic 75	android/os/SystemClock:elapsedRealtime	()J
    //   36: lstore_2
    //   37: invokestatic 64	com/tencent/mobileqq/activity/bless/BlessSelectMemberActivity:b	()Ljava/util/concurrent/atomic/AtomicBoolean;
    //   40: invokestatic 77	com/tencent/mobileqq/activity/bless/BlessSelectMemberActivity:a	()J
    //   43: invokevirtual 83	java/lang/Object:wait	(J)V
    //   46: invokestatic 75	android/os/SystemClock:elapsedRealtime	()J
    //   49: lload_2
    //   50: lsub
    //   51: invokestatic 86	com/tencent/mobileqq/activity/bless/BlessSelectMemberActivity:b	(J)J
    //   54: pop2
    //   55: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   58: ifeq +41 -> 99
    //   61: ldc 53
    //   63: iconst_2
    //   64: new 88	java/lang/StringBuilder
    //   67: dup
    //   68: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   71: ldc 91
    //   73: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: invokestatic 97	com/tencent/mobileqq/activity/bless/BlessSelectMemberActivity:b	()J
    //   79: invokevirtual 100	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   82: ldc 102
    //   84: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: invokestatic 105	com/tencent/mobileqq/activity/bless/BlessSelectMemberActivity:a	()I
    //   90: invokevirtual 108	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   93: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: invokestatic 115	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   99: aload 5
    //   101: monitorexit
    //   102: invokestatic 97	com/tencent/mobileqq/activity/bless/BlessSelectMemberActivity:b	()J
    //   105: invokestatic 77	com/tencent/mobileqq/activity/bless/BlessSelectMemberActivity:a	()J
    //   108: lcmp
    //   109: iflt +57 -> 166
    //   112: bipush 9
    //   114: invokestatic 121	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   117: areturn
    //   118: astore 6
    //   120: aload 5
    //   122: monitorexit
    //   123: aload 6
    //   125: athrow
    //   126: astore 5
    //   128: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   131: ifeq -29 -> 102
    //   134: ldc 53
    //   136: iconst_2
    //   137: new 88	java/lang/StringBuilder
    //   140: dup
    //   141: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   144: ldc 123
    //   146: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: aload 5
    //   151: invokevirtual 126	java/lang/InterruptedException:getMessage	()Ljava/lang/String;
    //   154: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   160: invokestatic 115	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   163: goto -61 -> 102
    //   166: invokestatic 105	com/tencent/mobileqq/activity/bless/BlessSelectMemberActivity:a	()I
    //   169: iconst_1
    //   170: if_icmpeq +10 -> 180
    //   173: invokestatic 105	com/tencent/mobileqq/activity/bless/BlessSelectMemberActivity:a	()I
    //   176: invokestatic 121	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   179: areturn
    //   180: aload_0
    //   181: invokestatic 131	java/lang/System:currentTimeMillis	()J
    //   184: putfield 22	ajbg:jdField_a_of_type_Long	J
    //   187: getstatic 133	com/tencent/mobileqq/activity/bless/BlessSelectMemberActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   190: astore 8
    //   192: aload_0
    //   193: getfield 33	ajbg:jdField_b_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   196: invokevirtual 136	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   199: checkcast 138	com/tencent/mobileqq/app/QQAppInterface
    //   202: sipush 138
    //   205: invokevirtual 142	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   208: checkcast 144	ajan
    //   211: invokevirtual 147	ajan:a	()Lcom/tencent/mobileqq/data/MessageForShortVideo;
    //   214: astore 7
    //   216: aload 7
    //   218: ifnonnull +8 -> 226
    //   221: iconst_5
    //   222: invokestatic 121	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   225: areturn
    //   226: aload 7
    //   228: instanceof 149
    //   231: ifeq +52 -> 283
    //   234: aload 7
    //   236: checkcast 149	com/tencent/mobileqq/data/MessageForBlessPTV
    //   239: aload_0
    //   240: getfield 35	ajbg:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   243: putfield 152	com/tencent/mobileqq/data/MessageForBlessPTV:uinList	Ljava/util/ArrayList;
    //   246: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   249: ifeq +34 -> 283
    //   252: ldc 53
    //   254: iconst_2
    //   255: new 88	java/lang/StringBuilder
    //   258: dup
    //   259: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   262: ldc 154
    //   264: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: aload_0
    //   268: getfield 35	ajbg:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   271: invokevirtual 157	java/util/ArrayList:toString	()Ljava/lang/String;
    //   274: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   280: invokestatic 115	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   283: aload_0
    //   284: getfield 33	ajbg:jdField_b_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   287: invokevirtual 136	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   290: checkcast 138	com/tencent/mobileqq/app/QQAppInterface
    //   293: astore 6
    //   295: aload 6
    //   297: ifnull +11 -> 308
    //   300: aload 6
    //   302: invokevirtual 161	com/tencent/mobileqq/app/QQAppInterface:getHwEngine	()Lcom/tencent/mobileqq/highway/HwEngine;
    //   305: invokevirtual 166	com/tencent/mobileqq/highway/HwEngine:preConnect	()V
    //   308: aload 7
    //   310: getfield 171	com/tencent/mobileqq/data/MessageForShortVideo:videoFileName	Ljava/lang/String;
    //   313: invokestatic 176	bhmi:b	(Ljava/lang/String;)Z
    //   316: ifeq +274 -> 590
    //   319: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   322: ifeq +11 -> 333
    //   325: ldc 53
    //   327: iconst_2
    //   328: ldc 178
    //   330: invokestatic 59	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   333: aload 7
    //   335: getfield 181	com/tencent/mobileqq/data/MessageForShortVideo:md5	Ljava/lang/String;
    //   338: invokestatic 187	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   341: ifeq +82 -> 423
    //   344: aload 7
    //   346: aload_0
    //   347: getfield 188	ajbg:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   350: putfield 181	com/tencent/mobileqq/data/MessageForShortVideo:md5	Ljava/lang/String;
    //   353: aload 7
    //   355: ldc 190
    //   357: invokestatic 195	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Lcom/tencent/mobileqq/data/MessageForShortVideo;Ljava/lang/String;)Ljava/lang/String;
    //   360: astore_1
    //   361: aload 8
    //   363: aload_1
    //   364: invokevirtual 201	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   367: ifne +41 -> 408
    //   370: aload 8
    //   372: aload_1
    //   373: invokestatic 205	bhmi:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   376: pop
    //   377: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   380: ifeq +28 -> 408
    //   383: ldc 53
    //   385: iconst_2
    //   386: new 88	java/lang/StringBuilder
    //   389: dup
    //   390: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   393: ldc 207
    //   395: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: aload_1
    //   399: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   405: invokestatic 210	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   408: aload_1
    //   409: putstatic 212	com/tencent/mobileqq/activity/bless/BlessSelectMemberActivity:b	Ljava/lang/String;
    //   412: aload 7
    //   414: aload_1
    //   415: putfield 171	com/tencent/mobileqq/data/MessageForShortVideo:videoFileName	Ljava/lang/String;
    //   418: aload 7
    //   420: invokevirtual 215	com/tencent/mobileqq/data/MessageForShortVideo:serial	()V
    //   423: aload 6
    //   425: ifnull +519 -> 944
    //   428: invokestatic 217	com/tencent/mobileqq/activity/bless/BlessSelectMemberActivity:b	()Z
    //   431: ifne +513 -> 944
    //   434: iconst_0
    //   435: iconst_3
    //   436: invokestatic 222	bcwu:a	(II)Lbcxn;
    //   439: astore_1
    //   440: aload 7
    //   442: aload_1
    //   443: invokestatic 225	bcwu:a	(Ljava/lang/Object;Lbcxn;)Lbcyf;
    //   446: astore 5
    //   448: aload 5
    //   450: iconst_0
    //   451: putfield 230	bcyf:a	Z
    //   454: aload 5
    //   456: iconst_1
    //   457: putfield 232	bcyf:d	Z
    //   460: aload 5
    //   462: getfield 235	bcyf:r	Ljava/lang/String;
    //   465: ifnull +32 -> 497
    //   468: aload 5
    //   470: getfield 235	bcyf:r	Ljava/lang/String;
    //   473: invokevirtual 238	java/lang/String:length	()I
    //   476: bipush 39
    //   478: if_icmpne +19 -> 497
    //   481: aload 5
    //   483: aload 5
    //   485: getfield 235	bcyf:r	Ljava/lang/String;
    //   488: iconst_0
    //   489: bipush 28
    //   491: invokevirtual 242	java/lang/String:substring	(II)Ljava/lang/String;
    //   494: putfield 235	bcyf:r	Ljava/lang/String;
    //   497: aload_1
    //   498: aload 5
    //   500: invokevirtual 247	bcxn:a	(Lbcyf;)V
    //   503: aload_1
    //   504: aload 6
    //   506: invokestatic 250	bcwu:a	(Lbcxn;Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   509: aload_0
    //   510: invokestatic 131	java/lang/System:currentTimeMillis	()J
    //   513: putfield 24	ajbg:jdField_b_of_type_Long	J
    //   516: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   519: ifeq +66 -> 585
    //   522: ldc 53
    //   524: iconst_2
    //   525: new 88	java/lang/StringBuilder
    //   528: dup
    //   529: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   532: ldc 252
    //   534: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   537: aload 7
    //   539: getfield 255	com/tencent/mobileqq/data/MessageForShortVideo:uniseq	J
    //   542: invokevirtual 100	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   545: ldc_w 257
    //   548: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   551: aload 7
    //   553: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   556: ldc_w 262
    //   559: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   562: aload_0
    //   563: getfield 24	ajbg:jdField_b_of_type_Long	J
    //   566: aload_0
    //   567: getfield 22	ajbg:jdField_a_of_type_Long	J
    //   570: lsub
    //   571: l2d
    //   572: ldc2_w 263
    //   575: ddiv
    //   576: invokevirtual 267	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   579: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   582: invokestatic 210	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   585: iconst_1
    //   586: invokestatic 121	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   589: areturn
    //   590: aload 8
    //   592: invokestatic 176	bhmi:b	(Ljava/lang/String;)Z
    //   595: ifne +24 -> 619
    //   598: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   601: ifeq +12 -> 613
    //   604: ldc 53
    //   606: iconst_2
    //   607: ldc_w 269
    //   610: invokestatic 59	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   613: bipush 10
    //   615: invokestatic 121	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   618: areturn
    //   619: new 271	java/io/File
    //   622: dup
    //   623: aload 8
    //   625: invokespecial 274	java/io/File:<init>	(Ljava/lang/String;)V
    //   628: astore 5
    //   630: aload 5
    //   632: invokevirtual 276	java/io/File:length	()J
    //   635: lstore_2
    //   636: lload_2
    //   637: lconst_0
    //   638: lcmp
    //   639: ifne +23 -> 662
    //   642: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   645: ifeq +12 -> 657
    //   648: ldc 53
    //   650: iconst_2
    //   651: ldc_w 278
    //   654: invokestatic 59	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   657: iconst_3
    //   658: invokestatic 121	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   661: areturn
    //   662: new 280	java/io/FileInputStream
    //   665: dup
    //   666: aload 5
    //   668: invokespecial 283	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   671: astore 5
    //   673: aload 5
    //   675: ifnull +196 -> 871
    //   678: aload 5
    //   680: lload_2
    //   681: invokestatic 289	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   684: invokestatic 295	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   687: astore 5
    //   689: aload 5
    //   691: astore_1
    //   692: aload 5
    //   694: invokestatic 187	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   697: ifeq +174 -> 871
    //   700: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   703: ifeq +30 -> 733
    //   706: ldc 53
    //   708: iconst_2
    //   709: new 88	java/lang/StringBuilder
    //   712: dup
    //   713: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   716: ldc_w 297
    //   719: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   722: aload 5
    //   724: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   727: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   730: invokestatic 59	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   733: iconst_3
    //   734: invokestatic 121	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   737: areturn
    //   738: astore 5
    //   740: aload 5
    //   742: invokevirtual 300	java/io/FileNotFoundException:printStackTrace	()V
    //   745: iconst_0
    //   746: ifeq +125 -> 871
    //   749: aconst_null
    //   750: lload_2
    //   751: invokestatic 289	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   754: invokestatic 295	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   757: astore 5
    //   759: aload 5
    //   761: astore_1
    //   762: aload 5
    //   764: invokestatic 187	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   767: ifeq +104 -> 871
    //   770: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   773: ifeq +30 -> 803
    //   776: ldc 53
    //   778: iconst_2
    //   779: new 88	java/lang/StringBuilder
    //   782: dup
    //   783: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   786: ldc_w 297
    //   789: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   792: aload 5
    //   794: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   797: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   800: invokestatic 59	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   803: iconst_3
    //   804: invokestatic 121	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   807: areturn
    //   808: astore_1
    //   809: iconst_0
    //   810: ifeq +59 -> 869
    //   813: aconst_null
    //   814: lload_2
    //   815: invokestatic 289	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   818: invokestatic 295	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   821: astore 5
    //   823: aload 5
    //   825: invokestatic 187	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   828: ifeq +41 -> 869
    //   831: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   834: ifeq +30 -> 864
    //   837: ldc 53
    //   839: iconst_2
    //   840: new 88	java/lang/StringBuilder
    //   843: dup
    //   844: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   847: ldc_w 297
    //   850: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   853: aload 5
    //   855: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   858: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   861: invokestatic 59	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   864: iconst_3
    //   865: invokestatic 121	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   868: areturn
    //   869: aload_1
    //   870: athrow
    //   871: aload_0
    //   872: aload_1
    //   873: putfield 188	ajbg:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   876: aload 7
    //   878: lload_2
    //   879: l2i
    //   880: putfield 303	com/tencent/mobileqq/data/MessageForShortVideo:videoFileSize	I
    //   883: aload 7
    //   885: getfield 306	com/tencent/mobileqq/data/MessageForShortVideo:mThumbFilePath	Ljava/lang/String;
    //   888: invokestatic 176	bhmi:b	(Ljava/lang/String;)Z
    //   891: ifeq -558 -> 333
    //   894: aload 7
    //   896: getfield 309	com/tencent/mobileqq/data/MessageForShortVideo:thumbMD5	Ljava/lang/String;
    //   899: ldc_w 311
    //   902: invokestatic 314	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   905: astore_1
    //   906: aload_1
    //   907: aload 7
    //   909: getfield 306	com/tencent/mobileqq/data/MessageForShortVideo:mThumbFilePath	Ljava/lang/String;
    //   912: invokevirtual 201	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   915: ifne -582 -> 333
    //   918: aload_1
    //   919: aload 7
    //   921: getfield 306	com/tencent/mobileqq/data/MessageForShortVideo:mThumbFilePath	Ljava/lang/String;
    //   924: invokestatic 205	bhmi:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   927: ifne +8 -> 935
    //   930: iconst_3
    //   931: invokestatic 121	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   934: areturn
    //   935: aload 7
    //   937: aload_1
    //   938: putfield 306	com/tencent/mobileqq/data/MessageForShortVideo:mThumbFilePath	Ljava/lang/String;
    //   941: goto -608 -> 333
    //   944: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   947: ifeq -362 -> 585
    //   950: new 88	java/lang/StringBuilder
    //   953: dup
    //   954: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   957: ldc_w 316
    //   960: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   963: astore_1
    //   964: aload 6
    //   966: ifnull +36 -> 1002
    //   969: iconst_1
    //   970: istore 4
    //   972: ldc 53
    //   974: iconst_2
    //   975: aload_1
    //   976: iload 4
    //   978: invokevirtual 319	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   981: ldc_w 321
    //   984: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   987: invokestatic 217	com/tencent/mobileqq/activity/bless/BlessSelectMemberActivity:b	()Z
    //   990: invokevirtual 319	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   993: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   996: invokestatic 210	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   999: goto -414 -> 585
    //   1002: iconst_0
    //   1003: istore 4
    //   1005: goto -33 -> 972
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1008	0	this	ajbg
    //   0	1008	1	paramVarArgs	Void[]
    //   36	843	2	l	long
    //   970	34	4	bool	boolean
    //   126	24	5	localInterruptedException	java.lang.InterruptedException
    //   446	277	5	localObject1	java.lang.Object
    //   738	3	5	localFileNotFoundException	java.io.FileNotFoundException
    //   757	97	5	str1	String
    //   118	6	6	localObject2	java.lang.Object
    //   293	672	6	localQQAppInterface	QQAppInterface
    //   214	722	7	localMessageForShortVideo	com.tencent.mobileqq.data.MessageForShortVideo
    //   190	434	8	str2	String
    // Exception table:
    //   from	to	target	type
    //   24	99	118	finally
    //   99	102	118	finally
    //   120	123	118	finally
    //   16	24	126	java/lang/InterruptedException
    //   123	126	126	java/lang/InterruptedException
    //   662	673	738	java/io/FileNotFoundException
    //   662	673	808	finally
    //   740	745	808	finally
  }
  
  protected void a(Integer paramInteger)
  {
    super.onPostExecute(paramInteger);
    QLog.i("BlessSelectMemberActivity", 1, "BlessPTVUploadTask: onPostExecute result=" + paramInteger + " ,entrance=" + this.jdField_a_of_type_Int);
    Properties localProperties = new Properties();
    localProperties.setProperty("bless_param_ptv_result", "" + paramInteger);
    localProperties.setProperty("bless_param_entrance_type", "" + this.jdField_a_of_type_Int);
    ajap.a("bless_event_ptv_result", localProperties);
    if (paramInteger.intValue() != 1)
    {
      ((BlessSelectMemberActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).e();
      switch (paramInteger.intValue())
      {
      }
    }
    for (;;)
    {
      BlessSelectMemberActivity.b(1);
      return;
      BlessSelectMemberActivity.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2131718247, true);
      continue;
      BlessSelectMemberActivity.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2131718242, true);
      continue;
      BlessSelectMemberActivity.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2131718213, true);
      continue;
      BlessSelectMemberActivity.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2131718239, true);
      continue;
      BlessSelectMemberActivity.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2131718243);
      continue;
      BlessSelectMemberActivity.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2131718240, true);
    }
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    BlessSelectMemberActivity.b(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ajbg
 * JD-Core Version:    0.7.0.1
 */
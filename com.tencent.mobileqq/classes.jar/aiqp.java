import android.content.Context;
import android.os.AsyncTask;
import com.tencent.mobileqq.activity.bless.BlessSelectMemberActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Properties;

public class aiqp
  extends AsyncTask<Void, Void, Integer>
{
  int jdField_a_of_type_Int;
  long jdField_a_of_type_Long = 0L;
  String jdField_a_of_type_JavaLangString;
  WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference;
  ArrayList<String> jdField_a_of_type_JavaUtilArrayList;
  long jdField_b_of_type_Long = 0L;
  WeakReference<QQAppInterface> jdField_b_of_type_JavaLangRefWeakReference;
  
  public aiqp(QQAppInterface paramQQAppInterface, Context paramContext, ArrayList<String> paramArrayList, int paramInt)
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
    //   184: putfield 22	aiqp:jdField_a_of_type_Long	J
    //   187: getstatic 133	com/tencent/mobileqq/activity/bless/BlessSelectMemberActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   190: astore 8
    //   192: aload_0
    //   193: getfield 33	aiqp:jdField_b_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   196: invokevirtual 136	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   199: checkcast 138	com/tencent/mobileqq/app/QQAppInterface
    //   202: getstatic 143	com/tencent/mobileqq/app/QQManagerFactory:SEND_BLESS_CONFIG_MANAGER	I
    //   205: invokevirtual 147	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   208: checkcast 149	aipw
    //   211: invokevirtual 152	aipw:a	()Lcom/tencent/mobileqq/data/MessageForShortVideo;
    //   214: astore 7
    //   216: aload 7
    //   218: ifnonnull +8 -> 226
    //   221: iconst_5
    //   222: invokestatic 121	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   225: areturn
    //   226: aload 7
    //   228: instanceof 154
    //   231: ifeq +52 -> 283
    //   234: aload 7
    //   236: checkcast 154	com/tencent/mobileqq/data/MessageForBlessPTV
    //   239: aload_0
    //   240: getfield 35	aiqp:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   243: putfield 157	com/tencent/mobileqq/data/MessageForBlessPTV:uinList	Ljava/util/ArrayList;
    //   246: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   249: ifeq +34 -> 283
    //   252: ldc 53
    //   254: iconst_2
    //   255: new 88	java/lang/StringBuilder
    //   258: dup
    //   259: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   262: ldc 159
    //   264: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: aload_0
    //   268: getfield 35	aiqp:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   271: invokevirtual 162	java/util/ArrayList:toString	()Ljava/lang/String;
    //   274: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   280: invokestatic 115	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   283: aload_0
    //   284: getfield 33	aiqp:jdField_b_of_type_JavaLangRefWeakReference	Ljava/lang/ref/WeakReference;
    //   287: invokevirtual 136	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   290: checkcast 138	com/tencent/mobileqq/app/QQAppInterface
    //   293: astore 6
    //   295: aload 6
    //   297: ifnull +11 -> 308
    //   300: aload 6
    //   302: invokevirtual 166	com/tencent/mobileqq/app/QQAppInterface:getHwEngine	()Lcom/tencent/mobileqq/highway/HwEngine;
    //   305: invokevirtual 171	com/tencent/mobileqq/highway/HwEngine:preConnect	()V
    //   308: aload 7
    //   310: getfield 176	com/tencent/mobileqq/data/MessageForShortVideo:videoFileName	Ljava/lang/String;
    //   313: invokestatic 182	com/tencent/mobileqq/utils/FileUtils:fileExistsAndNotEmpty	(Ljava/lang/String;)Z
    //   316: ifeq +275 -> 591
    //   319: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   322: ifeq +11 -> 333
    //   325: ldc 53
    //   327: iconst_2
    //   328: ldc 184
    //   330: invokestatic 59	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   333: aload 7
    //   335: getfield 187	com/tencent/mobileqq/data/MessageForShortVideo:md5	Ljava/lang/String;
    //   338: invokestatic 193	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   341: ifeq +82 -> 423
    //   344: aload 7
    //   346: aload_0
    //   347: getfield 194	aiqp:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   350: putfield 187	com/tencent/mobileqq/data/MessageForShortVideo:md5	Ljava/lang/String;
    //   353: aload 7
    //   355: ldc 196
    //   357: invokestatic 202	com/tencent/mobileqq/shortvideo/ShortVideoUtils:getShortVideoSavePath	(Lcom/tencent/mobileqq/data/MessageForShortVideo;Ljava/lang/String;)Ljava/lang/String;
    //   360: astore_1
    //   361: aload 8
    //   363: aload_1
    //   364: invokevirtual 208	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   367: ifne +41 -> 408
    //   370: aload 8
    //   372: aload_1
    //   373: invokestatic 212	com/tencent/mobileqq/utils/FileUtils:rename	(Ljava/lang/String;Ljava/lang/String;)Z
    //   376: pop
    //   377: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   380: ifeq +28 -> 408
    //   383: ldc 53
    //   385: iconst_2
    //   386: new 88	java/lang/StringBuilder
    //   389: dup
    //   390: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   393: ldc 214
    //   395: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: aload_1
    //   399: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   405: invokestatic 217	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   408: aload_1
    //   409: putstatic 219	com/tencent/mobileqq/activity/bless/BlessSelectMemberActivity:b	Ljava/lang/String;
    //   412: aload 7
    //   414: aload_1
    //   415: putfield 176	com/tencent/mobileqq/data/MessageForShortVideo:videoFileName	Ljava/lang/String;
    //   418: aload 7
    //   420: invokevirtual 222	com/tencent/mobileqq/data/MessageForShortVideo:serial	()V
    //   423: aload 6
    //   425: ifnull +520 -> 945
    //   428: invokestatic 224	com/tencent/mobileqq/activity/bless/BlessSelectMemberActivity:b	()Z
    //   431: ifne +514 -> 945
    //   434: iconst_0
    //   435: iconst_3
    //   436: invokestatic 229	bcwz:a	(II)Lbcxr;
    //   439: astore_1
    //   440: aload 7
    //   442: aload_1
    //   443: invokestatic 232	bcwz:a	(Ljava/lang/Object;Lbcxr;)Lbcyj;
    //   446: astore 5
    //   448: aload 5
    //   450: iconst_0
    //   451: putfield 237	bcyj:a	Z
    //   454: aload 5
    //   456: iconst_1
    //   457: putfield 239	bcyj:d	Z
    //   460: aload 5
    //   462: getfield 242	bcyj:r	Ljava/lang/String;
    //   465: ifnull +32 -> 497
    //   468: aload 5
    //   470: getfield 242	bcyj:r	Ljava/lang/String;
    //   473: invokevirtual 245	java/lang/String:length	()I
    //   476: bipush 39
    //   478: if_icmpne +19 -> 497
    //   481: aload 5
    //   483: aload 5
    //   485: getfield 242	bcyj:r	Ljava/lang/String;
    //   488: iconst_0
    //   489: bipush 28
    //   491: invokevirtual 249	java/lang/String:substring	(II)Ljava/lang/String;
    //   494: putfield 242	bcyj:r	Ljava/lang/String;
    //   497: aload_1
    //   498: aload 5
    //   500: invokevirtual 254	bcxr:a	(Lbcyj;)V
    //   503: aload_1
    //   504: aload 6
    //   506: invokestatic 257	bcwz:a	(Lbcxr;Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   509: aload_0
    //   510: invokestatic 131	java/lang/System:currentTimeMillis	()J
    //   513: putfield 24	aiqp:jdField_b_of_type_Long	J
    //   516: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   519: ifeq +67 -> 586
    //   522: ldc 53
    //   524: iconst_2
    //   525: new 88	java/lang/StringBuilder
    //   528: dup
    //   529: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   532: ldc_w 259
    //   535: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   538: aload 7
    //   540: getfield 262	com/tencent/mobileqq/data/MessageForShortVideo:uniseq	J
    //   543: invokevirtual 100	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   546: ldc_w 264
    //   549: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   552: aload 7
    //   554: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   557: ldc_w 269
    //   560: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   563: aload_0
    //   564: getfield 24	aiqp:jdField_b_of_type_Long	J
    //   567: aload_0
    //   568: getfield 22	aiqp:jdField_a_of_type_Long	J
    //   571: lsub
    //   572: l2d
    //   573: ldc2_w 270
    //   576: ddiv
    //   577: invokevirtual 274	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   580: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   583: invokestatic 217	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   586: iconst_1
    //   587: invokestatic 121	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   590: areturn
    //   591: aload 8
    //   593: invokestatic 182	com/tencent/mobileqq/utils/FileUtils:fileExistsAndNotEmpty	(Ljava/lang/String;)Z
    //   596: ifne +24 -> 620
    //   599: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   602: ifeq +12 -> 614
    //   605: ldc 53
    //   607: iconst_2
    //   608: ldc_w 276
    //   611: invokestatic 59	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   614: bipush 10
    //   616: invokestatic 121	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   619: areturn
    //   620: new 278	java/io/File
    //   623: dup
    //   624: aload 8
    //   626: invokespecial 281	java/io/File:<init>	(Ljava/lang/String;)V
    //   629: astore 5
    //   631: aload 5
    //   633: invokevirtual 283	java/io/File:length	()J
    //   636: lstore_2
    //   637: lload_2
    //   638: lconst_0
    //   639: lcmp
    //   640: ifne +23 -> 663
    //   643: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   646: ifeq +12 -> 658
    //   649: ldc 53
    //   651: iconst_2
    //   652: ldc_w 285
    //   655: invokestatic 59	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   658: iconst_3
    //   659: invokestatic 121	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   662: areturn
    //   663: new 287	java/io/FileInputStream
    //   666: dup
    //   667: aload 5
    //   669: invokespecial 290	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   672: astore 5
    //   674: aload 5
    //   676: ifnull +196 -> 872
    //   679: aload 5
    //   681: lload_2
    //   682: invokestatic 296	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   685: invokestatic 302	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   688: astore 5
    //   690: aload 5
    //   692: astore_1
    //   693: aload 5
    //   695: invokestatic 193	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   698: ifeq +174 -> 872
    //   701: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   704: ifeq +30 -> 734
    //   707: ldc 53
    //   709: iconst_2
    //   710: new 88	java/lang/StringBuilder
    //   713: dup
    //   714: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   717: ldc_w 304
    //   720: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   723: aload 5
    //   725: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   728: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   731: invokestatic 59	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   734: iconst_3
    //   735: invokestatic 121	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   738: areturn
    //   739: astore 5
    //   741: aload 5
    //   743: invokevirtual 307	java/io/FileNotFoundException:printStackTrace	()V
    //   746: iconst_0
    //   747: ifeq +125 -> 872
    //   750: aconst_null
    //   751: lload_2
    //   752: invokestatic 296	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   755: invokestatic 302	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   758: astore 5
    //   760: aload 5
    //   762: astore_1
    //   763: aload 5
    //   765: invokestatic 193	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   768: ifeq +104 -> 872
    //   771: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   774: ifeq +30 -> 804
    //   777: ldc 53
    //   779: iconst_2
    //   780: new 88	java/lang/StringBuilder
    //   783: dup
    //   784: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   787: ldc_w 304
    //   790: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   793: aload 5
    //   795: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   798: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   801: invokestatic 59	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   804: iconst_3
    //   805: invokestatic 121	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   808: areturn
    //   809: astore_1
    //   810: iconst_0
    //   811: ifeq +59 -> 870
    //   814: aconst_null
    //   815: lload_2
    //   816: invokestatic 296	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   819: invokestatic 302	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   822: astore 5
    //   824: aload 5
    //   826: invokestatic 193	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   829: ifeq +41 -> 870
    //   832: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   835: ifeq +30 -> 865
    //   838: ldc 53
    //   840: iconst_2
    //   841: new 88	java/lang/StringBuilder
    //   844: dup
    //   845: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   848: ldc_w 304
    //   851: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   854: aload 5
    //   856: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   859: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   862: invokestatic 59	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   865: iconst_3
    //   866: invokestatic 121	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   869: areturn
    //   870: aload_1
    //   871: athrow
    //   872: aload_0
    //   873: aload_1
    //   874: putfield 194	aiqp:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   877: aload 7
    //   879: lload_2
    //   880: l2i
    //   881: putfield 310	com/tencent/mobileqq/data/MessageForShortVideo:videoFileSize	I
    //   884: aload 7
    //   886: getfield 313	com/tencent/mobileqq/data/MessageForShortVideo:mThumbFilePath	Ljava/lang/String;
    //   889: invokestatic 182	com/tencent/mobileqq/utils/FileUtils:fileExistsAndNotEmpty	(Ljava/lang/String;)Z
    //   892: ifeq -559 -> 333
    //   895: aload 7
    //   897: getfield 316	com/tencent/mobileqq/data/MessageForShortVideo:thumbMD5	Ljava/lang/String;
    //   900: ldc_w 318
    //   903: invokestatic 322	com/tencent/mobileqq/shortvideo/ShortVideoUtils:getShortVideoThumbPicPath	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   906: astore_1
    //   907: aload_1
    //   908: aload 7
    //   910: getfield 313	com/tencent/mobileqq/data/MessageForShortVideo:mThumbFilePath	Ljava/lang/String;
    //   913: invokevirtual 208	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   916: ifne -583 -> 333
    //   919: aload_1
    //   920: aload 7
    //   922: getfield 313	com/tencent/mobileqq/data/MessageForShortVideo:mThumbFilePath	Ljava/lang/String;
    //   925: invokestatic 212	com/tencent/mobileqq/utils/FileUtils:rename	(Ljava/lang/String;Ljava/lang/String;)Z
    //   928: ifne +8 -> 936
    //   931: iconst_3
    //   932: invokestatic 121	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   935: areturn
    //   936: aload 7
    //   938: aload_1
    //   939: putfield 313	com/tencent/mobileqq/data/MessageForShortVideo:mThumbFilePath	Ljava/lang/String;
    //   942: goto -609 -> 333
    //   945: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   948: ifeq -362 -> 586
    //   951: new 88	java/lang/StringBuilder
    //   954: dup
    //   955: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   958: ldc_w 324
    //   961: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   964: astore_1
    //   965: aload 6
    //   967: ifnull +36 -> 1003
    //   970: iconst_1
    //   971: istore 4
    //   973: ldc 53
    //   975: iconst_2
    //   976: aload_1
    //   977: iload 4
    //   979: invokevirtual 327	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   982: ldc_w 329
    //   985: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   988: invokestatic 224	com/tencent/mobileqq/activity/bless/BlessSelectMemberActivity:b	()Z
    //   991: invokevirtual 327	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   994: invokevirtual 112	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   997: invokestatic 217	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1000: goto -414 -> 586
    //   1003: iconst_0
    //   1004: istore 4
    //   1006: goto -33 -> 973
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1009	0	this	aiqp
    //   0	1009	1	paramVarArgs	Void[]
    //   36	844	2	l	long
    //   971	34	4	bool	boolean
    //   126	24	5	localInterruptedException	java.lang.InterruptedException
    //   446	278	5	localObject1	java.lang.Object
    //   739	3	5	localFileNotFoundException	java.io.FileNotFoundException
    //   758	97	5	str1	String
    //   118	6	6	localObject2	java.lang.Object
    //   293	673	6	localQQAppInterface	QQAppInterface
    //   214	723	7	localMessageForShortVideo	com.tencent.mobileqq.data.MessageForShortVideo
    //   190	435	8	str2	String
    // Exception table:
    //   from	to	target	type
    //   24	99	118	finally
    //   99	102	118	finally
    //   120	123	118	finally
    //   16	24	126	java/lang/InterruptedException
    //   123	126	126	java/lang/InterruptedException
    //   663	674	739	java/io/FileNotFoundException
    //   663	674	809	finally
    //   741	746	809	finally
  }
  
  protected void a(Integer paramInteger)
  {
    super.onPostExecute(paramInteger);
    QLog.i("BlessSelectMemberActivity", 1, "BlessPTVUploadTask: onPostExecute result=" + paramInteger + " ,entrance=" + this.jdField_a_of_type_Int);
    Properties localProperties = new Properties();
    localProperties.setProperty("bless_param_ptv_result", "" + paramInteger);
    localProperties.setProperty("bless_param_entrance_type", "" + this.jdField_a_of_type_Int);
    aipy.a("bless_event_ptv_result", localProperties);
    if (paramInteger.intValue() != 1)
    {
      ((BlessSelectMemberActivity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).c();
      switch (paramInteger.intValue())
      {
      }
    }
    for (;;)
    {
      BlessSelectMemberActivity.b(1);
      return;
      BlessSelectMemberActivity.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2131718874, true);
      continue;
      BlessSelectMemberActivity.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2131718869, true);
      continue;
      BlessSelectMemberActivity.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2131718840, true);
      continue;
      BlessSelectMemberActivity.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2131718866, true);
      continue;
      BlessSelectMemberActivity.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2131718870);
      continue;
      BlessSelectMemberActivity.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2131718867, true);
    }
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    BlessSelectMemberActivity.b(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aiqp
 * JD-Core Version:    0.7.0.1
 */
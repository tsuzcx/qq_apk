import android.media.AudioRecord;
import com.tencent.mobileqq.ptt.processor.IPttProcessor;
import com.tencent.mobileqq.ptt.processor.IPttProcessor.ProcessData;
import com.tencent.mobileqq.ptt.processor.IPttProcessorListener;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.QQRecorder;
import com.tencent.mobileqq.utils.QQRecorder.RecorderProcessorListener;
import com.tencent.mobileqq.utils.WechatNsWrapper;
import com.tencent.qphone.base.util.QLog;

public class akfq
  extends Thread
  implements IPttProcessorListener
{
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long = 0L;
  public String a;
  public volatile boolean a;
  public volatile boolean b = true;
  private boolean c;
  
  public akfq(QQRecorder paramQQRecorder)
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  /* Error */
  private void a(String paramString)
  {
    // Byte code:
    //   0: invokestatic 41	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +28 -> 31
    //   6: ldc 43
    //   8: iconst_2
    //   9: new 45	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   16: ldc 48
    //   18: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_0
    //   22: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   31: lconst_0
    //   32: lstore 20
    //   34: lconst_0
    //   35: lstore 18
    //   37: iconst_0
    //   38: istore 11
    //   40: iconst_0
    //   41: istore 12
    //   43: dconst_0
    //   44: dstore_2
    //   45: invokestatic 69	java/lang/System:currentTimeMillis	()J
    //   48: lstore 28
    //   50: lconst_0
    //   51: lstore 16
    //   53: lconst_0
    //   54: lstore 22
    //   56: iconst_0
    //   57: istore 15
    //   59: iconst_0
    //   60: istore 13
    //   62: iconst_0
    //   63: istore 10
    //   65: lconst_0
    //   66: lstore 24
    //   68: sipush 250
    //   71: istore 8
    //   73: bipush 237
    //   75: invokestatic 75	android/os/Process:setThreadPriority	(I)V
    //   78: aload_0
    //   79: getfield 18	akfq:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   82: invokestatic 80	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/content/Context;
    //   85: iconst_1
    //   86: invokestatic 85	com/tencent/mobileqq/utils/AudioUtil:a	(Landroid/content/Context;Z)Z
    //   89: pop
    //   90: aload_0
    //   91: getfield 18	akfq:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   94: invokestatic 88	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   97: ifnull +23 -> 120
    //   100: aload_0
    //   101: getfield 18	akfq:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   104: invokestatic 88	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   107: aload_1
    //   108: aload_0
    //   109: getfield 18	akfq:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   112: getfield 91	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam	Lcom/tencent/mobileqq/utils/QQRecorder$RecorderParam;
    //   115: invokeinterface 96 3 0
    //   120: aload_0
    //   121: getfield 18	akfq:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   124: invokestatic 99	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)I
    //   127: newarray byte
    //   129: astore 30
    //   131: aload_0
    //   132: getfield 18	akfq:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   135: invokestatic 101	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)V
    //   138: aload_0
    //   139: getfield 18	akfq:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   142: invokestatic 88	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   145: ifnull +38 -> 183
    //   148: aload_0
    //   149: getfield 18	akfq:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   152: invokestatic 88	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   155: invokeinterface 104 1 0
    //   160: istore 9
    //   162: iload 9
    //   164: istore 8
    //   166: iload 9
    //   168: ifgt +8 -> 176
    //   171: sipush 250
    //   174: istore 8
    //   176: iload 8
    //   178: invokestatic 107	com/tencent/mobileqq/utils/QQRecorder:a	(I)I
    //   181: istore 8
    //   183: invokestatic 110	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   186: ifeq +34 -> 220
    //   189: ldc 43
    //   191: iconst_4
    //   192: new 45	java/lang/StringBuilder
    //   195: dup
    //   196: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   199: ldc 112
    //   201: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: invokestatic 117	android/os/SystemClock:uptimeMillis	()J
    //   207: getstatic 120	com/tencent/mobileqq/transfile/PttInfoCollector:jdField_a_of_type_Long	J
    //   210: lsub
    //   211: invokevirtual 123	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   214: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   220: aload_0
    //   221: getfield 18	akfq:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   224: invokestatic 125	com/tencent/mobileqq/utils/QQRecorder:b	(Lcom/tencent/mobileqq/utils/QQRecorder;)V
    //   227: aload_0
    //   228: getfield 18	akfq:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   231: invokestatic 128	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/ptt/processor/PttCompositeProcessor;
    //   234: aload_0
    //   235: invokevirtual 133	com/tencent/mobileqq/ptt/processor/PttCompositeProcessor:a	(Lcom/tencent/mobileqq/ptt/processor/IPttProcessorListener;)V
    //   238: ldc2_w 134
    //   241: invokestatic 139	java/lang/Thread:sleep	(J)V
    //   244: aload_0
    //   245: getfield 18	akfq:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   248: getfield 91	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam	Lcom/tencent/mobileqq/utils/QQRecorder$RecorderParam;
    //   251: getfield 142	com/tencent/mobileqq/utils/QQRecorder$RecorderParam:jdField_a_of_type_Int	I
    //   254: invokestatic 144	com/tencent/mobileqq/utils/QQRecorder:b	(I)I
    //   257: sipush 1000
    //   260: idiv
    //   261: iload 8
    //   263: imul
    //   264: istore 14
    //   266: iconst_0
    //   267: istore 8
    //   269: iload 8
    //   271: iload 14
    //   273: if_icmpge +60 -> 333
    //   276: aload_0
    //   277: getfield 18	akfq:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   280: invokestatic 99	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)I
    //   283: istore 9
    //   285: aload_0
    //   286: getfield 18	akfq:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   289: invokestatic 99	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)I
    //   292: iload 14
    //   294: iload 8
    //   296: isub
    //   297: if_icmple +10 -> 307
    //   300: iload 14
    //   302: iload 8
    //   304: isub
    //   305: istore 9
    //   307: aload_0
    //   308: getfield 18	akfq:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   311: invokestatic 147	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/media/AudioRecord;
    //   314: aload 30
    //   316: iconst_0
    //   317: iload 9
    //   319: invokevirtual 153	android/media/AudioRecord:read	([BII)I
    //   322: pop
    //   323: iload 9
    //   325: iload 8
    //   327: iadd
    //   328: istore 8
    //   330: goto -61 -> 269
    //   333: invokestatic 41	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   336: ifeq +39 -> 375
    //   339: ldc 43
    //   341: iconst_2
    //   342: new 45	java/lang/StringBuilder
    //   345: dup
    //   346: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   349: ldc 155
    //   351: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: iload 8
    //   356: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   359: ldc 160
    //   361: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   364: iload 14
    //   366: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   369: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   372: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   375: aload_0
    //   376: getfield 18	akfq:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   379: invokestatic 88	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   382: ifnull +3767 -> 4149
    //   385: aload_0
    //   386: getfield 18	akfq:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   389: invokestatic 88	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   392: aload_0
    //   393: getfield 162	akfq:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   396: aload_0
    //   397: getfield 18	akfq:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   400: getfield 91	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam	Lcom/tencent/mobileqq/utils/QQRecorder$RecorderParam;
    //   403: invokeinterface 165 3 0
    //   408: istore 14
    //   410: invokestatic 110	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   413: ifeq +34 -> 447
    //   416: ldc 43
    //   418: iconst_4
    //   419: new 45	java/lang/StringBuilder
    //   422: dup
    //   423: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   426: ldc 167
    //   428: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   431: invokestatic 117	android/os/SystemClock:uptimeMillis	()J
    //   434: getstatic 120	com/tencent/mobileqq/transfile/PttInfoCollector:jdField_a_of_type_Long	J
    //   437: lsub
    //   438: invokevirtual 123	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   441: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   444: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   447: invokestatic 69	java/lang/System:currentTimeMillis	()J
    //   450: lstore 26
    //   452: iconst_0
    //   453: istore 13
    //   455: iconst_0
    //   456: istore 8
    //   458: lconst_0
    //   459: lstore 20
    //   461: iconst_0
    //   462: istore 9
    //   464: lconst_0
    //   465: lstore 18
    //   467: lconst_0
    //   468: lstore 16
    //   470: dconst_0
    //   471: dstore_2
    //   472: aload_0
    //   473: getfield 23	akfq:jdField_a_of_type_Boolean	Z
    //   476: ifeq +1305 -> 1781
    //   479: aload_0
    //   480: getfield 169	akfq:c	Z
    //   483: ifne +1298 -> 1781
    //   486: iload 9
    //   488: istore 11
    //   490: invokestatic 69	java/lang/System:currentTimeMillis	()J
    //   493: lload 26
    //   495: lsub
    //   496: ldc2_w 170
    //   499: lcmp
    //   500: ifle +788 -> 1288
    //   503: iload 9
    //   505: istore 11
    //   507: iload 9
    //   509: ifne +779 -> 1288
    //   512: iconst_1
    //   513: istore 11
    //   515: lload 20
    //   517: lconst_0
    //   518: lcmp
    //   519: ifeq +8 -> 527
    //   522: iload 10
    //   524: ifne +764 -> 1288
    //   527: invokestatic 41	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   530: ifeq +39 -> 569
    //   533: ldc 43
    //   535: iconst_2
    //   536: new 45	java/lang/StringBuilder
    //   539: dup
    //   540: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   543: ldc 173
    //   545: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   548: lload 20
    //   550: invokevirtual 123	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   553: ldc 175
    //   555: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   558: iload 10
    //   560: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   563: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   566: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   569: new 177	com/tencent/mobileqq/utils/QQRecorder$RecordNoPermissonException
    //   572: dup
    //   573: ldc 179
    //   575: invokespecial 181	com/tencent/mobileqq/utils/QQRecorder$RecordNoPermissonException:<init>	(Ljava/lang/String;)V
    //   578: athrow
    //   579: astore 30
    //   581: lload 20
    //   583: lstore 26
    //   585: lload 18
    //   587: lstore 20
    //   589: lload 26
    //   591: lstore 18
    //   593: iload 8
    //   595: istore 9
    //   597: invokestatic 41	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   600: ifeq +13 -> 613
    //   603: ldc 43
    //   605: iconst_2
    //   606: ldc 183
    //   608: aload 30
    //   610: invokestatic 186	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   613: aload_0
    //   614: getfield 18	akfq:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   617: invokestatic 88	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   620: ifnull +71 -> 691
    //   623: aload_0
    //   624: getfield 18	akfq:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   627: getfield 189	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_AndroidMediaAudioManager	Landroid/media/AudioManager;
    //   630: ifnull +25 -> 655
    //   633: aload_0
    //   634: getfield 18	akfq:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   637: invokestatic 191	com/tencent/mobileqq/utils/QQRecorder:c	(Lcom/tencent/mobileqq/utils/QQRecorder;)I
    //   640: iconst_m1
    //   641: if_icmpeq +14 -> 655
    //   644: aload_0
    //   645: getfield 18	akfq:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   648: getfield 189	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_AndroidMediaAudioManager	Landroid/media/AudioManager;
    //   651: iconst_0
    //   652: invokevirtual 196	android/media/AudioManager:setMode	(I)V
    //   655: aload 30
    //   657: instanceof 198
    //   660: ifne +11 -> 671
    //   663: aload 30
    //   665: instanceof 200
    //   668: ifeq +2118 -> 2786
    //   671: aload_0
    //   672: getfield 18	akfq:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   675: invokestatic 88	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   678: aload_1
    //   679: aload_0
    //   680: getfield 18	akfq:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   683: getfield 91	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam	Lcom/tencent/mobileqq/utils/QQRecorder$RecorderParam;
    //   686: invokeinterface 202 3 0
    //   691: aload_0
    //   692: getfield 18	akfq:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   695: aload 30
    //   697: invokevirtual 205	com/tencent/mobileqq/utils/QQRecorder:a	(Ljava/lang/Throwable;)V
    //   700: aload_0
    //   701: getfield 18	akfq:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   704: invokestatic 147	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/media/AudioRecord;
    //   707: ifnull +27 -> 734
    //   710: aload_0
    //   711: getfield 18	akfq:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   714: invokestatic 147	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/media/AudioRecord;
    //   717: invokevirtual 208	android/media/AudioRecord:getState	()I
    //   720: iconst_1
    //   721: if_icmpne +13 -> 734
    //   724: aload_0
    //   725: getfield 18	akfq:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   728: invokestatic 147	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/media/AudioRecord;
    //   731: invokevirtual 211	android/media/AudioRecord:stop	()V
    //   734: aload_0
    //   735: getfield 18	akfq:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   738: invokestatic 213	com/tencent/mobileqq/utils/QQRecorder:c	(Lcom/tencent/mobileqq/utils/QQRecorder;)V
    //   741: invokestatic 41	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   744: ifeq +84 -> 828
    //   747: ldc 43
    //   749: iconst_2
    //   750: new 45	java/lang/StringBuilder
    //   753: dup
    //   754: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   757: ldc 215
    //   759: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   762: aload_0
    //   763: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   766: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   769: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   772: ldc 43
    //   774: iconst_2
    //   775: new 45	java/lang/StringBuilder
    //   778: dup
    //   779: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   782: ldc 217
    //   784: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   787: lload 20
    //   789: invokevirtual 123	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   792: ldc 219
    //   794: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   797: lload 18
    //   799: invokevirtual 123	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   802: ldc 221
    //   804: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   807: lload 16
    //   809: invokevirtual 123	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   812: ldc 223
    //   814: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   817: iload 9
    //   819: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   822: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   825: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   828: aload_0
    //   829: getfield 18	akfq:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   832: invokestatic 80	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/content/Context;
    //   835: iconst_0
    //   836: invokestatic 85	com/tencent/mobileqq/utils/AudioUtil:a	(Landroid/content/Context;Z)Z
    //   839: pop
    //   840: lload 16
    //   842: ldc2_w 224
    //   845: lcmp
    //   846: iflt +11 -> 857
    //   849: dload_2
    //   850: ldc2_w 226
    //   853: dcmpg
    //   854: ifge +3 -> 857
    //   857: new 229	java/util/HashMap
    //   860: dup
    //   861: invokespecial 230	java/util/HashMap:<init>	()V
    //   864: astore_1
    //   865: aload_1
    //   866: ldc 232
    //   868: new 45	java/lang/StringBuilder
    //   871: dup
    //   872: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   875: getstatic 237	android/os/Build$VERSION:SDK_INT	I
    //   878: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   881: ldc 239
    //   883: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   886: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   889: invokevirtual 243	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   892: pop
    //   893: aload_1
    //   894: ldc 245
    //   896: new 45	java/lang/StringBuilder
    //   899: dup
    //   900: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   903: getstatic 250	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   906: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   909: ldc 252
    //   911: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   914: getstatic 255	android/os/Build:MODEL	Ljava/lang/String;
    //   917: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   920: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   923: invokevirtual 243	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   926: pop
    //   927: aload_1
    //   928: ldc_w 257
    //   931: new 45	java/lang/StringBuilder
    //   934: dup
    //   935: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   938: lload 18
    //   940: invokevirtual 123	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   943: ldc 239
    //   945: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   948: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   951: invokevirtual 243	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   954: pop
    //   955: aload_1
    //   956: ldc_w 259
    //   959: new 45	java/lang/StringBuilder
    //   962: dup
    //   963: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   966: dload_2
    //   967: invokevirtual 262	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   970: ldc 239
    //   972: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   975: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   978: invokevirtual 243	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   981: pop
    //   982: aload_1
    //   983: ldc_w 264
    //   986: new 45	java/lang/StringBuilder
    //   989: dup
    //   990: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   993: invokestatic 69	java/lang/System:currentTimeMillis	()J
    //   996: lload 28
    //   998: lsub
    //   999: invokevirtual 123	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1002: ldc 239
    //   1004: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1007: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1010: invokevirtual 243	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1013: pop
    //   1014: aload_1
    //   1015: ldc_w 266
    //   1018: new 45	java/lang/StringBuilder
    //   1021: dup
    //   1022: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   1025: iload 10
    //   1027: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1030: ldc 239
    //   1032: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1035: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1038: invokevirtual 243	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1041: pop
    //   1042: aload_1
    //   1043: ldc_w 268
    //   1046: new 45	java/lang/StringBuilder
    //   1049: dup
    //   1050: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   1053: aload_0
    //   1054: getfield 27	akfq:jdField_a_of_type_Int	I
    //   1057: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1060: ldc 239
    //   1062: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1065: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1068: invokevirtual 243	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1071: pop
    //   1072: lload 22
    //   1074: lconst_0
    //   1075: lcmp
    //   1076: ifne +2699 -> 3775
    //   1079: ldc2_w 269
    //   1082: lstore 20
    //   1084: goto +3071 -> 4155
    //   1087: lload 20
    //   1089: l2i
    //   1090: istore 8
    //   1092: aload_1
    //   1093: ldc_w 272
    //   1096: new 45	java/lang/StringBuilder
    //   1099: dup
    //   1100: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   1103: iload 9
    //   1105: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1108: ldc 239
    //   1110: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1113: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1116: invokevirtual 243	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1119: pop
    //   1120: aload_1
    //   1121: ldc_w 274
    //   1124: new 45	java/lang/StringBuilder
    //   1127: dup
    //   1128: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   1131: iload 8
    //   1133: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1136: ldc 239
    //   1138: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1141: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1144: invokevirtual 243	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   1147: pop
    //   1148: ldc_w 276
    //   1151: iconst_1
    //   1152: aload_1
    //   1153: invokestatic 279	com/tencent/mobileqq/utils/QQRecorder:a	(Ljava/lang/String;ZLjava/util/HashMap;)V
    //   1156: invokestatic 41	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1159: ifeq +128 -> 1287
    //   1162: new 45	java/lang/StringBuilder
    //   1165: dup
    //   1166: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   1169: astore_1
    //   1170: aload_1
    //   1171: ldc_w 281
    //   1174: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1177: iload 10
    //   1179: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1182: pop
    //   1183: aload_1
    //   1184: ldc_w 283
    //   1187: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1190: iload 9
    //   1192: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1195: pop
    //   1196: aload_1
    //   1197: ldc_w 285
    //   1200: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1203: iload 8
    //   1205: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1208: pop
    //   1209: aload_1
    //   1210: ldc_w 287
    //   1213: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1216: iload 8
    //   1218: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1221: pop
    //   1222: aload_1
    //   1223: ldc_w 289
    //   1226: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1229: lload 18
    //   1231: invokevirtual 123	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1234: pop
    //   1235: aload_1
    //   1236: ldc_w 291
    //   1239: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1242: lload 16
    //   1244: invokevirtual 123	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1247: pop
    //   1248: aload_1
    //   1249: ldc_w 293
    //   1252: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1255: dload_2
    //   1256: invokevirtual 262	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   1259: pop
    //   1260: aload_1
    //   1261: ldc_w 295
    //   1264: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1267: invokestatic 69	java/lang/System:currentTimeMillis	()J
    //   1270: lload 28
    //   1272: lsub
    //   1273: invokevirtual 123	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1276: pop
    //   1277: ldc 43
    //   1279: iconst_2
    //   1280: aload_1
    //   1281: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1284: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1287: return
    //   1288: iload 13
    //   1290: istore 12
    //   1292: invokestatic 69	java/lang/System:currentTimeMillis	()J
    //   1295: lload 26
    //   1297: lsub
    //   1298: ldc2_w 170
    //   1301: lcmp
    //   1302: ifle +99 -> 1401
    //   1305: iload 13
    //   1307: istore 12
    //   1309: iload 13
    //   1311: ifne +90 -> 1401
    //   1314: invokestatic 41	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1317: ifeq +32 -> 1349
    //   1320: ldc 43
    //   1322: iconst_2
    //   1323: new 45	java/lang/StringBuilder
    //   1326: dup
    //   1327: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   1330: ldc_w 297
    //   1333: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1336: aload_0
    //   1337: getfield 27	akfq:jdField_a_of_type_Int	I
    //   1340: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1343: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1346: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1349: aload_0
    //   1350: getfield 27	akfq:jdField_a_of_type_Int	I
    //   1353: ifle +102 -> 1455
    //   1356: aload_0
    //   1357: getfield 27	akfq:jdField_a_of_type_Int	I
    //   1360: sipush 500
    //   1363: if_icmpge +92 -> 1455
    //   1366: iconst_1
    //   1367: istore 9
    //   1369: iload 9
    //   1371: istore 12
    //   1373: aload_0
    //   1374: getfield 18	akfq:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1377: invokestatic 88	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   1380: ifnull +21 -> 1401
    //   1383: aload_0
    //   1384: getfield 18	akfq:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1387: invokestatic 88	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   1390: iload 9
    //   1392: invokeinterface 299 2 0
    //   1397: iload 9
    //   1399: istore 12
    //   1401: lload 18
    //   1403: lconst_1
    //   1404: ladd
    //   1405: lstore 18
    //   1407: aload_0
    //   1408: getfield 18	akfq:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1411: invokestatic 147	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/media/AudioRecord;
    //   1414: aload 30
    //   1416: iconst_0
    //   1417: aload_0
    //   1418: getfield 18	akfq:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1421: invokestatic 99	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)I
    //   1424: invokevirtual 153	android/media/AudioRecord:read	([BII)I
    //   1427: istore 13
    //   1429: iload 13
    //   1431: ifgt +30 -> 1461
    //   1434: ldc2_w 300
    //   1437: invokestatic 139	java/lang/Thread:sleep	(J)V
    //   1440: iload 11
    //   1442: istore 9
    //   1444: iload 13
    //   1446: istore 8
    //   1448: iload 12
    //   1450: istore 13
    //   1452: goto -980 -> 472
    //   1455: iconst_2
    //   1456: istore 9
    //   1458: goto -89 -> 1369
    //   1461: lconst_1
    //   1462: lload 22
    //   1464: ladd
    //   1465: lstore 22
    //   1467: lload 20
    //   1469: iload 13
    //   1471: i2l
    //   1472: ladd
    //   1473: lstore 20
    //   1475: aload_0
    //   1476: getfield 18	akfq:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1479: invokestatic 80	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/content/Context;
    //   1482: aload 30
    //   1484: iload 13
    //   1486: fconst_1
    //   1487: invokestatic 306	com/tencent/mobileqq/utils/AudioHelper:a	(Landroid/content/Context;[BIF)J
    //   1490: l2i
    //   1491: istore 15
    //   1493: iload 10
    //   1495: iload 15
    //   1497: invokestatic 312	java/lang/Math:max	(II)I
    //   1500: istore 9
    //   1502: lload 24
    //   1504: iload 15
    //   1506: i2l
    //   1507: ladd
    //   1508: lstore 24
    //   1510: dload_2
    //   1511: dstore 4
    //   1513: dload_2
    //   1514: dstore 6
    //   1516: aload_0
    //   1517: getfield 18	akfq:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1520: invokestatic 128	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/ptt/processor/PttCompositeProcessor;
    //   1523: aload 30
    //   1525: iconst_0
    //   1526: iload 13
    //   1528: invokevirtual 315	com/tencent/mobileqq/ptt/processor/PttCompositeProcessor:a	([BII)Lcom/tencent/mobileqq/ptt/processor/IPttProcessor$ProcessData;
    //   1531: astore 31
    //   1533: dload_2
    //   1534: dstore 4
    //   1536: dload_2
    //   1537: dstore 6
    //   1539: invokestatic 317	com/tencent/mobileqq/transfile/PttInfoCollector:b	()V
    //   1542: dload_2
    //   1543: dstore 4
    //   1545: dload_2
    //   1546: dstore 6
    //   1548: dload_2
    //   1549: iload 13
    //   1551: i2l
    //   1552: aload_0
    //   1553: getfield 18	akfq:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1556: getfield 91	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam	Lcom/tencent/mobileqq/utils/QQRecorder$RecorderParam;
    //   1559: getfield 142	com/tencent/mobileqq/utils/QQRecorder$RecorderParam:jdField_a_of_type_Int	I
    //   1562: invokestatic 320	com/tencent/mobileqq/utils/QQRecorder:a	(JI)D
    //   1565: dadd
    //   1566: dstore_2
    //   1567: dload_2
    //   1568: dstore 4
    //   1570: dload_2
    //   1571: dstore 6
    //   1573: aload_0
    //   1574: getfield 18	akfq:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1577: invokestatic 88	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   1580: ifnull +52 -> 1632
    //   1583: aload 31
    //   1585: ifnull +47 -> 1632
    //   1588: dload_2
    //   1589: dstore 4
    //   1591: dload_2
    //   1592: dstore 6
    //   1594: aload_0
    //   1595: getfield 18	akfq:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1598: invokestatic 88	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   1601: aload_1
    //   1602: aload 31
    //   1604: getfield 325	com/tencent/mobileqq/ptt/processor/IPttProcessor$ProcessData:jdField_a_of_type_ArrayOfByte	[B
    //   1607: aload 31
    //   1609: getfield 326	com/tencent/mobileqq/ptt/processor/IPttProcessor$ProcessData:jdField_a_of_type_Int	I
    //   1612: aload_0
    //   1613: getfield 18	akfq:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1616: invokestatic 328	com/tencent/mobileqq/utils/QQRecorder:b	(Lcom/tencent/mobileqq/utils/QQRecorder;)I
    //   1619: dload_2
    //   1620: aload_0
    //   1621: getfield 18	akfq:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1624: getfield 91	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam	Lcom/tencent/mobileqq/utils/QQRecorder$RecorderParam;
    //   1627: invokeinterface 331 8 0
    //   1632: aload 31
    //   1634: ifnull +2512 -> 4146
    //   1637: dload_2
    //   1638: dstore 4
    //   1640: dload_2
    //   1641: dstore 6
    //   1643: aload 31
    //   1645: getfield 326	com/tencent/mobileqq/ptt/processor/IPttProcessor$ProcessData:jdField_a_of_type_Int	I
    //   1648: istore 10
    //   1650: iload 10
    //   1652: i2l
    //   1653: lload 16
    //   1655: ladd
    //   1656: lstore 16
    //   1658: iload 12
    //   1660: istore 13
    //   1662: iload 12
    //   1664: iconst_1
    //   1665: if_icmpne +86 -> 1751
    //   1668: iload 12
    //   1670: istore 13
    //   1672: aload_0
    //   1673: getfield 27	akfq:jdField_a_of_type_Int	I
    //   1676: sipush 500
    //   1679: if_icmple +72 -> 1751
    //   1682: iconst_2
    //   1683: istore 10
    //   1685: aload_0
    //   1686: getfield 18	akfq:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1689: invokestatic 88	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   1692: ifnull +16 -> 1708
    //   1695: aload_0
    //   1696: getfield 18	akfq:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1699: invokestatic 88	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   1702: iconst_2
    //   1703: invokeinterface 299 2 0
    //   1708: iload 10
    //   1710: istore 13
    //   1712: invokestatic 41	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1715: ifeq +36 -> 1751
    //   1718: ldc 43
    //   1720: iconst_2
    //   1721: new 45	java/lang/StringBuilder
    //   1724: dup
    //   1725: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   1728: ldc_w 333
    //   1731: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1734: aload_0
    //   1735: getfield 27	akfq:jdField_a_of_type_Int	I
    //   1738: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1741: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1744: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1747: iload 10
    //   1749: istore 13
    //   1751: iload 14
    //   1753: iconst_m1
    //   1754: if_icmpeq +16 -> 1770
    //   1757: dload_2
    //   1758: iload 14
    //   1760: i2d
    //   1761: dcmpl
    //   1762: iflt +8 -> 1770
    //   1765: aload_0
    //   1766: iconst_1
    //   1767: putfield 169	akfq:c	Z
    //   1770: iload 9
    //   1772: istore 10
    //   1774: iload 11
    //   1776: istore 9
    //   1778: goto -1306 -> 472
    //   1781: aload_0
    //   1782: getfield 18	akfq:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1785: invokestatic 88	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   1788: ifnull +56 -> 1844
    //   1791: aload_0
    //   1792: getfield 18	akfq:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1795: invokestatic 88	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   1798: aload_1
    //   1799: aload_0
    //   1800: getfield 18	akfq:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1803: getfield 91	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam	Lcom/tencent/mobileqq/utils/QQRecorder$RecorderParam;
    //   1806: dload_2
    //   1807: invokeinterface 336 5 0
    //   1812: aload_0
    //   1813: getfield 18	akfq:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1816: getfield 189	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_AndroidMediaAudioManager	Landroid/media/AudioManager;
    //   1819: ifnull +25 -> 1844
    //   1822: aload_0
    //   1823: getfield 18	akfq:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1826: invokestatic 191	com/tencent/mobileqq/utils/QQRecorder:c	(Lcom/tencent/mobileqq/utils/QQRecorder;)I
    //   1829: iconst_m1
    //   1830: if_icmpeq +14 -> 1844
    //   1833: aload_0
    //   1834: getfield 18	akfq:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1837: getfield 189	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_AndroidMediaAudioManager	Landroid/media/AudioManager;
    //   1840: iconst_0
    //   1841: invokevirtual 196	android/media/AudioManager:setMode	(I)V
    //   1844: aload_0
    //   1845: getfield 18	akfq:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1848: invokestatic 147	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/media/AudioRecord;
    //   1851: ifnull +27 -> 1878
    //   1854: aload_0
    //   1855: getfield 18	akfq:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1858: invokestatic 147	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/media/AudioRecord;
    //   1861: invokevirtual 208	android/media/AudioRecord:getState	()I
    //   1864: iconst_1
    //   1865: if_icmpne +13 -> 1878
    //   1868: aload_0
    //   1869: getfield 18	akfq:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1872: invokestatic 147	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/media/AudioRecord;
    //   1875: invokevirtual 211	android/media/AudioRecord:stop	()V
    //   1878: aload_0
    //   1879: getfield 18	akfq:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1882: invokestatic 213	com/tencent/mobileqq/utils/QQRecorder:c	(Lcom/tencent/mobileqq/utils/QQRecorder;)V
    //   1885: invokestatic 41	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1888: ifeq +84 -> 1972
    //   1891: ldc 43
    //   1893: iconst_2
    //   1894: new 45	java/lang/StringBuilder
    //   1897: dup
    //   1898: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   1901: ldc 215
    //   1903: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1906: aload_0
    //   1907: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1910: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1913: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1916: ldc 43
    //   1918: iconst_2
    //   1919: new 45	java/lang/StringBuilder
    //   1922: dup
    //   1923: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   1926: ldc 217
    //   1928: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1931: lload 18
    //   1933: invokevirtual 123	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1936: ldc 219
    //   1938: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1941: lload 20
    //   1943: invokevirtual 123	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1946: ldc 221
    //   1948: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1951: lload 16
    //   1953: invokevirtual 123	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1956: ldc 223
    //   1958: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1961: iload 8
    //   1963: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1966: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1969: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1972: aload_0
    //   1973: getfield 18	akfq:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   1976: invokestatic 80	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/content/Context;
    //   1979: iconst_0
    //   1980: invokestatic 85	com/tencent/mobileqq/utils/AudioUtil:a	(Landroid/content/Context;Z)Z
    //   1983: pop
    //   1984: lload 16
    //   1986: ldc2_w 224
    //   1989: lcmp
    //   1990: iflt +11 -> 2001
    //   1993: dload_2
    //   1994: ldc2_w 226
    //   1997: dcmpg
    //   1998: ifge +289 -> 2287
    //   2001: invokestatic 69	java/lang/System:currentTimeMillis	()J
    //   2004: lload 28
    //   2006: lsub
    //   2007: ldc2_w 170
    //   2010: lcmp
    //   2011: ifle +276 -> 2287
    //   2014: new 229	java/util/HashMap
    //   2017: dup
    //   2018: invokespecial 230	java/util/HashMap:<init>	()V
    //   2021: astore_1
    //   2022: aload_1
    //   2023: ldc_w 338
    //   2026: ldc_w 340
    //   2029: invokevirtual 243	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2032: pop
    //   2033: aload_1
    //   2034: ldc 232
    //   2036: new 45	java/lang/StringBuilder
    //   2039: dup
    //   2040: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   2043: getstatic 237	android/os/Build$VERSION:SDK_INT	I
    //   2046: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2049: ldc 239
    //   2051: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2054: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2057: invokevirtual 243	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2060: pop
    //   2061: aload_1
    //   2062: ldc 245
    //   2064: new 45	java/lang/StringBuilder
    //   2067: dup
    //   2068: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   2071: getstatic 250	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   2074: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2077: ldc 252
    //   2079: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2082: getstatic 255	android/os/Build:MODEL	Ljava/lang/String;
    //   2085: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2088: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2091: invokevirtual 243	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2094: pop
    //   2095: aload_1
    //   2096: ldc_w 257
    //   2099: new 45	java/lang/StringBuilder
    //   2102: dup
    //   2103: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   2106: lload 20
    //   2108: invokevirtual 123	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2111: ldc 239
    //   2113: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2116: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2119: invokevirtual 243	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2122: pop
    //   2123: aload_1
    //   2124: ldc_w 266
    //   2127: new 45	java/lang/StringBuilder
    //   2130: dup
    //   2131: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   2134: iload 10
    //   2136: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2139: ldc 239
    //   2141: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2144: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2147: invokevirtual 243	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2150: pop
    //   2151: aload_1
    //   2152: ldc_w 342
    //   2155: new 45	java/lang/StringBuilder
    //   2158: dup
    //   2159: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   2162: dload_2
    //   2163: invokevirtual 262	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   2166: ldc 239
    //   2168: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2171: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2174: invokevirtual 243	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2177: pop
    //   2178: aload_1
    //   2179: ldc_w 264
    //   2182: new 45	java/lang/StringBuilder
    //   2185: dup
    //   2186: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   2189: invokestatic 69	java/lang/System:currentTimeMillis	()J
    //   2192: lload 28
    //   2194: lsub
    //   2195: invokevirtual 123	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2198: ldc 239
    //   2200: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2203: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2206: invokevirtual 243	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2209: pop
    //   2210: ldc_w 344
    //   2213: iconst_0
    //   2214: aload_1
    //   2215: invokestatic 279	com/tencent/mobileqq/utils/QQRecorder:a	(Ljava/lang/String;ZLjava/util/HashMap;)V
    //   2218: invokestatic 41	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2221: ifeq +66 -> 2287
    //   2224: ldc 43
    //   2226: iconst_2
    //   2227: new 45	java/lang/StringBuilder
    //   2230: dup
    //   2231: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   2234: ldc_w 346
    //   2237: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2240: lload 20
    //   2242: invokevirtual 123	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2245: ldc_w 348
    //   2248: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2251: lload 16
    //   2253: invokevirtual 123	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2256: ldc_w 350
    //   2259: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2262: dload_2
    //   2263: invokevirtual 262	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   2266: ldc_w 352
    //   2269: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2272: invokestatic 69	java/lang/System:currentTimeMillis	()J
    //   2275: lload 28
    //   2277: lsub
    //   2278: invokevirtual 123	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2281: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2284: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2287: new 229	java/util/HashMap
    //   2290: dup
    //   2291: invokespecial 230	java/util/HashMap:<init>	()V
    //   2294: astore_1
    //   2295: aload_1
    //   2296: ldc 232
    //   2298: new 45	java/lang/StringBuilder
    //   2301: dup
    //   2302: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   2305: getstatic 237	android/os/Build$VERSION:SDK_INT	I
    //   2308: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2311: ldc 239
    //   2313: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2316: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2319: invokevirtual 243	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2322: pop
    //   2323: aload_1
    //   2324: ldc 245
    //   2326: new 45	java/lang/StringBuilder
    //   2329: dup
    //   2330: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   2333: getstatic 250	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   2336: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2339: ldc 252
    //   2341: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2344: getstatic 255	android/os/Build:MODEL	Ljava/lang/String;
    //   2347: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2350: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2353: invokevirtual 243	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2356: pop
    //   2357: aload_1
    //   2358: ldc_w 257
    //   2361: new 45	java/lang/StringBuilder
    //   2364: dup
    //   2365: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   2368: lload 20
    //   2370: invokevirtual 123	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2373: ldc 239
    //   2375: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2378: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2381: invokevirtual 243	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2384: pop
    //   2385: aload_1
    //   2386: ldc_w 259
    //   2389: new 45	java/lang/StringBuilder
    //   2392: dup
    //   2393: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   2396: dload_2
    //   2397: invokevirtual 262	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   2400: ldc 239
    //   2402: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2405: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2408: invokevirtual 243	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2411: pop
    //   2412: aload_1
    //   2413: ldc_w 264
    //   2416: new 45	java/lang/StringBuilder
    //   2419: dup
    //   2420: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   2423: invokestatic 69	java/lang/System:currentTimeMillis	()J
    //   2426: lload 28
    //   2428: lsub
    //   2429: invokevirtual 123	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2432: ldc 239
    //   2434: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2437: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2440: invokevirtual 243	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2443: pop
    //   2444: aload_1
    //   2445: ldc_w 266
    //   2448: new 45	java/lang/StringBuilder
    //   2451: dup
    //   2452: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   2455: iload 10
    //   2457: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2460: ldc 239
    //   2462: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2465: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2468: invokevirtual 243	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2471: pop
    //   2472: aload_1
    //   2473: ldc_w 268
    //   2476: new 45	java/lang/StringBuilder
    //   2479: dup
    //   2480: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   2483: aload_0
    //   2484: getfield 27	akfq:jdField_a_of_type_Int	I
    //   2487: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2490: ldc 239
    //   2492: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2495: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2498: invokevirtual 243	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2501: pop
    //   2502: lload 22
    //   2504: lconst_0
    //   2505: lcmp
    //   2506: ifne +258 -> 2764
    //   2509: ldc2_w 269
    //   2512: lstore 18
    //   2514: goto +1661 -> 4175
    //   2517: lload 18
    //   2519: l2i
    //   2520: istore 8
    //   2522: aload_1
    //   2523: ldc_w 272
    //   2526: new 45	java/lang/StringBuilder
    //   2529: dup
    //   2530: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   2533: iload 9
    //   2535: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2538: ldc 239
    //   2540: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2543: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2546: invokevirtual 243	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2549: pop
    //   2550: aload_1
    //   2551: ldc_w 274
    //   2554: new 45	java/lang/StringBuilder
    //   2557: dup
    //   2558: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   2561: iload 8
    //   2563: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2566: ldc 239
    //   2568: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2571: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2574: invokevirtual 243	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2577: pop
    //   2578: ldc_w 276
    //   2581: iconst_1
    //   2582: aload_1
    //   2583: invokestatic 279	com/tencent/mobileqq/utils/QQRecorder:a	(Ljava/lang/String;ZLjava/util/HashMap;)V
    //   2586: invokestatic 41	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2589: ifeq -1302 -> 1287
    //   2592: new 45	java/lang/StringBuilder
    //   2595: dup
    //   2596: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   2599: astore_1
    //   2600: aload_1
    //   2601: ldc_w 281
    //   2604: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2607: iload 10
    //   2609: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2612: pop
    //   2613: aload_1
    //   2614: ldc_w 283
    //   2617: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2620: iload 9
    //   2622: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2625: pop
    //   2626: aload_1
    //   2627: ldc_w 285
    //   2630: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2633: iload 8
    //   2635: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2638: pop
    //   2639: aload_1
    //   2640: ldc_w 287
    //   2643: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2646: iload 8
    //   2648: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2651: pop
    //   2652: aload_1
    //   2653: ldc_w 289
    //   2656: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2659: lload 20
    //   2661: invokevirtual 123	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2664: pop
    //   2665: aload_1
    //   2666: ldc_w 291
    //   2669: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2672: lload 16
    //   2674: invokevirtual 123	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2677: pop
    //   2678: aload_1
    //   2679: ldc_w 293
    //   2682: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2685: dload_2
    //   2686: invokevirtual 262	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   2689: pop
    //   2690: aload_1
    //   2691: ldc_w 295
    //   2694: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2697: invokestatic 69	java/lang/System:currentTimeMillis	()J
    //   2700: lload 28
    //   2702: lsub
    //   2703: invokevirtual 123	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2706: pop
    //   2707: ldc 43
    //   2709: iconst_2
    //   2710: aload_1
    //   2711: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2714: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2717: return
    //   2718: astore_1
    //   2719: invokestatic 41	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2722: ifeq -1435 -> 1287
    //   2725: ldc 43
    //   2727: iconst_2
    //   2728: ldc_w 354
    //   2731: aload_1
    //   2732: invokestatic 186	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2735: return
    //   2736: astore_1
    //   2737: aload_1
    //   2738: invokevirtual 357	java/lang/Throwable:printStackTrace	()V
    //   2741: goto -856 -> 1885
    //   2744: astore_1
    //   2745: invokestatic 41	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2748: ifeq -461 -> 2287
    //   2751: ldc 43
    //   2753: iconst_2
    //   2754: ldc_w 359
    //   2757: aload_1
    //   2758: invokestatic 186	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2761: goto -474 -> 2287
    //   2764: lload 24
    //   2766: lload 22
    //   2768: ldiv
    //   2769: lstore 18
    //   2771: goto +1404 -> 4175
    //   2774: aload_0
    //   2775: getfield 29	akfq:jdField_a_of_type_Long	J
    //   2778: lload 22
    //   2780: ldiv
    //   2781: lstore 18
    //   2783: goto -266 -> 2517
    //   2786: aload 30
    //   2788: instanceof 177
    //   2791: ifeq +948 -> 3739
    //   2794: aload_0
    //   2795: getfield 18	akfq:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   2798: invokestatic 88	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   2801: aload_1
    //   2802: aload_0
    //   2803: getfield 18	akfq:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   2806: getfield 91	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam	Lcom/tencent/mobileqq/utils/QQRecorder$RecorderParam;
    //   2809: invokeinterface 361 3 0
    //   2814: goto -2123 -> 691
    //   2817: astore_1
    //   2818: iconst_1
    //   2819: istore 8
    //   2821: lload 20
    //   2823: lstore 26
    //   2825: lload 18
    //   2827: lstore 20
    //   2829: aload_0
    //   2830: getfield 18	akfq:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   2833: invokestatic 147	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/media/AudioRecord;
    //   2836: ifnull +27 -> 2863
    //   2839: aload_0
    //   2840: getfield 18	akfq:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   2843: invokestatic 147	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/media/AudioRecord;
    //   2846: invokevirtual 208	android/media/AudioRecord:getState	()I
    //   2849: iconst_1
    //   2850: if_icmpne +13 -> 2863
    //   2853: aload_0
    //   2854: getfield 18	akfq:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   2857: invokestatic 147	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/media/AudioRecord;
    //   2860: invokevirtual 211	android/media/AudioRecord:stop	()V
    //   2863: aload_0
    //   2864: getfield 18	akfq:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   2867: invokestatic 213	com/tencent/mobileqq/utils/QQRecorder:c	(Lcom/tencent/mobileqq/utils/QQRecorder;)V
    //   2870: invokestatic 41	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2873: ifeq +84 -> 2957
    //   2876: ldc 43
    //   2878: iconst_2
    //   2879: new 45	java/lang/StringBuilder
    //   2882: dup
    //   2883: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   2886: ldc 215
    //   2888: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2891: aload_0
    //   2892: invokevirtual 55	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   2895: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2898: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2901: ldc 43
    //   2903: iconst_2
    //   2904: new 45	java/lang/StringBuilder
    //   2907: dup
    //   2908: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   2911: ldc 217
    //   2913: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2916: lload 26
    //   2918: invokevirtual 123	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2921: ldc 219
    //   2923: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2926: lload 20
    //   2928: invokevirtual 123	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2931: ldc 221
    //   2933: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2936: lload 16
    //   2938: invokevirtual 123	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2941: ldc 223
    //   2943: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2946: iload 9
    //   2948: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2951: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2954: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2957: aload_0
    //   2958: getfield 18	akfq:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   2961: invokestatic 80	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Landroid/content/Context;
    //   2964: iconst_0
    //   2965: invokestatic 85	com/tencent/mobileqq/utils/AudioUtil:a	(Landroid/content/Context;Z)Z
    //   2968: pop
    //   2969: lload 16
    //   2971: ldc2_w 224
    //   2974: lcmp
    //   2975: iflt +11 -> 2986
    //   2978: dload_2
    //   2979: ldc2_w 226
    //   2982: dcmpg
    //   2983: ifge +303 -> 3286
    //   2986: iload 8
    //   2988: ifne +298 -> 3286
    //   2991: invokestatic 69	java/lang/System:currentTimeMillis	()J
    //   2994: lload 28
    //   2996: lsub
    //   2997: ldc2_w 170
    //   3000: lcmp
    //   3001: ifle +285 -> 3286
    //   3004: new 229	java/util/HashMap
    //   3007: dup
    //   3008: invokespecial 230	java/util/HashMap:<init>	()V
    //   3011: astore 30
    //   3013: aload 30
    //   3015: ldc_w 338
    //   3018: ldc_w 340
    //   3021: invokevirtual 243	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3024: pop
    //   3025: aload 30
    //   3027: ldc 232
    //   3029: new 45	java/lang/StringBuilder
    //   3032: dup
    //   3033: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   3036: getstatic 237	android/os/Build$VERSION:SDK_INT	I
    //   3039: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3042: ldc 239
    //   3044: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3047: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3050: invokevirtual 243	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3053: pop
    //   3054: aload 30
    //   3056: ldc 245
    //   3058: new 45	java/lang/StringBuilder
    //   3061: dup
    //   3062: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   3065: getstatic 250	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   3068: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3071: ldc 252
    //   3073: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3076: getstatic 255	android/os/Build:MODEL	Ljava/lang/String;
    //   3079: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3082: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3085: invokevirtual 243	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3088: pop
    //   3089: aload 30
    //   3091: ldc_w 257
    //   3094: new 45	java/lang/StringBuilder
    //   3097: dup
    //   3098: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   3101: lload 20
    //   3103: invokevirtual 123	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3106: ldc 239
    //   3108: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3111: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3114: invokevirtual 243	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3117: pop
    //   3118: aload 30
    //   3120: ldc_w 266
    //   3123: new 45	java/lang/StringBuilder
    //   3126: dup
    //   3127: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   3130: iload 10
    //   3132: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3135: ldc 239
    //   3137: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3140: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3143: invokevirtual 243	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3146: pop
    //   3147: aload 30
    //   3149: ldc_w 342
    //   3152: new 45	java/lang/StringBuilder
    //   3155: dup
    //   3156: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   3159: dload_2
    //   3160: invokevirtual 262	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   3163: ldc 239
    //   3165: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3168: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3171: invokevirtual 243	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3174: pop
    //   3175: aload 30
    //   3177: ldc_w 264
    //   3180: new 45	java/lang/StringBuilder
    //   3183: dup
    //   3184: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   3187: invokestatic 69	java/lang/System:currentTimeMillis	()J
    //   3190: lload 28
    //   3192: lsub
    //   3193: invokevirtual 123	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3196: ldc 239
    //   3198: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3201: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3204: invokevirtual 243	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3207: pop
    //   3208: ldc_w 344
    //   3211: iconst_0
    //   3212: aload 30
    //   3214: invokestatic 279	com/tencent/mobileqq/utils/QQRecorder:a	(Ljava/lang/String;ZLjava/util/HashMap;)V
    //   3217: invokestatic 41	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3220: ifeq +66 -> 3286
    //   3223: ldc 43
    //   3225: iconst_2
    //   3226: new 45	java/lang/StringBuilder
    //   3229: dup
    //   3230: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   3233: ldc_w 346
    //   3236: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3239: lload 20
    //   3241: invokevirtual 123	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3244: ldc_w 348
    //   3247: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3250: lload 16
    //   3252: invokevirtual 123	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3255: ldc_w 350
    //   3258: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3261: dload_2
    //   3262: invokevirtual 262	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   3265: ldc_w 352
    //   3268: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3271: invokestatic 69	java/lang/System:currentTimeMillis	()J
    //   3274: lload 28
    //   3276: lsub
    //   3277: invokevirtual 123	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3280: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3283: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3286: new 229	java/util/HashMap
    //   3289: dup
    //   3290: invokespecial 230	java/util/HashMap:<init>	()V
    //   3293: astore 30
    //   3295: aload 30
    //   3297: ldc 232
    //   3299: new 45	java/lang/StringBuilder
    //   3302: dup
    //   3303: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   3306: getstatic 237	android/os/Build$VERSION:SDK_INT	I
    //   3309: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3312: ldc 239
    //   3314: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3317: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3320: invokevirtual 243	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3323: pop
    //   3324: aload 30
    //   3326: ldc 245
    //   3328: new 45	java/lang/StringBuilder
    //   3331: dup
    //   3332: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   3335: getstatic 250	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   3338: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3341: ldc 252
    //   3343: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3346: getstatic 255	android/os/Build:MODEL	Ljava/lang/String;
    //   3349: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3352: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3355: invokevirtual 243	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3358: pop
    //   3359: aload 30
    //   3361: ldc_w 257
    //   3364: new 45	java/lang/StringBuilder
    //   3367: dup
    //   3368: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   3371: lload 20
    //   3373: invokevirtual 123	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3376: ldc 239
    //   3378: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3381: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3384: invokevirtual 243	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3387: pop
    //   3388: aload 30
    //   3390: ldc_w 259
    //   3393: new 45	java/lang/StringBuilder
    //   3396: dup
    //   3397: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   3400: dload_2
    //   3401: invokevirtual 262	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   3404: ldc 239
    //   3406: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3409: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3412: invokevirtual 243	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3415: pop
    //   3416: aload 30
    //   3418: ldc_w 264
    //   3421: new 45	java/lang/StringBuilder
    //   3424: dup
    //   3425: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   3428: invokestatic 69	java/lang/System:currentTimeMillis	()J
    //   3431: lload 28
    //   3433: lsub
    //   3434: invokevirtual 123	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3437: ldc 239
    //   3439: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3442: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3445: invokevirtual 243	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3448: pop
    //   3449: aload 30
    //   3451: ldc_w 266
    //   3454: new 45	java/lang/StringBuilder
    //   3457: dup
    //   3458: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   3461: iload 10
    //   3463: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3466: ldc 239
    //   3468: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3471: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3474: invokevirtual 243	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3477: pop
    //   3478: aload 30
    //   3480: ldc_w 268
    //   3483: new 45	java/lang/StringBuilder
    //   3486: dup
    //   3487: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   3490: aload_0
    //   3491: getfield 27	akfq:jdField_a_of_type_Int	I
    //   3494: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3497: ldc 239
    //   3499: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3502: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3505: invokevirtual 243	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3508: pop
    //   3509: lload 22
    //   3511: lconst_0
    //   3512: lcmp
    //   3513: ifne +334 -> 3847
    //   3516: ldc2_w 269
    //   3519: lstore 18
    //   3521: goto +674 -> 4195
    //   3524: lload 18
    //   3526: l2i
    //   3527: istore 8
    //   3529: aload 30
    //   3531: ldc_w 272
    //   3534: new 45	java/lang/StringBuilder
    //   3537: dup
    //   3538: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   3541: iload 9
    //   3543: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3546: ldc 239
    //   3548: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3551: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3554: invokevirtual 243	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3557: pop
    //   3558: aload 30
    //   3560: ldc_w 274
    //   3563: new 45	java/lang/StringBuilder
    //   3566: dup
    //   3567: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   3570: iload 8
    //   3572: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3575: ldc 239
    //   3577: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3580: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3583: invokevirtual 243	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   3586: pop
    //   3587: ldc_w 276
    //   3590: iconst_1
    //   3591: aload 30
    //   3593: invokestatic 279	com/tencent/mobileqq/utils/QQRecorder:a	(Ljava/lang/String;ZLjava/util/HashMap;)V
    //   3596: invokestatic 41	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3599: ifeq +138 -> 3737
    //   3602: new 45	java/lang/StringBuilder
    //   3605: dup
    //   3606: invokespecial 46	java/lang/StringBuilder:<init>	()V
    //   3609: astore 30
    //   3611: aload 30
    //   3613: ldc_w 281
    //   3616: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3619: iload 10
    //   3621: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3624: pop
    //   3625: aload 30
    //   3627: ldc_w 283
    //   3630: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3633: iload 9
    //   3635: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3638: pop
    //   3639: aload 30
    //   3641: ldc_w 285
    //   3644: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3647: iload 8
    //   3649: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3652: pop
    //   3653: aload 30
    //   3655: ldc_w 287
    //   3658: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3661: iload 8
    //   3663: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3666: pop
    //   3667: aload 30
    //   3669: ldc_w 289
    //   3672: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3675: lload 20
    //   3677: invokevirtual 123	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3680: pop
    //   3681: aload 30
    //   3683: ldc_w 291
    //   3686: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3689: lload 16
    //   3691: invokevirtual 123	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3694: pop
    //   3695: aload 30
    //   3697: ldc_w 293
    //   3700: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3703: dload_2
    //   3704: invokevirtual 262	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   3707: pop
    //   3708: aload 30
    //   3710: ldc_w 295
    //   3713: invokevirtual 52	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3716: invokestatic 69	java/lang/System:currentTimeMillis	()J
    //   3719: lload 28
    //   3721: lsub
    //   3722: invokevirtual 123	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3725: pop
    //   3726: ldc 43
    //   3728: iconst_2
    //   3729: aload 30
    //   3731: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3734: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3737: aload_1
    //   3738: athrow
    //   3739: aload_0
    //   3740: getfield 18	akfq:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   3743: invokestatic 88	com/tencent/mobileqq/utils/QQRecorder:a	(Lcom/tencent/mobileqq/utils/QQRecorder;)Lcom/tencent/mobileqq/utils/QQRecorder$OnQQRecorderListener;
    //   3746: aload_1
    //   3747: aload_0
    //   3748: getfield 18	akfq:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   3751: getfield 91	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder$RecorderParam	Lcom/tencent/mobileqq/utils/QQRecorder$RecorderParam;
    //   3754: aload 30
    //   3756: invokevirtual 364	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   3759: invokeinterface 367 4 0
    //   3764: goto -3073 -> 691
    //   3767: astore_1
    //   3768: aload_1
    //   3769: invokevirtual 357	java/lang/Throwable:printStackTrace	()V
    //   3772: goto -3031 -> 741
    //   3775: lload 24
    //   3777: lload 22
    //   3779: ldiv
    //   3780: lstore 20
    //   3782: goto +373 -> 4155
    //   3785: aload_0
    //   3786: getfield 29	akfq:jdField_a_of_type_Long	J
    //   3789: lload 22
    //   3791: ldiv
    //   3792: lstore 20
    //   3794: goto -2707 -> 1087
    //   3797: astore_1
    //   3798: invokestatic 41	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3801: ifeq -2514 -> 1287
    //   3804: ldc 43
    //   3806: iconst_2
    //   3807: ldc_w 354
    //   3810: aload_1
    //   3811: invokestatic 186	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3814: return
    //   3815: astore 30
    //   3817: aload 30
    //   3819: invokevirtual 357	java/lang/Throwable:printStackTrace	()V
    //   3822: goto -952 -> 2870
    //   3825: astore 30
    //   3827: invokestatic 41	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3830: ifeq -544 -> 3286
    //   3833: ldc 43
    //   3835: iconst_2
    //   3836: ldc_w 359
    //   3839: aload 30
    //   3841: invokestatic 186	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3844: goto -558 -> 3286
    //   3847: lload 24
    //   3849: lload 22
    //   3851: ldiv
    //   3852: lstore 18
    //   3854: goto +341 -> 4195
    //   3857: aload_0
    //   3858: getfield 29	akfq:jdField_a_of_type_Long	J
    //   3861: lload 22
    //   3863: ldiv
    //   3864: lstore 18
    //   3866: goto -342 -> 3524
    //   3869: astore 30
    //   3871: invokestatic 41	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3874: ifeq -137 -> 3737
    //   3877: ldc 43
    //   3879: iconst_2
    //   3880: ldc_w 354
    //   3883: aload 30
    //   3885: invokestatic 186	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   3888: goto -151 -> 3737
    //   3891: astore_1
    //   3892: lconst_0
    //   3893: lstore 26
    //   3895: lconst_0
    //   3896: lstore 16
    //   3898: iconst_0
    //   3899: istore 8
    //   3901: iload 13
    //   3903: istore 10
    //   3905: iload 11
    //   3907: istore 9
    //   3909: lload 18
    //   3911: lstore 20
    //   3913: goto -1084 -> 2829
    //   3916: astore_1
    //   3917: iload 8
    //   3919: istore 9
    //   3921: iconst_0
    //   3922: istore 8
    //   3924: lload 18
    //   3926: lstore 26
    //   3928: goto -1099 -> 2829
    //   3931: astore_1
    //   3932: iload 8
    //   3934: istore 9
    //   3936: iconst_0
    //   3937: istore 8
    //   3939: lload 18
    //   3941: lstore 26
    //   3943: goto -1114 -> 2829
    //   3946: astore_1
    //   3947: iload 13
    //   3949: istore 9
    //   3951: iconst_0
    //   3952: istore 8
    //   3954: lload 18
    //   3956: lstore 26
    //   3958: goto -1129 -> 2829
    //   3961: astore_1
    //   3962: iload 8
    //   3964: istore 9
    //   3966: iconst_0
    //   3967: istore 8
    //   3969: lload 18
    //   3971: lstore 26
    //   3973: goto -1144 -> 2829
    //   3976: astore_1
    //   3977: iload 9
    //   3979: istore 10
    //   3981: dload 4
    //   3983: dstore_2
    //   3984: iload 8
    //   3986: istore 9
    //   3988: iconst_0
    //   3989: istore 8
    //   3991: lload 18
    //   3993: lstore 26
    //   3995: goto -1166 -> 2829
    //   3998: astore_1
    //   3999: iload 9
    //   4001: istore 10
    //   4003: iload 8
    //   4005: istore 9
    //   4007: iconst_0
    //   4008: istore 8
    //   4010: lload 18
    //   4012: lstore 26
    //   4014: goto -1185 -> 2829
    //   4017: astore 30
    //   4019: iload 15
    //   4021: istore 10
    //   4023: iload 12
    //   4025: istore 9
    //   4027: goto -3430 -> 597
    //   4030: astore 30
    //   4032: lload 18
    //   4034: lstore 26
    //   4036: iload 8
    //   4038: istore 9
    //   4040: lload 20
    //   4042: lstore 18
    //   4044: lload 26
    //   4046: lstore 20
    //   4048: goto -3451 -> 597
    //   4051: astore 30
    //   4053: iload 13
    //   4055: istore 9
    //   4057: lload 18
    //   4059: lstore 26
    //   4061: lload 20
    //   4063: lstore 18
    //   4065: lload 26
    //   4067: lstore 20
    //   4069: goto -3472 -> 597
    //   4072: astore 30
    //   4074: lload 18
    //   4076: lstore 26
    //   4078: iload 8
    //   4080: istore 9
    //   4082: lload 20
    //   4084: lstore 18
    //   4086: lload 26
    //   4088: lstore 20
    //   4090: goto -3493 -> 597
    //   4093: astore 30
    //   4095: dload 6
    //   4097: dstore_2
    //   4098: lload 18
    //   4100: lstore 26
    //   4102: iload 9
    //   4104: istore 10
    //   4106: iload 8
    //   4108: istore 9
    //   4110: lload 20
    //   4112: lstore 18
    //   4114: lload 26
    //   4116: lstore 20
    //   4118: goto -3521 -> 597
    //   4121: astore 30
    //   4123: lload 18
    //   4125: lstore 26
    //   4127: lload 20
    //   4129: lstore 18
    //   4131: iload 9
    //   4133: istore 10
    //   4135: iload 8
    //   4137: istore 9
    //   4139: lload 26
    //   4141: lstore 20
    //   4143: goto -3546 -> 597
    //   4146: goto -2488 -> 1658
    //   4149: iconst_m1
    //   4150: istore 14
    //   4152: goto -3742 -> 410
    //   4155: lload 20
    //   4157: l2i
    //   4158: istore 9
    //   4160: lload 22
    //   4162: lconst_0
    //   4163: lcmp
    //   4164: ifne -379 -> 3785
    //   4167: ldc2_w 269
    //   4170: lstore 20
    //   4172: goto -3085 -> 1087
    //   4175: lload 18
    //   4177: l2i
    //   4178: istore 9
    //   4180: lload 22
    //   4182: lconst_0
    //   4183: lcmp
    //   4184: ifne -1410 -> 2774
    //   4187: ldc2_w 269
    //   4190: lstore 18
    //   4192: goto -1675 -> 2517
    //   4195: lload 18
    //   4197: l2i
    //   4198: istore 9
    //   4200: lload 22
    //   4202: lconst_0
    //   4203: lcmp
    //   4204: ifne -347 -> 3857
    //   4207: ldc2_w 269
    //   4210: lstore 18
    //   4212: goto -688 -> 3524
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	4215	0	this	akfq
    //   0	4215	1	paramString	String
    //   44	4054	2	d1	double
    //   1511	2471	4	d2	double
    //   1514	2582	6	d3	double
    //   71	4065	8	i	int
    //   160	4039	9	j	int
    //   63	4071	10	k	int
    //   38	3868	11	m	int
    //   41	3983	12	n	int
    //   60	3994	13	i1	int
    //   264	3887	14	i2	int
    //   57	3963	15	i3	int
    //   51	3846	16	l1	long
    //   35	4176	18	l2	long
    //   32	4139	20	l3	long
    //   54	4147	22	l4	long
    //   66	3782	24	l5	long
    //   450	3690	26	l6	long
    //   48	3672	28	l7	long
    //   129	186	30	arrayOfByte	byte[]
    //   579	2208	30	localThrowable1	java.lang.Throwable
    //   3011	744	30	localObject	java.lang.Object
    //   3815	3	30	localThrowable2	java.lang.Throwable
    //   3825	15	30	localException1	java.lang.Exception
    //   3869	15	30	localException2	java.lang.Exception
    //   4017	1	30	localThrowable3	java.lang.Throwable
    //   4030	1	30	localThrowable4	java.lang.Throwable
    //   4051	1	30	localThrowable5	java.lang.Throwable
    //   4072	1	30	localThrowable6	java.lang.Throwable
    //   4093	1	30	localThrowable7	java.lang.Throwable
    //   4121	1	30	localThrowable8	java.lang.Throwable
    //   1531	113	31	localProcessData	IPttProcessor.ProcessData
    // Exception table:
    //   from	to	target	type
    //   472	486	579	java/lang/Throwable
    //   490	503	579	java/lang/Throwable
    //   527	569	579	java/lang/Throwable
    //   569	579	579	java/lang/Throwable
    //   1292	1305	579	java/lang/Throwable
    //   1314	1349	579	java/lang/Throwable
    //   1349	1366	579	java/lang/Throwable
    //   1373	1397	579	java/lang/Throwable
    //   1781	1844	579	java/lang/Throwable
    //   2287	2502	2718	java/lang/Exception
    //   2522	2717	2718	java/lang/Exception
    //   2764	2771	2718	java/lang/Exception
    //   2774	2783	2718	java/lang/Exception
    //   1878	1885	2736	java/lang/Throwable
    //   2014	2287	2744	java/lang/Exception
    //   597	613	2817	finally
    //   613	655	2817	finally
    //   655	671	2817	finally
    //   671	691	2817	finally
    //   691	700	2817	finally
    //   2786	2814	2817	finally
    //   3739	3764	2817	finally
    //   734	741	3767	java/lang/Throwable
    //   857	1072	3797	java/lang/Exception
    //   1092	1287	3797	java/lang/Exception
    //   3775	3782	3797	java/lang/Exception
    //   3785	3794	3797	java/lang/Exception
    //   2863	2870	3815	java/lang/Throwable
    //   3004	3286	3825	java/lang/Exception
    //   3286	3509	3869	java/lang/Exception
    //   3529	3737	3869	java/lang/Exception
    //   3847	3854	3869	java/lang/Exception
    //   3857	3866	3869	java/lang/Exception
    //   90	120	3891	finally
    //   120	138	3891	finally
    //   138	162	3891	finally
    //   176	183	3891	finally
    //   183	220	3891	finally
    //   220	266	3891	finally
    //   276	285	3891	finally
    //   285	300	3891	finally
    //   307	323	3891	finally
    //   333	375	3891	finally
    //   375	410	3891	finally
    //   410	447	3891	finally
    //   447	452	3891	finally
    //   472	486	3916	finally
    //   490	503	3916	finally
    //   527	569	3916	finally
    //   569	579	3916	finally
    //   1292	1305	3916	finally
    //   1314	1349	3916	finally
    //   1349	1366	3916	finally
    //   1373	1397	3916	finally
    //   1781	1844	3916	finally
    //   1407	1429	3931	finally
    //   1434	1440	3946	finally
    //   1475	1502	3961	finally
    //   1516	1533	3976	finally
    //   1539	1542	3976	finally
    //   1548	1567	3976	finally
    //   1573	1583	3976	finally
    //   1594	1632	3976	finally
    //   1643	1650	3976	finally
    //   1672	1682	3998	finally
    //   1685	1708	3998	finally
    //   1712	1747	3998	finally
    //   1765	1770	3998	finally
    //   90	120	4017	java/lang/Throwable
    //   120	138	4017	java/lang/Throwable
    //   138	162	4017	java/lang/Throwable
    //   176	183	4017	java/lang/Throwable
    //   183	220	4017	java/lang/Throwable
    //   220	266	4017	java/lang/Throwable
    //   276	285	4017	java/lang/Throwable
    //   285	300	4017	java/lang/Throwable
    //   307	323	4017	java/lang/Throwable
    //   333	375	4017	java/lang/Throwable
    //   375	410	4017	java/lang/Throwable
    //   410	447	4017	java/lang/Throwable
    //   447	452	4017	java/lang/Throwable
    //   1407	1429	4030	java/lang/Throwable
    //   1434	1440	4051	java/lang/Throwable
    //   1475	1502	4072	java/lang/Throwable
    //   1516	1533	4093	java/lang/Throwable
    //   1539	1542	4093	java/lang/Throwable
    //   1548	1567	4093	java/lang/Throwable
    //   1573	1583	4093	java/lang/Throwable
    //   1594	1632	4093	java/lang/Throwable
    //   1643	1650	4093	java/lang/Throwable
    //   1672	1682	4121	java/lang/Throwable
    //   1685	1708	4121	java/lang/Throwable
    //   1712	1747	4121	java/lang/Throwable
    //   1765	1770	4121	java/lang/Throwable
  }
  
  public void a()
  {
    if (QQRecorder.a(this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder) != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQRecorder", 2, "releaseRecorder");
      }
      QQRecorder.a(this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder).release();
      QQRecorder.a(this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder, null);
    }
  }
  
  public void a(IPttProcessor paramIPttProcessor, IPttProcessor.ProcessData paramProcessData)
  {
    if (((paramIPttProcessor instanceof WechatNsWrapper)) && (QQRecorder.a(this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder) != null)) {
      QQRecorder.a(this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder).b(paramIPttProcessor, paramProcessData);
    }
  }
  
  public boolean a()
  {
    return (this.b) || (QQRecorder.a(this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder) != null);
  }
  
  public void b(IPttProcessor paramIPttProcessor, IPttProcessor.ProcessData paramProcessData)
  {
    if ((paramIPttProcessor instanceof WechatNsWrapper))
    {
      QQRecorder.a(this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder, (int)AudioHelper.a(QQRecorder.a(this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder), paramProcessData.jdField_a_of_type_ArrayOfByte, paramProcessData.jdField_a_of_type_Int, 1.0F));
      this.jdField_a_of_type_Int = Math.max(this.jdField_a_of_type_Int, QQRecorder.b(this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder));
      this.jdField_a_of_type_Long += QQRecorder.b(this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder);
      if (QQRecorder.a(this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder) != null) {
        QQRecorder.a(this.jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder).a(paramIPttProcessor, paramProcessData);
      }
    }
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 25	akfq:b	Z
    //   4: ifeq +116 -> 120
    //   7: invokestatic 41	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   10: ifeq +12 -> 22
    //   13: ldc 43
    //   15: iconst_2
    //   16: ldc_w 395
    //   19: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   22: aload_0
    //   23: iconst_1
    //   24: putfield 23	akfq:jdField_a_of_type_Boolean	Z
    //   27: aload_0
    //   28: iconst_0
    //   29: putfield 169	akfq:c	Z
    //   32: aload_0
    //   33: aload_0
    //   34: getfield 162	akfq:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   37: invokespecial 397	akfq:a	(Ljava/lang/String;)V
    //   40: aload_0
    //   41: getfield 25	akfq:b	Z
    //   44: ifeq -44 -> 0
    //   47: invokestatic 117	android/os/SystemClock:uptimeMillis	()J
    //   50: lstore_1
    //   51: aload_0
    //   52: getfield 18	akfq:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   55: astore_3
    //   56: aload_3
    //   57: monitorenter
    //   58: aload_0
    //   59: getfield 18	akfq:jdField_a_of_type_ComTencentMobileqqUtilsQQRecorder	Lcom/tencent/mobileqq/utils/QQRecorder;
    //   62: getstatic 398	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_Int	I
    //   65: i2l
    //   66: invokevirtual 403	java/lang/Object:wait	(J)V
    //   69: aload_3
    //   70: monitorexit
    //   71: invokestatic 117	android/os/SystemClock:uptimeMillis	()J
    //   74: lload_1
    //   75: lsub
    //   76: getstatic 398	com/tencent/mobileqq/utils/QQRecorder:jdField_a_of_type_Int	I
    //   79: i2l
    //   80: lcmp
    //   81: iflt -81 -> 0
    //   84: invokestatic 41	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   87: ifeq +12 -> 99
    //   90: ldc 43
    //   92: iconst_2
    //   93: ldc_w 405
    //   96: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   99: aload_0
    //   100: monitorenter
    //   101: aload_0
    //   102: iconst_0
    //   103: putfield 25	akfq:b	Z
    //   106: aload_0
    //   107: monitorexit
    //   108: aload_0
    //   109: invokevirtual 407	akfq:a	()V
    //   112: goto -112 -> 0
    //   115: astore_3
    //   116: aload_3
    //   117: invokevirtual 408	java/lang/InterruptedException:printStackTrace	()V
    //   120: aload_0
    //   121: invokevirtual 407	akfq:a	()V
    //   124: return
    //   125: astore 4
    //   127: aload_3
    //   128: monitorexit
    //   129: aload 4
    //   131: athrow
    //   132: astore_3
    //   133: aload_0
    //   134: monitorexit
    //   135: aload_3
    //   136: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	137	0	this	akfq
    //   50	25	1	l	long
    //   115	13	3	localInterruptedException	java.lang.InterruptedException
    //   132	4	3	localObject1	java.lang.Object
    //   125	5	4	localObject2	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   47	58	115	java/lang/InterruptedException
    //   71	99	115	java/lang/InterruptedException
    //   99	101	115	java/lang/InterruptedException
    //   108	112	115	java/lang/InterruptedException
    //   129	132	115	java/lang/InterruptedException
    //   135	137	115	java/lang/InterruptedException
    //   58	71	125	finally
    //   127	129	125	finally
    //   101	108	132	finally
    //   133	135	132	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     akfq
 * JD-Core Version:    0.7.0.1
 */
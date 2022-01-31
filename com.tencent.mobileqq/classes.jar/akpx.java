import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.msgcache.MsgLruCache;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class akpx
  extends aksv
{
  private akpv jdField_a_of_type_Akpv;
  private azno jdField_a_of_type_Azno;
  private volatile boolean jdField_a_of_type_Boolean;
  private azno jdField_b_of_type_Azno;
  private volatile boolean jdField_b_of_type_Boolean;
  private azno c;
  
  public akpx(QQAppInterface paramQQAppInterface, ProxyManager paramProxyManager)
  {
    super(paramQQAppInterface, paramProxyManager);
    this.jdField_a_of_type_Akpv = new akpv(paramQQAppInterface, paramProxyManager);
    this.jdField_a_of_type_Azno = new azno(paramQQAppInterface, paramProxyManager);
    this.jdField_b_of_type_Azno = new azno(paramQQAppInterface, paramProxyManager);
    this.c = new azno(paramQQAppInterface, paramProxyManager);
  }
  
  public akpv a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return this.jdField_a_of_type_Akpv;
    case 1: 
      return this.jdField_a_of_type_Azno;
    case 3000: 
      return this.jdField_b_of_type_Azno;
    }
    return this.c;
  }
  
  /* Error */
  protected void a()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: getfield 35	akpx:jdField_a_of_type_Boolean	Z
    //   6: ifne +920 -> 926
    //   9: aload_0
    //   10: monitorenter
    //   11: aload_0
    //   12: getfield 35	akpx:jdField_a_of_type_Boolean	Z
    //   15: ifne +506 -> 521
    //   18: invokestatic 41	java/lang/System:currentTimeMillis	()J
    //   21: lstore 7
    //   23: aload_0
    //   24: getfield 24	akpx:jdField_a_of_type_Azno	Lazno;
    //   27: invokevirtual 43	azno:a	()V
    //   30: aload_0
    //   31: getfield 26	akpx:jdField_b_of_type_Azno	Lazno;
    //   34: invokevirtual 43	azno:a	()V
    //   37: aload_0
    //   38: getfield 19	akpx:jdField_a_of_type_Akpv	Lakpv;
    //   41: invokevirtual 44	akpv:a	()V
    //   44: aload_0
    //   45: getfield 28	akpx:c	Lazno;
    //   48: invokevirtual 43	azno:a	()V
    //   51: aload_0
    //   52: getfield 47	akpx:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   55: bipush 18
    //   57: invokevirtual 53	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   60: checkcast 55	com/tencent/mobileqq/app/proxy/ProxyManager
    //   63: invokevirtual 58	com/tencent/mobileqq/app/proxy/ProxyManager:a	()Laktg;
    //   66: iconst_1
    //   67: invokevirtual 63	aktg:a	(Z)Ljava/util/List;
    //   70: astore 14
    //   72: aload 14
    //   74: ifnonnull +6 -> 80
    //   77: aload_0
    //   78: monitorexit
    //   79: return
    //   80: invokestatic 69	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   83: ifeq +34 -> 117
    //   86: ldc 71
    //   88: iconst_2
    //   89: new 73	java/lang/StringBuilder
    //   92: dup
    //   93: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   96: ldc 77
    //   98: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: aload 14
    //   103: invokeinterface 87 1 0
    //   108: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   111: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: invokestatic 98	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   117: new 100	axrr
    //   120: dup
    //   121: invokespecial 101	axrr:<init>	()V
    //   124: astore 15
    //   126: aload 15
    //   128: iconst_0
    //   129: putfield 104	axrr:jdField_a_of_type_Int	I
    //   132: aload 15
    //   134: ldc 106
    //   136: putfield 109	axrr:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   139: aload 15
    //   141: ldc 111
    //   143: putfield 113	axrr:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   146: invokestatic 41	java/lang/System:currentTimeMillis	()J
    //   149: lstore 9
    //   151: getstatic 117	akrz:jdField_b_of_type_Boolean	Z
    //   154: istore 13
    //   156: iload 13
    //   158: ifeq +373 -> 531
    //   161: bipush 15
    //   163: istore 4
    //   165: iconst_0
    //   166: istore 5
    //   168: iconst_0
    //   169: istore_1
    //   170: iload_1
    //   171: istore_3
    //   172: iload 5
    //   174: aload 14
    //   176: invokeinterface 87 1 0
    //   181: if_icmpge +10 -> 191
    //   184: iload 5
    //   186: iload 4
    //   188: if_icmplt +350 -> 538
    //   191: iload_1
    //   192: istore_3
    //   193: invokestatic 41	java/lang/System:currentTimeMillis	()J
    //   196: lstore 11
    //   198: iload_1
    //   199: istore_3
    //   200: new 73	java/lang/StringBuilder
    //   203: dup
    //   204: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   207: ldc 119
    //   209: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: getstatic 124	com/tencent/mobileqq/app/msgcache/MsgLruCache:TAG	Ljava/lang/String;
    //   215: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   221: iconst_1
    //   222: bipush 8
    //   224: anewarray 126	java/lang/Object
    //   227: dup
    //   228: iconst_0
    //   229: ldc 128
    //   231: aastore
    //   232: dup
    //   233: iconst_1
    //   234: lload 11
    //   236: lload 9
    //   238: lsub
    //   239: invokestatic 134	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   242: aastore
    //   243: dup
    //   244: iconst_2
    //   245: ldc 136
    //   247: aastore
    //   248: dup
    //   249: iconst_3
    //   250: iload_1
    //   251: invokestatic 141	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   254: aastore
    //   255: dup
    //   256: iconst_4
    //   257: ldc 143
    //   259: aastore
    //   260: dup
    //   261: iconst_5
    //   262: iload_2
    //   263: invokestatic 141	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   266: aastore
    //   267: dup
    //   268: bipush 6
    //   270: ldc 145
    //   272: aastore
    //   273: dup
    //   274: bipush 7
    //   276: getstatic 117	akrz:jdField_b_of_type_Boolean	Z
    //   279: invokestatic 150	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   282: aastore
    //   283: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   286: invokestatic 41	java/lang/System:currentTimeMillis	()J
    //   289: lstore 9
    //   291: invokestatic 158	bfmu:a	()Lbfmu;
    //   294: ldc 160
    //   296: new 73	java/lang/StringBuilder
    //   299: dup
    //   300: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   303: lload 9
    //   305: lload 7
    //   307: lsub
    //   308: invokevirtual 163	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   311: ldc 165
    //   313: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   319: invokevirtual 168	bfmu:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   322: invokestatic 158	bfmu:a	()Lbfmu;
    //   325: ldc 170
    //   327: new 73	java/lang/StringBuilder
    //   330: dup
    //   331: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   334: iload_1
    //   335: invokevirtual 90	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   338: ldc 165
    //   340: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: invokevirtual 94	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   346: invokevirtual 168	bfmu:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   349: aload_0
    //   350: iconst_1
    //   351: putfield 35	akpx:jdField_a_of_type_Boolean	Z
    //   354: aload 15
    //   356: getfield 172	axrr:jdField_b_of_type_Int	I
    //   359: ifeq +162 -> 521
    //   362: invokestatic 176	axrl:a	()Z
    //   365: ifeq +156 -> 521
    //   368: new 178	java/util/HashMap
    //   371: dup
    //   372: invokespecial 179	java/util/HashMap:<init>	()V
    //   375: astore 14
    //   377: aload 14
    //   379: ldc 181
    //   381: aload 15
    //   383: getfield 104	axrr:jdField_a_of_type_Int	I
    //   386: invokestatic 186	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   389: invokevirtual 190	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   392: pop
    //   393: aload 14
    //   395: ldc 192
    //   397: aload 15
    //   399: getfield 109	axrr:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   402: invokevirtual 190	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   405: pop
    //   406: aload 14
    //   408: ldc 194
    //   410: aload 15
    //   412: getfield 197	axrr:jdField_a_of_type_Long	J
    //   415: invokestatic 200	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   418: invokevirtual 190	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   421: pop
    //   422: aload 14
    //   424: ldc 202
    //   426: aload 15
    //   428: getfield 172	axrr:jdField_b_of_type_Int	I
    //   431: invokestatic 186	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   434: invokevirtual 190	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   437: pop
    //   438: aload 14
    //   440: ldc 204
    //   442: aload 15
    //   444: getfield 206	axrr:c	I
    //   447: invokestatic 186	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   450: invokevirtual 190	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   453: pop
    //   454: aload 14
    //   456: ldc 208
    //   458: aload 15
    //   460: getfield 210	axrr:jdField_b_of_type_Long	J
    //   463: invokestatic 200	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   466: invokevirtual 190	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   469: pop
    //   470: aload 14
    //   472: ldc 212
    //   474: aload 15
    //   476: getfield 113	axrr:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   479: invokevirtual 190	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   482: pop
    //   483: aload 14
    //   485: ldc 214
    //   487: getstatic 217	akfv:jdField_a_of_type_Boolean	Z
    //   490: invokestatic 220	java/lang/String:valueOf	(Z)Ljava/lang/String;
    //   493: invokevirtual 190	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   496: pop
    //   497: invokestatic 226	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   500: invokestatic 229	axrl:a	(Landroid/content/Context;)Laxrl;
    //   503: aconst_null
    //   504: ldc 231
    //   506: iconst_1
    //   507: aload 15
    //   509: getfield 206	axrr:c	I
    //   512: i2l
    //   513: lconst_0
    //   514: aload 14
    //   516: aconst_null
    //   517: iconst_0
    //   518: invokevirtual 234	axrl:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   521: aload_0
    //   522: monitorexit
    //   523: return
    //   524: astore 14
    //   526: aload_0
    //   527: monitorexit
    //   528: aload 14
    //   530: athrow
    //   531: bipush 40
    //   533: istore 4
    //   535: goto -370 -> 165
    //   538: iload_1
    //   539: istore_3
    //   540: aload 14
    //   542: iload 5
    //   544: invokeinterface 238 2 0
    //   549: checkcast 240	com/tencent/mobileqq/data/RecentUser
    //   552: invokevirtual 243	com/tencent/mobileqq/data/RecentUser:getType	()I
    //   555: sipush 6000
    //   558: if_icmpne +6 -> 564
    //   561: goto +366 -> 927
    //   564: iload_1
    //   565: istore_3
    //   566: aload 14
    //   568: iload 5
    //   570: invokeinterface 238 2 0
    //   575: checkcast 240	com/tencent/mobileqq/data/RecentUser
    //   578: invokevirtual 243	com/tencent/mobileqq/data/RecentUser:getType	()I
    //   581: ifne +41 -> 622
    //   584: iload_1
    //   585: istore_3
    //   586: getstatic 248	ajsf:N	Ljava/lang/String;
    //   589: aload 14
    //   591: iload 5
    //   593: invokeinterface 238 2 0
    //   598: checkcast 240	com/tencent/mobileqq/data/RecentUser
    //   601: getfield 251	com/tencent/mobileqq/data/RecentUser:uin	Ljava/lang/String;
    //   604: invokevirtual 255	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   607: ifeq +15 -> 622
    //   610: iload_1
    //   611: istore_3
    //   612: invokestatic 260	aydb:a	()Laydb;
    //   615: aload_0
    //   616: getfield 47	akpx:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   619: invokevirtual 263	aydb:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   622: iload_1
    //   623: istore_3
    //   624: aload_0
    //   625: getfield 47	akpx:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   628: invokevirtual 266	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   631: invokestatic 271	akpu:a	(Ljava/lang/String;)Lakpu;
    //   634: aload 14
    //   636: iload 5
    //   638: invokeinterface 238 2 0
    //   643: checkcast 240	com/tencent/mobileqq/data/RecentUser
    //   646: getfield 251	com/tencent/mobileqq/data/RecentUser:uin	Ljava/lang/String;
    //   649: aload 14
    //   651: iload 5
    //   653: invokeinterface 238 2 0
    //   658: checkcast 240	com/tencent/mobileqq/data/RecentUser
    //   661: invokevirtual 243	com/tencent/mobileqq/data/RecentUser:getType	()I
    //   664: invokevirtual 274	akpu:a	(Ljava/lang/String;I)Ljava/lang/Object;
    //   667: astore 16
    //   669: iload_1
    //   670: istore_3
    //   671: aload 16
    //   673: monitorenter
    //   674: iload_1
    //   675: istore 6
    //   677: aload_0
    //   678: aload 14
    //   680: iload 5
    //   682: invokeinterface 238 2 0
    //   687: checkcast 240	com/tencent/mobileqq/data/RecentUser
    //   690: invokevirtual 243	com/tencent/mobileqq/data/RecentUser:getType	()I
    //   693: invokevirtual 276	akpx:a	(I)Lakpv;
    //   696: aload 14
    //   698: iload 5
    //   700: invokeinterface 238 2 0
    //   705: checkcast 240	com/tencent/mobileqq/data/RecentUser
    //   708: getfield 251	com/tencent/mobileqq/data/RecentUser:uin	Ljava/lang/String;
    //   711: aload 14
    //   713: iload 5
    //   715: invokeinterface 238 2 0
    //   720: checkcast 240	com/tencent/mobileqq/data/RecentUser
    //   723: invokevirtual 243	com/tencent/mobileqq/data/RecentUser:getType	()I
    //   726: aload 15
    //   728: invokevirtual 279	akpv:b	(Ljava/lang/String;ILaxrr;)Ljava/util/List;
    //   731: astore 17
    //   733: aload 17
    //   735: ifnull +188 -> 923
    //   738: iload_1
    //   739: istore 6
    //   741: aload 17
    //   743: invokeinterface 282 1 0
    //   748: ifne +175 -> 923
    //   751: iload_1
    //   752: istore 6
    //   754: getstatic 283	akrz:jdField_a_of_type_Boolean	Z
    //   757: ifeq +100 -> 857
    //   760: iload_1
    //   761: istore 6
    //   763: aload_0
    //   764: getfield 47	akpx:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   767: invokevirtual 266	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   770: invokestatic 271	akpu:a	(Ljava/lang/String;)Lakpu;
    //   773: invokevirtual 286	akpu:a	()Lcom/tencent/mobileqq/app/msgcache/MsgLruCache;
    //   776: aload 14
    //   778: iload 5
    //   780: invokeinterface 238 2 0
    //   785: checkcast 240	com/tencent/mobileqq/data/RecentUser
    //   788: getfield 251	com/tencent/mobileqq/data/RecentUser:uin	Ljava/lang/String;
    //   791: aload 14
    //   793: iload 5
    //   795: invokeinterface 238 2 0
    //   800: checkcast 240	com/tencent/mobileqq/data/RecentUser
    //   803: invokevirtual 243	com/tencent/mobileqq/data/RecentUser:getType	()I
    //   806: aload 17
    //   808: invokevirtual 289	com/tencent/mobileqq/app/msgcache/MsgLruCache:put	(Ljava/lang/String;ILjava/util/List;)Ljava/util/List;
    //   811: pop
    //   812: iload_1
    //   813: istore 6
    //   815: aload 17
    //   817: invokeinterface 87 1 0
    //   822: istore_3
    //   823: iload_2
    //   824: iconst_1
    //   825: iadd
    //   826: istore_2
    //   827: iload_1
    //   828: iload_3
    //   829: iadd
    //   830: istore_1
    //   831: aload 16
    //   833: monitorexit
    //   834: goto +93 -> 927
    //   837: astore 14
    //   839: iload_1
    //   840: istore_3
    //   841: iload_3
    //   842: istore 6
    //   844: aload 16
    //   846: monitorexit
    //   847: aload 14
    //   849: athrow
    //   850: astore 14
    //   852: iload_3
    //   853: istore_1
    //   854: goto -568 -> 286
    //   857: iload_1
    //   858: istore 6
    //   860: aload_0
    //   861: getfield 47	akpx:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   864: invokevirtual 266	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   867: invokestatic 271	akpu:a	(Ljava/lang/String;)Lakpu;
    //   870: invokevirtual 292	akpu:a	()Ljava/util/concurrent/ConcurrentHashMap;
    //   873: aload 14
    //   875: iload 5
    //   877: invokeinterface 238 2 0
    //   882: checkcast 240	com/tencent/mobileqq/data/RecentUser
    //   885: getfield 251	com/tencent/mobileqq/data/RecentUser:uin	Ljava/lang/String;
    //   888: aload 14
    //   890: iload 5
    //   892: invokeinterface 238 2 0
    //   897: checkcast 240	com/tencent/mobileqq/data/RecentUser
    //   900: invokevirtual 243	com/tencent/mobileqq/data/RecentUser:getType	()I
    //   903: invokestatic 297	akpy:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   906: aload 17
    //   908: invokevirtual 300	java/util/concurrent/ConcurrentHashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   911: pop
    //   912: goto -100 -> 812
    //   915: astore 14
    //   917: iload 6
    //   919: istore_3
    //   920: goto -79 -> 841
    //   923: goto -92 -> 831
    //   926: return
    //   927: iload 5
    //   929: iconst_1
    //   930: iadd
    //   931: istore 5
    //   933: goto -763 -> 170
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	936	0	this	akpx
    //   169	689	1	i	int
    //   1	826	2	j	int
    //   171	749	3	k	int
    //   163	371	4	m	int
    //   166	766	5	n	int
    //   675	243	6	i1	int
    //   21	285	7	l1	long
    //   149	155	9	l2	long
    //   196	39	11	l3	long
    //   154	3	13	bool	boolean
    //   70	445	14	localObject1	Object
    //   524	268	14	localObject2	Object
    //   850	39	14	localException	Exception
    //   915	1	14	localObject4	Object
    //   124	603	15	localaxrr	axrr
    //   667	178	16	localObject5	Object
    //   731	176	17	localList	List
    // Exception table:
    //   from	to	target	type
    //   11	72	524	finally
    //   77	79	524	finally
    //   80	117	524	finally
    //   117	156	524	finally
    //   172	184	524	finally
    //   193	198	524	finally
    //   200	286	524	finally
    //   286	521	524	finally
    //   521	523	524	finally
    //   526	528	524	finally
    //   540	561	524	finally
    //   566	584	524	finally
    //   586	610	524	finally
    //   612	622	524	finally
    //   624	669	524	finally
    //   671	674	524	finally
    //   847	850	524	finally
    //   831	834	837	finally
    //   172	184	850	java/lang/Exception
    //   193	198	850	java/lang/Exception
    //   200	286	850	java/lang/Exception
    //   540	561	850	java/lang/Exception
    //   566	584	850	java/lang/Exception
    //   586	610	850	java/lang/Exception
    //   612	622	850	java/lang/Exception
    //   624	669	850	java/lang/Exception
    //   671	674	850	java/lang/Exception
    //   847	850	850	java/lang/Exception
    //   677	733	915	finally
    //   741	751	915	finally
    //   754	760	915	finally
    //   763	812	915	finally
    //   815	823	915	finally
    //   844	847	915	finally
    //   860	912	915	finally
  }
  
  protected void b()
  {
    this.jdField_a_of_type_Azno.b();
    this.jdField_b_of_type_Azno.b();
    this.jdField_a_of_type_Akpv.b();
    this.c.b();
    akpu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a().clear();
    akpu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
  }
  
  public void c()
  {
    int j = 0;
    if ((akrz.jdField_b_of_type_Boolean) && (!this.jdField_b_of_type_Boolean)) {}
    for (;;)
    {
      List localList1;
      axrr localaxrr1;
      long l1;
      long l2;
      try
      {
        if (!this.jdField_b_of_type_Boolean)
        {
          if (QLog.isColorLevel()) {
            QLog.i("Q.msg.BaseMsgProxyContainer", 2, "init_lazy");
          }
          localList1 = ((ProxyManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(18)).a().a(true);
          if (localList1 == null) {
            return;
          }
          localaxrr1 = new axrr();
          localaxrr1.jdField_a_of_type_Int = 0;
          localaxrr1.jdField_a_of_type_JavaLangString = "select";
          localaxrr1.jdField_b_of_type_JavaLangString = "launch";
          l1 = System.currentTimeMillis();
          k = 0;
          i = 0;
        }
      }
      finally {}
      try
      {
        if ((k < localList1.size()) && (k < 40)) {
          break label397;
        }
        l2 = System.currentTimeMillis();
        QLog.d("Q.msg.BaseMsgProxyContainer_" + MsgLruCache.TAG, 1, new Object[] { "INIT_LAZY cost: ", Long.valueOf(l2 - l1), " msgSize: ", Integer.valueOf(i), " convSize:", Integer.valueOf(j), " adjustSwitch:", Boolean.valueOf(akrz.jdField_b_of_type_Boolean) });
      }
      catch (Exception localException)
      {
        for (;;)
        {
          List localList2;
          break;
          akpu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a().put(akpy.a(((RecentUser)localObject2.get(k)).uin, ((RecentUser)localObject2.get(k)).getType()), localList2);
          continue;
          m = i;
          i = j;
          j = m;
        }
      }
      this.jdField_b_of_type_Boolean = true;
      if ((localaxrr1.jdField_b_of_type_Int != 0) && (axrl.a()))
      {
        ??? = new HashMap();
        ((HashMap)???).put("param_IsMainThread", String.valueOf(localaxrr1.jdField_a_of_type_Int));
        ((HashMap)???).put("param_OptType", localaxrr1.jdField_a_of_type_JavaLangString);
        ((HashMap)???).put("param_OptTotalCost", String.valueOf(localaxrr1.jdField_a_of_type_Long));
        ((HashMap)???).put("param_OptCount", String.valueOf(localaxrr1.jdField_b_of_type_Int));
        ((HashMap)???).put("param_OptMsgCount", String.valueOf(localaxrr1.c));
        ((HashMap)???).put("param_OptOneCost", String.valueOf(localaxrr1.jdField_b_of_type_Long));
        ((HashMap)???).put("param_OptScene", localaxrr1.jdField_b_of_type_JavaLangString);
        ((HashMap)???).put("param_WalSwitch", String.valueOf(akfv.jdField_a_of_type_Boolean));
        axrl.a(BaseApplication.getContext()).a(null, "actSqliteOptCost", true, localaxrr1.c, 0L, (HashMap)???, null, false);
      }
      return;
      label397:
      if (((RecentUser)localList1.get(k)).getType() == 6000)
      {
        m = i;
        i = j;
        j = m;
      }
      else
      {
        if ((((RecentUser)localList1.get(k)).getType() == 0) && (ajsf.N.equals(((RecentUser)localList1.get(k)).uin))) {
          aydb.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
        synchronized (akpu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a(((RecentUser)localList1.get(k)).uin, ((RecentUser)localList1.get(k)).getType()))
        {
          localList2 = a(((RecentUser)localList1.get(k)).getType()).b(((RecentUser)localList1.get(k)).uin, ((RecentUser)localList1.get(k)).getType(), localaxrr2);
          if ((localList2 != null) && (!localList2.isEmpty())) {
            if (akrz.jdField_a_of_type_Boolean)
            {
              akpu.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()).a().put(((RecentUser)localList1.get(k)).uin, ((RecentUser)localList1.get(k)).getType(), localList2);
              int n = localList2.size();
              m = j + 1;
              j = i + n;
              i = m;
            }
          }
        }
        return;
      }
      int m = k + 1;
      int k = j;
      j = i;
      int i = k;
      k = m;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     akpx
 * JD-Core Version:    0.7.0.1
 */
import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.widgets.ScannerView;

public class aats
  extends Handler
{
  public aats(ScannerView paramScannerView, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  /* Error */
  public void handleMessage(android.os.Message paramMessage)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 26	android/os/Message:what	I
    //   4: tableswitch	default:+24 -> 28, 5:+25->29, 6:+1148->1152
    //   29: aload_0
    //   30: getfield 10	aats:a	Lcom/tencent/biz/widgets/ScannerView;
    //   33: astore 12
    //   35: aload 12
    //   37: aload 12
    //   39: getfield 32	com/tencent/biz/widgets/ScannerView:jdField_b_of_type_Long	J
    //   42: lconst_1
    //   43: ladd
    //   44: putfield 32	com/tencent/biz/widgets/ScannerView:jdField_b_of_type_Long	J
    //   47: aload_1
    //   48: getfield 36	android/os/Message:obj	Ljava/lang/Object;
    //   51: ifnull +13 -> 64
    //   54: aload_1
    //   55: getfield 36	android/os/Message:obj	Ljava/lang/Object;
    //   58: instanceof 38
    //   61: ifne +16 -> 77
    //   64: aload_0
    //   65: getfield 10	aats:a	Lcom/tencent/biz/widgets/ScannerView;
    //   68: getfield 41	com/tencent/biz/widgets/ScannerView:jdField_b_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   71: iconst_2
    //   72: invokevirtual 45	android/os/Handler:sendEmptyMessage	(I)Z
    //   75: pop
    //   76: return
    //   77: aload_1
    //   78: getfield 36	android/os/Message:obj	Ljava/lang/Object;
    //   81: checkcast 38	[B
    //   84: checkcast 38	[B
    //   87: astore 13
    //   89: aload_0
    //   90: getfield 10	aats:a	Lcom/tencent/biz/widgets/ScannerView;
    //   93: getfield 48	com/tencent/biz/widgets/ScannerView:h	I
    //   96: iconst_3
    //   97: if_icmpge +49 -> 146
    //   100: iconst_0
    //   101: istore 8
    //   103: aload 13
    //   105: arraylength
    //   106: istore 9
    //   108: iconst_0
    //   109: istore 6
    //   111: iload 8
    //   113: istore 7
    //   115: iload 6
    //   117: iload 9
    //   119: if_icmpge +14 -> 133
    //   122: aload 13
    //   124: iload 6
    //   126: baload
    //   127: ifeq +577 -> 704
    //   130: iconst_1
    //   131: istore 7
    //   133: iload 7
    //   135: ifeq +578 -> 713
    //   138: aload_0
    //   139: getfield 10	aats:a	Lcom/tencent/biz/widgets/ScannerView;
    //   142: iconst_3
    //   143: putfield 48	com/tencent/biz/widgets/ScannerView:h	I
    //   146: aload_0
    //   147: getfield 10	aats:a	Lcom/tencent/biz/widgets/ScannerView;
    //   150: getfield 51	com/tencent/biz/widgets/ScannerView:jdField_b_of_type_AndroidGraphicsRect	Landroid/graphics/Rect;
    //   153: astore_1
    //   154: aload_0
    //   155: getfield 10	aats:a	Lcom/tencent/biz/widgets/ScannerView;
    //   158: getfield 53	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidGraphicsRect	Landroid/graphics/Rect;
    //   161: astore 12
    //   163: aload_1
    //   164: ifnonnull +1068 -> 1232
    //   167: aload 12
    //   169: astore_1
    //   170: aload 12
    //   172: ifnonnull +39 -> 211
    //   175: aload_0
    //   176: getfield 10	aats:a	Lcom/tencent/biz/widgets/ScannerView;
    //   179: astore 12
    //   181: new 55	android/graphics/Rect
    //   184: dup
    //   185: iconst_0
    //   186: iconst_0
    //   187: aload_0
    //   188: getfield 10	aats:a	Lcom/tencent/biz/widgets/ScannerView;
    //   191: getfield 58	com/tencent/biz/widgets/ScannerView:e	I
    //   194: aload_0
    //   195: getfield 10	aats:a	Lcom/tencent/biz/widgets/ScannerView;
    //   198: getfield 61	com/tencent/biz/widgets/ScannerView:f	I
    //   201: invokespecial 64	android/graphics/Rect:<init>	(IIII)V
    //   204: astore_1
    //   205: aload 12
    //   207: aload_1
    //   208: putfield 53	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_AndroidGraphicsRect	Landroid/graphics/Rect;
    //   211: aload_0
    //   212: getfield 10	aats:a	Lcom/tencent/biz/widgets/ScannerView;
    //   215: getfield 67	com/tencent/biz/widgets/ScannerView:g	I
    //   218: bipush 90
    //   220: if_icmpne +534 -> 754
    //   223: aload_0
    //   224: getfield 10	aats:a	Lcom/tencent/biz/widgets/ScannerView;
    //   227: getfield 69	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_Int	I
    //   230: i2f
    //   231: aload_0
    //   232: getfield 10	aats:a	Lcom/tencent/biz/widgets/ScannerView;
    //   235: getfield 61	com/tencent/biz/widgets/ScannerView:f	I
    //   238: i2f
    //   239: fdiv
    //   240: fstore 4
    //   242: aload_0
    //   243: getfield 10	aats:a	Lcom/tencent/biz/widgets/ScannerView;
    //   246: getfield 71	com/tencent/biz/widgets/ScannerView:jdField_b_of_type_Int	I
    //   249: i2f
    //   250: aload_0
    //   251: getfield 10	aats:a	Lcom/tencent/biz/widgets/ScannerView;
    //   254: getfield 58	com/tencent/biz/widgets/ScannerView:e	I
    //   257: i2f
    //   258: fdiv
    //   259: fstore 5
    //   261: new 55	android/graphics/Rect
    //   264: dup
    //   265: aload_1
    //   266: getfield 74	android/graphics/Rect:top	I
    //   269: i2f
    //   270: fload 4
    //   272: fmul
    //   273: f2i
    //   274: aload_0
    //   275: getfield 10	aats:a	Lcom/tencent/biz/widgets/ScannerView;
    //   278: getfield 58	com/tencent/biz/widgets/ScannerView:e	I
    //   281: aload_1
    //   282: getfield 77	android/graphics/Rect:right	I
    //   285: isub
    //   286: i2f
    //   287: fload 5
    //   289: fmul
    //   290: f2i
    //   291: fload 4
    //   293: aload_1
    //   294: getfield 80	android/graphics/Rect:bottom	I
    //   297: i2f
    //   298: fmul
    //   299: f2i
    //   300: aload_0
    //   301: getfield 10	aats:a	Lcom/tencent/biz/widgets/ScannerView;
    //   304: getfield 58	com/tencent/biz/widgets/ScannerView:e	I
    //   307: aload_1
    //   308: getfield 83	android/graphics/Rect:left	I
    //   311: isub
    //   312: i2f
    //   313: fload 5
    //   315: fmul
    //   316: f2i
    //   317: invokespecial 64	android/graphics/Rect:<init>	(IIII)V
    //   320: astore_1
    //   321: aload_0
    //   322: getfield 10	aats:a	Lcom/tencent/biz/widgets/ScannerView;
    //   325: aload_1
    //   326: putfield 51	com/tencent/biz/widgets/ScannerView:jdField_b_of_type_AndroidGraphicsRect	Landroid/graphics/Rect;
    //   329: invokestatic 89	java/lang/System:currentTimeMillis	()J
    //   332: lstore 10
    //   334: iconst_2
    //   335: newarray int
    //   337: astore 14
    //   339: aload_1
    //   340: invokevirtual 93	android/graphics/Rect:width	()I
    //   343: aload_1
    //   344: invokevirtual 96	android/graphics/Rect:height	()I
    //   347: imul
    //   348: iconst_3
    //   349: imul
    //   350: iconst_1
    //   351: ishr
    //   352: newarray byte
    //   354: astore 12
    //   356: aload 12
    //   358: ifnull +868 -> 1226
    //   361: aload_0
    //   362: getfield 10	aats:a	Lcom/tencent/biz/widgets/ScannerView;
    //   365: getfield 69	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_Int	I
    //   368: ifle +858 -> 1226
    //   371: aload_0
    //   372: getfield 10	aats:a	Lcom/tencent/biz/widgets/ScannerView;
    //   375: getfield 71	com/tencent/biz/widgets/ScannerView:jdField_b_of_type_Int	I
    //   378: ifle +848 -> 1226
    //   381: aload_1
    //   382: getfield 83	android/graphics/Rect:left	I
    //   385: iflt +841 -> 1226
    //   388: aload_1
    //   389: getfield 74	android/graphics/Rect:top	I
    //   392: iflt +834 -> 1226
    //   395: aload_1
    //   396: invokevirtual 93	android/graphics/Rect:width	()I
    //   399: ifle +827 -> 1226
    //   402: aload_1
    //   403: invokevirtual 96	android/graphics/Rect:height	()I
    //   406: ifle +820 -> 1226
    //   409: aload_1
    //   410: getfield 77	android/graphics/Rect:right	I
    //   413: aload_0
    //   414: getfield 10	aats:a	Lcom/tencent/biz/widgets/ScannerView;
    //   417: getfield 69	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_Int	I
    //   420: if_icmpgt +806 -> 1226
    //   423: aload_1
    //   424: getfield 80	android/graphics/Rect:bottom	I
    //   427: aload_0
    //   428: getfield 10	aats:a	Lcom/tencent/biz/widgets/ScannerView;
    //   431: getfield 71	com/tencent/biz/widgets/ScannerView:jdField_b_of_type_Int	I
    //   434: if_icmpgt +792 -> 1226
    //   437: aload 13
    //   439: arraylength
    //   440: aload_0
    //   441: getfield 10	aats:a	Lcom/tencent/biz/widgets/ScannerView;
    //   444: getfield 69	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_Int	I
    //   447: aload_0
    //   448: getfield 10	aats:a	Lcom/tencent/biz/widgets/ScannerView;
    //   451: getfield 71	com/tencent/biz/widgets/ScannerView:jdField_b_of_type_Int	I
    //   454: imul
    //   455: iconst_3
    //   456: imul
    //   457: iconst_1
    //   458: ishr
    //   459: if_icmpne +767 -> 1226
    //   462: aload 12
    //   464: aload 14
    //   466: aload 13
    //   468: aload_0
    //   469: getfield 10	aats:a	Lcom/tencent/biz/widgets/ScannerView;
    //   472: getfield 69	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_Int	I
    //   475: aload_0
    //   476: getfield 10	aats:a	Lcom/tencent/biz/widgets/ScannerView;
    //   479: getfield 71	com/tencent/biz/widgets/ScannerView:jdField_b_of_type_Int	I
    //   482: aload_1
    //   483: getfield 83	android/graphics/Rect:left	I
    //   486: aload_1
    //   487: getfield 74	android/graphics/Rect:top	I
    //   490: aload_1
    //   491: invokevirtual 93	android/graphics/Rect:width	()I
    //   494: aload_1
    //   495: invokevirtual 96	android/graphics/Rect:height	()I
    //   498: aload_0
    //   499: getfield 10	aats:a	Lcom/tencent/biz/widgets/ScannerView;
    //   502: getfield 67	com/tencent/biz/widgets/ScannerView:g	I
    //   505: iconst_0
    //   506: invokestatic 102	com/tencent/imageboost/ImgProcessScan:gray_rotate_crop_sub	([B[I[BIIIIIIII)I
    //   509: ifne +717 -> 1226
    //   512: aload 12
    //   514: aload 14
    //   516: iconst_0
    //   517: iaload
    //   518: aload 14
    //   520: iconst_1
    //   521: iaload
    //   522: iconst_0
    //   523: invokestatic 107	bjuq:b	([BIII)I
    //   526: istore 6
    //   528: invokestatic 89	java/lang/System:currentTimeMillis	()J
    //   531: lload 10
    //   533: lsub
    //   534: l2d
    //   535: dstore_2
    //   536: iload 6
    //   538: istore 7
    //   540: invokestatic 113	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   543: ifeq +32 -> 575
    //   546: ldc 115
    //   548: iconst_4
    //   549: new 117	java/lang/StringBuilder
    //   552: dup
    //   553: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   556: ldc 122
    //   558: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   561: dload_2
    //   562: invokevirtual 129	java/lang/StringBuilder:append	(D)Ljava/lang/StringBuilder;
    //   565: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   568: invokestatic 137	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   571: iload 6
    //   573: istore 7
    //   575: iload 7
    //   577: iconst_1
    //   578: if_icmpne +561 -> 1139
    //   581: new 117	java/lang/StringBuilder
    //   584: dup
    //   585: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   588: astore_1
    //   589: new 117	java/lang/StringBuilder
    //   592: dup
    //   593: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   596: astore 12
    //   598: aload_1
    //   599: aload 12
    //   601: invokestatic 140	bjuq:a	(Ljava/lang/StringBuilder;Ljava/lang/StringBuilder;)I
    //   604: pop
    //   605: aconst_null
    //   606: ldc 142
    //   608: ldc 144
    //   610: ldc 146
    //   612: ldc 148
    //   614: ldc 150
    //   616: iconst_0
    //   617: iconst_0
    //   618: new 117	java/lang/StringBuilder
    //   621: dup
    //   622: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   625: ldc 146
    //   627: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   630: invokestatic 89	java/lang/System:currentTimeMillis	()J
    //   633: aload_0
    //   634: getfield 10	aats:a	Lcom/tencent/biz/widgets/ScannerView;
    //   637: getfield 152	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_Long	J
    //   640: lsub
    //   641: invokevirtual 155	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   644: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   647: new 117	java/lang/StringBuilder
    //   650: dup
    //   651: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   654: ldc 146
    //   656: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   659: aload_0
    //   660: getfield 10	aats:a	Lcom/tencent/biz/widgets/ScannerView;
    //   663: getfield 32	com/tencent/biz/widgets/ScannerView:jdField_b_of_type_Long	J
    //   666: invokevirtual 155	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   669: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   672: ldc 146
    //   674: ldc 146
    //   676: invokestatic 160	bdla:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   679: aload_0
    //   680: getfield 10	aats:a	Lcom/tencent/biz/widgets/ScannerView;
    //   683: aload_1
    //   684: putfield 163	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_JavaLangStringBuilder	Ljava/lang/StringBuilder;
    //   687: aload_0
    //   688: getfield 10	aats:a	Lcom/tencent/biz/widgets/ScannerView;
    //   691: getfield 41	com/tencent/biz/widgets/ScannerView:jdField_b_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   694: iconst_1
    //   695: aload 12
    //   697: invokevirtual 167	android/os/Handler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   700: invokevirtual 170	android/os/Message:sendToTarget	()V
    //   703: return
    //   704: iload 6
    //   706: iconst_1
    //   707: iadd
    //   708: istore 6
    //   710: goto -599 -> 111
    //   713: aload_0
    //   714: getfield 10	aats:a	Lcom/tencent/biz/widgets/ScannerView;
    //   717: astore_1
    //   718: aload_1
    //   719: getfield 48	com/tencent/biz/widgets/ScannerView:h	I
    //   722: iconst_1
    //   723: iadd
    //   724: istore 6
    //   726: aload_1
    //   727: iload 6
    //   729: putfield 48	com/tencent/biz/widgets/ScannerView:h	I
    //   732: iload 6
    //   734: iconst_3
    //   735: if_icmpne -589 -> 146
    //   738: aload_0
    //   739: getfield 10	aats:a	Lcom/tencent/biz/widgets/ScannerView;
    //   742: getfield 41	com/tencent/biz/widgets/ScannerView:jdField_b_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   745: bipush 9
    //   747: invokevirtual 45	android/os/Handler:sendEmptyMessage	(I)Z
    //   750: pop
    //   751: goto -605 -> 146
    //   754: aload_0
    //   755: getfield 10	aats:a	Lcom/tencent/biz/widgets/ScannerView;
    //   758: getfield 67	com/tencent/biz/widgets/ScannerView:g	I
    //   761: sipush 180
    //   764: if_icmpne +120 -> 884
    //   767: aload_0
    //   768: getfield 10	aats:a	Lcom/tencent/biz/widgets/ScannerView;
    //   771: getfield 69	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_Int	I
    //   774: i2f
    //   775: aload_0
    //   776: getfield 10	aats:a	Lcom/tencent/biz/widgets/ScannerView;
    //   779: getfield 58	com/tencent/biz/widgets/ScannerView:e	I
    //   782: i2f
    //   783: fdiv
    //   784: fstore 4
    //   786: aload_0
    //   787: getfield 10	aats:a	Lcom/tencent/biz/widgets/ScannerView;
    //   790: getfield 71	com/tencent/biz/widgets/ScannerView:jdField_b_of_type_Int	I
    //   793: i2f
    //   794: aload_0
    //   795: getfield 10	aats:a	Lcom/tencent/biz/widgets/ScannerView;
    //   798: getfield 61	com/tencent/biz/widgets/ScannerView:f	I
    //   801: i2f
    //   802: fdiv
    //   803: fstore 5
    //   805: new 55	android/graphics/Rect
    //   808: dup
    //   809: aload_0
    //   810: getfield 10	aats:a	Lcom/tencent/biz/widgets/ScannerView;
    //   813: getfield 58	com/tencent/biz/widgets/ScannerView:e	I
    //   816: aload_1
    //   817: getfield 77	android/graphics/Rect:right	I
    //   820: isub
    //   821: i2f
    //   822: fload 4
    //   824: fmul
    //   825: f2i
    //   826: aload_0
    //   827: getfield 10	aats:a	Lcom/tencent/biz/widgets/ScannerView;
    //   830: getfield 61	com/tencent/biz/widgets/ScannerView:f	I
    //   833: aload_1
    //   834: getfield 80	android/graphics/Rect:bottom	I
    //   837: isub
    //   838: i2f
    //   839: fload 5
    //   841: fmul
    //   842: f2i
    //   843: fload 4
    //   845: aload_0
    //   846: getfield 10	aats:a	Lcom/tencent/biz/widgets/ScannerView;
    //   849: getfield 58	com/tencent/biz/widgets/ScannerView:e	I
    //   852: aload_1
    //   853: getfield 83	android/graphics/Rect:left	I
    //   856: isub
    //   857: i2f
    //   858: fmul
    //   859: f2i
    //   860: aload_0
    //   861: getfield 10	aats:a	Lcom/tencent/biz/widgets/ScannerView;
    //   864: getfield 61	com/tencent/biz/widgets/ScannerView:f	I
    //   867: aload_1
    //   868: getfield 74	android/graphics/Rect:top	I
    //   871: isub
    //   872: i2f
    //   873: fload 5
    //   875: fmul
    //   876: f2i
    //   877: invokespecial 64	android/graphics/Rect:<init>	(IIII)V
    //   880: astore_1
    //   881: goto -560 -> 321
    //   884: aload_0
    //   885: getfield 10	aats:a	Lcom/tencent/biz/widgets/ScannerView;
    //   888: getfield 67	com/tencent/biz/widgets/ScannerView:g	I
    //   891: sipush 270
    //   894: if_icmpne +104 -> 998
    //   897: aload_0
    //   898: getfield 10	aats:a	Lcom/tencent/biz/widgets/ScannerView;
    //   901: getfield 69	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_Int	I
    //   904: i2f
    //   905: aload_0
    //   906: getfield 10	aats:a	Lcom/tencent/biz/widgets/ScannerView;
    //   909: getfield 61	com/tencent/biz/widgets/ScannerView:f	I
    //   912: i2f
    //   913: fdiv
    //   914: fstore 4
    //   916: aload_0
    //   917: getfield 10	aats:a	Lcom/tencent/biz/widgets/ScannerView;
    //   920: getfield 71	com/tencent/biz/widgets/ScannerView:jdField_b_of_type_Int	I
    //   923: i2f
    //   924: aload_0
    //   925: getfield 10	aats:a	Lcom/tencent/biz/widgets/ScannerView;
    //   928: getfield 58	com/tencent/biz/widgets/ScannerView:e	I
    //   931: i2f
    //   932: fdiv
    //   933: fstore 5
    //   935: new 55	android/graphics/Rect
    //   938: dup
    //   939: aload_0
    //   940: getfield 10	aats:a	Lcom/tencent/biz/widgets/ScannerView;
    //   943: getfield 61	com/tencent/biz/widgets/ScannerView:f	I
    //   946: aload_1
    //   947: getfield 80	android/graphics/Rect:bottom	I
    //   950: isub
    //   951: i2f
    //   952: fload 4
    //   954: fmul
    //   955: f2i
    //   956: aload_1
    //   957: getfield 83	android/graphics/Rect:left	I
    //   960: i2f
    //   961: fload 5
    //   963: fmul
    //   964: f2i
    //   965: fload 4
    //   967: aload_0
    //   968: getfield 10	aats:a	Lcom/tencent/biz/widgets/ScannerView;
    //   971: getfield 61	com/tencent/biz/widgets/ScannerView:f	I
    //   974: aload_1
    //   975: getfield 74	android/graphics/Rect:top	I
    //   978: isub
    //   979: i2f
    //   980: fmul
    //   981: f2i
    //   982: aload_1
    //   983: getfield 77	android/graphics/Rect:right	I
    //   986: i2f
    //   987: fload 5
    //   989: fmul
    //   990: f2i
    //   991: invokespecial 64	android/graphics/Rect:<init>	(IIII)V
    //   994: astore_1
    //   995: goto -674 -> 321
    //   998: aload_0
    //   999: getfield 10	aats:a	Lcom/tencent/biz/widgets/ScannerView;
    //   1002: getfield 69	com/tencent/biz/widgets/ScannerView:jdField_a_of_type_Int	I
    //   1005: i2f
    //   1006: aload_0
    //   1007: getfield 10	aats:a	Lcom/tencent/biz/widgets/ScannerView;
    //   1010: getfield 58	com/tencent/biz/widgets/ScannerView:e	I
    //   1013: i2f
    //   1014: fdiv
    //   1015: fstore 4
    //   1017: aload_0
    //   1018: getfield 10	aats:a	Lcom/tencent/biz/widgets/ScannerView;
    //   1021: getfield 71	com/tencent/biz/widgets/ScannerView:jdField_b_of_type_Int	I
    //   1024: i2f
    //   1025: aload_0
    //   1026: getfield 10	aats:a	Lcom/tencent/biz/widgets/ScannerView;
    //   1029: getfield 61	com/tencent/biz/widgets/ScannerView:f	I
    //   1032: i2f
    //   1033: fdiv
    //   1034: fstore 5
    //   1036: new 55	android/graphics/Rect
    //   1039: dup
    //   1040: aload_1
    //   1041: getfield 83	android/graphics/Rect:left	I
    //   1044: i2f
    //   1045: fload 4
    //   1047: fmul
    //   1048: f2i
    //   1049: aload_1
    //   1050: getfield 74	android/graphics/Rect:top	I
    //   1053: i2f
    //   1054: fload 5
    //   1056: fmul
    //   1057: f2i
    //   1058: fload 4
    //   1060: aload_1
    //   1061: getfield 77	android/graphics/Rect:right	I
    //   1064: i2f
    //   1065: fmul
    //   1066: f2i
    //   1067: aload_1
    //   1068: getfield 80	android/graphics/Rect:bottom	I
    //   1071: i2f
    //   1072: fload 5
    //   1074: fmul
    //   1075: f2i
    //   1076: invokespecial 64	android/graphics/Rect:<init>	(IIII)V
    //   1079: astore_1
    //   1080: goto -759 -> 321
    //   1083: astore 12
    //   1085: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1088: ifeq +14 -> 1102
    //   1091: ldc 115
    //   1093: iconst_2
    //   1094: aload 12
    //   1096: invokevirtual 174	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   1099: invokestatic 177	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1102: aconst_null
    //   1103: astore 12
    //   1105: goto -749 -> 356
    //   1108: astore_1
    //   1109: iconst_0
    //   1110: istore 6
    //   1112: iload 6
    //   1114: istore 7
    //   1116: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1119: ifeq -544 -> 575
    //   1122: ldc 115
    //   1124: iconst_2
    //   1125: aload_1
    //   1126: invokevirtual 178	java/lang/UnsatisfiedLinkError:toString	()Ljava/lang/String;
    //   1129: invokestatic 177	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1132: iload 6
    //   1134: istore 7
    //   1136: goto -561 -> 575
    //   1139: aload_0
    //   1140: getfield 10	aats:a	Lcom/tencent/biz/widgets/ScannerView;
    //   1143: getfield 41	com/tencent/biz/widgets/ScannerView:jdField_b_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   1146: iconst_2
    //   1147: invokevirtual 45	android/os/Handler:sendEmptyMessage	(I)Z
    //   1150: pop
    //   1151: return
    //   1152: aconst_null
    //   1153: astore 12
    //   1155: aload_1
    //   1156: getfield 36	android/os/Message:obj	Ljava/lang/Object;
    //   1159: instanceof 180
    //   1162: ifeq +22 -> 1184
    //   1165: aload_1
    //   1166: getfield 36	android/os/Message:obj	Ljava/lang/Object;
    //   1169: checkcast 180	android/net/Uri
    //   1172: aload_0
    //   1173: getfield 10	aats:a	Lcom/tencent/biz/widgets/ScannerView;
    //   1176: invokevirtual 184	com/tencent/biz/widgets/ScannerView:getContext	()Landroid/content/Context;
    //   1179: invokestatic 189	zmk:a	(Landroid/net/Uri;Landroid/content/Context;)Landroid/util/Pair;
    //   1182: astore 12
    //   1184: aload 12
    //   1186: ifnull +23 -> 1209
    //   1189: aload_0
    //   1190: getfield 10	aats:a	Lcom/tencent/biz/widgets/ScannerView;
    //   1193: getfield 41	com/tencent/biz/widgets/ScannerView:jdField_b_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   1196: iconst_3
    //   1197: aload 12
    //   1199: getfield 194	android/util/Pair:first	Ljava/lang/Object;
    //   1202: invokevirtual 167	android/os/Handler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   1205: invokevirtual 170	android/os/Message:sendToTarget	()V
    //   1208: return
    //   1209: aload_0
    //   1210: getfield 10	aats:a	Lcom/tencent/biz/widgets/ScannerView;
    //   1213: getfield 41	com/tencent/biz/widgets/ScannerView:jdField_b_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   1216: iconst_4
    //   1217: invokevirtual 45	android/os/Handler:sendEmptyMessage	(I)Z
    //   1220: pop
    //   1221: return
    //   1222: astore_1
    //   1223: goto -111 -> 1112
    //   1226: iconst_0
    //   1227: istore 6
    //   1229: goto -701 -> 528
    //   1232: goto -903 -> 329
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1235	0	this	aats
    //   0	1235	1	paramMessage	android.os.Message
    //   535	27	2	d	double
    //   240	819	4	f1	float
    //   259	814	5	f2	float
    //   109	1119	6	i	int
    //   113	1022	7	j	int
    //   101	11	8	k	int
    //   106	14	9	m	int
    //   332	200	10	l	long
    //   33	663	12	localObject	java.lang.Object
    //   1083	12	12	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   1103	95	12	localPair	android.util.Pair
    //   87	380	13	arrayOfByte	byte[]
    //   337	182	14	arrayOfInt	int[]
    // Exception table:
    //   from	to	target	type
    //   339	356	1083	java/lang/OutOfMemoryError
    //   329	339	1108	java/lang/UnsatisfiedLinkError
    //   339	356	1108	java/lang/UnsatisfiedLinkError
    //   361	528	1108	java/lang/UnsatisfiedLinkError
    //   1085	1102	1108	java/lang/UnsatisfiedLinkError
    //   528	536	1222	java/lang/UnsatisfiedLinkError
    //   540	571	1222	java/lang/UnsatisfiedLinkError
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aats
 * JD-Core Version:    0.7.0.1
 */
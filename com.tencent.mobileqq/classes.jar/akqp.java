import android.os.Build.VERSION;
import android.util.Xml;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

public class akqp
{
  private static akqt a;
  
  static
  {
    akqx localakqx = new akqx();
    if ((akqo.a("HUAWEI")) && (Build.VERSION.SDK_INT >= 23) && (akke.a())) {
      a = localakqx;
    }
  }
  
  /* Error */
  public static int a(akqt paramakqt, String paramString)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnull +14 -> 18
    //   7: aload_1
    //   8: invokestatic 38	baip:a	(Ljava/lang/String;)Z
    //   11: istore 4
    //   13: iload 4
    //   15: ifeq +11 -> 26
    //   18: bipush 252
    //   20: istore_2
    //   21: ldc 2
    //   23: monitorexit
    //   24: iload_2
    //   25: ireturn
    //   26: aload_0
    //   27: invokeinterface 43 1 0
    //   32: astore 5
    //   34: aload_0
    //   35: invokeinterface 46 1 0
    //   40: astore_0
    //   41: aload 5
    //   43: aload_0
    //   44: aload 5
    //   46: aload_0
    //   47: aload 5
    //   49: invokestatic 51	akno:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   52: aload_1
    //   53: invokestatic 54	akno:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   56: istore_3
    //   57: iload_3
    //   58: istore_2
    //   59: invokestatic 59	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   62: ifeq -41 -> 21
    //   65: ldc 61
    //   67: iconst_2
    //   68: new 63	java/lang/StringBuilder
    //   71: dup
    //   72: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   75: ldc 66
    //   77: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: aload_1
    //   81: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: ldc 72
    //   86: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: iload_3
    //   90: invokevirtual 75	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   93: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: invokestatic 82	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   99: iload_3
    //   100: istore_2
    //   101: goto -80 -> 21
    //   104: astore_0
    //   105: ldc 2
    //   107: monitorexit
    //   108: aload_0
    //   109: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	110	0	paramakqt	akqt
    //   0	110	1	paramString	String
    //   20	81	2	i	int
    //   56	44	3	j	int
    //   11	3	4	bool	boolean
    //   32	16	5	str	String
    // Exception table:
    //   from	to	target	type
    //   7	13	104	finally
    //   26	57	104	finally
    //   59	99	104	finally
  }
  
  /* Error */
  public static int a(akqt paramakqt, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: aload_0
    //   4: ifnull +21 -> 25
    //   7: aload_1
    //   8: invokestatic 38	baip:a	(Ljava/lang/String;)Z
    //   11: ifne +14 -> 25
    //   14: aload_2
    //   15: invokestatic 38	baip:a	(Ljava/lang/String;)Z
    //   18: istore 4
    //   20: iload 4
    //   22: ifeq +10 -> 32
    //   25: iconst_m1
    //   26: istore_3
    //   27: ldc 2
    //   29: monitorexit
    //   30: iload_3
    //   31: ireturn
    //   32: aload_0
    //   33: invokeinterface 43 1 0
    //   38: astore 5
    //   40: aload_0
    //   41: invokeinterface 46 1 0
    //   46: astore 6
    //   48: aload_0
    //   49: invokeinterface 90 1 0
    //   54: astore 8
    //   56: aload_0
    //   57: invokeinterface 93 1 0
    //   62: astore 7
    //   64: aload 7
    //   66: ifnull +730 -> 796
    //   69: aload 7
    //   71: invokeinterface 99 1 0
    //   76: ifne +6 -> 82
    //   79: goto +717 -> 796
    //   82: ldc 61
    //   84: iconst_2
    //   85: new 63	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   92: ldc 101
    //   94: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: aload_1
    //   98: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: ldc 103
    //   103: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: aload_2
    //   107: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: invokestatic 106	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   116: aload 5
    //   118: aload 6
    //   120: aload 5
    //   122: aload_2
    //   123: invokestatic 109	akno:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   126: aload_1
    //   127: aload 5
    //   129: aload 6
    //   131: aload 5
    //   133: aload 6
    //   135: aload 5
    //   137: invokestatic 51	akno:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   140: invokestatic 111	akno:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   143: invokestatic 116	aknk:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   146: new 63	java/lang/StringBuilder
    //   149: dup
    //   150: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   153: aload 5
    //   155: aload 6
    //   157: aload 5
    //   159: aload 6
    //   161: aload 5
    //   163: invokestatic 51	akno:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   166: invokestatic 111	akno:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   169: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: getstatic 122	java/io/File:separator	Ljava/lang/String;
    //   175: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: aload 8
    //   180: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   186: astore_0
    //   187: new 118	java/io/File
    //   190: dup
    //   191: aload_0
    //   192: invokespecial 125	java/io/File:<init>	(Ljava/lang/String;)V
    //   195: astore_2
    //   196: aload_2
    //   197: invokevirtual 128	java/io/File:exists	()Z
    //   200: ifeq +525 -> 725
    //   203: new 130	java/util/HashMap
    //   206: dup
    //   207: invokespecial 131	java/util/HashMap:<init>	()V
    //   210: pop
    //   211: aload_2
    //   212: invokestatic 136	bace:b	(Ljava/io/File;)Ljava/lang/String;
    //   215: aload 7
    //   217: invokestatic 139	akqp:a	(Ljava/lang/String;Ljava/util/List;)Ljava/util/HashMap;
    //   220: astore_0
    //   221: aload_0
    //   222: invokevirtual 140	java/util/HashMap:size	()I
    //   225: ifle +470 -> 695
    //   228: aload_0
    //   229: invokevirtual 144	java/util/HashMap:entrySet	()Ljava/util/Set;
    //   232: invokeinterface 150 1 0
    //   237: astore_1
    //   238: aload_1
    //   239: invokeinterface 155 1 0
    //   244: ifeq +522 -> 766
    //   247: aload_1
    //   248: invokeinterface 159 1 0
    //   253: checkcast 161	java/util/Map$Entry
    //   256: astore_2
    //   257: ldc 163
    //   259: astore_0
    //   260: aload_2
    //   261: invokeinterface 166 1 0
    //   266: checkcast 168	java/lang/String
    //   269: astore 8
    //   271: aload 7
    //   273: aload 8
    //   275: invokeinterface 172 2 0
    //   280: ifeq +67 -> 347
    //   283: new 63	java/lang/StringBuilder
    //   286: dup
    //   287: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   290: aload 5
    //   292: aload 6
    //   294: aload 5
    //   296: aload 6
    //   298: aload 5
    //   300: invokestatic 51	akno:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   303: invokestatic 111	akno:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   306: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: getstatic 122	java/io/File:separator	Ljava/lang/String;
    //   312: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: aload 8
    //   317: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: ldc 174
    //   322: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   328: astore_0
    //   329: aload 5
    //   331: aload 6
    //   333: aload 8
    //   335: aload_2
    //   336: invokeinterface 177 1 0
    //   341: checkcast 168	java/lang/String
    //   344: invokestatic 109	akno:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   347: new 118	java/io/File
    //   350: dup
    //   351: aload_0
    //   352: invokespecial 125	java/io/File:<init>	(Ljava/lang/String;)V
    //   355: astore 8
    //   357: ldc 61
    //   359: iconst_2
    //   360: new 63	java/lang/StringBuilder
    //   363: dup
    //   364: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   367: ldc 179
    //   369: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: aload_0
    //   373: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   379: invokestatic 106	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   382: aload 8
    //   384: invokevirtual 128	java/io/File:exists	()Z
    //   387: ifeq +267 -> 654
    //   390: aload_0
    //   391: invokestatic 184	attn:a	(Ljava/lang/String;)Ljava/lang/String;
    //   394: astore 9
    //   396: aload_2
    //   397: invokeinterface 177 1 0
    //   402: checkcast 168	java/lang/String
    //   405: astore_2
    //   406: aload_2
    //   407: aload 9
    //   409: invokevirtual 187	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   412: ifne -174 -> 238
    //   415: aload 8
    //   417: invokevirtual 190	java/io/File:delete	()Z
    //   420: pop
    //   421: ldc 61
    //   423: iconst_2
    //   424: new 63	java/lang/StringBuilder
    //   427: dup
    //   428: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   431: ldc 192
    //   433: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: bipush 253
    //   438: invokevirtual 75	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   441: ldc 194
    //   443: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   446: aload_0
    //   447: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   450: ldc 196
    //   452: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   455: aload 9
    //   457: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   460: ldc 198
    //   462: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: aload_2
    //   466: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   472: invokestatic 106	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   475: bipush 253
    //   477: istore_3
    //   478: goto -451 -> 27
    //   481: astore_0
    //   482: bipush 250
    //   484: istore_3
    //   485: aload 5
    //   487: aload 6
    //   489: aload 5
    //   491: aload 6
    //   493: aload 5
    //   495: invokestatic 51	akno:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   498: invokestatic 111	akno:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   501: iconst_0
    //   502: invokestatic 201	bace:a	(Ljava/lang/String;Z)V
    //   505: new 118	java/io/File
    //   508: dup
    //   509: aload_1
    //   510: invokespecial 125	java/io/File:<init>	(Ljava/lang/String;)V
    //   513: astore_0
    //   514: aload_0
    //   515: invokevirtual 128	java/io/File:exists	()Z
    //   518: ifeq +8 -> 526
    //   521: aload_0
    //   522: invokevirtual 190	java/io/File:delete	()Z
    //   525: pop
    //   526: ldc 61
    //   528: iconst_2
    //   529: new 63	java/lang/StringBuilder
    //   532: dup
    //   533: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   536: ldc 203
    //   538: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   541: bipush 250
    //   543: invokevirtual 75	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   546: ldc 205
    //   548: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   551: aload_1
    //   552: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   555: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   558: invokestatic 106	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   561: goto -534 -> 27
    //   564: astore_0
    //   565: ldc 2
    //   567: monitorexit
    //   568: aload_0
    //   569: athrow
    //   570: astore_0
    //   571: bipush 251
    //   573: istore_3
    //   574: ldc 61
    //   576: iconst_2
    //   577: new 63	java/lang/StringBuilder
    //   580: dup
    //   581: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   584: ldc 207
    //   586: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   589: bipush 251
    //   591: invokevirtual 75	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   594: ldc 205
    //   596: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   599: aload_1
    //   600: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   603: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   606: invokestatic 106	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   609: goto -582 -> 27
    //   612: astore_0
    //   613: bipush 251
    //   615: istore_3
    //   616: ldc 61
    //   618: iconst_2
    //   619: new 63	java/lang/StringBuilder
    //   622: dup
    //   623: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   626: ldc 207
    //   628: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   631: bipush 251
    //   633: invokevirtual 75	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   636: ldc 205
    //   638: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   641: aload_1
    //   642: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   645: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   648: invokestatic 106	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   651: goto -624 -> 27
    //   654: bipush 254
    //   656: istore_3
    //   657: ldc 61
    //   659: iconst_2
    //   660: new 63	java/lang/StringBuilder
    //   663: dup
    //   664: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   667: ldc 209
    //   669: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   672: bipush 254
    //   674: invokevirtual 75	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   677: ldc 194
    //   679: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   682: aload_0
    //   683: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   686: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   689: invokestatic 106	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   692: goto -665 -> 27
    //   695: iconst_m1
    //   696: istore_3
    //   697: ldc 61
    //   699: iconst_2
    //   700: new 63	java/lang/StringBuilder
    //   703: dup
    //   704: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   707: ldc 211
    //   709: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   712: iconst_m1
    //   713: invokevirtual 75	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   716: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   719: invokestatic 106	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   722: goto -695 -> 27
    //   725: bipush 254
    //   727: istore_3
    //   728: ldc 61
    //   730: iconst_2
    //   731: new 63	java/lang/StringBuilder
    //   734: dup
    //   735: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   738: ldc 209
    //   740: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   743: bipush 254
    //   745: invokevirtual 75	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   748: ldc 213
    //   750: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   753: aload_0
    //   754: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   757: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   760: invokestatic 106	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   763: goto -736 -> 27
    //   766: iconst_0
    //   767: istore_3
    //   768: ldc 61
    //   770: iconst_2
    //   771: new 63	java/lang/StringBuilder
    //   774: dup
    //   775: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   778: ldc 215
    //   780: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   783: iconst_0
    //   784: invokevirtual 75	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   787: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   790: invokestatic 106	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   793: goto -766 -> 27
    //   796: iconst_m1
    //   797: istore_3
    //   798: goto -771 -> 27
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	801	0	paramakqt	akqt
    //   0	801	1	paramString1	String
    //   0	801	2	paramString2	String
    //   26	772	3	i	int
    //   18	3	4	bool	boolean
    //   38	456	5	str1	String
    //   46	446	6	str2	String
    //   62	210	7	localList	List
    //   54	362	8	localObject	Object
    //   394	62	9	str3	String
    // Exception table:
    //   from	to	target	type
    //   126	146	481	java/io/IOException
    //   7	20	564	finally
    //   32	64	564	finally
    //   69	79	564	finally
    //   82	126	564	finally
    //   126	146	564	finally
    //   146	211	564	finally
    //   211	221	564	finally
    //   221	238	564	finally
    //   238	257	564	finally
    //   260	271	564	finally
    //   271	347	564	finally
    //   347	475	564	finally
    //   485	526	564	finally
    //   526	561	564	finally
    //   574	609	564	finally
    //   616	651	564	finally
    //   657	692	564	finally
    //   697	722	564	finally
    //   728	763	564	finally
    //   768	793	564	finally
    //   211	221	570	java/io/IOException
    //   211	221	612	java/lang/OutOfMemoryError
  }
  
  public static akqt a()
  {
    return a;
  }
  
  private static HashMap<String, String> a(String paramString, List<String> paramList)
  {
    HashMap localHashMap = new HashMap();
    for (;;)
    {
      try
      {
        localXmlPullParser = Xml.newPullParser();
        localXmlPullParser.setInput(new ByteArrayInputStream(paramString.getBytes()), "UTF-8");
        i = localXmlPullParser.getEventType();
      }
      catch (Exception paramList)
      {
        XmlPullParser localXmlPullParser;
        QLog.e("ArCoreNativeSoManager", 2, "parseSoMd5FromXmlConfig failed. error = " + paramList.getMessage() + ", xmlConfigContent = " + paramString);
        return localHashMap;
      }
      int i = localXmlPullParser.next();
      break label162;
      str = localXmlPullParser.getName();
      if (paramList.contains(str))
      {
        localHashMap.put(str, localXmlPullParser.nextText());
        label162:
        while (i == 1)
        {
          String str;
          QLog.d("ArCoreNativeSoManager", 2, "parseSoMd5FromXmlConfig successfully. soMd5List = " + localHashMap);
          return localHashMap;
        }
        switch (i)
        {
        }
      }
    }
  }
  
  public static boolean a(akqt paramakqt)
  {
    if (paramakqt == null) {
      return false;
    }
    Object localObject = paramakqt.a();
    if ((localObject == null) || (((List)localObject).size() == 0)) {
      return false;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      if (!a(paramakqt, (String)((Iterator)localObject).next())) {
        return false;
      }
    }
    return true;
  }
  
  public static boolean a(akqt paramakqt, String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramakqt != null) {}
    for (;;)
    {
      try
      {
        bool1 = baip.a(paramString);
        if (bool1)
        {
          bool1 = bool2;
          return bool1;
        }
        String str1 = paramakqt.a();
        String str2 = paramakqt.b();
        paramakqt = akno.a(str1, str2, akno.b(str1, str2, str1)) + File.separator + paramString + ".so";
        File localFile = new File(paramakqt);
        if (QLog.isColorLevel()) {
          QLog.d("ArCoreNativeSoManager", 2, "isSoFileExist soFile=" + paramakqt + ", exist=" + localFile.exists());
        }
        if (localFile.exists())
        {
          paramString = akno.b(str1, str2, paramString);
          str1 = attn.a(paramakqt);
          if (paramString.equalsIgnoreCase(str1))
          {
            bool1 = true;
            continue;
          }
          QLog.i("ArCoreNativeSoManager", 2, "isSoFileExist. check md5 failed. soFilename = " + paramakqt + ", md5FromConfig = " + paramString + ", md5FromCalc = " + str1);
          bool1 = bool2;
          continue;
        }
        QLog.i("ArCoreNativeSoManager", 2, "isSoFileExist. so not exist. soFilename = " + paramakqt);
      }
      finally {}
      bool1 = bool2;
    }
  }
  
  public static boolean b(akqt paramakqt)
  {
    if (paramakqt == null) {
      return false;
    }
    String str1 = paramakqt.a();
    String str2 = paramakqt.b();
    paramakqt = paramakqt.a();
    if ((paramakqt == null) || (paramakqt.size() == 0)) {
      return false;
    }
    paramakqt = paramakqt.iterator();
    while (paramakqt.hasNext())
    {
      String str3 = (String)paramakqt.next();
      if (!new File(akno.a(str1, str2, akno.b(str1, str2, str1)) + File.separator + str3 + ".so").exists())
      {
        QLog.i("ArCoreNativeSoManager", 2, "isAllFileExists. name not exist.");
        return false;
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     akqp
 * JD-Core Version:    0.7.0.1
 */
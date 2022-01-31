import cooperation.qqfav.widget.QfavJumpActivity;
import java.io.InputStream;

public class alzo
  implements Runnable
{
  public alzo(QfavJumpActivity paramQfavJumpActivity, String paramString, InputStream paramInputStream, long paramLong) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 12
    //   3: aconst_null
    //   4: astore 9
    //   6: aconst_null
    //   7: astore 10
    //   9: aconst_null
    //   10: astore 13
    //   12: aconst_null
    //   13: astore 8
    //   15: new 32	java/io/File
    //   18: dup
    //   19: aload_0
    //   20: getfield 17	alzo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   23: invokespecial 35	java/io/File:<init>	(Ljava/lang/String;)V
    //   26: astore 14
    //   28: aload 14
    //   30: invokevirtual 39	java/io/File:exists	()Z
    //   33: ifne +81 -> 114
    //   36: aload 14
    //   38: invokevirtual 42	java/io/File:createNewFile	()Z
    //   41: ifne +73 -> 114
    //   44: aload_0
    //   45: getfield 15	alzo:jdField_a_of_type_CooperationQqfavWidgetQfavJumpActivity	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   48: getfield 47	cooperation/qqfav/widget/QfavJumpActivity:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   51: iconst_1
    //   52: invokevirtual 53	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   55: pop
    //   56: iconst_0
    //   57: ifeq +10 -> 67
    //   60: invokestatic 59	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   63: aconst_null
    //   64: invokevirtual 63	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   67: aload_0
    //   68: getfield 15	alzo:jdField_a_of_type_CooperationQqfavWidgetQfavJumpActivity	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   71: iconst_0
    //   72: invokestatic 66	cooperation/qqfav/widget/QfavJumpActivity:a	(Lcooperation/qqfav/widget/QfavJumpActivity;Z)Z
    //   75: pop
    //   76: aload_0
    //   77: getfield 19	alzo:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   80: invokevirtual 71	java/io/InputStream:close	()V
    //   83: iconst_0
    //   84: ifeq +11 -> 95
    //   87: new 73	java/lang/NullPointerException
    //   90: dup
    //   91: invokespecial 74	java/lang/NullPointerException:<init>	()V
    //   94: athrow
    //   95: return
    //   96: astore 8
    //   98: aload 8
    //   100: invokevirtual 77	java/io/IOException:printStackTrace	()V
    //   103: goto -20 -> 83
    //   106: astore 8
    //   108: aload 8
    //   110: invokevirtual 77	java/io/IOException:printStackTrace	()V
    //   113: return
    //   114: new 79	java/io/FileOutputStream
    //   117: dup
    //   118: aload_0
    //   119: getfield 17	alzo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   122: invokespecial 80	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   125: astore 11
    //   127: aload 13
    //   129: astore 9
    //   131: invokestatic 59	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   134: sipush 8192
    //   137: invokevirtual 84	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   140: astore 10
    //   142: lconst_0
    //   143: lstore 6
    //   145: lconst_0
    //   146: lstore 4
    //   148: aload 10
    //   150: astore 8
    //   152: aload 10
    //   154: astore 9
    //   156: aload_0
    //   157: getfield 19	alzo:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   160: aload 10
    //   162: invokevirtual 88	java/io/InputStream:read	([B)I
    //   165: istore_1
    //   166: iload_1
    //   167: iconst_m1
    //   168: if_icmpeq +126 -> 294
    //   171: aload 10
    //   173: astore 8
    //   175: aload 10
    //   177: astore 9
    //   179: aload_0
    //   180: getfield 15	alzo:jdField_a_of_type_CooperationQqfavWidgetQfavJumpActivity	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   183: invokestatic 91	cooperation/qqfav/widget/QfavJumpActivity:a	(Lcooperation/qqfav/widget/QfavJumpActivity;)Z
    //   186: ifeq +108 -> 294
    //   189: lload 4
    //   191: iload_1
    //   192: i2l
    //   193: ladd
    //   194: lstore_2
    //   195: aload 10
    //   197: astore 8
    //   199: aload 10
    //   201: astore 9
    //   203: aload 11
    //   205: aload 10
    //   207: iconst_0
    //   208: iload_1
    //   209: invokevirtual 95	java/io/FileOutputStream:write	([BII)V
    //   212: lload_2
    //   213: lstore 4
    //   215: aload 10
    //   217: astore 8
    //   219: aload 10
    //   221: astore 9
    //   223: lload_2
    //   224: lload 6
    //   226: lsub
    //   227: l2d
    //   228: aload_0
    //   229: getfield 21	alzo:jdField_a_of_type_Long	J
    //   232: l2d
    //   233: ddiv
    //   234: ldc2_w 96
    //   237: dcmpl
    //   238: ifle -90 -> 148
    //   241: aload 10
    //   243: astore 8
    //   245: aload 10
    //   247: astore 9
    //   249: aload_0
    //   250: getfield 15	alzo:jdField_a_of_type_CooperationQqfavWidgetQfavJumpActivity	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   253: getfield 47	cooperation/qqfav/widget/QfavJumpActivity:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   256: aload_0
    //   257: getfield 15	alzo:jdField_a_of_type_CooperationQqfavWidgetQfavJumpActivity	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   260: getfield 47	cooperation/qqfav/widget/QfavJumpActivity:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   263: iconst_3
    //   264: lload_2
    //   265: l2d
    //   266: aload_0
    //   267: getfield 21	alzo:jdField_a_of_type_Long	J
    //   270: l2d
    //   271: ddiv
    //   272: ldc2_w 98
    //   275: dmul
    //   276: d2i
    //   277: iconst_0
    //   278: invokevirtual 103	mqq/os/MqqHandler:obtainMessage	(III)Landroid/os/Message;
    //   281: invokevirtual 107	mqq/os/MqqHandler:sendMessage	(Landroid/os/Message;)Z
    //   284: pop
    //   285: lload_2
    //   286: lstore 6
    //   288: lload_2
    //   289: lstore 4
    //   291: goto -143 -> 148
    //   294: lload 4
    //   296: lconst_0
    //   297: lcmp
    //   298: ifne +43 -> 341
    //   301: aload 10
    //   303: astore 8
    //   305: aload 10
    //   307: astore 9
    //   309: aload_0
    //   310: getfield 15	alzo:jdField_a_of_type_CooperationQqfavWidgetQfavJumpActivity	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   313: ldc 108
    //   315: invokevirtual 112	cooperation/qqfav/widget/QfavJumpActivity:getString	(I)Ljava/lang/String;
    //   318: putstatic 113	cooperation/qqfav/widget/QfavJumpActivity:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   321: aload 10
    //   323: astore 8
    //   325: aload 10
    //   327: astore 9
    //   329: aload_0
    //   330: getfield 15	alzo:jdField_a_of_type_CooperationQqfavWidgetQfavJumpActivity	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   333: getfield 47	cooperation/qqfav/widget/QfavJumpActivity:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   336: iconst_1
    //   337: invokevirtual 53	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   340: pop
    //   341: aload 10
    //   343: astore 8
    //   345: aload 10
    //   347: astore 9
    //   349: aload_0
    //   350: getfield 15	alzo:jdField_a_of_type_CooperationQqfavWidgetQfavJumpActivity	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   353: invokestatic 91	cooperation/qqfav/widget/QfavJumpActivity:a	(Lcooperation/qqfav/widget/QfavJumpActivity;)Z
    //   356: ifeq +107 -> 463
    //   359: aload 10
    //   361: astore 8
    //   363: aload 10
    //   365: astore 9
    //   367: aload_0
    //   368: getfield 15	alzo:jdField_a_of_type_CooperationQqfavWidgetQfavJumpActivity	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   371: getfield 47	cooperation/qqfav/widget/QfavJumpActivity:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   374: aload_0
    //   375: getfield 15	alzo:jdField_a_of_type_CooperationQqfavWidgetQfavJumpActivity	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   378: getfield 47	cooperation/qqfav/widget/QfavJumpActivity:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   381: iconst_3
    //   382: bipush 100
    //   384: iconst_0
    //   385: invokevirtual 103	mqq/os/MqqHandler:obtainMessage	(III)Landroid/os/Message;
    //   388: invokevirtual 107	mqq/os/MqqHandler:sendMessage	(Landroid/os/Message;)Z
    //   391: pop
    //   392: aload 10
    //   394: astore 8
    //   396: aload 10
    //   398: astore 9
    //   400: aload_0
    //   401: getfield 15	alzo:jdField_a_of_type_CooperationQqfavWidgetQfavJumpActivity	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   404: getfield 47	cooperation/qqfav/widget/QfavJumpActivity:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   407: iconst_2
    //   408: ldc2_w 114
    //   411: invokevirtual 119	mqq/os/MqqHandler:sendEmptyMessageDelayed	(IJ)Z
    //   414: pop
    //   415: aload 10
    //   417: ifnull +11 -> 428
    //   420: invokestatic 59	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   423: aload 10
    //   425: invokevirtual 63	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   428: aload_0
    //   429: getfield 15	alzo:jdField_a_of_type_CooperationQqfavWidgetQfavJumpActivity	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   432: iconst_0
    //   433: invokestatic 66	cooperation/qqfav/widget/QfavJumpActivity:a	(Lcooperation/qqfav/widget/QfavJumpActivity;Z)Z
    //   436: pop
    //   437: aload_0
    //   438: getfield 19	alzo:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   441: invokevirtual 71	java/io/InputStream:close	()V
    //   444: aload 11
    //   446: ifnull -351 -> 95
    //   449: aload 11
    //   451: invokevirtual 120	java/io/FileOutputStream:close	()V
    //   454: return
    //   455: astore 8
    //   457: aload 8
    //   459: invokevirtual 77	java/io/IOException:printStackTrace	()V
    //   462: return
    //   463: aload 10
    //   465: astore 8
    //   467: aload 10
    //   469: astore 9
    //   471: aload 11
    //   473: invokestatic 126	com/tencent/util/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   476: aload 10
    //   478: astore 8
    //   480: aload 10
    //   482: astore 9
    //   484: aload 14
    //   486: invokevirtual 129	java/io/File:delete	()Z
    //   489: pop
    //   490: goto -75 -> 415
    //   493: astore 12
    //   495: aload 11
    //   497: astore 10
    //   499: aload 8
    //   501: astore 9
    //   503: aload 12
    //   505: astore 8
    //   507: invokestatic 134	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   510: ifeq +13 -> 523
    //   513: ldc 136
    //   515: iconst_2
    //   516: ldc 138
    //   518: aload 8
    //   520: invokestatic 142	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   523: aload_0
    //   524: getfield 15	alzo:jdField_a_of_type_CooperationQqfavWidgetQfavJumpActivity	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   527: getfield 47	cooperation/qqfav/widget/QfavJumpActivity:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   530: iconst_1
    //   531: invokevirtual 53	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   534: pop
    //   535: aload 9
    //   537: ifnull +11 -> 548
    //   540: invokestatic 59	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   543: aload 9
    //   545: invokevirtual 63	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   548: aload_0
    //   549: getfield 15	alzo:jdField_a_of_type_CooperationQqfavWidgetQfavJumpActivity	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   552: iconst_0
    //   553: invokestatic 66	cooperation/qqfav/widget/QfavJumpActivity:a	(Lcooperation/qqfav/widget/QfavJumpActivity;Z)Z
    //   556: pop
    //   557: aload_0
    //   558: getfield 19	alzo:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   561: invokevirtual 71	java/io/InputStream:close	()V
    //   564: aload 10
    //   566: ifnull -471 -> 95
    //   569: aload 10
    //   571: invokevirtual 120	java/io/FileOutputStream:close	()V
    //   574: return
    //   575: astore 8
    //   577: aload 8
    //   579: invokevirtual 77	java/io/IOException:printStackTrace	()V
    //   582: return
    //   583: astore 8
    //   585: aload 8
    //   587: invokevirtual 77	java/io/IOException:printStackTrace	()V
    //   590: goto -146 -> 444
    //   593: astore 8
    //   595: aload 8
    //   597: invokevirtual 77	java/io/IOException:printStackTrace	()V
    //   600: goto -36 -> 564
    //   603: astore 8
    //   605: aconst_null
    //   606: astore 9
    //   608: aload 10
    //   610: ifnull +11 -> 621
    //   613: invokestatic 59	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   616: aload 10
    //   618: invokevirtual 63	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   621: aload_0
    //   622: getfield 15	alzo:jdField_a_of_type_CooperationQqfavWidgetQfavJumpActivity	Lcooperation/qqfav/widget/QfavJumpActivity;
    //   625: iconst_0
    //   626: invokestatic 66	cooperation/qqfav/widget/QfavJumpActivity:a	(Lcooperation/qqfav/widget/QfavJumpActivity;Z)Z
    //   629: pop
    //   630: aload_0
    //   631: getfield 19	alzo:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   634: invokevirtual 71	java/io/InputStream:close	()V
    //   637: aload 9
    //   639: ifnull +8 -> 647
    //   642: aload 9
    //   644: invokevirtual 120	java/io/FileOutputStream:close	()V
    //   647: aload 8
    //   649: athrow
    //   650: astore 10
    //   652: aload 10
    //   654: invokevirtual 77	java/io/IOException:printStackTrace	()V
    //   657: goto -20 -> 637
    //   660: astore 9
    //   662: aload 9
    //   664: invokevirtual 77	java/io/IOException:printStackTrace	()V
    //   667: goto -20 -> 647
    //   670: astore 8
    //   672: aload 9
    //   674: astore 10
    //   676: aload 11
    //   678: astore 9
    //   680: goto -72 -> 608
    //   683: astore 8
    //   685: aload 10
    //   687: astore 11
    //   689: aload 9
    //   691: astore 10
    //   693: aload 11
    //   695: astore 9
    //   697: goto -89 -> 608
    //   700: astore 8
    //   702: aload 12
    //   704: astore 10
    //   706: goto -199 -> 507
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	709	0	this	alzo
    //   165	44	1	i	int
    //   194	95	2	l1	long
    //   146	149	4	l2	long
    //   143	144	6	l3	long
    //   13	1	8	localObject1	Object
    //   96	3	8	localIOException1	java.io.IOException
    //   106	3	8	localIOException2	java.io.IOException
    //   150	245	8	localObject2	Object
    //   455	3	8	localIOException3	java.io.IOException
    //   465	54	8	localObject3	Object
    //   575	3	8	localIOException4	java.io.IOException
    //   583	3	8	localIOException5	java.io.IOException
    //   593	3	8	localIOException6	java.io.IOException
    //   603	45	8	localObject4	Object
    //   670	1	8	localObject5	Object
    //   683	1	8	localObject6	Object
    //   700	1	8	localException1	java.lang.Exception
    //   4	639	9	localObject7	Object
    //   660	13	9	localIOException7	java.io.IOException
    //   678	18	9	localObject8	Object
    //   7	610	10	localObject9	Object
    //   650	3	10	localIOException8	java.io.IOException
    //   674	31	10	localObject10	Object
    //   125	569	11	localObject11	Object
    //   1	1	12	localObject12	Object
    //   493	210	12	localException2	java.lang.Exception
    //   10	118	13	localObject13	Object
    //   26	459	14	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   76	83	96	java/io/IOException
    //   87	95	106	java/io/IOException
    //   449	454	455	java/io/IOException
    //   131	142	493	java/lang/Exception
    //   156	166	493	java/lang/Exception
    //   179	189	493	java/lang/Exception
    //   203	212	493	java/lang/Exception
    //   223	241	493	java/lang/Exception
    //   249	285	493	java/lang/Exception
    //   309	321	493	java/lang/Exception
    //   329	341	493	java/lang/Exception
    //   349	359	493	java/lang/Exception
    //   367	392	493	java/lang/Exception
    //   400	415	493	java/lang/Exception
    //   471	476	493	java/lang/Exception
    //   484	490	493	java/lang/Exception
    //   569	574	575	java/io/IOException
    //   437	444	583	java/io/IOException
    //   557	564	593	java/io/IOException
    //   15	56	603	finally
    //   114	127	603	finally
    //   630	637	650	java/io/IOException
    //   642	647	660	java/io/IOException
    //   131	142	670	finally
    //   156	166	670	finally
    //   179	189	670	finally
    //   203	212	670	finally
    //   223	241	670	finally
    //   249	285	670	finally
    //   309	321	670	finally
    //   329	341	670	finally
    //   349	359	670	finally
    //   367	392	670	finally
    //   400	415	670	finally
    //   471	476	670	finally
    //   484	490	670	finally
    //   507	523	683	finally
    //   523	535	683	finally
    //   15	56	700	java/lang/Exception
    //   114	127	700	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     alzo
 * JD-Core Version:    0.7.0.1
 */
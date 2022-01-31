import android.net.Uri;
import com.tencent.mobileqq.forward.ForwardFileBaseOption;
import java.io.InputStream;

public class adar
  implements Runnable
{
  public adar(ForwardFileBaseOption paramForwardFileBaseOption, String paramString, InputStream paramInputStream, long paramLong, Uri paramUri) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: aconst_null
    //   4: astore 11
    //   6: aconst_null
    //   7: astore 12
    //   9: aconst_null
    //   10: astore 8
    //   12: aconst_null
    //   13: astore 13
    //   15: new 33	java/io/File
    //   18: dup
    //   19: aload_0
    //   20: getfield 18	adar:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   23: invokespecial 36	java/io/File:<init>	(Ljava/lang/String;)V
    //   26: astore 14
    //   28: aload 14
    //   30: invokevirtual 40	java/io/File:exists	()Z
    //   33: ifne +55 -> 88
    //   36: aload 14
    //   38: invokevirtual 43	java/io/File:createNewFile	()Z
    //   41: ifne +47 -> 88
    //   44: aload_0
    //   45: getfield 16	adar:jdField_a_of_type_ComTencentMobileqqForwardForwardFileBaseOption	Lcom/tencent/mobileqq/forward/ForwardFileBaseOption;
    //   48: getfield 48	com/tencent/mobileqq/forward/ForwardFileBaseOption:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   51: iconst_1
    //   52: invokevirtual 54	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   55: pop
    //   56: iconst_0
    //   57: ifeq +10 -> 67
    //   60: invokestatic 60	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   63: aconst_null
    //   64: invokevirtual 64	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   67: aload_0
    //   68: getfield 16	adar:jdField_a_of_type_ComTencentMobileqqForwardForwardFileBaseOption	Lcom/tencent/mobileqq/forward/ForwardFileBaseOption;
    //   71: iconst_0
    //   72: invokestatic 67	com/tencent/mobileqq/forward/ForwardFileBaseOption:a	(Lcom/tencent/mobileqq/forward/ForwardFileBaseOption;Z)Z
    //   75: pop
    //   76: aload_0
    //   77: getfield 20	adar:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   80: invokestatic 73	com/tencent/util/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   83: aconst_null
    //   84: invokestatic 76	com/tencent/util/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   87: return
    //   88: new 78	java/io/FileOutputStream
    //   91: dup
    //   92: aload_0
    //   93: getfield 18	adar:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   96: invokespecial 79	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   99: astore 10
    //   101: aload 13
    //   103: astore 8
    //   105: aload 12
    //   107: astore 9
    //   109: invokestatic 60	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   112: sipush 8192
    //   115: invokevirtual 83	com/tencent/commonsdk/pool/ByteArrayPool:getBuf	(I)[B
    //   118: astore 11
    //   120: lconst_0
    //   121: lstore 6
    //   123: lconst_0
    //   124: lstore_2
    //   125: aload 11
    //   127: astore 8
    //   129: aload 11
    //   131: astore 9
    //   133: aload_0
    //   134: getfield 20	adar:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   137: aload 11
    //   139: invokevirtual 89	java/io/InputStream:read	([B)I
    //   142: istore_1
    //   143: iload_1
    //   144: iconst_m1
    //   145: if_icmpeq +129 -> 274
    //   148: aload 11
    //   150: astore 8
    //   152: aload 11
    //   154: astore 9
    //   156: aload_0
    //   157: getfield 16	adar:jdField_a_of_type_ComTencentMobileqqForwardForwardFileBaseOption	Lcom/tencent/mobileqq/forward/ForwardFileBaseOption;
    //   160: invokestatic 92	com/tencent/mobileqq/forward/ForwardFileBaseOption:a	(Lcom/tencent/mobileqq/forward/ForwardFileBaseOption;)Z
    //   163: ifeq +111 -> 274
    //   166: lload_2
    //   167: iload_1
    //   168: i2l
    //   169: ladd
    //   170: lstore 4
    //   172: aload 11
    //   174: astore 8
    //   176: aload 11
    //   178: astore 9
    //   180: aload 10
    //   182: aload 11
    //   184: iconst_0
    //   185: iload_1
    //   186: invokevirtual 96	java/io/FileOutputStream:write	([BII)V
    //   189: lload 4
    //   191: lstore_2
    //   192: aload 11
    //   194: astore 8
    //   196: aload 11
    //   198: astore 9
    //   200: lload 4
    //   202: lload 6
    //   204: lsub
    //   205: l2d
    //   206: aload_0
    //   207: getfield 22	adar:jdField_a_of_type_Long	J
    //   210: l2d
    //   211: ddiv
    //   212: ldc2_w 97
    //   215: dcmpl
    //   216: ifle -91 -> 125
    //   219: aload 11
    //   221: astore 8
    //   223: aload 11
    //   225: astore 9
    //   227: aload_0
    //   228: getfield 16	adar:jdField_a_of_type_ComTencentMobileqqForwardForwardFileBaseOption	Lcom/tencent/mobileqq/forward/ForwardFileBaseOption;
    //   231: getfield 48	com/tencent/mobileqq/forward/ForwardFileBaseOption:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   234: aload_0
    //   235: getfield 16	adar:jdField_a_of_type_ComTencentMobileqqForwardForwardFileBaseOption	Lcom/tencent/mobileqq/forward/ForwardFileBaseOption;
    //   238: getfield 48	com/tencent/mobileqq/forward/ForwardFileBaseOption:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   241: iconst_3
    //   242: lload 4
    //   244: l2d
    //   245: aload_0
    //   246: getfield 22	adar:jdField_a_of_type_Long	J
    //   249: l2d
    //   250: ddiv
    //   251: ldc2_w 99
    //   254: dmul
    //   255: d2i
    //   256: iconst_0
    //   257: invokevirtual 104	mqq/os/MqqHandler:obtainMessage	(III)Landroid/os/Message;
    //   260: invokevirtual 108	mqq/os/MqqHandler:sendMessage	(Landroid/os/Message;)Z
    //   263: pop
    //   264: lload 4
    //   266: lstore 6
    //   268: lload 4
    //   270: lstore_2
    //   271: goto -146 -> 125
    //   274: lload_2
    //   275: lconst_0
    //   276: lcmp
    //   277: ifne +69 -> 346
    //   280: aload 11
    //   282: astore 8
    //   284: aload 11
    //   286: astore 9
    //   288: aload_0
    //   289: getfield 24	adar:jdField_a_of_type_AndroidNetUri	Landroid/net/Uri;
    //   292: invokevirtual 114	android/net/Uri:toString	()Ljava/lang/String;
    //   295: ldc 116
    //   297: invokevirtual 122	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   300: ifeq +183 -> 483
    //   303: aload 11
    //   305: astore 8
    //   307: aload 11
    //   309: astore 9
    //   311: aload_0
    //   312: getfield 16	adar:jdField_a_of_type_ComTencentMobileqqForwardForwardFileBaseOption	Lcom/tencent/mobileqq/forward/ForwardFileBaseOption;
    //   315: getfield 125	com/tencent/mobileqq/forward/ForwardFileBaseOption:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   318: ldc 126
    //   320: invokevirtual 132	android/content/Context:getString	(I)Ljava/lang/String;
    //   323: putstatic 135	com/tencent/mobileqq/forward/ForwardFileBaseOption:f	Ljava/lang/String;
    //   326: aload 11
    //   328: astore 8
    //   330: aload 11
    //   332: astore 9
    //   334: aload_0
    //   335: getfield 16	adar:jdField_a_of_type_ComTencentMobileqqForwardForwardFileBaseOption	Lcom/tencent/mobileqq/forward/ForwardFileBaseOption;
    //   338: getfield 48	com/tencent/mobileqq/forward/ForwardFileBaseOption:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   341: iconst_1
    //   342: invokevirtual 54	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   345: pop
    //   346: aload 11
    //   348: astore 8
    //   350: aload 11
    //   352: astore 9
    //   354: aload_0
    //   355: getfield 16	adar:jdField_a_of_type_ComTencentMobileqqForwardForwardFileBaseOption	Lcom/tencent/mobileqq/forward/ForwardFileBaseOption;
    //   358: invokestatic 92	com/tencent/mobileqq/forward/ForwardFileBaseOption:a	(Lcom/tencent/mobileqq/forward/ForwardFileBaseOption;)Z
    //   361: ifeq +221 -> 582
    //   364: aload 11
    //   366: astore 8
    //   368: aload 11
    //   370: astore 9
    //   372: aload_0
    //   373: getfield 16	adar:jdField_a_of_type_ComTencentMobileqqForwardForwardFileBaseOption	Lcom/tencent/mobileqq/forward/ForwardFileBaseOption;
    //   376: aload_0
    //   377: getfield 16	adar:jdField_a_of_type_ComTencentMobileqqForwardForwardFileBaseOption	Lcom/tencent/mobileqq/forward/ForwardFileBaseOption;
    //   380: aload 14
    //   382: invokevirtual 138	java/io/File:getName	()Ljava/lang/String;
    //   385: lload_2
    //   386: invokestatic 141	com/tencent/mobileqq/forward/ForwardFileBaseOption:a	(Lcom/tencent/mobileqq/forward/ForwardFileBaseOption;Ljava/lang/String;J)Ljava/lang/String;
    //   389: putfield 142	com/tencent/mobileqq/forward/ForwardFileBaseOption:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   392: aload 11
    //   394: astore 8
    //   396: aload 11
    //   398: astore 9
    //   400: aload_0
    //   401: getfield 16	adar:jdField_a_of_type_ComTencentMobileqqForwardForwardFileBaseOption	Lcom/tencent/mobileqq/forward/ForwardFileBaseOption;
    //   404: getfield 48	com/tencent/mobileqq/forward/ForwardFileBaseOption:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   407: aload_0
    //   408: getfield 16	adar:jdField_a_of_type_ComTencentMobileqqForwardForwardFileBaseOption	Lcom/tencent/mobileqq/forward/ForwardFileBaseOption;
    //   411: getfield 48	com/tencent/mobileqq/forward/ForwardFileBaseOption:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   414: iconst_3
    //   415: bipush 100
    //   417: iconst_0
    //   418: invokevirtual 104	mqq/os/MqqHandler:obtainMessage	(III)Landroid/os/Message;
    //   421: invokevirtual 108	mqq/os/MqqHandler:sendMessage	(Landroid/os/Message;)Z
    //   424: pop
    //   425: aload 11
    //   427: astore 8
    //   429: aload 11
    //   431: astore 9
    //   433: aload_0
    //   434: getfield 16	adar:jdField_a_of_type_ComTencentMobileqqForwardForwardFileBaseOption	Lcom/tencent/mobileqq/forward/ForwardFileBaseOption;
    //   437: getfield 48	com/tencent/mobileqq/forward/ForwardFileBaseOption:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   440: iconst_2
    //   441: ldc2_w 143
    //   444: invokevirtual 148	mqq/os/MqqHandler:sendEmptyMessageDelayed	(IJ)Z
    //   447: pop
    //   448: aload 11
    //   450: ifnull +11 -> 461
    //   453: invokestatic 60	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   456: aload 11
    //   458: invokevirtual 64	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   461: aload_0
    //   462: getfield 16	adar:jdField_a_of_type_ComTencentMobileqqForwardForwardFileBaseOption	Lcom/tencent/mobileqq/forward/ForwardFileBaseOption;
    //   465: iconst_0
    //   466: invokestatic 67	com/tencent/mobileqq/forward/ForwardFileBaseOption:a	(Lcom/tencent/mobileqq/forward/ForwardFileBaseOption;Z)Z
    //   469: pop
    //   470: aload_0
    //   471: getfield 20	adar:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   474: invokestatic 73	com/tencent/util/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   477: aload 10
    //   479: invokestatic 76	com/tencent/util/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   482: return
    //   483: aload 11
    //   485: astore 8
    //   487: aload 11
    //   489: astore 9
    //   491: aload_0
    //   492: getfield 16	adar:jdField_a_of_type_ComTencentMobileqqForwardForwardFileBaseOption	Lcom/tencent/mobileqq/forward/ForwardFileBaseOption;
    //   495: getfield 125	com/tencent/mobileqq/forward/ForwardFileBaseOption:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   498: ldc 149
    //   500: invokevirtual 132	android/content/Context:getString	(I)Ljava/lang/String;
    //   503: putstatic 135	com/tencent/mobileqq/forward/ForwardFileBaseOption:f	Ljava/lang/String;
    //   506: goto -180 -> 326
    //   509: astore 11
    //   511: aload 10
    //   513: astore 9
    //   515: aload 11
    //   517: astore 10
    //   519: invokestatic 154	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   522: ifeq +13 -> 535
    //   525: ldc 156
    //   527: iconst_2
    //   528: ldc 158
    //   530: aload 10
    //   532: invokestatic 162	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   535: aload_0
    //   536: getfield 16	adar:jdField_a_of_type_ComTencentMobileqqForwardForwardFileBaseOption	Lcom/tencent/mobileqq/forward/ForwardFileBaseOption;
    //   539: getfield 48	com/tencent/mobileqq/forward/ForwardFileBaseOption:jdField_a_of_type_MqqOsMqqHandler	Lmqq/os/MqqHandler;
    //   542: iconst_1
    //   543: invokevirtual 54	mqq/os/MqqHandler:sendEmptyMessage	(I)Z
    //   546: pop
    //   547: aload 8
    //   549: ifnull +11 -> 560
    //   552: invokestatic 60	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   555: aload 8
    //   557: invokevirtual 64	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   560: aload_0
    //   561: getfield 16	adar:jdField_a_of_type_ComTencentMobileqqForwardForwardFileBaseOption	Lcom/tencent/mobileqq/forward/ForwardFileBaseOption;
    //   564: iconst_0
    //   565: invokestatic 67	com/tencent/mobileqq/forward/ForwardFileBaseOption:a	(Lcom/tencent/mobileqq/forward/ForwardFileBaseOption;Z)Z
    //   568: pop
    //   569: aload_0
    //   570: getfield 20	adar:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   573: invokestatic 73	com/tencent/util/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   576: aload 9
    //   578: invokestatic 76	com/tencent/util/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   581: return
    //   582: aload 11
    //   584: astore 8
    //   586: aload 11
    //   588: astore 9
    //   590: aload 10
    //   592: invokestatic 76	com/tencent/util/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   595: aload 11
    //   597: astore 8
    //   599: aload 11
    //   601: astore 9
    //   603: aload 14
    //   605: invokevirtual 165	java/io/File:delete	()Z
    //   608: pop
    //   609: goto -161 -> 448
    //   612: astore 11
    //   614: aload 9
    //   616: astore 8
    //   618: aload 11
    //   620: astore 9
    //   622: aload 8
    //   624: ifnull +11 -> 635
    //   627: invokestatic 60	com/tencent/commonsdk/pool/ByteArrayPool:getGenericInstance	()Lcom/tencent/commonsdk/pool/ByteArrayPool;
    //   630: aload 8
    //   632: invokevirtual 64	com/tencent/commonsdk/pool/ByteArrayPool:returnBuf	([B)V
    //   635: aload_0
    //   636: getfield 16	adar:jdField_a_of_type_ComTencentMobileqqForwardForwardFileBaseOption	Lcom/tencent/mobileqq/forward/ForwardFileBaseOption;
    //   639: iconst_0
    //   640: invokestatic 67	com/tencent/mobileqq/forward/ForwardFileBaseOption:a	(Lcom/tencent/mobileqq/forward/ForwardFileBaseOption;Z)Z
    //   643: pop
    //   644: aload_0
    //   645: getfield 20	adar:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   648: invokestatic 73	com/tencent/util/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   651: aload 10
    //   653: invokestatic 76	com/tencent/util/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   656: aload 9
    //   658: athrow
    //   659: astore 9
    //   661: aconst_null
    //   662: astore 10
    //   664: goto -42 -> 622
    //   667: astore 11
    //   669: aload 9
    //   671: astore 10
    //   673: aload 11
    //   675: astore 9
    //   677: goto -55 -> 622
    //   680: astore 10
    //   682: aload 11
    //   684: astore 8
    //   686: goto -167 -> 519
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	689	0	this	adar
    //   142	44	1	i	int
    //   124	262	2	l1	long
    //   170	99	4	l2	long
    //   121	146	6	l3	long
    //   10	675	8	localObject1	Object
    //   1	656	9	localObject2	Object
    //   659	11	9	localObject3	Object
    //   675	1	9	localObject4	Object
    //   99	573	10	localObject5	Object
    //   680	1	10	localException1	java.lang.Exception
    //   4	484	11	arrayOfByte	byte[]
    //   509	91	11	localException2	java.lang.Exception
    //   612	7	11	localObject6	Object
    //   667	16	11	localObject7	Object
    //   7	99	12	localObject8	Object
    //   13	89	13	localObject9	Object
    //   26	578	14	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   109	120	509	java/lang/Exception
    //   133	143	509	java/lang/Exception
    //   156	166	509	java/lang/Exception
    //   180	189	509	java/lang/Exception
    //   200	219	509	java/lang/Exception
    //   227	264	509	java/lang/Exception
    //   288	303	509	java/lang/Exception
    //   311	326	509	java/lang/Exception
    //   334	346	509	java/lang/Exception
    //   354	364	509	java/lang/Exception
    //   372	392	509	java/lang/Exception
    //   400	425	509	java/lang/Exception
    //   433	448	509	java/lang/Exception
    //   491	506	509	java/lang/Exception
    //   590	595	509	java/lang/Exception
    //   603	609	509	java/lang/Exception
    //   109	120	612	finally
    //   133	143	612	finally
    //   156	166	612	finally
    //   180	189	612	finally
    //   200	219	612	finally
    //   227	264	612	finally
    //   288	303	612	finally
    //   311	326	612	finally
    //   334	346	612	finally
    //   354	364	612	finally
    //   372	392	612	finally
    //   400	425	612	finally
    //   433	448	612	finally
    //   491	506	612	finally
    //   590	595	612	finally
    //   603	609	612	finally
    //   15	56	659	finally
    //   88	101	659	finally
    //   519	535	667	finally
    //   535	547	667	finally
    //   15	56	680	java/lang/Exception
    //   88	101	680	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     adar
 * JD-Core Version:    0.7.0.1
 */
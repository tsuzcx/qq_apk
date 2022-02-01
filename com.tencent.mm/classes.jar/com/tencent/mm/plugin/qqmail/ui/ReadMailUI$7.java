package com.tencent.mm.plugin.qqmail.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class ReadMailUI$7
  implements Runnable
{
  ReadMailUI$7(ReadMailUI paramReadMailUI) {}
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: ldc 24
    //   2: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aconst_null
    //   6: astore_3
    //   7: aconst_null
    //   8: astore 6
    //   10: new 32	java/net/URL
    //   13: dup
    //   14: aload_0
    //   15: getfield 16	com/tencent/mm/plugin/qqmail/ui/ReadMailUI$7:BxA	Lcom/tencent/mm/plugin/qqmail/ui/ReadMailUI;
    //   18: invokestatic 36	com/tencent/mm/plugin/qqmail/ui/ReadMailUI:H	(Lcom/tencent/mm/plugin/qqmail/ui/ReadMailUI;)Ljava/lang/String;
    //   21: invokespecial 39	java/net/URL:<init>	(Ljava/lang/String;)V
    //   24: invokevirtual 43	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   27: checkcast 45	java/net/HttpURLConnection
    //   30: astore 4
    //   32: aload 4
    //   34: iconst_0
    //   35: invokevirtual 49	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   38: aload 4
    //   40: invokevirtual 52	java/net/HttpURLConnection:connect	()V
    //   43: aload_0
    //   44: getfield 16	com/tencent/mm/plugin/qqmail/ui/ReadMailUI$7:BxA	Lcom/tencent/mm/plugin/qqmail/ui/ReadMailUI;
    //   47: aload 4
    //   49: ldc 54
    //   51: invokevirtual 58	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   54: invokestatic 62	com/tencent/mm/plugin/qqmail/ui/ReadMailUI:d	(Lcom/tencent/mm/plugin/qqmail/ui/ReadMailUI;Ljava/lang/String;)Ljava/lang/String;
    //   57: pop
    //   58: aload 4
    //   60: invokevirtual 66	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   63: astore 5
    //   65: aload 4
    //   67: ldc 68
    //   69: iconst_m1
    //   70: invokevirtual 72	java/net/HttpURLConnection:getHeaderFieldInt	(Ljava/lang/String;I)I
    //   73: istore_1
    //   74: iload_1
    //   75: ifgt +57 -> 132
    //   78: ldc 74
    //   80: ldc 76
    //   82: invokestatic 82	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   85: aload 5
    //   87: invokevirtual 87	java/io/InputStream:close	()V
    //   90: aload 4
    //   92: invokevirtual 90	java/net/HttpURLConnection:disconnect	()V
    //   95: aload 4
    //   97: ifnull +16 -> 113
    //   100: aload 4
    //   102: invokevirtual 66	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   105: invokevirtual 87	java/io/InputStream:close	()V
    //   108: aload 4
    //   110: invokevirtual 90	java/net/HttpURLConnection:disconnect	()V
    //   113: ldc 24
    //   115: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   118: return
    //   119: astore_3
    //   120: ldc 74
    //   122: aload_3
    //   123: invokevirtual 97	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   126: invokestatic 82	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   129: goto -21 -> 108
    //   132: iload_1
    //   133: newarray byte
    //   135: astore_3
    //   136: aload 5
    //   138: aload_3
    //   139: invokevirtual 101	java/io/InputStream:read	([B)I
    //   142: istore_2
    //   143: aload 5
    //   145: invokevirtual 87	java/io/InputStream:close	()V
    //   148: ldc 74
    //   150: ldc 103
    //   152: iconst_1
    //   153: anewarray 4	java/lang/Object
    //   156: dup
    //   157: iconst_0
    //   158: aload_0
    //   159: getfield 16	com/tencent/mm/plugin/qqmail/ui/ReadMailUI$7:BxA	Lcom/tencent/mm/plugin/qqmail/ui/ReadMailUI;
    //   162: invokestatic 106	com/tencent/mm/plugin/qqmail/ui/ReadMailUI:k	(Lcom/tencent/mm/plugin/qqmail/ui/ReadMailUI;)Ljava/lang/String;
    //   165: aastore
    //   166: invokestatic 109	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   169: ldc 74
    //   171: ldc 111
    //   173: iconst_3
    //   174: anewarray 4	java/lang/Object
    //   177: dup
    //   178: iconst_0
    //   179: iload_1
    //   180: invokestatic 117	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   183: aastore
    //   184: dup
    //   185: iconst_1
    //   186: iload_2
    //   187: invokestatic 117	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   190: aastore
    //   191: dup
    //   192: iconst_2
    //   193: new 119	java/lang/String
    //   196: dup
    //   197: aload_3
    //   198: invokespecial 122	java/lang/String:<init>	([B)V
    //   201: aastore
    //   202: invokestatic 109	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   205: aload_0
    //   206: getfield 16	com/tencent/mm/plugin/qqmail/ui/ReadMailUI$7:BxA	Lcom/tencent/mm/plugin/qqmail/ui/ReadMailUI;
    //   209: invokevirtual 126	com/tencent/mm/plugin/qqmail/ui/ReadMailUI:getApplicationContext	()Landroid/content/Context;
    //   212: ldc 128
    //   214: invokestatic 133	com/tencent/mm/b/m:o	(Landroid/content/Context;Ljava/lang/String;)Ljava/security/PublicKey;
    //   217: astore 5
    //   219: aload_3
    //   220: iconst_0
    //   221: invokestatic 139	android/util/Base64:decode	([BI)[B
    //   224: aload 5
    //   226: invokestatic 143	com/tencent/mm/b/m:a	([BLjava/security/PublicKey;)[B
    //   229: astore_3
    //   230: aload_0
    //   231: getfield 16	com/tencent/mm/plugin/qqmail/ui/ReadMailUI$7:BxA	Lcom/tencent/mm/plugin/qqmail/ui/ReadMailUI;
    //   234: new 119	java/lang/String
    //   237: dup
    //   238: aload_3
    //   239: invokespecial 122	java/lang/String:<init>	([B)V
    //   242: invokestatic 145	com/tencent/mm/plugin/qqmail/ui/ReadMailUI:e	(Lcom/tencent/mm/plugin/qqmail/ui/ReadMailUI;Ljava/lang/String;)Ljava/lang/String;
    //   245: pop
    //   246: ldc 74
    //   248: ldc 147
    //   250: iconst_1
    //   251: anewarray 4	java/lang/Object
    //   254: dup
    //   255: iconst_0
    //   256: aload_0
    //   257: getfield 16	com/tencent/mm/plugin/qqmail/ui/ReadMailUI$7:BxA	Lcom/tencent/mm/plugin/qqmail/ui/ReadMailUI;
    //   260: invokestatic 150	com/tencent/mm/plugin/qqmail/ui/ReadMailUI:l	(Lcom/tencent/mm/plugin/qqmail/ui/ReadMailUI;)Ljava/lang/String;
    //   263: aastore
    //   264: invokestatic 109	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   267: new 10	com/tencent/mm/plugin/qqmail/ui/ReadMailUI$7$1
    //   270: dup
    //   271: aload_0
    //   272: invokespecial 153	com/tencent/mm/plugin/qqmail/ui/ReadMailUI$7$1:<init>	(Lcom/tencent/mm/plugin/qqmail/ui/ReadMailUI$7;)V
    //   275: invokestatic 159	com/tencent/mm/sdk/platformtools/MMHandlerThread:postToMainThread	(Ljava/lang/Runnable;)V
    //   278: aload 4
    //   280: ifnull +142 -> 422
    //   283: aload 4
    //   285: invokevirtual 66	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   288: invokevirtual 87	java/io/InputStream:close	()V
    //   291: aload 4
    //   293: invokevirtual 90	java/net/HttpURLConnection:disconnect	()V
    //   296: ldc 24
    //   298: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   301: return
    //   302: astore_3
    //   303: ldc 74
    //   305: aload_3
    //   306: invokevirtual 97	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   309: invokestatic 82	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   312: goto -21 -> 291
    //   315: astore 5
    //   317: aload 6
    //   319: astore 4
    //   321: aload 4
    //   323: astore_3
    //   324: ldc 74
    //   326: aload 5
    //   328: ldc 161
    //   330: iconst_0
    //   331: anewarray 4	java/lang/Object
    //   334: invokestatic 165	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   337: aload 4
    //   339: ifnull +83 -> 422
    //   342: aload 4
    //   344: invokevirtual 66	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   347: invokevirtual 87	java/io/InputStream:close	()V
    //   350: aload 4
    //   352: invokevirtual 90	java/net/HttpURLConnection:disconnect	()V
    //   355: ldc 24
    //   357: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   360: return
    //   361: astore_3
    //   362: ldc 74
    //   364: aload_3
    //   365: invokevirtual 97	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   368: invokestatic 82	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   371: goto -21 -> 350
    //   374: astore 5
    //   376: aload_3
    //   377: astore 4
    //   379: aload 5
    //   381: astore_3
    //   382: aload 4
    //   384: ifnull +16 -> 400
    //   387: aload 4
    //   389: invokevirtual 66	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   392: invokevirtual 87	java/io/InputStream:close	()V
    //   395: aload 4
    //   397: invokevirtual 90	java/net/HttpURLConnection:disconnect	()V
    //   400: ldc 24
    //   402: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   405: aload_3
    //   406: athrow
    //   407: astore 5
    //   409: ldc 74
    //   411: aload 5
    //   413: invokevirtual 97	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   416: invokestatic 82	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   419: goto -24 -> 395
    //   422: ldc 24
    //   424: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   427: return
    //   428: astore_3
    //   429: goto -47 -> 382
    //   432: astore 5
    //   434: goto -113 -> 321
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	437	0	this	7
    //   73	107	1	i	int
    //   142	45	2	j	int
    //   6	1	3	localObject1	Object
    //   119	4	3	localException1	java.lang.Exception
    //   135	104	3	arrayOfByte	byte[]
    //   302	4	3	localException2	java.lang.Exception
    //   323	1	3	localObject2	Object
    //   361	16	3	localException3	java.lang.Exception
    //   381	25	3	localObject3	Object
    //   428	1	3	localObject4	Object
    //   30	366	4	localObject5	Object
    //   63	162	5	localObject6	Object
    //   315	12	5	localException4	java.lang.Exception
    //   374	6	5	localObject7	Object
    //   407	5	5	localException5	java.lang.Exception
    //   432	1	5	localException6	java.lang.Exception
    //   8	310	6	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   100	108	119	java/lang/Exception
    //   283	291	302	java/lang/Exception
    //   10	32	315	java/lang/Exception
    //   342	350	361	java/lang/Exception
    //   10	32	374	finally
    //   324	337	374	finally
    //   387	395	407	java/lang/Exception
    //   32	74	428	finally
    //   78	95	428	finally
    //   132	278	428	finally
    //   32	74	432	java/lang/Exception
    //   78	95	432	java/lang/Exception
    //   132	278	432	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ReadMailUI.7
 * JD-Core Version:    0.7.0.1
 */
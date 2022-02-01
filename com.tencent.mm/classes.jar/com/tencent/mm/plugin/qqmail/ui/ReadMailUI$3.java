package com.tencent.mm.plugin.qqmail.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class ReadMailUI$3
  implements Runnable
{
  ReadMailUI$3(ReadMailUI paramReadMailUI) {}
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: ldc 24
    //   2: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aconst_null
    //   6: astore_2
    //   7: aconst_null
    //   8: astore 5
    //   10: new 32	java/net/URL
    //   13: dup
    //   14: aload_0
    //   15: getfield 16	com/tencent/mm/plugin/qqmail/ui/ReadMailUI$3:uRh	Lcom/tencent/mm/plugin/qqmail/ui/ReadMailUI;
    //   18: invokestatic 36	com/tencent/mm/plugin/qqmail/ui/ReadMailUI:M	(Lcom/tencent/mm/plugin/qqmail/ui/ReadMailUI;)Ljava/lang/String;
    //   21: invokespecial 39	java/net/URL:<init>	(Ljava/lang/String;)V
    //   24: invokevirtual 43	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   27: checkcast 45	java/net/HttpURLConnection
    //   30: astore_3
    //   31: aload_3
    //   32: iconst_0
    //   33: invokevirtual 49	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   36: aload_3
    //   37: invokevirtual 52	java/net/HttpURLConnection:connect	()V
    //   40: aload_0
    //   41: getfield 16	com/tencent/mm/plugin/qqmail/ui/ReadMailUI$3:uRh	Lcom/tencent/mm/plugin/qqmail/ui/ReadMailUI;
    //   44: aload_3
    //   45: ldc 54
    //   47: invokevirtual 58	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   50: invokestatic 62	com/tencent/mm/plugin/qqmail/ui/ReadMailUI:a	(Lcom/tencent/mm/plugin/qqmail/ui/ReadMailUI;Ljava/lang/String;)Ljava/lang/String;
    //   53: pop
    //   54: aload_3
    //   55: invokevirtual 66	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   58: astore 4
    //   60: aload_3
    //   61: ldc 68
    //   63: iconst_m1
    //   64: invokevirtual 72	java/net/HttpURLConnection:getHeaderFieldInt	(Ljava/lang/String;I)I
    //   67: istore_1
    //   68: iload_1
    //   69: ifgt +53 -> 122
    //   72: ldc 74
    //   74: ldc 76
    //   76: invokestatic 82	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   79: aload 4
    //   81: invokevirtual 87	java/io/InputStream:close	()V
    //   84: aload_3
    //   85: invokevirtual 90	java/net/HttpURLConnection:disconnect	()V
    //   88: aload_3
    //   89: ifnull +14 -> 103
    //   92: aload_3
    //   93: invokevirtual 66	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   96: invokevirtual 87	java/io/InputStream:close	()V
    //   99: aload_3
    //   100: invokevirtual 90	java/net/HttpURLConnection:disconnect	()V
    //   103: ldc 24
    //   105: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   108: return
    //   109: astore_2
    //   110: ldc 74
    //   112: aload_2
    //   113: invokevirtual 97	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   116: invokestatic 82	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   119: goto -20 -> 99
    //   122: iload_1
    //   123: newarray byte
    //   125: astore_2
    //   126: aload 4
    //   128: aload_2
    //   129: invokevirtual 101	java/io/InputStream:read	([B)I
    //   132: pop
    //   133: aload 4
    //   135: invokevirtual 87	java/io/InputStream:close	()V
    //   138: ldc 74
    //   140: ldc 103
    //   142: iconst_1
    //   143: anewarray 4	java/lang/Object
    //   146: dup
    //   147: iconst_0
    //   148: aload_0
    //   149: getfield 16	com/tencent/mm/plugin/qqmail/ui/ReadMailUI$3:uRh	Lcom/tencent/mm/plugin/qqmail/ui/ReadMailUI;
    //   152: invokestatic 106	com/tencent/mm/plugin/qqmail/ui/ReadMailUI:x	(Lcom/tencent/mm/plugin/qqmail/ui/ReadMailUI;)Ljava/lang/String;
    //   155: aastore
    //   156: invokestatic 109	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   159: aload_0
    //   160: getfield 16	com/tencent/mm/plugin/qqmail/ui/ReadMailUI$3:uRh	Lcom/tencent/mm/plugin/qqmail/ui/ReadMailUI;
    //   163: invokevirtual 113	com/tencent/mm/plugin/qqmail/ui/ReadMailUI:getApplicationContext	()Landroid/content/Context;
    //   166: ldc 115
    //   168: invokestatic 121	com/tencent/mm/b/m:q	(Landroid/content/Context;Ljava/lang/String;)Ljava/security/PublicKey;
    //   171: astore 4
    //   173: aload_2
    //   174: iconst_0
    //   175: invokestatic 127	android/util/Base64:decode	([BI)[B
    //   178: aload 4
    //   180: invokestatic 130	com/tencent/mm/b/m:a	([BLjava/security/PublicKey;)[B
    //   183: astore_2
    //   184: aload_0
    //   185: getfield 16	com/tencent/mm/plugin/qqmail/ui/ReadMailUI$3:uRh	Lcom/tencent/mm/plugin/qqmail/ui/ReadMailUI;
    //   188: new 132	java/lang/String
    //   191: dup
    //   192: aload_2
    //   193: invokespecial 135	java/lang/String:<init>	([B)V
    //   196: invokestatic 138	com/tencent/mm/plugin/qqmail/ui/ReadMailUI:b	(Lcom/tencent/mm/plugin/qqmail/ui/ReadMailUI;Ljava/lang/String;)Ljava/lang/String;
    //   199: pop
    //   200: ldc 74
    //   202: ldc 140
    //   204: iconst_1
    //   205: anewarray 4	java/lang/Object
    //   208: dup
    //   209: iconst_0
    //   210: aload_0
    //   211: getfield 16	com/tencent/mm/plugin/qqmail/ui/ReadMailUI$3:uRh	Lcom/tencent/mm/plugin/qqmail/ui/ReadMailUI;
    //   214: invokestatic 143	com/tencent/mm/plugin/qqmail/ui/ReadMailUI:y	(Lcom/tencent/mm/plugin/qqmail/ui/ReadMailUI;)Ljava/lang/String;
    //   217: aastore
    //   218: invokestatic 109	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   221: new 10	com/tencent/mm/plugin/qqmail/ui/ReadMailUI$3$1
    //   224: dup
    //   225: aload_0
    //   226: invokespecial 146	com/tencent/mm/plugin/qqmail/ui/ReadMailUI$3$1:<init>	(Lcom/tencent/mm/plugin/qqmail/ui/ReadMailUI$3;)V
    //   229: invokestatic 152	com/tencent/mm/sdk/platformtools/aq:f	(Ljava/lang/Runnable;)V
    //   232: aload_3
    //   233: ifnull +131 -> 364
    //   236: aload_3
    //   237: invokevirtual 66	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   240: invokevirtual 87	java/io/InputStream:close	()V
    //   243: aload_3
    //   244: invokevirtual 90	java/net/HttpURLConnection:disconnect	()V
    //   247: ldc 24
    //   249: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   252: return
    //   253: astore_2
    //   254: ldc 74
    //   256: aload_2
    //   257: invokevirtual 97	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   260: invokestatic 82	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   263: goto -20 -> 243
    //   266: astore 4
    //   268: aload 5
    //   270: astore_3
    //   271: aload_3
    //   272: astore_2
    //   273: ldc 74
    //   275: aload 4
    //   277: ldc 154
    //   279: iconst_0
    //   280: anewarray 4	java/lang/Object
    //   283: invokestatic 158	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   286: aload_3
    //   287: ifnull +77 -> 364
    //   290: aload_3
    //   291: invokevirtual 66	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   294: invokevirtual 87	java/io/InputStream:close	()V
    //   297: aload_3
    //   298: invokevirtual 90	java/net/HttpURLConnection:disconnect	()V
    //   301: ldc 24
    //   303: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   306: return
    //   307: astore_2
    //   308: ldc 74
    //   310: aload_2
    //   311: invokevirtual 97	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   314: invokestatic 82	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   317: goto -20 -> 297
    //   320: astore 4
    //   322: aload_2
    //   323: astore_3
    //   324: aload 4
    //   326: astore_2
    //   327: aload_3
    //   328: ifnull +14 -> 342
    //   331: aload_3
    //   332: invokevirtual 66	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   335: invokevirtual 87	java/io/InputStream:close	()V
    //   338: aload_3
    //   339: invokevirtual 90	java/net/HttpURLConnection:disconnect	()V
    //   342: ldc 24
    //   344: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   347: aload_2
    //   348: athrow
    //   349: astore 4
    //   351: ldc 74
    //   353: aload 4
    //   355: invokevirtual 97	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   358: invokestatic 82	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   361: goto -23 -> 338
    //   364: ldc 24
    //   366: invokestatic 93	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   369: return
    //   370: astore_2
    //   371: goto -44 -> 327
    //   374: astore 4
    //   376: goto -105 -> 271
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	379	0	this	3
    //   67	56	1	i	int
    //   6	1	2	localObject1	Object
    //   109	4	2	localException1	java.lang.Exception
    //   125	68	2	arrayOfByte	byte[]
    //   253	4	2	localException2	java.lang.Exception
    //   272	1	2	localObject2	Object
    //   307	16	2	localException3	java.lang.Exception
    //   326	22	2	localObject3	Object
    //   370	1	2	localObject4	Object
    //   30	309	3	localObject5	Object
    //   58	121	4	localObject6	Object
    //   266	10	4	localException4	java.lang.Exception
    //   320	5	4	localObject7	Object
    //   349	5	4	localException5	java.lang.Exception
    //   374	1	4	localException6	java.lang.Exception
    //   8	261	5	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   92	99	109	java/lang/Exception
    //   236	243	253	java/lang/Exception
    //   10	31	266	java/lang/Exception
    //   290	297	307	java/lang/Exception
    //   10	31	320	finally
    //   273	286	320	finally
    //   331	338	349	java/lang/Exception
    //   31	68	370	finally
    //   72	88	370	finally
    //   122	232	370	finally
    //   31	68	374	java/lang/Exception
    //   72	88	374	java/lang/Exception
    //   122	232	374	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.ReadMailUI.3
 * JD-Core Version:    0.7.0.1
 */
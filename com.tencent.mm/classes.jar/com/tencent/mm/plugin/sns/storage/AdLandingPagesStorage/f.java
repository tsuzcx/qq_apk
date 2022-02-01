package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

public final class f
  extends b
{
  private a xhF;
  
  public f(String paramString1, String paramString2, boolean paramBoolean, int paramInt1, int paramInt2, a parama)
  {
    this.url = paramString1;
    this.filePath = paramString2;
    this.xhp = paramBoolean;
    this.xhq = paramInt1;
    this.scene = 0;
    this.xhF = parama;
  }
  
  /* Error */
  private String dxl()
  {
    // Byte code:
    //   0: ldc 42
    //   2: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 21	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/f:filePath	Ljava/lang/String;
    //   9: invokestatic 54	com/tencent/mm/vfs/i:eK	(Ljava/lang/String;)Z
    //   12: ifeq +10 -> 22
    //   15: ldc 42
    //   17: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   20: aconst_null
    //   21: areturn
    //   22: invokestatic 63	com/tencent/mm/sdk/platformtools/bt:eGO	()J
    //   25: lstore 5
    //   27: aload_0
    //   28: getfield 21	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/f:filePath	Ljava/lang/String;
    //   31: iconst_0
    //   32: aload_0
    //   33: getfield 21	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/f:filePath	Ljava/lang/String;
    //   36: ldc 65
    //   38: invokevirtual 71	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   41: invokevirtual 75	java/lang/String:substring	(II)Ljava/lang/String;
    //   44: invokestatic 78	com/tencent/mm/vfs/i:aMF	(Ljava/lang/String;)Z
    //   47: pop
    //   48: aload_0
    //   49: getfield 34	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/f:xhF	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/f$a;
    //   52: invokeinterface 81 1 0
    //   57: new 83	java/net/URL
    //   60: dup
    //   61: aload_0
    //   62: getfield 18	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/f:url	Ljava/lang/String;
    //   65: invokespecial 86	java/net/URL:<init>	(Ljava/lang/String;)V
    //   68: invokevirtual 90	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   71: checkcast 92	java/net/HttpURLConnection
    //   74: astore 7
    //   76: aload 7
    //   78: invokevirtual 95	java/net/HttpURLConnection:connect	()V
    //   81: aload 7
    //   83: invokevirtual 99	java/net/HttpURLConnection:getResponseCode	()I
    //   86: istore_2
    //   87: iload_2
    //   88: sipush 200
    //   91: if_icmpeq +379 -> 470
    //   94: aload_0
    //   95: getfield 34	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/f:xhF	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/f$a;
    //   98: invokeinterface 102 1 0
    //   103: new 104	java/lang/StringBuilder
    //   106: dup
    //   107: ldc 106
    //   109: invokespecial 107	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   112: aload 7
    //   114: invokevirtual 99	java/net/HttpURLConnection:getResponseCode	()I
    //   117: invokevirtual 111	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   120: ldc 113
    //   122: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: aload 7
    //   127: invokevirtual 119	java/net/HttpURLConnection:getResponseMessage	()Ljava/lang/String;
    //   130: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   133: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: astore 8
    //   138: aload 7
    //   140: invokevirtual 126	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   143: invokevirtual 131	java/io/InputStream:close	()V
    //   146: aload 7
    //   148: ifnull +8 -> 156
    //   151: aload 7
    //   153: invokevirtual 134	java/net/HttpURLConnection:disconnect	()V
    //   156: aload_0
    //   157: getfield 18	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/f:url	Ljava/lang/String;
    //   160: invokestatic 140	com/tencent/mm/sdk/platformtools/ai:du	(Ljava/lang/String;)Ljava/lang/String;
    //   163: astore 9
    //   165: aload_0
    //   166: invokespecial 143	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/f:getMediaType	()I
    //   169: istore_1
    //   170: lload 5
    //   172: invokestatic 147	com/tencent/mm/sdk/platformtools/bt:vM	(J)J
    //   175: l2i
    //   176: istore_3
    //   177: new 149	com/tencent/mm/modelsns/f
    //   180: dup
    //   181: invokespecial 150	com/tencent/mm/modelsns/f:<init>	()V
    //   184: astore 7
    //   186: aload 7
    //   188: ldc 152
    //   190: new 104	java/lang/StringBuilder
    //   193: dup
    //   194: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   197: aload 9
    //   199: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: ldc 155
    //   204: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: invokevirtual 158	com/tencent/mm/modelsns/f:o	(Ljava/lang/String;Ljava/lang/Object;)V
    //   213: aload 7
    //   215: ldc 160
    //   217: new 104	java/lang/StringBuilder
    //   220: dup
    //   221: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   224: iload_1
    //   225: invokevirtual 111	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   228: ldc 155
    //   230: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   236: invokevirtual 158	com/tencent/mm/modelsns/f:o	(Ljava/lang/String;Ljava/lang/Object;)V
    //   239: new 104	java/lang/StringBuilder
    //   242: dup
    //   243: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   246: astore 9
    //   248: aload_0
    //   249: getfield 25	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/f:xhp	Z
    //   252: ifeq +213 -> 465
    //   255: iconst_1
    //   256: istore_1
    //   257: aload 7
    //   259: ldc 162
    //   261: aload 9
    //   263: iload_1
    //   264: invokevirtual 111	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   267: ldc 155
    //   269: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   275: invokevirtual 158	com/tencent/mm/modelsns/f:o	(Ljava/lang/String;Ljava/lang/Object;)V
    //   278: aload 7
    //   280: ldc 164
    //   282: new 104	java/lang/StringBuilder
    //   285: dup
    //   286: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   289: iload_3
    //   290: invokevirtual 111	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   293: ldc 155
    //   295: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   301: invokevirtual 158	com/tencent/mm/modelsns/f:o	(Ljava/lang/String;Ljava/lang/Object;)V
    //   304: aload 7
    //   306: ldc 166
    //   308: new 104	java/lang/StringBuilder
    //   311: dup
    //   312: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   315: iload_2
    //   316: invokevirtual 111	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   319: ldc 155
    //   321: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   327: invokevirtual 158	com/tencent/mm/modelsns/f:o	(Ljava/lang/String;Ljava/lang/Object;)V
    //   330: aload 7
    //   332: ldc 168
    //   334: new 104	java/lang/StringBuilder
    //   337: dup
    //   338: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   341: aload_0
    //   342: getfield 32	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/f:scene	I
    //   345: invokevirtual 111	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   348: ldc 155
    //   350: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   356: invokevirtual 158	com/tencent/mm/modelsns/f:o	(Ljava/lang/String;Ljava/lang/Object;)V
    //   359: aload 7
    //   361: ldc 170
    //   363: ldc 172
    //   365: invokevirtual 158	com/tencent/mm/modelsns/f:o	(Ljava/lang/String;Ljava/lang/Object;)V
    //   368: aload 7
    //   370: ldc 174
    //   372: new 104	java/lang/StringBuilder
    //   375: dup
    //   376: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   379: lload 5
    //   381: ldc2_w 175
    //   384: ldiv
    //   385: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   388: ldc 155
    //   390: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   396: invokevirtual 158	com/tencent/mm/modelsns/f:o	(Ljava/lang/String;Ljava/lang/Object;)V
    //   399: ldc 181
    //   401: new 104	java/lang/StringBuilder
    //   404: dup
    //   405: ldc 183
    //   407: invokespecial 107	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   410: aload 7
    //   412: invokevirtual 186	com/tencent/mm/modelsns/f:PW	()Ljava/lang/String;
    //   415: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   418: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   421: invokestatic 191	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   424: getstatic 197	com/tencent/mm/plugin/report/service/h:vKh	Lcom/tencent/mm/plugin/report/service/h;
    //   427: sipush 13572
    //   430: iconst_1
    //   431: anewarray 199	java/lang/Object
    //   434: dup
    //   435: iconst_0
    //   436: aload 7
    //   438: aastore
    //   439: invokevirtual 203	com/tencent/mm/plugin/report/service/h:f	(I[Ljava/lang/Object;)V
    //   442: ldc 42
    //   444: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   447: aload 8
    //   449: areturn
    //   450: astore 9
    //   452: ldc 181
    //   454: aload 9
    //   456: invokevirtual 206	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   459: invokestatic 209	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   462: goto -316 -> 146
    //   465: iconst_0
    //   466: istore_1
    //   467: goto -210 -> 257
    //   470: aload 7
    //   472: invokevirtual 212	java/net/HttpURLConnection:getContentLength	()I
    //   475: pop
    //   476: aload 7
    //   478: invokevirtual 126	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   481: astore 10
    //   483: aload_0
    //   484: getfield 21	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/f:filePath	Ljava/lang/String;
    //   487: iconst_0
    //   488: invokestatic 216	com/tencent/mm/vfs/i:cM	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   491: astore 9
    //   493: sipush 4096
    //   496: newarray byte
    //   498: astore 8
    //   500: iconst_0
    //   501: istore_1
    //   502: aload 10
    //   504: aload 8
    //   506: invokevirtual 220	java/io/InputStream:read	([B)I
    //   509: istore_3
    //   510: iload_3
    //   511: iconst_m1
    //   512: if_icmpeq +401 -> 913
    //   515: aload_0
    //   516: invokevirtual 224	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/f:isCancelled	()Z
    //   519: ifeq +378 -> 897
    //   522: aload 10
    //   524: invokevirtual 131	java/io/InputStream:close	()V
    //   527: aload 9
    //   529: ifnull +8 -> 537
    //   532: aload 9
    //   534: invokevirtual 227	java/io/OutputStream:close	()V
    //   537: aload 10
    //   539: ifnull +8 -> 547
    //   542: aload 10
    //   544: invokevirtual 131	java/io/InputStream:close	()V
    //   547: aload 7
    //   549: invokevirtual 126	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   552: invokevirtual 131	java/io/InputStream:close	()V
    //   555: aload 7
    //   557: ifnull +8 -> 565
    //   560: aload 7
    //   562: invokevirtual 134	java/net/HttpURLConnection:disconnect	()V
    //   565: aload_0
    //   566: getfield 18	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/f:url	Ljava/lang/String;
    //   569: invokestatic 140	com/tencent/mm/sdk/platformtools/ai:du	(Ljava/lang/String;)Ljava/lang/String;
    //   572: astore 8
    //   574: aload_0
    //   575: invokespecial 143	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/f:getMediaType	()I
    //   578: istore_3
    //   579: lload 5
    //   581: invokestatic 147	com/tencent/mm/sdk/platformtools/bt:vM	(J)J
    //   584: l2i
    //   585: istore 4
    //   587: new 149	com/tencent/mm/modelsns/f
    //   590: dup
    //   591: invokespecial 150	com/tencent/mm/modelsns/f:<init>	()V
    //   594: astore 7
    //   596: aload 7
    //   598: ldc 152
    //   600: new 104	java/lang/StringBuilder
    //   603: dup
    //   604: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   607: aload 8
    //   609: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   612: ldc 155
    //   614: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   617: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   620: invokevirtual 158	com/tencent/mm/modelsns/f:o	(Ljava/lang/String;Ljava/lang/Object;)V
    //   623: aload 7
    //   625: ldc 160
    //   627: new 104	java/lang/StringBuilder
    //   630: dup
    //   631: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   634: iload_3
    //   635: invokevirtual 111	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   638: ldc 155
    //   640: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   643: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   646: invokevirtual 158	com/tencent/mm/modelsns/f:o	(Ljava/lang/String;Ljava/lang/Object;)V
    //   649: new 104	java/lang/StringBuilder
    //   652: dup
    //   653: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   656: astore 8
    //   658: aload_0
    //   659: getfield 25	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/f:xhp	Z
    //   662: ifeq +230 -> 892
    //   665: iconst_1
    //   666: istore_3
    //   667: aload 7
    //   669: ldc 162
    //   671: aload 8
    //   673: iload_3
    //   674: invokevirtual 111	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   677: ldc 155
    //   679: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   682: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   685: invokevirtual 158	com/tencent/mm/modelsns/f:o	(Ljava/lang/String;Ljava/lang/Object;)V
    //   688: aload 7
    //   690: ldc 164
    //   692: new 104	java/lang/StringBuilder
    //   695: dup
    //   696: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   699: iload 4
    //   701: invokevirtual 111	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   704: ldc 155
    //   706: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   709: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   712: invokevirtual 158	com/tencent/mm/modelsns/f:o	(Ljava/lang/String;Ljava/lang/Object;)V
    //   715: aload 7
    //   717: ldc 166
    //   719: new 104	java/lang/StringBuilder
    //   722: dup
    //   723: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   726: iload_2
    //   727: invokevirtual 111	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   730: ldc 155
    //   732: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   735: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   738: invokevirtual 158	com/tencent/mm/modelsns/f:o	(Ljava/lang/String;Ljava/lang/Object;)V
    //   741: aload 7
    //   743: ldc 168
    //   745: new 104	java/lang/StringBuilder
    //   748: dup
    //   749: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   752: aload_0
    //   753: getfield 32	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/f:scene	I
    //   756: invokevirtual 111	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   759: ldc 155
    //   761: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   764: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   767: invokevirtual 158	com/tencent/mm/modelsns/f:o	(Ljava/lang/String;Ljava/lang/Object;)V
    //   770: aload 7
    //   772: ldc 170
    //   774: new 104	java/lang/StringBuilder
    //   777: dup
    //   778: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   781: iload_1
    //   782: invokevirtual 111	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   785: ldc 155
    //   787: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   790: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   793: invokevirtual 158	com/tencent/mm/modelsns/f:o	(Ljava/lang/String;Ljava/lang/Object;)V
    //   796: aload 7
    //   798: ldc 174
    //   800: new 104	java/lang/StringBuilder
    //   803: dup
    //   804: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   807: lload 5
    //   809: ldc2_w 175
    //   812: ldiv
    //   813: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   816: ldc 155
    //   818: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   821: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   824: invokevirtual 158	com/tencent/mm/modelsns/f:o	(Ljava/lang/String;Ljava/lang/Object;)V
    //   827: ldc 181
    //   829: new 104	java/lang/StringBuilder
    //   832: dup
    //   833: ldc 183
    //   835: invokespecial 107	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   838: aload 7
    //   840: invokevirtual 186	com/tencent/mm/modelsns/f:PW	()Ljava/lang/String;
    //   843: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   846: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   849: invokestatic 191	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   852: getstatic 197	com/tencent/mm/plugin/report/service/h:vKh	Lcom/tencent/mm/plugin/report/service/h;
    //   855: sipush 13572
    //   858: iconst_1
    //   859: anewarray 199	java/lang/Object
    //   862: dup
    //   863: iconst_0
    //   864: aload 7
    //   866: aastore
    //   867: invokevirtual 203	com/tencent/mm/plugin/report/service/h:f	(I[Ljava/lang/Object;)V
    //   870: ldc 42
    //   872: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   875: aconst_null
    //   876: areturn
    //   877: astore 8
    //   879: ldc 181
    //   881: aload 8
    //   883: invokevirtual 206	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   886: invokestatic 209	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   889: goto -334 -> 555
    //   892: iconst_0
    //   893: istore_3
    //   894: goto -227 -> 667
    //   897: aload 9
    //   899: aload 8
    //   901: iconst_0
    //   902: iload_3
    //   903: invokevirtual 231	java/io/OutputStream:write	([BII)V
    //   906: iload_1
    //   907: iload_3
    //   908: iadd
    //   909: istore_1
    //   910: goto -408 -> 502
    //   913: aload 9
    //   915: ifnull +8 -> 923
    //   918: aload 9
    //   920: invokevirtual 227	java/io/OutputStream:close	()V
    //   923: aload 10
    //   925: ifnull +8 -> 933
    //   928: aload 10
    //   930: invokevirtual 131	java/io/InputStream:close	()V
    //   933: aload 7
    //   935: invokevirtual 126	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   938: invokevirtual 131	java/io/InputStream:close	()V
    //   941: aload 7
    //   943: ifnull +8 -> 951
    //   946: aload 7
    //   948: invokevirtual 134	java/net/HttpURLConnection:disconnect	()V
    //   951: aload_0
    //   952: getfield 18	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/f:url	Ljava/lang/String;
    //   955: invokestatic 140	com/tencent/mm/sdk/platformtools/ai:du	(Ljava/lang/String;)Ljava/lang/String;
    //   958: astore 8
    //   960: aload_0
    //   961: invokespecial 143	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/f:getMediaType	()I
    //   964: istore_3
    //   965: lload 5
    //   967: invokestatic 147	com/tencent/mm/sdk/platformtools/bt:vM	(J)J
    //   970: l2i
    //   971: istore 4
    //   973: new 149	com/tencent/mm/modelsns/f
    //   976: dup
    //   977: invokespecial 150	com/tencent/mm/modelsns/f:<init>	()V
    //   980: astore 7
    //   982: aload 7
    //   984: ldc 152
    //   986: new 104	java/lang/StringBuilder
    //   989: dup
    //   990: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   993: aload 8
    //   995: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   998: ldc 155
    //   1000: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1003: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1006: invokevirtual 158	com/tencent/mm/modelsns/f:o	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1009: aload 7
    //   1011: ldc 160
    //   1013: new 104	java/lang/StringBuilder
    //   1016: dup
    //   1017: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   1020: iload_3
    //   1021: invokevirtual 111	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1024: ldc 155
    //   1026: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1029: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1032: invokevirtual 158	com/tencent/mm/modelsns/f:o	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1035: new 104	java/lang/StringBuilder
    //   1038: dup
    //   1039: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   1042: astore 8
    //   1044: aload_0
    //   1045: getfield 25	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/f:xhp	Z
    //   1048: ifeq +230 -> 1278
    //   1051: iconst_1
    //   1052: istore_3
    //   1053: aload 7
    //   1055: ldc 162
    //   1057: aload 8
    //   1059: iload_3
    //   1060: invokevirtual 111	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1063: ldc 155
    //   1065: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1068: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1071: invokevirtual 158	com/tencent/mm/modelsns/f:o	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1074: aload 7
    //   1076: ldc 164
    //   1078: new 104	java/lang/StringBuilder
    //   1081: dup
    //   1082: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   1085: iload 4
    //   1087: invokevirtual 111	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1090: ldc 155
    //   1092: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1095: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1098: invokevirtual 158	com/tencent/mm/modelsns/f:o	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1101: aload 7
    //   1103: ldc 166
    //   1105: new 104	java/lang/StringBuilder
    //   1108: dup
    //   1109: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   1112: iload_2
    //   1113: invokevirtual 111	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1116: ldc 155
    //   1118: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1121: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1124: invokevirtual 158	com/tencent/mm/modelsns/f:o	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1127: aload 7
    //   1129: ldc 168
    //   1131: new 104	java/lang/StringBuilder
    //   1134: dup
    //   1135: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   1138: aload_0
    //   1139: getfield 32	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/f:scene	I
    //   1142: invokevirtual 111	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1145: ldc 155
    //   1147: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1150: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1153: invokevirtual 158	com/tencent/mm/modelsns/f:o	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1156: aload 7
    //   1158: ldc 170
    //   1160: new 104	java/lang/StringBuilder
    //   1163: dup
    //   1164: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   1167: iload_1
    //   1168: invokevirtual 111	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1171: ldc 155
    //   1173: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1176: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1179: invokevirtual 158	com/tencent/mm/modelsns/f:o	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1182: aload 7
    //   1184: ldc 174
    //   1186: new 104	java/lang/StringBuilder
    //   1189: dup
    //   1190: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   1193: lload 5
    //   1195: ldc2_w 175
    //   1198: ldiv
    //   1199: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1202: ldc 155
    //   1204: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1207: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1210: invokevirtual 158	com/tencent/mm/modelsns/f:o	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1213: ldc 181
    //   1215: new 104	java/lang/StringBuilder
    //   1218: dup
    //   1219: ldc 183
    //   1221: invokespecial 107	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1224: aload 7
    //   1226: invokevirtual 186	com/tencent/mm/modelsns/f:PW	()Ljava/lang/String;
    //   1229: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1232: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1235: invokestatic 191	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1238: getstatic 197	com/tencent/mm/plugin/report/service/h:vKh	Lcom/tencent/mm/plugin/report/service/h;
    //   1241: sipush 13572
    //   1244: iconst_1
    //   1245: anewarray 199	java/lang/Object
    //   1248: dup
    //   1249: iconst_0
    //   1250: aload 7
    //   1252: aastore
    //   1253: invokevirtual 203	com/tencent/mm/plugin/report/service/h:f	(I[Ljava/lang/Object;)V
    //   1256: ldc 42
    //   1258: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1261: aconst_null
    //   1262: areturn
    //   1263: astore 8
    //   1265: ldc 181
    //   1267: aload 8
    //   1269: invokevirtual 206	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1272: invokestatic 209	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1275: goto -334 -> 941
    //   1278: iconst_0
    //   1279: istore_3
    //   1280: goto -227 -> 1053
    //   1283: astore 7
    //   1285: aconst_null
    //   1286: astore 8
    //   1288: aconst_null
    //   1289: astore 9
    //   1291: aconst_null
    //   1292: astore 10
    //   1294: iconst_0
    //   1295: istore_1
    //   1296: iconst_0
    //   1297: istore_2
    //   1298: iload_2
    //   1299: istore_3
    //   1300: aload_0
    //   1301: getfield 34	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/f:xhF	Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/f$a;
    //   1304: invokeinterface 102 1 0
    //   1309: iload_2
    //   1310: istore_3
    //   1311: aload_0
    //   1312: getfield 21	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/f:filePath	Ljava/lang/String;
    //   1315: invokestatic 234	com/tencent/mm/vfs/i:deleteFile	(Ljava/lang/String;)Z
    //   1318: pop
    //   1319: iconst_m1
    //   1320: istore_3
    //   1321: aload 7
    //   1323: invokevirtual 235	java/lang/Exception:toString	()Ljava/lang/String;
    //   1326: astore 7
    //   1328: aload 9
    //   1330: ifnull +8 -> 1338
    //   1333: aload 9
    //   1335: invokevirtual 227	java/io/OutputStream:close	()V
    //   1338: aload 10
    //   1340: ifnull +8 -> 1348
    //   1343: aload 10
    //   1345: invokevirtual 131	java/io/InputStream:close	()V
    //   1348: aload 8
    //   1350: invokevirtual 126	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1353: invokevirtual 131	java/io/InputStream:close	()V
    //   1356: aload 8
    //   1358: ifnull +8 -> 1366
    //   1361: aload 8
    //   1363: invokevirtual 134	java/net/HttpURLConnection:disconnect	()V
    //   1366: aload_0
    //   1367: getfield 18	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/f:url	Ljava/lang/String;
    //   1370: invokestatic 140	com/tencent/mm/sdk/platformtools/ai:du	(Ljava/lang/String;)Ljava/lang/String;
    //   1373: astore 9
    //   1375: aload_0
    //   1376: invokespecial 143	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/f:getMediaType	()I
    //   1379: istore_2
    //   1380: lload 5
    //   1382: invokestatic 147	com/tencent/mm/sdk/platformtools/bt:vM	(J)J
    //   1385: l2i
    //   1386: istore_3
    //   1387: new 149	com/tencent/mm/modelsns/f
    //   1390: dup
    //   1391: invokespecial 150	com/tencent/mm/modelsns/f:<init>	()V
    //   1394: astore 8
    //   1396: aload 8
    //   1398: ldc 152
    //   1400: new 104	java/lang/StringBuilder
    //   1403: dup
    //   1404: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   1407: aload 9
    //   1409: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1412: ldc 155
    //   1414: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1417: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1420: invokevirtual 158	com/tencent/mm/modelsns/f:o	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1423: aload 8
    //   1425: ldc 160
    //   1427: new 104	java/lang/StringBuilder
    //   1430: dup
    //   1431: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   1434: iload_2
    //   1435: invokevirtual 111	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1438: ldc 155
    //   1440: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1443: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1446: invokevirtual 158	com/tencent/mm/modelsns/f:o	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1449: new 104	java/lang/StringBuilder
    //   1452: dup
    //   1453: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   1456: astore 9
    //   1458: aload_0
    //   1459: getfield 25	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/f:xhp	Z
    //   1462: ifeq +213 -> 1675
    //   1465: iconst_1
    //   1466: istore_2
    //   1467: aload 8
    //   1469: ldc 162
    //   1471: aload 9
    //   1473: iload_2
    //   1474: invokevirtual 111	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1477: ldc 155
    //   1479: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1482: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1485: invokevirtual 158	com/tencent/mm/modelsns/f:o	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1488: aload 8
    //   1490: ldc 164
    //   1492: new 104	java/lang/StringBuilder
    //   1495: dup
    //   1496: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   1499: iload_3
    //   1500: invokevirtual 111	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1503: ldc 155
    //   1505: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1508: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1511: invokevirtual 158	com/tencent/mm/modelsns/f:o	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1514: aload 8
    //   1516: ldc 166
    //   1518: ldc 237
    //   1520: invokevirtual 158	com/tencent/mm/modelsns/f:o	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1523: aload 8
    //   1525: ldc 168
    //   1527: new 104	java/lang/StringBuilder
    //   1530: dup
    //   1531: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   1534: aload_0
    //   1535: getfield 32	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/f:scene	I
    //   1538: invokevirtual 111	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1541: ldc 155
    //   1543: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1546: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1549: invokevirtual 158	com/tencent/mm/modelsns/f:o	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1552: aload 8
    //   1554: ldc 170
    //   1556: new 104	java/lang/StringBuilder
    //   1559: dup
    //   1560: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   1563: iload_1
    //   1564: invokevirtual 111	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1567: ldc 155
    //   1569: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1572: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1575: invokevirtual 158	com/tencent/mm/modelsns/f:o	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1578: aload 8
    //   1580: ldc 174
    //   1582: new 104	java/lang/StringBuilder
    //   1585: dup
    //   1586: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   1589: lload 5
    //   1591: ldc2_w 175
    //   1594: ldiv
    //   1595: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1598: ldc 155
    //   1600: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1603: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1606: invokevirtual 158	com/tencent/mm/modelsns/f:o	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1609: ldc 181
    //   1611: new 104	java/lang/StringBuilder
    //   1614: dup
    //   1615: ldc 183
    //   1617: invokespecial 107	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1620: aload 8
    //   1622: invokevirtual 186	com/tencent/mm/modelsns/f:PW	()Ljava/lang/String;
    //   1625: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1628: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1631: invokestatic 191	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1634: getstatic 197	com/tencent/mm/plugin/report/service/h:vKh	Lcom/tencent/mm/plugin/report/service/h;
    //   1637: sipush 13572
    //   1640: iconst_1
    //   1641: anewarray 199	java/lang/Object
    //   1644: dup
    //   1645: iconst_0
    //   1646: aload 8
    //   1648: aastore
    //   1649: invokevirtual 203	com/tencent/mm/plugin/report/service/h:f	(I[Ljava/lang/Object;)V
    //   1652: ldc 42
    //   1654: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1657: aload 7
    //   1659: areturn
    //   1660: astore 9
    //   1662: ldc 181
    //   1664: aload 9
    //   1666: invokevirtual 206	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1669: invokestatic 209	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1672: goto -316 -> 1356
    //   1675: iconst_0
    //   1676: istore_2
    //   1677: goto -210 -> 1467
    //   1680: astore 7
    //   1682: aconst_null
    //   1683: astore 8
    //   1685: aconst_null
    //   1686: astore 9
    //   1688: aconst_null
    //   1689: astore 10
    //   1691: iconst_0
    //   1692: istore_1
    //   1693: iconst_0
    //   1694: istore_2
    //   1695: aload 9
    //   1697: ifnull +8 -> 1705
    //   1700: aload 9
    //   1702: invokevirtual 227	java/io/OutputStream:close	()V
    //   1705: aload 10
    //   1707: ifnull +8 -> 1715
    //   1710: aload 10
    //   1712: invokevirtual 131	java/io/InputStream:close	()V
    //   1715: aload 8
    //   1717: invokevirtual 126	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   1720: invokevirtual 131	java/io/InputStream:close	()V
    //   1723: aload 8
    //   1725: ifnull +8 -> 1733
    //   1728: aload 8
    //   1730: invokevirtual 134	java/net/HttpURLConnection:disconnect	()V
    //   1733: aload_0
    //   1734: getfield 18	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/f:url	Ljava/lang/String;
    //   1737: invokestatic 140	com/tencent/mm/sdk/platformtools/ai:du	(Ljava/lang/String;)Ljava/lang/String;
    //   1740: astore 9
    //   1742: aload_0
    //   1743: invokespecial 143	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/f:getMediaType	()I
    //   1746: istore_3
    //   1747: lload 5
    //   1749: invokestatic 147	com/tencent/mm/sdk/platformtools/bt:vM	(J)J
    //   1752: l2i
    //   1753: istore 4
    //   1755: new 149	com/tencent/mm/modelsns/f
    //   1758: dup
    //   1759: invokespecial 150	com/tencent/mm/modelsns/f:<init>	()V
    //   1762: astore 8
    //   1764: aload 8
    //   1766: ldc 152
    //   1768: new 104	java/lang/StringBuilder
    //   1771: dup
    //   1772: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   1775: aload 9
    //   1777: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1780: ldc 155
    //   1782: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1785: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1788: invokevirtual 158	com/tencent/mm/modelsns/f:o	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1791: aload 8
    //   1793: ldc 160
    //   1795: new 104	java/lang/StringBuilder
    //   1798: dup
    //   1799: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   1802: iload_3
    //   1803: invokevirtual 111	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1806: ldc 155
    //   1808: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1811: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1814: invokevirtual 158	com/tencent/mm/modelsns/f:o	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1817: new 104	java/lang/StringBuilder
    //   1820: dup
    //   1821: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   1824: astore 9
    //   1826: aload_0
    //   1827: getfield 25	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/f:xhp	Z
    //   1830: ifeq +231 -> 2061
    //   1833: iconst_1
    //   1834: istore_3
    //   1835: aload 8
    //   1837: ldc 162
    //   1839: aload 9
    //   1841: iload_3
    //   1842: invokevirtual 111	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1845: ldc 155
    //   1847: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1850: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1853: invokevirtual 158	com/tencent/mm/modelsns/f:o	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1856: aload 8
    //   1858: ldc 164
    //   1860: new 104	java/lang/StringBuilder
    //   1863: dup
    //   1864: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   1867: iload 4
    //   1869: invokevirtual 111	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1872: ldc 155
    //   1874: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1877: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1880: invokevirtual 158	com/tencent/mm/modelsns/f:o	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1883: aload 8
    //   1885: ldc 166
    //   1887: new 104	java/lang/StringBuilder
    //   1890: dup
    //   1891: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   1894: iload_2
    //   1895: invokevirtual 111	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1898: ldc 155
    //   1900: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1903: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1906: invokevirtual 158	com/tencent/mm/modelsns/f:o	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1909: aload 8
    //   1911: ldc 168
    //   1913: new 104	java/lang/StringBuilder
    //   1916: dup
    //   1917: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   1920: aload_0
    //   1921: getfield 32	com/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/f:scene	I
    //   1924: invokevirtual 111	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1927: ldc 155
    //   1929: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1932: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1935: invokevirtual 158	com/tencent/mm/modelsns/f:o	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1938: aload 8
    //   1940: ldc 170
    //   1942: new 104	java/lang/StringBuilder
    //   1945: dup
    //   1946: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   1949: iload_1
    //   1950: invokevirtual 111	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1953: ldc 155
    //   1955: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1958: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1961: invokevirtual 158	com/tencent/mm/modelsns/f:o	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1964: aload 8
    //   1966: ldc 174
    //   1968: new 104	java/lang/StringBuilder
    //   1971: dup
    //   1972: invokespecial 153	java/lang/StringBuilder:<init>	()V
    //   1975: lload 5
    //   1977: ldc2_w 175
    //   1980: ldiv
    //   1981: invokevirtual 179	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1984: ldc 155
    //   1986: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1989: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1992: invokevirtual 158	com/tencent/mm/modelsns/f:o	(Ljava/lang/String;Ljava/lang/Object;)V
    //   1995: ldc 181
    //   1997: new 104	java/lang/StringBuilder
    //   2000: dup
    //   2001: ldc 183
    //   2003: invokespecial 107	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2006: aload 8
    //   2008: invokevirtual 186	com/tencent/mm/modelsns/f:PW	()Ljava/lang/String;
    //   2011: invokevirtual 116	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2014: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2017: invokestatic 191	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2020: getstatic 197	com/tencent/mm/plugin/report/service/h:vKh	Lcom/tencent/mm/plugin/report/service/h;
    //   2023: sipush 13572
    //   2026: iconst_1
    //   2027: anewarray 199	java/lang/Object
    //   2030: dup
    //   2031: iconst_0
    //   2032: aload 8
    //   2034: aastore
    //   2035: invokevirtual 203	com/tencent/mm/plugin/report/service/h:f	(I[Ljava/lang/Object;)V
    //   2038: ldc 42
    //   2040: invokestatic 57	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   2043: aload 7
    //   2045: athrow
    //   2046: astore 9
    //   2048: ldc 181
    //   2050: aload 9
    //   2052: invokevirtual 206	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2055: invokestatic 209	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2058: goto -335 -> 1723
    //   2061: iconst_0
    //   2062: istore_3
    //   2063: goto -228 -> 1835
    //   2066: astore 9
    //   2068: goto -353 -> 1715
    //   2071: astore 11
    //   2073: aload 7
    //   2075: astore 8
    //   2077: aconst_null
    //   2078: astore 9
    //   2080: aconst_null
    //   2081: astore 10
    //   2083: iconst_0
    //   2084: istore_1
    //   2085: iconst_0
    //   2086: istore_2
    //   2087: aload 11
    //   2089: astore 7
    //   2091: goto -396 -> 1695
    //   2094: astore 11
    //   2096: aload 7
    //   2098: astore 8
    //   2100: aconst_null
    //   2101: astore 9
    //   2103: aconst_null
    //   2104: astore 10
    //   2106: iconst_0
    //   2107: istore_1
    //   2108: aload 11
    //   2110: astore 7
    //   2112: goto -417 -> 1695
    //   2115: astore 11
    //   2117: aload 7
    //   2119: astore 8
    //   2121: aconst_null
    //   2122: astore 9
    //   2124: iconst_0
    //   2125: istore_1
    //   2126: aload 11
    //   2128: astore 7
    //   2130: goto -435 -> 1695
    //   2133: astore 8
    //   2135: aload 7
    //   2137: astore 11
    //   2139: iconst_0
    //   2140: istore_1
    //   2141: aload 8
    //   2143: astore 7
    //   2145: aload 11
    //   2147: astore 8
    //   2149: goto -454 -> 1695
    //   2152: astore 8
    //   2154: aload 7
    //   2156: astore 11
    //   2158: aload 8
    //   2160: astore 7
    //   2162: aload 11
    //   2164: astore 8
    //   2166: goto -471 -> 1695
    //   2169: astore 7
    //   2171: iload_3
    //   2172: istore_2
    //   2173: goto -478 -> 1695
    //   2176: astore 9
    //   2178: goto -830 -> 1348
    //   2181: astore 11
    //   2183: aload 7
    //   2185: astore 8
    //   2187: aconst_null
    //   2188: astore 9
    //   2190: aconst_null
    //   2191: astore 10
    //   2193: iconst_0
    //   2194: istore_1
    //   2195: iconst_0
    //   2196: istore_2
    //   2197: aload 11
    //   2199: astore 7
    //   2201: goto -903 -> 1298
    //   2204: astore 11
    //   2206: aload 7
    //   2208: astore 8
    //   2210: aconst_null
    //   2211: astore 9
    //   2213: aconst_null
    //   2214: astore 10
    //   2216: iconst_0
    //   2217: istore_1
    //   2218: aload 11
    //   2220: astore 7
    //   2222: goto -924 -> 1298
    //   2225: astore 11
    //   2227: aload 7
    //   2229: astore 8
    //   2231: aconst_null
    //   2232: astore 9
    //   2234: iconst_0
    //   2235: istore_1
    //   2236: aload 11
    //   2238: astore 7
    //   2240: goto -942 -> 1298
    //   2243: astore 8
    //   2245: aload 7
    //   2247: astore 11
    //   2249: iconst_0
    //   2250: istore_1
    //   2251: aload 8
    //   2253: astore 7
    //   2255: aload 11
    //   2257: astore 8
    //   2259: goto -961 -> 1298
    //   2262: astore 8
    //   2264: aload 7
    //   2266: astore 11
    //   2268: aload 8
    //   2270: astore 7
    //   2272: aload 11
    //   2274: astore 8
    //   2276: goto -978 -> 1298
    //   2279: astore 8
    //   2281: goto -1348 -> 933
    //   2284: astore 8
    //   2286: goto -1739 -> 547
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2289	0	this	f
    //   169	2082	1	i	int
    //   86	2111	2	j	int
    //   176	1996	3	k	int
    //   585	1283	4	m	int
    //   25	1951	5	l	long
    //   74	1177	7	localObject1	Object
    //   1283	39	7	localException1	java.lang.Exception
    //   1326	332	7	str	String
    //   1680	394	7	localObject2	Object
    //   2089	72	7	localObject3	Object
    //   2169	15	7	localObject4	Object
    //   2199	72	7	localObject5	Object
    //   136	536	8	localObject6	Object
    //   877	23	8	localException2	java.lang.Exception
    //   958	100	8	localObject7	Object
    //   1263	5	8	localException3	java.lang.Exception
    //   1286	834	8	localObject8	Object
    //   2133	9	8	localObject9	Object
    //   2147	1	8	localObject10	Object
    //   2152	7	8	localObject11	Object
    //   2164	66	8	localObject12	Object
    //   2243	9	8	localException4	java.lang.Exception
    //   2257	1	8	localObject13	Object
    //   2262	7	8	localException5	java.lang.Exception
    //   2274	1	8	localObject14	Object
    //   2279	1	8	localIOException1	java.io.IOException
    //   2284	1	8	localIOException2	java.io.IOException
    //   163	99	9	localObject15	Object
    //   450	5	9	localException6	java.lang.Exception
    //   491	981	9	localObject16	Object
    //   1660	5	9	localException7	java.lang.Exception
    //   1686	154	9	localObject17	Object
    //   2046	5	9	localException8	java.lang.Exception
    //   2066	1	9	localIOException3	java.io.IOException
    //   2078	45	9	localObject18	Object
    //   2176	1	9	localIOException4	java.io.IOException
    //   2188	45	9	localObject19	Object
    //   481	1734	10	localInputStream	java.io.InputStream
    //   2071	17	11	localObject20	Object
    //   2094	15	11	localObject21	Object
    //   2115	12	11	localObject22	Object
    //   2137	26	11	localObject23	Object
    //   2181	17	11	localException9	java.lang.Exception
    //   2204	15	11	localException10	java.lang.Exception
    //   2225	12	11	localException11	java.lang.Exception
    //   2247	26	11	localObject24	Object
    // Exception table:
    //   from	to	target	type
    //   138	146	450	java/lang/Exception
    //   547	555	877	java/lang/Exception
    //   933	941	1263	java/lang/Exception
    //   57	76	1283	java/lang/Exception
    //   1348	1356	1660	java/lang/Exception
    //   57	76	1680	finally
    //   1715	1723	2046	java/lang/Exception
    //   1700	1705	2066	java/io/IOException
    //   1710	1715	2066	java/io/IOException
    //   76	87	2071	finally
    //   94	138	2094	finally
    //   470	483	2094	finally
    //   483	493	2115	finally
    //   493	500	2133	finally
    //   502	510	2152	finally
    //   515	527	2152	finally
    //   897	906	2152	finally
    //   1300	1309	2169	finally
    //   1311	1319	2169	finally
    //   1321	1328	2169	finally
    //   1333	1338	2176	java/io/IOException
    //   1343	1348	2176	java/io/IOException
    //   76	87	2181	java/lang/Exception
    //   94	138	2204	java/lang/Exception
    //   470	483	2204	java/lang/Exception
    //   483	493	2225	java/lang/Exception
    //   493	500	2243	java/lang/Exception
    //   502	510	2262	java/lang/Exception
    //   515	527	2262	java/lang/Exception
    //   897	906	2262	java/lang/Exception
    //   918	923	2279	java/io/IOException
    //   928	933	2279	java/io/IOException
    //   532	537	2284	java/io/IOException
    //   542	547	2284	java/io/IOException
  }
  
  private int getMediaType()
  {
    int i = 1;
    switch (this.xhq)
    {
    default: 
      i = 0;
    case 41: 
    case 44: 
    case 45: 
    case 133: 
    case 1000000001: 
      return i;
    case 61: 
      return 2;
    }
    return 3;
  }
  
  public static abstract interface a
  {
    public abstract void apm(String paramString);
    
    public abstract void dsA();
    
    public abstract void duP();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.f
 * JD-Core Version:    0.7.0.1
 */
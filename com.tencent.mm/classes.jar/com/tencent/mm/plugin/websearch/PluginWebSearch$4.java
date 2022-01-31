package com.tencent.mm.plugin.websearch;

import com.tencent.mm.h.a.be;
import com.tencent.mm.sdk.b.c;

final class PluginWebSearch$4
  extends c<be>
{
  PluginWebSearch$4(PluginWebSearch paramPluginWebSearch)
  {
    this.udX = be.class.getName().hashCode();
  }
  
  /* Error */
  private boolean a(be parambe)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +361 -> 362
    //   4: aload_1
    //   5: getfield 43	com/tencent/mm/h/a/be:bHu	Lcom/tencent/mm/h/a/be$a;
    //   8: getfield 48	com/tencent/mm/h/a/be$a:bHv	I
    //   11: bipush 27
    //   13: if_icmpne +349 -> 362
    //   16: aload_1
    //   17: getfield 43	com/tencent/mm/h/a/be:bHu	Lcom/tencent/mm/h/a/be$a;
    //   20: getfield 51	com/tencent/mm/h/a/be$a:brC	I
    //   23: iconst_2
    //   24: if_icmpne +21 -> 45
    //   27: invokestatic 55	com/tencent/mm/plugin/websearch/PluginWebSearch:checkTopStoryTemplateFolderValid	()Z
    //   30: ifne +15 -> 45
    //   33: aload_1
    //   34: getfield 43	com/tencent/mm/h/a/be:bHu	Lcom/tencent/mm/h/a/be$a;
    //   37: getfield 51	com/tencent/mm/h/a/be$a:brC	I
    //   40: bipush 12
    //   42: invokestatic 59	com/tencent/mm/plugin/websearch/PluginWebSearch:access$100	(II)V
    //   45: aload_1
    //   46: getfield 43	com/tencent/mm/h/a/be:bHu	Lcom/tencent/mm/h/a/be$a;
    //   49: getfield 51	com/tencent/mm/h/a/be$a:brC	I
    //   52: invokestatic 65	com/tencent/mm/plugin/websearch/api/aa:Bx	(I)Ljava/lang/String;
    //   55: astore 6
    //   57: aload_1
    //   58: getfield 43	com/tencent/mm/h/a/be:bHu	Lcom/tencent/mm/h/a/be$a;
    //   61: getfield 51	com/tencent/mm/h/a/be$a:brC	I
    //   64: invokestatic 68	com/tencent/mm/plugin/websearch/api/aa:By	(I)Ljava/lang/String;
    //   67: astore 5
    //   69: aload_1
    //   70: getfield 43	com/tencent/mm/h/a/be:bHu	Lcom/tencent/mm/h/a/be$a;
    //   73: getfield 51	com/tencent/mm/h/a/be$a:brC	I
    //   76: invokestatic 72	com/tencent/mm/plugin/websearch/api/aa:Bz	(I)I
    //   79: istore_3
    //   80: aload 6
    //   82: invokestatic 78	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   85: ifne +277 -> 362
    //   88: aload 5
    //   90: invokestatic 78	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   93: ifne +269 -> 362
    //   96: new 80	com/tencent/mm/vfs/b
    //   99: dup
    //   100: aload_1
    //   101: getfield 43	com/tencent/mm/h/a/be:bHu	Lcom/tencent/mm/h/a/be$a;
    //   104: getfield 84	com/tencent/mm/h/a/be$a:filePath	Ljava/lang/String;
    //   107: invokespecial 87	com/tencent/mm/vfs/b:<init>	(Ljava/lang/String;)V
    //   110: astore 8
    //   112: aload 8
    //   114: invokevirtual 90	com/tencent/mm/vfs/b:exists	()Z
    //   117: ifeq +363 -> 480
    //   120: ldc 92
    //   122: ldc 94
    //   124: iconst_1
    //   125: anewarray 96	java/lang/Object
    //   128: dup
    //   129: iconst_0
    //   130: aload 8
    //   132: invokevirtual 100	com/tencent/mm/vfs/b:cLs	()Lcom/tencent/mm/vfs/b;
    //   135: aastore
    //   136: invokestatic 106	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   139: new 80	com/tencent/mm/vfs/b
    //   142: dup
    //   143: aload 6
    //   145: ldc 108
    //   147: invokespecial 111	com/tencent/mm/vfs/b:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   150: astore 9
    //   152: new 80	com/tencent/mm/vfs/b
    //   155: dup
    //   156: aload 9
    //   158: aload 5
    //   160: invokespecial 114	com/tencent/mm/vfs/b:<init>	(Lcom/tencent/mm/vfs/b;Ljava/lang/String;)V
    //   163: astore 5
    //   165: aload 9
    //   167: invokevirtual 117	com/tencent/mm/vfs/b:mkdirs	()Z
    //   170: pop
    //   171: aload 8
    //   173: invokevirtual 121	com/tencent/mm/vfs/b:cLr	()Landroid/net/Uri;
    //   176: invokestatic 127	com/tencent/mm/vfs/j:n	(Landroid/net/Uri;)Ljava/lang/String;
    //   179: aload 5
    //   181: invokevirtual 121	com/tencent/mm/vfs/b:cLr	()Landroid/net/Uri;
    //   184: invokestatic 127	com/tencent/mm/vfs/j:n	(Landroid/net/Uri;)Ljava/lang/String;
    //   187: invokestatic 133	com/tencent/mm/vfs/e:r	(Ljava/lang/String;Ljava/lang/String;)J
    //   190: pop2
    //   191: aload 5
    //   193: invokevirtual 121	com/tencent/mm/vfs/b:cLr	()Landroid/net/Uri;
    //   196: invokestatic 127	com/tencent/mm/vfs/j:n	(Landroid/net/Uri;)Ljava/lang/String;
    //   199: aload 9
    //   201: invokevirtual 121	com/tencent/mm/vfs/b:cLr	()Landroid/net/Uri;
    //   204: invokestatic 127	com/tencent/mm/vfs/j:n	(Landroid/net/Uri;)Ljava/lang/String;
    //   207: invokestatic 137	com/tencent/mm/sdk/platformtools/bk:gh	(Ljava/lang/String;Ljava/lang/String;)I
    //   210: istore 4
    //   212: iload 4
    //   214: iflt +284 -> 498
    //   217: new 139	java/util/Properties
    //   220: dup
    //   221: invokespecial 140	java/util/Properties:<init>	()V
    //   224: astore 10
    //   226: new 142	com/tencent/mm/vfs/d
    //   229: dup
    //   230: new 80	com/tencent/mm/vfs/b
    //   233: dup
    //   234: aload 9
    //   236: ldc 144
    //   238: invokespecial 114	com/tencent/mm/vfs/b:<init>	(Lcom/tencent/mm/vfs/b;Ljava/lang/String;)V
    //   241: invokespecial 147	com/tencent/mm/vfs/d:<init>	(Lcom/tencent/mm/vfs/b;)V
    //   244: astore 6
    //   246: aload 6
    //   248: astore 5
    //   250: aload 10
    //   252: aload 6
    //   254: invokevirtual 151	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   257: aload 6
    //   259: invokestatic 155	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   262: aload 10
    //   264: ldc 157
    //   266: ldc 159
    //   268: invokevirtual 163	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   271: invokestatic 169	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   274: invokevirtual 172	java/lang/Integer:intValue	()I
    //   277: istore_2
    //   278: aload 9
    //   280: getfield 176	com/tencent/mm/vfs/b:mUri	Landroid/net/Uri;
    //   283: invokestatic 127	com/tencent/mm/vfs/j:n	(Landroid/net/Uri;)Ljava/lang/String;
    //   286: iconst_1
    //   287: invokestatic 180	com/tencent/mm/vfs/e:K	(Ljava/lang/String;Z)Z
    //   290: pop
    //   291: iload_3
    //   292: iload_2
    //   293: if_icmpge +115 -> 408
    //   296: aload_1
    //   297: getfield 43	com/tencent/mm/h/a/be:bHu	Lcom/tencent/mm/h/a/be$a;
    //   300: getfield 51	com/tencent/mm/h/a/be$a:brC	I
    //   303: bipush 9
    //   305: invokestatic 59	com/tencent/mm/plugin/websearch/PluginWebSearch:access$100	(II)V
    //   308: ldc 92
    //   310: ldc 182
    //   312: iconst_3
    //   313: anewarray 96	java/lang/Object
    //   316: dup
    //   317: iconst_0
    //   318: aload_1
    //   319: getfield 43	com/tencent/mm/h/a/be:bHu	Lcom/tencent/mm/h/a/be$a;
    //   322: getfield 51	com/tencent/mm/h/a/be$a:brC	I
    //   325: invokestatic 185	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   328: aastore
    //   329: dup
    //   330: iconst_1
    //   331: iload_3
    //   332: invokestatic 185	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   335: aastore
    //   336: dup
    //   337: iconst_2
    //   338: iload_2
    //   339: invokestatic 185	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   342: aastore
    //   343: invokestatic 106	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   346: aload_0
    //   347: getfield 13	com/tencent/mm/plugin/websearch/PluginWebSearch$4:qTd	Lcom/tencent/mm/plugin/websearch/PluginWebSearch;
    //   350: aload 8
    //   352: aload_1
    //   353: getfield 43	com/tencent/mm/h/a/be:bHu	Lcom/tencent/mm/h/a/be$a;
    //   356: getfield 51	com/tencent/mm/h/a/be$a:brC	I
    //   359: invokestatic 189	com/tencent/mm/plugin/websearch/PluginWebSearch:access$200	(Lcom/tencent/mm/plugin/websearch/PluginWebSearch;Lcom/tencent/mm/vfs/b;I)V
    //   362: iconst_0
    //   363: ireturn
    //   364: astore 7
    //   366: aconst_null
    //   367: astore 6
    //   369: aload 6
    //   371: astore 5
    //   373: ldc 92
    //   375: aload 7
    //   377: aload 7
    //   379: invokevirtual 192	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   382: iconst_0
    //   383: anewarray 96	java/lang/Object
    //   386: invokestatic 196	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   389: aload 6
    //   391: invokestatic 155	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   394: goto -132 -> 262
    //   397: astore_1
    //   398: aconst_null
    //   399: astore 5
    //   401: aload 5
    //   403: invokestatic 155	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   406: aload_1
    //   407: athrow
    //   408: iload 4
    //   410: iflt +55 -> 465
    //   413: aload_1
    //   414: getfield 43	com/tencent/mm/h/a/be:bHu	Lcom/tencent/mm/h/a/be$a;
    //   417: getfield 51	com/tencent/mm/h/a/be$a:brC	I
    //   420: bipush 13
    //   422: invokestatic 59	com/tencent/mm/plugin/websearch/PluginWebSearch:access$100	(II)V
    //   425: ldc 92
    //   427: ldc 198
    //   429: iconst_3
    //   430: anewarray 96	java/lang/Object
    //   433: dup
    //   434: iconst_0
    //   435: aload_1
    //   436: getfield 43	com/tencent/mm/h/a/be:bHu	Lcom/tencent/mm/h/a/be$a;
    //   439: getfield 51	com/tencent/mm/h/a/be$a:brC	I
    //   442: invokestatic 185	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   445: aastore
    //   446: dup
    //   447: iconst_1
    //   448: iload_3
    //   449: invokestatic 185	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   452: aastore
    //   453: dup
    //   454: iconst_2
    //   455: iload_2
    //   456: invokestatic 185	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   459: aastore
    //   460: invokestatic 106	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   463: iconst_0
    //   464: ireturn
    //   465: aload_1
    //   466: getfield 43	com/tencent/mm/h/a/be:bHu	Lcom/tencent/mm/h/a/be$a;
    //   469: getfield 51	com/tencent/mm/h/a/be$a:brC	I
    //   472: bipush 11
    //   474: invokestatic 59	com/tencent/mm/plugin/websearch/PluginWebSearch:access$100	(II)V
    //   477: goto -52 -> 425
    //   480: ldc 92
    //   482: ldc 200
    //   484: invokestatic 203	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   487: iconst_0
    //   488: ireturn
    //   489: astore_1
    //   490: goto -89 -> 401
    //   493: astore 7
    //   495: goto -126 -> 369
    //   498: iconst_1
    //   499: istore_2
    //   500: goto -222 -> 278
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	503	0	this	4
    //   0	503	1	parambe	be
    //   277	223	2	i	int
    //   79	370	3	j	int
    //   210	199	4	k	int
    //   67	335	5	localObject1	java.lang.Object
    //   55	335	6	localObject2	java.lang.Object
    //   364	14	7	localException1	java.lang.Exception
    //   493	1	7	localException2	java.lang.Exception
    //   110	241	8	localb1	com.tencent.mm.vfs.b
    //   150	129	9	localb2	com.tencent.mm.vfs.b
    //   224	39	10	localProperties	java.util.Properties
    // Exception table:
    //   from	to	target	type
    //   226	246	364	java/lang/Exception
    //   226	246	397	finally
    //   250	257	489	finally
    //   373	389	489	finally
    //   250	257	493	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.PluginWebSearch.4
 * JD-Core Version:    0.7.0.1
 */
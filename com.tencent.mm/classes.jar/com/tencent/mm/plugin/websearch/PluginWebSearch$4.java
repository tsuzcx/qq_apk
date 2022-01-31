package com.tencent.mm.plugin.websearch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bg;
import com.tencent.mm.sdk.b.c;

final class PluginWebSearch$4
  extends c<bg>
{
  PluginWebSearch$4(PluginWebSearch paramPluginWebSearch)
  {
    AppMethodBeat.i(91308);
    this.__eventId = bg.class.getName().hashCode();
    AppMethodBeat.o(91308);
  }
  
  /* Error */
  private boolean a(bg parambg)
  {
    // Byte code:
    //   0: ldc 50
    //   2: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: ifnull +363 -> 369
    //   9: aload_1
    //   10: getfield 54	com/tencent/mm/g/a/bg:coI	Lcom/tencent/mm/g/a/bg$a;
    //   13: getfield 59	com/tencent/mm/g/a/bg$a:coJ	I
    //   16: bipush 27
    //   18: if_icmpne +351 -> 369
    //   21: aload_1
    //   22: getfield 54	com/tencent/mm/g/a/bg:coI	Lcom/tencent/mm/g/a/bg$a;
    //   25: getfield 62	com/tencent/mm/g/a/bg$a:subType	I
    //   28: iconst_2
    //   29: if_icmpne +21 -> 50
    //   32: invokestatic 66	com/tencent/mm/plugin/websearch/PluginWebSearch:checkTopStoryTemplateFolderValid	()Z
    //   35: ifne +15 -> 50
    //   38: aload_1
    //   39: getfield 54	com/tencent/mm/g/a/bg:coI	Lcom/tencent/mm/g/a/bg$a;
    //   42: getfield 62	com/tencent/mm/g/a/bg$a:subType	I
    //   45: bipush 12
    //   47: invokestatic 70	com/tencent/mm/plugin/websearch/PluginWebSearch:access$100	(II)V
    //   50: aload_1
    //   51: getfield 54	com/tencent/mm/g/a/bg:coI	Lcom/tencent/mm/g/a/bg$a;
    //   54: getfield 62	com/tencent/mm/g/a/bg$a:subType	I
    //   57: invokestatic 76	com/tencent/mm/plugin/websearch/api/aa:Jl	(I)Ljava/lang/String;
    //   60: astore 6
    //   62: aload_1
    //   63: getfield 54	com/tencent/mm/g/a/bg:coI	Lcom/tencent/mm/g/a/bg$a;
    //   66: getfield 62	com/tencent/mm/g/a/bg$a:subType	I
    //   69: invokestatic 79	com/tencent/mm/plugin/websearch/api/aa:Jm	(I)Ljava/lang/String;
    //   72: astore 5
    //   74: aload_1
    //   75: getfield 54	com/tencent/mm/g/a/bg:coI	Lcom/tencent/mm/g/a/bg$a;
    //   78: getfield 62	com/tencent/mm/g/a/bg$a:subType	I
    //   81: invokestatic 83	com/tencent/mm/plugin/websearch/api/aa:Jn	(I)I
    //   84: istore_3
    //   85: aload 6
    //   87: invokestatic 89	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   90: ifne +279 -> 369
    //   93: aload 5
    //   95: invokestatic 89	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   98: ifne +271 -> 369
    //   101: new 91	com/tencent/mm/vfs/b
    //   104: dup
    //   105: aload_1
    //   106: getfield 54	com/tencent/mm/g/a/bg:coI	Lcom/tencent/mm/g/a/bg$a;
    //   109: getfield 95	com/tencent/mm/g/a/bg$a:filePath	Ljava/lang/String;
    //   112: invokespecial 98	com/tencent/mm/vfs/b:<init>	(Ljava/lang/String;)V
    //   115: astore 8
    //   117: aload 8
    //   119: invokevirtual 101	com/tencent/mm/vfs/b:exists	()Z
    //   122: ifeq +376 -> 498
    //   125: ldc 103
    //   127: ldc 105
    //   129: iconst_1
    //   130: anewarray 107	java/lang/Object
    //   133: dup
    //   134: iconst_0
    //   135: aload 8
    //   137: invokevirtual 111	com/tencent/mm/vfs/b:dQK	()Lcom/tencent/mm/vfs/b;
    //   140: aastore
    //   141: invokestatic 116	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   144: new 91	com/tencent/mm/vfs/b
    //   147: dup
    //   148: aload 6
    //   150: ldc 118
    //   152: invokespecial 121	com/tencent/mm/vfs/b:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   155: astore 9
    //   157: new 91	com/tencent/mm/vfs/b
    //   160: dup
    //   161: aload 9
    //   163: aload 5
    //   165: invokespecial 124	com/tencent/mm/vfs/b:<init>	(Lcom/tencent/mm/vfs/b;Ljava/lang/String;)V
    //   168: astore 5
    //   170: aload 9
    //   172: invokevirtual 127	com/tencent/mm/vfs/b:mkdirs	()Z
    //   175: pop
    //   176: aload 8
    //   178: invokevirtual 131	com/tencent/mm/vfs/b:dQJ	()Landroid/net/Uri;
    //   181: invokestatic 137	com/tencent/mm/vfs/j:p	(Landroid/net/Uri;)Ljava/lang/String;
    //   184: aload 5
    //   186: invokevirtual 131	com/tencent/mm/vfs/b:dQJ	()Landroid/net/Uri;
    //   189: invokestatic 137	com/tencent/mm/vfs/j:p	(Landroid/net/Uri;)Ljava/lang/String;
    //   192: invokestatic 143	com/tencent/mm/vfs/e:C	(Ljava/lang/String;Ljava/lang/String;)J
    //   195: pop2
    //   196: aload 5
    //   198: invokevirtual 131	com/tencent/mm/vfs/b:dQJ	()Landroid/net/Uri;
    //   201: invokestatic 137	com/tencent/mm/vfs/j:p	(Landroid/net/Uri;)Ljava/lang/String;
    //   204: aload 9
    //   206: invokevirtual 131	com/tencent/mm/vfs/b:dQJ	()Landroid/net/Uri;
    //   209: invokestatic 137	com/tencent/mm/vfs/j:p	(Landroid/net/Uri;)Ljava/lang/String;
    //   212: invokestatic 147	com/tencent/mm/sdk/platformtools/bo:ii	(Ljava/lang/String;Ljava/lang/String;)I
    //   215: istore 4
    //   217: iconst_1
    //   218: istore_2
    //   219: iload 4
    //   221: iflt +64 -> 285
    //   224: new 149	java/util/Properties
    //   227: dup
    //   228: invokespecial 150	java/util/Properties:<init>	()V
    //   231: astore 10
    //   233: new 152	com/tencent/mm/vfs/d
    //   236: dup
    //   237: new 91	com/tencent/mm/vfs/b
    //   240: dup
    //   241: aload 9
    //   243: ldc 154
    //   245: invokespecial 124	com/tencent/mm/vfs/b:<init>	(Lcom/tencent/mm/vfs/b;Ljava/lang/String;)V
    //   248: invokespecial 157	com/tencent/mm/vfs/d:<init>	(Lcom/tencent/mm/vfs/b;)V
    //   251: astore 6
    //   253: aload 6
    //   255: astore 5
    //   257: aload 10
    //   259: aload 6
    //   261: invokevirtual 161	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   264: aload 6
    //   266: invokestatic 165	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   269: aload 10
    //   271: ldc 167
    //   273: ldc 169
    //   275: invokevirtual 173	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   278: invokestatic 179	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   281: invokevirtual 182	java/lang/Integer:intValue	()I
    //   284: istore_2
    //   285: aload 9
    //   287: getfield 186	com/tencent/mm/vfs/b:mUri	Landroid/net/Uri;
    //   290: invokestatic 137	com/tencent/mm/vfs/j:p	(Landroid/net/Uri;)Ljava/lang/String;
    //   293: iconst_1
    //   294: invokestatic 190	com/tencent/mm/vfs/e:O	(Ljava/lang/String;Z)Z
    //   297: pop
    //   298: iload_3
    //   299: iload_2
    //   300: if_icmpge +125 -> 425
    //   303: aload_1
    //   304: getfield 54	com/tencent/mm/g/a/bg:coI	Lcom/tencent/mm/g/a/bg$a;
    //   307: getfield 62	com/tencent/mm/g/a/bg$a:subType	I
    //   310: bipush 9
    //   312: invokestatic 70	com/tencent/mm/plugin/websearch/PluginWebSearch:access$100	(II)V
    //   315: ldc 103
    //   317: ldc 192
    //   319: iconst_3
    //   320: anewarray 107	java/lang/Object
    //   323: dup
    //   324: iconst_0
    //   325: aload_1
    //   326: getfield 54	com/tencent/mm/g/a/bg:coI	Lcom/tencent/mm/g/a/bg$a;
    //   329: getfield 62	com/tencent/mm/g/a/bg$a:subType	I
    //   332: invokestatic 195	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   335: aastore
    //   336: dup
    //   337: iconst_1
    //   338: iload_3
    //   339: invokestatic 195	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   342: aastore
    //   343: dup
    //   344: iconst_2
    //   345: iload_2
    //   346: invokestatic 195	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   349: aastore
    //   350: invokestatic 116	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   353: aload_0
    //   354: getfield 13	com/tencent/mm/plugin/websearch/PluginWebSearch$4:uIk	Lcom/tencent/mm/plugin/websearch/PluginWebSearch;
    //   357: aload 8
    //   359: aload_1
    //   360: getfield 54	com/tencent/mm/g/a/bg:coI	Lcom/tencent/mm/g/a/bg$a;
    //   363: getfield 62	com/tencent/mm/g/a/bg$a:subType	I
    //   366: invokestatic 199	com/tencent/mm/plugin/websearch/PluginWebSearch:access$200	(Lcom/tencent/mm/plugin/websearch/PluginWebSearch;Lcom/tencent/mm/vfs/b;I)V
    //   369: ldc 50
    //   371: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   374: iconst_0
    //   375: ireturn
    //   376: astore 7
    //   378: aconst_null
    //   379: astore 6
    //   381: aload 6
    //   383: astore 5
    //   385: ldc 103
    //   387: aload 7
    //   389: aload 7
    //   391: invokevirtual 202	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   394: iconst_0
    //   395: anewarray 107	java/lang/Object
    //   398: invokestatic 206	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   401: aload 6
    //   403: invokestatic 165	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   406: goto -137 -> 269
    //   409: astore_1
    //   410: aconst_null
    //   411: astore 5
    //   413: aload 5
    //   415: invokestatic 165	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   418: ldc 50
    //   420: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   423: aload_1
    //   424: athrow
    //   425: iload 4
    //   427: iflt +56 -> 483
    //   430: aload_1
    //   431: getfield 54	com/tencent/mm/g/a/bg:coI	Lcom/tencent/mm/g/a/bg$a;
    //   434: getfield 62	com/tencent/mm/g/a/bg$a:subType	I
    //   437: bipush 13
    //   439: invokestatic 70	com/tencent/mm/plugin/websearch/PluginWebSearch:access$100	(II)V
    //   442: ldc 103
    //   444: ldc 208
    //   446: iconst_3
    //   447: anewarray 107	java/lang/Object
    //   450: dup
    //   451: iconst_0
    //   452: aload_1
    //   453: getfield 54	com/tencent/mm/g/a/bg:coI	Lcom/tencent/mm/g/a/bg$a;
    //   456: getfield 62	com/tencent/mm/g/a/bg$a:subType	I
    //   459: invokestatic 195	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   462: aastore
    //   463: dup
    //   464: iconst_1
    //   465: iload_3
    //   466: invokestatic 195	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   469: aastore
    //   470: dup
    //   471: iconst_2
    //   472: iload_2
    //   473: invokestatic 195	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   476: aastore
    //   477: invokestatic 116	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   480: goto -111 -> 369
    //   483: aload_1
    //   484: getfield 54	com/tencent/mm/g/a/bg:coI	Lcom/tencent/mm/g/a/bg$a;
    //   487: getfield 62	com/tencent/mm/g/a/bg$a:subType	I
    //   490: bipush 11
    //   492: invokestatic 70	com/tencent/mm/plugin/websearch/PluginWebSearch:access$100	(II)V
    //   495: goto -53 -> 442
    //   498: ldc 103
    //   500: ldc 210
    //   502: invokestatic 213	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   505: goto -136 -> 369
    //   508: astore_1
    //   509: goto -96 -> 413
    //   512: astore 7
    //   514: goto -133 -> 381
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	517	0	this	4
    //   0	517	1	parambg	bg
    //   218	255	2	i	int
    //   84	382	3	j	int
    //   215	211	4	k	int
    //   72	342	5	localObject1	java.lang.Object
    //   60	342	6	localObject2	java.lang.Object
    //   376	14	7	localException1	java.lang.Exception
    //   512	1	7	localException2	java.lang.Exception
    //   115	243	8	localb1	com.tencent.mm.vfs.b
    //   155	131	9	localb2	com.tencent.mm.vfs.b
    //   231	39	10	localProperties	java.util.Properties
    // Exception table:
    //   from	to	target	type
    //   233	253	376	java/lang/Exception
    //   233	253	409	finally
    //   257	264	508	finally
    //   385	401	508	finally
    //   257	264	512	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.PluginWebSearch.4
 * JD-Core Version:    0.7.0.1
 */
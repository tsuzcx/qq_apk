package com.tencent.mm.plugin.websearch;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.jl;
import com.tencent.mm.sdk.b.c;

final class PluginWebSearch$5
  extends c<jl>
{
  PluginWebSearch$5(PluginWebSearch paramPluginWebSearch)
  {
    AppMethodBeat.i(91311);
    this.__eventId = jl.class.getName().hashCode();
    AppMethodBeat.o(91311);
  }
  
  /* Error */
  private boolean a(jl paramjl)
  {
    // Byte code:
    //   0: ldc 50
    //   2: invokestatic 23	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: ifnull +273 -> 279
    //   9: aload_1
    //   10: getfield 54	com/tencent/mm/g/a/jl:cyY	Lcom/tencent/mm/g/a/jl$a;
    //   13: getfield 59	com/tencent/mm/g/a/jl$a:coJ	I
    //   16: bipush 27
    //   18: if_icmpne +261 -> 279
    //   21: aload_1
    //   22: getfield 54	com/tencent/mm/g/a/jl:cyY	Lcom/tencent/mm/g/a/jl$a;
    //   25: getfield 62	com/tencent/mm/g/a/jl$a:subType	I
    //   28: iconst_1
    //   29: if_icmpne +313 -> 342
    //   32: new 64	com/tencent/mm/vfs/b
    //   35: dup
    //   36: aload_1
    //   37: getfield 54	com/tencent/mm/g/a/jl:cyY	Lcom/tencent/mm/g/a/jl$a;
    //   40: getfield 68	com/tencent/mm/g/a/jl$a:filePath	Ljava/lang/String;
    //   43: invokespecial 71	com/tencent/mm/vfs/b:<init>	(Ljava/lang/String;)V
    //   46: astore 6
    //   48: aload 6
    //   50: invokevirtual 75	com/tencent/mm/vfs/b:exists	()Z
    //   53: ifeq +279 -> 332
    //   56: ldc 77
    //   58: ldc 79
    //   60: iconst_1
    //   61: anewarray 81	java/lang/Object
    //   64: dup
    //   65: iconst_0
    //   66: aload 6
    //   68: invokevirtual 85	com/tencent/mm/vfs/b:dQK	()Lcom/tencent/mm/vfs/b;
    //   71: aastore
    //   72: invokestatic 90	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   75: new 64	com/tencent/mm/vfs/b
    //   78: dup
    //   79: aload_1
    //   80: getfield 54	com/tencent/mm/g/a/jl:cyY	Lcom/tencent/mm/g/a/jl$a;
    //   83: getfield 62	com/tencent/mm/g/a/jl$a:subType	I
    //   86: invokestatic 96	com/tencent/mm/plugin/websearch/api/aa:Jl	(I)Ljava/lang/String;
    //   89: ldc 98
    //   91: invokespecial 101	com/tencent/mm/vfs/b:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   94: astore 7
    //   96: new 64	com/tencent/mm/vfs/b
    //   99: dup
    //   100: aload 7
    //   102: aload_1
    //   103: getfield 54	com/tencent/mm/g/a/jl:cyY	Lcom/tencent/mm/g/a/jl$a;
    //   106: getfield 62	com/tencent/mm/g/a/jl$a:subType	I
    //   109: invokestatic 104	com/tencent/mm/plugin/websearch/api/aa:Jm	(I)Ljava/lang/String;
    //   112: invokespecial 107	com/tencent/mm/vfs/b:<init>	(Lcom/tencent/mm/vfs/b;Ljava/lang/String;)V
    //   115: astore_3
    //   116: aload 7
    //   118: invokevirtual 110	com/tencent/mm/vfs/b:mkdirs	()Z
    //   121: pop
    //   122: aload 6
    //   124: invokevirtual 114	com/tencent/mm/vfs/b:dQJ	()Landroid/net/Uri;
    //   127: invokestatic 120	com/tencent/mm/vfs/j:p	(Landroid/net/Uri;)Ljava/lang/String;
    //   130: aload_3
    //   131: invokevirtual 114	com/tencent/mm/vfs/b:dQJ	()Landroid/net/Uri;
    //   134: invokestatic 120	com/tencent/mm/vfs/j:p	(Landroid/net/Uri;)Ljava/lang/String;
    //   137: invokestatic 126	com/tencent/mm/vfs/e:C	(Ljava/lang/String;Ljava/lang/String;)J
    //   140: pop2
    //   141: aload_3
    //   142: invokevirtual 114	com/tencent/mm/vfs/b:dQJ	()Landroid/net/Uri;
    //   145: invokestatic 120	com/tencent/mm/vfs/j:p	(Landroid/net/Uri;)Ljava/lang/String;
    //   148: aload 7
    //   150: invokevirtual 114	com/tencent/mm/vfs/b:dQJ	()Landroid/net/Uri;
    //   153: invokestatic 120	com/tencent/mm/vfs/j:p	(Landroid/net/Uri;)Ljava/lang/String;
    //   156: invokestatic 132	com/tencent/mm/sdk/platformtools/bo:ii	(Ljava/lang/String;Ljava/lang/String;)I
    //   159: iflt +286 -> 445
    //   162: new 134	java/util/Properties
    //   165: dup
    //   166: invokespecial 135	java/util/Properties:<init>	()V
    //   169: astore 8
    //   171: new 137	com/tencent/mm/vfs/d
    //   174: dup
    //   175: new 64	com/tencent/mm/vfs/b
    //   178: dup
    //   179: aload 7
    //   181: ldc 139
    //   183: invokespecial 107	com/tencent/mm/vfs/b:<init>	(Lcom/tencent/mm/vfs/b;Ljava/lang/String;)V
    //   186: invokespecial 142	com/tencent/mm/vfs/d:<init>	(Lcom/tencent/mm/vfs/b;)V
    //   189: astore 4
    //   191: aload 4
    //   193: astore_3
    //   194: aload 8
    //   196: aload 4
    //   198: invokevirtual 146	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   201: aload 4
    //   203: invokestatic 150	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   206: aload 8
    //   208: ldc 152
    //   210: ldc 154
    //   212: invokevirtual 158	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   215: invokestatic 164	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   218: invokevirtual 167	java/lang/Integer:intValue	()I
    //   221: istore_2
    //   222: aload 7
    //   224: getfield 171	com/tencent/mm/vfs/b:mUri	Landroid/net/Uri;
    //   227: invokestatic 120	com/tencent/mm/vfs/j:p	(Landroid/net/Uri;)Ljava/lang/String;
    //   230: iconst_1
    //   231: invokestatic 175	com/tencent/mm/vfs/e:O	(Ljava/lang/String;Z)Z
    //   234: pop
    //   235: ldc 77
    //   237: ldc 177
    //   239: iconst_2
    //   240: anewarray 81	java/lang/Object
    //   243: dup
    //   244: iconst_0
    //   245: iconst_0
    //   246: invokestatic 181	com/tencent/mm/plugin/websearch/api/aa:Jf	(I)I
    //   249: invokestatic 184	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   252: aastore
    //   253: dup
    //   254: iconst_1
    //   255: iload_2
    //   256: invokestatic 184	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   259: aastore
    //   260: invokestatic 90	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   263: aload_0
    //   264: getfield 13	com/tencent/mm/plugin/websearch/PluginWebSearch$5:uIk	Lcom/tencent/mm/plugin/websearch/PluginWebSearch;
    //   267: aload 6
    //   269: aload_1
    //   270: getfield 54	com/tencent/mm/g/a/jl:cyY	Lcom/tencent/mm/g/a/jl$a;
    //   273: getfield 62	com/tencent/mm/g/a/jl$a:subType	I
    //   276: invokestatic 188	com/tencent/mm/plugin/websearch/PluginWebSearch:access$200	(Lcom/tencent/mm/plugin/websearch/PluginWebSearch;Lcom/tencent/mm/vfs/b;I)V
    //   279: ldc 50
    //   281: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   284: iconst_0
    //   285: ireturn
    //   286: astore 5
    //   288: aconst_null
    //   289: astore 4
    //   291: aload 4
    //   293: astore_3
    //   294: ldc 77
    //   296: aload 5
    //   298: aload 5
    //   300: invokevirtual 191	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   303: iconst_0
    //   304: anewarray 81	java/lang/Object
    //   307: invokestatic 195	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   310: aload 4
    //   312: invokestatic 150	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   315: goto -109 -> 206
    //   318: astore_1
    //   319: aconst_null
    //   320: astore_3
    //   321: aload_3
    //   322: invokestatic 150	com/tencent/mm/sdk/platformtools/bo:b	(Ljava/io/Closeable;)V
    //   325: ldc 50
    //   327: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   330: aload_1
    //   331: athrow
    //   332: ldc 77
    //   334: ldc 197
    //   336: invokestatic 200	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   339: goto -60 -> 279
    //   342: aload_1
    //   343: getfield 54	com/tencent/mm/g/a/jl:cyY	Lcom/tencent/mm/g/a/jl$a;
    //   346: getfield 62	com/tencent/mm/g/a/jl$a:subType	I
    //   349: iconst_2
    //   350: if_icmpne -71 -> 279
    //   353: new 64	com/tencent/mm/vfs/b
    //   356: dup
    //   357: aload_1
    //   358: getfield 54	com/tencent/mm/g/a/jl:cyY	Lcom/tencent/mm/g/a/jl$a;
    //   361: getfield 68	com/tencent/mm/g/a/jl$a:filePath	Ljava/lang/String;
    //   364: invokespecial 71	com/tencent/mm/vfs/b:<init>	(Ljava/lang/String;)V
    //   367: astore_3
    //   368: aload_3
    //   369: invokevirtual 75	com/tencent/mm/vfs/b:exists	()Z
    //   372: ifeq +54 -> 426
    //   375: iconst_1
    //   376: invokestatic 181	com/tencent/mm/plugin/websearch/api/aa:Jf	(I)I
    //   379: istore_2
    //   380: aload_0
    //   381: getfield 13	com/tencent/mm/plugin/websearch/PluginWebSearch$5:uIk	Lcom/tencent/mm/plugin/websearch/PluginWebSearch;
    //   384: aload_3
    //   385: aload_1
    //   386: getfield 54	com/tencent/mm/g/a/jl:cyY	Lcom/tencent/mm/g/a/jl$a;
    //   389: getfield 62	com/tencent/mm/g/a/jl$a:subType	I
    //   392: invokestatic 188	com/tencent/mm/plugin/websearch/PluginWebSearch:access$200	(Lcom/tencent/mm/plugin/websearch/PluginWebSearch;Lcom/tencent/mm/vfs/b;I)V
    //   395: ldc 77
    //   397: ldc 177
    //   399: iconst_2
    //   400: anewarray 81	java/lang/Object
    //   403: dup
    //   404: iconst_0
    //   405: iload_2
    //   406: invokestatic 184	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   409: aastore
    //   410: dup
    //   411: iconst_1
    //   412: iconst_1
    //   413: invokestatic 181	com/tencent/mm/plugin/websearch/api/aa:Jf	(I)I
    //   416: invokestatic 184	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   419: aastore
    //   420: invokestatic 90	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   423: goto -144 -> 279
    //   426: ldc 77
    //   428: ldc 197
    //   430: invokestatic 200	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   433: goto -154 -> 279
    //   436: astore_1
    //   437: goto -116 -> 321
    //   440: astore 5
    //   442: goto -151 -> 291
    //   445: iconst_1
    //   446: istore_2
    //   447: goto -225 -> 222
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	450	0	this	5
    //   0	450	1	paramjl	jl
    //   221	226	2	i	int
    //   115	270	3	localObject	java.lang.Object
    //   189	122	4	locald	com.tencent.mm.vfs.d
    //   286	13	5	localException1	java.lang.Exception
    //   440	1	5	localException2	java.lang.Exception
    //   46	222	6	localb1	com.tencent.mm.vfs.b
    //   94	129	7	localb2	com.tencent.mm.vfs.b
    //   169	38	8	localProperties	java.util.Properties
    // Exception table:
    //   from	to	target	type
    //   171	191	286	java/lang/Exception
    //   171	191	318	finally
    //   194	201	436	finally
    //   294	310	436	finally
    //   194	201	440	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.PluginWebSearch.5
 * JD-Core Version:    0.7.0.1
 */
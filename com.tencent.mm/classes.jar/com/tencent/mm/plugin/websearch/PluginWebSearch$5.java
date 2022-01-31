package com.tencent.mm.plugin.websearch;

import com.tencent.mm.h.a.jc;
import com.tencent.mm.sdk.b.c;

final class PluginWebSearch$5
  extends c<jc>
{
  PluginWebSearch$5(PluginWebSearch paramPluginWebSearch)
  {
    this.udX = jc.class.getName().hashCode();
  }
  
  /* Error */
  private boolean a(jc paramjc)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +273 -> 274
    //   4: aload_1
    //   5: getfield 43	com/tencent/mm/h/a/jc:bRw	Lcom/tencent/mm/h/a/jc$a;
    //   8: getfield 48	com/tencent/mm/h/a/jc$a:bHv	I
    //   11: bipush 27
    //   13: if_icmpne +261 -> 274
    //   16: aload_1
    //   17: getfield 43	com/tencent/mm/h/a/jc:bRw	Lcom/tencent/mm/h/a/jc$a;
    //   20: getfield 51	com/tencent/mm/h/a/jc$a:brC	I
    //   23: iconst_1
    //   24: if_icmpne +302 -> 326
    //   27: new 53	com/tencent/mm/vfs/b
    //   30: dup
    //   31: aload_1
    //   32: getfield 43	com/tencent/mm/h/a/jc:bRw	Lcom/tencent/mm/h/a/jc$a;
    //   35: getfield 57	com/tencent/mm/h/a/jc$a:filePath	Ljava/lang/String;
    //   38: invokespecial 60	com/tencent/mm/vfs/b:<init>	(Ljava/lang/String;)V
    //   41: astore 6
    //   43: aload 6
    //   45: invokevirtual 64	com/tencent/mm/vfs/b:exists	()Z
    //   48: ifeq +269 -> 317
    //   51: ldc 66
    //   53: ldc 68
    //   55: iconst_1
    //   56: anewarray 70	java/lang/Object
    //   59: dup
    //   60: iconst_0
    //   61: aload 6
    //   63: invokevirtual 74	com/tencent/mm/vfs/b:cLs	()Lcom/tencent/mm/vfs/b;
    //   66: aastore
    //   67: invokestatic 80	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   70: new 53	com/tencent/mm/vfs/b
    //   73: dup
    //   74: aload_1
    //   75: getfield 43	com/tencent/mm/h/a/jc:bRw	Lcom/tencent/mm/h/a/jc$a;
    //   78: getfield 51	com/tencent/mm/h/a/jc$a:brC	I
    //   81: invokestatic 86	com/tencent/mm/plugin/websearch/api/aa:Bx	(I)Ljava/lang/String;
    //   84: ldc 88
    //   86: invokespecial 91	com/tencent/mm/vfs/b:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   89: astore 7
    //   91: new 53	com/tencent/mm/vfs/b
    //   94: dup
    //   95: aload 7
    //   97: aload_1
    //   98: getfield 43	com/tencent/mm/h/a/jc:bRw	Lcom/tencent/mm/h/a/jc$a;
    //   101: getfield 51	com/tencent/mm/h/a/jc$a:brC	I
    //   104: invokestatic 94	com/tencent/mm/plugin/websearch/api/aa:By	(I)Ljava/lang/String;
    //   107: invokespecial 97	com/tencent/mm/vfs/b:<init>	(Lcom/tencent/mm/vfs/b;Ljava/lang/String;)V
    //   110: astore_3
    //   111: aload 7
    //   113: invokevirtual 100	com/tencent/mm/vfs/b:mkdirs	()Z
    //   116: pop
    //   117: aload 6
    //   119: invokevirtual 104	com/tencent/mm/vfs/b:cLr	()Landroid/net/Uri;
    //   122: invokestatic 110	com/tencent/mm/vfs/j:n	(Landroid/net/Uri;)Ljava/lang/String;
    //   125: aload_3
    //   126: invokevirtual 104	com/tencent/mm/vfs/b:cLr	()Landroid/net/Uri;
    //   129: invokestatic 110	com/tencent/mm/vfs/j:n	(Landroid/net/Uri;)Ljava/lang/String;
    //   132: invokestatic 116	com/tencent/mm/vfs/e:r	(Ljava/lang/String;Ljava/lang/String;)J
    //   135: pop2
    //   136: aload_3
    //   137: invokevirtual 104	com/tencent/mm/vfs/b:cLr	()Landroid/net/Uri;
    //   140: invokestatic 110	com/tencent/mm/vfs/j:n	(Landroid/net/Uri;)Ljava/lang/String;
    //   143: aload 7
    //   145: invokevirtual 104	com/tencent/mm/vfs/b:cLr	()Landroid/net/Uri;
    //   148: invokestatic 110	com/tencent/mm/vfs/j:n	(Landroid/net/Uri;)Ljava/lang/String;
    //   151: invokestatic 122	com/tencent/mm/sdk/platformtools/bk:gh	(Ljava/lang/String;Ljava/lang/String;)I
    //   154: iflt +273 -> 427
    //   157: new 124	java/util/Properties
    //   160: dup
    //   161: invokespecial 125	java/util/Properties:<init>	()V
    //   164: astore 8
    //   166: new 127	com/tencent/mm/vfs/d
    //   169: dup
    //   170: new 53	com/tencent/mm/vfs/b
    //   173: dup
    //   174: aload 7
    //   176: ldc 129
    //   178: invokespecial 97	com/tencent/mm/vfs/b:<init>	(Lcom/tencent/mm/vfs/b;Ljava/lang/String;)V
    //   181: invokespecial 132	com/tencent/mm/vfs/d:<init>	(Lcom/tencent/mm/vfs/b;)V
    //   184: astore 4
    //   186: aload 4
    //   188: astore_3
    //   189: aload 8
    //   191: aload 4
    //   193: invokevirtual 136	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   196: aload 4
    //   198: invokestatic 140	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   201: aload 8
    //   203: ldc 142
    //   205: ldc 144
    //   207: invokevirtual 148	java/util/Properties:getProperty	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   210: invokestatic 154	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   213: invokevirtual 157	java/lang/Integer:intValue	()I
    //   216: istore_2
    //   217: aload 7
    //   219: getfield 161	com/tencent/mm/vfs/b:mUri	Landroid/net/Uri;
    //   222: invokestatic 110	com/tencent/mm/vfs/j:n	(Landroid/net/Uri;)Ljava/lang/String;
    //   225: iconst_1
    //   226: invokestatic 165	com/tencent/mm/vfs/e:K	(Ljava/lang/String;Z)Z
    //   229: pop
    //   230: ldc 66
    //   232: ldc 167
    //   234: iconst_2
    //   235: anewarray 70	java/lang/Object
    //   238: dup
    //   239: iconst_0
    //   240: iconst_0
    //   241: invokestatic 171	com/tencent/mm/plugin/websearch/api/aa:Bs	(I)I
    //   244: invokestatic 174	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   247: aastore
    //   248: dup
    //   249: iconst_1
    //   250: iload_2
    //   251: invokestatic 174	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   254: aastore
    //   255: invokestatic 80	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   258: aload_0
    //   259: getfield 13	com/tencent/mm/plugin/websearch/PluginWebSearch$5:qTd	Lcom/tencent/mm/plugin/websearch/PluginWebSearch;
    //   262: aload 6
    //   264: aload_1
    //   265: getfield 43	com/tencent/mm/h/a/jc:bRw	Lcom/tencent/mm/h/a/jc$a;
    //   268: getfield 51	com/tencent/mm/h/a/jc$a:brC	I
    //   271: invokestatic 178	com/tencent/mm/plugin/websearch/PluginWebSearch:access$200	(Lcom/tencent/mm/plugin/websearch/PluginWebSearch;Lcom/tencent/mm/vfs/b;I)V
    //   274: iconst_0
    //   275: ireturn
    //   276: astore 5
    //   278: aconst_null
    //   279: astore 4
    //   281: aload 4
    //   283: astore_3
    //   284: ldc 66
    //   286: aload 5
    //   288: aload 5
    //   290: invokevirtual 181	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   293: iconst_0
    //   294: anewarray 70	java/lang/Object
    //   297: invokestatic 185	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   300: aload 4
    //   302: invokestatic 140	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   305: goto -104 -> 201
    //   308: astore_1
    //   309: aconst_null
    //   310: astore_3
    //   311: aload_3
    //   312: invokestatic 140	com/tencent/mm/sdk/platformtools/bk:b	(Ljava/io/Closeable;)V
    //   315: aload_1
    //   316: athrow
    //   317: ldc 66
    //   319: ldc 187
    //   321: invokestatic 190	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   324: iconst_0
    //   325: ireturn
    //   326: aload_1
    //   327: getfield 43	com/tencent/mm/h/a/jc:bRw	Lcom/tencent/mm/h/a/jc$a;
    //   330: getfield 51	com/tencent/mm/h/a/jc$a:brC	I
    //   333: iconst_2
    //   334: if_icmpne -60 -> 274
    //   337: new 53	com/tencent/mm/vfs/b
    //   340: dup
    //   341: aload_1
    //   342: getfield 43	com/tencent/mm/h/a/jc:bRw	Lcom/tencent/mm/h/a/jc$a;
    //   345: getfield 57	com/tencent/mm/h/a/jc$a:filePath	Ljava/lang/String;
    //   348: invokespecial 60	com/tencent/mm/vfs/b:<init>	(Ljava/lang/String;)V
    //   351: astore_3
    //   352: aload_3
    //   353: invokevirtual 64	com/tencent/mm/vfs/b:exists	()Z
    //   356: ifeq +53 -> 409
    //   359: iconst_1
    //   360: invokestatic 171	com/tencent/mm/plugin/websearch/api/aa:Bs	(I)I
    //   363: istore_2
    //   364: aload_0
    //   365: getfield 13	com/tencent/mm/plugin/websearch/PluginWebSearch$5:qTd	Lcom/tencent/mm/plugin/websearch/PluginWebSearch;
    //   368: aload_3
    //   369: aload_1
    //   370: getfield 43	com/tencent/mm/h/a/jc:bRw	Lcom/tencent/mm/h/a/jc$a;
    //   373: getfield 51	com/tencent/mm/h/a/jc$a:brC	I
    //   376: invokestatic 178	com/tencent/mm/plugin/websearch/PluginWebSearch:access$200	(Lcom/tencent/mm/plugin/websearch/PluginWebSearch;Lcom/tencent/mm/vfs/b;I)V
    //   379: ldc 66
    //   381: ldc 167
    //   383: iconst_2
    //   384: anewarray 70	java/lang/Object
    //   387: dup
    //   388: iconst_0
    //   389: iload_2
    //   390: invokestatic 174	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   393: aastore
    //   394: dup
    //   395: iconst_1
    //   396: iconst_1
    //   397: invokestatic 171	com/tencent/mm/plugin/websearch/api/aa:Bs	(I)I
    //   400: invokestatic 174	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   403: aastore
    //   404: invokestatic 80	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   407: iconst_0
    //   408: ireturn
    //   409: ldc 66
    //   411: ldc 187
    //   413: invokestatic 190	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   416: iconst_0
    //   417: ireturn
    //   418: astore_1
    //   419: goto -108 -> 311
    //   422: astore 5
    //   424: goto -143 -> 281
    //   427: iconst_1
    //   428: istore_2
    //   429: goto -212 -> 217
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	432	0	this	5
    //   0	432	1	paramjc	jc
    //   216	213	2	i	int
    //   110	259	3	localObject	java.lang.Object
    //   184	117	4	locald	com.tencent.mm.vfs.d
    //   276	13	5	localException1	java.lang.Exception
    //   422	1	5	localException2	java.lang.Exception
    //   41	222	6	localb1	com.tencent.mm.vfs.b
    //   89	129	7	localb2	com.tencent.mm.vfs.b
    //   164	38	8	localProperties	java.util.Properties
    // Exception table:
    //   from	to	target	type
    //   166	186	276	java/lang/Exception
    //   166	186	308	finally
    //   189	196	418	finally
    //   284	300	418	finally
    //   189	196	422	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.PluginWebSearch.5
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.sns.model.a;

import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.vfs.e;

public final class h
  extends b
{
  public h(c.a parama, a parama1)
  {
    super(parama, parama1);
  }
  
  /* Error */
  public final boolean A(java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: ldc 17
    //   2: ldc 19
    //   4: iconst_1
    //   5: anewarray 21	java/lang/Object
    //   8: dup
    //   9: iconst_0
    //   10: new 23	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   17: aload_0
    //   18: getfield 30	com/tencent/mm/plugin/sns/model/a/h:ouO	Lcom/tencent/mm/plugin/sns/model/a/a;
    //   21: invokevirtual 36	com/tencent/mm/plugin/sns/model/a/a:getPath	()Ljava/lang/String;
    //   24: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: aload_0
    //   28: getfield 30	com/tencent/mm/plugin/sns/model/a/h:ouO	Lcom/tencent/mm/plugin/sns/model/a/a;
    //   31: invokevirtual 43	com/tencent/mm/plugin/sns/model/a/a:bEq	()Ljava/lang/String;
    //   34: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   40: aastore
    //   41: invokestatic 52	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   44: sipush 1024
    //   47: newarray byte
    //   49: astore 8
    //   51: new 23	java/lang/StringBuilder
    //   54: dup
    //   55: invokespecial 26	java/lang/StringBuilder:<init>	()V
    //   58: aload_0
    //   59: getfield 30	com/tencent/mm/plugin/sns/model/a/h:ouO	Lcom/tencent/mm/plugin/sns/model/a/a;
    //   62: invokevirtual 36	com/tencent/mm/plugin/sns/model/a/a:getPath	()Ljava/lang/String;
    //   65: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: aload_0
    //   69: getfield 30	com/tencent/mm/plugin/sns/model/a/h:ouO	Lcom/tencent/mm/plugin/sns/model/a/a;
    //   72: invokevirtual 43	com/tencent/mm/plugin/sns/model/a/a:bEq	()Ljava/lang/String;
    //   75: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: iconst_0
    //   82: invokestatic 58	com/tencent/mm/vfs/e:I	(Ljava/lang/String;Z)Ljava/io/OutputStream;
    //   85: astore 7
    //   87: aload 7
    //   89: astore 6
    //   91: invokestatic 64	java/lang/System:currentTimeMillis	()J
    //   94: lstore 4
    //   96: aload 7
    //   98: astore 6
    //   100: aload_0
    //   101: getfield 68	com/tencent/mm/plugin/sns/model/a/h:ouZ	Lcom/tencent/mm/pointers/PString;
    //   104: ldc 70
    //   106: putfield 76	com/tencent/mm/pointers/PString:value	Ljava/lang/String;
    //   109: iconst_0
    //   110: istore_2
    //   111: aload 7
    //   113: astore 6
    //   115: aload_1
    //   116: aload 8
    //   118: invokevirtual 82	java/io/InputStream:read	([B)I
    //   121: istore_3
    //   122: iload_3
    //   123: iconst_m1
    //   124: if_icmpeq +181 -> 305
    //   127: aload 7
    //   129: astore 6
    //   131: iload_3
    //   132: aload_0
    //   133: getfield 85	com/tencent/mm/plugin/sns/model/a/h:ova	I
    //   136: if_icmple +23 -> 159
    //   139: aload 7
    //   141: astore 6
    //   143: aload_0
    //   144: iload_3
    //   145: putfield 85	com/tencent/mm/plugin/sns/model/a/h:ova	I
    //   148: aload 7
    //   150: astore 6
    //   152: aload_0
    //   153: invokestatic 90	com/tencent/mm/sdk/platformtools/bk:UX	()J
    //   156: putfield 94	com/tencent/mm/plugin/sns/model/a/h:ovb	J
    //   159: aload 7
    //   161: astore 6
    //   163: aload_0
    //   164: getfield 97	com/tencent/mm/plugin/sns/model/a/h:ovc	J
    //   167: lconst_0
    //   168: lcmp
    //   169: ifne +18 -> 187
    //   172: aload 7
    //   174: astore 6
    //   176: aload_0
    //   177: aload_0
    //   178: getfield 100	com/tencent/mm/plugin/sns/model/a/h:ovd	J
    //   181: invokestatic 104	com/tencent/mm/sdk/platformtools/bk:co	(J)J
    //   184: putfield 97	com/tencent/mm/plugin/sns/model/a/h:ovc	J
    //   187: aload 7
    //   189: astore 6
    //   191: invokestatic 109	com/tencent/mm/plugin/sns/model/af:FU	()Ljava/lang/String;
    //   194: invokestatic 115	com/tencent/mm/plugin/sns/data/i:Nd	(Ljava/lang/String;)Z
    //   197: ifne +47 -> 244
    //   200: aload 7
    //   202: astore 6
    //   204: aload 7
    //   206: invokevirtual 120	java/io/OutputStream:close	()V
    //   209: aload 7
    //   211: astore 6
    //   213: aload_1
    //   214: invokevirtual 121	java/io/InputStream:close	()V
    //   217: aload 7
    //   219: ifnull +8 -> 227
    //   222: aload 7
    //   224: invokevirtual 120	java/io/OutputStream:close	()V
    //   227: iconst_0
    //   228: ireturn
    //   229: astore_1
    //   230: ldc 17
    //   232: aload_1
    //   233: ldc 70
    //   235: iconst_0
    //   236: anewarray 21	java/lang/Object
    //   239: invokestatic 125	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   242: iconst_0
    //   243: ireturn
    //   244: aload 7
    //   246: astore 6
    //   248: aload 7
    //   250: aload 8
    //   252: iconst_0
    //   253: iload_3
    //   254: invokevirtual 129	java/io/OutputStream:write	([BII)V
    //   257: aload 7
    //   259: astore 6
    //   261: aload_0
    //   262: aload_0
    //   263: getfield 132	com/tencent/mm/plugin/sns/model/a/h:ovi	I
    //   266: iload_3
    //   267: iadd
    //   268: putfield 132	com/tencent/mm/plugin/sns/model/a/h:ovi	I
    //   271: aload 7
    //   273: astore 6
    //   275: aload_0
    //   276: getfield 132	com/tencent/mm/plugin/sns/model/a/h:ovi	I
    //   279: lload 4
    //   281: aload_0
    //   282: getfield 68	com/tencent/mm/plugin/sns/model/a/h:ouZ	Lcom/tencent/mm/pointers/PString;
    //   285: invokestatic 136	com/tencent/mm/plugin/sns/model/a/h:a	(IJLcom/tencent/mm/pointers/PString;)Z
    //   288: ifeq +167 -> 455
    //   291: aload 7
    //   293: astore 6
    //   295: invokestatic 64	java/lang/System:currentTimeMillis	()J
    //   298: lstore 4
    //   300: iconst_0
    //   301: istore_2
    //   302: goto -191 -> 111
    //   305: aload 7
    //   307: astore 6
    //   309: aload 7
    //   311: invokevirtual 120	java/io/OutputStream:close	()V
    //   314: iload_2
    //   315: ifeq +16 -> 331
    //   318: aload_0
    //   319: getfield 132	com/tencent/mm/plugin/sns/model/a/h:ovi	I
    //   322: lconst_0
    //   323: aload_0
    //   324: getfield 68	com/tencent/mm/plugin/sns/model/a/h:ouZ	Lcom/tencent/mm/pointers/PString;
    //   327: invokestatic 136	com/tencent/mm/plugin/sns/model/a/h:a	(IJLcom/tencent/mm/pointers/PString;)Z
    //   330: pop
    //   331: iconst_1
    //   332: ireturn
    //   333: astore_1
    //   334: aconst_null
    //   335: astore 7
    //   337: aload 7
    //   339: astore 6
    //   341: ldc 17
    //   343: aload_1
    //   344: new 23	java/lang/StringBuilder
    //   347: dup
    //   348: ldc 138
    //   350: invokespecial 141	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   353: aload_1
    //   354: invokevirtual 144	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   357: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   363: iconst_0
    //   364: anewarray 21	java/lang/Object
    //   367: invokestatic 125	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   370: aload 7
    //   372: astore 6
    //   374: ldc 17
    //   376: aload_1
    //   377: ldc 70
    //   379: iconst_0
    //   380: anewarray 21	java/lang/Object
    //   383: invokestatic 125	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   386: aload 7
    //   388: ifnull -161 -> 227
    //   391: aload 7
    //   393: invokevirtual 120	java/io/OutputStream:close	()V
    //   396: iconst_0
    //   397: ireturn
    //   398: astore_1
    //   399: ldc 17
    //   401: aload_1
    //   402: ldc 70
    //   404: iconst_0
    //   405: anewarray 21	java/lang/Object
    //   408: invokestatic 125	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   411: iconst_0
    //   412: ireturn
    //   413: astore_1
    //   414: aconst_null
    //   415: astore 6
    //   417: aload 6
    //   419: ifnull +8 -> 427
    //   422: aload 6
    //   424: invokevirtual 120	java/io/OutputStream:close	()V
    //   427: aload_1
    //   428: athrow
    //   429: astore 6
    //   431: ldc 17
    //   433: aload 6
    //   435: ldc 70
    //   437: iconst_0
    //   438: anewarray 21	java/lang/Object
    //   441: invokestatic 125	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   444: goto -17 -> 427
    //   447: astore_1
    //   448: goto -31 -> 417
    //   451: astore_1
    //   452: goto -115 -> 337
    //   455: iconst_1
    //   456: istore_2
    //   457: goto -346 -> 111
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	460	0	this	h
    //   0	460	1	paramInputStream	java.io.InputStream
    //   110	347	2	i	int
    //   121	147	3	j	int
    //   94	205	4	l	long
    //   89	334	6	localOutputStream1	java.io.OutputStream
    //   429	5	6	localIOException	java.io.IOException
    //   85	307	7	localOutputStream2	java.io.OutputStream
    //   49	202	8	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   222	227	229	java/io/IOException
    //   44	87	333	java/lang/Exception
    //   318	331	333	java/lang/Exception
    //   391	396	398	java/io/IOException
    //   44	87	413	finally
    //   318	331	413	finally
    //   422	427	429	java/io/IOException
    //   91	96	447	finally
    //   100	109	447	finally
    //   115	122	447	finally
    //   131	139	447	finally
    //   143	148	447	finally
    //   152	159	447	finally
    //   163	172	447	finally
    //   176	187	447	finally
    //   191	200	447	finally
    //   204	209	447	finally
    //   213	217	447	finally
    //   248	257	447	finally
    //   261	271	447	finally
    //   275	291	447	finally
    //   295	300	447	finally
    //   309	314	447	finally
    //   341	370	447	finally
    //   374	386	447	finally
    //   91	96	451	java/lang/Exception
    //   100	109	451	java/lang/Exception
    //   115	122	451	java/lang/Exception
    //   131	139	451	java/lang/Exception
    //   143	148	451	java/lang/Exception
    //   152	159	451	java/lang/Exception
    //   163	172	451	java/lang/Exception
    //   176	187	451	java/lang/Exception
    //   191	200	451	java/lang/Exception
    //   204	209	451	java/lang/Exception
    //   213	217	451	java/lang/Exception
    //   248	257	451	java/lang/Exception
    //   261	271	451	java/lang/Exception
    //   275	291	451	java/lang/Exception
    //   295	300	451	java/lang/Exception
    //   309	314	451	java/lang/Exception
  }
  
  public final String Oc(String paramString)
  {
    return paramString;
  }
  
  public final boolean bEs()
  {
    String str = i.j(this.bZK);
    e.f(this.ouO.getPath(), this.ouO.bEq(), str);
    return true;
  }
  
  protected final int bEt()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.a.h
 * JD-Core Version:    0.7.0.1
 */
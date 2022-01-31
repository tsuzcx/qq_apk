package com.tencent.mm.plugin.wear.model.e;

import java.util.ArrayList;
import java.util.List;

public final class d
  extends a
{
  public final List<Integer> bYY()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(11001));
    localArrayList.add(Integer.valueOf(11004));
    return localArrayList;
  }
  
  /* Error */
  protected final byte[] p(int paramInt, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: iload_1
    //   1: sipush 11001
    //   4: if_icmpne +92 -> 96
    //   7: new 34	com/tencent/mm/protocal/c/cjc
    //   10: dup
    //   11: invokespecial 35	com/tencent/mm/protocal/c/cjc:<init>	()V
    //   14: astore_3
    //   15: aload_3
    //   16: aload_2
    //   17: invokevirtual 39	com/tencent/mm/protocal/c/cjc:aH	([B)Lcom/tencent/mm/bv/a;
    //   20: pop
    //   21: invokestatic 45	com/tencent/mm/cd/b:csC	()Lcom/tencent/mm/cd/b;
    //   24: getfield 49	com/tencent/mm/cd/b:ukJ	J
    //   27: aload_3
    //   28: getfield 52	com/tencent/mm/protocal/c/cjc:tdO	J
    //   31: lcmp
    //   32: ifle +265 -> 297
    //   35: invokestatic 58	com/tencent/mm/sdk/platformtools/ae:getContext	()Landroid/content/Context;
    //   38: invokevirtual 64	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   41: ldc 66
    //   43: invokevirtual 72	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   46: astore_3
    //   47: aload_3
    //   48: astore_2
    //   49: aload_3
    //   50: invokestatic 78	com/tencent/mm/a/e:k	(Ljava/io/InputStream;)[B
    //   53: astore 4
    //   55: aload_3
    //   56: invokestatic 82	com/tencent/mm/a/e:j	(Ljava/io/InputStream;)V
    //   59: aload 4
    //   61: areturn
    //   62: astore 4
    //   64: aconst_null
    //   65: astore_3
    //   66: aload_3
    //   67: astore_2
    //   68: ldc 84
    //   70: aload 4
    //   72: ldc 86
    //   74: iconst_0
    //   75: anewarray 88	java/lang/Object
    //   78: invokestatic 94	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   81: aload_3
    //   82: invokestatic 82	com/tencent/mm/a/e:j	(Ljava/io/InputStream;)V
    //   85: aconst_null
    //   86: areturn
    //   87: astore_3
    //   88: aconst_null
    //   89: astore_2
    //   90: aload_2
    //   91: invokestatic 82	com/tencent/mm/a/e:j	(Ljava/io/InputStream;)V
    //   94: aload_3
    //   95: athrow
    //   96: iload_1
    //   97: sipush 11004
    //   100: if_icmpne +197 -> 297
    //   103: bipush 9
    //   105: invokestatic 100	com/tencent/mm/plugin/wear/model/c/a:Bf	(I)V
    //   108: new 102	com/tencent/mm/protocal/c/cjd
    //   111: dup
    //   112: invokespecial 103	com/tencent/mm/protocal/c/cjd:<init>	()V
    //   115: astore_3
    //   116: aload_3
    //   117: aload_2
    //   118: invokevirtual 104	com/tencent/mm/protocal/c/cjd:aH	([B)Lcom/tencent/mm/bv/a;
    //   121: pop
    //   122: new 106	com/tencent/mm/protocal/c/cje
    //   125: dup
    //   126: invokespecial 107	com/tencent/mm/protocal/c/cje:<init>	()V
    //   129: astore_2
    //   130: ldc 109
    //   132: invokestatic 115	com/tencent/mm/kernel/g:t	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   135: checkcast 109	com/tencent/mm/plugin/emoji/b/d
    //   138: invokeinterface 119 1 0
    //   143: ifnull +90 -> 233
    //   146: ldc 109
    //   148: invokestatic 115	com/tencent/mm/kernel/g:t	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   151: checkcast 109	com/tencent/mm/plugin/emoji/b/d
    //   154: invokeinterface 119 1 0
    //   159: aload_3
    //   160: getfield 123	com/tencent/mm/protocal/c/cjd:sFP	Ljava/lang/String;
    //   163: invokeinterface 129 2 0
    //   168: astore 4
    //   170: aload 4
    //   172: ifnull +61 -> 233
    //   175: aload 4
    //   177: invokeinterface 133 1 0
    //   182: astore 4
    //   184: aload 4
    //   186: invokeinterface 139 1 0
    //   191: ifeq +42 -> 233
    //   194: aload 4
    //   196: invokeinterface 143 1 0
    //   201: checkcast 145	com/tencent/mm/storage/emotion/EmojiInfo
    //   204: astore 5
    //   206: aload 5
    //   208: invokevirtual 149	com/tencent/mm/storage/emotion/EmojiInfo:Wv	()Ljava/lang/String;
    //   211: invokestatic 155	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   214: ifne -30 -> 184
    //   217: aload_2
    //   218: getfield 159	com/tencent/mm/protocal/c/cje:syU	Ljava/util/LinkedList;
    //   221: aload 5
    //   223: invokevirtual 149	com/tencent/mm/storage/emotion/EmojiInfo:Wv	()Ljava/lang/String;
    //   226: invokevirtual 162	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   229: pop
    //   230: goto -46 -> 184
    //   233: aload_2
    //   234: getfield 159	com/tencent/mm/protocal/c/cje:syU	Ljava/util/LinkedList;
    //   237: invokevirtual 166	java/util/LinkedList:size	()I
    //   240: ifne +49 -> 289
    //   243: new 168	com/tencent/mm/h/a/ua
    //   246: dup
    //   247: invokespecial 169	com/tencent/mm/h/a/ua:<init>	()V
    //   250: astore 4
    //   252: aload 4
    //   254: getfield 173	com/tencent/mm/h/a/ua:cex	Lcom/tencent/mm/h/a/ua$a;
    //   257: iconst_1
    //   258: anewarray 175	java/lang/String
    //   261: dup
    //   262: iconst_0
    //   263: aload_3
    //   264: getfield 123	com/tencent/mm/protocal/c/cjd:sFP	Ljava/lang/String;
    //   267: aastore
    //   268: putfield 181	com/tencent/mm/h/a/ua$a:cey	[Ljava/lang/String;
    //   271: aload 4
    //   273: getfield 173	com/tencent/mm/h/a/ua:cex	Lcom/tencent/mm/h/a/ua$a;
    //   276: iconst_1
    //   277: putfield 185	com/tencent/mm/h/a/ua$a:bHz	I
    //   280: getstatic 191	com/tencent/mm/sdk/b/a:udP	Lcom/tencent/mm/sdk/b/a;
    //   283: aload 4
    //   285: invokevirtual 195	com/tencent/mm/sdk/b/a:m	(Lcom/tencent/mm/sdk/b/b;)Z
    //   288: pop
    //   289: aload_2
    //   290: invokevirtual 199	com/tencent/mm/protocal/c/cje:toByteArray	()[B
    //   293: astore_2
    //   294: aload_2
    //   295: areturn
    //   296: astore_2
    //   297: aconst_null
    //   298: areturn
    //   299: astore_2
    //   300: goto -279 -> 21
    //   303: astore_2
    //   304: goto -182 -> 122
    //   307: astore_3
    //   308: goto -218 -> 90
    //   311: astore 4
    //   313: goto -247 -> 66
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	316	0	this	d
    //   0	316	1	paramInt	int
    //   0	316	2	paramArrayOfByte	byte[]
    //   14	68	3	localObject1	java.lang.Object
    //   87	8	3	localObject2	java.lang.Object
    //   115	149	3	localcjd	com.tencent.mm.protocal.c.cjd
    //   307	1	3	localObject3	java.lang.Object
    //   53	7	4	arrayOfByte	byte[]
    //   62	9	4	localIOException1	java.io.IOException
    //   168	116	4	localObject4	java.lang.Object
    //   311	1	4	localIOException2	java.io.IOException
    //   204	18	5	localEmojiInfo	com.tencent.mm.storage.emotion.EmojiInfo
    // Exception table:
    //   from	to	target	type
    //   35	47	62	java/io/IOException
    //   35	47	87	finally
    //   289	294	296	java/io/IOException
    //   15	21	299	java/io/IOException
    //   116	122	303	java/io/IOException
    //   49	55	307	finally
    //   68	81	307	finally
    //   49	55	311	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.e.d
 * JD-Core Version:    0.7.0.1
 */
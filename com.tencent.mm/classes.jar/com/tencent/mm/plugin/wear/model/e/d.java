package com.tencent.mm.plugin.wear.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class d
  extends a
{
  public final List<Integer> iob()
  {
    AppMethodBeat.i(30075);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(11001));
    localArrayList.add(Integer.valueOf(11004));
    AppMethodBeat.o(30075);
    return localArrayList;
  }
  
  /* Error */
  protected final byte[] u(int paramInt, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: sipush 30076
    //   3: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: iload_1
    //   7: sipush 11001
    //   10: if_icmpne +110 -> 120
    //   13: new 43	com/tencent/mm/protocal/protobuf/gfo
    //   16: dup
    //   17: invokespecial 44	com/tencent/mm/protocal/protobuf/gfo:<init>	()V
    //   20: astore_3
    //   21: aload_3
    //   22: aload_2
    //   23: invokevirtual 48	com/tencent/mm/protocal/protobuf/gfo:parseFrom	([B)Lcom/tencent/mm/bx/a;
    //   26: pop
    //   27: invokestatic 54	com/tencent/mm/smiley/EmojiHelper:iUM	()Lcom/tencent/mm/smiley/EmojiHelper;
    //   30: pop
    //   31: invokestatic 58	com/tencent/mm/smiley/EmojiHelper:iUP	()J
    //   34: aload_3
    //   35: getfield 62	com/tencent/mm/protocal/protobuf/gfo:aanC	J
    //   38: lcmp
    //   39: ifle +285 -> 324
    //   42: invokestatic 68	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   45: invokevirtual 74	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   48: ldc 76
    //   50: invokevirtual 82	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   53: astore_3
    //   54: aload_3
    //   55: astore_2
    //   56: aload_3
    //   57: invokestatic 88	com/tencent/mm/b/e:readFromStream	(Ljava/io/InputStream;)[B
    //   60: astore 4
    //   62: aload 4
    //   64: astore_2
    //   65: aload_3
    //   66: invokestatic 94	com/tencent/mm/vfs/ah:closeQuietly	(Ljava/io/Closeable;)V
    //   69: sipush 30076
    //   72: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   75: aload_2
    //   76: areturn
    //   77: astore 4
    //   79: aconst_null
    //   80: astore_3
    //   81: aload_3
    //   82: astore_2
    //   83: ldc 96
    //   85: aload 4
    //   87: ldc 98
    //   89: iconst_0
    //   90: anewarray 100	java/lang/Object
    //   93: invokestatic 106	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   96: aload_3
    //   97: invokestatic 94	com/tencent/mm/vfs/ah:closeQuietly	(Ljava/io/Closeable;)V
    //   100: aconst_null
    //   101: astore_2
    //   102: goto -33 -> 69
    //   105: astore_3
    //   106: aconst_null
    //   107: astore_2
    //   108: aload_2
    //   109: invokestatic 94	com/tencent/mm/vfs/ah:closeQuietly	(Ljava/io/Closeable;)V
    //   112: sipush 30076
    //   115: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   118: aload_3
    //   119: athrow
    //   120: iload_1
    //   121: sipush 11004
    //   124: if_icmpne +200 -> 324
    //   127: bipush 9
    //   129: invokestatic 111	com/tencent/mm/plugin/wear/model/c/a:asK	(I)V
    //   132: new 113	com/tencent/mm/protocal/protobuf/gfp
    //   135: dup
    //   136: invokespecial 114	com/tencent/mm/protocal/protobuf/gfp:<init>	()V
    //   139: astore_3
    //   140: aload_3
    //   141: aload_2
    //   142: invokevirtual 115	com/tencent/mm/protocal/protobuf/gfp:parseFrom	([B)Lcom/tencent/mm/bx/a;
    //   145: pop
    //   146: new 117	com/tencent/mm/protocal/protobuf/gfq
    //   149: dup
    //   150: invokespecial 118	com/tencent/mm/protocal/protobuf/gfq:<init>	()V
    //   153: astore_2
    //   154: ldc 120
    //   156: invokestatic 126	com/tencent/mm/kernel/h:az	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   159: checkcast 120	com/tencent/mm/plugin/emoji/c/d
    //   162: invokeinterface 130 1 0
    //   167: ifnull +90 -> 257
    //   170: ldc 120
    //   172: invokestatic 126	com/tencent/mm/kernel/h:az	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   175: checkcast 120	com/tencent/mm/plugin/emoji/c/d
    //   178: invokeinterface 130 1 0
    //   183: aload_3
    //   184: getfield 134	com/tencent/mm/protocal/protobuf/gfp:YYC	Ljava/lang/String;
    //   187: invokeinterface 140 2 0
    //   192: astore 4
    //   194: aload 4
    //   196: ifnull +61 -> 257
    //   199: aload 4
    //   201: invokeinterface 144 1 0
    //   206: astore 4
    //   208: aload 4
    //   210: invokeinterface 150 1 0
    //   215: ifeq +42 -> 257
    //   218: aload 4
    //   220: invokeinterface 154 1 0
    //   225: checkcast 156	com/tencent/mm/storage/emotion/EmojiInfo
    //   228: astore 5
    //   230: aload 5
    //   232: invokevirtual 160	com/tencent/mm/storage/emotion/EmojiInfo:getMd5	()Ljava/lang/String;
    //   235: invokestatic 166	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   238: ifne -30 -> 208
    //   241: aload_2
    //   242: getfield 170	com/tencent/mm/protocal/protobuf/gfq:YKG	Ljava/util/LinkedList;
    //   245: aload 5
    //   247: invokevirtual 160	com/tencent/mm/storage/emotion/EmojiInfo:getMd5	()Ljava/lang/String;
    //   250: invokevirtual 173	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   253: pop
    //   254: goto -46 -> 208
    //   257: aload_2
    //   258: getfield 170	com/tencent/mm/protocal/protobuf/gfq:YKG	Ljava/util/LinkedList;
    //   261: invokevirtual 177	java/util/LinkedList:size	()I
    //   264: ifne +46 -> 310
    //   267: new 179	com/tencent/mm/autogen/a/ads
    //   270: dup
    //   271: invokespecial 180	com/tencent/mm/autogen/a/ads:<init>	()V
    //   274: astore 4
    //   276: aload 4
    //   278: getfield 184	com/tencent/mm/autogen/a/ads:iic	Lcom/tencent/mm/autogen/a/ads$a;
    //   281: iconst_1
    //   282: anewarray 186	java/lang/String
    //   285: dup
    //   286: iconst_0
    //   287: aload_3
    //   288: getfield 134	com/tencent/mm/protocal/protobuf/gfp:YYC	Ljava/lang/String;
    //   291: aastore
    //   292: putfield 192	com/tencent/mm/autogen/a/ads$a:iid	[Ljava/lang/String;
    //   295: aload 4
    //   297: getfield 184	com/tencent/mm/autogen/a/ads:iic	Lcom/tencent/mm/autogen/a/ads$a;
    //   300: iconst_1
    //   301: putfield 196	com/tencent/mm/autogen/a/ads$a:hAf	I
    //   304: aload 4
    //   306: invokevirtual 199	com/tencent/mm/autogen/a/ads:publish	()Z
    //   309: pop
    //   310: aload_2
    //   311: invokevirtual 203	com/tencent/mm/protocal/protobuf/gfq:toByteArray	()[B
    //   314: astore_2
    //   315: sipush 30076
    //   318: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   321: aload_2
    //   322: areturn
    //   323: astore_2
    //   324: sipush 30076
    //   327: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   330: aconst_null
    //   331: areturn
    //   332: astore_2
    //   333: goto -306 -> 27
    //   336: astore_2
    //   337: goto -191 -> 146
    //   340: astore_3
    //   341: goto -233 -> 108
    //   344: astore 4
    //   346: goto -265 -> 81
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	349	0	this	d
    //   0	349	1	paramInt	int
    //   0	349	2	paramArrayOfByte	byte[]
    //   20	77	3	localObject1	java.lang.Object
    //   105	14	3	localObject2	java.lang.Object
    //   139	149	3	localgfp	com.tencent.mm.protocal.protobuf.gfp
    //   340	1	3	localObject3	java.lang.Object
    //   60	3	4	arrayOfByte	byte[]
    //   77	9	4	localIOException1	java.io.IOException
    //   192	113	4	localObject4	java.lang.Object
    //   344	1	4	localIOException2	java.io.IOException
    //   228	18	5	localEmojiInfo	com.tencent.mm.storage.emotion.EmojiInfo
    // Exception table:
    //   from	to	target	type
    //   42	54	77	java/io/IOException
    //   42	54	105	finally
    //   310	315	323	java/io/IOException
    //   21	27	332	java/io/IOException
    //   140	146	336	java/io/IOException
    //   56	62	340	finally
    //   83	96	340	finally
    //   56	62	344	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.e.d
 * JD-Core Version:    0.7.0.1
 */
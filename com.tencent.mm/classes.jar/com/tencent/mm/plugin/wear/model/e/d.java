package com.tencent.mm.plugin.wear.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public final class d
  extends a
{
  public final List<Integer> cYL()
  {
    AppMethodBeat.i(26393);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(11001));
    localArrayList.add(Integer.valueOf(11004));
    AppMethodBeat.o(26393);
    return localArrayList;
  }
  
  /* Error */
  protected final byte[] q(int paramInt, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: sipush 26394
    //   3: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: iload_1
    //   7: sipush 11001
    //   10: if_icmpne +109 -> 119
    //   13: new 43	com/tencent/mm/protocal/protobuf/cwp
    //   16: dup
    //   17: invokespecial 44	com/tencent/mm/protocal/protobuf/cwp:<init>	()V
    //   20: astore_3
    //   21: aload_3
    //   22: aload_2
    //   23: invokevirtual 48	com/tencent/mm/protocal/protobuf/cwp:parseFrom	([B)Lcom/tencent/mm/bv/a;
    //   26: pop
    //   27: invokestatic 54	com/tencent/mm/cd/b:duW	()Lcom/tencent/mm/cd/b;
    //   30: getfield 58	com/tencent/mm/cd/b:yun	J
    //   33: aload_3
    //   34: getfield 61	com/tencent/mm/protocal/protobuf/cwp:xbN	J
    //   37: lcmp
    //   38: ifle +288 -> 326
    //   41: invokestatic 67	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   44: invokevirtual 73	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   47: ldc 75
    //   49: invokevirtual 81	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   52: astore_3
    //   53: aload_3
    //   54: astore_2
    //   55: aload_3
    //   56: invokestatic 87	com/tencent/mm/a/e:m	(Ljava/io/InputStream;)[B
    //   59: astore 4
    //   61: aload 4
    //   63: astore_2
    //   64: aload_3
    //   65: invokestatic 91	com/tencent/mm/a/e:l	(Ljava/io/InputStream;)V
    //   68: sipush 26394
    //   71: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   74: aload_2
    //   75: areturn
    //   76: astore 4
    //   78: aconst_null
    //   79: astore_3
    //   80: aload_3
    //   81: astore_2
    //   82: ldc 93
    //   84: aload 4
    //   86: ldc 95
    //   88: iconst_0
    //   89: anewarray 97	java/lang/Object
    //   92: invokestatic 103	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   95: aload_3
    //   96: invokestatic 91	com/tencent/mm/a/e:l	(Ljava/io/InputStream;)V
    //   99: aconst_null
    //   100: astore_2
    //   101: goto -33 -> 68
    //   104: astore_3
    //   105: aconst_null
    //   106: astore_2
    //   107: aload_2
    //   108: invokestatic 91	com/tencent/mm/a/e:l	(Ljava/io/InputStream;)V
    //   111: sipush 26394
    //   114: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   117: aload_3
    //   118: athrow
    //   119: iload_1
    //   120: sipush 11004
    //   123: if_icmpne +203 -> 326
    //   126: bipush 9
    //   128: invokestatic 108	com/tencent/mm/plugin/wear/model/c/a:IR	(I)V
    //   131: new 110	com/tencent/mm/protocal/protobuf/cwq
    //   134: dup
    //   135: invokespecial 111	com/tencent/mm/protocal/protobuf/cwq:<init>	()V
    //   138: astore_3
    //   139: aload_3
    //   140: aload_2
    //   141: invokevirtual 112	com/tencent/mm/protocal/protobuf/cwq:parseFrom	([B)Lcom/tencent/mm/bv/a;
    //   144: pop
    //   145: new 114	com/tencent/mm/protocal/protobuf/cwr
    //   148: dup
    //   149: invokespecial 115	com/tencent/mm/protocal/protobuf/cwr:<init>	()V
    //   152: astore_2
    //   153: ldc 117
    //   155: invokestatic 123	com/tencent/mm/kernel/g:G	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   158: checkcast 117	com/tencent/mm/plugin/emoji/b/d
    //   161: invokeinterface 127 1 0
    //   166: ifnull +90 -> 256
    //   169: ldc 117
    //   171: invokestatic 123	com/tencent/mm/kernel/g:G	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
    //   174: checkcast 117	com/tencent/mm/plugin/emoji/b/d
    //   177: invokeinterface 127 1 0
    //   182: aload_3
    //   183: getfield 131	com/tencent/mm/protocal/protobuf/cwq:wCj	Ljava/lang/String;
    //   186: invokeinterface 137 2 0
    //   191: astore 4
    //   193: aload 4
    //   195: ifnull +61 -> 256
    //   198: aload 4
    //   200: invokeinterface 141 1 0
    //   205: astore 4
    //   207: aload 4
    //   209: invokeinterface 147 1 0
    //   214: ifeq +42 -> 256
    //   217: aload 4
    //   219: invokeinterface 151 1 0
    //   224: checkcast 153	com/tencent/mm/storage/emotion/EmojiInfo
    //   227: astore 5
    //   229: aload 5
    //   231: invokevirtual 157	com/tencent/mm/storage/emotion/EmojiInfo:Al	()Ljava/lang/String;
    //   234: invokestatic 163	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   237: ifne -30 -> 207
    //   240: aload_2
    //   241: getfield 167	com/tencent/mm/protocal/protobuf/cwr:wsV	Ljava/util/LinkedList;
    //   244: aload 5
    //   246: invokevirtual 157	com/tencent/mm/storage/emotion/EmojiInfo:Al	()Ljava/lang/String;
    //   249: invokevirtual 170	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   252: pop
    //   253: goto -46 -> 207
    //   256: aload_2
    //   257: getfield 167	com/tencent/mm/protocal/protobuf/cwr:wsV	Ljava/util/LinkedList;
    //   260: invokevirtual 174	java/util/LinkedList:size	()I
    //   263: ifne +49 -> 312
    //   266: new 176	com/tencent/mm/g/a/vw
    //   269: dup
    //   270: invokespecial 177	com/tencent/mm/g/a/vw:<init>	()V
    //   273: astore 4
    //   275: aload 4
    //   277: getfield 181	com/tencent/mm/g/a/vw:cNk	Lcom/tencent/mm/g/a/vw$a;
    //   280: iconst_1
    //   281: anewarray 183	java/lang/String
    //   284: dup
    //   285: iconst_0
    //   286: aload_3
    //   287: getfield 131	com/tencent/mm/protocal/protobuf/cwq:wCj	Ljava/lang/String;
    //   290: aastore
    //   291: putfield 189	com/tencent/mm/g/a/vw$a:cNl	[Ljava/lang/String;
    //   294: aload 4
    //   296: getfield 181	com/tencent/mm/g/a/vw:cNk	Lcom/tencent/mm/g/a/vw$a;
    //   299: iconst_1
    //   300: putfield 193	com/tencent/mm/g/a/vw$a:coO	I
    //   303: getstatic 199	com/tencent/mm/sdk/b/a:ymk	Lcom/tencent/mm/sdk/b/a;
    //   306: aload 4
    //   308: invokevirtual 202	com/tencent/mm/sdk/b/a:l	(Lcom/tencent/mm/sdk/b/b;)Z
    //   311: pop
    //   312: aload_2
    //   313: invokevirtual 206	com/tencent/mm/protocal/protobuf/cwr:toByteArray	()[B
    //   316: astore_2
    //   317: sipush 26394
    //   320: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   323: aload_2
    //   324: areturn
    //   325: astore_2
    //   326: sipush 26394
    //   329: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   332: aconst_null
    //   333: areturn
    //   334: astore_2
    //   335: goto -308 -> 27
    //   338: astore_2
    //   339: goto -194 -> 145
    //   342: astore_3
    //   343: goto -236 -> 107
    //   346: astore 4
    //   348: goto -268 -> 80
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	351	0	this	d
    //   0	351	1	paramInt	int
    //   0	351	2	paramArrayOfByte	byte[]
    //   20	76	3	localObject1	java.lang.Object
    //   104	14	3	localObject2	java.lang.Object
    //   138	149	3	localcwq	com.tencent.mm.protocal.protobuf.cwq
    //   342	1	3	localObject3	java.lang.Object
    //   59	3	4	arrayOfByte	byte[]
    //   76	9	4	localIOException1	java.io.IOException
    //   191	116	4	localObject4	java.lang.Object
    //   346	1	4	localIOException2	java.io.IOException
    //   227	18	5	localEmojiInfo	com.tencent.mm.storage.emotion.EmojiInfo
    // Exception table:
    //   from	to	target	type
    //   41	53	76	java/io/IOException
    //   41	53	104	finally
    //   312	317	325	java/io/IOException
    //   21	27	334	java/io/IOException
    //   139	145	338	java/io/IOException
    //   55	61	342	finally
    //   82	95	342	finally
    //   55	61	346	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.e.d
 * JD-Core Version:    0.7.0.1
 */
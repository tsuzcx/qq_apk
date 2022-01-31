package com.tencent.mm.plugin.wear.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cwy;
import java.util.ArrayList;
import java.util.List;

public final class i
  extends a
{
  public cwy uHH;
  
  public final List<Integer> cYL()
  {
    AppMethodBeat.i(26403);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(11002));
    AppMethodBeat.o(26403);
    return localArrayList;
  }
  
  /* Error */
  protected final byte[] q(int paramInt, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: sipush 26404
    //   3: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: iload_1
    //   7: sipush 11002
    //   10: if_icmpne +292 -> 302
    //   13: iconst_1
    //   14: iconst_0
    //   15: invokestatic 51	com/tencent/mm/plugin/wear/model/c/a:gD	(II)V
    //   18: iconst_0
    //   19: invokestatic 54	com/tencent/mm/plugin/wear/model/c/a:IR	(I)V
    //   22: new 56	com/tencent/mm/g/a/vw
    //   25: dup
    //   26: invokespecial 57	com/tencent/mm/g/a/vw:<init>	()V
    //   29: astore 4
    //   31: aload 4
    //   33: getfield 61	com/tencent/mm/g/a/vw:cNk	Lcom/tencent/mm/g/a/vw$a;
    //   36: invokestatic 67	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   39: invokevirtual 73	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   42: ldc 74
    //   44: invokevirtual 80	android/content/res/Resources:getStringArray	(I)[Ljava/lang/String;
    //   47: putfield 86	com/tencent/mm/g/a/vw$a:cNl	[Ljava/lang/String;
    //   50: aload 4
    //   52: getfield 61	com/tencent/mm/g/a/vw:cNk	Lcom/tencent/mm/g/a/vw$a;
    //   55: iconst_1
    //   56: putfield 90	com/tencent/mm/g/a/vw$a:coO	I
    //   59: getstatic 96	com/tencent/mm/sdk/b/a:ymk	Lcom/tencent/mm/sdk/b/a;
    //   62: aload 4
    //   64: invokevirtual 100	com/tencent/mm/sdk/b/a:l	(Lcom/tencent/mm/sdk/b/b;)Z
    //   67: pop
    //   68: invokestatic 106	com/tencent/mm/plugin/wear/model/a:cYy	()Lcom/tencent/mm/plugin/wear/model/a;
    //   71: getfield 110	com/tencent/mm/plugin/wear/model/a:uGC	Lcom/tencent/mm/plugin/wear/model/d;
    //   74: aload_2
    //   75: invokevirtual 116	com/tencent/mm/plugin/wear/model/d:bE	([B)[B
    //   78: astore_2
    //   79: aload_2
    //   80: ifnull +222 -> 302
    //   83: new 118	com/tencent/mm/protocal/protobuf/cwy
    //   86: dup
    //   87: invokespecial 119	com/tencent/mm/protocal/protobuf/cwy:<init>	()V
    //   90: astore 5
    //   92: aload 5
    //   94: aload_2
    //   95: invokevirtual 123	com/tencent/mm/protocal/protobuf/cwy:parseFrom	([B)Lcom/tencent/mm/bv/a;
    //   98: pop
    //   99: new 125	com/tencent/mm/protocal/protobuf/cwz
    //   102: dup
    //   103: invokespecial 126	com/tencent/mm/protocal/protobuf/cwz:<init>	()V
    //   106: astore 6
    //   108: bipush 20
    //   110: istore_1
    //   111: aconst_null
    //   112: astore_2
    //   113: aload_2
    //   114: astore 4
    //   116: iload_1
    //   117: ifle +32 -> 149
    //   120: invokestatic 132	com/tencent/mm/model/r:Zn	()Ljava/lang/String;
    //   123: astore_2
    //   124: aload_2
    //   125: invokestatic 138	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   128: istore_3
    //   129: aload_2
    //   130: astore 4
    //   132: iload_3
    //   133: ifeq +16 -> 149
    //   136: ldc2_w 139
    //   139: invokestatic 146	java/lang/Thread:sleep	(J)V
    //   142: iload_1
    //   143: iconst_1
    //   144: isub
    //   145: istore_1
    //   146: goto -33 -> 113
    //   149: aload 4
    //   151: invokestatic 138	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   154: istore_3
    //   155: iload_3
    //   156: ifeq +11 -> 167
    //   159: sipush 26404
    //   162: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   165: aconst_null
    //   166: areturn
    //   167: aload 6
    //   169: aload 4
    //   171: putfield 150	com/tencent/mm/protocal/protobuf/cwz:Username	Ljava/lang/String;
    //   174: invokestatic 67	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   177: invokestatic 153	com/tencent/mm/sdk/platformtools/ah:dsP	()Ljava/lang/String;
    //   180: iconst_0
    //   181: invokevirtual 157	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   184: astore_2
    //   185: invokestatic 67	com/tencent/mm/sdk/platformtools/ah:getContext	()Landroid/content/Context;
    //   188: pop
    //   189: aload_2
    //   190: invokestatic 163	com/tencent/mm/sdk/platformtools/aa:g	(Landroid/content/SharedPreferences;)Ljava/lang/String;
    //   193: astore_2
    //   194: invokestatic 166	com/tencent/mm/sdk/platformtools/aa:dsG	()Ljava/lang/String;
    //   197: astore 4
    //   199: aload_2
    //   200: ldc 168
    //   202: invokevirtual 173	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   205: ifeq +75 -> 280
    //   208: aload 6
    //   210: aload 4
    //   212: putfield 176	com/tencent/mm/protocal/protobuf/cwz:lGH	Ljava/lang/String;
    //   215: aload 6
    //   217: invokevirtual 180	com/tencent/mm/protocal/protobuf/cwz:toByteArray	()[B
    //   220: astore_2
    //   221: invokestatic 106	com/tencent/mm/plugin/wear/model/a:cYy	()Lcom/tencent/mm/plugin/wear/model/a;
    //   224: getfield 110	com/tencent/mm/plugin/wear/model/a:uGC	Lcom/tencent/mm/plugin/wear/model/d;
    //   227: aload_2
    //   228: invokevirtual 183	com/tencent/mm/plugin/wear/model/d:bF	([B)[B
    //   231: astore_2
    //   232: aload_2
    //   233: ifnull +77 -> 310
    //   236: aload_0
    //   237: aload 5
    //   239: putfield 185	com/tencent/mm/plugin/wear/model/e/i:uHH	Lcom/tencent/mm/protocal/protobuf/cwy;
    //   242: new 187	com/tencent/mm/g/a/vx
    //   245: dup
    //   246: invokespecial 188	com/tencent/mm/g/a/vx:<init>	()V
    //   249: astore 4
    //   251: aload 4
    //   253: getfield 192	com/tencent/mm/g/a/vx:cNm	Lcom/tencent/mm/g/a/vx$a;
    //   256: bipush 9
    //   258: putfield 195	com/tencent/mm/g/a/vx$a:coO	I
    //   261: getstatic 96	com/tencent/mm/sdk/b/a:ymk	Lcom/tencent/mm/sdk/b/a;
    //   264: aload 4
    //   266: invokestatic 201	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   269: invokevirtual 205	com/tencent/mm/sdk/b/a:a	(Lcom/tencent/mm/sdk/b/b;Landroid/os/Looper;)V
    //   272: sipush 26404
    //   275: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   278: aload_2
    //   279: areturn
    //   280: aload 6
    //   282: aload_2
    //   283: putfield 176	com/tencent/mm/protocal/protobuf/cwz:lGH	Ljava/lang/String;
    //   286: goto -71 -> 215
    //   289: astore_2
    //   290: ldc 207
    //   292: aload_2
    //   293: ldc 209
    //   295: iconst_0
    //   296: anewarray 211	java/lang/Object
    //   299: invokestatic 217	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   302: sipush 26404
    //   305: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   308: aconst_null
    //   309: areturn
    //   310: sipush 26404
    //   313: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   316: aconst_null
    //   317: areturn
    //   318: astore 4
    //   320: goto -178 -> 142
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	323	0	this	i
    //   0	323	1	paramInt	int
    //   0	323	2	paramArrayOfByte	byte[]
    //   128	28	3	bool	boolean
    //   29	236	4	localObject	java.lang.Object
    //   318	1	4	localInterruptedException	java.lang.InterruptedException
    //   90	148	5	localcwy	cwy
    //   106	175	6	localcwz	com.tencent.mm.protocal.protobuf.cwz
    // Exception table:
    //   from	to	target	type
    //   83	108	289	java/io/IOException
    //   120	129	289	java/io/IOException
    //   136	142	289	java/io/IOException
    //   149	155	289	java/io/IOException
    //   167	215	289	java/io/IOException
    //   215	232	289	java/io/IOException
    //   236	272	289	java/io/IOException
    //   280	286	289	java/io/IOException
    //   136	142	318	java/lang/InterruptedException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.e.i
 * JD-Core Version:    0.7.0.1
 */
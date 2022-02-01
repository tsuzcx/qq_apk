package com.tencent.mm.plugin.wear.model.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ect;
import java.util.ArrayList;
import java.util.List;

public final class i
  extends a
{
  public ect Dxz;
  
  public final List<Integer> eKN()
  {
    AppMethodBeat.i(30085);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(11002));
    AppMethodBeat.o(30085);
    return localArrayList;
  }
  
  /* Error */
  protected final byte[] s(int paramInt, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: sipush 30086
    //   3: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: iload_1
    //   7: sipush 11002
    //   10: if_icmpne +289 -> 299
    //   13: iconst_1
    //   14: iconst_0
    //   15: invokestatic 51	com/tencent/mm/plugin/wear/model/c/a:iP	(II)V
    //   18: iconst_0
    //   19: invokestatic 54	com/tencent/mm/plugin/wear/model/c/a:VS	(I)V
    //   22: new 56	com/tencent/mm/g/a/zb
    //   25: dup
    //   26: invokespecial 57	com/tencent/mm/g/a/zb:<init>	()V
    //   29: astore 4
    //   31: aload 4
    //   33: getfield 61	com/tencent/mm/g/a/zb:dOh	Lcom/tencent/mm/g/a/zb$a;
    //   36: invokestatic 67	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   39: invokevirtual 73	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   42: ldc 74
    //   44: invokevirtual 80	android/content/res/Resources:getStringArray	(I)[Ljava/lang/String;
    //   47: putfield 86	com/tencent/mm/g/a/zb$a:dOi	[Ljava/lang/String;
    //   50: aload 4
    //   52: getfield 61	com/tencent/mm/g/a/zb:dOh	Lcom/tencent/mm/g/a/zb$a;
    //   55: iconst_1
    //   56: putfield 90	com/tencent/mm/g/a/zb$a:dkM	I
    //   59: getstatic 96	com/tencent/mm/sdk/b/a:IbL	Lcom/tencent/mm/sdk/b/a;
    //   62: aload 4
    //   64: invokevirtual 100	com/tencent/mm/sdk/b/a:l	(Lcom/tencent/mm/sdk/b/b;)Z
    //   67: pop
    //   68: invokestatic 106	com/tencent/mm/plugin/wear/model/a:eKv	()Lcom/tencent/mm/plugin/wear/model/d;
    //   71: aload_2
    //   72: invokevirtual 112	com/tencent/mm/plugin/wear/model/d:cc	([B)[B
    //   75: astore_2
    //   76: aload_2
    //   77: ifnull +219 -> 296
    //   80: new 114	com/tencent/mm/protocal/protobuf/ect
    //   83: dup
    //   84: invokespecial 115	com/tencent/mm/protocal/protobuf/ect:<init>	()V
    //   87: astore 5
    //   89: aload 5
    //   91: aload_2
    //   92: invokevirtual 119	com/tencent/mm/protocal/protobuf/ect:parseFrom	([B)Lcom/tencent/mm/bx/a;
    //   95: pop
    //   96: new 121	com/tencent/mm/protocal/protobuf/ecu
    //   99: dup
    //   100: invokespecial 122	com/tencent/mm/protocal/protobuf/ecu:<init>	()V
    //   103: astore 6
    //   105: bipush 20
    //   107: istore_1
    //   108: aconst_null
    //   109: astore_2
    //   110: aload_2
    //   111: astore 4
    //   113: iload_1
    //   114: ifle +32 -> 146
    //   117: invokestatic 128	com/tencent/mm/model/u:aAm	()Ljava/lang/String;
    //   120: astore_2
    //   121: aload_2
    //   122: invokestatic 134	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   125: istore_3
    //   126: aload_2
    //   127: astore 4
    //   129: iload_3
    //   130: ifeq +16 -> 146
    //   133: ldc2_w 135
    //   136: invokestatic 142	java/lang/Thread:sleep	(J)V
    //   139: iload_1
    //   140: iconst_1
    //   141: isub
    //   142: istore_1
    //   143: goto -33 -> 110
    //   146: aload 4
    //   148: invokestatic 134	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   151: istore_3
    //   152: iload_3
    //   153: ifeq +11 -> 164
    //   156: sipush 30086
    //   159: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   162: aconst_null
    //   163: areturn
    //   164: aload 6
    //   166: aload 4
    //   168: putfield 146	com/tencent/mm/protocal/protobuf/ecu:Username	Ljava/lang/String;
    //   171: invokestatic 67	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   174: invokestatic 149	com/tencent/mm/sdk/platformtools/aj:fkC	()Ljava/lang/String;
    //   177: iconst_0
    //   178: invokevirtual 153	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   181: astore_2
    //   182: invokestatic 67	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   185: pop
    //   186: aload_2
    //   187: invokestatic 159	com/tencent/mm/sdk/platformtools/ac:g	(Landroid/content/SharedPreferences;)Ljava/lang/String;
    //   190: astore_2
    //   191: invokestatic 162	com/tencent/mm/sdk/platformtools/ac:fks	()Ljava/lang/String;
    //   194: astore 4
    //   196: aload_2
    //   197: ldc 164
    //   199: invokevirtual 169	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   202: ifeq +72 -> 274
    //   205: aload 6
    //   207: aload 4
    //   209: putfield 172	com/tencent/mm/protocal/protobuf/ecu:qei	Ljava/lang/String;
    //   212: aload 6
    //   214: invokevirtual 176	com/tencent/mm/protocal/protobuf/ecu:toByteArray	()[B
    //   217: astore_2
    //   218: invokestatic 106	com/tencent/mm/plugin/wear/model/a:eKv	()Lcom/tencent/mm/plugin/wear/model/d;
    //   221: aload_2
    //   222: invokevirtual 179	com/tencent/mm/plugin/wear/model/d:cd	([B)[B
    //   225: astore_2
    //   226: aload_2
    //   227: ifnull +80 -> 307
    //   230: aload_0
    //   231: aload 5
    //   233: putfield 181	com/tencent/mm/plugin/wear/model/e/i:Dxz	Lcom/tencent/mm/protocal/protobuf/ect;
    //   236: new 183	com/tencent/mm/g/a/zc
    //   239: dup
    //   240: invokespecial 184	com/tencent/mm/g/a/zc:<init>	()V
    //   243: astore 4
    //   245: aload 4
    //   247: getfield 188	com/tencent/mm/g/a/zc:dOj	Lcom/tencent/mm/g/a/zc$a;
    //   250: bipush 9
    //   252: putfield 191	com/tencent/mm/g/a/zc$a:dkM	I
    //   255: getstatic 96	com/tencent/mm/sdk/b/a:IbL	Lcom/tencent/mm/sdk/b/a;
    //   258: aload 4
    //   260: invokestatic 197	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   263: invokevirtual 201	com/tencent/mm/sdk/b/a:a	(Lcom/tencent/mm/sdk/b/b;Landroid/os/Looper;)V
    //   266: sipush 30086
    //   269: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   272: aload_2
    //   273: areturn
    //   274: aload 6
    //   276: aload_2
    //   277: putfield 172	com/tencent/mm/protocal/protobuf/ecu:qei	Ljava/lang/String;
    //   280: goto -68 -> 212
    //   283: astore_2
    //   284: ldc 203
    //   286: aload_2
    //   287: ldc 205
    //   289: iconst_0
    //   290: anewarray 207	java/lang/Object
    //   293: invokestatic 213	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   296: invokestatic 216	com/tencent/mm/plugin/wear/model/a:eKA	()V
    //   299: sipush 30086
    //   302: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   305: aconst_null
    //   306: areturn
    //   307: sipush 30086
    //   310: invokestatic 37	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   313: aconst_null
    //   314: areturn
    //   315: astore 4
    //   317: goto -178 -> 139
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	320	0	this	i
    //   0	320	1	paramInt	int
    //   0	320	2	paramArrayOfByte	byte[]
    //   125	28	3	bool	boolean
    //   29	230	4	localObject	java.lang.Object
    //   315	1	4	localInterruptedException	java.lang.InterruptedException
    //   87	145	5	localect	ect
    //   103	172	6	localecu	com.tencent.mm.protocal.protobuf.ecu
    // Exception table:
    //   from	to	target	type
    //   80	105	283	java/io/IOException
    //   117	126	283	java/io/IOException
    //   133	139	283	java/io/IOException
    //   146	152	283	java/io/IOException
    //   164	212	283	java/io/IOException
    //   212	226	283	java/io/IOException
    //   230	266	283	java/io/IOException
    //   274	280	283	java/io/IOException
    //   133	139	315	java/lang/InterruptedException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.e.i
 * JD-Core Version:    0.7.0.1
 */
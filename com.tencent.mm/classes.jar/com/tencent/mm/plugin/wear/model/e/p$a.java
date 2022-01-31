package com.tencent.mm.plugin.wear.model.e;

import com.tencent.mm.plugin.wear.model.f.c;
import com.tencent.mm.protocal.protobuf.cyb;

final class p$a
  extends c
{
  public int cnU;
  public int fOC;
  public cyb uHS;
  public int uHh = 2;
  
  public p$a(p paramp, int paramInt, cyb paramcyb)
  {
    this.cnU = paramInt;
    this.fOC = 30001;
    this.uHS = paramcyb;
  }
  
  public final String getName()
  {
    return "WearVoiceToTextTask";
  }
  
  /* Error */
  public final void send()
  {
    // Byte code:
    //   0: sipush 26420
    //   3: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 30	com/tencent/mm/plugin/wear/model/e/p$a:uHS	Lcom/tencent/mm/protocal/protobuf/cyb;
    //   10: invokevirtual 50	com/tencent/mm/protocal/protobuf/cyb:toByteArray	()[B
    //   13: astore_1
    //   14: invokestatic 56	com/tencent/mm/plugin/wear/model/a:cYy	()Lcom/tencent/mm/plugin/wear/model/a;
    //   17: getfield 60	com/tencent/mm/plugin/wear/model/a:uGC	Lcom/tencent/mm/plugin/wear/model/d;
    //   20: aload_1
    //   21: invokevirtual 66	com/tencent/mm/plugin/wear/model/d:bF	([B)[B
    //   24: astore_2
    //   25: new 68	java/io/ByteArrayOutputStream
    //   28: dup
    //   29: invokespecial 69	java/io/ByteArrayOutputStream:<init>	()V
    //   32: astore_1
    //   33: new 71	java/io/DataOutputStream
    //   36: dup
    //   37: aload_1
    //   38: invokespecial 74	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   41: astore_3
    //   42: aload_3
    //   43: aload_0
    //   44: getfield 24	com/tencent/mm/plugin/wear/model/e/p$a:uHh	I
    //   47: invokevirtual 77	java/io/DataOutputStream:writeInt	(I)V
    //   50: aload_3
    //   51: aload_0
    //   52: getfield 26	com/tencent/mm/plugin/wear/model/e/p$a:cnU	I
    //   55: invokevirtual 77	java/io/DataOutputStream:writeInt	(I)V
    //   58: aload_3
    //   59: aload_0
    //   60: getfield 28	com/tencent/mm/plugin/wear/model/e/p$a:fOC	I
    //   63: invokevirtual 77	java/io/DataOutputStream:writeInt	(I)V
    //   66: aload_2
    //   67: ifnull +94 -> 161
    //   70: aload_2
    //   71: arraylength
    //   72: ifle +89 -> 161
    //   75: aload_3
    //   76: aload_2
    //   77: arraylength
    //   78: invokevirtual 77	java/io/DataOutputStream:writeInt	(I)V
    //   81: aload_3
    //   82: aload_2
    //   83: invokevirtual 81	java/io/DataOutputStream:write	([B)V
    //   86: aload_1
    //   87: invokevirtual 82	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   90: astore_2
    //   91: ldc 84
    //   93: ldc 86
    //   95: iconst_2
    //   96: anewarray 88	java/lang/Object
    //   99: dup
    //   100: iconst_0
    //   101: aload_0
    //   102: getfield 28	com/tencent/mm/plugin/wear/model/e/p$a:fOC	I
    //   105: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   108: aastore
    //   109: dup
    //   110: iconst_1
    //   111: aload_2
    //   112: arraylength
    //   113: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   116: aastore
    //   117: invokestatic 99	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   120: invokestatic 56	com/tencent/mm/plugin/wear/model/a:cYy	()Lcom/tencent/mm/plugin/wear/model/a;
    //   123: getfield 60	com/tencent/mm/plugin/wear/model/a:uGC	Lcom/tencent/mm/plugin/wear/model/d;
    //   126: aload_1
    //   127: invokevirtual 82	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   130: invokevirtual 103	com/tencent/mm/plugin/wear/model/d:bD	([B)Z
    //   133: pop
    //   134: sipush 26420
    //   137: invokestatic 106	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   140: return
    //   141: astore_1
    //   142: ldc 84
    //   144: aload_1
    //   145: ldc 108
    //   147: iconst_0
    //   148: anewarray 88	java/lang/Object
    //   151: invokestatic 112	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   154: sipush 26420
    //   157: invokestatic 106	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   160: return
    //   161: aload_3
    //   162: iconst_0
    //   163: invokevirtual 77	java/io/DataOutputStream:writeInt	(I)V
    //   166: goto -80 -> 86
    //   169: astore_1
    //   170: ldc 84
    //   172: aload_1
    //   173: ldc 114
    //   175: iconst_3
    //   176: anewarray 88	java/lang/Object
    //   179: dup
    //   180: iconst_0
    //   181: aload_0
    //   182: getfield 24	com/tencent/mm/plugin/wear/model/e/p$a:uHh	I
    //   185: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   188: aastore
    //   189: dup
    //   190: iconst_1
    //   191: aload_0
    //   192: getfield 26	com/tencent/mm/plugin/wear/model/e/p$a:cnU	I
    //   195: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   198: aastore
    //   199: dup
    //   200: iconst_2
    //   201: aload_0
    //   202: getfield 28	com/tencent/mm/plugin/wear/model/e/p$a:fOC	I
    //   205: invokestatic 94	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   208: aastore
    //   209: invokestatic 112	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   212: sipush 26420
    //   215: invokestatic 106	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   218: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	219	0	this	a
    //   13	114	1	localObject	java.lang.Object
    //   141	4	1	localIOException1	java.io.IOException
    //   169	4	1	localIOException2	java.io.IOException
    //   24	88	2	arrayOfByte	byte[]
    //   41	121	3	localDataOutputStream	java.io.DataOutputStream
    // Exception table:
    //   from	to	target	type
    //   6	25	141	java/io/IOException
    //   42	66	169	java/io/IOException
    //   70	86	169	java/io/IOException
    //   86	134	169	java/io/IOException
    //   161	166	169	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.e.p.a
 * JD-Core Version:    0.7.0.1
 */
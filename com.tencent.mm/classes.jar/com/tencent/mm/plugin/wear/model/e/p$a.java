package com.tencent.mm.plugin.wear.model.e;

import com.tencent.mm.plugin.wear.model.f.c;
import com.tencent.mm.protocal.c.cko;

final class p$a
  extends c
{
  public int igH;
  public int qRZ = 2;
  public cko qSL;
  public int qSa;
  
  public p$a(p paramp, int paramInt, cko paramcko)
  {
    this.igH = paramInt;
    this.qSa = 30001;
    this.qSL = paramcko;
  }
  
  public final String getName()
  {
    return "WearVoiceToTextTask";
  }
  
  /* Error */
  protected final void send()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 30	com/tencent/mm/plugin/wear/model/e/p$a:qSL	Lcom/tencent/mm/protocal/c/cko;
    //   4: invokevirtual 44	com/tencent/mm/protocal/c/cko:toByteArray	()[B
    //   7: astore_1
    //   8: invokestatic 50	com/tencent/mm/plugin/wear/model/a:bYL	()Lcom/tencent/mm/plugin/wear/model/a;
    //   11: getfield 54	com/tencent/mm/plugin/wear/model/a:qRu	Lcom/tencent/mm/plugin/wear/model/d;
    //   14: aload_1
    //   15: invokevirtual 60	com/tencent/mm/plugin/wear/model/d:be	([B)[B
    //   18: astore_2
    //   19: new 62	java/io/ByteArrayOutputStream
    //   22: dup
    //   23: invokespecial 63	java/io/ByteArrayOutputStream:<init>	()V
    //   26: astore_1
    //   27: new 65	java/io/DataOutputStream
    //   30: dup
    //   31: aload_1
    //   32: invokespecial 68	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   35: astore_3
    //   36: aload_3
    //   37: aload_0
    //   38: getfield 24	com/tencent/mm/plugin/wear/model/e/p$a:qRZ	I
    //   41: invokevirtual 72	java/io/DataOutputStream:writeInt	(I)V
    //   44: aload_3
    //   45: aload_0
    //   46: getfield 26	com/tencent/mm/plugin/wear/model/e/p$a:igH	I
    //   49: invokevirtual 72	java/io/DataOutputStream:writeInt	(I)V
    //   52: aload_3
    //   53: aload_0
    //   54: getfield 28	com/tencent/mm/plugin/wear/model/e/p$a:qSa	I
    //   57: invokevirtual 72	java/io/DataOutputStream:writeInt	(I)V
    //   60: aload_2
    //   61: ifnull +82 -> 143
    //   64: aload_2
    //   65: arraylength
    //   66: ifle +77 -> 143
    //   69: aload_3
    //   70: aload_2
    //   71: arraylength
    //   72: invokevirtual 72	java/io/DataOutputStream:writeInt	(I)V
    //   75: aload_3
    //   76: aload_2
    //   77: invokevirtual 76	java/io/DataOutputStream:write	([B)V
    //   80: aload_1
    //   81: invokevirtual 77	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   84: astore_2
    //   85: ldc 79
    //   87: ldc 81
    //   89: iconst_2
    //   90: anewarray 83	java/lang/Object
    //   93: dup
    //   94: iconst_0
    //   95: aload_0
    //   96: getfield 28	com/tencent/mm/plugin/wear/model/e/p$a:qSa	I
    //   99: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   102: aastore
    //   103: dup
    //   104: iconst_1
    //   105: aload_2
    //   106: arraylength
    //   107: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   110: aastore
    //   111: invokestatic 95	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   114: invokestatic 50	com/tencent/mm/plugin/wear/model/a:bYL	()Lcom/tencent/mm/plugin/wear/model/a;
    //   117: getfield 54	com/tencent/mm/plugin/wear/model/a:qRu	Lcom/tencent/mm/plugin/wear/model/d;
    //   120: aload_1
    //   121: invokevirtual 77	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   124: invokevirtual 99	com/tencent/mm/plugin/wear/model/d:bc	([B)Z
    //   127: pop
    //   128: return
    //   129: astore_1
    //   130: ldc 79
    //   132: aload_1
    //   133: ldc 101
    //   135: iconst_0
    //   136: anewarray 83	java/lang/Object
    //   139: invokestatic 105	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   142: return
    //   143: aload_3
    //   144: iconst_0
    //   145: invokevirtual 72	java/io/DataOutputStream:writeInt	(I)V
    //   148: goto -68 -> 80
    //   151: astore_1
    //   152: ldc 79
    //   154: aload_1
    //   155: ldc 107
    //   157: iconst_3
    //   158: anewarray 83	java/lang/Object
    //   161: dup
    //   162: iconst_0
    //   163: aload_0
    //   164: getfield 24	com/tencent/mm/plugin/wear/model/e/p$a:qRZ	I
    //   167: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   170: aastore
    //   171: dup
    //   172: iconst_1
    //   173: aload_0
    //   174: getfield 26	com/tencent/mm/plugin/wear/model/e/p$a:igH	I
    //   177: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   180: aastore
    //   181: dup
    //   182: iconst_2
    //   183: aload_0
    //   184: getfield 28	com/tencent/mm/plugin/wear/model/e/p$a:qSa	I
    //   187: invokestatic 89	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   190: aastore
    //   191: invokestatic 105	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   194: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	195	0	this	a
    //   7	114	1	localObject	java.lang.Object
    //   129	4	1	localIOException1	java.io.IOException
    //   151	4	1	localIOException2	java.io.IOException
    //   18	88	2	arrayOfByte	byte[]
    //   35	109	3	localDataOutputStream	java.io.DataOutputStream
    // Exception table:
    //   from	to	target	type
    //   0	19	129	java/io/IOException
    //   36	60	151	java/io/IOException
    //   64	80	151	java/io/IOException
    //   80	128	151	java/io/IOException
    //   143	148	151	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.e.p.a
 * JD-Core Version:    0.7.0.1
 */
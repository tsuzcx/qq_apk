package com.tencent.mm.pluginsdk.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.h.b;
import com.tencent.mm.pluginsdk.h.b.a;
import com.tencent.mm.protocal.protobuf.eat;
import com.tencent.mm.protocal.protobuf.eau;

public final class f
{
  int Jmi = 3;
  boolean Uz = false;
  public String XPg;
  public eau XPh = null;
  e XPi = null;
  private b XPj = null;
  h XPk;
  public int retryCount;
  public int taskId;
  
  /* Error */
  public final void iGR()
  {
    // Byte code:
    //   0: ldc 43
    //   2: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 32	com/tencent/mm/pluginsdk/g/f:Uz	Z
    //   9: ifeq +34 -> 43
    //   12: ldc 51
    //   14: ldc 53
    //   16: iconst_2
    //   17: anewarray 4	java/lang/Object
    //   20: dup
    //   21: iconst_0
    //   22: aload_0
    //   23: getfield 30	com/tencent/mm/pluginsdk/g/f:XPi	Lcom/tencent/mm/pluginsdk/g/e;
    //   26: aastore
    //   27: dup
    //   28: iconst_1
    //   29: aload_0
    //   30: getfield 55	com/tencent/mm/pluginsdk/g/f:XPg	Ljava/lang/String;
    //   33: aastore
    //   34: invokestatic 61	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   37: ldc 43
    //   39: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   42: return
    //   43: aload_0
    //   44: iconst_1
    //   45: putfield 32	com/tencent/mm/pluginsdk/g/f:Uz	Z
    //   48: aconst_null
    //   49: astore_1
    //   50: new 66	com/tencent/mm/vfs/x
    //   53: dup
    //   54: new 68	com/tencent/mm/vfs/u
    //   57: dup
    //   58: aload_0
    //   59: getfield 30	com/tencent/mm/pluginsdk/g/f:XPi	Lcom/tencent/mm/pluginsdk/g/e;
    //   62: getfield 73	com/tencent/mm/pluginsdk/g/e:filePath	Ljava/lang/String;
    //   65: invokespecial 76	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
    //   68: invokespecial 79	com/tencent/mm/vfs/x:<init>	(Lcom/tencent/mm/vfs/u;)V
    //   71: astore_2
    //   72: aload_0
    //   73: getfield 30	com/tencent/mm/pluginsdk/g/f:XPi	Lcom/tencent/mm/pluginsdk/g/e;
    //   76: getfield 82	com/tencent/mm/pluginsdk/g/e:XOB	I
    //   79: newarray byte
    //   81: astore_1
    //   82: aload_2
    //   83: aload_0
    //   84: getfield 30	com/tencent/mm/pluginsdk/g/f:XPi	Lcom/tencent/mm/pluginsdk/g/e;
    //   87: getfield 85	com/tencent/mm/pluginsdk/g/e:XPf	I
    //   90: i2l
    //   91: invokevirtual 89	com/tencent/mm/vfs/x:skip	(J)J
    //   94: pop2
    //   95: iconst_m1
    //   96: aload_2
    //   97: aload_1
    //   98: iconst_0
    //   99: aload_0
    //   100: getfield 30	com/tencent/mm/pluginsdk/g/f:XPi	Lcom/tencent/mm/pluginsdk/g/e;
    //   103: getfield 82	com/tencent/mm/pluginsdk/g/e:XOB	I
    //   106: invokevirtual 93	com/tencent/mm/vfs/x:read	([BII)I
    //   109: if_icmpne +34 -> 143
    //   112: ldc 51
    //   114: ldc 95
    //   116: invokestatic 99	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   119: aload_2
    //   120: invokevirtual 102	com/tencent/mm/vfs/x:close	()V
    //   123: ldc 43
    //   125: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   128: return
    //   129: astore_1
    //   130: ldc 51
    //   132: ldc 104
    //   134: invokestatic 99	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   137: ldc 43
    //   139: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   142: return
    //   143: aload_0
    //   144: new 106	com/tencent/mm/pluginsdk/h/b
    //   147: dup
    //   148: aload_0
    //   149: getfield 55	com/tencent/mm/pluginsdk/g/f:XPg	Ljava/lang/String;
    //   152: aload_0
    //   153: getfield 28	com/tencent/mm/pluginsdk/g/f:XPh	Lcom/tencent/mm/protocal/protobuf/eau;
    //   156: aload_0
    //   157: getfield 30	com/tencent/mm/pluginsdk/g/f:XPi	Lcom/tencent/mm/pluginsdk/g/e;
    //   160: getfield 109	com/tencent/mm/pluginsdk/g/e:XPe	I
    //   163: aload_1
    //   164: new 6	com/tencent/mm/pluginsdk/g/f$1
    //   167: dup
    //   168: aload_0
    //   169: aload_0
    //   170: invokespecial 112	com/tencent/mm/pluginsdk/g/f$1:<init>	(Lcom/tencent/mm/pluginsdk/g/f;Lcom/tencent/mm/pluginsdk/g/f;)V
    //   173: invokespecial 115	com/tencent/mm/pluginsdk/h/b:<init>	(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/eau;I[BLcom/tencent/mm/pluginsdk/h/b$a;)V
    //   176: putfield 36	com/tencent/mm/pluginsdk/g/f:XPj	Lcom/tencent/mm/pluginsdk/h/b;
    //   179: invokestatic 121	com/tencent/mm/kernel/h:aZW	()Lcom/tencent/mm/am/s;
    //   182: aload_0
    //   183: getfield 36	com/tencent/mm/pluginsdk/g/f:XPj	Lcom/tencent/mm/pluginsdk/h/b;
    //   186: iconst_0
    //   187: invokevirtual 127	com/tencent/mm/am/s:a	(Lcom/tencent/mm/am/p;I)Z
    //   190: pop
    //   191: aload_2
    //   192: invokevirtual 102	com/tencent/mm/vfs/x:close	()V
    //   195: ldc 43
    //   197: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   200: return
    //   201: astore_1
    //   202: ldc 51
    //   204: ldc 104
    //   206: invokestatic 99	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   209: ldc 43
    //   211: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   214: return
    //   215: astore_2
    //   216: ldc 51
    //   218: new 129	java/lang/StringBuilder
    //   221: dup
    //   222: ldc 131
    //   224: invokespecial 132	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   227: aload_2
    //   228: invokevirtual 136	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   231: invokevirtual 140	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: invokevirtual 143	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   237: invokestatic 99	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   240: aload_1
    //   241: ifnull +7 -> 248
    //   244: aload_1
    //   245: invokevirtual 102	com/tencent/mm/vfs/x:close	()V
    //   248: ldc 43
    //   250: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   253: return
    //   254: astore_1
    //   255: ldc 51
    //   257: ldc 104
    //   259: invokestatic 99	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   262: ldc 43
    //   264: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   267: return
    //   268: astore_1
    //   269: aconst_null
    //   270: astore_2
    //   271: aload_2
    //   272: ifnull +7 -> 279
    //   275: aload_2
    //   276: invokevirtual 102	com/tencent/mm/vfs/x:close	()V
    //   279: ldc 43
    //   281: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   284: aload_1
    //   285: athrow
    //   286: astore_2
    //   287: ldc 51
    //   289: ldc 104
    //   291: invokestatic 99	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   294: goto -15 -> 279
    //   297: astore_1
    //   298: goto -27 -> 271
    //   301: astore_3
    //   302: aload_1
    //   303: astore_2
    //   304: aload_3
    //   305: astore_1
    //   306: goto -35 -> 271
    //   309: astore_3
    //   310: aload_2
    //   311: astore_1
    //   312: aload_3
    //   313: astore_2
    //   314: goto -98 -> 216
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	317	0	this	f
    //   49	49	1	arrayOfByte	byte[]
    //   129	35	1	localIOException1	java.io.IOException
    //   201	44	1	localIOException2	java.io.IOException
    //   254	1	1	localIOException3	java.io.IOException
    //   268	17	1	localObject1	Object
    //   297	6	1	localObject2	Object
    //   305	7	1	localObject3	Object
    //   71	121	2	localx	com.tencent.mm.vfs.x
    //   215	13	2	localException1	java.lang.Exception
    //   270	6	2	localObject4	Object
    //   286	1	2	localIOException4	java.io.IOException
    //   303	11	2	localObject5	Object
    //   301	4	3	localObject6	Object
    //   309	4	3	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   119	123	129	java/io/IOException
    //   191	195	201	java/io/IOException
    //   50	72	215	java/lang/Exception
    //   244	248	254	java/io/IOException
    //   50	72	268	finally
    //   275	279	286	java/io/IOException
    //   72	119	297	finally
    //   143	191	297	finally
    //   216	240	301	finally
    //   72	119	309	java/lang/Exception
    //   143	191	309	java/lang/Exception
  }
  
  public final void iGS()
  {
    this.Uz = false;
    this.XPj = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.g.f
 * JD-Core Version:    0.7.0.1
 */
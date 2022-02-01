package com.tencent.mm.pluginsdk.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.g.b;
import com.tencent.mm.pluginsdk.g.b.a;
import com.tencent.mm.protocal.protobuf.ciq;
import com.tencent.mm.protocal.protobuf.cir;

public final class f
{
  public String Fdj;
  public cir Fdk = null;
  e Fdl = null;
  private b Fdm = null;
  h Fdn;
  boolean isRunning = false;
  public int retryCount;
  public int taskId;
  int uQm = 3;
  
  /* Error */
  public final void fcX()
  {
    // Byte code:
    //   0: ldc 43
    //   2: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 32	com/tencent/mm/pluginsdk/f/f:isRunning	Z
    //   9: ifeq +34 -> 43
    //   12: ldc 51
    //   14: ldc 53
    //   16: iconst_2
    //   17: anewarray 4	java/lang/Object
    //   20: dup
    //   21: iconst_0
    //   22: aload_0
    //   23: getfield 30	com/tencent/mm/pluginsdk/f/f:Fdl	Lcom/tencent/mm/pluginsdk/f/e;
    //   26: aastore
    //   27: dup
    //   28: iconst_1
    //   29: aload_0
    //   30: getfield 55	com/tencent/mm/pluginsdk/f/f:Fdj	Ljava/lang/String;
    //   33: aastore
    //   34: invokestatic 61	com/tencent/mm/sdk/platformtools/ae:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   37: ldc 43
    //   39: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   42: return
    //   43: aload_0
    //   44: iconst_1
    //   45: putfield 32	com/tencent/mm/pluginsdk/f/f:isRunning	Z
    //   48: aconst_null
    //   49: astore_1
    //   50: new 66	com/tencent/mm/vfs/n
    //   53: dup
    //   54: new 68	com/tencent/mm/vfs/k
    //   57: dup
    //   58: aload_0
    //   59: getfield 30	com/tencent/mm/pluginsdk/f/f:Fdl	Lcom/tencent/mm/pluginsdk/f/e;
    //   62: getfield 73	com/tencent/mm/pluginsdk/f/e:filePath	Ljava/lang/String;
    //   65: invokespecial 76	com/tencent/mm/vfs/k:<init>	(Ljava/lang/String;)V
    //   68: invokespecial 79	com/tencent/mm/vfs/n:<init>	(Lcom/tencent/mm/vfs/k;)V
    //   71: astore_2
    //   72: aload_0
    //   73: getfield 30	com/tencent/mm/pluginsdk/f/f:Fdl	Lcom/tencent/mm/pluginsdk/f/e;
    //   76: getfield 82	com/tencent/mm/pluginsdk/f/e:FcG	I
    //   79: newarray byte
    //   81: astore_1
    //   82: aload_2
    //   83: aload_0
    //   84: getfield 30	com/tencent/mm/pluginsdk/f/f:Fdl	Lcom/tencent/mm/pluginsdk/f/e;
    //   87: getfield 85	com/tencent/mm/pluginsdk/f/e:Fdi	I
    //   90: i2l
    //   91: invokevirtual 89	com/tencent/mm/vfs/n:skip	(J)J
    //   94: pop2
    //   95: iconst_m1
    //   96: aload_2
    //   97: aload_1
    //   98: iconst_0
    //   99: aload_0
    //   100: getfield 30	com/tencent/mm/pluginsdk/f/f:Fdl	Lcom/tencent/mm/pluginsdk/f/e;
    //   103: getfield 82	com/tencent/mm/pluginsdk/f/e:FcG	I
    //   106: invokevirtual 93	com/tencent/mm/vfs/n:read	([BII)I
    //   109: if_icmpne +34 -> 143
    //   112: ldc 51
    //   114: ldc 95
    //   116: invokestatic 99	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   119: aload_2
    //   120: invokevirtual 102	com/tencent/mm/vfs/n:close	()V
    //   123: ldc 43
    //   125: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   128: return
    //   129: astore_1
    //   130: ldc 51
    //   132: ldc 104
    //   134: invokestatic 99	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   137: ldc 43
    //   139: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   142: return
    //   143: aload_0
    //   144: new 106	com/tencent/mm/pluginsdk/g/b
    //   147: dup
    //   148: aload_0
    //   149: getfield 55	com/tencent/mm/pluginsdk/f/f:Fdj	Ljava/lang/String;
    //   152: aload_0
    //   153: getfield 28	com/tencent/mm/pluginsdk/f/f:Fdk	Lcom/tencent/mm/protocal/protobuf/cir;
    //   156: aload_0
    //   157: getfield 30	com/tencent/mm/pluginsdk/f/f:Fdl	Lcom/tencent/mm/pluginsdk/f/e;
    //   160: getfield 109	com/tencent/mm/pluginsdk/f/e:Fdh	I
    //   163: aload_1
    //   164: new 6	com/tencent/mm/pluginsdk/f/f$1
    //   167: dup
    //   168: aload_0
    //   169: aload_0
    //   170: invokespecial 112	com/tencent/mm/pluginsdk/f/f$1:<init>	(Lcom/tencent/mm/pluginsdk/f/f;Lcom/tencent/mm/pluginsdk/f/f;)V
    //   173: invokespecial 115	com/tencent/mm/pluginsdk/g/b:<init>	(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/cir;I[BLcom/tencent/mm/pluginsdk/g/b$a;)V
    //   176: putfield 36	com/tencent/mm/pluginsdk/f/f:Fdm	Lcom/tencent/mm/pluginsdk/g/b;
    //   179: invokestatic 121	com/tencent/mm/kernel/g:ajj	()Lcom/tencent/mm/ak/q;
    //   182: aload_0
    //   183: getfield 36	com/tencent/mm/pluginsdk/f/f:Fdm	Lcom/tencent/mm/pluginsdk/g/b;
    //   186: iconst_0
    //   187: invokevirtual 127	com/tencent/mm/ak/q:a	(Lcom/tencent/mm/ak/n;I)Z
    //   190: pop
    //   191: aload_2
    //   192: invokevirtual 102	com/tencent/mm/vfs/n:close	()V
    //   195: ldc 43
    //   197: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   200: return
    //   201: astore_1
    //   202: ldc 51
    //   204: ldc 104
    //   206: invokestatic 99	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   237: invokestatic 99	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   240: aload_1
    //   241: invokevirtual 102	com/tencent/mm/vfs/n:close	()V
    //   244: ldc 43
    //   246: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   249: return
    //   250: astore_1
    //   251: ldc 51
    //   253: ldc 104
    //   255: invokestatic 99	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   258: ldc 43
    //   260: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   263: return
    //   264: astore_1
    //   265: aconst_null
    //   266: astore_2
    //   267: aload_2
    //   268: invokevirtual 102	com/tencent/mm/vfs/n:close	()V
    //   271: ldc 43
    //   273: invokestatic 64	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   276: aload_1
    //   277: athrow
    //   278: astore_2
    //   279: ldc 51
    //   281: ldc 104
    //   283: invokestatic 99	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   286: goto -15 -> 271
    //   289: astore_1
    //   290: goto -23 -> 267
    //   293: astore_3
    //   294: aload_1
    //   295: astore_2
    //   296: aload_3
    //   297: astore_1
    //   298: goto -31 -> 267
    //   301: astore_3
    //   302: aload_2
    //   303: astore_1
    //   304: aload_3
    //   305: astore_2
    //   306: goto -90 -> 216
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	309	0	this	f
    //   49	49	1	arrayOfByte	byte[]
    //   129	35	1	localIOException1	java.io.IOException
    //   201	40	1	localIOException2	java.io.IOException
    //   250	1	1	localIOException3	java.io.IOException
    //   264	13	1	localObject1	Object
    //   289	6	1	localObject2	Object
    //   297	7	1	localObject3	Object
    //   71	121	2	localn	com.tencent.mm.vfs.n
    //   215	13	2	localException1	java.lang.Exception
    //   266	2	2	localObject4	Object
    //   278	1	2	localIOException4	java.io.IOException
    //   295	11	2	localObject5	Object
    //   293	4	3	localObject6	Object
    //   301	4	3	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   119	123	129	java/io/IOException
    //   191	195	201	java/io/IOException
    //   50	72	215	java/lang/Exception
    //   240	244	250	java/io/IOException
    //   50	72	264	finally
    //   267	271	278	java/io/IOException
    //   72	119	289	finally
    //   143	191	289	finally
    //   216	240	293	finally
    //   72	119	301	java/lang/Exception
    //   143	191	301	java/lang/Exception
  }
  
  public final void fcY()
  {
    this.isRunning = false;
    this.Fdm = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.f.f
 * JD-Core Version:    0.7.0.1
 */
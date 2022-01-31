package com.tencent.mrs.a;

import com.tencent.matrix.mrs.core.MatrixReport;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.c.aar;
import com.tencent.mm.protocal.c.aas;
import com.tencent.mm.protocal.c.ag;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class b
  extends m
  implements k
{
  private static boolean isRunning = false;
  private static Object lock = new Object();
  private com.tencent.mm.ah.b dmK;
  private f dmL;
  private aar nEZ = null;
  
  public b(byte[] paramArrayOfByte)
  {
    iv(true);
    ag localag = new ag();
    this.nEZ = new aar();
    try
    {
      localag.aH(paramArrayOfByte);
      this.nEZ.taq = localag;
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      y.e("Matrix.NetSceneGetMrsStrategy", "parse data error");
      g.DQ();
      g.DS().O(new Runnable()
      {
        public final void run()
        {
          MatrixReport.with().onStrategyResp(3, -1, null);
        }
      });
    }
  }
  
  public static boolean isRunning()
  {
    synchronized (lock)
    {
      boolean bool = isRunning;
      return bool;
    }
  }
  
  private static void iv(boolean paramBoolean)
  {
    synchronized (lock)
    {
      isRunning = paramBoolean;
      return;
    }
  }
  
  public final int a(e parame, f paramf)
  {
    int j = -1;
    this.dmL = paramf;
    int i;
    if (!bk.bE(g.DO().Dj()))
    {
      i = 1;
      if (i != 0) {
        break label43;
      }
      y.w("Matrix.NetSceneGetMrsStrategy", "get mrs strategy must go after login");
      i = j;
    }
    label43:
    do
    {
      return i;
      i = 0;
      break;
      paramf = new b.a();
      paramf.ecL = false;
      paramf.ecH = this.nEZ;
      paramf.ecI = new aas();
      paramf.uri = "/cgi-bin/micromsg-bin/getapmstrategy";
      paramf.ecG = 914;
      this.dmK = paramf.Kt();
      j = a(parame, this.dmK, this);
      i = j;
    } while (j >= 0);
    y.i("Matrix.NetSceneGetMrsStrategy", "mark all failed. do scene %d", new Object[] { Integer.valueOf(j) });
    try
    {
      MatrixReport.with().onStrategyResp(3, -1, null);
      iv(false);
      return j;
    }
    catch (Exception parame)
    {
      y.e("Matrix.NetSceneGetMrsStrategy", "onStrategyResp failed  hash:%d  , ex:%s", new Object[] { Integer.valueOf(hashCode()), bk.j(parame) });
    }
    return j;
  }
  
  /* Error */
  public final void a(int paramInt1, int paramInt2, int paramInt3, java.lang.String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: invokestatic 92	com/tencent/mm/kernel/g:DO	()Lcom/tencent/mm/kernel/b;
    //   3: getfield 183	com/tencent/mm/kernel/b:dJT	Lcom/tencent/mm/ah/p;
    //   6: ifnull +15 -> 21
    //   9: invokestatic 92	com/tencent/mm/kernel/g:DO	()Lcom/tencent/mm/kernel/b;
    //   12: getfield 183	com/tencent/mm/kernel/b:dJT	Lcom/tencent/mm/ah/p;
    //   15: getfield 189	com/tencent/mm/ah/p:edx	Lcom/tencent/mm/network/e;
    //   18: ifnonnull +29 -> 47
    //   21: ldc 56
    //   23: ldc 191
    //   25: invokestatic 194	com/tencent/mm/sdk/platformtools/y:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   28: aload_0
    //   29: getfield 88	com/tencent/mrs/a/b:dmL	Lcom/tencent/mm/ah/f;
    //   32: iload_2
    //   33: iload_3
    //   34: aload 4
    //   36: aload_0
    //   37: invokeinterface 200 5 0
    //   42: iconst_0
    //   43: invokestatic 40	com/tencent/mrs/a/b:iv	(Z)V
    //   46: return
    //   47: iload_2
    //   48: ifeq +61 -> 109
    //   51: ldc 56
    //   53: new 202	java/lang/StringBuilder
    //   56: dup
    //   57: ldc 204
    //   59: invokespecial 207	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   62: iload_2
    //   63: invokevirtual 211	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   66: ldc 213
    //   68: invokevirtual 216	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: iload_3
    //   72: invokevirtual 211	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   75: invokevirtual 220	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: invokestatic 64	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   81: invokestatic 162	com/tencent/matrix/mrs/core/MatrixReport:with	()Lcom/tencent/matrix/mrs/core/MatrixReport;
    //   84: iload_2
    //   85: iload_3
    //   86: aconst_null
    //   87: invokevirtual 166	com/tencent/matrix/mrs/core/MatrixReport:onStrategyResp	(II[B)V
    //   90: aload_0
    //   91: getfield 88	com/tencent/mrs/a/b:dmL	Lcom/tencent/mm/ah/f;
    //   94: iload_2
    //   95: iload_3
    //   96: aload 4
    //   98: aload_0
    //   99: invokeinterface 200 5 0
    //   104: iconst_0
    //   105: invokestatic 40	com/tencent/mrs/a/b:iv	(Z)V
    //   108: return
    //   109: ldc 56
    //   111: ldc 222
    //   113: invokestatic 225	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   116: aload_0
    //   117: getfield 141	com/tencent/mrs/a/b:dmK	Lcom/tencent/mm/ah/b;
    //   120: getfield 231	com/tencent/mm/ah/b:ecF	Lcom/tencent/mm/ah/b$c;
    //   123: getfield 236	com/tencent/mm/ah/b$c:ecN	Lcom/tencent/mm/bv/a;
    //   126: checkcast 121	com/tencent/mm/protocal/c/aas
    //   129: astore 5
    //   131: invokestatic 162	com/tencent/matrix/mrs/core/MatrixReport:with	()Lcom/tencent/matrix/mrs/core/MatrixReport;
    //   134: iconst_0
    //   135: iconst_0
    //   136: aload 5
    //   138: getfield 240	com/tencent/mm/protocal/c/aas:tar	Lcom/tencent/mm/protocal/c/ah;
    //   141: invokevirtual 245	com/tencent/mm/protocal/c/ah:toByteArray	()[B
    //   144: invokevirtual 166	com/tencent/matrix/mrs/core/MatrixReport:onStrategyResp	(II[B)V
    //   147: aload_0
    //   148: getfield 88	com/tencent/mrs/a/b:dmL	Lcom/tencent/mm/ah/f;
    //   151: iload_2
    //   152: iload_3
    //   153: aload 4
    //   155: aload_0
    //   156: invokeinterface 200 5 0
    //   161: iconst_0
    //   162: invokestatic 40	com/tencent/mrs/a/b:iv	(Z)V
    //   165: return
    //   166: astore 5
    //   168: ldc 56
    //   170: ldc 247
    //   172: iconst_2
    //   173: anewarray 24	java/lang/Object
    //   176: dup
    //   177: iconst_0
    //   178: aload_0
    //   179: invokevirtual 172	java/lang/Object:hashCode	()I
    //   182: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   185: aastore
    //   186: dup
    //   187: iconst_1
    //   188: aload 5
    //   190: invokestatic 176	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   193: aastore
    //   194: invokestatic 178	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   197: goto -50 -> 147
    //   200: astore 4
    //   202: iconst_0
    //   203: invokestatic 40	com/tencent/mrs/a/b:iv	(Z)V
    //   206: aload 4
    //   208: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	209	0	this	b
    //   0	209	1	paramInt1	int
    //   0	209	2	paramInt2	int
    //   0	209	3	paramInt3	int
    //   0	209	4	paramString	java.lang.String
    //   0	209	5	paramq	com.tencent.mm.network.q
    //   0	209	6	paramArrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   131	147	166	java/lang/Exception
    //   0	21	200	finally
    //   21	42	200	finally
    //   51	104	200	finally
    //   109	131	200	finally
    //   131	147	200	finally
    //   147	161	200	finally
    //   168	197	200	finally
  }
  
  public final int getType()
  {
    return 914;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mrs.a.b
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mrs.a;

import com.tencent.matrix.mrs.core.MatrixReport;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.c;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.protobuf.af;
import com.tencent.mm.protocal.protobuf.afj;
import com.tencent.mm.protocal.protobuf.afk;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;

public final class b
  extends m
  implements k
{
  private static boolean isRunning = false;
  private static Object lock = new Object();
  private f callback;
  private afj qsb = null;
  private com.tencent.mm.ai.b rr;
  
  public b(byte[] paramArrayOfByte)
  {
    setIsRunning(true);
    af localaf = new af();
    this.qsb = new afj();
    try
    {
      localaf.parseFrom(paramArrayOfByte);
      this.qsb.wYH = localaf;
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      ab.e("Matrix.NetSceneGetMrsStrategy", "parse data error");
      g.RM();
      g.RO().ac(new Runnable()
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
  
  private static void setIsRunning(boolean paramBoolean)
  {
    synchronized (lock)
    {
      isRunning = paramBoolean;
      return;
    }
  }
  
  public final int doScene(e parame, f paramf)
  {
    int j = -1;
    this.callback = paramf;
    int i;
    if ((parame != null) && (parame.adI() != null) && (parame.adI().adC()))
    {
      i = 1;
      if (i != 0) {
        break label58;
      }
      ab.w("Matrix.NetSceneGetMrsStrategy", "get mrs strategy must go after login");
      i = j;
    }
    label58:
    do
    {
      return i;
      i = 0;
      break;
      paramf = new b.a();
      paramf.fsZ = false;
      paramf.fsX = this.qsb;
      paramf.fsY = new afk();
      paramf.uri = "/cgi-bin/micromsg-bin/getapmstrategy";
      paramf.funcId = getType();
      this.rr = paramf.ado();
      j = dispatch(parame, this.rr, this);
      i = j;
    } while (j >= 0);
    ab.i("Matrix.NetSceneGetMrsStrategy", "mark all failed. do scene %d", new Object[] { Integer.valueOf(j) });
    try
    {
      MatrixReport.with().onStrategyResp(3, -1, null);
      setIsRunning(false);
      return j;
    }
    catch (Exception parame)
    {
      ab.e("Matrix.NetSceneGetMrsStrategy", "onStrategyResp failed  hash:%d  , ex:%s", new Object[] { Integer.valueOf(hashCode()), bo.l(parame) });
    }
    return j;
  }
  
  public final int getType()
  {
    return 914;
  }
  
  /* Error */
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, java.lang.String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: invokestatic 185	com/tencent/mm/kernel/g:RK	()Lcom/tencent/mm/kernel/b;
    //   3: getfield 191	com/tencent/mm/kernel/b:eHt	Lcom/tencent/mm/ai/p;
    //   6: ifnull +15 -> 21
    //   9: invokestatic 185	com/tencent/mm/kernel/g:RK	()Lcom/tencent/mm/kernel/b;
    //   12: getfield 191	com/tencent/mm/kernel/b:eHt	Lcom/tencent/mm/ai/p;
    //   15: getfield 197	com/tencent/mm/ai/p:ftA	Lcom/tencent/mm/network/e;
    //   18: ifnonnull +29 -> 47
    //   21: ldc 56
    //   23: ldc 199
    //   25: invokestatic 202	com/tencent/mm/sdk/platformtools/ab:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   28: aload_0
    //   29: getfield 88	com/tencent/mrs/a/b:callback	Lcom/tencent/mm/ai/f;
    //   32: iload_2
    //   33: iload_3
    //   34: aload 4
    //   36: aload_0
    //   37: invokeinterface 208 5 0
    //   42: iconst_0
    //   43: invokestatic 40	com/tencent/mrs/a/b:setIsRunning	(Z)V
    //   46: return
    //   47: iload_2
    //   48: ifeq +61 -> 109
    //   51: ldc 56
    //   53: new 210	java/lang/StringBuilder
    //   56: dup
    //   57: ldc 212
    //   59: invokespecial 215	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   62: iload_2
    //   63: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   66: ldc 221
    //   68: invokevirtual 224	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: iload_3
    //   72: invokevirtual 219	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   75: invokevirtual 228	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: invokestatic 64	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   81: invokestatic 162	com/tencent/matrix/mrs/core/MatrixReport:with	()Lcom/tencent/matrix/mrs/core/MatrixReport;
    //   84: iload_2
    //   85: iload_3
    //   86: aconst_null
    //   87: invokevirtual 166	com/tencent/matrix/mrs/core/MatrixReport:onStrategyResp	(II[B)V
    //   90: aload_0
    //   91: getfield 88	com/tencent/mrs/a/b:callback	Lcom/tencent/mm/ai/f;
    //   94: iload_2
    //   95: iload_3
    //   96: aload 4
    //   98: aload_0
    //   99: invokeinterface 208 5 0
    //   104: iconst_0
    //   105: invokestatic 40	com/tencent/mrs/a/b:setIsRunning	(Z)V
    //   108: return
    //   109: ldc 56
    //   111: ldc 230
    //   113: invokestatic 233	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   116: aload_0
    //   117: getfield 140	com/tencent/mrs/a/b:rr	Lcom/tencent/mm/ai/b;
    //   120: getfield 239	com/tencent/mm/ai/b:fsW	Lcom/tencent/mm/ai/b$c;
    //   123: getfield 244	com/tencent/mm/ai/b$c:fta	Lcom/tencent/mm/bv/a;
    //   126: checkcast 116	com/tencent/mm/protocal/protobuf/afk
    //   129: astore 5
    //   131: invokestatic 162	com/tencent/matrix/mrs/core/MatrixReport:with	()Lcom/tencent/matrix/mrs/core/MatrixReport;
    //   134: iconst_0
    //   135: iconst_0
    //   136: aload 5
    //   138: getfield 248	com/tencent/mm/protocal/protobuf/afk:wYI	Lcom/tencent/mm/protocal/protobuf/ag;
    //   141: invokevirtual 254	com/tencent/mm/protocal/protobuf/ag:toByteArray	()[B
    //   144: invokevirtual 166	com/tencent/matrix/mrs/core/MatrixReport:onStrategyResp	(II[B)V
    //   147: aload_0
    //   148: getfield 88	com/tencent/mrs/a/b:callback	Lcom/tencent/mm/ai/f;
    //   151: iload_2
    //   152: iload_3
    //   153: aload 4
    //   155: aload_0
    //   156: invokeinterface 208 5 0
    //   161: iconst_0
    //   162: invokestatic 40	com/tencent/mrs/a/b:setIsRunning	(Z)V
    //   165: return
    //   166: astore 5
    //   168: ldc 56
    //   170: ldc_w 256
    //   173: iconst_2
    //   174: anewarray 24	java/lang/Object
    //   177: dup
    //   178: iconst_0
    //   179: aload_0
    //   180: invokevirtual 171	java/lang/Object:hashCode	()I
    //   183: invokestatic 152	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   186: aastore
    //   187: dup
    //   188: iconst_1
    //   189: aload 5
    //   191: invokestatic 177	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   194: aastore
    //   195: invokestatic 179	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   198: goto -51 -> 147
    //   201: astore 4
    //   203: iconst_0
    //   204: invokestatic 40	com/tencent/mrs/a/b:setIsRunning	(Z)V
    //   207: aload 4
    //   209: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	210	0	this	b
    //   0	210	1	paramInt1	int
    //   0	210	2	paramInt2	int
    //   0	210	3	paramInt3	int
    //   0	210	4	paramString	java.lang.String
    //   0	210	5	paramq	com.tencent.mm.network.q
    //   0	210	6	paramArrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   131	147	166	java/lang/Exception
    //   0	21	201	finally
    //   21	42	201	finally
    //   51	104	201	finally
    //   109	131	201	finally
    //   131	147	201	finally
    //   147	161	201	finally
    //   168	198	201	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mrs.a.b
 * JD-Core Version:    0.7.0.1
 */
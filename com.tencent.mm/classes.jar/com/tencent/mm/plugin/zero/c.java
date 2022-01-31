package com.tencent.mm.plugin.zero;

import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.zero.a.f;
import com.tencent.mm.protocal.c.qv;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class c
{
  public static volatile com.tencent.mm.ck.c<f> rSq;
  private final f rSr;
  
  public c()
  {
    if (rSq != null)
    {
      this.rSr = ((f)rSq.get());
      return;
    }
    this.rSr = null;
  }
  
  public final boolean a(qv paramqv, boolean paramBoolean)
  {
    if (!g.DK())
    {
      y.e("MicroMsg.SyncDoCmdDelegate", "account storage disabled, discard all commands");
      return false;
    }
    long l = bk.UY();
    byte[] arrayOfByte = aa.a(paramqv.sOB);
    y.i("MicroMsg.SyncDoCmdDelegate", "doCmd %d cmdid:%d buf:%d thr:[%d]", new Object[] { Long.valueOf(l), Integer.valueOf(paramqv.sOA), Integer.valueOf(bk.bF(arrayOfByte)), Long.valueOf(Thread.currentThread().getId()) });
    if (bk.bE(arrayOfByte))
    {
      y.e("MicroMsg.SyncDoCmdDelegate", "docmd: no protobuf found.");
      return false;
    }
    try
    {
      if (this.rSr != null) {
        this.rSr.a(paramqv, arrayOfByte, paramBoolean);
      }
      y.i("MicroMsg.SyncDoCmdDelegate", "doCmd FIN %d cmdid:%d Time:%d", new Object[] { Long.valueOf(l), Integer.valueOf(paramqv.sOA), Long.valueOf(bk.co(l)) });
      return true;
    }
    catch (Exception paramqv)
    {
      y.printErrStackTrace("MicroMsg.SyncDoCmdDelegate", paramqv, "", new Object[0]);
    }
    return false;
  }
  
  public final void bp(Object paramObject)
  {
    if (this.rSr != null) {
      this.rSr.bp(paramObject);
    }
  }
  
  public final void bq(Object paramObject)
  {
    if (this.rSr != null) {
      this.rSr.bq(paramObject);
    }
  }
  
  public final void br(Object paramObject)
  {
    if (this.rSr != null) {
      this.rSr.br(paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.zero.c
 * JD-Core Version:    0.7.0.1
 */
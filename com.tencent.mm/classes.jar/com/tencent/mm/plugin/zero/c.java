package com.tencent.mm.plugin.zero;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.zero.a.f;
import com.tencent.mm.protocal.protobuf.zu;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class c
{
  public static volatile com.tencent.mm.cn.c<f> EIM;
  public final f EIN;
  
  public c()
  {
    AppMethodBeat.i(133022);
    if (EIM != null)
    {
      this.EIN = ((f)EIM.get());
      AppMethodBeat.o(133022);
      return;
    }
    this.EIN = null;
    AppMethodBeat.o(133022);
  }
  
  public final boolean a(zu paramzu, boolean paramBoolean)
  {
    AppMethodBeat.i(133024);
    if (!g.ajx())
    {
      ad.e("MicroMsg.SyncDoCmdDelegate", "account storage disabled, discard all commands");
      AppMethodBeat.o(133024);
      return false;
    }
    long l = bt.flT();
    byte[] arrayOfByte = z.a(paramzu.FYV);
    ad.i("MicroMsg.SyncDoCmdDelegate", "doCmd %d cmdid:%d buf:%d thr:[%d]", new Object[] { Long.valueOf(l), Integer.valueOf(paramzu.FYU), Integer.valueOf(bt.cD(arrayOfByte)), Long.valueOf(Thread.currentThread().getId()) });
    if (bt.cC(arrayOfByte))
    {
      ad.e("MicroMsg.SyncDoCmdDelegate", "docmd: no protobuf found.");
      AppMethodBeat.o(133024);
      return false;
    }
    try
    {
      if (this.EIN != null) {
        this.EIN.a(paramzu, arrayOfByte, paramBoolean);
      }
      ad.i("MicroMsg.SyncDoCmdDelegate", "doCmd FIN %d cmdid:%d Time:%d", new Object[] { Long.valueOf(l), Integer.valueOf(paramzu.FYU), Long.valueOf(bt.Df(l)) });
      AppMethodBeat.o(133024);
      return true;
    }
    catch (Exception paramzu)
    {
      ad.printErrStackTrace("MicroMsg.SyncDoCmdDelegate", paramzu, "", new Object[0]);
      AppMethodBeat.o(133024);
    }
    return false;
  }
  
  public final void dr(Object paramObject)
  {
    AppMethodBeat.i(133023);
    if (this.EIN != null) {
      this.EIN.dr(paramObject);
    }
    AppMethodBeat.o(133023);
  }
  
  public final void ds(Object paramObject)
  {
    AppMethodBeat.i(133025);
    if (this.EIN != null) {
      this.EIN.ds(paramObject);
    }
    AppMethodBeat.o(133025);
  }
  
  public final void dt(Object paramObject)
  {
    AppMethodBeat.i(133026);
    if (this.EIN != null) {
      this.EIN.dt(paramObject);
    }
    AppMethodBeat.o(133026);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.zero.c
 * JD-Core Version:    0.7.0.1
 */
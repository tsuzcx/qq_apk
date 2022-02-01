package com.tencent.mm.plugin.zero;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.zero.a.f;
import com.tencent.mm.protocal.protobuf.xd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class c
{
  public static volatile com.tencent.mm.co.c<f> BMJ;
  public final f BMK;
  
  public c()
  {
    AppMethodBeat.i(133022);
    if (BMJ != null)
    {
      this.BMK = ((f)BMJ.get());
      AppMethodBeat.o(133022);
      return;
    }
    this.BMK = null;
    AppMethodBeat.o(133022);
  }
  
  public final boolean a(xd paramxd, boolean paramBoolean)
  {
    AppMethodBeat.i(133024);
    if (!g.afw())
    {
      ad.e("MicroMsg.SyncDoCmdDelegate", "account storage disabled, discard all commands");
      AppMethodBeat.o(133024);
      return false;
    }
    long l = bt.eGO();
    byte[] arrayOfByte = z.a(paramxd.CYZ);
    ad.i("MicroMsg.SyncDoCmdDelegate", "doCmd %d cmdid:%d buf:%d thr:[%d]", new Object[] { Long.valueOf(l), Integer.valueOf(paramxd.CYY), Integer.valueOf(bt.cx(arrayOfByte)), Long.valueOf(Thread.currentThread().getId()) });
    if (bt.cw(arrayOfByte))
    {
      ad.e("MicroMsg.SyncDoCmdDelegate", "docmd: no protobuf found.");
      AppMethodBeat.o(133024);
      return false;
    }
    try
    {
      if (this.BMK != null) {
        this.BMK.a(paramxd, arrayOfByte, paramBoolean);
      }
      ad.i("MicroMsg.SyncDoCmdDelegate", "doCmd FIN %d cmdid:%d Time:%d", new Object[] { Long.valueOf(l), Integer.valueOf(paramxd.CYY), Long.valueOf(bt.vM(l)) });
      AppMethodBeat.o(133024);
      return true;
    }
    catch (Exception paramxd)
    {
      ad.printErrStackTrace("MicroMsg.SyncDoCmdDelegate", paramxd, "", new Object[0]);
      AppMethodBeat.o(133024);
    }
    return false;
  }
  
  public final void dn(Object paramObject)
  {
    AppMethodBeat.i(133023);
    if (this.BMK != null) {
      this.BMK.dn(paramObject);
    }
    AppMethodBeat.o(133023);
  }
  
  public final void jdMethod_do(Object paramObject)
  {
    AppMethodBeat.i(133025);
    if (this.BMK != null) {
      this.BMK.jdMethod_do(paramObject);
    }
    AppMethodBeat.o(133025);
  }
  
  public final void dp(Object paramObject)
  {
    AppMethodBeat.i(133026);
    if (this.BMK != null) {
      this.BMK.dp(paramObject);
    }
    AppMethodBeat.o(133026);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.zero.c
 * JD-Core Version:    0.7.0.1
 */
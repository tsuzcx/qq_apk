package com.tencent.mm.plugin.zero;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.zero.a.f;
import com.tencent.mm.protocal.protobuf.xv;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public final class c
{
  public static volatile com.tencent.mm.cn.c<f> DeT;
  public final f DeU;
  
  public c()
  {
    AppMethodBeat.i(133022);
    if (DeT != null)
    {
      this.DeU = ((f)DeT.get());
      AppMethodBeat.o(133022);
      return;
    }
    this.DeU = null;
    AppMethodBeat.o(133022);
  }
  
  public final boolean a(xv paramxv, boolean paramBoolean)
  {
    AppMethodBeat.i(133024);
    if (!g.agM())
    {
      ac.e("MicroMsg.SyncDoCmdDelegate", "account storage disabled, discard all commands");
      AppMethodBeat.o(133024);
      return false;
    }
    long l = bs.eWj();
    byte[] arrayOfByte = z.a(paramxv.ErM);
    ac.i("MicroMsg.SyncDoCmdDelegate", "doCmd %d cmdid:%d buf:%d thr:[%d]", new Object[] { Long.valueOf(l), Integer.valueOf(paramxv.ErL), Integer.valueOf(bs.cw(arrayOfByte)), Long.valueOf(Thread.currentThread().getId()) });
    if (bs.cv(arrayOfByte))
    {
      ac.e("MicroMsg.SyncDoCmdDelegate", "docmd: no protobuf found.");
      AppMethodBeat.o(133024);
      return false;
    }
    try
    {
      if (this.DeU != null) {
        this.DeU.a(paramxv, arrayOfByte, paramBoolean);
      }
      ac.i("MicroMsg.SyncDoCmdDelegate", "doCmd FIN %d cmdid:%d Time:%d", new Object[] { Long.valueOf(l), Integer.valueOf(paramxv.ErL), Long.valueOf(bs.Ap(l)) });
      AppMethodBeat.o(133024);
      return true;
    }
    catch (Exception paramxv)
    {
      ac.printErrStackTrace("MicroMsg.SyncDoCmdDelegate", paramxv, "", new Object[0]);
      AppMethodBeat.o(133024);
    }
    return false;
  }
  
  public final void jdMethod_do(Object paramObject)
  {
    AppMethodBeat.i(133023);
    if (this.DeU != null) {
      this.DeU.jdMethod_do(paramObject);
    }
    AppMethodBeat.o(133023);
  }
  
  public final void dp(Object paramObject)
  {
    AppMethodBeat.i(133025);
    if (this.DeU != null) {
      this.DeU.dp(paramObject);
    }
    AppMethodBeat.o(133025);
  }
  
  public final void dq(Object paramObject)
  {
    AppMethodBeat.i(133026);
    if (this.DeU != null) {
      this.DeU.dq(paramObject);
    }
    AppMethodBeat.o(133026);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.zero.c
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.zero;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.zero.a.f;
import com.tencent.mm.protocal.protobuf.zx;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class c
{
  public static volatile com.tencent.mm.cm.c<f> Fbk;
  public final f Fbl;
  
  public c()
  {
    AppMethodBeat.i(133022);
    if (Fbk != null)
    {
      this.Fbl = ((f)Fbk.get());
      AppMethodBeat.o(133022);
      return;
    }
    this.Fbl = null;
    AppMethodBeat.o(133022);
  }
  
  public final boolean a(zx paramzx, boolean paramBoolean)
  {
    AppMethodBeat.i(133024);
    if (!g.ajM())
    {
      ae.e("MicroMsg.SyncDoCmdDelegate", "account storage disabled, discard all commands");
      AppMethodBeat.o(133024);
      return false;
    }
    long l = bu.fpO();
    byte[] arrayOfByte = z.a(paramzx.Grv);
    ae.i("MicroMsg.SyncDoCmdDelegate", "doCmd %d cmdid:%d buf:%d thr:[%d]", new Object[] { Long.valueOf(l), Integer.valueOf(paramzx.Gru), Integer.valueOf(bu.cG(arrayOfByte)), Long.valueOf(Thread.currentThread().getId()) });
    if (bu.cF(arrayOfByte))
    {
      ae.e("MicroMsg.SyncDoCmdDelegate", "docmd: no protobuf found.");
      AppMethodBeat.o(133024);
      return false;
    }
    try
    {
      if (this.Fbl != null) {
        this.Fbl.a(paramzx, arrayOfByte, paramBoolean);
      }
      ae.i("MicroMsg.SyncDoCmdDelegate", "doCmd FIN %d cmdid:%d Time:%d", new Object[] { Long.valueOf(l), Integer.valueOf(paramzx.Gru), Long.valueOf(bu.DD(l)) });
      AppMethodBeat.o(133024);
      return true;
    }
    catch (Exception paramzx)
    {
      ae.printErrStackTrace("MicroMsg.SyncDoCmdDelegate", paramzx, "", new Object[0]);
      AppMethodBeat.o(133024);
    }
    return false;
  }
  
  public final void ds(Object paramObject)
  {
    AppMethodBeat.i(133023);
    if (this.Fbl != null) {
      this.Fbl.ds(paramObject);
    }
    AppMethodBeat.o(133023);
  }
  
  public final void dt(Object paramObject)
  {
    AppMethodBeat.i(133025);
    if (this.Fbl != null) {
      this.Fbl.dt(paramObject);
    }
    AppMethodBeat.o(133025);
  }
  
  public final void du(Object paramObject)
  {
    AppMethodBeat.i(133026);
    if (this.Fbl != null) {
      this.Fbl.du(paramObject);
    }
    AppMethodBeat.o(133026);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.zero.c
 * JD-Core Version:    0.7.0.1
 */
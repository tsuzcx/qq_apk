package com.tencent.mm.plugin.zero;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.zero.a.f;
import com.tencent.mm.protocal.protobuf.ud;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class c
{
  public static volatile com.tencent.mm.cm.c<f> vJk;
  private final f vJl;
  
  public c()
  {
    AppMethodBeat.i(58772);
    if (vJk != null)
    {
      this.vJl = ((f)vJk.get());
      AppMethodBeat.o(58772);
      return;
    }
    this.vJl = null;
    AppMethodBeat.o(58772);
  }
  
  public final boolean a(ud paramud, boolean paramBoolean)
  {
    AppMethodBeat.i(58774);
    if (!g.RG())
    {
      ab.e("MicroMsg.SyncDoCmdDelegate", "account storage disabled, discard all commands");
      AppMethodBeat.o(58774);
      return false;
    }
    long l = bo.aoy();
    byte[] arrayOfByte = aa.a(paramud.wMD);
    ab.i("MicroMsg.SyncDoCmdDelegate", "doCmd %d cmdid:%d buf:%d thr:[%d]", new Object[] { Long.valueOf(l), Integer.valueOf(paramud.wMC), Integer.valueOf(bo.cf(arrayOfByte)), Long.valueOf(Thread.currentThread().getId()) });
    if (bo.ce(arrayOfByte))
    {
      ab.e("MicroMsg.SyncDoCmdDelegate", "docmd: no protobuf found.");
      AppMethodBeat.o(58774);
      return false;
    }
    try
    {
      if (this.vJl != null) {
        this.vJl.a(paramud, arrayOfByte, paramBoolean);
      }
      ab.i("MicroMsg.SyncDoCmdDelegate", "doCmd FIN %d cmdid:%d Time:%d", new Object[] { Long.valueOf(l), Integer.valueOf(paramud.wMC), Long.valueOf(bo.hl(l)) });
      AppMethodBeat.o(58774);
      return true;
    }
    catch (Exception paramud)
    {
      ab.printErrStackTrace("MicroMsg.SyncDoCmdDelegate", paramud, "", new Object[0]);
      AppMethodBeat.o(58774);
    }
    return false;
  }
  
  public final void bT(Object paramObject)
  {
    AppMethodBeat.i(58773);
    if (this.vJl != null) {
      this.vJl.bT(paramObject);
    }
    AppMethodBeat.o(58773);
  }
  
  public final void bU(Object paramObject)
  {
    AppMethodBeat.i(58775);
    if (this.vJl != null) {
      this.vJl.bU(paramObject);
    }
    AppMethodBeat.o(58775);
  }
  
  public final void bV(Object paramObject)
  {
    AppMethodBeat.i(58776);
    if (this.vJl != null) {
      this.vJl.bV(paramObject);
    }
    AppMethodBeat.o(58776);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.zero.c
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.zero;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.zero.a.f;
import com.tencent.mm.protocal.protobuf.adw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class c
{
  public static volatile com.tencent.mm.cp.c<f> XMN;
  private final f XMO;
  
  public c()
  {
    AppMethodBeat.i(133022);
    if (XMN != null)
    {
      this.XMO = ((f)XMN.get());
      AppMethodBeat.o(133022);
      return;
    }
    this.XMO = null;
    AppMethodBeat.o(133022);
  }
  
  public final boolean a(adw paramadw, boolean paramBoolean)
  {
    AppMethodBeat.i(133024);
    if (!h.baz())
    {
      Log.e("MicroMsg.SyncDoCmdDelegate", "account storage disabled, discard all commands");
      AppMethodBeat.o(133024);
      return false;
    }
    long l = Util.nowMilliSecond();
    byte[] arrayOfByte = w.a(paramadw.Zmd);
    Log.i("MicroMsg.SyncDoCmdDelegate", "doCmd %d cmdid:%d buf:%d thr:[%d]", new Object[] { Long.valueOf(l), Integer.valueOf(paramadw.Zmc), Integer.valueOf(Util.getLength(arrayOfByte)), Long.valueOf(Thread.currentThread().getId()) });
    if (Util.isNullOrNil(arrayOfByte))
    {
      Log.e("MicroMsg.SyncDoCmdDelegate", "docmd: no protobuf found.");
      AppMethodBeat.o(133024);
      return false;
    }
    try
    {
      if (this.XMO != null) {
        this.XMO.a(paramadw, arrayOfByte, paramBoolean);
      }
      Log.i("MicroMsg.SyncDoCmdDelegate", "doCmd FIN %d cmdid:%d Time:%d", new Object[] { Long.valueOf(l), Integer.valueOf(paramadw.Zmc), Long.valueOf(Util.milliSecondsToNow(l)) });
      AppMethodBeat.o(133024);
      return true;
    }
    catch (Exception paramadw)
    {
      Log.printErrStackTrace("MicroMsg.SyncDoCmdDelegate", paramadw, "", new Object[0]);
      AppMethodBeat.o(133024);
    }
    return false;
  }
  
  public final void fT(Object paramObject)
  {
    AppMethodBeat.i(133023);
    if (this.XMO != null) {
      this.XMO.fT(paramObject);
    }
    AppMethodBeat.o(133023);
  }
  
  public final void fU(Object paramObject)
  {
    AppMethodBeat.i(133025);
    if (this.XMO != null) {
      this.XMO.fU(paramObject);
    }
    AppMethodBeat.o(133025);
  }
  
  public final void fV(Object paramObject)
  {
    AppMethodBeat.i(133026);
    if (this.XMO != null) {
      this.XMO.fV(paramObject);
    }
    AppMethodBeat.o(133026);
  }
  
  public final void fW(Object paramObject)
  {
    AppMethodBeat.i(260963);
    if (this.XMO != null) {
      this.XMO.fW(paramObject);
    }
    AppMethodBeat.o(260963);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.zero.c
 * JD-Core Version:    0.7.0.1
 */
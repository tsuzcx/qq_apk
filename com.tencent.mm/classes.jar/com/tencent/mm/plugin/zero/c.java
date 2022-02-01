package com.tencent.mm.plugin.zero;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.zero.a.f;
import com.tencent.mm.protocal.protobuf.abu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class c
{
  public static volatile com.tencent.mm.cw.c<f> QRh;
  private final f QRi;
  
  public c()
  {
    AppMethodBeat.i(133022);
    if (QRh != null)
    {
      this.QRi = ((f)QRh.get());
      AppMethodBeat.o(133022);
      return;
    }
    this.QRi = null;
    AppMethodBeat.o(133022);
  }
  
  public final boolean a(abu paramabu, boolean paramBoolean)
  {
    AppMethodBeat.i(133024);
    if (!h.aHB())
    {
      Log.e("MicroMsg.SyncDoCmdDelegate", "account storage disabled, discard all commands");
      AppMethodBeat.o(133024);
      return false;
    }
    long l = Util.nowMilliSecond();
    byte[] arrayOfByte = z.a(paramabu.SnH);
    Log.i("MicroMsg.SyncDoCmdDelegate", "doCmd %d cmdid:%d buf:%d thr:[%d]", new Object[] { Long.valueOf(l), Integer.valueOf(paramabu.SnG), Integer.valueOf(Util.getLength(arrayOfByte)), Long.valueOf(Thread.currentThread().getId()) });
    if (Util.isNullOrNil(arrayOfByte))
    {
      Log.e("MicroMsg.SyncDoCmdDelegate", "docmd: no protobuf found.");
      AppMethodBeat.o(133024);
      return false;
    }
    try
    {
      if (this.QRi != null) {
        this.QRi.a(paramabu, arrayOfByte, paramBoolean);
      }
      Log.i("MicroMsg.SyncDoCmdDelegate", "doCmd FIN %d cmdid:%d Time:%d", new Object[] { Long.valueOf(l), Integer.valueOf(paramabu.SnG), Long.valueOf(Util.milliSecondsToNow(l)) });
      AppMethodBeat.o(133024);
      return true;
    }
    catch (Exception paramabu)
    {
      Log.printErrStackTrace("MicroMsg.SyncDoCmdDelegate", paramabu, "", new Object[0]);
      AppMethodBeat.o(133024);
    }
    return false;
  }
  
  public final void dC(Object paramObject)
  {
    AppMethodBeat.i(133023);
    if (this.QRi != null) {
      this.QRi.dC(paramObject);
    }
    AppMethodBeat.o(133023);
  }
  
  public final void dD(Object paramObject)
  {
    AppMethodBeat.i(133025);
    if (this.QRi != null) {
      this.QRi.dD(paramObject);
    }
    AppMethodBeat.o(133025);
  }
  
  public final void dE(Object paramObject)
  {
    AppMethodBeat.i(133026);
    if (this.QRi != null) {
      this.QRi.dE(paramObject);
    }
    AppMethodBeat.o(133026);
  }
  
  public final void dF(Object paramObject)
  {
    AppMethodBeat.i(200900);
    if (this.QRi != null) {
      this.QRi.dF(paramObject);
    }
    AppMethodBeat.o(200900);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.zero.c
 * JD-Core Version:    0.7.0.1
 */
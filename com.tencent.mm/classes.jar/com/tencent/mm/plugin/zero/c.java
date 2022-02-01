package com.tencent.mm.plugin.zero;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.zero.a.f;
import com.tencent.mm.protocal.protobuf.abn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class c
{
  public static volatile com.tencent.mm.co.c<f> JSe;
  public final f JSf;
  
  public c()
  {
    AppMethodBeat.i(133022);
    if (JSe != null)
    {
      this.JSf = ((f)JSe.get());
      AppMethodBeat.o(133022);
      return;
    }
    this.JSf = null;
    AppMethodBeat.o(133022);
  }
  
  public final boolean a(abn paramabn, boolean paramBoolean)
  {
    AppMethodBeat.i(133024);
    if (!g.aAc())
    {
      Log.e("MicroMsg.SyncDoCmdDelegate", "account storage disabled, discard all commands");
      AppMethodBeat.o(133024);
      return false;
    }
    long l = Util.nowMilliSecond();
    byte[] arrayOfByte = z.a(paramabn.Lmt);
    Log.i("MicroMsg.SyncDoCmdDelegate", "doCmd %d cmdid:%d buf:%d thr:[%d]", new Object[] { Long.valueOf(l), Integer.valueOf(paramabn.Lms), Integer.valueOf(Util.getLength(arrayOfByte)), Long.valueOf(Thread.currentThread().getId()) });
    if (Util.isNullOrNil(arrayOfByte))
    {
      Log.e("MicroMsg.SyncDoCmdDelegate", "docmd: no protobuf found.");
      AppMethodBeat.o(133024);
      return false;
    }
    try
    {
      if (this.JSf != null) {
        this.JSf.a(paramabn, arrayOfByte, paramBoolean);
      }
      Log.i("MicroMsg.SyncDoCmdDelegate", "doCmd FIN %d cmdid:%d Time:%d", new Object[] { Long.valueOf(l), Integer.valueOf(paramabn.Lms), Long.valueOf(Util.milliSecondsToNow(l)) });
      AppMethodBeat.o(133024);
      return true;
    }
    catch (Exception paramabn)
    {
      Log.printErrStackTrace("MicroMsg.SyncDoCmdDelegate", paramabn, "", new Object[0]);
      AppMethodBeat.o(133024);
    }
    return false;
  }
  
  public final void dA(Object paramObject)
  {
    AppMethodBeat.i(133025);
    if (this.JSf != null) {
      this.JSf.dA(paramObject);
    }
    AppMethodBeat.o(133025);
  }
  
  public final void dB(Object paramObject)
  {
    AppMethodBeat.i(133026);
    if (this.JSf != null) {
      this.JSf.dB(paramObject);
    }
    AppMethodBeat.o(133026);
  }
  
  public final void dz(Object paramObject)
  {
    AppMethodBeat.i(133023);
    if (this.JSf != null) {
      this.JSf.dz(paramObject);
    }
    AppMethodBeat.o(133023);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.zero.c
 * JD-Core Version:    0.7.0.1
 */
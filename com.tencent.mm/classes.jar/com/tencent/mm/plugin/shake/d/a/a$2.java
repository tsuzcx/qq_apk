package com.tencent.mm.plugin.shake.d.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bvk;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class a$2
  implements Runnable
{
  a$2(a parama, boolean paramBoolean) {}
  
  public final void run()
  {
    AppMethodBeat.i(24590);
    if (this.qOP)
    {
      a.a(this.qOO, null, -1L, this.qOQ);
      AppMethodBeat.o(24590);
      return;
    }
    if (!this.qOO.qOD)
    {
      ab.w("MicroMsg.MusicFingerPrintRecorder", "tryCallBack netscen not return.");
      AppMethodBeat.o(24590);
      return;
    }
    if (this.qOO.ciR != null)
    {
      ab.w("MicroMsg.MusicFingerPrintRecorder", "tryCallBack device not ready!");
      AppMethodBeat.o(24590);
      return;
    }
    if (this.qOO.qOE != null)
    {
      a locala = this.qOO;
      bvk localbvk = this.qOO.qOE.clR();
      e locale = this.qOO.qOE;
      long l2 = bo.aoy();
      long l1 = l2;
      if (locale.qOU > 0L)
      {
        l1 = l2;
        if (locale.qOU < l2) {
          l1 = locale.qOU;
        }
      }
      a.a(locala, localbvk, l1, this.qOQ);
      AppMethodBeat.o(24590);
      return;
    }
    a.a(this.qOO, null, -1L, this.qOQ);
    AppMethodBeat.o(24590);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.d.a.a.2
 * JD-Core Version:    0.7.0.1
 */
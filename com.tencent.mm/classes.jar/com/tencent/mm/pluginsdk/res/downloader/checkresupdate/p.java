package com.tencent.mm.pluginsdk.res.downloader.checkresupdate;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;

final class p
{
  static void cZW()
  {
    AppMethodBeat.i(152007);
    m localm = new m();
    h.baD().mCm.a(localm, 0);
    iJz();
    AppMethodBeat.o(152007);
  }
  
  private static void iJz()
  {
    AppMethodBeat.i(152006);
    if (!h.baC().aZN())
    {
      AppMethodBeat.o(152006);
      return;
    }
    long l = Util.nowSecond();
    h.baE().ban().set(at.a.acLo, Long.valueOf(l + 86400L));
    AppMethodBeat.o(152006);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.res.downloader.checkresupdate.p
 * JD-Core Version:    0.7.0.1
 */
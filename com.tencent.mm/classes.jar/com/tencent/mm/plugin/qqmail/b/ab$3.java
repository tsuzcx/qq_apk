package com.tencent.mm.plugin.qqmail.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

final class ab$3
  implements ab.c
{
  ab$3(ab paramab) {}
  
  public final void cdN()
  {
    AppMethodBeat.i(68039);
    com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.ShareModeMailAppService", "uploadMsgImg, finshed upload all msg img");
    this.pKx.BX(90);
    ab localab = this.pKx;
    if ((localab.pKp != null) && (localab.pKp.size() > 0)) {
      localab.pKp.clear();
    }
    this.pKx.cdM();
    AppMethodBeat.o(68039);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.ab.3
 * JD-Core Version:    0.7.0.1
 */
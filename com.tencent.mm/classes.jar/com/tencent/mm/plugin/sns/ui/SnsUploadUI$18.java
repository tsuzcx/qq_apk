package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.kp;
import com.tencent.mm.g.a.kp.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

final class SnsUploadUI$18
  extends IListener<kp>
{
  SnsUploadUI$18(SnsUploadUI paramSnsUploadUI)
  {
    AppMethodBeat.i(203776);
    this.__eventId = kp.class.getName().hashCode();
    AppMethodBeat.o(203776);
  }
  
  private boolean a(kp paramkp)
  {
    AppMethodBeat.i(203777);
    if ((paramkp != null) && (Util.isEqual(paramkp.dPH.dPI, this.EPZ.hashCode()))) {
      g.aAh().azQ().set(ar.a.Onx, paramkp.dPH.dPJ);
    }
    AppMethodBeat.o(203777);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadUI.18
 * JD-Core Version:    0.7.0.1
 */
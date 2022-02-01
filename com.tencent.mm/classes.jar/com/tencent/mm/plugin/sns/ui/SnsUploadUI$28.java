package com.tencent.mm.plugin.sns.ui;

import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.mm;
import com.tencent.mm.autogen.a.mm.a;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;

class SnsUploadUI$28
  extends IListener<mm>
{
  SnsUploadUI$28(SnsUploadUI paramSnsUploadUI, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(369926);
    this.__eventId = mm.class.getName().hashCode();
    AppMethodBeat.o(369926);
  }
  
  private boolean a(mm parammm)
  {
    AppMethodBeat.i(369927);
    if ((parammm != null) && (Util.isEqual(parammm.hOF.hOG, this.REd.hashCode()))) {
      h.baE().ban().set(at.a.adfE, parammm.hOF.hOH);
    }
    AppMethodBeat.o(369927);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadUI.28
 * JD-Core Version:    0.7.0.1
 */
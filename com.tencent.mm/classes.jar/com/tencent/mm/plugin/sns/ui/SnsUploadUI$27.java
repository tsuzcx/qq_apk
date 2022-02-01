package com.tencent.mm.plugin.sns.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.lg;
import com.tencent.mm.f.a.lg.a;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

final class SnsUploadUI$27
  extends IListener<lg>
{
  SnsUploadUI$27(SnsUploadUI paramSnsUploadUI)
  {
    AppMethodBeat.i(293247);
    this.__eventId = lg.class.getName().hashCode();
    AppMethodBeat.o(293247);
  }
  
  private boolean a(lg paramlg)
  {
    AppMethodBeat.i(293248);
    if ((paramlg != null) && (Util.isEqual(paramlg.fIX.fIY, this.LdU.hashCode()))) {
      h.aHG().aHp().set(ar.a.VCK, paramlg.fIX.fIZ);
    }
    AppMethodBeat.o(293248);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsUploadUI.27
 * JD-Core Version:    0.7.0.1
 */
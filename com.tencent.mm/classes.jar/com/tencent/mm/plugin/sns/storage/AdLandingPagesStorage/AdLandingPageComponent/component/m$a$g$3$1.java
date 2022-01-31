package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelstat.d;

final class m$a$g$3$1
  implements DialogInterface.OnClickListener
{
  m$a$g$3$1(m.a.g.3 param3) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(37131);
    m.a(this.rwb.rwa.rvU.rvI).sendMessage(12);
    d.b(10, "AdLandingPageDownloadApkBtnComp_TODOWLOAD_MSG_BTN_CLICK", this.rwb.rwa.hashCode());
    AppMethodBeat.o(37131);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m.a.g.3.1
 * JD-Core Version:    0.7.0.1
 */
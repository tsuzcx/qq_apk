package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import java.util.List;

final class AppAttachNewDownloadUI$15
  implements q.f
{
  AppAttachNewDownloadUI$15(AppAttachNewDownloadUI paramAppAttachNewDownloadUI, List paramList1, List paramList2) {}
  
  public final void onCreateMMMenu(o paramo)
  {
    AppMethodBeat.i(284917);
    if (!Util.isNullOrNil(this.cWz)) {
      paramo.setHeaderTitle(this.cWz);
    }
    int i = 0;
    while (i < this.KEx.size())
    {
      paramo.d(((Integer)this.KDR.get(i)).intValue(), (CharSequence)this.KEx.get(i));
      i += 1;
    }
    if (!Util.isNullOrNil(this.Wiv)) {
      paramo.d(-1, this.Wiv);
    }
    AppMethodBeat.o(284917);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.AppAttachNewDownloadUI.15
 * JD-Core Version:    0.7.0.1
 */
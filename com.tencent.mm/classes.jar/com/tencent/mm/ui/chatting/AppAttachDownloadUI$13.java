package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import java.util.List;

final class AppAttachDownloadUI$13
  implements o.f
{
  AppAttachDownloadUI$13(AppAttachDownloadUI paramAppAttachDownloadUI, List paramList1, List paramList2) {}
  
  public final void onCreateMMMenu(m paramm)
  {
    AppMethodBeat.i(232805);
    if (!Util.isNullOrNil(this.dqb)) {
      paramm.setHeaderTitle(this.dqb);
    }
    int i = 0;
    while (i < this.Ere.size())
    {
      paramm.d(((Integer)this.EqA.get(i)).intValue(), (CharSequence)this.Ere.get(i));
      i += 1;
    }
    if (!Util.isNullOrNil(this.OPn)) {
      paramm.d(-1, this.OPn);
    }
    AppMethodBeat.o(232805);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.AppAttachDownloadUI.13
 * JD-Core Version:    0.7.0.1
 */
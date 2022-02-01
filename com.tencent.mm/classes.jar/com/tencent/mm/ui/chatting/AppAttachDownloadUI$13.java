package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.g;
import java.util.List;

final class AppAttachDownloadUI$13
  implements u.g
{
  AppAttachDownloadUI$13(AppAttachDownloadUI paramAppAttachDownloadUI, List paramList1, List paramList2) {}
  
  public final void onCreateMMMenu(s params)
  {
    AppMethodBeat.i(253847);
    if (!Util.isNullOrNil(this.eSG)) {
      params.setHeaderTitle(this.eSG);
    }
    int i = 0;
    while (i < this.adPu.size())
    {
      params.c(((Integer)this.adPv.get(i)).intValue(), (CharSequence)this.adPu.get(i));
      i += 1;
    }
    if (!Util.isNullOrNil(this.adPw)) {
      params.c(-1, this.adPw);
    }
    AppMethodBeat.o(253847);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.AppAttachDownloadUI.13
 * JD-Core Version:    0.7.0.1
 */
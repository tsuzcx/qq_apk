package com.tencent.mm.ui.conversation;

import android.app.ProgressDialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bp.a;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.u;

final class BizConversationUI$BizConversationFmUI$8
  implements bp.a
{
  BizConversationUI$BizConversationFmUI$8(BizConversationUI.BizConversationFmUI paramBizConversationFmUI, ProgressDialog paramProgressDialog, String paramString) {}
  
  public final boolean amG()
  {
    AppMethodBeat.i(38242);
    boolean bool = BizConversationUI.BizConversationFmUI.l(this.Qbw);
    AppMethodBeat.o(38242);
    return bool;
  }
  
  public final void amH()
  {
    AppMethodBeat.i(38243);
    if (this.guD != null) {
      this.guD.dismiss();
    }
    if (Util.nullAsNil(BizConversationUI.BizConversationFmUI.m(this.Qbw)).equals("officialaccounts"))
    {
      g.af(q.class);
      u.biP(this.gMw);
    }
    AppMethodBeat.o(38243);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.BizConversationUI.BizConversationFmUI.8
 * JD-Core Version:    0.7.0.1
 */
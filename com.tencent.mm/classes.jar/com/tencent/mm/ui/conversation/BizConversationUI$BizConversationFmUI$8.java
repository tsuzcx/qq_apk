package com.tencent.mm.ui.conversation;

import android.app.ProgressDialog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ao.q;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.bq.a;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.u;

final class BizConversationUI$BizConversationFmUI$8
  implements bq.a
{
  BizConversationUI$BizConversationFmUI$8(BizConversationUI.BizConversationFmUI paramBizConversationFmUI, ProgressDialog paramProgressDialog, String paramString) {}
  
  public final boolean asH()
  {
    AppMethodBeat.i(38242);
    boolean bool = BizConversationUI.BizConversationFmUI.l(this.XzJ);
    AppMethodBeat.o(38242);
    return bool;
  }
  
  public final void asI()
  {
    AppMethodBeat.i(38243);
    if (this.iYO != null) {
      this.iYO.dismiss();
    }
    if (Util.nullAsNil(BizConversationUI.BizConversationFmUI.m(this.XzJ)).equals("officialaccounts"))
    {
      ((q)h.ae(q.class)).bbQ();
      u.bvj(this.jwL);
    }
    AppMethodBeat.o(38243);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.BizConversationUI.BizConversationFmUI.8
 * JD-Core Version:    0.7.0.1
 */
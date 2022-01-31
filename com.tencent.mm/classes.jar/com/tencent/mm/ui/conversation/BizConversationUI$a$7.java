package com.tencent.mm.ui.conversation;

import android.app.ProgressDialog;
import com.tencent.mm.ai.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.p;

final class BizConversationUI$a$7
  implements bd.a
{
  BizConversationUI$a$7(BizConversationUI.a parama, ProgressDialog paramProgressDialog, String paramString) {}
  
  public final void xA()
  {
    if (this.doh != null) {
      this.doh.dismiss();
    }
    if (bk.pm(BizConversationUI.a.m(this.vPu)).equals("officialaccounts"))
    {
      g.r(o.class);
      p.aaH(this.dAA);
    }
  }
  
  public final boolean xz()
  {
    return BizConversationUI.a.l(this.vPu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.BizConversationUI.a.7
 * JD-Core Version:    0.7.0.1
 */
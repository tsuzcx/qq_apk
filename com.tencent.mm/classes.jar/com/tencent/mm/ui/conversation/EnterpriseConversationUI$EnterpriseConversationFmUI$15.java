package com.tencent.mm.ui.conversation;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.g;
import com.tencent.mm.ui.tools.m;

final class EnterpriseConversationUI$EnterpriseConversationFmUI$15
  implements MenuItem.OnMenuItemClickListener
{
  EnterpriseConversationUI$EnterpriseConversationFmUI$15(EnterpriseConversationUI.EnterpriseConversationFmUI paramEnterpriseConversationFmUI) {}
  
  public final boolean onMenuItemClick(MenuItem paramMenuItem)
  {
    AppMethodBeat.i(34435);
    if (EnterpriseConversationUI.EnterpriseConversationFmUI.d(this.AkO) != null)
    {
      EnterpriseConversationUI.EnterpriseConversationFmUI.d(this.AkO).dismiss();
      EnterpriseConversationUI.EnterpriseConversationFmUI.a(this.AkO, null);
    }
    EnterpriseConversationUI.EnterpriseConversationFmUI.a(this.AkO, new m(this.AkO.getContext()));
    EnterpriseConversationUI.EnterpriseConversationFmUI.d(this.AkO).sao = new n.c()
    {
      public final void onCreateMMMenu(l paramAnonymousl)
      {
        AppMethodBeat.i(34433);
        if (EnterpriseConversationUI.EnterpriseConversationFmUI.e(EnterpriseConversationUI.EnterpriseConversationFmUI.15.this.AkO) == 1)
        {
          paramAnonymousl.aw(2, 2131299330, 2131230733);
          g.s(EnterpriseConversationUI.EnterpriseConversationFmUI.15.this.AkO.getContext(), EnterpriseConversationUI.EnterpriseConversationFmUI.c(EnterpriseConversationUI.EnterpriseConversationFmUI.15.this.AkO), 5);
        }
        paramAnonymousl.aw(3, 2131298744, 2131231823);
        paramAnonymousl.aw(4, 2131299311, 2131230732);
        paramAnonymousl.aw(5, 2131296408, 2131230759);
        AppMethodBeat.o(34433);
      }
    };
    EnterpriseConversationUI.EnterpriseConversationFmUI.d(this.AkO).sap = new EnterpriseConversationUI.EnterpriseConversationFmUI.15.2(this);
    EnterpriseConversationUI.EnterpriseConversationFmUI.d(this.AkO).gr();
    g.eK(EnterpriseConversationUI.EnterpriseConversationFmUI.c(this.AkO), 1);
    AppMethodBeat.o(34435);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.EnterpriseConversationUI.EnterpriseConversationFmUI.15
 * JD-Core Version:    0.7.0.1
 */
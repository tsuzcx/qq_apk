package com.tencent.mm.ui.conversation;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.storage.ak;
import com.tencent.mm.ui.tools.l;

final class EnterpriseConversationUI$EnterpriseConversationFmUI$5
  implements AdapterView.OnItemLongClickListener
{
  EnterpriseConversationUI$EnterpriseConversationFmUI$5(EnterpriseConversationUI.EnterpriseConversationFmUI paramEnterpriseConversationFmUI) {}
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(34421);
    paramAdapterView = (ak)EnterpriseConversationUI.EnterpriseConversationFmUI.f(this.AkO).getItem(paramInt);
    EnterpriseConversationUI.EnterpriseConversationFmUI.c(this.AkO, paramAdapterView.field_username);
    EnterpriseConversationUI.EnterpriseConversationFmUI.i(this.AkO).a(paramView, paramInt, paramLong, this.AkO, EnterpriseConversationUI.EnterpriseConversationFmUI.h(this.AkO));
    AppMethodBeat.o(34421);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.EnterpriseConversationUI.EnterpriseConversationFmUI.5
 * JD-Core Version:    0.7.0.1
 */
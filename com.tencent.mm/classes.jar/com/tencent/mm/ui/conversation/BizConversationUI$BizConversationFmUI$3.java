package com.tencent.mm.ui.conversation;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.storage.ak;
import com.tencent.mm.ui.widget.c.a;

final class BizConversationUI$BizConversationFmUI$3
  implements AdapterView.OnItemLongClickListener
{
  BizConversationUI$BizConversationFmUI$3(BizConversationUI.BizConversationFmUI paramBizConversationFmUI) {}
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(34118);
    BizConversationUI.BizConversationFmUI.a(this.Ahf, (ak)BizConversationUI.BizConversationFmUI.e(this.Ahf).getItem(paramInt));
    BizConversationUI.BizConversationFmUI.a(this.Ahf, BizConversationUI.BizConversationFmUI.f(this.Ahf).field_username);
    BizConversationUI.BizConversationFmUI.j(this.Ahf).a(paramView, paramInt, paramLong, this.Ahf, BizConversationUI.BizConversationFmUI.g(this.Ahf), BizConversationUI.BizConversationFmUI.h(this.Ahf), BizConversationUI.BizConversationFmUI.i(this.Ahf));
    AppMethodBeat.o(34118);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.BizConversationUI.BizConversationFmUI.3
 * JD-Core Version:    0.7.0.1
 */
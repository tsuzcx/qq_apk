package com.tencent.mm.ui.bizchat;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.c.a;

final class BizChatConversationUI$BizChatConversationFmUI$17
  implements AdapterView.OnItemLongClickListener
{
  BizChatConversationUI$BizChatConversationFmUI$17(BizChatConversationUI.BizChatConversationFmUI paramBizChatConversationFmUI, a parama) {}
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(30074);
    this.pIn.a(paramView, paramInt, paramLong, this.ztv, BizChatConversationUI.BizChatConversationFmUI.f(this.ztv), BizChatConversationUI.BizChatConversationFmUI.g(this.ztv), BizChatConversationUI.BizChatConversationFmUI.h(this.ztv));
    AppMethodBeat.o(30074);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatConversationUI.BizChatConversationFmUI.17
 * JD-Core Version:    0.7.0.1
 */
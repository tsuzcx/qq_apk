package com.tencent.mm.ui.conversation;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.storage.ak;
import com.tencent.mm.ui.widget.c.a;

final class NewBizConversationUI$3
  implements AdapterView.OnItemLongClickListener
{
  NewBizConversationUI$3(NewBizConversationUI paramNewBizConversationUI) {}
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(34534);
    NewBizConversationUI.a(this.AlC, (ak)NewBizConversationUI.e(this.AlC).getItem(paramInt));
    NewBizConversationUI.a(this.AlC, NewBizConversationUI.g(this.AlC).field_username);
    NewBizConversationUI.k(this.AlC).a(paramView, paramInt, paramLong, this.AlC, NewBizConversationUI.h(this.AlC), NewBizConversationUI.i(this.AlC), NewBizConversationUI.j(this.AlC));
    AppMethodBeat.o(34534);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.NewBizConversationUI.3
 * JD-Core Version:    0.7.0.1
 */
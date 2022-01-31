package com.tencent.mm.ui.conversation;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class ConversationListView$8
  implements AdapterView.OnItemLongClickListener
{
  ConversationListView$8(ConversationListView paramConversationListView) {}
  
  public final boolean onItemLongClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(156151);
    ab.i("MicroMsg.ConversationListView", "alvinluo onItemLongClick isCanClose: %b", new Object[] { Boolean.valueOf(ConversationListView.g(this.AiQ)) });
    if ((ConversationListView.h(this.AiQ) != null) && (!ConversationListView.g(this.AiQ)))
    {
      boolean bool = ConversationListView.h(this.AiQ).onItemLongClick(paramAdapterView, paramView, paramInt, paramLong);
      AppMethodBeat.o(156151);
      return bool;
    }
    AppMethodBeat.o(156151);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.ConversationListView.8
 * JD-Core Version:    0.7.0.1
 */
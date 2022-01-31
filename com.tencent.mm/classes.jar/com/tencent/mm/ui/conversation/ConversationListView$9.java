package com.tencent.mm.ui.conversation;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class ConversationListView$9
  implements AdapterView.OnItemClickListener
{
  ConversationListView$9(ConversationListView paramConversationListView) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(156152);
    ab.i("MicroMsg.ConversationListView", "alvinluo onItemClick isCanClose: %b", new Object[] { Boolean.valueOf(ConversationListView.g(this.AiQ)) });
    if ((ConversationListView.i(this.AiQ) != null) && (!ConversationListView.g(this.AiQ))) {
      ConversationListView.i(this.AiQ).onItemClick(paramAdapterView, paramView, paramInt, paramLong);
    }
    AppMethodBeat.o(156152);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.ConversationListView.9
 * JD-Core Version:    0.7.0.1
 */
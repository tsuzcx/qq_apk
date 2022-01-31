package com.tencent.mm.ui.conversation;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ConversationWithAppBrandListView$22
  implements AdapterView.OnItemClickListener
{
  ConversationWithAppBrandListView$22(ConversationWithAppBrandListView paramConversationWithAppBrandListView, AdapterView.OnItemClickListener paramOnItemClickListener) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(34290);
    if (this.AjO != null) {
      this.AjO.onItemClick(paramAdapterView, paramView, paramInt, paramLong);
    }
    if (!ConversationWithAppBrandListView.b(this.AjJ))
    {
      AppMethodBeat.o(34290);
      return;
    }
    if (this.AjJ.getFirstVisiblePosition() == 0) {
      this.AjJ.L(500L, 8);
    }
    AppMethodBeat.o(34290);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.ConversationWithAppBrandListView.22
 * JD-Core Version:    0.7.0.1
 */
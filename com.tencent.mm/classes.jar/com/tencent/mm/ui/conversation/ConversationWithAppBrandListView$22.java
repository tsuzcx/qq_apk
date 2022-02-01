package com.tencent.mm.ui.conversation;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class ConversationWithAppBrandListView$22
  implements AdapterView.OnItemClickListener
{
  ConversationWithAppBrandListView$22(ConversationWithAppBrandListView paramConversationWithAppBrandListView, AdapterView.OnItemClickListener paramOnItemClickListener) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(38418);
    b localb = new b();
    localb.bd(paramAdapterView);
    localb.bd(paramView);
    localb.mu(paramInt);
    localb.rl(paramLong);
    a.b("com/tencent/mm/ui/conversation/ConversationWithAppBrandListView$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
    if (this.KQZ != null) {
      this.KQZ.onItemClick(paramAdapterView, paramView, paramInt, paramLong);
    }
    if (!ConversationWithAppBrandListView.b(this.KQU))
    {
      a.a(this, "com/tencent/mm/ui/conversation/ConversationWithAppBrandListView$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      AppMethodBeat.o(38418);
      return;
    }
    if (this.KQU.getFirstVisiblePosition() == 0) {
      this.KQU.ap(500L, 8);
    }
    a.a(this, "com/tencent/mm/ui/conversation/ConversationWithAppBrandListView$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
    AppMethodBeat.o(38418);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.ConversationWithAppBrandListView.22
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.ui.conversation;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.conversation.presenter.d;

final class EnterpriseConversationUI$EnterpriseConversationFmUI$2
  implements AdapterView.OnItemClickListener
{
  EnterpriseConversationUI$EnterpriseConversationFmUI$2(EnterpriseConversationUI.EnterpriseConversationFmUI paramEnterpriseConversationFmUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(234158);
    b localb = new b();
    localb.bm(paramAdapterView);
    localb.bm(paramView);
    localb.pH(paramInt);
    localb.zo(paramLong);
    a.b("com/tencent/mm/ui/conversation/EnterpriseConversationUI$EnterpriseConversationFmUI$10", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
    paramAdapterView = EnterpriseConversationUI.EnterpriseConversationFmUI.d(this.Qfj).anT(paramInt);
    paramView = EnterpriseConversationUI.EnterpriseConversationFmUI.a(this.Qfj, paramAdapterView);
    if (paramView == null)
    {
      Log.e("MicroMsg.EnterpriseConversationUI", "user should not be null. position:%d, size:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(EnterpriseConversationUI.EnterpriseConversationFmUI.d(this.Qfj).getCount()) });
      EnterpriseConversationUI.EnterpriseConversationFmUI.d(this.Qfj).notifyDataSetChanged();
      a.a(this, "com/tencent/mm/ui/conversation/EnterpriseConversationUI$EnterpriseConversationFmUI$10", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
      AppMethodBeat.o(234158);
      return;
    }
    paramView.a(paramAdapterView);
    a.a(this, "com/tencent/mm/ui/conversation/EnterpriseConversationUI$EnterpriseConversationFmUI$10", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
    AppMethodBeat.o(234158);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.EnterpriseConversationUI.EnterpriseConversationFmUI.2
 * JD-Core Version:    0.7.0.1
 */
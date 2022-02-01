package com.tencent.mm.ui.conversation;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Util;

final class ServiceNotifyConversationUI$7
  implements View.OnClickListener
{
  ServiceNotifyConversationUI$7(ServiceNotifyConversationUI paramServiceNotifyConversationUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(256487);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/ui/conversation/ServiceNotifyConversationUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    paramView = new Intent();
    paramView.putExtra("Search_Scene", 2);
    d.d(this.afst.getContext(), ".ui.FTSServiceNotifyUI", paramView);
    h.OAn.b(23903, new Object[] { Integer.valueOf(6), Long.valueOf(Util.nowSecond()), null, Integer.valueOf(0) });
    a.a(this, "com/tencent/mm/ui/conversation/ServiceNotifyConversationUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(256487);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.ServiceNotifyConversationUI.7
 * JD-Core Version:    0.7.0.1
 */
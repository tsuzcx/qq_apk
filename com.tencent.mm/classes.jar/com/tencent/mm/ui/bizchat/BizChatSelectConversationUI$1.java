package com.tencent.mm.ui.bizchat;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class BizChatSelectConversationUI$1
  implements View.OnClickListener
{
  BizChatSelectConversationUI$1(BizChatSelectConversationUI paramBizChatSelectConversationUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(34026);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/ui/bizchat/BizChatSelectConversationUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    BizChatSelectConversationUI.a(this.PbV);
    a.a(this, "com/tencent/mm/ui/bizchat/BizChatSelectConversationUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(34026);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.bizchat.BizChatSelectConversationUI.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.ui.contact;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.SmoothScrollFactory;

final class ChatroomContactUI$4
  implements View.OnClickListener
{
  ChatroomContactUI$4(ChatroomContactUI paramChatroomContactUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(37694);
    Object localObject = new b();
    ((b)localObject).bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/contact/ChatroomContactUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
    paramView = ChatroomContactUI.d(this.PUp);
    paramView = new com.tencent.mm.hellhoundlib.b.a().bl(paramView);
    localObject = new Object();
    com.tencent.mm.hellhoundlib.a.a.a(localObject, paramView.axQ(), "com/tencent/mm/ui/contact/ChatroomContactUI$12", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
    BackwardSupportUtil.SmoothScrollFactory.scrollToTop((ListView)paramView.pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/ui/contact/ChatroomContactUI$12", "onClick", "(Landroid/view/View;)V", "com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory_EXEC_", "scrollToTop", "(Landroid/widget/ListView;)V");
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/contact/ChatroomContactUI$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(37694);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.contact.ChatroomContactUI.4
 * JD-Core Version:    0.7.0.1
 */
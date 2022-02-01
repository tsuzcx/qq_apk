package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class t$1
  implements View.OnClickListener
{
  t$1(t paramt) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(34609);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/ui/chatting/ChattingQQMailFooterHandler$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    new Intent().putExtra("composeType", 1);
    d.Q(this.JCe.mContext, "qqmail", ".ui.ComposeUI");
    a.a(this, "com/tencent/mm/ui/chatting/ChattingQQMailFooterHandler$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(34609);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.t.1
 * JD-Core Version:    0.7.0.1
 */
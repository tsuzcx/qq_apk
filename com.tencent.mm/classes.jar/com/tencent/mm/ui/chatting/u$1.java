package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class u$1
  implements View.OnClickListener
{
  u$1(u paramu) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(34609);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/ui/chatting/ChattingQQMailFooterHandler$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    new Intent().putExtra("composeType", 1);
    d.Q(this.JWV.mContext, "qqmail", ".ui.ComposeUI");
    a.a(this, "com/tencent/mm/ui/chatting/ChattingQQMailFooterHandler$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(34609);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.u.1
 * JD-Core Version:    0.7.0.1
 */
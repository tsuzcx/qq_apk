package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class w$1
  implements View.OnClickListener
{
  w$1(w paramw) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(34609);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/ui/chatting/ChattingQQMailFooterHandler$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    new Intent().putExtra("composeType", 1);
    c.ai(this.aejf.mContext, "qqmail", ".ui.ComposeUI");
    a.a(this, "com/tencent/mm/ui/chatting/ChattingQQMailFooterHandler$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(34609);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.w.1
 * JD-Core Version:    0.7.0.1
 */
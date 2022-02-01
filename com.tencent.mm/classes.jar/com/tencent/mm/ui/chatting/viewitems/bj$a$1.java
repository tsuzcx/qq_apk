package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.chatting.u;
import com.tencent.mm.ui.widget.MMNeat7extView;

final class bj$a$1
  implements View.OnClickListener
{
  bj$a$1(bj.a parama, bj.f paramf, com.tencent.mm.ui.chatting.d.a parama1) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(37383);
    b localb = new b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextFrom$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    Log.i("MicroMsg.ChattingItemTextFrom", "sourceTV click msgId:%s", new Object[] { this.aeVF.aeVM.getTag(bj.a.ddn()) });
    u.a(this.XSz, ((Long)this.aeVF.aeVM.getTag(bj.a.ddn())).longValue(), 1);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemText$ChattingItemTextFrom$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(37383);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bj.a.1
 * JD-Core Version:    0.7.0.1
 */
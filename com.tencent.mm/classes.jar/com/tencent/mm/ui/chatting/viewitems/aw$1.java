package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ae;

final class aw$1
  implements View.OnClickListener
{
  aw$1(aw paramaw) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(37380);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemSysMsgTemplate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    ae.d("MicroMsg.ChattingItemNewXmlSysImpl", "hy: textview clicked");
    a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemSysMsgTemplate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(37380);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.aw.1
 * JD-Core Version:    0.7.0.1
 */
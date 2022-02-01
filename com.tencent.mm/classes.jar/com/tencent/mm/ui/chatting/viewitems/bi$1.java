package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;

final class bi$1
  implements View.OnClickListener
{
  bi$1(bi parambi) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(37380);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemSysMsgTemplate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    Log.d("MicroMsg.ChattingItemNewXmlSysImpl", "hy: textview clicked");
    a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemSysMsgTemplate$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(37380);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bi.1
 * JD-Core Version:    0.7.0.1
 */
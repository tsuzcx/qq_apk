package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;

final class br$1
  implements View.OnClickListener
{
  br$1(br parambr) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(37549);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemWxaSubscribeSysImpl$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    Log.d("MicroMsg.ChattingItemWxaSubscribeSysImpl", "hy: textview clicked");
    a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemWxaSubscribeSysImpl$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(37549);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.br.1
 * JD-Core Version:    0.7.0.1
 */
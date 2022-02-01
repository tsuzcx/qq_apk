package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;

final class bl$1
  implements View.OnClickListener
{
  bl$1(bl parambl) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(37549);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/ui/chatting/viewitems/ChattingItemWxaSubscribeSysImpl$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    Log.d("MicroMsg.ChattingItemWxaSubscribeSysImpl", "hy: textview clicked");
    a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemWxaSubscribeSysImpl$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(37549);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bl.1
 * JD-Core Version:    0.7.0.1
 */
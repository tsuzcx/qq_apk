package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;

final class bc$2
  implements View.OnClickListener
{
  bc$2(bc parambc) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(37365);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/ui/chatting/viewitems/ChattingItemNewXmlSysImpl$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    Log.d("MicroMsg.ChattingItemNewXmlSysImpl", "clicked");
    a.a(this, "com/tencent/mm/ui/chatting/viewitems/ChattingItemNewXmlSysImpl$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(37365);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.bc.2
 * JD-Core Version:    0.7.0.1
 */
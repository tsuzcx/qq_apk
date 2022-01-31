package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class au$1
  implements View.OnClickListener
{
  au$1(au paramau) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(33439);
    ab.d("MicroMsg.ChattingItemWxaSubscribeSysImpl", "hy: textview clicked");
    AppMethodBeat.o(33439);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.au.1
 * JD-Core Version:    0.7.0.1
 */
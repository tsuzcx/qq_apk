package com.tencent.mm.pluginsdk.ui.chat;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.kvdata.VoiceInputBehavior;

final class n$7
  implements View.OnClickListener
{
  n$7(n paramn) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(27978);
    this.vZW.reset();
    paramView = new VoiceInputBehavior();
    paramView.clear = 1;
    n.c(paramView);
    this.vZW.Mo(4);
    AppMethodBeat.o(27978);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.n.7
 * JD-Core Version:    0.7.0.1
 */
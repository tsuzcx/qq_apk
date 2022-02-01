package com.tencent.mm.pluginsdk.ui.chat;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.kvdata.VoiceInputBehavior;

final class n$7
  implements View.OnClickListener
{
  n$7(n paramn) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(31773);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/pluginsdk/ui/chat/VoiceInputPanel$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    this.Fxu.reset();
    paramView = new VoiceInputBehavior();
    paramView.clear = 1;
    n.c(paramView);
    this.Fxu.ZT(4);
    a.a(this, "com/tencent/mm/pluginsdk/ui/chat/VoiceInputPanel$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(31773);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.n.7
 * JD-Core Version:    0.7.0.1
 */
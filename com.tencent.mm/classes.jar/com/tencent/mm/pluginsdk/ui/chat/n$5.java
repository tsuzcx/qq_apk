package com.tencent.mm.pluginsdk.ui.chat;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class n$5
  implements View.OnClickListener
{
  n$5(n paramn) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(31771);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/pluginsdk/ui/chat/VoiceInputPanel$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    this.Rpb.hmz();
    a.a(this, "com/tencent/mm/pluginsdk/ui/chat/VoiceInputPanel$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(31771);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.n.5
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.pluginsdk.ui.chat;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class n$6
  implements View.OnClickListener
{
  n$6(n paramn) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(31772);
    b localb = new b();
    localb.bm(paramView);
    a.b("com/tencent/mm/pluginsdk/ui/chat/VoiceInputPanel$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    n.a(this.Kop, 2);
    a.a(this, "com/tencent/mm/pluginsdk/ui/chat/VoiceInputPanel$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(31772);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.n.6
 * JD-Core Version:    0.7.0.1
 */
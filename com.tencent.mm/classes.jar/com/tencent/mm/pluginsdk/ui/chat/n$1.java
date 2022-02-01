package com.tencent.mm.pluginsdk.ui.chat;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class n$1
  implements View.OnLongClickListener
{
  n$1(n paramn) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(31761);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/pluginsdk/ui/chat/VoiceInputPanel$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahF());
    if (n.a(this.Fxu)) {
      n.b(this.Fxu);
    }
    a.a(true, this, "com/tencent/mm/pluginsdk/ui/chat/VoiceInputPanel$1", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(31761);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.n.1
 * JD-Core Version:    0.7.0.1
 */
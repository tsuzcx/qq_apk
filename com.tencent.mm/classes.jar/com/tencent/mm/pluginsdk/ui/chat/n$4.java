package com.tencent.mm.pluginsdk.ui.chat;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class n$4
  implements View.OnLongClickListener
{
  n$4(n paramn) {}
  
  public final boolean onLongClick(View paramView)
  {
    AppMethodBeat.i(245352);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/pluginsdk/ui/chat/VoiceInputPanel$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aYj());
    if (n.b(this.Yls)) {
      n.c(this.Yls);
    }
    a.a(true, this, "com/tencent/mm/pluginsdk/ui/chat/VoiceInputPanel$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(245352);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.n.4
 * JD-Core Version:    0.7.0.1
 */
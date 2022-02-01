package com.tencent.mm.pluginsdk.ui.chat;

import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.widget.MMEditText;

final class n$1
  implements View.OnClickListener
{
  n$1(n paramn) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(245335);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/pluginsdk/ui/chat/VoiceInputPanel$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    this.Yls.awL(n.a(this.Yls).getText().length());
    a.a(this, "com/tencent/mm/pluginsdk/ui/chat/VoiceInputPanel$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(245335);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.n.1
 * JD-Core Version:    0.7.0.1
 */
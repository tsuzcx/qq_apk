package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class br$1
  implements View.OnClickListener
{
  br$1(br parambr) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(99758);
    b localb = new b();
    localb.bd(paramView);
    a.b("com/tencent/mm/plugin/sns/ui/TimelineEmojiInfoHelper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
    this.AqE.edR();
    a.a(this, "com/tencent/mm/plugin/sns/ui/TimelineEmojiInfoHelper$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(99758);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.br.1
 * JD-Core Version:    0.7.0.1
 */
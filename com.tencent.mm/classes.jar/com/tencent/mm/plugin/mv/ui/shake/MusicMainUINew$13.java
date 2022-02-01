package com.tencent.mm.plugin.mv.ui.shake;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class MusicMainUINew$13
  implements View.OnClickListener
{
  MusicMainUINew$13(MusicMainUINew paramMusicMainUINew) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(287311);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/mv/ui/shake/MusicMainUINew$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    MusicMainUINew.c(this.McG);
    a.a(this, "com/tencent/mm/plugin/mv/ui/shake/MusicMainUINew$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(287311);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.shake.MusicMainUINew.13
 * JD-Core Version:    0.7.0.1
 */
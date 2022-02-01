package com.tencent.mm.plugin.music.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

final class MusicMainUI$6
  implements View.OnClickListener
{
  MusicMainUI$6(MusicMainUI paramMusicMainUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(63232);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/music/ui/MusicMainUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    MusicMainUI.e(this.LQd);
    a.a(this, "com/tencent/mm/plugin/music/ui/MusicMainUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(63232);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.MusicMainUI.6
 * JD-Core Version:    0.7.0.1
 */
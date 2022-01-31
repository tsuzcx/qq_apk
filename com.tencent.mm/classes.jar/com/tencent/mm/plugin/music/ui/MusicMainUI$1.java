package com.tencent.mm.plugin.music.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.a;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.plugin.music.f.a.d;

final class MusicMainUI$1
  implements View.OnClickListener
{
  MusicMainUI$1(MusicMainUI paramMusicMainUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(105089);
    MusicMainUI.a(this.pcd);
    if (MusicMainUI.b(this.pcd).isChecked())
    {
      a.KP();
      MusicMainUI.b(this.pcd).setChecked(true);
      AppMethodBeat.o(105089);
      return;
    }
    MusicMainUI.c(this.pcd);
    if (k.bVH().bVu().aiy()) {
      k.bVH().bVu().resume();
    }
    for (;;)
    {
      MusicMainUI.b(this.pcd).setChecked(false);
      AppMethodBeat.o(105089);
      return;
      k.bVH().p(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.MusicMainUI.1
 * JD-Core Version:    0.7.0.1
 */
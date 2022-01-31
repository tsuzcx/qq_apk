package com.tencent.mm.plugin.music.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mm.av.a;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.plugin.music.f.a.d;

final class MusicMainUI$1
  implements View.OnClickListener
{
  MusicMainUI$1(MusicMainUI paramMusicMainUI) {}
  
  public final void onClick(View paramView)
  {
    MusicMainUI.a(this.mCa);
    if (MusicMainUI.b(this.mCa).isChecked())
    {
      a.yu();
      MusicMainUI.b(this.mCa).setChecked(true);
      return;
    }
    MusicMainUI.c(this.mCa);
    if (k.bnl().bmY().Pv()) {
      k.bnl().bmY().resume();
    }
    for (;;)
    {
      MusicMainUI.b(this.mCa).setChecked(false);
      return;
      k.bnl().p(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.MusicMainUI.1
 * JD-Core Version:    0.7.0.1
 */
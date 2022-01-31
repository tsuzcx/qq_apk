package com.tencent.mm.plugin.scanner.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;

final class MusicPreference$1
  implements View.OnClickListener
{
  MusicPreference$1(MusicPreference paramMusicPreference) {}
  
  public final void onClick(View paramView)
  {
    if (MusicPreference.a(this.nJM) == null) {}
    while (paramView.getId() != R.h.pref_music_play_ib) {
      return;
    }
    if (MusicPreference.b(this.nJM))
    {
      MusicPreference.a(this.nJM, false);
      MusicPreference.c(this.nJM).setImageResource(R.g.product_music_play_btn);
    }
    for (;;)
    {
      MusicPreference.a(this.nJM).d(this.nJM);
      return;
      MusicPreference.a(this.nJM, true);
      MusicPreference.c(this.nJM).setImageResource(R.g.product_music_stop_btn);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.MusicPreference.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.scanner.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class MusicPreference$1
  implements View.OnClickListener
{
  MusicPreference$1(MusicPreference paramMusicPreference) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(81035);
    if (MusicPreference.a(this.qxo) == null)
    {
      AppMethodBeat.o(81035);
      return;
    }
    if (paramView.getId() == 2131826253)
    {
      if (!MusicPreference.b(this.qxo)) {
        break label83;
      }
      MusicPreference.a(this.qxo, false);
      MusicPreference.c(this.qxo).setImageResource(2130839969);
    }
    for (;;)
    {
      MusicPreference.a(this.qxo).d(this.qxo);
      AppMethodBeat.o(81035);
      return;
      label83:
      MusicPreference.a(this.qxo, true);
      MusicPreference.c(this.qxo).setImageResource(2130839970);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.MusicPreference.1
 * JD-Core Version:    0.7.0.1
 */
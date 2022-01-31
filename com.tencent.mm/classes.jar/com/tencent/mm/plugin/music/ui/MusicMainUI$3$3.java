package com.tencent.mm.plugin.music.ui;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.music.f.c.b;
import com.tencent.mm.plugin.music.model.d;
import com.tencent.mm.plugin.music.model.e.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.z;

final class MusicMainUI$3$3
  implements Runnable
{
  MusicMainUI$3$3(MusicMainUI.3 param3) {}
  
  public final void run()
  {
    AppMethodBeat.i(105093);
    MusicMainUI localMusicMainUI = this.pcf.pcd;
    if (((Boolean)g.RL().Ru().get(82, Boolean.TRUE)).booleanValue())
    {
      g.RL().Ru().set(82, Boolean.FALSE);
      switch (((com.tencent.mm.plugin.music.e.e)b.am(com.tencent.mm.plugin.music.e.e.class)).bVw().field_musicType)
      {
      }
    }
    for (;;)
    {
      MusicMainUI.k(this.pcf.pcd);
      AppMethodBeat.o(105093);
      return;
      d.T(localMusicMainUI, 2131303573);
      continue;
      d.T(localMusicMainUI, 2131303574);
      continue;
      d.T(localMusicMainUI, 2131303575);
      continue;
      d.T(localMusicMainUI, 2131303576);
      continue;
      if (((com.tencent.mm.plugin.music.e.e)b.am(com.tencent.mm.plugin.music.e.e.class)).getMode() == 2) {
        Toast.makeText(ah.getContext(), 2131304221, 0).show();
      } else {
        Toast.makeText(ah.getContext(), 2131304222, 0).show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.MusicMainUI.3.3
 * JD-Core Version:    0.7.0.1
 */
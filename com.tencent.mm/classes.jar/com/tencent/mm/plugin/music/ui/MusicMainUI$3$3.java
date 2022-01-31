package com.tencent.mm.plugin.music.ui;

import android.widget.Toast;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.music.a.f;
import com.tencent.mm.plugin.music.f.c.b;
import com.tencent.mm.plugin.music.model.d;
import com.tencent.mm.plugin.music.model.e.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.z;

final class MusicMainUI$3$3
  implements Runnable
{
  MusicMainUI$3$3(MusicMainUI.3 param3) {}
  
  public final void run()
  {
    MusicMainUI localMusicMainUI = this.mCc.mCa;
    if (((Boolean)g.DP().Dz().get(82, Boolean.valueOf(true))).booleanValue())
    {
      g.DP().Dz().o(82, Boolean.valueOf(false));
      switch (((com.tencent.mm.plugin.music.e.e)b.Q(com.tencent.mm.plugin.music.e.e.class)).bna().field_musicType)
      {
      }
    }
    for (;;)
    {
      MusicMainUI.k(this.mCc.mCa);
      return;
      d.H(localMusicMainUI, a.f.shake_first_time_chatting);
      continue;
      d.H(localMusicMainUI, a.f.shake_first_time_favorite);
      continue;
      d.H(localMusicMainUI, a.f.shake_first_time_shake);
      continue;
      d.H(localMusicMainUI, a.f.shake_first_time_timeline);
      continue;
      if (((com.tencent.mm.plugin.music.e.e)b.Q(com.tencent.mm.plugin.music.e.e.class)).getMode() == 2) {
        Toast.makeText(ae.getContext(), a.f.switch_to_multi_music, 0).show();
      } else {
        Toast.makeText(ae.getContext(), a.f.switch_to_single_music, 0).show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.MusicMainUI.3.3
 * JD-Core Version:    0.7.0.1
 */
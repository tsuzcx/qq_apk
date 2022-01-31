package com.tencent.mm.plugin.music.ui;

import android.content.Intent;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.f.a.d.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.f;
import junit.framework.Assert;

final class MusicMainUI$8
  implements d.a
{
  MusicMainUI$8(MusicMainUI paramMusicMainUI) {}
  
  public final void dW(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(105103);
    if (MusicMainUI.i(this.pcd) == null)
    {
      if ((f.IS_FLAVOR_RED) || (f.DEBUG)) {
        Assert.assertTrue("pager is null, err", false);
      }
      ab.w("MicroMsg.Music.MusicMainUI", "pager is null, return");
      AppMethodBeat.o(105103);
      return;
    }
    if ((MusicMainUI.m(this.pcd) == 1) && (!MusicMainUI.n(this.pcd)))
    {
      float f = this.pcd.getIntent().getFloatExtra("key_offset", 0.0F);
      long l = this.pcd.getIntent().getLongExtra("music_player_beg_time", 0L);
      l = (f * 1000.0F + (float)(System.currentTimeMillis() - l));
      if (l >= 0L) {
        MusicMainUI.i(this.pcd).X(MusicMainUI.j(this.pcd).getCurrentItem(), l + 200L);
      }
    }
    for (;;)
    {
      Message localMessage = new Message();
      localMessage.what = 1;
      MusicMainUI.o(this.pcd).sendMessage(localMessage);
      AppMethodBeat.o(105103);
      return;
      if ((paramInt1 >= 0) && (paramInt2 > 0)) {
        MusicMainUI.i(this.pcd).X(MusicMainUI.j(this.pcd).getCurrentItem(), paramInt1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.MusicMainUI.8
 * JD-Core Version:    0.7.0.1
 */
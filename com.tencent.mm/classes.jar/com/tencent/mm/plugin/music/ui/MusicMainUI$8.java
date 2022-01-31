package com.tencent.mm.plugin.music.ui;

import android.content.Intent;
import android.os.Message;
import com.tencent.mm.plugin.music.f.a.d.a;
import com.tencent.mm.sdk.platformtools.ah;

final class MusicMainUI$8
  implements d.a
{
  MusicMainUI$8(MusicMainUI paramMusicMainUI) {}
  
  public final void cy(int paramInt1, int paramInt2)
  {
    if ((MusicMainUI.m(this.mCa) == 1) && (!MusicMainUI.n(this.mCa)))
    {
      float f = this.mCa.getIntent().getFloatExtra("key_offset", 0.0F);
      long l = this.mCa.getIntent().getLongExtra("music_player_beg_time", 0L);
      l = (f * 1000.0F + (float)(System.currentTimeMillis() - l));
      if (l >= 0L) {
        MusicMainUI.i(this.mCa).H(MusicMainUI.j(this.mCa).getCurrentItem(), l + 200L);
      }
    }
    for (;;)
    {
      Message localMessage = new Message();
      localMessage.what = 1;
      MusicMainUI.o(this.mCa).sendMessage(localMessage);
      return;
      if ((paramInt1 >= 0) && (paramInt2 > 0)) {
        MusicMainUI.i(this.mCa).H(MusicMainUI.j(this.mCa).getCurrentItem(), paramInt1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.MusicMainUI.8
 * JD-Core Version:    0.7.0.1
 */
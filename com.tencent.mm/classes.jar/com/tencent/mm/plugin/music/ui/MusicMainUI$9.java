package com.tencent.mm.plugin.music.ui;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.ah;

final class MusicMainUI$9
  extends ah
{
  MusicMainUI$9(MusicMainUI paramMusicMainUI, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      MusicMainUI.p(this.mCa);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.MusicMainUI.9
 * JD-Core Version:    0.7.0.1
 */
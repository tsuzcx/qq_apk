package com.tencent.mm.plugin.music.ui;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;

final class MusicMainUI$9
  extends ak
{
  MusicMainUI$9(MusicMainUI paramMusicMainUI, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(105104);
    if (paramMessage.what == 1) {
      MusicMainUI.p(this.pcd);
    }
    AppMethodBeat.o(105104);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.MusicMainUI.9
 * JD-Core Version:    0.7.0.1
 */
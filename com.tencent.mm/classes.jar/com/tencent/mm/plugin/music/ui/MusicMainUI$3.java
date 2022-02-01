package com.tencent.mm.plugin.music.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.sdk.platformtools.Log;

final class MusicMainUI$3
  implements ap
{
  MusicMainUI$3(MusicMainUI paramMusicMainUI) {}
  
  public final void onLaunchApp(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(270951);
    Log.i("MicroMsg.Music.MusicMainUI", "onLaunchApp launchSuccess:%b", new Object[] { Boolean.valueOf(paramBoolean1) });
    AppMethodBeat.o(270951);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.MusicMainUI.3
 * JD-Core Version:    0.7.0.1
 */
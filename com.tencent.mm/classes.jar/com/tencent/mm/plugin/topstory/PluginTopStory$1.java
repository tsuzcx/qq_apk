package com.tencent.mm.plugin.topstory;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.xweb.WebView.c;

final class PluginTopStory$1
  implements WebView.c
{
  PluginTopStory$1(PluginTopStory paramPluginTopStory) {}
  
  public final void BG()
  {
    AppMethodBeat.i(65444);
    ab.i("MicroMsg.TopStory.PluginTopStory", "onCoreInitFailed");
    AppMethodBeat.o(65444);
  }
  
  public final void onCoreInitFinished()
  {
    AppMethodBeat.i(65443);
    ab.i("MicroMsg.TopStory.PluginTopStory", "onCoreInitFinished");
    AppMethodBeat.o(65443);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.PluginTopStory.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.topstory;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.xweb.WebView.PreInitCallback;

final class PluginTopStory$1
  implements WebView.PreInitCallback
{
  PluginTopStory$1(PluginTopStory paramPluginTopStory) {}
  
  public final void aXM()
  {
    AppMethodBeat.i(88408);
    ad.i("MicroMsg.TopStory.PluginTopStory", "onCoreInitFailed");
    AppMethodBeat.o(88408);
  }
  
  public final void onCoreInitFinished()
  {
    AppMethodBeat.i(88407);
    ad.i("MicroMsg.TopStory.PluginTopStory", "onCoreInitFinished");
    AppMethodBeat.o(88407);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.PluginTopStory.1
 * JD-Core Version:    0.7.0.1
 */
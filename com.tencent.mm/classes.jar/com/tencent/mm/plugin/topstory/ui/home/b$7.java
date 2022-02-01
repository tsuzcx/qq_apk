package com.tencent.mm.plugin.topstory.ui.home;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.p.a;
import com.tencent.mm.plugin.topstory.ui.a.e.17;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

final class b$7
  extends p.a
{
  b$7(b paramb) {}
  
  public final void onNetworkChange(int paramInt)
  {
    AppMethodBeat.i(125936);
    try
    {
      MMHandlerThread.postToMainThread(new e.17(this.GkK.Gkr));
      AppMethodBeat.o(125936);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", localException, "", new Object[0]);
      AppMethodBeat.o(125936);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.home.b.7
 * JD-Core Version:    0.7.0.1
 */
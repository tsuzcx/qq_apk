package com.tencent.mm.plugin.topstory.ui.home;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.n.a;
import com.tencent.mm.plugin.topstory.ui.webview.e.11;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

final class b$7
  extends n.a
{
  b$7(b paramb) {}
  
  public final void onNetworkChange(int paramInt)
  {
    AppMethodBeat.i(1584);
    try
    {
      al.d(new e.11(this.tgw.tgd));
      AppMethodBeat.o(1584);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", localException, "", new Object[0]);
      AppMethodBeat.o(1584);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.home.b.7
 * JD-Core Version:    0.7.0.1
 */
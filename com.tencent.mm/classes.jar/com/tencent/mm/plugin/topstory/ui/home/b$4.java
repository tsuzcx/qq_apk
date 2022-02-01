package com.tencent.mm.plugin.topstory.ui.home;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.ui.widget.TopStoryViewPager;
import com.tencent.mm.sdk.platformtools.Log;

final class b$4
  implements Runnable
{
  b$4(b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(125923);
    Log.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "hideNavBarShadow");
    this.GkK.Gkt.setVisibility(8);
    this.GkK.Gky = false;
    if (this.GkK.GkA != null) {
      this.GkK.GkA.setScrollEnable(true);
    }
    AppMethodBeat.o(125923);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.home.b.4
 * JD-Core Version:    0.7.0.1
 */
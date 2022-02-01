package com.tencent.mm.plugin.topstory.ui.home;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.ui.widget.TopStoryViewPager;
import com.tencent.mm.sdk.platformtools.ad;

final class b$4
  implements Runnable
{
  b$4(b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(125923);
    ad.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "hideNavBarShadow");
    this.BsG.Bsp.setVisibility(8);
    this.BsG.Bsu = false;
    if (this.BsG.Bsw != null) {
      this.BsG.Bsw.setScrollEnable(true);
    }
    AppMethodBeat.o(125923);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.home.b.4
 * JD-Core Version:    0.7.0.1
 */
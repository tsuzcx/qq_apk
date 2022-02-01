package com.tencent.mm.plugin.topstory.ui.home;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.List;

final class b$18
  implements Runnable
{
  b$18(b paramb, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(125954);
    if (this.jdE == this.BsG.sEa)
    {
      ((b.a)this.BsG.Ady.get(this.BsG.sEa)).BsY.setVisibility(8);
      ad.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "onH5RenderFinished hide fakeIv " + this.BsG.sEa);
    }
    AppMethodBeat.o(125954);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.home.b.18
 * JD-Core Version:    0.7.0.1
 */
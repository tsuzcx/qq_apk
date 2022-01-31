package com.tencent.mm.plugin.topstory.ui.home;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.List;

final class b$16
  implements Runnable
{
  b$16(b paramb, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(1600);
    if (this.gxr == this.tgw.stw)
    {
      ((b.a)this.tgw.rQS.get(this.tgw.stw)).tgP.setVisibility(8);
      ab.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "onH5RenderFinished hide fakeIv " + this.tgw.stw);
    }
    AppMethodBeat.o(1600);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.home.b.16
 * JD-Core Version:    0.7.0.1
 */
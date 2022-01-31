package com.tencent.mm.plugin.topstory.ui.home;

import android.content.res.Resources;
import android.os.Build.VERSION;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.ui.widget.TopStoryViewPager;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;

final class b$4
  implements Runnable
{
  b$4(b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(1570);
    ab.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "hideNavBarShadow");
    this.tgw.tgf.setVisibility(8);
    if ((Build.VERSION.SDK_INT >= 21) && (!com.tencent.mm.sdk.h.b.Mo())) {
      this.tgw.tfZ.getWindow().setStatusBarColor(this.tgw.tfZ.getResources().getColor(2131689496));
    }
    this.tgw.tgk = false;
    if (this.tgw.tgm != null) {
      this.tgw.tgm.setScrollEnable(true);
    }
    AppMethodBeat.o(1570);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.home.b.4
 * JD-Core Version:    0.7.0.1
 */
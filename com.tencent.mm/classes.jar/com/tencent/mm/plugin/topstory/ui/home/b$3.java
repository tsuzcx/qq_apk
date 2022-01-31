package com.tencent.mm.plugin.topstory.ui.home;

import android.content.res.Resources;
import android.os.Build.VERSION;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.ui.widget.TopStoryViewPager;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aj;

final class b$3
  implements Runnable
{
  b$3(b paramb, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    AppMethodBeat.i(1569);
    ab.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "showNavBarShadow %s, %s", new Object[] { Integer.valueOf(this.ixw), Integer.valueOf(this.tgx) });
    int i = this.ixw + 16581375 * this.tgx;
    this.tgw.tgf.setBackgroundColor(i);
    this.tgw.tgf.setVisibility(0);
    if ((Build.VERSION.SDK_INT >= 21) && (!com.tencent.mm.sdk.h.b.Mo())) {
      this.tgw.tfZ.getWindow().setStatusBarColor(aj.n(i, this.tgw.tfZ.getResources().getColor(2131689496)));
    }
    this.tgw.tgk = true;
    this.tgw.tgf.setOnClickListener(new b.3.1(this));
    if (this.tgw.tgm != null) {
      this.tgw.tgm.setScrollEnable(false);
    }
    AppMethodBeat.o(1569);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.home.b.3
 * JD-Core Version:    0.7.0.1
 */
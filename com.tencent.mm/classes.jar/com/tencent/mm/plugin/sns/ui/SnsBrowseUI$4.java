package com.tencent.mm.plugin.sns.ui;

import android.widget.Gallery;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.base.MMPageControlView;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.tools.e.b;

final class SnsBrowseUI$4
  implements e.b
{
  SnsBrowseUI$4(SnsBrowseUI paramSnsBrowseUI) {}
  
  public final void onAnimationEnd()
  {
    AppMethodBeat.i(38755);
    SnsBrowseUI.e(this.rOg).post(new SnsBrowseUI.4.2(this));
    AppMethodBeat.o(38755);
  }
  
  public final void onAnimationStart()
  {
    AppMethodBeat.i(38754);
    SnsInfoFlip localSnsInfoFlip = this.rOg.rNT;
    if (localSnsInfoFlip.rRh != null) {
      localSnsInfoFlip.rRh.setVisibility(8);
    }
    SnsBrowseUI.e(this.rOg).postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(38752);
        Object localObject = SnsBrowseUI.4.this.rOg.rNT;
        if (((SnsInfoFlip)localObject).rQU != null)
        {
          localObject = ((SnsInfoFlip)localObject).rQU.getSelectedView();
          if ((localObject instanceof MultiTouchImageView)) {
            ((MultiTouchImageView)localObject).dDJ();
          }
        }
        AppMethodBeat.o(38752);
      }
    }, 20L);
    AppMethodBeat.o(38754);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsBrowseUI.4
 * JD-Core Version:    0.7.0.1
 */
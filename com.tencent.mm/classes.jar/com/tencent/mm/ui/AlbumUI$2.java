package com.tencent.mm.ui;

import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.story.g.i;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

final class AlbumUI$2
  implements ViewPager.OnPageChangeListener
{
  AlbumUI$2(AlbumUI paramAlbumUI) {}
  
  public final void onPageScrollStateChanged(int paramInt) {}
  
  public final void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    AppMethodBeat.i(29106);
    AlbumUI.b(this.yTx).k(paramInt1, paramFloat);
    AppMethodBeat.o(29106);
  }
  
  public final void onPageSelected(int paramInt)
  {
    AppMethodBeat.i(29107);
    AlbumUI.b(this.yTx).setTo(paramInt);
    i locali;
    if (paramInt == 0)
    {
      locali = i.sFa;
      i.cDs().cWn = 3L;
    }
    for (;;)
    {
      locali = i.sFa;
      i.cDt();
      AppMethodBeat.o(29107);
      return;
      locali = i.sFa;
      i.cDs().cWn = 2L;
      if (AlbumUI.c(this.yTx))
      {
        AlbumUI.b(this.yTx).qe(false);
        g.RL().Ru().set(ac.a.yLO, Boolean.FALSE);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.AlbumUI.2
 * JD-Core Version:    0.7.0.1
 */
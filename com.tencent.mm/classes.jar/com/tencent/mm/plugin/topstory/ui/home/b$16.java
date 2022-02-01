package com.tencent.mm.plugin.topstory.ui.home;

import android.support.design.widget.TabLayout;
import android.support.design.widget.TabLayout.f;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.ui.widget.TopStoryViewPager;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.List;

final class b$16
  implements ViewPager.OnPageChangeListener
{
  b$16(b paramb, TabLayout paramTabLayout) {}
  
  public final void onPageScrollStateChanged(final int paramInt)
  {
    AppMethodBeat.i(125952);
    ad.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "onPageScrollStateChanged:".concat(String.valueOf(paramInt)));
    if (paramInt == 0)
    {
      if (this.BsG.BsA)
      {
        paramInt = this.BsG.sEa;
        this.BsG.Bsw.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(125950);
            if (paramInt == b.16.this.BsG.sEa)
            {
              ((b.a)b.16.this.BsG.Ady.get(b.16.this.BsG.sEa)).BsY.setVisibility(8);
              ad.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "onPageScrollStateChanged hide fakeIv " + b.16.this.BsG.sEa);
            }
            AppMethodBeat.o(125950);
          }
        }, 100L);
        AppMethodBeat.o(125952);
        return;
      }
      this.BsG.BsA = true;
    }
    AppMethodBeat.o(125952);
  }
  
  public final void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public final void onPageSelected(int paramInt)
  {
    AppMethodBeat.i(125951);
    ad.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "onPageSelected:".concat(String.valueOf(paramInt)));
    this.BsG.aJ(paramInt, true);
    if (!this.BsU.ad(paramInt).isSelected()) {
      this.BsU.ad(paramInt).select();
    }
    AppMethodBeat.o(125951);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.home.b.16
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.topstory.ui.home;

import android.support.design.widget.TabLayout;
import android.support.design.widget.TabLayout.e;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.ui.widget.TopStoryViewPager;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.List;

final class b$14
  implements ViewPager.OnPageChangeListener
{
  b$14(b paramb, TabLayout paramTabLayout) {}
  
  public final void onPageScrollStateChanged(final int paramInt)
  {
    AppMethodBeat.i(1598);
    ab.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "onPageScrollStateChanged:".concat(String.valueOf(paramInt)));
    if (paramInt == 0)
    {
      if (this.tgw.tgq)
      {
        paramInt = this.tgw.stw;
        this.tgw.tgm.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(1596);
            if (paramInt == b.14.this.tgw.stw)
            {
              ((b.a)b.14.this.tgw.rQS.get(b.14.this.tgw.stw)).tgP.setVisibility(8);
              ab.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "onPageScrollStateChanged hide fakeIv " + b.14.this.tgw.stw);
            }
            AppMethodBeat.o(1596);
          }
        }, 100L);
        AppMethodBeat.o(1598);
        return;
      }
      this.tgw.tgq = true;
    }
    AppMethodBeat.o(1598);
  }
  
  public final void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public final void onPageSelected(int paramInt)
  {
    AppMethodBeat.i(1597);
    ab.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "onPageSelected:".concat(String.valueOf(paramInt)));
    this.tgw.an(paramInt, true);
    if (!this.tgL.K(paramInt).isSelected()) {
      this.tgL.K(paramInt).select();
    }
    AppMethodBeat.o(1597);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.home.b.14
 * JD-Core Version:    0.7.0.1
 */
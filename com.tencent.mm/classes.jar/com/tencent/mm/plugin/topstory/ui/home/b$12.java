package com.tencent.mm.plugin.topstory.ui.home;

import android.content.res.Resources;
import android.support.design.widget.TabLayout.b;
import android.support.design.widget.TabLayout.e;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.topstory.ui.d.b;
import com.tencent.mm.plugin.topstory.ui.widget.TopStoryViewPager;
import com.tencent.mm.plugin.websearch.api.an;
import com.tencent.mm.protocal.protobuf.cko;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import java.util.Iterator;
import java.util.List;

final class b$12
  implements TabLayout.b
{
  b$12(b paramb) {}
  
  public final void f(TabLayout.e parame)
  {
    AppMethodBeat.i(1590);
    int i = 0;
    while (i < this.tgw.tgg.size())
    {
      d.b localb = (d.b)this.tgw.tgg.get(i);
      if (localb.tfQ.equals(parame))
      {
        ab.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "tab selected, " + localb.cyA);
        localb.titleTv.setTextColor(this.tgw.tfZ.getResources().getColor(2131690598));
        localb.tfR.setBackgroundColor(this.tgw.tfZ.getResources().getColor(2131689763));
        this.tgw.an(i, false);
        this.tgw.tgm.setCurrentItem(i);
        if ((localb.category == 100) && (localb.tfM > 0))
        {
          localb.bo(0, "");
          ((com.tencent.mm.plugin.topstory.a.b)g.G(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().cIn();
        }
        i = localb.category;
        g.RL().Ru().set(ac.a.yKN, Integer.valueOf(i));
        this.tgw.tgi = localb.category;
        AppMethodBeat.o(1590);
        return;
      }
      i += 1;
    }
    AppMethodBeat.o(1590);
  }
  
  public final void g(TabLayout.e parame)
  {
    AppMethodBeat.i(1591);
    Iterator localIterator = this.tgw.tgg.iterator();
    while (localIterator.hasNext())
    {
      d.b localb = (d.b)localIterator.next();
      if (localb.tfQ.equals(parame))
      {
        this.tgw.tgo = localb.category;
        ab.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "tab unselected, " + localb.cyA);
        localb.titleTv.setTextColor(this.tgw.tfZ.getResources().getColor(2131690599));
        localb.tfR.setBackgroundColor(this.tgw.tfZ.getResources().getColor(2131690605));
        AppMethodBeat.o(1591);
        return;
      }
    }
    AppMethodBeat.o(1591);
  }
  
  public final void h(TabLayout.e parame)
  {
    AppMethodBeat.i(1592);
    Object localObject = this.tgw.tgg.iterator();
    while (((Iterator)localObject).hasNext())
    {
      d.b localb = (d.b)((Iterator)localObject).next();
      if (localb.tfQ.equals(parame))
      {
        ab.i("MicroMsg.TopStory.TopStoryHomeUIComponentImpl", "tab reselected, " + localb.cyA);
        localb.titleTv.setTextColor(this.tgw.tfZ.getResources().getColor(2131690598));
        localb.tfR.setBackgroundColor(this.tgw.tfZ.getResources().getColor(2131689763));
        localObject = "";
        parame = (TabLayout.e)localObject;
        if (localb.category == 100)
        {
          parame = (TabLayout.e)localObject;
          if (localb.tfM > 0) {
            parame = ((com.tencent.mm.plugin.topstory.a.b)g.G(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().cIm();
          }
        }
        this.tgw.tgd.k(localb.tfL, localb.tfM, localb.tfN, parame);
        if ((localb.category == 100) && (localb.tfM > 0))
        {
          localb.bo(0, "");
          ((com.tencent.mm.plugin.topstory.a.b)g.G(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().cIn();
        }
        if (bo.isNullOrNil(localb.tfP)) {}
        for (parame = localb.tfO;; parame = localb.tfP)
        {
          an.b(localb.category, this.tgw.tgi, parame, this.tgw.cKi.hng, false);
          this.tgw.tgi = localb.category;
          AppMethodBeat.o(1592);
          return;
        }
      }
    }
    AppMethodBeat.o(1592);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.home.b.12
 * JD-Core Version:    0.7.0.1
 */
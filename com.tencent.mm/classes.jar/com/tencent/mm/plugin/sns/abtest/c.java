package com.tencent.mm.plugin.sns.abtest;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import com.tencent.mm.model.a.e;
import com.tencent.mm.model.a.f;
import com.tencent.mm.model.a.g;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.c.a.c;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashSet;
import java.util.Set;

public final class c
{
  private static String ojY = "0";
  private static Set<Long> ojZ = new HashSet();
  private static boolean ojn = false;
  private static com.tencent.mm.sdk.b.c ojw = new c.1();
  private static View.OnClickListener oka;
  
  public static void b(View paramView, a.c paramc)
  {
    if (ojn)
    {
      paramc.png = false;
      paramc.pne = ((ViewStub)paramView.findViewById(i.f.sns_post_hate_stub));
      paramc.pne.setVisibility(8);
    }
  }
  
  public static void bCa()
  {
    if (g.Iy().iX("6") != null)
    {
      ojY = g.Iy().iX("6").value;
      y.d("MicroMsg.SellerABTestManager", "startABTest, value:%s", new Object[] { ojY });
      ojn = true;
      a.udP.c(ojw);
      oka = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          if ((paramAnonymousView.getTag() instanceof n))
          {
            n localn = (n)paramAnonymousView.getTag();
            if ((localn != null) && (!bk.bl(localn.bGk()))) {
              c.O(paramAnonymousView.getContext(), localn.bGk());
            }
          }
        }
      };
    }
  }
  
  public static void bCb()
  {
    oka = null;
    a.udP.d(ojw);
    if (ojn)
    {
      g.Iy().iX("6").dYk = 2L;
      g.Iy().iX("6").result = ojZ.size();
      f.a(g.Iy().iX("6"));
      y.d("MicroMsg.SellerABTestManager", "endABTestWhenExitTimeline, scene:%d, result:%s", new Object[] { Integer.valueOf(2), ojZ.size() });
    }
    ojY = "0";
    ojn = false;
    ojZ.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.abtest.c
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.sns.abtest;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.th;
import com.tencent.mm.model.a.e;
import com.tencent.mm.model.a.f;
import com.tencent.mm.model.a.g;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashSet;
import java.util.Set;

public final class c
{
  private static boolean wvW;
  private static String wwH;
  private static Set<Long> wwI;
  private static View.OnClickListener wwJ;
  private static com.tencent.mm.sdk.b.c wwf;
  
  static
  {
    AppMethodBeat.i(94961);
    wwH = "0";
    wwI = new HashSet();
    wwf = new com.tencent.mm.sdk.b.c() {};
    wvW = false;
    AppMethodBeat.o(94961);
  }
  
  public static void b(View paramView, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(94958);
    if (wvW)
    {
      paramBaseViewHolder.xQX = false;
      paramBaseViewHolder.xQV = ((ViewStub)paramView.findViewById(2131305042));
      paramBaseViewHolder.xQV.setVisibility(8);
    }
    AppMethodBeat.o(94958);
  }
  
  public static void drr()
  {
    AppMethodBeat.i(94956);
    if (g.asX().uz("6") != null)
    {
      wwH = g.asX().uz("6").value;
      ad.d("MicroMsg.SellerABTestManager", "startABTest, value:%s", new Object[] { wwH });
      wvW = true;
      a.ESL.c(wwf);
      wwJ = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(94955);
          if ((paramAnonymousView.getTag() instanceof p))
          {
            p localp = (p)paramAnonymousView.getTag();
            if ((localp != null) && (!bt.isNullOrNil(localp.getSnsId()))) {
              c.R(paramAnonymousView.getContext(), localp.getSnsId());
            }
          }
          AppMethodBeat.o(94955);
        }
      };
    }
    AppMethodBeat.o(94956);
  }
  
  public static void drs()
  {
    AppMethodBeat.i(94957);
    wwJ = null;
    a.ESL.d(wwf);
    if (wvW)
    {
      g.asX().uz("6").gri = 2L;
      g.asX().uz("6").result = wwI.size();
      f.a(g.asX().uz("6"));
      ad.d("MicroMsg.SellerABTestManager", "endABTestWhenExitTimeline, scene:%d, result:%s", new Object[] { Integer.valueOf(2), wwI.size() });
    }
    wwH = "0";
    wvW = false;
    wwI.clear();
    AppMethodBeat.o(94957);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.abtest.c
 * JD-Core Version:    0.7.0.1
 */
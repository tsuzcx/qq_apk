package com.tencent.mm.plugin.sns.abtest;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.tq;
import com.tencent.mm.model.a.e;
import com.tencent.mm.model.a.f;
import com.tencent.mm.model.a.g;
import com.tencent.mm.plugin.sns.storage.p;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.HashSet;
import java.util.Set;

public final class c
{
  private static String xHX;
  private static Set<Long> xHY;
  private static View.OnClickListener xHZ;
  private static boolean xHm;
  private static com.tencent.mm.sdk.b.c xHv;
  
  static
  {
    AppMethodBeat.i(94961);
    xHX = "0";
    xHY = new HashSet();
    xHv = new com.tencent.mm.sdk.b.c() {};
    xHm = false;
    AppMethodBeat.o(94961);
  }
  
  public static void b(View paramView, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(94958);
    if (xHm)
    {
      paramBaseViewHolder.zdN = false;
      paramBaseViewHolder.zdL = ((ViewStub)paramView.findViewById(2131305042));
      paramBaseViewHolder.zdL.setVisibility(8);
    }
    AppMethodBeat.o(94958);
  }
  
  public static void dFA()
  {
    AppMethodBeat.i(94956);
    if (g.azO().yF("6") != null)
    {
      xHX = g.azO().yF("6").value;
      ac.d("MicroMsg.SellerABTestManager", "startABTest, value:%s", new Object[] { xHX });
      xHm = true;
      a.GpY.c(xHv);
      xHZ = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(94955);
          if ((paramAnonymousView.getTag() instanceof p))
          {
            p localp = (p)paramAnonymousView.getTag();
            if ((localp != null) && (!bs.isNullOrNil(localp.getSnsId()))) {
              c.S(paramAnonymousView.getContext(), localp.getSnsId());
            }
          }
          AppMethodBeat.o(94955);
        }
      };
    }
    AppMethodBeat.o(94956);
  }
  
  public static void dFB()
  {
    AppMethodBeat.i(94957);
    xHZ = null;
    a.GpY.d(xHv);
    if (xHm)
    {
      g.azO().yF("6").gRQ = 2L;
      g.azO().yF("6").result = xHY.size();
      f.a(g.azO().yF("6"));
      ac.d("MicroMsg.SellerABTestManager", "endABTestWhenExitTimeline, scene:%d, result:%s", new Object[] { Integer.valueOf(2), xHY.size() });
    }
    xHX = "0";
    xHm = false;
    xHY.clear();
    AppMethodBeat.o(94957);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.abtest.c
 * JD-Core Version:    0.7.0.1
 */
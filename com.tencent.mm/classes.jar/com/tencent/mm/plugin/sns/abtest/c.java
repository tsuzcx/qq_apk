package com.tencent.mm.plugin.sns.abtest;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.a.e;
import com.tencent.mm.model.a.f;
import com.tencent.mm.model.a.g;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashSet;
import java.util.Set;

public final class c
{
  private static com.tencent.mm.sdk.b.c qXH;
  private static boolean qXy;
  private static String qYj;
  private static Set<Long> qYk;
  private static View.OnClickListener qYl;
  
  static
  {
    AppMethodBeat.i(35687);
    qYj = "0";
    qYk = new HashSet();
    qXH = new c.1();
    qXy = false;
    AppMethodBeat.o(35687);
  }
  
  public static void b(View paramView, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(35684);
    if (qXy)
    {
      paramBaseViewHolder.shr = false;
      paramBaseViewHolder.shp = ((ViewStub)paramView.findViewById(2131828150));
      paramBaseViewHolder.shp.setVisibility(8);
    }
    AppMethodBeat.o(35684);
  }
  
  public static void cnB()
  {
    AppMethodBeat.i(35682);
    if (g.abw().pL("6") != null)
    {
      qYj = g.abw().pL("6").value;
      ab.d("MicroMsg.SellerABTestManager", "startABTest, value:%s", new Object[] { qYj });
      qXy = true;
      a.ymk.c(qXH);
      qYl = new c.2();
    }
    AppMethodBeat.o(35682);
  }
  
  public static void cnC()
  {
    AppMethodBeat.i(35683);
    qYl = null;
    a.ymk.d(qXH);
    if (qXy)
    {
      g.abw().pL("6").foo = 2L;
      g.abw().pL("6").result = qYk.size();
      f.a(g.abw().pL("6"));
      ab.d("MicroMsg.SellerABTestManager", "endABTestWhenExitTimeline, scene:%d, result:%s", new Object[] { Integer.valueOf(2), qYk.size() });
    }
    qYj = "0";
    qXy = false;
    qYk.clear();
    AppMethodBeat.o(35683);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.abtest.c
 * JD-Core Version:    0.7.0.1
 */
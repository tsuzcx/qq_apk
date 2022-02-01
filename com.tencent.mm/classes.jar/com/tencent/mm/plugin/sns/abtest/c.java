package com.tencent.mm.plugin.sns.abtest;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vl;
import com.tencent.mm.model.a.e;
import com.tencent.mm.model.a.f;
import com.tencent.mm.model.a.g;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashSet;
import java.util.Set;

public final class c
{
  private static boolean DqY;
  private static String DrJ;
  private static Set<Long> DrK;
  private static View.OnClickListener DrL;
  private static IListener Drh;
  
  static
  {
    AppMethodBeat.i(94961);
    DrJ = "0";
    DrK = new HashSet();
    Drh = new IListener() {};
    DqY = false;
    AppMethodBeat.o(94961);
  }
  
  public static void b(View paramView, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(94958);
    if (DqY)
    {
      paramBaseViewHolder.EXe = false;
      paramBaseViewHolder.EXc = ((ViewStub)paramView.findViewById(2131308193));
      paramBaseViewHolder.EXc.setVisibility(8);
    }
    AppMethodBeat.o(94958);
  }
  
  public static void eWA()
  {
    AppMethodBeat.i(94957);
    DrL = null;
    EventCenter.instance.removeListener(Drh);
    if (DqY)
    {
      g.aWT().KR("6").igp = 2L;
      g.aWT().KR("6").result = DrK.size();
      f.a(g.aWT().KR("6"));
      Log.d("MicroMsg.SellerABTestManager", "endABTestWhenExitTimeline, scene:%d, result:%s", new Object[] { Integer.valueOf(2), DrK.size() });
    }
    DrJ = "0";
    DqY = false;
    DrK.clear();
    AppMethodBeat.o(94957);
  }
  
  public static void eWz()
  {
    AppMethodBeat.i(94956);
    if (g.aWT().KR("6") != null)
    {
      DrJ = g.aWT().KR("6").value;
      Log.d("MicroMsg.SellerABTestManager", "startABTest, value:%s", new Object[] { DrJ });
      DqY = true;
      EventCenter.instance.addListener(Drh);
      DrL = new c.2();
    }
    AppMethodBeat.o(94956);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.abtest.c
 * JD-Core Version:    0.7.0.1
 */
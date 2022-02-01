package com.tencent.mm.plugin.sns.abtest;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.wq;
import com.tencent.mm.model.a.e;
import com.tencent.mm.model.a.f;
import com.tencent.mm.model.a.g;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashSet;
import java.util.Set;

public final class c
{
  private static boolean JwD;
  private static IListener JwM;
  private static String Jxo;
  private static Set<Long> Jxp;
  private static View.OnClickListener Jxq;
  
  static
  {
    AppMethodBeat.i(94961);
    Jxo = "0";
    Jxp = new HashSet();
    JwM = new IListener() {};
    JwD = false;
    AppMethodBeat.o(94961);
  }
  
  public static void b(View paramView, BaseTimeLineItem.BaseViewHolder paramBaseViewHolder)
  {
    AppMethodBeat.i(94958);
    if (JwD)
    {
      paramBaseViewHolder.Lls = false;
      paramBaseViewHolder.Llq = ((ViewStub)paramView.findViewById(i.f.sns_post_hate_stub));
      paramBaseViewHolder.Llq.setVisibility(8);
    }
    AppMethodBeat.o(94958);
  }
  
  public static void fJC()
  {
    AppMethodBeat.i(94956);
    if (g.bga().Sk("6") != null)
    {
      Jxo = g.bga().Sk("6").value;
      Log.d("MicroMsg.SellerABTestManager", "startABTest, value:%s", new Object[] { Jxo });
      JwD = true;
      EventCenter.instance.addListener(JwM);
      Jxq = new c.2();
    }
    AppMethodBeat.o(94956);
  }
  
  public static void fJD()
  {
    AppMethodBeat.i(94957);
    Jxq = null;
    EventCenter.instance.removeListener(JwM);
    if (JwD)
    {
      g.bga().Sk("6").kVd = 2L;
      g.bga().Sk("6").result = Jxp.size();
      f.a(g.bga().Sk("6"));
      Log.d("MicroMsg.SellerABTestManager", "endABTestWhenExitTimeline, scene:%d, result:%s", new Object[] { Integer.valueOf(2), Jxp.size() });
    }
    Jxo = "0";
    JwD = false;
    Jxp.clear();
    AppMethodBeat.o(94957);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.abtest.c
 * JD-Core Version:    0.7.0.1
 */
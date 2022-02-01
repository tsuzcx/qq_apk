package com.tencent.mm.plugin.websearch.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.jf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.websearch.api.WidgetData;
import com.tencent.mm.plugin.websearch.api.WidgetData.Info;
import com.tencent.mm.plugin.websearch.api.j;

public final class f
{
  public static void a(int paramInt, WidgetData paramWidgetData1, WidgetData paramWidgetData2)
  {
    AppMethodBeat.i(116645);
    Object localObject = "";
    switch (paramInt)
    {
    default: 
      paramWidgetData2 = (WidgetData)localObject;
    }
    for (;;)
    {
      localObject = new jf();
      ((jf)localObject).eAc = ((jf)localObject).t("appId", paramWidgetData2, true);
      ((jf)localObject).eAa = paramInt;
      ((jf)localObject).eAb = (System.currentTimeMillis() / 1000L);
      ((jf)localObject).eAd = paramWidgetData1.DCO.cQN;
      ((jf)localObject).eAe = ((jf)localObject).t("statBuffer", paramWidgetData1.DCO.DCV, true);
      ((jf)localObject).eAf = ((jf)localObject).t("switchId", String.format("%s-%s-%s", new Object[] { paramWidgetData1.DCO.keN, Integer.valueOf(paramWidgetData1.DCO.cQN), Long.valueOf(System.currentTimeMillis() / 1000L) }), true);
      paramWidgetData1 = ((jf)localObject).RD();
      ((j)g.ab(j.class)).ct(14688, paramWidgetData1);
      AppMethodBeat.o(116645);
      return;
      paramWidgetData2 = paramWidgetData1.DCO.hKC;
      continue;
      paramWidgetData2 = paramWidgetData2.DCO.hKC;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.f
 * JD-Core Version:    0.7.0.1
 */
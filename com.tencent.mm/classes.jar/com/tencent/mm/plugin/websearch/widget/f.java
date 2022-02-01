package com.tencent.mm.plugin.websearch.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.jh;
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
      localObject = new jh();
      ((jh)localObject).eBL = ((jh)localObject).t("appId", paramWidgetData2, true);
      ((jh)localObject).eBJ = paramInt;
      ((jh)localObject).eBK = (System.currentTimeMillis() / 1000L);
      ((jh)localObject).eBM = paramWidgetData1.DUM.cRx;
      ((jh)localObject).eBN = ((jh)localObject).t("statBuffer", paramWidgetData1.DUM.DUT, true);
      ((jh)localObject).eBO = ((jh)localObject).t("switchId", String.format("%s-%s-%s", new Object[] { paramWidgetData1.DUM.kid, Integer.valueOf(paramWidgetData1.DUM.cRx), Long.valueOf(System.currentTimeMillis() / 1000L) }), true);
      paramWidgetData1 = ((jh)localObject).RC();
      ((j)g.ab(j.class)).ct(14688, paramWidgetData1);
      AppMethodBeat.o(116645);
      return;
      paramWidgetData2 = paramWidgetData1.DUM.hNv;
      continue;
      paramWidgetData2 = paramWidgetData2.DUM.hNv;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.f
 * JD-Core Version:    0.7.0.1
 */
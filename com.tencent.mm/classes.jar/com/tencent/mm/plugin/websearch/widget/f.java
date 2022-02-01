package com.tencent.mm.plugin.websearch.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.gj;
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
      localObject = new gj();
      ((gj)localObject).egW = ((gj)localObject).t("appId", paramWidgetData2, true);
      ((gj)localObject).egU = paramInt;
      ((gj)localObject).egV = (System.currentTimeMillis() / 1000L);
      ((gj)localObject).egX = paramWidgetData1.AHB.cIB;
      ((gj)localObject).egY = ((gj)localObject).t("statBuffer", paramWidgetData1.AHB.AHJ, true);
      ((gj)localObject).egZ = ((gj)localObject).t("switchId", String.format("%s-%s-%s", new Object[] { paramWidgetData1.AHB.jko, Integer.valueOf(paramWidgetData1.AHB.cIB), Long.valueOf(System.currentTimeMillis() / 1000L) }), true);
      paramWidgetData1 = ((gj)localObject).PV();
      ((j)g.ab(j.class)).ci(14688, paramWidgetData1);
      AppMethodBeat.o(116645);
      return;
      paramWidgetData2 = paramWidgetData1.AHB.gRK;
      continue;
      paramWidgetData2 = paramWidgetData2.AHB.gRK;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.f
 * JD-Core Version:    0.7.0.1
 */
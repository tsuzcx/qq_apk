package com.tencent.mm.plugin.websearch.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.nd;
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
      localObject = new nd();
      ((nd)localObject).ekB = ((nd)localObject).x("appId", paramWidgetData2, true);
      ((nd)localObject).fgg = paramInt;
      ((nd)localObject).fgh = (System.currentTimeMillis() / 1000L);
      ((nd)localObject).fgi = paramWidgetData1.IFG.serviceType;
      ((nd)localObject).fgj = ((nd)localObject).x("statBuffer", paramWidgetData1.IFG.IFM, true);
      ((nd)localObject).fgk = ((nd)localObject).x("switchId", String.format("%s-%s-%s", new Object[] { paramWidgetData1.IFG.hes, Integer.valueOf(paramWidgetData1.IFG.serviceType), Long.valueOf(System.currentTimeMillis() / 1000L) }), true);
      paramWidgetData1 = ((nd)localObject).abV();
      ((j)g.af(j.class)).cL(14688, paramWidgetData1);
      AppMethodBeat.o(116645);
      return;
      paramWidgetData2 = paramWidgetData1.IFG.iIA;
      continue;
      paramWidgetData2 = paramWidgetData2.IFG.iIA;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.f
 * JD-Core Version:    0.7.0.1
 */
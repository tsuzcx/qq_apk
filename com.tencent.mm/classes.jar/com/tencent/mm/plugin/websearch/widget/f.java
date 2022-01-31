package com.tencent.mm.plugin.websearch.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.cy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.websearch.api.WidgetData;
import com.tencent.mm.plugin.websearch.api.WidgetData.Info;
import com.tencent.mm.plugin.websearch.api.n;

public final class f
{
  public static void a(int paramInt, WidgetData paramWidgetData1, WidgetData paramWidgetData2)
  {
    AppMethodBeat.i(91450);
    Object localObject = "";
    switch (paramInt)
    {
    default: 
      paramWidgetData2 = (WidgetData)localObject;
    }
    for (;;)
    {
      localObject = new cy();
      paramWidgetData2 = ((cy)localObject).ih(paramWidgetData2);
      paramWidgetData2.ddO = paramInt;
      paramWidgetData2.ddP = (System.currentTimeMillis() / 1000L);
      paramWidgetData2.ddR = paramWidgetData1.uKA.fmF;
      paramWidgetData2.ii(paramWidgetData1.uKA.uKJ).ij(String.format("%s-%s-%s", new Object[] { paramWidgetData1.uKA.hng, Integer.valueOf(paramWidgetData1.uKA.fmF), Long.valueOf(System.currentTimeMillis() / 1000L) }));
      paramWidgetData1 = ((cy)localObject).Ff();
      ((n)g.E(n.class)).bw(14688, paramWidgetData1);
      AppMethodBeat.o(91450);
      return;
      paramWidgetData2 = paramWidgetData1.uKA.fqf;
      continue;
      paramWidgetData2 = paramWidgetData2.uKA.fqf;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.f
 * JD-Core Version:    0.7.0.1
 */
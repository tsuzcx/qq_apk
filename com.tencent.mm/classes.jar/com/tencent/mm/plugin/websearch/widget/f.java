package com.tencent.mm.plugin.websearch.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.ib;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.websearch.api.WidgetData;
import com.tencent.mm.plugin.websearch.api.WidgetData.Info;
import com.tencent.mm.plugin.websearch.api.i;

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
      localObject = new ib();
      ((ib)localObject).ejc = ((ib)localObject).t("appId", paramWidgetData2, true);
      ((ib)localObject).eja = paramInt;
      ((ib)localObject).ejb = (System.currentTimeMillis() / 1000L);
      ((ib)localObject).ejd = paramWidgetData1.BZS.cFI;
      ((ib)localObject).eje = ((ib)localObject).t("statBuffer", paramWidgetData1.BZS.Caa, true);
      ((ib)localObject).ejf = ((ib)localObject).t("switchId", String.format("%s-%s-%s", new Object[] { paramWidgetData1.BZS.jKB, Integer.valueOf(paramWidgetData1.BZS.cFI), Long.valueOf(System.currentTimeMillis() / 1000L) }), true);
      paramWidgetData1 = ((ib)localObject).PR();
      ((i)g.ab(i.class)).cl(14688, paramWidgetData1);
      AppMethodBeat.o(116645);
      return;
      paramWidgetData2 = paramWidgetData1.BZS.hsk;
      continue;
      paramWidgetData2 = paramWidgetData2.BZS.hsk;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.f
 * JD-Core Version:    0.7.0.1
 */
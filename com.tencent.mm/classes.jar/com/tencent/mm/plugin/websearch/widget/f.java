package com.tencent.mm.plugin.websearch.widget;

import com.tencent.mm.h.b.a.at;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.websearch.api.WidgetData;
import com.tencent.mm.plugin.websearch.api.WidgetData.Info;
import com.tencent.mm.plugin.websearch.api.n;

public final class f
{
  public static void a(int paramInt, WidgetData paramWidgetData1, WidgetData paramWidgetData2)
  {
    Object localObject = "";
    switch (paramInt)
    {
    default: 
      paramWidgetData2 = (WidgetData)localObject;
    }
    for (;;)
    {
      localObject = new at();
      ((at)localObject).cpT = paramWidgetData2;
      ((at)localObject).cpR = paramInt;
      ((at)localObject).cpS = (System.currentTimeMillis() / 1000L);
      ((at)localObject).cpU = paramWidgetData1.qVo.dWx;
      ((at)localObject).cpV = paramWidgetData1.qVo.qVx;
      ((at)localObject).cpW = String.format("%s-%s-%s", new Object[] { paramWidgetData1.qVo.fTF, Integer.valueOf(paramWidgetData1.qVo.dWx), Long.valueOf(System.currentTimeMillis() / 1000L) });
      paramWidgetData1 = ((at)localObject).uI();
      ((n)g.r(n.class)).aR(14688, paramWidgetData1);
      return;
      paramWidgetData2 = paramWidgetData1.qVo.dZY;
      continue;
      paramWidgetData2 = paramWidgetData2.qVo.dZY;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.f
 * JD-Core Version:    0.7.0.1
 */
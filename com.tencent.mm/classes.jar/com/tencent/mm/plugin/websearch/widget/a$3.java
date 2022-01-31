package com.tencent.mm.plugin.websearch.widget;

import android.os.Bundle;
import android.view.View;
import android.widget.AbsoluteLayout;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.b.a;
import com.tencent.mm.ipcinvoker.e;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.plugin.websearch.api.WidgetData;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import java.util.Map;

final class a$3
  implements Runnable
{
  a$3(a parama, WidgetData paramWidgetData, ThreeDotsLoadingView paramThreeDotsLoadingView, String paramString1, String paramString2, View paramView, AbsoluteLayout paramAbsoluteLayout) {}
  
  public final void run()
  {
    int i;
    if (!e.fE(a.a(this.qWF)))
    {
      localObject = a.a(this.qWF);
      b localb = b.BT();
      if (localb.fC((String)localObject))
      {
        localObject = (b.a)localb.dGs.get(localObject);
        if ((localObject == null) || (((b.a)localObject).dGB)) {}
      }
      for (i = 1; i == 0; i = 0)
      {
        u.i("FTSSearchWidgetMgr", "do not has connected ipc service for %s, set timeout %d", new Object[] { a.a(this.qWF), Integer.valueOf(30000) });
        i = 30000;
        u.i("FTSSearchWidgetMgr", "widget loading timeout is %d ms", new Object[] { Integer.valueOf(i) });
        if (i > 0)
        {
          if (a.m(this.qWF) != null) {
            ai.S(a.m(this.qWF));
          }
          a.a(this.qWF, new a.3.1(this));
          ai.l(a.m(this.qWF), i);
        }
        return;
      }
    }
    Object localObject = (Bundle)f.a("com.tencent.mm", new Bundle(), a.a.class);
    if (localObject != null) {}
    for (int j = ((Bundle)localObject).getInt("search_wa_widget_init_out_time");; j = 0)
    {
      i = j;
      if (j != 0) {
        break;
      }
      i = 30000;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.a.3
 * JD-Core Version:    0.7.0.1
 */
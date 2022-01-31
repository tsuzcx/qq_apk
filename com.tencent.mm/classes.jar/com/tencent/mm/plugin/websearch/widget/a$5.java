package com.tencent.mm.plugin.websearch.widget;

import android.os.Bundle;
import android.view.View;
import android.widget.AbsoluteLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.b.a;
import com.tencent.mm.ipcinvoker.e;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.plugin.websearch.api.WidgetData;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import java.util.Map;

final class a$5
  implements Runnable
{
  a$5(a parama, WidgetData paramWidgetData, String paramString1, ThreeDotsLoadingView paramThreeDotsLoadingView, String paramString2, View paramView, AbsoluteLayout paramAbsoluteLayout) {}
  
  public final void run()
  {
    AppMethodBeat.i(91396);
    int i;
    if (!e.lZ(a.a(this.uLR)))
    {
      localObject = a.a(this.uLR);
      b localb = b.PK();
      if (localb.lX((String)localObject))
      {
        localObject = (b.a)localb.eDV.get(localObject);
        if ((localObject == null) || (((b.a)localObject).eEd)) {}
      }
      for (i = 1; i == 0; i = 0)
      {
        u.i("FTSSearchWidgetMgr", "do not has connected ipc service for %s, set timeout %d", new Object[] { a.a(this.uLR), Integer.valueOf(30000) });
        i = 30000;
        u.i("FTSSearchWidgetMgr", "widget loading timeout is %d ms", new Object[] { Integer.valueOf(i) });
        if (i > 0)
        {
          if (a.n(this.uLR) != null) {
            al.ae(a.n(this.uLR));
          }
          a.a(this.uLR, new a.5.1(this));
          al.p(a.n(this.uLR), i);
        }
        AppMethodBeat.o(91396);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.a.5
 * JD-Core Version:    0.7.0.1
 */
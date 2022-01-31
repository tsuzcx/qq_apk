package com.tencent.mm.plugin.websearch.widget.view;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.plugin.appbrand.s.g;
import com.tencent.mm.plugin.websearch.api.f;

final class b$7
  implements View.OnClickListener
{
  b$7(b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(91532);
    this.uNn.uMX = ("tap_" + System.currentTimeMillis());
    int i = (int)this.uNn.uNd[0];
    int k = (int)this.uNn.uNd[1];
    int j = i;
    if (i < 2) {
      j = 2;
    }
    i = k;
    if (k < 2) {
      i = 2;
    }
    k = i;
    if (i > this.uNn.uMU.getHeight() - 2) {
      k = this.uNn.uMU.getHeight() - 2;
    }
    this.uNn.uMV.f(g.pN(j), g.pN(k), this.uNn.uMW, this.uNn.uMX);
    this.uNn.iL(false);
    u.i("WidgetView", "tap event id %s, location x %f, y %f", new Object[] { this.uNn.uMX, Float.valueOf(this.uNn.uNd[0]), Float.valueOf(this.uNn.uNd[1]) });
    AppMethodBeat.o(91532);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.view.b.7
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.websearch.widget.view;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.modelappbrand.u;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.websearch.api.d;

final class b$7
  implements View.OnClickListener
{
  b$7(b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(116709);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramView);
    a.b("com/tencent/mm/plugin/websearch/widget/view/WidgetView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    this.IIZ.IIJ = ("tap_" + System.currentTimeMillis());
    int i = (int)this.IIZ.IIO[0];
    int k = (int)this.IIZ.IIO[1];
    int j = i;
    if (i < 2) {
      j = 2;
    }
    i = k;
    if (k < 2) {
      i = 2;
    }
    k = i;
    if (i > this.IIZ.IIG.getHeight() - 2) {
      k = this.IIZ.IIG.getHeight() - 2;
    }
    this.IIZ.IIH.g(g.zC(j), g.zC(k), this.IIZ.III, this.IIZ.IIJ);
    this.IIZ.qA(false);
    u.i("WidgetView", "tap event id %s, location x %f, y %f", new Object[] { this.IIZ.IIJ, Float.valueOf(this.IIZ.IIO[0]), Float.valueOf(this.IIZ.IIO[1]) });
    a.a(this, "com/tencent/mm/plugin/websearch/widget/view/WidgetView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(116709);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.view.b.7
 * JD-Core Version:    0.7.0.1
 */
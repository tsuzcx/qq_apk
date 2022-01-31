package com.tencent.mm.plugin.websearch.widget.view;

import android.support.v4.view.ViewPager;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ServiceWidgetView$1
  implements b.b
{
  ServiceWidgetView$1(ServiceWidgetView paramServiceWidgetView) {}
  
  public final void JE(int paramInt)
  {
    AppMethodBeat.i(91480);
    this.uMQ.JB(paramInt);
    AppMethodBeat.o(91480);
  }
  
  public final void a(b paramb)
  {
    AppMethodBeat.i(91481);
    if (paramb == this.uMQ.uMN.JF(this.uMQ.rwj.getCurrentItem())) {
      ServiceWidgetView.a(this.uMQ);
    }
    AppMethodBeat.o(91481);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.view.ServiceWidgetView.1
 * JD-Core Version:    0.7.0.1
 */
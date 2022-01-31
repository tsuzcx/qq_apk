package com.tencent.mm.plugin.websearch.widget.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.api.WidgetData;
import com.tencent.mm.plugin.websearch.api.WidgetData.Info;
import com.tencent.mm.plugin.websearch.api.WidgetData.MoreFooter;

final class b$2
  implements View.OnClickListener
{
  b$2(b paramb) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(91518);
    if (this.uNn.uNg.uKz != null)
    {
      this.uNn.P(this.uNn.uNg.uKz.uKO, this.uNn.uNg.uKz.uKN, this.uNn.uNg.uKA.uKH);
      this.uNn.iL(true);
    }
    AppMethodBeat.o(91518);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.view.b.2
 * JD-Core Version:    0.7.0.1
 */
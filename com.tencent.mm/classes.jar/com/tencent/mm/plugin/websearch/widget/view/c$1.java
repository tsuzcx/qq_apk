package com.tencent.mm.plugin.websearch.widget.view;

import android.content.Context;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.websearch.a.c;
import com.tencent.mm.plugin.websearch.api.h;
import com.tencent.mm.plugin.websearch.api.i;
import com.tencent.mm.plugin.websearch.widget.f;
import com.tencent.mm.plugin.websearch.widget.view.footer.a.a;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.List;

final class c$1
  implements a.a
{
  c$1(c paramc) {}
  
  public final void cas()
  {
    List localList = this.qXZ.qXR.can();
    if ((localList == null) || (localList.isEmpty()) || (localList.size() == 1)) {
      return;
    }
    f.a(1, this.qXZ.qXS, null);
    this.qXZ.qXQ = ((h)g.r(h.class)).a(this.qXZ.gfb, ae.getContext().getString(a.c.service_widget_choose_widget_actionsheet_title), "", localList, new c.1.1(this));
  }
  
  public final void cat()
  {
    this.qXZ.kBU.bZl();
  }
  
  public final void cau()
  {
    this.qXZ.kBU.bZm();
  }
  
  public final int getItemCount()
  {
    return this.qXZ.qXR.cam();
  }
  
  public final boolean hasNext()
  {
    return this.qXZ.qXR.hasNext();
  }
  
  public final boolean hasPrevious()
  {
    return this.qXZ.qXR.cao();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.widget.view.c.1
 * JD-Core Version:    0.7.0.1
 */
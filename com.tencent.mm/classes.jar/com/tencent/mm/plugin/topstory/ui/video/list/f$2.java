package com.tencent.mm.plugin.topstory.ui.video.list;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.topstory.ui.video.f.a;
import com.tencent.mm.plugin.topstory.ui.video.l;
import com.tencent.mm.plugin.topstory.ui.video.r;
import com.tencent.mm.plugin.websearch.api.a.a;

final class f$2
  implements View.OnClickListener
{
  f$2(f paramf) {}
  
  public final void onClick(View paramView)
  {
    if (f.a(this.pHJ) == f.a.pEM) {
      this.pHJ.getListVideoUIComponent().bNs().pFL = true;
    }
    if (this.pHJ.getListVideoUIComponent().bNs().isConnected())
    {
      if (this.pHJ.getListVideoUIComponent().bNx().pGx)
      {
        this.pHJ.getListVideoUIComponent().bNx().bMs();
        this.pHJ.bNN();
      }
      for (;;)
      {
        a.jdMethod_if(19);
        return;
        this.pHJ.jI(true);
      }
    }
    a.jdMethod_if(20);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.topstory.ui.video.list.f.2
 * JD-Core Version:    0.7.0.1
 */
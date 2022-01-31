package com.tencent.mm.plugin.sns.ui;

import android.widget.ListView;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

final class bh$2
  implements Runnable
{
  int offset = 0;
  
  bh$2(bh parambh) {}
  
  public final void run()
  {
    int i;
    if ((this.pkv.lwE != null) && (this.pkv.lwE.getCount() > this.pkv.position))
    {
      this.pkv.oXx = this.pkv.oNF.getTop();
      i = this.pkv.oXx - this.pkv.pko - this.pkv.pkm;
      y.d("MicroMsg.TimeLineScrollAnimation", "itemH:" + this.pkv.pkm + " footerTop" + this.pkv.oXx + " list.bottom:" + this.pkv.lwE.getBottom() + " position: " + this.pkv.position + " topselection: " + i);
      y.d("MicroMsg.TimeLineScrollAnimation", "list.getTop(): " + this.pkv.lwE.getTop() + " marginTop: " + this.pkv.pko + " footerTop " + this.pkv.oXx);
      if (i == this.offset)
      {
        this.pkv.lwE.setSelectionFromTop(this.pkv.position + this.pkv.lwE.getHeaderViewsCount(), i);
        this.offset = 0;
        this.pkv.pkq = 0;
      }
    }
    else
    {
      return;
    }
    if (bh.a(this.pkv) > 0)
    {
      new ah().postDelayed(this, 100L);
      this.offset = i;
      return;
    }
    this.offset = 0;
    this.pkv.pkq = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bh.2
 * JD-Core Version:    0.7.0.1
 */
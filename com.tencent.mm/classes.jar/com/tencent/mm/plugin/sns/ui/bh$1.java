package com.tencent.mm.plugin.sns.ui;

import android.widget.ListView;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

final class bh$1
  implements Runnable
{
  bh$1(bh parambh) {}
  
  public final void run()
  {
    if ((this.pkv.lwE != null) && (this.pkv.lwE.getCount() > this.pkv.position))
    {
      int j = this.pkv.oNF.getTop();
      y.d("MicroMsg.TimeLineScrollAnimation", "limitCount: " + this.pkv.pkq + " footerHeight:" + this.pkv.oNF.getHeight() + " listOriginalBottom: " + this.pkv.oWf);
      if ((bh.a(this.pkv) > 0) && ((this.pkv.oXx != j) || (j > this.pkv.oWf - 200) || (this.pkv.lwE.getBottom() > this.pkv.oWf - this.pkv.oNF.getHeight() - 150)))
      {
        i = 10;
        if (this.pkv.pkq == 0) {
          i = 200;
        }
        new ah().postDelayed(this, i);
      }
      this.pkv.oXx = j;
      int i = this.pkv.oXx - this.pkv.pko - this.pkv.pkm;
      y.d("MicroMsg.TimeLineScrollAnimation", "itemH:" + this.pkv.pkm + " footerTop" + this.pkv.oXx + " list.bottom:" + this.pkv.lwE.getBottom() + " position: " + this.pkv.position + " topselection: " + i);
      y.d("MicroMsg.TimeLineScrollAnimation", "list.getTop(): " + this.pkv.lwE.getTop() + " marginTop: " + this.pkv.pko + " footerTop " + this.pkv.oXx);
      this.pkv.lwE.setSelectionFromTop(this.pkv.position + this.pkv.lwE.getHeaderViewsCount(), i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bh.1
 * JD-Core Version:    0.7.0.1
 */
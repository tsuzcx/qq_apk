package com.tencent.mm.plugin.sns.ui;

import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

final class bf$2
  implements Runnable
{
  int offset = 0;
  
  bf$2(bf parambf) {}
  
  public final void run()
  {
    AppMethodBeat.i(39887);
    if ((this.scY.list != null) && (this.scY.list.getCount() > this.scY.position))
    {
      this.scY.rPV = this.scY.rFo.getTop();
      int i = this.scY.rPV - this.scY.scS - this.scY.scQ;
      ab.d("MicroMsg.TimeLineScrollAnimation", "itemH:" + this.scY.scQ + " footerTop" + this.scY.rPV + " list.bottom:" + this.scY.list.getBottom() + " position: " + this.scY.position + " topselection: " + i);
      ab.d("MicroMsg.TimeLineScrollAnimation", "list.getTop(): " + this.scY.list.getTop() + " marginTop: " + this.scY.scS + " footerTop " + this.scY.rPV);
      if (i == this.offset)
      {
        this.scY.list.setSelectionFromTop(this.scY.position + this.scY.list.getHeaderViewsCount(), i);
        this.offset = 0;
        this.scY.bQA = 0;
        AppMethodBeat.o(39887);
        return;
      }
      if (bf.a(this.scY) > 0)
      {
        new ak().postDelayed(this, 100L);
        this.offset = i;
        AppMethodBeat.o(39887);
        return;
      }
      this.offset = 0;
      this.scY.bQA = 0;
    }
    AppMethodBeat.o(39887);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bf.2
 * JD-Core Version:    0.7.0.1
 */
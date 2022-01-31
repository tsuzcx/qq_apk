package com.tencent.mm.plugin.sns.ui;

import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

final class bf$1
  implements Runnable
{
  bf$1(bf parambf) {}
  
  public final void run()
  {
    AppMethodBeat.i(39886);
    if ((this.scY.list != null) && (this.scY.list.getCount() > this.scY.position))
    {
      int j = this.scY.rFo.getTop();
      ab.d("MicroMsg.TimeLineScrollAnimation", "limitCount: " + this.scY.bQA + " footerHeight:" + this.scY.rFo.getHeight() + " listOriginalBottom: " + this.scY.rOD);
      if ((bf.a(this.scY) > 0) && ((this.scY.rPV != j) || (j > this.scY.rOD - 200) || (this.scY.list.getBottom() > this.scY.rOD - this.scY.rFo.getHeight() - 150)))
      {
        i = 10;
        if (this.scY.bQA == 0) {
          i = 200;
        }
        new ak().postDelayed(this, i);
      }
      this.scY.rPV = j;
      int i = this.scY.rPV - this.scY.scS - this.scY.scQ;
      ab.d("MicroMsg.TimeLineScrollAnimation", "itemH:" + this.scY.scQ + " footerTop" + this.scY.rPV + " list.bottom:" + this.scY.list.getBottom() + " position: " + this.scY.position + " topselection: " + i);
      ab.d("MicroMsg.TimeLineScrollAnimation", "list.getTop(): " + this.scY.list.getTop() + " marginTop: " + this.scY.scS + " footerTop " + this.scY.rPV);
      this.scY.list.setSelectionFromTop(this.scY.position + this.scY.list.getHeaderViewsCount(), i);
    }
    AppMethodBeat.o(39886);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bf.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.sns.ui;

import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;

public final class bq
{
  int AHJ;
  int AHK;
  public int AHL;
  boolean AHM;
  protected long AHN;
  Runnable AHO;
  Runnable AHP;
  Runnable AHQ;
  SnsCommentFooter Agn;
  public int ArY;
  int AtA;
  int cJU;
  ListView list;
  int position;
  
  public bq(ListView paramListView, SnsCommentFooter paramSnsCommentFooter)
  {
    AppMethodBeat.i(99754);
    this.position = -1;
    this.AHJ = -1;
    this.AHK = -1;
    this.ArY = -1;
    this.AHL = 0;
    this.AtA = -1;
    this.AHM = false;
    this.AHO = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(99751);
        if ((bq.this.list != null) && (bq.this.list.getCount() > bq.this.position))
        {
          int j = bq.this.Agn.getTop();
          ae.d("MicroMsg.TimeLineScrollAnimation", "limitCount: " + bq.this.cJU + " footerHeight:" + bq.this.Agn.getHeight() + " listOriginalBottom: " + bq.this.ArY);
          if ((bq.a(bq.this) > 0) && ((bq.this.AtA != j) || (j > bq.this.ArY - 200) || (bq.this.list.getBottom() > bq.this.ArY - bq.this.Agn.getHeight() - 150)))
          {
            i = 10;
            if (bq.this.cJU == 0) {
              i = 200;
            }
            new aq().postDelayed(this, i);
          }
          bq.this.AtA = j;
          int i = bq.this.AtA - bq.this.AHL - bq.this.AHJ;
          ae.d("MicroMsg.TimeLineScrollAnimation", "itemH:" + bq.this.AHJ + " footerTop" + bq.this.AtA + " list.bottom:" + bq.this.list.getBottom() + " position: " + bq.this.position + " topselection: " + i);
          ae.d("MicroMsg.TimeLineScrollAnimation", "list.getTop(): " + bq.this.list.getTop() + " marginTop: " + bq.this.AHL + " footerTop " + bq.this.AtA);
          bq.this.list.setSelectionFromTop(bq.this.position + bq.this.list.getHeaderViewsCount(), i);
        }
        AppMethodBeat.o(99751);
      }
    };
    this.AHP = new Runnable()
    {
      int offset = 0;
      
      public final void run()
      {
        AppMethodBeat.i(99752);
        if ((bq.this.list != null) && (bq.this.list.getCount() > bq.this.position))
        {
          bq.this.AtA = bq.this.Agn.getTop();
          int i = bq.this.AtA - bq.this.AHL - bq.this.AHJ;
          ae.d("MicroMsg.TimeLineScrollAnimation", "itemH:" + bq.this.AHJ + " footerTop" + bq.this.AtA + " list.bottom:" + bq.this.list.getBottom() + " position: " + bq.this.position + " topselection: " + i);
          ae.d("MicroMsg.TimeLineScrollAnimation", "list.getTop(): " + bq.this.list.getTop() + " marginTop: " + bq.this.AHL + " footerTop " + bq.this.AtA);
          if (i == this.offset)
          {
            bq.this.list.setSelectionFromTop(bq.this.position + bq.this.list.getHeaderViewsCount(), i);
            this.offset = 0;
            bq.this.cJU = 0;
            AppMethodBeat.o(99752);
            return;
          }
          if (bq.a(bq.this) > 0)
          {
            new aq().postDelayed(this, 100L);
            this.offset = i;
            AppMethodBeat.o(99752);
            return;
          }
          this.offset = 0;
          bq.this.cJU = 0;
        }
        AppMethodBeat.o(99752);
      }
    };
    this.AHQ = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(99753);
        ae.d("MicroMsg.TimeLineScrollAnimation", "originalTop:" + bq.this.AHK + " position:" + bq.this.position + " list.bottom:" + bq.this.list.getBottom());
        AppMethodBeat.o(99753);
      }
    };
    this.list = paramListView;
    this.Agn = paramSnsCommentFooter;
    AppMethodBeat.o(99754);
  }
  
  public final void ehv()
  {
    AppMethodBeat.i(99755);
    this.AHM = true;
    new aq().postDelayed(this.AHO, 30L);
    this.cJU = 10;
    ae.e("MicroMsg.TimeLineScrollAnimation", "footerTop when up :" + this.Agn.getTop());
    this.AHN = bu.HQ();
    AppMethodBeat.o(99755);
  }
  
  public final void ehw()
  {
    AppMethodBeat.i(99756);
    this.AHM = true;
    this.cJU = 20;
    new aq().postDelayed(this.AHP, 100L);
    AppMethodBeat.o(99756);
  }
  
  public final void ehx()
  {
    AppMethodBeat.i(99757);
    if (!this.AHM)
    {
      AppMethodBeat.o(99757);
      return;
    }
    this.AHM = false;
    new aq().postDelayed(this.AHQ, 30L);
    this.cJU = 10;
    AppMethodBeat.o(99757);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bq
 * JD-Core Version:    0.7.0.1
 */
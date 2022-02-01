package com.tencent.mm.plugin.sns.ui;

import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;

public final class bq
{
  public int AaL;
  int Acn;
  Runnable AqA;
  Runnable AqB;
  Runnable AqC;
  int Aqv;
  int Aqw;
  public int Aqx;
  boolean Aqy;
  protected long Aqz;
  int cJl;
  ListView list;
  int position;
  SnsCommentFooter zPg;
  
  public bq(ListView paramListView, SnsCommentFooter paramSnsCommentFooter)
  {
    AppMethodBeat.i(99754);
    this.position = -1;
    this.Aqv = -1;
    this.Aqw = -1;
    this.AaL = -1;
    this.Aqx = 0;
    this.Acn = -1;
    this.Aqy = false;
    this.AqA = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(99751);
        if ((bq.this.list != null) && (bq.this.list.getCount() > bq.this.position))
        {
          int j = bq.this.zPg.getTop();
          ad.d("MicroMsg.TimeLineScrollAnimation", "limitCount: " + bq.this.cJl + " footerHeight:" + bq.this.zPg.getHeight() + " listOriginalBottom: " + bq.this.AaL);
          if ((bq.a(bq.this) > 0) && ((bq.this.Acn != j) || (j > bq.this.AaL - 200) || (bq.this.list.getBottom() > bq.this.AaL - bq.this.zPg.getHeight() - 150)))
          {
            i = 10;
            if (bq.this.cJl == 0) {
              i = 200;
            }
            new ap().postDelayed(this, i);
          }
          bq.this.Acn = j;
          int i = bq.this.Acn - bq.this.Aqx - bq.this.Aqv;
          ad.d("MicroMsg.TimeLineScrollAnimation", "itemH:" + bq.this.Aqv + " footerTop" + bq.this.Acn + " list.bottom:" + bq.this.list.getBottom() + " position: " + bq.this.position + " topselection: " + i);
          ad.d("MicroMsg.TimeLineScrollAnimation", "list.getTop(): " + bq.this.list.getTop() + " marginTop: " + bq.this.Aqx + " footerTop " + bq.this.Acn);
          bq.this.list.setSelectionFromTop(bq.this.position + bq.this.list.getHeaderViewsCount(), i);
        }
        AppMethodBeat.o(99751);
      }
    };
    this.AqB = new Runnable()
    {
      int offset = 0;
      
      public final void run()
      {
        AppMethodBeat.i(99752);
        if ((bq.this.list != null) && (bq.this.list.getCount() > bq.this.position))
        {
          bq.this.Acn = bq.this.zPg.getTop();
          int i = bq.this.Acn - bq.this.Aqx - bq.this.Aqv;
          ad.d("MicroMsg.TimeLineScrollAnimation", "itemH:" + bq.this.Aqv + " footerTop" + bq.this.Acn + " list.bottom:" + bq.this.list.getBottom() + " position: " + bq.this.position + " topselection: " + i);
          ad.d("MicroMsg.TimeLineScrollAnimation", "list.getTop(): " + bq.this.list.getTop() + " marginTop: " + bq.this.Aqx + " footerTop " + bq.this.Acn);
          if (i == this.offset)
          {
            bq.this.list.setSelectionFromTop(bq.this.position + bq.this.list.getHeaderViewsCount(), i);
            this.offset = 0;
            bq.this.cJl = 0;
            AppMethodBeat.o(99752);
            return;
          }
          if (bq.a(bq.this) > 0)
          {
            new ap().postDelayed(this, 100L);
            this.offset = i;
            AppMethodBeat.o(99752);
            return;
          }
          this.offset = 0;
          bq.this.cJl = 0;
        }
        AppMethodBeat.o(99752);
      }
    };
    this.AqC = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(99753);
        ad.d("MicroMsg.TimeLineScrollAnimation", "originalTop:" + bq.this.Aqw + " position:" + bq.this.position + " list.bottom:" + bq.this.list.getBottom());
        AppMethodBeat.o(99753);
      }
    };
    this.list = paramListView;
    this.zPg = paramSnsCommentFooter;
    AppMethodBeat.o(99754);
  }
  
  public final void edO()
  {
    AppMethodBeat.i(99755);
    this.Aqy = true;
    new ap().postDelayed(this.AqA, 30L);
    this.cJl = 10;
    ad.e("MicroMsg.TimeLineScrollAnimation", "footerTop when up :" + this.zPg.getTop());
    this.Aqz = bt.HI();
    AppMethodBeat.o(99755);
  }
  
  public final void edP()
  {
    AppMethodBeat.i(99756);
    this.Aqy = true;
    this.cJl = 20;
    new ap().postDelayed(this.AqB, 100L);
    AppMethodBeat.o(99756);
  }
  
  public final void edQ()
  {
    AppMethodBeat.i(99757);
    if (!this.Aqy)
    {
      AppMethodBeat.o(99757);
      return;
    }
    this.Aqy = false;
    new ap().postDelayed(this.AqC, 30L);
    this.cJl = 10;
    AppMethodBeat.o(99757);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bq
 * JD-Core Version:    0.7.0.1
 */
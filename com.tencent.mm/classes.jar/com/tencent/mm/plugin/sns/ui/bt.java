package com.tencent.mm.plugin.sns.ui;

import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;

public final class bt
{
  public int EBc;
  int ECI;
  int ERG;
  int ERH;
  public int ERI;
  boolean ERJ;
  protected long ERK;
  Runnable ERL;
  Runnable ERM;
  Runnable ERN;
  SnsCommentFooter EoJ;
  int das;
  ListView list;
  int position;
  
  public bt(ListView paramListView, SnsCommentFooter paramSnsCommentFooter)
  {
    AppMethodBeat.i(99754);
    this.position = -1;
    this.ERG = -1;
    this.ERH = -1;
    this.EBc = -1;
    this.ERI = 0;
    this.ECI = -1;
    this.ERJ = false;
    this.ERL = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(99751);
        if ((bt.this.list != null) && (bt.this.list.getCount() > bt.this.position))
        {
          int j = bt.this.EoJ.getTop();
          Log.d("MicroMsg.TimeLineScrollAnimation", "limitCount: " + bt.this.das + " footerHeight:" + bt.this.EoJ.getHeight() + " listOriginalBottom: " + bt.this.EBc);
          if ((bt.a(bt.this) > 0) && ((bt.this.ECI != j) || (j > bt.this.EBc - 200) || (bt.this.list.getBottom() > bt.this.EBc - bt.this.EoJ.getHeight() - 150)))
          {
            i = 10;
            if (bt.this.das == 0) {
              i = 200;
            }
            new MMHandler().postDelayed(this, i);
          }
          bt.this.ECI = j;
          int i = bt.this.ECI - bt.this.ERI - bt.this.ERG;
          Log.d("MicroMsg.TimeLineScrollAnimation", "itemH:" + bt.this.ERG + " footerTop" + bt.this.ECI + " list.bottom:" + bt.this.list.getBottom() + " position: " + bt.this.position + " topselection: " + i);
          Log.d("MicroMsg.TimeLineScrollAnimation", "list.getTop(): " + bt.this.list.getTop() + " marginTop: " + bt.this.ERI + " footerTop " + bt.this.ECI);
          bt.this.list.setSelectionFromTop(bt.this.position + bt.this.list.getHeaderViewsCount(), i);
        }
        AppMethodBeat.o(99751);
      }
    };
    this.ERM = new Runnable()
    {
      int offset = 0;
      
      public final void run()
      {
        AppMethodBeat.i(99752);
        if ((bt.this.list != null) && (bt.this.list.getCount() > bt.this.position))
        {
          bt.this.ECI = bt.this.EoJ.getTop();
          int i = bt.this.ECI - bt.this.ERI - bt.this.ERG;
          Log.d("MicroMsg.TimeLineScrollAnimation", "itemH:" + bt.this.ERG + " footerTop" + bt.this.ECI + " list.bottom:" + bt.this.list.getBottom() + " position: " + bt.this.position + " topselection: " + i);
          Log.d("MicroMsg.TimeLineScrollAnimation", "list.getTop(): " + bt.this.list.getTop() + " marginTop: " + bt.this.ERI + " footerTop " + bt.this.ECI);
          if (i == this.offset)
          {
            bt.this.list.setSelectionFromTop(bt.this.position + bt.this.list.getHeaderViewsCount(), i);
            this.offset = 0;
            bt.this.das = 0;
            AppMethodBeat.o(99752);
            return;
          }
          if (bt.a(bt.this) > 0)
          {
            new MMHandler().postDelayed(this, 100L);
            this.offset = i;
            AppMethodBeat.o(99752);
            return;
          }
          this.offset = 0;
          bt.this.das = 0;
        }
        AppMethodBeat.o(99752);
      }
    };
    this.ERN = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(99753);
        Log.d("MicroMsg.TimeLineScrollAnimation", "originalTop:" + bt.this.ERH + " position:" + bt.this.position + " list.bottom:" + bt.this.list.getBottom());
        AppMethodBeat.o(99753);
      }
    };
    this.list = paramListView;
    this.EoJ = paramSnsCommentFooter;
    AppMethodBeat.o(99754);
  }
  
  public final void fjX()
  {
    AppMethodBeat.i(99755);
    this.ERJ = true;
    new MMHandler().postDelayed(this.ERL, 30L);
    this.das = 10;
    Log.e("MicroMsg.TimeLineScrollAnimation", "footerTop when up :" + this.EoJ.getTop());
    this.ERK = Util.currentTicks();
    AppMethodBeat.o(99755);
  }
  
  public final void fjY()
  {
    AppMethodBeat.i(99756);
    this.ERJ = true;
    this.das = 20;
    new MMHandler().postDelayed(this.ERM, 100L);
    AppMethodBeat.o(99756);
  }
  
  public final void fjZ()
  {
    AppMethodBeat.i(99757);
    if (!this.ERJ)
    {
      AppMethodBeat.o(99757);
      return;
    }
    this.ERJ = false;
    new MMHandler().postDelayed(this.ERN, 30L);
    this.das = 10;
    AppMethodBeat.o(99757);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bt
 * JD-Core Version:    0.7.0.1
 */
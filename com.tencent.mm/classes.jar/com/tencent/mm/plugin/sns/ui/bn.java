package com.tencent.mm.plugin.sns.ui;

import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;

public final class bn
{
  int cBh;
  ListView list;
  int position;
  int xLS;
  int xLT;
  public int xLU;
  boolean xLV;
  protected long xLW;
  Runnable xLX;
  Runnable xLY;
  Runnable xLZ;
  SnsCommentFooter xlc;
  public int xwB;
  int xyc;
  
  public bn(ListView paramListView, SnsCommentFooter paramSnsCommentFooter)
  {
    AppMethodBeat.i(99754);
    this.position = -1;
    this.xLS = -1;
    this.xLT = -1;
    this.xwB = -1;
    this.xLU = 0;
    this.xyc = -1;
    this.xLV = false;
    this.xLX = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(99751);
        if ((bn.this.list != null) && (bn.this.list.getCount() > bn.this.position))
        {
          int j = bn.this.xlc.getTop();
          ad.d("MicroMsg.TimeLineScrollAnimation", "limitCount: " + bn.this.cBh + " footerHeight:" + bn.this.xlc.getHeight() + " listOriginalBottom: " + bn.this.xwB);
          if ((bn.a(bn.this) > 0) && ((bn.this.xyc != j) || (j > bn.this.xwB - 200) || (bn.this.list.getBottom() > bn.this.xwB - bn.this.xlc.getHeight() - 150)))
          {
            i = 10;
            if (bn.this.cBh == 0) {
              i = 200;
            }
            new ap().postDelayed(this, i);
          }
          bn.this.xyc = j;
          int i = bn.this.xyc - bn.this.xLU - bn.this.xLS;
          ad.d("MicroMsg.TimeLineScrollAnimation", "itemH:" + bn.this.xLS + " footerTop" + bn.this.xyc + " list.bottom:" + bn.this.list.getBottom() + " position: " + bn.this.position + " topselection: " + i);
          ad.d("MicroMsg.TimeLineScrollAnimation", "list.getTop(): " + bn.this.list.getTop() + " marginTop: " + bn.this.xLU + " footerTop " + bn.this.xyc);
          bn.this.list.setSelectionFromTop(bn.this.position + bn.this.list.getHeaderViewsCount(), i);
        }
        AppMethodBeat.o(99751);
      }
    };
    this.xLY = new Runnable()
    {
      int offset = 0;
      
      public final void run()
      {
        AppMethodBeat.i(99752);
        if ((bn.this.list != null) && (bn.this.list.getCount() > bn.this.position))
        {
          bn.this.xyc = bn.this.xlc.getTop();
          int i = bn.this.xyc - bn.this.xLU - bn.this.xLS;
          ad.d("MicroMsg.TimeLineScrollAnimation", "itemH:" + bn.this.xLS + " footerTop" + bn.this.xyc + " list.bottom:" + bn.this.list.getBottom() + " position: " + bn.this.position + " topselection: " + i);
          ad.d("MicroMsg.TimeLineScrollAnimation", "list.getTop(): " + bn.this.list.getTop() + " marginTop: " + bn.this.xLU + " footerTop " + bn.this.xyc);
          if (i == this.offset)
          {
            bn.this.list.setSelectionFromTop(bn.this.position + bn.this.list.getHeaderViewsCount(), i);
            this.offset = 0;
            bn.this.cBh = 0;
            AppMethodBeat.o(99752);
            return;
          }
          if (bn.a(bn.this) > 0)
          {
            new ap().postDelayed(this, 100L);
            this.offset = i;
            AppMethodBeat.o(99752);
            return;
          }
          this.offset = 0;
          bn.this.cBh = 0;
        }
        AppMethodBeat.o(99752);
      }
    };
    this.xLZ = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(99753);
        ad.d("MicroMsg.TimeLineScrollAnimation", "originalTop:" + bn.this.xLT + " position:" + bn.this.position + " list.bottom:" + bn.this.list.getBottom());
        AppMethodBeat.o(99753);
      }
    };
    this.list = paramListView;
    this.xlc = paramSnsCommentFooter;
    AppMethodBeat.o(99754);
  }
  
  public final void dCX()
  {
    AppMethodBeat.i(99755);
    this.xLV = true;
    new ap().postDelayed(this.xLX, 30L);
    this.cBh = 10;
    ad.e("MicroMsg.TimeLineScrollAnimation", "footerTop when up :" + this.xlc.getTop());
    this.xLW = bt.GC();
    AppMethodBeat.o(99755);
  }
  
  public final void dCY()
  {
    AppMethodBeat.i(99756);
    this.xLV = true;
    this.cBh = 20;
    new ap().postDelayed(this.xLY, 100L);
    AppMethodBeat.o(99756);
  }
  
  public final void dCZ()
  {
    AppMethodBeat.i(99757);
    if (!this.xLV)
    {
      AppMethodBeat.o(99757);
      return;
    }
    this.xLV = false;
    new ap().postDelayed(this.xLZ, 30L);
    this.cBh = 10;
    AppMethodBeat.o(99757);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bn
 * JD-Core Version:    0.7.0.1
 */
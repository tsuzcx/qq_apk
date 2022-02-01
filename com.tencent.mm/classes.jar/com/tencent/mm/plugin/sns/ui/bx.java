package com.tencent.mm.plugin.sns.ui;

import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;

public class bx
{
  public int CMA;
  int RFW;
  int RFX;
  boolean RFY;
  private int RFZ;
  protected long RGa;
  Runnable RGb;
  Runnable RGc;
  Runnable RGd;
  private SnsCommentFooter RbA;
  public int RoH;
  private int Rqr;
  private ListView list;
  int position;
  
  public bx(ListView paramListView, SnsCommentFooter paramSnsCommentFooter)
  {
    AppMethodBeat.i(99754);
    this.position = -1;
    this.RFW = -1;
    this.RFX = -1;
    this.RoH = -1;
    this.CMA = 0;
    this.Rqr = -1;
    this.RFY = false;
    this.RGb = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(99751);
        if ((bx.a(bx.this) != null) && (bx.a(bx.this).getCount() > bx.this.position))
        {
          int j = bx.b(bx.this).getTop();
          Log.d("MicroMsg.TimeLineScrollAnimation", "limitCount: " + bx.c(bx.this) + " footerHeight:" + bx.b(bx.this).getHeight() + " listOriginalBottom: " + bx.this.RoH);
          if ((bx.d(bx.this) > 0) && ((bx.e(bx.this) != j) || (j > bx.this.RoH - 200) || (bx.a(bx.this).getBottom() > bx.this.RoH - bx.b(bx.this).getHeight() - 150)))
          {
            i = 10;
            if (bx.c(bx.this) == 0) {
              i = 200;
            }
            new MMHandler().postDelayed(this, i);
          }
          bx.a(bx.this, j);
          int i = bx.e(bx.this) - bx.this.CMA - bx.this.RFW;
          Log.d("MicroMsg.TimeLineScrollAnimation", "itemH:" + bx.this.RFW + " footerTop" + bx.e(bx.this) + " list.bottom:" + bx.a(bx.this).getBottom() + " position: " + bx.this.position + " topselection: " + i);
          Log.d("MicroMsg.TimeLineScrollAnimation", "list.getTop(): " + bx.a(bx.this).getTop() + " marginTop: " + bx.this.CMA + " footerTop " + bx.e(bx.this));
          bx.a(bx.this).setSelectionFromTop(bx.this.position + bx.a(bx.this).getHeaderViewsCount(), i);
        }
        AppMethodBeat.o(99751);
      }
    };
    this.RGc = new Runnable()
    {
      int offset = 0;
      
      public final void run()
      {
        AppMethodBeat.i(99752);
        if ((bx.a(bx.this) != null) && (bx.a(bx.this).getCount() > bx.this.position))
        {
          bx.a(bx.this, bx.b(bx.this).getTop());
          int i = bx.e(bx.this) - bx.this.CMA - bx.this.RFW;
          Log.d("MicroMsg.TimeLineScrollAnimation", "itemH:" + bx.this.RFW + " footerTop" + bx.e(bx.this) + " list.bottom:" + bx.a(bx.this).getBottom() + " position: " + bx.this.position + " topselection: " + i);
          Log.d("MicroMsg.TimeLineScrollAnimation", "list.getTop(): " + bx.a(bx.this).getTop() + " marginTop: " + bx.this.CMA + " footerTop " + bx.e(bx.this));
          if (i == this.offset)
          {
            bx.a(bx.this).setSelectionFromTop(bx.this.position + bx.a(bx.this).getHeaderViewsCount(), i);
            this.offset = 0;
            bx.f(bx.this);
            AppMethodBeat.o(99752);
            return;
          }
          if (bx.d(bx.this) > 0)
          {
            new MMHandler().postDelayed(this, 100L);
            this.offset = i;
            AppMethodBeat.o(99752);
            return;
          }
          this.offset = 0;
          bx.f(bx.this);
        }
        AppMethodBeat.o(99752);
      }
    };
    this.RGd = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(99753);
        Log.d("MicroMsg.TimeLineScrollAnimation", "originalTop:" + bx.this.RFX + " position:" + bx.this.position + " list.bottom:" + bx.a(bx.this).getBottom());
        AppMethodBeat.o(99753);
      }
    };
    this.list = paramListView;
    this.RbA = paramSnsCommentFooter;
    AppMethodBeat.o(99754);
  }
  
  public final void hqE()
  {
    AppMethodBeat.i(99755);
    this.RFY = true;
    new MMHandler().postDelayed(this.RGb, 30L);
    this.RFZ = 10;
    Log.e("MicroMsg.TimeLineScrollAnimation", "footerTop when up :" + this.RbA.getTop());
    this.RGa = Util.currentTicks();
    AppMethodBeat.o(99755);
  }
  
  public final void hqF()
  {
    AppMethodBeat.i(99756);
    this.RFY = true;
    this.RFZ = 20;
    new MMHandler().postDelayed(this.RGc, 100L);
    AppMethodBeat.o(99756);
  }
  
  public final void hqG()
  {
    AppMethodBeat.i(99757);
    if (!this.RFY)
    {
      AppMethodBeat.o(99757);
      return;
    }
    this.RFY = false;
    new MMHandler().postDelayed(this.RGd, 30L);
    this.RFZ = 10;
    AppMethodBeat.o(99757);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bx
 * JD-Core Version:    0.7.0.1
 */
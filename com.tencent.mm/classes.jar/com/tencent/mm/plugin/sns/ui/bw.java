package com.tencent.mm.plugin.sns.ui;

import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;

public class bw
{
  private SnsCommentFooter KBS;
  public int KOU;
  private int KQz;
  int LfK;
  int LfL;
  public int LfM;
  boolean LfN;
  private int LfO;
  protected long LfP;
  Runnable LfQ;
  Runnable LfR;
  Runnable LfS;
  private ListView list;
  int position;
  
  public bw(ListView paramListView, SnsCommentFooter paramSnsCommentFooter)
  {
    AppMethodBeat.i(99754);
    this.position = -1;
    this.LfK = -1;
    this.LfL = -1;
    this.KOU = -1;
    this.LfM = 0;
    this.KQz = -1;
    this.LfN = false;
    this.LfQ = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(99751);
        if ((bw.a(bw.this) != null) && (bw.a(bw.this).getCount() > bw.this.position))
        {
          int j = bw.b(bw.this).getTop();
          Log.d("MicroMsg.TimeLineScrollAnimation", "limitCount: " + bw.c(bw.this) + " footerHeight:" + bw.b(bw.this).getHeight() + " listOriginalBottom: " + bw.this.KOU);
          if ((bw.d(bw.this) > 0) && ((bw.e(bw.this) != j) || (j > bw.this.KOU - 200) || (bw.a(bw.this).getBottom() > bw.this.KOU - bw.b(bw.this).getHeight() - 150)))
          {
            i = 10;
            if (bw.c(bw.this) == 0) {
              i = 200;
            }
            new MMHandler().postDelayed(this, i);
          }
          bw.a(bw.this, j);
          int i = bw.e(bw.this) - bw.this.LfM - bw.this.LfK;
          Log.d("MicroMsg.TimeLineScrollAnimation", "itemH:" + bw.this.LfK + " footerTop" + bw.e(bw.this) + " list.bottom:" + bw.a(bw.this).getBottom() + " position: " + bw.this.position + " topselection: " + i);
          Log.d("MicroMsg.TimeLineScrollAnimation", "list.getTop(): " + bw.a(bw.this).getTop() + " marginTop: " + bw.this.LfM + " footerTop " + bw.e(bw.this));
          bw.a(bw.this).setSelectionFromTop(bw.this.position + bw.a(bw.this).getHeaderViewsCount(), i);
        }
        AppMethodBeat.o(99751);
      }
    };
    this.LfR = new Runnable()
    {
      int offset = 0;
      
      public final void run()
      {
        AppMethodBeat.i(99752);
        if ((bw.a(bw.this) != null) && (bw.a(bw.this).getCount() > bw.this.position))
        {
          bw.a(bw.this, bw.b(bw.this).getTop());
          int i = bw.e(bw.this) - bw.this.LfM - bw.this.LfK;
          Log.d("MicroMsg.TimeLineScrollAnimation", "itemH:" + bw.this.LfK + " footerTop" + bw.e(bw.this) + " list.bottom:" + bw.a(bw.this).getBottom() + " position: " + bw.this.position + " topselection: " + i);
          Log.d("MicroMsg.TimeLineScrollAnimation", "list.getTop(): " + bw.a(bw.this).getTop() + " marginTop: " + bw.this.LfM + " footerTop " + bw.e(bw.this));
          if (i == this.offset)
          {
            bw.a(bw.this).setSelectionFromTop(bw.this.position + bw.a(bw.this).getHeaderViewsCount(), i);
            this.offset = 0;
            bw.f(bw.this);
            AppMethodBeat.o(99752);
            return;
          }
          if (bw.d(bw.this) > 0)
          {
            new MMHandler().postDelayed(this, 100L);
            this.offset = i;
            AppMethodBeat.o(99752);
            return;
          }
          this.offset = 0;
          bw.f(bw.this);
        }
        AppMethodBeat.o(99752);
      }
    };
    this.LfS = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(99753);
        Log.d("MicroMsg.TimeLineScrollAnimation", "originalTop:" + bw.this.LfL + " position:" + bw.this.position + " list.bottom:" + bw.a(bw.this).getBottom());
        AppMethodBeat.o(99753);
      }
    };
    this.list = paramListView;
    this.KBS = paramSnsCommentFooter;
    AppMethodBeat.o(99754);
  }
  
  public final void fYg()
  {
    AppMethodBeat.i(99755);
    this.LfN = true;
    new MMHandler().postDelayed(this.LfQ, 30L);
    this.LfO = 10;
    Log.e("MicroMsg.TimeLineScrollAnimation", "footerTop when up :" + this.KBS.getTop());
    this.LfP = Util.currentTicks();
    AppMethodBeat.o(99755);
  }
  
  public final void fYh()
  {
    AppMethodBeat.i(99756);
    this.LfN = true;
    this.LfO = 20;
    new MMHandler().postDelayed(this.LfR, 100L);
    AppMethodBeat.o(99756);
  }
  
  public final void fYi()
  {
    AppMethodBeat.i(99757);
    if (!this.LfN)
    {
      AppMethodBeat.o(99757);
      return;
    }
    this.LfN = false;
    new MMHandler().postDelayed(this.LfS, 30L);
    this.LfO = 10;
    AppMethodBeat.o(99757);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bw
 * JD-Core Version:    0.7.0.1
 */
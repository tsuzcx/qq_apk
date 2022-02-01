package com.tencent.mm.plugin.sns.ui;

import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;

public final class bn
{
  int cyq;
  ListView list;
  int position;
  public int yJr;
  int yKS;
  int yYH;
  int yYI;
  public int yYJ;
  boolean yYK;
  protected long yYL;
  Runnable yYM;
  Runnable yYN;
  Runnable yYO;
  SnsCommentFooter yxU;
  
  public bn(ListView paramListView, SnsCommentFooter paramSnsCommentFooter)
  {
    AppMethodBeat.i(99754);
    this.position = -1;
    this.yYH = -1;
    this.yYI = -1;
    this.yJr = -1;
    this.yYJ = 0;
    this.yKS = -1;
    this.yYK = false;
    this.yYM = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(99751);
        if ((bn.this.list != null) && (bn.this.list.getCount() > bn.this.position))
        {
          int j = bn.this.yxU.getTop();
          ac.d("MicroMsg.TimeLineScrollAnimation", "limitCount: " + bn.this.cyq + " footerHeight:" + bn.this.yxU.getHeight() + " listOriginalBottom: " + bn.this.yJr);
          if ((bn.a(bn.this) > 0) && ((bn.this.yKS != j) || (j > bn.this.yJr - 200) || (bn.this.list.getBottom() > bn.this.yJr - bn.this.yxU.getHeight() - 150)))
          {
            i = 10;
            if (bn.this.cyq == 0) {
              i = 200;
            }
            new ao().postDelayed(this, i);
          }
          bn.this.yKS = j;
          int i = bn.this.yKS - bn.this.yYJ - bn.this.yYH;
          ac.d("MicroMsg.TimeLineScrollAnimation", "itemH:" + bn.this.yYH + " footerTop" + bn.this.yKS + " list.bottom:" + bn.this.list.getBottom() + " position: " + bn.this.position + " topselection: " + i);
          ac.d("MicroMsg.TimeLineScrollAnimation", "list.getTop(): " + bn.this.list.getTop() + " marginTop: " + bn.this.yYJ + " footerTop " + bn.this.yKS);
          bn.this.list.setSelectionFromTop(bn.this.position + bn.this.list.getHeaderViewsCount(), i);
        }
        AppMethodBeat.o(99751);
      }
    };
    this.yYN = new Runnable()
    {
      int offset = 0;
      
      public final void run()
      {
        AppMethodBeat.i(99752);
        if ((bn.this.list != null) && (bn.this.list.getCount() > bn.this.position))
        {
          bn.this.yKS = bn.this.yxU.getTop();
          int i = bn.this.yKS - bn.this.yYJ - bn.this.yYH;
          ac.d("MicroMsg.TimeLineScrollAnimation", "itemH:" + bn.this.yYH + " footerTop" + bn.this.yKS + " list.bottom:" + bn.this.list.getBottom() + " position: " + bn.this.position + " topselection: " + i);
          ac.d("MicroMsg.TimeLineScrollAnimation", "list.getTop(): " + bn.this.list.getTop() + " marginTop: " + bn.this.yYJ + " footerTop " + bn.this.yKS);
          if (i == this.offset)
          {
            bn.this.list.setSelectionFromTop(bn.this.position + bn.this.list.getHeaderViewsCount(), i);
            this.offset = 0;
            bn.this.cyq = 0;
            AppMethodBeat.o(99752);
            return;
          }
          if (bn.a(bn.this) > 0)
          {
            new ao().postDelayed(this, 100L);
            this.offset = i;
            AppMethodBeat.o(99752);
            return;
          }
          this.offset = 0;
          bn.this.cyq = 0;
        }
        AppMethodBeat.o(99752);
      }
    };
    this.yYO = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(99753);
        ac.d("MicroMsg.TimeLineScrollAnimation", "originalTop:" + bn.this.yYI + " position:" + bn.this.position + " list.bottom:" + bn.this.list.getBottom());
        AppMethodBeat.o(99753);
      }
    };
    this.list = paramListView;
    this.yxU = paramSnsCommentFooter;
    AppMethodBeat.o(99754);
  }
  
  public final void dRu()
  {
    AppMethodBeat.i(99755);
    this.yYK = true;
    new ao().postDelayed(this.yYM, 30L);
    this.cyq = 10;
    ac.e("MicroMsg.TimeLineScrollAnimation", "footerTop when up :" + this.yxU.getTop());
    this.yYL = bs.Gn();
    AppMethodBeat.o(99755);
  }
  
  public final void dRv()
  {
    AppMethodBeat.i(99756);
    this.yYK = true;
    this.cyq = 20;
    new ao().postDelayed(this.yYN, 100L);
    AppMethodBeat.o(99756);
  }
  
  public final void dRw()
  {
    AppMethodBeat.i(99757);
    if (!this.yYK)
    {
      AppMethodBeat.o(99757);
      return;
    }
    this.yYK = false;
    new ao().postDelayed(this.yYO, 30L);
    this.cyq = 10;
    AppMethodBeat.o(99757);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bn
 * JD-Core Version:    0.7.0.1
 */
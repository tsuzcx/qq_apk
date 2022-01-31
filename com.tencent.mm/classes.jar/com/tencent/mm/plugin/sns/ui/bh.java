package com.tencent.mm.plugin.sns.ui;

import android.widget.ListView;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class bh
{
  ListView lwE;
  SnsCommentFooter oNF;
  public int oWf = -1;
  int oXx = -1;
  int pkm = -1;
  int pkn = -1;
  public int pko = 0;
  boolean pkp = false;
  int pkq;
  protected long pkr;
  Runnable pks = new bh.1(this);
  Runnable pkt = new bh.2(this);
  Runnable pku = new bh.3(this);
  int position = -1;
  
  public bh(ListView paramListView, SnsCommentFooter paramSnsCommentFooter)
  {
    this.lwE = paramListView;
    this.oNF = paramSnsCommentFooter;
  }
  
  public final void bKg()
  {
    this.pkp = true;
    new ah().postDelayed(this.pks, 30L);
    this.pkq = 10;
    y.e("MicroMsg.TimeLineScrollAnimation", "footerTop when up :" + this.oNF.getTop());
    this.pkr = bk.UZ();
  }
  
  public final void bKh()
  {
    this.pkp = true;
    this.pkq = 20;
    new ah().postDelayed(this.pkt, 100L);
  }
  
  public final void bKi()
  {
    if (this.pkp)
    {
      this.pkp = false;
      new ah().postDelayed(this.pku, 30L);
      this.pkq = 10;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bh
 * JD-Core Version:    0.7.0.1
 */
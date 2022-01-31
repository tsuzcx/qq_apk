package com.tencent.mm.plugin.sns.ui;

import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;

public final class bf
{
  int bQA;
  ListView list;
  int position;
  SnsCommentFooter rFo;
  public int rOD;
  int rPV;
  int scQ;
  int scR;
  public int scS;
  boolean scT;
  protected long scU;
  Runnable scV;
  Runnable scW;
  Runnable scX;
  
  public bf(ListView paramListView, SnsCommentFooter paramSnsCommentFooter)
  {
    AppMethodBeat.i(39889);
    this.position = -1;
    this.scQ = -1;
    this.scR = -1;
    this.rOD = -1;
    this.scS = 0;
    this.rPV = -1;
    this.scT = false;
    this.scV = new bf.1(this);
    this.scW = new bf.2(this);
    this.scX = new bf.3(this);
    this.list = paramListView;
    this.rFo = paramSnsCommentFooter;
    AppMethodBeat.o(39889);
  }
  
  public final void cwI()
  {
    AppMethodBeat.i(39890);
    this.scT = true;
    new ak().postDelayed(this.scV, 30L);
    this.bQA = 10;
    ab.e("MicroMsg.TimeLineScrollAnimation", "footerTop when up :" + this.rFo.getTop());
    this.scU = bo.yB();
    AppMethodBeat.o(39890);
  }
  
  public final void cwJ()
  {
    AppMethodBeat.i(39891);
    this.scT = true;
    this.bQA = 20;
    new ak().postDelayed(this.scW, 100L);
    AppMethodBeat.o(39891);
  }
  
  public final void cwK()
  {
    AppMethodBeat.i(39892);
    if (!this.scT)
    {
      AppMethodBeat.o(39892);
      return;
    }
    this.scT = false;
    new ak().postDelayed(this.scX, 30L);
    this.bQA = 10;
    AppMethodBeat.o(39892);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bf
 * JD-Core Version:    0.7.0.1
 */
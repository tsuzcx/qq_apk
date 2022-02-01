package com.tencent.mm.ui.chatting.d;

import android.content.Intent;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ss;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.ui.chatting.ae;
import com.tencent.mm.ui.chatting.d.b.ag;
import com.tencent.mm.ui.chatting.view.MMChattingListView;

@com.tencent.mm.ui.chatting.d.a.a(fFo=ag.class)
public class aq
  extends a
  implements ag
{
  private c<ss> JMp;
  long mYb;
  
  public aq()
  {
    AppMethodBeat.i(194090);
    this.JMp = new c() {};
    AppMethodBeat.o(194090);
  }
  
  public final void fCC()
  {
    AppMethodBeat.i(194093);
    super.fCC();
    com.tencent.mm.sdk.b.a.IbL.d(this.JMp);
    this.cWM.JOV = false;
    AppMethodBeat.o(194093);
  }
  
  public final void fws() {}
  
  public final void fwu()
  {
    AppMethodBeat.i(194091);
    com.tencent.mm.sdk.b.a.IbL.b(this.JMp);
    AppMethodBeat.o(194091);
  }
  
  public final void fww() {}
  
  public final void fwx()
  {
    AppMethodBeat.i(194092);
    com.tencent.mm.sdk.b.a.IbL.d(this.JMp);
    this.cWM.JOV = false;
    AppMethodBeat.o(194092);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(194094);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(194094);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.aq
 * JD-Core Version:    0.7.0.1
 */
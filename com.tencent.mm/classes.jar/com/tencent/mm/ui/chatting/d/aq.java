package com.tencent.mm.ui.chatting.d;

import android.content.Intent;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.st;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.ui.chatting.af;
import com.tencent.mm.ui.chatting.d.b.ag;
import com.tencent.mm.ui.chatting.view.MMChattingListView;

@com.tencent.mm.ui.chatting.d.a.a(fJv=ag.class)
public class aq
  extends a
  implements ag
{
  private c<st> Khl;
  long ndi;
  
  public aq()
  {
    AppMethodBeat.i(187399);
    this.Khl = new c() {};
    AppMethodBeat.o(187399);
  }
  
  public final void fAs() {}
  
  public final void fAu()
  {
    AppMethodBeat.i(187400);
    com.tencent.mm.sdk.b.a.IvT.b(this.Khl);
    AppMethodBeat.o(187400);
  }
  
  public final void fAw() {}
  
  public final void fAx()
  {
    AppMethodBeat.i(187401);
    com.tencent.mm.sdk.b.a.IvT.d(this.Khl);
    this.cXJ.Kkh = false;
    AppMethodBeat.o(187401);
  }
  
  public final void fGE()
  {
    AppMethodBeat.i(187402);
    super.fGE();
    com.tencent.mm.sdk.b.a.IvT.d(this.Khl);
    this.cXJ.Kkh = false;
    AppMethodBeat.o(187402);
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(187403);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(187403);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.aq
 * JD-Core Version:    0.7.0.1
 */
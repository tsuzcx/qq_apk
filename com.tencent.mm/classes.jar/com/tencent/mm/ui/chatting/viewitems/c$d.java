package com.tencent.mm.ui.chatting.viewitems;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.chatting.s.e;

public class c$d
  extends s.e
{
  private c zRE;
  
  public c$d(a parama, c paramc)
  {
    super(parama);
    this.zRE = paramc;
  }
  
  public void a(View paramView, a parama, bi parambi)
  {
    AppMethodBeat.i(32799);
    paramView.getTag();
    this.zRE.b(paramView, parama, parambi);
    AppMethodBeat.o(32799);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.c.d
 * JD-Core Version:    0.7.0.1
 */
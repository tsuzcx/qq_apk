package com.tencent.mm.ui.chatting.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.c;

public class ac
  extends a
  implements v
{
  private c hCe;
  
  public ac()
  {
    AppMethodBeat.i(31607);
    this.hCe = new ac.1(this);
    AppMethodBeat.o(31607);
  }
  
  private void dHr()
  {
    AppMethodBeat.i(31608);
    com.tencent.mm.sdk.b.a.ymk.d(this.hCe);
    AppMethodBeat.o(31608);
  }
  
  public final void dCa()
  {
    AppMethodBeat.i(31609);
    com.tencent.mm.sdk.b.a.ymk.c(this.hCe);
    AppMethodBeat.o(31609);
  }
  
  public final void dCd()
  {
    AppMethodBeat.i(31610);
    dHr();
    AppMethodBeat.o(31610);
  }
  
  public final void dHq()
  {
    AppMethodBeat.i(31611);
    super.dHq();
    dHr();
    AppMethodBeat.o(31611);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.ac
 * JD-Core Version:    0.7.0.1
 */
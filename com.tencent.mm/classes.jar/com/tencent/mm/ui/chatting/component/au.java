package com.tencent.mm.ui.chatting.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.sdk.event.IListener;

public class au
  extends a
  implements aj
{
  private IListener rDF;
  
  public au()
  {
    AppMethodBeat.i(35502);
    this.rDF = new MusicComponent.1(this, f.hfK);
    AppMethodBeat.o(35502);
  }
  
  public final void jjh()
  {
    AppMethodBeat.i(35504);
    this.rDF.alive();
    AppMethodBeat.o(35504);
  }
  
  public final void jjk()
  {
    AppMethodBeat.i(35503);
    this.rDF.dead();
    AppMethodBeat.o(35503);
  }
  
  public final void jqF()
  {
    AppMethodBeat.i(35506);
    super.jqF();
    this.rDF.dead();
    AppMethodBeat.o(35506);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.au
 * JD-Core Version:    0.7.0.1
 */
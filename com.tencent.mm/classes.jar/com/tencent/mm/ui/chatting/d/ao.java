package com.tencent.mm.ui.chatting.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mx;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;

public class ao
  extends a
  implements af
{
  private IListener lEl;
  
  public ao()
  {
    AppMethodBeat.i(35502);
    this.lEl = new IListener() {};
    AppMethodBeat.o(35502);
  }
  
  private void gOL()
  {
    AppMethodBeat.i(35503);
    EventCenter.instance.removeListener(this.lEl);
    AppMethodBeat.o(35503);
  }
  
  public final void gIm()
  {
    AppMethodBeat.i(35504);
    EventCenter.instance.addListener(this.lEl);
    AppMethodBeat.o(35504);
  }
  
  public final void gIn()
  {
    AppMethodBeat.i(35505);
    gOL();
    AppMethodBeat.o(35505);
  }
  
  public final void gOK()
  {
    AppMethodBeat.i(35506);
    super.gOK();
    gOL();
    AppMethodBeat.o(35506);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.ao
 * JD-Core Version:    0.7.0.1
 */
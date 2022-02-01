package com.tencent.mm.ui.chatting.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.np;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;

public class aq
  extends a
  implements ag
{
  private IListener ozM;
  
  public aq()
  {
    AppMethodBeat.i(35502);
    this.ozM = new IListener() {};
    AppMethodBeat.o(35502);
  }
  
  private void hOa()
  {
    AppMethodBeat.i(35503);
    EventCenter.instance.removeListener(this.ozM);
    AppMethodBeat.o(35503);
  }
  
  public final void hGW()
  {
    AppMethodBeat.i(35504);
    EventCenter.instance.addListener(this.ozM);
    AppMethodBeat.o(35504);
  }
  
  public final void hGZ()
  {
    AppMethodBeat.i(35505);
    hOa();
    AppMethodBeat.o(35505);
  }
  
  public final void hNZ()
  {
    AppMethodBeat.i(35506);
    super.hNZ();
    hOa();
    AppMethodBeat.o(35506);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.aq
 * JD-Core Version:    0.7.0.1
 */
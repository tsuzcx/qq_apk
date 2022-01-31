package com.tencent.mm.ui.chatting.c.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.t;
import com.tencent.mm.sdk.platformtools.bo;

public final class b
  extends com.tencent.mm.ui.chatting.c.a
  implements com.tencent.mm.ui.chatting.c.b.a
{
  private a zJu;
  
  public b(a parama)
  {
    this.zJu = parama;
  }
  
  private boolean dJB()
  {
    AppMethodBeat.i(31910);
    if (bo.isNullOrNil(this.caz.getTalkerUserName()))
    {
      AppMethodBeat.o(31910);
      return false;
    }
    if (t.oC(this.caz.getTalkerUserName()))
    {
      AppMethodBeat.o(31910);
      return false;
    }
    if (this.zJu != null)
    {
      AppMethodBeat.o(31910);
      return true;
    }
    AppMethodBeat.o(31910);
    return false;
  }
  
  public final void a(com.tencent.mm.ui.chatting.d.a parama)
  {
    AppMethodBeat.i(31898);
    super.a(parama);
    if (this.zJu != null) {
      this.zJu.a(parama);
    }
    AppMethodBeat.o(31898);
  }
  
  public final void dBY()
  {
    AppMethodBeat.i(31900);
    if (dJB()) {
      this.zJu.dBY();
    }
    AppMethodBeat.o(31900);
  }
  
  public final void dBZ()
  {
    AppMethodBeat.i(31901);
    if (dJB()) {
      this.zJu.dBZ();
    }
    AppMethodBeat.o(31901);
  }
  
  public final void dCa()
  {
    AppMethodBeat.i(31902);
    if (dJB()) {
      this.zJu.dCa();
    }
    AppMethodBeat.o(31902);
  }
  
  public final void dCb()
  {
    AppMethodBeat.i(31903);
    if (dJB()) {
      this.zJu.dCb();
    }
    AppMethodBeat.o(31903);
  }
  
  public final void dCc()
  {
    AppMethodBeat.i(31904);
    if (dJB()) {
      this.zJu.dCc();
    }
    AppMethodBeat.o(31904);
  }
  
  public final void dCd()
  {
    AppMethodBeat.i(31905);
    if (dJB()) {
      this.zJu.dCd();
    }
    AppMethodBeat.o(31905);
  }
  
  public final void dCe()
  {
    AppMethodBeat.i(31906);
    if (dJB()) {
      this.zJu.dCe();
    }
    AppMethodBeat.o(31906);
  }
  
  public final void dHq()
  {
    AppMethodBeat.i(31899);
    super.dHq();
    if (this.zJu != null) {
      this.zJu.dHq();
    }
    AppMethodBeat.o(31899);
  }
  
  public final void dIv()
  {
    AppMethodBeat.i(31907);
    if (dJB()) {
      this.zJu.dIv();
    }
    AppMethodBeat.o(31907);
  }
  
  public final String dJA()
  {
    AppMethodBeat.i(31909);
    if (dJB())
    {
      String str = this.zJu.dJA();
      AppMethodBeat.o(31909);
      return str;
    }
    AppMethodBeat.o(31909);
    return null;
  }
  
  public final void dJz()
  {
    AppMethodBeat.i(31908);
    if (dJB()) {
      this.zJu.dJz();
    }
    AppMethodBeat.o(31908);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.c.b
 * JD-Core Version:    0.7.0.1
 */
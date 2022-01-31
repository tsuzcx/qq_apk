package com.tencent.mm.plugin.webview.luggage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.b.l;
import com.tencent.mm.ui.widget.d;

public class o
{
  d uSM;
  e uSb;
  l uSv;
  
  public o(e parame, l paraml)
  {
    AppMethodBeat.i(6221);
    this.uSb = parame;
    this.uSv = paraml;
    this.uSM = new d(this.uSb.mContext, 0, false);
    this.uSM.sao = new o.1(this);
    this.uSM.sap = new o.2(this);
    this.uSM.crd();
    AppMethodBeat.o(6221);
  }
  
  public final void dbu()
  {
    AppMethodBeat.i(6222);
    if (this.uSM != null) {
      this.uSM.cre();
    }
    AppMethodBeat.o(6222);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.o
 * JD-Core Version:    0.7.0.1
 */
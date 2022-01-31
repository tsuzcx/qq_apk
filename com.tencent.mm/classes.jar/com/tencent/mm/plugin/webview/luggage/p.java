package com.tencent.mm.plugin.webview.luggage;

import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.widget.c;

public class p
{
  com.tencent.mm.plugin.webview.luggage.b.l rcH;
  c rcQ;
  e rcp;
  
  public p(e parame, com.tencent.mm.plugin.webview.luggage.b.l paraml)
  {
    this.rcp = parame;
    this.rcH = paraml;
    this.rcQ = new c(this.rcp.mContext, 0, false);
    this.rcQ.phH = new n.c()
    {
      public final void a(com.tencent.mm.ui.base.l paramAnonymousl)
      {
        p localp = p.this;
        localp.rcH.b(localp.rcp.mContext, localp.rcp, paramAnonymousl);
      }
    };
    this.rcQ.phI = new p.2(this);
    this.rcQ.cfU();
  }
  
  public final void cbq()
  {
    if (this.rcQ != null) {
      this.rcQ.bFp();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.p
 * JD-Core Version:    0.7.0.1
 */
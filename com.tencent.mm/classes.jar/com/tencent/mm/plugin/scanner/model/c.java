package com.tencent.mm.plugin.scanner.model;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cl;
import com.tencent.mm.g.a.qf;
import com.tencent.mm.plugin.scanner.d.e.a;
import com.tencent.mm.plugin.scanner.util.a;

public final class c
{
  Activity mActivity;
  String wYM;
  com.tencent.mm.plugin.scanner.util.c wYN;
  a wYO;
  e.a wYP;
  public com.tencent.mm.sdk.b.c wYQ;
  public com.tencent.mm.sdk.b.c wYR;
  public com.tencent.mm.sdk.b.c wYS;
  
  public c()
  {
    AppMethodBeat.i(51615);
    this.wYP = new c.1(this);
    this.wYQ = new com.tencent.mm.sdk.b.c() {};
    this.wYR = new c.3(this);
    this.wYS = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(51615);
  }
  
  public final void dzs()
  {
    AppMethodBeat.i(51616);
    if (this.wYN != null)
    {
      this.wYN.dBn();
      this.wYN = null;
    }
    this.mActivity = null;
    this.wYM = null;
    AppMethodBeat.o(51616);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.model.c
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.selectrecord.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.gf;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
{
  public static b CXe = null;
  public gf CXf;
  
  public b()
  {
    AppMethodBeat.i(187916);
    this.CXf = null;
    this.CXf = new gf();
    AppMethodBeat.o(187916);
  }
  
  public static void eSA()
  {
    AppMethodBeat.i(187915);
    CXe = new b();
    AppMethodBeat.o(187915);
  }
  
  public static b eSz()
  {
    AppMethodBeat.i(187914);
    if (CXe == null) {
      eSA();
    }
    b localb = CXe;
    AppMethodBeat.o(187914);
    return localb;
  }
  
  public final void IH(long paramLong)
  {
    this.CXf.eJh = paramLong;
  }
  
  public final void Xk(int paramInt)
  {
    AppMethodBeat.i(187917);
    gf localgf = this.CXf;
    localgf.eJg = localgf.x("HasConfirmed", String.valueOf(paramInt), true);
    AppMethodBeat.o(187917);
  }
  
  public final boolean bfK()
  {
    AppMethodBeat.i(187919);
    this.CXf.eJl = 1L;
    Log.d("MicroMsg.MultiMessageForwardReportManager", "%s", new Object[] { this.CXf.abW() });
    boolean bool = this.CXf.bfK();
    AppMethodBeat.o(187919);
    return bool;
  }
  
  public final boolean eSB()
  {
    AppMethodBeat.i(187918);
    Xk(2);
    boolean bool = bfK();
    AppMethodBeat.o(187918);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.selectrecord.b.b
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.selectrecord.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.dk;
import com.tencent.mm.sdk.platformtools.ae;

public final class b
{
  public static b ySo = null;
  public dk ySp;
  
  public b()
  {
    AppMethodBeat.i(193994);
    this.ySp = null;
    this.ySp = new dk();
    AppMethodBeat.o(193994);
  }
  
  public static b dQy()
  {
    AppMethodBeat.i(193992);
    if (ySo == null) {
      dQz();
    }
    b localb = ySo;
    AppMethodBeat.o(193992);
    return localb;
  }
  
  public static void dQz()
  {
    AppMethodBeat.i(193993);
    ySo = new b();
    AppMethodBeat.o(193993);
  }
  
  public final void PG(int paramInt)
  {
    AppMethodBeat.i(193995);
    dk localdk = this.ySp;
    localdk.ehn = localdk.t("HasConfirmed", String.valueOf(paramInt), true);
    AppMethodBeat.o(193995);
  }
  
  public final boolean aLH()
  {
    AppMethodBeat.i(193997);
    this.ySp.ehs = 1L;
    ae.d("MicroMsg.MultiMessageForwardReportManager", "%s", new Object[] { this.ySp.RD() });
    boolean bool = this.ySp.aLH();
    AppMethodBeat.o(193997);
    return bool;
  }
  
  public final boolean dQA()
  {
    AppMethodBeat.i(193996);
    PG(2);
    boolean bool = aLH();
    AppMethodBeat.o(193996);
    return bool;
  }
  
  public final void zD(long paramLong)
  {
    this.ySp.eho = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.selectrecord.b.b
 * JD-Core Version:    0.7.0.1
 */
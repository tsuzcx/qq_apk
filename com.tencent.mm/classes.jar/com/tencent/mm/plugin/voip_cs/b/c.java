package com.tencent.mm.plugin.voip_cs.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.q;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;

public class c
  implements at
{
  private static c tJH = null;
  private com.tencent.mm.plugin.voip_cs.b.b.a tJI;
  private e tJJ;
  private d tJK;
  private com.tencent.mm.plugin.voip_cs.a.a tJL;
  private com.tencent.mm.sdk.b.c tJM;
  
  public c()
  {
    AppMethodBeat.i(135290);
    this.tJI = new com.tencent.mm.plugin.voip_cs.b.b.a();
    this.tJJ = new e();
    this.tJK = new d();
    this.tJL = new com.tencent.mm.plugin.voip_cs.a.a();
    this.tJM = new c.1(this);
    AppMethodBeat.o(135290);
  }
  
  private static c cQl()
  {
    AppMethodBeat.i(135291);
    c localc = (c)q.S(c.class);
    AppMethodBeat.o(135291);
    return localc;
  }
  
  public static com.tencent.mm.plugin.voip_cs.b.b.a cQm()
  {
    AppMethodBeat.i(135292);
    com.tencent.mm.plugin.voip_cs.b.b.a locala = cQl().tJI;
    AppMethodBeat.o(135292);
    return locala;
  }
  
  public static e cQn()
  {
    AppMethodBeat.i(135293);
    g.RJ().QQ();
    if (cQl().tJJ == null) {
      cQl().tJJ = new e();
    }
    e locale = cQl().tJJ;
    AppMethodBeat.o(135293);
    return locale;
  }
  
  public static d cQo()
  {
    AppMethodBeat.i(135294);
    d locald = cQl().tJK;
    AppMethodBeat.o(135294);
    return locald;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.d> getBaseDBFactories()
  {
    return null;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(135295);
    ab.d("MicroMsg.SubCoreVoipCS", "now account reset!");
    com.tencent.mm.sdk.b.a.ymk.c(this.tJL);
    com.tencent.mm.sdk.b.a.ymk.c(this.tJM);
    AppMethodBeat.o(135295);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(135296);
    com.tencent.mm.sdk.b.a.ymk.d(this.tJL);
    com.tencent.mm.sdk.b.a.ymk.d(this.tJM);
    AppMethodBeat.o(135296);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.b.c
 * JD-Core Version:    0.7.0.1
 */
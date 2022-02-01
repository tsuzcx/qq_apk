package com.tencent.mm.plugin.voip_cs.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class c
  implements az
{
  private static c CLO = null;
  private com.tencent.mm.plugin.voip_cs.c.b.a CLP;
  private e CLQ;
  private d CLS;
  private com.tencent.mm.plugin.voip_cs.b.a CLT;
  private com.tencent.mm.sdk.b.c CLU;
  
  public c()
  {
    AppMethodBeat.i(125342);
    this.CLP = new com.tencent.mm.plugin.voip_cs.c.b.a();
    this.CLQ = new e();
    this.CLS = new d();
    this.CLT = new com.tencent.mm.plugin.voip_cs.b.a();
    this.CLU = new c.1(this);
    AppMethodBeat.o(125342);
  }
  
  private static c eFi()
  {
    AppMethodBeat.i(125343);
    c localc = (c)u.ap(c.class);
    AppMethodBeat.o(125343);
    return localc;
  }
  
  public static com.tencent.mm.plugin.voip_cs.c.b.a eFj()
  {
    AppMethodBeat.i(125344);
    com.tencent.mm.plugin.voip_cs.c.b.a locala = eFi().CLP;
    AppMethodBeat.o(125344);
    return locala;
  }
  
  public static e eFk()
  {
    AppMethodBeat.i(125345);
    g.ajP().aiU();
    if (eFi().CLQ == null) {
      eFi().CLQ = new e();
    }
    e locale = eFi().CLQ;
    AppMethodBeat.o(125345);
    return locale;
  }
  
  public static d eFl()
  {
    AppMethodBeat.i(125346);
    d locald = eFi().CLS;
    AppMethodBeat.o(125346);
    return locald;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(125347);
    ae.d("MicroMsg.SubCoreVoipCS", "now account reset!");
    com.tencent.mm.sdk.b.a.IvT.c(this.CLT);
    com.tencent.mm.sdk.b.a.IvT.c(this.CLU);
    AppMethodBeat.o(125347);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(125348);
    com.tencent.mm.sdk.b.a.IvT.d(this.CLT);
    com.tencent.mm.sdk.b.a.IvT.d(this.CLU);
    AppMethodBeat.o(125348);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.c.c
 * JD-Core Version:    0.7.0.1
 */
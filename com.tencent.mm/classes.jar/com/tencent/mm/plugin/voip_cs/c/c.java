package com.tencent.mm.plugin.voip_cs.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.t;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class c
  implements ax
{
  private static c Cuk = null;
  private com.tencent.mm.plugin.voip_cs.c.b.a Cul;
  private e Cum;
  private d Cun;
  private com.tencent.mm.plugin.voip_cs.b.a Cuo;
  private com.tencent.mm.sdk.b.c Cup;
  
  public c()
  {
    AppMethodBeat.i(125342);
    this.Cul = new com.tencent.mm.plugin.voip_cs.c.b.a();
    this.Cum = new e();
    this.Cun = new d();
    this.Cuo = new com.tencent.mm.plugin.voip_cs.b.a();
    this.Cup = new c.1(this);
    AppMethodBeat.o(125342);
  }
  
  private static c eBA()
  {
    AppMethodBeat.i(125343);
    c localc = (c)t.ap(c.class);
    AppMethodBeat.o(125343);
    return localc;
  }
  
  public static com.tencent.mm.plugin.voip_cs.c.b.a eBB()
  {
    AppMethodBeat.i(125344);
    com.tencent.mm.plugin.voip_cs.c.b.a locala = eBA().Cul;
    AppMethodBeat.o(125344);
    return locala;
  }
  
  public static e eBC()
  {
    AppMethodBeat.i(125345);
    g.ajA().aiF();
    if (eBA().Cum == null) {
      eBA().Cum = new e();
    }
    e locale = eBA().Cum;
    AppMethodBeat.o(125345);
    return locale;
  }
  
  public static d eBD()
  {
    AppMethodBeat.i(125346);
    d locald = eBA().Cun;
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
    ad.d("MicroMsg.SubCoreVoipCS", "now account reset!");
    com.tencent.mm.sdk.b.a.IbL.c(this.Cuo);
    com.tencent.mm.sdk.b.a.IbL.c(this.Cup);
    AppMethodBeat.o(125347);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(125348);
    com.tencent.mm.sdk.b.a.IbL.d(this.Cuo);
    com.tencent.mm.sdk.b.a.IbL.d(this.Cup);
    AppMethodBeat.o(125348);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.c.c
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.voip_cs.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.bp;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.t;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class c
  implements aw
{
  private static c zBO = null;
  private com.tencent.mm.plugin.voip_cs.c.b.a zBP;
  private e zBQ;
  private d zBR;
  private com.tencent.mm.plugin.voip_cs.b.a zBS;
  private com.tencent.mm.sdk.b.c zBT;
  
  public c()
  {
    AppMethodBeat.i(125342);
    this.zBP = new com.tencent.mm.plugin.voip_cs.c.b.a();
    this.zBQ = new e();
    this.zBR = new d();
    this.zBS = new com.tencent.mm.plugin.voip_cs.b.a();
    this.zBT = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(125342);
  }
  
  private static c dYf()
  {
    AppMethodBeat.i(125343);
    c localc = (c)t.ap(c.class);
    AppMethodBeat.o(125343);
    return localc;
  }
  
  public static com.tencent.mm.plugin.voip_cs.c.b.a dYg()
  {
    AppMethodBeat.i(125344);
    com.tencent.mm.plugin.voip_cs.c.b.a locala = dYf().zBP;
    AppMethodBeat.o(125344);
    return locala;
  }
  
  public static e dYh()
  {
    AppMethodBeat.i(125345);
    g.afz().aeD();
    if (dYf().zBQ == null) {
      dYf().zBQ = new e();
    }
    e locale = dYf().zBQ;
    AppMethodBeat.o(125345);
    return locale;
  }
  
  public static d dYi()
  {
    AppMethodBeat.i(125346);
    d locald = dYf().zBR;
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
    com.tencent.mm.sdk.b.a.ESL.c(this.zBS);
    com.tencent.mm.sdk.b.a.ESL.c(this.zBT);
    AppMethodBeat.o(125347);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(125348);
    com.tencent.mm.sdk.b.a.ESL.d(this.zBS);
    com.tencent.mm.sdk.b.a.ESL.d(this.zBT);
    AppMethodBeat.o(125348);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.c.c
 * JD-Core Version:    0.7.0.1
 */
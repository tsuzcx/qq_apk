package com.tencent.mm.plugin.voip_cs.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.t;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class c
  implements aw
{
  private static c AUc = null;
  private com.tencent.mm.plugin.voip_cs.c.b.a AUd;
  private e AUe;
  private d AUf;
  private com.tencent.mm.plugin.voip_cs.b.a AUg;
  private com.tencent.mm.sdk.b.c AUh;
  
  public c()
  {
    AppMethodBeat.i(125342);
    this.AUd = new com.tencent.mm.plugin.voip_cs.c.b.a();
    this.AUe = new e();
    this.AUf = new d();
    this.AUg = new com.tencent.mm.plugin.voip_cs.b.a();
    this.AUh = new c.1(this);
    AppMethodBeat.o(125342);
  }
  
  private static c enB()
  {
    AppMethodBeat.i(125343);
    c localc = (c)t.ap(c.class);
    AppMethodBeat.o(125343);
    return localc;
  }
  
  public static com.tencent.mm.plugin.voip_cs.c.b.a enC()
  {
    AppMethodBeat.i(125344);
    com.tencent.mm.plugin.voip_cs.c.b.a locala = enB().AUd;
    AppMethodBeat.o(125344);
    return locala;
  }
  
  public static e enD()
  {
    AppMethodBeat.i(125345);
    g.agP().afT();
    if (enB().AUe == null) {
      enB().AUe = new e();
    }
    e locale = enB().AUe;
    AppMethodBeat.o(125345);
    return locale;
  }
  
  public static d enE()
  {
    AppMethodBeat.i(125346);
    d locald = enB().AUf;
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
    ac.d("MicroMsg.SubCoreVoipCS", "now account reset!");
    com.tencent.mm.sdk.b.a.GpY.c(this.AUg);
    com.tencent.mm.sdk.b.a.GpY.c(this.AUh);
    AppMethodBeat.o(125347);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(125348);
    com.tencent.mm.sdk.b.a.GpY.d(this.AUg);
    com.tencent.mm.sdk.b.a.GpY.d(this.AUh);
    AppMethodBeat.o(125348);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.c.c
 * JD-Core Version:    0.7.0.1
 */
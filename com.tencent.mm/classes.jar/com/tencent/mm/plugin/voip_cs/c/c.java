package com.tencent.mm.plugin.voip_cs.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.be;
import com.tencent.mm.model.y;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class c
  implements be
{
  private static c Oiq = null;
  private com.tencent.mm.plugin.voip_cs.c.b.a Oir;
  private e Ois;
  private d Oit;
  private com.tencent.mm.plugin.voip_cs.b.a Oiu;
  private IListener Oiv;
  
  public c()
  {
    AppMethodBeat.i(125342);
    this.Oir = new com.tencent.mm.plugin.voip_cs.c.b.a();
    this.Ois = new e();
    this.Oit = new d();
    this.Oiu = new com.tencent.mm.plugin.voip_cs.b.a();
    this.Oiv = new c.1(this);
    AppMethodBeat.o(125342);
  }
  
  private static c gEU()
  {
    AppMethodBeat.i(125343);
    c localc = (c)y.as(c.class);
    AppMethodBeat.o(125343);
    return localc;
  }
  
  public static com.tencent.mm.plugin.voip_cs.c.b.a gEV()
  {
    AppMethodBeat.i(125344);
    com.tencent.mm.plugin.voip_cs.c.b.a locala = gEU().Oir;
    AppMethodBeat.o(125344);
    return locala;
  }
  
  public static e gEW()
  {
    AppMethodBeat.i(125345);
    h.aHE().aGH();
    if (gEU().Ois == null) {
      gEU().Ois = new e();
    }
    e locale = gEU().Ois;
    AppMethodBeat.o(125345);
    return locale;
  }
  
  public static d gEX()
  {
    AppMethodBeat.i(125346);
    d locald = gEU().Oit;
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
    Log.d("MicroMsg.SubCoreVoipCS", "now account reset!");
    EventCenter.instance.addListener(this.Oiu);
    EventCenter.instance.addListener(this.Oiv);
    AppMethodBeat.o(125347);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(125348);
    EventCenter.instance.removeListener(this.Oiu);
    EventCenter.instance.removeListener(this.Oiv);
    AppMethodBeat.o(125348);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.c.c
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.voip_cs.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.y;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class c
  implements bd
{
  private static c HqF = null;
  private com.tencent.mm.plugin.voip_cs.c.b.a HqG;
  private e HqH;
  private d HqI;
  private com.tencent.mm.plugin.voip_cs.b.a HqJ;
  private IListener HqK;
  
  public c()
  {
    AppMethodBeat.i(125342);
    this.HqG = new com.tencent.mm.plugin.voip_cs.c.b.a();
    this.HqH = new e();
    this.HqI = new d();
    this.HqJ = new com.tencent.mm.plugin.voip_cs.b.a();
    this.HqK = new c.1(this);
    AppMethodBeat.o(125342);
  }
  
  private static c fMq()
  {
    AppMethodBeat.i(125343);
    c localc = (c)y.at(c.class);
    AppMethodBeat.o(125343);
    return localc;
  }
  
  public static com.tencent.mm.plugin.voip_cs.c.b.a fMr()
  {
    AppMethodBeat.i(125344);
    com.tencent.mm.plugin.voip_cs.c.b.a locala = fMq().HqG;
    AppMethodBeat.o(125344);
    return locala;
  }
  
  public static e fMs()
  {
    AppMethodBeat.i(125345);
    g.aAf().azk();
    if (fMq().HqH == null) {
      fMq().HqH = new e();
    }
    e locale = fMq().HqH;
    AppMethodBeat.o(125345);
    return locale;
  }
  
  public static d fMt()
  {
    AppMethodBeat.i(125346);
    d locald = fMq().HqI;
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
    EventCenter.instance.addListener(this.HqJ);
    EventCenter.instance.addListener(this.HqK);
    AppMethodBeat.o(125347);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(125348);
    EventCenter.instance.removeListener(this.HqJ);
    EventCenter.instance.removeListener(this.HqK);
    AppMethodBeat.o(125348);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.c.c
 * JD-Core Version:    0.7.0.1
 */
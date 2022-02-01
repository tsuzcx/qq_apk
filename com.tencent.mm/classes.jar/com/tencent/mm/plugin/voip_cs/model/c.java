package com.tencent.mm.plugin.voip_cs.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.be;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.voip_cs.listener.VoipCSEventListener;
import com.tencent.mm.plugin.voip_cs.model.b.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class c
  implements be
{
  private static c UWL = null;
  private a UWM;
  private e UWN;
  private d UWO;
  private VoipCSEventListener UWP;
  private IListener UWQ;
  
  public c()
  {
    AppMethodBeat.i(125342);
    this.UWM = new a();
    this.UWN = new e();
    this.UWO = new d();
    this.UWP = new VoipCSEventListener();
    this.UWQ = new SubCoreVoipCS.1(this, f.hfK);
    AppMethodBeat.o(125342);
  }
  
  private static c idV()
  {
    AppMethodBeat.i(125343);
    c localc = (c)y.aL(c.class);
    AppMethodBeat.o(125343);
    return localc;
  }
  
  public static a idW()
  {
    AppMethodBeat.i(125344);
    a locala = idV().UWM;
    AppMethodBeat.o(125344);
    return locala;
  }
  
  public static e idX()
  {
    AppMethodBeat.i(125345);
    h.baC().aZJ();
    if (idV().UWN == null) {
      idV().UWN = new e();
    }
    e locale = idV().UWN;
    AppMethodBeat.o(125345);
    return locale;
  }
  
  public static d idY()
  {
    AppMethodBeat.i(125346);
    d locald = idV().UWO;
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
    this.UWP.alive();
    this.UWQ.alive();
    AppMethodBeat.o(125347);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(125348);
    this.UWP.dead();
    this.UWQ.dead();
    AppMethodBeat.o(125348);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip_cs.model.c
 * JD-Core Version:    0.7.0.1
 */
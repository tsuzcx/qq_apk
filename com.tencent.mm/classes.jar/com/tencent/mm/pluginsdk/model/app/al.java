package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e.d;
import com.tencent.mm.app.j.a;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bw;
import com.tencent.mm.pluginsdk.model.b;
import java.util.HashMap;

public class al
  implements at
{
  private static HashMap<Integer, h.d> baseDBFactories;
  private j.a appForegroundListener;
  private o vLV;
  private ak.a vLW;
  private j vLX;
  private b vLY;
  private com.tencent.mm.sdk.b.c vLZ;
  private com.tencent.mm.sdk.b.c vMa;
  
  static
  {
    AppMethodBeat.i(27432);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("APPMESSAGE_TABLE".hashCode()), new al.1());
    baseDBFactories.put(Integer.valueOf("APPSORT_TABLE".hashCode()), new al.2());
    AppMethodBeat.o(27432);
  }
  
  public al()
  {
    AppMethodBeat.i(27419);
    this.vLW = null;
    this.vLX = new j();
    this.vLY = new b();
    this.appForegroundListener = new al.4(this);
    this.vLZ = new al.5(this);
    this.vMa = new al.6(this);
    AppMethodBeat.o(27419);
  }
  
  public static c aUJ()
  {
    AppMethodBeat.i(27422);
    c localc = com.tencent.mm.plugin.s.a.aUJ();
    AppMethodBeat.o(27422);
    return localc;
  }
  
  public static h cab()
  {
    AppMethodBeat.i(27423);
    h localh = com.tencent.mm.plugin.s.a.cab();
    AppMethodBeat.o(27423);
    return localh;
  }
  
  public static i cac()
  {
    AppMethodBeat.i(27424);
    i locali = com.tencent.mm.plugin.s.a.cac();
    AppMethodBeat.o(27424);
    return locali;
  }
  
  public static m cae()
  {
    AppMethodBeat.i(27428);
    m localm = com.tencent.mm.plugin.s.a.cae();
    AppMethodBeat.o(27428);
    return localm;
  }
  
  public static d caf()
  {
    AppMethodBeat.i(27429);
    d locald = com.tencent.mm.plugin.s.a.caf();
    AppMethodBeat.o(27429);
    return locald;
  }
  
  private static al dlJ()
  {
    AppMethodBeat.i(27420);
    aw.aat();
    al localal2 = (al)bw.pF(al.class.getName());
    al localal1 = localal2;
    if (localal2 == null) {
      localal1 = new al();
    }
    AppMethodBeat.o(27420);
    return localal1;
  }
  
  public static j dlK()
  {
    AppMethodBeat.i(27421);
    j localj = dlJ().vLX;
    AppMethodBeat.o(27421);
    return localj;
  }
  
  public static k dlL()
  {
    AppMethodBeat.i(27425);
    k localk = com.tencent.mm.plugin.s.a.cad();
    AppMethodBeat.o(27425);
    return localk;
  }
  
  public static o dlM()
  {
    AppMethodBeat.i(27426);
    g.RJ().QQ();
    if (dlJ().vLV == null)
    {
      localObject = dlJ();
      aw.aaz();
      ((al)localObject).vLV = new o(com.tencent.mm.model.c.Rq());
    }
    Object localObject = dlJ().vLV;
    AppMethodBeat.o(27426);
    return localObject;
  }
  
  public static ak.a dlN()
  {
    AppMethodBeat.i(27427);
    g.RJ().QQ();
    if (dlJ().vLW == null) {
      dlJ().vLW = new ak.a();
    }
    ak.a locala = dlJ().vLW;
    AppMethodBeat.o(27427);
    return locala;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.d> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(27431);
    com.tencent.mm.model.ad.a.flG = com.tencent.mm.plugin.s.a.cab();
    e.d.a(Integer.valueOf(47), this.vLY);
    e.d.a(Integer.valueOf(49), this.vLX);
    com.tencent.mm.sdk.b.a.ymk.c(this.vLZ);
    com.tencent.mm.sdk.b.a.ymk.c(this.vMa);
    this.appForegroundListener.alive();
    al.3 local3 = new al.3(this);
    try
    {
      local3.run();
      AppMethodBeat.o(27431);
      return;
    }
    catch (Throwable localThrowable)
    {
      if (com.tencent.mm.compatible.util.d.fw(20))
      {
        local3.run();
        AppMethodBeat.o(27431);
        return;
      }
      AppMethodBeat.o(27431);
      throw localThrowable;
    }
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(27430);
    ak.a locala = dlJ().vLW;
    if (locala != null) {
      locala.ckM = 0;
    }
    e.d.b(Integer.valueOf(47), this.vLY);
    e.d.b(Integer.valueOf(49), this.vLX);
    this.appForegroundListener.dead();
    com.tencent.mm.sdk.b.a.ymk.d(this.vLZ);
    com.tencent.mm.sdk.b.a.ymk.d(this.vMa);
    com.tencent.mm.pluginsdk.model.j.dlc();
    AppMethodBeat.o(27430);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.model.app.al
 * JD-Core Version:    0.7.0.1
 */
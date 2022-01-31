package com.tencent.mm.plugin.s;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.s.a.a.a;
import com.tencent.mm.pluginsdk.model.app.d;
import com.tencent.mm.pluginsdk.model.app.d.3;
import com.tencent.mm.pluginsdk.model.app.i;
import com.tencent.mm.pluginsdk.model.app.k;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.pluginsdk.model.app.t;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class a
  implements com.tencent.mm.kernel.api.bucket.a, com.tencent.mm.kernel.api.bucket.b, com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.kernel.api.e, com.tencent.mm.kernel.b.c
{
  private static HashMap<Integer, h.d> baseDBFactories;
  private static volatile a pou;
  private m poA;
  private d poB;
  private com.tencent.mm.sdk.b.c poC;
  private com.tencent.mm.pluginsdk.model.app.c pov;
  private com.tencent.mm.pluginsdk.model.app.e pow;
  private com.tencent.mm.pluginsdk.model.app.h pox;
  private i poy;
  private k poz;
  
  static
  {
    AppMethodBeat.i(79144);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("APPATTACHINFO_TABLE".hashCode()), new a.2());
    baseDBFactories.put(Integer.valueOf("APPINFO_TABLE".hashCode()), new a.3());
    AppMethodBeat.o(79144);
  }
  
  private a()
  {
    AppMethodBeat.i(79130);
    this.poC = new a.4(this);
    a.a.a(new a.1(this));
    AppMethodBeat.o(79130);
  }
  
  public static com.tencent.mm.pluginsdk.model.app.c aUJ()
  {
    AppMethodBeat.i(79134);
    g.RJ().QQ();
    if (bZY().pov == null) {
      bZY().pov = new com.tencent.mm.pluginsdk.model.app.c(g.RL().eHS);
    }
    com.tencent.mm.pluginsdk.model.app.c localc = bZY().pov;
    AppMethodBeat.o(79134);
    return localc;
  }
  
  public static a bZY()
  {
    AppMethodBeat.i(79131);
    if (pou == null) {}
    try
    {
      if (pou == null) {
        pou = new a();
      }
      a locala = pou;
      AppMethodBeat.o(79131);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(79131);
    }
  }
  
  public static String bZZ()
  {
    AppMethodBeat.i(79133);
    String str = g.RL().eHR + "openapi/";
    AppMethodBeat.o(79133);
    return str;
  }
  
  public static com.tencent.mm.pluginsdk.model.app.e caa()
  {
    AppMethodBeat.i(79135);
    g.RJ().QQ();
    if (bZY().pow == null) {
      bZY().pow = new com.tencent.mm.pluginsdk.model.app.e();
    }
    com.tencent.mm.pluginsdk.model.app.e locale = bZY().pow;
    AppMethodBeat.o(79135);
    return locale;
  }
  
  public static com.tencent.mm.pluginsdk.model.app.h cab()
  {
    AppMethodBeat.i(79136);
    g.RJ().QQ();
    if (bZY().pox == null) {
      bZY().pox = new com.tencent.mm.pluginsdk.model.app.h();
    }
    com.tencent.mm.pluginsdk.model.app.h localh = bZY().pox;
    AppMethodBeat.o(79136);
    return localh;
  }
  
  public static i cac()
  {
    AppMethodBeat.i(79137);
    g.RJ().QQ();
    if (bZY().poy == null) {
      bZY().poy = new i(g.RL().eHS);
    }
    i locali = bZY().poy;
    AppMethodBeat.o(79137);
    return locali;
  }
  
  public static k cad()
  {
    AppMethodBeat.i(79138);
    g.RJ().QQ();
    if (bZY().poz == null) {
      bZY().poz = new k(g.RL().eHS);
    }
    k localk = bZY().poz;
    AppMethodBeat.o(79138);
    return localk;
  }
  
  public static m cae()
  {
    AppMethodBeat.i(79139);
    g.RJ().QQ();
    if (bZY().poA == null) {
      bZY().poA = new m();
    }
    m localm = bZY().poA;
    AppMethodBeat.o(79139);
    return localm;
  }
  
  public static d caf()
  {
    AppMethodBeat.i(79140);
    g.RJ().QQ();
    if (bZY().poB == null) {
      bZY().poB = new d();
    }
    d locald = bZY().poB;
    AppMethodBeat.o(79140);
    return locald;
  }
  
  public final List<String> RR()
  {
    AppMethodBeat.i(79132);
    LinkedList localLinkedList = new LinkedList();
    Collections.addAll(localLinkedList, new String[] { "openapi/" });
    AppMethodBeat.o(79132);
    return localLinkedList;
  }
  
  public HashMap<Integer, h.d> collectDatabaseFactory()
  {
    return baseDBFactories;
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(79141);
    com.tencent.mm.model.ad.a.flG = cab();
    com.tencent.mm.sdk.b.a.ymk.c(this.poC);
    AppMethodBeat.o(79141);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(79142);
    Object localObject = bZY().pox;
    if (localObject != null) {
      caf().b(7, (t)localObject);
    }
    localObject = bZY().pow;
    if (localObject != null)
    {
      ((com.tencent.mm.pluginsdk.model.app.e)localObject).vKU.clear();
      ((com.tencent.mm.pluginsdk.model.app.e)localObject).qKd.clear();
      ((com.tencent.mm.pluginsdk.model.app.e)localObject).hqI.clear();
    }
    localObject = bZY().poA;
    if (localObject != null)
    {
      ab.d("MicroMsg.AppSettingService", "stop service");
      ((m)localObject).vLr.clear();
      caf().b(1, (t)localObject);
    }
    if (this.poB != null)
    {
      localObject = this.poB;
      g.RK().eHt.b(452, (com.tencent.mm.ai.f)localObject);
      al.d(new d.3((d)localObject));
    }
    if (bZY().poy != null) {
      bZY().poy.vLk.clear();
    }
    com.tencent.mm.sdk.b.a.ymk.d(this.poC);
    ab.i("XPinOpenApi", "onAccountRelease");
    AppMethodBeat.o(79142);
  }
  
  public void onDataBaseClosed(com.tencent.mm.cg.h paramh1, com.tencent.mm.cg.h paramh2)
  {
    AppMethodBeat.i(79143);
    this.pov = null;
    this.poy = null;
    ab.i("XPinOpenApi", "onDataBaseClosed");
    AppMethodBeat.o(79143);
  }
  
  public void onDataBaseOpened(com.tencent.mm.cg.h paramh1, com.tencent.mm.cg.h paramh2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.s.a
 * JD-Core Version:    0.7.0.1
 */
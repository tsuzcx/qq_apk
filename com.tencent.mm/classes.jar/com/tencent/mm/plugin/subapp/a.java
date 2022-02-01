package com.tencent.mm.plugin.subapp;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.n.a;
import com.tencent.mm.model.ar.f;
import com.tencent.mm.model.aw;
import com.tencent.mm.pluginsdk.g.f;
import com.tencent.mm.pluginsdk.g.f.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.cd;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class a
  implements aw
{
  static cd yBw;
  private n.a appForegroundListener;
  private com.tencent.mm.plugin.subapp.e.c yBA;
  private Map<String, aw> yBx;
  private a.a yBy;
  private com.tencent.mm.plugin.subapp.e.a yBz;
  
  public a()
  {
    AppMethodBeat.i(28847);
    this.yBx = new HashMap();
    this.appForegroundListener = new n.a()
    {
      public final void onAppBackground(String paramAnonymousString) {}
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(28832);
        if (f.BRH != null)
        {
          com.tencent.mm.plugin.subapp.jdbiz.d.dLT();
          com.tencent.mm.plugin.subapp.jdbiz.d.dMa();
        }
        AppMethodBeat.o(28832);
      }
    };
    ad.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp constructor: " + System.currentTimeMillis());
    ad.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp getSubCoreMap: " + System.currentTimeMillis());
    HashMap localHashMap = new HashMap();
    localHashMap.put(com.tencent.mm.au.d.class.getName(), new com.tencent.mm.au.d());
    localHashMap.put(com.tencent.mm.plugin.subapp.c.c.class.getName(), new com.tencent.mm.plugin.subapp.c.c());
    localHashMap.put(com.tencent.mm.plugin.subapp.b.c.class.getName(), new com.tencent.mm.plugin.subapp.b.c());
    Object localObject = new com.tencent.mm.plugin.subapp.d.d();
    com.tencent.mm.model.ar.a.gMZ = (ar.f)localObject;
    localHashMap.put(com.tencent.mm.plugin.subapp.d.d.class.getName(), localObject);
    localObject = new com.tencent.mm.plugin.subapp.jdbiz.d();
    localHashMap.put(com.tencent.mm.plugin.subapp.jdbiz.d.class.getName(), localObject);
    f.BRH = (f.a)localObject;
    this.yBx = localHashMap;
    AppMethodBeat.o(28847);
  }
  
  public final aw ash(String paramString)
  {
    AppMethodBeat.i(28853);
    paramString = (aw)this.yBx.get(paramString);
    AppMethodBeat.o(28853);
    return paramString;
  }
  
  public final void b(String paramString, aw paramaw)
  {
    AppMethodBeat.i(28854);
    this.yBx.put(paramString, paramaw);
    AppMethodBeat.o(28854);
  }
  
  public final void clearPluginData(int paramInt)
  {
    AppMethodBeat.i(28849);
    ad.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp clearPluginData: " + System.currentTimeMillis());
    Iterator localIterator = this.yBx.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((aw)((Map.Entry)localIterator.next()).getValue()).clearPluginData(paramInt);
    }
    AppMethodBeat.o(28849);
  }
  
  @SuppressLint({"UseSparseArrays"})
  public final HashMap<Integer, h.b> getBaseDBFactories()
  {
    AppMethodBeat.i(28848);
    ad.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp getBaseDBFactories: " + System.currentTimeMillis());
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.yBx.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((aw)localEntry.getValue()).getBaseDBFactories() != null) {
        localHashMap.putAll(((aw)localEntry.getValue()).getBaseDBFactories());
      }
    }
    AppMethodBeat.o(28848);
    return localHashMap;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(28850);
    ad.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp onAccountPostReset: " + System.currentTimeMillis());
    Iterator localIterator = this.yBx.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((aw)((Map.Entry)localIterator.next()).getValue()).onAccountPostReset(paramBoolean);
    }
    if (this.yBy == null) {
      this.yBy = new a.a();
    }
    if (this.yBz == null) {
      this.yBz = new com.tencent.mm.plugin.subapp.e.a();
    }
    if (this.yBA == null) {
      this.yBA = new com.tencent.mm.plugin.subapp.e.c();
    }
    com.tencent.mm.sdk.b.a.ESL.c(this.yBy);
    com.tencent.mm.sdk.b.a.ESL.c(this.yBA);
    com.tencent.mm.sdk.b.a.ESL.c(this.yBz);
    this.appForegroundListener.alive();
    AppMethodBeat.o(28850);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(28852);
    ad.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp onAccountRelease: " + System.currentTimeMillis());
    this.appForegroundListener.dead();
    Iterator localIterator = this.yBx.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((aw)((Map.Entry)localIterator.next()).getValue()).onAccountRelease();
    }
    if (this.yBy != null) {
      com.tencent.mm.sdk.b.a.ESL.d(this.yBy);
    }
    if (this.yBz != null) {
      com.tencent.mm.sdk.b.a.ESL.d(this.yBz);
    }
    if (this.yBA != null) {
      com.tencent.mm.sdk.b.a.ESL.d(this.yBA);
    }
    AppMethodBeat.o(28852);
  }
  
  public final void onSdcardMount(boolean paramBoolean)
  {
    AppMethodBeat.i(28851);
    ad.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp onSdcardMount: " + System.currentTimeMillis());
    Iterator localIterator = this.yBx.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((aw)((Map.Entry)localIterator.next()).getValue()).onSdcardMount(paramBoolean);
    }
    AppMethodBeat.o(28851);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.a
 * JD-Core Version:    0.7.0.1
 */
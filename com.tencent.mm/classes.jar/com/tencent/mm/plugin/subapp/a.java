package com.tencent.mm.plugin.subapp;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.n.a;
import com.tencent.mm.model.ar.f;
import com.tencent.mm.model.aw;
import com.tencent.mm.pluginsdk.g.f;
import com.tencent.mm.pluginsdk.g.f.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.cg;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class a
  implements aw
{
  static cg zOK;
  private n.a appForegroundListener;
  private Map<String, aw> zOL;
  private a.a zOM;
  private com.tencent.mm.plugin.subapp.e.a zON;
  private com.tencent.mm.plugin.subapp.e.c zOO;
  
  public a()
  {
    AppMethodBeat.i(28847);
    this.zOL = new HashMap();
    this.appForegroundListener = new n.a()
    {
      public final void onAppBackground(String paramAnonymousString) {}
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(28832);
        if (f.DjX != null)
        {
          com.tencent.mm.plugin.subapp.jdbiz.d.eat();
          com.tencent.mm.plugin.subapp.jdbiz.d.eaA();
        }
        AppMethodBeat.o(28832);
      }
    };
    ac.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp constructor: " + System.currentTimeMillis());
    ac.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp getSubCoreMap: " + System.currentTimeMillis());
    HashMap localHashMap = new HashMap();
    localHashMap.put(com.tencent.mm.at.d.class.getName(), new com.tencent.mm.at.d());
    localHashMap.put(com.tencent.mm.plugin.subapp.c.c.class.getName(), new com.tencent.mm.plugin.subapp.c.c());
    localHashMap.put(com.tencent.mm.plugin.subapp.b.c.class.getName(), new com.tencent.mm.plugin.subapp.b.c());
    Object localObject = new com.tencent.mm.plugin.subapp.d.d();
    com.tencent.mm.model.ar.a.hnz = (ar.f)localObject;
    localHashMap.put(com.tencent.mm.plugin.subapp.d.d.class.getName(), localObject);
    localObject = new com.tencent.mm.plugin.subapp.jdbiz.d();
    localHashMap.put(com.tencent.mm.plugin.subapp.jdbiz.d.class.getName(), localObject);
    f.DjX = (f.a)localObject;
    this.zOL = localHashMap;
    AppMethodBeat.o(28847);
  }
  
  public final aw axq(String paramString)
  {
    AppMethodBeat.i(28853);
    paramString = (aw)this.zOL.get(paramString);
    AppMethodBeat.o(28853);
    return paramString;
  }
  
  public final void b(String paramString, aw paramaw)
  {
    AppMethodBeat.i(28854);
    this.zOL.put(paramString, paramaw);
    AppMethodBeat.o(28854);
  }
  
  public final void clearPluginData(int paramInt)
  {
    AppMethodBeat.i(28849);
    ac.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp clearPluginData: " + System.currentTimeMillis());
    Iterator localIterator = this.zOL.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((aw)((Map.Entry)localIterator.next()).getValue()).clearPluginData(paramInt);
    }
    AppMethodBeat.o(28849);
  }
  
  @SuppressLint({"UseSparseArrays"})
  public final HashMap<Integer, h.b> getBaseDBFactories()
  {
    AppMethodBeat.i(28848);
    ac.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp getBaseDBFactories: " + System.currentTimeMillis());
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.zOL.entrySet().iterator();
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
    ac.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp onAccountPostReset: " + System.currentTimeMillis());
    Iterator localIterator = this.zOL.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((aw)((Map.Entry)localIterator.next()).getValue()).onAccountPostReset(paramBoolean);
    }
    if (this.zOM == null) {
      this.zOM = new a.a();
    }
    if (this.zON == null) {
      this.zON = new com.tencent.mm.plugin.subapp.e.a();
    }
    if (this.zOO == null) {
      this.zOO = new com.tencent.mm.plugin.subapp.e.c();
    }
    com.tencent.mm.sdk.b.a.GpY.c(this.zOM);
    com.tencent.mm.sdk.b.a.GpY.c(this.zOO);
    com.tencent.mm.sdk.b.a.GpY.c(this.zON);
    this.appForegroundListener.alive();
    AppMethodBeat.o(28850);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(28852);
    ac.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp onAccountRelease: " + System.currentTimeMillis());
    this.appForegroundListener.dead();
    Iterator localIterator = this.zOL.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((aw)((Map.Entry)localIterator.next()).getValue()).onAccountRelease();
    }
    if (this.zOM != null) {
      com.tencent.mm.sdk.b.a.GpY.d(this.zOM);
    }
    if (this.zON != null) {
      com.tencent.mm.sdk.b.a.GpY.d(this.zON);
    }
    if (this.zOO != null) {
      com.tencent.mm.sdk.b.a.GpY.d(this.zOO);
    }
    AppMethodBeat.o(28852);
  }
  
  public final void onSdcardMount(boolean paramBoolean)
  {
    AppMethodBeat.i(28851);
    ac.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp onSdcardMount: " + System.currentTimeMillis());
    Iterator localIterator = this.zOL.entrySet().iterator();
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
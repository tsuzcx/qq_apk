package com.tencent.mm.plugin.subapp;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o.a;
import com.tencent.mm.model.ay.f;
import com.tencent.mm.model.bd;
import com.tencent.mm.pluginsdk.i.d.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.cu;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class a
  implements bd
{
  static cu FIt;
  private Map<String, bd> FIu;
  private a.a FIv;
  private com.tencent.mm.plugin.subapp.e.a FIw;
  private com.tencent.mm.plugin.subapp.e.c FIx;
  private o.a appForegroundListener;
  
  public a()
  {
    AppMethodBeat.i(28847);
    this.FIu = new HashMap();
    this.appForegroundListener = new o.a()
    {
      public final void onAppBackground(String paramAnonymousString) {}
      
      public final void onAppForeground(String paramAnonymousString)
      {
        AppMethodBeat.i(28832);
        if (com.tencent.mm.pluginsdk.i.d.JYo != null)
        {
          com.tencent.mm.plugin.subapp.jdbiz.d.fsQ();
          com.tencent.mm.plugin.subapp.jdbiz.d.fsX();
        }
        AppMethodBeat.o(28832);
      }
    };
    Log.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp constructor: " + System.currentTimeMillis());
    Log.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp getSubCoreMap: " + System.currentTimeMillis());
    HashMap localHashMap = new HashMap();
    localHashMap.put(com.tencent.mm.at.d.class.getName(), new com.tencent.mm.at.d());
    localHashMap.put(com.tencent.mm.plugin.subapp.c.c.class.getName(), new com.tencent.mm.plugin.subapp.c.c());
    localHashMap.put(com.tencent.mm.plugin.subapp.b.c.class.getName(), new com.tencent.mm.plugin.subapp.b.c());
    Object localObject = new com.tencent.mm.plugin.subapp.d.d();
    com.tencent.mm.model.ay.a.iDt = (ay.f)localObject;
    localHashMap.put(com.tencent.mm.plugin.subapp.d.d.class.getName(), localObject);
    localObject = new com.tencent.mm.plugin.subapp.jdbiz.d();
    localHashMap.put(com.tencent.mm.plugin.subapp.jdbiz.d.class.getName(), localObject);
    com.tencent.mm.pluginsdk.i.d.JYo = (d.a)localObject;
    this.FIu = localHashMap;
    AppMethodBeat.o(28847);
  }
  
  public final bd aSI(String paramString)
  {
    AppMethodBeat.i(28853);
    paramString = (bd)this.FIu.get(paramString);
    AppMethodBeat.o(28853);
    return paramString;
  }
  
  public final void b(String paramString, bd parambd)
  {
    AppMethodBeat.i(28854);
    this.FIu.put(paramString, parambd);
    AppMethodBeat.o(28854);
  }
  
  public final void clearPluginData(int paramInt)
  {
    AppMethodBeat.i(28849);
    Log.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp clearPluginData: " + System.currentTimeMillis());
    Iterator localIterator = this.FIu.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((bd)((Map.Entry)localIterator.next()).getValue()).clearPluginData(paramInt);
    }
    AppMethodBeat.o(28849);
  }
  
  @SuppressLint({"UseSparseArrays"})
  public final HashMap<Integer, h.b> getBaseDBFactories()
  {
    AppMethodBeat.i(28848);
    Log.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp getBaseDBFactories: " + System.currentTimeMillis());
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.FIu.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((bd)localEntry.getValue()).getBaseDBFactories() != null) {
        localHashMap.putAll(((bd)localEntry.getValue()).getBaseDBFactories());
      }
    }
    AppMethodBeat.o(28848);
    return localHashMap;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(28850);
    Log.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp onAccountPostReset: " + System.currentTimeMillis());
    Iterator localIterator = this.FIu.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((bd)((Map.Entry)localIterator.next()).getValue()).onAccountPostReset(paramBoolean);
    }
    if (this.FIv == null) {
      this.FIv = new a.a();
    }
    if (this.FIw == null) {
      this.FIw = new com.tencent.mm.plugin.subapp.e.a();
    }
    if (this.FIx == null) {
      this.FIx = new com.tencent.mm.plugin.subapp.e.c();
    }
    EventCenter.instance.addListener(this.FIv);
    EventCenter.instance.addListener(this.FIx);
    EventCenter.instance.addListener(this.FIw);
    this.appForegroundListener.alive();
    AppMethodBeat.o(28850);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(28852);
    Log.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp onAccountRelease: " + System.currentTimeMillis());
    this.appForegroundListener.dead();
    Iterator localIterator = this.FIu.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((bd)((Map.Entry)localIterator.next()).getValue()).onAccountRelease();
    }
    if (this.FIv != null) {
      EventCenter.instance.removeListener(this.FIv);
    }
    if (this.FIw != null) {
      EventCenter.instance.removeListener(this.FIw);
    }
    if (this.FIx != null) {
      EventCenter.instance.removeListener(this.FIx);
    }
    AppMethodBeat.o(28852);
  }
  
  public final void onSdcardMount(boolean paramBoolean)
  {
    AppMethodBeat.i(28851);
    Log.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp onSdcardMount: " + System.currentTimeMillis());
    Iterator localIterator = this.FIu.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((bd)((Map.Entry)localIterator.next()).getValue()).onSdcardMount(paramBoolean);
    }
    AppMethodBeat.o(28851);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.a
 * JD-Core Version:    0.7.0.1
 */
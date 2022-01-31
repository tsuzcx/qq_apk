package com.tencent.mm.plugin.subapp;

import android.annotation.SuppressLint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.j.a;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.model.ao.f;
import com.tencent.mm.model.at;
import com.tencent.mm.pluginsdk.f.f.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.cc;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class a
  implements at
{
  static cc sVM;
  private j.a appForegroundListener;
  private Map<String, at> sVN;
  private a.a sVO;
  private com.tencent.mm.plugin.subapp.d.a sVP;
  private com.tencent.mm.plugin.subapp.d.c sVQ;
  
  public a()
  {
    AppMethodBeat.i(25171);
    this.sVN = new HashMap();
    this.appForegroundListener = new a.1(this);
    ab.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp constructor: " + System.currentTimeMillis());
    ab.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp getSubCoreMap: " + System.currentTimeMillis());
    HashMap localHashMap = new HashMap();
    localHashMap.put(com.tencent.mm.ar.d.class.getName(), new com.tencent.mm.ar.d());
    localHashMap.put(com.tencent.mm.plugin.subapp.b.c.class.getName(), new com.tencent.mm.plugin.subapp.b.c());
    localHashMap.put(com.tencent.mm.plugin.subapp.a.c.class.getName(), new com.tencent.mm.plugin.subapp.a.c());
    Object localObject = new com.tencent.mm.plugin.subapp.c.d();
    com.tencent.mm.model.ao.a.flL = (ao.f)localObject;
    localHashMap.put(com.tencent.mm.plugin.subapp.c.d.class.getName(), localObject);
    localObject = new com.tencent.mm.plugin.subapp.jdbiz.d();
    localHashMap.put(com.tencent.mm.plugin.subapp.jdbiz.d.class.getName(), localObject);
    com.tencent.mm.pluginsdk.f.f.vMG = (f.a)localObject;
    this.sVN = localHashMap;
    AppMethodBeat.o(25171);
  }
  
  public final at adN(String paramString)
  {
    AppMethodBeat.i(25177);
    paramString = (at)this.sVN.get(paramString);
    AppMethodBeat.o(25177);
    return paramString;
  }
  
  public final void b(String paramString, at paramat)
  {
    AppMethodBeat.i(25178);
    this.sVN.put(paramString, paramat);
    AppMethodBeat.o(25178);
  }
  
  public final void clearPluginData(int paramInt)
  {
    AppMethodBeat.i(25173);
    ab.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp clearPluginData: " + System.currentTimeMillis());
    Iterator localIterator = this.sVN.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((at)((Map.Entry)localIterator.next()).getValue()).clearPluginData(paramInt);
    }
    AppMethodBeat.o(25173);
  }
  
  @SuppressLint({"UseSparseArrays"})
  public final HashMap<Integer, h.d> getBaseDBFactories()
  {
    AppMethodBeat.i(25172);
    ab.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp getBaseDBFactories: " + System.currentTimeMillis());
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.sVN.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((at)localEntry.getValue()).getBaseDBFactories() != null) {
        localHashMap.putAll(((at)localEntry.getValue()).getBaseDBFactories());
      }
    }
    AppMethodBeat.o(25172);
    return localHashMap;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(25174);
    ab.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp onAccountPostReset: " + System.currentTimeMillis());
    Iterator localIterator = this.sVN.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((at)((Map.Entry)localIterator.next()).getValue()).onAccountPostReset(paramBoolean);
    }
    if (this.sVO == null) {
      this.sVO = new a.a();
    }
    if (this.sVP == null) {
      this.sVP = new com.tencent.mm.plugin.subapp.d.a();
    }
    if (this.sVQ == null) {
      this.sVQ = new com.tencent.mm.plugin.subapp.d.c();
    }
    com.tencent.mm.sdk.b.a.ymk.c(this.sVO);
    com.tencent.mm.sdk.b.a.ymk.c(this.sVQ);
    com.tencent.mm.sdk.b.a.ymk.c(this.sVP);
    this.appForegroundListener.alive();
    AppMethodBeat.o(25174);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(25176);
    ab.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp onAccountRelease: " + System.currentTimeMillis());
    this.appForegroundListener.dead();
    Iterator localIterator = this.sVN.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((at)((Map.Entry)localIterator.next()).getValue()).onAccountRelease();
    }
    if (this.sVO != null) {
      com.tencent.mm.sdk.b.a.ymk.d(this.sVO);
    }
    if (this.sVP != null) {
      com.tencent.mm.sdk.b.a.ymk.d(this.sVP);
    }
    if (this.sVQ != null) {
      com.tencent.mm.sdk.b.a.ymk.d(this.sVQ);
    }
    AppMethodBeat.o(25176);
  }
  
  public final void onSdcardMount(boolean paramBoolean)
  {
    AppMethodBeat.i(25175);
    ab.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp onSdcardMount: " + System.currentTimeMillis());
    Iterator localIterator = this.sVN.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((at)((Map.Entry)localIterator.next()).getValue()).onSdcardMount(paramBoolean);
    }
    AppMethodBeat.o(25175);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.a
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.subapp;

import android.annotation.SuppressLint;
import com.tencent.mm.cf.h.d;
import com.tencent.mm.model.am.f;
import com.tencent.mm.model.ar;
import com.tencent.mm.pluginsdk.f.f.b;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.cc;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class a
  implements ar
{
  static cc pum;
  private Map<String, ar> pun = new HashMap();
  private a.a puo;
  private com.tencent.mm.plugin.subapp.d.a pup;
  private com.tencent.mm.plugin.subapp.d.c puq;
  
  public a()
  {
    y.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp constructor: " + System.currentTimeMillis());
    y.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp getSubCoreMap: " + System.currentTimeMillis());
    HashMap localHashMap = new HashMap();
    localHashMap.put(com.tencent.mm.aq.d.class.getName(), new com.tencent.mm.aq.d());
    localHashMap.put(com.tencent.mm.plugin.subapp.b.c.class.getName(), new com.tencent.mm.plugin.subapp.b.c());
    localHashMap.put(com.tencent.mm.plugin.subapp.a.c.class.getName(), new com.tencent.mm.plugin.subapp.a.c());
    Object localObject = new com.tencent.mm.plugin.subapp.c.d();
    com.tencent.mm.model.am.a.dVB = (am.f)localObject;
    localHashMap.put(com.tencent.mm.plugin.subapp.c.d.class.getName(), localObject);
    localObject = new com.tencent.mm.plugin.subapp.jdbiz.c();
    localHashMap.put(com.tencent.mm.plugin.subapp.jdbiz.c.class.getName(), localObject);
    com.tencent.mm.pluginsdk.f.f.rVL = (f.b)localObject;
    this.pun = localHashMap;
  }
  
  public final ar Py(String paramString)
  {
    return (ar)this.pun.get(paramString);
  }
  
  public final void b(String paramString, ar paramar)
  {
    this.pun.put(paramString, paramar);
  }
  
  public final void bh(boolean paramBoolean)
  {
    y.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp onAccountPostReset: " + System.currentTimeMillis());
    Iterator localIterator = this.pun.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((ar)((Map.Entry)localIterator.next()).getValue()).bh(paramBoolean);
    }
    if (this.puo == null) {
      this.puo = new a.a();
    }
    if (this.pup == null) {
      this.pup = new com.tencent.mm.plugin.subapp.d.a();
    }
    if (this.puq == null) {
      this.puq = new com.tencent.mm.plugin.subapp.d.c();
    }
    com.tencent.mm.sdk.b.a.udP.c(this.puo);
    com.tencent.mm.sdk.b.a.udP.c(this.puq);
    com.tencent.mm.sdk.b.a.udP.c(this.pup);
  }
  
  public final void bi(boolean paramBoolean)
  {
    y.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp onSdcardMount: " + System.currentTimeMillis());
    Iterator localIterator = this.pun.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((ar)((Map.Entry)localIterator.next()).getValue()).bi(paramBoolean);
    }
  }
  
  public final void gf(int paramInt)
  {
    y.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp clearPluginData: " + System.currentTimeMillis());
    Iterator localIterator = this.pun.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((ar)((Map.Entry)localIterator.next()).getValue()).gf(paramInt);
    }
  }
  
  public final void onAccountRelease()
  {
    y.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp onAccountRelease: " + System.currentTimeMillis());
    Iterator localIterator = this.pun.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((ar)((Map.Entry)localIterator.next()).getValue()).onAccountRelease();
    }
    if (this.puo != null) {
      com.tencent.mm.sdk.b.a.udP.d(this.puo);
    }
    if (this.pup != null) {
      com.tencent.mm.sdk.b.a.udP.d(this.pup);
    }
    if (this.puq != null) {
      com.tencent.mm.sdk.b.a.udP.d(this.puq);
    }
  }
  
  @SuppressLint({"UseSparseArrays"})
  public final HashMap<Integer, h.d> xe()
  {
    y.i("MicroMsg.SubCoreSubapp", "SubCoreSubapp getBaseDBFactories: " + System.currentTimeMillis());
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.pun.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((ar)localEntry.getValue()).xe() != null) {
        localHashMap.putAll(((ar)localEntry.getValue()).xe());
      }
    }
    return localHashMap;
  }
  
  private static enum a$a
  {
    private a$a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.subapp.a
 * JD-Core Version:    0.7.0.1
 */
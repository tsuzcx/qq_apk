package com.tencent.mm.plugin.radar.b;

import android.content.Context;
import com.tencent.mm.ah.p;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class c
  implements m.b
{
  private static final String TAG = "MicroMsg.RadarAddContact";
  public static final c.b nkz = new c.b((byte)0);
  final Context context;
  private final ah handler;
  private final LinkedList<String> nku;
  public final HashMap<String, String> nkv;
  public final c.i nkw;
  public final c.g nkx;
  final c.c nky;
  
  public c(c.c paramc, Context paramContext)
  {
    this.nky = paramc;
    this.context = paramContext;
    this.nku = new LinkedList();
    this.nkv = new HashMap();
    this.nkw = new c.i(this);
    this.nkx = new c.g(this);
    this.handler = new ah();
  }
  
  private final void L(ad paramad)
  {
    if (this.nku.contains(paramad.getUsername())) {
      this.nku.remove(paramad.getUsername());
    }
    if (this.nku.contains(paramad.vp())) {
      this.nku.remove(paramad.vp());
    }
  }
  
  private final void M(ad paramad)
  {
    L(paramad);
    this.nkv.remove(paramad.getUsername());
    this.nkv.remove(paramad.vp());
    this.handler.post((Runnable)new c.j(this, paramad));
  }
  
  public final long Lw(String paramString)
  {
    a.d.b.g.k(paramString, "username");
    long l = System.currentTimeMillis();
    c.a locala = new c.a(this, (c.d)new c.f(this, paramString, l));
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(Integer.valueOf(48));
    if ((paramString != null) && (paramString.length() > 0)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      Assert.assertTrue(true);
      locala.onStart();
      locala.nkB = localLinkedList;
      locala.hcm = paramString;
      if (paramString != null) {
        locala.nkA.add(paramString);
      }
      com.tencent.mm.kernel.g.Dk().d((com.tencent.mm.ah.m)new com.tencent.mm.pluginsdk.model.m(2, (List)locala.nkA, (List)localLinkedList, "", ""));
      return l;
    }
  }
  
  public final c.e Lx(String paramString)
  {
    a.d.b.g.k(paramString, "username");
    Object localObject = com.tencent.mm.kernel.g.r(j.class);
    a.d.b.g.j(localObject, "service(IMessengerStorage::class.java)");
    localObject = ((j)localObject).Fw().abl(paramString);
    if ((localObject == null) || (((ad)localObject).Bo() == 0)) {
      if (this.nku.contains(paramString)) {
        localObject = c.e.nkF;
      }
    }
    for (;;)
    {
      y.d(TAG, "query username(%s) status %s", new Object[] { paramString, localObject });
      return localObject;
      localObject = c.e.nkE;
      continue;
      if (((ad)localObject).Bd()) {
        localObject = c.e.nkG;
      } else if (this.nkv.containsKey(paramString)) {
        localObject = c.e.nkH;
      } else if (this.nku.contains(paramString)) {
        localObject = c.e.nkF;
      } else {
        localObject = c.e.nkE;
      }
    }
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.m paramm, Object paramObject)
  {
    a.d.b.g.k(paramm, "stg");
    y.d(TAG, "onNotifyChange event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramm, paramObject });
    if ((paramObject == null) || (!(paramObject instanceof String))) {
      y.e(TAG, "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramm, paramObject });
    }
    do
    {
      return;
      paramm = (String)paramObject;
      paramObject = com.tencent.mm.kernel.g.r(j.class);
      a.d.b.g.j(paramObject, "service(IMessengerStorage::class.java)");
      paramObject = ((j)paramObject).Fw().abl(paramm);
    } while ((paramObject == null) || (!paramObject.Bd()));
    y.d(TAG, "ContactStg onNotifyChange %s", new Object[] { paramm });
    M(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.radar.b.c
 * JD-Core Version:    0.7.0.1
 */
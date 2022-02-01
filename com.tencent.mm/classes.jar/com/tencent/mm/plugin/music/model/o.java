package com.tencent.mm.plugin.music.model;

import android.content.ClipboardManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.al;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.be;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.music.e.e;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.plugin.music.e.m;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class o
  implements be
{
  private IListener FNC;
  private com.tencent.mm.plugin.music.model.e.b FRR;
  private ClipboardManager FRS;
  private com.tencent.mm.plugin.music.model.e.d FRT;
  private IListener<com.tencent.mm.f.a.d> FRU;
  private IListener rXj;
  
  public o()
  {
    AppMethodBeat.i(63029);
    this.FNC = new com.tencent.mm.plugin.music.e.f();
    this.rXj = new IListener() {};
    this.FRU = new o.4(this);
    AppMethodBeat.o(63029);
  }
  
  private static o feV()
  {
    AppMethodBeat.i(63030);
    o localo = (o)y.as(o.class);
    AppMethodBeat.o(63030);
    return localo;
  }
  
  public static com.tencent.mm.plugin.music.model.e.b feW()
  {
    AppMethodBeat.i(63032);
    if (feV().FRR == null) {
      feV().FRR = new com.tencent.mm.plugin.music.model.e.b(h.aHG().kcF);
    }
    com.tencent.mm.plugin.music.model.e.b localb = feV().FRR;
    AppMethodBeat.o(63032);
    return localb;
  }
  
  public static com.tencent.mm.plugin.music.model.e.d feX()
  {
    AppMethodBeat.i(63034);
    if (feV().FRT == null) {
      feV().FRT = new com.tencent.mm.plugin.music.model.e.d(h.aHG().kcF);
    }
    com.tencent.mm.plugin.music.model.e.d locald = feV().FRT;
    AppMethodBeat.o(63034);
    return locald;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    AppMethodBeat.i(63031);
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf("Music".hashCode()), new o.1(this));
    localHashMap.put(Integer.valueOf("PieceMusicInfo".hashCode()), new o.2(this));
    AppMethodBeat.o(63031);
    return localHashMap;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(63035);
    this.FRU.alive();
    this.FNC.alive();
    b.create();
    this.rXj.alive();
    m localm = new m();
    k.a(localm);
    com.tencent.mm.plugin.music.f.c.b.a(e.class, localm);
    com.tencent.mm.plugin.music.f.c.b.a(com.tencent.mm.plugin.music.e.d.class, new com.tencent.mm.plugin.music.model.d.f());
    AppMethodBeat.o(63035);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(63036);
    k.feu();
    com.tencent.mm.plugin.music.f.c.b.af(e.class);
    this.FRR = null;
    this.FRS = null;
    this.FRT = null;
    b.destroy();
    EventCenter.instance.removeListener(this.FNC);
    this.FNC.dead();
    this.rXj.dead();
    this.FRU.dead();
    AppMethodBeat.o(63036);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.o
 * JD-Core Version:    0.7.0.1
 */
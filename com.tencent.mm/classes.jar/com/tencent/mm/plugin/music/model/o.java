package com.tencent.mm.plugin.music.model;

import android.content.ClipboardManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.et;
import com.tencent.mm.g.c.fg;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.plugin.music.e.m;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class o
  implements bd
{
  private IListener AgM;
  private com.tencent.mm.plugin.music.model.e.b AkL;
  private ClipboardManager AkM;
  private com.tencent.mm.plugin.music.model.e.d AkN;
  private IListener<com.tencent.mm.g.a.d> AkO;
  private IListener oVk;
  
  public o()
  {
    AppMethodBeat.i(63029);
    this.AgM = new com.tencent.mm.plugin.music.e.f();
    this.oVk = new o.3(this);
    this.AkO = new IListener() {};
    AppMethodBeat.o(63029);
  }
  
  private static o euC()
  {
    AppMethodBeat.i(63030);
    o localo = (o)y.at(o.class);
    AppMethodBeat.o(63030);
    return localo;
  }
  
  public static com.tencent.mm.plugin.music.model.e.b euD()
  {
    AppMethodBeat.i(63032);
    if (euC().AkL == null) {
      euC().AkL = new com.tencent.mm.plugin.music.model.e.b(g.aAh().hqK);
    }
    com.tencent.mm.plugin.music.model.e.b localb = euC().AkL;
    AppMethodBeat.o(63032);
    return localb;
  }
  
  public static com.tencent.mm.plugin.music.model.e.d euE()
  {
    AppMethodBeat.i(63034);
    if (euC().AkN == null) {
      euC().AkN = new com.tencent.mm.plugin.music.model.e.d(g.aAh().hqK);
    }
    com.tencent.mm.plugin.music.model.e.d locald = euC().AkN;
    AppMethodBeat.o(63034);
    return locald;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    AppMethodBeat.i(63031);
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf("Music".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        AppMethodBeat.i(63025);
        String str = MAutoStorage.getCreateSQLs(et.ajs(), "Music");
        AppMethodBeat.o(63025);
        return new String[] { str };
      }
    });
    localHashMap.put(Integer.valueOf("PieceMusicInfo".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        AppMethodBeat.i(63026);
        String str = MAutoStorage.getCreateSQLs(fg.ajs(), "PieceMusicInfo");
        AppMethodBeat.o(63026);
        return new String[] { str };
      }
    });
    AppMethodBeat.o(63031);
    return localHashMap;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(63035);
    this.AkO.alive();
    this.AgM.alive();
    b.create();
    this.oVk.alive();
    m localm = new m();
    k.a(localm);
    com.tencent.mm.plugin.music.f.c.b.a(com.tencent.mm.plugin.music.e.e.class, localm);
    com.tencent.mm.plugin.music.f.c.b.a(com.tencent.mm.plugin.music.e.d.class, new com.tencent.mm.plugin.music.model.d.f());
    AppMethodBeat.o(63035);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(63036);
    k.euk();
    com.tencent.mm.plugin.music.f.c.b.ag(com.tencent.mm.plugin.music.e.e.class);
    this.AkL = null;
    this.AkM = null;
    this.AkN = null;
    b.destroy();
    EventCenter.instance.removeListener(this.AgM);
    this.AgM.dead();
    this.oVk.dead();
    this.AkO.dead();
    AppMethodBeat.o(63036);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.o
 * JD-Core Version:    0.7.0.1
 */
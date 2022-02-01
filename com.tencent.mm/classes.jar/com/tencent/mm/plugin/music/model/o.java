package com.tencent.mm.plugin.music.model;

import android.content.ClipboardManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.be;
import com.tencent.mm.model.y;
import com.tencent.mm.plugin.music.logic.MusicActionListener;
import com.tencent.mm.plugin.music.logic.j;
import com.tencent.mm.plugin.music.logic.l;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class o
  implements be
{
  private IListener LIy;
  private com.tencent.mm.plugin.music.model.e.b LMJ;
  private com.tencent.mm.plugin.music.model.e.d LMK;
  private IListener<com.tencent.mm.autogen.a.e> LML;
  private ClipboardManager aQR;
  private IListener viA;
  
  public o()
  {
    AppMethodBeat.i(63029);
    this.LIy = new MusicActionListener();
    this.viA = new SubCoreMusic.3(this, com.tencent.mm.app.f.hfK);
    this.LML = new SubCoreMusic.4(this, com.tencent.mm.app.f.hfK);
    AppMethodBeat.o(63029);
  }
  
  private static o goc()
  {
    AppMethodBeat.i(63030);
    o localo = (o)y.aL(o.class);
    AppMethodBeat.o(63030);
    return localo;
  }
  
  public static com.tencent.mm.plugin.music.model.e.b god()
  {
    AppMethodBeat.i(63032);
    if (goc().LMJ == null) {
      goc().LMJ = new com.tencent.mm.plugin.music.model.e.b(h.baE().mCN);
    }
    com.tencent.mm.plugin.music.model.e.b localb = goc().LMJ;
    AppMethodBeat.o(63032);
    return localb;
  }
  
  public static com.tencent.mm.plugin.music.model.e.d goe()
  {
    AppMethodBeat.i(63034);
    if (goc().LMK == null) {
      goc().LMK = new com.tencent.mm.plugin.music.model.e.d(h.baE().mCN);
    }
    com.tencent.mm.plugin.music.model.e.d locald = goc().LMK;
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
    this.LML.alive();
    this.LIy.alive();
    b.create();
    this.viA.alive();
    l locall = new l();
    j.a(locall);
    com.tencent.mm.plugin.music.e.c.b.a(com.tencent.mm.plugin.music.logic.e.class, locall);
    com.tencent.mm.plugin.music.e.c.b.a(com.tencent.mm.plugin.music.logic.d.class, new com.tencent.mm.plugin.music.model.d.f());
    AppMethodBeat.o(63035);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(63036);
    j.gnx();
    com.tencent.mm.plugin.music.e.c.b.ay(com.tencent.mm.plugin.music.logic.e.class);
    this.LMJ = null;
    this.aQR = null;
    this.LMK = null;
    b.destroy();
    this.LIy.dead();
    this.LIy.dead();
    this.viA.dead();
    this.LML.dead();
    AppMethodBeat.o(63036);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.o
 * JD-Core Version:    0.7.0.1
 */
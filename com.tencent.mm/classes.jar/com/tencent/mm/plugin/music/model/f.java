package com.tencent.mm.plugin.music.model;

import android.content.ClipboardManager;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.plugin.music.e.m;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bc;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class f
  implements ax
{
  private com.tencent.mm.sdk.b.c nEU;
  private com.tencent.mm.sdk.b.c whK;
  private com.tencent.mm.plugin.music.model.e.b wkV;
  private ClipboardManager wkW;
  private com.tencent.mm.plugin.music.model.e.d wkX;
  private com.tencent.mm.sdk.b.c<com.tencent.mm.g.a.d> wkY;
  
  public f()
  {
    AppMethodBeat.i(63029);
    this.whK = new com.tencent.mm.plugin.music.e.f();
    this.nEU = new f.3(this);
    this.wkY = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(63029);
  }
  
  private static f dte()
  {
    AppMethodBeat.i(63030);
    f localf = (f)t.ap(f.class);
    AppMethodBeat.o(63030);
    return localf;
  }
  
  public static com.tencent.mm.plugin.music.model.e.b dtf()
  {
    AppMethodBeat.i(63032);
    if (dte().wkV == null) {
      dte().wkV = new com.tencent.mm.plugin.music.model.e.b(g.ajC().gBq);
    }
    com.tencent.mm.plugin.music.model.e.b localb = dte().wkV;
    AppMethodBeat.o(63032);
    return localb;
  }
  
  public static ClipboardManager dtg()
  {
    AppMethodBeat.i(63033);
    if (dte().wkW == null) {
      dte().wkW = ((ClipboardManager)aj.getContext().getSystemService("clipboard"));
    }
    ClipboardManager localClipboardManager = dte().wkW;
    AppMethodBeat.o(63033);
    return localClipboardManager;
  }
  
  public static com.tencent.mm.plugin.music.model.e.d dth()
  {
    AppMethodBeat.i(63034);
    if (dte().wkX == null) {
      dte().wkX = new com.tencent.mm.plugin.music.model.e.d(g.ajC().gBq);
    }
    com.tencent.mm.plugin.music.model.e.d locald = dte().wkX;
    AppMethodBeat.o(63034);
    return locald;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    AppMethodBeat.i(63031);
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf("Music".hashCode()), new f.1(this));
    localHashMap.put(Integer.valueOf("PieceMusicInfo".hashCode()), new f.2(this));
    AppMethodBeat.o(63031);
    return localHashMap;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(63035);
    this.wkY.alive();
    this.whK.alive();
    Object localObject = a.a.wkG;
    ((com.tencent.mm.plugin.ball.c.c)g.ab(com.tencent.mm.plugin.ball.c.c.class)).a(6, ((a)localObject).kjw);
    ((a)localObject).wkB.alive();
    ((a)localObject).jSq = new bc();
    ((a)localObject).jSq.jb(aj.getContext());
    ((a)localObject).jSq.a(((a)localObject).jSr);
    ((a)localObject).jSt.alive();
    this.nEU.alive();
    localObject = new m();
    k.a((com.tencent.mm.plugin.music.e.a)localObject);
    com.tencent.mm.plugin.music.f.c.b.a(com.tencent.mm.plugin.music.e.e.class, (com.tencent.mm.plugin.music.f.c.a)localObject);
    com.tencent.mm.plugin.music.f.c.b.a(com.tencent.mm.plugin.music.e.d.class, new com.tencent.mm.plugin.music.model.d.f());
    AppMethodBeat.o(63035);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(63036);
    k.dtb();
    com.tencent.mm.plugin.music.f.c.b.ac(com.tencent.mm.plugin.music.e.e.class);
    this.wkV = null;
    this.wkW = null;
    this.wkX = null;
    a locala = a.a.wkG;
    ((com.tencent.mm.plugin.ball.c.c)g.ab(com.tencent.mm.plugin.ball.c.c.class)).b(6, locala.kjw);
    locala.wkB.dead();
    locala.jSq.b(locala.jSr);
    locala.jSq.end();
    locala.jSt.dead();
    com.tencent.mm.sdk.b.a.IbL.d(this.whK);
    this.whK.dead();
    this.nEU.dead();
    this.wkY.dead();
    AppMethodBeat.o(63036);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.f
 * JD-Core Version:    0.7.0.1
 */
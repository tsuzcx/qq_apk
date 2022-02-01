package com.tencent.mm.plugin.music.model;

import android.content.ClipboardManager;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.plugin.music.e.m;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class f
  implements az
{
  private com.tencent.mm.sdk.b.c nKp;
  private com.tencent.mm.plugin.music.model.e.b wAE;
  private ClipboardManager wAF;
  private com.tencent.mm.plugin.music.model.e.d wAG;
  private com.tencent.mm.sdk.b.c<com.tencent.mm.g.a.d> wAH;
  private com.tencent.mm.sdk.b.c wxo;
  
  public f()
  {
    AppMethodBeat.i(63029);
    this.wxo = new com.tencent.mm.plugin.music.e.f();
    this.nKp = new f.3(this);
    this.wAH = new f.4(this);
    AppMethodBeat.o(63029);
  }
  
  private static f dwt()
  {
    AppMethodBeat.i(63030);
    f localf = (f)u.ap(f.class);
    AppMethodBeat.o(63030);
    return localf;
  }
  
  public static com.tencent.mm.plugin.music.model.e.b dwu()
  {
    AppMethodBeat.i(63032);
    if (dwt().wAE == null) {
      dwt().wAE = new com.tencent.mm.plugin.music.model.e.b(g.ajR().gDX);
    }
    com.tencent.mm.plugin.music.model.e.b localb = dwt().wAE;
    AppMethodBeat.o(63032);
    return localb;
  }
  
  public static ClipboardManager dwv()
  {
    AppMethodBeat.i(63033);
    if (dwt().wAF == null) {
      dwt().wAF = ((ClipboardManager)ak.getContext().getSystemService("clipboard"));
    }
    ClipboardManager localClipboardManager = dwt().wAF;
    AppMethodBeat.o(63033);
    return localClipboardManager;
  }
  
  public static com.tencent.mm.plugin.music.model.e.d dww()
  {
    AppMethodBeat.i(63034);
    if (dwt().wAG == null) {
      dwt().wAG = new com.tencent.mm.plugin.music.model.e.d(g.ajR().gDX);
    }
    com.tencent.mm.plugin.music.model.e.d locald = dwt().wAG;
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
    this.wAH.alive();
    this.wxo.alive();
    Object localObject = a.a.wAp;
    ((com.tencent.mm.plugin.ball.c.c)g.ab(com.tencent.mm.plugin.ball.c.c.class)).a(6, ((a)localObject).kmM);
    ((a)localObject).wAk.alive();
    ((a)localObject).jVH = new bd();
    ((a)localObject).jVH.jg(ak.getContext());
    ((a)localObject).jVH.a(((a)localObject).jVI);
    ((a)localObject).jVK.alive();
    this.nKp.alive();
    localObject = new m();
    k.a((com.tencent.mm.plugin.music.e.a)localObject);
    com.tencent.mm.plugin.music.f.c.b.a(com.tencent.mm.plugin.music.e.e.class, (com.tencent.mm.plugin.music.f.c.a)localObject);
    com.tencent.mm.plugin.music.f.c.b.a(com.tencent.mm.plugin.music.e.d.class, new com.tencent.mm.plugin.music.model.d.f());
    AppMethodBeat.o(63035);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(63036);
    k.dwq();
    com.tencent.mm.plugin.music.f.c.b.ac(com.tencent.mm.plugin.music.e.e.class);
    this.wAE = null;
    this.wAF = null;
    this.wAG = null;
    a locala = a.a.wAp;
    ((com.tencent.mm.plugin.ball.c.c)g.ab(com.tencent.mm.plugin.ball.c.c.class)).b(6, locala.kmM);
    locala.wAk.dead();
    locala.jVH.b(locala.jVI);
    locala.jVH.end();
    locala.jVK.dead();
    com.tencent.mm.sdk.b.a.IvT.d(this.wxo);
    this.wxo.dead();
    this.nKp.dead();
    this.wAH.dead();
    AppMethodBeat.o(63036);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.f
 * JD-Core Version:    0.7.0.1
 */
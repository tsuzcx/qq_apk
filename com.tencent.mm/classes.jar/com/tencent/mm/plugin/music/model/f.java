package com.tencent.mm.plugin.music.model;

import android.content.ClipboardManager;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.plugin.music.e.m;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bc;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class f
  implements aw
{
  private com.tencent.mm.sdk.b.c mCw;
  private com.tencent.mm.sdk.b.c tTG;
  private com.tencent.mm.plugin.music.model.e.b tWP;
  private ClipboardManager tWQ;
  private com.tencent.mm.plugin.music.model.e.d tWR;
  private com.tencent.mm.sdk.b.c<com.tencent.mm.g.a.d> tWS;
  
  public f()
  {
    AppMethodBeat.i(63029);
    this.tTG = new com.tencent.mm.plugin.music.e.f();
    this.mCw = new f.3(this);
    this.tWS = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(63029);
  }
  
  private static f cVm()
  {
    AppMethodBeat.i(63030);
    f localf = (f)t.ap(f.class);
    AppMethodBeat.o(63030);
    return localf;
  }
  
  public static com.tencent.mm.plugin.music.model.e.b cVn()
  {
    AppMethodBeat.i(63032);
    if (cVm().tWP == null) {
      cVm().tWP = new com.tencent.mm.plugin.music.model.e.b(g.afB().gda);
    }
    com.tencent.mm.plugin.music.model.e.b localb = cVm().tWP;
    AppMethodBeat.o(63032);
    return localb;
  }
  
  public static ClipboardManager cVo()
  {
    AppMethodBeat.i(63033);
    if (cVm().tWQ == null) {
      cVm().tWQ = ((ClipboardManager)aj.getContext().getSystemService("clipboard"));
    }
    ClipboardManager localClipboardManager = cVm().tWQ;
    AppMethodBeat.o(63033);
    return localClipboardManager;
  }
  
  public static com.tencent.mm.plugin.music.model.e.d cVp()
  {
    AppMethodBeat.i(63034);
    if (cVm().tWR == null) {
      cVm().tWR = new com.tencent.mm.plugin.music.model.e.d(g.afB().gda);
    }
    com.tencent.mm.plugin.music.model.e.d locald = cVm().tWR;
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
    this.tWS.alive();
    this.tTG.alive();
    Object localObject = a.a.tWA;
    ((com.tencent.mm.plugin.ball.c.c)g.ab(com.tencent.mm.plugin.ball.c.c.class)).a(6, ((a)localObject).jpa);
    ((a)localObject).tWw.alive();
    ((a)localObject).iYc = new bc();
    ((a)localObject).iYc.iG(aj.getContext());
    ((a)localObject).iYc.a(((a)localObject).iYd);
    ((a)localObject).iYf.alive();
    this.mCw.alive();
    localObject = new m();
    k.a((com.tencent.mm.plugin.music.e.a)localObject);
    com.tencent.mm.plugin.music.f.c.b.a(com.tencent.mm.plugin.music.e.e.class, (com.tencent.mm.plugin.music.f.c.a)localObject);
    com.tencent.mm.plugin.music.f.c.b.a(com.tencent.mm.plugin.music.e.d.class, new com.tencent.mm.plugin.music.model.d.f());
    AppMethodBeat.o(63035);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(63036);
    k.cVj();
    com.tencent.mm.plugin.music.f.c.b.ac(com.tencent.mm.plugin.music.e.e.class);
    this.tWP = null;
    this.tWQ = null;
    this.tWR = null;
    a locala = a.a.tWA;
    ((com.tencent.mm.plugin.ball.c.c)g.ab(com.tencent.mm.plugin.ball.c.c.class)).b(6, locala.jpa);
    locala.tWw.dead();
    locala.iYc.b(locala.iYd);
    locala.iYc.end();
    locala.iYf.dead();
    com.tencent.mm.sdk.b.a.ESL.d(this.tTG);
    this.tTG.dead();
    this.mCw.dead();
    this.tWS.dead();
    AppMethodBeat.o(63036);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.f
 * JD-Core Version:    0.7.0.1
 */
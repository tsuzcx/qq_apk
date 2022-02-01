package com.tencent.mm.plugin.music.model;

import android.content.ClipboardManager;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ec;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.plugin.music.e.m;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bb;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class f
  implements aw
{
  private com.tencent.mm.sdk.b.c ney;
  private com.tencent.mm.sdk.b.c vco;
  private com.tencent.mm.plugin.music.model.e.b vfA;
  private ClipboardManager vfB;
  private com.tencent.mm.plugin.music.model.e.d vfC;
  private com.tencent.mm.sdk.b.c<com.tencent.mm.g.a.d> vfD;
  
  public f()
  {
    AppMethodBeat.i(63029);
    this.vco = new com.tencent.mm.plugin.music.e.f();
    this.ney = new f.3(this);
    this.vfD = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(63029);
  }
  
  private static f diS()
  {
    AppMethodBeat.i(63030);
    f localf = (f)t.ap(f.class);
    AppMethodBeat.o(63030);
    return localf;
  }
  
  public static com.tencent.mm.plugin.music.model.e.b diT()
  {
    AppMethodBeat.i(63032);
    if (diS().vfA == null) {
      diS().vfA = new com.tencent.mm.plugin.music.model.e.b(g.agR().ghG);
    }
    com.tencent.mm.plugin.music.model.e.b localb = diS().vfA;
    AppMethodBeat.o(63032);
    return localb;
  }
  
  public static ClipboardManager diU()
  {
    AppMethodBeat.i(63033);
    if (diS().vfB == null) {
      diS().vfB = ((ClipboardManager)ai.getContext().getSystemService("clipboard"));
    }
    ClipboardManager localClipboardManager = diS().vfB;
    AppMethodBeat.o(63033);
    return localClipboardManager;
  }
  
  public static com.tencent.mm.plugin.music.model.e.d diV()
  {
    AppMethodBeat.i(63034);
    if (diS().vfC == null) {
      diS().vfC = new com.tencent.mm.plugin.music.model.e.d(g.agR().ghG);
    }
    com.tencent.mm.plugin.music.model.e.d locald = diS().vfC;
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
        String str = j.getCreateSQLs(ec.Th(), "Music");
        AppMethodBeat.o(63025);
        return new String[] { str };
      }
    });
    localHashMap.put(Integer.valueOf("PieceMusicInfo".hashCode()), new f.2(this));
    AppMethodBeat.o(63031);
    return localHashMap;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(63035);
    this.vfD.alive();
    this.vco.alive();
    Object localObject = a.a.vfl;
    ((com.tencent.mm.plugin.ball.c.c)g.ab(com.tencent.mm.plugin.ball.c.c.class)).a(6, ((a)localObject).jPm);
    ((a)localObject).vfg.alive();
    ((a)localObject).jyt = new bb();
    ((a)localObject).jyt.iR(ai.getContext());
    ((a)localObject).jyt.a(((a)localObject).jyu);
    ((a)localObject).jyw.alive();
    this.ney.alive();
    localObject = new m();
    k.a((com.tencent.mm.plugin.music.e.a)localObject);
    com.tencent.mm.plugin.music.f.c.b.a(com.tencent.mm.plugin.music.e.e.class, (com.tencent.mm.plugin.music.f.c.a)localObject);
    com.tencent.mm.plugin.music.f.c.b.a(com.tencent.mm.plugin.music.e.d.class, new com.tencent.mm.plugin.music.model.d.f());
    AppMethodBeat.o(63035);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(63036);
    k.diP();
    com.tencent.mm.plugin.music.f.c.b.ac(com.tencent.mm.plugin.music.e.e.class);
    this.vfA = null;
    this.vfB = null;
    this.vfC = null;
    a locala = a.a.vfl;
    ((com.tencent.mm.plugin.ball.c.c)g.ab(com.tencent.mm.plugin.ball.c.c.class)).b(6, locala.jPm);
    locala.vfg.dead();
    locala.jyt.b(locala.jyu);
    locala.jyt.end();
    locala.jyw.dead();
    com.tencent.mm.sdk.b.a.GpY.d(this.vco);
    this.vco.dead();
    this.ney.dead();
    this.vfD.dead();
    AppMethodBeat.o(63036);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.f
 * JD-Core Version:    0.7.0.1
 */
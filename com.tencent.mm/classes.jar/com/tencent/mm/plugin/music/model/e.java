package com.tencent.mm.plugin.music.model;

import android.content.ClipboardManager;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.plugin.music.e.m;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.HashMap;

public class e
  implements at
{
  private c gSJ;
  private c<com.tencent.mm.g.a.d> mVr;
  private com.tencent.mm.plugin.music.model.e.b oZE;
  private ClipboardManager oZF;
  private com.tencent.mm.plugin.music.model.e.d oZG;
  private c oZH;
  
  public e()
  {
    AppMethodBeat.i(104898);
    this.oZH = new com.tencent.mm.plugin.music.e.f();
    this.gSJ = new e.3(this);
    this.mVr = new e.4(this);
    AppMethodBeat.o(104898);
  }
  
  private static e bVL()
  {
    AppMethodBeat.i(104899);
    e locale = (e)q.S(e.class);
    AppMethodBeat.o(104899);
    return locale;
  }
  
  public static com.tencent.mm.plugin.music.model.e.b bVM()
  {
    AppMethodBeat.i(104901);
    if (bVL().oZE == null) {
      bVL().oZE = new com.tencent.mm.plugin.music.model.e.b(g.RL().eHS);
    }
    com.tencent.mm.plugin.music.model.e.b localb = bVL().oZE;
    AppMethodBeat.o(104901);
    return localb;
  }
  
  public static ClipboardManager bVN()
  {
    AppMethodBeat.i(104902);
    if (bVL().oZF == null) {
      bVL().oZF = ((ClipboardManager)ah.getContext().getSystemService("clipboard"));
    }
    ClipboardManager localClipboardManager = bVL().oZF;
    AppMethodBeat.o(104902);
    return localClipboardManager;
  }
  
  public static com.tencent.mm.plugin.music.model.e.d bVO()
  {
    AppMethodBeat.i(104903);
    if (bVL().oZG == null) {
      bVL().oZG = new com.tencent.mm.plugin.music.model.e.d(g.RL().eHS);
    }
    com.tencent.mm.plugin.music.model.e.d locald = bVL().oZG;
    AppMethodBeat.o(104903);
    return locald;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.d> getBaseDBFactories()
  {
    AppMethodBeat.i(104900);
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf("Music".hashCode()), new e.1(this));
    localHashMap.put(Integer.valueOf("PieceMusicInfo".hashCode()), new e.2(this));
    AppMethodBeat.o(104900);
    return localHashMap;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(104904);
    this.mVr.alive();
    this.oZH.alive();
    this.gSJ.alive();
    m localm = new m();
    k.a(localm);
    com.tencent.mm.plugin.music.f.c.b.a(com.tencent.mm.plugin.music.e.e.class, localm);
    com.tencent.mm.plugin.music.f.c.b.a(com.tencent.mm.plugin.music.e.d.class, new com.tencent.mm.plugin.music.model.d.f());
    AppMethodBeat.o(104904);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(104905);
    k.bVI();
    com.tencent.mm.plugin.music.f.c.b.F(com.tencent.mm.plugin.music.e.e.class);
    this.oZE = null;
    this.oZF = null;
    this.oZG = null;
    a.ymk.d(this.oZH);
    this.oZH.dead();
    this.gSJ.dead();
    this.mVr.dead();
    AppMethodBeat.o(104905);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.e
 * JD-Core Version:    0.7.0.1
 */
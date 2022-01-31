package com.tencent.mm.plugin.music.model;

import android.content.ClipboardManager;
import android.content.Context;
import com.tencent.mm.cf.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.p;
import com.tencent.mm.plugin.music.e.f;
import com.tencent.mm.plugin.music.e.k;
import com.tencent.mm.plugin.music.e.m;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.HashMap;

public class e
  implements ar
{
  private c fAU = new e.3(this);
  private c<com.tencent.mm.h.a.d> kzB = new e.4(this);
  private com.tencent.mm.plugin.music.model.e.d mzA;
  private c mzB = new f();
  private com.tencent.mm.plugin.music.model.e.b mzy;
  private ClipboardManager mzz;
  
  private static e bnp()
  {
    return (e)p.B(e.class);
  }
  
  public static com.tencent.mm.plugin.music.model.e.b bnq()
  {
    if (bnp().mzy == null) {
      bnp().mzy = new com.tencent.mm.plugin.music.model.e.b(g.DP().dKu);
    }
    return bnp().mzy;
  }
  
  public static ClipboardManager bnr()
  {
    if (bnp().mzz == null) {
      bnp().mzz = ((ClipboardManager)ae.getContext().getSystemService("clipboard"));
    }
    return bnp().mzz;
  }
  
  public static com.tencent.mm.plugin.music.model.e.d bns()
  {
    if (bnp().mzA == null) {
      bnp().mzA = new com.tencent.mm.plugin.music.model.e.d(g.DP().dKu);
    }
    return bnp().mzA;
  }
  
  public final void bh(boolean paramBoolean)
  {
    this.kzB.cqo();
    this.mzB.cqo();
    this.fAU.cqo();
    m localm = new m();
    k.a(localm);
    com.tencent.mm.plugin.music.f.c.b.a(com.tencent.mm.plugin.music.e.e.class, localm);
    com.tencent.mm.plugin.music.f.c.b.a(com.tencent.mm.plugin.music.e.d.class, new com.tencent.mm.plugin.music.model.d.e());
  }
  
  public final void bi(boolean paramBoolean) {}
  
  public final void gf(int paramInt) {}
  
  public final void onAccountRelease()
  {
    k.bnm();
    com.tencent.mm.plugin.music.f.c.b.s(com.tencent.mm.plugin.music.e.e.class);
    this.mzy = null;
    this.mzz = null;
    this.mzA = null;
    a.udP.d(this.mzB);
    this.mzB.dead();
    this.fAU.dead();
    this.kzB.dead();
  }
  
  public final HashMap<Integer, h.d> xe()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf("Music".hashCode()), new e.1(this));
    localHashMap.put(Integer.valueOf("PieceMusicInfo".hashCode()), new e.2(this));
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.model.e
 * JD-Core Version:    0.7.0.1
 */
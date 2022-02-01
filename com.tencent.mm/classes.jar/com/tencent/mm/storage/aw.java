package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.pu;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.b;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.storage.emotion.j;
import com.tencent.mm.storage.emotion.l;
import com.tencent.mm.storage.emotion.n;
import com.tencent.mm.storage.emotion.p;
import com.tencent.mm.storage.emotion.r;
import com.tencent.mm.storage.emotion.s;
import com.tencent.mm.storage.emotion.t;
import com.tencent.mm.storage.emotion.v;
import java.util.ArrayList;
import java.util.HashMap;

public final class aw
{
  public static boolean Fzm;
  private static ArrayList<EmojiGroupInfo> Fzn;
  private static HashMap<String, ArrayList<EmojiInfo>> Fzo;
  private static aw Fzt;
  public static int dEQ;
  public f FyY;
  public com.tencent.mm.storage.emotion.c FyZ;
  public com.tencent.mm.storage.emotion.e Fza;
  public r Fzb;
  public l Fzc;
  public n Fzd;
  public j Fze;
  public p Fzf;
  public s Fzg;
  public t Fzh;
  public com.tencent.mm.storage.emotion.h Fzi;
  public v Fzj;
  private b Fzk;
  public com.tencent.mm.emoji.a.h Fzl;
  public final k.a Fzp;
  public final k.a Fzq;
  public final k.a Fzr;
  public final com.tencent.mm.sdk.b.c Fzs;
  
  static
  {
    AppMethodBeat.i(104977);
    Fzm = false;
    Fzn = new ArrayList();
    Fzo = new HashMap();
    dEQ = -1;
    AppMethodBeat.o(104977);
  }
  
  private aw()
  {
    AppMethodBeat.i(104971);
    this.Fzp = new k.a()
    {
      public final void a(String paramAnonymousString, m paramAnonymousm)
      {
        AppMethodBeat.i(104966);
        if ((!bt.isNullOrNil(paramAnonymousString)) && (paramAnonymousString.equals("event_update_group")))
        {
          ad.d("MicroMsg.emoji.EmojiStorageMgr", "onNotifyChange event:%s", new Object[] { (String)paramAnonymousm.obj });
          if (!g.afz().aeI())
          {
            AppMethodBeat.o(104966);
            return;
          }
          ((d)g.ad(d.class)).getEmojiDescMgr().eLu();
        }
        if ((!bt.isNullOrNil(paramAnonymousString)) && ((paramAnonymousString.equals("event_update_group")) || (paramAnonymousString.equalsIgnoreCase("productID"))))
        {
          ad.d("MicroMsg.emoji.EmojiStorageMgr", "modify emoji gorup .");
          aw.Fzm = true;
          aw.a(aw.this).dm(true);
        }
        AppMethodBeat.o(104966);
      }
    };
    this.Fzq = new k.a()
    {
      public final void a(String paramAnonymousString, m paramAnonymousm)
      {
        AppMethodBeat.i(104967);
        ((d)g.ad(d.class)).getEmojiDescMgr().eLu();
        AppMethodBeat.o(104967);
      }
    };
    this.Fzr = new k.a()
    {
      public final void a(String paramAnonymousString, m paramAnonymousm)
      {
        AppMethodBeat.i(104968);
        if (paramAnonymousString == null)
        {
          AppMethodBeat.o(104968);
          return;
        }
        aw.a(aw.this).dk(true);
        aw.a(aw.this).dl(true);
        aw.a(aw.this).dn(true);
        AppMethodBeat.o(104968);
      }
    };
    this.Fzs = new com.tencent.mm.sdk.b.c() {};
    ad.i("MicroMsg.emoji.EmojiStorageMgr", "EmojiStorageMgr: %s", new Object[] { bt.eGN() });
    AppMethodBeat.o(104971);
  }
  
  public static aw eLx()
  {
    try
    {
      AppMethodBeat.i(104970);
      if (Fzt == null)
      {
        localaw = new aw();
        Fzt = localaw;
        ad.i("MicroMsg.emoji.EmojiStorageMgr", "checkInitStorage: ");
        if (localaw.FyY == null) {
          localaw.eLy();
        }
      }
      aw localaw = Fzt;
      AppMethodBeat.o(104970);
      return localaw;
    }
    finally {}
  }
  
  public final f bxR()
  {
    return this.FyY;
  }
  
  public final b eLA()
  {
    return this.Fzk;
  }
  
  public final void eLy()
  {
    AppMethodBeat.i(104972);
    ad.i("MicroMsg.emoji.EmojiStorageMgr", "initStorage: ");
    if ((g.afB().gda == null) || (!g.afB().gda.isOpen())) {
      ad.w("MicroMsg.emoji.EmojiStorageMgr", "initStorage: db close %s", new Object[] { g.afB().gda });
    }
    this.FyY = new f(g.afB().gda);
    this.FyZ = new com.tencent.mm.storage.emotion.c(g.afB().gda);
    this.Fza = new com.tencent.mm.storage.emotion.e(g.afB().gda);
    this.Fzc = new l(g.afB().gda);
    this.Fzd = new n(g.afB().gda);
    this.Fze = new j(g.afB().gda);
    this.Fzb = new r(g.afB().gda);
    this.Fzf = new p(g.afB().gda);
    this.Fzg = new s(g.afB().gda);
    this.Fzh = new t(g.afB().gda);
    this.Fzi = new com.tencent.mm.storage.emotion.h(g.afB().gda);
    this.Fzj = new v();
    this.Fzk = new b(g.afB().gda);
    this.Fzl = com.tencent.mm.emoji.a.h.abj();
    AppMethodBeat.o(104972);
  }
  
  public final l eLz()
  {
    return this.Fzc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.storage.aw
 * JD-Core Version:    0.7.0.1
 */
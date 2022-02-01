package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.qp;
import com.tencent.mm.kernel.a;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.b;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.storage.emotion.k;
import com.tencent.mm.storage.emotion.o;
import com.tencent.mm.storage.emotion.q;
import com.tencent.mm.storage.emotion.s;
import com.tencent.mm.storage.emotion.t;
import com.tencent.mm.storage.emotion.u;
import com.tencent.mm.storage.emotion.w;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.HashMap;

public final class be
{
  public static boolean Jgj;
  private static ArrayList<EmojiGroupInfo> Jgk;
  private static HashMap<String, ArrayList<EmojiInfo>> Jgl;
  private static be Jgq;
  public static int dQf;
  public f JfU;
  public com.tencent.mm.storage.emotion.c JfV;
  public com.tencent.mm.storage.emotion.e JfW;
  public s JfX;
  public com.tencent.mm.storage.emotion.m JfY;
  public o JfZ;
  public k Jga;
  public q Jgb;
  public t Jgc;
  public u Jgd;
  public com.tencent.mm.storage.emotion.i Jge;
  public w Jgf;
  private b Jgg;
  private com.tencent.mm.storage.emotion.g Jgh;
  public com.tencent.mm.emoji.a.i Jgi;
  public final k.a Jgm;
  public final k.a Jgn;
  public final k.a Jgo;
  public final com.tencent.mm.sdk.b.c Jgp;
  
  static
  {
    AppMethodBeat.i(104977);
    Jgj = false;
    Jgk = new ArrayList();
    Jgl = new HashMap();
    dQf = -1;
    AppMethodBeat.o(104977);
  }
  
  private be()
  {
    AppMethodBeat.i(104971);
    this.Jgm = new k.a()
    {
      public final void a(String paramAnonymousString, com.tencent.mm.sdk.e.m paramAnonymousm)
      {
        AppMethodBeat.i(104966);
        if ((!bu.isNullOrNil(paramAnonymousString)) && (paramAnonymousString.equals("event_update_group")))
        {
          ae.d("MicroMsg.emoji.EmojiStorageMgr", "onNotifyChange event:%s", new Object[] { (String)paramAnonymousm.obj });
          if (!com.tencent.mm.kernel.g.ajP().aiZ())
          {
            AppMethodBeat.o(104966);
            return;
          }
          ((d)com.tencent.mm.kernel.g.ad(d.class)).getEmojiDescMgr().fuZ();
        }
        if ((!bu.isNullOrNil(paramAnonymousString)) && ((paramAnonymousString.equals("event_update_group")) || (paramAnonymousString.equalsIgnoreCase("productID"))))
        {
          ae.d("MicroMsg.emoji.EmojiStorageMgr", "modify emoji gorup .");
          be.Jgj = true;
          be.a(be.this).dn(true);
        }
        AppMethodBeat.o(104966);
      }
    };
    this.Jgn = new k.a()
    {
      public final void a(String paramAnonymousString, com.tencent.mm.sdk.e.m paramAnonymousm)
      {
        AppMethodBeat.i(104967);
        ((d)com.tencent.mm.kernel.g.ad(d.class)).getEmojiDescMgr().fuZ();
        AppMethodBeat.o(104967);
      }
    };
    this.Jgo = new k.a()
    {
      public final void a(String paramAnonymousString, com.tencent.mm.sdk.e.m paramAnonymousm)
      {
        AppMethodBeat.i(104968);
        if (paramAnonymousString == null)
        {
          AppMethodBeat.o(104968);
          return;
        }
        be.a(be.this).dl(true);
        be.a(be.this).dm(true);
        be.a(be.this).jdMethod_do(true);
        AppMethodBeat.o(104968);
      }
    };
    this.Jgp = new com.tencent.mm.sdk.b.c() {};
    ae.i("MicroMsg.emoji.EmojiStorageMgr", "EmojiStorageMgr: %s", new Object[] { bu.fpN() });
    AppMethodBeat.o(104971);
  }
  
  public static be fvc()
  {
    try
    {
      AppMethodBeat.i(104970);
      if (Jgq == null)
      {
        localbe = new be();
        Jgq = localbe;
        ae.i("MicroMsg.emoji.EmojiStorageMgr", "checkInitStorage: ");
        if (localbe.JfU == null) {
          localbe.fvd();
        }
      }
      be localbe = Jgq;
      AppMethodBeat.o(104970);
      return localbe;
    }
    finally {}
  }
  
  public final f bJU()
  {
    return this.JfU;
  }
  
  public final void fvd()
  {
    AppMethodBeat.i(104972);
    ae.i("MicroMsg.emoji.EmojiStorageMgr", "initStorage: ");
    if ((com.tencent.mm.kernel.g.ajR().gDX == null) || (!com.tencent.mm.kernel.g.ajR().gDX.isOpen())) {
      ae.w("MicroMsg.emoji.EmojiStorageMgr", "initStorage: db close %s", new Object[] { com.tencent.mm.kernel.g.ajR().gDX });
    }
    this.JfU = new f(com.tencent.mm.kernel.g.ajR().gDX);
    this.JfV = new com.tencent.mm.storage.emotion.c(com.tencent.mm.kernel.g.ajR().gDX);
    this.JfW = new com.tencent.mm.storage.emotion.e(com.tencent.mm.kernel.g.ajR().gDX);
    this.JfY = new com.tencent.mm.storage.emotion.m(com.tencent.mm.kernel.g.ajR().gDX);
    this.JfZ = new o(com.tencent.mm.kernel.g.ajR().gDX);
    this.Jga = new k(com.tencent.mm.kernel.g.ajR().gDX);
    this.JfX = new s(com.tencent.mm.kernel.g.ajR().gDX);
    this.Jgb = new q(com.tencent.mm.kernel.g.ajR().gDX);
    this.Jgc = new t(com.tencent.mm.kernel.g.ajR().gDX);
    this.Jgd = new u(com.tencent.mm.kernel.g.ajR().gDX);
    this.Jge = new com.tencent.mm.storage.emotion.i(com.tencent.mm.kernel.g.ajR().gDX);
    this.Jgf = new w();
    this.Jgg = new b(com.tencent.mm.kernel.g.ajR().gDX);
    this.Jgh = new com.tencent.mm.storage.emotion.g(com.tencent.mm.kernel.g.ajR().gDX);
    this.Jgi = com.tencent.mm.emoji.a.i.aeX();
    AppMethodBeat.o(104972);
  }
  
  public final com.tencent.mm.storage.emotion.m fve()
  {
    return this.JfY;
  }
  
  public final s fvf()
  {
    return this.JfX;
  }
  
  public final b fvg()
  {
    return this.Jgg;
  }
  
  public final com.tencent.mm.storage.emotion.g fvh()
  {
    return this.Jgh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.storage.be
 * JD-Core Version:    0.7.0.1
 */
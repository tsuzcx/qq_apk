package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.qo;
import com.tencent.mm.kernel.a;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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

public final class bd
{
  public static boolean ILC;
  private static ArrayList<EmojiGroupInfo> ILD;
  private static HashMap<String, ArrayList<EmojiInfo>> ILE;
  private static bd ILJ;
  public static int dOP;
  private com.tencent.mm.storage.emotion.g ILA;
  public com.tencent.mm.emoji.a.i ILB;
  public final k.a ILF;
  public final k.a ILG;
  public final k.a ILH;
  public final com.tencent.mm.sdk.b.c ILI;
  public f ILn;
  public com.tencent.mm.storage.emotion.c ILo;
  public com.tencent.mm.storage.emotion.e ILp;
  public s ILq;
  public com.tencent.mm.storage.emotion.m ILr;
  public o ILs;
  public k ILt;
  public q ILu;
  public t ILv;
  public u ILw;
  public com.tencent.mm.storage.emotion.i ILx;
  public w ILy;
  private b ILz;
  
  static
  {
    AppMethodBeat.i(104977);
    ILC = false;
    ILD = new ArrayList();
    ILE = new HashMap();
    dOP = -1;
    AppMethodBeat.o(104977);
  }
  
  private bd()
  {
    AppMethodBeat.i(104971);
    this.ILF = new k.a()
    {
      public final void a(String paramAnonymousString, com.tencent.mm.sdk.e.m paramAnonymousm)
      {
        AppMethodBeat.i(104966);
        if ((!bt.isNullOrNil(paramAnonymousString)) && (paramAnonymousString.equals("event_update_group")))
        {
          ad.d("MicroMsg.emoji.EmojiStorageMgr", "onNotifyChange event:%s", new Object[] { (String)paramAnonymousm.obj });
          if (!com.tencent.mm.kernel.g.ajA().aiK())
          {
            AppMethodBeat.o(104966);
            return;
          }
          ((d)com.tencent.mm.kernel.g.ad(d.class)).getEmojiDescMgr().fqZ();
        }
        if ((!bt.isNullOrNil(paramAnonymousString)) && ((paramAnonymousString.equals("event_update_group")) || (paramAnonymousString.equalsIgnoreCase("productID"))))
        {
          ad.d("MicroMsg.emoji.EmojiStorageMgr", "modify emoji gorup .");
          bd.ILC = true;
          bd.a(bd.this).dn(true);
        }
        AppMethodBeat.o(104966);
      }
    };
    this.ILG = new k.a()
    {
      public final void a(String paramAnonymousString, com.tencent.mm.sdk.e.m paramAnonymousm)
      {
        AppMethodBeat.i(104967);
        ((d)com.tencent.mm.kernel.g.ad(d.class)).getEmojiDescMgr().fqZ();
        AppMethodBeat.o(104967);
      }
    };
    this.ILH = new k.a()
    {
      public final void a(String paramAnonymousString, com.tencent.mm.sdk.e.m paramAnonymousm)
      {
        AppMethodBeat.i(104968);
        if (paramAnonymousString == null)
        {
          AppMethodBeat.o(104968);
          return;
        }
        bd.a(bd.this).dl(true);
        bd.a(bd.this).dm(true);
        bd.a(bd.this).jdMethod_do(true);
        AppMethodBeat.o(104968);
      }
    };
    this.ILI = new com.tencent.mm.sdk.b.c() {};
    ad.i("MicroMsg.emoji.EmojiStorageMgr", "EmojiStorageMgr: %s", new Object[] { bt.flS() });
    AppMethodBeat.o(104971);
  }
  
  public static bd frc()
  {
    try
    {
      AppMethodBeat.i(104970);
      if (ILJ == null)
      {
        localbd = new bd();
        ILJ = localbd;
        ad.i("MicroMsg.emoji.EmojiStorageMgr", "checkInitStorage: ");
        if (localbd.ILn == null) {
          localbd.frd();
        }
      }
      bd localbd = ILJ;
      AppMethodBeat.o(104970);
      return localbd;
    }
    finally {}
  }
  
  public final f bIW()
  {
    return this.ILn;
  }
  
  public final void frd()
  {
    AppMethodBeat.i(104972);
    ad.i("MicroMsg.emoji.EmojiStorageMgr", "initStorage: ");
    if ((com.tencent.mm.kernel.g.ajC().gBq == null) || (!com.tencent.mm.kernel.g.ajC().gBq.isOpen())) {
      ad.w("MicroMsg.emoji.EmojiStorageMgr", "initStorage: db close %s", new Object[] { com.tencent.mm.kernel.g.ajC().gBq });
    }
    this.ILn = new f(com.tencent.mm.kernel.g.ajC().gBq);
    this.ILo = new com.tencent.mm.storage.emotion.c(com.tencent.mm.kernel.g.ajC().gBq);
    this.ILp = new com.tencent.mm.storage.emotion.e(com.tencent.mm.kernel.g.ajC().gBq);
    this.ILr = new com.tencent.mm.storage.emotion.m(com.tencent.mm.kernel.g.ajC().gBq);
    this.ILs = new o(com.tencent.mm.kernel.g.ajC().gBq);
    this.ILt = new k(com.tencent.mm.kernel.g.ajC().gBq);
    this.ILq = new s(com.tencent.mm.kernel.g.ajC().gBq);
    this.ILu = new q(com.tencent.mm.kernel.g.ajC().gBq);
    this.ILv = new t(com.tencent.mm.kernel.g.ajC().gBq);
    this.ILw = new u(com.tencent.mm.kernel.g.ajC().gBq);
    this.ILx = new com.tencent.mm.storage.emotion.i(com.tencent.mm.kernel.g.ajC().gBq);
    this.ILy = new w();
    this.ILz = new b(com.tencent.mm.kernel.g.ajC().gBq);
    this.ILA = new com.tencent.mm.storage.emotion.g(com.tencent.mm.kernel.g.ajC().gBq);
    this.ILB = com.tencent.mm.emoji.a.i.aeL();
    AppMethodBeat.o(104972);
  }
  
  public final com.tencent.mm.storage.emotion.m fre()
  {
    return this.ILr;
  }
  
  public final s frf()
  {
    return this.ILq;
  }
  
  public final b frg()
  {
    return this.ILz;
  }
  
  public final com.tencent.mm.storage.emotion.g frh()
  {
    return this.ILA;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.bd
 * JD-Core Version:    0.7.0.1
 */
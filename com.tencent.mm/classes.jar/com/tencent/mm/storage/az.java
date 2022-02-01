package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.qd;
import com.tencent.mm.kernel.a;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
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

public final class az
{
  public static boolean GYo;
  private static ArrayList<EmojiGroupInfo> GYp;
  private static HashMap<String, ArrayList<EmojiInfo>> GYq;
  private static az GYv;
  public static int dCC;
  public f GXZ;
  public com.tencent.mm.storage.emotion.c GYa;
  public com.tencent.mm.storage.emotion.e GYb;
  public s GYc;
  public com.tencent.mm.storage.emotion.m GYd;
  public o GYe;
  public k GYf;
  public q GYg;
  public t GYh;
  public u GYi;
  public com.tencent.mm.storage.emotion.i GYj;
  public w GYk;
  private b GYl;
  private com.tencent.mm.storage.emotion.g GYm;
  public com.tencent.mm.emoji.a.i GYn;
  public final k.a GYr;
  public final k.a GYs;
  public final k.a GYt;
  public final com.tencent.mm.sdk.b.c GYu;
  
  static
  {
    AppMethodBeat.i(104977);
    GYo = false;
    GYp = new ArrayList();
    GYq = new HashMap();
    dCC = -1;
    AppMethodBeat.o(104977);
  }
  
  private az()
  {
    AppMethodBeat.i(104971);
    this.GYr = new k.a()
    {
      public final void a(String paramAnonymousString, com.tencent.mm.sdk.e.m paramAnonymousm)
      {
        AppMethodBeat.i(104966);
        if ((!bs.isNullOrNil(paramAnonymousString)) && (paramAnonymousString.equals("event_update_group")))
        {
          ac.d("MicroMsg.emoji.EmojiStorageMgr", "onNotifyChange event:%s", new Object[] { (String)paramAnonymousm.obj });
          if (!com.tencent.mm.kernel.g.agP().afY())
          {
            AppMethodBeat.o(104966);
            return;
          }
          ((d)com.tencent.mm.kernel.g.ad(d.class)).getEmojiDescMgr().faW();
        }
        if ((!bs.isNullOrNil(paramAnonymousString)) && ((paramAnonymousString.equals("event_update_group")) || (paramAnonymousString.equalsIgnoreCase("productID"))))
        {
          ac.d("MicroMsg.emoji.EmojiStorageMgr", "modify emoji gorup .");
          az.GYo = true;
          az.a(az.this).dl(true);
        }
        AppMethodBeat.o(104966);
      }
    };
    this.GYs = new k.a()
    {
      public final void a(String paramAnonymousString, com.tencent.mm.sdk.e.m paramAnonymousm)
      {
        AppMethodBeat.i(104967);
        ((d)com.tencent.mm.kernel.g.ad(d.class)).getEmojiDescMgr().faW();
        AppMethodBeat.o(104967);
      }
    };
    this.GYt = new k.a()
    {
      public final void a(String paramAnonymousString, com.tencent.mm.sdk.e.m paramAnonymousm)
      {
        AppMethodBeat.i(104968);
        if (paramAnonymousString == null)
        {
          AppMethodBeat.o(104968);
          return;
        }
        az.a(az.this).dj(true);
        az.a(az.this).dk(true);
        az.a(az.this).dm(true);
        AppMethodBeat.o(104968);
      }
    };
    this.GYu = new com.tencent.mm.sdk.b.c() {};
    ac.i("MicroMsg.emoji.EmojiStorageMgr", "EmojiStorageMgr: %s", new Object[] { bs.eWi() });
    AppMethodBeat.o(104971);
  }
  
  public static az faZ()
  {
    try
    {
      AppMethodBeat.i(104970);
      if (GYv == null)
      {
        localaz = new az();
        GYv = localaz;
        ac.i("MicroMsg.emoji.EmojiStorageMgr", "checkInitStorage: ");
        if (localaz.GXZ == null) {
          localaz.fba();
        }
      }
      az localaz = GYv;
      AppMethodBeat.o(104970);
      return localaz;
    }
    finally {}
  }
  
  public final f bEN()
  {
    return this.GXZ;
  }
  
  public final void fba()
  {
    AppMethodBeat.i(104972);
    ac.i("MicroMsg.emoji.EmojiStorageMgr", "initStorage: ");
    if ((com.tencent.mm.kernel.g.agR().ghG == null) || (!com.tencent.mm.kernel.g.agR().ghG.isOpen())) {
      ac.w("MicroMsg.emoji.EmojiStorageMgr", "initStorage: db close %s", new Object[] { com.tencent.mm.kernel.g.agR().ghG });
    }
    this.GXZ = new f(com.tencent.mm.kernel.g.agR().ghG);
    this.GYa = new com.tencent.mm.storage.emotion.c(com.tencent.mm.kernel.g.agR().ghG);
    this.GYb = new com.tencent.mm.storage.emotion.e(com.tencent.mm.kernel.g.agR().ghG);
    this.GYd = new com.tencent.mm.storage.emotion.m(com.tencent.mm.kernel.g.agR().ghG);
    this.GYe = new o(com.tencent.mm.kernel.g.agR().ghG);
    this.GYf = new k(com.tencent.mm.kernel.g.agR().ghG);
    this.GYc = new s(com.tencent.mm.kernel.g.agR().ghG);
    this.GYg = new q(com.tencent.mm.kernel.g.agR().ghG);
    this.GYh = new t(com.tencent.mm.kernel.g.agR().ghG);
    this.GYi = new u(com.tencent.mm.kernel.g.agR().ghG);
    this.GYj = new com.tencent.mm.storage.emotion.i(com.tencent.mm.kernel.g.agR().ghG);
    this.GYk = new w();
    this.GYl = new b(com.tencent.mm.kernel.g.agR().ghG);
    this.GYm = new com.tencent.mm.storage.emotion.g(com.tencent.mm.kernel.g.agR().ghG);
    this.GYn = com.tencent.mm.emoji.a.i.ach();
    AppMethodBeat.o(104972);
  }
  
  public final com.tencent.mm.storage.emotion.m fbb()
  {
    return this.GYd;
  }
  
  public final s fbc()
  {
    return this.GYc;
  }
  
  public final b fbd()
  {
    return this.GYl;
  }
  
  public final com.tencent.mm.storage.emotion.g fbe()
  {
    return this.GYm;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.storage.az
 * JD-Core Version:    0.7.0.1
 */
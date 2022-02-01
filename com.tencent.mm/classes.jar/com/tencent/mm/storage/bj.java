package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.b.j;
import com.tencent.mm.g.a.rj;
import com.tencent.mm.kernel.a;
import com.tencent.mm.plugin.emoji.b.d;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.b;
import com.tencent.mm.storage.emotion.c;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.storage.emotion.i;
import com.tencent.mm.storage.emotion.k;
import com.tencent.mm.storage.emotion.m;
import com.tencent.mm.storage.emotion.o;
import com.tencent.mm.storage.emotion.q;
import com.tencent.mm.storage.emotion.s;
import com.tencent.mm.storage.emotion.t;
import com.tencent.mm.storage.emotion.u;
import com.tencent.mm.storage.emotion.w;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.HashMap;

public final class bj
{
  public static boolean Oqc;
  private static ArrayList<EmojiGroupInfo> Oqd;
  private static HashMap<String, ArrayList<EmojiInfo>> Oqe;
  private static bj Oqh;
  public static int eii;
  public f OpN;
  public c OpO;
  public com.tencent.mm.storage.emotion.e OpP;
  public s OpQ;
  public m OpR;
  public o OpS;
  public k OpT;
  public q OpU;
  public t OpV;
  public u OpW;
  public i OpX;
  public w OpY;
  private b OpZ;
  private com.tencent.mm.storage.emotion.g Oqa;
  public j Oqb;
  public final MStorage.IOnStorageChange Oqf;
  public final MStorage.IOnStorageChange Oqg;
  public final MStorage.IOnStorageChange wKf;
  public final IListener wKg;
  
  static
  {
    AppMethodBeat.i(104977);
    Oqc = false;
    Oqd = new ArrayList();
    Oqe = new HashMap();
    eii = -1;
    AppMethodBeat.o(104977);
  }
  
  private bj()
  {
    AppMethodBeat.i(104971);
    this.Oqf = new MStorage.IOnStorageChange()
    {
      public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
      {
        AppMethodBeat.i(104966);
        if ((!Util.isNullOrNil(paramAnonymousString)) && (paramAnonymousString.equals("event_update_group")))
        {
          Log.d("MicroMsg.emoji.EmojiStorageMgr", "onNotifyChange event:%s", new Object[] { (String)paramAnonymousMStorageEventData.obj });
          if (!com.tencent.mm.kernel.g.aAf().azp())
          {
            AppMethodBeat.o(104966);
            return;
          }
          ((d)com.tencent.mm.kernel.g.ah(d.class)).getEmojiDescMgr().gCG();
        }
        if ((!Util.isNullOrNil(paramAnonymousString)) && ((paramAnonymousString.equals("event_update_group")) || (paramAnonymousString.equalsIgnoreCase("productID"))))
        {
          Log.d("MicroMsg.emoji.EmojiStorageMgr", "modify emoji gorup .");
          bj.Oqc = true;
          bj.a(bj.this).dX(true);
        }
        AppMethodBeat.o(104966);
      }
    };
    this.Oqg = new MStorage.IOnStorageChange()
    {
      public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
      {
        AppMethodBeat.i(104967);
        ((d)com.tencent.mm.kernel.g.ah(d.class)).getEmojiDescMgr().gCG();
        AppMethodBeat.o(104967);
      }
    };
    this.wKf = new MStorage.IOnStorageChange()
    {
      public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
      {
        AppMethodBeat.i(104968);
        if (paramAnonymousString == null)
        {
          AppMethodBeat.o(104968);
          return;
        }
        bj.a(bj.this).dV(true);
        bj.a(bj.this).dW(true);
        bj.a(bj.this).dY(true);
        AppMethodBeat.o(104968);
      }
    };
    this.wKg = new IListener() {};
    Log.i("MicroMsg.emoji.EmojiStorageMgr", "EmojiStorageMgr: %s", new Object[] { Util.getStack() });
    AppMethodBeat.o(104971);
  }
  
  public static bj gCJ()
  {
    try
    {
      AppMethodBeat.i(104970);
      if (Oqh == null)
      {
        localbj = new bj();
        Oqh = localbj;
        Log.i("MicroMsg.emoji.EmojiStorageMgr", "checkInitStorage: ");
        if (localbj.OpN == null) {
          localbj.gCK();
        }
      }
      bj localbj = Oqh;
      AppMethodBeat.o(104970);
      return localbj;
    }
    finally {}
  }
  
  public final f cgN()
  {
    return this.OpN;
  }
  
  public final void gCK()
  {
    AppMethodBeat.i(104972);
    Log.i("MicroMsg.emoji.EmojiStorageMgr", "initStorage: ");
    if ((com.tencent.mm.kernel.g.aAh().hqK == null) || (!com.tencent.mm.kernel.g.aAh().hqK.isOpen())) {
      Log.w("MicroMsg.emoji.EmojiStorageMgr", "initStorage: db close %s", new Object[] { com.tencent.mm.kernel.g.aAh().hqK });
    }
    this.OpN = new f(com.tencent.mm.kernel.g.aAh().hqK);
    this.OpO = new c(com.tencent.mm.kernel.g.aAh().hqK);
    this.OpP = new com.tencent.mm.storage.emotion.e(com.tencent.mm.kernel.g.aAh().hqK);
    this.OpR = new m(com.tencent.mm.kernel.g.aAh().hqK);
    this.OpS = new o(com.tencent.mm.kernel.g.aAh().hqK);
    this.OpT = new k(com.tencent.mm.kernel.g.aAh().hqK);
    this.OpQ = new s(com.tencent.mm.kernel.g.aAh().hqK);
    this.OpU = new q(com.tencent.mm.kernel.g.aAh().hqK);
    this.OpV = new t(com.tencent.mm.kernel.g.aAh().hqK);
    this.OpW = new u(com.tencent.mm.kernel.g.aAh().hqK);
    this.OpX = new i(com.tencent.mm.kernel.g.aAh().hqK);
    this.OpY = new w();
    this.OpZ = new b(com.tencent.mm.kernel.g.aAh().hqK);
    this.Oqa = new com.tencent.mm.storage.emotion.g(com.tencent.mm.kernel.g.aAh().hqK);
    this.Oqb = j.auL();
    AppMethodBeat.o(104972);
  }
  
  public final m gCL()
  {
    return this.OpR;
  }
  
  public final s gCM()
  {
    return this.OpQ;
  }
  
  public final b gCN()
  {
    return this.OpZ;
  }
  
  public final com.tencent.mm.storage.emotion.g gCO()
  {
    return this.Oqa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.storage.bj
 * JD-Core Version:    0.7.0.1
 */
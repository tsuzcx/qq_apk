package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.c.l;
import com.tencent.mm.plugin.emoji.c.d;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.c;
import com.tencent.mm.storage.emotion.e;
import com.tencent.mm.storage.emotion.g;
import com.tencent.mm.storage.emotion.i;
import com.tencent.mm.storage.emotion.k;
import com.tencent.mm.storage.emotion.m;
import com.tencent.mm.storage.emotion.o;
import com.tencent.mm.storage.emotion.q;
import com.tencent.mm.storage.emotion.s;
import com.tencent.mm.storage.emotion.u;
import com.tencent.mm.storage.emotion.v;
import com.tencent.mm.storage.emotion.w;
import com.tencent.mm.storage.emotion.y;
import java.util.ArrayList;
import java.util.HashMap;

public class bl
{
  public static boolean adjK;
  private static ArrayList<EmojiGroupInfo> adjL;
  private static HashMap<String, ArrayList<EmojiInfo>> adjM;
  private static bl adjR;
  private static int iiL;
  public o adjA;
  public k adjB;
  public q adjC;
  public v adjD;
  public w adjE;
  public i adjF;
  public y adjG;
  public com.tencent.mm.storage.emotion.b adjH;
  public g adjI;
  public l adjJ;
  public final MStorage.IOnStorageChange adjN;
  public final MStorage.IOnStorageChange adjO;
  public final MStorage.IOnStorageChange adjP;
  public final IListener adjQ;
  public com.tencent.mm.storage.emotion.f adju;
  public c adjv;
  public e adjw;
  public s adjx;
  public u adjy;
  public m adjz;
  
  static
  {
    AppMethodBeat.i(104977);
    adjK = false;
    adjL = new ArrayList();
    adjM = new HashMap();
    iiL = -1;
    AppMethodBeat.o(104977);
  }
  
  private bl()
  {
    AppMethodBeat.i(104971);
    this.adjN = new MStorage.IOnStorageChange()
    {
      public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
      {
        AppMethodBeat.i(104966);
        if ((!Util.isNullOrNil(paramAnonymousString)) && (paramAnonymousString.equals("event_update_group")))
        {
          Log.d("MicroMsg.emoji.EmojiStorageMgr", "onNotifyChange event:%s", new Object[] { (String)paramAnonymousMStorageEventData.obj });
          if (!com.tencent.mm.kernel.h.baC().aZN())
          {
            AppMethodBeat.o(104966);
            return;
          }
          ((d)com.tencent.mm.kernel.h.az(d.class)).getEmojiDescMgr().jaY();
        }
        if ((!Util.isNullOrNil(paramAnonymousString)) && ((paramAnonymousString.equals("event_update_group")) || (paramAnonymousString.equalsIgnoreCase("productID"))))
        {
          Log.d("MicroMsg.emoji.EmojiStorageMgr", "modify emoji gorup .");
          bl.adjK = true;
          bl.a(bl.this).fh(true);
        }
        AppMethodBeat.o(104966);
      }
    };
    this.adjO = new MStorage.IOnStorageChange()
    {
      public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
      {
        AppMethodBeat.i(104967);
        ((d)com.tencent.mm.kernel.h.az(d.class)).getEmojiDescMgr().jaY();
        AppMethodBeat.o(104967);
      }
    };
    this.adjP = new MStorage.IOnStorageChange()
    {
      public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
      {
        AppMethodBeat.i(104968);
        if (paramAnonymousString == null)
        {
          AppMethodBeat.o(104968);
          return;
        }
        bl.a(bl.this).ff(true);
        bl.a(bl.this).fg(true);
        bl.a(bl.this).fi(true);
        AppMethodBeat.o(104968);
      }
    };
    this.adjQ = new EmojiStorageMgr.4(this, com.tencent.mm.app.f.hfK);
    Log.i("MicroMsg.emoji.EmojiStorageMgr", "EmojiStorageMgr: %s", new Object[] { Util.getStack() });
    AppMethodBeat.o(104971);
  }
  
  public static bl jba()
  {
    try
    {
      AppMethodBeat.i(104970);
      if (adjR == null)
      {
        localbl = new bl();
        adjR = localbl;
        Log.i("MicroMsg.emoji.EmojiStorageMgr", "checkInitStorage: ");
        if (localbl.adju == null) {
          localbl.jbb();
        }
      }
      bl localbl = adjR;
      AppMethodBeat.o(104970);
      return localbl;
    }
    finally {}
  }
  
  public final com.tencent.mm.storage.emotion.f cWI()
  {
    return this.adju;
  }
  
  public final void jbb()
  {
    AppMethodBeat.i(104972);
    Log.i("MicroMsg.emoji.EmojiStorageMgr", "initStorage: ");
    if ((com.tencent.mm.kernel.h.baE().mCN == null) || (!com.tencent.mm.kernel.h.baE().mCN.isOpen())) {
      Log.w("MicroMsg.emoji.EmojiStorageMgr", "initStorage: db close %s", new Object[] { com.tencent.mm.kernel.h.baE().mCN });
    }
    this.adju = new com.tencent.mm.storage.emotion.f(com.tencent.mm.kernel.h.baE().mCN);
    this.adjv = new c(com.tencent.mm.kernel.h.baE().mCN);
    this.adjw = new e(com.tencent.mm.kernel.h.baE().mCN);
    this.adjz = new m(com.tencent.mm.kernel.h.baE().mCN);
    this.adjA = new o(com.tencent.mm.kernel.h.baE().mCN);
    this.adjB = new k(com.tencent.mm.kernel.h.baE().mCN);
    this.adjx = new s(com.tencent.mm.kernel.h.baE().mCN);
    this.adjy = new u(com.tencent.mm.kernel.h.baE().mCN);
    this.adjC = new q(com.tencent.mm.kernel.h.baE().mCN);
    this.adjD = new v(com.tencent.mm.kernel.h.baE().mCN);
    this.adjE = new w(com.tencent.mm.kernel.h.baE().mCN);
    this.adjF = new i(com.tencent.mm.kernel.h.baE().mCN);
    this.adjG = new y();
    this.adjH = new com.tencent.mm.storage.emotion.b(com.tencent.mm.kernel.h.baE().mCN);
    this.adjI = new g(com.tencent.mm.kernel.h.baE().mCN);
    this.adjJ = l.aUF();
    AppMethodBeat.o(104972);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.storage.bl
 * JD-Core Version:    0.7.0.1
 */
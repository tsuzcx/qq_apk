package com.tencent.mm.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.si;
import com.tencent.mm.plugin.emoji.b.d;
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
import com.tencent.mm.storage.emotion.m;
import com.tencent.mm.storage.emotion.o;
import com.tencent.mm.storage.emotion.q;
import com.tencent.mm.storage.emotion.s;
import com.tencent.mm.storage.emotion.t;
import com.tencent.mm.storage.emotion.u;
import com.tencent.mm.storage.emotion.w;
import java.util.ArrayList;
import java.util.HashMap;

public class bj
{
  public static boolean VFW;
  private static ArrayList<EmojiGroupInfo> VFX;
  private static HashMap<String, ArrayList<EmojiInfo>> VFY;
  private static bj VGd;
  private static int gcz;
  public com.tencent.mm.storage.emotion.f VFH;
  public c VFI;
  public e VFJ;
  public s VFK;
  public m VFL;
  public o VFM;
  public com.tencent.mm.storage.emotion.k VFN;
  public q VFO;
  public t VFP;
  public u VFQ;
  public i VFR;
  public w VFS;
  private com.tencent.mm.storage.emotion.b VFT;
  private g VFU;
  public com.tencent.mm.emoji.b.k VFV;
  public final MStorage.IOnStorageChange VFZ;
  public final MStorage.IOnStorageChange VGa;
  public final MStorage.IOnStorageChange VGb;
  public final IListener VGc;
  
  static
  {
    AppMethodBeat.i(104977);
    VFW = false;
    VFX = new ArrayList();
    VFY = new HashMap();
    gcz = -1;
    AppMethodBeat.o(104977);
  }
  
  private bj()
  {
    AppMethodBeat.i(104971);
    this.VFZ = new MStorage.IOnStorageChange()
    {
      public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
      {
        AppMethodBeat.i(104966);
        if ((!Util.isNullOrNil(paramAnonymousString)) && (paramAnonymousString.equals("event_update_group")))
        {
          Log.d("MicroMsg.emoji.EmojiStorageMgr", "onNotifyChange event:%s", new Object[] { (String)paramAnonymousMStorageEventData.obj });
          if (!com.tencent.mm.kernel.h.aHE().aGM())
          {
            AppMethodBeat.o(104966);
            return;
          }
          ((d)com.tencent.mm.kernel.h.ag(d.class)).getEmojiDescMgr().hyS();
        }
        if ((!Util.isNullOrNil(paramAnonymousString)) && ((paramAnonymousString.equals("event_update_group")) || (paramAnonymousString.equalsIgnoreCase("productID"))))
        {
          Log.d("MicroMsg.emoji.EmojiStorageMgr", "modify emoji gorup .");
          bj.VFW = true;
          bj.a(bj.this).ev(true);
        }
        AppMethodBeat.o(104966);
      }
    };
    this.VGa = new MStorage.IOnStorageChange()
    {
      public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
      {
        AppMethodBeat.i(104967);
        ((d)com.tencent.mm.kernel.h.ag(d.class)).getEmojiDescMgr().hyS();
        AppMethodBeat.o(104967);
      }
    };
    this.VGb = new MStorage.IOnStorageChange()
    {
      public final void onNotifyChange(String paramAnonymousString, MStorageEventData paramAnonymousMStorageEventData)
      {
        AppMethodBeat.i(104968);
        if (paramAnonymousString == null)
        {
          AppMethodBeat.o(104968);
          return;
        }
        bj.a(bj.this).et(true);
        bj.a(bj.this).eu(true);
        bj.a(bj.this).ew(true);
        AppMethodBeat.o(104968);
      }
    };
    this.VGc = new IListener() {};
    Log.i("MicroMsg.emoji.EmojiStorageMgr", "EmojiStorageMgr: %s", new Object[] { Util.getStack() });
    AppMethodBeat.o(104971);
  }
  
  public static bj hyV()
  {
    try
    {
      AppMethodBeat.i(104970);
      if (VGd == null)
      {
        localbj = new bj();
        VGd = localbj;
        Log.i("MicroMsg.emoji.EmojiStorageMgr", "checkInitStorage: ");
        if (localbj.VFH == null) {
          localbj.hyW();
        }
      }
      bj localbj = VGd;
      AppMethodBeat.o(104970);
      return localbj;
    }
    finally {}
  }
  
  public final com.tencent.mm.storage.emotion.f ctY()
  {
    return this.VFH;
  }
  
  public final void hyW()
  {
    AppMethodBeat.i(104972);
    Log.i("MicroMsg.emoji.EmojiStorageMgr", "initStorage: ");
    if ((com.tencent.mm.kernel.h.aHG().kcF == null) || (!com.tencent.mm.kernel.h.aHG().kcF.isOpen())) {
      Log.w("MicroMsg.emoji.EmojiStorageMgr", "initStorage: db close %s", new Object[] { com.tencent.mm.kernel.h.aHG().kcF });
    }
    this.VFH = new com.tencent.mm.storage.emotion.f(com.tencent.mm.kernel.h.aHG().kcF);
    this.VFI = new c(com.tencent.mm.kernel.h.aHG().kcF);
    this.VFJ = new e(com.tencent.mm.kernel.h.aHG().kcF);
    this.VFL = new m(com.tencent.mm.kernel.h.aHG().kcF);
    this.VFM = new o(com.tencent.mm.kernel.h.aHG().kcF);
    this.VFN = new com.tencent.mm.storage.emotion.k(com.tencent.mm.kernel.h.aHG().kcF);
    this.VFK = new s(com.tencent.mm.kernel.h.aHG().kcF);
    this.VFO = new q(com.tencent.mm.kernel.h.aHG().kcF);
    this.VFP = new t(com.tencent.mm.kernel.h.aHG().kcF);
    this.VFQ = new u(com.tencent.mm.kernel.h.aHG().kcF);
    this.VFR = new i(com.tencent.mm.kernel.h.aHG().kcF);
    this.VFS = new w();
    this.VFT = new com.tencent.mm.storage.emotion.b(com.tencent.mm.kernel.h.aHG().kcF);
    this.VFU = new g(com.tencent.mm.kernel.h.aHG().kcF);
    this.VFV = com.tencent.mm.emoji.b.k.aBH();
    AppMethodBeat.o(104972);
  }
  
  public final c hyX()
  {
    return this.VFI;
  }
  
  public final m hyY()
  {
    return this.VFL;
  }
  
  public final s hyZ()
  {
    return this.VFK;
  }
  
  public final com.tencent.mm.storage.emotion.b hza()
  {
    return this.VFT;
  }
  
  public final g hzb()
  {
    return this.VFU;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.storage.bj
 * JD-Core Version:    0.7.0.1
 */
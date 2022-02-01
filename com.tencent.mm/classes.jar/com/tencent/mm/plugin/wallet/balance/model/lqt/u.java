package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ai;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.d;
import com.tencent.mm.protocal.protobuf.amh;
import com.tencent.mm.protocal.protobuf.cki;
import com.tencent.mm.protocal.protobuf.cuv;
import com.tencent.mm.protocal.protobuf.vk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.vfs.e;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.locks.ReentrantLock;

public final class u
{
  public static final u HtN;
  private static final String HtO;
  private static final String HtP;
  private long HtA;
  private List<Bankcard> HtB;
  private List<Bankcard> HtC;
  private ReentrantLock HtD;
  public String HtE;
  public String HtF;
  public String HtG;
  public int HtH;
  public String HtI;
  public String HtJ;
  public String HtK;
  public amh HtL;
  public Vector<a> HtM;
  public cki Htx;
  public cki Hty;
  private long Htz;
  
  static
  {
    AppMethodBeat.i(68473);
    HtN = new u();
    HtO = fMX() + "/save/";
    HtP = fMX() + "/fetch/";
    AppMethodBeat.o(68473);
  }
  
  public u()
  {
    AppMethodBeat.i(68461);
    this.HtD = new ReentrantLock();
    this.HtM = new Vector();
    AppMethodBeat.o(68461);
  }
  
  public static List<Bankcard> aem(int paramInt)
  {
    AppMethodBeat.i(68468);
    Object localObject1 = HtN;
    boolean bool;
    Object localObject2;
    if (paramInt == 1)
    {
      bool = true;
      localObject2 = ((u)localObject1).xG(bool);
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((List)localObject2).size() != 0) {}
      }
      else
      {
        com.tencent.mm.plugin.wallet.a.s.fOg();
        localObject1 = com.tencent.mm.plugin.wallet.a.s.fOh().fRJ();
      }
      localObject2 = new LinkedList();
      if (localObject1 != null) {
        localObject1 = ((List)localObject1).iterator();
      }
    }
    else
    {
      for (;;)
      {
        if (!((Iterator)localObject1).hasNext()) {
          break label190;
        }
        Bankcard localBankcard = (Bankcard)((Iterator)localObject1).next();
        if (localBankcard.fQb())
        {
          com.tencent.mm.plugin.wallet.a.s.fOg();
          if (!com.tencent.mm.plugin.wallet.a.s.fOh().fRm())
          {
            ((List)localObject2).add(localBankcard);
            continue;
            bool = false;
            break;
          }
        }
        if ((paramInt == 1) && ((localBankcard.field_support_lqt_turn_in == 1) || (localBankcard.fQb()))) {
          ((List)localObject2).add(localBankcard);
        }
        if ((paramInt == 2) && ((localBankcard.field_support_lqt_turn_out == 1) || (localBankcard.fQb()))) {
          ((List)localObject2).add(localBankcard);
        }
      }
    }
    label190:
    AppMethodBeat.o(68468);
    return localObject2;
  }
  
  private static String fMX()
  {
    AppMethodBeat.i(68471);
    String str = b.aKJ() + "wallet/lqt/";
    AppMethodBeat.o(68471);
    return str;
  }
  
  private List<Bankcard> xH(boolean paramBoolean)
  {
    AppMethodBeat.i(68469);
    cki localcki;
    if (paramBoolean) {
      localcki = this.Htx;
    }
    try
    {
      this.HtD.lock();
      if (localcki == null)
      {
        if (paramBoolean) {
          this.HtB = null;
        }
        for (;;)
        {
          return null;
          localcki = this.Hty;
          break;
          this.HtC = null;
        }
      }
      if (!paramBoolean) {
        break label121;
      }
    }
    finally
    {
      this.HtD.unlock();
      AppMethodBeat.o(68469);
    }
    if ((this.HtB != null) && (this.HtB.size() > 0))
    {
      localObject2 = this.HtB;
      this.HtD.unlock();
      AppMethodBeat.o(68469);
      return localObject2;
      label121:
      if ((this.HtC != null) && (this.HtC.size() > 0))
      {
        localObject2 = this.HtC;
        this.HtD.unlock();
        AppMethodBeat.o(68469);
        return localObject2;
      }
    }
    Bankcard localBankcard;
    if (paramBoolean)
    {
      this.HtB = new ArrayList();
      if (this.Htx.MpI != null)
      {
        localObject2 = ai.a(this.Htx.MpI);
        if (localObject2 != null) {
          this.HtB.add(localObject2);
        }
      }
      if ((this.Htx.LSL != null) && (this.Htx.LSL.size() > 0))
      {
        localObject2 = this.Htx.LSL.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localBankcard = d.a((vk)((Iterator)localObject2).next());
          if (localBankcard != null) {
            this.HtB.add(localBankcard);
          }
        }
      }
      localObject2 = this.HtB;
      this.HtD.unlock();
      AppMethodBeat.o(68469);
      return localObject2;
    }
    this.HtC = new ArrayList();
    if (this.Hty.MpI != null)
    {
      localObject2 = ai.a(this.Hty.MpI);
      if (localObject2 != null) {
        this.HtC.add(localObject2);
      }
    }
    if ((this.Hty.LSL != null) && (this.Hty.LSL.size() > 0))
    {
      localObject2 = this.Hty.LSL.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localBankcard = d.a((vk)((Iterator)localObject2).next());
        if (localBankcard != null) {
          this.HtC.add(localBankcard);
        }
      }
    }
    Object localObject2 = this.HtC;
    this.HtD.unlock();
    AppMethodBeat.o(68469);
    return localObject2;
  }
  
  private void xJ(boolean paramBoolean)
  {
    AppMethodBeat.i(68472);
    if (paramBoolean) {}
    Object localObject1;
    for (String str = HtO;; str = HtP)
    {
      localObject1 = com.tencent.mm.vfs.s.dC(str, false);
      if (localObject1 != null) {
        break;
      }
      AppMethodBeat.o(68472);
      return;
    }
    Log.i("MicroMsg.LqtBindQueryInfoCache", "tryLoadCacheFromDisk: %s, save: %s", new Object[] { localObject1, Boolean.valueOf(paramBoolean) });
    long l1 = System.currentTimeMillis();
    Iterator localIterator = ((Iterable)localObject1).iterator();
    while (localIterator.hasNext())
    {
      localObject1 = ((e)localIterator.next()).name;
      Object localObject2 = str + (String)localObject1;
      long l2 = Util.getLong((String)localObject1, 0L);
      Log.i("MicroMsg.LqtBindQueryInfoCache", "file name: %s", new Object[] { Long.valueOf(l2) });
      if (l2 > 0L)
      {
        if (l1 - l2 < 3600000L)
        {
          localObject2 = com.tencent.mm.vfs.s.aW((String)localObject2, 0, -1);
          localObject1 = new cki();
          try
          {
            ((cki)localObject1).parseFrom((byte[])localObject2);
            if (localObject1 == null) {
              continue;
            }
            this.HtD.lock();
            if (paramBoolean)
            {
              this.Htx = ((cki)localObject1);
              this.HtB = null;
              this.Htz = l2;
              this.HtD.unlock();
              Log.i("MicroMsg.LqtBindQueryInfoCache", "succ get saveCache: %s %s", new Object[] { localObject1, Long.valueOf(l2) });
              AppMethodBeat.o(68472);
              return;
            }
          }
          catch (IOException localIOException)
          {
            for (;;)
            {
              localObject1 = null;
              Log.printErrStackTrace("MicroMsg.LqtBindQueryInfoCache", localIOException, "parse bindquery from cache error: %s", new Object[] { localIOException.getMessage() });
              continue;
              this.Hty = ((cki)localObject1);
              this.HtC = null;
              this.HtA = l2;
            }
          }
        }
        else
        {
          com.tencent.mm.vfs.s.deleteFile(localIOException);
        }
      }
      else {
        com.tencent.mm.vfs.s.deleteFile(localIOException);
      }
    }
    AppMethodBeat.o(68472);
  }
  
  public final void a(cki paramcki, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(213851);
    if (paramBoolean2)
    {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(68459);
          Iterator localIterator = u.a(u.this).iterator();
          while (localIterator.hasNext()) {
            ((u.a)localIterator.next()).xK(true);
          }
          AppMethodBeat.o(68459);
        }
      });
      AppMethodBeat.o(213851);
      return;
    }
    if (paramcki != null)
    {
      this.HtD.lock();
      if (!paramBoolean1) {
        break label127;
      }
      this.Htx = paramcki;
      this.HtB = null;
      this.Htz = System.currentTimeMillis();
    }
    for (;;)
    {
      this.HtD.unlock();
      Log.i("MicroMsg.LqtBindQueryInfoCache", "setCache: %s, save: %s", new Object[] { paramcki, Boolean.valueOf(paramBoolean1) });
      try
      {
        ThreadPool.post(new u.3(this, paramcki.toByteArray(), paramBoolean1), "LqtBindQueryInfoCache_saveCacheToDiski");
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(68460);
            Iterator localIterator = u.a(u.this).iterator();
            while (localIterator.hasNext()) {
              ((u.a)localIterator.next()).xK(false);
            }
            AppMethodBeat.o(68460);
          }
        });
        AppMethodBeat.o(213851);
        return;
        label127:
        this.Hty = paramcki;
        this.HtC = null;
        this.HtA = System.currentTimeMillis();
      }
      catch (Exception paramcki)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.LqtBindQueryInfoCache", paramcki, "saveCacheToDisk error: %s", new Object[] { paramcki.getMessage() });
        }
      }
    }
  }
  
  public final void a(cuv paramcuv)
  {
    this.HtE = paramcuv.HtE;
    this.HtF = paramcuv.HtF;
    this.HtG = paramcuv.HtG;
    this.HtH = paramcuv.HtH;
    this.HtI = paramcuv.HtI;
    this.HtJ = paramcuv.MAc;
    this.HtL = paramcuv.MAd;
  }
  
  public final Bankcard fMU()
  {
    AppMethodBeat.i(68464);
    xI(true);
    Object localObject = this.Htx;
    if (localObject != null)
    {
      localObject = ai.a(((cki)localObject).MpI);
      AppMethodBeat.o(68464);
      return localObject;
    }
    AppMethodBeat.o(68464);
    return null;
  }
  
  public final String fMV()
  {
    AppMethodBeat.i(68466);
    xI(true);
    Object localObject = this.Htx;
    if (localObject != null)
    {
      localObject = ((cki)localObject).MpM;
      AppMethodBeat.o(68466);
      return localObject;
    }
    AppMethodBeat.o(68466);
    return "";
  }
  
  public final int fMW()
  {
    AppMethodBeat.i(68467);
    xI(true);
    cki localcki = this.Htx;
    if (localcki != null)
    {
      int i = localcki.MpN;
      AppMethodBeat.o(68467);
      return i;
    }
    AppMethodBeat.o(68467);
    return 0;
  }
  
  public final Bankcard xE(boolean paramBoolean)
  {
    AppMethodBeat.i(68463);
    xI(paramBoolean);
    if (paramBoolean) {}
    for (Object localObject1 = this.Htx; (localObject1 != null) && (!Util.isNullOrNil(((cki)localObject1).MpG)); localObject1 = this.Hty)
    {
      Object localObject2 = xH(paramBoolean);
      if ((localObject2 == null) || (((List)localObject2).size() <= 0)) {
        break;
      }
      localObject1 = ((cki)localObject1).MpG;
      if (Util.isNullOrNil((String)localObject1)) {
        break;
      }
      localObject2 = ((List)localObject2).iterator();
      Bankcard localBankcard;
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localBankcard = (Bankcard)((Iterator)localObject2).next();
      } while ((localBankcard == null) || (!((String)localObject1).equals(localBankcard.field_bindSerial)));
      AppMethodBeat.o(68463);
      return localBankcard;
    }
    AppMethodBeat.o(68463);
    return null;
  }
  
  public final cki xF(boolean paramBoolean)
  {
    AppMethodBeat.i(213852);
    xI(paramBoolean);
    if (paramBoolean)
    {
      localcki = this.Htx;
      AppMethodBeat.o(213852);
      return localcki;
    }
    cki localcki = this.Hty;
    AppMethodBeat.o(213852);
    return localcki;
  }
  
  public final List<Bankcard> xG(boolean paramBoolean)
  {
    AppMethodBeat.i(68465);
    xI(paramBoolean);
    if (paramBoolean) {}
    for (Object localObject = this.Htx; localObject != null; localObject = this.Hty)
    {
      localObject = xH(paramBoolean);
      AppMethodBeat.o(68465);
      return localObject;
    }
    AppMethodBeat.o(68465);
    return null;
  }
  
  public final void xI(boolean paramBoolean)
  {
    AppMethodBeat.i(68470);
    long l2 = System.currentTimeMillis();
    cki localcki;
    if (paramBoolean)
    {
      localcki = this.Htx;
      if (!paramBoolean) {
        break label60;
      }
    }
    label60:
    for (long l1 = this.Htz;; l1 = this.HtA)
    {
      if ((localcki != null) || (!paramBoolean)) {
        break label68;
      }
      xJ(paramBoolean);
      AppMethodBeat.o(68470);
      return;
      localcki = this.Hty;
      break;
    }
    label68:
    if (l2 - l1 > 3600000L) {
      Log.i("MicroMsg.LqtBindQueryInfoCache", "checkCache, saveCache time exceed, try reload from disk");
    }
    AppMethodBeat.o(68470);
  }
  
  public static abstract interface a
  {
    public abstract void xK(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.u
 * JD-Core Version:    0.7.0.1
 */
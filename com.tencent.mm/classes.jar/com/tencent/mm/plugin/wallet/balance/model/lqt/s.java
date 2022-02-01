package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ah;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.d;
import com.tencent.mm.protocal.protobuf.afu;
import com.tencent.mm.protocal.protobuf.bmv;
import com.tencent.mm.protocal.protobuf.bum;
import com.tencent.mm.protocal.protobuf.rx;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.FileSystem.a;
import com.tencent.mm.vfs.i;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.locks.ReentrantLock;

public final class s
{
  public static final s zEV;
  private static final String zEW;
  private static final String zEX;
  public bmv zEF;
  public bmv zEG;
  private long zEH;
  private long zEI;
  private List<Bankcard> zEJ;
  private List<Bankcard> zEK;
  private ReentrantLock zEL;
  public String zEM;
  public String zEN;
  public String zEO;
  public int zEP;
  public String zEQ;
  public String zER;
  public String zES;
  public afu zET;
  public Vector<a> zEU;
  
  static
  {
    AppMethodBeat.i(68473);
    zEV = new s();
    zEW = dYL() + "/save/";
    zEX = dYL() + "/fetch/";
    AppMethodBeat.o(68473);
  }
  
  public s()
  {
    AppMethodBeat.i(68461);
    this.zEL = new ReentrantLock();
    this.zEU = new Vector();
    AppMethodBeat.o(68461);
  }
  
  public static List<Bankcard> Re(int paramInt)
  {
    AppMethodBeat.i(68468);
    Object localObject1 = zEV;
    boolean bool;
    Object localObject2;
    if (paramInt == 1)
    {
      bool = true;
      localObject2 = ((s)localObject1).sf(bool);
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((List)localObject2).size() != 0) {}
      }
      else
      {
        com.tencent.mm.plugin.wallet.a.s.dZT();
        localObject1 = com.tencent.mm.plugin.wallet.a.s.dZU().edd();
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
        if (localBankcard.ebv())
        {
          com.tencent.mm.plugin.wallet.a.s.dZT();
          if (!com.tencent.mm.plugin.wallet.a.s.dZU().ecH())
          {
            ((List)localObject2).add(localBankcard);
            continue;
            bool = false;
            break;
          }
        }
        if ((paramInt == 1) && ((localBankcard.field_support_lqt_turn_in == 1) || (localBankcard.ebv()))) {
          ((List)localObject2).add(localBankcard);
        }
        if ((paramInt == 2) && ((localBankcard.field_support_lqt_turn_out == 1) || (localBankcard.ebv()))) {
          ((List)localObject2).add(localBankcard);
        }
      }
    }
    label190:
    AppMethodBeat.o(68468);
    return localObject2;
  }
  
  private static String dYL()
  {
    AppMethodBeat.i(68471);
    String str = com.tencent.mm.loader.j.b.aih() + "wallet/lqt/";
    AppMethodBeat.o(68471);
    return str;
  }
  
  private List<Bankcard> sg(boolean paramBoolean)
  {
    AppMethodBeat.i(68469);
    bmv localbmv;
    if (paramBoolean) {
      localbmv = this.zEF;
    }
    try
    {
      this.zEL.lock();
      if (localbmv == null)
      {
        if (paramBoolean) {
          this.zEJ = null;
        }
        for (;;)
        {
          return null;
          localbmv = this.zEG;
          break;
          this.zEK = null;
        }
      }
      if (!paramBoolean) {
        break label121;
      }
    }
    finally
    {
      this.zEL.unlock();
      AppMethodBeat.o(68469);
    }
    if ((this.zEJ != null) && (this.zEJ.size() > 0))
    {
      localObject2 = this.zEJ;
      this.zEL.unlock();
      AppMethodBeat.o(68469);
      return localObject2;
      label121:
      if ((this.zEK != null) && (this.zEK.size() > 0))
      {
        localObject2 = this.zEK;
        this.zEL.unlock();
        AppMethodBeat.o(68469);
        return localObject2;
      }
    }
    Bankcard localBankcard;
    if (paramBoolean)
    {
      this.zEJ = new ArrayList();
      if (this.zEF.DKk != null)
      {
        localObject2 = ah.a(this.zEF.DKk);
        if (localObject2 != null) {
          this.zEJ.add(localObject2);
        }
      }
      if ((this.zEF.Drc != null) && (this.zEF.Drc.size() > 0))
      {
        localObject2 = this.zEF.Drc.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localBankcard = d.a((rx)((Iterator)localObject2).next());
          if (localBankcard != null) {
            this.zEJ.add(localBankcard);
          }
        }
      }
      localObject2 = this.zEJ;
      this.zEL.unlock();
      AppMethodBeat.o(68469);
      return localObject2;
    }
    this.zEK = new ArrayList();
    if (this.zEG.DKk != null)
    {
      localObject2 = ah.a(this.zEG.DKk);
      if (localObject2 != null) {
        this.zEK.add(localObject2);
      }
    }
    if ((this.zEG.Drc != null) && (this.zEG.Drc.size() > 0))
    {
      localObject2 = this.zEG.Drc.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localBankcard = d.a((rx)((Iterator)localObject2).next());
        if (localBankcard != null) {
          this.zEK.add(localBankcard);
        }
      }
    }
    Object localObject2 = this.zEK;
    this.zEL.unlock();
    AppMethodBeat.o(68469);
    return localObject2;
  }
  
  private void si(boolean paramBoolean)
  {
    AppMethodBeat.i(68472);
    if (paramBoolean) {}
    Object localObject1;
    for (String str = zEW;; str = zEX)
    {
      localObject1 = i.cT(str, false);
      if (localObject1 != null) {
        break;
      }
      AppMethodBeat.o(68472);
      return;
    }
    ad.i("MicroMsg.LqtBindQueryInfoCache", "tryLoadCacheFromDisk: %s, save: %s", new Object[] { localObject1, Boolean.valueOf(paramBoolean) });
    long l1 = System.currentTimeMillis();
    Iterator localIterator = ((Iterable)localObject1).iterator();
    while (localIterator.hasNext())
    {
      localObject1 = ((FileSystem.a)localIterator.next()).name;
      Object localObject2 = str + (String)localObject1;
      long l2 = bt.getLong((String)localObject1, 0L);
      ad.i("MicroMsg.LqtBindQueryInfoCache", "file name: %s", new Object[] { Long.valueOf(l2) });
      if (l2 > 0L)
      {
        if (l1 - l2 < 3600000L)
        {
          localObject2 = i.aR((String)localObject2, 0, -1);
          localObject1 = new bmv();
          try
          {
            ((bmv)localObject1).parseFrom((byte[])localObject2);
            if (localObject1 == null) {
              continue;
            }
            this.zEL.lock();
            if (paramBoolean)
            {
              this.zEF = ((bmv)localObject1);
              this.zEJ = null;
              this.zEH = l2;
              this.zEL.unlock();
              ad.i("MicroMsg.LqtBindQueryInfoCache", "succ get saveCache: %s %s", new Object[] { localObject1, Long.valueOf(l2) });
              AppMethodBeat.o(68472);
              return;
            }
          }
          catch (IOException localIOException)
          {
            for (;;)
            {
              localObject1 = null;
              ad.printErrStackTrace("MicroMsg.LqtBindQueryInfoCache", localIOException, "parse bindquery from cache error: %s", new Object[] { localIOException.getMessage() });
              continue;
              this.zEG = ((bmv)localObject1);
              this.zEK = null;
              this.zEI = l2;
            }
          }
        }
        else
        {
          i.deleteFile(localIOException);
        }
      }
      else {
        i.deleteFile(localIOException);
      }
    }
    AppMethodBeat.o(68472);
  }
  
  public final void a(bmv parambmv, final boolean paramBoolean)
  {
    AppMethodBeat.i(68462);
    if (parambmv != null)
    {
      this.zEL.lock();
      if (!paramBoolean) {
        break label105;
      }
      this.zEF = parambmv;
      this.zEJ = null;
      this.zEH = System.currentTimeMillis();
    }
    for (;;)
    {
      this.zEL.unlock();
      ad.i("MicroMsg.LqtBindQueryInfoCache", "setCache: %s, save: %s", new Object[] { parambmv, Boolean.valueOf(paramBoolean) });
      try
      {
        com.tencent.mm.sdk.g.b.c(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(68460);
            if (this.shP != null)
            {
              s.b(s.this).lock();
              if (paramBoolean)
              {
                if (i.eK(s.zEW)) {
                  i.cO(s.zEW, true);
                }
                i.aMF(s.zEW);
                s.c(s.this);
              }
              for (;;)
              {
                s.b(s.this).unlock();
                try
                {
                  Object localObject = System.currentTimeMillis();
                  label100:
                  long l;
                  StringBuilder localStringBuilder;
                  if (paramBoolean)
                  {
                    str = s.zEW;
                    ad.i("MicroMsg.LqtBindQueryInfoCache", "saveCacheToDisk, dir: %s, name: %s, save: %s", new Object[] { str, localObject, Boolean.valueOf(paramBoolean) });
                    l = bt.GC();
                    localStringBuilder = new StringBuilder();
                    if (!paramBoolean) {
                      break label254;
                    }
                  }
                  label254:
                  for (String str = s.zEW;; str = s.zEX)
                  {
                    str = str + (String)localObject;
                    localObject = this.shP;
                    i.f(str, (byte[])localObject, localObject.length);
                    ad.i("MicroMsg.LqtBindQueryInfoCache", "finish saveCacheToDisk, used %sms", new Object[] { Long.valueOf(bt.aS(l)) });
                    AppMethodBeat.o(68460);
                    return;
                    if (i.eK(s.zEX)) {
                      i.cO(s.zEX, true);
                    }
                    i.aMF(s.zEX);
                    s.d(s.this);
                    break;
                    str = s.zEX;
                    break label100;
                  }
                  AppMethodBeat.o(68460);
                }
                catch (Exception localException)
                {
                  ad.printErrStackTrace("MicroMsg.LqtBindQueryInfoCache", localException, "saveCacheToDisk error: %s", new Object[] { localException.getMessage() });
                }
              }
            }
          }
        }, "LqtBindQueryInfoCache_saveCacheToDiski");
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(68459);
            Iterator localIterator = s.a(s.this).iterator();
            while (localIterator.hasNext()) {
              ((s.a)localIterator.next()).dYM();
            }
            AppMethodBeat.o(68459);
          }
        });
        AppMethodBeat.o(68462);
        return;
        label105:
        this.zEG = parambmv;
        this.zEK = null;
        this.zEI = System.currentTimeMillis();
      }
      catch (Exception parambmv)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.LqtBindQueryInfoCache", parambmv, "saveCacheToDisk error: %s", new Object[] { parambmv.getMessage() });
        }
      }
    }
  }
  
  public final void a(bum parambum)
  {
    this.zEM = parambum.zEM;
    this.zEN = parambum.zEN;
    this.zEO = parambum.zEO;
    this.zEP = parambum.zEP;
    this.zEQ = parambum.zEQ;
    this.zER = parambum.DRG;
    this.zET = parambum.DRH;
  }
  
  public final Bankcard dYI()
  {
    AppMethodBeat.i(68464);
    sh(true);
    Object localObject = this.zEF;
    if (localObject != null)
    {
      localObject = ah.a(((bmv)localObject).DKk);
      AppMethodBeat.o(68464);
      return localObject;
    }
    AppMethodBeat.o(68464);
    return null;
  }
  
  public final String dYJ()
  {
    AppMethodBeat.i(68466);
    sh(true);
    Object localObject = this.zEF;
    if (localObject != null)
    {
      localObject = ((bmv)localObject).DKo;
      AppMethodBeat.o(68466);
      return localObject;
    }
    AppMethodBeat.o(68466);
    return "";
  }
  
  public final int dYK()
  {
    AppMethodBeat.i(68467);
    sh(true);
    bmv localbmv = this.zEF;
    if (localbmv != null)
    {
      int i = localbmv.DKp;
      AppMethodBeat.o(68467);
      return i;
    }
    AppMethodBeat.o(68467);
    return 0;
  }
  
  public final Bankcard se(boolean paramBoolean)
  {
    AppMethodBeat.i(68463);
    sh(paramBoolean);
    if (paramBoolean) {}
    for (Object localObject1 = this.zEF; (localObject1 != null) && (!bt.isNullOrNil(((bmv)localObject1).DKi)); localObject1 = this.zEG)
    {
      Object localObject2 = sg(paramBoolean);
      if ((localObject2 == null) || (((List)localObject2).size() <= 0)) {
        break;
      }
      localObject1 = ((bmv)localObject1).DKi;
      if (bt.isNullOrNil((String)localObject1)) {
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
  
  public final List<Bankcard> sf(boolean paramBoolean)
  {
    AppMethodBeat.i(68465);
    sh(paramBoolean);
    if (paramBoolean) {}
    for (Object localObject = this.zEF; localObject != null; localObject = this.zEG)
    {
      localObject = sg(paramBoolean);
      AppMethodBeat.o(68465);
      return localObject;
    }
    AppMethodBeat.o(68465);
    return null;
  }
  
  public final void sh(boolean paramBoolean)
  {
    AppMethodBeat.i(68470);
    long l2 = System.currentTimeMillis();
    bmv localbmv;
    long l1;
    if (paramBoolean)
    {
      localbmv = this.zEF;
      if (!paramBoolean) {
        break label89;
      }
      l1 = this.zEH;
      label30:
      if (localbmv != null)
      {
        if (l2 - l1 <= 3600000L) {
          break label73;
        }
        ad.i("MicroMsg.LqtBindQueryInfoCache", "checkCache, saveCache time exceed, try reload from disk");
        this.zEF = null;
        if (!paramBoolean) {
          break label97;
        }
        this.zEH = 0L;
      }
    }
    for (;;)
    {
      si(paramBoolean);
      label73:
      AppMethodBeat.o(68470);
      return;
      localbmv = this.zEG;
      break;
      label89:
      l1 = this.zEI;
      break label30;
      label97:
      this.zEI = 0L;
    }
  }
  
  public static abstract interface a
  {
    public abstract void dYM();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.s
 * JD-Core Version:    0.7.0.1
 */
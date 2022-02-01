package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ai;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.d;
import com.tencent.mm.protocal.protobuf.ajj;
import com.tencent.mm.protocal.protobuf.bvy;
import com.tencent.mm.protocal.protobuf.cdu;
import com.tencent.mm.protocal.protobuf.ub;
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
  public static final s Cxr;
  private static final String Cxs;
  private static final String Cxt;
  public bvy Cxb;
  public bvy Cxc;
  private long Cxd;
  private long Cxe;
  private List<Bankcard> Cxf;
  private List<Bankcard> Cxg;
  private ReentrantLock Cxh;
  public String Cxi;
  public String Cxj;
  public String Cxk;
  public int Cxl;
  public String Cxm;
  public String Cxn;
  public String Cxo;
  public ajj Cxp;
  public Vector<a> Cxq;
  
  static
  {
    AppMethodBeat.i(68473);
    Cxr = new s();
    Cxs = eCg() + "/save/";
    Cxt = eCg() + "/fetch/";
    AppMethodBeat.o(68473);
  }
  
  public s()
  {
    AppMethodBeat.i(68461);
    this.Cxh = new ReentrantLock();
    this.Cxq = new Vector();
    AppMethodBeat.o(68461);
  }
  
  public static List<Bankcard> Vg(int paramInt)
  {
    AppMethodBeat.i(68468);
    Object localObject1 = Cxr;
    boolean bool;
    Object localObject2;
    if (paramInt == 1)
    {
      bool = true;
      localObject2 = ((s)localObject1).tQ(bool);
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((List)localObject2).size() != 0) {}
      }
      else
      {
        com.tencent.mm.plugin.wallet.a.s.eDp();
        localObject1 = com.tencent.mm.plugin.wallet.a.s.eDq().eGy();
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
        if (localBankcard.eER())
        {
          com.tencent.mm.plugin.wallet.a.s.eDp();
          if (!com.tencent.mm.plugin.wallet.a.s.eDq().eGc())
          {
            ((List)localObject2).add(localBankcard);
            continue;
            bool = false;
            break;
          }
        }
        if ((paramInt == 1) && ((localBankcard.field_support_lqt_turn_in == 1) || (localBankcard.eER()))) {
          ((List)localObject2).add(localBankcard);
        }
        if ((paramInt == 2) && ((localBankcard.field_support_lqt_turn_out == 1) || (localBankcard.eER()))) {
          ((List)localObject2).add(localBankcard);
        }
      }
    }
    label190:
    AppMethodBeat.o(68468);
    return localObject2;
  }
  
  private static String eCg()
  {
    AppMethodBeat.i(68471);
    String str = com.tencent.mm.loader.j.b.arU() + "wallet/lqt/";
    AppMethodBeat.o(68471);
    return str;
  }
  
  private List<Bankcard> tR(boolean paramBoolean)
  {
    AppMethodBeat.i(68469);
    bvy localbvy;
    if (paramBoolean) {
      localbvy = this.Cxb;
    }
    try
    {
      this.Cxh.lock();
      if (localbvy == null)
      {
        if (paramBoolean) {
          this.Cxf = null;
        }
        for (;;)
        {
          return null;
          localbvy = this.Cxc;
          break;
          this.Cxg = null;
        }
      }
      if (!paramBoolean) {
        break label121;
      }
    }
    finally
    {
      this.Cxh.unlock();
      AppMethodBeat.o(68469);
    }
    if ((this.Cxf != null) && (this.Cxf.size() > 0))
    {
      localObject2 = this.Cxf;
      this.Cxh.unlock();
      AppMethodBeat.o(68469);
      return localObject2;
      label121:
      if ((this.Cxg != null) && (this.Cxg.size() > 0))
      {
        localObject2 = this.Cxg;
        this.Cxh.unlock();
        AppMethodBeat.o(68469);
        return localObject2;
      }
    }
    Bankcard localBankcard;
    if (paramBoolean)
    {
      this.Cxf = new ArrayList();
      if (this.Cxb.GQb != null)
      {
        localObject2 = ai.a(this.Cxb.GQb);
        if (localObject2 != null) {
          this.Cxf.add(localObject2);
        }
      }
      if ((this.Cxb.Gvi != null) && (this.Cxb.Gvi.size() > 0))
      {
        localObject2 = this.Cxb.Gvi.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localBankcard = d.a((ub)((Iterator)localObject2).next());
          if (localBankcard != null) {
            this.Cxf.add(localBankcard);
          }
        }
      }
      localObject2 = this.Cxf;
      this.Cxh.unlock();
      AppMethodBeat.o(68469);
      return localObject2;
    }
    this.Cxg = new ArrayList();
    if (this.Cxc.GQb != null)
    {
      localObject2 = ai.a(this.Cxc.GQb);
      if (localObject2 != null) {
        this.Cxg.add(localObject2);
      }
    }
    if ((this.Cxc.Gvi != null) && (this.Cxc.Gvi.size() > 0))
    {
      localObject2 = this.Cxc.Gvi.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localBankcard = d.a((ub)((Iterator)localObject2).next());
        if (localBankcard != null) {
          this.Cxg.add(localBankcard);
        }
      }
    }
    Object localObject2 = this.Cxg;
    this.Cxh.unlock();
    AppMethodBeat.o(68469);
    return localObject2;
  }
  
  private void tT(boolean paramBoolean)
  {
    AppMethodBeat.i(68472);
    if (paramBoolean) {}
    Object localObject1;
    for (String str = Cxs;; str = Cxt)
    {
      localObject1 = i.de(str, false);
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
          localObject2 = i.aY((String)localObject2, 0, -1);
          localObject1 = new bvy();
          try
          {
            ((bvy)localObject1).parseFrom((byte[])localObject2);
            if (localObject1 == null) {
              continue;
            }
            this.Cxh.lock();
            if (paramBoolean)
            {
              this.Cxb = ((bvy)localObject1);
              this.Cxf = null;
              this.Cxd = l2;
              this.Cxh.unlock();
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
              this.Cxc = ((bvy)localObject1);
              this.Cxg = null;
              this.Cxe = l2;
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
  
  public final void a(bvy parambvy, boolean paramBoolean)
  {
    AppMethodBeat.i(68462);
    if (parambvy != null)
    {
      this.Cxh.lock();
      if (!paramBoolean) {
        break label105;
      }
      this.Cxb = parambvy;
      this.Cxf = null;
      this.Cxd = System.currentTimeMillis();
    }
    for (;;)
    {
      this.Cxh.unlock();
      ad.i("MicroMsg.LqtBindQueryInfoCache", "setCache: %s, save: %s", new Object[] { parambvy, Boolean.valueOf(paramBoolean) });
      try
      {
        com.tencent.mm.sdk.g.b.c(new s.2(this, parambvy.toByteArray(), paramBoolean), "LqtBindQueryInfoCache_saveCacheToDiski");
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(68459);
            Iterator localIterator = s.a(s.this).iterator();
            while (localIterator.hasNext()) {
              ((s.a)localIterator.next()).eCh();
            }
            AppMethodBeat.o(68459);
          }
        });
        AppMethodBeat.o(68462);
        return;
        label105:
        this.Cxc = parambvy;
        this.Cxg = null;
        this.Cxe = System.currentTimeMillis();
      }
      catch (Exception parambvy)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.LqtBindQueryInfoCache", parambvy, "saveCacheToDisk error: %s", new Object[] { parambvy.getMessage() });
        }
      }
    }
  }
  
  public final void a(cdu paramcdu)
  {
    this.Cxi = paramcdu.Cxi;
    this.Cxj = paramcdu.Cxj;
    this.Cxk = paramcdu.Cxk;
    this.Cxl = paramcdu.Cxl;
    this.Cxm = paramcdu.Cxm;
    this.Cxn = paramcdu.GXM;
    this.Cxp = paramcdu.GXN;
  }
  
  public final Bankcard eCd()
  {
    AppMethodBeat.i(68464);
    tS(true);
    Object localObject = this.Cxb;
    if (localObject != null)
    {
      localObject = ai.a(((bvy)localObject).GQb);
      AppMethodBeat.o(68464);
      return localObject;
    }
    AppMethodBeat.o(68464);
    return null;
  }
  
  public final String eCe()
  {
    AppMethodBeat.i(68466);
    tS(true);
    Object localObject = this.Cxb;
    if (localObject != null)
    {
      localObject = ((bvy)localObject).GQf;
      AppMethodBeat.o(68466);
      return localObject;
    }
    AppMethodBeat.o(68466);
    return "";
  }
  
  public final int eCf()
  {
    AppMethodBeat.i(68467);
    tS(true);
    bvy localbvy = this.Cxb;
    if (localbvy != null)
    {
      int i = localbvy.GQg;
      AppMethodBeat.o(68467);
      return i;
    }
    AppMethodBeat.o(68467);
    return 0;
  }
  
  public final Bankcard tP(boolean paramBoolean)
  {
    AppMethodBeat.i(68463);
    tS(paramBoolean);
    if (paramBoolean) {}
    for (Object localObject1 = this.Cxb; (localObject1 != null) && (!bt.isNullOrNil(((bvy)localObject1).GPZ)); localObject1 = this.Cxc)
    {
      Object localObject2 = tR(paramBoolean);
      if ((localObject2 == null) || (((List)localObject2).size() <= 0)) {
        break;
      }
      localObject1 = ((bvy)localObject1).GPZ;
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
  
  public final List<Bankcard> tQ(boolean paramBoolean)
  {
    AppMethodBeat.i(68465);
    tS(paramBoolean);
    if (paramBoolean) {}
    for (Object localObject = this.Cxb; localObject != null; localObject = this.Cxc)
    {
      localObject = tR(paramBoolean);
      AppMethodBeat.o(68465);
      return localObject;
    }
    AppMethodBeat.o(68465);
    return null;
  }
  
  public final void tS(boolean paramBoolean)
  {
    AppMethodBeat.i(68470);
    long l2 = System.currentTimeMillis();
    bvy localbvy;
    if (paramBoolean)
    {
      localbvy = this.Cxb;
      if (!paramBoolean) {
        break label56;
      }
    }
    label56:
    for (long l1 = this.Cxd;; l1 = this.Cxe)
    {
      if (localbvy != null) {
        break label64;
      }
      tT(paramBoolean);
      AppMethodBeat.o(68470);
      return;
      localbvy = this.Cxc;
      break;
    }
    label64:
    if (l2 - l1 > 3600000L) {
      ad.i("MicroMsg.LqtBindQueryInfoCache", "checkCache, saveCache time exceed, try reload from disk");
    }
    AppMethodBeat.o(68470);
  }
  
  public static abstract interface a
  {
    public abstract void eCh();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.s
 * JD-Core Version:    0.7.0.1
 */
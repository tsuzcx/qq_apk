package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.loader.a.b;
import com.tencent.mm.plugin.wallet.a.p;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ab;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.d;
import com.tencent.mm.protocal.c.aup;
import com.tencent.mm.protocal.c.mo;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.FileSystem.a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class i
{
  private static final String qfA = qfy + "/fetch/";
  public static final i qfx = new i();
  private static final String qfy = b.bkH + "wallet/lqt";
  private static final String qfz = qfy + "/save/";
  public aup qfr;
  public aup qfs;
  private long qft;
  private long qfu;
  private List<Bankcard> qfv;
  private List<Bankcard> qfw;
  
  public static List<Bankcard> AG(int paramInt)
  {
    Object localObject1 = qfx;
    boolean bool;
    Object localObject2;
    if (paramInt == 1)
    {
      bool = true;
      localObject2 = ((i)localObject1).kl(bool);
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((List)localObject2).size() != 0) {}
      }
      else
      {
        p.bTK();
        localObject1 = p.bTL().bWc();
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
          return localObject2;
        }
        Bankcard localBankcard = (Bankcard)((Iterator)localObject1).next();
        if (localBankcard.bUQ())
        {
          p.bTK();
          if (!p.bTL().bVK())
          {
            ((List)localObject2).add(localBankcard);
            continue;
            bool = false;
            break;
          }
        }
        if ((paramInt == 1) && ((localBankcard.field_support_lqt_turn_in == 1) || (localBankcard.bUQ()))) {
          ((List)localObject2).add(localBankcard);
        }
        if ((paramInt == 2) && ((localBankcard.field_support_lqt_turn_out == 1) || (localBankcard.bUQ()))) {
          ((List)localObject2).add(localBankcard);
        }
      }
    }
    return localObject2;
  }
  
  private List<Bankcard> km(boolean paramBoolean)
  {
    Object localObject;
    if (paramBoolean) {
      localObject = this.qfr;
    }
    while (localObject == null) {
      if (paramBoolean)
      {
        this.qfv = null;
        return null;
        localObject = this.qfs;
      }
      else
      {
        this.qfw = null;
        return null;
      }
    }
    if (paramBoolean)
    {
      if ((this.qfv != null) && (this.qfv.size() > 0)) {
        return this.qfv;
      }
    }
    else if ((this.qfw != null) && (this.qfw.size() > 0)) {
      return this.qfw;
    }
    Bankcard localBankcard;
    if (paramBoolean)
    {
      this.qfv = new ArrayList();
      if (this.qfr.tqd != null)
      {
        localObject = ab.a(this.qfr.tqd);
        if (localObject != null) {
          this.qfv.add(localObject);
        }
      }
      if ((this.qfr.taW != null) && (this.qfr.taW.size() > 0))
      {
        localObject = this.qfr.taW.iterator();
        while (((Iterator)localObject).hasNext())
        {
          localBankcard = d.a((mo)((Iterator)localObject).next());
          if (localBankcard != null) {
            this.qfv.add(localBankcard);
          }
        }
      }
      return this.qfv;
    }
    this.qfw = new ArrayList();
    if (this.qfs.tqd != null)
    {
      localObject = ab.a(this.qfs.tqd);
      if (localObject != null) {
        this.qfw.add(localObject);
      }
    }
    if ((this.qfs.taW != null) && (this.qfs.taW.size() > 0))
    {
      localObject = this.qfs.taW.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localBankcard = d.a((mo)((Iterator)localObject).next());
        if (localBankcard != null) {
          this.qfw.add(localBankcard);
        }
      }
    }
    return this.qfw;
  }
  
  public final void a(aup paramaup, boolean paramBoolean)
  {
    if (paramaup != null)
    {
      if (!paramBoolean) {
        break label66;
      }
      this.qfr = paramaup;
      this.qfv = null;
      this.qft = System.currentTimeMillis();
    }
    for (;;)
    {
      y.i("MicroMsg.LqtBindQueryInfoCache", "setCache: %s, save: %s", new Object[] { paramaup, Boolean.valueOf(paramBoolean) });
      try
      {
        com.tencent.mm.sdk.f.e.post(new i.1(this, paramaup.toByteArray(), paramBoolean), "LqtBindQueryInfoCache_saveCacheToDiski");
        return;
      }
      catch (Exception paramaup)
      {
        label66:
        y.printErrStackTrace("MicroMsg.LqtBindQueryInfoCache", paramaup, "saveCacheToDisk error: %s", new Object[] { paramaup.getMessage() });
      }
      this.qfs = paramaup;
      this.qfw = null;
      this.qfu = System.currentTimeMillis();
    }
  }
  
  public final Bankcard kk(boolean paramBoolean)
  {
    kn(paramBoolean);
    if (paramBoolean) {}
    for (Object localObject1 = this.qfr; (localObject1 != null) && (!bk.bl(((aup)localObject1).tqb)); localObject1 = this.qfs)
    {
      Object localObject2 = km(paramBoolean);
      if ((localObject2 == null) || (((List)localObject2).size() <= 0)) {
        break;
      }
      localObject1 = ((aup)localObject1).tqb;
      if (bk.bl((String)localObject1)) {
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
      return localBankcard;
    }
    return null;
  }
  
  public final List<Bankcard> kl(boolean paramBoolean)
  {
    kn(paramBoolean);
    if (paramBoolean) {}
    for (aup localaup = this.qfr; localaup != null; localaup = this.qfs) {
      return km(paramBoolean);
    }
    return null;
  }
  
  public final void kn(boolean paramBoolean)
  {
    long l2 = System.currentTimeMillis();
    Object localObject1;
    long l1;
    label24:
    label61:
    label70:
    Object localObject2;
    if (paramBoolean)
    {
      localObject1 = this.qfr;
      if (!paramBoolean) {
        break label102;
      }
      l1 = this.qft;
      if (localObject1 != null)
      {
        if (l2 - l1 > 3600000L)
        {
          y.i("MicroMsg.LqtBindQueryInfoCache", "checkCache, saveCache time exceed, try reload from disk");
          this.qfr = null;
          if (!paramBoolean) {
            break label110;
          }
          this.qft = 0L;
        }
      }
      else
      {
        if (!paramBoolean) {
          break label118;
        }
        localObject1 = qfz;
        localObject2 = com.tencent.mm.vfs.e.aeT((String)localObject1);
        if ((localObject2 != null) && (((List)localObject2).size() != 0)) {
          break label126;
        }
      }
    }
    for (;;)
    {
      return;
      localObject1 = this.qfs;
      break;
      label102:
      l1 = this.qfu;
      break label24;
      label110:
      this.qfu = 0L;
      break label61;
      label118:
      localObject1 = qfA;
      break label70;
      label126:
      y.i("MicroMsg.LqtBindQueryInfoCache", "tryLoadCacheFromDisk: %s, save: %s", new Object[] { localObject2, Boolean.valueOf(paramBoolean) });
      l1 = System.currentTimeMillis();
      Iterator localIterator = ((List)localObject2).iterator();
      while (localIterator.hasNext())
      {
        localObject2 = ((FileSystem.a)localIterator.next()).name;
        Object localObject3 = (String)localObject1 + (String)localObject2;
        l2 = bk.getLong((String)localObject2, 0L);
        y.i("MicroMsg.LqtBindQueryInfoCache", "file name: %s", new Object[] { Long.valueOf(l2) });
        if (l2 > 0L)
        {
          if (l1 - l2 < 3600000L)
          {
            localObject3 = com.tencent.mm.vfs.e.c((String)localObject3, 0, -1);
            localObject2 = new aup();
            try
            {
              ((aup)localObject2).aH((byte[])localObject3);
              if (localObject2 == null) {
                continue;
              }
              if (paramBoolean)
              {
                this.qfr = ((aup)localObject2);
                this.qfv = null;
                this.qft = l2;
                y.i("MicroMsg.LqtBindQueryInfoCache", "succ get saveCache: %s %s", new Object[] { localObject2, Long.valueOf(l2) });
                return;
              }
            }
            catch (IOException localIOException)
            {
              for (;;)
              {
                localObject2 = null;
                y.printErrStackTrace("MicroMsg.LqtBindQueryInfoCache", localIOException, "parse bindquery from cache error: %s", new Object[] { localIOException.getMessage() });
                continue;
                this.qfs = ((aup)localObject2);
                this.qfw = null;
                this.qfu = l2;
              }
            }
          }
          else
          {
            com.tencent.mm.vfs.e.deleteFile(localIOException);
          }
        }
        else {
          com.tencent.mm.vfs.e.deleteFile(localIOException);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.a.a.i
 * JD-Core Version:    0.7.0.1
 */
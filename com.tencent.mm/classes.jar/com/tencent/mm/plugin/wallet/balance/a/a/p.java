package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ah;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.f;
import com.tencent.mm.protocal.protobuf.bax;
import com.tencent.mm.protocal.protobuf.bhf;
import com.tencent.mm.protocal.protobuf.po;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.FileSystem.a;
import com.tencent.mm.vfs.e;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.locks.ReentrantLock;

public final class p
{
  private static final String tMA;
  private static final String tMB;
  public static final p tMy;
  private static final String tMz;
  public bax tMj;
  public bax tMk;
  private long tMl;
  private long tMm;
  private List<Bankcard> tMn;
  private List<Bankcard> tMo;
  private ReentrantLock tMp;
  public String tMq;
  public String tMr;
  public String tMs;
  public int tMt;
  public String tMu;
  public String tMv;
  public String tMw;
  public Vector<p.a> tMx;
  
  static
  {
    AppMethodBeat.i(45260);
    tMy = new p();
    tMz = b.eQz + "wallet/lqt";
    tMA = tMz + "/save/";
    tMB = tMz + "/fetch/";
    AppMethodBeat.o(45260);
  }
  
  public p()
  {
    AppMethodBeat.i(45248);
    this.tMp = new ReentrantLock();
    this.tMx = new Vector();
    AppMethodBeat.o(45248);
  }
  
  public static List<Bankcard> Ih(int paramInt)
  {
    AppMethodBeat.i(45256);
    Object localObject1 = tMy;
    boolean bool;
    Object localObject2;
    if (paramInt == 1)
    {
      bool = true;
      localObject2 = ((p)localObject1).nl(bool);
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((List)localObject2).size() != 0) {}
      }
      else
      {
        s.cRG();
        localObject1 = s.cRH().cUJ();
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
        if (localBankcard.cTf())
        {
          s.cRG();
          if (!s.cRH().cUn())
          {
            ((List)localObject2).add(localBankcard);
            continue;
            bool = false;
            break;
          }
        }
        if ((paramInt == 1) && ((localBankcard.field_support_lqt_turn_in == 1) || (localBankcard.cTf()))) {
          ((List)localObject2).add(localBankcard);
        }
        if ((paramInt == 2) && ((localBankcard.field_support_lqt_turn_out == 1) || (localBankcard.cTf()))) {
          ((List)localObject2).add(localBankcard);
        }
      }
    }
    label190:
    AppMethodBeat.o(45256);
    return localObject2;
  }
  
  private List<Bankcard> nm(boolean paramBoolean)
  {
    AppMethodBeat.i(45257);
    bax localbax;
    if (paramBoolean) {
      localbax = this.tMj;
    }
    try
    {
      this.tMp.lock();
      if (localbax == null)
      {
        if (paramBoolean) {
          this.tMn = null;
        }
        for (;;)
        {
          return null;
          localbax = this.tMk;
          break;
          this.tMo = null;
        }
      }
      if (!paramBoolean) {
        break label121;
      }
    }
    finally
    {
      this.tMp.unlock();
      AppMethodBeat.o(45257);
    }
    if ((this.tMn != null) && (this.tMn.size() > 0))
    {
      localObject2 = this.tMn;
      this.tMp.unlock();
      AppMethodBeat.o(45257);
      return localObject2;
      label121:
      if ((this.tMo != null) && (this.tMo.size() > 0))
      {
        localObject2 = this.tMo;
        this.tMp.unlock();
        AppMethodBeat.o(45257);
        return localObject2;
      }
    }
    Bankcard localBankcard;
    if (paramBoolean)
    {
      this.tMn = new ArrayList();
      if (this.tMj.xqb != null)
      {
        localObject2 = ah.a(this.tMj.xqb);
        if (localObject2 != null) {
          this.tMn.add(localObject2);
        }
      }
      if ((this.tMj.wZn != null) && (this.tMj.wZn.size() > 0))
      {
        localObject2 = this.tMj.wZn.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localBankcard = f.a((po)((Iterator)localObject2).next());
          if (localBankcard != null) {
            this.tMn.add(localBankcard);
          }
        }
      }
      localObject2 = this.tMn;
      this.tMp.unlock();
      AppMethodBeat.o(45257);
      return localObject2;
    }
    this.tMo = new ArrayList();
    if (this.tMk.xqb != null)
    {
      localObject2 = ah.a(this.tMk.xqb);
      if (localObject2 != null) {
        this.tMo.add(localObject2);
      }
    }
    if ((this.tMk.wZn != null) && (this.tMk.wZn.size() > 0))
    {
      localObject2 = this.tMk.wZn.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localBankcard = f.a((po)((Iterator)localObject2).next());
        if (localBankcard != null) {
          this.tMo.add(localBankcard);
        }
      }
    }
    Object localObject2 = this.tMo;
    this.tMp.unlock();
    AppMethodBeat.o(45257);
    return localObject2;
  }
  
  private void no(boolean paramBoolean)
  {
    AppMethodBeat.i(45259);
    if (paramBoolean) {}
    Object localObject1;
    for (String str = tMA;; str = tMB)
    {
      localObject1 = e.cs(str, false);
      if ((localObject1 != null) && (((List)localObject1).size() != 0)) {
        break;
      }
      AppMethodBeat.o(45259);
      return;
    }
    ab.i("MicroMsg.LqtBindQueryInfoCache", "tryLoadCacheFromDisk: %s, save: %s", new Object[] { localObject1, Boolean.valueOf(paramBoolean) });
    long l1 = System.currentTimeMillis();
    Iterator localIterator = ((List)localObject1).iterator();
    while (localIterator.hasNext())
    {
      localObject1 = ((FileSystem.a)localIterator.next()).name;
      Object localObject2 = str + (String)localObject1;
      long l2 = bo.getLong((String)localObject1, 0L);
      ab.i("MicroMsg.LqtBindQueryInfoCache", "file name: %s", new Object[] { Long.valueOf(l2) });
      if (l2 > 0L)
      {
        if (l1 - l2 < 3600000L)
        {
          localObject2 = e.i((String)localObject2, 0, -1);
          localObject1 = new bax();
          try
          {
            ((bax)localObject1).parseFrom((byte[])localObject2);
            if (localObject1 == null) {
              continue;
            }
            this.tMp.lock();
            if (paramBoolean)
            {
              this.tMj = ((bax)localObject1);
              this.tMn = null;
              this.tMl = l2;
              this.tMp.unlock();
              ab.i("MicroMsg.LqtBindQueryInfoCache", "succ get saveCache: %s %s", new Object[] { localObject1, Long.valueOf(l2) });
              AppMethodBeat.o(45259);
              return;
            }
          }
          catch (IOException localIOException)
          {
            for (;;)
            {
              localObject1 = null;
              ab.printErrStackTrace("MicroMsg.LqtBindQueryInfoCache", localIOException, "parse bindquery from cache error: %s", new Object[] { localIOException.getMessage() });
              continue;
              this.tMk = ((bax)localObject1);
              this.tMo = null;
              this.tMm = l2;
            }
          }
        }
        else
        {
          e.deleteFile(localIOException);
        }
      }
      else {
        e.deleteFile(localIOException);
      }
    }
    AppMethodBeat.o(45259);
  }
  
  public final void a(bax parambax, boolean paramBoolean)
  {
    AppMethodBeat.i(45249);
    if (parambax != null)
    {
      this.tMp.lock();
      if (!paramBoolean) {
        break label105;
      }
      this.tMj = parambax;
      this.tMn = null;
      this.tMl = System.currentTimeMillis();
    }
    for (;;)
    {
      this.tMp.unlock();
      ab.i("MicroMsg.LqtBindQueryInfoCache", "setCache: %s, save: %s", new Object[] { parambax, Boolean.valueOf(paramBoolean) });
      try
      {
        d.post(new p.2(this, parambax.toByteArray(), paramBoolean), "LqtBindQueryInfoCache_saveCacheToDiski");
        al.d(new p.1(this));
        AppMethodBeat.o(45249);
        return;
        label105:
        this.tMk = parambax;
        this.tMo = null;
        this.tMm = System.currentTimeMillis();
      }
      catch (Exception parambax)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.LqtBindQueryInfoCache", parambax, "saveCacheToDisk error: %s", new Object[] { parambax.getMessage() });
        }
      }
    }
  }
  
  public final void a(bhf parambhf)
  {
    this.tMq = parambhf.tMq;
    this.tMr = parambhf.tMr;
    this.tMs = parambhf.tMs;
    this.tMt = parambhf.tMt;
    this.tMu = parambhf.tMu;
    this.tMv = parambhf.xwk;
  }
  
  public final Bankcard cQM()
  {
    AppMethodBeat.i(45252);
    nn(true);
    Object localObject = this.tMj;
    if (localObject != null)
    {
      localObject = ah.a(((bax)localObject).xqb);
      AppMethodBeat.o(45252);
      return localObject;
    }
    AppMethodBeat.o(45252);
    return null;
  }
  
  public final String cQN()
  {
    AppMethodBeat.i(45254);
    nn(true);
    Object localObject = this.tMj;
    if (localObject != null)
    {
      localObject = ((bax)localObject).xqf;
      AppMethodBeat.o(45254);
      return localObject;
    }
    AppMethodBeat.o(45254);
    return "";
  }
  
  public final int cQO()
  {
    AppMethodBeat.i(45255);
    nn(true);
    bax localbax = this.tMj;
    if (localbax != null)
    {
      int i = localbax.xqg;
      AppMethodBeat.o(45255);
      return i;
    }
    AppMethodBeat.o(45255);
    return 0;
  }
  
  public final boolean nj(boolean paramBoolean)
  {
    AppMethodBeat.i(45250);
    nn(paramBoolean);
    if (paramBoolean) {}
    for (bax localbax = this.tMj; localbax != null; localbax = this.tMk)
    {
      ab.i("MicroMsg.LqtBindQueryInfoCache", "isReqAgainAfterDeal: %s", new Object[] { Boolean.valueOf(localbax.xqd) });
      paramBoolean = localbax.xqd;
      AppMethodBeat.o(45250);
      return paramBoolean;
    }
    AppMethodBeat.o(45250);
    return false;
  }
  
  public final Bankcard nk(boolean paramBoolean)
  {
    AppMethodBeat.i(45251);
    nn(paramBoolean);
    if (paramBoolean) {}
    for (Object localObject1 = this.tMj; (localObject1 != null) && (!bo.isNullOrNil(((bax)localObject1).xpZ)); localObject1 = this.tMk)
    {
      Object localObject2 = nm(paramBoolean);
      if ((localObject2 == null) || (((List)localObject2).size() <= 0)) {
        break;
      }
      localObject1 = ((bax)localObject1).xpZ;
      if (bo.isNullOrNil((String)localObject1)) {
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
      AppMethodBeat.o(45251);
      return localBankcard;
    }
    AppMethodBeat.o(45251);
    return null;
  }
  
  public final List<Bankcard> nl(boolean paramBoolean)
  {
    AppMethodBeat.i(45253);
    nn(paramBoolean);
    if (paramBoolean) {}
    for (Object localObject = this.tMj; localObject != null; localObject = this.tMk)
    {
      localObject = nm(paramBoolean);
      AppMethodBeat.o(45253);
      return localObject;
    }
    AppMethodBeat.o(45253);
    return null;
  }
  
  public final void nn(boolean paramBoolean)
  {
    AppMethodBeat.i(45258);
    long l2 = System.currentTimeMillis();
    bax localbax;
    long l1;
    if (paramBoolean)
    {
      localbax = this.tMj;
      if (!paramBoolean) {
        break label89;
      }
      l1 = this.tMl;
      label30:
      if (localbax != null)
      {
        if (l2 - l1 <= 3600000L) {
          break label73;
        }
        ab.i("MicroMsg.LqtBindQueryInfoCache", "checkCache, saveCache time exceed, try reload from disk");
        this.tMj = null;
        if (!paramBoolean) {
          break label97;
        }
        this.tMl = 0L;
      }
    }
    for (;;)
    {
      no(paramBoolean);
      label73:
      AppMethodBeat.o(45258);
      return;
      localbax = this.tMk;
      break;
      label89:
      l1 = this.tMm;
      break label30;
      label97:
      this.tMm = 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.a.a.p
 * JD-Core Version:    0.7.0.1
 */
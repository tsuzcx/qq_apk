package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ai;
import com.tencent.mm.plugin.wallet_core.model.an;
import com.tencent.mm.plugin.wallet_core.model.d;
import com.tencent.mm.protocal.protobuf.ajt;
import com.tencent.mm.protocal.protobuf.bws;
import com.tencent.mm.protocal.protobuf.ceo;
import com.tencent.mm.protocal.protobuf.ud;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.c;
import com.tencent.mm.vfs.o;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.locks.ReentrantLock;

public final class s
{
  public static final s COW;
  private static final String COX;
  private static final String COY;
  public bws COG;
  public bws COH;
  private long COI;
  private long COJ;
  private List<Bankcard> COK;
  private List<Bankcard> COL;
  private ReentrantLock COM;
  public String CON;
  public String COO;
  public String COP;
  public int COQ;
  public String COR;
  public String COS;
  public String COT;
  public ajt COU;
  public Vector<a> COV;
  
  static
  {
    AppMethodBeat.i(68473);
    COW = new s();
    COX = eFO() + "/save/";
    COY = eFO() + "/fetch/";
    AppMethodBeat.o(68473);
  }
  
  public s()
  {
    AppMethodBeat.i(68461);
    this.COM = new ReentrantLock();
    this.COV = new Vector();
    AppMethodBeat.o(68461);
  }
  
  public static List<Bankcard> VN(int paramInt)
  {
    AppMethodBeat.i(68468);
    Object localObject1 = COW;
    boolean bool;
    Object localObject2;
    if (paramInt == 1)
    {
      bool = true;
      localObject2 = ((s)localObject1).tX(bool);
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((List)localObject2).size() != 0) {}
      }
      else
      {
        com.tencent.mm.plugin.wallet.a.s.eGW();
        localObject1 = com.tencent.mm.plugin.wallet.a.s.eGX().eKf();
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
        if (localBankcard.eIy())
        {
          com.tencent.mm.plugin.wallet.a.s.eGW();
          if (!com.tencent.mm.plugin.wallet.a.s.eGX().eJJ())
          {
            ((List)localObject2).add(localBankcard);
            continue;
            bool = false;
            break;
          }
        }
        if ((paramInt == 1) && ((localBankcard.field_support_lqt_turn_in == 1) || (localBankcard.eIy()))) {
          ((List)localObject2).add(localBankcard);
        }
        if ((paramInt == 2) && ((localBankcard.field_support_lqt_turn_out == 1) || (localBankcard.eIy()))) {
          ((List)localObject2).add(localBankcard);
        }
      }
    }
    label190:
    AppMethodBeat.o(68468);
    return localObject2;
  }
  
  private static String eFO()
  {
    AppMethodBeat.i(68471);
    String str = com.tencent.mm.loader.j.b.asj() + "wallet/lqt/";
    AppMethodBeat.o(68471);
    return str;
  }
  
  private List<Bankcard> tY(boolean paramBoolean)
  {
    AppMethodBeat.i(68469);
    bws localbws;
    if (paramBoolean) {
      localbws = this.COG;
    }
    try
    {
      this.COM.lock();
      if (localbws == null)
      {
        if (paramBoolean) {
          this.COK = null;
        }
        for (;;)
        {
          return null;
          localbws = this.COH;
          break;
          this.COL = null;
        }
      }
      if (!paramBoolean) {
        break label121;
      }
    }
    finally
    {
      this.COM.unlock();
      AppMethodBeat.o(68469);
    }
    if ((this.COK != null) && (this.COK.size() > 0))
    {
      localObject2 = this.COK;
      this.COM.unlock();
      AppMethodBeat.o(68469);
      return localObject2;
      label121:
      if ((this.COL != null) && (this.COL.size() > 0))
      {
        localObject2 = this.COL;
        this.COM.unlock();
        AppMethodBeat.o(68469);
        return localObject2;
      }
    }
    Bankcard localBankcard;
    if (paramBoolean)
    {
      this.COK = new ArrayList();
      if (this.COG.HjC != null)
      {
        localObject2 = ai.a(this.COG.HjC);
        if (localObject2 != null) {
          this.COK.add(localObject2);
        }
      }
      if ((this.COG.GOH != null) && (this.COG.GOH.size() > 0))
      {
        localObject2 = this.COG.GOH.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localBankcard = d.a((ud)((Iterator)localObject2).next());
          if (localBankcard != null) {
            this.COK.add(localBankcard);
          }
        }
      }
      localObject2 = this.COK;
      this.COM.unlock();
      AppMethodBeat.o(68469);
      return localObject2;
    }
    this.COL = new ArrayList();
    if (this.COH.HjC != null)
    {
      localObject2 = ai.a(this.COH.HjC);
      if (localObject2 != null) {
        this.COL.add(localObject2);
      }
    }
    if ((this.COH.GOH != null) && (this.COH.GOH.size() > 0))
    {
      localObject2 = this.COH.GOH.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localBankcard = d.a((ud)((Iterator)localObject2).next());
        if (localBankcard != null) {
          this.COL.add(localBankcard);
        }
      }
    }
    Object localObject2 = this.COL;
    this.COM.unlock();
    AppMethodBeat.o(68469);
    return localObject2;
  }
  
  private void ua(boolean paramBoolean)
  {
    AppMethodBeat.i(68472);
    if (paramBoolean) {}
    Object localObject1;
    for (String str = COX;; str = COY)
    {
      localObject1 = o.dh(str, false);
      if (localObject1 != null) {
        break;
      }
      AppMethodBeat.o(68472);
      return;
    }
    ae.i("MicroMsg.LqtBindQueryInfoCache", "tryLoadCacheFromDisk: %s, save: %s", new Object[] { localObject1, Boolean.valueOf(paramBoolean) });
    long l1 = System.currentTimeMillis();
    Iterator localIterator = ((Iterable)localObject1).iterator();
    while (localIterator.hasNext())
    {
      localObject1 = ((c)localIterator.next()).name;
      Object localObject2 = str + (String)localObject1;
      long l2 = bu.getLong((String)localObject1, 0L);
      ae.i("MicroMsg.LqtBindQueryInfoCache", "file name: %s", new Object[] { Long.valueOf(l2) });
      if (l2 > 0L)
      {
        if (l1 - l2 < 3600000L)
        {
          localObject2 = o.bb((String)localObject2, 0, -1);
          localObject1 = new bws();
          try
          {
            ((bws)localObject1).parseFrom((byte[])localObject2);
            if (localObject1 == null) {
              continue;
            }
            this.COM.lock();
            if (paramBoolean)
            {
              this.COG = ((bws)localObject1);
              this.COK = null;
              this.COI = l2;
              this.COM.unlock();
              ae.i("MicroMsg.LqtBindQueryInfoCache", "succ get saveCache: %s %s", new Object[] { localObject1, Long.valueOf(l2) });
              AppMethodBeat.o(68472);
              return;
            }
          }
          catch (IOException localIOException)
          {
            for (;;)
            {
              localObject1 = null;
              ae.printErrStackTrace("MicroMsg.LqtBindQueryInfoCache", localIOException, "parse bindquery from cache error: %s", new Object[] { localIOException.getMessage() });
              continue;
              this.COH = ((bws)localObject1);
              this.COL = null;
              this.COJ = l2;
            }
          }
        }
        else
        {
          o.deleteFile(localIOException);
        }
      }
      else {
        o.deleteFile(localIOException);
      }
    }
    AppMethodBeat.o(68472);
  }
  
  public final void a(bws parambws, final boolean paramBoolean)
  {
    AppMethodBeat.i(68462);
    if (parambws != null)
    {
      this.COM.lock();
      if (!paramBoolean) {
        break label105;
      }
      this.COG = parambws;
      this.COK = null;
      this.COI = System.currentTimeMillis();
    }
    for (;;)
    {
      this.COM.unlock();
      ae.i("MicroMsg.LqtBindQueryInfoCache", "setCache: %s, save: %s", new Object[] { parambws, Boolean.valueOf(paramBoolean) });
      try
      {
        com.tencent.mm.sdk.g.b.c(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(68460);
            if (this.uzC != null)
            {
              s.b(s.this).lock();
              if (paramBoolean)
              {
                if (o.fB(s.COX)) {
                  o.dd(s.COX, true);
                }
                o.aZI(s.COX);
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
                    str = s.COX;
                    ae.i("MicroMsg.LqtBindQueryInfoCache", "saveCacheToDisk, dir: %s, name: %s, save: %s", new Object[] { str, localObject, Boolean.valueOf(paramBoolean) });
                    l = bu.HQ();
                    localStringBuilder = new StringBuilder();
                    if (!paramBoolean) {
                      break label254;
                    }
                  }
                  label254:
                  for (String str = s.COX;; str = s.COY)
                  {
                    str = str + (String)localObject;
                    localObject = this.uzC;
                    o.f(str, (byte[])localObject, localObject.length);
                    ae.i("MicroMsg.LqtBindQueryInfoCache", "finish saveCacheToDisk, used %sms", new Object[] { Long.valueOf(bu.aO(l)) });
                    AppMethodBeat.o(68460);
                    return;
                    if (o.fB(s.COY)) {
                      o.dd(s.COY, true);
                    }
                    o.aZI(s.COY);
                    s.d(s.this);
                    break;
                    str = s.COY;
                    break label100;
                  }
                  AppMethodBeat.o(68460);
                }
                catch (Exception localException)
                {
                  ae.printErrStackTrace("MicroMsg.LqtBindQueryInfoCache", localException, "saveCacheToDisk error: %s", new Object[] { localException.getMessage() });
                }
              }
            }
          }
        }, "LqtBindQueryInfoCache_saveCacheToDiski");
        ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(68459);
            Iterator localIterator = s.a(s.this).iterator();
            while (localIterator.hasNext()) {
              ((s.a)localIterator.next()).eFP();
            }
            AppMethodBeat.o(68459);
          }
        });
        AppMethodBeat.o(68462);
        return;
        label105:
        this.COH = parambws;
        this.COL = null;
        this.COJ = System.currentTimeMillis();
      }
      catch (Exception parambws)
      {
        for (;;)
        {
          ae.printErrStackTrace("MicroMsg.LqtBindQueryInfoCache", parambws, "saveCacheToDisk error: %s", new Object[] { parambws.getMessage() });
        }
      }
    }
  }
  
  public final void a(ceo paramceo)
  {
    this.CON = paramceo.CON;
    this.COO = paramceo.COO;
    this.COP = paramceo.COP;
    this.COQ = paramceo.COQ;
    this.COR = paramceo.COR;
    this.COS = paramceo.Hrm;
    this.COU = paramceo.Hrn;
  }
  
  public final Bankcard eFL()
  {
    AppMethodBeat.i(68464);
    tZ(true);
    Object localObject = this.COG;
    if (localObject != null)
    {
      localObject = ai.a(((bws)localObject).HjC);
      AppMethodBeat.o(68464);
      return localObject;
    }
    AppMethodBeat.o(68464);
    return null;
  }
  
  public final String eFM()
  {
    AppMethodBeat.i(68466);
    tZ(true);
    Object localObject = this.COG;
    if (localObject != null)
    {
      localObject = ((bws)localObject).HjG;
      AppMethodBeat.o(68466);
      return localObject;
    }
    AppMethodBeat.o(68466);
    return "";
  }
  
  public final int eFN()
  {
    AppMethodBeat.i(68467);
    tZ(true);
    bws localbws = this.COG;
    if (localbws != null)
    {
      int i = localbws.HjH;
      AppMethodBeat.o(68467);
      return i;
    }
    AppMethodBeat.o(68467);
    return 0;
  }
  
  public final Bankcard tW(boolean paramBoolean)
  {
    AppMethodBeat.i(68463);
    tZ(paramBoolean);
    if (paramBoolean) {}
    for (Object localObject1 = this.COG; (localObject1 != null) && (!bu.isNullOrNil(((bws)localObject1).HjA)); localObject1 = this.COH)
    {
      Object localObject2 = tY(paramBoolean);
      if ((localObject2 == null) || (((List)localObject2).size() <= 0)) {
        break;
      }
      localObject1 = ((bws)localObject1).HjA;
      if (bu.isNullOrNil((String)localObject1)) {
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
  
  public final List<Bankcard> tX(boolean paramBoolean)
  {
    AppMethodBeat.i(68465);
    tZ(paramBoolean);
    if (paramBoolean) {}
    for (Object localObject = this.COG; localObject != null; localObject = this.COH)
    {
      localObject = tY(paramBoolean);
      AppMethodBeat.o(68465);
      return localObject;
    }
    AppMethodBeat.o(68465);
    return null;
  }
  
  public final void tZ(boolean paramBoolean)
  {
    AppMethodBeat.i(68470);
    long l2 = System.currentTimeMillis();
    bws localbws;
    if (paramBoolean)
    {
      localbws = this.COG;
      if (!paramBoolean) {
        break label56;
      }
    }
    label56:
    for (long l1 = this.COI;; l1 = this.COJ)
    {
      if (localbws != null) {
        break label64;
      }
      ua(paramBoolean);
      AppMethodBeat.o(68470);
      return;
      localbws = this.COH;
      break;
    }
    label64:
    if (l2 - l1 > 3600000L) {
      ae.i("MicroMsg.LqtBindQueryInfoCache", "checkCache, saveCache time exceed, try reload from disk");
    }
    AppMethodBeat.o(68470);
  }
  
  public static abstract interface a
  {
    public abstract void eFP();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.s
 * JD-Core Version:    0.7.0.1
 */
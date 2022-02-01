package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.plugin.wallet.a.s;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.aj;
import com.tencent.mm.plugin.wallet_core.model.ao;
import com.tencent.mm.plugin.wallet_core.model.d;
import com.tencent.mm.protocal.protobuf.ani;
import com.tencent.mm.protocal.protobuf.ctc;
import com.tencent.mm.protocal.protobuf.ded;
import com.tencent.mm.protocal.protobuf.vm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.vfs.f;
import com.tencent.mm.vfs.u;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.locks.ReentrantLock;

public final class v
{
  private static final String OlA;
  public static final v Oly;
  private static final String Olz;
  public ctc Oli;
  public ctc Olj;
  private long Olk;
  private long Oll;
  private List<Bankcard> Olm;
  private List<Bankcard> Oln;
  private ReentrantLock Olo;
  public String Olp;
  public String Olq;
  public String Olr;
  public int Ols;
  public String Olt;
  public String Olu;
  public String Olv;
  public ani Olw;
  public Vector<a> Olx;
  
  static
  {
    AppMethodBeat.i(68473);
    Oly = new v();
    Olz = gFB() + "/save/";
    OlA = gFB() + "/fetch/";
    AppMethodBeat.o(68473);
  }
  
  public v()
  {
    AppMethodBeat.i(68461);
    this.Olo = new ReentrantLock();
    this.Olx = new Vector();
    AppMethodBeat.o(68461);
  }
  
  private List<Bankcard> BB(boolean paramBoolean)
  {
    AppMethodBeat.i(68469);
    ctc localctc;
    if (paramBoolean) {
      localctc = this.Oli;
    }
    try
    {
      this.Olo.lock();
      if (localctc == null)
      {
        if (paramBoolean) {
          this.Olm = null;
        }
        for (;;)
        {
          return null;
          localctc = this.Olj;
          break;
          this.Oln = null;
        }
      }
      if (!paramBoolean) {
        break label121;
      }
    }
    finally
    {
      this.Olo.unlock();
      AppMethodBeat.o(68469);
    }
    if ((this.Olm != null) && (this.Olm.size() > 0))
    {
      localObject2 = this.Olm;
      this.Olo.unlock();
      AppMethodBeat.o(68469);
      return localObject2;
      label121:
      if ((this.Oln != null) && (this.Oln.size() > 0))
      {
        localObject2 = this.Oln;
        this.Olo.unlock();
        AppMethodBeat.o(68469);
        return localObject2;
      }
    }
    Bankcard localBankcard;
    if (paramBoolean)
    {
      this.Olm = new ArrayList();
      if (this.Oli.TAL != null)
      {
        localObject2 = aj.a(this.Oli.TAL);
        if (localObject2 != null) {
          this.Olm.add(localObject2);
        }
      }
      if ((this.Oli.Tbw != null) && (this.Oli.Tbw.size() > 0))
      {
        localObject2 = this.Oli.Tbw.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localBankcard = d.a((vm)((Iterator)localObject2).next());
          if (localBankcard != null) {
            this.Olm.add(localBankcard);
          }
        }
      }
      localObject2 = this.Olm;
      this.Olo.unlock();
      AppMethodBeat.o(68469);
      return localObject2;
    }
    this.Oln = new ArrayList();
    if (this.Olj.TAL != null)
    {
      localObject2 = aj.a(this.Olj.TAL);
      if (localObject2 != null) {
        this.Oln.add(localObject2);
      }
    }
    if ((this.Olj.Tbw != null) && (this.Olj.Tbw.size() > 0))
    {
      localObject2 = this.Olj.Tbw.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localBankcard = d.a((vm)((Iterator)localObject2).next());
        if (localBankcard != null) {
          this.Oln.add(localBankcard);
        }
      }
    }
    Object localObject2 = this.Oln;
    this.Olo.unlock();
    AppMethodBeat.o(68469);
    return localObject2;
  }
  
  private void BD(boolean paramBoolean)
  {
    AppMethodBeat.i(68472);
    if (paramBoolean) {}
    Object localObject1;
    for (String str = Olz;; str = OlA)
    {
      localObject1 = u.dP(str, false);
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
      localObject1 = ((f)localIterator.next()).name;
      Object localObject2 = str + (String)localObject1;
      long l2 = Util.getLong((String)localObject1, 0L);
      Log.i("MicroMsg.LqtBindQueryInfoCache", "file name: %s", new Object[] { Long.valueOf(l2) });
      if (l2 > 0L)
      {
        if (l1 - l2 < 3600000L)
        {
          localObject2 = u.aY((String)localObject2, 0, -1);
          localObject1 = new ctc();
          try
          {
            ((ctc)localObject1).parseFrom((byte[])localObject2);
            if (localObject1 == null) {
              continue;
            }
            this.Olo.lock();
            if (paramBoolean)
            {
              this.Oli = ((ctc)localObject1);
              this.Olm = null;
              this.Olk = l2;
              this.Olo.unlock();
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
              this.Olj = ((ctc)localObject1);
              this.Oln = null;
              this.Oll = l2;
            }
          }
        }
        else
        {
          u.deleteFile(localIOException);
        }
      }
      else {
        u.deleteFile(localIOException);
      }
    }
    AppMethodBeat.o(68472);
  }
  
  public static List<Bankcard> alZ(int paramInt)
  {
    AppMethodBeat.i(68468);
    Object localObject1 = Oly;
    boolean bool;
    Object localObject2;
    if (paramInt == 1)
    {
      bool = true;
      localObject2 = ((v)localObject1).BA(bool);
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((List)localObject2).size() != 0) {}
      }
      else
      {
        s.gGL();
        localObject1 = s.gGM().gKp();
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
        if (localBankcard.gIH())
        {
          s.gGL();
          if (!s.gGM().gJS())
          {
            ((List)localObject2).add(localBankcard);
            continue;
            bool = false;
            break;
          }
        }
        if ((paramInt == 1) && ((localBankcard.field_support_lqt_turn_in == 1) || (localBankcard.gIH()))) {
          ((List)localObject2).add(localBankcard);
        }
        if ((paramInt == 2) && ((localBankcard.field_support_lqt_turn_out == 1) || (localBankcard.gIH()))) {
          ((List)localObject2).add(localBankcard);
        }
      }
    }
    label190:
    AppMethodBeat.o(68468);
    return localObject2;
  }
  
  private static String gFB()
  {
    AppMethodBeat.i(68471);
    String str = b.aSL() + "wallet/lqt/";
    AppMethodBeat.o(68471);
    return str;
  }
  
  public final List<Bankcard> BA(boolean paramBoolean)
  {
    AppMethodBeat.i(68465);
    BC(paramBoolean);
    if (paramBoolean) {}
    for (Object localObject = this.Oli; localObject != null; localObject = this.Olj)
    {
      localObject = BB(paramBoolean);
      AppMethodBeat.o(68465);
      return localObject;
    }
    AppMethodBeat.o(68465);
    return null;
  }
  
  public final void BC(boolean paramBoolean)
  {
    AppMethodBeat.i(68470);
    long l2 = System.currentTimeMillis();
    ctc localctc;
    if (paramBoolean)
    {
      localctc = this.Oli;
      if (!paramBoolean) {
        break label60;
      }
    }
    label60:
    for (long l1 = this.Olk;; l1 = this.Oll)
    {
      if ((localctc != null) || (!paramBoolean)) {
        break label68;
      }
      BD(paramBoolean);
      AppMethodBeat.o(68470);
      return;
      localctc = this.Olj;
      break;
    }
    label68:
    if (l2 - l1 > 3600000L) {
      Log.i("MicroMsg.LqtBindQueryInfoCache", "checkCache, saveCache time exceed, try reload from disk");
    }
    AppMethodBeat.o(68470);
  }
  
  public final Bankcard By(boolean paramBoolean)
  {
    AppMethodBeat.i(68463);
    BC(paramBoolean);
    if (paramBoolean) {}
    for (Object localObject1 = this.Oli; (localObject1 != null) && (!Util.isNullOrNil(((ctc)localObject1).TAJ)); localObject1 = this.Olj)
    {
      Object localObject2 = BB(paramBoolean);
      if ((localObject2 == null) || (((List)localObject2).size() <= 0)) {
        break;
      }
      localObject1 = ((ctc)localObject1).TAJ;
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
  
  public final ctc Bz(boolean paramBoolean)
  {
    AppMethodBeat.i(218871);
    BC(paramBoolean);
    if (paramBoolean)
    {
      localctc = this.Oli;
      AppMethodBeat.o(218871);
      return localctc;
    }
    ctc localctc = this.Olj;
    AppMethodBeat.o(218871);
    return localctc;
  }
  
  public final void a(ctc paramctc, final boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(218863);
    if (paramBoolean2)
    {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(68459);
          Iterator localIterator = v.a(v.this).iterator();
          while (localIterator.hasNext()) {
            ((v.a)localIterator.next()).BE(true);
          }
          AppMethodBeat.o(68459);
        }
      });
      AppMethodBeat.o(218863);
      return;
    }
    if (paramctc != null)
    {
      this.Olo.lock();
      if (!paramBoolean1) {
        break label127;
      }
      this.Oli = paramctc;
      this.Olm = null;
      this.Olk = System.currentTimeMillis();
    }
    for (;;)
    {
      this.Olo.unlock();
      Log.i("MicroMsg.LqtBindQueryInfoCache", "setCache: %s, save: %s", new Object[] { paramctc, Boolean.valueOf(paramBoolean1) });
      try
      {
        ThreadPool.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(189836);
            if (this.CVL != null)
            {
              v.b(v.this).lock();
              if (paramBoolean1)
              {
                if (u.agG(v.Olz)) {
                  u.dK(v.Olz, true);
                }
                u.bBD(v.Olz);
                v.c(v.this);
              }
              for (;;)
              {
                v.b(v.this).unlock();
                try
                {
                  String str2 = System.currentTimeMillis();
                  label100:
                  long l;
                  StringBuilder localStringBuilder;
                  if (paramBoolean1)
                  {
                    str1 = v.Olz;
                    Log.i("MicroMsg.LqtBindQueryInfoCache", "saveCacheToDisk, dir: %s, name: %s, save: %s", new Object[] { str1, str2, Boolean.valueOf(paramBoolean1) });
                    l = Util.currentTicks();
                    localStringBuilder = new StringBuilder();
                    if (!paramBoolean1) {
                      break label245;
                    }
                  }
                  label245:
                  for (String str1 = v.Olz;; str1 = v.OlA)
                  {
                    u.H(str1 + str2, this.CVL);
                    Log.i("MicroMsg.LqtBindQueryInfoCache", "finish saveCacheToDisk, used %sms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
                    AppMethodBeat.o(189836);
                    return;
                    if (u.agG(v.OlA)) {
                      u.dK(v.OlA, true);
                    }
                    u.bBD(v.OlA);
                    v.d(v.this);
                    break;
                    str1 = v.OlA;
                    break label100;
                  }
                  AppMethodBeat.o(189836);
                }
                catch (Exception localException)
                {
                  Log.printErrStackTrace("MicroMsg.LqtBindQueryInfoCache", localException, "saveCacheToDisk error: %s", new Object[] { localException.getMessage() });
                }
              }
            }
          }
        }, "LqtBindQueryInfoCache_saveCacheToDiski");
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(68460);
            Iterator localIterator = v.a(v.this).iterator();
            while (localIterator.hasNext()) {
              ((v.a)localIterator.next()).BE(false);
            }
            AppMethodBeat.o(68460);
          }
        });
        AppMethodBeat.o(218863);
        return;
        label127:
        this.Olj = paramctc;
        this.Oln = null;
        this.Oll = System.currentTimeMillis();
      }
      catch (Exception paramctc)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.LqtBindQueryInfoCache", paramctc, "saveCacheToDisk error: %s", new Object[] { paramctc.getMessage() });
        }
      }
    }
  }
  
  public final void a(ded paramded)
  {
    this.Olp = paramded.Olp;
    this.Olq = paramded.Olq;
    this.Olr = paramded.Olr;
    this.Ols = paramded.Ols;
    this.Olt = paramded.Olt;
    this.Olu = paramded.TLL;
    this.Olw = paramded.TLM;
  }
  
  public final int gFA()
  {
    AppMethodBeat.i(68467);
    BC(true);
    ctc localctc = this.Oli;
    if (localctc != null)
    {
      int i = localctc.TAQ;
      AppMethodBeat.o(68467);
      return i;
    }
    AppMethodBeat.o(68467);
    return 0;
  }
  
  public final Bankcard gFy()
  {
    AppMethodBeat.i(68464);
    BC(true);
    Object localObject = this.Oli;
    if (localObject != null)
    {
      localObject = aj.a(((ctc)localObject).TAL);
      AppMethodBeat.o(68464);
      return localObject;
    }
    AppMethodBeat.o(68464);
    return null;
  }
  
  public final String gFz()
  {
    AppMethodBeat.i(68466);
    BC(true);
    Object localObject = this.Oli;
    if (localObject != null)
    {
      localObject = ((ctc)localObject).TAP;
      AppMethodBeat.o(68466);
      return localObject;
    }
    AppMethodBeat.o(68466);
    return "";
  }
  
  public static abstract interface a
  {
    public abstract void BE(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.v
 * JD-Core Version:    0.7.0.1
 */
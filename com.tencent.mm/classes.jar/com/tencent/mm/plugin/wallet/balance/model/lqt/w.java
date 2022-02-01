package com.tencent.mm.plugin.wallet.balance.model.lqt;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.loader.i.b;
import com.tencent.mm.plugin.wallet.model.p;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ah;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.d;
import com.tencent.mm.protocal.protobuf.arb;
import com.tencent.mm.protocal.protobuf.dke;
import com.tencent.mm.protocal.protobuf.dwc;
import com.tencent.mm.protocal.protobuf.eir;
import com.tencent.mm.protocal.protobuf.xe;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.aq;
import com.tencent.mm.vfs.j;
import com.tencent.mm.vfs.y;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.locks.ReentrantLock;

public final class w
{
  public static String Vab;
  public static final w Vad;
  private static final String Vae;
  private static final String Vaf;
  public dke UZL;
  public dke UZM;
  private long UZN;
  private long UZO;
  private List<Bankcard> UZP;
  private List<Bankcard> UZQ;
  private ReentrantLock UZR;
  public String UZS;
  public String UZT;
  public String UZU;
  public int UZV;
  public String UZW;
  public String UZX;
  public String UZY;
  public arb UZZ;
  public LinkedList<eir> Vaa;
  public Vector<a> Vac;
  
  static
  {
    AppMethodBeat.i(68473);
    Vab = "WCPay.OnClickPurchaseRes";
    Vad = new w();
    Vae = iez() + "/save/";
    Vaf = iez() + "/fetch/";
    AppMethodBeat.o(68473);
  }
  
  public w()
  {
    AppMethodBeat.i(68461);
    this.UZR = new ReentrantLock();
    this.Vac = new Vector();
    AppMethodBeat.o(68461);
  }
  
  private List<Bankcard> Hh(boolean paramBoolean)
  {
    AppMethodBeat.i(68469);
    dke localdke;
    if (paramBoolean) {
      localdke = this.UZL;
    }
    try
    {
      this.UZR.lock();
      if (localdke == null)
      {
        if (paramBoolean) {
          this.UZP = null;
        }
        for (;;)
        {
          return null;
          localdke = this.UZM;
          break;
          this.UZQ = null;
        }
      }
      if (!paramBoolean) {
        break label121;
      }
    }
    finally
    {
      this.UZR.unlock();
      AppMethodBeat.o(68469);
    }
    if ((this.UZP != null) && (this.UZP.size() > 0))
    {
      localObject2 = this.UZP;
      this.UZR.unlock();
      AppMethodBeat.o(68469);
      return localObject2;
      label121:
      if ((this.UZQ != null) && (this.UZQ.size() > 0))
      {
        localObject2 = this.UZQ;
        this.UZR.unlock();
        AppMethodBeat.o(68469);
        return localObject2;
      }
    }
    Bankcard localBankcard;
    if (paramBoolean)
    {
      this.UZP = new ArrayList();
      if (this.UZL.aaQa != null)
      {
        localObject2 = ah.a(this.UZL.aaQa);
        if (localObject2 != null) {
          this.UZP.add(localObject2);
        }
      }
      if ((this.UZL.aaoI != null) && (this.UZL.aaoI.size() > 0))
      {
        localObject2 = this.UZL.aaoI.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localBankcard = d.a((xe)((Iterator)localObject2).next());
          if (localBankcard != null) {
            this.UZP.add(localBankcard);
          }
        }
      }
      localObject2 = this.UZP;
      this.UZR.unlock();
      AppMethodBeat.o(68469);
      return localObject2;
    }
    this.UZQ = new ArrayList();
    if (this.UZM.aaQa != null)
    {
      localObject2 = ah.a(this.UZM.aaQa);
      if (localObject2 != null) {
        this.UZQ.add(localObject2);
      }
    }
    if ((this.UZM.aaoI != null) && (this.UZM.aaoI.size() > 0))
    {
      localObject2 = this.UZM.aaoI.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localBankcard = d.a((xe)((Iterator)localObject2).next());
        if (localBankcard != null) {
          this.UZQ.add(localBankcard);
        }
      }
    }
    Object localObject2 = this.UZQ;
    this.UZR.unlock();
    AppMethodBeat.o(68469);
    return localObject2;
  }
  
  private void Hj(boolean paramBoolean)
  {
    AppMethodBeat.i(68472);
    if (paramBoolean) {}
    Object localObject1;
    for (String str = Vae;; str = Vaf)
    {
      localObject1 = y.eB(str, false);
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
      localObject1 = ((j)localIterator.next()).name;
      Object localObject2 = str + (String)localObject1;
      long l2 = Util.getLong((String)localObject1, 0L);
      Log.i("MicroMsg.LqtBindQueryInfoCache", "file name: %s", new Object[] { Long.valueOf(l2) });
      if (l2 > 0L)
      {
        if (l1 - l2 < 3600000L)
        {
          localObject2 = y.bi((String)localObject2, 0, -1);
          localObject1 = new dke();
          try
          {
            ((dke)localObject1).parseFrom((byte[])localObject2);
            if (localObject1 == null) {
              continue;
            }
            this.UZR.lock();
            if (paramBoolean)
            {
              this.UZL = ((dke)localObject1);
              this.UZP = null;
              this.UZN = l2;
              this.UZR.unlock();
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
              this.UZM = ((dke)localObject1);
              this.UZQ = null;
              this.UZO = l2;
            }
          }
        }
        else
        {
          y.deleteFile(localIOException);
        }
      }
      else {
        y.deleteFile(localIOException);
      }
    }
    AppMethodBeat.o(68472);
  }
  
  public static dwc arH(int paramInt)
  {
    AppMethodBeat.i(316101);
    Object localObject = (String)h.baE().ban().d(2, "");
    localObject = (String)localObject + paramInt;
    byte[] arrayOfByte = Base64.decode(MultiProcessMMKV.getMMKV(Vab).getString((String)localObject, ""), 0);
    localObject = new dwc();
    if (arrayOfByte.length > 0) {}
    try
    {
      ((dwc)localObject).parseFrom(arrayOfByte);
      label79:
      AppMethodBeat.o(316101);
      return localObject;
    }
    catch (Exception localException)
    {
      break label79;
    }
  }
  
  public static List<Bankcard> arI(int paramInt)
  {
    AppMethodBeat.i(68468);
    Object localObject1 = Vad;
    boolean bool;
    Object localObject2;
    if (paramInt == 1)
    {
      bool = true;
      localObject2 = ((w)localObject1).Hg(bool);
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((List)localObject2).size() != 0) {}
      }
      else
      {
        p.ifO();
        localObject1 = p.ifP().ijG();
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
          break label191;
        }
        Bankcard localBankcard = (Bankcard)((Iterator)localObject1).next();
        if (localBankcard.ihV())
        {
          p.ifO();
          if (!p.ifP().ijh())
          {
            ((List)localObject2).add(localBankcard);
            continue;
            bool = false;
            break;
          }
        }
        if ((paramInt == 1) && ((localBankcard.field_support_lqt_turn_in == 1) || (localBankcard.ihV()))) {
          ((List)localObject2).add(localBankcard);
        }
        if ((paramInt == 2) && ((localBankcard.field_support_lqt_turn_out == 1) || (localBankcard.ihV()))) {
          ((List)localObject2).add(localBankcard);
        }
      }
    }
    label191:
    AppMethodBeat.o(68468);
    return localObject2;
  }
  
  private static String iez()
  {
    AppMethodBeat.i(68471);
    String str = b.bmz() + "wallet/lqt/";
    AppMethodBeat.o(68471);
    return str;
  }
  
  public final Bankcard He(boolean paramBoolean)
  {
    AppMethodBeat.i(68463);
    Hi(paramBoolean);
    if (paramBoolean) {}
    for (Object localObject1 = this.UZL; (localObject1 != null) && (!Util.isNullOrNil(((dke)localObject1).aaPY)); localObject1 = this.UZM)
    {
      Object localObject2 = Hh(paramBoolean);
      if ((localObject2 == null) || (((List)localObject2).size() <= 0)) {
        break;
      }
      localObject1 = ((dke)localObject1).aaPY;
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
  
  public final dke Hf(boolean paramBoolean)
  {
    AppMethodBeat.i(316162);
    Hi(paramBoolean);
    if (paramBoolean)
    {
      localdke = this.UZL;
      AppMethodBeat.o(316162);
      return localdke;
    }
    dke localdke = this.UZM;
    AppMethodBeat.o(316162);
    return localdke;
  }
  
  public final List<Bankcard> Hg(boolean paramBoolean)
  {
    AppMethodBeat.i(68465);
    Hi(paramBoolean);
    if (paramBoolean) {}
    for (Object localObject = this.UZL; localObject != null; localObject = this.UZM)
    {
      localObject = Hh(paramBoolean);
      AppMethodBeat.o(68465);
      return localObject;
    }
    AppMethodBeat.o(68465);
    return null;
  }
  
  public final void Hi(boolean paramBoolean)
  {
    AppMethodBeat.i(68470);
    long l2 = System.currentTimeMillis();
    dke localdke;
    if (paramBoolean)
    {
      localdke = this.UZL;
      if (!paramBoolean) {
        break label60;
      }
    }
    label60:
    for (long l1 = this.UZN;; l1 = this.UZO)
    {
      if ((localdke != null) || (!paramBoolean)) {
        break label68;
      }
      Hj(paramBoolean);
      AppMethodBeat.o(68470);
      return;
      localdke = this.UZM;
      break;
    }
    label68:
    if (l2 - l1 > 3600000L) {
      Log.i("MicroMsg.LqtBindQueryInfoCache", "checkCache, saveCache time exceed, try reload from disk");
    }
    AppMethodBeat.o(68470);
  }
  
  public final void a(dke paramdke, final boolean paramBoolean1, boolean paramBoolean2, final String paramString)
  {
    AppMethodBeat.i(316145);
    if (paramBoolean2)
    {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(68459);
          Iterator localIterator = w.a(w.this).iterator();
          while (localIterator.hasNext()) {
            ((w.a)localIterator.next()).aI(true, paramString);
          }
          AppMethodBeat.o(68459);
        }
      });
      AppMethodBeat.o(316145);
      return;
    }
    if (paramdke != null)
    {
      this.UZR.lock();
      if (!paramBoolean1) {
        break label129;
      }
      this.UZL = paramdke;
      this.UZP = null;
      this.UZN = System.currentTimeMillis();
    }
    for (;;)
    {
      this.UZR.unlock();
      Log.i("MicroMsg.LqtBindQueryInfoCache", "setCache: %s, save: %s", new Object[] { paramdke, Boolean.valueOf(paramBoolean1) });
      try
      {
        ThreadPool.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(316172);
            if (this.IQd != null)
            {
              w.b(w.this).lock();
              if (paramBoolean1)
              {
                if (y.ZC(w.Vae)) {
                  y.ew(w.Vae, true);
                }
                y.bDX(w.Vae);
                w.c(w.this);
              }
              for (;;)
              {
                w.b(w.this).unlock();
                try
                {
                  Object localObject = System.currentTimeMillis();
                  label100:
                  long l;
                  StringBuilder localStringBuilder;
                  if (paramBoolean1)
                  {
                    str = w.Vae;
                    Log.i("MicroMsg.LqtBindQueryInfoCache", "saveCacheToDisk, dir: %s, name: %s, save: %s", new Object[] { str, localObject, Boolean.valueOf(paramBoolean1) });
                    l = Util.currentTicks();
                    localStringBuilder = new StringBuilder();
                    if (!paramBoolean1) {
                      break label254;
                    }
                  }
                  label254:
                  for (String str = w.Vae;; str = w.Vaf)
                  {
                    str = str + (String)localObject;
                    localObject = this.IQd;
                    y.f(str, (byte[])localObject, localObject.length);
                    Log.i("MicroMsg.LqtBindQueryInfoCache", "finish saveCacheToDisk, used %sms", new Object[] { Long.valueOf(Util.ticksToNow(l)) });
                    AppMethodBeat.o(316172);
                    return;
                    if (y.ZC(w.Vaf)) {
                      y.ew(w.Vaf, true);
                    }
                    y.bDX(w.Vaf);
                    w.d(w.this);
                    break;
                    str = w.Vaf;
                    break label100;
                  }
                  AppMethodBeat.o(316172);
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
            Iterator localIterator = w.a(w.this).iterator();
            while (localIterator.hasNext()) {
              ((w.a)localIterator.next()).aI(false, "");
            }
            AppMethodBeat.o(68460);
          }
        });
        AppMethodBeat.o(316145);
        return;
        label129:
        this.UZM = paramdke;
        this.UZQ = null;
        this.UZO = System.currentTimeMillis();
      }
      catch (Exception paramdke)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.LqtBindQueryInfoCache", paramdke, "saveCacheToDisk error: %s", new Object[] { paramdke.getMessage() });
        }
      }
    }
  }
  
  public final void a(dwc paramdwc, int paramInt)
  {
    AppMethodBeat.i(316150);
    this.UZS = paramdwc.UZS;
    this.UZT = paramdwc.UZT;
    this.UZU = paramdwc.UZU;
    this.UZV = paramdwc.UZV;
    this.UZW = paramdwc.UZW;
    this.UZX = paramdwc.abbP;
    this.UZZ = paramdwc.abbQ;
    this.Vaa = paramdwc.abbY;
    Object localObject = new dwc();
    ((dwc)localObject).BaseResponse = paramdwc.BaseResponse;
    ((dwc)localObject).UZW = paramdwc.UZW;
    ((dwc)localObject).abbS = paramdwc.abbS;
    ((dwc)localObject).abbT = paramdwc.abbT;
    ((dwc)localObject).abbU = paramdwc.abbU;
    ((dwc)localObject).abbV = paramdwc.abbV;
    ((dwc)localObject).abbW = paramdwc.abbW;
    ((dwc)localObject).abbX = paramdwc.abbX;
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV(Vab);
    paramdwc = (String)h.baE().ban().d(2, "");
    String str = paramdwc + paramInt;
    paramdwc = "";
    for (;;)
    {
      try
      {
        localObject = ((dwc)localObject).toByteArray();
        if (localObject.length > 0) {
          paramdwc = Base64.encodeToString((byte[])localObject, 0);
        }
        if (paramdwc != null)
        {
          localObject = paramdwc;
          if (paramdwc.length() != 0)
          {
            localMultiProcessMMKV.putString(str, (String)localObject);
            AppMethodBeat.o(316150);
            return;
          }
        }
      }
      catch (Exception paramdwc)
      {
        AppMethodBeat.o(316150);
        return;
      }
      localObject = "";
    }
  }
  
  public final Bankcard iew()
  {
    AppMethodBeat.i(68464);
    Hi(true);
    Object localObject = this.UZL;
    if (localObject != null)
    {
      localObject = ah.a(((dke)localObject).aaQa);
      AppMethodBeat.o(68464);
      return localObject;
    }
    AppMethodBeat.o(68464);
    return null;
  }
  
  public final String iex()
  {
    AppMethodBeat.i(68466);
    Hi(true);
    Object localObject = this.UZL;
    if (localObject != null)
    {
      localObject = ((dke)localObject).aaQe;
      AppMethodBeat.o(68466);
      return localObject;
    }
    AppMethodBeat.o(68466);
    return "";
  }
  
  public final int iey()
  {
    AppMethodBeat.i(68467);
    Hi(true);
    dke localdke = this.UZL;
    if (localdke != null)
    {
      int i = localdke.aaQf;
      AppMethodBeat.o(68467);
      return i;
    }
    AppMethodBeat.o(68467);
    return 0;
  }
  
  public static abstract interface a
  {
    public abstract void aI(boolean paramBoolean, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.w
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.wallet.balance.model.lqt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ah;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.d;
import com.tencent.mm.protocal.protobuf.agt;
import com.tencent.mm.protocal.protobuf.brl;
import com.tencent.mm.protocal.protobuf.bzd;
import com.tencent.mm.protocal.protobuf.sh;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
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
  public static final s AXi;
  private static final String AXj;
  private static final String AXk;
  public brl AWS;
  public brl AWT;
  private long AWU;
  private long AWV;
  private List<Bankcard> AWW;
  private List<Bankcard> AWX;
  private ReentrantLock AWY;
  public String AWZ;
  public String AXa;
  public String AXb;
  public int AXc;
  public String AXd;
  public String AXe;
  public String AXf;
  public agt AXg;
  public Vector<a> AXh;
  
  static
  {
    AppMethodBeat.i(68473);
    AXi = new s();
    AXj = eoh() + "/save/";
    AXk = eoh() + "/fetch/";
    AppMethodBeat.o(68473);
  }
  
  public s()
  {
    AppMethodBeat.i(68461);
    this.AWY = new ReentrantLock();
    this.AXh = new Vector();
    AppMethodBeat.o(68461);
  }
  
  public static List<Bankcard> Tn(int paramInt)
  {
    AppMethodBeat.i(68468);
    Object localObject1 = AXi;
    boolean bool;
    Object localObject2;
    if (paramInt == 1)
    {
      bool = true;
      localObject2 = ((s)localObject1).tg(bool);
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((List)localObject2).size() != 0) {}
      }
      else
      {
        com.tencent.mm.plugin.wallet.a.s.epp();
        localObject1 = com.tencent.mm.plugin.wallet.a.s.epq().esy();
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
        if (localBankcard.eqR())
        {
          com.tencent.mm.plugin.wallet.a.s.epp();
          if (!com.tencent.mm.plugin.wallet.a.s.epq().esc())
          {
            ((List)localObject2).add(localBankcard);
            continue;
            bool = false;
            break;
          }
        }
        if ((paramInt == 1) && ((localBankcard.field_support_lqt_turn_in == 1) || (localBankcard.eqR()))) {
          ((List)localObject2).add(localBankcard);
        }
        if ((paramInt == 2) && ((localBankcard.field_support_lqt_turn_out == 1) || (localBankcard.eqR()))) {
          ((List)localObject2).add(localBankcard);
        }
      }
    }
    label190:
    AppMethodBeat.o(68468);
    return localObject2;
  }
  
  private static String eoh()
  {
    AppMethodBeat.i(68471);
    String str = com.tencent.mm.loader.j.b.aph() + "wallet/lqt/";
    AppMethodBeat.o(68471);
    return str;
  }
  
  private List<Bankcard> th(boolean paramBoolean)
  {
    AppMethodBeat.i(68469);
    brl localbrl;
    if (paramBoolean) {
      localbrl = this.AWS;
    }
    try
    {
      this.AWY.lock();
      if (localbrl == null)
      {
        if (paramBoolean) {
          this.AWW = null;
        }
        for (;;)
        {
          return null;
          localbrl = this.AWT;
          break;
          this.AWX = null;
        }
      }
      if (!paramBoolean) {
        break label121;
      }
    }
    finally
    {
      this.AWY.unlock();
      AppMethodBeat.o(68469);
    }
    if ((this.AWW != null) && (this.AWW.size() > 0))
    {
      localObject2 = this.AWW;
      this.AWY.unlock();
      AppMethodBeat.o(68469);
      return localObject2;
      label121:
      if ((this.AWX != null) && (this.AWX.size() > 0))
      {
        localObject2 = this.AWX;
        this.AWY.unlock();
        AppMethodBeat.o(68469);
        return localObject2;
      }
    }
    Bankcard localBankcard;
    if (paramBoolean)
    {
      this.AWW = new ArrayList();
      if (this.AWS.Fgz != null)
      {
        localObject2 = ah.a(this.AWS.Fgz);
        if (localObject2 != null) {
          this.AWW.add(localObject2);
        }
      }
      if ((this.AWS.EMe != null) && (this.AWS.EMe.size() > 0))
      {
        localObject2 = this.AWS.EMe.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localBankcard = d.a((sh)((Iterator)localObject2).next());
          if (localBankcard != null) {
            this.AWW.add(localBankcard);
          }
        }
      }
      localObject2 = this.AWW;
      this.AWY.unlock();
      AppMethodBeat.o(68469);
      return localObject2;
    }
    this.AWX = new ArrayList();
    if (this.AWT.Fgz != null)
    {
      localObject2 = ah.a(this.AWT.Fgz);
      if (localObject2 != null) {
        this.AWX.add(localObject2);
      }
    }
    if ((this.AWT.EMe != null) && (this.AWT.EMe.size() > 0))
    {
      localObject2 = this.AWT.EMe.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localBankcard = d.a((sh)((Iterator)localObject2).next());
        if (localBankcard != null) {
          this.AWX.add(localBankcard);
        }
      }
    }
    Object localObject2 = this.AWX;
    this.AWY.unlock();
    AppMethodBeat.o(68469);
    return localObject2;
  }
  
  private void tj(boolean paramBoolean)
  {
    AppMethodBeat.i(68472);
    if (paramBoolean) {}
    Object localObject1;
    for (String str = AXj;; str = AXk)
    {
      localObject1 = i.cZ(str, false);
      if (localObject1 != null) {
        break;
      }
      AppMethodBeat.o(68472);
      return;
    }
    ac.i("MicroMsg.LqtBindQueryInfoCache", "tryLoadCacheFromDisk: %s, save: %s", new Object[] { localObject1, Boolean.valueOf(paramBoolean) });
    long l1 = System.currentTimeMillis();
    Iterator localIterator = ((Iterable)localObject1).iterator();
    while (localIterator.hasNext())
    {
      localObject1 = ((FileSystem.a)localIterator.next()).name;
      Object localObject2 = str + (String)localObject1;
      long l2 = bs.getLong((String)localObject1, 0L);
      ac.i("MicroMsg.LqtBindQueryInfoCache", "file name: %s", new Object[] { Long.valueOf(l2) });
      if (l2 > 0L)
      {
        if (l1 - l2 < 3600000L)
        {
          localObject2 = i.aU((String)localObject2, 0, -1);
          localObject1 = new brl();
          try
          {
            ((brl)localObject1).parseFrom((byte[])localObject2);
            if (localObject1 == null) {
              continue;
            }
            this.AWY.lock();
            if (paramBoolean)
            {
              this.AWS = ((brl)localObject1);
              this.AWW = null;
              this.AWU = l2;
              this.AWY.unlock();
              ac.i("MicroMsg.LqtBindQueryInfoCache", "succ get saveCache: %s %s", new Object[] { localObject1, Long.valueOf(l2) });
              AppMethodBeat.o(68472);
              return;
            }
          }
          catch (IOException localIOException)
          {
            for (;;)
            {
              localObject1 = null;
              ac.printErrStackTrace("MicroMsg.LqtBindQueryInfoCache", localIOException, "parse bindquery from cache error: %s", new Object[] { localIOException.getMessage() });
              continue;
              this.AWT = ((brl)localObject1);
              this.AWX = null;
              this.AWV = l2;
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
  
  public final void a(brl parambrl, boolean paramBoolean)
  {
    AppMethodBeat.i(68462);
    if (parambrl != null)
    {
      this.AWY.lock();
      if (!paramBoolean) {
        break label105;
      }
      this.AWS = parambrl;
      this.AWW = null;
      this.AWU = System.currentTimeMillis();
    }
    for (;;)
    {
      this.AWY.unlock();
      ac.i("MicroMsg.LqtBindQueryInfoCache", "setCache: %s, save: %s", new Object[] { parambrl, Boolean.valueOf(paramBoolean) });
      try
      {
        com.tencent.mm.sdk.g.b.c(new s.2(this, parambrl.toByteArray(), paramBoolean), "LqtBindQueryInfoCache_saveCacheToDiski");
        ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(68459);
            Iterator localIterator = s.a(s.this).iterator();
            while (localIterator.hasNext()) {
              ((s.a)localIterator.next()).eoi();
            }
            AppMethodBeat.o(68459);
          }
        });
        AppMethodBeat.o(68462);
        return;
        label105:
        this.AWT = parambrl;
        this.AWX = null;
        this.AWV = System.currentTimeMillis();
      }
      catch (Exception parambrl)
      {
        for (;;)
        {
          ac.printErrStackTrace("MicroMsg.LqtBindQueryInfoCache", parambrl, "saveCacheToDisk error: %s", new Object[] { parambrl.getMessage() });
        }
      }
    }
  }
  
  public final void a(bzd parambzd)
  {
    this.AWZ = parambzd.AWZ;
    this.AXa = parambzd.AXa;
    this.AXb = parambzd.AXb;
    this.AXc = parambzd.AXc;
    this.AXd = parambzd.AXd;
    this.AXe = parambzd.Foa;
    this.AXg = parambzd.Fob;
  }
  
  public final Bankcard eoe()
  {
    AppMethodBeat.i(68464);
    ti(true);
    Object localObject = this.AWS;
    if (localObject != null)
    {
      localObject = ah.a(((brl)localObject).Fgz);
      AppMethodBeat.o(68464);
      return localObject;
    }
    AppMethodBeat.o(68464);
    return null;
  }
  
  public final String eof()
  {
    AppMethodBeat.i(68466);
    ti(true);
    Object localObject = this.AWS;
    if (localObject != null)
    {
      localObject = ((brl)localObject).FgD;
      AppMethodBeat.o(68466);
      return localObject;
    }
    AppMethodBeat.o(68466);
    return "";
  }
  
  public final int eog()
  {
    AppMethodBeat.i(68467);
    ti(true);
    brl localbrl = this.AWS;
    if (localbrl != null)
    {
      int i = localbrl.FgE;
      AppMethodBeat.o(68467);
      return i;
    }
    AppMethodBeat.o(68467);
    return 0;
  }
  
  public final Bankcard tf(boolean paramBoolean)
  {
    AppMethodBeat.i(68463);
    ti(paramBoolean);
    if (paramBoolean) {}
    for (Object localObject1 = this.AWS; (localObject1 != null) && (!bs.isNullOrNil(((brl)localObject1).Fgx)); localObject1 = this.AWT)
    {
      Object localObject2 = th(paramBoolean);
      if ((localObject2 == null) || (((List)localObject2).size() <= 0)) {
        break;
      }
      localObject1 = ((brl)localObject1).Fgx;
      if (bs.isNullOrNil((String)localObject1)) {
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
  
  public final List<Bankcard> tg(boolean paramBoolean)
  {
    AppMethodBeat.i(68465);
    ti(paramBoolean);
    if (paramBoolean) {}
    for (Object localObject = this.AWS; localObject != null; localObject = this.AWT)
    {
      localObject = th(paramBoolean);
      AppMethodBeat.o(68465);
      return localObject;
    }
    AppMethodBeat.o(68465);
    return null;
  }
  
  public final void ti(boolean paramBoolean)
  {
    AppMethodBeat.i(68470);
    long l2 = System.currentTimeMillis();
    brl localbrl;
    if (paramBoolean)
    {
      localbrl = this.AWS;
      if (!paramBoolean) {
        break label56;
      }
    }
    label56:
    for (long l1 = this.AWU;; l1 = this.AWV)
    {
      if (localbrl != null) {
        break label64;
      }
      tj(paramBoolean);
      AppMethodBeat.o(68470);
      return;
      localbrl = this.AWT;
      break;
    }
    label64:
    if (l2 - l1 > 3600000L) {
      ac.i("MicroMsg.LqtBindQueryInfoCache", "checkCache, saveCache time exceed, try reload from disk");
    }
    AppMethodBeat.o(68470);
  }
  
  public static abstract interface a
  {
    public abstract void eoi();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.balance.model.lqt.s
 * JD-Core Version:    0.7.0.1
 */
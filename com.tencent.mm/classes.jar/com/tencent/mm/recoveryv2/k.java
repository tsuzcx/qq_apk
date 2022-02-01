package com.tencent.mm.recoveryv2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public abstract interface k
{
  public abstract k a(int paramInt, d paramd);
  
  public abstract k a(b paramb);
  
  public abstract void begin();
  
  public abstract void finish();
  
  public static abstract class a
    implements k
  {
    protected i UOX;
    protected final AtomicReference<b> UPD;
    protected final SparseArray<List<d>> UPE;
    protected a UPF;
    protected long UPG;
    protected RecoveryCrash UPH;
    protected RecoveryCrash UPI;
    protected final Context mContext;
    protected final Handler mUiHandler;
    protected final String mVersionName;
    
    public a(Context paramContext)
    {
      this(paramContext, (byte)0);
    }
    
    private a(Context paramContext, byte paramByte)
    {
      this.mContext = paramContext;
      this.mUiHandler = new Handler(Looper.getMainLooper());
      this.mVersionName = m.jZ(this.mContext);
      this.UOX = null;
      this.UPD = new AtomicReference(new b.c().a(null));
      this.UPE = new SparseArray(2);
      this.UPE.put(1, new ArrayList());
      this.UPE.put(2, new ArrayList());
      this.UPI = RecoveryCrash.jM(this.mContext);
    }
    
    public a(a parama)
    {
      this.UPF = parama;
      this.mContext = parama.mContext;
      this.mUiHandler = parama.mUiHandler;
      this.mVersionName = parama.mVersionName;
      this.UPI = parama.UPI;
      this.UOX = parama.UOX;
      this.UPD = parama.UPD;
      this.UPE = parama.UPE;
    }
    
    protected final void EB(boolean paramBoolean)
    {
      if (paramBoolean)
      {
        this.UPH.arg();
        return;
      }
      RecoveryCrash localRecoveryCrash = this.UPH;
      c localc = localRecoveryCrash.UPd;
      localc.UPc.hu("crash_count", localc.UPf).hqh();
      localRecoveryCrash.UPc.nB("crash_version", localRecoveryCrash.UPb).ca("crash_time", localRecoveryCrash.UPa).hqh();
    }
    
    protected final void arK(int paramInt)
    {
      a.a.log(4, "MicroMsg.recovery.trigger", "recovery event, level = ".concat(String.valueOf(paramInt)));
      Iterator localIterator = ((List)this.UPE.get(paramInt)).iterator();
      while (localIterator.hasNext())
      {
        d locald = (d)localIterator.next();
        try
        {
          locald.arF(paramInt);
        }
        catch (Throwable localThrowable)
        {
          a.w("MicroMsg.recovery.trigger", "recovery event error", localThrowable);
        }
      }
    }
    
    public void begin()
    {
      this.UPG = System.currentTimeMillis();
    }
    
    protected final void hpZ()
    {
      if (this.UOX == null)
      {
        this.UOX = i.jP(this.mContext);
        ((b)this.UPD.get()).a(this.UOX);
      }
      if (this.UPI == null) {
        this.UPI = RecoveryCrash.jM(this.mContext);
      }
      this.UPI.hpZ();
      if (this.UPH == null)
      {
        Object localObject = this.UPI;
        Context localContext = ((RecoveryCrash)localObject).mContext;
        long l = ((RecoveryCrash)localObject).UPa;
        String str = ((RecoveryCrash)localObject).UPb;
        h localh = ((RecoveryCrash)localObject).UPc;
        localObject = ((RecoveryCrash)localObject).UPd;
        this.UPH = new RecoveryCrash(localContext, l, str, localh, new c(((c)localObject).UPf, ((c)localObject).UPc));
      }
    }
    
    protected boolean hqJ()
    {
      a.a.log(4, "MicroMsg.recovery.trigger", "onLaunchRecovery");
      try
      {
        ((b)this.UPD.get()).a(this.mContext, this.UPH);
        return true;
      }
      catch (Throwable localThrowable)
      {
        a.w("MicroMsg.recovery.trigger", "on launch recovery action error, mission aborted", localThrowable);
      }
      return false;
    }
    
    protected final void hqK()
    {
      RecoveryCrash localRecoveryCrash = this.UPH;
      c localc = localRecoveryCrash.UPd;
      localc.UPf += 1;
      localRecoveryCrash.UPb = this.mVersionName;
      localRecoveryCrash.UPa = this.UPG;
    }
    
    protected final void hqL()
    {
      this.UPH.hqd();
    }
    
    protected final void onTerminate()
    {
      a.a.log(4, "MicroMsg.recovery.trigger", "#onTerminate");
      try
      {
        ((b)this.UPD.get()).b(this.mContext, this.UPH);
        return;
      }
      catch (Throwable localThrowable) {}
    }
  }
  
  public static final class b
    extends k.a
  {
    final long UPJ;
    k.d UPK;
    k.e UPL;
    
    public b(Context paramContext)
    {
      super();
      AppMethodBeat.i(190269);
      this.UPJ = System.currentTimeMillis();
      AppMethodBeat.o(190269);
    }
    
    private k.e hqM()
    {
      AppMethodBeat.i(190272);
      if (this.UPK == null) {}
      for (Object localObject = this;; localObject = this.UPK)
      {
        localObject = new k.e((k.a)localObject);
        k.e.a locala = k.e.a.cE(this.mContext, "signal_acc");
        localObject = ((k.e)localObject).Uj(this.UPJ).a(locala);
        AppMethodBeat.o(190272);
        return localObject;
      }
    }
    
    public final void arL(int paramInt)
    {
      AppMethodBeat.i(190271);
      try
      {
        if (this.UPL == null) {
          this.UPL = hqM();
        }
        this.UPL.arM(paramInt);
        return;
      }
      finally
      {
        AppMethodBeat.o(190271);
      }
    }
    
    public final void begin()
    {
      AppMethodBeat.i(190270);
      super.begin();
      try
      {
        if ((this.UPK == null) && (this.UPL == null))
        {
          this.UPK = new k.c(this)
          {
            public final void finish()
            {
              AppMethodBeat.i(190268);
              a.a.log(4, "MicroMsg.recovery.combination", "safePoint finish, switch to signal handler");
              if (k.b.this.UPL == null) {
                k.b.this.UPL = k.b.a(k.b.this);
              }
              super.finish();
              AppMethodBeat.o(190268);
            }
          };
          if (this.UPK != null) {
            this.UPK.begin();
          }
          return;
        }
        if (this.UPL == null) {
          this.UPL = hqM();
        }
        if (this.UPL != null) {
          this.UPL.begin();
        }
        return;
      }
      finally
      {
        AppMethodBeat.o(190270);
      }
    }
    
    public final void finish()
    {
      AppMethodBeat.i(190273);
      try
      {
        if (this.UPK != null) {
          this.UPK.finish();
        }
        return;
      }
      finally
      {
        AppMethodBeat.o(190273);
      }
    }
  }
  
  public static class c
    extends k.d
  {
    public c(k.a parama)
    {
      super();
    }
    
    @SuppressLint({"MissingSuperCall"})
    public final void begin()
    {
      AppMethodBeat.i(190308);
      int i = this.UPI.UPd.UPf;
      if (i <= 0)
      {
        a.a.log(4, "MicroMsg.recovery.safePointLazy", "no need check, crash count = ".concat(String.valueOf(i)));
        this.UPO.set(true);
        hqN();
        Callable local1 = new Callable() {};
        Executors.newCachedThreadPool().submit(local1);
        AppMethodBeat.o(190308);
        return;
      }
      super.begin();
      new Future()
      {
        public final boolean cancel(boolean paramAnonymousBoolean)
        {
          return false;
        }
        
        public final boolean isCancelled()
        {
          return false;
        }
        
        public final boolean isDone()
        {
          return true;
        }
      };
      AppMethodBeat.o(190308);
    }
  }
  
  public static class d
    extends k.a
  {
    protected final AtomicBoolean UPO;
    protected final AtomicBoolean UPP;
    
    public d(k.a parama)
    {
      super();
      AppMethodBeat.i(190315);
      this.UPO = new AtomicBoolean();
      this.UPP = new AtomicBoolean();
      AppMethodBeat.o(190315);
    }
    
    public void begin()
    {
      AppMethodBeat.i(190316);
      super.begin();
      hpZ();
      long l1 = this.UPG - this.UPI.UPa;
      a.a.log(4, "MicroMsg.recovery.safePoint", "recovery interval = ".concat(String.valueOf(l1)));
      long l2 = this.UOX.UPq;
      if ((l2 > 0L) && (l1 < l2))
      {
        a.a.log(4, "MicroMsg.recovery.safePoint", "too fast, skip and do nothing, min = ".concat(String.valueOf(l2)));
        AppMethodBeat.o(190316);
        return;
      }
      this.UPO.set(true);
      if ((!TextUtils.isEmpty(this.UPI.UPb)) && (!this.UPI.UPb.equals(this.mVersionName)))
      {
        a.a.log(4, "MicroMsg.recovery.safePoint", "version code mismatch, skip");
        hqL();
      }
      if (l1 >= this.UOX.UPo)
      {
        a.a.log(4, "MicroMsg.recovery.safePoint", "over interval, skip");
        hqL();
      }
      int i = this.UPH.UPd.UPf;
      a.a.log(4, "MicroMsg.recovery.safePoint", "recovery crashCount = ".concat(String.valueOf(i)));
      if (i >= this.UOX.UPm)
      {
        if (!hqJ())
        {
          a.a.log(5, "MicroMsg.recovery.safePoint", "launch recovery fail");
          EB(true);
          AppMethodBeat.o(190316);
          return;
        }
        if (i < this.UOX.UPn)
        {
          arK(1);
          hqK();
        }
        for (;;)
        {
          EB(true);
          onTerminate();
          AppMethodBeat.o(190316);
          return;
          arK(2);
          hqL();
        }
      }
      hqN();
      hqK();
      EB(false);
      hqO();
      AppMethodBeat.o(190316);
    }
    
    public void finish()
    {
      AppMethodBeat.i(190317);
      a.a.log(4, "MicroMsg.recovery.safePoint", "#finish");
      if (this.UPO.get())
      {
        a.a.log(4, "MicroMsg.recovery.safePoint", "clear crash point");
        hpZ();
        hqL();
        EB(true);
      }
      AppMethodBeat.o(190317);
    }
    
    protected final boolean hqJ()
    {
      AppMethodBeat.i(190319);
      boolean bool = super.hqJ();
      if (bool)
      {
        j localj = j.jT(this.mContext);
        localj.UPA = false;
        localj.UPf = this.UPH.UPd.UPf;
        localj.UPw = true;
        localj.mFrom = 1;
        localj.hqI();
      }
      AppMethodBeat.o(190319);
      return bool;
    }
    
    protected final void hqN()
    {
      AppMethodBeat.i(190322);
      a.a.log(4, "MicroMsg.recovery.safePoint", "onLaunchNormal");
      if ((this.UPH != null) && (this.UPH.UPd.UPf > 0))
      {
        j localj = j.jT(this.mContext);
        localj.UPA = false;
        localj.UPf = this.UPH.UPd.UPf;
        localj.UPw = false;
        localj.mFrom = 1;
        localj.hqI();
      }
      AppMethodBeat.o(190322);
    }
    
    protected final void hqO()
    {
      AppMethodBeat.i(190328);
      this.mUiHandler.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(190312);
          if (k.d.this.UPP.get())
          {
            a.a.log(4, "MicroMsg.recovery.safePoint", "auto clear task has been canceled, skip");
            AppMethodBeat.o(190312);
            return;
          }
          a.a.log(4, "MicroMsg.recovery.safePoint", "auto clear point");
          k.d.this.finish();
          AppMethodBeat.o(190312);
        }
      }, this.UOX.UPr);
      AppMethodBeat.o(190328);
    }
    
    protected final void hqP()
    {
      AppMethodBeat.i(190330);
      this.UPP.set(true);
      AppMethodBeat.o(190330);
    }
  }
  
  public static final class e
    extends k.a
  {
    protected long UPC = 0L;
    protected long UPJ = 0L;
    protected a UPR;
    protected int mFrom = 2;
    
    public e(Context paramContext)
    {
      super();
    }
    
    public e(k.a parama)
    {
      super();
    }
    
    private static int aU(long paramLong1, long paramLong2)
    {
      if (paramLong1 >= paramLong2) {
        return 0;
      }
      if ((float)paramLong1 >= (float)paramLong2 * 0.75F) {
        return 25;
      }
      if ((float)paramLong1 >= (float)paramLong2 * 0.5F) {
        return 50;
      }
      if ((float)paramLong1 >= (float)paramLong2 * 0.25F) {
        return 75;
      }
      return 100;
    }
    
    private void hqN()
    {
      AppMethodBeat.i(190386);
      a.a.log(4, "MicroMsg.recovery.signalHandler", "onLaunchNormal");
      if (this.UPH.UPd.UPf > 0)
      {
        j localj = j.jT(this.mContext);
        localj.UPA = false;
        localj.UPf = this.UPH.UPd.UPf;
        localj.UPw = false;
        localj.mFrom = this.mFrom;
        localj.UPC = Math.max(this.UPC, 0L);
        localj.arg();
      }
      AppMethodBeat.o(190386);
    }
    
    public final e Uj(long paramLong)
    {
      this.UPJ = paramLong;
      return this;
    }
    
    public final e a(a parama)
    {
      this.UPR = parama;
      return this;
    }
    
    public final void arM(int paramInt)
    {
      AppMethodBeat.i(190366);
      super.begin();
      hpZ();
      a.a.log(4, "MicroMsg.recovery.signalHandler", "#begin");
      this.mFrom = paramInt;
      if (this.UPJ > 0L) {
        this.UPC = (this.UPG - this.UPJ);
      }
      long l1 = this.UPG - this.UPI.UPa;
      a.a.log(4, "MicroMsg.recovery.signalHandler", "recovery interval = ".concat(String.valueOf(l1)));
      long l2 = this.UOX.UPq;
      if ((l2 > 0L) && (l1 < l2))
      {
        a.a.log(4, "MicroMsg.recovery.signalHandler", "too fast, skip and do nothing, min = ".concat(String.valueOf(l2)));
        AppMethodBeat.o(190366);
        return;
      }
      if ((this.UPF instanceof k.d)) {
        ((k.d)this.UPF).hqP();
      }
      if ((!TextUtils.isEmpty(this.UPI.UPb)) && (!this.UPI.UPb.equals(this.mVersionName)))
      {
        a.a.log(4, "MicroMsg.recovery.signalHandler", "version code mismatch, skip");
        hqL();
      }
      if (l1 < this.UOX.UPo)
      {
        a.a.log(4, "MicroMsg.recovery.signalHandler", "within interval, inc");
        hqK();
      }
      for (;;)
      {
        paramInt = this.UPH.UPd.UPf;
        a.a.log(4, "MicroMsg.recovery.signalHandler", "recovery crashCount = ".concat(String.valueOf(paramInt)));
        if (paramInt < this.UOX.UPm) {
          break label403;
        }
        if (hqJ()) {
          break;
        }
        a.a.log(5, "MicroMsg.recovery.signalHandler", "launch recovery fail");
        EB(true);
        AppMethodBeat.o(190366);
        return;
        l2 = this.UOX.UPp;
        if ((l1 < l2) && (this.UPR != null))
        {
          a.a.log(4, "MicroMsg.recovery.signalHandler", "within signal interval");
          paramInt = aU(l1, l2);
          if (this.UPR.arO(paramInt))
          {
            a.a.log(4, "MicroMsg.recovery.signalHandler", "acc meet, inc");
            hqK();
          }
          this.UPR.arg();
        }
        else
        {
          a.a.log(4, "MicroMsg.recovery.signalHandler", "over signal interval, clear point");
          hqL();
          hqK();
        }
      }
      if (paramInt < this.UOX.UPn) {
        arK(1);
      }
      for (;;)
      {
        EB(true);
        onTerminate();
        AppMethodBeat.o(190366);
        return;
        arK(2);
        hqL();
      }
      label403:
      EB(true);
      hqN();
      AppMethodBeat.o(190366);
    }
    
    @SuppressLint({"MissingSuperCall"})
    public final void begin()
    {
      AppMethodBeat.i(190351);
      arM(2);
      AppMethodBeat.o(190351);
    }
    
    public final void finish()
    {
      AppMethodBeat.i(190372);
      a.a.log(4, "MicroMsg.recovery.signalHandler", "#finish");
      AppMethodBeat.o(190372);
    }
    
    protected final boolean hqJ()
    {
      AppMethodBeat.i(190380);
      boolean bool = super.hqJ();
      if (bool)
      {
        j localj = j.jT(this.mContext);
        localj.UPA = false;
        localj.UPf = this.UPH.UPd.UPf;
        localj.UPw = true;
        localj.mFrom = this.mFrom;
        localj.UPC = Math.max(this.UPC, 0L);
        localj.arg();
      }
      AppMethodBeat.o(190380);
      return bool;
    }
    
    static final class a
    {
      int UPS;
      h UPs;
      final String mName;
      
      private a(String paramString)
      {
        this.mName = paramString;
      }
      
      private a arN(int paramInt)
      {
        this.UPS += paramInt;
        return this;
      }
      
      public static a cE(Context paramContext, String paramString)
      {
        AppMethodBeat.i(190332);
        paramContext = new a(paramString).jU(paramContext);
        AppMethodBeat.o(190332);
        return paramContext;
      }
      
      private boolean hqQ()
      {
        boolean bool = false;
        if (this.UPS >= 100)
        {
          this.UPS = 0;
          bool = true;
        }
        return bool;
      }
      
      private a jU(Context paramContext)
      {
        AppMethodBeat.i(190337);
        this.UPs = new h.b(paramContext, this.mName).hqk();
        this.UPS = this.UPs.getInt("acc_total", 0);
        AppMethodBeat.o(190337);
        return this;
      }
      
      public final boolean arO(int paramInt)
      {
        AppMethodBeat.i(190342);
        boolean bool = arN(paramInt).hqQ();
        AppMethodBeat.o(190342);
        return bool;
      }
      
      public final void arg()
      {
        AppMethodBeat.i(190343);
        this.UPs.hu("acc_total", this.UPS).hqg();
        AppMethodBeat.o(190343);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.recoveryv2.k
 * JD-Core Version:    0.7.0.1
 */
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

public abstract interface j
{
  public abstract j a(int paramInt, d paramd);
  
  public abstract j a(b paramb);
  
  public abstract void begin();
  
  public abstract void finish();
  
  public static abstract class a
    implements j
  {
    protected h HTO;
    protected RecoveryCrash HUA;
    protected RecoveryCrash HUB;
    protected final Handler HUv;
    protected final AtomicReference<b> HUw;
    protected final SparseArray<List<d>> HUx;
    protected a HUy;
    protected long HUz;
    protected final Context mContext;
    protected final String mVersionName;
    
    public a(Context paramContext)
    {
      this(paramContext, (byte)0);
    }
    
    private a(Context paramContext, byte paramByte)
    {
      this.mContext = paramContext;
      this.HUv = new Handler(Looper.getMainLooper());
      this.mVersionName = l.hX(this.mContext);
      this.HTO = null;
      this.HUw = new AtomicReference(new b.c().a(null));
      this.HUx = new SparseArray(2);
      this.HUx.put(1, new ArrayList());
      this.HUx.put(2, new ArrayList());
      this.HUB = RecoveryCrash.hK(this.mContext);
    }
    
    public a(a parama)
    {
      this.HUy = parama;
      this.mContext = parama.mContext;
      this.HUv = parama.HUv;
      this.mVersionName = parama.mVersionName;
      this.HUB = parama.HUB;
      this.HTO = parama.HTO;
      this.HUw = parama.HUw;
      this.HUx = parama.HUx;
    }
    
    protected final void ZX(int paramInt)
    {
      a.a.log(4, "MicroMsg.recovery.trigger", "recovery event, level = ".concat(String.valueOf(paramInt)));
      Iterator localIterator = ((List)this.HUx.get(paramInt)).iterator();
      while (localIterator.hasNext())
      {
        d locald = (d)localIterator.next();
        try
        {
          locald.ZV(paramInt);
        }
        catch (Throwable localThrowable)
        {
          a.w("MicroMsg.recovery.trigger", "recovery event error", localThrowable);
        }
      }
    }
    
    public void begin()
    {
      this.HUz = System.currentTimeMillis();
    }
    
    protected final void fgY()
    {
      if (this.HTO == null)
      {
        this.HTO = h.hN(this.mContext);
        ((b)this.HUw.get()).a(this.HTO);
      }
      if (this.HUB == null) {
        this.HUB = RecoveryCrash.hK(this.mContext);
      }
      this.HUB.fgY();
      if (this.HUA == null)
      {
        Object localObject = this.HUB;
        Context localContext = ((RecoveryCrash)localObject).mContext;
        long l = ((RecoveryCrash)localObject).HTR;
        String str = ((RecoveryCrash)localObject).HTS;
        g localg = ((RecoveryCrash)localObject).HTT;
        localObject = ((RecoveryCrash)localObject).HTU;
        this.HUA = new RecoveryCrash(localContext, l, str, localg, new c(((c)localObject).HTW, ((c)localObject).HTT));
      }
    }
    
    protected boolean fhm()
    {
      a.a.log(4, "MicroMsg.recovery.trigger", "onLaunchRecovery");
      try
      {
        ((b)this.HUw.get()).a(this.mContext, this.HUA);
        return true;
      }
      catch (Throwable localThrowable)
      {
        a.w("MicroMsg.recovery.trigger", "on launch recovery action error, mission aborted", localThrowable);
      }
      return false;
    }
    
    protected final void fhn()
    {
      RecoveryCrash localRecoveryCrash = this.HUA;
      c localc = localRecoveryCrash.HTU;
      localc.HTW += 1;
      localRecoveryCrash.HTS = this.mVersionName;
      localRecoveryCrash.HTR = this.HUz;
    }
    
    protected final void fho()
    {
      this.HUA.fgZ();
    }
    
    protected final void onTerminate()
    {
      a.a.log(4, "MicroMsg.recovery.trigger", "#onTerminate");
      try
      {
        ((b)this.HUw.get()).b(this.mContext, this.HUA);
        return;
      }
      catch (Throwable localThrowable) {}
    }
    
    protected final void wm(boolean paramBoolean)
    {
      if (paramBoolean)
      {
        this.HUA.save();
        return;
      }
      RecoveryCrash localRecoveryCrash = this.HUA;
      c localc = localRecoveryCrash.HTU;
      localc.HTT.ge("crash_count", localc.HTW).fhd();
      localRecoveryCrash.HTT.lF("crash_version", localRecoveryCrash.HTS).bR("crash_time", localRecoveryCrash.HTR).fhd();
    }
  }
  
  public static final class b
    extends j.a
  {
    final long HUC;
    j.d HUD;
    j.e HUE;
    
    public b(Context paramContext)
    {
      super();
      AppMethodBeat.i(207043);
      this.HUC = System.currentTimeMillis();
      AppMethodBeat.o(207043);
    }
    
    private j.e fhp()
    {
      AppMethodBeat.i(207046);
      if (this.HUD == null) {}
      for (Object localObject = this;; localObject = this.HUD)
      {
        localObject = new j.e((j.a)localObject);
        j.e.a locala = j.e.a.bZ(this.mContext, "signal_acc");
        localObject = ((j.e)localObject).CN(this.HUC).a(locala);
        AppMethodBeat.o(207046);
        return localObject;
      }
    }
    
    public final void ZY(int paramInt)
    {
      AppMethodBeat.i(207045);
      try
      {
        if (this.HUE == null) {
          this.HUE = fhp();
        }
        this.HUE.ZZ(paramInt);
        return;
      }
      finally
      {
        AppMethodBeat.o(207045);
      }
    }
    
    public final void begin()
    {
      AppMethodBeat.i(207044);
      super.begin();
      try
      {
        if ((this.HUD == null) && (this.HUE == null))
        {
          this.HUD = new j.c(this)
          {
            public final void finish()
            {
              AppMethodBeat.i(207042);
              a.a.log(4, "MicroMsg.recovery.combination", "safePoint finish, switch to signal handler");
              if (j.b.this.HUE == null) {
                j.b.this.HUE = j.b.a(j.b.this);
              }
              super.finish();
              AppMethodBeat.o(207042);
            }
          };
          if (this.HUD != null) {
            this.HUD.begin();
          }
          return;
        }
        if (this.HUE == null) {
          this.HUE = fhp();
        }
        if (this.HUE != null) {
          this.HUE.begin();
        }
        return;
      }
      finally
      {
        AppMethodBeat.o(207044);
      }
    }
    
    public final void finish()
    {
      AppMethodBeat.i(207047);
      try
      {
        if (this.HUD != null) {
          this.HUD.finish();
        }
        return;
      }
      finally
      {
        AppMethodBeat.o(207047);
      }
    }
  }
  
  public static class c
    extends j.d
  {
    public c(j.a parama)
    {
      super();
    }
    
    @SuppressLint({"MissingSuperCall"})
    public final void begin()
    {
      AppMethodBeat.i(207050);
      int i = this.HUB.HTU.HTW;
      if (i <= 0)
      {
        a.a.log(4, "MicroMsg.recovery.safePointLazy", "no need check, crash count = ".concat(String.valueOf(i)));
        this.HUH.set(true);
        fhq();
        Callable local1 = new Callable() {};
        Executors.newCachedThreadPool().submit(local1);
        AppMethodBeat.o(207050);
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
      AppMethodBeat.o(207050);
    }
  }
  
  public static class d
    extends j.a
  {
    protected final AtomicBoolean HUH;
    protected final AtomicBoolean HUI;
    
    public d(j.a parama)
    {
      super();
      AppMethodBeat.i(207052);
      this.HUH = new AtomicBoolean();
      this.HUI = new AtomicBoolean();
      AppMethodBeat.o(207052);
    }
    
    public void begin()
    {
      AppMethodBeat.i(207053);
      super.begin();
      fgY();
      long l1 = this.HUz - this.HUB.HTR;
      a.a.log(4, "MicroMsg.recovery.safePoint", "recovery interval = ".concat(String.valueOf(l1)));
      long l2 = this.HTO.HUi;
      if ((l2 > 0L) && (l1 < l2))
      {
        a.a.log(4, "MicroMsg.recovery.safePoint", "too fast, skip and do nothing, min = ".concat(String.valueOf(l2)));
        AppMethodBeat.o(207053);
        return;
      }
      this.HUH.set(true);
      if ((!TextUtils.isEmpty(this.HUB.HTS)) && (!this.HUB.HTS.equals(this.mVersionName)))
      {
        a.a.log(4, "MicroMsg.recovery.safePoint", "version code mismatch, skip");
        fho();
      }
      if (l1 >= this.HTO.HUg)
      {
        a.a.log(4, "MicroMsg.recovery.safePoint", "over interval, skip");
        fho();
      }
      int i = this.HUA.HTU.HTW;
      a.a.log(4, "MicroMsg.recovery.safePoint", "recovery crashCount = ".concat(String.valueOf(i)));
      if (i >= this.HTO.HUe)
      {
        if (!fhm())
        {
          a.a.log(5, "MicroMsg.recovery.safePoint", "launch recovery fail");
          wm(true);
          AppMethodBeat.o(207053);
          return;
        }
        if (i < this.HTO.HUf)
        {
          ZX(1);
          fhn();
        }
        for (;;)
        {
          wm(true);
          onTerminate();
          AppMethodBeat.o(207053);
          return;
          ZX(2);
          fho();
        }
      }
      fhq();
      fhn();
      wm(false);
      fhr();
      AppMethodBeat.o(207053);
    }
    
    protected final boolean fhm()
    {
      AppMethodBeat.i(207055);
      boolean bool = super.fhm();
      if (bool)
      {
        i locali = i.hR(this.mContext);
        locali.HUs = false;
        locali.HTW = this.HUA.HTU.HTW;
        locali.HUo = true;
        locali.mFrom = 1;
        locali.fhl();
      }
      AppMethodBeat.o(207055);
      return bool;
    }
    
    protected final void fhq()
    {
      AppMethodBeat.i(207056);
      a.a.log(4, "MicroMsg.recovery.safePoint", "onLaunchNormal");
      if ((this.HUA != null) && (this.HUA.HTU.HTW > 0))
      {
        i locali = i.hR(this.mContext);
        locali.HUs = false;
        locali.HTW = this.HUA.HTU.HTW;
        locali.HUo = false;
        locali.mFrom = 1;
        locali.fhl();
      }
      AppMethodBeat.o(207056);
    }
    
    protected final void fhr()
    {
      AppMethodBeat.i(207057);
      this.HUv.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(207051);
          if (j.d.this.HUI.get())
          {
            a.a.log(4, "MicroMsg.recovery.safePoint", "auto clear task has been canceled, skip");
            AppMethodBeat.o(207051);
            return;
          }
          a.a.log(4, "MicroMsg.recovery.safePoint", "auto clear point");
          j.d.this.finish();
          AppMethodBeat.o(207051);
        }
      }, this.HTO.HUj);
      AppMethodBeat.o(207057);
    }
    
    protected final void fhs()
    {
      AppMethodBeat.i(207058);
      this.HUI.set(true);
      AppMethodBeat.o(207058);
    }
    
    public void finish()
    {
      AppMethodBeat.i(207054);
      a.a.log(4, "MicroMsg.recovery.safePoint", "#finish");
      if (this.HUH.get())
      {
        a.a.log(4, "MicroMsg.recovery.safePoint", "clear crash point");
        fgY();
        fho();
        wm(true);
      }
      AppMethodBeat.o(207054);
    }
  }
  
  public static final class e
    extends j.a
  {
    protected long HUC = 0L;
    protected a HUK;
    protected long HUu = 0L;
    protected int mFrom = 2;
    
    public e(Context paramContext)
    {
      super();
    }
    
    public e(j.a parama)
    {
      super();
    }
    
    private static int ax(long paramLong1, long paramLong2)
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
    
    private void fhq()
    {
      AppMethodBeat.i(207067);
      a.a.log(4, "MicroMsg.recovery.signalHandler", "onLaunchNormal");
      if (this.HUA.HTU.HTW > 0)
      {
        i locali = i.hR(this.mContext);
        locali.HUs = false;
        locali.HTW = this.HUA.HTU.HTW;
        locali.HUo = false;
        locali.mFrom = this.mFrom;
        locali.HUu = Math.max(this.HUu, 0L);
        locali.save();
      }
      AppMethodBeat.o(207067);
    }
    
    public final e CN(long paramLong)
    {
      this.HUC = paramLong;
      return this;
    }
    
    public final void ZZ(int paramInt)
    {
      AppMethodBeat.i(207064);
      super.begin();
      fgY();
      a.a.log(4, "MicroMsg.recovery.signalHandler", "#begin");
      this.mFrom = paramInt;
      if (this.HUC > 0L) {
        this.HUu = (this.HUz - this.HUC);
      }
      long l1 = this.HUz - this.HUB.HTR;
      a.a.log(4, "MicroMsg.recovery.signalHandler", "recovery interval = ".concat(String.valueOf(l1)));
      long l2 = this.HTO.HUi;
      if ((l2 > 0L) && (l1 < l2))
      {
        a.a.log(4, "MicroMsg.recovery.signalHandler", "too fast, skip and do nothing, min = ".concat(String.valueOf(l2)));
        AppMethodBeat.o(207064);
        return;
      }
      if ((this.HUy instanceof j.d)) {
        ((j.d)this.HUy).fhs();
      }
      if ((!TextUtils.isEmpty(this.HUB.HTS)) && (!this.HUB.HTS.equals(this.mVersionName)))
      {
        a.a.log(4, "MicroMsg.recovery.signalHandler", "version code mismatch, skip");
        fho();
      }
      if (l1 < this.HTO.HUg)
      {
        a.a.log(4, "MicroMsg.recovery.signalHandler", "within interval, inc");
        fhn();
      }
      for (;;)
      {
        paramInt = this.HUA.HTU.HTW;
        a.a.log(4, "MicroMsg.recovery.signalHandler", "recovery crashCount = ".concat(String.valueOf(paramInt)));
        if (paramInt < this.HTO.HUe) {
          break label403;
        }
        if (fhm()) {
          break;
        }
        a.a.log(5, "MicroMsg.recovery.signalHandler", "launch recovery fail");
        wm(true);
        AppMethodBeat.o(207064);
        return;
        l2 = this.HTO.HUh;
        if ((l1 < l2) && (this.HUK != null))
        {
          a.a.log(4, "MicroMsg.recovery.signalHandler", "within signal interval");
          paramInt = ax(l1, l2);
          if (this.HUK.aab(paramInt))
          {
            a.a.log(4, "MicroMsg.recovery.signalHandler", "acc meet, inc");
            fhn();
          }
          this.HUK.save();
        }
        else
        {
          a.a.log(4, "MicroMsg.recovery.signalHandler", "over signal interval, clear point");
          fho();
          fhn();
        }
      }
      if (paramInt < this.HTO.HUf) {
        ZX(1);
      }
      for (;;)
      {
        wm(true);
        onTerminate();
        AppMethodBeat.o(207064);
        return;
        ZX(2);
        fho();
      }
      label403:
      wm(true);
      fhq();
      AppMethodBeat.o(207064);
    }
    
    public final e a(a parama)
    {
      this.HUK = parama;
      return this;
    }
    
    @SuppressLint({"MissingSuperCall"})
    public final void begin()
    {
      AppMethodBeat.i(207063);
      ZZ(2);
      AppMethodBeat.o(207063);
    }
    
    protected final boolean fhm()
    {
      AppMethodBeat.i(207066);
      boolean bool = super.fhm();
      if (bool)
      {
        i locali = i.hR(this.mContext);
        locali.HUs = false;
        locali.HTW = this.HUA.HTU.HTW;
        locali.HUo = true;
        locali.mFrom = this.mFrom;
        locali.HUu = Math.max(this.HUu, 0L);
        locali.save();
      }
      AppMethodBeat.o(207066);
      return bool;
    }
    
    public final void finish()
    {
      AppMethodBeat.i(207065);
      a.a.log(4, "MicroMsg.recovery.signalHandler", "#finish");
      AppMethodBeat.o(207065);
    }
    
    static final class a
    {
      int HUL;
      g HUk;
      final String mName;
      
      private a(String paramString)
      {
        this.mName = paramString;
      }
      
      private a aaa(int paramInt)
      {
        this.HUL += paramInt;
        return this;
      }
      
      public static a bZ(Context paramContext, String paramString)
      {
        AppMethodBeat.i(207059);
        paramContext = new a(paramString).hS(paramContext);
        AppMethodBeat.o(207059);
        return paramContext;
      }
      
      private boolean fht()
      {
        boolean bool = false;
        if (this.HUL >= 100)
        {
          this.HUL = 0;
          bool = true;
        }
        return bool;
      }
      
      private a hS(Context paramContext)
      {
        AppMethodBeat.i(207060);
        this.HUk = new g.b(paramContext, this.mName).fhg();
        this.HUL = this.HUk.getInt("acc_total", 0);
        AppMethodBeat.o(207060);
        return this;
      }
      
      public final boolean aab(int paramInt)
      {
        AppMethodBeat.i(207061);
        boolean bool = aaa(paramInt).fht();
        AppMethodBeat.o(207061);
        return bool;
      }
      
      public final void save()
      {
        AppMethodBeat.i(207062);
        this.HUk.ge("acc_total", this.HUL).fhc();
        AppMethodBeat.o(207062);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.recoveryv2.j
 * JD-Core Version:    0.7.0.1
 */
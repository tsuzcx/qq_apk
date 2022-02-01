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
    protected h NBu;
    protected final AtomicReference<b> NCb;
    protected final SparseArray<List<d>> NCc;
    protected a NCd;
    protected long NCe;
    protected RecoveryCrash NCf;
    protected RecoveryCrash NCg;
    protected final Context mContext;
    protected final String mVersionName;
    protected final Handler sCt;
    
    public a(Context paramContext)
    {
      this(paramContext, (byte)0);
    }
    
    private a(Context paramContext, byte paramByte)
    {
      this.mContext = paramContext;
      this.sCt = new Handler(Looper.getMainLooper());
      this.mVersionName = l.iV(this.mContext);
      this.NBu = null;
      this.NCb = new AtomicReference(new b.c().a(null));
      this.NCc = new SparseArray(2);
      this.NCc.put(1, new ArrayList());
      this.NCc.put(2, new ArrayList());
      this.NCg = RecoveryCrash.iJ(this.mContext);
    }
    
    public a(a parama)
    {
      this.NCd = parama;
      this.mContext = parama.mContext;
      this.sCt = parama.sCt;
      this.mVersionName = parama.mVersionName;
      this.NCg = parama.NCg;
      this.NBu = parama.NBu;
      this.NCb = parama.NCb;
      this.NCc = parama.NCc;
    }
    
    protected final void Au(boolean paramBoolean)
    {
      if (paramBoolean)
      {
        this.NCf.save();
        return;
      }
      RecoveryCrash localRecoveryCrash = this.NCf;
      c localc = localRecoveryCrash.NBA;
      localc.NBz.gL("crash_count", localc.NBC).guG();
      localRecoveryCrash.NBz.mK("crash_version", localRecoveryCrash.NBy).bT("crash_time", localRecoveryCrash.NBx).guG();
    }
    
    protected final void ajs(int paramInt)
    {
      a.a.log(4, "MicroMsg.recovery.trigger", "recovery event, level = ".concat(String.valueOf(paramInt)));
      Iterator localIterator = ((List)this.NCc.get(paramInt)).iterator();
      while (localIterator.hasNext())
      {
        d locald = (d)localIterator.next();
        try
        {
          locald.ajq(paramInt);
        }
        catch (Throwable localThrowable)
        {
          a.w("MicroMsg.recovery.trigger", "recovery event error", localThrowable);
        }
      }
    }
    
    public void begin()
    {
      this.NCe = System.currentTimeMillis();
    }
    
    protected final void guB()
    {
      if (this.NBu == null)
      {
        this.NBu = h.iM(this.mContext);
        ((b)this.NCb.get()).a(this.NBu);
      }
      if (this.NCg == null) {
        this.NCg = RecoveryCrash.iJ(this.mContext);
      }
      this.NCg.guB();
      if (this.NCf == null)
      {
        Object localObject = this.NCg;
        Context localContext = ((RecoveryCrash)localObject).mContext;
        long l = ((RecoveryCrash)localObject).NBx;
        String str = ((RecoveryCrash)localObject).NBy;
        g localg = ((RecoveryCrash)localObject).NBz;
        localObject = ((RecoveryCrash)localObject).NBA;
        this.NCf = new RecoveryCrash(localContext, l, str, localg, new c(((c)localObject).NBC, ((c)localObject).NBz));
      }
    }
    
    protected boolean guP()
    {
      a.a.log(4, "MicroMsg.recovery.trigger", "onLaunchRecovery");
      try
      {
        ((b)this.NCb.get()).a(this.mContext, this.NCf);
        return true;
      }
      catch (Throwable localThrowable)
      {
        a.w("MicroMsg.recovery.trigger", "on launch recovery action error, mission aborted", localThrowable);
      }
      return false;
    }
    
    protected final void guQ()
    {
      RecoveryCrash localRecoveryCrash = this.NCf;
      c localc = localRecoveryCrash.NBA;
      localc.NBC += 1;
      localRecoveryCrash.NBy = this.mVersionName;
      localRecoveryCrash.NBx = this.NCe;
    }
    
    protected final void guR()
    {
      this.NCf.guC();
    }
    
    protected final void onTerminate()
    {
      a.a.log(4, "MicroMsg.recovery.trigger", "#onTerminate");
      try
      {
        ((b)this.NCb.get()).b(this.mContext, this.NCf);
        return;
      }
      catch (Throwable localThrowable) {}
    }
  }
  
  public static final class b
    extends j.a
  {
    final long NCh;
    j.d NCi;
    j.e NCj;
    
    public b(Context paramContext)
    {
      super();
      AppMethodBeat.i(193839);
      this.NCh = System.currentTimeMillis();
      AppMethodBeat.o(193839);
    }
    
    private j.e guS()
    {
      AppMethodBeat.i(193842);
      if (this.NCi == null) {}
      for (Object localObject = this;; localObject = this.NCi)
      {
        localObject = new j.e((j.a)localObject);
        j.e.a locala = j.e.a.cu(this.mContext, "signal_acc");
        localObject = ((j.e)localObject).MB(this.NCh).a(locala);
        AppMethodBeat.o(193842);
        return localObject;
      }
    }
    
    public final void ajt(int paramInt)
    {
      AppMethodBeat.i(193841);
      try
      {
        if (this.NCj == null) {
          this.NCj = guS();
        }
        this.NCj.aju(paramInt);
        return;
      }
      finally
      {
        AppMethodBeat.o(193841);
      }
    }
    
    public final void begin()
    {
      AppMethodBeat.i(193840);
      super.begin();
      try
      {
        if ((this.NCi == null) && (this.NCj == null))
        {
          this.NCi = new j.c(this)
          {
            public final void finish()
            {
              AppMethodBeat.i(193838);
              a.a.log(4, "MicroMsg.recovery.combination", "safePoint finish, switch to signal handler");
              if (j.b.this.NCj == null) {
                j.b.this.NCj = j.b.a(j.b.this);
              }
              super.finish();
              AppMethodBeat.o(193838);
            }
          };
          if (this.NCi != null) {
            this.NCi.begin();
          }
          return;
        }
        if (this.NCj == null) {
          this.NCj = guS();
        }
        if (this.NCj != null) {
          this.NCj.begin();
        }
        return;
      }
      finally
      {
        AppMethodBeat.o(193840);
      }
    }
    
    public final void finish()
    {
      AppMethodBeat.i(193843);
      try
      {
        if (this.NCi != null) {
          this.NCi.finish();
        }
        return;
      }
      finally
      {
        AppMethodBeat.o(193843);
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
      AppMethodBeat.i(193846);
      int i = this.NCg.NBA.NBC;
      if (i <= 0)
      {
        a.a.log(4, "MicroMsg.recovery.safePointLazy", "no need check, crash count = ".concat(String.valueOf(i)));
        this.NCm.set(true);
        guT();
        Callable local1 = new Callable() {};
        Executors.newCachedThreadPool().submit(local1);
        AppMethodBeat.o(193846);
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
      AppMethodBeat.o(193846);
    }
  }
  
  public static class d
    extends j.a
  {
    protected final AtomicBoolean NCm;
    protected final AtomicBoolean NCn;
    
    public d(j.a parama)
    {
      super();
      AppMethodBeat.i(193848);
      this.NCm = new AtomicBoolean();
      this.NCn = new AtomicBoolean();
      AppMethodBeat.o(193848);
    }
    
    public void begin()
    {
      AppMethodBeat.i(193849);
      super.begin();
      guB();
      long l1 = this.NCe - this.NCg.NBx;
      a.a.log(4, "MicroMsg.recovery.safePoint", "recovery interval = ".concat(String.valueOf(l1)));
      long l2 = this.NBu.NBO;
      if ((l2 > 0L) && (l1 < l2))
      {
        a.a.log(4, "MicroMsg.recovery.safePoint", "too fast, skip and do nothing, min = ".concat(String.valueOf(l2)));
        AppMethodBeat.o(193849);
        return;
      }
      this.NCm.set(true);
      if ((!TextUtils.isEmpty(this.NCg.NBy)) && (!this.NCg.NBy.equals(this.mVersionName)))
      {
        a.a.log(4, "MicroMsg.recovery.safePoint", "version code mismatch, skip");
        guR();
      }
      if (l1 >= this.NBu.NBM)
      {
        a.a.log(4, "MicroMsg.recovery.safePoint", "over interval, skip");
        guR();
      }
      int i = this.NCf.NBA.NBC;
      a.a.log(4, "MicroMsg.recovery.safePoint", "recovery crashCount = ".concat(String.valueOf(i)));
      if (i >= this.NBu.NBK)
      {
        if (!guP())
        {
          a.a.log(5, "MicroMsg.recovery.safePoint", "launch recovery fail");
          Au(true);
          AppMethodBeat.o(193849);
          return;
        }
        if (i < this.NBu.NBL)
        {
          ajs(1);
          guQ();
        }
        for (;;)
        {
          Au(true);
          onTerminate();
          AppMethodBeat.o(193849);
          return;
          ajs(2);
          guR();
        }
      }
      guT();
      guQ();
      Au(false);
      guU();
      AppMethodBeat.o(193849);
    }
    
    public void finish()
    {
      AppMethodBeat.i(193850);
      a.a.log(4, "MicroMsg.recovery.safePoint", "#finish");
      if (this.NCm.get())
      {
        a.a.log(4, "MicroMsg.recovery.safePoint", "clear crash point");
        guB();
        guR();
        Au(true);
      }
      AppMethodBeat.o(193850);
    }
    
    protected final boolean guP()
    {
      AppMethodBeat.i(193851);
      boolean bool = super.guP();
      if (bool)
      {
        i locali = i.iQ(this.mContext);
        locali.NBY = false;
        locali.NBC = this.NCf.NBA.NBC;
        locali.NBU = true;
        locali.mFrom = 1;
        locali.guO();
      }
      AppMethodBeat.o(193851);
      return bool;
    }
    
    protected final void guT()
    {
      AppMethodBeat.i(193852);
      a.a.log(4, "MicroMsg.recovery.safePoint", "onLaunchNormal");
      if ((this.NCf != null) && (this.NCf.NBA.NBC > 0))
      {
        i locali = i.iQ(this.mContext);
        locali.NBY = false;
        locali.NBC = this.NCf.NBA.NBC;
        locali.NBU = false;
        locali.mFrom = 1;
        locali.guO();
      }
      AppMethodBeat.o(193852);
    }
    
    protected final void guU()
    {
      AppMethodBeat.i(193853);
      this.sCt.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(193847);
          if (j.d.this.NCn.get())
          {
            a.a.log(4, "MicroMsg.recovery.safePoint", "auto clear task has been canceled, skip");
            AppMethodBeat.o(193847);
            return;
          }
          a.a.log(4, "MicroMsg.recovery.safePoint", "auto clear point");
          j.d.this.finish();
          AppMethodBeat.o(193847);
        }
      }, this.NBu.NBP);
      AppMethodBeat.o(193853);
    }
    
    protected final void guV()
    {
      AppMethodBeat.i(193854);
      this.NCn.set(true);
      AppMethodBeat.o(193854);
    }
  }
  
  public static final class e
    extends j.a
  {
    protected long NCa = 0L;
    protected long NCh = 0L;
    protected a NCp;
    protected int mFrom = 2;
    
    public e(Context paramContext)
    {
      super();
    }
    
    public e(j.a parama)
    {
      super();
    }
    
    private static int aD(long paramLong1, long paramLong2)
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
    
    private void guT()
    {
      AppMethodBeat.i(193863);
      a.a.log(4, "MicroMsg.recovery.signalHandler", "onLaunchNormal");
      if (this.NCf.NBA.NBC > 0)
      {
        i locali = i.iQ(this.mContext);
        locali.NBY = false;
        locali.NBC = this.NCf.NBA.NBC;
        locali.NBU = false;
        locali.mFrom = this.mFrom;
        locali.NCa = Math.max(this.NCa, 0L);
        locali.save();
      }
      AppMethodBeat.o(193863);
    }
    
    public final e MB(long paramLong)
    {
      this.NCh = paramLong;
      return this;
    }
    
    public final e a(a parama)
    {
      this.NCp = parama;
      return this;
    }
    
    public final void aju(int paramInt)
    {
      AppMethodBeat.i(193860);
      super.begin();
      guB();
      a.a.log(4, "MicroMsg.recovery.signalHandler", "#begin");
      this.mFrom = paramInt;
      if (this.NCh > 0L) {
        this.NCa = (this.NCe - this.NCh);
      }
      long l1 = this.NCe - this.NCg.NBx;
      a.a.log(4, "MicroMsg.recovery.signalHandler", "recovery interval = ".concat(String.valueOf(l1)));
      long l2 = this.NBu.NBO;
      if ((l2 > 0L) && (l1 < l2))
      {
        a.a.log(4, "MicroMsg.recovery.signalHandler", "too fast, skip and do nothing, min = ".concat(String.valueOf(l2)));
        AppMethodBeat.o(193860);
        return;
      }
      if ((this.NCd instanceof j.d)) {
        ((j.d)this.NCd).guV();
      }
      if ((!TextUtils.isEmpty(this.NCg.NBy)) && (!this.NCg.NBy.equals(this.mVersionName)))
      {
        a.a.log(4, "MicroMsg.recovery.signalHandler", "version code mismatch, skip");
        guR();
      }
      if (l1 < this.NBu.NBM)
      {
        a.a.log(4, "MicroMsg.recovery.signalHandler", "within interval, inc");
        guQ();
      }
      for (;;)
      {
        paramInt = this.NCf.NBA.NBC;
        a.a.log(4, "MicroMsg.recovery.signalHandler", "recovery crashCount = ".concat(String.valueOf(paramInt)));
        if (paramInt < this.NBu.NBK) {
          break label403;
        }
        if (guP()) {
          break;
        }
        a.a.log(5, "MicroMsg.recovery.signalHandler", "launch recovery fail");
        Au(true);
        AppMethodBeat.o(193860);
        return;
        l2 = this.NBu.NBN;
        if ((l1 < l2) && (this.NCp != null))
        {
          a.a.log(4, "MicroMsg.recovery.signalHandler", "within signal interval");
          paramInt = aD(l1, l2);
          if (this.NCp.ajw(paramInt))
          {
            a.a.log(4, "MicroMsg.recovery.signalHandler", "acc meet, inc");
            guQ();
          }
          this.NCp.save();
        }
        else
        {
          a.a.log(4, "MicroMsg.recovery.signalHandler", "over signal interval, clear point");
          guR();
          guQ();
        }
      }
      if (paramInt < this.NBu.NBL) {
        ajs(1);
      }
      for (;;)
      {
        Au(true);
        onTerminate();
        AppMethodBeat.o(193860);
        return;
        ajs(2);
        guR();
      }
      label403:
      Au(true);
      guT();
      AppMethodBeat.o(193860);
    }
    
    @SuppressLint({"MissingSuperCall"})
    public final void begin()
    {
      AppMethodBeat.i(193859);
      aju(2);
      AppMethodBeat.o(193859);
    }
    
    public final void finish()
    {
      AppMethodBeat.i(193861);
      a.a.log(4, "MicroMsg.recovery.signalHandler", "#finish");
      AppMethodBeat.o(193861);
    }
    
    protected final boolean guP()
    {
      AppMethodBeat.i(193862);
      boolean bool = super.guP();
      if (bool)
      {
        i locali = i.iQ(this.mContext);
        locali.NBY = false;
        locali.NBC = this.NCf.NBA.NBC;
        locali.NBU = true;
        locali.mFrom = this.mFrom;
        locali.NCa = Math.max(this.NCa, 0L);
        locali.save();
      }
      AppMethodBeat.o(193862);
      return bool;
    }
    
    static final class a
    {
      g NBQ;
      int NCq;
      final String mName;
      
      private a(String paramString)
      {
        this.mName = paramString;
      }
      
      private a ajv(int paramInt)
      {
        this.NCq += paramInt;
        return this;
      }
      
      public static a cu(Context paramContext, String paramString)
      {
        AppMethodBeat.i(193855);
        paramContext = new a(paramString).iR(paramContext);
        AppMethodBeat.o(193855);
        return paramContext;
      }
      
      private boolean guW()
      {
        boolean bool = false;
        if (this.NCq >= 100)
        {
          this.NCq = 0;
          bool = true;
        }
        return bool;
      }
      
      private a iR(Context paramContext)
      {
        AppMethodBeat.i(193856);
        this.NBQ = new g.b(paramContext, this.mName).guJ();
        this.NCq = this.NBQ.getInt("acc_total", 0);
        AppMethodBeat.o(193856);
        return this;
      }
      
      public final boolean ajw(int paramInt)
      {
        AppMethodBeat.i(193857);
        boolean bool = ajv(paramInt).guW();
        AppMethodBeat.o(193857);
        return bool;
      }
      
      public final void save()
      {
        AppMethodBeat.i(193858);
        this.NBQ.gL("acc_total", this.NCq).guF();
        AppMethodBeat.o(193858);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.recoveryv2.j
 * JD-Core Version:    0.7.0.1
 */
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
    protected h InW;
    protected final Handler IoD;
    protected final AtomicReference<b> IoE;
    protected final SparseArray<List<d>> IoF;
    protected a IoG;
    protected long IoH;
    protected RecoveryCrash IoI;
    protected RecoveryCrash IoJ;
    protected final Context mContext;
    protected final String mVersionName;
    
    public a(Context paramContext)
    {
      this(paramContext, (byte)0);
    }
    
    private a(Context paramContext, byte paramByte)
    {
      this.mContext = paramContext;
      this.IoD = new Handler(Looper.getMainLooper());
      this.mVersionName = l.ic(this.mContext);
      this.InW = null;
      this.IoE = new AtomicReference(new b.c().a(null));
      this.IoF = new SparseArray(2);
      this.IoF.put(1, new ArrayList());
      this.IoF.put(2, new ArrayList());
      this.IoJ = RecoveryCrash.hQ(this.mContext);
    }
    
    public a(a parama)
    {
      this.IoG = parama;
      this.mContext = parama.mContext;
      this.IoD = parama.IoD;
      this.mVersionName = parama.mVersionName;
      this.IoJ = parama.IoJ;
      this.InW = parama.InW;
      this.IoE = parama.IoE;
      this.IoF = parama.IoF;
    }
    
    protected final void aaD(int paramInt)
    {
      a.a.log(4, "MicroMsg.recovery.trigger", "recovery event, level = ".concat(String.valueOf(paramInt)));
      Iterator localIterator = ((List)this.IoF.get(paramInt)).iterator();
      while (localIterator.hasNext())
      {
        d locald = (d)localIterator.next();
        try
        {
          locald.aaB(paramInt);
        }
        catch (Throwable localThrowable)
        {
          a.w("MicroMsg.recovery.trigger", "recovery event error", localThrowable);
        }
      }
    }
    
    public void begin()
    {
      this.IoH = System.currentTimeMillis();
    }
    
    protected final void fkQ()
    {
      if (this.InW == null)
      {
        this.InW = h.hT(this.mContext);
        ((b)this.IoE.get()).a(this.InW);
      }
      if (this.IoJ == null) {
        this.IoJ = RecoveryCrash.hQ(this.mContext);
      }
      this.IoJ.fkQ();
      if (this.IoI == null)
      {
        Object localObject = this.IoJ;
        Context localContext = ((RecoveryCrash)localObject).mContext;
        long l = ((RecoveryCrash)localObject).InZ;
        String str = ((RecoveryCrash)localObject).Ioa;
        g localg = ((RecoveryCrash)localObject).Iob;
        localObject = ((RecoveryCrash)localObject).Ioc;
        this.IoI = new RecoveryCrash(localContext, l, str, localg, new c(((c)localObject).Ioe, ((c)localObject).Iob));
      }
    }
    
    protected boolean fle()
    {
      a.a.log(4, "MicroMsg.recovery.trigger", "onLaunchRecovery");
      try
      {
        ((b)this.IoE.get()).a(this.mContext, this.IoI);
        return true;
      }
      catch (Throwable localThrowable)
      {
        a.w("MicroMsg.recovery.trigger", "on launch recovery action error, mission aborted", localThrowable);
      }
      return false;
    }
    
    protected final void flf()
    {
      RecoveryCrash localRecoveryCrash = this.IoI;
      c localc = localRecoveryCrash.Ioc;
      localc.Ioe += 1;
      localRecoveryCrash.Ioa = this.mVersionName;
      localRecoveryCrash.InZ = this.IoH;
    }
    
    protected final void flg()
    {
      this.IoI.fkR();
    }
    
    protected final void onTerminate()
    {
      a.a.log(4, "MicroMsg.recovery.trigger", "#onTerminate");
      try
      {
        ((b)this.IoE.get()).b(this.mContext, this.IoI);
        return;
      }
      catch (Throwable localThrowable) {}
    }
    
    protected final void wu(boolean paramBoolean)
    {
      if (paramBoolean)
      {
        this.IoI.save();
        return;
      }
      RecoveryCrash localRecoveryCrash = this.IoI;
      c localc = localRecoveryCrash.Ioc;
      localc.Iob.gn("crash_count", localc.Ioe).fkV();
      localRecoveryCrash.Iob.lM("crash_version", localRecoveryCrash.Ioa).bS("crash_time", localRecoveryCrash.InZ).fkV();
    }
  }
  
  public static final class b
    extends j.a
  {
    final long IoK;
    j.d IoL;
    j.e IoM;
    
    public b(Context paramContext)
    {
      super();
      AppMethodBeat.i(195351);
      this.IoK = System.currentTimeMillis();
      AppMethodBeat.o(195351);
    }
    
    private j.e flh()
    {
      AppMethodBeat.i(195354);
      if (this.IoL == null) {}
      for (Object localObject = this;; localObject = this.IoL)
      {
        localObject = new j.e((j.a)localObject);
        j.e.a locala = j.e.a.ca(this.mContext, "signal_acc");
        localObject = ((j.e)localObject).Dl(this.IoK).a(locala);
        AppMethodBeat.o(195354);
        return localObject;
      }
    }
    
    public final void aaE(int paramInt)
    {
      AppMethodBeat.i(195353);
      try
      {
        if (this.IoM == null) {
          this.IoM = flh();
        }
        this.IoM.aaF(paramInt);
        return;
      }
      finally
      {
        AppMethodBeat.o(195353);
      }
    }
    
    public final void begin()
    {
      AppMethodBeat.i(195352);
      super.begin();
      try
      {
        if ((this.IoL == null) && (this.IoM == null))
        {
          this.IoL = new j.c(this)
          {
            public final void finish()
            {
              AppMethodBeat.i(195350);
              a.a.log(4, "MicroMsg.recovery.combination", "safePoint finish, switch to signal handler");
              if (j.b.this.IoM == null) {
                j.b.this.IoM = j.b.a(j.b.this);
              }
              super.finish();
              AppMethodBeat.o(195350);
            }
          };
          if (this.IoL != null) {
            this.IoL.begin();
          }
          return;
        }
        if (this.IoM == null) {
          this.IoM = flh();
        }
        if (this.IoM != null) {
          this.IoM.begin();
        }
        return;
      }
      finally
      {
        AppMethodBeat.o(195352);
      }
    }
    
    public final void finish()
    {
      AppMethodBeat.i(195355);
      try
      {
        if (this.IoL != null) {
          this.IoL.finish();
        }
        return;
      }
      finally
      {
        AppMethodBeat.o(195355);
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
      AppMethodBeat.i(195358);
      int i = this.IoJ.Ioc.Ioe;
      if (i <= 0)
      {
        a.a.log(4, "MicroMsg.recovery.safePointLazy", "no need check, crash count = ".concat(String.valueOf(i)));
        this.IoP.set(true);
        fli();
        Callable local1 = new Callable() {};
        Executors.newCachedThreadPool().submit(local1);
        AppMethodBeat.o(195358);
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
      AppMethodBeat.o(195358);
    }
  }
  
  public static class d
    extends j.a
  {
    protected final AtomicBoolean IoP;
    protected final AtomicBoolean IoQ;
    
    public d(j.a parama)
    {
      super();
      AppMethodBeat.i(195360);
      this.IoP = new AtomicBoolean();
      this.IoQ = new AtomicBoolean();
      AppMethodBeat.o(195360);
    }
    
    public void begin()
    {
      AppMethodBeat.i(195361);
      super.begin();
      fkQ();
      long l1 = this.IoH - this.IoJ.InZ;
      a.a.log(4, "MicroMsg.recovery.safePoint", "recovery interval = ".concat(String.valueOf(l1)));
      long l2 = this.InW.Ioq;
      if ((l2 > 0L) && (l1 < l2))
      {
        a.a.log(4, "MicroMsg.recovery.safePoint", "too fast, skip and do nothing, min = ".concat(String.valueOf(l2)));
        AppMethodBeat.o(195361);
        return;
      }
      this.IoP.set(true);
      if ((!TextUtils.isEmpty(this.IoJ.Ioa)) && (!this.IoJ.Ioa.equals(this.mVersionName)))
      {
        a.a.log(4, "MicroMsg.recovery.safePoint", "version code mismatch, skip");
        flg();
      }
      if (l1 >= this.InW.Ioo)
      {
        a.a.log(4, "MicroMsg.recovery.safePoint", "over interval, skip");
        flg();
      }
      int i = this.IoI.Ioc.Ioe;
      a.a.log(4, "MicroMsg.recovery.safePoint", "recovery crashCount = ".concat(String.valueOf(i)));
      if (i >= this.InW.Iom)
      {
        if (!fle())
        {
          a.a.log(5, "MicroMsg.recovery.safePoint", "launch recovery fail");
          wu(true);
          AppMethodBeat.o(195361);
          return;
        }
        if (i < this.InW.Ion)
        {
          aaD(1);
          flf();
        }
        for (;;)
        {
          wu(true);
          onTerminate();
          AppMethodBeat.o(195361);
          return;
          aaD(2);
          flg();
        }
      }
      fli();
      flf();
      wu(false);
      flj();
      AppMethodBeat.o(195361);
    }
    
    public void finish()
    {
      AppMethodBeat.i(195362);
      a.a.log(4, "MicroMsg.recovery.safePoint", "#finish");
      if (this.IoP.get())
      {
        a.a.log(4, "MicroMsg.recovery.safePoint", "clear crash point");
        fkQ();
        flg();
        wu(true);
      }
      AppMethodBeat.o(195362);
    }
    
    protected final boolean fle()
    {
      AppMethodBeat.i(195363);
      boolean bool = super.fle();
      if (bool)
      {
        i locali = i.hX(this.mContext);
        locali.IoA = false;
        locali.Ioe = this.IoI.Ioc.Ioe;
        locali.Iow = true;
        locali.mFrom = 1;
        locali.fld();
      }
      AppMethodBeat.o(195363);
      return bool;
    }
    
    protected final void fli()
    {
      AppMethodBeat.i(195364);
      a.a.log(4, "MicroMsg.recovery.safePoint", "onLaunchNormal");
      if ((this.IoI != null) && (this.IoI.Ioc.Ioe > 0))
      {
        i locali = i.hX(this.mContext);
        locali.IoA = false;
        locali.Ioe = this.IoI.Ioc.Ioe;
        locali.Iow = false;
        locali.mFrom = 1;
        locali.fld();
      }
      AppMethodBeat.o(195364);
    }
    
    protected final void flj()
    {
      AppMethodBeat.i(195365);
      this.IoD.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(195359);
          if (j.d.this.IoQ.get())
          {
            a.a.log(4, "MicroMsg.recovery.safePoint", "auto clear task has been canceled, skip");
            AppMethodBeat.o(195359);
            return;
          }
          a.a.log(4, "MicroMsg.recovery.safePoint", "auto clear point");
          j.d.this.finish();
          AppMethodBeat.o(195359);
        }
      }, this.InW.Ior);
      AppMethodBeat.o(195365);
    }
    
    protected final void flk()
    {
      AppMethodBeat.i(195366);
      this.IoQ.set(true);
      AppMethodBeat.o(195366);
    }
  }
  
  public static final class e
    extends j.a
  {
    protected long IoC = 0L;
    protected long IoK = 0L;
    protected a IoS;
    protected int mFrom = 2;
    
    public e(Context paramContext)
    {
      super();
    }
    
    public e(j.a parama)
    {
      super();
    }
    
    private static int aw(long paramLong1, long paramLong2)
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
    
    private void fli()
    {
      AppMethodBeat.i(195375);
      a.a.log(4, "MicroMsg.recovery.signalHandler", "onLaunchNormal");
      if (this.IoI.Ioc.Ioe > 0)
      {
        i locali = i.hX(this.mContext);
        locali.IoA = false;
        locali.Ioe = this.IoI.Ioc.Ioe;
        locali.Iow = false;
        locali.mFrom = this.mFrom;
        locali.IoC = Math.max(this.IoC, 0L);
        locali.save();
      }
      AppMethodBeat.o(195375);
    }
    
    public final e Dl(long paramLong)
    {
      this.IoK = paramLong;
      return this;
    }
    
    public final e a(a parama)
    {
      this.IoS = parama;
      return this;
    }
    
    public final void aaF(int paramInt)
    {
      AppMethodBeat.i(195372);
      super.begin();
      fkQ();
      a.a.log(4, "MicroMsg.recovery.signalHandler", "#begin");
      this.mFrom = paramInt;
      if (this.IoK > 0L) {
        this.IoC = (this.IoH - this.IoK);
      }
      long l1 = this.IoH - this.IoJ.InZ;
      a.a.log(4, "MicroMsg.recovery.signalHandler", "recovery interval = ".concat(String.valueOf(l1)));
      long l2 = this.InW.Ioq;
      if ((l2 > 0L) && (l1 < l2))
      {
        a.a.log(4, "MicroMsg.recovery.signalHandler", "too fast, skip and do nothing, min = ".concat(String.valueOf(l2)));
        AppMethodBeat.o(195372);
        return;
      }
      if ((this.IoG instanceof j.d)) {
        ((j.d)this.IoG).flk();
      }
      if ((!TextUtils.isEmpty(this.IoJ.Ioa)) && (!this.IoJ.Ioa.equals(this.mVersionName)))
      {
        a.a.log(4, "MicroMsg.recovery.signalHandler", "version code mismatch, skip");
        flg();
      }
      if (l1 < this.InW.Ioo)
      {
        a.a.log(4, "MicroMsg.recovery.signalHandler", "within interval, inc");
        flf();
      }
      for (;;)
      {
        paramInt = this.IoI.Ioc.Ioe;
        a.a.log(4, "MicroMsg.recovery.signalHandler", "recovery crashCount = ".concat(String.valueOf(paramInt)));
        if (paramInt < this.InW.Iom) {
          break label403;
        }
        if (fle()) {
          break;
        }
        a.a.log(5, "MicroMsg.recovery.signalHandler", "launch recovery fail");
        wu(true);
        AppMethodBeat.o(195372);
        return;
        l2 = this.InW.Iop;
        if ((l1 < l2) && (this.IoS != null))
        {
          a.a.log(4, "MicroMsg.recovery.signalHandler", "within signal interval");
          paramInt = aw(l1, l2);
          if (this.IoS.aaH(paramInt))
          {
            a.a.log(4, "MicroMsg.recovery.signalHandler", "acc meet, inc");
            flf();
          }
          this.IoS.save();
        }
        else
        {
          a.a.log(4, "MicroMsg.recovery.signalHandler", "over signal interval, clear point");
          flg();
          flf();
        }
      }
      if (paramInt < this.InW.Ion) {
        aaD(1);
      }
      for (;;)
      {
        wu(true);
        onTerminate();
        AppMethodBeat.o(195372);
        return;
        aaD(2);
        flg();
      }
      label403:
      wu(true);
      fli();
      AppMethodBeat.o(195372);
    }
    
    @SuppressLint({"MissingSuperCall"})
    public final void begin()
    {
      AppMethodBeat.i(195371);
      aaF(2);
      AppMethodBeat.o(195371);
    }
    
    public final void finish()
    {
      AppMethodBeat.i(195373);
      a.a.log(4, "MicroMsg.recovery.signalHandler", "#finish");
      AppMethodBeat.o(195373);
    }
    
    protected final boolean fle()
    {
      AppMethodBeat.i(195374);
      boolean bool = super.fle();
      if (bool)
      {
        i locali = i.hX(this.mContext);
        locali.IoA = false;
        locali.Ioe = this.IoI.Ioc.Ioe;
        locali.Iow = true;
        locali.mFrom = this.mFrom;
        locali.IoC = Math.max(this.IoC, 0L);
        locali.save();
      }
      AppMethodBeat.o(195374);
      return bool;
    }
    
    static final class a
    {
      int IoT;
      g Ios;
      final String mName;
      
      private a(String paramString)
      {
        this.mName = paramString;
      }
      
      private a aaG(int paramInt)
      {
        this.IoT += paramInt;
        return this;
      }
      
      public static a ca(Context paramContext, String paramString)
      {
        AppMethodBeat.i(195367);
        paramContext = new a(paramString).hY(paramContext);
        AppMethodBeat.o(195367);
        return paramContext;
      }
      
      private boolean fll()
      {
        boolean bool = false;
        if (this.IoT >= 100)
        {
          this.IoT = 0;
          bool = true;
        }
        return bool;
      }
      
      private a hY(Context paramContext)
      {
        AppMethodBeat.i(195368);
        this.Ios = new g.b(paramContext, this.mName).fkY();
        this.IoT = this.Ios.getInt("acc_total", 0);
        AppMethodBeat.o(195368);
        return this;
      }
      
      public final boolean aaH(int paramInt)
      {
        AppMethodBeat.i(195369);
        boolean bool = aaG(paramInt).fll();
        AppMethodBeat.o(195369);
        return bool;
      }
      
      public final void save()
      {
        AppMethodBeat.i(195370);
        this.Ios.gn("acc_total", this.IoT).fkU();
        AppMethodBeat.o(195370);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.recoveryv2.j
 * JD-Core Version:    0.7.0.1
 */
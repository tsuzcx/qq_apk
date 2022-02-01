package com.tencent.mm.recoveryv2;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public abstract interface j
{
  public abstract j a(int paramInt, c paramc);
  
  public abstract j a(a parama);
  
  public abstract void begin();
  
  public abstract void finish();
  
  public static abstract class a
    implements j
  {
    protected h acjN;
    protected RecoveryCrash ackA;
    protected final AtomicReference<a> ackv;
    protected final SparseArray<List<c>> ackw;
    protected a ackx;
    protected long acky;
    protected RecoveryCrash ackz;
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
      this.mVersionName = k.a.lY(this.mContext);
      this.acjN = null;
      this.ackv = new AtomicReference(new a.c().a(null));
      this.ackw = new SparseArray(2);
      this.ackw.put(1, new ArrayList());
      this.ackw.put(2, new ArrayList());
      this.ackA = RecoveryCrash.lK(this.mContext);
    }
    
    public a(a parama)
    {
      this.ackx = parama;
      this.mContext = parama.mContext;
      this.mUiHandler = parama.mUiHandler;
      this.mVersionName = parama.mVersionName;
      this.ackA = parama.ackA;
      this.acjN = parama.acjN;
      this.ackv = parama.ackv;
      this.ackw = parama.ackw;
    }
    
    protected final void Kl(boolean paramBoolean)
    {
      if (paramBoolean)
      {
        this.ackz.sz();
        return;
      }
      RecoveryCrash localRecoveryCrash = this.ackz;
      b localb = localRecoveryCrash.acjU;
      localb.acjT.iC("crash_count", localb.acjW).iQH();
      localRecoveryCrash.acjT.px("crash_version", localRecoveryCrash.acjS).cm("crash_time", localRecoveryCrash.acjR).iQH();
    }
    
    /* Error */
    protected final void axP(int paramInt)
    {
      // Byte code:
      //   0: iconst_4
      //   1: ldc 173
      //   3: ldc 175
      //   5: iload_1
      //   6: invokestatic 181	java/lang/String:valueOf	(I)Ljava/lang/String;
      //   9: invokevirtual 185	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   12: invokestatic 191	com/tencent/mm/recoveryv2/k$b$a:log	(ILjava/lang/String;Ljava/lang/String;)V
      //   15: aload_0
      //   16: getfield 82	com/tencent/mm/recoveryv2/j$a:ackw	Landroid/util/SparseArray;
      //   19: iload_1
      //   20: invokevirtual 157	android/util/SparseArray:get	(I)Ljava/lang/Object;
      //   23: checkcast 159	java/util/List
      //   26: invokeinterface 195 1 0
      //   31: astore_2
      //   32: aload_2
      //   33: invokeinterface 201 1 0
      //   38: ifeq +35 -> 73
      //   41: aload_2
      //   42: invokeinterface 205 1 0
      //   47: checkcast 207	com/tencent/mm/recoveryv2/c
      //   50: astore_3
      //   51: aload_3
      //   52: iload_1
      //   53: invokeinterface 210 2 0
      //   58: goto -26 -> 32
      //   61: astore_3
      //   62: ldc 173
      //   64: ldc 212
      //   66: aload_3
      //   67: invokestatic 218	com/tencent/mm/recoveryv2/k$b:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   70: goto -38 -> 32
      //   73: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	74	0	this	a
      //   0	74	1	paramInt	int
      //   31	11	2	localIterator	java.util.Iterator
      //   50	2	3	localc	c
      //   61	6	3	localThrowable	Throwable
      // Exception table:
      //   from	to	target	type
      //   51	58	61	finally
    }
    
    public void begin()
    {
      this.acky = System.currentTimeMillis();
    }
    
    protected final void iQB()
    {
      if (this.acjN == null)
      {
        this.acjN = h.lR(this.mContext);
        ((a)this.ackv.get()).a(this.acjN);
      }
      if (this.ackA == null) {
        this.ackA = RecoveryCrash.lK(this.mContext);
      }
      this.ackA.iQB();
      if (this.ackz == null) {
        this.ackz = this.ackA.iQC();
      }
    }
    
    public int iQQ()
    {
      return this.ackA.acjU.acjW;
    }
    
    protected boolean iQR()
    {
      k.b.a.log(4, "MicroMsg.recovery.trigger", "onLaunchRecovery");
      try
      {
        ((a)this.ackv.get()).a(this.mContext, this.ackz);
        return true;
      }
      finally
      {
        k.b.w("MicroMsg.recovery.trigger", "on launch recovery action error, mission aborted", localThrowable);
      }
      return false;
    }
    
    protected final void iQS()
    {
      RecoveryCrash localRecoveryCrash = this.ackz;
      b localb = localRecoveryCrash.acjU;
      localb.acjW += 1;
      localRecoveryCrash.acjS = this.mVersionName;
      localRecoveryCrash.acjR = this.acky;
    }
    
    protected final void iQT()
    {
      this.ackz.iQD();
    }
    
    protected final void iQU()
    {
      iQT();
      Context localContext = this.mContext;
      RecoveryCrash.lL(localContext).iQD().sz();
      RecoveryCrash.lM(localContext).iQD().sz();
    }
    
    protected final void onTerminate()
    {
      k.b.a.log(4, "MicroMsg.recovery.trigger", "#onTerminate");
      try
      {
        ((a)this.ackv.get()).b(this.mContext, this.ackz);
        return;
      }
      finally {}
    }
  }
  
  public static final class b
    extends j.a
  {
    final long ackB;
    j.d ackC;
    j.e ackD;
    
    public b(Context paramContext)
    {
      super();
      AppMethodBeat.i(237983);
      this.ackB = System.currentTimeMillis();
      AppMethodBeat.o(237983);
    }
    
    private j.e iQV()
    {
      AppMethodBeat.i(237991);
      if (this.ackC == null) {}
      for (Object localObject = this;; localObject = this.ackC)
      {
        localObject = new j.e((j.a)localObject);
        j.e.a locala = j.e.a.cP(this.mContext, "signal_acc");
        localObject = ((j.e)localObject).yv(this.ackB).a(locala);
        AppMethodBeat.o(237991);
        return localObject;
      }
    }
    
    public final void axQ(int paramInt)
    {
      AppMethodBeat.i(238021);
      try
      {
        if (this.ackD == null) {
          this.ackD = iQV();
        }
        this.ackD.axR(paramInt);
        return;
      }
      finally
      {
        AppMethodBeat.o(238021);
      }
    }
    
    public final void begin()
    {
      AppMethodBeat.i(238015);
      super.begin();
      try
      {
        if ((this.ackC == null) && (this.ackD == null))
        {
          this.ackC = new j.c(this)
          {
            public final void finish()
            {
              AppMethodBeat.i(238039);
              k.b.a.log(4, "MicroMsg.recovery.combination", "safePoint finish, switch to signal handler");
              if (j.b.this.ackD == null) {
                j.b.this.ackD = j.b.a(j.b.this);
              }
              super.finish();
              AppMethodBeat.o(238039);
            }
          };
          if (this.ackC != null) {
            this.ackC.begin();
          }
          return;
        }
        if (this.ackD == null) {
          this.ackD = iQV();
        }
        if (this.ackD != null) {
          this.ackD.begin();
        }
        return;
      }
      finally
      {
        AppMethodBeat.o(238015);
      }
    }
    
    public final void finish()
    {
      AppMethodBeat.i(238029);
      try
      {
        if (this.ackC != null) {
          this.ackC.finish();
        }
        return;
      }
      finally
      {
        AppMethodBeat.o(238029);
      }
    }
    
    public final int iQQ()
    {
      AppMethodBeat.i(238004);
      int i;
      if (this.ackD != null)
      {
        i = this.ackD.iQQ();
        AppMethodBeat.o(238004);
        return i;
      }
      if (this.ackC != null)
      {
        i = this.ackC.iQQ();
        AppMethodBeat.o(238004);
        return i;
      }
      AppMethodBeat.o(238004);
      return -1;
    }
  }
  
  public static class c
    extends j.d
  {
    public c(j.a parama)
    {
      super();
    }
    
    public final void begin()
    {
      AppMethodBeat.i(238001);
      this.acky = System.currentTimeMillis();
      int i = this.ackA.acjU.acjW;
      if (i <= 0)
      {
        k.b.a.log(4, "MicroMsg.recovery.safePointLazy", "no need check, crash count = ".concat(String.valueOf(i)));
        this.ackG.set(true);
        iQW();
        Callable local1 = new Callable() {};
        Executors.newCachedThreadPool().submit(local1);
        AppMethodBeat.o(238001);
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
      AppMethodBeat.o(238001);
    }
  }
  
  public static class d
    extends j.a
  {
    protected final AtomicBoolean ackG;
    protected final AtomicBoolean ackH;
    
    public d(j.a parama)
    {
      super();
      AppMethodBeat.i(238000);
      this.ackG = new AtomicBoolean();
      this.ackH = new AtomicBoolean();
      AppMethodBeat.o(238000);
    }
    
    public void begin()
    {
      AppMethodBeat.i(238023);
      super.begin();
      iQB();
      long l1 = this.acky - this.ackA.acjR;
      k.b.a.log(4, "MicroMsg.recovery.safePoint", "recovery interval = ".concat(String.valueOf(l1)));
      long l2 = this.acjN.ackh;
      if ((l2 > 0L) && (l1 < l2))
      {
        k.b.a.log(4, "MicroMsg.recovery.safePoint", "too fast, skip and do nothing, min = ".concat(String.valueOf(l2)));
        AppMethodBeat.o(238023);
        return;
      }
      this.ackG.set(true);
      if ((!TextUtils.isEmpty(this.ackA.acjS)) && (!this.ackA.acjS.equals(this.mVersionName)))
      {
        k.b.a.log(4, "MicroMsg.recovery.safePoint", "version code mismatch, skip");
        iQT();
      }
      if (l1 >= this.acjN.ackf)
      {
        k.b.a.log(4, "MicroMsg.recovery.safePoint", "over interval, skip");
        iQT();
      }
      int i = this.ackz.acjU.acjW;
      k.b.a.log(4, "MicroMsg.recovery.safePoint", "recovery crashCount = ".concat(String.valueOf(i)));
      if (i >= this.acjN.ackd)
      {
        if (!iQR())
        {
          k.b.a.log(5, "MicroMsg.recovery.safePoint", "launch recovery fail");
          Kl(true);
          AppMethodBeat.o(238023);
          return;
        }
        if (i < this.acjN.acke)
        {
          axP(1);
          iQS();
        }
        for (;;)
        {
          Kl(true);
          onTerminate();
          AppMethodBeat.o(238023);
          return;
          axP(2);
          iQU();
        }
      }
      iQW();
      iQS();
      Kl(false);
      iQX();
      AppMethodBeat.o(238023);
    }
    
    public void finish()
    {
      AppMethodBeat.i(238035);
      k.b.a.log(4, "MicroMsg.recovery.safePoint", "#finish");
      if (this.ackG.get())
      {
        k.b.a.log(4, "MicroMsg.recovery.safePoint", "clear crash point");
        iQB();
        iQT();
        Kl(true);
      }
      AppMethodBeat.o(238035);
    }
    
    protected final boolean iQR()
    {
      AppMethodBeat.i(238042);
      boolean bool = super.iQR();
      if (bool)
      {
        i locali = i.lV(this.mContext);
        locali.acks = false;
        locali.acjW = this.ackz.acjU.acjW;
        locali.acko = true;
        locali.mFrom = 1;
        locali.iQP();
      }
      AppMethodBeat.o(238042);
      return bool;
    }
    
    protected final void iQW()
    {
      AppMethodBeat.i(238053);
      k.b.a.log(4, "MicroMsg.recovery.safePoint", "onLaunchNormal");
      if ((this.ackz != null) && (this.ackz.acjU.acjW > 0))
      {
        i locali = i.lV(this.mContext);
        locali.acks = false;
        locali.acjW = this.ackz.acjU.acjW;
        locali.acko = false;
        locali.mFrom = 1;
        locali.iQP();
      }
      AppMethodBeat.o(238053);
    }
    
    protected final void iQX()
    {
      AppMethodBeat.i(238062);
      this.mUiHandler.postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(238016);
          if (j.d.this.ackH.get())
          {
            k.b.a.log(4, "MicroMsg.recovery.safePoint", "auto clear task has been canceled, skip");
            AppMethodBeat.o(238016);
            return;
          }
          k.b.a.log(4, "MicroMsg.recovery.safePoint", "auto clear point");
          j.d.this.finish();
          AppMethodBeat.o(238016);
        }
      }, this.acjN.acki);
      AppMethodBeat.o(238062);
    }
    
    protected final void iQY()
    {
      AppMethodBeat.i(238072);
      this.ackH.set(true);
      AppMethodBeat.o(238072);
    }
  }
  
  public static class e
    extends j.a
  {
    protected long ackB = 0L;
    protected a ackJ;
    protected boolean ackK = true;
    protected long acku = 0L;
    protected int mFrom = 2;
    
    public e(Context paramContext)
    {
      super();
    }
    
    public e(j.a parama)
    {
      super();
    }
    
    private void iQZ()
    {
      AppMethodBeat.i(237981);
      if (!this.ackK)
      {
        AppMethodBeat.o(237981);
        return;
      }
      k.b.a.log(4, "MicroMsg.recovery.signalHandler", "try fallback trigger");
      iRa().axR(this.mFrom);
      AppMethodBeat.o(237981);
    }
    
    private e iRa()
    {
      AppMethodBeat.i(237987);
      b localb = new b(this);
      localb.ackB = this.ackB;
      AppMethodBeat.o(237987);
      return localb;
    }
    
    public final e a(a parama)
    {
      this.ackJ = parama;
      return this;
    }
    
    public void axR(int paramInt)
    {
      AppMethodBeat.i(238030);
      super.begin();
      iQB();
      k.b.a.log(4, "MicroMsg.recovery.signalHandler", "#begin");
      this.mFrom = paramInt;
      if (this.ackB > 0L) {
        this.acku = (this.acky - this.ackB);
      }
      if (this.acku > 0L) {}
      long l2;
      for (long l1 = this.acku;; l1 = this.acky - this.ackA.acjR)
      {
        k.b.a.log(4, "MicroMsg.recovery.signalHandler", "recovery interval = ".concat(String.valueOf(l1)));
        l2 = this.acjN.ackh;
        if ((l2 <= 0L) || (l1 >= l2)) {
          break;
        }
        k.b.a.log(4, "MicroMsg.recovery.signalHandler", "too fast, skip and do nothing, min = ".concat(String.valueOf(l2)));
        iQZ();
        AppMethodBeat.o(238030);
        return;
      }
      if ((this.ackx instanceof j.d)) {
        ((j.d)this.ackx).iQY();
      }
      if ((!TextUtils.isEmpty(this.ackA.acjS)) && (!this.ackA.acjS.equals(this.mVersionName)))
      {
        k.b.a.log(4, "MicroMsg.recovery.signalHandler", "version code mismatch, skip");
        iQT();
      }
      if (l1 < this.acjN.ackf)
      {
        k.b.a.log(4, "MicroMsg.recovery.signalHandler", "within interval, inc");
        iQS();
      }
      label331:
      Object localObject;
      for (;;)
      {
        paramInt = this.ackz.acjU.acjW;
        k.b.a.log(4, "MicroMsg.recovery.signalHandler", "recovery crashCount = ".concat(String.valueOf(paramInt)));
        if (paramInt < this.acjN.ackd) {
          break label542;
        }
        if (iQR()) {
          break;
        }
        k.b.a.log(5, "MicroMsg.recovery.signalHandler", "launch recovery fail");
        Kl(true);
        AppMethodBeat.o(238030);
        return;
        l2 = this.acjN.ackg;
        if ((l1 < l2) && (this.ackJ != null))
        {
          k.b.a.log(4, "MicroMsg.recovery.signalHandler", "within signal interval");
          if (l1 >= l2)
          {
            paramInt = 0;
            localObject = this.ackJ;
            ((a)localObject).ackL = (paramInt + ((a)localObject).ackL);
            if (((a)localObject).ackL < 100) {
              break label475;
            }
            ((a)localObject).ackL = 0;
          }
          label475:
          for (paramInt = 1;; paramInt = 0)
          {
            if (paramInt != 0)
            {
              k.b.a.log(4, "MicroMsg.recovery.signalHandler", "acc meet, inc");
              iQS();
            }
            localObject = this.ackJ;
            ((a)localObject).ackj.iC("acc_total", ((a)localObject).ackL).iQG();
            break;
            if ((float)l1 >= (float)l2 * 0.75F)
            {
              paramInt = 25;
              break label331;
            }
            if ((float)l1 >= (float)l2 * 0.5F)
            {
              paramInt = 50;
              break label331;
            }
            if ((float)l1 >= (float)l2 * 0.25F)
            {
              paramInt = 75;
              break label331;
            }
            paramInt = 100;
            break label331;
          }
        }
        k.b.a.log(4, "MicroMsg.recovery.signalHandler", "over signal interval, clear point");
        iQT();
        iQS();
      }
      if (paramInt < this.acjN.acke) {
        axP(1);
      }
      for (;;)
      {
        Kl(true);
        onTerminate();
        AppMethodBeat.o(238030);
        return;
        axP(2);
        iQU();
      }
      label542:
      Kl(true);
      iQZ();
      k.b.a.log(4, "MicroMsg.recovery.signalHandler", "onLaunchNormal");
      if (this.ackz.acjU.acjW > 0)
      {
        localObject = i.lV(this.mContext);
        ((i)localObject).acks = false;
        ((i)localObject).acjW = this.ackz.acjU.acjW;
        ((i)localObject).acko = false;
        ((i)localObject).mFrom = this.mFrom;
        ((i)localObject).acku = Math.max(this.acku, 0L);
        ((i)localObject).sz();
      }
      AppMethodBeat.o(238030);
    }
    
    public void begin()
    {
      AppMethodBeat.i(238007);
      axR(2);
      AppMethodBeat.o(238007);
    }
    
    public final void finish()
    {
      AppMethodBeat.i(238034);
      k.b.a.log(4, "MicroMsg.recovery.signalHandler", "#finish");
      AppMethodBeat.o(238034);
    }
    
    protected final boolean iQR()
    {
      AppMethodBeat.i(238038);
      boolean bool = super.iQR();
      if (bool)
      {
        i locali = i.lV(this.mContext);
        locali.acks = false;
        locali.acjW = this.ackz.acjU.acjW;
        locali.acko = true;
        locali.mFrom = this.mFrom;
        locali.acku = Math.max(this.acku, 0L);
        locali.sz();
      }
      AppMethodBeat.o(238038);
      return bool;
    }
    
    public final e yv(long paramLong)
    {
      this.ackB = paramLong;
      return this;
    }
    
    static final class a
    {
      int ackL;
      f ackj;
      final String mName;
      
      private a(String paramString)
      {
        this.mName = paramString;
      }
      
      public static a cP(Context paramContext, String paramString)
      {
        AppMethodBeat.i(238057);
        paramContext = new a(paramString).lW(paramContext);
        AppMethodBeat.o(238057);
        return paramContext;
      }
      
      private a lW(Context paramContext)
      {
        AppMethodBeat.i(238068);
        this.ackj = new f.b(paramContext, this.mName).iQK();
        this.ackL = this.ackj.getInt("acc_total", 0);
        AppMethodBeat.o(238068);
        return this;
      }
    }
    
    public static final class b
      extends j.e
    {
      public b(j.e parame)
      {
        super();
      }
      
      public final void axR(int paramInt)
      {
        AppMethodBeat.i(238065);
        this.acky = System.currentTimeMillis();
        this.ackA = RecoveryCrash.lM(this.mContext);
        this.ackA.iQB();
        this.ackz = this.ackA.iQC();
        k.b.a.log(4, "MicroMsg.recovery.signalHandlerFallback", "#begin");
        this.mFrom = paramInt;
        if (this.ackB > 0L) {
          this.acku = (this.acky - this.ackB);
        }
        long l;
        if (this.acku > 0L)
        {
          l = this.acku;
          k.b.a.log(4, "MicroMsg.recovery.signalHandlerFallback", "recovery interval = ".concat(String.valueOf(l)));
          if (l >= this.acjN.ackg) {
            break label208;
          }
          k.b.a.log(4, "MicroMsg.recovery.signalHandlerFallback", "within interval, inc");
        }
        for (;;)
        {
          iQS();
          paramInt = this.ackz.acjU.acjW;
          k.b.a.log(4, "MicroMsg.recovery.signalHandlerFallback", "recovery crashCount = ".concat(String.valueOf(paramInt)));
          if (paramInt < this.acjN.ackd) {
            break label266;
          }
          if (iQR()) {
            break label223;
          }
          k.b.a.log(5, "MicroMsg.recovery.signalHandlerFallback", "launch recovery fail");
          Kl(true);
          AppMethodBeat.o(238065);
          return;
          l = this.acky - this.ackA.acjR;
          break;
          label208:
          k.b.a.log(4, "MicroMsg.recovery.signalHandlerFallback", "over signal interval, clear point");
          iQT();
        }
        label223:
        if (paramInt < this.acjN.acke) {
          axP(1);
        }
        for (;;)
        {
          Kl(true);
          onTerminate();
          AppMethodBeat.o(238065);
          return;
          axP(2);
          iQU();
        }
        label266:
        Kl(true);
        AppMethodBeat.o(238065);
      }
      
      public final void begin()
      {
        AppMethodBeat.i(238070);
        IllegalStateException localIllegalStateException = new IllegalStateException("Unsupported");
        AppMethodBeat.o(238070);
        throw localIllegalStateException;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.recoveryv2.j
 * JD-Core Version:    0.7.0.1
 */
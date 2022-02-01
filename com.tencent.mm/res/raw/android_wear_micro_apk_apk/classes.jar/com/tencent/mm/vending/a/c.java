package com.tencent.mm.vending.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class c<_Struct, _Index, _Change>
  implements com.tencent.mm.vending.e.a
{
  private e acA;
  private byte[] acB = new byte[0];
  private byte[] acC = new byte[0];
  private boolean acD = false;
  private boolean acE = false;
  private k<_Index> acF = new k((byte)0);
  private volatile com.tencent.mm.vending.b.c acG = new com.tencent.mm.vending.b.c(com.tencent.mm.vending.h.d.adB) {};
  private volatile com.tencent.mm.vending.b.c acH = new com.tencent.mm.vending.b.c(com.tencent.mm.vending.h.d.adB) {};
  private l<_Index, m<_Struct, _Index>> acI = new l();
  HashSet<c<_Struct, _Index, _Change>.h> acJ = new HashSet();
  private boolean acK = false;
  private n acu;
  private Looper acv;
  private Looper acw;
  private Handler acx;
  private Handler acy;
  private AtomicBoolean acz = new AtomicBoolean(false);
  
  public c()
  {
    this(Looper.getMainLooper());
  }
  
  private c(Looper paramLooper)
  {
    this.acv = paramLooper;
    this.acw = com.tencent.mm.vending.i.b.mw().getLooper();
    this.acI.a(new j()
    {
      public final void me()
      {
        com.tencent.mm.vending.f.a.mq();
        c.a(c.this);
      }
    });
    this.acu = new n(this.acv, this.acw);
    this.acu.a(new o()
    {
      public final void mf()
      {
        c localc = c.this;
        com.tencent.mm.vending.f.a.mq();
        c.b(c.this).mi();
      }
      
      public final void mg()
      {
        c localc = c.this;
        com.tencent.mm.vending.f.a.mq();
        c.this.acJ.clear();
        c.b(c.this).mi();
        c.c(c.this).removeCallbacksAndMessages(null);
        c.d(c.this).clear();
      }
      
      public final void mh()
      {
        c localc = c.this;
        com.tencent.mm.vending.f.a.mq();
        if (c.e(c.this) != null) {
          c.e(c.this).mn();
        }
      }
    });
    this.acx = new Handler(this.acv)
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        switch (paramAnonymousMessage.what)
        {
        default: 
          return;
        }
        paramAnonymousMessage = (m)paramAnonymousMessage.obj;
        c.a(c.this, m.a(paramAnonymousMessage));
      }
    };
    this.acy = new Handler(this.acw)
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        switch (paramAnonymousMessage.what)
        {
        default: 
          return;
        }
        c.f(c.this);
      }
    };
    this.acA = new e(this.acw, new f()
    {
      public final void T(_Index paramAnonymous_Index)
      {
        m localm = c.this.R(paramAnonymous_Index);
        boolean bool = c.a(c.this, localm, paramAnonymous_Index);
        if (m.b(localm)) {
          com.tencent.mm.vending.f.a.mr();
        }
        while (bool) {
          return;
        }
        c.a(c.this, localm);
      }
      
      public final void cancel()
      {
        c.a(c.this);
      }
    });
  }
  
  private boolean a(m<_Struct, _Index> paramm, _Index param_Index)
  {
    synchronized (m.e(paramm))
    {
      if ((!m.j(paramm)) || (m.f(paramm)) || (m.k(paramm)))
      {
        this.acK = true;
        Object localObject = P(param_Index);
        this.acK = false;
        if (m.b(paramm)) {
          return false;
        }
        m.c(paramm, localObject);
        m.d(paramm, param_Index);
        m.g(paramm);
        m.h(paramm);
        m.i(paramm);
        if (this.acF.acY == paramm) {
          m.a(paramm, true);
        }
        m.e(paramm).notify();
        return false;
      }
      return true;
    }
  }
  
  private m<_Struct, _Index> b(m<_Struct, _Index> paramm, _Index param_Index)
  {
    int i = 0;
    if (!com.tencent.mm.vending.i.b.mw().isRunning())
    {
      com.tencent.mm.vending.f.a.mo();
      return paramm;
    }
    for (;;)
    {
      synchronized (m.e(paramm))
      {
        if (this.acz.get())
        {
          com.tencent.mm.vending.f.a.mo();
          if ((m.j(paramm)) && (!m.f(paramm))) {
            break label127;
          }
          if (i != 0) {
            break;
          }
          return paramm;
        }
      }
      this.acA.U(param_Index);
      i = 1;
    }
    this.acF.acX.V(param_Index);
    this.acF.acY = paramm;
    com.tencent.mm.vending.f.a.mq();
    System.nanoTime();
    try
    {
      m.e(paramm).wait();
      System.nanoTime();
      com.tencent.mm.vending.f.a.mq();
      this.acF.me();
      label127:
      return paramm;
    }
    catch (InterruptedException param_Index)
    {
      for (;;)
      {
        param_Index.printStackTrace();
      }
    }
  }
  
  protected abstract _Struct P(_Index param_Index);
  
  protected final m<_Struct, _Index> R(_Index param_Index)
  {
    synchronized (this.acB)
    {
      m localm2 = (m)this.acI.get(param_Index);
      m localm1 = localm2;
      if (localm2 == null)
      {
        localm1 = new m();
        this.acI.put(param_Index, localm1);
      }
      return localm1;
    }
  }
  
  protected final c<_Struct, _Index, _Change>.h S(_Index param_Index)
  {
    if (Looper.myLooper() != this.acw) {
      throw new IllegalAccessError("Call from wrong looper");
    }
    if (!this.acK)
    {
      com.tencent.mm.vending.f.a.mp();
      return null;
    }
    m.d(R(param_Index));
    param_Index = new h(this, param_Index);
    this.acJ.add(param_Index);
    return param_Index;
  }
  
  public final com.tencent.mm.vending.b.b<d> a(d paramd)
  {
    return this.acH.W(paramd);
  }
  
  public final <T> T get(_Index param_Index)
  {
    Looper localLooper = Looper.myLooper();
    if ((localLooper != this.acv) && (localLooper != this.acw)) {
      throw new IllegalAccessError("Call from wrong looper");
    }
    if (this.acz.get()) {
      return null;
    }
    m localm = R(param_Index);
    if (localLooper == this.acv) {
      return b(localm, param_Index).mj();
    }
    a(localm, param_Index);
    return localm.mj();
  }
  
  public final void md()
  {
    Looper localLooper = Looper.myLooper();
    if ((localLooper != this.acv) && (localLooper != this.acw)) {
      throw new IllegalAccessError("Call from wrong looper");
    }
    com.tencent.mm.vending.f.a.mq();
    this.acz.set(true);
    this.acy.removeCallbacksAndMessages(null);
    this.acx.removeCallbacksAndMessages(null);
    this.acA.stop();
    this.acA.mi();
    this.acy.sendMessage(this.acy.obtainMessage(2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.vending.a.c
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.vending.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.vending.e.a;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class c<_Struct, _Index, _Change>
  implements a
{
  private n YU;
  private Looper YV;
  private Looper YW;
  private Handler YX;
  private Handler YY;
  private AtomicBoolean YZ = new AtomicBoolean(false);
  private e Za;
  private byte[] Zb = new byte[0];
  private byte[] Zc = new byte[0];
  private boolean Zd = false;
  private boolean Ze = false;
  private k<_Index> Zf = new k((byte)0);
  private volatile com.tencent.mm.vending.b.c Zg = new com.tencent.mm.vending.b.c(com.tencent.mm.vending.g.d.aaa) {};
  private volatile com.tencent.mm.vending.b.c Zh = new com.tencent.mm.vending.b.c(com.tencent.mm.vending.g.d.aaa) {};
  private l<_Index, m<_Struct, _Index>> Zi = new l();
  HashSet<c<_Struct, _Index, _Change>.h> Zj = new HashSet();
  private boolean Zk = false;
  
  public c()
  {
    this(Looper.getMainLooper());
  }
  
  private c(Looper paramLooper)
  {
    this.YV = paramLooper;
    this.YW = com.tencent.mm.vending.h.b.lJ().getLooper();
    this.Zi.a(new j()
    {
      public final void lx()
      {
        c.a(c.this);
      }
    });
    this.YU = new n(this.YV, this.YW);
    this.YU.a(new o()
    {
      public final void lA()
      {
        c localc = c.this;
        if (c.e(c.this) != null) {
          c.e(c.this).lF();
        }
      }
      
      public final void ly()
      {
        c localc = c.this;
        c.b(c.this).lB();
      }
      
      public final void lz()
      {
        c localc = c.this;
        c.this.Zj.clear();
        c.b(c.this).lB();
        c.c(c.this).removeCallbacksAndMessages(null);
        c.d(c.this).clear();
      }
    });
    this.YX = new Handler(this.YV)
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
    this.YY = new Handler(this.YW)
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
    this.Za = new e(this.YW, new f()
    {
      public final void K(_Index paramAnonymous_Index)
      {
        m localm = c.this.I(paramAnonymous_Index);
        boolean bool = c.a(c.this, localm, paramAnonymous_Index);
        if (m.b(localm)) {}
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
        this.Zk = true;
        Object localObject = G(param_Index);
        this.Zk = false;
        if (m.b(paramm)) {
          return false;
        }
        m.c(paramm, localObject);
        m.d(paramm, param_Index);
        m.g(paramm);
        m.h(paramm);
        m.i(paramm);
        if (this.Zf.Zy == paramm) {
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
    if (!com.tencent.mm.vending.h.b.lJ().isRunning()) {
      return paramm;
    }
    for (;;)
    {
      synchronized (m.e(paramm))
      {
        if (this.YZ.get())
        {
          if ((m.j(paramm)) && (!m.f(paramm))) {
            break label115;
          }
          if (i != 0) {
            break;
          }
          return paramm;
        }
      }
      this.Za.L(param_Index);
      i = 1;
    }
    this.Zf.Zx.M(param_Index);
    this.Zf.Zy = paramm;
    System.nanoTime();
    try
    {
      m.e(paramm).wait();
      System.nanoTime();
      this.Zf.lx();
      label115:
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
  
  protected abstract _Struct G(_Index param_Index);
  
  protected final m<_Struct, _Index> I(_Index param_Index)
  {
    synchronized (this.Zb)
    {
      m localm2 = (m)this.Zi.get(param_Index);
      m localm1 = localm2;
      if (localm2 == null)
      {
        localm1 = new m();
        this.Zi.put(param_Index, localm1);
      }
      return localm1;
    }
  }
  
  protected final c<_Struct, _Index, _Change>.h J(_Index param_Index)
  {
    if (Looper.myLooper() != this.YW) {
      throw new IllegalAccessError("Call from wrong looper");
    }
    if (!this.Zk) {
      return null;
    }
    m.d(I(param_Index));
    param_Index = new h(this, param_Index);
    this.Zj.add(param_Index);
    return param_Index;
  }
  
  public final com.tencent.mm.vending.b.b<d> a(d paramd)
  {
    return this.Zh.N(paramd);
  }
  
  public final <T> T get(_Index param_Index)
  {
    Looper localLooper = Looper.myLooper();
    if ((localLooper != this.YV) && (localLooper != this.YW)) {
      throw new IllegalAccessError("Call from wrong looper");
    }
    if (this.YZ.get()) {
      return null;
    }
    m localm = I(param_Index);
    if (localLooper == this.YV) {
      return b(localm, param_Index).lC();
    }
    a(localm, param_Index);
    return localm.lC();
  }
  
  public final void lw()
  {
    Looper localLooper = Looper.myLooper();
    if ((localLooper != this.YV) && (localLooper != this.YW)) {
      throw new IllegalAccessError("Call from wrong looper");
    }
    this.YZ.set(true);
    this.YY.removeCallbacksAndMessages(null);
    this.YX.removeCallbacksAndMessages(null);
    this.Za.stop();
    this.Za.lB();
    this.YY.sendMessage(this.YY.obtainMessage(2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.vending.a.c
 * JD-Core Version:    0.7.0.1
 */
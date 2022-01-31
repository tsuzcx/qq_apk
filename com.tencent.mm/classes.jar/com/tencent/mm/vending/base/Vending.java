package com.tencent.mm.vending.base;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.mm.vending.g.f;
import com.tencent.mm.vending.h.d;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class Vending<_Struct, _Index, _Change>
  implements com.tencent.mm.vending.e.a
{
  private c a;
  HashSet<Vending<_Struct, _Index, _Change>.d> b = new HashSet();
  private Looper c;
  private Looper d;
  private Handler e;
  private Handler f;
  private AtomicBoolean g = new AtomicBoolean(false);
  private Vending.c h;
  private byte[] i = new byte[0];
  private byte[] j = new byte[0];
  private boolean k = false;
  private boolean l = false;
  private Vending.g<_Index> m = new Vending.g((byte)0);
  private volatile com.tencent.mm.vending.b.c n = new Vending.1(this, d.AOW);
  private volatile com.tencent.mm.vending.b.c o = new com.tencent.mm.vending.b.c(d.AOW) {};
  private Vending.h<_Index, Vending.i<_Struct, _Index>> p = new Vending.h();
  private boolean q = false;
  
  public Vending()
  {
    this(Looper.getMainLooper());
  }
  
  public Vending(Looper paramLooper)
  {
    this.c = paramLooper;
    this.d = com.tencent.mm.vending.i.b.dQw().a.getLooper();
    this.p.AOf = new Vending.3(this);
    this.a = new c(this.c, this.d);
    this.a.AOh = new Vending.4(this);
    this.e = new Vending.5(this, this.c);
    this.f = new Vending.6(this, this.d);
    this.h = new Vending.c(this.d, new Vending.7(this));
  }
  
  private _Struct a(_Index param_Index)
  {
    Looper localLooper = Looper.myLooper();
    if ((localLooper != this.c) && (localLooper != this.d)) {
      throw new IllegalAccessError("Call from wrong looper");
    }
    if (this.g.get()) {
      return null;
    }
    Vending.i locali = getLock(param_Index);
    if (invalidIndex(param_Index)) {
      return locali.b;
    }
    if (localLooper == this.c) {
      return b(locali, param_Index).b;
    }
    a(locali, param_Index);
    return locali.b;
  }
  
  private void a(Vending<_Struct, _Index, _Change>.d arg1, _Index param_Index, _Struct param_Struct)
  {
    if (!this.b.contains(???)) {
      return;
    }
    Vending.i locali = getLock(param_Index);
    synchronized (locali.c)
    {
      locali.g = false;
      a(locali, param_Index, param_Struct);
      a(locali);
      return;
    }
  }
  
  private void a(Vending.i<_Struct, _Index> parami)
  {
    if (parami.h)
    {
      parami.h = false;
      return;
    }
    this.e.sendMessage(this.e.obtainMessage(1, parami));
  }
  
  private void a(Vending.i<_Struct, _Index> parami, _Index param_Index, _Struct param_Struct)
  {
    parami.b = param_Struct;
    parami.a = param_Index;
    parami.d = false;
    parami.e = false;
    parami.f = true;
    if (this.m.AOe == parami) {
      parami.h = true;
    }
    parami.c.notify();
  }
  
  private void a(_Index param_Index, _Struct param_Struct)
  {
    if (this.g.get()) {}
    while (this.o == null) {
      return;
    }
    this.o.a(f.cO(param_Index));
  }
  
  private void a(_Index param_Index, boolean paramBoolean)
  {
    looperCheckBoth();
    if (this.g.get()) {
      return;
    }
    Vending.i locali = getLock(param_Index);
    synchronized (locali.c)
    {
      if (locali.f)
      {
        if (paramBoolean) {
          locali.d = true;
        }
      }
      else
      {
        b(param_Index);
        return;
      }
      locali.e = true;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.g.get()) {
      return;
    }
    if ((Looper.myLooper() != this.c) && (Looper.myLooper() != this.d)) {
      throw new IllegalAccessError("Call from wrong thread");
    }
    if (paramBoolean)
    {
      this.a.t(2, null);
      return;
    }
    synchronized (this.j)
    {
      if (this.l)
      {
        this.k = true;
        return;
      }
    }
    if (Looper.myLooper() == this.d)
    {
      c();
      return;
    }
    this.f.removeMessages(1);
    this.f.sendMessage(this.f.obtainMessage(1));
    this.f.post(new Vending.8(this));
  }
  
  private boolean a(Vending.i<_Struct, _Index> parami, _Index param_Index)
  {
    synchronized (parami.c)
    {
      if ((!parami.f) || (parami.d) || (parami.e))
      {
        this.q = true;
        Object localObject = resolveAsynchronous(param_Index);
        this.q = false;
        if (parami.g) {
          return false;
        }
        a(parami, param_Index, localObject);
        return false;
      }
      return true;
    }
  }
  
  private Vending.i<_Struct, _Index> b(Vending.i<_Struct, _Index> parami, _Index param_Index)
  {
    if (!com.tencent.mm.vending.i.b.dQw().a.isAlive())
    {
      com.tencent.mm.vending.f.a.e("Vending", "Vending thread is not running!", new Object[0]);
      return parami;
    }
    synchronized (parami.c)
    {
      boolean bool = c(parami, param_Index);
      if ((parami.f) && (!parami.d)) {
        break label160;
      }
      if (!bool) {
        return parami;
      }
    }
    this.m.AOd.a = param_Index;
    this.m.AOe = parami;
    com.tencent.mm.vending.f.a.i("Vending", "%s waiting %s", new Object[] { this, param_Index });
    long l1 = System.nanoTime();
    try
    {
      parami.c.wait();
      label124:
      com.tencent.mm.vending.f.a.i("Vending", "%s waiting duration %s", new Object[] { this, Long.valueOf(System.nanoTime() - l1) });
      this.m.a();
      label160:
      return parami;
    }
    catch (InterruptedException param_Index)
    {
      break label124;
    }
  }
  
  private _Struct b(_Index param_Index)
  {
    if (invalidIndex(param_Index)) {}
    Vending.i locali;
    do
    {
      return null;
      locali = getLock(param_Index);
    } while ((!c(locali, param_Index)) || (locali.d));
    return locali.b;
  }
  
  private void b()
  {
    if (this.m.AOd.a != null)
    {
      com.tencent.mm.vending.f.a.e("Vending", "Catch deadlock! Tell Carl! .. " + this.m.AOd.a, new Object[0]);
      if (this.m.AOe == null) {}
    }
    synchronized (this.m.AOe.c)
    {
      this.m.AOe.c.notify();
      this.m.a();
      return;
    }
  }
  
  private void c()
  {
    if (this.g.get()) {
      return;
    }
    com.tencent.mm.vending.f.a.i("Vending", "Vending.callPrepareVendingData()", new Object[0]);
    Object localObject = prepareVendingDataAsynchronous();
    this.a.t(1, localObject);
  }
  
  private boolean c(Vending.i<_Struct, _Index> parami, _Index param_Index)
  {
    if (invalidIndex(param_Index)) {
      return false;
    }
    if (this.g.get())
    {
      com.tencent.mm.vending.f.a.e("Vending", "Vending.destroyed() has called.", new Object[0]);
      return false;
    }
    Vending.c localc = this.h;
    if (!localc.ANX.get()) {}
    synchronized (localc.b)
    {
      localc.a.put(param_Index, Vending.c.b.AOa);
      localc.e.sendMessageAtFrontOfQueue(localc.e.obtainMessage(0, param_Index));
      requestIndexImpl(parami, param_Index);
      return true;
    }
  }
  
  Vending.c<_Index> a()
  {
    return this.h;
  }
  
  public com.tencent.mm.vending.b.b<Vending.a> addVendingDataChangedCallback(Vending.a parama)
  {
    return this.n.at(parama);
  }
  
  public com.tencent.mm.vending.b.b<Vending.b> addVendingDataResolvedCallback(Vending.b paramb)
  {
    return this.o.at(paramb);
  }
  
  protected abstract void applyChangeSynchronized(_Change param_Change);
  
  public final void dead()
  {
    looperCheckBoth();
    com.tencent.mm.vending.f.a.i("Vending", "Vending.destroy()", new Object[0]);
    this.g.set(true);
    this.f.removeCallbacksAndMessages(null);
    this.e.removeCallbacksAndMessages(null);
    this.h.ANX.set(true);
    this.h.dQi();
    this.f.sendMessage(this.f.obtainMessage(2));
  }
  
  protected Vending<_Struct, _Index, _Change>.d defer(_Index param_Index)
  {
    looperCheckForVending();
    if (!this.q)
    {
      com.tencent.mm.vending.f.a.w("Vending", "Please call defer in resolveAsynchronous()", new Object[0]);
      return null;
    }
    getLock(param_Index).g = true;
    param_Index = new Vending.d(this, param_Index);
    this.b.add(param_Index);
    return param_Index;
  }
  
  protected abstract void destroyAsynchronous();
  
  public void freezeDataChange()
  {
    if (this.g.get()) {
      return;
    }
    synchronized (this.j)
    {
      this.l = true;
      return;
    }
  }
  
  public <T> T get(_Index param_Index)
  {
    return a(param_Index);
  }
  
  protected Vending.i<_Struct, _Index> getLock(_Index param_Index)
  {
    synchronized (this.i)
    {
      Vending.i locali2 = (Vending.i)this.p.get(param_Index);
      Vending.i locali1 = locali2;
      if (locali2 == null)
      {
        locali1 = new Vending.i();
        this.p.put(param_Index, locali1);
      }
      return locali1;
    }
  }
  
  public Looper getLooper()
  {
    return this.d;
  }
  
  protected boolean invalidIndex(_Index param_Index)
  {
    return false;
  }
  
  protected void loaderClear() {}
  
  protected void looperCheckBoth()
  {
    Looper localLooper = Looper.myLooper();
    if ((localLooper != this.c) && (localLooper != this.d)) {
      throw new IllegalAccessError("Call from wrong looper");
    }
  }
  
  protected void looperCheckForSubscriber()
  {
    if (Looper.myLooper() != this.c) {
      throw new IllegalAccessError("Call from wrong looper");
    }
  }
  
  protected void looperCheckForVending()
  {
    if (Looper.myLooper() != this.d) {
      throw new IllegalAccessError("Call from wrong looper");
    }
  }
  
  public void notifyVendingDataChange()
  {
    a(false);
  }
  
  public void notifyVendingDataChangeSynchronize()
  {
    a(true);
  }
  
  public <T> T peek(_Index param_Index)
  {
    if (this.g.get()) {}
    do
    {
      do
      {
        return null;
      } while (invalidIndex(param_Index));
      param_Index = peekLock(param_Index);
    } while ((param_Index == null) || (param_Index.d));
    return param_Index.b;
  }
  
  protected Vending.i<_Struct, _Index> peekLock(_Index param_Index)
  {
    synchronized (this.i)
    {
      param_Index = (Vending.i)this.p.get(param_Index);
      return param_Index;
    }
  }
  
  protected abstract _Change prepareVendingDataAsynchronous();
  
  public void removeVendingDataChangedCallback(Vending.a parama)
  {
    this.n.remove(parama);
  }
  
  public void removeVendingDataResolvedCallback(Vending.b paramb)
  {
    this.o.remove(paramb);
  }
  
  public void request(_Index param_Index)
  {
    a(param_Index, false);
  }
  
  public void requestConsistent(_Index param_Index)
  {
    a(param_Index, true);
  }
  
  protected void requestIndexImpl(Vending.i<_Struct, _Index> parami, _Index param_Index) {}
  
  protected abstract _Struct resolveAsynchronous(_Index param_Index);
  
  public void resolvedClear()
  {
    looperCheckBoth();
    if (this.g.get()) {
      return;
    }
    this.a.t(3, null);
  }
  
  protected void synchronizing(int paramInt, Object paramObject) {}
  
  public void unfreezeDataChange()
  {
    if (this.g.get()) {
      return;
    }
    synchronized (this.j)
    {
      this.l = false;
      if (this.k)
      {
        notifyVendingDataChange();
        this.k = false;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.vending.base.Vending
 * JD-Core Version:    0.7.0.1
 */
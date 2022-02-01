package com.tencent.mm.vending.base;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.b.c;
import com.tencent.mm.vending.g.g;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class Vending<_Struct, _Index, _Change>
  implements com.tencent.mm.vending.e.a
{
  private static final int MESSAGE_DO_DESTROY = 2;
  private static final int MESSAGE_NOTIFY_DATA_LOADED = 1;
  private static final int MESSAGE_PREPARE_VENDING_DATA = 1;
  private static final int SYNC_MESSAGE_APPLY_CHANGE = 1;
  private static final int SYNC_MESSAGE_CLEAR_RESOLVED_ONLY = 3;
  private static final int SYNC_MESSAGE_PREPARE_DATA_DEGRADE = 2;
  private static final String TAG = "Vending";
  private g<_Index, i<_Struct, _Index>> mArray = new g();
  private byte[] mArrayDataLock = new byte[0];
  private AtomicBoolean mCallDestroyed = new AtomicBoolean(false);
  private volatile c mDataChangedCallback = new Vending.1(this, com.tencent.mm.vending.h.d.UI);
  private volatile c mDataResolvedCallback = new Vending.2(this, com.tencent.mm.vending.h.d.UI);
  private Vending.c<_Index> mDeadlock = new Vending.c((byte)0);
  private boolean mFreezeDataChange = false;
  private boolean mHasPendingDataChange = false;
  private f mLoader;
  private byte[] mPendingDataChangeLock = new byte[0];
  private boolean mResolveFromVending = false;
  private Handler mSubscriberHandler;
  private Looper mSubscriberLooper;
  HashSet<Vending<_Struct, _Index, _Change>.h> mVendingDeferring = new HashSet();
  private Handler mVendingHandler;
  private Looper mVendingLooper;
  private d mVendingSync;
  
  public Vending()
  {
    this(Looper.getMainLooper());
  }
  
  public Vending(Looper paramLooper)
  {
    this.mSubscriberLooper = paramLooper;
    this.mVendingLooper = com.tencent.mm.vending.i.b.jJZ().agvC.getLooper();
    this.mArray.aguj = new b()
    {
      public final void jJF()
      {
        AppMethodBeat.i(177471);
        com.tencent.mm.vending.f.a.i("Vending", "SafeSparseArray fusing.", new Object[0]);
        Vending.this.deadlock();
        AppMethodBeat.o(177471);
      }
    };
    this.mVendingSync = new d(this.mSubscriberLooper, this.mVendingLooper);
    this.mVendingSync.agur = new d.a()
    {
      public final void jJG()
      {
        AppMethodBeat.i(74956);
        com.tencent.mm.vending.f.a.i("Vending", "%s beforeSynchronize", new Object[] { Vending.this });
        Vending.this.mLoader.jJI();
        AppMethodBeat.o(74956);
      }
      
      public final void jJH()
      {
        AppMethodBeat.i(74958);
        com.tencent.mm.vending.f.a.i("Vending", "%s afterSynchronize", new Object[] { Vending.this });
        if (Vending.this.mDataChangedCallback != null) {
          Vending.this.mDataChangedCallback.invoke();
        }
        AppMethodBeat.o(74958);
      }
      
      public final void synchronizing(int paramAnonymousInt, Object paramAnonymousObject)
      {
        AppMethodBeat.i(74957);
        com.tencent.mm.vending.f.a.i("Vending", "%s synchronizing", new Object[] { Vending.this });
        Vending.this.mVendingDeferring.clear();
        Vending.this.mLoader.jJI();
        Vending.this.mSubscriberHandler.removeCallbacksAndMessages(null);
        if (paramAnonymousInt == 2) {
          paramAnonymousObject = Vending.this.prepareVendingDataAsynchronous();
        }
        if ((paramAnonymousInt == 2) || (paramAnonymousInt == 1)) {
          Vending.this.applyChangeSynchronized(paramAnonymousObject);
        }
        Vending.this.synchronizing(paramAnonymousInt, paramAnonymousObject);
        Vending.this.mArray.clear();
        AppMethodBeat.o(74957);
      }
    };
    this.mSubscriberHandler = new Handler(this.mSubscriberLooper)
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(74963);
        switch (paramAnonymousMessage.what)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(74963);
          return;
          paramAnonymousMessage = (Vending.i)paramAnonymousMessage.obj;
          Vending.this.onDataResolved(Vending.i.a(paramAnonymousMessage), Vending.i.b(paramAnonymousMessage));
        }
      }
    };
    this.mVendingHandler = new Handler(this.mVendingLooper)
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(74955);
        switch (paramAnonymousMessage.what)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(74955);
          return;
          Vending.this.callPrepareVendingData();
          AppMethodBeat.o(74955);
          return;
          Vending.this.destroyAsynchronous();
        }
      }
    };
    this.mLoader = new f(this.mVendingLooper, new Vending.f.a()
    {
      public final void cancel()
      {
        AppMethodBeat.i(74966);
        Vending.this.loaderClear();
        Vending.this.deadlock();
        AppMethodBeat.o(74966);
      }
      
      public final void gL(_Index paramAnonymous_Index)
      {
        AppMethodBeat.i(74965);
        Vending.i locali = Vending.this.getLock(paramAnonymous_Index);
        boolean bool = Vending.this.loadFromVending(locali, paramAnonymous_Index);
        if (Vending.i.c(locali))
        {
          com.tencent.mm.vending.f.a.d("Vending", "This lock is defer to return %s %s", new Object[] { locali, paramAnonymous_Index });
          AppMethodBeat.o(74965);
          return;
        }
        if (bool)
        {
          AppMethodBeat.o(74965);
          return;
        }
        Vending.this.notifyDataLoadedIfNeed(locali);
        AppMethodBeat.o(74965);
      }
    });
  }
  
  private void callPrepareVendingData()
  {
    if (this.mCallDestroyed.get()) {
      return;
    }
    com.tencent.mm.vending.f.a.i("Vending", "Vending.callPrepareVendingData()", new Object[0]);
    Object localObject = prepareVendingDataAsynchronous();
    this.mVendingSync.R(1, localObject);
  }
  
  private void deadlock()
  {
    if (this.mDeadlock.agtZ.object != null)
    {
      com.tencent.mm.vending.f.a.e("Vending", "Catch deadlock! Tell Carl! .. " + this.mDeadlock.agtZ.object, new Object[0]);
      if (this.mDeadlock.agua == null) {}
    }
    synchronized (i.e(this.mDeadlock.agua))
    {
      i.e(this.mDeadlock.agua).notify();
      this.mDeadlock.reset();
      return;
    }
  }
  
  private void deferResolved(Vending<_Struct, _Index, _Change>.h arg1, _Index param_Index, _Struct param_Struct)
  {
    if (!this.mVendingDeferring.contains(???)) {
      return;
    }
    i locali = getLock(param_Index);
    synchronized (i.e(locali))
    {
      i.b(locali, false);
      lockResolved(locali, param_Index, param_Struct);
      notifyDataLoadedIfNeed(locali);
      return;
    }
  }
  
  private i<_Struct, _Index> forSubscriberSync(i<_Struct, _Index> parami, _Index param_Index)
  {
    if (!com.tencent.mm.vending.i.b.jJZ().agvC.isAlive())
    {
      com.tencent.mm.vending.f.a.e("Vending", "Vending thread is not running!", new Object[0]);
      return parami;
    }
    synchronized (i.e(parami))
    {
      boolean bool = requestIndex(parami, param_Index);
      if ((i.h(parami)) && (!i.f(parami))) {
        break label157;
      }
      if (!bool) {
        return parami;
      }
    }
    this.mDeadlock.agtZ.object = param_Index;
    this.mDeadlock.agua = parami;
    com.tencent.mm.vending.f.a.i("Vending", "%s waiting %s", new Object[] { this, param_Index });
    long l = System.nanoTime();
    try
    {
      i.e(parami).wait();
      label122:
      com.tencent.mm.vending.f.a.i("Vending", "%s waiting duration %s", new Object[] { this, Long.valueOf(System.nanoTime() - l) });
      this.mDeadlock.reset();
      label157:
      return parami;
    }
    catch (InterruptedException param_Index)
    {
      break label122;
    }
  }
  
  private _Struct getAsync(_Index param_Index)
  {
    if (invalidIndex(param_Index)) {}
    i locali;
    do
    {
      return null;
      locali = getLock(param_Index);
    } while ((!requestIndex(locali, param_Index)) || (i.f(locali)));
    return locali.agul;
  }
  
  private _Struct getSync(_Index param_Index)
  {
    Looper localLooper = Looper.myLooper();
    if ((localLooper != this.mSubscriberLooper) && (localLooper != this.mVendingLooper)) {
      throw new IllegalAccessError("Call from wrong looper");
    }
    if (this.mCallDestroyed.get()) {
      return null;
    }
    i locali = getLock(param_Index);
    if (invalidIndex(param_Index)) {
      return locali.agul;
    }
    if (localLooper == this.mSubscriberLooper) {
      return forSubscriberSync(locali, param_Index).agul;
    }
    loadFromVending(locali, param_Index);
    return locali.agul;
  }
  
  private boolean loadFromVending(i<_Struct, _Index> parami, _Index param_Index)
  {
    synchronized (i.e(parami))
    {
      if ((!i.h(parami)) || (i.f(parami)) || (i.i(parami)))
      {
        this.mResolveFromVending = true;
        Object localObject = resolveAsynchronous(param_Index);
        this.mResolveFromVending = false;
        if (i.c(parami)) {
          return false;
        }
        lockResolved(parami, param_Index, localObject);
        return false;
      }
      return true;
    }
  }
  
  private void lockResolved(i<_Struct, _Index> parami, _Index param_Index, _Struct param_Struct)
  {
    i.a(parami, param_Struct);
    i.b(parami, param_Index);
    i.c(parami, false);
    i.d(parami, false);
    i.g(parami);
    if (this.mDeadlock.agua == parami) {
      i.a(parami, true);
    }
    i.e(parami).notify();
  }
  
  private void notifyDataLoadedIfNeed(i<_Struct, _Index> parami)
  {
    if (i.d(parami))
    {
      i.a(parami, false);
      return;
    }
    this.mSubscriberHandler.sendMessage(this.mSubscriberHandler.obtainMessage(1, parami));
  }
  
  private void notifyVendingDataChange(boolean paramBoolean)
  {
    if (this.mCallDestroyed.get()) {
      return;
    }
    if ((Looper.myLooper() != this.mSubscriberLooper) && (Looper.myLooper() != this.mVendingLooper)) {
      throw new IllegalAccessError("Call from wrong thread");
    }
    if (paramBoolean)
    {
      this.mVendingSync.R(2, null);
      return;
    }
    synchronized (this.mPendingDataChangeLock)
    {
      if (this.mFreezeDataChange)
      {
        this.mHasPendingDataChange = true;
        return;
      }
    }
    if (Looper.myLooper() == this.mVendingLooper)
    {
      callPrepareVendingData();
      return;
    }
    this.mVendingHandler.removeMessages(1);
    this.mVendingHandler.sendMessage(this.mVendingHandler.obtainMessage(1));
    this.mVendingHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(74944);
        com.tencent.mm.vending.f.a.i("Vending", "WTTTTF", new Object[0]);
        AppMethodBeat.o(74944);
      }
    });
  }
  
  private void onDataResolved(_Index param_Index, _Struct param_Struct)
  {
    if (this.mCallDestroyed.get()) {}
    while (this.mDataResolvedCallback == null) {
      return;
    }
    this.mDataResolvedCallback.invoke(g.gS(param_Index));
  }
  
  private void refillImpl(_Index param_Index, boolean paramBoolean)
  {
    looperCheckBoth();
    if (this.mCallDestroyed.get()) {
      return;
    }
    i locali = getLock(param_Index);
    synchronized (i.e(locali))
    {
      if (i.h(locali))
      {
        if (paramBoolean) {
          i.c(locali, true);
        }
      }
      else
      {
        getAsync(param_Index);
        return;
      }
      i.d(locali, true);
    }
  }
  
  private boolean requestIndex(i<_Struct, _Index> parami, _Index param_Index)
  {
    if (invalidIndex(param_Index)) {
      return false;
    }
    if (this.mCallDestroyed.get())
    {
      com.tencent.mm.vending.f.a.e("Vending", "Vending.destroyed() has called.", new Object[0]);
      return false;
    }
    f localf = this.mLoader;
    if (!localf.qKN.get()) {}
    synchronized (localf.agud)
    {
      localf.agub.put(param_Index, Vending.f.b.agug);
      localf.mVendingHandler.sendMessageAtFrontOfQueue(localf.mVendingHandler.obtainMessage(0, param_Index));
      requestIndexImpl(parami, param_Index);
      return true;
    }
  }
  
  public com.tencent.mm.vending.b.b<Vending.d> addVendingDataChangedCallback(Vending.d paramd)
  {
    return this.mDataChangedCallback.add(paramd);
  }
  
  public com.tencent.mm.vending.b.b<Vending.e> addVendingDataResolvedCallback(Vending.e parame)
  {
    return this.mDataResolvedCallback.add(parame);
  }
  
  protected abstract void applyChangeSynchronized(_Change param_Change);
  
  public final void dead()
  {
    looperCheckBoth();
    com.tencent.mm.vending.f.a.i("Vending", "Vending.destroy()", new Object[0]);
    this.mCallDestroyed.set(true);
    this.mVendingHandler.removeCallbacksAndMessages(null);
    this.mSubscriberHandler.removeCallbacksAndMessages(null);
    this.mLoader.qKN.set(true);
    this.mLoader.jJI();
    this.mVendingHandler.sendMessage(this.mVendingHandler.obtainMessage(2));
  }
  
  protected Vending<_Struct, _Index, _Change>.h defer(_Index param_Index)
  {
    looperCheckForVending();
    if (!this.mResolveFromVending)
    {
      com.tencent.mm.vending.f.a.w("Vending", "Please call defer in resolveAsynchronous()", new Object[0]);
      return null;
    }
    i.b(getLock(param_Index), true);
    param_Index = new Vending.h(this, param_Index);
    this.mVendingDeferring.add(param_Index);
    return param_Index;
  }
  
  protected abstract void destroyAsynchronous();
  
  public void freezeDataChange()
  {
    if (this.mCallDestroyed.get()) {
      return;
    }
    synchronized (this.mPendingDataChangeLock)
    {
      this.mFreezeDataChange = true;
      return;
    }
  }
  
  public <T> T get(_Index param_Index)
  {
    return getSync(param_Index);
  }
  
  f<_Index> getLoader()
  {
    return this.mLoader;
  }
  
  protected i<_Struct, _Index> getLock(_Index param_Index)
  {
    synchronized (this.mArrayDataLock)
    {
      i locali2 = (i)this.mArray.get(param_Index);
      i locali1 = locali2;
      if (locali2 == null)
      {
        locali1 = new i();
        this.mArray.put(param_Index, locali1);
      }
      return locali1;
    }
  }
  
  public Looper getLooper()
  {
    return this.mVendingLooper;
  }
  
  protected boolean invalidIndex(_Index param_Index)
  {
    return false;
  }
  
  protected void loaderClear() {}
  
  protected void looperCheckBoth()
  {
    Looper localLooper = Looper.myLooper();
    if ((localLooper != this.mSubscriberLooper) && (localLooper != this.mVendingLooper)) {
      throw new IllegalAccessError("Call from wrong looper");
    }
  }
  
  protected void looperCheckForSubscriber()
  {
    if (Looper.myLooper() != this.mSubscriberLooper) {
      throw new IllegalAccessError("Call from wrong looper");
    }
  }
  
  protected void looperCheckForVending()
  {
    if (Looper.myLooper() != this.mVendingLooper) {
      throw new IllegalAccessError("Call from wrong looper");
    }
  }
  
  public void notifyVendingDataChange()
  {
    notifyVendingDataChange(false);
  }
  
  public void notifyVendingDataChangeSynchronize()
  {
    notifyVendingDataChange(true);
  }
  
  public <T> T peek(_Index param_Index)
  {
    if (this.mCallDestroyed.get()) {}
    do
    {
      do
      {
        return null;
      } while (invalidIndex(param_Index));
      param_Index = peekLock(param_Index);
    } while ((param_Index == null) || (i.f(param_Index)));
    return param_Index.agul;
  }
  
  protected i<_Struct, _Index> peekLock(_Index param_Index)
  {
    synchronized (this.mArrayDataLock)
    {
      param_Index = (i)this.mArray.get(param_Index);
      return param_Index;
    }
  }
  
  protected abstract _Change prepareVendingDataAsynchronous();
  
  public void removeVendingDataChangedCallback(Vending.d paramd)
  {
    this.mDataChangedCallback.remove(paramd);
  }
  
  public void removeVendingDataResolvedCallback(Vending.e parame)
  {
    this.mDataResolvedCallback.remove(parame);
  }
  
  public void request(_Index param_Index)
  {
    refillImpl(param_Index, false);
  }
  
  public void requestConsistent(_Index param_Index)
  {
    refillImpl(param_Index, true);
  }
  
  protected void requestIndexImpl(i<_Struct, _Index> parami, _Index param_Index) {}
  
  protected abstract _Struct resolveAsynchronous(_Index param_Index);
  
  public void resolvedClear()
  {
    looperCheckBoth();
    if (this.mCallDestroyed.get()) {
      return;
    }
    this.mVendingSync.R(3, null);
  }
  
  protected void synchronizing(int paramInt, Object paramObject) {}
  
  public void unfreezeDataChange()
  {
    if (this.mCallDestroyed.get()) {
      return;
    }
    synchronized (this.mPendingDataChangeLock)
    {
      this.mFreezeDataChange = false;
      if (this.mHasPendingDataChange)
      {
        notifyVendingDataChange();
        this.mHasPendingDataChange = false;
      }
      return;
    }
  }
  
  static abstract interface b
  {
    public abstract void jJF();
  }
  
  public static final class f<_Index>
  {
    HashMap<_Index, Vending.f.b> agub;
    private a<_Index> aguc;
    byte[] agud;
    Handler mVendingHandler;
    AtomicBoolean qKN;
    
    protected f(Looper paramLooper, a<_Index> parama)
    {
      AppMethodBeat.i(74947);
      this.agub = new HashMap();
      this.aguc = null;
      this.qKN = new AtomicBoolean(false);
      this.agud = new byte[0];
      this.aguc = parama;
      this.mVendingHandler = new Handler(paramLooper)
      {
        public final void handleMessage(Message arg1)
        {
          AppMethodBeat.i(74961);
          if (Vending.f.a(Vending.f.this).get())
          {
            Vending.f.b(Vending.f.this).cancel();
            AppMethodBeat.o(74961);
            return;
          }
          Object localObject1 = ???.obj;
          Vending.f.b(Vending.f.this).gL(localObject1);
          synchronized (Vending.f.this.agud)
          {
            Vending.f.this.agub.put(localObject1, Vending.f.b.aguh);
            AppMethodBeat.o(74961);
            return;
          }
        }
      };
      AppMethodBeat.o(74947);
    }
    
    protected final void jJI()
    {
      AppMethodBeat.i(74948);
      this.mVendingHandler.removeCallbacksAndMessages(null);
      com.tencent.mm.vending.f.a.i("Vending.Loader", "clear()", new Object[0]);
      synchronized (this.agud)
      {
        this.agub.clear();
        this.aguc.cancel();
        AppMethodBeat.o(74948);
        return;
      }
    }
    
    protected static abstract interface a<_Index>
    {
      public abstract void cancel();
      
      public abstract void gL(_Index param_Index);
    }
  }
  
  static class g<K, V>
    extends HashMap<K, V>
  {
    Vending.b aguj = null;
    
    public void clear()
    {
      AppMethodBeat.i(177473);
      super.clear();
      if (this.aguj != null) {
        this.aguj.jJF();
      }
      AppMethodBeat.o(177473);
    }
  }
  
  static final class i<_Struct, _Index>
  {
    private boolean RC;
    private boolean agtK;
    private _Index aguk;
    _Struct agul;
    private boolean agum;
    private boolean agun;
    private boolean mFc;
    private byte[] mLock;
    
    i()
    {
      AppMethodBeat.i(177474);
      this.mLock = new byte[0];
      this.RC = false;
      this.agum = false;
      this.mFc = false;
      this.agtK = false;
      this.agun = false;
      AppMethodBeat.o(177474);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.vending.base.Vending
 * JD-Core Version:    0.7.0.1
 */
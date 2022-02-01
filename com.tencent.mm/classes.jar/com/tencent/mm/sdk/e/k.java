package com.tencent.mm.sdk.e;

import android.os.Looper;
import com.tencent.e.j.a;

public abstract class k
  implements g
{
  private final l<a, m> defaults = new l() {};
  private final l<b, String> loadedListener = new l() {};
  
  private void processEvent(a parama, m paramm)
  {
    parama.a(paramm.dmp, paramm);
  }
  
  private void processLoaded(b paramb, String paramString) {}
  
  public void add(a parama, a parama1)
  {
    this.defaults.a(parama1, parama);
  }
  
  public void add(a parama)
  {
    this.defaults.a(parama, Looper.getMainLooper());
  }
  
  public void add(a parama, Looper paramLooper)
  {
    this.defaults.a(parama, paramLooper);
  }
  
  public void add(String paramString, a parama)
  {
    this.defaults.a(parama, a.bbi(paramString));
  }
  
  public void addLoadedListener(b paramb)
  {
    this.loadedListener.a(paramb, Looper.getMainLooper());
  }
  
  public void doNotify()
  {
    m localm = new m("*");
    this.defaults.dW(localm);
    this.defaults.doNotify();
  }
  
  public void doNotify(String paramString)
  {
    paramString = new m(paramString);
    this.defaults.dW(paramString);
    this.defaults.doNotify();
  }
  
  public void doNotify(String paramString, int paramInt, Object paramObject)
  {
    m localm = new m();
    localm.dmp = paramString;
    localm.duP = paramInt;
    localm.obj = paramObject;
    localm.IBX = this;
    this.defaults.dW(localm);
    this.defaults.doNotify();
  }
  
  public void lock()
  {
    this.defaults.lock();
  }
  
  public int lockCount()
  {
    return this.defaults.IBP;
  }
  
  public void remove(a parama)
  {
    this.defaults.remove(parama);
  }
  
  public void removeLoadedListener(b paramb)
  {
    this.loadedListener.remove(paramb);
  }
  
  public void unlock()
  {
    this.defaults.unlock();
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString, m paramm);
  }
  
  public static abstract interface b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.e.k
 * JD-Core Version:    0.7.0.1
 */
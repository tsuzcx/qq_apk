package com.tencent.mm.sdk.e;

import android.os.Looper;

public abstract class j
  implements f
{
  public final k<a, l> ujP = new k() {};
  private final k<Object, String> ujQ = new k() {};
  
  public void a(a parama, Looper paramLooper)
  {
    this.ujP.a(parama, paramLooper);
  }
  
  public final void aam(String paramString)
  {
    paramString = new l(paramString);
    this.ujP.bV(paramString);
    this.ujP.doNotify();
  }
  
  public void b(String paramString, int paramInt, Object paramObject)
  {
    l locall = new l();
    locall.bGt = paramString;
    locall.gbI = paramInt;
    locall.obj = paramObject;
    locall.ujY = this;
    this.ujP.bV(locall);
    this.ujP.doNotify();
  }
  
  public void c(a parama)
  {
    this.ujP.a(parama, Looper.getMainLooper());
  }
  
  public void d(a parama)
  {
    this.ujP.remove(parama);
  }
  
  public final void doNotify()
  {
    l locall = new l("*");
    this.ujP.bV(locall);
    this.ujP.doNotify();
  }
  
  public void lock()
  {
    this.ujP.lock();
  }
  
  public void unlock()
  {
    this.ujP.unlock();
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString, l paraml);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.e.j
 * JD-Core Version:    0.7.0.1
 */
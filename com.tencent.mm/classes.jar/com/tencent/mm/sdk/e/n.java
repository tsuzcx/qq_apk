package com.tencent.mm.sdk.e;

import android.os.Looper;

public abstract class n
  implements h
{
  private final l<b, a> defaults = new l() {};
  
  public final void a(b paramb)
  {
    if (paramb != null) {
      this.defaults.a(paramb, Looper.getMainLooper());
    }
  }
  
  public final void a(b paramb, Looper paramLooper)
  {
    this.defaults.a(paramb, paramLooper);
  }
  
  protected abstract boolean aPv();
  
  public final void b(int paramInt, n paramn, Object paramObject)
  {
    this.defaults.dS(new a(paramInt, paramn, paramObject));
    this.defaults.doNotify();
  }
  
  public final void b(b paramb)
  {
    if (paramb != null) {
      this.defaults.remove(paramb);
    }
  }
  
  final class a
  {
    int GvT;
    n GvU;
    Object obj;
    
    a(int paramInt, n paramn, Object paramObject)
    {
      this.GvT = paramInt;
      this.obj = paramObject;
      this.GvU = paramn;
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(int paramInt, n paramn, Object paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.e.n
 * JD-Core Version:    0.7.0.1
 */
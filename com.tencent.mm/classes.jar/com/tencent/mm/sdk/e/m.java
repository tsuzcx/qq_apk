package com.tencent.mm.sdk.e;

import android.os.Looper;

public abstract class m
  implements g
{
  private final k<b, a> ujP = new k() {};
  
  public abstract boolean WH();
  
  public final void a(b paramb)
  {
    if (paramb != null) {
      this.ujP.a(paramb, Looper.getMainLooper());
    }
  }
  
  public final void a(b paramb, Looper paramLooper)
  {
    if (paramb != null) {
      this.ujP.a(paramb, paramLooper);
    }
  }
  
  public final void b(int paramInt, m paramm, Object paramObject)
  {
    this.ujP.bV(new a(paramInt, paramm, paramObject));
    this.ujP.doNotify();
  }
  
  public final void b(b paramb)
  {
    if (paramb != null) {
      this.ujP.remove(paramb);
    }
  }
  
  private final class a
  {
    Object obj;
    int uka;
    m ukb;
    
    a(int paramInt, m paramm, Object paramObject)
    {
      this.uka = paramInt;
      this.obj = paramObject;
      this.ukb = paramm;
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(int paramInt, m paramm, Object paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.e.m
 * JD-Core Version:    0.7.0.1
 */
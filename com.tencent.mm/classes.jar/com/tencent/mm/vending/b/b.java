package com.tencent.mm.vending.b;

import com.tencent.mm.vending.h.d;
import junit.framework.Assert;

public final class b<_Callback>
  implements com.tencent.mm.vending.e.a
{
  private int c = -1;
  public _Callback d;
  private int e;
  private a wto;
  public d wtp;
  
  public b(_Callback param_Callback, a parama)
  {
    Assert.assertNotNull("Callback should not be null!", param_Callback);
    this.e = param_Callback.hashCode();
    this.d = param_Callback;
    this.wto = parama;
  }
  
  public final void dead()
  {
    Assert.assertNotNull(this.wto);
    this.wto.b(this);
  }
  
  public final boolean equals(Object paramObject)
  {
    return (paramObject != null) && (paramObject.hashCode() == this.e);
  }
  
  public final int hashCode()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.vending.b.b
 * JD-Core Version:    0.7.0.1
 */
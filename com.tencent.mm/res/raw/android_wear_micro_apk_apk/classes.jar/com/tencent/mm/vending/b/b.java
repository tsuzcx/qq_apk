package com.tencent.mm.vending.b;

import com.tencent.mm.vending.h.d;
import junit.framework.Assert;

public final class b<_Callback>
  implements com.tencent.mm.vending.e.a
{
  private a adn;
  private d ado;
  private int adp = -1;
  private _Callback adq;
  private int adr;
  
  public b(_Callback param_Callback, a parama)
  {
    Assert.assertNotNull("Callback should not be null!", param_Callback);
    this.adr = param_Callback.hashCode();
    this.adq = param_Callback;
    this.adn = parama;
  }
  
  public final boolean equals(Object paramObject)
  {
    return (paramObject != null) && (paramObject.hashCode() == this.adr);
  }
  
  public final _Callback get()
  {
    return this.adq;
  }
  
  public final int hashCode()
  {
    return this.adr;
  }
  
  public final void md()
  {
    Assert.assertNotNull(this.adn);
    this.adn.b(this);
  }
  
  public final d mm()
  {
    return this.ado;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.vending.b.b
 * JD-Core Version:    0.7.0.1
 */
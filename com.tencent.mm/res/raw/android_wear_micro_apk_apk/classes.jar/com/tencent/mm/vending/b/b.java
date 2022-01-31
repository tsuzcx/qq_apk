package com.tencent.mm.vending.b;

import com.tencent.mm.vending.g.d;
import junit.framework.Assert;

public final class b<_Callback>
  implements com.tencent.mm.vending.e.a
{
  private a ZN;
  private d ZO;
  private int ZP = -1;
  private _Callback ZQ;
  private int ZR;
  
  public b(_Callback param_Callback, a parama)
  {
    Assert.assertNotNull("Callback should not be null!", param_Callback);
    this.ZR = param_Callback.hashCode();
    this.ZQ = param_Callback;
    this.ZN = parama;
  }
  
  public final boolean equals(Object paramObject)
  {
    return (paramObject != null) && (paramObject.hashCode() == this.ZR);
  }
  
  public final _Callback get()
  {
    return this.ZQ;
  }
  
  public final int hashCode()
  {
    return this.ZR;
  }
  
  public final d lE()
  {
    return this.ZO;
  }
  
  public final void lw()
  {
    Assert.assertNotNull(this.ZN);
    this.ZN.b(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\res\raw\android_wear_micro_apk_apk\classes.jar
 * Qualified Name:     com.tencent.mm.vending.b.b
 * JD-Core Version:    0.7.0.1
 */
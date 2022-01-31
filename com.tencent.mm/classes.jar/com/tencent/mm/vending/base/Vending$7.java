package com.tencent.mm.vending.base;

import com.tencent.mm.vending.f.a;

final class Vending$7
  implements Vending.c.a<_Index>
{
  Vending$7(Vending paramVending) {}
  
  public final void cancel()
  {
    this.wta.loaderClear();
    Vending.a(this.wta);
  }
  
  public final void cf(_Index param_Index)
  {
    Vending.i locali = this.wta.getLock(param_Index);
    boolean bool = Vending.a(this.wta, locali, param_Index);
    if (locali.g) {
      a.d("Vending", "This lock is defer to return %s %s", new Object[] { locali, param_Index });
    }
    while (bool) {
      return;
    }
    Vending.a(this.wta, locali);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.vending.base.Vending.7
 * JD-Core Version:    0.7.0.1
 */
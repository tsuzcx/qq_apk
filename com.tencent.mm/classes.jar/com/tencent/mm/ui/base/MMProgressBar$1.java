package com.tencent.mm.ui.base;

import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.am.a;

final class MMProgressBar$1
  implements am.a
{
  MMProgressBar$1(MMProgressBar paramMMProgressBar) {}
  
  public final boolean tC()
  {
    int j = MMProgressBar.a(this.uWP) - MMProgressBar.b(this.uWP);
    int i;
    Object localObject;
    int k;
    if (j > 0)
    {
      i = (int)(j * 0.6D);
      localObject = this.uWP;
      k = MMProgressBar.b(this.uWP);
      if (i <= 0) {
        break label112;
      }
    }
    for (;;)
    {
      MMProgressBar.a((MMProgressBar)localObject, i + k);
      MMProgressBar.b(this.uWP, MMProgressBar.b(this.uWP));
      localObject = MMProgressBar.d(this.uWP);
      long l = (MMProgressBar.c(this.uWP) - j) * 40 / MMProgressBar.c(this.uWP);
      ((am)localObject).S(l, l);
      return false;
      label112:
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMProgressBar.1
 * JD-Core Version:    0.7.0.1
 */
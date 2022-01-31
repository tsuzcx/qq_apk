package com.tencent.mm.ui.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;

final class MMProgressBar$1
  implements ap.a
{
  MMProgressBar$1(MMProgressBar paramMMProgressBar) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(106704);
    int j = MMProgressBar.a(this.zli) - MMProgressBar.b(this.zli);
    int i;
    Object localObject;
    int k;
    if (j > 0)
    {
      i = (int)(j * 0.6D);
      localObject = this.zli;
      k = MMProgressBar.b(this.zli);
      if (i <= 0) {
        break label122;
      }
    }
    for (;;)
    {
      MMProgressBar.a((MMProgressBar)localObject, i + k);
      MMProgressBar.b(this.zli, MMProgressBar.b(this.zli));
      localObject = MMProgressBar.d(this.zli);
      long l = (MMProgressBar.c(this.zli) - j) * 40 / MMProgressBar.c(this.zli);
      ((ap)localObject).ag(l, l);
      AppMethodBeat.o(106704);
      return false;
      label122:
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMProgressBar.1
 * JD-Core Version:    0.7.0.1
 */
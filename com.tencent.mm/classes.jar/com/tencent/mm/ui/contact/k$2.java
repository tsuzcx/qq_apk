package com.tencent.mm.ui.contact;

import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.y;

final class k$2
  implements j.a
{
  k$2(k paramk) {}
  
  public final void a(String paramString, l paraml)
  {
    y.d("MicroMsg.FMessageContactView", "onNotifyChange, fmsg change");
    if (!k.b(this.vLo).crl()) {
      k.b(this.vLo).stopTimer();
    }
    paramString = k.b(this.vLo);
    if (k.c(this.vLo)) {}
    for (long l = 500L;; l = 1000L)
    {
      paramString.S(l, l);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.contact.k.2
 * JD-Core Version:    0.7.0.1
 */
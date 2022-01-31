package com.tencent.mm.plugin.shake.c.b;

import com.tencent.mm.h.a.pm;
import com.tencent.mm.h.a.pm.b;
import com.tencent.mm.sdk.platformtools.y;

final class a$3
  implements Runnable
{
  a$3(a parama, pm parampm) {}
  
  public final void run()
  {
    y.i("MicroMsg.ShakeCardDialog", "doNetSceneAccept callback");
    a.a(this.oai, this.oaj.bZb);
    if (a.g(this.oai) != null)
    {
      a.a(this.oai, 8);
      if (a.g(this.oai) != null) {
        a.a(this.oai, a.g(this.oai).bZc);
      }
      if ((a.g(this.oai) != null) && (a.g(this.oai).bKQ))
      {
        a.a(this.oai, a.a.oam);
        a.h(this.oai);
        a.i(this.oai);
        a.j(this.oai);
        if (a.a(this.oai) != null) {
          a.a(this.oai).bAj();
        }
        return;
      }
      a.a(this.oai, a.a.oan);
      a.h(this.oai);
      a.k(this.oai);
      return;
    }
    y.i("MicroMsg.ShakeCardDialog", "doNetSceneAccept callback, mCardAcceptResult == null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.c.b.a.3
 * JD-Core Version:    0.7.0.1
 */
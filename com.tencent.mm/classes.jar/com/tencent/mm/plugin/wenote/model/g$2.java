package com.tencent.mm.plugin.wenote.model;

import com.tencent.mm.plugin.wenote.model.a.m;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.k;
import com.tencent.mm.protocal.c.yj;
import java.util.HashMap;

final class g$2
  implements Runnable
{
  g$2(g paramg, yj paramyj) {}
  
  public final void run()
  {
    if (this.rFL != null)
    {
      com.tencent.mm.plugin.fav.a.g localg = new com.tencent.mm.plugin.fav.a.g();
      localg.field_localId = g.a(this.rFM);
      localg.field_favProto = this.rFL;
      this.rFM.rFt = localg.field_favProto;
      this.rFM.rFk = localg;
      g.a(this.rFM, localg);
    }
    if (g.chx().containsKey(g.b(this.rFM))) {
      this.rFM.rFj = ((m)g.chx().get(g.b(this.rFM)));
    }
    for (;;)
    {
      this.rFM.df(this.rFM.rFj.ntu);
      if (k.ciD() != null) {
        k.ciH();
      }
      return;
      g.c(this.rFM);
    }
  }
  
  public final String toString()
  {
    return super.toString() + "|dealWNoteInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wenote.model.g.2
 * JD-Core Version:    0.7.0.1
 */
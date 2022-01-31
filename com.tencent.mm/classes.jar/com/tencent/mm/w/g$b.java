package com.tencent.mm.w;

import a.d.b.g;
import com.tencent.mm.api.k;
import com.tencent.mm.model.bz;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.d;

public final class g$b
  implements b.a
{
  g$b(com.tencent.mm.v.e parame, d paramd, com.tencent.mm.api.e parame1, k paramk) {}
  
  public final void a(com.tencent.mm.api.e parame)
  {
    g.k(parame, "item");
    y.i("FunctionMsg.OpUpdateExecutor", "[onSuccessFetch] item:" + parame);
    if (parame.rU() > bz.Is() / 1000L)
    {
      this.dBF.a(0, parame, this.dBG.dBz);
      return;
    }
    y.i("FunctionMsg.OpUpdateExecutor", "[onTaskExpired] to show! id:" + this.dBH.rO());
    this.dBI.a(parame.rO(), parame, parame.rS());
  }
  
  public final void b(com.tencent.mm.api.e parame)
  {
    g.k(parame, "item");
    y.w("FunctionMsg.OpUpdateExecutor", "[onFailFetch] item:" + parame);
    if (parame.getStatus() == -1) {
      this.dBF.a(-1, parame, this.dBG.dBz);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.w.g.b
 * JD-Core Version:    0.7.0.1
 */
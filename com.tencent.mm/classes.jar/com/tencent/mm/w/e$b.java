package com.tencent.mm.w;

import a.d.b.g;
import com.tencent.mm.model.bz;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.d;

public final class e$b
  implements b.a
{
  e$b(com.tencent.mm.v.e parame, d paramd) {}
  
  public final void a(com.tencent.mm.api.e parame)
  {
    g.k(parame, "item");
    y.i("FunctionMsg.OpNoShowExecutor", "[onSuccessFetch] item:" + parame);
    if (parame.rU() > bz.Is() / 1000L) {
      this.dBF.a(2, parame, this.dBG.dBz);
    }
  }
  
  public final void b(com.tencent.mm.api.e parame)
  {
    g.k(parame, "item");
    y.w("FunctionMsg.OpNoShowExecutor", "[onFailFetch] item:" + parame);
    if (parame.getStatus() == -1) {
      this.dBF.a(-1, parame, this.dBG.dBz);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.w.e.b
 * JD-Core Version:    0.7.0.1
 */
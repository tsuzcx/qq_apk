package com.tencent.mm.ui.tools;

import com.tencent.mm.ai.d;
import com.tencent.mm.ai.e;
import com.tencent.mm.ai.o;
import com.tencent.mm.ai.z;
import com.tencent.mm.h.a.ag;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd.a;
import com.tencent.mm.sdk.b.a;

final class b$3
  implements bd.a
{
  b$3(d paramd, String paramString) {}
  
  public final void xA()
  {
    if (this.vYn.Lw())
    {
      g.r(o.class);
      com.tencent.mm.storage.p.aaH(this.mYI);
      ag localag = new ag();
      localag.bGi.userName = this.mYI;
      a.udP.m(localag);
    }
    z.My().delete(this.mYI);
    if (b.cIR() != null)
    {
      b.cIR().dismiss();
      b.cIS();
    }
  }
  
  public final boolean xz()
  {
    return b.access$000();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.tools.b.3
 * JD-Core Version:    0.7.0.1
 */
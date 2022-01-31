package com.tencent.mm.plugin.translate.a;

import com.tencent.mm.sdk.platformtools.am.a;
import com.tencent.mm.sdk.platformtools.y;

final class d$1
  implements am.a
{
  d$1(d paramd) {}
  
  public final boolean tC()
  {
    if (this.pKQ.pKM)
    {
      y.e("MicroMsg.WorkingTranslate", "this work is time out, index: %s", new Object[] { Integer.valueOf(this.pKQ.index) });
      this.pKQ.bOX();
      this.pKQ.pKO.a(-1, this.pKQ.pKL, null);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.translate.a.d.1
 * JD-Core Version:    0.7.0.1
 */
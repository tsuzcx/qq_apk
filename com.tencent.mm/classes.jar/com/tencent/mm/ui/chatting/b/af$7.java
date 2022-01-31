package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.chatting.v;
import com.tencent.mm.ui.tools.n.b;

final class af$7
  implements n.b
{
  private int vse = 0;
  
  af$7(af paramaf) {}
  
  public final void Wl()
  {
    new ah().post(new af.7.1(this));
  }
  
  public final void Wm() {}
  
  public final void Wn() {}
  
  public final void Wo() {}
  
  public final boolean pB(String paramString)
  {
    return false;
  }
  
  public final void pC(String paramString)
  {
    if (bk.bl(paramString))
    {
      this.vse = 0;
      this.vsd.He(-1);
      return;
    }
    if (paramString.length() > this.vse) {
      h.nFQ.f(10451, new Object[] { Integer.valueOf(1) });
    }
    this.vse = paramString.length();
    h.nFQ.f(10456, new Object[] { Integer.valueOf(1) });
    af.d(this.vsd).pA(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.af.7
 * JD-Core Version:    0.7.0.1
 */
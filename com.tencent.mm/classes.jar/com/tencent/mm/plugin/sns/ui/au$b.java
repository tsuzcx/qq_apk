package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.am.b.a;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.sdk.platformtools.ah;

public final class au$b
  implements am.b.a
{
  int mPosition;
  w pes = null;
  
  public au$b(w paramw, int paramInt)
  {
    this.pes = paramw;
    this.mPosition = paramInt;
  }
  
  public final void m(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      g.DQ();
      if (g.DN().Dc()) {
        af.aXq().post(new au.b.1(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.au.b
 * JD-Core Version:    0.7.0.1
 */
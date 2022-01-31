package com.tencent.mm.plugin.webwx.a;

import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.oz;
import com.tencent.mm.h.a.oz.a;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.b.c;

final class g$3
  extends c<oz>
{
  g$3(g paramg)
  {
    this.udX = oz.class.getName().hashCode();
  }
  
  private boolean a(oz paramoz)
  {
    if ((paramoz != null) && ((paramoz instanceof oz)))
    {
      d locald = new d(paramoz.bYC.bYD);
      paramoz = new g.3.1(this, locald, paramoz);
      au.Dk().a(971, paramoz);
      au.Dk().a(locald, 0);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webwx.a.g.3
 * JD-Core Version:    0.7.0.1
 */
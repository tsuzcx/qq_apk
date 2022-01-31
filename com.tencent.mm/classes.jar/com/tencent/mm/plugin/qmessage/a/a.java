package com.tencent.mm.plugin.qmessage.a;

import com.tencent.mm.ay.j;
import com.tencent.mm.h.a.af;
import com.tencent.mm.h.a.af.a;
import com.tencent.mm.model.au;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;

final class a
  extends com.tencent.mm.sdk.b.c<af>
{
  a()
  {
    this.udX = af.class.getName().hashCode();
  }
  
  private static boolean a(af paramaf)
  {
    if (!(paramaf instanceof af)) {
      y.f("MicroMsg.QMsg.EventListener", "not bind qq event");
    }
    while (paramaf.bGf.bGh != 0) {
      return false;
    }
    try
    {
      int i = q.Gu() | 0x20;
      au.Hx();
      com.tencent.mm.model.c.Dz().o(34, Integer.valueOf(i));
      au.Hx();
      com.tencent.mm.model.c.Fv().b(new j("", "", "", "", "", "", "", "", i, "", ""));
      g.btm();
      y.d("MicroMsg.QMsg.EventListener", "doClearQQOffLineMessageHelper succ ");
      return false;
    }
    catch (Exception paramaf)
    {
      y.printErrStackTrace("MicroMsg.QMsg.EventListener", paramaf, "", new Object[0]);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.qmessage.a.a
 * JD-Core Version:    0.7.0.1
 */
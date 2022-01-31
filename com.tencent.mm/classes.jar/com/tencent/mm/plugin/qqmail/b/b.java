package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.h.a.af;
import com.tencent.mm.h.a.af.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;

final class b
  extends c<af>
{
  b()
  {
    this.udX = af.class.getName().hashCode();
  }
  
  private static boolean a(af paramaf)
  {
    if (!(paramaf instanceof af)) {
      y.f("MicroMsg.QQMail.EventListener", "not bind qq event");
    }
    while (paramaf.bGf.bGh != 0) {
      return false;
    }
    try
    {
      g.DP().Dz().o(17, Integer.valueOf(2));
      int i = q.Gu() | 0x1;
      g.DP().Dz().o(34, Integer.valueOf(i));
      ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fv().b(new com.tencent.mm.ay.j("", "", "", "", "", "", "", "", i, "", ""));
      ac.btH();
      y.d("MicroMsg.QQMail.EventListener", "doClearQQMailHelper succ ");
      return false;
    }
    catch (Exception paramaf)
    {
      y.printErrStackTrace("MicroMsg.QQMail.EventListener", paramaf, "", new Object[0]);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.b.b
 * JD-Core Version:    0.7.0.1
 */
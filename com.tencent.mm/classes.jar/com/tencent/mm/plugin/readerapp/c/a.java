package com.tencent.mm.plugin.readerapp.c;

import com.tencent.mm.ay.f;
import com.tencent.mm.h.a.af;
import com.tencent.mm.h.a.af.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.protocal.c.bev;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;

final class a
  extends c<af>
{
  a()
  {
    this.udX = af.class.getName().hashCode();
  }
  
  private boolean a(af paramaf)
  {
    if (!(paramaf instanceof af)) {
      y.f("MicroMsg.ReaderAppBindQQ.EventListener", "not bind qq event");
    }
    while (paramaf.bGf.bGh != 0) {
      return false;
    }
    try
    {
      int i = q.Gu() | 0x40000;
      com.tencent.mm.kernel.g.DP().Dz().o(34, Integer.valueOf(i));
      paramaf = new bev();
      paramaf.stP = 262144;
      paramaf.tzI = 1;
      ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fv().b(new i.a(39, paramaf));
      ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fv().b(new com.tencent.mm.ay.j("", "", "", "", "", "", "", "", i, "", ""));
      g.b(new g.a()
      {
        public final void buW() {}
      });
      i = q.Gp();
      com.tencent.mm.kernel.g.DP().Dz().o(40, Integer.valueOf(i & 0xFFFFFFDF));
      ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fv().b(new f(21, 2));
      y.d("MicroMsg.ReaderAppBindQQ.EventListener", "doClearReaderAppWeiboHelper succ ");
      return false;
    }
    catch (Exception paramaf)
    {
      y.printErrStackTrace("MicroMsg.ReaderAppBindQQ.EventListener", paramaf, "", new Object[0]);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.readerapp.c.a
 * JD-Core Version:    0.7.0.1
 */
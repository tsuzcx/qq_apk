package com.tencent.mm.ui;

import com.tencent.mm.h.a.rd;
import com.tencent.mm.model.am.a;
import com.tencent.mm.model.am.f;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.modelvideo.y.a;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.pluginsdk.model.app.ao.a;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.sdk.b.a;

final class MMAppMgr$8$1
  implements Runnable
{
  MMAppMgr$8$1(MMAppMgr.8 param8) {}
  
  public final void run()
  {
    m.Ti().run();
    com.tencent.mm.modelvideo.o.Sw().run();
    com.tencent.mm.as.o.OH().run();
    ap.cle().run();
    if (am.a.dVB != null) {
      am.a.dVB.Hj();
    }
    a.udP.m(new rd());
    au.Hx();
    c.Fv().b(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.MMAppMgr.8.1
 * JD-Core Version:    0.7.0.1
 */
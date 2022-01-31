package com.tencent.mm.ui.transmit;

import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.ui.contact.m.a;
import java.util.ArrayList;
import java.util.List;

final class b$1
  implements com.tencent.mm.plugin.fts.a.l
{
  b$1(b paramb) {}
  
  public final void b(j paramj)
  {
    if (paramj.aYY == 0) {
      b.a(this.wga, paramj);
    }
    for (;;)
    {
      if (paramj.kxh.size() == 0)
      {
        com.tencent.mm.plugin.fts.a.a.l locall = new com.tencent.mm.plugin.fts.a.a.l();
        locall.kwg = "no_result​";
        paramj.kxh = new ArrayList();
        paramj.kxh.add(locall);
      }
      this.wga.clearCache();
      this.wga.notifyDataSetChanged();
      b.a(this.wga).t(paramj.ktu.bVk, paramj.kxh.size(), true);
      return;
      b.a(this.wga, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.b.1
 * JD-Core Version:    0.7.0.1
 */
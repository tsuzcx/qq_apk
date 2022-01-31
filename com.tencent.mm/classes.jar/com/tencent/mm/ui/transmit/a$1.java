package com.tencent.mm.ui.transmit;

import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import java.util.ArrayList;
import java.util.List;

final class a$1
  implements com.tencent.mm.plugin.fts.a.l
{
  a$1(a parama) {}
  
  public final void b(j paramj)
  {
    a.a locala = new a.a(this.wfV, (byte)0);
    locala.bVk = paramj.ktu.bVk;
    locala.kwi = paramj.kwi;
    locala.kxh = paramj.kxh;
    if ((locala.kxh == null) || (locala.kxh.size() == 0))
    {
      paramj = new com.tencent.mm.plugin.fts.a.a.l();
      paramj.kwg = "no_result​";
      locala.kxh = new ArrayList();
      locala.kxh.add(paramj);
    }
    a.a(this.wfV).add(locala);
    a.b(this.wfV);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.transmit.a.1
 * JD-Core Version:    0.7.0.1
 */
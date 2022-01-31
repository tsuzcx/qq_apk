package com.tencent.mm.plugin.profile.ui;

import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.ui.contact.m.a;
import java.util.List;

final class b$1
  implements l
{
  b$1(b paramb) {}
  
  public final void b(j paramj)
  {
    if (paramj.aYY == 0)
    {
      b.a(this.mVG, paramj.kxh);
      if (b.a(this.mVG) != null) {
        b.c(this.mVG).t(paramj.ktu.bVk, b.b(this.mVG).size(), true);
      }
    }
    this.mVG.clearCache();
    this.mVG.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.profile.ui.b.1
 * JD-Core Version:    0.7.0.1
 */
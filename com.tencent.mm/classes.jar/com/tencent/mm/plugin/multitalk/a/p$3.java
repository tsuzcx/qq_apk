package com.tencent.mm.plugin.multitalk.a;

import com.tencent.mm.model.ca.a;
import com.tencent.mm.sdk.platformtools.y;

final class p$3
  implements ca.a
{
  p$3(p paramp) {}
  
  public final boolean Iu()
  {
    y.w("MicroMsg.SubCoreMultiTalk", "HERE UninitForUEH is called! multitalk");
    if (p.a(this.mvd) != null)
    {
      p.a(this.mvd).bbJ();
      if (p.a(this.mvd).mtH != null) {
        y.i("MicroMsg.SubCoreMultiTalk", "dump multiTalkGroup: %s", new Object[] { j.h(p.a(this.mvd).mtH) });
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.a.p.3
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.ui.base;

import com.tencent.mm.sdk.platformtools.am.a;

final class s$1
  implements am.a
{
  s$1(s params) {}
  
  public final boolean tC()
  {
    if (s.a(this.uYG) == -1L)
    {
      this.uYG.show();
      return true;
    }
    s.b(this.uYG);
    if (s.c(this.uYG) >= 0)
    {
      this.uYG.show();
      return true;
    }
    this.uYG.cancel();
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.base.s.1
 * JD-Core Version:    0.7.0.1
 */
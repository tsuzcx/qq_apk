package com.tencent.mm.plugin.scanner.ui;

import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.modelstat.o;

final class q$1
  implements a.a
{
  q$1(q paramq) {}
  
  public final boolean a(boolean paramBoolean, float paramFloat1, float paramFloat2, int paramInt, double paramDouble1, double paramDouble2, double paramDouble3)
  {
    if (!paramBoolean) {
      return true;
    }
    q.a(this.nMN, paramFloat2);
    q.b(this.nMN, paramFloat1);
    q.a(this.nMN, (int)paramDouble2);
    q.a(this.nMN, "");
    q.b(this.nMN, "");
    q.b(this.nMN, paramInt);
    q.a(this.nMN);
    q.b(this.nMN);
    if (!q.c(this.nMN))
    {
      q.d(this.nMN);
      o.a(2012, paramFloat1, paramFloat2, (int)paramDouble2);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.q.1
 * JD-Core Version:    0.7.0.1
 */
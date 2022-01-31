package com.tencent.mm.x;

import com.tencent.mm.sdk.e.m.b;

final class b$1
  implements m.b
{
  b$1(b paramb) {}
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.m paramm, Object paramObject)
  {
    if (!b.BC()) {
      label6:
      return;
    }
    if ((paramObject != null) && ((paramObject instanceof String))) {}
    for (paramm = (String)paramObject;; paramm = null) {
      switch (paramInt)
      {
      case 3: 
      case 4: 
      default: 
        return;
      case 2: 
        if (paramm == null) {
          break label6;
        }
        this.dBR.dBO.a(65636, new b.f(this.dBR, paramm));
        return;
      }
    }
    if (paramm == null)
    {
      this.dBR.dBO.a(65636, new b.c(this.dBR));
      return;
    }
    this.dBR.dBO.a(65636, new b.d(this.dBR, paramm));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.x.b.1
 * JD-Core Version:    0.7.0.1
 */
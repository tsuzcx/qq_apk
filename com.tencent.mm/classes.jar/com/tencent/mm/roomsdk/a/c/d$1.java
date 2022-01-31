package com.tencent.mm.roomsdk.a.c;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;

final class d$1
  implements f
{
  d$1(d paramd) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    if ((paramm instanceof com.tencent.mm.roomsdk.a.a)) {
      ((com.tencent.mm.roomsdk.a.a)paramm).a(this.ubE.ubu);
    }
    if (this.ubE.ubu != null) {
      this.ubE.ubu.a(paramInt1, paramInt2, paramString, this.ubE.ubu);
    }
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if (this.ubE.ubs != null) {
        this.ubE.ubs.a(paramInt1, paramInt2, paramString, this.ubE.ubs);
      }
    }
    while (this.ubE.ubt == null) {
      return;
    }
    this.ubE.ubt.a(paramInt1, paramInt2, paramString, this.ubE.ubt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.roomsdk.a.c.d.1
 * JD-Core Version:    0.7.0.1
 */
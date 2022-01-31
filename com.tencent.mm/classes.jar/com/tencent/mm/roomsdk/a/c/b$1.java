package com.tencent.mm.roomsdk.a.c;

import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.kernel.g;

final class b$1
  implements f
{
  b$1(b paramb) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    g.DQ();
    g.DO().dJT.b(paramm.getType(), this.ubw.eeo);
    if (this.ubw.tipDialog != null) {
      this.ubw.tipDialog.dismiss();
    }
    if (this.ubw.ubv.equals(paramm))
    {
      if ((paramm instanceof com.tencent.mm.roomsdk.a.a)) {
        ((com.tencent.mm.roomsdk.a.a)paramm).a(this.ubw.ubu);
      }
      if (this.ubw.ubu != null) {
        this.ubw.ubu.a(paramInt1, paramInt2, paramString, this.ubw.ubu);
      }
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label157;
      }
      if (this.ubw.ubs != null) {
        this.ubw.ubs.a(paramInt1, paramInt2, paramString, this.ubw.ubs);
      }
    }
    label157:
    while (this.ubw.ubt == null) {
      return;
    }
    this.ubw.ubt.a(paramInt1, paramInt2, paramString, this.ubw.ubt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.roomsdk.a.c.b.1
 * JD-Core Version:    0.7.0.1
 */
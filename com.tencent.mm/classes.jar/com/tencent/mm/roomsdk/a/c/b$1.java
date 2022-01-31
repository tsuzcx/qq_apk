package com.tencent.mm.roomsdk.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;

final class b$1
  implements f
{
  b$1(b paramb) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(80257);
    g.RM();
    g.RK().eHt.b(paramm.getType(), this.yjL.fur);
    if (this.yjL.tipDialog != null) {
      this.yjL.tipDialog.dismiss();
    }
    if (this.yjL.uAW.equals(paramm))
    {
      if ((paramm instanceof com.tencent.mm.roomsdk.a.a)) {
        ((com.tencent.mm.roomsdk.a.a)paramm).a(this.yjL.yjK);
      }
      if (this.yjL.yjK != null) {
        this.yjL.yjK.a(paramInt1, paramInt2, paramString, this.yjL.yjK);
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (this.yjL.yjI != null)
        {
          this.yjL.yjI.a(paramInt1, paramInt2, paramString, this.yjL.yjI);
          AppMethodBeat.o(80257);
        }
      }
      else if (this.yjL.yjJ != null) {
        this.yjL.yjJ.a(paramInt1, paramInt2, paramString, this.yjL.yjJ);
      }
    }
    AppMethodBeat.o(80257);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.roomsdk.a.c.b.1
 * JD-Core Version:    0.7.0.1
 */
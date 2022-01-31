package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.x.a.a;

final class MoreTabUI$1
  implements a.a
{
  MoreTabUI$1(MoreTabUI paramMoreTabUI) {}
  
  public final void b(ac.a parama)
  {
    AppMethodBeat.i(29689);
    if (parama == ac.a.yyN) {
      MoreTabUI.e(this.zdu);
    }
    for (;;)
    {
      MoreTabUI.f(this.zdu).notifyDataSetChanged();
      AppMethodBeat.o(29689);
      return;
      if (parama == ac.a.yyO) {
        MoreTabUI.e(this.zdu);
      } else if ((parama == ac.a.yHy) || (parama == ac.a.yIY)) {
        MoreTabUI.d(this.zdu);
      } else if (parama == ac.a.yJH) {
        MoreTabUI.a(this.zdu);
      }
    }
  }
  
  public final void s(int paramInt, String paramString)
  {
    AppMethodBeat.i(29688);
    if ((paramInt == 262145) || (paramInt == 266260) || (paramInt == 262157) || (paramInt == 266267) || (paramInt == 262158))
    {
      MoreTabUI.a(this.zdu);
      MoreTabUI.b(this.zdu);
    }
    for (;;)
    {
      MoreTabUI.f(this.zdu).notifyDataSetChanged();
      AppMethodBeat.o(29688);
      return;
      if (paramInt == 262147) {
        MoreTabUI.c(this.zdu);
      } else if (paramInt == 262156) {
        MoreTabUI.d(this.zdu);
      } else if (paramInt == 262152) {
        MoreTabUI.e(this.zdu);
      } else if (paramInt == 352279) {
        MoreTabUI.a(this.zdu, paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.MoreTabUI.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.pluginsdk.ui.chat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.MMFlipper.a;

final class AppPanel$1
  implements MMFlipper.a
{
  AppPanel$1(AppPanel paramAppPanel) {}
  
  public final void fp(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(27741);
    ab.i("MicroMsg.AppPanel", "onMeasure width:" + paramInt1 + " height:" + paramInt2 + " isMeasured:" + AppPanel.a(this.vVs));
    if ((AppPanel.a(this.vVs)) || (paramInt2 == 0) || (paramInt1 == 0))
    {
      if ((paramInt2 == 0) || (paramInt1 == 0)) {
        ab.d("MicroMsg.AppPanel", "onMeasure, width or height is 0");
      }
      AppMethodBeat.o(27741);
      return;
    }
    if (AppPanel.b(this.vVs) == 2) {
      ab.d("MicroMsg.AppPanel", "landspace");
    }
    for (;;)
    {
      AppPanel.c(this.vVs);
      AppPanel.a(this.vVs, paramInt2);
      AppPanel.b(this.vVs, paramInt1);
      AppPanel.d(this.vVs);
      AppMethodBeat.o(27741);
      return;
      ab.d("MicroMsg.AppPanel", "portrait");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.AppPanel.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

final class i$1
  implements g.b
{
  i$1(e parame, g paramg, Point paramPoint, float paramFloat) {}
  
  public final void iX(boolean paramBoolean)
  {
    AppMethodBeat.i(8174);
    if (!paramBoolean)
    {
      ab.i("MicroMsg.TransformToBagAniHelper", "convertToTranslucent not drawComplete");
      al.d(new i.1.1(this));
      AppMethodBeat.o(8174);
      return;
    }
    al.d(new i.1.2(this));
    AppMethodBeat.o(8174);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.i.1
 * JD-Core Version:    0.7.0.1
 */
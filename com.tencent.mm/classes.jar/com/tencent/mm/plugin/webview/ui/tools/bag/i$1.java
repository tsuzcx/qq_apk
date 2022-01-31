package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.graphics.Point;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;

final class i$1
  implements g.b
{
  i$1(e parame, g paramg, Point paramPoint, float paramFloat) {}
  
  public final void ld(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      y.i("MicroMsg.TransformToBagAniHelper", "convertToTranslucent not drawComplete");
      ai.d(new i.1.1(this));
      return;
    }
    ai.d(new i.1.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.i.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.graphics.Point;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class n$1
  implements f
{
  n$1(n paramn) {}
  
  public final void bm(float paramFloat)
  {
    AppMethodBeat.i(8248);
    Bundle localBundle = new Bundle();
    localBundle.putFloat("key_alpha", paramFloat);
    n.a(this.viU, localBundle);
    AppMethodBeat.o(8248);
  }
  
  public final void f(float paramFloat, int paramInt)
  {
    AppMethodBeat.i(8247);
    ab.i("MicroMsg.WebViewUIBagHelper", "showBag swipedPosX:%f reportScene:%d", new Object[] { Float.valueOf(paramFloat), Integer.valueOf(paramInt) });
    n.a(this.viU, paramInt);
    Point localPoint = (Point)n.b(this.viU, 8).getParcelable("key_current_bag_pos");
    i.a(n.a(this.viU), localPoint, paramFloat, n.b(this.viU));
    AppMethodBeat.o(8247);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.n.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.graphics.Point;
import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.y;

final class n$1
  implements f
{
  n$1(n paramn) {}
  
  public final void aJ(float paramFloat)
  {
    Bundle localBundle = new Bundle();
    localBundle.putFloat("key_alpha", paramFloat);
    n.a(this.rsO, localBundle);
  }
  
  public final void c(float paramFloat, int paramInt)
  {
    y.i("MicroMsg.WebViewUIBagHelper", "showBag swipedPosX:%f reportScene:%d", new Object[] { Float.valueOf(paramFloat), Integer.valueOf(paramInt) });
    n.a(this.rsO, paramInt);
    Point localPoint = (Point)n.b(this.rsO, 8).getParcelable("key_current_bag_pos");
    i.a(n.a(this.rsO), localPoint, paramFloat, n.b(this.rsO));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.bag.n.1
 * JD-Core Version:    0.7.0.1
 */
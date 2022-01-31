package com.tencent.mm.plugin.webview.ui.tools.preload;

import com.tencent.mm.sdk.platformtools.y;
import java.util.List;

final class e$2
  implements c.a
{
  e$2(c paramc, List paramList) {}
  
  public final void Dd(int paramInt)
  {
    y.i("MicroMsg.Preload.PreloadWebviewManager", "[preloadWebViewInner]state:%d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 5) {
      y.e("MicroMsg.Preload.PreloadWebviewManager", "[preloadWebViewInner]fail");
    }
    while (paramInt != 2) {
      return;
    }
    y.i("MicroMsg.Preload.PreloadWebviewManager", "[preloadWebViewInner]success");
    this.rBy.setOnStateChange(null);
    this.rBz.add(this.rBy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.preload.e.2
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.qqmail.ui;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.xweb.WebView;

final class EmbedWebView$1
  extends GestureDetector.SimpleOnGestureListener
{
  EmbedWebView$1(EmbedWebView paramEmbedWebView) {}
  
  public final boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(123003);
    paramMotionEvent = this.vXN;
    ac.d("MicroMsg.EmbedWebView", "onDoubleTapm, before scale:" + paramMotionEvent.getScale());
    int i = 10;
    while (paramMotionEvent.getScale() != 1.0F)
    {
      i -= 1;
      if (i <= 0) {
        break;
      }
      if (paramMotionEvent.getScale() > 1.0F) {
        paramMotionEvent.zoomOut();
      } else {
        paramMotionEvent.zoomIn();
      }
    }
    ac.d("MicroMsg.EmbedWebView", "onDoubleTapm, after scale:" + this.vXN.getScale());
    AppMethodBeat.o(123003);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.ui.EmbedWebView.1
 * JD-Core Version:    0.7.0.1
 */
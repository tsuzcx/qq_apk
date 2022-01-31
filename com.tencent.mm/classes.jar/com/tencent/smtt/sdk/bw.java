package com.tencent.smtt.sdk;

import android.graphics.Picture;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase.PictureListener;

class bw
  implements IX5WebViewBase.PictureListener
{
  bw(WebView paramWebView, WebView.PictureListener paramPictureListener) {}
  
  public void onNewPicture(IX5WebViewBase paramIX5WebViewBase, Picture paramPicture, boolean paramBoolean)
  {
    AppMethodBeat.i(139431);
    this.b.a(paramIX5WebViewBase);
    this.a.onNewPicture(this.b, paramPicture);
    AppMethodBeat.o(139431);
  }
  
  public void onNewPictureIfHaveContent(IX5WebViewBase paramIX5WebViewBase, Picture paramPicture) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.smtt.sdk.bw
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.smtt.sdk;

import android.graphics.Picture;
import com.tencent.matrix.trace.core.AppMethodBeat;

class bv
  implements android.webkit.WebView.PictureListener
{
  bv(WebView paramWebView, WebView.PictureListener paramPictureListener) {}
  
  public void onNewPicture(android.webkit.WebView paramWebView, Picture paramPicture)
  {
    AppMethodBeat.i(139430);
    this.b.a(paramWebView);
    this.a.onNewPicture(this.b, paramPicture);
    AppMethodBeat.o(139430);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.smtt.sdk.bv
 * JD-Core Version:    0.7.0.1
 */
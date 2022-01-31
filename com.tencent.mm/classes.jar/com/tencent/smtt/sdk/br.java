package com.tencent.smtt.sdk;

import android.graphics.Picture;

class br
  implements android.webkit.WebView.PictureListener
{
  br(WebView paramWebView, WebView.PictureListener paramPictureListener) {}
  
  public void onNewPicture(android.webkit.WebView paramWebView, Picture paramPicture)
  {
    this.b.a(paramWebView);
    this.a.onNewPicture(this.b, paramPicture);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.smtt.sdk.br
 * JD-Core Version:    0.7.0.1
 */
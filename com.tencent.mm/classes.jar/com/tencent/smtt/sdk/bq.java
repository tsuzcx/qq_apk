package com.tencent.smtt.sdk;

import android.webkit.WebView.VisualStateCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;

class bq
  extends WebView.VisualStateCallback
{
  bq(WebView paramWebView, WebView.c paramc) {}
  
  public void onComplete(long paramLong)
  {
    AppMethodBeat.i(139425);
    this.a.a(paramLong);
    AppMethodBeat.o(139425);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.smtt.sdk.bq
 * JD-Core Version:    0.7.0.1
 */
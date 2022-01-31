package com.tencent.smtt.utils;

import android.content.Context;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebView;

class e
  implements d.a
{
  e(d paramd, WebView paramWebView, Context paramContext, RelativeLayout paramRelativeLayout, String paramString, TextView paramTextView) {}
  
  public void a()
  {
    AppMethodBeat.i(65200);
    this.a.post(new f(this));
    AppMethodBeat.o(65200);
  }
  
  public void a(int paramInt)
  {
    AppMethodBeat.i(65201);
    this.a.post(new g(this, paramInt));
    AppMethodBeat.o(65201);
  }
  
  public void a(Throwable paramThrowable)
  {
    AppMethodBeat.i(65202);
    this.a.post(new h(this));
    AppMethodBeat.o(65202);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.smtt.utils.e
 * JD-Core Version:    0.7.0.1
 */
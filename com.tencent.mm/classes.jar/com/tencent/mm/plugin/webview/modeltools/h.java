package com.tencent.mm.plugin.webview.modeltools;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ak.a;
import com.tencent.mm.ui.widget.MMWebView;

public final class h
{
  ak iMP;
  MMWebView uYh;
  public String uYi;
  h.c uYj;
  private ak.a uYk;
  
  public h()
  {
    AppMethodBeat.i(7011);
    this.uYk = new h.1(this);
    this.iMP = new ak(Looper.getMainLooper(), this.uYk);
    AppMethodBeat.o(7011);
  }
  
  public final void a(MMWebView paramMMWebView, h.c paramc)
  {
    AppMethodBeat.i(7012);
    this.uYh = paramMMWebView;
    this.uYj = paramc;
    this.iMP.sendEmptyMessage(1);
    AppMethodBeat.o(7012);
  }
  
  public final void dcJ()
  {
    AppMethodBeat.i(7013);
    d.post(new h.a(this, (byte)0), "ViewCaptureHelper_DeleteBitmap");
    AppMethodBeat.o(7013);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.h
 * JD-Core Version:    0.7.0.1
 */
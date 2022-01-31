package com.tencent.mm.plugin.webview.luggage;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.tencent.luggage.d.k;
import com.tencent.luggage.d.n;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class e$18
  implements View.OnClickListener
{
  e$18(e parame) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(6041);
    this.uRQ.bzs.loadUrl(this.uRQ.getUrl());
    e.a(this.uRQ).setVisibility(8);
    AppMethodBeat.o(6041);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.e.18
 * JD-Core Version:    0.7.0.1
 */
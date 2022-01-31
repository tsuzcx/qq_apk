package com.tencent.xweb.extension.video;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView;

final class d$16
  implements View.OnClickListener
{
  d$16(d paramd) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(84591);
    d.b(this.BFR).evaluateJavascript("xwebVideoBridge.xwebToJS_Video_Play();", new d.16.1(this));
    this.BFR.dYH();
    AppMethodBeat.o(84591);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.xweb.extension.video.d.16
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.xweb.xwalk;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.WebView;

final class c$35
  implements View.OnClickListener
{
  c$35(c paramc) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(139563);
    this.BIO.BIK.setVisibility(8);
    this.BIO.BID.startLongScreenshot(new c.35.1(this), true);
    AppMethodBeat.o(139563);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.xweb.xwalk.c.35
 * JD-Core Version:    0.7.0.1
 */
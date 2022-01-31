package com.tencent.mm.pluginsdk.ui.applet;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class e$1
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  e$1(e parame, ImageView paramImageView) {}
  
  public final void onGlobalLayout()
  {
    AppMethodBeat.i(151357);
    this.mPw.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    this.vTm.vTi = this.mPw.getMeasuredWidth();
    this.vTm.jWe = this.mPw.getMeasuredHeight();
    ab.d("MicroMsg.ChattingBizImageDownloadListener", "onProcessBitmap image delay layout:%d,%d", new Object[] { Integer.valueOf(this.vTm.vTi), Integer.valueOf(this.vTm.jWe) });
    this.vTm.vTl.run();
    AppMethodBeat.o(151357);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.applet.e.1
 * JD-Core Version:    0.7.0.1
 */
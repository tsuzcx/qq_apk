package com.tencent.xweb.xwalk;

import android.view.TextureView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.xweb.c.i.a;
import org.xwalk.core.Log;

final class j$7
  implements Runnable
{
  j$7(j paramj, View paramView, i.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(139595);
    Log.d("XWWebView", "onFinishGetBitmap with ".concat(String.valueOf(((TextureView)this.val$view).getBitmap())));
    AppMethodBeat.o(139595);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.xweb.xwalk.j.7
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.xweb.x5;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebView;
import com.tencent.xweb.c.i.a;
import org.xwalk.core.Log;

final class k$3
  implements Runnable
{
  k$3(k paramk, i.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(139551);
    int i = this.BIu.BIi.getHeight();
    Canvas localCanvas = new Canvas(Bitmap.createBitmap(this.BIu.BIi.getWidth(), i, Bitmap.Config.ARGB_8888));
    this.BIu.BIi.draw(localCanvas);
    Log.d("X5WebView", "bitmapCaptureFinished");
    AppMethodBeat.o(139551);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.xweb.x5.k.3
 * JD-Core Version:    0.7.0.1
 */
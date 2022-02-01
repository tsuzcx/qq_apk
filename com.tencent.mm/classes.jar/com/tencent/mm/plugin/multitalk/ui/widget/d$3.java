package com.tencent.mm.plugin.multitalk.ui.widget;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelimage.loader.b.h;
import com.tencent.mm.modelimage.loader.c.b;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.base.WxImageView;

public final class d$3
  implements h
{
  public d$3(d paramd) {}
  
  public final Bitmap a(String paramString, View paramView, b paramb)
  {
    return null;
  }
  
  public final void b(String paramString, View paramView, final b paramb)
  {
    AppMethodBeat.i(164061);
    if ((paramb.status == 0) && (paramb.bitmap != null)) {
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(164060);
          Bitmap localBitmap = paramb.bitmap;
          d.3.this.LtE.Lty.setBackgroundDrawable(new BitmapDrawable(localBitmap));
          AppMethodBeat.o(164060);
        }
      });
    }
    AppMethodBeat.o(164061);
  }
  
  public final void c(String paramString, View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.d.3
 * JD-Core Version:    0.7.0.1
 */
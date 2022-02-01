package com.tencent.mm.plugin.multitalk.ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver.OnDrawListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.c.h;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.multitalk.d.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.base.WxImageView;

public final class d
{
  public View jBN;
  public Context mContext;
  public boolean zRI;
  public WxImageView zRJ;
  public TextView zRK;
  public TextView zRL;
  public WxImageView zRM;
  boolean zRN;
  public ViewTreeObserver.OnDrawListener zRO;
  
  public d(Context paramContext)
  {
    AppMethodBeat.i(164062);
    this.zRI = false;
    this.zRN = false;
    this.zRO = new ViewTreeObserver.OnDrawListener()
    {
      public final void onDraw()
      {
        AppMethodBeat.i(164058);
        if (!d.this.zRN)
        {
          d.this.zRN = true;
          c.a(com.tencent.mm.plugin.multitalk.d.b.epW(), 0, 0, 0, 0, 0, 0, 0, 1, "", 0);
        }
        AppMethodBeat.o(164058);
      }
    };
    this.mContext = paramContext;
    AppMethodBeat.o(164062);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.d
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.multitalk.ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver.OnDrawListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.a.c.h;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.multitalk.d.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.base.WxImageView;

public final class d
{
  public boolean Fxn;
  public WxImageView Fxo;
  public TextView Fxp;
  public TextView Fxq;
  public WxImageView Fxr;
  boolean Fxs;
  public ViewTreeObserver.OnDrawListener Fxt;
  public Context mContext;
  public View mrI;
  
  public d(Context paramContext)
  {
    AppMethodBeat.i(164062);
    this.Fxn = false;
    this.Fxs = false;
    this.Fxt = new ViewTreeObserver.OnDrawListener()
    {
      public final void onDraw()
      {
        AppMethodBeat.i(164058);
        if (!d.this.Fxs)
        {
          d.this.Fxs = true;
          c.a(com.tencent.mm.plugin.multitalk.d.b.eZK(), 0, 0, 0, 0, 0, 0, 0, 1, "", 0);
        }
        AppMethodBeat.o(164058);
      }
    };
    this.mContext = paramContext;
    AppMethodBeat.o(164062);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.d
 * JD-Core Version:    0.7.0.1
 */
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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.ui.base.WxImageView;

public final class d
{
  public View iFK;
  public Context mContext;
  public boolean wuL;
  public WxImageView wuM;
  public TextView wuN;
  public TextView wuO;
  public WxImageView wuP;
  boolean wuQ;
  public ViewTreeObserver.OnDrawListener wuR;
  
  public d(Context paramContext)
  {
    AppMethodBeat.i(164062);
    this.wuL = false;
    this.wuQ = false;
    this.wuR = new ViewTreeObserver.OnDrawListener()
    {
      public final void onDraw()
      {
        AppMethodBeat.i(164058);
        if (!d.this.wuQ)
        {
          d.this.wuQ = true;
          c.a(com.tencent.mm.plugin.multitalk.d.b.duw(), 0, 0, 0, 0, 0, 0, 0, 1, "", 0);
        }
        AppMethodBeat.o(164058);
      }
    };
    this.mContext = paramContext;
    AppMethodBeat.o(164062);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.d
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.multitalk.ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver.OnDrawListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.a.c.h;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.multitalk.c.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.ui.base.WxImageView;

public final class d
{
  public View iCR;
  public Context mContext;
  public boolean wfi;
  public WxImageView wfj;
  public TextView wfk;
  public TextView wfl;
  public WxImageView wfm;
  boolean wfn;
  public ViewTreeObserver.OnDrawListener wfo;
  
  public d(Context paramContext)
  {
    AppMethodBeat.i(164062);
    this.wfi = false;
    this.wfn = false;
    this.wfo = new ViewTreeObserver.OnDrawListener()
    {
      public final void onDraw()
      {
        AppMethodBeat.i(164058);
        if (!d.this.wfn)
        {
          d.this.wfn = true;
          c.a(com.tencent.mm.plugin.multitalk.c.b.drk(), 0, 0, 0, 0, 0, 0, 0, 1, "", 0);
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
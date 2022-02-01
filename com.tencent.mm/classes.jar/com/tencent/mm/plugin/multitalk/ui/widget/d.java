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
import com.tencent.mm.plugin.multitalk.c.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.base.WxImageView;

public final class d
{
  public View ijA;
  public Context mContext;
  public boolean vab;
  public WxImageView vac;
  public TextView vad;
  public TextView vae;
  public WxImageView vaf;
  boolean vag;
  public ViewTreeObserver.OnDrawListener vah;
  
  public d(Context paramContext)
  {
    AppMethodBeat.i(164062);
    this.vab = false;
    this.vag = false;
    this.vah = new ViewTreeObserver.OnDrawListener()
    {
      public final void onDraw()
      {
        AppMethodBeat.i(164058);
        if (!d.this.vag)
        {
          d.this.vag = true;
          com.tencent.mm.plugin.multitalk.c.b.a(a.dhd(), 0, 0, 0, 0, 0, 0, 0, 1, "", 0);
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
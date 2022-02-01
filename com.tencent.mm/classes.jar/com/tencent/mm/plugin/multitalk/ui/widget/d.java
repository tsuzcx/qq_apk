package com.tencent.mm.plugin.multitalk.ui.widget;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver.OnDrawListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitalk.c.a;
import com.tencent.mm.plugin.multitalk.c.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.WxImageView;

public final class d
{
  public View hIZ;
  public Context mContext;
  public boolean tRt;
  public WxImageView tRu;
  public TextView tRv;
  public TextView tRw;
  public WxImageView tRx;
  boolean tRy;
  public ViewTreeObserver.OnDrawListener tRz;
  
  public d(Context paramContext)
  {
    AppMethodBeat.i(164062);
    this.tRt = false;
    this.tRy = false;
    this.tRz = new ViewTreeObserver.OnDrawListener()
    {
      public final void onDraw()
      {
        AppMethodBeat.i(164058);
        if (!d.this.tRy)
        {
          d.this.tRy = true;
          b.a(a.cTt(), 0, 0, 0, 0, 0, 0, 0, 1, "", 0);
        }
        AppMethodBeat.o(164058);
      }
    };
    this.mContext = paramContext;
    AppMethodBeat.o(164062);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.d
 * JD-Core Version:    0.7.0.1
 */
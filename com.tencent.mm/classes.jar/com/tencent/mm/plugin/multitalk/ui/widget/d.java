package com.tencent.mm.plugin.multitalk.ui.widget;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver.OnDrawListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.multitalk.e.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.WxImageView;

public final class d
{
  public TextView LtA;
  public WxImageView LtB;
  boolean LtC;
  public ViewTreeObserver.OnDrawListener LtD;
  public boolean Ltx;
  public WxImageView Lty;
  public TextView Ltz;
  public Context mContext;
  public View plc;
  
  public d(Context paramContext)
  {
    AppMethodBeat.i(164062);
    this.Ltx = false;
    this.LtC = false;
    this.LtD = new ViewTreeObserver.OnDrawListener()
    {
      public final void onDraw()
      {
        AppMethodBeat.i(164058);
        if (!d.this.LtC)
        {
          d.this.LtC = true;
          c.a(com.tencent.mm.plugin.multitalk.e.b.giL(), 0, 0, 0, 0, 0, 0, 0, 1, "", 0);
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
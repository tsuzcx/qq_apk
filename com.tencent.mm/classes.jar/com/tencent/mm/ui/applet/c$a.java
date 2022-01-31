package com.tencent.mm.ui.applet;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c$a
{
  private ImageView cxy;
  private View mView;
  FrameLayout zgE;
  WindowManager zgF;
  WindowManager.LayoutParams zgG;
  private ViewGroup.LayoutParams zgH;
  
  public c$a(Context paramContext, View paramView)
  {
    AppMethodBeat.i(29975);
    if ((this.zgE != null) && (this.zgF != null))
    {
      AppMethodBeat.o(29975);
      return;
    }
    paramView.findViewById(2131828619).setVisibility(8);
    this.cxy = ((ImageView)paramView.findViewById(2131820875));
    ((ImageView)paramView.findViewById(2131828620)).setOnClickListener(new c.a.1(this));
    this.zgG = new WindowManager.LayoutParams();
    this.zgG.height = -2;
    this.zgG.width = -2;
    this.zgF = ((WindowManager)paramContext.getSystemService("window"));
    this.zgG.x = 0;
    this.zgG.y = 0;
    this.zgG.flags = 40;
    this.zgG.type = 2002;
    this.mView = paramView;
    this.zgG.gravity = 51;
    this.zgG.format = 1;
    this.zgE = new FrameLayout(paramContext);
    this.zgE.setPadding(4, 4, 4, 4);
    this.zgH = new ViewGroup.LayoutParams(-2, -2);
    this.zgE.addView(this.mView, this.zgH);
    paramContext = paramContext.getResources().getDisplayMetrics();
    this.zgE.setOnTouchListener(new c.a.2(this, paramContext));
    AppMethodBeat.o(29975);
  }
  
  public final void dDx()
  {
    AppMethodBeat.i(29977);
    try
    {
      if (this.zgF != null)
      {
        if (this.zgE != null) {
          this.zgF.removeView(this.zgE);
        }
        this.zgF = null;
      }
      if (this.zgE != null)
      {
        this.zgE.removeAllViews();
        this.zgE = null;
      }
      this.mView = null;
      AppMethodBeat.o(29977);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(29977);
    }
  }
  
  public final void show()
  {
    AppMethodBeat.i(29976);
    this.zgF.addView(this.zgE, this.zgG);
    AppMethodBeat.o(29976);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.applet.c.a
 * JD-Core Version:    0.7.0.1
 */
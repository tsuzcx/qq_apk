package com.tencent.mm.ui.applet;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mm.R.h;

public final class c$a
{
  private ImageView bQf;
  private View mView;
  FrameLayout uSd;
  WindowManager uSe;
  WindowManager.LayoutParams uSf;
  private ViewGroup.LayoutParams uSg;
  
  public c$a(Context paramContext, View paramView)
  {
    if ((this.uSd != null) && (this.uSe != null)) {
      return;
    }
    paramView.findViewById(R.h.myLoadingProgress).setVisibility(8);
    this.bQf = ((ImageView)paramView.findViewById(R.h.button));
    ((ImageView)paramView.findViewById(R.h.deletebutton)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        c.a.this.cAn();
      }
    });
    this.uSf = new WindowManager.LayoutParams();
    this.uSf.height = -2;
    this.uSf.width = -2;
    this.uSe = ((WindowManager)paramContext.getSystemService("window"));
    this.uSf.x = 0;
    this.uSf.y = 0;
    this.uSf.flags = 40;
    this.uSf.type = 2002;
    this.mView = paramView;
    this.uSf.gravity = 51;
    this.uSf.format = 1;
    this.uSd = new FrameLayout(paramContext);
    this.uSd.setPadding(4, 4, 4, 4);
    this.uSg = new ViewGroup.LayoutParams(-2, -2);
    this.uSd.addView(this.mView, this.uSg);
    paramContext = paramContext.getResources().getDisplayMetrics();
    this.uSd.setOnTouchListener(new c.a.2(this, paramContext));
  }
  
  public final void cAn()
  {
    try
    {
      if (this.uSe != null)
      {
        if (this.uSd != null) {
          this.uSe.removeView(this.uSd);
        }
        this.uSe = null;
      }
      if (this.uSd != null)
      {
        this.uSd.removeAllViews();
        this.uSd = null;
      }
      this.mView = null;
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.applet.c.a
 * JD-Core Version:    0.7.0.1
 */
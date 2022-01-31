package com.tencent.mm.ui.applet;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.ch.d;
import com.tencent.mm.ch.d.b;
import com.tencent.mm.sdk.platformtools.ah;
import java.lang.ref.WeakReference;

public final class d$a
{
  ImageView bQf;
  ProgressBar bQh;
  Context context;
  TextView kZl;
  View mView;
  int uSA = 0;
  ah uSB = new d.a.4(this);
  FrameLayout uSd;
  WindowManager uSe;
  WindowManager.LayoutParams uSf;
  private ViewGroup.LayoutParams uSg;
  boolean uSx = false;
  d.b uSy = new d.a.1(this);
  com.tencent.mm.ch.d.a uSz;
  
  public d$a(Context paramContext, View paramView)
  {
    if ((this.uSd != null) && (this.uSe != null)) {
      return;
    }
    d.cxA().uGd = new WeakReference(this.uSy);
    this.kZl = ((TextView)paramView.findViewById(R.h.time));
    this.bQf = ((ImageView)paramView.findViewById(R.h.button));
    ((ImageView)paramView.findViewById(R.h.deletebutton)).setOnClickListener(new d.a.2(this));
    this.bQh = ((ProgressBar)paramView.findViewById(R.h.myLoadingProgress));
    this.bQh.setVisibility(8);
    this.context = paramContext;
    this.uSf = new WindowManager.LayoutParams();
    this.uSf.height = -2;
    this.uSf.width = -2;
    this.uSe = ((WindowManager)paramContext.getSystemService("window"));
    this.uSf.x = 0;
    this.uSf.y = 0;
    this.uSf.flags = 40;
    this.uSf.type = 2002;
    this.mView = paramView;
    this.kZl.setVisibility(8);
    this.uSf.gravity = 51;
    this.uSf.format = 1;
    this.uSd = new FrameLayout(paramContext);
    this.uSd.setPadding(4, 4, 4, 4);
    this.uSg = new ViewGroup.LayoutParams(-2, -2);
    this.uSd.addView(this.mView, this.uSg);
    paramContext = paramContext.getResources().getDisplayMetrics();
    this.uSd.setOnTouchListener(new d.a.3(this, paramContext));
  }
  
  final void cAp()
  {
    this.kZl.setText(this.uSA);
    this.uSB.sendEmptyMessageDelayed(0, 1000L);
  }
  
  final void gH(Context paramContext)
  {
    boolean bool = false;
    this.bQf.setVisibility(0);
    this.bQh.setVisibility(4);
    if (!this.uSx) {
      bool = true;
    }
    this.uSx = bool;
    this.bQf.setBackgroundDrawable(paramContext.getResources().getDrawable(R.g.trace_start_nor));
    this.kZl.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.applet.d.a
 * JD-Core Version:    0.7.0.1
 */
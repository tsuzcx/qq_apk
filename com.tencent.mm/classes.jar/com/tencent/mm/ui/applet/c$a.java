package com.tencent.mm.ui.applet;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cj.b;

public final class c$a
{
  FrameLayout HtX;
  WindowManager HtY;
  WindowManager.LayoutParams HtZ;
  private ViewGroup.LayoutParams Hua;
  private ImageView dkL;
  private View mView;
  
  public c$a(final Context paramContext, View paramView)
  {
    AppMethodBeat.i(33833);
    if ((this.HtX != null) && (this.HtY != null))
    {
      AppMethodBeat.o(33833);
      return;
    }
    paramView.findViewById(2131302644).setVisibility(8);
    this.dkL = ((ImageView)paramView.findViewById(2131297631));
    ((ImageView)paramView.findViewById(2131298992)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(33830);
        c.a.this.fhX();
        AppMethodBeat.o(33830);
      }
    });
    this.HtZ = new WindowManager.LayoutParams();
    this.HtZ.height = -2;
    this.HtZ.width = -2;
    this.HtY = ((WindowManager)paramContext.getSystemService("window"));
    this.HtZ.x = 0;
    this.HtZ.y = 0;
    this.HtZ.flags = 40;
    this.HtZ.type = 2002;
    this.mView = paramView;
    this.HtZ.gravity = 51;
    this.HtZ.format = 1;
    this.HtX = new FrameLayout(paramContext);
    this.HtX.setPadding(4, 4, 4, 4);
    this.Hua = new ViewGroup.LayoutParams(-2, -2);
    this.HtX.addView(this.mView, this.Hua);
    paramContext = paramContext.getResources().getDisplayMetrics();
    this.HtX.setOnTouchListener(new View.OnTouchListener()
    {
      int Huc;
      int Hud;
      int Hue;
      int Huf;
      long Hug;
      
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(33832);
        switch (paramAnonymousMotionEvent.getAction())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(33832);
          return false;
          this.Huc = ((int)paramAnonymousMotionEvent.getRawX() - c.a.this.HtZ.x);
          this.Hud = ((int)paramAnonymousMotionEvent.getRawY() - c.a.this.HtZ.y);
          this.Hug = System.currentTimeMillis();
          continue;
          this.Hue = (paramContext.widthPixels - c.a.this.HtZ.width - 1);
          this.Huf = (paramContext.heightPixels - c.a.this.HtZ.height - 1);
          c.a.this.HtZ.x = ((int)paramAnonymousMotionEvent.getRawX() - this.Huc);
          c.a.this.HtZ.y = ((int)paramAnonymousMotionEvent.getRawY() - this.Hud);
          paramAnonymousView = c.a.this.HtZ;
          if (c.a.this.HtZ.x < 0)
          {
            i = 0;
            label204:
            paramAnonymousView.x = i;
            paramAnonymousView = c.a.this.HtZ;
            if (c.a.this.HtZ.x <= this.Hue) {
              break label350;
            }
            i = this.Hue;
            label239:
            paramAnonymousView.x = i;
            paramAnonymousView = c.a.this.HtZ;
            if (c.a.this.HtZ.y >= 0) {
              break label364;
            }
            i = 0;
            label267:
            paramAnonymousView.y = i;
            paramAnonymousView = c.a.this.HtZ;
            if (c.a.this.HtZ.y <= this.Huf) {
              break label378;
            }
          }
          label350:
          label364:
          label378:
          for (int i = this.Huf;; i = c.a.this.HtZ.y)
          {
            paramAnonymousView.y = i;
            c.a.this.HtY.updateViewLayout(c.a.this.HtX, c.a.this.HtZ);
            break;
            i = c.a.this.HtZ.x;
            break label204;
            i = c.a.this.HtZ.x;
            break label239;
            i = c.a.this.HtZ.y;
            break label267;
          }
          if (System.currentTimeMillis() - this.Hug < 300L)
          {
            b.feo();
            b.aL(false, true);
            c.a.this.fhX();
          }
        }
      }
    });
    AppMethodBeat.o(33833);
  }
  
  public final void fhX()
  {
    AppMethodBeat.i(33835);
    try
    {
      if (this.HtY != null)
      {
        if (this.HtX != null) {
          this.HtY.removeView(this.HtX);
        }
        this.HtY = null;
      }
      if (this.HtX != null)
      {
        this.HtX.removeAllViews();
        this.HtX = null;
      }
      this.mView = null;
      AppMethodBeat.o(33835);
      return;
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(33835);
    }
  }
  
  public final void show()
  {
    AppMethodBeat.i(33834);
    this.HtY.addView(this.HtX, this.HtZ);
    AppMethodBeat.o(33834);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.applet.c.a
 * JD-Core Version:    0.7.0.1
 */
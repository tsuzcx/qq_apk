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
import com.tencent.mm.ck.b;

public final class c$a
{
  FrameLayout FUi;
  WindowManager FUj;
  WindowManager.LayoutParams FUk;
  private ViewGroup.LayoutParams FUl;
  private ImageView dnd;
  private View mView;
  
  public c$a(final Context paramContext, View paramView)
  {
    AppMethodBeat.i(33833);
    if ((this.FUi != null) && (this.FUj != null))
    {
      AppMethodBeat.o(33833);
      return;
    }
    paramView.findViewById(2131302644).setVisibility(8);
    this.dnd = ((ImageView)paramView.findViewById(2131297631));
    ((ImageView)paramView.findViewById(2131298992)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(33830);
        c.a.this.eSn();
        AppMethodBeat.o(33830);
      }
    });
    this.FUk = new WindowManager.LayoutParams();
    this.FUk.height = -2;
    this.FUk.width = -2;
    this.FUj = ((WindowManager)paramContext.getSystemService("window"));
    this.FUk.x = 0;
    this.FUk.y = 0;
    this.FUk.flags = 40;
    this.FUk.type = 2002;
    this.mView = paramView;
    this.FUk.gravity = 51;
    this.FUk.format = 1;
    this.FUi = new FrameLayout(paramContext);
    this.FUi.setPadding(4, 4, 4, 4);
    this.FUl = new ViewGroup.LayoutParams(-2, -2);
    this.FUi.addView(this.mView, this.FUl);
    paramContext = paramContext.getResources().getDisplayMetrics();
    this.FUi.setOnTouchListener(new View.OnTouchListener()
    {
      int FUn;
      int FUo;
      int FUp;
      int FUq;
      long FUr;
      
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
          this.FUn = ((int)paramAnonymousMotionEvent.getRawX() - c.a.this.FUk.x);
          this.FUo = ((int)paramAnonymousMotionEvent.getRawY() - c.a.this.FUk.y);
          this.FUr = System.currentTimeMillis();
          continue;
          this.FUp = (paramContext.widthPixels - c.a.this.FUk.width - 1);
          this.FUq = (paramContext.heightPixels - c.a.this.FUk.height - 1);
          c.a.this.FUk.x = ((int)paramAnonymousMotionEvent.getRawX() - this.FUn);
          c.a.this.FUk.y = ((int)paramAnonymousMotionEvent.getRawY() - this.FUo);
          paramAnonymousView = c.a.this.FUk;
          if (c.a.this.FUk.x < 0)
          {
            i = 0;
            label204:
            paramAnonymousView.x = i;
            paramAnonymousView = c.a.this.FUk;
            if (c.a.this.FUk.x <= this.FUp) {
              break label350;
            }
            i = this.FUp;
            label239:
            paramAnonymousView.x = i;
            paramAnonymousView = c.a.this.FUk;
            if (c.a.this.FUk.y >= 0) {
              break label364;
            }
            i = 0;
            label267:
            paramAnonymousView.y = i;
            paramAnonymousView = c.a.this.FUk;
            if (c.a.this.FUk.y <= this.FUq) {
              break label378;
            }
          }
          label350:
          label364:
          label378:
          for (int i = this.FUq;; i = c.a.this.FUk.y)
          {
            paramAnonymousView.y = i;
            c.a.this.FUj.updateViewLayout(c.a.this.FUi, c.a.this.FUk);
            break;
            i = c.a.this.FUk.x;
            break label204;
            i = c.a.this.FUk.x;
            break label239;
            i = c.a.this.FUk.y;
            break label267;
          }
          if (System.currentTimeMillis() - this.FUr < 300L)
          {
            b.eOK();
            b.aH(false, true);
            c.a.this.eSn();
          }
        }
      }
    });
    AppMethodBeat.o(33833);
  }
  
  public final void eSn()
  {
    AppMethodBeat.i(33835);
    try
    {
      if (this.FUj != null)
      {
        if (this.FUi != null) {
          this.FUj.removeView(this.FUi);
        }
        this.FUj = null;
      }
      if (this.FUi != null)
      {
        this.FUi.removeAllViews();
        this.FUi = null;
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
    this.FUj.addView(this.FUi, this.FUk);
    AppMethodBeat.o(33834);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.applet.c.a
 * JD-Core Version:    0.7.0.1
 */
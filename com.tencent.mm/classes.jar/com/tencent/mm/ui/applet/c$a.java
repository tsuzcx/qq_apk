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
import com.tencent.mm.hellhoundlib.a.a;

public final class c$a
{
  FrameLayout JhN;
  WindowManager JhO;
  WindowManager.LayoutParams JhP;
  private ViewGroup.LayoutParams JhQ;
  private ImageView dwy;
  private View mView;
  
  public c$a(final Context paramContext, View paramView)
  {
    AppMethodBeat.i(33833);
    if ((this.JhN != null) && (this.JhO != null))
    {
      AppMethodBeat.o(33833);
      return;
    }
    paramView.findViewById(2131302644).setVisibility(8);
    this.dwy = ((ImageView)paramView.findViewById(2131297631));
    ((ImageView)paramView.findViewById(2131298992)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(33830);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/ui/applet/MemoryDumpController$HprofView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        c.a.this.fyn();
        a.a(this, "com/tencent/mm/ui/applet/MemoryDumpController$HprofView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(33830);
      }
    });
    this.JhP = new WindowManager.LayoutParams();
    this.JhP.height = -2;
    this.JhP.width = -2;
    this.JhO = ((WindowManager)paramContext.getSystemService("window"));
    this.JhP.x = 0;
    this.JhP.y = 0;
    this.JhP.flags = 40;
    this.JhP.type = 2002;
    this.mView = paramView;
    this.JhP.gravity = 51;
    this.JhP.format = 1;
    this.JhN = new FrameLayout(paramContext);
    this.JhN.setPadding(4, 4, 4, 4);
    this.JhQ = new ViewGroup.LayoutParams(-2, -2);
    this.JhN.addView(this.mView, this.JhQ);
    paramContext = paramContext.getResources().getDisplayMetrics();
    this.JhN.setOnTouchListener(new View.OnTouchListener()
    {
      int JhS;
      int JhT;
      int JhU;
      int JhV;
      long JhW;
      
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(33832);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        a.b("com/tencent/mm/ui/applet/MemoryDumpController$HprofView$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
        switch (paramAnonymousMotionEvent.getAction())
        {
        }
        for (;;)
        {
          a.a(false, this, "com/tencent/mm/ui/applet/MemoryDumpController$HprofView$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(33832);
          return false;
          this.JhS = ((int)paramAnonymousMotionEvent.getRawX() - c.a.this.JhP.x);
          this.JhT = ((int)paramAnonymousMotionEvent.getRawY() - c.a.this.JhP.y);
          this.JhW = System.currentTimeMillis();
          continue;
          this.JhU = (paramContext.widthPixels - c.a.this.JhP.width - 1);
          this.JhV = (paramContext.heightPixels - c.a.this.JhP.height - 1);
          c.a.this.JhP.x = ((int)paramAnonymousMotionEvent.getRawX() - this.JhS);
          c.a.this.JhP.y = ((int)paramAnonymousMotionEvent.getRawY() - this.JhT);
          paramAnonymousView = c.a.this.JhP;
          if (c.a.this.JhP.x < 0)
          {
            i = 0;
            label253:
            paramAnonymousView.x = i;
            paramAnonymousView = c.a.this.JhP;
            if (c.a.this.JhP.x <= this.JhU) {
              break label399;
            }
            i = this.JhU;
            label288:
            paramAnonymousView.x = i;
            paramAnonymousView = c.a.this.JhP;
            if (c.a.this.JhP.y >= 0) {
              break label413;
            }
            i = 0;
            label316:
            paramAnonymousView.y = i;
            paramAnonymousView = c.a.this.JhP;
            if (c.a.this.JhP.y <= this.JhV) {
              break label427;
            }
          }
          label399:
          label413:
          label427:
          for (int i = this.JhV;; i = c.a.this.JhP.y)
          {
            paramAnonymousView.y = i;
            c.a.this.JhO.updateViewLayout(c.a.this.JhN, c.a.this.JhP);
            break;
            i = c.a.this.JhP.x;
            break label253;
            i = c.a.this.JhP.x;
            break label288;
            i = c.a.this.JhP.y;
            break label316;
          }
          if (System.currentTimeMillis() - this.JhW < 300L)
          {
            com.tencent.mm.cj.b.fuw();
            com.tencent.mm.cj.b.aS(false, true);
            c.a.this.fyn();
          }
        }
      }
    });
    AppMethodBeat.o(33833);
  }
  
  public final void fyn()
  {
    AppMethodBeat.i(33835);
    try
    {
      if (this.JhO != null)
      {
        if (this.JhN != null) {
          this.JhO.removeView(this.JhN);
        }
        this.JhO = null;
      }
      if (this.JhN != null)
      {
        this.JhN.removeAllViews();
        this.JhN = null;
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
    this.JhO.addView(this.JhN, this.JhP);
    AppMethodBeat.o(33834);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.applet.c.a
 * JD-Core Version:    0.7.0.1
 */
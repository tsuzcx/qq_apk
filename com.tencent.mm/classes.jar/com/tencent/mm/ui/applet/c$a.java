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
  WindowManager.LayoutParams JCA;
  private ViewGroup.LayoutParams JCB;
  FrameLayout JCy;
  WindowManager JCz;
  private ImageView dxD;
  private View mView;
  
  public c$a(final Context paramContext, View paramView)
  {
    AppMethodBeat.i(33833);
    if ((this.JCy != null) && (this.JCz != null))
    {
      AppMethodBeat.o(33833);
      return;
    }
    paramView.findViewById(2131302644).setVisibility(8);
    this.dxD = ((ImageView)paramView.findViewById(2131297631));
    ((ImageView)paramView.findViewById(2131298992)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(33830);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/ui/applet/MemoryDumpController$HprofView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        c.a.this.fCp();
        a.a(this, "com/tencent/mm/ui/applet/MemoryDumpController$HprofView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(33830);
      }
    });
    this.JCA = new WindowManager.LayoutParams();
    this.JCA.height = -2;
    this.JCA.width = -2;
    this.JCz = ((WindowManager)paramContext.getSystemService("window"));
    this.JCA.x = 0;
    this.JCA.y = 0;
    this.JCA.flags = 40;
    this.JCA.type = 2002;
    this.mView = paramView;
    this.JCA.gravity = 51;
    this.JCA.format = 1;
    this.JCy = new FrameLayout(paramContext);
    this.JCy.setPadding(4, 4, 4, 4);
    this.JCB = new ViewGroup.LayoutParams(-2, -2);
    this.JCy.addView(this.mView, this.JCB);
    paramContext = paramContext.getResources().getDisplayMetrics();
    this.JCy.setOnTouchListener(new View.OnTouchListener()
    {
      int JCD;
      int JCE;
      int JCF;
      int JCG;
      long JCH;
      
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(33832);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        a.b("com/tencent/mm/ui/applet/MemoryDumpController$HprofView$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
        switch (paramAnonymousMotionEvent.getAction())
        {
        }
        for (;;)
        {
          a.a(false, this, "com/tencent/mm/ui/applet/MemoryDumpController$HprofView$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(33832);
          return false;
          this.JCD = ((int)paramAnonymousMotionEvent.getRawX() - c.a.this.JCA.x);
          this.JCE = ((int)paramAnonymousMotionEvent.getRawY() - c.a.this.JCA.y);
          this.JCH = System.currentTimeMillis();
          continue;
          this.JCF = (paramContext.widthPixels - c.a.this.JCA.width - 1);
          this.JCG = (paramContext.heightPixels - c.a.this.JCA.height - 1);
          c.a.this.JCA.x = ((int)paramAnonymousMotionEvent.getRawX() - this.JCD);
          c.a.this.JCA.y = ((int)paramAnonymousMotionEvent.getRawY() - this.JCE);
          paramAnonymousView = c.a.this.JCA;
          if (c.a.this.JCA.x < 0)
          {
            i = 0;
            label253:
            paramAnonymousView.x = i;
            paramAnonymousView = c.a.this.JCA;
            if (c.a.this.JCA.x <= this.JCF) {
              break label399;
            }
            i = this.JCF;
            label288:
            paramAnonymousView.x = i;
            paramAnonymousView = c.a.this.JCA;
            if (c.a.this.JCA.y >= 0) {
              break label413;
            }
            i = 0;
            label316:
            paramAnonymousView.y = i;
            paramAnonymousView = c.a.this.JCA;
            if (c.a.this.JCA.y <= this.JCG) {
              break label427;
            }
          }
          label399:
          label413:
          label427:
          for (int i = this.JCG;; i = c.a.this.JCA.y)
          {
            paramAnonymousView.y = i;
            c.a.this.JCz.updateViewLayout(c.a.this.JCy, c.a.this.JCA);
            break;
            i = c.a.this.JCA.x;
            break label253;
            i = c.a.this.JCA.x;
            break label288;
            i = c.a.this.JCA.y;
            break label316;
          }
          if (System.currentTimeMillis() - this.JCH < 300L)
          {
            com.tencent.mm.ci.b.fyx();
            com.tencent.mm.ci.b.aR(false, true);
            c.a.this.fCp();
          }
        }
      }
    });
    AppMethodBeat.o(33833);
  }
  
  public final void fCp()
  {
    AppMethodBeat.i(33835);
    try
    {
      if (this.JCz != null)
      {
        if (this.JCy != null) {
          this.JCz.removeView(this.JCy);
        }
        this.JCz = null;
      }
      if (this.JCy != null)
      {
        this.JCy.removeAllViews();
        this.JCy = null;
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
    this.JCz.addView(this.JCy, this.JCA);
    AppMethodBeat.o(33834);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.applet.c.a
 * JD-Core Version:    0.7.0.1
 */
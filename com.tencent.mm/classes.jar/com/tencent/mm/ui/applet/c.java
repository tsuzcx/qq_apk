package com.tencent.mm.ui.applet;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
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

public final class c
{
  public static void jY(Context paramContext)
  {
    AppMethodBeat.i(33836);
    new a(paramContext, LayoutInflater.from(paramContext).inflate(2131496758, null)).show();
    AppMethodBeat.o(33836);
  }
  
  public static final class a
  {
    FrameLayout ONq;
    WindowManager ONr;
    WindowManager.LayoutParams ONs;
    private ViewGroup.LayoutParams ONt;
    private ImageView dPk;
    private View mView;
    
    public a(final Context paramContext, View paramView)
    {
      AppMethodBeat.i(33833);
      if ((this.ONq != null) && (this.ONr != null))
      {
        AppMethodBeat.o(33833);
        return;
      }
      paramView.findViewById(2131305192).setVisibility(8);
      this.dPk = ((ImageView)paramView.findViewById(2131297893));
      ((ImageView)paramView.findViewById(2131299491)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(33830);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          a.b("com/tencent/mm/ui/applet/MemoryDumpController$HprofView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          c.a.this.gKn();
          a.a(this, "com/tencent/mm/ui/applet/MemoryDumpController$HprofView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(33830);
        }
      });
      this.ONs = new WindowManager.LayoutParams();
      this.ONs.height = -2;
      this.ONs.width = -2;
      this.ONr = ((WindowManager)paramContext.getSystemService("window"));
      this.ONs.x = 0;
      this.ONs.y = 0;
      this.ONs.flags = 40;
      this.ONs.type = 2002;
      this.mView = paramView;
      this.ONs.gravity = 51;
      this.ONs.format = 1;
      this.ONq = new FrameLayout(paramContext);
      this.ONq.setPadding(4, 4, 4, 4);
      this.ONt = new ViewGroup.LayoutParams(-2, -2);
      this.ONq.addView(this.mView, this.ONt);
      paramContext = paramContext.getResources().getDisplayMetrics();
      this.ONq.setOnTouchListener(new View.OnTouchListener()
      {
        int ONv;
        int ONw;
        int ONx;
        int ONy;
        long ONz;
        
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
            this.ONv = ((int)paramAnonymousMotionEvent.getRawX() - c.a.this.ONs.x);
            this.ONw = ((int)paramAnonymousMotionEvent.getRawY() - c.a.this.ONs.y);
            this.ONz = System.currentTimeMillis();
            continue;
            this.ONx = (paramContext.widthPixels - c.a.this.ONs.width - 1);
            this.ONy = (paramContext.heightPixels - c.a.this.ONs.height - 1);
            c.a.this.ONs.x = ((int)paramAnonymousMotionEvent.getRawX() - this.ONv);
            c.a.this.ONs.y = ((int)paramAnonymousMotionEvent.getRawY() - this.ONw);
            paramAnonymousView = c.a.this.ONs;
            if (c.a.this.ONs.x < 0)
            {
              i = 0;
              label204:
              paramAnonymousView.x = i;
              paramAnonymousView = c.a.this.ONs;
              if (c.a.this.ONs.x <= this.ONx) {
                break label350;
              }
              i = this.ONx;
              label239:
              paramAnonymousView.x = i;
              paramAnonymousView = c.a.this.ONs;
              if (c.a.this.ONs.y >= 0) {
                break label364;
              }
              i = 0;
              label267:
              paramAnonymousView.y = i;
              paramAnonymousView = c.a.this.ONs;
              if (c.a.this.ONs.y <= this.ONy) {
                break label378;
              }
            }
            label350:
            label364:
            label378:
            for (int i = this.ONy;; i = c.a.this.ONs.y)
            {
              paramAnonymousView.y = i;
              c.a.this.ONr.updateViewLayout(c.a.this.ONq, c.a.this.ONs);
              break;
              i = c.a.this.ONs.x;
              break label204;
              i = c.a.this.ONs.x;
              break label239;
              i = c.a.this.ONs.y;
              break label267;
            }
            if (System.currentTimeMillis() - this.ONz < 300L)
            {
              com.tencent.mm.ci.b.gGl();
              com.tencent.mm.ci.b.bb(false, true);
              c.a.this.gKn();
            }
          }
        }
      });
      AppMethodBeat.o(33833);
    }
    
    public final void gKn()
    {
      AppMethodBeat.i(33835);
      try
      {
        if (this.ONr != null)
        {
          if (this.ONq != null) {
            this.ONr.removeView(this.ONq);
          }
          this.ONr = null;
        }
        if (this.ONq != null)
        {
          this.ONq.removeAllViews();
          this.ONq = null;
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
      this.ONr.addView(this.ONq, this.ONs);
      AppMethodBeat.o(33834);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.applet.c
 * JD-Core Version:    0.7.0.1
 */
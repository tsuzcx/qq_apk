package com.tencent.mm.ui.applet;

import android.content.Context;
import android.content.res.Resources;
import android.os.Message;
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
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cj.d.b;
import com.tencent.mm.sdk.platformtools.ao;
import java.lang.ref.WeakReference;

public final class d
{
  private static int Huq = 0;
  
  public static void jP(Context paramContext)
  {
    AppMethodBeat.i(33846);
    if (Huq > 0)
    {
      AppMethodBeat.o(33846);
      return;
    }
    paramContext = new a(paramContext, LayoutInflater.from(paramContext).inflate(2131495800, null));
    paramContext.HtY.addView(paramContext.HtX, paramContext.HtZ);
    Huq += 1;
    AppMethodBeat.o(33846);
  }
  
  public static final class a
  {
    FrameLayout HtX;
    WindowManager HtY;
    WindowManager.LayoutParams HtZ;
    private ViewGroup.LayoutParams Hua;
    boolean Hur;
    d.b Hus;
    com.tencent.mm.cj.d.a Hut;
    ao Huu;
    Context context;
    ImageView dkL;
    ProgressBar dkN;
    View mView;
    int rDB;
    TextView toC;
    
    public a(final Context paramContext, View paramView)
    {
      AppMethodBeat.i(33843);
      this.Hur = false;
      this.Hus = new d.b()
      {
        public final void fes()
        {
          AppMethodBeat.i(33838);
          d.a.this.jQ(d.a.this.context);
          Toast.makeText(d.a.this.context, "trace file has saved ", 0).show();
          AppMethodBeat.o(33838);
        }
      };
      this.rDB = 0;
      this.Huu = new ao()
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(33842);
          if (d.a.this.toC.getVisibility() != 0)
          {
            d.a.this.rDB = 0;
            AppMethodBeat.o(33842);
            return;
          }
          d.a locala = d.a.this;
          locala.rDB += 1;
          d.a.this.fhZ();
          super.handleMessage(paramAnonymousMessage);
          AppMethodBeat.o(33842);
        }
      };
      if ((this.HtX != null) && (this.HtY != null))
      {
        AppMethodBeat.o(33843);
        return;
      }
      com.tencent.mm.cj.d.feq().Her = new WeakReference(this.Hus);
      this.toC = ((TextView)paramView.findViewById(2131305811));
      this.dkL = ((ImageView)paramView.findViewById(2131297631));
      ((ImageView)paramView.findViewById(2131298992)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(33839);
          if ((d.a.this.Hur) && (d.a.this.dkN.getVisibility() != 0)) {
            com.tencent.mm.cj.d.feq().b(d.a.this.Hut);
          }
          paramAnonymousView = d.a.this;
          try
          {
            if (paramAnonymousView.HtY != null)
            {
              if (paramAnonymousView.HtX != null) {
                paramAnonymousView.HtY.removeView(paramAnonymousView.HtX);
              }
              paramAnonymousView.HtY = null;
            }
            if (paramAnonymousView.HtX != null)
            {
              paramAnonymousView.HtX.removeAllViews();
              paramAnonymousView.HtX = null;
            }
            paramAnonymousView.mView = null;
          }
          catch (Exception paramAnonymousView)
          {
            label103:
            break label103;
          }
          d.fhY();
          AppMethodBeat.o(33839);
        }
      });
      this.dkN = ((ProgressBar)paramView.findViewById(2131302644));
      this.dkN.setVisibility(8);
      this.context = paramContext;
      this.HtZ = new WindowManager.LayoutParams();
      this.HtZ.height = -2;
      this.HtZ.width = -2;
      this.HtY = ((WindowManager)paramContext.getSystemService("window"));
      this.HtZ.x = 0;
      this.HtZ.y = 0;
      this.HtZ.flags = 40;
      this.HtZ.type = 2002;
      this.mView = paramView;
      this.toC.setVisibility(8);
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
          AppMethodBeat.i(33841);
          switch (paramAnonymousMotionEvent.getAction())
          {
          }
          for (;;)
          {
            AppMethodBeat.o(33841);
            return false;
            this.Huc = ((int)paramAnonymousMotionEvent.getRawX() - d.a.this.HtZ.x);
            this.Hud = ((int)paramAnonymousMotionEvent.getRawY() - d.a.this.HtZ.y);
            this.Hug = System.currentTimeMillis();
            continue;
            this.Hue = (paramContext.widthPixels - d.a.this.HtZ.width - 1);
            this.Huf = (paramContext.heightPixels - d.a.this.HtZ.height - 1);
            d.a.this.HtZ.x = ((int)paramAnonymousMotionEvent.getRawX() - this.Huc);
            d.a.this.HtZ.y = ((int)paramAnonymousMotionEvent.getRawY() - this.Hud);
            paramAnonymousView = d.a.this.HtZ;
            if (d.a.this.HtZ.x < 0)
            {
              i = 0;
              label204:
              paramAnonymousView.x = i;
              paramAnonymousView = d.a.this.HtZ;
              if (d.a.this.HtZ.x <= this.Hue) {
                break label350;
              }
              i = this.Hue;
              label239:
              paramAnonymousView.x = i;
              paramAnonymousView = d.a.this.HtZ;
              if (d.a.this.HtZ.y >= 0) {
                break label364;
              }
              i = 0;
              label267:
              paramAnonymousView.y = i;
              paramAnonymousView = d.a.this.HtZ;
              if (d.a.this.HtZ.y <= this.Huf) {
                break label378;
              }
            }
            label350:
            label364:
            label378:
            for (int i = this.Huf;; i = d.a.this.HtZ.y)
            {
              paramAnonymousView.y = i;
              d.a.this.HtY.updateViewLayout(d.a.this.HtX, d.a.this.HtZ);
              break;
              i = d.a.this.HtZ.x;
              break label204;
              i = d.a.this.HtZ.x;
              break label239;
              i = d.a.this.HtZ.y;
              break label267;
            }
            if (System.currentTimeMillis() - this.Hug < 300L)
            {
              paramAnonymousView = d.a.this;
              paramAnonymousView.Huu.removeMessages(0);
              paramAnonymousView.rDB = 0;
              if (!paramAnonymousView.Hur) {
                break;
              }
              paramAnonymousView.dkN.setVisibility(0);
              paramAnonymousView.dkL.setVisibility(4);
              if (!com.tencent.mm.cj.d.feq().b(paramAnonymousView.Hut)) {
                paramAnonymousView.jQ(paramAnonymousView.context);
              }
            }
          }
          paramAnonymousView.dkL.setVisibility(0);
          paramAnonymousView.dkL.setBackgroundDrawable(paramAnonymousView.context.getResources().getDrawable(2131234419));
          if (!paramAnonymousView.Hur) {}
          for (boolean bool = true;; bool = false)
          {
            paramAnonymousView.Hur = bool;
            paramAnonymousView.Hut = new com.tencent.mm.cj.d.a(null, 6, 8, 0);
            com.tencent.mm.cj.d.feq().c(paramAnonymousView.Hut);
            paramAnonymousView.fhZ();
            break;
          }
        }
      });
      AppMethodBeat.o(33843);
    }
    
    final void fhZ()
    {
      AppMethodBeat.i(33845);
      this.toC.setText(this.rDB);
      this.Huu.sendEmptyMessageDelayed(0, 1000L);
      AppMethodBeat.o(33845);
    }
    
    final void jQ(Context paramContext)
    {
      boolean bool = false;
      AppMethodBeat.i(33844);
      this.dkL.setVisibility(0);
      this.dkN.setVisibility(4);
      if (!this.Hur) {
        bool = true;
      }
      this.Hur = bool;
      this.dkL.setBackgroundDrawable(paramContext.getResources().getDrawable(2131234418));
      this.toC.setVisibility(8);
      AppMethodBeat.o(33844);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.applet.d
 * JD-Core Version:    0.7.0.1
 */
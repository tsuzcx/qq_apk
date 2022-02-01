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
import com.tencent.mm.ci.d.b;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.lang.ref.WeakReference;

public final class d
{
  private static int ONJ = 0;
  
  public static void jZ(Context paramContext)
  {
    AppMethodBeat.i(33846);
    if (ONJ > 0)
    {
      AppMethodBeat.o(33846);
      return;
    }
    paramContext = new a(paramContext, LayoutInflater.from(paramContext).inflate(2131496758, null));
    paramContext.ONr.addView(paramContext.ONq, paramContext.ONs);
    ONJ += 1;
    AppMethodBeat.o(33846);
  }
  
  public static final class a
  {
    boolean ONK;
    d.b ONL;
    com.tencent.mm.ci.d.a ONM;
    MMHandler ONN;
    FrameLayout ONq;
    WindowManager ONr;
    WindowManager.LayoutParams ONs;
    private ViewGroup.LayoutParams ONt;
    Context context;
    ImageView dPk;
    ProgressBar dPm;
    View mView;
    TextView pwO;
    int vDO;
    
    public a(final Context paramContext, View paramView)
    {
      AppMethodBeat.i(33843);
      this.ONK = false;
      this.ONL = new d.b()
      {
        public final void gGo()
        {
          AppMethodBeat.i(33838);
          d.a.this.ka(d.a.this.context);
          Toast.makeText(d.a.this.context, "trace file has saved ", 0).show();
          AppMethodBeat.o(33838);
        }
      };
      this.vDO = 0;
      this.ONN = new MMHandler()
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(33842);
          if (d.a.this.pwO.getVisibility() != 0)
          {
            d.a.this.vDO = 0;
            AppMethodBeat.o(33842);
            return;
          }
          d.a locala = d.a.this;
          locala.vDO += 1;
          d.a.this.gKp();
          super.handleMessage(paramAnonymousMessage);
          AppMethodBeat.o(33842);
        }
      };
      if ((this.ONq != null) && (this.ONr != null))
      {
        AppMethodBeat.o(33843);
        return;
      }
      com.tencent.mm.ci.d.gGm().Owi = new WeakReference(this.ONL);
      this.pwO = ((TextView)paramView.findViewById(2131309086));
      this.dPk = ((ImageView)paramView.findViewById(2131297893));
      ((ImageView)paramView.findViewById(2131299491)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(33839);
          b localb = new b();
          localb.bm(paramAnonymousView);
          a.b("com/tencent/mm/ui/applet/TraceViewController$TraceView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if ((d.a.this.ONK) && (d.a.this.dPm.getVisibility() != 0)) {
            com.tencent.mm.ci.d.gGm().b(d.a.this.ONM);
          }
          paramAnonymousView = d.a.this;
          try
          {
            if (paramAnonymousView.ONr != null)
            {
              if (paramAnonymousView.ONq != null) {
                paramAnonymousView.ONr.removeView(paramAnonymousView.ONq);
              }
              paramAnonymousView.ONr = null;
            }
            if (paramAnonymousView.ONq != null)
            {
              paramAnonymousView.ONq.removeAllViews();
              paramAnonymousView.ONq = null;
            }
            paramAnonymousView.mView = null;
          }
          catch (Exception paramAnonymousView)
          {
            label132:
            break label132;
          }
          d.gKo();
          a.a(this, "com/tencent/mm/ui/applet/TraceViewController$TraceView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(33839);
        }
      });
      this.dPm = ((ProgressBar)paramView.findViewById(2131305192));
      this.dPm.setVisibility(8);
      this.context = paramContext;
      this.ONs = new WindowManager.LayoutParams();
      this.ONs.height = -2;
      this.ONs.width = -2;
      this.ONr = ((WindowManager)paramContext.getSystemService("window"));
      this.ONs.x = 0;
      this.ONs.y = 0;
      this.ONs.flags = 40;
      this.ONs.type = 2002;
      this.mView = paramView;
      this.pwO.setVisibility(8);
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
          AppMethodBeat.i(33841);
          switch (paramAnonymousMotionEvent.getAction())
          {
          }
          for (;;)
          {
            AppMethodBeat.o(33841);
            return false;
            this.ONv = ((int)paramAnonymousMotionEvent.getRawX() - d.a.this.ONs.x);
            this.ONw = ((int)paramAnonymousMotionEvent.getRawY() - d.a.this.ONs.y);
            this.ONz = System.currentTimeMillis();
            continue;
            this.ONx = (paramContext.widthPixels - d.a.this.ONs.width - 1);
            this.ONy = (paramContext.heightPixels - d.a.this.ONs.height - 1);
            d.a.this.ONs.x = ((int)paramAnonymousMotionEvent.getRawX() - this.ONv);
            d.a.this.ONs.y = ((int)paramAnonymousMotionEvent.getRawY() - this.ONw);
            paramAnonymousView = d.a.this.ONs;
            if (d.a.this.ONs.x < 0)
            {
              i = 0;
              label204:
              paramAnonymousView.x = i;
              paramAnonymousView = d.a.this.ONs;
              if (d.a.this.ONs.x <= this.ONx) {
                break label350;
              }
              i = this.ONx;
              label239:
              paramAnonymousView.x = i;
              paramAnonymousView = d.a.this.ONs;
              if (d.a.this.ONs.y >= 0) {
                break label364;
              }
              i = 0;
              label267:
              paramAnonymousView.y = i;
              paramAnonymousView = d.a.this.ONs;
              if (d.a.this.ONs.y <= this.ONy) {
                break label378;
              }
            }
            label350:
            label364:
            label378:
            for (int i = this.ONy;; i = d.a.this.ONs.y)
            {
              paramAnonymousView.y = i;
              d.a.this.ONr.updateViewLayout(d.a.this.ONq, d.a.this.ONs);
              break;
              i = d.a.this.ONs.x;
              break label204;
              i = d.a.this.ONs.x;
              break label239;
              i = d.a.this.ONs.y;
              break label267;
            }
            if (System.currentTimeMillis() - this.ONz < 300L)
            {
              paramAnonymousView = d.a.this;
              paramAnonymousView.ONN.removeMessages(0);
              paramAnonymousView.vDO = 0;
              if (!paramAnonymousView.ONK) {
                break;
              }
              paramAnonymousView.dPm.setVisibility(0);
              paramAnonymousView.dPk.setVisibility(4);
              if (!com.tencent.mm.ci.d.gGm().b(paramAnonymousView.ONM)) {
                paramAnonymousView.ka(paramAnonymousView.context);
              }
            }
          }
          paramAnonymousView.dPk.setVisibility(0);
          paramAnonymousView.dPk.setBackgroundDrawable(paramAnonymousView.context.getResources().getDrawable(2131235344));
          if (!paramAnonymousView.ONK) {}
          for (boolean bool = true;; bool = false)
          {
            paramAnonymousView.ONK = bool;
            paramAnonymousView.ONM = new com.tencent.mm.ci.d.a(null, 6, 8, 0);
            com.tencent.mm.ci.d.gGm().c(paramAnonymousView.ONM);
            paramAnonymousView.gKp();
            break;
          }
        }
      });
      AppMethodBeat.o(33843);
    }
    
    final void gKp()
    {
      AppMethodBeat.i(33845);
      this.pwO.setText(this.vDO);
      this.ONN.sendEmptyMessageDelayed(0, 1000L);
      AppMethodBeat.o(33845);
    }
    
    final void ka(Context paramContext)
    {
      boolean bool = false;
      AppMethodBeat.i(33844);
      this.dPk.setVisibility(0);
      this.dPm.setVisibility(4);
      if (!this.ONK) {
        bool = true;
      }
      this.ONK = bool;
      this.dPk.setBackgroundDrawable(paramContext.getResources().getDrawable(2131235343));
      this.pwO.setVisibility(8);
      AppMethodBeat.o(33844);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.applet.d
 * JD-Core Version:    0.7.0.1
 */
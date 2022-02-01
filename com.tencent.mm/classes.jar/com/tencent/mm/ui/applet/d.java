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
import com.tencent.mm.sdk.platformtools.aq;
import java.lang.ref.WeakReference;

public final class d
{
  private static int JCR = 0;
  
  public static void kh(Context paramContext)
  {
    AppMethodBeat.i(33846);
    if (JCR > 0)
    {
      AppMethodBeat.o(33846);
      return;
    }
    paramContext = new a(paramContext, LayoutInflater.from(paramContext).inflate(2131495800, null));
    paramContext.JCz.addView(paramContext.JCy, paramContext.JCA);
    JCR += 1;
    AppMethodBeat.o(33846);
  }
  
  public static final class a
  {
    WindowManager.LayoutParams JCA;
    private ViewGroup.LayoutParams JCB;
    boolean JCS;
    d.b JCT;
    com.tencent.mm.ci.d.a JCU;
    aq JCV;
    FrameLayout JCy;
    WindowManager JCz;
    Context context;
    ImageView dxD;
    ProgressBar dxF;
    View mView;
    TextView okL;
    int sJc;
    
    public a(final Context paramContext, View paramView)
    {
      AppMethodBeat.i(33843);
      this.JCS = false;
      this.JCT = new d.b()
      {
        public final void fyA()
        {
          AppMethodBeat.i(33838);
          d.a.this.ki(d.a.this.context);
          Toast.makeText(d.a.this.context, "trace file has saved ", 0).show();
          AppMethodBeat.o(33838);
        }
      };
      this.sJc = 0;
      this.JCV = new aq()
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(33842);
          if (d.a.this.okL.getVisibility() != 0)
          {
            d.a.this.sJc = 0;
            AppMethodBeat.o(33842);
            return;
          }
          d.a locala = d.a.this;
          locala.sJc += 1;
          d.a.this.fCr();
          super.handleMessage(paramAnonymousMessage);
          AppMethodBeat.o(33842);
        }
      };
      if ((this.JCy != null) && (this.JCz != null))
      {
        AppMethodBeat.o(33843);
        return;
      }
      com.tencent.mm.ci.d.fyy().Jmp = new WeakReference(this.JCT);
      this.okL = ((TextView)paramView.findViewById(2131305811));
      this.dxD = ((ImageView)paramView.findViewById(2131297631));
      ((ImageView)paramView.findViewById(2131298992)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(33839);
          b localb = new b();
          localb.bd(paramAnonymousView);
          a.b("com/tencent/mm/ui/applet/TraceViewController$TraceView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if ((d.a.this.JCS) && (d.a.this.dxF.getVisibility() != 0)) {
            com.tencent.mm.ci.d.fyy().b(d.a.this.JCU);
          }
          paramAnonymousView = d.a.this;
          try
          {
            if (paramAnonymousView.JCz != null)
            {
              if (paramAnonymousView.JCy != null) {
                paramAnonymousView.JCz.removeView(paramAnonymousView.JCy);
              }
              paramAnonymousView.JCz = null;
            }
            if (paramAnonymousView.JCy != null)
            {
              paramAnonymousView.JCy.removeAllViews();
              paramAnonymousView.JCy = null;
            }
            paramAnonymousView.mView = null;
          }
          catch (Exception paramAnonymousView)
          {
            label132:
            break label132;
          }
          d.fCq();
          a.a(this, "com/tencent/mm/ui/applet/TraceViewController$TraceView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(33839);
        }
      });
      this.dxF = ((ProgressBar)paramView.findViewById(2131302644));
      this.dxF.setVisibility(8);
      this.context = paramContext;
      this.JCA = new WindowManager.LayoutParams();
      this.JCA.height = -2;
      this.JCA.width = -2;
      this.JCz = ((WindowManager)paramContext.getSystemService("window"));
      this.JCA.x = 0;
      this.JCA.y = 0;
      this.JCA.flags = 40;
      this.JCA.type = 2002;
      this.mView = paramView;
      this.okL.setVisibility(8);
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
          AppMethodBeat.i(33841);
          b localb = new b();
          localb.bd(paramAnonymousView);
          localb.bd(paramAnonymousMotionEvent);
          a.b("com/tencent/mm/ui/applet/TraceViewController$TraceView$3", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
          switch (paramAnonymousMotionEvent.getAction())
          {
          }
          for (;;)
          {
            a.a(false, this, "com/tencent/mm/ui/applet/TraceViewController$TraceView$3", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(33841);
            return false;
            this.JCD = ((int)paramAnonymousMotionEvent.getRawX() - d.a.this.JCA.x);
            this.JCE = ((int)paramAnonymousMotionEvent.getRawY() - d.a.this.JCA.y);
            this.JCH = System.currentTimeMillis();
            continue;
            this.JCF = (paramContext.widthPixels - d.a.this.JCA.width - 1);
            this.JCG = (paramContext.heightPixels - d.a.this.JCA.height - 1);
            d.a.this.JCA.x = ((int)paramAnonymousMotionEvent.getRawX() - this.JCD);
            d.a.this.JCA.y = ((int)paramAnonymousMotionEvent.getRawY() - this.JCE);
            paramAnonymousView = d.a.this.JCA;
            if (d.a.this.JCA.x < 0)
            {
              i = 0;
              label253:
              paramAnonymousView.x = i;
              paramAnonymousView = d.a.this.JCA;
              if (d.a.this.JCA.x <= this.JCF) {
                break label399;
              }
              i = this.JCF;
              label288:
              paramAnonymousView.x = i;
              paramAnonymousView = d.a.this.JCA;
              if (d.a.this.JCA.y >= 0) {
                break label413;
              }
              i = 0;
              label316:
              paramAnonymousView.y = i;
              paramAnonymousView = d.a.this.JCA;
              if (d.a.this.JCA.y <= this.JCG) {
                break label427;
              }
            }
            label399:
            label413:
            label427:
            for (int i = this.JCG;; i = d.a.this.JCA.y)
            {
              paramAnonymousView.y = i;
              d.a.this.JCz.updateViewLayout(d.a.this.JCy, d.a.this.JCA);
              break;
              i = d.a.this.JCA.x;
              break label253;
              i = d.a.this.JCA.x;
              break label288;
              i = d.a.this.JCA.y;
              break label316;
            }
            if (System.currentTimeMillis() - this.JCH < 300L)
            {
              paramAnonymousView = d.a.this;
              paramAnonymousView.JCV.removeMessages(0);
              paramAnonymousView.sJc = 0;
              if (!paramAnonymousView.JCS) {
                break;
              }
              paramAnonymousView.dxF.setVisibility(0);
              paramAnonymousView.dxD.setVisibility(4);
              if (!com.tencent.mm.ci.d.fyy().b(paramAnonymousView.JCU)) {
                paramAnonymousView.ki(paramAnonymousView.context);
              }
            }
          }
          paramAnonymousView.dxD.setVisibility(0);
          paramAnonymousView.dxD.setBackgroundDrawable(paramAnonymousView.context.getResources().getDrawable(2131234419));
          if (!paramAnonymousView.JCS) {}
          for (boolean bool = true;; bool = false)
          {
            paramAnonymousView.JCS = bool;
            paramAnonymousView.JCU = new com.tencent.mm.ci.d.a(null, 6, 8, 0);
            com.tencent.mm.ci.d.fyy().c(paramAnonymousView.JCU);
            paramAnonymousView.fCr();
            break;
          }
        }
      });
      AppMethodBeat.o(33843);
    }
    
    final void fCr()
    {
      AppMethodBeat.i(33845);
      this.okL.setText(this.sJc);
      this.JCV.sendEmptyMessageDelayed(0, 1000L);
      AppMethodBeat.o(33845);
    }
    
    final void ki(Context paramContext)
    {
      boolean bool = false;
      AppMethodBeat.i(33844);
      this.dxD.setVisibility(0);
      this.dxF.setVisibility(4);
      if (!this.JCS) {
        bool = true;
      }
      this.JCS = bool;
      this.dxD.setBackgroundDrawable(paramContext.getResources().getDrawable(2131234418));
      this.okL.setVisibility(8);
      AppMethodBeat.o(33844);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.applet.d
 * JD-Core Version:    0.7.0.1
 */
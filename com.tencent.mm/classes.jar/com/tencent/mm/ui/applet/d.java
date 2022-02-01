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
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ap;
import java.lang.ref.WeakReference;

public final class d
{
  private static int Jig = 0;
  
  public static void ka(Context paramContext)
  {
    AppMethodBeat.i(33846);
    if (Jig > 0)
    {
      AppMethodBeat.o(33846);
      return;
    }
    paramContext = new a(paramContext, LayoutInflater.from(paramContext).inflate(2131495800, null));
    paramContext.JhO.addView(paramContext.JhN, paramContext.JhP);
    Jig += 1;
    AppMethodBeat.o(33846);
  }
  
  public static final class a
  {
    FrameLayout JhN;
    WindowManager JhO;
    WindowManager.LayoutParams JhP;
    private ViewGroup.LayoutParams JhQ;
    boolean Jih;
    d.b Jii;
    com.tencent.mm.cj.d.a Jij;
    ap Jik;
    Context context;
    ProgressBar dwA;
    ImageView dwy;
    View mView;
    int syl;
    TextView umZ;
    
    public a(final Context paramContext, View paramView)
    {
      AppMethodBeat.i(33843);
      this.Jih = false;
      this.Jii = new d.b()
      {
        public final void fuz()
        {
          AppMethodBeat.i(33838);
          d.a.this.kb(d.a.this.context);
          Toast.makeText(d.a.this.context, "trace file has saved ", 0).show();
          AppMethodBeat.o(33838);
        }
      };
      this.syl = 0;
      this.Jik = new ap()
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(33842);
          if (d.a.this.umZ.getVisibility() != 0)
          {
            d.a.this.syl = 0;
            AppMethodBeat.o(33842);
            return;
          }
          d.a locala = d.a.this;
          locala.syl += 1;
          d.a.this.fyp();
          super.handleMessage(paramAnonymousMessage);
          AppMethodBeat.o(33842);
        }
      };
      if ((this.JhN != null) && (this.JhO != null))
      {
        AppMethodBeat.o(33843);
        return;
      }
      com.tencent.mm.cj.d.fux().IRH = new WeakReference(this.Jii);
      this.umZ = ((TextView)paramView.findViewById(2131305811));
      this.dwy = ((ImageView)paramView.findViewById(2131297631));
      ((ImageView)paramView.findViewById(2131298992)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(33839);
          b localb = new b();
          localb.bd(paramAnonymousView);
          a.b("com/tencent/mm/ui/applet/TraceViewController$TraceView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          if ((d.a.this.Jih) && (d.a.this.dwA.getVisibility() != 0)) {
            com.tencent.mm.cj.d.fux().b(d.a.this.Jij);
          }
          paramAnonymousView = d.a.this;
          try
          {
            if (paramAnonymousView.JhO != null)
            {
              if (paramAnonymousView.JhN != null) {
                paramAnonymousView.JhO.removeView(paramAnonymousView.JhN);
              }
              paramAnonymousView.JhO = null;
            }
            if (paramAnonymousView.JhN != null)
            {
              paramAnonymousView.JhN.removeAllViews();
              paramAnonymousView.JhN = null;
            }
            paramAnonymousView.mView = null;
          }
          catch (Exception paramAnonymousView)
          {
            label132:
            break label132;
          }
          d.fyo();
          a.a(this, "com/tencent/mm/ui/applet/TraceViewController$TraceView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(33839);
        }
      });
      this.dwA = ((ProgressBar)paramView.findViewById(2131302644));
      this.dwA.setVisibility(8);
      this.context = paramContext;
      this.JhP = new WindowManager.LayoutParams();
      this.JhP.height = -2;
      this.JhP.width = -2;
      this.JhO = ((WindowManager)paramContext.getSystemService("window"));
      this.JhP.x = 0;
      this.JhP.y = 0;
      this.JhP.flags = 40;
      this.JhP.type = 2002;
      this.mView = paramView;
      this.umZ.setVisibility(8);
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
          AppMethodBeat.i(33841);
          b localb = new b();
          localb.bd(paramAnonymousView);
          localb.bd(paramAnonymousMotionEvent);
          a.b("com/tencent/mm/ui/applet/TraceViewController$TraceView$3", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
          switch (paramAnonymousMotionEvent.getAction())
          {
          }
          for (;;)
          {
            a.a(false, this, "com/tencent/mm/ui/applet/TraceViewController$TraceView$3", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(33841);
            return false;
            this.JhS = ((int)paramAnonymousMotionEvent.getRawX() - d.a.this.JhP.x);
            this.JhT = ((int)paramAnonymousMotionEvent.getRawY() - d.a.this.JhP.y);
            this.JhW = System.currentTimeMillis();
            continue;
            this.JhU = (paramContext.widthPixels - d.a.this.JhP.width - 1);
            this.JhV = (paramContext.heightPixels - d.a.this.JhP.height - 1);
            d.a.this.JhP.x = ((int)paramAnonymousMotionEvent.getRawX() - this.JhS);
            d.a.this.JhP.y = ((int)paramAnonymousMotionEvent.getRawY() - this.JhT);
            paramAnonymousView = d.a.this.JhP;
            if (d.a.this.JhP.x < 0)
            {
              i = 0;
              label253:
              paramAnonymousView.x = i;
              paramAnonymousView = d.a.this.JhP;
              if (d.a.this.JhP.x <= this.JhU) {
                break label399;
              }
              i = this.JhU;
              label288:
              paramAnonymousView.x = i;
              paramAnonymousView = d.a.this.JhP;
              if (d.a.this.JhP.y >= 0) {
                break label413;
              }
              i = 0;
              label316:
              paramAnonymousView.y = i;
              paramAnonymousView = d.a.this.JhP;
              if (d.a.this.JhP.y <= this.JhV) {
                break label427;
              }
            }
            label399:
            label413:
            label427:
            for (int i = this.JhV;; i = d.a.this.JhP.y)
            {
              paramAnonymousView.y = i;
              d.a.this.JhO.updateViewLayout(d.a.this.JhN, d.a.this.JhP);
              break;
              i = d.a.this.JhP.x;
              break label253;
              i = d.a.this.JhP.x;
              break label288;
              i = d.a.this.JhP.y;
              break label316;
            }
            if (System.currentTimeMillis() - this.JhW < 300L)
            {
              paramAnonymousView = d.a.this;
              paramAnonymousView.Jik.removeMessages(0);
              paramAnonymousView.syl = 0;
              if (!paramAnonymousView.Jih) {
                break;
              }
              paramAnonymousView.dwA.setVisibility(0);
              paramAnonymousView.dwy.setVisibility(4);
              if (!com.tencent.mm.cj.d.fux().b(paramAnonymousView.Jij)) {
                paramAnonymousView.kb(paramAnonymousView.context);
              }
            }
          }
          paramAnonymousView.dwy.setVisibility(0);
          paramAnonymousView.dwy.setBackgroundDrawable(paramAnonymousView.context.getResources().getDrawable(2131234419));
          if (!paramAnonymousView.Jih) {}
          for (boolean bool = true;; bool = false)
          {
            paramAnonymousView.Jih = bool;
            paramAnonymousView.Jij = new com.tencent.mm.cj.d.a(null, 6, 8, 0);
            com.tencent.mm.cj.d.fux().c(paramAnonymousView.Jij);
            paramAnonymousView.fyp();
            break;
          }
        }
      });
      AppMethodBeat.o(33843);
    }
    
    final void fyp()
    {
      AppMethodBeat.i(33845);
      this.umZ.setText(this.syl);
      this.Jik.sendEmptyMessageDelayed(0, 1000L);
      AppMethodBeat.o(33845);
    }
    
    final void kb(Context paramContext)
    {
      boolean bool = false;
      AppMethodBeat.i(33844);
      this.dwy.setVisibility(0);
      this.dwA.setVisibility(4);
      if (!this.Jih) {
        bool = true;
      }
      this.Jih = bool;
      this.dwy.setBackgroundDrawable(paramContext.getResources().getDrawable(2131234418));
      this.umZ.setVisibility(8);
      AppMethodBeat.o(33844);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.applet.d
 * JD-Core Version:    0.7.0.1
 */
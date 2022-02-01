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
import com.tencent.mm.ck.d.b;
import com.tencent.mm.sdk.platformtools.ap;
import java.lang.ref.WeakReference;

public final class d
{
  private static int FUB = 0;
  
  public static void jE(Context paramContext)
  {
    AppMethodBeat.i(33846);
    if (FUB > 0)
    {
      AppMethodBeat.o(33846);
      return;
    }
    paramContext = new a(paramContext, LayoutInflater.from(paramContext).inflate(2131495800, null));
    paramContext.FUj.addView(paramContext.FUi, paramContext.FUk);
    FUB += 1;
    AppMethodBeat.o(33846);
  }
  
  public static final class a
  {
    boolean FUC;
    d.b FUD;
    com.tencent.mm.ck.d.a FUE;
    int FUF;
    ap FUG;
    FrameLayout FUi;
    WindowManager FUj;
    WindowManager.LayoutParams FUk;
    private ViewGroup.LayoutParams FUl;
    Context context;
    ImageView dnd;
    ProgressBar dnf;
    View mView;
    TextView sgI;
    
    public a(final Context paramContext, View paramView)
    {
      AppMethodBeat.i(33843);
      this.FUC = false;
      this.FUD = new d.b()
      {
        public final void eOO()
        {
          AppMethodBeat.i(33838);
          d.a.this.jF(d.a.this.context);
          Toast.makeText(d.a.this.context, "trace file has saved ", 0).show();
          AppMethodBeat.o(33838);
        }
      };
      this.FUF = 0;
      this.FUG = new ap()
      {
        public final void handleMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(33842);
          if (d.a.this.sgI.getVisibility() != 0)
          {
            d.a.this.FUF = 0;
            AppMethodBeat.o(33842);
            return;
          }
          d.a locala = d.a.this;
          locala.FUF += 1;
          d.a.this.eSp();
          super.handleMessage(paramAnonymousMessage);
          AppMethodBeat.o(33842);
        }
      };
      if ((this.FUi != null) && (this.FUj != null))
      {
        AppMethodBeat.o(33843);
        return;
      }
      com.tencent.mm.ck.d.eOM().FFo = new WeakReference(this.FUD);
      this.sgI = ((TextView)paramView.findViewById(2131305811));
      this.dnd = ((ImageView)paramView.findViewById(2131297631));
      ((ImageView)paramView.findViewById(2131298992)).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(33839);
          if ((d.a.this.FUC) && (d.a.this.dnf.getVisibility() != 0)) {
            com.tencent.mm.ck.d.eOM().b(d.a.this.FUE);
          }
          paramAnonymousView = d.a.this;
          try
          {
            if (paramAnonymousView.FUj != null)
            {
              if (paramAnonymousView.FUi != null) {
                paramAnonymousView.FUj.removeView(paramAnonymousView.FUi);
              }
              paramAnonymousView.FUj = null;
            }
            if (paramAnonymousView.FUi != null)
            {
              paramAnonymousView.FUi.removeAllViews();
              paramAnonymousView.FUi = null;
            }
            paramAnonymousView.mView = null;
          }
          catch (Exception paramAnonymousView)
          {
            label103:
            break label103;
          }
          d.eSo();
          AppMethodBeat.o(33839);
        }
      });
      this.dnf = ((ProgressBar)paramView.findViewById(2131302644));
      this.dnf.setVisibility(8);
      this.context = paramContext;
      this.FUk = new WindowManager.LayoutParams();
      this.FUk.height = -2;
      this.FUk.width = -2;
      this.FUj = ((WindowManager)paramContext.getSystemService("window"));
      this.FUk.x = 0;
      this.FUk.y = 0;
      this.FUk.flags = 40;
      this.FUk.type = 2002;
      this.mView = paramView;
      this.sgI.setVisibility(8);
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
          AppMethodBeat.i(33841);
          switch (paramAnonymousMotionEvent.getAction())
          {
          }
          for (;;)
          {
            AppMethodBeat.o(33841);
            return false;
            this.FUn = ((int)paramAnonymousMotionEvent.getRawX() - d.a.this.FUk.x);
            this.FUo = ((int)paramAnonymousMotionEvent.getRawY() - d.a.this.FUk.y);
            this.FUr = System.currentTimeMillis();
            continue;
            this.FUp = (paramContext.widthPixels - d.a.this.FUk.width - 1);
            this.FUq = (paramContext.heightPixels - d.a.this.FUk.height - 1);
            d.a.this.FUk.x = ((int)paramAnonymousMotionEvent.getRawX() - this.FUn);
            d.a.this.FUk.y = ((int)paramAnonymousMotionEvent.getRawY() - this.FUo);
            paramAnonymousView = d.a.this.FUk;
            if (d.a.this.FUk.x < 0)
            {
              i = 0;
              label204:
              paramAnonymousView.x = i;
              paramAnonymousView = d.a.this.FUk;
              if (d.a.this.FUk.x <= this.FUp) {
                break label350;
              }
              i = this.FUp;
              label239:
              paramAnonymousView.x = i;
              paramAnonymousView = d.a.this.FUk;
              if (d.a.this.FUk.y >= 0) {
                break label364;
              }
              i = 0;
              label267:
              paramAnonymousView.y = i;
              paramAnonymousView = d.a.this.FUk;
              if (d.a.this.FUk.y <= this.FUq) {
                break label378;
              }
            }
            label350:
            label364:
            label378:
            for (int i = this.FUq;; i = d.a.this.FUk.y)
            {
              paramAnonymousView.y = i;
              d.a.this.FUj.updateViewLayout(d.a.this.FUi, d.a.this.FUk);
              break;
              i = d.a.this.FUk.x;
              break label204;
              i = d.a.this.FUk.x;
              break label239;
              i = d.a.this.FUk.y;
              break label267;
            }
            if (System.currentTimeMillis() - this.FUr < 300L)
            {
              paramAnonymousView = d.a.this;
              paramAnonymousView.FUG.removeMessages(0);
              paramAnonymousView.FUF = 0;
              if (!paramAnonymousView.FUC) {
                break;
              }
              paramAnonymousView.dnf.setVisibility(0);
              paramAnonymousView.dnd.setVisibility(4);
              if (!com.tencent.mm.ck.d.eOM().b(paramAnonymousView.FUE)) {
                paramAnonymousView.jF(paramAnonymousView.context);
              }
            }
          }
          paramAnonymousView.dnd.setVisibility(0);
          paramAnonymousView.dnd.setBackgroundDrawable(paramAnonymousView.context.getResources().getDrawable(2131234419));
          if (!paramAnonymousView.FUC) {}
          for (boolean bool = true;; bool = false)
          {
            paramAnonymousView.FUC = bool;
            paramAnonymousView.FUE = new com.tencent.mm.ck.d.a(null, 6, 8, 0);
            com.tencent.mm.ck.d.eOM().c(paramAnonymousView.FUE);
            paramAnonymousView.eSp();
            break;
          }
        }
      });
      AppMethodBeat.o(33843);
    }
    
    final void eSp()
    {
      AppMethodBeat.i(33845);
      this.sgI.setText(this.FUF);
      this.FUG.sendEmptyMessageDelayed(0, 1000L);
      AppMethodBeat.o(33845);
    }
    
    final void jF(Context paramContext)
    {
      boolean bool = false;
      AppMethodBeat.i(33844);
      this.dnd.setVisibility(0);
      this.dnf.setVisibility(4);
      if (!this.FUC) {
        bool = true;
      }
      this.FUC = bool;
      this.dnd.setBackgroundDrawable(paramContext.getResources().getDrawable(2131234418));
      this.sgI.setVisibility(8);
      AppMethodBeat.o(33844);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.applet.d
 * JD-Core Version:    0.7.0.1
 */
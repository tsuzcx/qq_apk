package com.tencent.mm.ui.widget.a;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetBehavior.a;
import android.support.design.widget.a;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private LinearLayout Jfq;
  private LinearLayout Jfr;
  private int Jge;
  private int Jgf;
  private LinearLayout Jgg;
  private Button Jgh;
  private Button Jgi;
  private Button Jgj;
  public LinearLayout Jgk;
  private TextView Jgl;
  private a Jgm;
  private a Jgn;
  public a Jgo;
  private ViewTreeObserver adE;
  private int iHV;
  public View khe;
  private Dialog lcA;
  private BottomSheetBehavior lcD;
  private boolean lcE;
  private int lcF;
  private boolean lcH;
  private Context mContext;
  private View oP;
  private boolean rVy;
  private boolean rVz;
  
  public g(Context paramContext)
  {
    AppMethodBeat.i(199689);
    this.lcE = false;
    this.rVz = false;
    this.lcH = false;
    this.Jge = 0;
    this.Jgf = 0;
    this.mContext = paramContext;
    this.Jge = 0;
    this.Jgf = 0;
    aM(this.mContext);
    AppMethodBeat.o(199689);
  }
  
  public g(Context paramContext, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(199690);
    this.lcE = false;
    this.rVz = false;
    this.lcH = false;
    this.Jge = 0;
    this.Jgf = 0;
    this.mContext = paramContext;
    this.Jge = paramInt1;
    this.Jgf = paramInt2;
    aM(this.mContext);
    AppMethodBeat.o(199690);
  }
  
  private void aM(Context paramContext)
  {
    AppMethodBeat.i(199693);
    if ((this.mContext instanceof Activity)) {
      this.oP = ((ViewGroup)((Activity)this.mContext).getWindow().getDecorView()).findViewById(16908290);
    }
    this.lcA = new a(paramContext, 2131820788);
    this.khe = View.inflate(paramContext, 2131494796, null);
    this.Jfq = ((LinearLayout)this.khe.findViewById(2131297466));
    this.Jfr = ((LinearLayout)this.khe.findViewById(2131297462));
    this.Jgk = ((LinearLayout)this.khe.findViewById(2131297461));
    fvy();
    initHeaderView();
    this.lcE = aly();
    this.lcA.setContentView(this.khe);
    this.lcD = BottomSheetBehavior.l((View)this.khe.getParent());
    this.lcD.setState(3);
    this.lcD.mp = new BottomSheetBehavior.a()
    {
      public final void N(int paramAnonymousInt) {}
      
      public final void l(float paramAnonymousFloat) {}
    };
    this.lcA.setOnDismissListener(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(199684);
        if (g.a(g.this) != null)
        {
          if (!g.a(g.this).isAlive()) {
            g.a(g.this, g.b(g.this).getViewTreeObserver());
          }
          g.a(g.this).removeGlobalOnLayoutListener(g.this);
          g.a(g.this, null);
        }
        if (!g.c(g.this)) {
          g.d(g.this);
        }
        AppMethodBeat.o(199684);
      }
    });
    AppMethodBeat.o(199693);
  }
  
  private boolean aly()
  {
    AppMethodBeat.i(199707);
    if (this.mContext.getResources().getConfiguration().orientation == 2)
    {
      AppMethodBeat.o(199707);
      return true;
    }
    AppMethodBeat.o(199707);
    return false;
  }
  
  @TargetApi(23)
  private void eFw()
  {
    AppMethodBeat.i(199701);
    if ((Build.VERSION.SDK_INT >= 23) && (this.lcA != null))
    {
      this.lcA.getWindow().getDecorView().setSystemUiVisibility(9216);
      this.lcA.getWindow().setStatusBarColor(0);
    }
    AppMethodBeat.o(199701);
  }
  
  private void fvv()
  {
    AppMethodBeat.i(199706);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.khe.getLayoutParams();
    if ((this.lcE) && (this.oP != null))
    {
      Rect localRect = new Rect();
      this.oP.getWindowVisibleDisplayFrame(localRect);
      localLayoutParams.width = localRect.right;
    }
    this.khe.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(199706);
  }
  
  private void fvy()
  {
    AppMethodBeat.i(199699);
    this.Jgg = ((LinearLayout)this.khe.findViewById(2131297590));
    this.Jgh = ((Button)this.khe.findViewById(2131297587));
    this.Jgi = ((Button)this.khe.findViewById(2131297588));
    this.Jgj = ((Button)this.khe.findViewById(2131297600));
    switch (this.Jge)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(199699);
      return;
      this.Jgg.setVisibility(8);
      AppMethodBeat.o(199699);
      return;
      this.Jgg.setVisibility(0);
      this.Jgj.setVisibility(8);
      this.Jgh.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(199685);
          if (g.e(g.this) != null) {
            g.e(g.this).onClick();
          }
          AppMethodBeat.o(199685);
        }
      });
      this.Jgi.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(199686);
          if (g.f(g.this) != null) {
            g.f(g.this).onClick();
          }
          AppMethodBeat.o(199686);
        }
      });
      AppMethodBeat.o(199699);
      return;
      this.Jgg.setVisibility(0);
      this.Jgh.setVisibility(8);
      this.Jgi.setVisibility(8);
      this.Jgj.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(199687);
          if (g.g(g.this) != null) {
            g.g(g.this).onClick();
          }
          AppMethodBeat.o(199687);
        }
      });
    }
  }
  
  private int getRotation()
  {
    AppMethodBeat.i(199692);
    int i = 0;
    if ((this.mContext instanceof Activity)) {
      i = ((Activity)this.mContext).getWindow().getWindowManager().getDefaultDisplay().getRotation();
    }
    AppMethodBeat.o(199692);
    return i;
  }
  
  private void initHeaderView()
  {
    AppMethodBeat.i(199700);
    if (this.Jfq != null)
    {
      this.Jfq.setVisibility(0);
      switch (this.Jgf)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(199700);
      return;
      this.Jfq.setVisibility(8);
      AppMethodBeat.o(199700);
      return;
      View localView = LayoutInflater.from(this.mContext).inflate(2131494428, null);
      localView.findViewById(2131298372).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(199688);
          g.this.bmi();
          AppMethodBeat.o(199688);
        }
      });
      this.Jfq.removeAllViews();
      this.Jfq.setGravity(17);
      this.Jfq.addView(localView, -1, -2);
      AppMethodBeat.o(199700);
      return;
      localView = LayoutInflater.from(this.mContext).inflate(2131494429, null);
      this.Jgl = ((TextView)localView.findViewById(2131305945));
      this.Jfq.removeAllViews();
      this.Jfq.setGravity(17);
      this.Jfq.addView(localView, -1, -2);
    }
  }
  
  public final void a(a parama1, a parama2)
  {
    this.Jgm = parama1;
    this.Jgn = parama2;
  }
  
  public final void acS(int paramInt)
  {
    AppMethodBeat.i(199697);
    if (this.Jgj != null) {
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(199697);
      return;
      this.Jgj.setBackgroundResource(2131231365);
      AppMethodBeat.o(199697);
      return;
      this.Jgj.setBackgroundResource(2131231367);
      this.Jgj.setTextColor(this.mContext.getResources().getColor(2131101180));
      AppMethodBeat.o(199697);
      return;
      this.Jgj.setBackgroundResource(2131231370);
      AppMethodBeat.o(199697);
      return;
      this.Jgj.setBackgroundResource(2131231375);
      AppMethodBeat.o(199697);
      return;
      this.Jgj.setBackgroundResource(2131231362);
      AppMethodBeat.o(199697);
      return;
      this.Jgj.setBackgroundResource(2131231368);
    }
  }
  
  public final void ax(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(199696);
    if (this.Jgj != null) {
      this.Jgj.setText(paramCharSequence);
    }
    AppMethodBeat.o(199696);
  }
  
  public final void bmi()
  {
    AppMethodBeat.i(199704);
    if (this.lcA != null)
    {
      if ((!(this.mContext instanceof Activity)) || ((this.mContext != null) && (!((Activity)this.mContext).isFinishing()) && (!((Activity)this.mContext).isDestroyed()))) {
        this.lcA.dismiss();
      }
      if (this.lcD != null) {
        this.lcD.mg = true;
      }
    }
    AppMethodBeat.o(199704);
  }
  
  public final void c(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    AppMethodBeat.i(199695);
    if ((this.Jgh != null) && (this.Jgi != null))
    {
      this.Jgh.setText(paramCharSequence1);
      this.Jgi.setText(paramCharSequence2);
    }
    AppMethodBeat.o(199695);
  }
  
  public final void cED()
  {
    AppMethodBeat.i(199703);
    this.lcE = aly();
    this.lcF = getRotation();
    if (this.lcA != null)
    {
      ((ViewGroup)this.khe.getParent()).setVisibility(0);
      fvv();
      if (Build.VERSION.SDK_INT >= 21) {
        this.lcA.getWindow().addFlags(-2147483648);
      }
      if (this.rVy) {
        eFw();
      }
      if (!this.lcH) {
        break label219;
      }
      this.lcA.getWindow().setFlags(8, 8);
      this.lcA.getWindow().addFlags(131200);
      this.lcA.getWindow().getDecorView().setSystemUiVisibility(6);
      if (this.oP != null) {
        if (this.adE != null) {
          break label274;
        }
      }
    }
    label274:
    for (int i = 1;; i = 0)
    {
      this.adE = this.oP.getViewTreeObserver();
      if (i != 0) {
        this.adE.addOnGlobalLayoutListener(this);
      }
      if (((this.mContext instanceof Activity)) && (!((Activity)this.mContext).isFinishing())) {
        this.lcA.show();
      }
      if (this.lcD != null) {
        this.lcD.mg = false;
      }
      AppMethodBeat.o(199703);
      return;
      label219:
      this.lcA.getWindow().clearFlags(8);
      this.lcA.getWindow().clearFlags(131072);
      this.lcA.getWindow().clearFlags(128);
      this.lcA.getWindow().getDecorView().setSystemUiVisibility(0);
      break;
    }
  }
  
  public final boolean isShowing()
  {
    AppMethodBeat.i(199705);
    if ((this.lcA != null) && (this.lcA.isShowing()))
    {
      AppMethodBeat.o(199705);
      return true;
    }
    AppMethodBeat.o(199705);
    return false;
  }
  
  public final void onGlobalLayout()
  {
    AppMethodBeat.i(199691);
    if (isShowing())
    {
      View localView = this.oP;
      if ((localView == null) || ((!localView.isShown()) && (localView.getVisibility() != 0)))
      {
        bmi();
        AppMethodBeat.o(199691);
        return;
      }
      if ((isShowing()) && ((this.lcE != aly()) || (this.lcF != getRotation()))) {
        bmi();
      }
    }
    AppMethodBeat.o(199691);
  }
  
  public final void setCustomView(View paramView)
  {
    AppMethodBeat.i(199702);
    if (this.Jgk != null)
    {
      this.Jgk.setVisibility(0);
      this.Jgk.removeAllViews();
      this.Jgk.setGravity(17);
      this.Jgk.addView(paramView, -1, -2);
    }
    AppMethodBeat.o(199702);
  }
  
  public final void setHeaderView(View paramView)
  {
    AppMethodBeat.i(199698);
    if (this.Jfq != null)
    {
      this.Jfq.setVisibility(0);
      this.Jfq.removeAllViews();
      this.Jfq.setGravity(17);
      this.Jfq.addView(paramView, -1, -2);
    }
    AppMethodBeat.o(199698);
  }
  
  public final void setHeight(int paramInt)
  {
    AppMethodBeat.i(199694);
    if (paramInt != 0)
    {
      this.iHV = paramInt;
      if (this.iHV != 0) {
        this.lcD.J(this.iHV);
      }
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.khe.getLayoutParams();
      localLayoutParams.height = paramInt;
      this.khe.setLayoutParams(localLayoutParams);
      this.khe.invalidate();
    }
    AppMethodBeat.o(199694);
  }
  
  public static abstract interface a
  {
    public abstract void onClick();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.a.g
 * JD-Core Version:    0.7.0.1
 */
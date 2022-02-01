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
import com.tencent.mm.hellhoundlib.b.b;

public final class g
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private LinearLayout KWD;
  private LinearLayout KWE;
  private a KXA;
  public a KXB;
  private int KXr;
  private int KXs;
  private LinearLayout KXt;
  private Button KXu;
  private Button KXv;
  private Button KXw;
  private LinearLayout KXx;
  private TextView KXy;
  private a KXz;
  private ViewTreeObserver afv;
  private int jbe;
  public View kBS;
  private Dialog lzA;
  private BottomSheetBehavior lzD;
  private boolean lzE;
  private int lzF;
  private boolean lzH;
  private Context mContext;
  private boolean ov;
  private View qI;
  private boolean sSh;
  private boolean sSi;
  
  public g(Context paramContext)
  {
    AppMethodBeat.i(192606);
    this.lzE = false;
    this.sSi = false;
    this.lzH = false;
    this.KXr = 0;
    this.KXs = 0;
    this.ov = true;
    this.mContext = paramContext;
    this.KXr = 0;
    this.KXs = 0;
    aM(this.mContext);
    AppMethodBeat.o(192606);
  }
  
  public g(Context paramContext, byte paramByte)
  {
    AppMethodBeat.i(192608);
    this.lzE = false;
    this.sSi = false;
    this.lzH = false;
    this.KXr = 0;
    this.KXs = 0;
    this.ov = true;
    this.mContext = paramContext;
    this.KXr = 1;
    this.KXs = 2;
    this.ov = false;
    aM(this.mContext);
    AppMethodBeat.o(192608);
  }
  
  public g(Context paramContext, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(192607);
    this.lzE = false;
    this.sSi = false;
    this.lzH = false;
    this.KXr = 0;
    this.KXs = 0;
    this.ov = true;
    this.mContext = paramContext;
    this.KXr = paramInt1;
    this.KXs = paramInt2;
    aM(this.mContext);
    AppMethodBeat.o(192607);
  }
  
  private void aM(Context paramContext)
  {
    AppMethodBeat.i(192611);
    if ((this.mContext instanceof Activity)) {
      this.qI = ((ViewGroup)((Activity)this.mContext).getWindow().getDecorView()).findViewById(16908290);
    }
    this.lzA = new android.support.design.widget.a(paramContext, 2131820788);
    this.kBS = View.inflate(paramContext, 2131494796, null);
    this.KWD = ((LinearLayout)this.kBS.findViewById(2131297466));
    this.KWE = ((LinearLayout)this.kBS.findViewById(2131297462));
    this.KXx = ((LinearLayout)this.kBS.findViewById(2131297461));
    fMm();
    initHeaderView();
    this.lzE = aol();
    this.lzA.setContentView(this.kBS);
    this.lzA.setCancelable(this.ov);
    this.lzD = BottomSheetBehavior.l((View)this.kBS.getParent());
    this.lzD.setState(3);
    this.lzD.oi = new BottomSheetBehavior.a()
    {
      public final void M(int paramAnonymousInt) {}
    };
    this.lzA.setOnDismissListener(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(192601);
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
        AppMethodBeat.o(192601);
      }
    });
    AppMethodBeat.o(192611);
  }
  
  private boolean aol()
  {
    AppMethodBeat.i(192629);
    if (this.mContext.getResources().getConfiguration().orientation == 2)
    {
      AppMethodBeat.o(192629);
      return true;
    }
    AppMethodBeat.o(192629);
    return false;
  }
  
  @TargetApi(23)
  private void eUs()
  {
    AppMethodBeat.i(192622);
    if ((Build.VERSION.SDK_INT >= 23) && (this.lzA != null))
    {
      this.lzA.getWindow().getDecorView().setSystemUiVisibility(9216);
      this.lzA.getWindow().setStatusBarColor(0);
    }
    AppMethodBeat.o(192622);
  }
  
  private void fMh()
  {
    AppMethodBeat.i(192628);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.kBS.getLayoutParams();
    if ((this.lzE) && (this.qI != null))
    {
      Rect localRect = new Rect();
      this.qI.getWindowVisibleDisplayFrame(localRect);
      localLayoutParams.width = localRect.right;
    }
    this.kBS.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(192628);
  }
  
  private void fMm()
  {
    AppMethodBeat.i(192620);
    this.KXt = ((LinearLayout)this.kBS.findViewById(2131297590));
    this.KXu = ((Button)this.kBS.findViewById(2131297587));
    this.KXv = ((Button)this.kBS.findViewById(2131297588));
    this.KXw = ((Button)this.kBS.findViewById(2131297600));
    switch (this.KXr)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(192620);
      return;
      this.KXt.setVisibility(8);
      AppMethodBeat.o(192620);
      return;
      this.KXt.setVisibility(0);
      this.KXw.setVisibility(8);
      this.KXu.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(192602);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/dialog/MMHalfBottomDialog$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          if (g.e(g.this) != null) {
            g.e(g.this).onClick();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/dialog/MMHalfBottomDialog$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(192602);
        }
      });
      this.KXv.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(192603);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/dialog/MMHalfBottomDialog$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          if (g.f(g.this) != null) {
            g.f(g.this).onClick();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/dialog/MMHalfBottomDialog$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(192603);
        }
      });
      AppMethodBeat.o(192620);
      return;
      this.KXt.setVisibility(0);
      this.KXu.setVisibility(8);
      this.KXv.setVisibility(8);
      this.KXw.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(192604);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/dialog/MMHalfBottomDialog$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          if (g.g(g.this) != null) {
            g.g(g.this).onClick();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/dialog/MMHalfBottomDialog$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(192604);
        }
      });
    }
  }
  
  private int getRotation()
  {
    AppMethodBeat.i(192610);
    int i = 0;
    if ((this.mContext instanceof Activity)) {
      i = ((Activity)this.mContext).getWindow().getWindowManager().getDefaultDisplay().getRotation();
    }
    AppMethodBeat.o(192610);
    return i;
  }
  
  private void initHeaderView()
  {
    AppMethodBeat.i(192621);
    if (this.KWD != null)
    {
      this.KWD.setVisibility(0);
      switch (this.KXs)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(192621);
      return;
      this.KWD.setVisibility(8);
      AppMethodBeat.o(192621);
      return;
      View localView = LayoutInflater.from(this.mContext).inflate(2131494428, null);
      localView.findViewById(2131298372).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(192605);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/dialog/MMHalfBottomDialog$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          g.this.bpT();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/dialog/MMHalfBottomDialog$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(192605);
        }
      });
      this.KWD.removeAllViews();
      this.KWD.setGravity(17);
      this.KWD.addView(localView, -1, -2);
      AppMethodBeat.o(192621);
      return;
      localView = LayoutInflater.from(this.mContext).inflate(2131494429, null);
      this.KXy = ((TextView)localView.findViewById(2131305945));
      this.KWD.removeAllViews();
      this.KWD.setGravity(17);
      this.KWD.addView(localView, -1, -2);
    }
  }
  
  public final void a(a parama1, a parama2)
  {
    this.KXz = parama1;
    this.KXA = parama2;
  }
  
  public final void afr(int paramInt)
  {
    AppMethodBeat.i(192614);
    if (this.KXu != null) {
      this.KXu.setTextColor(paramInt);
    }
    AppMethodBeat.o(192614);
  }
  
  public final void afs(int paramInt)
  {
    AppMethodBeat.i(192617);
    if (this.KXw != null) {
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(192617);
      return;
      this.KXw.setBackgroundResource(2131231365);
      AppMethodBeat.o(192617);
      return;
      this.KXw.setBackgroundResource(2131231367);
      this.KXw.setTextColor(this.mContext.getResources().getColor(2131101180));
      AppMethodBeat.o(192617);
      return;
      this.KXw.setBackgroundResource(2131231370);
      AppMethodBeat.o(192617);
      return;
      this.KXw.setBackgroundResource(2131231375);
      AppMethodBeat.o(192617);
      return;
      this.KXw.setBackgroundResource(2131231362);
      AppMethodBeat.o(192617);
      return;
      this.KXw.setBackgroundResource(2131231368);
    }
  }
  
  public final g aft(int paramInt)
  {
    AppMethodBeat.i(192623);
    if (this.KXx != null)
    {
      this.KXx.setVisibility(0);
      LayoutInflater.from(this.kBS.getContext()).inflate(paramInt, this.KXx, true);
    }
    AppMethodBeat.o(192623);
    return this;
  }
  
  public final void ax(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(192616);
    if (this.KXw != null) {
      this.KXw.setText(paramCharSequence);
    }
    AppMethodBeat.o(192616);
  }
  
  public final void ay(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(192618);
    if (this.KXy != null) {
      this.KXy.setText(paramCharSequence);
    }
    AppMethodBeat.o(192618);
  }
  
  public final void bpT()
  {
    AppMethodBeat.i(192626);
    if (this.lzA != null)
    {
      if ((!(this.mContext instanceof Activity)) || ((this.mContext != null) && (!((Activity)this.mContext).isFinishing()) && (!((Activity)this.mContext).isDestroyed()))) {
        this.lzA.dismiss();
      }
      if (this.lzD != null) {
        this.lzD.nZ = true;
      }
    }
    AppMethodBeat.o(192626);
  }
  
  public final void c(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    AppMethodBeat.i(192613);
    if ((this.KXu != null) && (this.KXv != null))
    {
      this.KXu.setText(paramCharSequence1);
      this.KXv.setText(paramCharSequence2);
    }
    AppMethodBeat.o(192613);
  }
  
  public final void cMW()
  {
    AppMethodBeat.i(192625);
    this.lzE = aol();
    this.lzF = getRotation();
    if (this.lzA != null)
    {
      ((ViewGroup)this.kBS.getParent()).setVisibility(0);
      fMh();
      if (Build.VERSION.SDK_INT >= 21) {
        this.lzA.getWindow().addFlags(-2147483648);
      }
      if (this.sSh) {
        eUs();
      }
      if (!this.lzH) {
        break label219;
      }
      this.lzA.getWindow().setFlags(8, 8);
      this.lzA.getWindow().addFlags(131200);
      this.lzA.getWindow().getDecorView().setSystemUiVisibility(6);
      if (this.qI != null) {
        if (this.afv != null) {
          break label274;
        }
      }
    }
    label274:
    for (int i = 1;; i = 0)
    {
      this.afv = this.qI.getViewTreeObserver();
      if (i != 0) {
        this.afv.addOnGlobalLayoutListener(this);
      }
      if (((this.mContext instanceof Activity)) && (!((Activity)this.mContext).isFinishing())) {
        this.lzA.show();
      }
      if (this.lzD != null) {
        this.lzD.nZ = false;
      }
      AppMethodBeat.o(192625);
      return;
      label219:
      this.lzA.getWindow().clearFlags(8);
      this.lzA.getWindow().clearFlags(131072);
      this.lzA.getWindow().clearFlags(128);
      this.lzA.getWindow().getDecorView().setSystemUiVisibility(0);
      break;
    }
  }
  
  public final void fMl()
  {
    AppMethodBeat.i(192615);
    if (this.KXv != null) {
      this.KXv.setBackgroundResource(2131231370);
    }
    AppMethodBeat.o(192615);
  }
  
  public final boolean isShowing()
  {
    AppMethodBeat.i(192627);
    if ((this.lzA != null) && (this.lzA.isShowing()))
    {
      AppMethodBeat.o(192627);
      return true;
    }
    AppMethodBeat.o(192627);
    return false;
  }
  
  public final void onGlobalLayout()
  {
    AppMethodBeat.i(192609);
    if (isShowing())
    {
      View localView = this.qI;
      if ((localView == null) || ((!localView.isShown()) && (localView.getVisibility() != 0)))
      {
        bpT();
        AppMethodBeat.o(192609);
        return;
      }
      if ((isShowing()) && ((this.lzE != aol()) || (this.lzF != getRotation()))) {
        bpT();
      }
    }
    AppMethodBeat.o(192609);
  }
  
  public final void setCustomView(View paramView)
  {
    AppMethodBeat.i(192624);
    if (this.KXx != null)
    {
      this.KXx.setVisibility(0);
      this.KXx.removeAllViews();
      this.KXx.setGravity(17);
      this.KXx.addView(paramView, -1, -2);
    }
    AppMethodBeat.o(192624);
  }
  
  public final void setHeaderView(View paramView)
  {
    AppMethodBeat.i(192619);
    if (this.KWD != null)
    {
      this.KWD.setVisibility(0);
      this.KWD.removeAllViews();
      this.KWD.setGravity(17);
      this.KWD.addView(paramView, -1, -2);
    }
    AppMethodBeat.o(192619);
  }
  
  public final void setHeight(int paramInt)
  {
    AppMethodBeat.i(192612);
    if (paramInt != 0)
    {
      this.jbe = paramInt;
      if (this.jbe != 0) {
        this.lzD.J(this.jbe);
      }
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.kBS.getLayoutParams();
      localLayoutParams.height = paramInt;
      this.kBS.setLayoutParams(localLayoutParams);
      this.kBS.invalidate();
    }
    AppMethodBeat.o(192612);
  }
  
  public static abstract interface a
  {
    public abstract void onClick();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.a.g
 * JD-Core Version:    0.7.0.1
 */
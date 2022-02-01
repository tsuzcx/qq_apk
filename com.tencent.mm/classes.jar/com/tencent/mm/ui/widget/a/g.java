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
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;

public class g
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private int HMp;
  private int HMq;
  private LinearLayout HMr;
  private Button HMs;
  private Button HMt;
  private Button HMu;
  private LinearLayout HMv;
  private LinearLayout HMw;
  private LinearLayout HMx;
  private TextView HMy;
  private a QOR;
  private a QOS;
  public a QOT;
  private ViewTreeObserver afI;
  private int kca;
  public View lJI;
  private Context mContext;
  private Dialog mLH;
  private BottomSheetBehavior mLK;
  private boolean mLL;
  private int mLM;
  private boolean mLO;
  private boolean ox;
  private View qK;
  private boolean wjM;
  private boolean wjN;
  
  public g(Context paramContext)
  {
    AppMethodBeat.i(198255);
    this.mLL = false;
    this.wjN = false;
    this.mLO = false;
    this.HMp = 0;
    this.HMq = 0;
    this.ox = true;
    this.mContext = paramContext;
    this.HMp = 0;
    this.HMq = 0;
    bh(this.mContext);
    AppMethodBeat.o(198255);
  }
  
  public g(Context paramContext, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(198256);
    this.mLL = false;
    this.wjN = false;
    this.mLO = false;
    this.HMp = 0;
    this.HMq = 0;
    this.ox = true;
    this.mContext = paramContext;
    this.HMp = paramInt1;
    this.HMq = paramInt2;
    bh(this.mContext);
    AppMethodBeat.o(198256);
  }
  
  public g(Context paramContext, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(198257);
    this.mLL = false;
    this.wjN = false;
    this.mLO = false;
    this.HMp = 0;
    this.HMq = 0;
    this.ox = true;
    this.mContext = paramContext;
    this.HMp = paramInt1;
    this.HMq = paramInt2;
    this.ox = paramBoolean;
    bh(this.mContext);
    AppMethodBeat.o(198257);
  }
  
  private void bh(Context paramContext)
  {
    AppMethodBeat.i(198260);
    if ((this.mContext instanceof Activity)) {
      this.qK = ((ViewGroup)((Activity)this.mContext).getWindow().getDecorView()).findViewById(16908290);
    }
    this.mLH = new android.support.design.widget.a(paramContext, 2131820791);
    this.lJI = View.inflate(paramContext, 2131495530, null);
    this.HMv = ((LinearLayout)this.lJI.findViewById(2131297701));
    this.HMw = ((LinearLayout)this.lJI.findViewById(2131297696));
    this.HMx = ((LinearLayout)this.lJI.findViewById(2131297695));
    fPz();
    initHeaderView();
    this.mLL = isLandscape();
    this.mLH.setContentView(this.lJI);
    this.mLH.setCancelable(this.ox);
    this.mLK = BottomSheetBehavior.l((View)this.lJI.getParent());
    this.mLK.setState(3);
    this.mLK.ok = new BottomSheetBehavior.a()
    {
      public final void f(View paramAnonymousView, int paramAnonymousInt) {}
      
      public final void m(View paramAnonymousView) {}
    };
    this.mLH.setOnDismissListener(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(198250);
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
        AppMethodBeat.o(198250);
      }
    });
    AppMethodBeat.o(198260);
  }
  
  private void fPz()
  {
    AppMethodBeat.i(198271);
    this.HMr = ((LinearLayout)this.lJI.findViewById(2131297837));
    this.HMs = ((Button)this.lJI.findViewById(2131297832));
    this.HMt = ((Button)this.lJI.findViewById(2131297833));
    this.HMu = ((Button)this.lJI.findViewById(2131297850));
    switch (this.HMp)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(198271);
      return;
      this.HMr.setVisibility(8);
      AppMethodBeat.o(198271);
      return;
      this.HMr.setVisibility(0);
      this.HMu.setVisibility(8);
      this.HMs.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(198251);
          b localb = new b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/dialog/MMHalfBottomDialog$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (g.e(g.this) != null) {
            g.e(g.this).onClick();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/dialog/MMHalfBottomDialog$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(198251);
        }
      });
      this.HMt.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(198252);
          b localb = new b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/dialog/MMHalfBottomDialog$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (g.f(g.this) != null) {
            g.f(g.this).onClick();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/dialog/MMHalfBottomDialog$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(198252);
        }
      });
      AppMethodBeat.o(198271);
      return;
      this.HMr.setVisibility(0);
      this.HMs.setVisibility(8);
      this.HMt.setVisibility(8);
      this.HMu.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(198253);
          b localb = new b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/dialog/MMHalfBottomDialog$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (g.g(g.this) != null) {
            g.g(g.this).onClick();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/dialog/MMHalfBottomDialog$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(198253);
        }
      });
    }
  }
  
  private int getRotation()
  {
    AppMethodBeat.i(198259);
    int i = 0;
    if ((this.mContext instanceof Activity)) {
      i = ((Activity)this.mContext).getWindow().getWindowManager().getDefaultDisplay().getRotation();
    }
    AppMethodBeat.o(198259);
    return i;
  }
  
  @TargetApi(23)
  private void ghk()
  {
    AppMethodBeat.i(198273);
    if ((Build.VERSION.SDK_INT >= 23) && (this.mLH != null))
    {
      this.mLH.getWindow().getDecorView().setSystemUiVisibility(9216);
      this.mLH.getWindow().setStatusBarColor(0);
    }
    AppMethodBeat.o(198273);
  }
  
  private void hbt()
  {
    AppMethodBeat.i(198279);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.lJI.getLayoutParams();
    if ((this.mLL) && (this.qK != null))
    {
      Rect localRect = new Rect();
      this.qK.getWindowVisibleDisplayFrame(localRect);
      localLayoutParams.width = localRect.right;
    }
    this.lJI.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(198279);
  }
  
  private void initHeaderView()
  {
    AppMethodBeat.i(198272);
    if (this.HMv != null)
    {
      this.HMv.setVisibility(0);
      switch (this.HMq)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(198272);
      return;
      this.HMv.setVisibility(8);
      AppMethodBeat.o(198272);
      return;
      View localView = LayoutInflater.from(this.mContext).inflate(2131495003, null);
      localView.findViewById(2131298781).setOnClickListener(new g.6(this));
      this.HMv.removeAllViews();
      this.HMv.setGravity(17);
      this.HMv.addView(localView, -1, -2);
      AppMethodBeat.o(198272);
      return;
      localView = LayoutInflater.from(this.mContext).inflate(2131495004, null);
      this.HMy = ((TextView)localView.findViewById(2131309245));
      this.HMv.removeAllViews();
      this.HMv.setGravity(17);
      this.HMv.addView(localView, -1, -2);
    }
  }
  
  private boolean isLandscape()
  {
    AppMethodBeat.i(198280);
    if (this.mContext.getResources().getConfiguration().orientation == 2)
    {
      AppMethodBeat.o(198280);
      return true;
    }
    AppMethodBeat.o(198280);
    return false;
  }
  
  public final void T(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(198266);
    if (this.HMu != null) {
      this.HMu.setText(paramCharSequence);
    }
    AppMethodBeat.o(198266);
  }
  
  public final void a(a parama)
  {
    this.QOT = parama;
  }
  
  public final void a(a parama1, a parama2)
  {
    this.QOR = parama1;
    this.QOS = parama2;
  }
  
  public final void aE(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(198268);
    if (this.HMy != null) {
      this.HMy.setText(paramCharSequence);
    }
    AppMethodBeat.o(198268);
  }
  
  public final void aeF(int paramInt)
  {
    AppMethodBeat.i(198264);
    if (this.HMu != null) {
      this.HMu.setTextColor(paramInt);
    }
    AppMethodBeat.o(198264);
  }
  
  public final void apd(int paramInt)
  {
    AppMethodBeat.i(198263);
    if (this.HMs != null) {
      this.HMs.setTextColor(paramInt);
    }
    AppMethodBeat.o(198263);
  }
  
  public final void ape(int paramInt)
  {
    AppMethodBeat.i(198267);
    if (this.HMu != null)
    {
      this.HMu.setTextColor(this.mContext.getResources().getColor(2131100194));
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(198267);
      return;
      this.HMu.setBackgroundResource(2131231429);
      AppMethodBeat.o(198267);
      return;
      this.HMu.setBackgroundResource(2131231431);
      this.HMu.setTextColor(this.mContext.getResources().getColor(2131101425));
      AppMethodBeat.o(198267);
      return;
      this.HMu.setBackgroundResource(2131231434);
      AppMethodBeat.o(198267);
      return;
      this.HMu.setBackgroundResource(2131231439);
      AppMethodBeat.o(198267);
      return;
      this.HMu.setBackgroundResource(2131231425);
      AppMethodBeat.o(198267);
      return;
      this.HMu.setBackgroundResource(2131231432);
    }
  }
  
  public final g apf(int paramInt)
  {
    AppMethodBeat.i(198274);
    if (this.HMx != null)
    {
      this.HMx.setVisibility(0);
      LayoutInflater.from(this.lJI.getContext()).inflate(paramInt, this.HMx, true);
    }
    AppMethodBeat.o(198274);
    return this;
  }
  
  public final void b(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    AppMethodBeat.i(198262);
    if ((this.HMs != null) && (this.HMt != null))
    {
      this.HMs.setText(paramCharSequence1);
      this.HMt.setText(paramCharSequence2);
    }
    AppMethodBeat.o(198262);
  }
  
  public final void bMo()
  {
    AppMethodBeat.i(198277);
    if (this.mLH != null)
    {
      if ((!(this.mContext instanceof Activity)) || ((this.mContext != null) && (!((Activity)this.mContext).isFinishing()) && (!((Activity)this.mContext).isDestroyed()))) {
        this.mLH.dismiss();
      }
      if (this.mLK != null) {
        this.mLK.ob = true;
      }
    }
    AppMethodBeat.o(198277);
  }
  
  public final void dGm()
  {
    AppMethodBeat.i(198276);
    this.mLL = isLandscape();
    this.mLM = getRotation();
    if (this.mLH != null)
    {
      ((ViewGroup)this.lJI.getParent()).setVisibility(0);
      hbt();
      if (Build.VERSION.SDK_INT >= 21) {
        this.mLH.getWindow().addFlags(-2147483648);
      }
      if (this.wjM) {
        ghk();
      }
      if (!this.mLO) {
        break label219;
      }
      this.mLH.getWindow().setFlags(8, 8);
      this.mLH.getWindow().addFlags(131200);
      this.mLH.getWindow().getDecorView().setSystemUiVisibility(6);
      if (this.qK != null) {
        if (this.afI != null) {
          break label274;
        }
      }
    }
    label274:
    for (int i = 1;; i = 0)
    {
      this.afI = this.qK.getViewTreeObserver();
      if (i != 0) {
        this.afI.addOnGlobalLayoutListener(this);
      }
      if (((this.mContext instanceof Activity)) && (!((Activity)this.mContext).isFinishing())) {
        this.mLH.show();
      }
      if (this.mLK != null) {
        this.mLK.ob = false;
      }
      AppMethodBeat.o(198276);
      return;
      label219:
      this.mLH.getWindow().clearFlags(8);
      this.mLH.getWindow().clearFlags(131072);
      this.mLH.getWindow().clearFlags(128);
      this.mLH.getWindow().getDecorView().setSystemUiVisibility(0);
      break;
    }
  }
  
  public final void hbw()
  {
    AppMethodBeat.i(198265);
    if (this.HMt != null) {
      this.HMt.setBackgroundResource(2131231434);
    }
    AppMethodBeat.o(198265);
  }
  
  public final void hv(View paramView)
  {
    AppMethodBeat.i(198270);
    if (this.HMv != null)
    {
      this.HMv.setVisibility(0);
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.HMv.getLayoutParams();
      localLayoutParams.width = -1;
      localLayoutParams.height = -2;
      this.HMv.setLayoutParams(localLayoutParams);
      this.HMv.removeAllViews();
      this.HMv.setGravity(17);
      this.HMv.addView(paramView, -1, -2);
    }
    AppMethodBeat.o(198270);
  }
  
  public final boolean isShowing()
  {
    AppMethodBeat.i(198278);
    if ((this.mLH != null) && (this.mLH.isShowing()))
    {
      AppMethodBeat.o(198278);
      return true;
    }
    AppMethodBeat.o(198278);
    return false;
  }
  
  public void onGlobalLayout()
  {
    AppMethodBeat.i(198258);
    if (isShowing())
    {
      View localView = this.qK;
      if ((localView == null) || ((!localView.isShown()) && (localView.getVisibility() != 0)))
      {
        bMo();
        AppMethodBeat.o(198258);
        return;
      }
      if ((isShowing()) && ((this.mLL != isLandscape()) || (this.mLM != getRotation()))) {
        bMo();
      }
    }
    AppMethodBeat.o(198258);
  }
  
  public final void setCustomView(View paramView)
  {
    AppMethodBeat.i(198275);
    if (this.HMx != null)
    {
      this.HMx.setVisibility(0);
      this.HMx.removeAllViews();
      this.HMx.setGravity(17);
      this.HMx.addView(paramView, -1, -2);
    }
    AppMethodBeat.o(198275);
  }
  
  public final void setHeaderView(View paramView)
  {
    AppMethodBeat.i(198269);
    if (this.HMv != null)
    {
      this.HMv.setVisibility(0);
      this.HMv.removeAllViews();
      this.HMv.setGravity(17);
      this.HMv.addView(paramView, -1, -2);
    }
    AppMethodBeat.o(198269);
  }
  
  public final void setHeight(int paramInt)
  {
    AppMethodBeat.i(198261);
    if (paramInt != 0)
    {
      this.kca = paramInt;
      if (this.kca != 0) {
        this.mLK.J(this.kca);
      }
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.lJI.getLayoutParams();
      localLayoutParams.height = paramInt;
      this.lJI.setLayoutParams(localLayoutParams);
      this.lJI.invalidate();
    }
    AppMethodBeat.o(198261);
  }
  
  public static abstract interface a
  {
    public abstract void onClick();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.widget.a.g
 * JD-Core Version:    0.7.0.1
 */
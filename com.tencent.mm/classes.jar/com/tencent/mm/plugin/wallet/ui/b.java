package com.tencent.mm.plugin.wallet.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.widget.a.i;

public final class b
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private b HMA;
  private b HMB;
  private b HMC;
  private boolean HMD;
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
  private a HMz;
  private ViewTreeObserver afI;
  public View lJI;
  private Context mContext;
  private Dialog mLH;
  private boolean mLL;
  private int mLM;
  private boolean mLO;
  private boolean mLP;
  private boolean ox;
  private View qK;
  private boolean wjM;
  private boolean wjN;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(214117);
    this.mLL = false;
    this.wjN = false;
    this.mLO = false;
    this.HMD = false;
    this.mLP = false;
    this.ox = true;
    this.mContext = paramContext;
    this.HMp = 0;
    this.HMq = 3;
    this.mLP = true;
    bh(this.mContext);
    AppMethodBeat.o(214117);
  }
  
  public b(Context paramContext, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(214116);
    this.mLL = false;
    this.wjN = false;
    this.mLO = false;
    this.HMD = false;
    this.mLP = false;
    this.ox = true;
    this.mContext = paramContext;
    this.HMp = paramInt1;
    this.HMq = paramInt2;
    bh(this.mContext);
    AppMethodBeat.o(214116);
  }
  
  private static void b(Window paramWindow)
  {
    AppMethodBeat.i(214131);
    if (paramWindow == null)
    {
      AppMethodBeat.o(214131);
      return;
    }
    paramWindow.getDecorView().setSystemUiVisibility(7942);
    AppMethodBeat.o(214131);
  }
  
  private void bh(Context paramContext)
  {
    AppMethodBeat.i(214120);
    if ((this.mContext instanceof Activity)) {
      this.qK = ((ViewGroup)((Activity)this.mContext).getWindow().getDecorView()).findViewById(16908290);
    }
    if (this.mLP) {}
    for (this.mLH = new com.tencent.mm.ui.widget.a.b(paramContext);; this.mLH = new i(paramContext))
    {
      this.lJI = View.inflate(paramContext, 2131495530, null);
      this.HMv = ((LinearLayout)this.lJI.findViewById(2131297701));
      this.HMw = ((LinearLayout)this.lJI.findViewById(2131297696));
      this.HMx = ((LinearLayout)this.lJI.findViewById(2131297695));
      fPz();
      initHeaderView();
      this.mLL = isLandscape();
      if ((this.mLP) && (this.mLL)) {
        this.mLO = true;
      }
      this.mLH.setContentView(this.lJI);
      this.mLH.setCancelable(this.ox);
      yf(false);
      this.mLH.setOnDismissListener(new DialogInterface.OnDismissListener()
      {
        public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(214111);
          if ((b.a(b.this)) && (b.b(b.this))) {
            ((Activity)b.c(b.this)).getWindow().clearFlags(512);
          }
          if (b.d(b.this) != null) {
            b.d(b.this).fPA();
          }
          if (b.e(b.this) != null)
          {
            if (!b.e(b.this).isAlive()) {
              b.a(b.this, b.f(b.this).getViewTreeObserver());
            }
            b.e(b.this).removeGlobalOnLayoutListener(b.this);
            b.a(b.this, null);
          }
          if (!b.g(b.this)) {
            b.h(b.this);
          }
          AppMethodBeat.o(214111);
        }
      });
      AppMethodBeat.o(214120);
      return;
    }
  }
  
  private void fPz()
  {
    AppMethodBeat.i(214127);
    this.HMr = ((LinearLayout)this.lJI.findViewById(2131297837));
    this.HMs = ((Button)this.lJI.findViewById(2131297832));
    this.HMt = ((Button)this.lJI.findViewById(2131297833));
    this.HMu = ((Button)this.lJI.findViewById(2131297850));
    switch (this.HMp)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(214127);
      return;
      this.HMr.setVisibility(8);
      AppMethodBeat.o(214127);
      return;
      this.HMr.setVisibility(0);
      this.HMu.setVisibility(8);
      this.HMs.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(214112);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          a.b("com/tencent/mm/plugin/wallet/ui/CommonBottomSheet$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (b.i(b.this) != null) {
            b.i(b.this).onClick();
          }
          a.a(this, "com/tencent/mm/plugin/wallet/ui/CommonBottomSheet$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(214112);
        }
      });
      this.HMt.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(214113);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          a.b("com/tencent/mm/plugin/wallet/ui/CommonBottomSheet$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (b.j(b.this) != null) {
            b.j(b.this).onClick();
          }
          a.a(this, "com/tencent/mm/plugin/wallet/ui/CommonBottomSheet$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(214113);
        }
      });
      AppMethodBeat.o(214127);
      return;
      this.HMr.setVisibility(0);
      this.HMs.setVisibility(8);
      this.HMt.setVisibility(8);
      this.HMu.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(214114);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          a.b("com/tencent/mm/plugin/wallet/ui/CommonBottomSheet$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (b.k(b.this) != null) {
            b.k(b.this).onClick();
          }
          a.a(this, "com/tencent/mm/plugin/wallet/ui/CommonBottomSheet$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(214114);
        }
      });
    }
  }
  
  private int getRotation()
  {
    AppMethodBeat.i(214119);
    int i = 0;
    if ((this.mContext instanceof Activity)) {
      i = ((Activity)this.mContext).getWindow().getWindowManager().getDefaultDisplay().getRotation();
    }
    AppMethodBeat.o(214119);
    return i;
  }
  
  private void initHeaderView()
  {
    AppMethodBeat.i(214128);
    if (this.HMv != null)
    {
      this.HMv.setVisibility(0);
      switch (this.HMq)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(214128);
      return;
      this.HMv.setVisibility(8);
      AppMethodBeat.o(214128);
      return;
      View localView = LayoutInflater.from(this.mContext).inflate(2131495003, null);
      localView.findViewById(2131298781).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(214115);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          a.b("com/tencent/mm/plugin/wallet/ui/CommonBottomSheet$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          b.this.bMo();
          a.a(this, "com/tencent/mm/plugin/wallet/ui/CommonBottomSheet$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(214115);
        }
      });
      this.HMv.removeAllViews();
      this.HMv.setGravity(17);
      this.HMv.addView(localView, -1, -2);
      AppMethodBeat.o(214128);
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
    AppMethodBeat.i(214135);
    if (this.mContext.getResources().getConfiguration().orientation == 2)
    {
      AppMethodBeat.o(214135);
      return true;
    }
    AppMethodBeat.o(214135);
    return false;
  }
  
  public final void T(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(214124);
    if (this.HMu != null) {
      this.HMu.setText(paramCharSequence);
    }
    AppMethodBeat.o(214124);
  }
  
  public final void a(a parama)
  {
    this.HMz = parama;
  }
  
  public final void a(b paramb)
  {
    this.HMC = paramb;
  }
  
  public final void aeF(int paramInt)
  {
    AppMethodBeat.i(214121);
    if (this.HMu != null) {
      this.HMu.setTextColor(paramInt);
    }
    AppMethodBeat.o(214121);
  }
  
  public final void b(DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(214134);
    if (this.mLH != null) {
      this.mLH.setOnCancelListener(paramOnCancelListener);
    }
    AppMethodBeat.o(214134);
  }
  
  public final void bMo()
  {
    AppMethodBeat.i(214132);
    if ((this.mLH != null) && ((!(this.mContext instanceof Activity)) || ((this.mContext != null) && (!((Activity)this.mContext).isFinishing()) && (!((Activity)this.mContext).isDestroyed())))) {
      this.mLH.dismiss();
    }
    AppMethodBeat.o(214132);
  }
  
  public final void dGm()
  {
    AppMethodBeat.i(214130);
    this.mLL = isLandscape();
    this.mLM = getRotation();
    Object localObject1;
    Object localObject2;
    if (this.mLH != null)
    {
      ((ViewGroup)this.lJI.getParent()).setVisibility(0);
      localObject1 = (FrameLayout.LayoutParams)this.lJI.getLayoutParams();
      if ((this.mLL) && (this.qK != null))
      {
        localObject2 = new Rect();
        this.qK.getWindowVisibleDisplayFrame((Rect)localObject2);
        ((FrameLayout.LayoutParams)localObject1).width = Math.min(((Rect)localObject2).right, ((Rect)localObject2).bottom);
        if (this.mLP)
        {
          ((FrameLayout.LayoutParams)localObject1).height = au.az(this.mContext).y;
          ((FrameLayout.LayoutParams)localObject1).width = au.az(this.mContext).y;
        }
      }
      this.lJI.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      if (Build.VERSION.SDK_INT >= 21) {
        this.mLH.getWindow().addFlags(-2147483648);
      }
      if ((this.wjM) && (Build.VERSION.SDK_INT >= 23) && (this.mLH != null))
      {
        this.mLH.getWindow().getDecorView().setSystemUiVisibility(9216);
        this.mLH.getWindow().setStatusBarColor(0);
      }
      localObject1 = this.mLH.getWindow();
      if (!this.mLO) {
        break label375;
      }
      ((Window)localObject1).setFlags(8, 8);
      ((Window)localObject1).addFlags(131200);
      ((Window)localObject1).addFlags(1024);
      b((Window)localObject1);
      if (this.qK != null) {
        if (this.afI != null) {
          break label413;
        }
      }
    }
    label413:
    for (int i = 1;; i = 0)
    {
      this.afI = this.qK.getViewTreeObserver();
      if (i != 0) {
        this.afI.addOnGlobalLayoutListener(this);
      }
      if (((this.mContext instanceof Activity)) && (!((Activity)this.mContext).isFinishing()))
      {
        localObject2 = ((Activity)this.mContext).getWindow();
        if (this.mLO) {
          ((Window)localObject2).addFlags(512);
        }
        this.mLH.show();
        if (this.mLO)
        {
          b((Window)localObject1);
          b((Window)localObject2);
          ((Window)localObject1).clearFlags(8);
        }
      }
      AppMethodBeat.o(214130);
      return;
      label375:
      ((Window)localObject1).clearFlags(8);
      ((Window)localObject1).clearFlags(131072);
      ((Window)localObject1).clearFlags(128);
      ((Window)localObject1).clearFlags(1024);
      ((Window)localObject1).getDecorView().setSystemUiVisibility(0);
      break;
    }
  }
  
  public final void fPx()
  {
    AppMethodBeat.i(214122);
    if (this.HMu != null) {
      this.HMu.setBackgroundResource(2131235729);
    }
    AppMethodBeat.o(214122);
  }
  
  public final void fPy()
  {
    AppMethodBeat.i(214123);
    Window localWindow = this.mLH.getWindow();
    if (localWindow == null)
    {
      AppMethodBeat.o(214123);
      return;
    }
    localWindow.setWindowAnimations(2131820992);
    AppMethodBeat.o(214123);
  }
  
  public final boolean isShowing()
  {
    AppMethodBeat.i(214133);
    if ((this.mLH != null) && (this.mLH.isShowing()))
    {
      AppMethodBeat.o(214133);
      return true;
    }
    AppMethodBeat.o(214133);
    return false;
  }
  
  public final void onGlobalLayout()
  {
    AppMethodBeat.i(214118);
    if (isShowing())
    {
      View localView = this.qK;
      if ((localView == null) || ((!localView.isShown()) && (localView.getVisibility() != 0)))
      {
        bMo();
        AppMethodBeat.o(214118);
        return;
      }
      if ((isShowing()) && ((this.mLL != isLandscape()) || (this.mLM != getRotation()))) {
        bMo();
      }
    }
    AppMethodBeat.o(214118);
  }
  
  public final void setCustomView(View paramView)
  {
    AppMethodBeat.i(214129);
    if (this.HMx != null)
    {
      this.HMx.setVisibility(0);
      this.HMx.removeAllViews();
      this.HMx.setGravity(17);
      this.HMx.addView(paramView, -1, -2);
    }
    AppMethodBeat.o(214129);
  }
  
  public final void setHeaderView(View paramView)
  {
    AppMethodBeat.i(214125);
    if (this.HMv != null)
    {
      this.HMv.setVisibility(0);
      this.HMv.removeAllViews();
      this.HMv.setGravity(17);
      this.HMv.addView(paramView, -1, -2);
    }
    AppMethodBeat.o(214125);
  }
  
  public final b yf(boolean paramBoolean)
  {
    AppMethodBeat.i(214126);
    this.HMD = paramBoolean;
    if (this.lJI == null)
    {
      AppMethodBeat.o(214126);
      return this;
    }
    if (this.HMD)
    {
      if ((this.mLP) && (this.mLL))
      {
        this.lJI.setBackgroundColor(this.mContext.getResources().getColor(2131099745));
        AppMethodBeat.o(214126);
        return this;
      }
      this.lJI.setBackgroundResource(2131235388);
      AppMethodBeat.o(214126);
      return this;
    }
    if ((this.mLP) && (this.mLL))
    {
      this.lJI.setBackgroundColor(this.mContext.getResources().getColor(2131099653));
      AppMethodBeat.o(214126);
      return this;
    }
    this.lJI.setBackgroundResource(2131235391);
    AppMethodBeat.o(214126);
    return this;
  }
  
  public static abstract interface a
  {
    public abstract void fPA();
  }
  
  public static abstract interface b
  {
    public abstract void onClick();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.ui.b
 * JD-Core Version:    0.7.0.1
 */
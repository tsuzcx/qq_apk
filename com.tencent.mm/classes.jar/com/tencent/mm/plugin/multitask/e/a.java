package com.tencent.mm.plugin.multitask.e;

import android.annotation.SuppressLint;
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
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.a.b;

public final class a
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private a Aca;
  private ViewTreeObserver afI;
  public View lJI;
  private Context mContext;
  private Dialog mLH;
  private BottomSheetBehavior mLK;
  private boolean mLL;
  private int mLM;
  private boolean mLO;
  private boolean mLP;
  private View qK;
  private boolean wjM;
  private boolean wjN;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(200263);
    this.mLL = false;
    this.wjN = false;
    this.mLO = false;
    this.mLP = false;
    this.Aca = null;
    this.mContext = paramContext;
    if ((this.mContext instanceof Activity)) {
      this.qK = ((ViewGroup)((Activity)this.mContext).getWindow().getDecorView()).findViewById(16908290);
    }
    paramContext = this.mContext;
    if (this.mLP) {}
    for (this.mLH = new b(paramContext);; this.mLH = new android.support.design.widget.a(paramContext, 2131820791))
    {
      this.lJI = View.inflate(paramContext, 2131495761, null);
      this.mLL = isLandscape();
      this.mLH.setContentView(this.lJI);
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
          AppMethodBeat.i(200262);
          if (a.a(a.this) != null)
          {
            if (!a.a(a.this).isAlive()) {
              a.a(a.this, a.b(a.this).getViewTreeObserver());
            }
            a.a(a.this).removeGlobalOnLayoutListener(a.this);
            a.a(a.this, null);
          }
          if (!a.c(a.this)) {
            a.d(a.this);
          }
          if (a.e(a.this) != null) {
            a.e(a.this).onDismiss();
          }
          AppMethodBeat.o(200262);
        }
      });
      AppMethodBeat.o(200263);
      return;
    }
  }
  
  @SuppressLint({"WrongConstant"})
  private int getRotation()
  {
    AppMethodBeat.i(200265);
    int i = 0;
    if ((this.mContext instanceof Activity)) {
      i = ((Activity)this.mContext).getWindow().getWindowManager().getDefaultDisplay().getRotation();
    }
    AppMethodBeat.o(200265);
    return i;
  }
  
  private boolean isLandscape()
  {
    AppMethodBeat.i(200270);
    if (this.mContext.getResources().getConfiguration().orientation == 2)
    {
      AppMethodBeat.o(200270);
      return true;
    }
    AppMethodBeat.o(200270);
    return false;
  }
  
  private boolean isShowing()
  {
    AppMethodBeat.i(200269);
    if ((this.mLH != null) && (this.mLH.isShowing()))
    {
      AppMethodBeat.o(200269);
      return true;
    }
    AppMethodBeat.o(200269);
    return false;
  }
  
  public final void a(a parama)
  {
    this.Aca = parama;
  }
  
  public final void bMo()
  {
    AppMethodBeat.i(200268);
    if (this.mLH != null)
    {
      if ((!(this.mContext instanceof Activity)) || ((this.mContext != null) && (!((Activity)this.mContext).isFinishing()) && (!((Activity)this.mContext).isDestroyed()))) {
        this.mLH.dismiss();
      }
      if (this.mLK != null) {
        this.mLK.ob = true;
      }
    }
    AppMethodBeat.o(200268);
  }
  
  public final void dGm()
  {
    AppMethodBeat.i(200267);
    this.mLL = isLandscape();
    this.mLM = getRotation();
    if (this.mLH != null)
    {
      ((ViewGroup)this.lJI.getParent()).setVisibility(0);
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.lJI.getLayoutParams();
      if ((this.mLL) && (this.qK != null))
      {
        Rect localRect = new Rect();
        this.qK.getWindowVisibleDisplayFrame(localRect);
        localLayoutParams.width = localRect.right;
      }
      this.lJI.setLayoutParams(localLayoutParams);
      if (Build.VERSION.SDK_INT >= 21) {
        this.mLH.getWindow().addFlags(-2147483648);
      }
      if ((this.wjM) && (Build.VERSION.SDK_INT >= 23) && (this.mLH != null))
      {
        this.mLH.getWindow().getDecorView().setSystemUiVisibility(9216);
        this.mLH.getWindow().setStatusBarColor(0);
      }
      if (!this.mLO) {
        break label307;
      }
      this.mLH.getWindow().setFlags(8, 8);
      this.mLH.getWindow().addFlags(131200);
      this.mLH.getWindow().getDecorView().setSystemUiVisibility(6);
      if (this.qK != null) {
        if (this.afI != null) {
          break label362;
        }
      }
    }
    label307:
    label362:
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
      AppMethodBeat.o(200267);
      return;
      this.mLH.getWindow().clearFlags(8);
      this.mLH.getWindow().clearFlags(131072);
      this.mLH.getWindow().clearFlags(128);
      this.mLH.getWindow().getDecorView().setSystemUiVisibility(0);
      break;
    }
  }
  
  public final a erk()
  {
    AppMethodBeat.i(200266);
    LinearLayout localLinearLayout = (LinearLayout)this.lJI.findViewById(2131297695);
    LayoutInflater.from(this.lJI.getContext()).inflate(2131495765, localLinearLayout, true);
    AppMethodBeat.o(200266);
    return this;
  }
  
  public final void onGlobalLayout()
  {
    AppMethodBeat.i(200264);
    if (isShowing())
    {
      View localView = this.qK;
      if ((localView == null) || ((!localView.isShown()) && (localView.getVisibility() != 0)))
      {
        bMo();
        AppMethodBeat.o(200264);
        return;
      }
      if ((isShowing()) && ((this.mLL != isLandscape()) || (this.mLM != getRotation()))) {
        bMo();
      }
    }
    AppMethodBeat.o(200264);
  }
  
  public static abstract interface a
  {
    public abstract void onDismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.e.a
 * JD-Core Version:    0.7.0.1
 */
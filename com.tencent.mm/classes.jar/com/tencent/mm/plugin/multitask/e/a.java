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
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetBehavior.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitask.j.e;
import com.tencent.mm.plugin.multitask.j.f;
import com.tencent.mm.plugin.multitask.j.i;
import com.tencent.mm.ui.widget.a.b;

public final class a
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private boolean AUA;
  private boolean AUB;
  private a FHP;
  private View lJ;
  private ViewTreeObserver lS;
  private Context mContext;
  public View oFW;
  private BottomSheetBehavior pMC;
  private boolean pMD;
  private int pME;
  private boolean pMG;
  private boolean pMH;
  private Dialog pMz;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(248597);
    this.pMD = false;
    this.AUB = false;
    this.pMG = false;
    this.pMH = false;
    this.FHP = null;
    this.mContext = paramContext;
    if ((this.mContext instanceof Activity)) {
      this.lJ = ((ViewGroup)((Activity)this.mContext).getWindow().getDecorView()).findViewById(16908290);
    }
    paramContext = this.mContext;
    if (this.pMH) {}
    for (this.pMz = new b(paramContext);; this.pMz = new com.google.android.material.bottomsheet.a(paramContext, j.i.BottomSheetDialog))
    {
      this.oFW = View.inflate(paramContext, j.f.multitask_bottom_sheet, null);
      this.pMD = isLandscape();
      this.pMz.setContentView(this.oFW);
      this.pMC = BottomSheetBehavior.cg((View)this.oFW.getParent());
      this.pMC.setState(3);
      this.pMC.bxG = new BottomSheetBehavior.a()
      {
        public final void ch(View paramAnonymousView) {}
        
        public final void e(View paramAnonymousView, int paramAnonymousInt) {}
      };
      this.pMz.setOnDismissListener(new DialogInterface.OnDismissListener()
      {
        public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(248473);
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
          AppMethodBeat.o(248473);
        }
      });
      AppMethodBeat.o(248597);
      return;
    }
  }
  
  @SuppressLint({"WrongConstant"})
  private int getRotation()
  {
    AppMethodBeat.i(248601);
    int i = 0;
    if ((this.mContext instanceof Activity)) {
      i = ((Activity)this.mContext).getWindow().getWindowManager().getDefaultDisplay().getRotation();
    }
    AppMethodBeat.o(248601);
    return i;
  }
  
  private boolean isLandscape()
  {
    AppMethodBeat.i(248609);
    if (this.mContext.getResources().getConfiguration().orientation == 2)
    {
      AppMethodBeat.o(248609);
      return true;
    }
    AppMethodBeat.o(248609);
    return false;
  }
  
  private boolean isShowing()
  {
    AppMethodBeat.i(248607);
    if ((this.pMz != null) && (this.pMz.isShowing()))
    {
      AppMethodBeat.o(248607);
      return true;
    }
    AppMethodBeat.o(248607);
    return false;
  }
  
  public final a Yf(int paramInt)
  {
    AppMethodBeat.i(248602);
    LinearLayout localLinearLayout = (LinearLayout)this.oFW.findViewById(j.e.bottom_sheet_custom_layout);
    LayoutInflater.from(this.oFW.getContext()).inflate(paramInt, localLinearLayout, true);
    AppMethodBeat.o(248602);
    return this;
  }
  
  public final void a(a parama)
  {
    this.FHP = parama;
  }
  
  public final void bYF()
  {
    AppMethodBeat.i(248605);
    if (this.pMz != null)
    {
      if ((!(this.mContext instanceof Activity)) || ((this.mContext != null) && (!((Activity)this.mContext).isFinishing()) && (!((Activity)this.mContext).isDestroyed()))) {
        this.pMz.dismiss();
      }
      if (this.pMC != null) {
        this.pMC.bxz = true;
      }
    }
    AppMethodBeat.o(248605);
  }
  
  public final void eik()
  {
    AppMethodBeat.i(248604);
    this.pMD = isLandscape();
    this.pME = getRotation();
    if (this.pMz != null)
    {
      ((ViewGroup)this.oFW.getParent()).setVisibility(0);
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.oFW.getLayoutParams();
      if ((this.pMD) && (this.lJ != null))
      {
        Rect localRect = new Rect();
        this.lJ.getWindowVisibleDisplayFrame(localRect);
        localLayoutParams.width = localRect.right;
      }
      this.oFW.setLayoutParams(localLayoutParams);
      if (Build.VERSION.SDK_INT >= 21) {
        this.pMz.getWindow().addFlags(-2147483648);
      }
      if ((this.AUA) && (Build.VERSION.SDK_INT >= 23) && (this.pMz != null))
      {
        this.pMz.getWindow().getDecorView().setSystemUiVisibility(9216);
        this.pMz.getWindow().setStatusBarColor(0);
      }
      if (!this.pMG) {
        break label308;
      }
      this.pMz.getWindow().setFlags(8, 8);
      this.pMz.getWindow().addFlags(131200);
      this.pMz.getWindow().getDecorView().setSystemUiVisibility(6);
      if (this.lJ != null) {
        if (this.lS != null) {
          break label363;
        }
      }
    }
    label308:
    label363:
    for (int i = 1;; i = 0)
    {
      this.lS = this.lJ.getViewTreeObserver();
      if (i != 0) {
        this.lS.addOnGlobalLayoutListener(this);
      }
      if (((this.mContext instanceof Activity)) && (!((Activity)this.mContext).isFinishing())) {
        this.pMz.show();
      }
      if (this.pMC != null) {
        this.pMC.bxz = false;
      }
      AppMethodBeat.o(248604);
      return;
      this.pMz.getWindow().clearFlags(8);
      this.pMz.getWindow().clearFlags(131072);
      this.pMz.getWindow().clearFlags(128);
      this.pMz.getWindow().getDecorView().setSystemUiVisibility(0);
      break;
    }
  }
  
  public final void onGlobalLayout()
  {
    AppMethodBeat.i(248599);
    if (isShowing())
    {
      View localView = this.lJ;
      if ((localView == null) || ((!localView.isShown()) && (localView.getVisibility() != 0)))
      {
        bYF();
        AppMethodBeat.o(248599);
        return;
      }
      if ((isShowing()) && ((this.pMD != isLandscape()) || (this.pME != getRotation()))) {
        bYF();
      }
    }
    AppMethodBeat.o(248599);
  }
  
  public static abstract interface a
  {
    public abstract void onDismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.e.a
 * JD-Core Version:    0.7.0.1
 */
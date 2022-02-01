package com.tencent.mm.ui.chatting.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.WindowManager;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cr.a.j;
import com.tencent.mm.ui.widget.a.e.b;

public final class b
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private boolean AUB;
  public e.b XbB;
  public boolean XbC;
  public View lJ;
  public ViewTreeObserver lS;
  public Context mContext;
  public View oFW;
  public BottomSheetBehavior pMC;
  public boolean pMD;
  public int pME;
  public boolean pMG;
  public Dialog pMz;
  
  public b(Context paramContext, View paramView)
  {
    AppMethodBeat.i(185898);
    this.pMD = false;
    this.AUB = false;
    this.XbC = false;
    this.pMG = false;
    this.oFW = paramView;
    this.mContext = paramContext;
    if ((this.mContext instanceof Activity)) {
      this.lJ = ((ViewGroup)((Activity)this.mContext).getWindow().getDecorView()).findViewById(16908290);
    }
    this.pMz = new a(this.mContext, a.j.BottomSheetDialog);
    this.pMD = isLandscape();
    if (this.pMz != null) {
      this.pMz.setContentView(this.oFW);
    }
    this.pMC = BottomSheetBehavior.cg((View)this.oFW.getParent());
    this.pMC.setState(3);
    if (this.pMz != null) {
      this.pMz.setOnDismissListener(new DialogInterface.OnDismissListener()
      {
        public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(185896);
          if (b.a(b.this) != null)
          {
            if (!b.a(b.this).isAlive()) {
              b.a(b.this, b.b(b.this).getViewTreeObserver());
            }
            b.a(b.this).removeGlobalOnLayoutListener(b.this);
            b.a(b.this, null);
          }
          if (!b.c(b.this)) {
            b.d(b.this);
          }
          AppMethodBeat.o(185896);
        }
      });
    }
    AppMethodBeat.o(185898);
  }
  
  private boolean isShowing()
  {
    AppMethodBeat.i(185903);
    if ((this.pMz != null) && (this.pMz.isShowing()))
    {
      AppMethodBeat.o(185903);
      return true;
    }
    AppMethodBeat.o(185903);
    return false;
  }
  
  public final void bYF()
  {
    AppMethodBeat.i(185901);
    if (this.pMz != null)
    {
      if (this.pMC != null) {
        this.pMC.bxz = true;
      }
      if ((!(this.mContext instanceof Activity)) || ((this.mContext != null) && (!((Activity)this.mContext).isFinishing()) && (!((Activity)this.mContext).isDestroyed()))) {
        this.pMz.dismiss();
      }
    }
    AppMethodBeat.o(185901);
  }
  
  @SuppressLint({"WrongConstant"})
  public final int getRotation()
  {
    AppMethodBeat.i(185900);
    int i = 0;
    if ((this.mContext instanceof Activity)) {
      i = ((Activity)this.mContext).getWindow().getWindowManager().getDefaultDisplay().getRotation();
    }
    AppMethodBeat.o(185900);
    return i;
  }
  
  public final boolean isLandscape()
  {
    AppMethodBeat.i(185902);
    if (this.mContext.getResources().getConfiguration().orientation == 2)
    {
      AppMethodBeat.o(185902);
      return true;
    }
    AppMethodBeat.o(185902);
    return false;
  }
  
  public final void onGlobalLayout()
  {
    AppMethodBeat.i(185899);
    if (isShowing())
    {
      View localView = this.lJ;
      if ((localView == null) || ((!localView.isShown()) && (localView.getVisibility() != 0)))
      {
        bYF();
        AppMethodBeat.o(185899);
        return;
      }
      if ((isShowing()) && ((this.pMD != isLandscape()) || (this.pME != getRotation()))) {
        bYF();
      }
    }
    AppMethodBeat.o(185899);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.view.b
 * JD-Core Version:    0.7.0.1
 */
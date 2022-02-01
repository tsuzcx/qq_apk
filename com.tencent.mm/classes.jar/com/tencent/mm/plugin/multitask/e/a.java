package com.tencent.mm.plugin.multitask.e;

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
import com.google.android.material.bottomsheet.BottomSheetBehavior.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitask.j.f;
import com.tencent.mm.plugin.multitask.j.i;
import com.tencent.mm.ui.widget.a.b;

public final class a
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  boolean GwR;
  private boolean GwS;
  a LDl;
  Context mContext;
  View mF;
  ViewTreeObserver mP;
  public View rootView;
  private boolean sRA;
  Dialog sRs;
  BottomSheetBehavior sRv;
  boolean sRw;
  int sRx;
  boolean sRz;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(303750);
    this.sRw = false;
    this.GwS = false;
    this.sRz = false;
    this.sRA = false;
    this.LDl = null;
    this.mContext = paramContext;
    if ((this.mContext instanceof Activity)) {
      this.mF = ((ViewGroup)((Activity)this.mContext).getWindow().getDecorView()).findViewById(16908290);
    }
    paramContext = this.mContext;
    if (this.sRA) {}
    for (this.sRs = new b(paramContext);; this.sRs = new com.google.android.material.bottomsheet.a(paramContext, j.i.BottomSheetDialog))
    {
      this.rootView = View.inflate(paramContext, j.f.multitask_bottom_sheet, null);
      this.sRw = isLandscape();
      this.sRs.setContentView(this.rootView);
      this.sRv = BottomSheetBehavior.cC((View)this.rootView.getParent());
      this.sRv.setState(3);
      this.sRv.dqJ = new BottomSheetBehavior.a()
      {
        public final void cD(View paramAnonymousView) {}
        
        public final void e(View paramAnonymousView, int paramAnonymousInt) {}
      };
      this.sRs.setOnDismissListener(new DialogInterface.OnDismissListener()
      {
        public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(303732);
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
          AppMethodBeat.o(303732);
        }
      });
      AppMethodBeat.o(303750);
      return;
    }
  }
  
  private boolean isShowing()
  {
    AppMethodBeat.i(303757);
    if ((this.sRs != null) && (this.sRs.isShowing()))
    {
      AppMethodBeat.o(303757);
      return true;
    }
    AppMethodBeat.o(303757);
    return false;
  }
  
  public final void cyW()
  {
    AppMethodBeat.i(303807);
    if (this.sRs != null)
    {
      if ((!(this.mContext instanceof Activity)) || ((this.mContext != null) && (!((Activity)this.mContext).isFinishing()) && (!((Activity)this.mContext).isDestroyed()))) {
        this.sRs.dismiss();
      }
      if (this.sRv != null) {
        this.sRv.dqC = true;
      }
    }
    AppMethodBeat.o(303807);
  }
  
  final int getRotation()
  {
    AppMethodBeat.i(303799);
    int i = 0;
    if ((this.mContext instanceof Activity)) {
      i = ((Activity)this.mContext).getWindow().getWindowManager().getDefaultDisplay().getRotation();
    }
    AppMethodBeat.o(303799);
    return i;
  }
  
  final boolean isLandscape()
  {
    AppMethodBeat.i(303817);
    if (this.mContext.getResources().getConfiguration().orientation == 2)
    {
      AppMethodBeat.o(303817);
      return true;
    }
    AppMethodBeat.o(303817);
    return false;
  }
  
  public final void onGlobalLayout()
  {
    AppMethodBeat.i(303791);
    if (isShowing())
    {
      View localView = this.mF;
      if ((localView == null) || ((!localView.isShown()) && (localView.getVisibility() != 0)))
      {
        cyW();
        AppMethodBeat.o(303791);
        return;
      }
      if ((isShowing()) && ((this.sRw != isLandscape()) || (this.sRx != getRotation()))) {
        cyW();
      }
    }
    AppMethodBeat.o(303791);
  }
  
  public static abstract interface a
  {
    public abstract void onDismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitask.e.a
 * JD-Core Version:    0.7.0.1
 */
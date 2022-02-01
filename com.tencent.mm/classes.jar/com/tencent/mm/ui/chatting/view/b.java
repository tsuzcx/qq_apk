package com.tencent.mm.ui.chatting.view;

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
import com.tencent.mm.ck.a.j;
import com.tencent.mm.ui.widget.a.f.b;

public final class b
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private boolean GwS;
  public f.b aeLi;
  public boolean aeLj;
  public Context mContext;
  public View mF;
  public ViewTreeObserver mP;
  public View rootView;
  public Dialog sRs;
  public BottomSheetBehavior sRv;
  public boolean sRw;
  public int sRx;
  public boolean sRz;
  
  public b(Context paramContext, View paramView)
  {
    AppMethodBeat.i(185898);
    this.sRw = false;
    this.GwS = false;
    this.aeLj = false;
    this.sRz = false;
    this.rootView = paramView;
    this.mContext = paramContext;
    if ((this.mContext instanceof Activity)) {
      this.mF = ((ViewGroup)((Activity)this.mContext).getWindow().getDecorView()).findViewById(16908290);
    }
    this.sRs = new a(this.mContext, a.j.BottomSheetDialog);
    this.sRw = isLandscape();
    if (this.sRs != null) {
      this.sRs.setContentView(this.rootView);
    }
    this.sRv = BottomSheetBehavior.cC((View)this.rootView.getParent());
    this.sRv.setState(3);
    if (this.sRs != null) {
      this.sRs.setOnDismissListener(new DialogInterface.OnDismissListener()
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
    if ((this.sRs != null) && (this.sRs.isShowing()))
    {
      AppMethodBeat.o(185903);
      return true;
    }
    AppMethodBeat.o(185903);
    return false;
  }
  
  public final void cyW()
  {
    AppMethodBeat.i(185901);
    if (this.sRs != null)
    {
      if (this.sRv != null) {
        this.sRv.dqC = true;
      }
      if ((!(this.mContext instanceof Activity)) || ((this.mContext != null) && (!((Activity)this.mContext).isFinishing()) && (!((Activity)this.mContext).isDestroyed()))) {
        this.sRs.dismiss();
      }
    }
    AppMethodBeat.o(185901);
  }
  
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
      View localView = this.mF;
      if ((localView == null) || ((!localView.isShown()) && (localView.getVisibility() != 0)))
      {
        cyW();
        AppMethodBeat.o(185899);
        return;
      }
      if ((isShowing()) && ((this.sRw != isLandscape()) || (this.sRx != getRotation()))) {
        cyW();
      }
    }
    AppMethodBeat.o(185899);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.view.b
 * JD-Core Version:    0.7.0.1
 */
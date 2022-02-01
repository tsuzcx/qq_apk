package com.tencent.mm.ui.chatting.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.a;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.a.e.b;

public final class b
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public e.b JXC;
  public boolean JXD;
  public ViewTreeObserver afv;
  public View kBS;
  public Dialog lzA;
  public BottomSheetBehavior lzD;
  public boolean lzE;
  public int lzF;
  public boolean lzH;
  public Context mContext;
  public View qI;
  private boolean sSi;
  
  public b(Context paramContext, View paramView)
  {
    AppMethodBeat.i(185898);
    this.lzE = false;
    this.sSi = false;
    this.JXD = false;
    this.lzH = false;
    this.kBS = paramView;
    this.mContext = paramContext;
    if ((this.mContext instanceof Activity)) {
      this.qI = ((ViewGroup)((Activity)this.mContext).getWindow().getDecorView()).findViewById(16908290);
    }
    this.lzA = new a(this.mContext, 2131820788);
    this.lzE = aol();
    if (this.lzA != null) {
      this.lzA.setContentView(this.kBS);
    }
    this.lzD = BottomSheetBehavior.l((View)this.kBS.getParent());
    this.lzD.setState(3);
    if (this.lzA != null) {
      this.lzA.setOnDismissListener(new DialogInterface.OnDismissListener()
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
    if ((this.lzA != null) && (this.lzA.isShowing()))
    {
      AppMethodBeat.o(185903);
      return true;
    }
    AppMethodBeat.o(185903);
    return false;
  }
  
  public final boolean aol()
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
  
  public final void bpT()
  {
    AppMethodBeat.i(185901);
    if (this.lzA != null)
    {
      if (this.lzD != null) {
        this.lzD.nZ = true;
      }
      if ((!(this.mContext instanceof Activity)) || ((this.mContext != null) && (!((Activity)this.mContext).isFinishing()) && (!((Activity)this.mContext).isDestroyed()))) {
        this.lzA.dismiss();
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
  
  public final void onGlobalLayout()
  {
    AppMethodBeat.i(185899);
    if (isShowing())
    {
      View localView = this.qI;
      if ((localView == null) || ((!localView.isShown()) && (localView.getVisibility() != 0)))
      {
        bpT();
        AppMethodBeat.o(185899);
        return;
      }
      if ((isShowing()) && ((this.lzE != aol()) || (this.lzF != getRotation()))) {
        bpT();
      }
    }
    AppMethodBeat.o(185899);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.view.b
 * JD-Core Version:    0.7.0.1
 */
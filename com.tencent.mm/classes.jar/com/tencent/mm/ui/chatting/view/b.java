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
  public e.b GHn;
  public boolean GHo;
  public ViewTreeObserver acK;
  public View jGG;
  public Dialog kBi;
  public BottomSheetBehavior kBl;
  public boolean kBm;
  public int kBn;
  public boolean kBp;
  public Context mContext;
  public View nO;
  private boolean qVt;
  
  public b(Context paramContext, View paramView)
  {
    AppMethodBeat.i(185898);
    this.kBm = false;
    this.qVt = false;
    this.GHo = false;
    this.kBp = false;
    this.jGG = paramView;
    this.mContext = paramContext;
    if ((this.mContext instanceof Activity)) {
      this.nO = ((ViewGroup)((Activity)this.mContext).getWindow().getDecorView()).findViewById(16908290);
    }
    this.kBi = new a(this.mContext, 2131820788);
    this.kBm = aov();
    if (this.kBi != null) {
      this.kBi.setContentView(this.jGG);
    }
    this.kBl = BottomSheetBehavior.l((View)this.jGG.getParent());
    this.kBl.setState(3);
    if (this.kBi != null) {
      this.kBi.setOnDismissListener(new DialogInterface.OnDismissListener()
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
    if ((this.kBi != null) && (this.kBi.isShowing()))
    {
      AppMethodBeat.o(185903);
      return true;
    }
    AppMethodBeat.o(185903);
    return false;
  }
  
  public final boolean aov()
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
  
  public final void bfo()
  {
    AppMethodBeat.i(185901);
    if (this.kBi != null)
    {
      if (this.kBl != null) {
        this.kBl.lh = true;
      }
      if ((!(this.mContext instanceof Activity)) || ((this.mContext != null) && (!((Activity)this.mContext).isFinishing()) && (!((Activity)this.mContext).isDestroyed()))) {
        this.kBi.dismiss();
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
      View localView = this.nO;
      if ((localView == null) || ((!localView.isShown()) && (localView.getVisibility() != 0)))
      {
        bfo();
        AppMethodBeat.o(185899);
        return;
      }
      if ((isShowing()) && ((this.kBm != aov()) || (this.kBn != getRotation()))) {
        bfo();
      }
    }
    AppMethodBeat.o(185899);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.view.b
 * JD-Core Version:    0.7.0.1
 */
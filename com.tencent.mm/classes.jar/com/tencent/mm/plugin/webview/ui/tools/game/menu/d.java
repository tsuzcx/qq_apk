package com.tencent.mm.plugin.webview.ui.tools.game.menu;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.m;

public final class d
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private m HMc;
  private e JrZ;
  public b.b Jsa;
  private GameMenuView Jsb;
  private f Jsc;
  private ViewTreeObserver afI;
  private Context mContext;
  private boolean mLL;
  public boolean mLN;
  public boolean mLO;
  private View qK;
  private boolean wjM;
  
  public d(Context paramContext)
  {
    AppMethodBeat.i(80973);
    this.mLL = false;
    this.mLO = false;
    this.mContext = paramContext;
    if ((this.mContext instanceof Activity))
    {
      paramContext = (ViewGroup)((Activity)this.mContext).getWindow().getDecorView();
      if (paramContext.getChildCount() <= 0) {
        break label156;
      }
    }
    label156:
    for (this.qK = paramContext.getChildAt(0);; this.qK = paramContext)
    {
      paramContext = this.mContext;
      this.HMc = new m(paramContext);
      this.JrZ = new e(paramContext);
      this.Jsb = new GameMenuView(paramContext);
      this.Jsc = new f(paramContext);
      this.Jsb.setAdapter(this.Jsc);
      this.mLL = isLandscape();
      this.JrZ.setContentView(this.Jsb);
      AppMethodBeat.o(80973);
      return;
    }
  }
  
  @TargetApi(23)
  private void ghk()
  {
    AppMethodBeat.i(80974);
    if ((Build.VERSION.SDK_INT >= 23) && (this.JrZ != null))
    {
      this.JrZ.getWindow().getDecorView().setSystemUiVisibility(9216);
      this.JrZ.getWindow().setStatusBarColor(0);
    }
    AppMethodBeat.o(80974);
  }
  
  private boolean isLandscape()
  {
    AppMethodBeat.i(80979);
    DisplayMetrics localDisplayMetrics = this.mContext.getResources().getDisplayMetrics();
    if (localDisplayMetrics.widthPixels > localDisplayMetrics.heightPixels)
    {
      AppMethodBeat.o(80979);
      return true;
    }
    AppMethodBeat.o(80979);
    return false;
  }
  
  private boolean isShowing()
  {
    AppMethodBeat.i(80977);
    if (this.JrZ != null)
    {
      if (this.JrZ.isShowing())
      {
        AppMethodBeat.o(80977);
        return true;
      }
      AppMethodBeat.o(80977);
      return false;
    }
    AppMethodBeat.o(80977);
    return false;
  }
  
  public final void a(b.c paramc)
  {
    AppMethodBeat.i(80978);
    if (this.Jsb != null) {
      this.Jsb.setGameMenuItemSelectedListener(paramc);
    }
    AppMethodBeat.o(80978);
  }
  
  public final void bMo()
  {
    AppMethodBeat.i(80976);
    if (this.afI != null)
    {
      if (!this.afI.isAlive()) {
        this.afI = this.qK.getViewTreeObserver();
      }
      this.afI.removeGlobalOnLayoutListener(this);
      this.afI = null;
    }
    if (this.JrZ != null) {
      this.JrZ.dismiss();
    }
    AppMethodBeat.o(80976);
  }
  
  public final void dGm()
  {
    int i = 0;
    AppMethodBeat.i(80975);
    this.mLL = isLandscape();
    if (this.Jsa != null) {
      this.Jsa.onCreateMMMenu(this.HMc);
    }
    if (this.JrZ != null)
    {
      if (this.Jsc != null) {
        this.Jsc.a(this.HMc);
      }
      if (Build.VERSION.SDK_INT >= 21) {
        this.JrZ.getWindow().addFlags(-2147483648);
      }
      if (this.wjM) {
        ghk();
      }
      if (this.mLN) {
        this.JrZ.getWindow().addFlags(1024);
      }
      if (!this.mLO) {
        break label248;
      }
      this.JrZ.getWindow().setFlags(8, 8);
      this.JrZ.getWindow().addFlags(131200);
      this.JrZ.getWindow().getDecorView().setSystemUiVisibility(6);
    }
    for (;;)
    {
      if (this.qK != null)
      {
        if (this.afI == null) {
          i = 1;
        }
        this.afI = this.qK.getViewTreeObserver();
        if (i != 0) {
          this.afI.addOnGlobalLayoutListener(this);
        }
      }
      this.JrZ.setOnDismissListener(new DialogInterface.OnDismissListener()
      {
        public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(80970);
          d.this.bMo();
          AppMethodBeat.o(80970);
        }
      });
      if (this.Jsb != null) {
        this.Jsb.setDismissListener(new b.a()
        {
          public final void onDismiss()
          {
            AppMethodBeat.i(80971);
            d.this.bMo();
            AppMethodBeat.o(80971);
          }
        });
      }
      this.JrZ.show();
      AppMethodBeat.o(80975);
      return;
      label248:
      this.JrZ.getWindow().clearFlags(8);
      this.JrZ.getWindow().clearFlags(131072);
      this.JrZ.getWindow().clearFlags(128);
      this.JrZ.getWindow().getDecorView().setSystemUiVisibility(0);
    }
  }
  
  public final void onGlobalLayout()
  {
    AppMethodBeat.i(80972);
    if (isShowing())
    {
      View localView = this.qK;
      if ((localView == null) || (!localView.isShown()))
      {
        bMo();
        AppMethodBeat.o(80972);
        return;
      }
      if ((isShowing()) && (this.mLL != isLandscape())) {
        bMo();
      }
    }
    AppMethodBeat.o(80972);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.menu.d
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.webview.ui.tools.game.menu;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.base.l;

public final class d
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private ViewTreeObserver VF;
  private View iU;
  private Context mContext;
  private l saq;
  private e vnO;
  public b.b vnP;
  private GameMenuView vnQ;
  private f vnR;
  private boolean vnS;
  private boolean vnT;
  public boolean vnU;
  public boolean vnV;
  
  public d(Context paramContext)
  {
    AppMethodBeat.i(8820);
    this.vnS = false;
    this.vnV = false;
    this.mContext = paramContext;
    if ((this.mContext instanceof Activity))
    {
      paramContext = (ViewGroup)((Activity)this.mContext).getWindow().getDecorView();
      if (paramContext.getChildCount() <= 0) {
        break label158;
      }
    }
    label158:
    for (this.iU = paramContext.getChildAt(0);; this.iU = paramContext)
    {
      paramContext = this.mContext;
      this.saq = new l(paramContext);
      this.vnO = new e(paramContext);
      this.vnQ = new GameMenuView(paramContext);
      this.vnR = new f(paramContext);
      this.vnQ.setAdapter(this.vnR);
      this.vnS = isLandscape();
      this.vnO.setContentView(this.vnQ);
      AppMethodBeat.o(8820);
      return;
    }
  }
  
  @TargetApi(23)
  private void dgf()
  {
    AppMethodBeat.i(8821);
    if ((Build.VERSION.SDK_INT >= 23) && (this.vnO != null))
    {
      this.vnO.getWindow().getDecorView().setSystemUiVisibility(9216);
      this.vnO.getWindow().setStatusBarColor(0);
    }
    AppMethodBeat.o(8821);
  }
  
  private boolean isLandscape()
  {
    AppMethodBeat.i(8826);
    DisplayMetrics localDisplayMetrics = this.mContext.getResources().getDisplayMetrics();
    if (localDisplayMetrics.widthPixels > localDisplayMetrics.heightPixels)
    {
      AppMethodBeat.o(8826);
      return true;
    }
    AppMethodBeat.o(8826);
    return false;
  }
  
  private boolean isShowing()
  {
    AppMethodBeat.i(8824);
    if (this.vnO != null)
    {
      if (this.vnO.isShowing())
      {
        AppMethodBeat.o(8824);
        return true;
      }
      AppMethodBeat.o(8824);
      return false;
    }
    AppMethodBeat.o(8824);
    return false;
  }
  
  public final void a(b.c paramc)
  {
    AppMethodBeat.i(8825);
    if (this.vnQ != null) {
      this.vnQ.setGameMenuItemSelectedListener(paramc);
    }
    AppMethodBeat.o(8825);
  }
  
  public final void crd()
  {
    int i = 0;
    AppMethodBeat.i(8822);
    this.vnS = isLandscape();
    if (this.vnP != null) {
      this.vnP.onCreateMMMenu(this.saq);
    }
    if (this.vnO != null)
    {
      if (this.vnR != null) {
        this.vnR.a(this.saq);
      }
      if (Build.VERSION.SDK_INT >= 21) {
        this.vnO.getWindow().addFlags(-2147483648);
      }
      if (this.vnT) {
        dgf();
      }
      if (this.vnU) {
        this.vnO.getWindow().addFlags(1024);
      }
      if (!this.vnV) {
        break label250;
      }
      this.vnO.getWindow().setFlags(8, 8);
      this.vnO.getWindow().addFlags(131200);
      this.vnO.getWindow().getDecorView().setSystemUiVisibility(6);
    }
    for (;;)
    {
      if (this.iU != null)
      {
        if (this.VF == null) {
          i = 1;
        }
        this.VF = this.iU.getViewTreeObserver();
        if (i != 0) {
          this.VF.addOnGlobalLayoutListener(this);
        }
      }
      this.vnO.setOnDismissListener(new d.1(this));
      if (this.vnQ != null) {
        this.vnQ.setDismissListener(new b.a()
        {
          public final void onDismiss()
          {
            AppMethodBeat.i(8818);
            d.this.cre();
            AppMethodBeat.o(8818);
          }
        });
      }
      this.vnO.show();
      AppMethodBeat.o(8822);
      return;
      label250:
      this.vnO.getWindow().clearFlags(8);
      this.vnO.getWindow().clearFlags(131072);
      this.vnO.getWindow().clearFlags(128);
      this.vnO.getWindow().getDecorView().setSystemUiVisibility(0);
    }
  }
  
  public final void cre()
  {
    AppMethodBeat.i(8823);
    if (this.VF != null)
    {
      if (!this.VF.isAlive()) {
        this.VF = this.iU.getViewTreeObserver();
      }
      this.VF.removeGlobalOnLayoutListener(this);
      this.VF = null;
    }
    if (this.vnO != null) {
      this.vnO.dismiss();
    }
    AppMethodBeat.o(8823);
  }
  
  public final void onGlobalLayout()
  {
    AppMethodBeat.i(8819);
    if (isShowing())
    {
      View localView = this.iU;
      if ((localView == null) || (!localView.isShown()))
      {
        cre();
        AppMethodBeat.o(8819);
        return;
      }
      if ((isShowing()) && (this.vnS != isLandscape())) {
        cre();
      }
    }
    AppMethodBeat.o(8819);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.menu.d
 * JD-Core Version:    0.7.0.1
 */
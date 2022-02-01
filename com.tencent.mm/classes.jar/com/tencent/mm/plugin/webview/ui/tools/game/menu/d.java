package com.tencent.mm.plugin.webview.ui.tools.game.menu;

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
import com.tencent.mm.ui.base.s;

public final class d
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private boolean GwR;
  private s Vtk;
  private e XhK;
  public b.b XhL;
  private GameMenuView XhM;
  private f XhN;
  private Context mContext;
  private View mF;
  private ViewTreeObserver mP;
  private boolean sRw;
  public boolean sRy;
  public boolean sRz;
  
  public d(Context paramContext)
  {
    AppMethodBeat.i(80973);
    this.sRw = false;
    this.sRz = false;
    this.mContext = paramContext;
    if ((this.mContext instanceof Activity))
    {
      paramContext = (ViewGroup)((Activity)this.mContext).getWindow().getDecorView();
      if (paramContext.getChildCount() <= 0) {
        break label156;
      }
    }
    label156:
    for (this.mF = paramContext.getChildAt(0);; this.mF = paramContext)
    {
      paramContext = this.mContext;
      this.Vtk = new s(paramContext);
      this.XhK = new e(paramContext);
      this.XhM = new GameMenuView(paramContext);
      this.XhN = new f(paramContext);
      this.XhM.setAdapter(this.XhN);
      this.sRw = isLandscape();
      this.XhK.setContentView(this.XhM);
      AppMethodBeat.o(80973);
      return;
    }
  }
  
  private void iAS()
  {
    AppMethodBeat.i(80974);
    if ((Build.VERSION.SDK_INT >= 23) && (this.XhK != null))
    {
      this.XhK.getWindow().getDecorView().setSystemUiVisibility(9216);
      this.XhK.getWindow().setStatusBarColor(0);
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
    if (this.XhK != null)
    {
      if (this.XhK.isShowing())
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
    if (this.XhM != null) {
      this.XhM.setGameMenuItemSelectedListener(paramc);
    }
    AppMethodBeat.o(80978);
  }
  
  public final void cyW()
  {
    AppMethodBeat.i(80976);
    if (this.mP != null)
    {
      if (!this.mP.isAlive()) {
        this.mP = this.mF.getViewTreeObserver();
      }
      this.mP.removeGlobalOnLayoutListener(this);
      this.mP = null;
    }
    if (this.XhK != null) {
      this.XhK.dismiss();
    }
    AppMethodBeat.o(80976);
  }
  
  public final void dDn()
  {
    int i = 0;
    AppMethodBeat.i(80975);
    this.sRw = isLandscape();
    if (this.XhL != null) {
      this.XhL.onCreateMMMenu(this.Vtk);
    }
    if (this.XhK != null)
    {
      if (this.XhN != null) {
        this.XhN.v(this.Vtk);
      }
      if (Build.VERSION.SDK_INT >= 21) {
        this.XhK.getWindow().addFlags(-2147483648);
      }
      if (this.GwR) {
        iAS();
      }
      if (this.sRy) {
        this.XhK.getWindow().addFlags(1024);
      }
      if (!this.sRz) {
        break label248;
      }
      this.XhK.getWindow().setFlags(8, 8);
      this.XhK.getWindow().addFlags(131200);
      this.XhK.getWindow().getDecorView().setSystemUiVisibility(6);
    }
    for (;;)
    {
      if (this.mF != null)
      {
        if (this.mP == null) {
          i = 1;
        }
        this.mP = this.mF.getViewTreeObserver();
        if (i != 0) {
          this.mP.addOnGlobalLayoutListener(this);
        }
      }
      this.XhK.setOnDismissListener(new DialogInterface.OnDismissListener()
      {
        public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(80970);
          d.this.cyW();
          AppMethodBeat.o(80970);
        }
      });
      if (this.XhM != null) {
        this.XhM.setDismissListener(new b.a()
        {
          public final void onDismiss()
          {
            AppMethodBeat.i(80971);
            d.this.cyW();
            AppMethodBeat.o(80971);
          }
        });
      }
      this.XhK.show();
      AppMethodBeat.o(80975);
      return;
      label248:
      this.XhK.getWindow().clearFlags(8);
      this.XhK.getWindow().clearFlags(131072);
      this.XhK.getWindow().clearFlags(128);
      this.XhK.getWindow().getDecorView().setSystemUiVisibility(0);
    }
  }
  
  public final void onGlobalLayout()
  {
    AppMethodBeat.i(80972);
    if (isShowing())
    {
      View localView = this.mF;
      if ((localView == null) || (!localView.isShown()))
      {
        cyW();
        AppMethodBeat.o(80972);
        return;
      }
      if ((isShowing()) && (this.sRw != isLandscape())) {
        cyW();
      }
    }
    AppMethodBeat.o(80972);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.menu.d
 * JD-Core Version:    0.7.0.1
 */
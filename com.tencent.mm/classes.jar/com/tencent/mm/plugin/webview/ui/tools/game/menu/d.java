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
import com.tencent.mm.ui.base.o;

public final class d
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private boolean AUA;
  private o ODY;
  private e Qpw;
  public b.b Qpx;
  private GameMenuView Qpy;
  private f Qpz;
  private View lJ;
  private ViewTreeObserver lS;
  private Context mContext;
  private boolean pMD;
  public boolean pMF;
  public boolean pMG;
  
  public d(Context paramContext)
  {
    AppMethodBeat.i(80973);
    this.pMD = false;
    this.pMG = false;
    this.mContext = paramContext;
    if ((this.mContext instanceof Activity))
    {
      paramContext = (ViewGroup)((Activity)this.mContext).getWindow().getDecorView();
      if (paramContext.getChildCount() <= 0) {
        break label156;
      }
    }
    label156:
    for (this.lJ = paramContext.getChildAt(0);; this.lJ = paramContext)
    {
      paramContext = this.mContext;
      this.ODY = new o(paramContext);
      this.Qpw = new e(paramContext);
      this.Qpy = new GameMenuView(paramContext);
      this.Qpz = new f(paramContext);
      this.Qpy.setAdapter(this.Qpz);
      this.pMD = isLandscape();
      this.Qpw.setContentView(this.Qpy);
      AppMethodBeat.o(80973);
      return;
    }
  }
  
  @TargetApi(23)
  private void haF()
  {
    AppMethodBeat.i(80974);
    if ((Build.VERSION.SDK_INT >= 23) && (this.Qpw != null))
    {
      this.Qpw.getWindow().getDecorView().setSystemUiVisibility(9216);
      this.Qpw.getWindow().setStatusBarColor(0);
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
    if (this.Qpw != null)
    {
      if (this.Qpw.isShowing())
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
    if (this.Qpy != null) {
      this.Qpy.setGameMenuItemSelectedListener(paramc);
    }
    AppMethodBeat.o(80978);
  }
  
  public final void bYF()
  {
    AppMethodBeat.i(80976);
    if (this.lS != null)
    {
      if (!this.lS.isAlive()) {
        this.lS = this.lJ.getViewTreeObserver();
      }
      this.lS.removeGlobalOnLayoutListener(this);
      this.lS = null;
    }
    if (this.Qpw != null) {
      this.Qpw.dismiss();
    }
    AppMethodBeat.o(80976);
  }
  
  public final void eik()
  {
    int i = 0;
    AppMethodBeat.i(80975);
    this.pMD = isLandscape();
    if (this.Qpx != null) {
      this.Qpx.onCreateMMMenu(this.ODY);
    }
    if (this.Qpw != null)
    {
      if (this.Qpz != null) {
        this.Qpz.c(this.ODY);
      }
      if (Build.VERSION.SDK_INT >= 21) {
        this.Qpw.getWindow().addFlags(-2147483648);
      }
      if (this.AUA) {
        haF();
      }
      if (this.pMF) {
        this.Qpw.getWindow().addFlags(1024);
      }
      if (!this.pMG) {
        break label248;
      }
      this.Qpw.getWindow().setFlags(8, 8);
      this.Qpw.getWindow().addFlags(131200);
      this.Qpw.getWindow().getDecorView().setSystemUiVisibility(6);
    }
    for (;;)
    {
      if (this.lJ != null)
      {
        if (this.lS == null) {
          i = 1;
        }
        this.lS = this.lJ.getViewTreeObserver();
        if (i != 0) {
          this.lS.addOnGlobalLayoutListener(this);
        }
      }
      this.Qpw.setOnDismissListener(new DialogInterface.OnDismissListener()
      {
        public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(80970);
          d.this.bYF();
          AppMethodBeat.o(80970);
        }
      });
      if (this.Qpy != null) {
        this.Qpy.setDismissListener(new b.a()
        {
          public final void onDismiss()
          {
            AppMethodBeat.i(80971);
            d.this.bYF();
            AppMethodBeat.o(80971);
          }
        });
      }
      this.Qpw.show();
      AppMethodBeat.o(80975);
      return;
      label248:
      this.Qpw.getWindow().clearFlags(8);
      this.Qpw.getWindow().clearFlags(131072);
      this.Qpw.getWindow().clearFlags(128);
      this.Qpw.getWindow().getDecorView().setSystemUiVisibility(0);
    }
  }
  
  public final void onGlobalLayout()
  {
    AppMethodBeat.i(80972);
    if (isShowing())
    {
      View localView = this.lJ;
      if ((localView == null) || (!localView.isShown()))
      {
        bYF();
        AppMethodBeat.o(80972);
        return;
      }
      if ((isShowing()) && (this.pMD != isLandscape())) {
        bYF();
      }
    }
    AppMethodBeat.o(80972);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.menu.d
 * JD-Core Version:    0.7.0.1
 */
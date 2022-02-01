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
import com.tencent.mm.ui.base.l;

public final class d
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private e CGF;
  public b.b CGG;
  private l CGH;
  private GameMenuView CGI;
  private f CGJ;
  private ViewTreeObserver adE;
  private boolean lcE;
  public boolean lcG;
  public boolean lcH;
  private Context mContext;
  private View oP;
  private boolean rVy;
  
  public d(Context paramContext)
  {
    AppMethodBeat.i(80973);
    this.lcE = false;
    this.lcH = false;
    this.mContext = paramContext;
    if ((this.mContext instanceof Activity))
    {
      paramContext = (ViewGroup)((Activity)this.mContext).getWindow().getDecorView();
      if (paramContext.getChildCount() <= 0) {
        break label156;
      }
    }
    label156:
    for (this.oP = paramContext.getChildAt(0);; this.oP = paramContext)
    {
      paramContext = this.mContext;
      this.CGH = new l(paramContext);
      this.CGF = new e(paramContext);
      this.CGI = new GameMenuView(paramContext);
      this.CGJ = new f(paramContext);
      this.CGI.setAdapter(this.CGJ);
      this.lcE = aly();
      this.CGF.setContentView(this.CGI);
      AppMethodBeat.o(80973);
      return;
    }
  }
  
  private boolean aly()
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
  
  @TargetApi(23)
  private void eFw()
  {
    AppMethodBeat.i(80974);
    if ((Build.VERSION.SDK_INT >= 23) && (this.CGF != null))
    {
      this.CGF.getWindow().getDecorView().setSystemUiVisibility(9216);
      this.CGF.getWindow().setStatusBarColor(0);
    }
    AppMethodBeat.o(80974);
  }
  
  private boolean isShowing()
  {
    AppMethodBeat.i(80977);
    if (this.CGF != null)
    {
      if (this.CGF.isShowing())
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
    if (this.CGI != null) {
      this.CGI.setGameMenuItemSelectedListener(paramc);
    }
    AppMethodBeat.o(80978);
  }
  
  public final void bmi()
  {
    AppMethodBeat.i(80976);
    if (this.adE != null)
    {
      if (!this.adE.isAlive()) {
        this.adE = this.oP.getViewTreeObserver();
      }
      this.adE.removeGlobalOnLayoutListener(this);
      this.adE = null;
    }
    if (this.CGF != null) {
      this.CGF.dismiss();
    }
    AppMethodBeat.o(80976);
  }
  
  public final void cED()
  {
    int i = 0;
    AppMethodBeat.i(80975);
    this.lcE = aly();
    if (this.CGG != null) {
      this.CGG.onCreateMMMenu(this.CGH);
    }
    if (this.CGF != null)
    {
      if (this.CGJ != null) {
        this.CGJ.a(this.CGH);
      }
      if (Build.VERSION.SDK_INT >= 21) {
        this.CGF.getWindow().addFlags(-2147483648);
      }
      if (this.rVy) {
        eFw();
      }
      if (this.lcG) {
        this.CGF.getWindow().addFlags(1024);
      }
      if (!this.lcH) {
        break label248;
      }
      this.CGF.getWindow().setFlags(8, 8);
      this.CGF.getWindow().addFlags(131200);
      this.CGF.getWindow().getDecorView().setSystemUiVisibility(6);
    }
    for (;;)
    {
      if (this.oP != null)
      {
        if (this.adE == null) {
          i = 1;
        }
        this.adE = this.oP.getViewTreeObserver();
        if (i != 0) {
          this.adE.addOnGlobalLayoutListener(this);
        }
      }
      this.CGF.setOnDismissListener(new DialogInterface.OnDismissListener()
      {
        public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(80970);
          d.this.bmi();
          AppMethodBeat.o(80970);
        }
      });
      if (this.CGI != null) {
        this.CGI.setDismissListener(new b.a()
        {
          public final void onDismiss()
          {
            AppMethodBeat.i(80971);
            d.this.bmi();
            AppMethodBeat.o(80971);
          }
        });
      }
      this.CGF.show();
      AppMethodBeat.o(80975);
      return;
      label248:
      this.CGF.getWindow().clearFlags(8);
      this.CGF.getWindow().clearFlags(131072);
      this.CGF.getWindow().clearFlags(128);
      this.CGF.getWindow().getDecorView().setSystemUiVisibility(0);
    }
  }
  
  public final void onGlobalLayout()
  {
    AppMethodBeat.i(80972);
    if (isShowing())
    {
      View localView = this.oP;
      if ((localView == null) || (!localView.isShown()))
      {
        bmi();
        AppMethodBeat.o(80972);
        return;
      }
      if ((isShowing()) && (this.lcE != aly())) {
        bmi();
      }
    }
    AppMethodBeat.o(80972);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.menu.d
 * JD-Core Version:    0.7.0.1
 */
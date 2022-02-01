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
  private e ECv;
  public b.b ECw;
  private l ECx;
  private GameMenuView ECy;
  private f ECz;
  private ViewTreeObserver afv;
  private boolean lEc;
  public boolean lEe;
  public boolean lEf;
  private Context mContext;
  private View qI;
  private boolean tds;
  
  public d(Context paramContext)
  {
    AppMethodBeat.i(80973);
    this.lEc = false;
    this.lEf = false;
    this.mContext = paramContext;
    if ((this.mContext instanceof Activity))
    {
      paramContext = (ViewGroup)((Activity)this.mContext).getWindow().getDecorView();
      if (paramContext.getChildCount() <= 0) {
        break label156;
      }
    }
    label156:
    for (this.qI = paramContext.getChildAt(0);; this.qI = paramContext)
    {
      paramContext = this.mContext;
      this.ECx = new l(paramContext);
      this.ECv = new e(paramContext);
      this.ECy = new GameMenuView(paramContext);
      this.ECz = new f(paramContext);
      this.ECy.setAdapter(this.ECz);
      this.lEc = aoA();
      this.ECv.setContentView(this.ECy);
      AppMethodBeat.o(80973);
      return;
    }
  }
  
  private boolean aoA()
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
  private void eYf()
  {
    AppMethodBeat.i(80974);
    if ((Build.VERSION.SDK_INT >= 23) && (this.ECv != null))
    {
      this.ECv.getWindow().getDecorView().setSystemUiVisibility(9216);
      this.ECv.getWindow().setStatusBarColor(0);
    }
    AppMethodBeat.o(80974);
  }
  
  private boolean isShowing()
  {
    AppMethodBeat.i(80977);
    if (this.ECv != null)
    {
      if (this.ECv.isShowing())
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
    if (this.ECy != null) {
      this.ECy.setGameMenuItemSelectedListener(paramc);
    }
    AppMethodBeat.o(80978);
  }
  
  public final void bqD()
  {
    AppMethodBeat.i(80976);
    if (this.afv != null)
    {
      if (!this.afv.isAlive()) {
        this.afv = this.qI.getViewTreeObserver();
      }
      this.afv.removeGlobalOnLayoutListener(this);
      this.afv = null;
    }
    if (this.ECv != null) {
      this.ECv.dismiss();
    }
    AppMethodBeat.o(80976);
  }
  
  public final void cPF()
  {
    int i = 0;
    AppMethodBeat.i(80975);
    this.lEc = aoA();
    if (this.ECw != null) {
      this.ECw.onCreateMMMenu(this.ECx);
    }
    if (this.ECv != null)
    {
      if (this.ECz != null) {
        this.ECz.a(this.ECx);
      }
      if (Build.VERSION.SDK_INT >= 21) {
        this.ECv.getWindow().addFlags(-2147483648);
      }
      if (this.tds) {
        eYf();
      }
      if (this.lEe) {
        this.ECv.getWindow().addFlags(1024);
      }
      if (!this.lEf) {
        break label248;
      }
      this.ECv.getWindow().setFlags(8, 8);
      this.ECv.getWindow().addFlags(131200);
      this.ECv.getWindow().getDecorView().setSystemUiVisibility(6);
    }
    for (;;)
    {
      if (this.qI != null)
      {
        if (this.afv == null) {
          i = 1;
        }
        this.afv = this.qI.getViewTreeObserver();
        if (i != 0) {
          this.afv.addOnGlobalLayoutListener(this);
        }
      }
      this.ECv.setOnDismissListener(new DialogInterface.OnDismissListener()
      {
        public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(80970);
          d.this.bqD();
          AppMethodBeat.o(80970);
        }
      });
      if (this.ECy != null) {
        this.ECy.setDismissListener(new b.a()
        {
          public final void onDismiss()
          {
            AppMethodBeat.i(80971);
            d.this.bqD();
            AppMethodBeat.o(80971);
          }
        });
      }
      this.ECv.show();
      AppMethodBeat.o(80975);
      return;
      label248:
      this.ECv.getWindow().clearFlags(8);
      this.ECv.getWindow().clearFlags(131072);
      this.ECv.getWindow().clearFlags(128);
      this.ECv.getWindow().getDecorView().setSystemUiVisibility(0);
    }
  }
  
  public final void onGlobalLayout()
  {
    AppMethodBeat.i(80972);
    if (isShowing())
    {
      View localView = this.qI;
      if ((localView == null) || (!localView.isShown()))
      {
        bqD();
        AppMethodBeat.o(80972);
        return;
      }
      if ((isShowing()) && (this.lEc != aoA())) {
        bqD();
      }
    }
    AppMethodBeat.o(80972);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.menu.d
 * JD-Core Version:    0.7.0.1
 */
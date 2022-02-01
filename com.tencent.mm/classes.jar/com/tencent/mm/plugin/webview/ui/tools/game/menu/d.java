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
  private e Ekr;
  public b.b Eks;
  private l Ekt;
  private GameMenuView Eku;
  private f Ekv;
  private ViewTreeObserver afv;
  private boolean lzE;
  public boolean lzG;
  public boolean lzH;
  private Context mContext;
  private View qI;
  private boolean sSh;
  
  public d(Context paramContext)
  {
    AppMethodBeat.i(80973);
    this.lzE = false;
    this.lzH = false;
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
      this.Ekt = new l(paramContext);
      this.Ekr = new e(paramContext);
      this.Eku = new GameMenuView(paramContext);
      this.Ekv = new f(paramContext);
      this.Eku.setAdapter(this.Ekv);
      this.lzE = aol();
      this.Ekr.setContentView(this.Eku);
      AppMethodBeat.o(80973);
      return;
    }
  }
  
  private boolean aol()
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
  private void eUs()
  {
    AppMethodBeat.i(80974);
    if ((Build.VERSION.SDK_INT >= 23) && (this.Ekr != null))
    {
      this.Ekr.getWindow().getDecorView().setSystemUiVisibility(9216);
      this.Ekr.getWindow().setStatusBarColor(0);
    }
    AppMethodBeat.o(80974);
  }
  
  private boolean isShowing()
  {
    AppMethodBeat.i(80977);
    if (this.Ekr != null)
    {
      if (this.Ekr.isShowing())
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
    if (this.Eku != null) {
      this.Eku.setGameMenuItemSelectedListener(paramc);
    }
    AppMethodBeat.o(80978);
  }
  
  public final void bpT()
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
    if (this.Ekr != null) {
      this.Ekr.dismiss();
    }
    AppMethodBeat.o(80976);
  }
  
  public final void cMW()
  {
    int i = 0;
    AppMethodBeat.i(80975);
    this.lzE = aol();
    if (this.Eks != null) {
      this.Eks.onCreateMMMenu(this.Ekt);
    }
    if (this.Ekr != null)
    {
      if (this.Ekv != null) {
        this.Ekv.a(this.Ekt);
      }
      if (Build.VERSION.SDK_INT >= 21) {
        this.Ekr.getWindow().addFlags(-2147483648);
      }
      if (this.sSh) {
        eUs();
      }
      if (this.lzG) {
        this.Ekr.getWindow().addFlags(1024);
      }
      if (!this.lzH) {
        break label248;
      }
      this.Ekr.getWindow().setFlags(8, 8);
      this.Ekr.getWindow().addFlags(131200);
      this.Ekr.getWindow().getDecorView().setSystemUiVisibility(6);
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
      this.Ekr.setOnDismissListener(new DialogInterface.OnDismissListener()
      {
        public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(80970);
          d.this.bpT();
          AppMethodBeat.o(80970);
        }
      });
      if (this.Eku != null) {
        this.Eku.setDismissListener(new b.a()
        {
          public final void onDismiss()
          {
            AppMethodBeat.i(80971);
            d.this.bpT();
            AppMethodBeat.o(80971);
          }
        });
      }
      this.Ekr.show();
      AppMethodBeat.o(80975);
      return;
      label248:
      this.Ekr.getWindow().clearFlags(8);
      this.Ekr.getWindow().clearFlags(131072);
      this.Ekr.getWindow().clearFlags(128);
      this.Ekr.getWindow().getDecorView().setSystemUiVisibility(0);
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
        bpT();
        AppMethodBeat.o(80972);
        return;
      }
      if ((isShowing()) && (this.lzE != aol())) {
        bpT();
      }
    }
    AppMethodBeat.o(80972);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.menu.d
 * JD-Core Version:    0.7.0.1
 */
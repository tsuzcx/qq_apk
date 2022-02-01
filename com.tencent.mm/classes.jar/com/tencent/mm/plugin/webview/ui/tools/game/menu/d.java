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
  private l BoA;
  private GameMenuView BoB;
  private f BoC;
  private e Boy;
  public b.b Boz;
  private ViewTreeObserver acK;
  private boolean kBm;
  public boolean kBo;
  public boolean kBp;
  private Context mContext;
  private View nO;
  private boolean qVs;
  
  public d(Context paramContext)
  {
    AppMethodBeat.i(80973);
    this.kBm = false;
    this.kBp = false;
    this.mContext = paramContext;
    if ((this.mContext instanceof Activity))
    {
      paramContext = (ViewGroup)((Activity)this.mContext).getWindow().getDecorView();
      if (paramContext.getChildCount() <= 0) {
        break label156;
      }
    }
    label156:
    for (this.nO = paramContext.getChildAt(0);; this.nO = paramContext)
    {
      paramContext = this.mContext;
      this.BoA = new l(paramContext);
      this.Boy = new e(paramContext);
      this.BoB = new GameMenuView(paramContext);
      this.BoC = new f(paramContext);
      this.BoB.setAdapter(this.BoC);
      this.kBm = aov();
      this.Boy.setContentView(this.BoB);
      AppMethodBeat.o(80973);
      return;
    }
  }
  
  private boolean aov()
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
  private void eqc()
  {
    AppMethodBeat.i(80974);
    if ((Build.VERSION.SDK_INT >= 23) && (this.Boy != null))
    {
      this.Boy.getWindow().getDecorView().setSystemUiVisibility(9216);
      this.Boy.getWindow().setStatusBarColor(0);
    }
    AppMethodBeat.o(80974);
  }
  
  private boolean isShowing()
  {
    AppMethodBeat.i(80977);
    if (this.Boy != null)
    {
      if (this.Boy.isShowing())
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
    if (this.BoB != null) {
      this.BoB.setGameMenuItemSelectedListener(paramc);
    }
    AppMethodBeat.o(80978);
  }
  
  public final void bfo()
  {
    AppMethodBeat.i(80976);
    if (this.acK != null)
    {
      if (!this.acK.isAlive()) {
        this.acK = this.nO.getViewTreeObserver();
      }
      this.acK.removeGlobalOnLayoutListener(this);
      this.acK = null;
    }
    if (this.Boy != null) {
      this.Boy.dismiss();
    }
    AppMethodBeat.o(80976);
  }
  
  public final void csG()
  {
    int i = 0;
    AppMethodBeat.i(80975);
    this.kBm = aov();
    if (this.Boz != null) {
      this.Boz.onCreateMMMenu(this.BoA);
    }
    if (this.Boy != null)
    {
      if (this.BoC != null) {
        this.BoC.a(this.BoA);
      }
      if (Build.VERSION.SDK_INT >= 21) {
        this.Boy.getWindow().addFlags(-2147483648);
      }
      if (this.qVs) {
        eqc();
      }
      if (this.kBo) {
        this.Boy.getWindow().addFlags(1024);
      }
      if (!this.kBp) {
        break label248;
      }
      this.Boy.getWindow().setFlags(8, 8);
      this.Boy.getWindow().addFlags(131200);
      this.Boy.getWindow().getDecorView().setSystemUiVisibility(6);
    }
    for (;;)
    {
      if (this.nO != null)
      {
        if (this.acK == null) {
          i = 1;
        }
        this.acK = this.nO.getViewTreeObserver();
        if (i != 0) {
          this.acK.addOnGlobalLayoutListener(this);
        }
      }
      this.Boy.setOnDismissListener(new DialogInterface.OnDismissListener()
      {
        public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(80970);
          d.this.bfo();
          AppMethodBeat.o(80970);
        }
      });
      if (this.BoB != null) {
        this.BoB.setDismissListener(new b.a()
        {
          public final void onDismiss()
          {
            AppMethodBeat.i(80971);
            d.this.bfo();
            AppMethodBeat.o(80971);
          }
        });
      }
      this.Boy.show();
      AppMethodBeat.o(80975);
      return;
      label248:
      this.Boy.getWindow().clearFlags(8);
      this.Boy.getWindow().clearFlags(131072);
      this.Boy.getWindow().clearFlags(128);
      this.Boy.getWindow().getDecorView().setSystemUiVisibility(0);
    }
  }
  
  public final void onGlobalLayout()
  {
    AppMethodBeat.i(80972);
    if (isShowing())
    {
      View localView = this.nO;
      if ((localView == null) || (!localView.isShown()))
      {
        bfo();
        AppMethodBeat.o(80972);
        return;
      }
      if ((isShowing()) && (this.kBm != aov())) {
        bfo();
      }
    }
    AppMethodBeat.o(80972);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.menu.d
 * JD-Core Version:    0.7.0.1
 */
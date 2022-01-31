package com.tencent.mm.plugin.webview.ui.tools.game.menu;

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
import com.tencent.mm.ui.base.l;

public final class d
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private ViewTreeObserver US;
  private View hX;
  private Context mContext;
  private l phJ;
  private e rwV;
  public b.b rwW;
  private GameMenuView rwX;
  private f rwY;
  private boolean rwZ = false;
  private boolean rxa;
  public boolean rxb;
  public boolean rxc = false;
  
  public d(Context paramContext)
  {
    this.mContext = paramContext;
    if ((this.mContext instanceof Activity))
    {
      paramContext = (ViewGroup)((Activity)this.mContext).getWindow().getDecorView();
      if (paramContext.getChildCount() <= 0) {
        break label146;
      }
    }
    label146:
    for (this.hX = paramContext.getChildAt(0);; this.hX = paramContext)
    {
      paramContext = this.mContext;
      this.phJ = new l(paramContext);
      this.rwV = new e(paramContext);
      this.rwX = new GameMenuView(paramContext);
      this.rwY = new f(paramContext);
      this.rwX.setAdapter(this.rwY);
      this.rwZ = biH();
      this.rwV.setContentView(this.rwX);
      return;
    }
  }
  
  private boolean biH()
  {
    DisplayMetrics localDisplayMetrics = this.mContext.getResources().getDisplayMetrics();
    return localDisplayMetrics.widthPixels > localDisplayMetrics.heightPixels;
  }
  
  private boolean isShowing()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.rwV != null)
    {
      bool1 = bool2;
      if (this.rwV.isShowing()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final void a(b.c paramc)
  {
    if (this.rwX != null) {
      this.rwX.setGameMenuItemSelectedListener(paramc);
    }
  }
  
  public final void bFp()
  {
    if (this.US != null)
    {
      if (!this.US.isAlive()) {
        this.US = this.hX.getViewTreeObserver();
      }
      this.US.removeGlobalOnLayoutListener(this);
      this.US = null;
    }
    if (this.rwV != null) {
      this.rwV.dismiss();
    }
  }
  
  public final void cfU()
  {
    int i = 0;
    this.rwZ = biH();
    if (this.rwW != null) {
      this.rwW.a(this.phJ);
    }
    if (this.rwV != null)
    {
      if (this.rwY != null)
      {
        f localf = this.rwY;
        localf.phJ = this.phJ;
        localf.notifyDataSetChanged();
      }
      if (Build.VERSION.SDK_INT >= 21) {
        this.rwV.getWindow().addFlags(-2147483648);
      }
      if ((this.rxa) && (Build.VERSION.SDK_INT >= 23) && (this.rwV != null))
      {
        this.rwV.getWindow().getDecorView().setSystemUiVisibility(9216);
        this.rwV.getWindow().setStatusBarColor(0);
      }
      if (this.rxb) {
        this.rwV.getWindow().addFlags(1024);
      }
      if (!this.rxc) {
        break label282;
      }
      this.rwV.getWindow().setFlags(8, 8);
      this.rwV.getWindow().addFlags(131200);
      this.rwV.getWindow().getDecorView().setSystemUiVisibility(6);
    }
    for (;;)
    {
      if (this.hX != null)
      {
        if (this.US == null) {
          i = 1;
        }
        this.US = this.hX.getViewTreeObserver();
        if (i != 0) {
          this.US.addOnGlobalLayoutListener(this);
        }
      }
      this.rwV.setOnDismissListener(new d.1(this));
      if (this.rwX != null) {
        this.rwX.setDismissListener(new b.a()
        {
          public final void onDismiss()
          {
            d.this.bFp();
          }
        });
      }
      this.rwV.show();
      return;
      label282:
      this.rwV.getWindow().clearFlags(8);
      this.rwV.getWindow().clearFlags(131072);
      this.rwV.getWindow().clearFlags(128);
      this.rwV.getWindow().getDecorView().setSystemUiVisibility(0);
    }
  }
  
  public final void onGlobalLayout()
  {
    if (isShowing())
    {
      View localView = this.hX;
      if ((localView != null) && (localView.isShown())) {
        break label28;
      }
      bFp();
    }
    label28:
    while ((!isShowing()) || (this.rwZ == biH())) {
      return;
    }
    bFp();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.game.menu.d
 * JD-Core Version:    0.7.0.1
 */
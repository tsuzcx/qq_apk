package com.tencent.mm.ui.widget.a;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetBehavior.a;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;

public final class g
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private int LtP;
  private int LtQ;
  private LinearLayout LtR;
  private Button LtS;
  private Button LtT;
  private Button LtU;
  private LinearLayout LtV;
  private TextView LtW;
  private a LtX;
  private a LtY;
  public a LtZ;
  private LinearLayout Ltb;
  private LinearLayout Ltc;
  private ViewTreeObserver afv;
  private int jdX;
  public View kFh;
  private Dialog lDY;
  private BottomSheetBehavior lEb;
  private boolean lEc;
  private int lEd;
  private boolean lEf;
  private Context mContext;
  private boolean ov;
  private View qI;
  private boolean tds;
  private boolean tdt;
  
  public g(Context paramContext)
  {
    AppMethodBeat.i(200371);
    this.lEc = false;
    this.tdt = false;
    this.lEf = false;
    this.LtP = 0;
    this.LtQ = 0;
    this.ov = true;
    this.mContext = paramContext;
    this.LtP = 0;
    this.LtQ = 0;
    aN(this.mContext);
    AppMethodBeat.o(200371);
  }
  
  public g(Context paramContext, byte paramByte)
  {
    AppMethodBeat.i(200373);
    this.lEc = false;
    this.tdt = false;
    this.lEf = false;
    this.LtP = 0;
    this.LtQ = 0;
    this.ov = true;
    this.mContext = paramContext;
    this.LtP = 1;
    this.LtQ = 2;
    this.ov = false;
    aN(this.mContext);
    AppMethodBeat.o(200373);
  }
  
  public g(Context paramContext, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(200372);
    this.lEc = false;
    this.tdt = false;
    this.lEf = false;
    this.LtP = 0;
    this.LtQ = 0;
    this.ov = true;
    this.mContext = paramContext;
    this.LtP = paramInt1;
    this.LtQ = paramInt2;
    aN(this.mContext);
    AppMethodBeat.o(200372);
  }
  
  private void aN(Context paramContext)
  {
    AppMethodBeat.i(200376);
    if ((this.mContext instanceof Activity)) {
      this.qI = ((ViewGroup)((Activity)this.mContext).getWindow().getDecorView()).findViewById(16908290);
    }
    this.lDY = new android.support.design.widget.a(paramContext, 2131820788);
    this.kFh = View.inflate(paramContext, 2131494796, null);
    this.Ltb = ((LinearLayout)this.kFh.findViewById(2131297466));
    this.Ltc = ((LinearLayout)this.kFh.findViewById(2131297462));
    this.LtV = ((LinearLayout)this.kFh.findViewById(2131297461));
    fQG();
    initHeaderView();
    this.lEc = aoA();
    this.lDY.setContentView(this.kFh);
    this.lDY.setCancelable(this.ov);
    this.lEb = BottomSheetBehavior.l((View)this.kFh.getParent());
    this.lEb.setState(3);
    this.lEb.oi = new BottomSheetBehavior.a()
    {
      public final void M(int paramAnonymousInt) {}
    };
    this.lDY.setOnDismissListener(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(200366);
        if (g.a(g.this) != null)
        {
          if (!g.a(g.this).isAlive()) {
            g.a(g.this, g.b(g.this).getViewTreeObserver());
          }
          g.a(g.this).removeGlobalOnLayoutListener(g.this);
          g.a(g.this, null);
        }
        if (!g.c(g.this)) {
          g.d(g.this);
        }
        AppMethodBeat.o(200366);
      }
    });
    AppMethodBeat.o(200376);
  }
  
  private boolean aoA()
  {
    AppMethodBeat.i(200394);
    if (this.mContext.getResources().getConfiguration().orientation == 2)
    {
      AppMethodBeat.o(200394);
      return true;
    }
    AppMethodBeat.o(200394);
    return false;
  }
  
  @TargetApi(23)
  private void eYf()
  {
    AppMethodBeat.i(200387);
    if ((Build.VERSION.SDK_INT >= 23) && (this.lDY != null))
    {
      this.lDY.getWindow().getDecorView().setSystemUiVisibility(9216);
      this.lDY.getWindow().setStatusBarColor(0);
    }
    AppMethodBeat.o(200387);
  }
  
  private void fQB()
  {
    AppMethodBeat.i(200393);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.kFh.getLayoutParams();
    if ((this.lEc) && (this.qI != null))
    {
      Rect localRect = new Rect();
      this.qI.getWindowVisibleDisplayFrame(localRect);
      localLayoutParams.width = localRect.right;
    }
    this.kFh.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(200393);
  }
  
  private void fQG()
  {
    AppMethodBeat.i(200385);
    this.LtR = ((LinearLayout)this.kFh.findViewById(2131297590));
    this.LtS = ((Button)this.kFh.findViewById(2131297587));
    this.LtT = ((Button)this.kFh.findViewById(2131297588));
    this.LtU = ((Button)this.kFh.findViewById(2131297600));
    switch (this.LtP)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(200385);
      return;
      this.LtR.setVisibility(8);
      AppMethodBeat.o(200385);
      return;
      this.LtR.setVisibility(0);
      this.LtU.setVisibility(8);
      this.LtS.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(200367);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/dialog/MMHalfBottomDialog$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if (g.e(g.this) != null) {
            g.e(g.this).onClick();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/dialog/MMHalfBottomDialog$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(200367);
        }
      });
      this.LtT.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(200368);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/dialog/MMHalfBottomDialog$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if (g.f(g.this) != null) {
            g.f(g.this).onClick();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/dialog/MMHalfBottomDialog$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(200368);
        }
      });
      AppMethodBeat.o(200385);
      return;
      this.LtR.setVisibility(0);
      this.LtS.setVisibility(8);
      this.LtT.setVisibility(8);
      this.LtU.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(200369);
          b localb = new b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/dialog/MMHalfBottomDialog$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if (g.g(g.this) != null) {
            g.g(g.this).onClick();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/dialog/MMHalfBottomDialog$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(200369);
        }
      });
    }
  }
  
  private int getRotation()
  {
    AppMethodBeat.i(200375);
    int i = 0;
    if ((this.mContext instanceof Activity)) {
      i = ((Activity)this.mContext).getWindow().getWindowManager().getDefaultDisplay().getRotation();
    }
    AppMethodBeat.o(200375);
    return i;
  }
  
  private void initHeaderView()
  {
    AppMethodBeat.i(200386);
    if (this.Ltb != null)
    {
      this.Ltb.setVisibility(0);
      switch (this.LtQ)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(200386);
      return;
      this.Ltb.setVisibility(8);
      AppMethodBeat.o(200386);
      return;
      View localView = LayoutInflater.from(this.mContext).inflate(2131494428, null);
      localView.findViewById(2131298372).setOnClickListener(new g.6(this));
      this.Ltb.removeAllViews();
      this.Ltb.setGravity(17);
      this.Ltb.addView(localView, -1, -2);
      AppMethodBeat.o(200386);
      return;
      localView = LayoutInflater.from(this.mContext).inflate(2131494429, null);
      this.LtW = ((TextView)localView.findViewById(2131305945));
      this.Ltb.removeAllViews();
      this.Ltb.setGravity(17);
      this.Ltb.addView(localView, -1, -2);
    }
  }
  
  public final void a(a parama1, a parama2)
  {
    this.LtX = parama1;
    this.LtY = parama2;
  }
  
  public final void aga(int paramInt)
  {
    AppMethodBeat.i(200379);
    if (this.LtS != null) {
      this.LtS.setTextColor(paramInt);
    }
    AppMethodBeat.o(200379);
  }
  
  public final void agb(int paramInt)
  {
    AppMethodBeat.i(200382);
    if (this.LtU != null)
    {
      this.LtU.setTextColor(this.mContext.getResources().getColor(2131100161));
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(200382);
      return;
      this.LtU.setBackgroundResource(2131231365);
      AppMethodBeat.o(200382);
      return;
      this.LtU.setBackgroundResource(2131231367);
      this.LtU.setTextColor(this.mContext.getResources().getColor(2131101180));
      AppMethodBeat.o(200382);
      return;
      this.LtU.setBackgroundResource(2131231370);
      AppMethodBeat.o(200382);
      return;
      this.LtU.setBackgroundResource(2131231375);
      AppMethodBeat.o(200382);
      return;
      this.LtU.setBackgroundResource(2131231362);
      AppMethodBeat.o(200382);
      return;
      this.LtU.setBackgroundResource(2131231368);
    }
  }
  
  public final g agc(int paramInt)
  {
    AppMethodBeat.i(200388);
    if (this.LtV != null)
    {
      this.LtV.setVisibility(0);
      LayoutInflater.from(this.kFh.getContext()).inflate(paramInt, this.LtV, true);
    }
    AppMethodBeat.o(200388);
    return this;
  }
  
  public final void aw(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(200381);
    if (this.LtU != null) {
      this.LtU.setText(paramCharSequence);
    }
    AppMethodBeat.o(200381);
  }
  
  public final void ax(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(200383);
    if (this.LtW != null) {
      this.LtW.setText(paramCharSequence);
    }
    AppMethodBeat.o(200383);
  }
  
  public final void bqD()
  {
    AppMethodBeat.i(200391);
    if (this.lDY != null)
    {
      if ((!(this.mContext instanceof Activity)) || ((this.mContext != null) && (!((Activity)this.mContext).isFinishing()) && (!((Activity)this.mContext).isDestroyed()))) {
        this.lDY.dismiss();
      }
      if (this.lEb != null) {
        this.lEb.nZ = true;
      }
    }
    AppMethodBeat.o(200391);
  }
  
  public final void c(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    AppMethodBeat.i(200378);
    if ((this.LtS != null) && (this.LtT != null))
    {
      this.LtS.setText(paramCharSequence1);
      this.LtT.setText(paramCharSequence2);
    }
    AppMethodBeat.o(200378);
  }
  
  public final void cPF()
  {
    AppMethodBeat.i(200390);
    this.lEc = aoA();
    this.lEd = getRotation();
    if (this.lDY != null)
    {
      ((ViewGroup)this.kFh.getParent()).setVisibility(0);
      fQB();
      if (Build.VERSION.SDK_INT >= 21) {
        this.lDY.getWindow().addFlags(-2147483648);
      }
      if (this.tds) {
        eYf();
      }
      if (!this.lEf) {
        break label219;
      }
      this.lDY.getWindow().setFlags(8, 8);
      this.lDY.getWindow().addFlags(131200);
      this.lDY.getWindow().getDecorView().setSystemUiVisibility(6);
      if (this.qI != null) {
        if (this.afv != null) {
          break label274;
        }
      }
    }
    label274:
    for (int i = 1;; i = 0)
    {
      this.afv = this.qI.getViewTreeObserver();
      if (i != 0) {
        this.afv.addOnGlobalLayoutListener(this);
      }
      if (((this.mContext instanceof Activity)) && (!((Activity)this.mContext).isFinishing())) {
        this.lDY.show();
      }
      if (this.lEb != null) {
        this.lEb.nZ = false;
      }
      AppMethodBeat.o(200390);
      return;
      label219:
      this.lDY.getWindow().clearFlags(8);
      this.lDY.getWindow().clearFlags(131072);
      this.lDY.getWindow().clearFlags(128);
      this.lDY.getWindow().getDecorView().setSystemUiVisibility(0);
      break;
    }
  }
  
  public final void fQF()
  {
    AppMethodBeat.i(200380);
    if (this.LtT != null) {
      this.LtT.setBackgroundResource(2131231370);
    }
    AppMethodBeat.o(200380);
  }
  
  public final boolean isShowing()
  {
    AppMethodBeat.i(200392);
    if ((this.lDY != null) && (this.lDY.isShowing()))
    {
      AppMethodBeat.o(200392);
      return true;
    }
    AppMethodBeat.o(200392);
    return false;
  }
  
  public final void onGlobalLayout()
  {
    AppMethodBeat.i(200374);
    if (isShowing())
    {
      View localView = this.qI;
      if ((localView == null) || ((!localView.isShown()) && (localView.getVisibility() != 0)))
      {
        bqD();
        AppMethodBeat.o(200374);
        return;
      }
      if ((isShowing()) && ((this.lEc != aoA()) || (this.lEd != getRotation()))) {
        bqD();
      }
    }
    AppMethodBeat.o(200374);
  }
  
  public final void setCustomView(View paramView)
  {
    AppMethodBeat.i(200389);
    if (this.LtV != null)
    {
      this.LtV.setVisibility(0);
      this.LtV.removeAllViews();
      this.LtV.setGravity(17);
      this.LtV.addView(paramView, -1, -2);
    }
    AppMethodBeat.o(200389);
  }
  
  public final void setHeaderView(View paramView)
  {
    AppMethodBeat.i(200384);
    if (this.Ltb != null)
    {
      this.Ltb.setVisibility(0);
      this.Ltb.removeAllViews();
      this.Ltb.setGravity(17);
      this.Ltb.addView(paramView, -1, -2);
    }
    AppMethodBeat.o(200384);
  }
  
  public final void setHeight(int paramInt)
  {
    AppMethodBeat.i(200377);
    if (paramInt != 0)
    {
      this.jdX = paramInt;
      if (this.jdX != 0) {
        this.lEb.J(this.jdX);
      }
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.kFh.getLayoutParams();
      localLayoutParams.height = paramInt;
      this.kFh.setLayoutParams(localLayoutParams);
      this.kFh.invalidate();
    }
    AppMethodBeat.o(200377);
  }
  
  public static abstract interface a
  {
    public abstract void onClick();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.widget.a.g
 * JD-Core Version:    0.7.0.1
 */
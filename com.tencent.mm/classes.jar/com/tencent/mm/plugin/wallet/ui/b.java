package com.tencent.mm.plugin.wallet.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.j;
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.widget.a.i;

public final class b
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private boolean AUA;
  private boolean AUB;
  private int OEl;
  private int OEm;
  private LinearLayout OEn;
  private Button OEo;
  private Button OEp;
  private Button OEq;
  private LinearLayout OEr;
  private LinearLayout OEs;
  private LinearLayout OEt;
  private TextView OEu;
  private a OEv;
  private b OEw;
  private b OEx;
  private b OEy;
  private boolean OEz;
  private boolean bxO;
  private View lJ;
  private ViewTreeObserver lS;
  private Context mContext;
  public View oFW;
  private boolean pMD;
  private int pME;
  private boolean pMG;
  private boolean pMH;
  private Dialog pMz;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(198812);
    this.pMD = false;
    this.AUB = false;
    this.pMG = false;
    this.OEz = false;
    this.pMH = false;
    this.bxO = true;
    this.mContext = paramContext;
    this.OEl = 0;
    this.OEm = 3;
    this.pMH = true;
    bv(this.mContext);
    AppMethodBeat.o(198812);
  }
  
  public b(Context paramContext, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(198805);
    this.pMD = false;
    this.AUB = false;
    this.pMG = false;
    this.OEz = false;
    this.pMH = false;
    this.bxO = true;
    this.mContext = paramContext;
    this.OEl = paramInt1;
    this.OEm = paramInt2;
    bv(this.mContext);
    AppMethodBeat.o(198805);
  }
  
  private static void b(Window paramWindow)
  {
    AppMethodBeat.i(198883);
    if (paramWindow == null)
    {
      AppMethodBeat.o(198883);
      return;
    }
    paramWindow.getDecorView().setSystemUiVisibility(7942);
    AppMethodBeat.o(198883);
  }
  
  private void bv(Context paramContext)
  {
    AppMethodBeat.i(198828);
    if ((this.mContext instanceof Activity)) {
      this.lJ = ((ViewGroup)((Activity)this.mContext).getWindow().getDecorView()).findViewById(16908290);
    }
    if (this.pMH) {}
    for (this.pMz = new com.tencent.mm.ui.widget.a.b(paramContext);; this.pMz = new i(paramContext, a.j.CustomSheetStyle))
    {
      this.oFW = View.inflate(paramContext, a.g.mm_half_bottom_dialog, null);
      this.OEr = ((LinearLayout)this.oFW.findViewById(a.f.bottom_sheet_title));
      this.OEs = ((LinearLayout)this.oFW.findViewById(a.f.bottom_sheet_footer));
      this.OEt = ((LinearLayout)this.oFW.findViewById(a.f.bottom_sheet_custom_layout));
      gIc();
      initHeaderView();
      this.pMD = isLandscape();
      if ((this.pMH) && (this.pMD)) {
        this.pMG = true;
      }
      this.pMz.setContentView(this.oFW);
      this.pMz.setCancelable(this.bxO);
      Ca(false);
      this.pMz.setOnDismissListener(new DialogInterface.OnDismissListener()
      {
        public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(263863);
          if ((b.a(b.this)) && (b.b(b.this))) {
            ((Activity)b.c(b.this)).getWindow().clearFlags(512);
          }
          if (b.d(b.this) != null) {
            b.d(b.this).gId();
          }
          if (b.e(b.this) != null)
          {
            if (!b.e(b.this).isAlive()) {
              b.a(b.this, b.f(b.this).getViewTreeObserver());
            }
            b.e(b.this).removeGlobalOnLayoutListener(b.this);
            b.a(b.this, null);
          }
          if (!b.g(b.this)) {
            b.h(b.this);
          }
          AppMethodBeat.o(263863);
        }
      });
      AppMethodBeat.o(198828);
      return;
    }
  }
  
  private void gIc()
  {
    AppMethodBeat.i(198861);
    this.OEn = ((LinearLayout)this.oFW.findViewById(a.f.btn_ll));
    this.OEo = ((Button)this.oFW.findViewById(a.f.btn_double_left));
    this.OEp = ((Button)this.oFW.findViewById(a.f.btn_double_right));
    this.OEq = ((Button)this.oFW.findViewById(a.f.btn_single));
    switch (this.OEl)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(198861);
      return;
      this.OEn.setVisibility(8);
      AppMethodBeat.o(198861);
      return;
      this.OEn.setVisibility(0);
      this.OEq.setVisibility(8);
      this.OEo.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(278167);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          a.c("com/tencent/mm/plugin/wallet/ui/CommonBottomSheet$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (b.i(b.this) != null) {
            b.i(b.this).onClick();
          }
          a.a(this, "com/tencent/mm/plugin/wallet/ui/CommonBottomSheet$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(278167);
        }
      });
      this.OEp.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(266716);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          a.c("com/tencent/mm/plugin/wallet/ui/CommonBottomSheet$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (b.j(b.this) != null) {
            b.j(b.this).onClick();
          }
          a.a(this, "com/tencent/mm/plugin/wallet/ui/CommonBottomSheet$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(266716);
        }
      });
      AppMethodBeat.o(198861);
      return;
      this.OEn.setVisibility(0);
      this.OEo.setVisibility(8);
      this.OEp.setVisibility(8);
      this.OEq.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(277601);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          a.c("com/tencent/mm/plugin/wallet/ui/CommonBottomSheet$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (b.k(b.this) != null) {
            b.k(b.this).onClick();
          }
          a.a(this, "com/tencent/mm/plugin/wallet/ui/CommonBottomSheet$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(277601);
        }
      });
    }
  }
  
  private int getRotation()
  {
    AppMethodBeat.i(198818);
    int i = 0;
    if ((this.mContext instanceof Activity)) {
      i = ((Activity)this.mContext).getWindow().getWindowManager().getDefaultDisplay().getRotation();
    }
    AppMethodBeat.o(198818);
    return i;
  }
  
  private void initHeaderView()
  {
    AppMethodBeat.i(198867);
    if (this.OEr != null)
    {
      this.OEr.setVisibility(0);
      switch (this.OEm)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(198867);
      return;
      this.OEr.setVisibility(8);
      AppMethodBeat.o(198867);
      return;
      View localView = LayoutInflater.from(this.mContext).inflate(a.g.half_dialog_header_down_arrow, null);
      localView.findViewById(a.f.close_img).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(266112);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          a.c("com/tencent/mm/plugin/wallet/ui/CommonBottomSheet$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          b.this.bYF();
          a.a(this, "com/tencent/mm/plugin/wallet/ui/CommonBottomSheet$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(266112);
        }
      });
      this.OEr.removeAllViews();
      this.OEr.setGravity(17);
      this.OEr.addView(localView, -1, -2);
      AppMethodBeat.o(198867);
      return;
      localView = LayoutInflater.from(this.mContext).inflate(a.g.half_dialog_header_title, null);
      this.OEu = ((TextView)localView.findViewById(a.f.title_text));
      this.OEr.removeAllViews();
      this.OEr.setGravity(17);
      this.OEr.addView(localView, -1, -2);
    }
  }
  
  private boolean isLandscape()
  {
    AppMethodBeat.i(198890);
    if (this.mContext.getResources().getConfiguration().orientation == 2)
    {
      AppMethodBeat.o(198890);
      return true;
    }
    AppMethodBeat.o(198890);
    return false;
  }
  
  public final b Ca(boolean paramBoolean)
  {
    AppMethodBeat.i(198852);
    this.OEz = paramBoolean;
    if (this.oFW == null)
    {
      AppMethodBeat.o(198852);
      return this;
    }
    if (this.OEz)
    {
      if ((this.pMH) && (this.pMD))
      {
        this.oFW.setBackgroundColor(this.mContext.getResources().getColor(a.c.Dark_5));
        AppMethodBeat.o(198852);
        return this;
      }
      this.oFW.setBackgroundResource(a.e.up_corner_dark_bg);
      AppMethodBeat.o(198852);
      return this;
    }
    if ((this.pMH) && (this.pMD))
    {
      this.oFW.setBackgroundColor(this.mContext.getResources().getColor(a.c.BG_5));
      AppMethodBeat.o(198852);
      return this;
    }
    this.oFW.setBackgroundResource(a.e.up_corner_white_bg);
    AppMethodBeat.o(198852);
    return this;
  }
  
  public final void a(a parama)
  {
    this.OEv = parama;
  }
  
  public final void a(b paramb)
  {
    this.OEy = paramb;
  }
  
  public final void ah(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(198840);
    if (this.OEq != null) {
      this.OEq.setText(paramCharSequence);
    }
    AppMethodBeat.o(198840);
  }
  
  public final void amr(int paramInt)
  {
    AppMethodBeat.i(198832);
    if (this.OEq != null) {
      this.OEq.setTextColor(paramInt);
    }
    AppMethodBeat.o(198832);
  }
  
  public final void ams(int paramInt)
  {
    AppMethodBeat.i(198833);
    if (this.OEq != null) {
      this.OEq.setBackgroundResource(paramInt);
    }
    AppMethodBeat.o(198833);
  }
  
  public final void b(DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(198889);
    if (this.pMz != null) {
      this.pMz.setOnCancelListener(paramOnCancelListener);
    }
    AppMethodBeat.o(198889);
  }
  
  public final void bYF()
  {
    AppMethodBeat.i(198886);
    if ((this.pMz != null) && ((!(this.mContext instanceof Activity)) || ((this.mContext != null) && (!((Activity)this.mContext).isFinishing()) && (!((Activity)this.mContext).isDestroyed())))) {
      this.pMz.dismiss();
    }
    AppMethodBeat.o(198886);
  }
  
  public final void eik()
  {
    AppMethodBeat.i(198881);
    this.pMD = isLandscape();
    this.pME = getRotation();
    Object localObject1;
    Object localObject2;
    if (this.pMz != null)
    {
      ((ViewGroup)this.oFW.getParent()).setVisibility(0);
      localObject1 = (FrameLayout.LayoutParams)this.oFW.getLayoutParams();
      if ((this.pMD) && (this.lJ != null))
      {
        localObject2 = new Rect();
        this.lJ.getWindowVisibleDisplayFrame((Rect)localObject2);
        ((FrameLayout.LayoutParams)localObject1).width = Math.min(((Rect)localObject2).right, ((Rect)localObject2).bottom);
        if (this.pMH)
        {
          ((FrameLayout.LayoutParams)localObject1).height = ax.au(this.mContext).y;
          ((FrameLayout.LayoutParams)localObject1).width = ax.au(this.mContext).y;
        }
      }
      this.oFW.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      if (Build.VERSION.SDK_INT >= 21) {
        this.pMz.getWindow().addFlags(-2147483648);
      }
      if ((this.AUA) && (Build.VERSION.SDK_INT >= 23) && (this.pMz != null))
      {
        this.pMz.getWindow().getDecorView().setSystemUiVisibility(9216);
        this.pMz.getWindow().setStatusBarColor(0);
      }
      localObject1 = this.pMz.getWindow();
      if (!this.pMG) {
        break label375;
      }
      ((Window)localObject1).setFlags(8, 8);
      ((Window)localObject1).addFlags(131200);
      ((Window)localObject1).addFlags(1024);
      b((Window)localObject1);
      if (this.lJ != null) {
        if (this.lS != null) {
          break label413;
        }
      }
    }
    label413:
    for (int i = 1;; i = 0)
    {
      this.lS = this.lJ.getViewTreeObserver();
      if (i != 0) {
        this.lS.addOnGlobalLayoutListener(this);
      }
      if (((this.mContext instanceof Activity)) && (!((Activity)this.mContext).isFinishing()))
      {
        localObject2 = ((Activity)this.mContext).getWindow();
        if (this.pMG) {
          ((Window)localObject2).addFlags(512);
        }
        this.pMz.show();
        if (this.pMG)
        {
          b((Window)localObject1);
          b((Window)localObject2);
          ((Window)localObject1).clearFlags(8);
        }
      }
      AppMethodBeat.o(198881);
      return;
      label375:
      ((Window)localObject1).clearFlags(8);
      ((Window)localObject1).clearFlags(131072);
      ((Window)localObject1).clearFlags(128);
      ((Window)localObject1).clearFlags(1024);
      ((Window)localObject1).getDecorView().setSystemUiVisibility(0);
      break;
    }
  }
  
  public final void gIb()
  {
    AppMethodBeat.i(198838);
    Window localWindow = this.pMz.getWindow();
    if (localWindow == null)
    {
      AppMethodBeat.o(198838);
      return;
    }
    localWindow.setWindowAnimations(a.j.InFromRightOutToBottomAnimation);
    AppMethodBeat.o(198838);
  }
  
  public final boolean isShowing()
  {
    AppMethodBeat.i(198888);
    if ((this.pMz != null) && (this.pMz.isShowing()))
    {
      AppMethodBeat.o(198888);
      return true;
    }
    AppMethodBeat.o(198888);
    return false;
  }
  
  public final void onGlobalLayout()
  {
    AppMethodBeat.i(198816);
    if (isShowing())
    {
      View localView = this.lJ;
      if ((localView == null) || ((!localView.isShown()) && (localView.getVisibility() != 0)))
      {
        bYF();
        AppMethodBeat.o(198816);
        return;
      }
      if ((isShowing()) && ((this.pMD != isLandscape()) || (this.pME != getRotation()))) {
        bYF();
      }
    }
    AppMethodBeat.o(198816);
  }
  
  public final void setCustomView(View paramView)
  {
    AppMethodBeat.i(198870);
    if (this.OEt != null)
    {
      this.OEt.setVisibility(0);
      this.OEt.removeAllViews();
      this.OEt.setGravity(17);
      this.OEt.addView(paramView, -1, -2);
    }
    AppMethodBeat.o(198870);
  }
  
  public final void setHeaderView(View paramView)
  {
    AppMethodBeat.i(198844);
    if (this.OEr != null)
    {
      this.OEr.setVisibility(0);
      this.OEr.removeAllViews();
      this.OEr.setGravity(17);
      this.OEr.addView(paramView, -1, -2);
    }
    AppMethodBeat.o(198844);
  }
  
  public static abstract interface a
  {
    public abstract void gId();
  }
  
  public static abstract interface b
  {
    public abstract void onClick();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.ui.b
 * JD-Core Version:    0.7.0.1
 */
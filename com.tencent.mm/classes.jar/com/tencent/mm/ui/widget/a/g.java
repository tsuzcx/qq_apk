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
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cr.a.c;
import com.tencent.mm.cr.a.e;
import com.tencent.mm.cr.a.f;
import com.tencent.mm.cr.a.g;
import com.tencent.mm.cr.a.j;
import com.tencent.mm.hellhoundlib.b.b;

public class g
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private boolean AUA;
  private boolean AUB;
  private int OEl;
  private int OEm;
  private LinearLayout OEn;
  private Button OEo;
  private Button OEp;
  public Button OEq;
  private LinearLayout OEr;
  private LinearLayout OEs;
  protected LinearLayout OEt;
  private TextView OEu;
  private a YnD;
  private a YnE;
  public a YnF;
  protected View YnG;
  public b YnH;
  private boolean bxO;
  private View lJ;
  private ViewTreeObserver lS;
  private Context mContext;
  private int mTz;
  public View oFW;
  private BottomSheetBehavior pMC;
  private boolean pMD;
  private int pME;
  private boolean pMG;
  public Dialog pMz;
  
  public g(Context paramContext)
  {
    AppMethodBeat.i(250290);
    this.pMD = false;
    this.AUB = false;
    this.pMG = false;
    this.OEl = 0;
    this.OEm = 0;
    this.bxO = true;
    this.mContext = paramContext;
    this.OEl = 0;
    this.OEm = 0;
    bv(this.mContext);
    AppMethodBeat.o(250290);
  }
  
  public g(Context paramContext, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(250291);
    this.pMD = false;
    this.AUB = false;
    this.pMG = false;
    this.OEl = 0;
    this.OEm = 0;
    this.bxO = true;
    this.mContext = paramContext;
    this.OEl = paramInt1;
    this.OEm = paramInt2;
    bv(this.mContext);
    AppMethodBeat.o(250291);
  }
  
  public g(Context paramContext, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(250293);
    this.pMD = false;
    this.AUB = false;
    this.pMG = false;
    this.OEl = 0;
    this.OEm = 0;
    this.bxO = true;
    this.mContext = paramContext;
    this.OEl = paramInt1;
    this.OEm = paramInt2;
    this.bxO = paramBoolean;
    bv(this.mContext);
    AppMethodBeat.o(250293);
  }
  
  private void bv(Context paramContext)
  {
    AppMethodBeat.i(250301);
    if ((this.mContext instanceof Activity)) {
      this.lJ = ((ViewGroup)((Activity)this.mContext).getWindow().getDecorView()).findViewById(16908290);
    }
    this.pMz = new com.google.android.material.bottomsheet.a(paramContext, a.j.HalfBottomDialog);
    this.oFW = View.inflate(paramContext, getLayoutId(), null);
    this.OEr = ((LinearLayout)this.oFW.findViewById(a.f.bottom_sheet_title));
    this.OEs = ((LinearLayout)this.oFW.findViewById(a.f.bottom_sheet_footer));
    this.OEt = ((LinearLayout)this.oFW.findViewById(a.f.bottom_sheet_custom_layout));
    this.YnG = this.oFW.findViewById(a.f.touch_outside_custom);
    gIc();
    initHeaderView();
    this.pMD = isLandscape();
    this.pMz.setContentView(this.oFW);
    this.pMz.setCancelable(this.bxO);
    this.pMC = BottomSheetBehavior.cg((View)this.oFW.getParent());
    this.pMC.setState(3);
    this.pMC.bxG = new g.1(this);
    this.pMz.setOnDismissListener(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(249623);
        if (g.a(g.this) != null) {
          g.a(g.this).dismiss();
        }
        if (g.b(g.this) != null)
        {
          if (!g.b(g.this).isAlive()) {
            g.a(g.this, g.c(g.this).getViewTreeObserver());
          }
          g.b(g.this).removeGlobalOnLayoutListener(g.this);
          g.a(g.this, null);
        }
        if (!g.d(g.this)) {
          g.e(g.this);
        }
        AppMethodBeat.o(249623);
      }
    });
    AppMethodBeat.o(250301);
  }
  
  private void gIc()
  {
    AppMethodBeat.i(250334);
    this.OEn = ((LinearLayout)this.oFW.findViewById(a.f.btn_ll));
    this.OEo = ((Button)this.oFW.findViewById(a.f.btn_double_left));
    this.OEp = ((Button)this.oFW.findViewById(a.f.btn_double_right));
    this.OEq = ((Button)this.oFW.findViewById(a.f.btn_single));
    switch (this.OEl)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(250334);
      return;
      this.OEn.setVisibility(8);
      AppMethodBeat.o(250334);
      return;
      this.OEn.setVisibility(0);
      this.OEq.setVisibility(8);
      this.OEo.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(251159);
          b localb = new b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/widget/dialog/MMHalfBottomDialog$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (g.f(g.this) != null) {
            g.f(g.this).onClick();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/dialog/MMHalfBottomDialog$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(251159);
        }
      });
      this.OEp.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(251085);
          b localb = new b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/widget/dialog/MMHalfBottomDialog$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (g.g(g.this) != null) {
            g.g(g.this).onClick();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/dialog/MMHalfBottomDialog$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(251085);
        }
      });
      AppMethodBeat.o(250334);
      return;
      this.OEn.setVisibility(0);
      this.OEo.setVisibility(8);
      this.OEp.setVisibility(8);
      this.OEq.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(249666);
          b localb = new b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/widget/dialog/MMHalfBottomDialog$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (g.h(g.this) != null) {
            g.h(g.this).onClick();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/dialog/MMHalfBottomDialog$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(249666);
        }
      });
    }
  }
  
  private int getRotation()
  {
    AppMethodBeat.i(250297);
    int i = 0;
    if ((this.mContext instanceof Activity)) {
      i = ((Activity)this.mContext).getWindow().getWindowManager().getDefaultDisplay().getRotation();
    }
    AppMethodBeat.o(250297);
    return i;
  }
  
  @TargetApi(23)
  private void haF()
  {
    AppMethodBeat.i(250338);
    if ((Build.VERSION.SDK_INT >= 23) && (this.pMz != null))
    {
      this.pMz.getWindow().getDecorView().setSystemUiVisibility(9216);
      this.pMz.getWindow().setStatusBarColor(0);
    }
    AppMethodBeat.o(250338);
  }
  
  private void icB()
  {
    AppMethodBeat.i(250347);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.oFW.getLayoutParams();
    if ((this.pMD) && (this.lJ != null))
    {
      Rect localRect = new Rect();
      this.lJ.getWindowVisibleDisplayFrame(localRect);
      localLayoutParams.width = localRect.right;
    }
    this.oFW.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(250347);
  }
  
  private void initHeaderView()
  {
    AppMethodBeat.i(250337);
    if (this.OEr != null)
    {
      this.OEr.setVisibility(0);
      switch (this.OEm)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(250337);
      return;
      this.OEr.setVisibility(8);
      AppMethodBeat.o(250337);
      return;
      View localView = LayoutInflater.from(this.mContext).inflate(a.g.half_dialog_header_down_arrow, null);
      localView.findViewById(a.f.close_img).setOnClickListener(new g.6(this));
      this.OEr.removeAllViews();
      this.OEr.setGravity(17);
      this.OEr.addView(localView, -1, -2);
      AppMethodBeat.o(250337);
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
    AppMethodBeat.i(250349);
    if (this.mContext.getResources().getConfiguration().orientation == 2)
    {
      AppMethodBeat.o(250349);
      return true;
    }
    AppMethodBeat.o(250349);
    return false;
  }
  
  public final void D(int paramInt)
  {
    AppMethodBeat.i(250306);
    this.pMC.D(paramInt);
    AppMethodBeat.o(250306);
  }
  
  public final void HM(boolean paramBoolean)
  {
    AppMethodBeat.i(250309);
    if (this.OEp != null) {
      this.OEp.setEnabled(paramBoolean);
    }
    AppMethodBeat.o(250309);
  }
  
  public final void a(a parama)
  {
    this.YnF = parama;
  }
  
  public final void a(a parama1, a parama2)
  {
    this.YnD = parama1;
    this.YnE = parama2;
  }
  
  public final void aT(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(250326);
    if (this.OEu != null) {
      this.OEu.setText(paramCharSequence);
    }
    AppMethodBeat.o(250326);
  }
  
  public final void ah(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(250320);
    if (this.OEq != null) {
      this.OEq.setText(paramCharSequence);
    }
    AppMethodBeat.o(250320);
  }
  
  public final void ays(int paramInt)
  {
    AppMethodBeat.i(250314);
    if (this.OEo != null) {
      this.OEo.setTextColor(paramInt);
    }
    AppMethodBeat.o(250314);
  }
  
  public final void ayt(int paramInt)
  {
    AppMethodBeat.i(250318);
    if (this.OEp != null) {
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(250318);
      return;
      this.OEp.setBackgroundResource(a.e.btn_solid_green);
      AppMethodBeat.o(250318);
      return;
      this.OEp.setBackgroundResource(a.e.btn_solid_red);
      AppMethodBeat.o(250318);
      return;
      this.OEp.setBackgroundResource(a.e.btn_solid_yellow);
      AppMethodBeat.o(250318);
      return;
      this.OEp.setBackgroundResource(a.e.btn_solid_blue);
      AppMethodBeat.o(250318);
      return;
      this.OEp.setBackgroundResource(a.e.btn_solid_orange);
    }
  }
  
  public final void ayu(int paramInt)
  {
    AppMethodBeat.i(250324);
    if (this.OEq != null)
    {
      this.OEq.setTextColor(this.mContext.getResources().getColor(a.c.color_btn_text_selector));
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(250324);
      return;
      this.OEq.setBackgroundResource(a.e.btn_solid_green);
      AppMethodBeat.o(250324);
      return;
      this.OEq.setBackgroundResource(a.e.btn_solid_grey);
      this.OEq.setTextColor(this.mContext.getResources().getColor(a.c.white_btn_text_selector));
      AppMethodBeat.o(250324);
      return;
      this.OEq.setBackgroundResource(a.e.btn_solid_red);
      AppMethodBeat.o(250324);
      return;
      this.OEq.setBackgroundResource(a.e.btn_solid_yellow);
      AppMethodBeat.o(250324);
      return;
      this.OEq.setBackgroundResource(a.e.btn_solid_blue);
      AppMethodBeat.o(250324);
      return;
      this.OEq.setBackgroundResource(a.e.btn_solid_orange);
    }
  }
  
  public final g ayv(int paramInt)
  {
    AppMethodBeat.i(250341);
    if (this.OEt != null)
    {
      this.OEt.setVisibility(0);
      LayoutInflater.from(this.oFW.getContext()).inflate(paramInt, this.OEt, true);
    }
    AppMethodBeat.o(250341);
    return this;
  }
  
  public final void bYF()
  {
    AppMethodBeat.i(250345);
    if (this.YnH != null) {
      this.YnH.dismiss();
    }
    if (this.pMz != null)
    {
      if ((!(this.mContext instanceof Activity)) || ((this.mContext != null) && (!((Activity)this.mContext).isFinishing()) && (!((Activity)this.mContext).isDestroyed()))) {
        this.pMz.dismiss();
      }
      if (this.pMC != null) {
        this.pMC.bxz = true;
      }
    }
    AppMethodBeat.o(250345);
  }
  
  public final void d(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    AppMethodBeat.i(250312);
    if ((this.OEo != null) && (this.OEp != null))
    {
      this.OEo.setText(paramCharSequence1);
      this.OEp.setText(paramCharSequence2);
    }
    AppMethodBeat.o(250312);
  }
  
  public final void eik()
  {
    AppMethodBeat.i(250344);
    this.pMD = isLandscape();
    this.pME = getRotation();
    if (this.pMz != null)
    {
      ((ViewGroup)this.oFW.getParent()).setVisibility(0);
      icB();
      if (Build.VERSION.SDK_INT >= 21) {
        this.pMz.getWindow().addFlags(-2147483648);
      }
      if (this.AUA) {
        haF();
      }
      if (!this.pMG) {
        break label219;
      }
      this.pMz.getWindow().setFlags(8, 8);
      this.pMz.getWindow().addFlags(131200);
      this.pMz.getWindow().getDecorView().setSystemUiVisibility(6);
      if (this.lJ != null) {
        if (this.lS != null) {
          break label274;
        }
      }
    }
    label274:
    for (int i = 1;; i = 0)
    {
      this.lS = this.lJ.getViewTreeObserver();
      if (i != 0) {
        this.lS.addOnGlobalLayoutListener(this);
      }
      if (((this.mContext instanceof Activity)) && (!((Activity)this.mContext).isFinishing())) {
        this.pMz.show();
      }
      if (this.pMC != null) {
        this.pMC.bxz = false;
      }
      AppMethodBeat.o(250344);
      return;
      label219:
      this.pMz.getWindow().clearFlags(8);
      this.pMz.getWindow().clearFlags(131072);
      this.pMz.getWindow().clearFlags(128);
      this.pMz.getWindow().getDecorView().setSystemUiVisibility(0);
      break;
    }
  }
  
  protected int getLayoutId()
  {
    return a.g.mm_half_bottom_dialog;
  }
  
  public final void iL(View paramView)
  {
    AppMethodBeat.i(250331);
    if (this.OEr != null)
    {
      this.OEr.setVisibility(0);
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.OEr.getLayoutParams();
      localLayoutParams.width = -1;
      localLayoutParams.height = -2;
      this.OEr.setLayoutParams(localLayoutParams);
      this.OEr.removeAllViews();
      this.OEr.setGravity(17);
      this.OEr.addView(paramView, -1, -2);
    }
    AppMethodBeat.o(250331);
  }
  
  public final void icG()
  {
    AppMethodBeat.i(250303);
    this.pMz.getWindow().getAttributes().softInputMode = 48;
    AppMethodBeat.o(250303);
  }
  
  public final boolean isShowing()
  {
    AppMethodBeat.i(250346);
    if ((this.pMz != null) && (this.pMz.isShowing()))
    {
      AppMethodBeat.o(250346);
      return true;
    }
    AppMethodBeat.o(250346);
    return false;
  }
  
  public void onGlobalLayout()
  {
    AppMethodBeat.i(250295);
    if (isShowing())
    {
      View localView = this.lJ;
      if ((localView == null) || ((!localView.isShown()) && (localView.getVisibility() != 0)))
      {
        bYF();
        AppMethodBeat.o(250295);
        return;
      }
      if ((isShowing()) && ((this.pMD != isLandscape()) || (this.pME != getRotation()))) {
        bYF();
      }
    }
    AppMethodBeat.o(250295);
  }
  
  public final void setCustomView(View paramView)
  {
    AppMethodBeat.i(250343);
    if (this.OEt != null)
    {
      this.OEt.setVisibility(0);
      this.OEt.removeAllViews();
      this.OEt.setGravity(17);
      this.OEt.addView(paramView, -1, -2);
    }
    AppMethodBeat.o(250343);
  }
  
  public final void setHeaderView(View paramView)
  {
    AppMethodBeat.i(250328);
    if (this.OEr != null)
    {
      this.OEr.setVisibility(0);
      this.OEr.removeAllViews();
      this.OEr.setGravity(17);
      this.OEr.addView(paramView, -1, -2);
    }
    AppMethodBeat.o(250328);
  }
  
  public final void setHeight(int paramInt)
  {
    AppMethodBeat.i(250305);
    if (paramInt != 0)
    {
      this.mTz = paramInt;
      if (this.mTz != 0) {
        this.pMC.D(this.mTz);
      }
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.oFW.getLayoutParams();
      localLayoutParams.height = paramInt;
      this.oFW.setLayoutParams(localLayoutParams);
      this.oFW.invalidate();
    }
    AppMethodBeat.o(250305);
  }
  
  public static abstract interface a
  {
    public abstract void onClick();
  }
  
  public static abstract interface b
  {
    public abstract void dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.widget.a.g
 * JD-Core Version:    0.7.0.1
 */
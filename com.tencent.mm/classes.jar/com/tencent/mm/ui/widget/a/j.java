package com.tencent.mm.ui.widget.a;

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
import com.tencent.mm.ck.a.c;
import com.tencent.mm.ck.a.e;
import com.tencent.mm.ck.a.f;
import com.tencent.mm.ck.a.g;
import com.tencent.mm.ck.a.j;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public class j
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private boolean GwR;
  public boolean GwS;
  private Button VtA;
  private Button VtB;
  private LinearLayout VtC;
  public LinearLayout VtD;
  protected LinearLayout VtE;
  public TextView VtF;
  private boolean VtK;
  public int Vtw;
  private int Vtx;
  private LinearLayout Vty;
  private Button Vtz;
  private LinearLayout agfL;
  private Button agfM;
  private Button agfN;
  public LinearLayout agfO;
  private a agfP;
  private a agfQ;
  public a agfR;
  protected View agfS;
  public b agfT;
  private boolean dqR;
  private Context mContext;
  private View mF;
  private ViewTreeObserver mP;
  private int pQg;
  public View rootView;
  public Dialog sRs;
  private BottomSheetBehavior sRv;
  private boolean sRw;
  private int sRx;
  private boolean sRz;
  
  public j(Context paramContext)
  {
    AppMethodBeat.i(251807);
    this.sRw = false;
    this.GwS = false;
    this.sRz = false;
    this.Vtw = 0;
    this.Vtx = 0;
    this.dqR = true;
    this.VtK = false;
    this.mContext = paramContext;
    this.Vtw = 0;
    this.Vtx = 0;
    ci(this.mContext);
    AppMethodBeat.o(251807);
  }
  
  public j(Context paramContext, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(251810);
    this.sRw = false;
    this.GwS = false;
    this.sRz = false;
    this.Vtw = 0;
    this.Vtx = 0;
    this.dqR = true;
    this.VtK = false;
    this.mContext = paramContext;
    this.Vtw = paramInt1;
    this.Vtx = paramInt2;
    ci(this.mContext);
    AppMethodBeat.o(251810);
  }
  
  public j(Context paramContext, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(251814);
    this.sRw = false;
    this.GwS = false;
    this.sRz = false;
    this.Vtw = 0;
    this.Vtx = 0;
    this.dqR = true;
    this.VtK = false;
    this.mContext = paramContext;
    this.Vtw = paramInt1;
    this.Vtx = paramInt2;
    this.dqR = paramBoolean;
    ci(this.mContext);
    AppMethodBeat.o(251814);
  }
  
  public j(Context paramContext, int paramInt1, int paramInt2, boolean paramBoolean, byte paramByte)
  {
    AppMethodBeat.i(251818);
    this.sRw = false;
    this.GwS = false;
    this.sRz = false;
    this.Vtw = 0;
    this.Vtx = 0;
    this.dqR = true;
    this.VtK = false;
    this.mContext = paramContext;
    this.Vtw = paramInt1;
    this.Vtx = paramInt2;
    this.dqR = true;
    this.VtK = paramBoolean;
    ci(this.mContext);
    AppMethodBeat.o(251818);
  }
  
  private void ci(Context paramContext)
  {
    AppMethodBeat.i(251831);
    if ((this.mContext instanceof Activity)) {
      this.mF = ((ViewGroup)((Activity)this.mContext).getWindow().getDecorView()).findViewById(16908290);
    }
    this.sRs = new l(paramContext, a.j.CustomSheetStyle);
    this.rootView = View.inflate(paramContext, getLayoutId(), null);
    if ((this.rootView != null) && (this.VtK)) {
      this.rootView.setBackgroundResource(a.e.up_corner_dark_bg);
    }
    this.VtC = ((LinearLayout)this.rootView.findViewById(a.f.bottom_sheet_title));
    this.VtD = ((LinearLayout)this.rootView.findViewById(a.f.bottom_sheet_footer));
    this.agfO = ((LinearLayout)this.rootView.findViewById(a.f.bottom_sheet_footer_two));
    this.VtE = ((LinearLayout)this.rootView.findViewById(a.f.bottom_sheet_custom_layout));
    this.agfS = this.rootView.findViewById(a.f.touch_outside_custom);
    ihg();
    initHeaderView();
    this.sRw = isLandscape();
    this.sRs.setContentView(this.rootView);
    this.sRs.setCancelable(this.dqR);
    this.sRs.setOnDismissListener(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(251874);
        if (j.l(j.this) != null) {
          j.l(j.this).dismiss();
        }
        if (j.m(j.this) != null)
        {
          if (!j.m(j.this).isAlive()) {
            j.a(j.this, j.n(j.this).getViewTreeObserver());
          }
          j.m(j.this).removeGlobalOnLayoutListener(j.this);
          j.a(j.this, null);
        }
        if (!j.o(j.this)) {
          j.p(j.this);
        }
        AppMethodBeat.o(251874);
      }
    });
    AppMethodBeat.o(251831);
  }
  
  private int getRotation()
  {
    AppMethodBeat.i(251827);
    int i = 0;
    if ((this.mContext instanceof Activity)) {
      i = ((Activity)this.mContext).getWindow().getWindowManager().getDefaultDisplay().getRotation();
    }
    AppMethodBeat.o(251827);
    return i;
  }
  
  private void iAS()
  {
    AppMethodBeat.i(251844);
    if ((Build.VERSION.SDK_INT >= 23) && (this.sRs != null))
    {
      this.sRs.getWindow().getDecorView().setSystemUiVisibility(9216);
      this.sRs.getWindow().setStatusBarColor(0);
    }
    AppMethodBeat.o(251844);
  }
  
  private void ihg()
  {
    AppMethodBeat.i(251839);
    this.Vty = ((LinearLayout)this.rootView.findViewById(a.f.btn_ll));
    this.Vtz = ((Button)this.rootView.findViewById(a.f.btn_double_left));
    this.VtA = ((Button)this.rootView.findViewById(a.f.btn_double_right));
    this.VtB = ((Button)this.rootView.findViewById(a.f.btn_single));
    this.agfL = ((LinearLayout)this.rootView.findViewById(a.f.btn_ll_up_down));
    this.agfM = ((Button)this.rootView.findViewById(a.f.btn_double_up));
    this.agfN = ((Button)this.rootView.findViewById(a.f.btn_double_down));
    switch (this.Vtw)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(251839);
      return;
      this.Vty.setVisibility(8);
      this.agfL.setVisibility(8);
      AppMethodBeat.o(251839);
      return;
      this.agfL.setVisibility(8);
      this.Vty.setVisibility(0);
      this.VtB.setVisibility(8);
      this.Vtz.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(251870);
          b localb = new b();
          localb.cH(paramAnonymousView);
          a.c("com/tencent/mm/ui/widget/dialog/MMHalfBottomDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          if (j.q(j.this) != null) {
            j.q(j.this).onClick();
          }
          a.a(this, "com/tencent/mm/ui/widget/dialog/MMHalfBottomDialog$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(251870);
        }
      });
      this.VtA.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(251871);
          b localb = new b();
          localb.cH(paramAnonymousView);
          a.c("com/tencent/mm/ui/widget/dialog/MMHalfBottomDialog$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          if (j.r(j.this) != null) {
            j.r(j.this).onClick();
          }
          a.a(this, "com/tencent/mm/ui/widget/dialog/MMHalfBottomDialog$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(251871);
        }
      });
      AppMethodBeat.o(251839);
      return;
      this.agfL.setVisibility(8);
      this.Vty.setVisibility(0);
      this.Vtz.setVisibility(8);
      this.VtA.setVisibility(8);
      this.VtB.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(251833);
          b localb = new b();
          localb.cH(paramAnonymousView);
          a.c("com/tencent/mm/ui/widget/dialog/MMHalfBottomDialog$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          if (j.s(j.this) != null) {
            j.s(j.this).onClick();
          }
          a.a(this, "com/tencent/mm/ui/widget/dialog/MMHalfBottomDialog$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(251833);
        }
      });
      AppMethodBeat.o(251839);
      return;
      this.agfL.setVisibility(0);
      this.Vty.setVisibility(8);
      this.agfN.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(251835);
          b localb = new b();
          localb.cH(paramAnonymousView);
          a.c("com/tencent/mm/ui/widget/dialog/MMHalfBottomDialog$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          if (j.q(j.this) != null) {
            j.q(j.this).onClick();
          }
          a.a(this, "com/tencent/mm/ui/widget/dialog/MMHalfBottomDialog$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(251835);
        }
      });
      this.agfM.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(251821);
          b localb = new b();
          localb.cH(paramAnonymousView);
          a.c("com/tencent/mm/ui/widget/dialog/MMHalfBottomDialog$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          if (j.r(j.this) != null) {
            j.r(j.this).onClick();
          }
          a.a(this, "com/tencent/mm/ui/widget/dialog/MMHalfBottomDialog$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(251821);
        }
      });
    }
  }
  
  private void initHeaderView()
  {
    AppMethodBeat.i(251840);
    if (this.VtC != null)
    {
      this.VtC.setVisibility(0);
      switch (this.Vtx)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(251840);
      return;
      this.VtC.setVisibility(8);
      AppMethodBeat.o(251840);
      return;
      View localView1 = LayoutInflater.from(this.mContext).inflate(a.g.half_dialog_header_down_arrow, null);
      View localView2 = localView1.findViewById(a.f.close_img);
      WeImageView localWeImageView = (WeImageView)localView1.findViewById(a.f.close_icon);
      if (this.VtK)
      {
        localView2.setBackgroundResource(a.e.half_dialog_dark_close_bg);
        localWeImageView.setIconColor(this.mContext.getResources().getColor(a.c.BW_100_Alpha_0_8));
      }
      localView2.setOnClickListener(new j.7(this));
      this.VtC.removeAllViews();
      this.VtC.setGravity(17);
      this.VtC.addView(localView1, -1, -2);
      AppMethodBeat.o(251840);
      return;
      localView1 = LayoutInflater.from(this.mContext).inflate(a.g.half_dialog_header_title, null);
      this.VtF = ((TextView)localView1.findViewById(a.f.title_text));
      this.VtC.removeAllViews();
      this.VtC.setGravity(17);
      this.VtC.addView(localView1, -1, -2);
    }
  }
  
  private boolean isLandscape()
  {
    AppMethodBeat.i(251853);
    if (this.mContext.getResources().getConfiguration().orientation == 2)
    {
      AppMethodBeat.o(251853);
      return true;
    }
    AppMethodBeat.o(251853);
    return false;
  }
  
  private void jHL()
  {
    AppMethodBeat.i(251850);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.rootView.getLayoutParams();
    if ((this.sRw) && (this.mF != null))
    {
      Rect localRect = new Rect();
      this.mF.getWindowVisibleDisplayFrame(localRect);
      localLayoutParams.width = Math.min(localRect.right, localRect.bottom);
    }
    this.rootView.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(251850);
  }
  
  public final void F(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(251957);
    if (this.VtE != null)
    {
      this.VtE.setVisibility(0);
      this.VtE.removeAllViews();
      this.VtE.setGravity(17);
      this.VtE.addView(paramView, -1, -2);
      this.VtE.setPadding(paramInt1, 0, paramInt2, 0);
    }
    AppMethodBeat.o(251957);
  }
  
  public final void NG(boolean paramBoolean)
  {
    AppMethodBeat.i(251901);
    if (this.VtA != null) {
      this.VtA.setEnabled(paramBoolean);
    }
    AppMethodBeat.o(251901);
  }
  
  public final void a(a parama1, a parama2)
  {
    this.agfP = parama1;
    this.agfQ = parama2;
  }
  
  public final void aFb(int paramInt)
  {
    AppMethodBeat.i(251905);
    if (this.Vtz != null) {
      this.Vtz.setTextColor(paramInt);
    }
    AppMethodBeat.o(251905);
  }
  
  public final void aFc(int paramInt)
  {
    AppMethodBeat.i(251907);
    if (this.VtB != null) {
      this.VtB.setTextColor(paramInt);
    }
    AppMethodBeat.o(251907);
  }
  
  public final void aFd(int paramInt)
  {
    AppMethodBeat.i(251913);
    if (this.VtA != null) {
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(251913);
      return;
      this.VtA.setBackgroundResource(a.e.btn_solid_green);
      AppMethodBeat.o(251913);
      return;
      this.VtA.setBackgroundResource(a.e.btn_solid_red);
      AppMethodBeat.o(251913);
      return;
      this.VtA.setBackgroundResource(a.e.btn_solid_yellow);
      AppMethodBeat.o(251913);
      return;
      this.VtA.setBackgroundResource(a.e.btn_solid_blue);
      AppMethodBeat.o(251913);
      return;
      this.VtA.setBackgroundResource(a.e.btn_solid_orange);
    }
  }
  
  public final void aFe(int paramInt)
  {
    AppMethodBeat.i(251926);
    Button localButton;
    int i;
    if (this.VtB != null)
    {
      localButton = this.VtB;
      if (!this.VtK) {
        break label95;
      }
      i = this.mContext.getResources().getColor(a.c.color_btn_alwaydark_text_selector);
      localButton.setTextColor(i);
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(251926);
      return;
      label95:
      i = this.mContext.getResources().getColor(a.c.color_btn_text_selector);
      break;
      this.VtB.setBackgroundResource(a.e.btn_solid_green);
      AppMethodBeat.o(251926);
      return;
      localButton = this.VtB;
      if (this.VtK)
      {
        paramInt = a.e.btn_dark_solid_grey;
        localButton.setBackgroundResource(paramInt);
        localButton = this.VtB;
        if (!this.VtK) {
          break label195;
        }
      }
      label195:
      for (paramInt = this.mContext.getResources().getColor(a.c.color_btn_text_selector);; paramInt = this.mContext.getResources().getColor(a.c.white_btn_text_selector))
      {
        localButton.setTextColor(paramInt);
        AppMethodBeat.o(251926);
        return;
        paramInt = a.e.btn_solid_grey;
        break;
      }
      this.VtB.setBackgroundResource(a.e.btn_solid_red);
      AppMethodBeat.o(251926);
      return;
      this.VtB.setBackgroundResource(a.e.btn_solid_yellow);
      AppMethodBeat.o(251926);
      return;
      this.VtB.setBackgroundResource(a.e.btn_solid_blue);
      AppMethodBeat.o(251926);
      return;
      this.VtB.setBackgroundResource(a.e.btn_solid_orange);
      this.VtB.setBackgroundResource(a.e.btn_dark_solid_white);
      this.VtB.setTextColor(this.mContext.getResources().getColor(a.c.btn_dark_text_selector));
    }
  }
  
  public final j aFf(int paramInt)
  {
    AppMethodBeat.i(251946);
    if (this.VtE != null)
    {
      this.VtE.setVisibility(0);
      LayoutInflater.from(this.rootView.getContext()).inflate(paramInt, this.VtE, true);
    }
    AppMethodBeat.o(251946);
    return this;
  }
  
  public final void au(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(251915);
    if (this.VtB != null) {
      this.VtB.setText(paramCharSequence);
    }
    AppMethodBeat.o(251915);
  }
  
  public final void bh(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(251928);
    if (this.VtF != null) {
      this.VtF.setText(paramCharSequence);
    }
    AppMethodBeat.o(251928);
  }
  
  public void cyW()
  {
    AppMethodBeat.i(251975);
    if (this.sRs != null)
    {
      if ((!(this.mContext instanceof Activity)) || ((this.mContext != null) && (!((Activity)this.mContext).isFinishing()) && (!((Activity)this.mContext).isDestroyed()))) {
        this.sRs.dismiss();
      }
      if (this.sRv != null)
      {
        this.sRv.dqC = true;
        AppMethodBeat.o(251975);
      }
    }
    else if (this.agfT != null)
    {
      this.agfT.dismiss();
    }
    AppMethodBeat.o(251975);
  }
  
  public final void d(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    AppMethodBeat.i(251903);
    if ((this.Vtz != null) && (this.VtA != null))
    {
      this.Vtz.setText(paramCharSequence1);
      this.VtA.setText(paramCharSequence2);
    }
    if ((this.agfN != null) && (this.agfM != null))
    {
      this.agfN.setText(paramCharSequence1);
      this.agfM.setText(paramCharSequence2);
    }
    AppMethodBeat.o(251903);
  }
  
  public final void dDn()
  {
    AppMethodBeat.i(251969);
    this.sRw = isLandscape();
    this.sRx = getRotation();
    if (this.sRs != null)
    {
      ((ViewGroup)this.rootView.getParent()).setVisibility(0);
      jHL();
      if (Build.VERSION.SDK_INT >= 21) {
        this.sRs.getWindow().addFlags(-2147483648);
      }
      if (this.GwR) {
        iAS();
      }
      if (!this.sRz) {
        break label219;
      }
      this.sRs.getWindow().setFlags(8, 8);
      this.sRs.getWindow().addFlags(131200);
      this.sRs.getWindow().getDecorView().setSystemUiVisibility(6);
      if (this.mF != null) {
        if (this.mP != null) {
          break label274;
        }
      }
    }
    label274:
    for (int i = 1;; i = 0)
    {
      this.mP = this.mF.getViewTreeObserver();
      if (i != 0) {
        this.mP.addOnGlobalLayoutListener(this);
      }
      if (((this.mContext instanceof Activity)) && (!((Activity)this.mContext).isFinishing())) {
        this.sRs.show();
      }
      if (this.sRv != null) {
        this.sRv.dqC = false;
      }
      AppMethodBeat.o(251969);
      return;
      label219:
      this.sRs.getWindow().clearFlags(8);
      this.sRs.getWindow().clearFlags(131072);
      this.sRs.getWindow().clearFlags(128);
      this.sRs.getWindow().getDecorView().setSystemUiVisibility(0);
      break;
    }
  }
  
  protected int getLayoutId()
  {
    return a.g.mm_half_bottom_dialog;
  }
  
  public final boolean isShowing()
  {
    AppMethodBeat.i(251980);
    if ((this.sRs != null) && (this.sRs.isShowing()))
    {
      AppMethodBeat.o(251980);
      return true;
    }
    AppMethodBeat.o(251980);
    return false;
  }
  
  public final void jHS()
  {
    AppMethodBeat.i(251891);
    this.sRs.getWindow().getAttributes().softInputMode = 48;
    AppMethodBeat.o(251891);
  }
  
  public final void mi(View paramView)
  {
    AppMethodBeat.i(251941);
    if (this.VtC != null)
    {
      this.VtC.setVisibility(0);
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.VtC.getLayoutParams();
      localLayoutParams.width = -1;
      localLayoutParams.height = -2;
      this.VtC.setLayoutParams(localLayoutParams);
      this.VtC.removeAllViews();
      this.VtC.setGravity(17);
      this.VtC.addView(paramView, -1, -2);
    }
    AppMethodBeat.o(251941);
  }
  
  public void onGlobalLayout()
  {
    AppMethodBeat.i(251885);
    if (isShowing())
    {
      View localView = this.mF;
      if ((localView == null) || ((!localView.isShown()) && (localView.getVisibility() != 0)))
      {
        cyW();
        AppMethodBeat.o(251885);
        return;
      }
      if ((isShowing()) && ((this.sRw != isLandscape()) || (this.sRx != getRotation()))) {
        cyW();
      }
    }
    AppMethodBeat.o(251885);
  }
  
  public final void setCustomView(View paramView)
  {
    AppMethodBeat.i(251951);
    if (this.VtE != null)
    {
      this.VtE.setVisibility(0);
      this.VtE.removeAllViews();
      this.VtE.setGravity(17);
      this.VtE.addView(paramView, -1, -2);
    }
    AppMethodBeat.o(251951);
  }
  
  public final void setHeaderView(View paramView)
  {
    AppMethodBeat.i(251934);
    if (this.VtC != null)
    {
      this.VtC.setVisibility(0);
      this.VtC.removeAllViews();
      this.VtC.setGravity(17);
      this.VtC.addView(paramView, -1, -2);
    }
    AppMethodBeat.o(251934);
  }
  
  public final void setHeight(int paramInt)
  {
    AppMethodBeat.i(251896);
    if (paramInt != 0)
    {
      this.pQg = paramInt;
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.rootView.getLayoutParams();
      localLayoutParams.height = paramInt;
      this.rootView.setLayoutParams(localLayoutParams);
      this.rootView.invalidate();
    }
    AppMethodBeat.o(251896);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.widget.a.j
 * JD-Core Version:    0.7.0.1
 */
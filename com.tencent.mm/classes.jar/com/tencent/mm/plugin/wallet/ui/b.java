package com.tencent.mm.plugin.wallet.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Configuration;
import android.content.res.Resources;
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
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.j;
import com.tencent.mm.ui.widget.a.l;

public final class b
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public boolean GwR;
  private boolean GwS;
  private Button VtA;
  private Button VtB;
  public LinearLayout VtC;
  private LinearLayout VtD;
  public LinearLayout VtE;
  private TextView VtF;
  public a VtG;
  private b VtH;
  private b VtI;
  private b VtJ;
  private boolean VtK;
  private int Vtw;
  private int Vtx;
  private LinearLayout Vty;
  private Button Vtz;
  private boolean dqR;
  public Context mContext;
  public View mF;
  public ViewTreeObserver mP;
  public View rootView;
  public boolean sRA;
  public Dialog sRs;
  public boolean sRw;
  public int sRx;
  public boolean sRz;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(315482);
    this.sRw = false;
    this.GwS = false;
    this.sRz = false;
    this.VtK = false;
    this.sRA = false;
    this.dqR = true;
    this.mContext = paramContext;
    this.Vtw = 0;
    this.Vtx = 3;
    ci(this.mContext);
    AppMethodBeat.o(315482);
  }
  
  public b(Context paramContext, byte paramByte)
  {
    AppMethodBeat.i(315490);
    this.sRw = false;
    this.GwS = false;
    this.sRz = false;
    this.VtK = false;
    this.sRA = false;
    this.dqR = true;
    this.mContext = paramContext;
    this.Vtw = 0;
    this.Vtx = 3;
    this.sRA = true;
    ci(this.mContext);
    AppMethodBeat.o(315490);
  }
  
  public static void b(Window paramWindow)
  {
    AppMethodBeat.i(315501);
    if (paramWindow == null)
    {
      AppMethodBeat.o(315501);
      return;
    }
    paramWindow.getDecorView().setSystemUiVisibility(7942);
    AppMethodBeat.o(315501);
  }
  
  private void ci(Context paramContext)
  {
    AppMethodBeat.i(315493);
    if ((this.mContext instanceof Activity)) {
      this.mF = ((ViewGroup)((Activity)this.mContext).getWindow().getDecorView()).findViewById(16908290);
    }
    if (this.sRA) {}
    for (this.sRs = new com.tencent.mm.ui.widget.a.b(paramContext);; this.sRs = new l(paramContext, a.j.CustomSheetStyle))
    {
      this.rootView = View.inflate(paramContext, a.g.mm_half_bottom_dialog, null);
      this.VtC = ((LinearLayout)this.rootView.findViewById(a.f.bottom_sheet_title));
      this.VtD = ((LinearLayout)this.rootView.findViewById(a.f.bottom_sheet_footer));
      this.VtE = ((LinearLayout)this.rootView.findViewById(a.f.bottom_sheet_custom_layout));
      ihg();
      initHeaderView();
      this.sRw = isLandscape();
      if ((this.sRA) && (this.sRw)) {
        this.sRz = true;
      }
      this.sRs.setContentView(this.rootView);
      this.sRs.setCancelable(this.dqR);
      HF(false);
      this.sRs.setOnDismissListener(new DialogInterface.OnDismissListener()
      {
        public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(315455);
          if ((b.a(b.this)) && (b.b(b.this))) {
            ((Activity)b.c(b.this)).getWindow().clearFlags(512);
          }
          if (b.d(b.this) != null) {
            b.d(b.this).onDismiss(paramAnonymousDialogInterface);
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
          AppMethodBeat.o(315455);
        }
      });
      AppMethodBeat.o(315493);
      return;
    }
  }
  
  private void ihg()
  {
    AppMethodBeat.i(315497);
    this.Vty = ((LinearLayout)this.rootView.findViewById(a.f.btn_ll));
    this.Vtz = ((Button)this.rootView.findViewById(a.f.btn_double_left));
    this.VtA = ((Button)this.rootView.findViewById(a.f.btn_double_right));
    this.VtB = ((Button)this.rootView.findViewById(a.f.btn_single));
    switch (this.Vtw)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(315497);
      return;
      this.Vty.setVisibility(8);
      AppMethodBeat.o(315497);
      return;
      this.Vty.setVisibility(0);
      this.VtB.setVisibility(8);
      this.Vtz.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(315454);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          a.c("com/tencent/mm/plugin/wallet/ui/CommonBottomSheet$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          if (b.i(b.this) != null) {
            b.i(b.this);
          }
          a.a(this, "com/tencent/mm/plugin/wallet/ui/CommonBottomSheet$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(315454);
        }
      });
      this.VtA.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(315459);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          a.c("com/tencent/mm/plugin/wallet/ui/CommonBottomSheet$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          if (b.j(b.this) != null) {
            b.j(b.this);
          }
          a.a(this, "com/tencent/mm/plugin/wallet/ui/CommonBottomSheet$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(315459);
        }
      });
      AppMethodBeat.o(315497);
      return;
      this.Vty.setVisibility(0);
      this.Vtz.setVisibility(8);
      this.VtA.setVisibility(8);
      this.VtB.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(315458);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          a.c("com/tencent/mm/plugin/wallet/ui/CommonBottomSheet$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          if (b.k(b.this) != null) {
            b.k(b.this);
          }
          a.a(this, "com/tencent/mm/plugin/wallet/ui/CommonBottomSheet$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(315458);
        }
      });
    }
  }
  
  private void initHeaderView()
  {
    AppMethodBeat.i(315499);
    if (this.VtC != null)
    {
      this.VtC.setVisibility(0);
      switch (this.Vtx)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(315499);
      return;
      this.VtC.setVisibility(8);
      AppMethodBeat.o(315499);
      return;
      View localView = LayoutInflater.from(this.mContext).inflate(a.g.half_dialog_header_down_arrow, null);
      localView.findViewById(a.f.close_img).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(315456);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          a.c("com/tencent/mm/plugin/wallet/ui/CommonBottomSheet$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          b.this.cyW();
          a.a(this, "com/tencent/mm/plugin/wallet/ui/CommonBottomSheet$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(315456);
        }
      });
      this.VtC.removeAllViews();
      this.VtC.setGravity(17);
      this.VtC.addView(localView, -1, -2);
      AppMethodBeat.o(315499);
      return;
      localView = LayoutInflater.from(this.mContext).inflate(a.g.half_dialog_header_title, null);
      this.VtF = ((TextView)localView.findViewById(a.f.title_text));
      this.VtC.removeAllViews();
      this.VtC.setGravity(17);
      this.VtC.addView(localView, -1, -2);
    }
  }
  
  public final b HF(boolean paramBoolean)
  {
    AppMethodBeat.i(315523);
    this.VtK = paramBoolean;
    if (this.rootView == null)
    {
      AppMethodBeat.o(315523);
      return this;
    }
    if (this.VtK)
    {
      if ((this.sRA) && (this.sRw))
      {
        this.rootView.setBackgroundColor(this.mContext.getResources().getColor(a.c.Dark_5));
        AppMethodBeat.o(315523);
        return this;
      }
      this.rootView.setBackgroundResource(a.e.up_corner_dark_bg);
      AppMethodBeat.o(315523);
      return this;
    }
    if ((this.sRA) && (this.sRw))
    {
      this.rootView.setBackgroundColor(this.mContext.getResources().getColor(a.c.BG_5));
      AppMethodBeat.o(315523);
      return this;
    }
    this.rootView.setBackgroundResource(a.e.up_corner_white_bg);
    AppMethodBeat.o(315523);
    return this;
  }
  
  public final void cyW()
  {
    AppMethodBeat.i(315524);
    if ((this.sRs != null) && ((!(this.mContext instanceof Activity)) || ((this.mContext != null) && (!((Activity)this.mContext).isFinishing()) && (!((Activity)this.mContext).isDestroyed())))) {
      this.sRs.dismiss();
    }
    AppMethodBeat.o(315524);
  }
  
  public final int getRotation()
  {
    AppMethodBeat.i(315522);
    int i = 0;
    if ((this.mContext instanceof Activity)) {
      i = ((Activity)this.mContext).getWindow().getWindowManager().getDefaultDisplay().getRotation();
    }
    AppMethodBeat.o(315522);
    return i;
  }
  
  public final boolean isLandscape()
  {
    AppMethodBeat.i(315526);
    if (this.mContext.getResources().getConfiguration().orientation == 2)
    {
      AppMethodBeat.o(315526);
      return true;
    }
    AppMethodBeat.o(315526);
    return false;
  }
  
  public final boolean isShowing()
  {
    AppMethodBeat.i(315525);
    if ((this.sRs != null) && (this.sRs.isShowing()))
    {
      AppMethodBeat.o(315525);
      return true;
    }
    AppMethodBeat.o(315525);
    return false;
  }
  
  public final void onGlobalLayout()
  {
    AppMethodBeat.i(315521);
    if (isShowing())
    {
      View localView = this.mF;
      if ((localView == null) || ((!localView.isShown()) && (localView.getVisibility() != 0)))
      {
        cyW();
        AppMethodBeat.o(315521);
        return;
      }
      if ((isShowing()) && ((this.sRw != isLandscape()) || (this.sRx != getRotation()))) {
        cyW();
      }
    }
    AppMethodBeat.o(315521);
  }
  
  public static abstract interface a
  {
    public abstract void onDismiss(DialogInterface paramDialogInterface);
  }
  
  public static abstract interface b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.ui.b
 * JD-Core Version:    0.7.0.1
 */
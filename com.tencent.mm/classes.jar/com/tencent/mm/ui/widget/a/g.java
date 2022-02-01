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
import android.support.design.widget.a;
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

public final class g
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private LinearLayout HEW;
  private LinearLayout HEX;
  private int HFH;
  private int HFI;
  private LinearLayout HFJ;
  private Button HFK;
  private Button HFL;
  private Button HFM;
  public LinearLayout HFN;
  private TextView HFO;
  private a HFP;
  private a HFQ;
  public a HFR;
  private ViewTreeObserver acK;
  public View jGG;
  private Dialog kBi;
  private BottomSheetBehavior kBl;
  private boolean kBm;
  private int kBn;
  private boolean kBp;
  private Context mContext;
  private View nO;
  private boolean qVs;
  private boolean qVt;
  
  public g(Context paramContext)
  {
    AppMethodBeat.i(195218);
    this.kBm = false;
    this.qVt = false;
    this.kBp = false;
    this.HFH = 0;
    this.HFI = 0;
    this.mContext = paramContext;
    this.HFH = 0;
    this.HFI = 0;
    aL(this.mContext);
    AppMethodBeat.o(195218);
  }
  
  public g(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(195219);
    this.kBm = false;
    this.qVt = false;
    this.kBp = false;
    this.HFH = 0;
    this.HFI = 0;
    this.mContext = paramContext;
    this.HFH = paramInt;
    this.HFI = 3;
    aL(this.mContext);
    AppMethodBeat.o(195219);
  }
  
  private void aL(Context paramContext)
  {
    AppMethodBeat.i(195222);
    if ((this.mContext instanceof Activity)) {
      this.nO = ((ViewGroup)((Activity)this.mContext).getWindow().getDecorView()).findViewById(16908290);
    }
    this.kBi = new a(paramContext, 2131820788);
    this.jGG = View.inflate(paramContext, 2131494796, null);
    this.HEW = ((LinearLayout)this.jGG.findViewById(2131297466));
    this.HEX = ((LinearLayout)this.jGG.findViewById(2131297462));
    this.HFN = ((LinearLayout)this.jGG.findViewById(2131297461));
    ffz();
    initHeaderView();
    this.kBm = aov();
    this.kBi.setContentView(this.jGG);
    this.kBl = BottomSheetBehavior.l((View)this.jGG.getParent());
    this.kBl.setState(3);
    this.kBl.lq = new BottomSheetBehavior.a()
    {
      public final void N(int paramAnonymousInt) {}
      
      public final void h(float paramAnonymousFloat) {}
    };
    this.kBi.setOnDismissListener(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(195213);
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
        AppMethodBeat.o(195213);
      }
    });
    AppMethodBeat.o(195222);
  }
  
  private boolean aov()
  {
    AppMethodBeat.i(195235);
    if (this.mContext.getResources().getConfiguration().orientation == 2)
    {
      AppMethodBeat.o(195235);
      return true;
    }
    AppMethodBeat.o(195235);
    return false;
  }
  
  @TargetApi(23)
  private void eqc()
  {
    AppMethodBeat.i(195229);
    if ((Build.VERSION.SDK_INT >= 23) && (this.kBi != null))
    {
      this.kBi.getWindow().getDecorView().setSystemUiVisibility(9216);
      this.kBi.getWindow().setStatusBarColor(0);
    }
    AppMethodBeat.o(195229);
  }
  
  private void ffx()
  {
    AppMethodBeat.i(195234);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.jGG.getLayoutParams();
    if ((this.kBm) && (this.nO != null))
    {
      Rect localRect = new Rect();
      this.nO.getWindowVisibleDisplayFrame(localRect);
      localLayoutParams.width = localRect.right;
    }
    this.jGG.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(195234);
  }
  
  private void ffz()
  {
    AppMethodBeat.i(195227);
    this.HFJ = ((LinearLayout)this.jGG.findViewById(2131297590));
    this.HFK = ((Button)this.jGG.findViewById(2131297587));
    this.HFL = ((Button)this.jGG.findViewById(2131297588));
    this.HFM = ((Button)this.jGG.findViewById(2131297600));
    switch (this.HFH)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(195227);
      return;
      this.HFJ.setVisibility(8);
      AppMethodBeat.o(195227);
      return;
      this.HFJ.setVisibility(0);
      this.HFM.setVisibility(8);
      this.HFK.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(195214);
          if (g.e(g.this) != null) {
            g.e(g.this).onClick();
          }
          AppMethodBeat.o(195214);
        }
      });
      this.HFL.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(195215);
          if (g.f(g.this) != null) {
            g.f(g.this).onClick();
          }
          AppMethodBeat.o(195215);
        }
      });
      AppMethodBeat.o(195227);
      return;
      this.HFJ.setVisibility(0);
      this.HFK.setVisibility(8);
      this.HFL.setVisibility(8);
      this.HFM.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(195216);
          if (g.g(g.this) != null) {
            g.g(g.this).onClick();
          }
          AppMethodBeat.o(195216);
        }
      });
    }
  }
  
  private int getRotation()
  {
    AppMethodBeat.i(195221);
    int i = 0;
    if ((this.mContext instanceof Activity)) {
      i = ((Activity)this.mContext).getWindow().getWindowManager().getDefaultDisplay().getRotation();
    }
    AppMethodBeat.o(195221);
    return i;
  }
  
  private void initHeaderView()
  {
    AppMethodBeat.i(195228);
    if (this.HEW != null)
    {
      this.HEW.setVisibility(0);
      switch (this.HFI)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(195228);
      return;
      this.HEW.setVisibility(8);
      AppMethodBeat.o(195228);
      return;
      View localView = LayoutInflater.from(this.mContext).inflate(2131494428, null);
      localView.findViewById(2131298372).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(195217);
          g.this.bfo();
          AppMethodBeat.o(195217);
        }
      });
      this.HEW.removeAllViews();
      this.HEW.setGravity(17);
      this.HEW.addView(localView, -1, -2);
      AppMethodBeat.o(195228);
      return;
      localView = LayoutInflater.from(this.mContext).inflate(2131494429, null);
      this.HFO = ((TextView)localView.findViewById(2131305945));
      this.HEW.removeAllViews();
      this.HEW.setGravity(17);
      this.HEW.addView(localView, -1, -2);
    }
  }
  
  public final void a(a parama1, a parama2)
  {
    this.HFP = parama1;
    this.HFQ = parama2;
  }
  
  public final void aaH(int paramInt)
  {
    AppMethodBeat.i(195225);
    if (this.HFM != null) {
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(195225);
      return;
      this.HFM.setBackgroundResource(2131231365);
      AppMethodBeat.o(195225);
      return;
      this.HFM.setBackgroundResource(2131231367);
      this.HFM.setTextColor(this.mContext.getResources().getColor(2131101180));
      AppMethodBeat.o(195225);
      return;
      this.HFM.setBackgroundResource(2131231370);
      AppMethodBeat.o(195225);
      return;
      this.HFM.setBackgroundResource(2131231375);
      AppMethodBeat.o(195225);
      return;
      this.HFM.setBackgroundResource(2131231362);
      AppMethodBeat.o(195225);
      return;
      this.HFM.setBackgroundResource(2131231368);
    }
  }
  
  public final void aw(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(195224);
    if (this.HFM != null) {
      this.HFM.setText(paramCharSequence);
    }
    AppMethodBeat.o(195224);
  }
  
  public final void bfo()
  {
    AppMethodBeat.i(195232);
    if (this.kBi != null)
    {
      if ((!(this.mContext instanceof Activity)) || ((this.mContext != null) && (!((Activity)this.mContext).isFinishing()) && (!((Activity)this.mContext).isDestroyed()))) {
        this.kBi.dismiss();
      }
      if (this.kBl != null) {
        this.kBl.lh = true;
      }
    }
    AppMethodBeat.o(195232);
  }
  
  public final void c(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    AppMethodBeat.i(195223);
    if ((this.HFK != null) && (this.HFL != null))
    {
      this.HFK.setText(paramCharSequence1);
      this.HFL.setText(paramCharSequence2);
    }
    AppMethodBeat.o(195223);
  }
  
  public final void csG()
  {
    AppMethodBeat.i(195231);
    this.kBm = aov();
    this.kBn = getRotation();
    if (this.kBi != null)
    {
      ((ViewGroup)this.jGG.getParent()).setVisibility(0);
      ffx();
      if (Build.VERSION.SDK_INT >= 21) {
        this.kBi.getWindow().addFlags(-2147483648);
      }
      if (this.qVs) {
        eqc();
      }
      if (!this.kBp) {
        break label219;
      }
      this.kBi.getWindow().setFlags(8, 8);
      this.kBi.getWindow().addFlags(131200);
      this.kBi.getWindow().getDecorView().setSystemUiVisibility(6);
      if (this.nO != null) {
        if (this.acK != null) {
          break label274;
        }
      }
    }
    label274:
    for (int i = 1;; i = 0)
    {
      this.acK = this.nO.getViewTreeObserver();
      if (i != 0) {
        this.acK.addOnGlobalLayoutListener(this);
      }
      if (((this.mContext instanceof Activity)) && (!((Activity)this.mContext).isFinishing())) {
        this.kBi.show();
      }
      if (this.kBl != null) {
        this.kBl.lh = false;
      }
      AppMethodBeat.o(195231);
      return;
      label219:
      this.kBi.getWindow().clearFlags(8);
      this.kBi.getWindow().clearFlags(131072);
      this.kBi.getWindow().clearFlags(128);
      this.kBi.getWindow().getDecorView().setSystemUiVisibility(0);
      break;
    }
  }
  
  public final boolean isShowing()
  {
    AppMethodBeat.i(195233);
    if ((this.kBi != null) && (this.kBi.isShowing()))
    {
      AppMethodBeat.o(195233);
      return true;
    }
    AppMethodBeat.o(195233);
    return false;
  }
  
  public final void onGlobalLayout()
  {
    AppMethodBeat.i(195220);
    if (isShowing())
    {
      View localView = this.nO;
      if ((localView == null) || ((!localView.isShown()) && (localView.getVisibility() != 0)))
      {
        bfo();
        AppMethodBeat.o(195220);
        return;
      }
      if ((isShowing()) && ((this.kBm != aov()) || (this.kBn != getRotation()))) {
        bfo();
      }
    }
    AppMethodBeat.o(195220);
  }
  
  public final void setCustomView(View paramView)
  {
    AppMethodBeat.i(195230);
    if (this.HFN != null)
    {
      this.HFN.setVisibility(0);
      this.HFN.removeAllViews();
      this.HFN.setGravity(17);
      this.HFN.addView(paramView, -1, -2);
    }
    AppMethodBeat.o(195230);
  }
  
  public final void setHeaderView(View paramView)
  {
    AppMethodBeat.i(195226);
    if (this.HEW != null)
    {
      this.HEW.setVisibility(0);
      this.HEW.removeAllViews();
      this.HEW.setGravity(17);
      this.HEW.addView(paramView, -1, -2);
    }
    AppMethodBeat.o(195226);
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
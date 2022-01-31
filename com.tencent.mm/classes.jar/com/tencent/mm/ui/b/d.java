package com.tencent.mm.ui.b;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.aa;
import android.support.v4.view.t;
import android.support.v4.view.x;
import android.support.v4.view.y;
import android.support.v4.view.z;
import android.support.v7.a.a.a;
import android.support.v7.app.ActionBar;
import android.support.v7.view.b;
import android.support.v7.view.b.a;
import android.support.v7.view.g;
import android.support.v7.view.menu.h.a;
import android.support.v7.widget.ActionBarContainer;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.ActionBarOverlayLayout.a;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.u;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public final class d
  extends ActionBar
  implements ActionBarOverlayLayout.a
{
  private static final Interpolator Qt;
  private static final Interpolator Qu;
  private static final boolean zgf;
  u PY;
  private boolean QC;
  b QE;
  b.a QF;
  private int QH;
  private boolean QI;
  private boolean QJ;
  private boolean QK;
  private boolean QL;
  private boolean QM;
  private android.support.v7.view.h QN;
  private boolean QO;
  final y QQ;
  final y QR;
  final aa QS;
  private boolean Qc;
  private ArrayList<Object> Qd;
  private Context Qv;
  private ActionBarContainer Qx;
  private ActionBarContextView Qy;
  private View Qz;
  private Activity mActivity;
  private Context mContext;
  a zgg;
  
  static
  {
    AppMethodBeat.i(106217);
    Qt = new AccelerateInterpolator();
    Qu = new DecelerateInterpolator();
    if (Build.VERSION.SDK_INT >= 14) {}
    for (boolean bool = true;; bool = false)
    {
      zgf = bool;
      AppMethodBeat.o(106217);
      return;
    }
  }
  
  public d(Activity paramActivity, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(106178);
    this.Qd = new ArrayList();
    this.QH = 0;
    this.QI = true;
    this.QM = true;
    this.QQ = new z()
    {
      public final void aC(View paramAnonymousView)
      {
        AppMethodBeat.i(106158);
        if ((d.a(d.this)) && (d.b(d.this) != null))
        {
          t.e(d.b(d.this), 0.0F);
          t.e(d.c(d.this), 0.0F);
        }
        d.c(d.this).setVisibility(8);
        d.c(d.this).setTransitioning(false);
        d.d(d.this);
        paramAnonymousView = d.this;
        if (paramAnonymousView.QF != null)
        {
          paramAnonymousView.QF.a(paramAnonymousView.QE);
          paramAnonymousView.QE = null;
          paramAnonymousView.QF = null;
        }
        AppMethodBeat.o(106158);
      }
    };
    this.QR = new z()
    {
      public final void aC(View paramAnonymousView)
      {
        AppMethodBeat.i(106159);
        d.d(d.this);
        d.c(d.this).requestLayout();
        AppMethodBeat.o(106159);
      }
    };
    this.QS = new aa()
    {
      public final void dJ()
      {
        AppMethodBeat.i(106160);
        ((View)d.c(d.this).getParent()).invalidate();
        AppMethodBeat.o(106160);
      }
    };
    this.mActivity = paramActivity;
    paramActivity = paramViewGroup.findViewById(2131820957);
    if ((paramActivity instanceof u)) {}
    for (paramActivity = (u)paramActivity;; paramActivity = ((Toolbar)paramActivity).getWrapper())
    {
      this.PY = paramActivity;
      this.Qy = ((ActionBarContextView)paramViewGroup.findViewById(2131820958));
      this.Qx = ((ActionBarContainer)paramViewGroup.findViewById(2131820956));
      if ((this.PY != null) && (this.Qy != null) && (this.Qx != null)) {
        break label247;
      }
      paramActivity = new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
      AppMethodBeat.o(106178);
      throw paramActivity;
      if (!(paramActivity instanceof Toolbar)) {
        break;
      }
    }
    if ("Can't make a decor toolbar out of ".concat(String.valueOf(paramActivity)) != null) {}
    for (paramActivity = paramActivity.getClass().getSimpleName();; paramActivity = "null")
    {
      paramActivity = new IllegalStateException(paramActivity);
      AppMethodBeat.o(106178);
      throw paramActivity;
    }
    label247:
    this.mContext = this.PY.getContext();
    if ((this.PY.getDisplayOptions() & 0x4) != 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        this.QC = true;
      }
      android.support.v7.view.a.W(this.mContext).fA();
      paramActivity = this.mContext.obtainStyledAttributes(null, a.a.ActionBar, 2130772139, 0);
      paramActivity.getBoolean(19, false);
      i = paramActivity.getDimensionPixelSize(26, 0);
      if (i != 0) {
        setElevation(i);
      }
      paramActivity.recycle();
      this.Qz = null;
      AppMethodBeat.o(106178);
      return;
    }
  }
  
  private void P(boolean paramBoolean)
  {
    AppMethodBeat.i(106203);
    if (c(this.QJ, this.QK, this.QL))
    {
      if (!this.QM)
      {
        this.QM = true;
        Q(paramBoolean);
        AppMethodBeat.o(106203);
      }
    }
    else if (this.QM)
    {
      this.QM = false;
      R(paramBoolean);
    }
    AppMethodBeat.o(106203);
  }
  
  private void Q(boolean paramBoolean)
  {
    AppMethodBeat.i(106204);
    if (this.QN != null) {
      this.QN.cancel();
    }
    this.Qx.setVisibility(0);
    if ((this.QH == 0) && (zgf) && ((this.QO) || (paramBoolean)))
    {
      t.e(this.Qx, 0.0F);
      float f2 = -this.Qx.getHeight();
      float f1 = f2;
      if (paramBoolean)
      {
        localObject = new int[2];
        Object tmp83_81 = localObject;
        tmp83_81[0] = 0;
        Object tmp87_83 = tmp83_81;
        tmp87_83[1] = 0;
        tmp87_83;
        this.Qx.getLocationInWindow((int[])localObject);
        f1 = f2 - localObject[1];
      }
      t.e(this.Qx, f1);
      Object localObject = new android.support.v7.view.h();
      x localx = t.ab(this.Qx).t(0.0F);
      localx.a(this.QS);
      ((android.support.v7.view.h)localObject).a(localx);
      if ((this.QI) && (this.Qz != null))
      {
        t.e(this.Qz, f1);
        ((android.support.v7.view.h)localObject).a(t.ab(this.Qz).t(0.0F));
      }
      ((android.support.v7.view.h)localObject).d(Qu);
      ((android.support.v7.view.h)localObject).fF();
      ((android.support.v7.view.h)localObject).b(this.QR);
      this.QN = ((android.support.v7.view.h)localObject);
      ((android.support.v7.view.h)localObject).start();
      AppMethodBeat.o(106204);
      return;
    }
    t.f(this.Qx, 1.0F);
    t.e(this.Qx, 0.0F);
    if ((this.QI) && (this.Qz != null)) {
      t.e(this.Qz, 0.0F);
    }
    this.QR.aC(null);
    AppMethodBeat.o(106204);
  }
  
  private void R(boolean paramBoolean)
  {
    AppMethodBeat.i(106205);
    if (this.QN != null) {
      this.QN.cancel();
    }
    if ((this.QH == 0) && (zgf) && ((this.QO) || (paramBoolean)))
    {
      t.f(this.Qx, 1.0F);
      this.Qx.setTransitioning(true);
      android.support.v7.view.h localh = new android.support.v7.view.h();
      float f2 = -this.Qx.getHeight();
      float f1 = f2;
      if (paramBoolean)
      {
        localObject = new int[2];
        Object tmp92_90 = localObject;
        tmp92_90[0] = 0;
        Object tmp96_92 = tmp92_90;
        tmp96_92[1] = 0;
        tmp96_92;
        this.Qx.getLocationInWindow((int[])localObject);
        f1 = f2 - localObject[1];
      }
      Object localObject = t.ab(this.Qx).t(f1);
      ((x)localObject).a(this.QS);
      localh.a((x)localObject);
      if ((this.QI) && (this.Qz != null)) {
        localh.a(t.ab(this.Qz).t(f1));
      }
      localh.d(Qt);
      localh.fF();
      localh.b(this.QQ);
      this.QN = localh;
      localh.start();
      AppMethodBeat.o(106205);
      return;
    }
    this.QQ.aC(null);
    AppMethodBeat.o(106205);
  }
  
  private static boolean c(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramBoolean3) {}
    while ((!paramBoolean1) && (!paramBoolean2)) {
      return true;
    }
    return false;
  }
  
  private void eX()
  {
    AppMethodBeat.i(106198);
    if (!this.QL)
    {
      this.QL = true;
      P(false);
    }
    AppMethodBeat.o(106198);
  }
  
  private void eZ()
  {
    AppMethodBeat.i(106201);
    if (this.QL)
    {
      this.QL = false;
      P(false);
    }
    AppMethodBeat.o(106201);
  }
  
  private void setDisplayOptions(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(106190);
    int i = this.PY.getDisplayOptions();
    if ((paramInt2 & 0x4) != 0) {
      this.QC = true;
    }
    this.PY.setDisplayOptions(i & (paramInt2 ^ 0xFFFFFFFF) | paramInt1 & paramInt2);
    AppMethodBeat.o(106190);
  }
  
  public final void K(boolean paramBoolean)
  {
    AppMethodBeat.i(106215);
    if (!this.QC) {
      setDisplayHomeAsUpEnabled(paramBoolean);
    }
    AppMethodBeat.o(106215);
  }
  
  public final void L(boolean paramBoolean)
  {
    AppMethodBeat.i(106181);
    this.QO = paramBoolean;
    if ((!paramBoolean) && (this.QN != null)) {
      this.QN.cancel();
    }
    AppMethodBeat.o(106181);
  }
  
  public final void M(boolean paramBoolean)
  {
    AppMethodBeat.i(106182);
    if (paramBoolean == this.Qc)
    {
      AppMethodBeat.o(106182);
      return;
    }
    this.Qc = paramBoolean;
    int j = this.Qd.size();
    int i = 0;
    while (i < j)
    {
      this.Qd.get(i);
      i += 1;
    }
    AppMethodBeat.o(106182);
  }
  
  public final void O(boolean paramBoolean)
  {
    this.QI = paramBoolean;
  }
  
  public final void S(boolean paramBoolean)
  {
    AppMethodBeat.i(106207);
    x localx1;
    x localx2;
    if (paramBoolean)
    {
      eX();
      if (!paramBoolean) {
        break label81;
      }
      localx1 = this.PY.c(8, 100L);
      localx2 = this.Qy.c(0, 200L);
    }
    for (;;)
    {
      android.support.v7.view.h localh = new android.support.v7.view.h();
      localh.a(localx1, localx2);
      localh.start();
      AppMethodBeat.o(106207);
      return;
      eZ();
      break;
      label81:
      localx2 = this.PY.c(0, 200L);
      localx1 = this.Qy.c(8, 100L);
    }
  }
  
  public final b a(b.a parama)
  {
    AppMethodBeat.i(106195);
    if (this.zgg != null) {
      this.zgg.finish();
    }
    this.Qy.gu();
    parama = new a(this.Qy.getContext(), parama);
    if (parama.fc())
    {
      parama.invalidate();
      this.Qy.c(parama);
      S(true);
      this.Qy.sendAccessibilityEvent(32);
      this.zgg = parama;
      AppMethodBeat.o(106195);
      return parama;
    }
    AppMethodBeat.o(106195);
    return null;
  }
  
  public final boolean collapseActionView()
  {
    AppMethodBeat.i(106211);
    if ((this.PY != null) && (this.PY.hasExpandedActionView()))
    {
      this.PY.collapseActionView();
      AppMethodBeat.o(106211);
      return true;
    }
    AppMethodBeat.o(106211);
    return false;
  }
  
  public final void eY()
  {
    AppMethodBeat.i(106199);
    if (this.QK)
    {
      this.QK = false;
      P(true);
    }
    AppMethodBeat.o(106199);
  }
  
  public final void es()
  {
    AppMethodBeat.i(106213);
    this.PY.setIcon(2130840999);
    AppMethodBeat.o(106213);
  }
  
  public final void et()
  {
    AppMethodBeat.i(106184);
    setDisplayOptions(0, 2);
    AppMethodBeat.o(106184);
  }
  
  public final void eu()
  {
    AppMethodBeat.i(106186);
    setDisplayOptions(0, 8);
    AppMethodBeat.o(106186);
  }
  
  public final void ev()
  {
    AppMethodBeat.i(106187);
    setDisplayOptions(16, 16);
    AppMethodBeat.o(106187);
  }
  
  public final void ew() {}
  
  public final void fa()
  {
    AppMethodBeat.i(106202);
    if (!this.QK)
    {
      this.QK = true;
      P(true);
    }
    AppMethodBeat.o(106202);
  }
  
  public final void fb()
  {
    AppMethodBeat.i(106210);
    if (this.QN != null)
    {
      this.QN.cancel();
      this.QN = null;
    }
    AppMethodBeat.o(106210);
  }
  
  public final View getCustomView()
  {
    AppMethodBeat.i(106192);
    View localView = this.PY.getCustomView();
    AppMethodBeat.o(106192);
    return localView;
  }
  
  public final int getDisplayOptions()
  {
    AppMethodBeat.i(106194);
    int i = this.PY.getDisplayOptions();
    AppMethodBeat.o(106194);
    return i;
  }
  
  public final int getHeight()
  {
    AppMethodBeat.i(106196);
    int i = this.Qx.getHeight();
    AppMethodBeat.o(106196);
    return i;
  }
  
  public final Context getThemedContext()
  {
    AppMethodBeat.i(106208);
    Object localObject;
    int i;
    if (this.Qv == null)
    {
      localObject = new TypedValue();
      this.mContext.getTheme().resolveAttribute(2130772142, (TypedValue)localObject, true);
      i = ((TypedValue)localObject).resourceId;
      if (i == 0) {
        break label75;
      }
    }
    label75:
    for (this.Qv = new ContextThemeWrapper(this.mContext, i);; this.Qv = this.mContext)
    {
      localObject = this.Qv;
      AppMethodBeat.o(106208);
      return localObject;
    }
  }
  
  public final CharSequence getTitle()
  {
    AppMethodBeat.i(106193);
    CharSequence localCharSequence = this.PY.getTitle();
    AppMethodBeat.o(106193);
    return localCharSequence;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(106200);
    if (!this.QJ)
    {
      this.QJ = true;
      P(false);
    }
    AppMethodBeat.o(106200);
  }
  
  public final boolean isShowing()
  {
    AppMethodBeat.i(106206);
    int i = this.Qx.getHeight();
    if ((this.QM) && ((i == 0) || (i > 0)))
    {
      AppMethodBeat.o(106206);
      return true;
    }
    AppMethodBeat.o(106206);
    return false;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(106180);
    paramConfiguration = this.PY.hz().getLayoutParams();
    if (paramConfiguration != null) {
      paramConfiguration.height = com.tencent.mm.compatible.util.a.bL(this.mActivity);
    }
    this.PY.hz().setLayoutParams(paramConfiguration);
    AppMethodBeat.o(106180);
  }
  
  public final void onWindowVisibilityChanged(int paramInt)
  {
    this.QH = paramInt;
  }
  
  public final void setBackgroundDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(106191);
    this.Qx.setPrimaryBackground(paramDrawable);
    AppMethodBeat.o(106191);
  }
  
  public final void setCustomView(int paramInt)
  {
    AppMethodBeat.i(106183);
    setCustomView(LayoutInflater.from(getThemedContext()).inflate(paramInt, this.PY.hz(), false));
    AppMethodBeat.o(106183);
  }
  
  public final void setCustomView(View paramView)
  {
    AppMethodBeat.i(106212);
    this.PY.setCustomView(paramView);
    AppMethodBeat.o(106212);
  }
  
  public final void setDisplayHomeAsUpEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(106185);
    if (paramBoolean) {}
    for (int i = 4;; i = 0)
    {
      setDisplayOptions(i, 4);
      AppMethodBeat.o(106185);
      return;
    }
  }
  
  public final void setDisplayOptions(int paramInt)
  {
    AppMethodBeat.i(106189);
    if ((paramInt & 0x4) != 0) {
      this.QC = true;
    }
    this.PY.setDisplayOptions(paramInt);
    AppMethodBeat.o(106189);
  }
  
  public final void setElevation(float paramFloat)
  {
    AppMethodBeat.i(106179);
    t.i(this.Qx, paramFloat);
    AppMethodBeat.o(106179);
  }
  
  public final void setHomeActionContentDescription(int paramInt)
  {
    AppMethodBeat.i(106209);
    this.PY.setNavigationContentDescription(paramInt);
    AppMethodBeat.o(106209);
  }
  
  public final void setLogo(Drawable paramDrawable)
  {
    AppMethodBeat.i(106214);
    this.PY.setLogo(paramDrawable);
    AppMethodBeat.o(106214);
  }
  
  public final void setWindowTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(106188);
    this.PY.setWindowTitle(paramCharSequence);
    AppMethodBeat.o(106188);
  }
  
  public final void show()
  {
    AppMethodBeat.i(106197);
    if (this.QJ)
    {
      this.QJ = false;
      P(false);
    }
    AppMethodBeat.o(106197);
  }
  
  public final class a
    extends b
    implements h.a
  {
    private final Context QU;
    private b.a QV;
    private WeakReference<View> QW;
    private final android.support.v7.view.menu.h eq;
    
    public a(Context paramContext, b.a parama)
    {
      AppMethodBeat.i(106161);
      this.QU = paramContext;
      this.QV = parama;
      this$1 = new android.support.v7.view.menu.h(paramContext);
      d.this.Ws = 1;
      this.eq = d.this;
      this.eq.a(this);
      AppMethodBeat.o(106161);
    }
    
    public final boolean a(android.support.v7.view.menu.h paramh, MenuItem paramMenuItem)
    {
      AppMethodBeat.i(106176);
      if (this.QV != null)
      {
        boolean bool = this.QV.a(this, paramMenuItem);
        AppMethodBeat.o(106176);
        return bool;
      }
      AppMethodBeat.o(106176);
      return false;
    }
    
    public final void b(android.support.v7.view.menu.h paramh)
    {
      AppMethodBeat.i(106177);
      if (this.QV == null)
      {
        AppMethodBeat.o(106177);
        return;
      }
      invalidate();
      d.g(d.this).showOverflowMenu();
      AppMethodBeat.o(106177);
    }
    
    public final boolean fc()
    {
      AppMethodBeat.i(106165);
      this.eq.fX();
      try
      {
        boolean bool = this.QV.a(this, this.eq);
        return bool;
      }
      finally
      {
        this.eq.fY();
        AppMethodBeat.o(106165);
      }
    }
    
    public final void finish()
    {
      AppMethodBeat.i(106163);
      if (d.this.zgg != this)
      {
        AppMethodBeat.o(106163);
        return;
      }
      if (!d.ai(d.e(d.this), d.f(d.this)))
      {
        d.this.QE = this;
        d.this.QF = this.QV;
      }
      for (;;)
      {
        this.QV = null;
        d.this.S(false);
        d.g(d.this).gt();
        d.h(d.this).hz().sendAccessibilityEvent(32);
        d.this.zgg = null;
        AppMethodBeat.o(106163);
        return;
        this.QV.a(this);
      }
    }
    
    public final View getCustomView()
    {
      AppMethodBeat.i(106175);
      if (this.QW != null)
      {
        View localView = (View)this.QW.get();
        AppMethodBeat.o(106175);
        return localView;
      }
      AppMethodBeat.o(106175);
      return null;
    }
    
    public final Menu getMenu()
    {
      return this.eq;
    }
    
    public final MenuInflater getMenuInflater()
    {
      AppMethodBeat.i(106162);
      g localg = new g(this.QU);
      AppMethodBeat.o(106162);
      return localg;
    }
    
    public final CharSequence getSubtitle()
    {
      AppMethodBeat.i(106172);
      CharSequence localCharSequence = d.g(d.this).getSubtitle();
      AppMethodBeat.o(106172);
      return localCharSequence;
    }
    
    public final CharSequence getTitle()
    {
      AppMethodBeat.i(106171);
      CharSequence localCharSequence = d.g(d.this).getTitle();
      AppMethodBeat.o(106171);
      return localCharSequence;
    }
    
    public final void invalidate()
    {
      AppMethodBeat.i(106164);
      if (d.this.zgg != this)
      {
        AppMethodBeat.o(106164);
        return;
      }
      this.eq.fX();
      try
      {
        this.QV.b(this, this.eq);
        return;
      }
      finally
      {
        this.eq.fY();
        AppMethodBeat.o(106164);
      }
    }
    
    public final boolean isTitleOptional()
    {
      AppMethodBeat.i(106174);
      boolean bool = d.g(d.this).XK;
      AppMethodBeat.o(106174);
      return bool;
    }
    
    public final void setCustomView(View paramView)
    {
      AppMethodBeat.i(106166);
      d.g(d.this).setCustomView(paramView);
      this.QW = new WeakReference(paramView);
      AppMethodBeat.o(106166);
    }
    
    public final void setSubtitle(int paramInt)
    {
      AppMethodBeat.i(106170);
      setSubtitle(d.i(d.this).getResources().getString(paramInt));
      AppMethodBeat.o(106170);
    }
    
    public final void setSubtitle(CharSequence paramCharSequence)
    {
      AppMethodBeat.i(106167);
      d.g(d.this).setSubtitle(paramCharSequence);
      AppMethodBeat.o(106167);
    }
    
    public final void setTitle(int paramInt)
    {
      AppMethodBeat.i(106169);
      setTitle(d.i(d.this).getResources().getString(paramInt));
      AppMethodBeat.o(106169);
    }
    
    public final void setTitle(CharSequence paramCharSequence)
    {
      AppMethodBeat.i(106168);
      d.g(d.this).setTitle(paramCharSequence);
      AppMethodBeat.o(106168);
    }
    
    public final void setTitleOptionalHint(boolean paramBoolean)
    {
      AppMethodBeat.i(106173);
      super.setTitleOptionalHint(paramBoolean);
      d.g(d.this).setTitleOptional(paramBoolean);
      AppMethodBeat.o(106173);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.b.d
 * JD-Core Version:    0.7.0.1
 */
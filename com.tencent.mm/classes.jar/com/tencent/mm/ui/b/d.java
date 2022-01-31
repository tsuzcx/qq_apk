package com.tencent.mm.ui.b;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.q;
import android.support.v4.view.u;
import android.support.v4.view.v;
import android.support.v4.view.x;
import android.support.v7.a.a.a;
import android.support.v7.a.a.f;
import android.support.v7.a.a.j;
import android.support.v7.app.ActionBar;
import android.support.v7.view.b;
import android.support.v7.view.b.a;
import android.support.v7.view.g;
import android.support.v7.view.menu.h.a;
import android.support.v7.widget.ActionBarContainer;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.ActionBarOverlayLayout.a;
import android.support.v7.widget.Toolbar;
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
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public final class d
  extends ActionBar
  implements ActionBarOverlayLayout.a
{
  private static final Interpolator QL = new AccelerateInterpolator();
  private static final Interpolator QM = new DecelerateInterpolator();
  private static final boolean uRE;
  private Context QN;
  private ActionBarContainer QP;
  private ActionBarContextView QQ;
  private View QR;
  private boolean QU;
  b QW;
  b.a QX;
  private int QZ = 0;
  android.support.v7.widget.w Qq;
  private boolean Qu;
  private ArrayList<Object> Qv = new ArrayList();
  private boolean Ra = true;
  private boolean Rb;
  private boolean Rc;
  private boolean Rd;
  private boolean Re = true;
  private android.support.v7.view.h Rf;
  private boolean Rg;
  final v Ri = new android.support.v4.view.w()
  {
    public final void av(View paramAnonymousView)
    {
      if ((d.a(d.this)) && (d.b(d.this) != null))
      {
        q.d(d.b(d.this), 0.0F);
        q.d(d.c(d.this), 0.0F);
      }
      d.c(d.this).setVisibility(8);
      d.c(d.this).setTransitioning(false);
      d.d(d.this);
      paramAnonymousView = d.this;
      if (paramAnonymousView.QX != null)
      {
        paramAnonymousView.QX.a(paramAnonymousView.QW);
        paramAnonymousView.QW = null;
        paramAnonymousView.QX = null;
      }
    }
  };
  final v Rj = new android.support.v4.view.w()
  {
    public final void av(View paramAnonymousView)
    {
      d.d(d.this);
      d.c(d.this).requestLayout();
    }
  };
  final x Rk = new x()
  {
    public final void du()
    {
      ((View)d.c(d.this).getParent()).invalidate();
    }
  };
  private Activity mActivity;
  private Context mContext;
  a uRF;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 14) {}
    for (boolean bool = true;; bool = false)
    {
      uRE = bool;
      return;
    }
  }
  
  public d(Activity paramActivity, ViewGroup paramViewGroup)
  {
    this.mActivity = paramActivity;
    paramActivity = paramViewGroup.findViewById(a.f.action_bar);
    if ((paramActivity instanceof android.support.v7.widget.w)) {}
    for (paramActivity = (android.support.v7.widget.w)paramActivity;; paramActivity = ((Toolbar)paramActivity).getWrapper())
    {
      this.Qq = paramActivity;
      this.QQ = ((ActionBarContextView)paramViewGroup.findViewById(a.f.action_context_bar));
      this.QP = ((ActionBarContainer)paramViewGroup.findViewById(a.f.action_bar_container));
      if ((this.Qq != null) && (this.QQ != null) && (this.QP != null)) {
        break label238;
      }
      throw new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
      if (!(paramActivity instanceof Toolbar)) {
        break;
      }
    }
    if ("Can't make a decor toolbar out of " + paramActivity != null) {}
    for (paramActivity = paramActivity.getClass().getSimpleName();; paramActivity = "null") {
      throw new IllegalStateException(paramActivity);
    }
    label238:
    this.mContext = this.Qq.getContext();
    if ((this.Qq.getDisplayOptions() & 0x4) != 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        this.QU = true;
      }
      android.support.v7.view.a.T(this.mContext).eN();
      paramActivity = this.mContext.obtainStyledAttributes(null, a.j.ActionBar, a.a.actionBarStyle, 0);
      paramActivity.getBoolean(a.j.ActionBar_hideOnContentScroll, false);
      i = paramActivity.getDimensionPixelSize(a.j.ActionBar_elevation, 0);
      if (i != 0) {
        setElevation(i);
      }
      paramActivity.recycle();
      this.QR = null;
      return;
    }
  }
  
  private void Q(boolean paramBoolean)
  {
    float f2;
    float f1;
    Object localObject1;
    Object localObject2;
    if (e(this.Rb, this.Rc, this.Rd)) {
      if (!this.Re)
      {
        this.Re = true;
        if (this.Rf != null) {
          this.Rf.cancel();
        }
        this.QP.setVisibility(0);
        if ((this.QZ != 0) || (!uRE) || ((!this.Rg) && (!paramBoolean))) {
          break label257;
        }
        q.d(this.QP, 0.0F);
        f2 = -this.QP.getHeight();
        f1 = f2;
        if (paramBoolean)
        {
          localObject1 = new int[2];
          Object tmp107_105 = localObject1;
          tmp107_105[0] = 0;
          Object tmp111_107 = tmp107_105;
          tmp111_107[1] = 0;
          tmp111_107;
          this.QP.getLocationInWindow((int[])localObject1);
          f1 = f2 - localObject1[1];
        }
        q.d(this.QP, f1);
        localObject1 = new android.support.v7.view.h();
        localObject2 = q.Y(this.QP).t(0.0F);
        ((u)localObject2).a(this.Rk);
        ((android.support.v7.view.h)localObject1).a((u)localObject2);
        if ((this.Ra) && (this.QR != null))
        {
          q.d(this.QR, f1);
          ((android.support.v7.view.h)localObject1).a(q.Y(this.QR).t(0.0F));
        }
        ((android.support.v7.view.h)localObject1).d(QM);
        ((android.support.v7.view.h)localObject1).eR();
        ((android.support.v7.view.h)localObject1).b(this.Rj);
        this.Rf = ((android.support.v7.view.h)localObject1);
        ((android.support.v7.view.h)localObject1).start();
      }
    }
    label257:
    while (!this.Re)
    {
      return;
      q.e(this.QP, 1.0F);
      q.d(this.QP, 0.0F);
      if ((this.Ra) && (this.QR != null)) {
        q.d(this.QR, 0.0F);
      }
      this.Rj.av(null);
      return;
    }
    this.Re = false;
    if (this.Rf != null) {
      this.Rf.cancel();
    }
    if ((this.QZ == 0) && (uRE) && ((this.Rg) || (paramBoolean)))
    {
      q.e(this.QP, 1.0F);
      this.QP.setTransitioning(true);
      localObject1 = new android.support.v7.view.h();
      f2 = -this.QP.getHeight();
      f1 = f2;
      if (paramBoolean)
      {
        localObject2 = new int[2];
        Object tmp404_402 = localObject2;
        tmp404_402[0] = 0;
        Object tmp408_404 = tmp404_402;
        tmp408_404[1] = 0;
        tmp408_404;
        this.QP.getLocationInWindow((int[])localObject2);
        f1 = f2 - localObject2[1];
      }
      localObject2 = q.Y(this.QP).t(f1);
      ((u)localObject2).a(this.Rk);
      ((android.support.v7.view.h)localObject1).a((u)localObject2);
      if ((this.Ra) && (this.QR != null)) {
        ((android.support.v7.view.h)localObject1).a(q.Y(this.QR).t(f1));
      }
      ((android.support.v7.view.h)localObject1).d(QL);
      ((android.support.v7.view.h)localObject1).eR();
      ((android.support.v7.view.h)localObject1).b(this.Ri);
      this.Rf = ((android.support.v7.view.h)localObject1);
      ((android.support.v7.view.h)localObject1).start();
      return;
    }
    this.Ri.av(null);
  }
  
  private static boolean e(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramBoolean3) {}
    while ((!paramBoolean1) && (!paramBoolean2)) {
      return true;
    }
    return false;
  }
  
  private void setDisplayOptions(int paramInt1, int paramInt2)
  {
    int i = this.Qq.getDisplayOptions();
    if ((paramInt2 & 0x4) != 0) {
      this.QU = true;
    }
    this.Qq.setDisplayOptions(i & (paramInt2 ^ 0xFFFFFFFF) | paramInt1 & paramInt2);
  }
  
  public final void L(boolean paramBoolean)
  {
    if (!this.QU) {
      setDisplayHomeAsUpEnabled(paramBoolean);
    }
  }
  
  public final void M(boolean paramBoolean)
  {
    this.Rg = paramBoolean;
    if ((!paramBoolean) && (this.Rf != null)) {
      this.Rf.cancel();
    }
  }
  
  public final void N(boolean paramBoolean)
  {
    if (paramBoolean == this.Qu) {}
    for (;;)
    {
      return;
      this.Qu = paramBoolean;
      int j = this.Qv.size();
      int i = 0;
      while (i < j)
      {
        this.Qv.get(i);
        i += 1;
      }
    }
  }
  
  public final void P(boolean paramBoolean)
  {
    this.Ra = paramBoolean;
  }
  
  public final void R(boolean paramBoolean)
  {
    u localu1;
    u localu2;
    if (paramBoolean)
    {
      if (!this.Rd)
      {
        this.Rd = true;
        Q(false);
      }
      if (!paramBoolean) {
        break label95;
      }
      localu1 = this.Qq.c(8, 100L);
      localu2 = this.QQ.c(0, 200L);
    }
    for (;;)
    {
      android.support.v7.view.h localh = new android.support.v7.view.h();
      localh.a(localu1, localu2);
      localh.start();
      return;
      if (!this.Rd) {
        break;
      }
      this.Rd = false;
      Q(false);
      break;
      label95:
      localu2 = this.Qq.c(0, 200L);
      localu1 = this.QQ.c(8, 100L);
    }
  }
  
  public final b a(b.a parama)
  {
    if (this.uRF != null) {
      this.uRF.finish();
    }
    this.QQ.fB();
    parama = new a(this.QQ.getContext(), parama);
    if (parama.ey())
    {
      parama.invalidate();
      this.QQ.c(parama);
      R(true);
      this.QQ.sendAccessibilityEvent(32);
      this.uRF = parama;
      return parama;
    }
    return null;
  }
  
  public final boolean collapseActionView()
  {
    if ((this.Qq != null) && (this.Qq.hasExpandedActionView()))
    {
      this.Qq.collapseActionView();
      return true;
    }
    return false;
  }
  
  public final void dY()
  {
    setDisplayOptions(0, 2);
  }
  
  public final void dZ()
  {
    setDisplayOptions(0, 8);
  }
  
  public final void ea()
  {
    setDisplayOptions(16, 16);
  }
  
  public final void ev()
  {
    if (this.Rc)
    {
      this.Rc = false;
      Q(true);
    }
  }
  
  public final void ew()
  {
    if (!this.Rc)
    {
      this.Rc = true;
      Q(true);
    }
  }
  
  public final void ex()
  {
    if (this.Rf != null)
    {
      this.Rf.cancel();
      this.Rf = null;
    }
  }
  
  public final View getCustomView()
  {
    return this.Qq.getCustomView();
  }
  
  public final int getDisplayOptions()
  {
    return this.Qq.getDisplayOptions();
  }
  
  public final int getHeight()
  {
    return this.QP.getHeight();
  }
  
  public final Context getThemedContext()
  {
    int i;
    if (this.QN == null)
    {
      TypedValue localTypedValue = new TypedValue();
      this.mContext.getTheme().resolveAttribute(a.a.actionBarWidgetTheme, localTypedValue, true);
      i = localTypedValue.resourceId;
      if (i == 0) {
        break label61;
      }
    }
    label61:
    for (this.QN = new ContextThemeWrapper(this.mContext, i);; this.QN = this.mContext) {
      return this.QN;
    }
  }
  
  public final CharSequence getTitle()
  {
    return this.Qq.getTitle();
  }
  
  public final void hide()
  {
    if (!this.Rb)
    {
      this.Rb = true;
      Q(false);
    }
  }
  
  public final boolean isShowing()
  {
    int i = this.QP.getHeight();
    return (this.Re) && ((i == 0) || (i > 0));
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    paramConfiguration = this.Qq.gz().getLayoutParams();
    if (paramConfiguration != null) {
      paramConfiguration.height = com.tencent.mm.compatible.util.a.bh(this.mActivity);
    }
    this.Qq.gz().setLayoutParams(paramConfiguration);
  }
  
  public final void onWindowVisibilityChanged(int paramInt)
  {
    this.QZ = paramInt;
  }
  
  public final void setBackgroundDrawable(Drawable paramDrawable)
  {
    this.QP.setPrimaryBackground(paramDrawable);
  }
  
  public final void setCustomView(int paramInt)
  {
    setCustomView(LayoutInflater.from(getThemedContext()).inflate(paramInt, this.Qq.gz(), false));
  }
  
  public final void setCustomView(View paramView)
  {
    this.Qq.setCustomView(paramView);
  }
  
  public final void setDisplayHomeAsUpEnabled(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 4;; i = 0)
    {
      setDisplayOptions(i, 4);
      return;
    }
  }
  
  public final void setDisplayOptions(int paramInt)
  {
    if ((paramInt & 0x4) != 0) {
      this.QU = true;
    }
    this.Qq.setDisplayOptions(paramInt);
  }
  
  public final void setElevation(float paramFloat)
  {
    q.h(this.QP, paramFloat);
  }
  
  public final void setHomeActionContentDescription(int paramInt)
  {
    this.Qq.setNavigationContentDescription(paramInt);
  }
  
  public final void setIcon(int paramInt)
  {
    this.Qq.setIcon(paramInt);
  }
  
  public final void setLogo(Drawable paramDrawable)
  {
    this.Qq.setLogo(paramDrawable);
  }
  
  public final void setWindowTitle(CharSequence paramCharSequence)
  {
    this.Qq.setWindowTitle(paramCharSequence);
  }
  
  public final void show()
  {
    if (this.Rb)
    {
      this.Rb = false;
      Q(false);
    }
  }
  
  public final class a
    extends b
    implements h.a
  {
    private final Context Rm;
    private b.a Rn;
    private WeakReference<View> Ro;
    private final android.support.v7.view.menu.h dm;
    
    public a(Context paramContext, b.a parama)
    {
      this.Rm = paramContext;
      this.Rn = parama;
      this$1 = new android.support.v7.view.menu.h(paramContext);
      d.this.VD = 1;
      this.dm = d.this;
      this.dm.a(this);
    }
    
    public final boolean a(android.support.v7.view.menu.h paramh, MenuItem paramMenuItem)
    {
      if (this.Rn != null) {
        return this.Rn.a(this, paramMenuItem);
      }
      return false;
    }
    
    public final void b(android.support.v7.view.menu.h paramh)
    {
      if (this.Rn == null) {
        return;
      }
      invalidate();
      d.g(d.this).showOverflowMenu();
    }
    
    public final boolean ey()
    {
      this.dm.fh();
      try
      {
        boolean bool = this.Rn.a(this, this.dm);
        return bool;
      }
      finally
      {
        this.dm.fi();
      }
    }
    
    public final void finish()
    {
      if (d.this.uRF != this) {
        return;
      }
      if (!d.X(d.e(d.this), d.f(d.this)))
      {
        d.this.QW = this;
        d.this.QX = this.Rn;
      }
      for (;;)
      {
        this.Rn = null;
        d.this.R(false);
        d.g(d.this).fA();
        d.h(d.this).gz().sendAccessibilityEvent(32);
        d.this.uRF = null;
        return;
        this.Rn.a(this);
      }
    }
    
    public final View getCustomView()
    {
      if (this.Ro != null) {
        return (View)this.Ro.get();
      }
      return null;
    }
    
    public final Menu getMenu()
    {
      return this.dm;
    }
    
    public final MenuInflater getMenuInflater()
    {
      return new g(this.Rm);
    }
    
    public final CharSequence getSubtitle()
    {
      return d.g(d.this).getSubtitle();
    }
    
    public final CharSequence getTitle()
    {
      return d.g(d.this).getTitle();
    }
    
    public final void invalidate()
    {
      if (d.this.uRF != this) {
        return;
      }
      this.dm.fh();
      try
      {
        this.Rn.b(this, this.dm);
        return;
      }
      finally
      {
        this.dm.fi();
      }
    }
    
    public final boolean isTitleOptional()
    {
      return d.g(d.this).WY;
    }
    
    public final void setCustomView(View paramView)
    {
      d.g(d.this).setCustomView(paramView);
      this.Ro = new WeakReference(paramView);
    }
    
    public final void setSubtitle(int paramInt)
    {
      setSubtitle(d.i(d.this).getResources().getString(paramInt));
    }
    
    public final void setSubtitle(CharSequence paramCharSequence)
    {
      d.g(d.this).setSubtitle(paramCharSequence);
    }
    
    public final void setTitle(int paramInt)
    {
      setTitle(d.i(d.this).getResources().getString(paramInt));
    }
    
    public final void setTitle(CharSequence paramCharSequence)
    {
      d.g(d.this).setTitle(paramCharSequence);
    }
    
    public final void setTitleOptionalHint(boolean paramBoolean)
    {
      super.setTitleOptionalHint(paramBoolean);
      d.g(d.this).setTitleOptional(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.b.d
 * JD-Core Version:    0.7.0.1
 */
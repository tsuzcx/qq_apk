package com.tencent.mm.ui.b;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
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
import androidx.appcompat.a.a;
import androidx.appcompat.a.j;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBar.LayoutParams;
import androidx.appcompat.view.b;
import androidx.appcompat.view.b.a;
import androidx.appcompat.view.g;
import androidx.appcompat.view.menu.h.a;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout.a;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.n;
import androidx.core.g.aa;
import androidx.core.g.ab;
import androidx.core.g.ac;
import androidx.core.g.ad;
import androidx.core.g.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.g;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public final class d
  extends ActionBar
  implements ActionBarOverlayLayout.a
{
  private static final boolean WfE;
  private static final Interpolator hO;
  private static final Interpolator hP;
  a WfF;
  private Context hQ;
  private ActionBarContainer hS;
  private ActionBarContextView hT;
  private boolean hX;
  b hZ;
  n ht;
  private boolean hx;
  private ArrayList<Object> hy;
  b.a ia;
  private int ic;
  private boolean ie;
  private boolean jdField_if;
  private boolean ig;
  private boolean ih;
  private boolean ii;
  private androidx.appcompat.view.h ij;
  private boolean ik;
  final ab im;
  final ab in;
  final ad io;
  private Activity mActivity;
  private View mContentView;
  private Context mContext;
  
  static
  {
    AppMethodBeat.i(141577);
    hO = new AccelerateInterpolator();
    hP = new DecelerateInterpolator();
    if (Build.VERSION.SDK_INT >= 14) {}
    for (boolean bool = true;; bool = false)
    {
      WfE = bool;
      AppMethodBeat.o(141577);
      return;
    }
  }
  
  public d(Activity paramActivity, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(141538);
    this.hy = new ArrayList();
    this.ic = 0;
    this.ie = true;
    this.ii = true;
    this.im = new ac()
    {
      public final void f(View paramAnonymousView)
      {
        AppMethodBeat.i(141518);
        if ((d.a(d.this)) && (d.b(d.this) != null))
        {
          w.d(d.b(d.this), 0.0F);
          w.d(d.c(d.this), 0.0F);
        }
        d.c(d.this).setVisibility(8);
        d.c(d.this).setTransitioning(false);
        d.d(d.this);
        paramAnonymousView = d.this;
        if (paramAnonymousView.ia != null)
        {
          paramAnonymousView.ia.a(paramAnonymousView.hZ);
          paramAnonymousView.hZ = null;
          paramAnonymousView.ia = null;
        }
        AppMethodBeat.o(141518);
      }
    };
    this.in = new ac()
    {
      public final void f(View paramAnonymousView)
      {
        AppMethodBeat.i(141519);
        d.d(d.this);
        d.c(d.this).requestLayout();
        AppMethodBeat.o(141519);
      }
    };
    this.io = new ad()
    {
      public final void bm()
      {
        AppMethodBeat.i(141520);
        ((View)d.c(d.this).getParent()).invalidate();
        AppMethodBeat.o(141520);
      }
    };
    this.mActivity = paramActivity;
    paramActivity = paramViewGroup.findViewById(a.g.action_bar);
    if ((paramActivity instanceof n)) {}
    for (paramActivity = (n)paramActivity;; paramActivity = ((Toolbar)paramActivity).getWrapper())
    {
      this.ht = paramActivity;
      this.hT = ((ActionBarContextView)paramViewGroup.findViewById(a.g.action_context_bar));
      this.hS = ((ActionBarContainer)paramViewGroup.findViewById(a.g.action_bar_container));
      if ((this.ht != null) && (this.hT != null) && (this.hS != null)) {
        break label250;
      }
      paramActivity = new IllegalStateException(getClass().getSimpleName() + " can only be used with a compatible window decor layout");
      AppMethodBeat.o(141538);
      throw paramActivity;
      if (!(paramActivity instanceof Toolbar)) {
        break;
      }
    }
    if ("Can't make a decor toolbar out of ".concat(String.valueOf(paramActivity)) != null) {}
    for (paramActivity = paramActivity.getClass().getSimpleName();; paramActivity = "null")
    {
      paramActivity = new IllegalStateException(paramActivity);
      AppMethodBeat.o(141538);
      throw paramActivity;
    }
    label250:
    this.mContext = this.ht.getContext();
    if ((this.ht.aC() & 0x4) != 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        this.hX = true;
      }
      androidx.appcompat.view.a.I(this.mContext).bA();
      paramActivity = this.mContext.obtainStyledAttributes(null, a.j.ActionBar, a.a.actionBarStyle, 0);
      paramActivity.getBoolean(a.j.ActionBar_hideOnContentScroll, false);
      i = paramActivity.getDimensionPixelSize(a.j.ActionBar_elevation, 0);
      if (i != 0) {
        e(i);
      }
      paramActivity.recycle();
      this.mContentView = null;
      AppMethodBeat.o(141538);
      return;
    }
  }
  
  private void A(boolean paramBoolean)
  {
    AppMethodBeat.i(141563);
    if (b(this.jdField_if, this.ig, this.ih))
    {
      if (!this.ii)
      {
        this.ii = true;
        B(paramBoolean);
        AppMethodBeat.o(141563);
      }
    }
    else if (this.ii)
    {
      this.ii = false;
      C(paramBoolean);
    }
    AppMethodBeat.o(141563);
  }
  
  private void B(boolean paramBoolean)
  {
    AppMethodBeat.i(141564);
    if (this.ij != null) {
      this.ij.cancel();
    }
    this.hS.setVisibility(0);
    if ((this.ic == 0) && (WfE) && ((this.ik) || (paramBoolean)))
    {
      w.d(this.hS, 0.0F);
      float f2 = -this.hS.getHeight();
      float f1 = f2;
      if (paramBoolean)
      {
        localObject = new int[2];
        Object tmp83_81 = localObject;
        tmp83_81[0] = 0;
        Object tmp87_83 = tmp83_81;
        tmp87_83[1] = 0;
        tmp87_83;
        this.hS.getLocationInWindow((int[])localObject);
        f1 = f2 - localObject[1];
      }
      w.d(this.hS, f1);
      Object localObject = new androidx.appcompat.view.h();
      aa localaa = w.Q(this.hS).j(0.0F);
      localaa.a(this.io);
      ((androidx.appcompat.view.h)localObject).a(localaa);
      if ((this.ie) && (this.mContentView != null))
      {
        w.d(this.mContentView, f1);
        ((androidx.appcompat.view.h)localObject).a(w.Q(this.mContentView).j(0.0F));
      }
      ((androidx.appcompat.view.h)localObject).a(hP);
      ((androidx.appcompat.view.h)localObject).bH();
      ((androidx.appcompat.view.h)localObject).a(this.in);
      this.ij = ((androidx.appcompat.view.h)localObject);
      ((androidx.appcompat.view.h)localObject).start();
      AppMethodBeat.o(141564);
      return;
    }
    w.e(this.hS, 1.0F);
    w.d(this.hS, 0.0F);
    if ((this.ie) && (this.mContentView != null)) {
      w.d(this.mContentView, 0.0F);
    }
    this.in.f(null);
    AppMethodBeat.o(141564);
  }
  
  private void C(boolean paramBoolean)
  {
    AppMethodBeat.i(141565);
    if (this.ij != null) {
      this.ij.cancel();
    }
    if ((this.ic == 0) && (WfE) && ((this.ik) || (paramBoolean)))
    {
      w.e(this.hS, 1.0F);
      this.hS.setTransitioning(true);
      androidx.appcompat.view.h localh = new androidx.appcompat.view.h();
      float f2 = -this.hS.getHeight();
      float f1 = f2;
      if (paramBoolean)
      {
        localObject = new int[2];
        Object tmp92_90 = localObject;
        tmp92_90[0] = 0;
        Object tmp96_92 = tmp92_90;
        tmp96_92[1] = 0;
        tmp96_92;
        this.hS.getLocationInWindow((int[])localObject);
        f1 = f2 - localObject[1];
      }
      Object localObject = w.Q(this.hS).j(f1);
      ((aa)localObject).a(this.io);
      localh.a((aa)localObject);
      if ((this.ie) && (this.mContentView != null)) {
        localh.a(w.Q(this.mContentView).j(f1));
      }
      localh.a(hO);
      localh.bH();
      localh.a(this.im);
      this.ij = localh;
      localh.start();
      AppMethodBeat.o(141565);
      return;
    }
    this.im.f(null);
    AppMethodBeat.o(141565);
  }
  
  private static boolean b(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramBoolean3) {}
    while ((!paramBoolean1) && (!paramBoolean2)) {
      return true;
    }
    return false;
  }
  
  private void bh()
  {
    AppMethodBeat.i(141558);
    if (!this.ih)
    {
      this.ih = true;
      A(false);
    }
    AppMethodBeat.o(141558);
  }
  
  private void bj()
  {
    AppMethodBeat.i(141561);
    if (this.ih)
    {
      this.ih = false;
      A(false);
    }
    AppMethodBeat.o(141561);
  }
  
  private void f(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(141550);
    int i = this.ht.aC();
    if ((paramInt2 & 0x4) != 0) {
      this.hX = true;
    }
    this.ht.O(i & (paramInt2 ^ 0xFFFFFFFF) | paramInt1 & paramInt2);
    AppMethodBeat.o(141550);
  }
  
  public final void D(boolean paramBoolean)
  {
    AppMethodBeat.i(141567);
    aa localaa1;
    aa localaa2;
    if (paramBoolean)
    {
      bh();
      if (!paramBoolean) {
        break label81;
      }
      localaa1 = this.ht.b(8, 100L);
      localaa2 = this.hT.b(0, 200L);
    }
    for (;;)
    {
      androidx.appcompat.view.h localh = new androidx.appcompat.view.h();
      localh.a(localaa1, localaa2);
      localh.start();
      AppMethodBeat.o(141567);
      return;
      bj();
      break;
      label81:
      localaa2 = this.ht.b(0, 200L);
      localaa1 = this.hT.b(8, 100L);
    }
  }
  
  public final void N(int paramInt)
  {
    AppMethodBeat.i(141543);
    setCustomView(LayoutInflater.from(aD()).inflate(paramInt, this.ht.dE(), false));
    AppMethodBeat.o(141543);
  }
  
  public final void O(int paramInt)
  {
    AppMethodBeat.i(141549);
    if ((paramInt & 0x4) != 0) {
      this.hX = true;
    }
    this.ht.O(paramInt);
    AppMethodBeat.o(141549);
  }
  
  public final b a(b.a parama)
  {
    AppMethodBeat.i(190164);
    if (this.WfF != null) {
      this.WfF.finish();
    }
    this.hT.cF();
    parama = new a(this.hT.getContext(), parama);
    if (parama.bn())
    {
      parama.invalidate();
      this.hT.c(parama);
      D(true);
      this.hT.sendAccessibilityEvent(32);
      this.WfF = parama;
      AppMethodBeat.o(190164);
      return parama;
    }
    AppMethodBeat.o(190164);
    return null;
  }
  
  public final void a(View paramView, ActionBar.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(190231);
    paramView.setLayoutParams(paramLayoutParams);
    this.ht.setCustomView(paramView);
    AppMethodBeat.o(190231);
  }
  
  public final int aC()
  {
    AppMethodBeat.i(141554);
    int i = this.ht.aC();
    AppMethodBeat.o(141554);
    return i;
  }
  
  public final Context aD()
  {
    AppMethodBeat.i(141568);
    Object localObject;
    int i;
    if (this.hQ == null)
    {
      localObject = new TypedValue();
      this.mContext.getTheme().resolveAttribute(a.a.actionBarWidgetTheme, (TypedValue)localObject, true);
      i = ((TypedValue)localObject).resourceId;
      if (i == 0) {
        break label75;
      }
    }
    label75:
    for (this.hQ = new ContextThemeWrapper(this.mContext, i);; this.hQ = this.mContext)
    {
      localObject = this.hQ;
      AppMethodBeat.o(141568);
      return localObject;
    }
  }
  
  public final void bi()
  {
    AppMethodBeat.i(141559);
    if (this.ig)
    {
      this.ig = false;
      A(true);
    }
    AppMethodBeat.o(141559);
  }
  
  public final void bk()
  {
    AppMethodBeat.i(141562);
    if (!this.ig)
    {
      this.ig = true;
      A(true);
    }
    AppMethodBeat.o(141562);
  }
  
  public final void bl()
  {
    AppMethodBeat.i(141570);
    if (this.ij != null)
    {
      this.ij.cancel();
      this.ij = null;
    }
    AppMethodBeat.o(141570);
  }
  
  public final boolean collapseActionView()
  {
    AppMethodBeat.i(141571);
    if ((this.ht != null) && (this.ht.dF()))
    {
      this.ht.dG();
      AppMethodBeat.o(141571);
      return true;
    }
    AppMethodBeat.o(141571);
    return false;
  }
  
  public final void e(float paramFloat)
  {
    AppMethodBeat.i(141539);
    w.j(this.hS, paramFloat);
    AppMethodBeat.o(141539);
  }
  
  public final View getCustomView()
  {
    AppMethodBeat.i(141552);
    View localView = this.ht.getCustomView();
    AppMethodBeat.o(141552);
    return localView;
  }
  
  public final int getHeight()
  {
    AppMethodBeat.i(141556);
    int i = this.hS.getHeight();
    AppMethodBeat.o(141556);
    return i;
  }
  
  public final CharSequence getTitle()
  {
    AppMethodBeat.i(141553);
    CharSequence localCharSequence = this.ht.getTitle();
    AppMethodBeat.o(141553);
    return localCharSequence;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(141560);
    if (!this.jdField_if)
    {
      this.jdField_if = true;
      A(false);
    }
    AppMethodBeat.o(141560);
  }
  
  public final boolean isShowing()
  {
    AppMethodBeat.i(141566);
    int i = this.hS.getHeight();
    if ((this.ii) && ((i == 0) || (i > 0)))
    {
      AppMethodBeat.o(141566);
      return true;
    }
    AppMethodBeat.o(141566);
    return false;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(141540);
    paramConfiguration = this.ht.dE().getLayoutParams();
    if (paramConfiguration != null) {
      paramConfiguration.height = com.tencent.mm.compatible.util.a.cu(this.mActivity);
    }
    this.ht.dE().setLayoutParams(paramConfiguration);
    AppMethodBeat.o(141540);
  }
  
  public final void onWindowVisibilityChanged(int paramInt)
  {
    this.ic = paramInt;
  }
  
  public final void r(boolean paramBoolean)
  {
    AppMethodBeat.i(190142);
    if (paramBoolean) {}
    for (int i = 2;; i = 0)
    {
      f(i, 2);
      AppMethodBeat.o(190142);
      return;
    }
  }
  
  public final void s(boolean paramBoolean)
  {
    AppMethodBeat.i(141545);
    if (paramBoolean) {}
    for (int i = 4;; i = 0)
    {
      f(i, 4);
      AppMethodBeat.o(141545);
      return;
    }
  }
  
  public final void setBackgroundDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(141551);
    this.hS.setPrimaryBackground(paramDrawable);
    AppMethodBeat.o(141551);
  }
  
  public final void setCustomView(View paramView)
  {
    AppMethodBeat.i(141572);
    this.ht.setCustomView(paramView);
    AppMethodBeat.o(141572);
  }
  
  public final void setHideOnContentScrollEnabled(boolean paramBoolean) {}
  
  public final void setIcon(int paramInt)
  {
    AppMethodBeat.i(190233);
    this.ht.setIcon(paramInt);
    AppMethodBeat.o(190233);
  }
  
  public final void setLogo(Drawable paramDrawable)
  {
    AppMethodBeat.i(141574);
    this.ht.setLogo(paramDrawable);
    AppMethodBeat.o(141574);
  }
  
  public final void setWindowTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(141548);
    this.ht.setWindowTitle(paramCharSequence);
    AppMethodBeat.o(141548);
  }
  
  public final void show()
  {
    AppMethodBeat.i(141557);
    if (this.jdField_if)
    {
      this.jdField_if = false;
      A(false);
    }
    AppMethodBeat.o(141557);
  }
  
  public final void t(boolean paramBoolean)
  {
    AppMethodBeat.i(190146);
    if (paramBoolean) {}
    for (int i = 8;; i = 0)
    {
      f(i, 8);
      AppMethodBeat.o(190146);
      return;
    }
  }
  
  public final void u(boolean paramBoolean)
  {
    AppMethodBeat.i(190149);
    if (paramBoolean) {}
    for (int i = 16;; i = 0)
    {
      f(i, 16);
      AppMethodBeat.o(190149);
      return;
    }
  }
  
  public final void v(boolean paramBoolean)
  {
    AppMethodBeat.i(141575);
    if (!this.hX) {
      s(paramBoolean);
    }
    AppMethodBeat.o(141575);
  }
  
  public final void w(boolean paramBoolean)
  {
    AppMethodBeat.i(141541);
    this.ik = paramBoolean;
    if ((!paramBoolean) && (this.ij != null)) {
      this.ij.cancel();
    }
    AppMethodBeat.o(141541);
  }
  
  public final void x(boolean paramBoolean)
  {
    AppMethodBeat.i(141542);
    if (paramBoolean == this.hx)
    {
      AppMethodBeat.o(141542);
      return;
    }
    this.hx = paramBoolean;
    int j = this.hy.size();
    int i = 0;
    while (i < j)
    {
      this.hy.get(i);
      i += 1;
    }
    AppMethodBeat.o(141542);
  }
  
  public final void z(boolean paramBoolean)
  {
    this.ie = paramBoolean;
  }
  
  public final class a
    extends b
    implements h.a
  {
    private final Context ir;
    private final androidx.appcompat.view.menu.h is;
    private b.a it;
    private WeakReference<View> iu;
    
    public a(Context paramContext, b.a parama)
    {
      AppMethodBeat.i(220328);
      this.ir = paramContext;
      this.it = parama;
      this$1 = new androidx.appcompat.view.menu.h(paramContext);
      d.this.mG = 1;
      this.is = d.this;
      this.is.a(this);
      AppMethodBeat.o(220328);
    }
    
    public final void a(androidx.appcompat.view.menu.h paramh)
    {
      AppMethodBeat.i(220359);
      if (this.it == null)
      {
        AppMethodBeat.o(220359);
        return;
      }
      invalidate();
      d.g(d.this).cC();
      AppMethodBeat.o(220359);
    }
    
    public final boolean a(androidx.appcompat.view.menu.h paramh, MenuItem paramMenuItem)
    {
      AppMethodBeat.i(220356);
      if (this.it != null)
      {
        boolean bool = this.it.a(this, paramMenuItem);
        AppMethodBeat.o(220356);
        return bool;
      }
      AppMethodBeat.o(220356);
      return false;
    }
    
    public final boolean bn()
    {
      AppMethodBeat.i(141525);
      this.is.ce();
      try
      {
        boolean bool = this.it.a(this, this.is);
        return bool;
      }
      finally
      {
        this.is.cf();
        AppMethodBeat.o(141525);
      }
    }
    
    public final void finish()
    {
      AppMethodBeat.i(141523);
      if (d.this.WfF != this)
      {
        AppMethodBeat.o(141523);
        return;
      }
      if (!d.bn(d.e(d.this), d.f(d.this)))
      {
        d.this.hZ = this;
        d.this.ia = this.it;
      }
      for (;;)
      {
        this.it = null;
        d.this.D(false);
        d.g(d.this).cE();
        d.h(d.this).dE().sendAccessibilityEvent(32);
        d.this.WfF = null;
        AppMethodBeat.o(141523);
        return;
        this.it.a(this);
      }
    }
    
    public final View getCustomView()
    {
      AppMethodBeat.i(141535);
      if (this.iu != null)
      {
        View localView = (View)this.iu.get();
        AppMethodBeat.o(141535);
        return localView;
      }
      AppMethodBeat.o(141535);
      return null;
    }
    
    public final Menu getMenu()
    {
      return this.is;
    }
    
    public final MenuInflater getMenuInflater()
    {
      AppMethodBeat.i(141522);
      g localg = new g(this.ir);
      AppMethodBeat.o(141522);
      return localg;
    }
    
    public final CharSequence getSubtitle()
    {
      AppMethodBeat.i(141532);
      CharSequence localCharSequence = d.g(d.this).getSubtitle();
      AppMethodBeat.o(141532);
      return localCharSequence;
    }
    
    public final CharSequence getTitle()
    {
      AppMethodBeat.i(141531);
      CharSequence localCharSequence = d.g(d.this).getTitle();
      AppMethodBeat.o(141531);
      return localCharSequence;
    }
    
    public final void invalidate()
    {
      AppMethodBeat.i(141524);
      if (d.this.WfF != this)
      {
        AppMethodBeat.o(141524);
        return;
      }
      this.is.ce();
      try
      {
        this.it.b(this, this.is);
        return;
      }
      finally
      {
        this.is.cf();
        AppMethodBeat.o(141524);
      }
    }
    
    public final boolean isTitleOptional()
    {
      AppMethodBeat.i(141534);
      boolean bool = d.g(d.this).oc;
      AppMethodBeat.o(141534);
      return bool;
    }
    
    public final void setCustomView(View paramView)
    {
      AppMethodBeat.i(141526);
      d.g(d.this).setCustomView(paramView);
      this.iu = new WeakReference(paramView);
      AppMethodBeat.o(141526);
    }
    
    public final void setSubtitle(int paramInt)
    {
      AppMethodBeat.i(141530);
      setSubtitle(d.i(d.this).getResources().getString(paramInt));
      AppMethodBeat.o(141530);
    }
    
    public final void setSubtitle(CharSequence paramCharSequence)
    {
      AppMethodBeat.i(141527);
      d.g(d.this).setSubtitle(paramCharSequence);
      AppMethodBeat.o(141527);
    }
    
    public final void setTitle(int paramInt)
    {
      AppMethodBeat.i(141529);
      setTitle(d.i(d.this).getResources().getString(paramInt));
      AppMethodBeat.o(141529);
    }
    
    public final void setTitle(CharSequence paramCharSequence)
    {
      AppMethodBeat.i(141528);
      d.g(d.this).setTitle(paramCharSequence);
      AppMethodBeat.o(141528);
    }
    
    public final void setTitleOptionalHint(boolean paramBoolean)
    {
      AppMethodBeat.i(141533);
      super.setTitleOptionalHint(paramBoolean);
      d.g(d.this).setTitleOptional(paramBoolean);
      AppMethodBeat.o(141533);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.b.d
 * JD-Core Version:    0.7.0.1
 */
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
  private static final boolean Htl;
  private static final Interpolator Yn;
  private static final Interpolator Yo;
  a Htm;
  u XS;
  private boolean XW;
  private ArrayList<Object> XX;
  private int YA;
  private boolean YB;
  private boolean YC;
  private boolean YD;
  private boolean YE;
  private boolean YF;
  private android.support.v7.view.h YG;
  private boolean YH;
  final y YJ;
  final y YK;
  final aa YL;
  private Context Yp;
  private ActionBarContainer Yr;
  private ActionBarContextView Ys;
  private boolean Yv;
  b Yx;
  b.a Yy;
  private Activity mActivity;
  private View mContentView;
  private Context mContext;
  
  static
  {
    AppMethodBeat.i(141577);
    Yn = new AccelerateInterpolator();
    Yo = new DecelerateInterpolator();
    if (Build.VERSION.SDK_INT >= 14) {}
    for (boolean bool = true;; bool = false)
    {
      Htl = bool;
      AppMethodBeat.o(141577);
      return;
    }
  }
  
  public d(Activity paramActivity, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(141538);
    this.XX = new ArrayList();
    this.YA = 0;
    this.YB = true;
    this.YF = true;
    this.YJ = new z()
    {
      public final void aI(View paramAnonymousView)
      {
        AppMethodBeat.i(141518);
        if ((d.a(d.this)) && (d.b(d.this) != null))
        {
          t.e(d.b(d.this), 0.0F);
          t.e(d.c(d.this), 0.0F);
        }
        d.c(d.this).setVisibility(8);
        d.c(d.this).setTransitioning(false);
        d.d(d.this);
        paramAnonymousView = d.this;
        if (paramAnonymousView.Yy != null)
        {
          paramAnonymousView.Yy.a(paramAnonymousView.Yx);
          paramAnonymousView.Yx = null;
          paramAnonymousView.Yy = null;
        }
        AppMethodBeat.o(141518);
      }
    };
    this.YK = new z()
    {
      public final void aI(View paramAnonymousView)
      {
        AppMethodBeat.i(141519);
        d.d(d.this);
        d.c(d.this).requestLayout();
        AppMethodBeat.o(141519);
      }
    };
    this.YL = new aa()
    {
      public final void fj()
      {
        AppMethodBeat.i(141520);
        ((View)d.c(d.this).getParent()).invalidate();
        AppMethodBeat.o(141520);
      }
    };
    this.mActivity = paramActivity;
    paramActivity = paramViewGroup.findViewById(2131296343);
    if ((paramActivity instanceof u)) {}
    for (paramActivity = (u)paramActivity;; paramActivity = ((Toolbar)paramActivity).getWrapper())
    {
      this.XS = paramActivity;
      this.Ys = ((ActionBarContextView)paramViewGroup.findViewById(2131296357));
      this.Yr = ((ActionBarContainer)paramViewGroup.findViewById(2131296345));
      if ((this.XS != null) && (this.Ys != null) && (this.Yr != null)) {
        break label247;
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
    label247:
    this.mContext = this.XS.getContext();
    if ((this.XS.getDisplayOptions() & 0x4) != 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        this.Yv = true;
      }
      android.support.v7.view.a.Z(this.mContext).he();
      paramActivity = this.mContext.obtainStyledAttributes(null, a.a.ActionBar, 2130968602, 0);
      paramActivity.getBoolean(14, false);
      i = paramActivity.getDimensionPixelSize(12, 0);
      if (i != 0) {
        setElevation(i);
      }
      paramActivity.recycle();
      this.mContentView = null;
      AppMethodBeat.o(141538);
      return;
    }
  }
  
  private void V(boolean paramBoolean)
  {
    AppMethodBeat.i(141563);
    if (c(this.YC, this.YD, this.YE))
    {
      if (!this.YF)
      {
        this.YF = true;
        W(paramBoolean);
        AppMethodBeat.o(141563);
      }
    }
    else if (this.YF)
    {
      this.YF = false;
      X(paramBoolean);
    }
    AppMethodBeat.o(141563);
  }
  
  private void W(boolean paramBoolean)
  {
    AppMethodBeat.i(141564);
    if (this.YG != null) {
      this.YG.cancel();
    }
    this.Yr.setVisibility(0);
    if ((this.YA == 0) && (Htl) && ((this.YH) || (paramBoolean)))
    {
      t.e(this.Yr, 0.0F);
      float f2 = -this.Yr.getHeight();
      float f1 = f2;
      if (paramBoolean)
      {
        localObject = new int[2];
        Object tmp83_81 = localObject;
        tmp83_81[0] = 0;
        Object tmp87_83 = tmp83_81;
        tmp87_83[1] = 0;
        tmp87_83;
        this.Yr.getLocationInWindow((int[])localObject);
        f1 = f2 - localObject[1];
      }
      t.e(this.Yr, f1);
      Object localObject = new android.support.v7.view.h();
      x localx = t.ag(this.Yr).B(0.0F);
      localx.a(this.YL);
      ((android.support.v7.view.h)localObject).a(localx);
      if ((this.YB) && (this.mContentView != null))
      {
        t.e(this.mContentView, f1);
        ((android.support.v7.view.h)localObject).a(t.ag(this.mContentView).B(0.0F));
      }
      ((android.support.v7.view.h)localObject).b(Yo);
      ((android.support.v7.view.h)localObject).hj();
      ((android.support.v7.view.h)localObject).b(this.YK);
      this.YG = ((android.support.v7.view.h)localObject);
      ((android.support.v7.view.h)localObject).start();
      AppMethodBeat.o(141564);
      return;
    }
    t.f(this.Yr, 1.0F);
    t.e(this.Yr, 0.0F);
    if ((this.YB) && (this.mContentView != null)) {
      t.e(this.mContentView, 0.0F);
    }
    this.YK.aI(null);
    AppMethodBeat.o(141564);
  }
  
  private void X(boolean paramBoolean)
  {
    AppMethodBeat.i(141565);
    if (this.YG != null) {
      this.YG.cancel();
    }
    if ((this.YA == 0) && (Htl) && ((this.YH) || (paramBoolean)))
    {
      t.f(this.Yr, 1.0F);
      this.Yr.setTransitioning(true);
      android.support.v7.view.h localh = new android.support.v7.view.h();
      float f2 = -this.Yr.getHeight();
      float f1 = f2;
      if (paramBoolean)
      {
        localObject = new int[2];
        Object tmp92_90 = localObject;
        tmp92_90[0] = 0;
        Object tmp96_92 = tmp92_90;
        tmp96_92[1] = 0;
        tmp96_92;
        this.Yr.getLocationInWindow((int[])localObject);
        f1 = f2 - localObject[1];
      }
      Object localObject = t.ag(this.Yr).B(f1);
      ((x)localObject).a(this.YL);
      localh.a((x)localObject);
      if ((this.YB) && (this.mContentView != null)) {
        localh.a(t.ag(this.mContentView).B(f1));
      }
      localh.b(Yn);
      localh.hj();
      localh.b(this.YJ);
      this.YG = localh;
      localh.start();
      AppMethodBeat.o(141565);
      return;
    }
    this.YJ.aI(null);
    AppMethodBeat.o(141565);
  }
  
  private static boolean c(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramBoolean3) {}
    while ((!paramBoolean1) && (!paramBoolean2)) {
      return true;
    }
    return false;
  }
  
  private void gA()
  {
    AppMethodBeat.i(141561);
    if (this.YE)
    {
      this.YE = false;
      V(false);
    }
    AppMethodBeat.o(141561);
  }
  
  private void gy()
  {
    AppMethodBeat.i(141558);
    if (!this.YE)
    {
      this.YE = true;
      V(false);
    }
    AppMethodBeat.o(141558);
  }
  
  private void setDisplayOptions(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(141550);
    int i = this.XS.getDisplayOptions();
    if ((paramInt2 & 0x4) != 0) {
      this.Yv = true;
    }
    this.XS.setDisplayOptions(i & (paramInt2 ^ 0xFFFFFFFF) | paramInt1 & paramInt2);
    AppMethodBeat.o(141550);
  }
  
  public final void Q(boolean paramBoolean)
  {
    AppMethodBeat.i(141575);
    if (!this.Yv) {
      setDisplayHomeAsUpEnabled(paramBoolean);
    }
    AppMethodBeat.o(141575);
  }
  
  public final void R(boolean paramBoolean)
  {
    AppMethodBeat.i(141541);
    this.YH = paramBoolean;
    if ((!paramBoolean) && (this.YG != null)) {
      this.YG.cancel();
    }
    AppMethodBeat.o(141541);
  }
  
  public final void S(boolean paramBoolean)
  {
    AppMethodBeat.i(141542);
    if (paramBoolean == this.XW)
    {
      AppMethodBeat.o(141542);
      return;
    }
    this.XW = paramBoolean;
    int j = this.XX.size();
    int i = 0;
    while (i < j)
    {
      this.XX.get(i);
      i += 1;
    }
    AppMethodBeat.o(141542);
  }
  
  public final void U(boolean paramBoolean)
  {
    this.YB = paramBoolean;
  }
  
  public final void Y(boolean paramBoolean)
  {
    AppMethodBeat.i(141567);
    x localx1;
    x localx2;
    if (paramBoolean)
    {
      gy();
      if (!paramBoolean) {
        break label81;
      }
      localx1 = this.XS.c(8, 100L);
      localx2 = this.Ys.c(0, 200L);
    }
    for (;;)
    {
      android.support.v7.view.h localh = new android.support.v7.view.h();
      localh.a(localx1, localx2);
      localh.start();
      AppMethodBeat.o(141567);
      return;
      gA();
      break;
      label81:
      localx2 = this.XS.c(0, 200L);
      localx1 = this.Ys.c(8, 100L);
    }
  }
  
  public final b a(b.a parama)
  {
    AppMethodBeat.i(141555);
    if (this.Htm != null) {
      this.Htm.finish();
    }
    this.Ys.hX();
    parama = new a(this.Ys.getContext(), parama);
    if (parama.gD())
    {
      parama.invalidate();
      this.Ys.c(parama);
      Y(true);
      this.Ys.sendAccessibilityEvent(32);
      this.Htm = parama;
      AppMethodBeat.o(141555);
      return parama;
    }
    AppMethodBeat.o(141555);
    return null;
  }
  
  public final boolean collapseActionView()
  {
    AppMethodBeat.i(141571);
    if ((this.XS != null) && (this.XS.hasExpandedActionView()))
    {
      this.XS.collapseActionView();
      AppMethodBeat.o(141571);
      return true;
    }
    AppMethodBeat.o(141571);
    return false;
  }
  
  public final void fS()
  {
    AppMethodBeat.i(141573);
    this.XS.setIcon(2131234429);
    AppMethodBeat.o(141573);
  }
  
  public final void fT()
  {
    AppMethodBeat.i(141544);
    setDisplayOptions(0, 2);
    AppMethodBeat.o(141544);
  }
  
  public final void fU()
  {
    AppMethodBeat.i(141546);
    setDisplayOptions(0, 8);
    AppMethodBeat.o(141546);
  }
  
  public final void fV()
  {
    AppMethodBeat.i(141547);
    setDisplayOptions(16, 16);
    AppMethodBeat.o(141547);
  }
  
  public final void fW() {}
  
  public final void gB()
  {
    AppMethodBeat.i(141562);
    if (!this.YD)
    {
      this.YD = true;
      V(true);
    }
    AppMethodBeat.o(141562);
  }
  
  public final void gC()
  {
    AppMethodBeat.i(141570);
    if (this.YG != null)
    {
      this.YG.cancel();
      this.YG = null;
    }
    AppMethodBeat.o(141570);
  }
  
  public final View getCustomView()
  {
    AppMethodBeat.i(141552);
    View localView = this.XS.getCustomView();
    AppMethodBeat.o(141552);
    return localView;
  }
  
  public final int getDisplayOptions()
  {
    AppMethodBeat.i(141554);
    int i = this.XS.getDisplayOptions();
    AppMethodBeat.o(141554);
    return i;
  }
  
  public final int getHeight()
  {
    AppMethodBeat.i(141556);
    int i = this.Yr.getHeight();
    AppMethodBeat.o(141556);
    return i;
  }
  
  public final Context getThemedContext()
  {
    AppMethodBeat.i(141568);
    Object localObject;
    int i;
    if (this.Yp == null)
    {
      localObject = new TypedValue();
      this.mContext.getTheme().resolveAttribute(2130968607, (TypedValue)localObject, true);
      i = ((TypedValue)localObject).resourceId;
      if (i == 0) {
        break label75;
      }
    }
    label75:
    for (this.Yp = new ContextThemeWrapper(this.mContext, i);; this.Yp = this.mContext)
    {
      localObject = this.Yp;
      AppMethodBeat.o(141568);
      return localObject;
    }
  }
  
  public final CharSequence getTitle()
  {
    AppMethodBeat.i(141553);
    CharSequence localCharSequence = this.XS.getTitle();
    AppMethodBeat.o(141553);
    return localCharSequence;
  }
  
  public final void gz()
  {
    AppMethodBeat.i(141559);
    if (this.YD)
    {
      this.YD = false;
      V(true);
    }
    AppMethodBeat.o(141559);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(141560);
    if (!this.YC)
    {
      this.YC = true;
      V(false);
    }
    AppMethodBeat.o(141560);
  }
  
  public final boolean isShowing()
  {
    AppMethodBeat.i(141566);
    int i = this.Yr.getHeight();
    if ((this.YF) && ((i == 0) || (i > 0)))
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
    paramConfiguration = this.XS.jd().getLayoutParams();
    if (paramConfiguration != null) {
      paramConfiguration.height = com.tencent.mm.compatible.util.a.cd(this.mActivity);
    }
    this.XS.jd().setLayoutParams(paramConfiguration);
    AppMethodBeat.o(141540);
  }
  
  public final void onWindowVisibilityChanged(int paramInt)
  {
    this.YA = paramInt;
  }
  
  public final void setBackgroundDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(141551);
    this.Yr.setPrimaryBackground(paramDrawable);
    AppMethodBeat.o(141551);
  }
  
  public final void setCustomView(int paramInt)
  {
    AppMethodBeat.i(141543);
    setCustomView(LayoutInflater.from(getThemedContext()).inflate(paramInt, this.XS.jd(), false));
    AppMethodBeat.o(141543);
  }
  
  public final void setCustomView(View paramView)
  {
    AppMethodBeat.i(141572);
    this.XS.setCustomView(paramView);
    AppMethodBeat.o(141572);
  }
  
  public final void setDisplayHomeAsUpEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(141545);
    if (paramBoolean) {}
    for (int i = 4;; i = 0)
    {
      setDisplayOptions(i, 4);
      AppMethodBeat.o(141545);
      return;
    }
  }
  
  public final void setDisplayOptions(int paramInt)
  {
    AppMethodBeat.i(141549);
    if ((paramInt & 0x4) != 0) {
      this.Yv = true;
    }
    this.XS.setDisplayOptions(paramInt);
    AppMethodBeat.o(141549);
  }
  
  public final void setElevation(float paramFloat)
  {
    AppMethodBeat.i(141539);
    t.k(this.Yr, paramFloat);
    AppMethodBeat.o(141539);
  }
  
  public final void setHomeActionContentDescription(int paramInt)
  {
    AppMethodBeat.i(141569);
    this.XS.setNavigationContentDescription(paramInt);
    AppMethodBeat.o(141569);
  }
  
  public final void setLogo(Drawable paramDrawable)
  {
    AppMethodBeat.i(141574);
    this.XS.setLogo(paramDrawable);
    AppMethodBeat.o(141574);
  }
  
  public final void setWindowTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(141548);
    this.XS.setWindowTitle(paramCharSequence);
    AppMethodBeat.o(141548);
  }
  
  public final void show()
  {
    AppMethodBeat.i(141557);
    if (this.YC)
    {
      this.YC = false;
      V(false);
    }
    AppMethodBeat.o(141557);
  }
  
  public final class a
    extends b
    implements h.a
  {
    private final Context YN;
    private final android.support.v7.view.menu.h YO;
    private b.a YP;
    private WeakReference<View> YQ;
    
    public a(Context paramContext, b.a parama)
    {
      AppMethodBeat.i(141521);
      this.YN = paramContext;
      this.YP = parama;
      this$1 = new android.support.v7.view.menu.h(paramContext);
      d.this.aes = 1;
      this.YO = d.this;
      this.YO.a(this);
      AppMethodBeat.o(141521);
    }
    
    public final boolean a(android.support.v7.view.menu.h paramh, MenuItem paramMenuItem)
    {
      AppMethodBeat.i(141536);
      if (this.YP != null)
      {
        boolean bool = this.YP.a(this, paramMenuItem);
        AppMethodBeat.o(141536);
        return bool;
      }
      AppMethodBeat.o(141536);
      return false;
    }
    
    public final void b(android.support.v7.view.menu.h paramh)
    {
      AppMethodBeat.i(141537);
      if (this.YP == null)
      {
        AppMethodBeat.o(141537);
        return;
      }
      invalidate();
      d.g(d.this).showOverflowMenu();
      AppMethodBeat.o(141537);
    }
    
    public final void finish()
    {
      AppMethodBeat.i(141523);
      if (d.this.Htm != this)
      {
        AppMethodBeat.o(141523);
        return;
      }
      if (!d.aM(d.e(d.this), d.f(d.this)))
      {
        d.this.Yx = this;
        d.this.Yy = this.YP;
      }
      for (;;)
      {
        this.YP = null;
        d.this.Y(false);
        d.g(d.this).hW();
        d.h(d.this).jd().sendAccessibilityEvent(32);
        d.this.Htm = null;
        AppMethodBeat.o(141523);
        return;
        this.YP.a(this);
      }
    }
    
    public final boolean gD()
    {
      AppMethodBeat.i(141525);
      this.YO.hB();
      try
      {
        boolean bool = this.YP.a(this, this.YO);
        return bool;
      }
      finally
      {
        this.YO.hC();
        AppMethodBeat.o(141525);
      }
    }
    
    public final View getCustomView()
    {
      AppMethodBeat.i(141535);
      if (this.YQ != null)
      {
        View localView = (View)this.YQ.get();
        AppMethodBeat.o(141535);
        return localView;
      }
      AppMethodBeat.o(141535);
      return null;
    }
    
    public final Menu getMenu()
    {
      return this.YO;
    }
    
    public final MenuInflater getMenuInflater()
    {
      AppMethodBeat.i(141522);
      g localg = new g(this.YN);
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
      if (d.this.Htm != this)
      {
        AppMethodBeat.o(141524);
        return;
      }
      this.YO.hB();
      try
      {
        this.YP.b(this, this.YO);
        return;
      }
      finally
      {
        this.YO.hC();
        AppMethodBeat.o(141524);
      }
    }
    
    public final boolean isTitleOptional()
    {
      AppMethodBeat.i(141534);
      boolean bool = d.g(d.this).afK;
      AppMethodBeat.o(141534);
      return bool;
    }
    
    public final void setCustomView(View paramView)
    {
      AppMethodBeat.i(141526);
      d.g(d.this).setCustomView(paramView);
      this.YQ = new WeakReference(paramView);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.b.d
 * JD-Core Version:    0.7.0.1
 */
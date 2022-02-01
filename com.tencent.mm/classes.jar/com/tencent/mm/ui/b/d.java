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
import android.support.v4.view.ab;
import android.support.v4.view.y;
import android.support.v4.view.z;
import android.support.v7.a.a.a;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.LayoutParams;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public final class d
  extends ActionBar
  implements ActionBarOverlayLayout.a
{
  private static final boolean OMf;
  private static final Interpolator aap;
  private static final Interpolator aaq;
  a OMg;
  android.support.v7.widget.u ZU;
  private boolean ZY;
  private ArrayList<Object> ZZ;
  b.a aaA;
  private int aaC;
  private boolean aaD;
  private boolean aaE;
  private boolean aaF;
  private boolean aaG;
  private boolean aaH;
  private android.support.v7.view.h aaI;
  private boolean aaJ;
  final z aaL;
  final z aaM;
  final ab aaN;
  private Context aar;
  private ActionBarContainer aat;
  private ActionBarContextView aau;
  private boolean aax;
  b aaz;
  private Activity mActivity;
  private View mContentView;
  private Context mContext;
  
  static
  {
    AppMethodBeat.i(141577);
    aap = new AccelerateInterpolator();
    aaq = new DecelerateInterpolator();
    if (Build.VERSION.SDK_INT >= 14) {}
    for (boolean bool = true;; bool = false)
    {
      OMf = bool;
      AppMethodBeat.o(141577);
      return;
    }
  }
  
  public d(Activity paramActivity, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(141538);
    this.ZZ = new ArrayList();
    this.aaC = 0;
    this.aaD = true;
    this.aaH = true;
    this.aaL = new aa()
    {
      public final void aJ(View paramAnonymousView)
      {
        AppMethodBeat.i(141518);
        if ((d.a(d.this)) && (d.b(d.this) != null))
        {
          android.support.v4.view.u.f(d.b(d.this), 0.0F);
          android.support.v4.view.u.f(d.c(d.this), 0.0F);
        }
        d.c(d.this).setVisibility(8);
        d.c(d.this).setTransitioning(false);
        d.d(d.this);
        paramAnonymousView = d.this;
        if (paramAnonymousView.aaA != null)
        {
          paramAnonymousView.aaA.a(paramAnonymousView.aaz);
          paramAnonymousView.aaz = null;
          paramAnonymousView.aaA = null;
        }
        AppMethodBeat.o(141518);
      }
    };
    this.aaM = new aa()
    {
      public final void aJ(View paramAnonymousView)
      {
        AppMethodBeat.i(141519);
        d.d(d.this);
        d.c(d.this).requestLayout();
        AppMethodBeat.o(141519);
      }
    };
    this.aaN = new ab()
    {
      public final void fH()
      {
        AppMethodBeat.i(141520);
        ((View)d.c(d.this).getParent()).invalidate();
        AppMethodBeat.o(141520);
      }
    };
    this.mActivity = paramActivity;
    paramActivity = paramViewGroup.findViewById(2131296363);
    if ((paramActivity instanceof android.support.v7.widget.u)) {}
    for (paramActivity = (android.support.v7.widget.u)paramActivity;; paramActivity = ((Toolbar)paramActivity).getWrapper())
    {
      this.ZU = paramActivity;
      this.aau = ((ActionBarContextView)paramViewGroup.findViewById(2131296380));
      this.aat = ((ActionBarContainer)paramViewGroup.findViewById(2131296366));
      if ((this.ZU != null) && (this.aau != null) && (this.aat != null)) {
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
    this.mContext = this.ZU.getContext();
    if ((this.ZU.getDisplayOptions() & 0x4) != 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        this.aax = true;
      }
      android.support.v7.view.a.ab(this.mContext).hD();
      paramActivity = this.mContext.obtainStyledAttributes(null, a.a.ActionBar, 2130968603, 0);
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
  
  private void U(boolean paramBoolean)
  {
    AppMethodBeat.i(141563);
    if (c(this.aaE, this.aaF, this.aaG))
    {
      if (!this.aaH)
      {
        this.aaH = true;
        V(paramBoolean);
        AppMethodBeat.o(141563);
      }
    }
    else if (this.aaH)
    {
      this.aaH = false;
      W(paramBoolean);
    }
    AppMethodBeat.o(141563);
  }
  
  private void V(boolean paramBoolean)
  {
    AppMethodBeat.i(141564);
    if (this.aaI != null) {
      this.aaI.cancel();
    }
    this.aat.setVisibility(0);
    if ((this.aaC == 0) && (OMf) && ((this.aaJ) || (paramBoolean)))
    {
      android.support.v4.view.u.f(this.aat, 0.0F);
      float f2 = -this.aat.getHeight();
      float f1 = f2;
      if (paramBoolean)
      {
        localObject = new int[2];
        Object tmp83_81 = localObject;
        tmp83_81[0] = 0;
        Object tmp87_83 = tmp83_81;
        tmp87_83[1] = 0;
        tmp87_83;
        this.aat.getLocationInWindow((int[])localObject);
        f1 = f2 - localObject[1];
      }
      android.support.v4.view.u.f(this.aat, f1);
      Object localObject = new android.support.v7.view.h();
      y localy = android.support.v4.view.u.ah(this.aat).z(0.0F);
      localy.a(this.aaN);
      ((android.support.v7.view.h)localObject).a(localy);
      if ((this.aaD) && (this.mContentView != null))
      {
        android.support.v4.view.u.f(this.mContentView, f1);
        ((android.support.v7.view.h)localObject).a(android.support.v4.view.u.ah(this.mContentView).z(0.0F));
      }
      ((android.support.v7.view.h)localObject).b(aaq);
      ((android.support.v7.view.h)localObject).hI();
      ((android.support.v7.view.h)localObject).b(this.aaM);
      this.aaI = ((android.support.v7.view.h)localObject);
      ((android.support.v7.view.h)localObject).start();
      AppMethodBeat.o(141564);
      return;
    }
    android.support.v4.view.u.g(this.aat, 1.0F);
    android.support.v4.view.u.f(this.aat, 0.0F);
    if ((this.aaD) && (this.mContentView != null)) {
      android.support.v4.view.u.f(this.mContentView, 0.0F);
    }
    this.aaM.aJ(null);
    AppMethodBeat.o(141564);
  }
  
  private void W(boolean paramBoolean)
  {
    AppMethodBeat.i(141565);
    if (this.aaI != null) {
      this.aaI.cancel();
    }
    if ((this.aaC == 0) && (OMf) && ((this.aaJ) || (paramBoolean)))
    {
      android.support.v4.view.u.g(this.aat, 1.0F);
      this.aat.setTransitioning(true);
      android.support.v7.view.h localh = new android.support.v7.view.h();
      float f2 = -this.aat.getHeight();
      float f1 = f2;
      if (paramBoolean)
      {
        localObject = new int[2];
        Object tmp92_90 = localObject;
        tmp92_90[0] = 0;
        Object tmp96_92 = tmp92_90;
        tmp96_92[1] = 0;
        tmp96_92;
        this.aat.getLocationInWindow((int[])localObject);
        f1 = f2 - localObject[1];
      }
      Object localObject = android.support.v4.view.u.ah(this.aat).z(f1);
      ((y)localObject).a(this.aaN);
      localh.a((y)localObject);
      if ((this.aaD) && (this.mContentView != null)) {
        localh.a(android.support.v4.view.u.ah(this.mContentView).z(f1));
      }
      localh.b(aap);
      localh.hI();
      localh.b(this.aaL);
      this.aaI = localh;
      localh.start();
      AppMethodBeat.o(141565);
      return;
    }
    this.aaL.aJ(null);
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
  
  private void gW()
  {
    AppMethodBeat.i(141558);
    if (!this.aaG)
    {
      this.aaG = true;
      U(false);
    }
    AppMethodBeat.o(141558);
  }
  
  private void gY()
  {
    AppMethodBeat.i(141561);
    if (this.aaG)
    {
      this.aaG = false;
      U(false);
    }
    AppMethodBeat.o(141561);
  }
  
  private void setDisplayOptions(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(141550);
    int i = this.ZU.getDisplayOptions();
    if ((paramInt2 & 0x4) != 0) {
      this.aax = true;
    }
    this.ZU.setDisplayOptions(i & (paramInt2 ^ 0xFFFFFFFF) | paramInt1 & paramInt2);
    AppMethodBeat.o(141550);
  }
  
  public final void P(boolean paramBoolean)
  {
    AppMethodBeat.i(141575);
    if (!this.aax) {
      setDisplayHomeAsUpEnabled(paramBoolean);
    }
    AppMethodBeat.o(141575);
  }
  
  public final void Q(boolean paramBoolean)
  {
    AppMethodBeat.i(141541);
    this.aaJ = paramBoolean;
    if ((!paramBoolean) && (this.aaI != null)) {
      this.aaI.cancel();
    }
    AppMethodBeat.o(141541);
  }
  
  public final void R(boolean paramBoolean)
  {
    AppMethodBeat.i(141542);
    if (paramBoolean == this.ZY)
    {
      AppMethodBeat.o(141542);
      return;
    }
    this.ZY = paramBoolean;
    int j = this.ZZ.size();
    int i = 0;
    while (i < j)
    {
      this.ZZ.get(i);
      i += 1;
    }
    AppMethodBeat.o(141542);
  }
  
  public final void T(boolean paramBoolean)
  {
    this.aaD = paramBoolean;
  }
  
  public final void X(boolean paramBoolean)
  {
    AppMethodBeat.i(141567);
    y localy1;
    y localy2;
    if (paramBoolean)
    {
      gW();
      if (!paramBoolean) {
        break label81;
      }
      localy1 = this.ZU.c(8, 100L);
      localy2 = this.aau.c(0, 200L);
    }
    for (;;)
    {
      android.support.v7.view.h localh = new android.support.v7.view.h();
      localh.a(localy1, localy2);
      localh.start();
      AppMethodBeat.o(141567);
      return;
      gY();
      break;
      label81:
      localy2 = this.ZU.c(0, 200L);
      localy1 = this.aau.c(8, 100L);
    }
  }
  
  public final b a(b.a parama)
  {
    AppMethodBeat.i(141555);
    if (this.OMg != null) {
      this.OMg.finish();
    }
    this.aau.iy();
    parama = new a(this.aau.getContext(), parama);
    if (parama.hb())
    {
      parama.invalidate();
      this.aau.c(parama);
      X(true);
      this.aau.sendAccessibilityEvent(32);
      this.OMg = parama;
      AppMethodBeat.o(141555);
      return parama;
    }
    AppMethodBeat.o(141555);
    return null;
  }
  
  public final void a(View paramView, ActionBar.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(205158);
    paramView.setLayoutParams(paramLayoutParams);
    this.ZU.setCustomView(paramView);
    AppMethodBeat.o(205158);
  }
  
  public final boolean collapseActionView()
  {
    AppMethodBeat.i(141571);
    if ((this.ZU != null) && (this.ZU.hasExpandedActionView()))
    {
      this.ZU.collapseActionView();
      AppMethodBeat.o(141571);
      return true;
    }
    AppMethodBeat.o(141571);
    return false;
  }
  
  public final void gX()
  {
    AppMethodBeat.i(141559);
    if (this.aaF)
    {
      this.aaF = false;
      U(true);
    }
    AppMethodBeat.o(141559);
  }
  
  public final void gZ()
  {
    AppMethodBeat.i(141562);
    if (!this.aaF)
    {
      this.aaF = true;
      U(true);
    }
    AppMethodBeat.o(141562);
  }
  
  public final View getCustomView()
  {
    AppMethodBeat.i(141552);
    View localView = this.ZU.getCustomView();
    AppMethodBeat.o(141552);
    return localView;
  }
  
  public final int getDisplayOptions()
  {
    AppMethodBeat.i(141554);
    int i = this.ZU.getDisplayOptions();
    AppMethodBeat.o(141554);
    return i;
  }
  
  public final int getHeight()
  {
    AppMethodBeat.i(141556);
    int i = this.aat.getHeight();
    AppMethodBeat.o(141556);
    return i;
  }
  
  public final Context getThemedContext()
  {
    AppMethodBeat.i(141568);
    Object localObject;
    int i;
    if (this.aar == null)
    {
      localObject = new TypedValue();
      this.mContext.getTheme().resolveAttribute(2130968608, (TypedValue)localObject, true);
      i = ((TypedValue)localObject).resourceId;
      if (i == 0) {
        break label75;
      }
    }
    label75:
    for (this.aar = new ContextThemeWrapper(this.mContext, i);; this.aar = this.mContext)
    {
      localObject = this.aar;
      AppMethodBeat.o(141568);
      return localObject;
    }
  }
  
  public final CharSequence getTitle()
  {
    AppMethodBeat.i(141553);
    CharSequence localCharSequence = this.ZU.getTitle();
    AppMethodBeat.o(141553);
    return localCharSequence;
  }
  
  public final void gr()
  {
    AppMethodBeat.i(141573);
    this.ZU.setIcon(2131235359);
    AppMethodBeat.o(141573);
  }
  
  public final void gs()
  {
    AppMethodBeat.i(141544);
    setDisplayOptions(0, 2);
    AppMethodBeat.o(141544);
  }
  
  public final void gt()
  {
    AppMethodBeat.i(141546);
    setDisplayOptions(0, 8);
    AppMethodBeat.o(141546);
  }
  
  public final void gu()
  {
    AppMethodBeat.i(141547);
    setDisplayOptions(16, 16);
    AppMethodBeat.o(141547);
  }
  
  public final void gv() {}
  
  public final void ha()
  {
    AppMethodBeat.i(141570);
    if (this.aaI != null)
    {
      this.aaI.cancel();
      this.aaI = null;
    }
    AppMethodBeat.o(141570);
  }
  
  public final void hide()
  {
    AppMethodBeat.i(141560);
    if (!this.aaE)
    {
      this.aaE = true;
      U(false);
    }
    AppMethodBeat.o(141560);
  }
  
  public final boolean isShowing()
  {
    AppMethodBeat.i(141566);
    int i = this.aat.getHeight();
    if ((this.aaH) && ((i == 0) || (i > 0)))
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
    paramConfiguration = this.ZU.jC().getLayoutParams();
    if (paramConfiguration != null) {
      paramConfiguration.height = com.tencent.mm.compatible.util.a.cy(this.mActivity);
    }
    this.ZU.jC().setLayoutParams(paramConfiguration);
    AppMethodBeat.o(141540);
  }
  
  public final void onWindowVisibilityChanged(int paramInt)
  {
    this.aaC = paramInt;
  }
  
  public final void setBackgroundDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(141551);
    this.aat.setPrimaryBackground(paramDrawable);
    AppMethodBeat.o(141551);
  }
  
  public final void setCustomView(int paramInt)
  {
    AppMethodBeat.i(141543);
    setCustomView(LayoutInflater.from(getThemedContext()).inflate(paramInt, this.ZU.jC(), false));
    AppMethodBeat.o(141543);
  }
  
  public final void setCustomView(View paramView)
  {
    AppMethodBeat.i(141572);
    this.ZU.setCustomView(paramView);
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
      this.aax = true;
    }
    this.ZU.setDisplayOptions(paramInt);
    AppMethodBeat.o(141549);
  }
  
  public final void setElevation(float paramFloat)
  {
    AppMethodBeat.i(141539);
    android.support.v4.view.u.l(this.aat, paramFloat);
    AppMethodBeat.o(141539);
  }
  
  public final void setHomeActionContentDescription(int paramInt)
  {
    AppMethodBeat.i(141569);
    this.ZU.setNavigationContentDescription(paramInt);
    AppMethodBeat.o(141569);
  }
  
  public final void setLogo(Drawable paramDrawable)
  {
    AppMethodBeat.i(141574);
    this.ZU.setLogo(paramDrawable);
    AppMethodBeat.o(141574);
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(205157);
    this.ZU.setTitle(paramCharSequence);
    AppMethodBeat.o(205157);
  }
  
  public final void setWindowTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(141548);
    this.ZU.setWindowTitle(paramCharSequence);
    AppMethodBeat.o(141548);
  }
  
  public final void show()
  {
    AppMethodBeat.i(141557);
    if (this.aaE)
    {
      this.aaE = false;
      U(false);
    }
    AppMethodBeat.o(141557);
  }
  
  public final class a
    extends b
    implements h.a
  {
    private final Context aaP;
    private final android.support.v7.view.menu.h aaQ;
    private b.a aaR;
    private WeakReference<View> aaS;
    
    public a(Context paramContext, b.a parama)
    {
      AppMethodBeat.i(141521);
      this.aaP = paramContext;
      this.aaR = parama;
      this$1 = new android.support.v7.view.menu.h(paramContext);
      d.this.agw = 1;
      this.aaQ = d.this;
      this.aaQ.a(this);
      AppMethodBeat.o(141521);
    }
    
    public final boolean a(android.support.v7.view.menu.h paramh, MenuItem paramMenuItem)
    {
      AppMethodBeat.i(141536);
      if (this.aaR != null)
      {
        boolean bool = this.aaR.a(this, paramMenuItem);
        AppMethodBeat.o(141536);
        return bool;
      }
      AppMethodBeat.o(141536);
      return false;
    }
    
    public final void b(android.support.v7.view.menu.h paramh)
    {
      AppMethodBeat.i(141537);
      if (this.aaR == null)
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
      if (d.this.OMg != this)
      {
        AppMethodBeat.o(141523);
        return;
      }
      if (!d.bd(d.e(d.this), d.f(d.this)))
      {
        d.this.aaz = this;
        d.this.aaA = this.aaR;
      }
      for (;;)
      {
        this.aaR = null;
        d.this.X(false);
        d.g(d.this).ix();
        d.h(d.this).jC().sendAccessibilityEvent(32);
        d.this.OMg = null;
        AppMethodBeat.o(141523);
        return;
        this.aaR.a(this);
      }
    }
    
    public final View getCustomView()
    {
      AppMethodBeat.i(141535);
      if (this.aaS != null)
      {
        View localView = (View)this.aaS.get();
        AppMethodBeat.o(141535);
        return localView;
      }
      AppMethodBeat.o(141535);
      return null;
    }
    
    public final Menu getMenu()
    {
      return this.aaQ;
    }
    
    public final MenuInflater getMenuInflater()
    {
      AppMethodBeat.i(141522);
      g localg = new g(this.aaP);
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
    
    public final boolean hb()
    {
      AppMethodBeat.i(141525);
      this.aaQ.ia();
      try
      {
        boolean bool = this.aaR.a(this, this.aaQ);
        return bool;
      }
      finally
      {
        this.aaQ.ib();
        AppMethodBeat.o(141525);
      }
    }
    
    public final void invalidate()
    {
      AppMethodBeat.i(141524);
      if (d.this.OMg != this)
      {
        AppMethodBeat.o(141524);
        return;
      }
      this.aaQ.ia();
      try
      {
        this.aaR.b(this, this.aaQ);
        return;
      }
      finally
      {
        this.aaQ.ib();
        AppMethodBeat.o(141524);
      }
    }
    
    public final boolean isTitleOptional()
    {
      AppMethodBeat.i(141534);
      boolean bool = d.g(d.this).ahO;
      AppMethodBeat.o(141534);
      return bool;
    }
    
    public final void setCustomView(View paramView)
    {
      AppMethodBeat.i(141526);
      d.g(d.this).setCustomView(paramView);
      this.aaS = new WeakReference(paramView);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.b.d
 * JD-Core Version:    0.7.0.1
 */
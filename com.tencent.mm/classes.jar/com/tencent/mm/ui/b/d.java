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
  private static final boolean JBM;
  private static final Interpolator aac;
  private static final Interpolator aad;
  a JBN;
  u ZH;
  private boolean ZL;
  private ArrayList<Object> ZM;
  final aa aaA;
  private Context aae;
  private ActionBarContainer aag;
  private ActionBarContextView aah;
  private boolean aak;
  b aam;
  b.a aan;
  private int aap;
  private boolean aaq;
  private boolean aar;
  private boolean aas;
  private boolean aat;
  private boolean aau;
  private android.support.v7.view.h aav;
  private boolean aaw;
  final y aay;
  final y aaz;
  private Activity mActivity;
  private View mContentView;
  private Context mContext;
  
  static
  {
    AppMethodBeat.i(141577);
    aac = new AccelerateInterpolator();
    aad = new DecelerateInterpolator();
    if (Build.VERSION.SDK_INT >= 14) {}
    for (boolean bool = true;; bool = false)
    {
      JBM = bool;
      AppMethodBeat.o(141577);
      return;
    }
  }
  
  public d(Activity paramActivity, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(141538);
    this.ZM = new ArrayList();
    this.aap = 0;
    this.aaq = true;
    this.aau = true;
    this.aay = new z()
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
        if (paramAnonymousView.aan != null)
        {
          paramAnonymousView.aan.a(paramAnonymousView.aam);
          paramAnonymousView.aam = null;
          paramAnonymousView.aan = null;
        }
        AppMethodBeat.o(141518);
      }
    };
    this.aaz = new z()
    {
      public final void aI(View paramAnonymousView)
      {
        AppMethodBeat.i(141519);
        d.d(d.this);
        d.c(d.this).requestLayout();
        AppMethodBeat.o(141519);
      }
    };
    this.aaA = new aa()
    {
      public final void fA()
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
      this.ZH = paramActivity;
      this.aah = ((ActionBarContextView)paramViewGroup.findViewById(2131296357));
      this.aag = ((ActionBarContainer)paramViewGroup.findViewById(2131296345));
      if ((this.ZH != null) && (this.aah != null) && (this.aag != null)) {
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
    this.mContext = this.ZH.getContext();
    if ((this.ZH.getDisplayOptions() & 0x4) != 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        this.aak = true;
      }
      android.support.v7.view.a.aa(this.mContext).hu();
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
    if (c(this.aar, this.aas, this.aat))
    {
      if (!this.aau)
      {
        this.aau = true;
        W(paramBoolean);
        AppMethodBeat.o(141563);
      }
    }
    else if (this.aau)
    {
      this.aau = false;
      X(paramBoolean);
    }
    AppMethodBeat.o(141563);
  }
  
  private void W(boolean paramBoolean)
  {
    AppMethodBeat.i(141564);
    if (this.aav != null) {
      this.aav.cancel();
    }
    this.aag.setVisibility(0);
    if ((this.aap == 0) && (JBM) && ((this.aaw) || (paramBoolean)))
    {
      t.e(this.aag, 0.0F);
      float f2 = -this.aag.getHeight();
      float f1 = f2;
      if (paramBoolean)
      {
        localObject = new int[2];
        Object tmp83_81 = localObject;
        tmp83_81[0] = 0;
        Object tmp87_83 = tmp83_81;
        tmp87_83[1] = 0;
        tmp87_83;
        this.aag.getLocationInWindow((int[])localObject);
        f1 = f2 - localObject[1];
      }
      t.e(this.aag, f1);
      Object localObject = new android.support.v7.view.h();
      x localx = t.ag(this.aag).z(0.0F);
      localx.a(this.aaA);
      ((android.support.v7.view.h)localObject).a(localx);
      if ((this.aaq) && (this.mContentView != null))
      {
        t.e(this.mContentView, f1);
        ((android.support.v7.view.h)localObject).a(t.ag(this.mContentView).z(0.0F));
      }
      ((android.support.v7.view.h)localObject).b(aad);
      ((android.support.v7.view.h)localObject).hz();
      ((android.support.v7.view.h)localObject).b(this.aaz);
      this.aav = ((android.support.v7.view.h)localObject);
      ((android.support.v7.view.h)localObject).start();
      AppMethodBeat.o(141564);
      return;
    }
    t.f(this.aag, 1.0F);
    t.e(this.aag, 0.0F);
    if ((this.aaq) && (this.mContentView != null)) {
      t.e(this.mContentView, 0.0F);
    }
    this.aaz.aI(null);
    AppMethodBeat.o(141564);
  }
  
  private void X(boolean paramBoolean)
  {
    AppMethodBeat.i(141565);
    if (this.aav != null) {
      this.aav.cancel();
    }
    if ((this.aap == 0) && (JBM) && ((this.aaw) || (paramBoolean)))
    {
      t.f(this.aag, 1.0F);
      this.aag.setTransitioning(true);
      android.support.v7.view.h localh = new android.support.v7.view.h();
      float f2 = -this.aag.getHeight();
      float f1 = f2;
      if (paramBoolean)
      {
        localObject = new int[2];
        Object tmp92_90 = localObject;
        tmp92_90[0] = 0;
        Object tmp96_92 = tmp92_90;
        tmp96_92[1] = 0;
        tmp96_92;
        this.aag.getLocationInWindow((int[])localObject);
        f1 = f2 - localObject[1];
      }
      Object localObject = t.ag(this.aag).z(f1);
      ((x)localObject).a(this.aaA);
      localh.a((x)localObject);
      if ((this.aaq) && (this.mContentView != null)) {
        localh.a(t.ag(this.mContentView).z(f1));
      }
      localh.b(aac);
      localh.hz();
      localh.b(this.aay);
      this.aav = localh;
      localh.start();
      AppMethodBeat.o(141565);
      return;
    }
    this.aay.aI(null);
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
  
  private void gP()
  {
    AppMethodBeat.i(141558);
    if (!this.aat)
    {
      this.aat = true;
      V(false);
    }
    AppMethodBeat.o(141558);
  }
  
  private void gR()
  {
    AppMethodBeat.i(141561);
    if (this.aat)
    {
      this.aat = false;
      V(false);
    }
    AppMethodBeat.o(141561);
  }
  
  private void setDisplayOptions(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(141550);
    int i = this.ZH.getDisplayOptions();
    if ((paramInt2 & 0x4) != 0) {
      this.aak = true;
    }
    this.ZH.setDisplayOptions(i & (paramInt2 ^ 0xFFFFFFFF) | paramInt1 & paramInt2);
    AppMethodBeat.o(141550);
  }
  
  public final void Q(boolean paramBoolean)
  {
    AppMethodBeat.i(141575);
    if (!this.aak) {
      setDisplayHomeAsUpEnabled(paramBoolean);
    }
    AppMethodBeat.o(141575);
  }
  
  public final void R(boolean paramBoolean)
  {
    AppMethodBeat.i(141541);
    this.aaw = paramBoolean;
    if ((!paramBoolean) && (this.aav != null)) {
      this.aav.cancel();
    }
    AppMethodBeat.o(141541);
  }
  
  public final void S(boolean paramBoolean)
  {
    AppMethodBeat.i(141542);
    if (paramBoolean == this.ZL)
    {
      AppMethodBeat.o(141542);
      return;
    }
    this.ZL = paramBoolean;
    int j = this.ZM.size();
    int i = 0;
    while (i < j)
    {
      this.ZM.get(i);
      i += 1;
    }
    AppMethodBeat.o(141542);
  }
  
  public final void U(boolean paramBoolean)
  {
    this.aaq = paramBoolean;
  }
  
  public final void Y(boolean paramBoolean)
  {
    AppMethodBeat.i(141567);
    x localx1;
    x localx2;
    if (paramBoolean)
    {
      gP();
      if (!paramBoolean) {
        break label81;
      }
      localx1 = this.ZH.c(8, 100L);
      localx2 = this.aah.c(0, 200L);
    }
    for (;;)
    {
      android.support.v7.view.h localh = new android.support.v7.view.h();
      localh.a(localx1, localx2);
      localh.start();
      AppMethodBeat.o(141567);
      return;
      gR();
      break;
      label81:
      localx2 = this.ZH.c(0, 200L);
      localx1 = this.aah.c(8, 100L);
    }
  }
  
  public final b a(b.a parama)
  {
    AppMethodBeat.i(141555);
    if (this.JBN != null) {
      this.JBN.finish();
    }
    this.aah.ip();
    parama = new a(this.aah.getContext(), parama);
    if (parama.gU())
    {
      parama.invalidate();
      this.aah.c(parama);
      Y(true);
      this.aah.sendAccessibilityEvent(32);
      this.JBN = parama;
      AppMethodBeat.o(141555);
      return parama;
    }
    AppMethodBeat.o(141555);
    return null;
  }
  
  public final boolean collapseActionView()
  {
    AppMethodBeat.i(141571);
    if ((this.ZH != null) && (this.ZH.hasExpandedActionView()))
    {
      this.ZH.collapseActionView();
      AppMethodBeat.o(141571);
      return true;
    }
    AppMethodBeat.o(141571);
    return false;
  }
  
  public final void gQ()
  {
    AppMethodBeat.i(141559);
    if (this.aas)
    {
      this.aas = false;
      V(true);
    }
    AppMethodBeat.o(141559);
  }
  
  public final void gS()
  {
    AppMethodBeat.i(141562);
    if (!this.aas)
    {
      this.aas = true;
      V(true);
    }
    AppMethodBeat.o(141562);
  }
  
  public final void gT()
  {
    AppMethodBeat.i(141570);
    if (this.aav != null)
    {
      this.aav.cancel();
      this.aav = null;
    }
    AppMethodBeat.o(141570);
  }
  
  public final View getCustomView()
  {
    AppMethodBeat.i(141552);
    View localView = this.ZH.getCustomView();
    AppMethodBeat.o(141552);
    return localView;
  }
  
  public final int getDisplayOptions()
  {
    AppMethodBeat.i(141554);
    int i = this.ZH.getDisplayOptions();
    AppMethodBeat.o(141554);
    return i;
  }
  
  public final int getHeight()
  {
    AppMethodBeat.i(141556);
    int i = this.aag.getHeight();
    AppMethodBeat.o(141556);
    return i;
  }
  
  public final Context getThemedContext()
  {
    AppMethodBeat.i(141568);
    Object localObject;
    int i;
    if (this.aae == null)
    {
      localObject = new TypedValue();
      this.mContext.getTheme().resolveAttribute(2130968607, (TypedValue)localObject, true);
      i = ((TypedValue)localObject).resourceId;
      if (i == 0) {
        break label75;
      }
    }
    label75:
    for (this.aae = new ContextThemeWrapper(this.mContext, i);; this.aae = this.mContext)
    {
      localObject = this.aae;
      AppMethodBeat.o(141568);
      return localObject;
    }
  }
  
  public final CharSequence getTitle()
  {
    AppMethodBeat.i(141553);
    CharSequence localCharSequence = this.ZH.getTitle();
    AppMethodBeat.o(141553);
    return localCharSequence;
  }
  
  public final void gk()
  {
    AppMethodBeat.i(141573);
    this.ZH.setIcon(2131234429);
    AppMethodBeat.o(141573);
  }
  
  public final void gl()
  {
    AppMethodBeat.i(141544);
    setDisplayOptions(0, 2);
    AppMethodBeat.o(141544);
  }
  
  public final void gm()
  {
    AppMethodBeat.i(141546);
    setDisplayOptions(0, 8);
    AppMethodBeat.o(141546);
  }
  
  public final void gn()
  {
    AppMethodBeat.i(141547);
    setDisplayOptions(16, 16);
    AppMethodBeat.o(141547);
  }
  
  public final void go() {}
  
  public final void hide()
  {
    AppMethodBeat.i(141560);
    if (!this.aar)
    {
      this.aar = true;
      V(false);
    }
    AppMethodBeat.o(141560);
  }
  
  public final boolean isShowing()
  {
    AppMethodBeat.i(141566);
    int i = this.aag.getHeight();
    if ((this.aau) && ((i == 0) || (i > 0)))
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
    paramConfiguration = this.ZH.jt().getLayoutParams();
    if (paramConfiguration != null) {
      paramConfiguration.height = com.tencent.mm.compatible.util.a.cd(this.mActivity);
    }
    this.ZH.jt().setLayoutParams(paramConfiguration);
    AppMethodBeat.o(141540);
  }
  
  public final void onWindowVisibilityChanged(int paramInt)
  {
    this.aap = paramInt;
  }
  
  public final void setBackgroundDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(141551);
    this.aag.setPrimaryBackground(paramDrawable);
    AppMethodBeat.o(141551);
  }
  
  public final void setCustomView(int paramInt)
  {
    AppMethodBeat.i(141543);
    setCustomView(LayoutInflater.from(getThemedContext()).inflate(paramInt, this.ZH.jt(), false));
    AppMethodBeat.o(141543);
  }
  
  public final void setCustomView(View paramView)
  {
    AppMethodBeat.i(141572);
    this.ZH.setCustomView(paramView);
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
      this.aak = true;
    }
    this.ZH.setDisplayOptions(paramInt);
    AppMethodBeat.o(141549);
  }
  
  public final void setElevation(float paramFloat)
  {
    AppMethodBeat.i(141539);
    t.k(this.aag, paramFloat);
    AppMethodBeat.o(141539);
  }
  
  public final void setHomeActionContentDescription(int paramInt)
  {
    AppMethodBeat.i(141569);
    this.ZH.setNavigationContentDescription(paramInt);
    AppMethodBeat.o(141569);
  }
  
  public final void setLogo(Drawable paramDrawable)
  {
    AppMethodBeat.i(141574);
    this.ZH.setLogo(paramDrawable);
    AppMethodBeat.o(141574);
  }
  
  public final void setWindowTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(141548);
    this.ZH.setWindowTitle(paramCharSequence);
    AppMethodBeat.o(141548);
  }
  
  public final void show()
  {
    AppMethodBeat.i(141557);
    if (this.aar)
    {
      this.aar = false;
      V(false);
    }
    AppMethodBeat.o(141557);
  }
  
  public final class a
    extends b
    implements h.a
  {
    private final Context aaC;
    private final android.support.v7.view.menu.h aaD;
    private b.a aaE;
    private WeakReference<View> aaF;
    
    public a(Context paramContext, b.a parama)
    {
      AppMethodBeat.i(141521);
      this.aaC = paramContext;
      this.aaE = parama;
      this$1 = new android.support.v7.view.menu.h(paramContext);
      d.this.agj = 1;
      this.aaD = d.this;
      this.aaD.a(this);
      AppMethodBeat.o(141521);
    }
    
    public final boolean a(android.support.v7.view.menu.h paramh, MenuItem paramMenuItem)
    {
      AppMethodBeat.i(141536);
      if (this.aaE != null)
      {
        boolean bool = this.aaE.a(this, paramMenuItem);
        AppMethodBeat.o(141536);
        return bool;
      }
      AppMethodBeat.o(141536);
      return false;
    }
    
    public final void b(android.support.v7.view.menu.h paramh)
    {
      AppMethodBeat.i(141537);
      if (this.aaE == null)
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
      if (d.this.JBN != this)
      {
        AppMethodBeat.o(141523);
        return;
      }
      if (!d.aT(d.e(d.this), d.f(d.this)))
      {
        d.this.aam = this;
        d.this.aan = this.aaE;
      }
      for (;;)
      {
        this.aaE = null;
        d.this.Y(false);
        d.g(d.this).in();
        d.h(d.this).jt().sendAccessibilityEvent(32);
        d.this.JBN = null;
        AppMethodBeat.o(141523);
        return;
        this.aaE.a(this);
      }
    }
    
    public final boolean gU()
    {
      AppMethodBeat.i(141525);
      this.aaD.hR();
      try
      {
        boolean bool = this.aaE.a(this, this.aaD);
        return bool;
      }
      finally
      {
        this.aaD.hS();
        AppMethodBeat.o(141525);
      }
    }
    
    public final View getCustomView()
    {
      AppMethodBeat.i(141535);
      if (this.aaF != null)
      {
        View localView = (View)this.aaF.get();
        AppMethodBeat.o(141535);
        return localView;
      }
      AppMethodBeat.o(141535);
      return null;
    }
    
    public final Menu getMenu()
    {
      return this.aaD;
    }
    
    public final MenuInflater getMenuInflater()
    {
      AppMethodBeat.i(141522);
      g localg = new g(this.aaC);
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
      if (d.this.JBN != this)
      {
        AppMethodBeat.o(141524);
        return;
      }
      this.aaD.hR();
      try
      {
        this.aaE.b(this, this.aaD);
        return;
      }
      finally
      {
        this.aaD.hS();
        AppMethodBeat.o(141524);
      }
    }
    
    public final boolean isTitleOptional()
    {
      AppMethodBeat.i(141534);
      boolean bool = d.g(d.this).ahB;
      AppMethodBeat.o(141534);
      return bool;
    }
    
    public final void setCustomView(View paramView)
    {
      AppMethodBeat.i(141526);
      d.g(d.this).setCustomView(paramView);
      this.aaF = new WeakReference(paramView);
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
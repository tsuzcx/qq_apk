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
import androidx.core.g.ad;
import androidx.core.g.ae;
import androidx.core.g.af;
import androidx.core.g.ag;
import androidx.core.g.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.a.g;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public final class d
  extends ActionBar
  implements ActionBarOverlayLayout.a
{
  private static final boolean adLL;
  private static final Interpolator iM;
  private static final Interpolator iN;
  a adLM;
  private Context iO;
  private ActionBarContainer iQ;
  private ActionBarContextView iR;
  private boolean iV;
  b iX;
  b.a iY;
  n iq;
  private boolean iu;
  private ArrayList<Object> iw;
  private int ja;
  private boolean jb;
  private boolean jc;
  private boolean jd;
  private boolean je;
  private boolean jf;
  private androidx.appcompat.view.h jg;
  private boolean jh;
  final ae jj;
  final ae jk;
  final ag jl;
  private Activity mActivity;
  private View mContentView;
  private Context mContext;
  
  static
  {
    AppMethodBeat.i(141577);
    iM = new AccelerateInterpolator();
    iN = new DecelerateInterpolator();
    if (Build.VERSION.SDK_INT >= 14) {}
    for (boolean bool = true;; bool = false)
    {
      adLL = bool;
      AppMethodBeat.o(141577);
      return;
    }
  }
  
  public d(Activity paramActivity, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(141538);
    this.iw = new ArrayList();
    this.ja = 0;
    this.jb = true;
    this.jf = true;
    this.jj = new af()
    {
      public final void f(View paramAnonymousView)
      {
        AppMethodBeat.i(141518);
        if ((d.a(d.this)) && (d.b(d.this) != null))
        {
          z.e(d.b(d.this), 0.0F);
          z.e(d.c(d.this), 0.0F);
        }
        d.c(d.this).setVisibility(8);
        d.c(d.this).setTransitioning(false);
        d.d(d.this);
        paramAnonymousView = d.this;
        if (paramAnonymousView.iY != null)
        {
          paramAnonymousView.iY.a(paramAnonymousView.iX);
          paramAnonymousView.iX = null;
          paramAnonymousView.iY = null;
        }
        AppMethodBeat.o(141518);
      }
    };
    this.jk = new af()
    {
      public final void f(View paramAnonymousView)
      {
        AppMethodBeat.i(141519);
        d.d(d.this);
        d.c(d.this).requestLayout();
        AppMethodBeat.o(141519);
      }
    };
    this.jl = new ag()
    {
      public final void cf()
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
      this.iq = paramActivity;
      this.iR = ((ActionBarContextView)paramViewGroup.findViewById(a.g.action_context_bar));
      this.iQ = ((ActionBarContainer)paramViewGroup.findViewById(a.g.action_bar_container));
      if ((this.iq != null) && (this.iR != null) && (this.iQ != null)) {
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
    this.mContext = this.iq.getContext();
    if ((this.iq.bu() & 0x4) != 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        this.iV = true;
      }
      androidx.appcompat.view.a.I(this.mContext).ct();
      paramActivity = this.mContext.obtainStyledAttributes(null, a.j.ActionBar, a.a.actionBarStyle, 0);
      paramActivity.getBoolean(a.j.ActionBar_hideOnContentScroll, false);
      i = paramActivity.getDimensionPixelSize(a.j.ActionBar_elevation, 0);
      if (i != 0) {
        g(i);
      }
      paramActivity.recycle();
      this.mContentView = null;
      AppMethodBeat.o(141538);
      return;
    }
  }
  
  private void E(boolean paramBoolean)
  {
    AppMethodBeat.i(141563);
    if (b(this.jc, this.jd, this.je))
    {
      if (!this.jf)
      {
        this.jf = true;
        F(paramBoolean);
        AppMethodBeat.o(141563);
      }
    }
    else if (this.jf)
    {
      this.jf = false;
      G(paramBoolean);
    }
    AppMethodBeat.o(141563);
  }
  
  private void F(boolean paramBoolean)
  {
    AppMethodBeat.i(141564);
    if (this.jg != null) {
      this.jg.cancel();
    }
    this.iQ.setVisibility(0);
    if ((this.ja == 0) && (adLL) && ((this.jh) || (paramBoolean)))
    {
      z.e(this.iQ, 0.0F);
      float f2 = -this.iQ.getHeight();
      float f1 = f2;
      if (paramBoolean)
      {
        localObject = new int[2];
        Object tmp83_81 = localObject;
        tmp83_81[0] = 0;
        Object tmp87_83 = tmp83_81;
        tmp87_83[1] = 0;
        tmp87_83;
        this.iQ.getLocationInWindow((int[])localObject);
        f1 = f2 - localObject[1];
      }
      z.e(this.iQ, f1);
      Object localObject = new androidx.appcompat.view.h();
      ad localad = z.ac(this.iQ).ap(0.0F);
      localad.a(this.jl);
      ((androidx.appcompat.view.h)localObject).a(localad);
      if ((this.jb) && (this.mContentView != null))
      {
        z.e(this.mContentView, f1);
        ((androidx.appcompat.view.h)localObject).a(z.ac(this.mContentView).ap(0.0F));
      }
      ((androidx.appcompat.view.h)localObject).b(iN);
      ((androidx.appcompat.view.h)localObject).cA();
      ((androidx.appcompat.view.h)localObject).a(this.jk);
      this.jg = ((androidx.appcompat.view.h)localObject);
      ((androidx.appcompat.view.h)localObject).start();
      AppMethodBeat.o(141564);
      return;
    }
    z.f(this.iQ, 1.0F);
    z.e(this.iQ, 0.0F);
    if ((this.jb) && (this.mContentView != null)) {
      z.e(this.mContentView, 0.0F);
    }
    this.jk.f(null);
    AppMethodBeat.o(141564);
  }
  
  private void G(boolean paramBoolean)
  {
    AppMethodBeat.i(141565);
    if (this.jg != null) {
      this.jg.cancel();
    }
    if ((this.ja == 0) && (adLL) && ((this.jh) || (paramBoolean)))
    {
      z.f(this.iQ, 1.0F);
      this.iQ.setTransitioning(true);
      androidx.appcompat.view.h localh = new androidx.appcompat.view.h();
      float f2 = -this.iQ.getHeight();
      float f1 = f2;
      if (paramBoolean)
      {
        localObject = new int[2];
        Object tmp92_90 = localObject;
        tmp92_90[0] = 0;
        Object tmp96_92 = tmp92_90;
        tmp96_92[1] = 0;
        tmp96_92;
        this.iQ.getLocationInWindow((int[])localObject);
        f1 = f2 - localObject[1];
      }
      Object localObject = z.ac(this.iQ).ap(f1);
      ((ad)localObject).a(this.jl);
      localh.a((ad)localObject);
      if ((this.jb) && (this.mContentView != null)) {
        localh.a(z.ac(this.mContentView).ap(f1));
      }
      localh.b(iM);
      localh.cA();
      localh.a(this.jj);
      this.jg = localh;
      localh.start();
      AppMethodBeat.o(141565);
      return;
    }
    this.jj.f(null);
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
  
  private void ca()
  {
    AppMethodBeat.i(141558);
    if (!this.je)
    {
      this.je = true;
      E(false);
    }
    AppMethodBeat.o(141558);
  }
  
  private void cc()
  {
    AppMethodBeat.i(141561);
    if (this.je)
    {
      this.je = false;
      E(false);
    }
    AppMethodBeat.o(141561);
  }
  
  private void k(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(141550);
    int i = this.iq.bu();
    if ((paramInt2 & 0x4) != 0) {
      this.iV = true;
    }
    this.iq.M(i & (paramInt2 ^ 0xFFFFFFFF) | paramInt1 & paramInt2);
    AppMethodBeat.o(141550);
  }
  
  public final void A(boolean paramBoolean)
  {
    AppMethodBeat.i(141541);
    this.jh = paramBoolean;
    if ((!paramBoolean) && (this.jg != null)) {
      this.jg.cancel();
    }
    AppMethodBeat.o(141541);
  }
  
  public final void B(boolean paramBoolean)
  {
    AppMethodBeat.i(141542);
    if (paramBoolean == this.iu)
    {
      AppMethodBeat.o(141542);
      return;
    }
    this.iu = paramBoolean;
    int j = this.iw.size();
    int i = 0;
    while (i < j)
    {
      this.iw.get(i);
      i += 1;
    }
    AppMethodBeat.o(141542);
  }
  
  public final void D(boolean paramBoolean)
  {
    this.jb = paramBoolean;
  }
  
  public final void H(boolean paramBoolean)
  {
    AppMethodBeat.i(141567);
    ad localad1;
    ad localad2;
    if (paramBoolean)
    {
      ca();
      if (!paramBoolean) {
        break label81;
      }
      localad1 = this.iq.b(8, 100L);
      localad2 = this.iR.b(0, 200L);
    }
    for (;;)
    {
      androidx.appcompat.view.h localh = new androidx.appcompat.view.h();
      localh.a(localad1, localad2);
      localh.start();
      AppMethodBeat.o(141567);
      return;
      cc();
      break;
      label81:
      localad2 = this.iq.b(0, 200L);
      localad1 = this.iR.b(8, 100L);
    }
  }
  
  public final void L(int paramInt)
  {
    AppMethodBeat.i(141543);
    setCustomView(LayoutInflater.from(bw()).inflate(paramInt, this.iq.eD(), false));
    AppMethodBeat.o(141543);
  }
  
  public final void M(int paramInt)
  {
    AppMethodBeat.i(141549);
    if ((paramInt & 0x4) != 0) {
      this.iV = true;
    }
    this.iq.M(paramInt);
    AppMethodBeat.o(141549);
  }
  
  public final b a(b.a parama)
  {
    AppMethodBeat.i(250159);
    if (this.adLM != null) {
      this.adLM.finish();
    }
    this.iR.dy();
    parama = new a(this.iR.getContext(), parama);
    if (parama.cg())
    {
      parama.invalidate();
      this.iR.c(parama);
      H(true);
      this.iR.sendAccessibilityEvent(32);
      this.adLM = parama;
      AppMethodBeat.o(250159);
      return parama;
    }
    AppMethodBeat.o(250159);
    return null;
  }
  
  public final void a(View paramView, ActionBar.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(250175);
    paramView.setLayoutParams(paramLayoutParams);
    this.iq.setCustomView(paramView);
    AppMethodBeat.o(250175);
  }
  
  public final int bu()
  {
    AppMethodBeat.i(141554);
    int i = this.iq.bu();
    AppMethodBeat.o(141554);
    return i;
  }
  
  public final Context bw()
  {
    AppMethodBeat.i(141568);
    Object localObject;
    int i;
    if (this.iO == null)
    {
      localObject = new TypedValue();
      this.mContext.getTheme().resolveAttribute(a.a.actionBarWidgetTheme, (TypedValue)localObject, true);
      i = ((TypedValue)localObject).resourceId;
      if (i == 0) {
        break label75;
      }
    }
    label75:
    for (this.iO = new ContextThemeWrapper(this.mContext, i);; this.iO = this.mContext)
    {
      localObject = this.iO;
      AppMethodBeat.o(141568);
      return localObject;
    }
  }
  
  public final void cb()
  {
    AppMethodBeat.i(141559);
    if (this.jd)
    {
      this.jd = false;
      E(true);
    }
    AppMethodBeat.o(141559);
  }
  
  public final void cd()
  {
    AppMethodBeat.i(141562);
    if (!this.jd)
    {
      this.jd = true;
      E(true);
    }
    AppMethodBeat.o(141562);
  }
  
  public final void ce()
  {
    AppMethodBeat.i(141570);
    if (this.jg != null)
    {
      this.jg.cancel();
      this.jg = null;
    }
    AppMethodBeat.o(141570);
  }
  
  public final boolean collapseActionView()
  {
    AppMethodBeat.i(141571);
    if ((this.iq != null) && (this.iq.eE()))
    {
      this.iq.eF();
      AppMethodBeat.o(141571);
      return true;
    }
    AppMethodBeat.o(141571);
    return false;
  }
  
  public final void g(float paramFloat)
  {
    AppMethodBeat.i(141539);
    z.k(this.iQ, paramFloat);
    AppMethodBeat.o(141539);
  }
  
  public final View getCustomView()
  {
    AppMethodBeat.i(141552);
    View localView = this.iq.getCustomView();
    AppMethodBeat.o(141552);
    return localView;
  }
  
  public final int getHeight()
  {
    AppMethodBeat.i(141556);
    int i = this.iQ.getHeight();
    AppMethodBeat.o(141556);
    return i;
  }
  
  public final CharSequence getTitle()
  {
    AppMethodBeat.i(141553);
    CharSequence localCharSequence = this.iq.getTitle();
    AppMethodBeat.o(141553);
    return localCharSequence;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(141560);
    if (!this.jc)
    {
      this.jc = true;
      E(false);
    }
    AppMethodBeat.o(141560);
  }
  
  public final boolean isShowing()
  {
    AppMethodBeat.i(141566);
    int i = this.iQ.getHeight();
    if ((this.jf) && ((i == 0) || (i > 0)))
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
    paramConfiguration = this.iq.eD().getLayoutParams();
    if (paramConfiguration != null) {
      paramConfiguration.height = com.tencent.mm.compatible.util.a.di(this.mActivity);
    }
    this.iq.eD().setLayoutParams(paramConfiguration);
    AppMethodBeat.o(141540);
  }
  
  public final void onWindowVisibilityChanged(int paramInt)
  {
    this.ja = paramInt;
  }
  
  public final void setBackgroundDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(141551);
    this.iQ.setPrimaryBackground(paramDrawable);
    AppMethodBeat.o(141551);
  }
  
  public final void setCustomView(View paramView)
  {
    AppMethodBeat.i(141572);
    this.iq.setCustomView(paramView);
    AppMethodBeat.o(141572);
  }
  
  public final void setHideOnContentScrollEnabled(boolean paramBoolean) {}
  
  public final void setIcon(int paramInt)
  {
    AppMethodBeat.i(250179);
    this.iq.setIcon(paramInt);
    AppMethodBeat.o(250179);
  }
  
  public final void setLogo(Drawable paramDrawable)
  {
    AppMethodBeat.i(141574);
    this.iq.setLogo(paramDrawable);
    AppMethodBeat.o(141574);
  }
  
  public final void setWindowTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(141548);
    this.iq.setWindowTitle(paramCharSequence);
    AppMethodBeat.o(141548);
  }
  
  public final void show()
  {
    AppMethodBeat.i(141557);
    if (this.jc)
    {
      this.jc = false;
      E(false);
    }
    AppMethodBeat.o(141557);
  }
  
  public final void v(boolean paramBoolean)
  {
    AppMethodBeat.i(250145);
    if (paramBoolean) {}
    for (int i = 2;; i = 0)
    {
      k(i, 2);
      AppMethodBeat.o(250145);
      return;
    }
  }
  
  public final void w(boolean paramBoolean)
  {
    AppMethodBeat.i(141545);
    if (paramBoolean) {}
    for (int i = 4;; i = 0)
    {
      k(i, 4);
      AppMethodBeat.o(141545);
      return;
    }
  }
  
  public final void x(boolean paramBoolean)
  {
    AppMethodBeat.i(250149);
    if (paramBoolean) {}
    for (int i = 8;; i = 0)
    {
      k(i, 8);
      AppMethodBeat.o(250149);
      return;
    }
  }
  
  public final void y(boolean paramBoolean)
  {
    AppMethodBeat.i(250153);
    if (paramBoolean) {}
    for (int i = 16;; i = 0)
    {
      k(i, 16);
      AppMethodBeat.o(250153);
      return;
    }
  }
  
  public final void z(boolean paramBoolean)
  {
    AppMethodBeat.i(141575);
    if (!this.iV) {
      w(paramBoolean);
    }
    AppMethodBeat.o(141575);
  }
  
  public final class a
    extends b
    implements h.a
  {
    private final Context jn;
    private final androidx.appcompat.view.menu.h jo;
    private b.a jp;
    private WeakReference<View> jq;
    
    public a(Context paramContext, b.a parama)
    {
      AppMethodBeat.i(250048);
      this.jn = paramContext;
      this.jp = parama;
      this$1 = new androidx.appcompat.view.menu.h(paramContext);
      d.this.nF = 1;
      this.jo = d.this;
      this.jo.a(this);
      AppMethodBeat.o(250048);
    }
    
    public final void a(androidx.appcompat.view.menu.h paramh)
    {
      AppMethodBeat.i(250114);
      if (this.jp == null)
      {
        AppMethodBeat.o(250114);
        return;
      }
      invalidate();
      d.g(d.this).dv();
      AppMethodBeat.o(250114);
    }
    
    public final boolean a(androidx.appcompat.view.menu.h paramh, MenuItem paramMenuItem)
    {
      AppMethodBeat.i(250111);
      if (this.jp != null)
      {
        boolean bool = this.jp.a(this, paramMenuItem);
        AppMethodBeat.o(250111);
        return bool;
      }
      AppMethodBeat.o(250111);
      return false;
    }
    
    public final boolean cg()
    {
      AppMethodBeat.i(141525);
      this.jo.cX();
      try
      {
        boolean bool = this.jp.a(this, this.jo);
        return bool;
      }
      finally
      {
        this.jo.cY();
        AppMethodBeat.o(141525);
      }
    }
    
    public final void finish()
    {
      AppMethodBeat.i(141523);
      if (d.this.adLM != this)
      {
        AppMethodBeat.o(141523);
        return;
      }
      if (!d.bL(d.e(d.this), d.f(d.this)))
      {
        d.this.iX = this;
        d.this.iY = this.jp;
      }
      for (;;)
      {
        this.jp = null;
        d.this.H(false);
        d.g(d.this).dx();
        d.h(d.this).eD().sendAccessibilityEvent(32);
        d.this.adLM = null;
        AppMethodBeat.o(141523);
        return;
        this.jp.a(this);
      }
    }
    
    public final View getCustomView()
    {
      AppMethodBeat.i(141535);
      if (this.jq != null)
      {
        View localView = (View)this.jq.get();
        AppMethodBeat.o(141535);
        return localView;
      }
      AppMethodBeat.o(141535);
      return null;
    }
    
    public final Menu getMenu()
    {
      return this.jo;
    }
    
    public final MenuInflater getMenuInflater()
    {
      AppMethodBeat.i(141522);
      g localg = new g(this.jn);
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
      if (d.this.adLM != this)
      {
        AppMethodBeat.o(141524);
        return;
      }
      this.jo.cX();
      try
      {
        this.jp.b(this, this.jo);
        return;
      }
      finally
      {
        this.jo.cY();
        AppMethodBeat.o(141524);
      }
    }
    
    public final boolean isTitleOptional()
    {
      AppMethodBeat.i(141534);
      boolean bool = d.g(d.this).pb;
      AppMethodBeat.o(141534);
      return bool;
    }
    
    public final void setCustomView(View paramView)
    {
      AppMethodBeat.i(141526);
      d.g(d.this).setCustomView(paramView);
      this.jq = new WeakReference(paramView);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.b.d
 * JD-Core Version:    0.7.0.1
 */
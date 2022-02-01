package com.tencent.mm.plugin.taskbar.ui;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.abt;
import com.tencent.mm.autogen.a.ls;
import com.tencent.mm.autogen.a.ls.a;
import com.tencent.mm.ce.j;
import com.tencent.mm.dynamicbackground.view.DynamicBackgroundGLSurfaceView;
import com.tencent.mm.dynamicbackground.view.GradientColorBackgroundView;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopContainerView;
import com.tencent.mm.plugin.multitask.ui.bg.DynamicBgContainer;
import com.tencent.mm.plugin.taskbar.api.GyroView;
import com.tencent.mm.plugin.taskbar.d.a;
import com.tencent.mm.plugin.taskbar.d.b;
import com.tencent.mm.plugin.taskbar.d.d;
import com.tencent.mm.plugin.taskbar.d.e;
import com.tencent.mm.plugin.taskbar.d.f;
import com.tencent.mm.plugin.taskbar.d.g;
import com.tencent.mm.plugin.textstatus.a.a.b;
import com.tencent.mm.plugin.textstatus.a.a.c;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.widget.imageview.WeImageView;

public class TaskBarContainer
  extends RelativeLayout
  implements View.OnTouchListener
{
  public boolean Gtm;
  private MMFragmentActivity PIA;
  private GyroView SRL;
  private a SRY;
  public TaskBarView SRZ;
  public DynamicBgContainer SSa;
  private GradientColorBackgroundView SSb;
  private Rect SSc;
  public LinearLayout SSd;
  ViewGroup SSe;
  public View SSf;
  private View SSg;
  private TextView SSh;
  private WeImageView SSi;
  private WeImageView SSj;
  private WeImageView SSk;
  private WeImageView SSl;
  private View SSm;
  private View SSn;
  private TaskBarBottomView SSo;
  AppBrandDesktopContainerView SSp;
  private boolean SSq;
  private int SSr;
  private int SSs;
  private boolean SSt;
  public Runnable SSu;
  public IListener SSv;
  private int bXQ;
  private int mViewHeight;
  private int mViewWidth;
  private View ugI;
  private int vpn;
  
  public TaskBarContainer(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(264458);
    this.SSc = new Rect();
    this.vpn = bf.getStatusBarHeight(getContext());
    this.SSq = true;
    this.mViewWidth = 0;
    this.mViewHeight = 0;
    this.SSr = 0;
    this.SSs = 0;
    this.bXQ = 0;
    this.Gtm = true;
    this.SSt = LocaleUtil.isChineseAppLang();
    this.SSu = null;
    this.SSv = new IListener(com.tencent.mm.app.f.hfK) {};
    init(paramContext);
    AppMethodBeat.o(264458);
  }
  
  public TaskBarContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(264464);
    this.SSc = new Rect();
    this.vpn = bf.getStatusBarHeight(getContext());
    this.SSq = true;
    this.mViewWidth = 0;
    this.mViewHeight = 0;
    this.SSr = 0;
    this.SSs = 0;
    this.bXQ = 0;
    this.Gtm = true;
    this.SSt = LocaleUtil.isChineseAppLang();
    this.SSu = null;
    this.SSv = new IListener(com.tencent.mm.app.f.hfK) {};
    init(paramContext);
    AppMethodBeat.o(264464);
  }
  
  public TaskBarContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(264473);
    this.SSc = new Rect();
    this.vpn = bf.getStatusBarHeight(getContext());
    this.SSq = true;
    this.mViewWidth = 0;
    this.mViewHeight = 0;
    this.SSr = 0;
    this.SSs = 0;
    this.bXQ = 0;
    this.Gtm = true;
    this.SSt = LocaleUtil.isChineseAppLang();
    this.SSu = null;
    this.SSv = new IListener(com.tencent.mm.app.f.hfK) {};
    init(paramContext);
    AppMethodBeat.o(264473);
  }
  
  private void hDp()
  {
    AppMethodBeat.i(264480);
    int i = getResources().getConfiguration().orientation;
    this.SSr = 0;
    AppMethodBeat.o(264480);
  }
  
  private void hDq()
  {
    AppMethodBeat.i(264506);
    Log.i("MicroMsg.AppBrandDesktopContainer", "alvinluo initViewScale measuredWidth: %d", new Object[] { Integer.valueOf(getMeasuredWidth()) });
    if (!this.Gtm)
    {
      AppMethodBeat.o(264506);
      return;
    }
    if (this.SSd != null)
    {
      this.SSd.setScaleX(0.6F);
      this.SSd.setScaleY(0.6F);
    }
    AppMethodBeat.o(264506);
  }
  
  private void hDr()
  {
    AppMethodBeat.i(264513);
    Object localObject;
    if ((this.SSh != null) && (this.ugI != null))
    {
      localObject = new int[2];
      this.ugI.getLocationOnScreen((int[])localObject);
      Log.i("MicroMsg.AppBrandDesktopContainer", "alvinluo updateFakeActionBarLeftMargin location x: %d, y: %d", new Object[] { Integer.valueOf(localObject[0]), Integer.valueOf(localObject[1]) });
      if (Build.VERSION.SDK_INT < 24) {
        break label163;
      }
    }
    label163:
    for (boolean bool = this.PIA.isInMultiWindowMode();; bool = false)
    {
      if (bool)
      {
        localObject = (LinearLayout.LayoutParams)this.SSh.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject).leftMargin = getResources().getDimensionPixelSize(d.b.BiggerPadding);
        Log.i("MicroMsg.AppBrandDesktopContainer", "alvinluo updateFakeActionBarLeftMargin leftMargin: %d", new Object[] { Integer.valueOf(((LinearLayout.LayoutParams)localObject).leftMargin) });
        if (this.SSh.getParent() != null) {
          this.SSh.getParent().requestLayout();
        }
        this.SSf.setVisibility(0);
      }
      AppMethodBeat.o(264513);
      return;
    }
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(264488);
    Log.i("MicroMsg.AppBrandDesktopContainer", "alvinluo HeaderContainer init");
    setImportantForAccessibility(2);
    this.bXQ = com.tencent.mm.cd.a.bs(paramContext, d.b.app_brand_desktop_close_area_extra);
    hDp();
    setBackgroundColor(getResources().getColor(d.a.transparent));
    com.tencent.mm.plugin.taskbar.ui.a.a locala = com.tencent.mm.plugin.taskbar.ui.a.a.STE;
    com.tencent.mm.plugin.taskbar.ui.a.a.hDY();
    kf(paramContext);
    AppMethodBeat.o(264488);
  }
  
  private void kf(Context paramContext)
  {
    AppMethodBeat.i(264501);
    View localView = LayoutInflater.from(paramContext).inflate(d.e.SPT, null);
    this.SSd = ((LinearLayout)localView.findViewById(d.d.app_brand_desktop_root_layout));
    ((FrameLayout.LayoutParams)this.SSd.getLayoutParams()).topMargin = this.vpn;
    this.SRL = ((GyroView)localView.findViewById(d.d.gyro_view));
    this.SSe = ((ViewGroup)localView.findViewById(d.d.SPH));
    this.SSp = ((AppBrandDesktopContainerView)localView.findViewById(d.d.SPI));
    FrameLayout localFrameLayout = (FrameLayout)localView.findViewById(d.d.SPG);
    this.SSf = LayoutInflater.from(paramContext).inflate(d.e.SPU, null);
    this.SSg = this.SSf.findViewById(d.d.container);
    localFrameLayout.addView(this.SSf, -1, -1);
    this.SSh = ((TextView)this.SSf.findViewById(16908308));
    this.SSi = ((WeImageView)this.SSf.findViewById(d.d.search_icon));
    this.SSj = ((WeImageView)this.SSf.findViewById(d.d.SPK));
    this.SSl = ((WeImageView)this.SSf.findViewById(d.d.home_title_icon));
    this.SSm = this.SSf.findViewById(d.d.SPM);
    this.SSn = this.SSf.findViewById(d.d.SPL);
    this.SSo = ((TaskBarBottomView)this.SSf.findViewById(d.d.SPF));
    this.SSk = ((WeImageView)this.SSf.findViewById(d.d.actionbar_up_indicator_btn));
    this.SSi.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(264054);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/taskbar/ui/TaskBarContainer$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if ((TaskBarContainer.a(TaskBarContainer.this) != null) && (TaskBarContainer.a(TaskBarContainer.this).glK())) {
          TaskBarContainer.a(TaskBarContainer.this).Eb(16);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/taskbar/ui/TaskBarContainer$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(264054);
      }
    });
    this.SSj.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(264055);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/taskbar/ui/TaskBarContainer$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if ((TaskBarContainer.a(TaskBarContainer.this) != null) && (TaskBarContainer.a(TaskBarContainer.this).glK())) {
          TaskBarContainer.a(TaskBarContainer.this).Eb(14);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/taskbar/ui/TaskBarContainer$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(264055);
      }
    });
    hDq();
    this.SRZ = ((TaskBarView)localView.findViewById(d.d.app_brand_desktop_view));
    this.SRZ.setHeaderContainer(this);
    this.SRZ.setId(d.d.app_brand_desktop_view);
    addView(localView, new RelativeLayout.LayoutParams(-1, -1));
    AppMethodBeat.o(264501);
  }
  
  private void setActionBarTitle(String paramString)
  {
    AppMethodBeat.i(264527);
    if (!h.baz())
    {
      AppMethodBeat.o(264527);
      return;
    }
    if (this.SSh != null)
    {
      paramString = p.d(getContext(), paramString, com.tencent.mm.cd.a.br(getContext(), d.b.BigTextSize));
      this.SSh.setText(paramString);
      float f = com.tencent.mm.cd.a.bs(getContext(), d.b.ActionBarTextSize) * com.tencent.mm.cd.a.jO(getContext());
      if (this.SSh.getTextSize() != f) {
        this.SSh.setTextSize(0, f);
      }
      aw.a(this.SSh.getPaint(), 0.8F);
      ((com.tencent.mm.plugin.textstatus.a.f)h.az(com.tencent.mm.plugin.textstatus.a.f.class)).setTextWithStatus(this.SSh, com.tencent.mm.plugin.auth.a.a.cUx(), a.b.ThJ, a.c.ThP);
    }
    AppMethodBeat.o(264527);
  }
  
  public final void Fj(boolean paramBoolean)
  {
    AppMethodBeat.i(264702);
    this.SRZ.Fl(paramBoolean);
    AppMethodBeat.o(264702);
  }
  
  public final void Fk(boolean paramBoolean)
  {
    AppMethodBeat.i(264731);
    if (this.SRZ != null)
    {
      TaskBarView localTaskBarView = this.SRZ;
      Log.i("MicroMsg.TaskBarView", "alvinluo notifyMultiWindowModeChanged: %b, old: %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(localTaskBarView.hRD) });
      if (localTaskBarView.hRD != paramBoolean) {
        localTaskBarView.hRD = paramBoolean;
      }
    }
    DynamicBgContainer.setIsInMultiWindowMode(paramBoolean);
    AppMethodBeat.o(264731);
  }
  
  public final void a(DynamicBgContainer paramDynamicBgContainer, GradientColorBackgroundView paramGradientColorBackgroundView)
  {
    AppMethodBeat.i(264673);
    this.SSa = paramDynamicBgContainer;
    this.SSb = paramGradientColorBackgroundView;
    if (this.SRY != null) {
      this.SRY.u(paramDynamicBgContainer, this.SSb);
    }
    AppMethodBeat.o(264673);
  }
  
  public final void aD(long paramLong, int paramInt)
  {
    AppMethodBeat.i(264655);
    if (this.SRY != null) {
      this.SRY.j(paramLong, paramInt, false);
    }
    AppMethodBeat.o(264655);
  }
  
  public final void aE(long paramLong, int paramInt)
  {
    AppMethodBeat.i(264661);
    if (this.SRY != null) {
      this.SRY.j(paramLong, paramInt, true);
    }
    AppMethodBeat.o(264661);
  }
  
  public final void anW(int paramInt)
  {
    AppMethodBeat.i(264621);
    if (this.vpn != paramInt)
    {
      this.vpn = paramInt;
      ((FrameLayout.LayoutParams)this.SSd.getLayoutParams()).topMargin = paramInt;
      Object localObject = this.SSp.uzB.getLayoutParams();
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        AppMethodBeat.o(264621);
        throw ((Throwable)localObject);
      }
      ((FrameLayout.LayoutParams)localObject).topMargin = paramInt;
    }
    AppMethodBeat.o(264621);
  }
  
  public final void anX(int paramInt)
  {
    AppMethodBeat.i(264713);
    if (this.SSo != null) {
      this.SSo.setDrawColor(paramInt);
    }
    AppMethodBeat.o(264713);
  }
  
  public int getAnimationScrollOffset()
  {
    return this.SRY.SRu;
  }
  
  public Rect getBackUpFooterRect()
  {
    return this.SSc;
  }
  
  public DynamicBgContainer getBackgroundGLSurfaceContainer()
  {
    return this.SSa;
  }
  
  public View getBackgroundGLSurfaceView()
  {
    AppMethodBeat.i(264690);
    DynamicBackgroundGLSurfaceView localDynamicBackgroundGLSurfaceView = this.SSa.getDynamicBgSurfaceView();
    AppMethodBeat.o(264690);
    return localDynamicBackgroundGLSurfaceView;
  }
  
  public View getBackgroundGradientView()
  {
    return this.SSb;
  }
  
  public AppBrandDesktopContainerView getDesktopContainerView()
  {
    return this.SSp;
  }
  
  public int getExtraBottomHeight()
  {
    return this.SSs;
  }
  
  public com.tencent.mm.plugin.appbrand.widget.e.a.a getHeaderView()
  {
    return null;
  }
  
  public LinearLayout getRootLayout()
  {
    return this.SSd;
  }
  
  public TaskBarView getTaskBarView()
  {
    return this.SRZ;
  }
  
  public int getViewHeight()
  {
    return this.mViewHeight;
  }
  
  public final void hDs()
  {
    AppMethodBeat.i(264648);
    if (this.PIA == null)
    {
      AppMethodBeat.o(264648);
      return;
    }
    Pair localPair = com.tencent.mm.plugin.taskbar.ui.c.b.by(this.PIA);
    ((FrameLayout.LayoutParams)this.SSg.getLayoutParams()).setMargins(((Integer)localPair.first).intValue(), 0, ((Integer)localPair.second).intValue(), 0);
    this.SSf.requestLayout();
    this.SSf.setVisibility(0);
    AppMethodBeat.o(264648);
  }
  
  public final boolean hDt()
  {
    AppMethodBeat.i(264652);
    if (this.SRY != null)
    {
      boolean bool = this.SRY.hDg();
      AppMethodBeat.o(264652);
      return bool;
    }
    AppMethodBeat.o(264652);
    return false;
  }
  
  public final void me(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(264719);
    if (this.SSh != null) {
      this.SSh.setTextColor(paramInt1);
    }
    if (this.SSi != null)
    {
      this.SSi.setImageResource(d.f.actionbar_icon_dark_search);
      this.SSi.setIconColor(paramInt2);
    }
    if (this.SSj != null)
    {
      this.SSj.setImageResource(d.f.icons_outlined_add2);
      this.SSj.setIconColor(paramInt2);
    }
    Object localObject;
    if (this.SSl != null)
    {
      localObject = this.SSl;
      if (!this.SRZ.SSB.epi) {
        break label162;
      }
    }
    label162:
    for (paramInt1 = 0;; paramInt1 = 8)
    {
      ((WeImageView)localObject).setVisibility(paramInt1);
      if (this.SSk == null) {
        break label176;
      }
      this.SSk.setIconColor(paramInt2);
      if (this.ugI == null) {
        break label176;
      }
      localObject = this.ugI.findViewById(d.d.actionbar_up_indicator_btn);
      if ((localObject != null) && (((View)localObject).getVisibility() == 0)) {
        break;
      }
      this.SSk.setVisibility(4);
      AppMethodBeat.o(264719);
      return;
    }
    this.SSk.setVisibility(0);
    label176:
    AppMethodBeat.o(264719);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(264605);
    super.onAttachedToWindow();
    Log.i("MicroMsg.AppBrandDesktopContainer", "alvinluo desktopContainer onAttachedToWindow");
    if (this.SSv != null) {
      this.SSv.alive();
    }
    ls localls = new ls();
    localls.publish();
    Log.i("MicroMsg.AppBrandDesktopContainer", "alvinluo updateUnReadCount unReadCount: %d", new Object[] { Integer.valueOf(localls.hNC.hND) });
    Object localObject2 = getContext().getResources().getString(d.g.app_name_separation);
    if (!com.tencent.mm.protocal.d.Yxk)
    {
      localObject1 = localObject2;
      if (!BuildInfo.IS_FLAVOR_BLUE) {}
    }
    else
    {
      if (!this.SSt) {
        break label221;
      }
    }
    label221:
    for (Object localObject1 = (String)localObject2 + j.mx(getContext());; localObject1 = (String)localObject2 + " " + j.mx(getContext()))
    {
      localObject2 = localObject1;
      if (localls.hNC.hND > 0)
      {
        localObject2 = localObject1;
        if (!this.SSt) {
          localObject2 = (String)localObject1 + " ";
        }
        localObject2 = (String)localObject2 + "(" + localls.hNC.hND + ")";
      }
      setActionBarTitle((String)localObject2);
      AppMethodBeat.o(264605);
      return;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(264611);
    super.onDetachedFromWindow();
    Log.i("MicroMsg.AppBrandDesktopContainer", "alvinluo desktopContainer onDetachedFromWindow");
    if (this.SSv != null) {
      this.SSv.dead();
    }
    AppMethodBeat.o(264611);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(264587);
    hDp();
    Log.v("MicroMsg.AppBrandDesktopContainer", "alvinluo onMeasure orientation: %d, closeHeight: %d, extraBottomHeight: %d", new Object[] { Integer.valueOf(getResources().getConfiguration().orientation), Integer.valueOf(this.SSr), Integer.valueOf(this.SSs) });
    if (this.SSq)
    {
      int i = ((ViewGroup)getParent()).getMeasuredHeight() - this.SSr - this.SSs - this.bXQ;
      paramInt2 = View.MeasureSpec.makeMeasureSpec(i, 1073741824);
      this.mViewHeight = i;
    }
    for (;;)
    {
      super.onMeasure(paramInt1, paramInt2);
      if (getMeasuredWidth() != this.mViewWidth)
      {
        Log.i("MicroMsg.AppBrandDesktopContainer", "alvinluo onMeasure width new: %d, old: %d", new Object[] { Integer.valueOf(getMeasuredWidth()), Integer.valueOf(this.mViewWidth) });
        this.mViewWidth = getMeasuredWidth();
        Log.i("MicroMsg.AppBrandDesktopContainer", "alvinluo initViewPivot getMeasuredWidth: %d", new Object[] { Integer.valueOf(getMeasuredWidth()) });
        this.SSd.setPivotX(getMeasuredWidth() / 2.0F);
        this.SSd.setPivotY(bf.fs(getContext()));
        hDq();
      }
      AppMethodBeat.o(264587);
      return;
      paramInt2 = View.MeasureSpec.makeMeasureSpec(0, 1073741824);
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(264637);
    if ((this.SRY != null) && ((paramMotionEvent.getAction() == 0) || (paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))) {
      this.SRY.onTouch(paramView, paramMotionEvent);
    }
    AppMethodBeat.o(264637);
    return false;
  }
  
  public void setActionBar(View paramView)
  {
    AppMethodBeat.i(264627);
    this.ugI = paramView;
    hDr();
    AppMethodBeat.o(264627);
  }
  
  public void setActivity(MMFragmentActivity paramMMFragmentActivity)
  {
    this.PIA = paramMMFragmentActivity;
  }
  
  public void setAnimController(a parama)
  {
    AppMethodBeat.i(264567);
    this.SRY = parama;
    if ((this.SRZ != null) && (this.SRY != null)) {
      this.SRY.a(this.SRZ);
    }
    AppMethodBeat.o(264567);
  }
  
  public void setDynamicBackgroundView(View paramView)
  {
    AppMethodBeat.i(264665);
    a((DynamicBgContainer)paramView, this.SSb);
    AppMethodBeat.o(264665);
  }
  
  public void setExtraBottomHeight(int paramInt)
  {
    this.SSs = paramInt;
  }
  
  public void setFixedHeight(boolean paramBoolean)
  {
    this.SSq = paramBoolean;
  }
  
  public void setFoldBanner(View paramView)
  {
    if (this.SRY != null) {
      this.SRY.SRa = paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.ui.TaskBarContainer
 * JD-Core Version:    0.7.0.1
 */
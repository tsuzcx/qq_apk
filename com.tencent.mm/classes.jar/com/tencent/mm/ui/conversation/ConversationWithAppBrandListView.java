package com.tencent.mm.ui.conversation;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Vibrator;
import android.support.v4.view.r;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.LayoutParams;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ListView.FixedViewInfo;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.l;
import com.tencent.mm.compatible.b.f;
import com.tencent.mm.h.a.ii;
import com.tencent.mm.h.a.jm;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.widget.header.GyroView;
import com.tencent.mm.plugin.appbrand.widget.header.HeaderContainer;
import com.tencent.mm.plugin.appbrand.widget.header.a.a;
import com.tencent.mm.plugin.appbrand.widget.header.a.a.a;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.e;
import com.tencent.mm.plugin.appbrand.widget.recentview.b;
import com.tencent.mm.plugin.appbrand.widget.recentview.d;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.aq;
import java.util.Iterator;
import java.util.LinkedList;

public class ConversationWithAppBrandListView
  extends ListView
  implements AbsListView.OnScrollListener, AppBrandRecentView.e
{
  private int agg = -1;
  private int agh;
  private int agi;
  boolean bNW;
  private boolean dBn = true;
  private boolean hasInit = false;
  private Vibrator hpm;
  private boolean hps = false;
  private View hrf;
  private b hrl;
  private float hsJ;
  private ValueAnimator jQ;
  private int jb;
  private float jeW;
  private float jeX;
  private AbsListView.OnScrollListener lMb;
  private LinkedList<ListView.FixedViewInfo> vQA = new LinkedList();
  private View vQP;
  Runnable vRA = null;
  c<jm> vRB = new ConversationWithAppBrandListView.1(this);
  private int vRC = 0;
  boolean vRD = false;
  final c<ii> vRE = new ConversationWithAppBrandListView.21(this);
  private ConversationWithAppBrandListView.a vRF = new ConversationWithAppBrandListView.a(this);
  private int vRG = 0;
  private float vRH;
  private float vRI;
  private float vRJ = 0.0F;
  private float vRK = 0.0F;
  private boolean vRL;
  private boolean vRM = false;
  boolean vRN;
  private boolean vRO = false;
  private boolean vRP = false;
  private Runnable vRQ;
  private Runnable vRR = new Runnable()
  {
    public final void run()
    {
      ConversationWithAppBrandListView.o(ConversationWithAppBrandListView.this);
      ConversationWithAppBrandListView.p(ConversationWithAppBrandListView.this);
      ConversationWithAppBrandListView.q(ConversationWithAppBrandListView.this);
    }
  };
  private boolean vRS = false;
  private boolean vRT = false;
  private int vRU;
  HeaderContainer vRj;
  View vRk;
  AppBrandRecentView vRl;
  private boolean vRm = false;
  private Paint vRn;
  private Paint vRo;
  private String vRp;
  private float vRq;
  public a vRr;
  private boolean vRs = false;
  private boolean vRt = false;
  private boolean vRu = false;
  private float vRv = 0.0F;
  private float vRw = 0.0F;
  private int vRx = 0;
  private Context vRy;
  private boolean vRz = false;
  
  public ConversationWithAppBrandListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.vRB.cqo();
  }
  
  private void HO(int paramInt)
  {
    y.i("MicroMsg.ConversationWithAppBrandListView", "[openAppBrandRecentView] isOpenAppBrandRecentView:%s isHeadsetPluged:%s", new Object[] { Boolean.valueOf(this.vRN), Boolean.valueOf(com.tencent.mm.model.au.Hy().yt()) });
    if (!this.vRN)
    {
      com.tencent.mm.sdk.platformtools.au.ak(getContext(), R.l.app_brand_recent_view_down_sound_path);
      if ((this.hrl != null) && (this.vRr != null))
      {
        b localb = this.hrl;
        int i = this.vRr.getRecentAppBrandCount();
        int j = this.vRr.getStarAppBrandCount();
        localb.hCa = (System.currentTimeMillis() / 1000L);
        localb.hCd = i;
        localb.hCm = j;
      }
      if (this.vRr != null) {
        this.vRr.arx();
      }
    }
    if ((this.vRD) && (this.vRl != null))
    {
      this.vRl.getAdapter().agL.notifyChanged();
      this.vRD = true;
    }
    super.smoothScrollToPositionFromTop(0, 0, paramInt);
    nD(true);
    setOpenAppBrandRecentView(true);
    if (this.vRr != null) {
      this.vRr.ary();
    }
  }
  
  private void HP(int paramInt)
  {
    y.i("MicroMsg.ConversationWithAppBrandListView", "[closeAppBrandRecentView] isOpenAppBrandRecentView:%s type:%s", new Object[] { Boolean.valueOf(this.vRN), Integer.valueOf(paramInt) });
    if ((this.vRN) && (getChildAt(0) != null) && (this.hrl != null) && (this.vRr != null))
    {
      this.hrl.A(this.vRr.getRecentAppBrandCount(), this.vRr.getStarAppBrandCount(), paramInt);
      this.vRr.mJ(paramInt);
    }
    View localView;
    if (getFirstVisiblePosition() == 0)
    {
      localView = getChildAt(0);
      if (localView != null) {
        break label158;
      }
    }
    label158:
    for (paramInt = 0;; paramInt = localView.getBottom())
    {
      if (paramInt != 0) {
        smoothScrollToPositionFromTop(getFirstHeaderVisible(), 0, 150);
      }
      cId();
      nD(true);
      setOpenAppBrandRecentView(false);
      ai.l(new ConversationWithAppBrandListView.9(this), 500L);
      return;
    }
  }
  
  private boolean K(MotionEvent paramMotionEvent)
  {
    int j = 0;
    if (!cIe()) {
      return false;
    }
    if (paramMotionEvent.getAction() == 0)
    {
      this.vRK = paramMotionEvent.getY();
      if (this.jQ != null) {
        this.jQ.cancel();
      }
    }
    float f3;
    try
    {
      if (((paramMotionEvent.getAction() != 2) || (Math.abs(paramMotionEvent.getY() - this.jeX) <= 2.0F) || (getFirstVisiblePosition() != 0) || (this.vRj.getTop() != 0)) && (getChildTranslationY() == 0.0F)) {
        break label551;
      }
      nD(true);
      if ((getHeight() - getTabViewHeight() - this.vRG) / 2 <= this.vRJ) {
        nE(false);
      }
      for (;;)
      {
        float f1 = paramMotionEvent.getY();
        float f2 = this.vRK;
        f3 = getHeight() - getTabViewHeight() - this.vRG;
        this.vRJ = ((f1 - f2) * 0.4F + this.vRJ);
        if (this.vRJ >= 0.0F) {
          break label463;
        }
        this.vRJ = 0.0F;
        cId();
        invalidate();
        return false;
        if (paramMotionEvent.getActionMasked() == 5)
        {
          this.vRK = paramMotionEvent.getY();
          break;
        }
        if (((paramMotionEvent.getAction() != 1) && (paramMotionEvent.getAction() != 3)) || (this.vRj.getTop() != 0) || (getChildTranslationY() == 0.0F)) {
          break;
        }
        nE(true);
        this.vRM = false;
        y.d("MicroMsg.ConversationWithAppBrandListView", "[animationChild] offset:%s delay:%s duration%s", new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(180) });
        if (!cIe()) {
          break;
        }
        if (this.jQ != null) {
          this.jQ.cancel();
        }
        this.jQ = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("deltaY", new float[] { getChildTranslationY() + 0.0F, 0.0F }), PropertyValuesHolder.ofFloat("headerDeltaY", new float[] { getHeaderY() + 0.0F, 0.0F }) });
        this.jQ.setDuration(180L);
        this.jQ.addUpdateListener(new ConversationWithAppBrandListView.10(this));
        this.jQ.addListener(new ConversationWithAppBrandListView.11(this));
        this.jQ.setStartDelay(0L);
        this.jQ.start();
        break;
        nE(true);
      }
      i = j;
    }
    finally
    {
      this.vRK = paramMotionEvent.getY();
    }
    label463:
    int i;
    if (f3 < this.vRJ)
    {
      this.vRJ = f3;
      i = j;
    }
    for (;;)
    {
      if (i < getChildCount())
      {
        if (i == 0) {
          getChildAt(i).setTranslationY(this.vRJ * 0.5F);
        } else {
          getChildAt(i).setTranslationY(this.vRJ);
        }
      }
      else
      {
        invalidate();
        this.vRK = paramMotionEvent.getY();
        return true;
        label551:
        this.vRK = paramMotionEvent.getY();
        return false;
      }
      i += 1;
    }
  }
  
  private void cIa()
  {
    boolean bool = false;
    int j = getFirstHeaderVisible();
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.vQP.getLayoutParams();
    int k = localLayoutParams.height;
    int i;
    float f1;
    if (getAdapter() == null)
    {
      i = 0;
      float f2 = HQ(i);
      if (f2 < 0.0F) {
        bool = true;
      }
      f1 = f2;
      if (f2 < getTabViewHeight()) {
        f1 = getTabViewHeight();
      }
      y.i("MicroMsg.ConversationWithAppBrandListView", "[checkEmptyFooter] isRealFull:" + bool + " extraHeight:" + f1);
      if (!bool) {
        break label163;
      }
      localLayoutParams.height = getTabViewHeight();
    }
    for (;;)
    {
      if (k != localLayoutParams.height)
      {
        this.vQP.setLayoutParams(localLayoutParams);
        if (!this.dBn) {
          super.setSelection(j);
        }
      }
      return;
      i = getAdapter().getCount();
      break;
      label163:
      localLayoutParams.height = ((int)f1);
      if (this.dBn) {
        post(new ConversationWithAppBrandListView.2(this));
      }
    }
  }
  
  private void cIb()
  {
    if ((this.vRk != null) && (this.vRr != null))
    {
      i = this.vRj.getMeasuredHeight();
      if ((i != 0) && (i != this.vRG)) {
        this.vRG = i;
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.vRv = (-(this.hsJ - getResources().getDimension(R.f.LargestPadding)));
        this.vRw = (-(this.hsJ - (this.vRG / 2 - getResources().getDimension(R.f.HugeTextSize))));
        if (this.vRu) {
          break;
        }
        if (this.vRk != null) {
          this.vRk.setTranslationY(this.vRv);
        }
        if (this.hrf != null) {
          this.hrf.setTranslationY(0.0F);
        }
        y.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo initAppBrandHeaderHeight AppBrandHeader appBrandHeight: %d, setTranslationY: %s", new Object[] { Integer.valueOf(this.vRG), Float.valueOf(this.vRv) });
      }
      return;
    }
    if (this.vRk != null) {
      this.vRk.setTranslationY(0.0F);
    }
    if (this.hrf != null) {
      this.hrf.setTranslationY(this.vRw);
    }
    y.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo initAppBrandHeaderHeight emptyView appBrandHeight: %d, setTranslationY: %s", new Object[] { Integer.valueOf(this.vRG), Float.valueOf(this.vRw) });
  }
  
  private void cIc()
  {
    if (this.vRz) {
      return;
    }
    if (g.r(d.class) != null)
    {
      this.vRj = ((d)g.r(d.class)).cF(this.vRy);
      this.vRz = true;
      this.vRj.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
      this.vRk = this.vRj.findViewById(R.h.appbrand_preview_layout);
      this.vRk.setVisibility(8);
      this.vRr = this.vRj.getHeaderView();
      this.vRr.setCollectionRefreshListener(new ConversationWithAppBrandListView.3(this));
      this.vRr.setUsageRefreshListener(new ConversationWithAppBrandListView.4(this));
      this.vRr.setIOnLaunchUIListener(new ConversationWithAppBrandListView.5(this));
      this.vRr.setOnEmptyViewListener(new a.a()
      {
        public final void dS(boolean paramAnonymousBoolean)
        {
          ConversationWithAppBrandListView.d(ConversationWithAppBrandListView.this, paramAnonymousBoolean);
          if (!ConversationWithAppBrandListView.f(ConversationWithAppBrandListView.this)) {}
          do
          {
            return;
            if ((ConversationWithAppBrandListView.g(ConversationWithAppBrandListView.this) != null) && (paramAnonymousBoolean)) {
              ConversationWithAppBrandListView.g(ConversationWithAppBrandListView.this).setTranslationY(0.0F);
            }
          } while ((ConversationWithAppBrandListView.h(ConversationWithAppBrandListView.this) == null) || (!paramAnonymousBoolean));
          ConversationWithAppBrandListView.h(ConversationWithAppBrandListView.this).setTranslationY(0.0F);
        }
      });
      this.vRr.setReporter(this.hrl);
      this.hrf = this.vRj.getEmptyView();
      this.vQA.remove(this.vRj);
      Object localObject = new ListView.FixedViewInfo(this);
      ((ListView.FixedViewInfo)localObject).view = this.vRj;
      ((ListView.FixedViewInfo)localObject).data = null;
      ((ListView.FixedViewInfo)localObject).isSelectable = true;
      this.vQA.addFirst(localObject);
      localObject = this.vQA.iterator();
      while (((Iterator)localObject).hasNext())
      {
        ListView.FixedViewInfo localFixedViewInfo = (ListView.FixedViewInfo)((Iterator)localObject).next();
        super.addHeaderView(localFixedViewInfo.view, localFixedViewInfo.data, localFixedViewInfo.isSelectable);
      }
    }
    y.e("MicroMsg.ConversationWithAppBrandListView", "alvinluo addAppBrandHalfView error");
    return;
    this.vRr.refresh();
  }
  
  private void cId()
  {
    int i = 0;
    while (i < getChildCount())
    {
      getChildAt(i).setTranslationY(0.0F);
      i += 1;
    }
    this.vRJ = 0.0F;
    invalidate();
  }
  
  private boolean cIe()
  {
    if (this.vRk != null) {
      return (nG(true)) && (this.vRk.getVisibility() == 0);
    }
    return false;
  }
  
  private float getChildTranslationY()
  {
    View localView = getChildAt(1);
    if (localView == null) {
      return 0.0F;
    }
    return localView.getTranslationY();
  }
  
  private View getEmptyFooter()
  {
    LinearLayout localLinearLayout = new LinearLayout(getContext());
    this.vQP = new View(getContext());
    this.vQP.setLayoutParams(new LinearLayout.LayoutParams(-1, 0));
    localLinearLayout.addView(this.vQP);
    localLinearLayout.setBackgroundColor(getContext().getResources().getColor(R.e.white));
    return localLinearLayout;
  }
  
  private float getHeaderY()
  {
    View localView = getChildAt(0);
    if (localView == null) {
      return 0.0F;
    }
    return localView.getTranslationY();
  }
  
  private int getTabViewHeight()
  {
    if (this.vRx == 0)
    {
      View localView = getRootView().findViewById(R.h.launcher_ui_bottom_tabview);
      if (localView != null)
      {
        y.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo initTabViewHeight tabView.getHeight: %d", new Object[] { Integer.valueOf(localView.getHeight()) });
        this.vRx = localView.getHeight();
      }
    }
    return this.vRx;
  }
  
  private void nD(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ai.S(this.vRF);
      return;
    }
    ai.S(this.vRF);
    ai.l(this.vRF, 1000L);
  }
  
  private void nE(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.vRQ != null))
    {
      ai.S(this.vRQ);
      this.vRQ = null;
      if (this.vRP) {
        nF(false);
      }
    }
    while ((paramBoolean) || (this.vRQ != null)) {
      return;
    }
    ConversationWithAppBrandListView.13 local13 = new ConversationWithAppBrandListView.13(this);
    this.vRQ = local13;
    ai.l(local13, 3000L);
  }
  
  private void nF(boolean paramBoolean)
  {
    y.i("MicroMsg.ConversationWithAppBrandListView", "[showTipWithAnim] isShow:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.vRP = true;
      localObject = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofInt("alpha", new int[] { 0, 77 }) });
      ((ValueAnimator)localObject).setDuration(200L);
      ((ValueAnimator)localObject).addUpdateListener(new ConversationWithAppBrandListView.14(this));
      ((ValueAnimator)localObject).start();
      if (this.hrl != null)
      {
        localObject = this.hrl;
        ((b)localObject).hCc += 1;
      }
      return;
    }
    Object localObject = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofInt("alpha", new int[] { 77, 0 }) });
    ((ValueAnimator)localObject).setDuration(200L);
    ((ValueAnimator)localObject).addUpdateListener(new ConversationWithAppBrandListView.15(this));
    ((ValueAnimator)localObject).addListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        ConversationWithAppBrandListView.n(ConversationWithAppBrandListView.this);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator) {}
    });
    ((ValueAnimator)localObject).start();
  }
  
  private void setEmptyViewVisible(boolean paramBoolean)
  {
    int j = 0;
    y.i("MicroMsg.ConversationWithAppBrandListView", "[setEmptyViewVisible] isShow:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    View localView;
    if (this.hrf != null)
    {
      localView = this.hrf;
      if (paramBoolean)
      {
        i = 0;
        localView.setVisibility(i);
      }
    }
    else if (this.vRk != null)
    {
      localView = this.vRk.findViewById(R.h.appbrand_preview_view);
      if (localView != null) {
        if (paramBoolean) {
          break label89;
        }
      }
    }
    label89:
    for (int i = j;; i = 4)
    {
      localView.setVisibility(i);
      return;
      i = 8;
      break;
    }
  }
  
  private void setOpenAppBrandRecentView(boolean paramBoolean)
  {
    this.vRN = paramBoolean;
  }
  
  public final void A(long paramLong, int paramInt)
  {
    y.i("MicroMsg.ConversationWithAppBrandListView", "[hideAppBrandRecentView] delay:%s, type: %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    if (!nG(true)) {
      if (this.vRk != null) {
        this.vRk.setVisibility(8);
      }
    }
    while (getFirstVisiblePosition() != 0) {
      return;
    }
    if ((this.hrl != null) && (this.vRr != null))
    {
      this.hrl.A(this.vRr.getRecentAppBrandCount(), this.vRr.getStarAppBrandCount(), paramInt);
      this.vRr.mJ(paramInt);
    }
    if (paramLong > 0L)
    {
      if (this.vRA != null) {
        removeCallbacks(this.vRA);
      }
      this.vRA = new ConversationWithAppBrandListView.25(this);
      postDelayed(this.vRA, paramLong);
    }
    for (;;)
    {
      cId();
      return;
      if (this.vRr != null) {
        this.vRr.arw();
      }
      if (this.vRl != null) {
        this.vRl.smoothScrollToPosition(0);
      }
      setSelection(0);
    }
  }
  
  final float HQ(int paramInt)
  {
    y.d("MicroMsg.ConversationWithAppBrandListView", "[isFull] totalItemCount:" + paramInt + " getFirstVisiblePosition:" + getFirstVisiblePosition() + " getLastVisiblePosition:" + getLastVisiblePosition() + " getHeaderViewsCount:" + getHeaderViewsCount() + " getFooterViewsCount:" + getFooterViewsCount());
    int i = (int)getResources().getDimension(R.f.NormalListHeight);
    paramInt = paramInt - getHeaderViewsCount() - getFooterViewsCount();
    float f = getMeasuredHeight() - i * paramInt;
    y.i("MicroMsg.ConversationWithAppBrandListView", "[isFull] height:%s rawCount:%s extraHeight:%s", new Object[] { Integer.valueOf(getHeight()), Integer.valueOf(paramInt), Float.valueOf(f) });
    return f;
  }
  
  public void addHeaderView(View paramView, Object paramObject, boolean paramBoolean)
  {
    ListView.FixedViewInfo localFixedViewInfo = new ListView.FixedViewInfo(this);
    localFixedViewInfo.view = paramView;
    localFixedViewInfo.data = paramObject;
    localFixedViewInfo.isSelectable = paramBoolean;
    this.vQA.add(localFixedViewInfo);
    if (getAdapter() != null) {
      super.addHeaderView(localFixedViewInfo.view, localFixedViewInfo.data, localFixedViewInfo.isSelectable);
    }
    y.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo addHeaderView %d", new Object[] { Integer.valueOf(this.vQA.size()) });
  }
  
  public boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if ((nG(true)) && (getFirstVisiblePosition() == 0) && (paramInt2 < 0))
    {
      paramArrayOfInt1[1] = ((int)(paramInt2 / 3.0F));
      super.dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2);
      return true;
    }
    return super.dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    try
    {
      if (paramMotionEvent.getAction() == 0)
      {
        float f = paramMotionEvent.getX();
        this.jeW = f;
        this.vRH = f;
        f = paramMotionEvent.getY();
        this.jeX = f;
        this.vRI = f;
      }
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      return bool;
    }
    finally
    {
      this.jeW = paramMotionEvent.getX();
      this.jeX = paramMotionEvent.getY();
    }
  }
  
  public int getFirstHeaderVisible()
  {
    Iterator localIterator = this.vQA.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject = (ListView.FixedViewInfo)localIterator.next();
      if (((ListView.FixedViewInfo)localObject).view == this.vRj)
      {
        i += 1;
      }
      else
      {
        if ((((ListView.FixedViewInfo)localObject).view != null) && ((((ListView.FixedViewInfo)localObject).view instanceof ViewGroup)))
        {
          localObject = ((ViewGroup)((ListView.FixedViewInfo)localObject).view).getChildAt(0);
          if ((localObject != null) && (((View)localObject).getVisibility() == 0))
          {
            y.i("MicroMsg.ConversationWithAppBrandListView", "[getFirstHeaderVisible] index:%s", new Object[] { Integer.valueOf(i) });
            return i;
          }
        }
        i += 1;
      }
    }
    y.i("MicroMsg.ConversationWithAppBrandListView", "[getFirstHeaderVisible] index:%s, size: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(this.vQA.size()) });
    return i;
  }
  
  public final void mH(int paramInt)
  {
    y.i("MicroMsg.ConversationWithAppBrandListView", "[next] size:%s isAppBrandHeaderEnable:%s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.vRm) });
    if (!nG(true))
    {
      y.w("MicroMsg.ConversationWithAppBrandListView", "[next] is disable!");
      if (this.vRk != null) {
        this.vRk.setVisibility(8);
      }
    }
    for (;;)
    {
      return;
      if ((paramInt == 1) && (this.vRk != null)) {
        setEmptyViewVisible(true);
      }
      while ((this.vRk != null) && (this.vRk.getVisibility() == 8))
      {
        this.vRk.setVisibility(0);
        setSelection(getFirstVisiblePosition());
        return;
        if ((paramInt > 1) && (this.vRk != null)) {
          setEmptyViewVisible(false);
        }
      }
    }
  }
  
  final void nC(boolean paramBoolean)
  {
    if ((this.vQP == null) || (!nG(true))) {
      return;
    }
    if (paramBoolean)
    {
      postDelayed(new ConversationWithAppBrandListView.26(this), 0L);
      return;
    }
    cIa();
  }
  
  final boolean nG(boolean paramBoolean)
  {
    if (((!this.hasInit) || (!paramBoolean)) && (g.r(d.class) != null))
    {
      g.r(d.class);
      this.vRm = true;
      y.i("MicroMsg.ConversationWithAppBrandListView", "[isAppBrandHeaderEnable] :%s", new Object[] { Boolean.valueOf(this.vRm) });
      this.hasInit = true;
    }
    return this.vRm;
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    y.i("MicroMsg.ConversationWithAppBrandListView", "[onConfigurationChanged] orientation:%s", new Object[] { Integer.valueOf(paramConfiguration.orientation) });
    this.vRD = true;
    nC(true);
    if (this.vRr != null) {
      this.vRr.a(paramConfiguration);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((getFirstVisiblePosition() == 0) && (this.vRj != null))
    {
      paramCanvas.drawRect(0.0F, 0.0F, getWidth(), this.vRj.getBottom() + this.vRJ, this.vRn);
      if (getChildAt(1) != null) {
        if ((getHeight() == 0) || (!this.vRP)) {
          break label138;
        }
      }
    }
    label138:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        float f1 = (getWidth() - this.vRq) / 2.0F;
        float f2 = this.vRj.getBottom();
        float f3 = this.vRJ;
        float f4 = getResources().getDimension(R.f.ListPadding);
        paramCanvas.drawText(this.vRp, f1, f2 + f3 - f4, this.vRo);
      }
      return;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    boolean bool1;
    if (getFirstVisiblePosition() != 0) {
      bool1 = super.onInterceptTouchEvent(paramMotionEvent);
    }
    do
    {
      return bool1;
      i = paramMotionEvent.getActionMasked();
      j = paramMotionEvent.getActionIndex();
      switch (i)
      {
      case 1: 
      case 3: 
      case 4: 
      default: 
        return super.onInterceptTouchEvent(paramMotionEvent);
      case 0: 
        this.agg = paramMotionEvent.getPointerId(0);
        this.agh = ((int)(paramMotionEvent.getX() + 0.5F));
        this.agi = ((int)(paramMotionEvent.getY() + 0.5F));
        return super.onInterceptTouchEvent(paramMotionEvent);
      case 5: 
        this.agg = paramMotionEvent.getPointerId(j);
        this.agh = ((int)(paramMotionEvent.getX(j) + 0.5F));
        this.agi = ((int)(paramMotionEvent.getY(j) + 0.5F));
        return super.onInterceptTouchEvent(paramMotionEvent);
      }
      j = paramMotionEvent.findPointerIndex(this.agg);
      bool1 = bool2;
    } while (j < 0);
    int i = (int)(paramMotionEvent.getX(j) + 0.5F);
    int k = (int)(paramMotionEvent.getY(j) + 0.5F);
    int j = this.agh;
    k -= this.agi;
    if ((Math.abs(k) > this.jb) && (Math.abs(k) >= Math.abs(i - j))) {}
    for (i = 1;; i = 0)
    {
      bool1 = bool2;
      if (i == 0) {
        break;
      }
      bool1 = bool2;
      if (!super.onInterceptTouchEvent(paramMotionEvent)) {
        break;
      }
      return true;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramBoolean) && (nG(true)))
    {
      if (!this.dBn) {
        break label60;
      }
      nC(true);
      post(new ConversationWithAppBrandListView.20(this));
      this.vRC = paramInt4;
      this.dBn = false;
    }
    label60:
    while ((this.bNW) || (this.vRC == paramInt4)) {
      return;
    }
    y.i("MicroMsg.ConversationWithAppBrandListView", "[onLayout] mLastBottom:" + this.vRC + " b:" + paramInt4);
    nC(true);
    this.vRC = paramInt4;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    cIb();
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.lMb != null) {
      this.lMb.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
    if (!nG(true)) {}
    View localView;
    do
    {
      do
      {
        return;
        cIb();
      } while (this.vRG == 0);
      y.v("MicroMsg.ConversationWithAppBrandListView", "alvinluo onScroll firstVisibleItem: %d, visibleItemCount: %d, totalItemCount: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      if (paramInt1 != 0) {
        break label746;
      }
      nD(false);
      paramAbsListView = paramAbsListView.getChildAt(0);
      if ((paramAbsListView == null) || (!(paramAbsListView instanceof HeaderContainer))) {
        break;
      }
      localView = paramAbsListView.findViewById(R.h.appbrand_preview_layout);
    } while ((localView == null) || (localView.getVisibility() == 8));
    GyroView localGyroView = ((HeaderContainer)paramAbsListView).getGyroView();
    y.v("MicroMsg.ConversationWithAppBrandListView", "alvinluo appBrandHeaderTransH: %s, emptyTransH: %s, headerParent.bottom: %s, translationY: %f, mAppBrandHeight: %d", new Object[] { Float.valueOf(this.vRv), Float.valueOf(this.vRw), Integer.valueOf(paramAbsListView.getBottom()), Float.valueOf(localView.getTranslationY()), Integer.valueOf(this.vRG) });
    if (paramAbsListView.getBottom() <= 3)
    {
      if (!this.vRu)
      {
        localView.setTranslationY(this.vRv);
        if (localGyroView.getVisibility() == 0)
        {
          localGyroView.setVerticalScroll(0.0F);
          localGyroView.setVisibility(8);
        }
        this.vRT = false;
      }
    }
    else
    {
      if ((paramAbsListView.getBottom() <= 3) || (paramAbsListView.getBottom() > this.hsJ) || ((localView.getTranslationY() == 0.0F) && ((this.hrf == null) || (this.hrf.getTranslationY() == 0.0F)))) {
        break label450;
      }
      if (localGyroView.getVisibility() == 8) {
        localGyroView.setVisibility(0);
      }
      localGyroView.setAlpha(1.0F);
      localGyroView.setTranslationY(-paramAbsListView.getBottom() / 2 + localGyroView.getHeight() / 2);
      localGyroView.setVerticalScroll(paramAbsListView.getBottom());
    }
    label450:
    label840:
    for (;;)
    {
      this.vRU = paramInt1;
      if ((this.vRS) && (this.hps) && (paramInt1 == 0))
      {
        y.e("MicroMsg.ConversationWithAppBrandListView", "[Stop fling!]");
        smoothScrollBy(0, 0);
        post(new ConversationWithAppBrandListView.19(this));
        this.vRS = false;
      }
      ai.S(this.vRR);
      ai.l(this.vRR, 50L);
      return;
      if (this.hrf != null) {
        this.hrf.setTranslationY(this.vRw);
      }
      localView.setTranslationY(0.0F);
      break;
      if ((paramAbsListView.getBottom() > this.hsJ) && ((localView.getTranslationY() != 0.0F) || ((this.hrf != null) && (this.hrf.getTranslationY() != 0.0F))))
      {
        float f = (float)(1.0D * (paramAbsListView.getBottom() - this.hsJ) / (this.vRG - this.hsJ));
        y.v("MicroMsg.ConversationWithAppBrandListView", "alvinluo checkUpAppBrandHeader appbrandHeader translationY: %f, percent: %f, setTranslationY: %f", new Object[] { Float.valueOf(localView.getTranslationY()), Float.valueOf(f), Float.valueOf(this.vRv * (1.0F - f)) });
        if (!this.vRu) {
          localView.setTranslationY(this.vRv * (1.0F - f));
        }
        for (;;)
        {
          localGyroView.setTranslationY(-this.hsJ / 2.0F + localGyroView.getHeight() / 2 + (this.hsJ / 2.0F + localGyroView.getHeight()) * f);
          localGyroView.setAlpha(1.0F - 2.0F * f);
          if ((!this.vRT) && (1.0F != f))
          {
            this.hpm.vibrate(10L);
            this.vRT = true;
          }
          nD(true);
          break;
          if (this.hrf != null)
          {
            y.v("MicroMsg.ConversationWithAppBrandListView", "alvinluo emptyView translationY: %f, set: %f", new Object[] { Float.valueOf(this.hrf.getTranslationY()), Float.valueOf(-this.vRw * (1.0F - f)) });
            this.hrf.setTranslationY(this.vRw * (1.0F - f));
          }
          localView.setTranslationY(0.0F);
        }
        label746:
        if (this.vRj != null)
        {
          paramAbsListView = this.vRj.findViewById(R.h.appbrand_preview_layout);
          if (this.vRu) {
            break label812;
          }
          if (paramAbsListView != null) {
            paramAbsListView.setTranslationY(this.vRv);
          }
        }
        for (;;)
        {
          if ((this.vRU != 0) || (paramInt1 == 0)) {
            break label840;
          }
          HP(4);
          nE(true);
          nD(true);
          break;
          if (this.hrf != null) {
            this.hrf.setTranslationY(this.vRw);
          }
          if (paramAbsListView != null) {
            paramAbsListView.setTranslationY(0.0F);
          }
        }
      }
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (this.lMb != null) {
      this.lMb.onScrollStateChanged(paramAbsListView, paramInt);
    }
    if ((getFirstVisiblePosition() != 0) && (paramInt == 2) && (!this.vRO)) {
      this.hps = true;
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    boolean bool1;
    if (!nG(true)) {
      bool1 = super.onTouchEvent(paramMotionEvent);
    }
    label364:
    do
    {
      return bool1;
      if (paramMotionEvent.getAction() == 0) {
        if (getFirstVisiblePosition() != 0) {
          this.vRS = true;
        }
      }
      for (;;)
      {
        if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
        {
          nD(true);
          this.vRL = false;
          if (getChildTranslationY() > 0.0F) {
            HO(250);
          }
        }
        if (K(paramMotionEvent)) {
          break label364;
        }
        if ((this.vRL) && (paramMotionEvent.getAction() == 2))
        {
          paramMotionEvent.setAction(0);
          super.onTouchEvent(paramMotionEvent);
          paramMotionEvent.setAction(2);
          this.vRL = false;
        }
        return super.onTouchEvent(paramMotionEvent);
        if (((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3)) && (getFirstVisiblePosition() == 0))
        {
          View localView = getChildAt(0);
          bool1 = bool2;
          if (localView == null) {
            break;
          }
          if ((Math.abs(paramMotionEvent.getX() - this.jeW) < 3.0F) && (Math.abs(paramMotionEvent.getY() - this.jeX) < 3.0F)) {
            super.onTouchEvent(paramMotionEvent);
          }
          if (getChildTranslationY() < 60.0F * getResources().getDisplayMetrics().density)
          {
            float f1 = Math.abs(paramMotionEvent.getX() - this.vRH);
            float f2 = Math.abs(paramMotionEvent.getY() - this.vRI);
            if (((paramMotionEvent.getY() - this.vRI < -5.0F) && (f1 - f2 < 0.0F) && (getFirstVisiblePosition() == 0)) || ((localView.getBottom() > 0) && (localView.getBottom() < this.hsJ))) {
              HP(4);
            } else if ((localView.getBottom() >= this.hsJ) && (paramMotionEvent.getY() - this.vRI > 5.0F)) {
              HO(250);
            }
          }
        }
      }
      if (paramMotionEvent.getAction() == 0)
      {
        super.onTouchEvent(paramMotionEvent);
        return true;
      }
      if ((paramMotionEvent.getAction() == 2) && (!this.vRL) && (Math.abs(paramMotionEvent.getY() - this.jeX) > 2.0F))
      {
        paramMotionEvent.setAction(3);
        super.onTouchEvent(paramMotionEvent);
        this.vRL = true;
        return true;
      }
      bool1 = bool2;
    } while (this.vRL);
    super.onTouchEvent(paramMotionEvent);
    return true;
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    y.i("MicroMsg.ConversationWithAppBrandListView", "[init] ");
    this.vRE.cqo();
    this.hpm = ((Vibrator)getContext().getSystemService("vibrator"));
    this.jb = r.a(ViewConfiguration.get(getContext()));
    this.vRn = new Paint(1);
    this.vRo = new Paint(1);
    this.vRn.setColor(getResources().getColor(R.e.app_brand_desktop_default_bg));
    this.vRo.setColor(-2130706433);
    this.vRo.setTextSize(getResources().getDimension(R.f.SmallestTextSize));
    nG(false);
    if (g.r(d.class) != null) {
      this.hrl = ((d)g.r(d.class)).aqW();
    }
    this.hsJ = (100.0F * getResources().getDisplayMetrics().density);
    y.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo init mAnimationPadding: %f, density: %f", new Object[] { Float.valueOf(this.hsJ), Float.valueOf(getResources().getDisplayMetrics().density) });
    this.vRp = getResources().getString(R.l.conversation_app_brand_recentview_tip);
    this.vRq = this.vRo.measureText(this.vRp);
    super.setOnScrollListener(this);
    paramListAdapter.registerDataSetObserver(new ConversationWithAppBrandListView.12(this, paramListAdapter));
    try
    {
      ((RelativeLayout.LayoutParams)getLayoutParams()).topMargin = aq.cD(getContext());
      if (this.vRy != null) {
        cIc();
      }
      addFooterView(getEmptyFooter());
      super.setAdapter(paramListAdapter);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.ConversationWithAppBrandListView", localException, "alvinluo initLayoutParams exception", new Object[0]);
      }
    }
  }
  
  public void setContext(Context paramContext)
  {
    this.vRy = paramContext;
    cIc();
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    super.setOnItemClickListener(new ConversationWithAppBrandListView.22(this, paramOnItemClickListener));
  }
  
  public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener paramOnItemLongClickListener)
  {
    super.setOnItemLongClickListener(new ConversationWithAppBrandListView.23(this, paramOnItemLongClickListener));
  }
  
  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.lMb = paramOnScrollListener;
  }
  
  public void setSelection(int paramInt)
  {
    y.i("MicroMsg.ConversationWithAppBrandListView", "[setSelection] position:%s", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt == 0) && (nG(true)))
    {
      paramInt = getFirstHeaderVisible();
      y.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo setSelection pos: %d, appbrandHeight: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.vRG) });
      super.setSelection(paramInt);
      if ((this.hrl != null) && (this.vRr != null))
      {
        this.hrl.A(this.vRr.getRecentAppBrandCount(), this.vRr.getStarAppBrandCount(), 7);
        this.vRr.mJ(7);
      }
      return;
    }
    super.setSelection(paramInt);
  }
  
  public void smoothScrollToPosition(int paramInt)
  {
    y.i("MicroMsg.ConversationWithAppBrandListView", "[smoothScrollToPosition] position:%s", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt == 0) && (nG(true)))
    {
      super.smoothScrollToPosition(getFirstHeaderVisible());
      return;
    }
    super.smoothScrollToPosition(paramInt);
  }
  
  public void smoothScrollToPositionFromTop(int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.ConversationWithAppBrandListView", "[smoothScrollToPositionFromTop] position:%s offset:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    int i = paramInt1;
    if (paramInt1 == 0)
    {
      i = paramInt1;
      if (nG(true)) {
        i = getFirstHeaderVisible();
      }
    }
    ai.l(new ConversationWithAppBrandListView.8(this, i, paramInt2), 100L);
  }
  
  public void smoothScrollToPositionFromTop(int paramInt1, int paramInt2, int paramInt3)
  {
    y.i("MicroMsg.ConversationWithAppBrandListView", "[smoothScrollToPositionFromTop] position:%s offset:%s duration:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt1 == 0) && (nG(true)))
    {
      super.smoothScrollToPositionFromTop(getFirstHeaderVisible(), paramInt2, paramInt3);
      return;
    }
    super.smoothScrollToPositionFromTop(paramInt1, paramInt2, paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.ConversationWithAppBrandListView
 * JD-Core Version:    0.7.0.1
 */
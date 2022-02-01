package com.tencent.mm.ui.conversation;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Vibrator;
import android.support.v4.view.u;
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
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ListView.FixedViewInfo;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.jn;
import com.tencent.mm.g.a.ky;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.widget.header.GyroView;
import com.tencent.mm.plugin.appbrand.widget.header.HeaderContainer;
import com.tencent.mm.plugin.appbrand.widget.header.a.a.a;
import com.tencent.mm.plugin.appbrand.widget.header.a.a.b;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.e;
import com.tencent.mm.plugin.appbrand.widget.recentview.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ap;
import java.util.Iterator;
import java.util.LinkedList;

public class ConversationWithAppBrandListView
  extends ListView
  implements AbsListView.OnScrollListener, AppBrandRecentView.e
{
  private View DR;
  private LinkedList<ListView.FixedViewInfo> HbM;
  private Paint HcA;
  private String HcB;
  private float HcC;
  private com.tencent.mm.plugin.appbrand.widget.header.a.a HcD;
  private boolean HcE;
  private boolean HcF;
  private boolean HcG;
  private float HcH;
  private float HcI;
  private int HcJ;
  private boolean HcK;
  private com.tencent.mm.plugin.appbrand.widget.header.a HcL;
  private Runnable HcM;
  private boolean HcN;
  private float HcO;
  private com.tencent.mm.plugin.appbrand.widget.header.b HcP;
  private com.tencent.mm.plugin.appbrand.widget.header.b HcQ;
  private com.tencent.mm.plugin.appbrand.widget.header.b HcR;
  private com.tencent.mm.sdk.b.c<ky> HcS;
  private int HcT;
  boolean HcU;
  private final com.tencent.mm.sdk.b.c<jn> HcV;
  private a HcW;
  private int HcX;
  private float HcY;
  private float HcZ;
  private View Hcq;
  private HeaderContainer Hcw;
  private View Hcx;
  private AppBrandRecentView Hcy;
  private boolean Hcz;
  private boolean Hda;
  private boolean Hdb;
  private boolean Hdc;
  private boolean Hdd;
  private boolean Hde;
  private Runnable Hdf;
  private Runnable Hdg;
  private boolean Hdh;
  private boolean Hdi;
  private int Hdj;
  private int apF;
  private int apG;
  private int apH;
  private ValueAnimator cHw;
  private boolean csX;
  private boolean dkt;
  private boolean hasInit;
  private Paint lEk;
  private Vibrator lRO;
  private boolean lSE;
  private GyroView lSL;
  private MMFragmentActivity lTx;
  private float lVc;
  private com.tencent.mm.plugin.appbrand.widget.recentview.b lWJ;
  private float lZZ;
  private int mTouchSlop;
  private float oEd;
  private float oEe;
  private AbsListView.OnScrollListener sZi;
  private float vLY;
  
  public ConversationWithAppBrandListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(38422);
    this.HbM = new LinkedList();
    this.Hcz = false;
    this.HcE = false;
    this.HcF = false;
    this.HcG = false;
    this.HcH = 0.0F;
    this.HcI = 0.0F;
    this.HcJ = 0;
    this.HcK = false;
    this.HcM = null;
    this.HcN = true;
    this.HcO = 0.0F;
    this.HcP = null;
    this.HcQ = null;
    this.HcR = null;
    this.HcS = new ConversationWithAppBrandListView.1(this);
    this.csX = true;
    this.HcT = 0;
    this.HcU = false;
    this.apF = -1;
    this.HcV = new com.tencent.mm.sdk.b.c() {};
    this.HcW = new a();
    this.HcX = 0;
    this.HcY = 0.0F;
    this.HcZ = 0.0F;
    this.Hdb = false;
    this.Hdd = false;
    this.Hde = false;
    this.Hdg = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(38413);
        ConversationWithAppBrandListView.o(ConversationWithAppBrandListView.this);
        ConversationWithAppBrandListView.p(ConversationWithAppBrandListView.this);
        ConversationWithAppBrandListView.q(ConversationWithAppBrandListView.this);
        AppMethodBeat.o(38413);
      }
    };
    this.lSE = false;
    this.Hdh = false;
    this.Hdi = false;
    this.hasInit = false;
    this.HcP = new com.tencent.mm.plugin.appbrand.widget.header.b(ao.aD(getContext(), 2130968577), getContext().getResources().getColor(2131099928));
    this.HcS.alive();
    AppMethodBeat.o(38422);
  }
  
  private void ZJ(int paramInt)
  {
    AppMethodBeat.i(38453);
    ad.i("MicroMsg.ConversationWithAppBrandListView", "[closeAppBrandRecentView] isOpenAppBrandRecentView:%s type:%s", new Object[] { Boolean.valueOf(this.Hdc), Integer.valueOf(paramInt) });
    if ((this.Hdc) && (getChildAt(0) != null) && (this.lWJ != null) && (this.HcD != null))
    {
      this.lWJ.N(this.HcD.getRecentAppBrandCount(), this.HcD.getStarAppBrandCount(), paramInt);
      this.HcD.uM(paramInt);
    }
    View localView;
    if (getFirstVisiblePosition() == 0)
    {
      localView = getChildAt(0);
      if (localView != null) {
        break label171;
      }
    }
    label171:
    for (paramInt = 0;; paramInt = localView.getBottom())
    {
      if (paramInt != 0) {
        smoothScrollToPositionFromTop(getFirstHeaderVisible(), 0, 150);
      }
      fco();
      wy(true);
      setOpenAppBrandRecentView(false);
      aq.n(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(38404);
          if (ConversationWithAppBrandListView.c(ConversationWithAppBrandListView.this) != null)
          {
            ad.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo scrollToFirstPage");
            ConversationWithAppBrandListView.c(ConversationWithAppBrandListView.this).bsp();
          }
          AppMethodBeat.o(38404);
        }
      }, 500L);
      AppMethodBeat.o(38453);
      return;
    }
  }
  
  private float ZK(int paramInt)
  {
    AppMethodBeat.i(38464);
    ad.d("MicroMsg.ConversationWithAppBrandListView", "[isFull] totalItemCount:" + paramInt + " getFirstVisiblePosition:" + getFirstVisiblePosition() + " getLastVisiblePosition:" + getLastVisiblePosition() + " getHeaderViewsCount:" + getHeaderViewsCount() + " getFooterViewsCount:" + getFooterViewsCount());
    int i = (int)getResources().getDimension(2131165515);
    paramInt = paramInt - getHeaderViewsCount() - getFooterViewsCount();
    float f = getMeasuredHeight() - i * paramInt;
    ad.i("MicroMsg.ConversationWithAppBrandListView", "[isFull] height:%s rawCount:%s extraHeight:%s", new Object[] { Integer.valueOf(getHeight()), Integer.valueOf(paramInt), Float.valueOf(f) });
    AppMethodBeat.o(38464);
    return f;
  }
  
  private boolean ac(MotionEvent paramMotionEvent)
  {
    int j = 0;
    AppMethodBeat.i(38450);
    if (!fcq())
    {
      AppMethodBeat.o(38450);
      return false;
    }
    if (paramMotionEvent.getAction() == 0)
    {
      this.HcZ = paramMotionEvent.getY();
      if (this.cHw != null) {
        this.cHw.cancel();
      }
    }
    float f3;
    try
    {
      if (((paramMotionEvent.getAction() != 2) || (Math.abs(paramMotionEvent.getY() - this.oEe) <= 2.0F) || (getFirstVisiblePosition() != 0) || (this.Hcw.getTop() != 0)) && (getChildTranslationY() == 0.0F)) {
        break label582;
      }
      wy(true);
      if ((getHeight() - getTabViewHeight() - this.HcX) / 2 <= this.HcY) {
        wz(false);
      }
      for (;;)
      {
        float f1 = paramMotionEvent.getY();
        float f2 = this.HcZ;
        f3 = getHeight() - getTabViewHeight() - this.HcX;
        this.HcY = ((f1 - f2) * 0.4F + this.HcY);
        if (this.HcY >= 0.0F) {
          break label488;
        }
        this.HcY = 0.0F;
        fco();
        invalidate();
        return false;
        if (paramMotionEvent.getActionMasked() == 5)
        {
          this.HcZ = paramMotionEvent.getY();
          break;
        }
        if (((paramMotionEvent.getAction() != 1) && (paramMotionEvent.getAction() != 3)) || (this.Hcw.getTop() != 0) || (getChildTranslationY() == 0.0F)) {
          break;
        }
        wz(true);
        this.Hdb = false;
        ad.d("MicroMsg.ConversationWithAppBrandListView", "[animationChild] offset:%s delay:%s duration%s", new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(180) });
        if (!fcq()) {
          break;
        }
        if (this.cHw != null) {
          this.cHw.cancel();
        }
        this.cHw = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("deltaY", new float[] { getChildTranslationY() + 0.0F, 0.0F }), PropertyValuesHolder.ofFloat("headerDeltaY", new float[] { getHeaderY() + 0.0F, 0.0F }) });
        this.cHw.setDuration(180L);
        this.cHw.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
          public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
          {
            AppMethodBeat.i(38405);
            float f1 = ((Float)paramAnonymousValueAnimator.getAnimatedValue("deltaY")).floatValue();
            float f2 = ((Float)paramAnonymousValueAnimator.getAnimatedValue("headerDeltaY")).floatValue();
            int i = 0;
            if (i < ConversationWithAppBrandListView.this.getChildCount())
            {
              if (i == 0) {
                ConversationWithAppBrandListView.this.getChildAt(i).setTranslationY(f2);
              }
              for (;;)
              {
                ConversationWithAppBrandListView.a(ConversationWithAppBrandListView.this, f1);
                i += 1;
                break;
                ConversationWithAppBrandListView.this.getChildAt(i).setTranslationY(f1);
              }
            }
            ConversationWithAppBrandListView.this.invalidate();
            AppMethodBeat.o(38405);
          }
        });
        this.cHw.addListener(new Animator.AnimatorListener()
        {
          public final void onAnimationCancel(Animator paramAnonymousAnimator)
          {
            AppMethodBeat.i(38408);
            ConversationWithAppBrandListView.k(ConversationWithAppBrandListView.this);
            AppMethodBeat.o(38408);
          }
          
          public final void onAnimationEnd(Animator paramAnonymousAnimator)
          {
            AppMethodBeat.i(38407);
            ConversationWithAppBrandListView.k(ConversationWithAppBrandListView.this);
            AppMethodBeat.o(38407);
          }
          
          public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
          
          public final void onAnimationStart(Animator paramAnonymousAnimator) {}
        });
        this.cHw.setStartDelay(0L);
        this.cHw.start();
        break;
        wz(true);
      }
      i = j;
    }
    finally
    {
      this.HcZ = paramMotionEvent.getY();
      AppMethodBeat.o(38450);
    }
    label488:
    int i;
    if (f3 < this.HcY)
    {
      this.HcY = f3;
      i = j;
    }
    for (;;)
    {
      if (i < getChildCount())
      {
        if (i == 0) {
          getChildAt(i).setTranslationY(this.HcY * 0.5F);
        } else {
          getChildAt(i).setTranslationY(this.HcY);
        }
      }
      else
      {
        invalidate();
        this.HcZ = paramMotionEvent.getY();
        AppMethodBeat.o(38450);
        return true;
        label582:
        this.HcZ = paramMotionEvent.getY();
        AppMethodBeat.o(38450);
        return false;
      }
      i += 1;
    }
  }
  
  private void fci()
  {
    boolean bool = false;
    AppMethodBeat.i(38436);
    int j = getFirstHeaderVisible();
    localLayoutParams = (LinearLayout.LayoutParams)this.Hcq.getLayoutParams();
    int k = localLayoutParams.height;
    for (;;)
    {
      try
      {
        if (getAdapter() != null) {
          continue;
        }
        i = 0;
        f1 = ZK(i);
      }
      catch (Exception localException)
      {
        int i;
        float f2;
        float f1 = 0.0F;
        continue;
        localLayoutParams.height = ((int)f2);
        if (!this.csX) {
          continue;
        }
        post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(38397);
            ConversationWithAppBrandListView.this.setSelection(0);
            AppMethodBeat.o(38397);
          }
        });
        continue;
      }
      if (f1 < 0.0F) {
        bool = true;
      }
      f2 = f1;
      if (f1 < getTabViewHeight()) {
        f2 = getTabViewHeight();
      }
      ad.i("MicroMsg.ConversationWithAppBrandListView", "[checkEmptyFooter] isRealFull:" + bool + " extraHeight:" + f2);
      if (!bool) {
        continue;
      }
      localLayoutParams.height = getTabViewHeight();
      if (k != localLayoutParams.height)
      {
        this.Hcq.setLayoutParams(localLayoutParams);
        if (!this.csX) {
          super.setSelection(j);
        }
      }
      AppMethodBeat.o(38436);
      return;
      i = getAdapter().getCount();
    }
  }
  
  private boolean fcj()
  {
    AppMethodBeat.i(38440);
    if ((this.Hcx != null) && (this.HcD != null))
    {
      int i = this.Hcw.getMeasuredHeight();
      if ((i != 0) && (i != this.HcX))
      {
        this.HcX = i;
        AppMethodBeat.o(38440);
        return true;
      }
    }
    AppMethodBeat.o(38440);
    return false;
  }
  
  private void fck()
  {
    AppMethodBeat.i(38441);
    if (fcj())
    {
      if (this.lSL != null) {
        this.lSL.setVisibility(0);
      }
      this.HcH = (-(this.lZZ - getResources().getDimension(2131165484)));
      this.HcI = (-(this.lZZ - (this.HcX / 2 - getResources().getDimension(2131165467))));
      if (!this.HcG)
      {
        if (this.Hcx != null) {
          this.Hcx.setTranslationY(this.HcH);
        }
        if (this.DR != null) {
          this.DR.setTranslationY(0.0F);
        }
        ad.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo initAppBrandHeaderHeight AppBrandHeader appBrandHeight: %d, setTranslationY: %s", new Object[] { Integer.valueOf(this.HcX), Float.valueOf(this.HcH) });
        AppMethodBeat.o(38441);
        return;
      }
      if (this.Hcx != null) {
        this.Hcx.setTranslationY(0.0F);
      }
      if (this.DR != null) {
        this.DR.setTranslationY(this.HcI);
      }
      ad.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo initAppBrandHeaderHeight emptyView appBrandHeight: %d, setTranslationY: %s", new Object[] { Integer.valueOf(this.HcX), Float.valueOf(this.HcI) });
    }
    AppMethodBeat.o(38441);
  }
  
  private void fcl()
  {
    AppMethodBeat.i(38442);
    if (this.HcK)
    {
      AppMethodBeat.o(38442);
      return;
    }
    if (g.ab(d.class) != null)
    {
      this.Hcw = ((d)g.ab(d.class)).dM(this.lTx);
      this.HcK = true;
      this.Hcw.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
      this.Hcx = this.Hcw.findViewById(2131296898);
      this.Hcx.setVisibility(8);
      this.lSL = this.Hcw.getGyroView();
      this.HcD = this.Hcw.getHeaderView();
      this.HcD.setCollectionRefreshListener(new AppBrandRecentView.e()
      {
        public final void tu(int paramAnonymousInt)
        {
          AppMethodBeat.i(38398);
          ad.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo onDone MyAppBrand size: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          if (paramAnonymousInt <= 0) {
            ConversationWithAppBrandListView.b(ConversationWithAppBrandListView.this, true);
          }
          for (;;)
          {
            ConversationWithAppBrandListView.a(ConversationWithAppBrandListView.this, paramAnonymousInt);
            AppMethodBeat.o(38398);
            return;
            ConversationWithAppBrandListView.b(ConversationWithAppBrandListView.this, false);
          }
        }
      });
      this.HcD.setUsageRefreshListener(new AppBrandRecentView.e()
      {
        public final void tu(int paramAnonymousInt)
        {
          AppMethodBeat.i(38399);
          ad.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo onDone RecentAppBrand size: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          if (paramAnonymousInt <= 0) {
            ConversationWithAppBrandListView.c(ConversationWithAppBrandListView.this, true);
          }
          for (;;)
          {
            ConversationWithAppBrandListView.a(ConversationWithAppBrandListView.this, paramAnonymousInt);
            AppMethodBeat.o(38399);
            return;
            ConversationWithAppBrandListView.c(ConversationWithAppBrandListView.this, false);
          }
        }
      });
      this.HcD.setIOnLaunchUIListener(new a.b()
      {
        public final void bsC()
        {
          AppMethodBeat.i(38400);
          ad.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo onLaunchCollectionUI");
          ConversationWithAppBrandListView.this.ag(300L, 10);
          AppMethodBeat.o(38400);
        }
        
        public final void bsD()
        {
          AppMethodBeat.i(38401);
          ad.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo onLaunchUsageUI");
          ConversationWithAppBrandListView.this.ag(300L, 9);
          AppMethodBeat.o(38401);
        }
      });
      this.HcD.setOnEmptyViewListener(new a.a()
      {
        public final void hz(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(38402);
          ad.v("MicroMsg.ConversationWithAppBrandListView", "alvinluo onShowEmptyView show: %b, isOpenAppBrandRecentView: %b", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Boolean.valueOf(ConversationWithAppBrandListView.g(ConversationWithAppBrandListView.this)) });
          ConversationWithAppBrandListView.d(ConversationWithAppBrandListView.this, paramAnonymousBoolean);
          if (ConversationWithAppBrandListView.h(ConversationWithAppBrandListView.this))
          {
            ConversationWithAppBrandListView.c(ConversationWithAppBrandListView.this, true);
            ConversationWithAppBrandListView.b(ConversationWithAppBrandListView.this, true);
          }
          if (!ConversationWithAppBrandListView.g(ConversationWithAppBrandListView.this))
          {
            AppMethodBeat.o(38402);
            return;
          }
          if ((ConversationWithAppBrandListView.i(ConversationWithAppBrandListView.this) != null) && (paramAnonymousBoolean)) {
            ConversationWithAppBrandListView.i(ConversationWithAppBrandListView.this).setTranslationY(0.0F);
          }
          if ((ConversationWithAppBrandListView.j(ConversationWithAppBrandListView.this) != null) && (paramAnonymousBoolean)) {
            ConversationWithAppBrandListView.j(ConversationWithAppBrandListView.this).setTranslationY(0.0F);
          }
          AppMethodBeat.o(38402);
        }
      });
      this.HcD.setReporter(this.lWJ);
      this.DR = this.Hcw.getEmptyView();
      this.HbM.remove(this.Hcw);
      Object localObject = new ListView.FixedViewInfo(this);
      ((ListView.FixedViewInfo)localObject).view = this.Hcw;
      ((ListView.FixedViewInfo)localObject).data = null;
      ((ListView.FixedViewInfo)localObject).isSelectable = true;
      this.HbM.addFirst(localObject);
      localObject = this.HbM.iterator();
      while (((Iterator)localObject).hasNext())
      {
        ListView.FixedViewInfo localFixedViewInfo = (ListView.FixedViewInfo)((Iterator)localObject).next();
        super.addHeaderView(localFixedViewInfo.view, localFixedViewInfo.data, localFixedViewInfo.isSelectable);
      }
    }
    ad.e("MicroMsg.ConversationWithAppBrandListView", "alvinluo addAppBrandHalfView error");
    AppMethodBeat.o(38442);
    return;
    this.HcD.refresh();
    AppMethodBeat.o(38442);
  }
  
  private void fcm()
  {
    AppMethodBeat.i(38451);
    if (!this.Hdc)
    {
      bd.iH(getContext());
      if ((this.lWJ != null) && (this.HcD != null)) {
        this.lWJ.ev(this.HcD.getRecentAppBrandCount(), this.HcD.getStarAppBrandCount());
      }
      if (this.HcD != null) {
        this.HcD.bsq();
      }
    }
    if ((this.HcU) && (this.Hcy != null))
    {
      this.Hcy.getAdapter().aql.notifyChanged();
      this.HcU = true;
    }
    super.smoothScrollToPositionFromTop(0, 0, 250);
    wy(true);
    setOpenAppBrandRecentView(true);
    fcn();
    AppMethodBeat.o(38451);
  }
  
  private void fcn()
  {
    AppMethodBeat.i(38452);
    if (this.HcD != null) {
      this.HcD.bsr();
    }
    AppMethodBeat.o(38452);
  }
  
  private void fco()
  {
    AppMethodBeat.i(38456);
    int i = 0;
    while (i < getChildCount())
    {
      getChildAt(i).setTranslationY(0.0F);
      i += 1;
    }
    this.HcY = 0.0F;
    invalidate();
    AppMethodBeat.o(38456);
  }
  
  private void fcp()
  {
    AppMethodBeat.i(38461);
    ad.d("MicroMsg.ConversationWithAppBrandListView", "alvinluo resetAppBrandHeaderBg");
    if (this.lEk != null)
    {
      int i = this.lTx.getResources().getColor(2131099934);
      this.lEk.setColor(i);
    }
    AppMethodBeat.o(38461);
  }
  
  private boolean fcq()
  {
    AppMethodBeat.i(38467);
    if (this.Hcx != null)
    {
      if ((wB(true)) && (this.Hcx.getVisibility() == 0))
      {
        AppMethodBeat.o(38467);
        return true;
      }
      AppMethodBeat.o(38467);
      return false;
    }
    AppMethodBeat.o(38467);
    return false;
  }
  
  private float getChildTranslationY()
  {
    AppMethodBeat.i(38454);
    View localView = getChildAt(1);
    if (localView == null)
    {
      AppMethodBeat.o(38454);
      return 0.0F;
    }
    float f = localView.getTranslationY();
    AppMethodBeat.o(38454);
    return f;
  }
  
  private View getEmptyFooter()
  {
    AppMethodBeat.i(38433);
    LinearLayout localLinearLayout = new LinearLayout(getContext());
    this.Hcq = new View(getContext());
    this.Hcq.setLayoutParams(new LinearLayout.LayoutParams(-1, 0));
    localLinearLayout.addView(this.Hcq);
    localLinearLayout.setBackgroundColor(getContext().getResources().getColor(2131101179));
    AppMethodBeat.o(38433);
    return localLinearLayout;
  }
  
  private float getHeaderY()
  {
    AppMethodBeat.i(38455);
    View localView = getChildAt(0);
    if (localView == null)
    {
      AppMethodBeat.o(38455);
      return 0.0F;
    }
    float f = localView.getTranslationY();
    AppMethodBeat.o(38455);
    return f;
  }
  
  private float getRatio()
  {
    float f1 = 0.0F;
    AppMethodBeat.i(38462);
    float f2;
    if ((this.Hcw != null) && (this.HcX != 0))
    {
      f2 = 1.0F - Math.abs(this.Hcw.getTop() * 1.0F) / this.HcX;
      if (f2 >= 0.0F) {
        break label122;
      }
    }
    for (;;)
    {
      ad.d("MicroMsg.ConversationWithAppBrandListView", "alvinluo header top: %d, header bottom: %d, ratio: %f, appBrandHeight: %d", new Object[] { Integer.valueOf(this.Hcw.getTop()), Integer.valueOf(this.Hcw.getBottom()), Float.valueOf(f1), Integer.valueOf(this.HcX) });
      AppMethodBeat.o(38462);
      return f1;
      AppMethodBeat.o(38462);
      return 0.0F;
      label122:
      f1 = f2;
    }
  }
  
  private int getTabViewHeight()
  {
    AppMethodBeat.i(38435);
    if (this.HcJ == 0)
    {
      View localView = getRootView().findViewById(2131301338);
      if (localView != null)
      {
        ad.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo initTabViewHeight tabView.getHeight: %d", new Object[] { Integer.valueOf(localView.getHeight()) });
        this.HcJ = localView.getHeight();
      }
    }
    int i = this.HcJ;
    AppMethodBeat.o(38435);
    return i;
  }
  
  private void setEmptyViewVisible(boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(38438);
    ad.i("MicroMsg.ConversationWithAppBrandListView", "[setEmptyViewVisible] isShow:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    View localView;
    if (this.DR != null)
    {
      localView = this.DR;
      if (paramBoolean)
      {
        i = 0;
        localView.setVisibility(i);
      }
    }
    else if (this.Hcx != null)
    {
      localView = this.Hcx.findViewById(2131296899);
      if (localView != null) {
        if (paramBoolean) {
          break label102;
        }
      }
    }
    label102:
    for (int i = j;; i = 4)
    {
      localView.setVisibility(i);
      AppMethodBeat.o(38438);
      return;
      i = 8;
      break;
    }
  }
  
  private void setOpenAppBrandRecentView(boolean paramBoolean)
  {
    this.Hdc = paramBoolean;
  }
  
  private void wA(boolean paramBoolean)
  {
    AppMethodBeat.i(38460);
    ad.i("MicroMsg.ConversationWithAppBrandListView", "[showTipWithAnim] isShow:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.Hde = true;
      localValueAnimator = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofInt("alpha", new int[] { 0, 77 }) });
      localValueAnimator.setDuration(200L);
      localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(38410);
          int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue("alpha")).intValue();
          ConversationWithAppBrandListView.m(ConversationWithAppBrandListView.this).setAlpha(i);
          ConversationWithAppBrandListView.this.invalidate();
          AppMethodBeat.o(38410);
        }
      });
      localValueAnimator.start();
      if (this.lWJ != null) {
        this.lWJ.buC();
      }
      AppMethodBeat.o(38460);
      return;
    }
    ValueAnimator localValueAnimator = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofInt("alpha", new int[] { 77, 0 }) });
    localValueAnimator.setDuration(200L);
    localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(38411);
        int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue("alpha")).intValue();
        ConversationWithAppBrandListView.m(ConversationWithAppBrandListView.this).setAlpha(i);
        ConversationWithAppBrandListView.this.invalidate();
        AppMethodBeat.o(38411);
      }
    });
    localValueAnimator.addListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(38412);
        ConversationWithAppBrandListView.n(ConversationWithAppBrandListView.this);
        AppMethodBeat.o(38412);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator) {}
    });
    localValueAnimator.start();
    AppMethodBeat.o(38460);
  }
  
  private boolean wB(boolean paramBoolean)
  {
    AppMethodBeat.i(38466);
    if (((!this.hasInit) || (!paramBoolean)) && (g.ab(d.class) != null))
    {
      g.ab(d.class);
      this.Hcz = true;
      ad.i("MicroMsg.ConversationWithAppBrandListView", "[isAppBrandHeaderEnable] :%s", new Object[] { Boolean.valueOf(this.Hcz) });
      this.hasInit = true;
    }
    paramBoolean = this.Hcz;
    AppMethodBeat.o(38466);
    return paramBoolean;
  }
  
  private void wx(boolean paramBoolean)
  {
    AppMethodBeat.i(38434);
    if ((this.Hcq == null) || (!wB(true)))
    {
      AppMethodBeat.o(38434);
      return;
    }
    if (paramBoolean)
    {
      postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(38396);
          ConversationWithAppBrandListView.f(ConversationWithAppBrandListView.this);
          AppMethodBeat.o(38396);
        }
      }, 0L);
      AppMethodBeat.o(38434);
      return;
    }
    fci();
    AppMethodBeat.o(38434);
  }
  
  private void wy(boolean paramBoolean)
  {
    AppMethodBeat.i(38437);
    if (paramBoolean)
    {
      aq.az(this.HcW);
      AppMethodBeat.o(38437);
      return;
    }
    aq.az(this.HcW);
    aq.n(this.HcW, 1000L);
    AppMethodBeat.o(38437);
  }
  
  private void wz(boolean paramBoolean)
  {
    AppMethodBeat.i(38459);
    if ((paramBoolean) && (this.Hdf != null))
    {
      aq.az(this.Hdf);
      this.Hdf = null;
      if (this.Hde)
      {
        wA(false);
        AppMethodBeat.o(38459);
      }
    }
    else if ((!paramBoolean) && (this.Hdf == null))
    {
      ConversationWithAppBrandListView.13 local13 = new ConversationWithAppBrandListView.13(this);
      this.Hdf = local13;
      aq.n(local13, 3000L);
    }
    AppMethodBeat.o(38459);
  }
  
  public void addHeaderView(View paramView, Object paramObject, boolean paramBoolean)
  {
    AppMethodBeat.i(38428);
    ListView.FixedViewInfo localFixedViewInfo = new ListView.FixedViewInfo(this);
    localFixedViewInfo.view = paramView;
    localFixedViewInfo.data = paramObject;
    localFixedViewInfo.isSelectable = paramBoolean;
    this.HbM.add(localFixedViewInfo);
    if (getAdapter() != null) {
      super.addHeaderView(localFixedViewInfo.view, localFixedViewInfo.data, localFixedViewInfo.isSelectable);
    }
    ad.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo addHeaderView %d", new Object[] { Integer.valueOf(this.HbM.size()) });
    AppMethodBeat.o(38428);
  }
  
  public final void ag(long paramLong, int paramInt)
  {
    AppMethodBeat.i(38431);
    ad.i("MicroMsg.ConversationWithAppBrandListView", "[hideAppBrandRecentView] delay:%s, type: %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    if (!wB(true))
    {
      if (this.Hcx != null) {
        this.Hcx.setVisibility(8);
      }
      AppMethodBeat.o(38431);
      return;
    }
    if (getFirstVisiblePosition() != 0)
    {
      AppMethodBeat.o(38431);
      return;
    }
    if ((this.lWJ != null) && (this.HcD != null))
    {
      this.lWJ.N(this.HcD.getRecentAppBrandCount(), this.HcD.getStarAppBrandCount(), paramInt);
      this.HcD.uM(paramInt);
    }
    if (paramLong > 0L)
    {
      if (this.HcM != null) {
        removeCallbacks(this.HcM);
      }
      this.HcM = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(38420);
          if (ConversationWithAppBrandListView.c(ConversationWithAppBrandListView.this) != null)
          {
            ad.d("MicroMsg.ConversationWithAppBrandListView", "alvinluo resetToFirstPage");
            ConversationWithAppBrandListView.c(ConversationWithAppBrandListView.this).bsp();
          }
          if (ConversationWithAppBrandListView.d(ConversationWithAppBrandListView.this) != null)
          {
            localObject = ConversationWithAppBrandListView.d(ConversationWithAppBrandListView.this);
            com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.adn(), "com/tencent/mm/ui/conversation/ConversationWithAppBrandListView$9", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
            ((AppBrandRecentView)localObject).smoothScrollToPosition(((Integer)locala.lS(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/ui/conversation/ConversationWithAppBrandListView$9", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
          }
          Object localObject = ConversationWithAppBrandListView.this.getChildAt(0);
          if (localObject == null) {}
          for (int i = 0;; i = ((View)localObject).getBottom())
          {
            if (i != 0) {
              ConversationWithAppBrandListView.this.smoothScrollBy(i, 0);
            }
            ConversationWithAppBrandListView.this.setSelection(0);
            ConversationWithAppBrandListView.e(ConversationWithAppBrandListView.this);
            AppMethodBeat.o(38420);
            return;
          }
        }
      };
      postDelayed(this.HcM, paramLong);
    }
    for (;;)
    {
      fco();
      AppMethodBeat.o(38431);
      return;
      if (this.HcD != null) {
        this.HcD.bsp();
      }
      if (this.Hcy != null)
      {
        AppBrandRecentView localAppBrandRecentView = this.Hcy;
        com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(localAppBrandRecentView, locala.adn(), "com/tencent/mm/ui/conversation/ConversationWithAppBrandListView", "hideAppBrandRecentView", "(JI)V", "Undefined", "smoothScrollToPosition", "(I)V");
        localAppBrandRecentView.smoothScrollToPosition(((Integer)locala.lS(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(localAppBrandRecentView, "com/tencent/mm/ui/conversation/ConversationWithAppBrandListView", "hideAppBrandRecentView", "(JI)V", "Undefined", "smoothScrollToPosition", "(I)V");
      }
      setSelection(0);
      ad.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo resetAppBrandHeaderBg");
      fcp();
    }
  }
  
  public boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    AppMethodBeat.i(38447);
    if ((wB(true)) && (getFirstVisiblePosition() == 0) && (paramInt2 < 0))
    {
      paramArrayOfInt1[1] = ((int)(paramInt2 / 3.0F));
      super.dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2);
      AppMethodBeat.o(38447);
      return true;
    }
    boolean bool = super.dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2);
    AppMethodBeat.o(38447);
    return bool;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(38448);
    try
    {
      if (paramMotionEvent.getAction() == 0)
      {
        float f = paramMotionEvent.getX();
        this.oEd = f;
        this.vLY = f;
        f = paramMotionEvent.getY();
        this.oEe = f;
        this.lVc = f;
      }
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      return bool;
    }
    finally
    {
      this.oEd = paramMotionEvent.getX();
      this.oEe = paramMotionEvent.getY();
      AppMethodBeat.o(38448);
    }
  }
  
  public int getFirstHeaderVisible()
  {
    AppMethodBeat.i(38465);
    Iterator localIterator = this.HbM.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      ListView.FixedViewInfo localFixedViewInfo = (ListView.FixedViewInfo)localIterator.next();
      if (localFixedViewInfo.view == this.Hcw)
      {
        i += 1;
      }
      else
      {
        if ((localFixedViewInfo.view != null) && ((localFixedViewInfo.view instanceof ViewGroup)))
        {
          int j = 0;
          while (j < ((ViewGroup)localFixedViewInfo.view).getChildCount())
          {
            View localView = ((ViewGroup)localFixedViewInfo.view).getChildAt(j);
            if (((localView != null) && (localView.getHeight() > 0)) || (localView.getVisibility() == 0))
            {
              ad.i("MicroMsg.ConversationWithAppBrandListView", "[getFirstHeaderVisible] index:%s", new Object[] { Integer.valueOf(i) });
              AppMethodBeat.o(38465);
              return i;
            }
            j += 1;
          }
        }
        i += 1;
      }
    }
    ad.i("MicroMsg.ConversationWithAppBrandListView", "[getFirstHeaderVisible] index:%s, size: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(this.HbM.size()) });
    AppMethodBeat.o(38465);
    return i;
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(38426);
    super.onConfigurationChanged(paramConfiguration);
    ad.i("MicroMsg.ConversationWithAppBrandListView", "[onConfigurationChanged] orientation:%s", new Object[] { Integer.valueOf(paramConfiguration.orientation) });
    this.HcU = true;
    wx(true);
    if (this.HcD != null) {
      this.HcD.e(paramConfiguration);
    }
    this.HcN = false;
    AppMethodBeat.o(38426);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(38457);
    super.onDraw(paramCanvas);
    if ((getFirstVisiblePosition() == 0) && (this.Hcw != null))
    {
      paramCanvas.drawRect(0.0F, 0.0F, getWidth(), this.Hcw.getBottom() + this.HcY, this.lEk);
      if (getChildAt(1) != null) {
        if ((getHeight() == 0) || (!this.Hde)) {
          break label150;
        }
      }
    }
    label150:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        float f1 = (getWidth() - this.HcC) / 2.0F;
        float f2 = this.Hcw.getBottom();
        float f3 = this.HcY;
        float f4 = getResources().getDimension(2131165489);
        paramCanvas.drawText(this.HcB, f1, f2 + f3 - f4, this.HcA);
      }
      AppMethodBeat.o(38457);
      return;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(38427);
    boolean bool;
    if (getFirstVisiblePosition() != 0)
    {
      bool = super.onInterceptTouchEvent(paramMotionEvent);
      AppMethodBeat.o(38427);
      return bool;
    }
    int i = paramMotionEvent.getActionMasked();
    int j = paramMotionEvent.getActionIndex();
    switch (i)
    {
    case 1: 
    case 3: 
    case 4: 
    default: 
      bool = super.onInterceptTouchEvent(paramMotionEvent);
      AppMethodBeat.o(38427);
      return bool;
    case 0: 
      this.apF = paramMotionEvent.getPointerId(0);
      this.apG = ((int)(paramMotionEvent.getX() + 0.5F));
      this.apH = ((int)(paramMotionEvent.getY() + 0.5F));
      bool = super.onInterceptTouchEvent(paramMotionEvent);
      AppMethodBeat.o(38427);
      return bool;
    case 5: 
      this.apF = paramMotionEvent.getPointerId(j);
      this.apG = ((int)(paramMotionEvent.getX(j) + 0.5F));
      this.apH = ((int)(paramMotionEvent.getY(j) + 0.5F));
      bool = super.onInterceptTouchEvent(paramMotionEvent);
      AppMethodBeat.o(38427);
      return bool;
    }
    j = paramMotionEvent.findPointerIndex(this.apF);
    if (j < 0)
    {
      AppMethodBeat.o(38427);
      return false;
    }
    i = (int)(paramMotionEvent.getX(j) + 0.5F);
    int k = (int)(paramMotionEvent.getY(j) + 0.5F);
    j = this.apG;
    k -= this.apH;
    if ((Math.abs(k) > this.mTouchSlop) && (Math.abs(k) >= Math.abs(i - j))) {}
    for (i = 1;; i = 0)
    {
      if ((i != 0) && (super.onInterceptTouchEvent(paramMotionEvent)))
      {
        AppMethodBeat.o(38427);
        return true;
      }
      AppMethodBeat.o(38427);
      return false;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(38425);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramBoolean) && (wB(true)))
    {
      if (this.csX)
      {
        wx(true);
        post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(38416);
            ConversationWithAppBrandListView.this.setSelection(0);
            AppMethodBeat.o(38416);
          }
        });
        this.HcT = paramInt4;
        this.csX = false;
        AppMethodBeat.o(38425);
        return;
      }
      if ((!this.dkt) && (this.HcT != paramInt4))
      {
        ad.i("MicroMsg.ConversationWithAppBrandListView", "[onLayout] mLastBottom:" + this.HcT + " b:" + paramInt4);
        wx(true);
        this.HcT = paramInt4;
      }
    }
    AppMethodBeat.o(38425);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(38439);
    super.onMeasure(paramInt1, paramInt2);
    fck();
    AppMethodBeat.o(38439);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(38463);
    if (this.sZi != null) {
      this.sZi.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
    if (!wB(true))
    {
      AppMethodBeat.o(38463);
      return;
    }
    fck();
    if (this.HcX == 0)
    {
      AppMethodBeat.o(38463);
      return;
    }
    ad.v("MicroMsg.ConversationWithAppBrandListView", "alvinluo onScroll firstVisibleItem: %d, visibleItemCount: %d, totalItemCount: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    float f1;
    View localView;
    label278:
    GyroView localGyroView;
    if (paramInt1 == 0)
    {
      float f2 = getRatio();
      if ((this.HcO == 0.0F) || (this.HcO == 1.0F) || (Math.abs(f2 - this.HcO) >= 0.01D))
      {
        this.HcO = f2;
        f1 = f2;
        if (this.Hcw != null)
        {
          if ((this.Hcw.getTop() != 0) || (this.HcN)) {
            break label278;
          }
          f1 = 0.0F;
        }
      }
      for (;;)
      {
        if (this.HcP != null)
        {
          paramInt2 = this.HcP.aH(f1);
          if (this.lEk != null) {
            this.lEk.setColor(paramInt2);
          }
          if (this.Hcx != null) {
            this.Hcx.setBackgroundColor(paramInt2);
          }
        }
        wy(false);
        paramAbsListView = paramAbsListView.getChildAt(0);
        if ((paramAbsListView == null) || (!(paramAbsListView instanceof HeaderContainer))) {
          break label530;
        }
        localView = paramAbsListView.findViewById(2131296898);
        if ((localView != null) && (localView.getVisibility() != 8)) {
          break;
        }
        AppMethodBeat.o(38463);
        return;
        f1 = f2;
        if (this.Hcw.getTop() != 0)
        {
          this.HcN = true;
          f1 = f2;
        }
      }
      localGyroView = ((HeaderContainer)paramAbsListView).getGyroView();
      ad.v("MicroMsg.ConversationWithAppBrandListView", "alvinluo appBrandHeaderTransH: %s, emptyTransH: %s, headerParent.bottom: %s, translationY: %f, mAppBrandHeight: %d", new Object[] { Float.valueOf(this.HcH), Float.valueOf(this.HcI), Integer.valueOf(paramAbsListView.getBottom()), Float.valueOf(localView.getTranslationY()), Integer.valueOf(this.HcX) });
      if (paramAbsListView.getBottom() <= 3)
      {
        if (!this.HcG)
        {
          localView.setTranslationY(this.HcH);
          if (localGyroView.getVisibility() == 0)
          {
            localGyroView.setVerticalScroll(0.0F);
            localGyroView.setVisibility(8);
          }
          this.Hdi = false;
        }
      }
      else
      {
        if ((paramAbsListView.getBottom() <= 3) || (paramAbsListView.getBottom() > this.lZZ) || ((localView.getTranslationY() == 0.0F) && ((this.DR == null) || (this.DR.getTranslationY() == 0.0F)))) {
          break label637;
        }
        if (localGyroView.getVisibility() == 8) {
          localGyroView.setVisibility(0);
        }
        localGyroView.setAlpha(1.0F);
        localGyroView.setTranslationY(-paramAbsListView.getBottom() / 2 + localGyroView.getHeight() / 2);
        localGyroView.setVerticalScroll(paramAbsListView.getBottom());
      }
    }
    label530:
    label1011:
    for (;;)
    {
      this.Hdj = paramInt1;
      if ((this.Hdh) && (this.lSE) && (paramInt1 == 0))
      {
        ad.e("MicroMsg.ConversationWithAppBrandListView", "[Stop fling!]");
        smoothScrollBy(0, 0);
        post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(38414);
            View localView = ConversationWithAppBrandListView.this.getChildAt(0);
            if (localView == null) {}
            for (int i = 0;; i = localView.getBottom())
            {
              ad.i("MicroMsg.ConversationWithAppBrandListView", "[smoothScrollBy] offset: ".concat(String.valueOf(i)));
              ConversationWithAppBrandListView.this.smoothScrollToPositionFromTop(ConversationWithAppBrandListView.this.getFirstHeaderVisible(), 0, 300);
              ConversationWithAppBrandListView.q(ConversationWithAppBrandListView.this);
              AppMethodBeat.o(38414);
              return;
            }
          }
        });
        this.Hdh = false;
      }
      aq.az(this.Hdg);
      aq.n(this.Hdg, 50L);
      AppMethodBeat.o(38463);
      return;
      if (this.DR != null) {
        this.DR.setTranslationY(this.HcI);
      }
      localView.setTranslationY(0.0F);
      break;
      label637:
      if ((paramAbsListView.getBottom() > this.lZZ) && ((localView.getTranslationY() != 0.0F) || ((this.DR != null) && (this.DR.getTranslationY() != 0.0F))))
      {
        f1 = (float)(1.0D * (paramAbsListView.getBottom() - this.lZZ) / (this.HcX - this.lZZ));
        ad.v("MicroMsg.ConversationWithAppBrandListView", "alvinluo checkUpAppBrandHeader appbrandHeader translationY: %f, percent: %f, setTranslationY: %f, isEmpty: %b", new Object[] { Float.valueOf(localView.getTranslationY()), Float.valueOf(f1), Float.valueOf(this.HcH * (1.0F - f1)), Boolean.valueOf(this.HcG) });
        if (!this.HcG) {
          localView.setTranslationY(this.HcH * (1.0F - f1));
        }
        for (;;)
        {
          localGyroView.setTranslationY(-this.lZZ / 2.0F + localGyroView.getHeight() / 2 + (this.lZZ / 2.0F + localGyroView.getHeight()) * f1);
          localGyroView.setAlpha(1.0F - 2.0F * f1);
          if ((!this.Hdi) && (1.0F != f1))
          {
            this.lRO.vibrate(10L);
            this.Hdi = true;
          }
          wy(true);
          break;
          if (this.DR != null)
          {
            ad.v("MicroMsg.ConversationWithAppBrandListView", "alvinluo emptyView translationY: %f, set: %f", new Object[] { Float.valueOf(this.DR.getTranslationY()), Float.valueOf(-this.HcI * (1.0F - f1)) });
            this.DR.setTranslationY(this.HcI * (1.0F - f1));
          }
          localView.setTranslationY(0.0F);
        }
        if (this.Hcw != null)
        {
          paramAbsListView = this.Hcw.findViewById(2131296898);
          if (this.HcG) {
            break label1011;
          }
          if (paramAbsListView != null) {
            paramAbsListView.setTranslationY(this.HcH);
          }
        }
        for (;;)
        {
          if ((this.Hdj != 0) || (paramInt1 == 0)) {
            break label1039;
          }
          ZJ(4);
          wz(true);
          wy(true);
          break;
          if (this.DR != null) {
            this.DR.setTranslationY(this.HcI);
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
    AppMethodBeat.i(38458);
    if (this.sZi != null) {
      this.sZi.onScrollStateChanged(paramAbsListView, paramInt);
    }
    if ((getFirstVisiblePosition() != 0) && (paramInt == 2) && (!this.Hdd)) {
      this.lSE = true;
    }
    AppMethodBeat.o(38458);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(38449);
    boolean bool;
    if (!wB(true))
    {
      bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(38449);
      return bool;
    }
    if (paramMotionEvent.getAction() == 0) {
      if (getFirstVisiblePosition() != 0) {
        this.Hdh = true;
      }
    }
    for (;;)
    {
      if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
      {
        wy(true);
        this.Hda = false;
        if (getChildTranslationY() > 0.0F) {
          fcm();
        }
      }
      if (ac(paramMotionEvent)) {
        break;
      }
      if ((this.Hda) && (paramMotionEvent.getAction() == 2))
      {
        paramMotionEvent.setAction(0);
        super.onTouchEvent(paramMotionEvent);
        paramMotionEvent.setAction(2);
        this.Hda = false;
      }
      bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(38449);
      return bool;
      if (((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3)) && (getFirstVisiblePosition() == 0))
      {
        View localView = getChildAt(0);
        if (localView == null)
        {
          AppMethodBeat.o(38449);
          return true;
        }
        if ((Math.abs(paramMotionEvent.getX() - this.oEd) < 3.0F) && (Math.abs(paramMotionEvent.getY() - this.oEe) < 3.0F)) {
          super.onTouchEvent(paramMotionEvent);
        }
        if (getChildTranslationY() < 60.0F * getResources().getDisplayMetrics().density)
        {
          float f1 = Math.abs(paramMotionEvent.getX() - this.vLY);
          float f2 = Math.abs(paramMotionEvent.getY() - this.lVc);
          if (((paramMotionEvent.getY() - this.lVc < -5.0F) && (f1 - f2 < 0.0F) && (getFirstVisiblePosition() == 0)) || ((localView.getBottom() > 0) && (localView.getBottom() < this.lZZ))) {
            ZJ(4);
          } else if ((localView.getBottom() >= this.lZZ) && (paramMotionEvent.getY() - this.lVc > 5.0F)) {
            fcm();
          }
        }
      }
    }
    if (paramMotionEvent.getAction() == 0) {
      super.onTouchEvent(paramMotionEvent);
    }
    for (;;)
    {
      AppMethodBeat.o(38449);
      return true;
      if ((paramMotionEvent.getAction() == 2) && (!this.Hda) && (Math.abs(paramMotionEvent.getY() - this.oEe) > 2.0F))
      {
        paramMotionEvent.setAction(3);
        super.onTouchEvent(paramMotionEvent);
        this.Hda = true;
      }
      else if (!this.Hda)
      {
        super.onTouchEvent(paramMotionEvent);
      }
    }
  }
  
  public void setActionBarUpdateCallback(com.tencent.mm.plugin.appbrand.widget.header.a parama)
  {
    this.HcL = parama;
  }
  
  public void setActivity(MMFragmentActivity paramMMFragmentActivity)
  {
    AppMethodBeat.i(38424);
    this.lTx = paramMMFragmentActivity;
    fcl();
    AppMethodBeat.o(38424);
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    AppMethodBeat.i(38423);
    ad.i("MicroMsg.ConversationWithAppBrandListView", "[init] ");
    this.HcV.alive();
    this.lRO = ((Vibrator)getContext().getSystemService("vibrator"));
    this.mTouchSlop = u.a(ViewConfiguration.get(getContext()));
    this.lEk = new Paint(1);
    this.HcA = new Paint(1);
    this.lEk.setColor(getResources().getColor(2131099955));
    this.HcA.setColor(-2147483648);
    this.HcA.setTextSize(getResources().getDimension(2131165576));
    wB(false);
    if (g.ab(d.class) != null) {
      this.lWJ = ((d)g.ab(d.class)).bqW();
    }
    this.lZZ = (100.0F * getResources().getDisplayMetrics().density);
    ad.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo init mAnimationPadding: %f, density: %f", new Object[] { Float.valueOf(this.lZZ), Float.valueOf(getResources().getDisplayMetrics().density) });
    this.HcB = getResources().getString(2131757945);
    this.HcC = this.HcA.measureText(this.HcB);
    super.setOnScrollListener(this);
    paramListAdapter.registerDataSetObserver(new ConversationWithAppBrandListView.11(this, paramListAdapter));
    try
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)getLayoutParams();
      localLayoutParams.topMargin = ap.dL(getContext());
      ad.i("MicroMsg.ConversationWithAppBrandListView", "[initLayoutParams]1 ActionBar height:%s", new Object[] { Integer.valueOf(localLayoutParams.topMargin) });
      if (localLayoutParams.topMargin <= 0) {
        postDelayed(new ConversationWithAppBrandListView.19(this, localLayoutParams), 200L);
      }
      if (this.lTx != null) {
        fcl();
      }
      addFooterView(getEmptyFooter());
      super.setAdapter(paramListAdapter);
      AppMethodBeat.o(38423);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.ConversationWithAppBrandListView", localException, "alvinluo initLayoutParams exception", new Object[0]);
      }
    }
  }
  
  public void setOnItemClickListener(final AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    AppMethodBeat.i(38429);
    super.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(38418);
        if (paramOnItemClickListener != null) {
          paramOnItemClickListener.onItemClick(paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        }
        if (!ConversationWithAppBrandListView.b(ConversationWithAppBrandListView.this))
        {
          AppMethodBeat.o(38418);
          return;
        }
        if (ConversationWithAppBrandListView.this.getFirstVisiblePosition() == 0) {
          ConversationWithAppBrandListView.this.ag(500L, 8);
        }
        AppMethodBeat.o(38418);
      }
    });
    AppMethodBeat.o(38429);
  }
  
  public void setOnItemLongClickListener(final AdapterView.OnItemLongClickListener paramOnItemLongClickListener)
  {
    AppMethodBeat.i(38430);
    super.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(38419);
        if ((paramAnonymousInt == 0) && (ConversationWithAppBrandListView.b(ConversationWithAppBrandListView.this)))
        {
          AppMethodBeat.o(38419);
          return false;
        }
        if (paramOnItemLongClickListener != null)
        {
          boolean bool = paramOnItemLongClickListener.onItemLongClick(paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
          AppMethodBeat.o(38419);
          return bool;
        }
        AppMethodBeat.o(38419);
        return false;
      }
    });
    AppMethodBeat.o(38430);
  }
  
  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.sZi = paramOnScrollListener;
  }
  
  public void setSelection(int paramInt)
  {
    AppMethodBeat.i(38443);
    ad.i("MicroMsg.ConversationWithAppBrandListView", "[setSelection] position:%s", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt == 0) && (wB(true)))
    {
      paramInt = getFirstHeaderVisible();
      ad.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo setSelection pos: %d, appbrandHeight: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.HcX) });
      super.setSelection(paramInt);
      if ((this.lWJ != null) && (this.HcD != null))
      {
        this.lWJ.N(this.HcD.getRecentAppBrandCount(), this.HcD.getStarAppBrandCount(), 7);
        this.HcD.uM(7);
      }
      AppMethodBeat.o(38443);
      return;
    }
    super.setSelection(paramInt);
    AppMethodBeat.o(38443);
  }
  
  public void smoothScrollToPosition(int paramInt)
  {
    AppMethodBeat.i(38444);
    ad.d("MicroMsg.ConversationWithAppBrandListView", "[smoothScrollToPosition] position:%s", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt == 0) && (wB(true)))
    {
      super.smoothScrollToPosition(getFirstHeaderVisible());
      AppMethodBeat.o(38444);
      return;
    }
    super.smoothScrollToPosition(paramInt);
    AppMethodBeat.o(38444);
  }
  
  public void smoothScrollToPositionFromTop(int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(38445);
    ad.d("MicroMsg.ConversationWithAppBrandListView", "[smoothScrollToPositionFromTop] position:%s offset:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    final int i = paramInt1;
    if (paramInt1 == 0)
    {
      i = paramInt1;
      if (wB(true)) {
        i = getFirstHeaderVisible();
      }
    }
    aq.n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(38403);
        ConversationWithAppBrandListView.a(ConversationWithAppBrandListView.this, i, paramInt2);
        AppMethodBeat.o(38403);
      }
    }, 100L);
    AppMethodBeat.o(38445);
  }
  
  public void smoothScrollToPositionFromTop(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(38446);
    ad.d("MicroMsg.ConversationWithAppBrandListView", "[smoothScrollToPositionFromTop] position:%s offset:%s duration:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt1 == 0) && (wB(true)))
    {
      super.smoothScrollToPositionFromTop(getFirstHeaderVisible(), paramInt2, paramInt3);
      AppMethodBeat.o(38446);
      return;
    }
    super.smoothScrollToPositionFromTop(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(38446);
  }
  
  public final void tu(int paramInt)
  {
    AppMethodBeat.i(38432);
    ad.i("MicroMsg.ConversationWithAppBrandListView", "[next] size:%s isAppBrandHeaderEnable:%s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.Hcz) });
    if (!wB(true))
    {
      ad.w("MicroMsg.ConversationWithAppBrandListView", "[next] is disable!");
      if (this.Hcx != null) {
        this.Hcx.setVisibility(8);
      }
      AppMethodBeat.o(38432);
      return;
    }
    if ((paramInt == 1) && (this.Hcx != null)) {
      setEmptyViewVisible(true);
    }
    for (;;)
    {
      if ((this.Hcx != null) && (this.Hcx.getVisibility() == 8))
      {
        this.Hcx.setVisibility(0);
        setSelection(getFirstVisiblePosition());
      }
      AppMethodBeat.o(38432);
      return;
      if ((paramInt > 1) && (this.Hcx != null)) {
        setEmptyViewVisible(false);
      }
    }
  }
  
  final class a
    implements Runnable
  {
    a() {}
    
    public final void run()
    {
      AppMethodBeat.i(38421);
      View localView = ConversationWithAppBrandListView.this.getChildAt(0);
      if ((ConversationWithAppBrandListView.this.getFirstVisiblePosition() == 0) && (localView != null))
      {
        if (localView.getTop() >= 0)
        {
          AppMethodBeat.o(38421);
          return;
        }
        ad.i("MicroMsg.ConversationWithAppBrandListView", "[UpAppBrandHeaderTask] run...");
        if (localView.getBottom() >= ConversationWithAppBrandListView.r(ConversationWithAppBrandListView.this))
        {
          ConversationWithAppBrandListView.s(ConversationWithAppBrandListView.this);
          AppMethodBeat.o(38421);
          return;
        }
        ConversationWithAppBrandListView.t(ConversationWithAppBrandListView.this);
      }
      AppMethodBeat.o(38421);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.ConversationWithAppBrandListView
 * JD-Core Version:    0.7.0.1
 */
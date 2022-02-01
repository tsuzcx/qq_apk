package com.tencent.mm.ui.conversation;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DataSetObserver;
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
import com.tencent.mm.g.a.kd;
import com.tencent.mm.g.a.lr;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.widget.header.GyroView;
import com.tencent.mm.plugin.appbrand.widget.header.HeaderContainer;
import com.tencent.mm.plugin.appbrand.widget.header.a.a.a;
import com.tencent.mm.plugin.appbrand.widget.header.a.a.b;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.e;
import com.tencent.mm.plugin.appbrand.widget.recentview.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.ui.MMFragmentActivity;
import java.util.Iterator;
import java.util.LinkedList;

public class ConversationWithAppBrandListView
  extends ListView
  implements AbsListView.OnScrollListener, AppBrandRecentView.e
{
  private View GG;
  private View KPX;
  private LinkedList<ListView.FixedViewInfo> KPt;
  private com.tencent.mm.plugin.appbrand.widget.header.b KQA;
  private com.tencent.mm.plugin.appbrand.widget.header.b KQB;
  private com.tencent.mm.sdk.b.c<lr> KQC;
  private int KQD;
  boolean KQE;
  private final com.tencent.mm.sdk.b.c<kd> KQF;
  private a KQG;
  private int KQH;
  private float KQI;
  private float KQJ;
  private boolean KQK;
  private boolean KQL;
  private boolean KQM;
  private boolean KQN;
  private boolean KQO;
  private Runnable KQP;
  private Runnable KQQ;
  private boolean KQR;
  private boolean KQS;
  private int KQT;
  private HeaderContainer KQh;
  private View KQi;
  private AppBrandRecentView KQj;
  private boolean KQk;
  private Paint KQl;
  private String KQm;
  private float KQn;
  private com.tencent.mm.plugin.appbrand.widget.header.a.a KQo;
  private boolean KQp;
  private boolean KQq;
  private float KQr;
  private float KQs;
  private int KQt;
  private boolean KQu;
  private com.tencent.mm.plugin.appbrand.widget.header.a KQv;
  private Runnable KQw;
  private boolean KQx;
  private float KQy;
  private com.tencent.mm.plugin.appbrand.widget.header.b KQz;
  private int ass;
  private int ast;
  private int asu;
  private boolean cBE;
  private ValueAnimator cQt;
  private boolean dus;
  private boolean dux;
  private boolean hasInit;
  private Paint mLJ;
  private int mTouchSlop;
  private Vibrator mZD;
  private GyroView naA;
  private boolean nat;
  private MMFragmentActivity nbm;
  private float ncP;
  private com.tencent.mm.plugin.appbrand.widget.recentview.b neB;
  private float nhJ;
  private float pRK;
  private float pRL;
  private AbsListView.OnScrollListener vwl;
  private float yzV;
  
  public ConversationWithAppBrandListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(38422);
    this.KPt = new LinkedList();
    this.KQk = false;
    this.KQp = false;
    this.KQq = false;
    this.dux = false;
    this.KQr = 0.0F;
    this.KQs = 0.0F;
    this.KQt = 0;
    this.KQu = false;
    this.KQw = null;
    this.KQx = true;
    this.KQy = 0.0F;
    this.KQz = null;
    this.KQA = null;
    this.KQB = null;
    this.KQC = new ConversationWithAppBrandListView.1(this);
    this.cBE = true;
    this.KQD = 0;
    this.KQE = false;
    this.ass = -1;
    this.KQF = new com.tencent.mm.sdk.b.c() {};
    this.KQG = new a();
    this.KQH = 0;
    this.KQI = 0.0F;
    this.KQJ = 0.0F;
    this.KQL = false;
    this.KQN = false;
    this.KQO = false;
    this.KQQ = new Runnable()
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
    this.nat = false;
    this.KQR = false;
    this.KQS = false;
    this.hasInit = false;
    this.KQz = new com.tencent.mm.plugin.appbrand.widget.header.b(getContext().getResources().getColor(2131099648), getContext().getResources().getColor(2131099928));
    this.KQC.alive();
    AppMethodBeat.o(38422);
  }
  
  private boolean ac(MotionEvent paramMotionEvent)
  {
    int j = 0;
    AppMethodBeat.i(38450);
    if (!fNq())
    {
      AppMethodBeat.o(38450);
      return false;
    }
    if (paramMotionEvent.getAction() == 0)
    {
      this.KQJ = paramMotionEvent.getY();
      if (this.cQt != null) {
        this.cQt.cancel();
      }
    }
    float f3;
    try
    {
      if (((paramMotionEvent.getAction() != 2) || (Math.abs(paramMotionEvent.getY() - this.pRL) <= 2.0F) || (getFirstVisiblePosition() != 0) || (this.KQh.getTop() != 0)) && (getChildTranslationY() == 0.0F)) {
        break label582;
      }
      yG(true);
      if ((getHeight() - getTabViewHeight() - this.KQH) / 2 <= this.KQI) {
        yH(false);
      }
      for (;;)
      {
        float f1 = paramMotionEvent.getY();
        float f2 = this.KQJ;
        f3 = getHeight() - getTabViewHeight() - this.KQH;
        this.KQI = ((f1 - f2) * 0.4F + this.KQI);
        if (this.KQI >= 0.0F) {
          break label488;
        }
        this.KQI = 0.0F;
        fNo();
        invalidate();
        return false;
        if (paramMotionEvent.getActionMasked() == 5)
        {
          this.KQJ = paramMotionEvent.getY();
          break;
        }
        if (((paramMotionEvent.getAction() != 1) && (paramMotionEvent.getAction() != 3)) || (this.KQh.getTop() != 0) || (getChildTranslationY() == 0.0F)) {
          break;
        }
        yH(true);
        this.KQL = false;
        ae.d("MicroMsg.ConversationWithAppBrandListView", "[animationChild] offset:%s delay:%s duration%s", new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(180) });
        if (!fNq()) {
          break;
        }
        if (this.cQt != null) {
          this.cQt.cancel();
        }
        this.cQt = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("deltaY", new float[] { getChildTranslationY() + 0.0F, 0.0F }), PropertyValuesHolder.ofFloat("headerDeltaY", new float[] { getHeaderY() + 0.0F, 0.0F }) });
        this.cQt.setDuration(180L);
        this.cQt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
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
        this.cQt.addListener(new ConversationWithAppBrandListView.12(this));
        this.cQt.setStartDelay(0L);
        this.cQt.start();
        break;
        yH(true);
      }
      i = j;
    }
    finally
    {
      this.KQJ = paramMotionEvent.getY();
      AppMethodBeat.o(38450);
    }
    label488:
    int i;
    if (f3 < this.KQI)
    {
      this.KQI = f3;
      i = j;
    }
    for (;;)
    {
      if (i < getChildCount())
      {
        if (i == 0) {
          getChildAt(i).setTranslationY(this.KQI * 0.5F);
        } else {
          getChildAt(i).setTranslationY(this.KQI);
        }
      }
      else
      {
        invalidate();
        this.KQJ = paramMotionEvent.getY();
        AppMethodBeat.o(38450);
        return true;
        label582:
        this.KQJ = paramMotionEvent.getY();
        AppMethodBeat.o(38450);
        return false;
      }
      i += 1;
    }
  }
  
  private void afd(int paramInt)
  {
    AppMethodBeat.i(38453);
    ae.i("MicroMsg.ConversationWithAppBrandListView", "[closeAppBrandRecentView] isOpenAppBrandRecentView:%s type:%s", new Object[] { Boolean.valueOf(this.KQM), Integer.valueOf(paramInt) });
    if ((this.KQM) && (getChildAt(0) != null) && (this.neB != null) && (this.KQo != null))
    {
      this.neB.Q(this.KQo.getRecentAppBrandCount(), this.KQo.getStarAppBrandCount(), paramInt);
      this.KQo.wo(paramInt);
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
      fNo();
      yG(true);
      setOpenAppBrandRecentView(false);
      com.tencent.mm.sdk.platformtools.ar.o(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(38404);
          if (ConversationWithAppBrandListView.c(ConversationWithAppBrandListView.this) != null)
          {
            ae.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo scrollToFirstPage");
            ConversationWithAppBrandListView.c(ConversationWithAppBrandListView.this).bEl();
          }
          AppMethodBeat.o(38404);
        }
      }, 500L);
      AppMethodBeat.o(38453);
      return;
    }
  }
  
  private float afe(int paramInt)
  {
    AppMethodBeat.i(38464);
    ae.d("MicroMsg.ConversationWithAppBrandListView", "[isFull] totalItemCount:" + paramInt + " getFirstVisiblePosition:" + getFirstVisiblePosition() + " getLastVisiblePosition:" + getLastVisiblePosition() + " getHeaderViewsCount:" + getHeaderViewsCount() + " getFooterViewsCount:" + getFooterViewsCount());
    int i = (int)getResources().getDimension(2131165515);
    paramInt = paramInt - getHeaderViewsCount() - getFooterViewsCount();
    float f = getMeasuredHeight() - i * paramInt;
    ae.i("MicroMsg.ConversationWithAppBrandListView", "[isFull] height:%s rawCount:%s extraHeight:%s", new Object[] { Integer.valueOf(getHeight()), Integer.valueOf(paramInt), Float.valueOf(f) });
    AppMethodBeat.o(38464);
    return f;
  }
  
  private void fNi()
  {
    boolean bool = false;
    AppMethodBeat.i(38436);
    int j = getFirstHeaderVisible();
    localLayoutParams = (LinearLayout.LayoutParams)this.KPX.getLayoutParams();
    int k = localLayoutParams.height;
    for (;;)
    {
      try
      {
        if (getAdapter() != null) {
          continue;
        }
        i = 0;
        f1 = afe(i);
      }
      catch (Exception localException)
      {
        int i;
        float f2;
        float f1 = 0.0F;
        continue;
        localLayoutParams.height = ((int)f2);
        if (!this.cBE) {
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
      ae.i("MicroMsg.ConversationWithAppBrandListView", "[checkEmptyFooter] isRealFull:" + bool + " extraHeight:" + f2);
      if (!bool) {
        continue;
      }
      localLayoutParams.height = getTabViewHeight();
      if (k != localLayoutParams.height)
      {
        this.KPX.setLayoutParams(localLayoutParams);
        if (!this.cBE) {
          super.setSelection(j);
        }
      }
      AppMethodBeat.o(38436);
      return;
      i = getAdapter().getCount();
    }
  }
  
  private boolean fNj()
  {
    AppMethodBeat.i(38440);
    if ((this.KQi != null) && (this.KQo != null))
    {
      int i = this.KQh.getMeasuredHeight();
      if ((i != 0) && (i != this.KQH))
      {
        this.KQH = i;
        AppMethodBeat.o(38440);
        return true;
      }
    }
    AppMethodBeat.o(38440);
    return false;
  }
  
  private void fNk()
  {
    AppMethodBeat.i(38441);
    if (fNj())
    {
      if (this.naA != null) {
        this.naA.setVisibility(0);
      }
      this.KQr = (-(this.nhJ - getResources().getDimension(2131165484)));
      this.KQs = (-(this.nhJ - (this.KQH / 2 - getResources().getDimension(2131165467))));
      if (!this.dux)
      {
        if (this.KQi != null) {
          this.KQi.setTranslationY(this.KQr);
        }
        if (this.GG != null) {
          this.GG.setTranslationY(0.0F);
        }
        ae.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo initAppBrandHeaderHeight AppBrandHeader appBrandHeight: %d, setTranslationY: %s", new Object[] { Integer.valueOf(this.KQH), Float.valueOf(this.KQr) });
        AppMethodBeat.o(38441);
        return;
      }
      if (this.KQi != null) {
        this.KQi.setTranslationY(0.0F);
      }
      if (this.GG != null) {
        this.GG.setTranslationY(this.KQs);
      }
      ae.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo initAppBrandHeaderHeight emptyView appBrandHeight: %d, setTranslationY: %s", new Object[] { Integer.valueOf(this.KQH), Float.valueOf(this.KQs) });
    }
    AppMethodBeat.o(38441);
  }
  
  private void fNl()
  {
    AppMethodBeat.i(38442);
    if (this.KQu)
    {
      AppMethodBeat.o(38442);
      return;
    }
    if (g.ab(d.class) != null)
    {
      this.KQh = ((d)g.ab(d.class)).dY(this.nbm);
      this.KQu = true;
      this.KQh.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
      this.KQi = this.KQh.findViewById(2131296898);
      this.KQi.setVisibility(8);
      this.naA = this.KQh.getGyroView();
      this.KQo = this.KQh.getHeaderView();
      this.KQo.setCollectionRefreshListener(new AppBrandRecentView.e()
      {
        public final void uT(int paramAnonymousInt)
        {
          AppMethodBeat.i(38398);
          ae.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo onDone MyAppBrand size: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
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
      this.KQo.setUsageRefreshListener(new AppBrandRecentView.e()
      {
        public final void uT(int paramAnonymousInt)
        {
          AppMethodBeat.i(38399);
          ae.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo onDone RecentAppBrand size: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
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
      this.KQo.setIOnLaunchUIListener(new a.b()
      {
        public final void bEx()
        {
          AppMethodBeat.i(38400);
          ae.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo onLaunchCollectionUI");
          ConversationWithAppBrandListView.this.ap(300L, 10);
          AppMethodBeat.o(38400);
        }
        
        public final void bEy()
        {
          AppMethodBeat.i(38401);
          ae.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo onLaunchUsageUI");
          ConversationWithAppBrandListView.this.ap(300L, 9);
          AppMethodBeat.o(38401);
        }
      });
      this.KQo.setOnEmptyViewListener(new a.a()
      {
        public final void ie(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(38402);
          ae.v("MicroMsg.ConversationWithAppBrandListView", "alvinluo onShowEmptyView show: %b, isOpenAppBrandRecentView: %b", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Boolean.valueOf(ConversationWithAppBrandListView.g(ConversationWithAppBrandListView.this)) });
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
      this.KQo.setReporter(this.neB);
      this.GG = this.KQh.getEmptyView();
      this.KPt.remove(this.KQh);
      Object localObject = new ListView.FixedViewInfo(this);
      ((ListView.FixedViewInfo)localObject).view = this.KQh;
      ((ListView.FixedViewInfo)localObject).data = null;
      ((ListView.FixedViewInfo)localObject).isSelectable = true;
      this.KPt.addFirst(localObject);
      localObject = this.KPt.iterator();
      while (((Iterator)localObject).hasNext())
      {
        ListView.FixedViewInfo localFixedViewInfo = (ListView.FixedViewInfo)((Iterator)localObject).next();
        super.addHeaderView(localFixedViewInfo.view, localFixedViewInfo.data, localFixedViewInfo.isSelectable);
      }
    }
    ae.e("MicroMsg.ConversationWithAppBrandListView", "alvinluo addAppBrandHalfView error");
    AppMethodBeat.o(38442);
    return;
    this.KQo.refresh();
    AppMethodBeat.o(38442);
  }
  
  private void fNm()
  {
    AppMethodBeat.i(38451);
    if (!this.KQM)
    {
      be.jh(getContext());
      if ((this.neB != null) && (this.KQo != null)) {
        this.neB.eB(this.KQo.getRecentAppBrandCount(), this.KQo.getStarAppBrandCount());
      }
      if (this.KQo != null) {
        this.KQo.bEm();
      }
    }
    if ((this.KQE) && (this.KQj != null))
    {
      this.KQj.getAdapter().asY.notifyChanged();
      this.KQE = true;
    }
    super.smoothScrollToPositionFromTop(0, 0, 250);
    yG(true);
    setOpenAppBrandRecentView(true);
    fNn();
    AppMethodBeat.o(38451);
  }
  
  private void fNn()
  {
    AppMethodBeat.i(38452);
    if (this.KQo != null) {
      this.KQo.bEn();
    }
    AppMethodBeat.o(38452);
  }
  
  private void fNo()
  {
    AppMethodBeat.i(38456);
    int i = 0;
    while (i < getChildCount())
    {
      getChildAt(i).setTranslationY(0.0F);
      i += 1;
    }
    this.KQI = 0.0F;
    invalidate();
    AppMethodBeat.o(38456);
  }
  
  private void fNp()
  {
    AppMethodBeat.i(38461);
    ae.d("MicroMsg.ConversationWithAppBrandListView", "alvinluo resetAppBrandHeaderBg");
    if (this.mLJ != null)
    {
      int i = this.nbm.getResources().getColor(2131099934);
      this.mLJ.setColor(i);
    }
    AppMethodBeat.o(38461);
  }
  
  private boolean fNq()
  {
    AppMethodBeat.i(38467);
    if (this.KQi != null)
    {
      if ((yJ(true)) && (this.KQi.getVisibility() == 0))
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
    this.KPX = new View(getContext());
    this.KPX.setLayoutParams(new LinearLayout.LayoutParams(-1, 0));
    localLinearLayout.addView(this.KPX);
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
    if ((this.KQh != null) && (this.KQH != 0))
    {
      f2 = 1.0F - Math.abs(this.KQh.getTop() * 1.0F) / this.KQH;
      if (f2 >= 0.0F) {
        break label122;
      }
    }
    for (;;)
    {
      ae.d("MicroMsg.ConversationWithAppBrandListView", "alvinluo header top: %d, header bottom: %d, ratio: %f, appBrandHeight: %d", new Object[] { Integer.valueOf(this.KQh.getTop()), Integer.valueOf(this.KQh.getBottom()), Float.valueOf(f1), Integer.valueOf(this.KQH) });
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
    if (this.KQt == 0)
    {
      View localView = getRootView().findViewById(2131301338);
      if (localView != null)
      {
        ae.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo initTabViewHeight tabView.getHeight: %d", new Object[] { Integer.valueOf(localView.getHeight()) });
        this.KQt = localView.getHeight();
      }
    }
    int i = this.KQt;
    AppMethodBeat.o(38435);
    return i;
  }
  
  private void setEmptyViewVisible(boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(38438);
    ae.i("MicroMsg.ConversationWithAppBrandListView", "[setEmptyViewVisible] isShow:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    View localView;
    if (this.GG != null)
    {
      localView = this.GG;
      if (paramBoolean)
      {
        i = 0;
        localView.setVisibility(i);
      }
    }
    else if (this.KQi != null)
    {
      localView = this.KQi.findViewById(2131296899);
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
    this.KQM = paramBoolean;
  }
  
  private void yF(boolean paramBoolean)
  {
    AppMethodBeat.i(38434);
    if ((this.KPX == null) || (!yJ(true)))
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
    fNi();
    AppMethodBeat.o(38434);
  }
  
  private void yG(boolean paramBoolean)
  {
    AppMethodBeat.i(38437);
    if (paramBoolean)
    {
      com.tencent.mm.sdk.platformtools.ar.ay(this.KQG);
      AppMethodBeat.o(38437);
      return;
    }
    com.tencent.mm.sdk.platformtools.ar.ay(this.KQG);
    com.tencent.mm.sdk.platformtools.ar.o(this.KQG, 1000L);
    AppMethodBeat.o(38437);
  }
  
  private void yH(boolean paramBoolean)
  {
    AppMethodBeat.i(38459);
    if ((paramBoolean) && (this.KQP != null))
    {
      com.tencent.mm.sdk.platformtools.ar.ay(this.KQP);
      this.KQP = null;
      if (this.KQO)
      {
        yI(false);
        AppMethodBeat.o(38459);
      }
    }
    else if ((!paramBoolean) && (this.KQP == null))
    {
      ConversationWithAppBrandListView.13 local13 = new ConversationWithAppBrandListView.13(this);
      this.KQP = local13;
      com.tencent.mm.sdk.platformtools.ar.o(local13, 3000L);
    }
    AppMethodBeat.o(38459);
  }
  
  private void yI(boolean paramBoolean)
  {
    AppMethodBeat.i(38460);
    ae.i("MicroMsg.ConversationWithAppBrandListView", "[showTipWithAnim] isShow:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.KQO = true;
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
      if (this.neB != null) {
        this.neB.bGw();
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
  
  private boolean yJ(boolean paramBoolean)
  {
    AppMethodBeat.i(38466);
    if (((!this.hasInit) || (!paramBoolean)) && (g.ab(d.class) != null))
    {
      g.ab(d.class);
      this.KQk = true;
      ae.i("MicroMsg.ConversationWithAppBrandListView", "[isAppBrandHeaderEnable] :%s", new Object[] { Boolean.valueOf(this.KQk) });
      this.hasInit = true;
    }
    paramBoolean = this.KQk;
    AppMethodBeat.o(38466);
    return paramBoolean;
  }
  
  public void addHeaderView(View paramView, Object paramObject, boolean paramBoolean)
  {
    AppMethodBeat.i(38428);
    ListView.FixedViewInfo localFixedViewInfo = new ListView.FixedViewInfo(this);
    localFixedViewInfo.view = paramView;
    localFixedViewInfo.data = paramObject;
    localFixedViewInfo.isSelectable = paramBoolean;
    this.KPt.add(localFixedViewInfo);
    if (getAdapter() != null) {
      super.addHeaderView(localFixedViewInfo.view, localFixedViewInfo.data, localFixedViewInfo.isSelectable);
    }
    ae.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo addHeaderView %d", new Object[] { Integer.valueOf(this.KPt.size()) });
    AppMethodBeat.o(38428);
  }
  
  public final void ap(long paramLong, int paramInt)
  {
    AppMethodBeat.i(38431);
    ae.i("MicroMsg.ConversationWithAppBrandListView", "[hideAppBrandRecentView] delay:%s, type: %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    if (!yJ(true))
    {
      if (this.KQi != null) {
        this.KQi.setVisibility(8);
      }
      AppMethodBeat.o(38431);
      return;
    }
    if (getFirstVisiblePosition() != 0)
    {
      AppMethodBeat.o(38431);
      return;
    }
    if ((this.neB != null) && (this.KQo != null))
    {
      this.neB.Q(this.KQo.getRecentAppBrandCount(), this.KQo.getStarAppBrandCount(), paramInt);
      this.KQo.wo(paramInt);
    }
    if (paramLong > 0L)
    {
      if (this.KQw != null) {
        removeCallbacks(this.KQw);
      }
      this.KQw = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(38420);
          if (ConversationWithAppBrandListView.c(ConversationWithAppBrandListView.this) != null)
          {
            ae.d("MicroMsg.ConversationWithAppBrandListView", "alvinluo resetToFirstPage");
            ConversationWithAppBrandListView.c(ConversationWithAppBrandListView.this).bEl();
          }
          if (ConversationWithAppBrandListView.d(ConversationWithAppBrandListView.this) != null)
          {
            localObject = ConversationWithAppBrandListView.d(ConversationWithAppBrandListView.this);
            com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.ahE(), "com/tencent/mm/ui/conversation/ConversationWithAppBrandListView$9", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
            ((AppBrandRecentView)localObject).smoothScrollToPosition(((Integer)locala.mt(0)).intValue());
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
      postDelayed(this.KQw, paramLong);
    }
    for (;;)
    {
      fNo();
      AppMethodBeat.o(38431);
      return;
      if (this.KQo != null) {
        this.KQo.bEl();
      }
      if (this.KQj != null)
      {
        AppBrandRecentView localAppBrandRecentView = this.KQj;
        com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(localAppBrandRecentView, locala.ahE(), "com/tencent/mm/ui/conversation/ConversationWithAppBrandListView", "hideAppBrandRecentView", "(JI)V", "Undefined", "smoothScrollToPosition", "(I)V");
        localAppBrandRecentView.smoothScrollToPosition(((Integer)locala.mt(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(localAppBrandRecentView, "com/tencent/mm/ui/conversation/ConversationWithAppBrandListView", "hideAppBrandRecentView", "(JI)V", "Undefined", "smoothScrollToPosition", "(I)V");
      }
      setSelection(0);
      ae.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo resetAppBrandHeaderBg");
      fNp();
    }
  }
  
  public boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    AppMethodBeat.i(38447);
    if ((yJ(true)) && (getFirstVisiblePosition() == 0) && (paramInt2 < 0))
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
        this.pRK = f;
        this.yzV = f;
        f = paramMotionEvent.getY();
        this.pRL = f;
        this.ncP = f;
      }
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      return bool;
    }
    finally
    {
      this.pRK = paramMotionEvent.getX();
      this.pRL = paramMotionEvent.getY();
      AppMethodBeat.o(38448);
    }
  }
  
  public int getFirstHeaderVisible()
  {
    AppMethodBeat.i(38465);
    Iterator localIterator = this.KPt.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      ListView.FixedViewInfo localFixedViewInfo = (ListView.FixedViewInfo)localIterator.next();
      if (localFixedViewInfo.view == this.KQh)
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
              ae.i("MicroMsg.ConversationWithAppBrandListView", "[getFirstHeaderVisible] index:%s", new Object[] { Integer.valueOf(i) });
              AppMethodBeat.o(38465);
              return i;
            }
            j += 1;
          }
        }
        i += 1;
      }
    }
    ae.i("MicroMsg.ConversationWithAppBrandListView", "[getFirstHeaderVisible] index:%s, size: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(this.KPt.size()) });
    AppMethodBeat.o(38465);
    return i;
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(38426);
    super.onConfigurationChanged(paramConfiguration);
    ae.i("MicroMsg.ConversationWithAppBrandListView", "[onConfigurationChanged] orientation:%s", new Object[] { Integer.valueOf(paramConfiguration.orientation) });
    this.KQE = true;
    yF(true);
    if (this.KQo != null) {
      this.KQo.e(paramConfiguration);
    }
    this.KQx = false;
    AppMethodBeat.o(38426);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(38457);
    super.onDraw(paramCanvas);
    if ((getFirstVisiblePosition() == 0) && (this.KQh != null))
    {
      paramCanvas.drawRect(0.0F, 0.0F, getWidth(), this.KQh.getBottom() + this.KQI, this.mLJ);
      if (getChildAt(1) != null) {
        if ((getHeight() == 0) || (!this.KQO)) {
          break label150;
        }
      }
    }
    label150:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        float f1 = (getWidth() - this.KQn) / 2.0F;
        float f2 = this.KQh.getBottom();
        float f3 = this.KQI;
        float f4 = getResources().getDimension(2131165489);
        paramCanvas.drawText(this.KQm, f1, f2 + f3 - f4, this.KQl);
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
      this.ass = paramMotionEvent.getPointerId(0);
      this.ast = ((int)(paramMotionEvent.getX() + 0.5F));
      this.asu = ((int)(paramMotionEvent.getY() + 0.5F));
      bool = super.onInterceptTouchEvent(paramMotionEvent);
      AppMethodBeat.o(38427);
      return bool;
    case 5: 
      this.ass = paramMotionEvent.getPointerId(j);
      this.ast = ((int)(paramMotionEvent.getX(j) + 0.5F));
      this.asu = ((int)(paramMotionEvent.getY(j) + 0.5F));
      bool = super.onInterceptTouchEvent(paramMotionEvent);
      AppMethodBeat.o(38427);
      return bool;
    }
    j = paramMotionEvent.findPointerIndex(this.ass);
    if (j < 0)
    {
      AppMethodBeat.o(38427);
      return false;
    }
    i = (int)(paramMotionEvent.getX(j) + 0.5F);
    int k = (int)(paramMotionEvent.getY(j) + 0.5F);
    j = this.ast;
    k -= this.asu;
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
    if ((paramBoolean) && (yJ(true)))
    {
      if (this.cBE)
      {
        yF(true);
        post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(38416);
            ConversationWithAppBrandListView.this.setSelection(0);
            AppMethodBeat.o(38416);
          }
        });
        this.KQD = paramInt4;
        this.cBE = false;
        AppMethodBeat.o(38425);
        return;
      }
      if ((!this.dus) && (this.KQD != paramInt4))
      {
        ae.i("MicroMsg.ConversationWithAppBrandListView", "[onLayout] mLastBottom:" + this.KQD + " b:" + paramInt4);
        yF(true);
        this.KQD = paramInt4;
      }
    }
    AppMethodBeat.o(38425);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(38439);
    super.onMeasure(paramInt1, paramInt2);
    fNk();
    AppMethodBeat.o(38439);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(38463);
    if (this.vwl != null) {
      this.vwl.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
    if (!yJ(true))
    {
      AppMethodBeat.o(38463);
      return;
    }
    fNk();
    if (this.KQH == 0)
    {
      AppMethodBeat.o(38463);
      return;
    }
    ae.v("MicroMsg.ConversationWithAppBrandListView", "alvinluo onScroll firstVisibleItem: %d, visibleItemCount: %d, totalItemCount: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    float f1;
    View localView;
    label278:
    GyroView localGyroView;
    if (paramInt1 == 0)
    {
      float f2 = getRatio();
      if ((this.KQy == 0.0F) || (this.KQy == 1.0F) || (Math.abs(f2 - this.KQy) >= 0.01D))
      {
        this.KQy = f2;
        f1 = f2;
        if (this.KQh != null)
        {
          if ((this.KQh.getTop() != 0) || (this.KQx)) {
            break label278;
          }
          f1 = 0.0F;
        }
      }
      for (;;)
      {
        if (this.KQz != null)
        {
          paramInt2 = this.KQz.aO(f1);
          if (this.mLJ != null) {
            this.mLJ.setColor(paramInt2);
          }
          if (this.KQi != null) {
            this.KQi.setBackgroundColor(paramInt2);
          }
        }
        yG(false);
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
        if (this.KQh.getTop() != 0)
        {
          this.KQx = true;
          f1 = f2;
        }
      }
      localGyroView = ((HeaderContainer)paramAbsListView).getGyroView();
      ae.v("MicroMsg.ConversationWithAppBrandListView", "alvinluo appBrandHeaderTransH: %s, emptyTransH: %s, headerParent.bottom: %s, translationY: %f, mAppBrandHeight: %d", new Object[] { Float.valueOf(this.KQr), Float.valueOf(this.KQs), Integer.valueOf(paramAbsListView.getBottom()), Float.valueOf(localView.getTranslationY()), Integer.valueOf(this.KQH) });
      if (paramAbsListView.getBottom() <= 3)
      {
        if (!this.dux)
        {
          localView.setTranslationY(this.KQr);
          if (localGyroView.getVisibility() == 0)
          {
            localGyroView.setVerticalScroll(0.0F);
            localGyroView.setVisibility(8);
          }
          this.KQS = false;
        }
      }
      else
      {
        if ((paramAbsListView.getBottom() <= 3) || (paramAbsListView.getBottom() > this.nhJ) || ((localView.getTranslationY() == 0.0F) && ((this.GG == null) || (this.GG.getTranslationY() == 0.0F)))) {
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
      this.KQT = paramInt1;
      if ((this.KQR) && (this.nat) && (paramInt1 == 0))
      {
        ae.e("MicroMsg.ConversationWithAppBrandListView", "[Stop fling!]");
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
              ae.i("MicroMsg.ConversationWithAppBrandListView", "[smoothScrollBy] offset: ".concat(String.valueOf(i)));
              ConversationWithAppBrandListView.this.smoothScrollToPositionFromTop(ConversationWithAppBrandListView.this.getFirstHeaderVisible(), 0, 300);
              ConversationWithAppBrandListView.q(ConversationWithAppBrandListView.this);
              AppMethodBeat.o(38414);
              return;
            }
          }
        });
        this.KQR = false;
      }
      com.tencent.mm.sdk.platformtools.ar.ay(this.KQQ);
      com.tencent.mm.sdk.platformtools.ar.o(this.KQQ, 50L);
      AppMethodBeat.o(38463);
      return;
      if (this.GG != null) {
        this.GG.setTranslationY(this.KQs);
      }
      localView.setTranslationY(0.0F);
      break;
      label637:
      if ((paramAbsListView.getBottom() > this.nhJ) && ((localView.getTranslationY() != 0.0F) || ((this.GG != null) && (this.GG.getTranslationY() != 0.0F))))
      {
        f1 = (float)(1.0D * (paramAbsListView.getBottom() - this.nhJ) / (this.KQH - this.nhJ));
        ae.v("MicroMsg.ConversationWithAppBrandListView", "alvinluo checkUpAppBrandHeader appbrandHeader translationY: %f, percent: %f, setTranslationY: %f, isEmpty: %b", new Object[] { Float.valueOf(localView.getTranslationY()), Float.valueOf(f1), Float.valueOf(this.KQr * (1.0F - f1)), Boolean.valueOf(this.dux) });
        if (!this.dux) {
          localView.setTranslationY(this.KQr * (1.0F - f1));
        }
        for (;;)
        {
          localGyroView.setTranslationY(-this.nhJ / 2.0F + localGyroView.getHeight() / 2 + (this.nhJ / 2.0F + localGyroView.getHeight()) * f1);
          localGyroView.setAlpha(1.0F - 2.0F * f1);
          if ((!this.KQS) && (1.0F != f1))
          {
            this.mZD.vibrate(10L);
            this.KQS = true;
          }
          yG(true);
          break;
          if (this.GG != null)
          {
            ae.v("MicroMsg.ConversationWithAppBrandListView", "alvinluo emptyView translationY: %f, set: %f", new Object[] { Float.valueOf(this.GG.getTranslationY()), Float.valueOf(-this.KQs * (1.0F - f1)) });
            this.GG.setTranslationY(this.KQs * (1.0F - f1));
          }
          localView.setTranslationY(0.0F);
        }
        if (this.KQh != null)
        {
          paramAbsListView = this.KQh.findViewById(2131296898);
          if (this.dux) {
            break label1011;
          }
          if (paramAbsListView != null) {
            paramAbsListView.setTranslationY(this.KQr);
          }
        }
        for (;;)
        {
          if ((this.KQT != 0) || (paramInt1 == 0)) {
            break label1039;
          }
          afd(4);
          yH(true);
          yG(true);
          break;
          if (this.GG != null) {
            this.GG.setTranslationY(this.KQs);
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
    if (this.vwl != null) {
      this.vwl.onScrollStateChanged(paramAbsListView, paramInt);
    }
    if ((getFirstVisiblePosition() != 0) && (paramInt == 2) && (!this.KQN)) {
      this.nat = true;
    }
    AppMethodBeat.o(38458);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(38449);
    boolean bool;
    if (!yJ(true))
    {
      bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(38449);
      return bool;
    }
    if (paramMotionEvent.getAction() == 0) {
      if (getFirstVisiblePosition() != 0) {
        this.KQR = true;
      }
    }
    for (;;)
    {
      if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
      {
        yG(true);
        this.KQK = false;
        if (getChildTranslationY() > 0.0F) {
          fNm();
        }
      }
      if (ac(paramMotionEvent)) {
        break;
      }
      if ((this.KQK) && (paramMotionEvent.getAction() == 2))
      {
        paramMotionEvent.setAction(0);
        super.onTouchEvent(paramMotionEvent);
        paramMotionEvent.setAction(2);
        this.KQK = false;
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
        if ((Math.abs(paramMotionEvent.getX() - this.pRK) < 3.0F) && (Math.abs(paramMotionEvent.getY() - this.pRL) < 3.0F)) {
          super.onTouchEvent(paramMotionEvent);
        }
        if (getChildTranslationY() < 60.0F * getResources().getDisplayMetrics().density)
        {
          float f1 = Math.abs(paramMotionEvent.getX() - this.yzV);
          float f2 = Math.abs(paramMotionEvent.getY() - this.ncP);
          if (((paramMotionEvent.getY() - this.ncP < -5.0F) && (f1 - f2 < 0.0F) && (getFirstVisiblePosition() == 0)) || ((localView.getBottom() > 0) && (localView.getBottom() < this.nhJ))) {
            afd(4);
          } else if ((localView.getBottom() >= this.nhJ) && (paramMotionEvent.getY() - this.ncP > 5.0F)) {
            fNm();
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
      if ((paramMotionEvent.getAction() == 2) && (!this.KQK) && (Math.abs(paramMotionEvent.getY() - this.pRL) > 2.0F))
      {
        paramMotionEvent.setAction(3);
        super.onTouchEvent(paramMotionEvent);
        this.KQK = true;
      }
      else if (!this.KQK)
      {
        super.onTouchEvent(paramMotionEvent);
      }
    }
  }
  
  public void setActionBarUpdateCallback(com.tencent.mm.plugin.appbrand.widget.header.a parama)
  {
    this.KQv = parama;
  }
  
  public void setActivity(MMFragmentActivity paramMMFragmentActivity)
  {
    AppMethodBeat.i(38424);
    this.nbm = paramMMFragmentActivity;
    fNl();
    AppMethodBeat.o(38424);
  }
  
  public void setAdapter(final ListAdapter paramListAdapter)
  {
    AppMethodBeat.i(38423);
    ae.i("MicroMsg.ConversationWithAppBrandListView", "[init] ");
    this.KQF.alive();
    this.mZD = ((Vibrator)getContext().getSystemService("vibrator"));
    this.mTouchSlop = u.a(ViewConfiguration.get(getContext()));
    this.mLJ = new Paint(1);
    this.KQl = new Paint(1);
    this.mLJ.setColor(getResources().getColor(2131099955));
    this.KQl.setColor(-2147483648);
    this.KQl.setTextSize(getResources().getDimension(2131165576));
    yJ(false);
    if (g.ab(d.class) != null) {
      this.neB = ((d)g.ab(d.class)).bCW();
    }
    this.nhJ = (100.0F * getResources().getDisplayMetrics().density);
    ae.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo init mAnimationPadding: %f, density: %f", new Object[] { Float.valueOf(this.nhJ), Float.valueOf(getResources().getDisplayMetrics().density) });
    this.KQm = getResources().getString(2131757945);
    this.KQn = this.KQl.measureText(this.KQm);
    super.setOnScrollListener(this);
    paramListAdapter.registerDataSetObserver(new DataSetObserver()
    {
      int KQW = -1;
      
      public final void onChanged()
      {
        AppMethodBeat.i(38406);
        boolean bool;
        if (this.KQW != paramListAdapter.getCount())
        {
          if (this.KQW <= paramListAdapter.getCount()) {
            break label108;
          }
          bool = true;
          ae.i("MicroMsg.ConversationWithAppBrandListView", "[onChanged] isDelete:%s", new Object[] { Boolean.valueOf(bool) });
          if (this.KQW <= paramListAdapter.getCount()) {
            break label113;
          }
          ConversationWithAppBrandListView.a(ConversationWithAppBrandListView.this, false);
          ConversationWithAppBrandListView.a(ConversationWithAppBrandListView.this, true);
        }
        for (;;)
        {
          this.KQW = paramListAdapter.getCount();
          AppMethodBeat.o(38406);
          return;
          label108:
          bool = false;
          break;
          label113:
          ConversationWithAppBrandListView.a(ConversationWithAppBrandListView.this);
        }
      }
    });
    try
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)getLayoutParams();
      localLayoutParams.topMargin = com.tencent.mm.ui.ar.dX(getContext());
      ae.i("MicroMsg.ConversationWithAppBrandListView", "[initLayoutParams]1 ActionBar height:%s", new Object[] { Integer.valueOf(localLayoutParams.topMargin) });
      if (localLayoutParams.topMargin <= 0) {
        postDelayed(new ConversationWithAppBrandListView.19(this, localLayoutParams), 200L);
      }
      if (this.nbm != null) {
        fNl();
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
        ae.printErrStackTrace("MicroMsg.ConversationWithAppBrandListView", localException, "alvinluo initLayoutParams exception", new Object[0]);
      }
    }
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    AppMethodBeat.i(38429);
    super.setOnItemClickListener(new ConversationWithAppBrandListView.22(this, paramOnItemClickListener));
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
    this.vwl = paramOnScrollListener;
  }
  
  public void setSelection(int paramInt)
  {
    AppMethodBeat.i(38443);
    ae.i("MicroMsg.ConversationWithAppBrandListView", "[setSelection] position:%s", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt == 0) && (yJ(true)))
    {
      paramInt = getFirstHeaderVisible();
      ae.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo setSelection pos: %d, appbrandHeight: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.KQH) });
      super.setSelection(paramInt);
      if ((this.neB != null) && (this.KQo != null))
      {
        this.neB.Q(this.KQo.getRecentAppBrandCount(), this.KQo.getStarAppBrandCount(), 7);
        this.KQo.wo(7);
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
    ae.d("MicroMsg.ConversationWithAppBrandListView", "[smoothScrollToPosition] position:%s", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt == 0) && (yJ(true)))
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
    ae.d("MicroMsg.ConversationWithAppBrandListView", "[smoothScrollToPositionFromTop] position:%s offset:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    final int i = paramInt1;
    if (paramInt1 == 0)
    {
      i = paramInt1;
      if (yJ(true)) {
        i = getFirstHeaderVisible();
      }
    }
    com.tencent.mm.sdk.platformtools.ar.o(new Runnable()
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
    ae.d("MicroMsg.ConversationWithAppBrandListView", "[smoothScrollToPositionFromTop] position:%s offset:%s duration:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt1 == 0) && (yJ(true)))
    {
      super.smoothScrollToPositionFromTop(getFirstHeaderVisible(), paramInt2, paramInt3);
      AppMethodBeat.o(38446);
      return;
    }
    super.smoothScrollToPositionFromTop(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(38446);
  }
  
  public final void uT(int paramInt)
  {
    AppMethodBeat.i(38432);
    ae.i("MicroMsg.ConversationWithAppBrandListView", "[next] size:%s isAppBrandHeaderEnable:%s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.KQk) });
    if (!yJ(true))
    {
      ae.w("MicroMsg.ConversationWithAppBrandListView", "[next] is disable!");
      if (this.KQi != null) {
        this.KQi.setVisibility(8);
      }
      AppMethodBeat.o(38432);
      return;
    }
    if ((paramInt == 1) && (this.KQi != null)) {
      setEmptyViewVisible(true);
    }
    for (;;)
    {
      if ((this.KQi != null) && (this.KQi.getVisibility() == 8))
      {
        this.KQi.setVisibility(0);
        setSelection(getFirstVisiblePosition());
      }
      AppMethodBeat.o(38432);
      return;
      if ((paramInt > 1) && (this.KQi != null)) {
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
        ae.i("MicroMsg.ConversationWithAppBrandListView", "[UpAppBrandHeaderTask] run...");
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
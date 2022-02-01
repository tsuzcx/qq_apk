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
import com.tencent.mm.g.a.kc;
import com.tencent.mm.g.a.lq;
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
import com.tencent.mm.ui.ar;
import java.util.Iterator;
import java.util.LinkedList;

public class ConversationWithAppBrandListView
  extends ListView
  implements AbsListView.OnScrollListener, AppBrandRecentView.e
{
  private View GG;
  private LinkedList<ListView.FixedViewInfo> KsZ;
  private View KtD;
  private HeaderContainer KtN;
  private View KtO;
  private AppBrandRecentView KtP;
  private boolean KtQ;
  private Paint KtR;
  private String KtS;
  private float KtT;
  private com.tencent.mm.plugin.appbrand.widget.header.a.a KtU;
  private boolean KtV;
  private boolean KtW;
  private float KtX;
  private float KtY;
  private int KtZ;
  private boolean Kua;
  private com.tencent.mm.plugin.appbrand.widget.header.a Kub;
  private Runnable Kuc;
  private boolean Kud;
  private float Kue;
  private com.tencent.mm.plugin.appbrand.widget.header.b Kuf;
  private com.tencent.mm.plugin.appbrand.widget.header.b Kug;
  private com.tencent.mm.plugin.appbrand.widget.header.b Kuh;
  private com.tencent.mm.sdk.b.c<lq> Kui;
  private int Kuj;
  boolean Kuk;
  private final com.tencent.mm.sdk.b.c<kc> Kul;
  private a Kum;
  private int Kun;
  private float Kuo;
  private float Kup;
  private boolean Kuq;
  private boolean Kur;
  private boolean Kus;
  private boolean Kut;
  private boolean Kuu;
  private Runnable Kuv;
  private Runnable Kuw;
  private boolean Kux;
  private boolean Kuy;
  private int Kuz;
  private int ass;
  private int ast;
  private int asu;
  private boolean cAX;
  private ValueAnimator cPJ;
  private boolean dtm;
  private boolean dtr;
  private boolean hasInit;
  private Paint mGF;
  private int mTouchSlop;
  private Vibrator mUw;
  private boolean mVn;
  private GyroView mVu;
  private MMFragmentActivity mWg;
  private float mXI;
  private com.tencent.mm.plugin.appbrand.widget.recentview.b mZt;
  private float ncA;
  private float pLf;
  private float pLg;
  private AbsListView.OnScrollListener vkg;
  private float yjW;
  
  public ConversationWithAppBrandListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(38422);
    this.KsZ = new LinkedList();
    this.KtQ = false;
    this.KtV = false;
    this.KtW = false;
    this.dtr = false;
    this.KtX = 0.0F;
    this.KtY = 0.0F;
    this.KtZ = 0;
    this.Kua = false;
    this.Kuc = null;
    this.Kud = true;
    this.Kue = 0.0F;
    this.Kuf = null;
    this.Kug = null;
    this.Kuh = null;
    this.Kui = new ConversationWithAppBrandListView.1(this);
    this.cAX = true;
    this.Kuj = 0;
    this.Kuk = false;
    this.ass = -1;
    this.Kul = new com.tencent.mm.sdk.b.c() {};
    this.Kum = new a();
    this.Kun = 0;
    this.Kuo = 0.0F;
    this.Kup = 0.0F;
    this.Kur = false;
    this.Kut = false;
    this.Kuu = false;
    this.Kuw = new Runnable()
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
    this.mVn = false;
    this.Kux = false;
    this.Kuy = false;
    this.hasInit = false;
    this.Kuf = new com.tencent.mm.plugin.appbrand.widget.header.b(getContext().getResources().getColor(2131099648), getContext().getResources().getColor(2131099928));
    this.Kui.alive();
    AppMethodBeat.o(38422);
  }
  
  private boolean ae(MotionEvent paramMotionEvent)
  {
    int j = 0;
    AppMethodBeat.i(38450);
    if (!fIZ())
    {
      AppMethodBeat.o(38450);
      return false;
    }
    if (paramMotionEvent.getAction() == 0)
    {
      this.Kup = paramMotionEvent.getY();
      if (this.cPJ != null) {
        this.cPJ.cancel();
      }
    }
    float f3;
    try
    {
      if (((paramMotionEvent.getAction() != 2) || (Math.abs(paramMotionEvent.getY() - this.pLg) <= 2.0F) || (getFirstVisiblePosition() != 0) || (this.KtN.getTop() != 0)) && (getChildTranslationY() == 0.0F)) {
        break label582;
      }
      yt(true);
      if ((getHeight() - getTabViewHeight() - this.Kun) / 2 <= this.Kuo) {
        yu(false);
      }
      for (;;)
      {
        float f1 = paramMotionEvent.getY();
        float f2 = this.Kup;
        f3 = getHeight() - getTabViewHeight() - this.Kun;
        this.Kuo = ((f1 - f2) * 0.4F + this.Kuo);
        if (this.Kuo >= 0.0F) {
          break label488;
        }
        this.Kuo = 0.0F;
        fIX();
        invalidate();
        return false;
        if (paramMotionEvent.getActionMasked() == 5)
        {
          this.Kup = paramMotionEvent.getY();
          break;
        }
        if (((paramMotionEvent.getAction() != 1) && (paramMotionEvent.getAction() != 3)) || (this.KtN.getTop() != 0) || (getChildTranslationY() == 0.0F)) {
          break;
        }
        yu(true);
        this.Kur = false;
        ad.d("MicroMsg.ConversationWithAppBrandListView", "[animationChild] offset:%s delay:%s duration%s", new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(180) });
        if (!fIZ()) {
          break;
        }
        if (this.cPJ != null) {
          this.cPJ.cancel();
        }
        this.cPJ = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("deltaY", new float[] { getChildTranslationY() + 0.0F, 0.0F }), PropertyValuesHolder.ofFloat("headerDeltaY", new float[] { getHeaderY() + 0.0F, 0.0F }) });
        this.cPJ.setDuration(180L);
        this.cPJ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
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
        this.cPJ.addListener(new ConversationWithAppBrandListView.12(this));
        this.cPJ.setStartDelay(0L);
        this.cPJ.start();
        break;
        yu(true);
      }
      i = j;
    }
    finally
    {
      this.Kup = paramMotionEvent.getY();
      AppMethodBeat.o(38450);
    }
    label488:
    int i;
    if (f3 < this.Kuo)
    {
      this.Kuo = f3;
      i = j;
    }
    for (;;)
    {
      if (i < getChildCount())
      {
        if (i == 0) {
          getChildAt(i).setTranslationY(this.Kuo * 0.5F);
        } else {
          getChildAt(i).setTranslationY(this.Kuo);
        }
      }
      else
      {
        invalidate();
        this.Kup = paramMotionEvent.getY();
        AppMethodBeat.o(38450);
        return true;
        label582:
        this.Kup = paramMotionEvent.getY();
        AppMethodBeat.o(38450);
        return false;
      }
      i += 1;
    }
  }
  
  private void aeu(int paramInt)
  {
    AppMethodBeat.i(38453);
    ad.i("MicroMsg.ConversationWithAppBrandListView", "[closeAppBrandRecentView] isOpenAppBrandRecentView:%s type:%s", new Object[] { Boolean.valueOf(this.Kus), Integer.valueOf(paramInt) });
    if ((this.Kus) && (getChildAt(0) != null) && (this.mZt != null) && (this.KtU != null))
    {
      this.mZt.Q(this.KtU.getRecentAppBrandCount(), this.KtU.getStarAppBrandCount(), paramInt);
      this.KtU.wj(paramInt);
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
      fIX();
      yt(true);
      setOpenAppBrandRecentView(false);
      aq.o(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(38404);
          if (ConversationWithAppBrandListView.c(ConversationWithAppBrandListView.this) != null)
          {
            ad.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo scrollToFirstPage");
            ConversationWithAppBrandListView.c(ConversationWithAppBrandListView.this).bDt();
          }
          AppMethodBeat.o(38404);
        }
      }, 500L);
      AppMethodBeat.o(38453);
      return;
    }
  }
  
  private float aev(int paramInt)
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
  
  private void fIR()
  {
    boolean bool = false;
    AppMethodBeat.i(38436);
    int j = getFirstHeaderVisible();
    localLayoutParams = (LinearLayout.LayoutParams)this.KtD.getLayoutParams();
    int k = localLayoutParams.height;
    for (;;)
    {
      try
      {
        if (getAdapter() != null) {
          continue;
        }
        i = 0;
        f1 = aev(i);
      }
      catch (Exception localException)
      {
        int i;
        float f2;
        float f1 = 0.0F;
        continue;
        localLayoutParams.height = ((int)f2);
        if (!this.cAX) {
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
        this.KtD.setLayoutParams(localLayoutParams);
        if (!this.cAX) {
          super.setSelection(j);
        }
      }
      AppMethodBeat.o(38436);
      return;
      i = getAdapter().getCount();
    }
  }
  
  private boolean fIS()
  {
    AppMethodBeat.i(38440);
    if ((this.KtO != null) && (this.KtU != null))
    {
      int i = this.KtN.getMeasuredHeight();
      if ((i != 0) && (i != this.Kun))
      {
        this.Kun = i;
        AppMethodBeat.o(38440);
        return true;
      }
    }
    AppMethodBeat.o(38440);
    return false;
  }
  
  private void fIT()
  {
    AppMethodBeat.i(38441);
    if (fIS())
    {
      if (this.mVu != null) {
        this.mVu.setVisibility(0);
      }
      this.KtX = (-(this.ncA - getResources().getDimension(2131165484)));
      this.KtY = (-(this.ncA - (this.Kun / 2 - getResources().getDimension(2131165467))));
      if (!this.dtr)
      {
        if (this.KtO != null) {
          this.KtO.setTranslationY(this.KtX);
        }
        if (this.GG != null) {
          this.GG.setTranslationY(0.0F);
        }
        ad.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo initAppBrandHeaderHeight AppBrandHeader appBrandHeight: %d, setTranslationY: %s", new Object[] { Integer.valueOf(this.Kun), Float.valueOf(this.KtX) });
        AppMethodBeat.o(38441);
        return;
      }
      if (this.KtO != null) {
        this.KtO.setTranslationY(0.0F);
      }
      if (this.GG != null) {
        this.GG.setTranslationY(this.KtY);
      }
      ad.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo initAppBrandHeaderHeight emptyView appBrandHeight: %d, setTranslationY: %s", new Object[] { Integer.valueOf(this.Kun), Float.valueOf(this.KtY) });
    }
    AppMethodBeat.o(38441);
  }
  
  private void fIU()
  {
    AppMethodBeat.i(38442);
    if (this.Kua)
    {
      AppMethodBeat.o(38442);
      return;
    }
    if (g.ab(d.class) != null)
    {
      this.KtN = ((d)g.ab(d.class)).dU(this.mWg);
      this.Kua = true;
      this.KtN.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
      this.KtO = this.KtN.findViewById(2131296898);
      this.KtO.setVisibility(8);
      this.mVu = this.KtN.getGyroView();
      this.KtU = this.KtN.getHeaderView();
      this.KtU.setCollectionRefreshListener(new AppBrandRecentView.e()
      {
        public final void uP(int paramAnonymousInt)
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
      this.KtU.setUsageRefreshListener(new AppBrandRecentView.e()
      {
        public final void uP(int paramAnonymousInt)
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
      this.KtU.setIOnLaunchUIListener(new a.b()
      {
        public final void bDF()
        {
          AppMethodBeat.i(38400);
          ad.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo onLaunchCollectionUI");
          ConversationWithAppBrandListView.this.ao(300L, 10);
          AppMethodBeat.o(38400);
        }
        
        public final void bDG()
        {
          AppMethodBeat.i(38401);
          ad.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo onLaunchUsageUI");
          ConversationWithAppBrandListView.this.ao(300L, 9);
          AppMethodBeat.o(38401);
        }
      });
      this.KtU.setOnEmptyViewListener(new a.a()
      {
        public final void ig(boolean paramAnonymousBoolean)
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
      this.KtU.setReporter(this.mZt);
      this.GG = this.KtN.getEmptyView();
      this.KsZ.remove(this.KtN);
      Object localObject = new ListView.FixedViewInfo(this);
      ((ListView.FixedViewInfo)localObject).view = this.KtN;
      ((ListView.FixedViewInfo)localObject).data = null;
      ((ListView.FixedViewInfo)localObject).isSelectable = true;
      this.KsZ.addFirst(localObject);
      localObject = this.KsZ.iterator();
      while (((Iterator)localObject).hasNext())
      {
        ListView.FixedViewInfo localFixedViewInfo = (ListView.FixedViewInfo)((Iterator)localObject).next();
        super.addHeaderView(localFixedViewInfo.view, localFixedViewInfo.data, localFixedViewInfo.isSelectable);
      }
    }
    ad.e("MicroMsg.ConversationWithAppBrandListView", "alvinluo addAppBrandHalfView error");
    AppMethodBeat.o(38442);
    return;
    this.KtU.refresh();
    AppMethodBeat.o(38442);
  }
  
  private void fIV()
  {
    AppMethodBeat.i(38451);
    if (!this.Kus)
    {
      bd.jc(getContext());
      if ((this.mZt != null) && (this.KtU != null)) {
        this.mZt.eB(this.KtU.getRecentAppBrandCount(), this.KtU.getStarAppBrandCount());
      }
      if (this.KtU != null) {
        this.KtU.bDu();
      }
    }
    if ((this.Kuk) && (this.KtP != null))
    {
      this.KtP.getAdapter().asY.notifyChanged();
      this.Kuk = true;
    }
    super.smoothScrollToPositionFromTop(0, 0, 250);
    yt(true);
    setOpenAppBrandRecentView(true);
    fIW();
    AppMethodBeat.o(38451);
  }
  
  private void fIW()
  {
    AppMethodBeat.i(38452);
    if (this.KtU != null) {
      this.KtU.bDv();
    }
    AppMethodBeat.o(38452);
  }
  
  private void fIX()
  {
    AppMethodBeat.i(38456);
    int i = 0;
    while (i < getChildCount())
    {
      getChildAt(i).setTranslationY(0.0F);
      i += 1;
    }
    this.Kuo = 0.0F;
    invalidate();
    AppMethodBeat.o(38456);
  }
  
  private void fIY()
  {
    AppMethodBeat.i(38461);
    ad.d("MicroMsg.ConversationWithAppBrandListView", "alvinluo resetAppBrandHeaderBg");
    if (this.mGF != null)
    {
      int i = this.mWg.getResources().getColor(2131099934);
      this.mGF.setColor(i);
    }
    AppMethodBeat.o(38461);
  }
  
  private boolean fIZ()
  {
    AppMethodBeat.i(38467);
    if (this.KtO != null)
    {
      if ((yw(true)) && (this.KtO.getVisibility() == 0))
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
    this.KtD = new View(getContext());
    this.KtD.setLayoutParams(new LinearLayout.LayoutParams(-1, 0));
    localLinearLayout.addView(this.KtD);
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
    if ((this.KtN != null) && (this.Kun != 0))
    {
      f2 = 1.0F - Math.abs(this.KtN.getTop() * 1.0F) / this.Kun;
      if (f2 >= 0.0F) {
        break label122;
      }
    }
    for (;;)
    {
      ad.d("MicroMsg.ConversationWithAppBrandListView", "alvinluo header top: %d, header bottom: %d, ratio: %f, appBrandHeight: %d", new Object[] { Integer.valueOf(this.KtN.getTop()), Integer.valueOf(this.KtN.getBottom()), Float.valueOf(f1), Integer.valueOf(this.Kun) });
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
    if (this.KtZ == 0)
    {
      View localView = getRootView().findViewById(2131301338);
      if (localView != null)
      {
        ad.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo initTabViewHeight tabView.getHeight: %d", new Object[] { Integer.valueOf(localView.getHeight()) });
        this.KtZ = localView.getHeight();
      }
    }
    int i = this.KtZ;
    AppMethodBeat.o(38435);
    return i;
  }
  
  private void setEmptyViewVisible(boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(38438);
    ad.i("MicroMsg.ConversationWithAppBrandListView", "[setEmptyViewVisible] isShow:%s", new Object[] { Boolean.valueOf(paramBoolean) });
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
    else if (this.KtO != null)
    {
      localView = this.KtO.findViewById(2131296899);
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
    this.Kus = paramBoolean;
  }
  
  private void ys(boolean paramBoolean)
  {
    AppMethodBeat.i(38434);
    if ((this.KtD == null) || (!yw(true)))
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
    fIR();
    AppMethodBeat.o(38434);
  }
  
  private void yt(boolean paramBoolean)
  {
    AppMethodBeat.i(38437);
    if (paramBoolean)
    {
      aq.aA(this.Kum);
      AppMethodBeat.o(38437);
      return;
    }
    aq.aA(this.Kum);
    aq.o(this.Kum, 1000L);
    AppMethodBeat.o(38437);
  }
  
  private void yu(boolean paramBoolean)
  {
    AppMethodBeat.i(38459);
    if ((paramBoolean) && (this.Kuv != null))
    {
      aq.aA(this.Kuv);
      this.Kuv = null;
      if (this.Kuu)
      {
        yv(false);
        AppMethodBeat.o(38459);
      }
    }
    else if ((!paramBoolean) && (this.Kuv == null))
    {
      ConversationWithAppBrandListView.13 local13 = new ConversationWithAppBrandListView.13(this);
      this.Kuv = local13;
      aq.o(local13, 3000L);
    }
    AppMethodBeat.o(38459);
  }
  
  private void yv(boolean paramBoolean)
  {
    AppMethodBeat.i(38460);
    ad.i("MicroMsg.ConversationWithAppBrandListView", "[showTipWithAnim] isShow:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.Kuu = true;
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
      if (this.mZt != null) {
        this.mZt.bFB();
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
  
  private boolean yw(boolean paramBoolean)
  {
    AppMethodBeat.i(38466);
    if (((!this.hasInit) || (!paramBoolean)) && (g.ab(d.class) != null))
    {
      g.ab(d.class);
      this.KtQ = true;
      ad.i("MicroMsg.ConversationWithAppBrandListView", "[isAppBrandHeaderEnable] :%s", new Object[] { Boolean.valueOf(this.KtQ) });
      this.hasInit = true;
    }
    paramBoolean = this.KtQ;
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
    this.KsZ.add(localFixedViewInfo);
    if (getAdapter() != null) {
      super.addHeaderView(localFixedViewInfo.view, localFixedViewInfo.data, localFixedViewInfo.isSelectable);
    }
    ad.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo addHeaderView %d", new Object[] { Integer.valueOf(this.KsZ.size()) });
    AppMethodBeat.o(38428);
  }
  
  public final void ao(long paramLong, int paramInt)
  {
    AppMethodBeat.i(38431);
    ad.i("MicroMsg.ConversationWithAppBrandListView", "[hideAppBrandRecentView] delay:%s, type: %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    if (!yw(true))
    {
      if (this.KtO != null) {
        this.KtO.setVisibility(8);
      }
      AppMethodBeat.o(38431);
      return;
    }
    if (getFirstVisiblePosition() != 0)
    {
      AppMethodBeat.o(38431);
      return;
    }
    if ((this.mZt != null) && (this.KtU != null))
    {
      this.mZt.Q(this.KtU.getRecentAppBrandCount(), this.KtU.getStarAppBrandCount(), paramInt);
      this.KtU.wj(paramInt);
    }
    if (paramLong > 0L)
    {
      if (this.Kuc != null) {
        removeCallbacks(this.Kuc);
      }
      this.Kuc = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(38420);
          if (ConversationWithAppBrandListView.c(ConversationWithAppBrandListView.this) != null)
          {
            ad.d("MicroMsg.ConversationWithAppBrandListView", "alvinluo resetToFirstPage");
            ConversationWithAppBrandListView.c(ConversationWithAppBrandListView.this).bDt();
          }
          if (ConversationWithAppBrandListView.d(ConversationWithAppBrandListView.this) != null)
          {
            localObject = ConversationWithAppBrandListView.d(ConversationWithAppBrandListView.this);
            com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.ahp(), "com/tencent/mm/ui/conversation/ConversationWithAppBrandListView$9", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
            ((AppBrandRecentView)localObject).smoothScrollToPosition(((Integer)locala.mq(0)).intValue());
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
      postDelayed(this.Kuc, paramLong);
    }
    for (;;)
    {
      fIX();
      AppMethodBeat.o(38431);
      return;
      if (this.KtU != null) {
        this.KtU.bDt();
      }
      if (this.KtP != null)
      {
        AppBrandRecentView localAppBrandRecentView = this.KtP;
        com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(localAppBrandRecentView, locala.ahp(), "com/tencent/mm/ui/conversation/ConversationWithAppBrandListView", "hideAppBrandRecentView", "(JI)V", "Undefined", "smoothScrollToPosition", "(I)V");
        localAppBrandRecentView.smoothScrollToPosition(((Integer)locala.mq(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(localAppBrandRecentView, "com/tencent/mm/ui/conversation/ConversationWithAppBrandListView", "hideAppBrandRecentView", "(JI)V", "Undefined", "smoothScrollToPosition", "(I)V");
      }
      setSelection(0);
      ad.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo resetAppBrandHeaderBg");
      fIY();
    }
  }
  
  public boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    AppMethodBeat.i(38447);
    if ((yw(true)) && (getFirstVisiblePosition() == 0) && (paramInt2 < 0))
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
        this.pLf = f;
        this.yjW = f;
        f = paramMotionEvent.getY();
        this.pLg = f;
        this.mXI = f;
      }
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      return bool;
    }
    finally
    {
      this.pLf = paramMotionEvent.getX();
      this.pLg = paramMotionEvent.getY();
      AppMethodBeat.o(38448);
    }
  }
  
  public int getFirstHeaderVisible()
  {
    AppMethodBeat.i(38465);
    Iterator localIterator = this.KsZ.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      ListView.FixedViewInfo localFixedViewInfo = (ListView.FixedViewInfo)localIterator.next();
      if (localFixedViewInfo.view == this.KtN)
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
    ad.i("MicroMsg.ConversationWithAppBrandListView", "[getFirstHeaderVisible] index:%s, size: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(this.KsZ.size()) });
    AppMethodBeat.o(38465);
    return i;
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(38426);
    super.onConfigurationChanged(paramConfiguration);
    ad.i("MicroMsg.ConversationWithAppBrandListView", "[onConfigurationChanged] orientation:%s", new Object[] { Integer.valueOf(paramConfiguration.orientation) });
    this.Kuk = true;
    ys(true);
    if (this.KtU != null) {
      this.KtU.e(paramConfiguration);
    }
    this.Kud = false;
    AppMethodBeat.o(38426);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(38457);
    super.onDraw(paramCanvas);
    if ((getFirstVisiblePosition() == 0) && (this.KtN != null))
    {
      paramCanvas.drawRect(0.0F, 0.0F, getWidth(), this.KtN.getBottom() + this.Kuo, this.mGF);
      if (getChildAt(1) != null) {
        if ((getHeight() == 0) || (!this.Kuu)) {
          break label150;
        }
      }
    }
    label150:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        float f1 = (getWidth() - this.KtT) / 2.0F;
        float f2 = this.KtN.getBottom();
        float f3 = this.Kuo;
        float f4 = getResources().getDimension(2131165489);
        paramCanvas.drawText(this.KtS, f1, f2 + f3 - f4, this.KtR);
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
    if ((paramBoolean) && (yw(true)))
    {
      if (this.cAX)
      {
        ys(true);
        post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(38416);
            ConversationWithAppBrandListView.this.setSelection(0);
            AppMethodBeat.o(38416);
          }
        });
        this.Kuj = paramInt4;
        this.cAX = false;
        AppMethodBeat.o(38425);
        return;
      }
      if ((!this.dtm) && (this.Kuj != paramInt4))
      {
        ad.i("MicroMsg.ConversationWithAppBrandListView", "[onLayout] mLastBottom:" + this.Kuj + " b:" + paramInt4);
        ys(true);
        this.Kuj = paramInt4;
      }
    }
    AppMethodBeat.o(38425);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(38439);
    super.onMeasure(paramInt1, paramInt2);
    fIT();
    AppMethodBeat.o(38439);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(38463);
    if (this.vkg != null) {
      this.vkg.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
    if (!yw(true))
    {
      AppMethodBeat.o(38463);
      return;
    }
    fIT();
    if (this.Kun == 0)
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
      if ((this.Kue == 0.0F) || (this.Kue == 1.0F) || (Math.abs(f2 - this.Kue) >= 0.01D))
      {
        this.Kue = f2;
        f1 = f2;
        if (this.KtN != null)
        {
          if ((this.KtN.getTop() != 0) || (this.Kud)) {
            break label278;
          }
          f1 = 0.0F;
        }
      }
      for (;;)
      {
        if (this.Kuf != null)
        {
          paramInt2 = this.Kuf.aO(f1);
          if (this.mGF != null) {
            this.mGF.setColor(paramInt2);
          }
          if (this.KtO != null) {
            this.KtO.setBackgroundColor(paramInt2);
          }
        }
        yt(false);
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
        if (this.KtN.getTop() != 0)
        {
          this.Kud = true;
          f1 = f2;
        }
      }
      localGyroView = ((HeaderContainer)paramAbsListView).getGyroView();
      ad.v("MicroMsg.ConversationWithAppBrandListView", "alvinluo appBrandHeaderTransH: %s, emptyTransH: %s, headerParent.bottom: %s, translationY: %f, mAppBrandHeight: %d", new Object[] { Float.valueOf(this.KtX), Float.valueOf(this.KtY), Integer.valueOf(paramAbsListView.getBottom()), Float.valueOf(localView.getTranslationY()), Integer.valueOf(this.Kun) });
      if (paramAbsListView.getBottom() <= 3)
      {
        if (!this.dtr)
        {
          localView.setTranslationY(this.KtX);
          if (localGyroView.getVisibility() == 0)
          {
            localGyroView.setVerticalScroll(0.0F);
            localGyroView.setVisibility(8);
          }
          this.Kuy = false;
        }
      }
      else
      {
        if ((paramAbsListView.getBottom() <= 3) || (paramAbsListView.getBottom() > this.ncA) || ((localView.getTranslationY() == 0.0F) && ((this.GG == null) || (this.GG.getTranslationY() == 0.0F)))) {
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
      this.Kuz = paramInt1;
      if ((this.Kux) && (this.mVn) && (paramInt1 == 0))
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
        this.Kux = false;
      }
      aq.aA(this.Kuw);
      aq.o(this.Kuw, 50L);
      AppMethodBeat.o(38463);
      return;
      if (this.GG != null) {
        this.GG.setTranslationY(this.KtY);
      }
      localView.setTranslationY(0.0F);
      break;
      label637:
      if ((paramAbsListView.getBottom() > this.ncA) && ((localView.getTranslationY() != 0.0F) || ((this.GG != null) && (this.GG.getTranslationY() != 0.0F))))
      {
        f1 = (float)(1.0D * (paramAbsListView.getBottom() - this.ncA) / (this.Kun - this.ncA));
        ad.v("MicroMsg.ConversationWithAppBrandListView", "alvinluo checkUpAppBrandHeader appbrandHeader translationY: %f, percent: %f, setTranslationY: %f, isEmpty: %b", new Object[] { Float.valueOf(localView.getTranslationY()), Float.valueOf(f1), Float.valueOf(this.KtX * (1.0F - f1)), Boolean.valueOf(this.dtr) });
        if (!this.dtr) {
          localView.setTranslationY(this.KtX * (1.0F - f1));
        }
        for (;;)
        {
          localGyroView.setTranslationY(-this.ncA / 2.0F + localGyroView.getHeight() / 2 + (this.ncA / 2.0F + localGyroView.getHeight()) * f1);
          localGyroView.setAlpha(1.0F - 2.0F * f1);
          if ((!this.Kuy) && (1.0F != f1))
          {
            this.mUw.vibrate(10L);
            this.Kuy = true;
          }
          yt(true);
          break;
          if (this.GG != null)
          {
            ad.v("MicroMsg.ConversationWithAppBrandListView", "alvinluo emptyView translationY: %f, set: %f", new Object[] { Float.valueOf(this.GG.getTranslationY()), Float.valueOf(-this.KtY * (1.0F - f1)) });
            this.GG.setTranslationY(this.KtY * (1.0F - f1));
          }
          localView.setTranslationY(0.0F);
        }
        if (this.KtN != null)
        {
          paramAbsListView = this.KtN.findViewById(2131296898);
          if (this.dtr) {
            break label1011;
          }
          if (paramAbsListView != null) {
            paramAbsListView.setTranslationY(this.KtX);
          }
        }
        for (;;)
        {
          if ((this.Kuz != 0) || (paramInt1 == 0)) {
            break label1039;
          }
          aeu(4);
          yu(true);
          yt(true);
          break;
          if (this.GG != null) {
            this.GG.setTranslationY(this.KtY);
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
    if (this.vkg != null) {
      this.vkg.onScrollStateChanged(paramAbsListView, paramInt);
    }
    if ((getFirstVisiblePosition() != 0) && (paramInt == 2) && (!this.Kut)) {
      this.mVn = true;
    }
    AppMethodBeat.o(38458);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(38449);
    boolean bool;
    if (!yw(true))
    {
      bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(38449);
      return bool;
    }
    if (paramMotionEvent.getAction() == 0) {
      if (getFirstVisiblePosition() != 0) {
        this.Kux = true;
      }
    }
    for (;;)
    {
      if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
      {
        yt(true);
        this.Kuq = false;
        if (getChildTranslationY() > 0.0F) {
          fIV();
        }
      }
      if (ae(paramMotionEvent)) {
        break;
      }
      if ((this.Kuq) && (paramMotionEvent.getAction() == 2))
      {
        paramMotionEvent.setAction(0);
        super.onTouchEvent(paramMotionEvent);
        paramMotionEvent.setAction(2);
        this.Kuq = false;
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
        if ((Math.abs(paramMotionEvent.getX() - this.pLf) < 3.0F) && (Math.abs(paramMotionEvent.getY() - this.pLg) < 3.0F)) {
          super.onTouchEvent(paramMotionEvent);
        }
        if (getChildTranslationY() < 60.0F * getResources().getDisplayMetrics().density)
        {
          float f1 = Math.abs(paramMotionEvent.getX() - this.yjW);
          float f2 = Math.abs(paramMotionEvent.getY() - this.mXI);
          if (((paramMotionEvent.getY() - this.mXI < -5.0F) && (f1 - f2 < 0.0F) && (getFirstVisiblePosition() == 0)) || ((localView.getBottom() > 0) && (localView.getBottom() < this.ncA))) {
            aeu(4);
          } else if ((localView.getBottom() >= this.ncA) && (paramMotionEvent.getY() - this.mXI > 5.0F)) {
            fIV();
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
      if ((paramMotionEvent.getAction() == 2) && (!this.Kuq) && (Math.abs(paramMotionEvent.getY() - this.pLg) > 2.0F))
      {
        paramMotionEvent.setAction(3);
        super.onTouchEvent(paramMotionEvent);
        this.Kuq = true;
      }
      else if (!this.Kuq)
      {
        super.onTouchEvent(paramMotionEvent);
      }
    }
  }
  
  public void setActionBarUpdateCallback(com.tencent.mm.plugin.appbrand.widget.header.a parama)
  {
    this.Kub = parama;
  }
  
  public void setActivity(MMFragmentActivity paramMMFragmentActivity)
  {
    AppMethodBeat.i(38424);
    this.mWg = paramMMFragmentActivity;
    fIU();
    AppMethodBeat.o(38424);
  }
  
  public void setAdapter(final ListAdapter paramListAdapter)
  {
    AppMethodBeat.i(38423);
    ad.i("MicroMsg.ConversationWithAppBrandListView", "[init] ");
    this.Kul.alive();
    this.mUw = ((Vibrator)getContext().getSystemService("vibrator"));
    this.mTouchSlop = u.a(ViewConfiguration.get(getContext()));
    this.mGF = new Paint(1);
    this.KtR = new Paint(1);
    this.mGF.setColor(getResources().getColor(2131099955));
    this.KtR.setColor(-2147483648);
    this.KtR.setTextSize(getResources().getDimension(2131165576));
    yw(false);
    if (g.ab(d.class) != null) {
      this.mZt = ((d)g.ab(d.class)).bCc();
    }
    this.ncA = (100.0F * getResources().getDisplayMetrics().density);
    ad.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo init mAnimationPadding: %f, density: %f", new Object[] { Float.valueOf(this.ncA), Float.valueOf(getResources().getDisplayMetrics().density) });
    this.KtS = getResources().getString(2131757945);
    this.KtT = this.KtR.measureText(this.KtS);
    super.setOnScrollListener(this);
    paramListAdapter.registerDataSetObserver(new DataSetObserver()
    {
      int KuC = -1;
      
      public final void onChanged()
      {
        AppMethodBeat.i(38406);
        boolean bool;
        if (this.KuC != paramListAdapter.getCount())
        {
          if (this.KuC <= paramListAdapter.getCount()) {
            break label108;
          }
          bool = true;
          ad.i("MicroMsg.ConversationWithAppBrandListView", "[onChanged] isDelete:%s", new Object[] { Boolean.valueOf(bool) });
          if (this.KuC <= paramListAdapter.getCount()) {
            break label113;
          }
          ConversationWithAppBrandListView.a(ConversationWithAppBrandListView.this, false);
          ConversationWithAppBrandListView.a(ConversationWithAppBrandListView.this, true);
        }
        for (;;)
        {
          this.KuC = paramListAdapter.getCount();
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
      localLayoutParams.topMargin = ar.dT(getContext());
      ad.i("MicroMsg.ConversationWithAppBrandListView", "[initLayoutParams]1 ActionBar height:%s", new Object[] { Integer.valueOf(localLayoutParams.topMargin) });
      if (localLayoutParams.topMargin <= 0) {
        postDelayed(new ConversationWithAppBrandListView.19(this, localLayoutParams), 200L);
      }
      if (this.mWg != null) {
        fIU();
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
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousAdapterView);
        localb.bd(paramAnonymousView);
        localb.mr(paramAnonymousInt);
        localb.qY(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/ConversationWithAppBrandListView$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
        if (paramOnItemClickListener != null) {
          paramOnItemClickListener.onItemClick(paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        }
        if (!ConversationWithAppBrandListView.b(ConversationWithAppBrandListView.this))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/ConversationWithAppBrandListView$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(38418);
          return;
        }
        if (ConversationWithAppBrandListView.this.getFirstVisiblePosition() == 0) {
          ConversationWithAppBrandListView.this.ao(500L, 8);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/ConversationWithAppBrandListView$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
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
    this.vkg = paramOnScrollListener;
  }
  
  public void setSelection(int paramInt)
  {
    AppMethodBeat.i(38443);
    ad.i("MicroMsg.ConversationWithAppBrandListView", "[setSelection] position:%s", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt == 0) && (yw(true)))
    {
      paramInt = getFirstHeaderVisible();
      ad.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo setSelection pos: %d, appbrandHeight: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.Kun) });
      super.setSelection(paramInt);
      if ((this.mZt != null) && (this.KtU != null))
      {
        this.mZt.Q(this.KtU.getRecentAppBrandCount(), this.KtU.getStarAppBrandCount(), 7);
        this.KtU.wj(7);
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
    if ((paramInt == 0) && (yw(true)))
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
      if (yw(true)) {
        i = getFirstHeaderVisible();
      }
    }
    aq.o(new Runnable()
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
    if ((paramInt1 == 0) && (yw(true)))
    {
      super.smoothScrollToPositionFromTop(getFirstHeaderVisible(), paramInt2, paramInt3);
      AppMethodBeat.o(38446);
      return;
    }
    super.smoothScrollToPositionFromTop(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(38446);
  }
  
  public final void uP(int paramInt)
  {
    AppMethodBeat.i(38432);
    ad.i("MicroMsg.ConversationWithAppBrandListView", "[next] size:%s isAppBrandHeaderEnable:%s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.KtQ) });
    if (!yw(true))
    {
      ad.w("MicroMsg.ConversationWithAppBrandListView", "[next] is disable!");
      if (this.KtO != null) {
        this.KtO.setVisibility(8);
      }
      AppMethodBeat.o(38432);
      return;
    }
    if ((paramInt == 1) && (this.KtO != null)) {
      setEmptyViewVisible(true);
    }
    for (;;)
    {
      if ((this.KtO != null) && (this.KtO.getVisibility() == 8))
      {
        this.KtO.setVisibility(0);
        setSelection(getFirstVisiblePosition());
      }
      AppMethodBeat.o(38432);
      return;
      if ((paramInt > 1) && (this.KtO != null)) {
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
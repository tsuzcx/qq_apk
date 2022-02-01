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
import com.tencent.mm.g.a.ju;
import com.tencent.mm.g.a.lh;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.widget.header.GyroView;
import com.tencent.mm.plugin.appbrand.widget.header.HeaderContainer;
import com.tencent.mm.plugin.appbrand.widget.header.a.a.a;
import com.tencent.mm.plugin.appbrand.widget.header.a.a.b;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.e;
import com.tencent.mm.plugin.appbrand.widget.recentview.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bc;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.ao;
import java.util.Iterator;
import java.util.LinkedList;

public class ConversationWithAppBrandListView
  extends ListView
  implements AbsListView.OnScrollListener, AppBrandRecentView.e
{
  private View EP;
  private LinkedList<ListView.FixedViewInfo> IBT;
  private HeaderContainer ICJ;
  private View ICK;
  private AppBrandRecentView ICL;
  private boolean ICM;
  private Paint ICN;
  private String ICO;
  private float ICP;
  private com.tencent.mm.plugin.appbrand.widget.header.a.a ICQ;
  private boolean ICR;
  private boolean ICS;
  private boolean ICT;
  private float ICU;
  private float ICV;
  private int ICW;
  private boolean ICX;
  private com.tencent.mm.plugin.appbrand.widget.header.a ICY;
  private Runnable ICZ;
  private View ICx;
  private boolean IDa;
  private float IDb;
  private com.tencent.mm.plugin.appbrand.widget.header.b IDc;
  private com.tencent.mm.plugin.appbrand.widget.header.b IDd;
  private com.tencent.mm.plugin.appbrand.widget.header.b IDe;
  private com.tencent.mm.sdk.b.c<lh> IDf;
  private int IDg;
  boolean IDh;
  private final com.tencent.mm.sdk.b.c<ju> IDi;
  private a IDj;
  private int IDk;
  private float IDl;
  private float IDm;
  private boolean IDn;
  private boolean IDo;
  private boolean IDp;
  private boolean IDq;
  private boolean IDr;
  private Runnable IDs;
  private Runnable IDt;
  private boolean IDu;
  private boolean IDv;
  private int IDw;
  private int aqA;
  private int aqB;
  private int aqC;
  private ValueAnimator cEE;
  private boolean cqf;
  private boolean dhO;
  private boolean hasInit;
  private float mCa;
  private int mTouchSlop;
  private Paint mge;
  private Vibrator mtQ;
  private boolean muG;
  private GyroView muN;
  private MMFragmentActivity mvz;
  private float mxe;
  private com.tencent.mm.plugin.appbrand.widget.recentview.b myL;
  private float phD;
  private float phE;
  private AbsListView.OnScrollListener uhw;
  private float wWl;
  
  public ConversationWithAppBrandListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(38422);
    this.IBT = new LinkedList();
    this.ICM = false;
    this.ICR = false;
    this.ICS = false;
    this.ICT = false;
    this.ICU = 0.0F;
    this.ICV = 0.0F;
    this.ICW = 0;
    this.ICX = false;
    this.ICZ = null;
    this.IDa = true;
    this.IDb = 0.0F;
    this.IDc = null;
    this.IDd = null;
    this.IDe = null;
    this.IDf = new ConversationWithAppBrandListView.1(this);
    this.cqf = true;
    this.IDg = 0;
    this.IDh = false;
    this.aqA = -1;
    this.IDi = new com.tencent.mm.sdk.b.c() {};
    this.IDj = new a();
    this.IDk = 0;
    this.IDl = 0.0F;
    this.IDm = 0.0F;
    this.IDo = false;
    this.IDq = false;
    this.IDr = false;
    this.IDt = new Runnable()
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
    this.muG = false;
    this.IDu = false;
    this.IDv = false;
    this.hasInit = false;
    this.IDc = new com.tencent.mm.plugin.appbrand.widget.header.b(ao.aJ(getContext(), 2130968577), getContext().getResources().getColor(2131099928));
    this.IDf.alive();
    AppMethodBeat.o(38422);
  }
  
  private void abX(int paramInt)
  {
    AppMethodBeat.i(38453);
    ac.i("MicroMsg.ConversationWithAppBrandListView", "[closeAppBrandRecentView] isOpenAppBrandRecentView:%s type:%s", new Object[] { Boolean.valueOf(this.IDp), Integer.valueOf(paramInt) });
    if ((this.IDp) && (getChildAt(0) != null) && (this.myL != null) && (this.ICQ != null))
    {
      this.myL.O(this.ICQ.getRecentAppBrandCount(), this.ICQ.getStarAppBrandCount(), paramInt);
      this.ICQ.vD(paramInt);
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
      fsj();
      xF(true);
      setOpenAppBrandRecentView(false);
      com.tencent.mm.sdk.platformtools.ap.n(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(38404);
          if (ConversationWithAppBrandListView.c(ConversationWithAppBrandListView.this) != null)
          {
            ac.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo scrollToFirstPage");
            ConversationWithAppBrandListView.c(ConversationWithAppBrandListView.this).bzp();
          }
          AppMethodBeat.o(38404);
        }
      }, 500L);
      AppMethodBeat.o(38453);
      return;
    }
  }
  
  private float abY(int paramInt)
  {
    AppMethodBeat.i(38464);
    ac.d("MicroMsg.ConversationWithAppBrandListView", "[isFull] totalItemCount:" + paramInt + " getFirstVisiblePosition:" + getFirstVisiblePosition() + " getLastVisiblePosition:" + getLastVisiblePosition() + " getHeaderViewsCount:" + getHeaderViewsCount() + " getFooterViewsCount:" + getFooterViewsCount());
    int i = (int)getResources().getDimension(2131165515);
    paramInt = paramInt - getHeaderViewsCount() - getFooterViewsCount();
    float f = getMeasuredHeight() - i * paramInt;
    ac.i("MicroMsg.ConversationWithAppBrandListView", "[isFull] height:%s rawCount:%s extraHeight:%s", new Object[] { Integer.valueOf(getHeight()), Integer.valueOf(paramInt), Float.valueOf(f) });
    AppMethodBeat.o(38464);
    return f;
  }
  
  private boolean ac(MotionEvent paramMotionEvent)
  {
    int j = 0;
    AppMethodBeat.i(38450);
    if (!fsl())
    {
      AppMethodBeat.o(38450);
      return false;
    }
    if (paramMotionEvent.getAction() == 0)
    {
      this.IDm = paramMotionEvent.getY();
      if (this.cEE != null) {
        this.cEE.cancel();
      }
    }
    float f3;
    try
    {
      if (((paramMotionEvent.getAction() != 2) || (Math.abs(paramMotionEvent.getY() - this.phE) <= 2.0F) || (getFirstVisiblePosition() != 0) || (this.ICJ.getTop() != 0)) && (getChildTranslationY() == 0.0F)) {
        break label582;
      }
      xF(true);
      if ((getHeight() - getTabViewHeight() - this.IDk) / 2 <= this.IDl) {
        xG(false);
      }
      for (;;)
      {
        float f1 = paramMotionEvent.getY();
        float f2 = this.IDm;
        f3 = getHeight() - getTabViewHeight() - this.IDk;
        this.IDl = ((f1 - f2) * 0.4F + this.IDl);
        if (this.IDl >= 0.0F) {
          break label488;
        }
        this.IDl = 0.0F;
        fsj();
        invalidate();
        return false;
        if (paramMotionEvent.getActionMasked() == 5)
        {
          this.IDm = paramMotionEvent.getY();
          break;
        }
        if (((paramMotionEvent.getAction() != 1) && (paramMotionEvent.getAction() != 3)) || (this.ICJ.getTop() != 0) || (getChildTranslationY() == 0.0F)) {
          break;
        }
        xG(true);
        this.IDo = false;
        ac.d("MicroMsg.ConversationWithAppBrandListView", "[animationChild] offset:%s delay:%s duration%s", new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(180) });
        if (!fsl()) {
          break;
        }
        if (this.cEE != null) {
          this.cEE.cancel();
        }
        this.cEE = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("deltaY", new float[] { getChildTranslationY() + 0.0F, 0.0F }), PropertyValuesHolder.ofFloat("headerDeltaY", new float[] { getHeaderY() + 0.0F, 0.0F }) });
        this.cEE.setDuration(180L);
        this.cEE.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
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
        this.cEE.addListener(new ConversationWithAppBrandListView.12(this));
        this.cEE.setStartDelay(0L);
        this.cEE.start();
        break;
        xG(true);
      }
      i = j;
    }
    finally
    {
      this.IDm = paramMotionEvent.getY();
      AppMethodBeat.o(38450);
    }
    label488:
    int i;
    if (f3 < this.IDl)
    {
      this.IDl = f3;
      i = j;
    }
    for (;;)
    {
      if (i < getChildCount())
      {
        if (i == 0) {
          getChildAt(i).setTranslationY(this.IDl * 0.5F);
        } else {
          getChildAt(i).setTranslationY(this.IDl);
        }
      }
      else
      {
        invalidate();
        this.IDm = paramMotionEvent.getY();
        AppMethodBeat.o(38450);
        return true;
        label582:
        this.IDm = paramMotionEvent.getY();
        AppMethodBeat.o(38450);
        return false;
      }
      i += 1;
    }
  }
  
  private void fsd()
  {
    boolean bool = false;
    AppMethodBeat.i(38436);
    int j = getFirstHeaderVisible();
    localLayoutParams = (LinearLayout.LayoutParams)this.ICx.getLayoutParams();
    int k = localLayoutParams.height;
    for (;;)
    {
      try
      {
        if (getAdapter() != null) {
          continue;
        }
        i = 0;
        f1 = abY(i);
      }
      catch (Exception localException)
      {
        int i;
        float f2;
        float f1 = 0.0F;
        continue;
        localLayoutParams.height = ((int)f2);
        if (!this.cqf) {
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
      ac.i("MicroMsg.ConversationWithAppBrandListView", "[checkEmptyFooter] isRealFull:" + bool + " extraHeight:" + f2);
      if (!bool) {
        continue;
      }
      localLayoutParams.height = getTabViewHeight();
      if (k != localLayoutParams.height)
      {
        this.ICx.setLayoutParams(localLayoutParams);
        if (!this.cqf) {
          super.setSelection(j);
        }
      }
      AppMethodBeat.o(38436);
      return;
      i = getAdapter().getCount();
    }
  }
  
  private boolean fse()
  {
    AppMethodBeat.i(38440);
    if ((this.ICK != null) && (this.ICQ != null))
    {
      int i = this.ICJ.getMeasuredHeight();
      if ((i != 0) && (i != this.IDk))
      {
        this.IDk = i;
        AppMethodBeat.o(38440);
        return true;
      }
    }
    AppMethodBeat.o(38440);
    return false;
  }
  
  private void fsf()
  {
    AppMethodBeat.i(38441);
    if (fse())
    {
      if (this.muN != null) {
        this.muN.setVisibility(0);
      }
      this.ICU = (-(this.mCa - getResources().getDimension(2131165484)));
      this.ICV = (-(this.mCa - (this.IDk / 2 - getResources().getDimension(2131165467))));
      if (!this.ICT)
      {
        if (this.ICK != null) {
          this.ICK.setTranslationY(this.ICU);
        }
        if (this.EP != null) {
          this.EP.setTranslationY(0.0F);
        }
        ac.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo initAppBrandHeaderHeight AppBrandHeader appBrandHeight: %d, setTranslationY: %s", new Object[] { Integer.valueOf(this.IDk), Float.valueOf(this.ICU) });
        AppMethodBeat.o(38441);
        return;
      }
      if (this.ICK != null) {
        this.ICK.setTranslationY(0.0F);
      }
      if (this.EP != null) {
        this.EP.setTranslationY(this.ICV);
      }
      ac.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo initAppBrandHeaderHeight emptyView appBrandHeight: %d, setTranslationY: %s", new Object[] { Integer.valueOf(this.IDk), Float.valueOf(this.ICV) });
    }
    AppMethodBeat.o(38441);
  }
  
  private void fsg()
  {
    AppMethodBeat.i(38442);
    if (this.ICX)
    {
      AppMethodBeat.o(38442);
      return;
    }
    if (g.ab(d.class) != null)
    {
      this.ICJ = ((d)g.ab(d.class)).dU(this.mvz);
      this.ICX = true;
      this.ICJ.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
      this.ICK = this.ICJ.findViewById(2131296898);
      this.ICK.setVisibility(8);
      this.muN = this.ICJ.getGyroView();
      this.ICQ = this.ICJ.getHeaderView();
      this.ICQ.setCollectionRefreshListener(new AppBrandRecentView.e()
      {
        public final void ul(int paramAnonymousInt)
        {
          AppMethodBeat.i(38398);
          ac.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo onDone MyAppBrand size: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
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
      this.ICQ.setUsageRefreshListener(new AppBrandRecentView.e()
      {
        public final void ul(int paramAnonymousInt)
        {
          AppMethodBeat.i(38399);
          ac.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo onDone RecentAppBrand size: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
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
      this.ICQ.setIOnLaunchUIListener(new a.b()
      {
        public final void bzC()
        {
          AppMethodBeat.i(38400);
          ac.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo onLaunchCollectionUI");
          ConversationWithAppBrandListView.this.aj(300L, 10);
          AppMethodBeat.o(38400);
        }
        
        public final void bzD()
        {
          AppMethodBeat.i(38401);
          ac.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo onLaunchUsageUI");
          ConversationWithAppBrandListView.this.aj(300L, 9);
          AppMethodBeat.o(38401);
        }
      });
      this.ICQ.setOnEmptyViewListener(new a.a()
      {
        public final void hX(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(38402);
          ac.v("MicroMsg.ConversationWithAppBrandListView", "alvinluo onShowEmptyView show: %b, isOpenAppBrandRecentView: %b", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Boolean.valueOf(ConversationWithAppBrandListView.g(ConversationWithAppBrandListView.this)) });
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
      this.ICQ.setReporter(this.myL);
      this.EP = this.ICJ.getEmptyView();
      this.IBT.remove(this.ICJ);
      Object localObject = new ListView.FixedViewInfo(this);
      ((ListView.FixedViewInfo)localObject).view = this.ICJ;
      ((ListView.FixedViewInfo)localObject).data = null;
      ((ListView.FixedViewInfo)localObject).isSelectable = true;
      this.IBT.addFirst(localObject);
      localObject = this.IBT.iterator();
      while (((Iterator)localObject).hasNext())
      {
        ListView.FixedViewInfo localFixedViewInfo = (ListView.FixedViewInfo)((Iterator)localObject).next();
        super.addHeaderView(localFixedViewInfo.view, localFixedViewInfo.data, localFixedViewInfo.isSelectable);
      }
    }
    ac.e("MicroMsg.ConversationWithAppBrandListView", "alvinluo addAppBrandHalfView error");
    AppMethodBeat.o(38442);
    return;
    this.ICQ.refresh();
    AppMethodBeat.o(38442);
  }
  
  private void fsh()
  {
    AppMethodBeat.i(38451);
    if (!this.IDp)
    {
      bc.iS(getContext());
      if ((this.myL != null) && (this.ICQ != null)) {
        this.myL.ey(this.ICQ.getRecentAppBrandCount(), this.ICQ.getStarAppBrandCount());
      }
      if (this.ICQ != null) {
        this.ICQ.bzq();
      }
    }
    if ((this.IDh) && (this.ICL != null))
    {
      this.ICL.getAdapter().arg.notifyChanged();
      this.IDh = true;
    }
    super.smoothScrollToPositionFromTop(0, 0, 250);
    xF(true);
    setOpenAppBrandRecentView(true);
    fsi();
    AppMethodBeat.o(38451);
  }
  
  private void fsi()
  {
    AppMethodBeat.i(38452);
    if (this.ICQ != null) {
      this.ICQ.bzr();
    }
    AppMethodBeat.o(38452);
  }
  
  private void fsj()
  {
    AppMethodBeat.i(38456);
    int i = 0;
    while (i < getChildCount())
    {
      getChildAt(i).setTranslationY(0.0F);
      i += 1;
    }
    this.IDl = 0.0F;
    invalidate();
    AppMethodBeat.o(38456);
  }
  
  private void fsk()
  {
    AppMethodBeat.i(38461);
    ac.d("MicroMsg.ConversationWithAppBrandListView", "alvinluo resetAppBrandHeaderBg");
    if (this.mge != null)
    {
      int i = this.mvz.getResources().getColor(2131099934);
      this.mge.setColor(i);
    }
    AppMethodBeat.o(38461);
  }
  
  private boolean fsl()
  {
    AppMethodBeat.i(38467);
    if (this.ICK != null)
    {
      if ((xI(true)) && (this.ICK.getVisibility() == 0))
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
    this.ICx = new View(getContext());
    this.ICx.setLayoutParams(new LinearLayout.LayoutParams(-1, 0));
    localLinearLayout.addView(this.ICx);
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
    if ((this.ICJ != null) && (this.IDk != 0))
    {
      f2 = 1.0F - Math.abs(this.ICJ.getTop() * 1.0F) / this.IDk;
      if (f2 >= 0.0F) {
        break label122;
      }
    }
    for (;;)
    {
      ac.d("MicroMsg.ConversationWithAppBrandListView", "alvinluo header top: %d, header bottom: %d, ratio: %f, appBrandHeight: %d", new Object[] { Integer.valueOf(this.ICJ.getTop()), Integer.valueOf(this.ICJ.getBottom()), Float.valueOf(f1), Integer.valueOf(this.IDk) });
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
    if (this.ICW == 0)
    {
      View localView = getRootView().findViewById(2131301338);
      if (localView != null)
      {
        ac.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo initTabViewHeight tabView.getHeight: %d", new Object[] { Integer.valueOf(localView.getHeight()) });
        this.ICW = localView.getHeight();
      }
    }
    int i = this.ICW;
    AppMethodBeat.o(38435);
    return i;
  }
  
  private void setEmptyViewVisible(boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(38438);
    ac.i("MicroMsg.ConversationWithAppBrandListView", "[setEmptyViewVisible] isShow:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    View localView;
    if (this.EP != null)
    {
      localView = this.EP;
      if (paramBoolean)
      {
        i = 0;
        localView.setVisibility(i);
      }
    }
    else if (this.ICK != null)
    {
      localView = this.ICK.findViewById(2131296899);
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
    this.IDp = paramBoolean;
  }
  
  private void xE(boolean paramBoolean)
  {
    AppMethodBeat.i(38434);
    if ((this.ICx == null) || (!xI(true)))
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
    fsd();
    AppMethodBeat.o(38434);
  }
  
  private void xF(boolean paramBoolean)
  {
    AppMethodBeat.i(38437);
    if (paramBoolean)
    {
      com.tencent.mm.sdk.platformtools.ap.aB(this.IDj);
      AppMethodBeat.o(38437);
      return;
    }
    com.tencent.mm.sdk.platformtools.ap.aB(this.IDj);
    com.tencent.mm.sdk.platformtools.ap.n(this.IDj, 1000L);
    AppMethodBeat.o(38437);
  }
  
  private void xG(boolean paramBoolean)
  {
    AppMethodBeat.i(38459);
    if ((paramBoolean) && (this.IDs != null))
    {
      com.tencent.mm.sdk.platformtools.ap.aB(this.IDs);
      this.IDs = null;
      if (this.IDr)
      {
        xH(false);
        AppMethodBeat.o(38459);
      }
    }
    else if ((!paramBoolean) && (this.IDs == null))
    {
      ConversationWithAppBrandListView.13 local13 = new ConversationWithAppBrandListView.13(this);
      this.IDs = local13;
      com.tencent.mm.sdk.platformtools.ap.n(local13, 3000L);
    }
    AppMethodBeat.o(38459);
  }
  
  private void xH(boolean paramBoolean)
  {
    AppMethodBeat.i(38460);
    ac.i("MicroMsg.ConversationWithAppBrandListView", "[showTipWithAnim] isShow:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.IDr = true;
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
      if (this.myL != null) {
        this.myL.bBz();
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
  
  private boolean xI(boolean paramBoolean)
  {
    AppMethodBeat.i(38466);
    if (((!this.hasInit) || (!paramBoolean)) && (g.ab(d.class) != null))
    {
      g.ab(d.class);
      this.ICM = true;
      ac.i("MicroMsg.ConversationWithAppBrandListView", "[isAppBrandHeaderEnable] :%s", new Object[] { Boolean.valueOf(this.ICM) });
      this.hasInit = true;
    }
    paramBoolean = this.ICM;
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
    this.IBT.add(localFixedViewInfo);
    if (getAdapter() != null) {
      super.addHeaderView(localFixedViewInfo.view, localFixedViewInfo.data, localFixedViewInfo.isSelectable);
    }
    ac.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo addHeaderView %d", new Object[] { Integer.valueOf(this.IBT.size()) });
    AppMethodBeat.o(38428);
  }
  
  public final void aj(long paramLong, int paramInt)
  {
    AppMethodBeat.i(38431);
    ac.i("MicroMsg.ConversationWithAppBrandListView", "[hideAppBrandRecentView] delay:%s, type: %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    if (!xI(true))
    {
      if (this.ICK != null) {
        this.ICK.setVisibility(8);
      }
      AppMethodBeat.o(38431);
      return;
    }
    if (getFirstVisiblePosition() != 0)
    {
      AppMethodBeat.o(38431);
      return;
    }
    if ((this.myL != null) && (this.ICQ != null))
    {
      this.myL.O(this.ICQ.getRecentAppBrandCount(), this.ICQ.getStarAppBrandCount(), paramInt);
      this.ICQ.vD(paramInt);
    }
    if (paramLong > 0L)
    {
      if (this.ICZ != null) {
        removeCallbacks(this.ICZ);
      }
      this.ICZ = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(38420);
          if (ConversationWithAppBrandListView.c(ConversationWithAppBrandListView.this) != null)
          {
            ac.d("MicroMsg.ConversationWithAppBrandListView", "alvinluo resetToFirstPage");
            ConversationWithAppBrandListView.c(ConversationWithAppBrandListView.this).bzp();
          }
          if (ConversationWithAppBrandListView.d(ConversationWithAppBrandListView.this) != null)
          {
            localObject = ConversationWithAppBrandListView.d(ConversationWithAppBrandListView.this);
            com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.aeD(), "com/tencent/mm/ui/conversation/ConversationWithAppBrandListView$9", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
            ((AppBrandRecentView)localObject).smoothScrollToPosition(((Integer)locala.lR(0)).intValue());
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
      postDelayed(this.ICZ, paramLong);
    }
    for (;;)
    {
      fsj();
      AppMethodBeat.o(38431);
      return;
      if (this.ICQ != null) {
        this.ICQ.bzp();
      }
      if (this.ICL != null)
      {
        AppBrandRecentView localAppBrandRecentView = this.ICL;
        com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(localAppBrandRecentView, locala.aeD(), "com/tencent/mm/ui/conversation/ConversationWithAppBrandListView", "hideAppBrandRecentView", "(JI)V", "Undefined", "smoothScrollToPosition", "(I)V");
        localAppBrandRecentView.smoothScrollToPosition(((Integer)locala.lR(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(localAppBrandRecentView, "com/tencent/mm/ui/conversation/ConversationWithAppBrandListView", "hideAppBrandRecentView", "(JI)V", "Undefined", "smoothScrollToPosition", "(I)V");
      }
      setSelection(0);
      ac.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo resetAppBrandHeaderBg");
      fsk();
    }
  }
  
  public boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    AppMethodBeat.i(38447);
    if ((xI(true)) && (getFirstVisiblePosition() == 0) && (paramInt2 < 0))
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
        this.phD = f;
        this.wWl = f;
        f = paramMotionEvent.getY();
        this.phE = f;
        this.mxe = f;
      }
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      return bool;
    }
    finally
    {
      this.phD = paramMotionEvent.getX();
      this.phE = paramMotionEvent.getY();
      AppMethodBeat.o(38448);
    }
  }
  
  public int getFirstHeaderVisible()
  {
    AppMethodBeat.i(38465);
    Iterator localIterator = this.IBT.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      ListView.FixedViewInfo localFixedViewInfo = (ListView.FixedViewInfo)localIterator.next();
      if (localFixedViewInfo.view == this.ICJ)
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
              ac.i("MicroMsg.ConversationWithAppBrandListView", "[getFirstHeaderVisible] index:%s", new Object[] { Integer.valueOf(i) });
              AppMethodBeat.o(38465);
              return i;
            }
            j += 1;
          }
        }
        i += 1;
      }
    }
    ac.i("MicroMsg.ConversationWithAppBrandListView", "[getFirstHeaderVisible] index:%s, size: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(this.IBT.size()) });
    AppMethodBeat.o(38465);
    return i;
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(38426);
    super.onConfigurationChanged(paramConfiguration);
    ac.i("MicroMsg.ConversationWithAppBrandListView", "[onConfigurationChanged] orientation:%s", new Object[] { Integer.valueOf(paramConfiguration.orientation) });
    this.IDh = true;
    xE(true);
    if (this.ICQ != null) {
      this.ICQ.e(paramConfiguration);
    }
    this.IDa = false;
    AppMethodBeat.o(38426);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(38457);
    super.onDraw(paramCanvas);
    if ((getFirstVisiblePosition() == 0) && (this.ICJ != null))
    {
      paramCanvas.drawRect(0.0F, 0.0F, getWidth(), this.ICJ.getBottom() + this.IDl, this.mge);
      if (getChildAt(1) != null) {
        if ((getHeight() == 0) || (!this.IDr)) {
          break label150;
        }
      }
    }
    label150:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        float f1 = (getWidth() - this.ICP) / 2.0F;
        float f2 = this.ICJ.getBottom();
        float f3 = this.IDl;
        float f4 = getResources().getDimension(2131165489);
        paramCanvas.drawText(this.ICO, f1, f2 + f3 - f4, this.ICN);
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
      this.aqA = paramMotionEvent.getPointerId(0);
      this.aqB = ((int)(paramMotionEvent.getX() + 0.5F));
      this.aqC = ((int)(paramMotionEvent.getY() + 0.5F));
      bool = super.onInterceptTouchEvent(paramMotionEvent);
      AppMethodBeat.o(38427);
      return bool;
    case 5: 
      this.aqA = paramMotionEvent.getPointerId(j);
      this.aqB = ((int)(paramMotionEvent.getX(j) + 0.5F));
      this.aqC = ((int)(paramMotionEvent.getY(j) + 0.5F));
      bool = super.onInterceptTouchEvent(paramMotionEvent);
      AppMethodBeat.o(38427);
      return bool;
    }
    j = paramMotionEvent.findPointerIndex(this.aqA);
    if (j < 0)
    {
      AppMethodBeat.o(38427);
      return false;
    }
    i = (int)(paramMotionEvent.getX(j) + 0.5F);
    int k = (int)(paramMotionEvent.getY(j) + 0.5F);
    j = this.aqB;
    k -= this.aqC;
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
    if ((paramBoolean) && (xI(true)))
    {
      if (this.cqf)
      {
        xE(true);
        post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(38416);
            ConversationWithAppBrandListView.this.setSelection(0);
            AppMethodBeat.o(38416);
          }
        });
        this.IDg = paramInt4;
        this.cqf = false;
        AppMethodBeat.o(38425);
        return;
      }
      if ((!this.dhO) && (this.IDg != paramInt4))
      {
        ac.i("MicroMsg.ConversationWithAppBrandListView", "[onLayout] mLastBottom:" + this.IDg + " b:" + paramInt4);
        xE(true);
        this.IDg = paramInt4;
      }
    }
    AppMethodBeat.o(38425);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(38439);
    super.onMeasure(paramInt1, paramInt2);
    fsf();
    AppMethodBeat.o(38439);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(38463);
    if (this.uhw != null) {
      this.uhw.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
    if (!xI(true))
    {
      AppMethodBeat.o(38463);
      return;
    }
    fsf();
    if (this.IDk == 0)
    {
      AppMethodBeat.o(38463);
      return;
    }
    ac.v("MicroMsg.ConversationWithAppBrandListView", "alvinluo onScroll firstVisibleItem: %d, visibleItemCount: %d, totalItemCount: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    float f1;
    View localView;
    label278:
    GyroView localGyroView;
    if (paramInt1 == 0)
    {
      float f2 = getRatio();
      if ((this.IDb == 0.0F) || (this.IDb == 1.0F) || (Math.abs(f2 - this.IDb) >= 0.01D))
      {
        this.IDb = f2;
        f1 = f2;
        if (this.ICJ != null)
        {
          if ((this.ICJ.getTop() != 0) || (this.IDa)) {
            break label278;
          }
          f1 = 0.0F;
        }
      }
      for (;;)
      {
        if (this.IDc != null)
        {
          paramInt2 = this.IDc.aL(f1);
          if (this.mge != null) {
            this.mge.setColor(paramInt2);
          }
          if (this.ICK != null) {
            this.ICK.setBackgroundColor(paramInt2);
          }
        }
        xF(false);
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
        if (this.ICJ.getTop() != 0)
        {
          this.IDa = true;
          f1 = f2;
        }
      }
      localGyroView = ((HeaderContainer)paramAbsListView).getGyroView();
      ac.v("MicroMsg.ConversationWithAppBrandListView", "alvinluo appBrandHeaderTransH: %s, emptyTransH: %s, headerParent.bottom: %s, translationY: %f, mAppBrandHeight: %d", new Object[] { Float.valueOf(this.ICU), Float.valueOf(this.ICV), Integer.valueOf(paramAbsListView.getBottom()), Float.valueOf(localView.getTranslationY()), Integer.valueOf(this.IDk) });
      if (paramAbsListView.getBottom() <= 3)
      {
        if (!this.ICT)
        {
          localView.setTranslationY(this.ICU);
          if (localGyroView.getVisibility() == 0)
          {
            localGyroView.setVerticalScroll(0.0F);
            localGyroView.setVisibility(8);
          }
          this.IDv = false;
        }
      }
      else
      {
        if ((paramAbsListView.getBottom() <= 3) || (paramAbsListView.getBottom() > this.mCa) || ((localView.getTranslationY() == 0.0F) && ((this.EP == null) || (this.EP.getTranslationY() == 0.0F)))) {
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
      this.IDw = paramInt1;
      if ((this.IDu) && (this.muG) && (paramInt1 == 0))
      {
        ac.e("MicroMsg.ConversationWithAppBrandListView", "[Stop fling!]");
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
              ac.i("MicroMsg.ConversationWithAppBrandListView", "[smoothScrollBy] offset: ".concat(String.valueOf(i)));
              ConversationWithAppBrandListView.this.smoothScrollToPositionFromTop(ConversationWithAppBrandListView.this.getFirstHeaderVisible(), 0, 300);
              ConversationWithAppBrandListView.q(ConversationWithAppBrandListView.this);
              AppMethodBeat.o(38414);
              return;
            }
          }
        });
        this.IDu = false;
      }
      com.tencent.mm.sdk.platformtools.ap.aB(this.IDt);
      com.tencent.mm.sdk.platformtools.ap.n(this.IDt, 50L);
      AppMethodBeat.o(38463);
      return;
      if (this.EP != null) {
        this.EP.setTranslationY(this.ICV);
      }
      localView.setTranslationY(0.0F);
      break;
      label637:
      if ((paramAbsListView.getBottom() > this.mCa) && ((localView.getTranslationY() != 0.0F) || ((this.EP != null) && (this.EP.getTranslationY() != 0.0F))))
      {
        f1 = (float)(1.0D * (paramAbsListView.getBottom() - this.mCa) / (this.IDk - this.mCa));
        ac.v("MicroMsg.ConversationWithAppBrandListView", "alvinluo checkUpAppBrandHeader appbrandHeader translationY: %f, percent: %f, setTranslationY: %f, isEmpty: %b", new Object[] { Float.valueOf(localView.getTranslationY()), Float.valueOf(f1), Float.valueOf(this.ICU * (1.0F - f1)), Boolean.valueOf(this.ICT) });
        if (!this.ICT) {
          localView.setTranslationY(this.ICU * (1.0F - f1));
        }
        for (;;)
        {
          localGyroView.setTranslationY(-this.mCa / 2.0F + localGyroView.getHeight() / 2 + (this.mCa / 2.0F + localGyroView.getHeight()) * f1);
          localGyroView.setAlpha(1.0F - 2.0F * f1);
          if ((!this.IDv) && (1.0F != f1))
          {
            this.mtQ.vibrate(10L);
            this.IDv = true;
          }
          xF(true);
          break;
          if (this.EP != null)
          {
            ac.v("MicroMsg.ConversationWithAppBrandListView", "alvinluo emptyView translationY: %f, set: %f", new Object[] { Float.valueOf(this.EP.getTranslationY()), Float.valueOf(-this.ICV * (1.0F - f1)) });
            this.EP.setTranslationY(this.ICV * (1.0F - f1));
          }
          localView.setTranslationY(0.0F);
        }
        if (this.ICJ != null)
        {
          paramAbsListView = this.ICJ.findViewById(2131296898);
          if (this.ICT) {
            break label1011;
          }
          if (paramAbsListView != null) {
            paramAbsListView.setTranslationY(this.ICU);
          }
        }
        for (;;)
        {
          if ((this.IDw != 0) || (paramInt1 == 0)) {
            break label1039;
          }
          abX(4);
          xG(true);
          xF(true);
          break;
          if (this.EP != null) {
            this.EP.setTranslationY(this.ICV);
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
    if (this.uhw != null) {
      this.uhw.onScrollStateChanged(paramAbsListView, paramInt);
    }
    if ((getFirstVisiblePosition() != 0) && (paramInt == 2) && (!this.IDq)) {
      this.muG = true;
    }
    AppMethodBeat.o(38458);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(38449);
    boolean bool;
    if (!xI(true))
    {
      bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(38449);
      return bool;
    }
    if (paramMotionEvent.getAction() == 0) {
      if (getFirstVisiblePosition() != 0) {
        this.IDu = true;
      }
    }
    for (;;)
    {
      if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
      {
        xF(true);
        this.IDn = false;
        if (getChildTranslationY() > 0.0F) {
          fsh();
        }
      }
      if (ac(paramMotionEvent)) {
        break;
      }
      if ((this.IDn) && (paramMotionEvent.getAction() == 2))
      {
        paramMotionEvent.setAction(0);
        super.onTouchEvent(paramMotionEvent);
        paramMotionEvent.setAction(2);
        this.IDn = false;
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
        if ((Math.abs(paramMotionEvent.getX() - this.phD) < 3.0F) && (Math.abs(paramMotionEvent.getY() - this.phE) < 3.0F)) {
          super.onTouchEvent(paramMotionEvent);
        }
        if (getChildTranslationY() < 60.0F * getResources().getDisplayMetrics().density)
        {
          float f1 = Math.abs(paramMotionEvent.getX() - this.wWl);
          float f2 = Math.abs(paramMotionEvent.getY() - this.mxe);
          if (((paramMotionEvent.getY() - this.mxe < -5.0F) && (f1 - f2 < 0.0F) && (getFirstVisiblePosition() == 0)) || ((localView.getBottom() > 0) && (localView.getBottom() < this.mCa))) {
            abX(4);
          } else if ((localView.getBottom() >= this.mCa) && (paramMotionEvent.getY() - this.mxe > 5.0F)) {
            fsh();
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
      if ((paramMotionEvent.getAction() == 2) && (!this.IDn) && (Math.abs(paramMotionEvent.getY() - this.phE) > 2.0F))
      {
        paramMotionEvent.setAction(3);
        super.onTouchEvent(paramMotionEvent);
        this.IDn = true;
      }
      else if (!this.IDn)
      {
        super.onTouchEvent(paramMotionEvent);
      }
    }
  }
  
  public void setActionBarUpdateCallback(com.tencent.mm.plugin.appbrand.widget.header.a parama)
  {
    this.ICY = parama;
  }
  
  public void setActivity(MMFragmentActivity paramMMFragmentActivity)
  {
    AppMethodBeat.i(38424);
    this.mvz = paramMMFragmentActivity;
    fsg();
    AppMethodBeat.o(38424);
  }
  
  public void setAdapter(final ListAdapter paramListAdapter)
  {
    AppMethodBeat.i(38423);
    ac.i("MicroMsg.ConversationWithAppBrandListView", "[init] ");
    this.IDi.alive();
    this.mtQ = ((Vibrator)getContext().getSystemService("vibrator"));
    this.mTouchSlop = u.a(ViewConfiguration.get(getContext()));
    this.mge = new Paint(1);
    this.ICN = new Paint(1);
    this.mge.setColor(getResources().getColor(2131099955));
    this.ICN.setColor(-2147483648);
    this.ICN.setTextSize(getResources().getDimension(2131165576));
    xI(false);
    if (g.ab(d.class) != null) {
      this.myL = ((d)g.ab(d.class)).bxW();
    }
    this.mCa = (100.0F * getResources().getDisplayMetrics().density);
    ac.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo init mAnimationPadding: %f, density: %f", new Object[] { Float.valueOf(this.mCa), Float.valueOf(getResources().getDisplayMetrics().density) });
    this.ICO = getResources().getString(2131757945);
    this.ICP = this.ICN.measureText(this.ICO);
    super.setOnScrollListener(this);
    paramListAdapter.registerDataSetObserver(new DataSetObserver()
    {
      int IDz = -1;
      
      public final void onChanged()
      {
        AppMethodBeat.i(38406);
        boolean bool;
        if (this.IDz != paramListAdapter.getCount())
        {
          if (this.IDz <= paramListAdapter.getCount()) {
            break label108;
          }
          bool = true;
          ac.i("MicroMsg.ConversationWithAppBrandListView", "[onChanged] isDelete:%s", new Object[] { Boolean.valueOf(bool) });
          if (this.IDz <= paramListAdapter.getCount()) {
            break label113;
          }
          ConversationWithAppBrandListView.a(ConversationWithAppBrandListView.this, false);
          ConversationWithAppBrandListView.a(ConversationWithAppBrandListView.this, true);
        }
        for (;;)
        {
          this.IDz = paramListAdapter.getCount();
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
      localLayoutParams.topMargin = com.tencent.mm.ui.ap.dT(getContext());
      ac.i("MicroMsg.ConversationWithAppBrandListView", "[initLayoutParams]1 ActionBar height:%s", new Object[] { Integer.valueOf(localLayoutParams.topMargin) });
      if (localLayoutParams.topMargin <= 0) {
        postDelayed(new ConversationWithAppBrandListView.19(this, localLayoutParams), 200L);
      }
      if (this.mvz != null) {
        fsg();
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
        ac.printErrStackTrace("MicroMsg.ConversationWithAppBrandListView", localException, "alvinluo initLayoutParams exception", new Object[0]);
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
          ConversationWithAppBrandListView.this.aj(500L, 8);
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
    this.uhw = paramOnScrollListener;
  }
  
  public void setSelection(int paramInt)
  {
    AppMethodBeat.i(38443);
    ac.i("MicroMsg.ConversationWithAppBrandListView", "[setSelection] position:%s", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt == 0) && (xI(true)))
    {
      paramInt = getFirstHeaderVisible();
      ac.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo setSelection pos: %d, appbrandHeight: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.IDk) });
      super.setSelection(paramInt);
      if ((this.myL != null) && (this.ICQ != null))
      {
        this.myL.O(this.ICQ.getRecentAppBrandCount(), this.ICQ.getStarAppBrandCount(), 7);
        this.ICQ.vD(7);
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
    ac.d("MicroMsg.ConversationWithAppBrandListView", "[smoothScrollToPosition] position:%s", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt == 0) && (xI(true)))
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
    ac.d("MicroMsg.ConversationWithAppBrandListView", "[smoothScrollToPositionFromTop] position:%s offset:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    final int i = paramInt1;
    if (paramInt1 == 0)
    {
      i = paramInt1;
      if (xI(true)) {
        i = getFirstHeaderVisible();
      }
    }
    com.tencent.mm.sdk.platformtools.ap.n(new Runnable()
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
    ac.d("MicroMsg.ConversationWithAppBrandListView", "[smoothScrollToPositionFromTop] position:%s offset:%s duration:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt1 == 0) && (xI(true)))
    {
      super.smoothScrollToPositionFromTop(getFirstHeaderVisible(), paramInt2, paramInt3);
      AppMethodBeat.o(38446);
      return;
    }
    super.smoothScrollToPositionFromTop(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(38446);
  }
  
  public final void ul(int paramInt)
  {
    AppMethodBeat.i(38432);
    ac.i("MicroMsg.ConversationWithAppBrandListView", "[next] size:%s isAppBrandHeaderEnable:%s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.ICM) });
    if (!xI(true))
    {
      ac.w("MicroMsg.ConversationWithAppBrandListView", "[next] is disable!");
      if (this.ICK != null) {
        this.ICK.setVisibility(8);
      }
      AppMethodBeat.o(38432);
      return;
    }
    if ((paramInt == 1) && (this.ICK != null)) {
      setEmptyViewVisible(true);
    }
    for (;;)
    {
      if ((this.ICK != null) && (this.ICK.getVisibility() == 8))
      {
        this.ICK.setVisibility(0);
        setSelection(getFirstVisiblePosition());
      }
      AppMethodBeat.o(38432);
      return;
      if ((paramInt > 1) && (this.ICK != null)) {
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
        ac.i("MicroMsg.ConversationWithAppBrandListView", "[UpAppBrandHeaderTask] run...");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.ConversationWithAppBrandListView
 * JD-Core Version:    0.7.0.1
 */
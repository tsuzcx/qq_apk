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
import android.support.v4.view.v;
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
import com.tencent.mm.g.a.ks;
import com.tencent.mm.g.a.mh;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.widget.recent.AppBrandRecentView;
import com.tencent.mm.plugin.appbrand.widget.recent.AppBrandRecentView.e;
import com.tencent.mm.plugin.appbrand.widget.recent.l;
import com.tencent.mm.plugin.taskbar.api.GyroView;
import com.tencent.mm.plugin.taskbar.api.HeaderContainer;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.PlaySound;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.au;
import java.util.Iterator;
import java.util.LinkedList;

public class ConversationWithAppBrandListView
  extends ListView
  implements AbsListView.OnScrollListener, AppBrandRecentView.e
{
  private float CBd;
  private MMFragmentActivity Dpx;
  private float FSk;
  private GyroView FTo;
  private View GQ;
  private LinkedList<ListView.FixedViewInfo> Qcu;
  private boolean QdA;
  private com.tencent.mm.plugin.taskbar.api.a QdB;
  private Runnable QdC;
  private boolean QdD;
  private float QdE;
  private com.tencent.mm.plugin.appbrand.widget.c.a QdF;
  private com.tencent.mm.plugin.appbrand.widget.c.a QdG;
  private com.tencent.mm.plugin.appbrand.widget.c.a QdH;
  private IListener<mh> QdI;
  private int QdJ;
  boolean QdK;
  private final IListener<ks> QdL;
  private a QdM;
  private int QdN;
  private float QdO;
  private float QdP;
  private boolean QdQ;
  private boolean QdR;
  private boolean QdS;
  private boolean QdT;
  private boolean QdU;
  private Runnable QdV;
  private Runnable QdW;
  private boolean QdX;
  private boolean QdY;
  private int QdZ;
  private View Qda;
  private HeaderContainer Qdm;
  private View Qdn;
  private AppBrandRecentView Qdo;
  private boolean Qdp;
  private Paint Qdq;
  private com.tencent.mm.plugin.appbrand.widget.recent.g Qdr;
  private String Qds;
  private float Qdt;
  private com.tencent.mm.plugin.appbrand.widget.c.a.a Qdu;
  private boolean Qdv;
  private boolean Qdw;
  private float Qdx;
  private float Qdy;
  private int Qdz;
  private int asD;
  private int asE;
  private int asF;
  private boolean dLD;
  private boolean dLH;
  private ValueAnimator dgN;
  private boolean hasInit;
  private boolean isInit;
  private int mTouchSlop;
  private Paint nYR;
  private float onW;
  private Vibrator ooM;
  private float riK;
  private float riL;
  private boolean xbw;
  private AbsListView.OnScrollListener yQz;
  
  public ConversationWithAppBrandListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(38422);
    this.Qcu = new LinkedList();
    this.Qdp = false;
    this.Qdv = false;
    this.Qdw = false;
    this.dLH = false;
    this.Qdx = 0.0F;
    this.Qdy = 0.0F;
    this.Qdz = 0;
    this.QdA = false;
    this.QdC = null;
    this.QdD = true;
    this.QdE = 0.0F;
    this.QdF = null;
    this.QdG = null;
    this.QdH = null;
    this.QdI = new IListener() {};
    this.isInit = true;
    this.QdJ = 0;
    this.QdK = false;
    this.asD = -1;
    this.QdL = new ConversationWithAppBrandListView.21(this);
    this.QdM = new a();
    this.QdN = 0;
    this.QdO = 0.0F;
    this.QdP = 0.0F;
    this.QdR = false;
    this.QdT = false;
    this.QdU = false;
    this.QdW = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(38413);
        ConversationWithAppBrandListView.k(ConversationWithAppBrandListView.this);
        ConversationWithAppBrandListView.l(ConversationWithAppBrandListView.this);
        ConversationWithAppBrandListView.m(ConversationWithAppBrandListView.this);
        AppMethodBeat.o(38413);
      }
    };
    this.xbw = false;
    this.QdX = false;
    this.QdY = false;
    this.hasInit = false;
    this.QdF = new com.tencent.mm.plugin.appbrand.widget.c.a(getContext().getResources().getColor(2131099648), getContext().getResources().getColor(2131099947));
    this.QdI.alive();
    AppMethodBeat.o(38422);
  }
  
  private boolean CA(boolean paramBoolean)
  {
    AppMethodBeat.i(38466);
    if (((!this.hasInit) || (!paramBoolean)) && (com.tencent.mm.kernel.g.af(l.class) != null))
    {
      com.tencent.mm.kernel.g.af(l.class);
      this.Qdp = true;
      Log.i("MicroMsg.ConversationWithAppBrandListView", "[isAppBrandHeaderEnable] :%s", new Object[] { Boolean.valueOf(this.Qdp) });
      this.hasInit = true;
    }
    paramBoolean = this.Qdp;
    AppMethodBeat.o(38466);
    return paramBoolean;
  }
  
  private void Cw(boolean paramBoolean)
  {
    AppMethodBeat.i(38434);
    if ((this.Qda == null) || (!CA(true)))
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
    gVD();
    AppMethodBeat.o(38434);
  }
  
  private void Cx(boolean paramBoolean)
  {
    AppMethodBeat.i(38437);
    if (paramBoolean)
    {
      MMHandlerThread.removeRunnable(this.QdM);
      AppMethodBeat.o(38437);
      return;
    }
    MMHandlerThread.removeRunnable(this.QdM);
    MMHandlerThread.postToMainThreadDelayed(this.QdM, 1000L);
    AppMethodBeat.o(38437);
  }
  
  private void Cy(boolean paramBoolean)
  {
    AppMethodBeat.i(38459);
    if ((paramBoolean) && (this.QdV != null))
    {
      MMHandlerThread.removeRunnable(this.QdV);
      this.QdV = null;
      if (this.QdU)
      {
        Cz(false);
        AppMethodBeat.o(38459);
      }
    }
    else if ((!paramBoolean) && (this.QdV == null))
    {
      Runnable local13 = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(38409);
          Log.i("MicroMsg.ConversationWithAppBrandListView", "[CheckShowTipTask]");
          ConversationWithAppBrandListView.h(ConversationWithAppBrandListView.this);
          AppMethodBeat.o(38409);
        }
      };
      this.QdV = local13;
      MMHandlerThread.postToMainThreadDelayed(local13, 3000L);
    }
    AppMethodBeat.o(38459);
  }
  
  private void Cz(boolean paramBoolean)
  {
    AppMethodBeat.i(38460);
    Log.i("MicroMsg.ConversationWithAppBrandListView", "[showTipWithAnim] isShow:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.QdU = true;
      localValueAnimator = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofInt("alpha", new int[] { 0, 77 }) });
      localValueAnimator.setDuration(200L);
      localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(38410);
          int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue("alpha")).intValue();
          ConversationWithAppBrandListView.i(ConversationWithAppBrandListView.this).setAlpha(i);
          ConversationWithAppBrandListView.this.invalidate();
          AppMethodBeat.o(38410);
        }
      });
      localValueAnimator.start();
      if (this.Qdr != null) {
        this.Qdr.ccT();
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
        ConversationWithAppBrandListView.i(ConversationWithAppBrandListView.this).setAlpha(i);
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
        ConversationWithAppBrandListView.j(ConversationWithAppBrandListView.this);
        AppMethodBeat.o(38412);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator) {}
    });
    localValueAnimator.start();
    AppMethodBeat.o(38460);
  }
  
  private boolean aj(MotionEvent paramMotionEvent)
  {
    int j = 0;
    AppMethodBeat.i(38450);
    if (!gVK())
    {
      AppMethodBeat.o(38450);
      return false;
    }
    if (paramMotionEvent.getAction() == 0)
    {
      this.QdP = paramMotionEvent.getY();
      if (this.dgN != null) {
        this.dgN.cancel();
      }
    }
    float f3;
    try
    {
      if (((paramMotionEvent.getAction() != 2) || (Math.abs(paramMotionEvent.getY() - this.riL) <= 2.0F) || (getFirstVisiblePosition() != 0) || (this.Qdm.getTop() != 0)) && (getChildTranslationY() == 0.0F)) {
        break label582;
      }
      Cx(true);
      if ((getHeight() - getTabViewHeight() - this.QdN) / 2 <= this.QdO) {
        Cy(false);
      }
      for (;;)
      {
        float f1 = paramMotionEvent.getY();
        float f2 = this.QdP;
        f3 = getHeight() - getTabViewHeight() - this.QdN;
        this.QdO = ((f1 - f2) * 0.4F + this.QdO);
        if (this.QdO >= 0.0F) {
          break label488;
        }
        this.QdO = 0.0F;
        gVI();
        invalidate();
        return false;
        if (paramMotionEvent.getActionMasked() == 5)
        {
          this.QdP = paramMotionEvent.getY();
          break;
        }
        if (((paramMotionEvent.getAction() != 1) && (paramMotionEvent.getAction() != 3)) || (this.Qdm.getTop() != 0) || (getChildTranslationY() == 0.0F)) {
          break;
        }
        Cy(true);
        this.QdR = false;
        Log.d("MicroMsg.ConversationWithAppBrandListView", "[animationChild] offset:%s delay:%s duration%s", new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(180) });
        if (!gVK()) {
          break;
        }
        if (this.dgN != null) {
          this.dgN.cancel();
        }
        this.dgN = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("deltaY", new float[] { getChildTranslationY() + 0.0F, 0.0F }), PropertyValuesHolder.ofFloat("headerDeltaY", new float[] { getHeaderY() + 0.0F, 0.0F }) });
        this.dgN.setDuration(180L);
        this.dgN.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
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
        this.dgN.addListener(new Animator.AnimatorListener()
        {
          public final void onAnimationCancel(Animator paramAnonymousAnimator)
          {
            AppMethodBeat.i(38408);
            ConversationWithAppBrandListView.g(ConversationWithAppBrandListView.this);
            AppMethodBeat.o(38408);
          }
          
          public final void onAnimationEnd(Animator paramAnonymousAnimator)
          {
            AppMethodBeat.i(38407);
            ConversationWithAppBrandListView.g(ConversationWithAppBrandListView.this);
            AppMethodBeat.o(38407);
          }
          
          public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
          
          public final void onAnimationStart(Animator paramAnonymousAnimator) {}
        });
        this.dgN.setStartDelay(0L);
        this.dgN.start();
        break;
        Cy(true);
      }
      i = j;
    }
    finally
    {
      this.QdP = paramMotionEvent.getY();
      AppMethodBeat.o(38450);
    }
    label488:
    int i;
    if (f3 < this.QdO)
    {
      this.QdO = f3;
      i = j;
    }
    for (;;)
    {
      if (i < getChildCount())
      {
        if (i == 0) {
          getChildAt(i).setTranslationY(this.QdO * 0.5F);
        } else {
          getChildAt(i).setTranslationY(this.QdO);
        }
      }
      else
      {
        invalidate();
        this.QdP = paramMotionEvent.getY();
        AppMethodBeat.o(38450);
        return true;
        label582:
        this.QdP = paramMotionEvent.getY();
        AppMethodBeat.o(38450);
        return false;
      }
      i += 1;
    }
  }
  
  private void anO(int paramInt)
  {
    AppMethodBeat.i(38453);
    Log.i("MicroMsg.ConversationWithAppBrandListView", "[closeAppBrandRecentView] isOpenAppBrandRecentView:%s type:%s", new Object[] { Boolean.valueOf(this.QdS), Integer.valueOf(paramInt) });
    if ((this.QdS) && (getChildAt(0) != null) && (this.Qdr != null) && (this.Qdu != null)) {
      this.Qdr.R(this.Qdu.caL(), this.Qdu.caM(), paramInt);
    }
    View localView;
    if (getFirstVisiblePosition() == 0)
    {
      localView = getChildAt(0);
      if (localView != null) {
        break label161;
      }
    }
    label161:
    for (paramInt = 0;; paramInt = localView.getBottom())
    {
      if (paramInt != 0) {
        smoothScrollToPositionFromTop(getFirstHeaderVisible(), 0, 150);
      }
      gVI();
      Cx(true);
      setOpenAppBrandRecentView(false);
      MMHandlerThread.postToMainThreadDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(38404);
          if (ConversationWithAppBrandListView.c(ConversationWithAppBrandListView.this) != null)
          {
            Log.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo scrollToFirstPage");
            ConversationWithAppBrandListView.c(ConversationWithAppBrandListView.this);
          }
          AppMethodBeat.o(38404);
        }
      }, 500L);
      AppMethodBeat.o(38453);
      return;
    }
  }
  
  private float anP(int paramInt)
  {
    AppMethodBeat.i(38464);
    Log.d("MicroMsg.ConversationWithAppBrandListView", "[isFull] totalItemCount:" + paramInt + " getFirstVisiblePosition:" + getFirstVisiblePosition() + " getLastVisiblePosition:" + getLastVisiblePosition() + " getHeaderViewsCount:" + getHeaderViewsCount() + " getFooterViewsCount:" + getFooterViewsCount());
    int i = (int)getResources().getDimension(2131165533);
    paramInt = paramInt - getHeaderViewsCount() - getFooterViewsCount();
    float f = getMeasuredHeight() - i * paramInt;
    Log.i("MicroMsg.ConversationWithAppBrandListView", "[isFull] height:%s rawCount:%s extraHeight:%s", new Object[] { Integer.valueOf(getHeight()), Integer.valueOf(paramInt), Float.valueOf(f) });
    AppMethodBeat.o(38464);
    return f;
  }
  
  private void gVD()
  {
    boolean bool = false;
    AppMethodBeat.i(38436);
    int j = getFirstHeaderVisible();
    localLayoutParams = (LinearLayout.LayoutParams)this.Qda.getLayoutParams();
    int k = localLayoutParams.height;
    for (;;)
    {
      try
      {
        if (getAdapter() != null) {
          continue;
        }
        i = 0;
        f1 = anP(i);
      }
      catch (Exception localException)
      {
        int i;
        float f2;
        float f1 = 0.0F;
        continue;
        localLayoutParams.height = ((int)f2);
        if (!this.isInit) {
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
      Log.i("MicroMsg.ConversationWithAppBrandListView", "[checkEmptyFooter] isRealFull:" + bool + " extraHeight:" + f2);
      if (!bool) {
        continue;
      }
      localLayoutParams.height = getTabViewHeight();
      if (k != localLayoutParams.height)
      {
        this.Qda.setLayoutParams(localLayoutParams);
        if (!this.isInit) {
          super.setSelection(j);
        }
      }
      AppMethodBeat.o(38436);
      return;
      i = getAdapter().getCount();
    }
  }
  
  private boolean gVE()
  {
    AppMethodBeat.i(38440);
    if ((this.Qdn != null) && (this.Qdu != null))
    {
      int i = this.Qdm.getMeasuredHeight();
      if ((i != 0) && (i != this.QdN))
      {
        this.QdN = i;
        AppMethodBeat.o(38440);
        return true;
      }
    }
    AppMethodBeat.o(38440);
    return false;
  }
  
  private void gVF()
  {
    AppMethodBeat.i(38441);
    if (gVE())
    {
      if (this.FTo != null) {
        this.FTo.setVisibility(0);
      }
      this.Qdx = (-(this.FSk - getResources().getDimension(2131165502)));
      this.Qdy = (-(this.FSk - (this.QdN / 2 - getResources().getDimension(2131165483))));
      if (!this.dLH)
      {
        if (this.Qdn != null) {
          this.Qdn.setTranslationY(this.Qdx);
        }
        if (this.GQ != null) {
          this.GQ.setTranslationY(0.0F);
        }
        Log.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo initAppBrandHeaderHeight AppBrandHeader appBrandHeight: %d, setTranslationY: %s", new Object[] { Integer.valueOf(this.QdN), Float.valueOf(this.Qdx) });
        AppMethodBeat.o(38441);
        return;
      }
      if (this.Qdn != null) {
        this.Qdn.setTranslationY(0.0F);
      }
      if (this.GQ != null) {
        this.GQ.setTranslationY(this.Qdy);
      }
      Log.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo initAppBrandHeaderHeight emptyView appBrandHeight: %d, setTranslationY: %s", new Object[] { Integer.valueOf(this.QdN), Float.valueOf(this.Qdy) });
    }
    AppMethodBeat.o(38441);
  }
  
  private void gVG()
  {
    AppMethodBeat.i(38442);
    if (this.QdA)
    {
      AppMethodBeat.o(38442);
      return;
    }
    if (com.tencent.mm.kernel.g.af(l.class) != null)
    {
      this.Qdm = ((com.tencent.mm.plugin.taskbar.api.c)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.taskbar.api.c.class)).hn(this.Dpx);
      this.QdA = true;
      this.Qdm.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
      this.Qdn = this.Qdm.findViewById(2131296998);
      this.Qdn.setVisibility(8);
      this.FTo = this.Qdm.getGyroView();
      this.Qdu = this.Qdm.getHeaderView();
      new AppBrandRecentView.e()
      {
        public final void yL(int paramAnonymousInt)
        {
          AppMethodBeat.i(38398);
          Log.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo onDone MyAppBrand size: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
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
      };
      new AppBrandRecentView.e()
      {
        public final void yL(int paramAnonymousInt)
        {
          AppMethodBeat.i(38399);
          Log.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo onDone RecentAppBrand size: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
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
      };
      new Object() {};
      new Object() {};
      this.GQ = this.Qdm.getEmptyView();
      this.Qcu.remove(this.Qdm);
      Object localObject = new ListView.FixedViewInfo(this);
      ((ListView.FixedViewInfo)localObject).view = this.Qdm;
      ((ListView.FixedViewInfo)localObject).data = null;
      ((ListView.FixedViewInfo)localObject).isSelectable = true;
      this.Qcu.addFirst(localObject);
      localObject = this.Qcu.iterator();
      while (((Iterator)localObject).hasNext())
      {
        ListView.FixedViewInfo localFixedViewInfo = (ListView.FixedViewInfo)((Iterator)localObject).next();
        super.addHeaderView(localFixedViewInfo.view, localFixedViewInfo.data, localFixedViewInfo.isSelectable);
      }
    }
    Log.e("MicroMsg.ConversationWithAppBrandListView", "alvinluo addAppBrandHalfView error");
    AppMethodBeat.o(38442);
    return;
    AppMethodBeat.o(38442);
  }
  
  private void gVH()
  {
    AppMethodBeat.i(38451);
    if (!this.QdS)
    {
      PlaySound.play(getContext(), 2131755659, 3);
      if ((this.Qdr != null) && (this.Qdu != null)) {
        this.Qdr.eO(this.Qdu.caL(), this.Qdu.caM());
      }
    }
    if ((this.QdK) && (this.Qdo != null))
    {
      this.Qdo.getAdapter().atj.notifyChanged();
      this.QdK = true;
    }
    super.smoothScrollToPositionFromTop(0, 0, 250);
    Cx(true);
    setOpenAppBrandRecentView(true);
    AppMethodBeat.o(38451);
  }
  
  private void gVI()
  {
    AppMethodBeat.i(38456);
    int i = 0;
    while (i < getChildCount())
    {
      getChildAt(i).setTranslationY(0.0F);
      i += 1;
    }
    this.QdO = 0.0F;
    invalidate();
    AppMethodBeat.o(38456);
  }
  
  private void gVJ()
  {
    AppMethodBeat.i(38461);
    Log.d("MicroMsg.ConversationWithAppBrandListView", "alvinluo resetAppBrandHeaderBg");
    if (this.nYR != null)
    {
      int i = this.Dpx.getResources().getColor(2131099953);
      this.nYR.setColor(i);
    }
    AppMethodBeat.o(38461);
  }
  
  private boolean gVK()
  {
    AppMethodBeat.i(38467);
    if (this.Qdn != null)
    {
      if ((CA(true)) && (this.Qdn.getVisibility() == 0))
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
    this.Qda = new View(getContext());
    this.Qda.setLayoutParams(new LinearLayout.LayoutParams(-1, 0));
    localLinearLayout.addView(this.Qda);
    localLinearLayout.setBackgroundColor(getContext().getResources().getColor(2131101424));
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
    if ((this.Qdm != null) && (this.QdN != 0))
    {
      f2 = 1.0F - Math.abs(this.Qdm.getTop() * 1.0F) / this.QdN;
      if (f2 >= 0.0F) {
        break label122;
      }
    }
    for (;;)
    {
      Log.d("MicroMsg.ConversationWithAppBrandListView", "alvinluo header top: %d, header bottom: %d, ratio: %f, appBrandHeight: %d", new Object[] { Integer.valueOf(this.Qdm.getTop()), Integer.valueOf(this.Qdm.getBottom()), Float.valueOf(f1), Integer.valueOf(this.QdN) });
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
    if (this.Qdz == 0)
    {
      View localView = getRootView().findViewById(2131303053);
      if (localView != null)
      {
        Log.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo initTabViewHeight tabView.getHeight: %d", new Object[] { Integer.valueOf(localView.getHeight()) });
        this.Qdz = localView.getHeight();
      }
    }
    int i = this.Qdz;
    AppMethodBeat.o(38435);
    return i;
  }
  
  private void setEmptyViewVisible(boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(38438);
    Log.i("MicroMsg.ConversationWithAppBrandListView", "[setEmptyViewVisible] isShow:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    View localView;
    if (this.GQ != null)
    {
      localView = this.GQ;
      if (paramBoolean)
      {
        i = 0;
        localView.setVisibility(i);
      }
    }
    else if (this.Qdn != null)
    {
      localView = this.Qdn.findViewById(2131296999);
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
    this.QdS = paramBoolean;
  }
  
  public void addHeaderView(View paramView, Object paramObject, boolean paramBoolean)
  {
    AppMethodBeat.i(38428);
    ListView.FixedViewInfo localFixedViewInfo = new ListView.FixedViewInfo(this);
    localFixedViewInfo.view = paramView;
    localFixedViewInfo.data = paramObject;
    localFixedViewInfo.isSelectable = paramBoolean;
    this.Qcu.add(localFixedViewInfo);
    if (getAdapter() != null) {
      super.addHeaderView(localFixedViewInfo.view, localFixedViewInfo.data, localFixedViewInfo.isSelectable);
    }
    Log.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo addHeaderView %d", new Object[] { Integer.valueOf(this.Qcu.size()) });
    AppMethodBeat.o(38428);
  }
  
  public final void as(long paramLong, int paramInt)
  {
    AppMethodBeat.i(38431);
    Log.i("MicroMsg.ConversationWithAppBrandListView", "[hideAppBrandRecentView] delay:%s, type: %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    if (!CA(true))
    {
      if (this.Qdn != null) {
        this.Qdn.setVisibility(8);
      }
      AppMethodBeat.o(38431);
      return;
    }
    if (getFirstVisiblePosition() != 0)
    {
      AppMethodBeat.o(38431);
      return;
    }
    if ((this.Qdr != null) && (this.Qdu != null)) {
      this.Qdr.R(this.Qdu.caL(), this.Qdu.caM(), paramInt);
    }
    if (paramLong > 0L)
    {
      if (this.QdC != null) {
        removeCallbacks(this.QdC);
      }
      this.QdC = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(38420);
          if (ConversationWithAppBrandListView.c(ConversationWithAppBrandListView.this) != null)
          {
            Log.d("MicroMsg.ConversationWithAppBrandListView", "alvinluo resetToFirstPage");
            ConversationWithAppBrandListView.c(ConversationWithAppBrandListView.this);
          }
          if (ConversationWithAppBrandListView.d(ConversationWithAppBrandListView.this) != null)
          {
            localObject = ConversationWithAppBrandListView.d(ConversationWithAppBrandListView.this);
            com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.axQ(), "com/tencent/mm/ui/conversation/ConversationWithAppBrandListView$9", "run", "()V", "Undefined", "smoothScrollToPosition", "(I)V");
            ((AppBrandRecentView)localObject).smoothScrollToPosition(((Integer)locala.pG(0)).intValue());
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
      postDelayed(this.QdC, paramLong);
    }
    for (;;)
    {
      gVI();
      AppMethodBeat.o(38431);
      return;
      if (this.Qdo != null)
      {
        AppBrandRecentView localAppBrandRecentView = this.Qdo;
        com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
        com.tencent.mm.hellhoundlib.a.a.a(localAppBrandRecentView, locala.axQ(), "com/tencent/mm/ui/conversation/ConversationWithAppBrandListView", "hideAppBrandRecentView", "(JI)V", "Undefined", "smoothScrollToPosition", "(I)V");
        localAppBrandRecentView.smoothScrollToPosition(((Integer)locala.pG(0)).intValue());
        com.tencent.mm.hellhoundlib.a.a.a(localAppBrandRecentView, "com/tencent/mm/ui/conversation/ConversationWithAppBrandListView", "hideAppBrandRecentView", "(JI)V", "Undefined", "smoothScrollToPosition", "(I)V");
      }
      setSelection(0);
      Log.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo resetAppBrandHeaderBg");
      gVJ();
    }
  }
  
  public boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    AppMethodBeat.i(38447);
    if ((CA(true)) && (getFirstVisiblePosition() == 0) && (paramInt2 < 0))
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
        this.riK = f;
        this.CBd = f;
        f = paramMotionEvent.getY();
        this.riL = f;
        this.onW = f;
      }
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      return bool;
    }
    finally
    {
      this.riK = paramMotionEvent.getX();
      this.riL = paramMotionEvent.getY();
      AppMethodBeat.o(38448);
    }
  }
  
  public int getFirstHeaderVisible()
  {
    AppMethodBeat.i(38465);
    Iterator localIterator = this.Qcu.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      ListView.FixedViewInfo localFixedViewInfo = (ListView.FixedViewInfo)localIterator.next();
      if (localFixedViewInfo.view == this.Qdm)
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
              Log.i("MicroMsg.ConversationWithAppBrandListView", "[getFirstHeaderVisible] index:%s", new Object[] { Integer.valueOf(i) });
              AppMethodBeat.o(38465);
              return i;
            }
            j += 1;
          }
        }
        i += 1;
      }
    }
    Log.i("MicroMsg.ConversationWithAppBrandListView", "[getFirstHeaderVisible] index:%s, size: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(this.Qcu.size()) });
    AppMethodBeat.o(38465);
    return i;
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(38426);
    super.onConfigurationChanged(paramConfiguration);
    Log.i("MicroMsg.ConversationWithAppBrandListView", "[onConfigurationChanged] orientation:%s", new Object[] { Integer.valueOf(paramConfiguration.orientation) });
    this.QdK = true;
    Cw(true);
    this.QdD = false;
    AppMethodBeat.o(38426);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(38457);
    super.onDraw(paramCanvas);
    if ((getFirstVisiblePosition() == 0) && (this.Qdm != null))
    {
      paramCanvas.drawRect(0.0F, 0.0F, getWidth(), this.Qdm.getBottom() + this.QdO, this.nYR);
      if (getChildAt(1) != null) {
        if ((getHeight() == 0) || (!this.QdU)) {
          break label150;
        }
      }
    }
    label150:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        float f1 = (getWidth() - this.Qdt) / 2.0F;
        float f2 = this.Qdm.getBottom();
        float f3 = this.QdO;
        float f4 = getResources().getDimension(2131165507);
        paramCanvas.drawText(this.Qds, f1, f2 + f3 - f4, this.Qdq);
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
      this.asD = paramMotionEvent.getPointerId(0);
      this.asE = ((int)(paramMotionEvent.getX() + 0.5F));
      this.asF = ((int)(paramMotionEvent.getY() + 0.5F));
      bool = super.onInterceptTouchEvent(paramMotionEvent);
      AppMethodBeat.o(38427);
      return bool;
    case 5: 
      this.asD = paramMotionEvent.getPointerId(j);
      this.asE = ((int)(paramMotionEvent.getX(j) + 0.5F));
      this.asF = ((int)(paramMotionEvent.getY(j) + 0.5F));
      bool = super.onInterceptTouchEvent(paramMotionEvent);
      AppMethodBeat.o(38427);
      return bool;
    }
    j = paramMotionEvent.findPointerIndex(this.asD);
    if (j < 0)
    {
      AppMethodBeat.o(38427);
      return false;
    }
    i = (int)(paramMotionEvent.getX(j) + 0.5F);
    int k = (int)(paramMotionEvent.getY(j) + 0.5F);
    j = this.asE;
    k -= this.asF;
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
    if ((paramBoolean) && (CA(true)))
    {
      if (this.isInit)
      {
        Cw(true);
        post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(38416);
            ConversationWithAppBrandListView.this.setSelection(0);
            AppMethodBeat.o(38416);
          }
        });
        this.QdJ = paramInt4;
        this.isInit = false;
        AppMethodBeat.o(38425);
        return;
      }
      if ((!this.dLD) && (this.QdJ != paramInt4))
      {
        Log.i("MicroMsg.ConversationWithAppBrandListView", "[onLayout] mLastBottom:" + this.QdJ + " b:" + paramInt4);
        Cw(true);
        this.QdJ = paramInt4;
      }
    }
    AppMethodBeat.o(38425);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(38439);
    super.onMeasure(paramInt1, paramInt2);
    gVF();
    AppMethodBeat.o(38439);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(38463);
    if (this.yQz != null) {
      this.yQz.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
    if (!CA(true))
    {
      AppMethodBeat.o(38463);
      return;
    }
    gVF();
    if (this.QdN == 0)
    {
      AppMethodBeat.o(38463);
      return;
    }
    Log.v("MicroMsg.ConversationWithAppBrandListView", "alvinluo onScroll firstVisibleItem: %d, visibleItemCount: %d, totalItemCount: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    float f1;
    View localView;
    label278:
    GyroView localGyroView;
    if (paramInt1 == 0)
    {
      float f2 = getRatio();
      if ((this.QdE == 0.0F) || (this.QdE == 1.0F) || (Math.abs(f2 - this.QdE) >= 0.01D))
      {
        this.QdE = f2;
        f1 = f2;
        if (this.Qdm != null)
        {
          if ((this.Qdm.getTop() != 0) || (this.QdD)) {
            break label278;
          }
          f1 = 0.0F;
        }
      }
      for (;;)
      {
        if (this.QdF != null)
        {
          paramInt2 = this.QdF.aW(f1);
          if (this.nYR != null) {
            this.nYR.setColor(paramInt2);
          }
          if (this.Qdn != null) {
            this.Qdn.setBackgroundColor(paramInt2);
          }
        }
        Cx(false);
        paramAbsListView = paramAbsListView.getChildAt(0);
        if ((paramAbsListView == null) || (!(paramAbsListView instanceof HeaderContainer))) {
          break label530;
        }
        localView = paramAbsListView.findViewById(2131296998);
        if ((localView != null) && (localView.getVisibility() != 8)) {
          break;
        }
        AppMethodBeat.o(38463);
        return;
        f1 = f2;
        if (this.Qdm.getTop() != 0)
        {
          this.QdD = true;
          f1 = f2;
        }
      }
      localGyroView = ((HeaderContainer)paramAbsListView).getGyroView();
      Log.v("MicroMsg.ConversationWithAppBrandListView", "alvinluo appBrandHeaderTransH: %s, emptyTransH: %s, headerParent.bottom: %s, translationY: %f, mAppBrandHeight: %d", new Object[] { Float.valueOf(this.Qdx), Float.valueOf(this.Qdy), Integer.valueOf(paramAbsListView.getBottom()), Float.valueOf(localView.getTranslationY()), Integer.valueOf(this.QdN) });
      if (paramAbsListView.getBottom() <= 3)
      {
        if (!this.dLH)
        {
          localView.setTranslationY(this.Qdx);
          if (localGyroView.getVisibility() == 0)
          {
            localGyroView.setVerticalScroll(0.0F);
            localGyroView.setVisibility(8);
          }
          this.QdY = false;
        }
      }
      else
      {
        if ((paramAbsListView.getBottom() <= 3) || (paramAbsListView.getBottom() > this.FSk) || ((localView.getTranslationY() == 0.0F) && ((this.GQ == null) || (this.GQ.getTranslationY() == 0.0F)))) {
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
      this.QdZ = paramInt1;
      if ((this.QdX) && (this.xbw) && (paramInt1 == 0))
      {
        Log.e("MicroMsg.ConversationWithAppBrandListView", "[Stop fling!]");
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
              Log.i("MicroMsg.ConversationWithAppBrandListView", "[smoothScrollBy] offset: ".concat(String.valueOf(i)));
              ConversationWithAppBrandListView.this.smoothScrollToPositionFromTop(ConversationWithAppBrandListView.this.getFirstHeaderVisible(), 0, 300);
              ConversationWithAppBrandListView.m(ConversationWithAppBrandListView.this);
              AppMethodBeat.o(38414);
              return;
            }
          }
        });
        this.QdX = false;
      }
      MMHandlerThread.removeRunnable(this.QdW);
      MMHandlerThread.postToMainThreadDelayed(this.QdW, 50L);
      AppMethodBeat.o(38463);
      return;
      if (this.GQ != null) {
        this.GQ.setTranslationY(this.Qdy);
      }
      localView.setTranslationY(0.0F);
      break;
      label637:
      if ((paramAbsListView.getBottom() > this.FSk) && ((localView.getTranslationY() != 0.0F) || ((this.GQ != null) && (this.GQ.getTranslationY() != 0.0F))))
      {
        f1 = (float)(1.0D * (paramAbsListView.getBottom() - this.FSk) / (this.QdN - this.FSk));
        Log.v("MicroMsg.ConversationWithAppBrandListView", "alvinluo checkUpAppBrandHeader appbrandHeader translationY: %f, percent: %f, setTranslationY: %f, isEmpty: %b", new Object[] { Float.valueOf(localView.getTranslationY()), Float.valueOf(f1), Float.valueOf(this.Qdx * (1.0F - f1)), Boolean.valueOf(this.dLH) });
        if (!this.dLH) {
          localView.setTranslationY(this.Qdx * (1.0F - f1));
        }
        for (;;)
        {
          localGyroView.setTranslationY(-this.FSk / 2.0F + localGyroView.getHeight() / 2 + (this.FSk / 2.0F + localGyroView.getHeight()) * f1);
          localGyroView.setAlpha(1.0F - 2.0F * f1);
          if ((!this.QdY) && (1.0F != f1))
          {
            this.ooM.vibrate(10L);
            this.QdY = true;
          }
          Cx(true);
          break;
          if (this.GQ != null)
          {
            Log.v("MicroMsg.ConversationWithAppBrandListView", "alvinluo emptyView translationY: %f, set: %f", new Object[] { Float.valueOf(this.GQ.getTranslationY()), Float.valueOf(-this.Qdy * (1.0F - f1)) });
            this.GQ.setTranslationY(this.Qdy * (1.0F - f1));
          }
          localView.setTranslationY(0.0F);
        }
        if (this.Qdm != null)
        {
          paramAbsListView = this.Qdm.findViewById(2131296998);
          if (this.dLH) {
            break label1011;
          }
          if (paramAbsListView != null) {
            paramAbsListView.setTranslationY(this.Qdx);
          }
        }
        for (;;)
        {
          if ((this.QdZ != 0) || (paramInt1 == 0)) {
            break label1039;
          }
          anO(4);
          Cy(true);
          Cx(true);
          break;
          if (this.GQ != null) {
            this.GQ.setTranslationY(this.Qdy);
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
    if (this.yQz != null) {
      this.yQz.onScrollStateChanged(paramAbsListView, paramInt);
    }
    if ((getFirstVisiblePosition() != 0) && (paramInt == 2) && (!this.QdT)) {
      this.xbw = true;
    }
    AppMethodBeat.o(38458);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(38449);
    boolean bool;
    if (!CA(true))
    {
      bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(38449);
      return bool;
    }
    if (paramMotionEvent.getAction() == 0) {
      if (getFirstVisiblePosition() != 0) {
        this.QdX = true;
      }
    }
    for (;;)
    {
      if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
      {
        Cx(true);
        this.QdQ = false;
        if (getChildTranslationY() > 0.0F) {
          gVH();
        }
      }
      if (aj(paramMotionEvent)) {
        break;
      }
      if ((this.QdQ) && (paramMotionEvent.getAction() == 2))
      {
        paramMotionEvent.setAction(0);
        super.onTouchEvent(paramMotionEvent);
        paramMotionEvent.setAction(2);
        this.QdQ = false;
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
        if ((Math.abs(paramMotionEvent.getX() - this.riK) < 3.0F) && (Math.abs(paramMotionEvent.getY() - this.riL) < 3.0F)) {
          super.onTouchEvent(paramMotionEvent);
        }
        if (getChildTranslationY() < 60.0F * getResources().getDisplayMetrics().density)
        {
          float f1 = Math.abs(paramMotionEvent.getX() - this.CBd);
          float f2 = Math.abs(paramMotionEvent.getY() - this.onW);
          if (((paramMotionEvent.getY() - this.onW < -5.0F) && (f1 - f2 < 0.0F) && (getFirstVisiblePosition() == 0)) || ((localView.getBottom() > 0) && (localView.getBottom() < this.FSk))) {
            anO(4);
          } else if ((localView.getBottom() >= this.FSk) && (paramMotionEvent.getY() - this.onW > 5.0F)) {
            gVH();
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
      if ((paramMotionEvent.getAction() == 2) && (!this.QdQ) && (Math.abs(paramMotionEvent.getY() - this.riL) > 2.0F))
      {
        paramMotionEvent.setAction(3);
        super.onTouchEvent(paramMotionEvent);
        this.QdQ = true;
      }
      else if (!this.QdQ)
      {
        super.onTouchEvent(paramMotionEvent);
      }
    }
  }
  
  public void setActionBarUpdateCallback(com.tencent.mm.plugin.taskbar.api.a parama)
  {
    this.QdB = parama;
  }
  
  public void setActivity(MMFragmentActivity paramMMFragmentActivity)
  {
    AppMethodBeat.i(38424);
    this.Dpx = paramMMFragmentActivity;
    gVG();
    AppMethodBeat.o(38424);
  }
  
  public void setAdapter(final ListAdapter paramListAdapter)
  {
    AppMethodBeat.i(38423);
    Log.i("MicroMsg.ConversationWithAppBrandListView", "[init] ");
    this.QdL.alive();
    this.ooM = ((Vibrator)getContext().getSystemService("vibrator"));
    this.mTouchSlop = v.a(ViewConfiguration.get(getContext()));
    this.nYR = new Paint(1);
    this.Qdq = new Paint(1);
    this.nYR.setColor(getResources().getColor(2131099975));
    this.Qdq.setColor(-2147483648);
    this.Qdq.setTextSize(getResources().getDimension(2131165594));
    CA(false);
    if (com.tencent.mm.kernel.g.af(l.class) != null) {
      this.Qdr = ((l)com.tencent.mm.kernel.g.af(l.class)).ccW();
    }
    this.FSk = (100.0F * getResources().getDisplayMetrics().density);
    Log.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo init mAnimationPadding: %f, density: %f", new Object[] { Float.valueOf(this.FSk), Float.valueOf(getResources().getDisplayMetrics().density) });
    this.Qds = getResources().getString(2131758188);
    this.Qdt = this.Qdq.measureText(this.Qds);
    super.setOnScrollListener(this);
    paramListAdapter.registerDataSetObserver(new DataSetObserver()
    {
      int Qec = -1;
      
      public final void onChanged()
      {
        AppMethodBeat.i(38406);
        boolean bool;
        if (this.Qec != paramListAdapter.getCount())
        {
          if (this.Qec <= paramListAdapter.getCount()) {
            break label108;
          }
          bool = true;
          Log.i("MicroMsg.ConversationWithAppBrandListView", "[onChanged] isDelete:%s", new Object[] { Boolean.valueOf(bool) });
          if (this.Qec <= paramListAdapter.getCount()) {
            break label113;
          }
          ConversationWithAppBrandListView.a(ConversationWithAppBrandListView.this, false);
          ConversationWithAppBrandListView.a(ConversationWithAppBrandListView.this, true);
        }
        for (;;)
        {
          this.Qec = paramListAdapter.getCount();
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
      final RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)getLayoutParams();
      localLayoutParams.topMargin = au.eu(getContext());
      Log.i("MicroMsg.ConversationWithAppBrandListView", "[initLayoutParams]1 ActionBar height:%s", new Object[] { Integer.valueOf(localLayoutParams.topMargin) });
      if (localLayoutParams.topMargin <= 0) {
        postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(38415);
            localLayoutParams.topMargin = au.eu(ConversationWithAppBrandListView.this.getContext());
            Log.i("MicroMsg.ConversationWithAppBrandListView", "[initLayoutParams]2 ActionBar height:%s", new Object[] { Integer.valueOf(localLayoutParams.topMargin) });
            AppMethodBeat.o(38415);
          }
        }, 200L);
      }
      if (this.Dpx != null) {
        gVG();
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
        Log.printErrStackTrace("MicroMsg.ConversationWithAppBrandListView", localException, "alvinluo initLayoutParams exception", new Object[0]);
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
        b localb = new b();
        localb.bm(paramAnonymousAdapterView);
        localb.bm(paramAnonymousView);
        localb.pH(paramAnonymousInt);
        localb.zo(paramAnonymousLong);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/ConversationWithAppBrandListView$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
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
          ConversationWithAppBrandListView.this.as(500L, 8);
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
    this.yQz = paramOnScrollListener;
  }
  
  public void setSelection(int paramInt)
  {
    AppMethodBeat.i(38443);
    Log.i("MicroMsg.ConversationWithAppBrandListView", "[setSelection] position:%s", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt == 0) && (CA(true)))
    {
      paramInt = getFirstHeaderVisible();
      Log.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo setSelection pos: %d, appbrandHeight: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.QdN) });
      super.setSelection(paramInt);
      if ((this.Qdr != null) && (this.Qdu != null)) {
        this.Qdr.R(this.Qdu.caL(), this.Qdu.caM(), 7);
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
    Log.d("MicroMsg.ConversationWithAppBrandListView", "[smoothScrollToPosition] position:%s", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt == 0) && (CA(true)))
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
    Log.d("MicroMsg.ConversationWithAppBrandListView", "[smoothScrollToPositionFromTop] position:%s offset:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    final int i = paramInt1;
    if (paramInt1 == 0)
    {
      i = paramInt1;
      if (CA(true)) {
        i = getFirstHeaderVisible();
      }
    }
    MMHandlerThread.postToMainThreadDelayed(new Runnable()
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
    Log.d("MicroMsg.ConversationWithAppBrandListView", "[smoothScrollToPositionFromTop] position:%s offset:%s duration:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt1 == 0) && (CA(true)))
    {
      super.smoothScrollToPositionFromTop(getFirstHeaderVisible(), paramInt2, paramInt3);
      AppMethodBeat.o(38446);
      return;
    }
    super.smoothScrollToPositionFromTop(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(38446);
  }
  
  public final void yL(int paramInt)
  {
    AppMethodBeat.i(38432);
    Log.i("MicroMsg.ConversationWithAppBrandListView", "[next] size:%s isAppBrandHeaderEnable:%s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.Qdp) });
    if (!CA(true))
    {
      Log.w("MicroMsg.ConversationWithAppBrandListView", "[next] is disable!");
      if (this.Qdn != null) {
        this.Qdn.setVisibility(8);
      }
      AppMethodBeat.o(38432);
      return;
    }
    if ((paramInt == 1) && (this.Qdn != null)) {
      setEmptyViewVisible(true);
    }
    for (;;)
    {
      if ((this.Qdn != null) && (this.Qdn.getVisibility() == 8))
      {
        this.Qdn.setVisibility(0);
        setSelection(getFirstVisiblePosition());
      }
      AppMethodBeat.o(38432);
      return;
      if ((paramInt > 1) && (this.Qdn != null)) {
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
        Log.i("MicroMsg.ConversationWithAppBrandListView", "[UpAppBrandHeaderTask] run...");
        if (localView.getBottom() >= ConversationWithAppBrandListView.n(ConversationWithAppBrandListView.this))
        {
          ConversationWithAppBrandListView.o(ConversationWithAppBrandListView.this);
          AppMethodBeat.o(38421);
          return;
        }
        ConversationWithAppBrandListView.p(ConversationWithAppBrandListView.this);
      }
      AppMethodBeat.o(38421);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.ConversationWithAppBrandListView
 * JD-Core Version:    0.7.0.1
 */
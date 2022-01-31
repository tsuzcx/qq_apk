package com.tencent.mm.ui.conversation;

import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
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
import com.tencent.mm.g.a.ip;
import com.tencent.mm.g.a.jv;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.widget.header.GyroView;
import com.tencent.mm.plugin.appbrand.widget.header.HeaderContainer;
import com.tencent.mm.plugin.appbrand.widget.header.a.a.b;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.e;
import com.tencent.mm.plugin.appbrand.widget.recentview.d;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.am;
import java.util.Iterator;
import java.util.LinkedList;

public class ConversationWithAppBrandListView
  extends ListView
  implements AbsListView.OnScrollListener, AppBrandRecentView.e
{
  private View AiN;
  private HeaderContainer AiT;
  private View AiU;
  private AppBrandRecentView AiV;
  private boolean AiW;
  private Paint AiX;
  private Paint AiY;
  private String AiZ;
  private LinkedList<ListView.FixedViewInfo> Aik;
  private boolean AjA;
  private boolean AjB;
  private boolean AjC;
  private boolean AjD;
  private Runnable AjE;
  private Runnable AjF;
  private boolean AjG;
  private boolean AjH;
  private int AjI;
  private float Aja;
  private com.tencent.mm.plugin.appbrand.widget.header.a.a Ajb;
  private boolean Ajc;
  private boolean Ajd;
  private boolean Aje;
  private float Ajf;
  private float Ajg;
  private int Ajh;
  private boolean Aji;
  private com.tencent.mm.plugin.appbrand.widget.header.a Ajj;
  private Runnable Ajk;
  private boolean Ajl;
  private float Ajm;
  private com.tencent.mm.plugin.appbrand.widget.header.b Ajn;
  private com.tencent.mm.plugin.appbrand.widget.header.b Ajo;
  private com.tencent.mm.plugin.appbrand.widget.header.b Ajp;
  private c<jv> Ajq;
  private int Ajr;
  boolean Ajs;
  private final c<ip> Ajt;
  private ConversationWithAppBrandListView.a Aju;
  private int Ajv;
  private float Ajw;
  private float Ajx;
  private float Ajy;
  private boolean Ajz;
  private int aiw;
  private int aix;
  private int aiy;
  private boolean bRB;
  private boolean cvo;
  private boolean hasInit;
  private Vibrator jbU;
  private boolean jcK;
  private GyroView jcR;
  private MMFragmentActivity jdB;
  private float jeY;
  private com.tencent.mm.plugin.appbrand.widget.recentview.b jhK;
  private float jkn;
  private ValueAnimator kO;
  private float lnM;
  private float lnN;
  private int mTouchSlop;
  private AbsListView.OnScrollListener ojv;
  private View xy;
  
  public ConversationWithAppBrandListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(34294);
    this.Aik = new LinkedList();
    this.AiW = false;
    this.Ajc = false;
    this.Ajd = false;
    this.Aje = false;
    this.Ajf = 0.0F;
    this.Ajg = 0.0F;
    this.Ajh = 0;
    this.Aji = false;
    this.Ajk = null;
    this.Ajl = true;
    this.Ajm = 0.0F;
    this.Ajn = null;
    this.Ajo = null;
    this.Ajp = null;
    this.Ajq = new ConversationWithAppBrandListView.1(this);
    this.bRB = true;
    this.Ajr = 0;
    this.Ajs = false;
    this.aiw = -1;
    this.Ajt = new ConversationWithAppBrandListView.21(this);
    this.Aju = new ConversationWithAppBrandListView.a(this);
    this.Ajv = 0;
    this.Ajx = 0.0F;
    this.Ajy = 0.0F;
    this.AjA = false;
    this.AjC = false;
    this.AjD = false;
    this.AjF = new ConversationWithAppBrandListView.17(this);
    this.jcK = false;
    this.AjG = false;
    this.AjH = false;
    this.hasInit = false;
    this.Ajn = new com.tencent.mm.plugin.appbrand.widget.header.b(getContext().getResources().getColor(2131689690), getContext().getResources().getColor(2131689688));
    this.Ajq.alive();
    AppMethodBeat.o(34294);
  }
  
  private void Qy(int paramInt)
  {
    AppMethodBeat.i(34325);
    ab.i("MicroMsg.ConversationWithAppBrandListView", "[closeAppBrandRecentView] isOpenAppBrandRecentView:%s type:%s", new Object[] { Boolean.valueOf(this.AjB), Integer.valueOf(paramInt) });
    if ((this.AjB) && (getChildAt(0) != null) && (this.jhK != null) && (this.Ajb != null))
    {
      this.jhK.M(this.Ajb.getRecentAppBrandCount(), this.Ajb.getStarAppBrandCount(), paramInt);
      this.Ajb.ql(paramInt);
    }
    View localView;
    if (getFirstVisiblePosition() == 0)
    {
      localView = getChildAt(0);
      if (localView != null) {
        break label167;
      }
    }
    label167:
    for (paramInt = 0;; paramInt = localView.getBottom())
    {
      if (paramInt != 0) {
        smoothScrollToPositionFromTop(getFirstHeaderVisible(), 0, 150);
      }
      dMH();
      rm(true);
      setOpenAppBrandRecentView(false);
      al.p(new ConversationWithAppBrandListView.9(this), 500L);
      AppMethodBeat.o(34325);
      return;
    }
  }
  
  private float Qz(int paramInt)
  {
    AppMethodBeat.i(34336);
    ab.d("MicroMsg.ConversationWithAppBrandListView", "[isFull] totalItemCount:" + paramInt + " getFirstVisiblePosition:" + getFirstVisiblePosition() + " getLastVisiblePosition:" + getLastVisiblePosition() + " getHeaderViewsCount:" + getHeaderViewsCount() + " getFooterViewsCount:" + getFooterViewsCount());
    int i = (int)getResources().getDimension(2131427807);
    paramInt = paramInt - getHeaderViewsCount() - getFooterViewsCount();
    float f = getMeasuredHeight() - i * paramInt;
    ab.i("MicroMsg.ConversationWithAppBrandListView", "[isFull] height:%s rawCount:%s extraHeight:%s", new Object[] { Integer.valueOf(getHeight()), Integer.valueOf(paramInt), Float.valueOf(f) });
    AppMethodBeat.o(34336);
    return f;
  }
  
  private boolean U(MotionEvent paramMotionEvent)
  {
    int j = 0;
    AppMethodBeat.i(34322);
    if (!dMJ())
    {
      AppMethodBeat.o(34322);
      return false;
    }
    if (paramMotionEvent.getAction() == 0)
    {
      this.Ajy = paramMotionEvent.getY();
      if (this.kO != null) {
        this.kO.cancel();
      }
    }
    float f3;
    try
    {
      if (((paramMotionEvent.getAction() != 2) || (Math.abs(paramMotionEvent.getY() - this.lnN) <= 2.0F) || (getFirstVisiblePosition() != 0) || (this.AiT.getTop() != 0)) && (getChildTranslationY() == 0.0F)) {
        break label581;
      }
      rm(true);
      if ((getHeight() - getTabViewHeight() - this.Ajv) / 2 <= this.Ajx) {
        rn(false);
      }
      for (;;)
      {
        float f1 = paramMotionEvent.getY();
        float f2 = this.Ajy;
        f3 = getHeight() - getTabViewHeight() - this.Ajv;
        this.Ajx = ((f1 - f2) * 0.4F + this.Ajx);
        if (this.Ajx >= 0.0F) {
          break label487;
        }
        this.Ajx = 0.0F;
        dMH();
        invalidate();
        return false;
        if (paramMotionEvent.getActionMasked() == 5)
        {
          this.Ajy = paramMotionEvent.getY();
          break;
        }
        if (((paramMotionEvent.getAction() != 1) && (paramMotionEvent.getAction() != 3)) || (this.AiT.getTop() != 0) || (getChildTranslationY() == 0.0F)) {
          break;
        }
        rn(true);
        this.AjA = false;
        ab.d("MicroMsg.ConversationWithAppBrandListView", "[animationChild] offset:%s delay:%s duration%s", new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(180) });
        if (!dMJ()) {
          break;
        }
        if (this.kO != null) {
          this.kO.cancel();
        }
        this.kO = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("deltaY", new float[] { getChildTranslationY() + 0.0F, 0.0F }), PropertyValuesHolder.ofFloat("headerDeltaY", new float[] { getHeaderY() + 0.0F, 0.0F }) });
        this.kO.setDuration(180L);
        this.kO.addUpdateListener(new ConversationWithAppBrandListView.10(this));
        this.kO.addListener(new ConversationWithAppBrandListView.12(this));
        this.kO.setStartDelay(0L);
        this.kO.start();
        break;
        rn(true);
      }
      i = j;
    }
    finally
    {
      this.Ajy = paramMotionEvent.getY();
      AppMethodBeat.o(34322);
    }
    label487:
    int i;
    if (f3 < this.Ajx)
    {
      this.Ajx = f3;
      i = j;
    }
    for (;;)
    {
      if (i < getChildCount())
      {
        if (i == 0) {
          getChildAt(i).setTranslationY(this.Ajx * 0.5F);
        } else {
          getChildAt(i).setTranslationY(this.Ajx);
        }
      }
      else
      {
        invalidate();
        this.Ajy = paramMotionEvent.getY();
        AppMethodBeat.o(34322);
        return true;
        label581:
        this.Ajy = paramMotionEvent.getY();
        AppMethodBeat.o(34322);
        return false;
      }
      i += 1;
    }
  }
  
  private void dMB()
  {
    boolean bool = false;
    AppMethodBeat.i(34308);
    int j = getFirstHeaderVisible();
    localLayoutParams = (LinearLayout.LayoutParams)this.AiN.getLayoutParams();
    int k = localLayoutParams.height;
    for (;;)
    {
      try
      {
        if (getAdapter() != null) {
          continue;
        }
        i = 0;
        f1 = Qz(i);
      }
      catch (Exception localException)
      {
        int i;
        float f2;
        float f1 = 0.0F;
        continue;
        localLayoutParams.height = ((int)f2);
        if (!this.bRB) {
          continue;
        }
        post(new ConversationWithAppBrandListView.3(this));
        continue;
      }
      if (f1 < 0.0F) {
        bool = true;
      }
      f2 = f1;
      if (f1 < getTabViewHeight()) {
        f2 = getTabViewHeight();
      }
      ab.i("MicroMsg.ConversationWithAppBrandListView", "[checkEmptyFooter] isRealFull:" + bool + " extraHeight:" + f2);
      if (!bool) {
        continue;
      }
      localLayoutParams.height = getTabViewHeight();
      if (k != localLayoutParams.height)
      {
        this.AiN.setLayoutParams(localLayoutParams);
        if (!this.bRB) {
          super.setSelection(j);
        }
      }
      AppMethodBeat.o(34308);
      return;
      i = getAdapter().getCount();
    }
  }
  
  private boolean dMC()
  {
    AppMethodBeat.i(34312);
    if ((this.AiU != null) && (this.Ajb != null))
    {
      int i = this.AiT.getMeasuredHeight();
      if ((i != 0) && (i != this.Ajv))
      {
        this.Ajv = i;
        AppMethodBeat.o(34312);
        return true;
      }
    }
    AppMethodBeat.o(34312);
    return false;
  }
  
  private void dMD()
  {
    AppMethodBeat.i(34313);
    if (dMC())
    {
      if (this.jcR != null) {
        this.jcR.setVisibility(0);
      }
      this.Ajf = (-(this.jkn - getResources().getDimension(2131427776)));
      this.Ajg = (-(this.jkn - (this.Ajv / 2 - getResources().getDimension(2131427759))));
      if (!this.Aje)
      {
        if (this.AiU != null) {
          this.AiU.setTranslationY(this.Ajf);
        }
        if (this.xy != null) {
          this.xy.setTranslationY(0.0F);
        }
        ab.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo initAppBrandHeaderHeight AppBrandHeader appBrandHeight: %d, setTranslationY: %s", new Object[] { Integer.valueOf(this.Ajv), Float.valueOf(this.Ajf) });
        AppMethodBeat.o(34313);
        return;
      }
      if (this.AiU != null) {
        this.AiU.setTranslationY(0.0F);
      }
      if (this.xy != null) {
        this.xy.setTranslationY(this.Ajg);
      }
      ab.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo initAppBrandHeaderHeight emptyView appBrandHeight: %d, setTranslationY: %s", new Object[] { Integer.valueOf(this.Ajv), Float.valueOf(this.Ajg) });
    }
    AppMethodBeat.o(34313);
  }
  
  private void dME()
  {
    AppMethodBeat.i(34314);
    if (this.Aji)
    {
      AppMethodBeat.o(34314);
      return;
    }
    if (g.E(d.class) != null)
    {
      this.AiT = ((d)g.E(d.class)).dj(this.jdB);
      this.Aji = true;
      this.AiT.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
      this.AiU = this.AiT.findViewById(2131821190);
      this.AiU.setVisibility(8);
      this.jcR = this.AiT.getGyroView();
      this.Ajb = this.AiT.getHeaderView();
      this.Ajb.setCollectionRefreshListener(new ConversationWithAppBrandListView.4(this));
      this.Ajb.setUsageRefreshListener(new ConversationWithAppBrandListView.5(this));
      this.Ajb.setIOnLaunchUIListener(new a.b()
      {
        public final void aQn()
        {
          AppMethodBeat.i(34271);
          ab.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo onLaunchCollectionUI");
          ConversationWithAppBrandListView.this.L(300L, 10);
          AppMethodBeat.o(34271);
        }
        
        public final void aQo()
        {
          AppMethodBeat.i(34272);
          ab.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo onLaunchUsageUI");
          ConversationWithAppBrandListView.this.L(300L, 9);
          AppMethodBeat.o(34272);
        }
      });
      this.Ajb.setOnEmptyViewListener(new ConversationWithAppBrandListView.7(this));
      this.Ajb.setReporter(this.jhK);
      this.xy = this.AiT.getEmptyView();
      this.Aik.remove(this.AiT);
      Object localObject = new ListView.FixedViewInfo(this);
      ((ListView.FixedViewInfo)localObject).view = this.AiT;
      ((ListView.FixedViewInfo)localObject).data = null;
      ((ListView.FixedViewInfo)localObject).isSelectable = true;
      this.Aik.addFirst(localObject);
      localObject = this.Aik.iterator();
      while (((Iterator)localObject).hasNext())
      {
        ListView.FixedViewInfo localFixedViewInfo = (ListView.FixedViewInfo)((Iterator)localObject).next();
        super.addHeaderView(localFixedViewInfo.view, localFixedViewInfo.data, localFixedViewInfo.isSelectable);
      }
    }
    ab.e("MicroMsg.ConversationWithAppBrandListView", "alvinluo addAppBrandHalfView error");
    AppMethodBeat.o(34314);
    return;
    this.Ajb.refresh();
    AppMethodBeat.o(34314);
  }
  
  private void dMF()
  {
    AppMethodBeat.i(34323);
    if (!this.AjB)
    {
      ay.he(getContext());
      if ((this.jhK != null) && (this.Ajb != null)) {
        this.jhK.dB(this.Ajb.getRecentAppBrandCount(), this.Ajb.getStarAppBrandCount());
      }
      if (this.Ajb != null) {
        this.Ajb.aQj();
      }
    }
    if ((this.Ajs) && (this.AiV != null))
    {
      this.AiV.getAdapter().ajb.notifyChanged();
      this.Ajs = true;
    }
    super.smoothScrollToPositionFromTop(0, 0, 250);
    rm(true);
    setOpenAppBrandRecentView(true);
    dMG();
    AppMethodBeat.o(34323);
  }
  
  private void dMG()
  {
    AppMethodBeat.i(34324);
    if (this.Ajb != null) {
      this.Ajb.aQk();
    }
    AppMethodBeat.o(34324);
  }
  
  private void dMH()
  {
    AppMethodBeat.i(34328);
    int i = 0;
    while (i < getChildCount())
    {
      getChildAt(i).setTranslationY(0.0F);
      i += 1;
    }
    this.Ajx = 0.0F;
    invalidate();
    AppMethodBeat.o(34328);
  }
  
  private void dMI()
  {
    AppMethodBeat.i(34333);
    ab.d("MicroMsg.ConversationWithAppBrandListView", "alvinluo resetAppBrandHeaderBg");
    if (this.AiX != null)
    {
      int i = this.jdB.getResources().getColor(2131689696);
      this.AiX.setColor(i);
    }
    AppMethodBeat.o(34333);
  }
  
  private boolean dMJ()
  {
    AppMethodBeat.i(34339);
    if (this.AiU != null)
    {
      if ((rp(true)) && (this.AiU.getVisibility() == 0))
      {
        AppMethodBeat.o(34339);
        return true;
      }
      AppMethodBeat.o(34339);
      return false;
    }
    AppMethodBeat.o(34339);
    return false;
  }
  
  private float getChildTranslationY()
  {
    AppMethodBeat.i(34326);
    View localView = getChildAt(1);
    if (localView == null)
    {
      AppMethodBeat.o(34326);
      return 0.0F;
    }
    float f = localView.getTranslationY();
    AppMethodBeat.o(34326);
    return f;
  }
  
  private View getEmptyFooter()
  {
    AppMethodBeat.i(34305);
    LinearLayout localLinearLayout = new LinearLayout(getContext());
    this.AiN = new View(getContext());
    this.AiN.setLayoutParams(new LinearLayout.LayoutParams(-1, 0));
    localLinearLayout.addView(this.AiN);
    localLinearLayout.setBackgroundColor(getContext().getResources().getColor(2131690709));
    AppMethodBeat.o(34305);
    return localLinearLayout;
  }
  
  private float getHeaderY()
  {
    AppMethodBeat.i(34327);
    View localView = getChildAt(0);
    if (localView == null)
    {
      AppMethodBeat.o(34327);
      return 0.0F;
    }
    float f = localView.getTranslationY();
    AppMethodBeat.o(34327);
    return f;
  }
  
  private float getRatio()
  {
    float f1 = 0.0F;
    AppMethodBeat.i(34334);
    float f2;
    if ((this.AiT != null) && (this.Ajv != 0))
    {
      f2 = 1.0F - Math.abs(this.AiT.getTop() * 1.0F) / this.Ajv;
      if (f2 >= 0.0F) {
        break label121;
      }
    }
    for (;;)
    {
      ab.d("MicroMsg.ConversationWithAppBrandListView", "alvinluo header top: %d, header bottom: %d, ratio: %f, appBrandHeight: %d", new Object[] { Integer.valueOf(this.AiT.getTop()), Integer.valueOf(this.AiT.getBottom()), Float.valueOf(f1), Integer.valueOf(this.Ajv) });
      AppMethodBeat.o(34334);
      return f1;
      AppMethodBeat.o(34334);
      return 0.0F;
      label121:
      f1 = f2;
    }
  }
  
  private int getTabViewHeight()
  {
    AppMethodBeat.i(34307);
    if (this.Ajh == 0)
    {
      View localView = getRootView().findViewById(2131820634);
      if (localView != null)
      {
        ab.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo initTabViewHeight tabView.getHeight: %d", new Object[] { Integer.valueOf(localView.getHeight()) });
        this.Ajh = localView.getHeight();
      }
    }
    int i = this.Ajh;
    AppMethodBeat.o(34307);
    return i;
  }
  
  private void rl(boolean paramBoolean)
  {
    AppMethodBeat.i(34306);
    if ((this.AiN == null) || (!rp(true)))
    {
      AppMethodBeat.o(34306);
      return;
    }
    if (paramBoolean)
    {
      postDelayed(new ConversationWithAppBrandListView.2(this), 0L);
      AppMethodBeat.o(34306);
      return;
    }
    dMB();
    AppMethodBeat.o(34306);
  }
  
  private void rm(boolean paramBoolean)
  {
    AppMethodBeat.i(34309);
    if (paramBoolean)
    {
      al.ae(this.Aju);
      AppMethodBeat.o(34309);
      return;
    }
    al.ae(this.Aju);
    al.p(this.Aju, 1000L);
    AppMethodBeat.o(34309);
  }
  
  private void rn(boolean paramBoolean)
  {
    AppMethodBeat.i(34331);
    if ((paramBoolean) && (this.AjE != null))
    {
      al.ae(this.AjE);
      this.AjE = null;
      if (this.AjD)
      {
        ro(false);
        AppMethodBeat.o(34331);
      }
    }
    else if ((!paramBoolean) && (this.AjE == null))
    {
      ConversationWithAppBrandListView.13 local13 = new ConversationWithAppBrandListView.13(this);
      this.AjE = local13;
      al.p(local13, 3000L);
    }
    AppMethodBeat.o(34331);
  }
  
  private void ro(boolean paramBoolean)
  {
    AppMethodBeat.i(34332);
    ab.i("MicroMsg.ConversationWithAppBrandListView", "[showTipWithAnim] isShow:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.AjD = true;
      localValueAnimator = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofInt("alpha", new int[] { 0, 77 }) });
      localValueAnimator.setDuration(200L);
      localValueAnimator.addUpdateListener(new ConversationWithAppBrandListView.14(this));
      localValueAnimator.start();
      if (this.jhK != null) {
        this.jhK.aSh();
      }
      AppMethodBeat.o(34332);
      return;
    }
    ValueAnimator localValueAnimator = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofInt("alpha", new int[] { 77, 0 }) });
    localValueAnimator.setDuration(200L);
    localValueAnimator.addUpdateListener(new ConversationWithAppBrandListView.15(this));
    localValueAnimator.addListener(new ConversationWithAppBrandListView.16(this));
    localValueAnimator.start();
    AppMethodBeat.o(34332);
  }
  
  private boolean rp(boolean paramBoolean)
  {
    AppMethodBeat.i(34338);
    if (((!this.hasInit) || (!paramBoolean)) && (g.E(d.class) != null))
    {
      g.E(d.class);
      this.AiW = true;
      ab.i("MicroMsg.ConversationWithAppBrandListView", "[isAppBrandHeaderEnable] :%s", new Object[] { Boolean.valueOf(this.AiW) });
      this.hasInit = true;
    }
    paramBoolean = this.AiW;
    AppMethodBeat.o(34338);
    return paramBoolean;
  }
  
  private void setEmptyViewVisible(boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(34310);
    ab.i("MicroMsg.ConversationWithAppBrandListView", "[setEmptyViewVisible] isShow:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    View localView;
    if (this.xy != null)
    {
      localView = this.xy;
      if (paramBoolean)
      {
        i = 0;
        localView.setVisibility(i);
      }
    }
    else if (this.AiU != null)
    {
      localView = this.AiU.findViewById(2131821539);
      if (localView != null) {
        if (paramBoolean) {
          break label101;
        }
      }
    }
    label101:
    for (int i = j;; i = 4)
    {
      localView.setVisibility(i);
      AppMethodBeat.o(34310);
      return;
      i = 8;
      break;
    }
  }
  
  private void setOpenAppBrandRecentView(boolean paramBoolean)
  {
    this.AjB = paramBoolean;
  }
  
  public final void L(long paramLong, int paramInt)
  {
    AppMethodBeat.i(34303);
    ab.i("MicroMsg.ConversationWithAppBrandListView", "[hideAppBrandRecentView] delay:%s, type: %d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt) });
    if (!rp(true))
    {
      if (this.AiU != null) {
        this.AiU.setVisibility(8);
      }
      AppMethodBeat.o(34303);
      return;
    }
    if (getFirstVisiblePosition() != 0)
    {
      AppMethodBeat.o(34303);
      return;
    }
    if ((this.jhK != null) && (this.Ajb != null))
    {
      this.jhK.M(this.Ajb.getRecentAppBrandCount(), this.Ajb.getStarAppBrandCount(), paramInt);
      this.Ajb.ql(paramInt);
    }
    if (paramLong > 0L)
    {
      if (this.Ajk != null) {
        removeCallbacks(this.Ajk);
      }
      this.Ajk = new ConversationWithAppBrandListView.24(this);
      postDelayed(this.Ajk, paramLong);
    }
    for (;;)
    {
      dMH();
      AppMethodBeat.o(34303);
      return;
      if (this.Ajb != null) {
        this.Ajb.aQi();
      }
      if (this.AiV != null) {
        this.AiV.smoothScrollToPosition(0);
      }
      setSelection(0);
      ab.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo resetAppBrandHeaderBg");
      dMI();
    }
  }
  
  public void addHeaderView(View paramView, Object paramObject, boolean paramBoolean)
  {
    AppMethodBeat.i(34300);
    ListView.FixedViewInfo localFixedViewInfo = new ListView.FixedViewInfo(this);
    localFixedViewInfo.view = paramView;
    localFixedViewInfo.data = paramObject;
    localFixedViewInfo.isSelectable = paramBoolean;
    this.Aik.add(localFixedViewInfo);
    if (getAdapter() != null) {
      super.addHeaderView(localFixedViewInfo.view, localFixedViewInfo.data, localFixedViewInfo.isSelectable);
    }
    ab.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo addHeaderView %d", new Object[] { Integer.valueOf(this.Aik.size()) });
    AppMethodBeat.o(34300);
  }
  
  public boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    AppMethodBeat.i(34319);
    if ((rp(true)) && (getFirstVisiblePosition() == 0) && (paramInt2 < 0))
    {
      paramArrayOfInt1[1] = ((int)(paramInt2 / 3.0F));
      super.dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2);
      AppMethodBeat.o(34319);
      return true;
    }
    boolean bool = super.dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2);
    AppMethodBeat.o(34319);
    return bool;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(34320);
    try
    {
      if (paramMotionEvent.getAction() == 0)
      {
        float f = paramMotionEvent.getX();
        this.lnM = f;
        this.Ajw = f;
        f = paramMotionEvent.getY();
        this.lnN = f;
        this.jeY = f;
      }
      boolean bool = super.dispatchTouchEvent(paramMotionEvent);
      return bool;
    }
    finally
    {
      this.lnM = paramMotionEvent.getX();
      this.lnN = paramMotionEvent.getY();
      AppMethodBeat.o(34320);
    }
  }
  
  public int getFirstHeaderVisible()
  {
    AppMethodBeat.i(34337);
    Iterator localIterator = this.Aik.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      ListView.FixedViewInfo localFixedViewInfo = (ListView.FixedViewInfo)localIterator.next();
      if (localFixedViewInfo.view == this.AiT)
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
              ab.i("MicroMsg.ConversationWithAppBrandListView", "[getFirstHeaderVisible] index:%s", new Object[] { Integer.valueOf(i) });
              AppMethodBeat.o(34337);
              return i;
            }
            j += 1;
          }
        }
        i += 1;
      }
    }
    ab.i("MicroMsg.ConversationWithAppBrandListView", "[getFirstHeaderVisible] index:%s, size: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(this.Aik.size()) });
    AppMethodBeat.o(34337);
    return i;
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(34298);
    super.onConfigurationChanged(paramConfiguration);
    ab.i("MicroMsg.ConversationWithAppBrandListView", "[onConfigurationChanged] orientation:%s", new Object[] { Integer.valueOf(paramConfiguration.orientation) });
    this.Ajs = true;
    rl(true);
    if (this.Ajb != null) {
      this.Ajb.b(paramConfiguration);
    }
    this.Ajl = false;
    AppMethodBeat.o(34298);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(34329);
    super.onDraw(paramCanvas);
    if ((getFirstVisiblePosition() == 0) && (this.AiT != null))
    {
      paramCanvas.drawRect(0.0F, 0.0F, getWidth(), this.AiT.getBottom() + this.Ajx, this.AiX);
      if (getChildAt(1) != null) {
        if ((getHeight() == 0) || (!this.AjD)) {
          break label150;
        }
      }
    }
    label150:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        float f1 = (getWidth() - this.Aja) / 2.0F;
        float f2 = this.AiT.getBottom();
        float f3 = this.Ajx;
        float f4 = getResources().getDimension(2131427781);
        paramCanvas.drawText(this.AiZ, f1, f2 + f3 - f4, this.AiY);
      }
      AppMethodBeat.o(34329);
      return;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(34299);
    boolean bool;
    if (getFirstVisiblePosition() != 0)
    {
      bool = super.onInterceptTouchEvent(paramMotionEvent);
      AppMethodBeat.o(34299);
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
      AppMethodBeat.o(34299);
      return bool;
    case 0: 
      this.aiw = paramMotionEvent.getPointerId(0);
      this.aix = ((int)(paramMotionEvent.getX() + 0.5F));
      this.aiy = ((int)(paramMotionEvent.getY() + 0.5F));
      bool = super.onInterceptTouchEvent(paramMotionEvent);
      AppMethodBeat.o(34299);
      return bool;
    case 5: 
      this.aiw = paramMotionEvent.getPointerId(j);
      this.aix = ((int)(paramMotionEvent.getX(j) + 0.5F));
      this.aiy = ((int)(paramMotionEvent.getY(j) + 0.5F));
      bool = super.onInterceptTouchEvent(paramMotionEvent);
      AppMethodBeat.o(34299);
      return bool;
    }
    j = paramMotionEvent.findPointerIndex(this.aiw);
    if (j < 0)
    {
      AppMethodBeat.o(34299);
      return false;
    }
    i = (int)(paramMotionEvent.getX(j) + 0.5F);
    int k = (int)(paramMotionEvent.getY(j) + 0.5F);
    j = this.aix;
    k -= this.aiy;
    if ((Math.abs(k) > this.mTouchSlop) && (Math.abs(k) >= Math.abs(i - j))) {}
    for (i = 1;; i = 0)
    {
      if ((i != 0) && (super.onInterceptTouchEvent(paramMotionEvent)))
      {
        AppMethodBeat.o(34299);
        return true;
      }
      AppMethodBeat.o(34299);
      return false;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(34297);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramBoolean) && (rp(true)))
    {
      if (this.bRB)
      {
        rl(true);
        post(new ConversationWithAppBrandListView.20(this));
        this.Ajr = paramInt4;
        this.bRB = false;
        AppMethodBeat.o(34297);
        return;
      }
      if ((!this.cvo) && (this.Ajr != paramInt4))
      {
        ab.i("MicroMsg.ConversationWithAppBrandListView", "[onLayout] mLastBottom:" + this.Ajr + " b:" + paramInt4);
        rl(true);
        this.Ajr = paramInt4;
      }
    }
    AppMethodBeat.o(34297);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(34311);
    super.onMeasure(paramInt1, paramInt2);
    dMD();
    AppMethodBeat.o(34311);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(34335);
    if (this.ojv != null) {
      this.ojv.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    }
    if (!rp(true))
    {
      AppMethodBeat.o(34335);
      return;
    }
    dMD();
    if (this.Ajv == 0)
    {
      AppMethodBeat.o(34335);
      return;
    }
    ab.v("MicroMsg.ConversationWithAppBrandListView", "alvinluo onScroll firstVisibleItem: %d, visibleItemCount: %d, totalItemCount: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    float f1;
    View localView;
    label277:
    GyroView localGyroView;
    if (paramInt1 == 0)
    {
      float f2 = getRatio();
      if ((this.Ajm == 0.0F) || (this.Ajm == 1.0F) || (Math.abs(f2 - this.Ajm) >= 0.01D))
      {
        this.Ajm = f2;
        f1 = f2;
        if (this.AiT != null)
        {
          if ((this.AiT.getTop() != 0) || (this.Ajl)) {
            break label277;
          }
          f1 = 0.0F;
        }
      }
      for (;;)
      {
        if (this.Ajn != null)
        {
          paramInt2 = this.Ajn.aE(f1);
          if (this.AiX != null) {
            this.AiX.setColor(paramInt2);
          }
          if (this.AiU != null) {
            this.AiU.setBackgroundColor(paramInt2);
          }
        }
        rm(false);
        paramAbsListView = paramAbsListView.getChildAt(0);
        if ((paramAbsListView == null) || (!(paramAbsListView instanceof HeaderContainer))) {
          break label528;
        }
        localView = paramAbsListView.findViewById(2131821190);
        if ((localView != null) && (localView.getVisibility() != 8)) {
          break;
        }
        AppMethodBeat.o(34335);
        return;
        f1 = f2;
        if (this.AiT.getTop() != 0)
        {
          this.Ajl = true;
          f1 = f2;
        }
      }
      localGyroView = ((HeaderContainer)paramAbsListView).getGyroView();
      ab.v("MicroMsg.ConversationWithAppBrandListView", "alvinluo appBrandHeaderTransH: %s, emptyTransH: %s, headerParent.bottom: %s, translationY: %f, mAppBrandHeight: %d", new Object[] { Float.valueOf(this.Ajf), Float.valueOf(this.Ajg), Integer.valueOf(paramAbsListView.getBottom()), Float.valueOf(localView.getTranslationY()), Integer.valueOf(this.Ajv) });
      if (paramAbsListView.getBottom() <= 3)
      {
        if (!this.Aje)
        {
          localView.setTranslationY(this.Ajf);
          if (localGyroView.getVisibility() == 0)
          {
            localGyroView.setVerticalScroll(0.0F);
            localGyroView.setVisibility(8);
          }
          this.AjH = false;
        }
      }
      else
      {
        if ((paramAbsListView.getBottom() <= 3) || (paramAbsListView.getBottom() > this.jkn) || ((localView.getTranslationY() == 0.0F) && ((this.xy == null) || (this.xy.getTranslationY() == 0.0F)))) {
          break label634;
        }
        if (localGyroView.getVisibility() == 8) {
          localGyroView.setVisibility(0);
        }
        localGyroView.setAlpha(1.0F);
        localGyroView.setTranslationY(-paramAbsListView.getBottom() / 2 + localGyroView.getHeight() / 2);
        localGyroView.setVerticalScroll(paramAbsListView.getBottom());
      }
    }
    label528:
    label1006:
    for (;;)
    {
      this.AjI = paramInt1;
      if ((this.AjG) && (this.jcK) && (paramInt1 == 0))
      {
        ab.e("MicroMsg.ConversationWithAppBrandListView", "[Stop fling!]");
        smoothScrollBy(0, 0);
        post(new ConversationWithAppBrandListView.18(this));
        this.AjG = false;
      }
      al.ae(this.AjF);
      al.p(this.AjF, 50L);
      AppMethodBeat.o(34335);
      return;
      if (this.xy != null) {
        this.xy.setTranslationY(this.Ajg);
      }
      localView.setTranslationY(0.0F);
      break;
      label634:
      if ((paramAbsListView.getBottom() > this.jkn) && ((localView.getTranslationY() != 0.0F) || ((this.xy != null) && (this.xy.getTranslationY() != 0.0F))))
      {
        f1 = (float)(1.0D * (paramAbsListView.getBottom() - this.jkn) / (this.Ajv - this.jkn));
        ab.v("MicroMsg.ConversationWithAppBrandListView", "alvinluo checkUpAppBrandHeader appbrandHeader translationY: %f, percent: %f, setTranslationY: %f, isEmpty: %b", new Object[] { Float.valueOf(localView.getTranslationY()), Float.valueOf(f1), Float.valueOf(this.Ajf * (1.0F - f1)), Boolean.valueOf(this.Aje) });
        if (!this.Aje) {
          localView.setTranslationY(this.Ajf * (1.0F - f1));
        }
        for (;;)
        {
          localGyroView.setTranslationY(-this.jkn / 2.0F + localGyroView.getHeight() / 2 + (this.jkn / 2.0F + localGyroView.getHeight()) * f1);
          localGyroView.setAlpha(1.0F - 2.0F * f1);
          if ((!this.AjH) && (1.0F != f1))
          {
            this.jbU.vibrate(10L);
            this.AjH = true;
          }
          rm(true);
          break;
          if (this.xy != null)
          {
            ab.v("MicroMsg.ConversationWithAppBrandListView", "alvinluo emptyView translationY: %f, set: %f", new Object[] { Float.valueOf(this.xy.getTranslationY()), Float.valueOf(-this.Ajg * (1.0F - f1)) });
            this.xy.setTranslationY(this.Ajg * (1.0F - f1));
          }
          localView.setTranslationY(0.0F);
        }
        if (this.AiT != null)
        {
          paramAbsListView = this.AiT.findViewById(2131821190);
          if (this.Aje) {
            break label1006;
          }
          if (paramAbsListView != null) {
            paramAbsListView.setTranslationY(this.Ajf);
          }
        }
        for (;;)
        {
          if ((this.AjI != 0) || (paramInt1 == 0)) {
            break label1034;
          }
          Qy(4);
          rn(true);
          rm(true);
          break;
          if (this.xy != null) {
            this.xy.setTranslationY(this.Ajg);
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
    AppMethodBeat.i(34330);
    if (this.ojv != null) {
      this.ojv.onScrollStateChanged(paramAbsListView, paramInt);
    }
    if ((getFirstVisiblePosition() != 0) && (paramInt == 2) && (!this.AjC)) {
      this.jcK = true;
    }
    AppMethodBeat.o(34330);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(34321);
    boolean bool;
    if (!rp(true))
    {
      bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(34321);
      return bool;
    }
    if (paramMotionEvent.getAction() == 0) {
      if (getFirstVisiblePosition() != 0) {
        this.AjG = true;
      }
    }
    for (;;)
    {
      if ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
      {
        rm(true);
        this.Ajz = false;
        if (getChildTranslationY() > 0.0F) {
          dMF();
        }
      }
      if (U(paramMotionEvent)) {
        break;
      }
      if ((this.Ajz) && (paramMotionEvent.getAction() == 2))
      {
        paramMotionEvent.setAction(0);
        super.onTouchEvent(paramMotionEvent);
        paramMotionEvent.setAction(2);
        this.Ajz = false;
      }
      bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(34321);
      return bool;
      if (((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3)) && (getFirstVisiblePosition() == 0))
      {
        View localView = getChildAt(0);
        if (localView == null)
        {
          AppMethodBeat.o(34321);
          return true;
        }
        if ((Math.abs(paramMotionEvent.getX() - this.lnM) < 3.0F) && (Math.abs(paramMotionEvent.getY() - this.lnN) < 3.0F)) {
          super.onTouchEvent(paramMotionEvent);
        }
        if (getChildTranslationY() < 60.0F * getResources().getDisplayMetrics().density)
        {
          float f1 = Math.abs(paramMotionEvent.getX() - this.Ajw);
          float f2 = Math.abs(paramMotionEvent.getY() - this.jeY);
          if (((paramMotionEvent.getY() - this.jeY < -5.0F) && (f1 - f2 < 0.0F) && (getFirstVisiblePosition() == 0)) || ((localView.getBottom() > 0) && (localView.getBottom() < this.jkn))) {
            Qy(4);
          } else if ((localView.getBottom() >= this.jkn) && (paramMotionEvent.getY() - this.jeY > 5.0F)) {
            dMF();
          }
        }
      }
    }
    if (paramMotionEvent.getAction() == 0) {
      super.onTouchEvent(paramMotionEvent);
    }
    for (;;)
    {
      AppMethodBeat.o(34321);
      return true;
      if ((paramMotionEvent.getAction() == 2) && (!this.Ajz) && (Math.abs(paramMotionEvent.getY() - this.lnN) > 2.0F))
      {
        paramMotionEvent.setAction(3);
        super.onTouchEvent(paramMotionEvent);
        this.Ajz = true;
      }
      else if (!this.Ajz)
      {
        super.onTouchEvent(paramMotionEvent);
      }
    }
  }
  
  public final void qj(int paramInt)
  {
    AppMethodBeat.i(34304);
    ab.i("MicroMsg.ConversationWithAppBrandListView", "[next] size:%s isAppBrandHeaderEnable:%s", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(this.AiW) });
    if (!rp(true))
    {
      ab.w("MicroMsg.ConversationWithAppBrandListView", "[next] is disable!");
      if (this.AiU != null) {
        this.AiU.setVisibility(8);
      }
      AppMethodBeat.o(34304);
      return;
    }
    if ((paramInt == 1) && (this.AiU != null)) {
      setEmptyViewVisible(true);
    }
    for (;;)
    {
      if ((this.AiU != null) && (this.AiU.getVisibility() == 8))
      {
        this.AiU.setVisibility(0);
        setSelection(getFirstVisiblePosition());
      }
      AppMethodBeat.o(34304);
      return;
      if ((paramInt > 1) && (this.AiU != null)) {
        setEmptyViewVisible(false);
      }
    }
  }
  
  public void setActionBarUpdateCallback(com.tencent.mm.plugin.appbrand.widget.header.a parama)
  {
    this.Ajj = parama;
  }
  
  public void setActivity(MMFragmentActivity paramMMFragmentActivity)
  {
    AppMethodBeat.i(34296);
    this.jdB = paramMMFragmentActivity;
    dME();
    AppMethodBeat.o(34296);
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    AppMethodBeat.i(34295);
    ab.i("MicroMsg.ConversationWithAppBrandListView", "[init] ");
    this.Ajt.alive();
    this.jbU = ((Vibrator)getContext().getSystemService("vibrator"));
    this.mTouchSlop = u.a(ViewConfiguration.get(getContext()));
    this.AiX = new Paint(1);
    this.AiY = new Paint(1);
    this.AiX.setColor(getResources().getColor(2131689715));
    this.AiY.setColor(-2147483648);
    this.AiY.setTextSize(getResources().getDimension(2131427862));
    rp(false);
    if (g.E(d.class) != null) {
      this.jhK = ((d)g.E(d.class)).aOz();
    }
    this.jkn = (100.0F * getResources().getDisplayMetrics().density);
    ab.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo init mAnimationPadding: %f, density: %f", new Object[] { Float.valueOf(this.jkn), Float.valueOf(getResources().getDisplayMetrics().density) });
    this.AiZ = getResources().getString(2131298867);
    this.Aja = this.AiY.measureText(this.AiZ);
    super.setOnScrollListener(this);
    paramListAdapter.registerDataSetObserver(new ConversationWithAppBrandListView.11(this, paramListAdapter));
    try
    {
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)getLayoutParams();
      localLayoutParams.topMargin = am.di(getContext());
      ab.i("MicroMsg.ConversationWithAppBrandListView", "[initLayoutParams]1 ActionBar height:%s", new Object[] { Integer.valueOf(localLayoutParams.topMargin) });
      if (localLayoutParams.topMargin <= 0) {
        postDelayed(new ConversationWithAppBrandListView.19(this, localLayoutParams), 200L);
      }
      if (this.jdB != null) {
        dME();
      }
      addFooterView(getEmptyFooter());
      super.setAdapter(paramListAdapter);
      AppMethodBeat.o(34295);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.ConversationWithAppBrandListView", localException, "alvinluo initLayoutParams exception", new Object[0]);
      }
    }
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    AppMethodBeat.i(34301);
    super.setOnItemClickListener(new ConversationWithAppBrandListView.22(this, paramOnItemClickListener));
    AppMethodBeat.o(34301);
  }
  
  public void setOnItemLongClickListener(final AdapterView.OnItemLongClickListener paramOnItemLongClickListener)
  {
    AppMethodBeat.i(34302);
    super.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(34291);
        if ((paramAnonymousInt == 0) && (ConversationWithAppBrandListView.b(ConversationWithAppBrandListView.this)))
        {
          AppMethodBeat.o(34291);
          return false;
        }
        if (paramOnItemLongClickListener != null)
        {
          boolean bool = paramOnItemLongClickListener.onItemLongClick(paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
          AppMethodBeat.o(34291);
          return bool;
        }
        AppMethodBeat.o(34291);
        return false;
      }
    });
    AppMethodBeat.o(34302);
  }
  
  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.ojv = paramOnScrollListener;
  }
  
  public void setSelection(int paramInt)
  {
    AppMethodBeat.i(34315);
    ab.i("MicroMsg.ConversationWithAppBrandListView", "[setSelection] position:%s", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt == 0) && (rp(true)))
    {
      paramInt = getFirstHeaderVisible();
      ab.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo setSelection pos: %d, appbrandHeight: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.Ajv) });
      super.setSelection(paramInt);
      if ((this.jhK != null) && (this.Ajb != null))
      {
        this.jhK.M(this.Ajb.getRecentAppBrandCount(), this.Ajb.getStarAppBrandCount(), 7);
        this.Ajb.ql(7);
      }
      AppMethodBeat.o(34315);
      return;
    }
    super.setSelection(paramInt);
    AppMethodBeat.o(34315);
  }
  
  public void smoothScrollToPosition(int paramInt)
  {
    AppMethodBeat.i(34316);
    ab.d("MicroMsg.ConversationWithAppBrandListView", "[smoothScrollToPosition] position:%s", new Object[] { Integer.valueOf(paramInt) });
    if ((paramInt == 0) && (rp(true)))
    {
      super.smoothScrollToPosition(getFirstHeaderVisible());
      AppMethodBeat.o(34316);
      return;
    }
    super.smoothScrollToPosition(paramInt);
    AppMethodBeat.o(34316);
  }
  
  public void smoothScrollToPositionFromTop(int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(34317);
    ab.d("MicroMsg.ConversationWithAppBrandListView", "[smoothScrollToPositionFromTop] position:%s offset:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    final int i = paramInt1;
    if (paramInt1 == 0)
    {
      i = paramInt1;
      if (rp(true)) {
        i = getFirstHeaderVisible();
      }
    }
    al.p(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(34274);
        ConversationWithAppBrandListView.a(ConversationWithAppBrandListView.this, i, paramInt2);
        AppMethodBeat.o(34274);
      }
    }, 100L);
    AppMethodBeat.o(34317);
  }
  
  public void smoothScrollToPositionFromTop(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(34318);
    ab.d("MicroMsg.ConversationWithAppBrandListView", "[smoothScrollToPositionFromTop] position:%s offset:%s duration:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if ((paramInt1 == 0) && (rp(true)))
    {
      super.smoothScrollToPositionFromTop(getFirstHeaderVisible(), paramInt2, paramInt3);
      AppMethodBeat.o(34318);
      return;
    }
    super.smoothScrollToPositionFromTop(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(34318);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.ConversationWithAppBrandListView
 * JD-Core Version:    0.7.0.1
 */
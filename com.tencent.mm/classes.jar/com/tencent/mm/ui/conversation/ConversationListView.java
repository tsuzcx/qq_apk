package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.kg;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.widget.header.HeaderContainer;
import com.tencent.mm.plugin.appbrand.widget.header.c.a;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.e;
import com.tencent.mm.plugin.appbrand.widget.recentview.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.am;
import java.util.Iterator;
import java.util.LinkedList;

public class ConversationListView
  extends ListView
  implements View.OnTouchListener, AbsListView.OnScrollListener, c.a, AppBrandRecentView.e
{
  private final float AiA;
  private int AiB;
  private boolean AiC;
  Runnable AiD;
  Runnable AiE;
  Runnable AiF;
  View AiG;
  private int AiH;
  private int AiI;
  private int AiJ;
  com.tencent.mm.sdk.b.c<kg> AiK;
  private View.OnTouchListener AiL;
  private int AiM;
  View AiN;
  private boolean AiO;
  private boolean AiP;
  private LinkedList<ListView.FixedViewInfo> Aik;
  com.tencent.mm.plugin.appbrand.widget.header.c Ail;
  private String Aim;
  private float Ain;
  private int Aio;
  private Bitmap Aip;
  private RectF Aiq;
  private boolean Air;
  private NinePatchDrawable Ais;
  private Rect Ait;
  private final float Aiu;
  private final float Aiv;
  private final float Aiw;
  private final float Aix;
  private final float Aiy;
  private boolean Aiz;
  private int XO;
  private View Xz;
  private AdapterView.OnItemClickListener amh;
  boolean czT;
  private int iAy;
  private int iPy;
  HeaderContainer jbP;
  private int jbV;
  private com.tencent.mm.plugin.appbrand.widget.header.a jbW;
  private View jbY;
  private boolean jcG;
  boolean jcu;
  private MMFragmentActivity jdB;
  private View.OnTouchListener kjL;
  private int mCount;
  private Paint mPaint;
  private int mScrollState;
  private AbsListView.OnScrollListener ojv;
  private AdapterView.OnItemLongClickListener zsC;
  
  public ConversationListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(34221);
    this.Aik = new LinkedList();
    this.mPaint = new Paint(1);
    this.Aip = null;
    this.Aiq = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
    this.Air = false;
    this.Ais = null;
    this.Ait = new Rect();
    this.Aiu = com.tencent.mm.cb.a.fromDPToPix(getContext(), 30);
    this.Aiv = com.tencent.mm.cb.a.fromDPToPix(getContext(), 8);
    this.Aiw = com.tencent.mm.cb.a.fromDPToPix(getContext(), 24);
    this.Aix = com.tencent.mm.cb.a.fromDPToPix(getContext(), 64);
    this.Aiy = 0.5F;
    this.Aiz = false;
    this.AiA = com.tencent.mm.cb.a.fromDPToPix(getContext(), 200);
    this.AiB = 0;
    this.jcu = false;
    this.AiC = false;
    this.jbW = null;
    this.AiD = null;
    this.AiE = null;
    this.AiF = null;
    this.iPy = 0;
    this.AiH = 0;
    this.iAy = 0;
    this.AiI = com.tencent.mm.cb.a.fromDPToPix(getContext(), 56);
    this.jcG = true;
    this.AiJ = 0;
    this.czT = false;
    this.AiK = new ConversationListView.1(this);
    this.AiL = null;
    this.AiM = 0;
    this.AiP = false;
    init(paramContext);
    AppMethodBeat.o(34221);
  }
  
  public ConversationListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(34222);
    this.Aik = new LinkedList();
    this.mPaint = new Paint(1);
    this.Aip = null;
    this.Aiq = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
    this.Air = false;
    this.Ais = null;
    this.Ait = new Rect();
    this.Aiu = com.tencent.mm.cb.a.fromDPToPix(getContext(), 30);
    this.Aiv = com.tencent.mm.cb.a.fromDPToPix(getContext(), 8);
    this.Aiw = com.tencent.mm.cb.a.fromDPToPix(getContext(), 24);
    this.Aix = com.tencent.mm.cb.a.fromDPToPix(getContext(), 64);
    this.Aiy = 0.5F;
    this.Aiz = false;
    this.AiA = com.tencent.mm.cb.a.fromDPToPix(getContext(), 200);
    this.AiB = 0;
    this.jcu = false;
    this.AiC = false;
    this.jbW = null;
    this.AiD = null;
    this.AiE = null;
    this.AiF = null;
    this.iPy = 0;
    this.AiH = 0;
    this.iAy = 0;
    this.AiI = com.tencent.mm.cb.a.fromDPToPix(getContext(), 56);
    this.jcG = true;
    this.AiJ = 0;
    this.czT = false;
    this.AiK = new ConversationListView.1(this);
    this.AiL = null;
    this.AiM = 0;
    this.AiP = false;
    init(paramContext);
    AppMethodBeat.o(34222);
  }
  
  private float Qx(int paramInt)
  {
    AppMethodBeat.i(34240);
    int i = (int)getResources().getDimension(2131427807);
    int j = getHeaderViewsCount();
    int k = getFooterViewsCount();
    float f = getMeasuredHeight() - i * (paramInt - j - k) - am.di(getContext());
    ab.d("MicroMsg.ConversationListView", "alvinluo isFullScreen getMeasuredHeight: %d", new Object[] { Integer.valueOf(getMeasuredHeight()) });
    ab.i("MicroMsg.ConversationListView", "[isFullScreen] totalItemCount:" + paramInt + " getFirstVisiblePosition:" + getFirstVisiblePosition() + " getLastVisiblePosition:" + getLastVisiblePosition() + " getHeaderViewsCount:" + getHeaderViewsCount() + " getFooterViewsCount:" + getFooterViewsCount() + " extraHeight:" + f);
    AppMethodBeat.o(34240);
    return f;
  }
  
  private void dMA()
  {
    AppMethodBeat.i(156155);
    if (this.jbW != null)
    {
      int i = getResources().getColor(2131689652);
      this.jbW.b(0.0F, i, i);
      this.jbW.a(0.0F, getResources().getColor(2131690316), 0);
    }
    AppMethodBeat.o(156155);
  }
  
  private void dMu()
  {
    AppMethodBeat.i(153990);
    if ((Build.VERSION.SDK_INT >= 24) && (LauncherUI.getInstance() != null))
    {
      this.czT = LauncherUI.getInstance().isInMultiWindowMode();
      if (this.jbP != null) {
        this.jbP.fg(this.czT);
      }
    }
    this.AiK.alive();
    AppMethodBeat.o(153990);
  }
  
  private void dMx()
  {
    AppMethodBeat.i(34238);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.AiN.getLayoutParams();
    int i;
    float f2;
    boolean bool;
    label42:
    int k;
    int m;
    label146:
    int j;
    float f1;
    if (getAdapter() == null)
    {
      i = 0;
      f2 = Qx(i);
      if (f2 >= 0.0F) {
        break label306;
      }
      bool = true;
      k = localLayoutParams.height;
      ab.i("MicroMsg.ConversationListView", "[checkEmptyFooter] isRealFull:" + bool + " old height:" + k);
      View localView = getRootView().findViewById(2131820634);
      if (localView != null) {
        ab.i("MicroMsg.ConversationListView", "alvinluo checkEmptyFooter tabView Height: %d", new Object[] { Integer.valueOf(localView.getHeight()) });
      }
      m = (int)getResources().getDimension(2131427807);
      if (localView == null) {
        break label312;
      }
      i = localView.getHeight();
      j = i;
      if (i <= 0) {
        j = this.AiB;
      }
      ab.d("MicroMsg.ConversationListView", "alvinluo checkEmptyFooter tabHeight: %d", new Object[] { Integer.valueOf(j) });
      if (!bool) {
        break label317;
      }
      localLayoutParams.height = j;
      f1 = f2;
    }
    for (;;)
    {
      if (k != localLayoutParams.height)
      {
        ab.i("MicroMsg.ConversationListView", "alvinluo checkEmptyFooter isHeaderOpen: %b", new Object[] { Boolean.valueOf(aOX()) });
        if (((!bool) || (Math.abs(f1) <= j + m)) && (!aOX()))
        {
          ab.i("MicroMsg.ConversationListView", "[checkEmptyFooter] setSelection");
          setSelection(1);
          if (this.Ail != null) {
            this.Ail.fe(true);
          }
        }
        this.AiN.requestLayout();
      }
      AppMethodBeat.o(34238);
      return;
      i = getAdapter().getCount();
      break;
      label306:
      bool = false;
      break label42;
      label312:
      i = 0;
      break label146;
      label317:
      f1 = f2;
      if (f2 < j) {
        f1 = j;
      }
      localLayoutParams.height = ((int)f1);
    }
  }
  
  private boolean dMy()
  {
    AppMethodBeat.i(34249);
    if (this.jbP == null)
    {
      AppMethodBeat.o(34249);
      return false;
    }
    if ((this.jbP.getBottom() >= this.XO + 3) && (getFirstVisiblePosition() == 0))
    {
      AppMethodBeat.o(34249);
      return true;
    }
    AppMethodBeat.o(34249);
    return false;
  }
  
  private View getEmptyFooter()
  {
    AppMethodBeat.i(34239);
    Object localObject = getRootView().findViewById(2131820634);
    int j = (int)getResources().getDimension(2131427807);
    int i;
    if (localObject != null)
    {
      i = ((View)localObject).getHeight();
      if (i > 0) {
        break label124;
      }
      i = j;
    }
    label124:
    for (;;)
    {
      localObject = new LinearLayout(getContext());
      this.AiN = new View(getContext());
      this.AiN.setLayoutParams(new LinearLayout.LayoutParams(-1, i));
      ((LinearLayout)localObject).addView(this.AiN);
      ((LinearLayout)localObject).setBackgroundColor(getContext().getResources().getColor(2131690709));
      AppMethodBeat.o(34239);
      return localObject;
      i = 0;
      break;
    }
  }
  
  private int getRealCount()
  {
    AppMethodBeat.i(34231);
    if (getAdapter() == null)
    {
      AppMethodBeat.o(34231);
      return 1;
    }
    int i = getAdapter().getCount();
    int j = getHeaderViewsCount();
    int k = getFooterViewsCount();
    AppMethodBeat.o(34231);
    return i - j - k;
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(34224);
    this.mPaint.setAlpha(255);
    this.mPaint.setTextSize(com.tencent.mm.cb.a.ap(getContext(), 2131427790));
    this.Aim = getResources().getString(2131298417);
    this.Ain = this.mPaint.measureText(this.Aim);
    super.setOnScrollListener(this);
    super.setOnTouchListener(this);
    setOverScrollMode(2);
    ab.i("MicroMsg.ConversationListView", "alvinluo HeaderContainer new, ConversationListView: %d", new Object[] { Integer.valueOf(hashCode()) });
    this.jbP = ((d)g.E(d.class)).dj(paramContext);
    this.jbP.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
    addHeaderView(this.jbP);
    addFooterView(getEmptyFooter());
    this.Ail = ((d)g.E(d.class)).a(paramContext, this, this.jbP);
    this.Ail.a(this);
    this.jbP.setAnimController(this.Ail);
    this.AiB = ((int)(com.tencent.mm.cb.a.ap(getContext(), 2131427563) * com.tencent.mm.cb.a.gr(getContext())));
    this.jbV = am.di(getContext());
    this.AiM = com.tencent.mm.cb.a.fromDPToPix(paramContext, 100);
    dMu();
    AppMethodBeat.o(34224);
  }
  
  private void setListTopMargin(int paramInt)
  {
    AppMethodBeat.i(156153);
    ab.i("MicroMsg.ConversationListView", "alvinluo initActionBarView statusBarHeight: %d, isInMultiWindowMode: %b, target: %d, actionBarTop: %d", new Object[] { Integer.valueOf(this.iPy), Boolean.valueOf(this.czT), Integer.valueOf(paramInt), Integer.valueOf(this.Xz.getTop()) });
    if (paramInt >= 0)
    {
      if (this.jbY != null) {
        if (this.czT) {
          break label127;
        }
      }
      ViewGroup.LayoutParams localLayoutParams;
      label127:
      for (this.jbY.getLayoutParams().height = this.iPy;; this.jbY.getLayoutParams().height = paramInt)
      {
        localLayoutParams = getLayoutParams();
        if (!(localLayoutParams instanceof RelativeLayout.LayoutParams)) {
          break label149;
        }
        if (this.czT) {
          break;
        }
        ((RelativeLayout.LayoutParams)localLayoutParams).topMargin = this.iPy;
        AppMethodBeat.o(156153);
        return;
      }
      ((RelativeLayout.LayoutParams)localLayoutParams).topMargin = paramInt;
    }
    label149:
    AppMethodBeat.o(156153);
  }
  
  public final boolean aOX()
  {
    AppMethodBeat.i(34248);
    if ((dMy()) && (this.jcu))
    {
      AppMethodBeat.o(34248);
      return true;
    }
    AppMethodBeat.o(34248);
    return false;
  }
  
  public final void aPx()
  {
    AppMethodBeat.i(34233);
    ab.d("MicroMsg.ConversationListView", "[onOpenHeader]");
    this.jcu = true;
    if (this.AiD != null) {
      removeCallbacks(this.AiD);
    }
    AppMethodBeat.o(34233);
  }
  
  public final void aPy()
  {
    AppMethodBeat.i(34236);
    aPx();
    AppMethodBeat.o(34236);
  }
  
  public void addHeaderView(View paramView, Object paramObject, boolean paramBoolean)
  {
    AppMethodBeat.i(34247);
    super.addHeaderView(paramView, paramObject, paramBoolean);
    ListView.FixedViewInfo localFixedViewInfo = new ListView.FixedViewInfo(this);
    localFixedViewInfo.view = paramView;
    localFixedViewInfo.data = paramObject;
    localFixedViewInfo.isSelectable = paramBoolean;
    this.Aik.add(localFixedViewInfo);
    AppMethodBeat.o(34247);
  }
  
  protected void attachViewToParent(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(34226);
    super.attachViewToParent(paramView, paramInt, paramLayoutParams);
    if ((this.XO <= 0) && (this.Ail != null))
    {
      this.XO = (am.di(getContext()) + af.hU(getContext()));
      this.jbV = am.di(getContext());
      dMv();
      if (this.jbP != null) {
        this.jbP.setActionBar(this.Xz);
      }
      this.Ail.setActionBar(this.Xz);
      this.Ail.setTabView(getRootView().findViewById(2131820634));
    }
    AppMethodBeat.o(34226);
  }
  
  public boolean canScrollHorizontally(int paramInt)
  {
    AppMethodBeat.i(34223);
    if (this.jbP == null)
    {
      boolean bool = super.canScrollHorizontally(paramInt);
      AppMethodBeat.o(34223);
      return bool;
    }
    if (this.jbP.getBottom() >= this.jbP.getHeight())
    {
      AppMethodBeat.o(34223);
      return true;
    }
    AppMethodBeat.o(34223);
    return false;
  }
  
  final void dMv()
  {
    int j = 0;
    AppMethodBeat.i(153991);
    this.Xz = getRootView().findViewById(2131820956);
    if (this.Xz == null)
    {
      AppMethodBeat.o(153991);
      return;
    }
    if ((this.czT) && (Build.VERSION.SDK_INT >= 24) && (LauncherUI.getInstance() != null))
    {
      this.czT = LauncherUI.getInstance().isInMultiWindowMode();
      ab.i("MicroMsg.ConversationListView", "alvinluo initActionBarView check multiWindowMode %b", new Object[] { Boolean.valueOf(this.czT) });
    }
    int i;
    if (this.iPy != 0)
    {
      i = j;
      if (!this.czT)
      {
        i = j;
        if (this.Xz.getTop() != this.iPy)
        {
          i = j;
          if (this.Xz.getTop() == 0) {}
        }
      }
    }
    else
    {
      this.iPy = this.Xz.getTop();
      i = 1;
    }
    if ((i != 0) && (!this.czT))
    {
      post(new ConversationListView.4(this));
      AppMethodBeat.o(153991);
      return;
    }
    this.AiH = this.Xz.getTop();
    setListTopMargin(this.AiH);
    AppMethodBeat.o(153991);
  }
  
  public final void dMw()
  {
    AppMethodBeat.i(156154);
    if (this.Ail != null) {
      this.Ail.c(0L, 0, true);
    }
    dMz();
    AppMethodBeat.o(156154);
  }
  
  final void dMz()
  {
    AppMethodBeat.i(154685);
    if (this.Xz != null)
    {
      this.Xz.setTranslationY(0.0F);
      this.Xz.setVisibility(0);
    }
    dMA();
    AppMethodBeat.o(154685);
  }
  
  public boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    AppMethodBeat.i(153992);
    if ((getFirstVisiblePosition() == 0) && (paramInt2 < 0) && (paramArrayOfInt1 != null) && (paramArrayOfInt1.length >= 2) && (!this.jcu))
    {
      paramArrayOfInt1[1] = ((int)(paramInt2 / 2.4F));
      super.dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2);
      AppMethodBeat.o(153992);
      return true;
    }
    boolean bool = super.dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2);
    AppMethodBeat.o(153992);
    return bool;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(34250);
    if (this.AiL != null) {
      this.AiL.onTouch(this, paramMotionEvent);
    }
    int i;
    boolean bool;
    try
    {
      ab.d("MicroMsg.ConversationListView", "alvinluo dispatchTouchEvent backUpFooterRect: %s, %f, %f, bottom: %d, height: %d, isCanClose: %b", new Object[] { this.jbP.getBackUpFooterRect().toString(), Float.valueOf(paramMotionEvent.getRawX()), Float.valueOf(paramMotionEvent.getRawY()), Integer.valueOf(this.jbP.getBottom()), Integer.valueOf(this.jbP.getHeight()), Boolean.valueOf(this.AiO) });
      int j = (int)(paramMotionEvent.getRawY() - this.iPy);
      i = j;
      if (this.czT) {
        i = j - this.AiJ + this.iPy;
      }
      if ((aOX()) && (this.jbP != null))
      {
        if (paramMotionEvent.getAction() == 0) {
          if (!this.jbP.getBackUpFooterRect().contains((int)paramMotionEvent.getRawX(), i)) {
            break label240;
          }
        }
        label240:
        for (this.AiP = true;; this.AiP = false)
        {
          ab.d("MicroMsg.ConversationListView", "alvinluo dispatchTouchEvent isDownInCloseRect: %b, touchY: %d", new Object[] { Boolean.valueOf(this.AiP), Integer.valueOf(i) });
          if (this.AiP) {
            break;
          }
          bool = this.jbP.dispatchTouchEvent(paramMotionEvent);
          AppMethodBeat.o(34250);
          return bool;
        }
      }
      if (this.jbP == null) {
        break label508;
      }
    }
    catch (Exception paramMotionEvent)
    {
      ab.printErrStackTrace("MicroMsg.ConversationListView", paramMotionEvent, "alvinluo ConversationListView dispatchTouchEvent exception", new Object[0]);
      AppMethodBeat.o(34250);
      return false;
    }
    if ((this.jbP.getBottom() >= this.jbP.getHeight()) && (this.jbP.isFullScreen()) && (getFirstVisiblePosition() == 0))
    {
      if ((paramMotionEvent.getAction() == 0) && (this.jbP.getBackUpFooterRect().contains((int)paramMotionEvent.getRawX(), i))) {
        this.AiO = true;
      }
      while ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
      {
        if (this.AiO)
        {
          this.AiO = false;
          if (this.Ail != null)
          {
            ab.i("MicroMsg.ConversationListView", "alvinluo closeHeader by click BackUpFooterRect");
            this.Ail.pW(12);
          }
          if (paramMotionEvent.getAction() == 1)
          {
            ab.i("MicroMsg.ConversationListView", "alvinluo ConversationListView cancel touch event");
            paramMotionEvent.setAction(3);
            bool = super.dispatchTouchEvent(paramMotionEvent);
            AppMethodBeat.o(34250);
            return bool;
            if (paramMotionEvent.getAction() != 0) {
              continue;
            }
            this.AiO = false;
          }
        }
        else
        {
          bool = super.dispatchTouchEvent(paramMotionEvent);
          AppMethodBeat.o(34250);
          return bool;
        }
        AppMethodBeat.o(34250);
        return true;
      }
      if ((this.Ail != null) && (paramMotionEvent.getAction() == 0)) {
        this.Ail.J(paramMotionEvent);
      }
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(34250);
      return bool;
    }
    label508:
    if ((this.AiO) && (paramMotionEvent.getAction() == 1))
    {
      ab.i("MicroMsg.ConversationListView", "alvinluo ConversationListView cancel touch event..., isHeaderOpen: %b, isHeaderVisible: %b", new Object[] { Boolean.valueOf(aOX()), Boolean.valueOf(dMy()) });
      if (aOX()) {
        break label612;
      }
      this.AiO = false;
    }
    for (;;)
    {
      if ((paramMotionEvent.getAction() == 0) && (this.Ail != null) && (paramMotionEvent.getAction() == 0)) {
        this.Ail.J(paramMotionEvent);
      }
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(34250);
      return bool;
      label612:
      paramMotionEvent.setAction(3);
    }
  }
  
  public final void g(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(34245);
    ab.i("MicroMsg.ConversationListView", "[showAppBrandHeader] isShow:" + paramBoolean1 + " isAnim:" + paramBoolean2 + " isScrollFirst:" + paramBoolean3);
    if (paramBoolean1)
    {
      if (this.Ail != null)
      {
        this.Ail.aOR();
        AppMethodBeat.o(34245);
      }
    }
    else if (this.Ail != null) {
      this.Ail.pW(0);
    }
    AppMethodBeat.o(34245);
  }
  
  public int getFirstHeaderVisible()
  {
    AppMethodBeat.i(34246);
    Iterator localIterator = this.Aik.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject = (ListView.FixedViewInfo)localIterator.next();
      if (((ListView.FixedViewInfo)localObject).view == this.jbP)
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
            ab.i("MicroMsg.ConversationListView", "[getFirstHeaderVisible] index:%s", new Object[] { Integer.valueOf(i) });
            AppMethodBeat.o(34246);
            return i;
          }
        }
        i += 1;
      }
    }
    ab.i("MicroMsg.ConversationListView", "[getFirstHeaderVisible] index:%s", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(34246);
    return i;
  }
  
  final void hK(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(153993);
    if (this.jbW != null)
    {
      this.jbW.a(1.0F, paramInt1, 0);
      this.jbW.b(1.0F, paramInt2, paramInt2);
    }
    AppMethodBeat.o(153993);
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(34253);
    super.onConfigurationChanged(paramConfiguration);
    ab.i("MicroMsg.ConversationListView", "[onConfigurationChanged] orientation:%s, last: %d", new Object[] { Integer.valueOf(paramConfiguration.orientation), Integer.valueOf(this.iAy) });
    rl(true);
    if (this.Ail != null) {
      this.Ail.gA();
    }
    if (this.jbP != null) {
      this.jbP.b(paramConfiguration);
    }
    hK(getResources().getColor(2131690316), getResources().getColor(2131689652));
    if (this.AiF != null) {
      removeCallbacks(this.AiF);
    }
    paramConfiguration = new ConversationListView.10(this);
    this.AiF = paramConfiguration;
    postDelayed(paramConfiguration, 800L);
    this.jcu = false;
    AppMethodBeat.o(34253);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(34227);
    super.onDraw(paramCanvas);
    if ((this.jbP != null) && (getFirstVisiblePosition() == 0) && (this.jbP.isFullScreen()) && (this.jbP.getBottom() > 6))
    {
      if (this.Aio < 30)
      {
        AppMethodBeat.o(34227);
        return;
      }
      this.mPaint.setStyle(Paint.Style.FILL);
      this.mPaint.setColor(getContext().getResources().getColor(2131689692));
      this.mPaint.setAlpha(this.Aio);
      paramCanvas.drawRect(this.jbP.getBackUpFooterRect().left, this.jbP.getBackUpFooterRect().top + this.AiI, this.jbP.getBackUpFooterRect().right, this.jbP.getBackUpFooterRect().bottom, this.mPaint);
    }
    AppMethodBeat.o(34227);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(34230);
    try
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      boolean bool = aOX();
      ab.i("MicroMsg.ConversationListView", "[onLayout] changed:%s, isHeaderOpen: %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) });
      ab.d("MicroMsg.ConversationListView", "[onLayout] top: %d, bottom: %d, height: %d, count: %d, realCount: %d, hashCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt4), Integer.valueOf(paramInt4 - paramInt2), Integer.valueOf(this.mCount), Integer.valueOf(getRealCount()), Integer.valueOf(hashCode()) });
      if ((paramBoolean) && (!bool))
      {
        setSelection(1);
        post(new ConversationListView.5(this));
      }
      if ((paramBoolean) || ((this.mCount < 16) && (getRealCount() != this.mCount))) {
        rl(false);
      }
      if ((this.AiG != null) && (this.AiG.getVisibility() == 0) && (getFirstVisiblePosition() != 0)) {
        this.AiG.setVisibility(4);
      }
      this.mCount = getRealCount();
      AppMethodBeat.o(34230);
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.ConversationListView", localException, "alvinluo onLayout exception", new Object[0]);
      AppMethodBeat.o(34230);
    }
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(34229);
    Object localObject;
    int i;
    if ((paramInt1 == 0) && (this.jcG))
    {
      localObject = getChildAt(1);
      if (localObject == null) {
        if (aOX())
        {
          i = this.jbP.getMeasuredHeight() - this.jbV;
          ab.i("MicroMsg.ConversationListView", "alvinluo computeActionBarTranslation %d", new Object[] { Integer.valueOf(i) });
          label70:
          i = Math.max(0, i);
          if (this.Xz != null)
          {
            if (Math.abs(i) > this.AiM) {
              break label441;
            }
            this.Xz.setVisibility(0);
            label105:
            ab.v("MicroMsg.ConversationListView", "alvinluo onScroll setTranslationY before: %f, trans: %d", new Object[] { Float.valueOf(this.Xz.getTranslationY()), Integer.valueOf(i) });
            this.Xz.setTranslationY(i);
          }
          if (this.jbP != null)
          {
            localObject = this.jbP;
            this.jbP.getHeight();
            ((HeaderContainer)localObject).dr(i, this.jbP.getHeight() - this.jbV);
          }
        }
      }
    }
    for (;;)
    {
      if (this.ojv != null) {
        this.ojv.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
      }
      if (this.Ail != null) {
        this.Ail.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
      }
      if ((paramInt2 > 1) && (dMy()) && (this.jbP != null))
      {
        paramAbsListView = new int[2];
        getLocationOnScreen(paramAbsListView);
        this.AiJ = paramAbsListView[1];
        paramInt1 = this.jbP.getBottom() - com.tencent.mm.cb.a.fromDPToPix(getContext(), 56);
        this.jbP.getBackUpFooterRect().set(0, paramInt1, getWidth(), getHeight() + paramInt1);
        ab.d("MicroMsg.ConversationListView", "alvinluo onScroll BackUpFooterRect: %s, headerContainer top: %d, bottom: %d", new Object[] { this.jbP.getBackUpFooterRect().toString(), Integer.valueOf(this.jbP.getTop()), Integer.valueOf(this.jbP.getBottom()) });
        this.Aio = ((int)(255.0F * this.jbP.getBottom() / this.jbP.getHeight()));
      }
      AppMethodBeat.o(34229);
      return;
      i = 0;
      break;
      i = ((View)localObject).getTop();
      int j = Math.max(paramInt1 - getHeaderViewsCount(), 0);
      i = -(-i + (int)(j * getResources().getDimension(2131427807)) + this.jbV);
      break label70;
      label441:
      this.Xz.setVisibility(4);
      break label105;
      if (paramInt1 > 0) {
        dMz();
      }
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(34228);
    if (this.ojv != null) {
      this.ojv.onScrollStateChanged(paramAbsListView, paramInt);
    }
    if (this.Ail != null) {
      this.Ail.onScrollStateChanged(paramAbsListView, paramInt);
    }
    this.mScrollState = paramInt;
    AppMethodBeat.o(34228);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(34225);
    boolean bool2 = this.Ail.onTouch(paramView, paramMotionEvent);
    boolean bool1 = bool2;
    if (this.kjL != null) {
      bool1 = bool2 | this.kjL.onTouch(paramView, paramMotionEvent);
    }
    AppMethodBeat.o(34225);
    return bool1;
  }
  
  public final void qb(int paramInt)
  {
    AppMethodBeat.i(34234);
    ab.d("MicroMsg.ConversationListView", "[onCloseHeader]");
    this.AiO = false;
    this.jcu = false;
    this.Aio = 0;
    if (this.AiD != null) {
      removeCallbacks(this.AiD);
    }
    AppMethodBeat.o(34234);
  }
  
  public final void qc(int paramInt)
  {
    AppMethodBeat.i(34235);
    qb(paramInt);
    AppMethodBeat.o(34235);
  }
  
  public final void qj(int paramInt) {}
  
  final void rl(boolean paramBoolean)
  {
    AppMethodBeat.i(34237);
    if (this.AiN == null)
    {
      AppMethodBeat.o(34237);
      return;
    }
    if (paramBoolean)
    {
      postDelayed(new ConversationListView.7(this), 0L);
      AppMethodBeat.o(34237);
      return;
    }
    dMx();
    AppMethodBeat.o(34237);
  }
  
  public void setActionBarUpdateCallback(com.tencent.mm.plugin.appbrand.widget.header.a parama)
  {
    AppMethodBeat.i(34254);
    if (this.Ail != null)
    {
      this.jbW = parama;
      this.Ail.setActionBarUpdateCallback(new ConversationListView.3(this, parama));
    }
    AppMethodBeat.o(34254);
  }
  
  public void setActivity(MMFragmentActivity paramMMFragmentActivity)
  {
    AppMethodBeat.i(34255);
    this.jdB = paramMMFragmentActivity;
    if (this.jbP != null) {
      this.jbP.setActivity(this.jdB);
    }
    AppMethodBeat.o(34255);
  }
  
  public void setIsCurrentMainUI(boolean paramBoolean)
  {
    AppMethodBeat.i(153994);
    ab.i("MicroMsg.ConversationListView", "alvinluo setIsCurrentMainUI: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.jcG = paramBoolean;
    if (this.Ail != null) {
      this.Ail.setIsCurrentMainUI(paramBoolean);
    }
    AppMethodBeat.o(153994);
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    AppMethodBeat.i(34252);
    this.amh = paramOnItemClickListener;
    super.setOnItemClickListener(new ConversationListView.9(this));
    AppMethodBeat.o(34252);
  }
  
  public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener paramOnItemLongClickListener)
  {
    AppMethodBeat.i(34251);
    this.zsC = paramOnItemLongClickListener;
    super.setOnItemLongClickListener(new ConversationListView.8(this));
    AppMethodBeat.o(34251);
  }
  
  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.ojv = paramOnScrollListener;
  }
  
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    this.kjL = paramOnTouchListener;
  }
  
  public void setSelection(int paramInt)
  {
    AppMethodBeat.i(34241);
    ab.i("MicroMsg.ConversationListView", "[setSelection] position:%s, scrollOffset: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.jbV) });
    if (paramInt == 0)
    {
      super.setSelectionFromTop(getFirstHeaderVisible(), this.jbV);
      AppMethodBeat.o(34241);
      return;
    }
    super.setSelectionFromTop(paramInt, this.jbV);
    AppMethodBeat.o(34241);
  }
  
  public void setStatusBarMaskView(View paramView)
  {
    AppMethodBeat.i(34256);
    this.jbY = paramView;
    if (this.Ail != null) {
      this.Ail.setStatusBarMaskView(paramView);
    }
    AppMethodBeat.o(34256);
  }
  
  public void setonDispatchTouchEventListener(View.OnTouchListener paramOnTouchListener)
  {
    this.AiL = paramOnTouchListener;
  }
  
  public void smoothScrollToPosition(int paramInt)
  {
    AppMethodBeat.i(34242);
    ab.i("MicroMsg.ConversationListView", "[smoothScrollToPosition] position:%s", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 0)
    {
      super.smoothScrollToPositionFromTop(getFirstHeaderVisible(), this.jbV);
      AppMethodBeat.o(34242);
      return;
    }
    super.smoothScrollToPositionFromTop(paramInt, this.jbV);
    AppMethodBeat.o(34242);
  }
  
  public void smoothScrollToPositionFromTop(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(34243);
    ab.i("MicroMsg.ConversationListView", "[smoothScrollToPositionFromTop] position:%s offset:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == 0)
    {
      super.smoothScrollToPositionFromTop(getFirstHeaderVisible(), this.jbV + paramInt2);
      AppMethodBeat.o(34243);
      return;
    }
    super.smoothScrollToPositionFromTop(paramInt1, this.jbV + paramInt2);
    AppMethodBeat.o(34243);
  }
  
  public void smoothScrollToPositionFromTop(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(34244);
    ab.i("MicroMsg.ConversationListView", "[smoothScrollToPositionFromTop] position:%s offset:%s duration:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramInt1 == 0)
    {
      super.smoothScrollToPositionFromTop(getFirstHeaderVisible(), this.jbV + paramInt2, paramInt3);
      AppMethodBeat.o(34244);
      return;
    }
    super.smoothScrollToPositionFromTop(paramInt1, this.jbV + paramInt2, paramInt3);
    AppMethodBeat.o(34244);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.ConversationListView
 * JD-Core Version:    0.7.0.1
 */
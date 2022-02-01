package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
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
import android.view.View.OnLayoutChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
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
import com.tencent.mm.g.a.me;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.widget.header.HeaderContainer;
import com.tencent.mm.plugin.appbrand.widget.header.c.a;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.e;
import com.tencent.mm.plugin.appbrand.widget.recentview.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.ar;
import java.util.Iterator;
import java.util.LinkedList;

public class ConversationListView
  extends ListView
  implements View.OnTouchListener, AbsListView.OnScrollListener, c.a, AppBrandRecentView.e
{
  private View.OnTouchListener CBc;
  private AdapterView.OnItemLongClickListener JOO;
  private boolean KPA;
  private NinePatchDrawable KPB;
  private Rect KPC;
  private final float KPD;
  private final float KPE;
  private final float KPF;
  private final float KPG;
  private final float KPH;
  private boolean KPI;
  private final float KPJ;
  private int KPK;
  private boolean KPL;
  Runnable KPM;
  Runnable KPN;
  Runnable KPO;
  View KPP;
  private int KPQ;
  private int KPR;
  private int KPS;
  com.tencent.mm.sdk.b.c<me> KPT;
  private View.OnLayoutChangeListener KPU;
  private View.OnTouchListener KPV;
  private int KPW;
  View KPX;
  private boolean KPY;
  private boolean KPZ;
  private LinkedList<ListView.FixedViewInfo> KPt;
  com.tencent.mm.plugin.appbrand.widget.header.c KPu;
  private String KPv;
  private float KPw;
  private int KPx;
  private Bitmap KPy;
  private RectF KPz;
  private int ahF;
  private View ahp;
  private AdapterView.OnItemClickListener awt;
  boolean dAG;
  private int gQT;
  private int mCount;
  private int mKJ;
  private Paint mPaint;
  private int mScrollState;
  private int mZE;
  private com.tencent.mm.plugin.appbrand.widget.header.a mZF;
  private View mZH;
  HeaderContainer mZy;
  boolean nad;
  private boolean nap;
  private MMFragmentActivity nbm;
  private AbsListView.OnScrollListener vwl;
  
  public ConversationListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(38336);
    this.KPt = new LinkedList();
    this.mPaint = new Paint(1);
    this.KPy = null;
    this.KPz = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
    this.KPA = false;
    this.KPB = null;
    this.KPC = new Rect();
    this.KPD = com.tencent.mm.cb.a.fromDPToPix(getContext(), 30);
    this.KPE = com.tencent.mm.cb.a.fromDPToPix(getContext(), 8);
    this.KPF = com.tencent.mm.cb.a.fromDPToPix(getContext(), 24);
    this.KPG = com.tencent.mm.cb.a.fromDPToPix(getContext(), 64);
    this.KPH = 0.5F;
    this.KPI = false;
    this.KPJ = com.tencent.mm.cb.a.fromDPToPix(getContext(), 200);
    this.KPK = 0;
    this.nad = false;
    this.KPL = false;
    this.mZF = null;
    this.KPM = null;
    this.KPN = null;
    this.KPO = null;
    this.mKJ = 0;
    this.KPQ = 0;
    this.gQT = 0;
    this.KPR = com.tencent.mm.cb.a.fromDPToPix(getContext(), 56);
    this.nap = true;
    this.KPS = 0;
    this.dAG = false;
    this.KPT = new com.tencent.mm.sdk.b.c() {};
    this.KPU = new View.OnLayoutChangeListener()
    {
      public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
      {
        AppMethodBeat.i(188049);
        ae.i("MicroMsg.ConversationListView", "ActionBarView layout changed, call setupActionBarView()");
        ConversationListView.b(ConversationListView.this);
        AppMethodBeat.o(188049);
      }
    };
    this.KPV = null;
    this.KPW = 0;
    this.KPZ = false;
    init(paramContext);
    AppMethodBeat.o(38336);
  }
  
  public ConversationListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(38337);
    this.KPt = new LinkedList();
    this.mPaint = new Paint(1);
    this.KPy = null;
    this.KPz = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
    this.KPA = false;
    this.KPB = null;
    this.KPC = new Rect();
    this.KPD = com.tencent.mm.cb.a.fromDPToPix(getContext(), 30);
    this.KPE = com.tencent.mm.cb.a.fromDPToPix(getContext(), 8);
    this.KPF = com.tencent.mm.cb.a.fromDPToPix(getContext(), 24);
    this.KPG = com.tencent.mm.cb.a.fromDPToPix(getContext(), 64);
    this.KPH = 0.5F;
    this.KPI = false;
    this.KPJ = com.tencent.mm.cb.a.fromDPToPix(getContext(), 200);
    this.KPK = 0;
    this.nad = false;
    this.KPL = false;
    this.mZF = null;
    this.KPM = null;
    this.KPN = null;
    this.KPO = null;
    this.mKJ = 0;
    this.KPQ = 0;
    this.gQT = 0;
    this.KPR = com.tencent.mm.cb.a.fromDPToPix(getContext(), 56);
    this.nap = true;
    this.KPS = 0;
    this.dAG = false;
    this.KPT = new com.tencent.mm.sdk.b.c() {};
    this.KPU = new View.OnLayoutChangeListener()
    {
      public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
      {
        AppMethodBeat.i(188049);
        ae.i("MicroMsg.ConversationListView", "ActionBarView layout changed, call setupActionBarView()");
        ConversationListView.b(ConversationListView.this);
        AppMethodBeat.o(188049);
      }
    };
    this.KPV = null;
    this.KPW = 0;
    this.KPZ = false;
    init(paramContext);
    AppMethodBeat.o(38337);
  }
  
  private float afb(int paramInt)
  {
    AppMethodBeat.i(38361);
    int i = (int)getResources().getDimension(2131165515);
    int j = getHeaderViewsCount();
    int k = getFooterViewsCount();
    float f = getMeasuredHeight() - i * (paramInt - j - k) - ar.dX(getContext());
    ae.d("MicroMsg.ConversationListView", "alvinluo isFullScreen getMeasuredHeight: %d", new Object[] { Integer.valueOf(getMeasuredHeight()) });
    ae.i("MicroMsg.ConversationListView", "[isFullScreen] totalItemCount:" + paramInt + " getFirstVisiblePosition:" + getFirstVisiblePosition() + " getLastVisiblePosition:" + getLastVisiblePosition() + " getHeaderViewsCount:" + getHeaderViewsCount() + " getFooterViewsCount:" + getFooterViewsCount() + " extraHeight:" + f);
    AppMethodBeat.o(38361);
    return f;
  }
  
  private static void bs(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(38343);
    ae.i("MicroMsg.ConversationListView", "alvinluo saveTopMargin topMargin: %d, needRead: %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    Object localObject = ak.fox();
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      if (localObject != null)
      {
        ((SharedPreferences.Editor)localObject).putBoolean("Main_need_read_top_margin", paramBoolean);
        ((SharedPreferences.Editor)localObject).putInt("Main_top_marign", paramInt);
        ((SharedPreferences.Editor)localObject).apply();
        ae.i("MicroMsg.ConversationListView", "alvinluo saveTopMargin success");
      }
    }
    AppMethodBeat.o(38343);
  }
  
  private void fMZ()
  {
    AppMethodBeat.i(38340);
    if ((Build.VERSION.SDK_INT >= 24) && (LauncherUI.getInstance() != null))
    {
      this.dAG = LauncherUI.getInstance().isInMultiWindowMode();
      if (this.mZy != null) {
        this.mZy.ia(this.dAG);
      }
    }
    AppMethodBeat.o(38340);
  }
  
  private void fNc()
  {
    AppMethodBeat.i(38359);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.KPX.getLayoutParams();
    int i;
    float f2;
    boolean bool;
    label42:
    int k;
    int m;
    label148:
    int j;
    float f1;
    if (getAdapter() == null)
    {
      i = 0;
      f2 = afb(i);
      if (f2 >= 0.0F) {
        break label311;
      }
      bool = true;
      k = localLayoutParams.height;
      ae.i("MicroMsg.ConversationListView", "[checkEmptyFooter] isRealFull:" + bool + " old height:" + k);
      View localView = getRootView().findViewById(2131301338);
      if (localView != null) {
        ae.i("MicroMsg.ConversationListView", "alvinluo checkEmptyFooter tabView Height: %d", new Object[] { Integer.valueOf(localView.getHeight()) });
      }
      m = (int)getResources().getDimension(2131165515);
      if (localView == null) {
        break label317;
      }
      i = localView.getHeight();
      j = i;
      if (i <= 0) {
        j = this.KPK;
      }
      ae.d("MicroMsg.ConversationListView", "alvinluo checkEmptyFooter tabHeight: %d", new Object[] { Integer.valueOf(j) });
      if (!bool) {
        break label322;
      }
      localLayoutParams.height = j;
      f1 = f2;
    }
    for (;;)
    {
      if (k != localLayoutParams.height)
      {
        ae.i("MicroMsg.ConversationListView", "alvinluo checkEmptyFooter isHeaderOpen: %b", new Object[] { Boolean.valueOf(bDr()) });
        if (((!bool) || (Math.abs(f1) <= j + m)) && (!bDr()))
        {
          ae.i("MicroMsg.ConversationListView", "[checkEmptyFooter] setSelection");
          setSelection(1);
          if (this.KPu != null) {
            this.KPu.hY(true);
          }
        }
        this.KPX.requestLayout();
      }
      AppMethodBeat.o(38359);
      return;
      i = getAdapter().getCount();
      break;
      label311:
      bool = false;
      break label42;
      label317:
      i = 0;
      break label148;
      label322:
      f1 = f2;
      if (f2 < j) {
        f1 = j;
      }
      localLayoutParams.height = ((int)f1);
    }
  }
  
  private boolean fNd()
  {
    AppMethodBeat.i(38370);
    if (this.mZy == null)
    {
      AppMethodBeat.o(38370);
      return false;
    }
    if ((this.mZy.getBottom() >= this.ahF + 3) && (getFirstVisiblePosition() == 0))
    {
      AppMethodBeat.o(38370);
      return true;
    }
    AppMethodBeat.o(38370);
    return false;
  }
  
  private void fNf()
  {
    AppMethodBeat.i(38382);
    if (this.mZF != null)
    {
      if (al.isDarkMode())
      {
        i = getResources().getColor(2131099886);
        this.mZF.b(0.0F, i, i);
        this.mZF.a(0.0F, getResources().getColor(2131100196), 0);
        AppMethodBeat.o(38382);
        return;
      }
      int i = getResources().getColor(2131099885);
      this.mZF.b(0.0F, i, i);
      this.mZF.a(0.0F, getResources().getColor(2131100705), 0);
    }
    AppMethodBeat.o(38382);
  }
  
  private View getEmptyFooter()
  {
    AppMethodBeat.i(38360);
    Object localObject = getRootView().findViewById(2131301338);
    int j = (int)getResources().getDimension(2131165515);
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
      this.KPX = new View(getContext());
      this.KPX.setLayoutParams(new LinearLayout.LayoutParams(-1, i));
      ((LinearLayout)localObject).addView(this.KPX);
      ((LinearLayout)localObject).setBackgroundColor(getContext().getResources().getColor(2131099650));
      AppMethodBeat.o(38360);
      return localObject;
      i = 0;
      break;
    }
  }
  
  private int getRealCount()
  {
    AppMethodBeat.i(38351);
    if (getAdapter() == null)
    {
      AppMethodBeat.o(38351);
      return 1;
    }
    int i = getAdapter().getCount();
    int j = getHeaderViewsCount();
    int k = getFooterViewsCount();
    AppMethodBeat.o(38351);
    return i - j - k;
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(38339);
    this.mPaint.setAlpha(255);
    this.mPaint.setTextSize(com.tencent.mm.cb.a.ay(getContext(), 2131165498));
    this.KPv = getResources().getString(2131757429);
    this.KPw = this.mPaint.measureText(this.KPv);
    super.setOnScrollListener(this);
    super.setOnTouchListener(this);
    setOverScrollMode(2);
    ae.i("MicroMsg.ConversationListView", "alvinluo HeaderContainer new, ConversationListView: %d", new Object[] { Integer.valueOf(hashCode()) });
    this.mZy = ((d)g.ab(d.class)).dY(paramContext);
    if (this.mZy != null)
    {
      this.mZy.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
      addHeaderView(this.mZy);
      addFooterView(getEmptyFooter());
      this.KPu = ((d)g.ab(d.class)).a(paramContext, this, this.mZy);
      this.KPu.a(this);
      this.mZy.setAnimController(this.KPu);
    }
    this.KPK = ((int)(com.tencent.mm.cb.a.ay(getContext(), 2131165256) * com.tencent.mm.cb.a.ip(getContext())));
    this.mZE = ar.dX(getContext());
    this.KPW = com.tencent.mm.cb.a.fromDPToPix(paramContext, 100);
    fMZ();
    AppMethodBeat.o(38339);
  }
  
  private void setListTopMargin(int paramInt)
  {
    AppMethodBeat.i(38342);
    ae.i("MicroMsg.ConversationListView", "alvinluo initActionBarView statusBarHeight: %d, isInMultiWindowMode: %b, target: %d, actionBarTop: %d", new Object[] { Integer.valueOf(this.mKJ), Boolean.valueOf(this.dAG), Integer.valueOf(paramInt), Integer.valueOf(this.ahp.getTop()) });
    if (paramInt >= 0)
    {
      if (this.mZH != null) {
        if (this.dAG) {
          break label128;
        }
      }
      ViewGroup.LayoutParams localLayoutParams;
      label128:
      for (this.mZH.getLayoutParams().height = this.mKJ;; this.mZH.getLayoutParams().height = paramInt)
      {
        localLayoutParams = getLayoutParams();
        if (!(localLayoutParams instanceof RelativeLayout.LayoutParams)) {
          break label150;
        }
        if (this.dAG) {
          break;
        }
        ((RelativeLayout.LayoutParams)localLayoutParams).topMargin = this.mKJ;
        AppMethodBeat.o(38342);
        return;
      }
      ((RelativeLayout.LayoutParams)localLayoutParams).topMargin = paramInt;
    }
    label150:
    AppMethodBeat.o(38342);
  }
  
  public void addHeaderView(View paramView, Object paramObject, boolean paramBoolean)
  {
    AppMethodBeat.i(38368);
    super.addHeaderView(paramView, paramObject, paramBoolean);
    ListView.FixedViewInfo localFixedViewInfo = new ListView.FixedViewInfo(this);
    localFixedViewInfo.view = paramView;
    localFixedViewInfo.data = paramObject;
    localFixedViewInfo.isSelectable = paramBoolean;
    this.KPt.add(localFixedViewInfo);
    AppMethodBeat.o(38368);
  }
  
  protected void attachViewToParent(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(38346);
    super.attachViewToParent(paramView, paramInt, paramLayoutParams);
    if ((this.ahF <= 0) && (this.KPu != null))
    {
      this.ahF = (ar.dX(getContext()) + al.aL(getContext(), 0));
      this.mZE = ar.dX(getContext());
      fNa();
      if (this.mZy != null) {
        this.mZy.setActionBar(this.ahp);
      }
      this.KPu.setActionBar(this.ahp);
      this.KPu.setTabView(getRootView().findViewById(2131301338));
    }
    AppMethodBeat.o(38346);
  }
  
  public final void bDR()
  {
    AppMethodBeat.i(38354);
    ae.d("MicroMsg.ConversationListView", "[onOpenHeader]");
    this.nad = true;
    if (this.KPM != null) {
      removeCallbacks(this.KPM);
    }
    AppMethodBeat.o(38354);
  }
  
  public final void bDS()
  {
    AppMethodBeat.i(38357);
    bDR();
    AppMethodBeat.o(38357);
  }
  
  public final boolean bDr()
  {
    AppMethodBeat.i(38369);
    if ((fNd()) && (this.nad))
    {
      AppMethodBeat.o(38369);
      return true;
    }
    AppMethodBeat.o(38369);
    return false;
  }
  
  public boolean canScrollHorizontally(int paramInt)
  {
    AppMethodBeat.i(38338);
    if (this.mZy == null)
    {
      boolean bool = super.canScrollHorizontally(paramInt);
      AppMethodBeat.o(38338);
      return bool;
    }
    if (this.mZy.getBottom() >= this.mZy.getHeight())
    {
      AppMethodBeat.o(38338);
      return true;
    }
    AppMethodBeat.o(38338);
    return false;
  }
  
  public boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    AppMethodBeat.i(38344);
    if ((getFirstVisiblePosition() == 0) && (paramInt2 < 0) && (paramArrayOfInt1 != null) && (paramArrayOfInt1.length >= 2) && (!this.nad))
    {
      paramArrayOfInt1[1] = ((int)(paramInt2 * 0.32F));
      super.dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2);
      AppMethodBeat.o(38344);
      return true;
    }
    boolean bool = super.dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2);
    AppMethodBeat.o(38344);
    return bool;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(38371);
    if (this.KPV != null) {
      this.KPV.onTouch(this, paramMotionEvent);
    }
    int i;
    boolean bool;
    try
    {
      ae.d("MicroMsg.ConversationListView", "alvinluo dispatchTouchEvent backUpFooterRect: %s, %f, %f, bottom: %d, height: %d, isCanClose: %b", new Object[] { this.mZy.getBackUpFooterRect().toString(), Float.valueOf(paramMotionEvent.getRawX()), Float.valueOf(paramMotionEvent.getRawY()), Integer.valueOf(this.mZy.getBottom()), Integer.valueOf(this.mZy.getHeight()), Boolean.valueOf(this.KPY) });
      int j = (int)(paramMotionEvent.getRawY() - this.mKJ);
      i = j;
      if (this.dAG) {
        i = j - this.KPS + this.mKJ;
      }
      if ((bDr()) && (this.mZy != null))
      {
        if (paramMotionEvent.getAction() == 0) {
          if (!this.mZy.getBackUpFooterRect().contains((int)paramMotionEvent.getRawX(), i)) {
            break label242;
          }
        }
        label242:
        for (this.KPZ = true;; this.KPZ = false)
        {
          ae.d("MicroMsg.ConversationListView", "alvinluo dispatchTouchEvent isDownInCloseRect: %b, touchY: %d", new Object[] { Boolean.valueOf(this.KPZ), Integer.valueOf(i) });
          if (this.KPZ) {
            break;
          }
          bool = this.mZy.dispatchTouchEvent(paramMotionEvent);
          AppMethodBeat.o(38371);
          return bool;
        }
      }
      if (this.mZy == null) {
        break label513;
      }
    }
    catch (Exception paramMotionEvent)
    {
      ae.printErrStackTrace("MicroMsg.ConversationListView", paramMotionEvent, "alvinluo ConversationListView dispatchTouchEvent exception", new Object[0]);
      AppMethodBeat.o(38371);
      return false;
    }
    if ((this.mZy.getBottom() >= this.mZy.getHeight()) && (this.mZy.isFullScreen()) && (getFirstVisiblePosition() == 0))
    {
      if ((paramMotionEvent.getAction() == 0) && (this.mZy.getBackUpFooterRect().contains((int)paramMotionEvent.getRawX(), i))) {
        this.KPY = true;
      }
      while ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
      {
        if (this.KPY)
        {
          this.KPY = false;
          if (this.KPu != null)
          {
            ae.i("MicroMsg.ConversationListView", "alvinluo closeHeader by click BackUpFooterRect");
            this.KPu.wc(12);
          }
          if (paramMotionEvent.getAction() == 1)
          {
            ae.i("MicroMsg.ConversationListView", "alvinluo ConversationListView cancel touch event");
            paramMotionEvent.setAction(3);
            bool = super.dispatchTouchEvent(paramMotionEvent);
            AppMethodBeat.o(38371);
            return bool;
            if (paramMotionEvent.getAction() != 0) {
              continue;
            }
            this.KPY = false;
          }
        }
        else
        {
          bool = super.dispatchTouchEvent(paramMotionEvent);
          AppMethodBeat.o(38371);
          return bool;
        }
        AppMethodBeat.o(38371);
        return true;
      }
      if ((this.KPu != null) && (paramMotionEvent.getAction() == 0)) {
        this.KPu.I(paramMotionEvent);
      }
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(38371);
      return bool;
    }
    label513:
    if ((this.KPY) && (paramMotionEvent.getAction() == 1))
    {
      ae.i("MicroMsg.ConversationListView", "alvinluo ConversationListView cancel touch event..., isHeaderOpen: %b, isHeaderVisible: %b", new Object[] { Boolean.valueOf(bDr()), Boolean.valueOf(fNd()) });
      if (bDr()) {
        break label618;
      }
      this.KPY = false;
    }
    for (;;)
    {
      if ((paramMotionEvent.getAction() == 0) && (this.KPu != null) && (paramMotionEvent.getAction() == 0)) {
        this.KPu.I(paramMotionEvent);
      }
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(38371);
      return bool;
      label618:
      paramMotionEvent.setAction(3);
    }
  }
  
  final void fNa()
  {
    int i = 1;
    AppMethodBeat.i(188053);
    if (this.ahp == null)
    {
      this.ahp = getRootView().findViewById(2131296345);
      if (this.ahp != null) {
        this.ahp.addOnLayoutChangeListener(this.KPU);
      }
    }
    else
    {
      if ((this.dAG) && (Build.VERSION.SDK_INT >= 24) && (LauncherUI.getInstance() != null))
      {
        this.dAG = LauncherUI.getInstance().isInMultiWindowMode();
        ae.i("MicroMsg.ConversationListView", "alvinluo initActionBarView check multiWindowMode %b", new Object[] { Boolean.valueOf(this.dAG) });
      }
      if ((this.mKJ != 0) && ((this.dAG) || (this.ahp.getTop() == this.mKJ) || (this.ahp.getTop() == 0))) {
        break label222;
      }
      this.mKJ = this.ahp.getTop();
    }
    for (;;)
    {
      if ((i != 0) && (!this.dAG))
      {
        post(new Runnable()
        {
          int hiJ = 0;
          
          public final void run()
          {
            AppMethodBeat.i(38330);
            if (ConversationListView.d(ConversationListView.this) == null)
            {
              AppMethodBeat.o(38330);
              return;
            }
            if (ConversationListView.d(ConversationListView.this).getTop() != 0) {
              ConversationListView.a(ConversationListView.this, ConversationListView.d(ConversationListView.this).getTop());
            }
            if (ConversationListView.e(ConversationListView.this) <= 0) {
              if (this.hiJ <= 2)
              {
                ae.i("MicroMsg.ConversationListView", "alvinluo initActionBarView try again tryCount: %d", new Object[] { Integer.valueOf(this.hiJ) });
                ConversationListView.this.post(this);
              }
            }
            for (;;)
            {
              this.hiJ += 1;
              AppMethodBeat.o(38330);
              return;
              ConversationListView.f(ConversationListView.this);
              continue;
              ConversationListView.b(ConversationListView.this, ConversationListView.e(ConversationListView.this));
              ConversationListView.afc(ConversationListView.e(ConversationListView.this));
            }
          }
        });
        AppMethodBeat.o(188053);
        return;
        AppMethodBeat.o(188053);
        return;
      }
      this.KPQ = this.ahp.getTop();
      setListTopMargin(this.KPQ);
      bs(this.KPQ, false);
      AppMethodBeat.o(188053);
      return;
      label222:
      i = 0;
    }
  }
  
  public final void fNb()
  {
    AppMethodBeat.i(38353);
    if (this.KPu != null) {
      this.KPu.b(0L, 0, true);
    }
    fNe();
    AppMethodBeat.o(38353);
  }
  
  final void fNe()
  {
    AppMethodBeat.i(38381);
    if (this.ahp != null)
    {
      this.ahp.setTranslationY(0.0F);
      this.ahp.setVisibility(0);
    }
    fNf();
    AppMethodBeat.o(38381);
  }
  
  public int getFirstHeaderVisible()
  {
    AppMethodBeat.i(38367);
    Iterator localIterator = this.KPt.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject = (ListView.FixedViewInfo)localIterator.next();
      if (((ListView.FixedViewInfo)localObject).view == this.mZy)
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
            ae.i("MicroMsg.ConversationListView", "[getFirstHeaderVisible] index:%s", new Object[] { Integer.valueOf(i) });
            AppMethodBeat.o(38367);
            return i;
          }
        }
        i += 1;
      }
    }
    ae.i("MicroMsg.ConversationListView", "[getFirstHeaderVisible] index:%s", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(38367);
    return i;
  }
  
  final void kc(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(38352);
    if (this.mZF != null)
    {
      this.mZF.a(1.0F, paramInt1, 0);
      this.mZF.b(1.0F, paramInt2, paramInt2);
    }
    AppMethodBeat.o(38352);
  }
  
  public final void m(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(38366);
    ae.i("MicroMsg.ConversationListView", "[showAppBrandHeader] isShow:" + paramBoolean1 + " isAnim:" + paramBoolean2 + " isScrollFirst:" + paramBoolean3);
    if (paramBoolean1)
    {
      if (this.KPu != null)
      {
        this.KPu.bDl();
        AppMethodBeat.o(38366);
      }
    }
    else if (this.KPu != null) {
      this.KPu.wc(0);
    }
    AppMethodBeat.o(38366);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(38375);
    super.onAttachedToWindow();
    if (this.KPT != null) {
      this.KPT.alive();
    }
    AppMethodBeat.o(38375);
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(38374);
    super.onConfigurationChanged(paramConfiguration);
    ae.i("MicroMsg.ConversationListView", "[onConfigurationChanged] orientation:%s, last: %d", new Object[] { Integer.valueOf(paramConfiguration.orientation), Integer.valueOf(this.gQT) });
    yF(true);
    if (this.KPu != null) {
      this.KPu.iv();
    }
    if (this.mZy != null) {
      this.mZy.e(paramConfiguration);
    }
    if (al.isDarkMode()) {
      kc(getResources().getColor(2131100196), getResources().getColor(2131099886));
    }
    for (;;)
    {
      if (this.KPO != null) {
        removeCallbacks(this.KPO);
      }
      paramConfiguration = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(38326);
          ConversationListView.this.setSelection(1);
          ConversationListView.k(ConversationListView.this);
          AppMethodBeat.o(38326);
        }
      };
      this.KPO = paramConfiguration;
      postDelayed(paramConfiguration, 800L);
      this.nad = false;
      AppMethodBeat.o(38374);
      return;
      kc(getResources().getColor(2131100705), getResources().getColor(2131099885));
    }
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(38376);
    super.onDetachedFromWindow();
    if (this.KPT != null) {
      this.KPT.dead();
    }
    AppMethodBeat.o(38376);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(38347);
    super.onDraw(paramCanvas);
    if ((this.mZy != null) && (getFirstVisiblePosition() == 0) && (this.mZy.isFullScreen()) && (this.mZy.getBottom() > 6))
    {
      if (this.KPx < 30)
      {
        AppMethodBeat.o(38347);
        return;
      }
      this.mPaint.setStyle(Paint.Style.FILL);
      this.mPaint.setColor(getContext().getResources().getColor(2131099930));
      this.mPaint.setAlpha(this.KPx);
      paramCanvas.drawRect(this.mZy.getBackUpFooterRect().left, this.mZy.getBackUpFooterRect().top + this.KPR, this.mZy.getBackUpFooterRect().right, this.mZy.getBackUpFooterRect().bottom, this.mPaint);
    }
    AppMethodBeat.o(38347);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(38350);
    try
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      boolean bool = bDr();
      ae.i("MicroMsg.ConversationListView", "[onLayout] changed:%s, isHeaderOpen: %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) });
      ae.d("MicroMsg.ConversationListView", "[onLayout] top: %d, bottom: %d, height: %d, count: %d, realCount: %d, hashCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt4), Integer.valueOf(paramInt4 - paramInt2), Integer.valueOf(this.mCount), Integer.valueOf(getRealCount()), Integer.valueOf(hashCode()) });
      if ((paramBoolean) && (!bool))
      {
        setSelection(1);
        post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(38331);
            ConversationListView.this.setSelection(1);
            AppMethodBeat.o(38331);
          }
        });
      }
      if ((paramBoolean) || ((this.mCount < 16) && (getRealCount() != this.mCount))) {
        yF(false);
      }
      if ((this.KPP != null) && (this.KPP.getVisibility() == 0) && (getFirstVisiblePosition() != 0)) {
        this.KPP.setVisibility(4);
      }
      this.mCount = getRealCount();
      AppMethodBeat.o(38350);
      return;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.ConversationListView", localException, "alvinluo onLayout exception", new Object[0]);
      AppMethodBeat.o(38350);
    }
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(38349);
    Object localObject;
    int i;
    if ((paramInt1 == 0) && (this.nap))
    {
      localObject = getChildAt(1);
      if (localObject == null) {
        if (bDr())
        {
          i = this.mZy.getMeasuredHeight() - this.mZE;
          ae.i("MicroMsg.ConversationListView", "alvinluo computeActionBarTranslation %d", new Object[] { Integer.valueOf(i) });
          label71:
          i = Math.max(0, i);
          if (this.ahp != null)
          {
            if (Math.abs(i) > this.KPW) {
              break label444;
            }
            this.ahp.setVisibility(0);
            label106:
            ae.v("MicroMsg.ConversationListView", "alvinluo onScroll setTranslationY before: %f, trans: %d", new Object[] { Float.valueOf(this.ahp.getTranslationY()), Integer.valueOf(i) });
            this.ahp.setTranslationY(i);
          }
          if (this.mZy != null)
          {
            localObject = this.mZy;
            this.mZy.getHeight();
            ((HeaderContainer)localObject).es(i, this.mZy.getHeight() - this.mZE);
          }
        }
      }
    }
    for (;;)
    {
      if (this.vwl != null) {
        this.vwl.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
      }
      if (this.KPu != null) {
        this.KPu.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
      }
      if ((paramInt2 > 1) && (fNd()) && (this.mZy != null))
      {
        paramAbsListView = new int[2];
        getLocationOnScreen(paramAbsListView);
        this.KPS = paramAbsListView[1];
        paramInt1 = this.mZy.getBottom() - com.tencent.mm.cb.a.fromDPToPix(getContext(), 56);
        this.mZy.getBackUpFooterRect().set(0, paramInt1, getWidth(), getHeight() + paramInt1);
        ae.d("MicroMsg.ConversationListView", "alvinluo onScroll BackUpFooterRect: %s, headerContainer top: %d, bottom: %d", new Object[] { this.mZy.getBackUpFooterRect().toString(), Integer.valueOf(this.mZy.getTop()), Integer.valueOf(this.mZy.getBottom()) });
        this.KPx = ((int)(255.0F * this.mZy.getBottom() / this.mZy.getHeight()));
      }
      AppMethodBeat.o(38349);
      return;
      i = 0;
      break;
      i = ((View)localObject).getTop();
      int j = Math.max(paramInt1 - getHeaderViewsCount(), 0);
      i = -(-i + (int)(j * getResources().getDimension(2131165515)) + this.mZE);
      break label71;
      label444:
      this.ahp.setVisibility(4);
      break label106;
      if (paramInt1 > 0) {
        fNe();
      }
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(38348);
    if (this.vwl != null) {
      this.vwl.onScrollStateChanged(paramAbsListView, paramInt);
    }
    if (this.KPu != null) {
      this.KPu.onScrollStateChanged(paramAbsListView, paramInt);
    }
    this.mScrollState = paramInt;
    AppMethodBeat.o(38348);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(38345);
    b localb = new b();
    localb.bd(paramView);
    localb.bd(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/ConversationListView", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
    boolean bool2 = this.KPu.onTouch(paramView, paramMotionEvent);
    boolean bool1 = bool2;
    if (this.CBc != null) {
      bool1 = bool2 | this.CBc.onTouch(paramView, paramMotionEvent);
    }
    com.tencent.mm.hellhoundlib.a.a.a(bool1, this, "com/tencent/mm/ui/conversation/ConversationListView", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(38345);
    return bool1;
  }
  
  public void setActionBarUpdateCallback(final com.tencent.mm.plugin.appbrand.widget.header.a parama)
  {
    AppMethodBeat.i(38377);
    if (this.KPu != null)
    {
      this.mZF = parama;
      this.KPu.setActionBarUpdateCallback(new com.tencent.mm.plugin.appbrand.widget.header.a()
      {
        public final void a(float paramAnonymousFloat, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(188047);
          if (parama != null) {
            parama.a(paramAnonymousFloat, paramAnonymousInt1, paramAnonymousInt2);
          }
          AppMethodBeat.o(188047);
        }
        
        public final void b(float paramAnonymousFloat, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(188048);
          if (parama != null) {
            parama.b(paramAnonymousFloat, paramAnonymousInt1, paramAnonymousInt2);
          }
          AppMethodBeat.o(188048);
        }
      });
    }
    AppMethodBeat.o(38377);
  }
  
  public void setActivity(MMFragmentActivity paramMMFragmentActivity)
  {
    AppMethodBeat.i(38378);
    this.nbm = paramMMFragmentActivity;
    if (this.mZy != null) {
      this.mZy.setActivity(this.nbm);
    }
    AppMethodBeat.o(38378);
  }
  
  public void setIsCurrentMainUI(boolean paramBoolean)
  {
    AppMethodBeat.i(38380);
    ae.i("MicroMsg.ConversationListView", "alvinluo setIsCurrentMainUI: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.nap = paramBoolean;
    if (this.KPu != null) {
      this.KPu.setIsCurrentMainUI(paramBoolean);
    }
    AppMethodBeat.o(38380);
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    AppMethodBeat.i(38373);
    this.awt = paramOnItemClickListener;
    super.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(188052);
        ae.i("MicroMsg.ConversationListView", "alvinluo onItemClick isCanClose: %b", new Object[] { Boolean.valueOf(ConversationListView.h(ConversationListView.this)) });
        if ((ConversationListView.j(ConversationListView.this) != null) && (!ConversationListView.h(ConversationListView.this))) {
          ConversationListView.j(ConversationListView.this).onItemClick(paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        }
        AppMethodBeat.o(188052);
      }
    });
    AppMethodBeat.o(38373);
  }
  
  public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener paramOnItemLongClickListener)
  {
    AppMethodBeat.i(38372);
    this.JOO = paramOnItemLongClickListener;
    super.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(188051);
        ae.i("MicroMsg.ConversationListView", "alvinluo onItemLongClick isCanClose: %b", new Object[] { Boolean.valueOf(ConversationListView.h(ConversationListView.this)) });
        if ((ConversationListView.i(ConversationListView.this) != null) && (!ConversationListView.h(ConversationListView.this)))
        {
          boolean bool = ConversationListView.i(ConversationListView.this).onItemLongClick(paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
          AppMethodBeat.o(188051);
          return bool;
        }
        AppMethodBeat.o(188051);
        return false;
      }
    });
    AppMethodBeat.o(38372);
  }
  
  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.vwl = paramOnScrollListener;
  }
  
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    this.CBc = paramOnTouchListener;
  }
  
  public void setSelection(int paramInt)
  {
    AppMethodBeat.i(38362);
    ae.i("MicroMsg.ConversationListView", "[setSelection] position:%s, scrollOffset: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.mZE) });
    if (paramInt == 0)
    {
      super.setSelectionFromTop(getFirstHeaderVisible(), this.mZE);
      AppMethodBeat.o(38362);
      return;
    }
    super.setSelectionFromTop(paramInt, this.mZE);
    AppMethodBeat.o(38362);
  }
  
  public void setStatusBarMaskView(View paramView)
  {
    AppMethodBeat.i(38379);
    this.mZH = paramView;
    if (this.KPu != null) {
      this.KPu.setStatusBarMaskView(paramView);
    }
    AppMethodBeat.o(38379);
  }
  
  public void setonDispatchTouchEventListener(View.OnTouchListener paramOnTouchListener)
  {
    this.KPV = paramOnTouchListener;
  }
  
  public void smoothScrollToPosition(int paramInt)
  {
    AppMethodBeat.i(38363);
    ae.i("MicroMsg.ConversationListView", "[smoothScrollToPosition] position:%s", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 0)
    {
      super.smoothScrollToPositionFromTop(getFirstHeaderVisible(), this.mZE);
      AppMethodBeat.o(38363);
      return;
    }
    super.smoothScrollToPositionFromTop(paramInt, this.mZE);
    AppMethodBeat.o(38363);
  }
  
  public void smoothScrollToPositionFromTop(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(38364);
    ae.i("MicroMsg.ConversationListView", "[smoothScrollToPositionFromTop] position:%s offset:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == 0)
    {
      super.smoothScrollToPositionFromTop(getFirstHeaderVisible(), this.mZE + paramInt2);
      AppMethodBeat.o(38364);
      return;
    }
    super.smoothScrollToPositionFromTop(paramInt1, this.mZE + paramInt2);
    AppMethodBeat.o(38364);
  }
  
  public void smoothScrollToPositionFromTop(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(38365);
    ae.i("MicroMsg.ConversationListView", "[smoothScrollToPositionFromTop] position:%s offset:%s duration:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramInt1 == 0)
    {
      super.smoothScrollToPositionFromTop(getFirstHeaderVisible(), this.mZE + paramInt2, paramInt3);
      AppMethodBeat.o(38365);
      return;
    }
    super.smoothScrollToPositionFromTop(paramInt1, this.mZE + paramInt2, paramInt3);
    AppMethodBeat.o(38365);
  }
  
  public final void uT(int paramInt) {}
  
  public final void wh(int paramInt)
  {
    AppMethodBeat.i(38355);
    ae.d("MicroMsg.ConversationListView", "[onCloseHeader]");
    this.KPY = false;
    this.nad = false;
    this.KPx = 0;
    if (this.KPM != null) {
      removeCallbacks(this.KPM);
    }
    AppMethodBeat.o(38355);
  }
  
  public final void wi(int paramInt)
  {
    AppMethodBeat.i(38356);
    wh(paramInt);
    AppMethodBeat.o(38356);
  }
  
  final void yF(boolean paramBoolean)
  {
    AppMethodBeat.i(38358);
    if (this.KPX == null)
    {
      AppMethodBeat.o(38358);
      return;
    }
    if (paramBoolean)
    {
      postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(188050);
          ConversationListView.g(ConversationListView.this);
          AppMethodBeat.o(188050);
        }
      }, 0L);
      AppMethodBeat.o(38358);
      return;
    }
    fNc();
    AppMethodBeat.o(38358);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.ConversationListView
 * JD-Core Version:    0.7.0.1
 */
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
import com.tencent.mm.g.a.lu;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.widget.header.HeaderContainer;
import com.tencent.mm.plugin.appbrand.widget.header.c.a;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.e;
import com.tencent.mm.plugin.appbrand.widget.recentview.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.aj;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ap;
import java.util.Iterator;
import java.util.LinkedList;

public class ConversationListView
  extends ListView
  implements View.OnTouchListener, AbsListView.OnScrollListener, c.a, AppBrandRecentView.e
{
  private View.OnTouchListener AKw;
  private AdapterView.OnItemLongClickListener HGi;
  private LinkedList<ListView.FixedViewInfo> IBT;
  com.tencent.mm.plugin.appbrand.widget.header.c IBU;
  private String IBV;
  private float IBW;
  private int IBX;
  private Bitmap IBY;
  private RectF IBZ;
  private boolean ICa;
  private NinePatchDrawable ICb;
  private Rect ICc;
  private final float ICd;
  private final float ICe;
  private final float ICf;
  private final float ICg;
  private final float ICh;
  private boolean ICi;
  private final float ICj;
  private int ICk;
  private boolean ICl;
  Runnable ICm;
  Runnable ICn;
  Runnable ICo;
  View ICp;
  private int ICq;
  private int ICr;
  private int ICs;
  com.tencent.mm.sdk.b.c<lu> ICt;
  private View.OnLayoutChangeListener ICu;
  private View.OnTouchListener ICv;
  private int ICw;
  View ICx;
  private boolean ICy;
  private boolean ICz;
  private int afO;
  private View afy;
  private AdapterView.OnItemClickListener auB;
  boolean dnN;
  private int guA;
  private int mCount;
  private Paint mPaint;
  private int mScrollState;
  private int mfe;
  HeaderContainer mtL;
  private int mtR;
  private com.tencent.mm.plugin.appbrand.widget.header.a mtS;
  private View mtU;
  private boolean muC;
  boolean muq;
  private MMFragmentActivity mvz;
  private AbsListView.OnScrollListener uhw;
  
  public ConversationListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(38336);
    this.IBT = new LinkedList();
    this.mPaint = new Paint(1);
    this.IBY = null;
    this.IBZ = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
    this.ICa = false;
    this.ICb = null;
    this.ICc = new Rect();
    this.ICd = com.tencent.mm.cc.a.fromDPToPix(getContext(), 30);
    this.ICe = com.tencent.mm.cc.a.fromDPToPix(getContext(), 8);
    this.ICf = com.tencent.mm.cc.a.fromDPToPix(getContext(), 24);
    this.ICg = com.tencent.mm.cc.a.fromDPToPix(getContext(), 64);
    this.ICh = 0.5F;
    this.ICi = false;
    this.ICj = com.tencent.mm.cc.a.fromDPToPix(getContext(), 200);
    this.ICk = 0;
    this.muq = false;
    this.ICl = false;
    this.mtS = null;
    this.ICm = null;
    this.ICn = null;
    this.ICo = null;
    this.mfe = 0;
    this.ICq = 0;
    this.guA = 0;
    this.ICr = com.tencent.mm.cc.a.fromDPToPix(getContext(), 56);
    this.muC = true;
    this.ICs = 0;
    this.dnN = false;
    this.ICt = new com.tencent.mm.sdk.b.c() {};
    this.ICu = new View.OnLayoutChangeListener()
    {
      public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
      {
        AppMethodBeat.i(196803);
        ac.i("MicroMsg.ConversationListView", "ActionBarView layout changed, call setupActionBarView()");
        ConversationListView.b(ConversationListView.this);
        AppMethodBeat.o(196803);
      }
    };
    this.ICv = null;
    this.ICw = 0;
    this.ICz = false;
    init(paramContext);
    AppMethodBeat.o(38336);
  }
  
  public ConversationListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(38337);
    this.IBT = new LinkedList();
    this.mPaint = new Paint(1);
    this.IBY = null;
    this.IBZ = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
    this.ICa = false;
    this.ICb = null;
    this.ICc = new Rect();
    this.ICd = com.tencent.mm.cc.a.fromDPToPix(getContext(), 30);
    this.ICe = com.tencent.mm.cc.a.fromDPToPix(getContext(), 8);
    this.ICf = com.tencent.mm.cc.a.fromDPToPix(getContext(), 24);
    this.ICg = com.tencent.mm.cc.a.fromDPToPix(getContext(), 64);
    this.ICh = 0.5F;
    this.ICi = false;
    this.ICj = com.tencent.mm.cc.a.fromDPToPix(getContext(), 200);
    this.ICk = 0;
    this.muq = false;
    this.ICl = false;
    this.mtS = null;
    this.ICm = null;
    this.ICn = null;
    this.ICo = null;
    this.mfe = 0;
    this.ICq = 0;
    this.guA = 0;
    this.ICr = com.tencent.mm.cc.a.fromDPToPix(getContext(), 56);
    this.muC = true;
    this.ICs = 0;
    this.dnN = false;
    this.ICt = new com.tencent.mm.sdk.b.c() {};
    this.ICu = new View.OnLayoutChangeListener()
    {
      public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
      {
        AppMethodBeat.i(196803);
        ac.i("MicroMsg.ConversationListView", "ActionBarView layout changed, call setupActionBarView()");
        ConversationListView.b(ConversationListView.this);
        AppMethodBeat.o(196803);
      }
    };
    this.ICv = null;
    this.ICw = 0;
    this.ICz = false;
    init(paramContext);
    AppMethodBeat.o(38337);
  }
  
  private float abV(int paramInt)
  {
    AppMethodBeat.i(38361);
    int i = (int)getResources().getDimension(2131165515);
    int j = getHeaderViewsCount();
    int k = getFooterViewsCount();
    float f = getMeasuredHeight() - i * (paramInt - j - k) - ap.dT(getContext());
    ac.d("MicroMsg.ConversationListView", "alvinluo isFullScreen getMeasuredHeight: %d", new Object[] { Integer.valueOf(getMeasuredHeight()) });
    ac.i("MicroMsg.ConversationListView", "[isFullScreen] totalItemCount:" + paramInt + " getFirstVisiblePosition:" + getFirstVisiblePosition() + " getLastVisiblePosition:" + getLastVisiblePosition() + " getHeaderViewsCount:" + getHeaderViewsCount() + " getFooterViewsCount:" + getFooterViewsCount() + " extraHeight:" + f);
    AppMethodBeat.o(38361);
    return f;
  }
  
  private static void bc(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(38343);
    ac.i("MicroMsg.ConversationListView", "alvinluo saveTopMargin topMargin: %d, needRead: %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    Object localObject = ai.eUY();
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      if (localObject != null)
      {
        ((SharedPreferences.Editor)localObject).putBoolean("Main_need_read_top_margin", paramBoolean);
        ((SharedPreferences.Editor)localObject).putInt("Main_top_marign", paramInt);
        ((SharedPreferences.Editor)localObject).apply();
        ac.i("MicroMsg.ConversationListView", "alvinluo saveTopMargin success");
      }
    }
    AppMethodBeat.o(38343);
  }
  
  private void frS()
  {
    AppMethodBeat.i(38340);
    if ((Build.VERSION.SDK_INT >= 24) && (LauncherUI.getInstance() != null))
    {
      this.dnN = LauncherUI.getInstance().isInMultiWindowMode();
      if (this.mtL != null) {
        this.mtL.hS(this.dnN);
      }
    }
    AppMethodBeat.o(38340);
  }
  
  private void frV()
  {
    AppMethodBeat.i(38359);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.ICx.getLayoutParams();
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
      f2 = abV(i);
      if (f2 >= 0.0F) {
        break label311;
      }
      bool = true;
      k = localLayoutParams.height;
      ac.i("MicroMsg.ConversationListView", "[checkEmptyFooter] isRealFull:" + bool + " old height:" + k);
      View localView = getRootView().findViewById(2131301338);
      if (localView != null) {
        ac.i("MicroMsg.ConversationListView", "alvinluo checkEmptyFooter tabView Height: %d", new Object[] { Integer.valueOf(localView.getHeight()) });
      }
      m = (int)getResources().getDimension(2131165515);
      if (localView == null) {
        break label317;
      }
      i = localView.getHeight();
      j = i;
      if (i <= 0) {
        j = this.ICk;
      }
      ac.d("MicroMsg.ConversationListView", "alvinluo checkEmptyFooter tabHeight: %d", new Object[] { Integer.valueOf(j) });
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
        ac.i("MicroMsg.ConversationListView", "alvinluo checkEmptyFooter isHeaderOpen: %b", new Object[] { Boolean.valueOf(byu()) });
        if (((!bool) || (Math.abs(f1) <= j + m)) && (!byu()))
        {
          ac.i("MicroMsg.ConversationListView", "[checkEmptyFooter] setSelection");
          setSelection(1);
          if (this.IBU != null) {
            this.IBU.hQ(true);
          }
        }
        this.ICx.requestLayout();
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
  
  private boolean frW()
  {
    AppMethodBeat.i(38370);
    if (this.mtL == null)
    {
      AppMethodBeat.o(38370);
      return false;
    }
    if ((this.mtL.getBottom() >= this.afO + 3) && (getFirstVisiblePosition() == 0))
    {
      AppMethodBeat.o(38370);
      return true;
    }
    AppMethodBeat.o(38370);
    return false;
  }
  
  private void frY()
  {
    AppMethodBeat.i(38382);
    if (this.mtS != null)
    {
      if (aj.DT())
      {
        i = getResources().getColor(2131099886);
        this.mtS.b(0.0F, i, i);
        this.mtS.a(0.0F, getResources().getColor(2131100196), 0);
        AppMethodBeat.o(38382);
        return;
      }
      int i = getResources().getColor(2131099885);
      this.mtS.b(0.0F, i, i);
      this.mtS.a(0.0F, getResources().getColor(2131100705), 0);
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
        break label121;
      }
      i = j;
    }
    label121:
    for (;;)
    {
      localObject = new LinearLayout(getContext());
      this.ICx = new View(getContext());
      this.ICx.setLayoutParams(new LinearLayout.LayoutParams(-1, i));
      ((LinearLayout)localObject).addView(this.ICx);
      ((LinearLayout)localObject).setBackgroundColor(ao.aJ(getContext(), 2130968579));
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
    this.mPaint.setTextSize(com.tencent.mm.cc.a.av(getContext(), 2131165498));
    this.IBV = getResources().getString(2131757429);
    this.IBW = this.mPaint.measureText(this.IBV);
    super.setOnScrollListener(this);
    super.setOnTouchListener(this);
    setOverScrollMode(2);
    ac.i("MicroMsg.ConversationListView", "alvinluo HeaderContainer new, ConversationListView: %d", new Object[] { Integer.valueOf(hashCode()) });
    this.mtL = ((d)g.ab(d.class)).dU(paramContext);
    if (this.mtL != null)
    {
      this.mtL.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
      addHeaderView(this.mtL);
      addFooterView(getEmptyFooter());
      this.IBU = ((d)g.ab(d.class)).a(paramContext, this, this.mtL);
      this.IBU.a(this);
      this.mtL.setAnimController(this.IBU);
    }
    this.ICk = ((int)(com.tencent.mm.cc.a.av(getContext(), 2131165256) * com.tencent.mm.cc.a.ib(getContext())));
    this.mtR = ap.dT(getContext());
    this.ICw = com.tencent.mm.cc.a.fromDPToPix(paramContext, 100);
    frS();
    AppMethodBeat.o(38339);
  }
  
  private void setListTopMargin(int paramInt)
  {
    AppMethodBeat.i(38342);
    ac.i("MicroMsg.ConversationListView", "alvinluo initActionBarView statusBarHeight: %d, isInMultiWindowMode: %b, target: %d, actionBarTop: %d", new Object[] { Integer.valueOf(this.mfe), Boolean.valueOf(this.dnN), Integer.valueOf(paramInt), Integer.valueOf(this.afy.getTop()) });
    if (paramInt >= 0)
    {
      if (this.mtU != null) {
        if (this.dnN) {
          break label128;
        }
      }
      ViewGroup.LayoutParams localLayoutParams;
      label128:
      for (this.mtU.getLayoutParams().height = this.mfe;; this.mtU.getLayoutParams().height = paramInt)
      {
        localLayoutParams = getLayoutParams();
        if (!(localLayoutParams instanceof RelativeLayout.LayoutParams)) {
          break label150;
        }
        if (this.dnN) {
          break;
        }
        ((RelativeLayout.LayoutParams)localLayoutParams).topMargin = this.mfe;
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
    this.IBT.add(localFixedViewInfo);
    AppMethodBeat.o(38368);
  }
  
  protected void attachViewToParent(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(38346);
    super.attachViewToParent(paramView, paramInt, paramLayoutParams);
    if ((this.afO <= 0) && (this.IBU != null))
    {
      this.afO = (ap.dT(getContext()) + aj.jx(getContext()));
      this.mtR = ap.dT(getContext());
      frT();
      if (this.mtL != null) {
        this.mtL.setActionBar(this.afy);
      }
      this.IBU.setActionBar(this.afy);
      this.IBU.setTabView(getRootView().findViewById(2131301338));
    }
    AppMethodBeat.o(38346);
  }
  
  public final void byW()
  {
    AppMethodBeat.i(38354);
    ac.d("MicroMsg.ConversationListView", "[onOpenHeader]");
    this.muq = true;
    if (this.ICm != null) {
      removeCallbacks(this.ICm);
    }
    AppMethodBeat.o(38354);
  }
  
  public final void byX()
  {
    AppMethodBeat.i(38357);
    byW();
    AppMethodBeat.o(38357);
  }
  
  public final boolean byu()
  {
    AppMethodBeat.i(38369);
    if ((frW()) && (this.muq))
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
    if (this.mtL == null)
    {
      boolean bool = super.canScrollHorizontally(paramInt);
      AppMethodBeat.o(38338);
      return bool;
    }
    if (this.mtL.getBottom() >= this.mtL.getHeight())
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
    if ((getFirstVisiblePosition() == 0) && (paramInt2 < 0) && (paramArrayOfInt1 != null) && (paramArrayOfInt1.length >= 2) && (!this.muq))
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
    if (this.ICv != null) {
      this.ICv.onTouch(this, paramMotionEvent);
    }
    int i;
    boolean bool;
    try
    {
      ac.d("MicroMsg.ConversationListView", "alvinluo dispatchTouchEvent backUpFooterRect: %s, %f, %f, bottom: %d, height: %d, isCanClose: %b", new Object[] { this.mtL.getBackUpFooterRect().toString(), Float.valueOf(paramMotionEvent.getRawX()), Float.valueOf(paramMotionEvent.getRawY()), Integer.valueOf(this.mtL.getBottom()), Integer.valueOf(this.mtL.getHeight()), Boolean.valueOf(this.ICy) });
      int j = (int)(paramMotionEvent.getRawY() - this.mfe);
      i = j;
      if (this.dnN) {
        i = j - this.ICs + this.mfe;
      }
      if ((byu()) && (this.mtL != null))
      {
        if (paramMotionEvent.getAction() == 0) {
          if (!this.mtL.getBackUpFooterRect().contains((int)paramMotionEvent.getRawX(), i)) {
            break label242;
          }
        }
        label242:
        for (this.ICz = true;; this.ICz = false)
        {
          ac.d("MicroMsg.ConversationListView", "alvinluo dispatchTouchEvent isDownInCloseRect: %b, touchY: %d", new Object[] { Boolean.valueOf(this.ICz), Integer.valueOf(i) });
          if (this.ICz) {
            break;
          }
          bool = this.mtL.dispatchTouchEvent(paramMotionEvent);
          AppMethodBeat.o(38371);
          return bool;
        }
      }
      if (this.mtL == null) {
        break label513;
      }
    }
    catch (Exception paramMotionEvent)
    {
      ac.printErrStackTrace("MicroMsg.ConversationListView", paramMotionEvent, "alvinluo ConversationListView dispatchTouchEvent exception", new Object[0]);
      AppMethodBeat.o(38371);
      return false;
    }
    if ((this.mtL.getBottom() >= this.mtL.getHeight()) && (this.mtL.isFullScreen()) && (getFirstVisiblePosition() == 0))
    {
      if ((paramMotionEvent.getAction() == 0) && (this.mtL.getBackUpFooterRect().contains((int)paramMotionEvent.getRawX(), i))) {
        this.ICy = true;
      }
      while ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
      {
        if (this.ICy)
        {
          this.ICy = false;
          if (this.IBU != null)
          {
            ac.i("MicroMsg.ConversationListView", "alvinluo closeHeader by click BackUpFooterRect");
            this.IBU.vr(12);
          }
          if (paramMotionEvent.getAction() == 1)
          {
            ac.i("MicroMsg.ConversationListView", "alvinluo ConversationListView cancel touch event");
            paramMotionEvent.setAction(3);
            bool = super.dispatchTouchEvent(paramMotionEvent);
            AppMethodBeat.o(38371);
            return bool;
            if (paramMotionEvent.getAction() != 0) {
              continue;
            }
            this.ICy = false;
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
      if ((this.IBU != null) && (paramMotionEvent.getAction() == 0)) {
        this.IBU.M(paramMotionEvent);
      }
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(38371);
      return bool;
    }
    label513:
    if ((this.ICy) && (paramMotionEvent.getAction() == 1))
    {
      ac.i("MicroMsg.ConversationListView", "alvinluo ConversationListView cancel touch event..., isHeaderOpen: %b, isHeaderVisible: %b", new Object[] { Boolean.valueOf(byu()), Boolean.valueOf(frW()) });
      if (byu()) {
        break label618;
      }
      this.ICy = false;
    }
    for (;;)
    {
      if ((paramMotionEvent.getAction() == 0) && (this.IBU != null) && (paramMotionEvent.getAction() == 0)) {
        this.IBU.M(paramMotionEvent);
      }
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(38371);
      return bool;
      label618:
      paramMotionEvent.setAction(3);
    }
  }
  
  final void frT()
  {
    int i = 1;
    AppMethodBeat.i(196807);
    if (this.afy == null)
    {
      this.afy = getRootView().findViewById(2131296345);
      if (this.afy != null) {
        this.afy.addOnLayoutChangeListener(this.ICu);
      }
    }
    else
    {
      if ((this.dnN) && (Build.VERSION.SDK_INT >= 24) && (LauncherUI.getInstance() != null))
      {
        this.dnN = LauncherUI.getInstance().isInMultiWindowMode();
        ac.i("MicroMsg.ConversationListView", "alvinluo initActionBarView check multiWindowMode %b", new Object[] { Boolean.valueOf(this.dnN) });
      }
      if ((this.mfe != 0) && ((this.dnN) || (this.afy.getTop() == this.mfe) || (this.afy.getTop() == 0))) {
        break label222;
      }
      this.mfe = this.afy.getTop();
    }
    for (;;)
    {
      if ((i != 0) && (!this.dnN))
      {
        post(new Runnable()
        {
          int gLY = 0;
          
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
              if (this.gLY <= 2)
              {
                ac.i("MicroMsg.ConversationListView", "alvinluo initActionBarView try again tryCount: %d", new Object[] { Integer.valueOf(this.gLY) });
                ConversationListView.this.post(this);
              }
            }
            for (;;)
            {
              this.gLY += 1;
              AppMethodBeat.o(38330);
              return;
              ConversationListView.f(ConversationListView.this);
              continue;
              ConversationListView.b(ConversationListView.this, ConversationListView.e(ConversationListView.this));
              ConversationListView.abW(ConversationListView.e(ConversationListView.this));
            }
          }
        });
        AppMethodBeat.o(196807);
        return;
        AppMethodBeat.o(196807);
        return;
      }
      this.ICq = this.afy.getTop();
      setListTopMargin(this.ICq);
      bc(this.ICq, false);
      AppMethodBeat.o(196807);
      return;
      label222:
      i = 0;
    }
  }
  
  public final void frU()
  {
    AppMethodBeat.i(38353);
    if (this.IBU != null) {
      this.IBU.b(0L, 0, true);
    }
    frX();
    AppMethodBeat.o(38353);
  }
  
  final void frX()
  {
    AppMethodBeat.i(38381);
    if (this.afy != null)
    {
      this.afy.setTranslationY(0.0F);
      this.afy.setVisibility(0);
    }
    frY();
    AppMethodBeat.o(38381);
  }
  
  public int getFirstHeaderVisible()
  {
    AppMethodBeat.i(38367);
    Iterator localIterator = this.IBT.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject = (ListView.FixedViewInfo)localIterator.next();
      if (((ListView.FixedViewInfo)localObject).view == this.mtL)
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
            ac.i("MicroMsg.ConversationListView", "[getFirstHeaderVisible] index:%s", new Object[] { Integer.valueOf(i) });
            AppMethodBeat.o(38367);
            return i;
          }
        }
        i += 1;
      }
    }
    ac.i("MicroMsg.ConversationListView", "[getFirstHeaderVisible] index:%s", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(38367);
    return i;
  }
  
  public final void j(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(38366);
    ac.i("MicroMsg.ConversationListView", "[showAppBrandHeader] isShow:" + paramBoolean1 + " isAnim:" + paramBoolean2 + " isScrollFirst:" + paramBoolean3);
    if (paramBoolean1)
    {
      if (this.IBU != null)
      {
        this.IBU.byo();
        AppMethodBeat.o(38366);
      }
    }
    else if (this.IBU != null) {
      this.IBU.vr(0);
    }
    AppMethodBeat.o(38366);
  }
  
  final void jJ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(38352);
    if (this.mtS != null)
    {
      this.mtS.a(1.0F, paramInt1, 0);
      this.mtS.b(1.0F, paramInt2, paramInt2);
    }
    AppMethodBeat.o(38352);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(38375);
    super.onAttachedToWindow();
    if (this.ICt != null) {
      this.ICt.alive();
    }
    AppMethodBeat.o(38375);
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(38374);
    super.onConfigurationChanged(paramConfiguration);
    ac.i("MicroMsg.ConversationListView", "[onConfigurationChanged] orientation:%s, last: %d", new Object[] { Integer.valueOf(paramConfiguration.orientation), Integer.valueOf(this.guA) });
    xE(true);
    if (this.IBU != null) {
      this.IBU.ie();
    }
    if (this.mtL != null) {
      this.mtL.e(paramConfiguration);
    }
    if (aj.DT()) {
      jJ(getResources().getColor(2131100196), getResources().getColor(2131099886));
    }
    for (;;)
    {
      if (this.ICo != null) {
        removeCallbacks(this.ICo);
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
      this.ICo = paramConfiguration;
      postDelayed(paramConfiguration, 800L);
      this.muq = false;
      AppMethodBeat.o(38374);
      return;
      jJ(getResources().getColor(2131100705), getResources().getColor(2131099885));
    }
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(38376);
    super.onDetachedFromWindow();
    if (this.ICt != null) {
      this.ICt.dead();
    }
    AppMethodBeat.o(38376);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(38347);
    super.onDraw(paramCanvas);
    if ((this.mtL != null) && (getFirstVisiblePosition() == 0) && (this.mtL.isFullScreen()) && (this.mtL.getBottom() > 6))
    {
      if (this.IBX < 30)
      {
        AppMethodBeat.o(38347);
        return;
      }
      this.mPaint.setStyle(Paint.Style.FILL);
      this.mPaint.setColor(getContext().getResources().getColor(2131099930));
      this.mPaint.setAlpha(this.IBX);
      paramCanvas.drawRect(this.mtL.getBackUpFooterRect().left, this.mtL.getBackUpFooterRect().top + this.ICr, this.mtL.getBackUpFooterRect().right, this.mtL.getBackUpFooterRect().bottom, this.mPaint);
    }
    AppMethodBeat.o(38347);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(38350);
    try
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      boolean bool = byu();
      ac.i("MicroMsg.ConversationListView", "[onLayout] changed:%s, isHeaderOpen: %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) });
      ac.d("MicroMsg.ConversationListView", "[onLayout] top: %d, bottom: %d, height: %d, count: %d, realCount: %d, hashCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt4), Integer.valueOf(paramInt4 - paramInt2), Integer.valueOf(this.mCount), Integer.valueOf(getRealCount()), Integer.valueOf(hashCode()) });
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
        xE(false);
      }
      if ((this.ICp != null) && (this.ICp.getVisibility() == 0) && (getFirstVisiblePosition() != 0)) {
        this.ICp.setVisibility(4);
      }
      this.mCount = getRealCount();
      AppMethodBeat.o(38350);
      return;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.ConversationListView", localException, "alvinluo onLayout exception", new Object[0]);
      AppMethodBeat.o(38350);
    }
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(38349);
    Object localObject;
    int i;
    if ((paramInt1 == 0) && (this.muC))
    {
      localObject = getChildAt(1);
      if (localObject == null) {
        if (byu())
        {
          i = this.mtL.getMeasuredHeight() - this.mtR;
          ac.i("MicroMsg.ConversationListView", "alvinluo computeActionBarTranslation %d", new Object[] { Integer.valueOf(i) });
          label71:
          i = Math.max(0, i);
          if (this.afy != null)
          {
            if (Math.abs(i) > this.ICw) {
              break label444;
            }
            this.afy.setVisibility(0);
            label106:
            ac.v("MicroMsg.ConversationListView", "alvinluo onScroll setTranslationY before: %f, trans: %d", new Object[] { Float.valueOf(this.afy.getTranslationY()), Integer.valueOf(i) });
            this.afy.setTranslationY(i);
          }
          if (this.mtL != null)
          {
            localObject = this.mtL;
            this.mtL.getHeight();
            ((HeaderContainer)localObject).eq(i, this.mtL.getHeight() - this.mtR);
          }
        }
      }
    }
    for (;;)
    {
      if (this.uhw != null) {
        this.uhw.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
      }
      if (this.IBU != null) {
        this.IBU.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
      }
      if ((paramInt2 > 1) && (frW()) && (this.mtL != null))
      {
        paramAbsListView = new int[2];
        getLocationOnScreen(paramAbsListView);
        this.ICs = paramAbsListView[1];
        paramInt1 = this.mtL.getBottom() - com.tencent.mm.cc.a.fromDPToPix(getContext(), 56);
        this.mtL.getBackUpFooterRect().set(0, paramInt1, getWidth(), getHeight() + paramInt1);
        ac.d("MicroMsg.ConversationListView", "alvinluo onScroll BackUpFooterRect: %s, headerContainer top: %d, bottom: %d", new Object[] { this.mtL.getBackUpFooterRect().toString(), Integer.valueOf(this.mtL.getTop()), Integer.valueOf(this.mtL.getBottom()) });
        this.IBX = ((int)(255.0F * this.mtL.getBottom() / this.mtL.getHeight()));
      }
      AppMethodBeat.o(38349);
      return;
      i = 0;
      break;
      i = ((View)localObject).getTop();
      int j = Math.max(paramInt1 - getHeaderViewsCount(), 0);
      i = -(-i + (int)(j * getResources().getDimension(2131165515)) + this.mtR);
      break label71;
      label444:
      this.afy.setVisibility(4);
      break label106;
      if (paramInt1 > 0) {
        frX();
      }
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(38348);
    if (this.uhw != null) {
      this.uhw.onScrollStateChanged(paramAbsListView, paramInt);
    }
    if (this.IBU != null) {
      this.IBU.onScrollStateChanged(paramAbsListView, paramInt);
    }
    this.mScrollState = paramInt;
    AppMethodBeat.o(38348);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(38345);
    boolean bool2 = this.IBU.onTouch(paramView, paramMotionEvent);
    boolean bool1 = bool2;
    if (this.AKw != null) {
      bool1 = bool2 | this.AKw.onTouch(paramView, paramMotionEvent);
    }
    AppMethodBeat.o(38345);
    return bool1;
  }
  
  public void setActionBarUpdateCallback(final com.tencent.mm.plugin.appbrand.widget.header.a parama)
  {
    AppMethodBeat.i(38377);
    if (this.IBU != null)
    {
      this.mtS = parama;
      this.IBU.setActionBarUpdateCallback(new com.tencent.mm.plugin.appbrand.widget.header.a()
      {
        public final void a(float paramAnonymousFloat, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(196801);
          if (parama != null) {
            parama.a(paramAnonymousFloat, paramAnonymousInt1, paramAnonymousInt2);
          }
          AppMethodBeat.o(196801);
        }
        
        public final void b(float paramAnonymousFloat, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(196802);
          if (parama != null) {
            parama.b(paramAnonymousFloat, paramAnonymousInt1, paramAnonymousInt2);
          }
          AppMethodBeat.o(196802);
        }
      });
    }
    AppMethodBeat.o(38377);
  }
  
  public void setActivity(MMFragmentActivity paramMMFragmentActivity)
  {
    AppMethodBeat.i(38378);
    this.mvz = paramMMFragmentActivity;
    if (this.mtL != null) {
      this.mtL.setActivity(this.mvz);
    }
    AppMethodBeat.o(38378);
  }
  
  public void setIsCurrentMainUI(boolean paramBoolean)
  {
    AppMethodBeat.i(38380);
    ac.i("MicroMsg.ConversationListView", "alvinluo setIsCurrentMainUI: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.muC = paramBoolean;
    if (this.IBU != null) {
      this.IBU.setIsCurrentMainUI(paramBoolean);
    }
    AppMethodBeat.o(38380);
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    AppMethodBeat.i(38373);
    this.auB = paramOnItemClickListener;
    super.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(196806);
        ac.i("MicroMsg.ConversationListView", "alvinluo onItemClick isCanClose: %b", new Object[] { Boolean.valueOf(ConversationListView.h(ConversationListView.this)) });
        if ((ConversationListView.j(ConversationListView.this) != null) && (!ConversationListView.h(ConversationListView.this))) {
          ConversationListView.j(ConversationListView.this).onItemClick(paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        }
        AppMethodBeat.o(196806);
      }
    });
    AppMethodBeat.o(38373);
  }
  
  public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener paramOnItemLongClickListener)
  {
    AppMethodBeat.i(38372);
    this.HGi = paramOnItemLongClickListener;
    super.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(196805);
        ac.i("MicroMsg.ConversationListView", "alvinluo onItemLongClick isCanClose: %b", new Object[] { Boolean.valueOf(ConversationListView.h(ConversationListView.this)) });
        if ((ConversationListView.i(ConversationListView.this) != null) && (!ConversationListView.h(ConversationListView.this)))
        {
          boolean bool = ConversationListView.i(ConversationListView.this).onItemLongClick(paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
          AppMethodBeat.o(196805);
          return bool;
        }
        AppMethodBeat.o(196805);
        return false;
      }
    });
    AppMethodBeat.o(38372);
  }
  
  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.uhw = paramOnScrollListener;
  }
  
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    this.AKw = paramOnTouchListener;
  }
  
  public void setSelection(int paramInt)
  {
    AppMethodBeat.i(38362);
    ac.i("MicroMsg.ConversationListView", "[setSelection] position:%s, scrollOffset: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.mtR) });
    if (paramInt == 0)
    {
      super.setSelectionFromTop(getFirstHeaderVisible(), this.mtR);
      AppMethodBeat.o(38362);
      return;
    }
    super.setSelectionFromTop(paramInt, this.mtR);
    AppMethodBeat.o(38362);
  }
  
  public void setStatusBarMaskView(View paramView)
  {
    AppMethodBeat.i(38379);
    this.mtU = paramView;
    if (this.IBU != null) {
      this.IBU.setStatusBarMaskView(paramView);
    }
    AppMethodBeat.o(38379);
  }
  
  public void setonDispatchTouchEventListener(View.OnTouchListener paramOnTouchListener)
  {
    this.ICv = paramOnTouchListener;
  }
  
  public void smoothScrollToPosition(int paramInt)
  {
    AppMethodBeat.i(38363);
    ac.i("MicroMsg.ConversationListView", "[smoothScrollToPosition] position:%s", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 0)
    {
      super.smoothScrollToPositionFromTop(getFirstHeaderVisible(), this.mtR);
      AppMethodBeat.o(38363);
      return;
    }
    super.smoothScrollToPositionFromTop(paramInt, this.mtR);
    AppMethodBeat.o(38363);
  }
  
  public void smoothScrollToPositionFromTop(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(38364);
    ac.i("MicroMsg.ConversationListView", "[smoothScrollToPositionFromTop] position:%s offset:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == 0)
    {
      super.smoothScrollToPositionFromTop(getFirstHeaderVisible(), this.mtR + paramInt2);
      AppMethodBeat.o(38364);
      return;
    }
    super.smoothScrollToPositionFromTop(paramInt1, this.mtR + paramInt2);
    AppMethodBeat.o(38364);
  }
  
  public void smoothScrollToPositionFromTop(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(38365);
    ac.i("MicroMsg.ConversationListView", "[smoothScrollToPositionFromTop] position:%s offset:%s duration:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramInt1 == 0)
    {
      super.smoothScrollToPositionFromTop(getFirstHeaderVisible(), this.mtR + paramInt2, paramInt3);
      AppMethodBeat.o(38365);
      return;
    }
    super.smoothScrollToPositionFromTop(paramInt1, this.mtR + paramInt2, paramInt3);
    AppMethodBeat.o(38365);
  }
  
  public final void ul(int paramInt) {}
  
  public final void vw(int paramInt)
  {
    AppMethodBeat.i(38355);
    ac.d("MicroMsg.ConversationListView", "[onCloseHeader]");
    this.ICy = false;
    this.muq = false;
    this.IBX = 0;
    if (this.ICm != null) {
      removeCallbacks(this.ICm);
    }
    AppMethodBeat.o(38355);
  }
  
  public final void vx(int paramInt)
  {
    AppMethodBeat.i(38356);
    vw(paramInt);
    AppMethodBeat.o(38356);
  }
  
  final void xE(boolean paramBoolean)
  {
    AppMethodBeat.i(38358);
    if (this.ICx == null)
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
          AppMethodBeat.i(196804);
          ConversationListView.g(ConversationListView.this);
          AppMethodBeat.o(196804);
        }
      }, 0L);
      AppMethodBeat.o(38358);
      return;
    }
    frV();
    AppMethodBeat.o(38358);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.ConversationListView
 * JD-Core Version:    0.7.0.1
 */
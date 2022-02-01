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
import com.tencent.mm.g.a.ll;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.widget.header.HeaderContainer;
import com.tencent.mm.plugin.appbrand.widget.header.c.a;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.e;
import com.tencent.mm.plugin.appbrand.widget.recentview.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.ap;
import java.util.Iterator;
import java.util.LinkedList;

public class ConversationListView
  extends ListView
  implements View.OnTouchListener, AbsListView.OnScrollListener, c.a, AppBrandRecentView.e
{
  private AdapterView.OnItemLongClickListener Ggs;
  private LinkedList<ListView.FixedViewInfo> HbM;
  com.tencent.mm.plugin.appbrand.widget.header.c HbN;
  private String HbO;
  private float HbP;
  private int HbQ;
  private Bitmap HbR;
  private RectF HbS;
  private boolean HbT;
  private NinePatchDrawable HbU;
  private Rect HbV;
  private final float HbW;
  private final float HbX;
  private final float HbY;
  private final float HbZ;
  private final float Hca;
  private boolean Hcb;
  private final float Hcc;
  private int Hcd;
  private boolean Hce;
  Runnable Hcf;
  Runnable Hcg;
  Runnable Hch;
  View Hci;
  private int Hcj;
  private int Hck;
  private int Hcl;
  com.tencent.mm.sdk.b.c<ll> Hcm;
  private View.OnLayoutChangeListener Hcn;
  private View.OnTouchListener Hco;
  private int Hcp;
  View Hcq;
  private boolean Hcr;
  private boolean Hcs;
  private View aeE;
  private int aeU;
  private AdapterView.OnItemClickListener atG;
  boolean dqc;
  private int lDk;
  HeaderContainer lRJ;
  private int lRP;
  private com.tencent.mm.plugin.appbrand.widget.header.a lRQ;
  private View lRS;
  private boolean lSA;
  boolean lSo;
  private MMFragmentActivity lTx;
  private int lgU;
  private int mCount;
  private Paint mPaint;
  private int mScrollState;
  private AbsListView.OnScrollListener sZi;
  private View.OnTouchListener zrL;
  
  public ConversationListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(38336);
    this.HbM = new LinkedList();
    this.mPaint = new Paint(1);
    this.HbR = null;
    this.HbS = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
    this.HbT = false;
    this.HbU = null;
    this.HbV = new Rect();
    this.HbW = com.tencent.mm.cd.a.fromDPToPix(getContext(), 30);
    this.HbX = com.tencent.mm.cd.a.fromDPToPix(getContext(), 8);
    this.HbY = com.tencent.mm.cd.a.fromDPToPix(getContext(), 24);
    this.HbZ = com.tencent.mm.cd.a.fromDPToPix(getContext(), 64);
    this.Hca = 0.5F;
    this.Hcb = false;
    this.Hcc = com.tencent.mm.cd.a.fromDPToPix(getContext(), 200);
    this.Hcd = 0;
    this.lSo = false;
    this.Hce = false;
    this.lRQ = null;
    this.Hcf = null;
    this.Hcg = null;
    this.Hch = null;
    this.lDk = 0;
    this.Hcj = 0;
    this.lgU = 0;
    this.Hck = com.tencent.mm.cd.a.fromDPToPix(getContext(), 56);
    this.lSA = true;
    this.Hcl = 0;
    this.dqc = false;
    this.Hcm = new com.tencent.mm.sdk.b.c() {};
    this.Hcn = new View.OnLayoutChangeListener()
    {
      public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
      {
        AppMethodBeat.i(191717);
        ad.i("MicroMsg.ConversationListView", "ActionBarView layout changed, call setupActionBarView()");
        ConversationListView.b(ConversationListView.this);
        AppMethodBeat.o(191717);
      }
    };
    this.Hco = null;
    this.Hcp = 0;
    this.Hcs = false;
    init(paramContext);
    AppMethodBeat.o(38336);
  }
  
  public ConversationListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(38337);
    this.HbM = new LinkedList();
    this.mPaint = new Paint(1);
    this.HbR = null;
    this.HbS = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
    this.HbT = false;
    this.HbU = null;
    this.HbV = new Rect();
    this.HbW = com.tencent.mm.cd.a.fromDPToPix(getContext(), 30);
    this.HbX = com.tencent.mm.cd.a.fromDPToPix(getContext(), 8);
    this.HbY = com.tencent.mm.cd.a.fromDPToPix(getContext(), 24);
    this.HbZ = com.tencent.mm.cd.a.fromDPToPix(getContext(), 64);
    this.Hca = 0.5F;
    this.Hcb = false;
    this.Hcc = com.tencent.mm.cd.a.fromDPToPix(getContext(), 200);
    this.Hcd = 0;
    this.lSo = false;
    this.Hce = false;
    this.lRQ = null;
    this.Hcf = null;
    this.Hcg = null;
    this.Hch = null;
    this.lDk = 0;
    this.Hcj = 0;
    this.lgU = 0;
    this.Hck = com.tencent.mm.cd.a.fromDPToPix(getContext(), 56);
    this.lSA = true;
    this.Hcl = 0;
    this.dqc = false;
    this.Hcm = new com.tencent.mm.sdk.b.c() {};
    this.Hcn = new View.OnLayoutChangeListener()
    {
      public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
      {
        AppMethodBeat.i(191717);
        ad.i("MicroMsg.ConversationListView", "ActionBarView layout changed, call setupActionBarView()");
        ConversationListView.b(ConversationListView.this);
        AppMethodBeat.o(191717);
      }
    };
    this.Hco = null;
    this.Hcp = 0;
    this.Hcs = false;
    init(paramContext);
    AppMethodBeat.o(38337);
  }
  
  private float ZH(int paramInt)
  {
    AppMethodBeat.i(38361);
    int i = (int)getResources().getDimension(2131165515);
    int j = getHeaderViewsCount();
    int k = getFooterViewsCount();
    float f = getMeasuredHeight() - i * (paramInt - j - k) - ap.dL(getContext());
    ad.d("MicroMsg.ConversationListView", "alvinluo isFullScreen getMeasuredHeight: %d", new Object[] { Integer.valueOf(getMeasuredHeight()) });
    ad.i("MicroMsg.ConversationListView", "[isFullScreen] totalItemCount:" + paramInt + " getFirstVisiblePosition:" + getFirstVisiblePosition() + " getLastVisiblePosition:" + getLastVisiblePosition() + " getHeaderViewsCount:" + getHeaderViewsCount() + " getFooterViewsCount:" + getFooterViewsCount() + " extraHeight:" + f);
    AppMethodBeat.o(38361);
    return f;
  }
  
  private static void aY(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(38343);
    ad.i("MicroMsg.ConversationListView", "alvinluo saveTopMargin topMargin: %d, needRead: %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    Object localObject = aj.eFE();
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      if (localObject != null)
      {
        ((SharedPreferences.Editor)localObject).putBoolean("Main_need_read_top_margin", paramBoolean);
        ((SharedPreferences.Editor)localObject).putInt("Main_top_marign", paramInt);
        ((SharedPreferences.Editor)localObject).apply();
        ad.i("MicroMsg.ConversationListView", "alvinluo saveTopMargin success");
      }
    }
    AppMethodBeat.o(38343);
  }
  
  private void fcb()
  {
    AppMethodBeat.i(38340);
    if ((Build.VERSION.SDK_INT >= 24) && (LauncherUI.getInstance() != null))
    {
      this.dqc = LauncherUI.getInstance().isInMultiWindowMode();
      if (this.lRJ != null) {
        this.lRJ.hu(this.dqc);
      }
    }
    AppMethodBeat.o(38340);
  }
  
  private void fce()
  {
    AppMethodBeat.i(38359);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.Hcq.getLayoutParams();
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
      f2 = ZH(i);
      if (f2 >= 0.0F) {
        break label311;
      }
      bool = true;
      k = localLayoutParams.height;
      ad.i("MicroMsg.ConversationListView", "[checkEmptyFooter] isRealFull:" + bool + " old height:" + k);
      View localView = getRootView().findViewById(2131301338);
      if (localView != null) {
        ad.i("MicroMsg.ConversationListView", "alvinluo checkEmptyFooter tabView Height: %d", new Object[] { Integer.valueOf(localView.getHeight()) });
      }
      m = (int)getResources().getDimension(2131165515);
      if (localView == null) {
        break label317;
      }
      i = localView.getHeight();
      j = i;
      if (i <= 0) {
        j = this.Hcd;
      }
      ad.d("MicroMsg.ConversationListView", "alvinluo checkEmptyFooter tabHeight: %d", new Object[] { Integer.valueOf(j) });
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
        ad.i("MicroMsg.ConversationListView", "alvinluo checkEmptyFooter isHeaderOpen: %b", new Object[] { Boolean.valueOf(bru()) });
        if (((!bool) || (Math.abs(f1) <= j + m)) && (!bru()))
        {
          ad.i("MicroMsg.ConversationListView", "[checkEmptyFooter] setSelection");
          setSelection(1);
          if (this.HbN != null) {
            this.HbN.hs(true);
          }
        }
        this.Hcq.requestLayout();
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
  
  private boolean fcf()
  {
    AppMethodBeat.i(38370);
    if (this.lRJ == null)
    {
      AppMethodBeat.o(38370);
      return false;
    }
    if ((this.lRJ.getBottom() >= this.aeU + 3) && (getFirstVisiblePosition() == 0))
    {
      AppMethodBeat.o(38370);
      return true;
    }
    AppMethodBeat.o(38370);
    return false;
  }
  
  private void fch()
  {
    AppMethodBeat.i(38382);
    if (this.lRQ != null)
    {
      if (ai.Eq())
      {
        i = getResources().getColor(2131099886);
        this.lRQ.b(0.0F, i, i);
        this.lRQ.a(0.0F, getResources().getColor(2131100196), 0);
        AppMethodBeat.o(38382);
        return;
      }
      int i = getResources().getColor(2131099885);
      this.lRQ.b(0.0F, i, i);
      this.lRQ.a(0.0F, getResources().getColor(2131100705), 0);
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
      this.Hcq = new View(getContext());
      this.Hcq.setLayoutParams(new LinearLayout.LayoutParams(-1, i));
      ((LinearLayout)localObject).addView(this.Hcq);
      ((LinearLayout)localObject).setBackgroundColor(ao.aD(getContext(), 2130968579));
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
    this.mPaint.setTextSize(com.tencent.mm.cd.a.ap(getContext(), 2131165498));
    this.HbO = getResources().getString(2131757429);
    this.HbP = this.mPaint.measureText(this.HbO);
    super.setOnScrollListener(this);
    super.setOnTouchListener(this);
    setOverScrollMode(2);
    ad.i("MicroMsg.ConversationListView", "alvinluo HeaderContainer new, ConversationListView: %d", new Object[] { Integer.valueOf(hashCode()) });
    this.lRJ = ((d)g.ab(d.class)).dM(paramContext);
    if (this.lRJ != null)
    {
      this.lRJ.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
      addHeaderView(this.lRJ);
      addFooterView(getEmptyFooter());
      this.HbN = ((d)g.ab(d.class)).a(paramContext, this, this.lRJ);
      this.HbN.a(this);
      this.lRJ.setAnimController(this.HbN);
    }
    this.Hcd = ((int)(com.tencent.mm.cd.a.ap(getContext(), 2131165256) * com.tencent.mm.cd.a.hQ(getContext())));
    this.lRP = ap.dL(getContext());
    this.Hcp = com.tencent.mm.cd.a.fromDPToPix(paramContext, 100);
    fcb();
    AppMethodBeat.o(38339);
  }
  
  private void setListTopMargin(int paramInt)
  {
    AppMethodBeat.i(38342);
    ad.i("MicroMsg.ConversationListView", "alvinluo initActionBarView statusBarHeight: %d, isInMultiWindowMode: %b, target: %d, actionBarTop: %d", new Object[] { Integer.valueOf(this.lDk), Boolean.valueOf(this.dqc), Integer.valueOf(paramInt), Integer.valueOf(this.aeE.getTop()) });
    if (paramInt >= 0)
    {
      if (this.lRS != null) {
        if (this.dqc) {
          break label128;
        }
      }
      ViewGroup.LayoutParams localLayoutParams;
      label128:
      for (this.lRS.getLayoutParams().height = this.lDk;; this.lRS.getLayoutParams().height = paramInt)
      {
        localLayoutParams = getLayoutParams();
        if (!(localLayoutParams instanceof RelativeLayout.LayoutParams)) {
          break label150;
        }
        if (this.dqc) {
          break;
        }
        ((RelativeLayout.LayoutParams)localLayoutParams).topMargin = this.lDk;
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
    this.HbM.add(localFixedViewInfo);
    AppMethodBeat.o(38368);
  }
  
  protected void attachViewToParent(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(38346);
    super.attachViewToParent(paramView, paramInt, paramLayoutParams);
    if ((this.aeU <= 0) && (this.HbN != null))
    {
      this.aeU = (ap.dL(getContext()) + ai.jm(getContext()));
      this.lRP = ap.dL(getContext());
      fcc();
      if (this.lRJ != null) {
        this.lRJ.setActionBar(this.aeE);
      }
      this.HbN.setActionBar(this.aeE);
      this.HbN.setTabView(getRootView().findViewById(2131301338));
    }
    AppMethodBeat.o(38346);
  }
  
  public final void brW()
  {
    AppMethodBeat.i(38354);
    ad.d("MicroMsg.ConversationListView", "[onOpenHeader]");
    this.lSo = true;
    if (this.Hcf != null) {
      removeCallbacks(this.Hcf);
    }
    AppMethodBeat.o(38354);
  }
  
  public final void brX()
  {
    AppMethodBeat.i(38357);
    brW();
    AppMethodBeat.o(38357);
  }
  
  public final boolean bru()
  {
    AppMethodBeat.i(38369);
    if ((fcf()) && (this.lSo))
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
    if (this.lRJ == null)
    {
      boolean bool = super.canScrollHorizontally(paramInt);
      AppMethodBeat.o(38338);
      return bool;
    }
    if (this.lRJ.getBottom() >= this.lRJ.getHeight())
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
    if ((getFirstVisiblePosition() == 0) && (paramInt2 < 0) && (paramArrayOfInt1 != null) && (paramArrayOfInt1.length >= 2) && (!this.lSo))
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
    if (this.Hco != null) {
      this.Hco.onTouch(this, paramMotionEvent);
    }
    int i;
    boolean bool;
    try
    {
      ad.d("MicroMsg.ConversationListView", "alvinluo dispatchTouchEvent backUpFooterRect: %s, %f, %f, bottom: %d, height: %d, isCanClose: %b", new Object[] { this.lRJ.getBackUpFooterRect().toString(), Float.valueOf(paramMotionEvent.getRawX()), Float.valueOf(paramMotionEvent.getRawY()), Integer.valueOf(this.lRJ.getBottom()), Integer.valueOf(this.lRJ.getHeight()), Boolean.valueOf(this.Hcr) });
      int j = (int)(paramMotionEvent.getRawY() - this.lDk);
      i = j;
      if (this.dqc) {
        i = j - this.Hcl + this.lDk;
      }
      if ((bru()) && (this.lRJ != null))
      {
        if (paramMotionEvent.getAction() == 0) {
          if (!this.lRJ.getBackUpFooterRect().contains((int)paramMotionEvent.getRawX(), i)) {
            break label242;
          }
        }
        label242:
        for (this.Hcs = true;; this.Hcs = false)
        {
          ad.d("MicroMsg.ConversationListView", "alvinluo dispatchTouchEvent isDownInCloseRect: %b, touchY: %d", new Object[] { Boolean.valueOf(this.Hcs), Integer.valueOf(i) });
          if (this.Hcs) {
            break;
          }
          bool = this.lRJ.dispatchTouchEvent(paramMotionEvent);
          AppMethodBeat.o(38371);
          return bool;
        }
      }
      if (this.lRJ == null) {
        break label513;
      }
    }
    catch (Exception paramMotionEvent)
    {
      ad.printErrStackTrace("MicroMsg.ConversationListView", paramMotionEvent, "alvinluo ConversationListView dispatchTouchEvent exception", new Object[0]);
      AppMethodBeat.o(38371);
      return false;
    }
    if ((this.lRJ.getBottom() >= this.lRJ.getHeight()) && (this.lRJ.isFullScreen()) && (getFirstVisiblePosition() == 0))
    {
      if ((paramMotionEvent.getAction() == 0) && (this.lRJ.getBackUpFooterRect().contains((int)paramMotionEvent.getRawX(), i))) {
        this.Hcr = true;
      }
      while ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
      {
        if (this.Hcr)
        {
          this.Hcr = false;
          if (this.HbN != null)
          {
            ad.i("MicroMsg.ConversationListView", "alvinluo closeHeader by click BackUpFooterRect");
            this.HbN.uA(12);
          }
          if (paramMotionEvent.getAction() == 1)
          {
            ad.i("MicroMsg.ConversationListView", "alvinluo ConversationListView cancel touch event");
            paramMotionEvent.setAction(3);
            bool = super.dispatchTouchEvent(paramMotionEvent);
            AppMethodBeat.o(38371);
            return bool;
            if (paramMotionEvent.getAction() != 0) {
              continue;
            }
            this.Hcr = false;
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
      if ((this.HbN != null) && (paramMotionEvent.getAction() == 0)) {
        this.HbN.O(paramMotionEvent);
      }
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(38371);
      return bool;
    }
    label513:
    if ((this.Hcr) && (paramMotionEvent.getAction() == 1))
    {
      ad.i("MicroMsg.ConversationListView", "alvinluo ConversationListView cancel touch event..., isHeaderOpen: %b, isHeaderVisible: %b", new Object[] { Boolean.valueOf(bru()), Boolean.valueOf(fcf()) });
      if (bru()) {
        break label618;
      }
      this.Hcr = false;
    }
    for (;;)
    {
      if ((paramMotionEvent.getAction() == 0) && (this.HbN != null) && (paramMotionEvent.getAction() == 0)) {
        this.HbN.O(paramMotionEvent);
      }
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(38371);
      return bool;
      label618:
      paramMotionEvent.setAction(3);
    }
  }
  
  final void fcc()
  {
    int i = 1;
    AppMethodBeat.i(191721);
    if (this.aeE == null)
    {
      this.aeE = getRootView().findViewById(2131296345);
      if (this.aeE != null) {
        this.aeE.addOnLayoutChangeListener(this.Hcn);
      }
    }
    else
    {
      if ((this.dqc) && (Build.VERSION.SDK_INT >= 24) && (LauncherUI.getInstance() != null))
      {
        this.dqc = LauncherUI.getInstance().isInMultiWindowMode();
        ad.i("MicroMsg.ConversationListView", "alvinluo initActionBarView check multiWindowMode %b", new Object[] { Boolean.valueOf(this.dqc) });
      }
      if ((this.lDk != 0) && ((this.dqc) || (this.aeE.getTop() == this.lDk) || (this.aeE.getTop() == 0))) {
        break label222;
      }
      this.lDk = this.aeE.getTop();
    }
    for (;;)
    {
      if ((i != 0) && (!this.dqc))
      {
        post(new Runnable()
        {
          int gll = 0;
          
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
              if (this.gll <= 2)
              {
                ad.i("MicroMsg.ConversationListView", "alvinluo initActionBarView try again tryCount: %d", new Object[] { Integer.valueOf(this.gll) });
                ConversationListView.this.post(this);
              }
            }
            for (;;)
            {
              this.gll += 1;
              AppMethodBeat.o(38330);
              return;
              ConversationListView.f(ConversationListView.this);
              continue;
              ConversationListView.b(ConversationListView.this, ConversationListView.e(ConversationListView.this));
              ConversationListView.ZI(ConversationListView.e(ConversationListView.this));
            }
          }
        });
        AppMethodBeat.o(191721);
        return;
        AppMethodBeat.o(191721);
        return;
      }
      this.Hcj = this.aeE.getTop();
      setListTopMargin(this.Hcj);
      aY(this.Hcj, false);
      AppMethodBeat.o(191721);
      return;
      label222:
      i = 0;
    }
  }
  
  public final void fcd()
  {
    AppMethodBeat.i(38353);
    if (this.HbN != null) {
      this.HbN.b(0L, 0, true);
    }
    fcg();
    AppMethodBeat.o(38353);
  }
  
  final void fcg()
  {
    AppMethodBeat.i(38381);
    if (this.aeE != null)
    {
      this.aeE.setTranslationY(0.0F);
      this.aeE.setVisibility(0);
    }
    fch();
    AppMethodBeat.o(38381);
  }
  
  public int getFirstHeaderVisible()
  {
    AppMethodBeat.i(38367);
    Iterator localIterator = this.HbM.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject = (ListView.FixedViewInfo)localIterator.next();
      if (((ListView.FixedViewInfo)localObject).view == this.lRJ)
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
            ad.i("MicroMsg.ConversationListView", "[getFirstHeaderVisible] index:%s", new Object[] { Integer.valueOf(i) });
            AppMethodBeat.o(38367);
            return i;
          }
        }
        i += 1;
      }
    }
    ad.i("MicroMsg.ConversationListView", "[getFirstHeaderVisible] index:%s", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(38367);
    return i;
  }
  
  public final void i(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(38366);
    ad.i("MicroMsg.ConversationListView", "[showAppBrandHeader] isShow:" + paramBoolean1 + " isAnim:" + paramBoolean2 + " isScrollFirst:" + paramBoolean3);
    if (paramBoolean1)
    {
      if (this.HbN != null)
      {
        this.HbN.bro();
        AppMethodBeat.o(38366);
      }
    }
    else if (this.HbN != null) {
      this.HbN.uA(0);
    }
    AppMethodBeat.o(38366);
  }
  
  final void jx(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(38352);
    if (this.lRQ != null)
    {
      this.lRQ.a(1.0F, paramInt1, 0);
      this.lRQ.b(1.0F, paramInt2, paramInt2);
    }
    AppMethodBeat.o(38352);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(38375);
    super.onAttachedToWindow();
    if (this.Hcm != null) {
      this.Hcm.alive();
    }
    AppMethodBeat.o(38375);
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(38374);
    super.onConfigurationChanged(paramConfiguration);
    ad.i("MicroMsg.ConversationListView", "[onConfigurationChanged] orientation:%s, last: %d", new Object[] { Integer.valueOf(paramConfiguration.orientation), Integer.valueOf(this.lgU) });
    wx(true);
    if (this.HbN != null) {
      this.HbN.hV();
    }
    if (this.lRJ != null) {
      this.lRJ.e(paramConfiguration);
    }
    if (ai.Eq()) {
      jx(getResources().getColor(2131100196), getResources().getColor(2131099886));
    }
    for (;;)
    {
      if (this.Hch != null) {
        removeCallbacks(this.Hch);
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
      this.Hch = paramConfiguration;
      postDelayed(paramConfiguration, 800L);
      this.lSo = false;
      AppMethodBeat.o(38374);
      return;
      jx(getResources().getColor(2131100705), getResources().getColor(2131099885));
    }
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(38376);
    super.onDetachedFromWindow();
    if (this.Hcm != null) {
      this.Hcm.dead();
    }
    AppMethodBeat.o(38376);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(38347);
    super.onDraw(paramCanvas);
    if ((this.lRJ != null) && (getFirstVisiblePosition() == 0) && (this.lRJ.isFullScreen()) && (this.lRJ.getBottom() > 6))
    {
      if (this.HbQ < 30)
      {
        AppMethodBeat.o(38347);
        return;
      }
      this.mPaint.setStyle(Paint.Style.FILL);
      this.mPaint.setColor(getContext().getResources().getColor(2131099930));
      this.mPaint.setAlpha(this.HbQ);
      paramCanvas.drawRect(this.lRJ.getBackUpFooterRect().left, this.lRJ.getBackUpFooterRect().top + this.Hck, this.lRJ.getBackUpFooterRect().right, this.lRJ.getBackUpFooterRect().bottom, this.mPaint);
    }
    AppMethodBeat.o(38347);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(38350);
    try
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      boolean bool = bru();
      ad.i("MicroMsg.ConversationListView", "[onLayout] changed:%s, isHeaderOpen: %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) });
      ad.d("MicroMsg.ConversationListView", "[onLayout] top: %d, bottom: %d, height: %d, count: %d, realCount: %d, hashCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt4), Integer.valueOf(paramInt4 - paramInt2), Integer.valueOf(this.mCount), Integer.valueOf(getRealCount()), Integer.valueOf(hashCode()) });
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
        wx(false);
      }
      if ((this.Hci != null) && (this.Hci.getVisibility() == 0) && (getFirstVisiblePosition() != 0)) {
        this.Hci.setVisibility(4);
      }
      this.mCount = getRealCount();
      AppMethodBeat.o(38350);
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.ConversationListView", localException, "alvinluo onLayout exception", new Object[0]);
      AppMethodBeat.o(38350);
    }
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(38349);
    Object localObject;
    int i;
    if ((paramInt1 == 0) && (this.lSA))
    {
      localObject = getChildAt(1);
      if (localObject == null) {
        if (bru())
        {
          i = this.lRJ.getMeasuredHeight() - this.lRP;
          ad.i("MicroMsg.ConversationListView", "alvinluo computeActionBarTranslation %d", new Object[] { Integer.valueOf(i) });
          label71:
          i = Math.max(0, i);
          if (this.aeE != null)
          {
            if (Math.abs(i) > this.Hcp) {
              break label444;
            }
            this.aeE.setVisibility(0);
            label106:
            ad.v("MicroMsg.ConversationListView", "alvinluo onScroll setTranslationY before: %f, trans: %d", new Object[] { Float.valueOf(this.aeE.getTranslationY()), Integer.valueOf(i) });
            this.aeE.setTranslationY(i);
          }
          if (this.lRJ != null)
          {
            localObject = this.lRJ;
            this.lRJ.getHeight();
            ((HeaderContainer)localObject).en(i, this.lRJ.getHeight() - this.lRP);
          }
        }
      }
    }
    for (;;)
    {
      if (this.sZi != null) {
        this.sZi.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
      }
      if (this.HbN != null) {
        this.HbN.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
      }
      if ((paramInt2 > 1) && (fcf()) && (this.lRJ != null))
      {
        paramAbsListView = new int[2];
        getLocationOnScreen(paramAbsListView);
        this.Hcl = paramAbsListView[1];
        paramInt1 = this.lRJ.getBottom() - com.tencent.mm.cd.a.fromDPToPix(getContext(), 56);
        this.lRJ.getBackUpFooterRect().set(0, paramInt1, getWidth(), getHeight() + paramInt1);
        ad.d("MicroMsg.ConversationListView", "alvinluo onScroll BackUpFooterRect: %s, headerContainer top: %d, bottom: %d", new Object[] { this.lRJ.getBackUpFooterRect().toString(), Integer.valueOf(this.lRJ.getTop()), Integer.valueOf(this.lRJ.getBottom()) });
        this.HbQ = ((int)(255.0F * this.lRJ.getBottom() / this.lRJ.getHeight()));
      }
      AppMethodBeat.o(38349);
      return;
      i = 0;
      break;
      i = ((View)localObject).getTop();
      int j = Math.max(paramInt1 - getHeaderViewsCount(), 0);
      i = -(-i + (int)(j * getResources().getDimension(2131165515)) + this.lRP);
      break label71;
      label444:
      this.aeE.setVisibility(4);
      break label106;
      if (paramInt1 > 0) {
        fcg();
      }
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(38348);
    if (this.sZi != null) {
      this.sZi.onScrollStateChanged(paramAbsListView, paramInt);
    }
    if (this.HbN != null) {
      this.HbN.onScrollStateChanged(paramAbsListView, paramInt);
    }
    this.mScrollState = paramInt;
    AppMethodBeat.o(38348);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(38345);
    boolean bool2 = this.HbN.onTouch(paramView, paramMotionEvent);
    boolean bool1 = bool2;
    if (this.zrL != null) {
      bool1 = bool2 | this.zrL.onTouch(paramView, paramMotionEvent);
    }
    AppMethodBeat.o(38345);
    return bool1;
  }
  
  public void setActionBarUpdateCallback(final com.tencent.mm.plugin.appbrand.widget.header.a parama)
  {
    AppMethodBeat.i(38377);
    if (this.HbN != null)
    {
      this.lRQ = parama;
      this.HbN.setActionBarUpdateCallback(new com.tencent.mm.plugin.appbrand.widget.header.a()
      {
        public final void a(float paramAnonymousFloat, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(191715);
          if (parama != null) {
            parama.a(paramAnonymousFloat, paramAnonymousInt1, paramAnonymousInt2);
          }
          AppMethodBeat.o(191715);
        }
        
        public final void b(float paramAnonymousFloat, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(191716);
          if (parama != null) {
            parama.b(paramAnonymousFloat, paramAnonymousInt1, paramAnonymousInt2);
          }
          AppMethodBeat.o(191716);
        }
      });
    }
    AppMethodBeat.o(38377);
  }
  
  public void setActivity(MMFragmentActivity paramMMFragmentActivity)
  {
    AppMethodBeat.i(38378);
    this.lTx = paramMMFragmentActivity;
    if (this.lRJ != null) {
      this.lRJ.setActivity(this.lTx);
    }
    AppMethodBeat.o(38378);
  }
  
  public void setIsCurrentMainUI(boolean paramBoolean)
  {
    AppMethodBeat.i(38380);
    ad.i("MicroMsg.ConversationListView", "alvinluo setIsCurrentMainUI: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.lSA = paramBoolean;
    if (this.HbN != null) {
      this.HbN.setIsCurrentMainUI(paramBoolean);
    }
    AppMethodBeat.o(38380);
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    AppMethodBeat.i(38373);
    this.atG = paramOnItemClickListener;
    super.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(191720);
        ad.i("MicroMsg.ConversationListView", "alvinluo onItemClick isCanClose: %b", new Object[] { Boolean.valueOf(ConversationListView.h(ConversationListView.this)) });
        if ((ConversationListView.j(ConversationListView.this) != null) && (!ConversationListView.h(ConversationListView.this))) {
          ConversationListView.j(ConversationListView.this).onItemClick(paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        }
        AppMethodBeat.o(191720);
      }
    });
    AppMethodBeat.o(38373);
  }
  
  public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener paramOnItemLongClickListener)
  {
    AppMethodBeat.i(38372);
    this.Ggs = paramOnItemLongClickListener;
    super.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(191719);
        ad.i("MicroMsg.ConversationListView", "alvinluo onItemLongClick isCanClose: %b", new Object[] { Boolean.valueOf(ConversationListView.h(ConversationListView.this)) });
        if ((ConversationListView.i(ConversationListView.this) != null) && (!ConversationListView.h(ConversationListView.this)))
        {
          boolean bool = ConversationListView.i(ConversationListView.this).onItemLongClick(paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
          AppMethodBeat.o(191719);
          return bool;
        }
        AppMethodBeat.o(191719);
        return false;
      }
    });
    AppMethodBeat.o(38372);
  }
  
  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.sZi = paramOnScrollListener;
  }
  
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    this.zrL = paramOnTouchListener;
  }
  
  public void setSelection(int paramInt)
  {
    AppMethodBeat.i(38362);
    ad.i("MicroMsg.ConversationListView", "[setSelection] position:%s, scrollOffset: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.lRP) });
    if (paramInt == 0)
    {
      super.setSelectionFromTop(getFirstHeaderVisible(), this.lRP);
      AppMethodBeat.o(38362);
      return;
    }
    super.setSelectionFromTop(paramInt, this.lRP);
    AppMethodBeat.o(38362);
  }
  
  public void setStatusBarMaskView(View paramView)
  {
    AppMethodBeat.i(38379);
    this.lRS = paramView;
    if (this.HbN != null) {
      this.HbN.setStatusBarMaskView(paramView);
    }
    AppMethodBeat.o(38379);
  }
  
  public void setonDispatchTouchEventListener(View.OnTouchListener paramOnTouchListener)
  {
    this.Hco = paramOnTouchListener;
  }
  
  public void smoothScrollToPosition(int paramInt)
  {
    AppMethodBeat.i(38363);
    ad.i("MicroMsg.ConversationListView", "[smoothScrollToPosition] position:%s", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 0)
    {
      super.smoothScrollToPositionFromTop(getFirstHeaderVisible(), this.lRP);
      AppMethodBeat.o(38363);
      return;
    }
    super.smoothScrollToPositionFromTop(paramInt, this.lRP);
    AppMethodBeat.o(38363);
  }
  
  public void smoothScrollToPositionFromTop(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(38364);
    ad.i("MicroMsg.ConversationListView", "[smoothScrollToPositionFromTop] position:%s offset:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == 0)
    {
      super.smoothScrollToPositionFromTop(getFirstHeaderVisible(), this.lRP + paramInt2);
      AppMethodBeat.o(38364);
      return;
    }
    super.smoothScrollToPositionFromTop(paramInt1, this.lRP + paramInt2);
    AppMethodBeat.o(38364);
  }
  
  public void smoothScrollToPositionFromTop(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(38365);
    ad.i("MicroMsg.ConversationListView", "[smoothScrollToPositionFromTop] position:%s offset:%s duration:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramInt1 == 0)
    {
      super.smoothScrollToPositionFromTop(getFirstHeaderVisible(), this.lRP + paramInt2, paramInt3);
      AppMethodBeat.o(38365);
      return;
    }
    super.smoothScrollToPositionFromTop(paramInt1, this.lRP + paramInt2, paramInt3);
    AppMethodBeat.o(38365);
  }
  
  public final void tu(int paramInt) {}
  
  public final void uF(int paramInt)
  {
    AppMethodBeat.i(38355);
    ad.d("MicroMsg.ConversationListView", "[onCloseHeader]");
    this.Hcr = false;
    this.lSo = false;
    this.HbQ = 0;
    if (this.Hcf != null) {
      removeCallbacks(this.Hcf);
    }
    AppMethodBeat.o(38355);
  }
  
  public final void uG(int paramInt)
  {
    AppMethodBeat.i(38356);
    uF(paramInt);
    AppMethodBeat.o(38356);
  }
  
  final void wx(boolean paramBoolean)
  {
    AppMethodBeat.i(38358);
    if (this.Hcq == null)
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
          AppMethodBeat.i(191718);
          ConversationListView.g(ConversationListView.this);
          AppMethodBeat.o(191718);
        }
      }, 0L);
      AppMethodBeat.o(38358);
      return;
    }
    fce();
    AppMethodBeat.o(38358);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.ConversationListView
 * JD-Core Version:    0.7.0.1
 */
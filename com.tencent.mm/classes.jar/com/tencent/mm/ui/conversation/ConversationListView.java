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
import com.tencent.mm.g.a.md;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.widget.header.HeaderContainer;
import com.tencent.mm.plugin.appbrand.widget.header.c.a;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.e;
import com.tencent.mm.plugin.appbrand.widget.recentview.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
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
  private View.OnTouchListener Cjy;
  private AdapterView.OnItemLongClickListener JtZ;
  private LinkedList<ListView.FixedViewInfo> KsZ;
  private View.OnLayoutChangeListener KtA;
  private View.OnTouchListener KtB;
  private int KtC;
  View KtD;
  private boolean KtE;
  private boolean KtF;
  com.tencent.mm.plugin.appbrand.widget.header.c Kta;
  private String Ktb;
  private float Ktc;
  private int Ktd;
  private Bitmap Kte;
  private RectF Ktf;
  private boolean Ktg;
  private NinePatchDrawable Kth;
  private Rect Kti;
  private final float Ktj;
  private final float Ktk;
  private final float Ktl;
  private final float Ktm;
  private final float Ktn;
  private boolean Kto;
  private final float Ktp;
  private int Ktq;
  private boolean Ktr;
  Runnable Kts;
  Runnable Ktt;
  Runnable Ktu;
  View Ktv;
  private int Ktw;
  private int Ktx;
  private int Kty;
  com.tencent.mm.sdk.b.c<md> Ktz;
  private int ahF;
  private View ahp;
  private AdapterView.OnItemClickListener awt;
  boolean dzB;
  private int gOl;
  private int mCount;
  private int mFF;
  private Paint mPaint;
  private int mScrollState;
  private View mUB;
  boolean mUX;
  HeaderContainer mUr;
  private int mUx;
  private com.tencent.mm.plugin.appbrand.widget.header.a mUy;
  private boolean mVj;
  private MMFragmentActivity mWg;
  private AbsListView.OnScrollListener vkg;
  
  public ConversationListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(38336);
    this.KsZ = new LinkedList();
    this.mPaint = new Paint(1);
    this.Kte = null;
    this.Ktf = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
    this.Ktg = false;
    this.Kth = null;
    this.Kti = new Rect();
    this.Ktj = com.tencent.mm.cc.a.fromDPToPix(getContext(), 30);
    this.Ktk = com.tencent.mm.cc.a.fromDPToPix(getContext(), 8);
    this.Ktl = com.tencent.mm.cc.a.fromDPToPix(getContext(), 24);
    this.Ktm = com.tencent.mm.cc.a.fromDPToPix(getContext(), 64);
    this.Ktn = 0.5F;
    this.Kto = false;
    this.Ktp = com.tencent.mm.cc.a.fromDPToPix(getContext(), 200);
    this.Ktq = 0;
    this.mUX = false;
    this.Ktr = false;
    this.mUy = null;
    this.Kts = null;
    this.Ktt = null;
    this.Ktu = null;
    this.mFF = 0;
    this.Ktw = 0;
    this.gOl = 0;
    this.Ktx = com.tencent.mm.cc.a.fromDPToPix(getContext(), 56);
    this.mVj = true;
    this.Kty = 0;
    this.dzB = false;
    this.Ktz = new com.tencent.mm.sdk.b.c() {};
    this.KtA = new View.OnLayoutChangeListener()
    {
      public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
      {
        AppMethodBeat.i(194647);
        ad.i("MicroMsg.ConversationListView", "ActionBarView layout changed, call setupActionBarView()");
        ConversationListView.b(ConversationListView.this);
        AppMethodBeat.o(194647);
      }
    };
    this.KtB = null;
    this.KtC = 0;
    this.KtF = false;
    init(paramContext);
    AppMethodBeat.o(38336);
  }
  
  public ConversationListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(38337);
    this.KsZ = new LinkedList();
    this.mPaint = new Paint(1);
    this.Kte = null;
    this.Ktf = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
    this.Ktg = false;
    this.Kth = null;
    this.Kti = new Rect();
    this.Ktj = com.tencent.mm.cc.a.fromDPToPix(getContext(), 30);
    this.Ktk = com.tencent.mm.cc.a.fromDPToPix(getContext(), 8);
    this.Ktl = com.tencent.mm.cc.a.fromDPToPix(getContext(), 24);
    this.Ktm = com.tencent.mm.cc.a.fromDPToPix(getContext(), 64);
    this.Ktn = 0.5F;
    this.Kto = false;
    this.Ktp = com.tencent.mm.cc.a.fromDPToPix(getContext(), 200);
    this.Ktq = 0;
    this.mUX = false;
    this.Ktr = false;
    this.mUy = null;
    this.Kts = null;
    this.Ktt = null;
    this.Ktu = null;
    this.mFF = 0;
    this.Ktw = 0;
    this.gOl = 0;
    this.Ktx = com.tencent.mm.cc.a.fromDPToPix(getContext(), 56);
    this.mVj = true;
    this.Kty = 0;
    this.dzB = false;
    this.Ktz = new com.tencent.mm.sdk.b.c() {};
    this.KtA = new View.OnLayoutChangeListener()
    {
      public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
      {
        AppMethodBeat.i(194647);
        ad.i("MicroMsg.ConversationListView", "ActionBarView layout changed, call setupActionBarView()");
        ConversationListView.b(ConversationListView.this);
        AppMethodBeat.o(194647);
      }
    };
    this.KtB = null;
    this.KtC = 0;
    this.KtF = false;
    init(paramContext);
    AppMethodBeat.o(38337);
  }
  
  private float aes(int paramInt)
  {
    AppMethodBeat.i(38361);
    int i = (int)getResources().getDimension(2131165515);
    int j = getHeaderViewsCount();
    int k = getFooterViewsCount();
    float f = getMeasuredHeight() - i * (paramInt - j - k) - ar.dT(getContext());
    ad.d("MicroMsg.ConversationListView", "alvinluo isFullScreen getMeasuredHeight: %d", new Object[] { Integer.valueOf(getMeasuredHeight()) });
    ad.i("MicroMsg.ConversationListView", "[isFullScreen] totalItemCount:" + paramInt + " getFirstVisiblePosition:" + getFirstVisiblePosition() + " getLastVisiblePosition:" + getLastVisiblePosition() + " getHeaderViewsCount:" + getHeaderViewsCount() + " getFooterViewsCount:" + getFooterViewsCount() + " extraHeight:" + f);
    AppMethodBeat.o(38361);
    return f;
  }
  
  private static void bj(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(38343);
    ad.i("MicroMsg.ConversationListView", "alvinluo saveTopMargin topMargin: %d, needRead: %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    Object localObject = aj.fkD();
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
  
  private void fIH()
  {
    AppMethodBeat.i(38340);
    if ((Build.VERSION.SDK_INT >= 24) && (LauncherUI.getInstance() != null))
    {
      this.dzB = LauncherUI.getInstance().isInMultiWindowMode();
      if (this.mUr != null) {
        this.mUr.ic(this.dzB);
      }
    }
    AppMethodBeat.o(38340);
  }
  
  private void fIK()
  {
    AppMethodBeat.i(38359);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.KtD.getLayoutParams();
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
      f2 = aes(i);
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
        j = this.Ktq;
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
        ad.i("MicroMsg.ConversationListView", "alvinluo checkEmptyFooter isHeaderOpen: %b", new Object[] { Boolean.valueOf(bCz()) });
        if (((!bool) || (Math.abs(f1) <= j + m)) && (!bCz()))
        {
          ad.i("MicroMsg.ConversationListView", "[checkEmptyFooter] setSelection");
          setSelection(1);
          if (this.Kta != null) {
            this.Kta.ia(true);
          }
        }
        this.KtD.requestLayout();
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
  
  private boolean fIL()
  {
    AppMethodBeat.i(38370);
    if (this.mUr == null)
    {
      AppMethodBeat.o(38370);
      return false;
    }
    if ((this.mUr.getBottom() >= this.ahF + 3) && (getFirstVisiblePosition() == 0))
    {
      AppMethodBeat.o(38370);
      return true;
    }
    AppMethodBeat.o(38370);
    return false;
  }
  
  private void fIN()
  {
    AppMethodBeat.i(38382);
    if (this.mUy != null)
    {
      if (al.isDarkMode())
      {
        i = getResources().getColor(2131099886);
        this.mUy.b(0.0F, i, i);
        this.mUy.a(0.0F, getResources().getColor(2131100196), 0);
        AppMethodBeat.o(38382);
        return;
      }
      int i = getResources().getColor(2131099885);
      this.mUy.b(0.0F, i, i);
      this.mUy.a(0.0F, getResources().getColor(2131100705), 0);
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
      this.KtD = new View(getContext());
      this.KtD.setLayoutParams(new LinearLayout.LayoutParams(-1, i));
      ((LinearLayout)localObject).addView(this.KtD);
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
    this.mPaint.setTextSize(com.tencent.mm.cc.a.ay(getContext(), 2131165498));
    this.Ktb = getResources().getString(2131757429);
    this.Ktc = this.mPaint.measureText(this.Ktb);
    super.setOnScrollListener(this);
    super.setOnTouchListener(this);
    setOverScrollMode(2);
    ad.i("MicroMsg.ConversationListView", "alvinluo HeaderContainer new, ConversationListView: %d", new Object[] { Integer.valueOf(hashCode()) });
    this.mUr = ((d)g.ab(d.class)).dU(paramContext);
    if (this.mUr != null)
    {
      this.mUr.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
      addHeaderView(this.mUr);
      addFooterView(getEmptyFooter());
      this.Kta = ((d)g.ab(d.class)).a(paramContext, this, this.mUr);
      this.Kta.a(this);
      this.mUr.setAnimController(this.Kta);
    }
    this.Ktq = ((int)(com.tencent.mm.cc.a.ay(getContext(), 2131165256) * com.tencent.mm.cc.a.ik(getContext())));
    this.mUx = ar.dT(getContext());
    this.KtC = com.tencent.mm.cc.a.fromDPToPix(paramContext, 100);
    fIH();
    AppMethodBeat.o(38339);
  }
  
  private void setListTopMargin(int paramInt)
  {
    AppMethodBeat.i(38342);
    ad.i("MicroMsg.ConversationListView", "alvinluo initActionBarView statusBarHeight: %d, isInMultiWindowMode: %b, target: %d, actionBarTop: %d", new Object[] { Integer.valueOf(this.mFF), Boolean.valueOf(this.dzB), Integer.valueOf(paramInt), Integer.valueOf(this.ahp.getTop()) });
    if (paramInt >= 0)
    {
      if (this.mUB != null) {
        if (this.dzB) {
          break label128;
        }
      }
      ViewGroup.LayoutParams localLayoutParams;
      label128:
      for (this.mUB.getLayoutParams().height = this.mFF;; this.mUB.getLayoutParams().height = paramInt)
      {
        localLayoutParams = getLayoutParams();
        if (!(localLayoutParams instanceof RelativeLayout.LayoutParams)) {
          break label150;
        }
        if (this.dzB) {
          break;
        }
        ((RelativeLayout.LayoutParams)localLayoutParams).topMargin = this.mFF;
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
    this.KsZ.add(localFixedViewInfo);
    AppMethodBeat.o(38368);
  }
  
  protected void attachViewToParent(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(38346);
    super.attachViewToParent(paramView, paramInt, paramLayoutParams);
    if ((this.ahF <= 0) && (this.Kta != null))
    {
      this.ahF = (ar.dT(getContext()) + al.aL(getContext(), 0));
      this.mUx = ar.dT(getContext());
      fII();
      if (this.mUr != null) {
        this.mUr.setActionBar(this.ahp);
      }
      this.Kta.setActionBar(this.ahp);
      this.Kta.setTabView(getRootView().findViewById(2131301338));
    }
    AppMethodBeat.o(38346);
  }
  
  public final void bCZ()
  {
    AppMethodBeat.i(38354);
    ad.d("MicroMsg.ConversationListView", "[onOpenHeader]");
    this.mUX = true;
    if (this.Kts != null) {
      removeCallbacks(this.Kts);
    }
    AppMethodBeat.o(38354);
  }
  
  public final boolean bCz()
  {
    AppMethodBeat.i(38369);
    if ((fIL()) && (this.mUX))
    {
      AppMethodBeat.o(38369);
      return true;
    }
    AppMethodBeat.o(38369);
    return false;
  }
  
  public final void bDa()
  {
    AppMethodBeat.i(38357);
    bCZ();
    AppMethodBeat.o(38357);
  }
  
  public boolean canScrollHorizontally(int paramInt)
  {
    AppMethodBeat.i(38338);
    if (this.mUr == null)
    {
      boolean bool = super.canScrollHorizontally(paramInt);
      AppMethodBeat.o(38338);
      return bool;
    }
    if (this.mUr.getBottom() >= this.mUr.getHeight())
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
    if ((getFirstVisiblePosition() == 0) && (paramInt2 < 0) && (paramArrayOfInt1 != null) && (paramArrayOfInt1.length >= 2) && (!this.mUX))
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
    if (this.KtB != null) {
      this.KtB.onTouch(this, paramMotionEvent);
    }
    int i;
    boolean bool;
    try
    {
      ad.d("MicroMsg.ConversationListView", "alvinluo dispatchTouchEvent backUpFooterRect: %s, %f, %f, bottom: %d, height: %d, isCanClose: %b", new Object[] { this.mUr.getBackUpFooterRect().toString(), Float.valueOf(paramMotionEvent.getRawX()), Float.valueOf(paramMotionEvent.getRawY()), Integer.valueOf(this.mUr.getBottom()), Integer.valueOf(this.mUr.getHeight()), Boolean.valueOf(this.KtE) });
      int j = (int)(paramMotionEvent.getRawY() - this.mFF);
      i = j;
      if (this.dzB) {
        i = j - this.Kty + this.mFF;
      }
      if ((bCz()) && (this.mUr != null))
      {
        if (paramMotionEvent.getAction() == 0) {
          if (!this.mUr.getBackUpFooterRect().contains((int)paramMotionEvent.getRawX(), i)) {
            break label242;
          }
        }
        label242:
        for (this.KtF = true;; this.KtF = false)
        {
          ad.d("MicroMsg.ConversationListView", "alvinluo dispatchTouchEvent isDownInCloseRect: %b, touchY: %d", new Object[] { Boolean.valueOf(this.KtF), Integer.valueOf(i) });
          if (this.KtF) {
            break;
          }
          bool = this.mUr.dispatchTouchEvent(paramMotionEvent);
          AppMethodBeat.o(38371);
          return bool;
        }
      }
      if (this.mUr == null) {
        break label513;
      }
    }
    catch (Exception paramMotionEvent)
    {
      ad.printErrStackTrace("MicroMsg.ConversationListView", paramMotionEvent, "alvinluo ConversationListView dispatchTouchEvent exception", new Object[0]);
      AppMethodBeat.o(38371);
      return false;
    }
    if ((this.mUr.getBottom() >= this.mUr.getHeight()) && (this.mUr.isFullScreen()) && (getFirstVisiblePosition() == 0))
    {
      if ((paramMotionEvent.getAction() == 0) && (this.mUr.getBackUpFooterRect().contains((int)paramMotionEvent.getRawX(), i))) {
        this.KtE = true;
      }
      while ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
      {
        if (this.KtE)
        {
          this.KtE = false;
          if (this.Kta != null)
          {
            ad.i("MicroMsg.ConversationListView", "alvinluo closeHeader by click BackUpFooterRect");
            this.Kta.vX(12);
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
            this.KtE = false;
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
      if ((this.Kta != null) && (paramMotionEvent.getAction() == 0)) {
        this.Kta.K(paramMotionEvent);
      }
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(38371);
      return bool;
    }
    label513:
    if ((this.KtE) && (paramMotionEvent.getAction() == 1))
    {
      ad.i("MicroMsg.ConversationListView", "alvinluo ConversationListView cancel touch event..., isHeaderOpen: %b, isHeaderVisible: %b", new Object[] { Boolean.valueOf(bCz()), Boolean.valueOf(fIL()) });
      if (bCz()) {
        break label618;
      }
      this.KtE = false;
    }
    for (;;)
    {
      if ((paramMotionEvent.getAction() == 0) && (this.Kta != null) && (paramMotionEvent.getAction() == 0)) {
        this.Kta.K(paramMotionEvent);
      }
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(38371);
      return bool;
      label618:
      paramMotionEvent.setAction(3);
    }
  }
  
  final void fII()
  {
    int i = 1;
    AppMethodBeat.i(194651);
    if (this.ahp == null)
    {
      this.ahp = getRootView().findViewById(2131296345);
      if (this.ahp != null) {
        this.ahp.addOnLayoutChangeListener(this.KtA);
      }
    }
    else
    {
      if ((this.dzB) && (Build.VERSION.SDK_INT >= 24) && (LauncherUI.getInstance() != null))
      {
        this.dzB = LauncherUI.getInstance().isInMultiWindowMode();
        ad.i("MicroMsg.ConversationListView", "alvinluo initActionBarView check multiWindowMode %b", new Object[] { Boolean.valueOf(this.dzB) });
      }
      if ((this.mFF != 0) && ((this.dzB) || (this.ahp.getTop() == this.mFF) || (this.ahp.getTop() == 0))) {
        break label222;
      }
      this.mFF = this.ahp.getTop();
    }
    for (;;)
    {
      if ((i != 0) && (!this.dzB))
      {
        post(new Runnable()
        {
          int hfV = 0;
          
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
              if (this.hfV <= 2)
              {
                ad.i("MicroMsg.ConversationListView", "alvinluo initActionBarView try again tryCount: %d", new Object[] { Integer.valueOf(this.hfV) });
                ConversationListView.this.post(this);
              }
            }
            for (;;)
            {
              this.hfV += 1;
              AppMethodBeat.o(38330);
              return;
              ConversationListView.f(ConversationListView.this);
              continue;
              ConversationListView.b(ConversationListView.this, ConversationListView.e(ConversationListView.this));
              ConversationListView.aet(ConversationListView.e(ConversationListView.this));
            }
          }
        });
        AppMethodBeat.o(194651);
        return;
        AppMethodBeat.o(194651);
        return;
      }
      this.Ktw = this.ahp.getTop();
      setListTopMargin(this.Ktw);
      bj(this.Ktw, false);
      AppMethodBeat.o(194651);
      return;
      label222:
      i = 0;
    }
  }
  
  public final void fIJ()
  {
    AppMethodBeat.i(38353);
    if (this.Kta != null) {
      this.Kta.b(0L, 0, true);
    }
    fIM();
    AppMethodBeat.o(38353);
  }
  
  final void fIM()
  {
    AppMethodBeat.i(38381);
    if (this.ahp != null)
    {
      this.ahp.setTranslationY(0.0F);
      this.ahp.setVisibility(0);
    }
    fIN();
    AppMethodBeat.o(38381);
  }
  
  public int getFirstHeaderVisible()
  {
    AppMethodBeat.i(38367);
    Iterator localIterator = this.KsZ.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject = (ListView.FixedViewInfo)localIterator.next();
      if (((ListView.FixedViewInfo)localObject).view == this.mUr)
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
  
  public final void j(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(38366);
    ad.i("MicroMsg.ConversationListView", "[showAppBrandHeader] isShow:" + paramBoolean1 + " isAnim:" + paramBoolean2 + " isScrollFirst:" + paramBoolean3);
    if (paramBoolean1)
    {
      if (this.Kta != null)
      {
        this.Kta.bCt();
        AppMethodBeat.o(38366);
      }
    }
    else if (this.Kta != null) {
      this.Kta.vX(0);
    }
    AppMethodBeat.o(38366);
  }
  
  final void jV(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(38352);
    if (this.mUy != null)
    {
      this.mUy.a(1.0F, paramInt1, 0);
      this.mUy.b(1.0F, paramInt2, paramInt2);
    }
    AppMethodBeat.o(38352);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(38375);
    super.onAttachedToWindow();
    if (this.Ktz != null) {
      this.Ktz.alive();
    }
    AppMethodBeat.o(38375);
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(38374);
    super.onConfigurationChanged(paramConfiguration);
    ad.i("MicroMsg.ConversationListView", "[onConfigurationChanged] orientation:%s, last: %d", new Object[] { Integer.valueOf(paramConfiguration.orientation), Integer.valueOf(this.gOl) });
    ys(true);
    if (this.Kta != null) {
      this.Kta.iv();
    }
    if (this.mUr != null) {
      this.mUr.e(paramConfiguration);
    }
    if (al.isDarkMode()) {
      jV(getResources().getColor(2131100196), getResources().getColor(2131099886));
    }
    for (;;)
    {
      if (this.Ktu != null) {
        removeCallbacks(this.Ktu);
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
      this.Ktu = paramConfiguration;
      postDelayed(paramConfiguration, 800L);
      this.mUX = false;
      AppMethodBeat.o(38374);
      return;
      jV(getResources().getColor(2131100705), getResources().getColor(2131099885));
    }
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(38376);
    super.onDetachedFromWindow();
    if (this.Ktz != null) {
      this.Ktz.dead();
    }
    AppMethodBeat.o(38376);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(38347);
    super.onDraw(paramCanvas);
    if ((this.mUr != null) && (getFirstVisiblePosition() == 0) && (this.mUr.isFullScreen()) && (this.mUr.getBottom() > 6))
    {
      if (this.Ktd < 30)
      {
        AppMethodBeat.o(38347);
        return;
      }
      this.mPaint.setStyle(Paint.Style.FILL);
      this.mPaint.setColor(getContext().getResources().getColor(2131099930));
      this.mPaint.setAlpha(this.Ktd);
      paramCanvas.drawRect(this.mUr.getBackUpFooterRect().left, this.mUr.getBackUpFooterRect().top + this.Ktx, this.mUr.getBackUpFooterRect().right, this.mUr.getBackUpFooterRect().bottom, this.mPaint);
    }
    AppMethodBeat.o(38347);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(38350);
    try
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      boolean bool = bCz();
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
        ys(false);
      }
      if ((this.Ktv != null) && (this.Ktv.getVisibility() == 0) && (getFirstVisiblePosition() != 0)) {
        this.Ktv.setVisibility(4);
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
    if ((paramInt1 == 0) && (this.mVj))
    {
      localObject = getChildAt(1);
      if (localObject == null) {
        if (bCz())
        {
          i = this.mUr.getMeasuredHeight() - this.mUx;
          ad.i("MicroMsg.ConversationListView", "alvinluo computeActionBarTranslation %d", new Object[] { Integer.valueOf(i) });
          label71:
          i = Math.max(0, i);
          if (this.ahp != null)
          {
            if (Math.abs(i) > this.KtC) {
              break label444;
            }
            this.ahp.setVisibility(0);
            label106:
            ad.v("MicroMsg.ConversationListView", "alvinluo onScroll setTranslationY before: %f, trans: %d", new Object[] { Float.valueOf(this.ahp.getTranslationY()), Integer.valueOf(i) });
            this.ahp.setTranslationY(i);
          }
          if (this.mUr != null)
          {
            localObject = this.mUr;
            this.mUr.getHeight();
            ((HeaderContainer)localObject).es(i, this.mUr.getHeight() - this.mUx);
          }
        }
      }
    }
    for (;;)
    {
      if (this.vkg != null) {
        this.vkg.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
      }
      if (this.Kta != null) {
        this.Kta.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
      }
      if ((paramInt2 > 1) && (fIL()) && (this.mUr != null))
      {
        paramAbsListView = new int[2];
        getLocationOnScreen(paramAbsListView);
        this.Kty = paramAbsListView[1];
        paramInt1 = this.mUr.getBottom() - com.tencent.mm.cc.a.fromDPToPix(getContext(), 56);
        this.mUr.getBackUpFooterRect().set(0, paramInt1, getWidth(), getHeight() + paramInt1);
        ad.d("MicroMsg.ConversationListView", "alvinluo onScroll BackUpFooterRect: %s, headerContainer top: %d, bottom: %d", new Object[] { this.mUr.getBackUpFooterRect().toString(), Integer.valueOf(this.mUr.getTop()), Integer.valueOf(this.mUr.getBottom()) });
        this.Ktd = ((int)(255.0F * this.mUr.getBottom() / this.mUr.getHeight()));
      }
      AppMethodBeat.o(38349);
      return;
      i = 0;
      break;
      i = ((View)localObject).getTop();
      int j = Math.max(paramInt1 - getHeaderViewsCount(), 0);
      i = -(-i + (int)(j * getResources().getDimension(2131165515)) + this.mUx);
      break label71;
      label444:
      this.ahp.setVisibility(4);
      break label106;
      if (paramInt1 > 0) {
        fIM();
      }
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(38348);
    if (this.vkg != null) {
      this.vkg.onScrollStateChanged(paramAbsListView, paramInt);
    }
    if (this.Kta != null) {
      this.Kta.onScrollStateChanged(paramAbsListView, paramInt);
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
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/conversation/ConversationListView", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
    boolean bool2 = this.Kta.onTouch(paramView, paramMotionEvent);
    boolean bool1 = bool2;
    if (this.Cjy != null) {
      bool1 = bool2 | this.Cjy.onTouch(paramView, paramMotionEvent);
    }
    com.tencent.mm.hellhoundlib.a.a.a(bool1, this, "com/tencent/mm/ui/conversation/ConversationListView", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
    AppMethodBeat.o(38345);
    return bool1;
  }
  
  public void setActionBarUpdateCallback(final com.tencent.mm.plugin.appbrand.widget.header.a parama)
  {
    AppMethodBeat.i(38377);
    if (this.Kta != null)
    {
      this.mUy = parama;
      this.Kta.setActionBarUpdateCallback(new com.tencent.mm.plugin.appbrand.widget.header.a()
      {
        public final void a(float paramAnonymousFloat, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(194645);
          if (parama != null) {
            parama.a(paramAnonymousFloat, paramAnonymousInt1, paramAnonymousInt2);
          }
          AppMethodBeat.o(194645);
        }
        
        public final void b(float paramAnonymousFloat, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(194646);
          if (parama != null) {
            parama.b(paramAnonymousFloat, paramAnonymousInt1, paramAnonymousInt2);
          }
          AppMethodBeat.o(194646);
        }
      });
    }
    AppMethodBeat.o(38377);
  }
  
  public void setActivity(MMFragmentActivity paramMMFragmentActivity)
  {
    AppMethodBeat.i(38378);
    this.mWg = paramMMFragmentActivity;
    if (this.mUr != null) {
      this.mUr.setActivity(this.mWg);
    }
    AppMethodBeat.o(38378);
  }
  
  public void setIsCurrentMainUI(boolean paramBoolean)
  {
    AppMethodBeat.i(38380);
    ad.i("MicroMsg.ConversationListView", "alvinluo setIsCurrentMainUI: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.mVj = paramBoolean;
    if (this.Kta != null) {
      this.Kta.setIsCurrentMainUI(paramBoolean);
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
        AppMethodBeat.i(194650);
        ad.i("MicroMsg.ConversationListView", "alvinluo onItemClick isCanClose: %b", new Object[] { Boolean.valueOf(ConversationListView.h(ConversationListView.this)) });
        if ((ConversationListView.j(ConversationListView.this) != null) && (!ConversationListView.h(ConversationListView.this))) {
          ConversationListView.j(ConversationListView.this).onItemClick(paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        }
        AppMethodBeat.o(194650);
      }
    });
    AppMethodBeat.o(38373);
  }
  
  public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener paramOnItemLongClickListener)
  {
    AppMethodBeat.i(38372);
    this.JtZ = paramOnItemLongClickListener;
    super.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(194649);
        ad.i("MicroMsg.ConversationListView", "alvinluo onItemLongClick isCanClose: %b", new Object[] { Boolean.valueOf(ConversationListView.h(ConversationListView.this)) });
        if ((ConversationListView.i(ConversationListView.this) != null) && (!ConversationListView.h(ConversationListView.this)))
        {
          boolean bool = ConversationListView.i(ConversationListView.this).onItemLongClick(paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
          AppMethodBeat.o(194649);
          return bool;
        }
        AppMethodBeat.o(194649);
        return false;
      }
    });
    AppMethodBeat.o(38372);
  }
  
  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.vkg = paramOnScrollListener;
  }
  
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    this.Cjy = paramOnTouchListener;
  }
  
  public void setSelection(int paramInt)
  {
    AppMethodBeat.i(38362);
    ad.i("MicroMsg.ConversationListView", "[setSelection] position:%s, scrollOffset: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.mUx) });
    if (paramInt == 0)
    {
      super.setSelectionFromTop(getFirstHeaderVisible(), this.mUx);
      AppMethodBeat.o(38362);
      return;
    }
    super.setSelectionFromTop(paramInt, this.mUx);
    AppMethodBeat.o(38362);
  }
  
  public void setStatusBarMaskView(View paramView)
  {
    AppMethodBeat.i(38379);
    this.mUB = paramView;
    if (this.Kta != null) {
      this.Kta.setStatusBarMaskView(paramView);
    }
    AppMethodBeat.o(38379);
  }
  
  public void setonDispatchTouchEventListener(View.OnTouchListener paramOnTouchListener)
  {
    this.KtB = paramOnTouchListener;
  }
  
  public void smoothScrollToPosition(int paramInt)
  {
    AppMethodBeat.i(38363);
    ad.i("MicroMsg.ConversationListView", "[smoothScrollToPosition] position:%s", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 0)
    {
      super.smoothScrollToPositionFromTop(getFirstHeaderVisible(), this.mUx);
      AppMethodBeat.o(38363);
      return;
    }
    super.smoothScrollToPositionFromTop(paramInt, this.mUx);
    AppMethodBeat.o(38363);
  }
  
  public void smoothScrollToPositionFromTop(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(38364);
    ad.i("MicroMsg.ConversationListView", "[smoothScrollToPositionFromTop] position:%s offset:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == 0)
    {
      super.smoothScrollToPositionFromTop(getFirstHeaderVisible(), this.mUx + paramInt2);
      AppMethodBeat.o(38364);
      return;
    }
    super.smoothScrollToPositionFromTop(paramInt1, this.mUx + paramInt2);
    AppMethodBeat.o(38364);
  }
  
  public void smoothScrollToPositionFromTop(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(38365);
    ad.i("MicroMsg.ConversationListView", "[smoothScrollToPositionFromTop] position:%s offset:%s duration:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramInt1 == 0)
    {
      super.smoothScrollToPositionFromTop(getFirstHeaderVisible(), this.mUx + paramInt2, paramInt3);
      AppMethodBeat.o(38365);
      return;
    }
    super.smoothScrollToPositionFromTop(paramInt1, this.mUx + paramInt2, paramInt3);
    AppMethodBeat.o(38365);
  }
  
  public final void uP(int paramInt) {}
  
  public final void wc(int paramInt)
  {
    AppMethodBeat.i(38355);
    ad.d("MicroMsg.ConversationListView", "[onCloseHeader]");
    this.KtE = false;
    this.mUX = false;
    this.Ktd = 0;
    if (this.Kts != null) {
      removeCallbacks(this.Kts);
    }
    AppMethodBeat.o(38355);
  }
  
  public final void wd(int paramInt)
  {
    AppMethodBeat.i(38356);
    wc(paramInt);
    AppMethodBeat.o(38356);
  }
  
  final void ys(boolean paramBoolean)
  {
    AppMethodBeat.i(38358);
    if (this.KtD == null)
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
          AppMethodBeat.i(194648);
          ConversationListView.g(ConversationListView.this);
          AppMethodBeat.o(194648);
        }
      }, 0L);
      AppMethodBeat.o(38358);
      return;
    }
    fIK();
    AppMethodBeat.o(38358);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.ConversationListView
 * JD-Core Version:    0.7.0.1
 */
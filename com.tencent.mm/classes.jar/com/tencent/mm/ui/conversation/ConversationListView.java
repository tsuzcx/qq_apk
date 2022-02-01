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
import com.tencent.mm.g.a.mv;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.appbrand.widget.recent.AppBrandRecentView.e;
import com.tencent.mm.plugin.appbrand.widget.recent.l;
import com.tencent.mm.plugin.taskbar.api.HeaderContainer;
import com.tencent.mm.plugin.taskbar.api.b.a;
import com.tencent.mm.plugin.taskbar.api.c;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.au;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class ConversationListView
  extends ListView
  implements View.OnTouchListener, AbsListView.OnScrollListener, AppBrandRecentView.e, b.a
{
  private int DBe;
  private MMFragmentActivity Dpx;
  boolean FSV;
  private com.tencent.mm.plugin.taskbar.api.a FSw;
  private View FSz;
  private boolean FTf;
  private View.OnTouchListener HeV;
  private AdapterView.OnItemLongClickListener OZU;
  private int QcA;
  private Bitmap QcB;
  private RectF QcC;
  private boolean QcD;
  private NinePatchDrawable QcE;
  private Rect QcF;
  private final float QcG;
  private final float QcH;
  private final float QcI;
  private final float QcJ;
  private final float QcK;
  private boolean QcL;
  private final float QcM;
  private int QcN;
  private boolean QcO;
  Runnable QcP;
  Runnable QcQ;
  Runnable QcR;
  View QcS;
  private int QcT;
  private int QcU;
  private int QcV;
  IListener<mv> QcW;
  private View.OnLayoutChangeListener QcX;
  private View.OnTouchListener QcY;
  private int QcZ;
  private LinkedList<ListView.FixedViewInfo> Qcu;
  boolean Qcv;
  private boolean Qcw;
  com.tencent.mm.plugin.taskbar.api.b Qcx;
  private String Qcy;
  private float Qcz;
  View Qda;
  private boolean Qdb;
  private boolean Qdc;
  final com.tencent.mm.kernel.api.g UuW;
  private View ahC;
  private AdapterView.OnItemClickListener awr;
  boolean dSv;
  private int hIX;
  private boolean iCn;
  private int mActionBarHeight;
  private int mCount;
  private Paint mPaint;
  private int mScrollState;
  private int mStatusBarHeight;
  private int ocu;
  HeaderContainer onh;
  private AbsListView.OnScrollListener yQz;
  
  public ConversationListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(38336);
    this.Qcu = new LinkedList();
    this.Qcv = true;
    this.Qcw = false;
    this.mPaint = new Paint(1);
    this.QcB = null;
    this.QcC = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
    this.QcD = false;
    this.QcE = null;
    this.QcF = new Rect();
    this.QcG = com.tencent.mm.cb.a.fromDPToPix(getContext(), 30);
    this.QcH = com.tencent.mm.cb.a.fromDPToPix(getContext(), 8);
    this.QcI = com.tencent.mm.cb.a.fromDPToPix(getContext(), 24);
    this.QcJ = com.tencent.mm.cb.a.fromDPToPix(getContext(), 64);
    this.QcK = 0.5F;
    this.QcL = false;
    this.QcM = com.tencent.mm.cb.a.fromDPToPix(getContext(), 200);
    this.QcN = 0;
    this.FSV = false;
    this.QcO = false;
    this.FSw = null;
    this.QcP = null;
    this.QcQ = null;
    this.QcR = null;
    this.mStatusBarHeight = 0;
    this.QcT = 0;
    this.hIX = 0;
    this.QcU = com.tencent.mm.cb.a.fromDPToPix(getContext(), 56);
    this.FTf = true;
    this.QcV = 0;
    this.dSv = false;
    this.QcW = new IListener() {};
    this.QcX = new View.OnLayoutChangeListener()
    {
      public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
      {
        AppMethodBeat.i(234118);
        Log.i("MicroMsg.ConversationListView", "ActionBarView layout changed, call setupActionBarView()");
        ConversationListView.b(ConversationListView.this);
        AppMethodBeat.o(234118);
      }
    };
    this.UuW = new ConversationListView.12(this);
    this.QcY = null;
    this.QcZ = 0;
    this.Qdc = false;
    init(paramContext);
    AppMethodBeat.o(38336);
  }
  
  public ConversationListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(38337);
    this.Qcu = new LinkedList();
    this.Qcv = true;
    this.Qcw = false;
    this.mPaint = new Paint(1);
    this.QcB = null;
    this.QcC = new RectF(0.0F, 0.0F, 0.0F, 0.0F);
    this.QcD = false;
    this.QcE = null;
    this.QcF = new Rect();
    this.QcG = com.tencent.mm.cb.a.fromDPToPix(getContext(), 30);
    this.QcH = com.tencent.mm.cb.a.fromDPToPix(getContext(), 8);
    this.QcI = com.tencent.mm.cb.a.fromDPToPix(getContext(), 24);
    this.QcJ = com.tencent.mm.cb.a.fromDPToPix(getContext(), 64);
    this.QcK = 0.5F;
    this.QcL = false;
    this.QcM = com.tencent.mm.cb.a.fromDPToPix(getContext(), 200);
    this.QcN = 0;
    this.FSV = false;
    this.QcO = false;
    this.FSw = null;
    this.QcP = null;
    this.QcQ = null;
    this.QcR = null;
    this.mStatusBarHeight = 0;
    this.QcT = 0;
    this.hIX = 0;
    this.QcU = com.tencent.mm.cb.a.fromDPToPix(getContext(), 56);
    this.FTf = true;
    this.QcV = 0;
    this.dSv = false;
    this.QcW = new IListener() {};
    this.QcX = new View.OnLayoutChangeListener()
    {
      public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
      {
        AppMethodBeat.i(234118);
        Log.i("MicroMsg.ConversationListView", "ActionBarView layout changed, call setupActionBarView()");
        ConversationListView.b(ConversationListView.this);
        AppMethodBeat.o(234118);
      }
    };
    this.UuW = new ConversationListView.12(this);
    this.QcY = null;
    this.QcZ = 0;
    this.Qdc = false;
    init(paramContext);
    AppMethodBeat.o(38337);
  }
  
  private float anM(int paramInt)
  {
    AppMethodBeat.i(38361);
    int i = (int)getResources().getDimension(2131165533);
    int j = getHeaderViewsCount();
    int k = getFooterViewsCount();
    float f = getMeasuredHeight() - i * (paramInt - j - k) - au.eu(getContext()) - au.getStatusBarHeight(getContext());
    Log.d("MicroMsg.ConversationListView", "alvinluo isFullScreen getMeasuredHeight: %d", new Object[] { Integer.valueOf(getMeasuredHeight()) });
    Log.i("MicroMsg.ConversationListView", "[isFullScreen] totalItemCount:" + paramInt + " getFirstVisiblePosition:" + getFirstVisiblePosition() + " getLastVisiblePosition:" + getLastVisiblePosition() + " getHeaderViewsCount:" + getHeaderViewsCount() + " getFooterViewsCount:" + getFooterViewsCount() + " extraHeight:" + f);
    AppMethodBeat.o(38361);
    return f;
  }
  
  private static void bN(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(38343);
    Log.i("MicroMsg.ConversationListView", "alvinluo saveTopMargin topMargin: %d, needRead: %b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    Object localObject = MMApplicationContext.getDefaultPreference();
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      if (localObject != null)
      {
        ((SharedPreferences.Editor)localObject).putBoolean("Main_need_read_top_margin", paramBoolean);
        ((SharedPreferences.Editor)localObject).putInt("Main_top_marign", paramInt);
        ((SharedPreferences.Editor)localObject).apply();
        Log.i("MicroMsg.ConversationListView", "alvinluo saveTopMargin success");
      }
    }
    AppMethodBeat.o(38343);
  }
  
  private void gVA()
  {
    AppMethodBeat.i(38382);
    if (this.FSw != null)
    {
      if (ao.isDarkMode())
      {
        i = getResources().getColor(2131099904);
        this.FSw.g(0.0F, i, i);
        this.FSw.f(0.0F, getResources().getColor(2131100229), 0);
        AppMethodBeat.o(38382);
        return;
      }
      int i = getResources().getColor(2131099903);
      this.FSw.g(0.0F, i, i);
      this.FSw.f(0.0F, getResources().getColor(2131100898), 0);
    }
    AppMethodBeat.o(38382);
  }
  
  private void gVr()
  {
    int j = 0;
    AppMethodBeat.i(234124);
    if (this.onh != null)
    {
      ArrayList localArrayList = getHeaderViewList();
      Log.i("MicroMsg.ConversationListView", "removeHeaderViewList size: %d", new Object[] { Integer.valueOf(localArrayList.size()) });
      int i = 0;
      while (i < localArrayList.size())
      {
        View localView = (View)localArrayList.get(i);
        if (localView != null) {
          removeHeaderView(localView);
        }
        i += 1;
      }
      addHeaderView(this.onh);
      localArrayList.remove(this.onh);
      Log.i("MicroMsg.ConversationListView", "addHeaderViewList addViewList: %d", new Object[] { Integer.valueOf(localArrayList.size()) });
      i = j;
      while (i < localArrayList.size())
      {
        addHeaderView((View)localArrayList.get(i));
        i += 1;
      }
      gVu();
    }
    AppMethodBeat.o(234124);
  }
  
  private void gVs()
  {
    AppMethodBeat.i(234125);
    if (this.onh != null)
    {
      removeHeaderView(this.onh);
      gVu();
    }
    AppMethodBeat.o(234125);
  }
  
  private void gVt()
  {
    AppMethodBeat.i(38340);
    if ((Build.VERSION.SDK_INT >= 24) && (LauncherUI.getInstance() != null))
    {
      this.dSv = LauncherUI.getInstance().isInMultiWindowMode();
      if (this.onh != null) {
        this.onh.wn(this.dSv);
      }
    }
    AppMethodBeat.o(38340);
  }
  
  private void gVv()
  {
    AppMethodBeat.i(234129);
    int i = au.getStatusBarHeight(getContext());
    Log.i("MicroMsg.ConversationListView", "updateScrollOffset %d %d", new Object[] { Integer.valueOf(i), Integer.valueOf(this.mStatusBarHeight) });
    if (this.mStatusBarHeight <= 0) {
      if (this.dSv) {
        break label111;
      }
    }
    label111:
    for (this.DBe = (i + au.eu(getContext()));; this.DBe = au.eu(getContext()))
    {
      if ((this.Qcv) && (this.Qcx != null)) {
        this.Qcx.abv(this.DBe);
      }
      AppMethodBeat.o(234129);
      return;
      i = this.mStatusBarHeight;
      break;
    }
  }
  
  private void gVx()
  {
    AppMethodBeat.i(38359);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.Qda.getLayoutParams();
    int i;
    float f2;
    boolean bool;
    label42:
    int k;
    int m;
    label149:
    int j;
    float f1;
    if (getAdapter() == null)
    {
      i = 0;
      f2 = anM(i);
      if (f2 >= 0.0F) {
        break label312;
      }
      bool = true;
      k = localLayoutParams.height;
      Log.i("MicroMsg.ConversationListView", "[checkEmptyFooter] isRealFull:" + bool + " old height:" + k);
      View localView = getRootView().findViewById(2131303053);
      if (localView != null) {
        Log.i("MicroMsg.ConversationListView", "alvinluo checkEmptyFooter tabView Height: %d", new Object[] { Integer.valueOf(localView.getHeight()) });
      }
      m = (int)getResources().getDimension(2131165533);
      if (localView == null) {
        break label318;
      }
      i = localView.getHeight();
      j = i;
      if (i <= 0) {
        j = this.QcN;
      }
      Log.d("MicroMsg.ConversationListView", "alvinluo checkEmptyFooter tabHeight: %d", new Object[] { Integer.valueOf(j) });
      if (!bool) {
        break label323;
      }
      localLayoutParams.height = j;
      f1 = f2;
    }
    for (;;)
    {
      if (k != localLayoutParams.height)
      {
        Log.i("MicroMsg.ConversationListView", "alvinluo checkEmptyFooter isHeaderOpen: %b", new Object[] { Boolean.valueOf(esy()) });
        if (((!bool) || (Math.abs(f1) <= j + m)) && (!esy()))
        {
          Log.i("MicroMsg.ConversationListView", "[checkEmptyFooter] setSelection");
          setSelection(1);
          if (this.Qcx != null) {
            this.Qcx.wk(true);
          }
        }
        this.Qda.requestLayout();
      }
      AppMethodBeat.o(38359);
      return;
      i = getAdapter().getCount();
      break;
      label312:
      bool = false;
      break label42;
      label318:
      i = 0;
      break label149;
      label323:
      f1 = f2;
      if (f2 < j) {
        f1 = j;
      }
      localLayoutParams.height = ((int)f1);
    }
  }
  
  private boolean gVy()
  {
    AppMethodBeat.i(38370);
    if (this.onh == null)
    {
      AppMethodBeat.o(38370);
      return false;
    }
    if ((this.onh.getBottom() >= this.mActionBarHeight + 3) && (getFirstVisiblePosition() == 0))
    {
      AppMethodBeat.o(38370);
      return true;
    }
    AppMethodBeat.o(38370);
    return false;
  }
  
  private View getEmptyFooter()
  {
    AppMethodBeat.i(38360);
    Object localObject = getRootView().findViewById(2131303053);
    int j = (int)getResources().getDimension(2131165533);
    int i;
    if (localObject != null)
    {
      i = ((View)localObject).getHeight();
      if (i > 0) {
        break label125;
      }
      i = j;
    }
    label125:
    for (;;)
    {
      localObject = new LinearLayout(getContext());
      this.Qda = new View(getContext());
      this.Qda.setLayoutParams(new LinearLayout.LayoutParams(-1, i));
      ((LinearLayout)localObject).addView(this.Qda);
      ((LinearLayout)localObject).setBackgroundColor(getContext().getResources().getColor(2131099650));
      AppMethodBeat.o(38360);
      return localObject;
      i = 0;
      break;
    }
  }
  
  private ArrayList<View> getHeaderViewList()
  {
    AppMethodBeat.i(234133);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.Qcu.size())
    {
      ListView.FixedViewInfo localFixedViewInfo = (ListView.FixedViewInfo)this.Qcu.get(i);
      if ((localFixedViewInfo != null) && (localFixedViewInfo.view != null)) {
        localArrayList.add(localFixedViewInfo.view);
      }
      i += 1;
    }
    AppMethodBeat.o(234133);
    return localArrayList;
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
    this.mPaint.setTextSize(com.tencent.mm.cb.a.aH(getContext(), 2131165516));
    this.Qcy = getResources().getString(2131757647);
    this.Qcz = this.mPaint.measureText(this.Qcy);
    super.setOnScrollListener(this);
    super.setOnTouchListener(this);
    setOverScrollMode(2);
    Log.i("MicroMsg.ConversationListView", "alvinluo HeaderContainer new, ConversationListView: %d", new Object[] { Integer.valueOf(hashCode()) });
    cau();
    Cv(false);
    if ((bg.aAc()) && (com.tencent.mm.kernel.g.aAf().hpY))
    {
      Log.i("MicroMsg.ConversationListView", "account initialized, initHeaderContainer");
      kq(paramContext);
    }
    for (;;)
    {
      addFooterView(getEmptyFooter());
      this.QcN = ((int)(com.tencent.mm.cb.a.aH(getContext(), 2131165260) * com.tencent.mm.cb.a.ji(getContext())));
      this.DBe = (au.eu(getContext()) + au.getStatusBarHeight(getContext()));
      this.QcZ = com.tencent.mm.cb.a.fromDPToPix(paramContext, 100);
      gVt();
      AppMethodBeat.o(38339);
      return;
      Log.i("MicroMsg.ConversationListView", "account not initialized, add callback");
      com.tencent.mm.kernel.g.aAi().a(this.UuW);
    }
  }
  
  private void lm(int paramInt1, int paramInt2)
  {
    int j = 0;
    AppMethodBeat.i(234128);
    Log.i("MicroMsg.ConversationListView", "alvinluo initActionBarView statusBarHeight: %d, isInMultiWindowMode: %b, target: %d, actionBarTop: %d, actionBarHeight: %d", new Object[] { Integer.valueOf(this.mStatusBarHeight), Boolean.valueOf(this.dSv), Integer.valueOf(paramInt1), Integer.valueOf(this.ahC.getTop()), Integer.valueOf(paramInt2) });
    Object localObject;
    int i;
    if (paramInt1 >= 0)
    {
      if (this.FSz != null)
      {
        if (this.dSv) {
          break label180;
        }
        localObject = this.FSz.getLayoutParams();
        int k = this.mStatusBarHeight;
        if (!this.Qcv) {
          break label175;
        }
        i = 0;
        ((ViewGroup.LayoutParams)localObject).height = (i + k);
      }
      label120:
      localObject = getLayoutParams();
      if ((localObject instanceof RelativeLayout.LayoutParams))
      {
        if (this.dSv) {
          break label199;
        }
        localObject = (RelativeLayout.LayoutParams)localObject;
        if (!this.Qcv) {
          break label194;
        }
        paramInt1 = j;
      }
    }
    label158:
    label175:
    label180:
    label194:
    label199:
    for (((RelativeLayout.LayoutParams)localObject).topMargin = paramInt1;; ((RelativeLayout.LayoutParams)localObject).topMargin = paramInt1)
    {
      gVv();
      AppMethodBeat.o(234128);
      return;
      i = paramInt2;
      break;
      this.FSz.getLayoutParams().height = paramInt1;
      break label120;
      paramInt1 = paramInt2;
      break label158;
    }
  }
  
  final void Cv(boolean paramBoolean)
  {
    AppMethodBeat.i(234126);
    boolean bool = this.Qcv;
    this.Qcv = true;
    Log.i("MicroMsg.ConversationListView", "updateHeaderContainer showHeaderContainer: %b, last: %b, updateView: %b, isHeaderContainerAdded: %b", new Object[] { Boolean.valueOf(this.Qcv), Boolean.valueOf(bool), Boolean.valueOf(paramBoolean), Boolean.valueOf(this.Qcw) });
    if (!paramBoolean)
    {
      AppMethodBeat.o(234126);
      return;
    }
    if (bool != this.Qcv) {
      if (this.Qcv)
      {
        if (!this.Qcw)
        {
          gVr();
          this.Qcw = true;
          i(200L, 0, true);
          AppMethodBeat.o(234126);
        }
      }
      else if (this.Qcw)
      {
        gVs();
        this.Qcw = false;
        setSelection(0);
      }
    }
    AppMethodBeat.o(234126);
  }
  
  final void Cw(boolean paramBoolean)
  {
    AppMethodBeat.i(38358);
    if (this.Qda == null)
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
          AppMethodBeat.i(258299);
          ConversationListView.f(ConversationListView.this);
          AppMethodBeat.o(258299);
        }
      }, 0L);
      AppMethodBeat.o(38358);
      return;
    }
    gVx();
    AppMethodBeat.o(38358);
  }
  
  public void addHeaderView(View paramView, Object paramObject, boolean paramBoolean)
  {
    AppMethodBeat.i(38368);
    super.addHeaderView(paramView, paramObject, paramBoolean);
    ListView.FixedViewInfo localFixedViewInfo = new ListView.FixedViewInfo(this);
    localFixedViewInfo.view = paramView;
    localFixedViewInfo.data = paramObject;
    localFixedViewInfo.isSelectable = paramBoolean;
    this.Qcu.add(localFixedViewInfo);
    AppMethodBeat.o(38368);
  }
  
  protected void attachViewToParent(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(38346);
    super.attachViewToParent(paramView, paramInt, paramLayoutParams);
    if ((this.mActionBarHeight <= 0) && (this.Qcx != null))
    {
      this.mActionBarHeight = (au.eu(getContext()) + au.D(getContext(), 0));
      this.DBe = (au.eu(getContext()) + au.getStatusBarHeight(getContext()));
      gVu();
      if (this.onh != null) {
        this.onh.setActionBar(this.ahC);
      }
      this.Qcx.setActionBar(this.ahC);
      this.Qcx.setTabView(getRootView().findViewById(2131303053));
    }
    AppMethodBeat.o(38346);
  }
  
  public final void caB()
  {
    AppMethodBeat.i(38354);
    Log.d("MicroMsg.ConversationListView", "[onOpenHeader]");
    this.FSV = true;
    if (this.QcP != null) {
      removeCallbacks(this.QcP);
    }
    if (this.FSw != null) {
      this.FSw.Fg(false);
    }
    AppMethodBeat.o(38354);
  }
  
  public final void caC()
  {
    AppMethodBeat.i(38357);
    caB();
    AppMethodBeat.o(38357);
  }
  
  public boolean canScrollHorizontally(int paramInt)
  {
    AppMethodBeat.i(38338);
    if (this.onh == null)
    {
      boolean bool = super.canScrollHorizontally(paramInt);
      AppMethodBeat.o(38338);
      return bool;
    }
    if (this.onh.getBottom() >= this.onh.getHeight())
    {
      AppMethodBeat.o(38338);
      return true;
    }
    AppMethodBeat.o(38338);
    return false;
  }
  
  final void cau()
  {
    AppMethodBeat.i(234122);
    this.iCn = ((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.teenmode.a.b.class)).Vt();
    this.ocu = ((com.tencent.mm.plugin.teenmode.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.teenmode.a.b.class)).fvp();
    Log.d("MicroMsg.ConversationListView", "updateTeenModeStatus isTeenMode: %b, miniProgramOption: %d", new Object[] { Boolean.valueOf(this.iCn), Integer.valueOf(this.ocu) });
    AppMethodBeat.o(234122);
  }
  
  public boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    AppMethodBeat.i(38344);
    if ((getFirstVisiblePosition() == 0) && (paramInt2 < 0) && (paramArrayOfInt1 != null) && (paramArrayOfInt1.length >= 2) && (!this.FSV))
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
    if (this.QcY != null) {
      this.QcY.onTouch(this, paramMotionEvent);
    }
    int i;
    boolean bool;
    try
    {
      Log.d("MicroMsg.ConversationListView", "alvinluo dispatchTouchEvent backUpFooterRect: %s, %f, %f, bottom: %d, height: %d, isCanClose: %b", new Object[] { this.onh.getBackUpFooterRect().toString(), Float.valueOf(paramMotionEvent.getRawX()), Float.valueOf(paramMotionEvent.getRawY()), Integer.valueOf(this.onh.getBottom()), Integer.valueOf(this.onh.getHeight()), Boolean.valueOf(this.Qdb) });
      int j = (int)paramMotionEvent.getRawY();
      i = j;
      if (this.dSv) {
        i = j - this.QcV + this.mStatusBarHeight;
      }
      if ((esy()) && (this.onh != null))
      {
        if (paramMotionEvent.getAction() == 0) {
          if (!this.onh.getBackUpFooterRect().contains((int)paramMotionEvent.getRawX(), i)) {
            break label236;
          }
        }
        label236:
        for (this.Qdc = true;; this.Qdc = false)
        {
          Log.d("MicroMsg.ConversationListView", "alvinluo dispatchTouchEvent isDownInCloseRect: %b, touchY: %d", new Object[] { Boolean.valueOf(this.Qdc), Integer.valueOf(i) });
          if (this.Qdc) {
            break;
          }
          bool = this.onh.dispatchTouchEvent(paramMotionEvent);
          AppMethodBeat.o(38371);
          return bool;
        }
      }
      if (this.onh == null) {
        break label507;
      }
    }
    catch (Exception paramMotionEvent)
    {
      Log.printErrStackTrace("MicroMsg.ConversationListView", paramMotionEvent, "alvinluo ConversationListView dispatchTouchEvent exception", new Object[0]);
      AppMethodBeat.o(38371);
      return false;
    }
    if ((this.onh.getBottom() >= this.onh.getHeight()) && (this.onh.isFullScreen()) && (getFirstVisiblePosition() == 0))
    {
      if ((paramMotionEvent.getAction() == 0) && (this.onh.getBackUpFooterRect().contains((int)paramMotionEvent.getRawX(), i))) {
        this.Qdb = true;
      }
      while ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
      {
        if (this.Qdb)
        {
          this.Qdb = false;
          if (this.Qcx != null)
          {
            Log.i("MicroMsg.ConversationListView", "alvinluo closeHeader by click BackUpFooterRect");
            this.Qcx.abu(12);
          }
          if (paramMotionEvent.getAction() == 1)
          {
            Log.i("MicroMsg.ConversationListView", "alvinluo ConversationListView cancel touch event");
            paramMotionEvent.setAction(3);
            bool = super.dispatchTouchEvent(paramMotionEvent);
            AppMethodBeat.o(38371);
            return bool;
            if (paramMotionEvent.getAction() != 0) {
              continue;
            }
            this.Qdb = false;
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
      if ((this.Qcx != null) && (paramMotionEvent.getAction() == 0)) {
        this.Qcx.ac(paramMotionEvent);
      }
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(38371);
      return bool;
    }
    label507:
    if ((this.Qdb) && (paramMotionEvent.getAction() == 1))
    {
      Log.i("MicroMsg.ConversationListView", "alvinluo ConversationListView cancel touch event..., isHeaderOpen: %b, isHeaderVisible: %b", new Object[] { Boolean.valueOf(esy()), Boolean.valueOf(gVy()) });
      if (esy()) {
        break label612;
      }
      this.Qdb = false;
    }
    for (;;)
    {
      if ((paramMotionEvent.getAction() == 0) && (this.Qcx != null) && (paramMotionEvent.getAction() == 0)) {
        this.Qcx.ac(paramMotionEvent);
      }
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(38371);
      return bool;
      label612:
      paramMotionEvent.setAction(3);
    }
  }
  
  public final void eG(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(234131);
    Log.d("MicroMsg.ConversationListView", "[onCloseHeader]");
    this.Qdb = false;
    this.FSV = false;
    this.QcA = 0;
    if (this.QcP != null) {
      removeCallbacks(this.QcP);
    }
    if (this.FSw != null) {
      this.FSw.Fg(true);
    }
    AppMethodBeat.o(234131);
  }
  
  public final boolean esy()
  {
    AppMethodBeat.i(38369);
    if ((gVy()) && (this.FSV))
    {
      AppMethodBeat.o(38369);
      return true;
    }
    AppMethodBeat.o(38369);
    return false;
  }
  
  final void gVu()
  {
    int i = 1;
    AppMethodBeat.i(234127);
    final int j;
    if (this.ahC == null)
    {
      this.ahC = getRootView().findViewById(2131296366);
      if (this.ahC != null) {
        this.ahC.addOnLayoutChangeListener(this.QcX);
      }
    }
    else
    {
      if ((this.dSv) && (Build.VERSION.SDK_INT >= 24) && (LauncherUI.getInstance() != null))
      {
        this.dSv = LauncherUI.getInstance().isInMultiWindowMode();
        Log.i("MicroMsg.ConversationListView", "alvinluo initActionBarView check multiWindowMode %b", new Object[] { Boolean.valueOf(this.dSv) });
      }
      j = h.eu(getContext());
      if ((this.mStatusBarHeight != 0) && ((this.dSv) || (this.ahC.getTop() == this.mStatusBarHeight) || (this.ahC.getTop() == 0))) {
        break label232;
      }
      this.mStatusBarHeight = this.ahC.getTop();
    }
    for (;;)
    {
      if ((i != 0) && (!this.dSv))
      {
        post(new Runnable()
        {
          int ibG = 0;
          
          public final void run()
          {
            AppMethodBeat.i(38331);
            if (ConversationListView.d(ConversationListView.this) == null)
            {
              AppMethodBeat.o(38331);
              return;
            }
            if (ConversationListView.d(ConversationListView.this).getTop() != 0) {
              ConversationListView.a(ConversationListView.this, ConversationListView.d(ConversationListView.this).getTop());
            }
            if (ConversationListView.e(ConversationListView.this) <= 0) {
              if (this.ibG <= 2)
              {
                Log.i("MicroMsg.ConversationListView", "alvinluo initActionBarView try again tryCount: %d", new Object[] { Integer.valueOf(this.ibG) });
                ConversationListView.this.post(this);
              }
            }
            for (;;)
            {
              this.ibG += 1;
              AppMethodBeat.o(38331);
              return;
              ConversationListView.b(ConversationListView.this, j);
              continue;
              ConversationListView.a(ConversationListView.this, ConversationListView.e(ConversationListView.this), j);
              ConversationListView.anN(ConversationListView.e(ConversationListView.this));
            }
          }
        });
        AppMethodBeat.o(234127);
        return;
        AppMethodBeat.o(234127);
        return;
      }
      this.QcT = this.ahC.getTop();
      lm(this.QcT, j);
      bN(this.QcT, false);
      AppMethodBeat.o(234127);
      return;
      label232:
      i = 0;
    }
  }
  
  public final void gVw()
  {
    AppMethodBeat.i(38353);
    if ((this.Qcv) && (this.Qcx != null)) {
      this.Qcx.i(0L, 0, true);
    }
    gVz();
    AppMethodBeat.o(38353);
  }
  
  final void gVz()
  {
    AppMethodBeat.i(38381);
    if (this.ahC != null)
    {
      this.ahC.setTranslationY(0.0F);
      this.ahC.setVisibility(0);
    }
    gVA();
    AppMethodBeat.o(38381);
  }
  
  public int getFirstHeaderVisible()
  {
    AppMethodBeat.i(38367);
    Iterator localIterator = this.Qcu.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject = (ListView.FixedViewInfo)localIterator.next();
      if (((ListView.FixedViewInfo)localObject).view == this.onh)
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
            Log.i("MicroMsg.ConversationListView", "[getFirstHeaderVisible] index:%s", new Object[] { Integer.valueOf(i) });
            AppMethodBeat.o(38367);
            return i;
          }
        }
        i += 1;
      }
    }
    Log.i("MicroMsg.ConversationListView", "[getFirstHeaderVisible] index:%s", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(38367);
    return i;
  }
  
  public boolean getShowHeaderContainer()
  {
    return this.Qcv;
  }
  
  public final void i(long paramLong, final int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(234130);
    Log.i("MicroMsg.ConversationListView", "[closeHeader] delay:%s, type: %d, forceClose: %b", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    if ((getFirstVisiblePosition() != 0) && (!paramBoolean))
    {
      AppMethodBeat.o(234130);
      return;
    }
    if (paramLong > 0L)
    {
      if (this.QcQ != null) {
        removeCallbacks(this.QcQ);
      }
      this.QcQ = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(234119);
          ConversationListView localConversationListView = ConversationListView.this;
          int i = paramInt;
          if ((localConversationListView.Qcv) && (localConversationListView.Qcx != null)) {
            localConversationListView.Qcx.abu(i);
          }
          AppMethodBeat.o(234119);
        }
      };
      postDelayed(this.QcQ, paramLong);
      AppMethodBeat.o(234130);
      return;
    }
    setSelection(0);
    AppMethodBeat.o(234130);
  }
  
  public final void kq(Context paramContext)
  {
    AppMethodBeat.i(234123);
    if (com.tencent.mm.kernel.g.af(l.class) == null)
    {
      Log.e("MicroMsg.ConversationListView", "alvinluo initHeaderContainer service is null");
      AppMethodBeat.o(234123);
      return;
    }
    if (this.onh != null)
    {
      AppMethodBeat.o(234123);
      return;
    }
    Log.i("MicroMsg.ConversationListView", "do initHeaderContainer");
    this.onh = ((c)com.tencent.mm.kernel.g.af(c.class)).hn(paramContext);
    if (this.onh != null)
    {
      this.onh.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
      this.Qcx = ((c)com.tencent.mm.kernel.g.af(c.class)).a(paramContext, this, this.onh);
      this.Qcx.a(this);
      this.onh.setAnimController(this.Qcx);
      if (this.Qcv)
      {
        this.Qcw = true;
        addHeaderView(this.onh);
      }
    }
    AppMethodBeat.o(234123);
  }
  
  final void ln(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(38352);
    if (this.FSw != null)
    {
      this.FSw.f(1.0F, paramInt1, 0);
      this.FSw.g(1.0F, paramInt2, paramInt2);
    }
    AppMethodBeat.o(38352);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(38375);
    super.onAttachedToWindow();
    if (this.QcW != null) {
      this.QcW.alive();
    }
    AppMethodBeat.o(38375);
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(38374);
    super.onConfigurationChanged(paramConfiguration);
    Log.i("MicroMsg.ConversationListView", "[onConfigurationChanged] orientation:%s, last: %d", new Object[] { Integer.valueOf(paramConfiguration.orientation), Integer.valueOf(this.hIX) });
    Cw(true);
    gVv();
    if ((this.Qcv) && (this.Qcx != null)) {
      this.Qcx.iE();
    }
    if (this.onh != null) {
      this.onh.f(paramConfiguration);
    }
    if (this.FSw != null) {
      this.FSw.Fg(true);
    }
    if (this.QcR != null) {
      removeCallbacks(this.QcR);
    }
    paramConfiguration = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(38329);
        if (ao.isDarkMode()) {
          ConversationListView.b(ConversationListView.this, ConversationListView.this.getResources().getColor(2131100229), ConversationListView.this.getResources().getColor(2131099904));
        }
        for (;;)
        {
          ConversationListView.j(ConversationListView.this).fuz();
          ConversationListView.c(ConversationListView.this).fuA();
          ConversationListView.this.setSelection(1);
          ConversationListView.k(ConversationListView.this);
          AppMethodBeat.o(38329);
          return;
          ConversationListView.b(ConversationListView.this, ConversationListView.this.getResources().getColor(2131100898), ConversationListView.this.getResources().getColor(2131099903));
        }
      }
    };
    this.QcR = paramConfiguration;
    postDelayed(paramConfiguration, 800L);
    this.FSV = false;
    AppMethodBeat.o(38374);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(38376);
    super.onDetachedFromWindow();
    if (this.QcW != null) {
      this.QcW.dead();
    }
    AppMethodBeat.o(38376);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(38347);
    super.onDraw(paramCanvas);
    if ((this.onh != null) && (getFirstVisiblePosition() == 0) && (this.onh.isFullScreen()) && (this.onh.getBottom() > 6))
    {
      if (this.QcA < 30)
      {
        AppMethodBeat.o(38347);
        return;
      }
      this.mPaint.setStyle(Paint.Style.FILL);
      this.mPaint.setColor(getContext().getResources().getColor(2131099949));
      this.mPaint.setAlpha(this.QcA);
      paramCanvas.drawRect(this.onh.getBackUpFooterRect().left, this.onh.getBackUpFooterRect().top + this.QcU, this.onh.getBackUpFooterRect().right, this.onh.getBackUpFooterRect().bottom, this.mPaint);
    }
    AppMethodBeat.o(38347);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(38350);
    try
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      boolean bool = esy();
      Log.i("MicroMsg.ConversationListView", "[onLayout] changed:%s, isHeaderOpen: %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) });
      Log.d("MicroMsg.ConversationListView", "[onLayout] top: %d, bottom: %d, height: %d, count: %d, realCount: %d, hashCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt4), Integer.valueOf(paramInt4 - paramInt2), Integer.valueOf(this.mCount), Integer.valueOf(getRealCount()), Integer.valueOf(hashCode()) });
      if ((paramBoolean) && (!bool))
      {
        setSelection(1);
        post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(38332);
            ConversationListView.this.setSelection(1);
            AppMethodBeat.o(38332);
          }
        });
      }
      if ((paramBoolean) || ((this.mCount < 16) && (getRealCount() != this.mCount))) {
        Cw(false);
      }
      this.mCount = getRealCount();
      AppMethodBeat.o(38350);
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.ConversationListView", localException, "alvinluo onLayout exception", new Object[0]);
      AppMethodBeat.o(38350);
    }
  }
  
  public void onNestedScroll(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(38349);
    Object localObject;
    int i;
    if ((this.Qcv) && (paramInt1 == 0) && (this.FTf))
    {
      localObject = getChildAt(1);
      if (localObject == null) {
        if (esy())
        {
          i = this.onh.getMeasuredHeight() - this.DBe;
          Log.i("MicroMsg.ConversationListView", "alvinluo computeActionBarTranslation %d", new Object[] { Integer.valueOf(i) });
          label78:
          i = Math.max(0, i);
          if (this.ahC != null)
          {
            Log.v("MicroMsg.ConversationListView", "alvinluo onScroll setTranslationY before: %f, trans: %d", new Object[] { Float.valueOf(this.ahC.getTranslationY()), Integer.valueOf(i) });
            this.ahC.setTranslationY(i);
          }
          if ((this.Qcv) && (this.onh != null))
          {
            localObject = this.onh;
            this.onh.getHeight();
            ((HeaderContainer)localObject).jh(i, this.onh.getHeight() - this.DBe);
          }
        }
      }
    }
    for (;;)
    {
      if (this.yQz != null) {
        this.yQz.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
      }
      if ((this.Qcv) && (this.Qcx != null)) {
        this.Qcx.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
      }
      if ((this.Qcv) && (paramInt2 > 1) && (gVy()) && (this.onh != null))
      {
        paramAbsListView = new int[2];
        getLocationOnScreen(paramAbsListView);
        this.QcV = paramAbsListView[1];
        paramInt1 = this.onh.getBottom() - com.tencent.mm.cb.a.fromDPToPix(getContext(), 56);
        this.onh.getBackUpFooterRect().set(0, paramInt1, getWidth(), getHeight() + paramInt1);
        Log.d("MicroMsg.ConversationListView", "alvinluo onScroll BackUpFooterRect: %s, headerContainer top: %d, bottom: %d", new Object[] { this.onh.getBackUpFooterRect().toString(), Integer.valueOf(this.onh.getTop()), Integer.valueOf(this.onh.getBottom()) });
        this.QcA = ((int)(255.0F * this.onh.getBottom() / this.onh.getHeight()));
      }
      AppMethodBeat.o(38349);
      return;
      i = 0;
      break;
      i = ((View)localObject).getTop();
      int j = Math.max(paramInt1 - getHeaderViewsCount(), 0);
      i = -(-i + (int)(j * getResources().getDimension(2131165533)) + this.DBe);
      break label78;
      if (paramInt1 > 0) {
        gVz();
      }
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(38348);
    if (this.yQz != null) {
      this.yQz.onScrollStateChanged(paramAbsListView, paramInt);
    }
    if ((this.Qcx != null) && (this.Qcv)) {
      this.Qcx.onScrollStateChanged(paramAbsListView, paramInt);
    }
    this.mScrollState = paramInt;
    AppMethodBeat.o(38348);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(38345);
    if ((this.Qcv) && (this.Qcx.onTouch(paramView, paramMotionEvent))) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = bool1;
      if (this.HeV != null) {
        bool2 = bool1 | this.HeV.onTouch(paramView, paramMotionEvent);
      }
      AppMethodBeat.o(38345);
      return bool2;
    }
  }
  
  public final void q(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(38366);
    Log.i("MicroMsg.ConversationListView", "[showAppBrandHeader] isShow:" + paramBoolean1 + " isAnim:" + paramBoolean2 + " isScrollFirst:" + paramBoolean3);
    if (paramBoolean1)
    {
      if ((this.Qcv) && (this.Qcx != null))
      {
        this.Qcx.fux();
        AppMethodBeat.o(38366);
      }
    }
    else if ((this.Qcv) && (this.Qcx != null)) {
      this.Qcx.abu(0);
    }
    AppMethodBeat.o(38366);
  }
  
  public boolean removeHeaderView(View paramView)
  {
    AppMethodBeat.i(234132);
    int i = 0;
    if (i < this.Qcu.size())
    {
      ListView.FixedViewInfo localFixedViewInfo = (ListView.FixedViewInfo)this.Qcu.get(i);
      if ((localFixedViewInfo == null) || (localFixedViewInfo.view != paramView)) {}
    }
    for (;;)
    {
      if (i != -1) {
        this.Qcu.remove(i);
      }
      boolean bool = super.removeHeaderView(paramView);
      AppMethodBeat.o(234132);
      return bool;
      i += 1;
      break;
      i = -1;
    }
  }
  
  public void setActionBarUpdateCallback(final com.tencent.mm.plugin.taskbar.api.a parama)
  {
    AppMethodBeat.i(234134);
    if (this.Qcx != null)
    {
      this.FSw = parama;
      this.Qcx.setActionBarUpdateCallback(new com.tencent.mm.plugin.taskbar.api.a()
      {
        public final void Fg(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(258297);
          if (parama != null) {
            parama.Fg(paramAnonymousBoolean);
          }
          AppMethodBeat.o(258297);
        }
        
        public final void f(float paramAnonymousFloat, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(258295);
          if (parama != null) {
            parama.f(paramAnonymousFloat, paramAnonymousInt1, paramAnonymousInt2);
          }
          AppMethodBeat.o(258295);
        }
        
        public final void g(float paramAnonymousFloat, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(258296);
          if (parama != null) {
            parama.g(paramAnonymousFloat, paramAnonymousInt1, paramAnonymousInt2);
          }
          AppMethodBeat.o(258296);
        }
      });
    }
    AppMethodBeat.o(234134);
  }
  
  public void setActivity(MMFragmentActivity paramMMFragmentActivity)
  {
    AppMethodBeat.i(38378);
    this.Dpx = paramMMFragmentActivity;
    if (this.onh != null) {
      this.onh.setActivity(this.Dpx);
    }
    AppMethodBeat.o(38378);
  }
  
  public void setIsCurrentMainUI(boolean paramBoolean)
  {
    AppMethodBeat.i(38380);
    Log.i("MicroMsg.ConversationListView", "alvinluo setIsCurrentMainUI: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.FTf = paramBoolean;
    if (this.Qcx != null) {
      this.Qcx.setIsCurrentMainUI(paramBoolean);
    }
    AppMethodBeat.o(38380);
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    AppMethodBeat.i(38373);
    this.awr = paramOnItemClickListener;
    super.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(258294);
        Log.i("MicroMsg.ConversationListView", "alvinluo onItemClick isCanClose: %b", new Object[] { Boolean.valueOf(ConversationListView.g(ConversationListView.this)) });
        if ((ConversationListView.i(ConversationListView.this) != null) && (!ConversationListView.g(ConversationListView.this))) {
          ConversationListView.i(ConversationListView.this).onItemClick(paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        }
        AppMethodBeat.o(258294);
      }
    });
    AppMethodBeat.o(38373);
  }
  
  public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener paramOnItemLongClickListener)
  {
    AppMethodBeat.i(38372);
    this.OZU = paramOnItemLongClickListener;
    super.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(258300);
        Log.i("MicroMsg.ConversationListView", "alvinluo onItemLongClick isCanClose: %b", new Object[] { Boolean.valueOf(ConversationListView.g(ConversationListView.this)) });
        if ((ConversationListView.h(ConversationListView.this) != null) && (!ConversationListView.g(ConversationListView.this)))
        {
          boolean bool = ConversationListView.h(ConversationListView.this).onItemLongClick(paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
          AppMethodBeat.o(258300);
          return bool;
        }
        AppMethodBeat.o(258300);
        return false;
      }
    });
    AppMethodBeat.o(38372);
  }
  
  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.yQz = paramOnScrollListener;
  }
  
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    this.HeV = paramOnTouchListener;
  }
  
  public void setSelection(int paramInt)
  {
    AppMethodBeat.i(38362);
    Log.i("MicroMsg.ConversationListView", "[setSelection] position:%s, scrollOffset: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.DBe) });
    if (paramInt == 0)
    {
      super.setSelectionFromTop(getFirstHeaderVisible(), this.DBe);
      AppMethodBeat.o(38362);
      return;
    }
    super.setSelectionFromTop(paramInt, this.DBe);
    AppMethodBeat.o(38362);
  }
  
  public void setStatusBarMaskView(View paramView)
  {
    AppMethodBeat.i(38379);
    this.FSz = paramView;
    if (this.Qcx != null) {
      this.Qcx.setStatusBarMaskView(paramView);
    }
    AppMethodBeat.o(38379);
  }
  
  public void setonDispatchTouchEventListener(View.OnTouchListener paramOnTouchListener)
  {
    this.QcY = paramOnTouchListener;
  }
  
  public void smoothScrollToPosition(int paramInt)
  {
    AppMethodBeat.i(38363);
    Log.i("MicroMsg.ConversationListView", "[smoothScrollToPosition] position:%s", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 0)
    {
      super.smoothScrollToPositionFromTop(getFirstHeaderVisible(), this.DBe);
      AppMethodBeat.o(38363);
      return;
    }
    super.smoothScrollToPositionFromTop(paramInt, this.DBe);
    AppMethodBeat.o(38363);
  }
  
  public void smoothScrollToPositionFromTop(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(38364);
    Log.i("MicroMsg.ConversationListView", "[smoothScrollToPositionFromTop] position:%s offset:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == 0)
    {
      super.smoothScrollToPositionFromTop(getFirstHeaderVisible(), this.DBe + paramInt2);
      AppMethodBeat.o(38364);
      return;
    }
    super.smoothScrollToPositionFromTop(paramInt1, this.DBe + paramInt2);
    AppMethodBeat.o(38364);
  }
  
  public void smoothScrollToPositionFromTop(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(38365);
    Log.i("MicroMsg.ConversationListView", "[smoothScrollToPositionFromTop] position:%s offset:%s duration:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramInt1 == 0)
    {
      super.smoothScrollToPositionFromTop(getFirstHeaderVisible(), this.DBe + paramInt2, paramInt3);
      AppMethodBeat.o(38365);
      return;
    }
    super.smoothScrollToPositionFromTop(paramInt1, this.DBe + paramInt2, paramInt3);
    AppMethodBeat.o(38365);
  }
  
  public final void yL(int paramInt) {}
  
  public final void zT(int paramInt)
  {
    AppMethodBeat.i(38356);
    eG(paramInt, 0);
    AppMethodBeat.o(38356);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.ConversationListView
 * JD-Core Version:    0.7.0.1
 */
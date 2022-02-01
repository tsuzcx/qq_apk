package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
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
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.f.a.nm;
import com.tencent.mm.plugin.appbrand.widget.recent.AppBrandRecentView.d;
import com.tencent.mm.plugin.taskbar.ui.TaskBarContainer;
import com.tencent.mm.plugin.taskbar.ui.TaskBarContainer.4;
import com.tencent.mm.plugin.taskbar.ui.TaskBarView;
import com.tencent.mm.plugin.taskbar.ui.a.a;
import com.tencent.mm.plugin.teenmode.a.b;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.ax;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class ConversationListView
  extends ListView
  implements View.OnTouchListener, AbsListView.OnScrollListener, AppBrandRecentView.d, a.a
{
  private AbsListView.OnScrollListener Euy;
  private int JMP;
  private MMFragmentActivity Jvc;
  private com.tencent.mm.plugin.taskbar.api.a MnB;
  private View MnD;
  boolean MnY;
  TaskBarContainer Mnv;
  private boolean Moh;
  private AdapterView.OnItemLongClickListener Wth;
  private LinkedList<ListView.FixedViewInfo> XAK;
  boolean XAL;
  boolean XAM;
  com.tencent.mm.plugin.taskbar.ui.a XAN;
  private int XAO;
  private int XAP;
  Runnable XAQ;
  Runnable XAR;
  Runnable XAS;
  private View XAT;
  private int XAU;
  private int XAV;
  IListener<nm> XAW;
  private View.OnLayoutChangeListener XAX;
  private View.OnTouchListener XAY;
  View XAZ;
  private boolean XBa;
  private boolean XBb;
  boolean fLS;
  private int kwr;
  private boolean lsi;
  private int mActionBarHeight;
  private int mCount;
  private Paint mPaint;
  private int mStatusBarHeight;
  private View nQ;
  private View.OnTouchListener nan;
  private int rec;
  private AdapterView.OnItemClickListener uX;
  
  public ConversationListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(38336);
    this.XAK = new LinkedList();
    this.XAL = true;
    this.XAM = false;
    this.mPaint = new Paint(1);
    this.XAP = 0;
    this.MnY = false;
    this.MnB = null;
    this.XAQ = null;
    this.XAR = null;
    this.XAS = null;
    this.mStatusBarHeight = 0;
    this.kwr = 0;
    this.XAU = com.tencent.mm.ci.a.fromDPToPix(getContext(), 56);
    this.Moh = true;
    this.XAV = 0;
    this.fLS = false;
    this.XAW = new IListener() {};
    this.XAX = new View.OnLayoutChangeListener()
    {
      public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
      {
        AppMethodBeat.i(270891);
        Log.i("MicroMsg.ConversationListView", "ActionBarView layout changed, call setupActionBarView()");
        ConversationListView.b(ConversationListView.this);
        AppMethodBeat.o(270891);
      }
    };
    this.XAY = null;
    this.XBb = false;
    dbb();
    AppMethodBeat.o(38336);
  }
  
  public ConversationListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(38337);
    this.XAK = new LinkedList();
    this.XAL = true;
    this.XAM = false;
    this.mPaint = new Paint(1);
    this.XAP = 0;
    this.MnY = false;
    this.MnB = null;
    this.XAQ = null;
    this.XAR = null;
    this.XAS = null;
    this.mStatusBarHeight = 0;
    this.kwr = 0;
    this.XAU = com.tencent.mm.ci.a.fromDPToPix(getContext(), 56);
    this.Moh = true;
    this.XAV = 0;
    this.fLS = false;
    this.XAW = new IListener() {};
    this.XAX = new View.OnLayoutChangeListener()
    {
      public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
      {
        AppMethodBeat.i(270891);
        Log.i("MicroMsg.ConversationListView", "ActionBarView layout changed, call setupActionBarView()");
        ConversationListView.b(ConversationListView.this);
        AppMethodBeat.o(270891);
      }
    };
    this.XAY = null;
    this.XBb = false;
    dbb();
    AppMethodBeat.o(38337);
  }
  
  private float awT(int paramInt)
  {
    AppMethodBeat.i(38361);
    int i = (int)getResources().getDimension(R.f.NormalListHeight);
    int j = getHeaderViewsCount();
    int k = getFooterViewsCount();
    float f = getMeasuredHeight() - i * (paramInt - j - k) - ax.ew(getContext()) - this.mStatusBarHeight;
    Log.i("MicroMsg.ConversationListView", "[isFullScreen] totalItemCount:" + paramInt + " getFirstVisiblePosition:" + getFirstVisiblePosition() + " getLastVisiblePosition:" + getLastVisiblePosition() + " getHeaderViewsCount:" + getHeaderViewsCount() + " getFooterViewsCount:" + getFooterViewsCount() + " extraHeight:" + f + " statusBarHeight: " + this.mStatusBarHeight);
    AppMethodBeat.o(38361);
    return f;
  }
  
  private static void ca(int paramInt, boolean paramBoolean)
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
  
  private void dbb()
  {
    AppMethodBeat.i(287325);
    this.mPaint.setAlpha(255);
    this.mPaint.setTextSize(com.tencent.mm.ci.a.aZ(getContext(), R.f.MiddleBtnTextSize));
    super.setOnScrollListener(this);
    super.setOnTouchListener(this);
    setOverScrollMode(2);
    Log.i("MicroMsg.ConversationListView", "alvinluo HeaderContainer new, ConversationListView: %d", new Object[] { Integer.valueOf(hashCode()) });
    cnt();
    GT(false);
    addFooterView(getEmptyFooter());
    this.XAP = ((int)(com.tencent.mm.ci.a.aZ(getContext(), R.f.DefaultTabbarHeight) * com.tencent.mm.ci.a.km(getContext())));
    this.JMP = (ax.ew(getContext()) + ax.getStatusBarHeight(getContext()));
    hWa();
    AppMethodBeat.o(287325);
  }
  
  private View getEmptyFooter()
  {
    AppMethodBeat.i(38360);
    Object localObject = getRootView().findViewById(R.h.dKR);
    int j = (int)getResources().getDimension(R.f.NormalListHeight);
    int i;
    if (localObject != null)
    {
      i = ((View)localObject).getHeight();
      if (i > 0) {
        break label132;
      }
      i = j;
    }
    label132:
    for (;;)
    {
      localObject = new LinearLayout(getContext());
      this.XAZ = new View(getContext());
      this.XAZ.setLayoutParams(new LinearLayout.LayoutParams(-1, i));
      ((LinearLayout)localObject).addView(this.XAZ);
      ((LinearLayout)localObject).setBackgroundColor(getContext().getResources().getColor(R.e.BG_2));
      ((LinearLayout)localObject).setId(R.h.dyB);
      AppMethodBeat.o(38360);
      return localObject;
      i = 0;
      break;
    }
  }
  
  private ArrayList<View> getHeaderViewList()
  {
    AppMethodBeat.i(287346);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.XAK.size())
    {
      ListView.FixedViewInfo localFixedViewInfo = (ListView.FixedViewInfo)this.XAK.get(i);
      if ((localFixedViewInfo != null) && (localFixedViewInfo.view != null)) {
        localArrayList.add(localFixedViewInfo.view);
      }
      i += 1;
    }
    AppMethodBeat.o(287346);
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
  
  private boolean gjg()
  {
    AppMethodBeat.i(38370);
    if ((this.Mnv == null) || (this.XAN == null))
    {
      AppMethodBeat.o(38370);
      return false;
    }
    boolean bool = this.XAN.gjg();
    AppMethodBeat.o(38370);
    return bool;
  }
  
  private void hVY()
  {
    int j = 0;
    AppMethodBeat.i(287327);
    if (this.Mnv != null)
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
      addHeaderView(this.Mnv);
      localArrayList.remove(this.Mnv);
      Log.i("MicroMsg.ConversationListView", "addHeaderViewList addViewList: %d", new Object[] { Integer.valueOf(localArrayList.size()) });
      i = j;
      while (i < localArrayList.size())
      {
        addHeaderView((View)localArrayList.get(i));
        i += 1;
      }
      hWb();
    }
    AppMethodBeat.o(287327);
  }
  
  private void hVZ()
  {
    AppMethodBeat.i(287329);
    if (this.Mnv != null)
    {
      removeHeaderView(this.Mnv);
      hWb();
    }
    AppMethodBeat.o(287329);
  }
  
  private void hWa()
  {
    AppMethodBeat.i(38340);
    if ((Build.VERSION.SDK_INT >= 24) && (LauncherUI.getInstance() != null))
    {
      this.fLS = LauncherUI.getInstance().isInMultiWindowMode();
      if (this.Mnv != null) {
        this.Mnv.zT(this.fLS);
      }
    }
    AppMethodBeat.o(38340);
  }
  
  private void hWc()
  {
    AppMethodBeat.i(287335);
    int j = ax.getStatusBarHeight(getContext());
    if ((this.mStatusBarHeight <= 0) && (!this.fLS)) {}
    for (int i = j;; i = this.mStatusBarHeight)
    {
      int k = this.JMP;
      this.JMP = (ax.ew(getContext()) + i);
      Log.i("MicroMsg.ConversationListView", "updateScrollOffset statusBarHeight:%d actionBarTop:%d scrollOffset:%d old:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(this.mStatusBarHeight), Integer.valueOf(this.JMP), Integer.valueOf(k) });
      if ((this.XAL) && (this.XAN != null)) {
        this.XAN.aiR(this.JMP);
      }
      if (this.Mnv != null) {
        this.Mnv.aiU(i);
      }
      if (k != this.JMP) {
        setSelection(1);
      }
      AppMethodBeat.o(287335);
      return;
    }
  }
  
  private void hWe()
  {
    AppMethodBeat.i(38359);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.XAZ.getLayoutParams();
    int i;
    float f2;
    boolean bool;
    label42:
    int k;
    int m;
    label147:
    int j;
    float f1;
    if (getAdapter() == null)
    {
      i = 0;
      f2 = awT(i);
      if (f2 >= 0.0F) {
        break label307;
      }
      bool = true;
      k = localLayoutParams.height;
      Log.i("MicroMsg.ConversationListView", "[checkEmptyFooter] isRealFull:" + bool + " old height:" + k);
      View localView = getRootView().findViewById(R.h.dKR);
      if (localView != null) {
        Log.i("MicroMsg.ConversationListView", "alvinluo checkEmptyFooter tabView Height: %d", new Object[] { Integer.valueOf(localView.getHeight()) });
      }
      m = (int)getResources().getDimension(R.f.NormalListHeight);
      if (localView == null) {
        break label313;
      }
      i = localView.getHeight();
      j = i;
      if (i <= 0) {
        j = this.XAP;
      }
      Log.d("MicroMsg.ConversationListView", "alvinluo checkEmptyFooter tabHeight: %d", new Object[] { Integer.valueOf(j) });
      if (!bool) {
        break label318;
      }
      localLayoutParams.height = j;
      f1 = f2;
    }
    for (;;)
    {
      if (k != localLayoutParams.height)
      {
        Log.i("MicroMsg.ConversationListView", "alvinluo checkEmptyFooter isHeaderOpen: %b", new Object[] { Boolean.valueOf(fcH()) });
        if (((!bool) || (Math.abs(f1) <= j + m)) && (!fcH()))
        {
          Log.i("MicroMsg.ConversationListView", "[checkEmptyFooter] setSelection");
          setSelection(1);
          if (this.XAN != null) {
            this.XAN.zR(true);
          }
        }
        this.XAZ.requestLayout();
      }
      AppMethodBeat.o(38359);
      return;
      i = getAdapter().getCount();
      break;
      label307:
      bool = false;
      break label42;
      label313:
      i = 0;
      break label147;
      label318:
      f1 = f2;
      if (f2 < j) {
        f1 = j;
      }
      localLayoutParams.height = ((int)f1);
    }
  }
  
  private void hWg()
  {
    AppMethodBeat.i(38382);
    if (this.MnB != null)
    {
      if (ar.isDarkMode())
      {
        i = getResources().getColor(R.e.actionbar_title_light_color);
        this.MnB.g(0.0F, i, i);
        this.MnB.f(0.0F, getResources().getColor(R.e.dark_actionbar_color), 0);
        AppMethodBeat.o(38382);
        return;
      }
      int i = getResources().getColor(R.e.actionbar_title_color);
      this.MnB.g(0.0F, i, i);
      this.MnB.f(0.0F, getResources().getColor(R.e.normal_actionbar_color), 0);
    }
    AppMethodBeat.o(38382);
  }
  
  private void mD(int paramInt1, int paramInt2)
  {
    int i = 0;
    AppMethodBeat.i(287334);
    Log.i("MicroMsg.ConversationListView", "alvinluo initActionBarView statusBarHeight: %d, isInMultiWindowMode: %b, target: %d, actionBarTop: %d, actionBarHeight: %d", new Object[] { Integer.valueOf(this.mStatusBarHeight), Boolean.valueOf(this.fLS), Integer.valueOf(paramInt1), Integer.valueOf(this.nQ.getTop()), Integer.valueOf(paramInt2) });
    Object localObject;
    if (paramInt1 >= 0)
    {
      if (this.MnD != null)
      {
        if (this.fLS) {
          break label177;
        }
        localObject = this.MnD.getLayoutParams();
        int j = this.mStatusBarHeight;
        if (!this.XAL) {
          break label172;
        }
        paramInt1 = 0;
        ((ViewGroup.LayoutParams)localObject).height = (paramInt1 + j);
      }
      label118:
      localObject = getLayoutParams();
      if ((localObject instanceof RelativeLayout.LayoutParams))
      {
        if (this.fLS) {
          break label196;
        }
        localObject = (RelativeLayout.LayoutParams)localObject;
        if (!this.XAL) {
          break label191;
        }
        paramInt1 = i;
      }
    }
    label155:
    label172:
    label177:
    label191:
    label196:
    for (((RelativeLayout.LayoutParams)localObject).topMargin = paramInt1;; ((RelativeLayout.LayoutParams)localObject).topMargin = 0)
    {
      hWc();
      AppMethodBeat.o(287334);
      return;
      paramInt1 = paramInt2;
      break;
      this.MnD.getLayoutParams().height = paramInt1;
      break label118;
      paramInt1 = paramInt2;
      break label155;
    }
  }
  
  final void GT(boolean paramBoolean)
  {
    AppMethodBeat.i(287331);
    boolean bool = this.XAL;
    this.XAL = true;
    Log.i("MicroMsg.ConversationListView", "updateHeaderContainer showHeaderContainer: %b, last: %b, updateView: %b, isHeaderContainerAdded: %b", new Object[] { Boolean.valueOf(this.XAL), Boolean.valueOf(bool), Boolean.valueOf(paramBoolean), Boolean.valueOf(this.XAM) });
    if (!paramBoolean)
    {
      AppMethodBeat.o(287331);
      return;
    }
    if (bool != this.XAL) {
      if (this.XAL)
      {
        if (!this.XAM)
        {
          hVY();
          this.XAM = true;
          i(200L, 0, true);
          AppMethodBeat.o(287331);
        }
      }
      else if (this.XAM)
      {
        hVZ();
        this.XAM = false;
        setSelection(0);
      }
    }
    AppMethodBeat.o(287331);
  }
  
  final void GU(boolean paramBoolean)
  {
    AppMethodBeat.i(38358);
    if (this.XAZ == null)
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
          AppMethodBeat.i(38332);
          ConversationListView.f(ConversationListView.this);
          AppMethodBeat.o(38332);
        }
      }, 0L);
      AppMethodBeat.o(38358);
      return;
    }
    hWe();
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
    this.XAK.add(localFixedViewInfo);
    AppMethodBeat.o(38368);
  }
  
  public final void aiS(int paramInt)
  {
    AppMethodBeat.i(38356);
    kr(paramInt, 0);
    AppMethodBeat.o(38356);
  }
  
  protected void attachViewToParent(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(38346);
    super.attachViewToParent(paramView, paramInt, paramLayoutParams);
    if ((this.mActionBarHeight <= 0) && (this.XAN != null))
    {
      this.mActionBarHeight = (ax.ew(getContext()) + ax.F(getContext(), 0));
      this.JMP = (ax.ew(getContext()) + ax.getStatusBarHeight(getContext()));
      hWb();
      if (this.Mnv != null) {
        this.Mnv.setActionBar(this.nQ);
      }
      this.XAN.raR = this.nQ;
      this.XAN.xp = getRootView().findViewById(R.h.dKR);
    }
    AppMethodBeat.o(38346);
  }
  
  public boolean canScrollHorizontally(int paramInt)
  {
    AppMethodBeat.i(38338);
    if (this.Mnv == null)
    {
      boolean bool = super.canScrollHorizontally(paramInt);
      AppMethodBeat.o(38338);
      return bool;
    }
    if (this.Mnv.getBottom() >= this.Mnv.getHeight())
    {
      AppMethodBeat.o(38338);
      return true;
    }
    AppMethodBeat.o(38338);
    return false;
  }
  
  public final void ceK() {}
  
  final void cnt()
  {
    AppMethodBeat.i(287326);
    this.lsi = ((b)com.tencent.mm.kernel.h.ae(b.class)).ZM();
    this.rec = ((b)com.tencent.mm.kernel.h.ae(b.class)).gks();
    Log.d("MicroMsg.ConversationListView", "updateTeenModeStatus isTeenMode: %b, miniProgramOption: %d", new Object[] { Boolean.valueOf(this.lsi), Integer.valueOf(this.rec) });
    AppMethodBeat.o(287326);
  }
  
  public boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    AppMethodBeat.i(38344);
    if ((getFirstVisiblePosition() == 0) && (paramInt2 < 0) && (paramArrayOfInt1 != null) && (paramArrayOfInt1.length >= 2) && (!this.MnY))
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
    if (this.XAY != null) {
      this.XAY.onTouch(this, paramMotionEvent);
    }
    int i;
    boolean bool;
    try
    {
      if (this.Mnv != null) {
        Log.d("MicroMsg.ConversationListView", "alvinluo dispatchTouchEvent backUpFooterRect: %s, %f, %f, bottom: %d, height: %d, isCanClose: %b", new Object[] { this.Mnv.getBackUpFooterRect().toString(), Float.valueOf(paramMotionEvent.getRawX()), Float.valueOf(paramMotionEvent.getRawY()), Integer.valueOf(this.Mnv.getBottom()), Integer.valueOf(this.Mnv.getHeight()), Boolean.valueOf(this.XBa) });
      }
      int j = (int)paramMotionEvent.getRawY();
      i = j;
      if (this.fLS) {
        i = j - this.XAV + this.mStatusBarHeight;
      }
      if ((fcH()) && (this.Mnv != null))
      {
        if (paramMotionEvent.getPointerCount() > 1)
        {
          paramMotionEvent.setAction(3);
          bool = this.Mnv.dispatchTouchEvent(paramMotionEvent);
          AppMethodBeat.o(38371);
          return bool;
        }
        if (paramMotionEvent.getAction() == 0) {
          if (!this.Mnv.getBackUpFooterRect().contains((int)paramMotionEvent.getRawX(), i)) {
            break label273;
          }
        }
        label273:
        for (this.XBb = true;; this.XBb = false)
        {
          Log.d("MicroMsg.ConversationListView", "alvinluo dispatchTouchEvent isDownInCloseRect: %b, touchY: %d", new Object[] { Boolean.valueOf(this.XBb), Integer.valueOf(i) });
          if (this.XBb) {
            break;
          }
          bool = this.Mnv.dispatchTouchEvent(paramMotionEvent);
          AppMethodBeat.o(38371);
          return bool;
        }
      }
      if (this.Mnv == null) {
        break label531;
      }
    }
    catch (Exception paramMotionEvent)
    {
      Log.printErrStackTrace("MicroMsg.ConversationListView", paramMotionEvent, "alvinluo ConversationListView dispatchTouchEvent exception", new Object[0]);
      AppMethodBeat.o(38371);
      return false;
    }
    if ((this.Mnv.getBottom() >= this.Mnv.getHeight()) && (getFirstVisiblePosition() == 0))
    {
      if ((paramMotionEvent.getAction() == 0) && (this.Mnv.getBackUpFooterRect().contains((int)paramMotionEvent.getRawX(), i))) {
        this.XBa = true;
      }
      while ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
      {
        if (this.XBa)
        {
          this.XBa = false;
          if (this.XAN != null)
          {
            Log.i("MicroMsg.ConversationListView", "alvinluo closeHeader by click BackUpFooterRect");
            this.XAN.DC(12);
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
            this.XBa = false;
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
      if ((this.XAN != null) && (paramMotionEvent.getAction() == 0)) {
        this.XAN.al(paramMotionEvent);
      }
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(38371);
      return bool;
    }
    label531:
    if ((this.XBa) && (paramMotionEvent.getAction() == 1))
    {
      Log.i("MicroMsg.ConversationListView", "alvinluo ConversationListView cancel touch event..., isHeaderOpen: %b, isHeaderVisible: %b", new Object[] { Boolean.valueOf(fcH()), Boolean.valueOf(gjg()) });
      if (fcH()) {
        break label635;
      }
      this.XBa = false;
    }
    for (;;)
    {
      if ((paramMotionEvent.getAction() == 0) && (this.XAN != null) && (paramMotionEvent.getAction() == 0)) {
        this.XAN.al(paramMotionEvent);
      }
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(38371);
      return bool;
      label635:
      paramMotionEvent.setAction(3);
    }
  }
  
  public final boolean fcH()
  {
    AppMethodBeat.i(38369);
    if ((gjg()) && (this.MnY))
    {
      AppMethodBeat.o(38369);
      return true;
    }
    AppMethodBeat.o(38369);
    return false;
  }
  
  public int getFirstHeaderVisible()
  {
    AppMethodBeat.i(38367);
    Iterator localIterator = this.XAK.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject = (ListView.FixedViewInfo)localIterator.next();
      if (((ListView.FixedViewInfo)localObject).view == this.Mnv)
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
    return this.XAL;
  }
  
  public TaskBarView getTaskBarView()
  {
    AppMethodBeat.i(287344);
    if (this.Mnv == null)
    {
      Log.w("MicroMsg.ConversationListView", "mHeaderContainer is null");
      AppMethodBeat.o(287344);
      return null;
    }
    TaskBarView localTaskBarView = this.Mnv.getTaskBarView();
    AppMethodBeat.o(287344);
    return localTaskBarView;
  }
  
  public final void gjn()
  {
    AppMethodBeat.i(38354);
    Log.d("MicroMsg.ConversationListView", "[onOpenHeader]");
    this.MnY = true;
    if (this.XAQ != null) {
      removeCallbacks(this.XAQ);
    }
    if (this.MnB != null) {
      this.MnB.zQ(false);
    }
    AppMethodBeat.o(38354);
  }
  
  public final void gjo()
  {
    AppMethodBeat.i(38357);
    gjn();
    AppMethodBeat.o(38357);
  }
  
  public final void hId()
  {
    AppMethodBeat.i(287336);
    if (this.XAN != null)
    {
      com.tencent.mm.plugin.taskbar.ui.a locala = this.XAN;
      Log.i("MicroMsg.TaskBarAnimController", "onChattingClose");
      locala.Lue = false;
    }
    AppMethodBeat.o(287336);
  }
  
  final void hWb()
  {
    AppMethodBeat.i(287332);
    final int j;
    int k;
    if (this.nQ == null)
    {
      this.nQ = getRootView().findViewById(R.h.action_bar_container);
      if (this.nQ != null) {
        this.nQ.addOnLayoutChangeListener(this.XAX);
      }
    }
    else
    {
      if (this.XAT == null) {
        this.XAT = getRootView().findViewById(R.h.top_status_bar);
      }
      if ((this.fLS) && (Build.VERSION.SDK_INT >= 24) && (LauncherUI.getInstance() != null))
      {
        this.fLS = LauncherUI.getInstance().isInMultiWindowMode();
        Log.i("MicroMsg.ConversationListView", "alvinluo initActionBarView check multiWindowMode %b", new Object[] { Boolean.valueOf(this.fLS) });
      }
      j = com.tencent.mm.pluginsdk.h.ew(getContext());
      k = this.mStatusBarHeight;
      if ((this.mStatusBarHeight != 0) && ((this.fLS) || (this.nQ.getTop() == this.mStatusBarHeight) || (this.nQ.getTop() == 0))) {
        break label295;
      }
      this.mStatusBarHeight = this.nQ.getTop();
    }
    label295:
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (!this.fLS)) {
        post(new Runnable()
        {
          int kQn = 0;
          
          public final void run()
          {
            AppMethodBeat.i(38329);
            if (ConversationListView.d(ConversationListView.this) == null)
            {
              AppMethodBeat.o(38329);
              return;
            }
            if (ConversationListView.d(ConversationListView.this).getTop() != 0) {
              ConversationListView.a(ConversationListView.this, ConversationListView.d(ConversationListView.this).getTop());
            }
            if (ConversationListView.e(ConversationListView.this) <= 0) {
              if (this.kQn <= 2)
              {
                Log.i("MicroMsg.ConversationListView", "alvinluo initActionBarView try again tryCount: %d", new Object[] { Integer.valueOf(this.kQn) });
                ConversationListView.this.post(this);
              }
            }
            for (;;)
            {
              this.kQn += 1;
              AppMethodBeat.o(38329);
              return;
              ConversationListView.b(ConversationListView.this, j);
              continue;
              ConversationListView.a(ConversationListView.this, ConversationListView.e(ConversationListView.this), j);
              ConversationListView.awU(ConversationListView.e(ConversationListView.this));
            }
          }
        });
      }
      for (;;)
      {
        if (this.mStatusBarHeight != k)
        {
          Log.i("MicroMsg.ConversationListView", "statusBar height changed old:%d new:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(this.mStatusBarHeight) });
          GU(false);
        }
        AppMethodBeat.o(287332);
        return;
        AppMethodBeat.o(287332);
        return;
        this.mStatusBarHeight = this.nQ.getTop();
        mD(this.mStatusBarHeight, j);
        ca(this.mStatusBarHeight, false);
      }
    }
  }
  
  public final void hWd()
  {
    AppMethodBeat.i(38353);
    if ((this.XAL) && (this.XAN != null)) {
      this.XAN.i(0L, 0, true);
    }
    hWf();
    AppMethodBeat.o(38353);
  }
  
  final void hWf()
  {
    AppMethodBeat.i(38381);
    if (this.nQ != null)
    {
      this.nQ.setTranslationY(0.0F);
      this.nQ.setVisibility(0);
    }
    hWg();
    AppMethodBeat.o(38381);
  }
  
  public final void i(long paramLong, final int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(287340);
    Log.i("MicroMsg.ConversationListView", "[closeHeader] delay:%s, type: %d, forceClose: %b", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    if ((getFirstVisiblePosition() != 0) && (!paramBoolean))
    {
      AppMethodBeat.o(287340);
      return;
    }
    if (paramLong > 0L)
    {
      if (this.XAR != null) {
        removeCallbacks(this.XAR);
      }
      this.XAR = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(38331);
          ConversationListView localConversationListView = ConversationListView.this;
          int i = paramInt;
          if ((localConversationListView.XAL) && (localConversationListView.XAN != null)) {
            localConversationListView.XAN.DC(i);
          }
          AppMethodBeat.o(38331);
        }
      };
      postDelayed(this.XAR, paramLong);
      AppMethodBeat.o(287340);
      return;
    }
    setSelection(0);
    AppMethodBeat.o(287340);
  }
  
  public final void kr(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(287341);
    Log.d("MicroMsg.ConversationListView", "[onCloseHeader]");
    this.XBa = false;
    this.MnY = false;
    this.XAO = 0;
    if (this.XAQ != null) {
      removeCallbacks(this.XAQ);
    }
    if (this.MnB != null) {
      this.MnB.zQ(true);
    }
    AppMethodBeat.o(287341);
  }
  
  final void mE(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(38352);
    if (this.MnB != null)
    {
      this.MnB.f(1.0F, paramInt1, 0);
      this.MnB.g(1.0F, paramInt2, paramInt2);
    }
    AppMethodBeat.o(38352);
  }
  
  public final void o(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(38366);
    Log.i("MicroMsg.ConversationListView", "[showAppBrandHeader] isShow:" + paramBoolean1 + " isAnim:" + paramBoolean2 + " isScrollFirst:" + paramBoolean3);
    if (paramBoolean1)
    {
      if ((this.XAL) && (this.XAN != null))
      {
        this.XAN.giZ();
        AppMethodBeat.o(38366);
      }
    }
    else if ((this.XAL) && (this.XAN != null)) {
      this.XAN.DC(0);
    }
    AppMethodBeat.o(38366);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(38375);
    super.onAttachedToWindow();
    if (this.XAW != null) {
      this.XAW.alive();
    }
    AppMethodBeat.o(38375);
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(38374);
    super.onConfigurationChanged(paramConfiguration);
    Log.i("MicroMsg.ConversationListView", "[onConfigurationChanged] orientation:%s, last: %d", new Object[] { Integer.valueOf(paramConfiguration.orientation), Integer.valueOf(this.kwr) });
    GU(true);
    hWc();
    Object localObject;
    if ((this.XAL) && (this.XAN != null))
    {
      localObject = this.XAN;
      ((com.tencent.mm.plugin.taskbar.ui.a)localObject).daP();
      ((com.tencent.mm.plugin.taskbar.ui.a)localObject).f(1.0F, ((com.tencent.mm.plugin.taskbar.ui.a)localObject).wYT, 0);
      ((com.tencent.mm.plugin.taskbar.ui.a)localObject).ck(1.0F);
      ((com.tencent.mm.plugin.taskbar.ui.a)localObject).MnW = false;
    }
    if (this.Mnv != null)
    {
      localObject = this.Mnv;
      Log.i("MicroMsg.AppBrandDesktopContainer", "alvinluo AppBrandDesktopContainer onCustomConfigurationChanged newConfig orientation: %d", new Object[] { Integer.valueOf(paramConfiguration.orientation) });
      if (((TaskBarContainer)localObject).Mpa != null) {
        ((TaskBarContainer)localObject).removeCallbacks(((TaskBarContainer)localObject).Mpa);
      }
      ((TaskBarContainer)localObject).MoL.setVisibility(4);
      TaskBarContainer.4 local4 = new TaskBarContainer.4((TaskBarContainer)localObject);
      ((TaskBarContainer)localObject).Mpa = local4;
      ((TaskBarContainer)localObject).postDelayed(local4, 400L);
      if (((TaskBarContainer)localObject).MoG != null)
      {
        localObject = ((TaskBarContainer)localObject).MoG;
        Log.i("MicroMsg.TaskBarView", "alvinluo TaskBarView onCustomConfigurationChanged lastOrientation: %d, orientation: %d", new Object[] { Integer.valueOf(((TaskBarView)localObject).kwr), Integer.valueOf(paramConfiguration.orientation) });
        if (((TaskBarView)localObject).Mnv != null)
        {
          ((TaskBarView)localObject).Mpn = ((TaskBarView)localObject).Mnv.getViewHeight();
          Log.i("MicroMsg.TaskBarView", "alvinluo TaskBarView onCustomConfigurationChanged fixedViewHeight: %d", new Object[] { Integer.valueOf(((TaskBarView)localObject).Mpn) });
        }
        if (((TaskBarView)localObject).kwr != paramConfiguration.orientation)
        {
          ((TaskBarView)localObject).kwr = paramConfiguration.orientation;
          if ((((TaskBarView)localObject).Mnv == null) || (!((TaskBarView)localObject).Mnv.gjt())) {
            break label385;
          }
          Log.i("MicroMsg.TaskBarView", "alvinluo onCustomConfigurationChanged closeHeader");
          ((TaskBarView)localObject).Mnv.am(0L, 0);
        }
      }
    }
    for (;;)
    {
      if (this.MnB != null) {
        this.MnB.zQ(true);
      }
      if (this.XAS != null) {
        removeCallbacks(this.XAS);
      }
      paramConfiguration = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(38335);
          if (ar.isDarkMode()) {
            ConversationListView.b(ConversationListView.this, ConversationListView.this.getResources().getColor(R.e.dark_actionbar_color), ConversationListView.this.getResources().getColor(R.e.actionbar_title_light_color));
          }
          for (;;)
          {
            if (ConversationListView.j(ConversationListView.this) != null) {
              ConversationListView.j(ConversationListView.this).giY();
            }
            if (ConversationListView.c(ConversationListView.this) != null) {
              ConversationListView.c(ConversationListView.this).gjs();
            }
            ConversationListView.this.setSelection(1);
            ConversationListView.k(ConversationListView.this);
            AppMethodBeat.o(38335);
            return;
            ConversationListView.b(ConversationListView.this, ConversationListView.this.getResources().getColor(R.e.normal_actionbar_color), ConversationListView.this.getResources().getColor(R.e.actionbar_title_color));
          }
        }
      };
      this.XAS = paramConfiguration;
      postDelayed(paramConfiguration, 800L);
      this.MnY = false;
      AppMethodBeat.o(38374);
      return;
      label385:
      ((TaskBarView)localObject).gjz();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(38376);
    super.onDetachedFromWindow();
    if (this.XAW != null) {
      this.XAW.dead();
    }
    AppMethodBeat.o(38376);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(38347);
    super.onDraw(paramCanvas);
    if ((this.Mnv != null) && (getFirstVisiblePosition() == 0) && (this.Mnv.getBottom() > 6))
    {
      if (this.XAO < 30)
      {
        AppMethodBeat.o(38347);
        return;
      }
      this.mPaint.setStyle(Paint.Style.FILL);
      this.mPaint.setColor(getContext().getResources().getColor(R.e.app_brand_desktop_bottom_action_bar_color));
      this.mPaint.setAlpha(this.XAO);
      paramCanvas.drawRect(this.Mnv.getBackUpFooterRect().left, this.Mnv.getBackUpFooterRect().top + this.XAU, this.Mnv.getBackUpFooterRect().right, this.Mnv.getBackUpFooterRect().bottom, this.mPaint);
    }
    AppMethodBeat.o(38347);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(38350);
    try
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      boolean bool = fcH();
      Log.i("MicroMsg.ConversationListView", "[onLayout] changed:%s, isHeaderOpen: %b", new Object[] { Boolean.valueOf(paramBoolean), Boolean.valueOf(bool) });
      Log.d("MicroMsg.ConversationListView", "[onLayout] top: %d, bottom: %d, height: %d, count: %d, realCount: %d, hashCode: %s", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt4), Integer.valueOf(paramInt4 - paramInt2), Integer.valueOf(this.mCount), Integer.valueOf(getRealCount()), Integer.valueOf(hashCode()) });
      if ((paramBoolean) && (!bool))
      {
        setSelection(1);
        post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(38330);
            ConversationListView.this.setSelection(1);
            AppMethodBeat.o(38330);
          }
        });
      }
      if ((paramBoolean) || ((this.mCount < 16) && (getRealCount() != this.mCount))) {
        GU(false);
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
    label84:
    int j;
    if ((this.XAL) && (paramInt1 == 0) && (this.Moh))
    {
      localObject = getChildAt(1);
      if (localObject == null) {
        if ((fcH()) && (this.Mnv != null))
        {
          i = this.Mnv.getMeasuredHeight() - this.JMP;
          Log.i("MicroMsg.ConversationListView", "alvinluo computeActionBarTranslation %d", new Object[] { Integer.valueOf(i) });
          i = Math.max(0, i);
          if (this.nQ != null) {
            this.nQ.setTranslationY(i);
          }
          if (this.XAT != null)
          {
            if (i <= 0) {
              break label507;
            }
            this.XAT.setAlpha(0.0F);
          }
          label129:
          if ((this.XAL) && (this.Mnv != null))
          {
            localObject = this.Mnv;
            this.Mnv.getHeight();
            j = this.Mnv.getHeight() - this.JMP;
            if (((TaskBarContainer)localObject).ARi) {
              break label518;
            }
            if (i <= 10) {
              ((TaskBarContainer)localObject).ARi = true;
            }
          }
        }
      }
    }
    for (;;)
    {
      if (this.Euy != null) {
        this.Euy.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
      }
      if ((this.XAL) && (this.XAN != null)) {
        this.XAN.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
      }
      if ((this.XAL) && (paramInt2 > 1) && (gjg()) && (this.Mnv != null))
      {
        paramAbsListView = new int[2];
        getLocationOnScreen(paramAbsListView);
        this.XAV = paramAbsListView[1];
        paramInt1 = this.Mnv.getBottom() - com.tencent.mm.ci.a.fromDPToPix(getContext(), 56);
        this.Mnv.getBackUpFooterRect().set(0, paramInt1, getWidth(), getHeight() + paramInt1);
        Log.d("MicroMsg.ConversationListView", "alvinluo onScroll BackUpFooterRect: %s, headerContainer top: %d, bottom: %d", new Object[] { this.Mnv.getBackUpFooterRect().toString(), Integer.valueOf(this.Mnv.getTop()), Integer.valueOf(this.Mnv.getBottom()) });
        this.XAO = ((int)(255.0F * this.Mnv.getBottom() / this.Mnv.getHeight()));
      }
      AppMethodBeat.o(38349);
      return;
      i = 0;
      break;
      i = ((View)localObject).getTop();
      j = Math.max(paramInt1 - getHeaderViewsCount(), 0);
      int k = -i;
      j = (int)(j * getResources().getDimension(R.f.NormalListHeight)) + k + this.JMP;
      Log.v("MicroMsg.ConversationListView", "[viroff] top %d translateY %d scrollOffset %d", new Object[] { Integer.valueOf(i), Integer.valueOf(-j), Integer.valueOf(this.JMP) });
      i = -j;
      break label84;
      label507:
      this.XAT.setAlpha(1.0F);
      break label129;
      label518:
      if ((((TaskBarContainer)localObject).MoK != null) && (i > 10))
      {
        ((TaskBarContainer)localObject).MoK.setTranslationY(((TaskBarContainer)localObject).getMeasuredHeight() - ((TaskBarContainer)localObject).getBottom());
        float f = Math.max(Math.min(i * 1.0F / j * 0.4F + 0.6F, 1.0F), 0.6F);
        ((TaskBarContainer)localObject).MoK.setScaleX(f);
        ((TaskBarContainer)localObject).MoK.setScaleY(f);
        Log.v("MicroMsg.AppBrandDesktopContainer", "alvinluo HeaderContainer onScroll scale: %f, scrollY: %d, totalHeight: %d", new Object[] { Float.valueOf(f), Integer.valueOf(i), Integer.valueOf(j) });
        if (i >= j)
        {
          ((TaskBarContainer)localObject).ARi = false;
          continue;
          if (paramInt1 > 0) {
            hWf();
          }
        }
      }
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(38348);
    if (this.Euy != null) {
      this.Euy.onScrollStateChanged(paramAbsListView, paramInt);
    }
    if ((this.XAN != null) && (this.XAL)) {
      this.XAN.onScrollStateChanged(paramAbsListView, paramInt);
    }
    AppMethodBeat.o(38348);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(38345);
    if ((this.XAL) && (this.XAN != null) && (this.XAN.onTouch(paramView, paramMotionEvent))) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = bool1;
      if (this.nan != null) {
        bool2 = bool1 | this.nan.onTouch(paramView, paramMotionEvent);
      }
      AppMethodBeat.o(38345);
      return bool2;
    }
  }
  
  public boolean removeHeaderView(View paramView)
  {
    AppMethodBeat.i(287345);
    int i = 0;
    if (i < this.XAK.size())
    {
      ListView.FixedViewInfo localFixedViewInfo = (ListView.FixedViewInfo)this.XAK.get(i);
      if ((localFixedViewInfo == null) || (localFixedViewInfo.view != paramView)) {}
    }
    for (;;)
    {
      if (i != -1) {
        this.XAK.remove(i);
      }
      boolean bool = super.removeHeaderView(paramView);
      AppMethodBeat.o(287345);
      return bool;
      i += 1;
      break;
      i = -1;
    }
  }
  
  public void setActionBarUpdateCallback(final com.tencent.mm.plugin.taskbar.api.a parama)
  {
    AppMethodBeat.i(287349);
    if (this.XAN != null)
    {
      this.MnB = parama;
      this.XAN.MnB = new com.tencent.mm.plugin.taskbar.api.a()
      {
        public final void f(float paramAnonymousFloat, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(38327);
          if (parama != null) {
            parama.f(paramAnonymousFloat, paramAnonymousInt1, paramAnonymousInt2);
          }
          AppMethodBeat.o(38327);
        }
        
        public final void g(float paramAnonymousFloat, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(38328);
          if (parama != null) {
            parama.g(paramAnonymousFloat, paramAnonymousInt1, paramAnonymousInt2);
          }
          AppMethodBeat.o(38328);
        }
        
        public final void zQ(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(270924);
          if (parama != null) {
            parama.zQ(paramAnonymousBoolean);
          }
          AppMethodBeat.o(270924);
        }
      };
    }
    AppMethodBeat.o(287349);
  }
  
  public void setActivity(MMFragmentActivity paramMMFragmentActivity)
  {
    AppMethodBeat.i(38378);
    this.Jvc = paramMMFragmentActivity;
    if (this.Mnv != null) {
      this.Mnv.setActivity(this.Jvc);
    }
    AppMethodBeat.o(38378);
  }
  
  public void setIsCurrentMainUI(boolean paramBoolean)
  {
    AppMethodBeat.i(38380);
    Log.i("MicroMsg.ConversationListView", "alvinluo setIsCurrentMainUI: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.Moh = paramBoolean;
    if (this.XAN != null)
    {
      com.tencent.mm.plugin.taskbar.ui.a locala = this.XAN;
      locala.Moh = paramBoolean;
      if ((!paramBoolean) && (locala.MnY))
      {
        Log.i("MicroMsg.TaskBarAnimController", "alvinluo setIsCurrentMainUI and header open, close");
        locala.i(0L, 0, true);
      }
    }
    AppMethodBeat.o(38380);
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    AppMethodBeat.i(38373);
    this.uX = paramOnItemClickListener;
    super.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(38334);
        Log.i("MicroMsg.ConversationListView", "alvinluo onItemClick isCanClose: %b", new Object[] { Boolean.valueOf(ConversationListView.g(ConversationListView.this)) });
        if ((ConversationListView.i(ConversationListView.this) != null) && (!ConversationListView.g(ConversationListView.this))) {
          ConversationListView.i(ConversationListView.this).onItemClick(paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        }
        AppMethodBeat.o(38334);
      }
    });
    AppMethodBeat.o(38373);
  }
  
  public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener paramOnItemLongClickListener)
  {
    AppMethodBeat.i(38372);
    this.Wth = paramOnItemLongClickListener;
    super.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(38333);
        Log.i("MicroMsg.ConversationListView", "alvinluo onItemLongClick isCanClose: %b", new Object[] { Boolean.valueOf(ConversationListView.g(ConversationListView.this)) });
        if ((ConversationListView.h(ConversationListView.this) != null) && (!ConversationListView.g(ConversationListView.this)))
        {
          boolean bool = ConversationListView.h(ConversationListView.this).onItemLongClick(paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
          AppMethodBeat.o(38333);
          return bool;
        }
        AppMethodBeat.o(38333);
        return false;
      }
    });
    AppMethodBeat.o(38372);
  }
  
  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.Euy = paramOnScrollListener;
  }
  
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    this.nan = paramOnTouchListener;
  }
  
  public void setSelection(int paramInt)
  {
    AppMethodBeat.i(38362);
    Log.i("MicroMsg.ConversationListView", "[setSelection] position:%s, scrollOffset: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.JMP) });
    if (paramInt == 0)
    {
      super.setSelectionFromTop(getFirstHeaderVisible(), this.JMP);
      AppMethodBeat.o(38362);
      return;
    }
    super.setSelectionFromTop(paramInt, this.JMP);
    AppMethodBeat.o(38362);
  }
  
  public void setSelectionFromTop(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(287343);
    Log.i("MicroMsg.ConversationListView", "[setSelectionFromTop] position:%s, scrollOffset: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    super.setSelectionFromTop(paramInt1, paramInt2);
    AppMethodBeat.o(287343);
  }
  
  public void setStatusBarMaskView(View paramView)
  {
    AppMethodBeat.i(38379);
    this.MnD = paramView;
    if (this.XAN != null) {
      this.XAN.MnD = paramView;
    }
    AppMethodBeat.o(38379);
  }
  
  public void setonDispatchTouchEventListener(View.OnTouchListener paramOnTouchListener)
  {
    this.XAY = paramOnTouchListener;
  }
  
  public void smoothScrollToPosition(int paramInt)
  {
    AppMethodBeat.i(38363);
    Log.i("MicroMsg.ConversationListView", "[smoothScrollToPosition] position:%s", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 0)
    {
      super.smoothScrollToPositionFromTop(getFirstHeaderVisible(), this.JMP);
      AppMethodBeat.o(38363);
      return;
    }
    super.smoothScrollToPositionFromTop(paramInt, this.JMP);
    AppMethodBeat.o(38363);
  }
  
  public void smoothScrollToPositionFromTop(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(38364);
    Log.i("MicroMsg.ConversationListView", "[smoothScrollToPositionFromTop] position:%s offset:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == 0)
    {
      super.smoothScrollToPositionFromTop(getFirstHeaderVisible(), this.JMP + paramInt2);
      AppMethodBeat.o(38364);
      return;
    }
    super.smoothScrollToPositionFromTop(paramInt1, this.JMP + paramInt2);
    AppMethodBeat.o(38364);
  }
  
  public void smoothScrollToPositionFromTop(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(38365);
    Log.i("MicroMsg.ConversationListView", "[smoothScrollToPositionFromTop] position:%s offset:%s duration:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramInt1 == 0)
    {
      super.smoothScrollToPositionFromTop(getFirstHeaderVisible(), this.JMP + paramInt2, paramInt3);
      AppMethodBeat.o(38365);
      return;
    }
    super.smoothScrollToPositionFromTop(paramInt1, this.JMP + paramInt2, paramInt3);
    AppMethodBeat.o(38365);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.ConversationListView
 * JD-Core Version:    0.7.0.1
 */
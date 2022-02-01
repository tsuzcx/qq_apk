package com.tencent.mm.ui.conversation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
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
import android.widget.HeaderViewListAdapter;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ListView.FixedViewInfo;
import android.widget.RelativeLayout.LayoutParams;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.autogen.a.ou;
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.plugin.appbrand.widget.recent.AppBrandRecentView.d;
import com.tencent.mm.plugin.taskbar.ui.TaskBarContainer;
import com.tencent.mm.plugin.taskbar.ui.TaskBarContainer.4;
import com.tencent.mm.plugin.taskbar.ui.TaskBarView;
import com.tencent.mm.plugin.taskbar.ui.a.a;
import com.tencent.mm.plugin.teenmode.a.d;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bb;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.bf;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ConversationListView
  extends ListView
  implements View.OnTouchListener, AbsListView.OnScrollListener, AppBrandRecentView.d, a.a
{
  private AbsListView.OnScrollListener Knf;
  private MMFragmentActivity PIA;
  private int Qhp;
  TaskBarContainer SQO;
  private com.tencent.mm.plugin.taskbar.api.a SQU;
  private View SQW;
  private boolean SRB;
  boolean SRs;
  private Rect aeLm;
  private Paint aeLn;
  private boolean aeLp;
  private AdapterView.OnItemLongClickListener aeaB;
  Runnable afnA;
  Runnable afnB;
  Runnable afnC;
  com.tencent.mm.ui.widget.pulldown.f afnD;
  private View afnE;
  private int afnF;
  private int afnG;
  private int afnH;
  IListener<ou> afnI;
  private View.OnLayoutChangeListener afnJ;
  private View.OnTouchListener afnK;
  View afnL;
  private boolean afnM;
  private boolean afnN;
  private LinkedList<ListView.FixedViewInfo> afns;
  boolean afnt;
  boolean afnu;
  com.tencent.mm.plugin.taskbar.ui.a afnv;
  private m afnw;
  private int afnx;
  private Paint afny;
  int afnz;
  private boolean epi;
  boolean hRD;
  private int mActionBarHeight;
  private int mCount;
  private Paint mPaint;
  private int mStatusBarHeight;
  private int mZT;
  private View oP;
  private View.OnTouchListener pWX;
  private int umi;
  private AdapterView.OnItemClickListener vT;
  
  public ConversationListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(38336);
    this.afns = new LinkedList();
    this.afnt = true;
    this.afnu = false;
    this.mPaint = new Paint(1);
    this.afny = new Paint(1);
    this.afnz = 0;
    this.SRs = false;
    this.SQU = null;
    this.afnA = null;
    this.afnB = null;
    this.afnC = null;
    this.mStatusBarHeight = 0;
    this.mZT = 0;
    this.afnF = com.tencent.mm.cd.a.fromDPToPix(getContext(), 56);
    this.SRB = true;
    this.afnG = 0;
    this.afnH = 0;
    this.hRD = false;
    this.aeLm = new Rect();
    this.aeLp = false;
    this.afnI = new IListener(com.tencent.mm.app.f.hfK) {};
    this.afnJ = new View.OnLayoutChangeListener()
    {
      public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
      {
        AppMethodBeat.i(256466);
        Log.i("MicroMsg.ConversationListView", "ActionBarView layout changed, call setupActionBarView()");
        ConversationListView.b(ConversationListView.this);
        AppMethodBeat.o(256466);
      }
    };
    this.afnK = null;
    this.afnN = false;
    dHA();
    AppMethodBeat.o(38336);
  }
  
  public ConversationListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(38337);
    this.afns = new LinkedList();
    this.afnt = true;
    this.afnu = false;
    this.mPaint = new Paint(1);
    this.afny = new Paint(1);
    this.afnz = 0;
    this.SRs = false;
    this.SQU = null;
    this.afnA = null;
    this.afnB = null;
    this.afnC = null;
    this.mStatusBarHeight = 0;
    this.mZT = 0;
    this.afnF = com.tencent.mm.cd.a.fromDPToPix(getContext(), 56);
    this.SRB = true;
    this.afnG = 0;
    this.afnH = 0;
    this.hRD = false;
    this.aeLm = new Rect();
    this.aeLp = false;
    this.afnI = new IListener(com.tencent.mm.app.f.hfK) {};
    this.afnJ = new View.OnLayoutChangeListener()
    {
      public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
      {
        AppMethodBeat.i(256466);
        Log.i("MicroMsg.ConversationListView", "ActionBarView layout changed, call setupActionBarView()");
        ConversationListView.b(ConversationListView.this);
        AppMethodBeat.o(256466);
      }
    };
    this.afnK = null;
    this.afnN = false;
    dHA();
    AppMethodBeat.o(38337);
  }
  
  private float aDA(int paramInt)
  {
    int k = 0;
    AppMethodBeat.i(256740);
    int i;
    boolean bool2;
    int j;
    if (((getAdapter() instanceof HeaderViewListAdapter)) && ((((HeaderViewListAdapter)getAdapter()).getWrappedAdapter() instanceof k)))
    {
      Iterator localIterator = m.k((k)((HeaderViewListAdapter)getAdapter()).getWrappedAdapter()).iterator();
      boolean bool1 = false;
      i = 0;
      bb localbb;
      for (;;)
      {
        bool2 = bool1;
        j = i;
        if (!localIterator.hasNext()) {
          break label130;
        }
        localbb = (bb)localIterator.next();
        if (localbb.adis != 4) {
          break;
        }
        i += 1;
      }
      if (!au.bwB(localbb.field_username)) {
        break label167;
      }
      bool1 = true;
    }
    label130:
    label167:
    for (;;)
    {
      break;
      bool2 = false;
      j = 0;
      i = k;
      if (this.afnw != null) {
        i = this.afnw.afpD;
      }
      float f = X(paramInt, j + i, bool2);
      AppMethodBeat.o(256740);
      return f;
    }
  }
  
  private static void cN(int paramInt, boolean paramBoolean)
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
  
  private void dHA()
  {
    AppMethodBeat.i(256695);
    this.mPaint.setAlpha(255);
    this.mPaint.setTextSize(com.tencent.mm.cd.a.bs(getContext(), R.f.MiddleBtnTextSize));
    this.aeLn = new Paint();
    this.aeLn.setColor(-16777216);
    this.afny.setColor(getResources().getColor(R.e.FG_3));
    this.afny.setStyle(Paint.Style.FILL);
    this.afny.setStrokeWidth(getResources().getDimension(R.f.DividerHeight));
    super.setOnScrollListener(this);
    super.setOnTouchListener(this);
    setOverScrollMode(2);
    Log.i("MicroMsg.ConversationListView", "alvinluo HeaderContainer new, ConversationListView: %d", new Object[] { Integer.valueOf(hashCode()) });
    cPw();
    MH(false);
    addFooterView(getEmptyFooter());
    this.afnz = ((int)(com.tencent.mm.cd.a.bs(getContext(), R.f.DefaultTabbarHeight) * com.tencent.mm.cd.a.jO(getContext())));
    this.Qhp = (bf.fs(getContext()) + bf.getStatusBarHeight(getContext()));
    jzY();
    setWillNotDraw(false);
    AppMethodBeat.o(256695);
  }
  
  private View getEmptyFooter()
  {
    AppMethodBeat.i(38360);
    Object localObject = getRootView().findViewById(R.h.fMt);
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
      this.afnL = new View(getContext());
      this.afnL.setLayoutParams(new LinearLayout.LayoutParams(-1, i));
      ((LinearLayout)localObject).addView(this.afnL);
      ((LinearLayout)localObject).setBackgroundColor(getContext().getResources().getColor(R.e.BG_2));
      ((LinearLayout)localObject).setId(R.h.fzl);
      AppMethodBeat.o(38360);
      return localObject;
      i = 0;
      break;
    }
  }
  
  private ArrayList<View> getHeaderViewList()
  {
    AppMethodBeat.i(256744);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.afns.size())
    {
      ListView.FixedViewInfo localFixedViewInfo = (ListView.FixedViewInfo)this.afns.get(i);
      if ((localFixedViewInfo != null) && (localFixedViewInfo.view != null)) {
        localArrayList.add(localFixedViewInfo.view);
      }
      i += 1;
    }
    AppMethodBeat.o(256744);
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
  
  private boolean hDg()
  {
    AppMethodBeat.i(38370);
    if ((this.SQO == null) || (this.afnv == null))
    {
      AppMethodBeat.o(38370);
      return false;
    }
    boolean bool = this.afnv.hDg();
    AppMethodBeat.o(38370);
    return bool;
  }
  
  private void jAa()
  {
    AppMethodBeat.i(256723);
    int j = bf.getStatusBarHeight(getContext());
    if ((this.mStatusBarHeight <= 0) && (!this.hRD)) {}
    for (int i = j;; i = this.mStatusBarHeight)
    {
      int k = this.Qhp;
      this.Qhp = (bf.fs(getContext()) + i);
      Log.i("MicroMsg.ConversationListView", "updateScrollOffset statusBarHeight:%d actionBarTop:%d scrollOffset:%d old:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(this.mStatusBarHeight), Integer.valueOf(this.Qhp), Integer.valueOf(k) });
      if ((this.afnt) && (this.afnv != null)) {
        this.afnv.anT(this.Qhp);
      }
      if (this.SQO != null) {
        this.SQO.anW(i);
      }
      if (k != this.Qhp) {
        setSelection(1);
      }
      AppMethodBeat.o(256723);
      return;
    }
  }
  
  private void jAc()
  {
    AppMethodBeat.i(38359);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.afnL.getLayoutParams();
    int i;
    float f2;
    boolean bool;
    label42:
    int k;
    int m;
    label159:
    int j;
    float f1;
    if (getAdapter() == null)
    {
      i = 0;
      f2 = aDA(i);
      if (f2 >= 0.0F) {
        break label322;
      }
      bool = true;
      k = localLayoutParams.height;
      Log.i("MicroMsg.ConversationListView", "[checkEmptyFooter] isRealFull:" + bool + " old height:" + k + " extraHeight:" + f2);
      View localView = getRootView().findViewById(R.h.fMt);
      if (localView != null) {
        Log.i("MicroMsg.ConversationListView", "alvinluo checkEmptyFooter tabView Height: %d", new Object[] { Integer.valueOf(localView.getHeight()) });
      }
      m = (int)getResources().getDimension(R.f.NormalListHeight);
      if (localView == null) {
        break label328;
      }
      i = localView.getHeight();
      j = i;
      if (i <= 0) {
        j = this.afnz;
      }
      Log.d("MicroMsg.ConversationListView", "alvinluo checkEmptyFooter tabHeight: %d", new Object[] { Integer.valueOf(j) });
      if (!bool) {
        break label333;
      }
      localLayoutParams.height = j;
      f1 = f2;
    }
    for (;;)
    {
      if (k != localLayoutParams.height)
      {
        Log.i("MicroMsg.ConversationListView", "alvinluo checkEmptyFooter isHeaderOpen: %b", new Object[] { Boolean.valueOf(glK()) });
        if (((!bool) || (Math.abs(f1) <= j + m)) && (!glK()))
        {
          Log.i("MicroMsg.ConversationListView", "[checkEmptyFooter] setSelection");
          setSelection(1);
          if (this.afnv != null) {
            this.afnv.Fi(true);
          }
        }
        this.afnL.requestLayout();
      }
      AppMethodBeat.o(38359);
      return;
      i = getAdapter().getCount();
      break;
      label322:
      bool = false;
      break label42;
      label328:
      i = 0;
      break label159;
      label333:
      f1 = f2;
      if (f2 < j) {
        f1 = j;
      }
      localLayoutParams.height = ((int)f1);
    }
  }
  
  private void jAe()
  {
    AppMethodBeat.i(38382);
    if (this.SQU != null)
    {
      if (aw.isDarkMode())
      {
        i = getResources().getColor(R.e.actionbar_title_light_color);
        this.SQU.h(0.0F, i, i);
        this.SQU.g(0.0F, getResources().getColor(R.e.dark_actionbar_color), 0);
        AppMethodBeat.o(38382);
        return;
      }
      int i = getResources().getColor(R.e.actionbar_title_color);
      this.SQU.h(0.0F, i, i);
      this.SQU.g(0.0F, getResources().getColor(R.e.normal_actionbar_color), 0);
    }
    AppMethodBeat.o(38382);
  }
  
  private void jzW()
  {
    int j = 0;
    AppMethodBeat.i(256700);
    if (this.SQO != null)
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
      addHeaderView(this.SQO);
      localArrayList.remove(this.SQO);
      Log.i("MicroMsg.ConversationListView", "addHeaderViewList addViewList: %d", new Object[] { Integer.valueOf(localArrayList.size()) });
      i = j;
      while (i < localArrayList.size())
      {
        addHeaderView((View)localArrayList.get(i));
        i += 1;
      }
      jzZ();
    }
    AppMethodBeat.o(256700);
  }
  
  private void jzX()
  {
    AppMethodBeat.i(256701);
    if (this.SQO != null)
    {
      removeHeaderView(this.SQO);
      jzZ();
    }
    AppMethodBeat.o(256701);
  }
  
  private void jzY()
  {
    AppMethodBeat.i(38340);
    if ((Build.VERSION.SDK_INT >= 24) && (LauncherUI.getInstance() != null))
    {
      this.hRD = LauncherUI.getInstance().isInMultiWindowMode();
      if (this.SQO != null) {
        this.SQO.Fk(this.hRD);
      }
    }
    AppMethodBeat.o(38340);
  }
  
  private void ox(int paramInt1, int paramInt2)
  {
    int i = 0;
    AppMethodBeat.i(256711);
    Log.i("MicroMsg.ConversationListView", "alvinluo initActionBarView statusBarHeight: %d, isInMultiWindowMode: %b, target: %d, actionBarTop: %d, actionBarHeight: %d", new Object[] { Integer.valueOf(this.mStatusBarHeight), Boolean.valueOf(this.hRD), Integer.valueOf(paramInt1), Integer.valueOf(this.oP.getTop()), Integer.valueOf(paramInt2) });
    Object localObject;
    if (paramInt1 >= 0)
    {
      if (this.hRD) {
        break label223;
      }
      int j;
      if (this.SQW != null)
      {
        localObject = this.SQW.getLayoutParams();
        j = this.mStatusBarHeight;
        if (!this.afnt) {
          break label213;
        }
        paramInt1 = 0;
        ((ViewGroup.LayoutParams)localObject).height = (paramInt1 + j);
      }
      if (this.afnE != null)
      {
        localObject = this.afnE.getLayoutParams();
        j = this.mStatusBarHeight;
        if (!this.afnt) {
          break label218;
        }
        paramInt1 = 0;
        label150:
        ((ViewGroup.LayoutParams)localObject).height = (paramInt1 + j);
      }
      label159:
      localObject = getLayoutParams();
      if ((localObject instanceof RelativeLayout.LayoutParams))
      {
        if (this.hRD) {
          break label267;
        }
        localObject = (RelativeLayout.LayoutParams)localObject;
        if (!this.afnt) {
          break label262;
        }
        paramInt1 = i;
      }
    }
    label196:
    for (((RelativeLayout.LayoutParams)localObject).topMargin = paramInt1;; ((RelativeLayout.LayoutParams)localObject).topMargin = 0)
    {
      jAa();
      AppMethodBeat.o(256711);
      return;
      label213:
      paramInt1 = paramInt2;
      break;
      label218:
      paramInt1 = paramInt2;
      break label150;
      label223:
      if (this.SQW != null) {
        this.SQW.getLayoutParams().height = paramInt1;
      }
      if (this.afnE == null) {
        break label159;
      }
      this.afnE.getLayoutParams().height = paramInt1;
      break label159;
      paramInt1 = paramInt2;
      break label196;
    }
  }
  
  final void MH(boolean paramBoolean)
  {
    AppMethodBeat.i(256814);
    boolean bool = this.afnt;
    this.afnt = true;
    Log.i("MicroMsg.ConversationListView", "updateHeaderContainer showHeaderContainer: %b, last: %b, updateView: %b, isHeaderContainerAdded: %b", new Object[] { Boolean.valueOf(this.afnt), Boolean.valueOf(bool), Boolean.valueOf(paramBoolean), Boolean.valueOf(this.afnu) });
    if (!paramBoolean)
    {
      AppMethodBeat.o(256814);
      return;
    }
    if (bool != this.afnt) {
      if (this.afnt)
      {
        if (!this.afnu)
        {
          jzW();
          this.afnu = true;
          j(200L, 0, true);
          AppMethodBeat.o(256814);
        }
      }
      else if (this.afnu)
      {
        jzX();
        this.afnu = false;
        setSelection(0);
      }
    }
    AppMethodBeat.o(256814);
  }
  
  public final void MI(boolean paramBoolean)
  {
    AppMethodBeat.i(38358);
    if (this.afnL == null)
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
          AppMethodBeat.i(256780);
          ConversationListView.i(ConversationListView.this);
          AppMethodBeat.o(256780);
        }
      }, 0L);
      AppMethodBeat.o(38358);
      return;
    }
    jAc();
    AppMethodBeat.o(38358);
  }
  
  public final float X(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(256943);
    if (getAdapter() == null)
    {
      AppMethodBeat.o(256943);
      return 0.0F;
    }
    int j = (int)getResources().getDimension(R.f.NormalListHeight);
    int k = (int)getResources().getDimension(R.f.ListFoldHeight);
    int m = paramInt1 - getHeaderViewsCount() - getFooterViewsCount();
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      float f = getMeasuredHeight() - (j * (m - paramInt2 - i) + k * i) - bf.fs(getContext()) - this.mStatusBarHeight;
      Log.i("MicroMsg.ConversationListView", "[isFullScreen] totalItemCount:" + paramInt1 + " rawCount:" + m + " foldedItemCount:" + paramInt2 + " foldItemCount:" + i + " getFirstVisiblePosition:" + getFirstVisiblePosition() + " getLastVisiblePosition:" + getLastVisiblePosition() + " getHeaderViewsCount:" + getHeaderViewsCount() + " getFooterViewsCount:" + getFooterViewsCount() + " extraHeight:" + f + " statusBarHeight: " + this.mStatusBarHeight);
      AppMethodBeat.o(256943);
      return f;
    }
  }
  
  public void addHeaderView(View paramView, Object paramObject, boolean paramBoolean)
  {
    AppMethodBeat.i(38368);
    super.addHeaderView(paramView, paramObject, paramBoolean);
    ListView.FixedViewInfo localFixedViewInfo = new ListView.FixedViewInfo(this);
    localFixedViewInfo.view = paramView;
    localFixedViewInfo.data = paramObject;
    localFixedViewInfo.isSelectable = paramBoolean;
    this.afns.add(localFixedViewInfo);
    AppMethodBeat.o(38368);
  }
  
  public final void anU(int paramInt)
  {
    AppMethodBeat.i(38356);
    md(paramInt, 0);
    AppMethodBeat.o(38356);
  }
  
  protected void attachViewToParent(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(38346);
    super.attachViewToParent(paramView, paramInt, paramLayoutParams);
    if ((this.mActionBarHeight <= 0) && (this.afnv != null))
    {
      this.mActionBarHeight = (bf.fs(getContext()) + bf.I(getContext(), 0));
      this.Qhp = (bf.fs(getContext()) + bf.getStatusBarHeight(getContext()));
      jzZ();
      if (this.SQO != null) {
        this.SQO.setActionBar(this.oP);
      }
      this.afnv.ugI = this.oP;
      this.afnv.yk = getRootView().findViewById(R.h.fMt);
    }
    AppMethodBeat.o(38346);
  }
  
  public final void cFn() {}
  
  final void cPw()
  {
    AppMethodBeat.i(256806);
    this.epi = ((d)com.tencent.mm.kernel.h.ax(d.class)).aBu();
    this.umi = ((d)com.tencent.mm.kernel.h.ax(d.class)).hEr();
    Log.d("MicroMsg.ConversationListView", "updateTeenModeStatus isTeenMode: %b, miniProgramOption: %d", new Object[] { Boolean.valueOf(this.epi), Integer.valueOf(this.umi) });
    AppMethodBeat.o(256806);
  }
  
  public boolean canScrollHorizontally(int paramInt)
  {
    AppMethodBeat.i(38338);
    if (this.SQO == null)
    {
      boolean bool = super.canScrollHorizontally(paramInt);
      AppMethodBeat.o(38338);
      return bool;
    }
    if (this.SQO.getBottom() >= this.SQO.getHeight())
    {
      AppMethodBeat.o(38338);
      return true;
    }
    AppMethodBeat.o(38338);
    return false;
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(256851);
    super.dispatchDraw(paramCanvas);
    int i = this.Qhp + this.afnH;
    if ((i >= 0) && (!glK())) {
      paramCanvas.drawLine(0.0F, i, getMeasuredWidth(), i, this.afny);
    }
    Rect localRect1;
    Rect localRect2;
    if (!this.aeLm.isEmpty())
    {
      localRect1 = new Rect();
      getLocalVisibleRect(localRect1);
      localRect2 = new Rect(localRect1);
      Rect localRect3 = new Rect(localRect1);
      if (this.aeLp) {
        break label227;
      }
      localRect2.bottom = this.aeLm.top;
      localRect3.top = this.aeLm.bottom;
      paramCanvas.drawRect(localRect2, this.aeLn);
      paramCanvas.drawRect(localRect3, this.aeLn);
    }
    for (;;)
    {
      if (Log.getLogLevel() <= 1)
      {
        Log.d("MicroMsg.ConversationListView", "mAlpha" + this.aeLn.getAlpha());
        Log.d("MicroMsg.ConversationListView", "[onDrawForeground] drawingRect:%s mHighLightItemRect:%s newStyle:%b  topRect:%s", new Object[] { localRect1, this.aeLm, Boolean.valueOf(this.aeLp), localRect2 });
      }
      AppMethodBeat.o(256851);
      return;
      label227:
      localRect2.top = this.aeLm.top;
      localRect2.bottom = this.aeLm.bottom;
      paramCanvas.drawRect(localRect2, this.aeLn);
    }
  }
  
  public boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    AppMethodBeat.i(38344);
    if ((getFirstVisiblePosition() == 0) && (paramInt2 < 0) && (paramArrayOfInt1 != null) && (paramArrayOfInt1.length >= 2) && (!this.SRs))
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
    if (this.afnK != null) {
      this.afnK.onTouch(this, paramMotionEvent);
    }
    int i;
    boolean bool;
    try
    {
      if (this.SQO != null) {
        Log.d("MicroMsg.ConversationListView", "alvinluo dispatchTouchEvent backUpFooterRect: %s, %f, %f, bottom: %d, height: %d, isCanClose: %b", new Object[] { this.SQO.getBackUpFooterRect().toString(), Float.valueOf(paramMotionEvent.getRawX()), Float.valueOf(paramMotionEvent.getRawY()), Integer.valueOf(this.SQO.getBottom()), Integer.valueOf(this.SQO.getHeight()), Boolean.valueOf(this.afnM) });
      }
      int j = (int)paramMotionEvent.getRawY();
      i = j;
      if (this.hRD) {
        i = j - this.afnG + this.mStatusBarHeight;
      }
      if ((glK()) && (this.SQO != null))
      {
        if (paramMotionEvent.getPointerCount() > 1)
        {
          paramMotionEvent.setAction(3);
          bool = this.SQO.dispatchTouchEvent(paramMotionEvent);
          AppMethodBeat.o(38371);
          return bool;
        }
        if (paramMotionEvent.getAction() == 0) {
          if (!this.SQO.getBackUpFooterRect().contains((int)paramMotionEvent.getRawX(), i)) {
            break label275;
          }
        }
        label275:
        for (this.afnN = true;; this.afnN = false)
        {
          Log.d("MicroMsg.ConversationListView", "alvinluo dispatchTouchEvent isDownInCloseRect: %b, touchY: %d", new Object[] { Boolean.valueOf(this.afnN), Integer.valueOf(i) });
          if (this.afnN) {
            break;
          }
          bool = this.SQO.dispatchTouchEvent(paramMotionEvent);
          AppMethodBeat.o(38371);
          return bool;
        }
      }
      if (this.SQO == null) {
        break label542;
      }
    }
    catch (Exception paramMotionEvent)
    {
      Log.printErrStackTrace("MicroMsg.ConversationListView", paramMotionEvent, "alvinluo ConversationListView dispatchTouchEvent exception", new Object[0]);
      AppMethodBeat.o(38371);
      return false;
    }
    if ((this.SQO.getBottom() >= this.SQO.getHeight()) && (TaskBarView.hDE()) && (getFirstVisiblePosition() == 0))
    {
      if ((paramMotionEvent.getAction() == 0) && (this.SQO.getBackUpFooterRect().contains((int)paramMotionEvent.getRawX(), i))) {
        this.afnM = true;
      }
      while ((paramMotionEvent.getAction() == 1) || (paramMotionEvent.getAction() == 3))
      {
        if (this.afnM)
        {
          this.afnM = false;
          if (this.afnv != null)
          {
            Log.i("MicroMsg.ConversationListView", "alvinluo closeHeader by click BackUpFooterRect");
            this.afnv.Eb(12);
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
            this.afnM = false;
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
      if ((this.afnv != null) && (paramMotionEvent.getAction() == 0)) {
        this.afnv.ao(paramMotionEvent);
      }
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(38371);
      return bool;
    }
    label542:
    if ((this.afnM) && (paramMotionEvent.getAction() == 1))
    {
      Log.i("MicroMsg.ConversationListView", "alvinluo ConversationListView cancel touch event..., isHeaderOpen: %b, isHeaderVisible: %b", new Object[] { Boolean.valueOf(glK()), Boolean.valueOf(hDg()) });
      if (glK()) {
        break label647;
      }
      this.afnM = false;
    }
    for (;;)
    {
      if ((paramMotionEvent.getAction() == 0) && (this.afnv != null) && (paramMotionEvent.getAction() == 0)) {
        this.afnv.ao(paramMotionEvent);
      }
      bool = super.dispatchTouchEvent(paramMotionEvent);
      AppMethodBeat.o(38371);
      return bool;
      label647:
      paramMotionEvent.setAction(3);
    }
  }
  
  public int getBannerHeaderHeight()
  {
    AppMethodBeat.i(256991);
    Iterator localIterator = this.afns.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      ListView.FixedViewInfo localFixedViewInfo = (ListView.FixedViewInfo)localIterator.next();
      if (localFixedViewInfo.view != this.SQO) {
        i = localFixedViewInfo.view.getMeasuredHeight() + i;
      }
    }
    AppMethodBeat.o(256991);
    return i;
  }
  
  public int getEmptyFooterHeight()
  {
    AppMethodBeat.i(256934);
    if (this.afnL != null) {}
    for (LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.afnL.getLayoutParams(); localLayoutParams != null; localLayoutParams = null)
    {
      int i = localLayoutParams.height;
      AppMethodBeat.o(256934);
      return i;
    }
    AppMethodBeat.o(256934);
    return 0;
  }
  
  public int getFirstHeaderVisible()
  {
    AppMethodBeat.i(38367);
    Iterator localIterator = this.afns.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject = (ListView.FixedViewInfo)localIterator.next();
      if (((ListView.FixedViewInfo)localObject).view == this.SQO)
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
    return this.afnt;
  }
  
  public TaskBarView getTaskBarView()
  {
    AppMethodBeat.i(256995);
    if (this.SQO == null)
    {
      Log.w("MicroMsg.ConversationListView", "mHeaderContainer is null");
      AppMethodBeat.o(256995);
      return null;
    }
    TaskBarView localTaskBarView = this.SQO.getTaskBarView();
    AppMethodBeat.o(256995);
    return localTaskBarView;
  }
  
  public final boolean glK()
  {
    AppMethodBeat.i(38369);
    if ((hDg()) && (this.SRs))
    {
      AppMethodBeat.o(38369);
      return true;
    }
    AppMethodBeat.o(38369);
    return false;
  }
  
  public final void hDn()
  {
    AppMethodBeat.i(38354);
    Log.i("MicroMsg.ConversationListView", "[onOpenHeader]");
    setImportantForAccessibility(2);
    this.SRs = true;
    if (this.afnA != null) {
      removeCallbacks(this.afnA);
    }
    if (this.afnD != null) {
      this.afnD.setBounceEnabled(false);
    }
    AppMethodBeat.o(38354);
  }
  
  public final void hDo()
  {
    AppMethodBeat.i(38357);
    hDn();
    AppMethodBeat.o(38357);
  }
  
  public final void j(long paramLong, final int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(256888);
    Log.i("MicroMsg.ConversationListView", "[closeHeader] delay:%s, type: %d, forceClose: %b", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    if ((getFirstVisiblePosition() != 0) && (!paramBoolean))
    {
      AppMethodBeat.o(256888);
      return;
    }
    if (paramLong > 0L)
    {
      if (this.afnB != null) {
        removeCallbacks(this.afnB);
      }
      this.afnB = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(256509);
          ConversationListView localConversationListView = ConversationListView.this;
          int i = paramInt;
          if ((localConversationListView.afnt) && (localConversationListView.afnv != null)) {
            localConversationListView.afnv.Eb(i);
          }
          AppMethodBeat.o(256509);
        }
      };
      postDelayed(this.afnB, paramLong);
      AppMethodBeat.o(256888);
      return;
    }
    setSelection(0);
    AppMethodBeat.o(256888);
  }
  
  public final void jAb()
  {
    AppMethodBeat.i(38353);
    if ((this.afnt) && (this.afnv != null)) {
      this.afnv.j(0L, 0, true);
    }
    jAd();
    AppMethodBeat.o(38353);
  }
  
  final void jAd()
  {
    AppMethodBeat.i(38381);
    if (this.oP != null)
    {
      this.oP.setTranslationY(0.0F);
      this.oP.setVisibility(0);
    }
    jAe();
    AppMethodBeat.o(38381);
  }
  
  public final void jkk()
  {
    AppMethodBeat.i(256823);
    if (this.afnv != null)
    {
      com.tencent.mm.plugin.taskbar.ui.a locala = this.afnv;
      Log.i("MicroMsg.TaskBarAnimController", "onChattingClose");
      locala.RXF = false;
    }
    AppMethodBeat.o(256823);
  }
  
  final void jzZ()
  {
    AppMethodBeat.i(256822);
    final int j;
    int k;
    if (this.oP == null)
    {
      this.oP = getRootView().findViewById(R.h.action_bar_container);
      if (this.oP != null) {
        this.oP.addOnLayoutChangeListener(this.afnJ);
      }
    }
    else
    {
      if (this.afnE == null) {
        this.afnE = getRootView().findViewById(R.h.top_status_bar);
      }
      if ((this.hRD) && (Build.VERSION.SDK_INT >= 24) && (LauncherUI.getInstance() != null))
      {
        this.hRD = LauncherUI.getInstance().isInMultiWindowMode();
        Log.i("MicroMsg.ConversationListView", "alvinluo initActionBarView check multiWindowMode %b", new Object[] { Boolean.valueOf(this.hRD) });
      }
      j = com.tencent.mm.pluginsdk.h.fs(getContext());
      k = this.mStatusBarHeight;
      if ((this.mStatusBarHeight != 0) && ((this.hRD) || (this.oP.getTop() == this.mStatusBarHeight) || (this.oP.getTop() == 0))) {
        break label297;
      }
      this.mStatusBarHeight = this.oP.getTop();
    }
    label297:
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (!this.hRD)) {
        post(new Runnable()
        {
          int nrQ = 0;
          
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
              if (this.nrQ <= 2)
              {
                Log.i("MicroMsg.ConversationListView", "alvinluo initActionBarView try again tryCount: %d", new Object[] { Integer.valueOf(this.nrQ) });
                ConversationListView.this.post(this);
              }
            }
            for (;;)
            {
              this.nrQ += 1;
              AppMethodBeat.o(38329);
              return;
              ConversationListView.b(ConversationListView.this, j);
              continue;
              ConversationListView.a(ConversationListView.this, ConversationListView.e(ConversationListView.this), j);
              ConversationListView.aDB(ConversationListView.e(ConversationListView.this));
            }
          }
        });
      }
      for (;;)
      {
        if (this.mStatusBarHeight != k)
        {
          Log.i("MicroMsg.ConversationListView", "statusBar height changed old:%d new:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(this.mStatusBarHeight) });
          MI(false);
        }
        AppMethodBeat.o(256822);
        return;
        AppMethodBeat.o(256822);
        return;
        this.mStatusBarHeight = this.oP.getTop();
        ox(this.mStatusBarHeight, j);
        cN(this.mStatusBarHeight, false);
      }
    }
  }
  
  public final void md(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(256917);
    Log.i("MicroMsg.ConversationListView", "[onCloseHeader]");
    setImportantForAccessibility(1);
    this.afnM = false;
    this.SRs = false;
    this.afnx = 0;
    if (this.afnA != null) {
      removeCallbacks(this.afnA);
    }
    if (this.afnD != null) {
      this.afnD.setBounceEnabled(true);
    }
    AppMethodBeat.o(256917);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(38375);
    super.onAttachedToWindow();
    if (this.afnI != null) {
      this.afnI.alive();
    }
    AppMethodBeat.o(38375);
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(38374);
    super.onConfigurationChanged(paramConfiguration);
    Log.i("MicroMsg.ConversationListView", "[onConfigurationChanged] orientation:%s, last: %d", new Object[] { Integer.valueOf(paramConfiguration.orientation), Integer.valueOf(this.mZT) });
    MI(true);
    jAa();
    Object localObject;
    if ((this.afnt) && (this.afnv != null))
    {
      localObject = this.afnv;
      ((com.tencent.mm.plugin.taskbar.ui.a)localObject).dHj();
      ((com.tencent.mm.plugin.taskbar.ui.a)localObject).g(1.0F, ((com.tencent.mm.plugin.taskbar.ui.a)localObject).Awb, 0);
      ((com.tencent.mm.plugin.taskbar.ui.a)localObject).dw(1.0F);
      ((com.tencent.mm.plugin.taskbar.ui.a)localObject).SRq = false;
    }
    if (this.SQO != null)
    {
      localObject = this.SQO;
      Log.i("MicroMsg.AppBrandDesktopContainer", "alvinluo AppBrandDesktopContainer onCustomConfigurationChanged newConfig orientation: %d", new Object[] { Integer.valueOf(paramConfiguration.orientation) });
      if (((TaskBarContainer)localObject).SSu != null) {
        ((TaskBarContainer)localObject).removeCallbacks(((TaskBarContainer)localObject).SSu);
      }
      ((TaskBarContainer)localObject).SSf.setVisibility(4);
      TaskBarContainer.4 local4 = new TaskBarContainer.4((TaskBarContainer)localObject);
      ((TaskBarContainer)localObject).SSu = local4;
      ((TaskBarContainer)localObject).postDelayed(local4, 400L);
      if (((TaskBarContainer)localObject).SRZ != null)
      {
        localObject = ((TaskBarContainer)localObject).SRZ;
        Log.i("MicroMsg.TaskBarView", "alvinluo TaskBarView onCustomConfigurationChanged lastOrientation: %d, orientation: %d", new Object[] { Integer.valueOf(((TaskBarView)localObject).mZT), Integer.valueOf(paramConfiguration.orientation) });
        if (((TaskBarView)localObject).SQO != null)
        {
          ((TaskBarView)localObject).SSH = ((TaskBarView)localObject).SQO.getViewHeight();
          Log.i("MicroMsg.TaskBarView", "alvinluo TaskBarView onCustomConfigurationChanged fixedViewHeight: %d", new Object[] { Integer.valueOf(((TaskBarView)localObject).SSH) });
        }
        if (((TaskBarView)localObject).mZT != paramConfiguration.orientation)
        {
          ((TaskBarView)localObject).mZT = paramConfiguration.orientation;
          if ((((TaskBarView)localObject).SQO == null) || (!((TaskBarView)localObject).SQO.hDt())) {
            break label386;
          }
          Log.i("MicroMsg.TaskBarView", "alvinluo onCustomConfigurationChanged closeHeader");
          ((TaskBarView)localObject).SQO.aE(0L, 0);
        }
      }
    }
    for (;;)
    {
      if (this.SQU != null) {
        this.SQU.Fh(true);
      }
      if (this.afnC != null) {
        removeCallbacks(this.afnC);
      }
      paramConfiguration = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(256474);
          if (aw.isDarkMode()) {
            ConversationListView.b(ConversationListView.this, ConversationListView.this.getResources().getColor(R.e.dark_actionbar_color), ConversationListView.this.getResources().getColor(R.e.actionbar_title_light_color));
          }
          for (;;)
          {
            if (ConversationListView.m(ConversationListView.this) != null) {
              ConversationListView.m(ConversationListView.this).hCY();
            }
            if (ConversationListView.c(ConversationListView.this) != null) {
              ConversationListView.c(ConversationListView.this).hDs();
            }
            ConversationListView.this.setSelection(1);
            ConversationListView.n(ConversationListView.this);
            AppMethodBeat.o(256474);
            return;
            ConversationListView.b(ConversationListView.this, ConversationListView.this.getResources().getColor(R.e.normal_actionbar_color), ConversationListView.this.getResources().getColor(R.e.actionbar_title_color));
          }
        }
      };
      this.afnC = paramConfiguration;
      postDelayed(paramConfiguration, 800L);
      this.SRs = false;
      AppMethodBeat.o(38374);
      return;
      label386:
      ((TaskBarView)localObject).eia();
    }
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(38376);
    super.onDetachedFromWindow();
    if (this.afnI != null) {
      this.afnI.dead();
    }
    AppMethodBeat.o(38376);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(38347);
    super.onDraw(paramCanvas);
    if ((this.SQO != null) && (getFirstVisiblePosition() == 0) && (TaskBarView.hDE()) && (this.SQO.getBottom() > 6))
    {
      if (this.afnx < 30)
      {
        AppMethodBeat.o(38347);
        return;
      }
      this.mPaint.setStyle(Paint.Style.FILL);
      this.mPaint.setColor(getContext().getResources().getColor(R.e.app_brand_desktop_bottom_action_bar_color));
      this.mPaint.setAlpha(this.afnx);
      paramCanvas.drawRect(this.SQO.getBackUpFooterRect().left, this.SQO.getBackUpFooterRect().top + this.afnF, this.SQO.getBackUpFooterRect().right, this.SQO.getBackUpFooterRect().bottom, this.mPaint);
    }
    AppMethodBeat.o(38347);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(38350);
    try
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      boolean bool = glK();
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
        MI(false);
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
    label85:
    int j;
    if ((this.afnt) && (paramInt1 == 0) && (this.SRB))
    {
      localObject = getChildAt(1);
      if (localObject == null) {
        if ((glK()) && (this.SQO != null))
        {
          i = this.SQO.getMeasuredHeight() - this.Qhp;
          Log.i("MicroMsg.ConversationListView", "alvinluo computeActionBarTranslation %d", new Object[] { Integer.valueOf(i) });
          i = Math.max(0, i);
          this.afnH = i;
          if (this.oP != null)
          {
            this.oP.setTranslationY(i);
            if (this.afnw != null)
            {
              localObject = this.afnw.afpq;
              if (localObject != null) {
                ((LinearLayout)localObject).setTranslationY(i);
              }
            }
          }
          if (this.afnE != null)
          {
            if (i <= 0) {
              break label545;
            }
            this.afnE.setAlpha(0.0F);
          }
          label165:
          if ((this.afnt) && (this.SQO != null))
          {
            localObject = this.SQO;
            this.SQO.getHeight();
            j = this.SQO.getHeight() - this.Qhp;
            if (((TaskBarContainer)localObject).Gtm) {
              break label556;
            }
            if (i <= 10) {
              ((TaskBarContainer)localObject).Gtm = true;
            }
          }
        }
      }
    }
    for (;;)
    {
      if (this.Knf != null) {
        this.Knf.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
      }
      if ((this.afnt) && (this.afnv != null)) {
        this.afnv.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
      }
      if ((this.afnt) && (paramInt2 > 1) && (hDg()) && (this.SQO != null))
      {
        paramAbsListView = new int[2];
        getLocationOnScreen(paramAbsListView);
        this.afnG = paramAbsListView[1];
        paramInt1 = this.SQO.getBottom() - com.tencent.mm.cd.a.fromDPToPix(getContext(), 56);
        this.SQO.getBackUpFooterRect().set(0, paramInt1, getWidth(), getHeight() + paramInt1);
        Log.d("MicroMsg.ConversationListView", "alvinluo onScroll BackUpFooterRect: %s, headerContainer top: %d, bottom: %d", new Object[] { this.SQO.getBackUpFooterRect().toString(), Integer.valueOf(this.SQO.getTop()), Integer.valueOf(this.SQO.getBottom()) });
        this.afnx = ((int)(255.0F * this.SQO.getBottom() / this.SQO.getHeight()));
      }
      AppMethodBeat.o(38349);
      return;
      i = 0;
      break;
      i = ((View)localObject).getTop();
      j = Math.max(paramInt1 - getHeaderViewsCount(), 0);
      int k = -i;
      j = (int)(j * getResources().getDimension(R.f.NormalListHeight)) + k + this.Qhp;
      Log.v("MicroMsg.ConversationListView", "[viroff] top %d translateY %d scrollOffset %d", new Object[] { Integer.valueOf(i), Integer.valueOf(-j), Integer.valueOf(this.Qhp) });
      i = -j;
      break label85;
      label545:
      this.afnE.setAlpha(1.0F);
      break label165;
      label556:
      if ((((TaskBarContainer)localObject).SSd != null) && (i > 10))
      {
        ((TaskBarContainer)localObject).SSd.setTranslationY(((TaskBarContainer)localObject).getMeasuredHeight() - ((TaskBarContainer)localObject).getBottom());
        float f = Math.max(Math.min(i * 1.0F / j * 0.4F + 0.6F, 1.0F), 0.6F);
        ((TaskBarContainer)localObject).SSd.setScaleX(f);
        ((TaskBarContainer)localObject).SSd.setScaleY(f);
        Log.v("MicroMsg.AppBrandDesktopContainer", "alvinluo HeaderContainer onScroll scale: %f, scrollY: %d, totalHeight: %d", new Object[] { Float.valueOf(f), Integer.valueOf(i), Integer.valueOf(j) });
        if (i >= j)
        {
          ((TaskBarContainer)localObject).Gtm = false;
          continue;
          if (paramInt1 > 0) {
            jAd();
          }
        }
      }
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    AppMethodBeat.i(38348);
    if (this.Knf != null) {
      this.Knf.onScrollStateChanged(paramAbsListView, paramInt);
    }
    if ((this.afnv != null) && (this.afnt)) {
      this.afnv.onScrollStateChanged(paramAbsListView, paramInt);
    }
    AppMethodBeat.o(38348);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(257022);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.afnw != null)
    {
      m localm = this.afnw;
      if (paramInt2 != paramInt4) {
        localm.cO(paramInt2, false);
      }
    }
    AppMethodBeat.o(257022);
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(38345);
    if ((this.afnt) && (this.afnv != null) && (this.afnv.onTouch(paramView, paramMotionEvent))) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = bool1;
      if (this.pWX != null) {
        bool2 = bool1 | this.pWX.onTouch(paramView, paramMotionEvent);
      }
      AppMethodBeat.o(38345);
      return bool2;
    }
  }
  
  final void oy(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(38352);
    if (this.SQU != null)
    {
      this.SQU.g(1.0F, paramInt1, 0);
      this.SQU.h(1.0F, paramInt2, paramInt2);
    }
    AppMethodBeat.o(38352);
  }
  
  public boolean removeHeaderView(View paramView)
  {
    AppMethodBeat.i(257005);
    int i = 0;
    if (i < this.afns.size())
    {
      ListView.FixedViewInfo localFixedViewInfo = (ListView.FixedViewInfo)this.afns.get(i);
      if ((localFixedViewInfo == null) || (localFixedViewInfo.view != paramView)) {}
    }
    for (;;)
    {
      if (i != -1) {
        this.afns.remove(i);
      }
      boolean bool = super.removeHeaderView(paramView);
      AppMethodBeat.o(257005);
      return bool;
      i += 1;
      break;
      i = -1;
    }
  }
  
  public final void s(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(38366);
    Log.i("MicroMsg.ConversationListView", "[showAppBrandHeader] isShow:" + paramBoolean1 + " isAnim:" + paramBoolean2 + " isScrollFirst:" + paramBoolean3);
    if (paramBoolean1)
    {
      if ((this.afnt) && (this.afnv != null))
      {
        this.afnv.hCZ();
        AppMethodBeat.o(38366);
      }
    }
    else if ((this.afnt) && (this.afnv != null)) {
      this.afnv.Eb(0);
    }
    AppMethodBeat.o(38366);
  }
  
  public void setActionBarUpdateCallback(final com.tencent.mm.plugin.taskbar.api.a parama)
  {
    AppMethodBeat.i(257030);
    if (this.afnv != null)
    {
      this.SQU = parama;
      this.afnv.SQU = new com.tencent.mm.plugin.taskbar.api.a()
      {
        public final void Fh(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(256479);
          if (parama != null) {
            parama.Fh(paramAnonymousBoolean);
          }
          AppMethodBeat.o(256479);
        }
        
        public final void g(float paramAnonymousFloat, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(256476);
          if (parama != null) {
            parama.g(paramAnonymousFloat, paramAnonymousInt1, paramAnonymousInt2);
          }
          AppMethodBeat.o(256476);
        }
        
        public final void h(float paramAnonymousFloat, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(256478);
          if (parama != null) {
            parama.h(paramAnonymousFloat, paramAnonymousInt1, paramAnonymousInt2);
          }
          AppMethodBeat.o(256478);
        }
      };
    }
    AppMethodBeat.o(257030);
  }
  
  public void setActivity(MMFragmentActivity paramMMFragmentActivity)
  {
    AppMethodBeat.i(38378);
    this.PIA = paramMMFragmentActivity;
    if (this.SQO != null) {
      this.SQO.setActivity(this.PIA);
    }
    AppMethodBeat.o(38378);
  }
  
  public void setFoldBanner(View paramView)
  {
    AppMethodBeat.i(257034);
    if (this.SQO != null) {
      this.SQO.setFoldBanner(paramView);
    }
    AppMethodBeat.o(257034);
  }
  
  public void setFoldHelper(m paramm)
  {
    this.afnw = paramm;
  }
  
  public void setHighLightChildNew(int paramInt)
  {
    AppMethodBeat.i(256876);
    this.aeLp = true;
    if (aw.isDarkMode()) {
      this.aeLn.setColor(getResources().getColor(R.e.White));
    }
    final View localView;
    for (;;)
    {
      Log.i("MicroMsg.ConversationListView", "[newStyle] setfalse" + this.aeLp);
      paramInt = Math.max(0, paramInt);
      localView = getChildAt(paramInt);
      if (localView != null) {
        break;
      }
      Log.e("MicroMsg.ConversationListView", "null == view index:%s", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(256876);
      return;
      this.aeLn.setColor(getResources().getColor(R.e.black));
    }
    if (localView.getBottom() - localView.getTop() <= 0) {
      localView = getChildAt(getHeaderViewsCount() + paramInt);
    }
    for (;;)
    {
      if (localView == null)
      {
        Log.e("MicroMsg.ConversationListView", "null == view index:%s", new Object[] { Integer.valueOf(paramInt + getHeaderViewsCount()) });
        AppMethodBeat.o(256876);
        return;
      }
      if (aw.isDarkMode()) {}
      for (Object localObject = PropertyValuesHolder.ofFloat("alpha", new float[] { 0.0F, 0.08F, 0.08F, 0.08F, 0.08F, 0.08F, 0.0F });; localObject = PropertyValuesHolder.ofFloat("alpha", new float[] { 0.0F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.0F }))
      {
        localObject = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { localObject });
        localView.getGlobalVisibleRect(this.aeLm);
        ((ValueAnimator)localObject).addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
          public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
          {
            AppMethodBeat.i(256465);
            localView.getGlobalVisibleRect(ConversationListView.f(ConversationListView.this));
            float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue("alpha")).floatValue();
            ConversationListView.g(ConversationListView.this).setAlpha((int)(255.0F * f));
            if (Log.getLogLevel() <= 1) {
              Log.d("MicroMsg.ConversationListView", "m ALpha" + f * 255.0F);
            }
            ConversationListView.this.postInvalidate();
            AppMethodBeat.o(256465);
          }
        });
        ((ValueAnimator)localObject).addListener(new AnimatorListenerAdapter()
        {
          public final void onAnimationEnd(Animator paramAnonymousAnimator)
          {
            AppMethodBeat.i(256464);
            super.onAnimationEnd(paramAnonymousAnimator);
            ConversationListView.f(ConversationListView.this).setEmpty();
            AppMethodBeat.o(256464);
          }
          
          public final void onAnimationStart(Animator paramAnonymousAnimator)
          {
            AppMethodBeat.i(256459);
            super.onAnimationStart(paramAnonymousAnimator);
            ConversationListView.h(ConversationListView.this);
            AppMethodBeat.o(256459);
          }
        });
        ((ValueAnimator)localObject).setDuration(1150L);
        ((ValueAnimator)localObject).start();
        AppMethodBeat.o(256876);
        return;
      }
    }
  }
  
  public void setIsCurrentMainUI(boolean paramBoolean)
  {
    AppMethodBeat.i(38380);
    Log.i("MicroMsg.ConversationListView", "alvinluo setIsCurrentMainUI: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.SRB = paramBoolean;
    if (this.afnv != null)
    {
      com.tencent.mm.plugin.taskbar.ui.a locala = this.afnv;
      locala.SRB = paramBoolean;
      if ((!paramBoolean) && (locala.SRs))
      {
        Log.i("MicroMsg.TaskBarAnimController", "alvinluo setIsCurrentMainUI and header open, close");
        locala.j(0L, 0, true);
      }
    }
    AppMethodBeat.o(38380);
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    AppMethodBeat.i(38373);
    this.vT = paramOnItemClickListener;
    super.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(256475);
        Log.i("MicroMsg.ConversationListView", "alvinluo onItemClick isCanClose: %b", new Object[] { Boolean.valueOf(ConversationListView.j(ConversationListView.this)) });
        if ((ConversationListView.l(ConversationListView.this) != null) && (!ConversationListView.j(ConversationListView.this))) {
          ConversationListView.l(ConversationListView.this).onItemClick(paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
        }
        AppMethodBeat.o(256475);
      }
    });
    AppMethodBeat.o(38373);
  }
  
  public void setOnItemLongClickListener(AdapterView.OnItemLongClickListener paramOnItemLongClickListener)
  {
    AppMethodBeat.i(38372);
    this.aeaB = paramOnItemLongClickListener;
    super.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(256773);
        Log.i("MicroMsg.ConversationListView", "alvinluo onItemLongClick isCanClose: %b", new Object[] { Boolean.valueOf(ConversationListView.j(ConversationListView.this)) });
        if ((ConversationListView.k(ConversationListView.this) != null) && (!ConversationListView.j(ConversationListView.this)))
        {
          boolean bool = ConversationListView.k(ConversationListView.this).onItemLongClick(paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
          AppMethodBeat.o(256773);
          return bool;
        }
        AppMethodBeat.o(256773);
        return false;
      }
    });
    AppMethodBeat.o(38372);
  }
  
  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.Knf = paramOnScrollListener;
  }
  
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    this.pWX = paramOnTouchListener;
  }
  
  public void setSelection(int paramInt)
  {
    AppMethodBeat.i(38362);
    Log.i("MicroMsg.ConversationListView", "[setSelection] position:%s, scrollOffset: %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(this.Qhp) });
    if (paramInt == 0)
    {
      super.setSelectionFromTop(getFirstHeaderVisible(), this.Qhp);
      AppMethodBeat.o(38362);
      return;
    }
    super.setSelectionFromTop(paramInt, this.Qhp);
    AppMethodBeat.o(38362);
  }
  
  public void setSelectionFromTop(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(256961);
    Log.i("MicroMsg.ConversationListView", "[setSelectionFromTop] position:%s, scrollOffset: %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    super.setSelectionFromTop(paramInt1, paramInt2);
    AppMethodBeat.o(256961);
  }
  
  public void setStatusBarMaskView(View paramView)
  {
    AppMethodBeat.i(38379);
    this.SQW = paramView;
    if (this.afnv != null) {
      this.afnv.SQW = paramView;
    }
    AppMethodBeat.o(38379);
  }
  
  public void setonDispatchTouchEventListener(View.OnTouchListener paramOnTouchListener)
  {
    this.afnK = paramOnTouchListener;
  }
  
  public void smoothScrollToPosition(int paramInt)
  {
    AppMethodBeat.i(38363);
    Log.i("MicroMsg.ConversationListView", "[smoothScrollToPosition] position:%s", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 0)
    {
      super.smoothScrollToPositionFromTop(getFirstHeaderVisible(), this.Qhp);
      AppMethodBeat.o(38363);
      return;
    }
    super.smoothScrollToPositionFromTop(paramInt, this.Qhp);
    AppMethodBeat.o(38363);
  }
  
  public void smoothScrollToPositionFromTop(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(38364);
    Log.i("MicroMsg.ConversationListView", "[smoothScrollToPositionFromTop] position:%s offset:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == 0)
    {
      super.smoothScrollToPositionFromTop(getFirstHeaderVisible(), this.Qhp + paramInt2);
      AppMethodBeat.o(38364);
      return;
    }
    super.smoothScrollToPositionFromTop(paramInt1, this.Qhp + paramInt2);
    AppMethodBeat.o(38364);
  }
  
  public void smoothScrollToPositionFromTop(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(38365);
    Log.i("MicroMsg.ConversationListView", "[smoothScrollToPositionFromTop] position:%s offset:%s duration:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (paramInt1 == 0)
    {
      super.smoothScrollToPositionFromTop(getFirstHeaderVisible(), this.Qhp + paramInt2, paramInt3);
      AppMethodBeat.o(38365);
      return;
    }
    super.smoothScrollToPositionFromTop(paramInt1, this.Qhp + paramInt2, paramInt3);
    AppMethodBeat.o(38365);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.ConversationListView
 * JD-Core Version:    0.7.0.1
 */
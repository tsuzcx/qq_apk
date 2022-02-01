package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.support.v7.app.ActionBar;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowInsets;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.multitask.ui.uic.MultiTaskUIC.b;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.ui.base.OnLayoutChangedLinearLayout;
import com.tencent.mm.ui.base.OnLayoutChangedLinearLayout.a;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.conversation.ConversationListView;
import com.tencent.mm.ui.conversation.MainUI;
import com.tencent.mm.ui.tools.TestTimeForChatting;
import com.tencent.mm.ui.tools.TestTimeForChatting.a;
import com.tencent.mm.ui.tools.j;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.ui.widget.h;
import java.util.HashMap;

public class NewChattingTabUI
  implements LauncherUI.a
{
  MMFragmentActivity Dpx;
  LauncherUI.b OJE;
  long OJF;
  private TestTimeForChatting OJG;
  private int OJH;
  MessageQueue.IdleHandler OJI;
  private OnLayoutChangedLinearLayout OJJ;
  String OJK;
  private String OJL;
  private Bundle OJM;
  BaseChattingUIFragment OJN;
  private long OJO;
  a OJP;
  boolean OJQ;
  boolean isAnimating;
  boolean mChattingClosed;
  Animation mChattingInAnim;
  private Animation mChattingOutAnim;
  private IChattingUIProxy mChattingUIProxy;
  private boolean mNeedChattingAnim;
  Bitmap mPrepareBitmap;
  Runnable mStartChattingRunnable;
  private OnLayoutChangedLinearLayout.a onChattingLayoutChangedListener;
  
  public NewChattingTabUI(LauncherUI.b paramb)
  {
    AppMethodBeat.i(33655);
    this.OJF = 0L;
    this.mChattingClosed = true;
    this.isAnimating = false;
    this.OJP = new a((byte)0);
    this.OJQ = false;
    this.mStartChattingRunnable = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(232691);
        if (!NewChattingTabUI.k(NewChattingTabUI.this))
        {
          Log.e("MicroMsg.LauncherUI.NewChattingTabUI", "start chatting but last chatting does't be close!");
          NewChattingTabUI.this.Bq(false);
        }
        if ((NewChattingTabUI.g(NewChattingTabUI.this).isFinishing()) || (NewChattingTabUI.g(NewChattingTabUI.this).isPaused()) || (!NewChattingTabUI.k(NewChattingTabUI.this)))
        {
          Log.w("MicroMsg.LauncherUI.NewChattingTabUI", "[mStartChattingRunnable] pass! isPause:%s mChattingClosed:%s", new Object[] { Boolean.valueOf(NewChattingTabUI.g(NewChattingTabUI.this).isPaused()), Boolean.valueOf(NewChattingTabUI.k(NewChattingTabUI.this)) });
          NewChattingTabUI.l(NewChattingTabUI.this);
          AppMethodBeat.o(232691);
          return;
        }
        NewChattingTabUI.m(NewChattingTabUI.this);
        boolean bool;
        if (NewChattingTabUI.d(NewChattingTabUI.this) == null)
        {
          bool = false;
          Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "ashutest::startChatting, ishow:%b", new Object[] { Boolean.valueOf(bool) });
          Intent localIntent = new Intent().putExtra("Chat_User", NewChattingTabUI.n(NewChattingTabUI.this));
          if (NewChattingTabUI.o(NewChattingTabUI.this) != null) {
            localIntent.putExtras(NewChattingTabUI.o(NewChattingTabUI.this));
          }
          localIntent.putExtra("img_gallery_enter_from_chatting_ui", true);
          NewChattingTabUI.a(NewChattingTabUI.this, localIntent, false);
          NewChattingTabUI.q(NewChattingTabUI.this).setOnChattingLayoutChangedListener(NewChattingTabUI.p(NewChattingTabUI.this));
          NewChattingTabUI.d(NewChattingTabUI.this).setVisibility(0);
          if (NewChattingTabUI.g(NewChattingTabUI.this).getWindow().getDecorView().getWidth() != 0) {
            break label355;
          }
        }
        label355:
        for (float f = NewChattingTabUI.g(NewChattingTabUI.this).getResources().getDisplayMetrics().widthPixels;; f = NewChattingTabUI.g(NewChattingTabUI.this).getWindow().getDecorView().getWidth())
        {
          NewChattingTabUI.d(NewChattingTabUI.this).setTranslationX(f - 0.1F);
          NewChattingTabUI.a(NewChattingTabUI.this, Util.nowSecond());
          NewChattingTabUI.r(NewChattingTabUI.this);
          if (NewChattingTabUI.s(NewChattingTabUI.this)) {
            h.a(NewChattingTabUI.g(NewChattingTabUI.this));
          }
          AppMethodBeat.o(232691);
          return;
          bool = NewChattingTabUI.d(NewChattingTabUI.this).isShown();
          break;
        }
      }
      
      public final String toString()
      {
        AppMethodBeat.i(232692);
        String str = super.toString() + "|startChattingRunnable";
        AppMethodBeat.o(232692);
        return str;
      }
    };
    this.onChattingLayoutChangedListener = new OnLayoutChangedLinearLayout.a()
    {
      long start = 0L;
      
      public final void gJw()
      {
        AppMethodBeat.i(232696);
        if (NewChattingTabUI.t(NewChattingTabUI.this) == null)
        {
          NewChattingTabUI.a(NewChattingTabUI.this, AnimationUtils.loadAnimation(NewChattingTabUI.g(NewChattingTabUI.this), MMFragmentActivity.a.ogm));
          NewChattingTabUI.t(NewChattingTabUI.this).setAnimationListener(new Animation.AnimationListener()
          {
            public final void onAnimationEnd(Animation paramAnonymous2Animation)
            {
              AppMethodBeat.i(232694);
              NewChattingTabUI.v(NewChattingTabUI.this);
              AppMethodBeat.o(232694);
            }
            
            public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
            
            public final void onAnimationStart(Animation paramAnonymous2Animation)
            {
              AppMethodBeat.i(232693);
              NewChattingTabUI.u(NewChattingTabUI.this);
              NewChattingTabUI.this.ac(false, 0);
              AppMethodBeat.o(232693);
            }
          });
        }
        if (NewChattingTabUI.w(NewChattingTabUI.this))
        {
          NewChattingTabUI.d(NewChattingTabUI.this).setOndispatchDraw(new TestTimeForChatting.a()
          {
            public final void gJx()
            {
              AppMethodBeat.i(232695);
              Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "[onDrawed]");
              NewChattingTabUI.7.this.start = System.currentTimeMillis();
              if (NewChattingTabUI.c(NewChattingTabUI.this).getSwipeBackLayout() != null)
              {
                NewChattingTabUI.c(NewChattingTabUI.this).getSwipeBackLayout().setNeedChangeWindowBackground(false);
                NewChattingTabUI.c(NewChattingTabUI.this).getSwipeBackLayout().startAnimation(NewChattingTabUI.t(NewChattingTabUI.this));
              }
              for (;;)
              {
                NewChattingTabUI.d(NewChattingTabUI.this).setOndispatchDraw(null);
                AppMethodBeat.o(232695);
                return;
                NewChattingTabUI.c(NewChattingTabUI.this).getView().startAnimation(NewChattingTabUI.t(NewChattingTabUI.this));
              }
            }
          });
          NewChattingTabUI.x(NewChattingTabUI.this);
        }
        for (;;)
        {
          NewChattingTabUI.q(NewChattingTabUI.this).OWo = null;
          Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "klem CHATTING ONLAYOUT ");
          AppMethodBeat.o(232696);
          return;
          NewChattingTabUI.u(NewChattingTabUI.this);
          NewChattingTabUI.v(NewChattingTabUI.this);
        }
      }
    };
    this.OJE = paramb;
    AppMethodBeat.o(33655);
  }
  
  static boolean acceptRequestCode(int paramInt)
  {
    AppMethodBeat.i(33657);
    paramInt = 0xFFFF & paramInt;
    Log.w("MicroMsg.LauncherUI.NewChattingTabUI", "check request code %d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(33657);
      return false;
    }
    AppMethodBeat.o(33657);
    return true;
  }
  
  private ViewGroup gJu()
  {
    AppMethodBeat.i(33659);
    ViewParent localViewParent = this.Dpx.getSupportActionBar().getCustomView().getParent();
    Object localObject3 = null;
    View localView2 = this.Dpx.getWindow().getDecorView();
    View localView1 = localView2;
    Object localObject2 = localObject3;
    Object localObject1 = localViewParent;
    if (Build.VERSION.SDK_INT >= 24)
    {
      localView1 = localView2;
      localObject2 = localObject3;
      localObject1 = localViewParent;
      if (LauncherUI.getInstance().isInMultiWindowMode())
      {
        localView1 = ((ViewGroup)localView2).getChildAt(0);
        localObject1 = localViewParent;
        localObject2 = localObject3;
      }
    }
    while ((localObject1 != localView1) && (localObject1 != null))
    {
      localViewParent = ((ViewParent)localObject1).getParent();
      localObject2 = localObject1;
      localObject1 = localViewParent;
    }
    if ((localObject2 instanceof ViewGroup))
    {
      localObject1 = (ViewGroup)localObject2;
      AppMethodBeat.o(33659);
      return localObject1;
    }
    localObject1 = (ViewGroup)localView1;
    AppMethodBeat.o(33659);
    return localObject1;
  }
  
  private Bitmap getMagicDrawingCache(View paramView)
  {
    AppMethodBeat.i(33662);
    long l = System.currentTimeMillis();
    int j = paramView.getWidth();
    int k = paramView.getHeight();
    int i = j;
    if (j <= 0) {
      i = paramView.getMeasuredWidth();
    }
    j = k;
    if (k <= 0) {
      j = paramView.getMeasuredHeight();
    }
    if ((i <= 0) || (j <= 0))
    {
      Log.e("MicroMsg.LauncherUI.NewChattingTabUI", "viewWidth:%s viewHeight:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      AppMethodBeat.o(33662);
      return null;
    }
    if (this.OJN.getView() == null)
    {
      AppMethodBeat.o(33662);
      return null;
    }
    if (this.OJN != null) {
      Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "getBottom:%s keyboardState:%s", new Object[] { Integer.valueOf(this.OJN.getView().getBottom()), Integer.valueOf(this.OJN.keyboardState()) });
    }
    if ((this.OJN != null) && (this.OJN.getView().getBottom() > 0) && ((this.OJN.keyboardState() == 1) || (this.OJN.getView().getBottom() < this.Dpx.getResources().getDisplayMetrics().heightPixels * 2 / 3)))
    {
      Log.e("MicroMsg.LauncherUI.NewChattingTabUI", "hardKeyboardHidden:%s", new Object[] { Integer.valueOf(this.OJN.keyboardState()) });
      this.Dpx.getWindow().setBackgroundDrawableResource(2131101007);
      AppMethodBeat.o(33662);
      return null;
    }
    if ((this.mPrepareBitmap == null) || (this.mPrepareBitmap.isRecycled()) || (this.mPrepareBitmap.getWidth() != i) || (this.mPrepareBitmap.getHeight() != j))
    {
      if ((this.mPrepareBitmap != null) && (!this.mPrepareBitmap.isRecycled()))
      {
        Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "bitmap recycle %s", new Object[] { this.mPrepareBitmap.toString() });
        this.mPrepareBitmap.recycle();
      }
      try
      {
        this.mPrepareBitmap = BitmapUtil.createBitmap(i, j, Bitmap.Config.ARGB_4444);
        if (this.mPrepareBitmap == null)
        {
          AppMethodBeat.o(33662);
          return null;
        }
      }
      catch (OutOfMemoryError paramView)
      {
        Log.e("MicroMsg.LauncherUI.NewChattingTabUI", "[getMagicDrawingCache] e:%s", new Object[] { paramView });
        AppMethodBeat.o(33662);
        return null;
      }
    }
    paramView.draw(new Canvas(this.mPrepareBitmap));
    Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "[getMagicDrawingCache] cost%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    paramView = this.mPrepareBitmap;
    AppMethodBeat.o(33662);
    return paramView;
  }
  
  private int getTopHeight()
  {
    AppMethodBeat.i(33658);
    int i = au.getStatusBarHeight(this.Dpx);
    if ((Build.VERSION.SDK_INT >= 24) && (LauncherUI.getInstance() != null)) {}
    for (boolean bool1 = LauncherUI.getInstance().isInMultiWindowMode();; bool1 = false)
    {
      SharedPreferences localSharedPreferences;
      if (!bool1)
      {
        localSharedPreferences = MMApplicationContext.getDefaultPreference();
        if (localSharedPreferences == null) {
          break label131;
        }
      }
      label131:
      for (boolean bool2 = localSharedPreferences.getBoolean("Main_need_read_top_margin", false);; bool2 = false)
      {
        if (bool2)
        {
          int j = localSharedPreferences.getInt("Main_top_marign", -1);
          if (j >= 0)
          {
            AppMethodBeat.o(33658);
            return j;
          }
        }
        if (bool1) {
          i = 0;
        }
        Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "getTopHeight statusHeight:%s, isInMultiWindowMode:%s", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1) });
        AppMethodBeat.o(33658);
        return i;
      }
    }
  }
  
  static void resetViewTranX(View paramView, ImageView paramImageView, float paramFloat)
  {
    AppMethodBeat.i(33666);
    if (Float.compare(1.0F, paramFloat) <= 0)
    {
      j.q(paramView, 0.0F);
      j.q(paramImageView, 0.0F);
      AppMethodBeat.o(33666);
      return;
    }
    if ((paramImageView != null) && (paramImageView.getDrawable() != null))
    {
      j.q(paramImageView, paramImageView.getWidth() / 2.5F * (1.0F - paramFloat) * -1.0F);
      AppMethodBeat.o(33666);
      return;
    }
    if (paramView != null) {
      j.q(paramView, paramView.getWidth() / 2.5F * (1.0F - paramFloat) * -1.0F);
    }
    AppMethodBeat.o(33666);
  }
  
  private void tryResetChattingSwipeStatus()
  {
    boolean bool = true;
    AppMethodBeat.i(33664);
    if (!gJv())
    {
      AppMethodBeat.o(33664);
      return;
    }
    if (this.OJN == null) {}
    for (;;)
    {
      Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "ashutest: tryResetChattingSwipeStatus, chattingFragment NULL ? %B", new Object[] { Boolean.valueOf(bool) });
      if (this.OJN != null) {
        this.OJN.getSwipeBackLayout().hfx = false;
      }
      AppMethodBeat.o(33664);
      return;
      bool = false;
    }
  }
  
  public final boolean Bq(boolean paramBoolean)
  {
    AppMethodBeat.i(33663);
    if (this.OJG == null) {}
    for (boolean bool = false;; bool = this.OJG.isShown())
    {
      Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "try closeChatting, ishow:%b", new Object[] { Boolean.valueOf(bool) });
      if ((this.OJN != null) && (this.OJN.getView() != null)) {
        this.OJN.getView().setImportantForAccessibility(4);
      }
      if ((this.OJG != null) && (this.OJG.getVisibility() != 8) && (this.OJN != null) && (this.Dpx != null)) {
        break;
      }
      AppMethodBeat.o(33663);
      return false;
    }
    if ((this.OJN != null) && (this.OJN.isSupportNavigationSwipeBack())) {
      h.b(this.Dpx);
    }
    Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "[closeChatting] needAnim:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    pl(4);
    this.mChattingClosed = true;
    if ((paramBoolean) && (this.mChattingOutAnim == null))
    {
      this.mChattingOutAnim = AnimationUtils.loadAnimation(this.Dpx, MMFragmentActivity.a.ogp);
      this.mChattingOutAnim.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(232698);
          NewChattingTabUI.a(NewChattingTabUI.this, false);
          NewChattingTabUI.d(NewChattingTabUI.this).setVisibility(8);
          bg.aAk().setLowPriority();
          MMHandlerThread.setCurrentPriority(0);
          NewChattingTabUI.y(NewChattingTabUI.this);
          Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "klem pop out onAnimationEnd");
          AppMethodBeat.o(232698);
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(232697);
          NewChattingTabUI.a(NewChattingTabUI.this, true);
          bg.aAk().setLowestPriority();
          MMHandlerThread.setCurrentPriority(-8);
          NewChattingTabUI.this.ac(true, 0);
          Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "klem pop out onAnimationStart");
          AppMethodBeat.o(232697);
        }
      });
    }
    aa.d(true, new Intent().putExtra("classname", "mainui").putExtra("main_process", false));
    if (this.OJN.isSupportCustomActionBar())
    {
      ImageView localImageView = (ImageView)this.Dpx.getWindow().getDecorView().findViewById(2131306100);
      if ((localImageView != null) && (localImageView.getVisibility() == 0))
      {
        localImageView.setVisibility(8);
        Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "[closeChatting] prepareView GONE");
      }
    }
    alj(0);
    if (paramBoolean)
    {
      this.mChattingUIProxy.onExitBegin();
      this.mChattingUIProxy.onExitEnd();
      this.OJG.startAnimation(this.mChattingOutAnim);
    }
    for (;;)
    {
      AppMethodBeat.o(33663);
      return true;
      this.mChattingUIProxy.onExitBegin();
      this.mChattingUIProxy.onExitEnd();
      this.OJG.setVisibility(8);
      this.Dpx.onSwipe(1.0F);
      tryResetChattingSwipeStatus();
    }
  }
  
  public final boolean ac(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(33665);
    Log.v("MicroMsg.LauncherUI.NewChattingTabUI", "ashutest: on settle %B, speed %d, resumeStatus %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), Boolean.valueOf(this.OJE.gHZ()) });
    if (!gJv())
    {
      AppMethodBeat.o(33665);
      return true;
    }
    if (paramBoolean) {
      this.OJE.gIc();
    }
    if (!this.OJE.gHZ())
    {
      AppMethodBeat.o(33665);
      return false;
    }
    View localView = this.Dpx.findViewById(2131303052);
    if (localView == null)
    {
      Log.e("MicroMsg.LauncherUI.NewChattingTabUI", "[onSettle] null == container");
      AppMethodBeat.o(33665);
      return true;
    }
    ImageView localImageView = (ImageView)this.Dpx.findViewById(2131306100);
    if ((localImageView != null) && (localImageView.getVisibility() == 8) && (localImageView.getDrawable() != null))
    {
      localImageView.setVisibility(0);
      Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "[onSettle] prepareView VISIBLE");
      localView.setVisibility(8);
    }
    if ((localImageView != null) && (localImageView.getVisibility() == 0)) {
      if (localImageView.getWidth() == 0)
      {
        paramInt = this.Dpx.getResources().getDisplayMetrics().widthPixels;
        if (!paramBoolean) {
          break label250;
        }
        j.a(localImageView, 182L, 0.0F, null);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(33665);
      return true;
      paramInt = localImageView.getWidth();
      break;
      label250:
      j.a(localImageView, 208L, paramInt * -1 / 3.5F, null);
      continue;
      if (localView.getWidth() == 0) {}
      for (paramInt = this.Dpx.getResources().getDisplayMetrics().widthPixels;; paramInt = localView.getWidth())
      {
        if (!paramBoolean) {
          break label315;
        }
        j.a(localView, 182L, 0.0F, null);
        break;
      }
      label315:
      j.a(localView, 208L, paramInt * -1 / 3.5F, null);
    }
  }
  
  final void alj(int paramInt)
  {
    AppMethodBeat.i(33667);
    Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "[setLauncherContainerVisible] visible:%s", new Object[] { Integer.valueOf(paramInt) });
    if (this.Dpx == null)
    {
      Log.e("MicroMsg.LauncherUI.NewChattingTabUI", "[setLauncherContainerVisible] getActivity is null");
      AppMethodBeat.o(33667);
      return;
    }
    View localView = this.Dpx.findViewById(2131303052);
    if ((localView != null) && (localView.getVisibility() != paramInt)) {
      localView.setVisibility(paramInt);
    }
    AppMethodBeat.o(33667);
  }
  
  public final void gHP()
  {
    AppMethodBeat.i(232701);
    if (gIx())
    {
      pl(4);
      if ((this.OJN != null) && (this.OJN.isSupportNavigationSwipeBack())) {
        this.OJN.getSwipeBackLayout().setEnableGesture(false);
      }
    }
    AppMethodBeat.o(232701);
  }
  
  public final boolean gIx()
  {
    if (this.OJN == null) {
      return false;
    }
    return this.OJN.dom.cQp;
  }
  
  final boolean gJv()
  {
    AppMethodBeat.i(33660);
    if ((com.tencent.mm.compatible.util.d.oD(19)) && (com.tencent.mm.compatible.h.b.apl()) && (!com.tencent.mm.compatible.e.b.cv(this.Dpx)))
    {
      AppMethodBeat.o(33660);
      return true;
    }
    AppMethodBeat.o(33660);
    return false;
  }
  
  final void pl(final int paramInt)
  {
    AppMethodBeat.i(33661);
    if (this.OJN == null)
    {
      AppMethodBeat.o(33661);
      return;
    }
    ThreadPool.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(33641);
        com.tencent.mm.modelstat.d.d(paramInt, "ChattingUI" + NewChattingTabUI.i(NewChattingTabUI.this), hashCode());
        if (paramInt == 4) {
          com.tencent.mm.modelstat.d.m("ChattingUI" + NewChattingTabUI.i(NewChattingTabUI.this), NewChattingTabUI.j(NewChattingTabUI.this), Util.nowSecond());
        }
        AppMethodBeat.o(33641);
      }
    }, "MicroMsg.LauncherUI.NewChattingTabUI|report");
    AppMethodBeat.o(33661);
  }
  
  public final void startChatting(String paramString, Bundle paramBundle, boolean paramBoolean)
  {
    AppMethodBeat.i(33656);
    this.OJO = System.currentTimeMillis();
    if (this.OJG == null) {}
    for (boolean bool = false;; bool = this.OJG.isShown())
    {
      Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "try startChatting, ishow:%b userName:%s needAnim:%b", new Object[] { Boolean.valueOf(bool), paramString, Boolean.valueOf(paramBoolean) });
      if ((this.OJN != null) && (this.OJN.getView() != null)) {
        this.OJN.getView().setImportantForAccessibility(1);
      }
      bg.getNotification().dh(false);
      this.OJQ = false;
      this.OJM = paramBundle;
      this.OJL = paramString;
      this.mNeedChattingAnim = paramBoolean;
      if ((!ao.gJN()) || ((!ao.gJL()) && (!ao.gJM()) && (!ao.gJK()))) {
        break;
      }
      paramString = new Intent(this.Dpx, ChattingUI.class);
      paramString.putExtra("Chat_User", this.OJL);
      if (paramBundle != null) {
        paramString.putExtras(paramBundle);
      }
      paramBundle = this.Dpx;
      paramString = new com.tencent.mm.hellhoundlib.b.a().bl(paramString);
      com.tencent.mm.hellhoundlib.a.a.a(paramBundle, paramString.axQ(), "com/tencent/mm/ui/NewChattingTabUI", "startChatting", "(Ljava/lang/String;Landroid/os/Bundle;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramBundle.startActivity((Intent)paramString.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramBundle, "com/tencent/mm/ui/NewChattingTabUI", "startChatting", "(Ljava/lang/String;Landroid/os/Bundle;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(33656);
      return;
    }
    bg.aAk().setLowestPriority();
    MMHandlerThread.setCurrentPriority(-8);
    MMHandlerThread.removeRunnable(this.mStartChattingRunnable);
    MMHandlerThread.postToMainThread(this.mStartChattingRunnable);
    AppMethodBeat.o(33656);
  }
  
  final class a
    implements Runnable
  {
    int OJY = 0;
    Intent dQs;
    int requestCode;
    int resultCode;
    
    private a() {}
    
    public final void run()
    {
      AppMethodBeat.i(33653);
      if ((bg.aAc()) && (NewChattingTabUI.a(NewChattingTabUI.this) != null))
      {
        Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "on post select image job, acc has ready, retry count %d", new Object[] { Integer.valueOf(this.OJY) });
        NewChattingTabUI.this.startChatting(NewChattingTabUI.b(NewChattingTabUI.this), null, false);
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            boolean bool = true;
            AppMethodBeat.i(33651);
            if (NewChattingTabUI.c(NewChattingTabUI.this) == null) {}
            for (;;)
            {
              Log.d("MicroMsg.LauncherUI.NewChattingTabUI", "on select image ActivityResult. after creat chattingUI, chatting fragment is null? %B", new Object[] { Boolean.valueOf(bool) });
              if (NewChattingTabUI.c(NewChattingTabUI.this) != null)
              {
                Log.d("MicroMsg.LauncherUI.NewChattingTabUI", "on select image ActivityResult. do post activity result");
                NewChattingTabUI.c(NewChattingTabUI.this).onActivityResult(NewChattingTabUI.a.this.requestCode & 0xFFFF, NewChattingTabUI.a.this.resultCode, NewChattingTabUI.a.this.dQs);
              }
              AppMethodBeat.o(33651);
              return;
              bool = false;
            }
          }
          
          public final String toString()
          {
            AppMethodBeat.i(33652);
            String str = super.toString() + "|PostSelectImageJob_onActivityResult";
            AppMethodBeat.o(33652);
            return str;
          }
        });
        AppMethodBeat.o(33653);
        return;
      }
      if (this.OJY >= 3)
      {
        Log.w("MicroMsg.LauncherUI.NewChattingTabUI", "on post select image job, match max retry count");
        AppMethodBeat.o(33653);
        return;
      }
      if (NewChattingTabUI.a(NewChattingTabUI.this) != null) {}
      for (boolean bool = true;; bool = false)
      {
        Log.w("MicroMsg.LauncherUI.NewChattingTabUI", "on post select image job, acc not ready or view init(%B), cur retry count %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.OJY) });
        this.OJY += 1;
        MMHandlerThread.postToMainThreadDelayed(this, 300L);
        AppMethodBeat.o(33653);
        return;
      }
    }
    
    public final String toString()
    {
      AppMethodBeat.i(33654);
      String str = super.toString() + "|PostSelectImageJob";
      AppMethodBeat.o(33654);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.NewChattingTabUI
 * JD-Core Version:    0.7.0.1
 */
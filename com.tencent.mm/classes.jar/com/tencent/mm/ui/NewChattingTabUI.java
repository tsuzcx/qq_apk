package com.tencent.mm.ui;

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
import androidx.appcompat.app.ActionBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.h;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.multitask.ui.uic.c.b;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.ui.base.OnLayoutChangedLinearLayout;
import com.tencent.mm.ui.base.OnLayoutChangedLinearLayout.a;
import com.tencent.mm.ui.base.ag;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.tools.TestTimeForChatting;
import com.tencent.mm.ui.tools.TestTimeForChatting.a;
import com.tencent.mm.ui.tools.k;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.ui.widget.l;

public class NewChattingTabUI
  implements LauncherUI.a
{
  MMFragmentActivity PIA;
  LauncherUI.b adIC;
  long adID;
  private TestTimeForChatting adIE;
  private int adIF;
  MessageQueue.IdleHandler adIG;
  private OnLayoutChangedLinearLayout adIH;
  String adII;
  private String adIJ;
  private Bundle adIK;
  BaseChattingUIFragment adIL;
  private long adIM;
  a adIN;
  boolean adIO;
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
    this.adID = 0L;
    this.mChattingClosed = true;
    this.isAnimating = false;
    this.adIN = new a((byte)0);
    this.adIO = false;
    this.mStartChattingRunnable = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(249166);
        if (!NewChattingTabUI.k(NewChattingTabUI.this))
        {
          Log.e("MicroMsg.LauncherUI.NewChattingTabUI", "start chatting but last chatting does't be close!");
          NewChattingTabUI.this.Lq(false);
        }
        if ((NewChattingTabUI.g(NewChattingTabUI.this).isFinishing()) || (NewChattingTabUI.g(NewChattingTabUI.this).isPaused()) || (!NewChattingTabUI.k(NewChattingTabUI.this)) || (!h.baC().aZN()))
        {
          Log.w("MicroMsg.LauncherUI.NewChattingTabUI", "[mStartChattingRunnable] pass! isPause:%s mChattingClosed:%s, account:%s", new Object[] { Boolean.valueOf(NewChattingTabUI.g(NewChattingTabUI.this).isPaused()), Boolean.valueOf(NewChattingTabUI.k(NewChattingTabUI.this)), Boolean.valueOf(h.baC().aZN()) });
          NewChattingTabUI.l(NewChattingTabUI.this);
          AppMethodBeat.o(249166);
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
          if (NewChattingTabUI.p(NewChattingTabUI.this) == null) {
            NewChattingTabUI.a(NewChattingTabUI.this, (OnLayoutChangedLinearLayout)NewChattingTabUI.c(NewChattingTabUI.this).getView().findViewById(R.h.chatting_bg_ll));
          }
          if (NewChattingTabUI.p(NewChattingTabUI.this) != null) {
            NewChattingTabUI.p(NewChattingTabUI.this).setOnChattingLayoutChangedListener(NewChattingTabUI.q(NewChattingTabUI.this));
          }
          NewChattingTabUI.d(NewChattingTabUI.this).setVisibility(0);
          if (NewChattingTabUI.g(NewChattingTabUI.this).getWindow().getDecorView().getWidth() != 0) {
            break label423;
          }
        }
        label423:
        for (float f = NewChattingTabUI.g(NewChattingTabUI.this).getResources().getDisplayMetrics().widthPixels;; f = NewChattingTabUI.g(NewChattingTabUI.this).getWindow().getDecorView().getWidth())
        {
          NewChattingTabUI.d(NewChattingTabUI.this).setTranslationX(f - 0.1F);
          NewChattingTabUI.a(NewChattingTabUI.this, Util.nowSecond());
          NewChattingTabUI.r(NewChattingTabUI.this);
          if (NewChattingTabUI.s(NewChattingTabUI.this)) {
            l.a(NewChattingTabUI.g(NewChattingTabUI.this));
          }
          AppMethodBeat.o(249166);
          return;
          bool = NewChattingTabUI.d(NewChattingTabUI.this).isShown();
          break;
        }
      }
      
      public final String toString()
      {
        AppMethodBeat.i(249167);
        String str = super.toString() + "|startChattingRunnable";
        AppMethodBeat.o(249167);
        return str;
      }
    };
    this.onChattingLayoutChangedListener = new OnLayoutChangedLinearLayout.a()
    {
      long start = 0L;
      
      public final void jkC()
      {
        AppMethodBeat.i(249163);
        if (NewChattingTabUI.t(NewChattingTabUI.this) == null)
        {
          NewChattingTabUI.a(NewChattingTabUI.this, AnimationUtils.loadAnimation(NewChattingTabUI.g(NewChattingTabUI.this), MMFragmentActivity.a.upU));
          NewChattingTabUI.t(NewChattingTabUI.this).setAnimationListener(new Animation.AnimationListener()
          {
            public final void onAnimationEnd(Animation paramAnonymous2Animation)
            {
              AppMethodBeat.i(249116);
              NewChattingTabUI.v(NewChattingTabUI.this);
              AppMethodBeat.o(249116);
            }
            
            public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
            
            public final void onAnimationStart(Animation paramAnonymous2Animation)
            {
              AppMethodBeat.i(249111);
              NewChattingTabUI.u(NewChattingTabUI.this);
              NewChattingTabUI.this.ar(false, 0);
              AppMethodBeat.o(249111);
            }
          });
        }
        if (NewChattingTabUI.w(NewChattingTabUI.this))
        {
          NewChattingTabUI.d(NewChattingTabUI.this).setOndispatchDraw(new TestTimeForChatting.a()
          {
            public final void jkD()
            {
              AppMethodBeat.i(249123);
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
                AppMethodBeat.o(249123);
                return;
                NewChattingTabUI.c(NewChattingTabUI.this).getView().startAnimation(NewChattingTabUI.t(NewChattingTabUI.this));
              }
            }
          });
          NewChattingTabUI.x(NewChattingTabUI.this);
        }
        for (;;)
        {
          if (NewChattingTabUI.p(NewChattingTabUI.this) != null) {
            NewChattingTabUI.p(NewChattingTabUI.this).adWO = null;
          }
          Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "klem CHATTING ONLAYOUT ");
          AppMethodBeat.o(249163);
          return;
          NewChattingTabUI.u(NewChattingTabUI.this);
          NewChattingTabUI.v(NewChattingTabUI.this);
        }
      }
    };
    this.adIC = paramb;
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
  
  public static boolean forceRemoveNoMatchOnPath()
  {
    return true;
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
    if (this.adIL.getView() == null)
    {
      AppMethodBeat.o(33662);
      return null;
    }
    if (this.adIL != null) {
      Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "getBottom:%s keyboardState:%s", new Object[] { Integer.valueOf(this.adIL.getView().getBottom()), Integer.valueOf(this.adIL.keyboardState()) });
    }
    if ((this.adIL != null) && (this.adIL.getView().getBottom() > 0) && ((this.adIL.keyboardState() == 1) || (this.adIL.getView().getBottom() < this.PIA.getResources().getDisplayMetrics().heightPixels * 2 / 3)))
    {
      Log.e("MicroMsg.LauncherUI.NewChattingTabUI", "hardKeyboardHidden:%s", new Object[] { Integer.valueOf(this.adIL.keyboardState()) });
      this.PIA.getWindow().setBackgroundDrawableResource(R.e.fkX);
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
    int i = bf.getStatusBarHeight(this.PIA);
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
  
  private ViewGroup kV(View paramView)
  {
    AppMethodBeat.i(249241);
    Object localObject1 = this.PIA.getSupportActionBar().getCustomView().getParent();
    Object localObject2 = null;
    while ((localObject1 != paramView) && (localObject1 != null))
    {
      ViewParent localViewParent = ((ViewParent)localObject1).getParent();
      localObject2 = localObject1;
      localObject1 = localViewParent;
    }
    if ((localObject2 instanceof ViewGroup))
    {
      paramView = (ViewGroup)localObject2;
      AppMethodBeat.o(249241);
      return paramView;
    }
    paramView = (ViewGroup)paramView;
    AppMethodBeat.o(249241);
    return paramView;
  }
  
  static void resetViewTranX(View paramView, ImageView paramImageView, float paramFloat)
  {
    AppMethodBeat.i(33666);
    if (Float.compare(1.0F, paramFloat) <= 0)
    {
      k.r(paramView, 0.0F);
      k.r(paramImageView, 0.0F);
      AppMethodBeat.o(33666);
      return;
    }
    if ((paramImageView != null) && (paramImageView.getDrawable() != null))
    {
      k.r(paramImageView, paramImageView.getWidth() / 2.5F * (1.0F - paramFloat) * -1.0F);
      AppMethodBeat.o(33666);
      return;
    }
    if (paramView != null) {
      k.r(paramView, paramView.getWidth() / 2.5F * (1.0F - paramFloat) * -1.0F);
    }
    AppMethodBeat.o(33666);
  }
  
  private void tryResetChattingSwipeStatus()
  {
    boolean bool = true;
    AppMethodBeat.i(33664);
    if (!jkB())
    {
      AppMethodBeat.o(33664);
      return;
    }
    if (this.adIL == null) {}
    for (;;)
    {
      Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "ashutest: tryResetChattingSwipeStatus, chattingFragment NULL ? %B", new Object[] { Boolean.valueOf(bool) });
      if (this.adIL != null) {
        this.adIL.getSwipeBackLayout().mqz = false;
      }
      AppMethodBeat.o(33664);
      return;
      bool = false;
    }
  }
  
  public final boolean Lq(boolean paramBoolean)
  {
    AppMethodBeat.i(33663);
    if (this.adIE == null) {}
    for (boolean bool = false;; bool = this.adIE.isShown())
    {
      Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "try closeChatting, ishow:%b", new Object[] { Boolean.valueOf(bool) });
      if ((this.adIL != null) && (this.adIL.getView() != null)) {
        this.adIL.getView().setImportantForAccessibility(4);
      }
      if ((this.adIE != null) && (this.adIE.getVisibility() != 8) && (this.adIL != null) && (this.PIA != null)) {
        break;
      }
      AppMethodBeat.o(33663);
      return false;
    }
    if ((this.adIL != null) && (this.adIL.isSupportNavigationSwipeBack())) {
      l.b(this.PIA);
    }
    Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "[closeChatting] needAnim:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    rG(4);
    this.mChattingClosed = true;
    if ((paramBoolean) && (this.mChattingOutAnim == null))
    {
      this.mChattingOutAnim = AnimationUtils.loadAnimation(this.PIA, MMFragmentActivity.a.upX);
      this.mChattingOutAnim.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(249160);
          NewChattingTabUI.a(NewChattingTabUI.this, false);
          NewChattingTabUI.d(NewChattingTabUI.this).setVisibility(8);
          bh.baH().setLowPriority();
          MMHandlerThread.setCurrentPriority(0);
          NewChattingTabUI.y(NewChattingTabUI.this);
          Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "klem pop out onAnimationEnd");
          AppMethodBeat.o(249160);
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(249151);
          NewChattingTabUI.a(NewChattingTabUI.this, true);
          bh.baH().setLowestPriority();
          MMHandlerThread.setCurrentPriority(-8);
          NewChattingTabUI.this.ar(true, 0);
          Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "klem pop out onAnimationStart");
          AppMethodBeat.o(249151);
        }
      });
    }
    ag.d(true, new Intent().putExtra("classname", "mainui").putExtra("main_process", false));
    if (this.adIL.isSupportCustomActionBar())
    {
      ImageView localImageView = (ImageView)this.PIA.getWindow().getDecorView().findViewById(R.h.fTp);
      if ((localImageView != null) && (localImageView.getVisibility() == 0))
      {
        localImageView.setVisibility(8);
        Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "[closeChatting] prepareView GONE");
      }
    }
    aAx(0);
    if (paramBoolean)
    {
      this.mChattingUIProxy.onExitBegin();
      this.mChattingUIProxy.onExitEnd();
      this.adIE.startAnimation(this.mChattingOutAnim);
    }
    for (;;)
    {
      AppMethodBeat.o(33663);
      return true;
      this.mChattingUIProxy.onExitBegin();
      this.mChattingUIProxy.onExitEnd();
      this.adIE.setVisibility(8);
      this.PIA.onSwipe(1.0F);
      tryResetChattingSwipeStatus();
    }
  }
  
  final void aAx(int paramInt)
  {
    AppMethodBeat.i(33667);
    Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "[setLauncherContainerVisible] visible:%s", new Object[] { Integer.valueOf(paramInt) });
    if (this.PIA == null)
    {
      Log.e("MicroMsg.LauncherUI.NewChattingTabUI", "[setLauncherContainerVisible] getActivity is null");
      AppMethodBeat.o(33667);
      return;
    }
    View localView = this.PIA.findViewById(R.h.fMr);
    if ((localView != null) && (localView.getVisibility() != paramInt)) {
      localView.setVisibility(paramInt);
    }
    AppMethodBeat.o(33667);
  }
  
  public final boolean ar(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(33665);
    Log.v("MicroMsg.LauncherUI.NewChattingTabUI", "ashutest: on settle %B, speed %d, resumeStatus %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), Boolean.valueOf(this.adIC.jiT()) });
    if (!jkB())
    {
      AppMethodBeat.o(33665);
      return true;
    }
    if (paramBoolean) {
      this.adIC.jiX();
    }
    if (!this.adIC.jiT())
    {
      AppMethodBeat.o(33665);
      return false;
    }
    View localView = this.PIA.findViewById(R.h.fMr);
    if (localView == null)
    {
      Log.e("MicroMsg.LauncherUI.NewChattingTabUI", "[onSettle] null == container");
      AppMethodBeat.o(33665);
      return true;
    }
    ImageView localImageView = (ImageView)this.PIA.findViewById(R.h.fTp);
    if ((localImageView != null) && (localImageView.getVisibility() == 8) && (localImageView.getDrawable() != null))
    {
      localImageView.setVisibility(0);
      Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "[onSettle] prepareView VISIBLE");
      localView.setVisibility(8);
    }
    if ((localImageView != null) && (localImageView.getVisibility() == 0)) {
      if (localImageView.getWidth() == 0)
      {
        paramInt = this.PIA.getResources().getDisplayMetrics().widthPixels;
        if (!paramBoolean) {
          break label250;
        }
        k.a(localImageView, 182L, 0.0F, null);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(33665);
      return true;
      paramInt = localImageView.getWidth();
      break;
      label250:
      k.a(localImageView, 208L, paramInt * -1 / 3.5F, null);
      continue;
      if (localView.getWidth() == 0) {}
      for (paramInt = this.PIA.getResources().getDisplayMetrics().widthPixels;; paramInt = localView.getWidth())
      {
        if (!paramBoolean) {
          break label315;
        }
        k.a(localView, 182L, 0.0F, null);
        break;
      }
      label315:
      k.a(localView, 208L, paramInt * -1 / 3.5F, null);
    }
  }
  
  public final boolean glL()
  {
    AppMethodBeat.i(249360);
    if (this.adIL == null)
    {
      AppMethodBeat.o(249360);
      return false;
    }
    boolean bool = this.adIL.isForeground();
    AppMethodBeat.o(249360);
    return bool;
  }
  
  public final void hdx()
  {
    AppMethodBeat.i(249351);
    if (glL())
    {
      rG(4);
      if ((this.adIL != null) && (this.adIL.isSupportNavigationSwipeBack())) {
        this.adIL.getSwipeBackLayout().setEnableGesture(false);
      }
    }
    AppMethodBeat.o(249351);
  }
  
  final boolean jkB()
  {
    AppMethodBeat.i(33660);
    if ((com.tencent.mm.compatible.util.d.rb(19)) && (com.tencent.mm.compatible.h.a.aPR()) && (!com.tencent.mm.compatible.e.b.df(this.PIA)))
    {
      AppMethodBeat.o(33660);
      return true;
    }
    AppMethodBeat.o(33660);
    return false;
  }
  
  final void rG(final int paramInt)
  {
    AppMethodBeat.i(33661);
    if (this.adIL == null)
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
          com.tencent.mm.modelstat.d.n("ChattingUI" + NewChattingTabUI.i(NewChattingTabUI.this), NewChattingTabUI.j(NewChattingTabUI.this), Util.nowSecond());
        }
        AppMethodBeat.o(33641);
      }
    }, "MicroMsg.LauncherUI.NewChattingTabUI|report");
    AppMethodBeat.o(33661);
  }
  
  public final void startChatting(String paramString, Bundle paramBundle, boolean paramBoolean)
  {
    AppMethodBeat.i(33656);
    this.adIM = System.currentTimeMillis();
    if (this.adIE == null) {}
    for (boolean bool = false;; bool = this.adIE.isShown())
    {
      Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "try startChatting, ishow:%b userName:%s needAnim:%b", new Object[] { Boolean.valueOf(bool), paramString, Boolean.valueOf(paramBoolean) });
      if ((this.adIL != null) && (this.adIL.getView() != null)) {
        this.adIL.getView().setImportantForAccessibility(1);
      }
      bh.getNotification().et(false);
      this.adIO = false;
      this.adIK = paramBundle;
      this.adIJ = paramString;
      this.mNeedChattingAnim = paramBoolean;
      if ((!aw.jlc()) || ((!aw.ato()) && (!aw.jkZ()) && (!aw.jkS()) && (!aw.jlb()))) {
        break;
      }
      paramString = new Intent(this.PIA, ChattingUI.class);
      paramString.putExtra("Chat_User", this.adIJ);
      if (paramBundle != null) {
        paramString.putExtras(paramBundle);
      }
      paramBundle = this.PIA;
      paramString = new com.tencent.mm.hellhoundlib.b.a().cG(paramString);
      com.tencent.mm.hellhoundlib.a.a.b(paramBundle, paramString.aYi(), "com/tencent/mm/ui/NewChattingTabUI", "startChatting", "(Ljava/lang/String;Landroid/os/Bundle;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramBundle.startActivity((Intent)paramString.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramBundle, "com/tencent/mm/ui/NewChattingTabUI", "startChatting", "(Ljava/lang/String;Landroid/os/Bundle;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(33656);
      return;
    }
    bh.baH().setLowestPriority();
    MMHandlerThread.setCurrentPriority(-8);
    MMHandlerThread.removeRunnable(this.mStartChattingRunnable);
    MMHandlerThread.postToMainThread(this.mStartChattingRunnable);
    AppMethodBeat.o(33656);
  }
  
  final class a
    implements Runnable
  {
    int adIW = 0;
    int hPm;
    Intent hPn;
    int resultCode;
    
    private a() {}
    
    public final void run()
    {
      AppMethodBeat.i(33653);
      if ((bh.baz()) && (NewChattingTabUI.a(NewChattingTabUI.this) != null))
      {
        Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "on post select image job, acc has ready, retry count %d", new Object[] { Integer.valueOf(this.adIW) });
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
                NewChattingTabUI.c(NewChattingTabUI.this).onActivityResult(NewChattingTabUI.a.this.hPm & 0xFFFF, NewChattingTabUI.a.this.resultCode, NewChattingTabUI.a.this.hPn);
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
      if (this.adIW >= 3)
      {
        Log.w("MicroMsg.LauncherUI.NewChattingTabUI", "on post select image job, match max retry count");
        AppMethodBeat.o(33653);
        return;
      }
      if (NewChattingTabUI.a(NewChattingTabUI.this) != null) {}
      for (boolean bool = true;; bool = false)
      {
        Log.w("MicroMsg.LauncherUI.NewChattingTabUI", "on post select image job, acc not ready or view init(%B), cur retry count %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.adIW) });
        this.adIW += 1;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.NewChattingTabUI
 * JD-Core Version:    0.7.0.1
 */
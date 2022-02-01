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
import com.tencent.mm.plugin.multitask.ui.a.c.b;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.ui.base.OnLayoutChangedLinearLayout;
import com.tencent.mm.ui.base.OnLayoutChangedLinearLayout.a;
import com.tencent.mm.ui.base.ac;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.tools.TestTimeForChatting;
import com.tencent.mm.ui.tools.TestTimeForChatting.a;
import com.tencent.mm.ui.tools.k;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.ui.widget.j;

public class NewChattingTabUI
  implements LauncherUI.a
{
  MMFragmentActivity Jvc;
  LauncherUI.b WcZ;
  long Wda;
  private TestTimeForChatting Wdb;
  private int Wdc;
  MessageQueue.IdleHandler Wdd;
  private OnLayoutChangedLinearLayout Wde;
  String Wdf;
  private String Wdg;
  private Bundle Wdh;
  BaseChattingUIFragment Wdi;
  private long Wdj;
  a Wdk;
  boolean Wdl;
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
    this.Wda = 0L;
    this.mChattingClosed = true;
    this.isAnimating = false;
    this.Wdk = new a((byte)0);
    this.Wdl = false;
    this.mStartChattingRunnable = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(275120);
        if (!NewChattingTabUI.k(NewChattingTabUI.this))
        {
          Log.e("MicroMsg.LauncherUI.NewChattingTabUI", "start chatting but last chatting does't be close!");
          NewChattingTabUI.this.FH(false);
        }
        if ((NewChattingTabUI.g(NewChattingTabUI.this).isFinishing()) || (NewChattingTabUI.g(NewChattingTabUI.this).isPaused()) || (!NewChattingTabUI.k(NewChattingTabUI.this)) || (!h.aHE().aGM()))
        {
          Log.w("MicroMsg.LauncherUI.NewChattingTabUI", "[mStartChattingRunnable] pass! isPause:%s mChattingClosed:%s, account:%s", new Object[] { Boolean.valueOf(NewChattingTabUI.g(NewChattingTabUI.this).isPaused()), Boolean.valueOf(NewChattingTabUI.k(NewChattingTabUI.this)), Boolean.valueOf(h.aHE().aGM()) });
          NewChattingTabUI.l(NewChattingTabUI.this);
          AppMethodBeat.o(275120);
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
            break label376;
          }
        }
        label376:
        for (float f = NewChattingTabUI.g(NewChattingTabUI.this).getResources().getDisplayMetrics().widthPixels;; f = NewChattingTabUI.g(NewChattingTabUI.this).getWindow().getDecorView().getWidth())
        {
          NewChattingTabUI.d(NewChattingTabUI.this).setTranslationX(f - 0.1F);
          NewChattingTabUI.a(NewChattingTabUI.this, Util.nowSecond());
          NewChattingTabUI.r(NewChattingTabUI.this);
          if (NewChattingTabUI.s(NewChattingTabUI.this)) {
            j.a(NewChattingTabUI.g(NewChattingTabUI.this));
          }
          AppMethodBeat.o(275120);
          return;
          bool = NewChattingTabUI.d(NewChattingTabUI.this).isShown();
          break;
        }
      }
      
      public final String toString()
      {
        AppMethodBeat.i(275121);
        String str = super.toString() + "|startChattingRunnable";
        AppMethodBeat.o(275121);
        return str;
      }
    };
    this.onChattingLayoutChangedListener = new OnLayoutChangedLinearLayout.a()
    {
      long start = 0L;
      
      public final void hIt()
      {
        AppMethodBeat.i(287372);
        if (NewChattingTabUI.t(NewChattingTabUI.this) == null)
        {
          NewChattingTabUI.a(NewChattingTabUI.this, AnimationUtils.loadAnimation(NewChattingTabUI.g(NewChattingTabUI.this), MMFragmentActivity.a.rhY));
          NewChattingTabUI.t(NewChattingTabUI.this).setAnimationListener(new Animation.AnimationListener()
          {
            public final void onAnimationEnd(Animation paramAnonymous2Animation)
            {
              AppMethodBeat.i(271534);
              NewChattingTabUI.v(NewChattingTabUI.this);
              AppMethodBeat.o(271534);
            }
            
            public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
            
            public final void onAnimationStart(Animation paramAnonymous2Animation)
            {
              AppMethodBeat.i(271531);
              NewChattingTabUI.u(NewChattingTabUI.this);
              NewChattingTabUI.this.aq(false, 0);
              AppMethodBeat.o(271531);
            }
          });
        }
        if (NewChattingTabUI.w(NewChattingTabUI.this))
        {
          NewChattingTabUI.d(NewChattingTabUI.this).setOndispatchDraw(new TestTimeForChatting.a()
          {
            public final void hIu()
            {
              AppMethodBeat.i(282680);
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
                AppMethodBeat.o(282680);
                return;
                NewChattingTabUI.c(NewChattingTabUI.this).getView().startAnimation(NewChattingTabUI.t(NewChattingTabUI.this));
              }
            }
          });
          NewChattingTabUI.x(NewChattingTabUI.this);
        }
        for (;;)
        {
          NewChattingTabUI.q(NewChattingTabUI.this).WpA = null;
          Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "klem CHATTING ONLAYOUT ");
          AppMethodBeat.o(287372);
          return;
          NewChattingTabUI.u(NewChattingTabUI.this);
          NewChattingTabUI.v(NewChattingTabUI.this);
        }
      }
    };
    this.WcZ = paramb;
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
    if (this.Wdi.getView() == null)
    {
      AppMethodBeat.o(33662);
      return null;
    }
    if (this.Wdi != null) {
      Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "getBottom:%s keyboardState:%s", new Object[] { Integer.valueOf(this.Wdi.getView().getBottom()), Integer.valueOf(this.Wdi.keyboardState()) });
    }
    if ((this.Wdi != null) && (this.Wdi.getView().getBottom() > 0) && ((this.Wdi.keyboardState() == 1) || (this.Wdi.getView().getBottom() < this.Jvc.getResources().getDisplayMetrics().heightPixels * 2 / 3)))
    {
      Log.e("MicroMsg.LauncherUI.NewChattingTabUI", "hardKeyboardHidden:%s", new Object[] { Integer.valueOf(this.Wdi.keyboardState()) });
      this.Jvc.getWindow().setBackgroundDrawableResource(R.e.dkI);
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
    int i = ax.getStatusBarHeight(this.Jvc);
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
  
  private ViewGroup hC(View paramView)
  {
    AppMethodBeat.i(288608);
    Object localObject1 = this.Jvc.getSupportActionBar().getCustomView().getParent();
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
      AppMethodBeat.o(288608);
      return paramView;
    }
    paramView = (ViewGroup)paramView;
    AppMethodBeat.o(288608);
    return paramView;
  }
  
  static void resetViewTranX(View paramView, ImageView paramImageView, float paramFloat)
  {
    AppMethodBeat.i(33666);
    if (Float.compare(1.0F, paramFloat) <= 0)
    {
      k.q(paramView, 0.0F);
      k.q(paramImageView, 0.0F);
      AppMethodBeat.o(33666);
      return;
    }
    if ((paramImageView != null) && (paramImageView.getDrawable() != null))
    {
      k.q(paramImageView, paramImageView.getWidth() / 2.5F * (1.0F - paramFloat) * -1.0F);
      AppMethodBeat.o(33666);
      return;
    }
    if (paramView != null) {
      k.q(paramView, paramView.getWidth() / 2.5F * (1.0F - paramFloat) * -1.0F);
    }
    AppMethodBeat.o(33666);
  }
  
  private void tryResetChattingSwipeStatus()
  {
    boolean bool = true;
    AppMethodBeat.i(33664);
    if (!hIs())
    {
      AppMethodBeat.o(33664);
      return;
    }
    if (this.Wdi == null) {}
    for (;;)
    {
      Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "ashutest: tryResetChattingSwipeStatus, chattingFragment NULL ? %B", new Object[] { Boolean.valueOf(bool) });
      if (this.Wdi != null) {
        this.Wdi.getSwipeBackLayout().jRp = false;
      }
      AppMethodBeat.o(33664);
      return;
      bool = false;
    }
  }
  
  public final boolean FH(boolean paramBoolean)
  {
    AppMethodBeat.i(33663);
    if (this.Wdb == null) {}
    for (boolean bool = false;; bool = this.Wdb.isShown())
    {
      Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "try closeChatting, ishow:%b", new Object[] { Boolean.valueOf(bool) });
      if ((this.Wdi != null) && (this.Wdi.getView() != null)) {
        this.Wdi.getView().setImportantForAccessibility(4);
      }
      if ((this.Wdb != null) && (this.Wdb.getVisibility() != 8) && (this.Wdi != null) && (this.Jvc != null)) {
        break;
      }
      AppMethodBeat.o(33663);
      return false;
    }
    if ((this.Wdi != null) && (this.Wdi.isSupportNavigationSwipeBack())) {
      j.b(this.Jvc);
    }
    Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "[closeChatting] needAnim:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    rE(4);
    this.mChattingClosed = true;
    if ((paramBoolean) && (this.mChattingOutAnim == null))
    {
      this.mChattingOutAnim = AnimationUtils.loadAnimation(this.Jvc, MMFragmentActivity.a.rib);
      this.mChattingOutAnim.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(290233);
          NewChattingTabUI.a(NewChattingTabUI.this, false);
          NewChattingTabUI.d(NewChattingTabUI.this).setVisibility(8);
          bh.aHJ().setLowPriority();
          MMHandlerThread.setCurrentPriority(0);
          NewChattingTabUI.y(NewChattingTabUI.this);
          Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "klem pop out onAnimationEnd");
          AppMethodBeat.o(290233);
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(290232);
          NewChattingTabUI.a(NewChattingTabUI.this, true);
          bh.aHJ().setLowestPriority();
          MMHandlerThread.setCurrentPriority(-8);
          NewChattingTabUI.this.aq(true, 0);
          Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "klem pop out onAnimationStart");
          AppMethodBeat.o(290232);
        }
      });
    }
    ac.d(true, new Intent().putExtra("classname", "mainui").putExtra("main_process", false));
    if (this.Wdi.isSupportCustomActionBar())
    {
      ImageView localImageView = (ImageView)this.Jvc.getWindow().getDecorView().findViewById(R.h.dRm);
      if ((localImageView != null) && (localImageView.getVisibility() == 0))
      {
        localImageView.setVisibility(8);
        Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "[closeChatting] prepareView GONE");
      }
    }
    aug(0);
    if (paramBoolean)
    {
      this.mChattingUIProxy.onExitBegin();
      this.mChattingUIProxy.onExitEnd();
      this.Wdb.startAnimation(this.mChattingOutAnim);
    }
    for (;;)
    {
      AppMethodBeat.o(33663);
      return true;
      this.mChattingUIProxy.onExitBegin();
      this.mChattingUIProxy.onExitEnd();
      this.Wdb.setVisibility(8);
      this.Jvc.onSwipe(1.0F);
      tryResetChattingSwipeStatus();
    }
  }
  
  public final boolean aq(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(33665);
    Log.v("MicroMsg.LauncherUI.NewChattingTabUI", "ashutest: on settle %B, speed %d, resumeStatus %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), Boolean.valueOf(this.WcZ.hGI()) });
    if (!hIs())
    {
      AppMethodBeat.o(33665);
      return true;
    }
    if (paramBoolean) {
      this.WcZ.hGM();
    }
    if (!this.WcZ.hGI())
    {
      AppMethodBeat.o(33665);
      return false;
    }
    View localView = this.Jvc.findViewById(R.h.dKQ);
    if (localView == null)
    {
      Log.e("MicroMsg.LauncherUI.NewChattingTabUI", "[onSettle] null == container");
      AppMethodBeat.o(33665);
      return true;
    }
    ImageView localImageView = (ImageView)this.Jvc.findViewById(R.h.dRm);
    if ((localImageView != null) && (localImageView.getVisibility() == 8) && (localImageView.getDrawable() != null))
    {
      localImageView.setVisibility(0);
      Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "[onSettle] prepareView VISIBLE");
      localView.setVisibility(8);
    }
    if ((localImageView != null) && (localImageView.getVisibility() == 0)) {
      if (localImageView.getWidth() == 0)
      {
        paramInt = this.Jvc.getResources().getDisplayMetrics().widthPixels;
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
      for (paramInt = this.Jvc.getResources().getDisplayMetrics().widthPixels;; paramInt = localView.getWidth())
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
  
  final void aug(int paramInt)
  {
    AppMethodBeat.i(33667);
    Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "[setLauncherContainerVisible] visible:%s", new Object[] { Integer.valueOf(paramInt) });
    if (this.Jvc == null)
    {
      Log.e("MicroMsg.LauncherUI.NewChattingTabUI", "[setLauncherContainerVisible] getActivity is null");
      AppMethodBeat.o(33667);
      return;
    }
    View localView = this.Jvc.findViewById(R.h.dKQ);
    if ((localView != null) && (localView.getVisibility() != paramInt)) {
      localView.setVisibility(paramInt);
    }
    AppMethodBeat.o(33667);
  }
  
  public final void fMw()
  {
    AppMethodBeat.i(288606);
    if (fcI())
    {
      rE(4);
      if ((this.Wdi != null) && (this.Wdi.isSupportNavigationSwipeBack())) {
        this.Wdi.getSwipeBackLayout().setEnableGesture(false);
      }
    }
    AppMethodBeat.o(288606);
  }
  
  public final boolean fcI()
  {
    if (this.Wdi == null) {
      return false;
    }
    return this.Wdi.fgR.dgo;
  }
  
  final boolean hIs()
  {
    AppMethodBeat.i(33660);
    if ((com.tencent.mm.compatible.util.d.qV(19)) && (com.tencent.mm.compatible.h.b.avx()) && (!com.tencent.mm.compatible.e.b.cr(this.Jvc)))
    {
      AppMethodBeat.o(33660);
      return true;
    }
    AppMethodBeat.o(33660);
    return false;
  }
  
  final void rE(final int paramInt)
  {
    AppMethodBeat.i(33661);
    if (this.Wdi == null)
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
          com.tencent.mm.modelstat.d.l("ChattingUI" + NewChattingTabUI.i(NewChattingTabUI.this), NewChattingTabUI.j(NewChattingTabUI.this), Util.nowSecond());
        }
        AppMethodBeat.o(33641);
      }
    }, "MicroMsg.LauncherUI.NewChattingTabUI|report");
    AppMethodBeat.o(33661);
  }
  
  public final void startChatting(String paramString, Bundle paramBundle, boolean paramBoolean)
  {
    AppMethodBeat.i(33656);
    this.Wdj = System.currentTimeMillis();
    if (this.Wdb == null) {}
    for (boolean bool = false;; bool = this.Wdb.isShown())
    {
      Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "try startChatting, ishow:%b userName:%s needAnim:%b", new Object[] { Boolean.valueOf(bool), paramString, Boolean.valueOf(paramBoolean) });
      if ((this.Wdi != null) && (this.Wdi.getView() != null)) {
        this.Wdi.getView().setImportantForAccessibility(1);
      }
      bh.getNotification().dH(false);
      this.Wdl = false;
      this.Wdh = paramBundle;
      this.Wdg = paramString;
      this.mNeedChattingAnim = paramBoolean;
      if ((!ar.hIO()) || ((!ar.hIM()) && (!ar.hIN()) && (!ar.hIH()))) {
        break;
      }
      paramString = new Intent(this.Jvc, ChattingUI.class);
      paramString.putExtra("Chat_User", this.Wdg);
      if (paramBundle != null) {
        paramString.putExtras(paramBundle);
      }
      paramBundle = this.Jvc;
      paramString = new com.tencent.mm.hellhoundlib.b.a().bm(paramString);
      com.tencent.mm.hellhoundlib.a.a.b(paramBundle, paramString.aFh(), "com/tencent/mm/ui/NewChattingTabUI", "startChatting", "(Ljava/lang/String;Landroid/os/Bundle;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramBundle.startActivity((Intent)paramString.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramBundle, "com/tencent/mm/ui/NewChattingTabUI", "startChatting", "(Ljava/lang/String;Landroid/os/Bundle;Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(33656);
      return;
    }
    bh.aHJ().setLowestPriority();
    MMHandlerThread.setCurrentPriority(-8);
    MMHandlerThread.removeRunnable(this.mStartChattingRunnable);
    MMHandlerThread.postToMainThread(this.mStartChattingRunnable);
    AppMethodBeat.o(33656);
  }
  
  final class a
    implements Runnable
  {
    int Wdt = 0;
    Intent fJJ;
    int requestCode;
    int resultCode;
    
    private a() {}
    
    public final void run()
    {
      AppMethodBeat.i(33653);
      if ((bh.aHB()) && (NewChattingTabUI.a(NewChattingTabUI.this) != null))
      {
        Log.i("MicroMsg.LauncherUI.NewChattingTabUI", "on post select image job, acc has ready, retry count %d", new Object[] { Integer.valueOf(this.Wdt) });
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
                NewChattingTabUI.c(NewChattingTabUI.this).onActivityResult(NewChattingTabUI.a.this.requestCode & 0xFFFF, NewChattingTabUI.a.this.resultCode, NewChattingTabUI.a.this.fJJ);
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
      if (this.Wdt >= 3)
      {
        Log.w("MicroMsg.LauncherUI.NewChattingTabUI", "on post select image job, match max retry count");
        AppMethodBeat.o(33653);
        return;
      }
      if (NewChattingTabUI.a(NewChattingTabUI.this) != null) {}
      for (boolean bool = true;; bool = false)
      {
        Log.w("MicroMsg.LauncherUI.NewChattingTabUI", "on post select image job, acc not ready or view init(%B), cur retry count %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.Wdt) });
        this.Wdt += 1;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.NewChattingTabUI
 * JD-Core Version:    0.7.0.1
 */
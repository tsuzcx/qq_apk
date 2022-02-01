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
import com.tencent.mm.model.az;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.ui.base.OnLayoutChangedLinearLayout;
import com.tencent.mm.ui.base.OnLayoutChangedLinearLayout.a;
import com.tencent.mm.ui.base.y;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.tools.TestTimeForChatting;
import com.tencent.mm.ui.tools.TestTimeForChatting.a;
import com.tencent.mm.ui.tools.j;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.ui.widget.h;

public class NewChattingTabUI
  implements LauncherUI.a
{
  LauncherUI.b FRd;
  long FRe;
  private TestTimeForChatting FRf;
  private int FRg;
  MessageQueue.IdleHandler FRh;
  private OnLayoutChangedLinearLayout FRi;
  String FRj;
  private String FRk;
  private Bundle FRl;
  BaseChattingUIFragment FRm;
  private long FRn;
  a FRo;
  boolean FRp;
  boolean isAnimating;
  MMFragmentActivity lTx;
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
    this.FRe = 0L;
    this.mChattingClosed = true;
    this.isAnimating = false;
    this.FRo = new a((byte)0);
    this.FRp = false;
    this.mStartChattingRunnable = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(33641);
        if (!NewChattingTabUI.k(NewChattingTabUI.this))
        {
          ad.e("MicroMsg.LauncherUI.NewChattingTabUI", "start chatting but last chatting does't be close!");
          NewChattingTabUI.this.vE(false);
        }
        if ((NewChattingTabUI.g(NewChattingTabUI.this).isFinishing()) || (NewChattingTabUI.g(NewChattingTabUI.this).isPaused()) || (!NewChattingTabUI.k(NewChattingTabUI.this)))
        {
          ad.w("MicroMsg.LauncherUI.NewChattingTabUI", "[mStartChattingRunnable] pass! isPause:%s mChattingClosed:%s", new Object[] { Boolean.valueOf(NewChattingTabUI.g(NewChattingTabUI.this).isPaused()), Boolean.valueOf(NewChattingTabUI.k(NewChattingTabUI.this)) });
          NewChattingTabUI.l(NewChattingTabUI.this);
          AppMethodBeat.o(33641);
          return;
        }
        NewChattingTabUI.m(NewChattingTabUI.this);
        boolean bool;
        if (NewChattingTabUI.d(NewChattingTabUI.this) == null)
        {
          bool = false;
          ad.i("MicroMsg.LauncherUI.NewChattingTabUI", "ashutest::startChatting, ishow:%b", new Object[] { Boolean.valueOf(bool) });
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
          NewChattingTabUI.a(NewChattingTabUI.this, bt.aGK());
          NewChattingTabUI.r(NewChattingTabUI.this);
          if (NewChattingTabUI.s(NewChattingTabUI.this)) {
            h.a(NewChattingTabUI.g(NewChattingTabUI.this));
          }
          AppMethodBeat.o(33641);
          return;
          bool = NewChattingTabUI.d(NewChattingTabUI.this).isShown();
          break;
        }
      }
      
      public final String toString()
      {
        AppMethodBeat.i(33642);
        String str = super.toString() + "|startChattingRunnable";
        AppMethodBeat.o(33642);
        return str;
      }
    };
    this.onChattingLayoutChangedListener = new OnLayoutChangedLinearLayout.a()
    {
      long start = 0L;
      
      public final void eRF()
      {
        AppMethodBeat.i(33646);
        if (NewChattingTabUI.t(NewChattingTabUI.this) == null)
        {
          NewChattingTabUI.a(NewChattingTabUI.this, AnimationUtils.loadAnimation(NewChattingTabUI.g(NewChattingTabUI.this), MMFragmentActivity.a.lLF));
          NewChattingTabUI.t(NewChattingTabUI.this).setAnimationListener(new Animation.AnimationListener()
          {
            public final void onAnimationEnd(Animation paramAnonymous2Animation)
            {
              AppMethodBeat.i(33644);
              NewChattingTabUI.v(NewChattingTabUI.this);
              AppMethodBeat.o(33644);
            }
            
            public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
            
            public final void onAnimationStart(Animation paramAnonymous2Animation)
            {
              AppMethodBeat.i(33643);
              NewChattingTabUI.u(NewChattingTabUI.this);
              NewChattingTabUI.this.S(false, 0);
              AppMethodBeat.o(33643);
            }
          });
        }
        if (NewChattingTabUI.w(NewChattingTabUI.this))
        {
          NewChattingTabUI.d(NewChattingTabUI.this).setOndispatchDraw(new TestTimeForChatting.a()
          {
            public final void eRG()
            {
              AppMethodBeat.i(33645);
              ad.i("MicroMsg.LauncherUI.NewChattingTabUI", "[onDrawed]");
              NewChattingTabUI.6.this.start = System.currentTimeMillis();
              if (NewChattingTabUI.c(NewChattingTabUI.this).getSwipeBackLayout() != null)
              {
                NewChattingTabUI.c(NewChattingTabUI.this).getSwipeBackLayout().setNeedChangeWindowBackground(false);
                NewChattingTabUI.c(NewChattingTabUI.this).getSwipeBackLayout().startAnimation(NewChattingTabUI.t(NewChattingTabUI.this));
              }
              for (;;)
              {
                NewChattingTabUI.d(NewChattingTabUI.this).setOndispatchDraw(null);
                AppMethodBeat.o(33645);
                return;
                NewChattingTabUI.c(NewChattingTabUI.this).getView().startAnimation(NewChattingTabUI.t(NewChattingTabUI.this));
              }
            }
          });
          NewChattingTabUI.x(NewChattingTabUI.this);
        }
        for (;;)
        {
          NewChattingTabUI.q(NewChattingTabUI.this).GcZ = null;
          ad.i("MicroMsg.LauncherUI.NewChattingTabUI", "klem CHATTING ONLAYOUT ");
          AppMethodBeat.o(33646);
          return;
          NewChattingTabUI.u(NewChattingTabUI.this);
          NewChattingTabUI.v(NewChattingTabUI.this);
        }
      }
    };
    this.FRd = paramb;
    AppMethodBeat.o(33655);
  }
  
  static boolean acceptRequestCode(int paramInt)
  {
    AppMethodBeat.i(33657);
    paramInt = 0xFFFF & paramInt;
    ad.w("MicroMsg.LauncherUI.NewChattingTabUI", "check request code %d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(33657);
      return false;
    }
    AppMethodBeat.o(33657);
    return true;
  }
  
  private ViewGroup eRD()
  {
    AppMethodBeat.i(33659);
    ViewParent localViewParent = this.lTx.getSupportActionBar().getCustomView().getParent();
    Object localObject3 = null;
    View localView2 = this.lTx.getWindow().getDecorView();
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
      ad.e("MicroMsg.LauncherUI.NewChattingTabUI", "viewWidth:%s viewHeight:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      AppMethodBeat.o(33662);
      return null;
    }
    if (this.FRm.getView() == null)
    {
      AppMethodBeat.o(33662);
      return null;
    }
    if (this.FRm != null) {
      ad.i("MicroMsg.LauncherUI.NewChattingTabUI", "getBottom:%s keyboardState:%s", new Object[] { Integer.valueOf(this.FRm.getView().getBottom()), Integer.valueOf(this.FRm.keyboardState()) });
    }
    if ((this.FRm != null) && (this.FRm.getView().getBottom() > 0) && ((this.FRm.keyboardState() == 1) || (this.FRm.getView().getBottom() < this.lTx.getResources().getDisplayMetrics().heightPixels * 2 / 3)))
    {
      ad.e("MicroMsg.LauncherUI.NewChattingTabUI", "hardKeyboardHidden:%s", new Object[] { Integer.valueOf(this.FRm.keyboardState()) });
      this.lTx.getWindow().setBackgroundDrawableResource(2131100810);
      AppMethodBeat.o(33662);
      return null;
    }
    if ((this.mPrepareBitmap == null) || (this.mPrepareBitmap.isRecycled()) || (this.mPrepareBitmap.getWidth() != i) || (this.mPrepareBitmap.getHeight() != j))
    {
      if ((this.mPrepareBitmap != null) && (!this.mPrepareBitmap.isRecycled()))
      {
        ad.i("MicroMsg.LauncherUI.NewChattingTabUI", "bitmap recycle %s", new Object[] { this.mPrepareBitmap.toString() });
        this.mPrepareBitmap.recycle();
      }
      try
      {
        this.mPrepareBitmap = f.createBitmap(i, j, Bitmap.Config.ARGB_4444);
        if (this.mPrepareBitmap == null)
        {
          AppMethodBeat.o(33662);
          return null;
        }
      }
      catch (OutOfMemoryError paramView)
      {
        ad.e("MicroMsg.LauncherUI.NewChattingTabUI", "[getMagicDrawingCache] e:%s", new Object[] { paramView });
        AppMethodBeat.o(33662);
        return null;
      }
    }
    paramView.draw(new Canvas(this.mPrepareBitmap));
    ad.i("MicroMsg.LauncherUI.NewChattingTabUI", "[getMagicDrawingCache] cost%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    paramView = this.mPrepareBitmap;
    AppMethodBeat.o(33662);
    return paramView;
  }
  
  private int getTopHeight()
  {
    AppMethodBeat.i(33658);
    int i = ap.iX(this.lTx);
    if ((Build.VERSION.SDK_INT >= 24) && (LauncherUI.getInstance() != null)) {}
    for (boolean bool1 = LauncherUI.getInstance().isInMultiWindowMode();; bool1 = false)
    {
      SharedPreferences localSharedPreferences;
      if (!bool1)
      {
        localSharedPreferences = aj.eFE();
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
        ad.i("MicroMsg.LauncherUI.NewChattingTabUI", "getTopHeight statusHeight:%s, isInMultiWindowMode:%s", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1) });
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
      j.x(paramView, 0.0F);
      j.x(paramImageView, 0.0F);
      AppMethodBeat.o(33666);
      return;
    }
    if ((paramImageView != null) && (paramImageView.getDrawable() != null))
    {
      j.x(paramImageView, paramImageView.getWidth() / 2.5F * (1.0F - paramFloat) * -1.0F);
      AppMethodBeat.o(33666);
      return;
    }
    j.x(paramView, paramView.getWidth() / 2.5F * (1.0F - paramFloat) * -1.0F);
    AppMethodBeat.o(33666);
  }
  
  private void tryResetChattingSwipeStatus()
  {
    boolean bool = true;
    AppMethodBeat.i(33664);
    if (!eRE())
    {
      AppMethodBeat.o(33664);
      return;
    }
    if (this.FRm == null) {}
    for (;;)
    {
      ad.i("MicroMsg.LauncherUI.NewChattingTabUI", "ashutest: tryResetChattingSwipeStatus, chattingFragment NULL ? %B", new Object[] { Boolean.valueOf(bool) });
      if (this.FRm != null) {
        this.FRm.getSwipeBackLayout().HBY = false;
      }
      AppMethodBeat.o(33664);
      return;
      bool = false;
    }
  }
  
  public final boolean S(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(33665);
    ad.v("MicroMsg.LauncherUI.NewChattingTabUI", "ashutest: on settle %B, speed %d, resumeStatus %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), Boolean.valueOf(this.FRd.eQn()) });
    if (!eRE())
    {
      AppMethodBeat.o(33665);
      return true;
    }
    if (paramBoolean) {
      this.FRd.eQq();
    }
    if (!this.FRd.eQn())
    {
      AppMethodBeat.o(33665);
      return false;
    }
    View localView = this.lTx.findViewById(2131301337);
    if (localView == null)
    {
      ad.e("MicroMsg.LauncherUI.NewChattingTabUI", "[onSettle] null == container");
      AppMethodBeat.o(33665);
      return true;
    }
    ImageView localImageView = (ImageView)this.lTx.findViewById(2131303386);
    if ((localImageView != null) && (localImageView.getVisibility() == 8) && (localImageView.getDrawable() != null))
    {
      localImageView.setVisibility(0);
      ad.i("MicroMsg.LauncherUI.NewChattingTabUI", "[onSettle] prepareView VISIBLE");
      localView.setVisibility(8);
    }
    if ((localImageView != null) && (localImageView.getVisibility() == 0)) {
      if (localImageView.getWidth() == 0)
      {
        paramInt = this.lTx.getResources().getDisplayMetrics().widthPixels;
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
      for (paramInt = this.lTx.getResources().getDisplayMetrics().widthPixels;; paramInt = localView.getWidth())
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
  
  final void Xy(int paramInt)
  {
    AppMethodBeat.i(33667);
    ad.i("MicroMsg.LauncherUI.NewChattingTabUI", "[setLauncherContainerVisible] visible:%s", new Object[] { Integer.valueOf(paramInt) });
    if (this.lTx == null)
    {
      ad.e("MicroMsg.LauncherUI.NewChattingTabUI", "[setLauncherContainerVisible] getActivity is null");
      AppMethodBeat.o(33667);
      return;
    }
    View localView = this.lTx.findViewById(2131301337);
    if ((localView != null) && (localView.getVisibility() != paramInt)) {
      localView.setVisibility(paramInt);
    }
    AppMethodBeat.o(33667);
  }
  
  public final boolean eQN()
  {
    if (this.FRm == null) {
      return false;
    }
    return this.FRm.cOd.ctF;
  }
  
  final boolean eRE()
  {
    AppMethodBeat.i(33660);
    if ((com.tencent.mm.compatible.util.d.lf(19)) && (com.tencent.mm.compatible.g.b.XE()) && (!com.tencent.mm.compatible.d.b.bX(this.lTx)))
    {
      AppMethodBeat.o(33660);
      return true;
    }
    AppMethodBeat.o(33660);
    return false;
  }
  
  final void lI(final int paramInt)
  {
    AppMethodBeat.i(33661);
    if (this.FRm == null)
    {
      AppMethodBeat.o(33661);
      return;
    }
    com.tencent.mm.sdk.g.b.c(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(33640);
        com.tencent.mm.modelstat.d.c(paramInt, "ChattingUI" + NewChattingTabUI.i(NewChattingTabUI.this), hashCode());
        if (paramInt == 4) {
          com.tencent.mm.modelstat.d.p("ChattingUI" + NewChattingTabUI.i(NewChattingTabUI.this), NewChattingTabUI.j(NewChattingTabUI.this), bt.aGK());
        }
        AppMethodBeat.o(33640);
      }
    }, "MicroMsg.LauncherUI.NewChattingTabUI|report");
    AppMethodBeat.o(33661);
  }
  
  public final void startChatting(String paramString, Bundle paramBundle, boolean paramBoolean)
  {
    AppMethodBeat.i(33656);
    this.FRn = System.currentTimeMillis();
    if (this.FRf == null) {}
    for (boolean bool = false;; bool = this.FRf.isShown())
    {
      ad.i("MicroMsg.LauncherUI.NewChattingTabUI", "try startChatting, ishow:%b userName:%s needAnim:%b", new Object[] { Boolean.valueOf(bool), paramString, Boolean.valueOf(paramBoolean) });
      if ((this.FRm != null) && (this.FRm.getView() != null)) {
        this.FRm.getView().setImportantForAccessibility(1);
      }
      az.getNotification().cw(false);
      this.FRp = false;
      this.FRl = paramBundle;
      this.FRk = paramString;
      this.mNeedChattingAnim = paramBoolean;
      az.afE().eFP();
      com.tencent.mm.sdk.platformtools.aq.Wk(-8);
      com.tencent.mm.sdk.platformtools.aq.az(this.mStartChattingRunnable);
      com.tencent.mm.sdk.platformtools.aq.f(this.mStartChattingRunnable);
      AppMethodBeat.o(33656);
      return;
    }
  }
  
  public final boolean vE(boolean paramBoolean)
  {
    AppMethodBeat.i(33663);
    if (this.FRf == null) {}
    for (boolean bool = false;; bool = this.FRf.isShown())
    {
      ad.i("MicroMsg.LauncherUI.NewChattingTabUI", "try closeChatting, ishow:%b", new Object[] { Boolean.valueOf(bool) });
      if ((this.FRm != null) && (this.FRm.getView() != null)) {
        this.FRm.getView().setImportantForAccessibility(4);
      }
      if ((this.FRf != null) && (this.FRf.getVisibility() != 8) && (this.FRm != null) && (this.lTx != null)) {
        break;
      }
      AppMethodBeat.o(33663);
      return false;
    }
    if ((this.FRm != null) && (this.FRm.isSupportNavigationSwipeBack())) {
      h.b(this.lTx);
    }
    ad.i("MicroMsg.LauncherUI.NewChattingTabUI", "[closeChatting] needAnim:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    lI(4);
    this.mChattingClosed = true;
    if ((paramBoolean) && (this.mChattingOutAnim == null))
    {
      this.mChattingOutAnim = AnimationUtils.loadAnimation(this.lTx, MMFragmentActivity.a.lLI);
      this.mChattingOutAnim.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(33648);
          NewChattingTabUI.a(NewChattingTabUI.this, false);
          NewChattingTabUI.d(NewChattingTabUI.this).setVisibility(8);
          az.afE().eFR();
          com.tencent.mm.sdk.platformtools.aq.Wk(0);
          NewChattingTabUI.y(NewChattingTabUI.this);
          ad.i("MicroMsg.LauncherUI.NewChattingTabUI", "klem pop out onAnimationEnd");
          AppMethodBeat.o(33648);
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(33647);
          NewChattingTabUI.a(NewChattingTabUI.this, true);
          az.afE().eFP();
          com.tencent.mm.sdk.platformtools.aq.Wk(-8);
          NewChattingTabUI.this.S(true, 0);
          ad.i("MicroMsg.LauncherUI.NewChattingTabUI", "klem pop out onAnimationStart");
          AppMethodBeat.o(33647);
        }
      });
    }
    y.d(true, new Intent().putExtra("classname", "mainui").putExtra("main_process", false));
    if (this.FRm.isSupportCustomActionBar())
    {
      ImageView localImageView = (ImageView)this.lTx.getWindow().getDecorView().findViewById(2131303386);
      if ((localImageView != null) && (localImageView.getVisibility() == 0))
      {
        localImageView.setVisibility(8);
        ad.i("MicroMsg.LauncherUI.NewChattingTabUI", "[closeChatting] prepareView GONE");
      }
    }
    Xy(0);
    if (paramBoolean)
    {
      this.mChattingUIProxy.onExitBegin();
      this.mChattingUIProxy.onExitEnd();
      this.FRf.startAnimation(this.mChattingOutAnim);
    }
    for (;;)
    {
      AppMethodBeat.o(33663);
      return true;
      this.mChattingUIProxy.onExitBegin();
      this.mChattingUIProxy.onExitEnd();
      this.FRf.setVisibility(8);
      this.lTx.onSwipe(1.0F);
      tryResetChattingSwipeStatus();
    }
  }
  
  final class a
    implements Runnable
  {
    int FRx = 0;
    int bRZ;
    Intent doc;
    int requestCode;
    
    private a() {}
    
    public final void run()
    {
      AppMethodBeat.i(33653);
      if ((az.afw()) && (NewChattingTabUI.a(NewChattingTabUI.this) != null))
      {
        ad.i("MicroMsg.LauncherUI.NewChattingTabUI", "on post select image job, acc has ready, retry count %d", new Object[] { Integer.valueOf(this.FRx) });
        NewChattingTabUI.this.startChatting(NewChattingTabUI.b(NewChattingTabUI.this), null, false);
        com.tencent.mm.sdk.platformtools.aq.f(new Runnable()
        {
          public final void run()
          {
            boolean bool = true;
            AppMethodBeat.i(33651);
            if (NewChattingTabUI.c(NewChattingTabUI.this) == null) {}
            for (;;)
            {
              ad.d("MicroMsg.LauncherUI.NewChattingTabUI", "on select image ActivityResult. after creat chattingUI, chatting fragment is null? %B", new Object[] { Boolean.valueOf(bool) });
              if (NewChattingTabUI.c(NewChattingTabUI.this) != null)
              {
                ad.d("MicroMsg.LauncherUI.NewChattingTabUI", "on select image ActivityResult. do post activity result");
                NewChattingTabUI.c(NewChattingTabUI.this).onActivityResult(NewChattingTabUI.a.this.requestCode & 0xFFFF, NewChattingTabUI.a.this.bRZ, NewChattingTabUI.a.this.doc);
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
      if (this.FRx >= 3)
      {
        ad.w("MicroMsg.LauncherUI.NewChattingTabUI", "on post select image job, match max retry count");
        AppMethodBeat.o(33653);
        return;
      }
      if (NewChattingTabUI.a(NewChattingTabUI.this) != null) {}
      for (boolean bool = true;; bool = false)
      {
        ad.w("MicroMsg.LauncherUI.NewChattingTabUI", "on post select image job, acc not ready or view init(%B), cur retry count %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.FRx) });
        this.FRx += 1;
        com.tencent.mm.sdk.platformtools.aq.n(this, 300L);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.NewChattingTabUI
 * JD-Core Version:    0.7.0.1
 */
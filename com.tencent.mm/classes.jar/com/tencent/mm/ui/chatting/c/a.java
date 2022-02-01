package com.tencent.mm.ui.chatting.c;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowInsets;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import androidx.appcompat.app.ActionBar;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.j.a.b;
import com.tencent.mm.j.a.c;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.HomeUI.FitSystemWindowLayoutView;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity.a;
import com.tencent.mm.ui.ad;
import com.tencent.mm.ui.base.OnLayoutChangedLinearLayout;
import com.tencent.mm.ui.base.OnLayoutChangedLinearLayout.a;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ChattingUIFragment;
import com.tencent.mm.ui.chatting.ChattingUIProxy;
import com.tencent.mm.ui.tools.TestTimeForChatting;
import com.tencent.mm.ui.tools.TestTimeForChatting.a;
import com.tencent.mm.ui.tools.k;
import com.tencent.mm.ui.w;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.ui.widget.j;
import com.tencent.mm.ui.widget.j.a;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

public final class a
  implements com.tencent.mm.j.a, j.a
{
  int PyE;
  ChattingUIFragment WGA;
  final ChattingUIProxy WGB;
  Animation WGC;
  boolean WGD;
  String WGE;
  private a.a WGF;
  HashSet<a.b> WGG;
  a.c WGH;
  public boolean WGI;
  boolean Wdl;
  MMActivity activity;
  private int chattingID;
  TestTimeForChatting chattingView;
  boolean isAnimating;
  ActionBar mActionBar;
  private Bitmap mPrepareBitmap;
  MMHandler mainHandler;
  OnLayoutChangedLinearLayout.a onChattingLayoutChangedListener;
  Bundle pendingBundle;
  String pendingUser;
  Runnable startChattingRunnable;
  
  a(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(276760);
    this.WGD = false;
    this.WGF = a.a.WGM;
    this.mainHandler = new MMHandler(Looper.getMainLooper());
    this.WGG = new HashSet();
    this.PyE = -1;
    this.WGI = false;
    this.startChattingRunnable = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(279605);
        a.this.PyE = a.this.activity.getController().PyE;
        if (!a.this.WGD)
        {
          Log.e("ChattingCompat", "start chatting but last chatting does't be close!");
          a.this.atu();
        }
        if ((a.this.activity.isFinishing()) || (a.a(a.this)) || (!a.this.WGD))
        {
          Log.w("ChattingCompat", "[startChattingRunnable] pass! isPause:%s mChattingClosed:%s", new Object[] { Boolean.valueOf(a.a(a.this)), Boolean.valueOf(a.this.WGD) });
          a.this.Wdl = true;
          AppMethodBeat.o(279605);
          return;
        }
        a.this.WGD = false;
        Object localObject = a.this.WGG.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((a.b)((Iterator)localObject).next()).aty();
        }
        localObject = new Intent().putExtra("Chat_User", a.this.pendingUser);
        ((Intent)localObject).putExtra("Chat_Self", a.this.WGE);
        if (a.this.pendingBundle != null) {
          ((Intent)localObject).putExtras(a.this.pendingBundle);
        }
        ((Intent)localObject).putExtra("img_gallery_enter_from_chatting_ui", true);
        a.this.WGA.getArguments().putAll(IntentUtil.getExtras((Intent)localObject));
        a.a(a.this, false);
        a.b(a.this).setOnChattingLayoutChangedListener(a.this.onChattingLayoutChangedListener);
        if (a.this.activity.getWindow().getDecorView().getWidth() == 0) {}
        for (float f = a.this.activity.getResources().getDisplayMetrics().widthPixels;; f = a.this.activity.getWindow().getDecorView().getWidth())
        {
          a.this.chattingView.setTranslationX(f - 0.1F);
          a.this.chattingView.setVisibility(0);
          j.a(a.this);
          AppMethodBeat.o(279605);
          return;
        }
      }
    };
    this.onChattingLayoutChangedListener = new OnLayoutChangedLinearLayout.a()
    {
      long start = 0L;
      
      public final void hIt()
      {
        AppMethodBeat.i(291407);
        if (a.this.WGC == null)
        {
          a.this.WGC = AnimationUtils.loadAnimation(a.this.activity, MMFragmentActivity.a.rhY);
          a.this.WGC.setAnimationListener(new Animation.AnimationListener()
          {
            public final void onAnimationEnd(Animation paramAnonymous2Animation)
            {
              AppMethodBeat.i(275922);
              a.this.isAnimating = false;
              Log.i("ChattingCompat", "klem animationEnd");
              paramAnonymous2Animation = a.this;
              com.tencent.e.h.ZvG.n(new a.4(paramAnonymous2Animation), 60L);
              AppMethodBeat.o(275922);
            }
            
            public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
            
            public final void onAnimationStart(Animation paramAnonymous2Animation)
            {
              AppMethodBeat.i(275921);
              Log.i("ChattingCompat", "klem onAnimationStart onDrawed->onAnimationStart:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - a.3.this.start) });
              a.this.isAnimating = true;
              paramAnonymous2Animation = a.this;
              paramAnonymous2Animation.chattingView.setTranslationX(0.0F);
              paramAnonymous2Animation.chattingView.hYG();
              a.this.onSettle(false, 0);
              AppMethodBeat.o(275921);
            }
          });
        }
        a.this.chattingView.setOndispatchDraw(new TestTimeForChatting.a()
        {
          public final void hIu()
          {
            AppMethodBeat.i(287654);
            Log.i("ChattingCompat", "[onDrawed]");
            a.3.this.start = System.currentTimeMillis();
            if (a.this.WGA == null)
            {
              Log.e("ChattingCompat", "chattingFragmet is null!");
              AppMethodBeat.o(287654);
              return;
            }
            if (a.this.WGA.getSwipeBackLayout() != null) {
              a.this.WGA.getSwipeBackLayout().startAnimation(a.this.WGC);
            }
            for (;;)
            {
              a.this.chattingView.setOndispatchDraw(null);
              AppMethodBeat.o(287654);
              return;
              a.this.WGA.getView().startAnimation(a.this.WGC);
            }
          }
        });
        ((OnLayoutChangedLinearLayout)Objects.requireNonNull(a.b(a.this))).WpA = null;
        Log.i("ChattingCompat", "klem CHATTING ONLAYOUT ");
        AppMethodBeat.o(291407);
      }
    };
    this.activity = paramMMActivity;
    this.WGA = new ChattingUIFragment();
    this.WGB = new ChattingUIProxy(paramMMActivity, this.WGA);
    AppMethodBeat.o(276760);
  }
  
  static void a(HomeUI.FitSystemWindowLayoutView paramFitSystemWindowLayoutView, Rect paramRect, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(276788);
    paramFitSystemWindowLayoutView.setActionBarContainer(paramViewGroup);
    paramFitSystemWindowLayoutView.fitSystemWindows(paramRect);
    AppMethodBeat.o(276788);
  }
  
  private ViewGroup findRootContainer()
  {
    AppMethodBeat.i(276789);
    Object localObject1 = this.mActionBar.getCustomView().getParent();
    Object localObject2 = null;
    ViewGroup localViewGroup = (ViewGroup)this.activity.getWindow().getDecorView();
    while ((localObject1 != localViewGroup) && (localObject1 != null))
    {
      ViewParent localViewParent = ((ViewParent)localObject1).getParent();
      localObject2 = localObject1;
      localObject1 = localViewParent;
    }
    localObject1 = (ViewGroup)localObject2;
    AppMethodBeat.o(276789);
    return localObject1;
  }
  
  private Bitmap getMagicDrawingCache(View paramView)
  {
    AppMethodBeat.i(276787);
    long l = System.currentTimeMillis();
    int i = paramView.getWidth();
    int j = paramView.getHeight();
    if (i <= 0) {
      i = paramView.getMeasuredWidth();
    }
    for (;;)
    {
      if (j <= 0) {
        j = paramView.getMeasuredHeight();
      }
      for (;;)
      {
        if ((i <= 0) || (j <= 0) || (this.WGA.getView() == null))
        {
          Log.e("ChattingCompat", "viewWidth:%s viewHeight:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          AppMethodBeat.o(276787);
          return null;
        }
        Log.i("ChattingCompat", "getBottom:%s keyboardState:%s", new Object[] { Integer.valueOf(this.WGA.getView().getBottom()), Integer.valueOf(this.WGA.keyboardState()) });
        if ((this.WGA.getView().getBottom() > 0) && ((this.WGA.keyboardState() == 1) || (this.WGA.getView().getBottom() < this.activity.getResources().getDisplayMetrics().heightPixels * 2 / 3)))
        {
          Log.e("ChattingCompat", "hardKeyboardHidden:%s", new Object[] { Integer.valueOf(this.WGA.keyboardState()) });
          AppMethodBeat.o(276787);
          return null;
        }
        if (this.WGA.keyboardState() == 1)
        {
          Log.e("ChattingCompat", "hardKeyboardHidden:%s", new Object[] { Integer.valueOf(this.WGA.keyboardState()) });
          AppMethodBeat.o(276787);
          return null;
        }
        if ((this.mPrepareBitmap == null) || (this.mPrepareBitmap.isRecycled()) || (this.mPrepareBitmap.getWidth() != i) || (this.mPrepareBitmap.getHeight() != j)) {
          if ((this.mPrepareBitmap != null) && (!this.mPrepareBitmap.isRecycled()))
          {
            Log.i("ChattingCompat", "bitmap recycle %s", new Object[] { this.mPrepareBitmap.toString() });
            this.mPrepareBitmap.recycle();
          }
        }
        for (;;)
        {
          try
          {
            this.mPrepareBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_4444);
            Canvas localCanvas = new Canvas(this.mPrepareBitmap);
            int k = (int)this.activity.getResources().getDimension(R.f.wechat_abc_action_bar_default_height);
            int m = (int)this.activity.getResources().getDimension(R.f.DefaultTabbarHeight);
            Paint localPaint = new Paint();
            localPaint.setColor(-1);
            localCanvas.drawRect(0.0F, k, i, j - m, localPaint);
            paramView.draw(localCanvas);
            Log.i("ChattingCompat", "[getMagicDrawingCache] cost%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
            paramView = this.mPrepareBitmap;
            AppMethodBeat.o(276787);
            return paramView;
          }
          catch (OutOfMemoryError paramView)
          {
            Log.e("ChattingCompat", "[getMagicDrawingCache] e:%s", new Object[] { paramView });
            AppMethodBeat.o(276787);
            return null;
          }
          this.mPrepareBitmap.eraseColor(0);
        }
      }
    }
  }
  
  public final void a(a.b paramb)
  {
    AppMethodBeat.i(276783);
    if (paramb != null) {
      this.WGG.add(paramb);
    }
    AppMethodBeat.o(276783);
  }
  
  public final void a(a.c paramc)
  {
    this.WGH = paramc;
  }
  
  public final void a(String paramString1, String paramString2, a.b paramb)
  {
    AppMethodBeat.i(276764);
    a(paramb);
    this.pendingUser = paramString1;
    this.WGE = paramString2;
    this.pendingBundle = null;
    this.Wdl = false;
    this.mainHandler.removeCallbacks(this.startChattingRunnable);
    this.mainHandler.post(this.startChattingRunnable);
    AppMethodBeat.o(276764);
  }
  
  public final void atu()
  {
    boolean bool = true;
    AppMethodBeat.i(276766);
    this.WGD = true;
    if ((this.chattingView != null) && (this.chattingView.isShown())) {}
    for (;;)
    {
      Log.i("ChattingCompat", "try closeChatting, isShown:%b", new Object[] { Boolean.valueOf(bool) });
      if ((this.WGA != null) && (this.WGA.isSupportNavigationSwipeBack())) {
        j.b(this);
      }
      if ((this.chattingView != null) && (this.chattingView.getVisibility() != 8) && (this.WGA != null)) {
        break;
      }
      AppMethodBeat.o(276766);
      return;
      bool = false;
    }
    Object localObject = this.WGG.iterator();
    while (((Iterator)localObject).hasNext()) {
      if (!((a.b)((Iterator)localObject).next()).atz()) {
        ((Iterator)localObject).remove();
      }
    }
    this.chattingView.setVisibility(8);
    localObject = (ImageView)this.activity.getWindow().getDecorView().findViewById(R.h.dRm);
    if ((localObject != null) && (((ImageView)localObject).getVisibility() == 0))
    {
      ((ImageView)localObject).setVisibility(8);
      Log.i("ChattingCompat", "[closeChatting] prepareView GONE");
      if (((ImageView)localObject).getTag() != null) {
        ((View)((ImageView)localObject).getTag()).setVisibility(0);
      }
    }
    this.WGB.onExitBegin();
    this.WGB.onExitEnd();
    this.chattingView.setVisibility(8);
    onSwipe(1.0F);
    tryResetChattingSwipeStatus();
    this.activity.getController().setStatusBarColor(this.PyE);
    AppMethodBeat.o(276766);
  }
  
  public final void atv()
  {
    AppMethodBeat.i(276767);
    this.activity.getWindow().setFormat(-2);
    com.tencent.mm.pluginsdk.h.r(this.activity);
    this.activity.customfixStatusbar(true);
    AppMethodBeat.o(276767);
  }
  
  public final void atw()
  {
    AppMethodBeat.i(276769);
    this.activity.getWindow().setBackgroundDrawableResource(R.e.White);
    this.mActionBar = com.tencent.mm.ui.widget.d.c(this.activity.getSupportActionBar());
    this.activity.initNavigationSwipeBack();
    if (this.WGI) {
      Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
      {
        public final boolean queueIdle()
        {
          AppMethodBeat.i(274056);
          if (a.this.activity == null)
          {
            AppMethodBeat.o(274056);
            return false;
          }
          if ((a.this.activity.isDestroyed()) || (a.this.activity.isFinishing()))
          {
            AppMethodBeat.o(274056);
            return false;
          }
          a.a(a.this, true);
          AppMethodBeat.o(274056);
          return false;
        }
      });
    }
    if ((this.WGA != null) && (this.WGA.fgR.dgo)) {
      Log.w("ChattingCompat", "[initActionBar] isChattingForeground True!");
    }
    for (;;)
    {
      this.mActionBar.show();
      com.tencent.mm.pluginsdk.h.s(this.activity);
      AppMethodBeat.o(276769);
      return;
      Log.w("ChattingCompat", "[initActionBar] isChattingForeground False!");
      View localView = ad.kS(this.activity).inflate(R.i.actionbar_custom_area, null);
      com.tencent.mm.ui.b localb = new com.tencent.mm.ui.b(localView);
      this.mActionBar.setLogo(new ColorDrawable(this.activity.getResources().getColor(17170445)));
      this.mActionBar.t(false);
      this.mActionBar.s(false);
      this.mActionBar.r(false);
      this.mActionBar.u(true);
      this.mActionBar.setCustomView(localView);
      this.activity.getController().VZF = localb.mNb;
      localb.setClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(270972);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/compat/ChattingCompat$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if (!a.this.isAnimating)
          {
            a.this.mainHandler.removeCallbacks(a.this.startChattingRunnable);
            if (a.this.WGH != null) {
              a.this.WGH.onFinish();
            }
            a.this.activity.finish();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/compat/ChattingCompat$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(270972);
        }
      });
    }
  }
  
  public final boolean atx()
  {
    return this.WGD;
  }
  
  public final void b(a.b paramb)
  {
    AppMethodBeat.i(276784);
    this.WGG.remove(paramb);
    AppMethodBeat.o(276784);
  }
  
  public final boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(276781);
    Log.d("ChattingCompat", "chatting ui dispatch key event %s", new Object[] { paramKeyEvent });
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0)) {
      this.mainHandler.removeCallbacks(this.startChattingRunnable);
    }
    if (this.isAnimating)
    {
      AppMethodBeat.o(276781);
      return true;
    }
    if ((this.WGA != null) && (this.WGA.onKeyDown(paramKeyEvent.getKeyCode(), paramKeyEvent)))
    {
      AppMethodBeat.o(276781);
      return true;
    }
    AppMethodBeat.o(276781);
    return false;
  }
  
  public final void e(Boolean paramBoolean)
  {
    AppMethodBeat.i(276763);
    this.WGI = paramBoolean.booleanValue();
    AppMethodBeat.o(276763);
  }
  
  public final boolean forceRemoveNoMatchOnPath()
  {
    return false;
  }
  
  public final boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(276773);
    if (((paramInt1 == 2001) || (paramInt1 == 30763) || (paramInt1 == 226) || (paramInt1 == 30762) || (paramInt1 == 1111)) && (this.WGA != null))
    {
      this.WGA.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(276773);
      return true;
    }
    AppMethodBeat.o(276773);
    return false;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(276772);
    if ((this.mPrepareBitmap != null) && (!this.mPrepareBitmap.isRecycled()))
    {
      Log.i("ChattingCompat", "bitmap recycle %s", new Object[] { this.mPrepareBitmap.toString() });
      this.mPrepareBitmap.recycle();
    }
    this.Wdl = false;
    this.WGG.clear();
    this.mainHandler.removeCallbacksAndMessages(null);
    this.activity = null;
    this.WGA = null;
    this.chattingView = null;
    this.WGC = null;
    AppMethodBeat.o(276772);
  }
  
  public final void onPause()
  {
    this.WGF = a.a.WGO;
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(276775);
    if (this.WGA != null) {
      this.WGA.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    }
    AppMethodBeat.o(276775);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(276771);
    this.WGF = a.a.WGN;
    onSwipe(1.0F);
    if ((this.WGA != null) && (this.WGA.fgR.dgo)) {}
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && (this.Wdl))
      {
        String str = this.pendingUser;
        Bundle localBundle = this.pendingBundle;
        this.pendingUser = str;
        this.pendingBundle = localBundle;
        this.Wdl = false;
        this.mainHandler.removeCallbacks(this.startChattingRunnable);
        this.mainHandler.post(this.startChattingRunnable);
      }
      AppMethodBeat.o(276771);
      return;
    }
  }
  
  public final void onSettle(boolean paramBoolean, int paramInt)
  {
    long l = 130L;
    AppMethodBeat.i(276777);
    Log.v("ChattingCompat", "ashutest: on settle %B, speed %d, resumeStatus %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), this.WGF });
    if ((!com.tencent.mm.compatible.util.d.qV(19)) || (!com.tencent.mm.compatible.h.b.avx()))
    {
      AppMethodBeat.o(276777);
      return;
    }
    View localView = this.activity.findViewById(R.h.dKQ);
    if (localView == null)
    {
      Log.e("ChattingCompat", "[onSettle] null == container");
      AppMethodBeat.o(276777);
      return;
    }
    ImageView localImageView = (ImageView)this.activity.findViewById(R.h.dRm);
    if ((localImageView != null) && (localImageView.getVisibility() == 8) && (localImageView.getDrawable() != null))
    {
      localImageView.setVisibility(0);
      Log.i("ChattingCompat", "[onSettle] prepareView VISIBLE");
      localView.setVisibility(8);
    }
    if ((localImageView != null) && (localImageView.getVisibility() == 0))
    {
      if (paramBoolean)
      {
        if (paramInt > 0) {}
        for (;;)
        {
          k.a(localImageView, l, 0.0F, null);
          AppMethodBeat.o(276777);
          return;
          l = 230L;
        }
      }
      if (paramInt > 0) {}
      for (;;)
      {
        k.a(localImageView, l, localImageView.getWidth() * -1 / 4, null);
        AppMethodBeat.o(276777);
        return;
        l = 230L;
      }
    }
    if (paramBoolean)
    {
      if (paramInt > 0) {}
      for (;;)
      {
        k.a(localView, l, 0.0F, null);
        AppMethodBeat.o(276777);
        return;
        l = 230L;
      }
    }
    if (paramInt > 0) {}
    for (;;)
    {
      k.a(localView, l, localView.getWidth() * -1 / 4, null);
      AppMethodBeat.o(276777);
      return;
      l = 230L;
    }
  }
  
  public final void onSwipe(float paramFloat)
  {
    AppMethodBeat.i(276780);
    Log.v("ChattingCompat", "ashutest::on swipe %f, duration %d, status %s", new Object[] { Float.valueOf(paramFloat), Long.valueOf(320L), this.WGF });
    if ((!com.tencent.mm.compatible.util.d.qV(19)) || (!com.tencent.mm.compatible.h.b.avx()))
    {
      AppMethodBeat.o(276780);
      return;
    }
    if (this.WGA == null)
    {
      AppMethodBeat.o(276780);
      return;
    }
    if ((paramFloat == 0.0F) && (!this.WGD))
    {
      localObject1 = (ImageView)this.activity.getWindow().getDecorView().findViewById(R.h.dRm);
      if (localObject1 != null)
      {
        localObject2 = (ViewGroup)((ImageView)localObject1).getTag();
        if (localObject2 != null)
        {
          Log.i("ChattingCompat", "[onSwipe] prepareView GONE");
          ((ViewGroup)localObject2).setVisibility(0);
          ((ImageView)localObject1).setVisibility(8);
          ((ImageView)localObject1).setImageDrawable(null);
        }
      }
      if (this.WGC != null) {
        this.WGC.cancel();
      }
    }
    while ((a.a.WGN != this.WGF) && (Float.compare(1.0F, paramFloat) > 0))
    {
      Log.i("ChattingCompat", "[onSwipe] return! consumedSuperCall:%s", new Object[] { Float.valueOf(paramFloat) });
      AppMethodBeat.o(276780);
      return;
      if ((paramFloat == 1.0F) && (!this.WGD) && (this.WGA.isSupportNavigationSwipeBack()))
      {
        this.activity.getWindow().setBackgroundDrawableResource(R.e.dkI);
        localObject1 = (ImageView)this.activity.getWindow().getDecorView().findViewById(R.h.dRm);
        if ((localObject1 != null) && (((ImageView)localObject1).getVisibility() == 0) && (((ImageView)localObject1).getTag() != null))
        {
          ((View)((ImageView)localObject1).getTag()).setVisibility(0);
          Log.i("ChattingCompat", "[onSwipe] prepareView GONE");
          ((ImageView)localObject1).setVisibility(8);
        }
      }
    }
    Object localObject1 = this.activity.findViewById(R.h.dKQ);
    Object localObject2 = (ImageView)this.activity.findViewById(R.h.dRm);
    if ((localObject2 != null) && (((ImageView)localObject2).getVisibility() == 8) && (((ImageView)localObject2).getDrawable() != null) && (!this.WGD) && (paramFloat != 1.0F) && (paramFloat != 0.0F))
    {
      ((ImageView)localObject2).setVisibility(0);
      Log.i("ChattingCompat", "[onSwipe] !1 && !0 prepareView VISIBLE");
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
    }
    if (Float.compare(1.0F, paramFloat) <= 0)
    {
      k.q((View)localObject1, 0.0F);
      k.q((View)localObject2, 0.0F);
      AppMethodBeat.o(276780);
      return;
    }
    if ((localObject2 != null) && (((ImageView)localObject2).getDrawable() != null))
    {
      k.q((View)localObject2, ((ImageView)localObject2).getWidth() / 4 * (1.0F - paramFloat) * -1.0F);
      AppMethodBeat.o(276780);
      return;
    }
    k.q((View)localObject1, ((View)localObject1).getWidth() / 4 * (1.0F - paramFloat) * -1.0F);
    AppMethodBeat.o(276780);
  }
  
  final void tryResetChattingSwipeStatus()
  {
    boolean bool = true;
    AppMethodBeat.i(276779);
    if ((!com.tencent.mm.compatible.util.d.qV(19)) || (!com.tencent.mm.compatible.h.b.avx()))
    {
      AppMethodBeat.o(276779);
      return;
    }
    if (this.WGA == null) {}
    for (;;)
    {
      Log.i("ChattingCompat", "ashutest: tryResetChattingSwipeStatus, chattingFragment NULL ? %B", new Object[] { Boolean.valueOf(bool) });
      if (this.WGA != null) {
        this.WGA.getSwipeBackLayout().jRp = false;
      }
      AppMethodBeat.o(276779);
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.a
 * JD-Core Version:    0.7.0.1
 */
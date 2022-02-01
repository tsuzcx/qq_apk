package com.tencent.mm.ui.chatting.c;

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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.chatting.a.b;
import com.tencent.mm.chatting.a.c;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.HomeUI.FitSystemWindowLayoutView;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity.a;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.base.OnLayoutChangedLinearLayout;
import com.tencent.mm.ui.base.OnLayoutChangedLinearLayout.a;
import com.tencent.mm.ui.chatting.ChattingUIFragment;
import com.tencent.mm.ui.chatting.ChattingUIProxy;
import com.tencent.mm.ui.tools.TestTimeForChatting;
import com.tencent.mm.ui.tools.TestTimeForChatting.a;
import com.tencent.mm.ui.tools.k;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.ui.widget.l;
import com.tencent.mm.ui.widget.l.a;
import com.tencent.mm.ui.y;
import com.tencent.threadpool.i;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

public final class a
  implements com.tencent.mm.chatting.a, l.a
{
  int WoL;
  MMActivity activity;
  boolean adIO;
  ChattingUIFragment aenP;
  final ChattingUIProxy aenQ;
  Animation aenR;
  boolean aenS;
  String aenT;
  private a.a aenU;
  HashSet<a.b> aenV;
  a.c aenW;
  public boolean aenX;
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
    AppMethodBeat.i(254140);
    this.aenS = false;
    this.aenU = a.a.aeob;
    this.mainHandler = new MMHandler(Looper.getMainLooper());
    this.aenV = new HashSet();
    this.WoL = -1;
    this.aenX = false;
    this.startChattingRunnable = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(254127);
        a.this.WoL = a.this.activity.getController().WoL;
        if (!a.this.aenS)
        {
          Log.e("ChattingCompat", "start chatting but last chatting does't be close!");
          a.this.aNR();
        }
        if ((a.this.activity.isFinishing()) || (a.a(a.this)) || (!a.this.aenS))
        {
          Log.w("ChattingCompat", "[startChattingRunnable] pass! isPause:%s mChattingClosed:%s", new Object[] { Boolean.valueOf(a.a(a.this)), Boolean.valueOf(a.this.aenS) });
          a.this.adIO = true;
          AppMethodBeat.o(254127);
          return;
        }
        a.this.aenS = false;
        Object localObject = a.this.aenV.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((a.b)((Iterator)localObject).next()).aNV();
        }
        localObject = new Intent().putExtra("Chat_User", a.this.pendingUser);
        ((Intent)localObject).putExtra("Chat_Self", a.this.aenT);
        if (a.this.pendingBundle != null) {
          ((Intent)localObject).putExtras(a.this.pendingBundle);
        }
        ((Intent)localObject).putExtra("img_gallery_enter_from_chatting_ui", true);
        a.this.aenP.getArguments().putAll(IntentUtil.getExtras((Intent)localObject));
        a.a(a.this, false);
        a.b(a.this).setOnChattingLayoutChangedListener(a.this.onChattingLayoutChangedListener);
        if (a.this.activity.getWindow().getDecorView().getWidth() == 0) {}
        for (float f = a.this.activity.getResources().getDisplayMetrics().widthPixels;; f = a.this.activity.getWindow().getDecorView().getWidth())
        {
          a.this.chattingView.setTranslationX(f - 0.1F);
          a.this.chattingView.setVisibility(0);
          l.a(a.this);
          AppMethodBeat.o(254127);
          return;
        }
      }
    };
    this.onChattingLayoutChangedListener = new OnLayoutChangedLinearLayout.a()
    {
      long start = 0L;
      
      public final void jkC()
      {
        AppMethodBeat.i(254123);
        if (a.this.aenR == null)
        {
          a.this.aenR = AnimationUtils.loadAnimation(a.this.activity, MMFragmentActivity.a.upU);
          a.this.aenR.setAnimationListener(new Animation.AnimationListener()
          {
            public final void onAnimationEnd(Animation paramAnonymous2Animation)
            {
              AppMethodBeat.i(254141);
              a.this.isAnimating = false;
              Log.i("ChattingCompat", "klem animationEnd");
              paramAnonymous2Animation = a.this;
              com.tencent.threadpool.h.ahAA.o(new a.4(paramAnonymous2Animation), 60L);
              AppMethodBeat.o(254141);
            }
            
            public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
            
            public final void onAnimationStart(Animation paramAnonymous2Animation)
            {
              AppMethodBeat.i(254135);
              Log.i("ChattingCompat", "klem onAnimationStart onDrawed->onAnimationStart:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - a.3.this.start) });
              a.this.isAnimating = true;
              paramAnonymous2Animation = a.this;
              paramAnonymous2Animation.chattingView.setTranslationX(0.0F);
              paramAnonymous2Animation.chattingView.jDp();
              a.this.onSettle(false, 0);
              AppMethodBeat.o(254135);
            }
          });
        }
        a.this.chattingView.setOndispatchDraw(new TestTimeForChatting.a()
        {
          public final void jkD()
          {
            AppMethodBeat.i(254133);
            Log.i("ChattingCompat", "[onDrawed]");
            a.3.this.start = System.currentTimeMillis();
            if (a.this.aenP == null)
            {
              Log.e("ChattingCompat", "chattingFragmet is null!");
              AppMethodBeat.o(254133);
              return;
            }
            if (a.this.aenP.getSwipeBackLayout() != null) {
              a.this.aenP.getSwipeBackLayout().startAnimation(a.this.aenR);
            }
            for (;;)
            {
              a.this.chattingView.setOndispatchDraw(null);
              AppMethodBeat.o(254133);
              return;
              a.this.aenP.getView().startAnimation(a.this.aenR);
            }
          }
        });
        ((OnLayoutChangedLinearLayout)Objects.requireNonNull(a.b(a.this))).adWO = null;
        Log.i("ChattingCompat", "klem CHATTING ONLAYOUT ");
        AppMethodBeat.o(254123);
      }
    };
    this.activity = paramMMActivity;
    this.aenP = new ChattingUIFragment();
    this.aenQ = new ChattingUIProxy(paramMMActivity, this.aenP);
    AppMethodBeat.o(254140);
  }
  
  static void a(HomeUI.FitSystemWindowLayoutView paramFitSystemWindowLayoutView, Rect paramRect, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(254147);
    paramFitSystemWindowLayoutView.setActionBarContainer(paramViewGroup);
    paramFitSystemWindowLayoutView.fitSystemWindows(paramRect);
    AppMethodBeat.o(254147);
  }
  
  private ViewGroup findRootContainer()
  {
    AppMethodBeat.i(254153);
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
    AppMethodBeat.o(254153);
    return localObject1;
  }
  
  private Bitmap getMagicDrawingCache(View paramView)
  {
    AppMethodBeat.i(254144);
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
        if ((i <= 0) || (j <= 0) || (this.aenP.getView() == null))
        {
          Log.e("ChattingCompat", "viewWidth:%s viewHeight:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          AppMethodBeat.o(254144);
          return null;
        }
        Log.i("ChattingCompat", "getBottom:%s keyboardState:%s", new Object[] { Integer.valueOf(this.aenP.getView().getBottom()), Integer.valueOf(this.aenP.keyboardState()) });
        if ((this.aenP.getView().getBottom() > 0) && ((this.aenP.keyboardState() == 1) || (this.aenP.getView().getBottom() < this.activity.getResources().getDisplayMetrics().heightPixels * 2 / 3)))
        {
          Log.e("ChattingCompat", "hardKeyboardHidden:%s", new Object[] { Integer.valueOf(this.aenP.keyboardState()) });
          AppMethodBeat.o(254144);
          return null;
        }
        if (this.aenP.keyboardState() == 1)
        {
          Log.e("ChattingCompat", "hardKeyboardHidden:%s", new Object[] { Integer.valueOf(this.aenP.keyboardState()) });
          AppMethodBeat.o(254144);
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
            AppMethodBeat.o(254144);
            return paramView;
          }
          catch (OutOfMemoryError paramView)
          {
            Log.e("ChattingCompat", "[getMagicDrawingCache] e:%s", new Object[] { paramView });
            AppMethodBeat.o(254144);
            return null;
          }
          this.mPrepareBitmap.eraseColor(0);
        }
      }
    }
  }
  
  public final void a(a.b paramb)
  {
    AppMethodBeat.i(254246);
    if (paramb != null) {
      this.aenV.add(paramb);
    }
    AppMethodBeat.o(254246);
  }
  
  public final void a(a.c paramc)
  {
    this.aenW = paramc;
  }
  
  public final void a(String paramString1, String paramString2, a.b paramb)
  {
    AppMethodBeat.i(254192);
    a(paramb);
    this.pendingUser = paramString1;
    this.aenT = paramString2;
    this.pendingBundle = null;
    this.adIO = false;
    this.mainHandler.removeCallbacks(this.startChattingRunnable);
    this.mainHandler.post(this.startChattingRunnable);
    AppMethodBeat.o(254192);
  }
  
  public final void aNR()
  {
    boolean bool = true;
    AppMethodBeat.i(254198);
    this.aenS = true;
    if ((this.chattingView != null) && (this.chattingView.isShown())) {}
    for (;;)
    {
      Log.i("ChattingCompat", "try closeChatting, isShown:%b", new Object[] { Boolean.valueOf(bool) });
      if ((this.aenP != null) && (this.aenP.isSupportNavigationSwipeBack())) {
        l.b(this);
      }
      if ((this.chattingView != null) && (this.chattingView.getVisibility() != 8) && (this.aenP != null)) {
        break;
      }
      AppMethodBeat.o(254198);
      return;
      bool = false;
    }
    Object localObject = this.aenV.iterator();
    while (((Iterator)localObject).hasNext()) {
      if (!((a.b)((Iterator)localObject).next()).aNW()) {
        ((Iterator)localObject).remove();
      }
    }
    this.chattingView.setVisibility(8);
    localObject = (ImageView)this.activity.getWindow().getDecorView().findViewById(R.h.fTp);
    if ((localObject != null) && (((ImageView)localObject).getVisibility() == 0))
    {
      ((ImageView)localObject).setVisibility(8);
      Log.i("ChattingCompat", "[closeChatting] prepareView GONE");
      if (((ImageView)localObject).getTag() != null) {
        ((View)((ImageView)localObject).getTag()).setVisibility(0);
      }
    }
    this.aenQ.onExitBegin();
    this.aenQ.onExitEnd();
    this.chattingView.setVisibility(8);
    onSwipe(1.0F);
    tryResetChattingSwipeStatus();
    this.activity.getController().setStatusBarColor(this.WoL);
    AppMethodBeat.o(254198);
  }
  
  public final void aNS()
  {
    AppMethodBeat.i(254203);
    this.activity.getWindow().setFormat(-2);
    com.tencent.mm.pluginsdk.h.w(this.activity);
    this.activity.customfixStatusbar(true);
    AppMethodBeat.o(254203);
  }
  
  public final void aNT()
  {
    AppMethodBeat.i(254210);
    this.activity.getWindow().setBackgroundDrawableResource(R.e.White);
    this.mActionBar = com.tencent.mm.ui.widget.d.c(this.activity.getSupportActionBar());
    this.activity.initNavigationSwipeBack();
    if (this.aenX) {
      Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
      {
        public final boolean queueIdle()
        {
          AppMethodBeat.i(254122);
          if (a.this.activity == null)
          {
            AppMethodBeat.o(254122);
            return false;
          }
          if ((a.this.activity.isDestroyed()) || (a.this.activity.isFinishing()))
          {
            AppMethodBeat.o(254122);
            return false;
          }
          a.a(a.this, true);
          AppMethodBeat.o(254122);
          return false;
        }
      });
    }
    if ((this.aenP != null) && (this.aenP.iNh().ffv)) {
      Log.w("ChattingCompat", "[initActionBar] isChattingForeground True!");
    }
    for (;;)
    {
      this.mActionBar.show();
      com.tencent.mm.pluginsdk.h.x(this.activity);
      AppMethodBeat.o(254210);
      return;
      Log.w("ChattingCompat", "[initActionBar] isChattingForeground False!");
      View localView = af.mU(this.activity).inflate(R.i.actionbar_custom_area, null);
      com.tencent.mm.ui.b localb = new com.tencent.mm.ui.b(localView);
      this.mActionBar.setLogo(new ColorDrawable(this.activity.getResources().getColor(17170445)));
      this.mActionBar.x(false);
      this.mActionBar.w(false);
      this.mActionBar.v(false);
      this.mActionBar.y(true);
      this.mActionBar.setCustomView(localView);
      this.activity.getController().adDZ = localb.pJJ;
      localb.setClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(254125);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/compat/ChattingCompat$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          if (!a.this.isAnimating)
          {
            a.this.mainHandler.removeCallbacks(a.this.startChattingRunnable);
            if (a.this.aenW != null) {
              a.this.aenW.onFinish();
            }
            a.this.activity.finish();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/compat/ChattingCompat$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(254125);
        }
      });
    }
  }
  
  public final boolean aNU()
  {
    return this.aenS;
  }
  
  public final void b(a.b paramb)
  {
    AppMethodBeat.i(254248);
    this.aenV.remove(paramb);
    AppMethodBeat.o(254248);
  }
  
  public final boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(254241);
    Log.d("ChattingCompat", "chatting ui dispatch key event %s", new Object[] { paramKeyEvent });
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0)) {
      this.mainHandler.removeCallbacks(this.startChattingRunnable);
    }
    if (this.isAnimating)
    {
      AppMethodBeat.o(254241);
      return true;
    }
    if ((this.aenP != null) && (this.aenP.onKeyDown(paramKeyEvent.getKeyCode(), paramKeyEvent)))
    {
      AppMethodBeat.o(254241);
      return true;
    }
    AppMethodBeat.o(254241);
    return false;
  }
  
  public final boolean forceRemoveNoMatchOnPath()
  {
    return false;
  }
  
  public final void i(Boolean paramBoolean)
  {
    AppMethodBeat.i(254186);
    this.aenX = paramBoolean.booleanValue();
    AppMethodBeat.o(254186);
  }
  
  public final boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(254221);
    if (((paramInt1 == 2001) || (paramInt1 == 30763) || (paramInt1 == 226) || (paramInt1 == 30762) || (paramInt1 == 1111)) && (this.aenP != null))
    {
      this.aenP.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(254221);
      return true;
    }
    AppMethodBeat.o(254221);
    return false;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(254218);
    if ((this.mPrepareBitmap != null) && (!this.mPrepareBitmap.isRecycled()))
    {
      Log.i("ChattingCompat", "bitmap recycle %s", new Object[] { this.mPrepareBitmap.toString() });
      this.mPrepareBitmap.recycle();
    }
    this.adIO = false;
    this.aenV.clear();
    this.mainHandler.removeCallbacksAndMessages(null);
    this.activity = null;
    this.aenP = null;
    this.chattingView = null;
    this.aenR = null;
    AppMethodBeat.o(254218);
  }
  
  public final void onPause()
  {
    this.aenU = a.a.aeod;
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(254225);
    if (this.aenP != null) {
      this.aenP.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    }
    AppMethodBeat.o(254225);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(254216);
    this.aenU = a.a.aeoc;
    onSwipe(1.0F);
    if ((this.aenP != null) && (this.aenP.isForeground())) {}
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && (this.adIO))
      {
        String str = this.pendingUser;
        Bundle localBundle = this.pendingBundle;
        this.pendingUser = str;
        this.pendingBundle = localBundle;
        this.adIO = false;
        this.mainHandler.removeCallbacks(this.startChattingRunnable);
        this.mainHandler.post(this.startChattingRunnable);
      }
      AppMethodBeat.o(254216);
      return;
    }
  }
  
  public final void onSettle(boolean paramBoolean, int paramInt)
  {
    long l = 130L;
    AppMethodBeat.i(254228);
    Log.v("ChattingCompat", "ashutest: on settle %B, speed %d, resumeStatus %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), this.aenU });
    if ((!com.tencent.mm.compatible.util.d.rb(19)) || (!com.tencent.mm.compatible.h.a.aPR()))
    {
      AppMethodBeat.o(254228);
      return;
    }
    View localView = this.activity.findViewById(R.h.fMr);
    if (localView == null)
    {
      Log.e("ChattingCompat", "[onSettle] null == container");
      AppMethodBeat.o(254228);
      return;
    }
    ImageView localImageView = (ImageView)this.activity.findViewById(R.h.fTp);
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
          AppMethodBeat.o(254228);
          return;
          l = 230L;
        }
      }
      if (paramInt > 0) {}
      for (;;)
      {
        k.a(localImageView, l, localImageView.getWidth() * -1 / 4, null);
        AppMethodBeat.o(254228);
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
        AppMethodBeat.o(254228);
        return;
        l = 230L;
      }
    }
    if (paramInt > 0) {}
    for (;;)
    {
      k.a(localView, l, localView.getWidth() * -1 / 4, null);
      AppMethodBeat.o(254228);
      return;
      l = 230L;
    }
  }
  
  public final void onSwipe(float paramFloat)
  {
    AppMethodBeat.i(254237);
    Log.v("ChattingCompat", "ashutest::on swipe %f, duration %d, status %s", new Object[] { Float.valueOf(paramFloat), Long.valueOf(320L), this.aenU });
    if ((!com.tencent.mm.compatible.util.d.rb(19)) || (!com.tencent.mm.compatible.h.a.aPR()))
    {
      AppMethodBeat.o(254237);
      return;
    }
    if (this.aenP == null)
    {
      AppMethodBeat.o(254237);
      return;
    }
    if ((paramFloat == 0.0F) && (!this.aenS))
    {
      localObject1 = (ImageView)this.activity.getWindow().getDecorView().findViewById(R.h.fTp);
      if (localObject1 != null)
      {
        localObject2 = (ViewGroup)((ImageView)localObject1).getTag();
        if (localObject2 != null)
        {
          Bitmap localBitmap = getMagicDrawingCache((View)localObject2);
          if (localBitmap == null) {
            break label220;
          }
          Log.i("ChattingCompat", "[onSwipe] prepareView VISIBLE");
          ((ImageView)localObject1).setVisibility(0);
          ((ImageView)localObject1).setImageBitmap(localBitmap);
          ((ViewGroup)localObject2).setVisibility(8);
        }
      }
      if (this.aenR != null) {
        this.aenR.cancel();
      }
    }
    for (;;)
    {
      if ((a.a.aeoc == this.aenU) || (Float.compare(1.0F, paramFloat) <= 0)) {
        break label349;
      }
      Log.i("ChattingCompat", "[onSwipe] return! consumedSuperCall:%s", new Object[] { Float.valueOf(paramFloat) });
      AppMethodBeat.o(254237);
      return;
      label220:
      Log.i("ChattingCompat", "[onSwipe] prepareView GONE");
      ((ViewGroup)localObject2).setVisibility(0);
      ((ImageView)localObject1).setVisibility(8);
      ((ImageView)localObject1).setImageDrawable(null);
      break;
      if ((paramFloat == 1.0F) && (!this.aenS) && (this.aenP.isSupportNavigationSwipeBack()))
      {
        this.activity.getWindow().setBackgroundDrawableResource(R.e.fkX);
        localObject1 = (ImageView)this.activity.getWindow().getDecorView().findViewById(R.h.fTp);
        if ((localObject1 != null) && (((ImageView)localObject1).getVisibility() == 0) && (((ImageView)localObject1).getTag() != null))
        {
          ((View)((ImageView)localObject1).getTag()).setVisibility(0);
          Log.i("ChattingCompat", "[onSwipe] prepareView GONE");
          ((ImageView)localObject1).setVisibility(8);
        }
      }
    }
    label349:
    Object localObject1 = this.activity.findViewById(R.h.fMr);
    Object localObject2 = (ImageView)this.activity.findViewById(R.h.fTp);
    if ((localObject2 != null) && (((ImageView)localObject2).getVisibility() == 8) && (((ImageView)localObject2).getDrawable() != null) && (!this.aenS) && (paramFloat != 1.0F) && (paramFloat != 0.0F))
    {
      ((ImageView)localObject2).setVisibility(0);
      Log.i("ChattingCompat", "[onSwipe] !1 && !0 prepareView VISIBLE");
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
    }
    if (Float.compare(1.0F, paramFloat) <= 0)
    {
      k.r((View)localObject1, 0.0F);
      k.r((View)localObject2, 0.0F);
      AppMethodBeat.o(254237);
      return;
    }
    if ((localObject2 != null) && (((ImageView)localObject2).getDrawable() != null))
    {
      k.r((View)localObject2, ((ImageView)localObject2).getWidth() / 4 * (1.0F - paramFloat) * -1.0F);
      AppMethodBeat.o(254237);
      return;
    }
    k.r((View)localObject1, ((View)localObject1).getWidth() / 4 * (1.0F - paramFloat) * -1.0F);
    AppMethodBeat.o(254237);
  }
  
  final void tryResetChattingSwipeStatus()
  {
    boolean bool = true;
    AppMethodBeat.i(254232);
    if ((!com.tencent.mm.compatible.util.d.rb(19)) || (!com.tencent.mm.compatible.h.a.aPR()))
    {
      AppMethodBeat.o(254232);
      return;
    }
    if (this.aenP == null) {}
    for (;;)
    {
      Log.i("ChattingCompat", "ashutest: tryResetChattingSwipeStatus, chattingFragment NULL ? %B", new Object[] { Boolean.valueOf(bool) });
      if (this.aenP != null) {
        this.aenP.getSwipeBackLayout().mqz = false;
      }
      AppMethodBeat.o(254232);
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.a
 * JD-Core Version:    0.7.0.1
 */
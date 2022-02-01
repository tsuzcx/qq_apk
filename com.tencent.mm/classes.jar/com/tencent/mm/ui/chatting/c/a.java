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
import android.support.v7.app.ActionBar;
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
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.j.a.b;
import com.tencent.mm.j.a.c;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.HomeUI.FitSystemWindowLayoutView;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity.a;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.base.OnLayoutChangedLinearLayout;
import com.tencent.mm.ui.base.OnLayoutChangedLinearLayout.a;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ChattingUIFragment;
import com.tencent.mm.ui.chatting.ChattingUIProxy;
import com.tencent.mm.ui.t;
import com.tencent.mm.ui.tools.TestTimeForChatting;
import com.tencent.mm.ui.tools.TestTimeForChatting.a;
import com.tencent.mm.ui.tools.j;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.ui.widget.h.a;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

public final class a
  implements com.tencent.mm.j.a, h.a
{
  boolean OJQ;
  ChattingUIFragment Pmo;
  final ChattingUIProxy Pmp;
  Animation Pmq;
  boolean Pmr;
  String Pms;
  private a Pmt;
  HashSet<a.b> Pmu;
  a.c Pmv;
  public boolean Pmw;
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
  int statusBarColor;
  
  a(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(232971);
    this.Pmr = false;
    this.Pmt = a.PmA;
    this.mainHandler = new MMHandler(Looper.getMainLooper());
    this.Pmu = new HashSet();
    this.statusBarColor = -1;
    this.Pmw = false;
    this.startChattingRunnable = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(232959);
        a.this.statusBarColor = a.this.activity.getController().statusBarColor;
        if (!a.this.Pmr)
        {
          Log.e("ChattingCompat", "start chatting but last chatting does't be close!");
          a.this.ant();
        }
        if ((a.this.activity.isFinishing()) || (a.a(a.this)) || (!a.this.Pmr))
        {
          Log.w("ChattingCompat", "[startChattingRunnable] pass! isPause:%s mChattingClosed:%s", new Object[] { Boolean.valueOf(a.a(a.this)), Boolean.valueOf(a.this.Pmr) });
          a.this.OJQ = true;
          AppMethodBeat.o(232959);
          return;
        }
        a.this.Pmr = false;
        Object localObject = a.this.Pmu.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((a.b)((Iterator)localObject).next()).anx();
        }
        localObject = new Intent().putExtra("Chat_User", a.this.pendingUser);
        ((Intent)localObject).putExtra("Chat_Self", a.this.Pms);
        if (a.this.pendingBundle != null) {
          ((Intent)localObject).putExtras(a.this.pendingBundle);
        }
        ((Intent)localObject).putExtra("img_gallery_enter_from_chatting_ui", true);
        a.this.Pmo.getArguments().putAll(IntentUtil.getExtras((Intent)localObject));
        a.a(a.this, false);
        a.b(a.this).setOnChattingLayoutChangedListener(a.this.onChattingLayoutChangedListener);
        if (a.this.activity.getWindow().getDecorView().getWidth() == 0) {}
        for (float f = a.this.activity.getResources().getDisplayMetrics().widthPixels;; f = a.this.activity.getWindow().getDecorView().getWidth())
        {
          a.this.chattingView.setTranslationX(f - 0.1F);
          a.this.chattingView.setVisibility(0);
          com.tencent.mm.ui.widget.h.a(a.this);
          AppMethodBeat.o(232959);
          return;
        }
      }
    };
    this.onChattingLayoutChangedListener = new OnLayoutChangedLinearLayout.a()
    {
      long start = 0L;
      
      public final void gJw()
      {
        AppMethodBeat.i(232963);
        if (a.this.Pmq == null)
        {
          a.this.Pmq = AnimationUtils.loadAnimation(a.this.activity, MMFragmentActivity.a.ogm);
          a.this.Pmq.setAnimationListener(new Animation.AnimationListener()
          {
            public final void onAnimationEnd(Animation paramAnonymous2Animation)
            {
              AppMethodBeat.i(232961);
              a.this.isAnimating = false;
              Log.i("ChattingCompat", "klem animationEnd");
              paramAnonymous2Animation = a.this;
              com.tencent.f.h.RTc.n(new a.4(paramAnonymous2Animation), 60L);
              AppMethodBeat.o(232961);
            }
            
            public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
            
            public final void onAnimationStart(Animation paramAnonymous2Animation)
            {
              AppMethodBeat.i(232960);
              Log.i("ChattingCompat", "klem onAnimationStart onDrawed->onAnimationStart:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - a.3.this.start) });
              a.this.isAnimating = true;
              paramAnonymous2Animation = a.this;
              paramAnonymous2Animation.chattingView.setTranslationX(0.0F);
              paramAnonymous2Animation.chattingView.gXV();
              a.this.onSettle(false, 0);
              AppMethodBeat.o(232960);
            }
          });
        }
        a.this.chattingView.setOndispatchDraw(new TestTimeForChatting.a()
        {
          public final void gJx()
          {
            AppMethodBeat.i(232962);
            Log.i("ChattingCompat", "[onDrawed]");
            a.3.this.start = System.currentTimeMillis();
            if (a.this.Pmo == null)
            {
              Log.e("ChattingCompat", "chattingFragmet is null!");
              AppMethodBeat.o(232962);
              return;
            }
            if (a.this.Pmo.getSwipeBackLayout() != null) {
              a.this.Pmo.getSwipeBackLayout().startAnimation(a.this.Pmq);
            }
            for (;;)
            {
              a.this.chattingView.setOndispatchDraw(null);
              AppMethodBeat.o(232962);
              return;
              a.this.Pmo.getView().startAnimation(a.this.Pmq);
            }
          }
        });
        ((OnLayoutChangedLinearLayout)Objects.requireNonNull(a.b(a.this))).OWo = null;
        Log.i("ChattingCompat", "klem CHATTING ONLAYOUT ");
        AppMethodBeat.o(232963);
      }
    };
    this.activity = paramMMActivity;
    this.Pmo = new ChattingUIFragment();
    this.Pmp = new ChattingUIProxy(paramMMActivity, this.Pmo);
    AppMethodBeat.o(232971);
  }
  
  static void a(HomeUI.FitSystemWindowLayoutView paramFitSystemWindowLayoutView, Rect paramRect, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(232988);
    paramFitSystemWindowLayoutView.setActionBarContainer(paramViewGroup);
    paramFitSystemWindowLayoutView.fitSystemWindows(paramRect);
    AppMethodBeat.o(232988);
  }
  
  private ViewGroup findRootContainer()
  {
    AppMethodBeat.i(232989);
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
    AppMethodBeat.o(232989);
    return localObject1;
  }
  
  private Bitmap getMagicDrawingCache(View paramView)
  {
    AppMethodBeat.i(232987);
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
        if ((i <= 0) || (j <= 0) || (this.Pmo.getView() == null))
        {
          Log.e("ChattingCompat", "viewWidth:%s viewHeight:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          AppMethodBeat.o(232987);
          return null;
        }
        Log.i("ChattingCompat", "getBottom:%s keyboardState:%s", new Object[] { Integer.valueOf(this.Pmo.getView().getBottom()), Integer.valueOf(this.Pmo.keyboardState()) });
        if ((this.Pmo.getView().getBottom() > 0) && ((this.Pmo.keyboardState() == 1) || (this.Pmo.getView().getBottom() < this.activity.getResources().getDisplayMetrics().heightPixels * 2 / 3)))
        {
          Log.e("ChattingCompat", "hardKeyboardHidden:%s", new Object[] { Integer.valueOf(this.Pmo.keyboardState()) });
          AppMethodBeat.o(232987);
          return null;
        }
        if (this.Pmo.keyboardState() == 1)
        {
          Log.e("ChattingCompat", "hardKeyboardHidden:%s", new Object[] { Integer.valueOf(this.Pmo.keyboardState()) });
          AppMethodBeat.o(232987);
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
            int k = (int)this.activity.getResources().getDimension(2131167159);
            int m = (int)this.activity.getResources().getDimension(2131165260);
            Paint localPaint = new Paint();
            localPaint.setColor(-1);
            localCanvas.drawRect(0.0F, k, i, j - m, localPaint);
            paramView.draw(localCanvas);
            Log.i("ChattingCompat", "[getMagicDrawingCache] cost%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
            paramView = this.mPrepareBitmap;
            AppMethodBeat.o(232987);
            return paramView;
          }
          catch (OutOfMemoryError paramView)
          {
            Log.e("ChattingCompat", "[getMagicDrawingCache] e:%s", new Object[] { paramView });
            AppMethodBeat.o(232987);
            return null;
          }
          this.mPrepareBitmap.eraseColor(0);
        }
      }
    }
  }
  
  public final void a(a.b paramb)
  {
    AppMethodBeat.i(232985);
    if (paramb != null) {
      this.Pmu.add(paramb);
    }
    AppMethodBeat.o(232985);
  }
  
  public final void a(a.c paramc)
  {
    this.Pmv = paramc;
  }
  
  public final void a(String paramString1, String paramString2, a.b paramb)
  {
    AppMethodBeat.i(232973);
    a(paramb);
    this.pendingUser = paramString1;
    this.Pms = paramString2;
    this.pendingBundle = null;
    this.OJQ = false;
    this.mainHandler.removeCallbacks(this.startChattingRunnable);
    this.mainHandler.post(this.startChattingRunnable);
    AppMethodBeat.o(232973);
  }
  
  public final void ant()
  {
    boolean bool = true;
    AppMethodBeat.i(232974);
    this.Pmr = true;
    if ((this.chattingView != null) && (this.chattingView.isShown())) {}
    for (;;)
    {
      Log.i("ChattingCompat", "try closeChatting, isShown:%b", new Object[] { Boolean.valueOf(bool) });
      if ((this.Pmo != null) && (this.Pmo.isSupportNavigationSwipeBack())) {
        com.tencent.mm.ui.widget.h.b(this);
      }
      if ((this.chattingView != null) && (this.chattingView.getVisibility() != 8) && (this.Pmo != null)) {
        break;
      }
      AppMethodBeat.o(232974);
      return;
      bool = false;
    }
    Object localObject = this.Pmu.iterator();
    while (((Iterator)localObject).hasNext()) {
      if (!((a.b)((Iterator)localObject).next()).any()) {
        ((Iterator)localObject).remove();
      }
    }
    this.chattingView.setVisibility(8);
    localObject = (ImageView)this.activity.getWindow().getDecorView().findViewById(2131306100);
    if ((localObject != null) && (((ImageView)localObject).getVisibility() == 0))
    {
      ((ImageView)localObject).setVisibility(8);
      Log.i("ChattingCompat", "[closeChatting] prepareView GONE");
      if (((ImageView)localObject).getTag() != null) {
        ((View)((ImageView)localObject).getTag()).setVisibility(0);
      }
    }
    this.Pmp.onExitBegin();
    this.Pmp.onExitEnd();
    this.chattingView.setVisibility(8);
    onSwipe(1.0F);
    tryResetChattingSwipeStatus();
    this.activity.getController().setStatusBarColor(this.statusBarColor);
    AppMethodBeat.o(232974);
  }
  
  public final void anu()
  {
    AppMethodBeat.i(232975);
    this.activity.getWindow().setFormat(-2);
    com.tencent.mm.pluginsdk.h.q(this.activity);
    this.activity.customfixStatusbar(true);
    AppMethodBeat.o(232975);
  }
  
  public final void anv()
  {
    AppMethodBeat.i(232976);
    this.activity.getWindow().setBackgroundDrawableResource(2131099844);
    this.mActionBar = this.activity.getSupportActionBar();
    this.activity.initNavigationSwipeBack();
    if (this.Pmw) {
      Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
      {
        public final boolean queueIdle()
        {
          AppMethodBeat.i(232958);
          if (a.this.activity == null)
          {
            AppMethodBeat.o(232958);
            return false;
          }
          if ((a.this.activity.isDestroyed()) || (a.this.activity.isFinishing()))
          {
            AppMethodBeat.o(232958);
            return false;
          }
          a.a(a.this, true);
          AppMethodBeat.o(232958);
          return false;
        }
      });
    }
    if ((this.Pmo != null) && (this.Pmo.dom.cQp)) {
      Log.w("ChattingCompat", "[initActionBar] isChattingForeground True!");
    }
    for (;;)
    {
      this.mActionBar.show();
      com.tencent.mm.pluginsdk.h.r(this.activity);
      AppMethodBeat.o(232976);
      return;
      Log.w("ChattingCompat", "[initActionBar] isChattingForeground False!");
      View localView = aa.jQ(this.activity).inflate(2131492939, null);
      com.tencent.mm.ui.a locala = new com.tencent.mm.ui.a(localView);
      this.mActionBar.setLogo(new ColorDrawable(this.activity.getResources().getColor(17170445)));
      this.mActionBar.gt();
      this.mActionBar.setDisplayHomeAsUpEnabled(false);
      this.mActionBar.gs();
      this.mActionBar.gu();
      this.mActionBar.setCustomView(localView);
      this.activity.getController().OGj = locala.jVO;
      locala.setClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(232965);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/compat/ChattingCompat$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (!a.this.isAnimating)
          {
            a.this.mainHandler.removeCallbacks(a.this.startChattingRunnable);
            if (a.this.Pmv != null) {
              a.this.Pmv.onFinish();
            }
            a.this.activity.finish();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/compat/ChattingCompat$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(232965);
        }
      });
    }
  }
  
  public final boolean anw()
  {
    return this.Pmr;
  }
  
  public final void b(a.b paramb)
  {
    AppMethodBeat.i(232986);
    this.Pmu.remove(paramb);
    AppMethodBeat.o(232986);
  }
  
  public final void c(Boolean paramBoolean)
  {
    AppMethodBeat.i(232972);
    this.Pmw = paramBoolean.booleanValue();
    AppMethodBeat.o(232972);
  }
  
  public final boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(232984);
    Log.d("ChattingCompat", "chatting ui dispatch key event %s", new Object[] { paramKeyEvent });
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0)) {
      this.mainHandler.removeCallbacks(this.startChattingRunnable);
    }
    if (this.isAnimating)
    {
      AppMethodBeat.o(232984);
      return true;
    }
    if ((this.Pmo != null) && (this.Pmo.onKeyDown(paramKeyEvent.getKeyCode(), paramKeyEvent)))
    {
      AppMethodBeat.o(232984);
      return true;
    }
    AppMethodBeat.o(232984);
    return false;
  }
  
  public final boolean forceRemoveNoMatchOnPath()
  {
    return false;
  }
  
  public final boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(232979);
    if (((paramInt1 == 2001) || (paramInt1 == 30763) || (paramInt1 == 226) || (paramInt1 == 30762) || (paramInt1 == 1111)) && (this.Pmo != null))
    {
      this.Pmo.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(232979);
      return true;
    }
    AppMethodBeat.o(232979);
    return false;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(232978);
    if ((this.mPrepareBitmap != null) && (!this.mPrepareBitmap.isRecycled()))
    {
      Log.i("ChattingCompat", "bitmap recycle %s", new Object[] { this.mPrepareBitmap.toString() });
      this.mPrepareBitmap.recycle();
    }
    this.OJQ = false;
    this.Pmu.clear();
    this.mainHandler.removeCallbacksAndMessages(null);
    this.activity = null;
    this.Pmo = null;
    this.chattingView = null;
    this.Pmq = null;
    AppMethodBeat.o(232978);
  }
  
  public final void onPause()
  {
    this.Pmt = a.PmC;
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(232980);
    if (this.Pmo != null) {
      this.Pmo.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    }
    AppMethodBeat.o(232980);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(232977);
    this.Pmt = a.PmB;
    onSwipe(1.0F);
    if ((this.Pmo != null) && (this.Pmo.dom.cQp)) {}
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && (this.OJQ))
      {
        String str = this.pendingUser;
        Bundle localBundle = this.pendingBundle;
        this.pendingUser = str;
        this.pendingBundle = localBundle;
        this.OJQ = false;
        this.mainHandler.removeCallbacks(this.startChattingRunnable);
        this.mainHandler.post(this.startChattingRunnable);
      }
      AppMethodBeat.o(232977);
      return;
    }
  }
  
  public final void onSettle(boolean paramBoolean, int paramInt)
  {
    long l = 130L;
    AppMethodBeat.i(232981);
    Log.v("ChattingCompat", "ashutest: on settle %B, speed %d, resumeStatus %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), this.Pmt });
    if ((!d.oD(19)) || (!com.tencent.mm.compatible.h.b.apl()))
    {
      AppMethodBeat.o(232981);
      return;
    }
    View localView = this.activity.findViewById(2131303052);
    if (localView == null)
    {
      Log.e("ChattingCompat", "[onSettle] null == container");
      AppMethodBeat.o(232981);
      return;
    }
    ImageView localImageView = (ImageView)this.activity.findViewById(2131306100);
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
          j.a(localImageView, l, 0.0F, null);
          AppMethodBeat.o(232981);
          return;
          l = 230L;
        }
      }
      if (paramInt > 0) {}
      for (;;)
      {
        j.a(localImageView, l, localImageView.getWidth() * -1 / 4, null);
        AppMethodBeat.o(232981);
        return;
        l = 230L;
      }
    }
    if (paramBoolean)
    {
      if (paramInt > 0) {}
      for (;;)
      {
        j.a(localView, l, 0.0F, null);
        AppMethodBeat.o(232981);
        return;
        l = 230L;
      }
    }
    if (paramInt > 0) {}
    for (;;)
    {
      j.a(localView, l, localView.getWidth() * -1 / 4, null);
      AppMethodBeat.o(232981);
      return;
      l = 230L;
    }
  }
  
  public final void onSwipe(float paramFloat)
  {
    AppMethodBeat.i(232983);
    Log.v("ChattingCompat", "ashutest::on swipe %f, duration %d, status %s", new Object[] { Float.valueOf(paramFloat), Long.valueOf(320L), this.Pmt });
    if ((!d.oD(19)) || (!com.tencent.mm.compatible.h.b.apl()))
    {
      AppMethodBeat.o(232983);
      return;
    }
    if (this.Pmo == null)
    {
      AppMethodBeat.o(232983);
      return;
    }
    if ((paramFloat == 0.0F) && (!this.Pmr))
    {
      localObject1 = (ImageView)this.activity.getWindow().getDecorView().findViewById(2131306100);
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
      if (this.Pmq != null) {
        this.Pmq.cancel();
      }
    }
    while ((a.PmB != this.Pmt) && (Float.compare(1.0F, paramFloat) > 0))
    {
      Log.i("ChattingCompat", "[onSwipe] return! consumedSuperCall:%s", new Object[] { Float.valueOf(paramFloat) });
      AppMethodBeat.o(232983);
      return;
      if ((paramFloat == 1.0F) && (!this.Pmr) && (this.Pmo.isSupportNavigationSwipeBack()))
      {
        this.activity.getWindow().setBackgroundDrawableResource(2131101007);
        localObject1 = (ImageView)this.activity.getWindow().getDecorView().findViewById(2131306100);
        if ((localObject1 != null) && (((ImageView)localObject1).getVisibility() == 0) && (((ImageView)localObject1).getTag() != null))
        {
          ((View)((ImageView)localObject1).getTag()).setVisibility(0);
          Log.i("ChattingCompat", "[onSwipe] prepareView GONE");
          ((ImageView)localObject1).setVisibility(8);
        }
      }
    }
    Object localObject1 = this.activity.findViewById(2131303052);
    Object localObject2 = (ImageView)this.activity.findViewById(2131306100);
    if ((localObject2 != null) && (((ImageView)localObject2).getVisibility() == 8) && (((ImageView)localObject2).getDrawable() != null) && (!this.Pmr) && (paramFloat != 1.0F) && (paramFloat != 0.0F))
    {
      ((ImageView)localObject2).setVisibility(0);
      Log.i("ChattingCompat", "[onSwipe] !1 && !0 prepareView VISIBLE");
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
    }
    if (Float.compare(1.0F, paramFloat) <= 0)
    {
      j.q((View)localObject1, 0.0F);
      j.q((View)localObject2, 0.0F);
      AppMethodBeat.o(232983);
      return;
    }
    if ((localObject2 != null) && (((ImageView)localObject2).getDrawable() != null))
    {
      j.q((View)localObject2, ((ImageView)localObject2).getWidth() / 4 * (1.0F - paramFloat) * -1.0F);
      AppMethodBeat.o(232983);
      return;
    }
    j.q((View)localObject1, ((View)localObject1).getWidth() / 4 * (1.0F - paramFloat) * -1.0F);
    AppMethodBeat.o(232983);
  }
  
  final void tryResetChattingSwipeStatus()
  {
    boolean bool = true;
    AppMethodBeat.i(232982);
    if ((!d.oD(19)) || (!com.tencent.mm.compatible.h.b.apl()))
    {
      AppMethodBeat.o(232982);
      return;
    }
    if (this.Pmo == null) {}
    for (;;)
    {
      Log.i("ChattingCompat", "ashutest: tryResetChattingSwipeStatus, chattingFragment NULL ? %B", new Object[] { Boolean.valueOf(bool) });
      if (this.Pmo != null) {
        this.Pmo.getSwipeBackLayout().hfx = false;
      }
      AppMethodBeat.o(232982);
      return;
      bool = false;
    }
  }
  
  static enum a
  {
    static
    {
      AppMethodBeat.i(232970);
      PmA = new a("ACTIVITY_CREATE", 0);
      PmB = new a("ACTIVITY_RESUME", 1);
      PmC = new a("ACTIVITY_PAUSE", 2);
      PmD = new a[] { PmA, PmB, PmC };
      AppMethodBeat.o(232970);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.a
 * JD-Core Version:    0.7.0.1
 */
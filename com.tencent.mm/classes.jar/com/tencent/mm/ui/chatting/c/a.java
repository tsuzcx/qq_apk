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
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.j.a.b;
import com.tencent.mm.j.a.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.HomeUI.FitSystemWindowLayoutView;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity.a;
import com.tencent.mm.ui.base.OnLayoutChangedLinearLayout;
import com.tencent.mm.ui.base.OnLayoutChangedLinearLayout.a;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ChattingUIFragment;
import com.tencent.mm.ui.chatting.ChattingUIProxy;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.tools.TestTimeForChatting;
import com.tencent.mm.ui.tools.TestTimeForChatting.a;
import com.tencent.mm.ui.tools.j;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.ui.widget.h.a;
import com.tencent.mm.ui.z;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

public final class a
  implements com.tencent.mm.j.a, h.a
{
  ChattingUIFragment JGb;
  final ChattingUIProxy JGc;
  Animation JGd;
  boolean JGe;
  String JGf;
  private a.a JGg;
  HashSet<a.b> JGh;
  a.c JGi;
  public boolean JGj;
  boolean JeJ;
  MMActivity activity;
  private int chattingID;
  TestTimeForChatting chattingView;
  ap hUx;
  boolean isAnimating;
  ActionBar mActionBar;
  private Bitmap mPrepareBitmap;
  OnLayoutChangedLinearLayout.a onChattingLayoutChangedListener;
  Bundle pendingBundle;
  String pendingUser;
  Runnable startChattingRunnable;
  int statusBarColor;
  
  a(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(193905);
    this.JGe = false;
    this.JGg = a.a.JGn;
    this.hUx = new ap(Looper.getMainLooper());
    this.JGh = new HashSet();
    this.statusBarColor = -1;
    this.JGj = false;
    this.startChattingRunnable = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(193893);
        a.this.statusBarColor = a.this.activity.getController().statusBarColor;
        if (!a.this.JGe)
        {
          ad.e("ChattingCompat", "start chatting but last chatting does't be close!");
          a.this.Zx();
        }
        if ((a.this.activity.isFinishing()) || (a.a(a.this)) || (!a.this.JGe))
        {
          ad.w("ChattingCompat", "[startChattingRunnable] pass! isPause:%s mChattingClosed:%s", new Object[] { Boolean.valueOf(a.a(a.this)), Boolean.valueOf(a.this.JGe) });
          a.this.JeJ = true;
          AppMethodBeat.o(193893);
          return;
        }
        a.this.JGe = false;
        Object localObject = a.this.JGh.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((a.b)((Iterator)localObject).next()).ZB();
        }
        localObject = new Intent().putExtra("Chat_User", a.this.pendingUser);
        ((Intent)localObject).putExtra("Chat_Self", a.this.JGf);
        if (a.this.pendingBundle != null) {
          ((Intent)localObject).putExtras(a.this.pendingBundle);
        }
        ((Intent)localObject).putExtra("img_gallery_enter_from_chatting_ui", true);
        a.this.JGb.getArguments().putAll(y.bk((Intent)localObject));
        a.a(a.this, false);
        a.b(a.this).setOnChattingLayoutChangedListener(a.this.onChattingLayoutChangedListener);
        if (a.this.activity.getWindow().getDecorView().getWidth() == 0) {}
        for (float f = a.this.activity.getResources().getDisplayMetrics().widthPixels;; f = a.this.activity.getWindow().getDecorView().getWidth())
        {
          a.this.chattingView.setTranslationX(f - 0.1F);
          a.this.chattingView.setVisibility(0);
          com.tencent.mm.ui.widget.h.a(a.this);
          AppMethodBeat.o(193893);
          return;
        }
      }
    };
    this.onChattingLayoutChangedListener = new OnLayoutChangedLinearLayout.a()
    {
      long start = 0L;
      
      public final void fxA()
      {
        AppMethodBeat.i(193897);
        if (a.this.JGd == null)
        {
          a.this.JGd = AnimationUtils.loadAnimation(a.this.activity, MMFragmentActivity.a.mOe);
          a.this.JGd.setAnimationListener(new Animation.AnimationListener()
          {
            public final void onAnimationEnd(Animation paramAnonymous2Animation)
            {
              AppMethodBeat.i(193895);
              a.this.isAnimating = false;
              ad.i("ChattingCompat", "klem animationEnd");
              paramAnonymous2Animation = a.this;
              com.tencent.e.h.LTJ.q(new a.4(paramAnonymous2Animation), 60L);
              AppMethodBeat.o(193895);
            }
            
            public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
            
            public final void onAnimationStart(Animation paramAnonymous2Animation)
            {
              AppMethodBeat.i(193894);
              ad.i("ChattingCompat", "klem onAnimationStart onDrawed->onAnimationStart:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - a.3.this.start) });
              a.this.isAnimating = true;
              paramAnonymous2Animation = a.this;
              paramAnonymous2Animation.chattingView.setTranslationX(0.0F);
              paramAnonymous2Animation.chattingView.fKK();
              a.this.onSettle(false, 0);
              AppMethodBeat.o(193894);
            }
          });
        }
        a.this.chattingView.setOndispatchDraw(new TestTimeForChatting.a()
        {
          public final void fxB()
          {
            AppMethodBeat.i(193896);
            ad.i("ChattingCompat", "[onDrawed]");
            a.3.this.start = System.currentTimeMillis();
            if (a.this.JGb == null)
            {
              ad.e("ChattingCompat", "chattingFragmet is null!");
              AppMethodBeat.o(193896);
              return;
            }
            if (a.this.JGb.getSwipeBackLayout() != null) {
              a.this.JGb.getSwipeBackLayout().startAnimation(a.this.JGd);
            }
            for (;;)
            {
              a.this.chattingView.setOndispatchDraw(null);
              AppMethodBeat.o(193896);
              return;
              a.this.JGb.getView().startAnimation(a.this.JGd);
            }
          }
        });
        ((OnLayoutChangedLinearLayout)Objects.requireNonNull(a.b(a.this))).JqD = null;
        ad.i("ChattingCompat", "klem CHATTING ONLAYOUT ");
        AppMethodBeat.o(193897);
      }
    };
    this.activity = paramMMActivity;
    this.JGb = new ChattingUIFragment();
    this.JGc = new ChattingUIProxy(paramMMActivity, this.JGb);
    AppMethodBeat.o(193905);
  }
  
  static void a(HomeUI.FitSystemWindowLayoutView paramFitSystemWindowLayoutView, Rect paramRect, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(193922);
    paramFitSystemWindowLayoutView.setActionBarContainer(paramViewGroup);
    paramFitSystemWindowLayoutView.fitSystemWindows(paramRect);
    AppMethodBeat.o(193922);
  }
  
  private ViewGroup findRootContainer()
  {
    AppMethodBeat.i(193923);
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
    AppMethodBeat.o(193923);
    return localObject1;
  }
  
  private Bitmap getMagicDrawingCache(View paramView)
  {
    AppMethodBeat.i(193921);
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
        if ((i <= 0) || (j <= 0) || (this.JGb.getView() == null))
        {
          ad.e("ChattingCompat", "viewWidth:%s viewHeight:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          AppMethodBeat.o(193921);
          return null;
        }
        ad.i("ChattingCompat", "getBottom:%s keyboardState:%s", new Object[] { Integer.valueOf(this.JGb.getView().getBottom()), Integer.valueOf(this.JGb.keyboardState()) });
        if ((this.JGb.getView().getBottom() > 0) && ((this.JGb.keyboardState() == 1) || (this.JGb.getView().getBottom() < this.activity.getResources().getDisplayMetrics().heightPixels * 2 / 3)))
        {
          ad.e("ChattingCompat", "hardKeyboardHidden:%s", new Object[] { Integer.valueOf(this.JGb.keyboardState()) });
          AppMethodBeat.o(193921);
          return null;
        }
        if (this.JGb.keyboardState() == 1)
        {
          ad.e("ChattingCompat", "hardKeyboardHidden:%s", new Object[] { Integer.valueOf(this.JGb.keyboardState()) });
          AppMethodBeat.o(193921);
          return null;
        }
        if ((this.mPrepareBitmap == null) || (this.mPrepareBitmap.isRecycled()) || (this.mPrepareBitmap.getWidth() != i) || (this.mPrepareBitmap.getHeight() != j)) {
          if ((this.mPrepareBitmap != null) && (!this.mPrepareBitmap.isRecycled()))
          {
            ad.i("ChattingCompat", "bitmap recycle %s", new Object[] { this.mPrepareBitmap.toString() });
            this.mPrepareBitmap.recycle();
          }
        }
        for (;;)
        {
          try
          {
            this.mPrepareBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_4444);
            Canvas localCanvas = new Canvas(this.mPrepareBitmap);
            int k = (int)this.activity.getResources().getDimension(2131167019);
            int m = (int)this.activity.getResources().getDimension(2131165256);
            Paint localPaint = new Paint();
            localPaint.setColor(-1);
            localCanvas.drawRect(0.0F, k, i, j - m, localPaint);
            paramView.draw(localCanvas);
            ad.i("ChattingCompat", "[getMagicDrawingCache] cost%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
            paramView = this.mPrepareBitmap;
            AppMethodBeat.o(193921);
            return paramView;
          }
          catch (OutOfMemoryError paramView)
          {
            ad.e("ChattingCompat", "[getMagicDrawingCache] e:%s", new Object[] { paramView });
            AppMethodBeat.o(193921);
            return null;
          }
          this.mPrepareBitmap.eraseColor(0);
        }
      }
    }
  }
  
  public final boolean ZA()
  {
    return this.JGe;
  }
  
  public final void Zx()
  {
    boolean bool = true;
    AppMethodBeat.i(193908);
    this.JGe = true;
    if ((this.chattingView != null) && (this.chattingView.isShown())) {}
    for (;;)
    {
      ad.i("ChattingCompat", "try closeChatting, isShown:%b", new Object[] { Boolean.valueOf(bool) });
      if ((this.JGb != null) && (this.JGb.isSupportNavigationSwipeBack())) {
        com.tencent.mm.ui.widget.h.b(this);
      }
      if ((this.chattingView != null) && (this.chattingView.getVisibility() != 8) && (this.JGb != null)) {
        break;
      }
      AppMethodBeat.o(193908);
      return;
      bool = false;
    }
    Object localObject = this.JGh.iterator();
    while (((Iterator)localObject).hasNext()) {
      if (!((a.b)((Iterator)localObject).next()).ZC()) {
        ((Iterator)localObject).remove();
      }
    }
    this.chattingView.setVisibility(8);
    localObject = (ImageView)this.activity.getWindow().getDecorView().findViewById(2131303386);
    if ((localObject != null) && (((ImageView)localObject).getVisibility() == 0))
    {
      ((ImageView)localObject).setVisibility(8);
      ad.i("ChattingCompat", "[closeChatting] prepareView GONE");
      if (((ImageView)localObject).getTag() != null) {
        ((View)((ImageView)localObject).getTag()).setVisibility(0);
      }
    }
    this.JGc.onExitBegin();
    this.JGc.onExitEnd();
    this.chattingView.setVisibility(8);
    onSwipe(1.0F);
    tryResetChattingSwipeStatus();
    this.activity.getController().setStatusBarColor(this.statusBarColor);
    AppMethodBeat.o(193908);
  }
  
  public final void Zy()
  {
    AppMethodBeat.i(193909);
    this.activity.getWindow().setFormat(-2);
    com.tencent.mm.pluginsdk.h.q(this.activity);
    this.activity.customfixStatusbar(true);
    AppMethodBeat.o(193909);
  }
  
  public final void Zz()
  {
    AppMethodBeat.i(193910);
    this.activity.getWindow().setBackgroundDrawableResource(2131099828);
    this.mActionBar = this.activity.getSupportActionBar();
    this.activity.initNavigationSwipeBack();
    if (this.JGj) {
      Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
      {
        public final boolean queueIdle()
        {
          AppMethodBeat.i(193892);
          if (a.this.activity == null)
          {
            AppMethodBeat.o(193892);
            return false;
          }
          if ((a.this.activity.isDestroyed()) || (a.this.activity.isFinishing()))
          {
            AppMethodBeat.o(193892);
            return false;
          }
          a.a(a.this, true);
          AppMethodBeat.o(193892);
          return false;
        }
      });
    }
    if ((this.JGb != null) && (this.JGb.cWM.cBJ)) {
      ad.w("ChattingCompat", "[initActionBar] isChattingForeground True!");
    }
    for (;;)
    {
      this.mActionBar.show();
      com.tencent.mm.pluginsdk.h.r(this.activity);
      AppMethodBeat.o(193910);
      return;
      ad.w("ChattingCompat", "[initActionBar] isChattingForeground False!");
      View localView = z.jO(this.activity).inflate(2131492921, null);
      com.tencent.mm.ui.a locala = new com.tencent.mm.ui.a(localView);
      this.mActionBar.setLogo(new ColorDrawable(this.activity.getResources().getColor(17170445)));
      this.mActionBar.gm();
      this.mActionBar.setDisplayHomeAsUpEnabled(false);
      this.mActionBar.gl();
      this.mActionBar.gn();
      this.mActionBar.setCustomView(localView);
      this.activity.getController().Jbi = locala.iVq;
      locala.setClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(193899);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/compat/ChattingCompat$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          if (!a.this.isAnimating)
          {
            a.this.hUx.removeCallbacks(a.this.startChattingRunnable);
            if (a.this.JGi != null) {
              a.this.JGi.onFinish();
            }
            a.this.activity.finish();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/compat/ChattingCompat$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(193899);
        }
      });
    }
  }
  
  public final void a(a.b paramb)
  {
    AppMethodBeat.i(193919);
    if (paramb != null) {
      this.JGh.add(paramb);
    }
    AppMethodBeat.o(193919);
  }
  
  public final void a(a.c paramc)
  {
    this.JGi = paramc;
  }
  
  public final void a(String paramString1, String paramString2, a.b paramb)
  {
    AppMethodBeat.i(193907);
    a(paramb);
    this.pendingUser = paramString1;
    this.JGf = paramString2;
    this.pendingBundle = null;
    this.JeJ = false;
    this.hUx.removeCallbacks(this.startChattingRunnable);
    this.hUx.post(this.startChattingRunnable);
    AppMethodBeat.o(193907);
  }
  
  public final void b(a.b paramb)
  {
    AppMethodBeat.i(193920);
    this.JGh.remove(paramb);
    AppMethodBeat.o(193920);
  }
  
  public final void d(Boolean paramBoolean)
  {
    AppMethodBeat.i(193906);
    this.JGj = paramBoolean.booleanValue();
    AppMethodBeat.o(193906);
  }
  
  public final boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(193918);
    ad.d("ChattingCompat", "chatting ui dispatch key event %s", new Object[] { paramKeyEvent });
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0)) {
      this.hUx.removeCallbacks(this.startChattingRunnable);
    }
    if (this.isAnimating)
    {
      AppMethodBeat.o(193918);
      return true;
    }
    if ((this.JGb != null) && (this.JGb.onKeyDown(paramKeyEvent.getKeyCode(), paramKeyEvent)))
    {
      AppMethodBeat.o(193918);
      return true;
    }
    AppMethodBeat.o(193918);
    return false;
  }
  
  public final boolean forceRemoveNoMatchOnPath()
  {
    return false;
  }
  
  public final boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(193913);
    if (((paramInt1 == 2001) || (paramInt1 == 30763) || (paramInt1 == 226) || (paramInt1 == 30762) || (paramInt1 == 1111)) && (this.JGb != null))
    {
      this.JGb.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(193913);
      return true;
    }
    AppMethodBeat.o(193913);
    return false;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(193912);
    if ((this.mPrepareBitmap != null) && (!this.mPrepareBitmap.isRecycled()))
    {
      ad.i("ChattingCompat", "bitmap recycle %s", new Object[] { this.mPrepareBitmap.toString() });
      this.mPrepareBitmap.recycle();
    }
    this.JeJ = false;
    this.JGh.clear();
    this.hUx.removeCallbacksAndMessages(null);
    this.activity = null;
    this.JGb = null;
    this.chattingView = null;
    this.JGd = null;
    AppMethodBeat.o(193912);
  }
  
  public final void onPause()
  {
    this.JGg = a.a.JGp;
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(193914);
    if (this.JGb != null) {
      this.JGb.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    }
    AppMethodBeat.o(193914);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(193911);
    this.JGg = a.a.JGo;
    onSwipe(1.0F);
    if ((this.JGb != null) && (this.JGb.cWM.cBJ)) {}
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && (this.JeJ))
      {
        String str = this.pendingUser;
        Bundle localBundle = this.pendingBundle;
        this.pendingUser = str;
        this.pendingBundle = localBundle;
        this.JeJ = false;
        this.hUx.removeCallbacks(this.startChattingRunnable);
        this.hUx.post(this.startChattingRunnable);
      }
      AppMethodBeat.o(193911);
      return;
    }
  }
  
  public final void onSettle(boolean paramBoolean, int paramInt)
  {
    long l = 130L;
    AppMethodBeat.i(193915);
    ad.v("ChattingCompat", "ashutest: on settle %B, speed %d, resumeStatus %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), this.JGg });
    if ((!d.ly(19)) || (!com.tencent.mm.compatible.g.b.abd()))
    {
      AppMethodBeat.o(193915);
      return;
    }
    View localView = this.activity.findViewById(2131301337);
    if (localView == null)
    {
      ad.e("ChattingCompat", "[onSettle] null == container");
      AppMethodBeat.o(193915);
      return;
    }
    ImageView localImageView = (ImageView)this.activity.findViewById(2131303386);
    if ((localImageView != null) && (localImageView.getVisibility() == 8) && (localImageView.getDrawable() != null))
    {
      localImageView.setVisibility(0);
      ad.i("ChattingCompat", "[onSettle] prepareView VISIBLE");
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
          AppMethodBeat.o(193915);
          return;
          l = 230L;
        }
      }
      if (paramInt > 0) {}
      for (;;)
      {
        j.a(localImageView, l, localImageView.getWidth() * -1 / 4, null);
        AppMethodBeat.o(193915);
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
        AppMethodBeat.o(193915);
        return;
        l = 230L;
      }
    }
    if (paramInt > 0) {}
    for (;;)
    {
      j.a(localView, l, localView.getWidth() * -1 / 4, null);
      AppMethodBeat.o(193915);
      return;
      l = 230L;
    }
  }
  
  public final void onSwipe(float paramFloat)
  {
    AppMethodBeat.i(193917);
    ad.v("ChattingCompat", "ashutest::on swipe %f, duration %d, status %s", new Object[] { Float.valueOf(paramFloat), Long.valueOf(320L), this.JGg });
    if ((!d.ly(19)) || (!com.tencent.mm.compatible.g.b.abd()))
    {
      AppMethodBeat.o(193917);
      return;
    }
    if (this.JGb == null)
    {
      AppMethodBeat.o(193917);
      return;
    }
    if ((paramFloat == 0.0F) && (!this.JGe))
    {
      localObject1 = (ImageView)this.activity.getWindow().getDecorView().findViewById(2131303386);
      if (localObject1 != null)
      {
        localObject2 = (ViewGroup)((ImageView)localObject1).getTag();
        if (localObject2 != null)
        {
          ad.i("ChattingCompat", "[onSwipe] prepareView GONE");
          ((ViewGroup)localObject2).setVisibility(0);
          ((ImageView)localObject1).setVisibility(8);
          ((ImageView)localObject1).setImageDrawable(null);
        }
      }
      if (this.JGd != null) {
        this.JGd.cancel();
      }
    }
    while ((a.a.JGo != this.JGg) && (Float.compare(1.0F, paramFloat) > 0))
    {
      ad.i("ChattingCompat", "[onSwipe] return! consumedSuperCall:%s", new Object[] { Float.valueOf(paramFloat) });
      AppMethodBeat.o(193917);
      return;
      if ((paramFloat == 1.0F) && (!this.JGe) && (this.JGb.isSupportNavigationSwipeBack()))
      {
        this.activity.getWindow().setBackgroundDrawableResource(2131100810);
        localObject1 = (ImageView)this.activity.getWindow().getDecorView().findViewById(2131303386);
        if ((localObject1 != null) && (((ImageView)localObject1).getVisibility() == 0) && (((ImageView)localObject1).getTag() != null))
        {
          ((View)((ImageView)localObject1).getTag()).setVisibility(0);
          ad.i("ChattingCompat", "[onSwipe] prepareView GONE");
          ((ImageView)localObject1).setVisibility(8);
        }
      }
    }
    Object localObject1 = this.activity.findViewById(2131301337);
    Object localObject2 = (ImageView)this.activity.findViewById(2131303386);
    if ((localObject2 != null) && (((ImageView)localObject2).getVisibility() == 8) && (((ImageView)localObject2).getDrawable() != null) && (!this.JGe) && (paramFloat != 1.0F) && (paramFloat != 0.0F))
    {
      ((ImageView)localObject2).setVisibility(0);
      ad.i("ChattingCompat", "[onSwipe] !1 && !0 prepareView VISIBLE");
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
    }
    if (Float.compare(1.0F, paramFloat) <= 0)
    {
      j.y((View)localObject1, 0.0F);
      j.y((View)localObject2, 0.0F);
      AppMethodBeat.o(193917);
      return;
    }
    if ((localObject2 != null) && (((ImageView)localObject2).getDrawable() != null))
    {
      j.y((View)localObject2, ((ImageView)localObject2).getWidth() / 4 * (1.0F - paramFloat) * -1.0F);
      AppMethodBeat.o(193917);
      return;
    }
    j.y((View)localObject1, ((View)localObject1).getWidth() / 4 * (1.0F - paramFloat) * -1.0F);
    AppMethodBeat.o(193917);
  }
  
  final void tryResetChattingSwipeStatus()
  {
    boolean bool = true;
    AppMethodBeat.i(193916);
    if ((!d.ly(19)) || (!com.tencent.mm.compatible.g.b.abd()))
    {
      AppMethodBeat.o(193916);
      return;
    }
    if (this.JGb == null) {}
    for (;;)
    {
      ad.i("ChattingCompat", "ashutest: tryResetChattingSwipeStatus, chattingFragment NULL ? %B", new Object[] { Boolean.valueOf(bool) });
      if (this.JGb != null) {
        this.JGb.getSwipeBackLayout().KTC = false;
      }
      AppMethodBeat.o(193916);
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.a
 * JD-Core Version:    0.7.0.1
 */
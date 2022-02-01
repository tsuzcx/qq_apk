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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
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
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

public final class a
  implements com.tencent.mm.j.a, h.a
{
  boolean Jzu;
  ChattingUIFragment KaS;
  final ChattingUIProxy KaT;
  Animation KaU;
  boolean KaV;
  String KaW;
  private a KaX;
  HashSet<a.b> KaY;
  a.c KaZ;
  public boolean Kba;
  MMActivity activity;
  private int chattingID;
  TestTimeForChatting chattingView;
  aq hXp;
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
    AppMethodBeat.i(187212);
    this.KaV = false;
    this.KaX = a.Kbe;
    this.hXp = new aq(Looper.getMainLooper());
    this.KaY = new HashSet();
    this.statusBarColor = -1;
    this.Kba = false;
    this.startChattingRunnable = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(187200);
        a.this.statusBarColor = a.this.activity.getController().statusBarColor;
        if (!a.this.KaV)
        {
          ae.e("ChattingCompat", "start chatting but last chatting does't be close!");
          a.this.ZG();
        }
        if ((a.this.activity.isFinishing()) || (a.a(a.this)) || (!a.this.KaV))
        {
          ae.w("ChattingCompat", "[startChattingRunnable] pass! isPause:%s mChattingClosed:%s", new Object[] { Boolean.valueOf(a.a(a.this)), Boolean.valueOf(a.this.KaV) });
          a.this.Jzu = true;
          AppMethodBeat.o(187200);
          return;
        }
        a.this.KaV = false;
        Object localObject = a.this.KaY.iterator();
        while (((Iterator)localObject).hasNext()) {
          ((a.b)((Iterator)localObject).next()).ZK();
        }
        localObject = new Intent().putExtra("Chat_User", a.this.pendingUser);
        ((Intent)localObject).putExtra("Chat_Self", a.this.KaW);
        if (a.this.pendingBundle != null) {
          ((Intent)localObject).putExtras(a.this.pendingBundle);
        }
        ((Intent)localObject).putExtra("img_gallery_enter_from_chatting_ui", true);
        a.this.KaS.getArguments().putAll(com.tencent.mm.sdk.platformtools.z.bl((Intent)localObject));
        a.a(a.this, false);
        a.b(a.this).setOnChattingLayoutChangedListener(a.this.onChattingLayoutChangedListener);
        if (a.this.activity.getWindow().getDecorView().getWidth() == 0) {}
        for (float f = a.this.activity.getResources().getDisplayMetrics().widthPixels;; f = a.this.activity.getWindow().getDecorView().getWidth())
        {
          a.this.chattingView.setTranslationX(f - 0.1F);
          a.this.chattingView.setVisibility(0);
          com.tencent.mm.ui.widget.h.a(a.this);
          AppMethodBeat.o(187200);
          return;
        }
      }
    };
    this.onChattingLayoutChangedListener = new OnLayoutChangedLinearLayout.a()
    {
      long start = 0L;
      
      public final void fBC()
      {
        AppMethodBeat.i(187204);
        if (a.this.KaU == null)
        {
          a.this.KaU = AnimationUtils.loadAnimation(a.this.activity, MMFragmentActivity.a.mTi);
          a.this.KaU.setAnimationListener(new Animation.AnimationListener()
          {
            public final void onAnimationEnd(Animation paramAnonymous2Animation)
            {
              AppMethodBeat.i(187202);
              a.this.isAnimating = false;
              ae.i("ChattingCompat", "klem animationEnd");
              paramAnonymous2Animation = a.this;
              com.tencent.e.h.MqF.q(new a.4(paramAnonymous2Animation), 60L);
              AppMethodBeat.o(187202);
            }
            
            public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
            
            public final void onAnimationStart(Animation paramAnonymous2Animation)
            {
              AppMethodBeat.i(187201);
              ae.i("ChattingCompat", "klem onAnimationStart onDrawed->onAnimationStart:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - a.3.this.start) });
              a.this.isAnimating = true;
              paramAnonymous2Animation = a.this;
              paramAnonymous2Animation.chattingView.setTranslationX(0.0F);
              paramAnonymous2Animation.chattingView.fPb();
              a.this.onSettle(false, 0);
              AppMethodBeat.o(187201);
            }
          });
        }
        a.this.chattingView.setOndispatchDraw(new TestTimeForChatting.a()
        {
          public final void fBD()
          {
            AppMethodBeat.i(187203);
            ae.i("ChattingCompat", "[onDrawed]");
            a.3.this.start = System.currentTimeMillis();
            if (a.this.KaS == null)
            {
              ae.e("ChattingCompat", "chattingFragmet is null!");
              AppMethodBeat.o(187203);
              return;
            }
            if (a.this.KaS.getSwipeBackLayout() != null) {
              a.this.KaS.getSwipeBackLayout().startAnimation(a.this.KaU);
            }
            for (;;)
            {
              a.this.chattingView.setOndispatchDraw(null);
              AppMethodBeat.o(187203);
              return;
              a.this.KaS.getView().startAnimation(a.this.KaU);
            }
          }
        });
        ((OnLayoutChangedLinearLayout)Objects.requireNonNull(a.b(a.this))).JLs = null;
        ae.i("ChattingCompat", "klem CHATTING ONLAYOUT ");
        AppMethodBeat.o(187204);
      }
    };
    this.activity = paramMMActivity;
    this.KaS = new ChattingUIFragment();
    this.KaT = new ChattingUIProxy(paramMMActivity, this.KaS);
    AppMethodBeat.o(187212);
  }
  
  static void a(HomeUI.FitSystemWindowLayoutView paramFitSystemWindowLayoutView, Rect paramRect, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(187229);
    paramFitSystemWindowLayoutView.setActionBarContainer(paramViewGroup);
    paramFitSystemWindowLayoutView.fitSystemWindows(paramRect);
    AppMethodBeat.o(187229);
  }
  
  private ViewGroup findRootContainer()
  {
    AppMethodBeat.i(187230);
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
    AppMethodBeat.o(187230);
    return localObject1;
  }
  
  private Bitmap getMagicDrawingCache(View paramView)
  {
    AppMethodBeat.i(187228);
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
        if ((i <= 0) || (j <= 0) || (this.KaS.getView() == null))
        {
          ae.e("ChattingCompat", "viewWidth:%s viewHeight:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          AppMethodBeat.o(187228);
          return null;
        }
        ae.i("ChattingCompat", "getBottom:%s keyboardState:%s", new Object[] { Integer.valueOf(this.KaS.getView().getBottom()), Integer.valueOf(this.KaS.keyboardState()) });
        if ((this.KaS.getView().getBottom() > 0) && ((this.KaS.keyboardState() == 1) || (this.KaS.getView().getBottom() < this.activity.getResources().getDisplayMetrics().heightPixels * 2 / 3)))
        {
          ae.e("ChattingCompat", "hardKeyboardHidden:%s", new Object[] { Integer.valueOf(this.KaS.keyboardState()) });
          AppMethodBeat.o(187228);
          return null;
        }
        if (this.KaS.keyboardState() == 1)
        {
          ae.e("ChattingCompat", "hardKeyboardHidden:%s", new Object[] { Integer.valueOf(this.KaS.keyboardState()) });
          AppMethodBeat.o(187228);
          return null;
        }
        if ((this.mPrepareBitmap == null) || (this.mPrepareBitmap.isRecycled()) || (this.mPrepareBitmap.getWidth() != i) || (this.mPrepareBitmap.getHeight() != j)) {
          if ((this.mPrepareBitmap != null) && (!this.mPrepareBitmap.isRecycled()))
          {
            ae.i("ChattingCompat", "bitmap recycle %s", new Object[] { this.mPrepareBitmap.toString() });
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
            ae.i("ChattingCompat", "[getMagicDrawingCache] cost%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
            paramView = this.mPrepareBitmap;
            AppMethodBeat.o(187228);
            return paramView;
          }
          catch (OutOfMemoryError paramView)
          {
            ae.e("ChattingCompat", "[getMagicDrawingCache] e:%s", new Object[] { paramView });
            AppMethodBeat.o(187228);
            return null;
          }
          this.mPrepareBitmap.eraseColor(0);
        }
      }
    }
  }
  
  public final void ZG()
  {
    boolean bool = true;
    AppMethodBeat.i(187215);
    this.KaV = true;
    if ((this.chattingView != null) && (this.chattingView.isShown())) {}
    for (;;)
    {
      ae.i("ChattingCompat", "try closeChatting, isShown:%b", new Object[] { Boolean.valueOf(bool) });
      if ((this.KaS != null) && (this.KaS.isSupportNavigationSwipeBack())) {
        com.tencent.mm.ui.widget.h.b(this);
      }
      if ((this.chattingView != null) && (this.chattingView.getVisibility() != 8) && (this.KaS != null)) {
        break;
      }
      AppMethodBeat.o(187215);
      return;
      bool = false;
    }
    Object localObject = this.KaY.iterator();
    while (((Iterator)localObject).hasNext()) {
      if (!((a.b)((Iterator)localObject).next()).ZL()) {
        ((Iterator)localObject).remove();
      }
    }
    this.chattingView.setVisibility(8);
    localObject = (ImageView)this.activity.getWindow().getDecorView().findViewById(2131303386);
    if ((localObject != null) && (((ImageView)localObject).getVisibility() == 0))
    {
      ((ImageView)localObject).setVisibility(8);
      ae.i("ChattingCompat", "[closeChatting] prepareView GONE");
      if (((ImageView)localObject).getTag() != null) {
        ((View)((ImageView)localObject).getTag()).setVisibility(0);
      }
    }
    this.KaT.onExitBegin();
    this.KaT.onExitEnd();
    this.chattingView.setVisibility(8);
    onSwipe(1.0F);
    tryResetChattingSwipeStatus();
    this.activity.getController().setStatusBarColor(this.statusBarColor);
    AppMethodBeat.o(187215);
  }
  
  public final void ZH()
  {
    AppMethodBeat.i(187216);
    this.activity.getWindow().setFormat(-2);
    com.tencent.mm.pluginsdk.h.q(this.activity);
    this.activity.customfixStatusbar(true);
    AppMethodBeat.o(187216);
  }
  
  public final void ZI()
  {
    AppMethodBeat.i(187217);
    this.activity.getWindow().setBackgroundDrawableResource(2131099828);
    this.mActionBar = this.activity.getSupportActionBar();
    this.activity.initNavigationSwipeBack();
    if (this.Kba) {
      Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
      {
        public final boolean queueIdle()
        {
          AppMethodBeat.i(187199);
          if (a.this.activity == null)
          {
            AppMethodBeat.o(187199);
            return false;
          }
          if ((a.this.activity.isDestroyed()) || (a.this.activity.isFinishing()))
          {
            AppMethodBeat.o(187199);
            return false;
          }
          a.a(a.this, true);
          AppMethodBeat.o(187199);
          return false;
        }
      });
    }
    if ((this.KaS != null) && (this.KaS.cXJ.cCq)) {
      ae.w("ChattingCompat", "[initActionBar] isChattingForeground True!");
    }
    for (;;)
    {
      this.mActionBar.show();
      com.tencent.mm.pluginsdk.h.r(this.activity);
      AppMethodBeat.o(187217);
      return;
      ae.w("ChattingCompat", "[initActionBar] isChattingForeground False!");
      View localView = com.tencent.mm.ui.z.jV(this.activity).inflate(2131492921, null);
      com.tencent.mm.ui.a locala = new com.tencent.mm.ui.a(localView);
      this.mActionBar.setLogo(new ColorDrawable(this.activity.getResources().getColor(17170445)));
      this.mActionBar.gm();
      this.mActionBar.setDisplayHomeAsUpEnabled(false);
      this.mActionBar.gl();
      this.mActionBar.gn();
      this.mActionBar.setCustomView(localView);
      this.activity.getController().JvQ = locala.iYj;
      locala.setClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(187206);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/compat/ChattingCompat$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if (!a.this.isAnimating)
          {
            a.this.hXp.removeCallbacks(a.this.startChattingRunnable);
            if (a.this.KaZ != null) {
              a.this.KaZ.onFinish();
            }
            a.this.activity.finish();
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/compat/ChattingCompat$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(187206);
        }
      });
    }
  }
  
  public final boolean ZJ()
  {
    return this.KaV;
  }
  
  public final void a(a.b paramb)
  {
    AppMethodBeat.i(187226);
    if (paramb != null) {
      this.KaY.add(paramb);
    }
    AppMethodBeat.o(187226);
  }
  
  public final void a(a.c paramc)
  {
    this.KaZ = paramc;
  }
  
  public final void a(String paramString1, String paramString2, a.b paramb)
  {
    AppMethodBeat.i(187214);
    a(paramb);
    this.pendingUser = paramString1;
    this.KaW = paramString2;
    this.pendingBundle = null;
    this.Jzu = false;
    this.hXp.removeCallbacks(this.startChattingRunnable);
    this.hXp.post(this.startChattingRunnable);
    AppMethodBeat.o(187214);
  }
  
  public final void b(a.b paramb)
  {
    AppMethodBeat.i(187227);
    this.KaY.remove(paramb);
    AppMethodBeat.o(187227);
  }
  
  public final void d(Boolean paramBoolean)
  {
    AppMethodBeat.i(187213);
    this.Kba = paramBoolean.booleanValue();
    AppMethodBeat.o(187213);
  }
  
  public final boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(187225);
    ae.d("ChattingCompat", "chatting ui dispatch key event %s", new Object[] { paramKeyEvent });
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0)) {
      this.hXp.removeCallbacks(this.startChattingRunnable);
    }
    if (this.isAnimating)
    {
      AppMethodBeat.o(187225);
      return true;
    }
    if ((this.KaS != null) && (this.KaS.onKeyDown(paramKeyEvent.getKeyCode(), paramKeyEvent)))
    {
      AppMethodBeat.o(187225);
      return true;
    }
    AppMethodBeat.o(187225);
    return false;
  }
  
  public final boolean forceRemoveNoMatchOnPath()
  {
    return false;
  }
  
  public final boolean onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(187220);
    if (((paramInt1 == 2001) || (paramInt1 == 30763) || (paramInt1 == 226) || (paramInt1 == 30762) || (paramInt1 == 1111)) && (this.KaS != null))
    {
      this.KaS.onActivityResult(paramInt1, paramInt2, paramIntent);
      AppMethodBeat.o(187220);
      return true;
    }
    AppMethodBeat.o(187220);
    return false;
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(187219);
    if ((this.mPrepareBitmap != null) && (!this.mPrepareBitmap.isRecycled()))
    {
      ae.i("ChattingCompat", "bitmap recycle %s", new Object[] { this.mPrepareBitmap.toString() });
      this.mPrepareBitmap.recycle();
    }
    this.Jzu = false;
    this.KaY.clear();
    this.hXp.removeCallbacksAndMessages(null);
    this.activity = null;
    this.KaS = null;
    this.chattingView = null;
    this.KaU = null;
    AppMethodBeat.o(187219);
  }
  
  public final void onPause()
  {
    this.KaX = a.Kbg;
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(187221);
    if (this.KaS != null) {
      this.KaS.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    }
    AppMethodBeat.o(187221);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(187218);
    this.KaX = a.Kbf;
    onSwipe(1.0F);
    if ((this.KaS != null) && (this.KaS.cXJ.cCq)) {}
    for (int i = 1;; i = 0)
    {
      if ((i == 0) && (this.Jzu))
      {
        String str = this.pendingUser;
        Bundle localBundle = this.pendingBundle;
        this.pendingUser = str;
        this.pendingBundle = localBundle;
        this.Jzu = false;
        this.hXp.removeCallbacks(this.startChattingRunnable);
        this.hXp.post(this.startChattingRunnable);
      }
      AppMethodBeat.o(187218);
      return;
    }
  }
  
  public final void onSettle(boolean paramBoolean, int paramInt)
  {
    long l = 130L;
    AppMethodBeat.i(187222);
    ae.v("ChattingCompat", "ashutest: on settle %B, speed %d, resumeStatus %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), this.KaX });
    if ((!d.lA(19)) || (!com.tencent.mm.compatible.g.b.abm()))
    {
      AppMethodBeat.o(187222);
      return;
    }
    View localView = this.activity.findViewById(2131301337);
    if (localView == null)
    {
      ae.e("ChattingCompat", "[onSettle] null == container");
      AppMethodBeat.o(187222);
      return;
    }
    ImageView localImageView = (ImageView)this.activity.findViewById(2131303386);
    if ((localImageView != null) && (localImageView.getVisibility() == 8) && (localImageView.getDrawable() != null))
    {
      localImageView.setVisibility(0);
      ae.i("ChattingCompat", "[onSettle] prepareView VISIBLE");
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
          AppMethodBeat.o(187222);
          return;
          l = 230L;
        }
      }
      if (paramInt > 0) {}
      for (;;)
      {
        j.a(localImageView, l, localImageView.getWidth() * -1 / 4, null);
        AppMethodBeat.o(187222);
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
        AppMethodBeat.o(187222);
        return;
        l = 230L;
      }
    }
    if (paramInt > 0) {}
    for (;;)
    {
      j.a(localView, l, localView.getWidth() * -1 / 4, null);
      AppMethodBeat.o(187222);
      return;
      l = 230L;
    }
  }
  
  public final void onSwipe(float paramFloat)
  {
    AppMethodBeat.i(187224);
    ae.v("ChattingCompat", "ashutest::on swipe %f, duration %d, status %s", new Object[] { Float.valueOf(paramFloat), Long.valueOf(320L), this.KaX });
    if ((!d.lA(19)) || (!com.tencent.mm.compatible.g.b.abm()))
    {
      AppMethodBeat.o(187224);
      return;
    }
    if (this.KaS == null)
    {
      AppMethodBeat.o(187224);
      return;
    }
    if ((paramFloat == 0.0F) && (!this.KaV))
    {
      localObject1 = (ImageView)this.activity.getWindow().getDecorView().findViewById(2131303386);
      if (localObject1 != null)
      {
        localObject2 = (ViewGroup)((ImageView)localObject1).getTag();
        if (localObject2 != null)
        {
          ae.i("ChattingCompat", "[onSwipe] prepareView GONE");
          ((ViewGroup)localObject2).setVisibility(0);
          ((ImageView)localObject1).setVisibility(8);
          ((ImageView)localObject1).setImageDrawable(null);
        }
      }
      if (this.KaU != null) {
        this.KaU.cancel();
      }
    }
    while ((a.Kbf != this.KaX) && (Float.compare(1.0F, paramFloat) > 0))
    {
      ae.i("ChattingCompat", "[onSwipe] return! consumedSuperCall:%s", new Object[] { Float.valueOf(paramFloat) });
      AppMethodBeat.o(187224);
      return;
      if ((paramFloat == 1.0F) && (!this.KaV) && (this.KaS.isSupportNavigationSwipeBack()))
      {
        this.activity.getWindow().setBackgroundDrawableResource(2131100810);
        localObject1 = (ImageView)this.activity.getWindow().getDecorView().findViewById(2131303386);
        if ((localObject1 != null) && (((ImageView)localObject1).getVisibility() == 0) && (((ImageView)localObject1).getTag() != null))
        {
          ((View)((ImageView)localObject1).getTag()).setVisibility(0);
          ae.i("ChattingCompat", "[onSwipe] prepareView GONE");
          ((ImageView)localObject1).setVisibility(8);
        }
      }
    }
    Object localObject1 = this.activity.findViewById(2131301337);
    Object localObject2 = (ImageView)this.activity.findViewById(2131303386);
    if ((localObject2 != null) && (((ImageView)localObject2).getVisibility() == 8) && (((ImageView)localObject2).getDrawable() != null) && (!this.KaV) && (paramFloat != 1.0F) && (paramFloat != 0.0F))
    {
      ((ImageView)localObject2).setVisibility(0);
      ae.i("ChattingCompat", "[onSwipe] !1 && !0 prepareView VISIBLE");
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
    }
    if (Float.compare(1.0F, paramFloat) <= 0)
    {
      j.y((View)localObject1, 0.0F);
      j.y((View)localObject2, 0.0F);
      AppMethodBeat.o(187224);
      return;
    }
    if ((localObject2 != null) && (((ImageView)localObject2).getDrawable() != null))
    {
      j.y((View)localObject2, ((ImageView)localObject2).getWidth() / 4 * (1.0F - paramFloat) * -1.0F);
      AppMethodBeat.o(187224);
      return;
    }
    j.y((View)localObject1, ((View)localObject1).getWidth() / 4 * (1.0F - paramFloat) * -1.0F);
    AppMethodBeat.o(187224);
  }
  
  final void tryResetChattingSwipeStatus()
  {
    boolean bool = true;
    AppMethodBeat.i(187223);
    if ((!d.lA(19)) || (!com.tencent.mm.compatible.g.b.abm()))
    {
      AppMethodBeat.o(187223);
      return;
    }
    if (this.KaS == null) {}
    for (;;)
    {
      ae.i("ChattingCompat", "ashutest: tryResetChattingSwipeStatus, chattingFragment NULL ? %B", new Object[] { Boolean.valueOf(bool) });
      if (this.KaS != null) {
        this.KaS.getSwipeBackLayout().Lqa = false;
      }
      AppMethodBeat.o(187223);
      return;
      bool = false;
    }
  }
  
  static enum a
  {
    static
    {
      AppMethodBeat.i(187211);
      Kbe = new a("ACTIVITY_CREATE", 0);
      Kbf = new a("ACTIVITY_RESUME", 1);
      Kbg = new a("ACTIVITY_PAUSE", 2);
      Kbh = new a[] { Kbe, Kbf, Kbg };
      AppMethodBeat.o(187211);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.a
 * JD-Core Version:    0.7.0.1
 */
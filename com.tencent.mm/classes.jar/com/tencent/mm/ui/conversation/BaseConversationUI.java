package com.tencent.mm.ui.conversation;

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
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowInsets;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.platformtools.IntentUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.ui.HomeUI.FitSystemWindowLayoutView;
import com.tencent.mm.ui.IChattingUIProxy;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.MMFragmentActivity.a;
import com.tencent.mm.ui.ab;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.b.c;
import com.tencent.mm.ui.base.OnLayoutChangedLinearLayout;
import com.tencent.mm.ui.base.OnLayoutChangedLinearLayout.a;
import com.tencent.mm.ui.chatting.ChattingUIFragment;
import com.tencent.mm.ui.chatting.ChattingUIProxy;
import com.tencent.mm.ui.tools.TestTimeForChatting;
import com.tencent.mm.ui.tools.TestTimeForChatting.a;
import com.tencent.mm.ui.tools.k;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.ui.widget.l;

public class BaseConversationUI
  extends MMFragmentActivity
{
  private static final String LAST_RESTORE_TALKER = "last_restore_talker";
  static final String TAG = "MicroMsg.BaseConversationUI";
  private OnLayoutChangedLinearLayout chattingFragmentView;
  private ChattingUIFragment chattingFragmet;
  private int chattingID;
  private IChattingUIProxy chattingUIProxy;
  private TestTimeForChatting chattingView;
  private long chattinguiResumeTime;
  public BaseConversationUI.BaseConversationFmUI conversationFm;
  private boolean isAnimating;
  private String lastRestoreTalker;
  private BaseConversationUI.a launcherUIStatus;
  private ActionBar mActionBar;
  private com.tencent.mm.ui.b mActionBarHelper;
  public boolean mChattingClosed;
  private Animation mChattingInAnim;
  private Animation mChattingOutAnim;
  private boolean mNeedChattingAnim;
  private Bitmap mPrepareBitmap;
  private OnLayoutChangedLinearLayout.a onChattingLayoutChangedListener;
  private long onDrawStart;
  Bundle pendingBundle;
  String pendingUser;
  private b selectImageJob;
  Runnable startChattingRunnable;
  private CharSequence title;
  
  public BaseConversationUI()
  {
    AppMethodBeat.i(38195);
    this.chattinguiResumeTime = 0L;
    this.launcherUIStatus = BaseConversationUI.a.afmj;
    this.mNeedChattingAnim = false;
    this.mChattingClosed = true;
    this.chattingID = -1;
    this.onDrawStart = 0L;
    this.onChattingLayoutChangedListener = new OnLayoutChangedLinearLayout.a()
    {
      public final void jkC()
      {
        AppMethodBeat.i(38173);
        BaseConversationUI.access$700(BaseConversationUI.this);
        if (BaseConversationUI.this.mNeedChattingAnim)
        {
          BaseConversationUI.this.chattingView.setOndispatchDraw(new TestTimeForChatting.a()
          {
            public final void jkD()
            {
              AppMethodBeat.i(256645);
              Log.i("MicroMsg.BaseConversationUI", "[onDrawed]");
              BaseConversationUI.access$902(BaseConversationUI.this, System.currentTimeMillis());
              if (BaseConversationUI.this.chattingFragmet == null)
              {
                Log.e("MicroMsg.BaseConversationUI", "chattingFragmet is null!");
                AppMethodBeat.o(256645);
                return;
              }
              BaseConversationUI.this.startChattingViewAnimation();
              BaseConversationUI.this.chattingView.setOndispatchDraw(null);
              AppMethodBeat.o(256645);
            }
          });
          BaseConversationUI.access$802(BaseConversationUI.this, false);
        }
        for (;;)
        {
          BaseConversationUI.this.chattingFragmentView.adWO = null;
          Log.i("MicroMsg.BaseConversationUI", "klem CHATTING ONLAYOUT ");
          AppMethodBeat.o(38173);
          return;
          BaseConversationUI.access$1000(BaseConversationUI.this);
          BaseConversationUI.access$1100(BaseConversationUI.this);
        }
      }
    };
    this.startChattingRunnable = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(256441);
        if (!BaseConversationUI.this.mChattingClosed)
        {
          Log.e("MicroMsg.BaseConversationUI", "start chatting but last chatting does't be close!");
          BaseConversationUI.this.closeChatting(false);
        }
        if ((BaseConversationUI.this.isFinishing()) || (BaseConversationUI.this.isPaused()) || (!BaseConversationUI.this.mChattingClosed))
        {
          Log.w("MicroMsg.BaseConversationUI", "[startChattingRunnable] pass! isPause:%s mChattingClosed:%s", new Object[] { Boolean.valueOf(BaseConversationUI.this.isPaused()), Boolean.valueOf(BaseConversationUI.this.mChattingClosed) });
          AppMethodBeat.o(256441);
          return;
        }
        BaseConversationUI.this.mChattingClosed = false;
        boolean bool;
        if (BaseConversationUI.this.chattingView == null)
        {
          bool = false;
          Log.i("MicroMsg.BaseConversationUI", "ashutest::startChatting, ishow:%b", new Object[] { Boolean.valueOf(bool) });
          Intent localIntent = new Intent().putExtra("Chat_User", BaseConversationUI.this.pendingUser);
          if (BaseConversationUI.this.pendingBundle != null) {
            localIntent.putExtras(BaseConversationUI.this.pendingBundle);
          }
          localIntent.putExtra("img_gallery_enter_from_chatting_ui", true);
          BaseConversationUI.access$300(BaseConversationUI.this, localIntent, false);
          BaseConversationUI.this.chattingFragmentView.setOnChattingLayoutChangedListener(BaseConversationUI.this.onChattingLayoutChangedListener);
          if (BaseConversationUI.this.getWindow().getDecorView().getWidth() != 0) {
            break label344;
          }
        }
        label344:
        for (float f = BaseConversationUI.this.getResources().getDisplayMetrics().widthPixels;; f = BaseConversationUI.this.getWindow().getDecorView().getWidth())
        {
          BaseConversationUI.this.chattingView.setTranslationX(f - 0.1F);
          BaseConversationUI.this.chattingView.setVisibility(0);
          BaseConversationUI.this.pauseMainFragment();
          if (BaseConversationUI.this.chattingFragmet.isSupportNavigationSwipeBack()) {
            l.a(BaseConversationUI.this);
          }
          ThreadPool.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(256462);
              if (BaseConversationUI.this.chattingFragmet != null)
              {
                com.tencent.mm.modelstat.d.d(4, BaseConversationUI.this.getLocalClassName(), BaseConversationUI.this.hashCode());
                com.tencent.mm.modelstat.d.d(3, "ChattingUI" + BaseConversationUI.this.chattingFragmet.getIdentityString(), BaseConversationUI.this.chattingFragmet.hashCode());
              }
              AppMethodBeat.o(256462);
            }
          }, "directReport_startChattingRunnable");
          BaseConversationUI.access$402(BaseConversationUI.this, Util.nowSecond());
          AppMethodBeat.o(256441);
          return;
          bool = BaseConversationUI.this.chattingView.isShown();
          break;
        }
      }
      
      public final String toString()
      {
        AppMethodBeat.i(256446);
        String str = super.toString() + "|startChattingRunnable";
        AppMethodBeat.o(256446);
        return str;
      }
    };
    this.selectImageJob = new b((byte)0);
    AppMethodBeat.o(38195);
  }
  
  private boolean acceptRequestCode(int paramInt)
  {
    AppMethodBeat.i(38221);
    paramInt = 0xFFFF & paramInt;
    Log.w("MicroMsg.BaseConversationUI", "check request code %d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(38221);
      return false;
    }
    AppMethodBeat.o(38221);
    return true;
  }
  
  private void createChattingView()
  {
    AppMethodBeat.i(38210);
    Object localObject2;
    Object localObject1;
    Object localObject3;
    final ViewGroup localViewGroup;
    int i;
    if (this.chattingView == null)
    {
      if (!this.chattingFragmet.isSupportCustomActionBar())
      {
        this.chattingView = ((TestTimeForChatting)findViewById(R.h.fxi));
        this.chattingID = this.chattingView.getId();
        AppMethodBeat.o(38210);
        return;
      }
      localObject2 = new int[2];
      localObject1 = getSupportActionBar().getCustomView();
      if (localObject1 != null) {
        ((View)localObject1).getLocationInWindow((int[])localObject2);
      }
      TestTimeForChatting localTestTimeForChatting = new TestTimeForChatting(this);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      localTestTimeForChatting.setId(R.h.fxF);
      this.chattingID = localTestTimeForChatting.getId();
      localTestTimeForChatting.setOrientation(1);
      localTestTimeForChatting.setLayoutParams(localLayoutParams);
      localObject3 = new HomeUI.FitSystemWindowLayoutView(this);
      ((HomeUI.FitSystemWindowLayoutView)localObject3).setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
      localViewGroup = findRootContainer();
      localObject1 = localViewGroup;
      if (localViewGroup == null) {
        localObject1 = ((ViewGroup)getWindow().getDecorView()).getChildAt(0);
      }
      if ((localObject1 instanceof SwipeBackLayout))
      {
        localViewGroup = (ViewGroup)((ViewGroup)localObject1).getChildAt(0);
        ImageView localImageView = new ImageView(this);
        localImageView.setId(R.h.fTp);
        localImageView.setLayoutParams(localLayoutParams);
        localImageView.setVisibility(8);
        ((ViewGroup)getWindow().getDecorView()).removeView((View)localObject1);
        ((View)localObject1).setId(R.h.fMr);
        ((HomeUI.FitSystemWindowLayoutView)localObject3).addView((View)localObject1);
        ((HomeUI.FitSystemWindowLayoutView)localObject3).addView(localImageView);
        ((HomeUI.FitSystemWindowLayoutView)localObject3).addView(localTestTimeForChatting);
        ((ViewGroup)getWindow().getDecorView()).addView((View)localObject3);
        getWindow().getDecorView().requestFitSystemWindows();
        i = localObject2[1];
        if (i <= 0) {
          break label373;
        }
        updateRootViewSystemWindowsInsets((HomeUI.FitSystemWindowLayoutView)localObject3, i, new Rect(0, i, 0, 0), localViewGroup);
      }
      for (;;)
      {
        this.chattingView = ((TestTimeForChatting)findViewById(this.chattingID));
        Log.i("MicroMsg.BaseConversationUI", "ashu::prepareChattingFragment init chattingView, top %s", new Object[] { Integer.valueOf(localObject2[1]) });
        AppMethodBeat.o(38210);
        return;
        localViewGroup = (ViewGroup)localObject1;
        break;
        label373:
        localObject1 = getSupportActionBar().getCustomView();
        if (localObject1 == null)
        {
          AppMethodBeat.o(38210);
          return;
        }
        ((View)localObject1).post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(38177);
            this.afmg.getLocationInWindow(this.adIR);
            int i = this.adIR[1];
            if (i > 0)
            {
              BaseConversationUI.access$1400(BaseConversationUI.this, this.adIS, i, new Rect(0, i, 0, 0), localViewGroup);
              AppMethodBeat.o(38177);
              return;
            }
            if (com.tencent.mm.compatible.util.d.rb(20)) {
              this.adIS.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener()
              {
                public final WindowInsets onApplyWindowInsets(View paramAnonymous2View, WindowInsets paramAnonymous2WindowInsets)
                {
                  AppMethodBeat.i(256631);
                  if (paramAnonymous2WindowInsets == null)
                  {
                    AppMethodBeat.o(256631);
                    return paramAnonymous2WindowInsets;
                  }
                  Log.i("MicroMsg.BaseConversationUI", "OnApplyWindowInsetsListener %s", new Object[] { paramAnonymous2WindowInsets });
                  paramAnonymous2WindowInsets.consumeSystemWindowInsets();
                  BaseConversationUI.access$1400(BaseConversationUI.this, BaseConversationUI.9.this.adIS, paramAnonymous2WindowInsets.getSystemWindowInsetTop(), new Rect(paramAnonymous2WindowInsets.getSystemWindowInsetLeft(), paramAnonymous2WindowInsets.getSystemWindowInsetTop(), paramAnonymous2WindowInsets.getSystemWindowInsetRight(), paramAnonymous2WindowInsets.getSystemWindowInsetBottom()), BaseConversationUI.9.this.adIT);
                  AppMethodBeat.o(256631);
                  return paramAnonymous2WindowInsets;
                }
              });
            }
            AppMethodBeat.o(38177);
          }
        });
      }
    }
    if (this.chattingFragmet.isSupportCustomActionBar())
    {
      localObject1 = new int[2];
      this.chattingView.getLocationInWindow((int[])localObject1);
      if (localObject1[1] == 0)
      {
        localViewGroup = (ViewGroup)getWindow().getDecorView();
        i = 0;
      }
    }
    for (;;)
    {
      if (i < localViewGroup.getChildCount())
      {
        localObject2 = ((ViewGroup)getWindow().getDecorView()).getChildAt(i);
        if (!(localObject2 instanceof HomeUI.FitSystemWindowLayoutView)) {
          break label712;
        }
        if (getSupportActionBar().getCustomView() != null) {
          getSupportActionBar().getCustomView().getLocationInWindow((int[])localObject1);
        }
        localObject2 = (HomeUI.FitSystemWindowLayoutView)localObject2;
        ((HomeUI.FitSystemWindowLayoutView)localObject2).fitSystemWindows(new Rect(0, ((HomeUI.FitSystemWindowLayoutView)localObject2).getCacheInsetsTop(), 0, 0));
        Log.i("MicroMsg.BaseConversationUI", "rootLayout2 fitSystemWindows, top %s", new Object[] { Integer.valueOf(localObject1[1]) });
        localViewGroup = (ViewGroup)localViewGroup.findViewById(R.h.fMr);
        localObject2 = (ImageView)((HomeUI.FitSystemWindowLayoutView)localObject2).findViewById(R.h.fTp);
        ((ImageView)localObject2).setTag(localViewGroup);
        localObject3 = localViewGroup.getLayoutParams();
        if ((localObject3 == null) || ((localObject3 instanceof FrameLayout.LayoutParams))) {
          break label693;
        }
        Log.w("MicroMsg.BaseConversationUI", "FIX LayoutParams");
        ((ImageView)localObject2).setLayoutParams(new FrameLayout.LayoutParams((ViewGroup.LayoutParams)localObject3));
        localObject3 = getMagicDrawingCache(localViewGroup);
        if (localObject3 == null) {
          break label703;
        }
        ((ImageView)localObject2).setImageBitmap((Bitmap)localObject3);
        localViewGroup.setVisibility(8);
        ((ImageView)localObject2).setVisibility(0);
        Log.i("MicroMsg.BaseConversationUI", "[prepareChattingFragment] prepareView VISIBLE");
      }
      for (;;)
      {
        Log.i("MicroMsg.BaseConversationUI", "ashu::prepareChattingFragment has chattingView, top %s", new Object[] { Integer.valueOf(localObject1[1]) });
        AppMethodBeat.o(38210);
        return;
        label693:
        ((ImageView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
        break;
        label703:
        ((ImageView)localObject2).setImageBitmap(null);
      }
      label712:
      Log.e("MicroMsg.BaseConversationUI", "on position %d, rootLayout not found!", new Object[] { Integer.valueOf(i) });
      i += 1;
    }
  }
  
  private void doJobOnChattingAnimEnd()
  {
    AppMethodBeat.i(38205);
    MMHandlerThread.postToMainThreadDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(38168);
        bh.baH().setLowPriority();
        MMHandlerThread.setCurrentPriority(0);
        BaseConversationUI.this.onSwipe(1.0F);
        if ((BaseConversationUI.this.chattingView != null) && (BaseConversationUI.this.chattingFragmet != null)) {
          BaseConversationUI.this.chattingView.jDq();
        }
        BaseConversationUI.this.chattingUIProxy.onEnterEnd();
        BaseConversationUI.access$600(BaseConversationUI.this);
        AppMethodBeat.o(38168);
      }
      
      public final String toString()
      {
        AppMethodBeat.i(38169);
        String str = super.toString() + "|chattingView_onAnimationEnd";
        AppMethodBeat.o(38169);
        return str;
      }
    }, 60L);
    AppMethodBeat.o(38205);
  }
  
  private void doJobOnChattingAnimStart()
  {
    AppMethodBeat.i(38204);
    this.chattingView.setTranslationX(0.0F);
    this.chattingView.jDp();
    AppMethodBeat.o(38204);
  }
  
  private ViewGroup findRootContainer()
  {
    Object localObject2 = null;
    AppMethodBeat.i(38213);
    Object localObject1 = this.mActionBar.getCustomView();
    if (localObject1 == null)
    {
      AppMethodBeat.o(38213);
      return null;
    }
    localObject1 = ((View)localObject1).getParent();
    ViewGroup localViewGroup = (ViewGroup)getWindow().getDecorView();
    while ((localObject1 != localViewGroup) && (localObject1 != null))
    {
      ViewParent localViewParent = ((ViewParent)localObject1).getParent();
      localObject2 = localObject1;
      localObject1 = localViewParent;
    }
    localObject1 = (ViewGroup)localObject2;
    AppMethodBeat.o(38213);
    return localObject1;
  }
  
  private String getIdentityString()
  {
    AppMethodBeat.i(38227);
    if (this.chattingFragmet != null)
    {
      String str = this.chattingFragmet.getIdentityString();
      AppMethodBeat.o(38227);
      return str;
    }
    AppMethodBeat.o(38227);
    return "";
  }
  
  private void initActionBar()
  {
    AppMethodBeat.i(38217);
    if ((this.chattingFragmet != null) && (this.chattingFragmet.iNh().ffv))
    {
      Log.w("MicroMsg.BaseConversationUI", "[initActionBar] isChattingForeground True!");
      AppMethodBeat.o(38217);
      return;
    }
    Log.w("MicroMsg.BaseConversationUI", "[initActionBar] isChattingForeground False!");
    View localView = getActionBarCustomView();
    this.mActionBarHelper = new com.tencent.mm.ui.b(localView);
    this.mActionBar.setLogo(new ColorDrawable(getResources().getColor(17170445)));
    this.mActionBar.x(false);
    this.mActionBar.w(false);
    this.mActionBar.v(false);
    this.mActionBar.y(true);
    this.mActionBar.setCustomView(localView);
    updateTitle(this.title);
    this.mActionBarHelper.setClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(256664);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/conversation/BaseConversationUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (BaseConversationUI.this.isAnimating)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/BaseConversationUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(256664);
          return;
        }
        MMHandlerThread.removeRunnable(BaseConversationUI.this.startChattingRunnable);
        BaseConversationUI.this.finish();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/conversation/BaseConversationUI$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(256664);
      }
    });
    if (this.mActionBar.getCustomView() != null)
    {
      this.mActionBar.getCustomView().findViewById(R.h.arrow_area_btn);
      ((TextView)this.mActionBar.getCustomView().findViewById(R.h.title_area)).setTextColor(getResources().getColor(R.e.black_text_color));
    }
    AppMethodBeat.o(38217);
  }
  
  private void initChattingInAnimation()
  {
    AppMethodBeat.i(256520);
    if (this.mChattingInAnim == null)
    {
      this.mChattingInAnim = AnimationUtils.loadAnimation(this, MMFragmentActivity.a.upU);
      this.mChattingInAnim.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(256444);
          BaseConversationUI.access$1302(BaseConversationUI.this, false);
          Log.i("MicroMsg.BaseConversationUI", "klem animationEnd");
          BaseConversationUI.access$1100(BaseConversationUI.this);
          AppMethodBeat.o(256444);
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(256437);
          Log.i("MicroMsg.BaseConversationUI", "klem onAnimationStart onDrawed->onAnimationStart:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - BaseConversationUI.this.onDrawStart) });
          BaseConversationUI.access$1302(BaseConversationUI.this, true);
          BaseConversationUI.access$1000(BaseConversationUI.this);
          BaseConversationUI.this.onSettle(false, 0);
          AppMethodBeat.o(256437);
        }
      });
    }
    AppMethodBeat.o(256520);
  }
  
  private void prepareChattingFragment(Intent paramIntent, boolean paramBoolean)
  {
    AppMethodBeat.i(38209);
    long l = System.currentTimeMillis();
    if (this.chattingFragmet == null)
    {
      this.chattingFragmet = getChattingUIFragment();
      this.chattingUIProxy = new ChattingUIProxy(this, this.chattingFragmet);
    }
    for (boolean bool = true;; bool = false)
    {
      createChattingView();
      if (paramIntent != null) {
        this.chattingFragmet.getArguments().putAll(IntentUtil.getExtras(paramIntent));
      }
      if (bool)
      {
        this.chattingUIProxy.onInit(this.chattingID, paramBoolean);
        this.chattingFragmentView = ((OnLayoutChangedLinearLayout)this.chattingFragmet.getView().findViewById(R.h.chatting_bg_ll));
      }
      for (;;)
      {
        if (this.chattingFragmet.isSupportNavigationSwipeBack()) {
          this.chattingFragmet.getSwipeBackLayout().setNeedRequestActivityTranslucent(false);
        }
        Log.i("MicroMsg.BaseConversationUI", "ashu::prepareChattingFragment use %dms, needInit %B, Intent %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Boolean.valueOf(bool), paramIntent });
        AppMethodBeat.o(38209);
        return;
        this.chattingUIProxy.onEnterBegin();
      }
    }
  }
  
  private void resetViewTranX(View paramView, ImageView paramImageView, float paramFloat)
  {
    AppMethodBeat.i(38202);
    if (Float.compare(1.0F, paramFloat) <= 0)
    {
      k.r(paramView, 0.0F);
      k.r(paramImageView, 0.0F);
      AppMethodBeat.o(38202);
      return;
    }
    if ((paramImageView != null) && (paramImageView.getDrawable() != null))
    {
      k.r(paramImageView, paramImageView.getWidth() / 4 * (1.0F - paramFloat) * -1.0F);
      AppMethodBeat.o(38202);
      return;
    }
    k.r(paramView, paramView.getWidth() / 4 * (1.0F - paramFloat) * -1.0F);
    AppMethodBeat.o(38202);
  }
  
  private void tryResetChattingSwipeStatus()
  {
    boolean bool = true;
    AppMethodBeat.i(38206);
    if ((!com.tencent.mm.compatible.util.d.rb(19)) || (!com.tencent.mm.compatible.h.a.aPR()))
    {
      AppMethodBeat.o(38206);
      return;
    }
    if (this.chattingFragmet == null) {}
    for (;;)
    {
      Log.i("MicroMsg.BaseConversationUI", "ashutest: tryResetChattingSwipeStatus, chattingFragment NULL ? %B", new Object[] { Boolean.valueOf(bool) });
      if ((this.chattingFragmet != null) && (this.chattingFragmet.getSwipeBackLayout() != null)) {
        this.chattingFragmet.getSwipeBackLayout().mqz = false;
      }
      AppMethodBeat.o(38206);
      return;
      bool = false;
    }
  }
  
  private void updateRootViewSystemWindowsInsets(HomeUI.FitSystemWindowLayoutView paramFitSystemWindowLayoutView, int paramInt, Rect paramRect, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(38212);
    int k = getWindow().getDecorView().getBottom();
    int i;
    if (getSupportActionBar().getCustomView() != null)
    {
      i = getSupportActionBar().getCustomView().getBottom();
      if ((this.conversationFm == null) || (this.conversationFm.getView() == null)) {
        break label145;
      }
    }
    label145:
    for (int j = k - (paramInt + i + this.conversationFm.getView().getBottom());; j = 0)
    {
      Log.i("MicroMsg.BaseConversationUI", "ashu::fitSystemWindows 2. decorBottom:%d, statusBarHeight:%d, actionBarHeight:%d, paddingForNavBar:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(j) });
      paramFitSystemWindowLayoutView.setActionBarContainer(paramViewGroup);
      paramFitSystemWindowLayoutView.fitSystemWindows(paramRect);
      AppMethodBeat.o(38212);
      return;
      i = 0;
      break;
    }
  }
  
  private void updateTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(256566);
    if (this.mActionBarHelper != null) {
      this.mActionBarHelper.setTitle(paramCharSequence);
    }
    AppMethodBeat.o(256566);
  }
  
  public void closeChatting(boolean paramBoolean)
  {
    AppMethodBeat.i(38216);
    if (this.chattingView == null) {}
    for (boolean bool = false;; bool = this.chattingView.isShown())
    {
      Log.i("MicroMsg.BaseConversationUI", "try closeChatting, ishow:%b", new Object[] { Boolean.valueOf(bool) });
      if ((this.chattingFragmet != null) && (this.chattingFragmet.isSupportNavigationSwipeBack())) {
        l.b(this);
      }
      if ((this.chattingView != null) && (this.chattingView.getVisibility() != 8) && (this.chattingFragmet != null)) {
        break;
      }
      AppMethodBeat.o(38216);
      return;
    }
    Log.i("MicroMsg.BaseConversationUI", "[closeChatting] needAnim:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.chattingView.setVisibility(8);
    this.mChattingClosed = true;
    if ((paramBoolean) && (this.mChattingOutAnim == null))
    {
      this.mChattingOutAnim = AnimationUtils.loadAnimation(this, MMFragmentActivity.a.upX);
      this.mChattingOutAnim.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(256477);
          bh.baH().setLowPriority();
          MMHandlerThread.setCurrentPriority(0);
          BaseConversationUI.access$600(BaseConversationUI.this);
          Log.i("MicroMsg.BaseConversationUI", "klem pop out onAnimationEnd");
          AppMethodBeat.o(256477);
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(256471);
          bh.baH().setLowestPriority();
          MMHandlerThread.setCurrentPriority(-8);
          Log.i("MicroMsg.BaseConversationUI", "klem pop out onAnimationStart");
          BaseConversationUI.this.onSettle(true, 0);
          AppMethodBeat.o(256471);
        }
      });
    }
    if (this.chattingFragmet.isSupportCustomActionBar())
    {
      ImageView localImageView = (ImageView)getWindow().getDecorView().findViewById(R.h.fTp);
      if ((localImageView != null) && (localImageView.getVisibility() == 0))
      {
        localImageView.setVisibility(8);
        Log.i("MicroMsg.BaseConversationUI", "[closeChatting] prepareView GONE");
        if (localImageView.getTag() != null) {
          ((View)localImageView.getTag()).setVisibility(0);
        }
      }
    }
    if (paramBoolean)
    {
      this.chattingUIProxy.onExitBegin();
      this.chattingUIProxy.onExitEnd();
      this.chattingView.startAnimation(this.mChattingOutAnim);
    }
    for (;;)
    {
      if (!this.chattingFragmet.isSupportCustomActionBar()) {
        initActionBar();
      }
      supportInvalidateOptionsMenu();
      resumeMainFragment();
      ThreadPool.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(256665);
          if (BaseConversationUI.this.chattingFragmet == null)
          {
            AppMethodBeat.o(256665);
            return;
          }
          com.tencent.mm.modelstat.d.d(4, "ChattingUI" + BaseConversationUI.access$000(BaseConversationUI.this), BaseConversationUI.this.chattingFragmet.hashCode());
          com.tencent.mm.modelstat.d.n("ChattingUI" + BaseConversationUI.access$000(BaseConversationUI.this), BaseConversationUI.this.chattinguiResumeTime, Util.nowSecond());
          com.tencent.mm.modelstat.d.d(3, BaseConversationUI.this.getLocalClassName(), BaseConversationUI.this.hashCode());
          AppMethodBeat.o(256665);
        }
      }, "directReport_closeChatting");
      AppMethodBeat.o(38216);
      return;
      this.chattingUIProxy.onExitBegin();
      this.chattingUIProxy.onExitEnd();
      this.chattingView.setVisibility(8);
      onSwipe(1.0F);
      tryResetChattingSwipeStatus();
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(38225);
    Log.d("MicroMsg.BaseConversationUI", "chatting ui dispatch key event %s", new Object[] { paramKeyEvent });
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0)) {
      MMHandlerThread.removeRunnable(this.startChattingRunnable);
    }
    if (this.isAnimating)
    {
      AppMethodBeat.o(38225);
      return true;
    }
    if ((this.chattingFragmet != null) && (this.chattingFragmet.onKeyDown(paramKeyEvent.getKeyCode(), paramKeyEvent)))
    {
      AppMethodBeat.o(38225);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(38225);
    return bool;
  }
  
  public View getActionBarCustomView()
  {
    AppMethodBeat.i(256687);
    View localView = af.mU(this).inflate(R.i.actionbar_custom_area_center, null);
    AppMethodBeat.o(256687);
    return localView;
  }
  
  protected ChattingUIFragment getChattingUIFragment()
  {
    AppMethodBeat.i(38226);
    ChattingUIFragment localChattingUIFragment = new ChattingUIFragment();
    AppMethodBeat.o(38226);
    return localChattingUIFragment;
  }
  
  public Bitmap getMagicDrawingCache(View paramView)
  {
    AppMethodBeat.i(38211);
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
        if ((i <= 0) || (j <= 0) || (this.chattingFragmet.getView() == null))
        {
          Log.e("MicroMsg.BaseConversationUI", "viewWidth:%s viewHeight:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          AppMethodBeat.o(38211);
          return null;
        }
        if (this.chattingFragmet != null) {
          Log.i("MicroMsg.BaseConversationUI", "getBottom:%s keyboardState:%s", new Object[] { Integer.valueOf(this.chattingFragmet.getView().getBottom()), Integer.valueOf(this.chattingFragmet.keyboardState()) });
        }
        if ((this.chattingFragmet != null) && (this.chattingFragmet.getView().getBottom() > 0) && ((this.chattingFragmet.keyboardState() == 1) || (this.chattingFragmet.getView().getBottom() < getResources().getDisplayMetrics().heightPixels * 2 / 3)))
        {
          Log.e("MicroMsg.BaseConversationUI", "hardKeyboardHidden:%s", new Object[] { Integer.valueOf(this.chattingFragmet.keyboardState()) });
          AppMethodBeat.o(38211);
          return null;
        }
        if ((this.chattingFragmet != null) && (this.chattingFragmet.keyboardState() == 1))
        {
          Log.e("MicroMsg.BaseConversationUI", "hardKeyboardHidden:%s", new Object[] { Integer.valueOf(this.chattingFragmet.keyboardState()) });
          AppMethodBeat.o(38211);
          return null;
        }
        if ((this.mPrepareBitmap == null) || (this.mPrepareBitmap.isRecycled()) || (this.mPrepareBitmap.getWidth() != i) || (this.mPrepareBitmap.getHeight() != j)) {
          if ((this.mPrepareBitmap != null) && (!this.mPrepareBitmap.isRecycled()))
          {
            Log.i("MicroMsg.BaseConversationUI", "bitmap recycle %s", new Object[] { this.mPrepareBitmap.toString() });
            this.mPrepareBitmap.recycle();
          }
        }
        for (;;)
        {
          try
          {
            this.mPrepareBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_4444);
            Canvas localCanvas = new Canvas(this.mPrepareBitmap);
            int k = (int)getResources().getDimension(R.f.wechat_abc_action_bar_default_height);
            int m = (int)getResources().getDimension(R.f.DefaultTabbarHeight);
            Paint localPaint = new Paint();
            localPaint.setColor(-1);
            localCanvas.drawRect(0.0F, k, i, j - m, localPaint);
            paramView.draw(localCanvas);
            Log.i("MicroMsg.BaseConversationUI", "[getMagicDrawingCache] cost%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
            paramView = this.mPrepareBitmap;
            AppMethodBeat.o(38211);
            return paramView;
          }
          catch (OutOfMemoryError paramView)
          {
            Log.e("MicroMsg.BaseConversationUI", "[getMagicDrawingCache] e:%s", new Object[] { paramView });
            AppMethodBeat.o(38211);
            return null;
          }
          this.mPrepareBitmap.eraseColor(0);
        }
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(38203);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.conversationFm != null) {
      this.conversationFm.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(38203);
      return;
    }
    if (((paramInt1 == 2001) || (paramInt1 == 226)) && (this.chattingFragmet != null)) {
      this.chattingFragmet.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    if ((acceptRequestCode(paramInt1)) && (this.chattingFragmet == null))
    {
      Log.i("MicroMsg.BaseConversationUI", "on select image ActivityResult. the chattingUI maybe kill in the background.");
      MMHandlerThread.removeRunnable(this.selectImageJob);
      this.selectImageJob.adIW = 0;
      this.selectImageJob.hPm = paramInt1;
      this.selectImageJob.resultCode = paramInt2;
      this.selectImageJob.hPn = paramIntent;
      MMHandlerThread.postToMainThread(this.selectImageJob);
      AppMethodBeat.o(38203);
      return;
    }
    AppMethodBeat.o(38203);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(38196);
    getWindow().setFormat(-2);
    super.onCreate(paramBundle);
    if (!b.jzR()) {
      getWindow().setCallback(new c(getWindow().getCallback(), this));
    }
    this.mActionBar = getSupportActionBar();
    initNavigationSwipeBack();
    AppMethodBeat.o(38196);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(38200);
    super.onDestroy();
    if ((this.mPrepareBitmap != null) && (!this.mPrepareBitmap.isRecycled()))
    {
      Log.i("MicroMsg.BaseConversationUI", "bitmap recycle %s", new Object[] { this.mPrepareBitmap.toString() });
      this.mPrepareBitmap.recycle();
    }
    this.chattingFragmet = null;
    this.chattingFragmentView = null;
    this.chattingView = null;
    this.conversationFm = null;
    this.mActionBarHelper = null;
    this.mChattingInAnim = null;
    this.mChattingOutAnim = null;
    AppMethodBeat.o(38200);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(38197);
    super.onNewIntent(paramIntent);
    Log.i("MicroMsg.BaseConversationUI", "onNewIntent");
    setIntent(paramIntent);
    AppMethodBeat.o(38197);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(38199);
    Log.i("MicroMsg.BaseConversationUI", "on pause");
    super.onPause();
    if (!isFinishing()) {
      l.a(this);
    }
    this.launcherUIStatus = BaseConversationUI.a.afml;
    if ((this.chattingView != null) && (this.chattingView.isShown())) {}
    for (final boolean bool = true;; bool = false)
    {
      ThreadPool.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(38167);
          int i = 0;
          if (BaseConversationUI.this.chattingFragmet != null) {
            i = BaseConversationUI.this.chattingFragmet.hashCode();
          }
          String str;
          if (bool)
          {
            str = "ChattingUI" + BaseConversationUI.access$000(BaseConversationUI.this);
            if (!bool) {
              break label130;
            }
          }
          for (;;)
          {
            com.tencent.mm.modelstat.d.d(4, str, i);
            if (bool) {
              com.tencent.mm.modelstat.d.n("ChattingUI" + BaseConversationUI.access$000(BaseConversationUI.this), BaseConversationUI.this.chattinguiResumeTime, Util.nowSecond());
            }
            AppMethodBeat.o(38167);
            return;
            str = BaseConversationUI.this.getLocalClassName();
            break;
            label130:
            i = BaseConversationUI.this.hashCode();
          }
        }
      }, "directReport_onPause");
      if ((this.chattingFragmet != null) && (this.chattingFragmet.isSupportNavigationSwipeBack())) {
        this.chattingFragmet.getSwipeBackLayout().setEnableGesture(false);
      }
      AppMethodBeat.o(38199);
      return;
    }
  }
  
  public void onRestoreInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(38222);
    super.onRestoreInstanceState(paramBundle);
    this.lastRestoreTalker = paramBundle.getString("last_restore_talker");
    Log.d("MicroMsg.BaseConversationUI", "onRestoreInstantceState:%s", new Object[] { this.lastRestoreTalker });
    AppMethodBeat.o(38222);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(38198);
    super.onResume();
    l.b(this);
    onSwipe(1.0F);
    this.launcherUIStatus = BaseConversationUI.a.afmk;
    if ((this.chattingView != null) && (this.chattingView.isShown())) {}
    for (final boolean bool = true;; bool = false)
    {
      ThreadPool.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(38164);
          String str;
          if (bool)
          {
            str = "ChattingUI" + BaseConversationUI.access$000(BaseConversationUI.this);
            if (!bool) {
              break label76;
            }
          }
          label76:
          for (int i = BaseConversationUI.this.chattingFragmet.hashCode();; i = BaseConversationUI.this.hashCode())
          {
            com.tencent.mm.modelstat.d.d(3, str, i);
            AppMethodBeat.o(38164);
            return;
            str = BaseConversationUI.this.getLocalClassName();
            break;
          }
        }
      }, "directReport_onResume");
      if (!bool) {
        this.chattinguiResumeTime = Util.nowSecond();
      }
      if ((com.tencent.mm.compatible.util.d.rb(19)) && (com.tencent.mm.compatible.h.a.aPR()))
      {
        if ((this.chattingFragmet != null) && (this.chattingFragmet.isSupportNavigationSwipeBack())) {
          this.chattingFragmet.getSwipeBackLayout().setEnableGesture(true);
        }
        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
        {
          public final boolean queueIdle()
          {
            AppMethodBeat.i(38166);
            long l = System.currentTimeMillis();
            if (BaseConversationUI.this.chattingView == null) {
              if ((BaseConversationUI.this.conversationFm == null) || (Util.isNullOrNil(BaseConversationUI.this.conversationFm.getUserName()))) {
                break label127;
              }
            }
            label127:
            for (Object localObject = BaseConversationUI.this.conversationFm.getUserName();; localObject = z.bAM())
            {
              localObject = new Intent().putExtra("Chat_User", (String)localObject);
              BaseConversationUI.access$300(BaseConversationUI.this, (Intent)localObject, true);
              BaseConversationUI.this.chattingView.setVisibility(8);
              BaseConversationUI.this.resumeMainFragment();
              Log.d("MicroMsg.BaseConversationUI", "prepare chattingUI logic use %dms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
              AppMethodBeat.o(38166);
              return false;
            }
          }
        });
      }
      initActionBar();
      this.mActionBar.show();
      AppMethodBeat.o(38198);
      return;
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(38223);
    if ((this.chattingFragmet != null) && (!Util.isNullOrNil(this.chattingFragmet.iNh().getTalkerUserName())))
    {
      Log.d("MicroMsg.BaseConversationUI", "onSaveInstanceState:%s", new Object[] { this.chattingFragmet.iNh().getTalkerUserName() });
      paramBundle.putString("last_restore_talker", this.chattingFragmet.iNh().getTalkerUserName());
    }
    AppMethodBeat.o(38223);
  }
  
  public void onSettle(boolean paramBoolean, int paramInt)
  {
    long l = 130L;
    AppMethodBeat.i(38224);
    Log.v("MicroMsg.BaseConversationUI", "ashutest: on settle %B, speed %d, resumeStatus %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), this.launcherUIStatus });
    if ((!com.tencent.mm.compatible.util.d.rb(19)) || (!com.tencent.mm.compatible.h.a.aPR()))
    {
      AppMethodBeat.o(38224);
      return;
    }
    View localView = findViewById(R.h.fMr);
    if (localView == null)
    {
      Log.e("MicroMsg.BaseConversationUI", "[onSettle] null == container");
      AppMethodBeat.o(38224);
      return;
    }
    ImageView localImageView = (ImageView)findViewById(R.h.fTp);
    if ((localImageView != null) && (localImageView.getVisibility() == 8) && (localImageView.getDrawable() != null))
    {
      localImageView.setVisibility(0);
      Log.i("MicroMsg.BaseConversationUI", "[onSettle] prepareView VISIBLE");
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
          AppMethodBeat.o(38224);
          return;
          l = 230L;
        }
      }
      if (paramInt > 0) {}
      for (;;)
      {
        k.a(localImageView, l, localImageView.getWidth() * -1 / 4, null);
        AppMethodBeat.o(38224);
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
        AppMethodBeat.o(38224);
        return;
        l = 230L;
      }
    }
    if (paramInt > 0) {}
    for (;;)
    {
      k.a(localView, l, localView.getWidth() * -1 / 4, null);
      AppMethodBeat.o(38224);
      return;
      l = 230L;
    }
  }
  
  public void onSwipe(float paramFloat)
  {
    AppMethodBeat.i(38201);
    Log.v("MicroMsg.BaseConversationUI", "ashutest::on swipe %f, duration %d, status %s", new Object[] { Float.valueOf(paramFloat), Long.valueOf(260L), this.launcherUIStatus });
    if ((!com.tencent.mm.compatible.util.d.rb(19)) || (!com.tencent.mm.compatible.h.a.aPR()))
    {
      AppMethodBeat.o(38201);
      return;
    }
    if (this.chattingFragmet == null)
    {
      Log.e("MicroMsg.BaseConversationUI", "chattingFragmet is null!");
      AppMethodBeat.o(38201);
      return;
    }
    if ((paramFloat == 0.0F) && (!this.mChattingClosed))
    {
      localObject1 = (ImageView)getWindow().getDecorView().findViewById(R.h.fTp);
      if (localObject1 != null)
      {
        localObject2 = (ViewGroup)((ImageView)localObject1).getTag();
        if (localObject2 != null)
        {
          Log.i("MicroMsg.BaseConversationUI", "[onSwipe] prepareView GONE");
          ((ViewGroup)localObject2).setVisibility(0);
          ((ImageView)localObject1).setVisibility(8);
          ((ImageView)localObject1).setImageDrawable(null);
        }
      }
      if (this.mChattingInAnim != null) {
        this.mChattingInAnim.cancel();
      }
    }
    while ((BaseConversationUI.a.afmk != this.launcherUIStatus) && (Float.compare(1.0F, paramFloat) > 0))
    {
      Log.i("MicroMsg.BaseConversationUI", "[onSwipe] return! consumedSuperCall:%s", new Object[] { Float.valueOf(paramFloat) });
      AppMethodBeat.o(38201);
      return;
      if ((paramFloat == 1.0F) && (!this.mChattingClosed) && (this.chattingFragmet.isSupportNavigationSwipeBack()))
      {
        getWindow().setBackgroundDrawableResource(R.e.fkX);
        localObject1 = (ImageView)getWindow().getDecorView().findViewById(R.h.fTp);
        if ((localObject1 != null) && (((ImageView)localObject1).getVisibility() == 0) && (((ImageView)localObject1).getTag() != null))
        {
          ((View)((ImageView)localObject1).getTag()).setVisibility(0);
          Log.i("MicroMsg.BaseConversationUI", "[onSwipe] prepareView GONE");
          ((ImageView)localObject1).setVisibility(8);
        }
      }
    }
    Object localObject1 = findViewById(R.h.fMr);
    Object localObject2 = (ImageView)findViewById(R.h.fTp);
    if ((localObject2 != null) && (((ImageView)localObject2).getVisibility() == 8) && (((ImageView)localObject2).getDrawable() != null) && (!this.mChattingClosed) && (paramFloat != 1.0F) && (paramFloat != 0.0F))
    {
      ((ImageView)localObject2).setVisibility(0);
      Log.i("MicroMsg.BaseConversationUI", "[onSwipe] !1 && !0 prepareView VISIBLE");
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
    }
    resetViewTranX((View)localObject1, (ImageView)localObject2, paramFloat);
    AppMethodBeat.o(38201);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public ActionMode onWindowStartingActionMode(ActionMode.Callback paramCallback)
  {
    AppMethodBeat.i(38220);
    if ((this.chattingFragmet == null) || (this.chattingFragmet.joS() == null) || (!this.chattingFragmet.isSupportCustomActionBar()))
    {
      AppMethodBeat.o(38220);
      return null;
    }
    if (com.tencent.mm.compatible.util.d.rd(22))
    {
      AppMethodBeat.o(38220);
      return null;
    }
    paramCallback = this.chattingFragmet.joS().b(paramCallback);
    if (paramCallback == null)
    {
      AppMethodBeat.o(38220);
      return null;
    }
    AppMethodBeat.o(38220);
    return paramCallback;
  }
  
  public void pauseMainFragment()
  {
    AppMethodBeat.i(38214);
    if (this.conversationFm != null)
    {
      this.conversationFm.onPause();
      if (!this.conversationFm.isSupportNavigationSwipeBack()) {
        this.conversationFm.showOptionMenu(false);
      }
    }
    AppMethodBeat.o(38214);
  }
  
  public void resumeMainFragment()
  {
    AppMethodBeat.i(38215);
    if (this.conversationFm != null)
    {
      this.conversationFm.onResume();
      if (!this.conversationFm.isSupportNavigationSwipeBack()) {
        this.conversationFm.showOptionMenu(true);
      }
    }
    AppMethodBeat.o(38215);
  }
  
  public void setCustomTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(256698);
    this.title = paramCharSequence;
    if (this.mActionBarHelper != null) {
      updateTitle(paramCharSequence);
    }
    AppMethodBeat.o(256698);
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(38219);
    this.title = paramString;
    if (this.mActionBarHelper != null) {
      updateTitle(paramString);
    }
    AppMethodBeat.o(38219);
  }
  
  public void startChatting(String paramString)
  {
    AppMethodBeat.i(38207);
    startChatting(paramString, null, false);
    AppMethodBeat.o(38207);
  }
  
  public void startChatting(String paramString, Bundle paramBundle, boolean paramBoolean)
  {
    AppMethodBeat.i(38208);
    startChatting(paramString, paramBundle, paramBoolean, true);
    AppMethodBeat.o(38208);
  }
  
  public void startChatting(String paramString, Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(256667);
    if (this.chattingView == null) {}
    for (boolean bool = false;; bool = this.chattingView.isShown())
    {
      Log.i("MicroMsg.BaseConversationUI", "try startChatting, ishow:%b, post: %b", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(paramBoolean2) });
      this.pendingBundle = paramBundle;
      this.pendingUser = paramString;
      this.mNeedChattingAnim = paramBoolean1;
      if (!paramBoolean2) {
        break;
      }
      bh.baH().setLowestPriority();
      MMHandlerThread.setCurrentPriority(-8);
      MMHandlerThread.removeRunnable(this.startChattingRunnable);
      MMHandlerThread.postToMainThread(this.startChattingRunnable);
      AppMethodBeat.o(256667);
      return;
    }
    this.startChattingRunnable.run();
    AppMethodBeat.o(256667);
  }
  
  protected void startChattingViewAnimation()
  {
    AppMethodBeat.i(256660);
    Log.i("MicroMsg.BaseConversationUI", "alvinluo startChattingViewAnimation");
    initChattingInAnimation();
    if (this.chattingFragmet.getSwipeBackLayout() != null)
    {
      this.chattingFragmet.getSwipeBackLayout().startAnimation(this.mChattingInAnim);
      AppMethodBeat.o(256660);
      return;
    }
    this.chattingFragmet.getView().startAnimation(this.mChattingInAnim);
    AppMethodBeat.o(256660);
  }
  
  public void updateTitle(String paramString)
  {
    AppMethodBeat.i(256692);
    if (this.mActionBarHelper != null) {
      this.mActionBarHelper.setTitle(aa.getDisplayName(paramString));
    }
    AppMethodBeat.o(256692);
  }
  
  class b
    implements Runnable
  {
    int adIW = 0;
    int hPm;
    Intent hPn;
    int resultCode;
    
    private b() {}
    
    public void run()
    {
      AppMethodBeat.i(38193);
      if (bh.baz())
      {
        Log.i("MicroMsg.BaseConversationUI", "on post select image job, acc has ready, retry count %d", new Object[] { Integer.valueOf(this.adIW) });
        BaseConversationUI.this.startChatting(BaseConversationUI.this.lastRestoreTalker);
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            boolean bool = true;
            AppMethodBeat.i(38191);
            if (BaseConversationUI.this.chattingFragmet == null) {}
            for (;;)
            {
              Log.d("MicroMsg.BaseConversationUI", "on select image ActivityResult. after creat chattingUI, chatting fragment is null? %B", new Object[] { Boolean.valueOf(bool) });
              if (BaseConversationUI.this.chattingFragmet != null)
              {
                Log.d("MicroMsg.BaseConversationUI", "on select image ActivityResult. do post activity result");
                BaseConversationUI.this.chattingFragmet.onActivityResult(BaseConversationUI.b.this.hPm & 0xFFFF, BaseConversationUI.b.this.resultCode, BaseConversationUI.b.this.hPn);
              }
              AppMethodBeat.o(38191);
              return;
              bool = false;
            }
          }
          
          public final String toString()
          {
            AppMethodBeat.i(38192);
            String str = super.toString() + "|PostSelectImageJob_onActivityResult";
            AppMethodBeat.o(38192);
            return str;
          }
        });
        AppMethodBeat.o(38193);
        return;
      }
      if (this.adIW >= 3)
      {
        Log.w("MicroMsg.BaseConversationUI", "on post select image job, match max retry count");
        AppMethodBeat.o(38193);
        return;
      }
      Log.w("MicroMsg.BaseConversationUI", "on post select image job, acc not ready, cur retry count %d", new Object[] { Integer.valueOf(this.adIW) });
      this.adIW += 1;
      MMHandlerThread.postToMainThreadDelayed(this, 300L);
      AppMethodBeat.o(38193);
    }
    
    public String toString()
    {
      AppMethodBeat.i(38194);
      String str = super.toString() + "|PostSelectImageJob";
      AppMethodBeat.o(38194);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.BaseConversationUI
 * JD-Core Version:    0.7.0.1
 */
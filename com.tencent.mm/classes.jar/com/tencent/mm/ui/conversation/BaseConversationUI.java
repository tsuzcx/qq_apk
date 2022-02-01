package com.tencent.mm.ui.conversation;

import android.annotation.TargetApi;
import android.app.Activity;
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
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az;
import com.tencent.mm.model.v;
import com.tencent.mm.pluginsdk.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.HomeUI.FitSystemWindowLayoutView;
import com.tencent.mm.ui.IChattingUIProxy;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.MMFragmentActivity.a;
import com.tencent.mm.ui.b.c;
import com.tencent.mm.ui.base.OnLayoutChangedLinearLayout;
import com.tencent.mm.ui.base.OnLayoutChangedLinearLayout.a;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ChattingUIFragment;
import com.tencent.mm.ui.chatting.ChattingUIProxy;
import com.tencent.mm.ui.tools.TestTimeForChatting;
import com.tencent.mm.ui.tools.TestTimeForChatting.a;
import com.tencent.mm.ui.tools.j;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.ui.widget.h;

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
  public BaseConversationFmUI conversationFm;
  private boolean isAnimating;
  private String lastRestoreTalker;
  private a launcherUIStatus;
  private ActionBar mActionBar;
  private com.tencent.mm.ui.a mActionBarHelper;
  public boolean mChattingClosed;
  private Animation mChattingInAnim;
  private Animation mChattingOutAnim;
  private boolean mNeedChattingAnim;
  private Bitmap mPrepareBitmap;
  private OnLayoutChangedLinearLayout.a onChattingLayoutChangedListener;
  Bundle pendingBundle;
  String pendingUser;
  private b selectImageJob;
  Runnable startChattingRunnable;
  private String title;
  
  public BaseConversationUI()
  {
    AppMethodBeat.i(38195);
    this.chattinguiResumeTime = 0L;
    this.launcherUIStatus = a.Haw;
    this.mNeedChattingAnim = false;
    this.mChattingClosed = true;
    this.chattingID = -1;
    this.onChattingLayoutChangedListener = new OnLayoutChangedLinearLayout.a()
    {
      long start = 0L;
      
      public final void eRF()
      {
        AppMethodBeat.i(38173);
        if (BaseConversationUI.this.mChattingInAnim == null)
        {
          BaseConversationUI.access$702(BaseConversationUI.this, AnimationUtils.loadAnimation(BaseConversationUI.this, MMFragmentActivity.a.lLF));
          BaseConversationUI.this.mChattingInAnim.setAnimationListener(new Animation.AnimationListener()
          {
            public final void onAnimationEnd(Animation paramAnonymous2Animation)
            {
              AppMethodBeat.i(38171);
              BaseConversationUI.access$802(BaseConversationUI.this, false);
              ad.i("MicroMsg.BaseConversationUI", "klem animationEnd");
              BaseConversationUI.access$1000(BaseConversationUI.this);
              AppMethodBeat.o(38171);
            }
            
            public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
            
            public final void onAnimationStart(Animation paramAnonymous2Animation)
            {
              AppMethodBeat.i(38170);
              ad.i("MicroMsg.BaseConversationUI", "klem onAnimationStart onDrawed->onAnimationStart:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - BaseConversationUI.6.this.start) });
              BaseConversationUI.access$802(BaseConversationUI.this, true);
              BaseConversationUI.access$900(BaseConversationUI.this);
              BaseConversationUI.this.onSettle(false, 0);
              AppMethodBeat.o(38170);
            }
          });
        }
        if (BaseConversationUI.this.mNeedChattingAnim)
        {
          BaseConversationUI.this.chattingView.setOndispatchDraw(new TestTimeForChatting.a()
          {
            public final void eRG()
            {
              AppMethodBeat.i(38172);
              ad.i("MicroMsg.BaseConversationUI", "[onDrawed]");
              BaseConversationUI.6.this.start = System.currentTimeMillis();
              if (BaseConversationUI.this.chattingFragmet == null)
              {
                ad.e("MicroMsg.BaseConversationUI", "chattingFragmet is null!");
                AppMethodBeat.o(38172);
                return;
              }
              if (BaseConversationUI.this.chattingFragmet.getSwipeBackLayout() != null) {
                BaseConversationUI.this.chattingFragmet.getSwipeBackLayout().startAnimation(BaseConversationUI.this.mChattingInAnim);
              }
              for (;;)
              {
                BaseConversationUI.this.chattingView.setOndispatchDraw(null);
                AppMethodBeat.o(38172);
                return;
                BaseConversationUI.this.chattingFragmet.getView().startAnimation(BaseConversationUI.this.mChattingInAnim);
              }
            }
          });
          BaseConversationUI.access$1102(BaseConversationUI.this, false);
        }
        for (;;)
        {
          BaseConversationUI.this.chattingFragmentView.GcZ = null;
          ad.i("MicroMsg.BaseConversationUI", "klem CHATTING ONLAYOUT ");
          AppMethodBeat.o(38173);
          return;
          BaseConversationUI.access$900(BaseConversationUI.this);
          BaseConversationUI.access$1000(BaseConversationUI.this);
        }
      }
    };
    this.startChattingRunnable = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(38177);
        if (!BaseConversationUI.this.mChattingClosed)
        {
          ad.e("MicroMsg.BaseConversationUI", "start chatting but last chatting does't be close!");
          BaseConversationUI.this.closeChatting(false);
        }
        if ((BaseConversationUI.this.isFinishing()) || (BaseConversationUI.this.isPaused()) || (!BaseConversationUI.this.mChattingClosed))
        {
          ad.w("MicroMsg.BaseConversationUI", "[startChattingRunnable] pass! isPause:%s mChattingClosed:%s", new Object[] { Boolean.valueOf(BaseConversationUI.this.isPaused()), Boolean.valueOf(BaseConversationUI.this.mChattingClosed) });
          AppMethodBeat.o(38177);
          return;
        }
        BaseConversationUI.this.mChattingClosed = false;
        boolean bool;
        if (BaseConversationUI.this.chattingView == null)
        {
          bool = false;
          ad.i("MicroMsg.BaseConversationUI", "ashutest::startChatting, ishow:%b", new Object[] { Boolean.valueOf(bool) });
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
            h.a(BaseConversationUI.this);
          }
          com.tencent.mm.sdk.g.b.c(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(38176);
              if (BaseConversationUI.this.chattingFragmet != null)
              {
                com.tencent.mm.modelstat.d.c(4, BaseConversationUI.this.getLocalClassName(), BaseConversationUI.this.hashCode());
                com.tencent.mm.modelstat.d.c(3, "ChattingUI" + BaseConversationUI.this.chattingFragmet.getIdentityString(), BaseConversationUI.this.chattingFragmet.hashCode());
              }
              AppMethodBeat.o(38176);
            }
          }, "directReport_startChattingRunnable");
          BaseConversationUI.access$402(BaseConversationUI.this, bt.aGK());
          AppMethodBeat.o(38177);
          return;
          bool = BaseConversationUI.this.chattingView.isShown();
          break;
        }
      }
      
      public final String toString()
      {
        AppMethodBeat.i(38178);
        String str = super.toString() + "|startChattingRunnable";
        AppMethodBeat.o(38178);
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
    ad.w("MicroMsg.BaseConversationUI", "check request code %d", new Object[] { Integer.valueOf(paramInt) });
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
    Object localObject3;
    final ViewGroup localViewGroup;
    Object localObject1;
    int i;
    if (this.chattingView == null)
    {
      if (!this.chattingFragmet.isSupportCustomActionBar())
      {
        this.chattingView = ((TestTimeForChatting)findViewById(2131298053));
        this.chattingID = this.chattingView.getId();
        AppMethodBeat.o(38210);
        return;
      }
      localObject2 = new int[2];
      getSupportActionBar().getCustomView().getLocationInWindow((int[])localObject2);
      localObject3 = new TestTimeForChatting(this);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      ((TestTimeForChatting)localObject3).setId(2131298080);
      this.chattingID = ((TestTimeForChatting)localObject3).getId();
      ((TestTimeForChatting)localObject3).setOrientation(1);
      ((TestTimeForChatting)localObject3).setLayoutParams(localLayoutParams);
      final HomeUI.FitSystemWindowLayoutView localFitSystemWindowLayoutView = new HomeUI.FitSystemWindowLayoutView(this);
      localFitSystemWindowLayoutView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
      localViewGroup = findRootContainer();
      localObject1 = localViewGroup;
      if (localViewGroup == null) {
        localObject1 = ((ViewGroup)getWindow().getDecorView()).getChildAt(0);
      }
      if ((localObject1 instanceof SwipeBackLayout))
      {
        localViewGroup = (ViewGroup)((ViewGroup)localObject1).getChildAt(0);
        ImageView localImageView = new ImageView(this);
        localImageView.setId(2131303386);
        localImageView.setLayoutParams(localLayoutParams);
        localImageView.setVisibility(8);
        ((ViewGroup)getWindow().getDecorView()).removeView((View)localObject1);
        ((View)localObject1).setId(2131301337);
        localFitSystemWindowLayoutView.addView((View)localObject1);
        localFitSystemWindowLayoutView.addView(localImageView);
        localFitSystemWindowLayoutView.addView((View)localObject3);
        ((ViewGroup)getWindow().getDecorView()).addView(localFitSystemWindowLayoutView);
        getWindow().getDecorView().requestFitSystemWindows();
        i = localObject2[1];
        if (i <= 0) {
          break label366;
        }
        updateRootViewSystemWindowsInsets(localFitSystemWindowLayoutView, i, new Rect(0, i, 0, 0), localViewGroup);
      }
      for (;;)
      {
        this.chattingView = ((TestTimeForChatting)findViewById(this.chattingID));
        ad.i("MicroMsg.BaseConversationUI", "ashu::prepareChattingFragment init chattingView, top %s", new Object[] { Integer.valueOf(localObject2[1]) });
        AppMethodBeat.o(38210);
        return;
        localViewGroup = (ViewGroup)localObject1;
        break;
        label366:
        getSupportActionBar().getCustomView().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(38175);
            BaseConversationUI.this.getSupportActionBar().getCustomView().getLocationInWindow(this.FRs);
            int i = this.FRs[1];
            if (i > 0)
            {
              BaseConversationUI.access$1300(BaseConversationUI.this, localFitSystemWindowLayoutView, i, new Rect(0, i, 0, 0), localViewGroup);
              AppMethodBeat.o(38175);
              return;
            }
            if (com.tencent.mm.compatible.util.d.lf(20)) {
              localFitSystemWindowLayoutView.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener()
              {
                @TargetApi(20)
                public final WindowInsets onApplyWindowInsets(View paramAnonymous2View, WindowInsets paramAnonymous2WindowInsets)
                {
                  AppMethodBeat.i(38174);
                  if (paramAnonymous2WindowInsets == null)
                  {
                    AppMethodBeat.o(38174);
                    return paramAnonymous2WindowInsets;
                  }
                  ad.i("MicroMsg.BaseConversationUI", "OnApplyWindowInsetsListener %s", new Object[] { paramAnonymous2WindowInsets });
                  paramAnonymous2WindowInsets.consumeSystemWindowInsets();
                  BaseConversationUI.access$1300(BaseConversationUI.this, BaseConversationUI.7.this.FRt, paramAnonymous2WindowInsets.getSystemWindowInsetTop(), new Rect(paramAnonymous2WindowInsets.getSystemWindowInsetLeft(), paramAnonymous2WindowInsets.getSystemWindowInsetTop(), paramAnonymous2WindowInsets.getSystemWindowInsetRight(), paramAnonymous2WindowInsets.getSystemWindowInsetBottom()), BaseConversationUI.7.this.FRu);
                  AppMethodBeat.o(38174);
                  return paramAnonymous2WindowInsets;
                }
              });
            }
            AppMethodBeat.o(38175);
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
          break label682;
        }
        getSupportActionBar().getCustomView().getLocationInWindow((int[])localObject1);
        localObject2 = (HomeUI.FitSystemWindowLayoutView)localObject2;
        ((HomeUI.FitSystemWindowLayoutView)localObject2).fitSystemWindows(new Rect(0, ((HomeUI.FitSystemWindowLayoutView)localObject2).getCacheInsetsTop(), 0, 0));
        ad.i("MicroMsg.BaseConversationUI", "rootLayout2 fitSystemWindows, top %s", new Object[] { Integer.valueOf(localObject1[1]) });
        localViewGroup = (ViewGroup)localViewGroup.findViewById(2131301337);
        localObject2 = (ImageView)((HomeUI.FitSystemWindowLayoutView)localObject2).findViewById(2131303386);
        ((ImageView)localObject2).setTag(localViewGroup);
        localObject3 = localViewGroup.getLayoutParams();
        if ((localObject3 == null) || ((localObject3 instanceof FrameLayout.LayoutParams))) {
          break label663;
        }
        ad.w("MicroMsg.BaseConversationUI", "FIX LayoutParams");
        ((ImageView)localObject2).setLayoutParams(new FrameLayout.LayoutParams((ViewGroup.LayoutParams)localObject3));
        localObject3 = getMagicDrawingCache(localViewGroup);
        if (localObject3 == null) {
          break label673;
        }
        ((ImageView)localObject2).setImageBitmap((Bitmap)localObject3);
        localViewGroup.setVisibility(8);
        ((ImageView)localObject2).setVisibility(0);
        ad.i("MicroMsg.BaseConversationUI", "[prepareChattingFragment] prepareView VISIBLE");
      }
      for (;;)
      {
        ad.i("MicroMsg.BaseConversationUI", "ashu::prepareChattingFragment has chattingView, top %s", new Object[] { Integer.valueOf(localObject1[1]) });
        AppMethodBeat.o(38210);
        return;
        label663:
        ((ImageView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
        break;
        label673:
        ((ImageView)localObject2).setImageBitmap(null);
      }
      label682:
      ad.e("MicroMsg.BaseConversationUI", "on position %d, rootLayout not found!", new Object[] { Integer.valueOf(i) });
      i += 1;
    }
  }
  
  private void doJobOnChattingAnimEnd()
  {
    AppMethodBeat.i(38205);
    aq.n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(38168);
        az.afE().eFR();
        aq.Wk(0);
        BaseConversationUI.this.onSwipe(1.0F);
        if ((BaseConversationUI.this.chattingView != null) && (BaseConversationUI.this.chattingFragmet != null)) {
          BaseConversationUI.this.chattingView.fed();
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
    this.chattingView.fec();
    AppMethodBeat.o(38204);
  }
  
  private ViewGroup findRootContainer()
  {
    AppMethodBeat.i(38213);
    Object localObject1 = this.mActionBar.getCustomView().getParent();
    Object localObject2 = null;
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
    if ((this.chattingFragmet != null) && (this.chattingFragmet.cOd.ctF))
    {
      ad.w("MicroMsg.BaseConversationUI", "[initActionBar] isChattingForeground True!");
      AppMethodBeat.o(38217);
      return;
    }
    ad.w("MicroMsg.BaseConversationUI", "[initActionBar] isChattingForeground False!");
    View localView = com.tencent.mm.ui.y.js(this).inflate(2131492921, null);
    this.mActionBarHelper = new com.tencent.mm.ui.a(localView);
    this.mActionBar.setLogo(new ColorDrawable(getResources().getColor(17170445)));
    this.mActionBar.fM();
    this.mActionBar.setDisplayHomeAsUpEnabled(false);
    this.mActionBar.fL();
    this.mActionBar.fN();
    this.mActionBar.setCustomView(localView);
    updateTitle();
    this.mActionBarHelper.e(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(38165);
        if (BaseConversationUI.this.isAnimating)
        {
          AppMethodBeat.o(38165);
          return;
        }
        aq.az(BaseConversationUI.this.startChattingRunnable);
        BaseConversationUI.this.finish();
        AppMethodBeat.o(38165);
      }
    });
    if (this.mActionBar.getCustomView() != null)
    {
      this.mActionBar.getCustomView().findViewById(2131296940);
      ((TextView)this.mActionBar.getCustomView().findViewById(2131305908)).setTextColor(getResources().getColor(2131100021));
    }
    AppMethodBeat.o(38217);
  }
  
  @TargetApi(19)
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
        this.chattingFragmet.getArguments().putAll(com.tencent.mm.sdk.platformtools.y.be(paramIntent));
      }
      if (bool)
      {
        this.chattingUIProxy.onInit(this.chattingID, paramBoolean);
        this.chattingFragmentView = ((OnLayoutChangedLinearLayout)this.chattingFragmet.getView().findViewById(2131298066));
      }
      for (;;)
      {
        if (this.chattingFragmet.isSupportNavigationSwipeBack()) {
          this.chattingFragmet.getSwipeBackLayout().setNeedRequestActivityTranslucent(false);
        }
        ad.i("MicroMsg.BaseConversationUI", "ashu::prepareChattingFragment use %dms, needInit %B, Intent %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Boolean.valueOf(bool), paramIntent });
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
      j.x(paramView, 0.0F);
      j.x(paramImageView, 0.0F);
      AppMethodBeat.o(38202);
      return;
    }
    if ((paramImageView != null) && (paramImageView.getDrawable() != null))
    {
      j.x(paramImageView, paramImageView.getWidth() / 4 * (1.0F - paramFloat) * -1.0F);
      AppMethodBeat.o(38202);
      return;
    }
    j.x(paramView, paramView.getWidth() / 4 * (1.0F - paramFloat) * -1.0F);
    AppMethodBeat.o(38202);
  }
  
  private void tryResetChattingSwipeStatus()
  {
    boolean bool = true;
    AppMethodBeat.i(38206);
    if ((!com.tencent.mm.compatible.util.d.lf(19)) || (!com.tencent.mm.compatible.g.b.XE()))
    {
      AppMethodBeat.o(38206);
      return;
    }
    if (this.chattingFragmet == null) {}
    for (;;)
    {
      ad.i("MicroMsg.BaseConversationUI", "ashutest: tryResetChattingSwipeStatus, chattingFragment NULL ? %B", new Object[] { Boolean.valueOf(bool) });
      if (this.chattingFragmet != null) {
        this.chattingFragmet.getSwipeBackLayout().HBY = false;
      }
      AppMethodBeat.o(38206);
      return;
      bool = false;
    }
  }
  
  private void updateRootViewSystemWindowsInsets(HomeUI.FitSystemWindowLayoutView paramFitSystemWindowLayoutView, int paramInt, Rect paramRect, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(38212);
    int j = getWindow().getDecorView().getBottom();
    int k = getSupportActionBar().getCustomView().getBottom();
    if ((this.conversationFm != null) && (this.conversationFm.getView() != null)) {}
    for (int i = j - (paramInt + k + this.conversationFm.getView().getBottom());; i = 0)
    {
      ad.i("MicroMsg.BaseConversationUI", "ashu::fitSystemWindows 2. decorBottom:%d, statusBarHeight:%d, actionBarHeight:%d, paddingForNavBar:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(paramInt), Integer.valueOf(k), Integer.valueOf(i) });
      paramFitSystemWindowLayoutView.setActionBarContainer(paramViewGroup);
      paramFitSystemWindowLayoutView.fitSystemWindows(paramRect);
      AppMethodBeat.o(38212);
      return;
    }
  }
  
  public void closeChatting(boolean paramBoolean)
  {
    AppMethodBeat.i(38216);
    if (this.chattingView == null) {}
    for (boolean bool = false;; bool = this.chattingView.isShown())
    {
      ad.i("MicroMsg.BaseConversationUI", "try closeChatting, ishow:%b", new Object[] { Boolean.valueOf(bool) });
      if ((this.chattingFragmet != null) && (this.chattingFragmet.isSupportNavigationSwipeBack())) {
        h.b(this);
      }
      if ((this.chattingView != null) && (this.chattingView.getVisibility() != 8) && (this.chattingFragmet != null)) {
        break;
      }
      AppMethodBeat.o(38216);
      return;
    }
    ad.i("MicroMsg.BaseConversationUI", "[closeChatting] needAnim:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.chattingView.setVisibility(8);
    this.mChattingClosed = true;
    if ((paramBoolean) && (this.mChattingOutAnim == null))
    {
      this.mChattingOutAnim = AnimationUtils.loadAnimation(this, MMFragmentActivity.a.lLI);
      this.mChattingOutAnim.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(38180);
          az.afE().eFR();
          aq.Wk(0);
          BaseConversationUI.access$600(BaseConversationUI.this);
          ad.i("MicroMsg.BaseConversationUI", "klem pop out onAnimationEnd");
          AppMethodBeat.o(38180);
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(38179);
          az.afE().eFP();
          aq.Wk(-8);
          ad.i("MicroMsg.BaseConversationUI", "klem pop out onAnimationStart");
          BaseConversationUI.this.onSettle(true, 0);
          AppMethodBeat.o(38179);
        }
      });
    }
    if (this.chattingFragmet.isSupportCustomActionBar())
    {
      ImageView localImageView = (ImageView)getWindow().getDecorView().findViewById(2131303386);
      if ((localImageView != null) && (localImageView.getVisibility() == 0))
      {
        localImageView.setVisibility(8);
        ad.i("MicroMsg.BaseConversationUI", "[closeChatting] prepareView GONE");
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
      com.tencent.mm.sdk.g.b.c(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(38181);
          if (BaseConversationUI.this.chattingFragmet == null)
          {
            AppMethodBeat.o(38181);
            return;
          }
          com.tencent.mm.modelstat.d.c(4, "ChattingUI" + BaseConversationUI.access$000(BaseConversationUI.this), BaseConversationUI.this.chattingFragmet.hashCode());
          com.tencent.mm.modelstat.d.p("ChattingUI" + BaseConversationUI.access$000(BaseConversationUI.this), BaseConversationUI.this.chattinguiResumeTime, bt.aGK());
          com.tencent.mm.modelstat.d.c(3, BaseConversationUI.this.getLocalClassName(), BaseConversationUI.this.hashCode());
          AppMethodBeat.o(38181);
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
    ad.d("MicroMsg.BaseConversationUI", "chatting ui dispatch key event %s", new Object[] { paramKeyEvent });
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0)) {
      aq.az(this.startChattingRunnable);
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
          ad.e("MicroMsg.BaseConversationUI", "viewWidth:%s viewHeight:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          AppMethodBeat.o(38211);
          return null;
        }
        if (this.chattingFragmet != null) {
          ad.i("MicroMsg.BaseConversationUI", "getBottom:%s keyboardState:%s", new Object[] { Integer.valueOf(this.chattingFragmet.getView().getBottom()), Integer.valueOf(this.chattingFragmet.keyboardState()) });
        }
        if ((this.chattingFragmet != null) && (this.chattingFragmet.getView().getBottom() > 0) && ((this.chattingFragmet.keyboardState() == 1) || (this.chattingFragmet.getView().getBottom() < getResources().getDisplayMetrics().heightPixels * 2 / 3)))
        {
          ad.e("MicroMsg.BaseConversationUI", "hardKeyboardHidden:%s", new Object[] { Integer.valueOf(this.chattingFragmet.keyboardState()) });
          AppMethodBeat.o(38211);
          return null;
        }
        if ((this.chattingFragmet != null) && (this.chattingFragmet.keyboardState() == 1))
        {
          ad.e("MicroMsg.BaseConversationUI", "hardKeyboardHidden:%s", new Object[] { Integer.valueOf(this.chattingFragmet.keyboardState()) });
          AppMethodBeat.o(38211);
          return null;
        }
        if ((this.mPrepareBitmap == null) || (this.mPrepareBitmap.isRecycled()) || (this.mPrepareBitmap.getWidth() != i) || (this.mPrepareBitmap.getHeight() != j)) {
          if ((this.mPrepareBitmap != null) && (!this.mPrepareBitmap.isRecycled()))
          {
            ad.i("MicroMsg.BaseConversationUI", "bitmap recycle %s", new Object[] { this.mPrepareBitmap.toString() });
            this.mPrepareBitmap.recycle();
          }
        }
        for (;;)
        {
          try
          {
            this.mPrepareBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_4444);
            Canvas localCanvas = new Canvas(this.mPrepareBitmap);
            int k = (int)getResources().getDimension(2131167019);
            int m = (int)getResources().getDimension(2131165256);
            Paint localPaint = new Paint();
            localPaint.setColor(-1);
            localCanvas.drawRect(0.0F, k, i, j - m, localPaint);
            paramView.draw(localCanvas);
            ad.i("MicroMsg.BaseConversationUI", "[getMagicDrawingCache] cost%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
            paramView = this.mPrepareBitmap;
            AppMethodBeat.o(38211);
            return paramView;
          }
          catch (OutOfMemoryError paramView)
          {
            ad.e("MicroMsg.BaseConversationUI", "[getMagicDrawingCache] e:%s", new Object[] { paramView });
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
      ad.i("MicroMsg.BaseConversationUI", "on select image ActivityResult. the chattingUI maybe kill in the background.");
      aq.az(this.selectImageJob);
      this.selectImageJob.FRx = 0;
      this.selectImageJob.requestCode = paramInt1;
      this.selectImageJob.bRZ = paramInt2;
      this.selectImageJob.doc = paramIntent;
      aq.f(this.selectImageJob);
      AppMethodBeat.o(38203);
      return;
    }
    AppMethodBeat.o(38203);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(38196);
    getWindow().setFormat(-2);
    g.aJ(this);
    super.onCreate(paramBundle);
    if (!b.fbV()) {
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
      ad.i("MicroMsg.BaseConversationUI", "bitmap recycle %s", new Object[] { this.mPrepareBitmap.toString() });
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
    ad.i("MicroMsg.BaseConversationUI", "onNewIntent");
    setIntent(paramIntent);
    AppMethodBeat.o(38197);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(38199);
    ad.i("MicroMsg.BaseConversationUI", "on pause");
    super.onPause();
    if (!isFinishing()) {
      h.a(this);
    }
    this.launcherUIStatus = a.Hay;
    if ((this.chattingView != null) && (this.chattingView.isShown())) {}
    for (final boolean bool = true;; bool = false)
    {
      com.tencent.mm.sdk.g.b.c(new Runnable()
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
            com.tencent.mm.modelstat.d.c(4, str, i);
            if (bool) {
              com.tencent.mm.modelstat.d.p("ChattingUI" + BaseConversationUI.access$000(BaseConversationUI.this), BaseConversationUI.this.chattinguiResumeTime, bt.aGK());
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
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(38222);
    super.onRestoreInstanceState(paramBundle);
    this.lastRestoreTalker = paramBundle.getString("last_restore_talker");
    ad.d("MicroMsg.BaseConversationUI", "onRestoreInstantceState:%s", new Object[] { this.lastRestoreTalker });
    AppMethodBeat.o(38222);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(38198);
    super.onResume();
    h.b(this);
    onSwipe(1.0F);
    this.launcherUIStatus = a.Hax;
    if ((this.chattingView != null) && (this.chattingView.isShown())) {}
    for (final boolean bool = true;; bool = false)
    {
      com.tencent.mm.sdk.g.b.c(new Runnable()
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
            com.tencent.mm.modelstat.d.c(3, str, i);
            AppMethodBeat.o(38164);
            return;
            str = BaseConversationUI.this.getLocalClassName();
            break;
          }
        }
      }, "directReport_onResume");
      if (!bool) {
        this.chattinguiResumeTime = bt.aGK();
      }
      if ((com.tencent.mm.compatible.util.d.lf(19)) && (com.tencent.mm.compatible.g.b.XE()))
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
              if ((BaseConversationUI.this.conversationFm == null) || (bt.isNullOrNil(BaseConversationUI.this.conversationFm.getUserName()))) {
                break label127;
              }
            }
            label127:
            for (Object localObject = BaseConversationUI.this.conversationFm.getUserName();; localObject = com.tencent.mm.model.u.aqG())
            {
              localObject = new Intent().putExtra("Chat_User", (String)localObject);
              BaseConversationUI.access$300(BaseConversationUI.this, (Intent)localObject, true);
              BaseConversationUI.this.chattingView.setVisibility(8);
              BaseConversationUI.this.resumeMainFragment();
              ad.d("MicroMsg.BaseConversationUI", "prepare chattingUI logic use %dms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
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
    if ((this.chattingFragmet != null) && (!bt.isNullOrNil(this.chattingFragmet.cOd.getTalkerUserName())))
    {
      ad.d("MicroMsg.BaseConversationUI", "onSaveInstanceState:%s", new Object[] { this.chattingFragmet.cOd.getTalkerUserName() });
      paramBundle.putString("last_restore_talker", this.chattingFragmet.cOd.getTalkerUserName());
    }
    AppMethodBeat.o(38223);
  }
  
  public void onSettle(boolean paramBoolean, int paramInt)
  {
    long l = 130L;
    AppMethodBeat.i(38224);
    ad.v("MicroMsg.BaseConversationUI", "ashutest: on settle %B, speed %d, resumeStatus %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), this.launcherUIStatus });
    if ((!com.tencent.mm.compatible.util.d.lf(19)) || (!com.tencent.mm.compatible.g.b.XE()))
    {
      AppMethodBeat.o(38224);
      return;
    }
    View localView = findViewById(2131301337);
    if (localView == null)
    {
      ad.e("MicroMsg.BaseConversationUI", "[onSettle] null == container");
      AppMethodBeat.o(38224);
      return;
    }
    ImageView localImageView = (ImageView)findViewById(2131303386);
    if ((localImageView != null) && (localImageView.getVisibility() == 8) && (localImageView.getDrawable() != null))
    {
      localImageView.setVisibility(0);
      ad.i("MicroMsg.BaseConversationUI", "[onSettle] prepareView VISIBLE");
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
          AppMethodBeat.o(38224);
          return;
          l = 230L;
        }
      }
      if (paramInt > 0) {}
      for (;;)
      {
        j.a(localImageView, l, localImageView.getWidth() * -1 / 4, null);
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
        j.a(localView, l, 0.0F, null);
        AppMethodBeat.o(38224);
        return;
        l = 230L;
      }
    }
    if (paramInt > 0) {}
    for (;;)
    {
      j.a(localView, l, localView.getWidth() * -1 / 4, null);
      AppMethodBeat.o(38224);
      return;
      l = 230L;
    }
  }
  
  public void onSwipe(float paramFloat)
  {
    AppMethodBeat.i(38201);
    ad.v("MicroMsg.BaseConversationUI", "ashutest::on swipe %f, duration %d, status %s", new Object[] { Float.valueOf(paramFloat), Long.valueOf(260L), this.launcherUIStatus });
    if ((!com.tencent.mm.compatible.util.d.lf(19)) || (!com.tencent.mm.compatible.g.b.XE()))
    {
      AppMethodBeat.o(38201);
      return;
    }
    if (this.chattingFragmet == null)
    {
      ad.e("MicroMsg.BaseConversationUI", "chattingFragmet is null!");
      AppMethodBeat.o(38201);
      return;
    }
    if ((paramFloat == 0.0F) && (!this.mChattingClosed))
    {
      localObject1 = (ImageView)getWindow().getDecorView().findViewById(2131303386);
      if (localObject1 != null)
      {
        localObject2 = (ViewGroup)((ImageView)localObject1).getTag();
        if (localObject2 != null)
        {
          ad.i("MicroMsg.BaseConversationUI", "[onSwipe] prepareView GONE");
          ((ViewGroup)localObject2).setVisibility(0);
          ((ImageView)localObject1).setVisibility(8);
          ((ImageView)localObject1).setImageDrawable(null);
        }
      }
      if (this.mChattingInAnim != null) {
        this.mChattingInAnim.cancel();
      }
    }
    while ((a.Hax != this.launcherUIStatus) && (Float.compare(1.0F, paramFloat) > 0))
    {
      ad.i("MicroMsg.BaseConversationUI", "[onSwipe] return! consumedSuperCall:%s", new Object[] { Float.valueOf(paramFloat) });
      AppMethodBeat.o(38201);
      return;
      if ((paramFloat == 1.0F) && (!this.mChattingClosed) && (this.chattingFragmet.isSupportNavigationSwipeBack()))
      {
        getWindow().setBackgroundDrawableResource(2131100810);
        localObject1 = (ImageView)getWindow().getDecorView().findViewById(2131303386);
        if ((localObject1 != null) && (((ImageView)localObject1).getVisibility() == 0) && (((ImageView)localObject1).getTag() != null))
        {
          ((View)((ImageView)localObject1).getTag()).setVisibility(0);
          ad.i("MicroMsg.BaseConversationUI", "[onSwipe] prepareView GONE");
          ((ImageView)localObject1).setVisibility(8);
        }
      }
    }
    Object localObject1 = findViewById(2131301337);
    Object localObject2 = (ImageView)findViewById(2131303386);
    if ((localObject2 != null) && (((ImageView)localObject2).getVisibility() == 8) && (((ImageView)localObject2).getDrawable() != null) && (!this.mChattingClosed) && (paramFloat != 1.0F) && (paramFloat != 0.0F))
    {
      ((ImageView)localObject2).setVisibility(0);
      ad.i("MicroMsg.BaseConversationUI", "[onSwipe] !1 && !0 prepareView VISIBLE");
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
    if ((this.chattingFragmet == null) || (this.chattingFragmet.eUV() == null) || (!this.chattingFragmet.isSupportCustomActionBar()))
    {
      AppMethodBeat.o(38220);
      return null;
    }
    if (com.tencent.mm.compatible.util.d.lh(22))
    {
      AppMethodBeat.o(38220);
      return null;
    }
    paramCallback = this.chattingFragmet.eUV().startActionMode(paramCallback);
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
    if ((this.conversationFm != null) && (!this.conversationFm.isSupportNavigationSwipeBack())) {
      this.conversationFm.showOptionMenu(false);
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
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(38219);
    this.title = paramString;
    if (this.mActionBarHelper != null) {
      updateTitle();
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
    if (this.chattingView == null) {}
    for (boolean bool = false;; bool = this.chattingView.isShown())
    {
      ad.i("MicroMsg.BaseConversationUI", "try startChatting, ishow:%b", new Object[] { Boolean.valueOf(bool) });
      this.pendingBundle = paramBundle;
      this.pendingUser = paramString;
      this.mNeedChattingAnim = paramBoolean;
      az.afE().eFP();
      aq.Wk(-8);
      aq.az(this.startChattingRunnable);
      aq.f(this.startChattingRunnable);
      AppMethodBeat.o(38208);
      return;
    }
  }
  
  public void updateTitle()
  {
    AppMethodBeat.i(38218);
    if (this.mActionBarHelper != null) {
      this.mActionBarHelper.setTitle(v.sh(this.title));
    }
    AppMethodBeat.o(38218);
  }
  
  public static class BaseConversationFmUI
    extends MMFragment
  {
    private BaseConversationUI.a fmStatus = BaseConversationUI.a.Haw;
    public BaseConversationUI ui;
    
    public void finish()
    {
      AppMethodBeat.i(38187);
      thisActivity().finish();
      AppMethodBeat.o(38187);
    }
    
    public int getLayoutId()
    {
      return 0;
    }
    
    public String getUserName()
    {
      return null;
    }
    
    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
    {
      AppMethodBeat.i(38185);
      this.fmStatus = BaseConversationUI.a.Haw;
      this.ui = ((BaseConversationUI)thisActivity());
      paramLayoutInflater = paramLayoutInflater.inflate(getLayoutId(), paramViewGroup, false);
      setHasOptionsMenu(true);
      AppMethodBeat.o(38185);
      return paramLayoutInflater;
    }
    
    public void onDestroy()
    {
      AppMethodBeat.i(38190);
      if (this.fmStatus != BaseConversationUI.a.Hay)
      {
        ad.w("MicroMsg.BaseConversationUI", "fmStatus != ActivityStatus.ACTIVITY_PAUSE when fm onDestroy");
        onPause();
      }
      super.onDestroy();
      AppMethodBeat.o(38190);
    }
    
    public void onPause()
    {
      AppMethodBeat.i(38189);
      super.onPause();
      this.fmStatus = BaseConversationUI.a.Hay;
      AppMethodBeat.o(38189);
    }
    
    public void onResume()
    {
      AppMethodBeat.i(38188);
      super.onResume();
      this.fmStatus = BaseConversationUI.a.Hax;
      AppMethodBeat.o(38188);
    }
    
    public void setMMTitle(String paramString)
    {
      AppMethodBeat.i(38186);
      if (this.ui != null) {
        this.ui.setTitle(paramString);
      }
      AppMethodBeat.o(38186);
    }
  }
  
  static enum a
  {
    static
    {
      AppMethodBeat.i(38184);
      Haw = new a("ACTIVITY_CREATE", 0);
      Hax = new a("ACTIVITY_RESUME", 1);
      Hay = new a("ACTIVITY_PAUSE", 2);
      Haz = new a[] { Haw, Hax, Hay };
      AppMethodBeat.o(38184);
    }
    
    private a() {}
  }
  
  final class b
    implements Runnable
  {
    int FRx = 0;
    int bRZ;
    Intent doc;
    int requestCode;
    
    private b() {}
    
    public final void run()
    {
      AppMethodBeat.i(38193);
      if (az.afw())
      {
        ad.i("MicroMsg.BaseConversationUI", "on post select image job, acc has ready, retry count %d", new Object[] { Integer.valueOf(this.FRx) });
        BaseConversationUI.this.startChatting(BaseConversationUI.this.lastRestoreTalker);
        aq.f(new Runnable()
        {
          public final void run()
          {
            boolean bool = true;
            AppMethodBeat.i(38191);
            if (BaseConversationUI.this.chattingFragmet == null) {}
            for (;;)
            {
              ad.d("MicroMsg.BaseConversationUI", "on select image ActivityResult. after creat chattingUI, chatting fragment is null? %B", new Object[] { Boolean.valueOf(bool) });
              if (BaseConversationUI.this.chattingFragmet != null)
              {
                ad.d("MicroMsg.BaseConversationUI", "on select image ActivityResult. do post activity result");
                BaseConversationUI.this.chattingFragmet.onActivityResult(BaseConversationUI.b.this.requestCode & 0xFFFF, BaseConversationUI.b.this.bRZ, BaseConversationUI.b.this.doc);
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
      if (this.FRx >= 3)
      {
        ad.w("MicroMsg.BaseConversationUI", "on post select image job, match max retry count");
        AppMethodBeat.o(38193);
        return;
      }
      ad.w("MicroMsg.BaseConversationUI", "on post select image job, acc not ready, cur retry count %d", new Object[] { Integer.valueOf(this.FRx) });
      this.FRx += 1;
      aq.n(this, 300L);
      AppMethodBeat.o(38193);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(38194);
      String str = super.toString() + "|PostSelectImageJob";
      AppMethodBeat.o(38194);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.BaseConversationUI
 * JD-Core Version:    0.7.0.1
 */
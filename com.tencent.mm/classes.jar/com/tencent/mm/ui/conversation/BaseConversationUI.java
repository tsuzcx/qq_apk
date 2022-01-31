package com.tencent.mm.ui.conversation;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.support.v7.app.ActionBar;
import android.util.DisplayMetrics;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.model.au;
import com.tencent.mm.model.r;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.HomeUI.FitSystemWindowLayoutView;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.MMFragmentActivity.a;
import com.tencent.mm.ui.b.c;
import com.tencent.mm.ui.base.OnLayoutChangedLinearLayout;
import com.tencent.mm.ui.base.OnLayoutChangedLinearLayout.a;
import com.tencent.mm.ui.chatting.aa;
import com.tencent.mm.ui.n;
import com.tencent.mm.ui.tools.TestTimeForChatting;
import com.tencent.mm.ui.tools.h;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import com.tencent.mm.ui.widget.g;

public class BaseConversationUI
  extends MMFragmentActivity
{
  private static final String LAST_RESTORE_TALKER = "last_restore_talker";
  static final String TAG = "MicroMsg.BaseConversationUI";
  private OnLayoutChangedLinearLayout chattingFragmentView;
  private com.tencent.mm.ui.chatting.y chattingFragmet;
  private int chattingID = -1;
  private n chattingUIProxy;
  private TestTimeForChatting chattingView;
  private long chattinguiResumeTime = 0L;
  public BaseConversationUI.b conversationFm;
  private boolean isAnimating;
  private String lastRestoreTalker;
  private BaseConversationUI.a launcherUIStatus = BaseConversationUI.a.vPm;
  private ActionBar mActionBar;
  private com.tencent.mm.ui.b mActionBarHelper;
  public boolean mChattingClosed = true;
  private Animation mChattingInAnim;
  private Animation mChattingOutAnim;
  private boolean mNeedChattingAnim = false;
  private Bitmap mPrepareBitmap;
  private OnLayoutChangedLinearLayout.a onChattingLayoutChangedListener = new BaseConversationUI.6(this);
  Bundle pendingBundle;
  String pendingUser;
  private BaseConversationUI.c selectImageJob = new BaseConversationUI.c(this, (byte)0);
  Runnable startChattingRunnable = new BaseConversationUI.8(this);
  private String title;
  
  private boolean acceptRequestCode(int paramInt)
  {
    boolean bool = true;
    paramInt = 0xFFFF & paramInt;
    com.tencent.mm.sdk.platformtools.y.w("MicroMsg.BaseConversationUI", "check request code %d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    default: 
      bool = false;
    }
    return bool;
  }
  
  private void createChattingView()
  {
    if (this.chattingView == null) {
      if (!this.chattingFragmet.isSupportCustomActionBar())
      {
        this.chattingView = ((TestTimeForChatting)findViewById(R.h.chatting_area));
        this.chattingID = this.chattingView.getId();
      }
    }
    Object localObject2;
    Object localObject3;
    ViewGroup localViewGroup;
    int i;
    label353:
    while (!this.chattingFragmet.isSupportCustomActionBar())
    {
      return;
      localObject2 = new int[2];
      getSupportActionBar().getCustomView().getLocationInWindow((int[])localObject2);
      localObject3 = new TestTimeForChatting(this);
      localObject1 = new FrameLayout.LayoutParams(-1, -1);
      ((TestTimeForChatting)localObject3).setId(R.h.chatting_custom_container);
      this.chattingID = ((TestTimeForChatting)localObject3).getId();
      ((TestTimeForChatting)localObject3).setOrientation(1);
      ((TestTimeForChatting)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      HomeUI.FitSystemWindowLayoutView localFitSystemWindowLayoutView = new HomeUI.FitSystemWindowLayoutView(this);
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
        localImageView.setId(R.h.prepare_imageview);
        localImageView.setLayoutParams(((TestTimeForChatting)localObject3).getLayoutParams());
        localImageView.setVisibility(8);
        ((ViewGroup)getWindow().getDecorView()).removeView((View)localObject1);
        ((View)localObject1).setId(R.h.launcher_container);
        localFitSystemWindowLayoutView.addView((View)localObject1);
        localFitSystemWindowLayoutView.addView(localImageView);
        localFitSystemWindowLayoutView.addView((View)localObject3);
        ((ViewGroup)getWindow().getDecorView()).addView(localFitSystemWindowLayoutView);
        getWindow().getDecorView().requestFitSystemWindows();
        i = localObject2[1];
        if (i <= 0) {
          break label353;
        }
        updateRootViewSystemWindowsInsets(localFitSystemWindowLayoutView, i, new Rect(0, i, 0, 0), localViewGroup);
      }
      for (;;)
      {
        this.chattingView = ((TestTimeForChatting)findViewById(this.chattingID));
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BaseConversationUI", "ashu::prepareChattingFragment init chattingView, top %s", new Object[] { Integer.valueOf(localObject2[1]) });
        return;
        localViewGroup = (ViewGroup)localObject1;
        break;
        getSupportActionBar().getCustomView().post(new BaseConversationUI.7(this, (int[])localObject2, localFitSystemWindowLayoutView, localViewGroup));
      }
    }
    Object localObject1 = new int[2];
    this.chattingView.getLocationInWindow((int[])localObject1);
    if (localObject1[1] == 0)
    {
      localViewGroup = (ViewGroup)getWindow().getDecorView();
      i = 0;
    }
    for (;;)
    {
      if (i < localViewGroup.getChildCount())
      {
        localObject2 = ((ViewGroup)getWindow().getDecorView()).getChildAt(i);
        if (!(localObject2 instanceof HomeUI.FitSystemWindowLayoutView)) {
          break label622;
        }
        getSupportActionBar().getCustomView().getLocationInWindow((int[])localObject1);
        localObject2 = (HomeUI.FitSystemWindowLayoutView)localObject2;
        ((HomeUI.FitSystemWindowLayoutView)localObject2).fitSystemWindows(new Rect(0, ((HomeUI.FitSystemWindowLayoutView)localObject2).getCacheInsetsTop(), 0, 0));
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BaseConversationUI", "rootLayout2 fitSystemWindows, top %s", new Object[] { Integer.valueOf(localObject1[1]) });
        localViewGroup = (ViewGroup)localViewGroup.findViewById(R.h.launcher_container);
        localObject2 = (ImageView)((HomeUI.FitSystemWindowLayoutView)localObject2).findViewById(R.h.prepare_imageview);
        ((ImageView)localObject2).setTag(localViewGroup);
        ((ImageView)localObject2).setLayoutParams(localViewGroup.getLayoutParams());
        localObject3 = getMagicDrawingCache(localViewGroup);
        if (localObject3 == null) {
          break label613;
        }
        ((ImageView)localObject2).setImageBitmap((Bitmap)localObject3);
        localViewGroup.setVisibility(8);
        ((ImageView)localObject2).setVisibility(0);
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BaseConversationUI", "[prepareChattingFragment] prepareView VISIBLE");
      }
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BaseConversationUI", "ashu::prepareChattingFragment has chattingView, top %s", new Object[] { Integer.valueOf(localObject1[1]) });
        return;
        label613:
        ((ImageView)localObject2).setImageBitmap(null);
      }
      label622:
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.BaseConversationUI", "on position %d, rootLayout not found!", new Object[] { Integer.valueOf(i) });
      i += 1;
    }
  }
  
  private void doJobOnChattingAnimEnd()
  {
    ai.l(new BaseConversationUI.5(this), 60L);
  }
  
  private void doJobOnChattingAnimStart()
  {
    this.chattingView.setTranslationX(0.0F);
    this.chattingView.cJl();
  }
  
  private ViewGroup findRootContainer()
  {
    Object localObject1 = this.mActionBar.getCustomView().getParent();
    Object localObject2 = null;
    ViewGroup localViewGroup = (ViewGroup)getWindow().getDecorView();
    while ((localObject1 != localViewGroup) && (localObject1 != null))
    {
      ViewParent localViewParent = ((ViewParent)localObject1).getParent();
      localObject2 = localObject1;
      localObject1 = localViewParent;
    }
    return (ViewGroup)localObject2;
  }
  
  private String getIdentityString()
  {
    if (this.chattingFragmet != null) {
      return this.chattingFragmet.getIdentityString();
    }
    return "";
  }
  
  private void initActionBar()
  {
    if ((this.chattingFragmet != null) && (this.chattingFragmet.byx.euf)) {
      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.BaseConversationUI", "[initActionBar] isChattingForeground True!");
    }
    boolean bool;
    do
    {
      return;
      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.BaseConversationUI", "[initActionBar] isChattingForeground False!");
      localObject = com.tencent.mm.ui.y.gt(this).inflate(R.i.actionbar_custom_area, null);
      this.mActionBarHelper = new com.tencent.mm.ui.b((View)localObject);
      this.mActionBar.setLogo(new ColorDrawable(getResources().getColor(17170445)));
      this.mActionBar.dZ();
      this.mActionBar.setDisplayHomeAsUpEnabled(false);
      this.mActionBar.dY();
      this.mActionBar.ea();
      this.mActionBar.setCustomView((View)localObject);
      updateTitle();
      this.mActionBarHelper.d(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          if (BaseConversationUI.this.isAnimating) {
            return;
          }
          ai.S(BaseConversationUI.this.startChattingRunnable);
          BaseConversationUI.this.finish();
        }
      });
      bool = ae.getContext().getSharedPreferences(ae.cqR() + "_redesign", 4).getBoolean("dark_actionbar", false);
    } while (this.mActionBar.getCustomView() == null);
    Object localObject = (ImageView)this.mActionBar.getCustomView().findViewById(R.h.arrow_area_btn);
    if (bool) {
      ((ImageView)localObject).setColorFilter(-1, PorterDuff.Mode.SRC_ATOP);
    }
    localObject = (TextView)this.mActionBar.getCustomView().findViewById(R.h.title_area);
    if (bool)
    {
      ((TextView)localObject).setTextColor(getResources().getColor(R.e.white_text_color));
      return;
    }
    ((TextView)localObject).setTextColor(getResources().getColor(R.e.black_text_color));
  }
  
  @TargetApi(19)
  private void prepareChattingFragment(Intent paramIntent, boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    if (this.chattingFragmet == null)
    {
      this.chattingFragmet = getChattingUIFragment();
      this.chattingUIProxy = new aa(this, this.chattingFragmet);
    }
    for (boolean bool = true;; bool = false)
    {
      createChattingView();
      if (paramIntent != null) {
        this.chattingFragmet.getArguments().putAll(com.tencent.mm.sdk.platformtools.t.al(paramIntent));
      }
      if (bool)
      {
        this.chattingUIProxy.ao(this.chattingID, paramBoolean);
        this.chattingFragmentView = ((OnLayoutChangedLinearLayout)this.chattingFragmet.getView().findViewById(R.h.chatting_bg_ll));
      }
      for (;;)
      {
        if (this.chattingFragmet.isSupportNavigationSwipeBack()) {
          this.chattingFragmet.getSwipeBackLayout().setNeedRequestActivityTranslucent(false);
        }
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BaseConversationUI", "ashu::prepareChattingFragment use %dms, needInit %B, Intent %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Boolean.valueOf(bool), paramIntent });
        return;
        this.chattingUIProxy.cyT();
      }
    }
  }
  
  private void resetViewTranX(View paramView, ImageView paramImageView, float paramFloat)
  {
    if (Float.compare(1.0F, paramFloat) <= 0)
    {
      h.q(paramView, 0.0F);
      h.q(paramImageView, 0.0F);
      return;
    }
    if ((paramImageView != null) && (paramImageView.getDrawable() != null))
    {
      h.q(paramImageView, paramImageView.getWidth() / 4 * (1.0F - paramFloat) * -1.0F);
      return;
    }
    h.q(paramView, paramView.getWidth() / 4 * (1.0F - paramFloat) * -1.0F);
  }
  
  private void tryResetChattingSwipeStatus()
  {
    boolean bool = true;
    if ((!com.tencent.mm.compatible.util.d.gF(19)) || (!com.tencent.mm.compatible.i.a.zD())) {
      return;
    }
    if (this.chattingFragmet == null) {}
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BaseConversationUI", "ashutest: tryResetChattingSwipeStatus, chattingFragment NULL ? %B", new Object[] { Boolean.valueOf(bool) });
      if (this.chattingFragmet == null) {
        break;
      }
      this.chattingFragmet.getSwipeBackLayout().wlh = false;
      return;
      bool = false;
    }
  }
  
  private void updateRootViewSystemWindowsInsets(HomeUI.FitSystemWindowLayoutView paramFitSystemWindowLayoutView, int paramInt, Rect paramRect, ViewGroup paramViewGroup)
  {
    int j = getWindow().getDecorView().getBottom();
    int k = getSupportActionBar().getCustomView().getBottom();
    if ((this.conversationFm != null) && (this.conversationFm.getView() != null)) {}
    for (int i = j - (paramInt + k + this.conversationFm.getView().getBottom());; i = 0)
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BaseConversationUI", "ashu::fitSystemWindows 2. decorBottom:%d, statusBarHeight:%d, actionBarHeight:%d, paddingForNavBar:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(paramInt), Integer.valueOf(k), Integer.valueOf(i) });
      paramFitSystemWindowLayoutView.setActionBarContainer(paramViewGroup);
      paramFitSystemWindowLayoutView.fitSystemWindows(paramRect);
      return;
    }
  }
  
  public void closeChatting(boolean paramBoolean)
  {
    if (this.chattingView == null) {}
    for (boolean bool = false;; bool = this.chattingView.isShown())
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BaseConversationUI", "try closeChatting, ishow:%b", new Object[] { Boolean.valueOf(bool) });
      if ((this.chattingFragmet != null) && (this.chattingFragmet.isSupportNavigationSwipeBack())) {
        g.b(this);
      }
      if ((this.chattingView != null) && (this.chattingView.getVisibility() != 8) && (this.chattingFragmet != null)) {
        break;
      }
      return;
    }
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BaseConversationUI", "[closeChatting] needAnim:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.chattingView.setVisibility(8);
    this.mChattingClosed = true;
    if (this.mChattingOutAnim == null)
    {
      this.mChattingOutAnim = AnimationUtils.loadAnimation(this, MMFragmentActivity.a.uOh);
      this.mChattingOutAnim.setAnimationListener(new BaseConversationUI.9(this));
    }
    if (this.chattingFragmet.isSupportCustomActionBar())
    {
      ImageView localImageView = (ImageView)getWindow().getDecorView().findViewById(R.h.prepare_imageview);
      if ((localImageView != null) && (localImageView.getVisibility() == 0))
      {
        localImageView.setVisibility(8);
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BaseConversationUI", "[closeChatting] prepareView GONE");
        if (localImageView.getTag() != null) {
          ((View)localImageView.getTag()).setVisibility(0);
        }
      }
    }
    if (paramBoolean)
    {
      this.chattingUIProxy.cyV();
      this.chattingUIProxy.cyW();
      this.chattingView.startAnimation(this.mChattingOutAnim);
    }
    for (;;)
    {
      if (!this.chattingFragmet.isSupportCustomActionBar()) {
        initActionBar();
      }
      supportInvalidateOptionsMenu();
      resumeMainFragment();
      com.tencent.mm.sdk.f.e.post(new BaseConversationUI.10(this), "directReport_closeChatting");
      return;
      this.chattingUIProxy.cyV();
      this.chattingUIProxy.cyW();
      this.chattingView.setVisibility(8);
      onSwipe(1.0F);
      tryResetChattingSwipeStatus();
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.BaseConversationUI", "chatting ui dispatch key event %s", new Object[] { paramKeyEvent });
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0)) {
      ai.S(this.startChattingRunnable);
    }
    if (this.isAnimating) {}
    while ((this.chattingFragmet != null) && (this.chattingFragmet.onKeyDown(paramKeyEvent.getKeyCode(), paramKeyEvent))) {
      return true;
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  protected com.tencent.mm.ui.chatting.y getChattingUIFragment()
  {
    return new com.tencent.mm.ui.chatting.y();
  }
  
  public Bitmap getMagicDrawingCache(View paramView)
  {
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
        if ((i <= 0) || (j <= 0))
        {
          com.tencent.mm.sdk.platformtools.y.e("MicroMsg.BaseConversationUI", "viewWidth:%s viewHeight:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          return null;
        }
        if (this.chattingFragmet != null) {
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BaseConversationUI", "getBottom:%s keyboardState:%s", new Object[] { Integer.valueOf(this.chattingFragmet.getView().getBottom()), Integer.valueOf(this.chattingFragmet.keyboardState()) });
        }
        if ((this.chattingFragmet != null) && (this.chattingFragmet.getView().getBottom() > 0) && ((this.chattingFragmet.keyboardState() == 1) || (this.chattingFragmet.getView().getBottom() < getResources().getDisplayMetrics().heightPixels * 2 / 3)))
        {
          com.tencent.mm.sdk.platformtools.y.e("MicroMsg.BaseConversationUI", "hardKeyboardHidden:%s", new Object[] { Integer.valueOf(this.chattingFragmet.keyboardState()) });
          return null;
        }
        if ((this.chattingFragmet != null) && (this.chattingFragmet.keyboardState() == 1))
        {
          com.tencent.mm.sdk.platformtools.y.e("MicroMsg.BaseConversationUI", "hardKeyboardHidden:%s", new Object[] { Integer.valueOf(this.chattingFragmet.keyboardState()) });
          return null;
        }
        if ((this.mPrepareBitmap == null) || (this.mPrepareBitmap.isRecycled()) || (this.mPrepareBitmap.getWidth() != i) || (this.mPrepareBitmap.getHeight() != j)) {
          if ((this.mPrepareBitmap != null) && (!this.mPrepareBitmap.isRecycled())) {
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
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BaseConversationUI", "[getMagicDrawingCache] cost%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
            return this.mPrepareBitmap;
          }
          catch (OutOfMemoryError paramView)
          {
            com.tencent.mm.sdk.platformtools.y.e("MicroMsg.BaseConversationUI", "[getMagicDrawingCache] e:%s", new Object[] { paramView });
            return null;
          }
          this.mPrepareBitmap.eraseColor(0);
        }
      }
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.conversationFm != null) {
      this.conversationFm.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    if (paramInt2 != -1) {}
    do
    {
      return;
      if ((paramInt1 == 2001) && (this.chattingFragmet != null)) {
        this.chattingFragmet.onActivityResult(paramInt1, paramInt2, paramIntent);
      }
    } while ((!acceptRequestCode(paramInt1)) || (this.chattingFragmet != null));
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BaseConversationUI", "on select image ActivityResult. the chattingUI maybe kill in the background.");
    ai.S(this.selectImageJob);
    this.selectImageJob.uQe = 0;
    this.selectImageJob.bQU = paramInt1;
    this.selectImageJob.aYY = paramInt2;
    this.selectImageJob.bQV = paramIntent;
    ai.d(this.selectImageJob);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    getWindow().setFormat(-2);
    com.tencent.mm.pluginsdk.e.S(this);
    super.onCreate(paramBundle);
    if (!b.cHU()) {
      getWindow().setCallback(new c(getWindow().getCallback(), this));
    }
    this.mActionBar = getSupportActionBar();
    initNavigationSwipeBack();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if ((this.mPrepareBitmap != null) && (!this.mPrepareBitmap.isRecycled())) {
      this.mPrepareBitmap.recycle();
    }
    this.chattingFragmet = null;
    this.chattingFragmentView = null;
    this.chattingView = null;
    this.conversationFm = null;
    this.mActionBarHelper = null;
    this.mChattingInAnim = null;
    this.mChattingOutAnim = null;
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BaseConversationUI", "onNewIntent");
    setIntent(paramIntent);
  }
  
  protected void onPause()
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BaseConversationUI", "on pause");
    super.onPause();
    if (!isFinishing()) {
      g.a(this);
    }
    this.launcherUIStatus = BaseConversationUI.a.vPo;
    if ((this.chattingView != null) && (this.chattingView.isShown())) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.sdk.f.e.post(new BaseConversationUI.4(this, bool), "directReport_onPause");
      if ((this.chattingFragmet != null) && (this.chattingFragmet.isSupportNavigationSwipeBack())) {
        this.chattingFragmet.getSwipeBackLayout().setEnableGesture(false);
      }
      return;
    }
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    super.onRestoreInstanceState(paramBundle);
    this.lastRestoreTalker = paramBundle.getString("last_restore_talker");
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.BaseConversationUI", "onRestoreInstantceState:%s", new Object[] { this.lastRestoreTalker });
  }
  
  protected void onResume()
  {
    super.onResume();
    g.b(this);
    onSwipe(1.0F);
    this.launcherUIStatus = BaseConversationUI.a.vPn;
    if ((this.chattingView != null) && (this.chattingView.isShown())) {}
    for (final boolean bool = true;; bool = false)
    {
      com.tencent.mm.sdk.f.e.post(new Runnable()
      {
        public final void run()
        {
          String str;
          if (bool)
          {
            str = "ChattingUI" + BaseConversationUI.this.getIdentityString();
            if (!bool) {
              break label66;
            }
          }
          label66:
          for (int i = BaseConversationUI.this.chattingFragmet.hashCode();; i = BaseConversationUI.this.hashCode())
          {
            com.tencent.mm.modelstat.d.b(3, str, i);
            return;
            str = BaseConversationUI.this.getLocalClassName();
            break;
          }
        }
      }, "directReport_onResume");
      if (!bool) {
        this.chattinguiResumeTime = bk.UX();
      }
      if ((com.tencent.mm.compatible.util.d.gF(19)) && (com.tencent.mm.compatible.i.a.zD()))
      {
        if ((this.chattingFragmet != null) && (this.chattingFragmet.isSupportNavigationSwipeBack())) {
          this.chattingFragmet.getSwipeBackLayout().setEnableGesture(true);
        }
        Looper.myQueue().addIdleHandler(new BaseConversationUI.3(this));
      }
      initActionBar();
      this.mActionBar.show();
      return;
    }
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    if ((this.chattingFragmet != null) && (!bk.bl(this.chattingFragmet.byx.getTalkerUserName())))
    {
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.BaseConversationUI", "onSaveInstanceState:%s", new Object[] { this.chattingFragmet.byx.getTalkerUserName() });
      paramBundle.putString("last_restore_talker", this.chattingFragmet.byx.getTalkerUserName());
    }
  }
  
  public void onSettle(boolean paramBoolean, int paramInt)
  {
    long l = 110L;
    com.tencent.mm.sdk.platformtools.y.v("MicroMsg.BaseConversationUI", "ashutest: on settle %B, speed %d, resumeStatus %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), this.launcherUIStatus });
    if ((!com.tencent.mm.compatible.util.d.gF(19)) || (!com.tencent.mm.compatible.i.a.zD())) {
      return;
    }
    View localView = findViewById(R.h.launcher_container);
    if (localView == null)
    {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.BaseConversationUI", "[onSettle] null == container");
      return;
    }
    ImageView localImageView = (ImageView)findViewById(R.h.prepare_imageview);
    if ((localImageView != null) && (localImageView.getVisibility() == 8) && (localImageView.getDrawable() != null))
    {
      localImageView.setVisibility(0);
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BaseConversationUI", "[onSettle] prepareView VISIBLE");
      localView.setVisibility(8);
    }
    if ((localImageView != null) && (localImageView.getVisibility() == 0))
    {
      if (paramBoolean)
      {
        if (paramInt > 0) {}
        for (;;)
        {
          h.a(localImageView, l, 0.0F, 0.125F);
          return;
          l = 220L;
        }
      }
      if (paramInt > 0) {}
      for (;;)
      {
        h.a(localImageView, l, localImageView.getWidth() * -1 / 4, 0.75F);
        return;
        l = 220L;
      }
    }
    if (paramBoolean)
    {
      if (paramInt > 0) {}
      for (;;)
      {
        h.a(localView, l, 0.0F, 0.125F);
        return;
        l = 220L;
      }
    }
    if (paramInt > 0) {}
    for (;;)
    {
      h.a(localView, l, localView.getWidth() * -1 / 4, 0.75F);
      return;
      l = 220L;
    }
  }
  
  public void onSwipe(float paramFloat)
  {
    com.tencent.mm.sdk.platformtools.y.v("MicroMsg.BaseConversationUI", "ashutest::on swipe %f, duration %d, status %s", new Object[] { Float.valueOf(paramFloat), Long.valueOf(220L), this.launcherUIStatus });
    if ((!com.tencent.mm.compatible.util.d.gF(19)) || (!com.tencent.mm.compatible.i.a.zD())) {
      return;
    }
    if ((paramFloat == 0.0F) && (!this.mChattingClosed))
    {
      localObject1 = (ImageView)getWindow().getDecorView().findViewById(R.h.prepare_imageview);
      if (localObject1 != null)
      {
        localObject2 = (ViewGroup)((ImageView)localObject1).getTag();
        if (localObject2 != null)
        {
          Bitmap localBitmap = getMagicDrawingCache((View)localObject2);
          if (localBitmap == null) {
            break label185;
          }
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BaseConversationUI", "[onSwipe] prepareView VISIBLE");
          ((ImageView)localObject1).setVisibility(0);
          ((ImageView)localObject1).setImageBitmap(localBitmap);
          ((ViewGroup)localObject2).setVisibility(8);
        }
      }
      if (this.mChattingInAnim != null) {
        this.mChattingInAnim.cancel();
      }
    }
    for (;;)
    {
      if ((BaseConversationUI.a.vPn == this.launcherUIStatus) || (Float.compare(1.0F, paramFloat) <= 0)) {
        break label315;
      }
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BaseConversationUI", "[onSwipe] return! consumedSuperCall:%s", new Object[] { Float.valueOf(paramFloat) });
      return;
      label185:
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BaseConversationUI", "[onSwipe] prepareView GONE");
      ((ViewGroup)localObject2).setVisibility(0);
      ((ImageView)localObject1).setVisibility(8);
      ((ImageView)localObject1).setImageDrawable(null);
      break;
      if ((paramFloat == 1.0F) && (!this.mChattingClosed) && (!this.mChattingClosed) && (this.chattingFragmet.isSupportNavigationSwipeBack()))
      {
        getWindow().setBackgroundDrawableResource(R.e.room_info_comment_layout_bg);
        localObject1 = (ImageView)getWindow().getDecorView().findViewById(R.h.prepare_imageview);
        if ((localObject1 != null) && (((ImageView)localObject1).getVisibility() == 0) && (((ImageView)localObject1).getTag() != null))
        {
          ((View)((ImageView)localObject1).getTag()).setVisibility(0);
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BaseConversationUI", "[onSwipe] prepareView GONE");
          ((ImageView)localObject1).setVisibility(8);
        }
      }
    }
    label315:
    Object localObject1 = findViewById(R.h.launcher_container);
    Object localObject2 = (ImageView)findViewById(R.h.prepare_imageview);
    if ((localObject2 != null) && (((ImageView)localObject2).getVisibility() == 8) && (((ImageView)localObject2).getDrawable() != null) && (!this.mChattingClosed) && (paramFloat != 1.0F) && (paramFloat != 0.0F))
    {
      ((ImageView)localObject2).setVisibility(0);
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BaseConversationUI", "[onSwipe] !1 && !0 prepareView VISIBLE");
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
    }
    resetViewTranX((View)localObject1, (ImageView)localObject2, paramFloat);
  }
  
  public ActionMode onWindowStartingActionMode(ActionMode.Callback paramCallback)
  {
    if ((this.chattingFragmet == null) || (this.chattingFragmet.cCn() == null) || (!this.chattingFragmet.isSupportCustomActionBar())) {}
    do
    {
      do
      {
        return null;
      } while (com.tencent.mm.compatible.util.d.gH(22));
      paramCallback = this.chattingFragmet.cCn().startActionMode(paramCallback);
    } while (paramCallback == null);
    return paramCallback;
  }
  
  public void pauseMainFragment()
  {
    if ((this.conversationFm != null) && (!this.conversationFm.isSupportNavigationSwipeBack())) {
      this.conversationFm.showOptionMenu(false);
    }
  }
  
  public void resumeMainFragment()
  {
    if (this.conversationFm != null)
    {
      this.conversationFm.onResume();
      if (!this.conversationFm.isSupportNavigationSwipeBack()) {
        this.conversationFm.showOptionMenu(true);
      }
    }
  }
  
  public void setTitle(String paramString)
  {
    this.title = paramString;
    if (this.mActionBarHelper != null) {
      updateTitle();
    }
  }
  
  public void startChatting(String paramString)
  {
    startChatting(paramString, null, false);
  }
  
  public void startChatting(String paramString, Bundle paramBundle, boolean paramBoolean)
  {
    if (this.chattingView == null) {}
    for (boolean bool = false;; bool = this.chattingView.isShown())
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BaseConversationUI", "try startChatting, ishow:%b", new Object[] { Boolean.valueOf(bool) });
      this.pendingBundle = paramBundle;
      this.pendingUser = paramString;
      this.mNeedChattingAnim = paramBoolean;
      au.DS().crc();
      ai.Fd(-8);
      ai.S(this.startChattingRunnable);
      ai.d(this.startChattingRunnable);
      return;
    }
  }
  
  public void updateTitle()
  {
    if (this.mActionBarHelper != null) {
      this.mActionBarHelper.setTitle(r.gV(this.title));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.BaseConversationUI
 * JD-Core Version:    0.7.0.1
 */
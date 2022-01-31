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
import android.support.v7.app.ActionBar;
import android.util.DisplayMetrics;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.pluginsdk.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.HomeUI.FitSystemWindowLayoutView;
import com.tencent.mm.ui.IChattingUIProxy;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.MMFragmentActivity.a;
import com.tencent.mm.ui.b.c;
import com.tencent.mm.ui.base.OnLayoutChangedLinearLayout;
import com.tencent.mm.ui.base.OnLayoutChangedLinearLayout.a;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ChattingUIFragment;
import com.tencent.mm.ui.chatting.ChattingUIProxy;
import com.tencent.mm.ui.tools.TestTimeForChatting;
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
  public BaseConversationUI.BaseConversationFmUI conversationFm;
  private boolean isAnimating;
  private String lastRestoreTalker;
  private BaseConversationUI.a launcherUIStatus;
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
  private BaseConversationUI.b selectImageJob;
  Runnable startChattingRunnable;
  private String title;
  
  public BaseConversationUI()
  {
    AppMethodBeat.i(34076);
    this.chattinguiResumeTime = 0L;
    this.launcherUIStatus = BaseConversationUI.a.AgX;
    this.mNeedChattingAnim = false;
    this.mChattingClosed = true;
    this.chattingID = -1;
    this.onChattingLayoutChangedListener = new BaseConversationUI.6(this);
    this.startChattingRunnable = new BaseConversationUI.8(this);
    this.selectImageJob = new BaseConversationUI.b(this, (byte)0);
    AppMethodBeat.o(34076);
  }
  
  private boolean acceptRequestCode(int paramInt)
  {
    AppMethodBeat.i(34102);
    paramInt = 0xFFFF & paramInt;
    ab.w("MicroMsg.BaseConversationUI", "check request code %d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(34102);
      return false;
    }
    AppMethodBeat.o(34102);
    return true;
  }
  
  private void createChattingView()
  {
    AppMethodBeat.i(34091);
    Object localObject2;
    Object localObject3;
    ViewGroup localViewGroup;
    Object localObject1;
    int i;
    if (this.chattingView == null)
    {
      if (!this.chattingFragmet.isSupportCustomActionBar())
      {
        this.chattingView = ((TestTimeForChatting)findViewById(2131821948));
        this.chattingID = this.chattingView.getId();
        AppMethodBeat.o(34091);
        return;
      }
      localObject2 = new int[2];
      getSupportActionBar().getCustomView().getLocationInWindow((int[])localObject2);
      localObject3 = new TestTimeForChatting(this);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      ((TestTimeForChatting)localObject3).setId(2131820581);
      this.chattingID = ((TestTimeForChatting)localObject3).getId();
      ((TestTimeForChatting)localObject3).setOrientation(1);
      ((TestTimeForChatting)localObject3).setLayoutParams(localLayoutParams);
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
        localImageView.setId(2131820649);
        localImageView.setLayoutParams(localLayoutParams);
        localImageView.setVisibility(8);
        ((ViewGroup)getWindow().getDecorView()).removeView((View)localObject1);
        ((View)localObject1).setId(2131820633);
        localFitSystemWindowLayoutView.addView((View)localObject1);
        localFitSystemWindowLayoutView.addView(localImageView);
        localFitSystemWindowLayoutView.addView((View)localObject3);
        ((ViewGroup)getWindow().getDecorView()).addView(localFitSystemWindowLayoutView);
        getWindow().getDecorView().requestFitSystemWindows();
        i = localObject2[1];
        if (i <= 0) {
          break label365;
        }
        updateRootViewSystemWindowsInsets(localFitSystemWindowLayoutView, i, new Rect(0, i, 0, 0), localViewGroup);
      }
      for (;;)
      {
        this.chattingView = ((TestTimeForChatting)findViewById(this.chattingID));
        ab.i("MicroMsg.BaseConversationUI", "ashu::prepareChattingFragment init chattingView, top %s", new Object[] { Integer.valueOf(localObject2[1]) });
        AppMethodBeat.o(34091);
        return;
        localViewGroup = (ViewGroup)localObject1;
        break;
        label365:
        getSupportActionBar().getCustomView().post(new BaseConversationUI.7(this, (int[])localObject2, localFitSystemWindowLayoutView, localViewGroup));
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
          break label681;
        }
        getSupportActionBar().getCustomView().getLocationInWindow((int[])localObject1);
        localObject2 = (HomeUI.FitSystemWindowLayoutView)localObject2;
        ((HomeUI.FitSystemWindowLayoutView)localObject2).fitSystemWindows(new Rect(0, ((HomeUI.FitSystemWindowLayoutView)localObject2).getCacheInsetsTop(), 0, 0));
        ab.i("MicroMsg.BaseConversationUI", "rootLayout2 fitSystemWindows, top %s", new Object[] { Integer.valueOf(localObject1[1]) });
        localViewGroup = (ViewGroup)localViewGroup.findViewById(2131820633);
        localObject2 = (ImageView)((HomeUI.FitSystemWindowLayoutView)localObject2).findViewById(2131820649);
        ((ImageView)localObject2).setTag(localViewGroup);
        localObject3 = localViewGroup.getLayoutParams();
        if ((localObject3 == null) || ((localObject3 instanceof FrameLayout.LayoutParams))) {
          break label662;
        }
        ab.w("MicroMsg.BaseConversationUI", "FIX LayoutParams");
        ((ImageView)localObject2).setLayoutParams(new FrameLayout.LayoutParams((ViewGroup.LayoutParams)localObject3));
        localObject3 = getMagicDrawingCache(localViewGroup);
        if (localObject3 == null) {
          break label672;
        }
        ((ImageView)localObject2).setImageBitmap((Bitmap)localObject3);
        localViewGroup.setVisibility(8);
        ((ImageView)localObject2).setVisibility(0);
        ab.i("MicroMsg.BaseConversationUI", "[prepareChattingFragment] prepareView VISIBLE");
      }
      for (;;)
      {
        ab.i("MicroMsg.BaseConversationUI", "ashu::prepareChattingFragment has chattingView, top %s", new Object[] { Integer.valueOf(localObject1[1]) });
        AppMethodBeat.o(34091);
        return;
        label662:
        ((ImageView)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
        break;
        label672:
        ((ImageView)localObject2).setImageBitmap(null);
      }
      label681:
      ab.e("MicroMsg.BaseConversationUI", "on position %d, rootLayout not found!", new Object[] { Integer.valueOf(i) });
      i += 1;
    }
  }
  
  private void doJobOnChattingAnimEnd()
  {
    AppMethodBeat.i(34086);
    al.p(new BaseConversationUI.5(this), 60L);
    AppMethodBeat.o(34086);
  }
  
  private void doJobOnChattingAnimStart()
  {
    AppMethodBeat.i(34085);
    this.chattingView.setTranslationX(0.0F);
    this.chattingView.dOb();
    AppMethodBeat.o(34085);
  }
  
  private ViewGroup findRootContainer()
  {
    AppMethodBeat.i(34094);
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
    AppMethodBeat.o(34094);
    return localObject1;
  }
  
  private String getIdentityString()
  {
    AppMethodBeat.i(34108);
    if (this.chattingFragmet != null)
    {
      String str = this.chattingFragmet.getIdentityString();
      AppMethodBeat.o(34108);
      return str;
    }
    AppMethodBeat.o(34108);
    return "";
  }
  
  private void initActionBar()
  {
    AppMethodBeat.i(34098);
    if ((this.chattingFragmet != null) && (this.chattingFragmet.caz.bSe))
    {
      ab.w("MicroMsg.BaseConversationUI", "[initActionBar] isChattingForeground True!");
      AppMethodBeat.o(34098);
      return;
    }
    ab.w("MicroMsg.BaseConversationUI", "[initActionBar] isChattingForeground False!");
    View localView = com.tencent.mm.ui.w.hM(this).inflate(2130968613, null);
    this.mActionBarHelper = new com.tencent.mm.ui.a(localView);
    this.mActionBar.setLogo(new ColorDrawable(getResources().getColor(17170445)));
    this.mActionBar.eu();
    this.mActionBar.setDisplayHomeAsUpEnabled(false);
    this.mActionBar.et();
    this.mActionBar.ev();
    this.mActionBar.setCustomView(localView);
    updateTitle();
    this.mActionBarHelper.b(new BaseConversationUI.2(this));
    if (this.mActionBar.getCustomView() != null)
    {
      this.mActionBar.getCustomView().findViewById(2131820980);
      ((TextView)this.mActionBar.getCustomView().findViewById(2131820981)).setTextColor(getResources().getColor(2131689766));
    }
    AppMethodBeat.o(34098);
  }
  
  @TargetApi(19)
  private void prepareChattingFragment(Intent paramIntent, boolean paramBoolean)
  {
    AppMethodBeat.i(34090);
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
        this.chattingFragmet.getArguments().putAll(com.tencent.mm.sdk.platformtools.w.aL(paramIntent));
      }
      if (bool)
      {
        this.chattingUIProxy.onInit(this.chattingID, paramBoolean);
        this.chattingFragmentView = ((OnLayoutChangedLinearLayout)this.chattingFragmet.getView().findViewById(2131821559));
      }
      for (;;)
      {
        if (this.chattingFragmet.isSupportNavigationSwipeBack()) {
          this.chattingFragmet.getSwipeBackLayout().setNeedRequestActivityTranslucent(false);
        }
        ab.i("MicroMsg.BaseConversationUI", "ashu::prepareChattingFragment use %dms, needInit %B, Intent %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Boolean.valueOf(bool), paramIntent });
        AppMethodBeat.o(34090);
        return;
        this.chattingUIProxy.onEnterBegin();
      }
    }
  }
  
  private void resetViewTranX(View paramView, ImageView paramImageView, float paramFloat)
  {
    AppMethodBeat.i(34083);
    if (Float.compare(1.0F, paramFloat) <= 0)
    {
      j.t(paramView, 0.0F);
      j.t(paramImageView, 0.0F);
      AppMethodBeat.o(34083);
      return;
    }
    if ((paramImageView != null) && (paramImageView.getDrawable() != null))
    {
      j.t(paramImageView, paramImageView.getWidth() / 4 * (1.0F - paramFloat) * -1.0F);
      AppMethodBeat.o(34083);
      return;
    }
    j.t(paramView, paramView.getWidth() / 4 * (1.0F - paramFloat) * -1.0F);
    AppMethodBeat.o(34083);
  }
  
  private void tryResetChattingSwipeStatus()
  {
    boolean bool = true;
    AppMethodBeat.i(34087);
    if ((!com.tencent.mm.compatible.util.d.fv(19)) || (!com.tencent.mm.compatible.i.b.Mg()))
    {
      AppMethodBeat.o(34087);
      return;
    }
    if (this.chattingFragmet == null) {}
    for (;;)
    {
      ab.i("MicroMsg.BaseConversationUI", "ashutest: tryResetChattingSwipeStatus, chattingFragment NULL ? %B", new Object[] { Boolean.valueOf(bool) });
      if (this.chattingFragmet != null) {
        this.chattingFragmet.getSwipeBackLayout().AEZ = false;
      }
      AppMethodBeat.o(34087);
      return;
      bool = false;
    }
  }
  
  private void updateRootViewSystemWindowsInsets(HomeUI.FitSystemWindowLayoutView paramFitSystemWindowLayoutView, int paramInt, Rect paramRect, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(34093);
    int j = getWindow().getDecorView().getBottom();
    int k = getSupportActionBar().getCustomView().getBottom();
    if ((this.conversationFm != null) && (this.conversationFm.getView() != null)) {}
    for (int i = j - (paramInt + k + this.conversationFm.getView().getBottom());; i = 0)
    {
      ab.i("MicroMsg.BaseConversationUI", "ashu::fitSystemWindows 2. decorBottom:%d, statusBarHeight:%d, actionBarHeight:%d, paddingForNavBar:%d", new Object[] { Integer.valueOf(j), Integer.valueOf(paramInt), Integer.valueOf(k), Integer.valueOf(i) });
      paramFitSystemWindowLayoutView.setActionBarContainer(paramViewGroup);
      paramFitSystemWindowLayoutView.fitSystemWindows(paramRect);
      AppMethodBeat.o(34093);
      return;
    }
  }
  
  public void closeChatting(boolean paramBoolean)
  {
    AppMethodBeat.i(34097);
    if (this.chattingView == null) {}
    for (boolean bool = false;; bool = this.chattingView.isShown())
    {
      ab.i("MicroMsg.BaseConversationUI", "try closeChatting, ishow:%b", new Object[] { Boolean.valueOf(bool) });
      if ((this.chattingFragmet != null) && (this.chattingFragmet.isSupportNavigationSwipeBack())) {
        h.b(this);
      }
      if ((this.chattingView != null) && (this.chattingView.getVisibility() != 8) && (this.chattingFragmet != null)) {
        break;
      }
      AppMethodBeat.o(34097);
      return;
    }
    ab.i("MicroMsg.BaseConversationUI", "[closeChatting] needAnim:%s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.chattingView.setVisibility(8);
    this.mChattingClosed = true;
    if ((paramBoolean) && (this.mChattingOutAnim == null))
    {
      this.mChattingOutAnim = AnimationUtils.loadAnimation(this, MMFragmentActivity.a.zca);
      this.mChattingOutAnim.setAnimationListener(new BaseConversationUI.9(this));
    }
    if (this.chattingFragmet.isSupportCustomActionBar())
    {
      ImageView localImageView = (ImageView)getWindow().getDecorView().findViewById(2131820649);
      if ((localImageView != null) && (localImageView.getVisibility() == 0))
      {
        localImageView.setVisibility(8);
        ab.i("MicroMsg.BaseConversationUI", "[closeChatting] prepareView GONE");
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
      com.tencent.mm.sdk.g.d.post(new BaseConversationUI.10(this), "directReport_closeChatting");
      AppMethodBeat.o(34097);
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
    AppMethodBeat.i(34106);
    ab.d("MicroMsg.BaseConversationUI", "chatting ui dispatch key event %s", new Object[] { paramKeyEvent });
    if ((paramKeyEvent.getKeyCode() == 4) && (paramKeyEvent.getAction() == 0)) {
      al.ae(this.startChattingRunnable);
    }
    if (this.isAnimating)
    {
      AppMethodBeat.o(34106);
      return true;
    }
    if ((this.chattingFragmet != null) && (this.chattingFragmet.onKeyDown(paramKeyEvent.getKeyCode(), paramKeyEvent)))
    {
      AppMethodBeat.o(34106);
      return true;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(34106);
    return bool;
  }
  
  protected ChattingUIFragment getChattingUIFragment()
  {
    AppMethodBeat.i(34107);
    ChattingUIFragment localChattingUIFragment = new ChattingUIFragment();
    AppMethodBeat.o(34107);
    return localChattingUIFragment;
  }
  
  public Bitmap getMagicDrawingCache(View paramView)
  {
    AppMethodBeat.i(34092);
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
          ab.e("MicroMsg.BaseConversationUI", "viewWidth:%s viewHeight:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
          AppMethodBeat.o(34092);
          return null;
        }
        if (this.chattingFragmet != null) {
          ab.i("MicroMsg.BaseConversationUI", "getBottom:%s keyboardState:%s", new Object[] { Integer.valueOf(this.chattingFragmet.getView().getBottom()), Integer.valueOf(this.chattingFragmet.keyboardState()) });
        }
        if ((this.chattingFragmet != null) && (this.chattingFragmet.getView().getBottom() > 0) && ((this.chattingFragmet.keyboardState() == 1) || (this.chattingFragmet.getView().getBottom() < getResources().getDisplayMetrics().heightPixels * 2 / 3)))
        {
          ab.e("MicroMsg.BaseConversationUI", "hardKeyboardHidden:%s", new Object[] { Integer.valueOf(this.chattingFragmet.keyboardState()) });
          AppMethodBeat.o(34092);
          return null;
        }
        if ((this.chattingFragmet != null) && (this.chattingFragmet.keyboardState() == 1))
        {
          ab.e("MicroMsg.BaseConversationUI", "hardKeyboardHidden:%s", new Object[] { Integer.valueOf(this.chattingFragmet.keyboardState()) });
          AppMethodBeat.o(34092);
          return null;
        }
        if ((this.mPrepareBitmap == null) || (this.mPrepareBitmap.isRecycled()) || (this.mPrepareBitmap.getWidth() != i) || (this.mPrepareBitmap.getHeight() != j)) {
          if ((this.mPrepareBitmap != null) && (!this.mPrepareBitmap.isRecycled()))
          {
            ab.i("MicroMsg.BaseConversationUI", "bitmap recycle %s", new Object[] { this.mPrepareBitmap.toString() });
            this.mPrepareBitmap.recycle();
          }
        }
        for (;;)
        {
          try
          {
            this.mPrepareBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_4444);
            Canvas localCanvas = new Canvas(this.mPrepareBitmap);
            int k = (int)getResources().getDimension(2131427359);
            int m = (int)getResources().getDimension(2131427563);
            Paint localPaint = new Paint();
            localPaint.setColor(-1);
            localCanvas.drawRect(0.0F, k, i, j - m, localPaint);
            paramView.draw(localCanvas);
            ab.i("MicroMsg.BaseConversationUI", "[getMagicDrawingCache] cost%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
            paramView = this.mPrepareBitmap;
            AppMethodBeat.o(34092);
            return paramView;
          }
          catch (OutOfMemoryError paramView)
          {
            ab.e("MicroMsg.BaseConversationUI", "[getMagicDrawingCache] e:%s", new Object[] { paramView });
            AppMethodBeat.o(34092);
            return null;
          }
          this.mPrepareBitmap.eraseColor(0);
        }
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(34084);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.conversationFm != null) {
      this.conversationFm.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    if (paramInt2 != -1)
    {
      AppMethodBeat.o(34084);
      return;
    }
    if ((paramInt1 == 2001) && (this.chattingFragmet != null)) {
      this.chattingFragmet.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    if ((acceptRequestCode(paramInt1)) && (this.chattingFragmet == null))
    {
      ab.i("MicroMsg.BaseConversationUI", "on select image ActivityResult. the chattingUI maybe kill in the background.");
      al.ae(this.selectImageJob);
      this.selectImageJob.zep = 0;
      this.selectImageJob.requestCode = paramInt1;
      this.selectImageJob.bpE = paramInt2;
      this.selectImageJob.cyu = paramIntent;
      al.d(this.selectImageJob);
      AppMethodBeat.o(34084);
      return;
    }
    AppMethodBeat.o(34084);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(34077);
    getWindow().setFormat(-2);
    f.ao(this);
    super.onCreate(paramBundle);
    if (!b.dMo()) {
      getWindow().setCallback(new c(getWindow().getCallback(), this));
    }
    this.mActionBar = getSupportActionBar();
    initNavigationSwipeBack();
    AppMethodBeat.o(34077);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(34081);
    super.onDestroy();
    if ((this.mPrepareBitmap != null) && (!this.mPrepareBitmap.isRecycled()))
    {
      ab.i("MicroMsg.BaseConversationUI", "bitmap recycle %s", new Object[] { this.mPrepareBitmap.toString() });
      this.mPrepareBitmap.recycle();
    }
    this.chattingFragmet = null;
    this.chattingFragmentView = null;
    this.chattingView = null;
    this.conversationFm = null;
    this.mActionBarHelper = null;
    this.mChattingInAnim = null;
    this.mChattingOutAnim = null;
    AppMethodBeat.o(34081);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(34078);
    super.onNewIntent(paramIntent);
    ab.i("MicroMsg.BaseConversationUI", "onNewIntent");
    setIntent(paramIntent);
    AppMethodBeat.o(34078);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(34080);
    ab.i("MicroMsg.BaseConversationUI", "on pause");
    super.onPause();
    if (!isFinishing()) {
      h.a(this);
    }
    this.launcherUIStatus = BaseConversationUI.a.AgZ;
    if ((this.chattingView != null) && (this.chattingView.isShown())) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.sdk.g.d.post(new BaseConversationUI.4(this, bool), "directReport_onPause");
      if ((this.chattingFragmet != null) && (this.chattingFragmet.isSupportNavigationSwipeBack())) {
        this.chattingFragmet.getSwipeBackLayout().setEnableGesture(false);
      }
      AppMethodBeat.o(34080);
      return;
    }
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(34103);
    super.onRestoreInstanceState(paramBundle);
    this.lastRestoreTalker = paramBundle.getString("last_restore_talker");
    ab.d("MicroMsg.BaseConversationUI", "onRestoreInstantceState:%s", new Object[] { this.lastRestoreTalker });
    AppMethodBeat.o(34103);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(34079);
    super.onResume();
    h.b(this);
    onSwipe(1.0F);
    this.launcherUIStatus = BaseConversationUI.a.AgY;
    if ((this.chattingView != null) && (this.chattingView.isShown())) {}
    for (boolean bool = true;; bool = false)
    {
      com.tencent.mm.sdk.g.d.post(new BaseConversationUI.1(this, bool), "directReport_onResume");
      if (!bool) {
        this.chattinguiResumeTime = bo.aox();
      }
      if ((com.tencent.mm.compatible.util.d.fv(19)) && (com.tencent.mm.compatible.i.b.Mg()))
      {
        if ((this.chattingFragmet != null) && (this.chattingFragmet.isSupportNavigationSwipeBack())) {
          this.chattingFragmet.getSwipeBackLayout().setEnableGesture(true);
        }
        Looper.myQueue().addIdleHandler(new BaseConversationUI.3(this));
      }
      initActionBar();
      this.mActionBar.show();
      AppMethodBeat.o(34079);
      return;
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    AppMethodBeat.i(34104);
    if ((this.chattingFragmet != null) && (!bo.isNullOrNil(this.chattingFragmet.caz.getTalkerUserName())))
    {
      ab.d("MicroMsg.BaseConversationUI", "onSaveInstanceState:%s", new Object[] { this.chattingFragmet.caz.getTalkerUserName() });
      paramBundle.putString("last_restore_talker", this.chattingFragmet.caz.getTalkerUserName());
    }
    AppMethodBeat.o(34104);
  }
  
  public void onSettle(boolean paramBoolean, int paramInt)
  {
    long l = 160L;
    AppMethodBeat.i(34105);
    ab.v("MicroMsg.BaseConversationUI", "ashutest: on settle %B, speed %d, resumeStatus %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), this.launcherUIStatus });
    if ((!com.tencent.mm.compatible.util.d.fv(19)) || (!com.tencent.mm.compatible.i.b.Mg()))
    {
      AppMethodBeat.o(34105);
      return;
    }
    View localView = findViewById(2131820633);
    if (localView == null)
    {
      ab.e("MicroMsg.BaseConversationUI", "[onSettle] null == container");
      AppMethodBeat.o(34105);
      return;
    }
    ImageView localImageView = (ImageView)findViewById(2131820649);
    if ((localImageView != null) && (localImageView.getVisibility() == 8) && (localImageView.getDrawable() != null))
    {
      localImageView.setVisibility(0);
      ab.i("MicroMsg.BaseConversationUI", "[onSettle] prepareView VISIBLE");
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
          AppMethodBeat.o(34105);
          return;
          l = 290L;
        }
      }
      if (paramInt > 0) {}
      for (;;)
      {
        j.a(localImageView, l, localImageView.getWidth() * -1 / 4, null);
        AppMethodBeat.o(34105);
        return;
        l = 290L;
      }
    }
    if (paramBoolean)
    {
      if (paramInt > 0) {}
      for (;;)
      {
        j.a(localView, l, 0.0F, null);
        AppMethodBeat.o(34105);
        return;
        l = 290L;
      }
    }
    if (paramInt > 0) {}
    for (;;)
    {
      j.a(localView, l, localView.getWidth() * -1 / 4, null);
      AppMethodBeat.o(34105);
      return;
      l = 290L;
    }
  }
  
  public void onSwipe(float paramFloat)
  {
    AppMethodBeat.i(34082);
    ab.v("MicroMsg.BaseConversationUI", "ashutest::on swipe %f, duration %d, status %s", new Object[] { Float.valueOf(paramFloat), Long.valueOf(320L), this.launcherUIStatus });
    if ((!com.tencent.mm.compatible.util.d.fv(19)) || (!com.tencent.mm.compatible.i.b.Mg()))
    {
      AppMethodBeat.o(34082);
      return;
    }
    if (this.chattingFragmet == null)
    {
      ab.e("MicroMsg.BaseConversationUI", "chattingFragmet is null!");
      AppMethodBeat.o(34082);
      return;
    }
    if ((paramFloat == 0.0F) && (!this.mChattingClosed))
    {
      localObject1 = (ImageView)getWindow().getDecorView().findViewById(2131820649);
      if (localObject1 != null)
      {
        localObject2 = (ViewGroup)((ImageView)localObject1).getTag();
        if (localObject2 != null)
        {
          ab.i("MicroMsg.BaseConversationUI", "[onSwipe] prepareView GONE");
          ((ViewGroup)localObject2).setVisibility(0);
          ((ImageView)localObject1).setVisibility(8);
          ((ImageView)localObject1).setImageDrawable(null);
        }
      }
      if (this.mChattingInAnim != null) {
        this.mChattingInAnim.cancel();
      }
    }
    while ((BaseConversationUI.a.AgY != this.launcherUIStatus) && (Float.compare(1.0F, paramFloat) > 0))
    {
      ab.i("MicroMsg.BaseConversationUI", "[onSwipe] return! consumedSuperCall:%s", new Object[] { Float.valueOf(paramFloat) });
      AppMethodBeat.o(34082);
      return;
      if ((paramFloat == 1.0F) && (!this.mChattingClosed) && (this.chattingFragmet.isSupportNavigationSwipeBack()))
      {
        getWindow().setBackgroundDrawableResource(2131690402);
        localObject1 = (ImageView)getWindow().getDecorView().findViewById(2131820649);
        if ((localObject1 != null) && (((ImageView)localObject1).getVisibility() == 0) && (((ImageView)localObject1).getTag() != null))
        {
          ((View)((ImageView)localObject1).getTag()).setVisibility(0);
          ab.i("MicroMsg.BaseConversationUI", "[onSwipe] prepareView GONE");
          ((ImageView)localObject1).setVisibility(8);
        }
      }
    }
    Object localObject1 = findViewById(2131820633);
    Object localObject2 = (ImageView)findViewById(2131820649);
    if ((localObject2 != null) && (((ImageView)localObject2).getVisibility() == 8) && (((ImageView)localObject2).getDrawable() != null) && (!this.mChattingClosed) && (paramFloat != 1.0F) && (paramFloat != 0.0F))
    {
      ((ImageView)localObject2).setVisibility(0);
      ab.i("MicroMsg.BaseConversationUI", "[onSwipe] !1 && !0 prepareView VISIBLE");
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
    }
    resetViewTranX((View)localObject1, (ImageView)localObject2, paramFloat);
    AppMethodBeat.o(34082);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public ActionMode onWindowStartingActionMode(ActionMode.Callback paramCallback)
  {
    AppMethodBeat.i(34101);
    if ((this.chattingFragmet == null) || (this.chattingFragmet.dGa() == null) || (!this.chattingFragmet.isSupportCustomActionBar()))
    {
      AppMethodBeat.o(34101);
      return null;
    }
    if (com.tencent.mm.compatible.util.d.iU(22))
    {
      AppMethodBeat.o(34101);
      return null;
    }
    paramCallback = this.chattingFragmet.dGa().startActionMode(paramCallback);
    if (paramCallback == null)
    {
      AppMethodBeat.o(34101);
      return null;
    }
    AppMethodBeat.o(34101);
    return paramCallback;
  }
  
  public void pauseMainFragment()
  {
    AppMethodBeat.i(34095);
    if ((this.conversationFm != null) && (!this.conversationFm.isSupportNavigationSwipeBack())) {
      this.conversationFm.showOptionMenu(false);
    }
    AppMethodBeat.o(34095);
  }
  
  public void resumeMainFragment()
  {
    AppMethodBeat.i(34096);
    if (this.conversationFm != null)
    {
      this.conversationFm.onResume();
      if (!this.conversationFm.isSupportNavigationSwipeBack()) {
        this.conversationFm.showOptionMenu(true);
      }
    }
    AppMethodBeat.o(34096);
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(34100);
    this.title = paramString;
    if (this.mActionBarHelper != null) {
      updateTitle();
    }
    AppMethodBeat.o(34100);
  }
  
  public void startChatting(String paramString)
  {
    AppMethodBeat.i(34088);
    startChatting(paramString, null, false);
    AppMethodBeat.o(34088);
  }
  
  public void startChatting(String paramString, Bundle paramBundle, boolean paramBoolean)
  {
    AppMethodBeat.i(34089);
    if (this.chattingView == null) {}
    for (boolean bool = false;; bool = this.chattingView.isShown())
    {
      ab.i("MicroMsg.BaseConversationUI", "try startChatting, ishow:%b", new Object[] { Boolean.valueOf(bool) });
      this.pendingBundle = paramBundle;
      this.pendingUser = paramString;
      this.mNeedChattingAnim = paramBoolean;
      aw.RO().dtb();
      al.Nf(-8);
      al.ae(this.startChattingRunnable);
      al.d(this.startChattingRunnable);
      AppMethodBeat.o(34089);
      return;
    }
  }
  
  public void updateTitle()
  {
    AppMethodBeat.i(34099);
    if (this.mActionBarHelper != null) {
      this.mActionBarHelper.setTitle(com.tencent.mm.model.s.nE(this.title));
    }
    AppMethodBeat.o(34099);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.conversation.BaseConversationUI
 * JD-Core Version:    0.7.0.1
 */
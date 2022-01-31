package com.tencent.mm.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.MessageQueue.IdleHandler;
import android.support.v7.app.ActionBar;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.an;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.base.OnLayoutChangedLinearLayout;
import com.tencent.mm.ui.base.OnLayoutChangedLinearLayout.a;
import com.tencent.mm.ui.base.y;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.tools.TestTimeForChatting;
import com.tencent.mm.ui.tools.j;
import com.tencent.mm.ui.widget.h;

public class NewChattingTabUI
  implements LauncherUI.a
{
  boolean isAnimating;
  MMFragmentActivity jdB;
  boolean mChattingClosed;
  Animation mChattingInAnim;
  private Animation mChattingOutAnim;
  private IChattingUIProxy mChattingUIProxy;
  private boolean mNeedChattingAnim;
  Bitmap mPrepareBitmap;
  Runnable mStartChattingRunnable;
  private OnLayoutChangedLinearLayout.a onChattingLayoutChangedListener;
  LauncherUI.b zdV;
  long zdW;
  private TestTimeForChatting zdX;
  private int zdY;
  MessageQueue.IdleHandler zdZ;
  private OnLayoutChangedLinearLayout zea;
  String zeb;
  private String zec;
  private Bundle zed;
  BaseChattingUIFragment zee;
  private long zef;
  NewChattingTabUI.a zeg;
  boolean zeh;
  
  public NewChattingTabUI(LauncherUI.b paramb)
  {
    AppMethodBeat.i(29811);
    this.zdW = 0L;
    this.mChattingClosed = true;
    this.isAnimating = false;
    this.zeg = new NewChattingTabUI.a(this, (byte)0);
    this.zeh = false;
    this.mStartChattingRunnable = new NewChattingTabUI.5(this);
    this.onChattingLayoutChangedListener = new NewChattingTabUI.6(this);
    this.zdV = paramb;
    AppMethodBeat.o(29811);
  }
  
  static boolean acceptRequestCode(int paramInt)
  {
    AppMethodBeat.i(29813);
    paramInt = 0xFFFF & paramInt;
    ab.w("MicroMsg.LauncherUI.NewChattingTabUI", "check request code %d", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    default: 
      AppMethodBeat.o(29813);
      return false;
    }
    AppMethodBeat.o(29813);
    return true;
  }
  
  private ViewGroup dDa()
  {
    AppMethodBeat.i(29814);
    ViewParent localViewParent = this.jdB.getSupportActionBar().getCustomView().getParent();
    Object localObject3 = null;
    View localView2 = this.jdB.getWindow().getDecorView();
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
    localObject1 = (ViewGroup)localObject2;
    AppMethodBeat.o(29814);
    return localObject1;
  }
  
  private Bitmap getMagicDrawingCache(View paramView)
  {
    AppMethodBeat.i(29817);
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
      ab.e("MicroMsg.LauncherUI.NewChattingTabUI", "viewWidth:%s viewHeight:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      AppMethodBeat.o(29817);
      return null;
    }
    if (this.zee.getView() == null)
    {
      AppMethodBeat.o(29817);
      return null;
    }
    if (this.zee != null) {
      ab.i("MicroMsg.LauncherUI.NewChattingTabUI", "getBottom:%s keyboardState:%s", new Object[] { Integer.valueOf(this.zee.getView().getBottom()), Integer.valueOf(this.zee.keyboardState()) });
    }
    if ((this.zee != null) && (this.zee.getView().getBottom() > 0) && ((this.zee.keyboardState() == 1) || (this.zee.getView().getBottom() < this.jdB.getResources().getDisplayMetrics().heightPixels * 2 / 3)))
    {
      ab.e("MicroMsg.LauncherUI.NewChattingTabUI", "hardKeyboardHidden:%s", new Object[] { Integer.valueOf(this.zee.keyboardState()) });
      this.jdB.getWindow().setBackgroundDrawableResource(2131690402);
      AppMethodBeat.o(29817);
      return null;
    }
    if ((this.mPrepareBitmap == null) || (this.mPrepareBitmap.isRecycled()) || (this.mPrepareBitmap.getWidth() != i) || (this.mPrepareBitmap.getHeight() != j))
    {
      if ((this.mPrepareBitmap != null) && (!this.mPrepareBitmap.isRecycled()))
      {
        ab.i("MicroMsg.LauncherUI.NewChattingTabUI", "bitmap recycle %s", new Object[] { this.mPrepareBitmap.toString() });
        this.mPrepareBitmap.recycle();
      }
      try
      {
        this.mPrepareBitmap = com.tencent.mm.sdk.platformtools.d.createBitmap(i, j, Bitmap.Config.ARGB_4444);
        if (this.mPrepareBitmap == null)
        {
          AppMethodBeat.o(29817);
          return null;
        }
      }
      catch (OutOfMemoryError paramView)
      {
        ab.e("MicroMsg.LauncherUI.NewChattingTabUI", "[getMagicDrawingCache] e:%s", new Object[] { paramView });
        AppMethodBeat.o(29817);
        return null;
      }
    }
    paramView.draw(new Canvas(this.mPrepareBitmap));
    ab.i("MicroMsg.LauncherUI.NewChattingTabUI", "[getMagicDrawingCache] cost%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    paramView = this.mPrepareBitmap;
    AppMethodBeat.o(29817);
    return paramView;
  }
  
  private int getTopHeight()
  {
    AppMethodBeat.i(156102);
    int i = am.getStatusBarHeight(this.jdB);
    if ((Build.VERSION.SDK_INT >= 24) && (LauncherUI.getInstance() != null)) {}
    for (boolean bool = LauncherUI.getInstance().isInMultiWindowMode();; bool = false)
    {
      if (bool) {
        i = 0;
      }
      ab.i("MicroMsg.LauncherUI.NewChattingTabUI", "getTopHeight statusHeight:%s, isInMultiWindowMode:%s", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool) });
      AppMethodBeat.o(156102);
      return i;
    }
  }
  
  static void resetViewTranX(View paramView, ImageView paramImageView, float paramFloat)
  {
    AppMethodBeat.i(153821);
    if (Float.compare(1.0F, paramFloat) <= 0)
    {
      j.t(paramView, 0.0F);
      j.t(paramImageView, 0.0F);
      AppMethodBeat.o(153821);
      return;
    }
    if ((paramImageView != null) && (paramImageView.getDrawable() != null))
    {
      j.t(paramImageView, paramImageView.getWidth() / 2.5F * (1.0F - paramFloat) * -1.0F);
      AppMethodBeat.o(153821);
      return;
    }
    j.t(paramView, paramView.getWidth() / 2.5F * (1.0F - paramFloat) * -1.0F);
    AppMethodBeat.o(153821);
  }
  
  private void tryResetChattingSwipeStatus()
  {
    boolean bool = true;
    AppMethodBeat.i(29819);
    if (!dbs())
    {
      AppMethodBeat.o(29819);
      return;
    }
    if (this.zee == null) {}
    for (;;)
    {
      ab.i("MicroMsg.LauncherUI.NewChattingTabUI", "ashutest: tryResetChattingSwipeStatus, chattingFragment NULL ? %B", new Object[] { Boolean.valueOf(bool) });
      if (this.zee != null) {
        this.zee.getSwipeBackLayout().AEZ = false;
      }
      AppMethodBeat.o(29819);
      return;
      bool = false;
    }
  }
  
  public final boolean H(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(29820);
    ab.v("MicroMsg.LauncherUI.NewChattingTabUI", "ashutest: on settle %B, speed %d, resumeStatus %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), Boolean.valueOf(this.zdV.dBP()) });
    if (!dbs())
    {
      AppMethodBeat.o(29820);
      return true;
    }
    if (paramBoolean) {
      this.zdV.dBS();
    }
    if (!this.zdV.dBP())
    {
      AppMethodBeat.o(29820);
      return false;
    }
    View localView = this.jdB.findViewById(2131820633);
    if (localView == null)
    {
      ab.e("MicroMsg.LauncherUI.NewChattingTabUI", "[onSettle] null == container");
      AppMethodBeat.o(29820);
      return true;
    }
    ImageView localImageView = (ImageView)this.jdB.findViewById(2131820649);
    if ((localImageView != null) && (localImageView.getVisibility() == 8) && (localImageView.getDrawable() != null))
    {
      localImageView.setVisibility(0);
      ab.i("MicroMsg.LauncherUI.NewChattingTabUI", "[onSettle] prepareView VISIBLE");
      localView.setVisibility(8);
    }
    if ((localImageView != null) && (localImageView.getVisibility() == 0)) {
      if (localImageView.getWidth() == 0)
      {
        paramInt = this.jdB.getResources().getDisplayMetrics().widthPixels;
        if (!paramBoolean) {
          break label250;
        }
        j.a(localImageView, 224L, 0.0F, null);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(29820);
      return true;
      paramInt = localImageView.getWidth();
      break;
      label250:
      j.a(localImageView, 256L, paramInt * -1 / 3.5F, null);
      continue;
      if (localView.getWidth() == 0) {}
      for (paramInt = this.jdB.getResources().getDisplayMetrics().widthPixels;; paramInt = localView.getWidth())
      {
        if (!paramBoolean) {
          break label315;
        }
        j.a(localView, 224L, 0.0F, null);
        break;
      }
      label315:
      j.a(localView, 256L, paramInt * -1 / 3.5F, null);
    }
  }
  
  final void Os(int paramInt)
  {
    AppMethodBeat.i(29822);
    ab.i("MicroMsg.LauncherUI.NewChattingTabUI", "[setLauncherContainerVisible] visible:%s", new Object[] { Integer.valueOf(paramInt) });
    if (this.jdB == null)
    {
      ab.e("MicroMsg.LauncherUI.NewChattingTabUI", "[setLauncherContainerVisible] getActivity is null");
      AppMethodBeat.o(29822);
      return;
    }
    View localView = this.jdB.findViewById(2131820633);
    if ((localView != null) && (localView.getVisibility() != paramInt)) {
      localView.setVisibility(paramInt);
    }
    AppMethodBeat.o(29822);
  }
  
  public final boolean dCm()
  {
    if (this.zee == null) {
      return false;
    }
    return this.zee.caz.bSe;
  }
  
  final boolean dbs()
  {
    AppMethodBeat.i(29815);
    if ((com.tencent.mm.compatible.util.d.fv(19)) && (com.tencent.mm.compatible.i.b.Mg()) && (!com.tencent.mm.compatible.f.b.bI(this.jdB)))
    {
      AppMethodBeat.o(29815);
      return true;
    }
    AppMethodBeat.o(29815);
    return false;
  }
  
  final void kS(int paramInt)
  {
    AppMethodBeat.i(29816);
    if (this.zee == null)
    {
      AppMethodBeat.o(29816);
      return;
    }
    com.tencent.mm.sdk.g.d.post(new NewChattingTabUI.4(this, paramInt), "MicroMsg.LauncherUI.NewChattingTabUI|report");
    AppMethodBeat.o(29816);
  }
  
  public final boolean qx(boolean paramBoolean)
  {
    AppMethodBeat.i(29818);
    if (this.zdX == null) {}
    for (boolean bool = false;; bool = this.zdX.isShown())
    {
      ab.i("MicroMsg.LauncherUI.NewChattingTabUI", "try closeChatting, ishow:%b", new Object[] { Boolean.valueOf(bool) });
      if ((this.zee != null) && (this.zee.getView() != null)) {
        this.zee.getView().setImportantForAccessibility(4);
      }
      if ((this.zdX != null) && (this.zdX.getVisibility() != 8) && (this.zee != null) && (this.jdB != null)) {
        break;
      }
      AppMethodBeat.o(29818);
      return false;
    }
    if ((this.zee != null) && (this.zee.isSupportNavigationSwipeBack())) {
      h.b(this.jdB);
    }
    ab.i("MicroMsg.LauncherUI.NewChattingTabUI", "[closeChatting] needAnim:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    kS(4);
    this.mChattingClosed = true;
    if ((paramBoolean) && (this.mChattingOutAnim == null))
    {
      this.mChattingOutAnim = AnimationUtils.loadAnimation(this.jdB, MMFragmentActivity.a.zca);
      this.mChattingOutAnim.setAnimationListener(new NewChattingTabUI.7(this));
    }
    y.d(true, new Intent().putExtra("classname", "mainui").putExtra("main_process", false));
    if (this.zee.isSupportCustomActionBar())
    {
      ImageView localImageView = (ImageView)this.jdB.getWindow().getDecorView().findViewById(2131820649);
      if ((localImageView != null) && (localImageView.getVisibility() == 0))
      {
        localImageView.setVisibility(8);
        ab.i("MicroMsg.LauncherUI.NewChattingTabUI", "[closeChatting] prepareView GONE");
      }
    }
    Os(0);
    if (paramBoolean)
    {
      this.mChattingUIProxy.onExitBegin();
      this.mChattingUIProxy.onExitEnd();
      this.zdX.startAnimation(this.mChattingOutAnim);
    }
    for (;;)
    {
      AppMethodBeat.o(29818);
      return true;
      this.mChattingUIProxy.onExitBegin();
      this.mChattingUIProxy.onExitEnd();
      this.zdX.setVisibility(8);
      this.jdB.onSwipe(1.0F);
      tryResetChattingSwipeStatus();
    }
  }
  
  public final void startChatting(String paramString, Bundle paramBundle, boolean paramBoolean)
  {
    AppMethodBeat.i(29812);
    this.zef = System.currentTimeMillis();
    if (this.zdX == null) {}
    for (boolean bool = false;; bool = this.zdX.isShown())
    {
      ab.i("MicroMsg.LauncherUI.NewChattingTabUI", "try startChatting, ishow:%b userName:%s needAnim:%b", new Object[] { Boolean.valueOf(bool), paramString, Boolean.valueOf(paramBoolean) });
      if ((this.zee != null) && (this.zee.getView() != null)) {
        this.zee.getView().setImportantForAccessibility(1);
      }
      aw.getNotification().bE(false);
      this.zeh = false;
      this.zed = paramBundle;
      this.zec = paramString;
      this.mNeedChattingAnim = paramBoolean;
      aw.RO().dtb();
      al.Nf(-8);
      al.ae(this.mStartChattingRunnable);
      al.d(this.mStartChattingRunnable);
      AppMethodBeat.o(29812);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ui.NewChattingTabUI
 * JD-Core Version:    0.7.0.1
 */
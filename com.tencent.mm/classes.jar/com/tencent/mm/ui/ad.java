package com.tencent.mm.ui;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.MessageQueue.IdleHandler;
import android.support.v7.app.ActionBar;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.animation.Animation;
import android.widget.ImageView;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.compatible.f.b;
import com.tencent.mm.model.al;
import com.tencent.mm.model.au;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.OnLayoutChangedLinearLayout;
import com.tencent.mm.ui.base.OnLayoutChangedLinearLayout.a;
import com.tencent.mm.ui.chatting.e;
import com.tencent.mm.ui.tools.TestTimeForChatting;
import com.tencent.mm.ui.tools.h;

public final class ad
  implements LauncherUI.a
{
  boolean isAnimating = false;
  boolean mChattingClosed = true;
  Animation mChattingInAnim;
  Animation mChattingOutAnim;
  boolean mNeedChattingAnim;
  Bitmap mPrepareBitmap;
  MMFragmentActivity ohK;
  OnLayoutChangedLinearLayout.a onChattingLayoutChangedListener = new ad.5(this);
  LauncherUI.b uPI;
  long uPJ = 0L;
  TestTimeForChatting uPK;
  private int uPL;
  MessageQueue.IdleHandler uPM;
  OnLayoutChangedLinearLayout uPN;
  String uPO;
  String uPP;
  Bundle uPQ;
  e uPR;
  n uPS;
  ad.a uPT = new ad.a(this, (byte)0);
  boolean uPU = false;
  Runnable uPV = new ad.4(this);
  
  public ad(LauncherUI.b paramb)
  {
    this.uPI = paramb;
  }
  
  private ViewGroup czZ()
  {
    Object localObject1 = this.ohK.getSupportActionBar().getCustomView().getParent();
    Object localObject2 = null;
    View localView = this.ohK.getWindow().getDecorView();
    while ((localObject1 != localView) && (localObject1 != null))
    {
      ViewParent localViewParent = ((ViewParent)localObject1).getParent();
      localObject2 = localObject1;
      localObject1 = localViewParent;
    }
    return (ViewGroup)localObject2;
  }
  
  private String getIdentityString()
  {
    if (this.uPR != null) {
      return this.uPR.getIdentityString();
    }
    return "";
  }
  
  final boolean cbo()
  {
    return (com.tencent.mm.compatible.util.d.gF(19)) && (com.tencent.mm.compatible.i.a.zD()) && (!b.be(this.ohK));
  }
  
  public final boolean czd()
  {
    if (this.uPR == null) {
      return false;
    }
    return this.uPR.byx.euf;
  }
  
  public final Bitmap getMagicDrawingCache(View paramView)
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
        if ((i <= 0) || (j <= 0)) {
          y.e("MicroMsg.LauncherUI.NewChattingTabUI", "viewWidth:%s viewHeight:%s", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
        }
        while (this.uPR.getView() == null) {
          return null;
        }
        if (this.uPR != null) {
          y.i("MicroMsg.LauncherUI.NewChattingTabUI", "getBottom:%s keyboardState:%s", new Object[] { Integer.valueOf(this.uPR.getView().getBottom()), Integer.valueOf(this.uPR.keyboardState()) });
        }
        if ((this.uPR != null) && (this.uPR.getView().getBottom() > 0) && ((this.uPR.keyboardState() == 1) || (this.uPR.getView().getBottom() < this.ohK.getResources().getDisplayMetrics().heightPixels * 2 / 3)))
        {
          y.e("MicroMsg.LauncherUI.NewChattingTabUI", "hardKeyboardHidden:%s", new Object[] { Integer.valueOf(this.uPR.keyboardState()) });
          this.ohK.getWindow().setBackgroundDrawableResource(R.e.room_info_comment_layout_bg);
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
            int k = (int)this.ohK.getResources().getDimension(R.f.wechat_abc_action_bar_default_height);
            int m = (int)this.ohK.getResources().getDimension(R.f.DefaultTabbarHeight);
            Paint localPaint = new Paint();
            localPaint.setColor(-1);
            localCanvas.drawRect(0.0F, k, i, j - m, localPaint);
            paramView.draw(localCanvas);
            y.i("MicroMsg.LauncherUI.NewChattingTabUI", "[getMagicDrawingCache] cost%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
            return this.mPrepareBitmap;
          }
          catch (OutOfMemoryError paramView)
          {
            y.e("MicroMsg.LauncherUI.NewChattingTabUI", "[getMagicDrawingCache] e:%s", new Object[] { paramView });
            return null;
          }
          this.mPrepareBitmap.eraseColor(0);
        }
      }
    }
  }
  
  final void jdMethod_if(int paramInt)
  {
    if (this.uPR == null) {}
    do
    {
      return;
      com.tencent.mm.modelstat.d.b(paramInt, "ChattingUI" + getIdentityString(), hashCode());
    } while (paramInt != 4);
    com.tencent.mm.modelstat.d.h("ChattingUI" + getIdentityString(), this.uPJ, ah.UX());
  }
  
  public final void startChatting(String paramString, Bundle paramBundle, boolean paramBoolean)
  {
    if (this.uPK == null) {}
    for (boolean bool = false;; bool = this.uPK.isShown())
    {
      y.i("MicroMsg.LauncherUI.NewChattingTabUI", "try startChatting, ishow:%b userName:%s needAnim:%b", new Object[] { Boolean.valueOf(bool), paramString, Boolean.valueOf(paramBoolean) });
      if ((this.uPR != null) && (this.uPR.getView() != null)) {
        this.uPR.getView().setImportantForAccessibility(1);
      }
      au.getNotification().bc(false);
      this.uPU = false;
      this.uPQ = paramBundle;
      this.uPP = paramString;
      this.mNeedChattingAnim = paramBoolean;
      au.DS().crc();
      ai.Fd(-8);
      ai.S(this.uPV);
      ai.d(this.uPV);
      return;
    }
  }
  
  final void tryResetChattingSwipeStatus()
  {
    boolean bool = true;
    if (!cbo()) {
      return;
    }
    if (this.uPR == null) {}
    for (;;)
    {
      y.i("MicroMsg.LauncherUI.NewChattingTabUI", "ashutest: tryResetChattingSwipeStatus, chattingFragment NULL ? %B", new Object[] { Boolean.valueOf(bool) });
      if (this.uPR == null) {
        break;
      }
      this.uPR.getSwipeBackLayout().wlh = false;
      return;
      bool = false;
    }
  }
  
  public final boolean z(boolean paramBoolean, int paramInt)
  {
    long l = 110L;
    y.v("MicroMsg.LauncherUI.NewChattingTabUI", "ashutest: on settle %B, speed %d, resumeStatus %s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), Boolean.valueOf(this.uPI.cyH()) });
    if (!cbo()) {
      return true;
    }
    if (!this.uPI.cyH()) {
      return false;
    }
    View localView = this.ohK.findViewById(R.h.launcher_container);
    if (localView == null)
    {
      y.e("MicroMsg.LauncherUI.NewChattingTabUI", "[onSettle] null == container");
      return true;
    }
    ImageView localImageView = (ImageView)this.ohK.findViewById(R.h.prepare_imageview);
    if ((localImageView != null) && (localImageView.getVisibility() == 8) && (localImageView.getDrawable() != null))
    {
      localImageView.setVisibility(0);
      y.i("MicroMsg.LauncherUI.NewChattingTabUI", "[onSettle] prepareView VISIBLE");
      localView.setVisibility(8);
    }
    int i;
    if ((localImageView != null) && (localImageView.getVisibility() == 0))
    {
      if (localImageView.getWidth() == 0)
      {
        i = this.ohK.getResources().getDisplayMetrics().widthPixels;
        if (!paramBoolean) {
          break label228;
        }
        if (paramInt <= 0) {
          break label220;
        }
      }
      for (;;)
      {
        h.a(localImageView, l, 0.0F, 0.125F);
        return true;
        i = localImageView.getWidth();
        break;
        label220:
        l = 220L;
      }
      label228:
      if (paramInt > 0) {}
      for (;;)
      {
        h.a(localImageView, l, i * -1 / 2.5F, 0.75F);
        break;
        l = 220L;
      }
    }
    if (localView.getWidth() == 0)
    {
      i = this.ohK.getResources().getDisplayMetrics().widthPixels;
      label283:
      if (!paramBoolean) {
        break label322;
      }
      if (paramInt <= 0) {
        break label314;
      }
    }
    for (;;)
    {
      h.a(localView, l, 0.0F, 0.125F);
      break;
      i = localView.getWidth();
      break label283;
      label314:
      l = 220L;
    }
    label322:
    if (paramInt > 0) {}
    for (;;)
    {
      h.a(localView, l, i * -1 / 2.5F, 0.75F);
      break;
      l = 220L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.ad
 * JD-Core Version:    0.7.0.1
 */
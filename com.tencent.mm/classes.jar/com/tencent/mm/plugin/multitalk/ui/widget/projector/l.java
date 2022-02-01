package com.tencent.mm.plugin.multitalk.ui.widget.projector;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.DrawFilter;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitalk.model.ac;
import com.tencent.mm.plugin.multitalk.model.af;
import com.tencent.mm.plugin.multitalk.ui.widget.k.a;
import com.tencent.mm.plugin.multitalk.ui.widget.k.a.a;
import com.tencent.mm.plugin.multitalk.ui.widget.k.a.b;
import com.tencent.mm.plugin.multitalk.ui.widget.k.a.c;
import com.tencent.mm.plugin.multitalk.ui.widget.k.a.d;
import com.tencent.mm.plugin.multitalk.ui.widget.k.a.e;
import com.tencent.mm.plugin.multitalk.ui.widget.k.a.f;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.d.a;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.g.b.z.f;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectRootView;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "avatarLayout", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectAvatarUI;", "getAvatarLayout", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectAvatarUI;", "setAvatarLayout", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectAvatarUI;)V", "avatarRoot", "Landroid/widget/FrameLayout;", "getAvatarRoot", "()Landroid/widget/FrameLayout;", "setAvatarRoot", "(Landroid/widget/FrameLayout;)V", "bottomRoot", "getBottomRoot", "setBottomRoot", "bottomUiLayout", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectBottomUI;", "getBottomUiLayout", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectBottomUI;", "setBottomUiLayout", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectBottomUI;)V", "fpsTimer", "Ljava/util/Timer;", "isAvatarLayoutOn", "", "()Z", "setAvatarLayoutOn", "(Z)V", "isDoodleLayoutOn", "setDoodleLayoutOn", "isLockGenerateBitmap", "setLockGenerateBitmap", "value", "isReadyNotAllowClick", "setReadyNotAllowClick", "isScreenProjectSending", "setScreenProjectSending", "mCurrentPageHeight", "", "getMCurrentPageHeight", "()I", "setMCurrentPageHeight", "(I)V", "mCurrentPageWidth", "getMCurrentPageWidth", "setMCurrentPageWidth", "mCurrentScale", "", "getMCurrentScale", "()F", "setMCurrentScale", "(F)V", "mEditLayout", "getMEditLayout", "setMEditLayout", "mFps", "mRawBitmap", "Landroid/graphics/Bitmap;", "getMRawBitmap", "()Landroid/graphics/Bitmap;", "setMRawBitmap", "(Landroid/graphics/Bitmap;)V", "mReadyLayout", "getMReadyLayout", "setMReadyLayout", "mScreenReportData", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenReportData;", "getMScreenReportData", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenReportData;", "setMScreenReportData", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenReportData;)V", "mStartTimes", "", "getMStartTimes", "()J", "setMStartTimes", "(J)V", "multiTalkStrokeContext", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/MultiTalkStrokeLayout;", "getMultiTalkStrokeContext", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/MultiTalkStrokeLayout;", "setMultiTalkStrokeContext", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/MultiTalkStrokeLayout;)V", "readyUI", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenReadyUI;", "getReadyUI", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenReadyUI;", "setReadyUI", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenReadyUI;)V", "screenFuncConfig", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;", "getScreenFuncConfig", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;", "setScreenFuncConfig", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;)V", "sendData", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "timer", "topRoot", "getTopRoot", "setTopRoot", "topUiLayout", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectTopUI;", "getTopUiLayout", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectTopUI;", "setTopUiLayout", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectTopUI;)V", "applyAvatarLayout", "", "applyBottomUI", "applyEditorLayout", "isFullScreen", "applyReaderUI", "applyReadyLayout", "applyThumbnailUI", "applyTopUI", "bitmapToByteArray", "", "bm", "checkCallerState", "checkCurrentInAvatarLayout", "checkCurrentInDoodleLayout", "checkCurrentOrientation", "clearScreen", "closeReaderRenderer", "dismissProjectScreen", "enterScreenDoodle", "getBackgroundView", "Landroid/view/View;", "getBitmap", "view", "ignoreBg", "getBitmapShot", "getCurrentStatus", "getLayoutId", "getRenderBitmap", "initView", "inputScreenProjectInfo", "params", "Landroid/os/Bundle;", "pageIndex", "isShow", "onBack", "onTimeSecondCallback", "onVideoGroupMemberChange", "refreshView", "reportScreenProject", "responeScreenClick", "showReaderContent", "show", "showStrokeContent", "statusChange", "status", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus$ProjectStatus;", "param", "stopScreenProjectSend", "isMini", "Companion", "plugin-multitalk_release"})
public abstract class l
  extends RelativeLayout
  implements a
{
  public static final l.a zXp = new l.a((byte)0);
  private Timer dfh;
  private int hDX;
  private float zVJ;
  private int zVK;
  private int zVL;
  private e zWU;
  s zWV;
  private long zWW;
  private FrameLayout zWX;
  private FrameLayout zWY;
  private FrameLayout zWZ;
  private FrameLayout zXa;
  private FrameLayout zXb;
  b zXc;
  private k zXd;
  private r zXe;
  private j zXf;
  private p zXg;
  Bitmap zXh;
  private boolean zXi;
  boolean zXj;
  private boolean zXk;
  private boolean zXl = true;
  private Timer zXm;
  private MMHandler zXn;
  volatile boolean zXo;
  
  public l(Context paramContext)
  {
    super(paramContext);
  }
  
  public static byte[] ab(Bitmap paramBitmap)
  {
    kotlin.g.b.p.h(paramBitmap, "bm");
    ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(paramBitmap.getWidth() * paramBitmap.getHeight() * 4);
    BitmapUtil.rotate(paramBitmap, -90.0F, false).copyPixelsToBuffer((Buffer)localByteBuffer);
    return localByteBuffer.array();
  }
  
  private void epC()
  {
    b localb = this.zXc;
    if (localb != null)
    {
      if (localb.zVQ)
      {
        localb1 = localb.zVO;
        if (localb1 != null) {
          localb1.setVisibility(0);
        }
        localb.epj();
        localb.zVQ = false;
      }
    }
    else {
      return;
    }
    localb.epj();
    com.tencent.mm.plugin.multitalk.ui.a.b localb1 = localb.zVO;
    if (localb1 != null) {
      localb1.setVisibility(0);
    }
    localb.zVQ = true;
  }
  
  private Bitmap ev(View paramView)
  {
    long l2 = 0L;
    kotlin.g.b.p.h(paramView, "view");
    int i = paramView.getMeasuredWidth() - paramView.getMeasuredWidth() % 4;
    int j = paramView.getMeasuredHeight() - paramView.getMeasuredHeight() % 4;
    if ((i <= 0) || (j <= 0)) {}
    Bitmap localBitmap;
    do
    {
      return null;
      localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      l1 = Util.currentTicks();
    } while ((localBitmap == null) || (localBitmap.isRecycled()));
    Object localObject = new Canvas(localBitmap);
    ((Canvas)localObject).drawPaint(new Paint());
    ((Canvas)localObject).setDrawFilter((DrawFilter)new PaintFlagsDrawFilter(0, 3));
    paramView.draw((Canvas)localObject);
    long l3 = Util.ticksToNow(l1);
    paramView = this.zWV;
    s locals;
    if (paramView != null)
    {
      locals = this.zWV;
      if (locals == null) {
        break label250;
      }
    }
    label250:
    for (long l1 = locals.zYi;; l1 = 0L)
    {
      paramView.zYi = ((l1 + l3) / 2L);
      l1 = Util.currentTicks();
      paramView = this.zXc;
      if (paramView != null) {
        paramView.t((Canvas)localObject);
      }
      l3 = Util.ticksToNow(l1);
      paramView = this.zWV;
      if (paramView != null)
      {
        localObject = this.zWV;
        l1 = l2;
        if (localObject != null) {
          l1 = ((s)localObject).zYh;
        }
        paramView.zYh = ((l3 + l1) / 2L);
      }
      if (i <= j) {
        break;
      }
      return BitmapUtil.rotate(localBitmap, 90.0F);
    }
    return localBitmap;
  }
  
  public void a(a.c paramc, Bundle paramBundle)
  {
    Object localObject = null;
    Runnable localRunnable = null;
    kotlin.g.b.p.h(paramc, "status");
    Log.printInfoStack("MicroMsg.MultiTalkScreenProjectorView", "statusChange %s and param is %s", new Object[] { paramc, paramBundle });
    switch (m.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              do
                              {
                                do
                                {
                                  do
                                  {
                                    return;
                                    Log.printInfoStack("MicroMsg.MultiTalkScreenProjectorView", "startScreenProjectSend", new Object[0]);
                                    getRenderBitmap();
                                    ac.eom();
                                    com.tencent.mm.plugin.multitalk.model.q.Rj(101);
                                    setScreenProjectSending(true);
                                    return;
                                    sh(false);
                                    return;
                                    this.zXj = true;
                                    paramc = this.zWZ;
                                    if (paramc != null) {
                                      paramc.setVisibility(4);
                                    }
                                    paramBundle = this.zXc;
                                    paramc = localRunnable;
                                    if (paramBundle != null)
                                    {
                                      paramBundle = paramBundle.zVO;
                                      paramc = localRunnable;
                                      if (paramBundle != null)
                                      {
                                        paramBundle = paramBundle.getMultiTalkEditPhotoWrapper();
                                        paramc = localRunnable;
                                        if (paramBundle != null)
                                        {
                                          paramBundle = paramBundle.zQo;
                                          paramc = localRunnable;
                                          if (paramBundle != null) {
                                            paramc = (com.tencent.mm.view.b.b)paramBundle.getBaseBoardView();
                                          }
                                        }
                                      }
                                    }
                                    if (paramc == null) {
                                      throw new kotlin.t("null cannot be cast to non-null type com.tencent.mm.view.board.MultiTalkBoardView");
                                    }
                                    paramc.setEnableToResponseSlid(true);
                                    epC();
                                  } while ((epf() != 90) && (epf() != 270));
                                  paramc = this.zXf;
                                } while (paramc == null);
                                paramc.epz();
                                return;
                                paramBundle = this.zXc;
                                paramc = localObject;
                                if (paramBundle != null)
                                {
                                  paramBundle = paramBundle.zVO;
                                  paramc = localObject;
                                  if (paramBundle != null)
                                  {
                                    paramBundle = paramBundle.getMultiTalkEditPhotoWrapper();
                                    paramc = localObject;
                                    if (paramBundle != null)
                                    {
                                      paramBundle = paramBundle.zQo;
                                      paramc = localObject;
                                      if (paramBundle != null) {
                                        paramc = (com.tencent.mm.view.b.b)paramBundle.getBaseBoardView();
                                      }
                                    }
                                  }
                                }
                                if (paramc == null) {
                                  throw new kotlin.t("null cannot be cast to non-null type com.tencent.mm.view.board.MultiTalkBoardView");
                                }
                                paramc.setEnableToResponseSlid(false);
                                this.zXj = false;
                                paramc = this.zWZ;
                                if (paramc != null) {
                                  paramc.setVisibility(0);
                                }
                                epC();
                              } while ((epf() != 90) && (epf() != 270));
                              paramc = this.zXf;
                            } while (paramc == null);
                            paramc.epz();
                            return;
                          } while (paramBundle == null);
                          ac.eom().rK(paramBundle.getBoolean("mic_mute_status"));
                          return;
                          epk();
                          return;
                          sh(false);
                          return;
                        } while (paramBundle == null);
                        paramc = paramBundle.getStringArrayList("avatar_available_speaker");
                        paramBundle = this.zXf;
                        if (paramBundle != null) {
                          if (paramc == null) {
                            kotlin.g.b.p.hyc();
                          }
                        }
                        for (boolean bool = paramBundle.aD(paramc);; bool = false)
                        {
                          this.zXk = bool;
                          return;
                        }
                        this.zXk = false;
                        return;
                      } while ((this.zXj) || (this.zXl));
                      h.RTc.aV((Runnable)new f(this));
                      return;
                      this.zXo = false;
                      return;
                      paramc = this.zWX;
                      if (paramc != null) {
                        paramc.setVisibility(8);
                      }
                      setReadyNotAllowClick(false);
                      return;
                      paramc = getBackgroundView();
                    } while (paramc == null);
                    paramBundle = ev(paramc);
                  } while (paramBundle == null);
                  paramc = com.tencent.mm.plugin.multitalk.ui.widget.k.zTz;
                  paramc = getContext();
                  kotlin.g.b.p.h(paramBundle, "bitmap");
                } while (paramc == null);
                paramBundle = (Runnable)new k.a.a(paramBundle, paramc);
                localRunnable = (Runnable)new k.a.b(paramc);
                if ((paramc instanceof Activity))
                {
                  com.tencent.mm.platformtools.p.a(paramc, paramBundle, localRunnable);
                  return;
                }
                localRunnable.run();
                return;
                paramc = getBackgroundView();
              } while (paramc == null);
              paramBundle = ev(paramc);
            } while (paramBundle == null);
            paramc = com.tencent.mm.plugin.multitalk.ui.widget.k.zTz;
            paramc = getContext();
            kotlin.g.b.p.h(paramBundle, "bitmap");
          } while (paramc == null);
          paramBundle = (Runnable)new k.a.c(paramBundle, paramc);
          localRunnable = (Runnable)new k.a.d(paramc);
          if ((paramc instanceof Activity))
          {
            com.tencent.mm.platformtools.p.a(paramc, paramBundle, localRunnable);
            return;
          }
          localRunnable.run();
          return;
          paramc = getBackgroundView();
        } while (paramc == null);
        paramBundle = ev(paramc);
      } while (paramBundle == null);
      paramc = com.tencent.mm.plugin.multitalk.ui.widget.k.zTz;
      paramc = getContext();
      kotlin.g.b.p.h(paramBundle, "bitmap");
    } while (paramc == null);
    paramBundle = (Runnable)new k.a.e(paramBundle, paramc);
    localRunnable = (Runnable)new k.a.f(paramc);
    if ((paramc instanceof Activity))
    {
      com.tencent.mm.platformtools.p.a(paramc, paramBundle, localRunnable);
      return;
    }
    localRunnable.run();
  }
  
  public void aq(Bundle paramBundle) {}
  
  public final boolean bJw()
  {
    return getVisibility() == 0;
  }
  
  public final void eaa()
  {
    Object localObject = this.zXf;
    if (localObject != null)
    {
      localObject = ((j)localObject).zWE;
      if (localObject != null) {
        ((i)localObject).eaa();
      }
    }
  }
  
  public final void epB()
  {
    Object localObject = this.zXc;
    if (localObject != null) {
      ((b)localObject).show();
    }
    if ((!this.zXi) && (!this.zXl))
    {
      a.b.a(this, a.c.zVl);
      localObject = this.zXg;
      if (localObject != null) {
        ((p)localObject).eoD();
      }
    }
  }
  
  public final int epf()
  {
    Object localObject = com.tencent.mm.plugin.multitalk.ui.widget.k.zTz;
    localObject = getContext();
    kotlin.g.b.p.g(localObject, "context");
    return k.a.gE((Context)localObject);
  }
  
  public final boolean epg()
  {
    return this.zXj;
  }
  
  public final boolean eph()
  {
    return this.zXk;
  }
  
  public final int epi()
  {
    return 1;
  }
  
  public final void epk()
  {
    b localb = this.zXc;
    if (localb != null) {
      localb.epk();
    }
  }
  
  public void epp()
  {
    Object localObject1 = this.zWV;
    if (localObject1 != null) {
      ((s)localObject1).cCv = Util.ticksToNow(this.zWW);
    }
    epq();
    localObject1 = this.zXf;
    if (localObject1 != null) {
      ((j)localObject1).zWE.release();
    }
    setVisibility(8);
    localObject1 = this.zXm;
    if (localObject1 != null) {
      ((Timer)localObject1).cancel();
    }
    this.zXm = null;
    localObject1 = this.dfh;
    if (localObject1 != null) {
      ((Timer)localObject1).cancel();
    }
    this.dfh = null;
    localObject1 = this.zWX;
    if (localObject1 != null) {
      ((FrameLayout)localObject1).clearAnimation();
    }
    localObject1 = this.zXn;
    if (localObject1 != null) {
      ((MMHandler)localObject1).removeCallbacksAndMessages(null);
    }
    localObject1 = this.zXn;
    if (localObject1 != null) {
      ((MMHandler)localObject1).quitSafely();
    }
    this.zXn = null;
    localObject1 = this.zXe;
    Object localObject2;
    if (localObject1 != null)
    {
      ((r)localObject1).timerHandler.stopTimer();
      localObject2 = ((r)localObject1).hSr;
      if (localObject2 != null) {
        ((TextView)localObject2).setScaleX(1.0F);
      }
      localObject2 = ((r)localObject1).hSr;
      if (localObject2 != null) {
        ((TextView)localObject2).setScaleY(1.0F);
      }
      ((r)localObject1).hSs = ((r)localObject1).hSo;
      ((r)localObject1).timerHandler.quitSafely();
    }
    localObject1 = ac.eom();
    kotlin.g.b.p.g(localObject1, "SubCoreMultiTalk.getMultiTalkManager()");
    ((com.tencent.mm.plugin.multitalk.model.q)localObject1).enw();
    com.tencent.mm.plugin.multitalk.model.t.Rk(103);
    localObject1 = this.zWV;
    if (localObject1 != null)
    {
      localObject2 = com.tencent.mm.plugin.multitalk.d.f.zZd;
      com.tencent.mm.plugin.multitalk.d.f.a(((s)localObject1).gCr, ((s)localObject1).fileSize, ((s)localObject1).fileName, ((s)localObject1).zYf, ((s)localObject1).cCv, ((s)localObject1).errorCode, ((s)localObject1).zYg, ((s)localObject1).zYh, ((s)localObject1).zYi, ((s)localObject1).zYj);
    }
    this.zWV = null;
  }
  
  public void epq() {}
  
  public int epr()
  {
    int j = 0;
    FrameLayout localFrameLayout = this.zWZ;
    if ((localFrameLayout != null) && (localFrameLayout.getVisibility() == 0))
    {
      i = 4;
      if (i != 0) {
        break label75;
      }
    }
    label75:
    for (int i = j;; i = 4)
    {
      localFrameLayout = this.zWZ;
      if (localFrameLayout != null) {
        localFrameLayout.setVisibility(i);
      }
      localFrameLayout = this.zXa;
      if (localFrameLayout != null) {
        localFrameLayout.setVisibility(i);
      }
      localFrameLayout = this.zWX;
      if (localFrameLayout != null) {
        localFrameLayout.setVisibility(i);
      }
      return i;
      i = 0;
      break;
    }
  }
  
  public void eps() {}
  
  protected void ept() {}
  
  protected final j getAvatarLayout()
  {
    return this.zXf;
  }
  
  protected final FrameLayout getAvatarRoot()
  {
    return this.zXb;
  }
  
  public abstract View getBackgroundView();
  
  protected final FrameLayout getBottomRoot()
  {
    return this.zXa;
  }
  
  protected final k getBottomUiLayout()
  {
    return this.zXd;
  }
  
  public boolean getCurrentStatus()
  {
    return this.zXi;
  }
  
  public abstract int getLayoutId();
  
  protected final int getMCurrentPageHeight()
  {
    return this.zVL;
  }
  
  protected final int getMCurrentPageWidth()
  {
    return this.zVK;
  }
  
  protected final float getMCurrentScale()
  {
    return this.zVJ;
  }
  
  protected final FrameLayout getMEditLayout()
  {
    return this.zWY;
  }
  
  protected final Bitmap getMRawBitmap()
  {
    return this.zXh;
  }
  
  protected final FrameLayout getMReadyLayout()
  {
    return this.zWX;
  }
  
  protected final s getMScreenReportData()
  {
    return this.zWV;
  }
  
  protected final long getMStartTimes()
  {
    return this.zWW;
  }
  
  protected final b getMultiTalkStrokeContext()
  {
    return this.zXc;
  }
  
  protected final r getReadyUI()
  {
    return this.zXe;
  }
  
  public final void getRenderBitmap()
  {
    if (this.dfh != null) {}
    Object localObject;
    do
    {
      return;
      localObject = (TimerTask)new c(this);
      this.zXm = new Timer();
      Timer localTimer = this.zXm;
      if (localTimer != null) {
        localTimer.schedule((TimerTask)localObject, 1000L, 1000L);
      }
      this.dfh = new Timer();
      this.zXn = new MMHandler("screen_project");
      localObject = this.dfh;
    } while (localObject == null);
    ((Timer)localObject).schedule((TimerTask)new b(this), 0L, 1000L / com.tencent.mm.plugin.multitalk.d.e.eqc());
  }
  
  protected final e getScreenFuncConfig()
  {
    return this.zWU;
  }
  
  protected final FrameLayout getTopRoot()
  {
    return this.zWZ;
  }
  
  protected final p getTopUiLayout()
  {
    return this.zXg;
  }
  
  public final void onBack()
  {
    Object localObject2 = null;
    if (this.zXi)
    {
      d.a locala1 = new d.a(getContext());
      Object localObject1 = getContext();
      kotlin.g.b.p.g(localObject1, "context");
      localObject1 = ((Context)localObject1).getResources();
      if (localObject1 != null) {}
      for (localObject1 = ((Resources)localObject1).getString(2131765024);; localObject1 = null)
      {
        locala1.boo((String)localObject1);
        d.a locala2 = locala1.aoV(2131765023).c((DialogInterface.OnClickListener)new d(this));
        Object localObject3 = getContext();
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          localObject3 = ((Context)localObject3).getResources();
          localObject1 = localObject2;
          if (localObject3 != null) {
            localObject1 = Integer.valueOf(((Resources)localObject3).getColor(2131099818));
          }
        }
        if (localObject1 == null) {
          kotlin.g.b.p.hyc();
        }
        locala2.aoX(((Integer)localObject1).intValue());
        locala1.aoW(2131755761).d((DialogInterface.OnClickListener)l.e.zXu);
        locala1.hbn().show();
        return;
      }
    }
    ac.eom().emx();
  }
  
  public void refreshView()
  {
    this.zXk = false;
    Object localObject1 = this.zWZ;
    if (localObject1 != null) {
      ((FrameLayout)localObject1).removeAllViews();
    }
    localObject1 = com.tencent.mm.plugin.multitalk.ui.widget.k.zTz;
    localObject1 = getContext();
    kotlin.g.b.p.g(localObject1, "context");
    Object localObject3;
    if (k.a.gE((Context)localObject1) != 90)
    {
      localObject1 = com.tencent.mm.plugin.multitalk.ui.widget.k.zTz;
      localObject1 = getContext();
      kotlin.g.b.p.g(localObject1, "context");
      if (k.a.gE((Context)localObject1) != 270) {}
    }
    else
    {
      localObject2 = new RelativeLayout.LayoutParams(com.tencent.mm.plugin.multitalk.ui.widget.f.zSu, -1);
      ((RelativeLayout.LayoutParams)localObject2).removeRule(20);
      ((RelativeLayout.LayoutParams)localObject2).removeRule(10);
      ((RelativeLayout.LayoutParams)localObject2).addRule(20);
      localObject1 = this.zWZ;
      if (localObject1 == null) {
        break label332;
      }
      ((FrameLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject2 = this.zXg;
      if (localObject2 != null)
      {
        localObject3 = getContext();
        kotlin.g.b.p.g(localObject3, "context");
        kotlin.g.b.p.h(localObject3, "context");
        kotlin.g.b.p.h(localObject1, "viewGroup");
        ((p)localObject2).zXU = LayoutInflater.from((Context)localObject3).inflate(2131495749, (ViewGroup)localObject1);
        ((p)localObject2).epA();
      }
      for (localObject1 = ((p)localObject2).zXU; localObject1 == null; localObject1 = null) {
        throw new kotlin.t("null cannot be cast to non-null type android.widget.FrameLayout");
      }
    }
    Object localObject2 = new RelativeLayout.LayoutParams(-1, com.tencent.mm.plugin.multitalk.ui.widget.f.zSr);
    ((RelativeLayout.LayoutParams)localObject2).removeRule(20);
    ((RelativeLayout.LayoutParams)localObject2).removeRule(10);
    ((RelativeLayout.LayoutParams)localObject2).addRule(10);
    ((RelativeLayout.LayoutParams)localObject2).topMargin = au.getStatusBarHeight(getContext());
    localObject1 = this.zWZ;
    if (localObject1 != null)
    {
      ((FrameLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject2 = this.zXg;
      if (localObject2 != null)
      {
        localObject3 = getContext();
        kotlin.g.b.p.g(localObject3, "context");
        kotlin.g.b.p.h(localObject3, "context");
        kotlin.g.b.p.h(localObject1, "viewGroup");
        ((p)localObject2).zXU = LayoutInflater.from((Context)localObject3).inflate(2131495748, (ViewGroup)localObject1);
        ((p)localObject2).epA();
      }
      for (localObject1 = ((p)localObject2).zXU; localObject1 == null; localObject1 = null) {
        throw new kotlin.t("null cannot be cast to non-null type android.widget.FrameLayout");
      }
    }
    label332:
    localObject1 = this.zXa;
    if (localObject1 != null) {
      ((FrameLayout)localObject1).removeAllViews();
    }
    localObject1 = this.zXa;
    if (localObject1 != null)
    {
      localObject2 = com.tencent.mm.plugin.multitalk.ui.widget.k.zTz;
      localObject2 = getContext();
      kotlin.g.b.p.g(localObject2, "context");
      if (k.a.gE((Context)localObject2) != 90)
      {
        localObject2 = com.tencent.mm.plugin.multitalk.ui.widget.k.zTz;
        localObject2 = getContext();
        kotlin.g.b.p.g(localObject2, "context");
        if (k.a.gE((Context)localObject2) != 270) {
          break label1109;
        }
      }
      localObject2 = new RelativeLayout.LayoutParams(com.tencent.mm.plugin.multitalk.ui.widget.f.zSu, -1);
      ((RelativeLayout.LayoutParams)localObject2).removeRule(21);
      ((RelativeLayout.LayoutParams)localObject2).removeRule(12);
      ((RelativeLayout.LayoutParams)localObject2).addRule(21);
      ((FrameLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject2 = this.zXd;
      if (localObject2 != null)
      {
        localObject3 = getContext();
        kotlin.g.b.p.g(localObject3, "context");
        kotlin.g.b.p.h(localObject3, "context");
        kotlin.g.b.p.h(localObject1, "rootView");
        ((k)localObject2).zWH = LayoutInflater.from((Context)localObject3).inflate(2131495742, (ViewGroup)localObject1);
        ((k)localObject2).epA();
      }
    }
    ept();
    localObject1 = this.zWX;
    if (localObject1 != null)
    {
      localObject2 = new RelativeLayout.LayoutParams(-1, -1);
      localObject3 = com.tencent.mm.plugin.multitalk.ui.widget.k.zTz;
      localObject3 = getContext();
      kotlin.g.b.p.g(localObject3, "context");
      if (k.a.gE((Context)localObject3) != 90)
      {
        localObject3 = com.tencent.mm.plugin.multitalk.ui.widget.k.zTz;
        localObject3 = getContext();
        kotlin.g.b.p.g(localObject3, "context");
        if (k.a.gE((Context)localObject3) != 270) {
          break label1205;
        }
      }
      ((RelativeLayout.LayoutParams)localObject2).removeRule(16);
      ((RelativeLayout.LayoutParams)localObject2).removeRule(3);
      ((RelativeLayout.LayoutParams)localObject2).removeRule(17);
      ((RelativeLayout.LayoutParams)localObject2).removeRule(2);
      localObject3 = this.zWZ;
      if (localObject3 == null) {
        kotlin.g.b.p.hyc();
      }
      ((RelativeLayout.LayoutParams)localObject2).addRule(17, ((FrameLayout)localObject3).getId());
      localObject3 = this.zXa;
      if (localObject3 == null) {
        kotlin.g.b.p.hyc();
      }
      ((RelativeLayout.LayoutParams)localObject2).addRule(16, ((FrameLayout)localObject3).getId());
      label634:
      ((FrameLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject2 = this.zXe;
      if (localObject2 != null)
      {
        localObject3 = getContext();
        kotlin.g.b.p.g(localObject3, "context");
        kotlin.g.b.p.h(localObject3, "context");
        kotlin.g.b.p.h(localObject1, "rootView");
        ((r)localObject2).zYc = LayoutInflater.from((Context)localObject3).inflate(2131495750, (ViewGroup)localObject1);
        localObject1 = ((r)localObject2).zQw;
        if ((localObject1 == null) || (((e)localObject1).Rx(4) != true)) {
          break label1282;
        }
        ((r)localObject2).aHG();
        ((r)localObject2).timerHandler.startTimer(0L, 1000L);
        localObject1 = ((r)localObject2).zYc;
        if (localObject1 == null) {
          break label1272;
        }
        localObject1 = (TextView)((View)localObject1).findViewById(2131306592);
        label746:
        ((r)localObject2).hSr = ((TextView)localObject1);
        localObject1 = ((r)localObject2).zYc;
        if (localObject1 == null) {
          break label1277;
        }
        localObject1 = (TextView)((View)localObject1).findViewById(2131306593);
        label771:
        ((r)localObject2).zYd = ((TextView)localObject1);
      }
    }
    label776:
    eps();
    localObject1 = this.zWY;
    if (localObject1 != null)
    {
      localObject2 = new RelativeLayout.LayoutParams(-1, -1);
      localObject3 = com.tencent.mm.plugin.multitalk.ui.widget.k.zTz;
      localObject3 = getContext();
      kotlin.g.b.p.g(localObject3, "context");
      if (k.a.gE((Context)localObject3) != 90)
      {
        localObject3 = com.tencent.mm.plugin.multitalk.ui.widget.k.zTz;
        localObject3 = getContext();
        kotlin.g.b.p.g(localObject3, "context");
        if (k.a.gE((Context)localObject3) != 270) {}
      }
      else
      {
        ((RelativeLayout.LayoutParams)localObject2).removeRule(16);
        ((RelativeLayout.LayoutParams)localObject2).removeRule(3);
        ((RelativeLayout.LayoutParams)localObject2).removeRule(17);
        ((RelativeLayout.LayoutParams)localObject2).removeRule(2);
        localObject3 = this.zWZ;
        if (localObject3 == null) {
          kotlin.g.b.p.hyc();
        }
        ((RelativeLayout.LayoutParams)localObject2).addRule(17, ((FrameLayout)localObject3).getId());
        localObject3 = this.zXa;
        if (localObject3 == null) {
          kotlin.g.b.p.hyc();
        }
        ((RelativeLayout.LayoutParams)localObject2).addRule(16, ((FrameLayout)localObject3).getId());
        localObject3 = this.zXc;
        if (localObject3 != null) {
          ((b)localObject3).sc(true);
        }
        label928:
        ((FrameLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
    }
    else
    {
      localObject1 = this.zXb;
      if (localObject1 != null) {
        ((FrameLayout)localObject1).removeAllViews();
      }
      localObject1 = this.zXb;
      if (localObject1 != null)
      {
        localObject2 = new RelativeLayout.LayoutParams(-1, -1);
        localObject3 = com.tencent.mm.plugin.multitalk.ui.widget.k.zTz;
        localObject3 = getContext();
        kotlin.g.b.p.g(localObject3, "context");
        if (k.a.gE((Context)localObject3) != 90)
        {
          localObject3 = com.tencent.mm.plugin.multitalk.ui.widget.k.zTz;
          localObject3 = getContext();
          kotlin.g.b.p.g(localObject3, "context");
          if (k.a.gE((Context)localObject3) != 270) {
            break label1384;
          }
        }
        ((RelativeLayout.LayoutParams)localObject2).removeRule(16);
        ((RelativeLayout.LayoutParams)localObject2).removeRule(3);
        ((RelativeLayout.LayoutParams)localObject2).removeRule(17);
        ((RelativeLayout.LayoutParams)localObject2).removeRule(2);
        localObject3 = this.zWZ;
        if (localObject3 == null) {
          kotlin.g.b.p.hyc();
        }
        ((RelativeLayout.LayoutParams)localObject2).addRule(17, ((FrameLayout)localObject3).getId());
        localObject3 = this.zXa;
        if (localObject3 == null) {
          kotlin.g.b.p.hyc();
        }
        ((RelativeLayout.LayoutParams)localObject2).addRule(16, ((FrameLayout)localObject3).getId());
      }
    }
    for (;;)
    {
      ((FrameLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject2 = this.zXf;
      if (localObject2 != null) {
        ((j)localObject2).A((ViewGroup)localObject1);
      }
      return;
      label1109:
      localObject2 = new RelativeLayout.LayoutParams(-1, com.tencent.mm.plugin.multitalk.ui.widget.f.zSu);
      ((RelativeLayout.LayoutParams)localObject2).removeRule(21);
      ((RelativeLayout.LayoutParams)localObject2).removeRule(12);
      ((RelativeLayout.LayoutParams)localObject2).addRule(12);
      ((FrameLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject2 = this.zXd;
      if (localObject2 == null) {
        break;
      }
      localObject3 = getContext();
      kotlin.g.b.p.g(localObject3, "context");
      kotlin.g.b.p.h(localObject3, "context");
      kotlin.g.b.p.h(localObject1, "rootView");
      ((k)localObject2).zWH = LayoutInflater.from((Context)localObject3).inflate(2131495741, (ViewGroup)localObject1);
      ((k)localObject2).epA();
      break;
      label1205:
      ((RelativeLayout.LayoutParams)localObject2).removeRule(16);
      ((RelativeLayout.LayoutParams)localObject2).removeRule(3);
      ((RelativeLayout.LayoutParams)localObject2).removeRule(17);
      ((RelativeLayout.LayoutParams)localObject2).removeRule(2);
      localObject3 = this.zWZ;
      if (localObject3 == null) {
        kotlin.g.b.p.hyc();
      }
      ((RelativeLayout.LayoutParams)localObject2).addRule(3, ((FrameLayout)localObject3).getId());
      localObject3 = this.zXa;
      if (localObject3 == null) {
        kotlin.g.b.p.hyc();
      }
      ((RelativeLayout.LayoutParams)localObject2).addRule(2, ((FrameLayout)localObject3).getId());
      break label634;
      label1272:
      localObject1 = null;
      break label746;
      label1277:
      localObject1 = null;
      break label771;
      label1282:
      ((r)localObject2).epK();
      break label776;
      ((RelativeLayout.LayoutParams)localObject2).removeRule(16);
      ((RelativeLayout.LayoutParams)localObject2).removeRule(3);
      ((RelativeLayout.LayoutParams)localObject2).removeRule(17);
      ((RelativeLayout.LayoutParams)localObject2).removeRule(2);
      localObject3 = this.zXc;
      if (localObject3 != null) {
        ((b)localObject3).sc(false);
      }
      localObject3 = this.zWZ;
      if (localObject3 != null) {
        ((FrameLayout)localObject3).setVisibility(0);
      }
      localObject3 = this.zWZ;
      if (localObject3 == null) {
        kotlin.g.b.p.hyc();
      }
      ((RelativeLayout.LayoutParams)localObject2).addRule(3, ((FrameLayout)localObject3).getId());
      localObject3 = this.zXa;
      if (localObject3 == null) {
        kotlin.g.b.p.hyc();
      }
      ((RelativeLayout.LayoutParams)localObject2).addRule(2, ((FrameLayout)localObject3).getId());
      break label928;
      label1384:
      ((RelativeLayout.LayoutParams)localObject2).removeRule(16);
      ((RelativeLayout.LayoutParams)localObject2).removeRule(3);
      ((RelativeLayout.LayoutParams)localObject2).removeRule(17);
      ((RelativeLayout.LayoutParams)localObject2).removeRule(2);
      localObject3 = this.zWZ;
      if (localObject3 == null) {
        kotlin.g.b.p.hyc();
      }
      ((RelativeLayout.LayoutParams)localObject2).addRule(3, ((FrameLayout)localObject3).getId());
      localObject3 = this.zXa;
      if (localObject3 == null) {
        kotlin.g.b.p.hyc();
      }
      ((RelativeLayout.LayoutParams)localObject2).addRule(2, ((FrameLayout)localObject3).getId());
    }
  }
  
  public void sd(boolean paramBoolean)
  {
    int j = 8;
    this.zWW = Util.currentTicks();
    Object localObject = this.zWY;
    if (localObject != null) {
      if (!paramBoolean) {
        break label239;
      }
    }
    label239:
    for (int i = 0;; i = 8)
    {
      ((FrameLayout)localObject).setVisibility(i);
      localObject = this.zXg;
      if (localObject != null)
      {
        localObject = ((p)localObject).qCm;
        if (localObject != null) {
          ((TextView)localObject).setVisibility(0);
        }
      }
      localObject = this.zXd;
      if (localObject != null)
      {
        localObject = ((k)localObject).zWH;
        if (localObject != null)
        {
          i = j;
          if (paramBoolean) {
            i = 0;
          }
          ((View)localObject).setVisibility(i);
        }
      }
      localObject = this.zXc;
      if (localObject != null)
      {
        FrameLayout localFrameLayout = this.zWY;
        if (localFrameLayout != null) {
          localFrameLayout.addView((View)((b)localObject).zVI);
        }
      }
      localObject = this.zWX;
      if (localObject != null) {
        ((FrameLayout)localObject).setVisibility(0);
      }
      localObject = this.zWX;
      if (localObject != null) {
        ((FrameLayout)localObject).clearAnimation();
      }
      localObject = this.zWX;
      if (localObject != null)
      {
        localObject = ((FrameLayout)localObject).animate();
        if (localObject != null)
        {
          localObject = ((ViewPropertyAnimator)localObject).setStartDelay(3000L);
          if (localObject != null)
          {
            localObject = ((ViewPropertyAnimator)localObject).setDuration(150L);
            if (localObject != null)
            {
              localObject = ((ViewPropertyAnimator)localObject).alpha(0.0F);
              if (localObject != null) {
                ((ViewPropertyAnimator)localObject).start();
              }
            }
          }
        }
      }
      return;
    }
  }
  
  protected final void setAvatarLayout(j paramj)
  {
    this.zXf = paramj;
  }
  
  public final void setAvatarLayoutOn(boolean paramBoolean)
  {
    this.zXk = paramBoolean;
  }
  
  protected final void setAvatarRoot(FrameLayout paramFrameLayout)
  {
    this.zXb = paramFrameLayout;
  }
  
  protected final void setBottomRoot(FrameLayout paramFrameLayout)
  {
    this.zXa = paramFrameLayout;
  }
  
  protected final void setBottomUiLayout(k paramk)
  {
    this.zXd = paramk;
  }
  
  public final void setDoodleLayoutOn(boolean paramBoolean)
  {
    this.zXj = paramBoolean;
  }
  
  protected final void setLockGenerateBitmap(boolean paramBoolean)
  {
    this.zXo = paramBoolean;
  }
  
  protected final void setMCurrentPageHeight(int paramInt)
  {
    this.zVL = paramInt;
  }
  
  protected final void setMCurrentPageWidth(int paramInt)
  {
    this.zVK = paramInt;
  }
  
  protected final void setMCurrentScale(float paramFloat)
  {
    this.zVJ = paramFloat;
  }
  
  protected final void setMEditLayout(FrameLayout paramFrameLayout)
  {
    this.zWY = paramFrameLayout;
  }
  
  protected final void setMRawBitmap(Bitmap paramBitmap)
  {
    this.zXh = paramBitmap;
  }
  
  protected final void setMReadyLayout(FrameLayout paramFrameLayout)
  {
    this.zWX = paramFrameLayout;
  }
  
  protected final void setMScreenReportData(s params)
  {
    this.zWV = params;
  }
  
  protected final void setMStartTimes(long paramLong)
  {
    this.zWW = paramLong;
  }
  
  protected final void setMultiTalkStrokeContext(b paramb)
  {
    this.zXc = paramb;
  }
  
  public final void setReadyNotAllowClick(boolean paramBoolean)
  {
    boolean bool2 = true;
    this.zXl = paramBoolean;
    Object localObject = this.zXc;
    boolean bool1;
    if (localObject != null)
    {
      if (paramBoolean) {
        break label66;
      }
      bool1 = true;
      localObject = ((b)localObject).zVO;
      if (localObject != null) {
        ((com.tencent.mm.plugin.multitalk.ui.a.b)localObject).setDrawingEnable(bool1);
      }
    }
    localObject = this.zXd;
    if (localObject != null) {
      if (paramBoolean) {
        break label71;
      }
    }
    label66:
    label71:
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      ((k)localObject).zWR = paramBoolean;
      return;
      bool1 = false;
      break;
    }
  }
  
  protected final void setReadyUI(r paramr)
  {
    this.zXe = paramr;
  }
  
  protected final void setScreenFuncConfig(e parame)
  {
    this.zWU = parame;
  }
  
  public final void setScreenProjectSending(boolean paramBoolean)
  {
    this.zXi = paramBoolean;
    ac.eom().zMz = paramBoolean;
  }
  
  protected final void setTopRoot(FrameLayout paramFrameLayout)
  {
    this.zWZ = paramFrameLayout;
  }
  
  protected final void setTopUiLayout(p paramp)
  {
    this.zXg = paramp;
  }
  
  public final void sh(boolean paramBoolean)
  {
    setScreenProjectSending(false);
    Object localObject = this.zXn;
    if (localObject != null) {
      ((MMHandler)localObject).removeCallbacksAndMessages(null);
    }
    localObject = this.zXn;
    if (localObject != null) {
      ((MMHandler)localObject).quitSafely();
    }
    this.zXn = null;
    localObject = this.dfh;
    if (localObject != null) {
      ((Timer)localObject).cancel();
    }
    localObject = this.zXm;
    if (localObject != null) {
      ((Timer)localObject).cancel();
    }
    this.zXm = null;
    this.dfh = null;
    if (paramBoolean)
    {
      ac.eom();
      com.tencent.mm.plugin.multitalk.model.q.Rj(102);
    }
    for (;;)
    {
      ac.eom().emx();
      return;
      ac.eom();
      com.tencent.mm.plugin.multitalk.model.q.Rj(103);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectRootView$getRenderBitmap$1", "Ljava/util/TimerTask;", "run", "", "plugin-multitalk_release"})
  public static final class b
    extends TimerTask
  {
    public final void run()
    {
      AppMethodBeat.i(240024);
      if (!ac.eom().zMA)
      {
        final z.f localf = new z.f();
        localf.SYG = ((kotlin.g.a.b)new b(this));
        h.RTc.aV((Runnable)new a(this, localf));
      }
      AppMethodBeat.o(240024);
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(l.b paramb, z.f paramf) {}
      
      public final void run()
      {
        AppMethodBeat.i(240021);
        if (!this.zXr.zXq.zXo)
        {
          Object localObject2 = this.zXr.zXq.getBackgroundView();
          if (localObject2 != null)
          {
            long l2 = Util.currentTicks();
            Object localObject1 = this.zXr.zXq.getScreenFuncConfig();
            boolean bool;
            int i;
            int j;
            if (localObject1 != null)
            {
              bool = ((e)localObject1).Ry(11);
              localObject1 = this.zXr.zXq;
              kotlin.g.b.p.h(localObject2, "view");
              i = ((View)localObject2).getMeasuredWidth() - ((View)localObject2).getMeasuredWidth() % 4;
              j = ((View)localObject2).getMeasuredHeight() - ((View)localObject2).getMeasuredHeight() % 4;
              if ((i > 0) && (j > 0)) {
                break label221;
              }
              localObject1 = null;
              label121:
              if (localObject1 != null)
              {
                localObject2 = (kotlin.g.a.b)localf.SYG;
                if (localObject2 != null) {
                  ((kotlin.g.a.b)localObject2).invoke(localObject1);
                }
              }
              localObject1 = this.zXr.zXq.getMScreenReportData();
              if (localObject1 == null) {
                break label562;
              }
              localObject2 = this.zXr.zXq.getMScreenReportData();
              if (localObject2 == null) {
                break label557;
              }
            }
            label290:
            label552:
            label557:
            for (long l1 = ((s)localObject2).zYg;; l1 = 0L)
            {
              ((s)localObject1).zYg = ((l1 + Util.ticksToNow(l2)) / 2L);
              AppMethodBeat.o(240021);
              return;
              bool = false;
              break;
              label221:
              if (((l)localObject1).zXh != null)
              {
                localObject3 = ((l)localObject1).zXh;
                if (localObject3 == null) {
                  kotlin.g.b.p.hyc();
                }
                if (((Bitmap)localObject3).getWidth() == i)
                {
                  localObject3 = ((l)localObject1).zXh;
                  if (localObject3 == null) {
                    kotlin.g.b.p.hyc();
                  }
                  if (((Bitmap)localObject3).getHeight() == j) {
                    break label290;
                  }
                }
              }
              ((l)localObject1).zXh = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
              l1 = Util.currentTicks();
              if (((l)localObject1).zXh != null)
              {
                localObject3 = ((l)localObject1).zXh;
                if ((localObject3 == null) || (((Bitmap)localObject3).isRecycled() != true)) {}
              }
              else
              {
                localObject1 = null;
                break label121;
              }
              Object localObject3 = ((l)localObject1).zXh;
              if (localObject3 == null) {
                kotlin.g.b.p.hyc();
              }
              localObject3 = new Canvas((Bitmap)localObject3);
              ((Canvas)localObject3).drawPaint(new Paint());
              ((Canvas)localObject3).setDrawFilter((DrawFilter)new PaintFlagsDrawFilter(0, 3));
              if (!bool) {
                ((View)localObject2).draw((Canvas)localObject3);
              }
              long l3 = Util.ticksToNow(l1);
              localObject2 = ((l)localObject1).zWV;
              if (localObject2 != null)
              {
                s locals = ((l)localObject1).zWV;
                if (locals != null)
                {
                  l1 = locals.zYi;
                  label432:
                  ((s)localObject2).zYi = ((l1 + l3) / 2L);
                }
              }
              else
              {
                l1 = Util.currentTicks();
                localObject2 = ((l)localObject1).zXc;
                if (localObject2 != null) {
                  ((b)localObject2).t((Canvas)localObject3);
                }
                l3 = Util.ticksToNow(l1);
                localObject2 = ((l)localObject1).zWV;
                if (localObject2 != null)
                {
                  localObject3 = ((l)localObject1).zWV;
                  if (localObject3 == null) {
                    break label552;
                  }
                }
              }
              for (l1 = ((s)localObject3).zYh;; l1 = 0L)
              {
                ((s)localObject2).zYh = ((l1 + l3) / 2L);
                if (i > j) {
                  ((l)localObject1).zXh = BitmapUtil.rotate(((l)localObject1).zXh, 90.0F);
                }
                localObject1 = ((l)localObject1).zXh;
                break;
                l1 = 0L;
                break label432;
              }
            }
            label562:
            AppMethodBeat.o(240021);
            return;
          }
        }
        AppMethodBeat.o(240021);
      }
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/graphics/Bitmap;", "invoke"})
    static final class b
      extends kotlin.g.b.q
      implements kotlin.g.a.b<Bitmap, x>
    {
      b(l.b paramb)
      {
        super();
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectRootView$getRenderBitmap$task$1", "Ljava/util/TimerTask;", "run", "", "plugin-multitalk_release"})
  public static final class c
    extends TimerTask
  {
    public final void run()
    {
      AppMethodBeat.i(240025);
      s locals1 = this.zXq.getMScreenReportData();
      if (locals1 != null)
      {
        s locals2 = this.zXq.getMScreenReportData();
        if (locals2 != null) {}
        for (int i = locals2.zYj;; i = 0)
        {
          locals1.zYj = ((i + l.b(this.zXq)) / 2);
          AppMethodBeat.o(240025);
          return;
        }
      }
      AppMethodBeat.o(240025);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "arg0", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "arg1", "", "onClick"})
  static final class d
    implements DialogInterface.OnClickListener
  {
    d(l paraml) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(240026);
      l.a(this.zXq);
      paramDialogInterface.dismiss();
      AppMethodBeat.o(240026);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class f
    implements Runnable
  {
    f(l paraml) {}
    
    public final void run()
    {
      AppMethodBeat.i(240029);
      this.zXq.epr();
      AppMethodBeat.o(240029);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.projector.l
 * JD-Core Version:    0.7.0.1
 */
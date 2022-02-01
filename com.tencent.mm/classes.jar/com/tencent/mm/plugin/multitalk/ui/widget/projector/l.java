package com.tencent.mm.plugin.multitalk.ui.widget.projector;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.DrawFilter;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.b.c;
import com.tencent.mm.plugin.multitalk.a.b;
import com.tencent.mm.plugin.multitalk.a.e;
import com.tencent.mm.plugin.multitalk.a.f;
import com.tencent.mm.plugin.multitalk.a.h;
import com.tencent.mm.plugin.multitalk.model.ad;
import com.tencent.mm.plugin.multitalk.model.q;
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
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.widget.a.d.a;
import java.util.TimerTask;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectRootView;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "avatarLayout", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectAvatarUI;", "getAvatarLayout", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectAvatarUI;", "setAvatarLayout", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectAvatarUI;)V", "avatarRoot", "Landroid/widget/FrameLayout;", "getAvatarRoot", "()Landroid/widget/FrameLayout;", "setAvatarRoot", "(Landroid/widget/FrameLayout;)V", "bitmapRenderPrco", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/render/ScreenProjectCanvasRendererMgr;", "getBitmapRenderPrco", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/render/ScreenProjectCanvasRendererMgr;", "setBitmapRenderPrco", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/render/ScreenProjectCanvasRendererMgr;)V", "bottomRoot", "getBottomRoot", "setBottomRoot", "bottomUiLayout", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectBottomUI;", "getBottomUiLayout", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectBottomUI;", "setBottomUiLayout", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectBottomUI;)V", "fpsFuture", "Lcom/tencent/threadpool/runnable/FutureEx;", "isAvatarLayoutOn", "", "()Z", "setAvatarLayoutOn", "(Z)V", "isDoodleLayoutOn", "setDoodleLayoutOn", "isLockGenerateBitmap", "setLockGenerateBitmap", "value", "isReadyNotAllowClick", "setReadyNotAllowClick", "isScreenProjectSending", "setScreenProjectSending", "mCurrentPageHeight", "", "getMCurrentPageHeight", "()I", "setMCurrentPageHeight", "(I)V", "mCurrentPageWidth", "getMCurrentPageWidth", "setMCurrentPageWidth", "mCurrentScale", "", "getMCurrentScale", "()F", "setMCurrentScale", "(F)V", "mEditLayout", "getMEditLayout", "setMEditLayout", "mFps", "mReadyLayout", "getMReadyLayout", "setMReadyLayout", "mScreenReportData", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenReportData;", "getMScreenReportData", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenReportData;", "setMScreenReportData", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenReportData;)V", "mStartTimes", "", "getMStartTimes", "()J", "setMStartTimes", "(J)V", "multiTalkStrokeContext", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/MultiTalkStrokeLayout;", "getMultiTalkStrokeContext", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/MultiTalkStrokeLayout;", "setMultiTalkStrokeContext", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/MultiTalkStrokeLayout;)V", "readyUI", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenReadyUI;", "getReadyUI", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenReadyUI;", "setReadyUI", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenReadyUI;)V", "renderTarget", "Landroid/view/Surface;", "screenFuncConfig", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;", "getScreenFuncConfig", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;", "setScreenFuncConfig", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;)V", "sendData", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getSendData", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "setSendData", "(Lcom/tencent/mm/sdk/platformtools/MMHandler;)V", "timerFuture", "topRoot", "getTopRoot", "setTopRoot", "topUiLayout", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectTopUI;", "getTopUiLayout", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectTopUI;", "setTopUiLayout", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectTopUI;)V", "applyAvatarLayout", "", "applyBottomUI", "applyEditorLayout", "isFullScreen", "applyReaderUI", "applyReadyLayout", "applyThumbnailUI", "applyTopUI", "checkCallerState", "checkCurrentInAvatarLayout", "checkCurrentInDoodleLayout", "checkCurrentOrientation", "clearScreen", "closeReaderRenderer", "dismissProjectScreen", "enterScreenDoodle", "getBackgroundView", "Landroid/view/View;", "getBitmapShot", "Landroid/graphics/Bitmap;", "view", "getCurrentStatus", "getLayoutId", "getRenderBitmap", "initView", "inputScreenProjectInfo", "params", "Landroid/os/Bundle;", "pageIndex", "isShow", "onBack", "onTimeSecondCallback", "refreshView", "renderBitmap", "ignoreBg", "reportScreenProject", "responeScreenClick", "setBitmapBackgroundRenderTarget", "surface", "showReaderContent", "show", "showStrokeContent", "statusChange", "status", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus$ProjectStatus;", "param", "stopScreenProjectSend", "isMini", "Companion", "plugin-multitalk_release"})
public abstract class l
  extends RelativeLayout
  implements a
{
  public static final l.a FCZ = new l.a((byte)0);
  private float FBt;
  private int FBu;
  private int FBv;
  private e FCC;
  private s FCD;
  private long FCE;
  private FrameLayout FCF;
  private FrameLayout FCG;
  private FrameLayout FCH;
  private FrameLayout FCI;
  private FrameLayout FCJ;
  b FCK;
  private k FCL;
  private r FCM;
  private j FCN;
  p FCO;
  private com.tencent.mm.plugin.multitalk.ui.widget.projector.b.a FCP;
  private Surface FCQ;
  boolean FCR;
  private boolean FCS;
  private boolean FCT;
  boolean FCU = true;
  private com.tencent.e.i.d<?> FCV;
  private com.tencent.e.i.d<?> FCW;
  private MMHandler FCX;
  volatile boolean FCY;
  private int ksc;
  
  public l(Context paramContext)
  {
    super(paramContext);
  }
  
  private void eZq()
  {
    b localb = this.FCK;
    if (localb != null)
    {
      if (localb.FBA)
      {
        localb1 = localb.FBy;
        if (localb1 != null) {
          localb1.setVisibility(0);
        }
        localb.eYZ();
        localb.FBA = false;
      }
    }
    else {
      return;
    }
    localb.eYZ();
    com.tencent.mm.plugin.multitalk.ui.a.b localb1 = localb.FBy;
    if (localb1 != null) {
      localb1.setVisibility(0);
    }
    localb.FBA = true;
  }
  
  private Bitmap fv(View paramView)
  {
    long l2 = 0L;
    kotlin.g.b.p.k(paramView, "view");
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
    paramView = this.FCD;
    s locals;
    if (paramView != null)
    {
      locals = this.FCD;
      if (locals == null) {
        break label250;
      }
    }
    label250:
    for (long l1 = locals.FDU;; l1 = 0L)
    {
      paramView.FDU = ((l1 + l3) / 2L);
      l1 = Util.currentTicks();
      paramView = this.FCK;
      if (paramView != null) {
        paramView.v((Canvas)localObject);
      }
      l3 = Util.ticksToNow(l1);
      paramView = this.FCD;
      if (paramView != null)
      {
        localObject = this.FCD;
        l1 = l2;
        if (localObject != null) {
          l1 = ((s)localObject).FDT;
        }
        paramView.FDT = ((l3 + l1) / 2L);
      }
      if (i <= j) {
        break;
      }
      return BitmapUtil.rotate(localBitmap, 90.0F);
    }
    return localBitmap;
  }
  
  private final void setBitmapBackgroundRenderTarget(Surface paramSurface)
  {
    this.FCQ = paramSurface;
  }
  
  public void a(a.c paramc, Bundle paramBundle)
  {
    Object localObject = null;
    Runnable localRunnable = null;
    kotlin.g.b.p.k(paramc, "status");
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
                                    ad.eYc();
                                    q.Xx(101);
                                    setScreenProjectSending(true);
                                    return;
                                    vj(false);
                                    return;
                                    this.FCS = true;
                                    paramc = this.FCH;
                                    if (paramc != null) {
                                      paramc.setVisibility(4);
                                    }
                                    paramBundle = this.FCK;
                                    paramc = localRunnable;
                                    if (paramBundle != null)
                                    {
                                      paramBundle = paramBundle.FBy;
                                      paramc = localRunnable;
                                      if (paramBundle != null)
                                      {
                                        paramBundle = paramBundle.getMultiTalkEditPhotoWrapper();
                                        paramc = localRunnable;
                                        if (paramBundle != null)
                                        {
                                          paramBundle = paramBundle.FvR;
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
                                    eZq();
                                  } while ((eYV() != 90) && (eYV() != 270));
                                  paramc = this.FCN;
                                } while (paramc == null);
                                paramc.eZm();
                                return;
                                paramBundle = this.FCK;
                                paramc = localObject;
                                if (paramBundle != null)
                                {
                                  paramBundle = paramBundle.FBy;
                                  paramc = localObject;
                                  if (paramBundle != null)
                                  {
                                    paramBundle = paramBundle.getMultiTalkEditPhotoWrapper();
                                    paramc = localObject;
                                    if (paramBundle != null)
                                    {
                                      paramBundle = paramBundle.FvR;
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
                                this.FCS = false;
                                paramc = this.FCH;
                                if (paramc != null) {
                                  paramc.setVisibility(0);
                                }
                                eZq();
                              } while ((eYV() != 90) && (eYV() != 270));
                              paramc = this.FCN;
                            } while (paramc == null);
                            paramc.eZm();
                            return;
                          } while (paramBundle == null);
                          ad.eYc().uN(paramBundle.getBoolean("mic_mute_status"));
                          return;
                          eZa();
                          return;
                          vj(false);
                          return;
                        } while (paramBundle == null);
                        paramc = paramBundle.getStringArrayList("avatar_available_speaker");
                        paramBundle = this.FCN;
                        if (paramBundle != null) {
                          if (paramc == null) {
                            kotlin.g.b.p.iCn();
                          }
                        }
                        for (boolean bool = paramBundle.aK(paramc);; bool = false)
                        {
                          this.FCT = bool;
                          return;
                        }
                        this.FCT = false;
                        return;
                      } while ((this.FCS) || (this.FCU));
                      h.ZvG.bc((Runnable)new g(this));
                      return;
                      this.FCY = false;
                      return;
                      paramc = this.FCF;
                      if (paramc != null) {
                        paramc.setVisibility(8);
                      }
                      setReadyNotAllowClick(false);
                      return;
                      paramc = getBackgroundView();
                    } while (paramc == null);
                    paramBundle = fv(paramc);
                  } while (paramBundle == null);
                  paramc = com.tencent.mm.plugin.multitalk.ui.widget.k.Fzb;
                  paramc = getContext();
                  kotlin.g.b.p.k(paramBundle, "bitmap");
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
              paramBundle = fv(paramc);
            } while (paramBundle == null);
            paramc = com.tencent.mm.plugin.multitalk.ui.widget.k.Fzb;
            paramc = getContext();
            kotlin.g.b.p.k(paramBundle, "bitmap");
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
        paramBundle = fv(paramc);
      } while (paramBundle == null);
      paramc = com.tencent.mm.plugin.multitalk.ui.widget.k.Fzb;
      paramc = getContext();
      kotlin.g.b.p.k(paramBundle, "bitmap");
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
  
  public void ak(Bundle paramBundle) {}
  
  public final boolean bVd()
  {
    return getVisibility() == 0;
  }
  
  public final void eIY()
  {
    Object localObject = this.FCN;
    if (localObject != null)
    {
      localObject = ((j)localObject).FCm;
      if (localObject != null) {
        ((i)localObject).eIY();
      }
    }
  }
  
  public final int eYV()
  {
    Object localObject = com.tencent.mm.plugin.multitalk.ui.widget.k.Fzb;
    localObject = getContext();
    kotlin.g.b.p.j(localObject, "context");
    return k.a.hB((Context)localObject);
  }
  
  public final boolean eYW()
  {
    return this.FCS;
  }
  
  public final boolean eYX()
  {
    return this.FCT;
  }
  
  public final int eYY()
  {
    return 1;
  }
  
  public final void eZa()
  {
    b localb = this.FCK;
    if (localb != null) {
      localb.eZa();
    }
  }
  
  public void eZf()
  {
    Object localObject1 = this.FCD;
    if (localObject1 != null) {
      ((s)localObject1).cCY = Util.ticksToNow(this.FCE);
    }
    eZg();
    localObject1 = this.FCN;
    if (localObject1 != null) {
      ((j)localObject1).FCm.release();
    }
    setVisibility(8);
    localObject1 = this.FCW;
    if (localObject1 != null) {
      ((com.tencent.e.i.d)localObject1).cancel(false);
    }
    this.FCW = null;
    localObject1 = this.FCV;
    if (localObject1 != null) {
      ((com.tencent.e.i.d)localObject1).cancel(false);
    }
    this.FCV = null;
    localObject1 = this.FCF;
    if (localObject1 != null) {
      ((FrameLayout)localObject1).clearAnimation();
    }
    localObject1 = this.FCX;
    if (localObject1 != null) {
      ((MMHandler)localObject1).removeCallbacksAndMessages(null);
    }
    localObject1 = this.FCX;
    if (localObject1 != null) {
      ((MMHandler)localObject1).quitSafely();
    }
    this.FCX = null;
    localObject1 = this.FCM;
    Object localObject2;
    if (localObject1 != null)
    {
      ((r)localObject1).timerHandler.stopTimer();
      localObject2 = ((r)localObject1).kGO;
      if (localObject2 != null) {
        ((TextView)localObject2).setScaleX(1.0F);
      }
      localObject2 = ((r)localObject1).kGO;
      if (localObject2 != null) {
        ((TextView)localObject2).setScaleY(1.0F);
      }
      ((r)localObject1).kGP = ((r)localObject1).kGL;
      ((r)localObject1).timerHandler.quitSafely();
    }
    localObject1 = ad.eYc();
    kotlin.g.b.p.j(localObject1, "SubCoreMultiTalk.getMultiTalkManager()");
    ((q)localObject1).eXm();
    com.tencent.mm.plugin.multitalk.model.t.Xy(103);
    localObject1 = this.FCD;
    if (localObject1 != null)
    {
      localObject2 = com.tencent.mm.plugin.multitalk.d.f.FEQ;
      com.tencent.mm.plugin.multitalk.d.f.a(((s)localObject1).jmx, ((s)localObject1).fileSize, ((s)localObject1).fileName, ((s)localObject1).FDR, ((s)localObject1).cCY, ((s)localObject1).errorCode, ((s)localObject1).FDS, ((s)localObject1).FDT, ((s)localObject1).FDU, ((s)localObject1).FDV);
    }
    this.FCD = null;
  }
  
  public void eZg() {}
  
  public int eZh()
  {
    int j = 0;
    FrameLayout localFrameLayout = this.FCH;
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
      localFrameLayout = this.FCH;
      if (localFrameLayout != null) {
        localFrameLayout.setVisibility(i);
      }
      localFrameLayout = this.FCI;
      if (localFrameLayout != null) {
        localFrameLayout.setVisibility(i);
      }
      localFrameLayout = this.FCF;
      if (localFrameLayout != null) {
        localFrameLayout.setVisibility(i);
      }
      return i;
      i = 0;
      break;
    }
  }
  
  public void eZi() {}
  
  protected void eZj() {}
  
  public final boolean eZp()
  {
    return this.FCS;
  }
  
  protected final j getAvatarLayout()
  {
    return this.FCN;
  }
  
  protected final FrameLayout getAvatarRoot()
  {
    return this.FCJ;
  }
  
  public abstract View getBackgroundView();
  
  protected final com.tencent.mm.plugin.multitalk.ui.widget.projector.b.a getBitmapRenderPrco()
  {
    return this.FCP;
  }
  
  protected final FrameLayout getBottomRoot()
  {
    return this.FCI;
  }
  
  protected final k getBottomUiLayout()
  {
    return this.FCL;
  }
  
  public boolean getCurrentStatus()
  {
    return this.FCR;
  }
  
  public abstract int getLayoutId();
  
  protected final int getMCurrentPageHeight()
  {
    return this.FBv;
  }
  
  protected final int getMCurrentPageWidth()
  {
    return this.FBu;
  }
  
  protected final float getMCurrentScale()
  {
    return this.FBt;
  }
  
  protected final FrameLayout getMEditLayout()
  {
    return this.FCG;
  }
  
  protected final FrameLayout getMReadyLayout()
  {
    return this.FCF;
  }
  
  protected final s getMScreenReportData()
  {
    return this.FCD;
  }
  
  protected final long getMStartTimes()
  {
    return this.FCE;
  }
  
  protected final b getMultiTalkStrokeContext()
  {
    return this.FCK;
  }
  
  protected final r getReadyUI()
  {
    return this.FCM;
  }
  
  public final void getRenderBitmap()
  {
    if (this.FCV != null) {
      return;
    }
    TimerTask localTimerTask = (TimerTask)new c(this);
    this.FCW = h.ZvG.b((Runnable)localTimerTask, 1000L, 1000L);
    this.FCX = new MMHandler("screen_project");
    this.FCV = h.ZvG.b((Runnable)new b(this), 0L, 1000L / com.tencent.mm.plugin.multitalk.d.e.eZT());
  }
  
  protected final e getScreenFuncConfig()
  {
    return this.FCC;
  }
  
  protected final MMHandler getSendData()
  {
    return this.FCX;
  }
  
  protected final FrameLayout getTopRoot()
  {
    return this.FCH;
  }
  
  protected final p getTopUiLayout()
  {
    return this.FCO;
  }
  
  public final void onBack()
  {
    Object localObject2 = null;
    if (this.FCR)
    {
      d.a locala1 = new d.a(getContext());
      Object localObject1 = getContext();
      kotlin.g.b.p.j(localObject1, "context");
      localObject1 = ((Context)localObject1).getResources();
      if (localObject1 != null) {}
      for (localObject1 = ((Resources)localObject1).getString(a.h.screen_projector_stop_tip);; localObject1 = null)
      {
        locala1.bBd((String)localObject1);
        d.a locala2 = locala1.ayj(a.h.screen_projector_pause_btn).c((DialogInterface.OnClickListener)new l.d(this));
        Object localObject3 = getContext();
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          localObject3 = ((Context)localObject3).getResources();
          localObject1 = localObject2;
          if (localObject3 != null) {
            localObject1 = Integer.valueOf(((Resources)localObject3).getColor(a.b.Red));
          }
        }
        if (localObject1 == null) {
          kotlin.g.b.p.iCn();
        }
        locala2.ayl(((Integer)localObject1).intValue());
        locala1.ayk(a.h.app_cancel).d((DialogInterface.OnClickListener)l.e.FDc);
        locala1.icu().show();
        return;
      }
    }
    ad.eYc().eWl();
  }
  
  public void refreshView()
  {
    this.FCT = false;
    Object localObject1 = this.FCH;
    if (localObject1 != null) {
      ((FrameLayout)localObject1).removeAllViews();
    }
    localObject1 = com.tencent.mm.plugin.multitalk.ui.widget.k.Fzb;
    localObject1 = getContext();
    kotlin.g.b.p.j(localObject1, "context");
    Object localObject3;
    if (k.a.hB((Context)localObject1) != 90)
    {
      localObject1 = com.tencent.mm.plugin.multitalk.ui.widget.k.Fzb;
      localObject1 = getContext();
      kotlin.g.b.p.j(localObject1, "context");
      if (k.a.hB((Context)localObject1) != 270) {}
    }
    else
    {
      localObject2 = new RelativeLayout.LayoutParams(com.tencent.mm.plugin.multitalk.ui.widget.f.FxW, -1);
      ((RelativeLayout.LayoutParams)localObject2).removeRule(20);
      ((RelativeLayout.LayoutParams)localObject2).removeRule(10);
      ((RelativeLayout.LayoutParams)localObject2).addRule(20);
      localObject1 = this.FCH;
      if (localObject1 == null) {
        break label332;
      }
      ((FrameLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject2 = this.FCO;
      if (localObject2 != null)
      {
        localObject3 = getContext();
        kotlin.g.b.p.j(localObject3, "context");
        kotlin.g.b.p.k(localObject3, "context");
        kotlin.g.b.p.k(localObject1, "viewGroup");
        ((p)localObject2).FDG = LayoutInflater.from((Context)localObject3).inflate(a.f.multitalk_screen_project_top_ui_land, (ViewGroup)localObject1);
        ((p)localObject2).eZo();
      }
      for (localObject1 = ((p)localObject2).FDG; localObject1 == null; localObject1 = null) {
        throw new kotlin.t("null cannot be cast to non-null type android.widget.FrameLayout");
      }
    }
    Object localObject2 = new RelativeLayout.LayoutParams(-1, com.tencent.mm.plugin.multitalk.ui.widget.f.FxT);
    ((RelativeLayout.LayoutParams)localObject2).removeRule(20);
    ((RelativeLayout.LayoutParams)localObject2).removeRule(10);
    ((RelativeLayout.LayoutParams)localObject2).addRule(10);
    ((RelativeLayout.LayoutParams)localObject2).topMargin = ax.getStatusBarHeight(getContext());
    localObject1 = this.FCH;
    if (localObject1 != null)
    {
      ((FrameLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject2 = this.FCO;
      if (localObject2 != null)
      {
        localObject3 = getContext();
        kotlin.g.b.p.j(localObject3, "context");
        kotlin.g.b.p.k(localObject3, "context");
        kotlin.g.b.p.k(localObject1, "viewGroup");
        ((p)localObject2).FDG = LayoutInflater.from((Context)localObject3).inflate(a.f.multitalk_screen_project_top_ui, (ViewGroup)localObject1);
        ((p)localObject2).eZo();
      }
      for (localObject1 = ((p)localObject2).FDG; localObject1 == null; localObject1 = null) {
        throw new kotlin.t("null cannot be cast to non-null type android.widget.FrameLayout");
      }
    }
    label332:
    localObject1 = this.FCI;
    if (localObject1 != null) {
      ((FrameLayout)localObject1).removeAllViews();
    }
    localObject1 = this.FCI;
    if (localObject1 != null)
    {
      localObject2 = com.tencent.mm.plugin.multitalk.ui.widget.k.Fzb;
      localObject2 = getContext();
      kotlin.g.b.p.j(localObject2, "context");
      if (k.a.hB((Context)localObject2) != 90)
      {
        localObject2 = com.tencent.mm.plugin.multitalk.ui.widget.k.Fzb;
        localObject2 = getContext();
        kotlin.g.b.p.j(localObject2, "context");
        if (k.a.hB((Context)localObject2) != 270) {
          break label1109;
        }
      }
      localObject2 = new RelativeLayout.LayoutParams(com.tencent.mm.plugin.multitalk.ui.widget.f.FxW, -1);
      ((RelativeLayout.LayoutParams)localObject2).removeRule(21);
      ((RelativeLayout.LayoutParams)localObject2).removeRule(12);
      ((RelativeLayout.LayoutParams)localObject2).addRule(21);
      ((FrameLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject2 = this.FCL;
      if (localObject2 != null)
      {
        localObject3 = getContext();
        kotlin.g.b.p.j(localObject3, "context");
        kotlin.g.b.p.k(localObject3, "context");
        kotlin.g.b.p.k(localObject1, "rootView");
        ((k)localObject2).FCp = LayoutInflater.from((Context)localObject3).inflate(a.f.multitalk_screen_project_bottom_ui_land, (ViewGroup)localObject1);
        ((k)localObject2).eZo();
      }
    }
    eZj();
    localObject1 = this.FCF;
    if (localObject1 != null)
    {
      localObject2 = new RelativeLayout.LayoutParams(-1, -1);
      localObject3 = com.tencent.mm.plugin.multitalk.ui.widget.k.Fzb;
      localObject3 = getContext();
      kotlin.g.b.p.j(localObject3, "context");
      if (k.a.hB((Context)localObject3) != 90)
      {
        localObject3 = com.tencent.mm.plugin.multitalk.ui.widget.k.Fzb;
        localObject3 = getContext();
        kotlin.g.b.p.j(localObject3, "context");
        if (k.a.hB((Context)localObject3) != 270) {
          break label1205;
        }
      }
      ((RelativeLayout.LayoutParams)localObject2).removeRule(16);
      ((RelativeLayout.LayoutParams)localObject2).removeRule(3);
      ((RelativeLayout.LayoutParams)localObject2).removeRule(17);
      ((RelativeLayout.LayoutParams)localObject2).removeRule(2);
      localObject3 = this.FCH;
      if (localObject3 == null) {
        kotlin.g.b.p.iCn();
      }
      ((RelativeLayout.LayoutParams)localObject2).addRule(17, ((FrameLayout)localObject3).getId());
      localObject3 = this.FCI;
      if (localObject3 == null) {
        kotlin.g.b.p.iCn();
      }
      ((RelativeLayout.LayoutParams)localObject2).addRule(16, ((FrameLayout)localObject3).getId());
      label634:
      ((FrameLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject2 = this.FCM;
      if (localObject2 != null)
      {
        localObject3 = getContext();
        kotlin.g.b.p.j(localObject3, "context");
        kotlin.g.b.p.k(localObject3, "context");
        kotlin.g.b.p.k(localObject1, "rootView");
        ((r)localObject2).FDO = LayoutInflater.from((Context)localObject3).inflate(a.f.multitalk_screen_ready_ui, (ViewGroup)localObject1);
        localObject1 = ((r)localObject2).FvZ;
        if ((localObject1 == null) || (((e)localObject1).XO(4) != true)) {
          break label1282;
        }
        ((r)localObject2).aPE();
        ((r)localObject2).timerHandler.startTimer(0L, 1000L);
        localObject1 = ((r)localObject2).FDO;
        if (localObject1 == null) {
          break label1272;
        }
        localObject1 = (TextView)((View)localObject1).findViewById(a.e.ready_count_down_tv);
        label746:
        ((r)localObject2).kGO = ((TextView)localObject1);
        localObject1 = ((r)localObject2).FDO;
        if (localObject1 == null) {
          break label1277;
        }
        localObject1 = (TextView)((View)localObject1).findViewById(a.e.ready_detail_tv);
        label771:
        ((r)localObject2).FDP = ((TextView)localObject1);
      }
    }
    label776:
    eZi();
    localObject1 = this.FCG;
    if (localObject1 != null)
    {
      localObject2 = new RelativeLayout.LayoutParams(-1, -1);
      localObject3 = com.tencent.mm.plugin.multitalk.ui.widget.k.Fzb;
      localObject3 = getContext();
      kotlin.g.b.p.j(localObject3, "context");
      if (k.a.hB((Context)localObject3) != 90)
      {
        localObject3 = com.tencent.mm.plugin.multitalk.ui.widget.k.Fzb;
        localObject3 = getContext();
        kotlin.g.b.p.j(localObject3, "context");
        if (k.a.hB((Context)localObject3) != 270) {}
      }
      else
      {
        ((RelativeLayout.LayoutParams)localObject2).removeRule(16);
        ((RelativeLayout.LayoutParams)localObject2).removeRule(3);
        ((RelativeLayout.LayoutParams)localObject2).removeRule(17);
        ((RelativeLayout.LayoutParams)localObject2).removeRule(2);
        localObject3 = this.FCH;
        if (localObject3 == null) {
          kotlin.g.b.p.iCn();
        }
        ((RelativeLayout.LayoutParams)localObject2).addRule(17, ((FrameLayout)localObject3).getId());
        localObject3 = this.FCI;
        if (localObject3 == null) {
          kotlin.g.b.p.iCn();
        }
        ((RelativeLayout.LayoutParams)localObject2).addRule(16, ((FrameLayout)localObject3).getId());
        localObject3 = this.FCK;
        if (localObject3 != null) {
          ((b)localObject3).ve(true);
        }
        label928:
        ((FrameLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
    }
    else
    {
      localObject1 = this.FCJ;
      if (localObject1 != null) {
        ((FrameLayout)localObject1).removeAllViews();
      }
      localObject1 = this.FCJ;
      if (localObject1 != null)
      {
        localObject2 = new RelativeLayout.LayoutParams(-1, -1);
        localObject3 = com.tencent.mm.plugin.multitalk.ui.widget.k.Fzb;
        localObject3 = getContext();
        kotlin.g.b.p.j(localObject3, "context");
        if (k.a.hB((Context)localObject3) != 90)
        {
          localObject3 = com.tencent.mm.plugin.multitalk.ui.widget.k.Fzb;
          localObject3 = getContext();
          kotlin.g.b.p.j(localObject3, "context");
          if (k.a.hB((Context)localObject3) != 270) {
            break label1384;
          }
        }
        ((RelativeLayout.LayoutParams)localObject2).removeRule(16);
        ((RelativeLayout.LayoutParams)localObject2).removeRule(3);
        ((RelativeLayout.LayoutParams)localObject2).removeRule(17);
        ((RelativeLayout.LayoutParams)localObject2).removeRule(2);
        localObject3 = this.FCH;
        if (localObject3 == null) {
          kotlin.g.b.p.iCn();
        }
        ((RelativeLayout.LayoutParams)localObject2).addRule(17, ((FrameLayout)localObject3).getId());
        localObject3 = this.FCI;
        if (localObject3 == null) {
          kotlin.g.b.p.iCn();
        }
        ((RelativeLayout.LayoutParams)localObject2).addRule(16, ((FrameLayout)localObject3).getId());
      }
    }
    for (;;)
    {
      ((FrameLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject2 = this.FCN;
      if (localObject2 != null) {
        ((j)localObject2).G((ViewGroup)localObject1);
      }
      return;
      label1109:
      localObject2 = new RelativeLayout.LayoutParams(-1, com.tencent.mm.plugin.multitalk.ui.widget.f.FxW);
      ((RelativeLayout.LayoutParams)localObject2).removeRule(21);
      ((RelativeLayout.LayoutParams)localObject2).removeRule(12);
      ((RelativeLayout.LayoutParams)localObject2).addRule(12);
      ((FrameLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject2 = this.FCL;
      if (localObject2 == null) {
        break;
      }
      localObject3 = getContext();
      kotlin.g.b.p.j(localObject3, "context");
      kotlin.g.b.p.k(localObject3, "context");
      kotlin.g.b.p.k(localObject1, "rootView");
      ((k)localObject2).FCp = LayoutInflater.from((Context)localObject3).inflate(a.f.multitalk_screen_project_bottom_ui, (ViewGroup)localObject1);
      ((k)localObject2).eZo();
      break;
      label1205:
      ((RelativeLayout.LayoutParams)localObject2).removeRule(16);
      ((RelativeLayout.LayoutParams)localObject2).removeRule(3);
      ((RelativeLayout.LayoutParams)localObject2).removeRule(17);
      ((RelativeLayout.LayoutParams)localObject2).removeRule(2);
      localObject3 = this.FCH;
      if (localObject3 == null) {
        kotlin.g.b.p.iCn();
      }
      ((RelativeLayout.LayoutParams)localObject2).addRule(3, ((FrameLayout)localObject3).getId());
      localObject3 = this.FCI;
      if (localObject3 == null) {
        kotlin.g.b.p.iCn();
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
      ((r)localObject2).eZy();
      break label776;
      ((RelativeLayout.LayoutParams)localObject2).removeRule(16);
      ((RelativeLayout.LayoutParams)localObject2).removeRule(3);
      ((RelativeLayout.LayoutParams)localObject2).removeRule(17);
      ((RelativeLayout.LayoutParams)localObject2).removeRule(2);
      localObject3 = this.FCK;
      if (localObject3 != null) {
        ((b)localObject3).ve(false);
      }
      localObject3 = this.FCH;
      if (localObject3 != null) {
        ((FrameLayout)localObject3).setVisibility(0);
      }
      localObject3 = this.FCH;
      if (localObject3 == null) {
        kotlin.g.b.p.iCn();
      }
      ((RelativeLayout.LayoutParams)localObject2).addRule(3, ((FrameLayout)localObject3).getId());
      localObject3 = this.FCI;
      if (localObject3 == null) {
        kotlin.g.b.p.iCn();
      }
      ((RelativeLayout.LayoutParams)localObject2).addRule(2, ((FrameLayout)localObject3).getId());
      break label928;
      label1384:
      ((RelativeLayout.LayoutParams)localObject2).removeRule(16);
      ((RelativeLayout.LayoutParams)localObject2).removeRule(3);
      ((RelativeLayout.LayoutParams)localObject2).removeRule(17);
      ((RelativeLayout.LayoutParams)localObject2).removeRule(2);
      localObject3 = this.FCH;
      if (localObject3 == null) {
        kotlin.g.b.p.iCn();
      }
      ((RelativeLayout.LayoutParams)localObject2).addRule(3, ((FrameLayout)localObject3).getId());
      localObject3 = this.FCI;
      if (localObject3 == null) {
        kotlin.g.b.p.iCn();
      }
      ((RelativeLayout.LayoutParams)localObject2).addRule(2, ((FrameLayout)localObject3).getId());
    }
  }
  
  protected final void setAvatarLayout(j paramj)
  {
    this.FCN = paramj;
  }
  
  public final void setAvatarLayoutOn(boolean paramBoolean)
  {
    this.FCT = paramBoolean;
  }
  
  protected final void setAvatarRoot(FrameLayout paramFrameLayout)
  {
    this.FCJ = paramFrameLayout;
  }
  
  protected final void setBitmapRenderPrco(com.tencent.mm.plugin.multitalk.ui.widget.projector.b.a parama)
  {
    this.FCP = parama;
  }
  
  protected final void setBottomRoot(FrameLayout paramFrameLayout)
  {
    this.FCI = paramFrameLayout;
  }
  
  protected final void setBottomUiLayout(k paramk)
  {
    this.FCL = paramk;
  }
  
  public final void setDoodleLayoutOn(boolean paramBoolean)
  {
    this.FCS = paramBoolean;
  }
  
  protected final void setLockGenerateBitmap(boolean paramBoolean)
  {
    this.FCY = paramBoolean;
  }
  
  protected final void setMCurrentPageHeight(int paramInt)
  {
    this.FBv = paramInt;
  }
  
  protected final void setMCurrentPageWidth(int paramInt)
  {
    this.FBu = paramInt;
  }
  
  protected final void setMCurrentScale(float paramFloat)
  {
    this.FBt = paramFloat;
  }
  
  protected final void setMEditLayout(FrameLayout paramFrameLayout)
  {
    this.FCG = paramFrameLayout;
  }
  
  protected final void setMReadyLayout(FrameLayout paramFrameLayout)
  {
    this.FCF = paramFrameLayout;
  }
  
  protected final void setMScreenReportData(s params)
  {
    this.FCD = params;
  }
  
  protected final void setMStartTimes(long paramLong)
  {
    this.FCE = paramLong;
  }
  
  protected final void setMultiTalkStrokeContext(b paramb)
  {
    this.FCK = paramb;
  }
  
  public final void setReadyNotAllowClick(boolean paramBoolean)
  {
    boolean bool2 = true;
    this.FCU = paramBoolean;
    Object localObject = this.FCK;
    boolean bool1;
    if (localObject != null)
    {
      if (paramBoolean) {
        break label66;
      }
      bool1 = true;
      localObject = ((b)localObject).FBy;
      if (localObject != null) {
        ((com.tencent.mm.plugin.multitalk.ui.a.b)localObject).setDrawingEnable(bool1);
      }
    }
    localObject = this.FCL;
    if (localObject != null) {
      if (paramBoolean) {
        break label71;
      }
    }
    label66:
    label71:
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      ((k)localObject).FCz = paramBoolean;
      return;
      bool1 = false;
      break;
    }
  }
  
  protected final void setReadyUI(r paramr)
  {
    this.FCM = paramr;
  }
  
  protected final void setScreenFuncConfig(e parame)
  {
    this.FCC = parame;
  }
  
  public final void setScreenProjectSending(boolean paramBoolean)
  {
    this.FCR = paramBoolean;
    ad.eYc().FrS = paramBoolean;
  }
  
  protected final void setSendData(MMHandler paramMMHandler)
  {
    this.FCX = paramMMHandler;
  }
  
  protected final void setTopRoot(FrameLayout paramFrameLayout)
  {
    this.FCH = paramFrameLayout;
  }
  
  protected final void setTopUiLayout(p paramp)
  {
    this.FCO = paramp;
  }
  
  public final void u(View paramView, boolean paramBoolean)
  {
    for (;;)
    {
      int i;
      int j;
      Object localObject1;
      long l1;
      try
      {
        kotlin.g.b.p.k(paramView, "view");
        i = paramView.getMeasuredWidth() - paramView.getMeasuredWidth() % 4;
        j = paramView.getMeasuredHeight();
        int k = paramView.getMeasuredHeight();
        j -= k % 4;
        if ((i <= 0) || (j <= 0)) {
          return;
        }
        if (this.FCP == null) {
          this.FCP = new com.tencent.mm.plugin.multitalk.ui.widget.projector.b.a(i, j, (kotlin.g.a.b)new l.f(this));
        }
        localObject1 = this.FCP;
        if (localObject1 != null)
        {
          localObject2 = ((com.tencent.mm.plugin.multitalk.ui.widget.projector.b.a)localObject1).tJS;
          if (localObject2 != null) {
            ((c)localObject2).dv(i, j);
          }
          localObject2 = ((com.tencent.mm.plugin.multitalk.ui.widget.projector.b.a)localObject1).mSurfaceTexture;
          if (localObject2 != null) {
            ((SurfaceTexture)localObject2).setDefaultBufferSize(i, j);
          }
          if (i >= j) {
            break label475;
          }
          localObject2 = ((com.tencent.mm.plugin.multitalk.ui.widget.projector.b.a)localObject1).tJS;
          if (localObject2 != null) {
            ((c)localObject2).tm(270);
          }
          localObject2 = ((com.tencent.mm.plugin.multitalk.ui.widget.projector.b.a)localObject1).tJS;
          if (localObject2 != null) {
            ((com.tencent.mm.media.j.b.a)localObject2).kYB = false;
          }
          localObject2 = ((com.tencent.mm.plugin.multitalk.ui.widget.projector.b.a)localObject1).tJS;
          if (localObject2 != null) {
            ((com.tencent.mm.media.j.b.a)localObject2).kYh = false;
          }
          localObject2 = ((com.tencent.mm.plugin.multitalk.ui.widget.projector.b.a)localObject1).tJS;
          if (localObject2 != null) {
            ((c)localObject2).du(j, i);
          }
          localObject2 = ((com.tencent.mm.plugin.multitalk.ui.widget.projector.b.a)localObject1).tJS;
          if (localObject2 != null) {
            ((c)localObject2).dy(j, i);
          }
          ((com.tencent.mm.plugin.multitalk.ui.widget.projector.b.a)localObject1).mWidth = i;
          ((com.tencent.mm.plugin.multitalk.ui.widget.projector.b.a)localObject1).mHeight = j;
          localObject1 = ((com.tencent.mm.plugin.multitalk.ui.widget.projector.b.a)localObject1).tJS;
          if (localObject1 != null) {
            ((com.tencent.mm.media.j.b.a)localObject1).kYH = true;
          }
        }
        l1 = Util.currentTicks();
        localObject1 = this.FCQ;
        if (localObject1 == null) {
          continue;
        }
        localObject1 = ((Surface)localObject1).lockCanvas(null);
        if (localObject1 == null) {
          continue;
        }
        ((Canvas)localObject1).drawPaint(new Paint());
        ((Canvas)localObject1).setDrawFilter((DrawFilter)new PaintFlagsDrawFilter(0, 3));
        if (!paramBoolean) {
          paramView.draw((Canvas)localObject1);
        }
        long l2 = Util.ticksToNow(l1);
        paramView = this.FCD;
        if (paramView != null)
        {
          localObject2 = this.FCD;
          if (localObject2 == null) {
            break label572;
          }
          l1 = ((s)localObject2).FDU;
          paramView.FDU = ((l1 + l2) / 2L);
        }
        l1 = Util.currentTicks();
        paramView = this.FCK;
        if (paramView != null) {
          paramView.v((Canvas)localObject1);
        }
        l2 = Util.ticksToNow(l1);
        paramView = this.FCD;
        if (paramView != null)
        {
          localObject2 = this.FCD;
          if (localObject2 == null) {
            break label578;
          }
          l1 = ((s)localObject2).FDT;
          paramView.FDT = ((l1 + l2) / 2L);
        }
        paramView = this.FCQ;
        if (paramView == null) {
          continue;
        }
        paramView.unlockCanvasAndPost((Canvas)localObject1);
        continue;
        localObject2 = ((com.tencent.mm.plugin.multitalk.ui.widget.projector.b.a)localObject1).tJS;
      }
      finally {}
      label475:
      if (localObject2 != null) {
        ((c)localObject2).tm(0);
      }
      Object localObject2 = ((com.tencent.mm.plugin.multitalk.ui.widget.projector.b.a)localObject1).tJS;
      if (localObject2 != null) {
        ((com.tencent.mm.media.j.b.a)localObject2).kYh = true;
      }
      localObject2 = ((com.tencent.mm.plugin.multitalk.ui.widget.projector.b.a)localObject1).tJS;
      if (localObject2 != null) {
        ((com.tencent.mm.media.j.b.a)localObject2).kYB = true;
      }
      localObject2 = ((com.tencent.mm.plugin.multitalk.ui.widget.projector.b.a)localObject1).tJS;
      if (localObject2 != null) {
        ((c)localObject2).du(i, j);
      }
      localObject2 = ((com.tencent.mm.plugin.multitalk.ui.widget.projector.b.a)localObject1).tJS;
      if (localObject2 != null)
      {
        ((c)localObject2).dy(i, j);
        continue;
        label572:
        l1 = 0L;
        continue;
        label578:
        l1 = 0L;
      }
    }
  }
  
  public void vf(boolean paramBoolean)
  {
    int j = 8;
    this.FCE = Util.currentTicks();
    Object localObject = this.FCG;
    if (localObject != null) {
      if (!paramBoolean) {
        break label239;
      }
    }
    label239:
    for (int i = 0;; i = 8)
    {
      ((FrameLayout)localObject).setVisibility(i);
      localObject = this.FCO;
      if (localObject != null)
      {
        localObject = ((p)localObject).ubm;
        if (localObject != null) {
          ((TextView)localObject).setVisibility(0);
        }
      }
      localObject = this.FCL;
      if (localObject != null)
      {
        localObject = ((k)localObject).FCp;
        if (localObject != null)
        {
          i = j;
          if (paramBoolean) {
            i = 0;
          }
          ((View)localObject).setVisibility(i);
        }
      }
      localObject = this.FCK;
      if (localObject != null)
      {
        FrameLayout localFrameLayout = this.FCG;
        if (localFrameLayout != null) {
          localFrameLayout.addView((View)((b)localObject).FBs);
        }
      }
      localObject = this.FCF;
      if (localObject != null) {
        ((FrameLayout)localObject).setVisibility(0);
      }
      localObject = this.FCF;
      if (localObject != null) {
        ((FrameLayout)localObject).clearAnimation();
      }
      localObject = this.FCF;
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
  
  public final void vj(boolean paramBoolean)
  {
    setScreenProjectSending(false);
    Object localObject = this.FCX;
    if (localObject != null) {
      ((MMHandler)localObject).removeCallbacksAndMessages(null);
    }
    localObject = this.FCX;
    if (localObject != null) {
      ((MMHandler)localObject).quitSafely();
    }
    this.FCX = null;
    localObject = this.FCV;
    if (localObject != null) {
      ((com.tencent.e.i.d)localObject).cancel(false);
    }
    this.FCV = null;
    localObject = this.FCW;
    if (localObject != null) {
      ((com.tencent.e.i.d)localObject).cancel(false);
    }
    this.FCW = null;
    if (paramBoolean)
    {
      ad.eYc();
      q.Xx(102);
    }
    for (;;)
    {
      ad.eYc().eWl();
      return;
      ad.eYc();
      q.Xx(103);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectRootView$getRenderBitmap$1", "Ljava/util/TimerTask;", "run", "", "plugin-multitalk_release"})
  public static final class b
    extends TimerTask
  {
    public final void run()
    {
      AppMethodBeat.i(207414);
      if (!ad.eYc().FrT) {
        h.ZvG.bc((Runnable)new a(this));
      }
      AppMethodBeat.o(207414);
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(l.b paramb) {}
      
      public final void run()
      {
        AppMethodBeat.i(195899);
        if (!this.FDb.FDa.FCY)
        {
          Object localObject1 = this.FDb.FDa.getBackgroundView();
          if (localObject1 != null)
          {
            long l2 = Util.currentTicks();
            Object localObject2 = this.FDb.FDa.getScreenFuncConfig();
            boolean bool;
            if (localObject2 != null)
            {
              bool = ((e)localObject2).XP(11);
              this.FDb.FDa.u((View)localObject1, bool);
              localObject1 = this.FDb.FDa.getMScreenReportData();
              if (localObject1 == null) {
                break label151;
              }
              localObject2 = this.FDb.FDa.getMScreenReportData();
              if (localObject2 == null) {
                break label146;
              }
            }
            label146:
            for (long l1 = ((s)localObject2).FDS;; l1 = 0L)
            {
              ((s)localObject1).FDS = ((l1 + Util.ticksToNow(l2)) / 2L);
              AppMethodBeat.o(195899);
              return;
              bool = false;
              break;
            }
            label151:
            AppMethodBeat.o(195899);
            return;
          }
        }
        AppMethodBeat.o(195899);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectRootView$getRenderBitmap$task$1", "Ljava/util/TimerTask;", "run", "", "plugin-multitalk_release"})
  public static final class c
    extends TimerTask
  {
    public final void run()
    {
      AppMethodBeat.i(200898);
      s locals1 = this.FDa.getMScreenReportData();
      if (locals1 != null)
      {
        s locals2 = this.FDa.getMScreenReportData();
        if (locals2 != null) {}
        for (int i = locals2.FDV;; i = 0)
        {
          locals1.FDV = ((i + l.b(this.FDa)) / 2);
          AppMethodBeat.o(200898);
          return;
        }
      }
      AppMethodBeat.o(200898);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    g(l paraml) {}
    
    public final void run()
    {
      AppMethodBeat.i(196835);
      this.FDa.eZh();
      AppMethodBeat.o(196835);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.projector.l
 * JD-Core Version:    0.7.0.1
 */
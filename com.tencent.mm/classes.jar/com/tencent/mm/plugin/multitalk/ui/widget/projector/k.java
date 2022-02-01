package com.tencent.mm.plugin.multitalk.ui.widget.projector;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.DrawFilter;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.j.b.c;
import com.tencent.mm.plugin.multitalk.a.b;
import com.tencent.mm.plugin.multitalk.a.e;
import com.tencent.mm.plugin.multitalk.a.f;
import com.tencent.mm.plugin.multitalk.a.h;
import com.tencent.mm.plugin.multitalk.e.g;
import com.tencent.mm.plugin.multitalk.model.ac;
import com.tencent.mm.plugin.multitalk.model.af;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.widget.a.e.a;
import com.tencent.mm.view.l;
import java.nio.ByteBuffer;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectRootView;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "avatarLayout", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectAvatarUI;", "getAvatarLayout", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectAvatarUI;", "setAvatarLayout", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectAvatarUI;)V", "avatarRoot", "Landroid/widget/FrameLayout;", "getAvatarRoot", "()Landroid/widget/FrameLayout;", "setAvatarRoot", "(Landroid/widget/FrameLayout;)V", "bitmapRenderPrco", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/render/ScreenProjectCanvasRendererMgr;", "getBitmapRenderPrco", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/render/ScreenProjectCanvasRendererMgr;", "setBitmapRenderPrco", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/render/ScreenProjectCanvasRendererMgr;)V", "bottomRoot", "getBottomRoot", "setBottomRoot", "bottomUiLayout", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectBottomUI;", "getBottomUiLayout", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectBottomUI;", "setBottomUiLayout", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectBottomUI;)V", "fpsFuture", "Lcom/tencent/threadpool/runnable/FutureEx;", "isAvatarLayoutOn", "", "()Z", "setAvatarLayoutOn", "(Z)V", "isDoodleLayoutOn", "setDoodleLayoutOn", "isLockGenerateBitmap", "setLockGenerateBitmap", "value", "isReadyNotAllowClick", "setReadyNotAllowClick", "isScreenProjectSending", "setScreenProjectSending", "mCurrentPageHeight", "", "getMCurrentPageHeight", "()I", "setMCurrentPageHeight", "(I)V", "mCurrentPageWidth", "getMCurrentPageWidth", "setMCurrentPageWidth", "mCurrentScale", "", "getMCurrentScale", "()F", "setMCurrentScale", "(F)V", "mEditLayout", "getMEditLayout", "setMEditLayout", "mFps", "mReadyLayout", "getMReadyLayout", "setMReadyLayout", "mScreenReportData", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenReportData;", "getMScreenReportData", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenReportData;", "setMScreenReportData", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenReportData;)V", "mStartTimes", "", "getMStartTimes", "()J", "setMStartTimes", "(J)V", "multiTalkStrokeContext", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/MultiTalkStrokeLayout;", "getMultiTalkStrokeContext", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/MultiTalkStrokeLayout;", "setMultiTalkStrokeContext", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/MultiTalkStrokeLayout;)V", "readyUI", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenReadyUI;", "getReadyUI", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenReadyUI;", "setReadyUI", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenReadyUI;)V", "renderTarget", "Landroid/view/Surface;", "screenFuncConfig", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;", "getScreenFuncConfig", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;", "setScreenFuncConfig", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenConfig;)V", "sendData", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getSendData", "()Lcom/tencent/mm/sdk/platformtools/MMHandler;", "setSendData", "(Lcom/tencent/mm/sdk/platformtools/MMHandler;)V", "timerFuture", "topRoot", "getTopRoot", "setTopRoot", "topUiLayout", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectTopUI;", "getTopUiLayout", "()Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectTopUI;", "setTopUiLayout", "(Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectTopUI;)V", "applyAvatarLayout", "", "applyBottomUI", "applyEditorLayout", "isFullScreen", "applyReaderUI", "applyReadyLayout", "applyThumbnailUI", "applyTopUI", "checkCallerState", "checkCurrentInAvatarLayout", "checkCurrentInDoodleLayout", "checkCurrentOrientation", "clearScreen", "closeReaderRenderer", "dismissProjectScreen", "enterScreenDoodle", "getBackgroundView", "Landroid/view/View;", "getBitmapShot", "Landroid/graphics/Bitmap;", "view", "getCurrentStatus", "getLayoutId", "getRenderBitmap", "initView", "inputScreenProjectInfo", "params", "Landroid/os/Bundle;", "pageIndex", "isShow", "onBack", "onTimeSecondCallback", "refreshView", "renderBitmap", "ignoreBg", "reportScreenProject", "responeScreenClick", "setBitmapBackgroundRenderTarget", "surface", "showReaderContent", "show", "showStrokeContent", "statusChange", "status", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/IProjectStatus$ProjectStatus;", "param", "stopScreenProjectSend", "isMini", "Companion", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class k
  extends RelativeLayout
  implements a
{
  public static final k.a Lyx = new k.a((byte)0);
  private float Lxx;
  private int Lxy;
  private int Lxz;
  private long LyA;
  private FrameLayout LyB;
  private FrameLayout LyC;
  private FrameLayout LyD;
  private FrameLayout LyE;
  private FrameLayout LyF;
  b LyG;
  private j LyH;
  private p LyI;
  private i LyJ;
  n LyK;
  private com.tencent.mm.plugin.multitalk.ui.widget.projector.b.a LyL;
  private volatile Surface LyM;
  boolean LyN;
  private boolean LyO;
  private boolean LyP;
  boolean LyQ = true;
  private com.tencent.threadpool.i.d<?> LyR;
  private com.tencent.threadpool.i.d<?> LyS;
  private MMHandler LyT;
  volatile boolean LyU;
  private e Lyy;
  private q Lyz;
  private int mVW;
  
  public k(Context paramContext)
  {
    super(paramContext);
  }
  
  private static final void G(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
  }
  
  private static final void a(k paramk)
  {
    kotlin.g.b.s.u(paramk, "this$0");
    paramk.gig();
  }
  
  private static final void a(k paramk, DialogInterface paramDialogInterface, int paramInt)
  {
    kotlin.g.b.s.u(paramk, "this$0");
    paramk.zx(false);
    paramDialogInterface.dismiss();
  }
  
  private void gip()
  {
    b localb = this.LyG;
    if (localb != null)
    {
      if (localb.LxD)
      {
        localb1 = localb.LxB;
        if (localb1 != null) {
          localb1.setVisibility(0);
        }
        localb.ghY();
        localb.LxD = false;
      }
    }
    else {
      return;
    }
    localb.ghY();
    com.tencent.mm.plugin.multitalk.ui.a.b localb1 = localb.LxB;
    if (localb1 != null) {
      localb1.setVisibility(0);
    }
    localb.LxD = true;
  }
  
  private Bitmap ih(View paramView)
  {
    long l2 = 0L;
    kotlin.g.b.s.u(paramView, "view");
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
    paramView = this.Lyz;
    q localq;
    if (paramView != null)
    {
      localq = this.Lyz;
      if (localq == null)
      {
        l1 = 0L;
        paramView.LzE = ((l1 + l3) / 2L);
      }
    }
    else
    {
      l1 = Util.currentTicks();
      paramView = this.LyG;
      if (paramView != null) {
        paramView.q((Canvas)localObject);
      }
      l3 = Util.ticksToNow(l1);
      paramView = this.Lyz;
      if (paramView != null)
      {
        localObject = this.Lyz;
        if (localObject != null) {
          break label249;
        }
      }
    }
    label249:
    for (long l1 = l2;; l1 = ((q)localObject).LzD)
    {
      paramView.LzD = ((l3 + l1) / 2L);
      if (i <= j) {
        break label259;
      }
      return BitmapUtil.rotate(localBitmap, 90.0F);
      l1 = localq.LzE;
      break;
    }
    label259:
    return localBitmap;
  }
  
  private final void setBitmapBackgroundRenderTarget(Surface paramSurface)
  {
    this.LyM = paramSurface;
  }
  
  public final void A(View paramView, boolean paramBoolean)
  {
    for (;;)
    {
      int i;
      int j;
      Object localObject1;
      long l1;
      try
      {
        kotlin.g.b.s.u(paramView, "view");
        i = paramView.getMeasuredWidth() - paramView.getMeasuredWidth() % 4;
        j = paramView.getMeasuredHeight();
        int k = paramView.getMeasuredHeight();
        j -= k % 4;
        if ((i <= 0) || (j <= 0)) {
          return;
        }
        if (this.LyL == null) {
          this.LyL = new com.tencent.mm.plugin.multitalk.ui.widget.projector.b.a(i, j, (kotlin.g.a.b)new e(this));
        }
        localObject1 = this.LyL;
        if (localObject1 != null)
        {
          localObject2 = ((com.tencent.mm.plugin.multitalk.ui.widget.projector.b.a)localObject1).wNo;
          if (localObject2 != null) {
            ((c)localObject2).el(i, j);
          }
          localObject2 = ((com.tencent.mm.plugin.multitalk.ui.widget.projector.b.a)localObject1).mSurfaceTexture;
          if (localObject2 != null) {
            ((SurfaceTexture)localObject2).setDefaultBufferSize(i, j);
          }
          if (i >= j) {
            break label467;
          }
          localObject2 = ((com.tencent.mm.plugin.multitalk.ui.widget.projector.b.a)localObject1).wNo;
          if (localObject2 != null) {
            ((c)localObject2).th(270);
          }
          localObject2 = ((com.tencent.mm.plugin.multitalk.ui.widget.projector.b.a)localObject1).wNo;
          if (localObject2 != null) {
            ((c)localObject2).gq(false);
          }
          localObject2 = ((com.tencent.mm.plugin.multitalk.ui.widget.projector.b.a)localObject1).wNo;
          if (localObject2 != null) {
            ((c)localObject2).gr(false);
          }
          localObject2 = ((com.tencent.mm.plugin.multitalk.ui.widget.projector.b.a)localObject1).wNo;
          if (localObject2 != null) {
            ((c)localObject2).ek(j, i);
          }
          localObject2 = ((com.tencent.mm.plugin.multitalk.ui.widget.projector.b.a)localObject1).wNo;
          if (localObject2 != null) {
            ((c)localObject2).es(j, i);
          }
          ((com.tencent.mm.plugin.multitalk.ui.widget.projector.b.a)localObject1).mWidth = i;
          ((com.tencent.mm.plugin.multitalk.ui.widget.projector.b.a)localObject1).mHeight = j;
          localObject1 = ((com.tencent.mm.plugin.multitalk.ui.widget.projector.b.a)localObject1).wNo;
          if (localObject1 != null) {
            ((com.tencent.mm.media.j.b.a)localObject1).nDP = true;
          }
        }
        l1 = Util.currentTicks();
        localObject1 = this.LyM;
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
        paramView = getMScreenReportData();
        if (paramView != null)
        {
          localObject2 = getMScreenReportData();
          if (localObject2 != null) {
            break label564;
          }
          l1 = 0L;
          paramView.LzE = ((l1 + l2) / 2L);
        }
        l1 = Util.currentTicks();
        paramView = getMultiTalkStrokeContext();
        if (paramView != null) {
          paramView.q((Canvas)localObject1);
        }
        l2 = Util.ticksToNow(l1);
        paramView = getMScreenReportData();
        if (paramView != null)
        {
          localObject2 = getMScreenReportData();
          if (localObject2 != null) {
            break label574;
          }
          l1 = 0L;
          paramView.LzD = ((l1 + l2) / 2L);
        }
        paramView = this.LyM;
        if (paramView == null) {
          continue;
        }
        paramView.unlockCanvasAndPost((Canvas)localObject1);
        continue;
        localObject2 = ((com.tencent.mm.plugin.multitalk.ui.widget.projector.b.a)localObject1).wNo;
      }
      finally {}
      label467:
      if (localObject2 != null) {
        ((c)localObject2).th(0);
      }
      Object localObject2 = ((com.tencent.mm.plugin.multitalk.ui.widget.projector.b.a)localObject1).wNo;
      if (localObject2 != null) {
        ((c)localObject2).gr(true);
      }
      localObject2 = ((com.tencent.mm.plugin.multitalk.ui.widget.projector.b.a)localObject1).wNo;
      if (localObject2 != null) {
        ((c)localObject2).gq(true);
      }
      localObject2 = ((com.tencent.mm.plugin.multitalk.ui.widget.projector.b.a)localObject1).wNo;
      if (localObject2 != null) {
        ((c)localObject2).ek(i, j);
      }
      localObject2 = ((com.tencent.mm.plugin.multitalk.ui.widget.projector.b.a)localObject1).wNo;
      if (localObject2 != null)
      {
        ((c)localObject2).es(i, j);
        continue;
        label564:
        l1 = ((q)localObject2).LzE;
        continue;
        label574:
        l1 = ((q)localObject2).LzD;
      }
    }
  }
  
  public void a(a.c paramc, Bundle paramBundle)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    kotlin.g.b.s.u(paramc, "status");
    Log.printInfoStack("MicroMsg.MultiTalkScreenProjectorView", "statusChange %s and param is %s", new Object[] { paramc, paramBundle });
    switch (b.$EnumSwitchMapping$0[paramc.ordinal()])
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
                              return;
                              Log.printInfoStack("MicroMsg.MultiTalkScreenProjectorView", "startScreenProjectSend", new Object[0]);
                              paramc = com.tencent.mm.plugin.multitalk.e.d.LAq;
                              com.tencent.mm.plugin.multitalk.e.d.ace(2);
                              getRenderBitmap();
                              ac.ggS();
                              com.tencent.mm.plugin.multitalk.model.p.abJ(101);
                              setScreenProjectSending(true);
                              return;
                              paramc = com.tencent.mm.plugin.multitalk.e.d.LAq;
                              com.tencent.mm.plugin.multitalk.e.d.ace(8);
                              zx(false);
                              return;
                              paramc = com.tencent.mm.plugin.multitalk.e.d.LAq;
                              com.tencent.mm.plugin.multitalk.e.d.ace(7);
                              this.LyO = true;
                              paramc = this.LyD;
                              if (paramc != null) {
                                paramc.setVisibility(4);
                              }
                              paramc = this.LyG;
                              if (paramc == null) {
                                paramc = localObject1;
                              }
                              while (paramc == null)
                              {
                                throw new NullPointerException("null cannot be cast to non-null type com.tencent.mm.view.board.MultiTalkBoardView");
                                paramBundle = paramc.LxB;
                                paramc = localObject1;
                                if (paramBundle != null)
                                {
                                  paramBundle = paramBundle.getMultiTalkEditPhotoWrapper();
                                  paramc = localObject1;
                                  if (paramBundle != null)
                                  {
                                    paramBundle = paramBundle.Lsf;
                                    paramc = localObject1;
                                    if (paramBundle != null) {
                                      paramc = (com.tencent.mm.view.b.b)paramBundle.getBaseBoardView();
                                    }
                                  }
                                }
                              }
                              paramc.setEnableToResponseSlid(true);
                              gip();
                            } while ((ghU() != 90) && (ghU() != 270));
                            paramc = this.LyJ;
                          } while (paramc == null);
                          paramc.gil();
                          return;
                          paramc = com.tencent.mm.plugin.multitalk.e.d.LAq;
                          com.tencent.mm.plugin.multitalk.e.d.ace(7);
                          paramc = this.LyG;
                          if (paramc == null) {
                            paramc = localObject2;
                          }
                          while (paramc == null)
                          {
                            throw new NullPointerException("null cannot be cast to non-null type com.tencent.mm.view.board.MultiTalkBoardView");
                            paramBundle = paramc.LxB;
                            paramc = localObject2;
                            if (paramBundle != null)
                            {
                              paramBundle = paramBundle.getMultiTalkEditPhotoWrapper();
                              paramc = localObject2;
                              if (paramBundle != null)
                              {
                                paramBundle = paramBundle.Lsf;
                                paramc = localObject2;
                                if (paramBundle != null) {
                                  paramc = (com.tencent.mm.view.b.b)paramBundle.getBaseBoardView();
                                }
                              }
                            }
                          }
                          paramc.setEnableToResponseSlid(false);
                          this.LyO = false;
                          paramc = this.LyD;
                          if (paramc != null) {
                            paramc.setVisibility(0);
                          }
                          gip();
                        } while ((ghU() != 90) && (ghU() != 270));
                        paramc = this.LyJ;
                      } while (paramc == null);
                      paramc.gil();
                      return;
                    } while (paramBundle == null);
                    ac.ggS().zc(paramBundle.getBoolean("mic_mute_status"));
                    return;
                    ghZ();
                    return;
                    zx(false);
                    return;
                  } while (paramBundle == null);
                  paramc = paramBundle.getStringArrayList("avatar_available_speaker");
                  paramBundle = getAvatarLayout();
                  if (paramBundle == null) {}
                  for (boolean bool = false;; bool = paramBundle.be(paramc))
                  {
                    setAvatarLayoutOn(bool);
                    return;
                    kotlin.g.b.s.checkNotNull(paramc);
                  }
                  this.LyP = false;
                  return;
                } while ((this.LyO) || (this.LyQ));
                com.tencent.threadpool.h.ahAA.bk(new k..ExternalSyntheticLambda2(this));
                return;
                this.LyU = false;
                return;
                paramc = this.LyB;
                if (paramc != null) {
                  paramc.setVisibility(8);
                }
                setReadyNotAllowClick(false);
                return;
                paramc = getBackgroundView();
              } while (paramc == null);
              paramc = ih(paramc);
            } while (paramc == null);
            paramBundle = com.tencent.mm.plugin.multitalk.ui.widget.k.Lvg;
            com.tencent.mm.plugin.multitalk.ui.widget.k.a.b(getContext(), paramc);
            return;
            paramc = getBackgroundView();
          } while (paramc == null);
          paramc = ih(paramc);
        } while (paramc == null);
        paramBundle = com.tencent.mm.plugin.multitalk.ui.widget.k.Lvg;
        com.tencent.mm.plugin.multitalk.ui.widget.k.a.c(getContext(), paramc);
        return;
        paramc = getBackgroundView();
      } while (paramc == null);
      paramc = ih(paramc);
    } while (paramc == null);
    paramBundle = com.tencent.mm.plugin.multitalk.ui.widget.k.Lvg;
    com.tencent.mm.plugin.multitalk.ui.widget.k.a.d(getContext(), paramc);
  }
  
  public void aI(Bundle paramBundle) {}
  
  public final boolean cvt()
  {
    return getVisibility() == 0;
  }
  
  public final void fQZ()
  {
    Object localObject = this.LyJ;
    if (localObject != null)
    {
      localObject = ((i)localObject).Lyk;
      if (localObject != null) {
        ((h)localObject).fQZ();
      }
    }
  }
  
  protected final i getAvatarLayout()
  {
    return this.LyJ;
  }
  
  protected final FrameLayout getAvatarRoot()
  {
    return this.LyF;
  }
  
  public abstract View getBackgroundView();
  
  protected final com.tencent.mm.plugin.multitalk.ui.widget.projector.b.a getBitmapRenderPrco()
  {
    return this.LyL;
  }
  
  protected final FrameLayout getBottomRoot()
  {
    return this.LyE;
  }
  
  protected final j getBottomUiLayout()
  {
    return this.LyH;
  }
  
  public boolean getCurrentStatus()
  {
    return this.LyN;
  }
  
  public abstract int getLayoutId();
  
  protected final int getMCurrentPageHeight()
  {
    return this.Lxz;
  }
  
  protected final int getMCurrentPageWidth()
  {
    return this.Lxy;
  }
  
  protected final float getMCurrentScale()
  {
    return this.Lxx;
  }
  
  protected final FrameLayout getMEditLayout()
  {
    return this.LyC;
  }
  
  protected final FrameLayout getMReadyLayout()
  {
    return this.LyB;
  }
  
  protected final q getMScreenReportData()
  {
    return this.Lyz;
  }
  
  protected final long getMStartTimes()
  {
    return this.LyA;
  }
  
  protected final b getMultiTalkStrokeContext()
  {
    return this.LyG;
  }
  
  protected final p getReadyUI()
  {
    return this.LyI;
  }
  
  public final void getRenderBitmap()
  {
    if (this.LyR != null) {
      return;
    }
    TimerTask localTimerTask = (TimerTask)new d(this);
    this.LyS = com.tencent.threadpool.h.ahAA.b((Runnable)localTimerTask, 1000L, 1000L);
    this.LyT = new MMHandler("screen_project");
    this.LyR = com.tencent.threadpool.h.ahAA.b((Runnable)new c(this), 0L, 1000L / com.tencent.mm.plugin.multitalk.e.f.giY());
  }
  
  protected final e getScreenFuncConfig()
  {
    return this.Lyy;
  }
  
  protected final MMHandler getSendData()
  {
    return this.LyT;
  }
  
  protected final FrameLayout getTopRoot()
  {
    return this.LyD;
  }
  
  protected final n getTopUiLayout()
  {
    return this.LyK;
  }
  
  public final int ghU()
  {
    Object localObject = com.tencent.mm.plugin.multitalk.ui.widget.k.Lvg;
    localObject = getContext();
    kotlin.g.b.s.s(localObject, "context");
    return com.tencent.mm.plugin.multitalk.ui.widget.k.a.iY((Context)localObject);
  }
  
  public final boolean ghV()
  {
    return this.LyO;
  }
  
  public final boolean ghW()
  {
    return this.LyP;
  }
  
  public final int ghX()
  {
    return 1;
  }
  
  public final void ghZ()
  {
    b localb = this.LyG;
    if (localb != null) {
      localb.ghZ();
    }
  }
  
  public void gie()
  {
    Object localObject1 = this.Lyz;
    if (localObject1 != null) {
      ((q)localObject1).cost = Util.ticksToNow(this.LyA);
    }
    this.LyM = null;
    gif();
    localObject1 = this.LyJ;
    if (localObject1 != null) {
      ((i)localObject1).Lyk.release();
    }
    setVisibility(8);
    localObject1 = this.LyS;
    if (localObject1 != null) {
      ((com.tencent.threadpool.i.d)localObject1).cancel(false);
    }
    this.LyS = null;
    localObject1 = this.LyR;
    if (localObject1 != null) {
      ((com.tencent.threadpool.i.d)localObject1).cancel(false);
    }
    this.LyR = null;
    localObject1 = this.LyB;
    if (localObject1 != null) {
      ((FrameLayout)localObject1).clearAnimation();
    }
    localObject1 = this.LyT;
    if (localObject1 != null) {
      ((MMHandler)localObject1).removeCallbacksAndMessages(null);
    }
    localObject1 = this.LyT;
    if (localObject1 != null) {
      ((MMHandler)localObject1).quitSafely();
    }
    this.LyT = null;
    localObject1 = this.LyI;
    Object localObject2;
    if (localObject1 != null)
    {
      ((p)localObject1).timerHandler.stopTimer();
      localObject2 = ((p)localObject1).njJ;
      if (localObject2 != null) {
        ((TextView)localObject2).setScaleX(1.0F);
      }
      localObject2 = ((p)localObject1).njJ;
      if (localObject2 != null) {
        ((TextView)localObject2).setScaleY(1.0F);
      }
      ((p)localObject1).njK = ((p)localObject1).njG;
      ((p)localObject1).timerHandler.quitSafely();
    }
    ac.ggS().ggc();
    com.tencent.mm.plugin.multitalk.model.s.ggz();
    localObject1 = this.Lyz;
    if (localObject1 != null)
    {
      localObject2 = g.LAS;
      g.a(((q)localObject1).lPJ, ((q)localObject1).fileSize, ((q)localObject1).fileName, ((q)localObject1).LzB, ((q)localObject1).cost, ((q)localObject1).errorCode, ((q)localObject1).LzC, ((q)localObject1).LzD, ((q)localObject1).LzE, ((q)localObject1).LzF);
    }
    this.Lyz = null;
  }
  
  public void gif()
  {
    Object localObject1 = this.LyL;
    if (localObject1 != null)
    {
      ((com.tencent.mm.plugin.multitalk.ui.widget.projector.b.a)localObject1).mVD.removeCallbacksAndMessages(null);
      ((com.tencent.mm.plugin.multitalk.ui.widget.projector.b.a)localObject1).K((kotlin.g.a.a)new com.tencent.mm.plugin.multitalk.ui.widget.projector.b.a.c((com.tencent.mm.plugin.multitalk.ui.widget.projector.b.a)localObject1));
      Object localObject2 = ((com.tencent.mm.plugin.multitalk.ui.widget.projector.b.a)localObject1).mVE;
      if (localObject2 != null) {
        ((HandlerThread)localObject2).quitSafely();
      }
      localObject2 = ((com.tencent.mm.plugin.multitalk.ui.widget.projector.b.a)localObject1).mVI;
      if (localObject2 != null) {
        ((Surface)localObject2).release();
      }
      localObject1 = ((com.tencent.mm.plugin.multitalk.ui.widget.projector.b.a)localObject1).mSurfaceTexture;
      if (localObject1 != null) {
        ((SurfaceTexture)localObject1).release();
      }
    }
  }
  
  public int gig()
  {
    int j = 0;
    FrameLayout localFrameLayout = this.LyD;
    if ((localFrameLayout != null) && (localFrameLayout.getVisibility() == 0))
    {
      i = 1;
      if (i == 0) {
        break label81;
      }
      i = 4;
      label26:
      if (i != 0) {
        break label86;
      }
    }
    label81:
    label86:
    for (int i = j;; i = 4)
    {
      localFrameLayout = this.LyD;
      if (localFrameLayout != null) {
        localFrameLayout.setVisibility(i);
      }
      localFrameLayout = this.LyE;
      if (localFrameLayout != null) {
        localFrameLayout.setVisibility(i);
      }
      localFrameLayout = this.LyB;
      if (localFrameLayout != null) {
        localFrameLayout.setVisibility(i);
      }
      return i;
      i = 0;
      break;
      i = 0;
      break label26;
    }
  }
  
  public void gih() {}
  
  protected void gii() {}
  
  public final boolean gio()
  {
    return this.LyO;
  }
  
  public final void onBack()
  {
    Object localObject2 = null;
    if (this.LyN)
    {
      e.a locala1 = new e.a(getContext());
      Object localObject1 = getContext().getResources();
      e.a locala2;
      if (localObject1 == null)
      {
        localObject1 = null;
        locala1.bDw((String)localObject1);
        locala2 = locala1.aER(a.h.screen_projector_pause_btn).c(new k..ExternalSyntheticLambda0(this));
        localObject1 = getContext();
        if (localObject1 != null) {
          break label119;
        }
        localObject1 = localObject2;
      }
      for (;;)
      {
        kotlin.g.b.s.checkNotNull(localObject1);
        locala2.aET(((Integer)localObject1).intValue());
        locala1.aES(a.h.app_cancel).d(k..ExternalSyntheticLambda1.INSTANCE);
        locala1.jHH().show();
        return;
        localObject1 = ((Resources)localObject1).getString(a.h.screen_projector_stop_tip);
        break;
        label119:
        Resources localResources = ((Context)localObject1).getResources();
        localObject1 = localObject2;
        if (localResources != null) {
          localObject1 = Integer.valueOf(localResources.getColor(a.b.Red));
        }
      }
    }
    ac.ggS().gfc();
  }
  
  public void refreshView()
  {
    this.LyP = false;
    Object localObject1 = this.LyD;
    if (localObject1 != null) {
      ((FrameLayout)localObject1).removeAllViews();
    }
    localObject1 = com.tencent.mm.plugin.multitalk.ui.widget.k.Lvg;
    localObject1 = getContext();
    kotlin.g.b.s.s(localObject1, "context");
    Object localObject3;
    if (com.tencent.mm.plugin.multitalk.ui.widget.k.a.iY((Context)localObject1) != 90)
    {
      localObject1 = com.tencent.mm.plugin.multitalk.ui.widget.k.Lvg;
      localObject1 = getContext();
      kotlin.g.b.s.s(localObject1, "context");
      if (com.tencent.mm.plugin.multitalk.ui.widget.k.a.iY((Context)localObject1) != 270) {}
    }
    else
    {
      localObject2 = new RelativeLayout.LayoutParams(com.tencent.mm.plugin.multitalk.ui.widget.f.Lui, -1);
      ((RelativeLayout.LayoutParams)localObject2).removeRule(20);
      ((RelativeLayout.LayoutParams)localObject2).removeRule(10);
      ((RelativeLayout.LayoutParams)localObject2).addRule(20);
      localObject1 = this.LyD;
      if (localObject1 == null) {
        break label346;
      }
      ((FrameLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject2 = getTopUiLayout();
      if (localObject2 == null) {}
      for (localObject1 = null; localObject1 == null; localObject1 = ((n)localObject2).Lzv)
      {
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout");
        localObject3 = getContext();
        kotlin.g.b.s.s(localObject3, "context");
        kotlin.g.b.s.u(localObject3, "context");
        kotlin.g.b.s.u(localObject1, "viewGroup");
        ((n)localObject2).Lzv = LayoutInflater.from((Context)localObject3).inflate(a.f.multitalk_screen_project_top_ui_land, (ViewGroup)localObject1);
        ((n)localObject2).gin();
      }
    }
    Object localObject2 = new RelativeLayout.LayoutParams(-1, com.tencent.mm.plugin.multitalk.ui.widget.f.Luf);
    ((RelativeLayout.LayoutParams)localObject2).removeRule(20);
    ((RelativeLayout.LayoutParams)localObject2).removeRule(10);
    ((RelativeLayout.LayoutParams)localObject2).addRule(10);
    ((RelativeLayout.LayoutParams)localObject2).topMargin = bf.getStatusBarHeight(getContext());
    localObject1 = this.LyD;
    if (localObject1 != null)
    {
      ((FrameLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject2 = getTopUiLayout();
      if (localObject2 == null) {}
      for (localObject1 = null; localObject1 == null; localObject1 = ((n)localObject2).Lzv)
      {
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout");
        localObject3 = getContext();
        kotlin.g.b.s.s(localObject3, "context");
        kotlin.g.b.s.u(localObject3, "context");
        kotlin.g.b.s.u(localObject1, "viewGroup");
        ((n)localObject2).Lzv = LayoutInflater.from((Context)localObject3).inflate(a.f.multitalk_screen_project_top_ui, (ViewGroup)localObject1);
        ((n)localObject2).gin();
      }
    }
    label346:
    localObject1 = this.LyE;
    if (localObject1 != null) {
      ((FrameLayout)localObject1).removeAllViews();
    }
    localObject1 = this.LyE;
    if (localObject1 != null)
    {
      localObject2 = com.tencent.mm.plugin.multitalk.ui.widget.k.Lvg;
      localObject2 = getContext();
      kotlin.g.b.s.s(localObject2, "context");
      if (com.tencent.mm.plugin.multitalk.ui.widget.k.a.iY((Context)localObject2) != 90)
      {
        localObject2 = com.tencent.mm.plugin.multitalk.ui.widget.k.Lvg;
        localObject2 = getContext();
        kotlin.g.b.s.s(localObject2, "context");
        if (com.tencent.mm.plugin.multitalk.ui.widget.k.a.iY((Context)localObject2) != 270) {
          break label1128;
        }
      }
      localObject2 = new RelativeLayout.LayoutParams(com.tencent.mm.plugin.multitalk.ui.widget.f.Lui, -1);
      ((RelativeLayout.LayoutParams)localObject2).removeRule(21);
      ((RelativeLayout.LayoutParams)localObject2).removeRule(12);
      ((RelativeLayout.LayoutParams)localObject2).addRule(21);
      ((FrameLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject2 = getBottomUiLayout();
      if (localObject2 != null)
      {
        localObject3 = getContext();
        kotlin.g.b.s.s(localObject3, "context");
        ((j)localObject2).e((Context)localObject3, (FrameLayout)localObject1);
      }
    }
    gii();
    localObject1 = this.LyB;
    label636:
    int i;
    if (localObject1 != null)
    {
      localObject2 = new RelativeLayout.LayoutParams(-1, -1);
      localObject3 = com.tencent.mm.plugin.multitalk.ui.widget.k.Lvg;
      localObject3 = getContext();
      kotlin.g.b.s.s(localObject3, "context");
      if (com.tencent.mm.plugin.multitalk.ui.widget.k.a.iY((Context)localObject3) != 90)
      {
        localObject3 = com.tencent.mm.plugin.multitalk.ui.widget.k.Lvg;
        localObject3 = getContext();
        kotlin.g.b.s.s(localObject3, "context");
        if (com.tencent.mm.plugin.multitalk.ui.widget.k.a.iY((Context)localObject3) != 270) {
          break label1200;
        }
      }
      ((RelativeLayout.LayoutParams)localObject2).removeRule(16);
      ((RelativeLayout.LayoutParams)localObject2).removeRule(3);
      ((RelativeLayout.LayoutParams)localObject2).removeRule(17);
      ((RelativeLayout.LayoutParams)localObject2).removeRule(2);
      localObject3 = getTopRoot();
      kotlin.g.b.s.checkNotNull(localObject3);
      ((RelativeLayout.LayoutParams)localObject2).addRule(17, ((FrameLayout)localObject3).getId());
      localObject3 = getBottomRoot();
      kotlin.g.b.s.checkNotNull(localObject3);
      ((RelativeLayout.LayoutParams)localObject2).addRule(16, ((FrameLayout)localObject3).getId());
      ((FrameLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject2 = getReadyUI();
      if (localObject2 != null)
      {
        localObject3 = getContext();
        kotlin.g.b.s.s(localObject3, "context");
        kotlin.g.b.s.u(localObject3, "context");
        kotlin.g.b.s.u(localObject1, "rootView");
        ((p)localObject2).Lzz = LayoutInflater.from((Context)localObject3).inflate(a.f.multitalk_screen_ready_ui, (ViewGroup)localObject1);
        localObject1 = ((p)localObject2).Lsc;
        if ((localObject1 == null) || (((e)localObject1).abY(4) != true)) {
          break label1267;
        }
        i = 1;
        label721:
        if (i == 0) {
          break label1300;
        }
        ((p)localObject2).bjs();
        ((p)localObject2).timerHandler.startTimer(0L, 1000L);
        localObject1 = ((p)localObject2).Lzz;
        if (localObject1 != null) {
          break label1272;
        }
        localObject1 = null;
        label751:
        ((p)localObject2).njJ = ((TextView)localObject1);
        localObject1 = ((p)localObject2).Lzz;
        if (localObject1 != null) {
          break label1286;
        }
        localObject1 = null;
        label767:
        ((p)localObject2).LzA = ((TextView)localObject1);
      }
    }
    label772:
    gih();
    localObject1 = this.LyC;
    if (localObject1 != null)
    {
      localObject2 = new RelativeLayout.LayoutParams(-1, -1);
      localObject3 = com.tencent.mm.plugin.multitalk.ui.widget.k.Lvg;
      localObject3 = getContext();
      kotlin.g.b.s.s(localObject3, "context");
      if (com.tencent.mm.plugin.multitalk.ui.widget.k.a.iY((Context)localObject3) != 90)
      {
        localObject3 = com.tencent.mm.plugin.multitalk.ui.widget.k.Lvg;
        localObject3 = getContext();
        kotlin.g.b.s.s(localObject3, "context");
        if (com.tencent.mm.plugin.multitalk.ui.widget.k.a.iY((Context)localObject3) != 270) {}
      }
      else
      {
        ((RelativeLayout.LayoutParams)localObject2).removeRule(16);
        ((RelativeLayout.LayoutParams)localObject2).removeRule(3);
        ((RelativeLayout.LayoutParams)localObject2).removeRule(17);
        ((RelativeLayout.LayoutParams)localObject2).removeRule(2);
        localObject3 = getTopRoot();
        kotlin.g.b.s.checkNotNull(localObject3);
        ((RelativeLayout.LayoutParams)localObject2).addRule(17, ((FrameLayout)localObject3).getId());
        localObject3 = getBottomRoot();
        kotlin.g.b.s.checkNotNull(localObject3);
        ((RelativeLayout.LayoutParams)localObject2).addRule(16, ((FrameLayout)localObject3).getId());
        localObject3 = getMultiTalkStrokeContext();
        if (localObject3 != null) {
          ((b)localObject3).zs(true);
        }
        label937:
        ((FrameLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
    }
    else
    {
      localObject1 = this.LyF;
      if (localObject1 != null) {
        ((FrameLayout)localObject1).removeAllViews();
      }
      localObject1 = this.LyF;
      if (localObject1 != null)
      {
        localObject2 = new RelativeLayout.LayoutParams(-1, -1);
        localObject3 = com.tencent.mm.plugin.multitalk.ui.widget.k.Lvg;
        localObject3 = getContext();
        kotlin.g.b.s.s(localObject3, "context");
        if (com.tencent.mm.plugin.multitalk.ui.widget.k.a.iY((Context)localObject3) != 90)
        {
          localObject3 = com.tencent.mm.plugin.multitalk.ui.widget.k.Lvg;
          localObject3 = getContext();
          kotlin.g.b.s.s(localObject3, "context");
          if (com.tencent.mm.plugin.multitalk.ui.widget.k.a.iY((Context)localObject3) != 270) {
            break label1408;
          }
        }
        ((RelativeLayout.LayoutParams)localObject2).removeRule(16);
        ((RelativeLayout.LayoutParams)localObject2).removeRule(3);
        ((RelativeLayout.LayoutParams)localObject2).removeRule(17);
        ((RelativeLayout.LayoutParams)localObject2).removeRule(2);
        localObject3 = getTopRoot();
        kotlin.g.b.s.checkNotNull(localObject3);
        ((RelativeLayout.LayoutParams)localObject2).addRule(17, ((FrameLayout)localObject3).getId());
        localObject3 = getBottomRoot();
        kotlin.g.b.s.checkNotNull(localObject3);
        ((RelativeLayout.LayoutParams)localObject2).addRule(16, ((FrameLayout)localObject3).getId());
      }
    }
    for (;;)
    {
      ((FrameLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject2 = getAvatarLayout();
      if (localObject2 != null) {
        ((i)localObject2).Q((ViewGroup)localObject1);
      }
      return;
      label1128:
      localObject2 = new RelativeLayout.LayoutParams(-1, com.tencent.mm.plugin.multitalk.ui.widget.f.Lui);
      ((RelativeLayout.LayoutParams)localObject2).removeRule(21);
      ((RelativeLayout.LayoutParams)localObject2).removeRule(12);
      ((RelativeLayout.LayoutParams)localObject2).addRule(12);
      ((FrameLayout)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localObject2 = getBottomUiLayout();
      if (localObject2 == null) {
        break;
      }
      localObject3 = getContext();
      kotlin.g.b.s.s(localObject3, "context");
      ((j)localObject2).d((Context)localObject3, (FrameLayout)localObject1);
      break;
      label1200:
      ((RelativeLayout.LayoutParams)localObject2).removeRule(16);
      ((RelativeLayout.LayoutParams)localObject2).removeRule(3);
      ((RelativeLayout.LayoutParams)localObject2).removeRule(17);
      ((RelativeLayout.LayoutParams)localObject2).removeRule(2);
      localObject3 = getTopRoot();
      kotlin.g.b.s.checkNotNull(localObject3);
      ((RelativeLayout.LayoutParams)localObject2).addRule(3, ((FrameLayout)localObject3).getId());
      localObject3 = getBottomRoot();
      kotlin.g.b.s.checkNotNull(localObject3);
      ((RelativeLayout.LayoutParams)localObject2).addRule(2, ((FrameLayout)localObject3).getId());
      break label636;
      label1267:
      i = 0;
      break label721;
      label1272:
      localObject1 = (TextView)((View)localObject1).findViewById(a.e.ready_count_down_tv);
      break label751;
      label1286:
      localObject1 = (TextView)((View)localObject1).findViewById(a.e.ready_detail_tv);
      break label767;
      label1300:
      ((p)localObject2).giy();
      break label772;
      ((RelativeLayout.LayoutParams)localObject2).removeRule(16);
      ((RelativeLayout.LayoutParams)localObject2).removeRule(3);
      ((RelativeLayout.LayoutParams)localObject2).removeRule(17);
      ((RelativeLayout.LayoutParams)localObject2).removeRule(2);
      localObject3 = getMultiTalkStrokeContext();
      if (localObject3 != null) {
        ((b)localObject3).zs(false);
      }
      localObject3 = getTopRoot();
      if (localObject3 != null) {
        ((FrameLayout)localObject3).setVisibility(0);
      }
      localObject3 = getTopRoot();
      kotlin.g.b.s.checkNotNull(localObject3);
      ((RelativeLayout.LayoutParams)localObject2).addRule(3, ((FrameLayout)localObject3).getId());
      localObject3 = getBottomRoot();
      kotlin.g.b.s.checkNotNull(localObject3);
      ((RelativeLayout.LayoutParams)localObject2).addRule(2, ((FrameLayout)localObject3).getId());
      break label937;
      label1408:
      ((RelativeLayout.LayoutParams)localObject2).removeRule(16);
      ((RelativeLayout.LayoutParams)localObject2).removeRule(3);
      ((RelativeLayout.LayoutParams)localObject2).removeRule(17);
      ((RelativeLayout.LayoutParams)localObject2).removeRule(2);
      localObject3 = getTopRoot();
      kotlin.g.b.s.checkNotNull(localObject3);
      ((RelativeLayout.LayoutParams)localObject2).addRule(3, ((FrameLayout)localObject3).getId());
      localObject3 = getBottomRoot();
      kotlin.g.b.s.checkNotNull(localObject3);
      ((RelativeLayout.LayoutParams)localObject2).addRule(2, ((FrameLayout)localObject3).getId());
    }
  }
  
  protected final void setAvatarLayout(i parami)
  {
    this.LyJ = parami;
  }
  
  public final void setAvatarLayoutOn(boolean paramBoolean)
  {
    this.LyP = paramBoolean;
  }
  
  protected final void setAvatarRoot(FrameLayout paramFrameLayout)
  {
    this.LyF = paramFrameLayout;
  }
  
  protected final void setBitmapRenderPrco(com.tencent.mm.plugin.multitalk.ui.widget.projector.b.a parama)
  {
    this.LyL = parama;
  }
  
  protected final void setBottomRoot(FrameLayout paramFrameLayout)
  {
    this.LyE = paramFrameLayout;
  }
  
  protected final void setBottomUiLayout(j paramj)
  {
    this.LyH = paramj;
  }
  
  public final void setDoodleLayoutOn(boolean paramBoolean)
  {
    this.LyO = paramBoolean;
  }
  
  protected final void setLockGenerateBitmap(boolean paramBoolean)
  {
    this.LyU = paramBoolean;
  }
  
  protected final void setMCurrentPageHeight(int paramInt)
  {
    this.Lxz = paramInt;
  }
  
  protected final void setMCurrentPageWidth(int paramInt)
  {
    this.Lxy = paramInt;
  }
  
  protected final void setMCurrentScale(float paramFloat)
  {
    this.Lxx = paramFloat;
  }
  
  protected final void setMEditLayout(FrameLayout paramFrameLayout)
  {
    this.LyC = paramFrameLayout;
  }
  
  protected final void setMReadyLayout(FrameLayout paramFrameLayout)
  {
    this.LyB = paramFrameLayout;
  }
  
  protected final void setMScreenReportData(q paramq)
  {
    this.Lyz = paramq;
  }
  
  protected final void setMStartTimes(long paramLong)
  {
    this.LyA = paramLong;
  }
  
  protected final void setMultiTalkStrokeContext(b paramb)
  {
    this.LyG = paramb;
  }
  
  public final void setReadyNotAllowClick(boolean paramBoolean)
  {
    boolean bool2 = true;
    this.LyQ = paramBoolean;
    Object localObject = this.LyG;
    boolean bool1;
    if (localObject != null)
    {
      if (paramBoolean) {
        break label66;
      }
      bool1 = true;
      localObject = ((b)localObject).LxB;
      if (localObject != null) {
        ((com.tencent.mm.plugin.multitalk.ui.a.b)localObject).setDrawingEnable(bool1);
      }
    }
    localObject = this.LyH;
    if (localObject != null) {
      if (paramBoolean) {
        break label71;
      }
    }
    label66:
    label71:
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      ((j)localObject).Lyw = paramBoolean;
      return;
      bool1 = false;
      break;
    }
  }
  
  protected final void setReadyUI(p paramp)
  {
    this.LyI = paramp;
  }
  
  protected final void setScreenFuncConfig(e parame)
  {
    this.Lyy = parame;
  }
  
  public final void setScreenProjectSending(boolean paramBoolean)
  {
    this.LyN = paramBoolean;
    ac.ggS().Lof = paramBoolean;
  }
  
  protected final void setSendData(MMHandler paramMMHandler)
  {
    this.LyT = paramMMHandler;
  }
  
  protected final void setTopRoot(FrameLayout paramFrameLayout)
  {
    this.LyD = paramFrameLayout;
  }
  
  protected final void setTopUiLayout(n paramn)
  {
    this.LyK = paramn;
  }
  
  public void zt(boolean paramBoolean)
  {
    int j = 8;
    this.LyA = Util.currentTicks();
    Object localObject = this.LyC;
    if (localObject != null) {
      if (!paramBoolean) {
        break label239;
      }
    }
    label239:
    for (int i = 0;; i = 8)
    {
      ((FrameLayout)localObject).setVisibility(i);
      localObject = this.LyK;
      if (localObject != null)
      {
        localObject = ((n)localObject).xeE;
        if (localObject != null) {
          ((TextView)localObject).setVisibility(0);
        }
      }
      localObject = this.LyH;
      if (localObject != null)
      {
        localObject = ((j)localObject).Lym;
        if (localObject != null)
        {
          i = j;
          if (paramBoolean) {
            i = 0;
          }
          ((View)localObject).setVisibility(i);
        }
      }
      localObject = this.LyG;
      if (localObject != null)
      {
        FrameLayout localFrameLayout = getMEditLayout();
        if (localFrameLayout != null) {
          localFrameLayout.addView((View)((b)localObject).Lxw);
        }
      }
      localObject = this.LyB;
      if (localObject != null) {
        ((FrameLayout)localObject).setVisibility(0);
      }
      localObject = this.LyB;
      if (localObject != null) {
        ((FrameLayout)localObject).clearAnimation();
      }
      localObject = this.LyB;
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
  
  public final void zx(boolean paramBoolean)
  {
    setScreenProjectSending(false);
    Object localObject = this.LyT;
    if (localObject != null) {
      ((MMHandler)localObject).removeCallbacksAndMessages(null);
    }
    localObject = this.LyT;
    if (localObject != null) {
      ((MMHandler)localObject).quitSafely();
    }
    this.LyT = null;
    localObject = this.LyR;
    if (localObject != null) {
      ((com.tencent.threadpool.i.d)localObject).cancel(false);
    }
    this.LyR = null;
    localObject = this.LyS;
    if (localObject != null) {
      ((com.tencent.threadpool.i.d)localObject).cancel(false);
    }
    this.LyS = null;
    if (paramBoolean)
    {
      ac.ggS();
      com.tencent.mm.plugin.multitalk.model.p.abJ(102);
    }
    for (;;)
    {
      ac.ggS().gfc();
      return;
      ac.ggS();
      com.tencent.mm.plugin.multitalk.model.p.abJ(103);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectRootView$getRenderBitmap$1", "Ljava/util/TimerTask;", "run", "", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends TimerTask
  {
    c(k paramk) {}
    
    private static final void c(k paramk)
    {
      AppMethodBeat.i(285951);
      kotlin.g.b.s.u(paramk, "this$0");
      Object localObject;
      long l2;
      e locale;
      boolean bool;
      if (!paramk.LyU)
      {
        localObject = paramk.getBackgroundView();
        if (localObject != null)
        {
          l2 = Util.currentTicks();
          locale = paramk.getScreenFuncConfig();
          if (locale != null) {
            break label98;
          }
          bool = false;
          paramk.A((View)localObject, bool);
          localObject = paramk.getMScreenReportData();
          if (localObject != null)
          {
            paramk = paramk.getMScreenReportData();
            if (paramk != null) {
              break label110;
            }
          }
        }
      }
      label98:
      label110:
      for (long l1 = 0L;; l1 = paramk.LzC)
      {
        ((q)localObject).LzC = ((l1 + Util.ticksToNow(l2)) / 2L);
        AppMethodBeat.o(285951);
        return;
        bool = locale.abZ(11);
        break;
      }
    }
    
    public final void run()
    {
      AppMethodBeat.i(285960);
      if (!ac.ggS().Log) {
        com.tencent.threadpool.h.ahAA.bk(new k.c..ExternalSyntheticLambda0(this.LyV));
      }
      AppMethodBeat.o(285960);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/multitalk/ui/widget/projector/ScreenProjectRootView$getRenderBitmap$task$1", "Ljava/util/TimerTask;", "run", "", "plugin-multitalk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends TimerTask
  {
    d(k paramk) {}
    
    public final void run()
    {
      AppMethodBeat.i(285949);
      q localq1 = this.LyV.getMScreenReportData();
      q localq2;
      if (localq1 != null)
      {
        localq2 = this.LyV.getMScreenReportData();
        if (localq2 != null) {
          break label52;
        }
      }
      label52:
      for (int i = 0;; i = localq2.LzF)
      {
        localq1.LzF = ((i + k.b(this.LyV)) / 2);
        AppMethodBeat.o(285949);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/multitalk/ui/widget/projector/render/ScreenProjectCanvasRendererMgr;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.b<com.tencent.mm.plugin.multitalk.ui.widget.projector.b.a, ah>
  {
    e(k paramk)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.projector.k
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.scanner.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.Display;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.TextureView;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowManager;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.uk;
import com.tencent.mm.modelstat.n;
import com.tencent.mm.plugin.scanner.api.BaseScanRequest;
import com.tencent.mm.plugin.scanner.api.ScanGoodsRequest;
import com.tencent.mm.plugin.scanner.d.a.3;
import com.tencent.mm.plugin.scanner.l.d;
import com.tencent.mm.plugin.scanner.l.i;
import com.tencent.mm.plugin.scanner.model.ScanPoint;
import com.tencent.mm.plugin.scanner.model.ac;
import com.tencent.mm.plugin.scanner.model.ad;
import com.tencent.mm.plugin.scanner.model.ae;
import com.tencent.mm.plugin.scanner.model.al;
import com.tencent.mm.plugin.scanner.model.v;
import com.tencent.mm.plugin.scanner.model.w;
import com.tencent.mm.plugin.scanner.ui.scangoods.widget.ScanAnimationDotsView;
import com.tencent.mm.plugin.scanner.ui.scangoods.widget.ScanGoodsMaskView;
import com.tencent.mm.plugin.scanner.ui.widget.ScanCodeMaskView;
import com.tencent.mm.plugin.scanner.ui.widget.ScanDebugView;
import com.tencent.mm.plugin.scanner.ui.widget.ScanSharedMaskView;
import com.tencent.mm.plugin.scanner.ui.widget.ScanSharedMaskView.f;
import com.tencent.mm.plugin.scanner.util.ScanCameraLightDetector;
import com.tencent.mm.plugin.scanner.util.m;
import com.tencent.mm.plugin.scanner.util.m.b;
import com.tencent.mm.plugin.scanner.util.r;
import com.tencent.mm.plugin.scanner.view.BaseScanMaskView;
import com.tencent.mm.plugin.scanner.view.ScanRectDecorView;
import com.tencent.mm.plugin.scanner.view.ScanTranslationMaskView;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.qbar.QbarNative.QBarPoint;
import com.tencent.qbar.ScanDecodeFrameData;
import com.tencent.qbar.WxQBarPoint;
import com.tencent.qbar.WxQBarResult;
import com.tencent.qbar.WxQbarNative.QBarReportMsg;
import com.tencent.qbar.c;
import com.tencent.qbar.g;
import com.tencent.qbar.h.c;
import com.tencent.scanlib.a.b.b.a;
import com.tencent.scanlib.a.b.c.a;
import com.tencent.scanlib.a.b.d.a;
import com.tencent.scanlib.ui.ScanView;
import java.util.ArrayList;
import java.util.List;
import kotlin.a.e;

public class ScanUIRectView
  extends ScanView
{
  public static final int ISX;
  private float BpS;
  private boolean Cfm;
  private long IIw;
  BaseScanMaskView ILO;
  ScanSharedMaskView ILP;
  private ScannerFlashSwitcher IOH;
  private com.tencent.mm.plugin.scanner.ui.widget.b ION;
  private boolean IOV;
  boolean IOW;
  private BaseScanRequest IPe;
  private boolean IPp;
  private ScanRectDecorView ISL;
  ScanDebugView ISM;
  private a ISN;
  private String ISO;
  com.tencent.mm.plugin.scanner.model.d ISP;
  private boolean ISQ;
  private boolean ISR;
  private int ISS;
  private int IST;
  private boolean ISU;
  private boolean ISV;
  private boolean ISW;
  private boolean ISY;
  private boolean ISZ;
  private boolean ITa;
  private com.tencent.mm.plugin.scanner.util.h ITb;
  private int ITc;
  private long ITd;
  private boolean ITe;
  private boolean ITf;
  private boolean ITg;
  private Runnable ITh;
  private int ITi;
  private int ITj;
  private h.c ITk;
  private com.tencent.mm.plugin.scanner.d.a.a ITl;
  private IListener<uk> ITm;
  private b ITn;
  private Activity activity;
  private com.tencent.mm.modelgeo.b.a iQJ;
  private boolean isFirst;
  private boolean isRetry;
  private com.tencent.mm.modelgeo.d lEL;
  private long lastShotTime;
  private GestureDetector mBn;
  private long mTimeout;
  int mode;
  private Point wxC;
  private boolean zHI;
  
  static
  {
    AppMethodBeat.i(51980);
    ISX = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.vUq, 50);
    AppMethodBeat.o(51980);
  }
  
  public ScanUIRectView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(51945);
    this.mode = 1;
    this.IOV = true;
    this.IOW = false;
    this.ISQ = true;
    this.ISR = false;
    this.ISS = 0;
    this.IST = 120;
    this.Cfm = false;
    this.wxC = null;
    this.ISV = true;
    this.ISW = false;
    this.IPp = false;
    this.ISY = false;
    this.ISZ = false;
    this.isFirst = true;
    this.ITa = false;
    this.ITb = new com.tencent.mm.plugin.scanner.util.h();
    this.ITc = 0;
    this.ITd = 0L;
    this.mTimeout = this.ITb.mTimeout;
    this.ITe = false;
    this.ITf = true;
    this.ITg = false;
    this.isRetry = false;
    this.ITh = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(51916);
        if ((ScanUIRectView.a(ScanUIRectView.this)) && (!ScanUIRectView.b(ScanUIRectView.this)))
        {
          ScanUIRectView.c(ScanUIRectView.this);
          ScanUIRectView.d(ScanUIRectView.this);
          ad.fDf();
          ScanUIRectView.e(ScanUIRectView.this);
        }
        AppMethodBeat.o(51916);
      }
    };
    this.ITi = 0;
    this.ITj = 0;
    this.ITk = new h.c()
    {
      public final void a(final long paramAnonymousLong, List<com.tencent.qbar.a.a> paramAnonymousList, final List<QbarNative.QBarPoint> paramAnonymousList1, final List<WxQbarNative.QBarReportMsg> paramAnonymousList2, final Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(217802);
        Log.d("MicroMsg.ScanUIRectView", String.format("scan code after decode %d", new Object[] { Long.valueOf(paramAnonymousLong) }));
        if ((paramAnonymousList != null) && (!paramAnonymousList.isEmpty())) {
          ScanUIRectView.this.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(161014);
              ArrayList localArrayList;
              int j;
              int i;
              Object localObject1;
              if ((ScanUIRectView.l(ScanUIRectView.this) == paramAnonymousLong) && (paramAnonymousLong != 0L))
              {
                ScanUIRectView.this.fEa();
                localArrayList = new ArrayList();
                if ((paramAnonymousList2 != null) && (!paramAnonymousList2.isEmpty()))
                {
                  Log.i("MicroMsg.ScanUIRectView", "alvinluo onDecodeSuccess result size: %d", new Object[] { Integer.valueOf(paramAnonymousList2.size()) });
                  j = 0;
                  i = 0;
                  if (j < paramAnonymousList2.size())
                  {
                    localObject1 = (com.tencent.qbar.a.a)paramAnonymousList2.get(j);
                    localObject1 = new WxQBarResult(((com.tencent.qbar.a.a)localObject1).typeID, ((com.tencent.qbar.a.a)localObject1).typeName, ((com.tencent.qbar.a.a)localObject1).data, ((com.tencent.qbar.a.a)localObject1).rawData, ((com.tencent.qbar.a.a)localObject1).charset, ((com.tencent.qbar.a.a)localObject1).priorityLevel);
                    Log.i("MicroMsg.ScanUIRectView", "alvinluo onDecodeSuccess result index: %d, format: %d, content:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(((WxQBarResult)localObject1).typeID), ((WxQBarResult)localObject1).data });
                    if ((paramAnonymousList1 != null) && (paramAnonymousList1.size() >= j + 1))
                    {
                      localObject2 = (WxQbarNative.QBarReportMsg)paramAnonymousList1.get(j);
                      if (localObject2 != null) {
                        ((WxQBarResult)localObject1).Zmv = ((WxQbarNative.QBarReportMsg)localObject2).qrcodeVersion;
                      }
                    }
                    if ((paramAnonymousBundle == null) || (paramAnonymousBundle.size() < j + 1)) {
                      break label426;
                    }
                    Object localObject2 = (QbarNative.QBarPoint)paramAnonymousBundle.get(j);
                    if (localObject2 == null) {
                      break label426;
                    }
                    ((WxQBarResult)localObject1).ZmX = new WxQBarPoint((QbarNative.QBarPoint)localObject2);
                    i += 1;
                  }
                }
              }
              label426:
              for (;;)
              {
                localArrayList.add(localObject1);
                j += 1;
                break;
                localObject1 = new Bundle();
                ((Bundle)localObject1).putParcelableArrayList("result_qbar_result_list", localArrayList);
                ((Bundle)localObject1).putInt("result_code_point_count", i);
                if (this.ITr != null) {
                  ((Bundle)localObject1).putAll(this.ITr);
                }
                ScanUIRectView.this.dlq();
                if (ScanUIRectView.m(ScanUIRectView.this) != null) {
                  ScanUIRectView.m(ScanUIRectView.this).e(ScanUIRectView.l(ScanUIRectView.this), (Bundle)localObject1);
                }
                AppMethodBeat.o(161014);
                return;
              }
            }
          });
        }
        AppMethodBeat.o(217802);
      }
      
      public final void as(final long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(217800);
        ScanUIRectView.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(161013);
            if ((paramAnonymousLong1 == ScanUIRectView.l(ScanUIRectView.this)) && (paramAnonymousLong1 != 0L)) {
              ScanUIRectView.this.PW(this.DNj);
            }
            AppMethodBeat.o(161013);
          }
        });
        AppMethodBeat.o(217800);
      }
      
      public final void b(final long paramAnonymousLong, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(217803);
        ScanUIRectView.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(161015);
            if ((paramAnonymousLong == ScanUIRectView.l(ScanUIRectView.this)) && (paramAnonymousLong != 0L) && (this.val$param.containsKey("param_zoom_ratio")))
            {
              float f = this.val$param.getFloat("param_zoom_ratio", 0.0F);
              Log.i("MicroMsg.ScanUIRectView", "zoom to scale %f", new Object[] { Float.valueOf(f) });
              if ((f > 0.0F) && (ScanUIRectView.n(ScanUIRectView.this)) && (ScanUIRectView.o(ScanUIRectView.this).egx()))
              {
                int i = (int)(((com.tencent.scanlib.a.a)ScanUIRectView.p(ScanUIRectView.this)).iov() * f);
                ((com.tencent.scanlib.a.a)ScanUIRectView.q(ScanUIRectView.this)).aAr(i);
                c localc = c.Zmm;
                localc.ZmA += 1;
                localc.ZmB *= f;
                localc.ZmC = (System.currentTimeMillis() - localc.IMq);
                Log.v("MicroMsg.QBarEngineReporter", "alvinluo zoom %d, zoomFactor: %s, totalZoomFactor: %s, lastZoomCostTime: %d", new Object[] { Integer.valueOf(localc.ZmA), Float.valueOf(f), Float.valueOf(localc.ZmB), Long.valueOf(localc.ZmC) });
              }
            }
            AppMethodBeat.o(161015);
          }
        });
        AppMethodBeat.o(217803);
      }
    };
    this.ITl = new com.tencent.mm.plugin.scanner.d.a.a()
    {
      public final void PQ(final long paramAnonymousLong)
      {
        AppMethodBeat.i(221446);
        Log.d("MicroMsg.ScanUIRectView", "alvinluo postTakeShot session: %d, delay: %d", new Object[] { Long.valueOf(paramAnonymousLong), Long.valueOf(0L) });
        ScanUIRectView.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(221848);
            if ((ScanUIRectView.l(ScanUIRectView.this) == paramAnonymousLong) && (ScanUIRectView.l(ScanUIRectView.this) != 0L)) {
              ScanUIRectView.this.PW(this.DNj);
            }
            AppMethodBeat.o(221848);
          }
        });
        AppMethodBeat.o(221446);
      }
      
      public final void a(final long paramAnonymousLong, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(221444);
        Log.d("MicroMsg.ScanUIRectView", "alvinluo onDecodeSuccess %d", new Object[] { Long.valueOf(paramAnonymousLong) });
        if (paramAnonymousBundle.getBoolean("result_is_best_img", false)) {
          ScanUIRectView.this.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(222216);
              if ((paramAnonymousLong == ScanUIRectView.l(ScanUIRectView.this)) && (ScanUIRectView.l(ScanUIRectView.this) != 0L) && (ScanUIRectView.m(ScanUIRectView.this) != null)) {
                ScanUIRectView.m(ScanUIRectView.this).e(ScanUIRectView.l(ScanUIRectView.this), this.val$result);
              }
              AppMethodBeat.o(222216);
            }
          });
        }
        AppMethodBeat.o(221444);
      }
      
      public final void a(final ac paramAnonymousac)
      {
        AppMethodBeat.i(221447);
        ScanUIRectView.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(217934);
            if ((paramAnonymousac != null) && ((ScanUIRectView.r(ScanUIRectView.this) instanceof ScanGoodsMaskView)))
            {
              ScanGoodsMaskView localScanGoodsMaskView = (ScanGoodsMaskView)ScanUIRectView.r(ScanUIRectView.this);
              ac localac = paramAnonymousac;
              kotlin.g.b.p.k(localac, "pointsResult");
              if (localScanGoodsMaskView.Jam)
              {
                Log.i("MicroMsg.ScanGoodsMaskView", "alvinluo addAnimationScanDots isViewDestroy");
                AppMethodBeat.o(217934);
                return;
              }
              ScanPoint[] arrayOfScanPoint = localac.points;
              if (arrayOfScanPoint != null)
              {
                Log.v("MicroMsg.ScanGoodsMaskView", "alvinluo addAnimationScanDots size: %d", new Object[] { Integer.valueOf(localac.pointCount) });
                int j = localac.pointCount;
                int i = 0;
                if (i < j)
                {
                  Object localObject2 = (ScanPoint)e.g(arrayOfScanPoint, i);
                  label149:
                  Float localFloat;
                  if (localObject2 != null)
                  {
                    localObject1 = Integer.valueOf(((ScanPoint)localObject2).getId());
                    if (localObject2 == null) {
                      break label216;
                    }
                    localFloat = Float.valueOf(((ScanPoint)localObject2).getX());
                    label164:
                    if (localObject2 == null) {
                      break label222;
                    }
                  }
                  label216:
                  label222:
                  for (localObject2 = Float.valueOf(((ScanPoint)localObject2).getY());; localObject2 = null)
                  {
                    Log.v("MicroMsg.ScanGoodsMaskView", "alvinluo getPointObjects id: %d, x: %f, y: %f", new Object[] { localObject1, localFloat, localObject2 });
                    i += 1;
                    break;
                    localObject1 = null;
                    break label149;
                    localFloat = null;
                    break label164;
                  }
                }
                Object localObject1 = localScanGoodsMaskView.IVq;
                if (localObject1 == null) {
                  kotlin.g.b.p.bGy("animationDotsView");
                }
                ((ScanAnimationDotsView)localObject1).b(localac);
              }
            }
            AppMethodBeat.o(217934);
          }
        });
        AppMethodBeat.o(221447);
      }
    };
    this.iQJ = new com.tencent.mm.modelgeo.b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(218352);
        Log.i("MicroMsg.ScanUIRectView", "onGetLocation %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (!paramAnonymousBoolean)
        {
          Log.i("MicroMsg.ScanUIRectView", "check permission not passed!");
          if ((!ScanUIRectView.s(ScanUIRectView.this)) && (!com.tencent.mm.modelgeo.d.blr()))
          {
            ScanUIRectView.t(ScanUIRectView.this);
            com.tencent.mm.ui.base.h.a(ScanUIRectView.this.getContext(), ScanUIRectView.this.getContext().getString(l.i.gps_disable_tip), ScanUIRectView.this.getContext().getString(l.i.app_tip), ScanUIRectView.this.getContext().getString(l.i.jump_to_settings), ScanUIRectView.this.getContext().getString(l.i.app_cancel), false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(222610);
                com.tencent.mm.modelgeo.d.cW(ScanUIRectView.this.getContext());
                AppMethodBeat.o(222610);
              }
            }, null);
          }
          AppMethodBeat.o(218352);
          return true;
        }
        if (ScanUIRectView.u(ScanUIRectView.this))
        {
          Log.i("MicroMsg.ScanUIRectView", "ignore, has get lbs!");
          AppMethodBeat.o(218352);
          return false;
        }
        ScanUIRectView.this.dlq();
        ScanUIRectView.v(ScanUIRectView.this);
        n.a(2012, paramAnonymousFloat1, paramAnonymousFloat2, (int)paramAnonymousDouble2);
        if (ScanUIRectView.m(ScanUIRectView.this) != null)
        {
          Bundle localBundle = new Bundle();
          localBundle.putFloat("result_lbs_latitude", paramAnonymousFloat2);
          localBundle.putFloat("result_lbs_longitude", paramAnonymousFloat1);
          localBundle.putInt("result_lbs_accuracy", (int)paramAnonymousDouble2);
          localBundle.putInt("result_lbs_source", paramAnonymousInt);
          ScanUIRectView.m(ScanUIRectView.this).e(ScanUIRectView.l(ScanUIRectView.this), localBundle);
        }
        AppMethodBeat.o(218352);
        return false;
      }
    };
    this.ITm = new IListener() {};
    this.mBn = new GestureDetector(new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(222264);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/scanner/ui/ScanUIRectView$15", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/scanner/ui/ScanUIRectView$15", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(222264);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(161025);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/scanner/ui/ScanUIRectView$15", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
        Log.d("MicroMsg.ScanUIRectView", "double click,pointer:%d,x:%f,y:%f", new Object[] { Integer.valueOf(paramAnonymousMotionEvent.getActionIndex()), Float.valueOf(paramAnonymousMotionEvent.getX(paramAnonymousMotionEvent.getActionIndex())), Float.valueOf(paramAnonymousMotionEvent.getY(paramAnonymousMotionEvent.getActionIndex())) });
        ((com.tencent.scanlib.a.a)ScanUIRectView.A(ScanUIRectView.this)).aAs(5);
        ad.je(ScanUIRectView.B(ScanUIRectView.this), 3);
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/scanner/ui/ScanUIRectView$15", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(161025);
        return true;
      }
      
      public final boolean onFling(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(161026);
        Log.d("MicroMsg.ScanUIRectView", "alvinluo onFling velocityX: %f, velocityY: %f, canScrollSwitchTab: %b, enableScrollSwitchTab: %b, isMultiTouch: %b", new Object[] { Float.valueOf(paramAnonymousFloat1), Float.valueOf(paramAnonymousFloat2), Boolean.valueOf(ScanUIRectView.C(ScanUIRectView.this)), Boolean.valueOf(ScanUIRectView.D(ScanUIRectView.this)), Boolean.valueOf(ScanUIRectView.E(ScanUIRectView.this)) });
        if ((!ScanUIRectView.E(ScanUIRectView.this)) && (ScanUIRectView.D(ScanUIRectView.this)) && (Math.abs(paramAnonymousFloat1) > Math.abs(paramAnonymousFloat2)))
        {
          if ((paramAnonymousFloat1 >= -1200.0F) || (!ScanUIRectView.C(ScanUIRectView.this))) {
            break label168;
          }
          if (ScanUIRectView.F(ScanUIRectView.this) != null) {
            ScanUIRectView.F(ScanUIRectView.this).fEC();
          }
          ScanUIRectView.b(ScanUIRectView.this, false);
        }
        for (;;)
        {
          boolean bool = super.onFling(paramAnonymousMotionEvent1, paramAnonymousMotionEvent2, paramAnonymousFloat1, paramAnonymousFloat2);
          AppMethodBeat.o(161026);
          return bool;
          label168:
          if ((paramAnonymousFloat1 > 1200.0F) && (ScanUIRectView.C(ScanUIRectView.this)))
          {
            if (ScanUIRectView.F(ScanUIRectView.this) != null) {
              ScanUIRectView.F(ScanUIRectView.this).fED();
            }
            ScanUIRectView.b(ScanUIRectView.this, false);
          }
        }
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(222262);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/scanner/ui/ScanUIRectView$15", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aFi());
        super.onLongPress(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/ScanUIRectView$15", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(222262);
      }
      
      public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(222259);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/scanner/ui/ScanUIRectView$15", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
        boolean bool = super.onSingleTapUp(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/scanner/ui/ScanUIRectView$15", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(222259);
        return bool;
      }
    });
    this.ITn = new b(Looper.getMainLooper());
    AppMethodBeat.o(51945);
  }
  
  public ScanUIRectView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(51946);
    this.mode = 1;
    this.IOV = true;
    this.IOW = false;
    this.ISQ = true;
    this.ISR = false;
    this.ISS = 0;
    this.IST = 120;
    this.Cfm = false;
    this.wxC = null;
    this.ISV = true;
    this.ISW = false;
    this.IPp = false;
    this.ISY = false;
    this.ISZ = false;
    this.isFirst = true;
    this.ITa = false;
    this.ITb = new com.tencent.mm.plugin.scanner.util.h();
    this.ITc = 0;
    this.ITd = 0L;
    this.mTimeout = this.ITb.mTimeout;
    this.ITe = false;
    this.ITf = true;
    this.ITg = false;
    this.isRetry = false;
    this.ITh = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(51916);
        if ((ScanUIRectView.a(ScanUIRectView.this)) && (!ScanUIRectView.b(ScanUIRectView.this)))
        {
          ScanUIRectView.c(ScanUIRectView.this);
          ScanUIRectView.d(ScanUIRectView.this);
          ad.fDf();
          ScanUIRectView.e(ScanUIRectView.this);
        }
        AppMethodBeat.o(51916);
      }
    };
    this.ITi = 0;
    this.ITj = 0;
    this.ITk = new h.c()
    {
      public final void a(final long paramAnonymousLong, List<com.tencent.qbar.a.a> paramAnonymousList, final List<QbarNative.QBarPoint> paramAnonymousList1, final List<WxQbarNative.QBarReportMsg> paramAnonymousList2, final Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(217802);
        Log.d("MicroMsg.ScanUIRectView", String.format("scan code after decode %d", new Object[] { Long.valueOf(paramAnonymousLong) }));
        if ((paramAnonymousList != null) && (!paramAnonymousList.isEmpty())) {
          ScanUIRectView.this.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(161014);
              ArrayList localArrayList;
              int j;
              int i;
              Object localObject1;
              if ((ScanUIRectView.l(ScanUIRectView.this) == paramAnonymousLong) && (paramAnonymousLong != 0L))
              {
                ScanUIRectView.this.fEa();
                localArrayList = new ArrayList();
                if ((paramAnonymousList2 != null) && (!paramAnonymousList2.isEmpty()))
                {
                  Log.i("MicroMsg.ScanUIRectView", "alvinluo onDecodeSuccess result size: %d", new Object[] { Integer.valueOf(paramAnonymousList2.size()) });
                  j = 0;
                  i = 0;
                  if (j < paramAnonymousList2.size())
                  {
                    localObject1 = (com.tencent.qbar.a.a)paramAnonymousList2.get(j);
                    localObject1 = new WxQBarResult(((com.tencent.qbar.a.a)localObject1).typeID, ((com.tencent.qbar.a.a)localObject1).typeName, ((com.tencent.qbar.a.a)localObject1).data, ((com.tencent.qbar.a.a)localObject1).rawData, ((com.tencent.qbar.a.a)localObject1).charset, ((com.tencent.qbar.a.a)localObject1).priorityLevel);
                    Log.i("MicroMsg.ScanUIRectView", "alvinluo onDecodeSuccess result index: %d, format: %d, content:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(((WxQBarResult)localObject1).typeID), ((WxQBarResult)localObject1).data });
                    if ((paramAnonymousList1 != null) && (paramAnonymousList1.size() >= j + 1))
                    {
                      localObject2 = (WxQbarNative.QBarReportMsg)paramAnonymousList1.get(j);
                      if (localObject2 != null) {
                        ((WxQBarResult)localObject1).Zmv = ((WxQbarNative.QBarReportMsg)localObject2).qrcodeVersion;
                      }
                    }
                    if ((paramAnonymousBundle == null) || (paramAnonymousBundle.size() < j + 1)) {
                      break label426;
                    }
                    Object localObject2 = (QbarNative.QBarPoint)paramAnonymousBundle.get(j);
                    if (localObject2 == null) {
                      break label426;
                    }
                    ((WxQBarResult)localObject1).ZmX = new WxQBarPoint((QbarNative.QBarPoint)localObject2);
                    i += 1;
                  }
                }
              }
              label426:
              for (;;)
              {
                localArrayList.add(localObject1);
                j += 1;
                break;
                localObject1 = new Bundle();
                ((Bundle)localObject1).putParcelableArrayList("result_qbar_result_list", localArrayList);
                ((Bundle)localObject1).putInt("result_code_point_count", i);
                if (this.ITr != null) {
                  ((Bundle)localObject1).putAll(this.ITr);
                }
                ScanUIRectView.this.dlq();
                if (ScanUIRectView.m(ScanUIRectView.this) != null) {
                  ScanUIRectView.m(ScanUIRectView.this).e(ScanUIRectView.l(ScanUIRectView.this), (Bundle)localObject1);
                }
                AppMethodBeat.o(161014);
                return;
              }
            }
          });
        }
        AppMethodBeat.o(217802);
      }
      
      public final void as(final long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(217800);
        ScanUIRectView.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(161013);
            if ((paramAnonymousLong1 == ScanUIRectView.l(ScanUIRectView.this)) && (paramAnonymousLong1 != 0L)) {
              ScanUIRectView.this.PW(this.DNj);
            }
            AppMethodBeat.o(161013);
          }
        });
        AppMethodBeat.o(217800);
      }
      
      public final void b(final long paramAnonymousLong, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(217803);
        ScanUIRectView.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(161015);
            if ((paramAnonymousLong == ScanUIRectView.l(ScanUIRectView.this)) && (paramAnonymousLong != 0L) && (this.val$param.containsKey("param_zoom_ratio")))
            {
              float f = this.val$param.getFloat("param_zoom_ratio", 0.0F);
              Log.i("MicroMsg.ScanUIRectView", "zoom to scale %f", new Object[] { Float.valueOf(f) });
              if ((f > 0.0F) && (ScanUIRectView.n(ScanUIRectView.this)) && (ScanUIRectView.o(ScanUIRectView.this).egx()))
              {
                int i = (int)(((com.tencent.scanlib.a.a)ScanUIRectView.p(ScanUIRectView.this)).iov() * f);
                ((com.tencent.scanlib.a.a)ScanUIRectView.q(ScanUIRectView.this)).aAr(i);
                c localc = c.Zmm;
                localc.ZmA += 1;
                localc.ZmB *= f;
                localc.ZmC = (System.currentTimeMillis() - localc.IMq);
                Log.v("MicroMsg.QBarEngineReporter", "alvinluo zoom %d, zoomFactor: %s, totalZoomFactor: %s, lastZoomCostTime: %d", new Object[] { Integer.valueOf(localc.ZmA), Float.valueOf(f), Float.valueOf(localc.ZmB), Long.valueOf(localc.ZmC) });
              }
            }
            AppMethodBeat.o(161015);
          }
        });
        AppMethodBeat.o(217803);
      }
    };
    this.ITl = new com.tencent.mm.plugin.scanner.d.a.a()
    {
      public final void PQ(final long paramAnonymousLong)
      {
        AppMethodBeat.i(221446);
        Log.d("MicroMsg.ScanUIRectView", "alvinluo postTakeShot session: %d, delay: %d", new Object[] { Long.valueOf(paramAnonymousLong), Long.valueOf(0L) });
        ScanUIRectView.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(221848);
            if ((ScanUIRectView.l(ScanUIRectView.this) == paramAnonymousLong) && (ScanUIRectView.l(ScanUIRectView.this) != 0L)) {
              ScanUIRectView.this.PW(this.DNj);
            }
            AppMethodBeat.o(221848);
          }
        });
        AppMethodBeat.o(221446);
      }
      
      public final void a(final long paramAnonymousLong, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(221444);
        Log.d("MicroMsg.ScanUIRectView", "alvinluo onDecodeSuccess %d", new Object[] { Long.valueOf(paramAnonymousLong) });
        if (paramAnonymousBundle.getBoolean("result_is_best_img", false)) {
          ScanUIRectView.this.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(222216);
              if ((paramAnonymousLong == ScanUIRectView.l(ScanUIRectView.this)) && (ScanUIRectView.l(ScanUIRectView.this) != 0L) && (ScanUIRectView.m(ScanUIRectView.this) != null)) {
                ScanUIRectView.m(ScanUIRectView.this).e(ScanUIRectView.l(ScanUIRectView.this), this.val$result);
              }
              AppMethodBeat.o(222216);
            }
          });
        }
        AppMethodBeat.o(221444);
      }
      
      public final void a(final ac paramAnonymousac)
      {
        AppMethodBeat.i(221447);
        ScanUIRectView.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(217934);
            if ((paramAnonymousac != null) && ((ScanUIRectView.r(ScanUIRectView.this) instanceof ScanGoodsMaskView)))
            {
              ScanGoodsMaskView localScanGoodsMaskView = (ScanGoodsMaskView)ScanUIRectView.r(ScanUIRectView.this);
              ac localac = paramAnonymousac;
              kotlin.g.b.p.k(localac, "pointsResult");
              if (localScanGoodsMaskView.Jam)
              {
                Log.i("MicroMsg.ScanGoodsMaskView", "alvinluo addAnimationScanDots isViewDestroy");
                AppMethodBeat.o(217934);
                return;
              }
              ScanPoint[] arrayOfScanPoint = localac.points;
              if (arrayOfScanPoint != null)
              {
                Log.v("MicroMsg.ScanGoodsMaskView", "alvinluo addAnimationScanDots size: %d", new Object[] { Integer.valueOf(localac.pointCount) });
                int j = localac.pointCount;
                int i = 0;
                if (i < j)
                {
                  Object localObject2 = (ScanPoint)e.g(arrayOfScanPoint, i);
                  label149:
                  Float localFloat;
                  if (localObject2 != null)
                  {
                    localObject1 = Integer.valueOf(((ScanPoint)localObject2).getId());
                    if (localObject2 == null) {
                      break label216;
                    }
                    localFloat = Float.valueOf(((ScanPoint)localObject2).getX());
                    label164:
                    if (localObject2 == null) {
                      break label222;
                    }
                  }
                  label216:
                  label222:
                  for (localObject2 = Float.valueOf(((ScanPoint)localObject2).getY());; localObject2 = null)
                  {
                    Log.v("MicroMsg.ScanGoodsMaskView", "alvinluo getPointObjects id: %d, x: %f, y: %f", new Object[] { localObject1, localFloat, localObject2 });
                    i += 1;
                    break;
                    localObject1 = null;
                    break label149;
                    localFloat = null;
                    break label164;
                  }
                }
                Object localObject1 = localScanGoodsMaskView.IVq;
                if (localObject1 == null) {
                  kotlin.g.b.p.bGy("animationDotsView");
                }
                ((ScanAnimationDotsView)localObject1).b(localac);
              }
            }
            AppMethodBeat.o(217934);
          }
        });
        AppMethodBeat.o(221447);
      }
    };
    this.iQJ = new com.tencent.mm.modelgeo.b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(218352);
        Log.i("MicroMsg.ScanUIRectView", "onGetLocation %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (!paramAnonymousBoolean)
        {
          Log.i("MicroMsg.ScanUIRectView", "check permission not passed!");
          if ((!ScanUIRectView.s(ScanUIRectView.this)) && (!com.tencent.mm.modelgeo.d.blr()))
          {
            ScanUIRectView.t(ScanUIRectView.this);
            com.tencent.mm.ui.base.h.a(ScanUIRectView.this.getContext(), ScanUIRectView.this.getContext().getString(l.i.gps_disable_tip), ScanUIRectView.this.getContext().getString(l.i.app_tip), ScanUIRectView.this.getContext().getString(l.i.jump_to_settings), ScanUIRectView.this.getContext().getString(l.i.app_cancel), false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(222610);
                com.tencent.mm.modelgeo.d.cW(ScanUIRectView.this.getContext());
                AppMethodBeat.o(222610);
              }
            }, null);
          }
          AppMethodBeat.o(218352);
          return true;
        }
        if (ScanUIRectView.u(ScanUIRectView.this))
        {
          Log.i("MicroMsg.ScanUIRectView", "ignore, has get lbs!");
          AppMethodBeat.o(218352);
          return false;
        }
        ScanUIRectView.this.dlq();
        ScanUIRectView.v(ScanUIRectView.this);
        n.a(2012, paramAnonymousFloat1, paramAnonymousFloat2, (int)paramAnonymousDouble2);
        if (ScanUIRectView.m(ScanUIRectView.this) != null)
        {
          Bundle localBundle = new Bundle();
          localBundle.putFloat("result_lbs_latitude", paramAnonymousFloat2);
          localBundle.putFloat("result_lbs_longitude", paramAnonymousFloat1);
          localBundle.putInt("result_lbs_accuracy", (int)paramAnonymousDouble2);
          localBundle.putInt("result_lbs_source", paramAnonymousInt);
          ScanUIRectView.m(ScanUIRectView.this).e(ScanUIRectView.l(ScanUIRectView.this), localBundle);
        }
        AppMethodBeat.o(218352);
        return false;
      }
    };
    this.ITm = new IListener() {};
    this.mBn = new GestureDetector(new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(222264);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/scanner/ui/ScanUIRectView$15", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/scanner/ui/ScanUIRectView$15", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(222264);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(161025);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/scanner/ui/ScanUIRectView$15", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
        Log.d("MicroMsg.ScanUIRectView", "double click,pointer:%d,x:%f,y:%f", new Object[] { Integer.valueOf(paramAnonymousMotionEvent.getActionIndex()), Float.valueOf(paramAnonymousMotionEvent.getX(paramAnonymousMotionEvent.getActionIndex())), Float.valueOf(paramAnonymousMotionEvent.getY(paramAnonymousMotionEvent.getActionIndex())) });
        ((com.tencent.scanlib.a.a)ScanUIRectView.A(ScanUIRectView.this)).aAs(5);
        ad.je(ScanUIRectView.B(ScanUIRectView.this), 3);
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/scanner/ui/ScanUIRectView$15", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(161025);
        return true;
      }
      
      public final boolean onFling(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(161026);
        Log.d("MicroMsg.ScanUIRectView", "alvinluo onFling velocityX: %f, velocityY: %f, canScrollSwitchTab: %b, enableScrollSwitchTab: %b, isMultiTouch: %b", new Object[] { Float.valueOf(paramAnonymousFloat1), Float.valueOf(paramAnonymousFloat2), Boolean.valueOf(ScanUIRectView.C(ScanUIRectView.this)), Boolean.valueOf(ScanUIRectView.D(ScanUIRectView.this)), Boolean.valueOf(ScanUIRectView.E(ScanUIRectView.this)) });
        if ((!ScanUIRectView.E(ScanUIRectView.this)) && (ScanUIRectView.D(ScanUIRectView.this)) && (Math.abs(paramAnonymousFloat1) > Math.abs(paramAnonymousFloat2)))
        {
          if ((paramAnonymousFloat1 >= -1200.0F) || (!ScanUIRectView.C(ScanUIRectView.this))) {
            break label168;
          }
          if (ScanUIRectView.F(ScanUIRectView.this) != null) {
            ScanUIRectView.F(ScanUIRectView.this).fEC();
          }
          ScanUIRectView.b(ScanUIRectView.this, false);
        }
        for (;;)
        {
          boolean bool = super.onFling(paramAnonymousMotionEvent1, paramAnonymousMotionEvent2, paramAnonymousFloat1, paramAnonymousFloat2);
          AppMethodBeat.o(161026);
          return bool;
          label168:
          if ((paramAnonymousFloat1 > 1200.0F) && (ScanUIRectView.C(ScanUIRectView.this)))
          {
            if (ScanUIRectView.F(ScanUIRectView.this) != null) {
              ScanUIRectView.F(ScanUIRectView.this).fED();
            }
            ScanUIRectView.b(ScanUIRectView.this, false);
          }
        }
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(222262);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/scanner/ui/ScanUIRectView$15", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aFi());
        super.onLongPress(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/ScanUIRectView$15", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(222262);
      }
      
      public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(222259);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/scanner/ui/ScanUIRectView$15", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
        boolean bool = super.onSingleTapUp(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/scanner/ui/ScanUIRectView$15", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(222259);
        return bool;
      }
    });
    this.ITn = new b(Looper.getMainLooper());
    AppMethodBeat.o(51946);
  }
  
  public ScanUIRectView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(51947);
    this.mode = 1;
    this.IOV = true;
    this.IOW = false;
    this.ISQ = true;
    this.ISR = false;
    this.ISS = 0;
    this.IST = 120;
    this.Cfm = false;
    this.wxC = null;
    this.ISV = true;
    this.ISW = false;
    this.IPp = false;
    this.ISY = false;
    this.ISZ = false;
    this.isFirst = true;
    this.ITa = false;
    this.ITb = new com.tencent.mm.plugin.scanner.util.h();
    this.ITc = 0;
    this.ITd = 0L;
    this.mTimeout = this.ITb.mTimeout;
    this.ITe = false;
    this.ITf = true;
    this.ITg = false;
    this.isRetry = false;
    this.ITh = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(51916);
        if ((ScanUIRectView.a(ScanUIRectView.this)) && (!ScanUIRectView.b(ScanUIRectView.this)))
        {
          ScanUIRectView.c(ScanUIRectView.this);
          ScanUIRectView.d(ScanUIRectView.this);
          ad.fDf();
          ScanUIRectView.e(ScanUIRectView.this);
        }
        AppMethodBeat.o(51916);
      }
    };
    this.ITi = 0;
    this.ITj = 0;
    this.ITk = new h.c()
    {
      public final void a(final long paramAnonymousLong, List<com.tencent.qbar.a.a> paramAnonymousList, final List<QbarNative.QBarPoint> paramAnonymousList1, final List<WxQbarNative.QBarReportMsg> paramAnonymousList2, final Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(217802);
        Log.d("MicroMsg.ScanUIRectView", String.format("scan code after decode %d", new Object[] { Long.valueOf(paramAnonymousLong) }));
        if ((paramAnonymousList != null) && (!paramAnonymousList.isEmpty())) {
          ScanUIRectView.this.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(161014);
              ArrayList localArrayList;
              int j;
              int i;
              Object localObject1;
              if ((ScanUIRectView.l(ScanUIRectView.this) == paramAnonymousLong) && (paramAnonymousLong != 0L))
              {
                ScanUIRectView.this.fEa();
                localArrayList = new ArrayList();
                if ((paramAnonymousList2 != null) && (!paramAnonymousList2.isEmpty()))
                {
                  Log.i("MicroMsg.ScanUIRectView", "alvinluo onDecodeSuccess result size: %d", new Object[] { Integer.valueOf(paramAnonymousList2.size()) });
                  j = 0;
                  i = 0;
                  if (j < paramAnonymousList2.size())
                  {
                    localObject1 = (com.tencent.qbar.a.a)paramAnonymousList2.get(j);
                    localObject1 = new WxQBarResult(((com.tencent.qbar.a.a)localObject1).typeID, ((com.tencent.qbar.a.a)localObject1).typeName, ((com.tencent.qbar.a.a)localObject1).data, ((com.tencent.qbar.a.a)localObject1).rawData, ((com.tencent.qbar.a.a)localObject1).charset, ((com.tencent.qbar.a.a)localObject1).priorityLevel);
                    Log.i("MicroMsg.ScanUIRectView", "alvinluo onDecodeSuccess result index: %d, format: %d, content:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(((WxQBarResult)localObject1).typeID), ((WxQBarResult)localObject1).data });
                    if ((paramAnonymousList1 != null) && (paramAnonymousList1.size() >= j + 1))
                    {
                      localObject2 = (WxQbarNative.QBarReportMsg)paramAnonymousList1.get(j);
                      if (localObject2 != null) {
                        ((WxQBarResult)localObject1).Zmv = ((WxQbarNative.QBarReportMsg)localObject2).qrcodeVersion;
                      }
                    }
                    if ((paramAnonymousBundle == null) || (paramAnonymousBundle.size() < j + 1)) {
                      break label426;
                    }
                    Object localObject2 = (QbarNative.QBarPoint)paramAnonymousBundle.get(j);
                    if (localObject2 == null) {
                      break label426;
                    }
                    ((WxQBarResult)localObject1).ZmX = new WxQBarPoint((QbarNative.QBarPoint)localObject2);
                    i += 1;
                  }
                }
              }
              label426:
              for (;;)
              {
                localArrayList.add(localObject1);
                j += 1;
                break;
                localObject1 = new Bundle();
                ((Bundle)localObject1).putParcelableArrayList("result_qbar_result_list", localArrayList);
                ((Bundle)localObject1).putInt("result_code_point_count", i);
                if (this.ITr != null) {
                  ((Bundle)localObject1).putAll(this.ITr);
                }
                ScanUIRectView.this.dlq();
                if (ScanUIRectView.m(ScanUIRectView.this) != null) {
                  ScanUIRectView.m(ScanUIRectView.this).e(ScanUIRectView.l(ScanUIRectView.this), (Bundle)localObject1);
                }
                AppMethodBeat.o(161014);
                return;
              }
            }
          });
        }
        AppMethodBeat.o(217802);
      }
      
      public final void as(final long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(217800);
        ScanUIRectView.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(161013);
            if ((paramAnonymousLong1 == ScanUIRectView.l(ScanUIRectView.this)) && (paramAnonymousLong1 != 0L)) {
              ScanUIRectView.this.PW(this.DNj);
            }
            AppMethodBeat.o(161013);
          }
        });
        AppMethodBeat.o(217800);
      }
      
      public final void b(final long paramAnonymousLong, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(217803);
        ScanUIRectView.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(161015);
            if ((paramAnonymousLong == ScanUIRectView.l(ScanUIRectView.this)) && (paramAnonymousLong != 0L) && (this.val$param.containsKey("param_zoom_ratio")))
            {
              float f = this.val$param.getFloat("param_zoom_ratio", 0.0F);
              Log.i("MicroMsg.ScanUIRectView", "zoom to scale %f", new Object[] { Float.valueOf(f) });
              if ((f > 0.0F) && (ScanUIRectView.n(ScanUIRectView.this)) && (ScanUIRectView.o(ScanUIRectView.this).egx()))
              {
                int i = (int)(((com.tencent.scanlib.a.a)ScanUIRectView.p(ScanUIRectView.this)).iov() * f);
                ((com.tencent.scanlib.a.a)ScanUIRectView.q(ScanUIRectView.this)).aAr(i);
                c localc = c.Zmm;
                localc.ZmA += 1;
                localc.ZmB *= f;
                localc.ZmC = (System.currentTimeMillis() - localc.IMq);
                Log.v("MicroMsg.QBarEngineReporter", "alvinluo zoom %d, zoomFactor: %s, totalZoomFactor: %s, lastZoomCostTime: %d", new Object[] { Integer.valueOf(localc.ZmA), Float.valueOf(f), Float.valueOf(localc.ZmB), Long.valueOf(localc.ZmC) });
              }
            }
            AppMethodBeat.o(161015);
          }
        });
        AppMethodBeat.o(217803);
      }
    };
    this.ITl = new com.tencent.mm.plugin.scanner.d.a.a()
    {
      public final void PQ(final long paramAnonymousLong)
      {
        AppMethodBeat.i(221446);
        Log.d("MicroMsg.ScanUIRectView", "alvinluo postTakeShot session: %d, delay: %d", new Object[] { Long.valueOf(paramAnonymousLong), Long.valueOf(0L) });
        ScanUIRectView.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(221848);
            if ((ScanUIRectView.l(ScanUIRectView.this) == paramAnonymousLong) && (ScanUIRectView.l(ScanUIRectView.this) != 0L)) {
              ScanUIRectView.this.PW(this.DNj);
            }
            AppMethodBeat.o(221848);
          }
        });
        AppMethodBeat.o(221446);
      }
      
      public final void a(final long paramAnonymousLong, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(221444);
        Log.d("MicroMsg.ScanUIRectView", "alvinluo onDecodeSuccess %d", new Object[] { Long.valueOf(paramAnonymousLong) });
        if (paramAnonymousBundle.getBoolean("result_is_best_img", false)) {
          ScanUIRectView.this.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(222216);
              if ((paramAnonymousLong == ScanUIRectView.l(ScanUIRectView.this)) && (ScanUIRectView.l(ScanUIRectView.this) != 0L) && (ScanUIRectView.m(ScanUIRectView.this) != null)) {
                ScanUIRectView.m(ScanUIRectView.this).e(ScanUIRectView.l(ScanUIRectView.this), this.val$result);
              }
              AppMethodBeat.o(222216);
            }
          });
        }
        AppMethodBeat.o(221444);
      }
      
      public final void a(final ac paramAnonymousac)
      {
        AppMethodBeat.i(221447);
        ScanUIRectView.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(217934);
            if ((paramAnonymousac != null) && ((ScanUIRectView.r(ScanUIRectView.this) instanceof ScanGoodsMaskView)))
            {
              ScanGoodsMaskView localScanGoodsMaskView = (ScanGoodsMaskView)ScanUIRectView.r(ScanUIRectView.this);
              ac localac = paramAnonymousac;
              kotlin.g.b.p.k(localac, "pointsResult");
              if (localScanGoodsMaskView.Jam)
              {
                Log.i("MicroMsg.ScanGoodsMaskView", "alvinluo addAnimationScanDots isViewDestroy");
                AppMethodBeat.o(217934);
                return;
              }
              ScanPoint[] arrayOfScanPoint = localac.points;
              if (arrayOfScanPoint != null)
              {
                Log.v("MicroMsg.ScanGoodsMaskView", "alvinluo addAnimationScanDots size: %d", new Object[] { Integer.valueOf(localac.pointCount) });
                int j = localac.pointCount;
                int i = 0;
                if (i < j)
                {
                  Object localObject2 = (ScanPoint)e.g(arrayOfScanPoint, i);
                  label149:
                  Float localFloat;
                  if (localObject2 != null)
                  {
                    localObject1 = Integer.valueOf(((ScanPoint)localObject2).getId());
                    if (localObject2 == null) {
                      break label216;
                    }
                    localFloat = Float.valueOf(((ScanPoint)localObject2).getX());
                    label164:
                    if (localObject2 == null) {
                      break label222;
                    }
                  }
                  label216:
                  label222:
                  for (localObject2 = Float.valueOf(((ScanPoint)localObject2).getY());; localObject2 = null)
                  {
                    Log.v("MicroMsg.ScanGoodsMaskView", "alvinluo getPointObjects id: %d, x: %f, y: %f", new Object[] { localObject1, localFloat, localObject2 });
                    i += 1;
                    break;
                    localObject1 = null;
                    break label149;
                    localFloat = null;
                    break label164;
                  }
                }
                Object localObject1 = localScanGoodsMaskView.IVq;
                if (localObject1 == null) {
                  kotlin.g.b.p.bGy("animationDotsView");
                }
                ((ScanAnimationDotsView)localObject1).b(localac);
              }
            }
            AppMethodBeat.o(217934);
          }
        });
        AppMethodBeat.o(221447);
      }
    };
    this.iQJ = new com.tencent.mm.modelgeo.b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(218352);
        Log.i("MicroMsg.ScanUIRectView", "onGetLocation %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (!paramAnonymousBoolean)
        {
          Log.i("MicroMsg.ScanUIRectView", "check permission not passed!");
          if ((!ScanUIRectView.s(ScanUIRectView.this)) && (!com.tencent.mm.modelgeo.d.blr()))
          {
            ScanUIRectView.t(ScanUIRectView.this);
            com.tencent.mm.ui.base.h.a(ScanUIRectView.this.getContext(), ScanUIRectView.this.getContext().getString(l.i.gps_disable_tip), ScanUIRectView.this.getContext().getString(l.i.app_tip), ScanUIRectView.this.getContext().getString(l.i.jump_to_settings), ScanUIRectView.this.getContext().getString(l.i.app_cancel), false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(222610);
                com.tencent.mm.modelgeo.d.cW(ScanUIRectView.this.getContext());
                AppMethodBeat.o(222610);
              }
            }, null);
          }
          AppMethodBeat.o(218352);
          return true;
        }
        if (ScanUIRectView.u(ScanUIRectView.this))
        {
          Log.i("MicroMsg.ScanUIRectView", "ignore, has get lbs!");
          AppMethodBeat.o(218352);
          return false;
        }
        ScanUIRectView.this.dlq();
        ScanUIRectView.v(ScanUIRectView.this);
        n.a(2012, paramAnonymousFloat1, paramAnonymousFloat2, (int)paramAnonymousDouble2);
        if (ScanUIRectView.m(ScanUIRectView.this) != null)
        {
          Bundle localBundle = new Bundle();
          localBundle.putFloat("result_lbs_latitude", paramAnonymousFloat2);
          localBundle.putFloat("result_lbs_longitude", paramAnonymousFloat1);
          localBundle.putInt("result_lbs_accuracy", (int)paramAnonymousDouble2);
          localBundle.putInt("result_lbs_source", paramAnonymousInt);
          ScanUIRectView.m(ScanUIRectView.this).e(ScanUIRectView.l(ScanUIRectView.this), localBundle);
        }
        AppMethodBeat.o(218352);
        return false;
      }
    };
    this.ITm = new IListener() {};
    this.mBn = new GestureDetector(new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(222264);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/scanner/ui/ScanUIRectView$15", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/scanner/ui/ScanUIRectView$15", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(222264);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(161025);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/scanner/ui/ScanUIRectView$15", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
        Log.d("MicroMsg.ScanUIRectView", "double click,pointer:%d,x:%f,y:%f", new Object[] { Integer.valueOf(paramAnonymousMotionEvent.getActionIndex()), Float.valueOf(paramAnonymousMotionEvent.getX(paramAnonymousMotionEvent.getActionIndex())), Float.valueOf(paramAnonymousMotionEvent.getY(paramAnonymousMotionEvent.getActionIndex())) });
        ((com.tencent.scanlib.a.a)ScanUIRectView.A(ScanUIRectView.this)).aAs(5);
        ad.je(ScanUIRectView.B(ScanUIRectView.this), 3);
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/scanner/ui/ScanUIRectView$15", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(161025);
        return true;
      }
      
      public final boolean onFling(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(161026);
        Log.d("MicroMsg.ScanUIRectView", "alvinluo onFling velocityX: %f, velocityY: %f, canScrollSwitchTab: %b, enableScrollSwitchTab: %b, isMultiTouch: %b", new Object[] { Float.valueOf(paramAnonymousFloat1), Float.valueOf(paramAnonymousFloat2), Boolean.valueOf(ScanUIRectView.C(ScanUIRectView.this)), Boolean.valueOf(ScanUIRectView.D(ScanUIRectView.this)), Boolean.valueOf(ScanUIRectView.E(ScanUIRectView.this)) });
        if ((!ScanUIRectView.E(ScanUIRectView.this)) && (ScanUIRectView.D(ScanUIRectView.this)) && (Math.abs(paramAnonymousFloat1) > Math.abs(paramAnonymousFloat2)))
        {
          if ((paramAnonymousFloat1 >= -1200.0F) || (!ScanUIRectView.C(ScanUIRectView.this))) {
            break label168;
          }
          if (ScanUIRectView.F(ScanUIRectView.this) != null) {
            ScanUIRectView.F(ScanUIRectView.this).fEC();
          }
          ScanUIRectView.b(ScanUIRectView.this, false);
        }
        for (;;)
        {
          boolean bool = super.onFling(paramAnonymousMotionEvent1, paramAnonymousMotionEvent2, paramAnonymousFloat1, paramAnonymousFloat2);
          AppMethodBeat.o(161026);
          return bool;
          label168:
          if ((paramAnonymousFloat1 > 1200.0F) && (ScanUIRectView.C(ScanUIRectView.this)))
          {
            if (ScanUIRectView.F(ScanUIRectView.this) != null) {
              ScanUIRectView.F(ScanUIRectView.this).fED();
            }
            ScanUIRectView.b(ScanUIRectView.this, false);
          }
        }
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(222262);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/scanner/ui/ScanUIRectView$15", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aFi());
        super.onLongPress(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/ScanUIRectView$15", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(222262);
      }
      
      public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(222259);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/scanner/ui/ScanUIRectView$15", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aFi());
        boolean bool = super.onSingleTapUp(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/scanner/ui/ScanUIRectView$15", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(222259);
        return bool;
      }
    });
    this.ITn = new b(Looper.getMainLooper());
    AppMethodBeat.o(51947);
  }
  
  private void PX(long paramLong)
  {
    AppMethodBeat.i(161046);
    long l1 = System.currentTimeMillis() - this.lastShotTime;
    if (l1 > ZrE)
    {
      this.ITn.removeMessages(0);
      this.ITn.sendEmptyMessageDelayed(0, paramLong);
      AppMethodBeat.o(161046);
      return;
    }
    long l2 = ZrE;
    this.ITn.removeMessages(0);
    this.ITn.sendEmptyMessageDelayed(0, l2 - l1 + paramLong);
    AppMethodBeat.o(161046);
  }
  
  private void a(Object paramObject, com.tencent.mm.plugin.scanner.view.d paramd)
  {
    AppMethodBeat.i(217146);
    Log.i("MicroMsg.ScanUIRectView", "alvinluo onScanSuccess");
    fEj();
    fEh();
    if (this.ILO != null)
    {
      this.ILO.b(paramObject, paramd);
      this.ILO.fY(this.aND);
    }
    if (this.ILP != null) {
      this.ILP.fEG();
    }
    if ((r.aeb(this.mode)) && (this.ITb != null)) {
      this.ITb.IZj = true;
    }
    AppMethodBeat.o(217146);
  }
  
  private void cn(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(161043);
    if ((this.ZrD.egx()) && (((com.tencent.mm.plugin.scanner.a.a)this.ZrD).fCr())) {
      ScanCameraLightDetector.IYP.P(paramArrayOfByte, ((com.tencent.mm.plugin.scanner.a.a)this.ZrD).ios().x, ((com.tencent.mm.plugin.scanner.a.a)this.ZrD).ios().y);
    }
    switch (this.mode)
    {
    default: 
      Log.i("MicroMsg.ScanUIRectView", "unknown scan mode %d", new Object[] { Integer.valueOf(this.mode) });
      AppMethodBeat.o(161043);
      return;
    case 1: 
    case 4: 
    case 8: 
      co(paramArrayOfByte);
      AppMethodBeat.o(161043);
      return;
    }
    cp(paramArrayOfByte);
    AppMethodBeat.o(161043);
  }
  
  private void co(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(161044);
    Object localObject;
    Rect localRect1;
    if ((this.IIw != 0L) && (this.ZrD.egx()))
    {
      localObject = this.ZrD.ios();
      if (localObject != null)
      {
        localRect1 = getScanCodeRect();
        if ((this.isRetry) && (this.ITc != 1)) {
          break label198;
        }
        Rect localRect2 = ((com.tencent.mm.plugin.scanner.a.a)this.ZrD).G(localRect1);
        if (this.ILO != null)
        {
          this.ILO.setPreviewRect(localRect2);
          this.ILO.setScanRect(localRect1);
          if ((this.ILO instanceof ScanCodeMaskView)) {
            ((ScanCodeMaskView)this.ILO).setNeedRotate(true);
          }
        }
        com.tencent.qbar.h.inM().a(paramArrayOfByte, (Point)localObject, this.ZrD.getCameraRotation(), localRect2);
      }
    }
    for (;;)
    {
      if ((!((com.tencent.scanlib.a.a)this.ZrD).fDZ()) && (com.tencent.qbar.h.inM().IIz > ISX))
      {
        Log.i("MicroMsg.ScanUIRectView", "change to FOCUS_MODE_AUTO");
        this.ZrD.bCY("auto");
        WO(100L);
      }
      AppMethodBeat.o(161044);
      return;
      label198:
      if ((this.isRetry) && (this.ITc == 2))
      {
        localObject = new Rect(0, 0, this.ITi, this.ITj);
        if (this.ILO != null)
        {
          this.ILO.setPreviewRect((Rect)localObject);
          this.ILO.setScanRect(localRect1);
          if ((this.ILO instanceof ScanCodeMaskView)) {
            ((ScanCodeMaskView)this.ILO).setNeedRotate(false);
          }
        }
        com.tencent.qbar.h.inM().a(paramArrayOfByte, new Point(this.ITi, this.ITj), 0, (Rect)localObject);
      }
    }
  }
  
  private void cp(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(161045);
    if (this.IIw != 0L) {
      synchronized (this.ZrD)
      {
        if (this.ZrD.egx())
        {
          Point localPoint = this.ZrD.ios();
          boolean bool = true;
          if ((this.IPe instanceof ScanGoodsRequest)) {
            bool = ((ScanGoodsRequest)this.IPe).IGw;
          }
          com.tencent.mm.plugin.scanner.d.a.fCz().a(paramArrayOfByte, localPoint, this.ZrD.getCameraRotation(), ((com.tencent.mm.plugin.scanner.a.a)this.ZrD).fCt(), bool);
        }
        AppMethodBeat.o(161045);
        return;
      }
    }
    AppMethodBeat.o(161045);
  }
  
  private byte[] fEb()
  {
    AppMethodBeat.i(161042);
    for (;;)
    {
      int i;
      try
      {
        l1 = System.currentTimeMillis();
        k = this.aND.getWidth();
        int m = this.aND.getHeight();
        i = m;
        j = k;
        if (this.ITb == null) {
          break label300;
        }
        i = m;
        j = k;
        if (this.ITb.IZh == 0.0F) {
          break label300;
        }
        j = (int)(this.aND.getWidth() * this.ITb.IZh);
        i = (int)(this.aND.getHeight() * this.ITb.IZh);
      }
      catch (Exception localException)
      {
        long l1;
        Object localObject;
        long l2;
        Log.printErrStackTrace("MicroMsg.ScanUIRectView", localException, "alvinluo generateFrameByTextureView exception", new Object[0]);
        AppMethodBeat.o(161042);
        return null;
      }
      localObject = this.aND.getBitmap(k, j);
      Log.d("MicroMsg.ScanUIRectView", "alvinluo generateFrameByTextureView getBitmap cost: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
      {
        this.ITi = ((Bitmap)localObject).getWidth();
        this.ITj = ((Bitmap)localObject).getHeight();
        Log.d("MicroMsg.ScanUIRectView", "alvinluo generateFrameByTextureView bitmap width: %d, height: %d", new Object[] { Integer.valueOf(this.ITi), Integer.valueOf(this.ITj) });
        l1 = System.currentTimeMillis();
        localObject = com.tencent.mm.plugin.scanner.util.p.getNV21(this.ITi, this.ITj, (Bitmap)localObject);
        l2 = System.currentTimeMillis();
        if (localObject != null)
        {
          i = localObject.length;
          Log.d("MicroMsg.ScanUIRectView", "alvinluo generateFrameByTextureView yuvData: %d, getNV21 cost: %d", new Object[] { Integer.valueOf(i), Long.valueOf(l2 - l1) });
          AppMethodBeat.o(161042);
          return localObject;
        }
        i = -1;
        continue;
      }
      label300:
      int k = j;
      if (j % 2 != 0) {
        k = j - 1;
      }
      int j = i;
      if (i % 2 != 0) {
        j = i - 1;
      }
    }
  }
  
  private void fEc()
  {
    boolean bool3 = true;
    boolean bool2 = true;
    AppMethodBeat.i(51960);
    Log.d("MicroMsg.ScanUIRectView", "alvinluo createScanMaskView mode: %d, bottomHeight: %d", new Object[] { Integer.valueOf(this.mode), Integer.valueOf(this.ISS) });
    Object localObject2;
    label239:
    int i;
    Object localObject3;
    switch (this.mode)
    {
    default: 
      Log.i("MicroMsg.ScanUIRectView", "unknown scan mode %d", new Object[] { Integer.valueOf(this.mode) });
      if ((this.ILO != null) && (this.ILP != null))
      {
        this.ILO.setBottomExtraHeight(this.ISS);
        this.ILO.IRX = ((com.tencent.mm.plugin.scanner.a.a)this.ZrD);
        localObject1 = this.ILO;
        localObject2 = this.ILP.getScanTipsView();
        kotlin.g.b.p.k(localObject2, "tipsView");
        ((BaseScanMaskView)localObject1).IXT = ((TextView)localObject2);
        this.ILO.fEr();
        this.ILP.setBottomExtraHeight(this.ISS);
        this.ILP.setFlashStatus(this.IOH.dic);
        localObject1 = this.ILP;
        if (this.isFirst) {
          break label812;
        }
        bool1 = true;
        ((ScanSharedMaskView)localObject1).setShowTitle(bool1);
        localObject2 = this.ILP;
        i = this.mode;
        Log.i("MicroMsg.ScanSharedMaskView", "alvinluo onViewReady currentTab: %d, hashCode: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(((ScanSharedMaskView)localObject2).hashCode()) });
        ((ScanSharedMaskView)localObject2).IXY = i;
        localObject3 = ((ScanSharedMaskView)localObject2).IXT;
        if (localObject3 == null) {
          kotlin.g.b.p.bGy("scanTips");
        }
        localObject1 = ((ScanSharedMaskView)localObject2).IXT;
        if (localObject1 == null) {
          kotlin.g.b.p.bGy("scanTips");
        }
        localObject1 = ((TextView)localObject1).getLayoutParams();
        if (localObject1 == null) {
          break label817;
        }
        if ((localObject1 instanceof ViewGroup.MarginLayoutParams)) {
          ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin = (com.tencent.mm.ci.a.fromDPToPix(((ScanSharedMaskView)localObject2).getContext(), 120) + ((ScanSharedMaskView)localObject2).IYh);
        }
        label373:
        ((TextView)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localObject3 = ((ScanSharedMaskView)localObject2).IXU;
        if (localObject3 == null) {
          kotlin.g.b.p.bGy("scanToast");
        }
        localObject1 = ((ScanSharedMaskView)localObject2).IXU;
        if (localObject1 == null) {
          kotlin.g.b.p.bGy("scanToast");
        }
        localObject1 = ((TextView)localObject1).getLayoutParams();
        if (localObject1 == null) {
          break label823;
        }
        if ((localObject1 instanceof ViewGroup.MarginLayoutParams)) {
          ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin = (com.tencent.mm.ci.a.fromDPToPix(((ScanSharedMaskView)localObject2).getContext(), 110) + ((ScanSharedMaskView)localObject2).IYh);
        }
        label460:
        ((TextView)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localObject3 = ((ScanSharedMaskView)localObject2).IXW;
        if (localObject3 == null) {
          kotlin.g.b.p.bGy("galleryButton");
        }
        localObject1 = ((ScanSharedMaskView)localObject2).IXW;
        if (localObject1 == null) {
          kotlin.g.b.p.bGy("galleryButton");
        }
        localObject1 = ((View)localObject1).getLayoutParams();
        if (localObject1 == null) {
          break label829;
        }
        if ((localObject1 instanceof ViewGroup.MarginLayoutParams)) {
          ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin = (com.tencent.mm.ci.a.fromDPToPix(((ScanSharedMaskView)localObject2).getContext(), 32) + ((ScanSharedMaskView)localObject2).IYh);
        }
        label547:
        ((View)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject1);
        if (!r.aed(((ScanSharedMaskView)localObject2).IXY)) {
          break label835;
        }
        localObject1 = ((ScanSharedMaskView)localObject2).IOH;
        if (localObject1 == null) {
          kotlin.g.b.p.bGy("flashSwitcher");
        }
        ((ScannerFlashSwitcher)localObject1).setVisibility(8);
        if (((ScanSharedMaskView)localObject2).IYi) {
          break label936;
        }
        if (((ScanSharedMaskView)localObject2).IYg) {
          break label931;
        }
      }
      break;
    }
    label931:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((ScanSharedMaskView)localObject2).xD(bool1);
      localObject1 = ((ScanSharedMaskView)localObject2).IXS;
      if (localObject1 == null) {
        kotlin.g.b.p.bGy("scanTitle");
      }
      ((TextView)localObject1).setVisibility(8);
      ((ScanSharedMaskView)localObject2).IYf = false;
      localObject1 = ((ScanSharedMaskView)localObject2).IXU;
      if (localObject1 == null) {
        kotlin.g.b.p.bGy("scanToast");
      }
      ((TextView)localObject1).setVisibility(8);
      ((ScanSharedMaskView)localObject2).dBp();
      ((ScanSharedMaskView)localObject2).adW(i);
      this.isFirst = false;
      AppMethodBeat.o(51960);
      return;
      fEi();
      this.ILO = new ScanCodeMaskView(getContext());
      addView(this.ILO);
      break;
      this.ILO = new ScanTranslationMaskView(getContext());
      addView(this.ILO);
      break;
      this.ILO = new ScanGoodsMaskView(getContext());
      addView(this.ILO);
      if ((!(this.ILO instanceof ScanGoodsMaskView)) || (!(this.IPe instanceof ScanGoodsRequest))) {
        break;
      }
      ((ScanGoodsMaskView)this.ILO).setScanRequest((ScanGoodsRequest)this.IPe);
      break;
      label812:
      bool1 = false;
      break label239;
      label817:
      localObject1 = null;
      break label373;
      label823:
      localObject1 = null;
      break label460;
      label829:
      localObject1 = null;
      break label547;
      label835:
      localObject3 = ((ScanSharedMaskView)localObject2).IOH;
      if (localObject3 == null) {
        kotlin.g.b.p.bGy("flashSwitcher");
      }
      localObject1 = ((ScanSharedMaskView)localObject2).IOH;
      if (localObject1 == null) {
        kotlin.g.b.p.bGy("flashSwitcher");
      }
      localObject1 = ((ScannerFlashSwitcher)localObject1).getLayoutParams();
      if (localObject1 != null) {
        if ((localObject1 instanceof ViewGroup.MarginLayoutParams)) {
          ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin = (com.tencent.mm.ci.a.fromDPToPix(((ScanSharedMaskView)localObject2).getContext(), 32) + ((ScanSharedMaskView)localObject2).IYh);
        }
      }
      for (;;)
      {
        ((ScannerFlashSwitcher)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject1);
        break;
        localObject1 = null;
      }
    }
    label936:
    ((ScanSharedMaskView)localObject2).xD(false);
    ((ScanSharedMaskView)localObject2).fEE();
    ((ScanSharedMaskView)localObject2).fEF();
    Object localObject1 = ((ScanSharedMaskView)localObject2).IXS;
    if (localObject1 == null) {
      kotlin.g.b.p.bGy("scanTitle");
    }
    ((TextView)localObject1).setAlpha(1.0F);
    localObject1 = ((ScanSharedMaskView)localObject2).IXS;
    if (localObject1 == null) {
      kotlin.g.b.p.bGy("scanTitle");
    }
    if (((TextView)localObject1).getVisibility() != 0) {}
    for (bool1 = bool3;; bool1 = false)
    {
      if (((ScanSharedMaskView)localObject2).IYd == null)
      {
        localObject1 = new m();
        localObject3 = ((ScanSharedMaskView)localObject2).IXS;
        if (localObject3 == null) {
          kotlin.g.b.p.bGy("scanTitle");
        }
        localObject1 = ((m)localObject1).fZ((View)localObject3).fEX().fEY();
        ((m)localObject1).IZK = ((m.b)new ScanSharedMaskView.f((ScanSharedMaskView)localObject2));
        ((ScanSharedMaskView)localObject2).IYd = ((m)localObject1);
      }
      localObject1 = ((ScanSharedMaskView)localObject2).IYd;
      if (localObject1 == null) {
        break;
      }
      ((m)localObject1).xJ(bool1);
      break;
    }
  }
  
  private void fEd()
  {
    AppMethodBeat.i(51962);
    String str = getScanTips();
    this.ILP.setScanTips(str);
    this.ILP.setScanRequest(this.IPe);
    switch (this.mode)
    {
    default: 
      Log.e("MicroMsg.ScanUIRectView", "alvinluo refreshSharedMaskView unknown scan mode %d", new Object[] { Integer.valueOf(this.mode) });
      AppMethodBeat.o(51962);
      return;
    case 1: 
    case 4: 
    case 8: 
      this.ILP.setScanTitle(getResources().getString(l.i.IEP));
      AppMethodBeat.o(51962);
      return;
    case 3: 
      this.ILP.setScanTitle(getResources().getString(l.i.scan_entry_ocr));
      AppMethodBeat.o(51962);
      return;
    }
    this.ILP.setScanTitle(getResources().getString(l.i.IEN));
    AppMethodBeat.o(51962);
  }
  
  private void fEg()
  {
    AppMethodBeat.i(51970);
    if (this.ILO != null)
    {
      final BaseScanMaskView localBaseScanMaskView = this.ILO;
      localBaseScanMaskView.a(new Animator.AnimatorListener()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(170022);
          ScanUIRectView.this.removeView((View)localBaseScanMaskView);
          localBaseScanMaskView.release();
          AppMethodBeat.o(170022);
        }
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(170021);
          ScanUIRectView.this.removeView((View)localBaseScanMaskView);
          localBaseScanMaskView.release();
          AppMethodBeat.o(170021);
        }
        
        public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationStart(Animator paramAnonymousAnimator) {}
      });
    }
    AppMethodBeat.o(51970);
  }
  
  private void fEi()
  {
    AppMethodBeat.i(162394);
    if (com.tencent.qbar.f.inJ())
    {
      Log.i("MicroMsg.ScanUIRectView", "alvinluo updateScanCodeRect visibleResolution: %s", new Object[] { this.wxC });
      if ((this.wxC != null) && (this.wxC.x > 0) && (this.wxC.y > 0))
      {
        this.ISL.setDecorRect(new Rect(0, (int)(this.wxC.y * 1.0F / 19.0F), this.wxC.x, (int)(this.wxC.y * 17.0F / 19.0F)));
        AppMethodBeat.o(162394);
      }
    }
    else
    {
      this.ISL.jp(getResources().getDimensionPixelSize(l.d.scan_code_rect_width), getResources().getDimensionPixelSize(l.d.scan_code_rect_height));
    }
    AppMethodBeat.o(162394);
  }
  
  private void fEj()
  {
    AppMethodBeat.i(160188);
    if (this.ITh != null) {
      removeCallbacks(this.ITh);
    }
    AppMethodBeat.o(160188);
  }
  
  private Rect getScanCodeRect()
  {
    int j = 0;
    AppMethodBeat.i(51975);
    if (com.tencent.qbar.f.inJ())
    {
      localRect1 = getDecorRect();
      AppMethodBeat.o(51975);
      return localRect1;
    }
    Rect localRect1 = getDecorRect();
    Point localPoint = new Point();
    ((Activity)getContext()).getWindowManager().getDefaultDisplay().getSize(localPoint);
    Rect localRect2 = new Rect();
    int i = (int)(localRect1.width() * 0.5F);
    int k = (int)(localRect1.height() * 0.5F);
    localRect1.left -= i / 2;
    int m = localRect1.right;
    localRect2.right = (i / 2 + m);
    localRect1.top -= k / 2;
    localRect1.bottom += k / 2;
    if (localRect2.left < 0)
    {
      i = 0;
      localRect2.left = i;
      if (localRect2.right <= localPoint.x) {
        break label257;
      }
      i = localPoint.x;
      label192:
      localRect2.right = i;
      if (localRect2.top >= 0) {
        break label266;
      }
      i = j;
      label208:
      localRect2.top = i;
      if (localRect2.bottom <= localPoint.y) {
        break label275;
      }
    }
    label257:
    label266:
    label275:
    for (i = localPoint.y;; i = localRect2.bottom)
    {
      localRect2.bottom = i;
      AppMethodBeat.o(51975);
      return localRect2;
      i = localRect2.left;
      break;
      i = localRect2.right;
      break label192;
      i = localRect2.top;
      break label208;
    }
  }
  
  private String getScanTips()
  {
    AppMethodBeat.i(51963);
    if (!this.IOV)
    {
      AppMethodBeat.o(51963);
      return "";
    }
    switch (this.mode)
    {
    default: 
      AppMethodBeat.o(51963);
      return "";
    case 1: 
      str = getResources().getString(l.i.IFp);
      AppMethodBeat.o(51963);
      return str;
    case 8: 
      str = getResources().getString(l.i.IED);
      AppMethodBeat.o(51963);
      return str;
    case 4: 
      str = getResources().getString(l.i.IEE);
      AppMethodBeat.o(51963);
      return str;
    case 3: 
      str = getResources().getString(l.i.scan_translation_capture_tip);
      AppMethodBeat.o(51963);
      return str;
    }
    if (!Util.isNullOrNil(this.ISO))
    {
      str = this.ISO;
      AppMethodBeat.o(51963);
      return str;
    }
    String str = getResources().getString(l.i.IER);
    AppMethodBeat.o(51963);
    return str;
  }
  
  private void xw(boolean paramBoolean)
  {
    AppMethodBeat.i(51974);
    if (this.ILO != null) {
      this.ILO.xw(paramBoolean);
    }
    if (this.ILP != null) {
      this.ILP.xw(paramBoolean);
    }
    if (this.ISM != null) {
      this.ISM.setVisibility(8);
    }
    if (this.ISP != null) {
      this.ISP.fCJ();
    }
    AppMethodBeat.o(51974);
  }
  
  public final void PW(long paramLong)
  {
    AppMethodBeat.i(51957);
    this.ISW = true;
    Log.d("MicroMsg.ScanUIRectView", "alvinluo takeOneShot timeout: %d, isRetry: %b, onPreviewFrameCalled: %b, canReportOnPreviewFrame: %b, hasReport: %b", new Object[] { Long.valueOf(this.mTimeout), Boolean.valueOf(this.isRetry), Boolean.valueOf(this.ITg), Boolean.valueOf(this.ITf), Boolean.valueOf(this.ITe) });
    if (!this.isRetry)
    {
      super.PW(paramLong);
      this.ITd = System.currentTimeMillis();
      if ((!this.ITg) && (this.ITf) && (r.aeb(this.mode)))
      {
        removeCallbacks(this.ITh);
        postDelayed(this.ITh, this.mTimeout);
        AppMethodBeat.o(51957);
      }
    }
    else if ((this.ITb != null) && (this.ITb.aea(this.ITc)))
    {
      if (this.ITc == 1)
      {
        super.PW(paramLong);
        this.ITd = System.currentTimeMillis();
        AppMethodBeat.o(51957);
        return;
      }
      if (this.ITc == 2) {
        PX(paramLong);
      }
    }
    AppMethodBeat.o(51957);
  }
  
  public final void TL()
  {
    AppMethodBeat.i(51956);
    super.TL();
    this.ISY = true;
    this.ISZ = false;
    AppMethodBeat.o(51956);
  }
  
  public final void a(final b.b.a parama)
  {
    AppMethodBeat.i(161041);
    super.a(new b.b.a()
    {
      public final void fEl()
      {
        AppMethodBeat.i(161029);
        ScanUIRectView.h(ScanUIRectView.this);
        if (parama != null) {
          parama.fEl();
        }
        AppMethodBeat.o(161029);
      }
    });
    AppMethodBeat.o(161041);
  }
  
  public final void a(final Object paramObject, final com.tencent.mm.plugin.scanner.view.d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(217144);
    if (paramBoolean)
    {
      com.tencent.e.h.ZvG.n(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(170023);
          ScanUIRectView.a(ScanUIRectView.this, paramObject, paramd);
          AppMethodBeat.o(170023);
        }
      }, 200L);
      AppMethodBeat.o(217144);
      return;
    }
    a(paramObject, paramd);
    AppMethodBeat.o(217144);
  }
  
  public final void b(boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(51965);
    if (this.ILO != null) {
      this.ILO.b(paramBoolean, paramOnCancelListener);
    }
    AppMethodBeat.o(51965);
  }
  
  public final void dlq()
  {
    AppMethodBeat.i(51978);
    if ((this.ILO != null) && ((this.ILO instanceof ScanCodeMaskView))) {
      ((ScanCodeMaskView)this.ILO).dlq();
    }
    AppMethodBeat.o(51978);
  }
  
  public final void fDY()
  {
    AppMethodBeat.i(51948);
    this.ZrD = new com.tencent.mm.plugin.scanner.a.a();
    AppMethodBeat.o(51948);
  }
  
  public final boolean fDZ()
  {
    AppMethodBeat.i(51950);
    if (this.ZrD != null)
    {
      boolean bool = ((com.tencent.scanlib.a.a)this.ZrD).fDZ();
      AppMethodBeat.o(51950);
      return bool;
    }
    AppMethodBeat.o(51950);
    return false;
  }
  
  public final void fEa()
  {
    AppMethodBeat.i(51952);
    Log.i("MicroMsg.ScanUIRectView", "alvinluo stopCurrentSession %d", new Object[] { Long.valueOf(this.IIw) });
    com.tencent.qbar.h.inM().PP(this.IIw);
    com.tencent.mm.plugin.scanner.d.a.fCz().PP(this.IIw);
    this.IIw = 0L;
    AppMethodBeat.o(51952);
  }
  
  public final void fEe()
  {
    AppMethodBeat.i(51967);
    if ((this.ILP != null) && (!this.IOH.dic)) {
      this.ILP.xF(true);
    }
    AppMethodBeat.o(51967);
  }
  
  public final void fEf()
  {
    AppMethodBeat.i(51968);
    if ((this.ILP != null) && (this.IOH.dic)) {
      this.ILP.xF(false);
    }
    AppMethodBeat.o(51968);
  }
  
  public final void fEh()
  {
    AppMethodBeat.i(217151);
    onPause();
    TL();
    AppMethodBeat.o(217151);
  }
  
  public Rect getDecorRect()
  {
    AppMethodBeat.i(51976);
    Rect localRect = this.ISL.getDecorRect();
    AppMethodBeat.o(51976);
    return localRect;
  }
  
  public com.tencent.scanlib.a.f getScanCamera()
  {
    return this.ZrD;
  }
  
  public BaseScanMaskView getScanMaskView()
  {
    return this.ILO;
  }
  
  public ScanSharedMaskView getSharedMaskView()
  {
    return this.ILP;
  }
  
  public TextureView getTextrueView()
  {
    return this.aND;
  }
  
  public final void init()
  {
    AppMethodBeat.i(51959);
    super.init();
    this.ISL = new ScanRectDecorView(getContext());
    if (this.IPp) {
      this.ISO = v.fCW();
    }
    Log.i("MicroMsg.ScanUIRectView", "initScanGoodsTips enable: %b, %s", new Object[] { Boolean.valueOf(this.IPp), this.ISO });
    addView(this.ISL, new FrameLayout.LayoutParams(-1, -1));
    this.ILP = new ScanSharedMaskView(getContext());
    this.IOH = this.ILP.getFlashSwitcherView();
    addView(this.ILP, new FrameLayout.LayoutParams(-1, -1));
    fEd();
    AppMethodBeat.o(51959);
  }
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    AppMethodBeat.i(51972);
    Log.i("MicroMsg.ScanUIRectView", "onAutoFocus %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.ITf = false;
      PW(0L);
    }
    WO(ZrG);
    AppMethodBeat.o(51972);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(51949);
    super.onCreate();
    this.IST = ((int)(com.tencent.mm.ci.a.kr(getContext()) / 4.5F));
    if (r.aeb(this.mode)) {
      com.tencent.qbar.h.inM().init(getContext());
    }
    com.tencent.qbar.h.inM().ZmZ = new al();
    setOnTouchListener(new View.OnTouchListener()
    {
      private float ITv;
      private float ITw = 400.0F;
      private boolean ITx = false;
      
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(161027);
        int i = paramAnonymousMotionEvent.getActionMasked();
        int j = paramAnonymousMotionEvent.getActionIndex();
        Log.d("MicroMsg.ScanUIRectView", "pointIndex:%d, action: %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
        switch (i)
        {
        }
        for (;;)
        {
          paramAnonymousView = ScanUIRectView.L(ScanUIRectView.this);
          com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().bm(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, locala.aFh(), "com/tencent/mm/plugin/scanner/ui/ScanUIRectView$16", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousView.onTouchEvent((MotionEvent)locala.sf(0)), "com/tencent/mm/plugin/scanner/ui/ScanUIRectView$16", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
          if (paramAnonymousMotionEvent.getAction() == 1) {
            ScanUIRectView.c(ScanUIRectView.this, false);
          }
          AppMethodBeat.o(161027);
          return true;
          Log.d("MicroMsg.ScanUIRectView", "first down,pointer:%d,x:%f,y:%f", new Object[] { Integer.valueOf(j), Float.valueOf(paramAnonymousMotionEvent.getX()), Float.valueOf(paramAnonymousMotionEvent.getY()) });
          ScanUIRectView.a(ScanUIRectView.this, paramAnonymousMotionEvent.getRawX());
          ScanUIRectView.b(ScanUIRectView.this, true);
          this.ITx = false;
          continue;
          Log.d("MicroMsg.ScanUIRectView", "down,pointer:%d,x:%f,y:%f", new Object[] { Integer.valueOf(j), Float.valueOf(paramAnonymousMotionEvent.getX(j)), Float.valueOf(paramAnonymousMotionEvent.getY(j)) });
          if (paramAnonymousMotionEvent.getPointerCount() == 2)
          {
            this.ITv = ((float)(Math.pow(paramAnonymousMotionEvent.getX(0) - paramAnonymousMotionEvent.getX(1), 2.0D) + Math.pow(paramAnonymousMotionEvent.getY(0) - paramAnonymousMotionEvent.getY(1), 2.0D)));
            ScanUIRectView.c(ScanUIRectView.this, true);
          }
          this.ITx = false;
          continue;
          Log.d("MicroMsg.ScanUIRectView", "last up,pointer:%d,x:%f,y:%f", new Object[] { Integer.valueOf(j), Float.valueOf(paramAnonymousMotionEvent.getX()), Float.valueOf(paramAnonymousMotionEvent.getY()) });
          if (paramAnonymousMotionEvent.getPointerCount() == 2)
          {
            this.ITv = ((float)(Math.pow(paramAnonymousMotionEvent.getX(0) - paramAnonymousMotionEvent.getX(1), 2.0D) + Math.pow(paramAnonymousMotionEvent.getY(0) - paramAnonymousMotionEvent.getY(1), 2.0D)));
            continue;
            Log.d("MicroMsg.ScanUIRectView", "up,pointer:%d,x:%f,y:%f", new Object[] { Integer.valueOf(j), Float.valueOf(paramAnonymousMotionEvent.getX(j)), Float.valueOf(paramAnonymousMotionEvent.getY(j)) });
            if (paramAnonymousMotionEvent.getPointerCount() == 2)
            {
              this.ITv = ((float)(Math.pow(paramAnonymousMotionEvent.getX(0) - paramAnonymousMotionEvent.getX(1), 2.0D) + Math.pow(paramAnonymousMotionEvent.getY(0) - paramAnonymousMotionEvent.getY(1), 2.0D)));
              if (this.ITx)
              {
                this.ITx = false;
                ad.je(ScanUIRectView.B(ScanUIRectView.this), 4);
                continue;
                float f;
                if (paramAnonymousMotionEvent.getPointerCount() == 2)
                {
                  Log.d("MicroMsg.ScanUIRectView", "move,pointer:0,x:%f,y:%f", new Object[] { Float.valueOf(paramAnonymousMotionEvent.getX(0)), Float.valueOf(paramAnonymousMotionEvent.getY(0)) });
                  Log.d("MicroMsg.ScanUIRectView", "move,pointer:1,x:%f,y:%f", new Object[] { Float.valueOf(paramAnonymousMotionEvent.getX(1)), Float.valueOf(paramAnonymousMotionEvent.getY(1)) });
                  f = (float)(Math.pow(paramAnonymousMotionEvent.getX(0) - paramAnonymousMotionEvent.getX(1), 2.0D) + Math.pow(paramAnonymousMotionEvent.getY(0) - paramAnonymousMotionEvent.getY(1), 2.0D));
                  Log.d("MicroMsg.ScanUIRectView", "distance:%f,lastDistance:%f,min move:%f", new Object[] { Float.valueOf(f), Float.valueOf(this.ITv), Float.valueOf(this.ITw) });
                  if (Math.abs(f - this.ITv) > this.ITw)
                  {
                    if (ScanUIRectView.n(ScanUIRectView.this)) {
                      ScanUIRectView.G(ScanUIRectView.this);
                    }
                    if (f - this.ITv > 0.0F) {
                      ((com.tencent.scanlib.a.a)ScanUIRectView.H(ScanUIRectView.this)).aAs(2);
                    }
                    for (this.ITx = true;; this.ITx = true)
                    {
                      this.ITv = f;
                      break;
                      ((com.tencent.scanlib.a.a)ScanUIRectView.I(ScanUIRectView.this)).aAs(3);
                    }
                  }
                }
                else if ((paramAnonymousMotionEvent.getPointerCount() == 1) && (ScanUIRectView.D(ScanUIRectView.this)) && (!ScanUIRectView.E(ScanUIRectView.this)))
                {
                  f = paramAnonymousMotionEvent.getRawX() - ScanUIRectView.J(ScanUIRectView.this);
                  Log.v("MicroMsg.ScanUIRectView", "alvinluo onTouchEvent offsetX: %f, canScrollSwitchTab: %b", new Object[] { Float.valueOf(f), Boolean.valueOf(ScanUIRectView.C(ScanUIRectView.this)) });
                  if ((f >= ScanUIRectView.K(ScanUIRectView.this)) && (ScanUIRectView.C(ScanUIRectView.this)))
                  {
                    if (ScanUIRectView.F(ScanUIRectView.this) != null) {
                      ScanUIRectView.F(ScanUIRectView.this).fED();
                    }
                    ScanUIRectView.b(ScanUIRectView.this, false);
                  }
                  else if ((f <= -ScanUIRectView.K(ScanUIRectView.this)) && (ScanUIRectView.C(ScanUIRectView.this)))
                  {
                    if (ScanUIRectView.F(ScanUIRectView.this) != null) {
                      ScanUIRectView.F(ScanUIRectView.this).fEC();
                    }
                    ScanUIRectView.b(ScanUIRectView.this, false);
                  }
                }
              }
            }
          }
        }
      }
    });
    EventCenter.instance.addListener(this.ITm);
    if (this.ITb != null) {
      this.ITb.zUF = System.currentTimeMillis();
    }
    AppMethodBeat.o(51949);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(51955);
    super.onDestroy();
    Log.d("MicroMsg.ScanUIRectView", "alvinluo releaseView");
    if (this.ILO != null) {
      this.ILO.release();
    }
    if (this.ILP != null)
    {
      localObject = this.ILP;
      Log.d("MicroMsg.ScanSharedMaskView", "alvinluo release hashCode: %d", new Object[] { Integer.valueOf(((ScanSharedMaskView)localObject).hashCode()) });
      ((ScanSharedMaskView)localObject).fEE();
      ((ScanSharedMaskView)localObject).fEF();
    }
    com.tencent.qbar.h.inM().release();
    Object localObject = com.tencent.mm.plugin.scanner.d.a.fCz();
    Log.i("MicroMsg.AiScanImageDecodeQueueNew", "alvinluo release");
    v.a(new a.3((com.tencent.mm.plugin.scanner.d.a)localObject));
    EventCenter.instance.removeListener(this.ITm);
    removeCallbacks(this.ITh);
    this.ITh = null;
    if (this.ITb != null)
    {
      localObject = this.ITb;
      ((com.tencent.mm.plugin.scanner.util.h)localObject).IZi = System.currentTimeMillis();
      ((com.tencent.mm.plugin.scanner.util.h)localObject).fOa = (((com.tencent.mm.plugin.scanner.util.h)localObject).IZi - ((com.tencent.mm.plugin.scanner.util.h)localObject).zUF);
      Log.i("MicroMsg.ScanRetryManager", "alvinluo exitScanUI stayTime: %d, isUpdated: %b, onPreviewFrameCalled: %b, isRetry: %b", new Object[] { Long.valueOf(((com.tencent.mm.plugin.scanner.util.h)localObject).fOa), Boolean.valueOf(((com.tencent.mm.plugin.scanner.util.h)localObject).IZd), Boolean.valueOf(((com.tencent.mm.plugin.scanner.util.h)localObject).ITg), Boolean.valueOf(((com.tencent.mm.plugin.scanner.util.h)localObject).isRetry) });
      ad.a(((com.tencent.mm.plugin.scanner.util.h)localObject).IZe, ((com.tencent.mm.plugin.scanner.util.h)localObject).isRetry, ((com.tencent.mm.plugin.scanner.util.h)localObject).ITg, ((com.tencent.mm.plugin.scanner.util.h)localObject).fOa);
      ad.l(((com.tencent.mm.plugin.scanner.util.h)localObject).IZe, ((com.tencent.mm.plugin.scanner.util.h)localObject).isRetry, ((com.tencent.mm.plugin.scanner.util.h)localObject).IZj);
      if (!((com.tencent.mm.plugin.scanner.util.h)localObject).IZd) {
        break label292;
      }
      ((com.tencent.mm.plugin.scanner.util.h)localObject).PY(((com.tencent.mm.plugin.scanner.util.h)localObject).mTimeout);
    }
    for (;;)
    {
      if ((r.aeb(this.mode)) && (!this.ISW)) {
        ad.fDh();
      }
      AppMethodBeat.o(51955);
      return;
      label292:
      if (!((com.tencent.mm.plugin.scanner.util.h)localObject).IZd)
      {
        ((com.tencent.mm.plugin.scanner.util.h)localObject).mTimeout = ((com.tencent.mm.plugin.scanner.util.h)localObject).IZa;
        ((com.tencent.mm.plugin.scanner.util.h)localObject).PY(((com.tencent.mm.plugin.scanner.util.h)localObject).mTimeout);
        Log.i("MicroMsg.ScanRetryManager", "alvinluo checkAndResetTimeout timeout not updated and reset to %d", new Object[] { Long.valueOf(((com.tencent.mm.plugin.scanner.util.h)localObject).mTimeout) });
      }
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(51953);
    super.onPause();
    Log.i("MicroMsg.ScanUIRectView", "alvinluo onPause");
    fEj();
    if (this.ILO != null) {
      this.ILO.onPause();
    }
    fEa();
    if (this.lEL != null) {
      this.lEL.b(this.iQJ);
    }
    AppMethodBeat.o(51953);
  }
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    AppMethodBeat.i(51973);
    super.onPreviewFrame(paramArrayOfByte, paramCamera);
    this.ITg = true;
    boolean bool;
    int i;
    if (paramArrayOfByte == null)
    {
      bool = true;
      Log.d("MicroMsg.ScanUIRectView", "onPreviewFrame null data: %b, isPreviewPaused: %b, canResumePreview: %b", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(this.ISY), Boolean.valueOf(this.ISZ) });
      if (this.ITc == 2) {
        if (this.ITb != null)
        {
          paramCamera = this.ITb;
          i = this.ITc;
          Log.i("MicroMsg.ScanRetryManager", "alvinluo cancelRetryType: %d", new Object[] { Integer.valueOf(i) });
          if (i != 1) {
            break label260;
          }
          paramCamera.IZf = false;
        }
      }
    }
    for (;;)
    {
      this.isRetry = false;
      removeCallbacks(this.ITh);
      if (this.ITb != null)
      {
        paramCamera = this.ITb;
        long l1 = System.currentTimeMillis();
        long l2 = this.ITd;
        if (!paramCamera.IZd)
        {
          paramCamera.IZd = true;
          l1 = ((float)(l1 - l2) * paramCamera.IZc);
          paramCamera.mTimeout = Math.max(paramCamera.IZb, Math.min(paramCamera.IZa, l1));
        }
        this.ITb.ITg = true;
      }
      if ((!this.ISY) || (!this.ISZ)) {
        break label273;
      }
      this.ISY = false;
      this.ISZ = false;
      xv(false);
      PW(100L);
      AppMethodBeat.o(51973);
      return;
      bool = false;
      break;
      label260:
      if (i == 2) {
        paramCamera.IZg = false;
      }
    }
    label273:
    if (this.ITa)
    {
      Log.w("MicroMsg.ScanUIRectView", "alvinluo onPreviewFrame ignorePreviewFrame");
      AppMethodBeat.o(51973);
      return;
    }
    if (paramArrayOfByte == null)
    {
      Log.w("MicroMsg.ScanUIRectView", "alvinluo onPreviewFrame data is null");
      PW(0L);
      ad.fDg();
      AppMethodBeat.o(51973);
      return;
    }
    cn(paramArrayOfByte);
    AppMethodBeat.o(51973);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(51951);
    super.onResume();
    if (!this.ZrD.isOpen())
    {
      Log.i("MicroMsg.ScanUIRectView", "alvinluo onResume openCamera");
      a(null);
      Log.i("MicroMsg.ScanUIRectView", "onResume %s", new Object[] { Util.getStack() });
      this.IIw = System.currentTimeMillis();
      if (!r.aeb(this.mode)) {
        break label244;
      }
      com.tencent.qbar.h.inM().a(this.IIw, this.ITk);
    }
    for (;;)
    {
      this.ISU = false;
      if (this.ILO != null) {
        this.ILO.onResume();
      }
      MMHandlerThread.postToMainThreadDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(51923);
          if ((ScanUIRectView.f(ScanUIRectView.this) != null) && (ScanUIRectView.f(ScanUIRectView.this).IGm))
          {
            AppMethodBeat.o(51923);
            return;
          }
          ScanCameraLightDetector.IYP.start(((com.tencent.mm.plugin.scanner.a.a)ScanUIRectView.g(ScanUIRectView.this)).iow());
          AppMethodBeat.o(51923);
        }
      }, 300L);
      this.ISZ = true;
      AppMethodBeat.o(51951);
      return;
      if (!this.ZrD.egx())
      {
        Log.i("MicroMsg.ScanUIRectView", "alvinluo onResume startPreview");
        ((com.tencent.mm.plugin.scanner.a.a)this.ZrD).fCp();
        a(new b.d.a()
        {
          public final void fEk()
          {
            AppMethodBeat.i(170017);
            ScanUIRectView.this.PW(0L);
            AppMethodBeat.o(170017);
          }
        });
        Log.i("MicroMsg.ScanUIRectView", "focus mode %s", new Object[] { this.ZrD.iow() });
        break;
      }
      Log.i("MicroMsg.ScanUIRectView", "alvinluo onResume camera is previewing");
      Log.i("MicroMsg.ScanUIRectView", "focus mode %s", new Object[] { this.ZrD.iow() });
      PW(0L);
      break;
      label244:
      if (this.mode == 12)
      {
        Log.i("MicroMsg.ScanUIRectView", "alvinluo onResume currentNetworkAvailable: %b", new Object[] { Boolean.valueOf(this.IOW) });
        if (this.IOW)
        {
          com.tencent.mm.plugin.scanner.d.a locala = com.tencent.mm.plugin.scanner.d.a.fCz();
          long l = this.IIw;
          com.tencent.mm.plugin.scanner.d.a.a locala1 = this.ITl;
          synchronized (locala.Brg)
          {
            locala.IIw = l;
            locala.IIN = locala1;
            synchronized (locala.IIM)
            {
              if (locala.jvb) {
                v.reset();
              }
            }
          }
        }
        com.tencent.mm.plugin.scanner.d.a.fCz().PP(this.IIw);
      }
    }
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(51954);
    super.onStop();
    aYA();
    ScanCameraLightDetector.IYP.stop();
    AppMethodBeat.o(51954);
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(162395);
    super.onSurfaceTextureAvailable(paramSurfaceTexture, paramInt1, paramInt2);
    if ((this.wxC == null) || (paramInt1 != this.wxC.x) || (paramInt2 != this.wxC.y))
    {
      if (this.wxC == null) {
        this.wxC = new Point(paramInt1, paramInt2);
      }
      if (r.aeb(this.mode)) {
        fEi();
      }
    }
    AppMethodBeat.o(162395);
  }
  
  public final void refreshView()
  {
    AppMethodBeat.i(51961);
    this.ISL.setVisibility(8);
    fEd();
    fEg();
    fEc();
    AppMethodBeat.o(51961);
  }
  
  public void setActivity(Activity paramActivity)
  {
    this.activity = paramActivity;
  }
  
  public void setBlackInterval(int paramInt)
  {
    AppMethodBeat.i(170024);
    com.tencent.qbar.h localh = com.tencent.qbar.h.inM();
    synchronized (localh.oMJ)
    {
      if (localh.oMJ.hasInited()) {
        localh.oMJ.setBlackInterval(paramInt);
      }
      AppMethodBeat.o(170024);
      return;
    }
  }
  
  public void setBottomExtraHeight(int paramInt)
  {
    this.ISS = paramInt;
  }
  
  public void setDecodeSuccessFrameData(ScanDecodeFrameData paramScanDecodeFrameData)
  {
    AppMethodBeat.i(170026);
    if (this.ILO != null) {
      this.ILO.setDecodeSuccessFrameData(paramScanDecodeFrameData);
    }
    AppMethodBeat.o(170026);
  }
  
  public void setDecorRect(Rect paramRect)
  {
    AppMethodBeat.i(51977);
    this.ISL.setDecorRect(paramRect);
    AppMethodBeat.o(51977);
  }
  
  public void setEnableScanGoodsDynamicWording(boolean paramBoolean)
  {
    this.IPp = paramBoolean;
  }
  
  public void setEnableScrollSwitchTab(boolean paramBoolean)
  {
    AppMethodBeat.i(51958);
    Log.i("MicroMsg.ScanUIRectView", "alvinluo setEnableScrollSwitchTab: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.ISQ = paramBoolean;
    AppMethodBeat.o(51958);
  }
  
  public void setFlashStatus(boolean paramBoolean)
  {
    AppMethodBeat.i(51966);
    if (this.ILP != null) {
      this.ILP.setFlashStatus(paramBoolean);
    }
    AppMethodBeat.o(51966);
  }
  
  public void setIgnorePreviewFrame(boolean paramBoolean)
  {
    AppMethodBeat.i(217138);
    Log.d("MicroMsg.ScanUIRectView", "alvinluo setIgnorePreviewFrame %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.ITa = paramBoolean;
    AppMethodBeat.o(217138);
  }
  
  public void setMyQrCodeVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(217131);
    if ((this.ILO instanceof ScanCodeMaskView)) {
      ((ScanCodeMaskView)this.ILO).setMyQrCodeButtonVisible(paramBoolean);
    }
    AppMethodBeat.o(217131);
  }
  
  public void setNetworkAvailable(boolean paramBoolean)
  {
    this.IOW = paramBoolean;
  }
  
  public void setScanCallback(a parama)
  {
    this.ISN = parama;
  }
  
  public void setScanCodeReaders(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(51979);
    com.tencent.qbar.h.inM().R(paramArrayOfInt);
    AppMethodBeat.o(51979);
  }
  
  public void setScanMode(int paramInt)
  {
    this.mode = paramInt;
  }
  
  public void setScanRequest(BaseScanRequest paramBaseScanRequest)
  {
    this.IPe = paramBaseScanRequest;
  }
  
  public void setScanSource(int paramInt)
  {
    AppMethodBeat.i(51964);
    if (this.ILO != null) {
      this.ILO.setScanSource(paramInt);
    }
    AppMethodBeat.o(51964);
  }
  
  public void setScrollTabController(com.tencent.mm.plugin.scanner.ui.widget.b paramb)
  {
    this.ION = paramb;
  }
  
  public void setShowScanTips(boolean paramBoolean)
  {
    this.IOV = paramBoolean;
  }
  
  public void setSuccessMarkClickListener(ae paramae)
  {
    AppMethodBeat.i(170025);
    if ((this.ILO instanceof ScanCodeMaskView)) {
      ((ScanCodeMaskView)this.ILO).setSuccessMarkClickListener(paramae);
    }
    AppMethodBeat.o(170025);
  }
  
  public final void xu(boolean paramBoolean)
  {
    boolean bool2 = true;
    AppMethodBeat.i(51969);
    Log.v("MicroMsg.ScanUIRectView", "alvinluo onShowNoDataView show: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    Object localObject;
    boolean bool1;
    if (this.ILP != null)
    {
      localObject = this.ILP;
      if (!paramBoolean)
      {
        bool1 = true;
        ((ScanSharedMaskView)localObject).xG(bool1);
      }
    }
    else if (this.ILO != null)
    {
      localObject = this.ILO;
      if (paramBoolean) {
        break label90;
      }
    }
    label90:
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      ((BaseScanMaskView)localObject).xG(paramBoolean);
      AppMethodBeat.o(51969);
      return;
      bool1 = false;
      break;
    }
  }
  
  public final void xv(final boolean paramBoolean)
  {
    AppMethodBeat.i(170027);
    ad.adw(this.mode);
    if (this.mode == 12) {
      ad.aR(1, System.currentTimeMillis());
    }
    if (Looper.getMainLooper().getThread() == Thread.currentThread())
    {
      xw(paramBoolean);
      AppMethodBeat.o(170027);
      return;
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(218468);
        ScanUIRectView.a(ScanUIRectView.this, paramBoolean);
        AppMethodBeat.o(218468);
      }
    });
    AppMethodBeat.o(170027);
  }
  
  public static abstract interface a
  {
    public abstract void e(long paramLong, Bundle paramBundle);
  }
  
  final class b
    extends Handler
  {
    b(Looper paramLooper)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(161040);
      ScanUIRectView.a(ScanUIRectView.this, System.currentTimeMillis());
      ScanUIRectView.M(ScanUIRectView.this);
      AppMethodBeat.o(161040);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ScanUIRectView
 * JD-Core Version:    0.7.0.1
 */
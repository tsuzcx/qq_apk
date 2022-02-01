package com.tencent.mm.plugin.scanner.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.TimeInterpolator;
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
import android.view.ViewPropertyAnimator;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.sm;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.plugin.scanner.api.BaseScanRequest;
import com.tencent.mm.plugin.scanner.api.ScanGoodsRequest;
import com.tencent.mm.plugin.scanner.c.a.3;
import com.tencent.mm.plugin.scanner.model.ScanPoint;
import com.tencent.mm.plugin.scanner.model.ac;
import com.tencent.mm.plugin.scanner.model.ad;
import com.tencent.mm.plugin.scanner.model.ak;
import com.tencent.mm.plugin.scanner.model.v;
import com.tencent.mm.plugin.scanner.model.w;
import com.tencent.mm.plugin.scanner.ui.scangoods.widget.ScanAnimationDotsView;
import com.tencent.mm.plugin.scanner.ui.scangoods.widget.ScanGoodsMaskView;
import com.tencent.mm.plugin.scanner.ui.widget.ScanCodeMaskView;
import com.tencent.mm.plugin.scanner.ui.widget.ScanDebugView;
import com.tencent.mm.plugin.scanner.ui.widget.ScanSharedMaskView;
import com.tencent.mm.plugin.scanner.util.ScanCameraLightDetector;
import com.tencent.mm.plugin.scanner.util.l;
import com.tencent.mm.plugin.scanner.view.BaseScanMaskView;
import com.tencent.mm.plugin.scanner.view.ScanRectDecorView;
import com.tencent.mm.plugin.scanner.view.ScanTranslationMaskView;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.qbar.QbarNative.QBarPoint;
import com.tencent.qbar.ScanDecodeFrameData;
import com.tencent.qbar.WxQBarPoint;
import com.tencent.qbar.WxQBarResult;
import com.tencent.qbar.WxQbarNative.QBarReportMsg;
import com.tencent.qbar.h.c;
import com.tencent.scanlib.a.b.b.a;
import com.tencent.scanlib.a.b.c.a;
import com.tencent.scanlib.a.b.d.a;
import com.tencent.scanlib.ui.ScanView;
import d.a.e;
import d.g.b.p;
import java.util.ArrayList;
import java.util.List;

public class ScanUIRectView
  extends ScanView
{
  public static final int yJI;
  private Activity activity;
  private com.tencent.mm.modelgeo.b.a fHp;
  private d hTg;
  private GestureDetector iNw;
  private boolean isFirst;
  private boolean isRetry;
  private long mTimeout;
  int mode;
  private Point rqj;
  private boolean ubz;
  private boolean vsk;
  private long yBt;
  BaseScanMaskView yDN;
  private ScanSharedMaskView yDO;
  private boolean yFG;
  boolean yFH;
  private BaseScanRequest yFP;
  private boolean yFZ;
  private ScannerFlashSwitcher yFp;
  private com.tencent.mm.plugin.scanner.ui.widget.b yFy;
  private String yJA;
  private boolean yJB;
  private boolean yJC;
  private int yJD;
  private int yJE;
  private boolean yJF;
  private boolean yJG;
  private boolean yJH;
  private boolean yJJ;
  private boolean yJK;
  private com.tencent.mm.plugin.scanner.util.g yJL;
  private int yJM;
  private long yJN;
  private boolean yJO;
  private boolean yJP;
  private boolean yJQ;
  private Runnable yJR;
  private int yJS;
  private int yJT;
  private h.c yJU;
  private com.tencent.mm.plugin.scanner.c.a.a yJV;
  private com.tencent.mm.sdk.b.c<sm> yJW;
  private long yJX;
  private b yJY;
  private ScanRectDecorView yJx;
  ScanDebugView yJy;
  private a yJz;
  private float yzV;
  
  static
  {
    AppMethodBeat.i(51980);
    yJI = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qMU, 50);
    AppMethodBeat.o(51980);
  }
  
  public ScanUIRectView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(51945);
    this.mode = 1;
    this.yFG = true;
    this.yFH = false;
    this.yJB = true;
    this.yJC = false;
    this.yJD = 0;
    this.yJE = 120;
    this.ubz = false;
    this.rqj = null;
    this.yJG = true;
    this.yJH = false;
    this.yFZ = false;
    this.yJJ = false;
    this.yJK = false;
    this.isFirst = true;
    this.yJL = new com.tencent.mm.plugin.scanner.util.g();
    this.yJM = 0;
    this.yJN = 0L;
    this.mTimeout = this.yJL.mTimeout;
    this.yJO = false;
    this.yJP = true;
    this.yJQ = false;
    this.isRetry = false;
    this.yJR = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(51916);
        if ((ScanUIRectView.a(ScanUIRectView.this)) && (!ScanUIRectView.b(ScanUIRectView.this)))
        {
          ScanUIRectView.c(ScanUIRectView.this);
          ScanUIRectView.d(ScanUIRectView.this);
          ad.dOD();
          ScanUIRectView.e(ScanUIRectView.this);
        }
        AppMethodBeat.o(51916);
      }
    };
    this.yJS = 0;
    this.yJT = 0;
    this.yJU = new h.c()
    {
      public final void a(final long paramAnonymousLong, List<com.tencent.qbar.a.a> paramAnonymousList, final List<QbarNative.QBarPoint> paramAnonymousList1, final List<WxQbarNative.QBarReportMsg> paramAnonymousList2, final Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(189505);
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.ScanUIRectView", String.format("scan code after decode %d", new Object[] { Long.valueOf(paramAnonymousLong) }));
        if ((paramAnonymousList != null) && (!paramAnonymousList.isEmpty())) {
          ScanUIRectView.this.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(161010);
              ArrayList localArrayList;
              int j;
              int i;
              Object localObject1;
              if ((ScanUIRectView.l(ScanUIRectView.this) == paramAnonymousLong) && (paramAnonymousLong != 0L))
              {
                ScanUIRectView.this.dPq();
                localArrayList = new ArrayList();
                if ((paramAnonymousList2 != null) && (!paramAnonymousList2.isEmpty()))
                {
                  com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ScanUIRectView", "alvinluo onDecodeSuccess result size: %d", new Object[] { Integer.valueOf(paramAnonymousList2.size()) });
                  j = 0;
                  i = 0;
                  if (j < paramAnonymousList2.size())
                  {
                    localObject1 = (com.tencent.qbar.a.a)paramAnonymousList2.get(j);
                    localObject1 = new WxQBarResult(((com.tencent.qbar.a.a)localObject1).typeID, ((com.tencent.qbar.a.a)localObject1).typeName, ((com.tencent.qbar.a.a)localObject1).data, ((com.tencent.qbar.a.a)localObject1).rawData, ((com.tencent.qbar.a.a)localObject1).charset, ((com.tencent.qbar.a.a)localObject1).priorityLevel);
                    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ScanUIRectView", "alvinluo onDecodeSuccess result index: %d, format: %d, content:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(((WxQBarResult)localObject1).typeID), ((WxQBarResult)localObject1).data });
                    if ((paramAnonymousList1 != null) && (paramAnonymousList1.size() >= j + 1))
                    {
                      localObject2 = (WxQbarNative.QBarReportMsg)paramAnonymousList1.get(j);
                      if (localObject2 != null) {
                        ((WxQBarResult)localObject1).Mhm = ((WxQbarNative.QBarReportMsg)localObject2).qrcodeVersion;
                      }
                    }
                    if ((paramAnonymousBundle == null) || (paramAnonymousBundle.size() < j + 1)) {
                      break label426;
                    }
                    Object localObject2 = (QbarNative.QBarPoint)paramAnonymousBundle.get(j);
                    if (localObject2 == null) {
                      break label426;
                    }
                    ((WxQBarResult)localObject1).MhO = new WxQBarPoint((QbarNative.QBarPoint)localObject2);
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
                if (this.yKb != null) {
                  ((Bundle)localObject1).putAll(this.yKb);
                }
                ScanUIRectView.this.cyf();
                if (ScanUIRectView.m(ScanUIRectView.this) != null) {
                  ScanUIRectView.m(ScanUIRectView.this).e(ScanUIRectView.l(ScanUIRectView.this), (Bundle)localObject1);
                }
                AppMethodBeat.o(161010);
                return;
              }
            }
          });
        }
        AppMethodBeat.o(189505);
      }
      
      public final void af(final long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(170011);
        ScanUIRectView.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(161009);
            if ((paramAnonymousLong1 == ScanUIRectView.l(ScanUIRectView.this)) && (paramAnonymousLong1 != 0L)) {
              ScanUIRectView.this.zy(this.uUG);
            }
            AppMethodBeat.o(161009);
          }
        });
        AppMethodBeat.o(170011);
      }
      
      public final void b(final long paramAnonymousLong, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(170013);
        ScanUIRectView.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(170010);
            if ((paramAnonymousLong == ScanUIRectView.l(ScanUIRectView.this)) && (paramAnonymousLong != 0L) && (this.val$param.containsKey("param_zoom_ratio")))
            {
              float f = this.val$param.getFloat("param_zoom_ratio", 0.0F);
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ScanUIRectView", "zoom to scale %f", new Object[] { Float.valueOf(f) });
              if ((f > 0.0F) && (ScanUIRectView.n(ScanUIRectView.this)) && (ScanUIRectView.o(ScanUIRectView.this).cOB()))
              {
                int i = (int)(((com.tencent.scanlib.a.a)ScanUIRectView.p(ScanUIRectView.this)).fYM() * f);
                ((com.tencent.scanlib.a.a)ScanUIRectView.q(ScanUIRectView.this)).ahr(i);
                com.tencent.qbar.c localc = com.tencent.qbar.c.Mhd;
                localc.Mhr += 1;
                localc.Mhs *= f;
                localc.Mht = (System.currentTimeMillis() - localc.yEl);
                com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.QBarEngineReporter", "alvinluo zoom %d, zoomFactor: %s, totalZoomFactor: %s, lastZoomCostTime: %d", new Object[] { Integer.valueOf(localc.Mhr), Float.valueOf(f), Float.valueOf(localc.Mhs), Long.valueOf(localc.Mht) });
              }
            }
            AppMethodBeat.o(170010);
          }
        });
        AppMethodBeat.o(170013);
      }
    };
    this.yJV = new com.tencent.mm.plugin.scanner.c.a.a()
    {
      public final void a(final long paramAnonymousLong, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(161016);
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.ScanUIRectView", "alvinluo onDecodeSuccess %d", new Object[] { Long.valueOf(paramAnonymousLong) });
        if (paramAnonymousBundle.getBoolean("result_is_best_img", false)) {
          ScanUIRectView.this.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(161013);
              if ((paramAnonymousLong == ScanUIRectView.l(ScanUIRectView.this)) && (ScanUIRectView.l(ScanUIRectView.this) != 0L) && (ScanUIRectView.m(ScanUIRectView.this) != null)) {
                ScanUIRectView.m(ScanUIRectView.this).e(ScanUIRectView.l(ScanUIRectView.this), this.val$result);
              }
              AppMethodBeat.o(161013);
            }
          });
        }
        AppMethodBeat.o(161016);
      }
      
      public final void a(final ac paramAnonymousac)
      {
        AppMethodBeat.i(161018);
        ScanUIRectView.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(161015);
            if ((paramAnonymousac != null) && ((ScanUIRectView.r(ScanUIRectView.this) instanceof ScanGoodsMaskView)))
            {
              ScanGoodsMaskView localScanGoodsMaskView = (ScanGoodsMaskView)ScanUIRectView.r(ScanUIRectView.this);
              ac localac = paramAnonymousac;
              p.h(localac, "pointsResult");
              if (localScanGoodsMaskView.yQD)
              {
                com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ScanGoodsMaskView", "alvinluo addAnimationScanDots isViewDestroy");
                AppMethodBeat.o(161015);
                return;
              }
              ScanPoint[] arrayOfScanPoint = localac.points;
              if (arrayOfScanPoint != null)
              {
                com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.ScanGoodsMaskView", "alvinluo addAnimationScanDots size: %d", new Object[] { Integer.valueOf(localac.pointCount) });
                int j = localac.pointCount;
                int i = 0;
                if (i < j)
                {
                  Object localObject2 = (ScanPoint)e.f(arrayOfScanPoint, i);
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
                    com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.ScanGoodsMaskView", "alvinluo getPointObjects id: %d, x: %f, y: %f", new Object[] { localObject1, localFloat, localObject2 });
                    i += 1;
                    break;
                    localObject1 = null;
                    break label149;
                    localFloat = null;
                    break label164;
                  }
                }
                Object localObject1 = localScanGoodsMaskView.yLW;
                if (localObject1 == null) {
                  p.bdF("animationDotsView");
                }
                ((ScanAnimationDotsView)localObject1).b(localac);
              }
            }
            AppMethodBeat.o(161015);
          }
        });
        AppMethodBeat.o(161018);
      }
      
      public final void zu(final long paramAnonymousLong)
      {
        AppMethodBeat.i(161017);
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.ScanUIRectView", "alvinluo postTakeShot session: %d, delay: %d", new Object[] { Long.valueOf(paramAnonymousLong), Long.valueOf(0L) });
        ScanUIRectView.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(161014);
            if ((ScanUIRectView.l(ScanUIRectView.this) == paramAnonymousLong) && (ScanUIRectView.l(ScanUIRectView.this) != 0L)) {
              ScanUIRectView.this.zy(this.uUG);
            }
            AppMethodBeat.o(161014);
          }
        });
        AppMethodBeat.o(161017);
      }
    };
    this.fHp = new com.tencent.mm.modelgeo.b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(161020);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ScanUIRectView", "onGetLocation %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (!paramAnonymousBoolean)
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ScanUIRectView", "check permission not passed!");
          if ((!ScanUIRectView.s(ScanUIRectView.this)) && (!d.aIi()))
          {
            ScanUIRectView.t(ScanUIRectView.this);
            com.tencent.mm.ui.base.h.a(ScanUIRectView.this.getContext(), ScanUIRectView.this.getContext().getString(2131760082), ScanUIRectView.this.getContext().getString(2131755906), ScanUIRectView.this.getContext().getString(2131760598), ScanUIRectView.this.getContext().getString(2131755691), false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(161019);
                d.cD(ScanUIRectView.this.getContext());
                AppMethodBeat.o(161019);
              }
            }, null);
          }
          AppMethodBeat.o(161020);
          return true;
        }
        if (ScanUIRectView.u(ScanUIRectView.this))
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ScanUIRectView", "ignore, has get lbs!");
          AppMethodBeat.o(161020);
          return false;
        }
        ScanUIRectView.this.cyf();
        ScanUIRectView.v(ScanUIRectView.this);
        com.tencent.mm.modelstat.o.a(2012, paramAnonymousFloat1, paramAnonymousFloat2, (int)paramAnonymousDouble2);
        if (ScanUIRectView.m(ScanUIRectView.this) != null)
        {
          Bundle localBundle = new Bundle();
          localBundle.putFloat("result_lbs_latitude", paramAnonymousFloat2);
          localBundle.putFloat("result_lbs_longitude", paramAnonymousFloat1);
          localBundle.putInt("result_lbs_accuracy", (int)paramAnonymousDouble2);
          localBundle.putInt("result_lbs_source", paramAnonymousInt);
          ScanUIRectView.m(ScanUIRectView.this).e(ScanUIRectView.l(ScanUIRectView.this), localBundle);
        }
        AppMethodBeat.o(161020);
        return false;
      }
    };
    this.yJW = new com.tencent.mm.sdk.b.c() {};
    this.iNw = new GestureDetector(new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(189508);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/ScanUIRectView$14", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/scanner/ui/ScanUIRectView$14", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(189508);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(170014);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/ScanUIRectView$14", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.ScanUIRectView", "double click,pointer:%d,x:%f,y:%f", new Object[] { Integer.valueOf(paramAnonymousMotionEvent.getActionIndex()), Float.valueOf(paramAnonymousMotionEvent.getX(paramAnonymousMotionEvent.getActionIndex())), Float.valueOf(paramAnonymousMotionEvent.getY(paramAnonymousMotionEvent.getActionIndex())) });
        ((com.tencent.scanlib.a.a)ScanUIRectView.A(ScanUIRectView.this)).ahs(5);
        ad.hp(ScanUIRectView.B(ScanUIRectView.this), 3);
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/scanner/ui/ScanUIRectView$14", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(170014);
        return true;
      }
      
      public final boolean onFling(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(170015);
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.ScanUIRectView", "alvinluo onFling velocityX: %f, velocityY: %f, canScrollSwitchTab: %b, enableScrollSwitchTab: %b, isMultiTouch: %b", new Object[] { Float.valueOf(paramAnonymousFloat1), Float.valueOf(paramAnonymousFloat2), Boolean.valueOf(ScanUIRectView.C(ScanUIRectView.this)), Boolean.valueOf(ScanUIRectView.D(ScanUIRectView.this)), Boolean.valueOf(ScanUIRectView.E(ScanUIRectView.this)) });
        if ((!ScanUIRectView.E(ScanUIRectView.this)) && (ScanUIRectView.D(ScanUIRectView.this)) && (Math.abs(paramAnonymousFloat1) > Math.abs(paramAnonymousFloat2)))
        {
          if ((paramAnonymousFloat1 >= -1200.0F) || (!ScanUIRectView.C(ScanUIRectView.this))) {
            break label168;
          }
          if (ScanUIRectView.F(ScanUIRectView.this) != null) {
            ScanUIRectView.F(ScanUIRectView.this).dPT();
          }
          ScanUIRectView.b(ScanUIRectView.this, false);
        }
        for (;;)
        {
          boolean bool = super.onFling(paramAnonymousMotionEvent1, paramAnonymousMotionEvent2, paramAnonymousFloat1, paramAnonymousFloat2);
          AppMethodBeat.o(170015);
          return bool;
          label168:
          if ((paramAnonymousFloat1 > 1200.0F) && (ScanUIRectView.C(ScanUIRectView.this)))
          {
            if (ScanUIRectView.F(ScanUIRectView.this) != null) {
              ScanUIRectView.F(ScanUIRectView.this).dPU();
            }
            ScanUIRectView.b(ScanUIRectView.this, false);
          }
        }
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(189507);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/ScanUIRectView$14", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.ahF());
        super.onLongPress(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/ScanUIRectView$14", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(189507);
      }
      
      public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(189506);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/ScanUIRectView$14", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
        boolean bool = super.onSingleTapUp(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/scanner/ui/ScanUIRectView$14", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(189506);
        return bool;
      }
    });
    this.yJY = new b(Looper.getMainLooper());
    AppMethodBeat.o(51945);
  }
  
  public ScanUIRectView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(51946);
    this.mode = 1;
    this.yFG = true;
    this.yFH = false;
    this.yJB = true;
    this.yJC = false;
    this.yJD = 0;
    this.yJE = 120;
    this.ubz = false;
    this.rqj = null;
    this.yJG = true;
    this.yJH = false;
    this.yFZ = false;
    this.yJJ = false;
    this.yJK = false;
    this.isFirst = true;
    this.yJL = new com.tencent.mm.plugin.scanner.util.g();
    this.yJM = 0;
    this.yJN = 0L;
    this.mTimeout = this.yJL.mTimeout;
    this.yJO = false;
    this.yJP = true;
    this.yJQ = false;
    this.isRetry = false;
    this.yJR = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(51916);
        if ((ScanUIRectView.a(ScanUIRectView.this)) && (!ScanUIRectView.b(ScanUIRectView.this)))
        {
          ScanUIRectView.c(ScanUIRectView.this);
          ScanUIRectView.d(ScanUIRectView.this);
          ad.dOD();
          ScanUIRectView.e(ScanUIRectView.this);
        }
        AppMethodBeat.o(51916);
      }
    };
    this.yJS = 0;
    this.yJT = 0;
    this.yJU = new h.c()
    {
      public final void a(final long paramAnonymousLong, List<com.tencent.qbar.a.a> paramAnonymousList, final List<QbarNative.QBarPoint> paramAnonymousList1, final List<WxQbarNative.QBarReportMsg> paramAnonymousList2, final Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(189505);
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.ScanUIRectView", String.format("scan code after decode %d", new Object[] { Long.valueOf(paramAnonymousLong) }));
        if ((paramAnonymousList != null) && (!paramAnonymousList.isEmpty())) {
          ScanUIRectView.this.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(161010);
              ArrayList localArrayList;
              int j;
              int i;
              Object localObject1;
              if ((ScanUIRectView.l(ScanUIRectView.this) == paramAnonymousLong) && (paramAnonymousLong != 0L))
              {
                ScanUIRectView.this.dPq();
                localArrayList = new ArrayList();
                if ((paramAnonymousList2 != null) && (!paramAnonymousList2.isEmpty()))
                {
                  com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ScanUIRectView", "alvinluo onDecodeSuccess result size: %d", new Object[] { Integer.valueOf(paramAnonymousList2.size()) });
                  j = 0;
                  i = 0;
                  if (j < paramAnonymousList2.size())
                  {
                    localObject1 = (com.tencent.qbar.a.a)paramAnonymousList2.get(j);
                    localObject1 = new WxQBarResult(((com.tencent.qbar.a.a)localObject1).typeID, ((com.tencent.qbar.a.a)localObject1).typeName, ((com.tencent.qbar.a.a)localObject1).data, ((com.tencent.qbar.a.a)localObject1).rawData, ((com.tencent.qbar.a.a)localObject1).charset, ((com.tencent.qbar.a.a)localObject1).priorityLevel);
                    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ScanUIRectView", "alvinluo onDecodeSuccess result index: %d, format: %d, content:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(((WxQBarResult)localObject1).typeID), ((WxQBarResult)localObject1).data });
                    if ((paramAnonymousList1 != null) && (paramAnonymousList1.size() >= j + 1))
                    {
                      localObject2 = (WxQbarNative.QBarReportMsg)paramAnonymousList1.get(j);
                      if (localObject2 != null) {
                        ((WxQBarResult)localObject1).Mhm = ((WxQbarNative.QBarReportMsg)localObject2).qrcodeVersion;
                      }
                    }
                    if ((paramAnonymousBundle == null) || (paramAnonymousBundle.size() < j + 1)) {
                      break label426;
                    }
                    Object localObject2 = (QbarNative.QBarPoint)paramAnonymousBundle.get(j);
                    if (localObject2 == null) {
                      break label426;
                    }
                    ((WxQBarResult)localObject1).MhO = new WxQBarPoint((QbarNative.QBarPoint)localObject2);
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
                if (this.yKb != null) {
                  ((Bundle)localObject1).putAll(this.yKb);
                }
                ScanUIRectView.this.cyf();
                if (ScanUIRectView.m(ScanUIRectView.this) != null) {
                  ScanUIRectView.m(ScanUIRectView.this).e(ScanUIRectView.l(ScanUIRectView.this), (Bundle)localObject1);
                }
                AppMethodBeat.o(161010);
                return;
              }
            }
          });
        }
        AppMethodBeat.o(189505);
      }
      
      public final void af(final long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(170011);
        ScanUIRectView.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(161009);
            if ((paramAnonymousLong1 == ScanUIRectView.l(ScanUIRectView.this)) && (paramAnonymousLong1 != 0L)) {
              ScanUIRectView.this.zy(this.uUG);
            }
            AppMethodBeat.o(161009);
          }
        });
        AppMethodBeat.o(170011);
      }
      
      public final void b(final long paramAnonymousLong, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(170013);
        ScanUIRectView.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(170010);
            if ((paramAnonymousLong == ScanUIRectView.l(ScanUIRectView.this)) && (paramAnonymousLong != 0L) && (this.val$param.containsKey("param_zoom_ratio")))
            {
              float f = this.val$param.getFloat("param_zoom_ratio", 0.0F);
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ScanUIRectView", "zoom to scale %f", new Object[] { Float.valueOf(f) });
              if ((f > 0.0F) && (ScanUIRectView.n(ScanUIRectView.this)) && (ScanUIRectView.o(ScanUIRectView.this).cOB()))
              {
                int i = (int)(((com.tencent.scanlib.a.a)ScanUIRectView.p(ScanUIRectView.this)).fYM() * f);
                ((com.tencent.scanlib.a.a)ScanUIRectView.q(ScanUIRectView.this)).ahr(i);
                com.tencent.qbar.c localc = com.tencent.qbar.c.Mhd;
                localc.Mhr += 1;
                localc.Mhs *= f;
                localc.Mht = (System.currentTimeMillis() - localc.yEl);
                com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.QBarEngineReporter", "alvinluo zoom %d, zoomFactor: %s, totalZoomFactor: %s, lastZoomCostTime: %d", new Object[] { Integer.valueOf(localc.Mhr), Float.valueOf(f), Float.valueOf(localc.Mhs), Long.valueOf(localc.Mht) });
              }
            }
            AppMethodBeat.o(170010);
          }
        });
        AppMethodBeat.o(170013);
      }
    };
    this.yJV = new com.tencent.mm.plugin.scanner.c.a.a()
    {
      public final void a(final long paramAnonymousLong, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(161016);
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.ScanUIRectView", "alvinluo onDecodeSuccess %d", new Object[] { Long.valueOf(paramAnonymousLong) });
        if (paramAnonymousBundle.getBoolean("result_is_best_img", false)) {
          ScanUIRectView.this.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(161013);
              if ((paramAnonymousLong == ScanUIRectView.l(ScanUIRectView.this)) && (ScanUIRectView.l(ScanUIRectView.this) != 0L) && (ScanUIRectView.m(ScanUIRectView.this) != null)) {
                ScanUIRectView.m(ScanUIRectView.this).e(ScanUIRectView.l(ScanUIRectView.this), this.val$result);
              }
              AppMethodBeat.o(161013);
            }
          });
        }
        AppMethodBeat.o(161016);
      }
      
      public final void a(final ac paramAnonymousac)
      {
        AppMethodBeat.i(161018);
        ScanUIRectView.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(161015);
            if ((paramAnonymousac != null) && ((ScanUIRectView.r(ScanUIRectView.this) instanceof ScanGoodsMaskView)))
            {
              ScanGoodsMaskView localScanGoodsMaskView = (ScanGoodsMaskView)ScanUIRectView.r(ScanUIRectView.this);
              ac localac = paramAnonymousac;
              p.h(localac, "pointsResult");
              if (localScanGoodsMaskView.yQD)
              {
                com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ScanGoodsMaskView", "alvinluo addAnimationScanDots isViewDestroy");
                AppMethodBeat.o(161015);
                return;
              }
              ScanPoint[] arrayOfScanPoint = localac.points;
              if (arrayOfScanPoint != null)
              {
                com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.ScanGoodsMaskView", "alvinluo addAnimationScanDots size: %d", new Object[] { Integer.valueOf(localac.pointCount) });
                int j = localac.pointCount;
                int i = 0;
                if (i < j)
                {
                  Object localObject2 = (ScanPoint)e.f(arrayOfScanPoint, i);
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
                    com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.ScanGoodsMaskView", "alvinluo getPointObjects id: %d, x: %f, y: %f", new Object[] { localObject1, localFloat, localObject2 });
                    i += 1;
                    break;
                    localObject1 = null;
                    break label149;
                    localFloat = null;
                    break label164;
                  }
                }
                Object localObject1 = localScanGoodsMaskView.yLW;
                if (localObject1 == null) {
                  p.bdF("animationDotsView");
                }
                ((ScanAnimationDotsView)localObject1).b(localac);
              }
            }
            AppMethodBeat.o(161015);
          }
        });
        AppMethodBeat.o(161018);
      }
      
      public final void zu(final long paramAnonymousLong)
      {
        AppMethodBeat.i(161017);
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.ScanUIRectView", "alvinluo postTakeShot session: %d, delay: %d", new Object[] { Long.valueOf(paramAnonymousLong), Long.valueOf(0L) });
        ScanUIRectView.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(161014);
            if ((ScanUIRectView.l(ScanUIRectView.this) == paramAnonymousLong) && (ScanUIRectView.l(ScanUIRectView.this) != 0L)) {
              ScanUIRectView.this.zy(this.uUG);
            }
            AppMethodBeat.o(161014);
          }
        });
        AppMethodBeat.o(161017);
      }
    };
    this.fHp = new com.tencent.mm.modelgeo.b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(161020);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ScanUIRectView", "onGetLocation %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (!paramAnonymousBoolean)
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ScanUIRectView", "check permission not passed!");
          if ((!ScanUIRectView.s(ScanUIRectView.this)) && (!d.aIi()))
          {
            ScanUIRectView.t(ScanUIRectView.this);
            com.tencent.mm.ui.base.h.a(ScanUIRectView.this.getContext(), ScanUIRectView.this.getContext().getString(2131760082), ScanUIRectView.this.getContext().getString(2131755906), ScanUIRectView.this.getContext().getString(2131760598), ScanUIRectView.this.getContext().getString(2131755691), false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(161019);
                d.cD(ScanUIRectView.this.getContext());
                AppMethodBeat.o(161019);
              }
            }, null);
          }
          AppMethodBeat.o(161020);
          return true;
        }
        if (ScanUIRectView.u(ScanUIRectView.this))
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ScanUIRectView", "ignore, has get lbs!");
          AppMethodBeat.o(161020);
          return false;
        }
        ScanUIRectView.this.cyf();
        ScanUIRectView.v(ScanUIRectView.this);
        com.tencent.mm.modelstat.o.a(2012, paramAnonymousFloat1, paramAnonymousFloat2, (int)paramAnonymousDouble2);
        if (ScanUIRectView.m(ScanUIRectView.this) != null)
        {
          Bundle localBundle = new Bundle();
          localBundle.putFloat("result_lbs_latitude", paramAnonymousFloat2);
          localBundle.putFloat("result_lbs_longitude", paramAnonymousFloat1);
          localBundle.putInt("result_lbs_accuracy", (int)paramAnonymousDouble2);
          localBundle.putInt("result_lbs_source", paramAnonymousInt);
          ScanUIRectView.m(ScanUIRectView.this).e(ScanUIRectView.l(ScanUIRectView.this), localBundle);
        }
        AppMethodBeat.o(161020);
        return false;
      }
    };
    this.yJW = new com.tencent.mm.sdk.b.c() {};
    this.iNw = new GestureDetector(new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(189508);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/ScanUIRectView$14", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/scanner/ui/ScanUIRectView$14", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(189508);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(170014);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/ScanUIRectView$14", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.ScanUIRectView", "double click,pointer:%d,x:%f,y:%f", new Object[] { Integer.valueOf(paramAnonymousMotionEvent.getActionIndex()), Float.valueOf(paramAnonymousMotionEvent.getX(paramAnonymousMotionEvent.getActionIndex())), Float.valueOf(paramAnonymousMotionEvent.getY(paramAnonymousMotionEvent.getActionIndex())) });
        ((com.tencent.scanlib.a.a)ScanUIRectView.A(ScanUIRectView.this)).ahs(5);
        ad.hp(ScanUIRectView.B(ScanUIRectView.this), 3);
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/scanner/ui/ScanUIRectView$14", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(170014);
        return true;
      }
      
      public final boolean onFling(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(170015);
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.ScanUIRectView", "alvinluo onFling velocityX: %f, velocityY: %f, canScrollSwitchTab: %b, enableScrollSwitchTab: %b, isMultiTouch: %b", new Object[] { Float.valueOf(paramAnonymousFloat1), Float.valueOf(paramAnonymousFloat2), Boolean.valueOf(ScanUIRectView.C(ScanUIRectView.this)), Boolean.valueOf(ScanUIRectView.D(ScanUIRectView.this)), Boolean.valueOf(ScanUIRectView.E(ScanUIRectView.this)) });
        if ((!ScanUIRectView.E(ScanUIRectView.this)) && (ScanUIRectView.D(ScanUIRectView.this)) && (Math.abs(paramAnonymousFloat1) > Math.abs(paramAnonymousFloat2)))
        {
          if ((paramAnonymousFloat1 >= -1200.0F) || (!ScanUIRectView.C(ScanUIRectView.this))) {
            break label168;
          }
          if (ScanUIRectView.F(ScanUIRectView.this) != null) {
            ScanUIRectView.F(ScanUIRectView.this).dPT();
          }
          ScanUIRectView.b(ScanUIRectView.this, false);
        }
        for (;;)
        {
          boolean bool = super.onFling(paramAnonymousMotionEvent1, paramAnonymousMotionEvent2, paramAnonymousFloat1, paramAnonymousFloat2);
          AppMethodBeat.o(170015);
          return bool;
          label168:
          if ((paramAnonymousFloat1 > 1200.0F) && (ScanUIRectView.C(ScanUIRectView.this)))
          {
            if (ScanUIRectView.F(ScanUIRectView.this) != null) {
              ScanUIRectView.F(ScanUIRectView.this).dPU();
            }
            ScanUIRectView.b(ScanUIRectView.this, false);
          }
        }
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(189507);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/ScanUIRectView$14", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.ahF());
        super.onLongPress(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/ScanUIRectView$14", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(189507);
      }
      
      public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(189506);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/ScanUIRectView$14", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
        boolean bool = super.onSingleTapUp(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/scanner/ui/ScanUIRectView$14", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(189506);
        return bool;
      }
    });
    this.yJY = new b(Looper.getMainLooper());
    AppMethodBeat.o(51946);
  }
  
  public ScanUIRectView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(51947);
    this.mode = 1;
    this.yFG = true;
    this.yFH = false;
    this.yJB = true;
    this.yJC = false;
    this.yJD = 0;
    this.yJE = 120;
    this.ubz = false;
    this.rqj = null;
    this.yJG = true;
    this.yJH = false;
    this.yFZ = false;
    this.yJJ = false;
    this.yJK = false;
    this.isFirst = true;
    this.yJL = new com.tencent.mm.plugin.scanner.util.g();
    this.yJM = 0;
    this.yJN = 0L;
    this.mTimeout = this.yJL.mTimeout;
    this.yJO = false;
    this.yJP = true;
    this.yJQ = false;
    this.isRetry = false;
    this.yJR = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(51916);
        if ((ScanUIRectView.a(ScanUIRectView.this)) && (!ScanUIRectView.b(ScanUIRectView.this)))
        {
          ScanUIRectView.c(ScanUIRectView.this);
          ScanUIRectView.d(ScanUIRectView.this);
          ad.dOD();
          ScanUIRectView.e(ScanUIRectView.this);
        }
        AppMethodBeat.o(51916);
      }
    };
    this.yJS = 0;
    this.yJT = 0;
    this.yJU = new h.c()
    {
      public final void a(final long paramAnonymousLong, List<com.tencent.qbar.a.a> paramAnonymousList, final List<QbarNative.QBarPoint> paramAnonymousList1, final List<WxQbarNative.QBarReportMsg> paramAnonymousList2, final Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(189505);
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.ScanUIRectView", String.format("scan code after decode %d", new Object[] { Long.valueOf(paramAnonymousLong) }));
        if ((paramAnonymousList != null) && (!paramAnonymousList.isEmpty())) {
          ScanUIRectView.this.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(161010);
              ArrayList localArrayList;
              int j;
              int i;
              Object localObject1;
              if ((ScanUIRectView.l(ScanUIRectView.this) == paramAnonymousLong) && (paramAnonymousLong != 0L))
              {
                ScanUIRectView.this.dPq();
                localArrayList = new ArrayList();
                if ((paramAnonymousList2 != null) && (!paramAnonymousList2.isEmpty()))
                {
                  com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ScanUIRectView", "alvinluo onDecodeSuccess result size: %d", new Object[] { Integer.valueOf(paramAnonymousList2.size()) });
                  j = 0;
                  i = 0;
                  if (j < paramAnonymousList2.size())
                  {
                    localObject1 = (com.tencent.qbar.a.a)paramAnonymousList2.get(j);
                    localObject1 = new WxQBarResult(((com.tencent.qbar.a.a)localObject1).typeID, ((com.tencent.qbar.a.a)localObject1).typeName, ((com.tencent.qbar.a.a)localObject1).data, ((com.tencent.qbar.a.a)localObject1).rawData, ((com.tencent.qbar.a.a)localObject1).charset, ((com.tencent.qbar.a.a)localObject1).priorityLevel);
                    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ScanUIRectView", "alvinluo onDecodeSuccess result index: %d, format: %d, content:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(((WxQBarResult)localObject1).typeID), ((WxQBarResult)localObject1).data });
                    if ((paramAnonymousList1 != null) && (paramAnonymousList1.size() >= j + 1))
                    {
                      localObject2 = (WxQbarNative.QBarReportMsg)paramAnonymousList1.get(j);
                      if (localObject2 != null) {
                        ((WxQBarResult)localObject1).Mhm = ((WxQbarNative.QBarReportMsg)localObject2).qrcodeVersion;
                      }
                    }
                    if ((paramAnonymousBundle == null) || (paramAnonymousBundle.size() < j + 1)) {
                      break label426;
                    }
                    Object localObject2 = (QbarNative.QBarPoint)paramAnonymousBundle.get(j);
                    if (localObject2 == null) {
                      break label426;
                    }
                    ((WxQBarResult)localObject1).MhO = new WxQBarPoint((QbarNative.QBarPoint)localObject2);
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
                if (this.yKb != null) {
                  ((Bundle)localObject1).putAll(this.yKb);
                }
                ScanUIRectView.this.cyf();
                if (ScanUIRectView.m(ScanUIRectView.this) != null) {
                  ScanUIRectView.m(ScanUIRectView.this).e(ScanUIRectView.l(ScanUIRectView.this), (Bundle)localObject1);
                }
                AppMethodBeat.o(161010);
                return;
              }
            }
          });
        }
        AppMethodBeat.o(189505);
      }
      
      public final void af(final long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(170011);
        ScanUIRectView.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(161009);
            if ((paramAnonymousLong1 == ScanUIRectView.l(ScanUIRectView.this)) && (paramAnonymousLong1 != 0L)) {
              ScanUIRectView.this.zy(this.uUG);
            }
            AppMethodBeat.o(161009);
          }
        });
        AppMethodBeat.o(170011);
      }
      
      public final void b(final long paramAnonymousLong, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(170013);
        ScanUIRectView.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(170010);
            if ((paramAnonymousLong == ScanUIRectView.l(ScanUIRectView.this)) && (paramAnonymousLong != 0L) && (this.val$param.containsKey("param_zoom_ratio")))
            {
              float f = this.val$param.getFloat("param_zoom_ratio", 0.0F);
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ScanUIRectView", "zoom to scale %f", new Object[] { Float.valueOf(f) });
              if ((f > 0.0F) && (ScanUIRectView.n(ScanUIRectView.this)) && (ScanUIRectView.o(ScanUIRectView.this).cOB()))
              {
                int i = (int)(((com.tencent.scanlib.a.a)ScanUIRectView.p(ScanUIRectView.this)).fYM() * f);
                ((com.tencent.scanlib.a.a)ScanUIRectView.q(ScanUIRectView.this)).ahr(i);
                com.tencent.qbar.c localc = com.tencent.qbar.c.Mhd;
                localc.Mhr += 1;
                localc.Mhs *= f;
                localc.Mht = (System.currentTimeMillis() - localc.yEl);
                com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.QBarEngineReporter", "alvinluo zoom %d, zoomFactor: %s, totalZoomFactor: %s, lastZoomCostTime: %d", new Object[] { Integer.valueOf(localc.Mhr), Float.valueOf(f), Float.valueOf(localc.Mhs), Long.valueOf(localc.Mht) });
              }
            }
            AppMethodBeat.o(170010);
          }
        });
        AppMethodBeat.o(170013);
      }
    };
    this.yJV = new com.tencent.mm.plugin.scanner.c.a.a()
    {
      public final void a(final long paramAnonymousLong, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(161016);
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.ScanUIRectView", "alvinluo onDecodeSuccess %d", new Object[] { Long.valueOf(paramAnonymousLong) });
        if (paramAnonymousBundle.getBoolean("result_is_best_img", false)) {
          ScanUIRectView.this.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(161013);
              if ((paramAnonymousLong == ScanUIRectView.l(ScanUIRectView.this)) && (ScanUIRectView.l(ScanUIRectView.this) != 0L) && (ScanUIRectView.m(ScanUIRectView.this) != null)) {
                ScanUIRectView.m(ScanUIRectView.this).e(ScanUIRectView.l(ScanUIRectView.this), this.val$result);
              }
              AppMethodBeat.o(161013);
            }
          });
        }
        AppMethodBeat.o(161016);
      }
      
      public final void a(final ac paramAnonymousac)
      {
        AppMethodBeat.i(161018);
        ScanUIRectView.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(161015);
            if ((paramAnonymousac != null) && ((ScanUIRectView.r(ScanUIRectView.this) instanceof ScanGoodsMaskView)))
            {
              ScanGoodsMaskView localScanGoodsMaskView = (ScanGoodsMaskView)ScanUIRectView.r(ScanUIRectView.this);
              ac localac = paramAnonymousac;
              p.h(localac, "pointsResult");
              if (localScanGoodsMaskView.yQD)
              {
                com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ScanGoodsMaskView", "alvinluo addAnimationScanDots isViewDestroy");
                AppMethodBeat.o(161015);
                return;
              }
              ScanPoint[] arrayOfScanPoint = localac.points;
              if (arrayOfScanPoint != null)
              {
                com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.ScanGoodsMaskView", "alvinluo addAnimationScanDots size: %d", new Object[] { Integer.valueOf(localac.pointCount) });
                int j = localac.pointCount;
                int i = 0;
                if (i < j)
                {
                  Object localObject2 = (ScanPoint)e.f(arrayOfScanPoint, i);
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
                    com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.ScanGoodsMaskView", "alvinluo getPointObjects id: %d, x: %f, y: %f", new Object[] { localObject1, localFloat, localObject2 });
                    i += 1;
                    break;
                    localObject1 = null;
                    break label149;
                    localFloat = null;
                    break label164;
                  }
                }
                Object localObject1 = localScanGoodsMaskView.yLW;
                if (localObject1 == null) {
                  p.bdF("animationDotsView");
                }
                ((ScanAnimationDotsView)localObject1).b(localac);
              }
            }
            AppMethodBeat.o(161015);
          }
        });
        AppMethodBeat.o(161018);
      }
      
      public final void zu(final long paramAnonymousLong)
      {
        AppMethodBeat.i(161017);
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.ScanUIRectView", "alvinluo postTakeShot session: %d, delay: %d", new Object[] { Long.valueOf(paramAnonymousLong), Long.valueOf(0L) });
        ScanUIRectView.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(161014);
            if ((ScanUIRectView.l(ScanUIRectView.this) == paramAnonymousLong) && (ScanUIRectView.l(ScanUIRectView.this) != 0L)) {
              ScanUIRectView.this.zy(this.uUG);
            }
            AppMethodBeat.o(161014);
          }
        });
        AppMethodBeat.o(161017);
      }
    };
    this.fHp = new com.tencent.mm.modelgeo.b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(161020);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ScanUIRectView", "onGetLocation %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (!paramAnonymousBoolean)
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ScanUIRectView", "check permission not passed!");
          if ((!ScanUIRectView.s(ScanUIRectView.this)) && (!d.aIi()))
          {
            ScanUIRectView.t(ScanUIRectView.this);
            com.tencent.mm.ui.base.h.a(ScanUIRectView.this.getContext(), ScanUIRectView.this.getContext().getString(2131760082), ScanUIRectView.this.getContext().getString(2131755906), ScanUIRectView.this.getContext().getString(2131760598), ScanUIRectView.this.getContext().getString(2131755691), false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(161019);
                d.cD(ScanUIRectView.this.getContext());
                AppMethodBeat.o(161019);
              }
            }, null);
          }
          AppMethodBeat.o(161020);
          return true;
        }
        if (ScanUIRectView.u(ScanUIRectView.this))
        {
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ScanUIRectView", "ignore, has get lbs!");
          AppMethodBeat.o(161020);
          return false;
        }
        ScanUIRectView.this.cyf();
        ScanUIRectView.v(ScanUIRectView.this);
        com.tencent.mm.modelstat.o.a(2012, paramAnonymousFloat1, paramAnonymousFloat2, (int)paramAnonymousDouble2);
        if (ScanUIRectView.m(ScanUIRectView.this) != null)
        {
          Bundle localBundle = new Bundle();
          localBundle.putFloat("result_lbs_latitude", paramAnonymousFloat2);
          localBundle.putFloat("result_lbs_longitude", paramAnonymousFloat1);
          localBundle.putInt("result_lbs_accuracy", (int)paramAnonymousDouble2);
          localBundle.putInt("result_lbs_source", paramAnonymousInt);
          ScanUIRectView.m(ScanUIRectView.this).e(ScanUIRectView.l(ScanUIRectView.this), localBundle);
        }
        AppMethodBeat.o(161020);
        return false;
      }
    };
    this.yJW = new com.tencent.mm.sdk.b.c() {};
    this.iNw = new GestureDetector(new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(189508);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/ScanUIRectView$14", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/scanner/ui/ScanUIRectView$14", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(189508);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(170014);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/ScanUIRectView$14", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.ScanUIRectView", "double click,pointer:%d,x:%f,y:%f", new Object[] { Integer.valueOf(paramAnonymousMotionEvent.getActionIndex()), Float.valueOf(paramAnonymousMotionEvent.getX(paramAnonymousMotionEvent.getActionIndex())), Float.valueOf(paramAnonymousMotionEvent.getY(paramAnonymousMotionEvent.getActionIndex())) });
        ((com.tencent.scanlib.a.a)ScanUIRectView.A(ScanUIRectView.this)).ahs(5);
        ad.hp(ScanUIRectView.B(ScanUIRectView.this), 3);
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/scanner/ui/ScanUIRectView$14", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(170014);
        return true;
      }
      
      public final boolean onFling(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(170015);
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.ScanUIRectView", "alvinluo onFling velocityX: %f, velocityY: %f, canScrollSwitchTab: %b, enableScrollSwitchTab: %b, isMultiTouch: %b", new Object[] { Float.valueOf(paramAnonymousFloat1), Float.valueOf(paramAnonymousFloat2), Boolean.valueOf(ScanUIRectView.C(ScanUIRectView.this)), Boolean.valueOf(ScanUIRectView.D(ScanUIRectView.this)), Boolean.valueOf(ScanUIRectView.E(ScanUIRectView.this)) });
        if ((!ScanUIRectView.E(ScanUIRectView.this)) && (ScanUIRectView.D(ScanUIRectView.this)) && (Math.abs(paramAnonymousFloat1) > Math.abs(paramAnonymousFloat2)))
        {
          if ((paramAnonymousFloat1 >= -1200.0F) || (!ScanUIRectView.C(ScanUIRectView.this))) {
            break label168;
          }
          if (ScanUIRectView.F(ScanUIRectView.this) != null) {
            ScanUIRectView.F(ScanUIRectView.this).dPT();
          }
          ScanUIRectView.b(ScanUIRectView.this, false);
        }
        for (;;)
        {
          boolean bool = super.onFling(paramAnonymousMotionEvent1, paramAnonymousMotionEvent2, paramAnonymousFloat1, paramAnonymousFloat2);
          AppMethodBeat.o(170015);
          return bool;
          label168:
          if ((paramAnonymousFloat1 > 1200.0F) && (ScanUIRectView.C(ScanUIRectView.this)))
          {
            if (ScanUIRectView.F(ScanUIRectView.this) != null) {
              ScanUIRectView.F(ScanUIRectView.this).dPU();
            }
            ScanUIRectView.b(ScanUIRectView.this, false);
          }
        }
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(189507);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/ScanUIRectView$14", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.ahF());
        super.onLongPress(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/ScanUIRectView$14", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(189507);
      }
      
      public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(189506);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/ScanUIRectView$14", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
        boolean bool = super.onSingleTapUp(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/scanner/ui/ScanUIRectView$14", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(189506);
        return bool;
      }
    });
    this.yJY = new b(Looper.getMainLooper());
    AppMethodBeat.o(51947);
  }
  
  private void bG(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(161043);
    if ((this.MmA.cOB()) && (((com.tencent.mm.plugin.scanner.a.a)this.MmA).dOb())) {
      ScanCameraLightDetector.yPx.D(paramArrayOfByte, ((com.tencent.mm.plugin.scanner.a.a)this.MmA).fYJ().x, ((com.tencent.mm.plugin.scanner.a.a)this.MmA).fYJ().y);
    }
    switch (this.mode)
    {
    default: 
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ScanUIRectView", "unknown scan mode %d", new Object[] { Integer.valueOf(this.mode) });
      AppMethodBeat.o(161043);
      return;
    case 1: 
    case 4: 
    case 8: 
      bH(paramArrayOfByte);
      AppMethodBeat.o(161043);
      return;
    }
    bI(paramArrayOfByte);
    AppMethodBeat.o(161043);
  }
  
  private void bH(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(161044);
    Object localObject;
    Rect localRect1;
    if ((this.yBt != 0L) && (this.MmA.cOB()))
    {
      localObject = this.MmA.fYJ();
      if (localObject != null)
      {
        localRect1 = getScanCodeRect();
        if ((this.isRetry) && (this.yJM != 1)) {
          break label198;
        }
        Rect localRect2 = ((com.tencent.mm.plugin.scanner.a.a)this.MmA).r(localRect1);
        if (this.yDN != null)
        {
          this.yDN.setPreviewRect(localRect2);
          this.yDN.setScanRect(localRect1);
          if ((this.yDN instanceof ScanCodeMaskView)) {
            ((ScanCodeMaskView)this.yDN).setNeedRotate(true);
          }
        }
        com.tencent.qbar.h.fYd().a(paramArrayOfByte, (Point)localObject, this.MmA.getCameraRotation(), localRect2);
      }
    }
    for (;;)
    {
      if ((!((com.tencent.scanlib.a.a)this.MmA).dPp()) && (com.tencent.qbar.h.fYd().yBw > yJI))
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ScanUIRectView", "change to FOCUS_MODE_AUTO");
        this.MmA.setFocusMode("auto");
        Fv(100L);
      }
      AppMethodBeat.o(161044);
      return;
      label198:
      if ((this.isRetry) && (this.yJM == 2))
      {
        localObject = new Rect(0, 0, this.yJS, this.yJT);
        if (this.yDN != null)
        {
          this.yDN.setPreviewRect((Rect)localObject);
          this.yDN.setScanRect(localRect1);
          if ((this.yDN instanceof ScanCodeMaskView)) {
            ((ScanCodeMaskView)this.yDN).setNeedRotate(false);
          }
        }
        com.tencent.qbar.h.fYd().a(paramArrayOfByte, new Point(this.yJS, this.yJT), 0, (Rect)localObject);
      }
    }
  }
  
  private void bI(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(161045);
    if (this.yBt != 0L) {
      synchronized (this.MmA)
      {
        if (this.MmA.cOB())
        {
          Point localPoint = this.MmA.fYJ();
          boolean bool = true;
          if ((this.yFP instanceof ScanGoodsRequest)) {
            bool = ((ScanGoodsRequest)this.yFP).yzL;
          }
          com.tencent.mm.plugin.scanner.c.a.dOf().a(paramArrayOfByte, localPoint, this.MmA.getCameraRotation(), ((com.tencent.mm.plugin.scanner.a.a)this.MmA).getPreviewFormat(), bool);
        }
        AppMethodBeat.o(161045);
        return;
      }
    }
    AppMethodBeat.o(161045);
  }
  
  private byte[] dPr()
  {
    AppMethodBeat.i(161042);
    for (;;)
    {
      int i;
      try
      {
        l1 = System.currentTimeMillis();
        k = this.bef.getWidth();
        int m = this.bef.getHeight();
        i = m;
        j = k;
        if (this.yJL == null) {
          break label300;
        }
        i = m;
        j = k;
        if (this.yJL.yPO == 0.0F) {
          break label300;
        }
        j = (int)(this.bef.getWidth() * this.yJL.yPO);
        i = (int)(this.bef.getHeight() * this.yJL.yPO);
      }
      catch (Exception localException)
      {
        long l1;
        Object localObject;
        long l2;
        com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.ScanUIRectView", localException, "alvinluo generateFrameByTextureView exception", new Object[0]);
        AppMethodBeat.o(161042);
        return null;
      }
      localObject = this.bef.getBitmap(k, j);
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.ScanUIRectView", "alvinluo generateFrameByTextureView getBitmap cost: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
      {
        this.yJS = ((Bitmap)localObject).getWidth();
        this.yJT = ((Bitmap)localObject).getHeight();
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.ScanUIRectView", "alvinluo generateFrameByTextureView bitmap width: %d, height: %d", new Object[] { Integer.valueOf(this.yJS), Integer.valueOf(this.yJT) });
        l1 = System.currentTimeMillis();
        localObject = l.a(this.yJS, this.yJT, (Bitmap)localObject);
        l2 = System.currentTimeMillis();
        if (localObject != null)
        {
          i = localObject.length;
          com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.ScanUIRectView", "alvinluo generateFrameByTextureView yuvData: %d, getNV21 cost: %d", new Object[] { Integer.valueOf(i), Long.valueOf(l2 - l1) });
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
  
  private void dPs()
  {
    int i = 0;
    AppMethodBeat.i(51960);
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.ScanUIRectView", "alvinluo createScanMaskView mode: %d, bottomHeight: %d", new Object[] { Integer.valueOf(this.mode), Integer.valueOf(this.yJD) });
    Object localObject2;
    label274:
    boolean bool;
    switch (this.mode)
    {
    default: 
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ScanUIRectView", "unknown scan mode %d", new Object[] { Integer.valueOf(this.mode) });
      if ((this.yDN == null) || (this.yDO == null)) {
        break label699;
      }
      this.yDN.setBottomExtraHeight(this.yJD);
      localObject1 = this.yDN;
      localObject2 = this.activity;
      p.h(localObject2, "activity");
      ((BaseScanMaskView)localObject1).activity = ((Activity)localObject2);
      this.yDN.eH(this.yFp);
      if ((this.MmA instanceof com.tencent.mm.plugin.scanner.a.a)) {
        this.yDN.yIK = ((com.tencent.mm.plugin.scanner.a.a)this.MmA);
      }
      this.yDN.d(this.yDO.getScanTipsView(), getScanTips());
      this.yDN.eJ(this.yDO.getGalleryButton());
      if (this.yFp != null) {
        setFlashStatus(this.yFp.cNB);
      }
      if (this.isFirst)
      {
        this.yDO.setShowTitle(false);
        this.isFirst = false;
        this.yDN.dPG();
        localObject1 = this.yDO;
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ScanSharedMaskView", "alvinluo onViewReady hashCode: %d", new Object[] { Integer.valueOf(((ScanSharedMaskView)localObject1).hashCode()) });
        if (((ScanSharedMaskView)localObject1).yOS) {
          break label550;
        }
        if (((ScanSharedMaskView)localObject1).yOR) {
          break label545;
        }
        bool = true;
        label325:
        ((ScanSharedMaskView)localObject1).qM(bool);
        localObject2 = ((ScanSharedMaskView)localObject1).yOJ;
        if (localObject2 == null) {
          p.bdF("scanTitle");
        }
        ((TextView)localObject2).setVisibility(8);
        label354:
        ((ScanSharedMaskView)localObject1).qM(true);
        if (((ScanSharedMaskView)localObject1).yFP == null) {
          break label679;
        }
        localObject2 = ((ScanSharedMaskView)localObject1).yOM;
        if (localObject2 == null) {
          p.bdF("galleryButton");
        }
        localObject1 = ((ScanSharedMaskView)localObject1).yFP;
        if (localObject1 == null) {
          p.gkB();
        }
        if (((BaseScanRequest)localObject1).yzD) {
          break label673;
        }
      }
      break;
    }
    for (;;)
    {
      ((View)localObject2).setVisibility(i);
      AppMethodBeat.o(51960);
      return;
      dPx();
      this.yDN = new ScanCodeMaskView(getContext());
      addView(this.yDN);
      break;
      this.yDN = new ScanTranslationMaskView(getContext());
      addView(this.yDN);
      break;
      this.yDN = new ScanGoodsMaskView(getContext());
      addView(this.yDN);
      if ((!(this.yDN instanceof ScanGoodsMaskView)) || (!(this.yFP instanceof ScanGoodsRequest))) {
        break;
      }
      ((ScanGoodsMaskView)this.yDN).setScanRequest((ScanGoodsRequest)this.yFP);
      break;
      this.yDO.setShowTitle(true);
      break label274;
      label545:
      bool = false;
      break label325;
      label550:
      ((ScanSharedMaskView)localObject1).qM(false);
      localObject2 = ((ScanSharedMaskView)localObject1).yOJ;
      if (localObject2 == null) {
        p.bdF("scanTitle");
      }
      if (((TextView)localObject2).getVisibility() != 0)
      {
        localObject2 = ((ScanSharedMaskView)localObject1).yOJ;
        if (localObject2 == null) {
          p.bdF("scanTitle");
        }
        ((TextView)localObject2).setVisibility(8);
        localObject2 = ((ScanSharedMaskView)localObject1).yOJ;
        if (localObject2 == null) {
          p.bdF("scanTitle");
        }
        ((TextView)localObject2).setAlpha(1.0F);
        ((ScanSharedMaskView)localObject1).dPX();
        ((ScanSharedMaskView)localObject1).qN(true);
        break label354;
      }
      localObject2 = ((ScanSharedMaskView)localObject1).yOJ;
      if (localObject2 == null) {
        p.bdF("scanTitle");
      }
      ((TextView)localObject2).setAlpha(1.0F);
      ((ScanSharedMaskView)localObject1).dPX();
      ((ScanSharedMaskView)localObject1).dPV();
      break label354;
      label673:
      i = 8;
    }
    label679:
    Object localObject1 = ((ScanSharedMaskView)localObject1).yOM;
    if (localObject1 == null) {
      p.bdF("galleryButton");
    }
    ((View)localObject1).setVisibility(0);
    label699:
    AppMethodBeat.o(51960);
  }
  
  private void dPt()
  {
    AppMethodBeat.i(51962);
    String str = getScanTips();
    this.yDO.setScanTips(str);
    this.yDO.setScanRequest(this.yFP);
    switch (this.mode)
    {
    default: 
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.ScanUIRectView", "alvinluo refreshSharedMaskView unknown scan mode %d", new Object[] { Integer.valueOf(this.mode) });
      AppMethodBeat.o(51962);
      return;
    case 1: 
    case 4: 
    case 8: 
      this.yDO.setScanTitle(getResources().getString(2131762809));
      AppMethodBeat.o(51962);
      return;
    case 3: 
      this.yDO.setScanTitle(getResources().getString(2131762808));
      AppMethodBeat.o(51962);
      return;
    }
    this.yDO.setScanTitle(getResources().getString(2131762804));
    AppMethodBeat.o(51962);
  }
  
  private void dPw()
  {
    AppMethodBeat.i(51970);
    if (this.yDN != null)
    {
      final BaseScanMaskView localBaseScanMaskView = this.yDN;
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
  
  private void dPx()
  {
    AppMethodBeat.i(162394);
    if (com.tencent.qbar.f.fYa())
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ScanUIRectView", "alvinluo updateScanCodeRect visibleResolution: %s", new Object[] { this.rqj });
      if ((this.rqj != null) && (this.rqj.x > 0) && (this.rqj.y > 0))
      {
        this.yJx.setDecorRect(new Rect(0, (int)(this.rqj.y * 1.0F / 19.0F), this.rqj.x, (int)(this.rqj.y * 17.0F / 19.0F)));
        AppMethodBeat.o(162394);
      }
    }
    else
    {
      this.yJx.hv(getResources().getDimensionPixelSize(2131166761), getResources().getDimensionPixelSize(2131166760));
    }
    AppMethodBeat.o(162394);
  }
  
  private void dPy()
  {
    AppMethodBeat.i(160188);
    if (this.yJR != null) {
      removeCallbacks(this.yJR);
    }
    AppMethodBeat.o(160188);
  }
  
  private Rect getScanCodeRect()
  {
    int j = 0;
    AppMethodBeat.i(51975);
    if (com.tencent.qbar.f.fYa())
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
    if (!this.yFG)
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
      str = getResources().getString(2131762874);
      AppMethodBeat.o(51963);
      return str;
    case 8: 
      str = getResources().getString(2131762066);
      AppMethodBeat.o(51963);
      return str;
    case 4: 
      str = getResources().getString(2131762067);
      AppMethodBeat.o(51963);
      return str;
    case 3: 
      str = getResources().getString(2131762882);
      AppMethodBeat.o(51963);
      return str;
    }
    if (!bu.isNullOrNil(this.yJA))
    {
      str = this.yJA;
      AppMethodBeat.o(51963);
      return str;
    }
    String str = getResources().getString(2131762823);
    AppMethodBeat.o(51963);
    return str;
  }
  
  private void qG(boolean paramBoolean)
  {
    AppMethodBeat.i(51974);
    if (this.yDN != null) {
      this.yDN.qG(paramBoolean);
    }
    if (this.yDO != null) {
      this.yDO.qG(paramBoolean);
    }
    if (this.yJy != null) {
      this.yJy.setVisibility(8);
    }
    AppMethodBeat.o(51974);
  }
  
  private void zz(long paramLong)
  {
    AppMethodBeat.i(161046);
    long l1 = System.currentTimeMillis() - this.yJX;
    if (l1 > MmB)
    {
      this.yJY.removeMessages(0);
      this.yJY.sendEmptyMessageDelayed(0, paramLong);
      AppMethodBeat.o(161046);
      return;
    }
    long l2 = MmB;
    this.yJY.removeMessages(0);
    this.yJY.sendEmptyMessageDelayed(0, l2 - l1 + paramLong);
    AppMethodBeat.o(161046);
  }
  
  public final void a(final b.b.a parama)
  {
    AppMethodBeat.i(161041);
    super.a(new b.b.a()
    {
      public final void dPA()
      {
        AppMethodBeat.i(161029);
        ScanUIRectView.h(ScanUIRectView.this);
        if (parama != null) {
          parama.dPA();
        }
        AppMethodBeat.o(161029);
      }
    });
    AppMethodBeat.o(161041);
  }
  
  public final void a(Object paramObject, com.tencent.mm.plugin.scanner.view.c paramc)
  {
    AppMethodBeat.i(51971);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ScanUIRectView", "alvinluo onScanSuccess");
    dPy();
    onPause();
    stopPreview();
    if (this.yDN != null)
    {
      this.yDN.a(paramObject, paramc);
      this.yDN.eI(this.bef);
    }
    if (this.yDO != null)
    {
      paramObject = this.yDO;
      com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.ScanSharedMaskView", "alvinluo onScanSuccess");
      paramc = paramObject.yOM;
      if (paramc == null) {
        p.bdF("galleryButton");
      }
      paramc = paramc.animate();
      if (paramc != null)
      {
        paramc = paramc.alpha(0.0F);
        if (paramc != null)
        {
          paramc = paramc.setListener(null);
          if (paramc != null)
          {
            paramc = paramc.setInterpolator((TimeInterpolator)new LinearInterpolator());
            if (paramc != null)
            {
              paramc = paramc.setUpdateListener(null);
              if (paramc != null)
              {
                paramc = paramc.setDuration(200L);
                if (paramc != null) {
                  paramc.start();
                }
              }
            }
          }
        }
      }
      paramObject.dPX();
      paramc = paramObject.yOJ;
      if (paramc == null) {
        p.bdF("scanTitle");
      }
      paramc.setVisibility(8);
      paramObject.yOR = false;
      paramObject = paramObject.yFp;
      if (paramObject == null) {
        p.bdF("flashSwitcher");
      }
      paramObject.setVisibility(8);
    }
    if ((com.tencent.mm.plugin.scanner.util.o.PD(this.mode)) && (this.yJL != null)) {
      this.yJL.yPQ = true;
    }
    AppMethodBeat.o(51971);
  }
  
  public final void a(boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(51965);
    if (this.yDN != null) {
      this.yDN.a(paramBoolean, paramOnCancelListener);
    }
    AppMethodBeat.o(51965);
  }
  
  public final void cyf()
  {
    AppMethodBeat.i(51978);
    if ((this.yDN != null) && ((this.yDN instanceof ScanCodeMaskView))) {
      ((ScanCodeMaskView)this.yDN).cyf();
    }
    AppMethodBeat.o(51978);
  }
  
  public final void dPo()
  {
    AppMethodBeat.i(51948);
    this.MmA = new com.tencent.mm.plugin.scanner.a.a();
    AppMethodBeat.o(51948);
  }
  
  public final boolean dPp()
  {
    AppMethodBeat.i(51950);
    if (this.MmA != null)
    {
      boolean bool = ((com.tencent.scanlib.a.a)this.MmA).dPp();
      AppMethodBeat.o(51950);
      return bool;
    }
    AppMethodBeat.o(51950);
    return false;
  }
  
  public final void dPq()
  {
    AppMethodBeat.i(51952);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ScanUIRectView", "alvinluo stopCurrentSession %d", new Object[] { Long.valueOf(this.yBt) });
    com.tencent.qbar.h.fYd().zt(this.yBt);
    com.tencent.mm.plugin.scanner.c.a.dOf().zt(this.yBt);
    this.yBt = 0L;
    AppMethodBeat.o(51952);
  }
  
  public final void dPu()
  {
    AppMethodBeat.i(51967);
    if ((this.yDO != null) && (!this.yFp.cNB)) {
      this.yDO.qO(true);
    }
    AppMethodBeat.o(51967);
  }
  
  public final void dPv()
  {
    AppMethodBeat.i(51968);
    if ((this.yDO != null) && (this.yFp.cNB)) {
      this.yDO.qO(false);
    }
    AppMethodBeat.o(51968);
  }
  
  public Rect getDecorRect()
  {
    AppMethodBeat.i(51976);
    Rect localRect = this.yJx.getDecorRect();
    AppMethodBeat.o(51976);
    return localRect;
  }
  
  public com.tencent.scanlib.a.f getScanCamera()
  {
    return this.MmA;
  }
  
  public BaseScanMaskView getScanMaskView()
  {
    return this.yDN;
  }
  
  public ScanSharedMaskView getSharedMaskView()
  {
    return this.yDO;
  }
  
  public final void init()
  {
    AppMethodBeat.i(51959);
    super.init();
    this.yJx = new ScanRectDecorView(getContext());
    if (this.yFZ) {
      this.yJA = v.dOu();
    }
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ScanUIRectView", "initScanGoodsTips enable: %b, %s", new Object[] { Boolean.valueOf(this.yFZ), this.yJA });
    addView(this.yJx, new FrameLayout.LayoutParams(-1, -1));
    this.yDO = new ScanSharedMaskView(getContext());
    this.yFp = this.yDO.getFlashSwitcherView();
    addView(this.yDO, new FrameLayout.LayoutParams(-1, -1));
    dPt();
    AppMethodBeat.o(51959);
  }
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    AppMethodBeat.i(51972);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ScanUIRectView", "onAutoFocus %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.yJP = false;
      zy(0L);
    }
    Fv(MmD);
    AppMethodBeat.o(51972);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(51949);
    super.onCreate();
    this.yJE = ((int)(com.tencent.mm.cb.a.iu(getContext()) / 4.5F));
    if (com.tencent.mm.plugin.scanner.util.o.PD(this.mode)) {
      com.tencent.qbar.h.fYd().init(getContext());
    }
    com.tencent.qbar.h.fYd().MhQ = new ak();
    setOnTouchListener(new View.OnTouchListener()
    {
      private float yKf;
      private float yKg = 400.0F;
      private boolean yKh = false;
      
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(170016);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/ScanUIRectView$15", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        int i = paramAnonymousMotionEvent.getActionMasked();
        int j = paramAnonymousMotionEvent.getActionIndex();
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.ScanUIRectView", "pointIndex:%d, action: %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
        switch (i)
        {
        }
        for (;;)
        {
          paramAnonymousView = ScanUIRectView.L(ScanUIRectView.this);
          localObject = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/scanner/ui/ScanUIRectView$15", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousView.onTouchEvent((MotionEvent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0)), "com/tencent/mm/plugin/scanner/ui/ScanUIRectView$15", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
          if (paramAnonymousMotionEvent.getAction() == 1) {
            ScanUIRectView.c(ScanUIRectView.this, false);
          }
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/scanner/ui/ScanUIRectView$15", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(170016);
          return true;
          com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.ScanUIRectView", "first down,pointer:%d,x:%f,y:%f", new Object[] { Integer.valueOf(j), Float.valueOf(paramAnonymousMotionEvent.getX()), Float.valueOf(paramAnonymousMotionEvent.getY()) });
          ScanUIRectView.a(ScanUIRectView.this, paramAnonymousMotionEvent.getRawX());
          ScanUIRectView.b(ScanUIRectView.this, true);
          this.yKh = false;
          continue;
          com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.ScanUIRectView", "down,pointer:%d,x:%f,y:%f", new Object[] { Integer.valueOf(j), Float.valueOf(paramAnonymousMotionEvent.getX(j)), Float.valueOf(paramAnonymousMotionEvent.getY(j)) });
          if (paramAnonymousMotionEvent.getPointerCount() == 2)
          {
            this.yKf = ((float)(Math.pow(paramAnonymousMotionEvent.getX(0) - paramAnonymousMotionEvent.getX(1), 2.0D) + Math.pow(paramAnonymousMotionEvent.getY(0) - paramAnonymousMotionEvent.getY(1), 2.0D)));
            ScanUIRectView.c(ScanUIRectView.this, true);
          }
          this.yKh = false;
          continue;
          com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.ScanUIRectView", "last up,pointer:%d,x:%f,y:%f", new Object[] { Integer.valueOf(j), Float.valueOf(paramAnonymousMotionEvent.getX()), Float.valueOf(paramAnonymousMotionEvent.getY()) });
          if (paramAnonymousMotionEvent.getPointerCount() == 2)
          {
            this.yKf = ((float)(Math.pow(paramAnonymousMotionEvent.getX(0) - paramAnonymousMotionEvent.getX(1), 2.0D) + Math.pow(paramAnonymousMotionEvent.getY(0) - paramAnonymousMotionEvent.getY(1), 2.0D)));
            continue;
            com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.ScanUIRectView", "up,pointer:%d,x:%f,y:%f", new Object[] { Integer.valueOf(j), Float.valueOf(paramAnonymousMotionEvent.getX(j)), Float.valueOf(paramAnonymousMotionEvent.getY(j)) });
            if (paramAnonymousMotionEvent.getPointerCount() == 2)
            {
              this.yKf = ((float)(Math.pow(paramAnonymousMotionEvent.getX(0) - paramAnonymousMotionEvent.getX(1), 2.0D) + Math.pow(paramAnonymousMotionEvent.getY(0) - paramAnonymousMotionEvent.getY(1), 2.0D)));
              if (this.yKh)
              {
                this.yKh = false;
                ad.hp(ScanUIRectView.B(ScanUIRectView.this), 4);
                continue;
                float f;
                if (paramAnonymousMotionEvent.getPointerCount() == 2)
                {
                  com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.ScanUIRectView", "move,pointer:0,x:%f,y:%f", new Object[] { Float.valueOf(paramAnonymousMotionEvent.getX(0)), Float.valueOf(paramAnonymousMotionEvent.getY(0)) });
                  com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.ScanUIRectView", "move,pointer:1,x:%f,y:%f", new Object[] { Float.valueOf(paramAnonymousMotionEvent.getX(1)), Float.valueOf(paramAnonymousMotionEvent.getY(1)) });
                  f = (float)(Math.pow(paramAnonymousMotionEvent.getX(0) - paramAnonymousMotionEvent.getX(1), 2.0D) + Math.pow(paramAnonymousMotionEvent.getY(0) - paramAnonymousMotionEvent.getY(1), 2.0D));
                  com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.ScanUIRectView", "distance:%f,lastDistance:%f,min move:%f", new Object[] { Float.valueOf(f), Float.valueOf(this.yKf), Float.valueOf(this.yKg) });
                  if (Math.abs(f - this.yKf) > this.yKg)
                  {
                    if (ScanUIRectView.n(ScanUIRectView.this)) {
                      ScanUIRectView.G(ScanUIRectView.this);
                    }
                    if (f - this.yKf > 0.0F) {
                      ((com.tencent.scanlib.a.a)ScanUIRectView.H(ScanUIRectView.this)).ahs(2);
                    }
                    for (this.yKh = true;; this.yKh = true)
                    {
                      this.yKf = f;
                      break;
                      ((com.tencent.scanlib.a.a)ScanUIRectView.I(ScanUIRectView.this)).ahs(3);
                    }
                  }
                }
                else if ((paramAnonymousMotionEvent.getPointerCount() == 1) && (ScanUIRectView.D(ScanUIRectView.this)) && (!ScanUIRectView.E(ScanUIRectView.this)))
                {
                  f = paramAnonymousMotionEvent.getRawX() - ScanUIRectView.J(ScanUIRectView.this);
                  com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.ScanUIRectView", "alvinluo onTouchEvent offsetX: %f, canScrollSwitchTab: %b", new Object[] { Float.valueOf(f), Boolean.valueOf(ScanUIRectView.C(ScanUIRectView.this)) });
                  if ((f >= ScanUIRectView.K(ScanUIRectView.this)) && (ScanUIRectView.C(ScanUIRectView.this)))
                  {
                    if (ScanUIRectView.F(ScanUIRectView.this) != null) {
                      ScanUIRectView.F(ScanUIRectView.this).dPU();
                    }
                    ScanUIRectView.b(ScanUIRectView.this, false);
                  }
                  else if ((f <= -ScanUIRectView.K(ScanUIRectView.this)) && (ScanUIRectView.C(ScanUIRectView.this)))
                  {
                    if (ScanUIRectView.F(ScanUIRectView.this) != null) {
                      ScanUIRectView.F(ScanUIRectView.this).dPT();
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
    com.tencent.mm.sdk.b.a.IvT.c(this.yJW);
    if (this.yJL != null) {
      this.yJL.xgd = System.currentTimeMillis();
    }
    AppMethodBeat.o(51949);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(51955);
    super.onDestroy();
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.ScanUIRectView", "alvinluo releaseView");
    if (this.yDN != null) {
      this.yDN.release();
    }
    if (this.yDO != null)
    {
      localObject = this.yDO;
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.ScanSharedMaskView", "alvinluo release hashCode: %d", new Object[] { Integer.valueOf(((ScanSharedMaskView)localObject).hashCode()) });
      ((ScanSharedMaskView)localObject).dPW();
    }
    com.tencent.qbar.h.fYd().release();
    Object localObject = com.tencent.mm.plugin.scanner.c.a.dOf();
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.AiScanImageDecodeQueueNew", "alvinluo release");
    v.a(new a.3((com.tencent.mm.plugin.scanner.c.a)localObject));
    com.tencent.mm.sdk.b.a.IvT.d(this.yJW);
    removeCallbacks(this.yJR);
    this.yJR = null;
    if (this.yJL != null)
    {
      localObject = this.yJL;
      ((com.tencent.mm.plugin.scanner.util.g)localObject).yPP = System.currentTimeMillis();
      ((com.tencent.mm.plugin.scanner.util.g)localObject).dCI = (((com.tencent.mm.plugin.scanner.util.g)localObject).yPP - ((com.tencent.mm.plugin.scanner.util.g)localObject).xgd);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ScanRetryManager", "alvinluo exitScanUI stayTime: %d, isUpdated: %b, onPreviewFrameCalled: %b, isRetry: %b", new Object[] { Long.valueOf(((com.tencent.mm.plugin.scanner.util.g)localObject).dCI), Boolean.valueOf(((com.tencent.mm.plugin.scanner.util.g)localObject).yPK), Boolean.valueOf(((com.tencent.mm.plugin.scanner.util.g)localObject).yJQ), Boolean.valueOf(((com.tencent.mm.plugin.scanner.util.g)localObject).isRetry) });
      ad.a(((com.tencent.mm.plugin.scanner.util.g)localObject).yPL, ((com.tencent.mm.plugin.scanner.util.g)localObject).isRetry, ((com.tencent.mm.plugin.scanner.util.g)localObject).yJQ, ((com.tencent.mm.plugin.scanner.util.g)localObject).dCI);
      ad.g(((com.tencent.mm.plugin.scanner.util.g)localObject).yPL, ((com.tencent.mm.plugin.scanner.util.g)localObject).isRetry, ((com.tencent.mm.plugin.scanner.util.g)localObject).yPQ);
      if (!((com.tencent.mm.plugin.scanner.util.g)localObject).yPK) {
        break label288;
      }
      ((com.tencent.mm.plugin.scanner.util.g)localObject).zA(((com.tencent.mm.plugin.scanner.util.g)localObject).mTimeout);
    }
    for (;;)
    {
      if ((com.tencent.mm.plugin.scanner.util.o.PD(this.mode)) && (!this.yJH)) {
        ad.dOF();
      }
      AppMethodBeat.o(51955);
      return;
      label288:
      if (!((com.tencent.mm.plugin.scanner.util.g)localObject).yPK)
      {
        ((com.tencent.mm.plugin.scanner.util.g)localObject).mTimeout = ((com.tencent.mm.plugin.scanner.util.g)localObject).yPH;
        ((com.tencent.mm.plugin.scanner.util.g)localObject).zA(((com.tencent.mm.plugin.scanner.util.g)localObject).mTimeout);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ScanRetryManager", "alvinluo checkAndResetTimeout timeout not updated and reset to %d", new Object[] { Long.valueOf(((com.tencent.mm.plugin.scanner.util.g)localObject).mTimeout) });
      }
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(51953);
    super.onPause();
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ScanUIRectView", "alvinluo onPuase");
    dPy();
    if (this.yDN != null) {
      this.yDN.onPause();
    }
    dPq();
    if (this.hTg != null) {
      this.hTg.c(this.fHp);
    }
    AppMethodBeat.o(51953);
  }
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    AppMethodBeat.i(51973);
    super.onPreviewFrame(paramArrayOfByte, paramCamera);
    this.yJQ = true;
    boolean bool;
    int i;
    if (paramArrayOfByte == null)
    {
      bool = true;
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.ScanUIRectView", "onPreviewFrame null data: %b, isPreviewPaused: %b, canResumePreview: %b", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(this.yJJ), Boolean.valueOf(this.yJK) });
      if (this.yJM == 2) {
        if (this.yJL != null)
        {
          paramCamera = this.yJL;
          i = this.yJM;
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ScanRetryManager", "alvinluo cancelRetryType: %d", new Object[] { Integer.valueOf(i) });
          if (i != 1) {
            break label260;
          }
          paramCamera.yPM = false;
        }
      }
    }
    for (;;)
    {
      this.isRetry = false;
      removeCallbacks(this.yJR);
      if (this.yJL != null)
      {
        paramCamera = this.yJL;
        long l1 = System.currentTimeMillis();
        long l2 = this.yJN;
        if (!paramCamera.yPK)
        {
          paramCamera.yPK = true;
          l1 = ((float)(l1 - l2) * paramCamera.yPJ);
          paramCamera.mTimeout = Math.max(paramCamera.yPI, Math.min(paramCamera.yPH, l1));
        }
        this.yJL.yJQ = true;
      }
      if ((!this.yJJ) || (!this.yJK)) {
        break label273;
      }
      this.yJJ = false;
      this.yJK = false;
      qF(false);
      zy(100L);
      AppMethodBeat.o(51973);
      return;
      bool = false;
      break;
      label260:
      if (i == 2) {
        paramCamera.yPN = false;
      }
    }
    label273:
    if (paramArrayOfByte == null)
    {
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.ScanUIRectView", "alvinluo onPreviewFrame data is null");
      zy(0L);
      ad.dOE();
      AppMethodBeat.o(51973);
      return;
    }
    bG(paramArrayOfByte);
    AppMethodBeat.o(51973);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(51951);
    super.onResume();
    if (!this.MmA.isOpen())
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ScanUIRectView", "alvinluo onResume openCamera");
      a(null);
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ScanUIRectView", "onResume %s", new Object[] { bu.fpN() });
      this.yBt = System.currentTimeMillis();
      if (!com.tencent.mm.plugin.scanner.util.o.PD(this.mode)) {
        break label244;
      }
      com.tencent.qbar.h.fYd().a(this.yBt, this.yJU);
    }
    for (;;)
    {
      this.yJF = false;
      if (this.yDN != null) {
        this.yDN.onResume();
      }
      ar.o(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(51923);
          if ((ScanUIRectView.f(ScanUIRectView.this) != null) && (ScanUIRectView.f(ScanUIRectView.this).yzC))
          {
            AppMethodBeat.o(51923);
            return;
          }
          ScanCameraLightDetector.yPx.start(((com.tencent.mm.plugin.scanner.a.a)ScanUIRectView.g(ScanUIRectView.this)).getFocusMode());
          AppMethodBeat.o(51923);
        }
      }, 300L);
      this.yJK = true;
      AppMethodBeat.o(51951);
      return;
      if (!this.MmA.cOB())
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ScanUIRectView", "alvinluo onResume startPreview");
        ((com.tencent.mm.plugin.scanner.a.a)this.MmA).dNZ();
        a(new b.d.a()
        {
          public final void dPz()
          {
            AppMethodBeat.i(170017);
            ScanUIRectView.this.zy(0L);
            AppMethodBeat.o(170017);
          }
        });
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ScanUIRectView", "focus mode %s", new Object[] { this.MmA.getFocusMode() });
        break;
      }
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ScanUIRectView", "alvinluo onResume camera is previewing");
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ScanUIRectView", "focus mode %s", new Object[] { this.MmA.getFocusMode() });
      zy(0L);
      break;
      label244:
      if (this.mode == 12)
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ScanUIRectView", "alvinluo onResume currentNetworkAvailable: %b", new Object[] { Boolean.valueOf(this.yFH) });
        if (this.yFH)
        {
          com.tencent.mm.plugin.scanner.c.a locala = com.tencent.mm.plugin.scanner.c.a.dOf();
          long l = this.yBt;
          com.tencent.mm.plugin.scanner.c.a.a locala1 = this.yJV;
          synchronized (locala.yBn)
          {
            locala.yBt = l;
            locala.yBI = locala1;
            synchronized (locala.yBH)
            {
              if (locala.gff) {
                v.reset();
              }
            }
          }
        }
        com.tencent.mm.plugin.scanner.c.a.dOf().zt(this.yBt);
      }
    }
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(51954);
    super.onStop();
    axl();
    ScanCameraLightDetector.yPx.stop();
    AppMethodBeat.o(51954);
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(162395);
    super.onSurfaceTextureAvailable(paramSurfaceTexture, paramInt1, paramInt2);
    if ((this.rqj == null) || (paramInt1 != this.rqj.x) || (paramInt2 != this.rqj.y))
    {
      if (this.rqj == null) {
        this.rqj = new Point(paramInt1, paramInt2);
      }
      if (com.tencent.mm.plugin.scanner.util.o.PD(this.mode)) {
        dPx();
      }
    }
    AppMethodBeat.o(162395);
  }
  
  public final void qE(boolean paramBoolean)
  {
    boolean bool2 = true;
    AppMethodBeat.i(51969);
    com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.ScanUIRectView", "alvinluo onShowNoDataView show: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    Object localObject;
    boolean bool1;
    if (this.yDO != null)
    {
      localObject = this.yDO;
      if (!paramBoolean)
      {
        bool1 = true;
        ((ScanSharedMaskView)localObject).qP(bool1);
      }
    }
    else if (this.yDN != null)
    {
      localObject = this.yDN;
      if (paramBoolean) {
        break label90;
      }
    }
    label90:
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      ((BaseScanMaskView)localObject).qP(paramBoolean);
      AppMethodBeat.o(51969);
      return;
      bool1 = false;
      break;
    }
  }
  
  public final void qF(final boolean paramBoolean)
  {
    AppMethodBeat.i(170027);
    ad.Pc(this.mode);
    if (this.mode == 12) {
      ad.aw(1, System.currentTimeMillis());
    }
    if (Looper.getMainLooper().getThread() == Thread.currentThread())
    {
      qG(paramBoolean);
      AppMethodBeat.o(170027);
      return;
    }
    ar.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(170023);
        ScanUIRectView.a(ScanUIRectView.this, paramBoolean);
        AppMethodBeat.o(170023);
      }
    });
    AppMethodBeat.o(170027);
  }
  
  public final void refreshView()
  {
    AppMethodBeat.i(51961);
    this.yJx.setVisibility(8);
    dPt();
    dPw();
    dPs();
    AppMethodBeat.o(51961);
  }
  
  public void setActivity(Activity paramActivity)
  {
    this.activity = paramActivity;
  }
  
  public void setBlackInterval(int paramInt)
  {
    AppMethodBeat.i(170024);
    com.tencent.qbar.h localh = com.tencent.qbar.h.fYd();
    synchronized (localh.kLC)
    {
      if (localh.kLC.hasInited()) {
        localh.kLC.setBlackInterval(paramInt);
      }
      AppMethodBeat.o(170024);
      return;
    }
  }
  
  public void setBottomExtraHeight(int paramInt)
  {
    this.yJD = paramInt;
  }
  
  public void setDecodeSuccessFrameData(ScanDecodeFrameData paramScanDecodeFrameData)
  {
    AppMethodBeat.i(170026);
    if (this.yDN != null) {
      this.yDN.setDecodeSuccessFrameData(paramScanDecodeFrameData);
    }
    AppMethodBeat.o(170026);
  }
  
  public void setDecorRect(Rect paramRect)
  {
    AppMethodBeat.i(51977);
    this.yJx.setDecorRect(paramRect);
    AppMethodBeat.o(51977);
  }
  
  public void setEnableScanGoodsDynamicWording(boolean paramBoolean)
  {
    this.yFZ = paramBoolean;
  }
  
  public void setEnableScrollSwitchTab(boolean paramBoolean)
  {
    AppMethodBeat.i(51958);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ScanUIRectView", "alvinluo setEnableScrollSwitchTab: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.yJB = paramBoolean;
    AppMethodBeat.o(51958);
  }
  
  public void setFlashStatus(boolean paramBoolean)
  {
    AppMethodBeat.i(51966);
    if (this.yDO != null) {
      this.yDO.setFlashStatus(paramBoolean);
    }
    AppMethodBeat.o(51966);
  }
  
  public void setMyQrCodeVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(189509);
    if ((this.yDN instanceof ScanCodeMaskView)) {
      ((ScanCodeMaskView)this.yDN).setMyQrCodeButtonVisible(paramBoolean);
    }
    AppMethodBeat.o(189509);
  }
  
  public void setNetworkAvailable(boolean paramBoolean)
  {
    this.yFH = paramBoolean;
  }
  
  public void setScanCallback(a parama)
  {
    this.yJz = parama;
  }
  
  public void setScanCodeReaders(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(51979);
    com.tencent.qbar.h.fYd().L(paramArrayOfInt);
    AppMethodBeat.o(51979);
  }
  
  public void setScanMode(int paramInt)
  {
    this.mode = paramInt;
  }
  
  public void setScanRequest(BaseScanRequest paramBaseScanRequest)
  {
    this.yFP = paramBaseScanRequest;
  }
  
  public void setScanSource(int paramInt)
  {
    AppMethodBeat.i(51964);
    if (this.yDN != null) {
      this.yDN.setScanSource(paramInt);
    }
    AppMethodBeat.o(51964);
  }
  
  public void setScrollTabController(com.tencent.mm.plugin.scanner.ui.widget.b paramb)
  {
    this.yFy = paramb;
  }
  
  public void setShowScanTips(boolean paramBoolean)
  {
    this.yFG = paramBoolean;
  }
  
  public void setSuccessMarkClickListener(com.tencent.mm.plugin.scanner.model.ae paramae)
  {
    AppMethodBeat.i(170025);
    if ((this.yDN instanceof ScanCodeMaskView)) {
      ((ScanCodeMaskView)this.yDN).setSuccessMarkClickListener(paramae);
    }
    AppMethodBeat.o(170025);
  }
  
  public final void stopPreview()
  {
    AppMethodBeat.i(51956);
    super.stopPreview();
    this.yJJ = true;
    this.yJK = false;
    AppMethodBeat.o(51956);
  }
  
  public final void zy(long paramLong)
  {
    AppMethodBeat.i(51957);
    this.yJH = true;
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.ScanUIRectView", "alvinluo takeOneShot timeout: %d, isRetry: %b, onPreviewFrameCalled: %b, canReportOnPreviewFrame: %b, hasReport: %b", new Object[] { Long.valueOf(this.mTimeout), Boolean.valueOf(this.isRetry), Boolean.valueOf(this.yJQ), Boolean.valueOf(this.yJP), Boolean.valueOf(this.yJO) });
    if (!this.isRetry)
    {
      super.zy(paramLong);
      this.yJN = System.currentTimeMillis();
      if ((!this.yJQ) && (this.yJP) && (com.tencent.mm.plugin.scanner.util.o.PD(this.mode)))
      {
        removeCallbacks(this.yJR);
        postDelayed(this.yJR, this.mTimeout);
        AppMethodBeat.o(51957);
      }
    }
    else if ((this.yJL != null) && (this.yJL.PC(this.yJM)))
    {
      if (this.yJM == 1)
      {
        super.zy(paramLong);
        this.yJN = System.currentTimeMillis();
        AppMethodBeat.o(51957);
        return;
      }
      if (this.yJM == 2) {
        zz(paramLong);
      }
    }
    AppMethodBeat.o(51957);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ScanUIRectView
 * JD-Core Version:    0.7.0.1
 */
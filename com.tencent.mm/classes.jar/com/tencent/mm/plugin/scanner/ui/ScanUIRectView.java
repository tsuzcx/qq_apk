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
import com.tencent.mm.g.a.rq;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.plugin.scanner.c.a.3;
import com.tencent.mm.plugin.scanner.model.ScanPoint;
import com.tencent.mm.plugin.scanner.model.ae;
import com.tencent.mm.plugin.scanner.model.s;
import com.tencent.mm.plugin.scanner.model.t;
import com.tencent.mm.plugin.scanner.model.w;
import com.tencent.mm.plugin.scanner.model.x;
import com.tencent.mm.plugin.scanner.model.y;
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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.qbar.QbarNative.QBarPoint;
import com.tencent.qbar.ScanDecodeFrameData;
import com.tencent.qbar.WxQBarPoint;
import com.tencent.qbar.WxQBarResult;
import com.tencent.qbar.WxQbarNative.QBarReportMsg;
import com.tencent.qbar.h.c;
import com.tencent.scanlib.a.b.b.a;
import com.tencent.scanlib.a.b.c.a;
import com.tencent.scanlib.ui.ScanView;
import d.a.e;
import d.g.b.k;
import java.util.ArrayList;
import java.util.List;

public class ScanUIRectView
  extends ScanView
{
  public static final int vUU;
  private Activity activity;
  private com.tencent.mm.modelgeo.b.a fjJ;
  private d gXu;
  private GestureDetector hRv;
  private boolean isFirst;
  private boolean isRetry;
  private long mTimeout;
  int mode;
  private Point pPH;
  private boolean rMu;
  private boolean sVh;
  private float vLY;
  private long vNo;
  BaseScanMaskView vPj;
  private ScanSharedMaskView vPk;
  private ScannerFlashSwitcher vQG;
  private com.tencent.mm.plugin.scanner.ui.widget.b vQP;
  private boolean vQW;
  boolean vQX;
  private ScanRectDecorView vUK;
  ScanDebugView vUL;
  private a vUM;
  private boolean vUN;
  private boolean vUO;
  private int vUP;
  private int vUQ;
  private boolean vUR;
  private boolean vUS;
  private boolean vUT;
  private boolean vUV;
  private boolean vUW;
  private com.tencent.mm.plugin.scanner.util.g vUX;
  private int vUY;
  private long vUZ;
  private boolean vVa;
  private boolean vVb;
  private boolean vVc;
  private Runnable vVd;
  private int vVe;
  private int vVf;
  private h.c vVg;
  private com.tencent.mm.plugin.scanner.c.a.a vVh;
  private com.tencent.mm.sdk.b.c<rq> vVi;
  private long vVj;
  private b vVk;
  
  static
  {
    AppMethodBeat.i(51980);
    vUU = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pvF, 50);
    AppMethodBeat.o(51980);
  }
  
  public ScanUIRectView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(51945);
    this.mode = 1;
    this.vQW = true;
    this.vQX = false;
    this.vUN = true;
    this.vUO = false;
    this.vUP = 0;
    this.vUQ = 120;
    this.rMu = false;
    this.pPH = null;
    this.vUS = true;
    this.vUT = false;
    this.vUV = false;
    this.vUW = false;
    this.isFirst = true;
    this.vUX = new com.tencent.mm.plugin.scanner.util.g();
    this.vUY = 0;
    this.vUZ = 0L;
    this.mTimeout = this.vUX.mTimeout;
    this.vVa = false;
    this.vVb = true;
    this.vVc = false;
    this.isRetry = false;
    this.vVd = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(51916);
        if ((ScanUIRectView.a(ScanUIRectView.this)) && (!ScanUIRectView.b(ScanUIRectView.this)))
        {
          ScanUIRectView.c(ScanUIRectView.this);
          ScanUIRectView.d(ScanUIRectView.this);
          x.dlE();
          ScanUIRectView.e(ScanUIRectView.this);
        }
        AppMethodBeat.o(51916);
      }
    };
    this.vVe = 0;
    this.vVf = 0;
    this.vVg = new h.c()
    {
      public final void a(final long paramAnonymousLong, List<com.tencent.qbar.a.a> paramAnonymousList, final List<QbarNative.QBarPoint> paramAnonymousList1, final List<WxQbarNative.QBarReportMsg> paramAnonymousList2, final Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(195437);
        ad.d("MicroMsg.ScanUIRectView", String.format("scan code after decode %d", new Object[] { Long.valueOf(paramAnonymousLong) }));
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
              if ((ScanUIRectView.k(ScanUIRectView.this) == paramAnonymousLong) && (paramAnonymousLong != 0L))
              {
                ScanUIRectView.this.dmt();
                localArrayList = new ArrayList();
                if ((paramAnonymousList2 != null) && (!paramAnonymousList2.isEmpty()))
                {
                  ad.i("MicroMsg.ScanUIRectView", "alvinluo onDecodeSuccess result size: %d", new Object[] { Integer.valueOf(paramAnonymousList2.size()) });
                  j = 0;
                  i = 0;
                  if (j < paramAnonymousList2.size())
                  {
                    localObject1 = (com.tencent.qbar.a.a)paramAnonymousList2.get(j);
                    localObject1 = new WxQBarResult(((com.tencent.qbar.a.a)localObject1).typeID, ((com.tencent.qbar.a.a)localObject1).typeName, ((com.tencent.qbar.a.a)localObject1).data, ((com.tencent.qbar.a.a)localObject1).rawData, ((com.tencent.qbar.a.a)localObject1).charset, ((com.tencent.qbar.a.a)localObject1).priorityLevel);
                    ad.i("MicroMsg.ScanUIRectView", "alvinluo onDecodeSuccess result index: %d, format: %d, content:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(((WxQBarResult)localObject1).typeID), ((WxQBarResult)localObject1).data });
                    if ((paramAnonymousList1 != null) && (paramAnonymousList1.size() >= j + 1))
                    {
                      localObject2 = (WxQbarNative.QBarReportMsg)paramAnonymousList1.get(j);
                      if (localObject2 != null) {
                        ((WxQBarResult)localObject1).IoP = ((WxQbarNative.QBarReportMsg)localObject2).qrcodeVersion;
                      }
                    }
                    if ((paramAnonymousBundle == null) || (paramAnonymousBundle.size() < j + 1)) {
                      break label426;
                    }
                    Object localObject2 = (QbarNative.QBarPoint)paramAnonymousBundle.get(j);
                    if (localObject2 == null) {
                      break label426;
                    }
                    ((WxQBarResult)localObject1).Ipo = new WxQBarPoint((QbarNative.QBarPoint)localObject2);
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
                if (this.vVo != null) {
                  ((Bundle)localObject1).putAll(this.vVo);
                }
                ScanUIRectView.this.cjn();
                if (ScanUIRectView.l(ScanUIRectView.this) != null) {
                  ScanUIRectView.l(ScanUIRectView.this).e(ScanUIRectView.k(ScanUIRectView.this), (Bundle)localObject1);
                }
                AppMethodBeat.o(161010);
                return;
              }
            }
          });
        }
        AppMethodBeat.o(195437);
      }
      
      public final void ag(final long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(170011);
        ScanUIRectView.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(161009);
            if ((paramAnonymousLong1 == ScanUIRectView.k(ScanUIRectView.this)) && (paramAnonymousLong1 != 0L)) {
              ScanUIRectView.this.sb(this.syr);
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
            if ((paramAnonymousLong == ScanUIRectView.k(ScanUIRectView.this)) && (paramAnonymousLong != 0L) && (this.val$param.containsKey("param_zoom_ratio")))
            {
              float f = this.val$param.getFloat("param_zoom_ratio", 0.0F);
              ad.i("MicroMsg.ScanUIRectView", "zoom to scale %f", new Object[] { Float.valueOf(f) });
              if ((f > 0.0F) && (ScanUIRectView.m(ScanUIRectView.this)) && (ScanUIRectView.n(ScanUIRectView.this).cPP()))
              {
                int i = (int)(((com.tencent.scanlib.a.a)ScanUIRectView.o(ScanUIRectView.this)).fmF() * f);
                ((com.tencent.scanlib.a.a)ScanUIRectView.p(ScanUIRectView.this)).abP(i);
                com.tencent.qbar.c localc = com.tencent.qbar.c.IoG;
                localc.IoV += 1;
                localc.IoW *= f;
                localc.IoX = (System.currentTimeMillis() - localc.vPG);
                ad.v("MicroMsg.QBarEngineReporter", "alvinluo zoom %d, zoomFactor: %s, totalZoomFactor: %s, lastZoomCostTime: %d", new Object[] { Integer.valueOf(localc.IoV), Float.valueOf(f), Float.valueOf(localc.IoW), Long.valueOf(localc.IoX) });
              }
            }
            AppMethodBeat.o(170010);
          }
        });
        AppMethodBeat.o(170013);
      }
    };
    this.vVh = new com.tencent.mm.plugin.scanner.c.a.a()
    {
      public final void a(final long paramAnonymousLong, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(161016);
        ad.d("MicroMsg.ScanUIRectView", "alvinluo onDecodeSuccess %d", new Object[] { Long.valueOf(paramAnonymousLong) });
        if (paramAnonymousBundle.getBoolean("result_is_best_img", false)) {
          ScanUIRectView.this.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(161013);
              if ((paramAnonymousLong == ScanUIRectView.k(ScanUIRectView.this)) && (ScanUIRectView.k(ScanUIRectView.this) != 0L) && (ScanUIRectView.l(ScanUIRectView.this) != null)) {
                ScanUIRectView.l(ScanUIRectView.this).e(ScanUIRectView.k(ScanUIRectView.this), this.val$result);
              }
              AppMethodBeat.o(161013);
            }
          });
        }
        AppMethodBeat.o(161016);
      }
      
      public final void a(final w paramAnonymousw)
      {
        AppMethodBeat.i(161018);
        ScanUIRectView.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(161015);
            if ((paramAnonymousw != null) && ((ScanUIRectView.q(ScanUIRectView.this) instanceof ScanGoodsMaskView)))
            {
              ScanGoodsMaskView localScanGoodsMaskView = (ScanGoodsMaskView)ScanUIRectView.q(ScanUIRectView.this);
              w localw = paramAnonymousw;
              k.h(localw, "pointsResult");
              if (localScanGoodsMaskView.wbw)
              {
                ad.i("MicroMsg.ScanGoodsMaskView", "alvinluo addAnimationScanDots isViewDestroy");
                AppMethodBeat.o(161015);
                return;
              }
              ScanPoint[] arrayOfScanPoint = localw.points;
              if (arrayOfScanPoint != null)
              {
                ad.v("MicroMsg.ScanGoodsMaskView", "alvinluo addAnimationScanDots size: %d", new Object[] { Integer.valueOf(localw.pointCount) });
                int j = localw.pointCount;
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
                    ad.v("MicroMsg.ScanGoodsMaskView", "alvinluo getPointObjects id: %d, x: %f, y: %f", new Object[] { localObject1, localFloat, localObject2 });
                    i += 1;
                    break;
                    localObject1 = null;
                    break label149;
                    localFloat = null;
                    break label164;
                  }
                }
                Object localObject1 = localScanGoodsMaskView.vXf;
                if (localObject1 == null) {
                  k.aPZ("animationDotsView");
                }
                ((ScanAnimationDotsView)localObject1).b(localw);
              }
            }
            AppMethodBeat.o(161015);
          }
        });
        AppMethodBeat.o(161018);
      }
      
      public final void rX(final long paramAnonymousLong)
      {
        AppMethodBeat.i(161017);
        ad.d("MicroMsg.ScanUIRectView", "alvinluo postTakeShot session: %d, delay: %d", new Object[] { Long.valueOf(paramAnonymousLong), Long.valueOf(0L) });
        ScanUIRectView.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(161014);
            if ((ScanUIRectView.k(ScanUIRectView.this) == paramAnonymousLong) && (ScanUIRectView.k(ScanUIRectView.this) != 0L)) {
              ScanUIRectView.this.sb(this.syr);
            }
            AppMethodBeat.o(161014);
          }
        });
        AppMethodBeat.o(161017);
      }
    };
    this.fjJ = new com.tencent.mm.modelgeo.b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(161020);
        ad.i("MicroMsg.ScanUIRectView", "onGetLocation %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (!paramAnonymousBoolean)
        {
          ad.i("MicroMsg.ScanUIRectView", "check permission not passed!");
          if ((!ScanUIRectView.r(ScanUIRectView.this)) && (!d.axU()))
          {
            ScanUIRectView.s(ScanUIRectView.this);
            com.tencent.mm.ui.base.h.a(ScanUIRectView.this.getContext(), ScanUIRectView.this.getContext().getString(2131760082), ScanUIRectView.this.getContext().getString(2131755906), ScanUIRectView.this.getContext().getString(2131760598), ScanUIRectView.this.getContext().getString(2131755691), false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(161019);
                d.cv(ScanUIRectView.this.getContext());
                AppMethodBeat.o(161019);
              }
            }, null);
          }
          AppMethodBeat.o(161020);
          return true;
        }
        if (ScanUIRectView.t(ScanUIRectView.this))
        {
          ad.i("MicroMsg.ScanUIRectView", "ignore, has get lbs!");
          AppMethodBeat.o(161020);
          return false;
        }
        ScanUIRectView.this.cjn();
        ScanUIRectView.u(ScanUIRectView.this);
        com.tencent.mm.modelstat.o.a(2012, paramAnonymousFloat1, paramAnonymousFloat2, (int)paramAnonymousDouble2);
        if (ScanUIRectView.l(ScanUIRectView.this) != null)
        {
          Bundle localBundle = new Bundle();
          localBundle.putFloat("result_lbs_latitude", paramAnonymousFloat2);
          localBundle.putFloat("result_lbs_longitude", paramAnonymousFloat1);
          localBundle.putInt("result_lbs_accuracy", (int)paramAnonymousDouble2);
          localBundle.putInt("result_lbs_source", paramAnonymousInt);
          ScanUIRectView.l(ScanUIRectView.this).e(ScanUIRectView.k(ScanUIRectView.this), localBundle);
        }
        AppMethodBeat.o(161020);
        return false;
      }
    };
    this.vVi = new ScanUIRectView.5(this);
    this.hRv = new GestureDetector(new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(170014);
        ad.d("MicroMsg.ScanUIRectView", "double click,pointer:%d,x:%f,y:%f", new Object[] { Integer.valueOf(paramAnonymousMotionEvent.getActionIndex()), Float.valueOf(paramAnonymousMotionEvent.getX(paramAnonymousMotionEvent.getActionIndex())), Float.valueOf(paramAnonymousMotionEvent.getY(paramAnonymousMotionEvent.getActionIndex())) });
        ((com.tencent.scanlib.a.a)ScanUIRectView.z(ScanUIRectView.this)).abQ(5);
        x.gO(ScanUIRectView.A(ScanUIRectView.this), 3);
        AppMethodBeat.o(170014);
        return true;
      }
      
      public final boolean onFling(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(170015);
        ad.d("MicroMsg.ScanUIRectView", "alvinluo onFling velocityX: %f, velocityY: %f, canScrollSwitchTab: %b, enableScrollSwitchTab: %b, isMultiTouch: %b", new Object[] { Float.valueOf(paramAnonymousFloat1), Float.valueOf(paramAnonymousFloat2), Boolean.valueOf(ScanUIRectView.B(ScanUIRectView.this)), Boolean.valueOf(ScanUIRectView.C(ScanUIRectView.this)), Boolean.valueOf(ScanUIRectView.D(ScanUIRectView.this)) });
        if ((!ScanUIRectView.D(ScanUIRectView.this)) && (ScanUIRectView.C(ScanUIRectView.this)) && (Math.abs(paramAnonymousFloat1) > Math.abs(paramAnonymousFloat2)))
        {
          if ((paramAnonymousFloat1 >= -1200.0F) || (!ScanUIRectView.B(ScanUIRectView.this))) {
            break label168;
          }
          if (ScanUIRectView.E(ScanUIRectView.this) != null) {
            ScanUIRectView.E(ScanUIRectView.this).dmU();
          }
          ScanUIRectView.b(ScanUIRectView.this, false);
        }
        for (;;)
        {
          boolean bool = super.onFling(paramAnonymousMotionEvent1, paramAnonymousMotionEvent2, paramAnonymousFloat1, paramAnonymousFloat2);
          AppMethodBeat.o(170015);
          return bool;
          label168:
          if ((paramAnonymousFloat1 > 1200.0F) && (ScanUIRectView.B(ScanUIRectView.this)))
          {
            if (ScanUIRectView.E(ScanUIRectView.this) != null) {
              ScanUIRectView.E(ScanUIRectView.this).dmV();
            }
            ScanUIRectView.b(ScanUIRectView.this, false);
          }
        }
      }
    });
    this.vVk = new b(Looper.getMainLooper());
    AppMethodBeat.o(51945);
  }
  
  public ScanUIRectView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(51946);
    this.mode = 1;
    this.vQW = true;
    this.vQX = false;
    this.vUN = true;
    this.vUO = false;
    this.vUP = 0;
    this.vUQ = 120;
    this.rMu = false;
    this.pPH = null;
    this.vUS = true;
    this.vUT = false;
    this.vUV = false;
    this.vUW = false;
    this.isFirst = true;
    this.vUX = new com.tencent.mm.plugin.scanner.util.g();
    this.vUY = 0;
    this.vUZ = 0L;
    this.mTimeout = this.vUX.mTimeout;
    this.vVa = false;
    this.vVb = true;
    this.vVc = false;
    this.isRetry = false;
    this.vVd = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(51916);
        if ((ScanUIRectView.a(ScanUIRectView.this)) && (!ScanUIRectView.b(ScanUIRectView.this)))
        {
          ScanUIRectView.c(ScanUIRectView.this);
          ScanUIRectView.d(ScanUIRectView.this);
          x.dlE();
          ScanUIRectView.e(ScanUIRectView.this);
        }
        AppMethodBeat.o(51916);
      }
    };
    this.vVe = 0;
    this.vVf = 0;
    this.vVg = new h.c()
    {
      public final void a(final long paramAnonymousLong, List<com.tencent.qbar.a.a> paramAnonymousList, final List<QbarNative.QBarPoint> paramAnonymousList1, final List<WxQbarNative.QBarReportMsg> paramAnonymousList2, final Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(195437);
        ad.d("MicroMsg.ScanUIRectView", String.format("scan code after decode %d", new Object[] { Long.valueOf(paramAnonymousLong) }));
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
              if ((ScanUIRectView.k(ScanUIRectView.this) == paramAnonymousLong) && (paramAnonymousLong != 0L))
              {
                ScanUIRectView.this.dmt();
                localArrayList = new ArrayList();
                if ((paramAnonymousList2 != null) && (!paramAnonymousList2.isEmpty()))
                {
                  ad.i("MicroMsg.ScanUIRectView", "alvinluo onDecodeSuccess result size: %d", new Object[] { Integer.valueOf(paramAnonymousList2.size()) });
                  j = 0;
                  i = 0;
                  if (j < paramAnonymousList2.size())
                  {
                    localObject1 = (com.tencent.qbar.a.a)paramAnonymousList2.get(j);
                    localObject1 = new WxQBarResult(((com.tencent.qbar.a.a)localObject1).typeID, ((com.tencent.qbar.a.a)localObject1).typeName, ((com.tencent.qbar.a.a)localObject1).data, ((com.tencent.qbar.a.a)localObject1).rawData, ((com.tencent.qbar.a.a)localObject1).charset, ((com.tencent.qbar.a.a)localObject1).priorityLevel);
                    ad.i("MicroMsg.ScanUIRectView", "alvinluo onDecodeSuccess result index: %d, format: %d, content:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(((WxQBarResult)localObject1).typeID), ((WxQBarResult)localObject1).data });
                    if ((paramAnonymousList1 != null) && (paramAnonymousList1.size() >= j + 1))
                    {
                      localObject2 = (WxQbarNative.QBarReportMsg)paramAnonymousList1.get(j);
                      if (localObject2 != null) {
                        ((WxQBarResult)localObject1).IoP = ((WxQbarNative.QBarReportMsg)localObject2).qrcodeVersion;
                      }
                    }
                    if ((paramAnonymousBundle == null) || (paramAnonymousBundle.size() < j + 1)) {
                      break label426;
                    }
                    Object localObject2 = (QbarNative.QBarPoint)paramAnonymousBundle.get(j);
                    if (localObject2 == null) {
                      break label426;
                    }
                    ((WxQBarResult)localObject1).Ipo = new WxQBarPoint((QbarNative.QBarPoint)localObject2);
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
                if (this.vVo != null) {
                  ((Bundle)localObject1).putAll(this.vVo);
                }
                ScanUIRectView.this.cjn();
                if (ScanUIRectView.l(ScanUIRectView.this) != null) {
                  ScanUIRectView.l(ScanUIRectView.this).e(ScanUIRectView.k(ScanUIRectView.this), (Bundle)localObject1);
                }
                AppMethodBeat.o(161010);
                return;
              }
            }
          });
        }
        AppMethodBeat.o(195437);
      }
      
      public final void ag(final long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(170011);
        ScanUIRectView.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(161009);
            if ((paramAnonymousLong1 == ScanUIRectView.k(ScanUIRectView.this)) && (paramAnonymousLong1 != 0L)) {
              ScanUIRectView.this.sb(this.syr);
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
            if ((paramAnonymousLong == ScanUIRectView.k(ScanUIRectView.this)) && (paramAnonymousLong != 0L) && (this.val$param.containsKey("param_zoom_ratio")))
            {
              float f = this.val$param.getFloat("param_zoom_ratio", 0.0F);
              ad.i("MicroMsg.ScanUIRectView", "zoom to scale %f", new Object[] { Float.valueOf(f) });
              if ((f > 0.0F) && (ScanUIRectView.m(ScanUIRectView.this)) && (ScanUIRectView.n(ScanUIRectView.this).cPP()))
              {
                int i = (int)(((com.tencent.scanlib.a.a)ScanUIRectView.o(ScanUIRectView.this)).fmF() * f);
                ((com.tencent.scanlib.a.a)ScanUIRectView.p(ScanUIRectView.this)).abP(i);
                com.tencent.qbar.c localc = com.tencent.qbar.c.IoG;
                localc.IoV += 1;
                localc.IoW *= f;
                localc.IoX = (System.currentTimeMillis() - localc.vPG);
                ad.v("MicroMsg.QBarEngineReporter", "alvinluo zoom %d, zoomFactor: %s, totalZoomFactor: %s, lastZoomCostTime: %d", new Object[] { Integer.valueOf(localc.IoV), Float.valueOf(f), Float.valueOf(localc.IoW), Long.valueOf(localc.IoX) });
              }
            }
            AppMethodBeat.o(170010);
          }
        });
        AppMethodBeat.o(170013);
      }
    };
    this.vVh = new com.tencent.mm.plugin.scanner.c.a.a()
    {
      public final void a(final long paramAnonymousLong, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(161016);
        ad.d("MicroMsg.ScanUIRectView", "alvinluo onDecodeSuccess %d", new Object[] { Long.valueOf(paramAnonymousLong) });
        if (paramAnonymousBundle.getBoolean("result_is_best_img", false)) {
          ScanUIRectView.this.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(161013);
              if ((paramAnonymousLong == ScanUIRectView.k(ScanUIRectView.this)) && (ScanUIRectView.k(ScanUIRectView.this) != 0L) && (ScanUIRectView.l(ScanUIRectView.this) != null)) {
                ScanUIRectView.l(ScanUIRectView.this).e(ScanUIRectView.k(ScanUIRectView.this), this.val$result);
              }
              AppMethodBeat.o(161013);
            }
          });
        }
        AppMethodBeat.o(161016);
      }
      
      public final void a(final w paramAnonymousw)
      {
        AppMethodBeat.i(161018);
        ScanUIRectView.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(161015);
            if ((paramAnonymousw != null) && ((ScanUIRectView.q(ScanUIRectView.this) instanceof ScanGoodsMaskView)))
            {
              ScanGoodsMaskView localScanGoodsMaskView = (ScanGoodsMaskView)ScanUIRectView.q(ScanUIRectView.this);
              w localw = paramAnonymousw;
              k.h(localw, "pointsResult");
              if (localScanGoodsMaskView.wbw)
              {
                ad.i("MicroMsg.ScanGoodsMaskView", "alvinluo addAnimationScanDots isViewDestroy");
                AppMethodBeat.o(161015);
                return;
              }
              ScanPoint[] arrayOfScanPoint = localw.points;
              if (arrayOfScanPoint != null)
              {
                ad.v("MicroMsg.ScanGoodsMaskView", "alvinluo addAnimationScanDots size: %d", new Object[] { Integer.valueOf(localw.pointCount) });
                int j = localw.pointCount;
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
                    ad.v("MicroMsg.ScanGoodsMaskView", "alvinluo getPointObjects id: %d, x: %f, y: %f", new Object[] { localObject1, localFloat, localObject2 });
                    i += 1;
                    break;
                    localObject1 = null;
                    break label149;
                    localFloat = null;
                    break label164;
                  }
                }
                Object localObject1 = localScanGoodsMaskView.vXf;
                if (localObject1 == null) {
                  k.aPZ("animationDotsView");
                }
                ((ScanAnimationDotsView)localObject1).b(localw);
              }
            }
            AppMethodBeat.o(161015);
          }
        });
        AppMethodBeat.o(161018);
      }
      
      public final void rX(final long paramAnonymousLong)
      {
        AppMethodBeat.i(161017);
        ad.d("MicroMsg.ScanUIRectView", "alvinluo postTakeShot session: %d, delay: %d", new Object[] { Long.valueOf(paramAnonymousLong), Long.valueOf(0L) });
        ScanUIRectView.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(161014);
            if ((ScanUIRectView.k(ScanUIRectView.this) == paramAnonymousLong) && (ScanUIRectView.k(ScanUIRectView.this) != 0L)) {
              ScanUIRectView.this.sb(this.syr);
            }
            AppMethodBeat.o(161014);
          }
        });
        AppMethodBeat.o(161017);
      }
    };
    this.fjJ = new com.tencent.mm.modelgeo.b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(161020);
        ad.i("MicroMsg.ScanUIRectView", "onGetLocation %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (!paramAnonymousBoolean)
        {
          ad.i("MicroMsg.ScanUIRectView", "check permission not passed!");
          if ((!ScanUIRectView.r(ScanUIRectView.this)) && (!d.axU()))
          {
            ScanUIRectView.s(ScanUIRectView.this);
            com.tencent.mm.ui.base.h.a(ScanUIRectView.this.getContext(), ScanUIRectView.this.getContext().getString(2131760082), ScanUIRectView.this.getContext().getString(2131755906), ScanUIRectView.this.getContext().getString(2131760598), ScanUIRectView.this.getContext().getString(2131755691), false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(161019);
                d.cv(ScanUIRectView.this.getContext());
                AppMethodBeat.o(161019);
              }
            }, null);
          }
          AppMethodBeat.o(161020);
          return true;
        }
        if (ScanUIRectView.t(ScanUIRectView.this))
        {
          ad.i("MicroMsg.ScanUIRectView", "ignore, has get lbs!");
          AppMethodBeat.o(161020);
          return false;
        }
        ScanUIRectView.this.cjn();
        ScanUIRectView.u(ScanUIRectView.this);
        com.tencent.mm.modelstat.o.a(2012, paramAnonymousFloat1, paramAnonymousFloat2, (int)paramAnonymousDouble2);
        if (ScanUIRectView.l(ScanUIRectView.this) != null)
        {
          Bundle localBundle = new Bundle();
          localBundle.putFloat("result_lbs_latitude", paramAnonymousFloat2);
          localBundle.putFloat("result_lbs_longitude", paramAnonymousFloat1);
          localBundle.putInt("result_lbs_accuracy", (int)paramAnonymousDouble2);
          localBundle.putInt("result_lbs_source", paramAnonymousInt);
          ScanUIRectView.l(ScanUIRectView.this).e(ScanUIRectView.k(ScanUIRectView.this), localBundle);
        }
        AppMethodBeat.o(161020);
        return false;
      }
    };
    this.vVi = new ScanUIRectView.5(this);
    this.hRv = new GestureDetector(new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(170014);
        ad.d("MicroMsg.ScanUIRectView", "double click,pointer:%d,x:%f,y:%f", new Object[] { Integer.valueOf(paramAnonymousMotionEvent.getActionIndex()), Float.valueOf(paramAnonymousMotionEvent.getX(paramAnonymousMotionEvent.getActionIndex())), Float.valueOf(paramAnonymousMotionEvent.getY(paramAnonymousMotionEvent.getActionIndex())) });
        ((com.tencent.scanlib.a.a)ScanUIRectView.z(ScanUIRectView.this)).abQ(5);
        x.gO(ScanUIRectView.A(ScanUIRectView.this), 3);
        AppMethodBeat.o(170014);
        return true;
      }
      
      public final boolean onFling(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(170015);
        ad.d("MicroMsg.ScanUIRectView", "alvinluo onFling velocityX: %f, velocityY: %f, canScrollSwitchTab: %b, enableScrollSwitchTab: %b, isMultiTouch: %b", new Object[] { Float.valueOf(paramAnonymousFloat1), Float.valueOf(paramAnonymousFloat2), Boolean.valueOf(ScanUIRectView.B(ScanUIRectView.this)), Boolean.valueOf(ScanUIRectView.C(ScanUIRectView.this)), Boolean.valueOf(ScanUIRectView.D(ScanUIRectView.this)) });
        if ((!ScanUIRectView.D(ScanUIRectView.this)) && (ScanUIRectView.C(ScanUIRectView.this)) && (Math.abs(paramAnonymousFloat1) > Math.abs(paramAnonymousFloat2)))
        {
          if ((paramAnonymousFloat1 >= -1200.0F) || (!ScanUIRectView.B(ScanUIRectView.this))) {
            break label168;
          }
          if (ScanUIRectView.E(ScanUIRectView.this) != null) {
            ScanUIRectView.E(ScanUIRectView.this).dmU();
          }
          ScanUIRectView.b(ScanUIRectView.this, false);
        }
        for (;;)
        {
          boolean bool = super.onFling(paramAnonymousMotionEvent1, paramAnonymousMotionEvent2, paramAnonymousFloat1, paramAnonymousFloat2);
          AppMethodBeat.o(170015);
          return bool;
          label168:
          if ((paramAnonymousFloat1 > 1200.0F) && (ScanUIRectView.B(ScanUIRectView.this)))
          {
            if (ScanUIRectView.E(ScanUIRectView.this) != null) {
              ScanUIRectView.E(ScanUIRectView.this).dmV();
            }
            ScanUIRectView.b(ScanUIRectView.this, false);
          }
        }
      }
    });
    this.vVk = new b(Looper.getMainLooper());
    AppMethodBeat.o(51946);
  }
  
  public ScanUIRectView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(51947);
    this.mode = 1;
    this.vQW = true;
    this.vQX = false;
    this.vUN = true;
    this.vUO = false;
    this.vUP = 0;
    this.vUQ = 120;
    this.rMu = false;
    this.pPH = null;
    this.vUS = true;
    this.vUT = false;
    this.vUV = false;
    this.vUW = false;
    this.isFirst = true;
    this.vUX = new com.tencent.mm.plugin.scanner.util.g();
    this.vUY = 0;
    this.vUZ = 0L;
    this.mTimeout = this.vUX.mTimeout;
    this.vVa = false;
    this.vVb = true;
    this.vVc = false;
    this.isRetry = false;
    this.vVd = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(51916);
        if ((ScanUIRectView.a(ScanUIRectView.this)) && (!ScanUIRectView.b(ScanUIRectView.this)))
        {
          ScanUIRectView.c(ScanUIRectView.this);
          ScanUIRectView.d(ScanUIRectView.this);
          x.dlE();
          ScanUIRectView.e(ScanUIRectView.this);
        }
        AppMethodBeat.o(51916);
      }
    };
    this.vVe = 0;
    this.vVf = 0;
    this.vVg = new h.c()
    {
      public final void a(final long paramAnonymousLong, List<com.tencent.qbar.a.a> paramAnonymousList, final List<QbarNative.QBarPoint> paramAnonymousList1, final List<WxQbarNative.QBarReportMsg> paramAnonymousList2, final Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(195437);
        ad.d("MicroMsg.ScanUIRectView", String.format("scan code after decode %d", new Object[] { Long.valueOf(paramAnonymousLong) }));
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
              if ((ScanUIRectView.k(ScanUIRectView.this) == paramAnonymousLong) && (paramAnonymousLong != 0L))
              {
                ScanUIRectView.this.dmt();
                localArrayList = new ArrayList();
                if ((paramAnonymousList2 != null) && (!paramAnonymousList2.isEmpty()))
                {
                  ad.i("MicroMsg.ScanUIRectView", "alvinluo onDecodeSuccess result size: %d", new Object[] { Integer.valueOf(paramAnonymousList2.size()) });
                  j = 0;
                  i = 0;
                  if (j < paramAnonymousList2.size())
                  {
                    localObject1 = (com.tencent.qbar.a.a)paramAnonymousList2.get(j);
                    localObject1 = new WxQBarResult(((com.tencent.qbar.a.a)localObject1).typeID, ((com.tencent.qbar.a.a)localObject1).typeName, ((com.tencent.qbar.a.a)localObject1).data, ((com.tencent.qbar.a.a)localObject1).rawData, ((com.tencent.qbar.a.a)localObject1).charset, ((com.tencent.qbar.a.a)localObject1).priorityLevel);
                    ad.i("MicroMsg.ScanUIRectView", "alvinluo onDecodeSuccess result index: %d, format: %d, content:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(((WxQBarResult)localObject1).typeID), ((WxQBarResult)localObject1).data });
                    if ((paramAnonymousList1 != null) && (paramAnonymousList1.size() >= j + 1))
                    {
                      localObject2 = (WxQbarNative.QBarReportMsg)paramAnonymousList1.get(j);
                      if (localObject2 != null) {
                        ((WxQBarResult)localObject1).IoP = ((WxQbarNative.QBarReportMsg)localObject2).qrcodeVersion;
                      }
                    }
                    if ((paramAnonymousBundle == null) || (paramAnonymousBundle.size() < j + 1)) {
                      break label426;
                    }
                    Object localObject2 = (QbarNative.QBarPoint)paramAnonymousBundle.get(j);
                    if (localObject2 == null) {
                      break label426;
                    }
                    ((WxQBarResult)localObject1).Ipo = new WxQBarPoint((QbarNative.QBarPoint)localObject2);
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
                if (this.vVo != null) {
                  ((Bundle)localObject1).putAll(this.vVo);
                }
                ScanUIRectView.this.cjn();
                if (ScanUIRectView.l(ScanUIRectView.this) != null) {
                  ScanUIRectView.l(ScanUIRectView.this).e(ScanUIRectView.k(ScanUIRectView.this), (Bundle)localObject1);
                }
                AppMethodBeat.o(161010);
                return;
              }
            }
          });
        }
        AppMethodBeat.o(195437);
      }
      
      public final void ag(final long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(170011);
        ScanUIRectView.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(161009);
            if ((paramAnonymousLong1 == ScanUIRectView.k(ScanUIRectView.this)) && (paramAnonymousLong1 != 0L)) {
              ScanUIRectView.this.sb(this.syr);
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
            if ((paramAnonymousLong == ScanUIRectView.k(ScanUIRectView.this)) && (paramAnonymousLong != 0L) && (this.val$param.containsKey("param_zoom_ratio")))
            {
              float f = this.val$param.getFloat("param_zoom_ratio", 0.0F);
              ad.i("MicroMsg.ScanUIRectView", "zoom to scale %f", new Object[] { Float.valueOf(f) });
              if ((f > 0.0F) && (ScanUIRectView.m(ScanUIRectView.this)) && (ScanUIRectView.n(ScanUIRectView.this).cPP()))
              {
                int i = (int)(((com.tencent.scanlib.a.a)ScanUIRectView.o(ScanUIRectView.this)).fmF() * f);
                ((com.tencent.scanlib.a.a)ScanUIRectView.p(ScanUIRectView.this)).abP(i);
                com.tencent.qbar.c localc = com.tencent.qbar.c.IoG;
                localc.IoV += 1;
                localc.IoW *= f;
                localc.IoX = (System.currentTimeMillis() - localc.vPG);
                ad.v("MicroMsg.QBarEngineReporter", "alvinluo zoom %d, zoomFactor: %s, totalZoomFactor: %s, lastZoomCostTime: %d", new Object[] { Integer.valueOf(localc.IoV), Float.valueOf(f), Float.valueOf(localc.IoW), Long.valueOf(localc.IoX) });
              }
            }
            AppMethodBeat.o(170010);
          }
        });
        AppMethodBeat.o(170013);
      }
    };
    this.vVh = new com.tencent.mm.plugin.scanner.c.a.a()
    {
      public final void a(final long paramAnonymousLong, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(161016);
        ad.d("MicroMsg.ScanUIRectView", "alvinluo onDecodeSuccess %d", new Object[] { Long.valueOf(paramAnonymousLong) });
        if (paramAnonymousBundle.getBoolean("result_is_best_img", false)) {
          ScanUIRectView.this.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(161013);
              if ((paramAnonymousLong == ScanUIRectView.k(ScanUIRectView.this)) && (ScanUIRectView.k(ScanUIRectView.this) != 0L) && (ScanUIRectView.l(ScanUIRectView.this) != null)) {
                ScanUIRectView.l(ScanUIRectView.this).e(ScanUIRectView.k(ScanUIRectView.this), this.val$result);
              }
              AppMethodBeat.o(161013);
            }
          });
        }
        AppMethodBeat.o(161016);
      }
      
      public final void a(final w paramAnonymousw)
      {
        AppMethodBeat.i(161018);
        ScanUIRectView.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(161015);
            if ((paramAnonymousw != null) && ((ScanUIRectView.q(ScanUIRectView.this) instanceof ScanGoodsMaskView)))
            {
              ScanGoodsMaskView localScanGoodsMaskView = (ScanGoodsMaskView)ScanUIRectView.q(ScanUIRectView.this);
              w localw = paramAnonymousw;
              k.h(localw, "pointsResult");
              if (localScanGoodsMaskView.wbw)
              {
                ad.i("MicroMsg.ScanGoodsMaskView", "alvinluo addAnimationScanDots isViewDestroy");
                AppMethodBeat.o(161015);
                return;
              }
              ScanPoint[] arrayOfScanPoint = localw.points;
              if (arrayOfScanPoint != null)
              {
                ad.v("MicroMsg.ScanGoodsMaskView", "alvinluo addAnimationScanDots size: %d", new Object[] { Integer.valueOf(localw.pointCount) });
                int j = localw.pointCount;
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
                    ad.v("MicroMsg.ScanGoodsMaskView", "alvinluo getPointObjects id: %d, x: %f, y: %f", new Object[] { localObject1, localFloat, localObject2 });
                    i += 1;
                    break;
                    localObject1 = null;
                    break label149;
                    localFloat = null;
                    break label164;
                  }
                }
                Object localObject1 = localScanGoodsMaskView.vXf;
                if (localObject1 == null) {
                  k.aPZ("animationDotsView");
                }
                ((ScanAnimationDotsView)localObject1).b(localw);
              }
            }
            AppMethodBeat.o(161015);
          }
        });
        AppMethodBeat.o(161018);
      }
      
      public final void rX(final long paramAnonymousLong)
      {
        AppMethodBeat.i(161017);
        ad.d("MicroMsg.ScanUIRectView", "alvinluo postTakeShot session: %d, delay: %d", new Object[] { Long.valueOf(paramAnonymousLong), Long.valueOf(0L) });
        ScanUIRectView.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(161014);
            if ((ScanUIRectView.k(ScanUIRectView.this) == paramAnonymousLong) && (ScanUIRectView.k(ScanUIRectView.this) != 0L)) {
              ScanUIRectView.this.sb(this.syr);
            }
            AppMethodBeat.o(161014);
          }
        });
        AppMethodBeat.o(161017);
      }
    };
    this.fjJ = new com.tencent.mm.modelgeo.b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(161020);
        ad.i("MicroMsg.ScanUIRectView", "onGetLocation %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (!paramAnonymousBoolean)
        {
          ad.i("MicroMsg.ScanUIRectView", "check permission not passed!");
          if ((!ScanUIRectView.r(ScanUIRectView.this)) && (!d.axU()))
          {
            ScanUIRectView.s(ScanUIRectView.this);
            com.tencent.mm.ui.base.h.a(ScanUIRectView.this.getContext(), ScanUIRectView.this.getContext().getString(2131760082), ScanUIRectView.this.getContext().getString(2131755906), ScanUIRectView.this.getContext().getString(2131760598), ScanUIRectView.this.getContext().getString(2131755691), false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(161019);
                d.cv(ScanUIRectView.this.getContext());
                AppMethodBeat.o(161019);
              }
            }, null);
          }
          AppMethodBeat.o(161020);
          return true;
        }
        if (ScanUIRectView.t(ScanUIRectView.this))
        {
          ad.i("MicroMsg.ScanUIRectView", "ignore, has get lbs!");
          AppMethodBeat.o(161020);
          return false;
        }
        ScanUIRectView.this.cjn();
        ScanUIRectView.u(ScanUIRectView.this);
        com.tencent.mm.modelstat.o.a(2012, paramAnonymousFloat1, paramAnonymousFloat2, (int)paramAnonymousDouble2);
        if (ScanUIRectView.l(ScanUIRectView.this) != null)
        {
          Bundle localBundle = new Bundle();
          localBundle.putFloat("result_lbs_latitude", paramAnonymousFloat2);
          localBundle.putFloat("result_lbs_longitude", paramAnonymousFloat1);
          localBundle.putInt("result_lbs_accuracy", (int)paramAnonymousDouble2);
          localBundle.putInt("result_lbs_source", paramAnonymousInt);
          ScanUIRectView.l(ScanUIRectView.this).e(ScanUIRectView.k(ScanUIRectView.this), localBundle);
        }
        AppMethodBeat.o(161020);
        return false;
      }
    };
    this.vVi = new ScanUIRectView.5(this);
    this.hRv = new GestureDetector(new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(170014);
        ad.d("MicroMsg.ScanUIRectView", "double click,pointer:%d,x:%f,y:%f", new Object[] { Integer.valueOf(paramAnonymousMotionEvent.getActionIndex()), Float.valueOf(paramAnonymousMotionEvent.getX(paramAnonymousMotionEvent.getActionIndex())), Float.valueOf(paramAnonymousMotionEvent.getY(paramAnonymousMotionEvent.getActionIndex())) });
        ((com.tencent.scanlib.a.a)ScanUIRectView.z(ScanUIRectView.this)).abQ(5);
        x.gO(ScanUIRectView.A(ScanUIRectView.this), 3);
        AppMethodBeat.o(170014);
        return true;
      }
      
      public final boolean onFling(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(170015);
        ad.d("MicroMsg.ScanUIRectView", "alvinluo onFling velocityX: %f, velocityY: %f, canScrollSwitchTab: %b, enableScrollSwitchTab: %b, isMultiTouch: %b", new Object[] { Float.valueOf(paramAnonymousFloat1), Float.valueOf(paramAnonymousFloat2), Boolean.valueOf(ScanUIRectView.B(ScanUIRectView.this)), Boolean.valueOf(ScanUIRectView.C(ScanUIRectView.this)), Boolean.valueOf(ScanUIRectView.D(ScanUIRectView.this)) });
        if ((!ScanUIRectView.D(ScanUIRectView.this)) && (ScanUIRectView.C(ScanUIRectView.this)) && (Math.abs(paramAnonymousFloat1) > Math.abs(paramAnonymousFloat2)))
        {
          if ((paramAnonymousFloat1 >= -1200.0F) || (!ScanUIRectView.B(ScanUIRectView.this))) {
            break label168;
          }
          if (ScanUIRectView.E(ScanUIRectView.this) != null) {
            ScanUIRectView.E(ScanUIRectView.this).dmU();
          }
          ScanUIRectView.b(ScanUIRectView.this, false);
        }
        for (;;)
        {
          boolean bool = super.onFling(paramAnonymousMotionEvent1, paramAnonymousMotionEvent2, paramAnonymousFloat1, paramAnonymousFloat2);
          AppMethodBeat.o(170015);
          return bool;
          label168:
          if ((paramAnonymousFloat1 > 1200.0F) && (ScanUIRectView.B(ScanUIRectView.this)))
          {
            if (ScanUIRectView.E(ScanUIRectView.this) != null) {
              ScanUIRectView.E(ScanUIRectView.this).dmV();
            }
            ScanUIRectView.b(ScanUIRectView.this, false);
          }
        }
      }
    });
    this.vVk = new b(Looper.getMainLooper());
    AppMethodBeat.o(51947);
  }
  
  private void bx(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(161043);
    if ((this.ItZ.cPP()) && (((com.tencent.mm.plugin.scanner.a.a)this.ItZ).dlj())) {
      ScanCameraLightDetector.wap.B(paramArrayOfByte, ((com.tencent.mm.plugin.scanner.a.a)this.ItZ).fmC().x, ((com.tencent.mm.plugin.scanner.a.a)this.ItZ).fmC().y);
    }
    switch (this.mode)
    {
    default: 
      ad.i("MicroMsg.ScanUIRectView", "unknown scan mode %d", new Object[] { Integer.valueOf(this.mode) });
      AppMethodBeat.o(161043);
      return;
    case 1: 
    case 4: 
    case 8: 
      by(paramArrayOfByte);
      AppMethodBeat.o(161043);
      return;
    }
    bz(paramArrayOfByte);
    AppMethodBeat.o(161043);
  }
  
  private void by(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(161044);
    Object localObject;
    Rect localRect1;
    if ((this.vNo != 0L) && (this.ItZ.cPP()))
    {
      localObject = this.ItZ.fmC();
      if (localObject != null)
      {
        localRect1 = getScanCodeRect();
        if ((this.isRetry) && (this.vUY != 1)) {
          break label198;
        }
        Rect localRect2 = ((com.tencent.mm.plugin.scanner.a.a)this.ItZ).t(localRect1);
        if (this.vPj != null)
        {
          this.vPj.setPreviewRect(localRect2);
          this.vPj.setScanRect(localRect1);
          if ((this.vPj instanceof ScanCodeMaskView)) {
            ((ScanCodeMaskView)this.vPj).setNeedRotate(true);
          }
        }
        com.tencent.qbar.h.flW().a(paramArrayOfByte, (Point)localObject, this.ItZ.getCameraRotation(), localRect2);
      }
    }
    for (;;)
    {
      if ((!((com.tencent.scanlib.a.a)this.ItZ).dms()) && (com.tencent.qbar.h.flW().vNr > vUU))
      {
        ad.i("MicroMsg.ScanUIRectView", "change to FOCUS_MODE_AUTO");
        this.ItZ.setFocusMode("auto");
        xh(100L);
      }
      AppMethodBeat.o(161044);
      return;
      label198:
      if ((this.isRetry) && (this.vUY == 2))
      {
        localObject = new Rect(0, 0, this.vVe, this.vVf);
        if (this.vPj != null)
        {
          this.vPj.setPreviewRect((Rect)localObject);
          this.vPj.setScanRect(localRect1);
          if ((this.vPj instanceof ScanCodeMaskView)) {
            ((ScanCodeMaskView)this.vPj).setNeedRotate(false);
          }
        }
        com.tencent.qbar.h.flW().a(paramArrayOfByte, new Point(this.vVe, this.vVf), 0, (Rect)localObject);
      }
    }
  }
  
  private void bz(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(161045);
    if (this.vNo != 0L) {
      synchronized (this.ItZ)
      {
        if (this.ItZ.cPP())
        {
          Point localPoint = this.ItZ.fmC();
          com.tencent.mm.plugin.scanner.c.a.dln().a(paramArrayOfByte, localPoint, this.ItZ.getCameraRotation(), ((com.tencent.mm.plugin.scanner.a.a)this.ItZ).getPreviewFormat());
        }
        AppMethodBeat.o(161045);
        return;
      }
    }
    AppMethodBeat.o(161045);
  }
  
  private void dmA()
  {
    AppMethodBeat.i(162394);
    if (com.tencent.qbar.f.flT())
    {
      ad.i("MicroMsg.ScanUIRectView", "alvinluo updateScanCodeRect visibleResolution: %s", new Object[] { this.pPH });
      if ((this.pPH != null) && (this.pPH.x > 0) && (this.pPH.y > 0))
      {
        this.vUK.setDecorRect(new Rect(0, (int)(this.pPH.y * 1.0F / 19.0F), this.pPH.x, (int)(this.pPH.y * 17.0F / 19.0F)));
        AppMethodBeat.o(162394);
      }
    }
    else
    {
      this.vUK.gT(getResources().getDimensionPixelSize(2131166761), getResources().getDimensionPixelSize(2131166760));
    }
    AppMethodBeat.o(162394);
  }
  
  private void dmB()
  {
    AppMethodBeat.i(160188);
    if (this.vVd != null) {
      removeCallbacks(this.vVd);
    }
    AppMethodBeat.o(160188);
  }
  
  private byte[] dmu()
  {
    AppMethodBeat.i(161042);
    for (;;)
    {
      int i;
      try
      {
        l1 = System.currentTimeMillis();
        k = this.aST.getWidth();
        int m = this.aST.getHeight();
        i = m;
        j = k;
        if (this.vUX == null) {
          break label300;
        }
        i = m;
        j = k;
        if (this.vUX.waG == 0.0F) {
          break label300;
        }
        j = (int)(this.aST.getWidth() * this.vUX.waG);
        i = (int)(this.aST.getHeight() * this.vUX.waG);
      }
      catch (Exception localException)
      {
        long l1;
        Object localObject;
        long l2;
        ad.printErrStackTrace("MicroMsg.ScanUIRectView", localException, "alvinluo generateFrameByTextureView exception", new Object[0]);
        AppMethodBeat.o(161042);
        return null;
      }
      localObject = this.aST.getBitmap(k, j);
      ad.d("MicroMsg.ScanUIRectView", "alvinluo generateFrameByTextureView getBitmap cost: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
      {
        this.vVe = ((Bitmap)localObject).getWidth();
        this.vVf = ((Bitmap)localObject).getHeight();
        ad.d("MicroMsg.ScanUIRectView", "alvinluo generateFrameByTextureView bitmap width: %d, height: %d", new Object[] { Integer.valueOf(this.vVe), Integer.valueOf(this.vVf) });
        l1 = System.currentTimeMillis();
        localObject = l.a(this.vVe, this.vVf, (Bitmap)localObject);
        l2 = System.currentTimeMillis();
        if (localObject != null)
        {
          i = localObject.length;
          ad.d("MicroMsg.ScanUIRectView", "alvinluo generateFrameByTextureView yuvData: %d, getNV21 cost: %d", new Object[] { Integer.valueOf(i), Long.valueOf(l2 - l1) });
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
  
  private void dmv()
  {
    AppMethodBeat.i(51960);
    ad.d("MicroMsg.ScanUIRectView", "alvinluo createScanMaskView mode: %d, bottomHeight: %d", new Object[] { Integer.valueOf(this.mode), Integer.valueOf(this.vUP) });
    Object localObject1;
    switch (this.mode)
    {
    default: 
      ad.i("MicroMsg.ScanUIRectView", "unknown scan mode %d", new Object[] { Integer.valueOf(this.mode) });
      if ((this.vPj == null) || (this.vPk == null)) {
        break label589;
      }
      this.vPj.setBottomExtraHeight(this.vUP);
      localObject1 = this.vPj;
      localObject2 = this.activity;
      k.h(localObject2, "activity");
      ((BaseScanMaskView)localObject1).activity = ((Activity)localObject2);
      this.vPj.ek(this.vQG);
      if ((this.ItZ instanceof com.tencent.mm.plugin.scanner.a.a)) {
        this.vPj.vTX = ((com.tencent.mm.plugin.scanner.a.a)this.ItZ);
      }
      this.vPj.o(this.vPk.getScanTipsView());
      this.vPj.em(this.vPk.getGalleryButton());
      if (this.vQG != null) {
        setFlashStatus(this.vQG.cEL);
      }
      if (this.isFirst)
      {
        this.vPk.setShowTitle(false);
        this.isFirst = false;
        label263:
        this.vPj.dmJ();
        localObject1 = this.vPk;
        ad.i("MicroMsg.ScanSharedMaskView", "alvinluo onViewReady hashCode: %d", new Object[] { Integer.valueOf(((ScanSharedMaskView)localObject1).hashCode()) });
        if (((ScanSharedMaskView)localObject1).vZK) {
          break label461;
        }
        localObject2 = ((ScanSharedMaskView)localObject1).vZC;
        if (localObject2 == null) {
          k.aPZ("scanTips");
        }
        if (!((ScanSharedMaskView)localObject1).vZJ) {
          break label456;
        }
      }
      break;
    }
    label456:
    for (int i = 8;; i = 0)
    {
      ((TextView)localObject2).setVisibility(i);
      localObject1 = ((ScanSharedMaskView)localObject1).vZB;
      if (localObject1 == null) {
        k.aPZ("scanTitle");
      }
      ((TextView)localObject1).setVisibility(8);
      AppMethodBeat.o(51960);
      return;
      dmA();
      this.vPj = new ScanCodeMaskView(getContext());
      addView(this.vPj);
      break;
      this.vPj = new ScanTranslationMaskView(getContext());
      addView(this.vPj);
      break;
      this.vPj = new ScanGoodsMaskView(getContext());
      addView(this.vPj);
      break;
      this.vPk.setShowTitle(true);
      break label263;
    }
    label461:
    Object localObject2 = ((ScanSharedMaskView)localObject1).vZC;
    if (localObject2 == null) {
      k.aPZ("scanTips");
    }
    ((TextView)localObject2).setVisibility(8);
    localObject2 = ((ScanSharedMaskView)localObject1).vZB;
    if (localObject2 == null) {
      k.aPZ("scanTitle");
    }
    if (((TextView)localObject2).getVisibility() != 0)
    {
      localObject2 = ((ScanSharedMaskView)localObject1).vZB;
      if (localObject2 == null) {
        k.aPZ("scanTitle");
      }
      ((TextView)localObject2).setVisibility(8);
      localObject2 = ((ScanSharedMaskView)localObject1).vZB;
      if (localObject2 == null) {
        k.aPZ("scanTitle");
      }
      ((TextView)localObject2).setAlpha(1.0F);
      ((ScanSharedMaskView)localObject1).dmY();
      ((ScanSharedMaskView)localObject1).pi(true);
      AppMethodBeat.o(51960);
      return;
    }
    localObject2 = ((ScanSharedMaskView)localObject1).vZB;
    if (localObject2 == null) {
      k.aPZ("scanTitle");
    }
    ((TextView)localObject2).setAlpha(1.0F);
    ((ScanSharedMaskView)localObject1).dmY();
    ((ScanSharedMaskView)localObject1).dmW();
    label589:
    AppMethodBeat.o(51960);
  }
  
  private void dmw()
  {
    AppMethodBeat.i(51962);
    String str = getScanTips();
    this.vPk.setScanTips(str);
    switch (this.mode)
    {
    default: 
      ad.e("MicroMsg.ScanUIRectView", "alvinluo refreshSharedMaskView unknown scan mode %d", new Object[] { Integer.valueOf(this.mode) });
      AppMethodBeat.o(51962);
      return;
    case 1: 
    case 4: 
    case 8: 
      this.vPk.setScanTitle(getResources().getString(2131762809));
      AppMethodBeat.o(51962);
      return;
    case 3: 
      this.vPk.setScanTitle(getResources().getString(2131762808));
      AppMethodBeat.o(51962);
      return;
    }
    this.vPk.setScanTitle(getResources().getString(2131762804));
    AppMethodBeat.o(51962);
  }
  
  private void dmz()
  {
    AppMethodBeat.i(51970);
    if (this.vPj != null)
    {
      final BaseScanMaskView localBaseScanMaskView = this.vPj;
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
  
  private Rect getScanCodeRect()
  {
    int j = 0;
    AppMethodBeat.i(51975);
    if (com.tencent.qbar.f.flT())
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
    if (!this.vQW)
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
    String str = getResources().getString(2131762823);
    AppMethodBeat.o(51963);
    return str;
  }
  
  private void pd(boolean paramBoolean)
  {
    AppMethodBeat.i(51974);
    if (this.vPj != null) {
      this.vPj.pd(paramBoolean);
    }
    if (this.vPk != null) {
      this.vPk.pd(paramBoolean);
    }
    if (this.vUL != null) {
      this.vUL.setVisibility(8);
    }
    AppMethodBeat.o(51974);
  }
  
  private void sc(long paramLong)
  {
    AppMethodBeat.i(161046);
    long l1 = System.currentTimeMillis() - this.vVj;
    if (l1 > Iua)
    {
      this.vVk.removeMessages(0);
      this.vVk.sendEmptyMessageDelayed(0, paramLong);
      AppMethodBeat.o(161046);
      return;
    }
    long l2 = Iua;
    this.vVk.removeMessages(0);
    this.vVk.sendEmptyMessageDelayed(0, l2 - l1 + paramLong);
    AppMethodBeat.o(161046);
  }
  
  public final void a(final b.b.a parama)
  {
    AppMethodBeat.i(161041);
    super.a(new b.b.a()
    {
      public final void dmD()
      {
        AppMethodBeat.i(161029);
        ScanUIRectView.g(ScanUIRectView.this);
        if (parama != null) {
          parama.dmD();
        }
        AppMethodBeat.o(161029);
      }
    });
    AppMethodBeat.o(161041);
  }
  
  public final void a(Object paramObject, com.tencent.mm.plugin.scanner.view.c paramc)
  {
    AppMethodBeat.i(51971);
    ad.i("MicroMsg.ScanUIRectView", "alvinluo onScanSuccess");
    dmB();
    onPause();
    stopPreview();
    if (this.vPj != null)
    {
      this.vPj.a(paramObject, paramc);
      this.vPj.el(this.aST);
    }
    if (this.vPk != null)
    {
      paramObject = this.vPk;
      ad.v("MicroMsg.ScanSharedMaskView", "alvinluo onScanSuccess");
      paramc = paramObject.vZE;
      if (paramc == null) {
        k.aPZ("galleryButton");
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
      paramObject.dmY();
      paramc = paramObject.vZB;
      if (paramc == null) {
        k.aPZ("scanTitle");
      }
      paramc.setVisibility(8);
      paramObject.vZJ = false;
      paramObject = paramObject.vQG;
      if (paramObject == null) {
        k.aPZ("flashSwitcher");
      }
      paramObject.setVisibility(8);
    }
    if ((com.tencent.mm.plugin.scanner.util.o.Lu(this.mode)) && (this.vUX != null)) {
      this.vUX.waJ = true;
    }
    AppMethodBeat.o(51971);
  }
  
  public final void a(boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(51965);
    if (this.vPj != null) {
      this.vPj.a(paramBoolean, paramOnCancelListener);
    }
    AppMethodBeat.o(51965);
  }
  
  public final void cjn()
  {
    AppMethodBeat.i(51978);
    if ((this.vPj != null) && ((this.vPj instanceof ScanCodeMaskView))) {
      ((ScanCodeMaskView)this.vPj).cjn();
    }
    AppMethodBeat.o(51978);
  }
  
  public final void dmr()
  {
    AppMethodBeat.i(51948);
    this.ItZ = new com.tencent.mm.plugin.scanner.a.a();
    AppMethodBeat.o(51948);
  }
  
  public final boolean dms()
  {
    AppMethodBeat.i(51950);
    if (this.ItZ != null)
    {
      boolean bool = ((com.tencent.scanlib.a.a)this.ItZ).dms();
      AppMethodBeat.o(51950);
      return bool;
    }
    AppMethodBeat.o(51950);
    return false;
  }
  
  public final void dmt()
  {
    AppMethodBeat.i(51952);
    ad.i("MicroMsg.ScanUIRectView", "alvinluo stopCurrentSession %d", new Object[] { Long.valueOf(this.vNo) });
    com.tencent.qbar.h.flW().rW(this.vNo);
    com.tencent.mm.plugin.scanner.c.a.dln().rW(this.vNo);
    this.vNo = 0L;
    AppMethodBeat.o(51952);
  }
  
  public final void dmx()
  {
    AppMethodBeat.i(51967);
    if ((this.vPk != null) && (!this.vQG.cEL)) {
      this.vPk.pj(true);
    }
    AppMethodBeat.o(51967);
  }
  
  public final void dmy()
  {
    AppMethodBeat.i(51968);
    if ((this.vPk != null) && (this.vQG.cEL)) {
      this.vPk.pj(false);
    }
    AppMethodBeat.o(51968);
  }
  
  public Rect getDecorRect()
  {
    AppMethodBeat.i(51976);
    Rect localRect = this.vUK.getDecorRect();
    AppMethodBeat.o(51976);
    return localRect;
  }
  
  public com.tencent.scanlib.a.f getScanCamera()
  {
    return this.ItZ;
  }
  
  public BaseScanMaskView getScanMaskView()
  {
    return this.vPj;
  }
  
  public ScanSharedMaskView getSharedMaskView()
  {
    return this.vPk;
  }
  
  public final void init()
  {
    AppMethodBeat.i(51959);
    super.init();
    this.vUK = new ScanRectDecorView(getContext());
    addView(this.vUK, new FrameLayout.LayoutParams(-1, -1));
    this.vPk = new ScanSharedMaskView(getContext());
    this.vQG = this.vPk.getFlashSwitcherView();
    addView(this.vPk, new FrameLayout.LayoutParams(-1, -1));
    dmw();
    AppMethodBeat.o(51959);
  }
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    AppMethodBeat.i(51972);
    ad.i("MicroMsg.ScanUIRectView", "onAutoFocus %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.vVb = false;
      sb(0L);
    }
    xh(Iuc);
    AppMethodBeat.o(51972);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(51949);
    super.onCreate();
    this.vUQ = ((int)(com.tencent.mm.cd.a.hV(getContext()) / 4.5F));
    if (com.tencent.mm.plugin.scanner.util.o.Lu(this.mode)) {
      com.tencent.qbar.h.flW().init(getContext());
    }
    com.tencent.qbar.h.flW().Ipq = new ae();
    setOnTouchListener(new View.OnTouchListener()
    {
      private float vVs;
      private float vVt = 400.0F;
      private boolean vVu = false;
      
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(170016);
        int i = paramAnonymousMotionEvent.getActionMasked();
        int j = paramAnonymousMotionEvent.getActionIndex();
        ad.d("MicroMsg.ScanUIRectView", "pointIndex:%d, action: %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
        switch (i)
        {
        }
        for (;;)
        {
          ScanUIRectView.K(ScanUIRectView.this).onTouchEvent(paramAnonymousMotionEvent);
          if (paramAnonymousMotionEvent.getAction() == 1) {
            ScanUIRectView.c(ScanUIRectView.this, false);
          }
          AppMethodBeat.o(170016);
          return true;
          ad.d("MicroMsg.ScanUIRectView", "first down,pointer:%d,x:%f,y:%f", new Object[] { Integer.valueOf(j), Float.valueOf(paramAnonymousMotionEvent.getX()), Float.valueOf(paramAnonymousMotionEvent.getY()) });
          ScanUIRectView.a(ScanUIRectView.this, paramAnonymousMotionEvent.getRawX());
          ScanUIRectView.b(ScanUIRectView.this, true);
          this.vVu = false;
          continue;
          ad.d("MicroMsg.ScanUIRectView", "down,pointer:%d,x:%f,y:%f", new Object[] { Integer.valueOf(j), Float.valueOf(paramAnonymousMotionEvent.getX(j)), Float.valueOf(paramAnonymousMotionEvent.getY(j)) });
          if (paramAnonymousMotionEvent.getPointerCount() == 2)
          {
            this.vVs = ((float)(Math.pow(paramAnonymousMotionEvent.getX(0) - paramAnonymousMotionEvent.getX(1), 2.0D) + Math.pow(paramAnonymousMotionEvent.getY(0) - paramAnonymousMotionEvent.getY(1), 2.0D)));
            ScanUIRectView.c(ScanUIRectView.this, true);
          }
          this.vVu = false;
          continue;
          ad.d("MicroMsg.ScanUIRectView", "last up,pointer:%d,x:%f,y:%f", new Object[] { Integer.valueOf(j), Float.valueOf(paramAnonymousMotionEvent.getX()), Float.valueOf(paramAnonymousMotionEvent.getY()) });
          if (paramAnonymousMotionEvent.getPointerCount() == 2)
          {
            this.vVs = ((float)(Math.pow(paramAnonymousMotionEvent.getX(0) - paramAnonymousMotionEvent.getX(1), 2.0D) + Math.pow(paramAnonymousMotionEvent.getY(0) - paramAnonymousMotionEvent.getY(1), 2.0D)));
            continue;
            ad.d("MicroMsg.ScanUIRectView", "up,pointer:%d,x:%f,y:%f", new Object[] { Integer.valueOf(j), Float.valueOf(paramAnonymousMotionEvent.getX(j)), Float.valueOf(paramAnonymousMotionEvent.getY(j)) });
            if (paramAnonymousMotionEvent.getPointerCount() == 2)
            {
              this.vVs = ((float)(Math.pow(paramAnonymousMotionEvent.getX(0) - paramAnonymousMotionEvent.getX(1), 2.0D) + Math.pow(paramAnonymousMotionEvent.getY(0) - paramAnonymousMotionEvent.getY(1), 2.0D)));
              if (this.vVu)
              {
                this.vVu = false;
                x.gO(ScanUIRectView.A(ScanUIRectView.this), 4);
                continue;
                float f;
                if (paramAnonymousMotionEvent.getPointerCount() == 2)
                {
                  ad.d("MicroMsg.ScanUIRectView", "move,pointer:0,x:%f,y:%f", new Object[] { Float.valueOf(paramAnonymousMotionEvent.getX(0)), Float.valueOf(paramAnonymousMotionEvent.getY(0)) });
                  ad.d("MicroMsg.ScanUIRectView", "move,pointer:1,x:%f,y:%f", new Object[] { Float.valueOf(paramAnonymousMotionEvent.getX(1)), Float.valueOf(paramAnonymousMotionEvent.getY(1)) });
                  f = (float)(Math.pow(paramAnonymousMotionEvent.getX(0) - paramAnonymousMotionEvent.getX(1), 2.0D) + Math.pow(paramAnonymousMotionEvent.getY(0) - paramAnonymousMotionEvent.getY(1), 2.0D));
                  ad.d("MicroMsg.ScanUIRectView", "distance:%f,lastDistance:%f,min move:%f", new Object[] { Float.valueOf(f), Float.valueOf(this.vVs), Float.valueOf(this.vVt) });
                  if (Math.abs(f - this.vVs) > this.vVt)
                  {
                    if (ScanUIRectView.m(ScanUIRectView.this)) {
                      ScanUIRectView.F(ScanUIRectView.this);
                    }
                    if (f - this.vVs > 0.0F) {
                      ((com.tencent.scanlib.a.a)ScanUIRectView.G(ScanUIRectView.this)).abQ(2);
                    }
                    for (this.vVu = true;; this.vVu = true)
                    {
                      this.vVs = f;
                      break;
                      ((com.tencent.scanlib.a.a)ScanUIRectView.H(ScanUIRectView.this)).abQ(3);
                    }
                  }
                }
                else if ((paramAnonymousMotionEvent.getPointerCount() == 1) && (ScanUIRectView.C(ScanUIRectView.this)) && (!ScanUIRectView.D(ScanUIRectView.this)))
                {
                  f = paramAnonymousMotionEvent.getRawX() - ScanUIRectView.I(ScanUIRectView.this);
                  ad.v("MicroMsg.ScanUIRectView", "alvinluo onTouchEvent offsetX: %f, canScrollSwitchTab: %b", new Object[] { Float.valueOf(f), Boolean.valueOf(ScanUIRectView.B(ScanUIRectView.this)) });
                  if ((f >= ScanUIRectView.J(ScanUIRectView.this)) && (ScanUIRectView.B(ScanUIRectView.this)))
                  {
                    if (ScanUIRectView.E(ScanUIRectView.this) != null) {
                      ScanUIRectView.E(ScanUIRectView.this).dmV();
                    }
                    ScanUIRectView.b(ScanUIRectView.this, false);
                  }
                  else if ((f <= -ScanUIRectView.J(ScanUIRectView.this)) && (ScanUIRectView.B(ScanUIRectView.this)))
                  {
                    if (ScanUIRectView.E(ScanUIRectView.this) != null) {
                      ScanUIRectView.E(ScanUIRectView.this).dmU();
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
    com.tencent.mm.sdk.b.a.ESL.c(this.vVi);
    if (this.vUX != null) {
      this.vUX.waH = System.currentTimeMillis();
    }
    AppMethodBeat.o(51949);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(51955);
    super.onDestroy();
    ad.d("MicroMsg.ScanUIRectView", "alvinluo releaseView");
    if (this.vPj != null) {
      this.vPj.release();
    }
    if (this.vPk != null)
    {
      localObject = this.vPk;
      ad.d("MicroMsg.ScanSharedMaskView", "alvinluo release hashCode: %d", new Object[] { Integer.valueOf(((ScanSharedMaskView)localObject).hashCode()) });
      ((ScanSharedMaskView)localObject).dmX();
    }
    com.tencent.qbar.h.flW().release();
    Object localObject = com.tencent.mm.plugin.scanner.c.a.dln();
    ad.i("MicroMsg.AiScanImageDecodeQueueNew", "alvinluo release");
    s.a(new a.3((com.tencent.mm.plugin.scanner.c.a)localObject));
    com.tencent.mm.sdk.b.a.ESL.d(this.vVi);
    removeCallbacks(this.vVd);
    this.vVd = null;
    if (this.vUX != null)
    {
      localObject = this.vUX;
      ((com.tencent.mm.plugin.scanner.util.g)localObject).waI = System.currentTimeMillis();
      ((com.tencent.mm.plugin.scanner.util.g)localObject).dsf = (((com.tencent.mm.plugin.scanner.util.g)localObject).waI - ((com.tencent.mm.plugin.scanner.util.g)localObject).waH);
      ad.i("MicroMsg.ScanRetryManager", "alvinluo exitScanUI stayTime: %d, isUpdated: %b, onPreviewFrameCalled: %b, isRetry: %b", new Object[] { Long.valueOf(((com.tencent.mm.plugin.scanner.util.g)localObject).dsf), Boolean.valueOf(((com.tencent.mm.plugin.scanner.util.g)localObject).waC), Boolean.valueOf(((com.tencent.mm.plugin.scanner.util.g)localObject).vVc), Boolean.valueOf(((com.tencent.mm.plugin.scanner.util.g)localObject).isRetry) });
      x.a(((com.tencent.mm.plugin.scanner.util.g)localObject).waD, ((com.tencent.mm.plugin.scanner.util.g)localObject).isRetry, ((com.tencent.mm.plugin.scanner.util.g)localObject).vVc, ((com.tencent.mm.plugin.scanner.util.g)localObject).dsf);
      x.f(((com.tencent.mm.plugin.scanner.util.g)localObject).waD, ((com.tencent.mm.plugin.scanner.util.g)localObject).isRetry, ((com.tencent.mm.plugin.scanner.util.g)localObject).waJ);
      if (!((com.tencent.mm.plugin.scanner.util.g)localObject).waC) {
        break label288;
      }
      ((com.tencent.mm.plugin.scanner.util.g)localObject).sd(((com.tencent.mm.plugin.scanner.util.g)localObject).mTimeout);
    }
    for (;;)
    {
      if ((com.tencent.mm.plugin.scanner.util.o.Lu(this.mode)) && (!this.vUT)) {
        x.dlG();
      }
      AppMethodBeat.o(51955);
      return;
      label288:
      if (!((com.tencent.mm.plugin.scanner.util.g)localObject).waC)
      {
        ((com.tencent.mm.plugin.scanner.util.g)localObject).mTimeout = ((com.tencent.mm.plugin.scanner.util.g)localObject).waz;
        ((com.tencent.mm.plugin.scanner.util.g)localObject).sd(((com.tencent.mm.plugin.scanner.util.g)localObject).mTimeout);
        ad.i("MicroMsg.ScanRetryManager", "alvinluo checkAndResetTimeout timeout not updated and reset to %d", new Object[] { Long.valueOf(((com.tencent.mm.plugin.scanner.util.g)localObject).mTimeout) });
      }
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(51953);
    super.onPause();
    ad.i("MicroMsg.ScanUIRectView", "alvinluo onPuase");
    dmB();
    if (this.vPj != null) {
      this.vPj.onPause();
    }
    dmt();
    if (this.gXu != null) {
      this.gXu.c(this.fjJ);
    }
    AppMethodBeat.o(51953);
  }
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    AppMethodBeat.i(51973);
    super.onPreviewFrame(paramArrayOfByte, paramCamera);
    this.vVc = true;
    boolean bool;
    int i;
    if (paramArrayOfByte == null)
    {
      bool = true;
      ad.d("MicroMsg.ScanUIRectView", "onPreviewFrame null data: %b, isPreviewPaused: %b, canResumePreview: %b", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(this.vUV), Boolean.valueOf(this.vUW) });
      if (this.vUY == 2) {
        if (this.vUX != null)
        {
          paramCamera = this.vUX;
          i = this.vUY;
          ad.i("MicroMsg.ScanRetryManager", "alvinluo cancelRetryType: %d", new Object[] { Integer.valueOf(i) });
          if (i != 1) {
            break label260;
          }
          paramCamera.waE = false;
        }
      }
    }
    for (;;)
    {
      this.isRetry = false;
      removeCallbacks(this.vVd);
      if (this.vUX != null)
      {
        paramCamera = this.vUX;
        long l1 = System.currentTimeMillis();
        long l2 = this.vUZ;
        if (!paramCamera.waC)
        {
          paramCamera.waC = true;
          l1 = ((float)(l1 - l2) * paramCamera.waB);
          paramCamera.mTimeout = Math.max(paramCamera.waA, Math.min(paramCamera.waz, l1));
        }
        this.vUX.vVc = true;
      }
      if ((!this.vUV) || (!this.vUW)) {
        break label273;
      }
      this.vUV = false;
      this.vUW = false;
      pc(false);
      sb(100L);
      AppMethodBeat.o(51973);
      return;
      bool = false;
      break;
      label260:
      if (i == 2) {
        paramCamera.waF = false;
      }
    }
    label273:
    if (paramArrayOfByte == null)
    {
      ad.w("MicroMsg.ScanUIRectView", "alvinluo onPreviewFrame data is null");
      sb(0L);
      x.dlF();
      AppMethodBeat.o(51973);
      return;
    }
    bx(paramArrayOfByte);
    AppMethodBeat.o(51973);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(51951);
    super.onResume();
    if (!this.ItZ.isOpen())
    {
      ad.i("MicroMsg.ScanUIRectView", "alvinluo onResume openCamera");
      a(null);
      ad.i("MicroMsg.ScanUIRectView", "onResume %s", new Object[] { bt.eGN() });
      this.vNo = System.currentTimeMillis();
      if (!com.tencent.mm.plugin.scanner.util.o.Lu(this.mode)) {
        break label244;
      }
      com.tencent.qbar.h.flW().a(this.vNo, this.vVg);
    }
    for (;;)
    {
      this.vUR = false;
      if (this.vPj != null) {
        this.vPj.onResume();
      }
      aq.n(new ScanUIRectView.9(this), 300L);
      this.vUW = true;
      AppMethodBeat.o(51951);
      return;
      if (!this.ItZ.cPP())
      {
        ad.i("MicroMsg.ScanUIRectView", "alvinluo onResume startPreview");
        ((com.tencent.mm.plugin.scanner.a.a)this.ItZ).dlh();
        a(new ScanUIRectView.8(this));
        ad.i("MicroMsg.ScanUIRectView", "focus mode %s", new Object[] { this.ItZ.getFocusMode() });
        break;
      }
      ad.i("MicroMsg.ScanUIRectView", "alvinluo onResume camera is previewing");
      ad.i("MicroMsg.ScanUIRectView", "focus mode %s", new Object[] { this.ItZ.getFocusMode() });
      sb(0L);
      break;
      label244:
      if (this.mode == 12)
      {
        ad.i("MicroMsg.ScanUIRectView", "alvinluo onResume currentNetworkAvailable: %b", new Object[] { Boolean.valueOf(this.vQX) });
        if (this.vQX)
        {
          com.tencent.mm.plugin.scanner.c.a locala = com.tencent.mm.plugin.scanner.c.a.dln();
          long l = this.vNo;
          com.tencent.mm.plugin.scanner.c.a.a locala1 = this.vVh;
          synchronized (locala.vNi)
          {
            locala.vNo = l;
            locala.vND = locala1;
            synchronized (locala.vNC)
            {
              if (locala.fFP) {
                s.reset();
              }
            }
          }
        }
        com.tencent.mm.plugin.scanner.c.a.dln().rW(this.vNo);
      }
    }
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(51954);
    super.onStop();
    anq();
    ScanCameraLightDetector.wap.stop();
    AppMethodBeat.o(51954);
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(162395);
    super.onSurfaceTextureAvailable(paramSurfaceTexture, paramInt1, paramInt2);
    if ((this.pPH == null) || (paramInt1 != this.pPH.x) || (paramInt2 != this.pPH.y))
    {
      if (this.pPH == null) {
        this.pPH = new Point(paramInt1, paramInt2);
      }
      if (com.tencent.mm.plugin.scanner.util.o.Lu(this.mode)) {
        dmA();
      }
    }
    AppMethodBeat.o(162395);
  }
  
  public final void pb(boolean paramBoolean)
  {
    boolean bool2 = true;
    AppMethodBeat.i(51969);
    ad.v("MicroMsg.ScanUIRectView", "alvinluo onShowNoDataView show: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    Object localObject;
    boolean bool1;
    if (this.vPk != null)
    {
      localObject = this.vPk;
      if (!paramBoolean)
      {
        bool1 = true;
        ((ScanSharedMaskView)localObject).pk(bool1);
      }
    }
    else if (this.vPj != null)
    {
      localObject = this.vPj;
      if (paramBoolean) {
        break label90;
      }
    }
    label90:
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      ((BaseScanMaskView)localObject).pk(paramBoolean);
      AppMethodBeat.o(51969);
      return;
      bool1 = false;
      break;
    }
  }
  
  public final void pc(final boolean paramBoolean)
  {
    AppMethodBeat.i(170027);
    x.KS(this.mode);
    if (this.mode == 12) {
      x.ar(1, System.currentTimeMillis());
    }
    if (Looper.getMainLooper().getThread() == Thread.currentThread())
    {
      pd(paramBoolean);
      AppMethodBeat.o(170027);
      return;
    }
    aq.f(new Runnable()
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
    this.vUK.setVisibility(8);
    dmw();
    dmz();
    dmv();
    AppMethodBeat.o(51961);
  }
  
  public final void sb(long paramLong)
  {
    AppMethodBeat.i(51957);
    this.vUT = true;
    ad.d("MicroMsg.ScanUIRectView", "alvinluo takeOneShot timeout: %d, isRetry: %b, onPreviewFrameCalled: %b, canReportOnPreviewFrame: %b, hasReport: %b", new Object[] { Long.valueOf(this.mTimeout), Boolean.valueOf(this.isRetry), Boolean.valueOf(this.vVc), Boolean.valueOf(this.vVb), Boolean.valueOf(this.vVa) });
    if (!this.isRetry)
    {
      super.sb(paramLong);
      this.vUZ = System.currentTimeMillis();
      if ((!this.vVc) && (this.vVb) && (com.tencent.mm.plugin.scanner.util.o.Lu(this.mode)))
      {
        removeCallbacks(this.vVd);
        postDelayed(this.vVd, this.mTimeout);
        AppMethodBeat.o(51957);
      }
    }
    else if ((this.vUX != null) && (this.vUX.Lt(this.vUY)))
    {
      if (this.vUY == 1)
      {
        super.sb(paramLong);
        this.vUZ = System.currentTimeMillis();
        AppMethodBeat.o(51957);
        return;
      }
      if (this.vUY == 2) {
        sc(paramLong);
      }
    }
    AppMethodBeat.o(51957);
  }
  
  public void setActivity(Activity paramActivity)
  {
    this.activity = paramActivity;
  }
  
  public void setBlackInterval(int paramInt)
  {
    AppMethodBeat.i(170024);
    com.tencent.qbar.h localh = com.tencent.qbar.h.flW();
    synchronized (localh.jMM)
    {
      if (localh.jMM.hasInited()) {
        localh.jMM.setBlackInterval(paramInt);
      }
      AppMethodBeat.o(170024);
      return;
    }
  }
  
  public void setBottomExtraHeight(int paramInt)
  {
    this.vUP = paramInt;
  }
  
  public void setDecodeSuccessFrameData(ScanDecodeFrameData paramScanDecodeFrameData)
  {
    AppMethodBeat.i(170026);
    if (this.vPj != null) {
      this.vPj.setDecodeSuccessFrameData(paramScanDecodeFrameData);
    }
    AppMethodBeat.o(170026);
  }
  
  public void setDecorRect(Rect paramRect)
  {
    AppMethodBeat.i(51977);
    this.vUK.setDecorRect(paramRect);
    AppMethodBeat.o(51977);
  }
  
  public void setEnableScrollSwitchTab(boolean paramBoolean)
  {
    AppMethodBeat.i(51958);
    ad.i("MicroMsg.ScanUIRectView", "alvinluo setEnableScrollSwitchTab: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.vUN = paramBoolean;
    AppMethodBeat.o(51958);
  }
  
  public void setFlashStatus(boolean paramBoolean)
  {
    AppMethodBeat.i(51966);
    if (this.vPk != null) {
      this.vPk.setFlashStatus(paramBoolean);
    }
    AppMethodBeat.o(51966);
  }
  
  public void setNetworkAvailable(boolean paramBoolean)
  {
    this.vQX = paramBoolean;
  }
  
  public void setScanCallback(a parama)
  {
    this.vUM = parama;
  }
  
  public void setScanCodeReaders(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(51979);
    com.tencent.qbar.h.flW().K(paramArrayOfInt);
    AppMethodBeat.o(51979);
  }
  
  public void setScanMode(int paramInt)
  {
    this.mode = paramInt;
  }
  
  public void setScanSource(int paramInt)
  {
    AppMethodBeat.i(51964);
    if (this.vPj != null) {
      this.vPj.setScanSource(paramInt);
    }
    AppMethodBeat.o(51964);
  }
  
  public void setScrollTabController(com.tencent.mm.plugin.scanner.ui.widget.b paramb)
  {
    this.vQP = paramb;
  }
  
  public void setShowScanTips(boolean paramBoolean)
  {
    this.vQW = paramBoolean;
  }
  
  public void setSuccessMarkClickListener(y paramy)
  {
    AppMethodBeat.i(170025);
    if ((this.vPj instanceof ScanCodeMaskView)) {
      ((ScanCodeMaskView)this.vPj).setSuccessMarkClickListener(paramy);
    }
    AppMethodBeat.o(170025);
  }
  
  public final void stopPreview()
  {
    AppMethodBeat.i(51956);
    super.stopPreview();
    this.vUV = true;
    this.vUW = false;
    AppMethodBeat.o(51956);
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
      ScanUIRectView.L(ScanUIRectView.this);
      AppMethodBeat.o(161040);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ScanUIRectView
 * JD-Core Version:    0.7.0.1
 */
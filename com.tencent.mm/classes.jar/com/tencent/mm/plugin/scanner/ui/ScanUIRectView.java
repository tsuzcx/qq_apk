package com.tencent.mm.plugin.scanner.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.TimeInterpolator;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
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
import com.tencent.mm.g.a.rz;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.plugin.scanner.api.BaseScanRequest;
import com.tencent.mm.plugin.scanner.api.ScanGoodsRequest;
import com.tencent.mm.plugin.scanner.c.a.3;
import com.tencent.mm.plugin.scanner.model.aa;
import com.tencent.mm.plugin.scanner.model.ag;
import com.tencent.mm.plugin.scanner.model.s;
import com.tencent.mm.plugin.scanner.model.t;
import com.tencent.mm.plugin.scanner.model.z;
import com.tencent.mm.plugin.scanner.ui.scangoods.widget.ScanGoodsMaskView;
import com.tencent.mm.plugin.scanner.ui.widget.ScanCodeMaskView;
import com.tencent.mm.plugin.scanner.ui.widget.ScanDebugView;
import com.tencent.mm.plugin.scanner.ui.widget.ScanSharedMaskView;
import com.tencent.mm.plugin.scanner.util.ScanCameraLightDetector;
import com.tencent.mm.plugin.scanner.util.l;
import com.tencent.mm.plugin.scanner.util.o;
import com.tencent.mm.plugin.scanner.view.BaseScanMaskView;
import com.tencent.mm.plugin.scanner.view.ScanRectDecorView;
import com.tencent.mm.plugin.scanner.view.ScanTranslationMaskView;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.qbar.QbarNative.QBarPoint;
import com.tencent.qbar.ScanDecodeFrameData;
import com.tencent.qbar.WxQBarPoint;
import com.tencent.qbar.WxQBarResult;
import com.tencent.qbar.WxQbarNative.QBarReportMsg;
import com.tencent.qbar.h;
import com.tencent.qbar.h.c;
import com.tencent.scanlib.a.b.b.a;
import com.tencent.scanlib.a.b.c.a;
import com.tencent.scanlib.a.b.d.a;
import com.tencent.scanlib.ui.ScanView;
import d.g.b.k;
import java.util.ArrayList;
import java.util.List;

public class ScanUIRectView
  extends ScanView
{
  public static final int xfF;
  private Activity activity;
  private com.tencent.mm.modelgeo.b.a fnd;
  private d hxT;
  private GestureDetector irA;
  private boolean isFirst;
  private boolean isRetry;
  private long mTimeout;
  int mode;
  private Point qyp;
  private boolean sUj;
  private boolean udt;
  private float wWl;
  private long wXJ;
  BaseScanMaskView wZP;
  private ScanSharedMaskView wZQ;
  private boolean xbF;
  boolean xbG;
  private BaseScanRequest xbO;
  private ScannerFlashSwitcher xbo;
  private com.tencent.mm.plugin.scanner.ui.widget.b xbx;
  private int xfA;
  private int xfB;
  private boolean xfC;
  private boolean xfD;
  private boolean xfE;
  private boolean xfG;
  private boolean xfH;
  private com.tencent.mm.plugin.scanner.util.g xfI;
  private int xfJ;
  private long xfK;
  private boolean xfL;
  private boolean xfM;
  private boolean xfN;
  private Runnable xfO;
  private int xfP;
  private int xfQ;
  private h.c xfR;
  private com.tencent.mm.plugin.scanner.c.a.a xfS;
  private com.tencent.mm.sdk.b.c<rz> xfT;
  private long xfU;
  private b xfV;
  private ScanRectDecorView xfv;
  ScanDebugView xfw;
  private ScanUIRectView.a xfx;
  private boolean xfy;
  private boolean xfz;
  
  static
  {
    AppMethodBeat.i(51980);
    xfF = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(com.tencent.mm.plugin.expt.a.b.a.pZT, 50);
    AppMethodBeat.o(51980);
  }
  
  public ScanUIRectView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(51945);
    this.mode = 1;
    this.xbF = true;
    this.xbG = false;
    this.xfy = true;
    this.xfz = false;
    this.xfA = 0;
    this.xfB = 120;
    this.sUj = false;
    this.qyp = null;
    this.xfD = true;
    this.xfE = false;
    this.xfG = false;
    this.xfH = false;
    this.isFirst = true;
    this.xfI = new com.tencent.mm.plugin.scanner.util.g();
    this.xfJ = 0;
    this.xfK = 0L;
    this.mTimeout = this.xfI.mTimeout;
    this.xfL = false;
    this.xfM = true;
    this.xfN = false;
    this.isRetry = false;
    this.xfO = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(51916);
        if ((ScanUIRectView.a(ScanUIRectView.this)) && (!ScanUIRectView.b(ScanUIRectView.this)))
        {
          ScanUIRectView.c(ScanUIRectView.this);
          ScanUIRectView.d(ScanUIRectView.this);
          z.dzK();
          ScanUIRectView.e(ScanUIRectView.this);
        }
        AppMethodBeat.o(51916);
      }
    };
    this.xfP = 0;
    this.xfQ = 0;
    this.xfR = new h.c()
    {
      public final void a(final long paramAnonymousLong, List<com.tencent.qbar.a.a> paramAnonymousList, final List<QbarNative.QBarPoint> paramAnonymousList1, final List<WxQbarNative.QBarReportMsg> paramAnonymousList2, final Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(199552);
        ac.d("MicroMsg.ScanUIRectView", String.format("scan code after decode %d", new Object[] { Long.valueOf(paramAnonymousLong) }));
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
                ScanUIRectView.this.dAz();
                localArrayList = new ArrayList();
                if ((paramAnonymousList2 != null) && (!paramAnonymousList2.isEmpty()))
                {
                  ac.i("MicroMsg.ScanUIRectView", "alvinluo onDecodeSuccess result size: %d", new Object[] { Integer.valueOf(paramAnonymousList2.size()) });
                  j = 0;
                  i = 0;
                  if (j < paramAnonymousList2.size())
                  {
                    localObject1 = (com.tencent.qbar.a.a)paramAnonymousList2.get(j);
                    localObject1 = new WxQBarResult(((com.tencent.qbar.a.a)localObject1).typeID, ((com.tencent.qbar.a.a)localObject1).typeName, ((com.tencent.qbar.a.a)localObject1).data, ((com.tencent.qbar.a.a)localObject1).rawData, ((com.tencent.qbar.a.a)localObject1).charset, ((com.tencent.qbar.a.a)localObject1).priorityLevel);
                    ac.i("MicroMsg.ScanUIRectView", "alvinluo onDecodeSuccess result index: %d, format: %d, content:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(((WxQBarResult)localObject1).typeID), ((WxQBarResult)localObject1).data });
                    if ((paramAnonymousList1 != null) && (paramAnonymousList1.size() >= j + 1))
                    {
                      localObject2 = (WxQbarNative.QBarReportMsg)paramAnonymousList1.get(j);
                      if (localObject2 != null) {
                        ((WxQBarResult)localObject1).JQA = ((WxQbarNative.QBarReportMsg)localObject2).qrcodeVersion;
                      }
                    }
                    if ((paramAnonymousBundle == null) || (paramAnonymousBundle.size() < j + 1)) {
                      break label426;
                    }
                    Object localObject2 = (QbarNative.QBarPoint)paramAnonymousBundle.get(j);
                    if (localObject2 == null) {
                      break label426;
                    }
                    ((WxQBarResult)localObject1).JQY = new WxQBarPoint((QbarNative.QBarPoint)localObject2);
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
                if (this.xfZ != null) {
                  ((Bundle)localObject1).putAll(this.xfZ);
                }
                ScanUIRectView.this.cqU();
                if (ScanUIRectView.m(ScanUIRectView.this) != null) {
                  ScanUIRectView.m(ScanUIRectView.this).e(ScanUIRectView.l(ScanUIRectView.this), (Bundle)localObject1);
                }
                AppMethodBeat.o(161010);
                return;
              }
            }
          });
        }
        AppMethodBeat.o(199552);
      }
      
      public final void ad(final long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(170011);
        ScanUIRectView.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(161009);
            if ((paramAnonymousLong1 == ScanUIRectView.l(ScanUIRectView.this)) && (paramAnonymousLong1 != 0L)) {
              ScanUIRectView.this.wE(this.tGh);
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
              ac.i("MicroMsg.ScanUIRectView", "zoom to scale %f", new Object[] { Float.valueOf(f) });
              if ((f > 0.0F) && (ScanUIRectView.n(ScanUIRectView.this)) && (ScanUIRectView.o(ScanUIRectView.this).cDz()))
              {
                int i = (int)(((com.tencent.scanlib.a.a)ScanUIRectView.p(ScanUIRectView.this)).fCV() * f);
                ((com.tencent.scanlib.a.a)ScanUIRectView.q(ScanUIRectView.this)).aei(i);
                com.tencent.qbar.c localc = com.tencent.qbar.c.JQr;
                localc.JQF += 1;
                localc.JQG *= f;
                localc.JQH = (System.currentTimeMillis() - localc.xan);
                ac.v("MicroMsg.QBarEngineReporter", "alvinluo zoom %d, zoomFactor: %s, totalZoomFactor: %s, lastZoomCostTime: %d", new Object[] { Integer.valueOf(localc.JQF), Float.valueOf(f), Float.valueOf(localc.JQG), Long.valueOf(localc.JQH) });
              }
            }
            AppMethodBeat.o(170010);
          }
        });
        AppMethodBeat.o(170013);
      }
    };
    this.xfS = new ScanUIRectView.3(this);
    this.fnd = new ScanUIRectView.4(this);
    this.xfT = new com.tencent.mm.sdk.b.c() {};
    this.irA = new GestureDetector(new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(170014);
        ac.d("MicroMsg.ScanUIRectView", "double click,pointer:%d,x:%f,y:%f", new Object[] { Integer.valueOf(paramAnonymousMotionEvent.getActionIndex()), Float.valueOf(paramAnonymousMotionEvent.getX(paramAnonymousMotionEvent.getActionIndex())), Float.valueOf(paramAnonymousMotionEvent.getY(paramAnonymousMotionEvent.getActionIndex())) });
        ((com.tencent.scanlib.a.a)ScanUIRectView.A(ScanUIRectView.this)).aej(5);
        z.gW(ScanUIRectView.B(ScanUIRectView.this), 3);
        AppMethodBeat.o(170014);
        return true;
      }
      
      public final boolean onFling(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(170015);
        ac.d("MicroMsg.ScanUIRectView", "alvinluo onFling velocityX: %f, velocityY: %f, canScrollSwitchTab: %b, enableScrollSwitchTab: %b, isMultiTouch: %b", new Object[] { Float.valueOf(paramAnonymousFloat1), Float.valueOf(paramAnonymousFloat2), Boolean.valueOf(ScanUIRectView.C(ScanUIRectView.this)), Boolean.valueOf(ScanUIRectView.D(ScanUIRectView.this)), Boolean.valueOf(ScanUIRectView.E(ScanUIRectView.this)) });
        if ((!ScanUIRectView.E(ScanUIRectView.this)) && (ScanUIRectView.D(ScanUIRectView.this)) && (Math.abs(paramAnonymousFloat1) > Math.abs(paramAnonymousFloat2)))
        {
          if ((paramAnonymousFloat1 >= -1200.0F) || (!ScanUIRectView.C(ScanUIRectView.this))) {
            break label168;
          }
          if (ScanUIRectView.F(ScanUIRectView.this) != null) {
            ScanUIRectView.F(ScanUIRectView.this).dBc();
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
              ScanUIRectView.F(ScanUIRectView.this).dBd();
            }
            ScanUIRectView.b(ScanUIRectView.this, false);
          }
        }
      }
    });
    this.xfV = new b(Looper.getMainLooper());
    AppMethodBeat.o(51945);
  }
  
  public ScanUIRectView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(51946);
    this.mode = 1;
    this.xbF = true;
    this.xbG = false;
    this.xfy = true;
    this.xfz = false;
    this.xfA = 0;
    this.xfB = 120;
    this.sUj = false;
    this.qyp = null;
    this.xfD = true;
    this.xfE = false;
    this.xfG = false;
    this.xfH = false;
    this.isFirst = true;
    this.xfI = new com.tencent.mm.plugin.scanner.util.g();
    this.xfJ = 0;
    this.xfK = 0L;
    this.mTimeout = this.xfI.mTimeout;
    this.xfL = false;
    this.xfM = true;
    this.xfN = false;
    this.isRetry = false;
    this.xfO = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(51916);
        if ((ScanUIRectView.a(ScanUIRectView.this)) && (!ScanUIRectView.b(ScanUIRectView.this)))
        {
          ScanUIRectView.c(ScanUIRectView.this);
          ScanUIRectView.d(ScanUIRectView.this);
          z.dzK();
          ScanUIRectView.e(ScanUIRectView.this);
        }
        AppMethodBeat.o(51916);
      }
    };
    this.xfP = 0;
    this.xfQ = 0;
    this.xfR = new h.c()
    {
      public final void a(final long paramAnonymousLong, List<com.tencent.qbar.a.a> paramAnonymousList, final List<QbarNative.QBarPoint> paramAnonymousList1, final List<WxQbarNative.QBarReportMsg> paramAnonymousList2, final Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(199552);
        ac.d("MicroMsg.ScanUIRectView", String.format("scan code after decode %d", new Object[] { Long.valueOf(paramAnonymousLong) }));
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
                ScanUIRectView.this.dAz();
                localArrayList = new ArrayList();
                if ((paramAnonymousList2 != null) && (!paramAnonymousList2.isEmpty()))
                {
                  ac.i("MicroMsg.ScanUIRectView", "alvinluo onDecodeSuccess result size: %d", new Object[] { Integer.valueOf(paramAnonymousList2.size()) });
                  j = 0;
                  i = 0;
                  if (j < paramAnonymousList2.size())
                  {
                    localObject1 = (com.tencent.qbar.a.a)paramAnonymousList2.get(j);
                    localObject1 = new WxQBarResult(((com.tencent.qbar.a.a)localObject1).typeID, ((com.tencent.qbar.a.a)localObject1).typeName, ((com.tencent.qbar.a.a)localObject1).data, ((com.tencent.qbar.a.a)localObject1).rawData, ((com.tencent.qbar.a.a)localObject1).charset, ((com.tencent.qbar.a.a)localObject1).priorityLevel);
                    ac.i("MicroMsg.ScanUIRectView", "alvinluo onDecodeSuccess result index: %d, format: %d, content:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(((WxQBarResult)localObject1).typeID), ((WxQBarResult)localObject1).data });
                    if ((paramAnonymousList1 != null) && (paramAnonymousList1.size() >= j + 1))
                    {
                      localObject2 = (WxQbarNative.QBarReportMsg)paramAnonymousList1.get(j);
                      if (localObject2 != null) {
                        ((WxQBarResult)localObject1).JQA = ((WxQbarNative.QBarReportMsg)localObject2).qrcodeVersion;
                      }
                    }
                    if ((paramAnonymousBundle == null) || (paramAnonymousBundle.size() < j + 1)) {
                      break label426;
                    }
                    Object localObject2 = (QbarNative.QBarPoint)paramAnonymousBundle.get(j);
                    if (localObject2 == null) {
                      break label426;
                    }
                    ((WxQBarResult)localObject1).JQY = new WxQBarPoint((QbarNative.QBarPoint)localObject2);
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
                if (this.xfZ != null) {
                  ((Bundle)localObject1).putAll(this.xfZ);
                }
                ScanUIRectView.this.cqU();
                if (ScanUIRectView.m(ScanUIRectView.this) != null) {
                  ScanUIRectView.m(ScanUIRectView.this).e(ScanUIRectView.l(ScanUIRectView.this), (Bundle)localObject1);
                }
                AppMethodBeat.o(161010);
                return;
              }
            }
          });
        }
        AppMethodBeat.o(199552);
      }
      
      public final void ad(final long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(170011);
        ScanUIRectView.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(161009);
            if ((paramAnonymousLong1 == ScanUIRectView.l(ScanUIRectView.this)) && (paramAnonymousLong1 != 0L)) {
              ScanUIRectView.this.wE(this.tGh);
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
              ac.i("MicroMsg.ScanUIRectView", "zoom to scale %f", new Object[] { Float.valueOf(f) });
              if ((f > 0.0F) && (ScanUIRectView.n(ScanUIRectView.this)) && (ScanUIRectView.o(ScanUIRectView.this).cDz()))
              {
                int i = (int)(((com.tencent.scanlib.a.a)ScanUIRectView.p(ScanUIRectView.this)).fCV() * f);
                ((com.tencent.scanlib.a.a)ScanUIRectView.q(ScanUIRectView.this)).aei(i);
                com.tencent.qbar.c localc = com.tencent.qbar.c.JQr;
                localc.JQF += 1;
                localc.JQG *= f;
                localc.JQH = (System.currentTimeMillis() - localc.xan);
                ac.v("MicroMsg.QBarEngineReporter", "alvinluo zoom %d, zoomFactor: %s, totalZoomFactor: %s, lastZoomCostTime: %d", new Object[] { Integer.valueOf(localc.JQF), Float.valueOf(f), Float.valueOf(localc.JQG), Long.valueOf(localc.JQH) });
              }
            }
            AppMethodBeat.o(170010);
          }
        });
        AppMethodBeat.o(170013);
      }
    };
    this.xfS = new ScanUIRectView.3(this);
    this.fnd = new ScanUIRectView.4(this);
    this.xfT = new com.tencent.mm.sdk.b.c() {};
    this.irA = new GestureDetector(new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(170014);
        ac.d("MicroMsg.ScanUIRectView", "double click,pointer:%d,x:%f,y:%f", new Object[] { Integer.valueOf(paramAnonymousMotionEvent.getActionIndex()), Float.valueOf(paramAnonymousMotionEvent.getX(paramAnonymousMotionEvent.getActionIndex())), Float.valueOf(paramAnonymousMotionEvent.getY(paramAnonymousMotionEvent.getActionIndex())) });
        ((com.tencent.scanlib.a.a)ScanUIRectView.A(ScanUIRectView.this)).aej(5);
        z.gW(ScanUIRectView.B(ScanUIRectView.this), 3);
        AppMethodBeat.o(170014);
        return true;
      }
      
      public final boolean onFling(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(170015);
        ac.d("MicroMsg.ScanUIRectView", "alvinluo onFling velocityX: %f, velocityY: %f, canScrollSwitchTab: %b, enableScrollSwitchTab: %b, isMultiTouch: %b", new Object[] { Float.valueOf(paramAnonymousFloat1), Float.valueOf(paramAnonymousFloat2), Boolean.valueOf(ScanUIRectView.C(ScanUIRectView.this)), Boolean.valueOf(ScanUIRectView.D(ScanUIRectView.this)), Boolean.valueOf(ScanUIRectView.E(ScanUIRectView.this)) });
        if ((!ScanUIRectView.E(ScanUIRectView.this)) && (ScanUIRectView.D(ScanUIRectView.this)) && (Math.abs(paramAnonymousFloat1) > Math.abs(paramAnonymousFloat2)))
        {
          if ((paramAnonymousFloat1 >= -1200.0F) || (!ScanUIRectView.C(ScanUIRectView.this))) {
            break label168;
          }
          if (ScanUIRectView.F(ScanUIRectView.this) != null) {
            ScanUIRectView.F(ScanUIRectView.this).dBc();
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
              ScanUIRectView.F(ScanUIRectView.this).dBd();
            }
            ScanUIRectView.b(ScanUIRectView.this, false);
          }
        }
      }
    });
    this.xfV = new b(Looper.getMainLooper());
    AppMethodBeat.o(51946);
  }
  
  public ScanUIRectView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(51947);
    this.mode = 1;
    this.xbF = true;
    this.xbG = false;
    this.xfy = true;
    this.xfz = false;
    this.xfA = 0;
    this.xfB = 120;
    this.sUj = false;
    this.qyp = null;
    this.xfD = true;
    this.xfE = false;
    this.xfG = false;
    this.xfH = false;
    this.isFirst = true;
    this.xfI = new com.tencent.mm.plugin.scanner.util.g();
    this.xfJ = 0;
    this.xfK = 0L;
    this.mTimeout = this.xfI.mTimeout;
    this.xfL = false;
    this.xfM = true;
    this.xfN = false;
    this.isRetry = false;
    this.xfO = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(51916);
        if ((ScanUIRectView.a(ScanUIRectView.this)) && (!ScanUIRectView.b(ScanUIRectView.this)))
        {
          ScanUIRectView.c(ScanUIRectView.this);
          ScanUIRectView.d(ScanUIRectView.this);
          z.dzK();
          ScanUIRectView.e(ScanUIRectView.this);
        }
        AppMethodBeat.o(51916);
      }
    };
    this.xfP = 0;
    this.xfQ = 0;
    this.xfR = new h.c()
    {
      public final void a(final long paramAnonymousLong, List<com.tencent.qbar.a.a> paramAnonymousList, final List<QbarNative.QBarPoint> paramAnonymousList1, final List<WxQbarNative.QBarReportMsg> paramAnonymousList2, final Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(199552);
        ac.d("MicroMsg.ScanUIRectView", String.format("scan code after decode %d", new Object[] { Long.valueOf(paramAnonymousLong) }));
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
                ScanUIRectView.this.dAz();
                localArrayList = new ArrayList();
                if ((paramAnonymousList2 != null) && (!paramAnonymousList2.isEmpty()))
                {
                  ac.i("MicroMsg.ScanUIRectView", "alvinluo onDecodeSuccess result size: %d", new Object[] { Integer.valueOf(paramAnonymousList2.size()) });
                  j = 0;
                  i = 0;
                  if (j < paramAnonymousList2.size())
                  {
                    localObject1 = (com.tencent.qbar.a.a)paramAnonymousList2.get(j);
                    localObject1 = new WxQBarResult(((com.tencent.qbar.a.a)localObject1).typeID, ((com.tencent.qbar.a.a)localObject1).typeName, ((com.tencent.qbar.a.a)localObject1).data, ((com.tencent.qbar.a.a)localObject1).rawData, ((com.tencent.qbar.a.a)localObject1).charset, ((com.tencent.qbar.a.a)localObject1).priorityLevel);
                    ac.i("MicroMsg.ScanUIRectView", "alvinluo onDecodeSuccess result index: %d, format: %d, content:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(((WxQBarResult)localObject1).typeID), ((WxQBarResult)localObject1).data });
                    if ((paramAnonymousList1 != null) && (paramAnonymousList1.size() >= j + 1))
                    {
                      localObject2 = (WxQbarNative.QBarReportMsg)paramAnonymousList1.get(j);
                      if (localObject2 != null) {
                        ((WxQBarResult)localObject1).JQA = ((WxQbarNative.QBarReportMsg)localObject2).qrcodeVersion;
                      }
                    }
                    if ((paramAnonymousBundle == null) || (paramAnonymousBundle.size() < j + 1)) {
                      break label426;
                    }
                    Object localObject2 = (QbarNative.QBarPoint)paramAnonymousBundle.get(j);
                    if (localObject2 == null) {
                      break label426;
                    }
                    ((WxQBarResult)localObject1).JQY = new WxQBarPoint((QbarNative.QBarPoint)localObject2);
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
                if (this.xfZ != null) {
                  ((Bundle)localObject1).putAll(this.xfZ);
                }
                ScanUIRectView.this.cqU();
                if (ScanUIRectView.m(ScanUIRectView.this) != null) {
                  ScanUIRectView.m(ScanUIRectView.this).e(ScanUIRectView.l(ScanUIRectView.this), (Bundle)localObject1);
                }
                AppMethodBeat.o(161010);
                return;
              }
            }
          });
        }
        AppMethodBeat.o(199552);
      }
      
      public final void ad(final long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(170011);
        ScanUIRectView.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(161009);
            if ((paramAnonymousLong1 == ScanUIRectView.l(ScanUIRectView.this)) && (paramAnonymousLong1 != 0L)) {
              ScanUIRectView.this.wE(this.tGh);
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
              ac.i("MicroMsg.ScanUIRectView", "zoom to scale %f", new Object[] { Float.valueOf(f) });
              if ((f > 0.0F) && (ScanUIRectView.n(ScanUIRectView.this)) && (ScanUIRectView.o(ScanUIRectView.this).cDz()))
              {
                int i = (int)(((com.tencent.scanlib.a.a)ScanUIRectView.p(ScanUIRectView.this)).fCV() * f);
                ((com.tencent.scanlib.a.a)ScanUIRectView.q(ScanUIRectView.this)).aei(i);
                com.tencent.qbar.c localc = com.tencent.qbar.c.JQr;
                localc.JQF += 1;
                localc.JQG *= f;
                localc.JQH = (System.currentTimeMillis() - localc.xan);
                ac.v("MicroMsg.QBarEngineReporter", "alvinluo zoom %d, zoomFactor: %s, totalZoomFactor: %s, lastZoomCostTime: %d", new Object[] { Integer.valueOf(localc.JQF), Float.valueOf(f), Float.valueOf(localc.JQG), Long.valueOf(localc.JQH) });
              }
            }
            AppMethodBeat.o(170010);
          }
        });
        AppMethodBeat.o(170013);
      }
    };
    this.xfS = new ScanUIRectView.3(this);
    this.fnd = new ScanUIRectView.4(this);
    this.xfT = new com.tencent.mm.sdk.b.c() {};
    this.irA = new GestureDetector(new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(170014);
        ac.d("MicroMsg.ScanUIRectView", "double click,pointer:%d,x:%f,y:%f", new Object[] { Integer.valueOf(paramAnonymousMotionEvent.getActionIndex()), Float.valueOf(paramAnonymousMotionEvent.getX(paramAnonymousMotionEvent.getActionIndex())), Float.valueOf(paramAnonymousMotionEvent.getY(paramAnonymousMotionEvent.getActionIndex())) });
        ((com.tencent.scanlib.a.a)ScanUIRectView.A(ScanUIRectView.this)).aej(5);
        z.gW(ScanUIRectView.B(ScanUIRectView.this), 3);
        AppMethodBeat.o(170014);
        return true;
      }
      
      public final boolean onFling(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(170015);
        ac.d("MicroMsg.ScanUIRectView", "alvinluo onFling velocityX: %f, velocityY: %f, canScrollSwitchTab: %b, enableScrollSwitchTab: %b, isMultiTouch: %b", new Object[] { Float.valueOf(paramAnonymousFloat1), Float.valueOf(paramAnonymousFloat2), Boolean.valueOf(ScanUIRectView.C(ScanUIRectView.this)), Boolean.valueOf(ScanUIRectView.D(ScanUIRectView.this)), Boolean.valueOf(ScanUIRectView.E(ScanUIRectView.this)) });
        if ((!ScanUIRectView.E(ScanUIRectView.this)) && (ScanUIRectView.D(ScanUIRectView.this)) && (Math.abs(paramAnonymousFloat1) > Math.abs(paramAnonymousFloat2)))
        {
          if ((paramAnonymousFloat1 >= -1200.0F) || (!ScanUIRectView.C(ScanUIRectView.this))) {
            break label168;
          }
          if (ScanUIRectView.F(ScanUIRectView.this) != null) {
            ScanUIRectView.F(ScanUIRectView.this).dBc();
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
              ScanUIRectView.F(ScanUIRectView.this).dBd();
            }
            ScanUIRectView.b(ScanUIRectView.this, false);
          }
        }
      }
    });
    this.xfV = new b(Looper.getMainLooper());
    AppMethodBeat.o(51947);
  }
  
  private void bw(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(161043);
    if ((this.JVI.cDz()) && (((com.tencent.mm.plugin.scanner.a.a)this.JVI).dzl())) {
      ScanCameraLightDetector.xlv.A(paramArrayOfByte, ((com.tencent.mm.plugin.scanner.a.a)this.JVI).fCS().x, ((com.tencent.mm.plugin.scanner.a.a)this.JVI).fCS().y);
    }
    switch (this.mode)
    {
    default: 
      ac.i("MicroMsg.ScanUIRectView", "unknown scan mode %d", new Object[] { Integer.valueOf(this.mode) });
      AppMethodBeat.o(161043);
      return;
    case 1: 
    case 4: 
    case 8: 
      bx(paramArrayOfByte);
      AppMethodBeat.o(161043);
      return;
    }
    by(paramArrayOfByte);
    AppMethodBeat.o(161043);
  }
  
  private void bx(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(161044);
    Object localObject;
    Rect localRect1;
    if ((this.wXJ != 0L) && (this.JVI.cDz()))
    {
      localObject = this.JVI.fCS();
      if (localObject != null)
      {
        localRect1 = getScanCodeRect();
        if ((this.isRetry) && (this.xfJ != 1)) {
          break label198;
        }
        Rect localRect2 = ((com.tencent.mm.plugin.scanner.a.a)this.JVI).s(localRect1);
        if (this.wZP != null)
        {
          this.wZP.setPreviewRect(localRect2);
          this.wZP.setScanRect(localRect1);
          if ((this.wZP instanceof ScanCodeMaskView)) {
            ((ScanCodeMaskView)this.wZP).setNeedRotate(true);
          }
        }
        h.fCn().a(paramArrayOfByte, (Point)localObject, this.JVI.getCameraRotation(), localRect2);
      }
    }
    for (;;)
    {
      if ((!((com.tencent.scanlib.a.a)this.JVI).dAy()) && (h.fCn().wXM > xfF))
      {
        ac.i("MicroMsg.ScanUIRectView", "change to FOCUS_MODE_AUTO");
        this.JVI.setFocusMode("auto");
        BR(100L);
      }
      AppMethodBeat.o(161044);
      return;
      label198:
      if ((this.isRetry) && (this.xfJ == 2))
      {
        localObject = new Rect(0, 0, this.xfP, this.xfQ);
        if (this.wZP != null)
        {
          this.wZP.setPreviewRect((Rect)localObject);
          this.wZP.setScanRect(localRect1);
          if ((this.wZP instanceof ScanCodeMaskView)) {
            ((ScanCodeMaskView)this.wZP).setNeedRotate(false);
          }
        }
        h.fCn().a(paramArrayOfByte, new Point(this.xfP, this.xfQ), 0, (Rect)localObject);
      }
    }
  }
  
  private void by(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(161045);
    if (this.wXJ != 0L) {
      synchronized (this.JVI)
      {
        if (this.JVI.cDz())
        {
          Point localPoint = this.JVI.fCS();
          boolean bool = true;
          if ((this.xbO instanceof ScanGoodsRequest)) {
            bool = ((ScanGoodsRequest)this.xbO).wWh;
          }
          com.tencent.mm.plugin.scanner.c.a.dzp().a(paramArrayOfByte, localPoint, this.JVI.getCameraRotation(), ((com.tencent.mm.plugin.scanner.a.a)this.JVI).getPreviewFormat(), bool);
        }
        AppMethodBeat.o(161045);
        return;
      }
    }
    AppMethodBeat.o(161045);
  }
  
  private byte[] dAA()
  {
    AppMethodBeat.i(161042);
    for (;;)
    {
      int i;
      try
      {
        l1 = System.currentTimeMillis();
        k = this.aTL.getWidth();
        int m = this.aTL.getHeight();
        i = m;
        j = k;
        if (this.xfI == null) {
          break label300;
        }
        i = m;
        j = k;
        if (this.xfI.xlM == 0.0F) {
          break label300;
        }
        j = (int)(this.aTL.getWidth() * this.xfI.xlM);
        i = (int)(this.aTL.getHeight() * this.xfI.xlM);
      }
      catch (Exception localException)
      {
        long l1;
        Object localObject;
        long l2;
        ac.printErrStackTrace("MicroMsg.ScanUIRectView", localException, "alvinluo generateFrameByTextureView exception", new Object[0]);
        AppMethodBeat.o(161042);
        return null;
      }
      localObject = this.aTL.getBitmap(k, j);
      ac.d("MicroMsg.ScanUIRectView", "alvinluo generateFrameByTextureView getBitmap cost: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
      {
        this.xfP = ((Bitmap)localObject).getWidth();
        this.xfQ = ((Bitmap)localObject).getHeight();
        ac.d("MicroMsg.ScanUIRectView", "alvinluo generateFrameByTextureView bitmap width: %d, height: %d", new Object[] { Integer.valueOf(this.xfP), Integer.valueOf(this.xfQ) });
        l1 = System.currentTimeMillis();
        localObject = l.a(this.xfP, this.xfQ, (Bitmap)localObject);
        l2 = System.currentTimeMillis();
        if (localObject != null)
        {
          i = localObject.length;
          ac.d("MicroMsg.ScanUIRectView", "alvinluo generateFrameByTextureView yuvData: %d, getNV21 cost: %d", new Object[] { Integer.valueOf(i), Long.valueOf(l2 - l1) });
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
  
  private void dAB()
  {
    int i = 0;
    AppMethodBeat.i(51960);
    ac.d("MicroMsg.ScanUIRectView", "alvinluo createScanMaskView mode: %d, bottomHeight: %d", new Object[] { Integer.valueOf(this.mode), Integer.valueOf(this.xfA) });
    Object localObject2;
    label270:
    boolean bool;
    switch (this.mode)
    {
    default: 
      ac.i("MicroMsg.ScanUIRectView", "unknown scan mode %d", new Object[] { Integer.valueOf(this.mode) });
      if ((this.wZP == null) || (this.wZQ == null)) {
        break label695;
      }
      this.wZP.setBottomExtraHeight(this.xfA);
      localObject1 = this.wZP;
      localObject2 = this.activity;
      k.h(localObject2, "activity");
      ((BaseScanMaskView)localObject1).activity = ((Activity)localObject2);
      this.wZP.ev(this.xbo);
      if ((this.JVI instanceof com.tencent.mm.plugin.scanner.a.a)) {
        this.wZP.xeI = ((com.tencent.mm.plugin.scanner.a.a)this.JVI);
      }
      this.wZP.o(this.wZQ.getScanTipsView());
      this.wZP.ex(this.wZQ.getGalleryButton());
      if (this.xbo != null) {
        setFlashStatus(this.xbo.cBT);
      }
      if (this.isFirst)
      {
        this.wZQ.setShowTitle(false);
        this.isFirst = false;
        this.wZP.dAP();
        localObject1 = this.wZQ;
        ac.i("MicroMsg.ScanSharedMaskView", "alvinluo onViewReady hashCode: %d", new Object[] { Integer.valueOf(((ScanSharedMaskView)localObject1).hashCode()) });
        if (((ScanSharedMaskView)localObject1).xkQ) {
          break label546;
        }
        if (((ScanSharedMaskView)localObject1).xkP) {
          break label541;
        }
        bool = true;
        label321:
        ((ScanSharedMaskView)localObject1).qg(bool);
        localObject2 = ((ScanSharedMaskView)localObject1).xkH;
        if (localObject2 == null) {
          k.aVY("scanTitle");
        }
        ((TextView)localObject2).setVisibility(8);
        label350:
        ((ScanSharedMaskView)localObject1).qg(true);
        if (((ScanSharedMaskView)localObject1).xbO == null) {
          break label675;
        }
        localObject2 = ((ScanSharedMaskView)localObject1).xkK;
        if (localObject2 == null) {
          k.aVY("galleryButton");
        }
        localObject1 = ((ScanSharedMaskView)localObject1).xbO;
        if (localObject1 == null) {
          k.fOy();
        }
        if (((BaseScanRequest)localObject1).wWa) {
          break label669;
        }
      }
      break;
    }
    for (;;)
    {
      ((View)localObject2).setVisibility(i);
      AppMethodBeat.o(51960);
      return;
      dAG();
      this.wZP = new ScanCodeMaskView(getContext());
      addView(this.wZP);
      break;
      this.wZP = new ScanTranslationMaskView(getContext());
      addView(this.wZP);
      break;
      this.wZP = new ScanGoodsMaskView(getContext());
      addView(this.wZP);
      if ((!(this.wZP instanceof ScanGoodsMaskView)) || (!(this.xbO instanceof ScanGoodsRequest))) {
        break;
      }
      ((ScanGoodsMaskView)this.wZP).setScanRequest((ScanGoodsRequest)this.xbO);
      break;
      this.wZQ.setShowTitle(true);
      break label270;
      label541:
      bool = false;
      break label321;
      label546:
      ((ScanSharedMaskView)localObject1).qg(false);
      localObject2 = ((ScanSharedMaskView)localObject1).xkH;
      if (localObject2 == null) {
        k.aVY("scanTitle");
      }
      if (((TextView)localObject2).getVisibility() != 0)
      {
        localObject2 = ((ScanSharedMaskView)localObject1).xkH;
        if (localObject2 == null) {
          k.aVY("scanTitle");
        }
        ((TextView)localObject2).setVisibility(8);
        localObject2 = ((ScanSharedMaskView)localObject1).xkH;
        if (localObject2 == null) {
          k.aVY("scanTitle");
        }
        ((TextView)localObject2).setAlpha(1.0F);
        ((ScanSharedMaskView)localObject1).dBg();
        ((ScanSharedMaskView)localObject1).qh(true);
        break label350;
      }
      localObject2 = ((ScanSharedMaskView)localObject1).xkH;
      if (localObject2 == null) {
        k.aVY("scanTitle");
      }
      ((TextView)localObject2).setAlpha(1.0F);
      ((ScanSharedMaskView)localObject1).dBg();
      ((ScanSharedMaskView)localObject1).dBe();
      break label350;
      label669:
      i = 8;
    }
    label675:
    Object localObject1 = ((ScanSharedMaskView)localObject1).xkK;
    if (localObject1 == null) {
      k.aVY("galleryButton");
    }
    ((View)localObject1).setVisibility(0);
    label695:
    AppMethodBeat.o(51960);
  }
  
  private void dAC()
  {
    AppMethodBeat.i(51962);
    String str = getScanTips();
    this.wZQ.setScanTips(str);
    this.wZQ.setScanRequest(this.xbO);
    switch (this.mode)
    {
    default: 
      ac.e("MicroMsg.ScanUIRectView", "alvinluo refreshSharedMaskView unknown scan mode %d", new Object[] { Integer.valueOf(this.mode) });
      AppMethodBeat.o(51962);
      return;
    case 1: 
    case 4: 
    case 8: 
      this.wZQ.setScanTitle(getResources().getString(2131762809));
      AppMethodBeat.o(51962);
      return;
    case 3: 
      this.wZQ.setScanTitle(getResources().getString(2131762808));
      AppMethodBeat.o(51962);
      return;
    }
    this.wZQ.setScanTitle(getResources().getString(2131762804));
    AppMethodBeat.o(51962);
  }
  
  private void dAF()
  {
    AppMethodBeat.i(51970);
    if (this.wZP != null)
    {
      final BaseScanMaskView localBaseScanMaskView = this.wZP;
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
  
  private void dAG()
  {
    AppMethodBeat.i(162394);
    if (com.tencent.qbar.f.fCk())
    {
      ac.i("MicroMsg.ScanUIRectView", "alvinluo updateScanCodeRect visibleResolution: %s", new Object[] { this.qyp });
      if ((this.qyp != null) && (this.qyp.x > 0) && (this.qyp.y > 0))
      {
        this.xfv.setDecorRect(new Rect(0, (int)(this.qyp.y * 1.0F / 19.0F), this.qyp.x, (int)(this.qyp.y * 17.0F / 19.0F)));
        AppMethodBeat.o(162394);
      }
    }
    else
    {
      this.xfv.hc(getResources().getDimensionPixelSize(2131166761), getResources().getDimensionPixelSize(2131166760));
    }
    AppMethodBeat.o(162394);
  }
  
  private void dAH()
  {
    AppMethodBeat.i(160188);
    if (this.xfO != null) {
      removeCallbacks(this.xfO);
    }
    AppMethodBeat.o(160188);
  }
  
  private Rect getScanCodeRect()
  {
    int j = 0;
    AppMethodBeat.i(51975);
    if (com.tencent.qbar.f.fCk())
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
    if (!this.xbF)
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
  
  private void qb(boolean paramBoolean)
  {
    AppMethodBeat.i(51974);
    if (this.wZP != null) {
      this.wZP.qb(paramBoolean);
    }
    if (this.wZQ != null) {
      this.wZQ.qb(paramBoolean);
    }
    if (this.xfw != null) {
      this.xfw.setVisibility(8);
    }
    AppMethodBeat.o(51974);
  }
  
  private void wF(long paramLong)
  {
    AppMethodBeat.i(161046);
    long l1 = System.currentTimeMillis() - this.xfU;
    if (l1 > JVJ)
    {
      this.xfV.removeMessages(0);
      this.xfV.sendEmptyMessageDelayed(0, paramLong);
      AppMethodBeat.o(161046);
      return;
    }
    long l2 = JVJ;
    this.xfV.removeMessages(0);
    this.xfV.sendEmptyMessageDelayed(0, l2 - l1 + paramLong);
    AppMethodBeat.o(161046);
  }
  
  public final void a(final b.b.a parama)
  {
    AppMethodBeat.i(161041);
    super.a(new b.b.a()
    {
      public final void dAJ()
      {
        AppMethodBeat.i(161029);
        ScanUIRectView.h(ScanUIRectView.this);
        if (parama != null) {
          parama.dAJ();
        }
        AppMethodBeat.o(161029);
      }
    });
    AppMethodBeat.o(161041);
  }
  
  public final void a(Object paramObject, com.tencent.mm.plugin.scanner.view.c paramc)
  {
    AppMethodBeat.i(51971);
    ac.i("MicroMsg.ScanUIRectView", "alvinluo onScanSuccess");
    dAH();
    onPause();
    stopPreview();
    if (this.wZP != null)
    {
      this.wZP.a(paramObject, paramc);
      this.wZP.ew(this.aTL);
    }
    if (this.wZQ != null)
    {
      paramObject = this.wZQ;
      ac.v("MicroMsg.ScanSharedMaskView", "alvinluo onScanSuccess");
      paramc = paramObject.xkK;
      if (paramc == null) {
        k.aVY("galleryButton");
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
      paramObject.dBg();
      paramc = paramObject.xkH;
      if (paramc == null) {
        k.aVY("scanTitle");
      }
      paramc.setVisibility(8);
      paramObject.xkP = false;
      paramObject = paramObject.xbo;
      if (paramObject == null) {
        k.aVY("flashSwitcher");
      }
      paramObject.setVisibility(8);
    }
    if ((o.Nu(this.mode)) && (this.xfI != null)) {
      this.xfI.xlP = true;
    }
    AppMethodBeat.o(51971);
  }
  
  public final void a(boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(51965);
    if (this.wZP != null) {
      this.wZP.a(paramBoolean, paramOnCancelListener);
    }
    AppMethodBeat.o(51965);
  }
  
  public final void cqU()
  {
    AppMethodBeat.i(51978);
    if ((this.wZP != null) && ((this.wZP instanceof ScanCodeMaskView))) {
      ((ScanCodeMaskView)this.wZP).cqU();
    }
    AppMethodBeat.o(51978);
  }
  
  public final void dAD()
  {
    AppMethodBeat.i(51967);
    if ((this.wZQ != null) && (!this.xbo.cBT)) {
      this.wZQ.qi(true);
    }
    AppMethodBeat.o(51967);
  }
  
  public final void dAE()
  {
    AppMethodBeat.i(51968);
    if ((this.wZQ != null) && (this.xbo.cBT)) {
      this.wZQ.qi(false);
    }
    AppMethodBeat.o(51968);
  }
  
  public final void dAx()
  {
    AppMethodBeat.i(51948);
    this.JVI = new com.tencent.mm.plugin.scanner.a.a();
    AppMethodBeat.o(51948);
  }
  
  public final boolean dAy()
  {
    AppMethodBeat.i(51950);
    if (this.JVI != null)
    {
      boolean bool = ((com.tencent.scanlib.a.a)this.JVI).dAy();
      AppMethodBeat.o(51950);
      return bool;
    }
    AppMethodBeat.o(51950);
    return false;
  }
  
  public final void dAz()
  {
    AppMethodBeat.i(51952);
    ac.i("MicroMsg.ScanUIRectView", "alvinluo stopCurrentSession %d", new Object[] { Long.valueOf(this.wXJ) });
    h.fCn().wz(this.wXJ);
    com.tencent.mm.plugin.scanner.c.a.dzp().wz(this.wXJ);
    this.wXJ = 0L;
    AppMethodBeat.o(51952);
  }
  
  public Rect getDecorRect()
  {
    AppMethodBeat.i(51976);
    Rect localRect = this.xfv.getDecorRect();
    AppMethodBeat.o(51976);
    return localRect;
  }
  
  public com.tencent.scanlib.a.f getScanCamera()
  {
    return this.JVI;
  }
  
  public BaseScanMaskView getScanMaskView()
  {
    return this.wZP;
  }
  
  public ScanSharedMaskView getSharedMaskView()
  {
    return this.wZQ;
  }
  
  public final void init()
  {
    AppMethodBeat.i(51959);
    super.init();
    this.xfv = new ScanRectDecorView(getContext());
    addView(this.xfv, new FrameLayout.LayoutParams(-1, -1));
    this.wZQ = new ScanSharedMaskView(getContext());
    this.xbo = this.wZQ.getFlashSwitcherView();
    addView(this.wZQ, new FrameLayout.LayoutParams(-1, -1));
    dAC();
    AppMethodBeat.o(51959);
  }
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    AppMethodBeat.i(51972);
    ac.i("MicroMsg.ScanUIRectView", "onAutoFocus %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.xfM = false;
      wE(0L);
    }
    BR(JVL);
    AppMethodBeat.o(51972);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(51949);
    super.onCreate();
    this.xfB = ((int)(com.tencent.mm.cc.a.ig(getContext()) / 4.5F));
    if (o.Nu(this.mode)) {
      h.fCn().init(getContext());
    }
    h.fCn().JRa = new ag();
    setOnTouchListener(new View.OnTouchListener()
    {
      private float xgd;
      private float xge = 400.0F;
      private boolean xgf = false;
      
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(170016);
        int i = paramAnonymousMotionEvent.getActionMasked();
        int j = paramAnonymousMotionEvent.getActionIndex();
        ac.d("MicroMsg.ScanUIRectView", "pointIndex:%d, action: %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
        switch (i)
        {
        }
        for (;;)
        {
          ScanUIRectView.L(ScanUIRectView.this).onTouchEvent(paramAnonymousMotionEvent);
          if (paramAnonymousMotionEvent.getAction() == 1) {
            ScanUIRectView.c(ScanUIRectView.this, false);
          }
          AppMethodBeat.o(170016);
          return true;
          ac.d("MicroMsg.ScanUIRectView", "first down,pointer:%d,x:%f,y:%f", new Object[] { Integer.valueOf(j), Float.valueOf(paramAnonymousMotionEvent.getX()), Float.valueOf(paramAnonymousMotionEvent.getY()) });
          ScanUIRectView.a(ScanUIRectView.this, paramAnonymousMotionEvent.getRawX());
          ScanUIRectView.b(ScanUIRectView.this, true);
          this.xgf = false;
          continue;
          ac.d("MicroMsg.ScanUIRectView", "down,pointer:%d,x:%f,y:%f", new Object[] { Integer.valueOf(j), Float.valueOf(paramAnonymousMotionEvent.getX(j)), Float.valueOf(paramAnonymousMotionEvent.getY(j)) });
          if (paramAnonymousMotionEvent.getPointerCount() == 2)
          {
            this.xgd = ((float)(Math.pow(paramAnonymousMotionEvent.getX(0) - paramAnonymousMotionEvent.getX(1), 2.0D) + Math.pow(paramAnonymousMotionEvent.getY(0) - paramAnonymousMotionEvent.getY(1), 2.0D)));
            ScanUIRectView.c(ScanUIRectView.this, true);
          }
          this.xgf = false;
          continue;
          ac.d("MicroMsg.ScanUIRectView", "last up,pointer:%d,x:%f,y:%f", new Object[] { Integer.valueOf(j), Float.valueOf(paramAnonymousMotionEvent.getX()), Float.valueOf(paramAnonymousMotionEvent.getY()) });
          if (paramAnonymousMotionEvent.getPointerCount() == 2)
          {
            this.xgd = ((float)(Math.pow(paramAnonymousMotionEvent.getX(0) - paramAnonymousMotionEvent.getX(1), 2.0D) + Math.pow(paramAnonymousMotionEvent.getY(0) - paramAnonymousMotionEvent.getY(1), 2.0D)));
            continue;
            ac.d("MicroMsg.ScanUIRectView", "up,pointer:%d,x:%f,y:%f", new Object[] { Integer.valueOf(j), Float.valueOf(paramAnonymousMotionEvent.getX(j)), Float.valueOf(paramAnonymousMotionEvent.getY(j)) });
            if (paramAnonymousMotionEvent.getPointerCount() == 2)
            {
              this.xgd = ((float)(Math.pow(paramAnonymousMotionEvent.getX(0) - paramAnonymousMotionEvent.getX(1), 2.0D) + Math.pow(paramAnonymousMotionEvent.getY(0) - paramAnonymousMotionEvent.getY(1), 2.0D)));
              if (this.xgf)
              {
                this.xgf = false;
                z.gW(ScanUIRectView.B(ScanUIRectView.this), 4);
                continue;
                float f;
                if (paramAnonymousMotionEvent.getPointerCount() == 2)
                {
                  ac.d("MicroMsg.ScanUIRectView", "move,pointer:0,x:%f,y:%f", new Object[] { Float.valueOf(paramAnonymousMotionEvent.getX(0)), Float.valueOf(paramAnonymousMotionEvent.getY(0)) });
                  ac.d("MicroMsg.ScanUIRectView", "move,pointer:1,x:%f,y:%f", new Object[] { Float.valueOf(paramAnonymousMotionEvent.getX(1)), Float.valueOf(paramAnonymousMotionEvent.getY(1)) });
                  f = (float)(Math.pow(paramAnonymousMotionEvent.getX(0) - paramAnonymousMotionEvent.getX(1), 2.0D) + Math.pow(paramAnonymousMotionEvent.getY(0) - paramAnonymousMotionEvent.getY(1), 2.0D));
                  ac.d("MicroMsg.ScanUIRectView", "distance:%f,lastDistance:%f,min move:%f", new Object[] { Float.valueOf(f), Float.valueOf(this.xgd), Float.valueOf(this.xge) });
                  if (Math.abs(f - this.xgd) > this.xge)
                  {
                    if (ScanUIRectView.n(ScanUIRectView.this)) {
                      ScanUIRectView.G(ScanUIRectView.this);
                    }
                    if (f - this.xgd > 0.0F) {
                      ((com.tencent.scanlib.a.a)ScanUIRectView.H(ScanUIRectView.this)).aej(2);
                    }
                    for (this.xgf = true;; this.xgf = true)
                    {
                      this.xgd = f;
                      break;
                      ((com.tencent.scanlib.a.a)ScanUIRectView.I(ScanUIRectView.this)).aej(3);
                    }
                  }
                }
                else if ((paramAnonymousMotionEvent.getPointerCount() == 1) && (ScanUIRectView.D(ScanUIRectView.this)) && (!ScanUIRectView.E(ScanUIRectView.this)))
                {
                  f = paramAnonymousMotionEvent.getRawX() - ScanUIRectView.J(ScanUIRectView.this);
                  ac.v("MicroMsg.ScanUIRectView", "alvinluo onTouchEvent offsetX: %f, canScrollSwitchTab: %b", new Object[] { Float.valueOf(f), Boolean.valueOf(ScanUIRectView.C(ScanUIRectView.this)) });
                  if ((f >= ScanUIRectView.K(ScanUIRectView.this)) && (ScanUIRectView.C(ScanUIRectView.this)))
                  {
                    if (ScanUIRectView.F(ScanUIRectView.this) != null) {
                      ScanUIRectView.F(ScanUIRectView.this).dBd();
                    }
                    ScanUIRectView.b(ScanUIRectView.this, false);
                  }
                  else if ((f <= -ScanUIRectView.K(ScanUIRectView.this)) && (ScanUIRectView.C(ScanUIRectView.this)))
                  {
                    if (ScanUIRectView.F(ScanUIRectView.this) != null) {
                      ScanUIRectView.F(ScanUIRectView.this).dBc();
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
    com.tencent.mm.sdk.b.a.GpY.c(this.xfT);
    if (this.xfI != null) {
      this.xfI.xlN = System.currentTimeMillis();
    }
    AppMethodBeat.o(51949);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(51955);
    super.onDestroy();
    ac.d("MicroMsg.ScanUIRectView", "alvinluo releaseView");
    if (this.wZP != null) {
      this.wZP.release();
    }
    if (this.wZQ != null)
    {
      localObject = this.wZQ;
      ac.d("MicroMsg.ScanSharedMaskView", "alvinluo release hashCode: %d", new Object[] { Integer.valueOf(((ScanSharedMaskView)localObject).hashCode()) });
      ((ScanSharedMaskView)localObject).dBf();
    }
    h.fCn().release();
    Object localObject = com.tencent.mm.plugin.scanner.c.a.dzp();
    ac.i("MicroMsg.AiScanImageDecodeQueueNew", "alvinluo release");
    s.a(new a.3((com.tencent.mm.plugin.scanner.c.a)localObject));
    com.tencent.mm.sdk.b.a.GpY.d(this.xfT);
    removeCallbacks(this.xfO);
    this.xfO = null;
    if (this.xfI != null)
    {
      localObject = this.xfI;
      ((com.tencent.mm.plugin.scanner.util.g)localObject).xlO = System.currentTimeMillis();
      ((com.tencent.mm.plugin.scanner.util.g)localObject).dpQ = (((com.tencent.mm.plugin.scanner.util.g)localObject).xlO - ((com.tencent.mm.plugin.scanner.util.g)localObject).xlN);
      ac.i("MicroMsg.ScanRetryManager", "alvinluo exitScanUI stayTime: %d, isUpdated: %b, onPreviewFrameCalled: %b, isRetry: %b", new Object[] { Long.valueOf(((com.tencent.mm.plugin.scanner.util.g)localObject).dpQ), Boolean.valueOf(((com.tencent.mm.plugin.scanner.util.g)localObject).xlI), Boolean.valueOf(((com.tencent.mm.plugin.scanner.util.g)localObject).xfN), Boolean.valueOf(((com.tencent.mm.plugin.scanner.util.g)localObject).isRetry) });
      z.a(((com.tencent.mm.plugin.scanner.util.g)localObject).xlJ, ((com.tencent.mm.plugin.scanner.util.g)localObject).isRetry, ((com.tencent.mm.plugin.scanner.util.g)localObject).xfN, ((com.tencent.mm.plugin.scanner.util.g)localObject).dpQ);
      z.f(((com.tencent.mm.plugin.scanner.util.g)localObject).xlJ, ((com.tencent.mm.plugin.scanner.util.g)localObject).isRetry, ((com.tencent.mm.plugin.scanner.util.g)localObject).xlP);
      if (!((com.tencent.mm.plugin.scanner.util.g)localObject).xlI) {
        break label288;
      }
      ((com.tencent.mm.plugin.scanner.util.g)localObject).wG(((com.tencent.mm.plugin.scanner.util.g)localObject).mTimeout);
    }
    for (;;)
    {
      if ((o.Nu(this.mode)) && (!this.xfE)) {
        z.dzM();
      }
      AppMethodBeat.o(51955);
      return;
      label288:
      if (!((com.tencent.mm.plugin.scanner.util.g)localObject).xlI)
      {
        ((com.tencent.mm.plugin.scanner.util.g)localObject).mTimeout = ((com.tencent.mm.plugin.scanner.util.g)localObject).xlF;
        ((com.tencent.mm.plugin.scanner.util.g)localObject).wG(((com.tencent.mm.plugin.scanner.util.g)localObject).mTimeout);
        ac.i("MicroMsg.ScanRetryManager", "alvinluo checkAndResetTimeout timeout not updated and reset to %d", new Object[] { Long.valueOf(((com.tencent.mm.plugin.scanner.util.g)localObject).mTimeout) });
      }
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(51953);
    super.onPause();
    ac.i("MicroMsg.ScanUIRectView", "alvinluo onPuase");
    dAH();
    if (this.wZP != null) {
      this.wZP.onPause();
    }
    dAz();
    if (this.hxT != null) {
      this.hxT.c(this.fnd);
    }
    AppMethodBeat.o(51953);
  }
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    AppMethodBeat.i(51973);
    super.onPreviewFrame(paramArrayOfByte, paramCamera);
    this.xfN = true;
    boolean bool;
    int i;
    if (paramArrayOfByte == null)
    {
      bool = true;
      ac.d("MicroMsg.ScanUIRectView", "onPreviewFrame null data: %b, isPreviewPaused: %b, canResumePreview: %b", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(this.xfG), Boolean.valueOf(this.xfH) });
      if (this.xfJ == 2) {
        if (this.xfI != null)
        {
          paramCamera = this.xfI;
          i = this.xfJ;
          ac.i("MicroMsg.ScanRetryManager", "alvinluo cancelRetryType: %d", new Object[] { Integer.valueOf(i) });
          if (i != 1) {
            break label260;
          }
          paramCamera.xlK = false;
        }
      }
    }
    for (;;)
    {
      this.isRetry = false;
      removeCallbacks(this.xfO);
      if (this.xfI != null)
      {
        paramCamera = this.xfI;
        long l1 = System.currentTimeMillis();
        long l2 = this.xfK;
        if (!paramCamera.xlI)
        {
          paramCamera.xlI = true;
          l1 = ((float)(l1 - l2) * paramCamera.xlH);
          paramCamera.mTimeout = Math.max(paramCamera.xlG, Math.min(paramCamera.xlF, l1));
        }
        this.xfI.xfN = true;
      }
      if ((!this.xfG) || (!this.xfH)) {
        break label273;
      }
      this.xfG = false;
      this.xfH = false;
      qa(false);
      wE(100L);
      AppMethodBeat.o(51973);
      return;
      bool = false;
      break;
      label260:
      if (i == 2) {
        paramCamera.xlL = false;
      }
    }
    label273:
    if (paramArrayOfByte == null)
    {
      ac.w("MicroMsg.ScanUIRectView", "alvinluo onPreviewFrame data is null");
      wE(0L);
      z.dzL();
      AppMethodBeat.o(51973);
      return;
    }
    bw(paramArrayOfByte);
    AppMethodBeat.o(51973);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(51951);
    super.onResume();
    if (!this.JVI.isOpen())
    {
      ac.i("MicroMsg.ScanUIRectView", "alvinluo onResume openCamera");
      a(null);
      ac.i("MicroMsg.ScanUIRectView", "onResume %s", new Object[] { bs.eWi() });
      this.wXJ = System.currentTimeMillis();
      if (!o.Nu(this.mode)) {
        break label244;
      }
      h.fCn().a(this.wXJ, this.xfR);
    }
    for (;;)
    {
      this.xfC = false;
      if (this.wZP != null) {
        this.wZP.onResume();
      }
      ap.n(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(51923);
          if ((ScanUIRectView.f(ScanUIRectView.this) != null) && (ScanUIRectView.f(ScanUIRectView.this).wVZ))
          {
            AppMethodBeat.o(51923);
            return;
          }
          ScanCameraLightDetector.xlv.start(((com.tencent.mm.plugin.scanner.a.a)ScanUIRectView.g(ScanUIRectView.this)).getFocusMode());
          AppMethodBeat.o(51923);
        }
      }, 300L);
      this.xfH = true;
      AppMethodBeat.o(51951);
      return;
      if (!this.JVI.cDz())
      {
        ac.i("MicroMsg.ScanUIRectView", "alvinluo onResume startPreview");
        ((com.tencent.mm.plugin.scanner.a.a)this.JVI).dzj();
        a(new b.d.a()
        {
          public final void dAI()
          {
            AppMethodBeat.i(170017);
            ScanUIRectView.this.wE(0L);
            AppMethodBeat.o(170017);
          }
        });
        ac.i("MicroMsg.ScanUIRectView", "focus mode %s", new Object[] { this.JVI.getFocusMode() });
        break;
      }
      ac.i("MicroMsg.ScanUIRectView", "alvinluo onResume camera is previewing");
      ac.i("MicroMsg.ScanUIRectView", "focus mode %s", new Object[] { this.JVI.getFocusMode() });
      wE(0L);
      break;
      label244:
      if (this.mode == 12)
      {
        ac.i("MicroMsg.ScanUIRectView", "alvinluo onResume currentNetworkAvailable: %b", new Object[] { Boolean.valueOf(this.xbG) });
        if (this.xbG)
        {
          com.tencent.mm.plugin.scanner.c.a locala = com.tencent.mm.plugin.scanner.c.a.dzp();
          long l = this.wXJ;
          com.tencent.mm.plugin.scanner.c.a.a locala1 = this.xfS;
          synchronized (locala.wXD)
          {
            locala.wXJ = l;
            locala.wXY = locala1;
            synchronized (locala.wXX)
            {
              if (locala.fJw) {
                s.reset();
              }
            }
          }
        }
        com.tencent.mm.plugin.scanner.c.a.dzp().wz(this.wXJ);
      }
    }
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(51954);
    super.onStop();
    auj();
    ScanCameraLightDetector.xlv.stop();
    AppMethodBeat.o(51954);
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(162395);
    super.onSurfaceTextureAvailable(paramSurfaceTexture, paramInt1, paramInt2);
    if ((this.qyp == null) || (paramInt1 != this.qyp.x) || (paramInt2 != this.qyp.y))
    {
      if (this.qyp == null) {
        this.qyp = new Point(paramInt1, paramInt2);
      }
      if (o.Nu(this.mode)) {
        dAG();
      }
    }
    AppMethodBeat.o(162395);
  }
  
  public final void pZ(boolean paramBoolean)
  {
    boolean bool2 = true;
    AppMethodBeat.i(51969);
    ac.v("MicroMsg.ScanUIRectView", "alvinluo onShowNoDataView show: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    Object localObject;
    boolean bool1;
    if (this.wZQ != null)
    {
      localObject = this.wZQ;
      if (!paramBoolean)
      {
        bool1 = true;
        ((ScanSharedMaskView)localObject).qj(bool1);
      }
    }
    else if (this.wZP != null)
    {
      localObject = this.wZP;
      if (paramBoolean) {
        break label90;
      }
    }
    label90:
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      ((BaseScanMaskView)localObject).qj(paramBoolean);
      AppMethodBeat.o(51969);
      return;
      bool1 = false;
      break;
    }
  }
  
  public final void qa(final boolean paramBoolean)
  {
    AppMethodBeat.i(170027);
    z.MT(this.mode);
    if (this.mode == 12) {
      z.aq(1, System.currentTimeMillis());
    }
    if (Looper.getMainLooper().getThread() == Thread.currentThread())
    {
      qb(paramBoolean);
      AppMethodBeat.o(170027);
      return;
    }
    ap.f(new Runnable()
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
    this.xfv.setVisibility(8);
    dAC();
    dAF();
    dAB();
    AppMethodBeat.o(51961);
  }
  
  public void setActivity(Activity paramActivity)
  {
    this.activity = paramActivity;
  }
  
  public void setBlackInterval(int paramInt)
  {
    AppMethodBeat.i(170024);
    h localh = h.fCn();
    synchronized (localh.knn)
    {
      if (localh.knn.hasInited()) {
        localh.knn.setBlackInterval(paramInt);
      }
      AppMethodBeat.o(170024);
      return;
    }
  }
  
  public void setBottomExtraHeight(int paramInt)
  {
    this.xfA = paramInt;
  }
  
  public void setDecodeSuccessFrameData(ScanDecodeFrameData paramScanDecodeFrameData)
  {
    AppMethodBeat.i(170026);
    if (this.wZP != null) {
      this.wZP.setDecodeSuccessFrameData(paramScanDecodeFrameData);
    }
    AppMethodBeat.o(170026);
  }
  
  public void setDecorRect(Rect paramRect)
  {
    AppMethodBeat.i(51977);
    this.xfv.setDecorRect(paramRect);
    AppMethodBeat.o(51977);
  }
  
  public void setEnableScrollSwitchTab(boolean paramBoolean)
  {
    AppMethodBeat.i(51958);
    ac.i("MicroMsg.ScanUIRectView", "alvinluo setEnableScrollSwitchTab: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.xfy = paramBoolean;
    AppMethodBeat.o(51958);
  }
  
  public void setFlashStatus(boolean paramBoolean)
  {
    AppMethodBeat.i(51966);
    if (this.wZQ != null) {
      this.wZQ.setFlashStatus(paramBoolean);
    }
    AppMethodBeat.o(51966);
  }
  
  public void setMyQrCodeVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(199553);
    if ((this.wZP instanceof ScanCodeMaskView)) {
      ((ScanCodeMaskView)this.wZP).setMyQrCodeButtonVisible(paramBoolean);
    }
    AppMethodBeat.o(199553);
  }
  
  public void setNetworkAvailable(boolean paramBoolean)
  {
    this.xbG = paramBoolean;
  }
  
  public void setScanCallback(ScanUIRectView.a parama)
  {
    this.xfx = parama;
  }
  
  public void setScanCodeReaders(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(51979);
    h.fCn().K(paramArrayOfInt);
    AppMethodBeat.o(51979);
  }
  
  public void setScanMode(int paramInt)
  {
    this.mode = paramInt;
  }
  
  public void setScanRequest(BaseScanRequest paramBaseScanRequest)
  {
    this.xbO = paramBaseScanRequest;
  }
  
  public void setScanSource(int paramInt)
  {
    AppMethodBeat.i(51964);
    if (this.wZP != null) {
      this.wZP.setScanSource(paramInt);
    }
    AppMethodBeat.o(51964);
  }
  
  public void setScrollTabController(com.tencent.mm.plugin.scanner.ui.widget.b paramb)
  {
    this.xbx = paramb;
  }
  
  public void setShowScanTips(boolean paramBoolean)
  {
    this.xbF = paramBoolean;
  }
  
  public void setSuccessMarkClickListener(aa paramaa)
  {
    AppMethodBeat.i(170025);
    if ((this.wZP instanceof ScanCodeMaskView)) {
      ((ScanCodeMaskView)this.wZP).setSuccessMarkClickListener(paramaa);
    }
    AppMethodBeat.o(170025);
  }
  
  public final void stopPreview()
  {
    AppMethodBeat.i(51956);
    super.stopPreview();
    this.xfG = true;
    this.xfH = false;
    AppMethodBeat.o(51956);
  }
  
  public final void wE(long paramLong)
  {
    AppMethodBeat.i(51957);
    this.xfE = true;
    ac.d("MicroMsg.ScanUIRectView", "alvinluo takeOneShot timeout: %d, isRetry: %b, onPreviewFrameCalled: %b, canReportOnPreviewFrame: %b, hasReport: %b", new Object[] { Long.valueOf(this.mTimeout), Boolean.valueOf(this.isRetry), Boolean.valueOf(this.xfN), Boolean.valueOf(this.xfM), Boolean.valueOf(this.xfL) });
    if (!this.isRetry)
    {
      super.wE(paramLong);
      this.xfK = System.currentTimeMillis();
      if ((!this.xfN) && (this.xfM) && (o.Nu(this.mode)))
      {
        removeCallbacks(this.xfO);
        postDelayed(this.xfO, this.mTimeout);
        AppMethodBeat.o(51957);
      }
    }
    else if ((this.xfI != null) && (this.xfI.Nt(this.xfJ)))
    {
      if (this.xfJ == 1)
      {
        super.wE(paramLong);
        this.xfK = System.currentTimeMillis();
        AppMethodBeat.o(51957);
        return;
      }
      if (this.xfJ == 2) {
        wF(paramLong);
      }
    }
    AppMethodBeat.o(51957);
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
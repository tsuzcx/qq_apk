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
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.tj;
import com.tencent.mm.plugin.scanner.api.BaseScanRequest;
import com.tencent.mm.plugin.scanner.api.ScanGoodsRequest;
import com.tencent.mm.plugin.scanner.d.a.3;
import com.tencent.mm.plugin.scanner.model.ScanPoint;
import com.tencent.mm.plugin.scanner.model.ae;
import com.tencent.mm.plugin.scanner.model.af;
import com.tencent.mm.plugin.scanner.model.ag;
import com.tencent.mm.plugin.scanner.model.an;
import com.tencent.mm.plugin.scanner.model.x;
import com.tencent.mm.plugin.scanner.model.y;
import com.tencent.mm.plugin.scanner.ui.scangoods.widget.ScanAnimationDotsView;
import com.tencent.mm.plugin.scanner.ui.scangoods.widget.ScanGoodsMaskView;
import com.tencent.mm.plugin.scanner.ui.widget.ScanCodeMaskView;
import com.tencent.mm.plugin.scanner.ui.widget.ScanDebugView;
import com.tencent.mm.plugin.scanner.ui.widget.ScanSharedMaskView;
import com.tencent.mm.plugin.scanner.ui.widget.ScanSharedMaskView.f;
import com.tencent.mm.plugin.scanner.util.ScanCameraLightDetector;
import com.tencent.mm.plugin.scanner.util.l;
import com.tencent.mm.plugin.scanner.util.l.b;
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
import com.tencent.qbar.h.c;
import com.tencent.scanlib.a.b.b.a;
import com.tencent.scanlib.a.b.c.a;
import com.tencent.scanlib.a.b.d.a;
import com.tencent.scanlib.ui.ScanView;
import java.util.ArrayList;
import java.util.List;
import kotlin.a.e;
import kotlin.g.b.p;

public class ScanUIRectView
  extends ScanView
{
  public static final int CNv;
  private float CBd;
  private long CDU;
  BaseScanMaskView CGD;
  ScanSharedMaskView CGE;
  private BaseScanRequest CJD;
  private boolean CJO;
  private ScannerFlashSwitcher CJh;
  private com.tencent.mm.plugin.scanner.ui.widget.b CJn;
  private boolean CJu;
  boolean CJv;
  private int CNA;
  private long CNB;
  private boolean CNC;
  private boolean CND;
  private boolean CNE;
  private Runnable CNF;
  private int CNG;
  private int CNH;
  private h.c CNI;
  private com.tencent.mm.plugin.scanner.d.a.a CNJ;
  private IListener<tj> CNK;
  private b CNL;
  private ScanRectDecorView CNj;
  ScanDebugView CNk;
  private a CNl;
  private String CNm;
  com.tencent.mm.plugin.scanner.model.f CNn;
  private boolean CNo;
  private boolean CNp;
  private int CNq;
  private int CNr;
  private boolean CNs;
  private boolean CNt;
  private boolean CNu;
  private boolean CNw;
  private boolean CNx;
  private boolean CNy;
  private com.tencent.mm.plugin.scanner.util.h CNz;
  private Activity activity;
  private com.tencent.mm.modelgeo.b.a gmA;
  private com.tencent.mm.modelgeo.d iOv;
  private boolean isFirst;
  private boolean isRetry;
  private GestureDetector jKk;
  private long lastShotTime;
  private long mTimeout;
  int mode;
  private Point sRG;
  private boolean uSu;
  private boolean xsN;
  
  static
  {
    AppMethodBeat.i(51980);
    CNv = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.sjP, 50);
    AppMethodBeat.o(51980);
  }
  
  public ScanUIRectView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(51945);
    this.mode = 1;
    this.CJu = true;
    this.CJv = false;
    this.CNo = true;
    this.CNp = false;
    this.CNq = 0;
    this.CNr = 120;
    this.xsN = false;
    this.sRG = null;
    this.CNt = true;
    this.CNu = false;
    this.CJO = false;
    this.CNw = false;
    this.CNx = false;
    this.isFirst = true;
    this.CNy = false;
    this.CNz = new com.tencent.mm.plugin.scanner.util.h();
    this.CNA = 0;
    this.CNB = 0L;
    this.mTimeout = this.CNz.mTimeout;
    this.CNC = false;
    this.CND = true;
    this.CNE = false;
    this.isRetry = false;
    this.CNF = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(51916);
        if ((ScanUIRectView.a(ScanUIRectView.this)) && (!ScanUIRectView.b(ScanUIRectView.this)))
        {
          ScanUIRectView.c(ScanUIRectView.this);
          ScanUIRectView.d(ScanUIRectView.this);
          af.eQj();
          ScanUIRectView.e(ScanUIRectView.this);
        }
        AppMethodBeat.o(51916);
      }
    };
    this.CNG = 0;
    this.CNH = 0;
    this.CNI = new h.c()
    {
      public final void a(final long paramAnonymousLong, List<com.tencent.qbar.a.a> paramAnonymousList, final List<QbarNative.QBarPoint> paramAnonymousList1, final List<WxQbarNative.QBarReportMsg> paramAnonymousList2, final Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(240781);
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
                ScanUIRectView.this.eRa();
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
                        ((WxQBarResult)localObject1).RJN = ((WxQbarNative.QBarReportMsg)localObject2).qrcodeVersion;
                      }
                    }
                    if ((paramAnonymousBundle == null) || (paramAnonymousBundle.size() < j + 1)) {
                      break label426;
                    }
                    Object localObject2 = (QbarNative.QBarPoint)paramAnonymousBundle.get(j);
                    if (localObject2 == null) {
                      break label426;
                    }
                    ((WxQBarResult)localObject1).RKp = new WxQBarPoint((QbarNative.QBarPoint)localObject2);
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
                if (this.CNP != null) {
                  ((Bundle)localObject1).putAll(this.CNP);
                }
                ScanUIRectView.this.cWj();
                if (ScanUIRectView.m(ScanUIRectView.this) != null) {
                  ScanUIRectView.m(ScanUIRectView.this).e(ScanUIRectView.l(ScanUIRectView.this), (Bundle)localObject1);
                }
                AppMethodBeat.o(161014);
                return;
              }
            }
          });
        }
        AppMethodBeat.o(240781);
      }
      
      public final void aj(final long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(240780);
        ScanUIRectView.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(161013);
            if ((paramAnonymousLong1 == ScanUIRectView.l(ScanUIRectView.this)) && (paramAnonymousLong1 != 0L)) {
              ScanUIRectView.this.IC(this.ynh);
            }
            AppMethodBeat.o(161013);
          }
        });
        AppMethodBeat.o(240780);
      }
      
      public final void b(final long paramAnonymousLong, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(240782);
        ScanUIRectView.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(161015);
            if ((paramAnonymousLong == ScanUIRectView.l(ScanUIRectView.this)) && (paramAnonymousLong != 0L) && (this.val$param.containsKey("param_zoom_ratio")))
            {
              float f = this.val$param.getFloat("param_zoom_ratio", 0.0F);
              Log.i("MicroMsg.ScanUIRectView", "zoom to scale %f", new Object[] { Float.valueOf(f) });
              if ((f > 0.0F) && (ScanUIRectView.n(ScanUIRectView.this)) && (ScanUIRectView.o(ScanUIRectView.this).dEO()))
              {
                int i = (int)(((com.tencent.scanlib.a.a)ScanUIRectView.p(ScanUIRectView.this)).hkX() * f);
                ((com.tencent.scanlib.a.a)ScanUIRectView.q(ScanUIRectView.this)).aqE(i);
                c localc = c.RJE;
                localc.RJS += 1;
                localc.RJT *= f;
                localc.RJU = (System.currentTimeMillis() - localc.CHf);
                Log.v("MicroMsg.QBarEngineReporter", "alvinluo zoom %d, zoomFactor: %s, totalZoomFactor: %s, lastZoomCostTime: %d", new Object[] { Integer.valueOf(localc.RJS), Float.valueOf(f), Float.valueOf(localc.RJT), Long.valueOf(localc.RJU) });
              }
            }
            AppMethodBeat.o(161015);
          }
        });
        AppMethodBeat.o(240782);
      }
    };
    this.CNJ = new com.tencent.mm.plugin.scanner.d.a.a()
    {
      public final void Iw(final long paramAnonymousLong)
      {
        AppMethodBeat.i(240787);
        Log.d("MicroMsg.ScanUIRectView", "alvinluo postTakeShot session: %d, delay: %d", new Object[] { Long.valueOf(paramAnonymousLong), Long.valueOf(0L) });
        ScanUIRectView.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(240784);
            if ((ScanUIRectView.l(ScanUIRectView.this) == paramAnonymousLong) && (ScanUIRectView.l(ScanUIRectView.this) != 0L)) {
              ScanUIRectView.this.IC(this.ynh);
            }
            AppMethodBeat.o(240784);
          }
        });
        AppMethodBeat.o(240787);
      }
      
      public final void a(final long paramAnonymousLong, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(240786);
        Log.d("MicroMsg.ScanUIRectView", "alvinluo onDecodeSuccess %d", new Object[] { Long.valueOf(paramAnonymousLong) });
        if (paramAnonymousBundle.getBoolean("result_is_best_img", false)) {
          ScanUIRectView.this.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(240783);
              if ((paramAnonymousLong == ScanUIRectView.l(ScanUIRectView.this)) && (ScanUIRectView.l(ScanUIRectView.this) != 0L) && (ScanUIRectView.m(ScanUIRectView.this) != null)) {
                ScanUIRectView.m(ScanUIRectView.this).e(ScanUIRectView.l(ScanUIRectView.this), this.val$result);
              }
              AppMethodBeat.o(240783);
            }
          });
        }
        AppMethodBeat.o(240786);
      }
      
      public final void a(final ae paramAnonymousae)
      {
        AppMethodBeat.i(240788);
        ScanUIRectView.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(240785);
            if ((paramAnonymousae != null) && ((ScanUIRectView.r(ScanUIRectView.this) instanceof ScanGoodsMaskView)))
            {
              ScanGoodsMaskView localScanGoodsMaskView = (ScanGoodsMaskView)ScanUIRectView.r(ScanUIRectView.this);
              ae localae = paramAnonymousae;
              p.h(localae, "pointsResult");
              if (localScanGoodsMaskView.CUN)
              {
                Log.i("MicroMsg.ScanGoodsMaskView", "alvinluo addAnimationScanDots isViewDestroy");
                AppMethodBeat.o(240785);
                return;
              }
              ScanPoint[] arrayOfScanPoint = localae.points;
              if (arrayOfScanPoint != null)
              {
                Log.v("MicroMsg.ScanGoodsMaskView", "alvinluo addAnimationScanDots size: %d", new Object[] { Integer.valueOf(localae.pointCount) });
                int j = localae.pointCount;
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
                    Log.v("MicroMsg.ScanGoodsMaskView", "alvinluo getPointObjects id: %d, x: %f, y: %f", new Object[] { localObject1, localFloat, localObject2 });
                    i += 1;
                    break;
                    localObject1 = null;
                    break label149;
                    localFloat = null;
                    break label164;
                  }
                }
                Object localObject1 = localScanGoodsMaskView.CPO;
                if (localObject1 == null) {
                  p.btv("animationDotsView");
                }
                ((ScanAnimationDotsView)localObject1).b(localae);
              }
            }
            AppMethodBeat.o(240785);
          }
        });
        AppMethodBeat.o(240788);
      }
    };
    this.gmA = new com.tencent.mm.modelgeo.b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(240790);
        Log.i("MicroMsg.ScanUIRectView", "onGetLocation %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (!paramAnonymousBoolean)
        {
          Log.i("MicroMsg.ScanUIRectView", "check permission not passed!");
          if ((!ScanUIRectView.s(ScanUIRectView.this)) && (!com.tencent.mm.modelgeo.d.bcc()))
          {
            ScanUIRectView.t(ScanUIRectView.this);
            com.tencent.mm.ui.base.h.a(ScanUIRectView.this.getContext(), ScanUIRectView.this.getContext().getString(2131761461), ScanUIRectView.this.getContext().getString(2131755998), ScanUIRectView.this.getContext().getString(2131762043), ScanUIRectView.this.getContext().getString(2131755761), false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(240789);
                com.tencent.mm.modelgeo.d.cZ(ScanUIRectView.this.getContext());
                AppMethodBeat.o(240789);
              }
            }, null);
          }
          AppMethodBeat.o(240790);
          return true;
        }
        if (ScanUIRectView.u(ScanUIRectView.this))
        {
          Log.i("MicroMsg.ScanUIRectView", "ignore, has get lbs!");
          AppMethodBeat.o(240790);
          return false;
        }
        ScanUIRectView.this.cWj();
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
        AppMethodBeat.o(240790);
        return false;
      }
    };
    this.CNK = new IListener() {};
    this.jKk = new GestureDetector(new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(240793);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/ScanUIRectView$15", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/scanner/ui/ScanUIRectView$15", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(240793);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(161025);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/ScanUIRectView$15", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
        Log.d("MicroMsg.ScanUIRectView", "double click,pointer:%d,x:%f,y:%f", new Object[] { Integer.valueOf(paramAnonymousMotionEvent.getActionIndex()), Float.valueOf(paramAnonymousMotionEvent.getX(paramAnonymousMotionEvent.getActionIndex())), Float.valueOf(paramAnonymousMotionEvent.getY(paramAnonymousMotionEvent.getActionIndex())) });
        ((com.tencent.scanlib.a.a)ScanUIRectView.A(ScanUIRectView.this)).aqF(5);
        af.ia(ScanUIRectView.B(ScanUIRectView.this), 3);
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
            ScanUIRectView.F(ScanUIRectView.this).eRD();
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
              ScanUIRectView.F(ScanUIRectView.this).eRE();
            }
            ScanUIRectView.b(ScanUIRectView.this, false);
          }
        }
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(240792);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/ScanUIRectView$15", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.axR());
        super.onLongPress(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/ScanUIRectView$15", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(240792);
      }
      
      public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(240791);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/ScanUIRectView$15", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
        boolean bool = super.onSingleTapUp(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/scanner/ui/ScanUIRectView$15", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(240791);
        return bool;
      }
    });
    this.CNL = new b(Looper.getMainLooper());
    AppMethodBeat.o(51945);
  }
  
  public ScanUIRectView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(51946);
    this.mode = 1;
    this.CJu = true;
    this.CJv = false;
    this.CNo = true;
    this.CNp = false;
    this.CNq = 0;
    this.CNr = 120;
    this.xsN = false;
    this.sRG = null;
    this.CNt = true;
    this.CNu = false;
    this.CJO = false;
    this.CNw = false;
    this.CNx = false;
    this.isFirst = true;
    this.CNy = false;
    this.CNz = new com.tencent.mm.plugin.scanner.util.h();
    this.CNA = 0;
    this.CNB = 0L;
    this.mTimeout = this.CNz.mTimeout;
    this.CNC = false;
    this.CND = true;
    this.CNE = false;
    this.isRetry = false;
    this.CNF = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(51916);
        if ((ScanUIRectView.a(ScanUIRectView.this)) && (!ScanUIRectView.b(ScanUIRectView.this)))
        {
          ScanUIRectView.c(ScanUIRectView.this);
          ScanUIRectView.d(ScanUIRectView.this);
          af.eQj();
          ScanUIRectView.e(ScanUIRectView.this);
        }
        AppMethodBeat.o(51916);
      }
    };
    this.CNG = 0;
    this.CNH = 0;
    this.CNI = new h.c()
    {
      public final void a(final long paramAnonymousLong, List<com.tencent.qbar.a.a> paramAnonymousList, final List<QbarNative.QBarPoint> paramAnonymousList1, final List<WxQbarNative.QBarReportMsg> paramAnonymousList2, final Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(240781);
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
                ScanUIRectView.this.eRa();
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
                        ((WxQBarResult)localObject1).RJN = ((WxQbarNative.QBarReportMsg)localObject2).qrcodeVersion;
                      }
                    }
                    if ((paramAnonymousBundle == null) || (paramAnonymousBundle.size() < j + 1)) {
                      break label426;
                    }
                    Object localObject2 = (QbarNative.QBarPoint)paramAnonymousBundle.get(j);
                    if (localObject2 == null) {
                      break label426;
                    }
                    ((WxQBarResult)localObject1).RKp = new WxQBarPoint((QbarNative.QBarPoint)localObject2);
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
                if (this.CNP != null) {
                  ((Bundle)localObject1).putAll(this.CNP);
                }
                ScanUIRectView.this.cWj();
                if (ScanUIRectView.m(ScanUIRectView.this) != null) {
                  ScanUIRectView.m(ScanUIRectView.this).e(ScanUIRectView.l(ScanUIRectView.this), (Bundle)localObject1);
                }
                AppMethodBeat.o(161014);
                return;
              }
            }
          });
        }
        AppMethodBeat.o(240781);
      }
      
      public final void aj(final long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(240780);
        ScanUIRectView.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(161013);
            if ((paramAnonymousLong1 == ScanUIRectView.l(ScanUIRectView.this)) && (paramAnonymousLong1 != 0L)) {
              ScanUIRectView.this.IC(this.ynh);
            }
            AppMethodBeat.o(161013);
          }
        });
        AppMethodBeat.o(240780);
      }
      
      public final void b(final long paramAnonymousLong, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(240782);
        ScanUIRectView.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(161015);
            if ((paramAnonymousLong == ScanUIRectView.l(ScanUIRectView.this)) && (paramAnonymousLong != 0L) && (this.val$param.containsKey("param_zoom_ratio")))
            {
              float f = this.val$param.getFloat("param_zoom_ratio", 0.0F);
              Log.i("MicroMsg.ScanUIRectView", "zoom to scale %f", new Object[] { Float.valueOf(f) });
              if ((f > 0.0F) && (ScanUIRectView.n(ScanUIRectView.this)) && (ScanUIRectView.o(ScanUIRectView.this).dEO()))
              {
                int i = (int)(((com.tencent.scanlib.a.a)ScanUIRectView.p(ScanUIRectView.this)).hkX() * f);
                ((com.tencent.scanlib.a.a)ScanUIRectView.q(ScanUIRectView.this)).aqE(i);
                c localc = c.RJE;
                localc.RJS += 1;
                localc.RJT *= f;
                localc.RJU = (System.currentTimeMillis() - localc.CHf);
                Log.v("MicroMsg.QBarEngineReporter", "alvinluo zoom %d, zoomFactor: %s, totalZoomFactor: %s, lastZoomCostTime: %d", new Object[] { Integer.valueOf(localc.RJS), Float.valueOf(f), Float.valueOf(localc.RJT), Long.valueOf(localc.RJU) });
              }
            }
            AppMethodBeat.o(161015);
          }
        });
        AppMethodBeat.o(240782);
      }
    };
    this.CNJ = new com.tencent.mm.plugin.scanner.d.a.a()
    {
      public final void Iw(final long paramAnonymousLong)
      {
        AppMethodBeat.i(240787);
        Log.d("MicroMsg.ScanUIRectView", "alvinluo postTakeShot session: %d, delay: %d", new Object[] { Long.valueOf(paramAnonymousLong), Long.valueOf(0L) });
        ScanUIRectView.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(240784);
            if ((ScanUIRectView.l(ScanUIRectView.this) == paramAnonymousLong) && (ScanUIRectView.l(ScanUIRectView.this) != 0L)) {
              ScanUIRectView.this.IC(this.ynh);
            }
            AppMethodBeat.o(240784);
          }
        });
        AppMethodBeat.o(240787);
      }
      
      public final void a(final long paramAnonymousLong, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(240786);
        Log.d("MicroMsg.ScanUIRectView", "alvinluo onDecodeSuccess %d", new Object[] { Long.valueOf(paramAnonymousLong) });
        if (paramAnonymousBundle.getBoolean("result_is_best_img", false)) {
          ScanUIRectView.this.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(240783);
              if ((paramAnonymousLong == ScanUIRectView.l(ScanUIRectView.this)) && (ScanUIRectView.l(ScanUIRectView.this) != 0L) && (ScanUIRectView.m(ScanUIRectView.this) != null)) {
                ScanUIRectView.m(ScanUIRectView.this).e(ScanUIRectView.l(ScanUIRectView.this), this.val$result);
              }
              AppMethodBeat.o(240783);
            }
          });
        }
        AppMethodBeat.o(240786);
      }
      
      public final void a(final ae paramAnonymousae)
      {
        AppMethodBeat.i(240788);
        ScanUIRectView.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(240785);
            if ((paramAnonymousae != null) && ((ScanUIRectView.r(ScanUIRectView.this) instanceof ScanGoodsMaskView)))
            {
              ScanGoodsMaskView localScanGoodsMaskView = (ScanGoodsMaskView)ScanUIRectView.r(ScanUIRectView.this);
              ae localae = paramAnonymousae;
              p.h(localae, "pointsResult");
              if (localScanGoodsMaskView.CUN)
              {
                Log.i("MicroMsg.ScanGoodsMaskView", "alvinluo addAnimationScanDots isViewDestroy");
                AppMethodBeat.o(240785);
                return;
              }
              ScanPoint[] arrayOfScanPoint = localae.points;
              if (arrayOfScanPoint != null)
              {
                Log.v("MicroMsg.ScanGoodsMaskView", "alvinluo addAnimationScanDots size: %d", new Object[] { Integer.valueOf(localae.pointCount) });
                int j = localae.pointCount;
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
                    Log.v("MicroMsg.ScanGoodsMaskView", "alvinluo getPointObjects id: %d, x: %f, y: %f", new Object[] { localObject1, localFloat, localObject2 });
                    i += 1;
                    break;
                    localObject1 = null;
                    break label149;
                    localFloat = null;
                    break label164;
                  }
                }
                Object localObject1 = localScanGoodsMaskView.CPO;
                if (localObject1 == null) {
                  p.btv("animationDotsView");
                }
                ((ScanAnimationDotsView)localObject1).b(localae);
              }
            }
            AppMethodBeat.o(240785);
          }
        });
        AppMethodBeat.o(240788);
      }
    };
    this.gmA = new com.tencent.mm.modelgeo.b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(240790);
        Log.i("MicroMsg.ScanUIRectView", "onGetLocation %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (!paramAnonymousBoolean)
        {
          Log.i("MicroMsg.ScanUIRectView", "check permission not passed!");
          if ((!ScanUIRectView.s(ScanUIRectView.this)) && (!com.tencent.mm.modelgeo.d.bcc()))
          {
            ScanUIRectView.t(ScanUIRectView.this);
            com.tencent.mm.ui.base.h.a(ScanUIRectView.this.getContext(), ScanUIRectView.this.getContext().getString(2131761461), ScanUIRectView.this.getContext().getString(2131755998), ScanUIRectView.this.getContext().getString(2131762043), ScanUIRectView.this.getContext().getString(2131755761), false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(240789);
                com.tencent.mm.modelgeo.d.cZ(ScanUIRectView.this.getContext());
                AppMethodBeat.o(240789);
              }
            }, null);
          }
          AppMethodBeat.o(240790);
          return true;
        }
        if (ScanUIRectView.u(ScanUIRectView.this))
        {
          Log.i("MicroMsg.ScanUIRectView", "ignore, has get lbs!");
          AppMethodBeat.o(240790);
          return false;
        }
        ScanUIRectView.this.cWj();
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
        AppMethodBeat.o(240790);
        return false;
      }
    };
    this.CNK = new IListener() {};
    this.jKk = new GestureDetector(new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(240793);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/ScanUIRectView$15", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/scanner/ui/ScanUIRectView$15", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(240793);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(161025);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/ScanUIRectView$15", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
        Log.d("MicroMsg.ScanUIRectView", "double click,pointer:%d,x:%f,y:%f", new Object[] { Integer.valueOf(paramAnonymousMotionEvent.getActionIndex()), Float.valueOf(paramAnonymousMotionEvent.getX(paramAnonymousMotionEvent.getActionIndex())), Float.valueOf(paramAnonymousMotionEvent.getY(paramAnonymousMotionEvent.getActionIndex())) });
        ((com.tencent.scanlib.a.a)ScanUIRectView.A(ScanUIRectView.this)).aqF(5);
        af.ia(ScanUIRectView.B(ScanUIRectView.this), 3);
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
            ScanUIRectView.F(ScanUIRectView.this).eRD();
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
              ScanUIRectView.F(ScanUIRectView.this).eRE();
            }
            ScanUIRectView.b(ScanUIRectView.this, false);
          }
        }
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(240792);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/ScanUIRectView$15", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.axR());
        super.onLongPress(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/ScanUIRectView$15", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(240792);
      }
      
      public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(240791);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/ScanUIRectView$15", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
        boolean bool = super.onSingleTapUp(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/scanner/ui/ScanUIRectView$15", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(240791);
        return bool;
      }
    });
    this.CNL = new b(Looper.getMainLooper());
    AppMethodBeat.o(51946);
  }
  
  public ScanUIRectView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(51947);
    this.mode = 1;
    this.CJu = true;
    this.CJv = false;
    this.CNo = true;
    this.CNp = false;
    this.CNq = 0;
    this.CNr = 120;
    this.xsN = false;
    this.sRG = null;
    this.CNt = true;
    this.CNu = false;
    this.CJO = false;
    this.CNw = false;
    this.CNx = false;
    this.isFirst = true;
    this.CNy = false;
    this.CNz = new com.tencent.mm.plugin.scanner.util.h();
    this.CNA = 0;
    this.CNB = 0L;
    this.mTimeout = this.CNz.mTimeout;
    this.CNC = false;
    this.CND = true;
    this.CNE = false;
    this.isRetry = false;
    this.CNF = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(51916);
        if ((ScanUIRectView.a(ScanUIRectView.this)) && (!ScanUIRectView.b(ScanUIRectView.this)))
        {
          ScanUIRectView.c(ScanUIRectView.this);
          ScanUIRectView.d(ScanUIRectView.this);
          af.eQj();
          ScanUIRectView.e(ScanUIRectView.this);
        }
        AppMethodBeat.o(51916);
      }
    };
    this.CNG = 0;
    this.CNH = 0;
    this.CNI = new h.c()
    {
      public final void a(final long paramAnonymousLong, List<com.tencent.qbar.a.a> paramAnonymousList, final List<QbarNative.QBarPoint> paramAnonymousList1, final List<WxQbarNative.QBarReportMsg> paramAnonymousList2, final Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(240781);
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
                ScanUIRectView.this.eRa();
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
                        ((WxQBarResult)localObject1).RJN = ((WxQbarNative.QBarReportMsg)localObject2).qrcodeVersion;
                      }
                    }
                    if ((paramAnonymousBundle == null) || (paramAnonymousBundle.size() < j + 1)) {
                      break label426;
                    }
                    Object localObject2 = (QbarNative.QBarPoint)paramAnonymousBundle.get(j);
                    if (localObject2 == null) {
                      break label426;
                    }
                    ((WxQBarResult)localObject1).RKp = new WxQBarPoint((QbarNative.QBarPoint)localObject2);
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
                if (this.CNP != null) {
                  ((Bundle)localObject1).putAll(this.CNP);
                }
                ScanUIRectView.this.cWj();
                if (ScanUIRectView.m(ScanUIRectView.this) != null) {
                  ScanUIRectView.m(ScanUIRectView.this).e(ScanUIRectView.l(ScanUIRectView.this), (Bundle)localObject1);
                }
                AppMethodBeat.o(161014);
                return;
              }
            }
          });
        }
        AppMethodBeat.o(240781);
      }
      
      public final void aj(final long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(240780);
        ScanUIRectView.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(161013);
            if ((paramAnonymousLong1 == ScanUIRectView.l(ScanUIRectView.this)) && (paramAnonymousLong1 != 0L)) {
              ScanUIRectView.this.IC(this.ynh);
            }
            AppMethodBeat.o(161013);
          }
        });
        AppMethodBeat.o(240780);
      }
      
      public final void b(final long paramAnonymousLong, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(240782);
        ScanUIRectView.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(161015);
            if ((paramAnonymousLong == ScanUIRectView.l(ScanUIRectView.this)) && (paramAnonymousLong != 0L) && (this.val$param.containsKey("param_zoom_ratio")))
            {
              float f = this.val$param.getFloat("param_zoom_ratio", 0.0F);
              Log.i("MicroMsg.ScanUIRectView", "zoom to scale %f", new Object[] { Float.valueOf(f) });
              if ((f > 0.0F) && (ScanUIRectView.n(ScanUIRectView.this)) && (ScanUIRectView.o(ScanUIRectView.this).dEO()))
              {
                int i = (int)(((com.tencent.scanlib.a.a)ScanUIRectView.p(ScanUIRectView.this)).hkX() * f);
                ((com.tencent.scanlib.a.a)ScanUIRectView.q(ScanUIRectView.this)).aqE(i);
                c localc = c.RJE;
                localc.RJS += 1;
                localc.RJT *= f;
                localc.RJU = (System.currentTimeMillis() - localc.CHf);
                Log.v("MicroMsg.QBarEngineReporter", "alvinluo zoom %d, zoomFactor: %s, totalZoomFactor: %s, lastZoomCostTime: %d", new Object[] { Integer.valueOf(localc.RJS), Float.valueOf(f), Float.valueOf(localc.RJT), Long.valueOf(localc.RJU) });
              }
            }
            AppMethodBeat.o(161015);
          }
        });
        AppMethodBeat.o(240782);
      }
    };
    this.CNJ = new com.tencent.mm.plugin.scanner.d.a.a()
    {
      public final void Iw(final long paramAnonymousLong)
      {
        AppMethodBeat.i(240787);
        Log.d("MicroMsg.ScanUIRectView", "alvinluo postTakeShot session: %d, delay: %d", new Object[] { Long.valueOf(paramAnonymousLong), Long.valueOf(0L) });
        ScanUIRectView.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(240784);
            if ((ScanUIRectView.l(ScanUIRectView.this) == paramAnonymousLong) && (ScanUIRectView.l(ScanUIRectView.this) != 0L)) {
              ScanUIRectView.this.IC(this.ynh);
            }
            AppMethodBeat.o(240784);
          }
        });
        AppMethodBeat.o(240787);
      }
      
      public final void a(final long paramAnonymousLong, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(240786);
        Log.d("MicroMsg.ScanUIRectView", "alvinluo onDecodeSuccess %d", new Object[] { Long.valueOf(paramAnonymousLong) });
        if (paramAnonymousBundle.getBoolean("result_is_best_img", false)) {
          ScanUIRectView.this.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(240783);
              if ((paramAnonymousLong == ScanUIRectView.l(ScanUIRectView.this)) && (ScanUIRectView.l(ScanUIRectView.this) != 0L) && (ScanUIRectView.m(ScanUIRectView.this) != null)) {
                ScanUIRectView.m(ScanUIRectView.this).e(ScanUIRectView.l(ScanUIRectView.this), this.val$result);
              }
              AppMethodBeat.o(240783);
            }
          });
        }
        AppMethodBeat.o(240786);
      }
      
      public final void a(final ae paramAnonymousae)
      {
        AppMethodBeat.i(240788);
        ScanUIRectView.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(240785);
            if ((paramAnonymousae != null) && ((ScanUIRectView.r(ScanUIRectView.this) instanceof ScanGoodsMaskView)))
            {
              ScanGoodsMaskView localScanGoodsMaskView = (ScanGoodsMaskView)ScanUIRectView.r(ScanUIRectView.this);
              ae localae = paramAnonymousae;
              p.h(localae, "pointsResult");
              if (localScanGoodsMaskView.CUN)
              {
                Log.i("MicroMsg.ScanGoodsMaskView", "alvinluo addAnimationScanDots isViewDestroy");
                AppMethodBeat.o(240785);
                return;
              }
              ScanPoint[] arrayOfScanPoint = localae.points;
              if (arrayOfScanPoint != null)
              {
                Log.v("MicroMsg.ScanGoodsMaskView", "alvinluo addAnimationScanDots size: %d", new Object[] { Integer.valueOf(localae.pointCount) });
                int j = localae.pointCount;
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
                    Log.v("MicroMsg.ScanGoodsMaskView", "alvinluo getPointObjects id: %d, x: %f, y: %f", new Object[] { localObject1, localFloat, localObject2 });
                    i += 1;
                    break;
                    localObject1 = null;
                    break label149;
                    localFloat = null;
                    break label164;
                  }
                }
                Object localObject1 = localScanGoodsMaskView.CPO;
                if (localObject1 == null) {
                  p.btv("animationDotsView");
                }
                ((ScanAnimationDotsView)localObject1).b(localae);
              }
            }
            AppMethodBeat.o(240785);
          }
        });
        AppMethodBeat.o(240788);
      }
    };
    this.gmA = new com.tencent.mm.modelgeo.b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(240790);
        Log.i("MicroMsg.ScanUIRectView", "onGetLocation %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (!paramAnonymousBoolean)
        {
          Log.i("MicroMsg.ScanUIRectView", "check permission not passed!");
          if ((!ScanUIRectView.s(ScanUIRectView.this)) && (!com.tencent.mm.modelgeo.d.bcc()))
          {
            ScanUIRectView.t(ScanUIRectView.this);
            com.tencent.mm.ui.base.h.a(ScanUIRectView.this.getContext(), ScanUIRectView.this.getContext().getString(2131761461), ScanUIRectView.this.getContext().getString(2131755998), ScanUIRectView.this.getContext().getString(2131762043), ScanUIRectView.this.getContext().getString(2131755761), false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(240789);
                com.tencent.mm.modelgeo.d.cZ(ScanUIRectView.this.getContext());
                AppMethodBeat.o(240789);
              }
            }, null);
          }
          AppMethodBeat.o(240790);
          return true;
        }
        if (ScanUIRectView.u(ScanUIRectView.this))
        {
          Log.i("MicroMsg.ScanUIRectView", "ignore, has get lbs!");
          AppMethodBeat.o(240790);
          return false;
        }
        ScanUIRectView.this.cWj();
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
        AppMethodBeat.o(240790);
        return false;
      }
    };
    this.CNK = new IListener() {};
    this.jKk = new GestureDetector(new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(240793);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/ScanUIRectView$15", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/scanner/ui/ScanUIRectView$15", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(240793);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(161025);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/ScanUIRectView$15", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
        Log.d("MicroMsg.ScanUIRectView", "double click,pointer:%d,x:%f,y:%f", new Object[] { Integer.valueOf(paramAnonymousMotionEvent.getActionIndex()), Float.valueOf(paramAnonymousMotionEvent.getX(paramAnonymousMotionEvent.getActionIndex())), Float.valueOf(paramAnonymousMotionEvent.getY(paramAnonymousMotionEvent.getActionIndex())) });
        ((com.tencent.scanlib.a.a)ScanUIRectView.A(ScanUIRectView.this)).aqF(5);
        af.ia(ScanUIRectView.B(ScanUIRectView.this), 3);
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
            ScanUIRectView.F(ScanUIRectView.this).eRD();
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
              ScanUIRectView.F(ScanUIRectView.this).eRE();
            }
            ScanUIRectView.b(ScanUIRectView.this, false);
          }
        }
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(240792);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/ScanUIRectView$15", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.axR());
        super.onLongPress(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/ScanUIRectView$15", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(240792);
      }
      
      public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(240791);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/ScanUIRectView$15", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
        boolean bool = super.onSingleTapUp(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/scanner/ui/ScanUIRectView$15", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(240791);
        return bool;
      }
    });
    this.CNL = new b(Looper.getMainLooper());
    AppMethodBeat.o(51947);
  }
  
  private void ID(long paramLong)
  {
    AppMethodBeat.i(161046);
    long l1 = System.currentTimeMillis() - this.lastShotTime;
    if (l1 > ROZ)
    {
      this.CNL.removeMessages(0);
      this.CNL.sendEmptyMessageDelayed(0, paramLong);
      AppMethodBeat.o(161046);
      return;
    }
    long l2 = ROZ;
    this.CNL.removeMessages(0);
    this.CNL.sendEmptyMessageDelayed(0, l2 - l1 + paramLong);
    AppMethodBeat.o(161046);
  }
  
  private void a(Object paramObject, com.tencent.mm.plugin.scanner.view.d paramd)
  {
    AppMethodBeat.i(240797);
    Log.i("MicroMsg.ScanUIRectView", "alvinluo onScanSuccess");
    eRj();
    eRh();
    if (this.CGD != null)
    {
      this.CGD.b(paramObject, paramd);
      this.CGD.eU(this.bec);
    }
    if (this.CGE != null) {
      this.CGE.eRH();
    }
    if ((r.Xd(this.mode)) && (this.CNz != null)) {
      this.CNz.CTR = true;
    }
    AppMethodBeat.o(240797);
  }
  
  private void bX(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(161043);
    if ((this.ROY.dEO()) && (((com.tencent.mm.plugin.scanner.a.a)this.ROY).ePE())) {
      ScanCameraLightDetector.CTx.N(paramArrayOfByte, ((com.tencent.mm.plugin.scanner.a.a)this.ROY).hkU().x, ((com.tencent.mm.plugin.scanner.a.a)this.ROY).hkU().y);
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
      bY(paramArrayOfByte);
      AppMethodBeat.o(161043);
      return;
    }
    bZ(paramArrayOfByte);
    AppMethodBeat.o(161043);
  }
  
  private void bY(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(161044);
    Object localObject;
    Rect localRect1;
    if ((this.CDU != 0L) && (this.ROY.dEO()))
    {
      localObject = this.ROY.hkU();
      if (localObject != null)
      {
        localRect1 = getScanCodeRect();
        if ((this.isRetry) && (this.CNA != 1)) {
          break label198;
        }
        Rect localRect2 = ((com.tencent.mm.plugin.scanner.a.a)this.ROY).w(localRect1);
        if (this.CGD != null)
        {
          this.CGD.setPreviewRect(localRect2);
          this.CGD.setScanRect(localRect1);
          if ((this.CGD instanceof ScanCodeMaskView)) {
            ((ScanCodeMaskView)this.CGD).setNeedRotate(true);
          }
        }
        com.tencent.qbar.h.hkp().a(paramArrayOfByte, (Point)localObject, this.ROY.getCameraRotation(), localRect2);
      }
    }
    for (;;)
    {
      if ((!((com.tencent.scanlib.a.a)this.ROY).eQZ()) && (com.tencent.qbar.h.hkp().CDX > CNv))
      {
        Log.i("MicroMsg.ScanUIRectView", "change to FOCUS_MODE_AUTO");
        this.ROY.setFocusMode("auto");
        Oy(100L);
      }
      AppMethodBeat.o(161044);
      return;
      label198:
      if ((this.isRetry) && (this.CNA == 2))
      {
        localObject = new Rect(0, 0, this.CNG, this.CNH);
        if (this.CGD != null)
        {
          this.CGD.setPreviewRect((Rect)localObject);
          this.CGD.setScanRect(localRect1);
          if ((this.CGD instanceof ScanCodeMaskView)) {
            ((ScanCodeMaskView)this.CGD).setNeedRotate(false);
          }
        }
        com.tencent.qbar.h.hkp().a(paramArrayOfByte, new Point(this.CNG, this.CNH), 0, (Rect)localObject);
      }
    }
  }
  
  private void bZ(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(161045);
    if (this.CDU != 0L) {
      synchronized (this.ROY)
      {
        if (this.ROY.dEO())
        {
          Point localPoint = this.ROY.hkU();
          boolean bool = true;
          if ((this.CJD instanceof ScanGoodsRequest)) {
            bool = ((ScanGoodsRequest)this.CJD).CAR;
          }
          com.tencent.mm.plugin.scanner.d.a.ePJ().a(paramArrayOfByte, localPoint, this.ROY.getCameraRotation(), ((com.tencent.mm.plugin.scanner.a.a)this.ROY).getPreviewFormat(), bool);
        }
        AppMethodBeat.o(161045);
        return;
      }
    }
    AppMethodBeat.o(161045);
  }
  
  private byte[] eRb()
  {
    AppMethodBeat.i(161042);
    for (;;)
    {
      int i;
      try
      {
        l1 = System.currentTimeMillis();
        k = this.bec.getWidth();
        int m = this.bec.getHeight();
        i = m;
        j = k;
        if (this.CNz == null) {
          break label300;
        }
        i = m;
        j = k;
        if (this.CNz.CTP == 0.0F) {
          break label300;
        }
        j = (int)(this.bec.getWidth() * this.CNz.CTP);
        i = (int)(this.bec.getHeight() * this.CNz.CTP);
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
      localObject = this.bec.getBitmap(k, j);
      Log.d("MicroMsg.ScanUIRectView", "alvinluo generateFrameByTextureView getBitmap cost: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
      {
        this.CNG = ((Bitmap)localObject).getWidth();
        this.CNH = ((Bitmap)localObject).getHeight();
        Log.d("MicroMsg.ScanUIRectView", "alvinluo generateFrameByTextureView bitmap width: %d, height: %d", new Object[] { Integer.valueOf(this.CNG), Integer.valueOf(this.CNH) });
        l1 = System.currentTimeMillis();
        localObject = com.tencent.mm.plugin.scanner.util.o.getNV21(this.CNG, this.CNH, (Bitmap)localObject);
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
  
  private void eRc()
  {
    boolean bool3 = true;
    boolean bool2 = true;
    AppMethodBeat.i(51960);
    Log.d("MicroMsg.ScanUIRectView", "alvinluo createScanMaskView mode: %d, bottomHeight: %d", new Object[] { Integer.valueOf(this.mode), Integer.valueOf(this.CNq) });
    Object localObject2;
    label239:
    int i;
    Object localObject3;
    switch (this.mode)
    {
    default: 
      Log.i("MicroMsg.ScanUIRectView", "unknown scan mode %d", new Object[] { Integer.valueOf(this.mode) });
      if ((this.CGD != null) && (this.CGE != null))
      {
        this.CGD.setBottomExtraHeight(this.CNq);
        this.CGD.CMx = ((com.tencent.mm.plugin.scanner.a.a)this.ROY);
        localObject1 = this.CGD;
        localObject2 = this.CGE.getScanTipsView();
        p.h(localObject2, "tipsView");
        ((BaseScanMaskView)localObject1).CSB = ((TextView)localObject2);
        this.CGD.eRq();
        this.CGE.setBottomExtraHeight(this.CNq);
        this.CGE.setFlashStatus(this.CJh.ddZ);
        localObject1 = this.CGE;
        if (this.isFirst) {
          break label812;
        }
        bool1 = true;
        ((ScanSharedMaskView)localObject1).setShowTitle(bool1);
        localObject2 = this.CGE;
        i = this.mode;
        Log.i("MicroMsg.ScanSharedMaskView", "alvinluo onViewReady currentTab: %d, hashCode: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(((ScanSharedMaskView)localObject2).hashCode()) });
        ((ScanSharedMaskView)localObject2).CSG = i;
        localObject3 = ((ScanSharedMaskView)localObject2).CSB;
        if (localObject3 == null) {
          p.btv("scanTips");
        }
        localObject1 = ((ScanSharedMaskView)localObject2).CSB;
        if (localObject1 == null) {
          p.btv("scanTips");
        }
        localObject1 = ((TextView)localObject1).getLayoutParams();
        if (localObject1 == null) {
          break label817;
        }
        if ((localObject1 instanceof ViewGroup.MarginLayoutParams)) {
          ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin = (com.tencent.mm.cb.a.fromDPToPix(((ScanSharedMaskView)localObject2).getContext(), 120) + ((ScanSharedMaskView)localObject2).CSP);
        }
        label373:
        ((TextView)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localObject3 = ((ScanSharedMaskView)localObject2).CSC;
        if (localObject3 == null) {
          p.btv("scanToast");
        }
        localObject1 = ((ScanSharedMaskView)localObject2).CSC;
        if (localObject1 == null) {
          p.btv("scanToast");
        }
        localObject1 = ((TextView)localObject1).getLayoutParams();
        if (localObject1 == null) {
          break label823;
        }
        if ((localObject1 instanceof ViewGroup.MarginLayoutParams)) {
          ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin = (com.tencent.mm.cb.a.fromDPToPix(((ScanSharedMaskView)localObject2).getContext(), 110) + ((ScanSharedMaskView)localObject2).CSP);
        }
        label460:
        ((TextView)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject1);
        localObject3 = ((ScanSharedMaskView)localObject2).CSE;
        if (localObject3 == null) {
          p.btv("galleryButton");
        }
        localObject1 = ((ScanSharedMaskView)localObject2).CSE;
        if (localObject1 == null) {
          p.btv("galleryButton");
        }
        localObject1 = ((View)localObject1).getLayoutParams();
        if (localObject1 == null) {
          break label829;
        }
        if ((localObject1 instanceof ViewGroup.MarginLayoutParams)) {
          ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin = (com.tencent.mm.cb.a.fromDPToPix(((ScanSharedMaskView)localObject2).getContext(), 32) + ((ScanSharedMaskView)localObject2).CSP);
        }
        label547:
        ((View)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject1);
        if (!r.Xf(((ScanSharedMaskView)localObject2).CSG)) {
          break label835;
        }
        localObject1 = ((ScanSharedMaskView)localObject2).CJh;
        if (localObject1 == null) {
          p.btv("flashSwitcher");
        }
        ((ScannerFlashSwitcher)localObject1).setVisibility(8);
        if (((ScanSharedMaskView)localObject2).CSQ) {
          break label936;
        }
        if (((ScanSharedMaskView)localObject2).CSO) {
          break label931;
        }
      }
      break;
    }
    label931:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((ScanSharedMaskView)localObject2).uf(bool1);
      localObject1 = ((ScanSharedMaskView)localObject2).CSA;
      if (localObject1 == null) {
        p.btv("scanTitle");
      }
      ((TextView)localObject1).setVisibility(8);
      ((ScanSharedMaskView)localObject2).CSN = false;
      localObject1 = ((ScanSharedMaskView)localObject2).CSC;
      if (localObject1 == null) {
        p.btv("scanToast");
      }
      ((TextView)localObject1).setVisibility(8);
      ((ScanSharedMaskView)localObject2).eQC();
      ((ScanSharedMaskView)localObject2).WY(i);
      this.isFirst = false;
      AppMethodBeat.o(51960);
      return;
      eRi();
      this.CGD = new ScanCodeMaskView(getContext());
      addView(this.CGD);
      break;
      this.CGD = new ScanTranslationMaskView(getContext());
      addView(this.CGD);
      break;
      this.CGD = new ScanGoodsMaskView(getContext());
      addView(this.CGD);
      if ((!(this.CGD instanceof ScanGoodsMaskView)) || (!(this.CJD instanceof ScanGoodsRequest))) {
        break;
      }
      ((ScanGoodsMaskView)this.CGD).setScanRequest((ScanGoodsRequest)this.CJD);
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
      localObject3 = ((ScanSharedMaskView)localObject2).CJh;
      if (localObject3 == null) {
        p.btv("flashSwitcher");
      }
      localObject1 = ((ScanSharedMaskView)localObject2).CJh;
      if (localObject1 == null) {
        p.btv("flashSwitcher");
      }
      localObject1 = ((ScannerFlashSwitcher)localObject1).getLayoutParams();
      if (localObject1 != null) {
        if ((localObject1 instanceof ViewGroup.MarginLayoutParams)) {
          ((ViewGroup.MarginLayoutParams)localObject1).bottomMargin = (com.tencent.mm.cb.a.fromDPToPix(((ScanSharedMaskView)localObject2).getContext(), 32) + ((ScanSharedMaskView)localObject2).CSP);
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
    ((ScanSharedMaskView)localObject2).uf(false);
    ((ScanSharedMaskView)localObject2).eRF();
    ((ScanSharedMaskView)localObject2).eRG();
    Object localObject1 = ((ScanSharedMaskView)localObject2).CSA;
    if (localObject1 == null) {
      p.btv("scanTitle");
    }
    ((TextView)localObject1).setAlpha(1.0F);
    localObject1 = ((ScanSharedMaskView)localObject2).CSA;
    if (localObject1 == null) {
      p.btv("scanTitle");
    }
    if (((TextView)localObject1).getVisibility() != 0) {}
    for (bool1 = bool3;; bool1 = false)
    {
      if (((ScanSharedMaskView)localObject2).CSL == null)
      {
        localObject1 = new l();
        localObject3 = ((ScanSharedMaskView)localObject2).CSA;
        if (localObject3 == null) {
          p.btv("scanTitle");
        }
        localObject1 = ((l)localObject1).eV((View)localObject3).eRY().eRZ();
        ((l)localObject1).CUp = ((l.b)new ScanSharedMaskView.f((ScanSharedMaskView)localObject2));
        ((ScanSharedMaskView)localObject2).CSL = ((l)localObject1);
      }
      localObject1 = ((ScanSharedMaskView)localObject2).CSL;
      if (localObject1 == null) {
        break;
      }
      ((l)localObject1).ul(bool1);
      break;
    }
  }
  
  private void eRd()
  {
    AppMethodBeat.i(51962);
    String str = getScanTips();
    this.CGE.setScanTips(str);
    this.CGE.setScanRequest(this.CJD);
    switch (this.mode)
    {
    default: 
      Log.e("MicroMsg.ScanUIRectView", "alvinluo refreshSharedMaskView unknown scan mode %d", new Object[] { Integer.valueOf(this.mode) });
      AppMethodBeat.o(51962);
      return;
    case 1: 
    case 4: 
    case 8: 
      this.CGE.setScanTitle(getResources().getString(2131764906));
      AppMethodBeat.o(51962);
      return;
    case 3: 
      this.CGE.setScanTitle(getResources().getString(2131764905));
      AppMethodBeat.o(51962);
      return;
    }
    this.CGE.setScanTitle(getResources().getString(2131764901));
    AppMethodBeat.o(51962);
  }
  
  private void eRg()
  {
    AppMethodBeat.i(51970);
    if (this.CGD != null)
    {
      final BaseScanMaskView localBaseScanMaskView = this.CGD;
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
  
  private void eRi()
  {
    AppMethodBeat.i(162394);
    if (com.tencent.qbar.f.hkm())
    {
      Log.i("MicroMsg.ScanUIRectView", "alvinluo updateScanCodeRect visibleResolution: %s", new Object[] { this.sRG });
      if ((this.sRG != null) && (this.sRG.x > 0) && (this.sRG.y > 0))
      {
        this.CNj.setDecorRect(new Rect(0, (int)(this.sRG.y * 1.0F / 19.0F), this.sRG.x, (int)(this.sRG.y * 17.0F / 19.0F)));
        AppMethodBeat.o(162394);
      }
    }
    else
    {
      this.CNj.ij(getResources().getDimensionPixelSize(2131166881), getResources().getDimensionPixelSize(2131166880));
    }
    AppMethodBeat.o(162394);
  }
  
  private void eRj()
  {
    AppMethodBeat.i(160188);
    if (this.CNF != null) {
      removeCallbacks(this.CNF);
    }
    AppMethodBeat.o(160188);
  }
  
  private Rect getScanCodeRect()
  {
    int j = 0;
    AppMethodBeat.i(51975);
    if (com.tencent.qbar.f.hkm())
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
    if (!this.CJu)
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
      str = getResources().getString(2131764984);
      AppMethodBeat.o(51963);
      return str;
    case 8: 
      str = getResources().getString(2131764084);
      AppMethodBeat.o(51963);
      return str;
    case 4: 
      str = getResources().getString(2131764085);
      AppMethodBeat.o(51963);
      return str;
    case 3: 
      str = getResources().getString(2131764993);
      AppMethodBeat.o(51963);
      return str;
    }
    if (!Util.isNullOrNil(this.CNm))
    {
      str = this.CNm;
      AppMethodBeat.o(51963);
      return str;
    }
    String str = getResources().getString(2131764920);
    AppMethodBeat.o(51963);
    return str;
  }
  
  private void tY(boolean paramBoolean)
  {
    AppMethodBeat.i(51974);
    if (this.CGD != null) {
      this.CGD.tY(paramBoolean);
    }
    if (this.CGE != null) {
      this.CGE.tY(paramBoolean);
    }
    if (this.CNk != null) {
      this.CNk.setVisibility(8);
    }
    if (this.CNn != null) {
      this.CNn.ePO();
    }
    AppMethodBeat.o(51974);
  }
  
  public final void IC(long paramLong)
  {
    AppMethodBeat.i(51957);
    this.CNu = true;
    Log.d("MicroMsg.ScanUIRectView", "alvinluo takeOneShot timeout: %d, isRetry: %b, onPreviewFrameCalled: %b, canReportOnPreviewFrame: %b, hasReport: %b", new Object[] { Long.valueOf(this.mTimeout), Boolean.valueOf(this.isRetry), Boolean.valueOf(this.CNE), Boolean.valueOf(this.CND), Boolean.valueOf(this.CNC) });
    if (!this.isRetry)
    {
      super.IC(paramLong);
      this.CNB = System.currentTimeMillis();
      if ((!this.CNE) && (this.CND) && (r.Xd(this.mode)))
      {
        removeCallbacks(this.CNF);
        postDelayed(this.CNF, this.mTimeout);
        AppMethodBeat.o(51957);
      }
    }
    else if ((this.CNz != null) && (this.CNz.Xc(this.CNA)))
    {
      if (this.CNA == 1)
      {
        super.IC(paramLong);
        this.CNB = System.currentTimeMillis();
        AppMethodBeat.o(51957);
        return;
      }
      if (this.CNA == 2) {
        ID(paramLong);
      }
    }
    AppMethodBeat.o(51957);
  }
  
  public final void a(final b.b.a parama)
  {
    AppMethodBeat.i(161041);
    super.a(new b.b.a()
    {
      public final void eRl()
      {
        AppMethodBeat.i(161029);
        ScanUIRectView.h(ScanUIRectView.this);
        if (parama != null) {
          parama.eRl();
        }
        AppMethodBeat.o(161029);
      }
    });
    AppMethodBeat.o(161041);
  }
  
  public final void a(final Object paramObject, final com.tencent.mm.plugin.scanner.view.d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(240796);
    if (paramBoolean)
    {
      com.tencent.f.h.RTc.n(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(170023);
          ScanUIRectView.a(ScanUIRectView.this, paramObject, paramd);
          AppMethodBeat.o(170023);
        }
      }, 200L);
      AppMethodBeat.o(240796);
      return;
    }
    a(paramObject, paramd);
    AppMethodBeat.o(240796);
  }
  
  public final void b(boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(51965);
    if (this.CGD != null) {
      this.CGD.b(paramBoolean, paramOnCancelListener);
    }
    AppMethodBeat.o(51965);
  }
  
  public final void cWj()
  {
    AppMethodBeat.i(51978);
    if ((this.CGD != null) && ((this.CGD instanceof ScanCodeMaskView))) {
      ((ScanCodeMaskView)this.CGD).cWj();
    }
    AppMethodBeat.o(51978);
  }
  
  public final void eQY()
  {
    AppMethodBeat.i(51948);
    this.ROY = new com.tencent.mm.plugin.scanner.a.a();
    AppMethodBeat.o(51948);
  }
  
  public final boolean eQZ()
  {
    AppMethodBeat.i(51950);
    if (this.ROY != null)
    {
      boolean bool = ((com.tencent.scanlib.a.a)this.ROY).eQZ();
      AppMethodBeat.o(51950);
      return bool;
    }
    AppMethodBeat.o(51950);
    return false;
  }
  
  public final void eRa()
  {
    AppMethodBeat.i(51952);
    Log.i("MicroMsg.ScanUIRectView", "alvinluo stopCurrentSession %d", new Object[] { Long.valueOf(this.CDU) });
    com.tencent.qbar.h.hkp().Iv(this.CDU);
    com.tencent.mm.plugin.scanner.d.a.ePJ().Iv(this.CDU);
    this.CDU = 0L;
    AppMethodBeat.o(51952);
  }
  
  public final void eRe()
  {
    AppMethodBeat.i(51967);
    if ((this.CGE != null) && (!this.CJh.ddZ)) {
      this.CGE.uh(true);
    }
    AppMethodBeat.o(51967);
  }
  
  public final void eRf()
  {
    AppMethodBeat.i(51968);
    if ((this.CGE != null) && (this.CJh.ddZ)) {
      this.CGE.uh(false);
    }
    AppMethodBeat.o(51968);
  }
  
  public final void eRh()
  {
    AppMethodBeat.i(240798);
    onPause();
    stopPreview();
    AppMethodBeat.o(240798);
  }
  
  public Rect getDecorRect()
  {
    AppMethodBeat.i(51976);
    Rect localRect = this.CNj.getDecorRect();
    AppMethodBeat.o(51976);
    return localRect;
  }
  
  public com.tencent.scanlib.a.f getScanCamera()
  {
    return this.ROY;
  }
  
  public BaseScanMaskView getScanMaskView()
  {
    return this.CGD;
  }
  
  public ScanSharedMaskView getSharedMaskView()
  {
    return this.CGE;
  }
  
  public TextureView getTextrueView()
  {
    return this.bec;
  }
  
  public final void init()
  {
    AppMethodBeat.i(51959);
    super.init();
    this.CNj = new ScanRectDecorView(getContext());
    if (this.CJO) {
      this.CNm = x.eQa();
    }
    Log.i("MicroMsg.ScanUIRectView", "initScanGoodsTips enable: %b, %s", new Object[] { Boolean.valueOf(this.CJO), this.CNm });
    addView(this.CNj, new FrameLayout.LayoutParams(-1, -1));
    this.CGE = new ScanSharedMaskView(getContext());
    this.CJh = this.CGE.getFlashSwitcherView();
    addView(this.CGE, new FrameLayout.LayoutParams(-1, -1));
    eRd();
    AppMethodBeat.o(51959);
  }
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    AppMethodBeat.i(51972);
    Log.i("MicroMsg.ScanUIRectView", "onAutoFocus %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.CND = false;
      IC(0L);
    }
    Oy(RPb);
    AppMethodBeat.o(51972);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(51949);
    super.onCreate();
    this.CNr = ((int)(com.tencent.mm.cb.a.jn(getContext()) / 4.5F));
    if (r.Xd(this.mode)) {
      com.tencent.qbar.h.hkp().init(getContext());
    }
    com.tencent.qbar.h.hkp().RKr = new an();
    setOnTouchListener(new View.OnTouchListener()
    {
      private float CNT;
      private float CNU = 400.0F;
      private boolean CNV = false;
      
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
          com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().bl(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, locala.axQ(), "com/tencent/mm/plugin/scanner/ui/ScanUIRectView$16", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousView.onTouchEvent((MotionEvent)locala.pG(0)), "com/tencent/mm/plugin/scanner/ui/ScanUIRectView$16", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
          if (paramAnonymousMotionEvent.getAction() == 1) {
            ScanUIRectView.c(ScanUIRectView.this, false);
          }
          AppMethodBeat.o(161027);
          return true;
          Log.d("MicroMsg.ScanUIRectView", "first down,pointer:%d,x:%f,y:%f", new Object[] { Integer.valueOf(j), Float.valueOf(paramAnonymousMotionEvent.getX()), Float.valueOf(paramAnonymousMotionEvent.getY()) });
          ScanUIRectView.a(ScanUIRectView.this, paramAnonymousMotionEvent.getRawX());
          ScanUIRectView.b(ScanUIRectView.this, true);
          this.CNV = false;
          continue;
          Log.d("MicroMsg.ScanUIRectView", "down,pointer:%d,x:%f,y:%f", new Object[] { Integer.valueOf(j), Float.valueOf(paramAnonymousMotionEvent.getX(j)), Float.valueOf(paramAnonymousMotionEvent.getY(j)) });
          if (paramAnonymousMotionEvent.getPointerCount() == 2)
          {
            this.CNT = ((float)(Math.pow(paramAnonymousMotionEvent.getX(0) - paramAnonymousMotionEvent.getX(1), 2.0D) + Math.pow(paramAnonymousMotionEvent.getY(0) - paramAnonymousMotionEvent.getY(1), 2.0D)));
            ScanUIRectView.c(ScanUIRectView.this, true);
          }
          this.CNV = false;
          continue;
          Log.d("MicroMsg.ScanUIRectView", "last up,pointer:%d,x:%f,y:%f", new Object[] { Integer.valueOf(j), Float.valueOf(paramAnonymousMotionEvent.getX()), Float.valueOf(paramAnonymousMotionEvent.getY()) });
          if (paramAnonymousMotionEvent.getPointerCount() == 2)
          {
            this.CNT = ((float)(Math.pow(paramAnonymousMotionEvent.getX(0) - paramAnonymousMotionEvent.getX(1), 2.0D) + Math.pow(paramAnonymousMotionEvent.getY(0) - paramAnonymousMotionEvent.getY(1), 2.0D)));
            continue;
            Log.d("MicroMsg.ScanUIRectView", "up,pointer:%d,x:%f,y:%f", new Object[] { Integer.valueOf(j), Float.valueOf(paramAnonymousMotionEvent.getX(j)), Float.valueOf(paramAnonymousMotionEvent.getY(j)) });
            if (paramAnonymousMotionEvent.getPointerCount() == 2)
            {
              this.CNT = ((float)(Math.pow(paramAnonymousMotionEvent.getX(0) - paramAnonymousMotionEvent.getX(1), 2.0D) + Math.pow(paramAnonymousMotionEvent.getY(0) - paramAnonymousMotionEvent.getY(1), 2.0D)));
              if (this.CNV)
              {
                this.CNV = false;
                af.ia(ScanUIRectView.B(ScanUIRectView.this), 4);
                continue;
                float f;
                if (paramAnonymousMotionEvent.getPointerCount() == 2)
                {
                  Log.d("MicroMsg.ScanUIRectView", "move,pointer:0,x:%f,y:%f", new Object[] { Float.valueOf(paramAnonymousMotionEvent.getX(0)), Float.valueOf(paramAnonymousMotionEvent.getY(0)) });
                  Log.d("MicroMsg.ScanUIRectView", "move,pointer:1,x:%f,y:%f", new Object[] { Float.valueOf(paramAnonymousMotionEvent.getX(1)), Float.valueOf(paramAnonymousMotionEvent.getY(1)) });
                  f = (float)(Math.pow(paramAnonymousMotionEvent.getX(0) - paramAnonymousMotionEvent.getX(1), 2.0D) + Math.pow(paramAnonymousMotionEvent.getY(0) - paramAnonymousMotionEvent.getY(1), 2.0D));
                  Log.d("MicroMsg.ScanUIRectView", "distance:%f,lastDistance:%f,min move:%f", new Object[] { Float.valueOf(f), Float.valueOf(this.CNT), Float.valueOf(this.CNU) });
                  if (Math.abs(f - this.CNT) > this.CNU)
                  {
                    if (ScanUIRectView.n(ScanUIRectView.this)) {
                      ScanUIRectView.G(ScanUIRectView.this);
                    }
                    if (f - this.CNT > 0.0F) {
                      ((com.tencent.scanlib.a.a)ScanUIRectView.H(ScanUIRectView.this)).aqF(2);
                    }
                    for (this.CNV = true;; this.CNV = true)
                    {
                      this.CNT = f;
                      break;
                      ((com.tencent.scanlib.a.a)ScanUIRectView.I(ScanUIRectView.this)).aqF(3);
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
                      ScanUIRectView.F(ScanUIRectView.this).eRE();
                    }
                    ScanUIRectView.b(ScanUIRectView.this, false);
                  }
                  else if ((f <= -ScanUIRectView.K(ScanUIRectView.this)) && (ScanUIRectView.C(ScanUIRectView.this)))
                  {
                    if (ScanUIRectView.F(ScanUIRectView.this) != null) {
                      ScanUIRectView.F(ScanUIRectView.this).eRD();
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
    EventCenter.instance.addListener(this.CNK);
    if (this.CNz != null) {
      this.CNz.viC = System.currentTimeMillis();
    }
    AppMethodBeat.o(51949);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(51955);
    super.onDestroy();
    Log.d("MicroMsg.ScanUIRectView", "alvinluo releaseView");
    if (this.CGD != null) {
      this.CGD.release();
    }
    if (this.CGE != null)
    {
      localObject = this.CGE;
      Log.d("MicroMsg.ScanSharedMaskView", "alvinluo release hashCode: %d", new Object[] { Integer.valueOf(((ScanSharedMaskView)localObject).hashCode()) });
      ((ScanSharedMaskView)localObject).eRF();
      ((ScanSharedMaskView)localObject).eRG();
    }
    com.tencent.qbar.h.hkp().release();
    Object localObject = com.tencent.mm.plugin.scanner.d.a.ePJ();
    Log.i("MicroMsg.AiScanImageDecodeQueueNew", "alvinluo release");
    x.a(new a.3((com.tencent.mm.plugin.scanner.d.a)localObject));
    EventCenter.instance.removeListener(this.CNK);
    removeCallbacks(this.CNF);
    this.CNF = null;
    if (this.CNz != null)
    {
      localObject = this.CNz;
      ((com.tencent.mm.plugin.scanner.util.h)localObject).CTQ = System.currentTimeMillis();
      ((com.tencent.mm.plugin.scanner.util.h)localObject).dUy = (((com.tencent.mm.plugin.scanner.util.h)localObject).CTQ - ((com.tencent.mm.plugin.scanner.util.h)localObject).viC);
      Log.i("MicroMsg.ScanRetryManager", "alvinluo exitScanUI stayTime: %d, isUpdated: %b, onPreviewFrameCalled: %b, isRetry: %b", new Object[] { Long.valueOf(((com.tencent.mm.plugin.scanner.util.h)localObject).dUy), Boolean.valueOf(((com.tencent.mm.plugin.scanner.util.h)localObject).CTL), Boolean.valueOf(((com.tencent.mm.plugin.scanner.util.h)localObject).CNE), Boolean.valueOf(((com.tencent.mm.plugin.scanner.util.h)localObject).isRetry) });
      af.a(((com.tencent.mm.plugin.scanner.util.h)localObject).CTM, ((com.tencent.mm.plugin.scanner.util.h)localObject).isRetry, ((com.tencent.mm.plugin.scanner.util.h)localObject).CNE, ((com.tencent.mm.plugin.scanner.util.h)localObject).dUy);
      af.i(((com.tencent.mm.plugin.scanner.util.h)localObject).CTM, ((com.tencent.mm.plugin.scanner.util.h)localObject).isRetry, ((com.tencent.mm.plugin.scanner.util.h)localObject).CTR);
      if (!((com.tencent.mm.plugin.scanner.util.h)localObject).CTL) {
        break label292;
      }
      ((com.tencent.mm.plugin.scanner.util.h)localObject).IE(((com.tencent.mm.plugin.scanner.util.h)localObject).mTimeout);
    }
    for (;;)
    {
      if ((r.Xd(this.mode)) && (!this.CNu)) {
        af.eQl();
      }
      AppMethodBeat.o(51955);
      return;
      label292:
      if (!((com.tencent.mm.plugin.scanner.util.h)localObject).CTL)
      {
        ((com.tencent.mm.plugin.scanner.util.h)localObject).mTimeout = ((com.tencent.mm.plugin.scanner.util.h)localObject).CTI;
        ((com.tencent.mm.plugin.scanner.util.h)localObject).IE(((com.tencent.mm.plugin.scanner.util.h)localObject).mTimeout);
        Log.i("MicroMsg.ScanRetryManager", "alvinluo checkAndResetTimeout timeout not updated and reset to %d", new Object[] { Long.valueOf(((com.tencent.mm.plugin.scanner.util.h)localObject).mTimeout) });
      }
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(51953);
    super.onPause();
    Log.i("MicroMsg.ScanUIRectView", "alvinluo onPause");
    eRj();
    if (this.CGD != null) {
      this.CGD.onPause();
    }
    eRa();
    if (this.iOv != null) {
      this.iOv.c(this.gmA);
    }
    AppMethodBeat.o(51953);
  }
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    AppMethodBeat.i(51973);
    super.onPreviewFrame(paramArrayOfByte, paramCamera);
    this.CNE = true;
    boolean bool;
    int i;
    if (paramArrayOfByte == null)
    {
      bool = true;
      Log.d("MicroMsg.ScanUIRectView", "onPreviewFrame null data: %b, isPreviewPaused: %b, canResumePreview: %b", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(this.CNw), Boolean.valueOf(this.CNx) });
      if (this.CNA == 2) {
        if (this.CNz != null)
        {
          paramCamera = this.CNz;
          i = this.CNA;
          Log.i("MicroMsg.ScanRetryManager", "alvinluo cancelRetryType: %d", new Object[] { Integer.valueOf(i) });
          if (i != 1) {
            break label260;
          }
          paramCamera.CTN = false;
        }
      }
    }
    for (;;)
    {
      this.isRetry = false;
      removeCallbacks(this.CNF);
      if (this.CNz != null)
      {
        paramCamera = this.CNz;
        long l1 = System.currentTimeMillis();
        long l2 = this.CNB;
        if (!paramCamera.CTL)
        {
          paramCamera.CTL = true;
          l1 = ((float)(l1 - l2) * paramCamera.CTK);
          paramCamera.mTimeout = Math.max(paramCamera.CTJ, Math.min(paramCamera.CTI, l1));
        }
        this.CNz.CNE = true;
      }
      if ((!this.CNw) || (!this.CNx)) {
        break label273;
      }
      this.CNw = false;
      this.CNx = false;
      tX(false);
      IC(100L);
      AppMethodBeat.o(51973);
      return;
      bool = false;
      break;
      label260:
      if (i == 2) {
        paramCamera.CTO = false;
      }
    }
    label273:
    if (this.CNy)
    {
      Log.w("MicroMsg.ScanUIRectView", "alvinluo onPreviewFrame ignorePreviewFrame");
      AppMethodBeat.o(51973);
      return;
    }
    if (paramArrayOfByte == null)
    {
      Log.w("MicroMsg.ScanUIRectView", "alvinluo onPreviewFrame data is null");
      IC(0L);
      af.eQk();
      AppMethodBeat.o(51973);
      return;
    }
    bX(paramArrayOfByte);
    AppMethodBeat.o(51973);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(51951);
    super.onResume();
    if (!this.ROY.isOpen())
    {
      Log.i("MicroMsg.ScanUIRectView", "alvinluo onResume openCamera");
      a(null);
      Log.i("MicroMsg.ScanUIRectView", "onResume %s", new Object[] { Util.getStack() });
      this.CDU = System.currentTimeMillis();
      if (!r.Xd(this.mode)) {
        break label244;
      }
      com.tencent.qbar.h.hkp().a(this.CDU, this.CNI);
    }
    for (;;)
    {
      this.CNs = false;
      if (this.CGD != null) {
        this.CGD.onResume();
      }
      MMHandlerThread.postToMainThreadDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(51923);
          if ((ScanUIRectView.f(ScanUIRectView.this) != null) && (ScanUIRectView.f(ScanUIRectView.this).CAG))
          {
            AppMethodBeat.o(51923);
            return;
          }
          ScanCameraLightDetector.CTx.start(((com.tencent.mm.plugin.scanner.a.a)ScanUIRectView.g(ScanUIRectView.this)).getFocusMode());
          AppMethodBeat.o(51923);
        }
      }, 300L);
      this.CNx = true;
      AppMethodBeat.o(51951);
      return;
      if (!this.ROY.dEO())
      {
        Log.i("MicroMsg.ScanUIRectView", "alvinluo onResume startPreview");
        ((com.tencent.mm.plugin.scanner.a.a)this.ROY).ePC();
        a(new b.d.a()
        {
          public final void eRk()
          {
            AppMethodBeat.i(170017);
            ScanUIRectView.this.IC(0L);
            AppMethodBeat.o(170017);
          }
        });
        Log.i("MicroMsg.ScanUIRectView", "focus mode %s", new Object[] { this.ROY.getFocusMode() });
        break;
      }
      Log.i("MicroMsg.ScanUIRectView", "alvinluo onResume camera is previewing");
      Log.i("MicroMsg.ScanUIRectView", "focus mode %s", new Object[] { this.ROY.getFocusMode() });
      IC(0L);
      break;
      label244:
      if (this.mode == 12)
      {
        Log.i("MicroMsg.ScanUIRectView", "alvinluo onResume currentNetworkAvailable: %b", new Object[] { Boolean.valueOf(this.CJv) });
        if (this.CJv)
        {
          com.tencent.mm.plugin.scanner.d.a locala = com.tencent.mm.plugin.scanner.d.a.ePJ();
          long l = this.CDU;
          com.tencent.mm.plugin.scanner.d.a.a locala1 = this.CNJ;
          synchronized (locala.CCt)
          {
            locala.CDU = l;
            locala.CEl = locala1;
            synchronized (locala.CEk)
            {
              if (locala.gKM) {
                x.reset();
              }
            }
          }
        }
        com.tencent.mm.plugin.scanner.d.a.ePJ().Iv(this.CDU);
      }
    }
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(51954);
    super.onStop();
    aPK();
    ScanCameraLightDetector.CTx.stop();
    AppMethodBeat.o(51954);
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(162395);
    super.onSurfaceTextureAvailable(paramSurfaceTexture, paramInt1, paramInt2);
    if ((this.sRG == null) || (paramInt1 != this.sRG.x) || (paramInt2 != this.sRG.y))
    {
      if (this.sRG == null) {
        this.sRG = new Point(paramInt1, paramInt2);
      }
      if (r.Xd(this.mode)) {
        eRi();
      }
    }
    AppMethodBeat.o(162395);
  }
  
  public final void refreshView()
  {
    AppMethodBeat.i(51961);
    this.CNj.setVisibility(8);
    eRd();
    eRg();
    eRc();
    AppMethodBeat.o(51961);
  }
  
  public void setActivity(Activity paramActivity)
  {
    this.activity = paramActivity;
  }
  
  public void setBlackInterval(int paramInt)
  {
    AppMethodBeat.i(170024);
    com.tencent.qbar.h localh = com.tencent.qbar.h.hkp();
    synchronized (localh.lQo)
    {
      if (localh.lQo.hasInited()) {
        localh.lQo.setBlackInterval(paramInt);
      }
      AppMethodBeat.o(170024);
      return;
    }
  }
  
  public void setBottomExtraHeight(int paramInt)
  {
    this.CNq = paramInt;
  }
  
  public void setDecodeSuccessFrameData(ScanDecodeFrameData paramScanDecodeFrameData)
  {
    AppMethodBeat.i(170026);
    if (this.CGD != null) {
      this.CGD.setDecodeSuccessFrameData(paramScanDecodeFrameData);
    }
    AppMethodBeat.o(170026);
  }
  
  public void setDecorRect(Rect paramRect)
  {
    AppMethodBeat.i(51977);
    this.CNj.setDecorRect(paramRect);
    AppMethodBeat.o(51977);
  }
  
  public void setEnableScanGoodsDynamicWording(boolean paramBoolean)
  {
    this.CJO = paramBoolean;
  }
  
  public void setEnableScrollSwitchTab(boolean paramBoolean)
  {
    AppMethodBeat.i(51958);
    Log.i("MicroMsg.ScanUIRectView", "alvinluo setEnableScrollSwitchTab: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.CNo = paramBoolean;
    AppMethodBeat.o(51958);
  }
  
  public void setFlashStatus(boolean paramBoolean)
  {
    AppMethodBeat.i(51966);
    if (this.CGE != null) {
      this.CGE.setFlashStatus(paramBoolean);
    }
    AppMethodBeat.o(51966);
  }
  
  public void setIgnorePreviewFrame(boolean paramBoolean)
  {
    AppMethodBeat.i(240795);
    Log.d("MicroMsg.ScanUIRectView", "alvinluo setIgnorePreviewFrame %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.CNy = paramBoolean;
    AppMethodBeat.o(240795);
  }
  
  public void setMyQrCodeVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(240794);
    if ((this.CGD instanceof ScanCodeMaskView)) {
      ((ScanCodeMaskView)this.CGD).setMyQrCodeButtonVisible(paramBoolean);
    }
    AppMethodBeat.o(240794);
  }
  
  public void setNetworkAvailable(boolean paramBoolean)
  {
    this.CJv = paramBoolean;
  }
  
  public void setScanCallback(a parama)
  {
    this.CNl = parama;
  }
  
  public void setScanCodeReaders(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(51979);
    com.tencent.qbar.h.hkp().S(paramArrayOfInt);
    AppMethodBeat.o(51979);
  }
  
  public void setScanMode(int paramInt)
  {
    this.mode = paramInt;
  }
  
  public void setScanRequest(BaseScanRequest paramBaseScanRequest)
  {
    this.CJD = paramBaseScanRequest;
  }
  
  public void setScanSource(int paramInt)
  {
    AppMethodBeat.i(51964);
    if (this.CGD != null) {
      this.CGD.setScanSource(paramInt);
    }
    AppMethodBeat.o(51964);
  }
  
  public void setScrollTabController(com.tencent.mm.plugin.scanner.ui.widget.b paramb)
  {
    this.CJn = paramb;
  }
  
  public void setShowScanTips(boolean paramBoolean)
  {
    this.CJu = paramBoolean;
  }
  
  public void setSuccessMarkClickListener(ag paramag)
  {
    AppMethodBeat.i(170025);
    if ((this.CGD instanceof ScanCodeMaskView)) {
      ((ScanCodeMaskView)this.CGD).setSuccessMarkClickListener(paramag);
    }
    AppMethodBeat.o(170025);
  }
  
  public final void stopPreview()
  {
    AppMethodBeat.i(51956);
    super.stopPreview();
    this.CNw = true;
    this.CNx = false;
    AppMethodBeat.o(51956);
  }
  
  public final void tW(boolean paramBoolean)
  {
    boolean bool2 = true;
    AppMethodBeat.i(51969);
    Log.v("MicroMsg.ScanUIRectView", "alvinluo onShowNoDataView show: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    Object localObject;
    boolean bool1;
    if (this.CGE != null)
    {
      localObject = this.CGE;
      if (!paramBoolean)
      {
        bool1 = true;
        ((ScanSharedMaskView)localObject).ui(bool1);
      }
    }
    else if (this.CGD != null)
    {
      localObject = this.CGD;
      if (paramBoolean) {
        break label90;
      }
    }
    label90:
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      ((BaseScanMaskView)localObject).ui(paramBoolean);
      AppMethodBeat.o(51969);
      return;
      bool1 = false;
      break;
    }
  }
  
  public final void tX(final boolean paramBoolean)
  {
    AppMethodBeat.i(170027);
    af.WA(this.mode);
    if (this.mode == 12) {
      af.aE(1, System.currentTimeMillis());
    }
    if (Looper.getMainLooper().getThread() == Thread.currentThread())
    {
      tY(paramBoolean);
      AppMethodBeat.o(170027);
      return;
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(240779);
        ScanUIRectView.a(ScanUIRectView.this, paramBoolean);
        AppMethodBeat.o(240779);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ScanUIRectView
 * JD-Core Version:    0.7.0.1
 */
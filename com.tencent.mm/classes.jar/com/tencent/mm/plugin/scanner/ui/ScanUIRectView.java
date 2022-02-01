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
import com.tencent.mm.g.a.sl;
import com.tencent.mm.modelgeo.d;
import com.tencent.mm.plugin.scanner.api.BaseScanRequest;
import com.tencent.mm.plugin.scanner.api.ScanGoodsRequest;
import com.tencent.mm.plugin.scanner.c.a.3;
import com.tencent.mm.plugin.scanner.model.ac;
import com.tencent.mm.plugin.scanner.model.aj;
import com.tencent.mm.plugin.scanner.model.u;
import com.tencent.mm.plugin.scanner.model.v;
import com.tencent.mm.plugin.scanner.ui.scangoods.widget.ScanGoodsMaskView;
import com.tencent.mm.plugin.scanner.ui.widget.ScanCodeMaskView;
import com.tencent.mm.plugin.scanner.ui.widget.ScanDebugView;
import com.tencent.mm.plugin.scanner.ui.widget.ScanSharedMaskView;
import com.tencent.mm.plugin.scanner.util.ScanCameraLightDetector;
import com.tencent.mm.plugin.scanner.util.l;
import com.tencent.mm.plugin.scanner.view.BaseScanMaskView;
import com.tencent.mm.plugin.scanner.view.ScanRectDecorView;
import com.tencent.mm.plugin.scanner.view.ScanTranslationMaskView;
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
import d.g.b.p;
import java.util.ArrayList;
import java.util.List;

public class ScanUIRectView
  extends ScanView
{
  public static final int ytH;
  private Activity activity;
  private com.tencent.mm.modelgeo.b.a fFl;
  private d hQo;
  private GestureDetector iKD;
  private boolean isFirst;
  private boolean isRetry;
  private long mTimeout;
  int mode;
  private Point rif;
  private boolean tQI;
  private boolean vgd;
  private float yjW;
  private long ylu;
  BaseScanMaskView ynO;
  private ScanSharedMaskView ynP;
  private boolean ypH;
  boolean ypI;
  private BaseScanRequest ypQ;
  private ScannerFlashSwitcher ypq;
  private com.tencent.mm.plugin.scanner.ui.widget.b ypz;
  private boolean ytA;
  private boolean ytB;
  private int ytC;
  private int ytD;
  private boolean ytE;
  private boolean ytF;
  private boolean ytG;
  private boolean ytI;
  private boolean ytJ;
  private com.tencent.mm.plugin.scanner.util.g ytK;
  private int ytL;
  private long ytM;
  private boolean ytN;
  private boolean ytO;
  private boolean ytP;
  private Runnable ytQ;
  private int ytR;
  private int ytS;
  private h.c ytT;
  private com.tencent.mm.plugin.scanner.c.a.a ytU;
  private com.tencent.mm.sdk.b.c<sl> ytV;
  private long ytW;
  private b ytX;
  private ScanRectDecorView ytx;
  ScanDebugView yty;
  private ScanUIRectView.a ytz;
  
  static
  {
    AppMethodBeat.i(51980);
    ytH = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(com.tencent.mm.plugin.expt.b.b.a.qFo, 50);
    AppMethodBeat.o(51980);
  }
  
  public ScanUIRectView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(51945);
    this.mode = 1;
    this.ypH = true;
    this.ypI = false;
    this.ytA = true;
    this.ytB = false;
    this.ytC = 0;
    this.ytD = 120;
    this.tQI = false;
    this.rif = null;
    this.ytF = true;
    this.ytG = false;
    this.ytI = false;
    this.ytJ = false;
    this.isFirst = true;
    this.ytK = new com.tencent.mm.plugin.scanner.util.g();
    this.ytL = 0;
    this.ytM = 0L;
    this.mTimeout = this.ytK.mTimeout;
    this.ytN = false;
    this.ytO = true;
    this.ytP = false;
    this.isRetry = false;
    this.ytQ = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(51916);
        if ((ScanUIRectView.a(ScanUIRectView.this)) && (!ScanUIRectView.b(ScanUIRectView.this)))
        {
          ScanUIRectView.c(ScanUIRectView.this);
          ScanUIRectView.d(ScanUIRectView.this);
          ac.dLk();
          ScanUIRectView.e(ScanUIRectView.this);
        }
        AppMethodBeat.o(51916);
      }
    };
    this.ytR = 0;
    this.ytS = 0;
    this.ytT = new h.c()
    {
      public final void a(final long paramAnonymousLong, List<com.tencent.qbar.a.a> paramAnonymousList, final List<QbarNative.QBarPoint> paramAnonymousList1, final List<WxQbarNative.QBarReportMsg> paramAnonymousList2, final Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(186223);
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ScanUIRectView", String.format("scan code after decode %d", new Object[] { Long.valueOf(paramAnonymousLong) }));
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
                ScanUIRectView.this.dLX();
                localArrayList = new ArrayList();
                if ((paramAnonymousList2 != null) && (!paramAnonymousList2.isEmpty()))
                {
                  com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ScanUIRectView", "alvinluo onDecodeSuccess result size: %d", new Object[] { Integer.valueOf(paramAnonymousList2.size()) });
                  j = 0;
                  i = 0;
                  if (j < paramAnonymousList2.size())
                  {
                    localObject1 = (com.tencent.qbar.a.a)paramAnonymousList2.get(j);
                    localObject1 = new WxQBarResult(((com.tencent.qbar.a.a)localObject1).typeID, ((com.tencent.qbar.a.a)localObject1).typeName, ((com.tencent.qbar.a.a)localObject1).data, ((com.tencent.qbar.a.a)localObject1).rawData, ((com.tencent.qbar.a.a)localObject1).charset, ((com.tencent.qbar.a.a)localObject1).priorityLevel);
                    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ScanUIRectView", "alvinluo onDecodeSuccess result index: %d, format: %d, content:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(((WxQBarResult)localObject1).typeID), ((WxQBarResult)localObject1).data });
                    if ((paramAnonymousList1 != null) && (paramAnonymousList1.size() >= j + 1))
                    {
                      localObject2 = (WxQbarNative.QBarReportMsg)paramAnonymousList1.get(j);
                      if (localObject2 != null) {
                        ((WxQBarResult)localObject1).LKn = ((WxQbarNative.QBarReportMsg)localObject2).qrcodeVersion;
                      }
                    }
                    if ((paramAnonymousBundle == null) || (paramAnonymousBundle.size() < j + 1)) {
                      break label426;
                    }
                    Object localObject2 = (QbarNative.QBarPoint)paramAnonymousBundle.get(j);
                    if (localObject2 == null) {
                      break label426;
                    }
                    ((WxQBarResult)localObject1).LKP = new WxQBarPoint((QbarNative.QBarPoint)localObject2);
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
                if (this.yua != null) {
                  ((Bundle)localObject1).putAll(this.yua);
                }
                ScanUIRectView.this.cwE();
                if (ScanUIRectView.m(ScanUIRectView.this) != null) {
                  ScanUIRectView.m(ScanUIRectView.this).e(ScanUIRectView.l(ScanUIRectView.this), (Bundle)localObject1);
                }
                AppMethodBeat.o(161010);
                return;
              }
            }
          });
        }
        AppMethodBeat.o(186223);
      }
      
      public final void ag(final long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(170011);
        ScanUIRectView.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(161009);
            if ((paramAnonymousLong1 == ScanUIRectView.l(ScanUIRectView.this)) && (paramAnonymousLong1 != 0L)) {
              ScanUIRectView.this.zb(this.uIT);
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
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ScanUIRectView", "zoom to scale %f", new Object[] { Float.valueOf(f) });
              if ((f > 0.0F) && (ScanUIRectView.n(ScanUIRectView.this)) && (ScanUIRectView.o(ScanUIRectView.this).cLT()))
              {
                int i = (int)(((com.tencent.scanlib.a.a)ScanUIRectView.p(ScanUIRectView.this)).fUn() * f);
                ((com.tencent.scanlib.a.a)ScanUIRectView.q(ScanUIRectView.this)).agI(i);
                com.tencent.qbar.c localc = com.tencent.qbar.c.LKe;
                localc.LKs += 1;
                localc.LKt *= f;
                localc.LKu = (System.currentTimeMillis() - localc.yom);
                com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.QBarEngineReporter", "alvinluo zoom %d, zoomFactor: %s, totalZoomFactor: %s, lastZoomCostTime: %d", new Object[] { Integer.valueOf(localc.LKs), Float.valueOf(f), Float.valueOf(localc.LKt), Long.valueOf(localc.LKu) });
              }
            }
            AppMethodBeat.o(170010);
          }
        });
        AppMethodBeat.o(170013);
      }
    };
    this.ytU = new ScanUIRectView.3(this);
    this.fFl = new com.tencent.mm.modelgeo.b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(161020);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ScanUIRectView", "onGetLocation %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (!paramAnonymousBoolean)
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ScanUIRectView", "check permission not passed!");
          if ((!ScanUIRectView.s(ScanUIRectView.this)) && (!d.aHR()))
          {
            ScanUIRectView.t(ScanUIRectView.this);
            com.tencent.mm.ui.base.h.a(ScanUIRectView.this.getContext(), ScanUIRectView.this.getContext().getString(2131760082), ScanUIRectView.this.getContext().getString(2131755906), ScanUIRectView.this.getContext().getString(2131760598), ScanUIRectView.this.getContext().getString(2131755691), false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(161019);
                d.cB(ScanUIRectView.this.getContext());
                AppMethodBeat.o(161019);
              }
            }, null);
          }
          AppMethodBeat.o(161020);
          return true;
        }
        if (ScanUIRectView.u(ScanUIRectView.this))
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ScanUIRectView", "ignore, has get lbs!");
          AppMethodBeat.o(161020);
          return false;
        }
        ScanUIRectView.this.cwE();
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
    this.ytV = new com.tencent.mm.sdk.b.c() {};
    this.iKD = new GestureDetector(new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(186226);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/ScanUIRectView$14", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/scanner/ui/ScanUIRectView$14", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(186226);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(170014);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/ScanUIRectView$14", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ScanUIRectView", "double click,pointer:%d,x:%f,y:%f", new Object[] { Integer.valueOf(paramAnonymousMotionEvent.getActionIndex()), Float.valueOf(paramAnonymousMotionEvent.getX(paramAnonymousMotionEvent.getActionIndex())), Float.valueOf(paramAnonymousMotionEvent.getY(paramAnonymousMotionEvent.getActionIndex())) });
        ((com.tencent.scanlib.a.a)ScanUIRectView.A(ScanUIRectView.this)).agJ(5);
        ac.hn(ScanUIRectView.B(ScanUIRectView.this), 3);
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/scanner/ui/ScanUIRectView$14", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(170014);
        return true;
      }
      
      public final boolean onFling(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(170015);
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ScanUIRectView", "alvinluo onFling velocityX: %f, velocityY: %f, canScrollSwitchTab: %b, enableScrollSwitchTab: %b, isMultiTouch: %b", new Object[] { Float.valueOf(paramAnonymousFloat1), Float.valueOf(paramAnonymousFloat2), Boolean.valueOf(ScanUIRectView.C(ScanUIRectView.this)), Boolean.valueOf(ScanUIRectView.D(ScanUIRectView.this)), Boolean.valueOf(ScanUIRectView.E(ScanUIRectView.this)) });
        if ((!ScanUIRectView.E(ScanUIRectView.this)) && (ScanUIRectView.D(ScanUIRectView.this)) && (Math.abs(paramAnonymousFloat1) > Math.abs(paramAnonymousFloat2)))
        {
          if ((paramAnonymousFloat1 >= -1200.0F) || (!ScanUIRectView.C(ScanUIRectView.this))) {
            break label168;
          }
          if (ScanUIRectView.F(ScanUIRectView.this) != null) {
            ScanUIRectView.F(ScanUIRectView.this).dMA();
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
              ScanUIRectView.F(ScanUIRectView.this).dMB();
            }
            ScanUIRectView.b(ScanUIRectView.this, false);
          }
        }
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(186225);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/ScanUIRectView$14", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.ahq());
        super.onLongPress(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/ScanUIRectView$14", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(186225);
      }
      
      public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(186224);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/ScanUIRectView$14", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
        boolean bool = super.onSingleTapUp(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/scanner/ui/ScanUIRectView$14", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(186224);
        return bool;
      }
    });
    this.ytX = new b(Looper.getMainLooper());
    AppMethodBeat.o(51945);
  }
  
  public ScanUIRectView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(51946);
    this.mode = 1;
    this.ypH = true;
    this.ypI = false;
    this.ytA = true;
    this.ytB = false;
    this.ytC = 0;
    this.ytD = 120;
    this.tQI = false;
    this.rif = null;
    this.ytF = true;
    this.ytG = false;
    this.ytI = false;
    this.ytJ = false;
    this.isFirst = true;
    this.ytK = new com.tencent.mm.plugin.scanner.util.g();
    this.ytL = 0;
    this.ytM = 0L;
    this.mTimeout = this.ytK.mTimeout;
    this.ytN = false;
    this.ytO = true;
    this.ytP = false;
    this.isRetry = false;
    this.ytQ = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(51916);
        if ((ScanUIRectView.a(ScanUIRectView.this)) && (!ScanUIRectView.b(ScanUIRectView.this)))
        {
          ScanUIRectView.c(ScanUIRectView.this);
          ScanUIRectView.d(ScanUIRectView.this);
          ac.dLk();
          ScanUIRectView.e(ScanUIRectView.this);
        }
        AppMethodBeat.o(51916);
      }
    };
    this.ytR = 0;
    this.ytS = 0;
    this.ytT = new h.c()
    {
      public final void a(final long paramAnonymousLong, List<com.tencent.qbar.a.a> paramAnonymousList, final List<QbarNative.QBarPoint> paramAnonymousList1, final List<WxQbarNative.QBarReportMsg> paramAnonymousList2, final Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(186223);
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ScanUIRectView", String.format("scan code after decode %d", new Object[] { Long.valueOf(paramAnonymousLong) }));
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
                ScanUIRectView.this.dLX();
                localArrayList = new ArrayList();
                if ((paramAnonymousList2 != null) && (!paramAnonymousList2.isEmpty()))
                {
                  com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ScanUIRectView", "alvinluo onDecodeSuccess result size: %d", new Object[] { Integer.valueOf(paramAnonymousList2.size()) });
                  j = 0;
                  i = 0;
                  if (j < paramAnonymousList2.size())
                  {
                    localObject1 = (com.tencent.qbar.a.a)paramAnonymousList2.get(j);
                    localObject1 = new WxQBarResult(((com.tencent.qbar.a.a)localObject1).typeID, ((com.tencent.qbar.a.a)localObject1).typeName, ((com.tencent.qbar.a.a)localObject1).data, ((com.tencent.qbar.a.a)localObject1).rawData, ((com.tencent.qbar.a.a)localObject1).charset, ((com.tencent.qbar.a.a)localObject1).priorityLevel);
                    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ScanUIRectView", "alvinluo onDecodeSuccess result index: %d, format: %d, content:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(((WxQBarResult)localObject1).typeID), ((WxQBarResult)localObject1).data });
                    if ((paramAnonymousList1 != null) && (paramAnonymousList1.size() >= j + 1))
                    {
                      localObject2 = (WxQbarNative.QBarReportMsg)paramAnonymousList1.get(j);
                      if (localObject2 != null) {
                        ((WxQBarResult)localObject1).LKn = ((WxQbarNative.QBarReportMsg)localObject2).qrcodeVersion;
                      }
                    }
                    if ((paramAnonymousBundle == null) || (paramAnonymousBundle.size() < j + 1)) {
                      break label426;
                    }
                    Object localObject2 = (QbarNative.QBarPoint)paramAnonymousBundle.get(j);
                    if (localObject2 == null) {
                      break label426;
                    }
                    ((WxQBarResult)localObject1).LKP = new WxQBarPoint((QbarNative.QBarPoint)localObject2);
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
                if (this.yua != null) {
                  ((Bundle)localObject1).putAll(this.yua);
                }
                ScanUIRectView.this.cwE();
                if (ScanUIRectView.m(ScanUIRectView.this) != null) {
                  ScanUIRectView.m(ScanUIRectView.this).e(ScanUIRectView.l(ScanUIRectView.this), (Bundle)localObject1);
                }
                AppMethodBeat.o(161010);
                return;
              }
            }
          });
        }
        AppMethodBeat.o(186223);
      }
      
      public final void ag(final long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(170011);
        ScanUIRectView.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(161009);
            if ((paramAnonymousLong1 == ScanUIRectView.l(ScanUIRectView.this)) && (paramAnonymousLong1 != 0L)) {
              ScanUIRectView.this.zb(this.uIT);
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
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ScanUIRectView", "zoom to scale %f", new Object[] { Float.valueOf(f) });
              if ((f > 0.0F) && (ScanUIRectView.n(ScanUIRectView.this)) && (ScanUIRectView.o(ScanUIRectView.this).cLT()))
              {
                int i = (int)(((com.tencent.scanlib.a.a)ScanUIRectView.p(ScanUIRectView.this)).fUn() * f);
                ((com.tencent.scanlib.a.a)ScanUIRectView.q(ScanUIRectView.this)).agI(i);
                com.tencent.qbar.c localc = com.tencent.qbar.c.LKe;
                localc.LKs += 1;
                localc.LKt *= f;
                localc.LKu = (System.currentTimeMillis() - localc.yom);
                com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.QBarEngineReporter", "alvinluo zoom %d, zoomFactor: %s, totalZoomFactor: %s, lastZoomCostTime: %d", new Object[] { Integer.valueOf(localc.LKs), Float.valueOf(f), Float.valueOf(localc.LKt), Long.valueOf(localc.LKu) });
              }
            }
            AppMethodBeat.o(170010);
          }
        });
        AppMethodBeat.o(170013);
      }
    };
    this.ytU = new ScanUIRectView.3(this);
    this.fFl = new com.tencent.mm.modelgeo.b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(161020);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ScanUIRectView", "onGetLocation %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (!paramAnonymousBoolean)
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ScanUIRectView", "check permission not passed!");
          if ((!ScanUIRectView.s(ScanUIRectView.this)) && (!d.aHR()))
          {
            ScanUIRectView.t(ScanUIRectView.this);
            com.tencent.mm.ui.base.h.a(ScanUIRectView.this.getContext(), ScanUIRectView.this.getContext().getString(2131760082), ScanUIRectView.this.getContext().getString(2131755906), ScanUIRectView.this.getContext().getString(2131760598), ScanUIRectView.this.getContext().getString(2131755691), false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(161019);
                d.cB(ScanUIRectView.this.getContext());
                AppMethodBeat.o(161019);
              }
            }, null);
          }
          AppMethodBeat.o(161020);
          return true;
        }
        if (ScanUIRectView.u(ScanUIRectView.this))
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ScanUIRectView", "ignore, has get lbs!");
          AppMethodBeat.o(161020);
          return false;
        }
        ScanUIRectView.this.cwE();
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
    this.ytV = new com.tencent.mm.sdk.b.c() {};
    this.iKD = new GestureDetector(new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(186226);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/ScanUIRectView$14", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/scanner/ui/ScanUIRectView$14", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(186226);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(170014);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/ScanUIRectView$14", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ScanUIRectView", "double click,pointer:%d,x:%f,y:%f", new Object[] { Integer.valueOf(paramAnonymousMotionEvent.getActionIndex()), Float.valueOf(paramAnonymousMotionEvent.getX(paramAnonymousMotionEvent.getActionIndex())), Float.valueOf(paramAnonymousMotionEvent.getY(paramAnonymousMotionEvent.getActionIndex())) });
        ((com.tencent.scanlib.a.a)ScanUIRectView.A(ScanUIRectView.this)).agJ(5);
        ac.hn(ScanUIRectView.B(ScanUIRectView.this), 3);
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/scanner/ui/ScanUIRectView$14", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(170014);
        return true;
      }
      
      public final boolean onFling(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(170015);
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ScanUIRectView", "alvinluo onFling velocityX: %f, velocityY: %f, canScrollSwitchTab: %b, enableScrollSwitchTab: %b, isMultiTouch: %b", new Object[] { Float.valueOf(paramAnonymousFloat1), Float.valueOf(paramAnonymousFloat2), Boolean.valueOf(ScanUIRectView.C(ScanUIRectView.this)), Boolean.valueOf(ScanUIRectView.D(ScanUIRectView.this)), Boolean.valueOf(ScanUIRectView.E(ScanUIRectView.this)) });
        if ((!ScanUIRectView.E(ScanUIRectView.this)) && (ScanUIRectView.D(ScanUIRectView.this)) && (Math.abs(paramAnonymousFloat1) > Math.abs(paramAnonymousFloat2)))
        {
          if ((paramAnonymousFloat1 >= -1200.0F) || (!ScanUIRectView.C(ScanUIRectView.this))) {
            break label168;
          }
          if (ScanUIRectView.F(ScanUIRectView.this) != null) {
            ScanUIRectView.F(ScanUIRectView.this).dMA();
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
              ScanUIRectView.F(ScanUIRectView.this).dMB();
            }
            ScanUIRectView.b(ScanUIRectView.this, false);
          }
        }
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(186225);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/ScanUIRectView$14", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.ahq());
        super.onLongPress(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/ScanUIRectView$14", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(186225);
      }
      
      public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(186224);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/ScanUIRectView$14", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
        boolean bool = super.onSingleTapUp(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/scanner/ui/ScanUIRectView$14", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(186224);
        return bool;
      }
    });
    this.ytX = new b(Looper.getMainLooper());
    AppMethodBeat.o(51946);
  }
  
  public ScanUIRectView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(51947);
    this.mode = 1;
    this.ypH = true;
    this.ypI = false;
    this.ytA = true;
    this.ytB = false;
    this.ytC = 0;
    this.ytD = 120;
    this.tQI = false;
    this.rif = null;
    this.ytF = true;
    this.ytG = false;
    this.ytI = false;
    this.ytJ = false;
    this.isFirst = true;
    this.ytK = new com.tencent.mm.plugin.scanner.util.g();
    this.ytL = 0;
    this.ytM = 0L;
    this.mTimeout = this.ytK.mTimeout;
    this.ytN = false;
    this.ytO = true;
    this.ytP = false;
    this.isRetry = false;
    this.ytQ = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(51916);
        if ((ScanUIRectView.a(ScanUIRectView.this)) && (!ScanUIRectView.b(ScanUIRectView.this)))
        {
          ScanUIRectView.c(ScanUIRectView.this);
          ScanUIRectView.d(ScanUIRectView.this);
          ac.dLk();
          ScanUIRectView.e(ScanUIRectView.this);
        }
        AppMethodBeat.o(51916);
      }
    };
    this.ytR = 0;
    this.ytS = 0;
    this.ytT = new h.c()
    {
      public final void a(final long paramAnonymousLong, List<com.tencent.qbar.a.a> paramAnonymousList, final List<QbarNative.QBarPoint> paramAnonymousList1, final List<WxQbarNative.QBarReportMsg> paramAnonymousList2, final Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(186223);
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ScanUIRectView", String.format("scan code after decode %d", new Object[] { Long.valueOf(paramAnonymousLong) }));
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
                ScanUIRectView.this.dLX();
                localArrayList = new ArrayList();
                if ((paramAnonymousList2 != null) && (!paramAnonymousList2.isEmpty()))
                {
                  com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ScanUIRectView", "alvinluo onDecodeSuccess result size: %d", new Object[] { Integer.valueOf(paramAnonymousList2.size()) });
                  j = 0;
                  i = 0;
                  if (j < paramAnonymousList2.size())
                  {
                    localObject1 = (com.tencent.qbar.a.a)paramAnonymousList2.get(j);
                    localObject1 = new WxQBarResult(((com.tencent.qbar.a.a)localObject1).typeID, ((com.tencent.qbar.a.a)localObject1).typeName, ((com.tencent.qbar.a.a)localObject1).data, ((com.tencent.qbar.a.a)localObject1).rawData, ((com.tencent.qbar.a.a)localObject1).charset, ((com.tencent.qbar.a.a)localObject1).priorityLevel);
                    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ScanUIRectView", "alvinluo onDecodeSuccess result index: %d, format: %d, content:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(((WxQBarResult)localObject1).typeID), ((WxQBarResult)localObject1).data });
                    if ((paramAnonymousList1 != null) && (paramAnonymousList1.size() >= j + 1))
                    {
                      localObject2 = (WxQbarNative.QBarReportMsg)paramAnonymousList1.get(j);
                      if (localObject2 != null) {
                        ((WxQBarResult)localObject1).LKn = ((WxQbarNative.QBarReportMsg)localObject2).qrcodeVersion;
                      }
                    }
                    if ((paramAnonymousBundle == null) || (paramAnonymousBundle.size() < j + 1)) {
                      break label426;
                    }
                    Object localObject2 = (QbarNative.QBarPoint)paramAnonymousBundle.get(j);
                    if (localObject2 == null) {
                      break label426;
                    }
                    ((WxQBarResult)localObject1).LKP = new WxQBarPoint((QbarNative.QBarPoint)localObject2);
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
                if (this.yua != null) {
                  ((Bundle)localObject1).putAll(this.yua);
                }
                ScanUIRectView.this.cwE();
                if (ScanUIRectView.m(ScanUIRectView.this) != null) {
                  ScanUIRectView.m(ScanUIRectView.this).e(ScanUIRectView.l(ScanUIRectView.this), (Bundle)localObject1);
                }
                AppMethodBeat.o(161010);
                return;
              }
            }
          });
        }
        AppMethodBeat.o(186223);
      }
      
      public final void ag(final long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(170011);
        ScanUIRectView.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(161009);
            if ((paramAnonymousLong1 == ScanUIRectView.l(ScanUIRectView.this)) && (paramAnonymousLong1 != 0L)) {
              ScanUIRectView.this.zb(this.uIT);
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
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ScanUIRectView", "zoom to scale %f", new Object[] { Float.valueOf(f) });
              if ((f > 0.0F) && (ScanUIRectView.n(ScanUIRectView.this)) && (ScanUIRectView.o(ScanUIRectView.this).cLT()))
              {
                int i = (int)(((com.tencent.scanlib.a.a)ScanUIRectView.p(ScanUIRectView.this)).fUn() * f);
                ((com.tencent.scanlib.a.a)ScanUIRectView.q(ScanUIRectView.this)).agI(i);
                com.tencent.qbar.c localc = com.tencent.qbar.c.LKe;
                localc.LKs += 1;
                localc.LKt *= f;
                localc.LKu = (System.currentTimeMillis() - localc.yom);
                com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.QBarEngineReporter", "alvinluo zoom %d, zoomFactor: %s, totalZoomFactor: %s, lastZoomCostTime: %d", new Object[] { Integer.valueOf(localc.LKs), Float.valueOf(f), Float.valueOf(localc.LKt), Long.valueOf(localc.LKu) });
              }
            }
            AppMethodBeat.o(170010);
          }
        });
        AppMethodBeat.o(170013);
      }
    };
    this.ytU = new ScanUIRectView.3(this);
    this.fFl = new com.tencent.mm.modelgeo.b.a()
    {
      public final boolean a(boolean paramAnonymousBoolean, float paramAnonymousFloat1, float paramAnonymousFloat2, int paramAnonymousInt, double paramAnonymousDouble1, double paramAnonymousDouble2)
      {
        AppMethodBeat.i(161020);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ScanUIRectView", "onGetLocation %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (!paramAnonymousBoolean)
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ScanUIRectView", "check permission not passed!");
          if ((!ScanUIRectView.s(ScanUIRectView.this)) && (!d.aHR()))
          {
            ScanUIRectView.t(ScanUIRectView.this);
            com.tencent.mm.ui.base.h.a(ScanUIRectView.this.getContext(), ScanUIRectView.this.getContext().getString(2131760082), ScanUIRectView.this.getContext().getString(2131755906), ScanUIRectView.this.getContext().getString(2131760598), ScanUIRectView.this.getContext().getString(2131755691), false, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(161019);
                d.cB(ScanUIRectView.this.getContext());
                AppMethodBeat.o(161019);
              }
            }, null);
          }
          AppMethodBeat.o(161020);
          return true;
        }
        if (ScanUIRectView.u(ScanUIRectView.this))
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ScanUIRectView", "ignore, has get lbs!");
          AppMethodBeat.o(161020);
          return false;
        }
        ScanUIRectView.this.cwE();
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
    this.ytV = new com.tencent.mm.sdk.b.c() {};
    this.iKD = new GestureDetector(new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(186226);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/ScanUIRectView$14", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/scanner/ui/ScanUIRectView$14", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(186226);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(170014);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/ScanUIRectView$14", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ScanUIRectView", "double click,pointer:%d,x:%f,y:%f", new Object[] { Integer.valueOf(paramAnonymousMotionEvent.getActionIndex()), Float.valueOf(paramAnonymousMotionEvent.getX(paramAnonymousMotionEvent.getActionIndex())), Float.valueOf(paramAnonymousMotionEvent.getY(paramAnonymousMotionEvent.getActionIndex())) });
        ((com.tencent.scanlib.a.a)ScanUIRectView.A(ScanUIRectView.this)).agJ(5);
        ac.hn(ScanUIRectView.B(ScanUIRectView.this), 3);
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/scanner/ui/ScanUIRectView$14", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(170014);
        return true;
      }
      
      public final boolean onFling(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(170015);
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ScanUIRectView", "alvinluo onFling velocityX: %f, velocityY: %f, canScrollSwitchTab: %b, enableScrollSwitchTab: %b, isMultiTouch: %b", new Object[] { Float.valueOf(paramAnonymousFloat1), Float.valueOf(paramAnonymousFloat2), Boolean.valueOf(ScanUIRectView.C(ScanUIRectView.this)), Boolean.valueOf(ScanUIRectView.D(ScanUIRectView.this)), Boolean.valueOf(ScanUIRectView.E(ScanUIRectView.this)) });
        if ((!ScanUIRectView.E(ScanUIRectView.this)) && (ScanUIRectView.D(ScanUIRectView.this)) && (Math.abs(paramAnonymousFloat1) > Math.abs(paramAnonymousFloat2)))
        {
          if ((paramAnonymousFloat1 >= -1200.0F) || (!ScanUIRectView.C(ScanUIRectView.this))) {
            break label168;
          }
          if (ScanUIRectView.F(ScanUIRectView.this) != null) {
            ScanUIRectView.F(ScanUIRectView.this).dMA();
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
              ScanUIRectView.F(ScanUIRectView.this).dMB();
            }
            ScanUIRectView.b(ScanUIRectView.this, false);
          }
        }
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(186225);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/ScanUIRectView$14", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.ahq());
        super.onLongPress(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/ui/ScanUIRectView$14", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(186225);
      }
      
      public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(186224);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/ScanUIRectView$14", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
        boolean bool = super.onSingleTapUp(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/scanner/ui/ScanUIRectView$14", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(186224);
        return bool;
      }
    });
    this.ytX = new b(Looper.getMainLooper());
    AppMethodBeat.o(51947);
  }
  
  private void bD(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(161043);
    if ((this.LPD.cLT()) && (((com.tencent.mm.plugin.scanner.a.a)this.LPD).dKJ())) {
      ScanCameraLightDetector.yzx.C(paramArrayOfByte, ((com.tencent.mm.plugin.scanner.a.a)this.LPD).fUk().x, ((com.tencent.mm.plugin.scanner.a.a)this.LPD).fUk().y);
    }
    switch (this.mode)
    {
    default: 
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ScanUIRectView", "unknown scan mode %d", new Object[] { Integer.valueOf(this.mode) });
      AppMethodBeat.o(161043);
      return;
    case 1: 
    case 4: 
    case 8: 
      bE(paramArrayOfByte);
      AppMethodBeat.o(161043);
      return;
    }
    bF(paramArrayOfByte);
    AppMethodBeat.o(161043);
  }
  
  private void bE(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(161044);
    Object localObject;
    Rect localRect1;
    if ((this.ylu != 0L) && (this.LPD.cLT()))
    {
      localObject = this.LPD.fUk();
      if (localObject != null)
      {
        localRect1 = getScanCodeRect();
        if ((this.isRetry) && (this.ytL != 1)) {
          break label198;
        }
        Rect localRect2 = ((com.tencent.mm.plugin.scanner.a.a)this.LPD).r(localRect1);
        if (this.ynO != null)
        {
          this.ynO.setPreviewRect(localRect2);
          this.ynO.setScanRect(localRect1);
          if ((this.ynO instanceof ScanCodeMaskView)) {
            ((ScanCodeMaskView)this.ynO).setNeedRotate(true);
          }
        }
        com.tencent.qbar.h.fTD().a(paramArrayOfByte, (Point)localObject, this.LPD.getCameraRotation(), localRect2);
      }
    }
    for (;;)
    {
      if ((!((com.tencent.scanlib.a.a)this.LPD).dLW()) && (com.tencent.qbar.h.fTD().ylx > ytH))
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ScanUIRectView", "change to FOCUS_MODE_AUTO");
        this.LPD.setFocusMode("auto");
        ET(100L);
      }
      AppMethodBeat.o(161044);
      return;
      label198:
      if ((this.isRetry) && (this.ytL == 2))
      {
        localObject = new Rect(0, 0, this.ytR, this.ytS);
        if (this.ynO != null)
        {
          this.ynO.setPreviewRect((Rect)localObject);
          this.ynO.setScanRect(localRect1);
          if ((this.ynO instanceof ScanCodeMaskView)) {
            ((ScanCodeMaskView)this.ynO).setNeedRotate(false);
          }
        }
        com.tencent.qbar.h.fTD().a(paramArrayOfByte, new Point(this.ytR, this.ytS), 0, (Rect)localObject);
      }
    }
  }
  
  private void bF(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(161045);
    if (this.ylu != 0L) {
      synchronized (this.LPD)
      {
        if (this.LPD.cLT())
        {
          Point localPoint = this.LPD.fUk();
          boolean bool = true;
          if ((this.ypQ instanceof ScanGoodsRequest)) {
            bool = ((ScanGoodsRequest)this.ypQ).yjP;
          }
          com.tencent.mm.plugin.scanner.c.a.dKN().a(paramArrayOfByte, localPoint, this.LPD.getCameraRotation(), ((com.tencent.mm.plugin.scanner.a.a)this.LPD).getPreviewFormat(), bool);
        }
        AppMethodBeat.o(161045);
        return;
      }
    }
    AppMethodBeat.o(161045);
  }
  
  private byte[] dLY()
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
        if (this.ytK == null) {
          break label300;
        }
        i = m;
        j = k;
        if (this.ytK.yzO == 0.0F) {
          break label300;
        }
        j = (int)(this.bef.getWidth() * this.ytK.yzO);
        i = (int)(this.bef.getHeight() * this.ytK.yzO);
      }
      catch (Exception localException)
      {
        long l1;
        Object localObject;
        long l2;
        com.tencent.mm.sdk.platformtools.ad.printErrStackTrace("MicroMsg.ScanUIRectView", localException, "alvinluo generateFrameByTextureView exception", new Object[0]);
        AppMethodBeat.o(161042);
        return null;
      }
      localObject = this.bef.getBitmap(k, j);
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ScanUIRectView", "alvinluo generateFrameByTextureView getBitmap cost: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
      {
        this.ytR = ((Bitmap)localObject).getWidth();
        this.ytS = ((Bitmap)localObject).getHeight();
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ScanUIRectView", "alvinluo generateFrameByTextureView bitmap width: %d, height: %d", new Object[] { Integer.valueOf(this.ytR), Integer.valueOf(this.ytS) });
        l1 = System.currentTimeMillis();
        localObject = l.a(this.ytR, this.ytS, (Bitmap)localObject);
        l2 = System.currentTimeMillis();
        if (localObject != null)
        {
          i = localObject.length;
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ScanUIRectView", "alvinluo generateFrameByTextureView yuvData: %d, getNV21 cost: %d", new Object[] { Integer.valueOf(i), Long.valueOf(l2 - l1) });
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
  
  private void dLZ()
  {
    int i = 0;
    AppMethodBeat.i(51960);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ScanUIRectView", "alvinluo createScanMaskView mode: %d, bottomHeight: %d", new Object[] { Integer.valueOf(this.mode), Integer.valueOf(this.ytC) });
    Object localObject2;
    label270:
    boolean bool;
    switch (this.mode)
    {
    default: 
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ScanUIRectView", "unknown scan mode %d", new Object[] { Integer.valueOf(this.mode) });
      if ((this.ynO == null) || (this.ynP == null)) {
        break label695;
      }
      this.ynO.setBottomExtraHeight(this.ytC);
      localObject1 = this.ynO;
      localObject2 = this.activity;
      p.h(localObject2, "activity");
      ((BaseScanMaskView)localObject1).activity = ((Activity)localObject2);
      this.ynO.eH(this.ypq);
      if ((this.LPD instanceof com.tencent.mm.plugin.scanner.a.a)) {
        this.ynO.ysK = ((com.tencent.mm.plugin.scanner.a.a)this.LPD);
      }
      this.ynO.o(this.ynP.getScanTipsView());
      this.ynO.eJ(this.ynP.getGalleryButton());
      if (this.ypq != null) {
        setFlashStatus(this.ypq.cMS);
      }
      if (this.isFirst)
      {
        this.ynP.setShowTitle(false);
        this.isFirst = false;
        this.ynO.dMn();
        localObject1 = this.ynP;
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ScanSharedMaskView", "alvinluo onViewReady hashCode: %d", new Object[] { Integer.valueOf(((ScanSharedMaskView)localObject1).hashCode()) });
        if (((ScanSharedMaskView)localObject1).yyS) {
          break label546;
        }
        if (((ScanSharedMaskView)localObject1).yyR) {
          break label541;
        }
        bool = true;
        label321:
        ((ScanSharedMaskView)localObject1).qF(bool);
        localObject2 = ((ScanSharedMaskView)localObject1).yyJ;
        if (localObject2 == null) {
          p.bcb("scanTitle");
        }
        ((TextView)localObject2).setVisibility(8);
        label350:
        ((ScanSharedMaskView)localObject1).qF(true);
        if (((ScanSharedMaskView)localObject1).ypQ == null) {
          break label675;
        }
        localObject2 = ((ScanSharedMaskView)localObject1).yyM;
        if (localObject2 == null) {
          p.bcb("galleryButton");
        }
        localObject1 = ((ScanSharedMaskView)localObject1).ypQ;
        if (localObject1 == null) {
          p.gfZ();
        }
        if (((BaseScanRequest)localObject1).yjH) {
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
      dMe();
      this.ynO = new ScanCodeMaskView(getContext());
      addView(this.ynO);
      break;
      this.ynO = new ScanTranslationMaskView(getContext());
      addView(this.ynO);
      break;
      this.ynO = new ScanGoodsMaskView(getContext());
      addView(this.ynO);
      if ((!(this.ynO instanceof ScanGoodsMaskView)) || (!(this.ypQ instanceof ScanGoodsRequest))) {
        break;
      }
      ((ScanGoodsMaskView)this.ynO).setScanRequest((ScanGoodsRequest)this.ypQ);
      break;
      this.ynP.setShowTitle(true);
      break label270;
      label541:
      bool = false;
      break label321;
      label546:
      ((ScanSharedMaskView)localObject1).qF(false);
      localObject2 = ((ScanSharedMaskView)localObject1).yyJ;
      if (localObject2 == null) {
        p.bcb("scanTitle");
      }
      if (((TextView)localObject2).getVisibility() != 0)
      {
        localObject2 = ((ScanSharedMaskView)localObject1).yyJ;
        if (localObject2 == null) {
          p.bcb("scanTitle");
        }
        ((TextView)localObject2).setVisibility(8);
        localObject2 = ((ScanSharedMaskView)localObject1).yyJ;
        if (localObject2 == null) {
          p.bcb("scanTitle");
        }
        ((TextView)localObject2).setAlpha(1.0F);
        ((ScanSharedMaskView)localObject1).dME();
        ((ScanSharedMaskView)localObject1).qG(true);
        break label350;
      }
      localObject2 = ((ScanSharedMaskView)localObject1).yyJ;
      if (localObject2 == null) {
        p.bcb("scanTitle");
      }
      ((TextView)localObject2).setAlpha(1.0F);
      ((ScanSharedMaskView)localObject1).dME();
      ((ScanSharedMaskView)localObject1).dMC();
      break label350;
      label669:
      i = 8;
    }
    label675:
    Object localObject1 = ((ScanSharedMaskView)localObject1).yyM;
    if (localObject1 == null) {
      p.bcb("galleryButton");
    }
    ((View)localObject1).setVisibility(0);
    label695:
    AppMethodBeat.o(51960);
  }
  
  private void dMa()
  {
    AppMethodBeat.i(51962);
    String str = getScanTips();
    this.ynP.setScanTips(str);
    this.ynP.setScanRequest(this.ypQ);
    switch (this.mode)
    {
    default: 
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.ScanUIRectView", "alvinluo refreshSharedMaskView unknown scan mode %d", new Object[] { Integer.valueOf(this.mode) });
      AppMethodBeat.o(51962);
      return;
    case 1: 
    case 4: 
    case 8: 
      this.ynP.setScanTitle(getResources().getString(2131762809));
      AppMethodBeat.o(51962);
      return;
    case 3: 
      this.ynP.setScanTitle(getResources().getString(2131762808));
      AppMethodBeat.o(51962);
      return;
    }
    this.ynP.setScanTitle(getResources().getString(2131762804));
    AppMethodBeat.o(51962);
  }
  
  private void dMd()
  {
    AppMethodBeat.i(51970);
    if (this.ynO != null)
    {
      final BaseScanMaskView localBaseScanMaskView = this.ynO;
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
  
  private void dMe()
  {
    AppMethodBeat.i(162394);
    if (com.tencent.qbar.f.fTA())
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ScanUIRectView", "alvinluo updateScanCodeRect visibleResolution: %s", new Object[] { this.rif });
      if ((this.rif != null) && (this.rif.x > 0) && (this.rif.y > 0))
      {
        this.ytx.setDecorRect(new Rect(0, (int)(this.rif.y * 1.0F / 19.0F), this.rif.x, (int)(this.rif.y * 17.0F / 19.0F)));
        AppMethodBeat.o(162394);
      }
    }
    else
    {
      this.ytx.ht(getResources().getDimensionPixelSize(2131166761), getResources().getDimensionPixelSize(2131166760));
    }
    AppMethodBeat.o(162394);
  }
  
  private void dMf()
  {
    AppMethodBeat.i(160188);
    if (this.ytQ != null) {
      removeCallbacks(this.ytQ);
    }
    AppMethodBeat.o(160188);
  }
  
  private Rect getScanCodeRect()
  {
    int j = 0;
    AppMethodBeat.i(51975);
    if (com.tencent.qbar.f.fTA())
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
    if (!this.ypH)
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
  
  private void qz(boolean paramBoolean)
  {
    AppMethodBeat.i(51974);
    if (this.ynO != null) {
      this.ynO.qz(paramBoolean);
    }
    if (this.ynP != null) {
      this.ynP.qz(paramBoolean);
    }
    if (this.yty != null) {
      this.yty.setVisibility(8);
    }
    AppMethodBeat.o(51974);
  }
  
  private void zc(long paramLong)
  {
    AppMethodBeat.i(161046);
    long l1 = System.currentTimeMillis() - this.ytW;
    if (l1 > LPE)
    {
      this.ytX.removeMessages(0);
      this.ytX.sendEmptyMessageDelayed(0, paramLong);
      AppMethodBeat.o(161046);
      return;
    }
    long l2 = LPE;
    this.ytX.removeMessages(0);
    this.ytX.sendEmptyMessageDelayed(0, l2 - l1 + paramLong);
    AppMethodBeat.o(161046);
  }
  
  public final void a(final b.b.a parama)
  {
    AppMethodBeat.i(161041);
    super.a(new b.b.a()
    {
      public final void dMh()
      {
        AppMethodBeat.i(161029);
        ScanUIRectView.h(ScanUIRectView.this);
        if (parama != null) {
          parama.dMh();
        }
        AppMethodBeat.o(161029);
      }
    });
    AppMethodBeat.o(161041);
  }
  
  public final void a(Object paramObject, com.tencent.mm.plugin.scanner.view.c paramc)
  {
    AppMethodBeat.i(51971);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ScanUIRectView", "alvinluo onScanSuccess");
    dMf();
    onPause();
    stopPreview();
    if (this.ynO != null)
    {
      this.ynO.a(paramObject, paramc);
      this.ynO.eI(this.bef);
    }
    if (this.ynP != null)
    {
      paramObject = this.ynP;
      com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.ScanSharedMaskView", "alvinluo onScanSuccess");
      paramc = paramObject.yyM;
      if (paramc == null) {
        p.bcb("galleryButton");
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
      paramObject.dME();
      paramc = paramObject.yyJ;
      if (paramc == null) {
        p.bcb("scanTitle");
      }
      paramc.setVisibility(8);
      paramObject.yyR = false;
      paramObject = paramObject.ypq;
      if (paramObject == null) {
        p.bcb("flashSwitcher");
      }
      paramObject.setVisibility(8);
    }
    if ((com.tencent.mm.plugin.scanner.util.o.OW(this.mode)) && (this.ytK != null)) {
      this.ytK.yzQ = true;
    }
    AppMethodBeat.o(51971);
  }
  
  public final void a(boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(51965);
    if (this.ynO != null) {
      this.ynO.a(paramBoolean, paramOnCancelListener);
    }
    AppMethodBeat.o(51965);
  }
  
  public final void cwE()
  {
    AppMethodBeat.i(51978);
    if ((this.ynO != null) && ((this.ynO instanceof ScanCodeMaskView))) {
      ((ScanCodeMaskView)this.ynO).cwE();
    }
    AppMethodBeat.o(51978);
  }
  
  public final void dLV()
  {
    AppMethodBeat.i(51948);
    this.LPD = new com.tencent.mm.plugin.scanner.a.a();
    AppMethodBeat.o(51948);
  }
  
  public final boolean dLW()
  {
    AppMethodBeat.i(51950);
    if (this.LPD != null)
    {
      boolean bool = ((com.tencent.scanlib.a.a)this.LPD).dLW();
      AppMethodBeat.o(51950);
      return bool;
    }
    AppMethodBeat.o(51950);
    return false;
  }
  
  public final void dLX()
  {
    AppMethodBeat.i(51952);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ScanUIRectView", "alvinluo stopCurrentSession %d", new Object[] { Long.valueOf(this.ylu) });
    com.tencent.qbar.h.fTD().yV(this.ylu);
    com.tencent.mm.plugin.scanner.c.a.dKN().yV(this.ylu);
    this.ylu = 0L;
    AppMethodBeat.o(51952);
  }
  
  public final void dMb()
  {
    AppMethodBeat.i(51967);
    if ((this.ynP != null) && (!this.ypq.cMS)) {
      this.ynP.qH(true);
    }
    AppMethodBeat.o(51967);
  }
  
  public final void dMc()
  {
    AppMethodBeat.i(51968);
    if ((this.ynP != null) && (this.ypq.cMS)) {
      this.ynP.qH(false);
    }
    AppMethodBeat.o(51968);
  }
  
  public Rect getDecorRect()
  {
    AppMethodBeat.i(51976);
    Rect localRect = this.ytx.getDecorRect();
    AppMethodBeat.o(51976);
    return localRect;
  }
  
  public com.tencent.scanlib.a.f getScanCamera()
  {
    return this.LPD;
  }
  
  public BaseScanMaskView getScanMaskView()
  {
    return this.ynO;
  }
  
  public ScanSharedMaskView getSharedMaskView()
  {
    return this.ynP;
  }
  
  public final void init()
  {
    AppMethodBeat.i(51959);
    super.init();
    this.ytx = new ScanRectDecorView(getContext());
    addView(this.ytx, new FrameLayout.LayoutParams(-1, -1));
    this.ynP = new ScanSharedMaskView(getContext());
    this.ypq = this.ynP.getFlashSwitcherView();
    addView(this.ynP, new FrameLayout.LayoutParams(-1, -1));
    dMa();
    AppMethodBeat.o(51959);
  }
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    AppMethodBeat.i(51972);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ScanUIRectView", "onAutoFocus %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.ytO = false;
      zb(0L);
    }
    ET(LPG);
    AppMethodBeat.o(51972);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(51949);
    super.onCreate();
    this.ytD = ((int)(com.tencent.mm.cc.a.ip(getContext()) / 4.5F));
    if (com.tencent.mm.plugin.scanner.util.o.OW(this.mode)) {
      com.tencent.qbar.h.fTD().init(getContext());
    }
    com.tencent.qbar.h.fTD().LKR = new aj();
    setOnTouchListener(new View.OnTouchListener()
    {
      private float yue;
      private float yuf = 400.0F;
      private boolean yug = false;
      
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(170016);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/ui/ScanUIRectView$15", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        int i = paramAnonymousMotionEvent.getActionMasked();
        int j = paramAnonymousMotionEvent.getActionIndex();
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ScanUIRectView", "pointIndex:%d, action: %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
        switch (i)
        {
        }
        for (;;)
        {
          paramAnonymousView = ScanUIRectView.L(ScanUIRectView.this);
          localObject = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/scanner/ui/ScanUIRectView$15", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
          com.tencent.mm.hellhoundlib.a.a.a(paramAnonymousView, paramAnonymousView.onTouchEvent((MotionEvent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0)), "com/tencent/mm/plugin/scanner/ui/ScanUIRectView$15", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
          if (paramAnonymousMotionEvent.getAction() == 1) {
            ScanUIRectView.c(ScanUIRectView.this, false);
          }
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/scanner/ui/ScanUIRectView$15", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(170016);
          return true;
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ScanUIRectView", "first down,pointer:%d,x:%f,y:%f", new Object[] { Integer.valueOf(j), Float.valueOf(paramAnonymousMotionEvent.getX()), Float.valueOf(paramAnonymousMotionEvent.getY()) });
          ScanUIRectView.a(ScanUIRectView.this, paramAnonymousMotionEvent.getRawX());
          ScanUIRectView.b(ScanUIRectView.this, true);
          this.yug = false;
          continue;
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ScanUIRectView", "down,pointer:%d,x:%f,y:%f", new Object[] { Integer.valueOf(j), Float.valueOf(paramAnonymousMotionEvent.getX(j)), Float.valueOf(paramAnonymousMotionEvent.getY(j)) });
          if (paramAnonymousMotionEvent.getPointerCount() == 2)
          {
            this.yue = ((float)(Math.pow(paramAnonymousMotionEvent.getX(0) - paramAnonymousMotionEvent.getX(1), 2.0D) + Math.pow(paramAnonymousMotionEvent.getY(0) - paramAnonymousMotionEvent.getY(1), 2.0D)));
            ScanUIRectView.c(ScanUIRectView.this, true);
          }
          this.yug = false;
          continue;
          com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ScanUIRectView", "last up,pointer:%d,x:%f,y:%f", new Object[] { Integer.valueOf(j), Float.valueOf(paramAnonymousMotionEvent.getX()), Float.valueOf(paramAnonymousMotionEvent.getY()) });
          if (paramAnonymousMotionEvent.getPointerCount() == 2)
          {
            this.yue = ((float)(Math.pow(paramAnonymousMotionEvent.getX(0) - paramAnonymousMotionEvent.getX(1), 2.0D) + Math.pow(paramAnonymousMotionEvent.getY(0) - paramAnonymousMotionEvent.getY(1), 2.0D)));
            continue;
            com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ScanUIRectView", "up,pointer:%d,x:%f,y:%f", new Object[] { Integer.valueOf(j), Float.valueOf(paramAnonymousMotionEvent.getX(j)), Float.valueOf(paramAnonymousMotionEvent.getY(j)) });
            if (paramAnonymousMotionEvent.getPointerCount() == 2)
            {
              this.yue = ((float)(Math.pow(paramAnonymousMotionEvent.getX(0) - paramAnonymousMotionEvent.getX(1), 2.0D) + Math.pow(paramAnonymousMotionEvent.getY(0) - paramAnonymousMotionEvent.getY(1), 2.0D)));
              if (this.yug)
              {
                this.yug = false;
                ac.hn(ScanUIRectView.B(ScanUIRectView.this), 4);
                continue;
                float f;
                if (paramAnonymousMotionEvent.getPointerCount() == 2)
                {
                  com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ScanUIRectView", "move,pointer:0,x:%f,y:%f", new Object[] { Float.valueOf(paramAnonymousMotionEvent.getX(0)), Float.valueOf(paramAnonymousMotionEvent.getY(0)) });
                  com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ScanUIRectView", "move,pointer:1,x:%f,y:%f", new Object[] { Float.valueOf(paramAnonymousMotionEvent.getX(1)), Float.valueOf(paramAnonymousMotionEvent.getY(1)) });
                  f = (float)(Math.pow(paramAnonymousMotionEvent.getX(0) - paramAnonymousMotionEvent.getX(1), 2.0D) + Math.pow(paramAnonymousMotionEvent.getY(0) - paramAnonymousMotionEvent.getY(1), 2.0D));
                  com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ScanUIRectView", "distance:%f,lastDistance:%f,min move:%f", new Object[] { Float.valueOf(f), Float.valueOf(this.yue), Float.valueOf(this.yuf) });
                  if (Math.abs(f - this.yue) > this.yuf)
                  {
                    if (ScanUIRectView.n(ScanUIRectView.this)) {
                      ScanUIRectView.G(ScanUIRectView.this);
                    }
                    if (f - this.yue > 0.0F) {
                      ((com.tencent.scanlib.a.a)ScanUIRectView.H(ScanUIRectView.this)).agJ(2);
                    }
                    for (this.yug = true;; this.yug = true)
                    {
                      this.yue = f;
                      break;
                      ((com.tencent.scanlib.a.a)ScanUIRectView.I(ScanUIRectView.this)).agJ(3);
                    }
                  }
                }
                else if ((paramAnonymousMotionEvent.getPointerCount() == 1) && (ScanUIRectView.D(ScanUIRectView.this)) && (!ScanUIRectView.E(ScanUIRectView.this)))
                {
                  f = paramAnonymousMotionEvent.getRawX() - ScanUIRectView.J(ScanUIRectView.this);
                  com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.ScanUIRectView", "alvinluo onTouchEvent offsetX: %f, canScrollSwitchTab: %b", new Object[] { Float.valueOf(f), Boolean.valueOf(ScanUIRectView.C(ScanUIRectView.this)) });
                  if ((f >= ScanUIRectView.K(ScanUIRectView.this)) && (ScanUIRectView.C(ScanUIRectView.this)))
                  {
                    if (ScanUIRectView.F(ScanUIRectView.this) != null) {
                      ScanUIRectView.F(ScanUIRectView.this).dMB();
                    }
                    ScanUIRectView.b(ScanUIRectView.this, false);
                  }
                  else if ((f <= -ScanUIRectView.K(ScanUIRectView.this)) && (ScanUIRectView.C(ScanUIRectView.this)))
                  {
                    if (ScanUIRectView.F(ScanUIRectView.this) != null) {
                      ScanUIRectView.F(ScanUIRectView.this).dMA();
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
    com.tencent.mm.sdk.b.a.IbL.c(this.ytV);
    if (this.ytK != null) {
      this.ytK.wQm = System.currentTimeMillis();
    }
    AppMethodBeat.o(51949);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(51955);
    super.onDestroy();
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ScanUIRectView", "alvinluo releaseView");
    if (this.ynO != null) {
      this.ynO.release();
    }
    if (this.ynP != null)
    {
      localObject = this.ynP;
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ScanSharedMaskView", "alvinluo release hashCode: %d", new Object[] { Integer.valueOf(((ScanSharedMaskView)localObject).hashCode()) });
      ((ScanSharedMaskView)localObject).dMD();
    }
    com.tencent.qbar.h.fTD().release();
    Object localObject = com.tencent.mm.plugin.scanner.c.a.dKN();
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.AiScanImageDecodeQueueNew", "alvinluo release");
    u.a(new a.3((com.tencent.mm.plugin.scanner.c.a)localObject));
    com.tencent.mm.sdk.b.a.IbL.d(this.ytV);
    removeCallbacks(this.ytQ);
    this.ytQ = null;
    if (this.ytK != null)
    {
      localObject = this.ytK;
      ((com.tencent.mm.plugin.scanner.util.g)localObject).yzP = System.currentTimeMillis();
      ((com.tencent.mm.plugin.scanner.util.g)localObject).dBD = (((com.tencent.mm.plugin.scanner.util.g)localObject).yzP - ((com.tencent.mm.plugin.scanner.util.g)localObject).wQm);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ScanRetryManager", "alvinluo exitScanUI stayTime: %d, isUpdated: %b, onPreviewFrameCalled: %b, isRetry: %b", new Object[] { Long.valueOf(((com.tencent.mm.plugin.scanner.util.g)localObject).dBD), Boolean.valueOf(((com.tencent.mm.plugin.scanner.util.g)localObject).yzK), Boolean.valueOf(((com.tencent.mm.plugin.scanner.util.g)localObject).ytP), Boolean.valueOf(((com.tencent.mm.plugin.scanner.util.g)localObject).isRetry) });
      ac.a(((com.tencent.mm.plugin.scanner.util.g)localObject).yzL, ((com.tencent.mm.plugin.scanner.util.g)localObject).isRetry, ((com.tencent.mm.plugin.scanner.util.g)localObject).ytP, ((com.tencent.mm.plugin.scanner.util.g)localObject).dBD);
      ac.g(((com.tencent.mm.plugin.scanner.util.g)localObject).yzL, ((com.tencent.mm.plugin.scanner.util.g)localObject).isRetry, ((com.tencent.mm.plugin.scanner.util.g)localObject).yzQ);
      if (!((com.tencent.mm.plugin.scanner.util.g)localObject).yzK) {
        break label288;
      }
      ((com.tencent.mm.plugin.scanner.util.g)localObject).zd(((com.tencent.mm.plugin.scanner.util.g)localObject).mTimeout);
    }
    for (;;)
    {
      if ((com.tencent.mm.plugin.scanner.util.o.OW(this.mode)) && (!this.ytG)) {
        ac.dLm();
      }
      AppMethodBeat.o(51955);
      return;
      label288:
      if (!((com.tencent.mm.plugin.scanner.util.g)localObject).yzK)
      {
        ((com.tencent.mm.plugin.scanner.util.g)localObject).mTimeout = ((com.tencent.mm.plugin.scanner.util.g)localObject).yzH;
        ((com.tencent.mm.plugin.scanner.util.g)localObject).zd(((com.tencent.mm.plugin.scanner.util.g)localObject).mTimeout);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ScanRetryManager", "alvinluo checkAndResetTimeout timeout not updated and reset to %d", new Object[] { Long.valueOf(((com.tencent.mm.plugin.scanner.util.g)localObject).mTimeout) });
      }
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(51953);
    super.onPause();
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ScanUIRectView", "alvinluo onPuase");
    dMf();
    if (this.ynO != null) {
      this.ynO.onPause();
    }
    dLX();
    if (this.hQo != null) {
      this.hQo.c(this.fFl);
    }
    AppMethodBeat.o(51953);
  }
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    AppMethodBeat.i(51973);
    super.onPreviewFrame(paramArrayOfByte, paramCamera);
    this.ytP = true;
    boolean bool;
    int i;
    if (paramArrayOfByte == null)
    {
      bool = true;
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ScanUIRectView", "onPreviewFrame null data: %b, isPreviewPaused: %b, canResumePreview: %b", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(this.ytI), Boolean.valueOf(this.ytJ) });
      if (this.ytL == 2) {
        if (this.ytK != null)
        {
          paramCamera = this.ytK;
          i = this.ytL;
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ScanRetryManager", "alvinluo cancelRetryType: %d", new Object[] { Integer.valueOf(i) });
          if (i != 1) {
            break label260;
          }
          paramCamera.yzM = false;
        }
      }
    }
    for (;;)
    {
      this.isRetry = false;
      removeCallbacks(this.ytQ);
      if (this.ytK != null)
      {
        paramCamera = this.ytK;
        long l1 = System.currentTimeMillis();
        long l2 = this.ytM;
        if (!paramCamera.yzK)
        {
          paramCamera.yzK = true;
          l1 = ((float)(l1 - l2) * paramCamera.yzJ);
          paramCamera.mTimeout = Math.max(paramCamera.yzI, Math.min(paramCamera.yzH, l1));
        }
        this.ytK.ytP = true;
      }
      if ((!this.ytI) || (!this.ytJ)) {
        break label273;
      }
      this.ytI = false;
      this.ytJ = false;
      qy(false);
      zb(100L);
      AppMethodBeat.o(51973);
      return;
      bool = false;
      break;
      label260:
      if (i == 2) {
        paramCamera.yzN = false;
      }
    }
    label273:
    if (paramArrayOfByte == null)
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.ScanUIRectView", "alvinluo onPreviewFrame data is null");
      zb(0L);
      ac.dLl();
      AppMethodBeat.o(51973);
      return;
    }
    bD(paramArrayOfByte);
    AppMethodBeat.o(51973);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(51951);
    super.onResume();
    if (!this.LPD.isOpen())
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ScanUIRectView", "alvinluo onResume openCamera");
      a(null);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ScanUIRectView", "onResume %s", new Object[] { bt.flS() });
      this.ylu = System.currentTimeMillis();
      if (!com.tencent.mm.plugin.scanner.util.o.OW(this.mode)) {
        break label244;
      }
      com.tencent.qbar.h.fTD().a(this.ylu, this.ytT);
    }
    for (;;)
    {
      this.ytE = false;
      if (this.ynO != null) {
        this.ynO.onResume();
      }
      aq.o(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(51923);
          if ((ScanUIRectView.f(ScanUIRectView.this) != null) && (ScanUIRectView.f(ScanUIRectView.this).yjG))
          {
            AppMethodBeat.o(51923);
            return;
          }
          ScanCameraLightDetector.yzx.start(((com.tencent.mm.plugin.scanner.a.a)ScanUIRectView.g(ScanUIRectView.this)).getFocusMode());
          AppMethodBeat.o(51923);
        }
      }, 300L);
      this.ytJ = true;
      AppMethodBeat.o(51951);
      return;
      if (!this.LPD.cLT())
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ScanUIRectView", "alvinluo onResume startPreview");
        ((com.tencent.mm.plugin.scanner.a.a)this.LPD).dKH();
        a(new ScanUIRectView.8(this));
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ScanUIRectView", "focus mode %s", new Object[] { this.LPD.getFocusMode() });
        break;
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ScanUIRectView", "alvinluo onResume camera is previewing");
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ScanUIRectView", "focus mode %s", new Object[] { this.LPD.getFocusMode() });
      zb(0L);
      break;
      label244:
      if (this.mode == 12)
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ScanUIRectView", "alvinluo onResume currentNetworkAvailable: %b", new Object[] { Boolean.valueOf(this.ypI) });
        if (this.ypI)
        {
          com.tencent.mm.plugin.scanner.c.a locala = com.tencent.mm.plugin.scanner.c.a.dKN();
          long l = this.ylu;
          com.tencent.mm.plugin.scanner.c.a.a locala1 = this.ytU;
          synchronized (locala.ylo)
          {
            locala.ylu = l;
            locala.ylJ = locala1;
            synchronized (locala.ylI)
            {
              if (locala.gcX) {
                u.reset();
              }
            }
          }
        }
        com.tencent.mm.plugin.scanner.c.a.dKN().yV(this.ylu);
      }
    }
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(51954);
    super.onStop();
    awW();
    ScanCameraLightDetector.yzx.stop();
    AppMethodBeat.o(51954);
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(162395);
    super.onSurfaceTextureAvailable(paramSurfaceTexture, paramInt1, paramInt2);
    if ((this.rif == null) || (paramInt1 != this.rif.x) || (paramInt2 != this.rif.y))
    {
      if (this.rif == null) {
        this.rif = new Point(paramInt1, paramInt2);
      }
      if (com.tencent.mm.plugin.scanner.util.o.OW(this.mode)) {
        dMe();
      }
    }
    AppMethodBeat.o(162395);
  }
  
  public final void qx(boolean paramBoolean)
  {
    boolean bool2 = true;
    AppMethodBeat.i(51969);
    com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.ScanUIRectView", "alvinluo onShowNoDataView show: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    Object localObject;
    boolean bool1;
    if (this.ynP != null)
    {
      localObject = this.ynP;
      if (!paramBoolean)
      {
        bool1 = true;
        ((ScanSharedMaskView)localObject).qI(bool1);
      }
    }
    else if (this.ynO != null)
    {
      localObject = this.ynO;
      if (paramBoolean) {
        break label90;
      }
    }
    label90:
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      ((BaseScanMaskView)localObject).qI(paramBoolean);
      AppMethodBeat.o(51969);
      return;
      bool1 = false;
      break;
    }
  }
  
  public final void qy(final boolean paramBoolean)
  {
    AppMethodBeat.i(170027);
    ac.Ov(this.mode);
    if (this.mode == 12) {
      ac.aw(1, System.currentTimeMillis());
    }
    if (Looper.getMainLooper().getThread() == Thread.currentThread())
    {
      qz(paramBoolean);
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
    this.ytx.setVisibility(8);
    dMa();
    dMd();
    dLZ();
    AppMethodBeat.o(51961);
  }
  
  public void setActivity(Activity paramActivity)
  {
    this.activity = paramActivity;
  }
  
  public void setBlackInterval(int paramInt)
  {
    AppMethodBeat.i(170024);
    com.tencent.qbar.h localh = com.tencent.qbar.h.fTD();
    synchronized (localh.kIn)
    {
      if (localh.kIn.hasInited()) {
        localh.kIn.setBlackInterval(paramInt);
      }
      AppMethodBeat.o(170024);
      return;
    }
  }
  
  public void setBottomExtraHeight(int paramInt)
  {
    this.ytC = paramInt;
  }
  
  public void setDecodeSuccessFrameData(ScanDecodeFrameData paramScanDecodeFrameData)
  {
    AppMethodBeat.i(170026);
    if (this.ynO != null) {
      this.ynO.setDecodeSuccessFrameData(paramScanDecodeFrameData);
    }
    AppMethodBeat.o(170026);
  }
  
  public void setDecorRect(Rect paramRect)
  {
    AppMethodBeat.i(51977);
    this.ytx.setDecorRect(paramRect);
    AppMethodBeat.o(51977);
  }
  
  public void setEnableScrollSwitchTab(boolean paramBoolean)
  {
    AppMethodBeat.i(51958);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ScanUIRectView", "alvinluo setEnableScrollSwitchTab: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.ytA = paramBoolean;
    AppMethodBeat.o(51958);
  }
  
  public void setFlashStatus(boolean paramBoolean)
  {
    AppMethodBeat.i(51966);
    if (this.ynP != null) {
      this.ynP.setFlashStatus(paramBoolean);
    }
    AppMethodBeat.o(51966);
  }
  
  public void setMyQrCodeVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(186227);
    if ((this.ynO instanceof ScanCodeMaskView)) {
      ((ScanCodeMaskView)this.ynO).setMyQrCodeButtonVisible(paramBoolean);
    }
    AppMethodBeat.o(186227);
  }
  
  public void setNetworkAvailable(boolean paramBoolean)
  {
    this.ypI = paramBoolean;
  }
  
  public void setScanCallback(ScanUIRectView.a parama)
  {
    this.ytz = parama;
  }
  
  public void setScanCodeReaders(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(51979);
    com.tencent.qbar.h.fTD().K(paramArrayOfInt);
    AppMethodBeat.o(51979);
  }
  
  public void setScanMode(int paramInt)
  {
    this.mode = paramInt;
  }
  
  public void setScanRequest(BaseScanRequest paramBaseScanRequest)
  {
    this.ypQ = paramBaseScanRequest;
  }
  
  public void setScanSource(int paramInt)
  {
    AppMethodBeat.i(51964);
    if (this.ynO != null) {
      this.ynO.setScanSource(paramInt);
    }
    AppMethodBeat.o(51964);
  }
  
  public void setScrollTabController(com.tencent.mm.plugin.scanner.ui.widget.b paramb)
  {
    this.ypz = paramb;
  }
  
  public void setShowScanTips(boolean paramBoolean)
  {
    this.ypH = paramBoolean;
  }
  
  public void setSuccessMarkClickListener(com.tencent.mm.plugin.scanner.model.ad paramad)
  {
    AppMethodBeat.i(170025);
    if ((this.ynO instanceof ScanCodeMaskView)) {
      ((ScanCodeMaskView)this.ynO).setSuccessMarkClickListener(paramad);
    }
    AppMethodBeat.o(170025);
  }
  
  public final void stopPreview()
  {
    AppMethodBeat.i(51956);
    super.stopPreview();
    this.ytI = true;
    this.ytJ = false;
    AppMethodBeat.o(51956);
  }
  
  public final void zb(long paramLong)
  {
    AppMethodBeat.i(51957);
    this.ytG = true;
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ScanUIRectView", "alvinluo takeOneShot timeout: %d, isRetry: %b, onPreviewFrameCalled: %b, canReportOnPreviewFrame: %b, hasReport: %b", new Object[] { Long.valueOf(this.mTimeout), Boolean.valueOf(this.isRetry), Boolean.valueOf(this.ytP), Boolean.valueOf(this.ytO), Boolean.valueOf(this.ytN) });
    if (!this.isRetry)
    {
      super.zb(paramLong);
      this.ytM = System.currentTimeMillis();
      if ((!this.ytP) && (this.ytO) && (com.tencent.mm.plugin.scanner.util.o.OW(this.mode)))
      {
        removeCallbacks(this.ytQ);
        postDelayed(this.ytQ, this.mTimeout);
        AppMethodBeat.o(51957);
      }
    }
    else if ((this.ytK != null) && (this.ytK.OV(this.ytL)))
    {
      if (this.ytL == 1)
      {
        super.zb(paramLong);
        this.ytM = System.currentTimeMillis();
        AppMethodBeat.o(51957);
        return;
      }
      if (this.ytL == 2) {
        zc(paramLong);
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
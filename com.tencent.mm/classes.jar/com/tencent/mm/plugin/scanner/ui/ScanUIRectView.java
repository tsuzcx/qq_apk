package com.tencent.mm.plugin.scanner.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
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
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.WindowManager;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.wa;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.scanner.api.BaseScanRequest;
import com.tencent.mm.plugin.scanner.api.ScanGoodsRequest;
import com.tencent.mm.plugin.scanner.d.a.3;
import com.tencent.mm.plugin.scanner.d.b.3;
import com.tencent.mm.plugin.scanner.d.b.5;
import com.tencent.mm.plugin.scanner.d.b.b;
import com.tencent.mm.plugin.scanner.l.d;
import com.tencent.mm.plugin.scanner.l.i;
import com.tencent.mm.plugin.scanner.model.ac;
import com.tencent.mm.plugin.scanner.model.ad;
import com.tencent.mm.plugin.scanner.model.am;
import com.tencent.mm.plugin.scanner.model.an;
import com.tencent.mm.plugin.scanner.model.au;
import com.tencent.mm.plugin.scanner.ui.scangoods.widget.ScanGoodsMaskView;
import com.tencent.mm.plugin.scanner.ui.widget.ScanCodeMaskView;
import com.tencent.mm.plugin.scanner.ui.widget.ScanCodeProductMergeMaskView;
import com.tencent.mm.plugin.scanner.ui.widget.ScanDebugView;
import com.tencent.mm.plugin.scanner.ui.widget.ScanProductMaskDecorView;
import com.tencent.mm.plugin.scanner.ui.widget.ScanProductMaskDecorView.e;
import com.tencent.mm.plugin.scanner.ui.widget.ScanProductMaskDecorView.f;
import com.tencent.mm.plugin.scanner.ui.widget.ScanSharedMaskView;
import com.tencent.mm.plugin.scanner.ui.widget.ScanSharedMaskView.d;
import com.tencent.mm.plugin.scanner.util.ScanCameraLightDetector;
import com.tencent.mm.plugin.scanner.util.j;
import com.tencent.mm.plugin.scanner.util.o;
import com.tencent.mm.plugin.scanner.util.o.b;
import com.tencent.mm.plugin.scanner.util.r;
import com.tencent.mm.plugin.scanner.util.t;
import com.tencent.mm.plugin.scanner.view.BaseScanMaskView;
import com.tencent.mm.plugin.scanner.view.ScanRectDecorView;
import com.tencent.mm.plugin.scanner.view.ScanTranslationMaskView;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.qbar.QbarNative.QBarPoint;
import com.tencent.qbar.ScanDecodeFrameData;
import com.tencent.qbar.WxQbarNative.QBarReportMsg;
import com.tencent.qbar.g;
import com.tencent.qbar.h.c;
import com.tencent.qbar.h.d;
import com.tencent.scanlib.a.b.b.a;
import com.tencent.scanlib.a.b.c.a;
import com.tencent.scanlib.a.b.d.a;
import com.tencent.scanlib.ui.ScanView;
import com.tencent.threadpool.i;
import java.util.List;
import kotlin.ah;
import kotlin.g.b.s;

public class ScanUIRectView
  extends ScanView
{
  public static final int PbP;
  private boolean EPk;
  private boolean HRt;
  long OOu;
  BaseScanMaskView OSO;
  ScanSharedMaskView OSP;
  private boolean OTn;
  private BaseScanRequest OXF;
  private boolean OXP;
  private boolean OXS;
  private boolean OXT;
  private ScannerFlashSwitcher OXj;
  private ScanProductMaskDecorView OXk;
  private com.tencent.mm.plugin.scanner.ui.widget.b OXp;
  private boolean OXw;
  boolean OXx;
  private ScanProductMaskDecorView.f OYd;
  private ScanProductMaskDecorView.e OYf;
  private ScanRectDecorView PbB;
  ScanDebugView PbC;
  private ScanUIRectView.a PbD;
  private String PbE;
  private String PbF;
  private ScanCodeProductMergeMaskView PbG;
  com.tencent.mm.plugin.scanner.model.h PbH;
  private boolean PbI;
  private boolean PbJ;
  private int PbK;
  private int PbL;
  private boolean PbM;
  private boolean PbN;
  private boolean PbO;
  private boolean PbQ;
  private boolean PbR;
  private boolean PbS;
  private j PbT;
  private int PbU;
  private long PbV;
  private boolean PbW;
  private boolean PbX;
  private boolean PbY;
  private Runnable PbZ;
  private int Pca;
  private int Pcb;
  h.c Pcc;
  private com.tencent.mm.plugin.scanner.d.a.a Pcd;
  private IListener<wa> Pce;
  private b Pcf;
  private Activity activity;
  private boolean isFirst;
  private long lastShotTime;
  private com.tencent.mm.modelgeo.b.a lsF;
  private long mTimeout;
  int mode;
  private GestureDetector nwZ;
  private com.tencent.mm.modelgeo.d owr;
  private float puO;
  private boolean vBn;
  private Point zTI;
  
  static
  {
    AppMethodBeat.i(51980);
    PbP = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zmT, 50);
    AppMethodBeat.o(51980);
  }
  
  public ScanUIRectView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(51945);
    this.mode = 1;
    this.OXw = true;
    this.OXx = false;
    this.PbI = true;
    this.PbJ = false;
    this.PbK = 0;
    this.PbL = 120;
    this.HRt = false;
    this.zTI = null;
    this.OXT = true;
    this.PbN = true;
    this.PbO = false;
    this.OXS = false;
    this.OTn = false;
    this.OXP = false;
    this.PbQ = false;
    this.PbR = false;
    this.isFirst = true;
    this.PbS = false;
    this.PbT = new j();
    this.PbU = 0;
    this.PbV = 0L;
    this.mTimeout = this.PbT.mTimeout;
    this.PbW = false;
    this.PbX = true;
    this.PbY = false;
    this.vBn = false;
    this.PbZ = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(51916);
        if ((ScanUIRectView.a(ScanUIRectView.this)) && (!ScanUIRectView.b(ScanUIRectView.this)))
        {
          ScanUIRectView.c(ScanUIRectView.this);
          ScanUIRectView.d(ScanUIRectView.this);
          am.gRp();
          ScanUIRectView.e(ScanUIRectView.this);
        }
        AppMethodBeat.o(51916);
      }
    };
    this.Pca = 0;
    this.Pcb = 0;
    this.Pcc = new h.c()
    {
      public final void a(long paramAnonymousLong, List<com.tencent.qbar.a.a> paramAnonymousList, List<QbarNative.QBarPoint> paramAnonymousList1, List<WxQbarNative.QBarReportMsg> paramAnonymousList2, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(314519);
        Log.d("MicroMsg.ScanUIRectView", String.format("scan code after decode %d", new Object[] { Long.valueOf(paramAnonymousLong) }));
        if ((paramAnonymousList != null) && (!paramAnonymousList.isEmpty())) {
          ScanUIRectView.this.post(new ScanUIRectView.4.2(this, paramAnonymousLong, paramAnonymousList, paramAnonymousList2, paramAnonymousList1, paramAnonymousBundle));
        }
        AppMethodBeat.o(314519);
      }
      
      public final void b(long paramAnonymousLong, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(314520);
        ScanUIRectView.this.post(new ScanUIRectView.4.3(this, paramAnonymousLong, paramAnonymousBundle));
        AppMethodBeat.o(314520);
      }
      
      public final void bc(long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(314517);
        Log.i("MicroMsg.ScanUIRectView", "postTakeShot  session:%d  delay:%d", new Object[] { Long.valueOf(paramAnonymousLong1), Long.valueOf(paramAnonymousLong2) });
        ScanUIRectView.this.post(new ScanUIRectView.4.1(this, paramAnonymousLong1, paramAnonymousLong2));
        AppMethodBeat.o(314517);
      }
      
      public final void cr(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(314528);
        if (!ScanUIRectView.r(ScanUIRectView.this))
        {
          Log.w("MicroMsg.ScanUIRectView", "enableScanCodeProductMerge false, return");
          AppMethodBeat.o(314528);
          return;
        }
        if (ScanUIRectView.s(ScanUIRectView.this))
        {
          Log.w("MicroMsg.ScanUIRectView", "disableScanProductInMergeMode true, return");
          AppMethodBeat.o(314528);
          return;
        }
        com.tencent.mm.plugin.scanner.d.b localb;
        Point localPoint;
        int j;
        int k;
        try
        {
          if (!ScanUIRectView.t(ScanUIRectView.this).isOpen()) {
            break label900;
          }
          localb = com.tencent.mm.plugin.scanner.d.b.gQw();
          localPoint = ScanUIRectView.u(ScanUIRectView.this).jXF();
          j = ScanUIRectView.v(ScanUIRectView.this).getCameraRotation();
          k = ((com.tencent.mm.plugin.scanner.a.a)ScanUIRectView.w(ScanUIRectView.this)).gQf();
          if (!localb.OPe)
          {
            Log.e("MicroMsg.ReIdAiScanImageDecodeQueue", "addDecodeTask is not working");
            AppMethodBeat.o(314528);
            return;
          }
        }
        catch (Exception paramAnonymousArrayOfByte)
        {
          Log.printErrStackTrace("MicroMsg.ScanUIRectView", paramAnonymousArrayOfByte, "", new Object[0]);
          AppMethodBeat.o(314528);
          return;
        }
        if ((paramAnonymousArrayOfByte == null) || (paramAnonymousArrayOfByte.length == 0))
        {
          Log.e("MicroMsg.ReIdAiScanImageDecodeQueue", "addDecodeTask previewData is empty");
          AppMethodBeat.o(314528);
          return;
        }
        Object localObject;
        if (localb.OPd != null)
        {
          localObject = localb.OPd;
          ((b.b)localObject).OPx += 1;
        }
        if (localb.OPh < com.tencent.mm.plugin.scanner.d.b.OOK)
        {
          localb.OPh += 1;
          if (localb.OPd != null)
          {
            paramAnonymousArrayOfByte = localb.OPd;
            paramAnonymousArrayOfByte.OPz += 1;
          }
          Log.v("MicroMsg.ReIdAiScanImageDecodeQueue", "addDecodeTask skip frame, hasSkipCount:" + localb.OPh);
          AppMethodBeat.o(314528);
          return;
        }
        localb.OPh = 0;
        int i;
        if (!com.tencent.mm.plugin.scanner.c.a.gQt()) {
          i = 1;
        }
        for (;;)
        {
          double d;
          if (i == 0)
          {
            Log.e("MicroMsg.ReIdAiScanImageDecodeQueue", "addDecodeTask beyond shake range");
            if (localb.OPd != null)
            {
              paramAnonymousArrayOfByte = localb.OPd;
              paramAnonymousArrayOfByte.OPA += 1;
            }
            com.tencent.mm.plugin.scanner.d.b.a(new b.5(localb));
            AppMethodBeat.o(314528);
            return;
            long l2 = System.currentTimeMillis();
            long l1 = l2 - localb.mJI;
            localb.mJI = l2;
            if (l2 - localb.OPq > 1000L)
            {
              i = 1;
              continue;
            }
            if (localb.OPq > localb.OPr)
            {
              l2 = localb.OPq - localb.OPr;
              float f1 = localb.pxk - localb.OPm;
              float f2 = localb.pxl - localb.OPn;
              float f3 = localb.OPl - localb.OPo;
              localb.OPm = localb.pxk;
              localb.OPn = localb.pxl;
              localb.OPo = localb.OPl;
              localb.OPr = localb.OPq;
              localb.OPp = ((Math.pow(f1, 2.0D) + Math.pow(f2, 2.0D) + Math.pow(f3, 2.0D)) / l2 * 100.0D);
              Log.v("MicroMsg.ReIdAiScanImageDecodeQueue", "getShakeDeltaFromLastDetect  dx:%f, dy:%f, dz:%f, shakeDelta:%f, timeInterval:%d", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(f3), Double.valueOf(localb.OPp), Long.valueOf(l2) });
            }
            for (d = localb.OPp;; d = localb.OPp)
            {
              if (!BuildInfo.DEBUG) {
                break label906;
              }
              if (d <= 8.0D) {
                break;
              }
              Log.e("MicroMsg.ReIdAiScanImageDecodeQueue", "isWithinAcceptableShakeRange：" + d + "   duration:" + l1);
              break label906;
              Log.w("MicroMsg.ReIdAiScanImageDecodeQueue", "getShakeDeltaFromLastDetect  return last delta " + localb.OPp);
            }
            if (d > 4.0D) {
              Log.w("MicroMsg.ReIdAiScanImageDecodeQueue", "isWithinAcceptableShakeRange：" + d + "   duration:" + l1);
            } else {
              Log.d("MicroMsg.ReIdAiScanImageDecodeQueue", "isWithinAcceptableShakeRange：" + d + "   duration:" + l1);
            }
          }
          else
          {
            if ((com.tencent.mm.plugin.scanner.d.b.OPf != null) && (com.tencent.mm.plugin.scanner.d.b.OPg != null) && (com.tencent.mm.plugin.scanner.d.b.OPf.id != com.tencent.mm.plugin.scanner.d.b.OPg.id) && (localb.OPd != null))
            {
              localObject = localb.OPd;
              ((b.b)localObject).OPy += 1;
            }
            if (localb.OPd != null) {
              Log.i("MicroMsg.ReIdAiScanImageDecodeQueue", "addDecodeTask deal img:" + localb.OPd.OPB);
            }
            localObject = new com.tencent.mm.plugin.scanner.d.b.a();
            ((com.tencent.mm.plugin.scanner.d.b.a)localObject).imageData = paramAnonymousArrayOfByte;
            ((com.tencent.mm.plugin.scanner.d.b.a)localObject).id = System.currentTimeMillis();
            com.tencent.mm.plugin.scanner.d.b.OPf = (com.tencent.mm.plugin.scanner.d.b.a)localObject;
            localb.a(localPoint, j, k, true, true);
            label900:
            AppMethodBeat.o(314528);
            return;
          }
          label906:
          if (d < 4.0D) {
            i = 1;
          } else {
            i = 0;
          }
        }
      }
    };
    this.Pcd = new ScanUIRectView.5(this);
    this.lsF = new ScanUIRectView.6(this);
    this.Pce = new IListener(com.tencent.mm.app.f.hfK) {};
    this.nwZ = new GestureDetector(new ScanUIRectView.7(this));
    this.Pcf = new b(Looper.getMainLooper());
    AppMethodBeat.o(51945);
  }
  
  public ScanUIRectView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(51946);
    this.mode = 1;
    this.OXw = true;
    this.OXx = false;
    this.PbI = true;
    this.PbJ = false;
    this.PbK = 0;
    this.PbL = 120;
    this.HRt = false;
    this.zTI = null;
    this.OXT = true;
    this.PbN = true;
    this.PbO = false;
    this.OXS = false;
    this.OTn = false;
    this.OXP = false;
    this.PbQ = false;
    this.PbR = false;
    this.isFirst = true;
    this.PbS = false;
    this.PbT = new j();
    this.PbU = 0;
    this.PbV = 0L;
    this.mTimeout = this.PbT.mTimeout;
    this.PbW = false;
    this.PbX = true;
    this.PbY = false;
    this.vBn = false;
    this.PbZ = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(51916);
        if ((ScanUIRectView.a(ScanUIRectView.this)) && (!ScanUIRectView.b(ScanUIRectView.this)))
        {
          ScanUIRectView.c(ScanUIRectView.this);
          ScanUIRectView.d(ScanUIRectView.this);
          am.gRp();
          ScanUIRectView.e(ScanUIRectView.this);
        }
        AppMethodBeat.o(51916);
      }
    };
    this.Pca = 0;
    this.Pcb = 0;
    this.Pcc = new h.c()
    {
      public final void a(long paramAnonymousLong, List<com.tencent.qbar.a.a> paramAnonymousList, List<QbarNative.QBarPoint> paramAnonymousList1, List<WxQbarNative.QBarReportMsg> paramAnonymousList2, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(314519);
        Log.d("MicroMsg.ScanUIRectView", String.format("scan code after decode %d", new Object[] { Long.valueOf(paramAnonymousLong) }));
        if ((paramAnonymousList != null) && (!paramAnonymousList.isEmpty())) {
          ScanUIRectView.this.post(new ScanUIRectView.4.2(this, paramAnonymousLong, paramAnonymousList, paramAnonymousList2, paramAnonymousList1, paramAnonymousBundle));
        }
        AppMethodBeat.o(314519);
      }
      
      public final void b(long paramAnonymousLong, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(314520);
        ScanUIRectView.this.post(new ScanUIRectView.4.3(this, paramAnonymousLong, paramAnonymousBundle));
        AppMethodBeat.o(314520);
      }
      
      public final void bc(long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(314517);
        Log.i("MicroMsg.ScanUIRectView", "postTakeShot  session:%d  delay:%d", new Object[] { Long.valueOf(paramAnonymousLong1), Long.valueOf(paramAnonymousLong2) });
        ScanUIRectView.this.post(new ScanUIRectView.4.1(this, paramAnonymousLong1, paramAnonymousLong2));
        AppMethodBeat.o(314517);
      }
      
      public final void cr(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(314528);
        if (!ScanUIRectView.r(ScanUIRectView.this))
        {
          Log.w("MicroMsg.ScanUIRectView", "enableScanCodeProductMerge false, return");
          AppMethodBeat.o(314528);
          return;
        }
        if (ScanUIRectView.s(ScanUIRectView.this))
        {
          Log.w("MicroMsg.ScanUIRectView", "disableScanProductInMergeMode true, return");
          AppMethodBeat.o(314528);
          return;
        }
        com.tencent.mm.plugin.scanner.d.b localb;
        Point localPoint;
        int j;
        int k;
        try
        {
          if (!ScanUIRectView.t(ScanUIRectView.this).isOpen()) {
            break label900;
          }
          localb = com.tencent.mm.plugin.scanner.d.b.gQw();
          localPoint = ScanUIRectView.u(ScanUIRectView.this).jXF();
          j = ScanUIRectView.v(ScanUIRectView.this).getCameraRotation();
          k = ((com.tencent.mm.plugin.scanner.a.a)ScanUIRectView.w(ScanUIRectView.this)).gQf();
          if (!localb.OPe)
          {
            Log.e("MicroMsg.ReIdAiScanImageDecodeQueue", "addDecodeTask is not working");
            AppMethodBeat.o(314528);
            return;
          }
        }
        catch (Exception paramAnonymousArrayOfByte)
        {
          Log.printErrStackTrace("MicroMsg.ScanUIRectView", paramAnonymousArrayOfByte, "", new Object[0]);
          AppMethodBeat.o(314528);
          return;
        }
        if ((paramAnonymousArrayOfByte == null) || (paramAnonymousArrayOfByte.length == 0))
        {
          Log.e("MicroMsg.ReIdAiScanImageDecodeQueue", "addDecodeTask previewData is empty");
          AppMethodBeat.o(314528);
          return;
        }
        Object localObject;
        if (localb.OPd != null)
        {
          localObject = localb.OPd;
          ((b.b)localObject).OPx += 1;
        }
        if (localb.OPh < com.tencent.mm.plugin.scanner.d.b.OOK)
        {
          localb.OPh += 1;
          if (localb.OPd != null)
          {
            paramAnonymousArrayOfByte = localb.OPd;
            paramAnonymousArrayOfByte.OPz += 1;
          }
          Log.v("MicroMsg.ReIdAiScanImageDecodeQueue", "addDecodeTask skip frame, hasSkipCount:" + localb.OPh);
          AppMethodBeat.o(314528);
          return;
        }
        localb.OPh = 0;
        int i;
        if (!com.tencent.mm.plugin.scanner.c.a.gQt()) {
          i = 1;
        }
        for (;;)
        {
          double d;
          if (i == 0)
          {
            Log.e("MicroMsg.ReIdAiScanImageDecodeQueue", "addDecodeTask beyond shake range");
            if (localb.OPd != null)
            {
              paramAnonymousArrayOfByte = localb.OPd;
              paramAnonymousArrayOfByte.OPA += 1;
            }
            com.tencent.mm.plugin.scanner.d.b.a(new b.5(localb));
            AppMethodBeat.o(314528);
            return;
            long l2 = System.currentTimeMillis();
            long l1 = l2 - localb.mJI;
            localb.mJI = l2;
            if (l2 - localb.OPq > 1000L)
            {
              i = 1;
              continue;
            }
            if (localb.OPq > localb.OPr)
            {
              l2 = localb.OPq - localb.OPr;
              float f1 = localb.pxk - localb.OPm;
              float f2 = localb.pxl - localb.OPn;
              float f3 = localb.OPl - localb.OPo;
              localb.OPm = localb.pxk;
              localb.OPn = localb.pxl;
              localb.OPo = localb.OPl;
              localb.OPr = localb.OPq;
              localb.OPp = ((Math.pow(f1, 2.0D) + Math.pow(f2, 2.0D) + Math.pow(f3, 2.0D)) / l2 * 100.0D);
              Log.v("MicroMsg.ReIdAiScanImageDecodeQueue", "getShakeDeltaFromLastDetect  dx:%f, dy:%f, dz:%f, shakeDelta:%f, timeInterval:%d", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(f3), Double.valueOf(localb.OPp), Long.valueOf(l2) });
            }
            for (d = localb.OPp;; d = localb.OPp)
            {
              if (!BuildInfo.DEBUG) {
                break label906;
              }
              if (d <= 8.0D) {
                break;
              }
              Log.e("MicroMsg.ReIdAiScanImageDecodeQueue", "isWithinAcceptableShakeRange：" + d + "   duration:" + l1);
              break label906;
              Log.w("MicroMsg.ReIdAiScanImageDecodeQueue", "getShakeDeltaFromLastDetect  return last delta " + localb.OPp);
            }
            if (d > 4.0D) {
              Log.w("MicroMsg.ReIdAiScanImageDecodeQueue", "isWithinAcceptableShakeRange：" + d + "   duration:" + l1);
            } else {
              Log.d("MicroMsg.ReIdAiScanImageDecodeQueue", "isWithinAcceptableShakeRange：" + d + "   duration:" + l1);
            }
          }
          else
          {
            if ((com.tencent.mm.plugin.scanner.d.b.OPf != null) && (com.tencent.mm.plugin.scanner.d.b.OPg != null) && (com.tencent.mm.plugin.scanner.d.b.OPf.id != com.tencent.mm.plugin.scanner.d.b.OPg.id) && (localb.OPd != null))
            {
              localObject = localb.OPd;
              ((b.b)localObject).OPy += 1;
            }
            if (localb.OPd != null) {
              Log.i("MicroMsg.ReIdAiScanImageDecodeQueue", "addDecodeTask deal img:" + localb.OPd.OPB);
            }
            localObject = new com.tencent.mm.plugin.scanner.d.b.a();
            ((com.tencent.mm.plugin.scanner.d.b.a)localObject).imageData = paramAnonymousArrayOfByte;
            ((com.tencent.mm.plugin.scanner.d.b.a)localObject).id = System.currentTimeMillis();
            com.tencent.mm.plugin.scanner.d.b.OPf = (com.tencent.mm.plugin.scanner.d.b.a)localObject;
            localb.a(localPoint, j, k, true, true);
            label900:
            AppMethodBeat.o(314528);
            return;
          }
          label906:
          if (d < 4.0D) {
            i = 1;
          } else {
            i = 0;
          }
        }
      }
    };
    this.Pcd = new ScanUIRectView.5(this);
    this.lsF = new ScanUIRectView.6(this);
    this.Pce = new IListener(com.tencent.mm.app.f.hfK) {};
    this.nwZ = new GestureDetector(new ScanUIRectView.7(this));
    this.Pcf = new b(Looper.getMainLooper());
    AppMethodBeat.o(51946);
  }
  
  public ScanUIRectView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(51947);
    this.mode = 1;
    this.OXw = true;
    this.OXx = false;
    this.PbI = true;
    this.PbJ = false;
    this.PbK = 0;
    this.PbL = 120;
    this.HRt = false;
    this.zTI = null;
    this.OXT = true;
    this.PbN = true;
    this.PbO = false;
    this.OXS = false;
    this.OTn = false;
    this.OXP = false;
    this.PbQ = false;
    this.PbR = false;
    this.isFirst = true;
    this.PbS = false;
    this.PbT = new j();
    this.PbU = 0;
    this.PbV = 0L;
    this.mTimeout = this.PbT.mTimeout;
    this.PbW = false;
    this.PbX = true;
    this.PbY = false;
    this.vBn = false;
    this.PbZ = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(51916);
        if ((ScanUIRectView.a(ScanUIRectView.this)) && (!ScanUIRectView.b(ScanUIRectView.this)))
        {
          ScanUIRectView.c(ScanUIRectView.this);
          ScanUIRectView.d(ScanUIRectView.this);
          am.gRp();
          ScanUIRectView.e(ScanUIRectView.this);
        }
        AppMethodBeat.o(51916);
      }
    };
    this.Pca = 0;
    this.Pcb = 0;
    this.Pcc = new h.c()
    {
      public final void a(long paramAnonymousLong, List<com.tencent.qbar.a.a> paramAnonymousList, List<QbarNative.QBarPoint> paramAnonymousList1, List<WxQbarNative.QBarReportMsg> paramAnonymousList2, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(314519);
        Log.d("MicroMsg.ScanUIRectView", String.format("scan code after decode %d", new Object[] { Long.valueOf(paramAnonymousLong) }));
        if ((paramAnonymousList != null) && (!paramAnonymousList.isEmpty())) {
          ScanUIRectView.this.post(new ScanUIRectView.4.2(this, paramAnonymousLong, paramAnonymousList, paramAnonymousList2, paramAnonymousList1, paramAnonymousBundle));
        }
        AppMethodBeat.o(314519);
      }
      
      public final void b(long paramAnonymousLong, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(314520);
        ScanUIRectView.this.post(new ScanUIRectView.4.3(this, paramAnonymousLong, paramAnonymousBundle));
        AppMethodBeat.o(314520);
      }
      
      public final void bc(long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(314517);
        Log.i("MicroMsg.ScanUIRectView", "postTakeShot  session:%d  delay:%d", new Object[] { Long.valueOf(paramAnonymousLong1), Long.valueOf(paramAnonymousLong2) });
        ScanUIRectView.this.post(new ScanUIRectView.4.1(this, paramAnonymousLong1, paramAnonymousLong2));
        AppMethodBeat.o(314517);
      }
      
      public final void cr(byte[] paramAnonymousArrayOfByte)
      {
        AppMethodBeat.i(314528);
        if (!ScanUIRectView.r(ScanUIRectView.this))
        {
          Log.w("MicroMsg.ScanUIRectView", "enableScanCodeProductMerge false, return");
          AppMethodBeat.o(314528);
          return;
        }
        if (ScanUIRectView.s(ScanUIRectView.this))
        {
          Log.w("MicroMsg.ScanUIRectView", "disableScanProductInMergeMode true, return");
          AppMethodBeat.o(314528);
          return;
        }
        com.tencent.mm.plugin.scanner.d.b localb;
        Point localPoint;
        int j;
        int k;
        try
        {
          if (!ScanUIRectView.t(ScanUIRectView.this).isOpen()) {
            break label900;
          }
          localb = com.tencent.mm.plugin.scanner.d.b.gQw();
          localPoint = ScanUIRectView.u(ScanUIRectView.this).jXF();
          j = ScanUIRectView.v(ScanUIRectView.this).getCameraRotation();
          k = ((com.tencent.mm.plugin.scanner.a.a)ScanUIRectView.w(ScanUIRectView.this)).gQf();
          if (!localb.OPe)
          {
            Log.e("MicroMsg.ReIdAiScanImageDecodeQueue", "addDecodeTask is not working");
            AppMethodBeat.o(314528);
            return;
          }
        }
        catch (Exception paramAnonymousArrayOfByte)
        {
          Log.printErrStackTrace("MicroMsg.ScanUIRectView", paramAnonymousArrayOfByte, "", new Object[0]);
          AppMethodBeat.o(314528);
          return;
        }
        if ((paramAnonymousArrayOfByte == null) || (paramAnonymousArrayOfByte.length == 0))
        {
          Log.e("MicroMsg.ReIdAiScanImageDecodeQueue", "addDecodeTask previewData is empty");
          AppMethodBeat.o(314528);
          return;
        }
        Object localObject;
        if (localb.OPd != null)
        {
          localObject = localb.OPd;
          ((b.b)localObject).OPx += 1;
        }
        if (localb.OPh < com.tencent.mm.plugin.scanner.d.b.OOK)
        {
          localb.OPh += 1;
          if (localb.OPd != null)
          {
            paramAnonymousArrayOfByte = localb.OPd;
            paramAnonymousArrayOfByte.OPz += 1;
          }
          Log.v("MicroMsg.ReIdAiScanImageDecodeQueue", "addDecodeTask skip frame, hasSkipCount:" + localb.OPh);
          AppMethodBeat.o(314528);
          return;
        }
        localb.OPh = 0;
        int i;
        if (!com.tencent.mm.plugin.scanner.c.a.gQt()) {
          i = 1;
        }
        for (;;)
        {
          double d;
          if (i == 0)
          {
            Log.e("MicroMsg.ReIdAiScanImageDecodeQueue", "addDecodeTask beyond shake range");
            if (localb.OPd != null)
            {
              paramAnonymousArrayOfByte = localb.OPd;
              paramAnonymousArrayOfByte.OPA += 1;
            }
            com.tencent.mm.plugin.scanner.d.b.a(new b.5(localb));
            AppMethodBeat.o(314528);
            return;
            long l2 = System.currentTimeMillis();
            long l1 = l2 - localb.mJI;
            localb.mJI = l2;
            if (l2 - localb.OPq > 1000L)
            {
              i = 1;
              continue;
            }
            if (localb.OPq > localb.OPr)
            {
              l2 = localb.OPq - localb.OPr;
              float f1 = localb.pxk - localb.OPm;
              float f2 = localb.pxl - localb.OPn;
              float f3 = localb.OPl - localb.OPo;
              localb.OPm = localb.pxk;
              localb.OPn = localb.pxl;
              localb.OPo = localb.OPl;
              localb.OPr = localb.OPq;
              localb.OPp = ((Math.pow(f1, 2.0D) + Math.pow(f2, 2.0D) + Math.pow(f3, 2.0D)) / l2 * 100.0D);
              Log.v("MicroMsg.ReIdAiScanImageDecodeQueue", "getShakeDeltaFromLastDetect  dx:%f, dy:%f, dz:%f, shakeDelta:%f, timeInterval:%d", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(f3), Double.valueOf(localb.OPp), Long.valueOf(l2) });
            }
            for (d = localb.OPp;; d = localb.OPp)
            {
              if (!BuildInfo.DEBUG) {
                break label906;
              }
              if (d <= 8.0D) {
                break;
              }
              Log.e("MicroMsg.ReIdAiScanImageDecodeQueue", "isWithinAcceptableShakeRange：" + d + "   duration:" + l1);
              break label906;
              Log.w("MicroMsg.ReIdAiScanImageDecodeQueue", "getShakeDeltaFromLastDetect  return last delta " + localb.OPp);
            }
            if (d > 4.0D) {
              Log.w("MicroMsg.ReIdAiScanImageDecodeQueue", "isWithinAcceptableShakeRange：" + d + "   duration:" + l1);
            } else {
              Log.d("MicroMsg.ReIdAiScanImageDecodeQueue", "isWithinAcceptableShakeRange：" + d + "   duration:" + l1);
            }
          }
          else
          {
            if ((com.tencent.mm.plugin.scanner.d.b.OPf != null) && (com.tencent.mm.plugin.scanner.d.b.OPg != null) && (com.tencent.mm.plugin.scanner.d.b.OPf.id != com.tencent.mm.plugin.scanner.d.b.OPg.id) && (localb.OPd != null))
            {
              localObject = localb.OPd;
              ((b.b)localObject).OPy += 1;
            }
            if (localb.OPd != null) {
              Log.i("MicroMsg.ReIdAiScanImageDecodeQueue", "addDecodeTask deal img:" + localb.OPd.OPB);
            }
            localObject = new com.tencent.mm.plugin.scanner.d.b.a();
            ((com.tencent.mm.plugin.scanner.d.b.a)localObject).imageData = paramAnonymousArrayOfByte;
            ((com.tencent.mm.plugin.scanner.d.b.a)localObject).id = System.currentTimeMillis();
            com.tencent.mm.plugin.scanner.d.b.OPf = (com.tencent.mm.plugin.scanner.d.b.a)localObject;
            localb.a(localPoint, j, k, true, true);
            label900:
            AppMethodBeat.o(314528);
            return;
          }
          label906:
          if (d < 4.0D) {
            i = 1;
          } else {
            i = 0;
          }
        }
      }
    };
    this.Pcd = new ScanUIRectView.5(this);
    this.lsF = new ScanUIRectView.6(this);
    this.Pce = new IListener(com.tencent.mm.app.f.hfK) {};
    this.nwZ = new GestureDetector(new ScanUIRectView.7(this));
    this.Pcf = new b(Looper.getMainLooper());
    AppMethodBeat.o(51947);
  }
  
  private void Ck(boolean paramBoolean)
  {
    AppMethodBeat.i(51974);
    if (this.OSO != null) {
      this.OSO.Ck(paramBoolean);
    }
    if (this.OSP != null) {
      this.OSP.Ck(paramBoolean);
    }
    if (this.PbC != null) {
      this.PbC.setVisibility(8);
    }
    if (this.PbH != null) {
      this.PbH.gQK();
    }
    AppMethodBeat.o(51974);
  }
  
  private void a(Object paramObject, com.tencent.mm.plugin.scanner.view.d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(314559);
    Log.i("MicroMsg.ScanUIRectView", "alvinluo onScanSuccess");
    gSW();
    gSt();
    if (this.OSO != null)
    {
      this.OSO.a(paramObject, paramd);
      this.OSO.iZ(this.cHz);
    }
    if (this.OSP != null) {
      this.OSP.Ct(paramBoolean);
    }
    if ((t.aiG(this.mode)) && (this.PbT != null)) {
      this.PbT.Pje = true;
    }
    AppMethodBeat.o(314559);
  }
  
  private void co(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(161043);
    Log.i("MicroMsg.ScanUIRectView", "processFrame");
    if ((this.ahwr.boa()) && (((com.tencent.mm.plugin.scanner.a.a)this.ahwr).gQd())) {
      ScanCameraLightDetector.Pio.N(paramArrayOfByte, ((com.tencent.mm.plugin.scanner.a.a)this.ahwr).jXF().x, ((com.tencent.mm.plugin.scanner.a.a)this.ahwr).jXF().y);
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
      cp(paramArrayOfByte);
      AppMethodBeat.o(161043);
      return;
    }
    cq(paramArrayOfByte);
    AppMethodBeat.o(161043);
  }
  
  private void cp(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(161044);
    Log.i("MicroMsg.ScanUIRectView", "handleCodeData");
    Object localObject;
    Rect localRect1;
    if ((this.OOu != 0L) && (this.ahwr.boa()))
    {
      localObject = this.ahwr.jXF();
      if (localObject != null)
      {
        localRect1 = getScanCodeRect();
        if ((this.vBn) && (this.PbU != 1)) {
          break label207;
        }
        Rect localRect2 = ((com.tencent.mm.plugin.scanner.a.a)this.ahwr).O(localRect1);
        if (this.OSO != null)
        {
          this.OSO.setPreviewRect(localRect2);
          this.OSO.setScanRect(localRect1);
          if ((this.OSO instanceof ScanCodeMaskView)) {
            ((ScanCodeMaskView)this.OSO).setNeedRotate(true);
          }
        }
        com.tencent.qbar.h.jWV().a(paramArrayOfByte, (Point)localObject, this.ahwr.getCameraRotation(), localRect2);
      }
    }
    for (;;)
    {
      if ((!((com.tencent.scanlib.a.a)this.ahwr).gSN()) && (com.tencent.qbar.h.jWV().OOx > PbP))
      {
        Log.i("MicroMsg.ScanUIRectView", "change to FOCUS_MODE_AUTO");
        this.ahwr.bFD("auto");
        Bb(100L);
      }
      AppMethodBeat.o(161044);
      return;
      label207:
      if ((this.vBn) && (this.PbU == 2))
      {
        localObject = new Rect(0, 0, this.Pca, this.Pcb);
        if (this.OSO != null)
        {
          this.OSO.setPreviewRect((Rect)localObject);
          this.OSO.setScanRect(localRect1);
          if ((this.OSO instanceof ScanCodeMaskView)) {
            ((ScanCodeMaskView)this.OSO).setNeedRotate(false);
          }
        }
        com.tencent.qbar.h.jWV().a(paramArrayOfByte, new Point(this.Pca, this.Pcb), 0, (Rect)localObject);
      }
    }
  }
  
  private void cq(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(161045);
    if (this.OOu != 0L) {
      synchronized (this.ahwr)
      {
        if (this.ahwr.boa())
        {
          Point localPoint = this.ahwr.jXF();
          boolean bool = true;
          if ((this.OXF instanceof ScanGoodsRequest)) {
            bool = ((ScanGoodsRequest)this.OXF).OME;
          }
          com.tencent.mm.plugin.scanner.d.a.gQu().a(paramArrayOfByte, localPoint, this.ahwr.getCameraRotation(), ((com.tencent.mm.plugin.scanner.a.a)this.ahwr).gQf(), bool);
        }
        AppMethodBeat.o(161045);
        return;
      }
    }
    AppMethodBeat.o(161045);
  }
  
  private byte[] gSP()
  {
    AppMethodBeat.i(161042);
    for (;;)
    {
      int i;
      try
      {
        l1 = System.currentTimeMillis();
        k = this.cHz.getWidth();
        int m = this.cHz.getHeight();
        i = m;
        j = k;
        if (this.PbT == null) {
          break label300;
        }
        i = m;
        j = k;
        if (this.PbT.Pjc == 0.0F) {
          break label300;
        }
        j = (int)(this.cHz.getWidth() * this.PbT.Pjc);
        i = (int)(this.cHz.getHeight() * this.PbT.Pjc);
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
      localObject = this.cHz.getBitmap(k, j);
      Log.d("MicroMsg.ScanUIRectView", "alvinluo generateFrameByTextureView getBitmap cost: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
      {
        this.Pca = ((Bitmap)localObject).getWidth();
        this.Pcb = ((Bitmap)localObject).getHeight();
        Log.d("MicroMsg.ScanUIRectView", "alvinluo generateFrameByTextureView bitmap width: %d, height: %d", new Object[] { Integer.valueOf(this.Pca), Integer.valueOf(this.Pcb) });
        l1 = System.currentTimeMillis();
        localObject = r.getNV21(this.Pca, this.Pcb, (Bitmap)localObject);
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
  
  private void gSQ()
  {
    boolean bool3 = true;
    boolean bool2 = true;
    Object localObject3 = null;
    AppMethodBeat.i(51960);
    Log.d("MicroMsg.ScanUIRectView", "createScanMaskView mode: %d, bottomHeight: %d", new Object[] { Integer.valueOf(this.mode), Integer.valueOf(this.PbK) });
    Object localObject1;
    Object localObject2;
    boolean bool1;
    label280:
    ScanSharedMaskView localScanSharedMaskView;
    int i;
    label355:
    Object localObject4;
    switch (this.mode)
    {
    default: 
      Log.i("MicroMsg.ScanUIRectView", "unknown scan mode %d", new Object[] { Integer.valueOf(this.mode) });
      if ((this.OSO != null) && (this.OSP != null))
      {
        localObject1 = this.OSO;
        localObject2 = this.PbH;
        s.u(localObject2, "scanUIModel");
        ((BaseScanMaskView)localObject1).OSW = ((com.tencent.mm.plugin.scanner.model.h)localObject2);
        this.OSO.setBottomExtraHeight(this.PbK);
        this.OSO.PaS = ((com.tencent.mm.plugin.scanner.a.a)this.ahwr);
        localObject1 = this.OSO;
        localObject2 = this.OSP.getScanTipsView();
        s.u(localObject2, "tipsView");
        ((BaseScanMaskView)localObject1).Pht = ((TextView)localObject2);
        this.OSO.PhG = this.OXj.fhR;
        this.OSO.gTe();
        this.OSP.setBottomExtraHeight(this.PbK);
        this.OSP.setFlashStatus(this.OXj.fhR);
        localObject1 = this.OSP;
        if (this.isFirst) {
          break label880;
        }
        bool1 = true;
        ((ScanSharedMaskView)localObject1).setShowTitle(bool1);
        localScanSharedMaskView = this.OSP;
        i = this.mode;
        Log.i("MicroMsg.ScanSharedMaskView", "alvinluo onViewReady currentTab: %d, hashCode: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(localScanSharedMaskView.hashCode()) });
        localScanSharedMaskView.Phy = i;
        localObject1 = localScanSharedMaskView.Pht;
        if (localObject1 != null) {
          break label885;
        }
        s.bIx("scanTips");
        localObject1 = null;
        localObject4 = localScanSharedMaskView.Pht;
        localObject2 = localObject4;
        if (localObject4 == null)
        {
          s.bIx("scanTips");
          localObject2 = null;
        }
        localObject2 = ((TextView)localObject2).getLayoutParams();
        if (localObject2 != null) {
          break label888;
        }
        localObject2 = null;
        label395:
        ((TextView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        localObject1 = localScanSharedMaskView.Phu;
        if (localObject1 != null) {
          break label928;
        }
        s.bIx("scanToast");
        localObject1 = null;
        label423:
        localObject4 = localScanSharedMaskView.Phu;
        localObject2 = localObject4;
        if (localObject4 == null)
        {
          s.bIx("scanToast");
          localObject2 = null;
        }
        localObject2 = ((TextView)localObject2).getLayoutParams();
        if (localObject2 != null) {
          break label931;
        }
        localObject2 = null;
        label463:
        ((TextView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        localObject1 = localScanSharedMaskView.Phw;
        if (localObject1 != null) {
          break label971;
        }
        s.bIx("galleryButton");
        localObject1 = null;
        label491:
        localObject4 = localScanSharedMaskView.Phw;
        localObject2 = localObject4;
        if (localObject4 == null)
        {
          s.bIx("galleryButton");
          localObject2 = null;
        }
        localObject2 = ((View)localObject2).getLayoutParams();
        if (localObject2 != null) {
          break label974;
        }
        localObject2 = null;
        label531:
        ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        if (!t.aiI(localScanSharedMaskView.Phy)) {
          break label1014;
        }
        localObject2 = localScanSharedMaskView.OXj;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          s.bIx("flashSwitcher");
          localObject1 = null;
        }
        ((ScannerFlashSwitcher)localObject1).setVisibility(8);
        if (localScanSharedMaskView.PhI) {
          break label1133;
        }
        if (localScanSharedMaskView.PhG) {
          break label1128;
        }
        bool1 = bool2;
        label599:
        localScanSharedMaskView.Cr(bool1);
        localObject2 = localScanSharedMaskView.Phs;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          s.bIx("scanTitle");
          localObject1 = null;
        }
        ((TextView)localObject1).setVisibility(8);
        localScanSharedMaskView.PhF = false;
        localObject1 = localScanSharedMaskView.Phu;
        if (localObject1 != null) {
          break label1326;
        }
        s.bIx("scanToast");
        localObject1 = localObject3;
      }
      break;
    }
    label928:
    label931:
    label1326:
    for (;;)
    {
      ((TextView)localObject1).setVisibility(8);
      localScanSharedMaskView.eqb();
      localScanSharedMaskView.aiB(i);
      this.isFirst = false;
      AppMethodBeat.o(51960);
      return;
      gSV();
      if (this.OTn)
      {
        this.PbG = new ScanCodeProductMergeMaskView(getContext());
        this.OSO = this.PbG;
        this.OXk = this.PbG.getScanProductView();
        this.PbG.setScanProductCallBack(this.OYf);
        this.PbG.setScanProductOnItemClickListener(this.OYd);
      }
      for (;;)
      {
        addView(this.OSO);
        break;
        this.OSO = new ScanCodeMaskView(getContext());
      }
      this.OSO = new ScanTranslationMaskView(getContext());
      addView(this.OSO);
      break;
      this.OSO = new ScanGoodsMaskView(getContext());
      addView(this.OSO);
      if ((!(this.OSO instanceof ScanGoodsMaskView)) || (!(this.OXF instanceof ScanGoodsRequest))) {
        break;
      }
      ((ScanGoodsMaskView)this.OSO).setScanRequest((ScanGoodsRequest)this.OXF);
      break;
      label880:
      bool1 = false;
      break label280;
      label885:
      break label355;
      label888:
      if ((localObject2 instanceof ViewGroup.MarginLayoutParams)) {
        ((ViewGroup.MarginLayoutParams)localObject2).bottomMargin = (com.tencent.mm.cd.a.fromDPToPix(localScanSharedMaskView.getContext(), 120) + localScanSharedMaskView.PhH);
      }
      localObject4 = ah.aiuX;
      break label395;
      break label423;
      if ((localObject2 instanceof ViewGroup.MarginLayoutParams)) {
        ((ViewGroup.MarginLayoutParams)localObject2).bottomMargin = (com.tencent.mm.cd.a.fromDPToPix(localScanSharedMaskView.getContext(), 110) + localScanSharedMaskView.PhH);
      }
      localObject4 = ah.aiuX;
      break label463;
      label971:
      break label491;
      label974:
      if ((localObject2 instanceof ViewGroup.MarginLayoutParams)) {
        ((ViewGroup.MarginLayoutParams)localObject2).bottomMargin = (com.tencent.mm.cd.a.fromDPToPix(localScanSharedMaskView.getContext(), 32) + localScanSharedMaskView.PhH);
      }
      localObject4 = ah.aiuX;
      break label531;
      label1014:
      localObject1 = localScanSharedMaskView.OXj;
      if (localObject1 == null)
      {
        s.bIx("flashSwitcher");
        localObject1 = null;
        localObject4 = localScanSharedMaskView.OXj;
        localObject2 = localObject4;
        if (localObject4 == null)
        {
          s.bIx("flashSwitcher");
          localObject2 = null;
        }
        localObject2 = ((ScannerFlashSwitcher)localObject2).getLayoutParams();
        if (localObject2 != null) {
          break label1088;
        }
        localObject2 = null;
      }
      for (;;)
      {
        ((ScannerFlashSwitcher)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        break;
        break label1035;
        label1088:
        if ((localObject2 instanceof ViewGroup.MarginLayoutParams)) {
          ((ViewGroup.MarginLayoutParams)localObject2).bottomMargin = (com.tencent.mm.cd.a.fromDPToPix(localScanSharedMaskView.getContext(), 112) + localScanSharedMaskView.PhH);
        }
        localObject4 = ah.aiuX;
      }
      label1128:
      bool1 = false;
      break label599;
      label1133:
      localScanSharedMaskView.Cr(false);
      localScanSharedMaskView.gTz();
      localScanSharedMaskView.gTA();
      localObject2 = localScanSharedMaskView.Phs;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("scanTitle");
        localObject1 = null;
      }
      ((TextView)localObject1).setAlpha(1.0F);
      localObject2 = localScanSharedMaskView.Phs;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("scanTitle");
        localObject1 = null;
      }
      if (((TextView)localObject1).getVisibility() != 0) {}
      for (bool1 = bool3;; bool1 = false)
      {
        if (localScanSharedMaskView.PhD == null)
        {
          localObject4 = new o();
          localObject2 = localScanSharedMaskView.Phs;
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            s.bIx("scanTitle");
            localObject1 = null;
          }
          localObject1 = ((o)localObject4).ja((View)localObject1).gUh().gUi();
          ((o)localObject1).PjD = ((o.b)new ScanSharedMaskView.d(localScanSharedMaskView));
          localScanSharedMaskView.PhD = ((o)localObject1);
        }
        localObject1 = localScanSharedMaskView.PhD;
        if (localObject1 == null) {
          break;
        }
        ((o)localObject1).Cz(bool1);
        break;
      }
    }
  }
  
  private void gSR()
  {
    AppMethodBeat.i(51962);
    String str = getScanTips();
    this.OSP.setScanTips(str);
    this.OSP.setScanRequest(this.OXF);
    switch (this.mode)
    {
    default: 
      Log.e("MicroMsg.ScanUIRectView", "alvinluo refreshSharedMaskView unknown scan mode %d", new Object[] { Integer.valueOf(this.mode) });
      AppMethodBeat.o(51962);
      return;
    case 1: 
    case 4: 
    case 8: 
      if (this.OTn)
      {
        this.OSP.setScanTitle(getResources().getString(l.i.OKT));
        AppMethodBeat.o(51962);
        return;
      }
      this.OSP.setScanTitle(getResources().getString(l.i.OKW));
      AppMethodBeat.o(51962);
      return;
    case 3: 
      this.OSP.setScanTitle(getResources().getString(l.i.scan_entry_ocr));
      AppMethodBeat.o(51962);
      return;
    }
    this.OSP.setScanTitle(getResources().getString(l.i.OKU));
    AppMethodBeat.o(51962);
  }
  
  private void gSU()
  {
    AppMethodBeat.i(51970);
    this.PbG = null;
    if (this.OSO != null)
    {
      final BaseScanMaskView localBaseScanMaskView = this.OSO;
      localBaseScanMaskView.a(new Animator.AnimatorListener()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(314505);
          ScanUIRectView.this.removeView((View)localBaseScanMaskView);
          localBaseScanMaskView.release();
          AppMethodBeat.o(314505);
        }
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(314502);
          ScanUIRectView.this.removeView((View)localBaseScanMaskView);
          localBaseScanMaskView.release();
          AppMethodBeat.o(314502);
        }
        
        public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationStart(Animator paramAnonymousAnimator) {}
      });
    }
    AppMethodBeat.o(51970);
  }
  
  private void gSV()
  {
    AppMethodBeat.i(162394);
    if (com.tencent.qbar.f.jWS())
    {
      Log.i("MicroMsg.ScanUIRectView", "alvinluo updateScanCodeRect visibleResolution: %s", new Object[] { this.zTI });
      if ((this.zTI != null) && (this.zTI.x > 0) && (this.zTI.y > 0))
      {
        this.PbB.setDecorRect(new Rect(0, (int)(this.zTI.y * 1.0F / 19.0F), this.zTI.x, (int)(this.zTI.y * 17.0F / 19.0F)));
        AppMethodBeat.o(162394);
      }
    }
    else
    {
      this.PbB.kX(getResources().getDimensionPixelSize(l.d.scan_code_rect_width), getResources().getDimensionPixelSize(l.d.scan_code_rect_height));
    }
    AppMethodBeat.o(162394);
  }
  
  private void gSW()
  {
    AppMethodBeat.i(160188);
    if (this.PbZ != null) {
      removeCallbacks(this.PbZ);
    }
    AppMethodBeat.o(160188);
  }
  
  private Rect getScanCodeRect()
  {
    int j = 0;
    AppMethodBeat.i(51975);
    if (com.tencent.qbar.f.jWS())
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
    if (!this.OXw)
    {
      AppMethodBeat.o(51963);
      return "";
    }
    if (this.OTn) {}
    switch (this.mode)
    {
    default: 
      switch (this.mode)
      {
      default: 
        AppMethodBeat.o(51963);
        return "";
      }
      break;
    }
    if (!Util.isNullOrNil(this.PbF))
    {
      str = this.PbF;
      AppMethodBeat.o(51963);
      return str;
    }
    String str = getResources().getString(l.i.OKS);
    AppMethodBeat.o(51963);
    return str;
    str = getResources().getString(l.i.OLx);
    AppMethodBeat.o(51963);
    return str;
    str = getResources().getString(l.i.OKG);
    AppMethodBeat.o(51963);
    return str;
    str = getResources().getString(l.i.OKH);
    AppMethodBeat.o(51963);
    return str;
    str = getResources().getString(l.i.scan_translation_capture_tip);
    AppMethodBeat.o(51963);
    return str;
    if (!Util.isNullOrNil(this.PbE))
    {
      str = this.PbE;
      AppMethodBeat.o(51963);
      return str;
    }
    str = getResources().getString(l.i.OKY);
    AppMethodBeat.o(51963);
    return str;
  }
  
  private void ub(long paramLong)
  {
    AppMethodBeat.i(161046);
    long l1 = System.currentTimeMillis() - this.lastShotTime;
    if (l1 > ahws)
    {
      this.Pcf.removeMessages(0);
      this.Pcf.sendEmptyMessageDelayed(0, paramLong);
      AppMethodBeat.o(161046);
      return;
    }
    long l2 = ahws;
    this.Pcf.removeMessages(0);
    this.Pcf.sendEmptyMessageDelayed(0, l2 - l1 + paramLong);
    AppMethodBeat.o(161046);
  }
  
  public final void Ci(boolean paramBoolean)
  {
    boolean bool2 = true;
    AppMethodBeat.i(51969);
    Log.v("MicroMsg.ScanUIRectView", "alvinluo onShowNoDataView show: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    Object localObject;
    boolean bool1;
    if (this.OSP != null)
    {
      localObject = this.OSP;
      if (!paramBoolean)
      {
        bool1 = true;
        ((ScanSharedMaskView)localObject).Cv(bool1);
      }
    }
    else if (this.OSO != null)
    {
      localObject = this.OSO;
      if (paramBoolean) {
        break label90;
      }
    }
    label90:
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      ((BaseScanMaskView)localObject).CB(paramBoolean);
      AppMethodBeat.o(51969);
      return;
      bool1 = false;
      break;
    }
  }
  
  public final void Cj(final boolean paramBoolean)
  {
    AppMethodBeat.i(170027);
    am.ahT(this.mode);
    if (this.mode == 12) {
      am.aY(1, System.currentTimeMillis());
    }
    if (Looper.getMainLooper().getThread() == Thread.currentThread())
    {
      Ck(paramBoolean);
      AppMethodBeat.o(170027);
      return;
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(314513);
        ScanUIRectView.a(ScanUIRectView.this, paramBoolean);
        AppMethodBeat.o(314513);
      }
    });
    AppMethodBeat.o(170027);
  }
  
  public final void a(final b.b.a parama)
  {
    AppMethodBeat.i(161041);
    if (!this.OXT)
    {
      Log.w("MicroMsg.ScanUIRectView", "openCamera not enable and stop");
      AppMethodBeat.o(161041);
      return;
    }
    super.a(new b.b.a()
    {
      public final void gSY()
      {
        AppMethodBeat.i(170019);
        ScanUIRectView.h(ScanUIRectView.this);
        if (parama != null) {
          parama.gSY();
        }
        AppMethodBeat.o(170019);
      }
    });
    AppMethodBeat.o(161041);
  }
  
  public final void a(final Object paramObject, final com.tencent.mm.plugin.scanner.view.d paramd, boolean paramBoolean1, final boolean paramBoolean2)
  {
    AppMethodBeat.i(315134);
    if (paramBoolean1)
    {
      com.tencent.threadpool.h.ahAA.o(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(314512);
          ScanUIRectView.a(ScanUIRectView.this, paramObject, paramd, paramBoolean2);
          AppMethodBeat.o(314512);
        }
      }, 200L);
      AppMethodBeat.o(315134);
      return;
    }
    a(paramObject, paramd, paramBoolean2);
    AppMethodBeat.o(315134);
  }
  
  public final void auq()
  {
    AppMethodBeat.i(51956);
    super.auq();
    this.PbQ = true;
    this.PbR = false;
    AppMethodBeat.o(51956);
  }
  
  public final void b(boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    AppMethodBeat.i(51965);
    if (this.OSO != null) {
      this.OSO.b(paramBoolean, paramOnCancelListener);
    }
    AppMethodBeat.o(51965);
  }
  
  public final void dSg()
  {
    AppMethodBeat.i(51978);
    if ((this.OSO != null) && ((this.OSO instanceof ScanCodeMaskView))) {
      ((ScanCodeMaskView)this.OSO).dSg();
    }
    AppMethodBeat.o(51978);
  }
  
  public final void gSM()
  {
    AppMethodBeat.i(51948);
    this.ahwr = new com.tencent.mm.plugin.scanner.a.a();
    AppMethodBeat.o(51948);
  }
  
  public final boolean gSN()
  {
    AppMethodBeat.i(51950);
    if (this.ahwr != null)
    {
      boolean bool = ((com.tencent.scanlib.a.a)this.ahwr).gSN();
      AppMethodBeat.o(51950);
      return bool;
    }
    AppMethodBeat.o(51950);
    return false;
  }
  
  public final void gSO()
  {
    AppMethodBeat.i(51952);
    Log.i("MicroMsg.ScanUIRectView", "alvinluo stopCurrentSession %d", new Object[] { Long.valueOf(this.OOu) });
    com.tencent.qbar.h.jWV().tR(this.OOu);
    com.tencent.mm.plugin.scanner.d.a.gQu().tR(this.OOu);
    com.tencent.mm.plugin.scanner.d.b.gQw().gQy();
    this.OOu = 0L;
    AppMethodBeat.o(51952);
  }
  
  public final void gSS()
  {
    AppMethodBeat.i(51967);
    if ((this.OSP != null) && (!this.OXj.fhR)) {
      this.OSP.Cu(true);
    }
    if ((this.OSO != null) && (!this.OXj.fhR)) {
      this.OSO.PhG = true;
    }
    AppMethodBeat.o(51967);
  }
  
  public final void gST()
  {
    AppMethodBeat.i(51968);
    if ((this.OSP != null) && (this.OXj.fhR)) {
      this.OSP.Cu(false);
    }
    if ((this.OSO != null) && (this.OXj.fhR)) {
      this.OSO.PhG = false;
    }
    AppMethodBeat.o(51968);
  }
  
  public final void gSt()
  {
    AppMethodBeat.i(315147);
    onPause();
    auq();
    AppMethodBeat.o(315147);
  }
  
  public Rect getDecorRect()
  {
    AppMethodBeat.i(51976);
    Rect localRect = this.PbB.getDecorRect();
    AppMethodBeat.o(51976);
    return localRect;
  }
  
  public com.tencent.scanlib.a.f getScanCamera()
  {
    return this.ahwr;
  }
  
  int getScanCodeTabType()
  {
    if (this.OTn) {
      return com.tencent.qbar.c.ahqG;
    }
    return com.tencent.qbar.c.ahqD;
  }
  
  public BaseScanMaskView getScanMaskView()
  {
    return this.OSO;
  }
  
  public ScanProductMaskDecorView getScanProductMaskDecorView()
  {
    return this.OXk;
  }
  
  h.d getSessionInfo()
  {
    AppMethodBeat.i(315013);
    h.d locald = new h.d();
    locald.OTy = am.ahU(this.mode);
    locald.OTx = am.ahS(this.mode);
    AppMethodBeat.o(315013);
    return locald;
  }
  
  public ScanSharedMaskView getSharedMaskView()
  {
    return this.OSP;
  }
  
  public TextureView getTextrueView()
  {
    return this.cHz;
  }
  
  public final void init()
  {
    AppMethodBeat.i(51959);
    super.init();
    this.PbB = new ScanRectDecorView(getContext());
    if (this.OXS) {
      this.PbE = ac.gRc();
    }
    if (this.OTn) {
      this.PbF = ac.gRd();
    }
    Log.i("MicroMsg.ScanUIRectView", "initScanTips enableScanGoodsWording: %b, scanGoodsTips: %s, scanMergeTips: %s", new Object[] { Boolean.valueOf(this.OXS), this.PbE, this.PbF });
    addView(this.PbB, new FrameLayout.LayoutParams(-1, -1));
    this.OSP = new ScanSharedMaskView(getContext());
    this.OXj = this.OSP.getFlashSwitcherView();
    addView(this.OSP, new FrameLayout.LayoutParams(-1, -1));
    gSR();
    AppMethodBeat.o(51959);
  }
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    AppMethodBeat.i(51972);
    Log.i("MicroMsg.ScanUIRectView", "onAutoFocus %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.PbX = false;
      ua(0L);
    }
    Bb(ahwu);
    AppMethodBeat.o(51972);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(51949);
    super.onCreate();
    this.PbL = ((int)(com.tencent.mm.cd.a.ms(getContext()) / 4.5F));
    if (t.aiG(this.mode)) {
      com.tencent.qbar.h.jWV().init(getContext());
    }
    com.tencent.qbar.h.jWV().ahrw = new au();
    setOnTouchListener(new ScanUIRectView.8(this));
    this.Pce.alive();
    if (this.PbT != null) {
      this.PbT.AxK = System.currentTimeMillis();
    }
    AppMethodBeat.o(51949);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(51955);
    super.onDestroy();
    Log.d("MicroMsg.ScanUIRectView", "alvinluo releaseView");
    if (this.OSO != null) {
      this.OSO.release();
    }
    if (this.OSP != null)
    {
      localObject1 = this.OSP;
      Log.d("MicroMsg.ScanSharedMaskView", "alvinluo release hashCode: %d", new Object[] { Integer.valueOf(((ScanSharedMaskView)localObject1).hashCode()) });
      ((ScanSharedMaskView)localObject1).gTz();
      ((ScanSharedMaskView)localObject1).gTA();
    }
    if (this.OXk != null) {
      ScanProductMaskDecorView.onDestroy();
    }
    com.tencent.qbar.h.jWV().release();
    Object localObject1 = com.tencent.mm.plugin.scanner.d.a.gQu();
    Log.i("MicroMsg.AiScanImageDecodeQueueNew", "alvinluo release");
    ac.a(new a.3((com.tencent.mm.plugin.scanner.d.a)localObject1));
    localObject1 = com.tencent.mm.plugin.scanner.d.b.gQw();
    Log.i("MicroMsg.ReIdAiScanImageDecodeQueue", "release");
    com.tencent.mm.plugin.scanner.d.b.a(new b.3((com.tencent.mm.plugin.scanner.d.b)localObject1));
    ((com.tencent.mm.plugin.scanner.d.b)localObject1).OPe = false;
    ((com.tencent.mm.plugin.scanner.d.b)localObject1).OPh = 0;
    ((com.tencent.mm.plugin.scanner.d.b)localObject1).OPc = null;
    Object localObject2 = com.tencent.mm.plugin.scanner.model.f.ORq;
    localObject2 = ((com.tencent.mm.plugin.scanner.d.b)localObject1).OPd;
    if (localObject2 != null) {
      com.tencent.mm.plugin.scanner.model.f.a(((b.b)localObject2).OPw, ((b.b)localObject2).OPx, ((b.b)localObject2).OPy, ((b.b)localObject2).OPz, ((b.b)localObject2).OPB, ((b.b)localObject2).OPC, ((b.b)localObject2).OPD, ((b.b)localObject2).OPE, ((b.b)localObject2).OPF, ((b.b)localObject2).OPG, ((b.b)localObject2).OPH, ((b.b)localObject2).OPI, ((b.b)localObject2).OPJ, ((b.b)localObject2).OPA);
    }
    ((com.tencent.mm.plugin.scanner.d.b)localObject1).OPd = null;
    ((com.tencent.mm.plugin.scanner.d.b)localObject1).gQA();
    ((com.tencent.mm.plugin.scanner.d.b)localObject1).sensorManager = null;
    ((com.tencent.mm.plugin.scanner.d.b)localObject1).OPi = null;
    this.Pce.dead();
    removeCallbacks(this.PbZ);
    this.PbZ = null;
    if (this.PbT != null)
    {
      localObject1 = this.PbT;
      ((j)localObject1).Pjd = System.currentTimeMillis();
      ((j)localObject1).hTS = (((j)localObject1).Pjd - ((j)localObject1).AxK);
      Log.i("MicroMsg.ScanRetryManager", "alvinluo exitScanUI stayTime: %d, isUpdated: %b, onPreviewFrameCalled: %b, isRetry: %b", new Object[] { Long.valueOf(((j)localObject1).hTS), Boolean.valueOf(((j)localObject1).PiY), Boolean.valueOf(((j)localObject1).PbY), Boolean.valueOf(((j)localObject1).vBn) });
      am.a(((j)localObject1).PiZ, ((j)localObject1).vBn, ((j)localObject1).PbY, ((j)localObject1).hTS);
      am.n(((j)localObject1).PiZ, ((j)localObject1).vBn, ((j)localObject1).Pje);
      if (!((j)localObject1).PiY) {
        break label428;
      }
      ((j)localObject1).uc(((j)localObject1).mTimeout);
    }
    for (;;)
    {
      if ((t.aiG(this.mode)) && (!this.PbO)) {
        am.gRr();
      }
      AppMethodBeat.o(51955);
      return;
      label428:
      if (!((j)localObject1).PiY)
      {
        ((j)localObject1).mTimeout = ((j)localObject1).PiV;
        ((j)localObject1).uc(((j)localObject1).mTimeout);
        Log.i("MicroMsg.ScanRetryManager", "alvinluo checkAndResetTimeout timeout not updated and reset to %d", new Object[] { Long.valueOf(((j)localObject1).mTimeout) });
      }
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(51953);
    super.onPause();
    Log.i("MicroMsg.ScanUIRectView", "alvinluo onPause");
    gSW();
    if (this.OSO != null) {
      this.OSO.onPause();
    }
    gSO();
    if (this.owr != null) {
      this.owr.a(this.lsF);
    }
    AppMethodBeat.o(51953);
  }
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    AppMethodBeat.i(51973);
    super.onPreviewFrame(paramArrayOfByte, paramCamera);
    this.PbY = true;
    boolean bool;
    if (paramArrayOfByte == null)
    {
      bool = true;
      Log.d("MicroMsg.ScanUIRectView", "onPreviewFrame null data: %b, isPreviewPaused: %b, canResumePreview: %b", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(this.PbQ), Boolean.valueOf(this.PbR) });
      if (this.PbU == 2) {
        if (this.PbT != null)
        {
          paramCamera = this.PbT;
          int i = this.PbU;
          Log.i("MicroMsg.ScanRetryManager", "alvinluo cancelRetryType: %d", new Object[] { Integer.valueOf(i) });
          switch (i)
          {
          }
        }
      }
    }
    for (;;)
    {
      this.vBn = false;
      removeCallbacks(this.PbZ);
      if (this.PbT != null)
      {
        paramCamera = this.PbT;
        long l1 = System.currentTimeMillis();
        long l2 = this.PbV;
        if (!paramCamera.PiY)
        {
          paramCamera.PiY = true;
          l1 = ((float)(l1 - l2) * paramCamera.PiX);
          paramCamera.mTimeout = Math.max(paramCamera.PiW, Math.min(paramCamera.PiV, l1));
        }
        this.PbT.PbY = true;
      }
      if ((!this.PbQ) || (!this.PbR)) {
        break label288;
      }
      this.PbQ = false;
      this.PbR = false;
      Cj(false);
      ua(100L);
      AppMethodBeat.o(51973);
      return;
      bool = false;
      break;
      paramCamera.Pja = false;
      continue;
      paramCamera.Pjb = false;
    }
    label288:
    if (this.PbS)
    {
      Log.w("MicroMsg.ScanUIRectView", "alvinluo onPreviewFrame ignorePreviewFrame");
      AppMethodBeat.o(51973);
      return;
    }
    if (paramArrayOfByte == null)
    {
      Log.w("MicroMsg.ScanUIRectView", "alvinluo onPreviewFrame data is null");
      ua(0L);
      am.gRq();
      AppMethodBeat.o(51973);
      return;
    }
    Log.i("MicroMsg.ScanUIRectView", "onPreviewFrame");
    co(paramArrayOfByte);
    AppMethodBeat.o(51973);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(51951);
    super.onResume();
    if (!this.ahwr.isOpen())
    {
      Log.i("MicroMsg.ScanUIRectView", "alvinluo onResume openCamera");
      a(null);
      Log.i("MicroMsg.ScanUIRectView", "onResume %s", new Object[] { Util.getStack() });
      this.OOu = System.currentTimeMillis();
      if (!t.aiG(this.mode)) {
        break label258;
      }
      com.tencent.qbar.h.jWV().a(this.OOu, getScanCodeTabType(), getSessionInfo(), this.Pcc);
      com.tencent.mm.plugin.scanner.d.b.gQw().gQx();
    }
    for (;;)
    {
      this.PbM = false;
      if (this.OSO != null) {
        this.OSO.onResume();
      }
      MMHandlerThread.postToMainThreadDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(51923);
          if ((ScanUIRectView.f(ScanUIRectView.this) != null) && (ScanUIRectView.f(ScanUIRectView.this).OMu))
          {
            AppMethodBeat.o(51923);
            return;
          }
          ScanCameraLightDetector.Pio.start(((com.tencent.mm.plugin.scanner.a.a)ScanUIRectView.g(ScanUIRectView.this)).jXJ());
          AppMethodBeat.o(51923);
        }
      }, 300L);
      this.PbR = true;
      AppMethodBeat.o(51951);
      return;
      if (!this.ahwr.boa())
      {
        Log.i("MicroMsg.ScanUIRectView", "alvinluo onResume startPreview");
        ((com.tencent.mm.plugin.scanner.a.a)this.ahwr).gQb();
        a(new b.d.a()
        {
          public final void gSX()
          {
            AppMethodBeat.i(170017);
            ScanUIRectView.this.ua(0L);
            AppMethodBeat.o(170017);
          }
        });
        Log.i("MicroMsg.ScanUIRectView", "focus mode %s", new Object[] { this.ahwr.jXJ() });
        break;
      }
      Log.i("MicroMsg.ScanUIRectView", "alvinluo onResume camera is previewing");
      Log.i("MicroMsg.ScanUIRectView", "focus mode %s", new Object[] { this.ahwr.jXJ() });
      ua(0L);
      break;
      label258:
      if (this.mode == 12)
      {
        Log.i("MicroMsg.ScanUIRectView", "alvinluo onResume currentNetworkAvailable: %b", new Object[] { Boolean.valueOf(this.OXx) });
        if (this.OXx)
        {
          com.tencent.mm.plugin.scanner.d.a locala = com.tencent.mm.plugin.scanner.d.a.gQu();
          long l = this.OOu;
          com.tencent.mm.plugin.scanner.d.a.a locala1 = this.Pcd;
          synchronized (locala.GXz)
          {
            locala.OOu = l;
            locala.OOS = locala1;
            synchronized (locala.OOR)
            {
              if (locala.lYs) {
                ac.reset();
              }
            }
          }
        }
        com.tencent.mm.plugin.scanner.d.a.gQu().tR(this.OOu);
      }
    }
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(51954);
    super.onStop();
    bty();
    ScanCameraLightDetector.Pio.stop();
    AppMethodBeat.o(51954);
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(162395);
    super.onSurfaceTextureAvailable(paramSurfaceTexture, paramInt1, paramInt2);
    if ((this.zTI == null) || (paramInt1 != this.zTI.x) || (paramInt2 != this.zTI.y))
    {
      if (this.zTI == null) {
        this.zTI = new Point(paramInt1, paramInt2);
      }
      if (t.aiG(this.mode)) {
        gSV();
      }
    }
    AppMethodBeat.o(162395);
  }
  
  public final void refreshView()
  {
    AppMethodBeat.i(51961);
    this.PbB.setVisibility(8);
    gSR();
    gSU();
    gSQ();
    AppMethodBeat.o(51961);
  }
  
  public void setActivity(Activity paramActivity)
  {
    this.activity = paramActivity;
  }
  
  public void setBlackInterval(int paramInt)
  {
    AppMethodBeat.i(170024);
    com.tencent.qbar.h localh = com.tencent.qbar.h.jWV();
    synchronized (localh.rQG)
    {
      if (localh.rQG.hasInited()) {
        localh.rQG.setBlackInterval(paramInt);
      }
      AppMethodBeat.o(170024);
      return;
    }
  }
  
  public void setBottomExtraHeight(int paramInt)
  {
    this.PbK = paramInt;
  }
  
  public void setDecodeSuccessFrameData(ScanDecodeFrameData paramScanDecodeFrameData)
  {
    AppMethodBeat.i(170026);
    if (this.OSO != null) {
      this.OSO.setDecodeSuccessFrameData(paramScanDecodeFrameData);
    }
    AppMethodBeat.o(170026);
  }
  
  public void setDecorRect(Rect paramRect)
  {
    AppMethodBeat.i(51977);
    this.PbB.setDecorRect(paramRect);
    AppMethodBeat.o(51977);
  }
  
  public void setDisableScanProductInMergeMode(boolean paramBoolean)
  {
    this.OXP = paramBoolean;
  }
  
  public void setEnableOpenCamera(boolean paramBoolean)
  {
    AppMethodBeat.i(315105);
    Log.i("MicroMsg.ScanUIRectView", "setEnableOpenCamera: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.OXT = paramBoolean;
    AppMethodBeat.o(315105);
  }
  
  public void setEnableScanCodeProductMerge(boolean paramBoolean)
  {
    this.OTn = paramBoolean;
  }
  
  public void setEnableScanGoodsDynamicWording(boolean paramBoolean)
  {
    this.OXS = paramBoolean;
  }
  
  public void setEnableScrollSwitchTab(boolean paramBoolean)
  {
    AppMethodBeat.i(51958);
    Log.i("MicroMsg.ScanUIRectView", "alvinluo setEnableScrollSwitchTab: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.PbI = paramBoolean;
    AppMethodBeat.o(51958);
  }
  
  public void setFlashStatus(boolean paramBoolean)
  {
    AppMethodBeat.i(51966);
    if (this.OSP != null) {
      this.OSP.setFlashStatus(paramBoolean);
    }
    AppMethodBeat.o(51966);
  }
  
  public void setIgnorePreviewFrame(boolean paramBoolean)
  {
    AppMethodBeat.i(315109);
    Log.d("MicroMsg.ScanUIRectView", "alvinluo setIgnorePreviewFrame %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.PbS = paramBoolean;
    AppMethodBeat.o(315109);
  }
  
  public void setMyQrCodeVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(314953);
    if ((this.OSO instanceof ScanCodeMaskView)) {
      ((ScanCodeMaskView)this.OSO).setMyQrCodeButtonVisible(paramBoolean);
    }
    AppMethodBeat.o(314953);
  }
  
  public void setNetworkAvailable(boolean paramBoolean)
  {
    this.OXx = paramBoolean;
  }
  
  public void setScanCallback(ScanUIRectView.a parama)
  {
    this.PbD = parama;
  }
  
  public void setScanCodeReaders(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(51979);
    com.tencent.qbar.h.jWV().T(paramArrayOfInt);
    AppMethodBeat.o(51979);
  }
  
  public void setScanMode(int paramInt)
  {
    this.mode = paramInt;
  }
  
  public void setScanProductCallback(ScanProductMaskDecorView.e parame)
  {
    this.OYf = parame;
  }
  
  public void setScanProductOnItemClickListener(ScanProductMaskDecorView.f paramf)
  {
    this.OYd = paramf;
  }
  
  public void setScanRequest(BaseScanRequest paramBaseScanRequest)
  {
    this.OXF = paramBaseScanRequest;
  }
  
  public void setScanSource(int paramInt)
  {
    AppMethodBeat.i(51964);
    if (this.OSO != null) {
      this.OSO.setScanSource(paramInt);
    }
    AppMethodBeat.o(51964);
  }
  
  public void setScrollTabController(com.tencent.mm.plugin.scanner.ui.widget.b paramb)
  {
    this.OXp = paramb;
  }
  
  public void setShowScanTips(boolean paramBoolean)
  {
    this.OXw = paramBoolean;
  }
  
  public void setSuccessMarkClickListener(an paraman)
  {
    AppMethodBeat.i(170025);
    if ((this.OSO instanceof ScanCodeMaskView)) {
      ((ScanCodeMaskView)this.OSO).setSuccessMarkClickListener(paraman);
    }
    AppMethodBeat.o(170025);
  }
  
  public final void ua(long paramLong)
  {
    AppMethodBeat.i(51957);
    this.PbO = true;
    Log.d("MicroMsg.ScanUIRectView", "alvinluo takeOneShot timeout: %d, isRetry: %b, onPreviewFrameCalled: %b, canReportOnPreviewFrame: %b, hasReport: %b", new Object[] { Long.valueOf(this.mTimeout), Boolean.valueOf(this.vBn), Boolean.valueOf(this.PbY), Boolean.valueOf(this.PbX), Boolean.valueOf(this.PbW) });
    if (!this.vBn)
    {
      super.ua(paramLong);
      this.PbV = System.currentTimeMillis();
      if ((!this.PbY) && (this.PbX) && (t.aiG(this.mode)))
      {
        removeCallbacks(this.PbZ);
        postDelayed(this.PbZ, this.mTimeout);
        AppMethodBeat.o(51957);
      }
    }
    else if ((this.PbT != null) && (this.PbT.aiF(this.PbU)))
    {
      if (this.PbU == 1)
      {
        super.ua(paramLong);
        this.PbV = System.currentTimeMillis();
        AppMethodBeat.o(51957);
        return;
      }
      if (this.PbU == 2) {
        ub(paramLong);
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
      ScanUIRectView.S(ScanUIRectView.this);
      AppMethodBeat.o(161040);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ScanUIRectView
 * JD-Core Version:    0.7.0.1
 */
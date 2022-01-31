package com.tencent.mm.plugin.scanner.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Message;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.TextureView.SurfaceTextureListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R.e;
import com.tencent.mm.R.g;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.compatible.e.d;
import com.tencent.mm.h.a.lx;
import com.tencent.mm.h.a.lx.b;
import com.tencent.mm.h.a.lz;
import com.tencent.mm.h.a.ow;
import com.tencent.mm.h.a.oy;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.scanner.util.ScanCameraLightDetector;
import com.tencent.mm.plugin.scanner.util.ScanCameraLightDetector.1;
import com.tencent.mm.plugin.scanner.util.ScanCameraLightDetector.a;
import com.tencent.mm.plugin.scanner.util.e.a;
import com.tencent.mm.plugin.scanner.util.r;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMTextureView;
import com.tencent.mm.ui.s;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@com.tencent.mm.kernel.j
@com.tencent.mm.ui.base.a(3)
public class BaseScanUI
  extends MMActivity
  implements Camera.AutoFocusCallback, Camera.PreviewCallback, TextureView.SurfaceTextureListener, i.b
{
  private int bID = 0;
  private final Object bjn = new Object();
  private boolean fht = true;
  private int[] fmY = new int[8];
  private volatile boolean jTM = false;
  private boolean mBI = false;
  private int nIA;
  private boolean nIB = true;
  private Rect nIC = new Rect();
  private TextView nID;
  private View nIE;
  private boolean nIF = false;
  private boolean nIG = true;
  private boolean nIH = false;
  private boolean nII = false;
  private com.tencent.mm.plugin.scanner.util.e nIJ = null;
  private TranslateAnimation nIK;
  private ImageView nIL;
  private i nIM;
  private int nIN = 0;
  private int nIO = 0;
  private boolean nIP = false;
  private long nIQ;
  private long nIR;
  private Set<Integer> nIS = new HashSet();
  private int nIT;
  private ValueAnimator nIU;
  private com.tencent.mm.network.n nIV = new BaseScanUI.1(this);
  private com.tencent.mm.sdk.b.c<lz> nIW = new com.tencent.mm.sdk.b.c() {};
  protected ah nIX = new BaseScanUI.4(this);
  private final int nIY = 2600;
  protected ah nIZ = new BaseScanUI.9(this);
  private final long nIh = 150L;
  private final int nIi = 2;
  private MMTextureView nIj;
  private SurfaceTexture nIk;
  private LinearLayout nIl;
  private TextView nIm;
  private FrameLayout nIn;
  private com.tencent.mm.plugin.scanner.util.h nIo;
  private Point nIp;
  private SelectScanModePanel nIq;
  private ScanMaskView nIr = null;
  private ScannerFlashSwitcher nIs;
  private boolean nIt = false;
  private boolean nIu = false;
  private boolean nIv = true;
  private i.a nIw;
  private int nIx;
  private int nIy;
  private int nIz;
  protected ah nJa = new ah()
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      if ((!BaseScanUI.f(BaseScanUI.this)) && (BaseScanUI.g(BaseScanUI.this) != null) && (BaseScanUI.r(BaseScanUI.this))) {
        BaseScanUI.g(BaseScanUI.this).a(BaseScanUI.this);
      }
    }
  };
  private com.tencent.mm.sdk.b.c nJb = new com.tencent.mm.sdk.b.c() {};
  protected ah nJc = new BaseScanUI.13(this);
  protected final int nJd = 0;
  protected final int nJe = 1;
  protected final int nJf = 2;
  private PowerManager.WakeLock wakeLock = null;
  
  private void aPC()
  {
    com.tencent.mm.sdk.f.e.post(new BaseScanUI.6(this), "BaseScanUI_closeCamera");
  }
  
  private void aSq()
  {
    oy localoy = new oy();
    localoy.bYB.bcw = 1;
    com.tencent.mm.sdk.b.a.udP.m(localoy);
    setResult(0);
    finish();
  }
  
  private void buJ()
  {
    boolean bool2 = true;
    if (!com.tencent.mm.compatible.f.b.zB()) {
      com.tencent.mm.ui.base.h.a(this, getString(R.l.app_special_no_open_camera_permission), getString(R.l.app_need_camera_title), getString(R.l.app_need_show_settings_button), true, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          com.tencent.mm.compatible.f.b.bf(BaseScanUI.this);
          BaseScanUI.this.finish();
        }
      });
    }
    for (;;)
    {
      return;
      if ((!this.nIG) || (this.nIv))
      {
        this.nIu = false;
        e(false, 0L);
        label69:
        this.nII = false;
      }
      synchronized (this.bjn)
      {
        y.d("MicroMsg.scanner.BaseScanUI", "onResume open Camera");
        int i = this.nIN;
        boolean bool1 = bool2;
        if (7 != this.nIN)
        {
          bool1 = bool2;
          if (9 != this.nIN)
          {
            bool1 = bool2;
            if (10 != this.nIN)
            {
              if (11 != this.nIN) {
                break label313;
              }
              bool1 = bool2;
            }
          }
        }
        this.nIo = new com.tencent.mm.plugin.scanner.util.h(this, i, bool1);
        bxz();
        if ((this.nIN != 3) || (!r.byE()))
        {
          if (this.nIM.bxp() != null) {
            this.nIM.bxp().byg();
          }
          this.nIM.onResume();
        }
        if (this.wakeLock == null)
        {
          this.wakeLock = ((PowerManager)getSystemService("power")).newWakeLock(10, "Scan Lock");
          this.wakeLock.acquire();
        }
        sendBroadcast(new Intent("com.tencent.mm.ui.ACTION_ACTIVE").putExtra("classname", getClass().getName()), "com.tencent.mm.permission.MM_MESSAGE");
        if (this.nIG) {
          com.tencent.mm.model.au.a(this.nIV);
        }
        if (this.nIJ == null) {
          continue;
        }
        this.nIJ.onResume();
        return;
        this.nIu = true;
        bxx();
        break label69;
        label313:
        bool1 = false;
      }
    }
  }
  
  private void bxA()
  {
    if (this.nIt) {
      return;
    }
    this.nIt = true;
    ix(true);
    Object localObject = new lx();
    ((lx)localObject).bVc.type = 2;
    com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject);
    if (((lx)localObject).bVd.bVb)
    {
      y.i("MicroMsg.scanner.BaseScanUI", "Permission dialog showed");
      this.nIu = true;
      aPC();
      aSq();
      overridePendingTransition(0, 0);
      return;
    }
    localObject = com.tencent.mm.ui.base.h.a(this, getString(R.l.scan_open_camera_fail), getString(R.l.app_tip), new BaseScanUI.7(this));
    if (localObject == null)
    {
      y.d("MicroMsg.scanner.BaseScanUI", "comfirmDialog == null");
      return;
    }
    ((com.tencent.mm.ui.widget.a.c)localObject).setCancelable(false);
    ((com.tencent.mm.ui.widget.a.c)localObject).setCanceledOnTouchOutside(false);
    ((com.tencent.mm.ui.widget.a.c)localObject).show();
  }
  
  private void bxC()
  {
    Rect localRect = new Rect();
    getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
    this.nIp = new Point(localRect.width(), localRect.height());
    y.d("MicroMsg.scanner.BaseScanUI", "update visible rect:%s", new Object[] { this.nIp });
  }
  
  private void bxw()
  {
    if (this.nIM == null) {
      return;
    }
    this.nIM.onPause();
    bxB();
  }
  
  private void bxz()
  {
    ai.l(new BaseScanUI.5(this), 25L);
  }
  
  private void e(boolean paramBoolean, long paramLong)
  {
    if ((this.nIz < 0) || (this.nIA <= 0) || (this.nIM == null) || (!this.nIM.bxu()))
    {
      bxx();
      return;
    }
    FrameLayout.LayoutParams localLayoutParams;
    if (paramBoolean)
    {
      localLayoutParams = (FrameLayout.LayoutParams)this.nIL.getLayoutParams();
      if (!this.nIB) {
        break label152;
      }
      localLayoutParams.width = this.nIx;
      localLayoutParams.gravity = 1;
      this.nIL.setLayoutParams(localLayoutParams);
      this.nIL.invalidate();
      this.nIL.setVisibility(0);
      if (!this.nIB) {
        break label183;
      }
    }
    label152:
    label183:
    for (this.nIK = new TranslateAnimation(0.0F, 0.0F, this.nIz, this.nIA);; this.nIK = new TranslateAnimation(this.nIz, this.nIA, 0.0F, 0.0F))
    {
      this.nIX.removeMessages(1);
      if (paramLong > 0L) {
        break label209;
      }
      this.nIX.sendEmptyMessage(1);
      return;
      localLayoutParams.height = this.nIy;
      localLayoutParams.gravity = 48;
      localLayoutParams.topMargin = this.nIC.top;
      break;
    }
    label209:
    bxx();
    this.nIX.sendEmptyMessageDelayed(1, paramLong);
  }
  
  private void startPreview()
  {
    try
    {
      if ((this.jTM) || (this.nIo == null))
      {
        y.w("MicroMsg.scanner.BaseScanUI", "scanCamera == null, in startPreview");
        return;
      }
      if (!this.nIo.isOpen())
      {
        y.w("MicroMsg.scanner.BaseScanUI", "camera not open");
        return;
      }
    }
    catch (Exception localException)
    {
      y.w("MicroMsg.scanner.BaseScanUI", "Exception in scanCamera.startPreview(), [%s]", new Object[] { localException.toString() });
      y.printErrStackTrace("MicroMsg.scanner.BaseScanUI", localException, "", new Object[0]);
      bxA();
      return;
    }
    if (this.nIk == null)
    {
      y.w("MicroMsg.scanner.BaseScanUI", "preview surface in null in startPreview");
      return;
    }
    if (this.nIo.jOC)
    {
      y.w("MicroMsg.scanner.BaseScanUI", "camera is previewing");
      return;
    }
    y.d("MicroMsg.scanner.BaseScanUI", "camera startPreview.");
    for (;;)
    {
      synchronized (this.bjn)
      {
        this.nIo.j(this.nIk);
        y.d("MicroMsg.scanner.BaseScanUI", "camera startPreview. done");
        this.fmY[5] = ((int)(System.currentTimeMillis() - this.nIQ));
        if ((!bk.bl(this.nIo.getFocusMode())) && (this.nIo.getFocusMode().equals("continuous-video")))
        {
          this.nIo.cancelAutoFocus();
          fC(0L);
          return;
        }
      }
      if (com.tencent.mm.compatible.e.q.dyd.dwx > 0L) {
        fC((int)((float)com.tencent.mm.compatible.e.q.dyd.dwx * ae.eTz));
      }
      fD(0L);
    }
  }
  
  private boolean yN()
  {
    return (7 == this.nIN) || (9 == this.nIN) || (10 == this.nIN) || (11 == this.nIN) || (d.yN());
  }
  
  public final void L(int paramInt, long paramLong)
  {
    this.nIZ.removeMessages(0);
    this.nIZ.sendEmptyMessageDelayed(paramInt, paramLong);
    this.nIq.setSelectedMode(paramInt);
  }
  
  public final void V(int paramInt1, int paramInt2, int paramInt3)
  {
    for (;;)
    {
      synchronized (this.bjn)
      {
        if ((!this.jTM) && (this.nIo != null) && (this.nIo.jOC))
        {
          y.i("MicroMsg.scanner.BaseScanUI", "zoom camera,action:%d,type:%d,scale:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
          int i = this.nIo.byt();
          if ((this.nIN != 1) && (this.nIN != 8) && (this.nIN != 4)) {
            break label226;
          }
          if ((paramInt2 == 1) && (!((p)this.nIM).bxU()))
          {
            y.d("MicroMsg.scanner.BaseScanUI", "auto zoom is disable");
            return;
          }
          if (paramInt1 != 6) {
            break label215;
          }
          this.nIo.wW(paramInt3);
          if (paramInt2 == 2) {
            ((p)this.nIM).bxT();
          }
          if (this.nIo.byt() != i)
          {
            com.tencent.mm.plugin.scanner.a.m localm = com.tencent.mm.plugin.scanner.a.m.nHb;
            this.nIo.byt();
            if (paramInt2 != 1) {
              break label254;
            }
            localm.nHo |= 0x1;
          }
        }
        return;
      }
      label215:
      this.nIo.wX(paramInt1);
      continue;
      label226:
      if (paramInt1 == 6)
      {
        this.nIo.wW(paramInt3);
      }
      else
      {
        this.nIo.wX(paramInt1);
        continue;
        label254:
        if (paramInt2 == 2) {
          localObject2.nHo |= 0x2;
        }
      }
    }
  }
  
  public final void a(i.a parama)
  {
    this.nIw = parama;
  }
  
  public final void a(String paramString, int paramInt1, int paramInt2, int paramInt3, e.a parama)
  {
    y.i("MicroMsg.scanner.BaseScanUI", "dealQBarString, qbarString: %s, codeType: %s, codeVersion: %s", new Object[] { paramString, Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    if (this.nIJ != null) {
      this.nIJ.bym();
    }
    Bundle localBundle = getIntent().getBundleExtra("_stat_obj");
    this.nIJ = new com.tencent.mm.plugin.scanner.util.e();
    this.nIJ.a(this, paramString, paramInt1, paramInt2, paramInt3, parama, localBundle);
    if ((this.nIN == 1) || (this.nIN == 8) || (this.nIN == 4))
    {
      paramInt1 = com.tencent.mm.plugin.scanner.a.m.nHb.nyR;
      paramInt1 = com.tencent.mm.plugin.scanner.a.m.nGY;
    }
  }
  
  public final void b(int paramInt, View.OnClickListener paramOnClickListener)
  {
    if (this.nIl != null) {
      if (!getIntent().getBooleanExtra("key_is_hide_right_btn", false)) {
        if (paramOnClickListener != null)
        {
          this.nIl.setVisibility(paramInt);
          this.nIl.setOnClickListener(paramOnClickListener);
          this.nIm.setBackgroundDrawable(null);
          this.nIm.setText(getString(R.l.self_qrcode_gallery_land));
        }
      }
    }
    while (getIntent().getBooleanExtra("key_is_hide_right_btn", false))
    {
      return;
      this.nIl.setVisibility(8);
      return;
    }
    if (paramOnClickListener != null)
    {
      addIconOptionMenu(0, R.k.actionbar_icon_dark_more, new BaseScanUI.14(this, paramOnClickListener));
      return;
    }
    removeOptionMenu(0);
  }
  
  public final void bxB()
  {
    for (;;)
    {
      try
      {
        bxC();
        if (this.nIM == null)
        {
          y.d("MicroMsg.scanner.BaseScanUI", "initBodyByScanMode null scanMode");
          return;
        }
        this.nIM.g(this.nIp);
        Object localObject1 = this.nIM.D(true, yN());
        Object localObject2 = new FrameLayout.LayoutParams(((Rect)localObject1).width(), ((Rect)localObject1).height(), 3);
        ((FrameLayout.LayoutParams)localObject2).leftMargin = ((Rect)localObject1).left;
        ((FrameLayout.LayoutParams)localObject2).topMargin = ((Rect)localObject1).top;
        this.nIx = ((Rect)localObject1).width();
        this.nIy = ((Rect)localObject1).height();
        y.d("MicroMsg.scanner.BaseScanUI", "mask : leftMargin=[%s], topMargin=[%s], width=[%s], height=[%s]", new Object[] { Integer.valueOf(((FrameLayout.LayoutParams)localObject2).leftMargin), Integer.valueOf(((FrameLayout.LayoutParams)localObject2).topMargin), Integer.valueOf(this.nIx), Integer.valueOf(this.nIy) });
        localObject1 = new Rect(((FrameLayout.LayoutParams)localObject2).leftMargin, ((FrameLayout.LayoutParams)localObject2).topMargin, ((FrameLayout.LayoutParams)localObject2).leftMargin + this.nIx, ((FrameLayout.LayoutParams)localObject2).topMargin + this.nIy);
        if (this.nIp.x - ((Rect)localObject1).right < ((Rect)localObject1).left)
        {
          y.w("MicroMsg.scanner.BaseScanUI", "this is a special device");
          if (this.nIp.x - ((Rect)localObject1).left > ((Rect)localObject1).left) {
            ((Rect)localObject1).right = (this.nIp.x - ((Rect)localObject1).left);
          }
        }
        if (this.nIr != null)
        {
          localObject2 = this.nIr.getMaskRect();
          this.nIr.bxP();
          this.nIr = new ScanMaskView(this, (Rect)localObject2);
          localObject2 = new FrameLayout.LayoutParams(-1, -1);
          this.nIr.setLayoutParams((ViewGroup.LayoutParams)localObject2);
          if ((this.nIN == 3) && (r.byE())) {
            this.nIr.setMaskAnimaListener(new BaseScanUI.8(this));
          }
          this.nIn.removeAllViews();
          View.inflate(this, this.nIM.bxq(), this.nIn);
          this.nIM.cK(this.nIn.getChildAt(0));
          this.nIM.bxs();
          i locali = this.nIM;
          FrameLayout localFrameLayout = this.nIn;
          locali.jEK = new GestureDetector(new i.2(locali));
          localFrameLayout.setOnTouchListener(new i.3(locali));
          this.nIn.addView(this.nIr, 0, (ViewGroup.LayoutParams)localObject2);
          localObject2 = this.nIr;
          if ((((Rect)localObject1).left != ((ScanMaskView)localObject2).nLe.left) || (((Rect)localObject1).right != ((ScanMaskView)localObject2).nLe.right) || (((Rect)localObject1).top != ((ScanMaskView)localObject2).nLe.top) || (((Rect)localObject1).bottom != ((ScanMaskView)localObject2).nLe.bottom))
          {
            ((ScanMaskView)localObject2).nLl = (((Rect)localObject1).left - ((ScanMaskView)localObject2).nLe.left);
            ((ScanMaskView)localObject2).nLm = (((Rect)localObject1).right - ((ScanMaskView)localObject2).nLe.right);
            ((ScanMaskView)localObject2).nLn = (((Rect)localObject1).top - ((ScanMaskView)localObject2).nLe.top);
            ((ScanMaskView)localObject2).nLo = (((Rect)localObject1).bottom - ((ScanMaskView)localObject2).nLe.bottom);
            ((ScanMaskView)localObject2).nLj = new Rect(((ScanMaskView)localObject2).nLe.left, ((ScanMaskView)localObject2).nLe.top, ((ScanMaskView)localObject2).nLe.right, ((ScanMaskView)localObject2).nLe.bottom);
            ((ScanMaskView)localObject2).nLi = true;
            ((ScanMaskView)localObject2).nLq = new ValueAnimator();
            ((ScanMaskView)localObject2).nLq.setFloatValues(new float[] { 0.0F, 1.0F });
            ((ScanMaskView)localObject2).nLq.setDuration(((ScanMaskView)localObject2).nLk);
            ((ScanMaskView)localObject2).nLq.addUpdateListener(new ScanMaskView.1((ScanMaskView)localObject2));
            ((ScanMaskView)localObject2).nLq.start();
            ((ScanMaskView)localObject2).nLq.addListener(new ScanMaskView.2((ScanMaskView)localObject2));
          }
          this.nIM.j((Rect)localObject1);
          this.nIr.setBackgroundColor(0);
          y.d("MicroMsg.scanner.BaseScanUI", "newRect = %s", new Object[] { localObject1 });
          if (!this.nIB) {
            break label1029;
          }
          this.nIz = ((Rect)localObject1).top;
          this.nIA = (((Rect)localObject1).bottom - BackwardSupportUtil.b.b(this, 8.0F));
          this.nIC = ((Rect)localObject1);
          if (this.nIs != null)
          {
            localObject1 = (FrameLayout.LayoutParams)this.nIs.getLayoutParams();
            if (this.nIN != 3) {
              break label1061;
            }
            ((FrameLayout.LayoutParams)localObject1).topMargin = (this.nIq.getTop() - com.tencent.mm.cb.a.fromDPToPix(this, 70));
            y.l("MicroMsg.scanner.BaseScanUI", "initFlashSwitcher, scanMaskRect: %s, scanLineStart: %s, scanLineEnd: %s", new Object[] { this.nIC, Integer.valueOf(this.nIz), Integer.valueOf(this.nIA) });
            this.nIs.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            this.nIs.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                if (BaseScanUI.g(BaseScanUI.this) != null)
                {
                  com.tencent.mm.plugin.scanner.a.m.nHb.wP(2);
                  if (BaseScanUI.g(BaseScanUI.this).mgM) {
                    break label197;
                  }
                  paramAnonymousView = BaseScanUI.g(BaseScanUI.this);
                  y.i("MicroMsg.scanner.ScanCamera", "openFlash, camera: %s, isPreviewing: %s", new Object[] { paramAnonymousView.dwJ, Boolean.valueOf(paramAnonymousView.jOC) });
                  if ((paramAnonymousView.dwJ == null) || (!paramAnonymousView.jOC)) {}
                }
                try
                {
                  paramAnonymousView.mgM = true;
                  Camera.Parameters localParameters = paramAnonymousView.dwJ.getParameters();
                  if ((!bk.dk(localParameters.getSupportedFlashModes())) && (localParameters.getSupportedFlashModes().contains("torch")))
                  {
                    localParameters.setFlashMode("torch");
                    paramAnonymousView.dwJ.setParameters(localParameters);
                    y.i("MicroMsg.scanner.ScanCamera", "open flash");
                  }
                  for (;;)
                  {
                    paramAnonymousView = BaseScanUI.h(BaseScanUI.this);
                    y.i("MicroMsg.ScannerFlashSwitcher", "openFlashStatus");
                    paramAnonymousView.nNq.setImageResource(R.k.scanner_flash_open_on);
                    return;
                    y.i("MicroMsg.scanner.ScanCamera", "camera not support flash!!");
                  }
                }
                catch (Exception paramAnonymousView)
                {
                  for (;;)
                  {
                    y.printErrStackTrace("MicroMsg.scanner.ScanCamera", paramAnonymousView, "openFlash error: %s", new Object[] { paramAnonymousView.getMessage() });
                  }
                }
                label197:
                BaseScanUI.g(BaseScanUI.this).biP();
                BaseScanUI.h(BaseScanUI.this).byd();
              }
            });
            if ((this.nIo == null) || (!this.nIo.mgM)) {
              break label1090;
            }
            this.nIs.setVisibility(0);
          }
          if ((this.nIG) && (!this.nIv)) {
            break label1102;
          }
          e(true, this.nIr.getMaskAnimDuration() + 150L);
          if ((this.nID != null) && (this.nIE != null))
          {
            this.nID.setVisibility(8);
            this.nIE.setVisibility(8);
          }
          if ((this.nIo == null) || (!this.nIo.isOpen())) {
            break;
          }
          this.nIo.g(this.nIp);
          this.nIM.iB(bxE());
          this.nIM.h(this.nIo.jOD);
          return;
        }
      }
      catch (Exception localException)
      {
        y.printErrStackTrace("MicroMsg.scanner.BaseScanUI", localException, "", new Object[0]);
        return;
      }
      this.nIr = new ScanMaskView(this, localException);
      continue;
      label1029:
      this.nIz = localException.left;
      this.nIA = (localException.right - BackwardSupportUtil.b.b(this, 8.0F));
      this.nIC = localException;
      continue;
      label1061:
      localException.topMargin = (this.nIC.top + (this.nIC.height() - com.tencent.mm.cb.a.fromDPToPix(this, 70)));
      continue;
      label1090:
      this.nIs.setVisibility(8);
      continue;
      label1102:
      if ((this.nID != null) && (this.nIE != null))
      {
        this.nID.setText(R.l.scan_no_network);
        this.nIE.setVisibility(0);
        this.nID.setVisibility(0);
      }
    }
  }
  
  public final void bxD()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("preview_ui_title", R.l.scan_select_local_img);
    com.tencent.mm.pluginsdk.ui.tools.l.a(this, 4660, localIntent);
  }
  
  public final boolean bxE()
  {
    if ((this.nIo == null) || (!this.nIo.isOpen()))
    {
      y.d("MicroMsg.scanner.BaseScanUI", "scanCamera == null or scanCamera is not open, cameraNeedRotate return false");
      return false;
    }
    return this.nIo.jOG;
  }
  
  public final void bxF()
  {
    aSq();
  }
  
  public final void bxG()
  {
    super.finish();
  }
  
  public final void bxH()
  {
    if ((!this.jTM) && (this.nIo != null) && (!this.nIu))
    {
      Object localObject = this.nIo.getFocusMode();
      if ((!bk.bl((String)localObject)) && (!((String)localObject).equals("auto")))
      {
        localObject = this.nIo;
        if ((((com.tencent.mm.plugin.scanner.util.h)localObject).dwJ != null) && (((com.tencent.mm.plugin.scanner.util.h)localObject).jOC))
        {
          Camera.Parameters localParameters = ((com.tencent.mm.plugin.scanner.util.h)localObject).dwJ.getParameters();
          List localList = localParameters.getSupportedFocusModes();
          if ((localList != null) && (localList.contains("auto")) && (!bk.bl(localParameters.getFocusMode())) && (!localParameters.getFocusMode().equals("auto")))
          {
            localParameters.setFocusMode("auto");
            ((com.tencent.mm.plugin.scanner.util.h)localObject).dwJ.setParameters(localParameters);
          }
        }
        fD(0L);
      }
    }
  }
  
  public final void bxx()
  {
    if ((this.nIL != null) && (this.nIK != null))
    {
      this.nIL.setVisibility(8);
      this.nIL.clearAnimation();
      this.nIL.setAnimation(null);
    }
  }
  
  public final void bxy()
  {
    if (!this.nIu) {
      com.tencent.mm.sdk.platformtools.au.G(this, R.l.qrcode_completed);
    }
  }
  
  public final void fC(long paramLong)
  {
    y.i("MicroMsg.scanner.BaseScanUI", "takeOneShotDelay: %s", new Object[] { Long.valueOf(paramLong) });
    this.nJa.removeMessages(0);
    if (!this.nIu)
    {
      this.nJa.sendEmptyMessageDelayed(0, paramLong);
      return;
    }
    y.w("MicroMsg.scanner.BaseScanUI", "takeOneShotDelay() scanPause");
  }
  
  public final void fD(long paramLong)
  {
    if ((this.nIo != null) && (!this.nIu) && (this.nIo.jOC))
    {
      y.d("MicroMsg.scanner.BaseScanUI", "focus delay:" + paramLong);
      String str = this.nIo.getFocusMode();
      if ((!bk.bl(str)) && (str.equals("continuous-video"))) {
        fC(0L);
      }
    }
    else
    {
      return;
    }
    this.nJc.removeMessages(0);
    this.nJc.sendEmptyMessageDelayed(0, paramLong);
  }
  
  public View findViewById(int paramInt)
  {
    return super.findViewById(paramInt);
  }
  
  protected final int getForceOrientation()
  {
    if (!yN())
    {
      y.d("MicroMsg.scanner.BaseScanUI", "getForceOrientation PORTRAIT");
      return 1;
    }
    y.d("MicroMsg.scanner.BaseScanUI", "getForceOrientation LANDSCAPE");
    return 0;
  }
  
  protected final int getLayoutId()
  {
    if (!yN())
    {
      y.d("MicroMsg.scanner.BaseScanUI", "getLayoutId PORTRAIT");
      return R.i.scan_base;
    }
    y.d("MicroMsg.scanner.BaseScanUI", "getLayoutId LANDSCAPE");
    return R.i.scan_base_land;
  }
  
  protected final void initView()
  {
    if (yN())
    {
      getWindow().setFlags(1024, 1024);
      this.mController.hideTitleView();
      y.d("MicroMsg.scanner.BaseScanUI", "oncreate LANDSCAPE");
    }
    this.nIE = findViewById(R.h.scan_no_data_mask);
    this.nID = ((TextView)findViewById(R.h.scan_no_network_tips));
    this.nIl = ((LinearLayout)findViewById(R.h.scan_title_btn));
    this.nIm = ((TextView)findViewById(R.h.scan_title_btn_bg));
    this.nIn = ((FrameLayout)findViewById(R.h.scan_body_fl));
    this.nIs = ((ScannerFlashSwitcher)findViewById(R.h.scanner_flash_switcher));
    this.nIj = ((MMTextureView)findViewById(R.h.preview_view));
    this.nIj.setOpaque(false);
    this.nIj.setSurfaceTextureListener(this);
    Object localObject2;
    Object localObject1;
    if ((7 == this.nIN) || (9 == this.nIN) || (10 == this.nIN) || (11 == this.nIN))
    {
      localObject2 = (Button)findViewById(R.h.scan_bank_ret_btn);
      ((Button)localObject2).setVisibility(0);
      findViewById(R.h.scan_bottom_ll).setVisibility(8);
      findViewById(R.h.scan_top_ll).setVisibility(8);
      if (9 != this.nIN)
      {
        localObject1 = localObject2;
        if (10 != this.nIN) {}
      }
      else
      {
        ViewGroup.LayoutParams localLayoutParams = ((Button)localObject2).getLayoutParams();
        localObject1 = localObject2;
        if (localLayoutParams != null)
        {
          localObject1 = localObject2;
          if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams))
          {
            localObject1 = (ViewGroup.MarginLayoutParams)localLayoutParams;
            ((ViewGroup.MarginLayoutParams)localObject1).leftMargin = ((ViewGroup.MarginLayoutParams)localObject1).topMargin;
            ((Button)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
            localObject1 = localObject2;
          }
        }
      }
      if (localObject1 == null) {
        break label503;
      }
      ((Button)localObject1).setOnClickListener(new BaseScanUI.16(this));
    }
    int i;
    for (;;)
    {
      this.nIL = ((ImageView)findViewById(R.h.scan_line));
      this.bID = getIntent().getIntExtra("GetFriendQRCodeUI.INTENT_FROM_ACTIVITY", 0);
      this.nIq = ((SelectScanModePanel)findViewById(R.h.scan_select_scan_mode_panel));
      this.nIn.setVisibility(0);
      if ((7 != this.nIN) && (9 != this.nIN) && (10 != this.nIN) && (11 != this.nIN) && (yN()))
      {
        this.nIN = 1;
        this.nIF = true;
      }
      localObject1 = getIntent().getIntArrayExtra("key_support_scan_code_type");
      localObject2 = new HashSet();
      if ((localObject1 == null) || (localObject1.length <= 0)) {
        break label518;
      }
      i = 0;
      while (i < localObject1.length)
      {
        ((Set)localObject2).add(Integer.valueOf(localObject1[i]));
        i += 1;
      }
      localObject1 = (Button)findViewById(R.h.scan_back_btn);
      break;
      label503:
      setBackBtn(new BaseScanUI.17(this));
    }
    label518:
    bxC();
    setMMSubTitle(null);
    if (this.nIN == 2)
    {
      this.nIM = new k(this, this.nIp);
      setMMTitle(r.eD(r.nPW, getString(R.l.scan_img_title)));
      if (com.tencent.mm.y.c.BS().b(ac.a.uzK, ac.a.uzL)) {
        this.nIS.add(Integer.valueOf(3));
      }
      this.nIB = this.nIM.bxt();
      localObject1 = this.nIL;
      if (!this.nIB) {
        break label1683;
      }
      i = R.g.qrcode_scan_line;
      label625:
      ((ImageView)localObject1).setBackgroundResource(i);
      if ((7 != this.nIN) && (9 != this.nIN) && (10 != this.nIN) && (11 != this.nIN)) {
        break label1690;
      }
    }
    for (;;)
    {
      if (this.nIo != null) {
        this.nIo.wV(this.nIN);
      }
      bxw();
      this.nIU = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      this.nIU.addUpdateListener(new BaseScanUI.18(this));
      this.nIU.setDuration(300L);
      ta(getResources().getColor(R.e.transparent));
      y.i("MicroMsg.scanner.BaseScanUI", "initView() done, fromSource=[%s], directSelectMode=[%s]", new Object[] { Integer.valueOf(this.bID), Integer.valueOf(this.nIN) });
      return;
      if (this.nIN == 5)
      {
        this.nIM = new q(this, this.nIp);
        setMMTitle(R.l.scan_entry_street);
        y.i("MicroMsg.scanner.BaseScanUI", "summerper checkPermission checkLocation[%b], stack[%s]", new Object[] { Boolean.valueOf(com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null)), bk.csb() });
        break;
      }
      if (this.nIN == 3)
      {
        this.nIM = new o(this, this.nIp);
        setMMTitle(R.l.scan_entry_ocr);
        break;
      }
      if ((this.nIN == 4) && (!yN()))
      {
        if (((Set)localObject2).isEmpty()) {}
        for (this.nIM = new p(this, this.nIp, this.bID, 2);; this.nIM = new p(this, this.nIp, this.bID, (Set)localObject2))
        {
          ((p)this.nIM).nMu = getIntent().getBooleanExtra("key_is_finish_on_scanned", false);
          this.nIq.setVisibility(8);
          setMMTitle(R.l.scan_entry_zbar);
          break;
        }
      }
      if (this.nIN == 8)
      {
        if (((Set)localObject2).isEmpty()) {}
        for (this.nIM = new p(this, this.nIp, this.bID, 1);; this.nIM = new p(this, this.nIp, this.bID, (Set)localObject2))
        {
          ((p)this.nIM).nMu = getIntent().getBooleanExtra("key_is_finish_on_scanned", false);
          this.nIq.setVisibility(8);
          setMMTitle(R.l.scan_entry_qrcode);
          break;
        }
      }
      if (7 == this.nIN)
      {
        localObject1 = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject1);
        this.nIM = new j(this, this.nIp, (DisplayMetrics)localObject1, getWindowManager().getDefaultDisplay().getRotation());
        localObject1 = (j)this.nIM;
        if ((getIntent() != null) && (getIntent().getBooleanExtra("scan_bankcard_with_confirm_ui", false))) {}
        for (boolean bool = true;; bool = false)
        {
          ((j)localObject1).nLJ = bool;
          setMMTitle(R.l.scan_entry_bankcard);
          this.nIq.setVisibility(8);
          break;
        }
      }
      if (9 == this.nIN)
      {
        localObject1 = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject1);
        this.nIM = new m(this, this.nIp, (DisplayMetrics)localObject1, getWindowManager().getDefaultDisplay().getRotation());
        setMMTitle(R.l.scan_entry_id_card);
        this.nIq.setVisibility(8);
        break;
      }
      if (10 == this.nIN)
      {
        localObject1 = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject1);
        this.nIM = new l(this, this.nIp, (DisplayMetrics)localObject1, getWindowManager().getDefaultDisplay().getRotation());
        setMMTitle(R.l.scan_entry_driving_licence);
        this.nIq.setVisibility(8);
        break;
      }
      if (11 == this.nIN)
      {
        localObject1 = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject1);
        this.nIM = new n(this, this.nIp, (DisplayMetrics)localObject1, getWindowManager().getDefaultDisplay().getRotation());
        setMMTitle(R.l.scan_entry_id_card_for_pay_auth);
        this.nIq.setVisibility(8);
        break;
      }
      this.nIN = 1;
      if (((Set)localObject2).isEmpty())
      {
        localObject1 = this.nIp;
        int j = this.bID;
        if (yN())
        {
          i = 1;
          label1503:
          this.nIM = new p(this, (Point)localObject1, j, i);
          label1519:
          ((p)this.nIM).nMu = getIntent().getBooleanExtra("key_is_finish_on_scanned", false);
          if (!com.tencent.mm.at.b.Pe()) {
            break label1642;
          }
          this.nIF = true;
          if (!r.byE()) {
            break label1630;
          }
          this.nIq.setDisplayModes(new int[] { 1, 3 });
          this.nIq.setVisibility(0);
        }
      }
      for (;;)
      {
        if (!this.nIF) {
          break label1673;
        }
        setMMTitle(R.l.scan_entry_qrcode);
        break;
        i = 0;
        break label1503;
        this.nIM = new p(this, this.nIp, this.bID, (Set)localObject2);
        break label1519;
        label1630:
        this.nIq.setVisibility(8);
        continue;
        label1642:
        if (getIntent().getBooleanExtra("BaseScanUI_only_scan_qrcode_with_zbar", false))
        {
          this.nIF = false;
          this.nIq.setVisibility(8);
        }
      }
      label1673:
      setMMTitle(R.l.scan_entry_qrcode_zbar);
      break;
      label1683:
      i = R.g.qrcode_scan_line_hor;
      break label625;
      label1690:
      this.nIq.setShowRedDotModes(this.nIS);
      this.nIq.setSelectedMode(this.nIN);
      this.nIq.setOnGridItemClickCallback(new BaseScanUI.19(this));
    }
  }
  
  public final void ix(boolean paramBoolean)
  {
    this.nIu = paramBoolean;
    if (paramBoolean)
    {
      bxx();
      if (this.nIE != null) {
        this.nIE.setVisibility(0);
      }
    }
    do
    {
      return;
      fD(0L);
      e(false, 0L);
    } while (this.nIE == null);
    this.nIE.setVisibility(8);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.nIw != null) {
      this.nIw.b(this, paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    y.i("MicroMsg.scanner.BaseScanUI", "onAutoFocus, success: %s, camera: %s", new Object[] { Boolean.valueOf(paramBoolean), paramCamera });
    this.fmY[4] = ((int)(System.currentTimeMillis() - this.nIR));
    com.tencent.mm.compatible.e.q.dyd.dwx = this.fmY[4];
    if (this.nIu) {}
    do
    {
      do
      {
        return;
      } while (this.nIM == null);
      if ((this.nIo != null) && (this.nIo.jOC) && (paramBoolean)) {
        fC(0L);
      }
    } while (this.nIM.nLt <= 0L);
    fD(this.nIM.nLt);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    y.i("MicroMsg.scanner.BaseScanUI", "screen orientation %d", new Object[] { Integer.valueOf(paramConfiguration.orientation) });
    if ((paramConfiguration.orientation == 2) || (paramConfiguration.orientation == 1)) {
      ai.l(new BaseScanUI.15(this), 100L);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.nIN = getIntent().getIntExtra("BaseScanUI_select_scan_mode", 1);
    super.onCreate(paramBundle);
    s.initLanguage(this);
    getWindow().addFlags(2097280);
    getWindow().getDecorView().setSystemUiVisibility(1280);
    if ((com.tencent.mm.model.au.Dk().KG() == 6) || (com.tencent.mm.model.au.Dk().KG() == 4)) {
      this.nIv = true;
    }
    for (;;)
    {
      if ((7 == this.nIN) || (11 == this.nIN)) {
        this.nIG = false;
      }
      com.tencent.mm.sdk.b.a.udP.c(this.nJb);
      com.tencent.mm.sdk.b.a.udP.c(this.nIW);
      initView();
      this.nIQ = System.currentTimeMillis();
      paramBundle = ScanCameraLightDetector.nPf;
      try
      {
        paramBundle.nPk = com.tencent.mm.sdk.f.e.aap("ScanCameraLightDetector_detectThread");
        paramBundle.nPk.start();
        paramBundle.handler = new ScanCameraLightDetector.1(paramBundle, paramBundle.nPk.getLooper());
        y.i("MicroMsg.ScanCameraLightDetector", "start, sensorManager: %s, lightSensor: %s, isRegister: %s", new Object[] { paramBundle.sensorManager, paramBundle.nPh, Boolean.valueOf(paramBundle.nPi) });
        this.nIQ = System.currentTimeMillis();
        return;
        this.nIv = false;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.ScanCameraLightDetector", localException, "start error: %s", new Object[] { localException.getMessage() });
        }
      }
    }
  }
  
  protected void onDestroy()
  {
    y.i("MicroMsg.scanner.BaseScanUI", "onDestroy()");
    if (this.nIM != null) {
      this.nIM.onDestroy();
    }
    if (this.nIr != null) {
      this.nIr.bxP();
    }
    if (this.nIj != null) {
      this.nIj.setSurfaceTextureListener(null);
    }
    com.tencent.mm.sdk.b.a.udP.d(this.nJb);
    com.tencent.mm.sdk.b.a.udP.d(this.nIW);
    ScanCameraLightDetector localScanCameraLightDetector = ScanCameraLightDetector.nPf;
    y.i("MicroMsg.ScanCameraLightDetector", "stop, isRegister: %s, sensorManager: %s, lightSensor: %s", new Object[] { Boolean.valueOf(localScanCameraLightDetector.nPi), localScanCameraLightDetector.sensorManager, localScanCameraLightDetector.nPh });
    try
    {
      localScanCameraLightDetector.nPg = -1L;
      if (localScanCameraLightDetector.nPk != null) {
        localScanCameraLightDetector.nPk.quit();
      }
      super.onDestroy();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.ScanCameraLightDetector", localException, "stop error: %s", new Object[] { localException.getMessage() });
      }
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (paramKeyEvent.getAction() == 0) && (paramKeyEvent.getRepeatCount() == 0))
    {
      y.d("MicroMsg.scanner.BaseScanUI", "keyCode KEYCODE_BACK");
      this.nIu = true;
      aSq();
      overridePendingTransition(0, 0);
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onPause()
  {
    y.i("MicroMsg.scanner.BaseScanUI", "onPause(), scanMode: %s, mQBarStringHandler: %s", new Object[] { this.nIM, this.nIJ });
    this.nIu = true;
    com.tencent.mm.plugin.scanner.util.m.nPF.stop();
    if (this.nIM != null)
    {
      this.nIM.onPause();
      if (this.nIM.bxp() != null) {
        this.nIM.bxp().nm();
      }
    }
    int i;
    if (this.nIo != null)
    {
      String str = this.nIo.getFocusMode();
      if ((!bk.bl(str)) && (str.equals("continuous-video"))) {
        this.fmY[2] = 1;
      }
    }
    else
    {
      aPC();
      if (this.nIs != null)
      {
        this.nIs.byd();
        this.nIs.hide();
      }
      if ((this.wakeLock != null) && (this.wakeLock.isHeld()))
      {
        this.wakeLock.release();
        this.wakeLock = null;
      }
      sendBroadcast(new Intent("com.tencent.mm.ui.ACTION_DEACTIVE").putExtra("classname", getClass().getName()), "com.tencent.mm.permission.MM_MESSAGE");
      if (this.nIG) {
        com.tencent.mm.model.au.b(this.nIV);
      }
      if (this.nIJ != null) {
        this.nIJ.onPause();
      }
      if ((this.nIN == 1) || (this.nIN == 8) || (this.nIN == 4))
      {
        com.tencent.mm.plugin.scanner.a.m.nHb.bcI();
        i = (int)(System.currentTimeMillis() - this.nIQ);
        y.i("MicroMsg.scanner.BaseScanUI", "scan cost time:" + i);
        if (!com.tencent.mm.plugin.scanner.a.m.nHb.nHd) {
          break label492;
        }
        this.fmY[0] = 1;
      }
    }
    for (;;)
    {
      this.fmY[1] = i;
      this.fmY[3] = com.tencent.mm.plugin.scanner.a.m.nHb.nHe;
      if (com.tencent.mm.plugin.scanner.util.m.nPF.byA() > 0L) {
        this.fmY[6] = ((int)(com.tencent.mm.plugin.scanner.util.m.nPF.byA() - this.nIQ));
      }
      this.fmY[7] = this.nIN;
      com.tencent.mm.plugin.report.service.h.nFQ.f(14176, new Object[] { Integer.valueOf(this.fmY[0]), Integer.valueOf(this.fmY[1]), Integer.valueOf(this.fmY[2]), Integer.valueOf(this.fmY[3]), Integer.valueOf(this.fmY[4]), Integer.valueOf(this.fmY[5]), Integer.valueOf(this.fmY[6]), Integer.valueOf(this.fmY[7]) });
      super.onPause();
      return;
      this.fmY[2] = 0;
      break;
      label492:
      this.fmY[0] = 0;
    }
  }
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    boolean bool;
    if (paramArrayOfByte == null)
    {
      bool = true;
      y.i("MicroMsg.scanner.BaseScanUI", "onPreviewFrame, data==null: %s, camera: %s", new Object[] { Boolean.valueOf(bool), paramCamera });
      if ((!this.nIu) && (this.nIM != null) && (this.nIM.bxp() != null) && (this.nIM.D(false, yN()) != null)) {
        break label101;
      }
      y.w("MicroMsg.scanner.BaseScanUI", "onPreviewFrame error state, scanPause = [%s]", new Object[] { Boolean.valueOf(this.nIu) });
    }
    label101:
    do
    {
      return;
      bool = false;
      break;
      if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0))
      {
        if (paramArrayOfByte == null) {}
        for (bool = true;; bool = false)
        {
          y.e("MicroMsg.scanner.BaseScanUI", "onPreviewFrame, wrong data, data is null [%s]", new Object[] { Boolean.valueOf(bool) });
          bxA();
          return;
        }
      }
      if (this.nIo == null)
      {
        y.e("MicroMsg.scanner.BaseScanUI", "onPreviewFrame, scanCamera == null, finish this activity");
        return;
      }
      if (this.nIo != null)
      {
        paramCamera = this.nIo;
        if (paramCamera.nPa < 0)
        {
          if (!paramCamera.byv()) {
            break label798;
          }
          i = 1;
          paramCamera.nPa = i;
        }
        if (paramCamera.nPa != 1) {
          break label803;
        }
        i = 1;
        if ((i != 0) && (!this.nIo.mgM) && (this.nIv))
        {
          paramCamera = ScanCameraLightDetector.nPf;
          i = this.nIo.jOD.x;
          j = this.nIo.jOD.y;
          if ((paramCamera.nPg < 0L) || ((bk.cp(paramCamera.nPg) >= 1000L) && (paramCamera.handler != null) && (paramCamera.nPk != null) && (paramCamera.nPk.isAlive())))
          {
            localObject1 = new ScanCameraLightDetector.a(paramCamera, (byte)0);
            ((ScanCameraLightDetector.a)localObject1).mip = paramArrayOfByte;
            ((ScanCameraLightDetector.a)localObject1).width = i;
            ((ScanCameraLightDetector.a)localObject1).height = j;
            localObject2 = Message.obtain();
            ((Message)localObject2).what = 233;
            ((Message)localObject2).obj = localObject1;
            paramCamera.handler.sendMessage((Message)localObject2);
            paramCamera.nPg = bk.UZ();
          }
        }
      }
    } while ((this.nIo == null) || (this.nIu));
    label209:
    paramCamera = this.nIM;
    Object localObject1 = this.nIo.jOD;
    int i = this.nIo.jOH;
    Object localObject2 = this.nIo;
    Rect localRect1 = this.nIM.iA(yN());
    int j = this.nIN;
    Rect localRect2 = new Rect();
    y.i("MicroMsg.scanner.ScanCamera", "frame rect:%s, visibleResolution:%s, cameraResolution %s", new Object[] { localRect1, ((com.tencent.mm.plugin.scanner.util.h)localObject2).jOF, ((com.tencent.mm.plugin.scanner.util.h)localObject2).jOD });
    if ((((com.tencent.mm.plugin.scanner.util.h)localObject2).jOG) && (!((com.tencent.mm.plugin.scanner.util.h)localObject2).nOX))
    {
      y.i("MicroMsg.scanner.ScanCamera", ", needRotate = " + ((com.tencent.mm.plugin.scanner.util.h)localObject2).jOG + " needLandscape = " + ((com.tencent.mm.plugin.scanner.util.h)localObject2).nOX);
      localRect2.top = ((((com.tencent.mm.plugin.scanner.util.h)localObject2).jOD.x - (int)(localRect1.height() * ((com.tencent.mm.plugin.scanner.util.h)localObject2).byq())) / 2);
      localRect2.bottom = (((com.tencent.mm.plugin.scanner.util.h)localObject2).jOD.x - localRect2.top);
      localRect2.left = ((((com.tencent.mm.plugin.scanner.util.h)localObject2).jOD.y - (int)(localRect1.width() * ((com.tencent.mm.plugin.scanner.util.h)localObject2).byp())) / 2);
      localRect2.right = (((com.tencent.mm.plugin.scanner.util.h)localObject2).jOD.y - localRect2.left);
      label628:
      if ((7 == j) || (11 == j))
      {
        if ((!((com.tencent.mm.plugin.scanner.util.h)localObject2).jOG) || (((com.tencent.mm.plugin.scanner.util.h)localObject2).nOX)) {
          break label993;
        }
        if (localRect2.height() / 1.586F >= localRect2.width()) {
          break label941;
        }
        j = (int)(localRect2.height() / 1.586F);
        localRect2.left = ((localRect2.left + localRect2.right) / 2 - j / 2);
        localRect2.right = (j + localRect2.left);
      }
    }
    for (;;)
    {
      y.i("MicroMsg.scanner.ScanCamera", "resultRect %s", new Object[] { localRect2 });
      ((com.tencent.mm.plugin.scanner.util.h)localObject2).jLf = localRect2;
      ((com.tencent.mm.plugin.scanner.util.h)localObject2).byr();
      y.i("MicroMsg.scanner.ScanCamera", "scanRect:" + ((com.tencent.mm.plugin.scanner.util.h)localObject2).jLf);
      paramCamera.a(paramArrayOfByte, (Point)localObject1, i, ((com.tencent.mm.plugin.scanner.util.h)localObject2).jLf);
      return;
      label798:
      i = 0;
      break;
      label803:
      i = 0;
      break label209;
      localRect2.left = ((int)(localRect1.left * ((com.tencent.mm.plugin.scanner.util.h)localObject2).byp()));
      localRect2.right = ((int)(localRect1.right * ((com.tencent.mm.plugin.scanner.util.h)localObject2).byp()));
      localRect2.top = ((int)(localRect1.top * ((com.tencent.mm.plugin.scanner.util.h)localObject2).byq()));
      localRect2.bottom = ((int)(localRect1.bottom * ((com.tencent.mm.plugin.scanner.util.h)localObject2).byq()));
      if (localRect2.bottom > ((com.tencent.mm.plugin.scanner.util.h)localObject2).jOD.y) {
        localRect2.bottom = ((com.tencent.mm.plugin.scanner.util.h)localObject2).jOD.y;
      }
      if (localRect2.right <= ((com.tencent.mm.plugin.scanner.util.h)localObject2).jOD.x) {
        break label628;
      }
      localRect2.right = ((com.tencent.mm.plugin.scanner.util.h)localObject2).jOD.x;
      break label628;
      label941:
      j = (int)(localRect2.width() * 1.586F);
      localRect2.top = ((localRect2.top + localRect2.bottom) / 2 - j / 2);
      localRect2.bottom = (j + localRect2.top);
      continue;
      label993:
      if (localRect2.width() * 1.0D / localRect2.height() < 1.585999965667725D)
      {
        j = (int)(localRect2.width() / 1.586F);
        localRect2.top = ((localRect2.top + localRect2.bottom) / 2 - j / 2);
        localRect2.bottom = (j + localRect2.top);
      }
      else
      {
        j = (int)(localRect2.height() * 1.586F);
        localRect2.left = ((localRect2.left + localRect2.right) / 2 - j / 2);
        localRect2.right = (j + localRect2.left);
      }
    }
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    y.i("MicroMsg.scanner.BaseScanUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults len[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt.length), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    do
    {
      return;
      if ((paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0))
      {
        buJ();
        return;
      }
      this.fht = false;
      com.tencent.mm.ui.base.h.a(this, getString(R.l.permission_camera_request_again_msg), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.cancel), false, new BaseScanUI.21(this), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          BaseScanUI.o(BaseScanUI.this);
          BaseScanUI.this.finish();
        }
      });
      return;
    } while ((paramArrayOfInt.length > 0) && (paramArrayOfInt[0] == 0));
    com.tencent.mm.ui.base.h.a(this, getString(R.l.permission_location_request_again_msg), getString(R.l.permission_tips_title), getString(R.l.jump_to_settings), getString(R.l.cancel), false, new BaseScanUI.2(this), null);
  }
  
  protected void onResume()
  {
    super.onResume();
    if (!this.nIP)
    {
      com.tencent.mm.cl.b.afs("com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
      this.nIP = true;
    }
    if (this.fht)
    {
      boolean bool = com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.CAMERA", 16, null, null);
      y.i("MicroMsg.scanner.BaseScanUI", "summerper checkPermission checkCamera[%b]", new Object[] { Boolean.valueOf(bool) });
      if (bool) {}
    }
    com.tencent.mm.plugin.scanner.util.m localm;
    do
    {
      return;
      buJ();
      if ((!this.nIu) && ((this.nIN == 1) || (this.nIN == 8) || (this.nIN == 4)))
      {
        com.tencent.mm.plugin.scanner.a.m.nHb.reset();
        com.tencent.mm.plugin.scanner.a.m.nHb.wO(com.tencent.mm.plugin.scanner.a.m.nGY);
      }
      localm = com.tencent.mm.plugin.scanner.util.m.nPF;
      y.i("MicroMsg.ScanStableDetector", "start detect scan stable");
    } while (localm.aVT == null);
    localm.nPD = 0;
    localm.nPC[0] = 0.0F;
    localm.nPC[1] = 0.0F;
    localm.nPC[2] = 0.0F;
    y.i("MicroMsg.ScanStableDetector", "register accelerate listener");
    localm.aVT.registerListener(localm, localm.nPB, 50000);
  }
  
  public void onStart()
  {
    super.onStart();
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    y.d("MicroMsg.scanner.BaseScanUI", "onSurfaceTextureAvailable");
    this.nIj.cBe();
    this.nIk = paramSurfaceTexture;
    this.nIH = true;
    if (this.nII)
    {
      bxz();
      this.nII = false;
    }
    startPreview();
  }
  
  public boolean onSurfaceTextureDestroyed(SurfaceTexture paramSurfaceTexture)
  {
    y.d("MicroMsg.scanner.BaseScanUI", "onSurfaceTextureDestroyed");
    this.nIH = false;
    return false;
  }
  
  public void onSurfaceTextureSizeChanged(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    y.d("MicroMsg.scanner.BaseScanUI", "onSurfaceTextureSizeChanged");
    this.nIk = paramSurfaceTexture;
  }
  
  public void onSurfaceTextureUpdated(SurfaceTexture paramSurfaceTexture) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.BaseScanUI
 * JD-Core Version:    0.7.0.1
 */
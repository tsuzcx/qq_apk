package com.tencent.mm.plugin.scanner.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.vz;
import com.tencent.mm.autogen.a.wa;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.ak.a.d;
import com.tencent.mm.plugin.ak.a.e;
import com.tencent.mm.plugin.ak.a.g;
import com.tencent.mm.plugin.licence.model.LibCardRecog;
import com.tencent.mm.plugin.scanner.b.a.a.a;
import com.tencent.mm.plugin.scanner.b.a.b.a;
import com.tencent.mm.plugin.scanner.b.a.b.b;
import com.tencent.mm.plugin.scanner.b.a.c.b;
import com.tencent.mm.plugin.scanner.ui.ScannerFlashSwitcher;
import com.tencent.mm.plugin.scanner.util.ScanCameraLightDetector;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import com.tencent.qbar.WxQbarNative;
import com.tencent.scanlib.a.b.b.a;
import com.tencent.scanlib.a.b.d.a;
import com.tencent.scanlib.ui.ScanView;
import java.util.Map;
import java.util.concurrent.ExecutorService;

public class ScanCardRectView
  extends ScanView
{
  private View Ild;
  private long OOu;
  private ScannerFlashSwitcher OXj;
  private IListener OYl;
  private ScanRectDecorView PbB;
  private IListener<wa> Pce;
  private c.b PkA;
  private CardHighLightEdgeView Pkw;
  private ScanCardRectView.a Pkx;
  private a.a Pky;
  private b.a Pkz;
  private int mode;
  
  public ScanCardRectView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(118389);
    this.Pky = new a.a() {};
    this.Pkz = new ScanCardRectView.5(this);
    this.PkA = new ScanCardRectView.6(this);
    this.OYl = new IListener(com.tencent.mm.app.f.hfK) {};
    this.Pce = new IListener(com.tencent.mm.app.f.hfK) {};
    AppMethodBeat.o(118389);
  }
  
  public ScanCardRectView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(118390);
    this.Pky = new a.a() {};
    this.Pkz = new ScanCardRectView.5(this);
    this.PkA = new ScanCardRectView.6(this);
    this.OYl = new IListener(com.tencent.mm.app.f.hfK) {};
    this.Pce = new IListener(com.tencent.mm.app.f.hfK) {};
    AppMethodBeat.o(118390);
  }
  
  public ScanCardRectView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(118391);
    this.Pky = new a.a() {};
    this.Pkz = new ScanCardRectView.5(this);
    this.PkA = new ScanCardRectView.6(this);
    this.OYl = new IListener(com.tencent.mm.app.f.hfK) {};
    this.Pce = new IListener(com.tencent.mm.app.f.hfK) {};
    AppMethodBeat.o(118391);
  }
  
  private static boolean gQi()
  {
    AppMethodBeat.i(314060);
    if (((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(com.tencent.mm.plugin.expt.b.c.a.yRb, 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.ScanCardRectView", "id_card_scan_v2: %s", new Object[] { Boolean.valueOf(bool) });
      AppMethodBeat.o(314060);
      return bool;
    }
  }
  
  private void gSO()
  {
    AppMethodBeat.i(118398);
    com.tencent.mm.plugin.scanner.b.a.b.gQg().release();
    com.tencent.mm.plugin.scanner.b.a.c localc = com.tencent.mm.plugin.scanner.b.a.c.gQh();
    long l = this.OOu;
    synchronized (localc.GXz)
    {
      if (localc.OOu == l)
      {
        localc.OOu = 0L;
        localc.OOx = 0;
        localc.OOC = null;
        localc.OOo.clear();
      }
      this.OOu = 0L;
      AppMethodBeat.o(118398);
      return;
    }
  }
  
  private void gSl()
  {
    AppMethodBeat.i(118404);
    this.OXj = ((ScannerFlashSwitcher)this.Ild.findViewById(a.d.scanner_card_flash_switcher));
    if (this.OXj != null) {
      this.OXj.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(177504);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/scanner/view/ScanCardRectView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          if (!ScanCardRectView.g(ScanCardRectView.this).hU)
          {
            paramAnonymousView = new wa();
            paramAnonymousView.hZH.hAf = 1;
            paramAnonymousView.publish();
            ScanCardRectView.g(ScanCardRectView.this).gSZ();
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/view/ScanCardRectView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(177504);
            return;
            paramAnonymousView = new wa();
            paramAnonymousView.hZH.hAf = 2;
            paramAnonymousView.publish();
            ScanCardRectView.g(ScanCardRectView.this).gTa();
          }
        }
      });
    }
    this.OYl.alive();
    this.Pce.alive();
    MMHandlerThread.postToMainThreadDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(177505);
        ScanCameraLightDetector.Pio.start(((com.tencent.mm.plugin.scanner.a.a)ScanCardRectView.h(ScanCardRectView.this)).jXJ());
        AppMethodBeat.o(177505);
      }
    }, 300L);
    AppMethodBeat.o(118404);
  }
  
  public final void gSM()
  {
    AppMethodBeat.i(118393);
    this.ahwr = new com.tencent.mm.plugin.scanner.a.a();
    AppMethodBeat.o(118393);
  }
  
  public Rect getDecorRect()
  {
    AppMethodBeat.i(118394);
    Rect localRect = this.PbB.getDecorRect();
    AppMethodBeat.o(118394);
    return localRect;
  }
  
  public final void init()
  {
    AppMethodBeat.i(118392);
    super.init();
    this.Pkw = new CardHighLightEdgeView(getContext());
    addView(this.Pkw, new FrameLayout.LayoutParams(-1, -1));
    this.PbB = new ScanRectDecorView(getContext());
    addView(this.PbB, new FrameLayout.LayoutParams(-1, -1));
    AppMethodBeat.o(118392);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(118396);
    super.onAttachedToWindow();
    Object localObject1 = new Point();
    getDisplay().getSize((Point)localObject1);
    Log.i("MicroMsg.ScanCardRectView", "screenSize %s", new Object[] { localObject1 });
    if (this.Ild != null) {
      removeView(this.Ild);
    }
    switch (this.mode)
    {
    case 8: 
    default: 
      Log.e("MicroMsg.ScanCardRectView", "unknown mode!");
      AppMethodBeat.o(118396);
      return;
    case 7: 
      this.Ild = View.inflate(getContext(), a.e.scan_bankcard_body, null);
      localObject2 = Util.nullAs(((Activity)getContext()).getIntent().getStringExtra("bank_card_owner"), "");
      String str = String.format(getContext().getResources().getString(a.g.scan_bank_owner), new Object[] { localObject2 });
      View localView = this.Ild.findViewById(a.d.top_container);
      if (Util.isNullOrNil((String)localObject2)) {
        localView.setVisibility(4);
      }
      for (;;)
      {
        addView(this.Ild, new FrameLayout.LayoutParams(-1, -1));
        localObject2 = new Rect();
        ((Rect)localObject2).left = com.tencent.mm.cd.a.fromDPToPix(getContext(), 40);
        ((Rect)localObject2).right = (((Point)localObject1).x - com.tencent.mm.cd.a.fromDPToPix(getContext(), 40));
        ((Rect)localObject2).top = ((((Point)localObject1).y - (int)(((Rect)localObject2).width() / 1.586F)) / 2);
        ((Rect)localObject2).bottom = (((Rect)localObject2).top + (int)(((Rect)localObject2).width() / 1.586F));
        Log.i("MicroMsg.ScanCardRectView", "scan bank card rect %s", new Object[] { localObject2 });
        this.PbB.kX(((Rect)localObject2).width(), ((Rect)localObject2).height());
        this.Pkw.setCardRect((Rect)localObject2);
        gSl();
        AppMethodBeat.o(118396);
        return;
        ((TextView)this.Ild.findViewById(a.d.bank_card_owner)).setText(str);
        this.Ild.findViewById(a.d.bank_card_declare).setOnClickListener(new ScanCardRectView.1(this));
        localView.setVisibility(0);
      }
    case 9: 
    case 11: 
      localObject2 = new Rect();
      ((Rect)localObject2).left = com.tencent.mm.cd.a.fromDPToPix(getContext(), 40);
      ((Rect)localObject2).right = (((Point)localObject1).x - com.tencent.mm.cd.a.fromDPToPix(getContext(), 40));
      ((Rect)localObject2).top = ((((Point)localObject1).y - (int)(((Rect)localObject2).width() / 1.586F)) / 2);
      ((Rect)localObject2).bottom = (((Rect)localObject2).top + (int)(((Rect)localObject2).width() / 1.586F));
      Log.i("MicroMsg.ScanCardRectView", "scan id card rect %s", new Object[] { localObject2 });
      this.PbB.kX(((Rect)localObject2).width(), ((Rect)localObject2).height());
      this.Pkw.setCardRect((Rect)localObject2);
      this.Ild = View.inflate(getContext(), a.e.scan_idcard_body, null);
      addView(this.Ild, new FrameLayout.LayoutParams(-1, -1));
      localObject1 = (TextView)this.Ild.findViewById(a.d.bottom_tip_view);
      ((TextView)localObject1).setShadowLayer(3.0F, 0.0F, 0.0F, -16777216);
      ((TextView)localObject1).setText(getContext().getResources().getString(a.g.scan_id_card_default_tips));
      aw.a(((TextView)localObject1).getPaint(), 0.8F);
      gSl();
      AppMethodBeat.o(118396);
      return;
    }
    Object localObject2 = new Rect();
    ((Rect)localObject2).left = com.tencent.mm.cd.a.fromDPToPix(getContext(), 40);
    ((Rect)localObject2).right = (((Point)localObject1).x - com.tencent.mm.cd.a.fromDPToPix(getContext(), 40));
    ((Rect)localObject2).top = ((((Point)localObject1).y - (int)(((Rect)localObject2).width() / 1.467F)) / 2);
    ((Rect)localObject2).bottom = (((Rect)localObject2).top + (int)(((Rect)localObject2).width() / 1.467F));
    Log.i("MicroMsg.ScanCardRectView", "scan driver card rect %s", new Object[] { localObject2 });
    this.PbB.kX(((Rect)localObject2).width(), ((Rect)localObject2).height());
    this.Pkw.setCardRect((Rect)localObject2);
    this.Ild = View.inflate(getContext(), a.e.scan_idcard_body, null);
    addView(this.Ild, new FrameLayout.LayoutParams(-1, -1));
    ((TextView)this.Ild.findViewById(a.d.bottom_tip_view)).setText("");
    gSl();
    AppMethodBeat.o(118396);
  }
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    AppMethodBeat.i(118403);
    Log.i("MicroMsg.ScanCardRectView", "onAutoFocus %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      ua(0L);
    }
    Bb(ahwu);
    AppMethodBeat.o(118403);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(118401);
    super.onDestroy();
    com.tencent.mm.plugin.scanner.b.a.b.gQg().release();
    com.tencent.mm.plugin.scanner.b.a.c.gQh().release();
    AppMethodBeat.o(118401);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(118399);
    super.onPause();
    gSO();
    AppMethodBeat.o(118399);
  }
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    AppMethodBeat.i(118402);
    super.onPreviewFrame(paramArrayOfByte, paramCamera);
    paramCamera = new StringBuilder("onPreviewFrame null data:");
    boolean bool;
    if (paramArrayOfByte == null) {
      bool = true;
    }
    Point localPoint;
    int i;
    int j;
    int k;
    for (;;)
    {
      Log.i("MicroMsg.ScanCardRectView", bool);
      if ((this.ahwr.boa()) && (((com.tencent.mm.plugin.scanner.a.a)this.ahwr).gQd())) {
        ScanCameraLightDetector.Pio.N(paramArrayOfByte, ((com.tencent.mm.plugin.scanner.a.a)this.ahwr).jXF().x, ((com.tencent.mm.plugin.scanner.a.a)this.ahwr).jXF().y);
      }
      if (this.mode == 7)
      {
        ??? = ((com.tencent.scanlib.a.a)this.ahwr).O(getDecorRect());
        paramCamera = com.tencent.mm.plugin.scanner.b.a.b.gQg();
        localPoint = this.ahwr.jXF();
        i = this.ahwr.getCameraRotation();
        synchronized (paramCamera.GXz)
        {
          if ((((Rect)???).width() != paramCamera.OOr.width()) || (((Rect)???).height() != paramCamera.OOr.height())) {}
          synchronized (paramCamera.OOp)
          {
            if (paramCamera.lYs) {
              WxQbarNative.focusedEngineRelease();
            }
            paramCamera.lYs = false;
            Log.i("MicroMsg.BankCardDetectQueue", "resolution %s, rotation %d, rect %s", new Object[] { localPoint, Integer.valueOf(i), ??? });
            if (!paramCamera.lYs) {}
            synchronized (paramCamera.OOp)
            {
              Log.i("MicroMsg.BankCardDetectQueue", "rect %s", new Object[] { ??? });
              paramCamera.OOr = ((Rect)???);
              j = (int)(((Rect)???).width() * com.tencent.mm.plugin.scanner.b.a.b.OOn);
              k = (int)(((Rect)???).height() * com.tencent.mm.plugin.scanner.b.a.b.OOn);
              paramCamera.Gl.left = (((Rect)???).left - (j - ((Rect)???).width()) / 2);
              paramCamera.Gl.top = (((Rect)???).top - (k - ((Rect)???).height()) / 2);
              paramCamera.Gl.right = (paramCamera.Gl.left + j);
              paramCamera.Gl.bottom = (paramCamera.Gl.top + k);
              Log.i("MicroMsg.BankCardDetectQueue", "cropRect %s", new Object[] { paramCamera.Gl });
              if (WxQbarNative.focusedEngineForBankcardInit(j, k, 8, false) == 0)
              {
                bool = true;
                label436:
                paramCamera.lYs = bool;
                if (!paramCamera.lYs) {}
              }
            }
          }
        }
        synchronized (paramCamera.GXz)
        {
          paramCamera.OOo.clear();
          paramCamera.OOo.put("param_preview_data", paramArrayOfByte);
          paramCamera.OOo.put("param_camera_resolution", localPoint);
          paramCamera.OOo.put("param_camera_rotation", Integer.valueOf(i));
          if ((!paramCamera.OOw) && (paramCamera.OOu != 0L))
          {
            Log.i("MicroMsg.BankCardDetectQueue", "%d submit decode bankcard", new Object[] { Long.valueOf(paramCamera.OOu) });
            paramCamera.OOt.execute(new b.b(paramCamera, paramCamera.OOu));
          }
          if ((!((com.tencent.scanlib.a.a)this.ahwr).gSN()) && (com.tencent.mm.plugin.scanner.b.a.b.gQg().OOx > 10))
          {
            Log.i("MicroMsg.ScanCardRectView", "change to FOCUS_MODE_AUTO");
            this.ahwr.bFD("auto");
            Bb(100L);
          }
          AppMethodBeat.o(118402);
          return;
          bool = false;
          continue;
          paramArrayOfByte = finally;
          AppMethodBeat.o(118402);
          throw paramArrayOfByte;
          paramArrayOfByte = finally;
          AppMethodBeat.o(118402);
          throw paramArrayOfByte;
          bool = false;
          break label436;
          paramArrayOfByte = finally;
          AppMethodBeat.o(118402);
          throw paramArrayOfByte;
        }
      }
    }
    if (this.mode == 11)
    {
      paramCamera = getDecorRect();
      double d1 = 0.0D;
      if (gQi()) {
        d1 = 30.0D;
      }
      double d3 = (paramCamera.bottom - paramCamera.top) / (paramCamera.right - paramCamera.left);
      double d4 = paramCamera.right - paramCamera.left;
      double d5 = paramCamera.bottom - paramCamera.top;
      double d2 = d1 * 0.5D;
      d1 = (d3 * (d4 + d1) - d5) * 0.5D;
      i = paramCamera.left;
      j = (int)d2;
      k = paramCamera.top;
      int m = (int)d1;
      int n = paramCamera.right;
      paramCamera = new Rect(i - j, k - m, (int)d2 + n, paramCamera.bottom + (int)d1);
      ??? = ((com.tencent.scanlib.a.a)this.ahwr).O(paramCamera);
      paramCamera = com.tencent.mm.plugin.scanner.b.a.c.gQh();
      localPoint = this.ahwr.jXF();
      j = this.ahwr.getCameraRotation();
    }
    for (;;)
    {
      synchronized (paramCamera.GXz)
      {
        if ((((Rect)???).width() != paramCamera.OOr.width()) || (((Rect)???).height() != paramCamera.OOr.height()))
        {
          paramCamera.release();
          paramCamera.lYs = false;
        }
        if (!paramCamera.lYs) {}
        synchronized (paramCamera.OOp)
        {
          paramCamera.OOr = ((Rect)???);
          i = (int)(((Rect)???).width() * 1.05D) / 4 * 4;
          k = (int)(((Rect)???).height() * 1.05D) / 4 * 4;
          paramCamera.Gl.left = (((Rect)???).left - (i - ((Rect)???).width()) / 2);
          paramCamera.Gl.top = (((Rect)???).top - (k - ((Rect)???).height()) / 2);
          paramCamera.Gl.right = (i + paramCamera.Gl.left);
          paramCamera.Gl.bottom = (k + paramCamera.Gl.top);
          if (j % 180 != 0)
          {
            k = (localPoint.y - paramCamera.Gl.height()) / 2;
            i = (localPoint.x - paramCamera.Gl.width()) / 2;
            if (com.tencent.mm.plugin.scanner.b.a.c.gQi()) {
              i = ((Rect)???).left;
            }
            paramCamera.Gl = new Rect(k, i, paramCamera.Gl.height() + k, paramCamera.Gl.width() + i);
          }
          Log.i("MicroMsg.LicenseCardDecodeQueue", "init cropRect %s", new Object[] { paramCamera.Gl });
          i = LibCardRecog.recognizeCardInit(paramCamera.Gl.width(), paramCamera.Gl.height(), paramCamera.nSq);
          Log.d("MicroMsg.LicenseCardDecodeQueue", "initRet %d, cropWidth %d, cropHeight %d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramCamera.Gl.width()), Integer.valueOf(paramCamera.Gl.height()) });
          if (i == 0)
          {
            bool = true;
            paramCamera.lYs = bool;
            if (!paramCamera.lYs) {}
          }
        }
      }
      synchronized (paramCamera.GXz)
      {
        paramCamera.OOo.clear();
        paramCamera.OOo.put("param_preview_data", paramArrayOfByte);
        paramCamera.OOo.put("param_camera_resolution", localPoint);
        paramCamera.OOo.put("param_camera_rotation", Integer.valueOf(j));
        if ((!paramCamera.OOw) && (paramCamera.OOu != 0L))
        {
          Log.i("MicroMsg.LicenseCardDecodeQueue", "%d submit decode license card", new Object[] { Long.valueOf(paramCamera.OOu) });
          paramCamera.OOq.execute(new com.tencent.mm.plugin.scanner.b.a.c.a(paramCamera, paramCamera.OOu));
        }
        if ((!((com.tencent.scanlib.a.a)this.ahwr).gSN()) && (com.tencent.mm.plugin.scanner.b.a.c.gQh().OOx > 10))
        {
          Log.i("MicroMsg.ScanCardRectView", "change to FOCUS_MODE_AUTO");
          this.ahwr.bFD("auto");
          Bb(100L);
        }
        AppMethodBeat.o(118402);
        return;
        paramArrayOfByte = finally;
        AppMethodBeat.o(118402);
        throw paramArrayOfByte;
        bool = false;
        continue;
        paramArrayOfByte = finally;
        AppMethodBeat.o(118402);
        throw paramArrayOfByte;
      }
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(118397);
    super.onResume();
    com.tencent.mm.plugin.scanner.b.a.b localb;
    long l;
    b.a locala;
    if (!this.ahwr.isOpen())
    {
      a(new b.b.a()
      {
        public final void gSY()
        {
          AppMethodBeat.i(118379);
          ScanCardRectView.this.a(new b.d.a()
          {
            public final void gSX()
            {
              AppMethodBeat.i(177499);
              ScanCardRectView.this.ua(0L);
              AppMethodBeat.o(177499);
            }
          });
          AppMethodBeat.o(118379);
        }
      });
      this.OOu = System.currentTimeMillis();
      if (this.mode != 7) {
        break label157;
      }
      localb = com.tencent.mm.plugin.scanner.b.a.b.gQg();
      l = this.OOu;
      locala = this.Pkz;
    }
    for (;;)
    {
      label157:
      synchronized (localb.GXz)
      {
        localb.OOu = l;
        localb.OOx = 0;
        localb.OOv = locala;
        this.PbB.dSf();
        AppMethodBeat.o(118397);
        return;
        if (!this.ahwr.boa())
        {
          a(new b.d.a()
          {
            public final void gSX()
            {
              AppMethodBeat.i(177500);
              ScanCardRectView.this.ua(0L);
              AppMethodBeat.o(177500);
            }
          });
          break;
        }
        ua(0L);
      }
      if (this.mode == 10) {
        if ((this.mode == 9) || (this.mode == 11)) {
          com.tencent.mm.plugin.scanner.b.a.c.gQh().a(1, this.OOu, this.PkA);
        } else if (this.mode == 10) {
          com.tencent.mm.plugin.scanner.b.a.c.gQh().a(2, this.OOu, this.PkA);
        }
      }
    }
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(118400);
    super.onStop();
    bty();
    if (this.OXj != null) {
      this.OXj.gTa();
    }
    ScanCameraLightDetector.Pio.stop();
    this.Pce.dead();
    this.OYl.dead();
    AppMethodBeat.o(118400);
  }
  
  public void setDecorRect(Rect paramRect)
  {
    AppMethodBeat.i(118395);
    this.PbB.setDecorRect(paramRect);
    this.Pkw.setCardRect(paramRect);
    AppMethodBeat.o(118395);
  }
  
  public void setMode(int paramInt)
  {
    this.mode = paramInt;
    this.OOu = 0L;
  }
  
  public void setScanCallback(ScanCardRectView.a parama)
  {
    this.Pkx = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.view.ScanCardRectView
 * JD-Core Version:    0.7.0.1
 */
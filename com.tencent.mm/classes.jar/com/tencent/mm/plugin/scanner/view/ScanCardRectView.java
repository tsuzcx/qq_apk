package com.tencent.mm.plugin.scanner.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.rp;
import com.tencent.mm.g.a.rq;
import com.tencent.mm.plugin.licence.model.LibCardRecog;
import com.tencent.mm.plugin.scanner.b.a.a.a;
import com.tencent.mm.plugin.scanner.b.a.b;
import com.tencent.mm.plugin.scanner.b.a.b.a;
import com.tencent.mm.plugin.scanner.b.a.b.b;
import com.tencent.mm.plugin.scanner.b.a.c.a;
import com.tencent.mm.plugin.scanner.b.a.c.b;
import com.tencent.mm.plugin.scanner.ui.ScannerFlashSwitcher;
import com.tencent.mm.plugin.scanner.util.ScanCameraLightDetector;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.qbar.WxQbarNative;
import com.tencent.scanlib.a.b.b.a;
import com.tencent.scanlib.a.b.d.a;
import com.tencent.scanlib.a.f;
import com.tencent.scanlib.ui.ScanView;
import java.util.Map;
import java.util.concurrent.ExecutorService;

public class ScanCardRectView
  extends ScanView
{
  private int mode;
  private long vNo;
  private ScannerFlashSwitcher vQG;
  private com.tencent.mm.sdk.b.c vRs;
  private ScanRectDecorView vUK;
  private com.tencent.mm.sdk.b.c<rq> vVi;
  private CardHighLightEdgeView wbH;
  private a wbI;
  private View wbJ;
  private a.a wbK;
  private b.a wbL;
  private c.b wbM;
  
  public ScanCardRectView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(118389);
    this.wbK = new a.a() {};
    this.wbL = new b.a()
    {
      public final void a(long paramAnonymousLong, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(118383);
        if (paramAnonymousLong == ScanCardRectView.a(ScanCardRectView.this))
        {
          ad.i("MicroMsg.ScanCardRectView", "bankcard decode success %s", new Object[] { Long.valueOf(ScanCardRectView.a(ScanCardRectView.this)) });
          ScanCardRectView.b(ScanCardRectView.this);
          if (ScanCardRectView.c(ScanCardRectView.this) != null) {
            ScanCardRectView.c(ScanCardRectView.this).e(paramAnonymousLong, paramAnonymousBundle);
          }
        }
        AppMethodBeat.o(118383);
      }
      
      public final void ag(long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(118382);
        if (paramAnonymousLong1 == ScanCardRectView.a(ScanCardRectView.this)) {
          ScanCardRectView.this.sb(paramAnonymousLong2);
        }
        AppMethodBeat.o(118382);
      }
    };
    this.wbM = new c.b()
    {
      public final void a(long paramAnonymousLong, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(177502);
        if (paramAnonymousLong == ScanCardRectView.a(ScanCardRectView.this))
        {
          ad.i("MicroMsg.ScanCardRectView", "license decode success %s", new Object[] { Long.valueOf(ScanCardRectView.a(ScanCardRectView.this)) });
          ScanCardRectView.b(ScanCardRectView.this);
          if (ScanCardRectView.c(ScanCardRectView.this) != null) {
            ScanCardRectView.c(ScanCardRectView.this).e(paramAnonymousLong, paramAnonymousBundle);
          }
        }
        AppMethodBeat.o(177502);
      }
      
      public final void ag(long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(177501);
        if (paramAnonymousLong1 == ScanCardRectView.a(ScanCardRectView.this)) {
          ScanCardRectView.this.sb(paramAnonymousLong2);
        }
        AppMethodBeat.o(177501);
      }
      
      public final void b(long paramAnonymousLong, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(177503);
        if ((paramAnonymousLong == ScanCardRectView.a(ScanCardRectView.this)) && (paramAnonymousBundle.containsKey("param_card_edge"))) {
          ScanCardRectView.d(ScanCardRectView.this).setHighLightEdges(paramAnonymousBundle.getBooleanArray("param_card_edge"));
        }
        AppMethodBeat.o(177503);
      }
    };
    this.vRs = new com.tencent.mm.sdk.b.c() {};
    this.vVi = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(118389);
  }
  
  public ScanCardRectView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(118390);
    this.wbK = new a.a() {};
    this.wbL = new b.a()
    {
      public final void a(long paramAnonymousLong, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(118383);
        if (paramAnonymousLong == ScanCardRectView.a(ScanCardRectView.this))
        {
          ad.i("MicroMsg.ScanCardRectView", "bankcard decode success %s", new Object[] { Long.valueOf(ScanCardRectView.a(ScanCardRectView.this)) });
          ScanCardRectView.b(ScanCardRectView.this);
          if (ScanCardRectView.c(ScanCardRectView.this) != null) {
            ScanCardRectView.c(ScanCardRectView.this).e(paramAnonymousLong, paramAnonymousBundle);
          }
        }
        AppMethodBeat.o(118383);
      }
      
      public final void ag(long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(118382);
        if (paramAnonymousLong1 == ScanCardRectView.a(ScanCardRectView.this)) {
          ScanCardRectView.this.sb(paramAnonymousLong2);
        }
        AppMethodBeat.o(118382);
      }
    };
    this.wbM = new c.b()
    {
      public final void a(long paramAnonymousLong, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(177502);
        if (paramAnonymousLong == ScanCardRectView.a(ScanCardRectView.this))
        {
          ad.i("MicroMsg.ScanCardRectView", "license decode success %s", new Object[] { Long.valueOf(ScanCardRectView.a(ScanCardRectView.this)) });
          ScanCardRectView.b(ScanCardRectView.this);
          if (ScanCardRectView.c(ScanCardRectView.this) != null) {
            ScanCardRectView.c(ScanCardRectView.this).e(paramAnonymousLong, paramAnonymousBundle);
          }
        }
        AppMethodBeat.o(177502);
      }
      
      public final void ag(long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(177501);
        if (paramAnonymousLong1 == ScanCardRectView.a(ScanCardRectView.this)) {
          ScanCardRectView.this.sb(paramAnonymousLong2);
        }
        AppMethodBeat.o(177501);
      }
      
      public final void b(long paramAnonymousLong, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(177503);
        if ((paramAnonymousLong == ScanCardRectView.a(ScanCardRectView.this)) && (paramAnonymousBundle.containsKey("param_card_edge"))) {
          ScanCardRectView.d(ScanCardRectView.this).setHighLightEdges(paramAnonymousBundle.getBooleanArray("param_card_edge"));
        }
        AppMethodBeat.o(177503);
      }
    };
    this.vRs = new com.tencent.mm.sdk.b.c() {};
    this.vVi = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(118390);
  }
  
  public ScanCardRectView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(118391);
    this.wbK = new a.a() {};
    this.wbL = new b.a()
    {
      public final void a(long paramAnonymousLong, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(118383);
        if (paramAnonymousLong == ScanCardRectView.a(ScanCardRectView.this))
        {
          ad.i("MicroMsg.ScanCardRectView", "bankcard decode success %s", new Object[] { Long.valueOf(ScanCardRectView.a(ScanCardRectView.this)) });
          ScanCardRectView.b(ScanCardRectView.this);
          if (ScanCardRectView.c(ScanCardRectView.this) != null) {
            ScanCardRectView.c(ScanCardRectView.this).e(paramAnonymousLong, paramAnonymousBundle);
          }
        }
        AppMethodBeat.o(118383);
      }
      
      public final void ag(long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(118382);
        if (paramAnonymousLong1 == ScanCardRectView.a(ScanCardRectView.this)) {
          ScanCardRectView.this.sb(paramAnonymousLong2);
        }
        AppMethodBeat.o(118382);
      }
    };
    this.wbM = new c.b()
    {
      public final void a(long paramAnonymousLong, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(177502);
        if (paramAnonymousLong == ScanCardRectView.a(ScanCardRectView.this))
        {
          ad.i("MicroMsg.ScanCardRectView", "license decode success %s", new Object[] { Long.valueOf(ScanCardRectView.a(ScanCardRectView.this)) });
          ScanCardRectView.b(ScanCardRectView.this);
          if (ScanCardRectView.c(ScanCardRectView.this) != null) {
            ScanCardRectView.c(ScanCardRectView.this).e(paramAnonymousLong, paramAnonymousBundle);
          }
        }
        AppMethodBeat.o(177502);
      }
      
      public final void ag(long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(177501);
        if (paramAnonymousLong1 == ScanCardRectView.a(ScanCardRectView.this)) {
          ScanCardRectView.this.sb(paramAnonymousLong2);
        }
        AppMethodBeat.o(177501);
      }
      
      public final void b(long paramAnonymousLong, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(177503);
        if ((paramAnonymousLong == ScanCardRectView.a(ScanCardRectView.this)) && (paramAnonymousBundle.containsKey("param_card_edge"))) {
          ScanCardRectView.d(ScanCardRectView.this).setHighLightEdges(paramAnonymousBundle.getBooleanArray("param_card_edge"));
        }
        AppMethodBeat.o(177503);
      }
    };
    this.vRs = new com.tencent.mm.sdk.b.c() {};
    this.vVi = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(118391);
  }
  
  private void dlN()
  {
    AppMethodBeat.i(118404);
    this.vQG = ((ScannerFlashSwitcher)this.wbJ.findViewById(2131304345));
    if (this.vQG != null) {
      this.vQG.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(177504);
          if (!ScanCardRectView.e(ScanCardRectView.this).SE)
          {
            paramAnonymousView = new rq();
            paramAnonymousView.dxj.dbV = 1;
            com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousView);
            ScanCardRectView.e(ScanCardRectView.this).dmE();
            AppMethodBeat.o(177504);
            return;
          }
          paramAnonymousView = new rq();
          paramAnonymousView.dxj.dbV = 2;
          com.tencent.mm.sdk.b.a.ESL.l(paramAnonymousView);
          ScanCardRectView.e(ScanCardRectView.this).dmF();
          AppMethodBeat.o(177504);
        }
      });
    }
    com.tencent.mm.sdk.b.a.ESL.c(this.vRs);
    com.tencent.mm.sdk.b.a.ESL.c(this.vVi);
    aq.n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(177505);
        ScanCameraLightDetector.wap.start(((com.tencent.mm.plugin.scanner.a.a)ScanCardRectView.f(ScanCardRectView.this)).getFocusMode());
        AppMethodBeat.o(177505);
      }
    }, 300L);
    AppMethodBeat.o(118404);
  }
  
  private void dmt()
  {
    AppMethodBeat.i(118398);
    b.dll().release();
    com.tencent.mm.plugin.scanner.b.a.c localc = com.tencent.mm.plugin.scanner.b.a.c.dlm();
    long l = this.vNo;
    synchronized (localc.vNi)
    {
      if (localc.vNo == l)
      {
        localc.vNo = 0L;
        localc.vNr = 0;
        localc.vNw = null;
        localc.vNh.clear();
      }
      this.vNo = 0L;
      AppMethodBeat.o(118398);
      return;
    }
  }
  
  public final void dmr()
  {
    AppMethodBeat.i(118393);
    this.ItZ = new com.tencent.mm.plugin.scanner.a.a();
    AppMethodBeat.o(118393);
  }
  
  public Rect getDecorRect()
  {
    AppMethodBeat.i(118394);
    Rect localRect = this.vUK.getDecorRect();
    AppMethodBeat.o(118394);
    return localRect;
  }
  
  public final void init()
  {
    AppMethodBeat.i(118392);
    super.init();
    this.wbH = new CardHighLightEdgeView(getContext());
    addView(this.wbH, new FrameLayout.LayoutParams(-1, -1));
    this.vUK = new ScanRectDecorView(getContext());
    addView(this.vUK, new FrameLayout.LayoutParams(-1, -1));
    AppMethodBeat.o(118392);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(118396);
    super.onAttachedToWindow();
    Point localPoint = new Point();
    getDisplay().getSize(localPoint);
    ad.i("MicroMsg.ScanCardRectView", "screenSize %s", new Object[] { localPoint });
    if (this.wbJ != null) {
      removeView(this.wbJ);
    }
    switch (this.mode)
    {
    case 8: 
    default: 
      ad.e("MicroMsg.ScanCardRectView", "unknown mode!");
      AppMethodBeat.o(118396);
      return;
    case 7: 
      this.wbJ = View.inflate(getContext(), 2131495287, null);
      localObject = bt.by(((Activity)getContext()).getIntent().getStringExtra("bank_card_owner"), "");
      String str = String.format(getContext().getResources().getString(2131762798), new Object[] { localObject });
      View localView = this.wbJ.findViewById(2131306001);
      if (bt.isNullOrNil((String)localObject)) {
        localView.setVisibility(4);
      }
      for (;;)
      {
        addView(this.wbJ, new FrameLayout.LayoutParams(-1, -1));
        localObject = new Rect();
        ((Rect)localObject).left = com.tencent.mm.cd.a.fromDPToPix(getContext(), 40);
        ((Rect)localObject).right = (localPoint.x - com.tencent.mm.cd.a.fromDPToPix(getContext(), 40));
        ((Rect)localObject).top = ((localPoint.y - (int)(((Rect)localObject).width() / 1.586F)) / 2);
        ((Rect)localObject).bottom = (((Rect)localObject).top + (int)(((Rect)localObject).width() / 1.586F));
        ad.i("MicroMsg.ScanCardRectView", "scan bank card rect %s", new Object[] { localObject });
        this.vUK.gT(((Rect)localObject).width(), ((Rect)localObject).height());
        this.wbH.setCardRect((Rect)localObject);
        dlN();
        AppMethodBeat.o(118396);
        return;
        ((TextView)this.wbJ.findViewById(2131297118)).setText(str);
        this.wbJ.findViewById(2131297114).setOnClickListener(new ScanCardRectView.1(this));
        localView.setVisibility(0);
      }
    case 9: 
    case 11: 
      localObject = new Rect();
      ((Rect)localObject).left = com.tencent.mm.cd.a.fromDPToPix(getContext(), 40);
      ((Rect)localObject).right = (localPoint.x - com.tencent.mm.cd.a.fromDPToPix(getContext(), 40));
      ((Rect)localObject).top = ((localPoint.y - (int)(((Rect)localObject).width() / 1.586F)) / 2);
      ((Rect)localObject).bottom = (((Rect)localObject).top + (int)(((Rect)localObject).width() / 1.586F));
      ad.i("MicroMsg.ScanCardRectView", "scan id card rect %s", new Object[] { localObject });
      this.vUK.gT(((Rect)localObject).width(), ((Rect)localObject).height());
      this.wbH.setCardRect((Rect)localObject);
      this.wbJ = View.inflate(getContext(), 2131495296, null);
      addView(this.wbJ, new FrameLayout.LayoutParams(-1, -1));
      ((TextView)this.wbJ.findViewById(2131297474)).setText(getContext().getResources().getString(2131762830, new Object[] { getContext().getResources().getString(2131762805) }));
      dlN();
      AppMethodBeat.o(118396);
      return;
    }
    Object localObject = new Rect();
    ((Rect)localObject).left = com.tencent.mm.cd.a.fromDPToPix(getContext(), 40);
    ((Rect)localObject).right = (localPoint.x - com.tencent.mm.cd.a.fromDPToPix(getContext(), 40));
    ((Rect)localObject).top = ((localPoint.y - (int)(((Rect)localObject).width() / 1.467F)) / 2);
    ((Rect)localObject).bottom = (((Rect)localObject).top + (int)(((Rect)localObject).width() / 1.467F));
    ad.i("MicroMsg.ScanCardRectView", "scan driver card rect %s", new Object[] { localObject });
    this.vUK.gT(((Rect)localObject).width(), ((Rect)localObject).height());
    this.wbH.setCardRect((Rect)localObject);
    this.wbJ = View.inflate(getContext(), 2131495296, null);
    addView(this.wbJ, new FrameLayout.LayoutParams(-1, -1));
    ((TextView)this.wbJ.findViewById(2131297474)).setText("");
    dlN();
    AppMethodBeat.o(118396);
  }
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    AppMethodBeat.i(118403);
    ad.i("MicroMsg.ScanCardRectView", "onAutoFocus %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      sb(0L);
    }
    xh(Iuc);
    AppMethodBeat.o(118403);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(118401);
    super.onDestroy();
    b.dll().release();
    com.tencent.mm.plugin.scanner.b.a.c.dlm().release();
    AppMethodBeat.o(118401);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(118399);
    super.onPause();
    dmt();
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
      ad.i("MicroMsg.ScanCardRectView", bool);
      if ((this.ItZ.cPP()) && (((com.tencent.mm.plugin.scanner.a.a)this.ItZ).dlj())) {
        ScanCameraLightDetector.wap.B(paramArrayOfByte, ((com.tencent.mm.plugin.scanner.a.a)this.ItZ).fmC().x, ((com.tencent.mm.plugin.scanner.a.a)this.ItZ).fmC().y);
      }
      if (this.mode == 7)
      {
        ??? = ((com.tencent.scanlib.a.a)this.ItZ).t(getDecorRect());
        paramCamera = b.dll();
        localPoint = this.ItZ.fmC();
        i = this.ItZ.getCameraRotation();
        synchronized (paramCamera.vNi)
        {
          if ((((Rect)???).width() != paramCamera.vNl.width()) || (((Rect)???).height() != paramCamera.vNl.height())) {}
          synchronized (paramCamera.vNj)
          {
            if (paramCamera.fFP) {
              WxQbarNative.focusedEngineRelease();
            }
            paramCamera.fFP = false;
            ad.i("MicroMsg.BankCardDetectQueue", "resolution %s, rotation %d, rect %s", new Object[] { localPoint, Integer.valueOf(i), ??? });
            if (!paramCamera.fFP) {}
            synchronized (paramCamera.vNj)
            {
              ad.i("MicroMsg.BankCardDetectQueue", "rect %s", new Object[] { ??? });
              paramCamera.vNl = ((Rect)???);
              j = (int)(((Rect)???).width() * b.vNg);
              k = (int)(((Rect)???).height() * b.vNg);
              paramCamera.gtE.left = (((Rect)???).left - (j - ((Rect)???).width()) / 2);
              paramCamera.gtE.top = (((Rect)???).top - (k - ((Rect)???).height()) / 2);
              paramCamera.gtE.right = (paramCamera.gtE.left + j);
              paramCamera.gtE.bottom = (paramCamera.gtE.top + k);
              ad.i("MicroMsg.BankCardDetectQueue", "cropRect %s", new Object[] { paramCamera.gtE });
              if (WxQbarNative.focusedEngineForBankcardInit(j, k, 8, false) == 0)
              {
                bool = true;
                label434:
                paramCamera.fFP = bool;
                if (!paramCamera.fFP) {}
              }
            }
          }
        }
        synchronized (paramCamera.vNi)
        {
          paramCamera.vNh.clear();
          paramCamera.vNh.put("param_preview_data", paramArrayOfByte);
          paramCamera.vNh.put("param_camera_resolution", localPoint);
          paramCamera.vNh.put("param_camera_rotation", Integer.valueOf(i));
          if ((!paramCamera.vNq) && (paramCamera.vNo != 0L))
          {
            ad.i("MicroMsg.BankCardDetectQueue", "%d submit decode bankcard", new Object[] { Long.valueOf(paramCamera.vNo) });
            paramCamera.vNn.execute(new b.b(paramCamera, paramCamera.vNo));
          }
          if ((!((com.tencent.scanlib.a.a)this.ItZ).dms()) && (b.dll().vNr > 10))
          {
            ad.i("MicroMsg.ScanCardRectView", "change to FOCUS_MODE_AUTO");
            this.ItZ.setFocusMode("auto");
            xh(100L);
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
          break label434;
          paramArrayOfByte = finally;
          AppMethodBeat.o(118402);
          throw paramArrayOfByte;
        }
      }
    }
    if (this.mode == 11)
    {
      ??? = ((com.tencent.scanlib.a.a)this.ItZ).t(getDecorRect());
      paramCamera = com.tencent.mm.plugin.scanner.b.a.c.dlm();
      localPoint = this.ItZ.fmC();
      i = this.ItZ.getCameraRotation();
    }
    for (;;)
    {
      synchronized (paramCamera.vNi)
      {
        if ((((Rect)???).width() != paramCamera.vNl.width()) || (((Rect)???).height() != paramCamera.vNl.height()))
        {
          paramCamera.release();
          paramCamera.fFP = false;
        }
        if (!paramCamera.fFP) {}
        synchronized (paramCamera.vNj)
        {
          paramCamera.vNl = ((Rect)???);
          j = (int)(((Rect)???).width() * 1.05D) / 4 * 4;
          k = (int)(((Rect)???).height() * 1.05D) / 4 * 4;
          paramCamera.gtE.left = (((Rect)???).left - (j - ((Rect)???).width()) / 2);
          paramCamera.gtE.top = (((Rect)???).top - (k - ((Rect)???).height()) / 2);
          paramCamera.gtE.right = (j + paramCamera.gtE.left);
          paramCamera.gtE.bottom = (paramCamera.gtE.top + k);
          if (i % 180 != 0)
          {
            j = (localPoint.y - paramCamera.gtE.height()) / 2;
            k = (localPoint.x - paramCamera.gtE.width()) / 2;
            paramCamera.gtE = new Rect(j, k, paramCamera.gtE.height() + j, paramCamera.gtE.width() + k);
          }
          ad.i("MicroMsg.LicenseCardDecodeQueue", "init cropRect %s", new Object[] { paramCamera.gtE });
          j = LibCardRecog.recognizeCardInit(paramCamera.gtE.width(), paramCamera.gtE.height(), paramCamera.gIt);
          ad.d("MicroMsg.LicenseCardDecodeQueue", "initRet %d, cropWidth %d, cropHeight %d", new Object[] { Integer.valueOf(j), Integer.valueOf(paramCamera.gtE.width()), Integer.valueOf(paramCamera.gtE.height()) });
          if (j == 0)
          {
            bool = true;
            paramCamera.fFP = bool;
            if (!paramCamera.fFP) {}
          }
        }
      }
      synchronized (paramCamera.vNi)
      {
        paramCamera.vNh.clear();
        paramCamera.vNh.put("param_preview_data", paramArrayOfByte);
        paramCamera.vNh.put("param_camera_resolution", localPoint);
        paramCamera.vNh.put("param_camera_rotation", Integer.valueOf(i));
        if ((!paramCamera.vNq) && (paramCamera.vNo != 0L))
        {
          ad.i("MicroMsg.LicenseCardDecodeQueue", "%d submit decode license card", new Object[] { Long.valueOf(paramCamera.vNo) });
          paramCamera.vNk.execute(new c.a(paramCamera, paramCamera.vNo));
        }
        if ((!((com.tencent.scanlib.a.a)this.ItZ).dms()) && (com.tencent.mm.plugin.scanner.b.a.c.dlm().vNr > 10))
        {
          ad.i("MicroMsg.ScanCardRectView", "change to FOCUS_MODE_AUTO");
          this.ItZ.setFocusMode("auto");
          xh(100L);
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
    b localb;
    long l;
    b.a locala;
    if (!this.ItZ.isOpen())
    {
      a(new b.b.a()
      {
        public final void dmD()
        {
          AppMethodBeat.i(118379);
          ScanCardRectView.this.a(new b.d.a()
          {
            public final void dmC()
            {
              AppMethodBeat.i(177499);
              ScanCardRectView.this.sb(0L);
              AppMethodBeat.o(177499);
            }
          });
          AppMethodBeat.o(118379);
        }
      });
      this.vNo = System.currentTimeMillis();
      if (this.mode != 7) {
        break label157;
      }
      localb = b.dll();
      l = this.vNo;
      locala = this.wbL;
    }
    for (;;)
    {
      synchronized (localb.vNi)
      {
        localb.vNo = l;
        localb.vNr = 0;
        localb.vNp = locala;
        this.vUK.cjm();
        AppMethodBeat.o(118397);
        return;
        if (!this.ItZ.cPP())
        {
          a(new b.d.a()
          {
            public final void dmC()
            {
              AppMethodBeat.i(177500);
              ScanCardRectView.this.sb(0L);
              AppMethodBeat.o(177500);
            }
          });
          break;
        }
        sb(0L);
      }
      label157:
      if ((this.mode == 9) || (this.mode == 11) || (this.mode == 10)) {
        if ((this.mode == 9) || (this.mode == 11)) {
          com.tencent.mm.plugin.scanner.b.a.c.dlm().a(1, this.vNo, this.wbM);
        } else if (this.mode == 10) {
          com.tencent.mm.plugin.scanner.b.a.c.dlm().a(2, this.vNo, this.wbM);
        }
      }
    }
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(118400);
    super.onStop();
    anq();
    if (this.vQG != null) {
      this.vQG.dmF();
    }
    ScanCameraLightDetector.wap.stop();
    com.tencent.mm.sdk.b.a.ESL.d(this.vVi);
    com.tencent.mm.sdk.b.a.ESL.d(this.vRs);
    AppMethodBeat.o(118400);
  }
  
  public void setDecorRect(Rect paramRect)
  {
    AppMethodBeat.i(118395);
    this.vUK.setDecorRect(paramRect);
    this.wbH.setCardRect(paramRect);
    AppMethodBeat.o(118395);
  }
  
  public void setMode(int paramInt)
  {
    this.mode = paramInt;
    this.vNo = 0L;
  }
  
  public void setScanCallback(a parama)
  {
    this.wbI = parama;
  }
  
  public static abstract interface a
  {
    public abstract void e(long paramLong, Bundle paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.view.ScanCardRectView
 * JD-Core Version:    0.7.0.1
 */
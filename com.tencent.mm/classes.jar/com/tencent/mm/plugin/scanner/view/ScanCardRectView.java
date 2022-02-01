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
import com.tencent.mm.g.a.ry;
import com.tencent.mm.g.a.rz;
import com.tencent.mm.plugin.licence.model.LibCardRecog;
import com.tencent.mm.plugin.scanner.b.a.a.a;
import com.tencent.mm.plugin.scanner.b.a.b;
import com.tencent.mm.plugin.scanner.b.a.b.a;
import com.tencent.mm.plugin.scanner.b.a.b.b;
import com.tencent.mm.plugin.scanner.b.a.c.a;
import com.tencent.mm.plugin.scanner.b.a.c.b;
import com.tencent.mm.plugin.scanner.ui.ScannerFlashSwitcher;
import com.tencent.mm.plugin.scanner.util.ScanCameraLightDetector;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
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
  private long wXJ;
  private ScannerFlashSwitcher xbo;
  private com.tencent.mm.sdk.b.c xcd;
  private com.tencent.mm.sdk.b.c<rz> xfT;
  private ScanRectDecorView xfv;
  private CardHighLightEdgeView xmO;
  private a xmP;
  private View xmQ;
  private a.a xmR;
  private b.a xmS;
  private c.b xmT;
  
  public ScanCardRectView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(118389);
    this.xmR = new a.a() {};
    this.xmS = new b.a()
    {
      public final void a(long paramAnonymousLong, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(118383);
        if (paramAnonymousLong == ScanCardRectView.a(ScanCardRectView.this))
        {
          ac.i("MicroMsg.ScanCardRectView", "bankcard decode success %s", new Object[] { Long.valueOf(ScanCardRectView.a(ScanCardRectView.this)) });
          ScanCardRectView.b(ScanCardRectView.this);
          if (ScanCardRectView.c(ScanCardRectView.this) != null) {
            ScanCardRectView.c(ScanCardRectView.this).e(paramAnonymousLong, paramAnonymousBundle);
          }
        }
        AppMethodBeat.o(118383);
      }
      
      public final void ad(long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(118382);
        if (paramAnonymousLong1 == ScanCardRectView.a(ScanCardRectView.this)) {
          ScanCardRectView.this.wE(paramAnonymousLong2);
        }
        AppMethodBeat.o(118382);
      }
    };
    this.xmT = new c.b()
    {
      public final void a(long paramAnonymousLong, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(177502);
        if (paramAnonymousLong == ScanCardRectView.a(ScanCardRectView.this))
        {
          ac.i("MicroMsg.ScanCardRectView", "license decode success %s", new Object[] { Long.valueOf(ScanCardRectView.a(ScanCardRectView.this)) });
          ScanCardRectView.b(ScanCardRectView.this);
          if (ScanCardRectView.c(ScanCardRectView.this) != null) {
            ScanCardRectView.c(ScanCardRectView.this).e(paramAnonymousLong, paramAnonymousBundle);
          }
        }
        AppMethodBeat.o(177502);
      }
      
      public final void ad(long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(177501);
        if (paramAnonymousLong1 == ScanCardRectView.a(ScanCardRectView.this)) {
          ScanCardRectView.this.wE(paramAnonymousLong2);
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
    this.xcd = new com.tencent.mm.sdk.b.c() {};
    this.xfT = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(118389);
  }
  
  public ScanCardRectView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(118390);
    this.xmR = new a.a() {};
    this.xmS = new b.a()
    {
      public final void a(long paramAnonymousLong, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(118383);
        if (paramAnonymousLong == ScanCardRectView.a(ScanCardRectView.this))
        {
          ac.i("MicroMsg.ScanCardRectView", "bankcard decode success %s", new Object[] { Long.valueOf(ScanCardRectView.a(ScanCardRectView.this)) });
          ScanCardRectView.b(ScanCardRectView.this);
          if (ScanCardRectView.c(ScanCardRectView.this) != null) {
            ScanCardRectView.c(ScanCardRectView.this).e(paramAnonymousLong, paramAnonymousBundle);
          }
        }
        AppMethodBeat.o(118383);
      }
      
      public final void ad(long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(118382);
        if (paramAnonymousLong1 == ScanCardRectView.a(ScanCardRectView.this)) {
          ScanCardRectView.this.wE(paramAnonymousLong2);
        }
        AppMethodBeat.o(118382);
      }
    };
    this.xmT = new c.b()
    {
      public final void a(long paramAnonymousLong, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(177502);
        if (paramAnonymousLong == ScanCardRectView.a(ScanCardRectView.this))
        {
          ac.i("MicroMsg.ScanCardRectView", "license decode success %s", new Object[] { Long.valueOf(ScanCardRectView.a(ScanCardRectView.this)) });
          ScanCardRectView.b(ScanCardRectView.this);
          if (ScanCardRectView.c(ScanCardRectView.this) != null) {
            ScanCardRectView.c(ScanCardRectView.this).e(paramAnonymousLong, paramAnonymousBundle);
          }
        }
        AppMethodBeat.o(177502);
      }
      
      public final void ad(long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(177501);
        if (paramAnonymousLong1 == ScanCardRectView.a(ScanCardRectView.this)) {
          ScanCardRectView.this.wE(paramAnonymousLong2);
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
    this.xcd = new com.tencent.mm.sdk.b.c() {};
    this.xfT = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(118390);
  }
  
  public ScanCardRectView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(118391);
    this.xmR = new a.a() {};
    this.xmS = new b.a()
    {
      public final void a(long paramAnonymousLong, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(118383);
        if (paramAnonymousLong == ScanCardRectView.a(ScanCardRectView.this))
        {
          ac.i("MicroMsg.ScanCardRectView", "bankcard decode success %s", new Object[] { Long.valueOf(ScanCardRectView.a(ScanCardRectView.this)) });
          ScanCardRectView.b(ScanCardRectView.this);
          if (ScanCardRectView.c(ScanCardRectView.this) != null) {
            ScanCardRectView.c(ScanCardRectView.this).e(paramAnonymousLong, paramAnonymousBundle);
          }
        }
        AppMethodBeat.o(118383);
      }
      
      public final void ad(long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(118382);
        if (paramAnonymousLong1 == ScanCardRectView.a(ScanCardRectView.this)) {
          ScanCardRectView.this.wE(paramAnonymousLong2);
        }
        AppMethodBeat.o(118382);
      }
    };
    this.xmT = new c.b()
    {
      public final void a(long paramAnonymousLong, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(177502);
        if (paramAnonymousLong == ScanCardRectView.a(ScanCardRectView.this))
        {
          ac.i("MicroMsg.ScanCardRectView", "license decode success %s", new Object[] { Long.valueOf(ScanCardRectView.a(ScanCardRectView.this)) });
          ScanCardRectView.b(ScanCardRectView.this);
          if (ScanCardRectView.c(ScanCardRectView.this) != null) {
            ScanCardRectView.c(ScanCardRectView.this).e(paramAnonymousLong, paramAnonymousBundle);
          }
        }
        AppMethodBeat.o(177502);
      }
      
      public final void ad(long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(177501);
        if (paramAnonymousLong1 == ScanCardRectView.a(ScanCardRectView.this)) {
          ScanCardRectView.this.wE(paramAnonymousLong2);
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
    this.xcd = new com.tencent.mm.sdk.b.c() {};
    this.xfT = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(118391);
  }
  
  private void dAz()
  {
    AppMethodBeat.i(118398);
    b.dzn().release();
    com.tencent.mm.plugin.scanner.b.a.c localc = com.tencent.mm.plugin.scanner.b.a.c.dzo();
    long l = this.wXJ;
    synchronized (localc.wXD)
    {
      if (localc.wXJ == l)
      {
        localc.wXJ = 0L;
        localc.wXM = 0;
        localc.wXR = null;
        localc.wXC.clear();
      }
      this.wXJ = 0L;
      AppMethodBeat.o(118398);
      return;
    }
  }
  
  private void dzT()
  {
    AppMethodBeat.i(118404);
    this.xbo = ((ScannerFlashSwitcher)this.xmQ.findViewById(2131304345));
    if (this.xbo != null) {
      this.xbo.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(177504);
          if (!ScanCardRectView.e(ScanCardRectView.this).Tz)
          {
            paramAnonymousView = new rz();
            paramAnonymousView.duW.cZu = 1;
            com.tencent.mm.sdk.b.a.GpY.l(paramAnonymousView);
            ScanCardRectView.e(ScanCardRectView.this).dAK();
            AppMethodBeat.o(177504);
            return;
          }
          paramAnonymousView = new rz();
          paramAnonymousView.duW.cZu = 2;
          com.tencent.mm.sdk.b.a.GpY.l(paramAnonymousView);
          ScanCardRectView.e(ScanCardRectView.this).dAL();
          AppMethodBeat.o(177504);
        }
      });
    }
    com.tencent.mm.sdk.b.a.GpY.c(this.xcd);
    com.tencent.mm.sdk.b.a.GpY.c(this.xfT);
    ap.n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(177505);
        ScanCameraLightDetector.xlv.start(((com.tencent.mm.plugin.scanner.a.a)ScanCardRectView.f(ScanCardRectView.this)).getFocusMode());
        AppMethodBeat.o(177505);
      }
    }, 300L);
    AppMethodBeat.o(118404);
  }
  
  public final void dAx()
  {
    AppMethodBeat.i(118393);
    this.JVI = new com.tencent.mm.plugin.scanner.a.a();
    AppMethodBeat.o(118393);
  }
  
  public Rect getDecorRect()
  {
    AppMethodBeat.i(118394);
    Rect localRect = this.xfv.getDecorRect();
    AppMethodBeat.o(118394);
    return localRect;
  }
  
  public final void init()
  {
    AppMethodBeat.i(118392);
    super.init();
    this.xmO = new CardHighLightEdgeView(getContext());
    addView(this.xmO, new FrameLayout.LayoutParams(-1, -1));
    this.xfv = new ScanRectDecorView(getContext());
    addView(this.xfv, new FrameLayout.LayoutParams(-1, -1));
    AppMethodBeat.o(118392);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(118396);
    super.onAttachedToWindow();
    Point localPoint = new Point();
    getDisplay().getSize(localPoint);
    ac.i("MicroMsg.ScanCardRectView", "screenSize %s", new Object[] { localPoint });
    if (this.xmQ != null) {
      removeView(this.xmQ);
    }
    switch (this.mode)
    {
    case 8: 
    default: 
      ac.e("MicroMsg.ScanCardRectView", "unknown mode!");
      AppMethodBeat.o(118396);
      return;
    case 7: 
      this.xmQ = View.inflate(getContext(), 2131495287, null);
      localObject = bs.bG(((Activity)getContext()).getIntent().getStringExtra("bank_card_owner"), "");
      String str = String.format(getContext().getResources().getString(2131762798), new Object[] { localObject });
      View localView = this.xmQ.findViewById(2131306001);
      if (bs.isNullOrNil((String)localObject)) {
        localView.setVisibility(4);
      }
      for (;;)
      {
        addView(this.xmQ, new FrameLayout.LayoutParams(-1, -1));
        localObject = new Rect();
        ((Rect)localObject).left = com.tencent.mm.cc.a.fromDPToPix(getContext(), 40);
        ((Rect)localObject).right = (localPoint.x - com.tencent.mm.cc.a.fromDPToPix(getContext(), 40));
        ((Rect)localObject).top = ((localPoint.y - (int)(((Rect)localObject).width() / 1.586F)) / 2);
        ((Rect)localObject).bottom = (((Rect)localObject).top + (int)(((Rect)localObject).width() / 1.586F));
        ac.i("MicroMsg.ScanCardRectView", "scan bank card rect %s", new Object[] { localObject });
        this.xfv.hc(((Rect)localObject).width(), ((Rect)localObject).height());
        this.xmO.setCardRect((Rect)localObject);
        dzT();
        AppMethodBeat.o(118396);
        return;
        ((TextView)this.xmQ.findViewById(2131297118)).setText(str);
        this.xmQ.findViewById(2131297114).setOnClickListener(new ScanCardRectView.1(this));
        localView.setVisibility(0);
      }
    case 9: 
    case 11: 
      localObject = new Rect();
      ((Rect)localObject).left = com.tencent.mm.cc.a.fromDPToPix(getContext(), 40);
      ((Rect)localObject).right = (localPoint.x - com.tencent.mm.cc.a.fromDPToPix(getContext(), 40));
      ((Rect)localObject).top = ((localPoint.y - (int)(((Rect)localObject).width() / 1.586F)) / 2);
      ((Rect)localObject).bottom = (((Rect)localObject).top + (int)(((Rect)localObject).width() / 1.586F));
      ac.i("MicroMsg.ScanCardRectView", "scan id card rect %s", new Object[] { localObject });
      this.xfv.hc(((Rect)localObject).width(), ((Rect)localObject).height());
      this.xmO.setCardRect((Rect)localObject);
      this.xmQ = View.inflate(getContext(), 2131495296, null);
      addView(this.xmQ, new FrameLayout.LayoutParams(-1, -1));
      ((TextView)this.xmQ.findViewById(2131297474)).setText(getContext().getResources().getString(2131762830, new Object[] { getContext().getResources().getString(2131762805) }));
      dzT();
      AppMethodBeat.o(118396);
      return;
    }
    Object localObject = new Rect();
    ((Rect)localObject).left = com.tencent.mm.cc.a.fromDPToPix(getContext(), 40);
    ((Rect)localObject).right = (localPoint.x - com.tencent.mm.cc.a.fromDPToPix(getContext(), 40));
    ((Rect)localObject).top = ((localPoint.y - (int)(((Rect)localObject).width() / 1.467F)) / 2);
    ((Rect)localObject).bottom = (((Rect)localObject).top + (int)(((Rect)localObject).width() / 1.467F));
    ac.i("MicroMsg.ScanCardRectView", "scan driver card rect %s", new Object[] { localObject });
    this.xfv.hc(((Rect)localObject).width(), ((Rect)localObject).height());
    this.xmO.setCardRect((Rect)localObject);
    this.xmQ = View.inflate(getContext(), 2131495296, null);
    addView(this.xmQ, new FrameLayout.LayoutParams(-1, -1));
    ((TextView)this.xmQ.findViewById(2131297474)).setText("");
    dzT();
    AppMethodBeat.o(118396);
  }
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    AppMethodBeat.i(118403);
    ac.i("MicroMsg.ScanCardRectView", "onAutoFocus %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      wE(0L);
    }
    BR(JVL);
    AppMethodBeat.o(118403);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(118401);
    super.onDestroy();
    b.dzn().release();
    com.tencent.mm.plugin.scanner.b.a.c.dzo().release();
    AppMethodBeat.o(118401);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(118399);
    super.onPause();
    dAz();
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
      ac.i("MicroMsg.ScanCardRectView", bool);
      if ((this.JVI.cDz()) && (((com.tencent.mm.plugin.scanner.a.a)this.JVI).dzl())) {
        ScanCameraLightDetector.xlv.A(paramArrayOfByte, ((com.tencent.mm.plugin.scanner.a.a)this.JVI).fCS().x, ((com.tencent.mm.plugin.scanner.a.a)this.JVI).fCS().y);
      }
      if (this.mode == 7)
      {
        ??? = ((com.tencent.scanlib.a.a)this.JVI).s(getDecorRect());
        paramCamera = b.dzn();
        localPoint = this.JVI.fCS();
        i = this.JVI.getCameraRotation();
        synchronized (paramCamera.wXD)
        {
          if ((((Rect)???).width() != paramCamera.wXG.width()) || (((Rect)???).height() != paramCamera.wXG.height())) {}
          synchronized (paramCamera.wXE)
          {
            if (paramCamera.fJw) {
              WxQbarNative.focusedEngineRelease();
            }
            paramCamera.fJw = false;
            ac.i("MicroMsg.BankCardDetectQueue", "resolution %s, rotation %d, rect %s", new Object[] { localPoint, Integer.valueOf(i), ??? });
            if (!paramCamera.fJw) {}
            synchronized (paramCamera.wXE)
            {
              ac.i("MicroMsg.BankCardDetectQueue", "rect %s", new Object[] { ??? });
              paramCamera.wXG = ((Rect)???);
              j = (int)(((Rect)???).width() * b.wXB);
              k = (int)(((Rect)???).height() * b.wXB);
              paramCamera.gUl.left = (((Rect)???).left - (j - ((Rect)???).width()) / 2);
              paramCamera.gUl.top = (((Rect)???).top - (k - ((Rect)???).height()) / 2);
              paramCamera.gUl.right = (paramCamera.gUl.left + j);
              paramCamera.gUl.bottom = (paramCamera.gUl.top + k);
              ac.i("MicroMsg.BankCardDetectQueue", "cropRect %s", new Object[] { paramCamera.gUl });
              if (WxQbarNative.focusedEngineForBankcardInit(j, k, 8, false) == 0)
              {
                bool = true;
                label434:
                paramCamera.fJw = bool;
                if (!paramCamera.fJw) {}
              }
            }
          }
        }
        synchronized (paramCamera.wXD)
        {
          paramCamera.wXC.clear();
          paramCamera.wXC.put("param_preview_data", paramArrayOfByte);
          paramCamera.wXC.put("param_camera_resolution", localPoint);
          paramCamera.wXC.put("param_camera_rotation", Integer.valueOf(i));
          if ((!paramCamera.wXL) && (paramCamera.wXJ != 0L))
          {
            ac.i("MicroMsg.BankCardDetectQueue", "%d submit decode bankcard", new Object[] { Long.valueOf(paramCamera.wXJ) });
            paramCamera.wXI.execute(new b.b(paramCamera, paramCamera.wXJ));
          }
          if ((!((com.tencent.scanlib.a.a)this.JVI).dAy()) && (b.dzn().wXM > 10))
          {
            ac.i("MicroMsg.ScanCardRectView", "change to FOCUS_MODE_AUTO");
            this.JVI.setFocusMode("auto");
            BR(100L);
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
      ??? = ((com.tencent.scanlib.a.a)this.JVI).s(getDecorRect());
      paramCamera = com.tencent.mm.plugin.scanner.b.a.c.dzo();
      localPoint = this.JVI.fCS();
      i = this.JVI.getCameraRotation();
    }
    for (;;)
    {
      synchronized (paramCamera.wXD)
      {
        if ((((Rect)???).width() != paramCamera.wXG.width()) || (((Rect)???).height() != paramCamera.wXG.height()))
        {
          paramCamera.release();
          paramCamera.fJw = false;
        }
        if (!paramCamera.fJw) {}
        synchronized (paramCamera.wXE)
        {
          paramCamera.wXG = ((Rect)???);
          j = (int)(((Rect)???).width() * 1.05D) / 4 * 4;
          k = (int)(((Rect)???).height() * 1.05D) / 4 * 4;
          paramCamera.gUl.left = (((Rect)???).left - (j - ((Rect)???).width()) / 2);
          paramCamera.gUl.top = (((Rect)???).top - (k - ((Rect)???).height()) / 2);
          paramCamera.gUl.right = (j + paramCamera.gUl.left);
          paramCamera.gUl.bottom = (paramCamera.gUl.top + k);
          if (i % 180 != 0)
          {
            j = (localPoint.y - paramCamera.gUl.height()) / 2;
            k = (localPoint.x - paramCamera.gUl.width()) / 2;
            paramCamera.gUl = new Rect(j, k, paramCamera.gUl.height() + j, paramCamera.gUl.width() + k);
          }
          ac.i("MicroMsg.LicenseCardDecodeQueue", "init cropRect %s", new Object[] { paramCamera.gUl });
          j = LibCardRecog.recognizeCardInit(paramCamera.gUl.width(), paramCamera.gUl.height(), paramCamera.hiU);
          ac.d("MicroMsg.LicenseCardDecodeQueue", "initRet %d, cropWidth %d, cropHeight %d", new Object[] { Integer.valueOf(j), Integer.valueOf(paramCamera.gUl.width()), Integer.valueOf(paramCamera.gUl.height()) });
          if (j == 0)
          {
            bool = true;
            paramCamera.fJw = bool;
            if (!paramCamera.fJw) {}
          }
        }
      }
      synchronized (paramCamera.wXD)
      {
        paramCamera.wXC.clear();
        paramCamera.wXC.put("param_preview_data", paramArrayOfByte);
        paramCamera.wXC.put("param_camera_resolution", localPoint);
        paramCamera.wXC.put("param_camera_rotation", Integer.valueOf(i));
        if ((!paramCamera.wXL) && (paramCamera.wXJ != 0L))
        {
          ac.i("MicroMsg.LicenseCardDecodeQueue", "%d submit decode license card", new Object[] { Long.valueOf(paramCamera.wXJ) });
          paramCamera.wXF.execute(new c.a(paramCamera, paramCamera.wXJ));
        }
        if ((!((com.tencent.scanlib.a.a)this.JVI).dAy()) && (com.tencent.mm.plugin.scanner.b.a.c.dzo().wXM > 10))
        {
          ac.i("MicroMsg.ScanCardRectView", "change to FOCUS_MODE_AUTO");
          this.JVI.setFocusMode("auto");
          BR(100L);
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
    if (!this.JVI.isOpen())
    {
      a(new b.b.a()
      {
        public final void dAJ()
        {
          AppMethodBeat.i(118379);
          ScanCardRectView.this.a(new b.d.a()
          {
            public final void dAI()
            {
              AppMethodBeat.i(177499);
              ScanCardRectView.this.wE(0L);
              AppMethodBeat.o(177499);
            }
          });
          AppMethodBeat.o(118379);
        }
      });
      this.wXJ = System.currentTimeMillis();
      if (this.mode != 7) {
        break label157;
      }
      localb = b.dzn();
      l = this.wXJ;
      locala = this.xmS;
    }
    for (;;)
    {
      synchronized (localb.wXD)
      {
        localb.wXJ = l;
        localb.wXM = 0;
        localb.wXK = locala;
        this.xfv.cqT();
        AppMethodBeat.o(118397);
        return;
        if (!this.JVI.cDz())
        {
          a(new b.d.a()
          {
            public final void dAI()
            {
              AppMethodBeat.i(177500);
              ScanCardRectView.this.wE(0L);
              AppMethodBeat.o(177500);
            }
          });
          break;
        }
        wE(0L);
      }
      label157:
      if ((this.mode == 9) || (this.mode == 11) || (this.mode == 10)) {
        if ((this.mode == 9) || (this.mode == 11)) {
          com.tencent.mm.plugin.scanner.b.a.c.dzo().a(1, this.wXJ, this.xmT);
        } else if (this.mode == 10) {
          com.tencent.mm.plugin.scanner.b.a.c.dzo().a(2, this.wXJ, this.xmT);
        }
      }
    }
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(118400);
    super.onStop();
    auj();
    if (this.xbo != null) {
      this.xbo.dAL();
    }
    ScanCameraLightDetector.xlv.stop();
    com.tencent.mm.sdk.b.a.GpY.d(this.xfT);
    com.tencent.mm.sdk.b.a.GpY.d(this.xcd);
    AppMethodBeat.o(118400);
  }
  
  public void setDecorRect(Rect paramRect)
  {
    AppMethodBeat.i(118395);
    this.xfv.setDecorRect(paramRect);
    this.xmO.setCardRect(paramRect);
    AppMethodBeat.o(118395);
  }
  
  public void setMode(int paramInt)
  {
    this.mode = paramInt;
    this.wXJ = 0L;
  }
  
  public void setScanCallback(a parama)
  {
    this.xmP = parama;
  }
  
  public static abstract interface a
  {
    public abstract void e(long paramLong, Bundle paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.view.ScanCardRectView
 * JD-Core Version:    0.7.0.1
 */
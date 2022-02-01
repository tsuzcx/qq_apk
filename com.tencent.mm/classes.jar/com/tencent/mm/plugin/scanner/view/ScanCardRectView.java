package com.tencent.mm.plugin.scanner.view;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
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
import com.tencent.mm.g.a.sl;
import com.tencent.mm.g.a.sm;
import com.tencent.mm.plugin.licence.model.LibCardRecog;
import com.tencent.mm.plugin.scanner.b.a.a.a;
import com.tencent.mm.plugin.scanner.b.a.b.a;
import com.tencent.mm.plugin.scanner.b.a.b.b;
import com.tencent.mm.plugin.scanner.b.a.c.a;
import com.tencent.mm.plugin.scanner.b.a.c.b;
import com.tencent.mm.plugin.scanner.ui.ScannerFlashSwitcher;
import com.tencent.mm.plugin.scanner.util.ScanCameraLightDetector;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.h;
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
  private long yBt;
  private ScannerFlashSwitcher yFp;
  private com.tencent.mm.sdk.b.c yGf;
  private com.tencent.mm.sdk.b.c<sm> yJW;
  private ScanRectDecorView yJx;
  private CardHighLightEdgeView yQP;
  private ScanCardRectView.a yQQ;
  private View yQR;
  private a.a yQS;
  private b.a yQT;
  private c.b yQU;
  
  public ScanCardRectView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(118389);
    this.yQS = new a.a() {};
    this.yQT = new b.a()
    {
      public final void a(long paramAnonymousLong, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(118383);
        if (paramAnonymousLong == ScanCardRectView.a(ScanCardRectView.this))
        {
          ae.i("MicroMsg.ScanCardRectView", "bankcard decode success %s", new Object[] { Long.valueOf(ScanCardRectView.a(ScanCardRectView.this)) });
          ScanCardRectView.b(ScanCardRectView.this);
          if (ScanCardRectView.c(ScanCardRectView.this) != null) {
            ScanCardRectView.c(ScanCardRectView.this).e(paramAnonymousLong, paramAnonymousBundle);
          }
        }
        AppMethodBeat.o(118383);
      }
      
      public final void af(long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(118382);
        if (paramAnonymousLong1 == ScanCardRectView.a(ScanCardRectView.this)) {
          ScanCardRectView.this.zy(paramAnonymousLong2);
        }
        AppMethodBeat.o(118382);
      }
    };
    this.yQU = new c.b()
    {
      public final void a(long paramAnonymousLong, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(177502);
        if (paramAnonymousLong == ScanCardRectView.a(ScanCardRectView.this))
        {
          ae.i("MicroMsg.ScanCardRectView", "license decode success %s", new Object[] { Long.valueOf(ScanCardRectView.a(ScanCardRectView.this)) });
          ScanCardRectView.b(ScanCardRectView.this);
          if (ScanCardRectView.c(ScanCardRectView.this) != null) {
            ScanCardRectView.c(ScanCardRectView.this).e(paramAnonymousLong, paramAnonymousBundle);
          }
        }
        AppMethodBeat.o(177502);
      }
      
      public final void af(long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(177501);
        if (paramAnonymousLong1 == ScanCardRectView.a(ScanCardRectView.this)) {
          ScanCardRectView.this.zy(paramAnonymousLong2);
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
    this.yGf = new com.tencent.mm.sdk.b.c() {};
    this.yJW = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(118389);
  }
  
  public ScanCardRectView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(118390);
    this.yQS = new a.a() {};
    this.yQT = new b.a()
    {
      public final void a(long paramAnonymousLong, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(118383);
        if (paramAnonymousLong == ScanCardRectView.a(ScanCardRectView.this))
        {
          ae.i("MicroMsg.ScanCardRectView", "bankcard decode success %s", new Object[] { Long.valueOf(ScanCardRectView.a(ScanCardRectView.this)) });
          ScanCardRectView.b(ScanCardRectView.this);
          if (ScanCardRectView.c(ScanCardRectView.this) != null) {
            ScanCardRectView.c(ScanCardRectView.this).e(paramAnonymousLong, paramAnonymousBundle);
          }
        }
        AppMethodBeat.o(118383);
      }
      
      public final void af(long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(118382);
        if (paramAnonymousLong1 == ScanCardRectView.a(ScanCardRectView.this)) {
          ScanCardRectView.this.zy(paramAnonymousLong2);
        }
        AppMethodBeat.o(118382);
      }
    };
    this.yQU = new c.b()
    {
      public final void a(long paramAnonymousLong, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(177502);
        if (paramAnonymousLong == ScanCardRectView.a(ScanCardRectView.this))
        {
          ae.i("MicroMsg.ScanCardRectView", "license decode success %s", new Object[] { Long.valueOf(ScanCardRectView.a(ScanCardRectView.this)) });
          ScanCardRectView.b(ScanCardRectView.this);
          if (ScanCardRectView.c(ScanCardRectView.this) != null) {
            ScanCardRectView.c(ScanCardRectView.this).e(paramAnonymousLong, paramAnonymousBundle);
          }
        }
        AppMethodBeat.o(177502);
      }
      
      public final void af(long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(177501);
        if (paramAnonymousLong1 == ScanCardRectView.a(ScanCardRectView.this)) {
          ScanCardRectView.this.zy(paramAnonymousLong2);
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
    this.yGf = new com.tencent.mm.sdk.b.c() {};
    this.yJW = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(118390);
  }
  
  public ScanCardRectView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(118391);
    this.yQS = new a.a() {};
    this.yQT = new b.a()
    {
      public final void a(long paramAnonymousLong, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(118383);
        if (paramAnonymousLong == ScanCardRectView.a(ScanCardRectView.this))
        {
          ae.i("MicroMsg.ScanCardRectView", "bankcard decode success %s", new Object[] { Long.valueOf(ScanCardRectView.a(ScanCardRectView.this)) });
          ScanCardRectView.b(ScanCardRectView.this);
          if (ScanCardRectView.c(ScanCardRectView.this) != null) {
            ScanCardRectView.c(ScanCardRectView.this).e(paramAnonymousLong, paramAnonymousBundle);
          }
        }
        AppMethodBeat.o(118383);
      }
      
      public final void af(long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(118382);
        if (paramAnonymousLong1 == ScanCardRectView.a(ScanCardRectView.this)) {
          ScanCardRectView.this.zy(paramAnonymousLong2);
        }
        AppMethodBeat.o(118382);
      }
    };
    this.yQU = new c.b()
    {
      public final void a(long paramAnonymousLong, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(177502);
        if (paramAnonymousLong == ScanCardRectView.a(ScanCardRectView.this))
        {
          ae.i("MicroMsg.ScanCardRectView", "license decode success %s", new Object[] { Long.valueOf(ScanCardRectView.a(ScanCardRectView.this)) });
          ScanCardRectView.b(ScanCardRectView.this);
          if (ScanCardRectView.c(ScanCardRectView.this) != null) {
            ScanCardRectView.c(ScanCardRectView.this).e(paramAnonymousLong, paramAnonymousBundle);
          }
        }
        AppMethodBeat.o(177502);
      }
      
      public final void af(long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(177501);
        if (paramAnonymousLong1 == ScanCardRectView.a(ScanCardRectView.this)) {
          ScanCardRectView.this.zy(paramAnonymousLong2);
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
    this.yGf = new com.tencent.mm.sdk.b.c() {};
    this.yJW = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(118391);
  }
  
  private void dOK()
  {
    AppMethodBeat.i(118404);
    this.yFp = ((ScannerFlashSwitcher)this.yQR.findViewById(2131304345));
    if (this.yFp != null) {
      this.yFp.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(177504);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/view/ScanCardRectView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if (!ScanCardRectView.e(ScanCardRectView.this).Vp)
          {
            paramAnonymousView = new sm();
            paramAnonymousView.dId.dlO = 1;
            com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousView);
            ScanCardRectView.e(ScanCardRectView.this).dPB();
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/view/ScanCardRectView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(177504);
            return;
            paramAnonymousView = new sm();
            paramAnonymousView.dId.dlO = 2;
            com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousView);
            ScanCardRectView.e(ScanCardRectView.this).dPC();
          }
        }
      });
    }
    com.tencent.mm.sdk.b.a.IvT.c(this.yGf);
    com.tencent.mm.sdk.b.a.IvT.c(this.yJW);
    ar.o(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(177505);
        ScanCameraLightDetector.yPx.start(((com.tencent.mm.plugin.scanner.a.a)ScanCardRectView.f(ScanCardRectView.this)).getFocusMode());
        AppMethodBeat.o(177505);
      }
    }, 300L);
    AppMethodBeat.o(118404);
  }
  
  private void dPq()
  {
    AppMethodBeat.i(118398);
    com.tencent.mm.plugin.scanner.b.a.b.dOd().release();
    com.tencent.mm.plugin.scanner.b.a.c localc = com.tencent.mm.plugin.scanner.b.a.c.dOe();
    long l = this.yBt;
    synchronized (localc.yBn)
    {
      if (localc.yBt == l)
      {
        localc.yBt = 0L;
        localc.yBw = 0;
        localc.yBB = null;
        localc.yBm.clear();
      }
      this.yBt = 0L;
      AppMethodBeat.o(118398);
      return;
    }
  }
  
  public final void dPo()
  {
    AppMethodBeat.i(118393);
    this.MmA = new com.tencent.mm.plugin.scanner.a.a();
    AppMethodBeat.o(118393);
  }
  
  public Rect getDecorRect()
  {
    AppMethodBeat.i(118394);
    Rect localRect = this.yJx.getDecorRect();
    AppMethodBeat.o(118394);
    return localRect;
  }
  
  public final void init()
  {
    AppMethodBeat.i(118392);
    super.init();
    this.yQP = new CardHighLightEdgeView(getContext());
    addView(this.yQP, new FrameLayout.LayoutParams(-1, -1));
    this.yJx = new ScanRectDecorView(getContext());
    addView(this.yJx, new FrameLayout.LayoutParams(-1, -1));
    AppMethodBeat.o(118392);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(118396);
    super.onAttachedToWindow();
    Point localPoint = new Point();
    getDisplay().getSize(localPoint);
    ae.i("MicroMsg.ScanCardRectView", "screenSize %s", new Object[] { localPoint });
    if (this.yQR != null) {
      removeView(this.yQR);
    }
    switch (this.mode)
    {
    case 8: 
    default: 
      ae.e("MicroMsg.ScanCardRectView", "unknown mode!");
      AppMethodBeat.o(118396);
      return;
    case 7: 
      this.yQR = View.inflate(getContext(), 2131495287, null);
      localObject = bu.bI(((Activity)getContext()).getIntent().getStringExtra("bank_card_owner"), "");
      String str = String.format(getContext().getResources().getString(2131762798), new Object[] { localObject });
      View localView = this.yQR.findViewById(2131306001);
      if (bu.isNullOrNil((String)localObject)) {
        localView.setVisibility(4);
      }
      for (;;)
      {
        addView(this.yQR, new FrameLayout.LayoutParams(-1, -1));
        localObject = new Rect();
        ((Rect)localObject).left = com.tencent.mm.cb.a.fromDPToPix(getContext(), 40);
        ((Rect)localObject).right = (localPoint.x - com.tencent.mm.cb.a.fromDPToPix(getContext(), 40));
        ((Rect)localObject).top = ((localPoint.y - (int)(((Rect)localObject).width() / 1.586F)) / 2);
        ((Rect)localObject).bottom = (((Rect)localObject).top + (int)(((Rect)localObject).width() / 1.586F));
        ae.i("MicroMsg.ScanCardRectView", "scan bank card rect %s", new Object[] { localObject });
        this.yJx.hv(((Rect)localObject).width(), ((Rect)localObject).height());
        this.yQP.setCardRect((Rect)localObject);
        dOK();
        AppMethodBeat.o(118396);
        return;
        ((TextView)this.yQR.findViewById(2131297118)).setText(str);
        this.yQR.findViewById(2131297114).setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(118378);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/view/ScanCardRectView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            paramAnonymousView = View.inflate(ScanCardRectView.this.getContext(), 2131495286, null);
            h.a(ScanCardRectView.this.getContext(), ScanCardRectView.this.getContext().getString(2131762796), ScanCardRectView.this.getContext().getString(2131762795), paramAnonymousView, new DialogInterface.OnClickListener()
            {
              public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
              {
                AppMethodBeat.i(118377);
                paramAnonymous2DialogInterface.dismiss();
                AppMethodBeat.o(118377);
              }
            });
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/view/ScanCardRectView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(118378);
          }
        });
        localView.setVisibility(0);
      }
    case 9: 
    case 11: 
      localObject = new Rect();
      ((Rect)localObject).left = com.tencent.mm.cb.a.fromDPToPix(getContext(), 40);
      ((Rect)localObject).right = (localPoint.x - com.tencent.mm.cb.a.fromDPToPix(getContext(), 40));
      ((Rect)localObject).top = ((localPoint.y - (int)(((Rect)localObject).width() / 1.586F)) / 2);
      ((Rect)localObject).bottom = (((Rect)localObject).top + (int)(((Rect)localObject).width() / 1.586F));
      ae.i("MicroMsg.ScanCardRectView", "scan id card rect %s", new Object[] { localObject });
      this.yJx.hv(((Rect)localObject).width(), ((Rect)localObject).height());
      this.yQP.setCardRect((Rect)localObject);
      this.yQR = View.inflate(getContext(), 2131495296, null);
      addView(this.yQR, new FrameLayout.LayoutParams(-1, -1));
      ((TextView)this.yQR.findViewById(2131297474)).setText(getContext().getResources().getString(2131762830, new Object[] { getContext().getResources().getString(2131762805) }));
      dOK();
      AppMethodBeat.o(118396);
      return;
    }
    Object localObject = new Rect();
    ((Rect)localObject).left = com.tencent.mm.cb.a.fromDPToPix(getContext(), 40);
    ((Rect)localObject).right = (localPoint.x - com.tencent.mm.cb.a.fromDPToPix(getContext(), 40));
    ((Rect)localObject).top = ((localPoint.y - (int)(((Rect)localObject).width() / 1.467F)) / 2);
    ((Rect)localObject).bottom = (((Rect)localObject).top + (int)(((Rect)localObject).width() / 1.467F));
    ae.i("MicroMsg.ScanCardRectView", "scan driver card rect %s", new Object[] { localObject });
    this.yJx.hv(((Rect)localObject).width(), ((Rect)localObject).height());
    this.yQP.setCardRect((Rect)localObject);
    this.yQR = View.inflate(getContext(), 2131495296, null);
    addView(this.yQR, new FrameLayout.LayoutParams(-1, -1));
    ((TextView)this.yQR.findViewById(2131297474)).setText("");
    dOK();
    AppMethodBeat.o(118396);
  }
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    AppMethodBeat.i(118403);
    ae.i("MicroMsg.ScanCardRectView", "onAutoFocus %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      zy(0L);
    }
    Fv(MmD);
    AppMethodBeat.o(118403);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(118401);
    super.onDestroy();
    com.tencent.mm.plugin.scanner.b.a.b.dOd().release();
    com.tencent.mm.plugin.scanner.b.a.c.dOe().release();
    AppMethodBeat.o(118401);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(118399);
    super.onPause();
    dPq();
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
      ae.i("MicroMsg.ScanCardRectView", bool);
      if ((this.MmA.cOB()) && (((com.tencent.mm.plugin.scanner.a.a)this.MmA).dOb())) {
        ScanCameraLightDetector.yPx.D(paramArrayOfByte, ((com.tencent.mm.plugin.scanner.a.a)this.MmA).fYJ().x, ((com.tencent.mm.plugin.scanner.a.a)this.MmA).fYJ().y);
      }
      if (this.mode == 7)
      {
        ??? = ((com.tencent.scanlib.a.a)this.MmA).r(getDecorRect());
        paramCamera = com.tencent.mm.plugin.scanner.b.a.b.dOd();
        localPoint = this.MmA.fYJ();
        i = this.MmA.getCameraRotation();
        synchronized (paramCamera.yBn)
        {
          if ((((Rect)???).width() != paramCamera.yBq.width()) || (((Rect)???).height() != paramCamera.yBq.height())) {}
          synchronized (paramCamera.yBo)
          {
            if (paramCamera.gff) {
              WxQbarNative.focusedEngineRelease();
            }
            paramCamera.gff = false;
            ae.i("MicroMsg.BankCardDetectQueue", "resolution %s, rotation %d, rect %s", new Object[] { localPoint, Integer.valueOf(i), ??? });
            if (!paramCamera.gff) {}
            synchronized (paramCamera.yBo)
            {
              ae.i("MicroMsg.BankCardDetectQueue", "rect %s", new Object[] { ??? });
              paramCamera.yBq = ((Rect)???);
              j = (int)(((Rect)???).width() * com.tencent.mm.plugin.scanner.b.a.b.yBl);
              k = (int)(((Rect)???).height() * com.tencent.mm.plugin.scanner.b.a.b.yBl);
              paramCamera.hpa.left = (((Rect)???).left - (j - ((Rect)???).width()) / 2);
              paramCamera.hpa.top = (((Rect)???).top - (k - ((Rect)???).height()) / 2);
              paramCamera.hpa.right = (paramCamera.hpa.left + j);
              paramCamera.hpa.bottom = (paramCamera.hpa.top + k);
              ae.i("MicroMsg.BankCardDetectQueue", "cropRect %s", new Object[] { paramCamera.hpa });
              if (WxQbarNative.focusedEngineForBankcardInit(j, k, 8, false) == 0)
              {
                bool = true;
                label434:
                paramCamera.gff = bool;
                if (!paramCamera.gff) {}
              }
            }
          }
        }
        synchronized (paramCamera.yBn)
        {
          paramCamera.yBm.clear();
          paramCamera.yBm.put("param_preview_data", paramArrayOfByte);
          paramCamera.yBm.put("param_camera_resolution", localPoint);
          paramCamera.yBm.put("param_camera_rotation", Integer.valueOf(i));
          if ((!paramCamera.yBv) && (paramCamera.yBt != 0L))
          {
            ae.i("MicroMsg.BankCardDetectQueue", "%d submit decode bankcard", new Object[] { Long.valueOf(paramCamera.yBt) });
            paramCamera.yBs.execute(new b.b(paramCamera, paramCamera.yBt));
          }
          if ((!((com.tencent.scanlib.a.a)this.MmA).dPp()) && (com.tencent.mm.plugin.scanner.b.a.b.dOd().yBw > 10))
          {
            ae.i("MicroMsg.ScanCardRectView", "change to FOCUS_MODE_AUTO");
            this.MmA.setFocusMode("auto");
            Fv(100L);
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
      ??? = ((com.tencent.scanlib.a.a)this.MmA).r(getDecorRect());
      paramCamera = com.tencent.mm.plugin.scanner.b.a.c.dOe();
      localPoint = this.MmA.fYJ();
      i = this.MmA.getCameraRotation();
    }
    for (;;)
    {
      synchronized (paramCamera.yBn)
      {
        if ((((Rect)???).width() != paramCamera.yBq.width()) || (((Rect)???).height() != paramCamera.yBq.height()))
        {
          paramCamera.release();
          paramCamera.gff = false;
        }
        if (!paramCamera.gff) {}
        synchronized (paramCamera.yBo)
        {
          paramCamera.yBq = ((Rect)???);
          j = (int)(((Rect)???).width() * 1.05D) / 4 * 4;
          k = (int)(((Rect)???).height() * 1.05D) / 4 * 4;
          paramCamera.hpa.left = (((Rect)???).left - (j - ((Rect)???).width()) / 2);
          paramCamera.hpa.top = (((Rect)???).top - (k - ((Rect)???).height()) / 2);
          paramCamera.hpa.right = (j + paramCamera.hpa.left);
          paramCamera.hpa.bottom = (paramCamera.hpa.top + k);
          if (i % 180 != 0)
          {
            j = (localPoint.y - paramCamera.hpa.height()) / 2;
            k = (localPoint.x - paramCamera.hpa.width()) / 2;
            paramCamera.hpa = new Rect(j, k, paramCamera.hpa.height() + j, paramCamera.hpa.width() + k);
          }
          ae.i("MicroMsg.LicenseCardDecodeQueue", "init cropRect %s", new Object[] { paramCamera.hpa });
          j = LibCardRecog.recognizeCardInit(paramCamera.hpa.width(), paramCamera.hpa.height(), paramCamera.hDR);
          ae.d("MicroMsg.LicenseCardDecodeQueue", "initRet %d, cropWidth %d, cropHeight %d", new Object[] { Integer.valueOf(j), Integer.valueOf(paramCamera.hpa.width()), Integer.valueOf(paramCamera.hpa.height()) });
          if (j == 0)
          {
            bool = true;
            paramCamera.gff = bool;
            if (!paramCamera.gff) {}
          }
        }
      }
      synchronized (paramCamera.yBn)
      {
        paramCamera.yBm.clear();
        paramCamera.yBm.put("param_preview_data", paramArrayOfByte);
        paramCamera.yBm.put("param_camera_resolution", localPoint);
        paramCamera.yBm.put("param_camera_rotation", Integer.valueOf(i));
        if ((!paramCamera.yBv) && (paramCamera.yBt != 0L))
        {
          ae.i("MicroMsg.LicenseCardDecodeQueue", "%d submit decode license card", new Object[] { Long.valueOf(paramCamera.yBt) });
          paramCamera.yBp.execute(new c.a(paramCamera, paramCamera.yBt));
        }
        if ((!((com.tencent.scanlib.a.a)this.MmA).dPp()) && (com.tencent.mm.plugin.scanner.b.a.c.dOe().yBw > 10))
        {
          ae.i("MicroMsg.ScanCardRectView", "change to FOCUS_MODE_AUTO");
          this.MmA.setFocusMode("auto");
          Fv(100L);
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
    if (!this.MmA.isOpen())
    {
      a(new b.b.a()
      {
        public final void dPA()
        {
          AppMethodBeat.i(118379);
          ScanCardRectView.this.a(new b.d.a()
          {
            public final void dPz()
            {
              AppMethodBeat.i(177499);
              ScanCardRectView.this.zy(0L);
              AppMethodBeat.o(177499);
            }
          });
          AppMethodBeat.o(118379);
        }
      });
      this.yBt = System.currentTimeMillis();
      if (this.mode != 7) {
        break label157;
      }
      localb = com.tencent.mm.plugin.scanner.b.a.b.dOd();
      l = this.yBt;
      locala = this.yQT;
    }
    for (;;)
    {
      synchronized (localb.yBn)
      {
        localb.yBt = l;
        localb.yBw = 0;
        localb.yBu = locala;
        this.yJx.cye();
        AppMethodBeat.o(118397);
        return;
        if (!this.MmA.cOB())
        {
          a(new b.d.a()
          {
            public final void dPz()
            {
              AppMethodBeat.i(177500);
              ScanCardRectView.this.zy(0L);
              AppMethodBeat.o(177500);
            }
          });
          break;
        }
        zy(0L);
      }
      label157:
      if ((this.mode == 9) || (this.mode == 11) || (this.mode == 10)) {
        if ((this.mode == 9) || (this.mode == 11)) {
          com.tencent.mm.plugin.scanner.b.a.c.dOe().a(1, this.yBt, this.yQU);
        } else if (this.mode == 10) {
          com.tencent.mm.plugin.scanner.b.a.c.dOe().a(2, this.yBt, this.yQU);
        }
      }
    }
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(118400);
    super.onStop();
    axl();
    if (this.yFp != null) {
      this.yFp.dPC();
    }
    ScanCameraLightDetector.yPx.stop();
    com.tencent.mm.sdk.b.a.IvT.d(this.yJW);
    com.tencent.mm.sdk.b.a.IvT.d(this.yGf);
    AppMethodBeat.o(118400);
  }
  
  public void setDecorRect(Rect paramRect)
  {
    AppMethodBeat.i(118395);
    this.yJx.setDecorRect(paramRect);
    this.yQP.setCardRect(paramRect);
    AppMethodBeat.o(118395);
  }
  
  public void setMode(int paramInt)
  {
    this.mode = paramInt;
    this.yBt = 0L;
  }
  
  public void setScanCallback(ScanCardRectView.a parama)
  {
    this.yQQ = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.view.ScanCardRectView
 * JD-Core Version:    0.7.0.1
 */
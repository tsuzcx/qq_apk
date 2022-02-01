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
import com.tencent.mm.g.a.sk;
import com.tencent.mm.g.a.sl;
import com.tencent.mm.plugin.licence.model.LibCardRecog;
import com.tencent.mm.plugin.scanner.b.a.a.a;
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
  private CardHighLightEdgeView yAP;
  private ScanCardRectView.a yAQ;
  private View yAR;
  private a.a yAS;
  private b.a yAT;
  private c.b yAU;
  private long ylu;
  private ScannerFlashSwitcher ypq;
  private com.tencent.mm.sdk.b.c yqf;
  private com.tencent.mm.sdk.b.c<sl> ytV;
  private ScanRectDecorView ytx;
  
  public ScanCardRectView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(118389);
    this.yAS = new a.a() {};
    this.yAT = new b.a()
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
          ScanCardRectView.this.zb(paramAnonymousLong2);
        }
        AppMethodBeat.o(118382);
      }
    };
    this.yAU = new c.b()
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
          ScanCardRectView.this.zb(paramAnonymousLong2);
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
    this.yqf = new com.tencent.mm.sdk.b.c() {};
    this.ytV = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(118389);
  }
  
  public ScanCardRectView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(118390);
    this.yAS = new a.a() {};
    this.yAT = new b.a()
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
          ScanCardRectView.this.zb(paramAnonymousLong2);
        }
        AppMethodBeat.o(118382);
      }
    };
    this.yAU = new c.b()
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
          ScanCardRectView.this.zb(paramAnonymousLong2);
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
    this.yqf = new com.tencent.mm.sdk.b.c() {};
    this.ytV = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(118390);
  }
  
  public ScanCardRectView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(118391);
    this.yAS = new a.a() {};
    this.yAT = new b.a()
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
          ScanCardRectView.this.zb(paramAnonymousLong2);
        }
        AppMethodBeat.o(118382);
      }
    };
    this.yAU = new c.b()
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
          ScanCardRectView.this.zb(paramAnonymousLong2);
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
    this.yqf = new com.tencent.mm.sdk.b.c() {};
    this.ytV = new com.tencent.mm.sdk.b.c() {};
    AppMethodBeat.o(118391);
  }
  
  private void dLX()
  {
    AppMethodBeat.i(118398);
    com.tencent.mm.plugin.scanner.b.a.b.dKL().release();
    com.tencent.mm.plugin.scanner.b.a.c localc = com.tencent.mm.plugin.scanner.b.a.c.dKM();
    long l = this.ylu;
    synchronized (localc.ylo)
    {
      if (localc.ylu == l)
      {
        localc.ylu = 0L;
        localc.ylx = 0;
        localc.ylC = null;
        localc.yln.clear();
      }
      this.ylu = 0L;
      AppMethodBeat.o(118398);
      return;
    }
  }
  
  private void dLr()
  {
    AppMethodBeat.i(118404);
    this.ypq = ((ScannerFlashSwitcher)this.yAR.findViewById(2131304345));
    if (this.ypq != null) {
      this.ypq.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(177504);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/view/ScanCardRectView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          if (!ScanCardRectView.e(ScanCardRectView.this).Vp)
          {
            paramAnonymousView = new sl();
            paramAnonymousView.dGX.dkM = 1;
            com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousView);
            ScanCardRectView.e(ScanCardRectView.this).dMi();
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/view/ScanCardRectView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(177504);
            return;
            paramAnonymousView = new sl();
            paramAnonymousView.dGX.dkM = 2;
            com.tencent.mm.sdk.b.a.IbL.l(paramAnonymousView);
            ScanCardRectView.e(ScanCardRectView.this).dMj();
          }
        }
      });
    }
    com.tencent.mm.sdk.b.a.IbL.c(this.yqf);
    com.tencent.mm.sdk.b.a.IbL.c(this.ytV);
    aq.o(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(177505);
        ScanCameraLightDetector.yzx.start(((com.tencent.mm.plugin.scanner.a.a)ScanCardRectView.f(ScanCardRectView.this)).getFocusMode());
        AppMethodBeat.o(177505);
      }
    }, 300L);
    AppMethodBeat.o(118404);
  }
  
  public final void dLV()
  {
    AppMethodBeat.i(118393);
    this.LPD = new com.tencent.mm.plugin.scanner.a.a();
    AppMethodBeat.o(118393);
  }
  
  public Rect getDecorRect()
  {
    AppMethodBeat.i(118394);
    Rect localRect = this.ytx.getDecorRect();
    AppMethodBeat.o(118394);
    return localRect;
  }
  
  public final void init()
  {
    AppMethodBeat.i(118392);
    super.init();
    this.yAP = new CardHighLightEdgeView(getContext());
    addView(this.yAP, new FrameLayout.LayoutParams(-1, -1));
    this.ytx = new ScanRectDecorView(getContext());
    addView(this.ytx, new FrameLayout.LayoutParams(-1, -1));
    AppMethodBeat.o(118392);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(118396);
    super.onAttachedToWindow();
    Point localPoint = new Point();
    getDisplay().getSize(localPoint);
    ad.i("MicroMsg.ScanCardRectView", "screenSize %s", new Object[] { localPoint });
    if (this.yAR != null) {
      removeView(this.yAR);
    }
    switch (this.mode)
    {
    case 8: 
    default: 
      ad.e("MicroMsg.ScanCardRectView", "unknown mode!");
      AppMethodBeat.o(118396);
      return;
    case 7: 
      this.yAR = View.inflate(getContext(), 2131495287, null);
      localObject = bt.bI(((Activity)getContext()).getIntent().getStringExtra("bank_card_owner"), "");
      String str = String.format(getContext().getResources().getString(2131762798), new Object[] { localObject });
      View localView = this.yAR.findViewById(2131306001);
      if (bt.isNullOrNil((String)localObject)) {
        localView.setVisibility(4);
      }
      for (;;)
      {
        addView(this.yAR, new FrameLayout.LayoutParams(-1, -1));
        localObject = new Rect();
        ((Rect)localObject).left = com.tencent.mm.cc.a.fromDPToPix(getContext(), 40);
        ((Rect)localObject).right = (localPoint.x - com.tencent.mm.cc.a.fromDPToPix(getContext(), 40));
        ((Rect)localObject).top = ((localPoint.y - (int)(((Rect)localObject).width() / 1.586F)) / 2);
        ((Rect)localObject).bottom = (((Rect)localObject).top + (int)(((Rect)localObject).width() / 1.586F));
        ad.i("MicroMsg.ScanCardRectView", "scan bank card rect %s", new Object[] { localObject });
        this.ytx.ht(((Rect)localObject).width(), ((Rect)localObject).height());
        this.yAP.setCardRect((Rect)localObject);
        dLr();
        AppMethodBeat.o(118396);
        return;
        ((TextView)this.yAR.findViewById(2131297118)).setText(str);
        this.yAR.findViewById(2131297114).setOnClickListener(new ScanCardRectView.1(this));
        localView.setVisibility(0);
      }
    case 9: 
    case 11: 
      localObject = new Rect();
      ((Rect)localObject).left = com.tencent.mm.cc.a.fromDPToPix(getContext(), 40);
      ((Rect)localObject).right = (localPoint.x - com.tencent.mm.cc.a.fromDPToPix(getContext(), 40));
      ((Rect)localObject).top = ((localPoint.y - (int)(((Rect)localObject).width() / 1.586F)) / 2);
      ((Rect)localObject).bottom = (((Rect)localObject).top + (int)(((Rect)localObject).width() / 1.586F));
      ad.i("MicroMsg.ScanCardRectView", "scan id card rect %s", new Object[] { localObject });
      this.ytx.ht(((Rect)localObject).width(), ((Rect)localObject).height());
      this.yAP.setCardRect((Rect)localObject);
      this.yAR = View.inflate(getContext(), 2131495296, null);
      addView(this.yAR, new FrameLayout.LayoutParams(-1, -1));
      ((TextView)this.yAR.findViewById(2131297474)).setText(getContext().getResources().getString(2131762830, new Object[] { getContext().getResources().getString(2131762805) }));
      dLr();
      AppMethodBeat.o(118396);
      return;
    }
    Object localObject = new Rect();
    ((Rect)localObject).left = com.tencent.mm.cc.a.fromDPToPix(getContext(), 40);
    ((Rect)localObject).right = (localPoint.x - com.tencent.mm.cc.a.fromDPToPix(getContext(), 40));
    ((Rect)localObject).top = ((localPoint.y - (int)(((Rect)localObject).width() / 1.467F)) / 2);
    ((Rect)localObject).bottom = (((Rect)localObject).top + (int)(((Rect)localObject).width() / 1.467F));
    ad.i("MicroMsg.ScanCardRectView", "scan driver card rect %s", new Object[] { localObject });
    this.ytx.ht(((Rect)localObject).width(), ((Rect)localObject).height());
    this.yAP.setCardRect((Rect)localObject);
    this.yAR = View.inflate(getContext(), 2131495296, null);
    addView(this.yAR, new FrameLayout.LayoutParams(-1, -1));
    ((TextView)this.yAR.findViewById(2131297474)).setText("");
    dLr();
    AppMethodBeat.o(118396);
  }
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    AppMethodBeat.i(118403);
    ad.i("MicroMsg.ScanCardRectView", "onAutoFocus %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      zb(0L);
    }
    ET(LPG);
    AppMethodBeat.o(118403);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(118401);
    super.onDestroy();
    com.tencent.mm.plugin.scanner.b.a.b.dKL().release();
    com.tencent.mm.plugin.scanner.b.a.c.dKM().release();
    AppMethodBeat.o(118401);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(118399);
    super.onPause();
    dLX();
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
      if ((this.LPD.cLT()) && (((com.tencent.mm.plugin.scanner.a.a)this.LPD).dKJ())) {
        ScanCameraLightDetector.yzx.C(paramArrayOfByte, ((com.tencent.mm.plugin.scanner.a.a)this.LPD).fUk().x, ((com.tencent.mm.plugin.scanner.a.a)this.LPD).fUk().y);
      }
      if (this.mode == 7)
      {
        ??? = ((com.tencent.scanlib.a.a)this.LPD).r(getDecorRect());
        paramCamera = com.tencent.mm.plugin.scanner.b.a.b.dKL();
        localPoint = this.LPD.fUk();
        i = this.LPD.getCameraRotation();
        synchronized (paramCamera.ylo)
        {
          if ((((Rect)???).width() != paramCamera.ylr.width()) || (((Rect)???).height() != paramCamera.ylr.height())) {}
          synchronized (paramCamera.ylp)
          {
            if (paramCamera.gcX) {
              WxQbarNative.focusedEngineRelease();
            }
            paramCamera.gcX = false;
            ad.i("MicroMsg.BankCardDetectQueue", "resolution %s, rotation %d, rect %s", new Object[] { localPoint, Integer.valueOf(i), ??? });
            if (!paramCamera.gcX) {}
            synchronized (paramCamera.ylp)
            {
              ad.i("MicroMsg.BankCardDetectQueue", "rect %s", new Object[] { ??? });
              paramCamera.ylr = ((Rect)???);
              j = (int)(((Rect)???).width() * com.tencent.mm.plugin.scanner.b.a.b.ylm);
              k = (int)(((Rect)???).height() * com.tencent.mm.plugin.scanner.b.a.b.ylm);
              paramCamera.hmm.left = (((Rect)???).left - (j - ((Rect)???).width()) / 2);
              paramCamera.hmm.top = (((Rect)???).top - (k - ((Rect)???).height()) / 2);
              paramCamera.hmm.right = (paramCamera.hmm.left + j);
              paramCamera.hmm.bottom = (paramCamera.hmm.top + k);
              ad.i("MicroMsg.BankCardDetectQueue", "cropRect %s", new Object[] { paramCamera.hmm });
              if (WxQbarNative.focusedEngineForBankcardInit(j, k, 8, false) == 0)
              {
                bool = true;
                label434:
                paramCamera.gcX = bool;
                if (!paramCamera.gcX) {}
              }
            }
          }
        }
        synchronized (paramCamera.ylo)
        {
          paramCamera.yln.clear();
          paramCamera.yln.put("param_preview_data", paramArrayOfByte);
          paramCamera.yln.put("param_camera_resolution", localPoint);
          paramCamera.yln.put("param_camera_rotation", Integer.valueOf(i));
          if ((!paramCamera.ylw) && (paramCamera.ylu != 0L))
          {
            ad.i("MicroMsg.BankCardDetectQueue", "%d submit decode bankcard", new Object[] { Long.valueOf(paramCamera.ylu) });
            paramCamera.ylt.execute(new b.b(paramCamera, paramCamera.ylu));
          }
          if ((!((com.tencent.scanlib.a.a)this.LPD).dLW()) && (com.tencent.mm.plugin.scanner.b.a.b.dKL().ylx > 10))
          {
            ad.i("MicroMsg.ScanCardRectView", "change to FOCUS_MODE_AUTO");
            this.LPD.setFocusMode("auto");
            ET(100L);
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
      ??? = ((com.tencent.scanlib.a.a)this.LPD).r(getDecorRect());
      paramCamera = com.tencent.mm.plugin.scanner.b.a.c.dKM();
      localPoint = this.LPD.fUk();
      i = this.LPD.getCameraRotation();
    }
    for (;;)
    {
      synchronized (paramCamera.ylo)
      {
        if ((((Rect)???).width() != paramCamera.ylr.width()) || (((Rect)???).height() != paramCamera.ylr.height()))
        {
          paramCamera.release();
          paramCamera.gcX = false;
        }
        if (!paramCamera.gcX) {}
        synchronized (paramCamera.ylp)
        {
          paramCamera.ylr = ((Rect)???);
          j = (int)(((Rect)???).width() * 1.05D) / 4 * 4;
          k = (int)(((Rect)???).height() * 1.05D) / 4 * 4;
          paramCamera.hmm.left = (((Rect)???).left - (j - ((Rect)???).width()) / 2);
          paramCamera.hmm.top = (((Rect)???).top - (k - ((Rect)???).height()) / 2);
          paramCamera.hmm.right = (j + paramCamera.hmm.left);
          paramCamera.hmm.bottom = (paramCamera.hmm.top + k);
          if (i % 180 != 0)
          {
            j = (localPoint.y - paramCamera.hmm.height()) / 2;
            k = (localPoint.x - paramCamera.hmm.width()) / 2;
            paramCamera.hmm = new Rect(j, k, paramCamera.hmm.height() + j, paramCamera.hmm.width() + k);
          }
          ad.i("MicroMsg.LicenseCardDecodeQueue", "init cropRect %s", new Object[] { paramCamera.hmm });
          j = LibCardRecog.recognizeCardInit(paramCamera.hmm.width(), paramCamera.hmm.height(), paramCamera.hBd);
          ad.d("MicroMsg.LicenseCardDecodeQueue", "initRet %d, cropWidth %d, cropHeight %d", new Object[] { Integer.valueOf(j), Integer.valueOf(paramCamera.hmm.width()), Integer.valueOf(paramCamera.hmm.height()) });
          if (j == 0)
          {
            bool = true;
            paramCamera.gcX = bool;
            if (!paramCamera.gcX) {}
          }
        }
      }
      synchronized (paramCamera.ylo)
      {
        paramCamera.yln.clear();
        paramCamera.yln.put("param_preview_data", paramArrayOfByte);
        paramCamera.yln.put("param_camera_resolution", localPoint);
        paramCamera.yln.put("param_camera_rotation", Integer.valueOf(i));
        if ((!paramCamera.ylw) && (paramCamera.ylu != 0L))
        {
          ad.i("MicroMsg.LicenseCardDecodeQueue", "%d submit decode license card", new Object[] { Long.valueOf(paramCamera.ylu) });
          paramCamera.ylq.execute(new c.a(paramCamera, paramCamera.ylu));
        }
        if ((!((com.tencent.scanlib.a.a)this.LPD).dLW()) && (com.tencent.mm.plugin.scanner.b.a.c.dKM().ylx > 10))
        {
          ad.i("MicroMsg.ScanCardRectView", "change to FOCUS_MODE_AUTO");
          this.LPD.setFocusMode("auto");
          ET(100L);
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
    if (!this.LPD.isOpen())
    {
      a(new b.b.a()
      {
        public final void dMh()
        {
          AppMethodBeat.i(118379);
          ScanCardRectView.this.a(new b.d.a()
          {
            public final void dMg()
            {
              AppMethodBeat.i(177499);
              ScanCardRectView.this.zb(0L);
              AppMethodBeat.o(177499);
            }
          });
          AppMethodBeat.o(118379);
        }
      });
      this.ylu = System.currentTimeMillis();
      if (this.mode != 7) {
        break label157;
      }
      localb = com.tencent.mm.plugin.scanner.b.a.b.dKL();
      l = this.ylu;
      locala = this.yAT;
    }
    for (;;)
    {
      synchronized (localb.ylo)
      {
        localb.ylu = l;
        localb.ylx = 0;
        localb.ylv = locala;
        this.ytx.cwD();
        AppMethodBeat.o(118397);
        return;
        if (!this.LPD.cLT())
        {
          a(new b.d.a()
          {
            public final void dMg()
            {
              AppMethodBeat.i(177500);
              ScanCardRectView.this.zb(0L);
              AppMethodBeat.o(177500);
            }
          });
          break;
        }
        zb(0L);
      }
      label157:
      if ((this.mode == 9) || (this.mode == 11) || (this.mode == 10)) {
        if ((this.mode == 9) || (this.mode == 11)) {
          com.tencent.mm.plugin.scanner.b.a.c.dKM().a(1, this.ylu, this.yAU);
        } else if (this.mode == 10) {
          com.tencent.mm.plugin.scanner.b.a.c.dKM().a(2, this.ylu, this.yAU);
        }
      }
    }
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(118400);
    super.onStop();
    awW();
    if (this.ypq != null) {
      this.ypq.dMj();
    }
    ScanCameraLightDetector.yzx.stop();
    com.tencent.mm.sdk.b.a.IbL.d(this.ytV);
    com.tencent.mm.sdk.b.a.IbL.d(this.yqf);
    AppMethodBeat.o(118400);
  }
  
  public void setDecorRect(Rect paramRect)
  {
    AppMethodBeat.i(118395);
    this.ytx.setDecorRect(paramRect);
    this.yAP.setCardRect(paramRect);
    AppMethodBeat.o(118395);
  }
  
  public void setMode(int paramInt)
  {
    this.mode = paramInt;
    this.ylu = 0L;
  }
  
  public void setScanCallback(ScanCardRectView.a parama)
  {
    this.yAQ = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.view.ScanCardRectView
 * JD-Core Version:    0.7.0.1
 */
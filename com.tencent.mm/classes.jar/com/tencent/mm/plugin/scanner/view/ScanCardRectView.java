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
import com.tencent.mm.g.a.ti;
import com.tencent.mm.g.a.tj;
import com.tencent.mm.plugin.licence.model.LibCardRecog;
import com.tencent.mm.plugin.scanner.b.a.a.a;
import com.tencent.mm.plugin.scanner.b.a.b.a;
import com.tencent.mm.plugin.scanner.b.a.b.b;
import com.tencent.mm.plugin.scanner.b.a.c;
import com.tencent.mm.plugin.scanner.b.a.c.a;
import com.tencent.mm.plugin.scanner.b.a.c.b;
import com.tencent.mm.plugin.scanner.ui.ScannerFlashSwitcher;
import com.tencent.mm.plugin.scanner.util.ScanCameraLightDetector;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
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
  private long CDU;
  private IListener CJU;
  private ScannerFlashSwitcher CJh;
  private IListener<tj> CNK;
  private ScanRectDecorView CNj;
  private CardHighLightEdgeView CVc;
  private a CVd;
  private View CVe;
  private a.a CVf;
  private b.a CVg;
  private c.b CVh;
  private int mode;
  
  public ScanCardRectView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(118389);
    this.CVf = new a.a() {};
    this.CVg = new b.a()
    {
      public final void a(long paramAnonymousLong, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(118383);
        if (paramAnonymousLong == ScanCardRectView.a(ScanCardRectView.this))
        {
          Log.i("MicroMsg.ScanCardRectView", "bankcard decode success %s", new Object[] { Long.valueOf(ScanCardRectView.a(ScanCardRectView.this)) });
          ScanCardRectView.b(ScanCardRectView.this);
          if (ScanCardRectView.c(ScanCardRectView.this) != null) {
            ScanCardRectView.c(ScanCardRectView.this).e(paramAnonymousLong, paramAnonymousBundle);
          }
        }
        AppMethodBeat.o(118383);
      }
      
      public final void aj(long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(118382);
        if (paramAnonymousLong1 == ScanCardRectView.a(ScanCardRectView.this)) {
          ScanCardRectView.this.IC(paramAnonymousLong2);
        }
        AppMethodBeat.o(118382);
      }
    };
    this.CVh = new c.b()
    {
      public final void a(long paramAnonymousLong, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(177502);
        if (paramAnonymousLong == ScanCardRectView.a(ScanCardRectView.this))
        {
          Log.i("MicroMsg.ScanCardRectView", "license decode success %s", new Object[] { Long.valueOf(ScanCardRectView.a(ScanCardRectView.this)) });
          ScanCardRectView.b(ScanCardRectView.this);
          if (ScanCardRectView.c(ScanCardRectView.this) != null) {
            ScanCardRectView.c(ScanCardRectView.this).e(paramAnonymousLong, paramAnonymousBundle);
          }
        }
        AppMethodBeat.o(177502);
      }
      
      public final void aj(long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(177501);
        if (paramAnonymousLong1 == ScanCardRectView.a(ScanCardRectView.this)) {
          ScanCardRectView.this.IC(paramAnonymousLong2);
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
    this.CJU = new IListener() {};
    this.CNK = new IListener() {};
    AppMethodBeat.o(118389);
  }
  
  public ScanCardRectView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(118390);
    this.CVf = new a.a() {};
    this.CVg = new b.a()
    {
      public final void a(long paramAnonymousLong, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(118383);
        if (paramAnonymousLong == ScanCardRectView.a(ScanCardRectView.this))
        {
          Log.i("MicroMsg.ScanCardRectView", "bankcard decode success %s", new Object[] { Long.valueOf(ScanCardRectView.a(ScanCardRectView.this)) });
          ScanCardRectView.b(ScanCardRectView.this);
          if (ScanCardRectView.c(ScanCardRectView.this) != null) {
            ScanCardRectView.c(ScanCardRectView.this).e(paramAnonymousLong, paramAnonymousBundle);
          }
        }
        AppMethodBeat.o(118383);
      }
      
      public final void aj(long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(118382);
        if (paramAnonymousLong1 == ScanCardRectView.a(ScanCardRectView.this)) {
          ScanCardRectView.this.IC(paramAnonymousLong2);
        }
        AppMethodBeat.o(118382);
      }
    };
    this.CVh = new c.b()
    {
      public final void a(long paramAnonymousLong, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(177502);
        if (paramAnonymousLong == ScanCardRectView.a(ScanCardRectView.this))
        {
          Log.i("MicroMsg.ScanCardRectView", "license decode success %s", new Object[] { Long.valueOf(ScanCardRectView.a(ScanCardRectView.this)) });
          ScanCardRectView.b(ScanCardRectView.this);
          if (ScanCardRectView.c(ScanCardRectView.this) != null) {
            ScanCardRectView.c(ScanCardRectView.this).e(paramAnonymousLong, paramAnonymousBundle);
          }
        }
        AppMethodBeat.o(177502);
      }
      
      public final void aj(long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(177501);
        if (paramAnonymousLong1 == ScanCardRectView.a(ScanCardRectView.this)) {
          ScanCardRectView.this.IC(paramAnonymousLong2);
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
    this.CJU = new IListener() {};
    this.CNK = new IListener() {};
    AppMethodBeat.o(118390);
  }
  
  public ScanCardRectView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(118391);
    this.CVf = new a.a() {};
    this.CVg = new b.a()
    {
      public final void a(long paramAnonymousLong, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(118383);
        if (paramAnonymousLong == ScanCardRectView.a(ScanCardRectView.this))
        {
          Log.i("MicroMsg.ScanCardRectView", "bankcard decode success %s", new Object[] { Long.valueOf(ScanCardRectView.a(ScanCardRectView.this)) });
          ScanCardRectView.b(ScanCardRectView.this);
          if (ScanCardRectView.c(ScanCardRectView.this) != null) {
            ScanCardRectView.c(ScanCardRectView.this).e(paramAnonymousLong, paramAnonymousBundle);
          }
        }
        AppMethodBeat.o(118383);
      }
      
      public final void aj(long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(118382);
        if (paramAnonymousLong1 == ScanCardRectView.a(ScanCardRectView.this)) {
          ScanCardRectView.this.IC(paramAnonymousLong2);
        }
        AppMethodBeat.o(118382);
      }
    };
    this.CVh = new c.b()
    {
      public final void a(long paramAnonymousLong, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(177502);
        if (paramAnonymousLong == ScanCardRectView.a(ScanCardRectView.this))
        {
          Log.i("MicroMsg.ScanCardRectView", "license decode success %s", new Object[] { Long.valueOf(ScanCardRectView.a(ScanCardRectView.this)) });
          ScanCardRectView.b(ScanCardRectView.this);
          if (ScanCardRectView.c(ScanCardRectView.this) != null) {
            ScanCardRectView.c(ScanCardRectView.this).e(paramAnonymousLong, paramAnonymousBundle);
          }
        }
        AppMethodBeat.o(177502);
      }
      
      public final void aj(long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(177501);
        if (paramAnonymousLong1 == ScanCardRectView.a(ScanCardRectView.this)) {
          ScanCardRectView.this.IC(paramAnonymousLong2);
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
    this.CJU = new IListener() {};
    this.CNK = new IListener() {};
    AppMethodBeat.o(118391);
  }
  
  private void eQw()
  {
    AppMethodBeat.i(118404);
    this.CJh = ((ScannerFlashSwitcher)this.CVe.findViewById(2131307277));
    if (this.CJh != null) {
      this.CJh.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(177504);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/scanner/view/ScanCardRectView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (!ScanCardRectView.e(ScanCardRectView.this).VC)
          {
            paramAnonymousView = new tj();
            paramAnonymousView.dZP.dDe = 1;
            EventCenter.instance.publish(paramAnonymousView);
            ScanCardRectView.e(ScanCardRectView.this).eRm();
          }
          for (;;)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/scanner/view/ScanCardRectView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(177504);
            return;
            paramAnonymousView = new tj();
            paramAnonymousView.dZP.dDe = 2;
            EventCenter.instance.publish(paramAnonymousView);
            ScanCardRectView.e(ScanCardRectView.this).eRn();
          }
        }
      });
    }
    EventCenter.instance.addListener(this.CJU);
    EventCenter.instance.addListener(this.CNK);
    MMHandlerThread.postToMainThreadDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(177505);
        ScanCameraLightDetector.CTx.start(((com.tencent.mm.plugin.scanner.a.a)ScanCardRectView.f(ScanCardRectView.this)).getFocusMode());
        AppMethodBeat.o(177505);
      }
    }, 300L);
    AppMethodBeat.o(118404);
  }
  
  private void eRa()
  {
    AppMethodBeat.i(118398);
    com.tencent.mm.plugin.scanner.b.a.b.ePG().release();
    c localc = c.ePH();
    long l = this.CDU;
    synchronized (localc.CCt)
    {
      if (localc.CDU == l)
      {
        localc.CDU = 0L;
        localc.CDX = 0;
        localc.CEc = null;
        localc.CDO.clear();
      }
      this.CDU = 0L;
      AppMethodBeat.o(118398);
      return;
    }
  }
  
  public final void eQY()
  {
    AppMethodBeat.i(118393);
    this.ROY = new com.tencent.mm.plugin.scanner.a.a();
    AppMethodBeat.o(118393);
  }
  
  public Rect getDecorRect()
  {
    AppMethodBeat.i(118394);
    Rect localRect = this.CNj.getDecorRect();
    AppMethodBeat.o(118394);
    return localRect;
  }
  
  public final void init()
  {
    AppMethodBeat.i(118392);
    super.init();
    this.CVc = new CardHighLightEdgeView(getContext());
    addView(this.CVc, new FrameLayout.LayoutParams(-1, -1));
    this.CNj = new ScanRectDecorView(getContext());
    addView(this.CNj, new FrameLayout.LayoutParams(-1, -1));
    AppMethodBeat.o(118392);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(118396);
    super.onAttachedToWindow();
    Point localPoint = new Point();
    getDisplay().getSize(localPoint);
    Log.i("MicroMsg.ScanCardRectView", "screenSize %s", new Object[] { localPoint });
    if (this.CVe != null) {
      removeView(this.CVe);
    }
    switch (this.mode)
    {
    case 8: 
    default: 
      Log.e("MicroMsg.ScanCardRectView", "unknown mode!");
      AppMethodBeat.o(118396);
      return;
    case 7: 
      this.CVe = View.inflate(getContext(), 2131496137, null);
      localObject = Util.nullAs(((Activity)getContext()).getIntent().getStringExtra("bank_card_owner"), "");
      String str = String.format(getContext().getResources().getString(2131764886), new Object[] { localObject });
      View localView = this.CVe.findViewById(2131309310);
      if (Util.isNullOrNil((String)localObject)) {
        localView.setVisibility(4);
      }
      for (;;)
      {
        addView(this.CVe, new FrameLayout.LayoutParams(-1, -1));
        localObject = new Rect();
        ((Rect)localObject).left = com.tencent.mm.cb.a.fromDPToPix(getContext(), 40);
        ((Rect)localObject).right = (localPoint.x - com.tencent.mm.cb.a.fromDPToPix(getContext(), 40));
        ((Rect)localObject).top = ((localPoint.y - (int)(((Rect)localObject).width() / 1.586F)) / 2);
        ((Rect)localObject).bottom = (((Rect)localObject).top + (int)(((Rect)localObject).width() / 1.586F));
        Log.i("MicroMsg.ScanCardRectView", "scan bank card rect %s", new Object[] { localObject });
        this.CNj.ij(((Rect)localObject).width(), ((Rect)localObject).height());
        this.CVc.setCardRect((Rect)localObject);
        eQw();
        AppMethodBeat.o(118396);
        return;
        ((TextView)this.CVe.findViewById(2131297262)).setText(str);
        this.CVe.findViewById(2131297259).setOnClickListener(new ScanCardRectView.1(this));
        localView.setVisibility(0);
      }
    case 9: 
    case 11: 
      localObject = new Rect();
      ((Rect)localObject).left = com.tencent.mm.cb.a.fromDPToPix(getContext(), 40);
      ((Rect)localObject).right = (localPoint.x - com.tencent.mm.cb.a.fromDPToPix(getContext(), 40));
      ((Rect)localObject).top = ((localPoint.y - (int)(((Rect)localObject).width() / 1.586F)) / 2);
      ((Rect)localObject).bottom = (((Rect)localObject).top + (int)(((Rect)localObject).width() / 1.586F));
      Log.i("MicroMsg.ScanCardRectView", "scan id card rect %s", new Object[] { localObject });
      this.CNj.ij(((Rect)localObject).width(), ((Rect)localObject).height());
      this.CVc.setCardRect((Rect)localObject);
      this.CVe = View.inflate(getContext(), 2131496146, null);
      addView(this.CVe, new FrameLayout.LayoutParams(-1, -1));
      ((TextView)this.CVe.findViewById(2131297711)).setText(getContext().getResources().getString(2131764937, new Object[] { getContext().getResources().getString(2131764902) }));
      eQw();
      AppMethodBeat.o(118396);
      return;
    }
    Object localObject = new Rect();
    ((Rect)localObject).left = com.tencent.mm.cb.a.fromDPToPix(getContext(), 40);
    ((Rect)localObject).right = (localPoint.x - com.tencent.mm.cb.a.fromDPToPix(getContext(), 40));
    ((Rect)localObject).top = ((localPoint.y - (int)(((Rect)localObject).width() / 1.467F)) / 2);
    ((Rect)localObject).bottom = (((Rect)localObject).top + (int)(((Rect)localObject).width() / 1.467F));
    Log.i("MicroMsg.ScanCardRectView", "scan driver card rect %s", new Object[] { localObject });
    this.CNj.ij(((Rect)localObject).width(), ((Rect)localObject).height());
    this.CVc.setCardRect((Rect)localObject);
    this.CVe = View.inflate(getContext(), 2131496146, null);
    addView(this.CVe, new FrameLayout.LayoutParams(-1, -1));
    ((TextView)this.CVe.findViewById(2131297711)).setText("");
    eQw();
    AppMethodBeat.o(118396);
  }
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    AppMethodBeat.i(118403);
    Log.i("MicroMsg.ScanCardRectView", "onAutoFocus %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      IC(0L);
    }
    Oy(RPb);
    AppMethodBeat.o(118403);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(118401);
    super.onDestroy();
    com.tencent.mm.plugin.scanner.b.a.b.ePG().release();
    c.ePH().release();
    AppMethodBeat.o(118401);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(118399);
    super.onPause();
    eRa();
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
      if ((this.ROY.dEO()) && (((com.tencent.mm.plugin.scanner.a.a)this.ROY).ePE())) {
        ScanCameraLightDetector.CTx.N(paramArrayOfByte, ((com.tencent.mm.plugin.scanner.a.a)this.ROY).hkU().x, ((com.tencent.mm.plugin.scanner.a.a)this.ROY).hkU().y);
      }
      if (this.mode == 7)
      {
        ??? = ((com.tencent.scanlib.a.a)this.ROY).w(getDecorRect());
        paramCamera = com.tencent.mm.plugin.scanner.b.a.b.ePG();
        localPoint = this.ROY.hkU();
        i = this.ROY.getCameraRotation();
        synchronized (paramCamera.CCt)
        {
          if ((((Rect)???).width() != paramCamera.CDR.width()) || (((Rect)???).height() != paramCamera.CDR.height())) {}
          synchronized (paramCamera.CDP)
          {
            if (paramCamera.gKM) {
              WxQbarNative.focusedEngineRelease();
            }
            paramCamera.gKM = false;
            Log.i("MicroMsg.BankCardDetectQueue", "resolution %s, rotation %d, rect %s", new Object[] { localPoint, Integer.valueOf(i), ??? });
            if (!paramCamera.gKM) {}
            synchronized (paramCamera.CDP)
            {
              Log.i("MicroMsg.BankCardDetectQueue", "rect %s", new Object[] { ??? });
              paramCamera.CDR = ((Rect)???);
              j = (int)(((Rect)???).width() * com.tencent.mm.plugin.scanner.b.a.b.CDN);
              k = (int)(((Rect)???).height() * com.tencent.mm.plugin.scanner.b.a.b.CDN);
              paramCamera.iiw.left = (((Rect)???).left - (j - ((Rect)???).width()) / 2);
              paramCamera.iiw.top = (((Rect)???).top - (k - ((Rect)???).height()) / 2);
              paramCamera.iiw.right = (paramCamera.iiw.left + j);
              paramCamera.iiw.bottom = (paramCamera.iiw.top + k);
              Log.i("MicroMsg.BankCardDetectQueue", "cropRect %s", new Object[] { paramCamera.iiw });
              if (WxQbarNative.focusedEngineForBankcardInit(j, k, 8, false) == 0)
              {
                bool = true;
                label434:
                paramCamera.gKM = bool;
                if (!paramCamera.gKM) {}
              }
            }
          }
        }
        synchronized (paramCamera.CCt)
        {
          paramCamera.CDO.clear();
          paramCamera.CDO.put("param_preview_data", paramArrayOfByte);
          paramCamera.CDO.put("param_camera_resolution", localPoint);
          paramCamera.CDO.put("param_camera_rotation", Integer.valueOf(i));
          if ((!paramCamera.CDW) && (paramCamera.CDU != 0L))
          {
            Log.i("MicroMsg.BankCardDetectQueue", "%d submit decode bankcard", new Object[] { Long.valueOf(paramCamera.CDU) });
            paramCamera.CDT.execute(new b.b(paramCamera, paramCamera.CDU));
          }
          if ((!((com.tencent.scanlib.a.a)this.ROY).eQZ()) && (com.tencent.mm.plugin.scanner.b.a.b.ePG().CDX > 10))
          {
            Log.i("MicroMsg.ScanCardRectView", "change to FOCUS_MODE_AUTO");
            this.ROY.setFocusMode("auto");
            Oy(100L);
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
      ??? = ((com.tencent.scanlib.a.a)this.ROY).w(getDecorRect());
      paramCamera = c.ePH();
      localPoint = this.ROY.hkU();
      i = this.ROY.getCameraRotation();
    }
    for (;;)
    {
      synchronized (paramCamera.CCt)
      {
        if ((((Rect)???).width() != paramCamera.CDR.width()) || (((Rect)???).height() != paramCamera.CDR.height()))
        {
          paramCamera.release();
          paramCamera.gKM = false;
        }
        if (!paramCamera.gKM) {}
        synchronized (paramCamera.CDP)
        {
          paramCamera.CDR = ((Rect)???);
          j = (int)(((Rect)???).width() * 1.05D) / 4 * 4;
          k = (int)(((Rect)???).height() * 1.05D) / 4 * 4;
          paramCamera.iiw.left = (((Rect)???).left - (j - ((Rect)???).width()) / 2);
          paramCamera.iiw.top = (((Rect)???).top - (k - ((Rect)???).height()) / 2);
          paramCamera.iiw.right = (j + paramCamera.iiw.left);
          paramCamera.iiw.bottom = (paramCamera.iiw.top + k);
          if (i % 180 != 0)
          {
            j = (localPoint.y - paramCamera.iiw.height()) / 2;
            k = (localPoint.x - paramCamera.iiw.width()) / 2;
            paramCamera.iiw = new Rect(j, k, paramCamera.iiw.height() + j, paramCamera.iiw.width() + k);
          }
          Log.i("MicroMsg.LicenseCardDecodeQueue", "init cropRect %s", new Object[] { paramCamera.iiw });
          j = LibCardRecog.recognizeCardInit(paramCamera.iiw.width(), paramCamera.iiw.height(), paramCamera.ixW);
          Log.d("MicroMsg.LicenseCardDecodeQueue", "initRet %d, cropWidth %d, cropHeight %d", new Object[] { Integer.valueOf(j), Integer.valueOf(paramCamera.iiw.width()), Integer.valueOf(paramCamera.iiw.height()) });
          if (j == 0)
          {
            bool = true;
            paramCamera.gKM = bool;
            if (!paramCamera.gKM) {}
          }
        }
      }
      synchronized (paramCamera.CCt)
      {
        paramCamera.CDO.clear();
        paramCamera.CDO.put("param_preview_data", paramArrayOfByte);
        paramCamera.CDO.put("param_camera_resolution", localPoint);
        paramCamera.CDO.put("param_camera_rotation", Integer.valueOf(i));
        if ((!paramCamera.CDW) && (paramCamera.CDU != 0L))
        {
          Log.i("MicroMsg.LicenseCardDecodeQueue", "%d submit decode license card", new Object[] { Long.valueOf(paramCamera.CDU) });
          paramCamera.CDQ.execute(new c.a(paramCamera, paramCamera.CDU));
        }
        if ((!((com.tencent.scanlib.a.a)this.ROY).eQZ()) && (c.ePH().CDX > 10))
        {
          Log.i("MicroMsg.ScanCardRectView", "change to FOCUS_MODE_AUTO");
          this.ROY.setFocusMode("auto");
          Oy(100L);
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
    if (!this.ROY.isOpen())
    {
      a(new b.b.a()
      {
        public final void eRl()
        {
          AppMethodBeat.i(118379);
          ScanCardRectView.this.a(new b.d.a()
          {
            public final void eRk()
            {
              AppMethodBeat.i(177499);
              ScanCardRectView.this.IC(0L);
              AppMethodBeat.o(177499);
            }
          });
          AppMethodBeat.o(118379);
        }
      });
      this.CDU = System.currentTimeMillis();
      if (this.mode != 7) {
        break label157;
      }
      localb = com.tencent.mm.plugin.scanner.b.a.b.ePG();
      l = this.CDU;
      locala = this.CVg;
    }
    for (;;)
    {
      synchronized (localb.CCt)
      {
        localb.CDU = l;
        localb.CDX = 0;
        localb.CDV = locala;
        this.CNj.cWi();
        AppMethodBeat.o(118397);
        return;
        if (!this.ROY.dEO())
        {
          a(new b.d.a()
          {
            public final void eRk()
            {
              AppMethodBeat.i(177500);
              ScanCardRectView.this.IC(0L);
              AppMethodBeat.o(177500);
            }
          });
          break;
        }
        IC(0L);
      }
      label157:
      if ((this.mode == 9) || (this.mode == 11) || (this.mode == 10)) {
        if ((this.mode == 9) || (this.mode == 11)) {
          c.ePH().a(1, this.CDU, this.CVh);
        } else if (this.mode == 10) {
          c.ePH().a(2, this.CDU, this.CVh);
        }
      }
    }
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(118400);
    super.onStop();
    aPK();
    if (this.CJh != null) {
      this.CJh.eRn();
    }
    ScanCameraLightDetector.CTx.stop();
    EventCenter.instance.removeListener(this.CNK);
    EventCenter.instance.removeListener(this.CJU);
    AppMethodBeat.o(118400);
  }
  
  public void setDecorRect(Rect paramRect)
  {
    AppMethodBeat.i(118395);
    this.CNj.setDecorRect(paramRect);
    this.CVc.setCardRect(paramRect);
    AppMethodBeat.o(118395);
  }
  
  public void setMode(int paramInt)
  {
    this.mode = paramInt;
    this.CDU = 0L;
  }
  
  public void setScanCallback(a parama)
  {
    this.CVd = parama;
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
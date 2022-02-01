package com.tencent.scanlib.ui;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Bundle;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qbar.a.a;
import com.tencent.scanlib.a.b.b.a;
import com.tencent.scanlib.a.b.d.a;
import com.tencent.scanlib.a.f;
import com.tencent.scanlib.b.c;
import com.tencent.scanlib.b.c.a;
import com.tencent.scanlib.b.c.c;
import com.tencent.stubs.logger.Log;
import java.util.List;
import java.util.concurrent.ExecutorService;

public class ScanCodeView
  extends ScanView
{
  public long CDU;
  private c.c ROO;
  public a ROT;
  
  public ScanCodeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(3592);
    this.ROO = new c.c()
    {
      public final void aj(final long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(3588);
        ScanCodeView.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(3585);
            if ((paramAnonymousLong1 == ScanCodeView.this.CDU) && (paramAnonymousLong1 != 0L)) {
              ScanCodeView.this.IC(this.ynh);
            }
            AppMethodBeat.o(3585);
          }
        });
        AppMethodBeat.o(3588);
      }
      
      public final void b(final long paramAnonymousLong, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(3590);
        ScanCodeView.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(3587);
            if ((paramAnonymousLong == ScanCodeView.this.CDU) && (paramAnonymousLong != 0L) && (this.val$param.containsKey("param_zoom_ratio")))
            {
              float f = this.val$param.getFloat("param_zoom_ratio", 0.0F);
              if ((f > 0.0F) && (ScanCodeView.this.ROY.dEO()))
              {
                int i = (int)(((com.tencent.scanlib.a.a)ScanCodeView.this.ROY).hkX() * f);
                ((com.tencent.scanlib.a.a)ScanCodeView.this.ROY).aqE(i);
              }
            }
            AppMethodBeat.o(3587);
          }
        });
        AppMethodBeat.o(3590);
      }
      
      public final void b(final long paramAnonymousLong, List<a.a> paramAnonymousList)
      {
        AppMethodBeat.i(3589);
        Log.d("ScanCodeView", String.format("after decode %d", new Object[] { Long.valueOf(paramAnonymousLong) }));
        if ((paramAnonymousList != null) && (!paramAnonymousList.isEmpty())) {
          ScanCodeView.this.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(3586);
              if ((ScanCodeView.this.CDU == paramAnonymousLong) && (paramAnonymousLong != 0L))
              {
                ScanCodeView.a(ScanCodeView.this);
                if ((this.CFR != null) && (!this.CFR.isEmpty()))
                {
                  Bundle localBundle = new Bundle();
                  String str = ((a.a)this.CFR.get(0)).data;
                  localBundle.putString("result_content", str);
                  int i = ((a.a)this.CFR.get(0)).typeID;
                  localBundle.putInt("result_code_format", i);
                  localBundle.putString("result_code_name", ((a.a)this.CFR.get(0)).typeName);
                  byte[] arrayOfByte = ((a.a)this.CFR.get(0)).rawData;
                  if (arrayOfByte != null) {
                    localBundle.putByteArray("result_raw_data", arrayOfByte);
                  }
                  Log.i("ScanCodeView", String.format("scan result format: %d, content:%s", new Object[] { Integer.valueOf(i), str }));
                  if (ScanCodeView.this.ROT != null) {
                    ScanCodeView.this.ROT.ay(localBundle);
                  }
                }
              }
              AppMethodBeat.o(3586);
            }
          });
        }
        AppMethodBeat.o(3589);
      }
    };
    AppMethodBeat.o(3592);
  }
  
  public ScanCodeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(3593);
    this.ROO = new c.c()
    {
      public final void aj(final long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(3588);
        ScanCodeView.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(3585);
            if ((paramAnonymousLong1 == ScanCodeView.this.CDU) && (paramAnonymousLong1 != 0L)) {
              ScanCodeView.this.IC(this.ynh);
            }
            AppMethodBeat.o(3585);
          }
        });
        AppMethodBeat.o(3588);
      }
      
      public final void b(final long paramAnonymousLong, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(3590);
        ScanCodeView.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(3587);
            if ((paramAnonymousLong == ScanCodeView.this.CDU) && (paramAnonymousLong != 0L) && (this.val$param.containsKey("param_zoom_ratio")))
            {
              float f = this.val$param.getFloat("param_zoom_ratio", 0.0F);
              if ((f > 0.0F) && (ScanCodeView.this.ROY.dEO()))
              {
                int i = (int)(((com.tencent.scanlib.a.a)ScanCodeView.this.ROY).hkX() * f);
                ((com.tencent.scanlib.a.a)ScanCodeView.this.ROY).aqE(i);
              }
            }
            AppMethodBeat.o(3587);
          }
        });
        AppMethodBeat.o(3590);
      }
      
      public final void b(final long paramAnonymousLong, List<a.a> paramAnonymousList)
      {
        AppMethodBeat.i(3589);
        Log.d("ScanCodeView", String.format("after decode %d", new Object[] { Long.valueOf(paramAnonymousLong) }));
        if ((paramAnonymousList != null) && (!paramAnonymousList.isEmpty())) {
          ScanCodeView.this.post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(3586);
              if ((ScanCodeView.this.CDU == paramAnonymousLong) && (paramAnonymousLong != 0L))
              {
                ScanCodeView.a(ScanCodeView.this);
                if ((this.CFR != null) && (!this.CFR.isEmpty()))
                {
                  Bundle localBundle = new Bundle();
                  String str = ((a.a)this.CFR.get(0)).data;
                  localBundle.putString("result_content", str);
                  int i = ((a.a)this.CFR.get(0)).typeID;
                  localBundle.putInt("result_code_format", i);
                  localBundle.putString("result_code_name", ((a.a)this.CFR.get(0)).typeName);
                  byte[] arrayOfByte = ((a.a)this.CFR.get(0)).rawData;
                  if (arrayOfByte != null) {
                    localBundle.putByteArray("result_raw_data", arrayOfByte);
                  }
                  Log.i("ScanCodeView", String.format("scan result format: %d, content:%s", new Object[] { Integer.valueOf(i), str }));
                  if (ScanCodeView.this.ROT != null) {
                    ScanCodeView.this.ROT.ay(localBundle);
                  }
                }
              }
              AppMethodBeat.o(3586);
            }
          });
        }
        AppMethodBeat.o(3589);
      }
    };
    AppMethodBeat.o(3593);
  }
  
  private void eRa()
  {
    AppMethodBeat.i(3596);
    c.hld().Iv(this.CDU);
    this.CDU = 0L;
    AppMethodBeat.o(3596);
  }
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    AppMethodBeat.i(3601);
    Log.i("ScanCodeView", "onAutoFocus %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      IC(0L);
    }
    Oy(1000L);
    AppMethodBeat.o(3601);
  }
  
  public void onCreate()
  {
    AppMethodBeat.i(3594);
    super.onCreate();
    c localc = c.hld();
    Context localContext = getContext();
    synchronized (localc.ROF)
    {
      if (!localc.ROF.hasInited())
      {
        localc.ROF.a(0, com.tencent.scanlib.a.lb(localContext));
        if (localc.ROF.hasInited()) {
          localc.ROF.T(localc.RKg);
        }
      }
      AppMethodBeat.o(3594);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(3599);
    super.onDestroy();
    c localc = c.hld();
    Log.i("ScanDecodeQueue", "release QBar");
    synchronized (localc.ROF)
    {
      localc.ROF.release();
      AppMethodBeat.o(3599);
      return;
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(3597);
    super.onPause();
    eRa();
    AppMethodBeat.o(3597);
  }
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera arg2)
  {
    AppMethodBeat.i(3600);
    super.onPreviewFrame(paramArrayOfByte, ???);
    ??? = new StringBuilder("onPreviewFrame null data:");
    boolean bool;
    if (paramArrayOfByte == null) {
      bool = true;
    }
    for (;;)
    {
      Log.d("ScanCodeView", bool);
      Point localPoint;
      Rect localRect;
      c localc;
      int i;
      if ((this.CDU != 0L) && (this.ROY.dEO()))
      {
        localPoint = this.ROY.hkU();
        localRect = ((com.tencent.scanlib.a.a)this.ROY).w(new Rect(0, 0, getWidth(), getHeight()));
        localc = c.hld();
        i = this.ROY.getCameraRotation();
      }
      synchronized (localc.CCt)
      {
        Log.d("ScanDecodeQueue", String.format("%d submit crop gray", new Object[] { Long.valueOf(localc.CDU) }));
        if (localc.CDU != 0L) {
          localc.ROH.execute(new c.a(localc, localc.CDU, paramArrayOfByte, localPoint, i, localRect));
        }
        if ((!((com.tencent.scanlib.a.a)this.ROY).eQZ()) && (c.hld().CDX > 50))
        {
          Log.i("ScanCodeView", "change to FOCUS_MODE_AUTO");
          this.ROY.setFocusMode("auto");
          Oy(100L);
        }
        AppMethodBeat.o(3600);
        return;
        bool = false;
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(3595);
    super.onResume();
    if (!this.ROY.isOpen()) {
      a(new b.b.a()
      {
        public final void eRl()
        {
          AppMethodBeat.i(3591);
          ScanCodeView.this.a(new b.d.a()
          {
            public final void eRk()
            {
              AppMethodBeat.i(174604);
              ScanCodeView.this.IC(0L);
              AppMethodBeat.o(174604);
            }
          });
          AppMethodBeat.o(3591);
        }
      });
    }
    for (;;)
    {
      this.CDU = System.currentTimeMillis();
      c.hld().a(this.CDU, this.ROO);
      AppMethodBeat.o(3595);
      return;
      if (!this.ROY.dEO()) {
        a(new b.d.a()
        {
          public final void eRk()
          {
            AppMethodBeat.i(174605);
            ScanCodeView.this.IC(0L);
            AppMethodBeat.o(174605);
          }
        });
      } else {
        IC(0L);
      }
    }
  }
  
  public void onStop()
  {
    AppMethodBeat.i(3598);
    super.onStop();
    stopPreview();
    aPK();
    AppMethodBeat.o(3598);
  }
  
  public void setScanCallBack(a parama)
  {
    this.ROT = parama;
  }
  
  public void setScanCodeReaders(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(3602);
    c localc = c.hld();
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0)) {
      synchronized (localc.ROF)
      {
        localc.RKg = paramArrayOfInt;
        if (localc.ROF.hasInited()) {
          localc.ROF.T(localc.RKg);
        }
        AppMethodBeat.o(3602);
        return;
      }
    }
    AppMethodBeat.o(3602);
  }
  
  public static abstract interface a
  {
    public abstract void ay(Bundle paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.scanlib.ui.ScanCodeView
 * JD-Core Version:    0.7.0.1
 */
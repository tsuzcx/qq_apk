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
  private c.c LPu;
  public a LPz;
  public long ylu;
  
  public ScanCodeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(3592);
    this.LPu = new c.c()
    {
      public final void ag(final long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(3588);
        ScanCodeView.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(3585);
            if ((paramAnonymousLong1 == ScanCodeView.this.ylu) && (paramAnonymousLong1 != 0L)) {
              ScanCodeView.this.zb(this.uIT);
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
            if ((paramAnonymousLong == ScanCodeView.this.ylu) && (paramAnonymousLong != 0L) && (this.val$param.containsKey("param_zoom_ratio")))
            {
              float f = this.val$param.getFloat("param_zoom_ratio", 0.0F);
              if ((f > 0.0F) && (ScanCodeView.this.LPD.cLT()))
              {
                int i = (int)(((com.tencent.scanlib.a.a)ScanCodeView.this.LPD).fUn() * f);
                ((com.tencent.scanlib.a.a)ScanCodeView.this.LPD).agI(i);
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
              if ((ScanCodeView.this.ylu == paramAnonymousLong) && (paramAnonymousLong != 0L))
              {
                ScanCodeView.a(ScanCodeView.this);
                if ((this.ynd != null) && (!this.ynd.isEmpty()))
                {
                  Bundle localBundle = new Bundle();
                  String str = ((a.a)this.ynd.get(0)).data;
                  localBundle.putString("result_content", str);
                  int i = ((a.a)this.ynd.get(0)).typeID;
                  localBundle.putInt("result_code_format", i);
                  localBundle.putString("result_code_name", ((a.a)this.ynd.get(0)).typeName);
                  byte[] arrayOfByte = ((a.a)this.ynd.get(0)).rawData;
                  if (arrayOfByte != null) {
                    localBundle.putByteArray("result_raw_data", arrayOfByte);
                  }
                  Log.i("ScanCodeView", String.format("scan result format: %d, content:%s", new Object[] { Integer.valueOf(i), str }));
                  if (ScanCodeView.this.LPz != null) {
                    ScanCodeView.this.LPz.an(localBundle);
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
    this.LPu = new c.c()
    {
      public final void ag(final long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(3588);
        ScanCodeView.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(3585);
            if ((paramAnonymousLong1 == ScanCodeView.this.ylu) && (paramAnonymousLong1 != 0L)) {
              ScanCodeView.this.zb(this.uIT);
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
            if ((paramAnonymousLong == ScanCodeView.this.ylu) && (paramAnonymousLong != 0L) && (this.val$param.containsKey("param_zoom_ratio")))
            {
              float f = this.val$param.getFloat("param_zoom_ratio", 0.0F);
              if ((f > 0.0F) && (ScanCodeView.this.LPD.cLT()))
              {
                int i = (int)(((com.tencent.scanlib.a.a)ScanCodeView.this.LPD).fUn() * f);
                ((com.tencent.scanlib.a.a)ScanCodeView.this.LPD).agI(i);
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
              if ((ScanCodeView.this.ylu == paramAnonymousLong) && (paramAnonymousLong != 0L))
              {
                ScanCodeView.a(ScanCodeView.this);
                if ((this.ynd != null) && (!this.ynd.isEmpty()))
                {
                  Bundle localBundle = new Bundle();
                  String str = ((a.a)this.ynd.get(0)).data;
                  localBundle.putString("result_content", str);
                  int i = ((a.a)this.ynd.get(0)).typeID;
                  localBundle.putInt("result_code_format", i);
                  localBundle.putString("result_code_name", ((a.a)this.ynd.get(0)).typeName);
                  byte[] arrayOfByte = ((a.a)this.ynd.get(0)).rawData;
                  if (arrayOfByte != null) {
                    localBundle.putByteArray("result_raw_data", arrayOfByte);
                  }
                  Log.i("ScanCodeView", String.format("scan result format: %d, content:%s", new Object[] { Integer.valueOf(i), str }));
                  if (ScanCodeView.this.LPz != null) {
                    ScanCodeView.this.LPz.an(localBundle);
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
  
  private void dLX()
  {
    AppMethodBeat.i(3596);
    c.fUt().yV(this.ylu);
    this.ylu = 0L;
    AppMethodBeat.o(3596);
  }
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    AppMethodBeat.i(3601);
    Log.i("ScanCodeView", "onAutoFocus %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      zb(0L);
    }
    ET(1000L);
    AppMethodBeat.o(3601);
  }
  
  public void onCreate()
  {
    AppMethodBeat.i(3594);
    super.onCreate();
    c localc = c.fUt();
    Context localContext = getContext();
    synchronized (localc.LPl)
    {
      if (!localc.LPl.hasInited())
      {
        localc.LPl.a(0, com.tencent.scanlib.a.la(localContext));
        if (localc.LPl.hasInited()) {
          localc.LPl.L(localc.LKG);
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
    c localc = c.fUt();
    Log.i("ScanDecodeQueue", "release QBar");
    synchronized (localc.LPl)
    {
      localc.LPl.release();
      AppMethodBeat.o(3599);
      return;
    }
  }
  
  public void onPause()
  {
    AppMethodBeat.i(3597);
    super.onPause();
    dLX();
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
      if ((this.ylu != 0L) && (this.LPD.cLT()))
      {
        localPoint = this.LPD.fUk();
        localRect = ((com.tencent.scanlib.a.a)this.LPD).r(new Rect(0, 0, getWidth(), getHeight()));
        localc = c.fUt();
        i = this.LPD.getCameraRotation();
      }
      synchronized (localc.ylo)
      {
        Log.d("ScanDecodeQueue", String.format("%d submit crop gray", new Object[] { Long.valueOf(localc.ylu) }));
        if (localc.ylu != 0L) {
          localc.LPn.execute(new c.a(localc, localc.ylu, paramArrayOfByte, localPoint, i, localRect));
        }
        if ((!((com.tencent.scanlib.a.a)this.LPD).dLW()) && (c.fUt().ylx > 50))
        {
          Log.i("ScanCodeView", "change to FOCUS_MODE_AUTO");
          this.LPD.setFocusMode("auto");
          ET(100L);
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
    if (!this.LPD.isOpen()) {
      a(new b.b.a()
      {
        public final void dMh()
        {
          AppMethodBeat.i(3591);
          ScanCodeView.this.a(new b.d.a()
          {
            public final void dMg()
            {
              AppMethodBeat.i(174604);
              ScanCodeView.this.zb(0L);
              AppMethodBeat.o(174604);
            }
          });
          AppMethodBeat.o(3591);
        }
      });
    }
    for (;;)
    {
      this.ylu = System.currentTimeMillis();
      c.fUt().a(this.ylu, this.LPu);
      AppMethodBeat.o(3595);
      return;
      if (!this.LPD.cLT()) {
        a(new b.d.a()
        {
          public final void dMg()
          {
            AppMethodBeat.i(174605);
            ScanCodeView.this.zb(0L);
            AppMethodBeat.o(174605);
          }
        });
      } else {
        zb(0L);
      }
    }
  }
  
  public void onStop()
  {
    AppMethodBeat.i(3598);
    super.onStop();
    stopPreview();
    awW();
    AppMethodBeat.o(3598);
  }
  
  public void setScanCallBack(a parama)
  {
    this.LPz = parama;
  }
  
  public void setScanCodeReaders(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(3602);
    c localc = c.fUt();
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0)) {
      synchronized (localc.LPl)
      {
        localc.LKG = paramArrayOfInt;
        if (localc.LPl.hasInited()) {
          localc.LPl.L(localc.LKG);
        }
        AppMethodBeat.o(3602);
        return;
      }
    }
    AppMethodBeat.o(3602);
  }
  
  public static abstract interface a
  {
    public abstract void an(Bundle paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.scanlib.ui.ScanCodeView
 * JD-Core Version:    0.7.0.1
 */
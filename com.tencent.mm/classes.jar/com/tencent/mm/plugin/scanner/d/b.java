package com.tencent.mm.plugin.scanner.d;

import android.content.Context;
import android.graphics.Point;
import android.graphics.RectF;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.model.ac;
import com.tencent.mm.plugin.scanner.model.ad;
import com.tencent.mm.plugin.scanner.scan_goods_new.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;

public final class b
{
  public static int OOK;
  private static b OPb;
  public static volatile a OPf;
  public static volatile a OPg;
  private volatile boolean OOw;
  public c OPc;
  public b OPd;
  public boolean OPe;
  public int OPh;
  public Sensor OPi;
  private boolean OPj;
  private b.d OPk;
  public float OPl;
  public float OPm;
  public float OPn;
  public float OPo;
  public double OPp;
  public long OPq;
  public long OPr;
  private boolean lYs;
  public long mJI;
  public float pxk;
  public float pxl;
  public SensorManager sensorManager;
  
  static
  {
    AppMethodBeat.i(313415);
    OPb = new b();
    OOK = com.tencent.mm.plugin.scanner.c.a.gQq();
    OPf = null;
    OPg = null;
    AppMethodBeat.o(313415);
  }
  
  public b()
  {
    AppMethodBeat.i(313386);
    this.OPh = 0;
    this.OPj = false;
    this.mJI = 0L;
    this.OPk = new b.d(this);
    AppMethodBeat.o(313386);
  }
  
  private void a(Point paramPoint, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(313391);
    b(paramPoint, paramInt1, paramInt2, paramBoolean);
    this.OOw = false;
    a(paramPoint, paramInt1, paramInt2, paramBoolean, false);
    AppMethodBeat.o(313391);
  }
  
  public static void a(ad paramad)
  {
    AppMethodBeat.i(313399);
    h.ahAA.g(paramad, "ReIdAiScanImageDecodeQueue_decode_task");
    AppMethodBeat.o(313399);
  }
  
  private void b(Point paramPoint, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(313396);
    int j = a.ahI(paramInt2);
    if (OPf == null)
    {
      Log.w("MicroMsg.ReIdAiScanImageDecodeQueue", "runDecodeTaskImpl sPendingImage is null");
      AppMethodBeat.o(313396);
      return;
    }
    if (!this.lYs)
    {
      Log.i("MicroMsg.ReIdAiScanImageDecodeQueue", "runDecodeTaskImpl ScanFastFocusEngineManager init");
      if (ac.b(paramPoint.x, paramPoint.y, j, paramInt1, paramBoolean, true) != 0) {
        break label93;
      }
    }
    label93:
    for (paramBoolean = true;; paramBoolean = false)
    {
      this.lYs = paramBoolean;
      if (this.lYs) {
        break;
      }
      Log.e("MicroMsg.ReIdAiScanImageDecodeQueue", "runDecodeTaskImpl ffe init fail");
      AppMethodBeat.o(313396);
      return;
    }
    Object localObject;
    int i;
    if (this.OPd != null)
    {
      localObject = this.OPd;
      ((b)localObject).OPC += 1;
      if (this.OPd.OPE > 0) {
        i = 1;
      }
    }
    for (;;)
    {
      localObject = OPf;
      OPg = (a)localObject;
      if (localObject == null)
      {
        Log.w("MicroMsg.ReIdAiScanImageDecodeQueue", "runDecodeTaskImpl sDecodingImage is null");
        AppMethodBeat.o(313396);
        return;
        i = 0;
      }
      else
      {
        Log.i("MicroMsg.ReIdAiScanImageDecodeQueue", "runDecodeTaskImpl resolution: %s, previewData length: %d, cameraRotation: %d, previewFormat: %d", new Object[] { paramPoint, Integer.valueOf(OPg.imageData.length), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
        paramPoint = ac.a(OPg.imageData, paramPoint.y, paramPoint.x, j, paramInt1, this.OPd);
        if ((this.OPd != null) && (i == 0)) {
          this.OPd.OPF = this.OPd.OPE;
        }
        if (paramPoint != null)
        {
          paramPoint.source = 3;
          paramPoint.hBk = System.currentTimeMillis();
        }
        if (this.OPc != null) {
          this.OPc.a(paramPoint);
        }
        AppMethodBeat.o(313396);
        return;
        i = 0;
      }
    }
  }
  
  public static b gQw()
  {
    return OPb;
  }
  
  public final void a(final Point paramPoint, final int paramInt1, final int paramInt2, final boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(313425);
    if (this.OOw)
    {
      Log.w("MicroMsg.ReIdAiScanImageDecodeQueue", "dealDecodeImage image is decoding");
      AppMethodBeat.o(313425);
      return;
    }
    if (OPf == null)
    {
      Log.w("MicroMsg.ReIdAiScanImageDecodeQueue", "dealDecodeImage sPendingImage is null");
      AppMethodBeat.o(313425);
      return;
    }
    if ((OPg != null) && (OPf.id == OPg.id))
    {
      Log.w("MicroMsg.ReIdAiScanImageDecodeQueue", "dealDecodeImage image id is same, do not decode");
      AppMethodBeat.o(313425);
      return;
    }
    this.OOw = true;
    if (this.OPd != null)
    {
      b localb = this.OPd;
      localb.OPB += 1;
    }
    if (paramBoolean2)
    {
      a(new ad()
      {
        public final void run()
        {
          AppMethodBeat.i(313382);
          b.a(b.this, paramPoint, paramInt1, paramInt2, paramBoolean1);
          AppMethodBeat.o(313382);
        }
      });
      AppMethodBeat.o(313425);
      return;
    }
    a(paramPoint, paramInt1, paramInt2, paramBoolean1);
    AppMethodBeat.o(313425);
  }
  
  public final void gQA()
  {
    AppMethodBeat.i(313429);
    if (!com.tencent.mm.plugin.scanner.c.a.gQt())
    {
      AppMethodBeat.o(313429);
      return;
    }
    if ((this.sensorManager != null) && (this.OPj))
    {
      Log.i("MicroMsg.ReIdAiScanImageDecodeQueue", "stopSensorShakeDetect");
      this.sensorManager.unregisterListener(this.OPk);
    }
    this.OPj = false;
    AppMethodBeat.o(313429);
  }
  
  public final void gQx()
  {
    AppMethodBeat.i(313418);
    if ((this.OPe) && (com.tencent.mm.plugin.scanner.c.a.gQt()))
    {
      if (this.sensorManager == null) {
        this.sensorManager = ((SensorManager)MMApplicationContext.getContext().getSystemService("sensor"));
      }
      if ((this.sensorManager != null) && (this.OPi == null)) {
        this.OPi = this.sensorManager.getDefaultSensor(10);
      }
      if ((this.sensorManager != null) && (this.OPi != null) && (!this.OPj))
      {
        Log.i("MicroMsg.ReIdAiScanImageDecodeQueue", "startSensorShakeDetect");
        this.sensorManager.registerListener(this.OPk, this.OPi, 3);
        this.OPj = true;
      }
    }
    AppMethodBeat.o(313418);
  }
  
  public final void gQy()
  {
    AppMethodBeat.i(313422);
    if (this.OPe) {
      gQA();
    }
    this.OPh = 0;
    a(new ad()
    {
      public final void run()
      {
        AppMethodBeat.i(313376);
        if (b.a(b.this)) {
          ac.reset();
        }
        AppMethodBeat.o(313376);
      }
    });
    AppMethodBeat.o(313422);
  }
  
  public final void gQz()
  {
    if (this.OPd != null)
    {
      b localb = this.OPd;
      localb.OPH += 1;
    }
  }
  
  public static final class a
  {
    public long id;
    public byte[] imageData;
  }
  
  public final class b
  {
    public int OPA = 0;
    public int OPB = 0;
    public int OPC = 0;
    public int OPD = 0;
    public int OPE = 0;
    public int OPF = 0;
    public int OPG = 0;
    public int OPH = 0;
    public int OPI = 0;
    public int OPJ = 0;
    public int OPw = 0;
    public int OPx = 0;
    public int OPy = 0;
    public int OPz = 0;
    
    public b() {}
  }
  
  public static abstract interface c
  {
    public abstract void a(k paramk);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.d.b
 * JD-Core Version:    0.7.0.1
 */
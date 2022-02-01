package com.tencent.mm.pluginsdk.l;

import android.app.Activity;
import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build.VERSION;
import android.view.SurfaceHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.compatible.deviceinfo.c;
import com.tencent.mm.compatible.deviceinfo.d.a.a;
import com.tencent.mm.compatible.deviceinfo.w;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class g
  implements SensorEventListener
{
  private static int KUX = 0;
  private boolean KUW;
  private Sensor KUZ;
  private float KVa;
  private float KVb;
  private float KVc;
  private Camera.PreviewCallback PJm;
  private SurfaceHolder SPc;
  private boolean XXA;
  private Camera.AutoFocusCallback XXB;
  private a XXx;
  public List<Integer> XXy;
  private boolean XXz;
  public w lTN;
  private SensorManager mSensorManager;
  d.a.a nGr;
  
  public g()
  {
    AppMethodBeat.i(31186);
    this.lTN = null;
    this.KUW = false;
    this.SPc = null;
    this.XXy = new ArrayList();
    this.XXz = true;
    this.KVa = 0.0F;
    this.KVb = 0.0F;
    this.KVc = 0.0F;
    this.PJm = null;
    this.XXA = true;
    this.XXB = new Camera.AutoFocusCallback()
    {
      public final void onAutoFocus(boolean paramAnonymousBoolean, Camera paramAnonymousCamera)
      {
        AppMethodBeat.i(31185);
        Log.d("MicroMsg.YuvReocrder", "auto focus callback");
        g.a(g.this);
        AppMethodBeat.o(31185);
      }
    };
    AppMethodBeat.o(31186);
  }
  
  public static int getCameraId()
  {
    return KUX;
  }
  
  private static void k(Camera.Parameters paramParameters)
  {
    AppMethodBeat.i(31188);
    if (af.lXY.lTg > 0)
    {
      AppMethodBeat.o(31188);
      return;
    }
    if (Build.VERSION.SDK_INT < 9)
    {
      AppMethodBeat.o(31188);
      return;
    }
    List localList = paramParameters.getSupportedPreviewFpsRange();
    if ((localList == null) || (localList.size() == 0))
    {
      AppMethodBeat.o(31188);
      return;
    }
    int i1 = localList.size();
    int k = 0;
    int j = -2147483648;
    int i = -2147483648;
    if (k < i1)
    {
      int[] arrayOfInt = (int[])localList.get(k);
      if ((arrayOfInt == null) || (arrayOfInt.length <= 1)) {
        break label267;
      }
      int n = arrayOfInt[0];
      int m = arrayOfInt[1];
      Log.d("MicroMsg.YuvReocrder", "dkfps %d:[%d %d]", new Object[] { Integer.valueOf(k), Integer.valueOf(n), Integer.valueOf(m) });
      if ((n < 0) || (m < n) || (m < j)) {
        break label267;
      }
      i = n;
      j = m;
    }
    label267:
    for (;;)
    {
      k += 1;
      break;
      Log.d("MicroMsg.YuvReocrder", "dkfps get fit  [%d %d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      if ((i == 2147483647) || (j == 2147483647))
      {
        AppMethodBeat.o(31188);
        return;
      }
      try
      {
        paramParameters.setPreviewFpsRange(i, j);
        AppMethodBeat.o(31188);
        return;
      }
      catch (Exception paramParameters)
      {
        Log.printErrStackTrace("MicroMsg.YuvReocrder", paramParameters, "", new Object[0]);
        AppMethodBeat.o(31188);
        return;
      }
    }
  }
  
  public final int a(Activity paramActivity, a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(31190);
    int i;
    if (parama == null)
    {
      i = f.getLine();
      AppMethodBeat.o(31190);
      return 0 - i;
    }
    this.XXx = parama;
    if ((this.mSensorManager == null) && (this.KUZ == null))
    {
      this.mSensorManager = ((SensorManager)MMApplicationContext.getContext().getSystemService("sensor"));
      this.KUZ = this.mSensorManager.getDefaultSensor(1);
    }
    if ((paramBoolean) || (this.lTN == null))
    {
      gbX();
      if (paramBoolean) {
        KUX = (KUX ^ 0xFFFFFFFF) & 0x1;
      }
      this.nGr = com.tencent.mm.compatible.deviceinfo.d.G(paramActivity, KUX);
      if (this.nGr == null)
      {
        Log.e("MicroMsg.YuvReocrder", "start camera FAILED!");
        i = f.getLine();
        AppMethodBeat.o(31190);
        return 0 - i;
      }
      this.lTN = this.nGr.lTN;
      this.XXx.hYK = this.nGr.hYK;
      if (this.lTN == null)
      {
        Log.e("MicroMsg.YuvReocrder", "start camera FAILED!");
        i = f.getLine();
        AppMethodBeat.o(31190);
        return 0 - i;
      }
    }
    AppMethodBeat.o(31190);
    return 0;
  }
  
  public final int e(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(31189);
    if (this.KUW)
    {
      AppMethodBeat.o(31189);
      return 0;
    }
    int i;
    if (paramSurfaceHolder == null)
    {
      i = f.getLine();
      AppMethodBeat.o(31189);
      return 0 - i;
    }
    for (;;)
    {
      Object localObject;
      int k;
      try
      {
        this.SPc = paramSurfaceHolder;
        localParameters = this.lTN.aPy();
        locala = this.XXx;
        Log.d("MicroMsg.YuvReocrder", "getFitRecordSize");
        j = 2147483647;
        localObject = com.tencent.mm.compatible.deviceinfo.d.b(localParameters);
        if (localObject != null) {
          break label675;
        }
        Log.d("MicroMsg.YuvReocrder", "getFitRecordSize getSupportedVideoSizes null, use getSupportedPreviewSizes instead");
        localObject = com.tencent.mm.compatible.deviceinfo.d.a(localParameters);
      }
      catch (Exception paramSurfaceHolder)
      {
        Camera.Parameters localParameters;
        a locala;
        int j;
        int n;
        int i1;
        int m;
        Log.printErrStackTrace("MicroMsg.YuvReocrder", paramSurfaceHolder, "", new Object[0]);
        Log.e("MicroMsg.YuvReocrder", "Start preview FAILED :" + paramSurfaceHolder.getMessage());
        i = f.getLine();
        AppMethodBeat.o(31189);
        return 0 - i;
      }
      if (k < ((List)localObject).size())
      {
        n = ((Camera.Size)((List)localObject).get(k)).height;
        i1 = ((Camera.Size)((List)localObject).get(k)).width;
        Log.d("MicroMsg.YuvReocrder", "supp w:" + i1 + " h:" + n);
        m = n * i1;
        if (((locala.hYK != 0) && (locala.hYK != 180)) || (((n >= locala.nAh) && (i1 >= locala.nAg)) || (((locala.hYK == 90) || (locala.hYK == 270)) && (i1 >= locala.nAh) && (n >= locala.nAg) && (m < j))))
        {
          locala.zWH = i1;
          locala.zWI = n;
          i = 1;
          j = m;
          break label688;
        }
      }
      else
      {
        if (i == 0)
        {
          localObject = localParameters.getPreviewSize();
          locala.zWI = ((Camera.Size)localObject).height;
          locala.zWH = ((Camera.Size)localObject).width;
        }
        Log.d("MicroMsg.YuvReocrder", " rotate:" + locala.hYK + " w:" + locala.zWH + " h:" + locala.zWI);
        localParameters.setPreviewSize(this.XXx.zWH, this.XXx.zWI);
        k(localParameters);
        localObject = localParameters.getSupportedPreviewFrameRates();
        this.XXy.clear();
        this.XXy.addAll((Collection)localObject);
        localParameters.setPreviewFormat(17);
        localObject = localParameters.getSupportedFocusModes();
        if (localObject != null)
        {
          if ((com.tencent.mm.compatible.util.d.rd(9)) && (true == ((List)localObject).contains("continuous-video")))
          {
            Log.i("MicroMsg.YuvReocrder", "support continous-video");
            this.XXz = false;
            localParameters.setFocusMode("continuous-video");
          }
        }
        else
        {
          this.lTN.c(localParameters);
          this.lTN.a(paramSurfaceHolder);
          this.lTN.aPz();
          if ((this.mSensorManager != null) && (this.KUZ != null) && (this.XXz)) {
            this.mSensorManager.registerListener(this, this.KUZ, 2);
          }
          this.KUW = true;
          AppMethodBeat.o(31189);
          return 0;
          localObject = localParameters.getPreviewSize();
          locala.zWI = ((Camera.Size)localObject).height;
          locala.zWH = ((Camera.Size)localObject).width;
          continue;
        }
        if (((List)localObject).contains("auto")) {
          continue;
        }
        Log.i("MicroMsg.YuvReocrder", "don't support auto");
        this.XXz = false;
        continue;
      }
      label675:
      if (localObject != null)
      {
        k = 0;
        i = 0;
        continue;
        label688:
        k += 1;
      }
    }
  }
  
  public final void gbX()
  {
    AppMethodBeat.i(31187);
    if ((this.mSensorManager != null) && (this.KUZ != null)) {
      this.mSensorManager.unregisterListener(this);
    }
    if (this.lTN != null)
    {
      Log.d("MicroMsg.YuvReocrder", "release camera");
      this.lTN.a(null);
      this.lTN.auq();
      this.lTN.release();
      this.lTN = null;
      this.KUW = false;
    }
    AppMethodBeat.o(31187);
  }
  
  public final void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public final void onSensorChanged(SensorEvent paramSensorEvent)
  {
    AppMethodBeat.i(31191);
    float f1 = paramSensorEvent.values[0];
    float f2 = paramSensorEvent.values[1];
    float f3 = paramSensorEvent.values[2];
    if (((Math.abs(this.KVa - f1) > 2.0F) || (Math.abs(this.KVb - f2) > 2.0F) || (Math.abs(this.KVc - f3) > 2.0F)) && (this.lTN != null) && (this.XXA) && (true == this.XXz)) {}
    try
    {
      Log.d("MicroMsg.YuvReocrder", "auto focus");
      this.lTN.a(this.XXB);
      this.XXA = false;
      this.KVa = f1;
      this.KVb = f2;
      this.KVc = f3;
      AppMethodBeat.o(31191);
      return;
    }
    catch (Exception paramSensorEvent)
    {
      for (;;)
      {
        Log.d("MicroMsg.YuvReocrder", "auto focus failed");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.l.g
 * JD-Core Version:    0.7.0.1
 */
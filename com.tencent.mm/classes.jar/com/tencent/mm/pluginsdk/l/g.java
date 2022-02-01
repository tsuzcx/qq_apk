package com.tencent.mm.pluginsdk.l;

import android.annotation.TargetApi;
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
import com.tencent.mm.compatible.deviceinfo.c;
import com.tencent.mm.compatible.deviceinfo.d.a.a;
import com.tencent.mm.compatible.deviceinfo.h;
import com.tencent.mm.compatible.deviceinfo.v;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class g
  implements SensorEventListener
{
  private static int vZH = 0;
  private SurfaceHolder BGR;
  private a FjV;
  public List<Integer> FjW;
  private boolean FjX;
  private boolean FjY;
  private Camera.AutoFocusCallback FjZ;
  public v gaZ;
  d.a.a hsD;
  private Camera.PreviewCallback mPreviewCallback;
  private SensorManager mSensorManager;
  private boolean vZG;
  private Sensor vZJ;
  private float vZK;
  private float vZL;
  private float vZM;
  
  public g()
  {
    AppMethodBeat.i(31186);
    this.gaZ = null;
    this.vZG = false;
    this.BGR = null;
    this.FjW = new ArrayList();
    this.FjX = true;
    this.vZK = 0.0F;
    this.vZL = 0.0F;
    this.vZM = 0.0F;
    this.mPreviewCallback = null;
    this.FjY = true;
    this.FjZ = new Camera.AutoFocusCallback()
    {
      public final void onAutoFocus(boolean paramAnonymousBoolean, Camera paramAnonymousCamera)
      {
        AppMethodBeat.i(31185);
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.YuvReocrder", "auto focus callback");
        g.a(g.this);
        AppMethodBeat.o(31185);
      }
    };
    AppMethodBeat.o(31186);
  }
  
  @TargetApi(9)
  private static void g(Camera.Parameters paramParameters)
  {
    AppMethodBeat.i(31188);
    if (com.tencent.mm.compatible.deviceinfo.ae.geM.gaz > 0)
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
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.YuvReocrder", "dkfps %d:[%d %d]", new Object[] { Integer.valueOf(k), Integer.valueOf(n), Integer.valueOf(m) });
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
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.YuvReocrder", "dkfps get fit  [%d %d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
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
        com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.YuvReocrder", paramParameters, "", new Object[0]);
        AppMethodBeat.o(31188);
        return;
      }
    }
  }
  
  public static int getCameraId()
  {
    return vZH;
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
    this.FjV = parama;
    if ((this.mSensorManager == null) && (this.vZJ == null))
    {
      this.mSensorManager = ((SensorManager)ak.getContext().getSystemService("sensor"));
      this.vZJ = this.mSensorManager.getDefaultSensor(1);
    }
    if ((paramBoolean) || (this.gaZ == null))
    {
      dpI();
      if (paramBoolean) {
        vZH = (vZH ^ 0xFFFFFFFF) & 0x1;
      }
      this.hsD = com.tencent.mm.compatible.deviceinfo.d.a(paramActivity, vZH, null);
      if (this.hsD == null)
      {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.YuvReocrder", "start camera FAILED!");
        i = f.getLine();
        AppMethodBeat.o(31190);
        return 0 - i;
      }
      this.gaZ = this.hsD.gaZ;
      this.FjV.dHi = this.hsD.dHi;
      if (this.gaZ == null)
      {
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.YuvReocrder", "start camera FAILED!");
        i = f.getLine();
        AppMethodBeat.o(31190);
        return 0 - i;
      }
    }
    AppMethodBeat.o(31190);
    return 0;
  }
  
  public final int b(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(31189);
    if (this.vZG)
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
        this.BGR = paramSurfaceHolder;
        localParameters = this.gaZ.getParameters();
        locala = this.FjV;
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.YuvReocrder", "getFitRecordSize");
        j = 2147483647;
        if (Build.VERSION.SDK_INT < 11) {
          break label723;
        }
        new h();
        localObject = localParameters.getSupportedVideoSizes();
        if (localObject != null) {
          break label701;
        }
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.YuvReocrder", "getFitRecordSize getSupportedVideoSizes null, use getSupportedPreviewSizes instead");
        new com.tencent.mm.compatible.deviceinfo.g();
        localObject = localParameters.getSupportedPreviewSizes();
      }
      catch (Exception paramSurfaceHolder)
      {
        Camera.Parameters localParameters;
        a locala;
        int j;
        int n;
        int i1;
        int m;
        com.tencent.mm.sdk.platformtools.ae.printErrStackTrace("MicroMsg.YuvReocrder", paramSurfaceHolder, "", new Object[0]);
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.YuvReocrder", "Start preview FAILED :" + paramSurfaceHolder.getMessage());
        i = f.getLine();
        AppMethodBeat.o(31189);
        return 0 - i;
      }
      if (k < ((List)localObject).size())
      {
        n = ((Camera.Size)((List)localObject).get(k)).height;
        i1 = ((Camera.Size)((List)localObject).get(k)).width;
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.YuvReocrder", "supp w:" + i1 + " h:" + n);
        m = n * i1;
        if (((locala.dHi != 0) && (locala.dHi != 180)) || (((n >= locala.waN) && (i1 >= locala.waO)) || (((locala.dHi == 90) || (locala.dHi == 270)) && (i1 >= locala.waN) && (n >= locala.waO) && (m < j))))
        {
          locala.ruC = i1;
          locala.ruD = n;
          i = 1;
          j = m;
          break label714;
        }
      }
      else
      {
        if (i == 0)
        {
          localObject = localParameters.getPreviewSize();
          locala.ruD = ((Camera.Size)localObject).height;
          locala.ruC = ((Camera.Size)localObject).width;
        }
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.YuvReocrder", " rotate:" + locala.dHi + " w:" + locala.ruC + " h:" + locala.ruD);
        localParameters.setPreviewSize(this.FjV.ruC, this.FjV.ruD);
        g(localParameters);
        localObject = localParameters.getSupportedPreviewFrameRates();
        this.FjW.clear();
        this.FjW.addAll((Collection)localObject);
        localParameters.setPreviewFormat(17);
        localObject = localParameters.getSupportedFocusModes();
        if (localObject != null)
        {
          if ((com.tencent.mm.compatible.util.d.lC(9)) && (true == ((List)localObject).contains("continuous-video")))
          {
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.YuvReocrder", "support continous-video");
            this.FjX = false;
            localParameters.setFocusMode("continuous-video");
          }
        }
        else
        {
          this.gaZ.setParameters(localParameters);
          this.gaZ.setPreviewDisplay(paramSurfaceHolder);
          this.gaZ.startPreview();
          if ((this.mSensorManager != null) && (this.vZJ != null) && (this.FjX)) {
            this.mSensorManager.registerListener(this, this.vZJ, 2);
          }
          this.vZG = true;
          AppMethodBeat.o(31189);
          return 0;
          localObject = localParameters.getPreviewSize();
          locala.ruD = ((Camera.Size)localObject).height;
          locala.ruC = ((Camera.Size)localObject).width;
          continue;
        }
        if (((List)localObject).contains("auto")) {
          continue;
        }
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.YuvReocrder", "don't support auto");
        this.FjX = false;
        continue;
      }
      label701:
      if (localObject != null)
      {
        k = 0;
        i = 0;
        continue;
        label714:
        k += 1;
        continue;
        label723:
        localObject = null;
      }
    }
  }
  
  public final void dpI()
  {
    AppMethodBeat.i(31187);
    if ((this.mSensorManager != null) && (this.vZJ != null)) {
      this.mSensorManager.unregisterListener(this);
    }
    if (this.gaZ != null)
    {
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.YuvReocrder", "release camera");
      this.gaZ.setPreviewCallback(null);
      this.gaZ.stopPreview();
      this.gaZ.release();
      this.gaZ = null;
      this.vZG = false;
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
    if (((Math.abs(this.vZK - f1) > 2.0F) || (Math.abs(this.vZL - f2) > 2.0F) || (Math.abs(this.vZM - f3) > 2.0F)) && (this.gaZ != null) && (this.FjY) && (true == this.FjX)) {}
    try
    {
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.YuvReocrder", "auto focus");
      this.gaZ.autoFocus(this.FjZ);
      this.FjY = false;
      this.vZK = f1;
      this.vZL = f2;
      this.vZM = f3;
      AppMethodBeat.o(31191);
      return;
    }
    catch (Exception paramSensorEvent)
    {
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.YuvReocrder", "auto focus failed");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.l.g
 * JD-Core Version:    0.7.0.1
 */
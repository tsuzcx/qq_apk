package com.tencent.mm.pluginsdk.i;

import android.annotation.TargetApi;
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
import com.tencent.mm.compatible.e.c;
import com.tencent.mm.compatible.e.d.a.a;
import com.tencent.mm.compatible.e.h;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class f
  implements SensorEventListener
{
  static int mgz = 0;
  SensorManager aVT;
  public Camera dwJ = null;
  d.a.a jXx;
  private Camera.PreviewCallback mPreviewCallback = null;
  Sensor mgB;
  private float mgC = 0.0F;
  private float mgD = 0.0F;
  private float mgE = 0.0F;
  private boolean mgy = false;
  private SurfaceHolder pCw = null;
  a rYt;
  public List<Integer> rYu = new ArrayList();
  private boolean rYv = true;
  private boolean rYw = true;
  private Camera.AutoFocusCallback rYx = new f.1(this);
  
  @TargetApi(9)
  private static void f(Camera.Parameters paramParameters)
  {
    if (q.dyd.dwn > 0) {}
    List localList;
    do
    {
      do
      {
        return;
      } while (Build.VERSION.SDK_INT < 9);
      localList = paramParameters.getSupportedPreviewFpsRange();
    } while ((localList == null) || (localList.size() == 0));
    int i1 = localList.size();
    int k = 0;
    int j = -2147483648;
    int i = -2147483648;
    label56:
    if (k < i1)
    {
      int[] arrayOfInt = (int[])localList.get(k);
      if ((arrayOfInt == null) || (arrayOfInt.length <= 1)) {
        break label222;
      }
      int n = arrayOfInt[0];
      int m = arrayOfInt[1];
      y.d("MicroMsg.YuvReocrder", "dkfps %d:[%d %d]", new Object[] { Integer.valueOf(k), Integer.valueOf(n), Integer.valueOf(m) });
      if ((n < 0) || (m < n) || (m < j)) {
        break label222;
      }
      i = n;
      j = m;
    }
    label222:
    for (;;)
    {
      k += 1;
      break label56;
      y.d("MicroMsg.YuvReocrder", "dkfps get fit  [%d %d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      if ((i == 2147483647) || (j == 2147483647)) {
        break;
      }
      try
      {
        paramParameters.setPreviewFpsRange(i, j);
        return;
      }
      catch (Exception paramParameters)
      {
        y.printErrStackTrace("MicroMsg.YuvReocrder", paramParameters, "", new Object[0]);
        return;
      }
    }
  }
  
  public static int getCameraId()
  {
    return mgz;
  }
  
  public final int b(SurfaceHolder paramSurfaceHolder)
  {
    if (this.mgy) {
      return 0;
    }
    if (paramSurfaceHolder == null) {
      return 0 - com.tencent.mm.compatible.util.g.getLine();
    }
    for (;;)
    {
      Object localObject;
      int k;
      int i;
      try
      {
        this.pCw = paramSurfaceHolder;
        localParameters = this.dwJ.getParameters();
        locala = this.rYt;
        y.d("MicroMsg.YuvReocrder", "getFitRecordSize");
        j = 2147483647;
        if (Build.VERSION.SDK_INT < 11) {
          break label685;
        }
        new h();
        localObject = localParameters.getSupportedVideoSizes();
        if (localObject != null) {
          break label663;
        }
        y.d("MicroMsg.YuvReocrder", "getFitRecordSize getSupportedVideoSizes null, use getSupportedPreviewSizes instead");
        new com.tencent.mm.compatible.e.g();
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
        y.printErrStackTrace("MicroMsg.YuvReocrder", paramSurfaceHolder, "", new Object[0]);
        y.e("MicroMsg.YuvReocrder", "Start preview FAILED :" + paramSurfaceHolder.getMessage());
        return 0 - com.tencent.mm.compatible.util.g.getLine();
      }
      if (k < ((List)localObject).size())
      {
        n = ((Camera.Size)((List)localObject).get(k)).height;
        i1 = ((Camera.Size)((List)localObject).get(k)).width;
        y.d("MicroMsg.YuvReocrder", "supp w:" + i1 + " h:" + n);
        m = n * i1;
        if (((locala.rotate != 0) && (locala.rotate != 180)) || (((n >= locala.mhT) && (i1 >= locala.mhU)) || (((locala.rotate == 90) || (locala.rotate == 270)) && (i1 >= locala.mhT) && (n >= locala.mhU) && (m < j))))
        {
          locala.jSV = i1;
          locala.jSW = n;
          i = 1;
          j = m;
          break label676;
        }
      }
      else
      {
        if (i == 0)
        {
          localObject = localParameters.getPreviewSize();
          locala.jSW = ((Camera.Size)localObject).height;
          locala.jSV = ((Camera.Size)localObject).width;
        }
        y.d("MicroMsg.YuvReocrder", " rotate:" + locala.rotate + " w:" + locala.jSV + " h:" + locala.jSW);
        localParameters.setPreviewSize(this.rYt.jSV, this.rYt.jSW);
        f(localParameters);
        localObject = localParameters.getSupportedPreviewFrameRates();
        this.rYu.clear();
        this.rYu.addAll((Collection)localObject);
        localParameters.setPreviewFormat(17);
        localObject = localParameters.getSupportedFocusModes();
        if (localObject != null)
        {
          if ((d.gH(9)) && (true == ((List)localObject).contains("continuous-video")))
          {
            y.i("MicroMsg.YuvReocrder", "support continous-video");
            this.rYv = false;
            localParameters.setFocusMode("continuous-video");
          }
        }
        else
        {
          this.dwJ.setParameters(localParameters);
          this.dwJ.setPreviewDisplay(paramSurfaceHolder);
          this.dwJ.startPreview();
          if ((this.aVT != null) && (this.mgB != null) && (this.rYv)) {
            this.aVT.registerListener(this, this.mgB, 2);
          }
          this.mgy = true;
          return 0;
          localObject = localParameters.getPreviewSize();
          locala.jSW = ((Camera.Size)localObject).height;
          locala.jSV = ((Camera.Size)localObject).width;
          continue;
        }
        if (((List)localObject).contains("auto")) {
          continue;
        }
        y.i("MicroMsg.YuvReocrder", "don't support auto");
        this.rYv = false;
        continue;
      }
      label663:
      if (localObject != null)
      {
        k = 0;
        i = 0;
        continue;
        label676:
        k += 1;
        continue;
        label685:
        localObject = null;
      }
    }
  }
  
  public final void biI()
  {
    if ((this.aVT != null) && (this.mgB != null)) {
      this.aVT.unregisterListener(this);
    }
    if (this.dwJ != null)
    {
      y.d("MicroMsg.YuvReocrder", "release camera");
      this.dwJ.setPreviewCallback(null);
      this.dwJ.stopPreview();
      this.dwJ.release();
      this.dwJ = null;
      this.mgy = false;
    }
  }
  
  public final void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public final void onSensorChanged(SensorEvent paramSensorEvent)
  {
    float f1 = paramSensorEvent.values[0];
    float f2 = paramSensorEvent.values[1];
    float f3 = paramSensorEvent.values[2];
    if (((Math.abs(this.mgC - f1) > 2.0F) || (Math.abs(this.mgD - f2) > 2.0F) || (Math.abs(this.mgE - f3) > 2.0F)) && (this.dwJ != null) && (this.rYw) && (true == this.rYv)) {}
    try
    {
      y.d("MicroMsg.YuvReocrder", "auto focus");
      this.dwJ.autoFocus(this.rYx);
      this.rYw = false;
      this.mgC = f1;
      this.mgD = f2;
      this.mgE = f3;
      return;
    }
    catch (Exception paramSensorEvent)
    {
      for (;;)
      {
        y.d("MicroMsg.YuvReocrder", "auto focus failed");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.i.f
 * JD-Core Version:    0.7.0.1
 */
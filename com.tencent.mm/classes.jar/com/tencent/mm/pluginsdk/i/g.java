package com.tencent.mm.pluginsdk.i;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
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
import com.tencent.mm.compatible.e.ac;
import com.tencent.mm.compatible.e.c;
import com.tencent.mm.compatible.e.d.a.a;
import com.tencent.mm.compatible.e.h;
import com.tencent.mm.compatible.e.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class g
  implements SensorEventListener
{
  private static int oGU = 0;
  private SensorManager bmB;
  public u eoH;
  d.a.a fau;
  private Camera.PreviewCallback mPreviewCallback;
  private boolean oGT;
  private Sensor oGW;
  private float oGX;
  private float oGY;
  private float oGZ;
  private SurfaceHolder teg;
  private a vPi;
  public List<Integer> vPj;
  private boolean vPk;
  private boolean vPl;
  private Camera.AutoFocusCallback vPm;
  
  public g()
  {
    AppMethodBeat.i(27484);
    this.eoH = null;
    this.oGT = false;
    this.teg = null;
    this.vPj = new ArrayList();
    this.vPk = true;
    this.oGX = 0.0F;
    this.oGY = 0.0F;
    this.oGZ = 0.0F;
    this.mPreviewCallback = null;
    this.vPl = true;
    this.vPm = new g.1(this);
    AppMethodBeat.o(27484);
  }
  
  public static int getCameraId()
  {
    return oGU;
  }
  
  @TargetApi(9)
  private static void i(Camera.Parameters paramParameters)
  {
    AppMethodBeat.i(27486);
    if (ac.eru.eoh > 0)
    {
      AppMethodBeat.o(27486);
      return;
    }
    if (Build.VERSION.SDK_INT < 9)
    {
      AppMethodBeat.o(27486);
      return;
    }
    List localList = paramParameters.getSupportedPreviewFpsRange();
    if ((localList == null) || (localList.size() == 0))
    {
      AppMethodBeat.o(27486);
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
      ab.d("MicroMsg.YuvReocrder", "dkfps %d:[%d %d]", new Object[] { Integer.valueOf(k), Integer.valueOf(n), Integer.valueOf(m) });
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
      ab.d("MicroMsg.YuvReocrder", "dkfps get fit  [%d %d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      if ((i == 2147483647) || (j == 2147483647))
      {
        AppMethodBeat.o(27486);
        return;
      }
      try
      {
        paramParameters.setPreviewFpsRange(i, j);
        AppMethodBeat.o(27486);
        return;
      }
      catch (Exception paramParameters)
      {
        ab.printErrStackTrace("MicroMsg.YuvReocrder", paramParameters, "", new Object[0]);
        AppMethodBeat.o(27486);
        return;
      }
    }
  }
  
  public final int a(Activity paramActivity, a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(27488);
    int i;
    if (parama == null)
    {
      i = com.tencent.mm.compatible.util.g.getLine();
      AppMethodBeat.o(27488);
      return 0 - i;
    }
    this.vPi = parama;
    if ((this.bmB == null) && (this.oGW == null))
    {
      this.bmB = ((SensorManager)ah.getContext().getSystemService("sensor"));
      this.oGW = this.bmB.getDefaultSensor(1);
    }
    if ((paramBoolean) || (this.eoH == null))
    {
      bQK();
      if (paramBoolean) {
        oGU = (oGU ^ 0xFFFFFFFF) & 0x1;
      }
      this.fau = com.tencent.mm.compatible.e.d.a(paramActivity, oGU, null);
      if (this.fau == null)
      {
        ab.e("MicroMsg.YuvReocrder", "start camera FAILED!");
        i = com.tencent.mm.compatible.util.g.getLine();
        AppMethodBeat.o(27488);
        return 0 - i;
      }
      this.eoH = this.fau.eoH;
      this.vPi.rotate = this.fau.rotate;
      if (this.eoH == null)
      {
        ab.e("MicroMsg.YuvReocrder", "start camera FAILED!");
        i = com.tencent.mm.compatible.util.g.getLine();
        AppMethodBeat.o(27488);
        return 0 - i;
      }
    }
    AppMethodBeat.o(27488);
    return 0;
  }
  
  public final int b(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(27487);
    if (this.oGT)
    {
      AppMethodBeat.o(27487);
      return 0;
    }
    int i;
    if (paramSurfaceHolder == null)
    {
      i = com.tencent.mm.compatible.util.g.getLine();
      AppMethodBeat.o(27487);
      return 0 - i;
    }
    for (;;)
    {
      Object localObject;
      int k;
      try
      {
        this.teg = paramSurfaceHolder;
        localParameters = this.eoH.getParameters();
        locala = this.vPi;
        ab.d("MicroMsg.YuvReocrder", "getFitRecordSize");
        j = 2147483647;
        if (Build.VERSION.SDK_INT < 11) {
          break label723;
        }
        new h();
        localObject = localParameters.getSupportedVideoSizes();
        if (localObject != null) {
          break label701;
        }
        ab.d("MicroMsg.YuvReocrder", "getFitRecordSize getSupportedVideoSizes null, use getSupportedPreviewSizes instead");
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
        ab.printErrStackTrace("MicroMsg.YuvReocrder", paramSurfaceHolder, "", new Object[0]);
        ab.e("MicroMsg.YuvReocrder", "Start preview FAILED :" + paramSurfaceHolder.getMessage());
        i = com.tencent.mm.compatible.util.g.getLine();
        AppMethodBeat.o(27487);
        return 0 - i;
      }
      if (k < ((List)localObject).size())
      {
        n = ((Camera.Size)((List)localObject).get(k)).height;
        i1 = ((Camera.Size)((List)localObject).get(k)).width;
        ab.d("MicroMsg.YuvReocrder", "supp w:" + i1 + " h:" + n);
        m = n * i1;
        if (((locala.rotate != 0) && (locala.rotate != 180)) || (((n >= locala.oHZ) && (i1 >= locala.oIa)) || (((locala.rotate == 90) || (locala.rotate == 270)) && (i1 >= locala.oHZ) && (n >= locala.oIa) && (m < j))))
        {
          locala.mnr = i1;
          locala.mns = n;
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
          locala.mns = ((Camera.Size)localObject).height;
          locala.mnr = ((Camera.Size)localObject).width;
        }
        ab.d("MicroMsg.YuvReocrder", " rotate:" + locala.rotate + " w:" + locala.mnr + " h:" + locala.mns);
        localParameters.setPreviewSize(this.vPi.mnr, this.vPi.mns);
        i(localParameters);
        localObject = localParameters.getSupportedPreviewFrameRates();
        this.vPj.clear();
        this.vPj.addAll((Collection)localObject);
        localParameters.setPreviewFormat(17);
        localObject = localParameters.getSupportedFocusModes();
        if (localObject != null)
        {
          if ((com.tencent.mm.compatible.util.d.iU(9)) && (true == ((List)localObject).contains("continuous-video")))
          {
            ab.i("MicroMsg.YuvReocrder", "support continous-video");
            this.vPk = false;
            localParameters.setFocusMode("continuous-video");
          }
        }
        else
        {
          this.eoH.setParameters(localParameters);
          this.eoH.setPreviewDisplay(paramSurfaceHolder);
          this.eoH.startPreview();
          if ((this.bmB != null) && (this.oGW != null) && (this.vPk)) {
            this.bmB.registerListener(this, this.oGW, 2);
          }
          this.oGT = true;
          AppMethodBeat.o(27487);
          return 0;
          localObject = localParameters.getPreviewSize();
          locala.mns = ((Camera.Size)localObject).height;
          locala.mnr = ((Camera.Size)localObject).width;
          continue;
        }
        if (((List)localObject).contains("auto")) {
          continue;
        }
        ab.i("MicroMsg.YuvReocrder", "don't support auto");
        this.vPk = false;
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
  
  public final void bQK()
  {
    AppMethodBeat.i(27485);
    if ((this.bmB != null) && (this.oGW != null)) {
      this.bmB.unregisterListener(this);
    }
    if (this.eoH != null)
    {
      ab.d("MicroMsg.YuvReocrder", "release camera");
      this.eoH.setPreviewCallback(null);
      this.eoH.stopPreview();
      this.eoH.release();
      this.eoH = null;
      this.oGT = false;
    }
    AppMethodBeat.o(27485);
  }
  
  public final void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public final void onSensorChanged(SensorEvent paramSensorEvent)
  {
    AppMethodBeat.i(27489);
    float f1 = paramSensorEvent.values[0];
    float f2 = paramSensorEvent.values[1];
    float f3 = paramSensorEvent.values[2];
    if (((Math.abs(this.oGX - f1) > 2.0F) || (Math.abs(this.oGY - f2) > 2.0F) || (Math.abs(this.oGZ - f3) > 2.0F)) && (this.eoH != null) && (this.vPl) && (true == this.vPk)) {}
    try
    {
      ab.d("MicroMsg.YuvReocrder", "auto focus");
      this.eoH.autoFocus(this.vPm);
      this.vPl = false;
      this.oGX = f1;
      this.oGY = f2;
      this.oGZ = f3;
      AppMethodBeat.o(27489);
      return;
    }
    catch (Exception paramSensorEvent)
    {
      for (;;)
      {
        ab.d("MicroMsg.YuvReocrder", "auto focus failed");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.i.g
 * JD-Core Version:    0.7.0.1
 */
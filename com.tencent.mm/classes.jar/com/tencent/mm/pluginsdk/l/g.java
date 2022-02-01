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
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.c;
import com.tencent.mm.compatible.deviceinfo.d.a.a;
import com.tencent.mm.compatible.deviceinfo.h;
import com.tencent.mm.compatible.deviceinfo.v;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class g
  implements SensorEventListener
{
  private static int ztK = 0;
  private Camera.PreviewCallback Dqj;
  private SurfaceHolder FRI;
  private a KaN;
  public List<Integer> KaO;
  private boolean KaP;
  private boolean KaQ;
  private Camera.AutoFocusCallback KaR;
  public v gGr;
  d.a.a imk;
  private SensorManager mSensorManager;
  private boolean ztJ;
  private Sensor ztM;
  private float ztN;
  private float ztO;
  private float ztP;
  
  public g()
  {
    AppMethodBeat.i(31186);
    this.gGr = null;
    this.ztJ = false;
    this.FRI = null;
    this.KaO = new ArrayList();
    this.KaP = true;
    this.ztN = 0.0F;
    this.ztO = 0.0F;
    this.ztP = 0.0F;
    this.Dqj = null;
    this.KaQ = true;
    this.KaR = new Camera.AutoFocusCallback()
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
  
  @TargetApi(9)
  private static void f(Camera.Parameters paramParameters)
  {
    AppMethodBeat.i(31188);
    if (ae.gKt.gFP > 0)
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
  
  public static int getCameraId()
  {
    return ztK;
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
    this.KaN = parama;
    if ((this.mSensorManager == null) && (this.ztM == null))
    {
      this.mSensorManager = ((SensorManager)MMApplicationContext.getContext().getSystemService("sensor"));
      this.ztM = this.mSensorManager.getDefaultSensor(1);
    }
    if ((paramBoolean) || (this.gGr == null))
    {
      ejx();
      if (paramBoolean) {
        ztK = (ztK ^ 0xFFFFFFFF) & 0x1;
      }
      this.imk = com.tencent.mm.compatible.deviceinfo.d.a(paramActivity, ztK, null);
      if (this.imk == null)
      {
        Log.e("MicroMsg.YuvReocrder", "start camera FAILED!");
        i = f.getLine();
        AppMethodBeat.o(31190);
        return 0 - i;
      }
      this.gGr = this.imk.gGr;
      this.KaN.dYT = this.imk.dYT;
      if (this.gGr == null)
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
  
  public final int b(SurfaceHolder paramSurfaceHolder)
  {
    AppMethodBeat.i(31189);
    if (this.ztJ)
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
        this.FRI = paramSurfaceHolder;
        localParameters = this.gGr.getParameters();
        locala = this.KaN;
        Log.d("MicroMsg.YuvReocrder", "getFitRecordSize");
        j = 2147483647;
        if (Build.VERSION.SDK_INT < 11) {
          break label723;
        }
        new h();
        localObject = localParameters.getSupportedVideoSizes();
        if (localObject != null) {
          break label701;
        }
        Log.d("MicroMsg.YuvReocrder", "getFitRecordSize getSupportedVideoSizes null, use getSupportedPreviewSizes instead");
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
        if (((locala.dYT != 0) && (locala.dYT != 180)) || (((n >= locala.ifO) && (i1 >= locala.ifN)) || (((locala.dYT == 90) || (locala.dYT == 270)) && (i1 >= locala.ifO) && (n >= locala.ifN) && (m < j))))
        {
          locala.sUz = i1;
          locala.sUA = n;
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
          locala.sUA = ((Camera.Size)localObject).height;
          locala.sUz = ((Camera.Size)localObject).width;
        }
        Log.d("MicroMsg.YuvReocrder", " rotate:" + locala.dYT + " w:" + locala.sUz + " h:" + locala.sUA);
        localParameters.setPreviewSize(this.KaN.sUz, this.KaN.sUA);
        f(localParameters);
        localObject = localParameters.getSupportedPreviewFrameRates();
        this.KaO.clear();
        this.KaO.addAll((Collection)localObject);
        localParameters.setPreviewFormat(17);
        localObject = localParameters.getSupportedFocusModes();
        if (localObject != null)
        {
          if ((com.tencent.mm.compatible.util.d.oF(9)) && (true == ((List)localObject).contains("continuous-video")))
          {
            Log.i("MicroMsg.YuvReocrder", "support continous-video");
            this.KaP = false;
            localParameters.setFocusMode("continuous-video");
          }
        }
        else
        {
          this.gGr.setParameters(localParameters);
          this.gGr.setPreviewDisplay(paramSurfaceHolder);
          this.gGr.startPreview();
          if ((this.mSensorManager != null) && (this.ztM != null) && (this.KaP)) {
            this.mSensorManager.registerListener(this, this.ztM, 2);
          }
          this.ztJ = true;
          AppMethodBeat.o(31189);
          return 0;
          localObject = localParameters.getPreviewSize();
          locala.sUA = ((Camera.Size)localObject).height;
          locala.sUz = ((Camera.Size)localObject).width;
          continue;
        }
        if (((List)localObject).contains("auto")) {
          continue;
        }
        Log.i("MicroMsg.YuvReocrder", "don't support auto");
        this.KaP = false;
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
  
  public final void ejx()
  {
    AppMethodBeat.i(31187);
    if ((this.mSensorManager != null) && (this.ztM != null)) {
      this.mSensorManager.unregisterListener(this);
    }
    if (this.gGr != null)
    {
      Log.d("MicroMsg.YuvReocrder", "release camera");
      this.gGr.setPreviewCallback(null);
      this.gGr.stopPreview();
      this.gGr.release();
      this.gGr = null;
      this.ztJ = false;
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
    if (((Math.abs(this.ztN - f1) > 2.0F) || (Math.abs(this.ztO - f2) > 2.0F) || (Math.abs(this.ztP - f3) > 2.0F)) && (this.gGr != null) && (this.KaQ) && (true == this.KaP)) {}
    try
    {
      Log.d("MicroMsg.YuvReocrder", "auto focus");
      this.gGr.autoFocus(this.KaR);
      this.KaQ = false;
      this.ztN = f1;
      this.ztO = f2;
      this.ztP = f3;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.l.g
 * JD-Core Version:    0.7.0.1
 */
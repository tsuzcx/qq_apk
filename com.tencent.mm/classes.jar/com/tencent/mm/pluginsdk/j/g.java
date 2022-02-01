package com.tencent.mm.pluginsdk.j;

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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class g
  implements SensorEventListener
{
  private static int uKy = 0;
  private boolean DmA;
  private boolean DmB;
  private Camera.AutoFocusCallback DmC;
  private a Dmy;
  public List<Integer> Dmz;
  public v fFt;
  d.a.a gXJ;
  private Camera.PreviewCallback mPreviewCallback;
  private SensorManager mSensorManager;
  private Sensor uKA;
  private float uKB;
  private float uKC;
  private float uKD;
  private boolean uKx;
  private SurfaceHolder zXO;
  
  public g()
  {
    AppMethodBeat.i(31186);
    this.fFt = null;
    this.uKx = false;
    this.zXO = null;
    this.Dmz = new ArrayList();
    this.DmA = true;
    this.uKB = 0.0F;
    this.uKC = 0.0F;
    this.uKD = 0.0F;
    this.mPreviewCallback = null;
    this.DmB = true;
    this.DmC = new Camera.AutoFocusCallback()
    {
      public final void onAutoFocus(boolean paramAnonymousBoolean, Camera paramAnonymousCamera)
      {
        AppMethodBeat.i(31185);
        ac.d("MicroMsg.YuvReocrder", "auto focus callback");
        g.a(g.this);
        AppMethodBeat.o(31185);
      }
    };
    AppMethodBeat.o(31186);
  }
  
  public static int getCameraId()
  {
    return uKy;
  }
  
  @TargetApi(9)
  private static void i(Camera.Parameters paramParameters)
  {
    AppMethodBeat.i(31188);
    if (ae.fJd.fET > 0)
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
      ac.d("MicroMsg.YuvReocrder", "dkfps %d:[%d %d]", new Object[] { Integer.valueOf(k), Integer.valueOf(n), Integer.valueOf(m) });
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
      ac.d("MicroMsg.YuvReocrder", "dkfps get fit  [%d %d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
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
        ac.printErrStackTrace("MicroMsg.YuvReocrder", paramParameters, "", new Object[0]);
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
    this.Dmy = parama;
    if ((this.mSensorManager == null) && (this.uKA == null))
    {
      this.mSensorManager = ((SensorManager)ai.getContext().getSystemService("sensor"));
      this.uKA = this.mSensorManager.getDefaultSensor(1);
    }
    if ((paramBoolean) || (this.fFt == null))
    {
      ddo();
      if (paramBoolean) {
        uKy = (uKy ^ 0xFFFFFFFF) & 0x1;
      }
      this.gXJ = com.tencent.mm.compatible.deviceinfo.d.a(paramActivity, uKy, null);
      if (this.gXJ == null)
      {
        ac.e("MicroMsg.YuvReocrder", "start camera FAILED!");
        i = f.getLine();
        AppMethodBeat.o(31190);
        return 0 - i;
      }
      this.fFt = this.gXJ.fFt;
      this.Dmy.duc = this.gXJ.duc;
      if (this.fFt == null)
      {
        ac.e("MicroMsg.YuvReocrder", "start camera FAILED!");
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
    if (this.uKx)
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
        this.zXO = paramSurfaceHolder;
        localParameters = this.fFt.getParameters();
        locala = this.Dmy;
        ac.d("MicroMsg.YuvReocrder", "getFitRecordSize");
        j = 2147483647;
        if (Build.VERSION.SDK_INT < 11) {
          break label723;
        }
        new h();
        localObject = localParameters.getSupportedVideoSizes();
        if (localObject != null) {
          break label701;
        }
        ac.d("MicroMsg.YuvReocrder", "getFitRecordSize getSupportedVideoSizes null, use getSupportedPreviewSizes instead");
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
        ac.printErrStackTrace("MicroMsg.YuvReocrder", paramSurfaceHolder, "", new Object[0]);
        ac.e("MicroMsg.YuvReocrder", "Start preview FAILED :" + paramSurfaceHolder.getMessage());
        i = f.getLine();
        AppMethodBeat.o(31189);
        return 0 - i;
      }
      if (k < ((List)localObject).size())
      {
        n = ((Camera.Size)((List)localObject).get(k)).height;
        i1 = ((Camera.Size)((List)localObject).get(k)).width;
        ac.d("MicroMsg.YuvReocrder", "supp w:" + i1 + " h:" + n);
        m = n * i1;
        if (((locala.duc != 0) && (locala.duc != 180)) || (((n >= locala.uLE) && (i1 >= locala.uLF)) || (((locala.duc == 90) || (locala.duc == 270)) && (i1 >= locala.uLE) && (n >= locala.uLF) && (m < j))))
        {
          locala.qCH = i1;
          locala.qCI = n;
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
          locala.qCI = ((Camera.Size)localObject).height;
          locala.qCH = ((Camera.Size)localObject).width;
        }
        ac.d("MicroMsg.YuvReocrder", " rotate:" + locala.duc + " w:" + locala.qCH + " h:" + locala.qCI);
        localParameters.setPreviewSize(this.Dmy.qCH, this.Dmy.qCI);
        i(localParameters);
        localObject = localParameters.getSupportedPreviewFrameRates();
        this.Dmz.clear();
        this.Dmz.addAll((Collection)localObject);
        localParameters.setPreviewFormat(17);
        localObject = localParameters.getSupportedFocusModes();
        if (localObject != null)
        {
          if ((com.tencent.mm.compatible.util.d.lb(9)) && (true == ((List)localObject).contains("continuous-video")))
          {
            ac.i("MicroMsg.YuvReocrder", "support continous-video");
            this.DmA = false;
            localParameters.setFocusMode("continuous-video");
          }
        }
        else
        {
          this.fFt.setParameters(localParameters);
          this.fFt.setPreviewDisplay(paramSurfaceHolder);
          this.fFt.startPreview();
          if ((this.mSensorManager != null) && (this.uKA != null) && (this.DmA)) {
            this.mSensorManager.registerListener(this, this.uKA, 2);
          }
          this.uKx = true;
          AppMethodBeat.o(31189);
          return 0;
          localObject = localParameters.getPreviewSize();
          locala.qCI = ((Camera.Size)localObject).height;
          locala.qCH = ((Camera.Size)localObject).width;
          continue;
        }
        if (((List)localObject).contains("auto")) {
          continue;
        }
        ac.i("MicroMsg.YuvReocrder", "don't support auto");
        this.DmA = false;
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
  
  public final void ddo()
  {
    AppMethodBeat.i(31187);
    if ((this.mSensorManager != null) && (this.uKA != null)) {
      this.mSensorManager.unregisterListener(this);
    }
    if (this.fFt != null)
    {
      ac.d("MicroMsg.YuvReocrder", "release camera");
      this.fFt.setPreviewCallback(null);
      this.fFt.stopPreview();
      this.fFt.release();
      this.fFt = null;
      this.uKx = false;
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
    if (((Math.abs(this.uKB - f1) > 2.0F) || (Math.abs(this.uKC - f2) > 2.0F) || (Math.abs(this.uKD - f3) > 2.0F)) && (this.fFt != null) && (this.DmB) && (true == this.DmA)) {}
    try
    {
      ac.d("MicroMsg.YuvReocrder", "auto focus");
      this.fFt.autoFocus(this.DmC);
      this.DmB = false;
      this.uKB = f1;
      this.uKC = f2;
      this.uKD = f3;
      AppMethodBeat.o(31191);
      return;
    }
    catch (Exception paramSensorEvent)
    {
      for (;;)
      {
        ac.d("MicroMsg.YuvReocrder", "auto focus failed");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.j.g
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.pluginsdk.m;

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

public final class h
  implements SensorEventListener
{
  private static int EZl = 0;
  private boolean EZk;
  private Sensor EZn;
  private float EZo;
  private float EZp;
  private float EZq;
  private Camera.PreviewCallback JvO;
  private SurfaceHolder MlJ;
  private a Rbr;
  public List<Integer> Rbs;
  private boolean Rbt;
  private boolean Rbu;
  private Camera.AutoFocusCallback Rbv;
  public w jqD;
  d.a.a lbk;
  private SensorManager mSensorManager;
  
  public h()
  {
    AppMethodBeat.i(31186);
    this.jqD = null;
    this.EZk = false;
    this.MlJ = null;
    this.Rbs = new ArrayList();
    this.Rbt = true;
    this.EZo = 0.0F;
    this.EZp = 0.0F;
    this.EZq = 0.0F;
    this.JvO = null;
    this.Rbu = true;
    this.Rbv = new Camera.AutoFocusCallback()
    {
      public final void onAutoFocus(boolean paramAnonymousBoolean, Camera paramAnonymousCamera)
      {
        AppMethodBeat.i(31185);
        Log.d("MicroMsg.YuvReocrder", "auto focus callback");
        h.a(h.this);
        AppMethodBeat.o(31185);
      }
    };
    AppMethodBeat.o(31186);
  }
  
  public static int getCameraId()
  {
    return EZl;
  }
  
  @TargetApi(9)
  private static void i(Camera.Parameters paramParameters)
  {
    AppMethodBeat.i(31188);
    if (af.juH.jpZ > 0)
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
    this.Rbr = parama;
    if ((this.mSensorManager == null) && (this.EZn == null))
    {
      this.mSensorManager = ((SensorManager)MMApplicationContext.getContext().getSystemService("sensor"));
      this.EZn = this.mSensorManager.getDefaultSensor(1);
    }
    if ((paramBoolean) || (this.jqD == null))
    {
      eTe();
      if (paramBoolean) {
        EZl = (EZl ^ 0xFFFFFFFF) & 0x1;
      }
      this.lbk = com.tencent.mm.compatible.deviceinfo.d.D(paramActivity, EZl);
      if (this.lbk == null)
      {
        Log.e("MicroMsg.YuvReocrder", "start camera FAILED!");
        i = f.getLine();
        AppMethodBeat.o(31190);
        return 0 - i;
      }
      this.jqD = this.lbk.jqD;
      this.Rbr.fSM = this.lbk.fSM;
      if (this.jqD == null)
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
    if (this.EZk)
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
        this.MlJ = paramSurfaceHolder;
        localParameters = this.jqD.avd();
        locala = this.Rbr;
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
        if (((locala.fSM != 0) && (locala.fSM != 180)) || (((n >= locala.kUC) && (i1 >= locala.kUB)) || (((locala.fSM == 90) || (locala.fSM == 270)) && (i1 >= locala.kUC) && (n >= locala.kUB) && (m < j))))
        {
          locala.wAw = i1;
          locala.wAx = n;
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
          locala.wAx = ((Camera.Size)localObject).height;
          locala.wAw = ((Camera.Size)localObject).width;
        }
        Log.d("MicroMsg.YuvReocrder", " rotate:" + locala.fSM + " w:" + locala.wAw + " h:" + locala.wAx);
        localParameters.setPreviewSize(this.Rbr.wAw, this.Rbr.wAx);
        i(localParameters);
        localObject = localParameters.getSupportedPreviewFrameRates();
        this.Rbs.clear();
        this.Rbs.addAll((Collection)localObject);
        localParameters.setPreviewFormat(17);
        localObject = localParameters.getSupportedFocusModes();
        if (localObject != null)
        {
          if ((com.tencent.mm.compatible.util.d.qX(9)) && (true == ((List)localObject).contains("continuous-video")))
          {
            Log.i("MicroMsg.YuvReocrder", "support continous-video");
            this.Rbt = false;
            localParameters.setFocusMode("continuous-video");
          }
        }
        else
        {
          this.jqD.c(localParameters);
          this.jqD.a(paramSurfaceHolder);
          this.jqD.ave();
          if ((this.mSensorManager != null) && (this.EZn != null) && (this.Rbt)) {
            this.mSensorManager.registerListener(this, this.EZn, 2);
          }
          this.EZk = true;
          AppMethodBeat.o(31189);
          return 0;
          localObject = localParameters.getPreviewSize();
          locala.wAx = ((Camera.Size)localObject).height;
          locala.wAw = ((Camera.Size)localObject).width;
          continue;
        }
        if (((List)localObject).contains("auto")) {
          continue;
        }
        Log.i("MicroMsg.YuvReocrder", "don't support auto");
        this.Rbt = false;
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
  
  public final void eTe()
  {
    AppMethodBeat.i(31187);
    if ((this.mSensorManager != null) && (this.EZn != null)) {
      this.mSensorManager.unregisterListener(this);
    }
    if (this.jqD != null)
    {
      Log.d("MicroMsg.YuvReocrder", "release camera");
      this.jqD.a(null);
      this.jqD.TL();
      this.jqD.release();
      this.jqD = null;
      this.EZk = false;
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
    if (((Math.abs(this.EZo - f1) > 2.0F) || (Math.abs(this.EZp - f2) > 2.0F) || (Math.abs(this.EZq - f3) > 2.0F)) && (this.jqD != null) && (this.Rbu) && (true == this.Rbt)) {}
    try
    {
      Log.d("MicroMsg.YuvReocrder", "auto focus");
      this.jqD.a(this.Rbv);
      this.Rbu = false;
      this.EZo = f1;
      this.EZp = f2;
      this.EZq = f3;
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
 * Qualified Name:     com.tencent.mm.pluginsdk.m.h
 * JD-Core Version:    0.7.0.1
 */
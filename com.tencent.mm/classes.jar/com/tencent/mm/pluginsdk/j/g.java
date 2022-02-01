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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class g
  implements SensorEventListener
{
  private static int tCb = 0;
  private a BUi;
  public List<Integer> BUj;
  private boolean BUk;
  private boolean BUl;
  private Camera.AutoFocusCallback BUm;
  public v fBM;
  d.a.a gxm;
  private Camera.PreviewCallback mPreviewCallback;
  private SensorManager mSensorManager;
  private boolean tCa;
  private Sensor tCd;
  private float tCe;
  private float tCf;
  private float tCg;
  private SurfaceHolder yKB;
  
  public g()
  {
    AppMethodBeat.i(31186);
    this.fBM = null;
    this.tCa = false;
    this.yKB = null;
    this.BUj = new ArrayList();
    this.BUk = true;
    this.tCe = 0.0F;
    this.tCf = 0.0F;
    this.tCg = 0.0F;
    this.mPreviewCallback = null;
    this.BUl = true;
    this.BUm = new Camera.AutoFocusCallback()
    {
      public final void onAutoFocus(boolean paramAnonymousBoolean, Camera paramAnonymousCamera)
      {
        AppMethodBeat.i(31185);
        ad.d("MicroMsg.YuvReocrder", "auto focus callback");
        g.a(g.this);
        AppMethodBeat.o(31185);
      }
    };
    AppMethodBeat.o(31186);
  }
  
  public static int getCameraId()
  {
    return tCb;
  }
  
  @TargetApi(9)
  private static void i(Camera.Parameters paramParameters)
  {
    AppMethodBeat.i(31188);
    if (ae.fFw.fBm > 0)
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
      ad.d("MicroMsg.YuvReocrder", "dkfps %d:[%d %d]", new Object[] { Integer.valueOf(k), Integer.valueOf(n), Integer.valueOf(m) });
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
      ad.d("MicroMsg.YuvReocrder", "dkfps get fit  [%d %d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
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
        ad.printErrStackTrace("MicroMsg.YuvReocrder", paramParameters, "", new Object[0]);
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
    this.BUi = parama;
    if ((this.mSensorManager == null) && (this.tCd == null))
    {
      this.mSensorManager = ((SensorManager)aj.getContext().getSystemService("sensor"));
      this.tCd = this.mSensorManager.getDefaultSensor(1);
    }
    if ((paramBoolean) || (this.fBM == null))
    {
      cPF();
      if (paramBoolean) {
        tCb = (tCb ^ 0xFFFFFFFF) & 0x1;
      }
      this.gxm = com.tencent.mm.compatible.deviceinfo.d.a(paramActivity, tCb, null);
      if (this.gxm == null)
      {
        ad.e("MicroMsg.YuvReocrder", "start camera FAILED!");
        i = f.getLine();
        AppMethodBeat.o(31190);
        return 0 - i;
      }
      this.fBM = this.gxm.fBM;
      this.BUi.dwp = this.gxm.dwp;
      if (this.fBM == null)
      {
        ad.e("MicroMsg.YuvReocrder", "start camera FAILED!");
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
    if (this.tCa)
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
        this.yKB = paramSurfaceHolder;
        localParameters = this.fBM.getParameters();
        locala = this.BUi;
        ad.d("MicroMsg.YuvReocrder", "getFitRecordSize");
        j = 2147483647;
        if (Build.VERSION.SDK_INT < 11) {
          break label723;
        }
        new h();
        localObject = localParameters.getSupportedVideoSizes();
        if (localObject != null) {
          break label701;
        }
        ad.d("MicroMsg.YuvReocrder", "getFitRecordSize getSupportedVideoSizes null, use getSupportedPreviewSizes instead");
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
        ad.printErrStackTrace("MicroMsg.YuvReocrder", paramSurfaceHolder, "", new Object[0]);
        ad.e("MicroMsg.YuvReocrder", "Start preview FAILED :" + paramSurfaceHolder.getMessage());
        i = f.getLine();
        AppMethodBeat.o(31189);
        return 0 - i;
      }
      if (k < ((List)localObject).size())
      {
        n = ((Camera.Size)((List)localObject).get(k)).height;
        i1 = ((Camera.Size)((List)localObject).get(k)).width;
        ad.d("MicroMsg.YuvReocrder", "supp w:" + i1 + " h:" + n);
        m = n * i1;
        if (((locala.dwp != 0) && (locala.dwp != 180)) || (((n >= locala.tDh) && (i1 >= locala.tDi)) || (((locala.dwp == 90) || (locala.dwp == 270)) && (i1 >= locala.tDh) && (n >= locala.tDi) && (m < j))))
        {
          locala.pUc = i1;
          locala.pUd = n;
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
          locala.pUd = ((Camera.Size)localObject).height;
          locala.pUc = ((Camera.Size)localObject).width;
        }
        ad.d("MicroMsg.YuvReocrder", " rotate:" + locala.dwp + " w:" + locala.pUc + " h:" + locala.pUd);
        localParameters.setPreviewSize(this.BUi.pUc, this.BUi.pUd);
        i(localParameters);
        localObject = localParameters.getSupportedPreviewFrameRates();
        this.BUj.clear();
        this.BUj.addAll((Collection)localObject);
        localParameters.setPreviewFormat(17);
        localObject = localParameters.getSupportedFocusModes();
        if (localObject != null)
        {
          if ((com.tencent.mm.compatible.util.d.lh(9)) && (true == ((List)localObject).contains("continuous-video")))
          {
            ad.i("MicroMsg.YuvReocrder", "support continous-video");
            this.BUk = false;
            localParameters.setFocusMode("continuous-video");
          }
        }
        else
        {
          this.fBM.setParameters(localParameters);
          this.fBM.setPreviewDisplay(paramSurfaceHolder);
          this.fBM.startPreview();
          if ((this.mSensorManager != null) && (this.tCd != null) && (this.BUk)) {
            this.mSensorManager.registerListener(this, this.tCd, 2);
          }
          this.tCa = true;
          AppMethodBeat.o(31189);
          return 0;
          localObject = localParameters.getPreviewSize();
          locala.pUd = ((Camera.Size)localObject).height;
          locala.pUc = ((Camera.Size)localObject).width;
          continue;
        }
        if (((List)localObject).contains("auto")) {
          continue;
        }
        ad.i("MicroMsg.YuvReocrder", "don't support auto");
        this.BUk = false;
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
  
  public final void cPF()
  {
    AppMethodBeat.i(31187);
    if ((this.mSensorManager != null) && (this.tCd != null)) {
      this.mSensorManager.unregisterListener(this);
    }
    if (this.fBM != null)
    {
      ad.d("MicroMsg.YuvReocrder", "release camera");
      this.fBM.setPreviewCallback(null);
      this.fBM.stopPreview();
      this.fBM.release();
      this.fBM = null;
      this.tCa = false;
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
    if (((Math.abs(this.tCe - f1) > 2.0F) || (Math.abs(this.tCf - f2) > 2.0F) || (Math.abs(this.tCg - f3) > 2.0F)) && (this.fBM != null) && (this.BUl) && (true == this.BUk)) {}
    try
    {
      ad.d("MicroMsg.YuvReocrder", "auto focus");
      this.fBM.autoFocus(this.BUm);
      this.BUl = false;
      this.tCe = f1;
      this.tCf = f2;
      this.tCg = f3;
      AppMethodBeat.o(31191);
      return;
    }
    catch (Exception paramSensorEvent)
    {
      for (;;)
      {
        ad.d("MicroMsg.YuvReocrder", "auto focus failed");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.j.g
 * JD-Core Version:    0.7.0.1
 */
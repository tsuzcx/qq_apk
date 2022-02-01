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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class g
  implements SensorEventListener
{
  private static int vNE = 0;
  private SurfaceHolder Bps;
  private a ERA;
  public List<Integer> ERB;
  private boolean ERC;
  private boolean ERD;
  private Camera.AutoFocusCallback ERE;
  public v fYS;
  d.a.a hpP;
  private Camera.PreviewCallback mPreviewCallback;
  private SensorManager mSensorManager;
  private boolean vND;
  private Sensor vNG;
  private float vNH;
  private float vNI;
  private float vNJ;
  
  public g()
  {
    AppMethodBeat.i(31186);
    this.fYS = null;
    this.vND = false;
    this.Bps = null;
    this.ERB = new ArrayList();
    this.ERC = true;
    this.vNH = 0.0F;
    this.vNI = 0.0F;
    this.vNJ = 0.0F;
    this.mPreviewCallback = null;
    this.ERD = true;
    this.ERE = new Camera.AutoFocusCallback()
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
  
  @TargetApi(9)
  private static void g(Camera.Parameters paramParameters)
  {
    AppMethodBeat.i(31188);
    if (ae.gcE.fYs > 0)
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
  
  public static int getCameraId()
  {
    return vNE;
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
    this.ERA = parama;
    if ((this.mSensorManager == null) && (this.vNG == null))
    {
      this.mSensorManager = ((SensorManager)aj.getContext().getSystemService("sensor"));
      this.vNG = this.mSensorManager.getDefaultSensor(1);
    }
    if ((paramBoolean) || (this.fYS == null))
    {
      dmK();
      if (paramBoolean) {
        vNE = (vNE ^ 0xFFFFFFFF) & 0x1;
      }
      this.hpP = com.tencent.mm.compatible.deviceinfo.d.a(paramActivity, vNE, null);
      if (this.hpP == null)
      {
        ad.e("MicroMsg.YuvReocrder", "start camera FAILED!");
        i = f.getLine();
        AppMethodBeat.o(31190);
        return 0 - i;
      }
      this.fYS = this.hpP.fYS;
      this.ERA.dGc = this.hpP.dGc;
      if (this.fYS == null)
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
    if (this.vND)
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
        this.Bps = paramSurfaceHolder;
        localParameters = this.fYS.getParameters();
        locala = this.ERA;
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
        if (((locala.dGc != 0) && (locala.dGc != 180)) || (((n >= locala.vOK) && (i1 >= locala.vOL)) || (((locala.dGc == 90) || (locala.dGc == 270)) && (i1 >= locala.vOK) && (n >= locala.vOL) && (m < j))))
        {
          locala.rmx = i1;
          locala.rmy = n;
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
          locala.rmy = ((Camera.Size)localObject).height;
          locala.rmx = ((Camera.Size)localObject).width;
        }
        ad.d("MicroMsg.YuvReocrder", " rotate:" + locala.dGc + " w:" + locala.rmx + " h:" + locala.rmy);
        localParameters.setPreviewSize(this.ERA.rmx, this.ERA.rmy);
        g(localParameters);
        localObject = localParameters.getSupportedPreviewFrameRates();
        this.ERB.clear();
        this.ERB.addAll((Collection)localObject);
        localParameters.setPreviewFormat(17);
        localObject = localParameters.getSupportedFocusModes();
        if (localObject != null)
        {
          if ((com.tencent.mm.compatible.util.d.lA(9)) && (true == ((List)localObject).contains("continuous-video")))
          {
            ad.i("MicroMsg.YuvReocrder", "support continous-video");
            this.ERC = false;
            localParameters.setFocusMode("continuous-video");
          }
        }
        else
        {
          this.fYS.setParameters(localParameters);
          this.fYS.setPreviewDisplay(paramSurfaceHolder);
          this.fYS.startPreview();
          if ((this.mSensorManager != null) && (this.vNG != null) && (this.ERC)) {
            this.mSensorManager.registerListener(this, this.vNG, 2);
          }
          this.vND = true;
          AppMethodBeat.o(31189);
          return 0;
          localObject = localParameters.getPreviewSize();
          locala.rmy = ((Camera.Size)localObject).height;
          locala.rmx = ((Camera.Size)localObject).width;
          continue;
        }
        if (((List)localObject).contains("auto")) {
          continue;
        }
        ad.i("MicroMsg.YuvReocrder", "don't support auto");
        this.ERC = false;
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
  
  public final void dmK()
  {
    AppMethodBeat.i(31187);
    if ((this.mSensorManager != null) && (this.vNG != null)) {
      this.mSensorManager.unregisterListener(this);
    }
    if (this.fYS != null)
    {
      ad.d("MicroMsg.YuvReocrder", "release camera");
      this.fYS.setPreviewCallback(null);
      this.fYS.stopPreview();
      this.fYS.release();
      this.fYS = null;
      this.vND = false;
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
    if (((Math.abs(this.vNH - f1) > 2.0F) || (Math.abs(this.vNI - f2) > 2.0F) || (Math.abs(this.vNJ - f3) > 2.0F)) && (this.fYS != null) && (this.ERD) && (true == this.ERC)) {}
    try
    {
      ad.d("MicroMsg.YuvReocrder", "auto focus");
      this.fYS.autoFocus(this.ERE);
      this.ERD = false;
      this.vNH = f1;
      this.vNI = f2;
      this.vNJ = f3;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.l.g
 * JD-Core Version:    0.7.0.1
 */
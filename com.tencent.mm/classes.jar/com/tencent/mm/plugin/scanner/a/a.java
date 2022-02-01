package com.tencent.mm.plugin.scanner.a;

import android.graphics.Rect;
import android.hardware.Camera;
import android.hardware.Camera.Area;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.Parameters;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a
  extends com.tencent.scanlib.a.a
{
  private boolean dKK()
  {
    AppMethodBeat.i(91047);
    if ((this.gbc != null) && (cLT())) {}
    try
    {
      List localList = this.gbc.getParameters().getSupportedFlashModes();
      if (localList != null)
      {
        boolean bool = localList.contains("torch");
        if (bool)
        {
          AppMethodBeat.o(91047);
          return true;
        }
      }
      ad.i("MicroMsg.WxScanCamera", "camera not support flash!!");
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("MicroMsg.WxScanCamera", "isFlashSupported error: " + localException.getMessage());
      }
    }
    AppMethodBeat.o(91047);
    return false;
  }
  
  public final void a(float paramFloat1, float paramFloat2, Camera.AutoFocusCallback paramAutoFocusCallback)
  {
    AppMethodBeat.i(91044);
    int i = (int)(paramFloat1 * 2000.0F);
    int j = (int)(2000.0F * paramFloat2);
    try
    {
      ad.i("MicroMsg.WxScanCamera", String.format("fx %f, fy %f, x %d, y %d", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), Integer.valueOf(i), Integer.valueOf(j) }));
      Object localObject1 = new Rect();
      if (fUj())
      {
        ((Rect)localObject1).left = (j - 1000 - 250);
        ((Rect)localObject1).right = (j - 1000 + 250);
        ((Rect)localObject1).top = (2000 - i - 1000 - 250);
      }
      for (((Rect)localObject1).bottom = (2000 - i - 1000 + 250);; ((Rect)localObject1).bottom = (j - 1000 + 250))
      {
        Camera.Parameters localParameters = this.gbc.getParameters();
        if (((Rect)localObject1).left < -1000) {
          ((Rect)localObject1).left = -1000;
        }
        if (((Rect)localObject1).right > 1000) {
          ((Rect)localObject1).right = 1000;
        }
        if (((Rect)localObject1).top < -1000) {
          ((Rect)localObject1).top = -1000;
        }
        if (((Rect)localObject1).bottom > 1000) {
          ((Rect)localObject1).bottom = 1000;
        }
        ad.i("MicroMsg.WxScanCamera", "focus area ".concat(String.valueOf(localObject1)));
        Object localObject2 = new Rect((Rect)localObject1);
        if (localParameters.getMaxNumMeteringAreas() <= 0) {
          break;
        }
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(new Camera.Area((Rect)localObject2, 1000));
        localParameters.setMeteringAreas(localArrayList);
        if (localParameters.getMaxNumFocusAreas() <= 0) {
          break label548;
        }
        localObject2 = new ArrayList();
        ((ArrayList)localObject2).add(new Camera.Area((Rect)localObject1, 1000));
        localParameters.setFocusAreas((List)localObject2);
        this.gbc.cancelAutoFocus();
        if ((this.gbc != null) && (this.rid))
        {
          localObject1 = localParameters.getSupportedFocusModes();
          if ((localObject1 != null) && (((List)localObject1).contains("auto")) && (!com.tencent.scanlib.a.isNullOrNil(localParameters.getFocusMode())) && (!localParameters.getFocusMode().equals("auto"))) {
            localParameters.setFocusMode("auto");
          }
        }
        this.gbc.setParameters(localParameters);
        this.gbc.autoFocus(paramAutoFocusCallback);
        AppMethodBeat.o(91044);
        return;
        ((Rect)localObject1).left = (i - 1000 - 250);
        ((Rect)localObject1).right = (i - 1000 + 250);
        ((Rect)localObject1).top = (j - 1000 - 250);
      }
      ad.i("MicroMsg.WxScanCamera", "setCaptureFocusAndMeteringArea, camera not support set metering area");
    }
    catch (Exception paramAutoFocusCallback)
    {
      ad.e("MicroMsg.WxScanCamera", "setCaptureFocusAndMeteringArea error: " + paramAutoFocusCallback.getMessage());
      AppMethodBeat.o(91044);
      return;
    }
    AppMethodBeat.o(91044);
    return;
    label548:
    ad.i("MicroMsg.WxScanCamera", "setCaptureFocusAndMeteringArea, camera not support area focus");
    AppMethodBeat.o(91044);
  }
  
  public final void dKG()
  {
    AppMethodBeat.i(91043);
    List localList;
    try
    {
      ad.i("MicroMsg.WxScanCamera", "set picture focus");
      Camera.Parameters localParameters = this.gbc.getParameters();
      if (localParameters == null)
      {
        ad.w("MicroMsg.WxScanCamera", "camera parameters is null");
        AppMethodBeat.o(91043);
        return;
      }
      localList = localParameters.getSupportedFocusModes();
      if (localList == null) {
        break label170;
      }
      ad.d("MicroMsg.WxScanCamera", "supported focus modes size = " + localList.size());
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext()) {
        ad.d("MicroMsg.WxScanCamera", "supported focus modes : ".concat(String.valueOf((String)localIterator.next())));
      }
      if (!localList.contains("continuous-picture")) {
        break label176;
      }
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.WxScanCamera", "setPictureFocus error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(91043);
      return;
    }
    ad.d("MicroMsg.WxScanCamera", "camera support continuous picture focus");
    localException.setFocusMode("continuous-picture");
    for (;;)
    {
      this.gbc.setParameters(localException);
      label170:
      AppMethodBeat.o(91043);
      return;
      label176:
      if (localList.contains("continuous-video"))
      {
        ad.d("MicroMsg.WxScanCamera", "camera support continuous video focus");
        localException.setFocusMode("continuous-video");
      }
      else if (localList.contains("auto"))
      {
        ad.d("MicroMsg.WxScanCamera", "camera support auto focus");
        localException.setFocusMode("auto");
      }
    }
  }
  
  public final void dKH()
  {
    AppMethodBeat.i(91045);
    try
    {
      Object localObject;
      if (this.gbc != null)
      {
        localObject = this.gbc.getParameters();
        String str = ((Camera.Parameters)localObject).get("zoom-supported");
        if ((com.tencent.scanlib.a.isNullOrNil(str)) || (!Boolean.parseBoolean(str)))
        {
          ad.i("MicroMsg.WxScanCamera", "not support zoom");
          AppMethodBeat.o(91045);
          return;
        }
        localObject = ((Camera.Parameters)localObject).getZoomRatios();
        if (localObject != null)
        {
          int i = ((List)localObject).size();
          if (i > 0) {}
        }
        else
        {
          AppMethodBeat.o(91045);
          return;
        }
        this.LOQ = 0;
        this.mMaxZoom = ((int)(((List)localObject).size() / 1.5D));
        ad.d("MicroMsg.WxScanCamera", "divideRatio: %f,max zoom: %d", new Object[] { Double.valueOf(1.5D), Integer.valueOf(this.mMaxZoom) });
        if (this.mMaxZoom >= this.LOQ) {
          break label217;
        }
        this.mMaxZoom = this.LOQ;
      }
      for (;;)
      {
        ad.i("MicroMsg.WxScanCamera", "default zoom:%d,default ratio:%d,max zoom:%d,max ratio:%d", new Object[] { Integer.valueOf(this.LOQ), ((List)localObject).get(this.LOQ), Integer.valueOf(this.mMaxZoom), ((List)localObject).get(this.mMaxZoom) });
        AppMethodBeat.o(91045);
        return;
        label217:
        if (((Integer)((List)localObject).get(this.mMaxZoom)).intValue() > 400) {
          this.mMaxZoom = C((List)localObject, 400);
        }
      }
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.WxScanCamera", "init zoom exception! " + localException.getMessage());
      AppMethodBeat.o(91045);
    }
  }
  
  public final boolean dKI()
  {
    return this.vNQ;
  }
  
  public final boolean dKJ()
  {
    AppMethodBeat.i(91046);
    if (this.LOO < 0) {
      if (!dKK()) {
        break label43;
      }
    }
    label43:
    for (int i = 1;; i = 0)
    {
      this.LOO = i;
      if (this.LOO != 1) {
        break;
      }
      AppMethodBeat.o(91046);
      return true;
    }
    AppMethodBeat.o(91046);
    return false;
  }
  
  public final void dmR()
  {
    AppMethodBeat.i(91048);
    ad.i("MicroMsg.WxScanCamera", String.format("openFlash, camera: %s, isPreviewing: %s", new Object[] { this.gbc, Boolean.valueOf(cLT()) }));
    if ((this.gbc != null) && (cLT())) {
      try
      {
        this.vNQ = true;
        Camera.Parameters localParameters = this.gbc.getParameters();
        List localList = localParameters.getSupportedFlashModes();
        if ((localList != null) && (localList.contains("torch")))
        {
          localParameters.setFlashMode("torch");
          this.gbc.setParameters(localParameters);
          ad.i("MicroMsg.WxScanCamera", "open flash");
          AppMethodBeat.o(91048);
          return;
        }
        ad.i("MicroMsg.WxScanCamera", "camera not support flash!!");
        AppMethodBeat.o(91048);
        return;
      }
      catch (Exception localException)
      {
        ad.e("MicroMsg.WxScanCamera", "openFlash error: " + localException.getMessage());
      }
    }
    AppMethodBeat.o(91048);
  }
  
  public final void dmS()
  {
    AppMethodBeat.i(91049);
    ad.i("MicroMsg.WxScanCamera", String.format("closeFlash, camera: %s, isPreviewing: %s", new Object[] { this.gbc, Boolean.valueOf(cLT()) }));
    if ((this.gbc != null) && (cLT())) {
      try
      {
        this.vNQ = false;
        Camera.Parameters localParameters = this.gbc.getParameters();
        List localList = localParameters.getSupportedFlashModes();
        if ((localList != null) && (localList.contains("off")))
        {
          localParameters.setFlashMode("off");
          this.gbc.setParameters(localParameters);
          ad.i("MicroMsg.WxScanCamera", "close flash");
          AppMethodBeat.o(91049);
          return;
        }
        ad.i("MicroMsg.WxScanCamera", "camera not support close flash!!");
        AppMethodBeat.o(91049);
        return;
      }
      catch (Exception localException)
      {
        ad.e("MicroMsg.WxScanCamera", "closeFlash error: " + localException.getMessage());
      }
    }
    AppMethodBeat.o(91049);
  }
  
  public final int getPreviewFormat()
  {
    AppMethodBeat.i(91050);
    int i = this.gbc.getParameters().getPreviewFormat();
    AppMethodBeat.o(91050);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.a.a
 * JD-Core Version:    0.7.0.1
 */
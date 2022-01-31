package com.tencent.mm.plugin.scanner.util;

import android.app.Activity;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera.Area;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.ac;
import com.tencent.mm.compatible.e.d;
import com.tencent.mm.compatible.e.d.a.a;
import com.tencent.mm.compatible.e.k;
import com.tencent.mm.compatible.e.u;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bs;
import com.tencent.mm.ui.af;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public final class j
{
  private static final Pattern qCQ;
  private Activity cup;
  public u eoH;
  private int hIg;
  public Rect mfj;
  public boolean miS;
  public Point miT;
  private Point miU;
  public Point miV;
  public boolean miW;
  public int miX;
  private boolean miY;
  public boolean oHg;
  public boolean qCR;
  private Rect qCS;
  private Rect qCT;
  public int qCU;
  private String qCV;
  private int qCW;
  private int qCX;
  private int qCY;
  
  static
  {
    AppMethodBeat.i(81443);
    qCQ = Pattern.compile(",");
    AppMethodBeat.o(81443);
  }
  
  public j(Activity paramActivity, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(81420);
    this.miS = false;
    this.hIg = 0;
    this.miT = null;
    this.miU = null;
    this.miV = null;
    this.miY = false;
    this.oHg = false;
    this.qCU = -1;
    this.qCV = "";
    this.cup = paramActivity;
    this.miU = af.hQ(paramActivity);
    this.qCR = paramBoolean;
    this.hIg = paramInt;
    this.miS = false;
    AppMethodBeat.o(81420);
  }
  
  private static Point a(Camera.Parameters paramParameters, Point paramPoint1, Point paramPoint2, boolean paramBoolean)
  {
    AppMethodBeat.i(81432);
    String str = paramParameters.get("preview-size-values");
    if (str == null) {
      str = paramParameters.get("preview-size-value");
    }
    for (;;)
    {
      Point localPoint = null;
      if (str != null)
      {
        ab.d("MicroMsg.scanner.ScanCamera", "preview-size-values parameter: ".concat(String.valueOf(str)));
        localPoint = a(paramParameters, paramPoint1, paramBoolean);
      }
      paramParameters = localPoint;
      if (localPoint == null) {
        paramParameters = new Point(paramPoint2.x >> 3 << 3, paramPoint2.y >> 3 << 3);
      }
      AppMethodBeat.o(81432);
      return paramParameters;
    }
  }
  
  private static Point a(Camera.Parameters paramParameters, Point paramPoint, boolean paramBoolean)
  {
    AppMethodBeat.i(81433);
    Object localObject = new ArrayList(paramParameters.getSupportedPreviewSizes());
    Collections.sort((List)localObject, new j.a((byte)0));
    ((List)localObject).remove(0);
    Point localPoint = null;
    float f3 = paramPoint.x / paramPoint.y;
    ab.d("MicroMsg.scanner.ScanCamera", "screen.x: %d, screen.y: %d, ratio: %f", new Object[] { Integer.valueOf(paramPoint.x), Integer.valueOf(paramPoint.y), Float.valueOf(f3) });
    int n = paramPoint.x * paramPoint.y;
    ab.i("MicroMsg.scanner.ScanCamera", "SCREEN_PIXELS: %s, MAX_PREVIEW_PIXELS_USE_BIGGER: %s", new Object[] { Integer.valueOf(n), Integer.valueOf(2073600) });
    float f1 = (1.0F / 1.0F);
    localObject = ((List)localObject).iterator();
    int i;
    int j;
    label276:
    label373:
    label380:
    float f2;
    while (((Iterator)localObject).hasNext())
    {
      Camera.Size localSize = (Camera.Size)((Iterator)localObject).next();
      i = localSize.width;
      j = localSize.height;
      ab.i("MicroMsg.scanner.ScanCamera", "realWidth: %d, realHeight: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      int k = i * j;
      if ((k >= 150400) && (k <= 2073600) && ((k <= n) || (Math.min(paramPoint.x, paramPoint.y) < 720)))
      {
        if (i > j)
        {
          m = 1;
          if ((m == 0) || (paramBoolean)) {
            break label373;
          }
          k = j;
          if ((m == 0) || (paramBoolean)) {
            break label380;
          }
        }
        for (int m = i;; m = j)
        {
          ab.d("MicroMsg.scanner.ScanCamera", "maybeFlippedWidth: %d, maybeFlippedHeight: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(m) });
          if ((k != paramPoint.x) || (m != paramPoint.y)) {
            break label387;
          }
          paramParameters = new Point(i, j);
          ab.i("MicroMsg.scanner.ScanCamera", "Found preview size exactly matching screen size: ".concat(String.valueOf(paramParameters)));
          AppMethodBeat.o(81433);
          return paramParameters;
          m = 0;
          break;
          k = i;
          break label276;
        }
        label387:
        f2 = Math.abs(k / m - f3);
        if (f2 >= f1) {
          break label534;
        }
        localPoint = new Point(i, j);
        f1 = f2;
      }
    }
    label534:
    for (;;)
    {
      ab.i("MicroMsg.scanner.ScanCamera", "diff:[%s] newdiff:[%s] w:[%s] h:[%s]", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(i), Integer.valueOf(j) });
      break;
      paramPoint = localPoint;
      if (localPoint == null)
      {
        paramParameters = paramParameters.getPreviewSize();
        paramPoint = new Point(paramParameters.width, paramParameters.height);
        ab.i("MicroMsg.scanner.ScanCamera", "No suitable preview sizes, using default: ".concat(String.valueOf(paramPoint)));
      }
      ab.i("MicroMsg.scanner.ScanCamera", "Found best approximate preview size: ".concat(String.valueOf(paramPoint)));
      AppMethodBeat.o(81433);
      return paramPoint;
    }
  }
  
  private void cjA()
  {
    AppMethodBeat.i(81429);
    if (this.mfj == null)
    {
      AppMethodBeat.o(81429);
      return;
    }
    float f3 = this.miT.x;
    float f4 = this.miT.y;
    float f2 = f4;
    float f1 = f3;
    if (this.miW)
    {
      f2 = f4;
      f1 = f3;
      if (!this.qCR)
      {
        f1 = this.miT.y;
        f2 = this.miT.x;
      }
    }
    this.qCT = new Rect();
    int i = (int)(this.mfj.width() / f1 * 2000.0F);
    int j = (int)(this.mfj.height() / f2 * 2000.0F);
    this.qCT.left = (-i / 2);
    this.qCT.right = (i / 2);
    this.qCT.top = (-j / 2);
    this.qCT.bottom = (j / 2);
    ab.i("MicroMsg.scanner.ScanCamera", "set metering area:" + this.qCT);
    AppMethodBeat.o(81429);
  }
  
  private void cjz()
  {
    AppMethodBeat.i(81428);
    if (this.mfj == null)
    {
      AppMethodBeat.o(81428);
      return;
    }
    this.qCS = new Rect();
    float f3 = this.miT.x;
    float f4 = this.miT.y;
    float f2 = f4;
    float f1 = f3;
    if (this.miW)
    {
      f2 = f4;
      f1 = f3;
      if (!this.qCR)
      {
        f1 = this.miT.y;
        f2 = this.miT.x;
      }
    }
    int i = (int)(this.mfj.width() / f1 * 2000.0F);
    int j = (int)(this.mfj.height() / f2 * 2000.0F);
    this.qCS.left = (-i / 2);
    this.qCS.right = (i / 2);
    this.qCS.top = (-j / 2);
    this.qCS.bottom = (j / 2);
    ab.i("MicroMsg.scanner.ScanCamera", "set focus area:" + this.qCS);
    AppMethodBeat.o(81428);
  }
  
  private static void g(Camera.Parameters paramParameters)
  {
    AppMethodBeat.i(81439);
    List localList;
    try
    {
      ab.i("MicroMsg.scanner.ScanCamera", "set scan focus");
      localList = paramParameters.getSupportedFocusModes();
      if (localList == null) {
        break label180;
      }
      ab.i("MicroMsg.scanner.ScanCamera", "supported focus modes size = " + localList.size());
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext()) {
        ab.i("MicroMsg.scanner.ScanCamera", "supported focus modes : ".concat(String.valueOf((String)localIterator.next())));
      }
      if (!localList.contains("continuous-video")) {
        break label153;
      }
    }
    catch (Exception paramParameters)
    {
      ab.e("MicroMsg.scanner.ScanCamera", "setScanFocus error: %s", new Object[] { paramParameters.getMessage() });
      AppMethodBeat.o(81439);
      return;
    }
    ab.d("MicroMsg.scanner.ScanCamera", "camera support continuous video focus");
    paramParameters.setFocusMode("continuous-video");
    AppMethodBeat.o(81439);
    return;
    label153:
    if (localList.contains("auto"))
    {
      ab.d("MicroMsg.scanner.ScanCamera", "camera support auto focus");
      paramParameters.setFocusMode("auto");
    }
    label180:
    AppMethodBeat.o(81439);
  }
  
  private static int n(List<Integer> paramList, int paramInt)
  {
    AppMethodBeat.i(81435);
    int i;
    if ((paramList != null) && (paramList.size() > 0))
    {
      ab.i("MicroMsg.scanner.ScanCamera", "zoomRatios: %s,size: %d", new Object[] { paramList, Integer.valueOf(paramList.size()) });
      i = Collections.binarySearch(paramList, Integer.valueOf(paramInt));
      ab.i("MicroMsg.scanner.ScanCamera", "insert index:%d", new Object[] { Integer.valueOf(i) });
      if (i >= 0) {
        paramInt = i;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(81435);
      return paramInt;
      i = -(i + 1);
      int j = i - 1;
      if ((i >= 0) && (i <= paramList.size() - 1) && (j >= 0) && (j <= paramList.size() - 1))
      {
        if (((Integer)paramList.get(i)).intValue() - paramInt > paramInt - ((Integer)paramList.get(j)).intValue()) {
          paramInt = j;
        } else {
          paramInt = i;
        }
      }
      else if ((i >= 0) && (i <= paramList.size() - 1)) {
        paramInt = i;
      } else if ((j >= 0) && (j <= paramList.size() - 1)) {
        paramInt = j;
      } else {
        paramInt = 0;
      }
    }
  }
  
  public final void CQ(int paramInt)
  {
    this.hIg = paramInt;
    this.mfj = null;
  }
  
  public final void CR(int paramInt)
  {
    AppMethodBeat.i(81436);
    if ((this.eoH != null) && (this.miS) && (paramInt > 0)) {
      try
      {
        Camera.Parameters localParameters = this.eoH.getParameters();
        List localList = localParameters.getZoomRatios();
        if (localList != null)
        {
          i = localList.size();
          if (i > 0) {}
        }
        else
        {
          AppMethodBeat.o(81436);
          return;
        }
        double d = paramInt / 100.0D;
        int i = (int)(d * ((Integer)localList.get(this.qCW)).intValue());
        ab.d("MicroMsg.scanner.ScanCamera", "scale:%d,to ratio:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
        if ((i >= ((Integer)localList.get(this.qCX)).intValue()) && (i <= ((Integer)localList.get(this.qCY)).intValue())) {
          paramInt = n(localList, i);
        }
        for (;;)
        {
          ab.i("MicroMsg.scanner.ScanCamera", "zoom:%d,ratio:%d", new Object[] { Integer.valueOf(paramInt), localList.get(paramInt) });
          this.qCW = paramInt;
          localParameters.setZoom(paramInt);
          this.eoH.setParameters(localParameters);
          AppMethodBeat.o(81436);
          return;
          if (i < ((Integer)localList.get(this.qCX)).intValue())
          {
            paramInt = this.qCX;
          }
          else
          {
            ab.i("MicroMsg.scanner.ScanCamera", "exceed max zoom");
            i = this.qCW + (this.qCY - this.qCW) / 5;
            paramInt = i;
            if (i > this.qCY) {
              paramInt = this.qCY;
            }
          }
        }
        AppMethodBeat.o(81436);
      }
      catch (Exception localException)
      {
        ab.e("MicroMsg.scanner.ScanCamera", "zoom scale exception:" + localException.getMessage());
      }
    }
  }
  
  public final void CS(int paramInt)
  {
    AppMethodBeat.i(81437);
    if ((this.eoH != null) && (this.miS)) {}
    for (;;)
    {
      int i;
      try
      {
        Camera.Parameters localParameters = this.eoH.getParameters();
        List localList = localParameters.getZoomRatios();
        if (localList != null)
        {
          i = localList.size();
          if (i > 0) {}
        }
        else
        {
          AppMethodBeat.o(81437);
          return;
        }
        ab.i("MicroMsg.scanner.ScanCamera", "zoom action:%d,beforeZoom:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(localParameters.getZoom()) });
        switch (paramInt)
        {
        case 0: 
          localParameters.setZoom(this.qCW);
          this.eoH.setParameters(localParameters);
          ab.i("MicroMsg.scanner.ScanCamera", "zoom action:%d,afterZoom:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(localParameters.getZoom()) });
          AppMethodBeat.o(81437);
          return;
        }
      }
      catch (Exception localException)
      {
        ab.e("MicroMsg.scanner.ScanCamera", "zoom action exception:" + localException.getMessage());
      }
      this.qCW = 0;
      continue;
      AppMethodBeat.o(81437);
      return;
      this.qCW = this.qCX;
      continue;
      if (this.qCW < this.qCY)
      {
        this.qCW += 1;
        if (this.qCW > this.qCY) {}
        for (i = this.qCY;; i = this.qCW)
        {
          this.qCW = i;
          break;
        }
        if (this.qCW > this.qCX)
        {
          this.qCW -= 1;
          if (this.qCW < this.qCX) {}
          for (i = this.qCX;; i = this.qCW)
          {
            this.qCW = i;
            break;
          }
          this.qCW = this.qCY;
          continue;
          if (this.qCW != this.qCX) {
            this.qCW = this.qCX;
          } else {
            this.qCW = this.qCY;
          }
        }
      }
    }
  }
  
  public final void a(Camera.PreviewCallback paramPreviewCallback)
  {
    AppMethodBeat.i(81423);
    if (this.eoH != null) {
      try
      {
        this.eoH.setOneShotPreviewCallback(paramPreviewCallback);
        AppMethodBeat.o(81423);
        return;
      }
      catch (RuntimeException paramPreviewCallback)
      {
        ab.w("MicroMsg.scanner.ScanCamera", "takeOneShot() " + paramPreviewCallback.getMessage());
      }
    }
    AppMethodBeat.o(81423);
  }
  
  public final void bQR()
  {
    AppMethodBeat.i(81442);
    ab.i("MicroMsg.scanner.ScanCamera", "closeFlash, camera: %s, isPreviewing: %s", new Object[] { this.eoH, Boolean.valueOf(this.miS) });
    if ((this.eoH != null) && (this.miS)) {
      try
      {
        this.oHg = false;
        Camera.Parameters localParameters = this.eoH.getParameters();
        if ((!bo.es(localParameters.getSupportedFlashModes())) && (localParameters.getSupportedFlashModes().contains("off")))
        {
          localParameters.setFlashMode("off");
          this.eoH.setParameters(localParameters);
          ab.i("MicroMsg.scanner.ScanCamera", "close flash");
          AppMethodBeat.o(81442);
          return;
        }
        ab.i("MicroMsg.scanner.ScanCamera", "camera not support close flash!!");
        AppMethodBeat.o(81442);
        return;
      }
      catch (Exception localException)
      {
        ab.printErrStackTrace("MicroMsg.scanner.ScanCamera", localException, "closeFlash error: %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(81442);
  }
  
  public final void cancelAutoFocus()
  {
    AppMethodBeat.i(81425);
    try
    {
      if (this.eoH != null) {
        this.eoH.cancelAutoFocus();
      }
      AppMethodBeat.o(81425);
      return;
    }
    catch (Exception localException)
    {
      ab.w("MicroMsg.scanner.ScanCamera", "cancelAutoFocus %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(81425);
    }
  }
  
  public final void cjB()
  {
    AppMethodBeat.i(81430);
    if ((this.eoH == null) || (this.miY))
    {
      AppMethodBeat.o(81430);
      return;
    }
    for (;;)
    {
      try
      {
        Camera.Parameters localParameters = this.eoH.getParameters();
        cjz();
        cjA();
        Object localObject;
        if (this.qCS != null)
        {
          localObject = this.qCT;
          if (localObject != null) {}
        }
        else
        {
          AppMethodBeat.o(81430);
          return;
        }
        this.miY = true;
        if (localParameters.getMaxNumMeteringAreas() > 0)
        {
          localObject = new ArrayList();
          ((ArrayList)localObject).add(new Camera.Area(this.qCT, 1000));
          localParameters.setMeteringAreas((List)localObject);
          if (localParameters.getMaxNumFocusAreas() > 0)
          {
            localObject = new ArrayList();
            ((ArrayList)localObject).add(new Camera.Area(this.qCS, 1000));
            localParameters.setFocusAreas((List)localObject);
            this.eoH.setParameters(localParameters);
            AppMethodBeat.o(81430);
          }
        }
        else
        {
          ab.i("MicroMsg.scanner.ScanCamera", "setScanFocusAndMeteringArea, camera not support set metering area");
          continue;
        }
        ab.i("MicroMsg.scanner.ScanCamera", "setScanFocusAndMeteringArea, camera not support area focus");
      }
      catch (Exception localException)
      {
        ab.e("MicroMsg.scanner.ScanCamera", "setScanFocusAndMeteringArea error: %s", new Object[] { localException.getMessage() });
        AppMethodBeat.o(81430);
        return;
      }
    }
  }
  
  public final void cjC()
  {
    AppMethodBeat.i(81434);
    for (;;)
    {
      try
      {
        if (this.eoH != null)
        {
          Object localObject = this.eoH.getParameters();
          String str = ((Camera.Parameters)localObject).get("zoom-supported");
          if ((bo.isNullOrNil(str)) || (!Boolean.parseBoolean(str)))
          {
            ab.i("MicroMsg.scanner.ScanCamera", "not support zoom");
            AppMethodBeat.o(81434);
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
            AppMethodBeat.o(81434);
            return;
          }
          ac.ll(g.RL().Rv().dyM());
          if (ac.erF.epj == 1)
          {
            bool = true;
            ab.i("MicroMsg.scanner.ScanCamera", "needZoom: %s, qrCodeZoom: %s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(ac.erF.epj) });
            if ((!bool) || (this.miU.x < 720) || ((this.hIg != 1) && (this.hIg != 8) && (this.hIg != 4))) {
              continue;
            }
            this.qCX = (((List)localObject).size() / 5);
            if (this.qCX > 150) {
              this.qCX = 150;
            }
            double d = 1.5D;
            if (ac.erF.epk != -1.0D) {
              d = ac.erF.epk;
            }
            this.qCY = ((int)(((List)localObject).size() / d));
            ab.d("MicroMsg.scanner.ScanCamera", "divideRatio: %f,max zoom: %d", new Object[] { Double.valueOf(d), Integer.valueOf(this.qCY) });
            if (this.qCY >= this.qCX) {
              break label415;
            }
            this.qCY = this.qCX;
            ab.i("MicroMsg.scanner.ScanCamera", "default zoom:%d,default ratio:%d,max zoom:%d,max ratio:%d", new Object[] { Integer.valueOf(this.qCX), ((List)localObject).get(this.qCX), Integer.valueOf(this.qCY), ((List)localObject).get(this.qCY) });
          }
        }
        else
        {
          AppMethodBeat.o(81434);
          return;
        }
        boolean bool = false;
        continue;
        this.qCX = 0;
        continue;
        if (this.qCY <= 400) {
          continue;
        }
      }
      catch (Exception localException)
      {
        ab.printErrStackTrace("MicroMsg.scanner.ScanCamera", localException, "init zoom exception!", new Object[0]);
        AppMethodBeat.o(81434);
        return;
      }
      label415:
      this.qCY = 400;
    }
  }
  
  public final int cjD()
  {
    AppMethodBeat.i(81438);
    try
    {
      if ((this.eoH != null) && (this.eoH.getParameters() != null) && (this.eoH.getParameters().getZoomRatios() != null) && (this.eoH.getParameters().getZoomRatios().size() > 0))
      {
        int i = ((Integer)this.eoH.getParameters().getZoomRatios().get(this.qCW)).intValue();
        AppMethodBeat.o(81438);
        return i;
      }
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.scanner.ScanCamera", "get zoom ratio exception:" + localException.getMessage());
      AppMethodBeat.o(81438);
    }
    return 100;
  }
  
  public final void cjE()
  {
    AppMethodBeat.i(81440);
    List localList;
    try
    {
      ab.i("MicroMsg.scanner.ScanCamera", "set picture focus");
      Camera.Parameters localParameters = this.eoH.getParameters();
      if (localParameters == null)
      {
        ab.w("MicroMsg.scanner.ScanCamera", "camera parameters is null");
        AppMethodBeat.o(81440);
        return;
      }
      localList = localParameters.getSupportedFocusModes();
      if (localList == null) {
        break label181;
      }
      ab.d("MicroMsg.scanner.ScanCamera", "supported focus modes size = " + localList.size());
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext()) {
        ab.d("MicroMsg.scanner.ScanCamera", "supported focus modes : ".concat(String.valueOf((String)localIterator.next())));
      }
      if (!localList.contains("continuous-picture")) {
        break label188;
      }
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.scanner.ScanCamera", "setPictureFocus error: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(81440);
      return;
    }
    ab.d("MicroMsg.scanner.ScanCamera", "camera support continuous picture focus");
    localException.setFocusMode("continuous-picture");
    for (;;)
    {
      this.eoH.setParameters(localException);
      label181:
      AppMethodBeat.o(81440);
      return;
      label188:
      if (localList.contains("continuous-video"))
      {
        ab.d("MicroMsg.scanner.ScanCamera", "camera support continuous video focus");
        localException.setFocusMode("continuous-video");
      }
      else if (localList.contains("auto"))
      {
        ab.d("MicroMsg.scanner.ScanCamera", "camera support auto focus");
        localException.setFocusMode("auto");
      }
    }
  }
  
  public final boolean cjF()
  {
    AppMethodBeat.i(81441);
    if ((this.eoH != null) && (this.miS)) {}
    try
    {
      Camera.Parameters localParameters = this.eoH.getParameters();
      if (!bo.es(localParameters.getSupportedFlashModes()))
      {
        boolean bool = localParameters.getSupportedFlashModes().contains("torch");
        if (bool)
        {
          AppMethodBeat.o(81441);
          return true;
        }
      }
      ab.i("MicroMsg.scanner.ScanCamera", "camera not support flash!!");
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.scanner.ScanCamera", localException, "isFlashSupported error: %s", new Object[] { localException.getMessage() });
      }
    }
    AppMethodBeat.o(81441);
    return false;
  }
  
  public final float cjx()
  {
    if ((this.miW) && (!this.qCR)) {
      return this.miT.y / this.miV.x;
    }
    return this.miT.x / this.miV.x;
  }
  
  public final float cjy()
  {
    if ((this.miW) && (!this.qCR)) {
      return this.miT.x / this.miV.y;
    }
    return this.miT.y / this.miV.y;
  }
  
  public final void f(Point paramPoint)
  {
    AppMethodBeat.i(81431);
    this.miV = new Point(paramPoint);
    ab.d("MicroMsg.scanner.ScanCamera", "set visible resolution:%s", new Object[] { this.miV });
    AppMethodBeat.o(81431);
  }
  
  public final String getFocusMode()
  {
    AppMethodBeat.i(81424);
    try
    {
      if ((this.eoH != null) && (this.miS))
      {
        String str = this.eoH.getParameters().getFocusMode();
        AppMethodBeat.o(81424);
        return str;
      }
    }
    catch (Exception localException)
    {
      ab.w("MicroMsg.scanner.ScanCamera", "getFocusMode() %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(81424);
    }
    return "";
  }
  
  public final boolean isOpen()
  {
    return this.eoH != null;
  }
  
  public final void k(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(81421);
    long l = bo.yB();
    if ((this.eoH != null) && (!this.miS))
    {
      if (paramSurfaceTexture != null) {
        this.eoH.setPreviewTexture(paramSurfaceTexture);
      }
      this.eoH.startPreview();
      this.miS = true;
      ab.d("MicroMsg.scanner.ScanCamera", "startPreview done costTime=[%s]", new Object[] { Long.valueOf(bo.av(l)) });
    }
    AppMethodBeat.o(81421);
  }
  
  public final void open()
  {
    AppMethodBeat.i(81426);
    if (this.miS)
    {
      ab.w("MicroMsg.scanner.ScanCamera", "in open(), previewing");
      release();
    }
    int i = d.Lj();
    long l = bo.yB();
    Object localObject1 = d.a(this.cup, i, null);
    if (localObject1 == null)
    {
      ab.e("MicroMsg.scanner.ScanCamera", "in open(), openCameraRes == null");
      localObject1 = new IOException();
      AppMethodBeat.o(81426);
      throw ((Throwable)localObject1);
    }
    this.oHg = false;
    this.qCU = -1;
    ab.d("MicroMsg.scanner.ScanCamera", "openCamera done, cameraId=[%s] costTime=[%s]", new Object[] { Integer.valueOf(i), Long.valueOf(bo.av(l)) });
    this.miX = ((d.a.a)localObject1).rotate;
    if (((d.a.a)localObject1).rotate % 180 != 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.miW = bool;
      this.eoH = ((d.a.a)localObject1).eoH;
      if (this.eoH != null) {
        break;
      }
      ab.e("MicroMsg.scanner.ScanCamera", "in open(), camera == null, bNeedRotate=[%s]", new Object[] { Boolean.valueOf(this.miW) });
      localObject1 = new IOException();
      AppMethodBeat.o(81426);
      throw ((Throwable)localObject1);
    }
    localObject1 = this.eoH.getParameters();
    Object localObject2 = this.miU;
    Point localPoint = this.miV;
    if ((9 == this.hIg) || (10 == this.hIg) || (7 == this.hIg) || (11 == this.hIg)) {
      bool = true;
    }
    for (;;)
    {
      this.miT = a((Camera.Parameters)localObject1, (Point)localObject2, localPoint, bool);
      ab.d("MicroMsg.scanner.ScanCamera", "getCameraResolution: " + this.miU + " camera:" + this.miT);
      ((Camera.Parameters)localObject1).setPreviewSize(this.miT.x, this.miT.y);
      cjC();
      try
      {
        g((Camera.Parameters)localObject1);
        localObject2 = ((Camera.Parameters)localObject1).getSupportedPreviewFormats();
        ab.i("MicroMsg.scanner.ScanCamera", "supportedPreviewFormat:".concat(String.valueOf(localObject2)));
        if (((List)localObject2).contains(Integer.valueOf(17)))
        {
          i = 0;
          j = 1;
          if (j == 0) {
            break label486;
          }
          ab.i("MicroMsg.scanner.ScanCamera", "Preview support NV21");
          ((Camera.Parameters)localObject1).setPreviewFormat(17);
          this.eoH.setParameters((Camera.Parameters)localObject1);
          ab.i("MicroMsg.scanner.ScanCamera", "camera open done.");
          AppMethodBeat.o(81426);
          return;
          bool = false;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          int j;
          ab.e("MicroMsg.scanner.ScanCamera", "set focus mode error: %s", new Object[] { localException.getMessage() });
          continue;
          if (localException.contains(Integer.valueOf(842094169)))
          {
            i = 1;
            j = 0;
            continue;
            label486:
            if (i != 0)
            {
              ab.i("MicroMsg.scanner.ScanCamera", "Preview not support NV21, but support YV12");
              ((Camera.Parameters)localObject1).setPreviewFormat(842094169);
            }
            else
            {
              ab.i("MicroMsg.scanner.ScanCamera", "Preview not support NV21 and YV12. Use format: %s", new Object[] { localException.get(0) });
              ((Camera.Parameters)localObject1).setPreviewFormat(((Integer)localException.get(0)).intValue());
            }
          }
          else
          {
            i = 0;
            j = 0;
          }
        }
      }
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(81427);
    ab.i("MicroMsg.scanner.ScanCamera", "release(), previewing = [%s]", new Object[] { Boolean.valueOf(this.miS) });
    if (this.eoH != null)
    {
      long l = bo.yB();
      this.eoH.setPreviewCallback(null);
      this.eoH.stopPreview();
      this.miS = false;
      ab.i("MicroMsg.scanner.ScanCamera", "stopPreview costTime=[%s]", new Object[] { Long.valueOf(bo.av(l)) });
      l = bo.yB();
      this.eoH.release();
      this.eoH = null;
      ab.i("MicroMsg.scanner.ScanCamera", "camera.release() costTime=[%s]", new Object[] { Long.valueOf(bo.av(l)) });
    }
    this.oHg = false;
    this.miY = false;
    this.qCU = -1;
    this.hIg = 0;
    AppMethodBeat.o(81427);
  }
  
  public final void stopPreview()
  {
    AppMethodBeat.i(81422);
    if (this.eoH != null)
    {
      this.eoH.stopPreview();
      this.miS = false;
    }
    AppMethodBeat.o(81422);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.util.j
 * JD-Core Version:    0.7.0.1
 */
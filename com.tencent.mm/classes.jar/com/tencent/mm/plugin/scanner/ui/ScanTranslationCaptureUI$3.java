package com.tencent.mm.plugin.scanner.ui;

import android.graphics.Rect;
import android.hardware.Camera.Area;
import android.hardware.Camera.Parameters;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.u;
import com.tencent.mm.plugin.scanner.util.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.List;

final class ScanTranslationCaptureUI$3
  implements View.OnTouchListener
{
  ScanTranslationCaptureUI$3(ScanTranslationCaptureUI paramScanTranslationCaptureUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(81257);
    if ((ScanTranslationCaptureUI.e(this.qAW) == 0) && (paramView == ScanTranslationCaptureUI.b(this.qAW)))
    {
      float f1;
      float f2;
      int i;
      int j;
      if (paramMotionEvent.getAction() == 0)
      {
        ab.i("MicroMsg.ScanTranslationCaptureUI", "event down, (%f, %f)", new Object[] { Float.valueOf(paramMotionEvent.getX()), Float.valueOf(paramMotionEvent.getY()) });
        f1 = paramMotionEvent.getX() / ScanTranslationCaptureUI.b(this.qAW).getWidth();
        f2 = paramMotionEvent.getY() / ScanTranslationCaptureUI.b(this.qAW).getHeight();
        paramView = ScanTranslationCaptureUI.h(this.qAW);
        paramMotionEvent = new ScanTranslationCaptureUI.3.1(this);
        i = (int)(2000.0F * f1);
        j = (int)(2000.0F * f2);
      }
      for (;;)
      {
        try
        {
          ab.i("MicroMsg.scanner.ScanCamera", "fx %f, fy %f, x %d, y %d", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(i), Integer.valueOf(j) });
          localObject1 = new Rect();
          if ((!paramView.miW) || (paramView.qCR)) {
            continue;
          }
          ((Rect)localObject1).left = (j - 1000 - 250);
          ((Rect)localObject1).right = (j - 1000 + 250);
          ((Rect)localObject1).top = (2000 - i - 1000 - 250);
          ((Rect)localObject1).bottom = (2000 - i - 1000 + 250);
          Camera.Parameters localParameters = paramView.eoH.getParameters();
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
          ab.i("MicroMsg.scanner.ScanCamera", "focus area, %s", new Object[] { localObject1 });
          Object localObject2 = new Rect((Rect)localObject1);
          if (localParameters.getMaxNumMeteringAreas() <= 0) {
            continue;
          }
          ArrayList localArrayList = new ArrayList();
          localArrayList.add(new Camera.Area((Rect)localObject2, 1000));
          localParameters.setMeteringAreas(localArrayList);
          if (localParameters.getMaxNumFocusAreas() <= 0) {
            continue;
          }
          localObject2 = new ArrayList();
          ((ArrayList)localObject2).add(new Camera.Area((Rect)localObject1, 1000));
          localParameters.setFocusAreas((List)localObject2);
          paramView.eoH.cancelAutoFocus();
          if ((paramView.eoH != null) && (paramView.miS))
          {
            localObject1 = localParameters.getSupportedFocusModes();
            if ((localObject1 != null) && (((List)localObject1).contains("auto")) && (!bo.isNullOrNil(localParameters.getFocusMode())) && (!localParameters.getFocusMode().equals("auto"))) {
              localParameters.setFocusMode("auto");
            }
          }
          paramView.eoH.setParameters(localParameters);
          paramView.eoH.autoFocus(paramMotionEvent);
        }
        catch (Exception paramView)
        {
          Object localObject1;
          ab.e("MicroMsg.scanner.ScanCamera", "setCaptureFocusAndMeteringArea error: %s", new Object[] { paramView.getMessage() });
          continue;
          ab.i("MicroMsg.scanner.ScanCamera", "setCaptureFocusAndMeteringArea, camera not support set metering area");
          continue;
          ab.i("MicroMsg.scanner.ScanCamera", "setCaptureFocusAndMeteringArea, camera not support area focus");
          continue;
        }
        AppMethodBeat.o(81257);
        return true;
        ((Rect)localObject1).left = (i - 1000 - 250);
        ((Rect)localObject1).right = (i - 1000 + 250);
        ((Rect)localObject1).top = (j - 1000 - 250);
        ((Rect)localObject1).bottom = (j - 1000 + 250);
      }
    }
    AppMethodBeat.o(81257);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI.3
 * JD-Core Version:    0.7.0.1
 */
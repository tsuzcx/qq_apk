package com.tencent.mm.plugin.scanner.ui;

import android.graphics.Rect;
import android.hardware.Camera;
import android.hardware.Camera.Area;
import android.hardware.Camera.Parameters;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.plugin.scanner.util.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.List;

final class ScanTranslationCaptureUI$2
  implements View.OnTouchListener
{
  ScanTranslationCaptureUI$2(ScanTranslationCaptureUI paramScanTranslationCaptureUI) {}
  
  public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((ScanTranslationCaptureUI.i(this.nNm) == 0) && (paramView == ScanTranslationCaptureUI.b(this.nNm)))
    {
      if (paramMotionEvent.getAction() == 0)
      {
        y.i("MicroMsg.ScanTranslationCaptureUI", "event down, (%f, %f)", new Object[] { Float.valueOf(paramMotionEvent.getX()), Float.valueOf(paramMotionEvent.getY()) });
        float f1 = paramMotionEvent.getX() / ScanTranslationCaptureUI.b(this.nNm).getWidth();
        float f2 = paramMotionEvent.getY() / ScanTranslationCaptureUI.b(this.nNm).getHeight();
        paramView = ScanTranslationCaptureUI.f(this.nNm);
        paramMotionEvent = new ScanTranslationCaptureUI.2.1(this);
        int i = (int)(2000.0F * f1);
        int j = (int)(2000.0F * f2);
        try
        {
          y.i("MicroMsg.scanner.ScanCamera", "fx %f, fy %f, x %d, y %d", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(i), Integer.valueOf(j) });
          Object localObject1 = new Rect();
          if ((paramView.jOG) && (!paramView.nOX))
          {
            ((Rect)localObject1).left = (j - 1000 - 250);
            ((Rect)localObject1).right = (j - 1000 + 250);
            ((Rect)localObject1).top = (2000 - i - 1000 - 250);
          }
          for (((Rect)localObject1).bottom = (2000 - i - 1000 + 250);; ((Rect)localObject1).bottom = (j - 1000 + 250))
          {
            Camera.Parameters localParameters = paramView.dwJ.getParameters();
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
            y.i("MicroMsg.scanner.ScanCamera", "focus area, %s", new Object[] { localObject1 });
            Object localObject2 = new Rect((Rect)localObject1);
            if (localParameters.getMaxNumMeteringAreas() <= 0) {
              break;
            }
            ArrayList localArrayList = new ArrayList();
            localArrayList.add(new Camera.Area((Rect)localObject2, 1000));
            localParameters.setMeteringAreas(localArrayList);
            if (localParameters.getMaxNumFocusAreas() <= 0) {
              break label646;
            }
            localObject2 = new ArrayList();
            ((ArrayList)localObject2).add(new Camera.Area((Rect)localObject1, 1000));
            localParameters.setFocusAreas((List)localObject2);
            paramView.dwJ.cancelAutoFocus();
            if ((paramView.dwJ != null) && (paramView.jOC))
            {
              localObject1 = localParameters.getSupportedFocusModes();
              if ((localObject1 != null) && (((List)localObject1).contains("auto")) && (!bk.bl(localParameters.getFocusMode())) && (!localParameters.getFocusMode().equals("auto"))) {
                localParameters.setFocusMode("auto");
              }
            }
            paramView.dwJ.setParameters(localParameters);
            paramView.dwJ.autoFocus(paramMotionEvent);
            break label658;
            ((Rect)localObject1).left = (i - 1000 - 250);
            ((Rect)localObject1).right = (i - 1000 + 250);
            ((Rect)localObject1).top = (j - 1000 - 250);
          }
          y.i("MicroMsg.scanner.ScanCamera", "setCaptureFocusAndMeteringArea, camera not support set metering area");
        }
        catch (Exception paramView)
        {
          y.e("MicroMsg.scanner.ScanCamera", "setCaptureFocusAndMeteringArea error: %s", new Object[] { paramView.getMessage() });
        }
        break label658;
        label646:
        y.i("MicroMsg.scanner.ScanCamera", "setCaptureFocusAndMeteringArea, camera not support area focus");
      }
    }
    else {
      return false;
    }
    label658:
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ScanTranslationCaptureUI.2
 * JD-Core Version:    0.7.0.1
 */
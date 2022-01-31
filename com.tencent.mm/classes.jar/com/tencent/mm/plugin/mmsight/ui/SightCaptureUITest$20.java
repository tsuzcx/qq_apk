package com.tencent.mm.plugin.mmsight.ui;

import android.widget.Toast;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.b.b;
import com.tencent.mm.media.widget.camerarecordview.a;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.mmsight.model.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bo;

final class SightCaptureUITest$20
  implements MMSightRecordButton.b
{
  SightCaptureUITest$20(SightCaptureUITest paramSightCaptureUITest) {}
  
  public final void boX()
  {
    AppMethodBeat.i(150484);
    ab.i("MicroMsg.SightCaptureUIEvent", "onLongPressFinish %s", new Object[] { bo.dtY().toString() });
    if (SightCaptureUITest.m(this.oQq) == 0)
    {
      if ((SightCaptureUITest.c(this.oQq) != null) && (SightCaptureUITest.c(this.oQq).Xf() <= 1000L) && (SightCaptureUITest.c(this.oQq).isRecording))
      {
        ab.i("MicroMsg.SightCaptureUI", "video record too short, cancel and convert to takepicture");
        Object localObject = SightCaptureUITest.c(this.oQq);
        try
        {
          d.i("MicroMsg.CameraPreviewContainer", "cancelRecord");
          b localb = ((a)localObject).faU;
          if (localb != null) {
            localb.cancel();
          }
          localObject = ((a)localObject).faU;
          if (localObject != null) {
            ((b)localObject).clear();
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            d.printErrStackTrace("MicroMsg.CameraPreviewContainer", (Throwable)localException, "cancel record error", new Object[0]);
          }
        }
        if (SightCaptureUITest.m(this.oQq) != 0) {
          break label272;
        }
        SightCaptureUITest.n(this.oQq);
        AppMethodBeat.o(150484);
        return;
      }
      SightCaptureUITest.k(this.oQq);
      AppMethodBeat.o(150484);
    }
    else if (SightCaptureUITest.m(this.oQq) == 1)
    {
      if (((SightCaptureUITest.c(this.oQq) != null) && (SightCaptureUITest.c(this.oQq).Xf() <= 1000L)) || (SightCaptureUITest.c(this.oQq) == null))
      {
        ab.i("MicroMsg.SightCaptureUI", "video record too short");
        Toast.makeText(this.oQq, 2131301570, 1).show();
        SightCaptureUITest.o(this.oQq);
        AppMethodBeat.o(150484);
        return;
      }
      SightCaptureUITest.k(this.oQq);
    }
    label272:
    AppMethodBeat.o(150484);
  }
  
  public final void boY()
  {
    AppMethodBeat.i(150482);
    int[] arrayOfInt = new int[2];
    SightCaptureUITest.h(this.oQq).getLocationOnScreen(arrayOfInt);
    SightCaptureUITest.c(this.oQq).kk(arrayOfInt[1]);
    AppMethodBeat.o(150482);
  }
  
  public final void hH()
  {
    AppMethodBeat.i(150483);
    if (SightCaptureUITest.e(this.oQq) == 0)
    {
      AppMethodBeat.o(150483);
      return;
    }
    SightCaptureUITest.i(this.oQq);
    ab.i("MicroMsg.SightCaptureUIEvent", "onLongPress %s", new Object[] { bo.dtY().toString() });
    SightCaptureUITest.h(this.oQq).a(SightCaptureUITest.j(this.oQq).duration * 1000, 0, new SightCaptureUITest.20.1(this));
    SightCaptureUITest.c(this.oQq).g(SightCaptureUITest.l(this.oQq).isLandscape(), SightCaptureUITest.l(this.oQq).getOrientation());
    AppMethodBeat.o(150483);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.SightCaptureUITest.20
 * JD-Core Version:    0.7.0.1
 */
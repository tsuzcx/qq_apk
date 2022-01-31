package com.tencent.mm.plugin.mmsight.ui;

import android.widget.Toast;
import com.tencent.mm.plugin.mmsight.model.a.d;
import com.tencent.mm.plugin.mmsight.model.a.d.c;
import com.tencent.mm.plugin.mmsight.model.e;
import com.tencent.mm.plugin.u.a.h;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class SightCaptureUI$21
  implements MMSightRecordButton.b
{
  SightCaptureUI$21(SightCaptureUI paramSightCaptureUI) {}
  
  public final void aKO()
  {
    String str = bk.csb().toString();
    d locald = SightCaptureUI.n(this.mqB);
    long l;
    if (SightCaptureUI.n(this.mqB) != null)
    {
      l = SightCaptureUI.n(this.mqB).bjo();
      y.i("MicroMsg.TestCaptureUiEvent", "onLongPressFinish %s, recorder: %s, recordTime: %s", new Object[] { str, locald, Long.valueOf(l) });
      if (SightCaptureUI.j(this.mqB) != 0) {
        break label173;
      }
      if ((SightCaptureUI.n(this.mqB) == null) || (SightCaptureUI.n(this.mqB).bjo() > 1000L) || (SightCaptureUI.n(this.mqB).bjq() != d.c.miA)) {
        break label165;
      }
      y.i("MicroMsg.SightCaptureUI", "video record too short, cancel and convert to takepicture");
      SightCaptureUI.n(this.mqB).cancel();
      if (SightCaptureUI.j(this.mqB) == 0) {
        SightCaptureUI.o(this.mqB);
      }
    }
    label165:
    label173:
    while (SightCaptureUI.j(this.mqB) != 1)
    {
      return;
      l = 0L;
      break;
      SightCaptureUI.p(this.mqB);
      return;
    }
    if (((SightCaptureUI.n(this.mqB) != null) && (SightCaptureUI.n(this.mqB).bjo() <= 1000L)) || (SightCaptureUI.n(this.mqB) == null))
    {
      y.i("MicroMsg.SightCaptureUI", "video record too short");
      Toast.makeText(this.mqB, a.h.mmsight_capture_video_too_short, 1).show();
      SightCaptureUI.q(this.mqB);
      return;
    }
    SightCaptureUI.p(this.mqB);
  }
  
  public final void aKP()
  {
    if ((SightCaptureUI.e(this.mqB) == 0) || (SightCaptureUI.h(this.mqB) == null) || (!SightCaptureUI.h(this.mqB).mgy)) {
      return;
    }
    SightCaptureUI.l(this.mqB);
    y.i("MicroMsg.TestCaptureUiEvent", "onLongPress %s", new Object[] { bk.csb().toString() });
    SightCaptureUI.m(this.mqB);
  }
  
  public final void aKQ()
  {
    y.i("MicroMsg.SightCaptureUI", "onPressDown, currentStatus: %s", new Object[] { Integer.valueOf(SightCaptureUI.e(this.mqB)) });
    if ((SightCaptureUI.e(this.mqB) == 0) || (SightCaptureUI.h(this.mqB) == null) || (!SightCaptureUI.h(this.mqB).mgy)) {}
    do
    {
      return;
      int[] arrayOfInt = new int[2];
      SightCaptureUI.i(this.mqB).getLocationOnScreen(arrayOfInt);
      SightCaptureUI.h(this.mqB).tY(arrayOfInt[1]);
    } while (SightCaptureUI.j(this.mqB) != 0);
    SightCaptureUI.a(this.mqB, SightCaptureUI.k(this.mqB));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.21
 * JD-Core Version:    0.7.0.1
 */
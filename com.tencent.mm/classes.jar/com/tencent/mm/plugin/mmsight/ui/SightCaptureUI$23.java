package com.tencent.mm.plugin.mmsight.ui;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.model.a.d;
import com.tencent.mm.plugin.mmsight.model.a.d.c;
import com.tencent.mm.plugin.mmsight.model.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bo;

final class SightCaptureUI$23
  implements MMSightRecordButton.b
{
  SightCaptureUI$23(SightCaptureUI paramSightCaptureUI) {}
  
  public final void boX()
  {
    AppMethodBeat.i(55222);
    String str = bo.dtY().toString();
    d locald = SightCaptureUI.p(this.oQf);
    if (SightCaptureUI.p(this.oQf) != null) {}
    for (long l = SightCaptureUI.p(this.oQf).Xf();; l = 0L)
    {
      ab.i("MicroMsg.TestCaptureUiEvent", "onLongPressFinish %s, recorder: %s, recordTime: %s", new Object[] { str, locald, Long.valueOf(l) });
      if (SightCaptureUI.l(this.oQf) != 0) {
        break label188;
      }
      if ((SightCaptureUI.p(this.oQf) == null) || (SightCaptureUI.p(this.oQf).Xf() > 1000L) || (SightCaptureUI.p(this.oQf).Xw() != d.c.oIG)) {
        break;
      }
      ab.i("MicroMsg.SightCaptureUI", "video record too short, cancel and convert to takepicture");
      SightCaptureUI.p(this.oQf).cancel();
      if (SightCaptureUI.l(this.oQf) != 0) {
        break label360;
      }
      SightCaptureUI.q(this.oQf);
      AppMethodBeat.o(55222);
      return;
    }
    SightCaptureUI.r(this.oQf);
    AppMethodBeat.o(55222);
    return;
    label188:
    if (SightCaptureUI.l(this.oQf) == 1)
    {
      if (SightCaptureUI.p(this.oQf) == null)
      {
        str = "null";
        if (SightCaptureUI.p(this.oQf) != null) {
          break label337;
        }
      }
      label337:
      for (l = -1L;; l = SightCaptureUI.p(this.oQf).Xf())
      {
        ab.i("MicroMsg.TestCaptureUiEvent", "onLongPressFinish, MODE_SIGHT, recorder=%s, recordTime=%d", new Object[] { str, Long.valueOf(l) });
        if (((SightCaptureUI.p(this.oQf) == null) || (SightCaptureUI.p(this.oQf).Xf() > 1000L)) && (SightCaptureUI.p(this.oQf) != null)) {
          break label353;
        }
        ab.i("MicroMsg.SightCaptureUI", "video record too short");
        Toast.makeText(this.oQf, 2131301570, 1).show();
        SightCaptureUI.s(this.oQf);
        AppMethodBeat.o(55222);
        return;
        str = SightCaptureUI.p(this.oQf).getClass().getSimpleName();
        break;
      }
      label353:
      SightCaptureUI.r(this.oQf);
    }
    label360:
    AppMethodBeat.o(55222);
  }
  
  public final void boY()
  {
    AppMethodBeat.i(55220);
    ab.i("MicroMsg.SightCaptureUI", "onPressDown, currentStatus: %s", new Object[] { Integer.valueOf(SightCaptureUI.g(this.oQf)) });
    if ((SightCaptureUI.g(this.oQf) == 0) || (SightCaptureUI.j(this.oQf) == null) || (!SightCaptureUI.j(this.oQf).bQT()))
    {
      AppMethodBeat.o(55220);
      return;
    }
    int[] arrayOfInt = new int[2];
    SightCaptureUI.k(this.oQf).getLocationOnScreen(arrayOfInt);
    SightCaptureUI.j(this.oQf).kh(arrayOfInt[1]);
    if (SightCaptureUI.l(this.oQf) == 0) {
      SightCaptureUI.a(this.oQf, SightCaptureUI.m(this.oQf));
    }
    AppMethodBeat.o(55220);
  }
  
  public final void hH()
  {
    AppMethodBeat.i(55221);
    if ((SightCaptureUI.g(this.oQf) == 0) || (SightCaptureUI.j(this.oQf) == null) || (!SightCaptureUI.j(this.oQf).bQT()))
    {
      AppMethodBeat.o(55221);
      return;
    }
    SightCaptureUI.n(this.oQf);
    ab.i("MicroMsg.TestCaptureUiEvent", "onLongPress %s", new Object[] { bo.dtY().toString() });
    SightCaptureUI.o(this.oQf);
    AppMethodBeat.o(55221);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.SightCaptureUI.23
 * JD-Core Version:    0.7.0.1
 */
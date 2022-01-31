package com.tencent.mm.plugin.mmsight.ui;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.widget.camerarecordview.a.a;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.mmsight.d;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.plugin.recordvideo.b.c;

final class SightCaptureUITest$18
  implements a
{
  SightCaptureUITest$18(SightCaptureUITest paramSightCaptureUITest) {}
  
  public final int Xh()
  {
    AppMethodBeat.i(150477);
    c localc = c.qbf;
    int i = c.cgk();
    AppMethodBeat.o(150477);
    return i;
  }
  
  public final String Xi()
  {
    AppMethodBeat.i(150479);
    if (SightCaptureUITest.d(this.oQq) == null)
    {
      AppMethodBeat.o(150479);
      return null;
    }
    String str = SightCaptureUITest.d(this.oQq).oFR;
    if (!TextUtils.isEmpty(str))
    {
      AppMethodBeat.o(150479);
      return str;
    }
    str = d.TW(d.TU(CaptureMMProxy.getInstance().getAccVideoPath()));
    AppMethodBeat.o(150479);
    return str;
  }
  
  public final String getFilePath()
  {
    AppMethodBeat.i(150478);
    if (SightCaptureUITest.d(this.oQq) == null)
    {
      AppMethodBeat.o(150478);
      return null;
    }
    String str = SightCaptureUITest.d(this.oQq).oFQ;
    if (!TextUtils.isEmpty(str))
    {
      AppMethodBeat.o(150478);
      return str;
    }
    str = d.TU(CaptureMMProxy.getInstance().getAccVideoPath());
    AppMethodBeat.o(150478);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.SightCaptureUITest.18
 * JD-Core Version:    0.7.0.1
 */
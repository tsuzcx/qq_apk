package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.model.CaptureMMProxy;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class SightCaptureUITest$1
  implements Runnable
{
  SightCaptureUITest$1(SightCaptureUITest paramSightCaptureUITest, long paramLong) {}
  
  public final void run()
  {
    AppMethodBeat.i(150441);
    ab.i("MicroMsg.SightCaptureUI", "connect cost %sms", new Object[] { Long.valueOf(bo.av(this.ngG)) });
    SightCaptureUITest.a(this.oQq, CaptureMMProxy.getInstance().getSubCoreImageFullPath("capture_" + System.currentTimeMillis()));
    SightCaptureUITest.a(this.oQq);
    AppMethodBeat.o(150441);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.SightCaptureUITest.1
 * JD-Core Version:    0.7.0.1
 */
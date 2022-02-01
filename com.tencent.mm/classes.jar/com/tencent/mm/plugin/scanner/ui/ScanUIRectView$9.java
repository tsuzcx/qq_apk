package com.tencent.mm.plugin.scanner.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.a.a;
import com.tencent.mm.plugin.scanner.util.ScanCameraLightDetector;

final class ScanUIRectView$9
  implements Runnable
{
  ScanUIRectView$9(ScanUIRectView paramScanUIRectView) {}
  
  public final void run()
  {
    AppMethodBeat.i(51923);
    ScanCameraLightDetector.wap.start(((a)ScanUIRectView.f(this.vVl)).getFocusMode());
    AppMethodBeat.o(51923);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.ui.ScanUIRectView.9
 * JD-Core Version:    0.7.0.1
 */
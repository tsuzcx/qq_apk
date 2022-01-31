package com.tencent.mm.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap.a;

final class CropImageNewUI$8
  implements ap.a
{
  CropImageNewUI$8(CropImageNewUI paramCropImageNewUI) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(34821);
    CropImageNewUI.j(this.AqU).zoomOut();
    AppMethodBeat.o(34821);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.tools.CropImageNewUI.8
 * JD-Core Version:    0.7.0.1
 */
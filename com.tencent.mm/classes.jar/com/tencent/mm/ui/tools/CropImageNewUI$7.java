package com.tencent.mm.ui.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ap.a;

final class CropImageNewUI$7
  implements ap.a
{
  CropImageNewUI$7(CropImageNewUI paramCropImageNewUI) {}
  
  public final boolean onTimerExpired()
  {
    AppMethodBeat.i(34820);
    CropImageNewUI.j(this.AqU).zoomIn();
    AppMethodBeat.o(34820);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.tools.CropImageNewUI.7
 * JD-Core Version:    0.7.0.1
 */
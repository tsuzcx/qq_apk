package com.tencent.mm.plugin.mmsight.ui;

import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.vfs.e;

final class SightCaptureUITest$6$1$1
  implements Runnable
{
  SightCaptureUITest$6$1$1(SightCaptureUITest.6.1 param1) {}
  
  public final void run()
  {
    AppMethodBeat.i(150449);
    try
    {
      d.a(this.oQt.oQr, 90, Bitmap.CompressFormat.JPEG, SightCaptureUITest.v(this.oQt.oQs.oQq), false);
      ab.i("MicroMsg.SightCaptureUI", "bitmap filelen %s", new Object[] { Long.valueOf(e.avI(SightCaptureUITest.v(this.oQt.oQs.oQq))) });
      AppMethodBeat.o(150449);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.SightCaptureUI", "error for saveBitmapToImage %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(150449);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.SightCaptureUITest.6.1.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.mmsight.ui;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.n;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.d;
import java.io.IOException;

final class TestVideoEditUI$2
  implements n
{
  TestVideoEditUI$2(TestVideoEditUI paramTestVideoEditUI) {}
  
  public final void b(Bitmap paramBitmap, boolean paramBoolean)
  {
    AppMethodBeat.i(55295);
    ab.i("MicroMsg.TestVideoEditUI", "[onSuccess] w:%s h:%s", new Object[] { Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()) });
    String str = e.esI + String.format("%s%d.%s", new Object[] { "wx_photo_edit_", Long.valueOf(System.currentTimeMillis()), "png" });
    try
    {
      d.a(paramBitmap, 100, Bitmap.CompressFormat.PNG, str, true);
      AppMethodBeat.o(55295);
      return;
    }
    catch (IOException paramBitmap)
    {
      AppMethodBeat.o(55295);
    }
  }
  
  public final void onError(Exception paramException) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.TestVideoEditUI.2
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.mmsight.ui;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.s;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.g;
import java.io.IOException;

final class TestVideoEditUI$2
  implements s
{
  TestVideoEditUI$2(TestVideoEditUI paramTestVideoEditUI) {}
  
  public final void a(Bitmap paramBitmap, boolean paramBoolean)
  {
    AppMethodBeat.i(94746);
    ad.i("MicroMsg.TestVideoEditUI", "[onSuccess] w:%s h:%s", new Object[] { Integer.valueOf(paramBitmap.getWidth()), Integer.valueOf(paramBitmap.getHeight()) });
    String str = b.asd() + String.format("%s%d.%s", new Object[] { "wx_photo_edit_", Long.valueOf(System.currentTimeMillis()), "png" });
    try
    {
      g.a(paramBitmap, 100, Bitmap.CompressFormat.PNG, str, true);
      AppMethodBeat.o(94746);
      return;
    }
    catch (IOException paramBitmap)
    {
      AppMethodBeat.o(94746);
    }
  }
  
  public final void onError(Exception paramException) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.ui.TestVideoEditUI.2
 * JD-Core Version:    0.7.0.1
 */
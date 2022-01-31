package com.tencent.mm.plugin.webview.modeltools;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.d;
import java.io.IOException;
import java.util.Locale;

final class h$b
  implements Runnable
{
  private Bitmap mBitmap;
  
  public h$b(h paramh, Bitmap paramBitmap)
  {
    this.mBitmap = paramBitmap;
  }
  
  public final void run()
  {
    AppMethodBeat.i(7010);
    this.uYl.uYi = String.format(Locale.US, "%s%s_%08x.jpg", new Object[] { e.eQz, Long.valueOf(System.currentTimeMillis()), Integer.valueOf(this.mBitmap.hashCode()) });
    try
    {
      d.a(this.mBitmap, 100, Bitmap.CompressFormat.JPEG, this.uYl.uYi, true);
      ab.i("MicroMsg.ViewCaptureHelper", "bitmap recycle %s", new Object[] { this.mBitmap.toString() });
      this.mBitmap.recycle();
      this.uYl.iMP.sendEmptyMessage(2);
      AppMethodBeat.o(7010);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ab.e("MicroMsg.ViewCaptureHelper", "saveBitmapToImage failed, " + localIOException.getMessage());
        this.uYl.uYi = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.modeltools.h.b
 * JD-Core Version:    0.7.0.1
 */
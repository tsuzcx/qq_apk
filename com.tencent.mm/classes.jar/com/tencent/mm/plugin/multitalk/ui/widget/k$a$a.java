package com.tencent.mm.plugin.multitalk.ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
public final class k$a$a
  implements Runnable
{
  public k$a$a(Bitmap paramBitmap, Context paramContext) {}
  
  public final void run()
  {
    AppMethodBeat.i(239806);
    String str = AndroidMediaUtil.getExportImagePath("jpg");
    boolean bool = BitmapUtil.saveBitmapToImage(this.cKG, 100, Bitmap.CompressFormat.JPEG, str, true);
    if (!bool)
    {
      Toast.makeText(this.$context, (CharSequence)this.$context.getString(2131764864), 1).show();
      AppMethodBeat.o(239806);
      return;
    }
    if (bool)
    {
      AndroidMediaUtil.refreshMediaScannerAsync(str, this.$context);
      Toast.makeText(this.$context, (CharSequence)this.$context.getString(2131764869, new Object[] { AndroidMediaUtil.getSysCameraDirPath() }), 1).show();
    }
    AppMethodBeat.o(239806);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.k.a.a
 * JD-Core Version:    0.7.0.1
 */
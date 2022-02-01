package com.tencent.mm.plugin.multitalk.ui.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.multitalk.a.h;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
public final class k$a$a
  implements Runnable
{
  public k$a$a(Bitmap paramBitmap, Context paramContext) {}
  
  public final void run()
  {
    AppMethodBeat.i(201136);
    String str = AndroidMediaUtil.getExportImagePath("jpg");
    boolean bool = BitmapUtil.saveBitmapToImage(this.cLr, 100, Bitmap.CompressFormat.JPEG, str, true);
    if (!bool)
    {
      Toast.makeText(this.$context, (CharSequence)this.$context.getString(a.h.save_image_err), 1).show();
      AppMethodBeat.o(201136);
      return;
    }
    if (bool)
    {
      AndroidMediaUtil.refreshMediaScannerAsync(str, this.$context);
      Toast.makeText(this.$context, (CharSequence)this.$context.getString(a.h.save_screen_img_succ, new Object[] { AndroidMediaUtil.getSysCameraDirPath() }), 1).show();
    }
    AppMethodBeat.o(201136);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.ui.widget.k.a.a
 * JD-Core Version:    0.7.0.1
 */
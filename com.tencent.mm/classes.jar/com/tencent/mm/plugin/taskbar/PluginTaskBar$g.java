package com.tencent.mm.plugin.taskbar;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.a.a;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
final class PluginTaskBar$g
  implements Runnable
{
  PluginTaskBar$g(PluginTaskBar paramPluginTaskBar, Bitmap paramBitmap, String paramString, a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(215307);
    try
    {
      BitmapUtil.saveBitmapToImage(this.cLr, 100, Bitmap.CompressFormat.JPEG, this.oyo, false);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e(PluginTaskBar.access$getTAG$p(this.MlY), "save bitmap failed! " + this.oyo, new Object[] { localThrowable });
      return;
    }
    finally
    {
      this.kWs.invoke();
      AppMethodBeat.o(215307);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.PluginTaskBar.g
 * JD-Core Version:    0.7.0.1
 */
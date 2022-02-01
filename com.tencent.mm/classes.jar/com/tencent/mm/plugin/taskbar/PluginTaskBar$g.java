package com.tencent.mm.plugin.taskbar;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.a.a;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
final class PluginTaskBar$g
  implements Runnable
{
  PluginTaskBar$g(PluginTaskBar paramPluginTaskBar, Bitmap paramBitmap, String paramString, a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(258566);
    try
    {
      BitmapUtil.saveBitmapToImage(this.cKG, 100, Bitmap.CompressFormat.PNG, this.lCM, false);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.e(PluginTaskBar.access$getTAG$p(this.FRX), "save bitmap failed!", new Object[] { localThrowable });
      return;
    }
    finally
    {
      this.ihE.invoke();
      AppMethodBeat.o(258566);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.taskbar.PluginTaskBar.g
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.vlog.ui.timelineeditor.emojidecoder;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.xeffect.effect.IStickerDecoder;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/emojidecoder/DefaultDecoder;", "Lcom/tencent/mm/xeffect/effect/IStickerDecoder;", "()V", "textBitmap", "Landroid/graphics/Bitmap;", "destroy", "", "duration", "", "getFrame", "seekTo", "time", "size", "Landroid/util/Size;", "plugin-vlog_release"})
public final class a
  implements IStickerDecoder
{
  private Bitmap NEw;
  
  public a()
  {
    AppMethodBeat.i(229941);
    Bitmap localBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ALPHA_8);
    p.j(localBitmap, "Bitmap.createBitmap(1, 1, Bitmap.Config.ALPHA_8)");
    this.NEw = localBitmap;
    AppMethodBeat.o(229941);
  }
  
  public final void destroy() {}
  
  public final long duration()
  {
    return 1073741824L;
  }
  
  public final Bitmap getFrame()
  {
    return this.NEw;
  }
  
  public final void seekTo(long paramLong) {}
  
  public final Size size()
  {
    AppMethodBeat.i(229937);
    Size localSize = new Size(0, 0);
    AppMethodBeat.o(229937);
    return localSize;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.timelineeditor.emojidecoder.a
 * JD-Core Version:    0.7.0.1
 */
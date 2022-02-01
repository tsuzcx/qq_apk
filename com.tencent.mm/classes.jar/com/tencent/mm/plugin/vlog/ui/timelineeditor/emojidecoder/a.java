package com.tencent.mm.plugin.vlog.ui.timelineeditor.emojidecoder;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.util.Size;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.xeffect.effect.IStickerDecoder;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/ui/timelineeditor/emojidecoder/DefaultDecoder;", "Lcom/tencent/mm/xeffect/effect/IStickerDecoder;", "()V", "textBitmap", "Landroid/graphics/Bitmap;", "destroy", "", "duration", "", "getFrame", "seekTo", "time", "size", "Landroid/util/Size;", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements IStickerDecoder
{
  private Bitmap UqH;
  
  public a()
  {
    AppMethodBeat.i(282131);
    Bitmap localBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ALPHA_8);
    s.s(localBitmap, "createBitmap(1, 1, Bitmap.Config.ALPHA_8)");
    this.UqH = localBitmap;
    AppMethodBeat.o(282131);
  }
  
  public final void destroy() {}
  
  public final long duration()
  {
    return 1073741824L;
  }
  
  public final Bitmap getFrame()
  {
    return this.UqH;
  }
  
  public final void seekTo(long paramLong) {}
  
  public final Size size()
  {
    AppMethodBeat.i(282164);
    Size localSize = new Size(0, 0);
    AppMethodBeat.o(282164);
    return localSize;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.ui.timelineeditor.emojidecoder.a
 * JD-Core Version:    0.7.0.1
 */
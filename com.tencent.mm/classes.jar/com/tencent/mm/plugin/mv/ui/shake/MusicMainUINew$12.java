package com.tencent.mm.plugin.mv.ui.shake;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.music.model.i.b;
import com.tencent.mm.videocomposition.effect.a;
import com.tencent.mm.videocomposition.effect.d;
import com.tencent.mm.xeffect.effect.EffectManager;
import kotlin.ah;
import kotlin.g.a.b;

final class MusicMainUINew$12
  implements i.b
{
  a McJ;
  
  MusicMainUINew$12(MusicMainUINew paramMusicMainUINew, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(287306);
    this.McJ = new a();
    AppMethodBeat.o(287306);
  }
  
  public final void at(Bitmap paramBitmap)
  {
    AppMethodBeat.i(287315);
    try
    {
      this.McJ.setInputBitmap(paramBitmap);
      this.McJ.setOutputSize(this.val$width, this.val$height);
      this.McJ.HkF.GpO.jQk();
      this.McJ.aW(new b() {});
      AppMethodBeat.o(287315);
      return;
    }
    catch (Exception paramBitmap)
    {
      AppMethodBeat.o(287315);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.mv.ui.shake.MusicMainUINew.12
 * JD-Core Version:    0.7.0.1
 */
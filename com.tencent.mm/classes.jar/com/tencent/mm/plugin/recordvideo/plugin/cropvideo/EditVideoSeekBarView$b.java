package com.tencent.mm.plugin.recordvideo.plugin.cropvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "error", "", "onPrepared"})
final class EditVideoSeekBarView$b
  implements c.a
{
  public static final b BSM;
  
  static
  {
    AppMethodBeat.i(75704);
    BSM = new b();
    AppMethodBeat.o(75704);
  }
  
  public final void ri(boolean paramBoolean)
  {
    AppMethodBeat.i(75703);
    if (paramBoolean)
    {
      Log.e("MicroMsg.VideoSeekBarEditorView", "Not Supported init SegmentSeekBar failed.");
      AppMethodBeat.o(75703);
      return;
    }
    AppMethodBeat.o(75703);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.cropvideo.EditVideoSeekBarView.b
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.recordvideo.plugin.cropvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.c.a;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "error", "", "onPrepared"})
public final class EditVideoSeekBarView$b
  implements c.a
{
  public static final b wuI;
  
  static
  {
    AppMethodBeat.i(75704);
    wuI = new b();
    AppMethodBeat.o(75704);
  }
  
  public final void oa(boolean paramBoolean)
  {
    AppMethodBeat.i(75703);
    if (paramBoolean)
    {
      ac.e("MicroMsg.VideoSeekBarEditorView", "Not Supported init SegmentSeekBar failed.");
      AppMethodBeat.o(75703);
      return;
    }
    AppMethodBeat.o(75703);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.cropvideo.EditVideoSeekBarView.b
 * JD-Core Version:    0.7.0.1
 */
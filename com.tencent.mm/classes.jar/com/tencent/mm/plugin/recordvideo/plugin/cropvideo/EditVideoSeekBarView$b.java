package com.tencent.mm.plugin.recordvideo.plugin.cropvideo;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.c.a;
import com.tencent.mm.sdk.platformtools.ab;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "error", "", "onPrepared"})
public final class EditVideoSeekBarView$b
  implements c.a
{
  public static final b qds;
  
  static
  {
    AppMethodBeat.i(150750);
    qds = new b();
    AppMethodBeat.o(150750);
  }
  
  public final void jp(boolean paramBoolean)
  {
    AppMethodBeat.i(150749);
    if (paramBoolean)
    {
      ab.e("MicroMsg.VideoSeekBarEditorView", "Not Supported init SegmentSeekBar failed.");
      AppMethodBeat.o(150749);
      return;
    }
    AppMethodBeat.o(150749);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.cropvideo.EditVideoSeekBarView.b
 * JD-Core Version:    0.7.0.1
 */
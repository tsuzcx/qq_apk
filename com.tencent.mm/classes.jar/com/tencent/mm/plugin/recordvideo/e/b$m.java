package com.tencent.mm.plugin.recordvideo.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.recordvideo.jumper.CaptureDataManager.CaptureVideoNormalModel;
import com.tencent.mm.sdk.f.b;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.vfs.o;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
final class b$m
  implements Runnable
{
  b$m(CaptureDataManager.CaptureVideoNormalModel paramCaptureVideoNormalModel) {}
  
  public final void run()
  {
    AppMethodBeat.i(76187);
    String str = b.arS("mp4");
    o.mF(this.xJZ.getVideoPath(), str);
    b.k(str, ak.getContext());
    AppMethodBeat.o(76187);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.e.b.m
 * JD-Core Version:    0.7.0.1
 */
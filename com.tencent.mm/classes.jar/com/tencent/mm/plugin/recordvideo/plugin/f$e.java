package com.tencent.mm.plugin.recordvideo.plugin;

import a.f.b.j;
import a.l;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.e.b.a;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/MotionEvent;", "kotlin.jvm.PlatformType", "onDispatchTouch"})
public final class f$e
  implements b.a
{
  public f$e(f paramf) {}
  
  public final boolean o(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(150622);
    f localf = this.qbZ;
    j.p(paramMotionEvent, "it");
    f.a(localf, paramMotionEvent);
    AppMethodBeat.o(150622);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.plugin.f.e
 * JD-Core Version:    0.7.0.1
 */
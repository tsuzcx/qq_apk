package com.tencent.mm.plugin.recordvideo.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.f.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.vfs.o;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
final class b$h
  implements Runnable
{
  b$h(String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(207134);
    Object localObject = g.ajR();
    p.g(localObject, "MMKernel.storage()");
    boolean bool = ((e)localObject).ajA().getBoolean(am.a.IRU, true);
    ae.i("MicroMsg.MediaFileUtil", "remuxComposition videoState : " + bool + " videoPath:" + this.tcc);
    if (bool)
    {
      localObject = b.arS("mp4");
      o.mF(this.tcc, (String)localObject);
      b.k((String)localObject, ak.getContext());
    }
    AppMethodBeat.o(207134);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.e.b.h
 * JD-Core Version:    0.7.0.1
 */
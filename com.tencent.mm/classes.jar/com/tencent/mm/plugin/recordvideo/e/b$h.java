package com.tencent.mm.plugin.recordvideo.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.f.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.vfs.i;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
final class b$h
  implements Runnable
{
  b$h(String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(199450);
    Object localObject = g.agR();
    k.g(localObject, "MMKernel.storage()");
    boolean bool = ((e)localObject).agA().getBoolean(ah.a.GLe, true);
    ac.i("MicroMsg.MediaFileUtil", "remuxComposition videoState : " + bool + " videoPath:" + this.rUg);
    if (bool)
    {
      localObject = b.alY("mp4");
      i.lZ(this.rUg, (String)localObject);
      b.k((String)localObject, ai.getContext());
    }
    AppMethodBeat.o(199450);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.e.b.h
 * JD-Core Version:    0.7.0.1
 */
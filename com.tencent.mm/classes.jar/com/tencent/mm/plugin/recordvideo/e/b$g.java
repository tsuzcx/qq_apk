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
final class b$g
  implements Runnable
{
  b$g(String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(199449);
    Object localObject = g.agR();
    k.g(localObject, "MMKernel.storage()");
    boolean bool = ((e)localObject).agA().getBoolean(ah.a.GLd, true);
    ac.i("MicroMsg.MediaFileUtil", "handleMultiVideoResult videoState : " + bool + ' ');
    if (bool)
    {
      localObject = b.alY("jpg");
      i.lZ(this.wDI, (String)localObject);
      b.k((String)localObject, ai.getContext());
    }
    AppMethodBeat.o(199449);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.e.b.g
 * JD-Core Version:    0.7.0.1
 */
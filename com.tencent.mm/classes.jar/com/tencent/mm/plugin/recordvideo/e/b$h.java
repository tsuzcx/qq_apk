package com.tencent.mm.plugin.recordvideo.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.f.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.vfs.i;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
final class b$h
  implements Runnable
{
  b$h(String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(200876);
    Object localObject = g.ajC();
    p.g(localObject, "MMKernel.storage()");
    boolean bool = ((e)localObject).ajl().getBoolean(al.a.Ixw, true);
    ad.i("MicroMsg.MediaFileUtil", "remuxComposition videoState : " + bool + " videoPath:" + this.sQR);
    if (bool)
    {
      localObject = b.aqN("mp4");
      i.mz(this.sQR, (String)localObject);
      b.k((String)localObject, aj.getContext());
    }
    AppMethodBeat.o(200876);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.e.b.h
 * JD-Core Version:    0.7.0.1
 */
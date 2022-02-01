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
final class b$g
  implements Runnable
{
  b$g(String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(207133);
    Object localObject = g.ajR();
    p.g(localObject, "MMKernel.storage()");
    boolean bool = ((e)localObject).ajA().getBoolean(am.a.IRT, true);
    ae.i("MicroMsg.MediaFileUtil", "handleMultiVideoResult videoState : " + bool + ' ');
    if (bool)
    {
      localObject = b.arS("jpg");
      o.mF(this.yhi, (String)localObject);
      b.k((String)localObject, ak.getContext());
    }
    AppMethodBeat.o(207133);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.e.b.g
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.recordvideo.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.f.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.vfs.i;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
final class b$l
  implements Runnable
{
  b$l(String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(204329);
    Object localObject = g.afB();
    k.g(localObject, "MMKernel.storage()");
    boolean bool = ((e)localObject).afk().getBoolean(ae.a.Fno, true);
    ad.i("MicroMsg.MediaFileUtil", "handleMultiVideoResult videoState : " + bool + ' ');
    if (bool)
    {
      localObject = b.ahd("jpg");
      i.lC(this.LpU, (String)localObject);
      b.k((String)localObject, aj.getContext());
    }
    AppMethodBeat.o(204329);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.recordvideo.e.b.l
 * JD-Core Version:    0.7.0.1
 */
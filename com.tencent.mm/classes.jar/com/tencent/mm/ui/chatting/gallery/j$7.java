package com.tencent.mm.ui.chatting.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

final class j$7
  implements b
{
  j$7(j paramj) {}
  
  public final long bQp()
  {
    AppMethodBeat.i(32322);
    ab.i("MicroMsg.Imagegallery.handler.video", "%d video get online cache sec", new Object[] { Integer.valueOf(this.zNd.hashCode()) });
    aw.aaz();
    c.Ru().set(ac.a.yFa, Boolean.TRUE);
    try
    {
      if ((j.c(this.zNd)) && (j.f(this.zNd) != null))
      {
        int i = j.f(this.zNd).fVp;
        long l = i;
        AppMethodBeat.o(32322);
        return l;
      }
    }
    catch (Exception localException)
    {
      AppMethodBeat.o(32322);
    }
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.j.7
 * JD-Core Version:    0.7.0.1
 */
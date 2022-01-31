package com.tencent.mm.ui.chatting.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.tools.e.e;
import com.tencent.mm.sdk.platformtools.ab;

final class j$6
  implements e.e
{
  j$6(j paramj) {}
  
  public final void bSk()
  {
    AppMethodBeat.i(32321);
    ab.i("MicroMsg.Imagegallery.handler.video", "%d on texture update.", new Object[] { Integer.valueOf(this.zNd.hashCode()) });
    try
    {
      this.zNd.zJI.dJY().a(true, 1.0F);
      AppMethodBeat.o(32321);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.Imagegallery.handler.video", "texture view update. error " + localException.toString());
      AppMethodBeat.o(32321);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.j.6
 * JD-Core Version:    0.7.0.1
 */
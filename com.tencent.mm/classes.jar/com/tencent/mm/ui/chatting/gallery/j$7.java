package com.tencent.mm.ui.chatting.gallery;

import com.tencent.mm.pluginsdk.ui.tools.f.e;
import com.tencent.mm.sdk.platformtools.y;

final class j$7
  implements f.e
{
  j$7(j paramj) {}
  
  public final void bkk()
  {
    y.i("MicroMsg.Imagegallery.handler.video", "%d on texture update.", new Object[] { Integer.valueOf(this.vwT.hashCode()) });
    try
    {
      this.vwT.vtH.cFV().a(true, 1.0F);
      return;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.Imagegallery.handler.video", "texture view update. error " + localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.j.7
 * JD-Core Version:    0.7.0.1
 */
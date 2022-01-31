package com.tencent.mm.ui.chatting.gallery;

import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.s.b;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

final class j$8
  implements b
{
  j$8(j paramj) {}
  
  public final long bin()
  {
    y.i("MicroMsg.Imagegallery.handler.video", "%d video get online cache sec", new Object[] { Integer.valueOf(this.vwT.hashCode()) });
    au.Hx();
    c.Dz().c(ac.a.uuT, Boolean.valueOf(true));
    try
    {
      if ((j.c(this.vwT)) && (j.f(this.vwT) != null))
      {
        int i = j.f(this.vwT).eFy;
        return i;
      }
    }
    catch (Exception localException) {}
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.j.8
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.ui.chatting.gallery;

import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.sdk.platformtools.y;

final class j$6
  implements Runnable
{
  j$6(j paramj, int paramInt) {}
  
  public final void run()
  {
    Object localObject = j.a(this.vwT);
    int i = this.gAv;
    localObject = u.oe((String)localObject);
    if (localObject != null)
    {
      int j = ((s)localObject).eHH;
      if ((j <= 0) || (Math.abs(j - i) > 2))
      {
        ((s)localObject).eHH = i;
        ((s)localObject).bcw = 4096;
        y.i("MicroMsg.VideoLogic", "repair video duration ret %b, duration[%d, %d]", new Object[] { Boolean.valueOf(u.f((s)localObject)), Integer.valueOf(j), Integer.valueOf(i) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.j.6
 * JD-Core Version:    0.7.0.1
 */
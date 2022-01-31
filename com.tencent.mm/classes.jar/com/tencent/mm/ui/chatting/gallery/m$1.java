package com.tencent.mm.ui.chatting.gallery;

import com.tencent.mm.modelvideo.u;

final class m$1
  implements Runnable
{
  m$1(m paramm) {}
  
  public final void run()
  {
    if (this.vxR.vxP != null)
    {
      int i = u.u(this.vxR.eFu, this.vxR.filename);
      if (this.vxR.jr(i))
      {
        if ((this.vxR.oRT == 0) && (this.vxR.oRV == 0L)) {
          this.vxR.bHW();
        }
        this.vxR.vxP.bg(this.vxR.filename, true);
        this.vxR.eFA = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.m.1
 * JD-Core Version:    0.7.0.1
 */
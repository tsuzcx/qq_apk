package com.tencent.mm.ui.chatting.gallery;

import com.tencent.mm.sdk.platformtools.y;

final class c$a$2
  implements ImageGalleryUI.a
{
  c$a$2(c.a parama, c paramc) {}
  
  public final void k(Boolean paramBoolean)
  {
    y.i("MicroMsg.AutoList", "isPlaying : " + paramBoolean);
    if (!paramBoolean.booleanValue())
    {
      c.a.a(this.vul);
      if (this.vuk.vtR != null) {
        this.vuk.vtR.kA();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.c.a.2
 * JD-Core Version:    0.7.0.1
 */
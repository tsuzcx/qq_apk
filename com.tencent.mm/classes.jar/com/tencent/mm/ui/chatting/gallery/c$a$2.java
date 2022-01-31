package com.tencent.mm.ui.chatting.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

final class c$a$2
  implements ImageGalleryUI.a
{
  c$a$2(c.a parama, c paramc) {}
  
  public final void m(Boolean paramBoolean)
  {
    AppMethodBeat.i(31965);
    ab.i("MicroMsg.AutoList", "isPlaying : ".concat(String.valueOf(paramBoolean)));
    if (!paramBoolean.booleanValue())
    {
      c.a.a(this.zKm);
      if (this.zKl.zJS != null) {
        this.zKl.zJS.mG();
      }
    }
    AppMethodBeat.o(31965);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.c.a.2
 * JD-Core Version:    0.7.0.1
 */
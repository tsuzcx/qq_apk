package com.tencent.mm.ui.chatting.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/chatting/gallery/ResourceState;", "", "(Ljava/lang/String;I)V", "EXPIRED", "NOT_DOWNLOADED", "DOWNLOADED", "app_release"})
public enum u
{
  static
  {
    AppMethodBeat.i(267201);
    u localu1 = new u("EXPIRED", 0);
    WWI = localu1;
    u localu2 = new u("NOT_DOWNLOADED", 1);
    WWJ = localu2;
    u localu3 = new u("DOWNLOADED", 2);
    WWK = localu3;
    WWL = new u[] { localu1, localu2, localu3 };
    AppMethodBeat.o(267201);
  }
  
  private u() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.u
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.ui.chatting.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/ui/chatting/gallery/ResourceState;", "", "(Ljava/lang/String;I)V", "EXPIRED", "NOT_DOWNLOADED", "DOWNLOADED", "app_release"})
public enum p
{
  static
  {
    AppMethodBeat.i(231221);
    p localp1 = new p("EXPIRED", 0);
    PBM = localp1;
    p localp2 = new p("NOT_DOWNLOADED", 1);
    PBN = localp2;
    p localp3 = new p("DOWNLOADED", 2);
    PBO = localp3;
    PBP = new p[] { localp1, localp2, localp3 };
    AppMethodBeat.o(231221);
  }
  
  private p() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.p
 * JD-Core Version:    0.7.0.1
 */
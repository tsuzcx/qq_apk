package com.tencent.mm.ui.chatting.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/gallery/ResourceState;", "", "(Ljava/lang/String;I)V", "EXPIRED", "NOT_DOWNLOADED", "DOWNLOADED", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum w
{
  static
  {
    AppMethodBeat.i(254439);
    aeGm = new w("EXPIRED", 0);
    aeGn = new w("NOT_DOWNLOADED", 1);
    aeGo = new w("DOWNLOADED", 2);
    aeGp = new w[] { aeGm, aeGn, aeGo };
    AppMethodBeat.o(254439);
  }
  
  private w() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.gallery.w
 * JD-Core Version:    0.7.0.1
 */
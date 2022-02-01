package com.tencent.mm.ui.chatting.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.chatting.d.b.al;
import com.tencent.mm.ui.chatting.gallery.a.l.a;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

@com.tencent.mm.ui.chatting.d.a.a(gRF=al.class)
@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/ui/chatting/component/ScanComponent;", "Lcom/tencent/mm/ui/chatting/component/AbstractChattingComponent;", "Lcom/tencent/mm/ui/chatting/component/api/IScanComponent;", "()V", "onChattingExitAnimEnd", "", "Companion", "app_release"})
public final class av
  extends a
  implements al
{
  public static final av.a Ptn;
  
  static
  {
    AppMethodBeat.i(231220);
    Ptn = new av.a((byte)0);
    AppMethodBeat.o(231220);
  }
  
  public final void gIo()
  {
    AppMethodBeat.i(231219);
    super.gIo();
    l.a locala = com.tencent.mm.ui.chatting.gallery.a.l.PCP;
    Log.i("MicroMsg.ImageSearchPreviewManager", "alvinluo clearCache previewResult size: %d, msgIdToPHashCache size: %d", new Object[] { Integer.valueOf(com.tencent.mm.ui.chatting.gallery.a.l.gTA().size()), Integer.valueOf(com.tencent.mm.ui.chatting.gallery.a.l.gTB().size()) });
    com.tencent.mm.ui.chatting.gallery.a.l.gTA().clear();
    com.tencent.mm.ui.chatting.gallery.a.l.gTB().clear();
    AppMethodBeat.o(231219);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.av
 * JD-Core Version:    0.7.0.1
 */
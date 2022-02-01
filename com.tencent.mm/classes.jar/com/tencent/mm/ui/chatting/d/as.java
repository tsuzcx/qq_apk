package com.tencent.mm.ui.chatting.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.chatting.d.b.ai;
import com.tencent.mm.ui.chatting.gallery.a.l.a;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

@com.tencent.mm.ui.chatting.d.a.a(fJv=ai.class)
@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/ui/chatting/component/ScanComponent;", "Lcom/tencent/mm/ui/chatting/component/AbstractChattingComponent;", "Lcom/tencent/mm/ui/chatting/component/api/IScanComponent;", "()V", "onChattingExitAnimEnd", "", "Companion", "app_release"})
public final class as
  extends a
  implements ai
{
  public static final as.a Khs;
  
  static
  {
    AppMethodBeat.i(188272);
    Khs = new as.a((byte)0);
    AppMethodBeat.o(188272);
  }
  
  public final void fAy()
  {
    AppMethodBeat.i(188271);
    super.fAy();
    l.a locala = com.tencent.mm.ui.chatting.gallery.a.l.KqG;
    ae.i("MicroMsg.ImageSearchPreviewManager", "alvinluo clearCache previewResult size: %d, msgIdToPHashCache size: %d", new Object[] { Integer.valueOf(com.tencent.mm.ui.chatting.gallery.a.l.fLi().size()), Integer.valueOf(com.tencent.mm.ui.chatting.gallery.a.l.fLj().size()) });
    com.tencent.mm.ui.chatting.gallery.a.l.fLi().clear();
    com.tencent.mm.ui.chatting.gallery.a.l.fLj().clear();
    AppMethodBeat.o(188271);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.as
 * JD-Core Version:    0.7.0.1
 */
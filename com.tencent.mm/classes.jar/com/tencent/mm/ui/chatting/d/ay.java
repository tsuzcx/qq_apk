package com.tencent.mm.ui.chatting.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.chatting.d.b.am;
import com.tencent.mm.ui.chatting.gallery.a.j;
import com.tencent.mm.ui.chatting.gallery.a.j.a;
import com.tencent.worddetect.b;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.l;

@com.tencent.mm.ui.chatting.d.a.a(hRc=am.class)
@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ui/chatting/component/ScanComponent;", "Lcom/tencent/mm/ui/chatting/component/AbstractChattingComponent;", "Lcom/tencent/mm/ui/chatting/component/api/IScanComponent;", "()V", "onChattingExitAnimEnd", "", "releaseWordDetect", "Companion", "app_release"})
public final class ay
  extends a
  implements am
{
  public static final ay.a WNQ;
  
  static
  {
    AppMethodBeat.i(272506);
    WNQ = new ay.a((byte)0);
    AppMethodBeat.o(272506);
  }
  
  public final void hHa()
  {
    AppMethodBeat.i(272505);
    super.hHa();
    j.a locala = j.WXH;
    Log.i("MicroMsg.ImageSearchPreviewManager", "alvinluo clearCache previewResult size: %d, msgIdToPHashCache size: %d", new Object[] { Integer.valueOf(j.hTg().size()), Integer.valueOf(j.hTh().size()) });
    j.hTg().clear();
    j.hTh().clear();
    b.release();
    AppMethodBeat.o(272505);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.d.ay
 * JD-Core Version:    0.7.0.1
 */
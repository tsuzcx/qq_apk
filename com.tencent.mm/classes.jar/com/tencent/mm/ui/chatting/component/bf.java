package com.tencent.mm.ui.chatting.component;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.chatting.component.api.at;
import com.tencent.mm.ui.chatting.gallery.scan.j;
import com.tencent.mm.ui.chatting.gallery.scan.j.a;
import com.tencent.worddetect.b;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;

@com.tencent.mm.ui.chatting.component.annotation.a(juB=at.class)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/component/ScanComponent;", "Lcom/tencent/mm/ui/chatting/component/AbstractChattingComponent;", "Lcom/tencent/mm/ui/chatting/component/api/IScanComponent;", "()V", "onChattingExitAnimEnd", "", "releaseWordDetect", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bf
  extends a
  implements at
{
  public static final bf.a aewq;
  
  static
  {
    AppMethodBeat.i(256356);
    aewq = new bf.a((byte)0);
    AppMethodBeat.o(256356);
  }
  
  public final void jjl()
  {
    AppMethodBeat.i(256362);
    super.jjl();
    j.a locala = j.aeHd;
    Log.i("MicroMsg.ImageSearchPreviewManager", "alvinluo clearCache previewResult size: %d, msgIdToPHashCache size: %d", new Object[] { Integer.valueOf(j.jwH().size()), Integer.valueOf(j.jwI().size()) });
    j.jwH().clear();
    j.jwI().clear();
    b.release();
    AppMethodBeat.o(256362);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.bf
 * JD-Core Version:    0.7.0.1
 */
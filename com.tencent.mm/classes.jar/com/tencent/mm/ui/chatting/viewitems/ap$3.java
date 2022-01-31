package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.record.b.e;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.sdk.platformtools.ab;

final class ap$3
  implements f
{
  ap$3(ap paramap, b paramb) {}
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(33385);
    ab.d("MicroMsg.ChattingItemVoiceRemindConfirm", "errType " + paramInt1 + " errCode " + paramInt2 + "  scene " + paramm.getType());
    if (((e)paramm).getMediaId().equals(this.zYb.field_mediaSvrId))
    {
      aw.Rc().b(221, ap.b(this.zYa));
      ap.a(this.zYa, null);
    }
    AppMethodBeat.o(33385);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.ap.3
 * JD-Core Version:    0.7.0.1
 */
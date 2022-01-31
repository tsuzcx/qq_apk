package com.tencent.mm.ui.chatting;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.ShowMessageFromWX.Req;
import com.tencent.mm.pluginsdk.model.app.ai;
import java.util.Map;

final class ar$2$1
  implements ai
{
  ar$2$1(ar.2 param2, ShowMessageFromWX.Req paramReq) {}
  
  public final void dZ(boolean paramBoolean)
  {
    AppMethodBeat.i(31087);
    if (paramBoolean) {
      ar.b(this.zCZ.zCY).put(this.vLc.transaction, this.vLc);
    }
    if (this.zCZ.zCX != null) {
      this.zCZ.zCX.dZ(paramBoolean);
    }
    AppMethodBeat.o(31087);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.ar.2.1
 * JD-Core Version:    0.7.0.1
 */
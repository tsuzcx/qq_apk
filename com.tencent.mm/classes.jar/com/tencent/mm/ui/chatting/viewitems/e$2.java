package com.tencent.mm.ui.chatting.viewitems;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.chatroom.d.ab;
import com.tencent.mm.chatroom.d.ab.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.chatting.d.a;

final class e$2
  implements ab.a
{
  e$2(boolean paramBoolean, c.a parama, a parama1, cc paramcc) {}
  
  public final void aLZ()
  {
    AppMethodBeat.i(255397);
    if (!this.aeMV) {}
    for (boolean bool = true;; bool = false)
    {
      e.a(bool, this.aeMv, this.XSz);
      Pair localPair = ab.c(this.oiV);
      Log.i("MicroMsg.ChattingItemAppMsg", "handleTodoClickImp addtodo msgId(%s) result:%s", new Object[] { Long.valueOf(this.oiV.field_msgSvrId), localPair });
      AppMethodBeat.o(255397);
      return;
    }
  }
  
  public final void aMa()
  {
    AppMethodBeat.i(255399);
    if (!this.aeMV) {}
    for (boolean bool = true;; bool = false)
    {
      e.a(bool, this.aeMv, this.XSz);
      Pair localPair = ab.e(this.oiV);
      Log.i("MicroMsg.ChattingItemAppMsg", "handleTodoClickImp recall msgId(%s) result:%s", new Object[] { Long.valueOf(this.oiV.field_msgSvrId), localPair });
      AppMethodBeat.o(255399);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.e.2
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.ui.chatting.viewitems;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatroom.d.ac;
import com.tencent.mm.ui.widget.a.f.b;

final class e$5
  implements f.b
{
  e$5(e.f paramf, String paramString1, boolean paramBoolean, String paramString2, String paramString3) {}
  
  public final void onDismiss()
  {
    AppMethodBeat.i(255198);
    String str;
    int j;
    if (!this.aeMW.aeOK)
    {
      str = this.lzC;
      j = this.lyS;
      if (!this.aeMV) {
        break label56;
      }
    }
    label56:
    for (int i = 1;; i = 2)
    {
      ac.a(str, 1, j, i, 1, this.aeMZ, this.aeNa);
      AppMethodBeat.o(255198);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.e.5
 * JD-Core Version:    0.7.0.1
 */
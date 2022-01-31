package com.tencent.mm.ui.chatting.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.choosemsgfile.compat.b.a;
import com.tencent.mm.pluginsdk.model.app.l.a;

final class a$5
  implements l.a
{
  a$5(a parama, b.a parama1) {}
  
  public final void ha(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(31164);
    if (this.zDU != null) {
      this.zDU.bV(paramInt1, paramInt2);
    }
    if ((paramInt1 >= paramInt2) && (this.zDU != null)) {
      this.zDU.p(0, "");
    }
    AppMethodBeat.o(31164);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.a.5
 * JD-Core Version:    0.7.0.1
 */
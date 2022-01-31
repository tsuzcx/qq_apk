package com.tencent.mm.ui.chatting.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.g;
import com.tencent.mm.ai.m;
import com.tencent.mm.choosemsgfile.compat.b.a;

final class a$3
  implements g
{
  a$3(a parama, b.a parama1) {}
  
  public final void a(int paramInt1, int paramInt2, m paramm)
  {
    AppMethodBeat.i(31162);
    if (this.zDU != null) {
      this.zDU.bV(paramInt1, paramInt2);
    }
    if ((paramInt1 >= paramInt2) && (this.zDU != null)) {
      this.zDU.p(0, "");
    }
    AppMethodBeat.o(31162);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.b.a.3
 * JD-Core Version:    0.7.0.1
 */
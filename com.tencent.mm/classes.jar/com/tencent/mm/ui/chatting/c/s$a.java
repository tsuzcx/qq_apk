package com.tencent.mm.ui.chatting.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.f;
import com.tencent.mm.at.d;
import com.tencent.mm.at.e;
import com.tencent.mm.at.o;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.storage.bi;
import java.util.HashSet;

final class s$a
  implements Runnable
{
  private bi cEE;
  private int i;
  private e pNY;
  
  s$a(s params, bi parambi, e parame, int paramInt)
  {
    this.cEE = parambi;
    this.pNY = parame;
    this.i = paramInt;
  }
  
  public final void run()
  {
    AppMethodBeat.i(31457);
    f.afO().fyQ.add("image_" + this.cEE.field_msgId);
    o.ahD().a(this.pNY.fDL, this.cEE.field_msgId, 0, Integer.valueOf(this.i), 2130838228, this.zGl, -1, true);
    AppMethodBeat.o(31457);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.c.s.a
 * JD-Core Version:    0.7.0.1
 */
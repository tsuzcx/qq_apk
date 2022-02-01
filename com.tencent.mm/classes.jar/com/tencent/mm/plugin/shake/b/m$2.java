package com.tencent.mm.plugin.shake.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.bb;
import com.tencent.mm.model.ab;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.bw.a;

final class m$2
  implements bw.a
{
  m$2(m paramm) {}
  
  public final void a(az paramaz, bw parambw)
  {
    AppMethodBeat.i(28151);
    if ((paramaz != null) && (ab.Jw(paramaz.field_username))) {
      paramaz.setUsername("");
    }
    AppMethodBeat.o(28151);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.b.m.2
 * JD-Core Version:    0.7.0.1
 */
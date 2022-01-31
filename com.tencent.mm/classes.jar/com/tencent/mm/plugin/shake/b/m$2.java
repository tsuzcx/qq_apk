package com.tencent.mm.plugin.shake.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.t;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.be.a;

final class m$2
  implements be.a
{
  m$2(m paramm) {}
  
  public final void a(ak paramak, be parambe)
  {
    AppMethodBeat.i(24476);
    if ((paramak != null) && (t.ox(paramak.field_username))) {
      paramak.setUsername("");
    }
    AppMethodBeat.o(24476);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.shake.b.m.2
 * JD-Core Version:    0.7.0.1
 */
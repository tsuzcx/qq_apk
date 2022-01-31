package com.tencent.soter.a.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.a.e.b;
import com.tencent.soter.a.e.b.a;
import com.tencent.soter.core.c.d;

public final class k
  extends c
{
  com.tencent.soter.a.f.e Bon = null;
  private boolean Boo = false;
  
  public k(com.tencent.soter.a.f.e parame, boolean paramBoolean)
  {
    this.Bon = parame;
    this.Boo = paramBoolean;
  }
  
  final boolean dVB()
  {
    AppMethodBeat.i(10562);
    if (!com.tencent.soter.a.c.a.dVu().isInit())
    {
      d.w("Soter.TaskPrepareAppSecureKey", "soter: not initialized yet", new Object[0]);
      b(new com.tencent.soter.a.b.c(14));
      AppMethodBeat.o(10562);
      return true;
    }
    if (!com.tencent.soter.a.c.a.dVu().dVs())
    {
      d.w("Soter.TaskPrepareAppSecureKey", "soter: not support soter", new Object[0]);
      b(new com.tencent.soter.a.b.c(2));
      AppMethodBeat.o(10562);
      return true;
    }
    if ((com.tencent.soter.core.a.dVg()) && (!this.Boo))
    {
      d.i("Soter.TaskPrepareAppSecureKey", "soter: already has ask. do not need generate again", new Object[0]);
      b(new com.tencent.soter.a.b.c(com.tencent.soter.core.a.dVh()));
      AppMethodBeat.o(10562);
      return true;
    }
    if (this.Bon == null) {
      d.w("Soter.TaskPrepareAppSecureKey", "soter: it is strongly recommended that you provide a net wrapper to check and upload ASK validation from server! Please make sure you upload it later", new Object[0]);
    }
    AppMethodBeat.o(10562);
    return false;
  }
  
  final void dVC()
  {
    AppMethodBeat.i(10563);
    d.w("Soter.TaskPrepareAppSecureKey", "soter: cancelled prepare ask", new Object[0]);
    com.tencent.soter.core.a.dVe();
    AppMethodBeat.o(10563);
  }
  
  final void execute()
  {
    AppMethodBeat.i(10564);
    ff(com.tencent.soter.core.c.e.dVl().Bmr, 1);
    b.a locala = new b.a();
    boolean bool = this.Boo;
    locala.Bnc |= 0x1;
    locala.Bne = bool;
    locala.Bng = new k.1(this);
    locala.dVz().dVy();
    AppMethodBeat.o(10564);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.soter.a.g.k
 * JD-Core Version:    0.7.0.1
 */
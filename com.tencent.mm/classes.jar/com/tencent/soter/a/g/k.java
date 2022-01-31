package com.tencent.soter.a.g;

import com.tencent.soter.a.e.b;
import com.tencent.soter.a.e.b.a;
import com.tencent.soter.core.c.d;

public final class k
  extends c
{
  com.tencent.soter.a.f.e wQN = null;
  private boolean wQO = false;
  
  public k(com.tencent.soter.a.f.e parame, boolean paramBoolean)
  {
    this.wQN = parame;
    this.wQO = paramBoolean;
  }
  
  final boolean cPF()
  {
    if (!com.tencent.soter.a.c.a.cPy().isInit())
    {
      d.w("Soter.TaskPrepareAppSecureKey", "soter: not initialized yet", new Object[0]);
      b(new com.tencent.soter.a.b.c(14));
      return true;
    }
    if (!com.tencent.soter.a.c.a.cPy().cPw())
    {
      d.w("Soter.TaskPrepareAppSecureKey", "soter: not support soter", new Object[0]);
      b(new com.tencent.soter.a.b.c(2));
      return true;
    }
    if ((com.tencent.soter.core.a.cPl()) && (!this.wQO))
    {
      d.i("Soter.TaskPrepareAppSecureKey", "soter: already has ask. do not need generate again", new Object[0]);
      b(new com.tencent.soter.a.b.c(com.tencent.soter.core.a.cPm()));
      return true;
    }
    if (this.wQN == null) {
      d.w("Soter.TaskPrepareAppSecureKey", "soter: it is strongly recommended that you provide a net wrapper to check and upload ASK validation from server! Please make sure you upload it later", new Object[0]);
    }
    return false;
  }
  
  final void cPG()
  {
    d.w("Soter.TaskPrepareAppSecureKey", "soter: cancelled prepare ask", new Object[0]);
    com.tencent.soter.core.a.cPj();
  }
  
  final void execute()
  {
    dV(com.tencent.soter.core.c.e.cPq().wOT, 1);
    b.a locala = new b.a();
    boolean bool = this.wQO;
    locala.wPC |= 0x1;
    locala.wPE = bool;
    locala.wPG = new k.1(this);
    locala.cPD().cPC();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.soter.a.g.k
 * JD-Core Version:    0.7.0.1
 */
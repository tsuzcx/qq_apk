package com.tencent.soter.a.g;

import android.annotation.SuppressLint;
import android.util.SparseArray;
import com.tencent.soter.a.e.b;
import com.tencent.soter.a.e.b.a;
import com.tencent.soter.a.f.e;
import com.tencent.soter.core.c.d;
import com.tencent.soter.core.c.g;

public final class l
  extends c
{
  private int fzn = -1;
  e psg = null;
  private e psh = null;
  String wPD = null;
  private boolean wQO = false;
  private boolean wQR = false;
  
  public l(int paramInt, e parame1, e parame2, boolean paramBoolean)
  {
    this.fzn = paramInt;
    this.psg = parame1;
    this.wQO = paramBoolean;
    this.wQR = true;
    this.psh = parame2;
  }
  
  private void cPP()
  {
    dV(this.wPD, 1);
    b.a locala = new b.a();
    String str = this.wPD;
    boolean bool = this.wQO;
    locala.wPD = str;
    locala.wPF = bool;
    locala.wPC |= 0x2;
    locala.wPG = new l.2(this);
    locala.cPD().cPC();
  }
  
  @SuppressLint({"DefaultLocale"})
  final boolean cPF()
  {
    if (!com.tencent.soter.a.c.a.cPy().isInit())
    {
      d.w("Soter.TaskPrepareAuthKey", "soter: not initialized yet", new Object[0]);
      b(new com.tencent.soter.a.b.c(14));
      return true;
    }
    if (!com.tencent.soter.a.c.a.cPy().cPw())
    {
      d.w("Soter.TaskPrepareAuthKey", "soter: not support soter", new Object[0]);
      b(new com.tencent.soter.a.b.c(2));
      return true;
    }
    this.wPD = ((String)com.tencent.soter.a.c.a.cPy().cPA().get(this.fzn, ""));
    if (g.bl(this.wPD))
    {
      d.w("Soter.TaskPrepareAuthKey", "soter: request prepare auth key scene: %d, but key name is not registered. Please make sure you register the scene in init", new Object[0]);
      b(new com.tencent.soter.a.b.c(15, String.format("auth scene %d not initialized in map", new Object[] { Integer.valueOf(this.fzn) })));
      return true;
    }
    boolean bool = com.tencent.soter.core.a.cPl();
    if ((!bool) && (com.tencent.soter.core.a.afP(this.wPD)))
    {
      d.w("Soter.TaskPrepareAuthKey", "soter: no ask but has auth key. delete the auth key as well", new Object[0]);
      com.tencent.soter.core.a.bR(this.wPD, false);
    }
    if ((!bool) && (!this.wQR))
    {
      d.w("Soter.TaskPrepareAuthKey", "soter: has not generate app secure key yet and not require to generate it", new Object[0]);
      b(new com.tencent.soter.a.b.c(3));
      return true;
    }
    if ((com.tencent.soter.core.a.afP(this.wPD)) && (!com.tencent.soter.core.a.afQ(this.wPD)))
    {
      d.w("Soter.TaskPrepareAuthKey", "soter: already has auth key but not valid. delete it already and re-generate", new Object[0]);
      return false;
    }
    if ((com.tencent.soter.core.a.afP(this.wPD)) && (!this.wQO))
    {
      d.i("Soter.TaskPrepareAuthKey", "soter: already has key. do not need generate again", new Object[0]);
      b(new com.tencent.soter.a.b.c(com.tencent.soter.core.a.afR(this.wPD)));
      return true;
    }
    if (this.psg == null) {
      d.w("Soter.TaskPrepareAuthKey", "soter: it is strongly recommended that you provide a net wrapper to check and upload AuthKey validation from server! Please make sure you upload it later", new Object[0]);
    }
    return false;
  }
  
  final void cPG()
  {
    d.w("Soter.TaskPrepareAuthKey", "soter: cancelled prepare authkey: %s", new Object[] { this.wPD });
    com.tencent.soter.core.a.bR(this.wPD, false);
  }
  
  final void execute()
  {
    if ((!com.tencent.soter.core.a.cPl()) && (this.wQR))
    {
      d.d("Soter.TaskPrepareAuthKey", "soter: ask not found, but required to generate it. start generate", new Object[0]);
      com.tencent.soter.a.a.a(new l.1(this), false, this.psh);
      return;
    }
    cPP();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.soter.a.g.l
 * JD-Core Version:    0.7.0.1
 */
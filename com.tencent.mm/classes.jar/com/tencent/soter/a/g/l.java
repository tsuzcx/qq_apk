package com.tencent.soter.a.g;

import android.annotation.SuppressLint;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.a.e.b;
import com.tencent.soter.a.e.b.a;
import com.tencent.soter.a.f.e;
import com.tencent.soter.core.c.d;
import com.tencent.soter.core.c.g;

public final class l
  extends c
{
  String Bnd = null;
  private boolean Boo = false;
  private boolean Bor = false;
  private int mScene = -1;
  e soi = null;
  private e soj = null;
  
  public l(int paramInt, e parame1, e parame2, boolean paramBoolean)
  {
    this.mScene = paramInt;
    this.soi = parame1;
    this.Boo = paramBoolean;
    this.Bor = true;
    this.soj = parame2;
  }
  
  private void dVL()
  {
    AppMethodBeat.i(10572);
    ff(this.Bnd, 1);
    b.a locala = new b.a().cv(this.Bnd, this.Boo);
    locala.Bng = new l.2(this);
    locala.dVz().dVy();
    AppMethodBeat.o(10572);
  }
  
  @SuppressLint({"DefaultLocale"})
  final boolean dVB()
  {
    AppMethodBeat.i(10569);
    if (!com.tencent.soter.a.c.a.dVu().isInit())
    {
      d.w("Soter.TaskPrepareAuthKey", "soter: not initialized yet", new Object[0]);
      b(new com.tencent.soter.a.b.c(14));
      AppMethodBeat.o(10569);
      return true;
    }
    if (!com.tencent.soter.a.c.a.dVu().dVs())
    {
      d.w("Soter.TaskPrepareAuthKey", "soter: not support soter", new Object[0]);
      b(new com.tencent.soter.a.b.c(2));
      AppMethodBeat.o(10569);
      return true;
    }
    this.Bnd = ((String)com.tencent.soter.a.c.a.dVu().dVw().get(this.mScene, ""));
    if (g.isNullOrNil(this.Bnd))
    {
      d.w("Soter.TaskPrepareAuthKey", "soter: request prepare auth key scene: %d, but key name is not registered. Please make sure you register the scene in init", new Object[0]);
      b(new com.tencent.soter.a.b.c(15, String.format("auth scene %d not initialized in map", new Object[] { Integer.valueOf(this.mScene) })));
      AppMethodBeat.o(10569);
      return true;
    }
    boolean bool = com.tencent.soter.core.a.dVg();
    if ((!bool) && (com.tencent.soter.core.a.awK(this.Bnd)))
    {
      d.w("Soter.TaskPrepareAuthKey", "soter: no ask but has auth key. delete the auth key as well", new Object[0]);
      com.tencent.soter.core.a.cu(this.Bnd, false);
    }
    if ((!bool) && (!this.Bor))
    {
      d.w("Soter.TaskPrepareAuthKey", "soter: has not generate app secure key yet and not require to generate it", new Object[0]);
      b(new com.tencent.soter.a.b.c(3));
      AppMethodBeat.o(10569);
      return true;
    }
    if ((com.tencent.soter.core.a.awK(this.Bnd)) && (!com.tencent.soter.core.a.awL(this.Bnd)))
    {
      d.w("Soter.TaskPrepareAuthKey", "soter: already has auth key but not valid. delete it already and re-generate", new Object[0]);
      AppMethodBeat.o(10569);
      return false;
    }
    if ((com.tencent.soter.core.a.awK(this.Bnd)) && (!this.Boo))
    {
      d.i("Soter.TaskPrepareAuthKey", "soter: already has key. do not need generate again", new Object[0]);
      b(new com.tencent.soter.a.b.c(com.tencent.soter.core.a.awM(this.Bnd)));
      AppMethodBeat.o(10569);
      return true;
    }
    if (this.soi == null) {
      d.w("Soter.TaskPrepareAuthKey", "soter: it is strongly recommended that you provide a net wrapper to check and upload AuthKey validation from server! Please make sure you upload it later", new Object[0]);
    }
    AppMethodBeat.o(10569);
    return false;
  }
  
  final void dVC()
  {
    AppMethodBeat.i(10570);
    d.w("Soter.TaskPrepareAuthKey", "soter: cancelled prepare authkey: %s", new Object[] { this.Bnd });
    com.tencent.soter.core.a.cu(this.Bnd, false);
    AppMethodBeat.o(10570);
  }
  
  final void execute()
  {
    AppMethodBeat.i(10571);
    if ((!com.tencent.soter.core.a.dVg()) && (this.Bor))
    {
      d.d("Soter.TaskPrepareAuthKey", "soter: ask not found, but required to generate it. start generate", new Object[0]);
      com.tencent.soter.a.a.a(new l.1(this), false, this.soj);
      AppMethodBeat.o(10571);
      return;
    }
    dVL();
    AppMethodBeat.o(10571);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.soter.a.g.l
 * JD-Core Version:    0.7.0.1
 */
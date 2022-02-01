package com.tencent.soter.a.g;

import android.annotation.SuppressLint;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.a.e.b.a;
import com.tencent.soter.a.f.e;
import com.tencent.soter.a.f.e.a;
import com.tencent.soter.a.f.e.b;
import com.tencent.soter.core.c.d;
import com.tencent.soter.core.c.g;
import com.tencent.soter.core.c.i;

public final class l
  extends c
{
  e FhP = null;
  private e FhQ = null;
  String RQC = null;
  private boolean RRQ = false;
  private boolean RRT = false;
  private int mScene = -1;
  
  public l(int paramInt, e parame1, e parame2, boolean paramBoolean)
  {
    this.mScene = paramInt;
    this.FhP = parame1;
    this.RRQ = paramBoolean;
    this.RRT = true;
    this.FhQ = parame2;
  }
  
  private void hlW()
  {
    AppMethodBeat.i(126);
    hx(this.RQC, 1);
    b.a locala = new b.a().dF(this.RQC, this.RRQ);
    locala.RQF = new com.tencent.soter.a.e.a()
    {
      public final void onError(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(120);
        d.w("Soter.TaskPrepareAuthKey", "soter: auth key %s generate failed. errcode: %d, errmsg: %s", new Object[] { l.this.RQC, Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        l.hx(l.this.RQC, 0);
        l.this.c(new com.tencent.soter.a.b.c(paramAnonymousInt, paramAnonymousString));
        AppMethodBeat.o(120);
      }
      
      public final void onSuccess()
      {
        AppMethodBeat.i(121);
        d.i("Soter.TaskPrepareAuthKey", "soter: auth key generate successfully. start upload", new Object[0]);
        if (l.this.FhP != null) {
          l.hx(l.this.RQC, 2);
        }
        l locall;
        i locali;
        for (;;)
        {
          locall = l.this;
          locali = com.tencent.soter.core.a.bqj(locall.RQC);
          if (locali != null) {
            break;
          }
          d.e("Soter.TaskPrepareAuthKey", "soter: auth key model is null even after generation. fatal error", new Object[0]);
          com.tencent.soter.core.a.dE(locall.RQC, false);
          locall.c(new com.tencent.soter.a.b.c(1006, "auth key model is null even after generation."));
          AppMethodBeat.o(121);
          return;
          l.hx(l.this.RQC, 0);
        }
        if (locall.FhP != null)
        {
          locall.FhP.setRequest(new e.a(locali.signature, locali.RPQ));
          locall.FhP.a(new l.3(locall, locali));
          locall.FhP.execute();
          AppMethodBeat.o(121);
          return;
        }
        d.d("Soter.TaskPrepareAuthKey", "soter: not provide network wrapper instance. please check if it is what you want. we treat it as normal", new Object[0]);
        locall.c(new com.tencent.soter.a.b.c("treat as normal because you do not provide the net wrapper", locali));
        AppMethodBeat.o(121);
      }
    };
    locala.hlK().hi();
    AppMethodBeat.o(126);
  }
  
  final void execute()
  {
    AppMethodBeat.i(125);
    if ((!com.tencent.soter.core.a.hln()) && (this.RRT))
    {
      d.d("Soter.TaskPrepareAuthKey", "soter: ask not found, but required to generate it. start generate", new Object[0]);
      com.tencent.soter.a.a.a(new com.tencent.soter.a.b.b() {}, false, this.FhQ);
      AppMethodBeat.o(125);
      return;
    }
    hlW();
    AppMethodBeat.o(125);
  }
  
  @SuppressLint({"DefaultLocale"})
  final boolean hlM()
  {
    AppMethodBeat.i(123);
    if (!com.tencent.soter.a.c.b.hlG().isInit())
    {
      d.w("Soter.TaskPrepareAuthKey", "soter: not initialized yet", new Object[0]);
      c(new com.tencent.soter.a.b.c(1008));
      AppMethodBeat.o(123);
      return true;
    }
    if (!com.tencent.soter.a.c.b.hlG().hlC())
    {
      d.w("Soter.TaskPrepareAuthKey", "soter: not support soter", new Object[0]);
      c(new com.tencent.soter.a.b.c(2));
      AppMethodBeat.o(123);
      return true;
    }
    this.RQC = ((String)com.tencent.soter.a.c.b.hlG().hlI().get(this.mScene, ""));
    if (g.isNullOrNil(this.RQC))
    {
      d.w("Soter.TaskPrepareAuthKey", "soter: request prepare auth key scene: %d, but key name is not registered. Please make sure you register the scene in init", new Object[0]);
      c(new com.tencent.soter.a.b.c(1009, String.format("auth scene %d not initialized in map", new Object[] { Integer.valueOf(this.mScene) })));
      AppMethodBeat.o(123);
      return true;
    }
    boolean bool = com.tencent.soter.core.a.hln();
    if ((!bool) && (com.tencent.soter.core.a.bqh(this.RQC)))
    {
      d.w("Soter.TaskPrepareAuthKey", "soter: no ask but has auth key. delete the auth key as well", new Object[0]);
      com.tencent.soter.core.a.dE(this.RQC, false);
    }
    if ((!bool) && (!this.RRT))
    {
      d.w("Soter.TaskPrepareAuthKey", "soter: has not generate app secure key yet and not require to generate it", new Object[0]);
      c(new com.tencent.soter.a.b.c(3));
      AppMethodBeat.o(123);
      return true;
    }
    if ((com.tencent.soter.core.a.bqh(this.RQC)) && (!com.tencent.soter.core.a.bqi(this.RQC)))
    {
      d.w("Soter.TaskPrepareAuthKey", "soter: already has auth key but not valid. delete it already and re-generate", new Object[0]);
      AppMethodBeat.o(123);
      return false;
    }
    if ((com.tencent.soter.core.a.bqh(this.RQC)) && (!this.RRQ))
    {
      d.i("Soter.TaskPrepareAuthKey", "soter: already has key. do not need generate again", new Object[0]);
      c(new com.tencent.soter.a.b.c(com.tencent.soter.core.a.bqj(this.RQC)));
      AppMethodBeat.o(123);
      return true;
    }
    if (this.FhP == null) {
      d.w("Soter.TaskPrepareAuthKey", "soter: it is strongly recommended that you provide a net wrapper to check and upload AuthKey validation from server! Please make sure you upload it later", new Object[0]);
    }
    AppMethodBeat.o(123);
    return false;
  }
  
  final void hlN()
  {
    AppMethodBeat.i(124);
    d.w("Soter.TaskPrepareAuthKey", "soter: cancelled prepare authkey: %s", new Object[] { this.RQC });
    com.tencent.soter.core.a.dE(this.RQC, false);
    AppMethodBeat.o(124);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.soter.a.g.l
 * JD-Core Version:    0.7.0.1
 */
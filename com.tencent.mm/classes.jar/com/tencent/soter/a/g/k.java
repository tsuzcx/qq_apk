package com.tencent.soter.a.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.a.e.b.a;
import com.tencent.soter.a.f.e.a;
import com.tencent.soter.a.f.e.b;
import com.tencent.soter.core.c.d;
import com.tencent.soter.core.c.i;

public final class k
  extends c
{
  com.tencent.soter.a.f.e IwR = null;
  private boolean IwS = false;
  
  public k(com.tencent.soter.a.f.e parame, boolean paramBoolean)
  {
    this.IwR = parame;
    this.IwS = paramBoolean;
  }
  
  final void execute()
  {
    AppMethodBeat.i(118);
    gs(com.tencent.soter.core.c.e.fna().IuM, 1);
    b.a locala = new b.a();
    boolean bool = this.IwS;
    locala.IvC |= 0x1;
    locala.IvE = bool;
    locala.IvG = new com.tencent.soter.a.e.a()
    {
      public final void onError(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(113);
        d.w("Soter.TaskPrepareAppSecureKey", "soter: app secure key generate failed. errcode: %d, errmsg: %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        k.gs(com.tencent.soter.core.c.e.fna().IuM, 0);
        k.this.c(new com.tencent.soter.a.b.c(paramAnonymousInt, paramAnonymousString));
        AppMethodBeat.o(113);
      }
      
      public final void onSuccess()
      {
        AppMethodBeat.i(114);
        d.i("Soter.TaskPrepareAppSecureKey", "soter: app secure key generate successfully. start upload ask", new Object[0]);
        if (k.this.IwR != null) {
          k.gs(com.tencent.soter.core.c.e.fna().IuM, 2);
        }
        k localk;
        i locali;
        for (;;)
        {
          localk = k.this;
          locali = com.tencent.soter.core.a.fmW();
          if (locali != null) {
            break;
          }
          d.e("Soter.TaskPrepareAppSecureKey", "soter: ask model is null even after generation. fatal error", new Object[0]);
          com.tencent.soter.core.a.fmT();
          localk.c(new com.tencent.soter.a.b.c(3, "ask model is null even after generation."));
          AppMethodBeat.o(114);
          return;
          k.gs(com.tencent.soter.core.c.e.fna().IuM, 0);
        }
        if (localk.IwR != null)
        {
          localk.IwR.cY(new e.a(locali.signature, locali.IuR));
          localk.IwR.a(new k.2(localk, locali));
          localk.IwR.execute();
          AppMethodBeat.o(114);
          return;
        }
        d.d("Soter.TaskPrepareAppSecureKey", "soter: not provide network wrapper instance. please check if it is what you want. we treat it as normal", new Object[0]);
        localk.c(new com.tencent.soter.a.b.c("treat as normal because you do not provide the net wrapper", locali));
        AppMethodBeat.o(114);
      }
    };
    locala.fns().gB();
    AppMethodBeat.o(118);
  }
  
  final boolean fnu()
  {
    AppMethodBeat.i(116);
    if (!com.tencent.soter.a.c.b.fno().isInit())
    {
      d.w("Soter.TaskPrepareAppSecureKey", "soter: not initialized yet", new Object[0]);
      c(new com.tencent.soter.a.b.c(1008));
      AppMethodBeat.o(116);
      return true;
    }
    if (!com.tencent.soter.a.c.b.fno().fnk())
    {
      d.w("Soter.TaskPrepareAppSecureKey", "soter: not support soter", new Object[0]);
      c(new com.tencent.soter.a.b.c(2));
      AppMethodBeat.o(116);
      return true;
    }
    if ((com.tencent.soter.core.a.fmV()) && (!this.IwS))
    {
      d.i("Soter.TaskPrepareAppSecureKey", "soter: already has ask. do not need generate again", new Object[0]);
      c(new com.tencent.soter.a.b.c(com.tencent.soter.core.a.fmW()));
      AppMethodBeat.o(116);
      return true;
    }
    if (this.IwR == null) {
      d.w("Soter.TaskPrepareAppSecureKey", "soter: it is strongly recommended that you provide a net wrapper to check and upload ASK validation from server! Please make sure you upload it later", new Object[0]);
    }
    AppMethodBeat.o(116);
    return false;
  }
  
  final void fnv()
  {
    AppMethodBeat.i(117);
    d.w("Soter.TaskPrepareAppSecureKey", "soter: cancelled prepare ask", new Object[0]);
    com.tencent.soter.core.a.fmT();
    AppMethodBeat.o(117);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.soter.a.g.k
 * JD-Core Version:    0.7.0.1
 */
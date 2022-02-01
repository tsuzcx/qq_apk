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
  com.tencent.soter.a.f.e ahzm = null;
  private boolean ahzn = false;
  
  public k(com.tencent.soter.a.f.e parame, boolean paramBoolean)
  {
    this.ahzm = parame;
    this.ahzn = paramBoolean;
  }
  
  final void execute()
  {
    AppMethodBeat.i(118);
    jt(com.tencent.soter.core.c.e.jYf().ahxe, 1);
    b.a locala = new b.a();
    boolean bool = this.ahzn;
    locala.ahxT |= 0x1;
    locala.ahxV = bool;
    locala.ahxX = new com.tencent.soter.a.e.a()
    {
      public final void onError(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(113);
        d.w("Soter.TaskPrepareAppSecureKey", "soter: app secure key generate failed. errcode: %d, errmsg: %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousString });
        k.jt(com.tencent.soter.core.c.e.jYf().ahxe, 0);
        k.this.c(new com.tencent.soter.a.b.c(paramAnonymousInt, paramAnonymousString));
        AppMethodBeat.o(113);
      }
      
      public final void onSuccess()
      {
        AppMethodBeat.i(114);
        d.i("Soter.TaskPrepareAppSecureKey", "soter: app secure key generate successfully. start upload ask", new Object[0]);
        if (k.this.ahzm != null) {
          k.jt(com.tencent.soter.core.c.e.jYf().ahxe, 2);
        }
        k localk;
        i locali;
        for (;;)
        {
          localk = k.this;
          locali = com.tencent.soter.core.a.jYa();
          if (locali != null) {
            break;
          }
          d.e("Soter.TaskPrepareAppSecureKey", "soter: ask model is null even after generation. fatal error", new Object[0]);
          com.tencent.soter.core.a.jXX();
          localk.c(new com.tencent.soter.a.b.c(3, "ask model is null even after generation."));
          AppMethodBeat.o(114);
          return;
          k.jt(com.tencent.soter.core.c.e.jYf().ahxe, 0);
        }
        if (localk.ahzm != null)
        {
          localk.ahzm.setRequest(new e.a(locali.signature, locali.ahxj));
          localk.ahzm.a(new k.2(localk, locali));
          localk.ahzm.execute();
          AppMethodBeat.o(114);
          return;
        }
        d.d("Soter.TaskPrepareAppSecureKey", "soter: not provide network wrapper instance. please check if it is what you want. we treat it as normal", new Object[0]);
        localk.c(new com.tencent.soter.a.b.c("treat as normal because you do not provide the net wrapper", locali));
        AppMethodBeat.o(114);
      }
    };
    locala.jYx().Iz();
    AppMethodBeat.o(118);
  }
  
  final boolean jYA()
  {
    AppMethodBeat.i(116);
    if (!com.tencent.soter.a.c.b.jYt().isInit())
    {
      d.w("Soter.TaskPrepareAppSecureKey", "soter: not initialized yet", new Object[0]);
      c(new com.tencent.soter.a.b.c(1008));
      AppMethodBeat.o(116);
      return true;
    }
    if (!com.tencent.soter.a.c.b.jYt().jYp())
    {
      d.w("Soter.TaskPrepareAppSecureKey", "soter: not support soter", new Object[0]);
      c(new com.tencent.soter.a.b.c(2));
      AppMethodBeat.o(116);
      return true;
    }
    if ((com.tencent.soter.core.a.jXZ()) && (!this.ahzn))
    {
      d.i("Soter.TaskPrepareAppSecureKey", "soter: already has ask. do not need generate again", new Object[0]);
      c(new com.tencent.soter.a.b.c(com.tencent.soter.core.a.jYa()));
      AppMethodBeat.o(116);
      return true;
    }
    if (this.ahzm == null) {
      d.w("Soter.TaskPrepareAppSecureKey", "soter: it is strongly recommended that you provide a net wrapper to check and upload ASK validation from server! Please make sure you upload it later", new Object[0]);
    }
    AppMethodBeat.o(116);
    return false;
  }
  
  final boolean jYB()
  {
    return true;
  }
  
  final void jYC()
  {
    AppMethodBeat.i(117);
    d.w("Soter.TaskPrepareAppSecureKey", "soter: cancelled prepare ask", new Object[0]);
    com.tencent.soter.core.a.jXX();
    AppMethodBeat.o(117);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.soter.a.g.k
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.ui.chatting.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.chatting.d.ad;
import java.util.HashMap;

public final class a
{
  public HashMap<Class<? extends ad>, ad> KrM;
  private com.tencent.mm.ui.chatting.e.a cXJ;
  
  public a(com.tencent.mm.ui.chatting.e.a parama)
  {
    AppMethodBeat.i(36433);
    this.KrM = new HashMap();
    this.cXJ = parama;
    AppMethodBeat.o(36433);
  }
  
  public final void a(Class<? extends ad> paramClass, ad paramad)
  {
    AppMethodBeat.i(36435);
    if (this.KrM.put(paramClass, paramad) != null) {
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.ChattingComponentManager", "[register] %s has register", new Object[] { paramClass });
    }
    if ((paramad instanceof com.tencent.mm.ui.chatting.d.ae))
    {
      long l1 = System.currentTimeMillis();
      ((com.tencent.mm.ui.chatting.d.ae)paramad).a(this.cXJ);
      long l2 = System.currentTimeMillis();
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.ChattingComponentManager", "[install] listener:%s cost:%sms", new Object[] { paramad.getClass().getName(), Long.valueOf(l2 - l1) });
    }
    AppMethodBeat.o(36435);
  }
  
  public final <T extends ad, V extends Class<T>> T bh(V paramV)
  {
    AppMethodBeat.i(36434);
    if (!paramV.isInterface())
    {
      paramV = new RuntimeException("[get] " + paramV + " is not a interface!");
      AppMethodBeat.o(36434);
      throw paramV;
    }
    if (this.KrM.containsKey(paramV))
    {
      paramV = (ad)this.KrM.get(paramV);
      AppMethodBeat.o(36434);
      return paramV;
    }
    AppMethodBeat.o(36434);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.i.a
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.ui.chatting.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.chatting.d.ae;
import java.util.HashMap;

public final class a
{
  public HashMap<Class<? extends com.tencent.mm.ui.chatting.d.ad>, com.tencent.mm.ui.chatting.d.ad> JVu;
  private com.tencent.mm.ui.chatting.e.a cWM;
  
  public a(com.tencent.mm.ui.chatting.e.a parama)
  {
    AppMethodBeat.i(36433);
    this.JVu = new HashMap();
    this.cWM = parama;
    AppMethodBeat.o(36433);
  }
  
  public final void a(Class<? extends com.tencent.mm.ui.chatting.d.ad> paramClass, com.tencent.mm.ui.chatting.d.ad paramad)
  {
    AppMethodBeat.i(36435);
    if (this.JVu.put(paramClass, paramad) != null) {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.ChattingComponentManager", "[register] %s has register", new Object[] { paramClass });
    }
    if ((paramad instanceof ae))
    {
      long l1 = System.currentTimeMillis();
      ((ae)paramad).a(this.cWM);
      long l2 = System.currentTimeMillis();
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ChattingComponentManager", "[install] listener:%s cost:%sms", new Object[] { paramad.getClass().getName(), Long.valueOf(l2 - l1) });
    }
    AppMethodBeat.o(36435);
  }
  
  public final <T extends com.tencent.mm.ui.chatting.d.ad, V extends Class<T>> T bh(V paramV)
  {
    AppMethodBeat.i(36434);
    if (!paramV.isInterface())
    {
      paramV = new RuntimeException("[get] " + paramV + " is not a interface!");
      AppMethodBeat.o(36434);
      throw paramV;
    }
    if (this.JVu.containsKey(paramV))
    {
      paramV = (com.tencent.mm.ui.chatting.d.ad)this.JVu.get(paramV);
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
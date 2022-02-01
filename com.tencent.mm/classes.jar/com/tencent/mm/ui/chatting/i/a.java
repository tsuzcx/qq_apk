package com.tencent.mm.ui.chatting.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.chatting.d.af;
import com.tencent.mm.ui.chatting.d.ag;
import java.util.HashMap;

public final class a
{
  public HashMap<Class<? extends af>, af> PDU;
  private com.tencent.mm.ui.chatting.e.a dom;
  
  public a(com.tencent.mm.ui.chatting.e.a parama)
  {
    AppMethodBeat.i(36433);
    this.PDU = new HashMap();
    this.dom = parama;
    AppMethodBeat.o(36433);
  }
  
  public final void a(Class<? extends af> paramClass, af paramaf)
  {
    AppMethodBeat.i(36435);
    if (this.PDU.put(paramClass, paramaf) != null) {
      Log.w("MicroMsg.ChattingComponentManager", "[register] %s has register", new Object[] { paramClass });
    }
    if ((paramaf instanceof ag))
    {
      long l1 = System.currentTimeMillis();
      ((ag)paramaf).a(this.dom);
      long l2 = System.currentTimeMillis();
      Log.i("MicroMsg.ChattingComponentManager", "[install] listener:%s cost:%sms", new Object[] { paramaf.getClass().getName(), Long.valueOf(l2 - l1) });
    }
    AppMethodBeat.o(36435);
  }
  
  public final <T extends af, V extends Class<T>> T bh(V paramV)
  {
    AppMethodBeat.i(36434);
    if (!paramV.isInterface())
    {
      paramV = new RuntimeException("[get] " + paramV + " is not a interface!");
      AppMethodBeat.o(36434);
      throw paramV;
    }
    if (this.PDU.containsKey(paramV))
    {
      paramV = (af)this.PDU.get(paramV);
      AppMethodBeat.o(36434);
      return paramV;
    }
    AppMethodBeat.o(36434);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.i.a
 * JD-Core Version:    0.7.0.1
 */
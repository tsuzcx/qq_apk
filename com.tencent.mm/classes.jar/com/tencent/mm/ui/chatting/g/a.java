package com.tencent.mm.ui.chatting.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.chatting.component.aj;
import com.tencent.mm.ui.chatting.component.ak;
import java.util.HashMap;

public final class a
{
  public HashMap<Class<? extends aj>, aj> aeIh;
  private com.tencent.mm.ui.chatting.d.a hlc;
  
  public a(com.tencent.mm.ui.chatting.d.a parama)
  {
    AppMethodBeat.i(36433);
    this.aeIh = new HashMap();
    this.hlc = parama;
    AppMethodBeat.o(36433);
  }
  
  public final void a(Class<? extends aj> paramClass, aj paramaj)
  {
    AppMethodBeat.i(36435);
    if (this.aeIh.put(paramClass, paramaj) != null) {
      Log.w("MicroMsg.ChattingComponentManager", "[register] %s has register", new Object[] { paramClass });
    }
    if ((paramaj instanceof ak))
    {
      long l1 = System.currentTimeMillis();
      ((ak)paramaj).a(this.hlc);
      long l2 = System.currentTimeMillis();
      Log.i("MicroMsg.ChattingComponentManager", "[install] listener:%s cost:%sms", new Object[] { paramaj.getClass().getName(), Long.valueOf(l2 - l1) });
    }
    AppMethodBeat.o(36435);
  }
  
  public final <T extends aj, V extends Class<T>> T cm(V paramV)
  {
    AppMethodBeat.i(36434);
    if (!paramV.isInterface())
    {
      paramV = new RuntimeException("[get] " + paramV + " is not a interface!");
      AppMethodBeat.o(36434);
      throw paramV;
    }
    if (this.aeIh.containsKey(paramV))
    {
      paramV = (aj)this.aeIh.get(paramV);
      AppMethodBeat.o(36434);
      return paramV;
    }
    AppMethodBeat.o(36434);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.g.a
 * JD-Core Version:    0.7.0.1
 */
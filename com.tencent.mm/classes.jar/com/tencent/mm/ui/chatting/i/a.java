package com.tencent.mm.ui.chatting.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.chatting.d.ag;
import com.tencent.mm.ui.chatting.d.ah;
import java.util.HashMap;

public final class a
{
  public HashMap<Class<? extends ag>, ag> WYH;
  private com.tencent.mm.ui.chatting.e.a fgR;
  
  public a(com.tencent.mm.ui.chatting.e.a parama)
  {
    AppMethodBeat.i(36433);
    this.WYH = new HashMap();
    this.fgR = parama;
    AppMethodBeat.o(36433);
  }
  
  public final void a(Class<? extends ag> paramClass, ag paramag)
  {
    AppMethodBeat.i(36435);
    if (this.WYH.put(paramClass, paramag) != null) {
      Log.w("MicroMsg.ChattingComponentManager", "[register] %s has register", new Object[] { paramClass });
    }
    if ((paramag instanceof ah))
    {
      long l1 = System.currentTimeMillis();
      ((ah)paramag).a(this.fgR);
      long l2 = System.currentTimeMillis();
      Log.i("MicroMsg.ChattingComponentManager", "[install] listener:%s cost:%sms", new Object[] { paramag.getClass().getName(), Long.valueOf(l2 - l1) });
    }
    AppMethodBeat.o(36435);
  }
  
  public final <T extends ag, V extends Class<T>> T bC(V paramV)
  {
    AppMethodBeat.i(36434);
    if (!paramV.isInterface())
    {
      paramV = new RuntimeException("[get] " + paramV + " is not a interface!");
      AppMethodBeat.o(36434);
      throw paramV;
    }
    if (this.WYH.containsKey(paramV))
    {
      paramV = (ag)this.WYH.get(paramV);
      AppMethodBeat.o(36434);
      return paramV;
    }
    AppMethodBeat.o(36434);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.i.a
 * JD-Core Version:    0.7.0.1
 */
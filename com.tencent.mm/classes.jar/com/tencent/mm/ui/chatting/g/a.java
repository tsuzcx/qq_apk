package com.tencent.mm.ui.chatting.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.chatting.c.v;
import com.tencent.mm.ui.chatting.c.w;
import java.util.HashMap;

public final class a
{
  private com.tencent.mm.ui.chatting.d.a caz;
  public HashMap<Class<?>, v> zOP;
  
  public a(com.tencent.mm.ui.chatting.d.a parama)
  {
    AppMethodBeat.i(32492);
    this.zOP = new HashMap();
    this.caz = parama;
    AppMethodBeat.o(32492);
  }
  
  public final void a(Class<? extends v> paramClass, v paramv)
  {
    AppMethodBeat.i(32494);
    if (this.zOP.put(paramClass, paramv) != null) {
      ab.w("MicroMsg.ChattingComponentManager", "[register] %s has register", new Object[] { paramClass });
    }
    if ((paramv instanceof w))
    {
      long l1 = System.currentTimeMillis();
      ((w)paramv).a(this.caz);
      long l2 = System.currentTimeMillis();
      ab.i("MicroMsg.ChattingComponentManager", "[install] listener:%s cost:%sms", new Object[] { paramv.getClass().getName(), Long.valueOf(l2 - l1) });
    }
    AppMethodBeat.o(32494);
  }
  
  public final <T extends v, V extends Class<T>> T ay(V paramV)
  {
    AppMethodBeat.i(32493);
    if (!paramV.isInterface())
    {
      paramV = new RuntimeException("[get] " + paramV + " is not a interface!");
      AppMethodBeat.o(32493);
      throw paramV;
    }
    if (this.zOP.containsKey(paramV))
    {
      paramV = (v)this.zOP.get(paramV);
      AppMethodBeat.o(32493);
      return paramV;
    }
    AppMethodBeat.o(32493);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.g.a
 * JD-Core Version:    0.7.0.1
 */
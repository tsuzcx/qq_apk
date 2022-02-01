package com.tencent.mm.ui.chatting.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.chatting.c.ab;
import com.tencent.mm.ui.chatting.c.ac;
import java.util.HashMap;

public final class a
{
  public HashMap<Class<? extends ab>, ab> GFl;
  private com.tencent.mm.ui.chatting.d.a cOd;
  
  public a(com.tencent.mm.ui.chatting.d.a parama)
  {
    AppMethodBeat.i(36433);
    this.GFl = new HashMap();
    this.cOd = parama;
    AppMethodBeat.o(36433);
  }
  
  public final void a(Class<? extends ab> paramClass, ab paramab)
  {
    AppMethodBeat.i(36435);
    if (this.GFl.put(paramClass, paramab) != null) {
      ad.w("MicroMsg.ChattingComponentManager", "[register] %s has register", new Object[] { paramClass });
    }
    if ((paramab instanceof ac))
    {
      long l1 = System.currentTimeMillis();
      ((ac)paramab).a(this.cOd);
      long l2 = System.currentTimeMillis();
      ad.i("MicroMsg.ChattingComponentManager", "[install] listener:%s cost:%sms", new Object[] { paramab.getClass().getName(), Long.valueOf(l2 - l1) });
    }
    AppMethodBeat.o(36435);
  }
  
  public final <T extends ab, V extends Class<T>> T be(V paramV)
  {
    AppMethodBeat.i(36434);
    if (!paramV.isInterface())
    {
      paramV = new RuntimeException("[get] " + paramV + " is not a interface!");
      AppMethodBeat.o(36434);
      throw paramV;
    }
    if (this.GFl.containsKey(paramV))
    {
      paramV = (ab)this.GFl.get(paramV);
      AppMethodBeat.o(36434);
      return paramV;
    }
    AppMethodBeat.o(36434);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.h.a
 * JD-Core Version:    0.7.0.1
 */
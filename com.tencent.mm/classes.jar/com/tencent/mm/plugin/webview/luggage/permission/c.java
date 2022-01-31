package com.tencent.mm.plugin.webview.luggage.permission;

import com.tencent.luggage.d.a.a;
import com.tencent.luggage.d.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.e;
import com.tencent.mm.protocal.c.g;
import java.util.HashSet;
import java.util.Set;

public final class c
  implements a
{
  private LuggageGetA8Key uRC;
  private e uSb;
  private Set<String> uUU;
  
  public c(e parame, LuggageGetA8Key paramLuggageGetA8Key)
  {
    AppMethodBeat.i(6490);
    this.uUU = new HashSet();
    this.uSb = parame;
    this.uRC = paramLuggageGetA8Key;
    AppMethodBeat.o(6490);
  }
  
  public final void a(com.tencent.luggage.d.a.c paramc)
  {
    AppMethodBeat.i(6492);
    paramc.a(b.bzB);
    AppMethodBeat.o(6492);
  }
  
  public final void a(String paramString, com.tencent.luggage.d.a.c paramc)
  {
    AppMethodBeat.i(6493);
    if (this.uUU.contains(paramString))
    {
      this.uUU.remove(paramString);
      paramc.a(b.bzB);
      AppMethodBeat.o(6493);
      return;
    }
    LuggageGetA8Key localLuggageGetA8Key = this.uRC;
    String str = this.uSb.getUrl();
    paramString = com.tencent.mm.protocal.c.anm(paramString);
    int i;
    if (paramString == null)
    {
      i = -1;
      if (!localLuggageGetA8Key.dN(str, i)) {
        break label109;
      }
    }
    label109:
    for (paramString = b.bzB;; paramString = b.bzC)
    {
      paramc.a(paramString);
      AppMethodBeat.o(6493);
      return;
      i = paramString.dqm();
      break;
    }
  }
  
  public final void agX(String paramString)
  {
    AppMethodBeat.i(6491);
    this.uUU.add(paramString);
    AppMethodBeat.o(6491);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.permission.c
 * JD-Core Version:    0.7.0.1
 */
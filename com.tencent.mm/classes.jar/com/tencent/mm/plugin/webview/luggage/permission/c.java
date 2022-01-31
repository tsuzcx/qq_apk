package com.tencent.mm.plugin.webview.luggage.permission;

import com.tencent.luggage.e.a.a;
import com.tencent.luggage.e.a.b;
import com.tencent.mm.plugin.webview.luggage.e;
import com.tencent.mm.protocal.c.g;
import java.util.HashSet;
import java.util.Set;

public final class c
  implements a
{
  private LuggageGetA8Key rbR;
  private e rcp;
  private Set<String> reM = new HashSet();
  
  public c(e parame, LuggageGetA8Key paramLuggageGetA8Key)
  {
    this.rcp = parame;
    this.rbR = paramLuggageGetA8Key;
  }
  
  public final void RS(String paramString)
  {
    this.reM.add(paramString);
  }
  
  public final void a(com.tencent.luggage.e.a.c paramc)
  {
    paramc.a(b.bjc);
  }
  
  public final void a(String paramString, com.tencent.luggage.e.a.c paramc)
  {
    if (this.reM.contains(paramString))
    {
      this.reM.remove(paramString);
      paramc.a(b.bjc);
      return;
    }
    LuggageGetA8Key localLuggageGetA8Key = this.rbR;
    String str = this.rcp.getUrl();
    paramString = com.tencent.mm.protocal.c.Xq(paramString);
    int i;
    if (paramString == null)
    {
      i = -1;
      if (!localLuggageGetA8Key.cO(str, i)) {
        break label91;
      }
    }
    label91:
    for (paramString = b.bjc;; paramString = b.bjd)
    {
      paramc.a(paramString);
      return;
      i = paramString.coP();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.luggage.permission.c
 * JD-Core Version:    0.7.0.1
 */
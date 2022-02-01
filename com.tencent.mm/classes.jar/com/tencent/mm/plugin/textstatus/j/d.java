package com.tencent.mm.plugin.textstatus.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.a.i;
import com.tencent.mm.plugin.textstatus.a.m;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/third/StatusThirdShareManager;", "", "()V", "TAG", "", "services", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/textstatus/api/IStatusThirdShareService;", "Lkotlin/collections/HashMap;", "contains", "", "jumpType", "get", "getCustomParts", "Lcom/tencent/mm/plugin/textstatus/api/IStatusCustomParts;", "getMixCustomParts", "Lcom/tencent/mm/plugin/textstatus/api/IMixStatusCustomParts;", "register", "", "service", "unregister", "plugin-textstatus_release"})
public final class d
{
  public static final HashMap<String, m> MIV;
  public static final d MIW;
  
  static
  {
    AppMethodBeat.i(234772);
    MIW = new d();
    MIV = new HashMap();
    AppMethodBeat.o(234772);
  }
  
  public static void b(String paramString, m paramm)
  {
    AppMethodBeat.i(234764);
    p.k(paramString, "jumpType");
    p.k(paramm, "service");
    ((Map)MIV).put(paramString, paramm);
    AppMethodBeat.o(234764);
  }
  
  public static m beD(String paramString)
  {
    AppMethodBeat.i(234765);
    paramString = (m)MIV.get(paramString);
    AppMethodBeat.o(234765);
    return paramString;
  }
  
  public static i beE(String paramString)
  {
    localObject = null;
    AppMethodBeat.i(234768);
    try
    {
      m localm = beD(paramString);
      paramString = localObject;
      if (localm != null) {
        paramString = localm.dDF();
      }
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.TextStatus.StatusThirdShareManager", paramString, "customps err", new Object[0]);
        paramString = localObject;
      }
    }
    AppMethodBeat.o(234768);
    return paramString;
  }
  
  public static boolean contains(String paramString)
  {
    AppMethodBeat.i(234767);
    if (MIV.get(paramString) != null)
    {
      AppMethodBeat.o(234767);
      return true;
    }
    AppMethodBeat.o(234767);
    return false;
  }
  
  public static com.tencent.mm.plugin.textstatus.a.c gmo()
  {
    AppMethodBeat.i(234770);
    com.tencent.mm.plugin.textstatus.a.c localc = (com.tencent.mm.plugin.textstatus.a.c)new c();
    AppMethodBeat.o(234770);
    return localc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.j.d
 * JD-Core Version:    0.7.0.1
 */
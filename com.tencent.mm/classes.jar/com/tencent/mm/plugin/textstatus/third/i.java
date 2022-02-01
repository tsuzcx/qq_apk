package com.tencent.mm.plugin.textstatus.third;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.a.d;
import com.tencent.mm.plugin.textstatus.a.e;
import com.tencent.mm.plugin.textstatus.a.k;
import com.tencent.mm.plugin.textstatus.a.o;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/third/StatusThirdShareManager;", "", "()V", "TAG", "", "services", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/textstatus/api/IStatusThirdShareService;", "Lkotlin/collections/HashMap;", "contains", "", "jumpType", "get", "getCustomParts", "Lcom/tencent/mm/plugin/textstatus/api/IStatusCustomParts;", "getMixCustomElements", "Lcom/tencent/mm/plugin/textstatus/api/IMixStatusCustomElements;", "getMixCustomParts", "Lcom/tencent/mm/plugin/textstatus/api/IMixStatusCustomParts;", "register", "", "service", "unregister", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
{
  public static final i TuX;
  public static final HashMap<String, o> TuY;
  
  static
  {
    AppMethodBeat.i(290186);
    TuX = new i();
    TuY = new HashMap();
    AppMethodBeat.o(290186);
  }
  
  public static void b(String paramString, o paramo)
  {
    AppMethodBeat.i(290140);
    s.u(paramString, "jumpType");
    s.u(paramo, "service");
    ((Map)TuY).put(paramString, paramo);
    AppMethodBeat.o(290140);
  }
  
  public static o bec(String paramString)
  {
    AppMethodBeat.i(290147);
    paramString = (o)TuY.get(paramString);
    AppMethodBeat.o(290147);
    return paramString;
  }
  
  public static k bed(String paramString)
  {
    localObject = null;
    AppMethodBeat.i(290164);
    for (;;)
    {
      try
      {
        localo = bec(paramString);
        if (localo != null) {
          continue;
        }
        paramString = localObject;
      }
      finally
      {
        o localo;
        Log.printErrStackTrace("MicroMsg.TextStatus.StatusThirdShareManager", paramString, "customps err", new Object[0]);
        paramString = localObject;
        continue;
      }
      AppMethodBeat.o(290164);
      return paramString;
      paramString = localo.axF(paramString);
    }
  }
  
  public static boolean contains(String paramString)
  {
    AppMethodBeat.i(290153);
    if (TuY.get(paramString) != null)
    {
      AppMethodBeat.o(290153);
      return true;
    }
    AppMethodBeat.o(290153);
    return false;
  }
  
  public static e hIb()
  {
    AppMethodBeat.i(290174);
    e locale = (e)new g();
    AppMethodBeat.o(290174);
    return locale;
  }
  
  public static d hIc()
  {
    AppMethodBeat.i(290179);
    d locald = (d)new f();
    AppMethodBeat.o(290179);
    return locald;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.third.i
 * JD-Core Version:    0.7.0.1
 */
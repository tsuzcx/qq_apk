package com.tencent.mm.plugin.textstatus.i;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.g.r;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/third/ThirdSpeciaViewManger;", "", "()V", "TAG", "", "singletons", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/textstatus/third/ISpecialViewSingleton;", "Lkotlin/collections/HashMap;", "getView", "Landroid/view/View;", "sourceId", "jumpInfo", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;", "getViewAndRefresh", "callback", "Lkotlin/Function0;", "", "release", "plugin-textstatus_release"})
public final class d
{
  private static final HashMap<String, b> FYa;
  public static final d Gcq;
  
  static
  {
    AppMethodBeat.i(216343);
    Gcq = new d();
    HashMap localHashMap = new HashMap();
    FYa = localHashMap;
    ((Map)localHashMap).put("demo@inner", new a());
    ((Map)FYa).put("live_player@inner", new c());
    AppMethodBeat.o(216343);
  }
  
  public static View a(String paramString, r paramr)
  {
    AppMethodBeat.i(216340);
    p.h(paramString, "sourceId");
    p.h(paramr, "jumpInfo");
    paramString = (b)FYa.get(paramString);
    if (paramString != null) {}
    for (paramString = paramString.a(paramr);; paramString = null)
    {
      AppMethodBeat.o(216340);
      return paramString;
    }
  }
  
  public static View a(String paramString, r paramr, kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(216341);
    p.h(paramString, "sourceId");
    p.h(paramr, "jumpInfo");
    p.h(parama, "callback");
    paramString = (b)FYa.get(paramString);
    if (paramString != null) {}
    for (paramString = paramString.a(paramr, parama);; paramString = null)
    {
      AppMethodBeat.o(216341);
      return paramString;
    }
  }
  
  public static void b(String paramString, r paramr)
  {
    AppMethodBeat.i(216342);
    p.h(paramString, "sourceId");
    p.h(paramr, "jumpInfo");
    paramString = (b)FYa.get(paramString);
    if (paramString != null)
    {
      paramString.b(paramr);
      AppMethodBeat.o(216342);
      return;
    }
    AppMethodBeat.o(216342);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.i.d
 * JD-Core Version:    0.7.0.1
 */
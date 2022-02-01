package com.tencent.mm.plugin.textstatus.c;

import android.content.Intent;
import com.tencent.e.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.textstatus.g.r;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/jump/TextStatusJumpManager;", "", "()V", "TAG", "", "singletons", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/textstatus/jump/ITextStatusJumpSingleton;", "Lkotlin/collections/HashMap;", "doJump", "", "sourceId", "textStatusID", "jumpInfos", "", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;", "plugin-textstatus_release"})
public final class e
{
  private static final HashMap<String, b> FYa;
  public static final e FYb;
  
  static
  {
    AppMethodBeat.i(216129);
    FYb = new e();
    HashMap localHashMap = new HashMap();
    FYa = localHashMap;
    ((Map)localHashMap).put("demo@inner", new a());
    ((Map)FYa).put("music_player@inner", new d());
    ((Map)FYa).put("live_player@inner", new c());
    AppMethodBeat.o(216129);
  }
  
  public static boolean h(String paramString1, String paramString2, List<? extends r> paramList)
  {
    AppMethodBeat.i(258412);
    p.h(paramString1, "sourceId");
    p.h(paramString2, "textStatusID");
    p.h(paramList, "jumpInfos");
    boolean bool = false;
    Object localObject = (b)FYa.get(paramString1);
    if (localObject != null) {
      bool = ((b)localObject).F(paramString2, paramList);
    }
    if (!bool)
    {
      paramList = ((Iterable)paramList).iterator();
      while (paramList.hasNext())
      {
        paramString2 = (r)paramList.next();
        localObject = paramString2.GaO;
        if (localObject != null) {
          switch (((String)localObject).hashCode())
          {
          default: 
            break;
          case 51: 
            if (((String)localObject).equals("3"))
            {
              new StringBuilder("sourceId:").append(paramString1).append(", jump to h5");
              h.hkS();
              paramString1 = new Intent();
              paramString1.putExtra("rawUrl", paramString2.GaQ);
              com.tencent.mm.br.c.b(MMApplicationContext.getContext(), "webview", ".ui.tools.WebViewUI", paramString1);
              bool = true;
            }
            break;
          }
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(258412);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.c.e
 * JD-Core Version:    0.7.0.1
 */
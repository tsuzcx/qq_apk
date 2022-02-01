package com.tencent.mm.plugin.websearch.a;

import android.content.Context;
import android.view.Window;
import androidx.appcompat.app.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.websearch.a.a.a;
import com.tencent.mm.protocal.protobuf.amr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/websearch/emojisearch/EmojiSearchServiceImpl;", "Lcom/tencent/mm/emojisearch/ui/IEmojiSearchService;", "()V", "genSearchRequestId", "", "genSearchSessionId", "startEmojiSearchDialog", "Landroidx/appcompat/app/AppCompatDialog;", "context", "Landroid/content/Context;", "talker", "toSendText", "listener", "Lcom/tencent/mm/emojisearch/ui/IEmojiSearchDialogListener;", "sessionId", "ui-websearch_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements com.tencent.mm.emojisearch.ui.c
{
  public final e a(Context paramContext, String paramString1, String paramString2, com.tencent.mm.emojisearch.ui.b paramb, String paramString3)
  {
    AppMethodBeat.i(315051);
    s.u(paramContext, "context");
    s.u(paramString1, "talker");
    s.u(paramString2, "toSendText");
    s.u(paramb, "listener");
    s.u(paramString3, "sessionId");
    Object localObject = c.WqA;
    s.u(paramContext, "context");
    s.u(paramString1, "talker");
    s.u(paramString2, "toSendText");
    s.u(paramb, "listener");
    s.u(paramString3, "sessionId");
    amr localamr = new amr();
    HashMap localHashMap = new HashMap();
    ((Map)localHashMap).put("scene", "71");
    ((Map)localHashMap).put("sessionId", paramString3);
    ((Map)localHashMap).put("subSessionId", paramString3);
    ((Map)localHashMap).put("toSendText", paramString2);
    ((Map)localHashMap).put("isHomePage", "1");
    ((Map)localHashMap).put("talker", paramString1);
    Map localMap = (Map)localHashMap;
    if (Util.isOverseasUser(paramContext)) {}
    for (localObject = "1";; localObject = "0")
    {
      localMap.put("isOverseaApp", localObject);
      c.br((Map)localHashMap);
      localamr.url = c.bq((Map)localHashMap);
      localamr.talker = paramString1;
      localamr.mps = paramString2;
      localamr.sessionId = paramString3;
      localamr.scene = 71;
      localamr.hAB = "";
      localamr.mpa = "";
      localamr.hOG = "";
      paramContext = new a(paramContext, localamr, paramb);
      paramContext.show();
      paramString1 = paramContext.getWindow();
      if (paramString1 != null) {
        paramString1.setLayout(-1, -1);
      }
      Log.i("MicroMsg.WebSearch.EmojiSearchUILogic", s.X("startEmojiSearchDialog url:", localamr.url));
      paramContext = (e)paramContext;
      AppMethodBeat.o(315051);
      return paramContext;
    }
  }
  
  public final String aWX()
  {
    AppMethodBeat.i(315036);
    String str = d.We(78);
    s.s(str, "getUnsignedMd5UInt(Const…ARCH_SCENE_CHAT_EMO_MORE)");
    AppMethodBeat.o(315036);
    return str;
  }
  
  public final String aWY()
  {
    AppMethodBeat.i(315039);
    String str = d.We(78);
    s.s(str, "getUnsignedMd5UInt(Const…ARCH_SCENE_CHAT_EMO_MORE)");
    AppMethodBeat.o(315039);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.websearch.a.b
 * JD-Core Version:    0.7.0.1
 */
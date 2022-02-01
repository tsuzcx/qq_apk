package com.tencent.mm.plugin.search.ui.a.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.api.c;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.ui.FTSConvMessageUI;
import com.tencent.mm.plugin.fts.ui.FTSConvTalkerMessageUI;
import com.tencent.mm.plugin.fts.ui.a.p;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.bs;

public final class b
  implements com.tencent.mm.plugin.fts.a.d.a.b
{
  public final boolean a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a paramVarArgs)
  {
    AppMethodBeat.i(28081);
    com.tencent.mm.plugin.fts.ui.a.m localm = (com.tencent.mm.plugin.fts.ui.a.m)paramVarArgs;
    if (localm.sEN < 2) {
      if (f.AR(localm.username))
      {
        paramVarArgs = new Intent().putExtra("Contact_User", localm.username);
        com.tencent.mm.plugin.search.a.iyx.c(paramVarArgs, paramContext);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(28081);
      return true;
      if (f.so(localm.username))
      {
        paramVarArgs = new Intent();
        paramVarArgs.putExtra("Contact_User", localm.username);
        paramVarArgs.addFlags(67108864);
        paramVarArgs.putExtra("biz_chat_from_scene", 5);
        d.e(paramContext, ".ui.bizchat.BizChatConversationUI", paramVarArgs);
      }
      else
      {
        Object localObject;
        if (f.AS(localm.username))
        {
          paramVarArgs = f.dX(localm.username);
          if (paramVarArgs == null) {}
          for (paramVarArgs = null;; paramVarArgs = paramVarArgs.IR())
          {
            localObject = paramVarArgs;
            if (paramVarArgs == null) {
              localObject = "";
            }
            paramVarArgs = new Intent();
            paramVarArgs.putExtra("rawUrl", (String)localObject);
            paramVarArgs.putExtra("useJs", true);
            paramVarArgs.putExtra("srcUsername", localm.username);
            paramVarArgs.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
            paramVarArgs.addFlags(67108864);
            d.b(paramContext, "webview", ".ui.tools.WebViewUI", paramVarArgs);
            break;
          }
        }
        paramVarArgs = bs.S(localm.sxM.sym);
        paramVarArgs = new Intent().putExtra("Chat_User", localm.username).putExtra("finish_direct", true).putExtra("from_global_search", true).putExtra("msg_local_id", localm.jPN.syN).putExtra("highlight_keyword_list", paramVarArgs);
        com.tencent.mm.plugin.search.a.iyx.d(paramVarArgs, paramContext);
        continue;
        if (f.so(localm.username))
        {
          paramVarArgs = new Intent();
          paramVarArgs.putExtra("Contact_User", localm.username);
          paramVarArgs.addFlags(67108864);
          paramVarArgs.putExtra("biz_chat_from_scene", 5);
          d.e(paramContext, ".ui.bizchat.BizChatConversationUI", paramVarArgs);
        }
        else
        {
          if (f.AS(localm.username))
          {
            paramVarArgs = f.dX(localm.username);
            if (paramVarArgs == null) {}
            for (paramVarArgs = null;; paramVarArgs = paramVarArgs.IR())
            {
              localObject = paramVarArgs;
              if (paramVarArgs == null) {
                localObject = "";
              }
              paramVarArgs = new Intent();
              paramVarArgs.putExtra("rawUrl", (String)localObject);
              paramVarArgs.putExtra("useJs", true);
              paramVarArgs.putExtra("srcUsername", localm.username);
              paramVarArgs.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
              paramVarArgs.addFlags(67108864);
              d.b(paramContext, "webview", ".ui.tools.WebViewUI", paramVarArgs);
              break;
            }
          }
          if ((localm instanceof p))
          {
            paramVarArgs = (p)localm;
            paramVarArgs = new Intent(paramContext, FTSConvTalkerMessageUI.class).putExtra("Search_Scene", paramVarArgs.kNw).putExtra("key_talker_query", paramVarArgs.sEg.sxM.syk).putExtra("key_talker", paramVarArgs.sEg.sxG).putExtra("key_conv", paramVarArgs.username).putExtra("key_query", paramVarArgs.sxM.syk).putExtra("detail_type", paramVarArgs.cZX);
            paramVarArgs = new com.tencent.mm.hellhoundlib.b.a().ba(paramVarArgs);
            com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramVarArgs.aeD(), "com/tencent/mm/plugin/search/ui/item/handler/FTSMessageDataItemClickHandler", "onItemClick", "(Landroid/content/Context;Landroid/view/View;Lcom/tencent/mm/plugin/fts/api/ui/item/FTSDataItem;[Ljava/lang/Object;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramContext.startActivity((Intent)paramVarArgs.lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/search/ui/item/handler/FTSMessageDataItemClickHandler", "onItemClick", "(Landroid/content/Context;Landroid/view/View;Lcom/tencent/mm/plugin/fts/api/ui/item/FTSDataItem;[Ljava/lang/Object;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
          else
          {
            paramVarArgs = new Intent(paramContext, FTSConvMessageUI.class).putExtra("Search_Scene", localm.kNw).putExtra("key_conv", localm.username).putExtra("key_query", localm.sxM.syk).putExtra("key_count", localm.sEN);
            paramVarArgs = new com.tencent.mm.hellhoundlib.b.a().ba(paramVarArgs);
            com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramVarArgs.aeD(), "com/tencent/mm/plugin/search/ui/item/handler/FTSMessageDataItemClickHandler", "onItemClick", "(Landroid/content/Context;Landroid/view/View;Lcom/tencent/mm/plugin/fts/api/ui/item/FTSDataItem;[Ljava/lang/Object;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            paramContext.startActivity((Intent)paramVarArgs.lR(0));
            com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/search/ui/item/handler/FTSMessageDataItemClickHandler", "onItemClick", "(Landroid/content/Context;Landroid/view/View;Lcom/tencent/mm/plugin/fts/api/ui/item/FTSDataItem;[Ljava/lang/Object;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.search.ui.a.a.b
 * JD-Core Version:    0.7.0.1
 */
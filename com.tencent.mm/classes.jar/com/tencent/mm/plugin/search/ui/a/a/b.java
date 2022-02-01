package com.tencent.mm.plugin.search.ui.a.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.c;
import com.tencent.mm.br.d;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.ui.FTSConvMessageUI;
import com.tencent.mm.plugin.fts.ui.FTSConvTalkerMessageUI;
import com.tencent.mm.plugin.fts.ui.a.p;
import com.tencent.mm.plugin.gamelife.a.e;
import com.tencent.mm.plugin.gamelife.a.f;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;

public final class b
  implements com.tencent.mm.plugin.fts.a.d.a.b
{
  public final boolean a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a paramVarArgs)
  {
    AppMethodBeat.i(28081);
    com.tencent.mm.plugin.fts.ui.a.m localm = (com.tencent.mm.plugin.fts.ui.a.m)paramVarArgs;
    if (localm.tMw == 0)
    {
      paramVarArgs = new Intent(paramContext, FTSConvMessageUI.class).putExtra("Search_Scene", localm.lox).putExtra("key_conv", localm.username).putExtra("key_query", localm.tFe.tFC).putExtra("key_count", 1);
      paramVarArgs = new com.tencent.mm.hellhoundlib.b.a().bc(paramVarArgs);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramVarArgs.ahE(), "com/tencent/mm/plugin/search/ui/item/handler/FTSMessageDataItemClickHandler", "onItemClick", "(Landroid/content/Context;Landroid/view/View;Lcom/tencent/mm/plugin/fts/api/ui/item/FTSDataItem;[Ljava/lang/Object;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramVarArgs.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/search/ui/item/handler/FTSMessageDataItemClickHandler", "onItemClick", "(Landroid/content/Context;Landroid/view/View;Lcom/tencent/mm/plugin/fts/api/ui/item/FTSDataItem;[Ljava/lang/Object;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    for (;;)
    {
      AppMethodBeat.o(28081);
      return true;
      Object localObject;
      if (localm.tMw == 1)
      {
        if (com.tencent.mm.al.g.Es(localm.username))
        {
          paramVarArgs = new Intent().putExtra("Contact_User", localm.username);
          com.tencent.mm.plugin.search.a.iUz.c(paramVarArgs, paramContext);
        }
        else if (com.tencent.mm.al.g.vz(localm.username))
        {
          paramVarArgs = new Intent();
          paramVarArgs.putExtra("Contact_User", localm.username);
          paramVarArgs.addFlags(67108864);
          paramVarArgs.putExtra("biz_chat_from_scene", 5);
          d.f(paramContext, ".ui.bizchat.BizChatConversationUI", paramVarArgs);
        }
        else
        {
          if (com.tencent.mm.al.g.Et(localm.username))
          {
            paramVarArgs = com.tencent.mm.al.g.eX(localm.username);
            if (paramVarArgs == null) {}
            for (paramVarArgs = null;; paramVarArgs = paramVarArgs.Kz())
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
          if (x.AW(localm.username))
          {
            paramVarArgs = bu.U(localm.tFe.tFE);
            localObject = new Intent();
            ((Intent)localObject).putExtra("Chat_User", localm.kno.talker);
            ((Intent)localObject).putExtra("finish_direct", true);
            ((Intent)localObject).putExtra("from_global_search", true);
            ((Intent)localObject).putExtra("msg_local_id", localm.kno.tGf);
            ((Intent)localObject).putExtra("highlight_keyword_list", paramVarArgs);
            d.f(paramContext, ".ui.chatting.AppBrandServiceChattingUI", (Intent)localObject);
          }
          else if (an.aUv(localm.username))
          {
            paramVarArgs = ((f)com.tencent.mm.kernel.g.ab(f.class)).anD(localm.username);
            paramVarArgs = new Intent().putExtra("Chat_User", localm.username).putExtra("Chat_Self", paramVarArgs.getSelfUsername()).putExtra("finish_direct", true);
            com.tencent.mm.plugin.search.a.iUz.d(paramVarArgs, paramContext);
          }
          else
          {
            paramVarArgs = bu.U(localm.tFe.tFE);
            paramVarArgs = new Intent().putExtra("Chat_User", localm.username).putExtra("finish_direct", true).putExtra("from_global_search", true).putExtra("msg_local_id", localm.kno.tGf).putExtra("highlight_keyword_list", paramVarArgs);
            com.tencent.mm.plugin.search.a.iUz.d(paramVarArgs, paramContext);
          }
        }
      }
      else if (com.tencent.mm.al.g.vz(localm.username))
      {
        paramVarArgs = new Intent();
        paramVarArgs.putExtra("Contact_User", localm.username);
        paramVarArgs.addFlags(67108864);
        paramVarArgs.putExtra("biz_chat_from_scene", 5);
        d.f(paramContext, ".ui.bizchat.BizChatConversationUI", paramVarArgs);
      }
      else
      {
        if (com.tencent.mm.al.g.Et(localm.username))
        {
          paramVarArgs = com.tencent.mm.al.g.eX(localm.username);
          if (paramVarArgs == null) {}
          for (paramVarArgs = null;; paramVarArgs = paramVarArgs.Kz())
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
        if (an.aUv(localm.username))
        {
          paramVarArgs = ((f)com.tencent.mm.kernel.g.ab(f.class)).anD(localm.username);
          paramVarArgs = new Intent().putExtra("Chat_User", localm.username).putExtra("Chat_Self", paramVarArgs.getSelfUsername()).putExtra("finish_direct", true);
          com.tencent.mm.plugin.search.a.iUz.d(paramVarArgs, paramContext);
        }
        else if ((localm instanceof p))
        {
          paramVarArgs = (p)localm;
          paramVarArgs = new Intent(paramContext, FTSConvTalkerMessageUI.class).putExtra("Search_Scene", paramVarArgs.lox).putExtra("key_talker_query", paramVarArgs.tLO.tFe.tFC).putExtra("key_talker", paramVarArgs.tLO.tEY).putExtra("key_conv", paramVarArgs.username).putExtra("key_query", paramVarArgs.tFe.tFC).putExtra("detail_type", paramVarArgs.dmr);
          paramVarArgs = new com.tencent.mm.hellhoundlib.b.a().bc(paramVarArgs);
          com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramVarArgs.ahE(), "com/tencent/mm/plugin/search/ui/item/handler/FTSMessageDataItemClickHandler", "onItemClick", "(Landroid/content/Context;Landroid/view/View;Lcom/tencent/mm/plugin/fts/api/ui/item/FTSDataItem;[Ljava/lang/Object;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramContext.startActivity((Intent)paramVarArgs.mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/search/ui/item/handler/FTSMessageDataItemClickHandler", "onItemClick", "(Landroid/content/Context;Landroid/view/View;Lcom/tencent/mm/plugin/fts/api/ui/item/FTSDataItem;[Ljava/lang/Object;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        else
        {
          paramVarArgs = new Intent(paramContext, FTSConvMessageUI.class).putExtra("Search_Scene", localm.lox).putExtra("key_conv", localm.username).putExtra("key_query", localm.tFe.tFC).putExtra("key_count", localm.tMw);
          paramVarArgs = new com.tencent.mm.hellhoundlib.b.a().bc(paramVarArgs);
          com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramVarArgs.ahE(), "com/tencent/mm/plugin/search/ui/item/handler/FTSMessageDataItemClickHandler", "onItemClick", "(Landroid/content/Context;Landroid/view/View;Lcom/tencent/mm/plugin/fts/api/ui/item/FTSDataItem;[Ljava/lang/Object;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramContext.startActivity((Intent)paramVarArgs.mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/search/ui/item/handler/FTSMessageDataItemClickHandler", "onItemClick", "(Landroid/content/Context;Landroid/view/View;Lcom/tencent/mm/plugin/fts/api/ui/item/FTSDataItem;[Ljava/lang/Object;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.search.ui.a.a.b
 * JD-Core Version:    0.7.0.1
 */
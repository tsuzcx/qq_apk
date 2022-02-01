package com.tencent.mm.plugin.search.ui.a.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.a.o;
import com.tencent.mm.plugin.fts.ui.FTSConvMessageUI;
import com.tencent.mm.plugin.fts.ui.FTSConvTalkerMessageUI;
import com.tencent.mm.plugin.fts.ui.b.s;
import com.tencent.mm.plugin.gamelife.a.e;
import com.tencent.mm.plugin.gamelife.a.f;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.au;

public final class b
  implements com.tencent.mm.plugin.fts.a.d.a.b
{
  public final boolean a(Context paramContext, View paramView, com.tencent.mm.plugin.fts.a.d.a.a paramVarArgs)
  {
    AppMethodBeat.i(262369);
    com.tencent.mm.plugin.fts.ui.b.m localm = (com.tencent.mm.plugin.fts.ui.b.m)paramVarArgs;
    if ((au.bwO(localm.username)) || (au.bwF(localm.username)))
    {
      if (!WeChatBrands.Business.Entries.GlobalWeCom.checkAvailable(paramView.getContext()))
      {
        AppMethodBeat.o(262369);
        return true;
      }
    }
    else if (ab.IS(localm.username))
    {
      if (!WeChatBrands.Business.Entries.SessionOa.checkAvailable(paramView.getContext()))
      {
        AppMethodBeat.o(262369);
        return true;
      }
    }
    else if ((au.bwC(localm.username)) && (!WeChatBrands.Business.Entries.SessionOa.checkAvailable(paramView.getContext())))
    {
      AppMethodBeat.o(262369);
      return true;
    }
    if (localm.HBm == 0)
    {
      paramView = new Intent(paramContext, FTSConvMessageUI.class).putExtra("Search_Scene", localm.syO).putExtra("key_conv", localm.username).putExtra("key_query", localm.FWt.Hte).putExtra("key_count", 1);
      paramView = new com.tencent.mm.hellhoundlib.b.a().cG(paramView);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramView.aYi(), "com/tencent/mm/plugin/search/ui/item/handler/FTSMessageDataItemClickHandler", "onItemClick", "(Landroid/content/Context;Landroid/view/View;Lcom/tencent/mm/plugin/fts/api/ui/item/FTSDataItem;[Ljava/lang/Object;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramView.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/search/ui/item/handler/FTSMessageDataItemClickHandler", "onItemClick", "(Landroid/content/Context;Landroid/view/View;Lcom/tencent/mm/plugin/fts/api/ui/item/FTSDataItem;[Ljava/lang/Object;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    for (;;)
    {
      AppMethodBeat.o(262369);
      return true;
      if (localm.HBm == 1)
      {
        if (com.tencent.mm.an.g.MB(localm.username))
        {
          paramView = new Intent().putExtra("Contact_User", localm.username);
          com.tencent.mm.plugin.search.a.pFn.c(paramView, paramContext);
        }
        else if (com.tencent.mm.an.g.Dn(localm.username))
        {
          paramView = new Intent();
          paramView.putExtra("Contact_User", localm.username);
          paramView.addFlags(67108864);
          paramView.putExtra("biz_chat_from_scene", 5);
          com.tencent.mm.br.c.g(paramContext, ".ui.bizchat.BizChatConversationUI", paramView);
        }
        else
        {
          if (com.tencent.mm.an.g.MC(localm.username))
          {
            paramView = com.tencent.mm.an.g.hU(localm.username);
            if (paramView == null) {}
            for (paramView = null;; paramView = paramView.aAT())
            {
              paramVarArgs = paramView;
              if (paramView == null) {
                paramVarArgs = "";
              }
              paramView = new Intent();
              paramView.putExtra("rawUrl", paramVarArgs);
              paramView.putExtra("useJs", true);
              paramView.putExtra("srcUsername", localm.username);
              paramView.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
              paramView.addFlags(67108864);
              com.tencent.mm.br.c.b(paramContext, "webview", ".ui.tools.WebViewUI", paramView);
              break;
            }
          }
          if (au.bwy(localm.username))
          {
            paramView = Util.stringsToList(localm.FWt.Htg);
            paramVarArgs = new Intent();
            paramVarArgs.putExtra("Chat_User", localm.rpp.talker);
            paramVarArgs.putExtra("finish_direct", true);
            com.tencent.mm.plugin.appbrand.config.g localg = com.tencent.mm.plugin.appbrand.config.g.qWE;
            if (!com.tencent.mm.plugin.appbrand.config.g.ckz()) {
              paramVarArgs.putExtra("key_need_send_video", false);
            }
            paramVarArgs.putExtra("from_global_search", true);
            paramVarArgs.putExtra("msg_local_id", localm.rpp.HtI);
            paramVarArgs.putExtra("highlight_keyword_list", paramView);
            paramVarArgs.putExtra("app_brand_chatting_from_scene_new", 5);
            com.tencent.mm.br.c.g(paramContext, ".ui.chatting.AppBrandServiceChattingUI", paramVarArgs);
          }
          else if (au.bwW(localm.username))
          {
            paramView = ((f)h.ax(f.class)).aHz(localm.username);
            paramView = new Intent().putExtra("Chat_User", localm.username).putExtra("Chat_Self", paramView.getSelfUsername()).putExtra("finish_direct", true);
            paramView.putExtra("chat_from_scene", 5);
            com.tencent.mm.plugin.search.a.pFn.d(paramView, paramContext);
          }
          else
          {
            paramView = Util.stringsToList(localm.FWt.Htg);
            paramView = new Intent().putExtra("Chat_User", localm.username).putExtra("finish_direct", true).putExtra("from_global_search", true).putExtra("msg_local_id", localm.rpp.HtI).putExtra("highlight_keyword_list", paramView);
            paramView.putExtra("chat_from_scene", 5);
            com.tencent.mm.plugin.search.a.pFn.d(paramView, paramContext);
          }
        }
      }
      else if (com.tencent.mm.an.g.Dn(localm.username))
      {
        paramView = new Intent();
        paramView.putExtra("Contact_User", localm.username);
        paramView.addFlags(67108864);
        paramView.putExtra("biz_chat_from_scene", 5);
        com.tencent.mm.br.c.g(paramContext, ".ui.bizchat.BizChatConversationUI", paramView);
      }
      else
      {
        if (com.tencent.mm.an.g.MC(localm.username))
        {
          paramView = com.tencent.mm.an.g.hU(localm.username);
          if (paramView == null) {}
          for (paramView = null;; paramView = paramView.aAT())
          {
            paramVarArgs = paramView;
            if (paramView == null) {
              paramVarArgs = "";
            }
            paramView = new Intent();
            paramView.putExtra("rawUrl", paramVarArgs);
            paramView.putExtra("useJs", true);
            paramView.putExtra("srcUsername", localm.username);
            paramView.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
            paramView.addFlags(67108864);
            com.tencent.mm.br.c.b(paramContext, "webview", ".ui.tools.WebViewUI", paramView);
            break;
          }
        }
        if (au.bwW(localm.username))
        {
          paramView = ((f)h.ax(f.class)).aHz(localm.username);
          paramView = new Intent().putExtra("Chat_User", localm.username).putExtra("Chat_Self", paramView.getSelfUsername()).putExtra("finish_direct", true);
          paramView.putExtra("chat_from_scene", 5);
          com.tencent.mm.plugin.search.a.pFn.d(paramView, paramContext);
        }
        else if ((localm instanceof s))
        {
          paramView = (s)localm;
          paramView = new Intent(paramContext, FTSConvTalkerMessageUI.class).putExtra("Search_Scene", paramView.syO).putExtra("key_talker_query", paramView.HAD.FWt.Hte).putExtra("key_talker", paramView.HAD.Hsz).putExtra("key_conv", paramView.username).putExtra("key_query", paramView.FWt.Hte).putExtra("detail_type", paramView.hAN);
          paramView = new com.tencent.mm.hellhoundlib.b.a().cG(paramView);
          com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramView.aYi(), "com/tencent/mm/plugin/search/ui/item/handler/FTSMessageDataItemClickHandler", "onItemClick", "(Landroid/content/Context;Landroid/view/View;Lcom/tencent/mm/plugin/fts/api/ui/item/FTSDataItem;[Ljava/lang/Object;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramContext.startActivity((Intent)paramView.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/search/ui/item/handler/FTSMessageDataItemClickHandler", "onItemClick", "(Landroid/content/Context;Landroid/view/View;Lcom/tencent/mm/plugin/fts/api/ui/item/FTSDataItem;[Ljava/lang/Object;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        else
        {
          paramView = new Intent(paramContext, FTSConvMessageUI.class).putExtra("Search_Scene", localm.syO).putExtra("key_conv", localm.username).putExtra("key_query", localm.FWt.Hte).putExtra("key_count", localm.HBm);
          paramView = new com.tencent.mm.hellhoundlib.b.a().cG(paramView);
          com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramView.aYi(), "com/tencent/mm/plugin/search/ui/item/handler/FTSMessageDataItemClickHandler", "onItemClick", "(Landroid/content/Context;Landroid/view/View;Lcom/tencent/mm/plugin/fts/api/ui/item/FTSDataItem;[Ljava/lang/Object;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramContext.startActivity((Intent)paramView.sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/search/ui/item/handler/FTSMessageDataItemClickHandler", "onItemClick", "(Landroid/content/Context;Landroid/view/View;Lcom/tencent/mm/plugin/fts/api/ui/item/FTSDataItem;[Ljava/lang/Object;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.search.ui.a.a.b
 * JD-Core Version:    0.7.0.1
 */
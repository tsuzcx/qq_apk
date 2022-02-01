package com.tencent.mm.plugin.search.ui.a.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ao.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.fts.ui.FTSConvMessageUI;
import com.tencent.mm.plugin.fts.ui.FTSConvTalkerMessageUI;
import com.tencent.mm.plugin.fts.ui.a.p;
import com.tencent.mm.plugin.gamelife.a.e;
import com.tencent.mm.plugin.gamelife.a.f;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands.Business.Entries;
import com.tencent.mm.storage.as;

public final class b
  implements com.tencent.mm.plugin.fts.a.d.a.b
{
  public final boolean a(Context paramContext, View paramView, com.tencent.mm.plugin.fts.a.d.a.a paramVarArgs)
  {
    AppMethodBeat.i(277499);
    com.tencent.mm.plugin.fts.ui.a.m localm = (com.tencent.mm.plugin.fts.ui.a.m)paramVarArgs;
    if ((as.bvK(localm.username)) || (ab.PQ(localm.username)))
    {
      if (!WeChatBrands.Business.Entries.GlobalWeCom.checkAvailable(paramView.getContext()))
      {
        AppMethodBeat.o(277499);
        return true;
      }
    }
    else if (ab.Qm(localm.username))
    {
      if (!WeChatBrands.Business.Entries.SessionOa.checkAvailable(paramView.getContext()))
      {
        AppMethodBeat.o(277499);
        return true;
      }
    }
    else if ((ab.QW(localm.username)) && (!WeChatBrands.Business.Entries.SessionOa.checkAvailable(paramView.getContext())))
    {
      AppMethodBeat.o(277499);
      return true;
    }
    if (localm.BPu == 0)
    {
      paramView = new Intent(paramContext, FTSConvMessageUI.class).putExtra("Search_Scene", localm.ptD).putExtra("key_conv", localm.username).putExtra("key_query", localm.BHY.BIw).putExtra("key_count", 1);
      paramView = new com.tencent.mm.hellhoundlib.b.a().bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramView.aFh(), "com/tencent/mm/plugin/search/ui/item/handler/FTSMessageDataItemClickHandler", "onItemClick", "(Landroid/content/Context;Landroid/view/View;Lcom/tencent/mm/plugin/fts/api/ui/item/FTSDataItem;[Ljava/lang/Object;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramView.sf(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/search/ui/item/handler/FTSMessageDataItemClickHandler", "onItemClick", "(Landroid/content/Context;Landroid/view/View;Lcom/tencent/mm/plugin/fts/api/ui/item/FTSDataItem;[Ljava/lang/Object;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    for (;;)
    {
      AppMethodBeat.o(277499);
      return true;
      if (localm.BPu == 1)
      {
        if (g.UC(localm.username))
        {
          paramView = new Intent().putExtra("Contact_User", localm.username);
          com.tencent.mm.plugin.search.a.mIG.c(paramView, paramContext);
        }
        else if (g.KI(localm.username))
        {
          paramView = new Intent();
          paramView.putExtra("Contact_User", localm.username);
          paramView.addFlags(67108864);
          paramView.putExtra("biz_chat_from_scene", 5);
          com.tencent.mm.by.c.f(paramContext, ".ui.bizchat.BizChatConversationUI", paramView);
        }
        else
        {
          if (g.UD(localm.username))
          {
            paramView = g.gu(localm.username);
            if (paramView == null) {}
            for (paramView = null;; paramView = paramView.Zb())
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
              com.tencent.mm.by.c.b(paramContext, "webview", ".ui.tools.WebViewUI", paramView);
              break;
            }
          }
          if (ab.QU(localm.username))
          {
            paramView = Util.stringsToList(localm.BHY.BIy);
            paramVarArgs = new Intent();
            paramVarArgs.putExtra("Chat_User", localm.olG.talker);
            paramVarArgs.putExtra("finish_direct", true);
            paramVarArgs.putExtra("from_global_search", true);
            paramVarArgs.putExtra("msg_local_id", localm.olG.BIZ);
            paramVarArgs.putExtra("highlight_keyword_list", paramView);
            paramVarArgs.putExtra("app_brand_chatting_from_scene_new", 5);
            com.tencent.mm.by.c.f(paramContext, ".ui.chatting.AppBrandServiceChattingUI", paramVarArgs);
          }
          else if (as.bvQ(localm.username))
          {
            paramView = ((f)com.tencent.mm.kernel.h.ae(f.class)).aKJ(localm.username);
            paramView = new Intent().putExtra("Chat_User", localm.username).putExtra("Chat_Self", paramView.getSelfUsername()).putExtra("finish_direct", true);
            paramView.putExtra("chat_from_scene", 5);
            com.tencent.mm.plugin.search.a.mIG.d(paramView, paramContext);
          }
          else
          {
            paramView = Util.stringsToList(localm.BHY.BIy);
            paramView = new Intent().putExtra("Chat_User", localm.username).putExtra("finish_direct", true).putExtra("from_global_search", true).putExtra("msg_local_id", localm.olG.BIZ).putExtra("highlight_keyword_list", paramView);
            paramView.putExtra("chat_from_scene", 5);
            com.tencent.mm.plugin.search.a.mIG.d(paramView, paramContext);
          }
        }
      }
      else if (g.KI(localm.username))
      {
        paramView = new Intent();
        paramView.putExtra("Contact_User", localm.username);
        paramView.addFlags(67108864);
        paramView.putExtra("biz_chat_from_scene", 5);
        com.tencent.mm.by.c.f(paramContext, ".ui.bizchat.BizChatConversationUI", paramView);
      }
      else
      {
        if (g.UD(localm.username))
        {
          paramView = g.gu(localm.username);
          if (paramView == null) {}
          for (paramView = null;; paramView = paramView.Zb())
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
            com.tencent.mm.by.c.b(paramContext, "webview", ".ui.tools.WebViewUI", paramView);
            break;
          }
        }
        if (as.bvQ(localm.username))
        {
          paramView = ((f)com.tencent.mm.kernel.h.ae(f.class)).aKJ(localm.username);
          paramView = new Intent().putExtra("Chat_User", localm.username).putExtra("Chat_Self", paramView.getSelfUsername()).putExtra("finish_direct", true);
          paramView.putExtra("chat_from_scene", 5);
          com.tencent.mm.plugin.search.a.mIG.d(paramView, paramContext);
        }
        else if ((localm instanceof p))
        {
          paramView = (p)localm;
          paramView = new Intent(paramContext, FTSConvTalkerMessageUI.class).putExtra("Search_Scene", paramView.ptD).putExtra("key_talker_query", paramView.BON.BHY.BIw).putExtra("key_talker", paramView.BON.BHS).putExtra("key_conv", paramView.username).putExtra("key_query", paramView.BHY.BIw).putExtra("detail_type", paramView.fwp);
          paramView = new com.tencent.mm.hellhoundlib.b.a().bm(paramView);
          com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramView.aFh(), "com/tencent/mm/plugin/search/ui/item/handler/FTSMessageDataItemClickHandler", "onItemClick", "(Landroid/content/Context;Landroid/view/View;Lcom/tencent/mm/plugin/fts/api/ui/item/FTSDataItem;[Ljava/lang/Object;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramContext.startActivity((Intent)paramView.sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/search/ui/item/handler/FTSMessageDataItemClickHandler", "onItemClick", "(Landroid/content/Context;Landroid/view/View;Lcom/tencent/mm/plugin/fts/api/ui/item/FTSDataItem;[Ljava/lang/Object;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        else
        {
          paramView = new Intent(paramContext, FTSConvMessageUI.class).putExtra("Search_Scene", localm.ptD).putExtra("key_conv", localm.username).putExtra("key_query", localm.BHY.BIw).putExtra("key_count", localm.BPu);
          paramView = new com.tencent.mm.hellhoundlib.b.a().bm(paramView);
          com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramView.aFh(), "com/tencent/mm/plugin/search/ui/item/handler/FTSMessageDataItemClickHandler", "onItemClick", "(Landroid/content/Context;Landroid/view/View;Lcom/tencent/mm/plugin/fts/api/ui/item/FTSDataItem;[Ljava/lang/Object;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramContext.startActivity((Intent)paramView.sf(0));
          com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/search/ui/item/handler/FTSMessageDataItemClickHandler", "onItemClick", "(Landroid/content/Context;Landroid/view/View;Lcom/tencent/mm/plugin/fts/api/ui/item/FTSDataItem;[Ljava/lang/Object;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.search.ui.a.a.b
 * JD-Core Version:    0.7.0.1
 */
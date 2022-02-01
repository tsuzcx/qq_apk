package com.tencent.mm.plugin.search.ui.a.a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.fts.a.a.h;
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
    AppMethodBeat.i(232057);
    com.tencent.mm.plugin.fts.ui.a.m localm = (com.tencent.mm.plugin.fts.ui.a.m)paramVarArgs;
    if ((as.bjp(localm.username)) || (ab.Iy(localm.username)))
    {
      if (!WeChatBrands.Business.Entries.GlobalWeCom.checkAvailable(paramView.getContext()))
      {
        AppMethodBeat.o(232057);
        return true;
      }
    }
    else if (ab.IT(localm.username))
    {
      if (!WeChatBrands.Business.Entries.SessionOa.checkAvailable(paramView.getContext()))
      {
        AppMethodBeat.o(232057);
        return true;
      }
    }
    else if ((ab.JD(localm.username)) && (!WeChatBrands.Business.Entries.SessionOa.checkAvailable(paramView.getContext())))
    {
      AppMethodBeat.o(232057);
      return true;
    }
    if (localm.xdw == 0)
    {
      paramView = new Intent(paramContext, FTSConvMessageUI.class).putExtra("Search_Scene", localm.mve).putExtra("key_conv", localm.username).putExtra("key_query", localm.wWd.wWB).putExtra("key_count", 1);
      paramView = new com.tencent.mm.hellhoundlib.b.a().bl(paramView);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramView.axQ(), "com/tencent/mm/plugin/search/ui/item/handler/FTSMessageDataItemClickHandler", "onItemClick", "(Landroid/content/Context;Landroid/view/View;Lcom/tencent/mm/plugin/fts/api/ui/item/FTSDataItem;[Ljava/lang/Object;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramView.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/search/ui/item/handler/FTSMessageDataItemClickHandler", "onItemClick", "(Landroid/content/Context;Landroid/view/View;Lcom/tencent/mm/plugin/fts/api/ui/item/FTSDataItem;[Ljava/lang/Object;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    for (;;)
    {
      AppMethodBeat.o(232057);
      return true;
      if (localm.xdw == 1)
      {
        if (com.tencent.mm.al.g.Ng(localm.username))
        {
          paramView = new Intent().putExtra("Contact_User", localm.username);
          com.tencent.mm.plugin.search.a.jRt.c(paramView, paramContext);
        }
        else if (com.tencent.mm.al.g.DQ(localm.username))
        {
          paramView = new Intent();
          paramView.putExtra("Contact_User", localm.username);
          paramView.addFlags(67108864);
          paramView.putExtra("biz_chat_from_scene", 5);
          com.tencent.mm.br.c.f(paramContext, ".ui.bizchat.BizChatConversationUI", paramView);
        }
        else
        {
          if (com.tencent.mm.al.g.Nh(localm.username))
          {
            paramView = com.tencent.mm.al.g.fJ(localm.username);
            if (paramView == null) {}
            for (paramView = null;; paramView = paramView.UJ())
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
          if (ab.JB(localm.username))
          {
            paramView = Util.stringsToList(localm.wWd.wWD);
            paramVarArgs = new Intent();
            paramVarArgs.putExtra("Chat_User", localm.lqW.talker);
            paramVarArgs.putExtra("finish_direct", true);
            paramVarArgs.putExtra("from_global_search", true);
            paramVarArgs.putExtra("msg_local_id", localm.lqW.wXe);
            paramVarArgs.putExtra("highlight_keyword_list", paramView);
            com.tencent.mm.br.c.f(paramContext, ".ui.chatting.AppBrandServiceChattingUI", paramVarArgs);
          }
          else if (as.bju(localm.username))
          {
            paramView = ((f)com.tencent.mm.kernel.g.af(f.class)).aAW(localm.username);
            paramView = new Intent().putExtra("Chat_User", localm.username).putExtra("Chat_Self", paramView.getSelfUsername()).putExtra("finish_direct", true);
            paramView.putExtra("chat_from_scene", 5);
            com.tencent.mm.plugin.search.a.jRt.d(paramView, paramContext);
          }
          else
          {
            paramView = Util.stringsToList(localm.wWd.wWD);
            paramView = new Intent().putExtra("Chat_User", localm.username).putExtra("finish_direct", true).putExtra("from_global_search", true).putExtra("msg_local_id", localm.lqW.wXe).putExtra("highlight_keyword_list", paramView);
            paramView.putExtra("chat_from_scene", 5);
            com.tencent.mm.plugin.search.a.jRt.d(paramView, paramContext);
          }
        }
      }
      else if (com.tencent.mm.al.g.DQ(localm.username))
      {
        paramView = new Intent();
        paramView.putExtra("Contact_User", localm.username);
        paramView.addFlags(67108864);
        paramView.putExtra("biz_chat_from_scene", 5);
        com.tencent.mm.br.c.f(paramContext, ".ui.bizchat.BizChatConversationUI", paramView);
      }
      else
      {
        if (com.tencent.mm.al.g.Nh(localm.username))
        {
          paramView = com.tencent.mm.al.g.fJ(localm.username);
          if (paramView == null) {}
          for (paramView = null;; paramView = paramView.UJ())
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
        if (as.bju(localm.username))
        {
          paramView = ((f)com.tencent.mm.kernel.g.af(f.class)).aAW(localm.username);
          paramView = new Intent().putExtra("Chat_User", localm.username).putExtra("Chat_Self", paramView.getSelfUsername()).putExtra("finish_direct", true);
          paramView.putExtra("chat_from_scene", 5);
          com.tencent.mm.plugin.search.a.jRt.d(paramView, paramContext);
        }
        else if ((localm instanceof p))
        {
          paramView = (p)localm;
          paramView = new Intent(paramContext, FTSConvTalkerMessageUI.class).putExtra("Search_Scene", paramView.mve).putExtra("key_talker_query", paramView.xcP.wWd.wWB).putExtra("key_talker", paramView.xcP.wVX).putExtra("key_conv", paramView.username).putExtra("key_query", paramView.wWd.wWB).putExtra("detail_type", paramView.dDG);
          paramView = new com.tencent.mm.hellhoundlib.b.a().bl(paramView);
          com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramView.axQ(), "com/tencent/mm/plugin/search/ui/item/handler/FTSMessageDataItemClickHandler", "onItemClick", "(Landroid/content/Context;Landroid/view/View;Lcom/tencent/mm/plugin/fts/api/ui/item/FTSDataItem;[Ljava/lang/Object;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramContext.startActivity((Intent)paramView.pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/search/ui/item/handler/FTSMessageDataItemClickHandler", "onItemClick", "(Landroid/content/Context;Landroid/view/View;Lcom/tencent/mm/plugin/fts/api/ui/item/FTSDataItem;[Ljava/lang/Object;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        else
        {
          paramView = new Intent(paramContext, FTSConvMessageUI.class).putExtra("Search_Scene", localm.mve).putExtra("key_conv", localm.username).putExtra("key_query", localm.wWd.wWB).putExtra("key_count", localm.xdw);
          paramView = new com.tencent.mm.hellhoundlib.b.a().bl(paramView);
          com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramView.axQ(), "com/tencent/mm/plugin/search/ui/item/handler/FTSMessageDataItemClickHandler", "onItemClick", "(Landroid/content/Context;Landroid/view/View;Lcom/tencent/mm/plugin/fts/api/ui/item/FTSDataItem;[Ljava/lang/Object;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramContext.startActivity((Intent)paramView.pG(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/search/ui/item/handler/FTSMessageDataItemClickHandler", "onItemClick", "(Landroid/content/Context;Landroid/view/View;Lcom/tencent/mm/plugin/fts/api/ui/item/FTSDataItem;[Ljava/lang/Object;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.search.ui.a.a.b
 * JD-Core Version:    0.7.0.1
 */
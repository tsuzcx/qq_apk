package com.tencent.mm.plugin.search.ui.a.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.c;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.fts.a.a.h;
import com.tencent.mm.plugin.fts.ui.FTSConvMessageUI;
import com.tencent.mm.plugin.fts.ui.FTSConvTalkerMessageUI;
import com.tencent.mm.plugin.fts.ui.a.p;
import com.tencent.mm.plugin.gamelife.a.e;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;

public final class b
  implements com.tencent.mm.plugin.fts.a.d.a.b
{
  public final boolean a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a paramVarArgs)
  {
    AppMethodBeat.i(28081);
    com.tencent.mm.plugin.fts.ui.a.m localm = (com.tencent.mm.plugin.fts.ui.a.m)paramVarArgs;
    if (localm.tBF == 0)
    {
      paramVarArgs = new Intent(paramContext, FTSConvMessageUI.class).putExtra("Search_Scene", localm.ljZ).putExtra("key_conv", localm.username).putExtra("key_query", localm.tun.tuL).putExtra("key_count", 1);
      paramVarArgs = new com.tencent.mm.hellhoundlib.b.a().bc(paramVarArgs);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramVarArgs.ahp(), "com/tencent/mm/plugin/search/ui/item/handler/FTSMessageDataItemClickHandler", "onItemClick", "(Landroid/content/Context;Landroid/view/View;Lcom/tencent/mm/plugin/fts/api/ui/item/FTSDataItem;[Ljava/lang/Object;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramVarArgs.mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/search/ui/item/handler/FTSMessageDataItemClickHandler", "onItemClick", "(Landroid/content/Context;Landroid/view/View;Lcom/tencent/mm/plugin/fts/api/ui/item/FTSDataItem;[Ljava/lang/Object;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    }
    for (;;)
    {
      AppMethodBeat.o(28081);
      return true;
      Object localObject;
      if (localm.tBF == 1)
      {
        if (com.tencent.mm.am.g.DQ(localm.username))
        {
          paramVarArgs = new Intent().putExtra("Contact_User", localm.username);
          com.tencent.mm.plugin.search.a.iRG.c(paramVarArgs, paramContext);
        }
        else if (com.tencent.mm.am.g.vd(localm.username))
        {
          paramVarArgs = new Intent();
          paramVarArgs.putExtra("Contact_User", localm.username);
          paramVarArgs.addFlags(67108864);
          paramVarArgs.putExtra("biz_chat_from_scene", 5);
          com.tencent.mm.bs.d.f(paramContext, ".ui.bizchat.BizChatConversationUI", paramVarArgs);
        }
        else
        {
          if (com.tencent.mm.am.g.DR(localm.username))
          {
            paramVarArgs = com.tencent.mm.am.g.eS(localm.username);
            if (paramVarArgs == null) {}
            for (paramVarArgs = null;; paramVarArgs = paramVarArgs.Kr())
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
              com.tencent.mm.bs.d.b(paramContext, "webview", ".ui.tools.WebViewUI", paramVarArgs);
              break;
            }
          }
          if (w.Am(localm.username))
          {
            paramVarArgs = bt.U(localm.tun.tuN);
            localObject = new Intent();
            ((Intent)localObject).putExtra("Chat_User", localm.kjY.talker);
            ((Intent)localObject).putExtra("finish_direct", true);
            ((Intent)localObject).putExtra("from_global_search", true);
            ((Intent)localObject).putExtra("msg_local_id", localm.kjY.tvo);
            ((Intent)localObject).putExtra("highlight_keyword_list", paramVarArgs);
            com.tencent.mm.bs.d.f(paramContext, ".ui.chatting.AppBrandServiceChattingUI", (Intent)localObject);
          }
          else if (am.aSV(localm.username))
          {
            paramVarArgs = ((e)com.tencent.mm.kernel.g.ab(e.class)).amC(localm.username);
            paramVarArgs = new Intent().putExtra("Chat_User", localm.username).putExtra("Chat_Self", paramVarArgs.getSelfUsername()).putExtra("finish_direct", true);
            com.tencent.mm.plugin.search.a.iRG.d(paramVarArgs, paramContext);
          }
          else
          {
            paramVarArgs = bt.U(localm.tun.tuN);
            paramVarArgs = new Intent().putExtra("Chat_User", localm.username).putExtra("finish_direct", true).putExtra("from_global_search", true).putExtra("msg_local_id", localm.kjY.tvo).putExtra("highlight_keyword_list", paramVarArgs);
            com.tencent.mm.plugin.search.a.iRG.d(paramVarArgs, paramContext);
          }
        }
      }
      else if (com.tencent.mm.am.g.vd(localm.username))
      {
        paramVarArgs = new Intent();
        paramVarArgs.putExtra("Contact_User", localm.username);
        paramVarArgs.addFlags(67108864);
        paramVarArgs.putExtra("biz_chat_from_scene", 5);
        com.tencent.mm.bs.d.f(paramContext, ".ui.bizchat.BizChatConversationUI", paramVarArgs);
      }
      else
      {
        if (com.tencent.mm.am.g.DR(localm.username))
        {
          paramVarArgs = com.tencent.mm.am.g.eS(localm.username);
          if (paramVarArgs == null) {}
          for (paramVarArgs = null;; paramVarArgs = paramVarArgs.Kr())
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
            com.tencent.mm.bs.d.b(paramContext, "webview", ".ui.tools.WebViewUI", paramVarArgs);
            break;
          }
        }
        if (am.aSV(localm.username))
        {
          paramVarArgs = ((e)com.tencent.mm.kernel.g.ab(e.class)).amC(localm.username);
          paramVarArgs = new Intent().putExtra("Chat_User", localm.username).putExtra("Chat_Self", paramVarArgs.getSelfUsername()).putExtra("finish_direct", true);
          com.tencent.mm.plugin.search.a.iRG.d(paramVarArgs, paramContext);
        }
        else if ((localm instanceof p))
        {
          paramVarArgs = (p)localm;
          paramVarArgs = new Intent(paramContext, FTSConvTalkerMessageUI.class).putExtra("Search_Scene", paramVarArgs.ljZ).putExtra("key_talker_query", paramVarArgs.tAX.tun.tuL).putExtra("key_talker", paramVarArgs.tAX.tuh).putExtra("key_conv", paramVarArgs.username).putExtra("key_query", paramVarArgs.tun.tuL).putExtra("detail_type", paramVarArgs.dlp);
          paramVarArgs = new com.tencent.mm.hellhoundlib.b.a().bc(paramVarArgs);
          com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramVarArgs.ahp(), "com/tencent/mm/plugin/search/ui/item/handler/FTSMessageDataItemClickHandler", "onItemClick", "(Landroid/content/Context;Landroid/view/View;Lcom/tencent/mm/plugin/fts/api/ui/item/FTSDataItem;[Ljava/lang/Object;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramContext.startActivity((Intent)paramVarArgs.mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/search/ui/item/handler/FTSMessageDataItemClickHandler", "onItemClick", "(Landroid/content/Context;Landroid/view/View;Lcom/tencent/mm/plugin/fts/api/ui/item/FTSDataItem;[Ljava/lang/Object;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        else
        {
          paramVarArgs = new Intent(paramContext, FTSConvMessageUI.class).putExtra("Search_Scene", localm.ljZ).putExtra("key_conv", localm.username).putExtra("key_query", localm.tun.tuL).putExtra("key_count", localm.tBF);
          paramVarArgs = new com.tencent.mm.hellhoundlib.b.a().bc(paramVarArgs);
          com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramVarArgs.ahp(), "com/tencent/mm/plugin/search/ui/item/handler/FTSMessageDataItemClickHandler", "onItemClick", "(Landroid/content/Context;Landroid/view/View;Lcom/tencent/mm/plugin/fts/api/ui/item/FTSDataItem;[Ljava/lang/Object;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          paramContext.startActivity((Intent)paramVarArgs.mq(0));
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
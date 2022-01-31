package com.tencent.mm.plugin.search.b.a.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.ai.f;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.ui.FTSConvMessageUI;
import com.tencent.mm.plugin.fts.ui.FTSConvTalkerMessageUI;
import com.tencent.mm.plugin.fts.ui.a.p;
import com.tencent.mm.sdk.platformtools.bk;

public final class b
  implements com.tencent.mm.plugin.fts.a.d.a.b
{
  public final boolean a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a paramVarArgs)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    com.tencent.mm.plugin.fts.ui.a.m localm = (com.tencent.mm.plugin.fts.ui.a.m)paramVarArgs;
    if (localm.kDC < 2)
    {
      if (f.lc(localm.username))
      {
        paramVarArgs = new Intent().putExtra("Contact_User", localm.username);
        com.tencent.mm.plugin.search.a.eUR.d(paramVarArgs, paramContext);
        return true;
      }
      if (f.eW(localm.username))
      {
        paramVarArgs = new Intent();
        paramVarArgs.putExtra("Contact_User", localm.username);
        paramVarArgs.addFlags(67108864);
        paramVarArgs.putExtra("biz_chat_from_scene", 5);
        com.tencent.mm.br.d.e(paramContext, ".ui.bizchat.BizChatConversationUI", paramVarArgs);
        return true;
      }
      if (f.ld(localm.username))
      {
        paramVarArgs = f.kX(localm.username);
        if (paramVarArgs == null) {}
        for (paramVarArgs = (com.tencent.mm.plugin.fts.a.d.a.a)localObject1;; paramVarArgs = paramVarArgs.LC())
        {
          localObject1 = paramVarArgs;
          if (paramVarArgs == null) {
            localObject1 = "";
          }
          paramVarArgs = new Intent();
          paramVarArgs.putExtra("rawUrl", (String)localObject1);
          paramVarArgs.putExtra("useJs", true);
          paramVarArgs.putExtra("srcUsername", localm.username);
          paramVarArgs.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
          paramVarArgs.addFlags(67108864);
          com.tencent.mm.br.d.b(paramContext, "webview", ".ui.tools.WebViewUI", paramVarArgs);
          return true;
        }
      }
      paramVarArgs = bk.G(localm.kwi.kwI);
      paramVarArgs = new Intent().putExtra("Chat_User", localm.username).putExtra("finish_direct", true).putExtra("from_global_search", true).putExtra("msg_local_id", localm.fYx.kxk).putExtra("highlight_keyword_list", paramVarArgs);
      com.tencent.mm.plugin.search.a.eUR.e(paramVarArgs, paramContext);
      return true;
    }
    if (f.eW(localm.username))
    {
      paramVarArgs = new Intent();
      paramVarArgs.putExtra("Contact_User", localm.username);
      paramVarArgs.addFlags(67108864);
      paramVarArgs.putExtra("biz_chat_from_scene", 5);
      com.tencent.mm.br.d.e(paramContext, ".ui.bizchat.BizChatConversationUI", paramVarArgs);
      return true;
    }
    if (f.ld(localm.username))
    {
      paramVarArgs = f.kX(localm.username);
      if (paramVarArgs == null) {}
      for (paramVarArgs = localObject2;; paramVarArgs = paramVarArgs.LC())
      {
        localObject1 = paramVarArgs;
        if (paramVarArgs == null) {
          localObject1 = "";
        }
        paramVarArgs = new Intent();
        paramVarArgs.putExtra("rawUrl", (String)localObject1);
        paramVarArgs.putExtra("useJs", true);
        paramVarArgs.putExtra("srcUsername", localm.username);
        paramVarArgs.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
        paramVarArgs.addFlags(67108864);
        com.tencent.mm.br.d.b(paramContext, "webview", ".ui.tools.WebViewUI", paramVarArgs);
        return true;
      }
    }
    if ((localm instanceof p))
    {
      paramVarArgs = (p)localm;
      paramContext.startActivity(new Intent(paramContext, FTSConvTalkerMessageUI.class).putExtra("Search_Scene", paramVarArgs.kxJ).putExtra("key_talker_query", paramVarArgs.kCT.kwi.kwG).putExtra("key_talker", paramVarArgs.kCT.kwg).putExtra("key_conv", paramVarArgs.username).putExtra("key_query", paramVarArgs.kwi.kwG).putExtra("detail_type", paramVarArgs.showType));
      return true;
    }
    paramContext.startActivity(new Intent(paramContext, FTSConvMessageUI.class).putExtra("Search_Scene", localm.kxJ).putExtra("key_conv", localm.username).putExtra("key_query", localm.kwi.kwG).putExtra("key_count", localm.kDC));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.search.b.a.a.b
 * JD-Core Version:    0.7.0.1
 */
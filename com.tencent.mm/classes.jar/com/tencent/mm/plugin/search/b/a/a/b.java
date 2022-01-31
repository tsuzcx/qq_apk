package com.tencent.mm.plugin.search.b.a.a;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.f;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.ui.FTSConvMessageUI;
import com.tencent.mm.plugin.fts.ui.FTSConvTalkerMessageUI;
import com.tencent.mm.plugin.fts.ui.a.m;
import com.tencent.mm.plugin.fts.ui.a.p;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.platformtools.bo;

public final class b
  implements com.tencent.mm.plugin.fts.a.d.a.b
{
  public final boolean a(Context paramContext, com.tencent.mm.plugin.fts.a.d.a.a paramVarArgs)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(24406);
    m localm = (m)paramVarArgs;
    if (localm.mZy < 2) {
      if (f.rX(localm.username))
      {
        paramVarArgs = new Intent().putExtra("Contact_User", localm.username);
        com.tencent.mm.plugin.search.a.gmO.c(paramVarArgs, paramContext);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(24406);
      return true;
      if (f.lg(localm.username))
      {
        paramVarArgs = new Intent();
        paramVarArgs.putExtra("Contact_User", localm.username);
        paramVarArgs.addFlags(67108864);
        paramVarArgs.putExtra("biz_chat_from_scene", 5);
        com.tencent.mm.bq.d.f(paramContext, ".ui.bizchat.BizChatConversationUI", paramVarArgs);
      }
      else
      {
        if (f.rY(localm.username))
        {
          paramVarArgs = f.rS(localm.username);
          if (paramVarArgs == null) {}
          for (paramVarArgs = (com.tencent.mm.plugin.fts.a.d.a.a)localObject1;; paramVarArgs = paramVarArgs.aek())
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
            com.tencent.mm.bq.d.b(paramContext, "webview", ".ui.tools.WebViewUI", paramVarArgs);
            break;
          }
        }
        paramVarArgs = bo.P(localm.mRX.mSy);
        paramVarArgs = new Intent().putExtra("Chat_User", localm.username).putExtra("finish_direct", true).putExtra("from_global_search", true).putExtra("msg_local_id", localm.hrL.mSZ).putExtra("highlight_keyword_list", paramVarArgs);
        com.tencent.mm.plugin.search.a.gmO.d(paramVarArgs, paramContext);
        continue;
        if (f.lg(localm.username))
        {
          paramVarArgs = new Intent();
          paramVarArgs.putExtra("Contact_User", localm.username);
          paramVarArgs.addFlags(67108864);
          paramVarArgs.putExtra("biz_chat_from_scene", 5);
          com.tencent.mm.bq.d.f(paramContext, ".ui.bizchat.BizChatConversationUI", paramVarArgs);
        }
        else
        {
          if (f.rY(localm.username))
          {
            paramVarArgs = f.rS(localm.username);
            if (paramVarArgs == null) {}
            for (paramVarArgs = localObject2;; paramVarArgs = paramVarArgs.aek())
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
              com.tencent.mm.bq.d.b(paramContext, "webview", ".ui.tools.WebViewUI", paramVarArgs);
              break;
            }
          }
          if ((localm instanceof p))
          {
            paramVarArgs = (p)localm;
            paramContext.startActivity(new Intent(paramContext, FTSConvTalkerMessageUI.class).putExtra("Search_Scene", paramVarArgs.ibk).putExtra("key_talker_query", paramVarArgs.mYP.mRX.mSw).putExtra("key_talker", paramVarArgs.mYP.mRV).putExtra("key_conv", paramVarArgs.username).putExtra("key_query", paramVarArgs.mRX.mSw).putExtra("detail_type", paramVarArgs.showType));
          }
          else
          {
            paramContext.startActivity(new Intent(paramContext, FTSConvMessageUI.class).putExtra("Search_Scene", localm.ibk).putExtra("key_conv", localm.username).putExtra("key_query", localm.mRX.mSw).putExtra("key_count", localm.mZy));
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.search.b.a.a.b
 * JD-Core Version:    0.7.0.1
 */
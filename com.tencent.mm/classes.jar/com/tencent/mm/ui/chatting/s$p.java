package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.l;
import com.tencent.mm.af.p;
import com.tencent.mm.af.q;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.s;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.viewitems.az;
import com.tencent.mm.ui.chatting.viewitems.x.b;
import com.tencent.mm.ui.e.l;
import java.util.LinkedList;
import java.util.Map;

public final class s$p
  extends s.e
{
  public s$p(com.tencent.mm.ui.chatting.d.a parama)
  {
    super(parama);
  }
  
  public final void a(View paramView, com.tencent.mm.ui.chatting.d.a parama, bi parambi)
  {
    AppMethodBeat.i(30734);
    paramView = (az)paramView.getTag();
    int j = 0;
    long l = System.currentTimeMillis();
    int k = (int)(l / 1000L);
    ab.i("MicroMsg.WebViewClickListener", "WebViewClickListener onClick = %d", new Object[] { Integer.valueOf(k) });
    if (e.a(paramView.cMO, parama.zJz.getContext(), null, parama.getTalkerUserName()))
    {
      AppMethodBeat.o(30734);
      return;
    }
    Object localObject1 = paramView.userName;
    Object localObject2 = paramView.zYG;
    if ((localObject1 == null) || (((String)localObject1).equals("")))
    {
      AppMethodBeat.o(30734);
      return;
    }
    Object localObject3 = l.c((String)localObject1, 0, parama.zJz.getIntExtra("KOpenArticleSceneFromScene", 10000), k);
    localObject1 = new Intent();
    ((Intent)localObject1).putExtra("rawUrl", (String)localObject3);
    ((Intent)localObject1).putExtra("shortUrl", (String)localObject3);
    ((Intent)localObject1).putExtra("webpageTitle", (String)localObject2);
    localObject2 = new Bundle();
    int i;
    if (parambi != null)
    {
      if (parambi.dxP())
      {
        localObject3 = br.F(parambi.field_content, "msg");
        if (localObject3 != null)
        {
          localObject3 = x.b.aY((Map)localObject3);
          if (!bo.isNullOrNil(((x.b)localObject3).fhC))
          {
            ((Intent)localObject1).putExtra("KTemplateId", ((x.b)localObject3).fhC);
            ab.d("MicroMsg.WebViewClickListener", "report template msg click action, templateId(%s). srcUsername(%s)", new Object[] { ((x.b)localObject3).fhC, paramView.cGN });
            h.qsU.e(11608, new Object[] { ((x.b)localObject3).fhC, paramView.cGN, Integer.valueOf(0) });
          }
        }
      }
      aw.aaz();
      localObject3 = com.tencent.mm.model.c.YA().arw(parambi.field_talker);
      i = j;
      if (localObject3 != null)
      {
        i = j;
        if (((ad)localObject3).dwz())
        {
          i = 4;
          ab.d("MicroMsg.WebViewClickListener", "hakon click biz msg %s", new Object[] { ((aq)localObject3).field_username });
        }
      }
      ((Intent)localObject1).putExtra("msg_id", parambi.field_msgId);
      ((Intent)localObject1).putExtra("KPublisherId", "msg_" + Long.toString(parambi.field_msgSvrId));
      ((Intent)localObject1).putExtra("pre_username", parambi.field_talker);
      localObject3 = (com.tencent.mm.ui.chatting.c.b.d)parama.ay(com.tencent.mm.ui.chatting.c.b.d.class);
      ((Intent)localObject1).putExtra("prePublishId", "msg_" + Long.toString(parambi.field_msgSvrId));
      ((Intent)localObject1).putExtra("preUsername", com.tencent.mm.ui.chatting.viewitems.c.a(parambi, paramView.zvB, ((com.tencent.mm.ui.chatting.c.b.d)localObject3).dHv()));
      ((Intent)localObject1).putExtra("preChatName", parama.getTalkerUserName());
      ((Intent)localObject1).putExtra("preMsgIndex", paramView.uXa);
      localObject3 = paramView.zYL;
      j = i;
      if (localObject3 != null) {
        ((Intent)localObject1).putExtras((Bundle)localObject3);
      }
    }
    for (j = i;; j = 0)
    {
      ((Bundle)localObject2).putInt("snsWebSource", j);
      ((Intent)localObject1).putExtra("jsapiargs", (Bundle)localObject2);
      ((Intent)localObject1).putExtra("geta8key_username", parama.getTalkerUserName());
      if (!bo.isNullOrNil(paramView.cGN))
      {
        ((Intent)localObject1).putExtra("srcUsername", paramView.cGN);
        ((Intent)localObject1).putExtra("srcDisplayname", paramView.cGO);
        ((Intent)localObject1).putExtra("mode", 1);
      }
      ((Intent)localObject1).putExtra("message_id", paramView.uWZ);
      ((Intent)localObject1).putExtra("message_index", paramView.uXa);
      ((Intent)localObject1).putExtra("from_scence", 1);
      ((Intent)localObject1).putExtra("start_activity_time", l);
      ((Intent)localObject1).putExtra(e.l.yVt, paramView.zYN);
      ((Intent)localObject1).addFlags(536870912);
      i = parama.zJz.getContext().getIntent().getIntExtra("KOpenArticleSceneFromScene", 10000);
      if ((((b)g.E(b.class)).rU(2)) && (((b)g.E(b.class)).a(parama.zJz.getContext(), paramView.userName, paramView.zYN, false, 0, i, (Intent)localObject1))) {
        ab.i("MicroMsg.WebViewClickListener", "jump to TmplWebview");
      }
      for (;;)
      {
        if (!bo.isNullOrNil(parama.getTalkerUserName()))
        {
          aw.aaz();
          if (com.tencent.mm.model.c.YA().arw(parama.getTalkerUserName()).dqS == 1)
          {
            aw.aaz();
            com.tencent.mm.model.c.YF().arM(parama.getTalkerUserName());
          }
        }
        if ((parambi == null) || (!parambi.dvV())) {
          break label1074;
        }
        localObject1 = ((com.tencent.mm.plugin.biz.a.a)g.E(com.tencent.mm.plugin.biz.a.a.class)).b(parambi.field_msgId, parambi.field_content);
        if ((localObject1 != null) && (((p)localObject1).fjy != null) && (((p)localObject1).fjy.size() > paramView.uXa)) {
          break;
        }
        AppMethodBeat.o(30734);
        return;
        com.tencent.mm.bq.d.b(parama.zJz.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
      }
      i = 0;
      paramView = (q)((p)localObject1).fjy.get(paramView.uXa);
      if (!bo.isNullOrNil(paramView.url)) {}
      for (;;)
      {
        try
        {
          paramView = Uri.parse(paramView.url);
          l = bo.getLong(paramView.getQueryParameter("mid"), 0L);
          int m;
          label1074:
          l = 0L;
        }
        catch (UnsupportedOperationException paramView)
        {
          try
          {
            j = bo.getInt(paramView.getQueryParameter("idx"), 0);
            i = j;
            j = parama.zJz.getIntExtra("specific_chat_from_scene", 0);
            m = s.getSessionId();
            h.qsU.e(16243, new Object[] { parambi.field_talker, Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(m), Integer.valueOf(2), Integer.valueOf(k), Integer.valueOf(l.LZ()) });
            AppMethodBeat.o(30734);
            return;
          }
          catch (Exception paramView)
          {
            continue;
          }
          catch (UnsupportedOperationException paramView)
          {
            continue;
          }
          paramView = paramView;
          l = 0L;
          ab.w("MicroMsg.WebViewClickListener", "Report 16243 exp %s", new Object[] { paramView.getMessage() });
        }
        catch (Exception paramView)
        {
          l = 0L;
          ab.w("MicroMsg.WebViewClickListener", "Report 16243 exp %s", new Object[] { paramView.getMessage() });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.s.p
 * JD-Core Version:    0.7.0.1
 */
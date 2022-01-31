package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.tencent.mm.ae.i;
import com.tencent.mm.ae.l;
import com.tencent.mm.ae.m;
import com.tencent.mm.br.d;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.s;
import com.tencent.mm.ui.chatting.viewitems.aw;
import com.tencent.mm.ui.chatting.viewitems.u.b;
import com.tencent.mm.ui.x;
import java.util.LinkedList;
import java.util.Map;

public final class t$o
  extends t.d
{
  public t$o(com.tencent.mm.ui.chatting.c.a parama)
  {
    super(parama);
  }
  
  public final void a(View paramView, com.tencent.mm.ui.chatting.c.a parama, bi parambi)
  {
    paramView = (aw)paramView.getTag();
    int j = 0;
    y.d("MicroMsg.WebViewClickListener", "edw timestamp, onClick = " + System.currentTimeMillis());
    if (f.a(paramView.ceb, parama.vtz.getContext(), null, parama.getTalkerUserName())) {}
    do
    {
      return;
      localObject1 = paramView.userName;
      localObject2 = paramView.vHk;
    } while ((localObject1 == null) || (((String)localObject1).equals("")));
    Object localObject3 = i.g((String)localObject1, -1, parama.vtz.getIntExtra("KOpenArticleSceneFromScene", -1));
    Object localObject1 = new Intent();
    ((Intent)localObject1).putExtra("rawUrl", (String)localObject3);
    ((Intent)localObject1).putExtra("shortUrl", (String)localObject3);
    ((Intent)localObject1).putExtra("webpageTitle", (String)localObject2);
    Object localObject2 = new Bundle();
    int i;
    if (parambi != null)
    {
      if (parambi.cvl())
      {
        localObject3 = bn.s(parambi.field_content, "msg");
        if (localObject3 != null)
        {
          localObject3 = u.b.az((Map)localObject3);
          if (!bk.bl(((u.b)localObject3).dRD))
          {
            ((Intent)localObject1).putExtra("KTemplateId", ((u.b)localObject3).dRD);
            y.d("MicroMsg.WebViewClickListener", "report template msg click action, templateId(%s). srcUsername(%s)", new Object[] { ((u.b)localObject3).dRD, paramView.bYG });
            h.nFQ.f(11608, new Object[] { ((u.b)localObject3).dRD, paramView.bYG, Integer.valueOf(0) });
          }
        }
      }
      au.Hx();
      localObject3 = com.tencent.mm.model.c.Fw().abl(parambi.field_talker);
      i = j;
      if (localObject3 != null)
      {
        i = j;
        if (((ad)localObject3).cua())
        {
          i = 4;
          y.d("MicroMsg.WebViewClickListener", "hakon click biz msg %s", new Object[] { ((ao)localObject3).field_username });
        }
      }
      ((Intent)localObject1).putExtra("msg_id", parambi.field_msgId);
      ((Intent)localObject1).putExtra("KPublisherId", "msg_" + Long.toString(parambi.field_msgSvrId));
      ((Intent)localObject1).putExtra("pre_username", parambi.field_talker);
      localObject3 = (com.tencent.mm.ui.chatting.b.b.c)parama.ac(com.tencent.mm.ui.chatting.b.b.c.class);
      ((Intent)localObject1).putExtra("prePublishId", "msg_" + Long.toString(parambi.field_msgSvrId));
      ((Intent)localObject1).putExtra("preUsername", com.tencent.mm.ui.chatting.viewitems.c.a(parambi, paramView.vgB, ((com.tencent.mm.ui.chatting.b.b.c)localObject3).cDG()));
      ((Intent)localObject1).putExtra("preChatName", parama.getTalkerUserName());
      ((Intent)localObject1).putExtra("preChatTYPE", t.R(com.tencent.mm.ui.chatting.viewitems.c.a(parambi, paramView.vgB, ((com.tencent.mm.ui.chatting.b.b.c)localObject3).cDG()), parama.getTalkerUserName()));
      ((Intent)localObject1).putExtra("preMsgIndex", paramView.rgM);
      localObject3 = paramView.vHq;
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
      if (!bk.bl(paramView.bYG))
      {
        ((Intent)localObject1).putExtra("srcUsername", paramView.bYG);
        ((Intent)localObject1).putExtra("srcDisplayname", paramView.bYH);
        ((Intent)localObject1).putExtra("mode", 1);
      }
      ((Intent)localObject1).putExtra("message_id", paramView.rgL);
      ((Intent)localObject1).putExtra("message_index", paramView.rgM);
      ((Intent)localObject1).putExtra("from_scence", 1);
      ((Intent)localObject1).addFlags(536870912);
      d.b(parama.vtz.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
      if (!bk.bl(parama.getTalkerUserName()))
      {
        au.Hx();
        if (com.tencent.mm.model.c.Fw().abl(parama.getTalkerUserName()).cCI == 1)
        {
          au.Hx();
          com.tencent.mm.model.c.FB().abA(parama.getTalkerUserName());
        }
      }
      if (!parambi.ctz()) {
        break;
      }
      localObject1 = ((com.tencent.mm.plugin.biz.a.a)g.r(com.tencent.mm.plugin.biz.a.a.class)).d(parambi.field_msgId, parambi.field_content);
      if ((localObject1 == null) || (((l)localObject1).dTx == null) || (((l)localObject1).dTx.size() <= paramView.rgM)) {
        break;
      }
      i = 0;
      paramView = (m)((l)localObject1).dTx.get(paramView.rgM);
      if (!bk.bl(paramView.url)) {}
      for (;;)
      {
        try
        {
          paramView = Uri.parse(paramView.url);
          long l = bk.getLong(paramView.getQueryParameter("mid"), 0L);
          int k;
          l = 0L;
        }
        catch (UnsupportedOperationException paramView)
        {
          try
          {
            j = bk.getInt(paramView.getQueryParameter("idx"), 0);
            i = j;
            j = parama.vtz.getIntExtra("specific_chat_from_scene", 0);
            k = s.getSessionId();
            h.nFQ.f(16243, new Object[] { parambi.field_talker, Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
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
          y.w("MicroMsg.WebViewClickListener", "Report 16243 exp %s", new Object[] { paramView.getMessage() });
        }
        catch (Exception paramView)
        {
          l = 0L;
          y.w("MicroMsg.WebViewClickListener", "Report 16243 exp %s", new Object[] { paramView.getMessage() });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.t.o
 * JD-Core Version:    0.7.0.1
 */
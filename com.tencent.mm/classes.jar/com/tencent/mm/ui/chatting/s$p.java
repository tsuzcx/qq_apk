package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.u;
import com.tencent.mm.ai.v;
import com.tencent.mm.am.l;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.ba;
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.y;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.viewitems.ai.b;
import com.tencent.mm.ui.chatting.viewitems.bk;
import com.tencent.mm.ui.e.m;
import java.util.LinkedList;
import java.util.Map;

public final class s$p
  extends s.e
{
  public s$p(com.tencent.mm.ui.chatting.e.a parama)
  {
    super(parama);
  }
  
  public final void a(View paramView, com.tencent.mm.ui.chatting.e.a parama, bu parambu)
  {
    AppMethodBeat.i(34608);
    paramView = (bk)paramView.getTag();
    int j = 0;
    long l = System.currentTimeMillis();
    int k = (int)(l / 1000L);
    ad.i("MicroMsg.WebViewClickListener", "WebViewClickListener onClick = %d", new Object[] { Integer.valueOf(k) });
    if (e.a(paramView.dNL, parama.JOR.getContext(), null, parama.getTalkerUserName()))
    {
      AppMethodBeat.o(34608);
      return;
    }
    Object localObject1 = paramView.userName;
    Object localObject2 = paramView.Khu;
    if ((localObject1 == null) || (((String)localObject1).equals("")))
    {
      AppMethodBeat.o(34608);
      return;
    }
    localObject1 = m.d((String)localObject1, 0, parama.JOR.getIntExtra("KOpenArticleSceneFromScene", 10000), k);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", (String)localObject1);
    localIntent.putExtra("shortUrl", (String)localObject1);
    localIntent.putExtra("webpageTitle", (String)localObject2);
    localObject2 = new Bundle();
    int i;
    if (parambu != null)
    {
      if (parambu.frC())
      {
        localObject3 = bw.M(parambu.field_content, "msg");
        if (localObject3 != null)
        {
          localObject3 = ai.b.bX((Map)localObject3);
          if (!bt.isNullOrNil(((ai.b)localObject3).hAT))
          {
            localIntent.putExtra("KTemplateId", ((ai.b)localObject3).hAT);
            ad.d("MicroMsg.WebViewClickListener", "report template msg click action, templateId(%s). srcUsername(%s)", new Object[] { ((ai.b)localObject3).hAT, paramView.dHo });
            com.tencent.mm.plugin.report.service.g.yhR.f(11608, new Object[] { ((ai.b)localObject3).hAT, paramView.dHo, Integer.valueOf(0) });
          }
        }
      }
      ba.aBQ();
      Object localObject3 = com.tencent.mm.model.c.azp().Bf(parambu.field_talker);
      i = j;
      if (localObject3 != null)
      {
        i = j;
        if (((am)localObject3).fqg())
        {
          i = 4;
          ad.d("MicroMsg.WebViewClickListener", "hakon click biz msg %s", new Object[] { ((aw)localObject3).field_username });
          localIntent.putExtra("geta8key_scene", 7);
        }
      }
      localIntent.putExtra("msg_id", parambu.field_msgId);
      localIntent.putExtra("KPublisherId", "msg_" + Long.toString(parambu.field_msgSvrId));
      localIntent.putExtra("pre_username", parambu.field_talker);
      localObject3 = (com.tencent.mm.ui.chatting.d.b.d)parama.bh(com.tencent.mm.ui.chatting.d.b.d.class);
      localIntent.putExtra("prePublishId", "msg_" + Long.toString(parambu.field_msgSvrId));
      localIntent.putExtra("preUsername", com.tencent.mm.ui.chatting.viewitems.c.a(parambu, paramView.Jxs, ((com.tencent.mm.ui.chatting.d.b.d)localObject3).fCH()));
      localIntent.putExtra("preChatName", parama.getTalkerUserName());
      localIntent.putExtra("preMsgIndex", paramView.DUB);
      localObject3 = paramView.Khz;
      j = i;
      if (localObject3 != null) {
        localIntent.putExtras((Bundle)localObject3);
      }
    }
    for (j = i;; j = 0)
    {
      ((Bundle)localObject2).putInt("snsWebSource", j);
      localIntent.putExtra("jsapiargs", (Bundle)localObject2);
      localIntent.putExtra("geta8key_username", parama.getTalkerUserName());
      if (!bt.isNullOrNil(paramView.dHo))
      {
        localIntent.putExtra("srcUsername", paramView.dHo);
        localIntent.putExtra("srcDisplayname", paramView.dHp);
        localIntent.putExtra("mode", 1);
      }
      localIntent.putExtra("message_id", paramView.DUA);
      localIntent.putExtra("message_index", paramView.DUB);
      localIntent.putExtra("from_scence", 1);
      localIntent.putExtra("start_activity_time", l);
      localIntent.putExtra(e.m.IUR, paramView.KhB);
      com.tencent.mm.ui.chatting.viewitems.c.t(localIntent, parama.getTalkerUserName());
      localIntent.addFlags(536870912);
      i = parama.JOR.getContext().getIntent().getIntExtra("KOpenArticleSceneFromScene", 10000);
      if ((((b)com.tencent.mm.kernel.g.ab(b.class)).zc(2)) && (((b)com.tencent.mm.kernel.g.ab(b.class)).a(parama.JOR.getContext(), (String)localObject1, paramView.KhB, 0, i, localIntent))) {
        ad.i("MicroMsg.WebViewClickListener", "jump to TmplWebview");
      }
      for (;;)
      {
        if (!bt.isNullOrNil(parama.getTalkerUserName()))
        {
          ba.aBQ();
          if (com.tencent.mm.model.c.azp().Bf(parama.getTalkerUserName()).ePC == 1)
          {
            ba.aBQ();
            com.tencent.mm.model.c.azv().aTE(parama.getTalkerUserName());
          }
        }
        if ((parambu == null) || (!parambu.fpd())) {
          break label1102;
        }
        localObject1 = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).a(parambu.field_msgId, parambu.field_content);
        if ((localObject1 != null) && (((u)localObject1).hDb != null) && (((u)localObject1).hDb.size() > paramView.DUB)) {
          break;
        }
        AppMethodBeat.o(34608);
        return;
        localIntent.putExtra("rawUrl", (String)localObject1);
        com.tencent.mm.bs.d.b(parama.JOR.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
      }
      i = 0;
      paramView = (v)((u)localObject1).hDb.get(paramView.DUB);
      if (!bt.isNullOrNil(paramView.url)) {}
      for (;;)
      {
        try
        {
          paramView = Uri.parse(paramView.url);
          l = bt.getLong(paramView.getQueryParameter("mid"), 0L);
          int m;
          label1102:
          l = 0L;
        }
        catch (UnsupportedOperationException paramView)
        {
          try
          {
            j = bt.getInt(paramView.getQueryParameter("idx"), 0);
            i = j;
            j = parama.JOR.getIntExtra("specific_chat_from_scene", 0);
            m = y.getSessionId();
            com.tencent.mm.plugin.report.service.g.yhR.f(16243, new Object[] { parambu.field_talker, Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(m), Integer.valueOf(2), Integer.valueOf(k), Integer.valueOf(m.aaW()) });
            l.I(parambu);
            AppMethodBeat.o(34608);
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
          ad.w("MicroMsg.WebViewClickListener", "Report 16243 exp %s", new Object[] { paramView.getMessage() });
        }
        catch (Exception paramView)
        {
          l = 0L;
          ad.w("MicroMsg.WebViewClickListener", "Report 16243 exp %s", new Object[] { paramView.getMessage() });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.s.p
 * JD-Core Version:    0.7.0.1
 */
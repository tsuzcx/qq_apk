package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.m;
import com.tencent.mm.ag.u;
import com.tencent.mm.ag.v;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.ca;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.d.b.d;
import com.tencent.mm.ui.chatting.viewitems.ao.b;
import com.tencent.mm.ui.chatting.viewitems.bq;
import com.tencent.mm.ui.e.p;
import java.util.LinkedList;
import java.util.Map;

public final class t$p
  extends t.e
{
  public t$p(com.tencent.mm.ui.chatting.e.a parama)
  {
    super(parama);
  }
  
  public final void a(View paramView, com.tencent.mm.ui.chatting.e.a parama, ca paramca)
  {
    AppMethodBeat.i(34608);
    paramView = (bq)paramView.getTag();
    int j = 0;
    long l = System.currentTimeMillis();
    int k = (int)(l / 1000L);
    Log.i("MicroMsg.WebViewClickListener", "WebViewClickListener onClick = %d", new Object[] { Integer.valueOf(k) });
    if (e.a(paramView.egX, parama.Pwc.getContext(), null, parama.getTalkerUserName()))
    {
      AppMethodBeat.o(34608);
      return;
    }
    Object localObject1 = paramView.userName;
    Object localObject2 = paramView.Nwj;
    if ((localObject1 == null) || (((String)localObject1).equals("")))
    {
      AppMethodBeat.o(34608);
      return;
    }
    localObject1 = m.d((String)localObject1, 0, parama.Pwc.getIntExtra("KOpenArticleSceneFromScene", 10000), k);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", (String)localObject1);
    localIntent.putExtra("shortUrl", (String)localObject1);
    localIntent.putExtra("webpageTitle", (String)localObject2);
    localObject2 = new Bundle();
    int i;
    if (paramca != null)
    {
      if (paramca.gDj())
      {
        localObject3 = XmlParser.parseXml(paramca.field_content, "msg", null);
        if (localObject3 != null)
        {
          localObject3 = ao.b.ci((Map)localObject3);
          if (!Util.isNullOrNil(((ao.b)localObject3).ixM))
          {
            localIntent.putExtra("KTemplateId", ((ao.b)localObject3).ixM);
            Log.d("MicroMsg.WebViewClickListener", "report template msg click action, templateId(%s). srcUsername(%s)", new Object[] { ((ao.b)localObject3).ixM, paramView.eag });
            h.CyF.a(11608, new Object[] { ((ao.b)localObject3).ixM, paramView.eag, Integer.valueOf(0) });
          }
        }
      }
      bg.aVF();
      Object localObject3 = com.tencent.mm.model.c.aSN().Kn(paramca.field_talker);
      i = j;
      if (localObject3 != null)
      {
        i = j;
        if (((as)localObject3).gBM())
        {
          i = 4;
          Log.d("MicroMsg.WebViewClickListener", "hakon click biz msg %s", new Object[] { ((ax)localObject3).field_username });
          localIntent.putExtra("geta8key_scene", 7);
        }
      }
      localIntent.putExtra("msg_id", paramca.field_msgId);
      localIntent.putExtra("KPublisherId", "msg_" + Long.toString(paramca.field_msgSvrId));
      localIntent.putExtra("pre_username", paramca.field_talker);
      localObject3 = (d)parama.bh(d.class);
      localIntent.putExtra("prePublishId", "msg_" + Long.toString(paramca.field_msgSvrId));
      localIntent.putExtra("preUsername", com.tencent.mm.ui.chatting.viewitems.c.a(paramca, paramView.Pdm, ((d)localObject3).gOP()));
      localIntent.putExtra("preChatName", parama.getTalkerUserName());
      localIntent.putExtra("preMsgIndex", paramView.IZD);
      localObject3 = paramView.PQH;
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
      if (!Util.isNullOrNil(paramView.eag))
      {
        localIntent.putExtra("srcUsername", paramView.eag);
        localIntent.putExtra("srcDisplayname", paramView.eah);
        localIntent.putExtra("mode", 1);
      }
      localIntent.putExtra("message_id", paramView.IZC);
      localIntent.putExtra("message_index", paramView.IZD);
      localIntent.putExtra("from_scence", 1);
      localIntent.putExtra("start_activity_time", l);
      localIntent.putExtra(e.p.OzA, paramView.PQJ);
      com.tencent.mm.ui.chatting.viewitems.c.r(localIntent, parama.getTalkerUserName());
      localIntent.addFlags(536870912);
      i = parama.Pwc.getContext().getIntent().getIntExtra("KOpenArticleSceneFromScene", 10000);
      if ((((b)g.af(b.class)).CR(2)) && (((b)g.af(b.class)).a(parama.Pwc.getContext(), (String)localObject1, paramView.PQJ, 0, i, localIntent))) {
        Log.i("MicroMsg.WebViewClickListener", "jump to TmplWebview");
      }
      for (;;)
      {
        if (!Util.isNullOrNil(parama.getTalkerUserName()))
        {
          bg.aVF();
          if (com.tencent.mm.model.c.aSN().Kn(parama.getTalkerUserName()).fuQ == 1)
          {
            bg.aVF();
            com.tencent.mm.model.c.aST().bkd(parama.getTalkerUserName());
          }
        }
        if ((paramca == null) || (!paramca.gAt())) {
          break label1104;
        }
        localObject1 = ((com.tencent.mm.plugin.biz.a.a)g.af(com.tencent.mm.plugin.biz.a.a.class)).a(paramca.field_msgId, paramca.field_content);
        if ((localObject1 != null) && (((u)localObject1).iAd != null) && (((u)localObject1).iAd.size() > paramView.IZD)) {
          break;
        }
        AppMethodBeat.o(34608);
        return;
        localIntent.putExtra("rawUrl", (String)localObject1);
        com.tencent.mm.br.c.b(parama.Pwc.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
      }
      i = 0;
      paramView = (v)((u)localObject1).iAd.get(paramView.IZD);
      if (!Util.isNullOrNil(paramView.url)) {}
      for (;;)
      {
        try
        {
          paramView = Uri.parse(paramView.url);
          l = Util.getLong(paramView.getQueryParameter("mid"), 0L);
          int m;
          label1104:
          l = 0L;
        }
        catch (UnsupportedOperationException paramView)
        {
          try
          {
            j = Util.getInt(paramView.getQueryParameter("idx"), 0);
            i = j;
            j = parama.Pwc.getIntExtra("specific_chat_from_scene", 0);
            m = ab.getSessionId();
            h.CyF.a(16243, new Object[] { paramca.field_talker, Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(m), Integer.valueOf(2), Integer.valueOf(k), Integer.valueOf(m.ape()) });
            com.tencent.mm.ui.chatting.viewitems.c.c(parama, paramca);
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
          Log.w("MicroMsg.WebViewClickListener", "Report 16243 exp %s", new Object[] { paramView.getMessage() });
        }
        catch (Exception paramView)
        {
          l = 0L;
          Log.w("MicroMsg.WebViewClickListener", "Report 16243 exp %s", new Object[] { paramView.getMessage() });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.t.p
 * JD-Core Version:    0.7.0.1
 */
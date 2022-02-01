package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.m;
import com.tencent.mm.aj.u;
import com.tencent.mm.aj.v;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.bh;
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
import com.tencent.mm.ui.chatting.viewitems.ar.b;
import com.tencent.mm.ui.chatting.viewitems.by;
import com.tencent.mm.ui.f.r;
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
    paramView = (by)paramView.getTag();
    int j = 0;
    long l = System.currentTimeMillis();
    int k = (int)(l / 1000L);
    Log.i("MicroMsg.WebViewClickListener", "WebViewClickListener onClick = %d", new Object[] { Integer.valueOf(k) });
    if (e.a(paramView.gbn, parama.WQv.getContext(), null, parama.getTalkerUserName()))
    {
      AppMethodBeat.o(34608);
      return;
    }
    Object localObject1 = paramView.userName;
    Object localObject2 = paramView.UJu;
    if ((localObject1 == null) || (((String)localObject1).equals("")))
    {
      AppMethodBeat.o(34608);
      return;
    }
    localObject1 = m.e((String)localObject1, 0, parama.WQv.getIntExtra("KOpenArticleSceneFromScene", 10000), k);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", (String)localObject1);
    localIntent.putExtra("shortUrl", (String)localObject1);
    localIntent.putExtra("webpageTitle", (String)localObject2);
    localObject2 = new Bundle();
    int i;
    if (paramca != null)
    {
      if (paramca.hzw())
      {
        localObject3 = XmlParser.parseXml(paramca.field_content, "msg", null);
        if (localObject3 != null)
        {
          localObject3 = ar.b.co((Map)localObject3);
          if (!Util.isNullOrNil(((ar.b)localObject3).lnb))
          {
            localIntent.putExtra("KTemplateId", ((ar.b)localObject3).lnb);
            Log.d("MicroMsg.WebViewClickListener", "report template msg click action, templateId(%s). srcUsername(%s)", new Object[] { ((ar.b)localObject3).lnb, paramView.fUd });
            com.tencent.mm.plugin.report.service.h.IzE.a(11608, new Object[] { ((ar.b)localObject3).lnb, paramView.fUd, Integer.valueOf(0) });
          }
        }
      }
      bh.beI();
      Object localObject3 = com.tencent.mm.model.c.bbL().RG(paramca.field_talker);
      i = j;
      if (localObject3 != null)
      {
        i = j;
        if (((as)localObject3).hxX())
        {
          i = 4;
          Log.d("MicroMsg.WebViewClickListener", "hakon click biz msg %s", new Object[] { ((ax)localObject3).field_username });
          localIntent.putExtra("geta8key_scene", 7);
        }
      }
      localIntent.putExtra("msg_id", paramca.field_msgId);
      localIntent.putExtra("KPublisherId", "msg_" + Long.toString(paramca.field_msgSvrId));
      localIntent.putExtra("pre_username", paramca.field_talker);
      localObject3 = (d)parama.bC(d.class);
      localIntent.putExtra("prePublishId", "msg_" + Long.toString(paramca.field_msgSvrId));
      localIntent.putExtra("preUsername", com.tencent.mm.ui.chatting.viewitems.c.b(paramca, paramView.Wwx, ((d)localObject3).hOe()));
      localIntent.putExtra("preChatName", parama.getTalkerUserName());
      localIntent.putExtra("preMsgIndex", paramView.PVU);
      localObject3 = paramView.XmN;
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
      if (!Util.isNullOrNil(paramView.fUd))
      {
        localIntent.putExtra("srcUsername", paramView.fUd);
        localIntent.putExtra("srcDisplayname", paramView.fUe);
        localIntent.putExtra("mode", 1);
      }
      localIntent.putExtra("message_id", paramView.PVT);
      localIntent.putExtra("message_index", paramView.PVU);
      localIntent.putExtra("from_scence", 1);
      localIntent.putExtra("start_activity_time", l);
      localIntent.putExtra(f.r.VSO, paramView.XmP);
      com.tencent.mm.ui.chatting.viewitems.c.q(localIntent, parama.getTalkerUserName());
      localIntent.addFlags(536870912);
      i = parama.WQv.getContext().getIntent().getIntExtra("KOpenArticleSceneFromScene", 10000);
      if ((((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).Gw(2)) && (((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).a(parama.WQv.getContext(), (String)localObject1, paramView.XmP, 0, i, localIntent))) {
        Log.i("MicroMsg.WebViewClickListener", "jump to TmplWebview");
      }
      for (;;)
      {
        if (!Util.isNullOrNil(parama.getTalkerUserName()))
        {
          bh.beI();
          if (com.tencent.mm.model.c.bbL().RG(parama.getTalkerUserName()).hDp == 1)
          {
            bh.beI();
            com.tencent.mm.model.c.bbR().bwC(parama.getTalkerUserName());
          }
        }
        if ((paramca == null) || (!paramca.hwA())) {
          break label1104;
        }
        localObject1 = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.biz.a.a.class)).b(paramca.field_msgId, paramca.field_content);
        if ((localObject1 != null) && (((u)localObject1).lpz != null) && (((u)localObject1).lpz.size() > paramView.PVU)) {
          break;
        }
        AppMethodBeat.o(34608);
        return;
        localIntent.putExtra("rawUrl", (String)localObject1);
        com.tencent.mm.by.c.b(parama.WQv.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
      }
      i = 0;
      paramView = (v)((u)localObject1).lpz.get(paramView.PVU);
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
            j = parama.WQv.getIntExtra("specific_chat_from_scene", 0);
            m = ab.getSessionId();
            com.tencent.mm.plugin.report.service.h.IzE.a(16243, new Object[] { paramca.field_talker, Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(m), Integer.valueOf(2), Integer.valueOf(k), Integer.valueOf(m.avq()) });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.t.p
 * JD-Core Version:    0.7.0.1
 */
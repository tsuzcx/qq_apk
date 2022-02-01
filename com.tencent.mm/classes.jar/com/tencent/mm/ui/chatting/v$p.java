package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.message.m;
import com.tencent.mm.message.u;
import com.tencent.mm.message.v;
import com.tencent.mm.model.bh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.component.api.e;
import com.tencent.mm.ui.chatting.viewitems.aq.c;
import com.tencent.mm.ui.chatting.viewitems.bz;
import com.tencent.mm.ui.f.s;
import java.util.LinkedList;
import java.util.Map;

public final class v$p
  extends v.e
{
  public v$p(com.tencent.mm.ui.chatting.d.a parama)
  {
    super(parama);
  }
  
  public final void a(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    AppMethodBeat.i(34608);
    paramView = (bz)paramView.getTag();
    int j = 0;
    long l = System.currentTimeMillis();
    int k = (int)(l / 1000L);
    Log.i("MicroMsg.WebViewClickListener", "WebViewClickListener onClick = %d", new Object[] { Integer.valueOf(k) });
    if (f.a(paramView.ihx, parama.aezO.getContext(), null, parama.getTalkerUserName()))
    {
      AppMethodBeat.o(34608);
      return;
    }
    Object localObject1 = paramView.userName;
    Object localObject2 = paramView.acdC;
    if ((localObject1 == null) || (((String)localObject1).equals("")))
    {
      AppMethodBeat.o(34608);
      return;
    }
    localObject1 = m.e((String)localObject1, 0, parama.aezO.getIntExtra("KOpenArticleSceneFromScene", 10000), k);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", (String)localObject1);
    localIntent.putExtra("shortUrl", (String)localObject1);
    localIntent.putExtra("webpageTitle", (String)localObject2);
    localObject2 = new Bundle();
    int i;
    if (paramcc != null)
    {
      if (paramcc.jbz())
      {
        localObject3 = XmlParser.parseXml(paramcc.field_content, "msg", null);
        if (localObject3 != null)
        {
          localObject3 = aq.c.cM((Map)localObject3);
          if ((localObject3 != null) && (!Util.isNullOrNil(((aq.c)localObject3).nSg)))
          {
            localIntent.putExtra("KTemplateId", ((aq.c)localObject3).nSg);
            Log.d("MicroMsg.WebViewClickListener", "report template msg click action, templateId(%s). srcUsername(%s)", new Object[] { ((aq.c)localObject3).nSg, paramView.iaa });
            com.tencent.mm.plugin.report.service.h.OAn.b(11608, new Object[] { ((aq.c)localObject3).nSg, paramView.iaa, Integer.valueOf(0) });
          }
        }
      }
      bh.bCz();
      Object localObject3 = com.tencent.mm.model.c.bzA().JE(paramcc.field_talker);
      i = j;
      if (localObject3 != null)
      {
        i = j;
        if (((au)localObject3).iZC())
        {
          i = 4;
          Log.d("MicroMsg.WebViewClickListener", "hakon click biz msg %s", new Object[] { ((az)localObject3).field_username });
          localIntent.putExtra("geta8key_scene", 7);
        }
      }
      localIntent.putExtra("msg_id", paramcc.field_msgId);
      localIntent.putExtra("KPublisherId", "msg_" + Long.toString(paramcc.field_msgSvrId));
      localIntent.putExtra("pre_username", paramcc.field_talker);
      localObject3 = (e)parama.cm(e.class);
      localIntent.putExtra("prePublishId", "msg_" + Long.toString(paramcc.field_msgSvrId));
      localIntent.putExtra("preUsername", com.tencent.mm.ui.chatting.viewitems.c.b(paramcc, paramView.aedO, ((e)localObject3).jqV()));
      localIntent.putExtra("preChatName", parama.getTalkerUserName());
      localIntent.putExtra("preMsgIndex", paramView.WMC);
      localObject3 = paramView.aeXS;
      j = i;
      if (localObject3 != null) {
        localIntent.putExtras((Bundle)localObject3);
      }
    }
    for (j = i;; j = 0)
    {
      ((Bundle)localObject2).putInt("snsWebSource", j);
      localIntent.putExtra("jsapiargs", (Bundle)localObject2);
      if (("notifymessage".equals(parama.getTalkerUserName())) && (!Util.isNullOrNil(paramView.iaa)))
      {
        localIntent.putExtra("geta8key_username", paramView.iaa);
        if (!Util.isNullOrNil(paramView.iaa))
        {
          localIntent.putExtra("srcUsername", paramView.iaa);
          localIntent.putExtra("srcDisplayname", paramView.iab);
          localIntent.putExtra("mode", 1);
        }
        localIntent.putExtra("message_id", paramView.WMB);
        localIntent.putExtra("message_index", paramView.WMC);
        localIntent.putExtra("from_scence", 1);
        localIntent.putExtra("start_activity_time", l);
        localIntent.putExtra(f.s.adwW, paramView.aeXU);
        localIntent.putExtra("webpageTitle", paramView.aeXV);
        localIntent.putExtra("thumbUrl", paramView.thumbUrl);
        localIntent.putExtra("key_enable_teen_mode_check", true);
        com.tencent.mm.ui.chatting.viewitems.c.s(localIntent, parama.getTalkerUserName());
        localIntent.addFlags(536870912);
        i = parama.aezO.getContext().getIntent().getIntExtra("KOpenArticleSceneFromScene", 10000);
        if ((!((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).GV(2)) || (!((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).a(parama.aezO.getContext(), (String)localObject1, paramView.aeXU, 0, i, localIntent))) {
          break label983;
        }
        Log.i("MicroMsg.WebViewClickListener", "jump to TmplWebview");
      }
      for (;;)
      {
        if (!Util.isNullOrNil(parama.getTalkerUserName()))
        {
          bh.bCz();
          if (com.tencent.mm.model.c.bzA().JE(parama.getTalkerUserName()).hyY == 1)
          {
            bh.bCz();
            com.tencent.mm.model.c.bzG().bxS(parama.getTalkerUserName());
          }
        }
        if ((paramcc == null) || (!paramcc.iYe())) {
          break label1183;
        }
        localObject1 = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.biz.a.a.class)).c(paramcc.field_msgId, paramcc.field_content);
        if ((localObject1 != null) && (((u)localObject1).nUC != null) && (((u)localObject1).nUC.size() > paramView.WMC)) {
          break label1014;
        }
        AppMethodBeat.o(34608);
        return;
        localIntent.putExtra("geta8key_username", parama.getTalkerUserName());
        break;
        label983:
        localIntent.putExtra("rawUrl", (String)localObject1);
        com.tencent.mm.br.c.b(parama.aezO.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
      }
      label1014:
      i = 0;
      paramView = (v)((u)localObject1).nUC.get(paramView.WMC);
      if (!Util.isNullOrNil(paramView.url)) {}
      for (;;)
      {
        try
        {
          paramView = Uri.parse(paramView.url);
          l = Util.getLong(paramView.getQueryParameter("mid"), 0L);
          int m;
          label1183:
          l = 0L;
        }
        catch (UnsupportedOperationException paramView)
        {
          try
          {
            j = Util.getInt(paramView.getQueryParameter("idx"), 0);
            i = j;
            j = parama.aezO.getIntExtra("specific_chat_from_scene", 0);
            m = ad.getSessionId();
            com.tencent.mm.plugin.report.service.h.OAn.b(16243, new Object[] { paramcc.field_talker, Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(m), Integer.valueOf(2), Integer.valueOf(k), Integer.valueOf(m.aPK()) });
            com.tencent.mm.ui.chatting.viewitems.c.c(parama, paramcc);
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
 * Qualified Name:     com.tencent.mm.ui.chatting.v.p
 * JD-Core Version:    0.7.0.1
 */
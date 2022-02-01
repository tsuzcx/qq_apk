package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.u;
import com.tencent.mm.g.c.av;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.bo;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.viewitems.ah.b;
import com.tencent.mm.ui.e.m;
import java.util.LinkedList;
import java.util.Map;

public final class s$p
  extends s.e
{
  public s$p(com.tencent.mm.ui.chatting.d.a parama)
  {
    super(parama);
  }
  
  public final void a(View paramView, com.tencent.mm.ui.chatting.d.a parama, bo parambo)
  {
    AppMethodBeat.i(34608);
    paramView = (com.tencent.mm.ui.chatting.viewitems.bj)paramView.getTag();
    int j = 0;
    long l = System.currentTimeMillis();
    int k = (int)(l / 1000L);
    ac.i("MicroMsg.WebViewClickListener", "WebViewClickListener onClick = %d", new Object[] { Integer.valueOf(k) });
    if (e.a(paramView.dBy, parama.HZF.getContext(), null, parama.getTalkerUserName()))
    {
      AppMethodBeat.o(34608);
      return;
    }
    Object localObject1 = paramView.userName;
    Object localObject2 = paramView.IqR;
    if ((localObject1 == null) || (((String)localObject1).equals("")))
    {
      AppMethodBeat.o(34608);
      return;
    }
    localObject1 = m.d((String)localObject1, 0, parama.HZF.getIntExtra("KOpenArticleSceneFromScene", 10000), k);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", (String)localObject1);
    localIntent.putExtra("shortUrl", (String)localObject1);
    localIntent.putExtra("webpageTitle", (String)localObject2);
    localObject2 = new Bundle();
    int i;
    if (parambo != null)
    {
      if (parambo.fbz())
      {
        localObject3 = bv.L(parambo.field_content, "msg");
        if (localObject3 != null)
        {
          localObject3 = ah.b.bR((Map)localObject3);
          if (!bs.isNullOrNil(((ah.b)localObject3).hiK))
          {
            localIntent.putExtra("KTemplateId", ((ah.b)localObject3).hiK);
            ac.d("MicroMsg.WebViewClickListener", "report template msg click action, templateId(%s). srcUsername(%s)", new Object[] { ((ah.b)localObject3).hiK, paramView.dvl });
            h.wUl.f(11608, new Object[] { ((ah.b)localObject3).hiK, paramView.dvl, Integer.valueOf(0) });
          }
        }
      }
      az.ayM();
      Object localObject3 = com.tencent.mm.model.c.awB().aNt(parambo.field_talker);
      i = j;
      if (localObject3 != null)
      {
        i = j;
        if (((ai)localObject3).fad())
        {
          i = 4;
          ac.d("MicroMsg.WebViewClickListener", "hakon click biz msg %s", new Object[] { ((av)localObject3).field_username });
          localIntent.putExtra("geta8key_scene", 7);
        }
      }
      localIntent.putExtra("msg_id", parambo.field_msgId);
      localIntent.putExtra("KPublisherId", "msg_" + Long.toString(parambo.field_msgSvrId));
      localIntent.putExtra("pre_username", parambo.field_talker);
      localObject3 = (com.tencent.mm.ui.chatting.c.b.d)parama.bf(com.tencent.mm.ui.chatting.c.b.d.class);
      localIntent.putExtra("prePublishId", "msg_" + Long.toString(parambo.field_msgSvrId));
      localIntent.putExtra("preUsername", com.tencent.mm.ui.chatting.viewitems.c.a(parambo, paramView.HJB, ((com.tencent.mm.ui.chatting.c.b.d)localObject3).fmo()));
      localIntent.putExtra("preChatName", parama.getTalkerUserName());
      localIntent.putExtra("preMsgIndex", paramView.CqX);
      localObject3 = paramView.IqW;
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
      if (!bs.isNullOrNil(paramView.dvl))
      {
        localIntent.putExtra("srcUsername", paramView.dvl);
        localIntent.putExtra("srcDisplayname", paramView.dvm);
        localIntent.putExtra("mode", 1);
      }
      localIntent.putExtra("message_id", paramView.CqW);
      localIntent.putExtra("message_index", paramView.CqX);
      localIntent.putExtra("from_scence", 1);
      localIntent.putExtra("start_activity_time", l);
      localIntent.putExtra(e.m.HhB, paramView.IqY);
      com.tencent.mm.ui.chatting.viewitems.c.t(localIntent, parama.getTalkerUserName());
      localIntent.addFlags(536870912);
      i = parama.HZF.getContext().getIntent().getIntExtra("KOpenArticleSceneFromScene", 10000);
      if ((((b)g.ab(b.class)).ys(2)) && (((b)g.ab(b.class)).a(parama.HZF.getContext(), (String)localObject1, paramView.IqY, 0, i, localIntent))) {
        ac.i("MicroMsg.WebViewClickListener", "jump to TmplWebview");
      }
      for (;;)
      {
        if (!bs.isNullOrNil(parama.getTalkerUserName()))
        {
          az.ayM();
          if (com.tencent.mm.model.c.awB().aNt(parama.getTalkerUserName()).eyd == 1)
          {
            az.ayM();
            com.tencent.mm.model.c.awG().aNN(parama.getTalkerUserName());
          }
        }
        if ((parambo == null) || (!parambo.eZj())) {
          break label1098;
        }
        localObject1 = ((com.tencent.mm.plugin.biz.a.a)g.ab(com.tencent.mm.plugin.biz.a.a.class)).a(parambo.field_msgId, parambo.field_content);
        if ((localObject1 != null) && (((u)localObject1).hkS != null) && (((u)localObject1).hkS.size() > paramView.CqX)) {
          break;
        }
        AppMethodBeat.o(34608);
        return;
        localIntent.putExtra("rawUrl", (String)localObject1);
        com.tencent.mm.br.d.b(parama.HZF.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
      }
      i = 0;
      paramView = (com.tencent.mm.ah.v)((u)localObject1).hkS.get(paramView.CqX);
      if (!bs.isNullOrNil(paramView.url)) {}
      for (;;)
      {
        try
        {
          paramView = Uri.parse(paramView.url);
          l = bs.getLong(paramView.getQueryParameter("mid"), 0L);
          int m;
          label1098:
          l = 0L;
        }
        catch (UnsupportedOperationException paramView)
        {
          try
          {
            j = bs.getInt(paramView.getQueryParameter("idx"), 0);
            i = j;
            j = parama.HZF.getIntExtra("specific_chat_from_scene", 0);
            m = com.tencent.mm.storage.v.getSessionId();
            h.wUl.f(16243, new Object[] { parambo.field_talker, Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(m), Integer.valueOf(2), Integer.valueOf(k), Integer.valueOf(m.Yu()) });
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
          ac.w("MicroMsg.WebViewClickListener", "Report 16243 exp %s", new Object[] { paramView.getMessage() });
        }
        catch (Exception paramView)
        {
          l = 0L;
          ac.w("MicroMsg.WebViewClickListener", "Report 16243 exp %s", new Object[] { paramView.getMessage() });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.s.p
 * JD-Core Version:    0.7.0.1
 */
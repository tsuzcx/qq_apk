package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.v;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bl;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.viewitems.ag.b;
import com.tencent.mm.ui.chatting.viewitems.bi;
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
  
  public final void a(View paramView, com.tencent.mm.ui.chatting.d.a parama, bl parambl)
  {
    AppMethodBeat.i(34608);
    paramView = (bi)paramView.getTag();
    int j = 0;
    long l = System.currentTimeMillis();
    int k = (int)(l / 1000L);
    ad.i("MicroMsg.WebViewClickListener", "WebViewClickListener onClick = %d", new Object[] { Integer.valueOf(k) });
    if (e.a(paramView.dDM, parama.GzJ.getContext(), null, parama.getTalkerUserName()))
    {
      AppMethodBeat.o(34608);
      return;
    }
    Object localObject1 = paramView.userName;
    Object localObject2 = paramView.GQQ;
    if ((localObject1 == null) || (((String)localObject1).equals("")))
    {
      AppMethodBeat.o(34608);
      return;
    }
    localObject1 = m.d((String)localObject1, 0, parama.GzJ.getIntExtra("KOpenArticleSceneFromScene", 10000), k);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", (String)localObject1);
    localIntent.putExtra("shortUrl", (String)localObject1);
    localIntent.putExtra("webpageTitle", (String)localObject2);
    localObject2 = new Bundle();
    int i;
    if (parambl != null)
    {
      if (parambl.eLV())
      {
        localObject3 = bw.K(parambl.field_content, "msg");
        if (localObject3 != null)
        {
          localObject3 = ag.b.bM((Map)localObject3);
          if (!bt.isNullOrNil(((ag.b)localObject3).gIj))
          {
            localIntent.putExtra("KTemplateId", ((ag.b)localObject3).gIj);
            ad.d("MicroMsg.WebViewClickListener", "report template msg click action, templateId(%s). srcUsername(%s)", new Object[] { ((ag.b)localObject3).gIj, paramView.dxz });
            h.vKh.f(11608, new Object[] { ((ag.b)localObject3).gIj, paramView.dxz, Integer.valueOf(0) });
          }
        }
      }
      az.arV();
      Object localObject3 = com.tencent.mm.model.c.apM().aHY(parambl.field_talker);
      i = j;
      if (localObject3 != null)
      {
        i = j;
        if (((af)localObject3).eKB())
        {
          i = 4;
          ad.d("MicroMsg.WebViewClickListener", "hakon click biz msg %s", new Object[] { ((au)localObject3).field_username });
          localIntent.putExtra("geta8key_scene", 7);
        }
      }
      localIntent.putExtra("msg_id", parambl.field_msgId);
      localIntent.putExtra("KPublisherId", "msg_" + Long.toString(parambl.field_msgSvrId));
      localIntent.putExtra("pre_username", parambl.field_talker);
      localObject3 = (com.tencent.mm.ui.chatting.c.b.d)parama.be(com.tencent.mm.ui.chatting.c.b.d.class);
      localIntent.putExtra("prePublishId", "msg_" + Long.toString(parambl.field_msgSvrId));
      localIntent.putExtra("preUsername", com.tencent.mm.ui.chatting.viewitems.c.a(parambl, paramView.GjM, ((com.tencent.mm.ui.chatting.c.b.d)localObject3).eWC()));
      localIntent.putExtra("preChatName", parama.getTalkerUserName());
      localIntent.putExtra("preMsgIndex", paramView.AYK);
      localObject3 = paramView.GQV;
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
      if (!bt.isNullOrNil(paramView.dxz))
      {
        localIntent.putExtra("srcUsername", paramView.dxz);
        localIntent.putExtra("srcDisplayname", paramView.dxA);
        localIntent.putExtra("mode", 1);
      }
      localIntent.putExtra("message_id", paramView.AYJ);
      localIntent.putExtra("message_index", paramView.AYK);
      localIntent.putExtra("from_scence", 1);
      localIntent.putExtra("start_activity_time", l);
      localIntent.putExtra(e.m.FIt, paramView.GQX);
      com.tencent.mm.ui.chatting.viewitems.c.t(localIntent, parama.getTalkerUserName());
      localIntent.addFlags(536870912);
      i = parama.GzJ.getContext().getIntent().getIntExtra("KOpenArticleSceneFromScene", 10000);
      if ((((b)g.ab(b.class)).xA(2)) && (((b)g.ab(b.class)).a(parama.GzJ.getContext(), (String)localObject1, paramView.GQX, 0, i, localIntent))) {
        ad.i("MicroMsg.WebViewClickListener", "jump to TmplWebview");
      }
      for (;;)
      {
        if (!bt.isNullOrNil(parama.getTalkerUserName()))
        {
          az.arV();
          if (com.tencent.mm.model.c.apM().aHY(parama.getTalkerUserName()).evH == 1)
          {
            az.arV();
            com.tencent.mm.model.c.apR().aIs(parama.getTalkerUserName());
          }
        }
        if ((parambl == null) || (!parambl.eJL())) {
          break label1098;
        }
        localObject1 = ((com.tencent.mm.plugin.biz.a.a)g.ab(com.tencent.mm.plugin.biz.a.a.class)).a(parambl.field_msgId, parambl.field_content);
        if ((localObject1 != null) && (((com.tencent.mm.ai.u)localObject1).gKs != null) && (((com.tencent.mm.ai.u)localObject1).gKs.size() > paramView.AYK)) {
          break;
        }
        AppMethodBeat.o(34608);
        return;
        localIntent.putExtra("rawUrl", (String)localObject1);
        com.tencent.mm.bs.d.b(parama.GzJ.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
      }
      i = 0;
      paramView = (v)((com.tencent.mm.ai.u)localObject1).gKs.get(paramView.AYK);
      if (!bt.isNullOrNil(paramView.url)) {}
      for (;;)
      {
        try
        {
          paramView = Uri.parse(paramView.url);
          l = bt.getLong(paramView.getQueryParameter("mid"), 0L);
          int m;
          label1098:
          l = 0L;
        }
        catch (UnsupportedOperationException paramView)
        {
          try
          {
            j = bt.getInt(paramView.getQueryParameter("idx"), 0);
            i = j;
            j = parama.GzJ.getIntExtra("specific_chat_from_scene", 0);
            m = com.tencent.mm.storage.u.getSessionId();
            h.vKh.f(16243, new Object[] { parambl.field_talker, Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(m), Integer.valueOf(2), Integer.valueOf(k), Integer.valueOf(m.Xx()) });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.s.p
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.u;
import com.tencent.mm.ah.v;
import com.tencent.mm.al.l;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.bc;
import com.tencent.mm.plugin.brandservice.a.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.y;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.viewitems.ai.b;
import com.tencent.mm.ui.chatting.viewitems.bk;
import com.tencent.mm.ui.e.m;
import java.util.LinkedList;
import java.util.Map;

public final class t$p
  extends t.e
{
  public t$p(com.tencent.mm.ui.chatting.e.a parama)
  {
    super(parama);
  }
  
  public final void a(View paramView, com.tencent.mm.ui.chatting.e.a parama, bv parambv)
  {
    AppMethodBeat.i(34608);
    paramView = (bk)paramView.getTag();
    int j = 0;
    long l = System.currentTimeMillis();
    int k = (int)(l / 1000L);
    ae.i("MicroMsg.WebViewClickListener", "WebViewClickListener onClick = %d", new Object[] { Integer.valueOf(k) });
    if (e.a(paramView.dPb, parama.Kkd.getContext(), null, parama.getTalkerUserName()))
    {
      AppMethodBeat.o(34608);
      return;
    }
    Object localObject1 = paramView.userName;
    Object localObject2 = paramView.KDP;
    if ((localObject1 == null) || (((String)localObject1).equals("")))
    {
      AppMethodBeat.o(34608);
      return;
    }
    localObject1 = m.d((String)localObject1, 0, parama.Kkd.getIntExtra("KOpenArticleSceneFromScene", 10000), k);
    Intent localIntent = new Intent();
    localIntent.putExtra("rawUrl", (String)localObject1);
    localIntent.putExtra("shortUrl", (String)localObject1);
    localIntent.putExtra("webpageTitle", (String)localObject2);
    localObject2 = new Bundle();
    int i;
    if (parambv != null)
    {
      if (parambv.fvC())
      {
        localObject3 = bx.M(parambv.field_content, "msg");
        if (localObject3 != null)
        {
          localObject3 = ai.b.cc((Map)localObject3);
          if (!bu.isNullOrNil(((ai.b)localObject3).hDH))
          {
            localIntent.putExtra("KTemplateId", ((ai.b)localObject3).hDH);
            ae.d("MicroMsg.WebViewClickListener", "report template msg click action, templateId(%s). srcUsername(%s)", new Object[] { ((ai.b)localObject3).hDH, paramView.dIt });
            com.tencent.mm.plugin.report.service.g.yxI.f(11608, new Object[] { ((ai.b)localObject3).hDH, paramView.dIt, Integer.valueOf(0) });
          }
        }
      }
      bc.aCg();
      Object localObject3 = com.tencent.mm.model.c.azF().BH(parambv.field_talker);
      i = j;
      if (localObject3 != null)
      {
        i = j;
        if (((an)localObject3).fug())
        {
          i = 4;
          ae.d("MicroMsg.WebViewClickListener", "hakon click biz msg %s", new Object[] { ((aw)localObject3).field_username });
          localIntent.putExtra("geta8key_scene", 7);
        }
      }
      localIntent.putExtra("msg_id", parambv.field_msgId);
      localIntent.putExtra("KPublisherId", "msg_" + Long.toString(parambv.field_msgSvrId));
      localIntent.putExtra("pre_username", parambv.field_talker);
      localObject3 = (com.tencent.mm.ui.chatting.d.b.d)parama.bh(com.tencent.mm.ui.chatting.d.b.d.class);
      localIntent.putExtra("prePublishId", "msg_" + Long.toString(parambv.field_msgSvrId));
      localIntent.putExtra("preUsername", com.tencent.mm.ui.chatting.viewitems.c.a(parambv, paramView.JSi, ((com.tencent.mm.ui.chatting.d.b.d)localObject3).fGJ()));
      localIntent.putExtra("preChatName", parama.getTalkerUserName());
      localIntent.putExtra("preMsgIndex", paramView.EmA);
      localObject3 = paramView.KDU;
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
      if (!bu.isNullOrNil(paramView.dIt))
      {
        localIntent.putExtra("srcUsername", paramView.dIt);
        localIntent.putExtra("srcDisplayname", paramView.dIu);
        localIntent.putExtra("mode", 1);
      }
      localIntent.putExtra("message_id", paramView.Emz);
      localIntent.putExtra("message_index", paramView.EmA);
      localIntent.putExtra("from_scence", 1);
      localIntent.putExtra("start_activity_time", l);
      localIntent.putExtra(e.m.Jpz, paramView.KDW);
      com.tencent.mm.ui.chatting.viewitems.c.t(localIntent, parama.getTalkerUserName());
      localIntent.addFlags(536870912);
      i = parama.Kkd.getContext().getIntent().getIntExtra("KOpenArticleSceneFromScene", 10000);
      if ((((b)com.tencent.mm.kernel.g.ab(b.class)).zl(2)) && (((b)com.tencent.mm.kernel.g.ab(b.class)).a(parama.Kkd.getContext(), (String)localObject1, paramView.KDW, 0, i, localIntent))) {
        ae.i("MicroMsg.WebViewClickListener", "jump to TmplWebview");
      }
      for (;;)
      {
        if (!bu.isNullOrNil(parama.getTalkerUserName()))
        {
          bc.aCg();
          if (com.tencent.mm.model.c.azF().BH(parama.getTalkerUserName()).eRn == 1)
          {
            bc.aCg();
            com.tencent.mm.model.c.azL().aVf(parama.getTalkerUserName());
          }
        }
        if ((parambv == null) || (!parambv.fta())) {
          break label1102;
        }
        localObject1 = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).a(parambv.field_msgId, parambv.field_content);
        if ((localObject1 != null) && (((u)localObject1).hFT != null) && (((u)localObject1).hFT.size() > paramView.EmA)) {
          break;
        }
        AppMethodBeat.o(34608);
        return;
        localIntent.putExtra("rawUrl", (String)localObject1);
        com.tencent.mm.br.d.b(parama.Kkd.getContext(), "webview", ".ui.tools.WebViewUI", localIntent);
      }
      i = 0;
      paramView = (v)((u)localObject1).hFT.get(paramView.EmA);
      if (!bu.isNullOrNil(paramView.url)) {}
      for (;;)
      {
        try
        {
          paramView = Uri.parse(paramView.url);
          l = bu.getLong(paramView.getQueryParameter("mid"), 0L);
          int m;
          label1102:
          l = 0L;
        }
        catch (UnsupportedOperationException paramView)
        {
          try
          {
            j = bu.getInt(paramView.getQueryParameter("idx"), 0);
            i = j;
            j = parama.Kkd.getIntExtra("specific_chat_from_scene", 0);
            m = y.getSessionId();
            com.tencent.mm.plugin.report.service.g.yxI.f(16243, new Object[] { parambv.field_talker, Long.valueOf(l), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(m), Integer.valueOf(2), Integer.valueOf(k), Integer.valueOf(m.abf()) });
            l.I(parambv);
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
          ae.w("MicroMsg.WebViewClickListener", "Report 16243 exp %s", new Object[] { paramView.getMessage() });
        }
        catch (Exception paramView)
        {
          l = 0L;
          ae.w("MicroMsg.WebViewClickListener", "Report 16243 exp %s", new Object[] { paramView.getMessage() });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.t.p
 * JD-Core Version:    0.7.0.1
 */
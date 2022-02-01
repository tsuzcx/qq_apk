package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.br;
import com.tencent.mm.modelimage.j;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.appbrand.service.t;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.u;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.v.e;

final class aj$d
  extends v.e
{
  private c chattingItem;
  
  public aj$d(com.tencent.mm.ui.chatting.d.a parama, c paramc)
  {
    super(parama);
    this.chattingItem = paramc;
  }
  
  public final void a(View paramView, com.tencent.mm.ui.chatting.d.a parama, cc paramcc)
  {
    AppMethodBeat.i(37080);
    ((com.tencent.mm.plugin.comm.a.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.comm.a.c.class)).amp(paramcc.field_talker);
    k.b localb = k.b.Hf(br.a(parama.juG(), paramcc.field_content, paramcc.field_isSend));
    if (localb == null)
    {
      Log.w("MicroMsg.WeishiVideoClickListener", "weishi chatItemClick, content is null");
      AppMethodBeat.o(37080);
      return;
    }
    if ((Util.isNullOrNil(localb.nTE)) && (Util.isNullOrNil(localb.nTD)))
    {
      paramcc = new Intent();
      str1 = localb.url;
      if (parama.juG()) {}
      for (paramView = "groupmessage";; paramView = "singlemessage")
      {
        paramcc.putExtra("rawUrl", u.ab(str1, paramView));
        paramcc.putExtra("webpageTitle", localb.title);
        paramcc.putExtra("shortUrl", localb.url);
        com.tencent.mm.br.c.b(parama.aezO.getContext(), "webview", ".ui.tools.WebViewUI", paramcc);
        AppMethodBeat.o(37080);
        return;
      }
    }
    String str1 = parama.getTalkerUserName();
    String str2 = this.chattingItem.a(parama, paramcc);
    Bundle localBundle = new Bundle();
    int i;
    label307:
    boolean bool;
    if (parama.juG())
    {
      i = 2;
      localBundle.putInt("stat_scene", i);
      localBundle.putString("stat_msg_id", "msg_" + Long.toString(paramcc.field_msgSvrId));
      localBundle.putString("stat_chat_talker_username", str1);
      localBundle.putString("stat_send_msg_user", str2);
      paramView = com.tencent.mm.pluginsdk.model.app.h.is(localb.appId, localb.appVersion);
      if ((paramView != null) && (paramView.field_appName != null) && (paramView.field_appName.trim().length() > 0)) {
        break label537;
      }
      paramView = localb.appName;
      localBundle.putString("stat_weishi_app_name", paramView);
      localBundle.putString("stat_weishi_app_id", localb.appId);
      localBundle.putString("stat_weishi_source_username", localb.iaa);
      paramView = (com.tencent.mm.message.a)localb.aK(com.tencent.mm.message.a.class);
      if ((paramView == null) || (paramView.nPf != 1)) {
        break label545;
      }
      bool = true;
      label365:
      localBundle.putBoolean("stat_weishi_from_opensdk", bool);
      localBundle.putString("stat_weishi_msg_img_path", paramcc.field_imgPath);
      localBundle.putString("stat_weishi_thumb_path", r.bKa().d(paramcc.field_imgPath, false, true));
      if (paramView == null) {
        break label551;
      }
    }
    label537:
    label545:
    label551:
    for (paramView = paramView.appThumbUrl;; paramView = null)
    {
      localBundle.putString("stat_weishi_thumb_url", paramView);
      com.tencent.mm.plugin.report.service.h.OAn.b(16979, new Object[] { localb.nTE, localb.nTC, Integer.valueOf(0), Integer.valueOf(1) });
      com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1129L, 0L, 1L, false);
      ((t)com.tencent.mm.kernel.h.ax(t.class)).b(parama.aezO.getContext(), str1, str2, parama.juG(), localb, localBundle);
      AppMethodBeat.o(37080);
      return;
      if (ab.IS(str1))
      {
        i = 7;
        break;
      }
      i = 1;
      break;
      paramView = paramView.field_appName;
      break label307;
      bool = false;
      break label365;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.aj.d
 * JD-Core Version:    0.7.0.1
 */
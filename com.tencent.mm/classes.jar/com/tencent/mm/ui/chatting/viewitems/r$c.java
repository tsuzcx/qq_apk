package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.at.o;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.appbrand.service.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.s.e;

final class r$c
  extends s.e
{
  private c zRE;
  
  public r$c(com.tencent.mm.ui.chatting.d.a parama, c paramc)
  {
    super(parama);
    this.zRE = paramc;
  }
  
  public final void a(View paramView, com.tencent.mm.ui.chatting.d.a parama, bi parambi)
  {
    AppMethodBeat.i(33018);
    j.b localb = j.b.mY(bf.b(parama.dJG(), parambi.field_content, parambi.field_isSend));
    if (localb == null)
    {
      ab.w("MicroMsg.WeishiVideoClickListener", "weishi chatItemClick, content is null");
      AppMethodBeat.o(33018);
      return;
    }
    if ((bo.isNullOrNil(localb.fiY)) && (bo.isNullOrNil(localb.fiX)))
    {
      parambi = new Intent();
      str1 = localb.url;
      if (parama.dJG()) {}
      for (paramView = "groupmessage";; paramView = "singlemessage")
      {
        parambi.putExtra("rawUrl", p.H(str1, paramView));
        parambi.putExtra("webpageTitle", localb.title);
        parambi.putExtra("shortUrl", localb.url);
        d.b(parama.zJz.getContext(), "webview", ".ui.tools.WebViewUI", parambi);
        AppMethodBeat.o(33018);
        return;
      }
    }
    String str1 = parama.getTalkerUserName();
    String str2 = this.zRE.b(parama, parambi);
    Bundle localBundle = new Bundle();
    int i;
    label290:
    boolean bool;
    if (parama.dJG())
    {
      i = 2;
      localBundle.putInt("stat_scene", i);
      localBundle.putString("stat_msg_id", "msg_" + Long.toString(parambi.field_msgSvrId));
      localBundle.putString("stat_chat_talker_username", str1);
      localBundle.putString("stat_send_msg_user", str2);
      paramView = com.tencent.mm.pluginsdk.model.app.g.em(localb.appId, localb.bDc);
      if ((paramView != null) && (paramView.field_appName != null) && (paramView.field_appName.trim().length() > 0)) {
        break label535;
      }
      paramView = localb.appName;
      localBundle.putString("stat_weishi_app_name", paramView);
      localBundle.putString("stat_app_id", localb.appId);
      localBundle.putString("stat_weishi_source_username", localb.cGN);
      paramView = (com.tencent.mm.af.a)localb.R(com.tencent.mm.af.a.class);
      if ((paramView == null) || (paramView.fft != 1)) {
        break label543;
      }
      bool = true;
      label348:
      localBundle.putBoolean("stat_weishi_from_opensdk", bool);
      localBundle.putString("stat_weishi_msg_img_path", parambi.field_imgPath);
      localBundle.putString("stat_weishi_thumb_path", o.ahC().c(parambi.field_imgPath, false, true));
      if (paramView == null) {
        break label549;
      }
    }
    label535:
    label543:
    label549:
    for (paramView = paramView.appThumbUrl;; paramView = null)
    {
      localBundle.putString("stat_weishi_thumb_url", paramView);
      h.qsU.e(16979, new Object[] { localb.fiY, localb.fiW, Integer.valueOf(0), Integer.valueOf(1) });
      ab.i("MicroMsg.WeishiVideoClickListener", "weishi chatItemClick, appbrandAppId:%s, appBrandUsername:%s", new Object[] { localb.fiY, localb.fiX });
      ((j)com.tencent.mm.kernel.g.E(j.class)).a(parama.zJz.getContext(), str1, str2, parama.dJG(), localb, localBundle);
      AppMethodBeat.o(33018);
      return;
      if (t.nU(str1))
      {
        i = 7;
        break;
      }
      i = 1;
      break;
      paramView = paramView.field_appName;
      break label290;
      bool = false;
      break label348;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.viewitems.r.c
 * JD-Core Version:    0.7.0.1
 */
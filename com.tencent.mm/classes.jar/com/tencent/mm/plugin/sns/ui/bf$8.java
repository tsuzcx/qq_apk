package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.h.a.gq;
import com.tencent.mm.h.a.nr;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.c.at;
import com.tencent.mm.protocal.c.av;
import com.tencent.mm.protocal.c.bxk;
import com.tencent.mm.protocal.c.dk;
import com.tencent.mm.protocal.c.rp;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bd;

final class bf$8
  implements View.OnClickListener
{
  bf$8(bf parambf) {}
  
  public final void onClick(View paramView)
  {
    nr localnr = null;
    Object localObject1 = this.pkg;
    int i;
    if ((paramView == null) || (!(paramView.getTag() instanceof bxk))) {
      i = 1;
    }
    while ((i != 0) || (paramView == null) || (!(paramView.getTag() instanceof bxk)))
    {
      return;
      localObject2 = ((bxk)paramView.getTag()).tNq.lsK;
      if ("wx485a97c844086dc9".equals(localObject2))
      {
        com.tencent.mm.br.d.b(paramView.getContext(), "shake", ".ui.ShakeReportUI", new Intent().putExtra("shake_music", true));
        i = 1;
      }
      else
      {
        if ("wx7fa037cc7dfabad5".equals(localObject2))
        {
          com.tencent.mm.plugin.sport.b.d.jdMethod_if(34);
          g.DQ();
          if (com.tencent.mm.n.a.gR(((j)g.r(j.class)).Fw().abl("gh_43f2581f6fd6").field_type))
          {
            localObject2 = new Intent();
            ((Intent)localObject2).putExtra("Chat_User", "gh_43f2581f6fd6");
            ((Intent)localObject2).putExtra("finish_direct", true);
            com.tencent.mm.br.d.e(((bf)localObject1).context, ".ui.chatting.ChattingUI", (Intent)localObject2);
          }
          for (;;)
          {
            i = 1;
            break;
            localObject2 = new Intent();
            ((Intent)localObject2).putExtra("Contact_User", "gh_43f2581f6fd6");
            com.tencent.mm.br.d.b(((bf)localObject1).context, "profile", ".ui.ContactInfoUI", (Intent)localObject2);
          }
        }
        if (("wx9181ed3f223e6d76".equals(localObject2)) || ("wx2fe12a395c426fcf".equals(localObject2)))
        {
          y.i("MicroMsg.TimeLineClickEvent", "hy: shake new year closed. try to go to shake TV");
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("shake_tv", true);
          com.tencent.mm.br.d.b(paramView.getContext(), "shake", ".ui.ShakeReportUI", (Intent)localObject1);
          i = 1;
        }
        else if ("wx751a1acca5688ba3".equals(localObject2))
        {
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("BaseScanUI_select_scan_mode", 5);
          if ((!com.tencent.mm.r.a.bj(((bf)localObject1).context)) && (!com.tencent.mm.r.a.bi(((bf)localObject1).context))) {
            com.tencent.mm.br.d.b(((bf)localObject1).context, "scanner", ".ui.BaseScanUI", (Intent)localObject2);
          }
          i = 1;
        }
        else if ("wxfbc915ff7c30e335".equals(localObject2))
        {
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("BaseScanUI_select_scan_mode", 1);
          if ((!com.tencent.mm.r.a.bj(((bf)localObject1).context)) && (!com.tencent.mm.r.a.bi(((bf)localObject1).context))) {
            com.tencent.mm.br.d.b(((bf)localObject1).context, "scanner", ".ui.BaseScanUI", (Intent)localObject2);
          }
          i = 1;
        }
        else if ("wx482a4001c37e2b74".equals(localObject2))
        {
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("BaseScanUI_select_scan_mode", 2);
          if ((!com.tencent.mm.r.a.bj(((bf)localObject1).context)) && (!com.tencent.mm.r.a.bi(((bf)localObject1).context))) {
            com.tencent.mm.br.d.b(((bf)localObject1).context, "scanner", ".ui.BaseScanUI", (Intent)localObject2);
          }
          i = 1;
        }
        else if ("wxaf060266bfa9a35c".equals(localObject2))
        {
          if (!com.tencent.mm.av.d.PB())
          {
            i = 1;
          }
          else
          {
            localObject2 = new Intent();
            ((Intent)localObject2).putExtra("shake_tv", true);
            com.tencent.mm.br.d.b(((bf)localObject1).context, "shake", ".ui.ShakeReportUI", (Intent)localObject2);
            i = 1;
          }
        }
        else
        {
          i = 0;
        }
      }
    }
    bxk localbxk = (bxk)paramView.getTag();
    if ((localbxk == null) || (localbxk.tNq == null))
    {
      y.e("MicroMsg.TimeLineClickEvent", "appInfo is null");
      return;
    }
    Object localObject2 = localbxk.tNq.lsK;
    String str = com.tencent.mm.plugin.sns.c.a.eUS.cs((String)localObject2);
    if ((!bk.bl(str)) && (com.tencent.mm.plugin.sns.c.a.eUS.cu((String)localObject2))) {
      if (localbxk == null)
      {
        paramView = null;
        label624:
        if (localbxk.tNr.sPI != 1) {
          break label870;
        }
        i = 2;
      }
    }
    for (;;)
    {
      localObject1 = localnr;
      if (localbxk.ouC != null)
      {
        localObject1 = localnr;
        if (localbxk.ouC.sug != null) {
          localObject1 = localbxk.ouC.sug.sua;
        }
      }
      localnr = new nr();
      localnr.bXp.context = this.pkg.context;
      localnr.bXp.scene = 4;
      localnr.bXp.bOL = ((String)localObject2);
      localnr.bXp.packageName = str;
      localnr.bXp.msgType = i;
      localnr.bXp.bRO = paramView;
      localnr.bXp.mediaTagName = ((String)localObject1);
      localnr.bXp.bXq = 5;
      localnr.bXp.bXr = 0L;
      localnr.bXp.bXs = localbxk.lsK;
      com.tencent.mm.sdk.b.a.udP.m(localnr);
      paramView = new gq();
      paramView.bOu.actionCode = 2;
      paramView.bOu.scene = 3;
      paramView.bOu.extMsg = "timeline_src=3";
      paramView.bOu.appId = ((String)localObject2);
      paramView.bOu.context = this.pkg.context;
      com.tencent.mm.sdk.b.a.udP.m(paramView);
      return;
      paramView = localbxk.hPY;
      break label624;
      label870:
      if (localbxk.tNr.sPI == 3)
      {
        i = 5;
        continue;
        paramView = this.pkg;
        paramView = com.tencent.mm.plugin.sns.c.a.eUS.f(paramView.context, (String)localObject2, "timeline");
        if ((paramView == null) || (paramView.length() == 0)) {
          break;
        }
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("rawUrl", paramView);
        ((Intent)localObject1).putExtra("shortUrl", paramView);
        ((Intent)localObject1).putExtra("useJs", true);
        ((Intent)localObject1).putExtra("type", -255);
        ((Intent)localObject1).putExtra("geta8key_scene", 2);
        com.tencent.mm.plugin.sns.c.a.eUR.j((Intent)localObject1, this.pkg.context);
        return;
      }
      i = 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.bf.8
 * JD-Core Version:    0.7.0.1
 */
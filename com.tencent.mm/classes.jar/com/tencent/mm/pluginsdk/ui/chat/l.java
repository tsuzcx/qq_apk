package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bf.e;
import com.tencent.mm.h.a.gq;
import com.tencent.mm.h.a.nr;
import com.tencent.mm.h.a.rh;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bd;

public final class l
  implements View.OnClickListener
{
  private Context context;
  
  public l(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public final void onClick(View paramView)
  {
    int j = 1;
    Object localObject = paramView.getTag();
    if ((localObject instanceof l.b))
    {
      localObject = (l.b)localObject;
      if ((localObject == null) || (paramView == null))
      {
        y.w("MicroMsg.SourceClickListener", "localAppRedirectHandle: but info or v is null");
        i = 0;
        if (i == 0)
        {
          paramView = p.f(this.context, ((l.b)localObject).appId, ((l.b)localObject).bWQ);
          localObject = new rh();
          ((rh)localObject).caR.caS = paramView;
          ((rh)localObject).caR.context = this.context;
          com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject);
        }
      }
    }
    while (!(localObject instanceof l.a)) {
      for (;;)
      {
        int i;
        return;
        if ("wx7fa037cc7dfabad5".equals(((l.b)localObject).appId))
        {
          com.tencent.mm.plugin.sport.b.d.jdMethod_if(33);
          au.Hx();
          if (com.tencent.mm.n.a.gR(c.Fw().abl("gh_43f2581f6fd6").field_type))
          {
            paramView = new Intent();
            paramView.putExtra("Chat_User", "gh_43f2581f6fd6");
            paramView.putExtra("finish_direct", true);
            com.tencent.mm.br.d.e(this.context, ".ui.chatting.ChattingUI", paramView);
            i = j;
          }
          else
          {
            paramView = new Intent();
            paramView.putExtra("Contact_User", "gh_43f2581f6fd6");
            com.tencent.mm.br.d.b(this.context, "profile", ".ui.ContactInfoUI", paramView);
            i = j;
          }
        }
        else if ("wx485a97c844086dc9".equals(((l.b)localObject).appId))
        {
          paramView = new Intent();
          paramView.putExtra("shake_music", true);
          com.tencent.mm.br.d.b(this.context, "shake", ".ui.ShakeReportUI", paramView);
          i = j;
        }
        else if ("wxfbc915ff7c30e335".equals(((l.b)localObject).appId))
        {
          i = j;
          if (!com.tencent.mm.at.b.Pe())
          {
            paramView = new Intent();
            paramView.putExtra("BaseScanUI_select_scan_mode", 1);
            i = j;
            if (!com.tencent.mm.r.a.bj(this.context))
            {
              i = j;
              if (!e.RS())
              {
                com.tencent.mm.br.d.b(this.context, "scanner", ".ui.BaseScanUI", paramView);
                i = j;
              }
            }
          }
        }
        else if ("wx482a4001c37e2b74".equals(((l.b)localObject).appId))
        {
          i = j;
          if (!com.tencent.mm.at.b.Pe())
          {
            paramView = new Intent();
            paramView.putExtra("BaseScanUI_select_scan_mode", 2);
            i = j;
            if (!com.tencent.mm.r.a.bj(this.context))
            {
              i = j;
              if (!e.RS())
              {
                com.tencent.mm.br.d.b(this.context, "scanner", ".ui.BaseScanUI", paramView);
                i = j;
              }
            }
          }
        }
        else if ("wx751a1acca5688ba3".equals(((l.b)localObject).appId))
        {
          i = j;
          if (!com.tencent.mm.at.b.Pe())
          {
            paramView = new Intent();
            paramView.putExtra("BaseScanUI_select_scan_mode", 5);
            i = j;
            if (!com.tencent.mm.r.a.bj(this.context))
            {
              i = j;
              if (!e.RS())
              {
                com.tencent.mm.br.d.b(this.context, "scanner", ".ui.BaseScanUI", paramView);
                i = j;
              }
            }
          }
        }
        else if ("wxaf060266bfa9a35c".equals(((l.b)localObject).appId))
        {
          paramView = new Intent();
          paramView.putExtra("shake_tv", true);
          com.tencent.mm.br.d.b(this.context, "shake", ".ui.ShakeReportUI", paramView);
          i = j;
        }
      }
    }
    paramView = (l.a)localObject;
    localObject = new gq();
    ((gq)localObject).bOu.actionCode = 2;
    ((gq)localObject).bOu.scene = paramView.scene;
    ((gq)localObject).bOu.extMsg = ("chatting_src=" + paramView.scene);
    ((gq)localObject).bOu.appId = paramView.appId;
    ((gq)localObject).bOu.context = this.context;
    com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject);
    localObject = new nr();
    ((nr)localObject).bXp.context = this.context;
    ((nr)localObject).bXp.scene = paramView.scene;
    ((nr)localObject).bXp.bOL = paramView.appId;
    ((nr)localObject).bXp.packageName = paramView.bwQ;
    ((nr)localObject).bXp.msgType = paramView.sgD;
    ((nr)localObject).bXp.bRO = paramView.bXl;
    ((nr)localObject).bXp.bXq = 5;
    ((nr)localObject).bXp.mediaTagName = paramView.sgE;
    ((nr)localObject).bXp.bXr = paramView.bXr;
    ((nr)localObject).bXp.bXs = "";
    com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.l
 * JD-Core Version:    0.7.0.1
 */
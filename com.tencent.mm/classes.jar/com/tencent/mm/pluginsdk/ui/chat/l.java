package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bg.e;
import com.tencent.mm.g.a.gu;
import com.tencent.mm.g.a.or;
import com.tencent.mm.g.a.st;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.ab;
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
    AppMethodBeat.i(27964);
    Object localObject = paramView.getTag();
    if ((localObject instanceof l.b))
    {
      localObject = (l.b)localObject;
      int i;
      if ((localObject == null) || (paramView == null))
      {
        ab.w("MicroMsg.SourceClickListener", "localAppRedirectHandle: but info or v is null");
        i = 0;
      }
      for (;;)
      {
        if (i == 0)
        {
          paramView = p.f(this.context, ((l.b)localObject).appId, ((l.b)localObject).cEG);
          localObject = new st();
          ((st)localObject).cJq.cJr = paramView;
          ((st)localObject).cJq.context = this.context;
          com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
        }
        AppMethodBeat.o(27964);
        return;
        if ("wx7fa037cc7dfabad5".equals(((l.b)localObject).appId))
        {
          com.tencent.mm.plugin.sport.a.d.kS(33);
          aw.aaz();
          if (com.tencent.mm.n.a.je(c.YA().arw("gh_43f2581f6fd6").field_type))
          {
            paramView = new Intent();
            paramView.putExtra("Chat_User", "gh_43f2581f6fd6");
            paramView.putExtra("finish_direct", true);
            com.tencent.mm.bq.d.f(this.context, ".ui.chatting.ChattingUI", paramView);
            i = j;
          }
          else
          {
            paramView = new Intent();
            paramView.putExtra("Contact_User", "gh_43f2581f6fd6");
            com.tencent.mm.bq.d.b(this.context, "profile", ".ui.ContactInfoUI", paramView);
            i = j;
          }
        }
        else if ("wx485a97c844086dc9".equals(((l.b)localObject).appId))
        {
          paramView = new Intent();
          paramView.putExtra("shake_music", true);
          com.tencent.mm.bq.d.b(this.context, "shake", ".ui.ShakeReportUI", paramView);
          i = j;
        }
        else if ("wxfbc915ff7c30e335".equals(((l.b)localObject).appId))
        {
          i = j;
          if (!com.tencent.mm.au.b.aig())
          {
            paramView = new Intent();
            paramView.putExtra("BaseScanUI_select_scan_mode", 1);
            i = j;
            if (!com.tencent.mm.r.a.bN(this.context))
            {
              i = j;
              if (!e.alb())
              {
                com.tencent.mm.bq.d.b(this.context, "scanner", ".ui.BaseScanUI", paramView);
                i = j;
              }
            }
          }
        }
        else if ("wx482a4001c37e2b74".equals(((l.b)localObject).appId))
        {
          i = j;
          if (!com.tencent.mm.au.b.aig())
          {
            paramView = new Intent();
            paramView.putExtra("BaseScanUI_select_scan_mode", 2);
            i = j;
            if (!com.tencent.mm.r.a.bN(this.context))
            {
              i = j;
              if (!e.alb())
              {
                com.tencent.mm.bq.d.b(this.context, "scanner", ".ui.BaseScanUI", paramView);
                i = j;
              }
            }
          }
        }
        else if ("wx751a1acca5688ba3".equals(((l.b)localObject).appId))
        {
          i = j;
          if (!com.tencent.mm.au.b.aig())
          {
            paramView = new Intent();
            paramView.putExtra("BaseScanUI_select_scan_mode", 5);
            i = j;
            if (!com.tencent.mm.r.a.bN(this.context))
            {
              i = j;
              if (!e.alb())
              {
                com.tencent.mm.bq.d.b(this.context, "scanner", ".ui.BaseScanUI", paramView);
                i = j;
              }
            }
          }
        }
        else
        {
          if (!"wxaf060266bfa9a35c".equals(((l.b)localObject).appId)) {
            break;
          }
          paramView = new Intent();
          paramView.putExtra("shake_tv", true);
          com.tencent.mm.bq.d.b(this.context, "shake", ".ui.ShakeReportUI", paramView);
          i = j;
        }
      }
    }
    if ((localObject instanceof l.a))
    {
      paramView = (l.a)localObject;
      localObject = new gu();
      ((gu)localObject).cvL.actionCode = 2;
      ((gu)localObject).cvL.scene = paramView.scene;
      ((gu)localObject).cvL.extMsg = ("chatting_src=" + paramView.scene);
      ((gu)localObject).cvL.appId = paramView.appId;
      ((gu)localObject).cvL.context = this.context;
      com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
      localObject = new or();
      ((or)localObject).cFl.context = this.context;
      ((or)localObject).cFl.scene = paramView.scene;
      ((or)localObject).cFl.cwc = paramView.appId;
      ((or)localObject).cFl.packageName = paramView.bYA;
      ((or)localObject).cFl.msgType = paramView.vYV;
      ((or)localObject).cFl.czp = paramView.cFh;
      ((or)localObject).cFl.cFm = 5;
      ((or)localObject).cFl.mediaTagName = paramView.vYW;
      ((or)localObject).cFl.cFn = paramView.cFn;
      ((or)localObject).cFl.cFo = "";
      ((or)localObject).cFl.cmF = paramView.vYX;
      com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject);
    }
    AppMethodBeat.o(27964);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.l
 * JD-Core Version:    0.7.0.1
 */
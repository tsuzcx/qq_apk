package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bi.e;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.a.ho;
import com.tencent.mm.g.a.qj;
import com.tencent.mm.g.a.uq;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.az;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.bg;

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
    AppMethodBeat.i(31760);
    Object localObject = paramView.getTag();
    if ((localObject instanceof b))
    {
      localObject = (b)localObject;
      int i;
      if ((localObject == null) || (paramView == null))
      {
        ad.w("MicroMsg.SourceClickListener", "localAppRedirectHandle: but info or v is null");
        i = 0;
      }
      for (;;)
      {
        if (i == 0)
        {
          paramView = q.e(this.context, ((b)localObject).appId, ((b)localObject).dvh);
          localObject = new uq();
          ((uq)localObject).dAk.dAl = paramView;
          ((uq)localObject).dAk.context = this.context;
          com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
        }
        AppMethodBeat.o(31760);
        return;
        if ("wx7fa037cc7dfabad5".equals(((b)localObject).appId))
        {
          com.tencent.mm.plugin.sport.a.c.lI(33);
          az.arV();
          if (com.tencent.mm.n.b.ls(com.tencent.mm.model.c.apM().aHY("gh_43f2581f6fd6").field_type))
          {
            paramView = new Intent();
            paramView.putExtra("Chat_User", "gh_43f2581f6fd6");
            paramView.putExtra("finish_direct", true);
            d.e(this.context, ".ui.chatting.ChattingUI", paramView);
            i = j;
          }
          else
          {
            paramView = new Intent();
            paramView.putExtra("Contact_User", "gh_43f2581f6fd6");
            d.b(this.context, "profile", ".ui.ContactInfoUI", paramView);
            i = j;
          }
        }
        else if ("wx485a97c844086dc9".equals(((b)localObject).appId))
        {
          paramView = new Intent();
          paramView.putExtra("shake_music", true);
          d.b(this.context, "shake", ".ui.ShakeReportUI", paramView);
          i = j;
        }
        else if ("wxfbc915ff7c30e335".equals(((b)localObject).appId))
        {
          i = j;
          if (!com.tencent.mm.ax.b.azn())
          {
            paramView = new Intent();
            paramView.putExtra("BaseScanUI_select_scan_mode", 1);
            i = j;
            if (!com.tencent.mm.r.a.cd(this.context))
            {
              i = j;
              if (!e.aCh())
              {
                d.b(this.context, "scanner", ".ui.BaseScanUI", paramView);
                i = j;
              }
            }
          }
        }
        else
        {
          if (!"wxaf060266bfa9a35c".equals(((b)localObject).appId)) {
            break;
          }
          paramView = new Intent();
          paramView.putExtra("shake_tv", true);
          d.b(this.context, "shake", ".ui.ShakeReportUI", paramView);
          i = j;
        }
      }
    }
    if ((localObject instanceof a))
    {
      paramView = (a)localObject;
      localObject = new ho();
      ((ho)localObject).dlk.actionCode = 2;
      ((ho)localObject).dlk.scene = paramView.scene;
      ((ho)localObject).dlk.extMsg = ("chatting_src=" + paramView.scene);
      ((ho)localObject).dlk.appId = paramView.appId;
      ((ho)localObject).dlk.context = this.context;
      com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
      localObject = new qj();
      ((qj)localObject).dvV.context = this.context;
      ((qj)localObject).dvV.scene = paramView.scene;
      ((qj)localObject).dvV.dlB = paramView.appId;
      ((qj)localObject).dvV.packageName = paramView.dvP;
      ((qj)localObject).dvV.msgType = paramView.Cgv;
      ((qj)localObject).dvV.dpv = paramView.dvQ;
      ((qj)localObject).dvV.dvW = 5;
      ((qj)localObject).dvV.mediaTagName = paramView.Cgw;
      ((qj)localObject).dvV.drA = paramView.drA;
      ((qj)localObject).dvV.dvX = "";
      ((qj)localObject).dvV.dbt = paramView.Cgx;
      com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject);
    }
    AppMethodBeat.o(31760);
  }
  
  public static final class a
  {
    public int Cgv;
    public String Cgw;
    public String Cgx;
    public String appId;
    public long drA;
    public String dvP;
    public String dvQ;
    public String dvh;
    public int scene;
  }
  
  public static final class b
  {
    public String appId;
    public String dvh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.l
 * JD-Core Version:    0.7.0.1
 */
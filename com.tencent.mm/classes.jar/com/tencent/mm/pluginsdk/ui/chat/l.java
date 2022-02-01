package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bh.e;
import com.tencent.mm.br.d;
import com.tencent.mm.g.a.id;
import com.tencent.mm.g.a.re;
import com.tencent.mm.g.a.vx;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.bc;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.bq;

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
    AppMethodBeat.i(31760);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/chat/SourceClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
    localObject = paramView.getTag();
    int i;
    if ((localObject instanceof b))
    {
      localObject = (b)localObject;
      if ((localObject == null) || (paramView == null))
      {
        ae.w("MicroMsg.SourceClickListener", "localAppRedirectHandle: but info or v is null");
        i = 0;
        label69:
        if (i == 0)
        {
          paramView = q.e(this.context, ((b)localObject).appId, ((b)localObject).dFY);
          localObject = new vx();
          ((vx)localObject).dLy.dLz = paramView;
          ((vx)localObject).dLy.context = this.context;
          com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
        }
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/pluginsdk/ui/chat/SourceClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(31760);
      return;
      if ("wx7fa037cc7dfabad5".equals(((b)localObject).appId))
      {
        com.tencent.mm.plugin.sport.a.c.md(33);
        bc.aCg();
        if (com.tencent.mm.contact.c.lO(com.tencent.mm.model.c.azF().BH("gh_43f2581f6fd6").field_type))
        {
          paramView = new Intent();
          paramView.putExtra("Chat_User", "gh_43f2581f6fd6");
          paramView.putExtra("finish_direct", true);
          d.f(this.context, ".ui.chatting.ChattingUI", paramView);
        }
        for (;;)
        {
          i = 1;
          break;
          paramView = new Intent();
          paramView.putExtra("Contact_User", "gh_43f2581f6fd6");
          d.b(this.context, "profile", ".ui.ContactInfoUI", paramView);
        }
      }
      if ("wx485a97c844086dc9".equals(((b)localObject).appId))
      {
        paramView = new Intent();
        paramView.putExtra("shake_music", true);
        d.b(this.context, "shake", ".ui.ShakeReportUI", paramView);
        i = 1;
        break label69;
      }
      if ("wxfbc915ff7c30e335".equals(((b)localObject).appId))
      {
        if (com.tencent.mm.aw.b.aJF())
        {
          i = 1;
          break label69;
        }
        paramView = new Intent();
        paramView.putExtra("BaseScanUI_select_scan_mode", 1);
        if ((!com.tencent.mm.r.a.n(this.context, true)) && (!e.aME()) && (!com.tencent.mm.r.a.p(this.context, true))) {
          d.b(this.context, "scanner", ".ui.BaseScanUI", paramView);
        }
        i = 1;
        break label69;
      }
      if (!"wxaf060266bfa9a35c".equals(((b)localObject).appId)) {
        break;
      }
      paramView = new Intent();
      paramView.putExtra("shake_tv", true);
      d.b(this.context, "shake", ".ui.ShakeReportUI", paramView);
      i = 1;
      break label69;
      if ((localObject instanceof a))
      {
        paramView = (a)localObject;
        localObject = new id();
        ((id)localObject).dvK.actionCode = 2;
        ((id)localObject).dvK.scene = paramView.scene;
        ((id)localObject).dvK.extMsg = ("chatting_src=" + paramView.scene);
        ((id)localObject).dvK.appId = paramView.appId;
        ((id)localObject).dvK.context = this.context;
        com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
        localObject = new re();
        ((re)localObject).dGN.context = this.context;
        ((re)localObject).dGN.scene = paramView.scene;
        ((re)localObject).dGN.dwb = paramView.appId;
        ((re)localObject).dGN.packageName = paramView.dGI;
        ((re)localObject).dGN.msgType = paramView.Fwt;
        ((re)localObject).dGN.dzZ = paramView.dGJ;
        ((re)localObject).dGN.dGO = 5;
        ((re)localObject).dGN.mediaTagName = paramView.Fwu;
        ((re)localObject).dGN.dCd = paramView.dCd;
        ((re)localObject).dGN.dGP = "";
        ((re)localObject).dGN.dlj = paramView.Fwv;
        com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject);
      }
    }
  }
  
  public static final class a
  {
    public int Fwt;
    public String Fwu;
    public String Fwv;
    public String appId;
    public long dCd;
    public String dFY;
    public String dGI;
    public String dGJ;
    public int scene;
  }
  
  public static final class b
  {
    public String appId;
    public String dFY;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.l
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bh.e;
import com.tencent.mm.g.a.is;
import com.tencent.mm.g.a.ry;
import com.tencent.mm.g.a.wx;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.bg;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bv;

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
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/pluginsdk/ui/chat/SourceClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
    localObject = paramView.getTag();
    int i;
    if ((localObject instanceof b))
    {
      localObject = (b)localObject;
      if ((localObject == null) || (paramView == null))
      {
        Log.w("MicroMsg.SourceClickListener", "localAppRedirectHandle: but info or v is null");
        i = 0;
        label69:
        if (i == 0)
        {
          paramView = q.e(this.context, ((b)localObject).appId, ((b)localObject).from);
          localObject = new wx();
          ((wx)localObject).edn.edo = paramView;
          ((wx)localObject).edn.context = this.context;
          EventCenter.instance.publish((IEvent)localObject);
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
        com.tencent.mm.plugin.sport.a.c.pl(33);
        bg.aVF();
        if (com.tencent.mm.contact.c.oR(com.tencent.mm.model.c.aSN().Kn("gh_43f2581f6fd6").field_type))
        {
          paramView = new Intent();
          paramView.putExtra("Chat_User", "gh_43f2581f6fd6");
          paramView.putExtra("finish_direct", true);
          com.tencent.mm.br.c.f(this.context, ".ui.chatting.ChattingUI", paramView);
        }
        for (;;)
        {
          i = 1;
          break;
          paramView = new Intent();
          paramView.putExtra("Contact_User", "gh_43f2581f6fd6");
          com.tencent.mm.br.c.b(this.context, "profile", ".ui.ContactInfoUI", paramView);
        }
      }
      if ("wx485a97c844086dc9".equals(((b)localObject).appId))
      {
        paramView = new Intent();
        paramView.putExtra("shake_music", true);
        com.tencent.mm.br.c.b(this.context, "shake", ".ui.ShakeReportUI", paramView);
        i = 1;
        break label69;
      }
      if ("wxfbc915ff7c30e335".equals(((b)localObject).appId))
      {
        if (com.tencent.mm.aw.b.bdG())
        {
          i = 1;
          break label69;
        }
        paramView = new Intent();
        paramView.putExtra("BaseScanUI_select_scan_mode", 1);
        if ((!com.tencent.mm.q.a.o(this.context, true)) && (!e.bgF()) && (!com.tencent.mm.q.a.r(this.context, true))) {
          com.tencent.mm.br.c.b(this.context, "scanner", ".ui.BaseScanUI", paramView);
        }
        i = 1;
        break label69;
      }
      if (!"wxaf060266bfa9a35c".equals(((b)localObject).appId)) {
        break;
      }
      paramView = new Intent();
      paramView.putExtra("shake_tv", true);
      com.tencent.mm.br.c.b(this.context, "shake", ".ui.ShakeReportUI", paramView);
      i = 1;
      break label69;
      if ((localObject instanceof a))
      {
        paramView = (a)localObject;
        localObject = new is();
        ((is)localObject).dNr.actionCode = 2;
        ((is)localObject).dNr.scene = paramView.scene;
        ((is)localObject).dNr.extMsg = ("chatting_src=" + paramView.scene);
        ((is)localObject).dNr.appId = paramView.appId;
        ((is)localObject).dNr.context = this.context;
        EventCenter.instance.publish((IEvent)localObject);
        localObject = new ry();
        ((ry)localObject).dYw.context = this.context;
        ((ry)localObject).dYw.scene = paramView.scene;
        ((ry)localObject).dYw.dNI = paramView.appId;
        ((ry)localObject).dYw.packageName = paramView.pkgName;
        ((ry)localObject).dYw.msgType = paramView.Kno;
        ((ry)localObject).dYw.dRL = paramView.dYs;
        ((ry)localObject).dYw.dYx = 5;
        ((ry)localObject).dYw.mediaTagName = paramView.Knp;
        ((ry)localObject).dYw.dTS = paramView.dTS;
        ((ry)localObject).dYw.dYy = "";
        ((ry)localObject).dYw.dCw = paramView.Knq;
        EventCenter.instance.publish((IEvent)localObject);
      }
    }
  }
  
  public static final class a
  {
    public int Kno;
    public String Knp;
    public String Knq;
    public String appId;
    public long dTS;
    public String dYs;
    public String from;
    public String pkgName;
    public int scene;
  }
  
  public static final class b
  {
    public String appId;
    public String from;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.l
 * JD-Core Version:    0.7.0.1
 */
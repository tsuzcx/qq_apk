package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.kj;
import com.tencent.mm.autogen.a.un;
import com.tencent.mm.autogen.a.zw;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.bc.e;
import com.tencent.mm.model.bh;
import com.tencent.mm.pluginsdk.model.app.u;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.bx;

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
    ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/chat/SourceClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
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
          paramView = u.i(this.context, ((b)localObject).appId, ((b)localObject).from);
          localObject = new zw();
          ((zw)localObject).idt.idu = paramView;
          ((zw)localObject).idt.context = this.context;
          ((zw)localObject).publish();
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
        com.tencent.mm.plugin.sport.a.d.rG(33);
        bh.bCz();
        if (com.tencent.mm.contact.d.rs(com.tencent.mm.model.c.bzA().JE("gh_43f2581f6fd6").field_type))
        {
          paramView = new Intent();
          paramView.putExtra("Chat_User", "gh_43f2581f6fd6");
          paramView.putExtra("finish_direct", true);
          com.tencent.mm.br.c.g(this.context, ".ui.chatting.ChattingUI", paramView);
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
        paramView.putExtra("enter_from_scene", 3);
        com.tencent.mm.br.c.b(this.context, "shake", ".ui.ShakeReportUI", paramView);
        i = 1;
        break label69;
      }
      if ("wxfbc915ff7c30e335".equals(((b)localObject).appId))
      {
        if (com.tencent.mm.au.b.bKM())
        {
          i = 1;
          break label69;
        }
        paramView = new Intent();
        paramView.putExtra("BaseScanUI_select_scan_mode", 1);
        if ((!com.tencent.mm.n.a.p(this.context, true)) && (!e.bNA()) && (!com.tencent.mm.n.a.u(this.context, true))) {
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
      paramView.putExtra("enter_from_scene", 3);
      com.tencent.mm.br.c.b(this.context, "shake", ".ui.ShakeReportUI", paramView);
      i = 1;
      break label69;
      if ((localObject instanceof a))
      {
        paramView = (a)localObject;
        localObject = new kj();
        ((kj)localObject).hLZ.actionCode = 2;
        ((kj)localObject).hLZ.scene = paramView.scene;
        ((kj)localObject).hLZ.extMsg = ("chatting_src=" + paramView.scene);
        ((kj)localObject).hLZ.appId = paramView.appId;
        ((kj)localObject).hLZ.context = this.context;
        ((kj)localObject).publish();
        localObject = new un();
        ((un)localObject).hYk.context = this.context;
        ((un)localObject).hYk.scene = paramView.scene;
        ((un)localObject).hYk.appid = paramView.appId;
        ((un)localObject).hYk.packageName = paramView.pkgName;
        ((un)localObject).hYk.msgType = paramView.Ykr;
        ((un)localObject).hYk.hQQ = paramView.hYg;
        ((un)localObject).hYk.hYl = 5;
        ((un)localObject).hYk.mediaTagName = paramView.Yks;
        ((un)localObject).hYk.hTh = paramView.hTh;
        ((un)localObject).hYk.hYm = "";
        ((un)localObject).hYk.hzx = paramView.Ykt;
        ((un)localObject).publish();
      }
    }
  }
  
  public static final class a
  {
    public int Ykr;
    public String Yks;
    public String Ykt;
    public String appId;
    public String from;
    public long hTh;
    public String hYg;
    public String pkgName;
    public int scene;
  }
  
  public static final class b
  {
    public String appId;
    public String from;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.l
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bj.e;
import com.tencent.mm.f.a.ji;
import com.tencent.mm.f.a.sy;
import com.tencent.mm.f.a.yd;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.bh;
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
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/pluginsdk/ui/chat/SourceClickListener", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
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
          localObject = new yd();
          ((yd)localObject).fXt.fXu = paramView;
          ((yd)localObject).fXt.context = this.context;
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
        com.tencent.mm.plugin.sport.a.d.rE(33);
        bh.beI();
        if (com.tencent.mm.contact.d.rk(com.tencent.mm.model.c.bbL().RG("gh_43f2581f6fd6").field_type))
        {
          paramView = new Intent();
          paramView.putExtra("Chat_User", "gh_43f2581f6fd6");
          paramView.putExtra("finish_direct", true);
          com.tencent.mm.by.c.f(this.context, ".ui.chatting.ChattingUI", paramView);
        }
        for (;;)
        {
          i = 1;
          break;
          paramView = new Intent();
          paramView.putExtra("Contact_User", "gh_43f2581f6fd6");
          com.tencent.mm.by.c.b(this.context, "profile", ".ui.ContactInfoUI", paramView);
        }
      }
      if ("wx485a97c844086dc9".equals(((b)localObject).appId))
      {
        paramView = new Intent();
        paramView.putExtra("shake_music", true);
        com.tencent.mm.by.c.b(this.context, "shake", ".ui.ShakeReportUI", paramView);
        i = 1;
        break label69;
      }
      if ("wxfbc915ff7c30e335".equals(((b)localObject).appId))
      {
        if (com.tencent.mm.az.b.bna())
        {
          i = 1;
          break label69;
        }
        paramView = new Intent();
        paramView.putExtra("BaseScanUI_select_scan_mode", 1);
        if ((!com.tencent.mm.q.a.p(this.context, true)) && (!e.bpU()) && (!com.tencent.mm.q.a.t(this.context, true))) {
          com.tencent.mm.by.c.b(this.context, "scanner", ".ui.BaseScanUI", paramView);
        }
        i = 1;
        break label69;
      }
      if (!"wxaf060266bfa9a35c".equals(((b)localObject).appId)) {
        break;
      }
      paramView = new Intent();
      paramView.putExtra("shake_tv", true);
      com.tencent.mm.by.c.b(this.context, "shake", ".ui.ShakeReportUI", paramView);
      i = 1;
      break label69;
      if ((localObject instanceof a))
      {
        paramView = (a)localObject;
        localObject = new ji();
        ((ji)localObject).fGD.actionCode = 2;
        ((ji)localObject).fGD.scene = paramView.scene;
        ((ji)localObject).fGD.extMsg = ("chatting_src=" + paramView.scene);
        ((ji)localObject).fGD.appId = paramView.appId;
        ((ji)localObject).fGD.context = this.context;
        EventCenter.instance.publish((IEvent)localObject);
        localObject = new sy();
        ((sy)localObject).fSn.context = this.context;
        ((sy)localObject).fSn.scene = paramView.scene;
        ((sy)localObject).fSn.appid = paramView.appId;
        ((sy)localObject).fSn.packageName = paramView.pkgName;
        ((sy)localObject).fSn.msgType = paramView.Roa;
        ((sy)localObject).fSn.fLi = paramView.fSj;
        ((sy)localObject).fSn.fSo = 5;
        ((sy)localObject).fSn.mediaTagName = paramView.Rob;
        ((sy)localObject).fSn.fNu = paramView.fNu;
        ((sy)localObject).fSn.fSp = "";
        ((sy)localObject).fSn.fvd = paramView.Roc;
        EventCenter.instance.publish((IEvent)localObject);
      }
    }
  }
  
  public static final class a
  {
    public int Roa;
    public String Rob;
    public String Roc;
    public String appId;
    public long fNu;
    public String fSj;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.l
 * JD-Core Version:    0.7.0.1
 */